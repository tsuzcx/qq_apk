package com.tencent.mm.permission;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.g.a.ka;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  static final String bYu;
  static final String bYv;
  static Map<Integer, a.a> giG;
  c giH;
  private c giI;
  private c giJ;
  
  static
  {
    AppMethodBeat.i(16645);
    Object localObject = q.LK();
    bYu = (String)localObject;
    bYv = p.getString(((String)localObject).hashCode());
    localObject = new HashMap();
    giG = (Map)localObject;
    ((Map)localObject).put(Integer.valueOf(1), new a.a(38, 40, 41, 2131297033, 2131297025));
    giG.put(Integer.valueOf(2), new a.a(43, 44, 45, 2131297032, 2131297026));
    AppMethodBeat.o(16645);
  }
  
  public a()
  {
    AppMethodBeat.i(16641);
    this.giH = new a.1(this);
    this.giI = new a.2(this);
    this.giJ = new c() {};
    com.tencent.mm.sdk.b.a.ymk.c(this.giH);
    com.tencent.mm.sdk.b.a.ymk.c(this.giI);
    com.tencent.mm.sdk.b.a.ymk.c(this.giJ);
    AppMethodBeat.o(16641);
  }
  
  private static int wp(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(16642);
    try
    {
      int j = bo.getInt(g.Nq().getValue(paramString), 0);
      i = j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.PermissionMgr", "getIntValFromDynamicConfig parseInt failed, val: ".concat(String.valueOf(paramString)));
      }
    }
    AppMethodBeat.o(16642);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.permission.a
 * JD-Core Version:    0.7.0.1
 */