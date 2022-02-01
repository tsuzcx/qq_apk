package com.tencent.mm.plugin.luckymoney.appbrand.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.LinkedList;
import java.util.List;

public enum g
{
  public int sYe;
  public double sYf;
  public double sYg;
  public double sYh;
  public double sYi;
  public String sYj;
  public String sYk;
  private List<Object> sYl;
  
  static
  {
    AppMethodBeat.i(64886);
    sYd = new g("GLOBAL");
    sYm = new g[] { sYd };
    AppMethodBeat.o(64886);
  }
  
  private g()
  {
    AppMethodBeat.i(64884);
    this.sYe = 100;
    this.sYf = 200.0D;
    this.sYg = 0.01D;
    this.sYh = 2000.0D;
    this.sYi = 200.0D;
    this.sYj = "¥";
    this.sYk = aj.getContext().getString(2131760830);
    this.sYl = new LinkedList();
    AppMethodBeat.o(64884);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(64885);
    String str = "WxaLuckyMoneyConfig{maxTotalNum=" + this.sYe + ", perPersonMaxValue=" + this.sYf + ", perMinValue=" + this.sYg + ", maxTotalAmount=" + this.sYh + ", mListener=" + this.sYl + '}';
    AppMethodBeat.o(64885);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.a.g
 * JD-Core Version:    0.7.0.1
 */