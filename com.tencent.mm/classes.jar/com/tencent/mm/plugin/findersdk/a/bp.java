package com.tencent.mm.plugin.findersdk.a;

import android.content.Context;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.protocal.protobuf.bqh;
import com.tencent.mm.protocal.protobuf.bqi;
import java.util.LinkedList;
import java.util.List;

public abstract interface bp
  extends a
{
  public abstract void a(Context paramContext, int paramInt1, String paramString, int paramInt2, a parama);
  
  public abstract void a(Context paramContext, int paramInt1, String paramString1, String paramString2, Long paramLong, int paramInt2, a parama);
  
  public abstract void a(Context paramContext, String paramString, a parama);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, a parama);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, Long paramLong1, Long paramLong2, boolean paramBoolean, a parama);
  
  public abstract void a(LinkedList<bqh> paramLinkedList, b paramb);
  
  public abstract String aAw(String paramString);
  
  public abstract String aAx(String paramString);
  
  public abstract boolean aAy(String paramString);
  
  public abstract void b(Context paramContext, String paramString1, String paramString2, a parama);
  
  public abstract String eI(String paramString, int paramInt);
  
  public static abstract interface a
  {
    public abstract void onDone(String paramString1, int paramInt1, int paramInt2, String paramString2);
  }
  
  public static abstract interface b
  {
    public abstract void onDone(List<bqi> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.a.bp
 * JD-Core Version:    0.7.0.1
 */