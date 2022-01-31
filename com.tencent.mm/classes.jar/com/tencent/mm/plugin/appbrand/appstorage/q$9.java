package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.mm.plugin.appbrand.u.k;
import java.io.File;
import java.util.LinkedList;
import java.util.regex.Pattern;

final class q$9
  implements q.a
{
  q$9(q paramq) {}
  
  public final h a(File paramFile, Object... paramVarArgs)
  {
    if (!paramFile.isDirectory()) {
      return h.fHc;
    }
    if (i.w(paramFile)) {
      return h.fHe;
    }
    LinkedList localLinkedList = new LinkedList();
    paramFile.listFiles(new q.9.1(this, Pattern.quote(paramFile.getAbsolutePath()), localLinkedList));
    ((k)paramVarArgs[0]).value = localLinkedList;
    return h.fGU;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.q.9
 * JD-Core Version:    0.7.0.1
 */