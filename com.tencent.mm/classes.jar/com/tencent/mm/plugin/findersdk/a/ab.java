package com.tencent.mm.plugin.findersdk.a;

import android.content.Context;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.protocal.protobuf.bfe;
import com.tencent.mm.protocal.protobuf.bff;
import java.util.LinkedList;
import java.util.List;

public abstract interface ab
  extends a
{
  public abstract void a(Context paramContext, int paramInt1, String paramString, int paramInt2, a parama);
  
  public abstract void a(Context paramContext, int paramInt1, String paramString1, String paramString2, Long paramLong, int paramInt2, a parama);
  
  public abstract void a(Context paramContext, String paramString, a parama);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, a parama);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, Long paramLong1, Long paramLong2, a parama);
  
  public abstract void a(LinkedList<bfe> paramLinkedList, b paramb);
  
  public abstract String aED(String paramString);
  
  public abstract String aEE(String paramString);
  
  public abstract boolean aEF(String paramString);
  
  public abstract String dX(String paramString, int paramInt);
  
  public static abstract interface a
  {
    public abstract void l(String paramString1, int paramInt1, int paramInt2, String paramString2);
  }
  
  public static abstract interface b
  {
    public abstract void eK(List<bff> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.a.ab
 * JD-Core Version:    0.7.0.1
 */