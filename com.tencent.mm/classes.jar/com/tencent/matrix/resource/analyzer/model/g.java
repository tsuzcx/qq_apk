package com.tencent.matrix.resource.analyzer.model;

import com.d.a.b.h;
import com.d.a.b.l;
import com.tencent.matrix.resource.analyzer.a.a;
import java.io.File;

public final class g
{
  public final l cks;
  private final File dbW;
  
  public g(File paramFile)
  {
    this.dbW = ((File)com.tencent.matrix.resource.a.a.b.c(paramFile, "hprofFile"));
    paramFile = new h(new com.d.a.b.a.b(paramFile, (byte)0)).La();
    a.a(paramFile);
    this.cks = paramFile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.resource.analyzer.model.g
 * JD-Core Version:    0.7.0.1
 */