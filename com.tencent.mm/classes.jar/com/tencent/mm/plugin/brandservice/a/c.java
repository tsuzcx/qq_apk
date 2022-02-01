package com.tencent.mm.plugin.brandservice.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.aj.p;
import com.tencent.mm.aj.q;
import com.tencent.mm.aj.y;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.protocal.protobuf.jd;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public abstract interface c
  extends com.tencent.mm.kernel.c.a
{
  public abstract boolean E(Object paramObject1, Object paramObject2);
  
  public abstract boolean Gv(int paramInt);
  
  public abstract boolean Gw(int paramInt);
  
  public abstract void Gx(int paramInt);
  
  public abstract a Gy(int paramInt);
  
  public abstract boolean Gz(int paramInt);
  
  public abstract void O(String paramString1, String paramString2, String paramString3);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2);
  
  public abstract void a(Context paramContext, JSONObject paramJSONObject, HashMap<String, Object> paramHashMap);
  
  public abstract void a(b paramb);
  
  public abstract void a(jd paramjd, MMActivity paramMMActivity, int paramInt);
  
  public abstract void a(String paramString, int paramInt1, int paramInt2, Object... paramVarArgs);
  
  public abstract void a(String paramString1, y paramy, String paramString2, f<Bundle> paramf);
  
  public abstract boolean a(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, Intent paramIntent);
  
  public abstract boolean a(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, Intent paramIntent, int paramInt4, a parama);
  
  public abstract boolean apb(String paramString);
  
  public abstract p apc(String paramString);
  
  public abstract void apd(String paramString);
  
  public abstract long ape(String paramString);
  
  public abstract String apf(String paramString);
  
  public abstract String apg(String paramString);
  
  public abstract int aph(String paramString);
  
  public abstract boolean api(String paramString);
  
  public abstract void apj(String paramString);
  
  public abstract void apk(String paramString);
  
  public abstract void apl(String paramString);
  
  public abstract void c(jd paramjd);
  
  public abstract void cY(String paramString, int paramInt);
  
  public abstract void cZ(String paramString, int paramInt);
  
  public abstract void cp(List<q> paramList);
  
  public abstract boolean cyB();
  
  public abstract String cyC();
  
  public abstract void cyD();
  
  public abstract int cyE();
  
  public abstract boolean cyF();
  
  public abstract boolean cyG();
  
  public abstract void cyH();
  
  public abstract String cyI();
  
  public abstract void cyJ();
  
  public abstract void cyK();
  
  public abstract String e(String paramString, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract boolean isMpUrl(String paramString);
  
  public abstract void j(List<List<String>> paramList, int paramInt);
  
  public abstract void k(List<String[]> paramList, int paramInt);
  
  public abstract void l(List<q> paramList, int paramInt);
  
  public abstract void n(String paramString1, String paramString2, String paramString3, String paramString4);
  
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
 * Qualified Name:     com.tencent.mm.plugin.brandservice.a.c
 * JD-Core Version:    0.7.0.1
 */