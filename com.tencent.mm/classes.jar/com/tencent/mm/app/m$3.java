package com.tencent.mm.app;

import android.content.Context;
import java.io.File;
import java.io.FilenameFilter;

final class m$3
  implements FilenameFilter
{
  String bYA = this.val$context.getPackageName();
  
  m$3(m paramm, Context paramContext) {}
  
  public final boolean accept(File paramFile, String paramString)
  {
    return (paramString.startsWith(this.bYA)) || (paramString.startsWith("java_" + this.bYA));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.app.m.3
 * JD-Core Version:    0.7.0.1
 */