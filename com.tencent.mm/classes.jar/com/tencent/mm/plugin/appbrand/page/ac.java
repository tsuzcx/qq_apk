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
  public abstract ar CA();
  
  public abstract void CB();
  
  public abstract void CC();
  
  public abstract void CE();
  
  public abstract bh Cz();
  
  public abstract <T> T Q(Class<T> paramClass);
  
  public abstract View a(LayoutInflater paramLayoutInflater);
  
  public abstract void a(Map<String, Object> paramMap, by paramby);
  
  public abstract void b(b paramb);
  
  public abstract void cm(View paramView);
  
  public abstract RelativeLayout.LayoutParams cn(View paramView);
  
  public abstract boolean cn(String paramString);
  
  public abstract void dispatchConfigurationChanged(Configuration paramConfiguration);
  
  public abstract void dispatchDestroy();
  
  public abstract void dispatchStart();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ac
 * JD-Core Version:    0.7.0.1
 */