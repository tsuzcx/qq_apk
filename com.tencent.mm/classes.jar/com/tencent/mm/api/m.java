package com.tencent.mm.api;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.protocal.protobuf.csq;
import com.tencent.mm.protocal.protobuf.css;
import java.util.ArrayList;

public abstract interface m
  extends a
{
  public abstract void a(Intent paramIntent, csq paramcsq, int paramInt);
  
  public abstract void a(Intent paramIntent, css paramcss, int paramInt);
  
  public abstract void b(Activity paramActivity, String paramString);
  
  public abstract boolean dR(String paramString);
  
  public abstract ArrayList<String> dS(String paramString);
  
  public abstract boolean dT(String paramString);
  
  public abstract String dU(String paramString);
  
  public abstract String dV(String paramString);
  
  public abstract void dW(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.api.m
 * JD-Core Version:    0.7.0.1
 */