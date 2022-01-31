package com.google.android.exoplayer2.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

public final class b
{
  public final File baB;
  public final File baC;
  
  public b(File paramFile)
  {
    AppMethodBeat.i(152026);
    this.baB = paramFile;
    this.baC = new File(paramFile.getPath() + ".bak");
    AppMethodBeat.o(152026);
  }
  
  public final OutputStream qG()
  {
    AppMethodBeat.i(152027);
    if (this.baB.exists())
    {
      if (this.baC.exists()) {
        break label87;
      }
      if (!this.baB.renameTo(this.baC)) {
        new StringBuilder("Couldn't rename file ").append(this.baB).append(" to backup file ").append(this.baC);
      }
    }
    try
    {
      for (;;)
      {
        b.a locala = new b.a(this.baB);
        AppMethodBeat.o(152027);
        return locala;
        label87:
        this.baB.delete();
      }
    }
    catch (FileNotFoundException localFileNotFoundException1)
    {
      for (;;)
      {
        Object localObject;
        if (!this.baB.getParentFile().mkdirs())
        {
          localObject = new IOException("Couldn't create directory " + this.baB);
          AppMethodBeat.o(152027);
          throw ((Throwable)localObject);
        }
        try
        {
          localObject = new b.a(this.baB);
        }
        catch (FileNotFoundException localFileNotFoundException2)
        {
          IOException localIOException = new IOException("Couldn't create " + this.baB);
          AppMethodBeat.o(152027);
          throw localIOException;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.i.b
 * JD-Core Version:    0.7.0.1
 */