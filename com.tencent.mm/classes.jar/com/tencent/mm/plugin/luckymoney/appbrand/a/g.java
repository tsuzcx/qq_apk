package com.tencent.mm.plugin.luckymoney.appbrand.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.LinkedList;
import java.util.List;

public enum g
{
  public int vvh;
  public double vvi;
  public double vvj;
  public double vvk;
  public double vvl;
  public String vvm;
  public String vvn;
  private List<Object> vvo;
  
  static
  {
    AppMethodBeat.i(64886);
    vvg = new g("GLOBAL");
    vvp = new g[] { vvg };
    AppMethodBeat.o(64886);
  }
  
  private g()
  {
    AppMethodBeat.i(64884);
    this.vvh = 100;
    this.vvi = 200.0D;
    this.vvj = 0.01D;
    this.vvk = 2000.0D;
    this.vvl = 200.0D;
    this.vvm = "¥";
    this.vvn = ak.getContext().getString(2131760830);
    this.vvo = new LinkedList();
    AppMethodBeat.o(64884);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(64885);
    String str = "WxaLuckyMoneyConfig{maxTotalNum=" + this.vvh + ", perPersonMaxValue=" + this.vvi + ", perMinValue=" + this.vvj + ", maxTotalAmount=" + this.vvk + ", mListener=" + this.vvo + '}';
    AppMethodBeat.o(64885);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.a.g
 * JD-Core Version:    0.7.0.1
 */