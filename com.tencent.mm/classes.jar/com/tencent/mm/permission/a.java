package com.tencent.mm.permission;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.f.a.nd;
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
  static Map<Integer, a> mAK;
  IListener mAL;
  private IListener mAM;
  private IListener mAN;
  
  static
  {
    AppMethodBeat.i(20689);
    HashMap localHashMap = new HashMap();
    mAK = localHashMap;
    localHashMap.put(Integer.valueOf(1), new a(38, 40, 41, R.l.eoO, R.l.eoM));
    mAK.put(Integer.valueOf(2), new a(43, 44, 45, R.l.app_permission_tips_title_camera, R.l.app_permission_tips_content_prefix_camera));
    AppMethodBeat.o(20689);
  }
  
  public a()
  {
    AppMethodBeat.i(20685);
    this.mAL = new a.1(this);
    this.mAM = new a.2(this);
    this.mAN = new IListener() {};
    EventCenter.instance.addListener(this.mAL);
    EventCenter.instance.addListener(this.mAM);
    EventCenter.instance.addListener(this.mAN);
    AppMethodBeat.o(20685);
  }
  
  private static int ZG(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(20686);
    try
    {
      int j = Util.getInt(h.axc().getValue(paramString), 0);
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
    public int mAP;
    public int mAQ;
    public int mAR;
    public int mAS;
    public int mAT;
    
    public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      this.mAP = paramInt1;
      this.mAQ = paramInt2;
      this.mAR = paramInt3;
      this.mAS = paramInt4;
      this.mAT = paramInt5;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.permission.a
 * JD-Core Version:    0.7.0.1
 */