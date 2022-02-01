package com.tencent.mm.booter.notification.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
{
  public b luP;
  public c luQ;
  public d luR;
  public h luS;
  private f luT;
  public a luU;
  public int luV;
  public int luW;
  public int luX;
  public int luY;
  public boolean luZ;
  private int lva;
  private int lvb;
  public boolean lvc;
  public boolean lvd;
  public Context mContext;
  
  public g(Context paramContext)
  {
    AppMethodBeat.i(20067);
    this.lva = -1;
    this.lvb = -1;
    this.mContext = paramContext;
    this.luP = new b();
    this.luQ = new c();
    this.luR = new d();
    this.luS = new h();
    this.luU = new a();
    this.luT = f.a.aLo();
    AppMethodBeat.o(20067);
  }
  
  public static String c(long[] paramArrayOfLong)
  {
    AppMethodBeat.i(20069);
    if (paramArrayOfLong == null)
    {
      AppMethodBeat.o(20069);
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
      AppMethodBeat.o(20069);
      return str;
    }
    paramArrayOfLong = str.substring(0, str.length() - 1);
    AppMethodBeat.o(20069);
    return paramArrayOfLong;
  }
  
  public final int aLp()
  {
    AppMethodBeat.i(238927);
    if (this.luW == -1) {
      this.luW = com.tencent.mm.k.h.aRy();
    }
    int i = this.luW;
    AppMethodBeat.o(238927);
    return i;
  }
  
  public final int aLq()
  {
    AppMethodBeat.i(238928);
    if (this.luX == -1) {
      this.luX = com.tencent.mm.k.h.aRz();
    }
    int i = this.luX;
    AppMethodBeat.o(238928);
    return i;
  }
  
  public final void t(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(238929);
    this.luT.s(paramString, paramBoolean);
    AppMethodBeat.o(238929);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.booter.notification.a.g
 * JD-Core Version:    0.7.0.1
 */