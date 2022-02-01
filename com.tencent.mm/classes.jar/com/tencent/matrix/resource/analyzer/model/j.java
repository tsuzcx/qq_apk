package com.tencent.matrix.resource.analyzer.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public final class j
  implements Serializable
{
  final e cGQ;
  final String cGT;
  final b cGV;
  final a cGW;
  final List<String> cGX;
  final String className;
  final String extra;
  
  public j(String paramString1, b paramb, a parama, String paramString2, String paramString3, e parame, List<String> paramList)
  {
    this.cGT = paramString1;
    this.cGV = paramb;
    this.cGW = parama;
    this.className = paramString2;
    this.extra = paramString3;
    this.cGQ = parame;
    this.cGX = Collections.unmodifiableList(new ArrayList(paramList));
  }
  
  public final String toString()
  {
    Object localObject1 = "";
    if (this.cGV == b.cHe) {
      localObject1 = "" + "static ";
    }
    if (this.cGW != a.cHb)
    {
      localObject2 = localObject1;
      if (this.cGW != a.cHa) {}
    }
    else
    {
      localObject2 = (String)localObject1 + this.cGW.name().toLowerCase(Locale.US) + " ";
    }
    localObject1 = (String)localObject2 + this.className;
    if (this.cGT != null) {}
    for (Object localObject2 = (String)localObject1 + " " + this.cGT;; localObject2 = (String)localObject1 + " instance")
    {
      localObject1 = localObject2;
      if (this.extra != null) {
        localObject1 = (String)localObject2 + " " + this.extra;
      }
      localObject2 = localObject1;
      if (this.cGQ != null) {
        localObject2 = (String)localObject1 + " , matching exclusion " + this.cGQ.cGN;
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