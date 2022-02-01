package com.tencent.mm.plugin.luckymoney.appbrand.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.LinkedList;
import java.util.List;

public enum g
{
  public String yPA;
  public String yPB;
  private List<Object> yPC;
  public int yPv;
  public double yPw;
  public double yPx;
  public double yPy;
  public double yPz;
  
  static
  {
    AppMethodBeat.i(64886);
    yPu = new g("GLOBAL");
    yPD = new g[] { yPu };
    AppMethodBeat.o(64886);
  }
  
  private g()
  {
    AppMethodBeat.i(64884);
    this.yPv = 100;
    this.yPw = 200.0D;
    this.yPx = 0.01D;
    this.yPy = 2000.0D;
    this.yPz = 200.0D;
    this.yPA = "¥";
    this.yPB = MMApplicationContext.getContext().getString(2131762584);
    this.yPC = new LinkedList();
    AppMethodBeat.o(64884);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(64885);
    String str = "WxaLuckyMoneyConfig{maxTotalNum=" + this.yPv + ", perPersonMaxValue=" + this.yPw + ", perMinValue=" + this.yPx + ", maxTotalAmount=" + this.yPy + ", mListener=" + this.yPC + '}';
    AppMethodBeat.o(64885);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.a.g
 * JD-Core Version:    0.7.0.1
 */