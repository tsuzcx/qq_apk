package com.tencent.mm.plugin.appbrand.page;

import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.plugin.appbrand.page.b.c;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import java.util.Map;

public abstract interface ac
  extends c
{
  public abstract bc DC();
  
  public abstract am DD();
  
  public abstract void DE();
  
  public abstract void DF();
  
  public abstract void DH();
  
  public abstract <T> T Q(Class<T> paramClass);
  
  public abstract View a(LayoutInflater paramLayoutInflater);
  
  public abstract void a(Map<String, Object> paramMap, bs parambs);
  
  public abstract void b(b paramb);
  
  public abstract boolean cX(String paramString);
  
  public abstract void cm(View paramView);
  
  public abstract RelativeLayout.LayoutParams cn(View paramView);
  
  public abstract void dispatchConfigurationChanged(Configuration paramConfiguration);
  
  public abstract void dispatchDestroy();
  
  public abstract void dispatchStart();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ac
 * JD-Core Version:    0.7.0.1
 */