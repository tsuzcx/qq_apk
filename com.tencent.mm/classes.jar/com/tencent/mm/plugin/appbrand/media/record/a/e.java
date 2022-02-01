package com.tencent.mm.plugin.appbrand.media.record.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.media.encode.Mp3EncodeJni;
import com.tencent.mm.plugin.appbrand.media.record.h;
import com.tencent.mm.plugin.appbrand.media.record.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.vfs.i;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

public final class e
  extends c
{
  private int hUa = 2;
  private byte[] lta;
  private OutputStream mFileOutputStream;
  private String mFilePath = "";
  
  public final boolean a(boolean paramBoolean, byte[] paramArrayOfByte, int paramInt)
  {
    paramBoolean = true;
    AppMethodBeat.i(146346);
    if (this.lsW <= 0)
    {
      ac.e("MicroMsg.Record.MP3AudioEncoder", "mMinBufferSize %d is invalid", new Object[] { Integer.valueOf(this.lsW) });
      AppMethodBeat.o(146346);
      return false;
    }
    if (this.mFileOutputStream == null)
    {
      ac.e("MicroMsg.Record.MP3AudioEncoder", "mFileOutputStream is null");
      AppMethodBeat.o(146346);
      return false;
    }
    if (this.lta == null)
    {
      i = (int)(7200.0D + this.lsW * this.hUa * 1.25D);
      ac.i("MicroMsg.Record.MP3AudioEncoder", "channelCnt:%d, mMinBufferSize:%d, size:%d, ", new Object[] { Integer.valueOf(this.hUa), Integer.valueOf(this.lsW), Integer.valueOf(i) });
      this.lta = new byte[i];
    }
    paramArrayOfByte = h.E(paramArrayOfByte, paramInt);
    int i = Mp3EncodeJni.encode(paramArrayOfByte, paramArrayOfByte, paramInt / 2, this.lta);
    ac.d("MicroMsg.Record.MP3AudioEncoder", "len:%d, shorts.len:%d, encodedSize:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(i) });
    if (i > 0) {
      ac.d("MicroMsg.Record.MP3AudioEncoder", "encodeSize:%d, len:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
    }
    for (;;)
    {
      try
      {
        this.mFileOutputStream.write(this.lta, 0, i);
        d(this.lta, i, false);
        AppMethodBeat.o(146346);
        return paramBoolean;
      }
      catch (IOException paramArrayOfByte)
      {
        ac.printErrStackTrace("MicroMsg.Record.MP3AudioEncoder", paramArrayOfByte, "encode write", new Object[0]);
        j.tY(20);
        paramBoolean = false;
        continue;
      }
      ac.e("MicroMsg.Record.MP3AudioEncoder", "Mp3EncodeJni encode fail, encodedSize:%d", new Object[] { Integer.valueOf(i) });
      paramBoolean = false;
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(146348);
    ac.i("MicroMsg.Record.MP3AudioEncoder", "close");
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
        ac.printErrStackTrace("MicroMsg.Record.MP3AudioEncoder", localIOException, "close", new Object[0]);
        j.tY(20);
      }
    }
  }
  
  public final void flush()
  {
    AppMethodBeat.i(146347);
    ac.i("MicroMsg.Record.MP3AudioEncoder", "flush");
    if ((this.mFileOutputStream == null) || (this.lta == null))
    {
      ac.e("MicroMsg.Record.MP3AudioEncoder", "flush, mFileOutputStream or mMp3Buffer is null");
      AppMethodBeat.o(146347);
      return;
    }
    int i = Mp3EncodeJni.flush(this.lta);
    if (i > 0) {
      try
      {
        this.mFileOutputStream.write(this.lta, 0, i);
        d(this.lta, i, true);
        AppMethodBeat.o(146347);
        return;
      }
      catch (IOException localIOException)
      {
        ac.printErrStackTrace("MicroMsg.Record.MP3AudioEncoder", localIOException, "flush write", new Object[0]);
        j.tY(20);
        AppMethodBeat.o(146347);
        return;
      }
    }
    ac.e("MicroMsg.Record.MP3AudioEncoder", "flush fail, flushResult:%d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(146347);
  }
  
  public final boolean i(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = true;
    AppMethodBeat.i(146345);
    ac.i("MicroMsg.Record.MP3AudioEncoder", "init, filePath:%s, sampleRate:%d, channelCount:%d, bitRate:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.mFilePath = paramString;
    this.hUa = paramInt2;
    paramInt1 = Mp3EncodeJni.init(paramInt1, paramInt2, paramInt1, paramInt3 / 1000, 5);
    ac.i("MicroMsg.Record.MP3AudioEncoder", "Mp3EncodeJni.init ret :%d", new Object[] { Integer.valueOf(paramInt1) });
    if (paramInt1 == -1)
    {
      j.tY(17);
      AppMethodBeat.o(146345);
      return false;
    }
    ac.i("MicroMsg.Record.MP3AudioEncoder", "lame MPEG version:%d", new Object[] { Integer.valueOf(Mp3EncodeJni.getVersion()) });
    try
    {
      this.mFileOutputStream = i.cS(paramString, false);
      AppMethodBeat.o(146345);
      return bool;
    }
    catch (FileNotFoundException paramString)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.Record.MP3AudioEncoder", paramString, "init", new Object[0]);
        j.tY(18);
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.a.e
 * JD-Core Version:    0.7.0.1
 */