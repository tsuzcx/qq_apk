package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.d;
import com.tencent.mm.vfs.e;

public class f
{
  public static f lfM;
  public boolean isRunning = false;
  private String key;
  
  private static boolean a(EmojiInfo paramEmojiInfo, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(139670);
    String str;
    if (r.bX(paramArrayOfByte))
    {
      str = paramEmojiInfo.field_externMd5;
      paramArrayOfByte = ag.v(paramArrayOfByte);
      if ((bo.isNullOrNil(str)) || (bo.isNullOrNil(paramArrayOfByte)) || (!bo.isEqual(str, paramArrayOfByte))) {
        break label83;
      }
    }
    label83:
    for (boolean bool = true;; bool = false)
    {
      if (!bool) {
        ab.w("MicroMsg.emoji.EmojiFileEncryptMgr", "checkFileMd5: %s", new Object[] { paramEmojiInfo.field_md5 });
      }
      AppMethodBeat.o(139670);
      return bool;
      str = paramEmojiInfo.field_md5;
      break;
    }
  }
  
  public static f bkQ()
  {
    AppMethodBeat.i(52865);
    if (lfM == null) {}
    try
    {
      lfM = new f();
      f localf = lfM;
      AppMethodBeat.o(52865);
      return localf;
    }
    finally
    {
      AppMethodBeat.o(52865);
    }
  }
  
  private String bkR()
  {
    AppMethodBeat.i(52866);
    if (bo.isNullOrNil(this.key)) {
      this.key = i.getEmojiStorageMgr().yNn.getKey();
    }
    String str = this.key;
    AppMethodBeat.o(52866);
    return str;
  }
  
  public final boolean c(EmojiInfo paramEmojiInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(52868);
    if (paramEmojiInfo == null)
    {
      ab.w("MicroMsg.emoji.EmojiFileEncryptMgr", "encodeEmojiFile failed. emoji is null.");
      AppMethodBeat.o(52868);
      return false;
    }
    if (!isEnable())
    {
      ab.i("MicroMsg.emoji.EmojiFileEncryptMgr", "disable encrypt");
      AppMethodBeat.o(52868);
      return false;
    }
    String str = paramEmojiInfo.dQB();
    Object localObject;
    boolean bool1;
    if (e.cN(str))
    {
      boolean bool2 = false;
      localObject = e.i(str, 0, 10);
      bool1 = bool2;
      if (localObject != null) {
        bool1 = bool2;
      }
    }
    for (;;)
    {
      try
      {
        if (localObject.length >= 10) {
          bool1 = r.bW((byte[])localObject);
        }
        if ((paramBoolean) || (bool1))
        {
          long l = System.currentTimeMillis();
          j = (int)e.avI(str);
          byte[] arrayOfByte2;
          byte[] arrayOfByte1;
          if (j > 1024)
          {
            i = 1024;
            arrayOfByte2 = e.i(str, 0, j);
            arrayOfByte1 = e.i(str, 0, i);
            localObject = new byte[0];
          }
          try
          {
            arrayOfByte1 = AesEcb.aesCryptEcb(arrayOfByte1, bkR().getBytes(), true, false);
            localObject = arrayOfByte1;
          }
          catch (Throwable localThrowable2)
          {
            ab.printErrStackTrace("MicroMsg.emoji.EmojiFileEncryptMgr", localThrowable2, "", new Object[0]);
            continue;
            ab.w("MicroMsg.emoji.EmojiFileEncryptMgr", "encodeEmojiFile failed. write file failed.");
            h.qsU.idkeyStat(252L, 3L, 1L, false);
            AppMethodBeat.o(52868);
            return false;
          }
          if ((localObject == null) || (localObject.length < i) || (arrayOfByte2 == null) || (arrayOfByte2.length < i)) {
            break label451;
          }
          System.arraycopy(localObject, 0, arrayOfByte2, 0, i);
          i = e.b(str, arrayOfByte2, arrayOfByte2.length);
          if (i == 0)
          {
            l = System.currentTimeMillis() - l;
            h.qsU.idkeyStat(252L, 1L, l, false);
            h.qsU.idkeyStat(252L, 6L, 1L, false);
            paramEmojiInfo.field_reserved4 |= EmojiInfo.APx;
            paramEmojiInfo.field_size = j;
            i.getEmojiStorageMgr().yNn.K(paramEmojiInfo);
            ab.i("MicroMsg.emoji.EmojiFileEncryptMgr", "encode emoji file length:%d use time:%d", new Object[] { Integer.valueOf(arrayOfByte2.length), Long.valueOf(l) });
            AppMethodBeat.o(52868);
            return true;
          }
        }
      }
      catch (Throwable localThrowable1)
      {
        int j;
        ab.printErrStackTrace("MicroMsg.emoji.EmojiFileEncryptMgr", localThrowable1, "", new Object[0]);
        bool1 = false;
        continue;
        i = j;
        continue;
      }
      ab.i("MicroMsg.emoji.EmojiFileEncryptMgr", "encodeEmojiFile file had encrypt.");
      AppMethodBeat.o(52868);
      return true;
      ab.w("MicroMsg.emoji.EmojiFileEncryptMgr", "encodeEmojiFile failed. file not exist. path%s", new Object[] { str });
      paramEmojiInfo.field_reserved4 = 0;
      i.getEmojiStorageMgr().yNn.K(paramEmojiInfo);
      AppMethodBeat.o(52868);
      return false;
      label451:
      int i = -1;
    }
  }
  
