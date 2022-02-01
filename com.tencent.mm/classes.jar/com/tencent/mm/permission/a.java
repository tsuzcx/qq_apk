package com.tencent.mm.permission;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.k.i;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  static Map<Integer, a> pxu;
  IListener pxv;
  private IListener pxw;
  private IListener pxx;
  
  static
  {
    AppMethodBeat.i(20689);
    HashMap localHashMap = new HashMap();
    pxu = localHashMap;
    localHashMap.put(Integer.valueOf(1), new a(38, 40, 41, R.l.grP, R.l.grN));
    pxu.put(Integer.valueOf(2), new a(43, 44, 45, R.l.app_permission_tips_title_camera, R.l.app_permission_tips_content_prefix_camera));
    AppMethodBeat.o(20689);
  }
  
  public a()
  {
    AppMethodBeat.i(20685);
    this.pxv = new PermissionMgr.1(this, com.tencent.mm.app.f.hfK);
    this.pxw = new PermissionMgr.2(this, com.tencent.mm.app.f.hfK);
    this.pxx = new PermissionMgr.3(this, com.tencent.mm.app.f.hfK);
    this.pxv.alive();
    this.pxw.alive();
    this.pxx.alive();
    AppMethodBeat.o(20685);
  }
  
  private static int RW(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(20686);
    try
    {
      int j = Util.getInt(i.aRC().getValue(paramString), 0);
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
    public int pxA;
    public int pxB;
    public int pxC;
    public int pxD;
    public int pxz;
    
    public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      this.pxz = paramInt1;
      this.pxA = paramInt2;
      this.pxB = paramInt3;
      this.pxC = paramInt4;
      this.pxD = paramInt5;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.permission.a
 * JD-Core Version:    0.7.0.1
 */