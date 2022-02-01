package com.tencent.mm.plugin.i.a;

import android.content.Context;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.protocal.protobuf.azi;
import com.tencent.mm.protocal.protobuf.azj;
import java.util.LinkedList;
import java.util.List;

public abstract interface aa
  extends a
{
  public abstract void a(Context paramContext, int paramInt, String paramString1, String paramString2, Long paramLong, a parama);
  
  public abstract void a(Context paramContext, String paramString, a parama);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, a parama);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, Long paramLong1, Long paramLong2, a parama);
  
  public abstract void a(LinkedList<azi> paramLinkedList, b paramb);
  
  public abstract String avi(String paramString);
  
  public abstract String avj(String paramString);
  
  public abstract String avk(String paramString);
  
  public abstract boolean avl(String paramString);
  
  public static abstract interface a
  {
    public abstract void j(String paramString1, int paramInt1, int paramInt2, String paramString2);
  }
  
  public static abstract interface b
  {
    public abstract void er(List<azj> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.i.a.aa
 * JD-Core Version:    0.7.0.1
 */