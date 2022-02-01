package com.tencent.mm.plugin.brandservice.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ah.p;
import com.tencent.mm.ah.q;
import com.tencent.mm.ah.y;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.protocal.protobuf.jb;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public abstract interface b
  extends a
{
  public abstract boolean F(Object paramObject1, Object paramObject2);
  
  public abstract void M(String paramString1, String paramString2, String paramString3);
  
  public abstract void XA(String paramString);
  
  public abstract long XB(String paramString);
  
  public abstract String XC(String paramString);
  
  public abstract void XD(String paramString);
  
  public abstract boolean Xy(String paramString);
  
  public abstract p Xz(String paramString);
  
  public abstract void a(Context paramContext, JSONObject paramJSONObject, HashMap<String, Object> paramHashMap);
  
  public abstract void a(b paramb);
  
  public abstract void a(jb paramjb, MMActivity paramMMActivity, int paramInt);
  
  public abstract void a(String paramString, int paramInt1, int paramInt2, Object... paramVarArgs);
  
  public abstract void a(String paramString1, y paramy, String paramString2, d<Bundle> paramd);
  
  public abstract boolean a(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, Intent paramIntent);
  
  public abstract boolean a(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, Intent paramIntent, int paramInt4, a parama);
  
  public abstract boolean bOd();
  
  public abstract boolean bOe();
  
  public abstract boolean bOf();
  
  public abstract String bOg();
  
  public abstract void bOh();
  
  public abstract int bOi();
  
  public abstract String bOj();
  
  public abstract void bOk();
  
  public abstract void c(jb paramjb);
  
  public abstract void ce(List<q> paramList);
  
  public abstract void cw(String paramString, int paramInt);
  
  public abstract void cx(String paramString, int paramInt);
  
  public abstract String d(String paramString, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract boolean isMpUrl(String paramString);
  
  public abstract void j(List<List<String>> paramList, int paramInt);
  
  public abstract void k(List<String[]> paramList, int paramInt);
  
  public abstract void l(List<q> paramList, int paramInt);
  
  public abstract boolean zk(int paramInt);
  
  public abstract boolean zl(int paramInt);
  
  public abstract void zm(int paramInt);
  
  public abstract boolean zn(int paramInt);
  
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