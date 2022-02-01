package com.tencent.mm.plugin.appbrand.media.record.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.media.encode.Mp3EncodeJni;
import com.tencent.mm.plugin.appbrand.media.record.h;
import com.tencent.mm.plugin.appbrand.media.record.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.i;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

public final class e
  extends c
{
  private int inv = 2;
  private byte[] lSj;
  private OutputStream mFileOutputStream;
  private String mFilePath = "";
  
  public final boolean a(boolean paramBoolean, byte[] paramArrayOfByte, int paramInt)
  {
    paramBoolean = true;
    AppMethodBeat.i(146346);
    if (this.lSf <= 0)
    {
      ad.e("MicroMsg.Record.MP3AudioEncoder", "mMinBufferSize %d is invalid", new Object[] { Integer.valueOf(this.lSf) });
      AppMethodBeat.o(146346);
      return false;
    }
    if (this.mFileOutputStream == null)
    {
      ad.e("MicroMsg.Record.MP3AudioEncoder", "mFileOutputStream is null");
      AppMethodBeat.o(146346);
      return false;
    }
    if (this.lSj == null)
    {
      i = (int)(7200.0D + this.lSf * this.inv * 1.25D);
      ad.i("MicroMsg.Record.MP3AudioEncoder", "channelCnt:%d, mMinBufferSize:%d, size:%d, ", new Object[] { Integer.valueOf(this.inv), Integer.valueOf(this.lSf), Integer.valueOf(i) });
      this.lSj = new byte[i];
    }
    paramArrayOfByte = h.E(paramArrayOfByte, paramInt);
    int i = Mp3EncodeJni.encode(paramArrayOfByte, paramArrayOfByte, paramInt / 2, this.lSj);
    ad.d("MicroMsg.Record.MP3AudioEncoder", "len:%d, shorts.len:%d, encodedSize:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(i) });
    if (i > 0) {
      ad.d("MicroMsg.Record.MP3AudioEncoder", "encodeSize:%d, len:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
    }
    for (;;)
    {
      try
      {
        this.mFileOutputStream.write(this.lSj, 0, i);
        d(this.lSj, i, false);
        AppMethodBeat.o(146346);
        return paramBoolean;
      }
      catch (IOException paramArrayOfByte)
      {
        ad.printErrStackTrace("MicroMsg.Record.MP3AudioEncoder", paramArrayOfByte, "encode write", new Object[0]);
        j.uC(20);
        paramBoolean = false;
        continue;
      }
      ad.e("MicroMsg.Record.MP3AudioEncoder", "Mp3EncodeJni encode fail, encodedSize:%d", new Object[] { Integer.valueOf(i) });
      paramBoolean = false;
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(146348);
    ad.i("MicroMsg.Record.MP3AudioEncoder", "close");
    Mp3EncodeJni.close();
    if (this.mFileOutputStream != null) {}
    try
    {
      this.mFileOutputStream.close();
      this.mFileOutputStream = null;
      AppMethodBeat.o(146348);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.Record.MP3AudioEncoder", localIOException, "close", new Object[0]);
        j.uC(20);
      }
    }
  }
  
  public final void flush()
  {
    AppMethodBeat.i(146347);
    ad.i("MicroMsg.Record.MP3AudioEncoder", "flush");
    if ((this.mFileOutputStream == null) || (this.lSj == null))
    {
      ad.e("MicroMsg.Record.MP3AudioEncoder", "flush, mFileOutputStream or mMp3Buffer is null");
      AppMethodBeat.o(146347);
      return;
    }
    int i = Mp3EncodeJni.flush(this.lSj);
    if (i > 0) {
      try
      {
        this.mFileOutputStream.write(this.lSj, 0, i);
        d(this.lSj, i, true);
        AppMethodBeat.o(146347);
        return;
      }
      catch (IOException localIOException)
      {
        ad.printErrStackTrace("MicroMsg.Record.MP3AudioEncoder", localIOException, "flush write", new Object[0]);
        j.uC(20);
        AppMethodBeat.o(146347);
        return;
      }
    }
    ad.e("MicroMsg.Record.MP3AudioEncoder", "flush fail, flushResult:%d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(146347);
  }
  
  public final boolean i(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = true;
    AppMethodBeat.i(146345);
    ad.i("MicroMsg.Record.MP3AudioEncoder", "init, filePath:%s, sampleRate:%d, channelCount:%d, bitRate:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.mFilePath = paramString;
    this.inv = paramInt2;
    paramInt1 = Mp3EncodeJni.init(paramInt1, paramInt2, paramInt1, paramInt3 / 1000, 5);
    ad.i("MicroMsg.Record.MP3AudioEncoder", "Mp3EncodeJni.init ret :%d", new Object[] { Integer.valueOf(paramInt1) });
    if (paramInt1 == -1)
    {
      j.uC(17);
      AppMethodBeat.o(146345);
      return false;
    }
    ad.i("MicroMsg.Record.MP3AudioEncoder", "lame MPEG version:%d", new Object[] { Integer.valueOf(Mp3EncodeJni.getVersion()) });
    try
    {
      this.mFileOutputStream = i.cX(paramString, false);
      AppMethodBeat.o(146345);
      return bool;
    }
    catch (FileNotFoundException paramString)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.Record.MP3AudioEncoder", paramString, "init", new Object[0]);
        j.uC(18);
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.a.e
 * JD-Core Version:    0.7.0.1
 */