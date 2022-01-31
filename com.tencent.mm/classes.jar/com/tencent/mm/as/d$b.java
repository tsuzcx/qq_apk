package com.tencent.mm.as;

import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import java.util.List;

final class d$b
{
  private int auK = 0;
  public long dqO;
  public long enj;
  public int enk;
  public int enl;
  public List<d.c> enm;
  
  public d$b(long paramLong1, long paramLong2, int paramInt)
  {
    this.enj = paramLong1;
    this.dqO = paramLong2;
    this.enk = paramInt;
    this.enl = 0;
  }
  
  public final boolean a(d.a parama, Object paramObject)
  {
    if (this.enm == null) {
      this.enm = new LinkedList();
    }
    parama = new d.c(parama, paramObject);
    if (this.enm.contains(parama))
    {
      y.d("ModelImage.DownloadImgService.Task", "task item already exists");
      return false;
    }
    this.enm.add(parama);
    return true;
  }
  
  public final boolean b(d.a parama)
  {
    parama = new d.c(parama, null);
    if (this.enm.contains(parama))
    {
      this.enm.remove(parama);
      return true;
    }
    return false;
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof b))) {}
    do
    {
      return false;
      paramObject = (b)paramObject;
    } while ((paramObject.enj != this.enj) || (paramObject.dqO != this.dqO) || (paramObject.enk != this.enk));
    return true;
  }
  
  public final int hashCode()
  {
    if (this.auK == 0) {
      this.auK = (this.enj + "_" + this.dqO + "_" + this.enk).hashCode();
    }
    return this.auK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.as.d.b
 * JD-Core Version:    0.7.0.1
 */