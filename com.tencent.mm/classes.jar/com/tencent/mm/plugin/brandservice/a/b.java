package com.tencent.mm.plugin.brandservice.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.kernel.c.a;
import java.util.List;

public abstract interface b
  extends a
{
  public abstract boolean GI(String paramString);
  
  public abstract void GJ(String paramString);
  
  public abstract long GK(String paramString);
  
  public abstract void a(String paramString, int paramInt1, int paramInt2, Object... paramVarArgs);
  
  public abstract boolean a(Context paramContext, String paramString, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, Intent paramIntent);
  
  public abstract boolean a(Context paramContext, String paramString, int paramInt1, boolean paramBoolean, int paramInt2, Intent paramIntent, int paramInt3, b.a parama);
  
  public abstract boolean aWl();
  
  public abstract boolean aWm();
  
  public abstract String aWn();
  
  public abstract void aWo();
  
  public abstract void i(List<List<String>> paramList, int paramInt);
  
  public abstract void j(List<String[]> paramList, int paramInt);
  
  public abstract boolean rT(int paramInt);
  
  public abstract boolean rU(int paramInt);
  
  public abstract void rV(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.a.b
 * JD-Core Version:    0.7.0.1
 */