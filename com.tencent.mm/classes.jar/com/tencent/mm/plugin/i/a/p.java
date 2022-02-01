package com.tencent.mm.plugin.i.a;

import com.tencent.mm.kernel.c.a;
import com.tencent.mm.protocal.protobuf.apu;
import com.tencent.mm.protocal.protobuf.apv;
import java.util.LinkedList;
import java.util.List;

public abstract interface p
  extends a
{
  public abstract void a(String paramString, a parama);
  
  public abstract void a(String paramString1, String paramString2, a parama);
  
  public abstract void a(String paramString1, String paramString2, Long paramLong1, Long paramLong2, a parama);
  
  public abstract void a(LinkedList<apu> paramLinkedList, b paramb);
  
  public abstract String aii(String paramString);
  
  public abstract String aij(String paramString);
  
  public abstract String aik(String paramString);
  
  public abstract boolean ail(String paramString);
  
  public static abstract interface a
  {
    public abstract void j(String paramString1, int paramInt1, int paramInt2, String paramString2);
  }
  
  public static abstract interface b
  {
    public abstract void dH(List<apv> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.i.a.p
 * JD-Core Version:    0.7.0.1
 */