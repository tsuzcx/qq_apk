package com.google.android.exoplayer2.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class b
{
  public final File bGy;
  public final File bGz;
  
  public b(File paramFile)
  {
    AppMethodBeat.i(93119);
    this.bGy = paramFile;
    this.bGz = new File(paramFile.getPath() + ".bak");
    AppMethodBeat.o(93119);
  }
  
  public final OutputStream wQ()
  {
    AppMethodBeat.i(93120);
    if (this.bGy.exists())
    {
      if (this.bGz.exists()) {
        break label87;
      }
      if (!this.bGy.renameTo(this.bGz)) {
        new StringBuilder("Couldn't rename file ").append(this.bGy).append(" to backup file ").append(this.bGz);
      }
    }
    try
    {
      for (;;)
      {
        a locala = new a(this.bGy);
        AppMethodBeat.o(93120);
        return locala;
        label87:
        this.bGy.delete();
      }
    }
    catch (FileNotFoundException localFileNotFoundException1)
    {
      for (;;)
      {
        Object localObject;
        if (!this.bGy.getParentFile().mkdirs())
        {
          localObject = new IOException("Couldn't create directory " + this.bGy);
          AppMethodBeat.o(93120);
          throw ((Throwable)localObject);
        }
        try
        {
          localObject = new a(this.bGy);
        }
        catch (FileNotFoundException localFileNotFoundException2)
        {
          IOException localIOException = new IOException("Couldn't create " + this.bGy);
          AppMethodBeat.o(93120);
          throw localIOException;
        }
      }
    }
  }
  
  static final class a
    extends OutputStream
  {
    private final FileOutputStream bGA;
    private boolean closed;
    
    public a(File paramFile)
    {
      AppMethodBeat.i(93113);
      this.closed = false;
      this.bGA = new FileOutputStream(paramFile);
      AppMethodBeat.o(93113);
    }
    
    public final void close()
    {
      AppMethodBeat.i(93114);
      if (this.closed)
      {
        AppMethodBeat.o(93114);
        return;
      }
      this.closed = true;
      flush();
      try
      {
        this.bGA.getFD().sync();
        label37:
        this.bGA.close();
        AppMethodBeat.o(93114);
        return;
      }
      catch (IOException localIOException)
      {
        break label37;
      }
    }
    
    public final void flush()
    {
      AppMethodBeat.i(93115);
      this.bGA.flush();
      AppMethodBeat.o(93115);
    }
    
    public final void write(int paramInt)
    {
      AppMethodBeat.i(93116);
      this.bGA.write(paramInt);
      AppMethodBeat.o(93116);
    }
    
    public final void write(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(93117);
      this.bGA.write(paramArrayOfByte);
      AppMethodBeat.o(93117);
    }
    
    public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(93118);
      this.bGA.write(paramArrayOfByte, paramInt1, paramInt2);
      AppMethodBeat.o(93118);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.i.b
 * JD-Core Version:    0.7.0.1
 */