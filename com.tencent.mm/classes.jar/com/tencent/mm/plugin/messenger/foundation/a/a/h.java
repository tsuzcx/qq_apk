package com.tencent.mm.plugin.messenger.foundation.a.a;

import com.tencent.mm.kernel.c.a;
import com.tencent.mm.protocal.protobuf.dzc;
import java.util.ArrayList;
import java.util.LinkedList;

public abstract interface h
  extends a
{
  public abstract void a(int paramInt, h.b paramb);
  
  public abstract void a(a parama);
  
  public abstract void a(ArrayList<k.b> paramArrayList, a parama);
  
  public abstract void b(int paramInt, h.b paramb);
  
  public abstract void b(a parama);
  
  public abstract void b(k.b paramb);
  
  public abstract void y(ArrayList<k.b> paramArrayList);
  
  public static abstract interface a
  {
    public abstract void onOpLogResult(LinkedList<Integer> paramLinkedList, LinkedList<dzc> paramLinkedList1, ArrayList<k.b> paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.a.a.h
 * JD-Core Version:    0.7.0.1
 */