package com.tencent.matrix.e;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

final class a$1
  implements FileFilter
{
  public final boolean accept(File paramFile)
  {
    return Pattern.matches("cpu[0-9]", paramFile.getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.e.a.1
 * JD-Core Version:    0.7.0.1
 */