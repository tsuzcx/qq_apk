package com.tencent.mm.plugin.luckymoney.appbrand.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.LinkedList;
import java.util.List;

public enum g
{
  public int vjc;
  public double vjd;
  public double vje;
  public double vjf;
  public double vjg;
  public String vjh;
  public String vji;
  private List<Object> vjj;
  
  static
  {
    AppMethodBeat.i(64886);
    vjb = new g("GLOBAL");
    vjk = new g[] { vjb };
    AppMethodBeat.o(64886);
  }
  
  private g()
  {
    AppMethodBeat.i(64884);
    this.vjc = 100;
    this.vjd = 200.0D;
    this.vje = 0.01D;
    this.vjf = 2000.0D;
    this.vjg = 200.0D;
    this.vjh = "¥";
    this.vji = aj.getContext().getString(2131760830);
    this.vjj = new LinkedList();
    AppMethodBeat.o(64884);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(64885);
    String str = "WxaLuckyMoneyConfig{maxTotalNum=" + this.vjc + ", perPersonMaxValue=" + this.vjd + ", perMinValue=" + this.vje + ", maxTotalAmount=" + this.vjf + ", mListener=" + this.vjj + '}';
    AppMethodBeat.o(64885);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.a.g
 * JD-Core Version:    0.7.0.1
 */