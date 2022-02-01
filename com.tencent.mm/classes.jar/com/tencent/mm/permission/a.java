package com.tencent.mm.permission;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.g.a.ld;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  static final String cLR;
  static final String cLS;
  static Map<Integer, a> hQU;
  c hQV;
  private c hQW;
  private c hQX;
  
  static
  {
    AppMethodBeat.i(20689);
    Object localObject = q.Xa();
    cLR = (String)localObject;
    cLS = p.getString(((String)localObject).hashCode());
    localObject = new HashMap();
    hQU = (Map)localObject;
    ((Map)localObject).put(Integer.valueOf(1), new a(38, 40, 41, 2131755850, 2131755842));
    hQU.put(Integer.valueOf(2), new a(43, 44, 45, 2131755849, 2131755843));
    AppMethodBeat.o(20689);
  }
  
  public a()
  {
    AppMethodBeat.i(20685);
    this.hQV = new a.1(this);
    this.hQW = new a.2(this);
    this.hQX = new c() {};
    com.tencent.mm.sdk.b.a.ESL.c(this.hQV);
    com.tencent.mm.sdk.b.a.ESL.c(this.hQW);
    com.tencent.mm.sdk.b.a.ESL.c(this.hQX);
    AppMethodBeat.o(20685);
  }
  
  private static int Bo(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(20686);
    try
    {
      int j = bt.getInt(g.Zd().getValue(paramString), 0);
      i = j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.PermissionMgr", "getIntValFromDynamicConfig parseInt failed, val: ".concat(String.valueOf(paramString)));
      }
    }
    AppMethodBeat.o(20686);
    return i;
  }
  
  static final class a
  {
    public int hQZ;
    public int hRa;
    public int hRb;
    public int hRc;
    public int hRd;
    
    public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      this.hQZ = paramInt1;
      this.hRa = paramInt2;
      this.hRb = paramInt3;
      this.hRc = paramInt4;
      this.hRd = paramInt5;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.permission.a
 * JD-Core Version:    0.7.0.1
 */