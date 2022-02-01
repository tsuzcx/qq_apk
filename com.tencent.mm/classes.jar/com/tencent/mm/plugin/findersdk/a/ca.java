package com.tencent.mm.plugin.findersdk.a;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mm.protocal.protobuf.baj;
import com.tencent.mm.vending.e.a;
import java.util.Map;
import kotlin.r;
import org.json.JSONObject;

public abstract interface ca
{
  public abstract void G(Context paramContext, String paramString1, String paramString2);
  
  public abstract r<Boolean, Object> J(long paramLong, String paramString);
  
  public abstract Object a(String paramString1, String paramString2, com.tencent.mm.vending.e.b<a> paramb, ca.a<Object> parama, ca.a<Integer> parama1);
  
  public abstract void a(long paramLong, ca.a<Boolean> parama);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4);
  
  public abstract void a(Context paramContext, JSONObject paramJSONObject, ca.a<Object> parama, ca.a<Integer> parama1);
  
  public abstract void a(ImageView paramImageView, String paramString);
  
  public abstract void a(String paramString1, long paramLong, String paramString2, String paramString3, Map<String, Object> paramMap, ca.a<Void> parama, ca.a<Integer> parama1);
  
  public abstract void a(String paramString1, String paramString2, ca.a<Boolean> parama, ca.a<Integer> parama1);
  
  public abstract void aBY(String paramString);
  
  public abstract bs aP(Activity paramActivity);
  
  public abstract com.tencent.mm.am.b<baj> azA(String paramString);
  
  public abstract void b(String paramString, int paramInt, JSONObject paramJSONObject);
  
  public abstract void b(String paramString1, long paramLong, String paramString2, String paramString3, Map<String, Object> paramMap, ca.a<Void> parama, ca.a<Integer> parama1);
  
  public abstract void b(String paramString1, String paramString2, ca.a<Void> parama, ca.a<Integer> parama1);
  
  public abstract void e(Context paramContext, String paramString1, String paramString2, int paramInt);
  
  public abstract void e(ViewGroup paramViewGroup, int paramInt1, int paramInt2);
  
  public abstract an en(Context paramContext);
  
  public abstract void f(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract int fgA();
  
  public abstract float fgB();
  
  public abstract float fgC();
  
  public abstract boolean fgD();
  
  public abstract boolean fgE();
  
  public abstract boolean fgF();
  
  public abstract boolean fgG();
  
  public abstract boolean fgH();
  
  public abstract String fgI();
  
  public abstract String fgJ();
  
  public abstract void h(Context paramContext, String paramString1, String paramString2, String paramString3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.a.ca
 * JD-Core Version:    0.7.0.1
 */