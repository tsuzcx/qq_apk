package com.tencent.mm.plugin.location.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.k.b;
import com.tencent.mm.plugin.k.d;
import com.tencent.mm.plugin.location.ui.impl.TrackPoint;
import com.tencent.mm.plugin.location.ui.impl.TrackPointAnimAvatar;
import com.tencent.mm.plugin.location_soso.ViewManager;
import com.tencent.mm.protocal.protobuf.bmx;
import com.tencent.mm.protocal.protobuf.cpm;
import com.tencent.mm.sdk.platformtools.ab;

final class m$4
  implements b.a
{
  m$4(m paramm) {}
  
  public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    AppMethodBeat.i(113562);
    if (!paramBoolean)
    {
      AppMethodBeat.o(113562);
      return false;
    }
    m localm = this.oeH;
    paramDouble1 = paramFloat2;
    paramDouble2 = paramFloat1;
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("[refreshMyLocation] ");
    localStringBuffer.append(String.format("latitude = %f, longtitude = %f", new Object[] { Double.valueOf(paramDouble1), Double.valueOf(paramDouble2) }));
    if (localm.obk == null)
    {
      localm.obk = new cpm();
      localObject = new bmx();
      localm.obk.xYw = ((bmx)localObject);
      localObject = r.Zn();
      localm.obk.Username = ((String)localObject);
      localm.obk.xYw.wyP = paramDouble1;
      localm.obk.xYw.wyO = paramDouble2;
      if ((localm.ocj) && (localm.oes)) {
        localm.bLX();
      }
    }
    localm.obk.xYw.wyP = paramDouble1;
    localm.obk.xYw.wyO = paramDouble2;
    Object localObject = localm.oci.getViewByItag(localm.obk.Username);
    if (localObject != null)
    {
      localStringBuffer.append("[ view is not null hasCode: " + localObject.hashCode() + " ] ");
      ab.d("MicroMsg.TrackPointViewMgrImpl", localStringBuffer.toString());
      if ((localObject instanceof TrackPoint))
      {
        localm.oeq = ((TrackPoint)localObject);
        ab.d("MicroMsg.TrackPointViewMgrImpl", "udpate view layout");
        localm.oeq.n(paramDouble1, paramDouble2);
      }
      if (localm.oez) {
        localm.oci.getIController().setCenter(localm.obk.xYw.wyP, localm.obk.xYw.wyO);
      }
      AppMethodBeat.o(113562);
      return true;
    }
    localObject = new TrackPoint(localm.mContext, (ViewManager)localm.oci.getViewManager(), (byte)0);
    localm.oci.addView(localObject, 0.0D, 0.0D, localm.obk.Username);
    ((TrackPoint)localObject).o(paramDouble1, paramDouble2);
    if (localm.oex)
    {
      ((TrackPoint)localObject).setOnAvatarOnClickListener(null);
      ((TrackPoint)localObject).setOnLocationOnClickListener(null);
      ((TrackPoint)localObject).bMw();
    }
    for (;;)
    {
      ((TrackPoint)localObject).setAvatar(localm.obk.Username);
      localStringBuffer.append("[view is null new one: " + localObject.hashCode() + " ] ");
      localm.oer = new TrackPointAnimAvatar(localm.mContext);
      break;
      ((TrackPoint)localObject).setOnAvatarOnClickListener(localm.oeF);
      ((TrackPoint)localObject).setOnLocationOnClickListener(localm.oeE);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.m.4
 * JD-Core Version:    0.7.0.1
 */