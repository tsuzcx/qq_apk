package com.tencent.mm.plugin.appbrand.media.record.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class g
  extends f
{
  private int mSampleRate;
  private int qeE;
  
  public final void close()
  {
    AppMethodBeat.i(146355);
    super.close();
    try
    {
      RandomAccessFile localRandomAccessFile = u.dO(this.mFile.bOF(), true);
      localRandomAccessFile.seek(0L);
      int i = this.mSampleRate;
      int j = this.qeE;
      long l1 = this.mFile.length();
      long l2 = 36L + l1;
      long l3 = i;
      long l4 = i * 16 * j / 8;
      localRandomAccessFile.write(new byte[] { 82, 73, 70, 70, (byte)(int)(0xFF & l2), (byte)(int)(l2 >> 8 & 0xFF), (byte)(int)(l2 >> 16 & 0xFF), (byte)(int)(l2 >> 24 & 0xFF), 87, 65, 86, 69, 102, 109, 116, 32, 16, 0, 0, 0, 1, 0, (byte)j, 0, (byte)(int)(0xFF & l3), (byte)(int)(l3 >> 8 & 0xFF), (byte)(int)(l3 >> 16 & 0xFF), (byte)(int)(l3 >> 24 & 0xFF), (byte)(int)(0xFF & l4), (byte)(int)(l4 >> 8 & 0xFF), (byte)(int)(l4 >> 16 & 0xFF), (byte)(int)(l4 >> 24 & 0xFF), (byte)(j * 2), 0, 16, 0, 100, 97, 116, 97, (byte)(int)(0xFF & l1), (byte)(int)(l1 >> 8 & 0xFF), (byte)(int)(l1 >> 16 & 0xFF), (byte)(int)(l1 >> 24 & 0xFF) });
      localRandomAccessFile.close();
      AppMethodBeat.o(146355);
      return;
    }
    catch (IOException localIOException)
    {
      Log.printInfoStack("Luggage.PCMAudioEncoder", "", new Object[] { localIOException });
      AppMethodBeat.o(146355);
    }
  }
  
  public final boolean j(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(146354);
    this.mSampleRate = paramInt1;
    this.qeE = paramInt2;
    boolean bool = super.j(paramString, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(146354);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.a.g
 * JD-Core Version:    0.7.0.1
 */