package com.tencent.mm.booter.notification.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
{
  public int fJA;
  public int fJB;
  public int fJC;
  public boolean fJD;
  private int fJE;
  private int fJF;
  public boolean fJG;
  public boolean fJH;
  public b fJt;
  public c fJu;
  public d fJv;
  public h fJw;
  private f fJx;
  public a fJy;
  public int fJz;
  public Context mContext;
  
  public g(Context paramContext)
  {
    AppMethodBeat.i(20067);
    this.fJE = -1;
    this.fJF = -1;
    this.mContext = paramContext;
    this.fJt = new b();
    this.fJu = new c();
    this.fJv = new d();
    this.fJw = new h();
    this.fJy = new a();
    this.fJx = f.a.XH();
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
  
  public final int XI()
  {
    AppMethodBeat.i(186340);
    if (this.fJA == -1) {
      this.fJA = com.tencent.mm.n.f.acH();
    }
    int i = this.fJA;
    AppMethodBeat.o(186340);
    return i;
  }
  
  public final int XJ()
  {
    AppMethodBeat.i(186341);
    if (this.fJB == -1) {
      this.fJB = com.tencent.mm.n.f.acI();
    }
    int i = this.fJB;
    AppMethodBeat.o(186341);
    return i;
  }
  
  public final void uP(String paramString)
  {
    AppMethodBeat.i(20068);
    this.fJx.uO(paramString);
    AppMethodBeat.o(20068);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.booter.notification.a.g
 * JD-Core Version:    0.7.0.1
 */