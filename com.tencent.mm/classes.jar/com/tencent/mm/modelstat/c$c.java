package com.tencent.mm.modelstat;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

final class c$c
{
  int ezN;
  long fSm;
  float fSn;
  String fSo;
  ArrayList<Pair<String, Boolean>> fSp;
  ArrayList<Pair<String, String>> fSq;
  int id;
  String name;
  
  private c$c()
  {
    AppMethodBeat.i(78667);
    this.fSp = new ArrayList();
    this.fSq = new ArrayList();
    AppMethodBeat.o(78667);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(78668);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ReportConfigEvent{");
    ((StringBuilder)localObject).append("id=" + this.id);
    ((StringBuilder)localObject).append(", name='" + this.name + "'");
    ((StringBuilder)localObject).append(", expireTime=" + this.fSm);
    ((StringBuilder)localObject).append(", rate=" + this.fSn);
    ((StringBuilder)localObject).append(", logId=" + this.ezN);
    ((StringBuilder)localObject).append(", pagesType='" + this.fSo + "'");
    ((StringBuilder)localObject).append(", pageList=[");
    Iterator localIterator = this.fSp.iterator();
    Pair localPair;
    while (localIterator.hasNext())
    {
      localPair = (Pair)localIterator.next();
      ((StringBuilder)localObject).append("{" + (String)localPair.first + "," + localPair.second + "}");
      ((StringBuilder)localObject).append(",");
    }
    ((StringBuilder)localObject).append("]");
    ((StringBuilder)localObject).append(", specialPVPages=[");
    localIterator = this.fSq.iterator();
    while (localIterator.hasNext())
    {
      localPair = (Pair)localIterator.next();
      ((StringBuilder)localObject).append("{" + (String)localPair.first + "," + (String)localPair.second + "}");
      ((StringBuilder)localObject).append(",");
    }
    ((StringBuilder)localObject).append("]}");
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(78668);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelstat.c.c
 * JD-Core Version:    0.7.0.1
 */