package com.tencent.mm.plugin.appbrand.media.record.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.media.encode.Mp3EncodeJni;
import com.tencent.mm.plugin.appbrand.media.record.h;
import com.tencent.mm.plugin.appbrand.media.record.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.o;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

public final class e
  extends c
{
  private int iqp = 2;
  private byte[] lWK;
  private OutputStream mFileOutputStream;
  private String mFilePath = "";
  
  public final boolean a(boolean paramBoolean, byte[] paramArrayOfByte, int paramInt)
  {
    paramBoolean = true;
    AppMethodBeat.i(146346);
    if (this.lWG <= 0)
    {
      ae.e("MicroMsg.Record.MP3AudioEncoder", "mMinBufferSize %d is invalid", new Object[] { Integer.valueOf(this.lWG) });
      AppMethodBeat.o(146346);
      return false;
    }
    if (this.mFileOutputStream == null)
    {
      ae.e("MicroMsg.Record.MP3AudioEncoder", "mFileOutputStream is null");
      AppMethodBeat.o(146346);
      return false;
    }
    if (this.lWK == null)
    {
      i = (int)(7200.0D + this.lWG * this.iqp * 1.25D);
      ae.i("MicroMsg.Record.MP3AudioEncoder", "channelCnt:%d, mMinBufferSize:%d, size:%d, ", new Object[] { Integer.valueOf(this.iqp), Integer.valueOf(this.lWG), Integer.valueOf(i) });
      this.lWK = new byte[i];
    }
    paramArrayOfByte = h.E(paramArrayOfByte, paramInt);
    int i = Mp3EncodeJni.encode(paramArrayOfByte, paramArrayOfByte, paramInt / 2, this.lWK);
    ae.d("MicroMsg.Record.MP3AudioEncoder", "len:%d, shorts.len:%d, encodedSize:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(i) });
    if (i > 0) {
      ae.d("MicroMsg.Record.MP3AudioEncoder", "encodeSize:%d, len:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
    }
    for (;;)
    {
      try
      {
        this.mFileOutputStream.write(this.lWK, 0, i);
        d(this.lWK, i, false);
        AppMethodBeat.o(146346);
        return paramBoolean;
      }
      catch (IOException paramArrayOfByte)
      {
        ae.printErrStackTrace("MicroMsg.Record.MP3AudioEncoder", paramArrayOfByte, "encode write", new Object[0]);
        j.uI(20);
        paramBoolean = false;
        continue;
      }
      ae.e("MicroMsg.Record.MP3AudioEncoder", "Mp3EncodeJni encode fail, encodedSize:%d", new Object[] { Integer.valueOf(i) });
      paramBoolean = false;
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(146348);
    ae.i("MicroMsg.Record.MP3AudioEncoder", "close");
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
        ae.printErrStackTrace("MicroMsg.Record.MP3AudioEncoder", localIOException, "close", new Object[0]);
        j.uI(20);
      }
    }
  }
  
  public final void flush()
  {
    AppMethodBeat.i(146347);
    ae.i("MicroMsg.Record.MP3AudioEncoder", "flush");
    if ((this.mFileOutputStream == null) || (this.lWK == null))
    {
      ae.e("MicroMsg.Record.MP3AudioEncoder", "flush, mFileOutputStream or mMp3Buffer is null");
      AppMethodBeat.o(146347);
      return;
    }
    int i = Mp3EncodeJni.flush(this.lWK);
    if (i > 0) {
      try
      {
        this.mFileOutputStream.write(this.lWK, 0, i);
        d(this.lWK, i, true);
        AppMethodBeat.o(146347);
        return;
      }
      catch (IOException localIOException)
      {
        ae.printErrStackTrace("MicroMsg.Record.MP3AudioEncoder", localIOException, "flush write", new Object[0]);
        j.uI(20);
        AppMethodBeat.o(146347);
        return;
      }
    }
    ae.e("MicroMsg.Record.MP3AudioEncoder", "flush fail, flushResult:%d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(146347);
  }
  
  public final boolean i(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = true;
    AppMethodBeat.i(146345);
    ae.i("MicroMsg.Record.MP3AudioEncoder", "init, filePath:%s, sampleRate:%d, channelCount:%d, bitRate:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.mFilePath = paramString;
    this.iqp = paramInt2;
    paramInt1 = Mp3EncodeJni.init(paramInt1, paramInt2, paramInt1, paramInt3 / 1000, 5);
    ae.i("MicroMsg.Record.MP3AudioEncoder", "Mp3EncodeJni.init ret :%d", new Object[] { Integer.valueOf(paramInt1) });
    if (paramInt1 == -1)
    {
      j.uI(17);
      AppMethodBeat.o(146345);
      return false;
    }
    ae.i("MicroMsg.Record.MP3AudioEncoder", "lame MPEG version:%d", new Object[] { Integer.valueOf(Mp3EncodeJni.getVersion()) });
    try
    {
      this.mFileOutputStream = o.db(paramString, false);
      AppMethodBeat.o(146345);
      return bool;
    }
    catch (FileNotFoundException paramString)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.Record.MP3AudioEncoder", paramString, "init", new Object[0]);
        j.uI(18);
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.a.e
 * JD-Core Version:    0.7.0.1
 */