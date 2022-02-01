package com.tencent.mm.plugin.appbrand.page;

import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.plugin.appbrand.page.a.c;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import java.util.Map;

public abstract interface af
  extends c
{
  public abstract bh PU();
  
  public abstract void PV();
  
  public abstract void PW();
  
  public abstract void PY();
  
  public abstract <T> T R(Class<T> paramClass);
  
  public abstract View a(LayoutInflater paramLayoutInflater);
  
  public abstract void a(Map<String, Object> paramMap, ca paramca);
  
  public abstract void b(b paramb);
  
  public abstract boolean b(String paramString, ca paramca);
  
  public abstract void ct(View paramView);
  
  public abstract RelativeLayout.LayoutParams cu(View paramView);
  
  public abstract void dispatchConfigurationChanged(Configuration paramConfiguration);
  
  public abstract void dispatchDestroy();
  
  public abstract void dispatchStart();
  
  public abstract ap getCustomViewContainer();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.af
 * JD-Core Version:    0.7.0.1
 */