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
  public abstract View a(LayoutInflater paramLayoutInflater);
  
  public abstract void a(Map<String, Object> paramMap, cb paramcb);
  
  public abstract <T> T aa(Class<T> paramClass);
  
  public abstract bh aqd();
  
  public abstract void aqe();
  
  public abstract void aqf();
  
  public abstract boolean aqg();
  
  public abstract void aqi();
  
  public abstract void b(b paramb);
  
  public abstract boolean b(String paramString, cb paramcb);
  
  public abstract RelativeLayout.LayoutParams cP(View paramView);
  
  public abstract void dispatchConfigurationChanged(Configuration paramConfiguration);
  
  public abstract void dispatchDestroy();
  
  public abstract void dispatchStart();
  
  public abstract ap getCustomViewContainer();
  
  public abstract void onViewCreated(View paramView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.af
 * JD-Core Version:    0.7.0.1
 */