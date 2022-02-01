package com.tencent.mm.booter.notification.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
{
  public b fph;
  public c fpi;
  public d fpj;
  public h fpk;
  private f fpl;
  public a fpm;
  public int fpn;
  public int fpo;
  public int fpp;
  public int fpq;
  public boolean fpr;
  private int fpt;
  private int fpu;
  public boolean fpv;
  public boolean fpw;
  public Context mContext;
  
  public g(Context paramContext)
  {
    AppMethodBeat.i(20067);
    this.fpt = -1;
    this.fpu = -1;
    this.mContext = paramContext;
    this.fph = new b();
    this.fpi = new c();
    this.fpj = new d();
    this.fpk = new h();
    this.fpm = new a();
    this.fpl = f.a.Vi();
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
  
  public final void rH(String paramString)
  {
    AppMethodBeat.i(20068);
    this.fpl.rG(paramString);
    AppMethodBeat.o(20068);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.booter.notification.a.g
 * JD-Core Version:    0.7.0.1
 */