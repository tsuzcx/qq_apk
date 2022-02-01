package com.tencent.mm.api;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.protocal.protobuf.cyu;
import com.tencent.mm.protocal.protobuf.cyw;
import java.util.ArrayList;

public abstract interface m
  extends a
{
  public abstract void a(Intent paramIntent, cyu paramcyu, int paramInt);
  
  public abstract void a(Intent paramIntent, cyw paramcyw, int paramInt);
  
  public abstract void b(Activity paramActivity, String paramString);
  
  public abstract boolean eR(String paramString);
  
  public abstract ArrayList<String> eS(String paramString);
  
  public abstract boolean eT(String paramString);
  
  public abstract String eU(String paramString);
  
  public abstract String eV(String paramString);
  
  public abstract void eW(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.api.m
 * JD-Core Version:    0.7.0.1
 */