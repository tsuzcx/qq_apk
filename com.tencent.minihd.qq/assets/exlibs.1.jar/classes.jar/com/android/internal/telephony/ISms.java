package com.android.internal.telephony;

import android.app.PendingIntent;
import android.os.IInterface;
import java.util.List;

public abstract interface ISms
  extends IInterface
{
  public abstract List a();
  
  public abstract void a(String paramString1, String paramString2, int paramInt, byte[] paramArrayOfByte, PendingIntent paramPendingIntent1, PendingIntent paramPendingIntent2);
  
  public abstract void a(String paramString1, String paramString2, String paramString3, PendingIntent paramPendingIntent1, PendingIntent paramPendingIntent2);
  
  public abstract void a(String paramString1, String paramString2, List paramList1, List paramList2, List paramList3);
  
  public abstract boolean a(int paramInt);
  
  public abstract boolean a(int paramInt1, int paramInt2, byte[] paramArrayOfByte);
  
  public abstract boolean a(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  public abstract boolean b(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.android.internal.telephony.ISms
 * JD-Core Version:    0.7.0.1
 */