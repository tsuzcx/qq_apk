package com.tencent.mm.j;

import android.content.Intent;
import android.view.KeyEvent;
import com.tencent.mm.ui.MMActivity;

public abstract interface a
{
  public abstract boolean ZA();
  
  public abstract void Zx();
  
  public abstract void Zy();
  
  public abstract void Zz();
  
  public abstract void a(a.b paramb);
  
  public abstract void a(a.c paramc);
  
  public abstract void a(String paramString1, String paramString2, a.b paramb);
  
  public abstract void b(a.b paramb);
  
  public abstract void d(Boolean paramBoolean);
  
  public abstract boolean dispatchKeyEvent(KeyEvent paramKeyEvent);
  
  public abstract boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void onDestroy();
  
  public abstract void onPause();
  
  public abstract void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt);
  
  public abstract void onResume();
  
  public static final class a
  {
    public static a fVe;
    
    public static abstract interface a
    {
      public abstract a a(MMActivity paramMMActivity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.j.a
 * JD-Core Version:    0.7.0.1
 */