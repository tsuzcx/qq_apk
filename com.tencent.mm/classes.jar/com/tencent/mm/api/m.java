package com.tencent.mm.api;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.protocal.protobuf.cnj;
import com.tencent.mm.protocal.protobuf.cnl;
import java.util.ArrayList;

public abstract interface m
  extends a
{
  public abstract void a(Intent paramIntent, cnj paramcnj, int paramInt);
  
  public abstract void a(Intent paramIntent, cnl paramcnl, int paramInt);
  
  public abstract void b(Activity paramActivity, String paramString);
  
  public abstract boolean ec(String paramString);
  
  public abstract ArrayList<String> ed(String paramString);
  
  public abstract boolean ee(String paramString);
  
  public abstract String ef(String paramString);
  
  public abstract String eg(String paramString);
  
  public abstract void eh(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.api.m
 * JD-Core Version:    0.7.0.1
 */