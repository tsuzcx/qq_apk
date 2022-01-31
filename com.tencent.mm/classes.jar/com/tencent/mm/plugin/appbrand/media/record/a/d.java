package com.tencent.mm.plugin.appbrand.media.record.a;

import com.tencent.mm.plugin.appbrand.media.encode.Mp3EncodeJni;
import com.tencent.mm.plugin.appbrand.media.record.h;
import com.tencent.mm.plugin.appbrand.media.record.j;
import com.tencent.mm.sdk.platformtools.y;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public final class d
  extends b
{
  private int eAY = 2;
  private byte[] gOA;
  private FileOutputStream mFileOutputStream;
  private String mFilePath = "";
  
  public final boolean a(boolean paramBoolean, byte[] paramArrayOfByte, int paramInt)
  {
    paramBoolean = true;
    if (this.gOw <= 0)
    {
      y.e("MicroMsg.Record.MP3AudioEncoder", "mMinBufferSize %d is invalid", new Object[] { Integer.valueOf(this.gOw) });
      return false;
    }
    if (this.mFileOutputStream == null)
    {
      y.e("MicroMsg.Record.MP3AudioEncoder", "mFileOutputStream is null");
      return false;
    }
    if (this.gOA == null)
    {
      i = (int)(7200.0D + this.gOw * this.eAY * 1.25D);
      y.i("MicroMsg.Record.MP3AudioEncoder", "channelCnt:%d, mMinBufferSize:%d, size:%d, ", new Object[] { Integer.valueOf(this.eAY), Integer.valueOf(this.gOw), Integer.valueOf(i) });
      this.gOA = new byte[i];
    }
    paramArrayOfByte = h.B(paramArrayOfByte, paramInt);
    int i = Mp3EncodeJni.encode(paramArrayOfByte, paramArrayOfByte, paramInt / 2, this.gOA);
    y.d("MicroMsg.Record.MP3AudioEncoder", "len:%d, shorts.len:%d, encodedSize:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(i) });
    if (i > 0) {
      y.d("MicroMsg.Record.MP3AudioEncoder", "encodeSize:%d, len:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
    }
    for (;;)
    {
      try
      {
        this.mFileOutputStream.write(this.gOA, 0, i);
        d(this.gOA, i, false);
        return paramBoolean;
      }
      catch (IOException paramArrayOfByte)
      {
        y.printErrStackTrace("MicroMsg.Record.MP3AudioEncoder", paramArrayOfByte, "encode write", new Object[0]);
        j.lU(20);
        paramBoolean = false;
        continue;
      }
      y.e("MicroMsg.Record.MP3AudioEncoder", "Mp3EncodeJni encode fail, encodedSize:%d", new Object[] { Integer.valueOf(i) });
      paramBoolean = false;
    }
  }
  
  public final void close()
  {
    y.i("MicroMsg.Record.MP3AudioEncoder", "close");
    Mp3EncodeJni.close();
    if (this.mFileOutputStream != null) {}
    try
    {
      this.mFileOutputStream.close();
      this.mFileOutputStream = null;
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.Record.MP3AudioEncoder", localIOException, "close", new Object[0]);
        j.lU(20);
      }
    }
  }
  
  public final boolean f(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = true;
    y.i("MicroMsg.Record.MP3AudioEncoder", "init, filePath:%s, sampleRate:%d, channelCount:%d, bitRate:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.mFilePath = paramString;
    this.eAY = paramInt2;
    paramInt1 = Mp3EncodeJni.init(paramInt1, paramInt2, paramInt1, paramInt3 / 1000, 5);
    y.i("MicroMsg.Record.MP3AudioEncoder", "Mp3EncodeJni.init ret :%d", new Object[] { Integer.valueOf(paramInt1) });
    if (paramInt1 == -1)
    {
      j.lU(17);
      return false;
    }
    y.i("MicroMsg.Record.MP3AudioEncoder", "lame MPEG version:%d", new Object[] { Integer.valueOf(Mp3EncodeJni.getVersion()) });
    try
    {
      this.mFileOutputStream = new FileOutputStream(paramString);
      return bool;
    }
    catch (FileNotFoundException paramString)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.Record.MP3AudioEncoder", paramString, "init", new Object[0]);
        j.lU(18);
        bool = false;
      }
    }
  }
  
  public final void flush()
  {
    y.i("MicroMsg.Record.MP3AudioEncoder", "flush");
    if ((this.mFileOutputStream == null) || (this.gOA == null))
    {
      y.e("MicroMsg.Record.MP3AudioEncoder", "flush, mFileOutputStream or mMp3Buffer is null");
      return;
    }
    int i = Mp3EncodeJni.flush(this.gOA);
    if (i > 0) {
      try
      {
        this.mFileOutputStream.write(this.gOA, 0, i);
        d(this.gOA, i, true);
        return;
      }
      catch (IOException localIOException)
      {
        y.printErrStackTrace("MicroMsg.Record.MP3AudioEncoder", localIOException, "flush write", new Object[0]);
        j.lU(20);
        return;
      }
    }
    y.e("MicroMsg.Record.MP3AudioEncoder", "flush fail, flushResult:%d", new Object[] { Integer.valueOf(i) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.a.d
 * JD-Core Version:    0.7.0.1
 */