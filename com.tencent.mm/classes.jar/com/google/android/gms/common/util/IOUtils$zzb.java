package com.google.android.gms.common.util;

import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileInputStream;
import java.nio.channels.FileChannel;

final class IOUtils$zzb
{
  private final File file;
  
  private IOUtils$zzb(File paramFile)
  {
    AppMethodBeat.i(90219);
    this.file = ((File)Preconditions.checkNotNull(paramFile));
    AppMethodBeat.o(90219);
  }
  
  public final byte[] zzdd()
  {
    AppMethodBeat.i(90220);
    try
    {
      FileInputStream localFileInputStream = new FileInputStream(this.file);
      byte[] arrayOfByte;
      IOUtils.closeQuietly(localFileInputStream);
    }
    finally
    {
      try
      {
        arrayOfByte = IOUtils.zzb(localFileInputStream, localFileInputStream.getChannel().size());
        IOUtils.closeQuietly(localFileInputStream);
        AppMethodBeat.o(90220);
        return arrayOfByte;
      }
      finally {}
      localObject1 = finally;
      localFileInputStream = null;
    }
    AppMethodBeat.o(90220);
    throw localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.util.IOUtils.zzb
 * JD-Core Version:    0.7.0.1
 */