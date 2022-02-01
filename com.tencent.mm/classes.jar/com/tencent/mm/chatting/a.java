package com.tencent.mm.chatting;

import android.content.Intent;
import android.view.KeyEvent;
import com.tencent.mm.ui.MMActivity;

public abstract interface a
{
  public abstract void a(b paramb);
  
  public abstract void a(c paramc);
  
  public abstract void a(String paramString1, String paramString2, b paramb);
  
  public abstract void aNR();
  
  public abstract void aNS();
  
  public abstract void aNT();
  
  public abstract boolean aNU();
  
  public abstract void b(b paramb);
  
  public abstract boolean dispatchKeyEvent(KeyEvent paramKeyEvent);
  
  public abstract void i(Boolean paramBoolean);
  
  public abstract boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void onDestroy();
  
  public abstract void onPause();
  
  public abstract void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt);
  
  public abstract void onResume();
  
  public static abstract interface a$a
  {
    public abstract a a(MMActivity paramMMActivity);
  }
  
  public static abstract interface b
  {
    public abstract void aNV();
    
    public abstract boolean aNW();
  }
  
  public static abstract interface c
  {
    public abstract void onFinish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.chatting.a
 * JD-Core Version:    0.7.0.1
 */