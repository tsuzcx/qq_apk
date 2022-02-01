package com.tencent.matrix.resource.analyzer.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public final class j
  implements Serializable
{
  final List<String> bZq;
  final e cXX;
  final String cYa;
  final b cYc;
  final a cYd;
  final String className;
  final String extra;
  
  public j(String paramString1, b paramb, a parama, String paramString2, String paramString3, e parame, List<String> paramList)
  {
    this.cYa = paramString1;
    this.cYc = paramb;
    this.cYd = parama;
    this.className = paramString2;
    this.extra = paramString3;
    this.cXX = parame;
    this.bZq = Collections.unmodifiableList(new ArrayList(paramList));
  }
  
  public final String toString()
  {
    Object localObject1 = "";
    if (this.cYc == b.cYk) {
      localObject1 = "" + "static ";
    }
    if (this.cYd != a.cYh)
    {
      localObject2 = localObject1;
      if (this.cYd != a.cYg) {}
    }
    else
    {
      localObject2 = (String)localObject1 + this.cYd.name().toLowerCase(Locale.US) + " ";
    }
    localObject1 = (String)localObject2 + this.className;
    if (this.cYa != null) {}
    for (Object localObject2 = (String)localObject1 + " " + this.cYa;; localObject2 = (String)localObject1 + " instance")
    {
      localObject1 = localObject2;
      if (this.extra != null) {
        localObject1 = (String)localObject2 + " " + this.extra;
      }
      localObject2 = localObject1;
      if (this.cXX != null) {
        localObject2 = (String)localObject1 + " , matching exclusion " + this.cXX.cXU;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.matrix.resource.analyzer.model.j
 * JD-Core Version:    0.7.0.1
 */