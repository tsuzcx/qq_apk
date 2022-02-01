package com.tencent.mm.plugin.brandservice.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ag.p;
import com.tencent.mm.ag.q;
import com.tencent.mm.ag.y;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.protocal.protobuf.jo;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public abstract interface b
  extends a
{
  public abstract boolean CQ(int paramInt);
  
  public abstract boolean CR(int paramInt);
  
  public abstract void CS(int paramInt);
  
  public abstract boolean CT(int paramInt);
  
  public abstract boolean L(Object paramObject1, Object paramObject2);
  
  public abstract void P(String paramString1, String paramString2, String paramString3);
  
  public abstract void Q(String paramString1, String paramString2, String paramString3);
  
  public abstract void a(Context paramContext, JSONObject paramJSONObject, HashMap<String, Object> paramHashMap);
  
  public abstract void a(b paramb);
  
  public abstract void a(jo paramjo, MMActivity paramMMActivity, int paramInt);
  
  public abstract void a(String paramString, int paramInt1, int paramInt2, Object... paramVarArgs);
  
  public abstract void a(String paramString1, y paramy, String paramString2, d<Bundle> paramd);
  
  public abstract boolean a(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, Intent paramIntent);
  
  public abstract boolean a(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, Intent paramIntent, int paramInt4, b.a parama);
  
  public abstract void ahA(String paramString);
  
  public abstract boolean ahv(String paramString);
  
  public abstract p ahw(String paramString);
  
  public abstract void ahx(String paramString);
  
  public abstract long ahy(String paramString);
  
  public abstract String ahz(String paramString);
  
  public abstract void c(jo paramjo);
  
  public abstract void cD(String paramString, int paramInt);
  
  public abstract void cE(String paramString, int paramInt);
  
  public abstract boolean clc();
  
  public abstract boolean cld();
  
  public abstract boolean cle();
  
  public abstract String clf();
  
  public abstract void clg();
  
  public abstract int clh();
  
  public abstract String cli();
  
  public abstract void clj();
  
  public abstract void clk();
  
  public abstract void ct(List<q> paramList);
  
  public abstract String d(String paramString, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract boolean isMpUrl(String paramString);
  
  public abstract void j(List<List<String>> paramList, int paramInt);
  
  public abstract void k(List<String[]> paramList, int paramInt);
  
  public abstract void l(List<q> paramList, int paramInt);
  
  public static abstract interface b
  {
    public abstract void onSuccess(String paramString);
    
    public abstract void p(int paramInt1, int paramInt2, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.a.b
 * JD-Core Version:    0.7.0.1
 */