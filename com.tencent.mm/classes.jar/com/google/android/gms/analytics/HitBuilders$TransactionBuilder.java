package com.google.android.gms.analytics;

@Deprecated
public class HitBuilders$TransactionBuilder
  extends HitBuilders.HitBuilder<TransactionBuilder>
{
  public HitBuilders$TransactionBuilder()
  {
    set("&t", "transaction");
  }
  
  public TransactionBuilder setAffiliation(String paramString)
  {
    set("&ta", paramString);
    return this;
  }
  
  public TransactionBuilder setCurrencyCode(String paramString)
  {
    set("&cu", paramString);
    return this;
  }
  
  public TransactionBuilder setRevenue(double paramDouble)
  {
    set("&tr", Double.toString(paramDouble));
    return this;
  }
  
  public TransactionBuilder setShipping(double paramDouble)
  {
    set("&ts", Double.toString(paramDouble));
    return this;
  }
  
  public TransactionBuilder setTax(double paramDouble)
  {
    set("&tt", Double.toString(paramDouble));
    return this;
  }
  
  public TransactionBuilder setTransactionId(String paramString)
  {
    set("&ti", paramString);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.analytics.HitBuilders.TransactionBuilder
 * JD-Core Version:    0.7.0.1
 */