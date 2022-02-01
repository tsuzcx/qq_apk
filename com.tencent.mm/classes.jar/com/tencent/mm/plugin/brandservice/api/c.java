package com.tencent.mm.plugin.brandservice.api;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.message.p;
import com.tencent.mm.message.q;
import com.tencent.mm.message.y;
import com.tencent.mm.protocal.protobuf.jz;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public abstract interface c
  extends com.tencent.mm.kernel.c.a
{
  public abstract boolean GU(int paramInt);
  
  public abstract boolean GV(int paramInt);
  
  public abstract void GW(int paramInt);
  
  public abstract a GX(int paramInt);
  
  public abstract boolean GY(int paramInt);
  
  public abstract boolean P(Object paramObject1, Object paramObject2);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2);
  
  public abstract void a(Context paramContext, JSONObject paramJSONObject, HashMap<String, Object> paramHashMap);
  
  public abstract void a(c.b paramb);
  
  public abstract void a(jz paramjz, MMActivity paramMMActivity, int paramInt);
  
  public abstract void a(String paramString, int paramInt1, int paramInt2, Object... paramVarArgs);
  
  public abstract void a(String paramString1, y paramy, String paramString2, f<Bundle> paramf);
  
  public abstract void a(String paramString1, String paramString2, String paramString3, long paramLong);
  
  public abstract boolean a(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, Intent paramIntent);
  
  public abstract boolean a(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, Intent paramIntent, int paramInt4, a parama);
  
  public abstract void aiA(String paramString);
  
  public abstract long aiB(String paramString);
  
  public abstract String aiC(String paramString);
  
  public abstract String aiD(String paramString);
  
  public abstract int aiE(String paramString);
  
  public abstract boolean aiF(String paramString);
  
  public abstract void aiG(String paramString);
  
  public abstract void aiH(String paramString);
  
  public abstract void aiI(String paramString);
  
  public abstract boolean aiy(String paramString);
  
  public abstract p aiz(String paramString);
  
  public abstract void b(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3);
  
  public abstract void c(jz paramjz);
  
  public abstract void dA(String paramString, int paramInt);
  
  public abstract void dB(String paramString, int paramInt);
  
  public abstract int dav();
  
  public abstract void dbA();
  
  public abstract int dbB();
  
  public abstract boolean dbC();
  
  public abstract boolean dbD();
  
  public abstract void dbE();
  
  public abstract String dbF();
  
  public abstract int dbG();
  
  public abstract void dbH();
  
  public abstract void dbI();
  
  public abstract boolean dbw();
  
  public abstract boolean dbx();
  
  public abstract void dby();
  
  public abstract String dbz();
  
  public abstract String e(String paramString, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void eh(List<q> paramList);
  
  public abstract boolean isMpUrl(String paramString);
  
  public abstract void m(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract void s(List<List<String>> paramList, int paramInt);
  
  public abstract void t(List<String[]> paramList, int paramInt);
  
  public abstract void u(List<q> paramList, int paramInt);
  
  public static final class a
  {
    public String message;
    public boolean success = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.api.c
 * JD-Core Version:    0.7.0.1
 */