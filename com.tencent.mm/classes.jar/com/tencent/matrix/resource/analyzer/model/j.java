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
  final e cvV;
  final String cvY;
  final b cwa;
  final a cwb;
  final List<String> cwc;
  final String extra;
  
  public j(String paramString1, b paramb, a parama, String paramString2, String paramString3, e parame, List<String> paramList)
  {
    this.cvY = paramString1;
    this.cwa = paramb;
    this.cwb = parama;
    this.className = paramString2;
    this.extra = paramString3;
    this.cvV = parame;
    this.cwc = Collections.unmodifiableList(new ArrayList(paramList));
  }
  
  public final String toString()
  {
    Object localObject1 = "";
    if (this.cwa == b.cwj) {
      localObject1 = "" + "static ";
    }
    if (this.cwb != a.cwg)
    {
      localObject2 = localObject1;
      if (this.cwb != a.cwf) {}
    }
    else
    {
      localObject2 = (String)localObject1 + this.cwb.name().toLowerCase(Locale.US) + " ";
    }
    localObject1 = (String)localObject2 + this.className;
    if (this.cvY != null) {}
    for (Object localObject2 = (String)localObject1 + " " + this.cvY;; localObject2 = (String)localObject1 + " instance")
    {
      localObject1 = localObject2;
      if (this.extra != null) {
        localObject1 = (String)localObject2 + " " + this.extra;
      }
      localObject2 = localObject1;
      if (this.cvV != null) {
        localObject2 = (String)localObject1 + " , matching exclusion " + this.cvV.cvS;
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