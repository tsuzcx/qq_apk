package com.tencent.matrix.openglleak.statistics.resource;

import java.util.LinkedList;
import java.util.List;

public final class d
  implements ResRecordManager.a
{
  public final List<c> eXW = new LinkedList();
  
  public final void b(c paramc)
  {
    synchronized (this.eXW)
    {
      this.eXW.add(paramc);
      return;
    }
  }
  
  public final void c(c paramc)
  {
    synchronized (this.eXW)
    {
      this.eXW.remove(paramc);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.openglleak.statistics.resource.d
 * JD-Core Version:    0.7.0.1
 */