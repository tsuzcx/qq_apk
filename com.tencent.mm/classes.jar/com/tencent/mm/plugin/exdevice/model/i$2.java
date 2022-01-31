package com.tencent.mm.plugin.exdevice.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.protocal.protobuf.ahp;
import com.tencent.mm.protocal.protobuf.auh;
import com.tencent.mm.protocal.protobuf.aui;
import com.tencent.mm.protocal.protobuf.bec;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class i$2
  implements Runnable
{
  i$2(i parami, ahp paramahp) {}
  
  public final void run()
  {
    AppMethodBeat.i(19296);
    i.jf(bo.aoy());
    Object localObject2 = ad.bpY();
    Object localObject1 = new LinkedList();
    localObject2 = ((com.tencent.mm.plugin.exdevice.h.c)localObject2).getAll();
    Object localObject3;
    if ((localObject2 != null) && (((Cursor)localObject2).moveToFirst())) {
      do
      {
        localObject3 = new com.tencent.mm.plugin.exdevice.h.b();
        ((com.tencent.mm.plugin.exdevice.h.b)localObject3).convertFrom((Cursor)localObject2);
        ((List)localObject1).add(localObject3);
      } while (((Cursor)localObject2).moveToNext());
    }
    if (localObject2 != null) {
      ((Cursor)localObject2).close();
    }
    localObject1 = ((List)localObject1).iterator();
    label957:
    for (;;)
    {
      Object localObject4;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.plugin.exdevice.h.b)((Iterator)localObject1).next();
        localObject3 = this.lFm.wZO.iterator();
        do
        {
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject4 = ((bec)((Iterator)localObject3).next()).wvw;
        } while ((!((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_deviceType.equals(((auh)localObject4).wsq)) || (!((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_deviceID.equals(((auh)localObject4).jJD)));
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label957;
        }
        ab.d("MicroMsg.exdevice.GetBoundDeviceLogic", "delete deviceId %s, deviceType %s ", new Object[] { ((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_deviceID, ((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_deviceType });
        i.d((com.tencent.mm.plugin.exdevice.h.b)localObject2);
        ad.bpY().dW(((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_deviceID, ((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_deviceType);
        ad.bqj();
        e.aB(((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_deviceID, false);
        break;
        localObject1 = this.lFm.wZO.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject5 = (bec)((Iterator)localObject1).next();
          localObject2 = ((bec)localObject5).wvx;
          localObject3 = ((bec)localObject5).wvw;
          if ((localObject3 != null) && (localObject2 != null) && (!bo.isNullOrNil(((auh)localObject3).jJD)))
          {
            ab.i("MicroMsg.exdevice.GetBoundDeviceLogic", "ModHardDevice deviceId = %s, deviceType = %s, BindFlag = %s", new Object[] { ((auh)localObject3).jJD, ((auh)localObject3).wsq, Integer.valueOf(((bec)localObject5).xtR) });
            localObject4 = ad.bpY().LI(((auh)localObject3).jJD);
            if (2 == ((bec)localObject5).xtR)
            {
              ab.w("MicroMsg.exdevice.GetBoundDeviceLogic", "This Device is unbind, Just leave. deviceId = %s, mac = %s, brandName = %s", new Object[] { ((auh)localObject3).jJD, ((aui)localObject2).wuT, ((aui)localObject2).xji });
              if (localObject4 != null)
              {
                i.d((com.tencent.mm.plugin.exdevice.h.b)localObject4);
                ad.bpY().dW(((com.tencent.mm.plugin.exdevice.h.b)localObject4).field_deviceID, ((com.tencent.mm.plugin.exdevice.h.b)localObject4).field_deviceType);
                ad.bqj();
                e.aB(((com.tencent.mm.plugin.exdevice.h.b)localObject4).field_deviceID, false);
              }
            }
            else
            {
              localObject5 = new com.tencent.mm.plugin.exdevice.h.b();
              ((com.tencent.mm.plugin.exdevice.h.b)localObject5).field_deviceID = ((auh)localObject3).jJD;
              ((com.tencent.mm.plugin.exdevice.h.b)localObject5).field_deviceType = ((auh)localObject3).wsq;
              ((com.tencent.mm.plugin.exdevice.h.b)localObject5).field_connProto = ((aui)localObject2).xjj;
              ((com.tencent.mm.plugin.exdevice.h.b)localObject5).field_connStrategy = ((aui)localObject2).xjk;
              ((com.tencent.mm.plugin.exdevice.h.b)localObject5).field_closeStrategy = ((aui)localObject2).xjl;
              if ((((aui)localObject2).dCN == 2) && (localObject4 != null) && (((ch)localObject4).dCJ != null)) {
                ((aui)localObject2).gwU = ((ch)localObject4).dCJ;
              }
              ((com.tencent.mm.plugin.exdevice.h.b)localObject5).jm(((aui)localObject2).gwU);
              ((com.tencent.mm.plugin.exdevice.h.b)localObject5).ke(((aui)localObject2).xjr);
              ((com.tencent.mm.plugin.exdevice.h.b)localObject5).kd(((aui)localObject2).xjq);
              ((com.tencent.mm.plugin.exdevice.h.b)localObject5).kc(((aui)localObject2).xjp);
              ((com.tencent.mm.plugin.exdevice.h.b)localObject5).hS(((aui)localObject2).xjs);
              ((com.tencent.mm.plugin.exdevice.h.b)localObject5).ka(((aui)localObject2).IconUrl);
              ((com.tencent.mm.plugin.exdevice.h.b)localObject5).kb(((aui)localObject2).npR);
              ((com.tencent.mm.plugin.exdevice.h.b)localObject5).hT(((aui)localObject2).dCN);
              ((com.tencent.mm.plugin.exdevice.h.b)localObject5).fO(((aui)localObject2).dCO);
              ((com.tencent.mm.plugin.exdevice.h.b)localObject5).kf(((aui)localObject2).dCP);
              ((com.tencent.mm.plugin.exdevice.h.b)localObject5).kg(((aui)localObject2).dCQ);
              ((com.tencent.mm.plugin.exdevice.h.b)localObject5).kh(((aui)localObject2).dCR);
              ((com.tencent.mm.plugin.exdevice.h.b)localObject5).ki(((aui)localObject2).dCS);
              ((com.tencent.mm.plugin.exdevice.h.b)localObject5).field_url = "";
              ((com.tencent.mm.plugin.exdevice.h.b)localObject5).field_mac = com.tencent.mm.plugin.exdevice.j.b.LX(com.tencent.mm.plugin.exdevice.j.b.LY(((aui)localObject2).wuT));
              ((com.tencent.mm.plugin.exdevice.h.b)localObject5).field_md5Str = g.w(new String(((auh)localObject3).wsq + ((auh)localObject3).jJD).getBytes());
              ((com.tencent.mm.plugin.exdevice.h.b)localObject5).field_authKey = ((aui)localObject2).wrS;
              ((com.tencent.mm.plugin.exdevice.h.b)localObject5).field_brandName = ((aui)localObject2).xji;
              if (((com.tencent.mm.plugin.exdevice.h.b)localObject5).field_mac == 0L) {
                ((com.tencent.mm.plugin.exdevice.h.b)localObject5).field_mac = System.currentTimeMillis();
              }
              boolean bool1;
              if (localObject4 == null)
              {
                boolean bool2 = ad.bpY().insert((com.tencent.mm.sdk.e.c)localObject5);
                bool1 = bool2;
                if (bool2)
                {
                  ad.bqj();
                  e.aB(((com.tencent.mm.plugin.exdevice.h.b)localObject5).field_deviceID, true);
                  bool1 = bool2;
                }
              }
              for (;;)
              {
                ab.i("MicroMsg.exdevice.GetBoundDeviceLogic", "insert HardDeviceInfo %s, brandName = %s, deviceID = %s, deviceType = %s, connProto = %s, connStrategy = %s, closeStrategy = %s, mac = %s", new Object[] { Boolean.valueOf(bool1), ((com.tencent.mm.plugin.exdevice.h.b)localObject5).field_brandName, ((com.tencent.mm.plugin.exdevice.h.b)localObject5).field_deviceID, ((auh)localObject3).wsq, ((com.tencent.mm.plugin.exdevice.h.b)localObject5).field_connProto, Integer.valueOf(((com.tencent.mm.plugin.exdevice.h.b)localObject5).field_connStrategy), Integer.valueOf(((com.tencent.mm.plugin.exdevice.h.b)localObject5).field_closeStrategy), Long.valueOf(((com.tencent.mm.plugin.exdevice.h.b)localObject5).field_mac) });
                break;
                if (ad.bpY().e((com.tencent.mm.plugin.exdevice.h.b)localObject5) == 0) {
                  bool1 = false;
                } else {
                  bool1 = true;
                }
              }
            }
          }
        }
        AppMethodBeat.o(19296);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.i.2
 * JD-Core Version:    0.7.0.1
 */