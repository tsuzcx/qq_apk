package com.tencent.mm.plugin.appbrand.media.record.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class g
  extends f
{
  private int iqm;
  private int mSampleRate;
  
  private static RandomAccessFile I(File paramFile)
  {
    AppMethodBeat.i(140665);
    try
    {
      paramFile = new RandomAccessFile(paramFile, "rw");
      AppMethodBeat.o(140665);
      return paramFile;
    }
    catch (FileNotFoundException paramFile)
    {
      ab.b("Luggage.PCMAudioEncoder", "", new Object[] { paramFile });
      AppMethodBeat.o(140665);
    }
    return null;
  }
  
  public final void close()
  {
    AppMethodBeat.i(140664);
    super.close();
    try
    {
      RandomAccessFile localRandomAccessFile = I(this.gVL);
      localRandomAccessFile.seek(0L);
      int i = this.mSampleRate;
      int j = this.iqm;
      long l2 = this.gVL.length();
      long l1 = l2 - 44L;
      l2 = l2 - 44L + 36L;
      long l3 = i;
      long l4 = i * 16 * j / 8;
      localRandomAccessFile.write(new byte[] { 82, 73, 70, 70, (byte)(int)(0xFF & l2), (byte)(int)(l2 >> 8 & 0xFF), (byte)(int)(l2 >> 16 & 0xFF), (byte)(int)(l2 >> 24 & 0xFF), 87, 65, 86, 69, 102, 109, 116, 32, 16, 0, 0, 0, 1, 0, (byte)j, 0, (byte)(int)(0xFF & l3), (byte)(int)(l3 >> 8 & 0xFF), (byte)(int)(l3 >> 16 & 0xFF), (byte)(int)(l3 >> 24 & 0xFF), (byte)(int)(0xFF & l4), (byte)(int)(l4 >> 8 & 0xFF), (byte)(int)(l4 >> 16 & 0xFF), (byte)(int)(l4 >> 24 & 0xFF), (byte)(j * 2), 0, 16, 0, 100, 97, 116, 97, (byte)(int)(0xFF & l1), (byte)(int)(l1 >> 8 & 0xFF), (byte)(int)(l1 >> 16 & 0xFF), (byte)(int)(l1 >> 24 & 0xFF) });
      localRandomAccessFile.close();
      AppMethodBeat.o(140664);
      return;
    }
    catch (IOException localIOException)
    {
      ab.b("Luggage.PCMAudioEncoder", "", new Object[] { localIOException });
      AppMethodBeat.o(140664);
    }
  }
  
  public final boolean h(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(140663);
    this.mSampleRate = paramInt1;
    this.iqm = paramInt2;
    boolean bool = super.h(paramString, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(140663);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.a.g
 * JD-Core Version:    0.7.0.1
 */