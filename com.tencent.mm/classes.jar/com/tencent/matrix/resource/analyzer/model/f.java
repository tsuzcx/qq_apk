package com.tencent.matrix.resource.analyzer.model;

import com.tencent.matrix.resource.a.a.b;
import java.io.File;
import java.io.Serializable;

public final class f
  implements Serializable
{
  public final String daR;
  public final File dbW;
  public final String mActivityName;
  
  public f(File paramFile, String paramString1, String paramString2)
  {
    this.dbW = ((File)b.c(paramFile, "hprofFile"));
    this.daR = ((String)b.c(paramString1, "refKey"));
    this.mActivityName = ((String)b.c(paramString2, "activityName"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.resource.analyzer.model.f
 * JD-Core Version:    0.7.0.1
 */