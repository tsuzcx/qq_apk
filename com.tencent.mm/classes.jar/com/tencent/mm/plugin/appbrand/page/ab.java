package com.tencent.mm.plugin.appbrand.page;

import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.plugin.appbrand.page.a.c;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import java.util.Map;

public abstract interface ab
  extends c
{
  public abstract bb DF();
  
  public abstract al DG();
  
  public abstract void DH();
  
  public abstract void DI();
  
  public abstract void DK();
  
  public abstract <T> T Q(Class<T> paramClass);
  
  public abstract View a(LayoutInflater paramLayoutInflater);
  
  public abstract void a(Map<String, Object> paramMap, br parambr);
  
  public abstract void b(b paramb);
  
  public abstract boolean cZ(String paramString);
  
  public abstract void cm(View paramView);
  
  public abstract RelativeLayout.LayoutParams cn(View paramView);
  
  public abstract void dispatchConfigurationChanged(Configuration paramConfiguration);
  
  public abstract void dispatchDestroy();
  
  public abstract void dispatchStart();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ab
 * JD-Core Version:    0.7.0.1
 */