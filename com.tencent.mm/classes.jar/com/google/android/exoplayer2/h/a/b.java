package com.google.android.exoplayer2.h.a;

import com.google.android.exoplayer2.h.f;
import com.google.android.exoplayer2.h.j;
import com.google.android.exoplayer2.i.q;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class b
  implements f
{
  private j aQI;
  private final a aZF;
  private final long aZG;
  private FileOutputStream aZH;
  private long aZI;
  private long aZJ;
  private q aZK;
  private final int bufferSize;
  private File file;
  private OutputStream outputStream;
  
  public b(a parama)
  {
    this(parama, (byte)0);
  }
  
  private b(a parama, byte paramByte)
  {
    AppMethodBeat.i(151941);
    this.aZF = ((a)com.google.android.exoplayer2.i.a.checkNotNull(parama));
    this.aZG = 5242880L;
    this.bufferSize = 20480;
    AppMethodBeat.o(151941);
  }
  
  private void qx()
  {
    AppMethodBeat.i(151945);
    long l;
    if (this.aQI.aPF == -1L)
    {
      l = this.aZG;
      this.file = this.aZF.e(this.aQI.key, this.aQI.aYy + this.aZJ, l);
      this.aZH = new FileOutputStream(this.file);
      if (this.bufferSize <= 0) {
        break label161;
      }
      if (this.aZK != null) {
        break label147;
      }
      this.aZK = new q(this.aZH, this.bufferSize);
    }
    label105:
    for (this.outputStream = this.aZK;; this.outputStream = this.aZH)
    {
      this.aZI = 0L;
      AppMethodBeat.o(151945);
      return;
      l = Math.min(this.aQI.aPF - this.aZJ, this.aZG);
      break;
      this.aZK.a(this.aZH);
      break label105;
    }
  }
  
  private void qy()
  {
    AppMethodBeat.i(151946);
    if (this.outputStream == null)
    {
      AppMethodBeat.o(151946);
      return;
    }
    try
    {
      this.outputStream.flush();
      this.aZH.getFD().sync();
      x.closeQuietly(this.outputStream);
      this.outputStream = null;
      File localFile1 = this.file;
      this.file = null;
      this.aZF.k(localFile1);
      AppMethodBeat.o(151946);
      return;
    }
    finally
    {
      x.closeQuietly(this.outputStream);
      this.outputStream = null;
      File localFile2 = this.file;
      this.file = null;
      localFile2.delete();
      AppMethodBeat.o(151946);
    }
  }
  
  public final void b(j paramj)
  {
    AppMethodBeat.i(151942);
    if ((paramj.aPF == -1L) && (!paramj.ej(2)))
    {
      this.aQI = null;
      AppMethodBeat.o(151942);
      return;
    }
    this.aQI = paramj;
    this.aZJ = 0L;
    try
    {
      qx();
      AppMethodBeat.o(151942);
      return;
    }
    catch (IOException paramj)
    {
      paramj = new b.a(paramj);
      AppMethodBeat.o(151942);
      throw paramj;
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(151944);
    if (this.aQI == null)
    {
      AppMethodBeat.o(151944);
      return;
    }
    try
    {
      qy();
      AppMethodBeat.o(151944);
      return;
    }
    catch (IOException localIOException)
    {
      b.a locala = new b.a(localIOException);
      AppMethodBeat.o(151944);
      throw locala;
    }
  }
  
  public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(151943);
    if (this.aQI == null)
    {
      AppMethodBeat.o(151943);
      return;
    }
    int i = 0;
    while (i < paramInt2) {
      try
      {
        if (this.aZI == this.aZG)
        {
          qy();
          qx();
        }
        int j = (int)Math.min(paramInt2 - i, this.aZG - this.aZI);
        this.outputStream.write(paramArrayOfByte, paramInt1 + i, j);
        i += j;
        this.aZI += j;
        this.aZJ += j;
      }
      catch (IOException paramArrayOfByte)
      {
        paramArrayOfByte = new b.a(paramArrayOfByte);
        AppMethodBeat.o(151943);
        throw paramArrayOfByte;
      }
    }
    AppMethodBeat.o(151943);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.h.a.b
 * JD-Core Version:    0.7.0.1
 */