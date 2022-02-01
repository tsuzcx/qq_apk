package com.tencent.matrix.resource.analyzer.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public final class j
  implements Serializable
{
  final String className;
  final e cyM;
  final String cyP;
  final b cyR;
  final a cyS;
  final List<String> cyT;
  final String extra;
  
  public j(String paramString1, b paramb, a parama, String paramString2, String paramString3, e parame, List<String> paramList)
  {
    this.cyP = paramString1;
    this.cyR = paramb;
    this.cyS = parama;
    this.className = paramString2;
    this.extra = paramString3;
    this.cyM = parame;
    this.cyT = Collections.unmodifiableList(new ArrayList(paramList));
  }
  
  public final String toString()
  {
    Object localObject1 = "";
    if (this.cyR == b.cza) {
      localObject1 = "" + "static ";
    }
    if (this.cyS != a.cyX)
    {
      localObject2 = localObject1;
      if (this.cyS != a.cyW) {}
    }
    else
    {
      localObject2 = (String)localObject1 + this.cyS.name().toLowerCase(Locale.US) + " ";
    }
    localObject1 = (String)localObject2 + this.className;
    if (this.cyP != null) {}
    for (Object localObject2 = (String)localObject1 + " " + this.cyP;; localObject2 = (String)localObject1 + " instance")
    {
      localObject1 = localObject2;
      if (this.extra != null) {
        localObject1 = (String)localObject2 + " " + this.extra;
      }
      localObject2 = localObject1;
      if (this.cyM != null) {
        localObject2 = (String)localObject1 + " , matching exclusion " + this.cyM.cyJ;
      }
      return localObject2;
    }
  }
  
  public static enum a
  {
    private a() {}
  }
  
  public static enum b
  {
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.resource.analyzer.model.j
 * JD-Core Version:    0.7.0.1
 */