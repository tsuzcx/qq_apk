package com.tencent.mm.plugin.luckymoney.appbrand.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.LinkedList;
import java.util.List;

public enum g
{
  public int oir;
  public double ois;
  public double oit;
  public double oiu;
  public double oiv;
  public String oiw;
  public String oix;
  private List<Object> oiy;
  
  static
  {
    AppMethodBeat.i(41998);
    oiq = new g("GLOBAL");
    oiz = new g[] { oiq };
    AppMethodBeat.o(41998);
  }
  
  private g()
  {
    AppMethodBeat.i(41996);
    this.oir = 100;
    this.ois = 200.0D;
    this.oit = 0.01D;
    this.oiu = 2000.0D;
    this.oiv = 200.0D;
    this.oiw = "¥";
    this.oix = ah.getContext().getString(2131301196);
    this.oiy = new LinkedList();
    AppMethodBeat.o(41996);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(41997);
    String str = "WxaLuckyMoneyConfig{maxTotalNum=" + this.oir + ", perPersonMaxValue=" + this.ois + ", perMinValue=" + this.oit + ", maxTotalAmount=" + this.oiu + ", mListener=" + this.oiy + '}';
    AppMethodBeat.o(41997);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.a.g
 * JD-Core Version:    0.7.0.1
 */