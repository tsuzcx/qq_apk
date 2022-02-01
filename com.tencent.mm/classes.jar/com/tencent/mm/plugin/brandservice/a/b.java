package com.tencent.mm.plugin.brandservice.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ah.p;
import com.tencent.mm.ah.q;
import com.tencent.mm.ah.y;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.kernel.c.a;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public abstract interface b
  extends a
{
  public abstract boolean D(Object paramObject1, Object paramObject2);
  
  public abstract boolean Tg(String paramString);
  
  public abstract p Th(String paramString);
  
  public abstract void Ti(String paramString);
  
  public abstract long Tj(String paramString);
  
  public abstract String Tk(String paramString);
  
  public abstract void Tl(String paramString);
  
  public abstract void a(Context paramContext, JSONObject paramJSONObject, HashMap<String, Object> paramHashMap);
  
  public abstract void a(b paramb);
  
  public abstract void a(String paramString, int paramInt1, int paramInt2, Object... paramVarArgs);
  
  public abstract void a(String paramString1, y paramy, String paramString2, d<Bundle> paramd);
  
  public abstract boolean a(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, Intent paramIntent);
  
  public abstract boolean a(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, Intent paramIntent, int paramInt4, a parama);
  
  public abstract boolean bIO();
  
  public abstract boolean bIP();
  
  public abstract boolean bIQ();
  
  public abstract String bIR();
  
  public abstract void bIS();
  
  public abstract String bIT();
  
  public abstract void cb(List<q> paramList);
  
  public abstract void cp(String paramString, int paramInt);
  
  public abstract void cq(String paramString, int paramInt);
  
  public abstract String d(String paramString, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void i(List<List<String>> paramList, int paramInt);
  
  public abstract boolean isMpUrl(String paramString);
  
  public abstract void j(List<String[]> paramList, int paramInt);
  
  public abstract void k(List<q> paramList, int paramInt);
  
  public abstract boolean yr(int paramInt);
  
  public abstract boolean ys(int paramInt);
  
  public abstract void yt(int paramInt);
  
  public abstract boolean yu(int paramInt);
  
  public static final class a
  {
    public String message;
    public boolean success = false;
  }
  
  public static abstract interface b
  {
    public abstract void onSuccess(String paramString);
    
    public abstract void p(int paramInt1, int paramInt2, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.a.b
 * JD-Core Version:    0.7.0.1
 */