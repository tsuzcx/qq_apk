package com.bumptech.glide.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

final class c
{
  static final Charset US_ASCII;
  static final Charset UTF_8;
  
  static
  {
    AppMethodBeat.i(100646);
    US_ASCII = Charset.forName("US-ASCII");
    UTF_8 = Charset.forName("UTF-8");
    AppMethodBeat.o(100646);
  }
  
  static void closeQuietly(Closeable paramCloseable)
  {
    AppMethodBeat.i(100645);
    try
    {
      paramCloseable.close();
      AppMethodBeat.o(100645);
      return;
    }
    catch (RuntimeException paramCloseable)
    {
      AppMethodBeat.o(100645);
      throw paramCloseable;
    }
    catch (Exception paramCloseable)
    {
      AppMethodBeat.o(100645);
    }
  }
  
  static void r(File paramFile)
  {
    AppMethodBeat.i(100644);
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile == null)
    {
      paramFile = new IOException("not a readable directory: ".concat(String.valueOf(paramFile)));
      AppMethodBeat.o(100644);
      throw paramFile;
    }
    int j = arrayOfFile.length;
    int i = 0;
    while (i < j)
    {
      paramFile = arrayOfFile[i];
      if (paramFile.isDirectory()) {
        r(paramFile);
      }
      if (!paramFile.delete())
      {
        paramFile = new IOException("failed to delete file: ".concat(String.valueOf(paramFile)));
        AppMethodBeat.o(100644);
        throw paramFile;
      }
      i += 1;
    }
    AppMethodBeat.o(100644);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.a.c
 * JD-Core Version:    0.7.0.1
 */