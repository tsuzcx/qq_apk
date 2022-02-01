package com.tencent.mm.plugin.gamelive;

import android.content.Context;
import com.tencent.mm.kernel.c.a;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public abstract interface b
  extends a
{
  public abstract void A(Boolean paramBoolean);
  
  public abstract void a(Context paramContext, String paramString, int paramInt, Runnable paramRunnable);
  
  public abstract void a(Context paramContext, String paramString, int paramInt, JSONObject paramJSONObject, a parama);
  
  public abstract void a(c paramc);
  
  public abstract void a(d paramd);
  
  public abstract void a(b.g paramg);
  
  public abstract void a(Object paramObject, Context paramContext, String paramString, int paramInt);
  
  public abstract void a(String paramString, int paramInt, Context paramContext);
  
  public abstract void a(String paramString, int paramInt1, Context paramContext, int paramInt2, b paramb);
  
  public abstract void a(String paramString, int paramInt, Context paramContext, b.f paramf);
  
  public abstract void a(String paramString1, int paramInt, Context paramContext, String paramString2, String paramString3);
  
  public abstract void a(String paramString, e parame);
  
  public abstract void aHH(String paramString);
  
  public abstract void b(Boolean paramBoolean, int paramInt);
  
  public abstract void fA(String paramString, int paramInt);
  
  public abstract void fIF();
  
  public abstract void fIH();
  
  public abstract Boolean fII();
  
  public abstract void g(String paramString, Context paramContext);
  
  public abstract void n(Context paramContext, String paramString, int paramInt);
  
  public static abstract interface a
  {
    public abstract void getCgiStatus(int paramInt1, int paramInt2, boolean paramBoolean);
  }
  
  public static abstract interface b
  {
    public abstract void AJ(int paramInt);
  }
  
  public static abstract interface c
  {
    public abstract void callback(int paramInt, String paramString);
  }
  
  public static abstract interface d
  {
    public abstract void dm(List<Map<String, Object>> paramList);
  }
  
  public static abstract interface e
  {
    public abstract void callback(Boolean paramBoolean, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelive.b
 * JD-Core Version:    0.7.0.1
 */