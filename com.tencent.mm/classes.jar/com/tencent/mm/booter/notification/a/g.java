package com.tencent.mm.booter.notification.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
{
  public b flN;
  public c flO;
  public d flP;
  public h flQ;
  private f flR;
  public a flS;
  public int flT;
  public int flU;
  public int flV;
  public int flW;
  public boolean flX;
  private int flY;
  private int flZ;
  public boolean fma;
  public boolean fmb;
  public Context mContext;
  
  public g(Context paramContext)
  {
    AppMethodBeat.i(20067);
    this.flY = -1;
    this.flZ = -1;
    this.mContext = paramContext;
    this.flN = new b();
    this.flO = new c();
    this.flP = new d();
    this.flQ = new h();
    this.flS = new a();
    this.flR = f.a.Un();
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
  
  public final void oB(String paramString)
  {
    AppMethodBeat.i(20068);
    this.flR.oA(paramString);
    AppMethodBeat.o(20068);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.booter.notification.a.g
 * JD-Core Version:    0.7.0.1
 */