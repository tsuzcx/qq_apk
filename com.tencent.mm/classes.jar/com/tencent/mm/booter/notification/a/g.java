package com.tencent.mm.booter.notification.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
{
  public b iSR;
  public c iSS;
  public d iST;
  public h iSU;
  private f iSV;
  public a iSW;
  public int iSX;
  public int iSY;
  public int iSZ;
  public int iTa;
  public boolean iTb;
  private int iTc;
  private int iTd;
  public boolean iTe;
  public boolean iTf;
  public Context mContext;
  
  public g(Context paramContext)
  {
    AppMethodBeat.i(20067);
    this.iTc = -1;
    this.iTd = -1;
    this.mContext = paramContext;
    this.iSR = new b();
    this.iSS = new c();
    this.iST = new d();
    this.iSU = new h();
    this.iSW = new a();
    this.iSV = f.a.ars();
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
  
  public final void JW(String paramString)
  {
    AppMethodBeat.i(20068);
    this.iSV.JV(paramString);
    AppMethodBeat.o(20068);
  }
  
  public final int art()
  {
    AppMethodBeat.i(287280);
    if (this.iSY == -1) {
      this.iSY = com.tencent.mm.n.g.awY();
    }
    int i = this.iSY;
    AppMethodBeat.o(287280);
    return i;
  }
  
  public final int aru()
  {
    AppMethodBeat.i(287281);
    if (this.iSZ == -1) {
      this.iSZ = com.tencent.mm.n.g.awZ();
    }
    int i = this.iSZ;
    AppMethodBeat.o(287281);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.booter.notification.a.g
 * JD-Core Version:    0.7.0.1
 */