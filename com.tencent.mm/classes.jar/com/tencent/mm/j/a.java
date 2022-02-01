package com.tencent.mm.j;

import android.content.Intent;
import android.view.KeyEvent;

public abstract interface a
{
  public abstract void a(a.b paramb);
  
  public abstract void a(a.c paramc);
  
  public abstract void a(String paramString1, String paramString2, a.b paramb);
  
  public abstract void atu();
  
  public abstract void atv();
  
  public abstract void atw();
  
  public abstract boolean atx();
  
  public abstract void b(a.b paramb);
  
  public abstract boolean dispatchKeyEvent(KeyEvent paramKeyEvent);
  
  public abstract void e(Boolean paramBoolean);
  
  public abstract boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void onDestroy();
  
  public abstract void onPause();
  
  public abstract void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt);
  
  public abstract void onResume();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.j.a
 * JD-Core Version:    0.7.0.1
 */