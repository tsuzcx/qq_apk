package com.tencent.mm.plugin.luckymoney.appbrand.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.LinkedList;
import java.util.List;

public enum g
{
  public int Kmb;
  public double Kmc;
  public double Kmd;
  public double Kme;
  public double Kmf;
  public String Kmg;
  public String Kmh;
  private List<Object> Kmi;
  
  static
  {
    AppMethodBeat.i(64886);
    Kma = new g("GLOBAL");
    Kmj = new g[] { Kma };
    AppMethodBeat.o(64886);
  }
  
  private g()
  {
    AppMethodBeat.i(64884);
    this.Kmb = 100;
    this.Kmc = 200.0D;
    this.Kmd = 0.01D;
    this.Kme = 2000.0D;
    this.Kmf = 200.0D;
    this.Kmg = "¥";
    this.Kmh = MMApplicationContext.getContext().getString(a.i.lucky_money_amount_unit_title);
    this.Kmi = new LinkedList();
    AppMethodBeat.o(64884);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(64885);
    String str = "WxaLuckyMoneyConfig{maxTotalNum=" + this.Kmb + ", perPersonMaxValue=" + this.Kmc + ", perMinValue=" + this.Kmd + ", maxTotalAmount=" + this.Kme + ", mListener=" + this.Kmi + '}';
    AppMethodBeat.o(64885);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.a.g
 * JD-Core Version:    0.7.0.1
 */