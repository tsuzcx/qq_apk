package com.tencent.mm.plugin.brandservice.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ai.p;
import com.tencent.mm.ai.q;
import com.tencent.mm.ai.y;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.kernel.c.a;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public abstract interface b
  extends a
{
  public abstract boolean D(Object paramObject1, Object paramObject2);
  
  public abstract boolean OW(String paramString);
  
  public abstract p OX(String paramString);
  
  public abstract void OY(String paramString);
  
  public abstract long OZ(String paramString);
  
  public abstract String Pa(String paramString);
  
  public abstract void Pb(String paramString);
  
  public abstract void a(Context paramContext, JSONObject paramJSONObject, HashMap<String, Object> paramHashMap);
  
  public abstract void a(b paramb);
  
  public abstract void a(String paramString, int paramInt1, int paramInt2, Object... paramVarArgs);
  
  public abstract void a(String paramString1, y paramy, String paramString2, d<Bundle> paramd);
  
  public abstract boolean a(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, Intent paramIntent);
  
  public abstract boolean a(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, Intent paramIntent, int paramInt4, a parama);
  
  public abstract boolean bBQ();
  
  public abstract boolean bBR();
  
  public abstract boolean bBS();
  
  public abstract String bBT();
  
  public abstract void bBU();
  
  public abstract String bBV();
  
  public abstract void cb(List<q> paramList);
  
  public abstract void ck(String paramString, int paramInt);
  
  public abstract void cl(String paramString, int paramInt);
  
  public abstract String d(String paramString, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void i(List<List<String>> paramList, int paramInt);
  
  public abstract boolean isMpUrl(String paramString);
  
  public abstract void j(List<String[]> paramList, int paramInt);
  
  public abstract void k(List<q> paramList, int paramInt);
  
  public abstract boolean xA(int paramInt);
  
  public abstract void xB(int paramInt);
  
  public abstract boolean xC(int paramInt);
  
  public abstract boolean xz(int paramInt);
  
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