  public final boolean isEnable()
  {
    AppMethodBeat.i(52867);
    if (bo.isNullOrNil(bkR()))
    {
      AppMethodBeat.o(52867);
      return false;
    }
    AppMethodBeat.o(52867);
    return true;
  }
  
  public final byte[] l(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(52869);
    if (paramEmojiInfo == null)
    {
      ab.w("MicroMsg.emoji.EmojiFileEncryptMgr", "decodeEmojiData failed. emoji is null.");
      AppMethodBeat.o(52869);
      return null;
    }
    String str = paramEmojiInfo.dQB();
    byte[] arrayOfByte1 = e.i(str, 0, -1);
    if ((e.avI(str) > 0L) && (arrayOfByte1 != null) && (arrayOfByte1.length >= 10))
    {
      Object localObject1 = new byte[10];
      System.arraycopy(arrayOfByte1, 0, localObject1, 0, 10);
      if (((paramEmojiInfo.field_reserved4 & EmojiInfo.APx) == EmojiInfo.APx) && (!r.bW((byte[])localObject1)))
      {
        long l = System.currentTimeMillis();
        int j = (int)e.avI(str);
        int i = j;
        if (j > 1024) {
          i = 1024;
        }
        byte[] arrayOfByte2 = e.i(str, 0, i);
        Object localObject3 = null;
        localObject1 = localObject3;
        if (!bo.isNullOrNil(bkR())) {}
        try
        {
          localObject1 = AesEcb.aesCryptEcb(arrayOfByte2, bkR().getBytes(), false, false);
          if ((!bo.ce((byte[])localObject1)) && (!bo.ce(arrayOfByte1)))
          {
            System.arraycopy(localObject1, 0, arrayOfByte1, 0, i);
            l = System.currentTimeMillis() - l;
            h.qsU.idkeyStat(252L, 0L, l, false);
            h.qsU.idkeyStat(252L, 5L, 1L, false);
            ab.d("MicroMsg.emoji.EmojiFileEncryptMgr", "decode emoji file length:%d use time:%d", new Object[] { Integer.valueOf(arrayOfByte1.length), Long.valueOf(l) });
            if (!a(paramEmojiInfo, arrayOfByte1)) {
              break label382;
            }
            AppMethodBeat.o(52869);
            return arrayOfByte1;
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            ab.printErrStackTrace("MicroMsg.emoji.EmojiFileEncryptMgr", localThrowable, "", new Object[0]);
            Object localObject2 = localObject3;
          }
          h.qsU.idkeyStat(252L, 2L, 1L, false);
          ab.i("MicroMsg.emoji.EmojiFileEncryptMgr", "decode emoji file failed. path:%s return original ", new Object[] { str });
          if (!a(paramEmojiInfo, arrayOfByte1)) {
            break label382;
          }
        }
        AppMethodBeat.o(52869);
        return arrayOfByte1;
      }
      else if (a(paramEmojiInfo, arrayOfByte1))
      {
        AppMethodBeat.o(52869);
        return arrayOfByte1;
      }
    }
    else
    {
      ab.i("MicroMsg.emoji.EmojiFileEncryptMgr", "decode emoji file failed. path is no exist :%s ", new Object[] { str });
      AppMethodBeat.o(52869);
      return null;
    }
    label382:
    AppMethodBeat.o(52869);
    return null;
  }
  
  public final boolean m(EmojiInfo paramEmojiInfo)
  {
    int i = 1024;
    AppMethodBeat.i(52870);
    if (paramEmojiInfo == null)
    {
      ab.w("MicroMsg.emoji.EmojiFileEncryptMgr", "decodeEmojiData failed. emoji is null.");
      AppMethodBeat.o(52870);
      return false;
    }
    long l = System.currentTimeMillis();
    Object localObject = paramEmojiInfo.dQB();
    int j = (int)e.avI((String)localObject);
    byte[] arrayOfByte;
    if (j > 1024)
    {
      arrayOfByte = e.i((String)localObject, 0, i);
      if ((e.avI((String)localObject) <= 0L) || (arrayOfByte == null) || (arrayOfByte.length < 10)) {
        break label240;
      }
      localObject = new byte[10];
      System.arraycopy(arrayOfByte, 0, localObject, 0, 10);
      if (!r.bW((byte[])localObject)) {
        break label156;
      }
    }
    label156:
    label240:
    for (boolean bool = true;; bool = false) {
      for (;;)
      {
        ab.d("MicroMsg.emoji.EmojiFileEncryptMgr", "checkout use time:%s result:%b", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Boolean.valueOf(bool) });
        AppMethodBeat.o(52870);
        return bool;
        i = j;
        break;
        if ((paramEmojiInfo.field_reserved4 & EmojiInfo.APx) == EmojiInfo.APx)
        {
          localObject = null;
          paramEmojiInfo = (EmojiInfo)localObject;
          if (!bo.isNullOrNil(bkR())) {}
          try
          {
            paramEmojiInfo = AesEcb.aesCryptEcb(arrayOfByte, bkR().getBytes(), false, false);
            if ((!bo.ce(paramEmojiInfo)) && (r.bW(paramEmojiInfo))) {
              bool = true;
            }
          }
          catch (Throwable paramEmojiInfo)
          {
            for (;;)
            {
              ab.printErrStackTrace("MicroMsg.emoji.EmojiFileEncryptMgr", paramEmojiInfo, "", new Object[0]);
              paramEmojiInfo = (EmojiInfo)localObject;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.f
 * JD-Core Version:    0.7.0.1
 */