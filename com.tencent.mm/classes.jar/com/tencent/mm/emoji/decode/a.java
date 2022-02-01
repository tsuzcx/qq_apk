package com.tencent.mm.emoji.decode;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.vfs.u;

public class a
{
  public static a jFw;
  private boolean isRunning = false;
  private String key;
  
  private static boolean a(EmojiInfo paramEmojiInfo, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(104439);
    String str1;
    if (ImgUtil.isWXGF(paramArrayOfByte))
    {
      String str2 = paramEmojiInfo.field_externMd5;
      str1 = str2;
      if (TextUtils.isEmpty(str2))
      {
        AppMethodBeat.o(104439);
        return true;
      }
    }
    else
    {
      str1 = paramEmojiInfo.field_md5;
    }
    paramArrayOfByte = MD5Util.getMD5String(paramArrayOfByte);
    if ((!Util.isNullOrNil(str1)) && (!Util.isNullOrNil(paramArrayOfByte)) && (Util.isEqual(str1, paramArrayOfByte))) {}
    for (boolean bool = true;; bool = false)
    {
      if (!bool)
      {
        paramEmojiInfo.hBq();
        Log.w("MicroMsg.emoji.EmojiFileEncryptMgr", "checkFileMd5: %s", new Object[] { paramEmojiInfo.field_md5 });
      }
      AppMethodBeat.o(104439);
      return bool;
    }
  }
  
  public static a aBf()
  {
    AppMethodBeat.i(104434);
    if (jFw == null) {}
    try
    {
      jFw = new a();
      a locala = jFw;
      AppMethodBeat.o(104434);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(104434);
    }
  }
  
