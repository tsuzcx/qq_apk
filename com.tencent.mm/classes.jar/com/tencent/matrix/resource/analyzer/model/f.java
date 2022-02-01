package com.tencent.matrix.resource.analyzer.model;

import com.tencent.matrix.resource.a.a.b;
import java.io.File;
import java.io.Serializable;

public final class f
  implements Serializable
{
  public final String cGt;
  public final File cHx;
  public final String mActivityName;
  
  public f(File paramFile, String paramString1, String paramString2)
  {
    this.cHx = ((File)b.checkNotNull(paramFile, "hprofFile"));
    this.cGt = ((String)b.checkNotNull(paramString1, "refKey"));
    this.mActivityName = ((String)b.checkNotNull(paramString2, "activityName"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.resource.analyzer.model.f
 * JD-Core Version:    0.7.0.1
 */