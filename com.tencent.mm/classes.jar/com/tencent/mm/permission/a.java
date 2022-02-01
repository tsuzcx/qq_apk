package com.tencent.mm.permission;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.g.a.lv;
import com.tencent.mm.n.e;
import com.tencent.mm.n.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  static final String cUi;
  static final String cUj;
  static Map<Integer, a> iKc;
  c iKd;
  private c iKe;
  private c iKf;
  
  static
  {
    AppMethodBeat.i(20689);
    Object localObject = q.aay();
    cUi = (String)localObject;
    cUj = p.getString(((String)localObject).hashCode());
    localObject = new HashMap();
    iKc = (Map)localObject;
    ((Map)localObject).put(Integer.valueOf(1), new a(38, 40, 41, 2131755850, 2131755842));
    iKc.put(Integer.valueOf(2), new a(43, 44, 45, 2131755849, 2131755843));
    AppMethodBeat.o(20689);
  }
  
  public a()
  {
    AppMethodBeat.i(20685);
    this.iKd = new a.1(this);
    this.iKe = new a.2(this);
    this.iKf = new c() {};
    com.tencent.mm.sdk.b.a.IbL.c(this.iKd);
    com.tencent.mm.sdk.b.a.IbL.c(this.iKe);
    com.tencent.mm.sdk.b.a.IbL.c(this.iKf);
    AppMethodBeat.o(20685);
  }
  
  private static int II(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(20686);
    try
    {
      int j = bt.getInt(g.acA().getValue(paramString), 0);
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
    public int iKh;
    public int iKi;
    public int iKj;
    public int iKk;
    public int iKl;
    
    public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      this.iKh = paramInt1;
      this.iKi = paramInt2;
      this.iKj = paramInt3;
      this.iKk = paramInt4;
      this.iKl = paramInt5;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.permission.a
 * JD-Core Version:    0.7.0.1
 */