package com.tencent.mm.plugin.luckymoney.appbrand.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ai;
import java.util.LinkedList;
import java.util.List;

public enum g
{
  public int ugs;
  public double ugt;
  public double ugu;
  public double ugv;
  public double ugw;
  public String ugx;
  public String ugy;
  private List<Object> ugz;
  
  static
  {
    AppMethodBeat.i(64886);
    ugr = new g("GLOBAL");
    ugA = new g[] { ugr };
    AppMethodBeat.o(64886);
  }
  
  private g()
  {
    AppMethodBeat.i(64884);
    this.ugs = 100;
    this.ugt = 200.0D;
    this.ugu = 0.01D;
    this.ugv = 2000.0D;
    this.ugw = 200.0D;
    this.ugx = "¥";
    this.ugy = ai.getContext().getString(2131760830);
    this.ugz = new LinkedList();
    AppMethodBeat.o(64884);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(64885);
    String str = "WxaLuckyMoneyConfig{maxTotalNum=" + this.ugs + ", perPersonMaxValue=" + this.ugt + ", perMinValue=" + this.ugu + ", maxTotalAmount=" + this.ugv + ", mListener=" + this.ugz + '}';
    AppMethodBeat.o(64885);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.a.g
 * JD-Core Version:    0.7.0.1
 */