  public final boolean a(EmojiInfo paramEmojiInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(104437);
    if (paramEmojiInfo == null)
    {
      Log.w("MicroMsg.emoji.EmojiFileEncryptMgr", "encodeEmojiFile failed. emoji is null.");
      AppMethodBeat.o(104437);
      return false;
    }
    if (Util.isNullOrNil(aBg())) {}
    for (int i = 0; i == 0; i = 1)
    {
      Log.i("MicroMsg.emoji.EmojiFileEncryptMgr", "disable encrypt");
      AppMethodBeat.o(104437);
      return false;
    }
    String str = paramEmojiInfo.ifh();
    Object localObject;
    boolean bool1;
    if (u.agG(str))
    {
      boolean bool2 = false;
      localObject = u.aY(str, 0, 10);
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
          bool1 = ImgUtil.isImageFile((byte[])localObject);
        }
        if ((paramBoolean) || (bool1))
        {
          long l = System.currentTimeMillis();
          j = (int)u.bBQ(str);
          byte[] arrayOfByte2;
          byte[] arrayOfByte1;
          if (j > 1024)
          {
            i = 1024;
            arrayOfByte2 = u.aY(str, 0, j);
            arrayOfByte1 = u.aY(str, 0, i);
            localObject = new byte[0];
          }
          try
          {
            arrayOfByte1 = AesEcb.aesCryptEcb(arrayOfByte1, aBg().getBytes(), true, false);
            localObject = arrayOfByte1;
          }
          catch (Throwable localThrowable2)
          {
            Log.printErrStackTrace("MicroMsg.emoji.EmojiFileEncryptMgr", localThrowable2, "", new Object[0]);
            continue;
            Log.w("MicroMsg.emoji.EmojiFileEncryptMgr", "encodeEmojiFile failed. write file failed.");
            h.IzE.idkeyStat(252L, 3L, 1L, false);
            AppMethodBeat.o(104437);
            return false;
          }
          if ((localObject == null) || (localObject.length < i) || (arrayOfByte2 == null) || (arrayOfByte2.length < i)) {
            break label465;
          }
          System.arraycopy(localObject, 0, arrayOfByte2, 0, i);
          i = u.f(str, arrayOfByte2, arrayOfByte2.length);
          if (i == 0)
          {
            l = System.currentTimeMillis() - l;
            h.IzE.idkeyStat(252L, 1L, l, false);
            h.IzE.idkeyStat(252L, 6L, 1L, false);
            paramEmojiInfo.field_reserved4 |= EmojiInfo.ZuM;
            paramEmojiInfo.field_size = j;
            bj.hyV().VFH.N(paramEmojiInfo);
            Log.i("MicroMsg.emoji.EmojiFileEncryptMgr", "encode emoji file length:%d use time:%d", new Object[] { Integer.valueOf(arrayOfByte2.length), Long.valueOf(l) });
            AppMethodBeat.o(104437);
            return true;
          }
        }
      }
      catch (Throwable localThrowable1)
      {
        int j;
        Log.printErrStackTrace("MicroMsg.emoji.EmojiFileEncryptMgr", localThrowable1, "", new Object[0]);
        bool1 = false;
        continue;
        i = j;
        continue;
      }
      Log.i("MicroMsg.emoji.EmojiFileEncryptMgr", "encodeEmojiFile file had encrypt.");
      AppMethodBeat.o(104437);
      return true;
      Log.w("MicroMsg.emoji.EmojiFileEncryptMgr", "encodeEmojiFile failed. file not exist. path%s", new Object[] { str });
      paramEmojiInfo.field_reserved4 = 0;
      bj.hyV().VFH.N(paramEmojiInfo);
      AppMethodBeat.o(104437);
      return false;
      label465:
      i = -1;
    }
  }
  
  public final byte[] a(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(104438);
    if (paramEmojiInfo == null)
    {
      Log.w("MicroMsg.emoji.EmojiFileEncryptMgr", "decodeEmojiData failed. emoji is null.");
      AppMethodBeat.o(104438);
      return null;
    }
    String str = paramEmojiInfo.ifh();
    byte[] arrayOfByte1 = u.aY(str, 0, -1);
    if ((u.bBQ(str) > 0L) && (arrayOfByte1 != null) && (arrayOfByte1.length >= 10))
    {
      Object localObject1 = new byte[10];
      System.arraycopy(arrayOfByte1, 0, localObject1, 0, 10);
      if (((paramEmojiInfo.field_reserved4 & EmojiInfo.ZuM) == EmojiInfo.ZuM) || (!ImgUtil.isImageFile((byte[])localObject1)))
      {
        long l = System.currentTimeMillis();
        int j = (int)u.bBQ(str);
        int i = j;
        if (j > 1024) {
          i = 1024;
        }
        byte[] arrayOfByte2 = u.aY(str, 0, i);
        Object localObject3 = null;
        localObject1 = localObject3;
        if (!Util.isNullOrNil(aBg())) {}
        try
        {
          localObject1 = AesEcb.aesCryptEcb(arrayOfByte2, aBg().getBytes(), false, false);
          if ((!Util.isNullOrNil((byte[])localObject1)) && (!Util.isNullOrNil(arrayOfByte1)))
          {
            System.arraycopy(localObject1, 0, arrayOfByte1, 0, i);
            l = System.currentTimeMillis() - l;
            h.IzE.idkeyStat(252L, 0L, l, false);
            h.IzE.idkeyStat(252L, 5L, 1L, false);
            Log.d("MicroMsg.emoji.EmojiFileEncryptMgr", "decode emoji file length:%d use time:%d", new Object[] { Integer.valueOf(arrayOfByte1.length), Long.valueOf(l) });
            if (!a(paramEmojiInfo, arrayOfByte1)) {
              break label382;
            }
            AppMethodBeat.o(104438);
            return arrayOfByte1;
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.emoji.EmojiFileEncryptMgr", localThrowable, "", new Object[0]);
            Object localObject2 = localObject3;
          }
          h.IzE.idkeyStat(252L, 2L, 1L, false);
          Log.i("MicroMsg.emoji.EmojiFileEncryptMgr", "decode emoji file failed. path:%s return original ", new Object[] { str });
          if (!a(paramEmojiInfo, arrayOfByte1)) {
            break label382;
          }
        }
        AppMethodBeat.o(104438);
        return arrayOfByte1;
      }
      else if (a(paramEmojiInfo, arrayOfByte1))
      {
        AppMethodBeat.o(104438);
        return arrayOfByte1;
      }
    }
    else
    {
      Log.i("MicroMsg.emoji.EmojiFileEncryptMgr", "decode emoji file failed. path is no exist :%s ", new Object[] { str });
      AppMethodBeat.o(104438);
      return null;
    }
    label382:
    AppMethodBeat.o(104438);
    return null;
  }
  
  public final String aBg()
  {
    AppMethodBeat.i(104435);
    if (Util.isNullOrNil(this.key)) {
      this.key = bj.hyV().VFH.getKey();
    }
    String str = this.key;
    AppMethodBeat.o(104435);
    return str;
  }
  
  public final boolean b(EmojiInfo paramEmojiInfo)
  {
    int i = 1024;
    AppMethodBeat.i(104440);
    if (paramEmojiInfo == null)
    {
      Log.w("MicroMsg.emoji.EmojiFileEncryptMgr", "decodeEmojiData failed. emoji is null.");
      AppMethodBeat.o(104440);
      return false;
    }
    long l = System.currentTimeMillis();
    Object localObject = paramEmojiInfo.ifh();
    int j = (int)u.bBQ((String)localObject);
    byte[] arrayOfByte;
    if (j > 1024)
    {
      arrayOfByte = u.aY((String)localObject, 0, i);
      if ((u.bBQ((String)localObject) <= 0L) || (arrayOfByte == null) || (arrayOfByte.length < 10)) {
        break label240;
      }
      localObject = new byte[10];
      System.arraycopy(arrayOfByte, 0, localObject, 0, 10);
      if (!ImgUtil.isImageFile((byte[])localObject)) {
        break label156;
      }
    }
    label156:
    label240:
    for (boolean bool = true;; bool = false) {
      for (;;)
      {
        Log.d("MicroMsg.emoji.EmojiFileEncryptMgr", "checkout use time:%s result:%b", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Boolean.valueOf(bool) });
        AppMethodBeat.o(104440);
        return bool;
        i = j;
        break;
        if ((paramEmojiInfo.field_reserved4 & EmojiInfo.ZuM) == EmojiInfo.ZuM)
        {
          localObject = null;
          paramEmojiInfo = (EmojiInfo)localObject;
          if (!Util.isNullOrNil(aBg())) {}
          try
          {
            paramEmojiInfo = AesEcb.aesCryptEcb(arrayOfByte, aBg().getBytes(), false, false);
            if ((!Util.isNullOrNil(paramEmojiInfo)) && (ImgUtil.isImageFile(paramEmojiInfo))) {
              bool = true;
            }
          }
          catch (Throwable paramEmojiInfo)
          {
            for (;;)
            {
              Log.printErrStackTrace("MicroMsg.emoji.EmojiFileEncryptMgr", paramEmojiInfo, "", new Object[0]);
              paramEmojiInfo = (EmojiInfo)localObject;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.decode.a
 * JD-Core Version:    0.7.0.1
 */