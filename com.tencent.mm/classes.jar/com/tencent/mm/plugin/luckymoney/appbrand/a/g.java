package com.tencent.mm.plugin.luckymoney.appbrand.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.LinkedList;
import java.util.List;

public enum g
{
  public String EtA;
  private List<Object> EtB;
  public int Etu;
  public double Etv;
  public double Etw;
  public double Etx;
  public double Ety;
  public String Etz;
  
  static
  {
    AppMethodBeat.i(64886);
    Ett = new g("GLOBAL");
    EtC = new g[] { Ett };
    AppMethodBeat.o(64886);
  }
  
  private g()
  {
    AppMethodBeat.i(64884);
    this.Etu = 100;
    this.Etv = 200.0D;
    this.Etw = 0.01D;
    this.Etx = 2000.0D;
    this.Ety = 200.0D;
    this.Etz = "¥";
    this.EtA = MMApplicationContext.getContext().getString(a.i.lucky_money_amount_unit_title);
    this.EtB = new LinkedList();
    AppMethodBeat.o(64884);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(64885);
    String str = "WxaLuckyMoneyConfig{maxTotalNum=" + this.Etu + ", perPersonMaxValue=" + this.Etv + ", perMinValue=" + this.Etw + ", maxTotalAmount=" + this.Etx + ", mListener=" + this.EtB + '}';
    AppMethodBeat.o(64885);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.a.g
 * JD-Core Version:    0.7.0.1
 */