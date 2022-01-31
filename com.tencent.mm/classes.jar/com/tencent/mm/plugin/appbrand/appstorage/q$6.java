package com.tencent.mm.plugin.appbrand.appstorage;

import java.io.File;

final class q$6
  extends q.b
{
  q$6(q paramq)
  {
    super(paramq, (byte)0);
  }
  
  public final h x(File paramFile)
  {
    if (!paramFile.exists()) {
      return h.fHa;
    }
    if (paramFile.isDirectory()) {
      return h.fGU;
    }
    return h.fHc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.q.6
 * JD-Core Version:    0.7.0.1
 */