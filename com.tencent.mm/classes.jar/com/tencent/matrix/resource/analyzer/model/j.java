package com.tencent.matrix.resource.analyzer.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public final class j
  implements Serializable
{
  final List<String> caT;
  final String className;
  final e dbX;
  final String dca;
  final b dcc;
  final a dcd;
  final String extra;
  
  public j(String paramString1, b paramb, a parama, String paramString2, String paramString3, e parame, List<String> paramList)
  {
    this.dca = paramString1;
    this.dcc = paramb;
    this.dcd = parama;
    this.className = paramString2;
    this.extra = paramString3;
    this.dbX = parame;
    this.caT = Collections.unmodifiableList(new ArrayList(paramList));
  }
  
  public final String toString()
  {
    Object localObject1 = "";
    if (this.dcc == b.dck) {
      localObject1 = "" + "static ";
    }
    if (this.dcd != a.dch)
    {
      localObject2 = localObject1;
      if (this.dcd != a.dcg) {}
    }
    else
    {
      localObject2 = (String)localObject1 + this.dcd.name().toLowerCase(Locale.US) + " ";
    }
    localObject1 = (String)localObject2 + this.className;
    if (this.dca != null) {}
    for (Object localObject2 = (String)localObject1 + " " + this.dca;; localObject2 = (String)localObject1 + " instance")
    {
      localObject1 = localObject2;
      if (this.extra != null) {
        localObject1 = (String)localObject2 + " " + this.extra;
      }
      localObject2 = localObject1;
      if (this.dbX != null) {
        localObject2 = (String)localObject1 + " , matching exclusion " + this.dbX.dbV;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.matrix.resource.analyzer.model.j
 * JD-Core Version:    0.7.0.1
 */