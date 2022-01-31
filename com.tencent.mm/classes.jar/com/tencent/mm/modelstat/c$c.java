package com.tencent.mm.modelstat;

import android.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;

final class c$c
{
  int dCy;
  long eCv;
  float eCw;
  String eCx;
  ArrayList<Pair<String, Boolean>> eCy = new ArrayList();
  ArrayList<Pair<String, String>> eCz = new ArrayList();
  int id;
  String name;
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ReportConfigEvent{");
    localStringBuilder.append("id=" + this.id);
    localStringBuilder.append(", name='" + this.name + "'");
    localStringBuilder.append(", expireTime=" + this.eCv);
    localStringBuilder.append(", rate=" + this.eCw);
    localStringBuilder.append(", logId=" + this.dCy);
    localStringBuilder.append(", pagesType='" + this.eCx + "'");
    localStringBuilder.append(", pageList=[");
    Iterator localIterator = this.eCy.iterator();
    Pair localPair;
    while (localIterator.hasNext())
    {
      localPair = (Pair)localIterator.next();
      localStringBuilder.append("{" + (String)localPair.first + "," + localPair.second + "}");
      localStringBuilder.append(",");
    }
    localStringBuilder.append("]");
    localStringBuilder.append(", specialPVPages=[");
    localIterator = this.eCz.iterator();
    while (localIterator.hasNext())
    {
      localPair = (Pair)localIterator.next();
      localStringBuilder.append("{" + (String)localPair.first + "," + (String)localPair.second + "}");
      localStringBuilder.append(",");
    }
    localStringBuilder.append("]}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelstat.c.c
 * JD-Core Version:    0.7.0.1
 */