package com.tencent.matrix.resource.analyzer.model;

import com.tencent.matrix.resource.a.a.b;
import java.io.File;
import java.io.Serializable;

public final class a
  implements Serializable
{
  public final File bOU;
  public final String bOV;
  public final String mActivityName;
  
  public a(File paramFile, String paramString1, String paramString2)
  {
    this.bOU = ((File)b.d(paramFile, "hprofFile"));
    this.bOV = ((String)b.d(paramString1, "refKey"));
    this.mActivityName = ((String)b.d(paramString2, "activityName"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.resource.analyzer.model.a
 * JD-Core Version:    0.7.0.1
 */