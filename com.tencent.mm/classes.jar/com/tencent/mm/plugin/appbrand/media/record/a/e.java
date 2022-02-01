package com.tencent.mm.plugin.appbrand.media.record.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.media.encode.Mp3EncodeJni;
import com.tencent.mm.plugin.appbrand.media.record.h;
import com.tencent.mm.plugin.appbrand.media.record.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

public final class e
  extends c
{
  private int jlA = 2;
  private OutputStream mFileOutputStream;
  private String mFilePath = "";
  private byte[] nem;
  
  public final boolean a(boolean paramBoolean, byte[] paramArrayOfByte, int paramInt)
  {
    paramBoolean = true;
    AppMethodBeat.i(146346);
    if (this.nei <= 0)
    {
      Log.e("MicroMsg.Record.MP3AudioEncoder", "mMinBufferSize %d is invalid", new Object[] { Integer.valueOf(this.nei) });
      AppMethodBeat.o(146346);
      return false;
    }
    if (this.mFileOutputStream == null)
    {
      Log.e("MicroMsg.Record.MP3AudioEncoder", "mFileOutputStream is null");
      AppMethodBeat.o(146346);
      return false;
    }
    if (this.nem == null)
    {
      i = (int)(7200.0D + this.nei * this.jlA * 1.25D);
      Log.i("MicroMsg.Record.MP3AudioEncoder", "channelCnt:%d, mMinBufferSize:%d, size:%d, ", new Object[] { Integer.valueOf(this.jlA), Integer.valueOf(this.nei), Integer.valueOf(i) });
      this.nem = new byte[i];
    }
    paramArrayOfByte = h.G(paramArrayOfByte, paramInt);
    int i = Mp3EncodeJni.encode(paramArrayOfByte, paramArrayOfByte, paramInt / 2, this.nem);
    Log.d("MicroMsg.Record.MP3AudioEncoder", "len:%d, shorts.len:%d, encodedSize:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(i) });
    if (i > 0) {
      Log.d("MicroMsg.Record.MP3AudioEncoder", "encodeSize:%d, len:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
    }
    for (;;)
    {
      try
      {
        this.mFileOutputStream.write(this.nem, 0, i);
        d(this.nem, i, false);
        AppMethodBeat.o(146346);
        return paramBoolean;
      }
      catch (IOException paramArrayOfByte)
      {
        Log.printErrStackTrace("MicroMsg.Record.MP3AudioEncoder", paramArrayOfByte, "encode write", new Object[0]);
        j.yz(20);
        paramBoolean = false;
        continue;
      }
      Log.e("MicroMsg.Record.MP3AudioEncoder", "Mp3EncodeJni encode fail, encodedSize:%d", new Object[] { Integer.valueOf(i) });
      paramBoolean = false;
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(146348);
    Log.i("MicroMsg.Record.MP3AudioEncoder", "close");
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
        Log.printErrStackTrace("MicroMsg.Record.MP3AudioEncoder", localIOException, "close", new Object[0]);
        j.yz(20);
      }
    }
  }
  
  public final void flush()
  {
    AppMethodBeat.i(146347);
    Log.i("MicroMsg.Record.MP3AudioEncoder", "flush");
    if ((this.mFileOutputStream == null) || (this.nem == null))
    {
      Log.e("MicroMsg.Record.MP3AudioEncoder", "flush, mFileOutputStream or mMp3Buffer is null");
      AppMethodBeat.o(146347);
      return;
    }
    int i = Mp3EncodeJni.flush(this.nem);
    if (i > 0) {
      try
      {
        this.mFileOutputStream.write(this.nem, 0, i);
        d(this.nem, i, true);
        AppMethodBeat.o(146347);
        return;
      }
      catch (IOException localIOException)
      {
        Log.printErrStackTrace("MicroMsg.Record.MP3AudioEncoder", localIOException, "flush write", new Object[0]);
        j.yz(20);
        AppMethodBeat.o(146347);
        return;
      }
    }
    Log.e("MicroMsg.Record.MP3AudioEncoder", "flush fail, flushResult:%d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(146347);
  }
  
  public final boolean i(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = true;
    AppMethodBeat.i(146345);
    Log.i("MicroMsg.Record.MP3AudioEncoder", "init, filePath:%s, sampleRate:%d, channelCount:%d, bitRate:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.mFilePath = paramString;
    this.jlA = paramInt2;
    paramInt1 = Mp3EncodeJni.init(paramInt1, paramInt2, paramInt1, paramInt3 / 1000, 5);
    Log.i("MicroMsg.Record.MP3AudioEncoder", "Mp3EncodeJni.init ret :%d", new Object[] { Integer.valueOf(paramInt1) });
    if (paramInt1 == -1)
    {
      j.yz(17);
      AppMethodBeat.o(146345);
      return false;
    }
    Log.i("MicroMsg.Record.MP3AudioEncoder", "lame MPEG version:%d", new Object[] { Integer.valueOf(Mp3EncodeJni.getVersion()) });
    try
    {
      this.mFileOutputStream = s.dw(paramString, false);
      AppMethodBeat.o(146345);
      return bool;
    }
    catch (FileNotFoundException paramString)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.Record.MP3AudioEncoder", paramString, "init", new Object[0]);
        j.yz(18);
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.a.e
 * JD-Core Version:    0.7.0.1
 */