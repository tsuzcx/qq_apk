package com.tencent.mm.plugin.facedetect.b;

import android.os.Build;
import com.tencent.mm.an.d;
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class a
  extends q
{
  public int dispatch(g paramg, s params, m paramm)
  {
    boolean bool = ((b)h.ae(b.class)).a(b.a.vKI, true);
    if (((params instanceof d)) && (bool) && (((d)params).getReqObj() != null))
    {
      Log.i("MicroMsg.FaceNetSceneBase", "Build.MODEL:%s", new Object[] { Build.MODEL });
      ((d)params).getReqObj().setDeviceType(Build.MODEL);
    }
    return super.dispatch(paramg, params, paramm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.a
 * JD-Core Version:    0.7.0.1
 */