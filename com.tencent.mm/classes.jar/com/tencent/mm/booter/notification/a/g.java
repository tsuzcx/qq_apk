package com.tencent.mm.booter.notification.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
{
  public b ebB;
  public c ebC;
  public d ebD;
  public h ebE;
  private f ebF;
  public a ebG;
  public int ebH;
  public int ebI;
  public int ebJ;
  public int ebK;
  public boolean ebL;
  private int ebM;
  private int ebN;
  public boolean ebO;
  public boolean ebP;
  public Context mContext;
  
  public g(Context paramContext)
  {
    AppMethodBeat.i(16035);
    this.ebM = -1;
    this.ebN = -1;
    this.mContext = paramContext;
    this.ebB = new b();
    this.ebC = new c();
    this.ebD = new d();
    this.ebE = new h();
    this.ebG = new a();
    this.ebF = f.a.IY();
    AppMethodBeat.o(16035);
  }
  
  public static String b(long[] paramArrayOfLong)
  {
    AppMethodBeat.i(16037);
    if (paramArrayOfLong == null)
    {
      AppMethodBeat.o(16037);
      return null;
    }
    String str = "";
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      long l = paramArrayOfLong[i];
      str = str + String.valueOf(l) + ",";
      i += 1;
    }
    if (str.isEmpty())
    {
      AppMethodBeat.o(16037);
      return str;
    }
    paramArrayOfLong = str.substring(0, str.length() - 1);
    AppMethodBeat.o(16037);
    return paramArrayOfLong;
  }
  
  public final void kJ(String paramString)
  {
    AppMethodBeat.i(16036);
    this.ebF.kI(paramString);
    AppMethodBeat.o(16036);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.booter.notification.a.g
 * JD-Core Version:    0.7.0.1
 */