package com.tencent.mm.model;

import android.app.Notification;
import android.app.PendingIntent;
import android.graphics.Bitmap;

public abstract interface ar
  extends at
{
  public abstract void A(String paramString, int paramInt);
  
  public abstract void MU();
  
  public abstract String Xf();
  
  public abstract void Xg();
  
  public abstract void Xh();
  
  public abstract int a(Notification paramNotification, boolean paramBoolean);
  
  public abstract Notification a(Notification paramNotification, int paramInt1, int paramInt2, PendingIntent paramPendingIntent, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, String paramString4);
  
  public abstract Notification a(Notification paramNotification, int paramInt, PendingIntent paramPendingIntent1, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, String paramString4, PendingIntent paramPendingIntent2, String paramString5, PendingIntent paramPendingIntent3, String paramString6);
  
  public abstract Notification a(PendingIntent paramPendingIntent, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, String paramString4);
  
  public abstract void a(int paramInt, Notification paramNotification, boolean paramBoolean);
  
  public abstract int c(Notification paramNotification);
  
  public abstract void cA(boolean paramBoolean);
  
  public abstract void cancel(int paramInt);
  
  public abstract void cancelNotification(String paramString);
  
  public abstract void cz(boolean paramBoolean);
  
  public abstract void kN(int paramInt);
  
  public abstract void kO(int paramInt);
  
  public abstract void notify(int paramInt, Notification paramNotification);
  
  public abstract void p(int paramInt, String paramString);
  
  public abstract void un(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.ar
 * JD-Core Version:    0.7.0.1
 */