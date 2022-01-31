package com.tencent.mm.app;

import android.content.Context;
import java.io.File;
import java.io.FilenameFilter;

final class k$3
  implements FilenameFilter
{
  String bwQ = this.val$context.getPackageName();
  
  k$3(k paramk, Context paramContext) {}
  
  public final boolean accept(File paramFile, String paramString)
  {
    return paramString.startsWith(this.bwQ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.k.3
 * JD-Core Version:    0.7.0.1
 */