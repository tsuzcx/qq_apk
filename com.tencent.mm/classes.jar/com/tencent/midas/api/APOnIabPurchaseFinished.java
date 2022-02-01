package com.tencent.midas.api;

import com.tencent.midas.api.request.APIabResult;
import com.tencent.midas.api.request.APPurchase;

public abstract interface APOnIabPurchaseFinished
{
  public abstract void onIabPurchaseFinished(APIabResult paramAPIabResult, APPurchase paramAPPurchase);
  
  public abstract void onIabyNeedLogin();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.midas.api.APOnIabPurchaseFinished
 * JD-Core Version:    0.7.0.1
 */