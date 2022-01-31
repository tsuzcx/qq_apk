package com.tencent.mm.plugin.luckymoney.appbrand.a;

import android.content.Context;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;
import java.util.List;

public enum g
{
  public int lKX = 100;
  public double lKY = 200.0D;
  public double lKZ = 0.01D;
  public double lLa = 2000.0D;
  public double lLb = 200.0D;
  public String lLc = "¥";
  public String lLd = ae.getContext().getString(a.i.lucky_money_amount_unit_title);
  private List<Object> lLe = new LinkedList();
  
  private g() {}
  
  public final String toString()
  {
    return "WxaLuckyMoneyConfig{maxTotalNum=" + this.lKX + ", perPersonMaxValue=" + this.lKY + ", perMinValue=" + this.lKZ + ", maxTotalAmount=" + this.lLa + ", mListener=" + this.lLe + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.a.g
 * JD-Core Version:    0.7.0.1
 */