package com.android.vending.billing;

import android.os.Bundle;
import android.os.IInterface;

public abstract interface IInAppBillingService
  extends IInterface
{
  public abstract Bundle a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract int b(int paramInt, String paramString1, String paramString2);
  
  public abstract Bundle b(int paramInt, String paramString1, String paramString2, String paramString3);
  
  public abstract int c(int paramInt, String paramString1, String paramString2);
  
  public abstract Bundle getSkuDetails(int paramInt, String paramString1, String paramString2, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.android.vending.billing.IInAppBillingService
 * JD-Core Version:    0.7.0.1
 */