package com.tencent.mm.permission;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mm;
import com.tencent.mm.g.a.pk;
import com.tencent.mm.g.a.pl;
import com.tencent.mm.n.f;
import com.tencent.mm.n.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  static Map<Integer, a> jJJ;
  IListener jJK;
  private IListener jJL;
  private IListener jJM;
  
  static
  {
    AppMethodBeat.i(20689);
    HashMap localHashMap = new HashMap();
    jJJ = localHashMap;
    localHashMap.put(Integer.valueOf(1), new a(38, 40, 41, 2131755936, 2131755928));
    jJJ.put(Integer.valueOf(2), new a(43, 44, 45, 2131755935, 2131755929));
    AppMethodBeat.o(20689);
  }
  
  public a()
  {
    AppMethodBeat.i(20685);
    this.jJK = new IListener() {};
    this.jJL = new IListener() {};
    this.jJM = new IListener() {};
    EventCenter.instance.addListener(this.jJK);
    EventCenter.instance.addListener(this.jJL);
    EventCenter.instance.addListener(this.jJM);
    AppMethodBeat.o(20685);
  }
  
  private static int Se(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(20686);
    try
    {
      int j = Util.getInt(h.aqJ().getValue(paramString), 0);
      i = j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.PermissionMgr", "getIntValFromDynamicConfig parseInt failed, val: ".concat(String.valueOf(paramString)));
      }
    }
    AppMethodBeat.o(20686);
    return i;
  }
  
  static final class a
  {
    public int jJO;
    public int jJP;
    public int jJQ;
    public int jJR;
    public int jJS;
    
    public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      this.jJO = paramInt1;
      this.jJP = paramInt2;
      this.jJQ = paramInt3;
      this.jJR = paramInt4;
      this.jJS = paramInt5;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.permission.a
 * JD-Core Version:    0.7.0.1
 */