package com.tencent.mm.booter.notification.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
{
  private int fHA;
  private int fHB;
  public boolean fHC;
  public boolean fHD;
  public b fHp;
  public c fHq;
  public d fHr;
  public h fHs;
  private f fHt;
  public a fHu;
  public int fHv;
  public int fHw;
  public int fHx;
  public int fHy;
  public boolean fHz;
  public Context mContext;
  
  public g(Context paramContext)
  {
    AppMethodBeat.i(20067);
    this.fHA = -1;
    this.fHB = -1;
    this.mContext = paramContext;
    this.fHp = new b();
    this.fHq = new c();
    this.fHr = new d();
    this.fHs = new h();
    this.fHu = new a();
    this.fHt = f.a.Xz();
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
  
  public final int Mn()
  {
    AppMethodBeat.i(221373);
    if (this.fHw == -1) {
      this.fHw = com.tencent.mm.n.f.acw();
    }
    int i = this.fHw;
    AppMethodBeat.o(221373);
    return i;
  }
  
  public final int Mo()
  {
    AppMethodBeat.i(221374);
    if (this.fHx == -1) {
      this.fHx = com.tencent.mm.n.f.acx();
    }
    int i = this.fHx;
    AppMethodBeat.o(221374);
    return i;
  }
  
  public final void uu(String paramString)
  {
    AppMethodBeat.i(20068);
    this.fHt.ut(paramString);
    AppMethodBeat.o(20068);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.booter.notification.a.g
 * JD-Core Version:    0.7.0.1
 */