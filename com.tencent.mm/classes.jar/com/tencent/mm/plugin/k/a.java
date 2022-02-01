package com.tencent.mm.plugin.k;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;

public abstract class a
{
  public abstract boolean dispatchKeyEvent(KeyEvent paramKeyEvent);
  
  public abstract boolean dispatchTouchEvent(MotionEvent paramMotionEvent);
  
  public abstract boolean djW();
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public abstract void onBackPressed();
  
  public abstract void onCreate(Bundle paramBundle);
  
  public abstract void onDestroy();
  
  public abstract void onPause();
  
  public abstract void onResume();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.k.a
 * JD-Core Version:    0.7.0.1
 */