package com.tencent.mm.plugin.appbrand.page;

import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.plugin.appbrand.page.a.c;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import java.util.Map;

public abstract interface ae
  extends c
{
  public abstract bf Nc();
  
  public abstract void Nd();
  
  public abstract void Ne();
  
  public abstract void Ng();
  
  public abstract <T> T S(Class<T> paramClass);
  
  public abstract View a(LayoutInflater paramLayoutInflater);
  
  public abstract void a(Map<String, Object> paramMap, bx parambx);
  
  public abstract void b(b paramb);
  
  public abstract void cb(View paramView);
  
  public abstract RelativeLayout.LayoutParams cc(View paramView);
  
  public abstract void dispatchConfigurationChanged(Configuration paramConfiguration);
  
  public abstract void dispatchDestroy();
  
  public abstract void dispatchStart();
  
  public abstract boolean dy(String paramString);
  
  public abstract ao getCustomViewContainer();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ae
 * JD-Core Version:    0.7.0.1
 */