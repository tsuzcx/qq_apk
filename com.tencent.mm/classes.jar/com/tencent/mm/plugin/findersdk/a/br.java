package com.tencent.mm.plugin.findersdk.a;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.protocal.protobuf.bvl;
import java.util.Map;

public abstract interface br
  extends a
{
  public abstract boolean a(Context paramContext, String paramString1, Map<String, String> paramMap, String paramString2);
  
  public abstract boolean a(AppCompatActivity paramAppCompatActivity, String paramString, Map<String, String> paramMap);
  
  public abstract a aE(String paramString, long paramLong);
  
  public abstract boolean b(AppCompatActivity paramAppCompatActivity, String paramString, Map<String, String> paramMap);
  
  public abstract String x(String paramString, Map<String, String> paramMap);
  
  public abstract bvl y(String paramString, Map<String, String> paramMap);
  
  public static abstract interface a
  {
    public abstract void dUW();
    
    public abstract void dUX();
    
    public abstract Fragment getFragment();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.a.br
 * JD-Core Version:    0.7.0.1
 */