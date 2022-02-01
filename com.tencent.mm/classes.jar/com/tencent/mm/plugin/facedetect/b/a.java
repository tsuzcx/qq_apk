package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.am.p;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class a
  extends p
{
  public int dispatch(g paramg, s params, m paramm)
  {
    boolean bool = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zbi, true);
    if (((params instanceof com.tencent.mm.am.c)) && (bool) && (((com.tencent.mm.am.c)params).getReqObj() != null))
    {
      Log.i("MicroMsg.FaceNetSceneBase", "Build.MODEL:%s", new Object[] { q.aPo() });
      ((com.tencent.mm.am.c)params).getReqObj().setDeviceType(q.aPo());
    }
    return super.dispatch(paramg, params, paramm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.a
 * JD-Core Version:    0.7.0.1
 */