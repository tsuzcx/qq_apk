package com.tencent.mm.booter.notification.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
{
  public b goI;
  public c goJ;
  public d goK;
  public h goL;
  private f goM;
  public a goN;
  public int goO;
  public int goP;
  public int goQ;
  public int goR;
  public boolean goS;
  private int goT;
  private int goU;
  public boolean goV;
  public boolean goW;
  public Context mContext;
  
  public g(Context paramContext)
  {
    AppMethodBeat.i(20067);
    this.goT = -1;
    this.goU = -1;
    this.mContext = paramContext;
    this.goI = new b();
    this.goJ = new c();
    this.goK = new d();
    this.goL = new h();
    this.goN = new a();
    this.goM = f.a.alu();
    AppMethodBeat.o(20067);
  }
  
  public static String a(long[] paramArrayOfLong)
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
  
  public final void Df(String paramString)
  {
    AppMethodBeat.i(20068);
    this.goM.De(paramString);
    AppMethodBeat.o(20068);
  }
  
  public final int alv()
  {
    AppMethodBeat.i(231503);
    if (this.goP == -1) {
      this.goP = com.tencent.mm.n.g.aqF();
    }
    int i = this.goP;
    AppMethodBeat.o(231503);
    return i;
  }
  
  public final int alw()
  {
    AppMethodBeat.i(231504);
    if (this.goQ == -1) {
      this.goQ = com.tencent.mm.n.g.aqG();
    }
    int i = this.goQ;
    AppMethodBeat.o(231504);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.booter.notification.a.g
 * JD-Core Version:    0.7.0.1
 */