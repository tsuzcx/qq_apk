package com.tencent.mm.model;

import android.app.Notification;
import android.app.PendingIntent;
import android.graphics.Bitmap;

public abstract interface ax
  extends az
{
  public abstract void C(String paramString, int paramInt);
  
  public abstract void CY(String paramString);
  
  public abstract void Xc();
  
  public abstract int a(Notification paramNotification, boolean paramBoolean);
  
  public abstract Notification a(Notification paramNotification, int paramInt1, int paramInt2, PendingIntent paramPendingIntent, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, String paramString4);
  
  public abstract Notification a(Notification paramNotification, int paramInt, PendingIntent paramPendingIntent1, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, String paramString4, PendingIntent paramPendingIntent2, String paramString5, PendingIntent paramPendingIntent3, String paramString6);
  
  public abstract Notification a(PendingIntent paramPendingIntent, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, String paramString4);
  
  public abstract void a(int paramInt, Notification paramNotification, boolean paramBoolean);
  
  public abstract String ala();
  
  public abstract void alb();
  
  public abstract void alc();
  
  public abstract int c(Notification paramNotification);
  
  public abstract void cancel(int paramInt);
  
  public abstract void cancelNotification(String paramString);
  
  public abstract void dh(boolean paramBoolean);
  
  public abstract void di(boolean paramBoolean);
  
  public abstract void dj(boolean paramBoolean);
  
  public abstract void nR(int paramInt);
  
  public abstract void nS(int paramInt);
  
  public abstract void notify(int paramInt, Notification paramNotification);
  
  public abstract void r(int paramInt, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.ax
 * JD-Core Version:    0.7.0.1
 */