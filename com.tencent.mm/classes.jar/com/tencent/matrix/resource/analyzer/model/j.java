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
  final List<String> dVu;
  final String extra;
  final String faA;
  final b faC;
  final a faD;
  final e fax;
  
  public j(String paramString1, b paramb, a parama, String paramString2, String paramString3, e parame, List<String> paramList)
  {
    this.faA = paramString1;
    this.faC = paramb;
    this.faD = parama;
    this.className = paramString2;
    this.extra = paramString3;
    this.fax = parame;
    this.dVu = Collections.unmodifiableList(new ArrayList(paramList));
  }
  
  public final String toString()
  {
    Object localObject1 = "";
    if (this.faC == b.faK) {
      localObject1 = "" + "static ";
    }
    if (this.faD != a.faH)
    {
      localObject2 = localObject1;
      if (this.faD != a.faG) {}
    }
    else
    {
      localObject2 = (String)localObject1 + this.faD.name().toLowerCase(Locale.US) + " ";
    }
    localObject1 = (String)localObject2 + this.className;
    if (this.faA != null) {}
    for (Object localObject2 = (String)localObject1 + " " + this.faA;; localObject2 = (String)localObject1 + " instance")
    {
      localObject1 = localObject2;
      if (this.extra != null) {
        localObject1 = (String)localObject2 + " " + this.extra;
      }
      localObject2 = localObject1;
      if (this.fax != null) {
        localObject2 = (String)localObject1 + " , matching exclusion " + this.fax.fau;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.matrix.resource.analyzer.model.j
 * JD-Core Version:    0.7.0.1
 */