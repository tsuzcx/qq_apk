package com.tencent.mm.model;

import android.app.Notification;
import android.app.PendingIntent;
import android.graphics.Bitmap;

public abstract interface al
  extends an
{
  public abstract int a(Notification paramNotification, boolean paramBoolean);
  
  public abstract Notification a(Notification paramNotification, int paramInt1, int paramInt2, PendingIntent paramPendingIntent, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, String paramString4);
  
  public abstract Notification a(Notification paramNotification, int paramInt1, PendingIntent paramPendingIntent1, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, int paramInt2, String paramString4, PendingIntent paramPendingIntent2, int paramInt3, String paramString5, PendingIntent paramPendingIntent3, String paramString6);
  
  public abstract Notification a(PendingIntent paramPendingIntent, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, String paramString4);
  
  public abstract void a(int paramInt, Notification paramNotification, boolean paramBoolean);
  
  public abstract void bc(boolean paramBoolean);
  
  public abstract void bd(boolean paramBoolean);
  
  public abstract int c(Notification paramNotification);
  
  public abstract void cancel(int paramInt);
  
  public abstract void cancelNotification(String paramString);
  
  public abstract void ew(String paramString);
  
  public abstract void ex(String paramString);
  
  public abstract void fS(int paramInt);
  
  public abstract void fT(int paramInt);
  
  public abstract void fU(int paramInt);
  
  public abstract void k(int paramInt, String paramString);
  
  public abstract void notify(int paramInt, Notification paramNotification);
  
  public abstract void t(String paramString, int paramInt);
  
  public abstract void tn();
  
  public abstract String wo();
  
  public abstract void wp();
  
  public abstract boolean wq();
  
  public abstract void wr();
  
  public abstract void ws();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.model.al
 * JD-Core Version:    0.7.0.1
 */