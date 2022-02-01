package com.tencent.mm.permission;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.g.a.lm;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  static final String cIZ;
  static final String cJa;
  static Map<Integer, a> iqY;
  c iqZ;
  private c ira;
  private c irb;
  
  static
  {
    AppMethodBeat.i(20689);
    Object localObject = q.XX();
    cIZ = (String)localObject;
    cJa = p.getString(((String)localObject).hashCode());
    localObject = new HashMap();
    iqY = (Map)localObject;
    ((Map)localObject).put(Integer.valueOf(1), new a(38, 40, 41, 2131755850, 2131755842));
    iqY.put(Integer.valueOf(2), new a(43, 44, 45, 2131755849, 2131755843));
    AppMethodBeat.o(20689);
  }
  
  public a()
  {
    AppMethodBeat.i(20685);
    this.iqZ = new a.1(this);
    this.ira = new a.2(this);
    this.irb = new c() {};
    com.tencent.mm.sdk.b.a.GpY.c(this.iqZ);
    com.tencent.mm.sdk.b.a.GpY.c(this.ira);
    com.tencent.mm.sdk.b.a.GpY.c(this.irb);
    AppMethodBeat.o(20685);
  }
  
  private static int Fs(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(20686);
    try
    {
      int j = bs.getInt(g.ZY().getValue(paramString), 0);
      i = j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.e("MicroMsg.PermissionMgr", "getIntValFromDynamicConfig parseInt failed, val: ".concat(String.valueOf(paramString)));
      }
    }
    AppMethodBeat.o(20686);
    return i;
  }
  
  static final class a
  {
    public int ird;
    public int ire;
    public int irf;
    public int irg;
    public int irh;
    
    public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      this.ird = paramInt1;
      this.ire = paramInt2;
      this.irf = paramInt3;
      this.irg = paramInt4;
      this.irh = paramInt5;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.permission.a
 * JD-Core Version:    0.7.0.1
 */