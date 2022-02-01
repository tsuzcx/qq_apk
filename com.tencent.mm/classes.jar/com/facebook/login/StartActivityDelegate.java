package com.facebook.login;

import android.app.Activity;
import android.content.Intent;

abstract interface StartActivityDelegate
{
  public abstract Activity getActivityContext();
  
  public abstract void startActivityForResult(Intent paramIntent, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.login.StartActivityDelegate
 * JD-Core Version:    0.7.0.1
 */