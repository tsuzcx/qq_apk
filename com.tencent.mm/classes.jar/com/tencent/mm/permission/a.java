package com.tencent.mm.permission;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.g.a.lw;
import com.tencent.mm.n.e;
import com.tencent.mm.n.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  static final String cVh;
  static final String cVi;
  static Map<Integer, a> iMV;
  c iMW;
  private c iMX;
  private c iMY;
  
  static
  {
    AppMethodBeat.i(20689);
    Object localObject = q.aaH();
    cVh = (String)localObject;
    cVi = p.getString(((String)localObject).hashCode());
    localObject = new HashMap();
    iMV = (Map)localObject;
    ((Map)localObject).put(Integer.valueOf(1), new a(38, 40, 41, 2131755850, 2131755842));
    iMV.put(Integer.valueOf(2), new a(43, 44, 45, 2131755849, 2131755843));
    AppMethodBeat.o(20689);
  }
  
  public a()
  {
    AppMethodBeat.i(20685);
    this.iMW = new a.1(this);
    this.iMX = new a.2(this);
    this.iMY = new c() {};
    com.tencent.mm.sdk.b.a.IvT.c(this.iMW);
    com.tencent.mm.sdk.b.a.IvT.c(this.iMX);
    com.tencent.mm.sdk.b.a.IvT.c(this.iMY);
    AppMethodBeat.o(20685);
  }
  
  private static int Jh(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(20686);
    try
    {
      int j = bu.getInt(g.acL().getValue(paramString), 0);
      i = j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.e("MicroMsg.PermissionMgr", "getIntValFromDynamicConfig parseInt failed, val: ".concat(String.valueOf(paramString)));
      }
    }
    AppMethodBeat.o(20686);
    return i;
  }
  
  static final class a
  {
    public int iNa;
    public int iNb;
    public int iNc;
    public int iNd;
    public int iNe;
    
    public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      this.iNa = paramInt1;
      this.iNb = paramInt2;
      this.iNc = paramInt3;
      this.iNd = paramInt4;
      this.iNe = paramInt5;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.permission.a
 * JD-Core Version:    0.7.0.1
 */