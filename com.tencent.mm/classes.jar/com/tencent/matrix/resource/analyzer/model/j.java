package com.tencent.matrix.resource.analyzer.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public final class j
  implements Serializable
{
  final String cHC;
  final j.b cHE;
  final a cHF;
  final List<String> cHG;
  final e cHz;
  final String className;
  final String extra;
  
  public j(String paramString1, j.b paramb, a parama, String paramString2, String paramString3, e parame, List<String> paramList)
  {
    this.cHC = paramString1;
    this.cHE = paramb;
    this.cHF = parama;
    this.className = paramString2;
    this.extra = paramString3;
    this.cHz = parame;
    this.cHG = Collections.unmodifiableList(new ArrayList(paramList));
  }
  
  public final String toString()
  {
    Object localObject1 = "";
    if (this.cHE == j.b.cHN) {
      localObject1 = "" + "static ";
    }
    if (this.cHF != a.cHK)
    {
      localObject2 = localObject1;
      if (this.cHF != a.cHJ) {}
    }
    else
    {
      localObject2 = (String)localObject1 + this.cHF.name().toLowerCase(Locale.US) + " ";
    }
    localObject1 = (String)localObject2 + this.className;
    if (this.cHC != null) {}
    for (Object localObject2 = (String)localObject1 + " " + this.cHC;; localObject2 = (String)localObject1 + " instance")
    {
      localObject1 = localObject2;
      if (this.extra != null) {
        localObject1 = (String)localObject2 + " " + this.extra;
      }
      localObject2 = localObject1;
      if (this.cHz != null) {
        localObject2 = (String)localObject1 + " , matching exclusion " + this.cHz.cHw;
      }
      return localObject2;
    }
  }
  
  public static enum a
  {
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.matrix.resource.analyzer.model.j
 * JD-Core Version:    0.7.0.1
 */