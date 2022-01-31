package com.tencent.mm.ay;

import com.tencent.mm.plugin.messenger.foundation.a.a.i.b;
import com.tencent.mm.protocal.c.asy;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Deprecated
public final class g
  extends i.b
{
  private asy ewb;
  
  public g(List<g.a> paramList)
  {
    super(36);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      localLinkedList.add(((g.a)localIterator.next()).ewc);
    }
    this.ewb = new asy();
    this.ewb.hPS = paramList.size();
    this.ewb.hPT = localLinkedList;
    this.mdD = this.ewb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ay.g
 * JD-Core Version:    0.7.0.1
 */