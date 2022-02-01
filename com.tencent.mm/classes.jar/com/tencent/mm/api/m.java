package com.tencent.mm.api;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.protocal.protobuf.cya;
import com.tencent.mm.protocal.protobuf.cyc;
import java.util.ArrayList;

public abstract interface m
  extends a
{
  public abstract void a(Intent paramIntent, cya paramcya, int paramInt);
  
  public abstract void a(Intent paramIntent, cyc paramcyc, int paramInt);
  
  public abstract void b(Activity paramActivity, String paramString);
  
  public abstract boolean eM(String paramString);
  
  public abstract ArrayList<String> eN(String paramString);
  
  public abstract boolean eO(String paramString);
  
  public abstract String eP(String paramString);
  
  public abstract String eQ(String paramString);
  
  public abstract void eR(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.api.m
 * JD-Core Version:    0.7.0.1
 */