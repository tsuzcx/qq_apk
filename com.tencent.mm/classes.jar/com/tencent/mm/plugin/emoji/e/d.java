package com.tencent.mm.plugin.emoji.e;

import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.e;

public class d
{
  public static d iWE;
  boolean isRunning = false;
  private String key;
  
  public static d aHc()
  {
    if (iWE == null) {}
    try
    {
      iWE = new d();
      return iWE;
    }
    finally {}
  }
  
  private String aHd()
  {
    if (bk.bl(this.key)) {
      this.key = i.getEmojiStorageMgr().uBb.getKey();
    }
    return this.key;
  }
  
  public final byte[] a(EmojiInfo paramEmojiInfo)
  {
    if (paramEmojiInfo == null)
    {
      y.w("MicroMsg.emoji.EmojiFileEncryptMgr", "decodeEmojiData failed. emoji is null.");
      return null;
    }
    String str = paramEmojiInfo.cwL();
    byte[] arrayOfByte1 = e.c(str, 0, -1);
    if ((e.aeQ(str) > 0L) && (arrayOfByte1 != null) && (arrayOfByte1.length >= 10))
    {
      byte[] arrayOfByte2 = new byte[10];
      System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, 10);
      if (((paramEmojiInfo.field_reserved4 & EmojiInfo.uDo) == EmojiInfo.uDo) && (!o.by(arrayOfByte2)))
      {
        long l = System.currentTimeMillis();
        int j = (int)e.aeQ(str);
        int i = j;
        if (j > 1024) {
          i = 1024;
        }
        arrayOfByte2 = e.c(str, 0, i);
        paramEmojiInfo = null;
        if (!bk.bl(aHd())) {
          paramEmojiInfo = AesEcb.aesCryptEcb(arrayOfByte2, aHd().getBytes(), false, false);
        }
        if ((!bk.bE(paramEmojiInfo)) && (!bk.bE(arrayOfByte1)))
        {
          System.arraycopy(paramEmojiInfo, 0, arrayOfByte1, 0, i);
          l = System.currentTimeMillis() - l;
          h.nFQ.a(252L, 0L, l, false);
          h.nFQ.a(252L, 5L, 1L, false);
          y.d("MicroMsg.emoji.EmojiFileEncryptMgr", "decode emoji file length:%d use time:%d", new Object[] { Integer.valueOf(arrayOfByte1.length), Long.valueOf(l) });
          return arrayOfByte1;
        }
        h.nFQ.a(252L, 2L, 1L, false);
        y.i("MicroMsg.emoji.EmojiFileEncryptMgr", "decode emoji file failed. path:%s return original ", new Object[] { str });
        return arrayOfByte1;
      }
      return arrayOfByte1;
    }
    y.i("MicroMsg.emoji.EmojiFileEncryptMgr", "decode emoji file failed. path is no exist :%s ", new Object[] { str });
    return null;
  }
  
  public final boolean b(EmojiInfo paramEmojiInfo)
  {
    int i = 1024;
    if (paramEmojiInfo == null)
    {
      y.w("MicroMsg.emoji.EmojiFileEncryptMgr", "decodeEmojiData failed. emoji is null.");
      return false;
    }
    long l = System.currentTimeMillis();
    Object localObject = paramEmojiInfo.cwL();
    int j = (int)e.aeQ((String)localObject);
    byte[] arrayOfByte;
    boolean bool;
    if (j > 1024)
    {
      arrayOfByte = e.c((String)localObject, 0, i);
      if ((e.aeQ((String)localObject) <= 0L) || (arrayOfByte == null) || (arrayOfByte.length < 10)) {
        break label202;
      }
      localObject = new byte[10];
      System.arraycopy(arrayOfByte, 0, localObject, 0, 10);
      if (!o.by((byte[])localObject)) {
        break label141;
      }
      bool = true;
    }
    for (;;)
    {
      y.d("MicroMsg.emoji.EmojiFileEncryptMgr", "checkout use time:%s result:%b", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Boolean.valueOf(bool) });
      return bool;
      i = j;
      break;
      label141:
      if ((paramEmojiInfo.field_reserved4 & EmojiInfo.uDo) == EmojiInfo.uDo)
      {
        paramEmojiInfo = null;
        if (!bk.bl(aHd())) {
          paramEmojiInfo = AesEcb.aesCryptEcb(arrayOfByte, aHd().getBytes(), false, false);
        }
        if ((!bk.bE(paramEmojiInfo)) && (o.by(paramEmojiInfo)))
        {
          bool = true;
          continue;
        }
      }
      label202:
      bool = false;
    }
  }
  
  public final boolean c(EmojiInfo paramEmojiInfo, boolean paramBoolean)
  {
    if (paramEmojiInfo == null)
    {
      y.w("MicroMsg.emoji.EmojiFileEncryptMgr", "encodeEmojiFile failed. emoji is null.");
      return false;
    }
    if (!isEnable())
    {
      y.i("MicroMsg.emoji.EmojiFileEncryptMgr", "disable encrypt");
      return false;
    }
    String str = paramEmojiInfo.cwL();
    byte[] arrayOfByte1;
    boolean bool1;
    if (e.bK(str))
    {
      boolean bool2 = false;
      arrayOfByte1 = e.c(str, 0, 10);
      bool1 = bool2;
      if (arrayOfByte1 != null) {
        bool1 = bool2;
      }
    }
    for (;;)
    {
      try
      {
        if (arrayOfByte1.length >= 10) {
          bool1 = o.by(arrayOfByte1);
        }
        if ((paramBoolean) || (bool1))
        {
          long l = System.currentTimeMillis();
          j = (int)e.aeQ(str);
          if (j > 1024)
          {
            i = 1024;
            arrayOfByte1 = e.c(str, 0, j);
            byte[] arrayOfByte2 = AesEcb.aesCryptEcb(e.c(str, 0, i), aHd().getBytes(), true, false);
            if ((arrayOfByte2 == null) || (arrayOfByte2.length < i) || (arrayOfByte1 == null) || (arrayOfByte1.length < i)) {
              break label385;
            }
            System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 0, i);
            i = e.b(str, arrayOfByte1, arrayOfByte1.length);
            if (i != 0) {
              continue;
            }
            l = System.currentTimeMillis() - l;
            h.nFQ.a(252L, 1L, l, false);
            h.nFQ.a(252L, 6L, 1L, false);
            paramEmojiInfo.field_reserved4 |= EmojiInfo.uDo;
            paramEmojiInfo.field_size = j;
            i.getEmojiStorageMgr().uBb.r(paramEmojiInfo);
            y.i("MicroMsg.emoji.EmojiFileEncryptMgr", "encode emoji file length:%d use time:%d", new Object[] { Integer.valueOf(arrayOfByte1.length), Long.valueOf(l) });
            return true;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        int j;
        y.printErrStackTrace("MicroMsg.emoji.EmojiFileEncryptMgr", localThrowable, "", new Object[0]);
        bool1 = false;
        continue;
        i = j;
        continue;
        y.w("MicroMsg.emoji.EmojiFileEncryptMgr", "encodeEmojiFile failed. write file failed.");
        h.nFQ.a(252L, 3L, 1L, false);
        return false;
      }
      y.i("MicroMsg.emoji.EmojiFileEncryptMgr", "encodeEmojiFile file had encrypt.");
      return true;
      y.w("MicroMsg.emoji.EmojiFileEncryptMgr", "encodeEmojiFile failed. file not exist. path%s", new Object[] { str });
      paramEmojiInfo.field_reserved4 = 0;
      i.getEmojiStorageMgr().uBb.r(paramEmojiInfo);
      return false;
      label385:
      int i = -1;
    }
  }
  
  public final boolean isEnable()
  {
    return !bk.bl(aHd());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.d
 * JD-Core Version:    0.7.0.1
 */