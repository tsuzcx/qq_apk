package com.tencent.mm.plugin.exdevice.model;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import com.tencent.mm.R.l;
import com.tencent.mm.a.g;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.c.cc;
import com.tencent.mm.model.au;
import com.tencent.mm.protocal.c.acz;
import com.tencent.mm.protocal.c.aop;
import com.tencent.mm.protocal.c.aoq;
import com.tencent.mm.protocal.c.axm;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public enum i
  implements f
{
  private ProgressDialog dnm;
  private boolean jvH = false;
  public i.a jvI;
  
  private i()
  {
    Object localObject = ae.getContext().getSharedPreferences("exdevice_pref", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    au.Hx();
    long l = ((SharedPreferences)localObject).getLong(com.tencent.mm.model.c.CK(), 0L);
    if (l != 0L)
    {
      y.i("MicroMsg.exdevice.GetBoundDeviceLogic", "this user has get bound device, last time is %d", new Object[] { Long.valueOf(l) });
      return;
    }
    y.i("MicroMsg.exdevice.GetBoundDeviceLogic", "the user has not get bound device yet");
  }
  
  public static void dN(long paramLong)
  {
    y.i("MicroMsg.exdevice.GetBoundDeviceLogic", "update get bound hard device time : %d", new Object[] { Long.valueOf(paramLong) });
    SharedPreferences.Editor localEditor = ae.getContext().getSharedPreferences("exdevice_pref", 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    au.Hx();
    localEditor.putLong(com.tencent.mm.model.c.CK(), paramLong).commit();
  }
  
  public final void a(Context paramContext, i.a parama)
  {
    y.i("MicroMsg.exdevice.GetBoundDeviceLogic", "startGetBoundHardDevices");
    if (this.jvH)
    {
      if (this.jvI == null) {
        this.jvI = parama;
      }
      y.i("MicroMsg.exdevice.GetBoundDeviceLogic", "getting bound device now, just leave");
      return;
    }
    o localo = new o();
    if ((paramContext != null) && ((paramContext instanceof Activity)) && (!((Activity)paramContext).isFinishing()))
    {
      if ((this.dnm != null) && (this.dnm.isShowing())) {
        this.dnm.dismiss();
      }
      paramContext.getString(R.l.app_tip);
      this.dnm = h.b(paramContext, paramContext.getString(R.l.scan_loading_tip), new i.1(this, localo, parama));
    }
    this.jvI = parama;
    au.Dk().a(localo, 0);
  }
  
  public final boolean fC(boolean paramBoolean)
  {
    if (this.jvH)
    {
      y.i("MicroMsg.exdevice.GetBoundDeviceLogic", "Getting bound device now, just leave");
      return false;
    }
    long l1 = System.currentTimeMillis();
    SharedPreferences localSharedPreferences = ae.getContext().getSharedPreferences("exdevice_pref", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    au.Hx();
    long l2 = localSharedPreferences.getLong(com.tencent.mm.model.c.CK(), 0L);
    if ((!paramBoolean) && (l1 - l2 < 86400000L))
    {
      y.i("MicroMsg.exdevice.GetBoundDeviceLogic", "GetBoundHardDevices not now pp");
      return false;
    }
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, m paramm)
  {
    y.i("MicroMsg.exdevice.GetBoundDeviceLogic", "onSceneEnd errType = " + paramInt1 + ", errCode = " + paramInt2 + ",errMsg = " + paramString);
    this.jvH = false;
    if ((paramm == null) || (paramInt2 != 0) || (paramInt1 != 0)) {
      y.e("MicroMsg.exdevice.GetBoundDeviceLogic", "do scene failed : %d, %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
    }
    label306:
    label339:
    do
    {
      do
      {
        return;
        y.i("MicroMsg.exdevice.GetBoundDeviceLogic", "scene.getType() = %s", new Object[] { Integer.valueOf(paramm.getType()) });
        if (paramm.getType() != 539) {
          break label339;
        }
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          break;
        }
        y.e("MicroMsg.exdevice.GetBoundDeviceLogic", "scene.getType() = %s, %s, %s", new Object[] { Integer.valueOf(paramm.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        if (this.jvI != null) {
          this.jvI.fB(false);
        }
      } while ((this.dnm == null) || (!this.dnm.isShowing()));
      this.dnm.dismiss();
      return;
      paramString = (o)paramm;
      if ((paramString.dmK != null) && (paramString.dmK.ecF.ecN != null)) {}
      for (paramString = (acz)paramString.dmK.ecF.ecN;; paramString = null)
      {
        if ((paramString != null) && (paramString.tbC != null)) {
          break label306;
        }
        if (this.jvI != null) {
          this.jvI.fB(false);
        }
        if ((this.dnm == null) || (!this.dnm.isShowing())) {
          break;
        }
        this.dnm.dismiss();
        return;
      }
      au.DS().O(new Runnable()
      {
        public final void run()
        {
          i.dN(bk.UY());
          Object localObject2 = ad.aLL();
          Object localObject1 = new LinkedList();
          localObject2 = ((com.tencent.mm.plugin.exdevice.h.c)localObject2).aAn();
          Object localObject3;
          if ((localObject2 != null) && (((Cursor)localObject2).moveToFirst())) {
            do
            {
              localObject3 = new com.tencent.mm.plugin.exdevice.h.b();
              ((com.tencent.mm.plugin.exdevice.h.b)localObject3).d((Cursor)localObject2);
              ((List)localObject1).add(localObject3);
            } while (((Cursor)localObject2).moveToNext());
          }
          if (localObject2 != null) {
            ((Cursor)localObject2).close();
          }
          localObject1 = ((List)localObject1).iterator();
          label945:
          for (;;)
          {
            Object localObject4;
            if (((Iterator)localObject1).hasNext())
            {
              localObject2 = (com.tencent.mm.plugin.exdevice.h.b)((Iterator)localObject1).next();
              localObject3 = paramString.tbC.iterator();
              do
              {
                if (!((Iterator)localObject3).hasNext()) {
                  break;
                }
                localObject4 = ((axm)((Iterator)localObject3).next()).sBc;
              } while ((!((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_deviceType.equals(((aop)localObject4).syI)) || (!((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_deviceID.equals(((aop)localObject4).hQb)));
            }
            for (int i = 1;; i = 0)
            {
              if (i != 0) {
                break label945;
              }
              y.d("MicroMsg.exdevice.GetBoundDeviceLogic", "delete deviceId %s, deviceType %s ", new Object[] { ((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_deviceID, ((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_deviceType });
              i.d((com.tencent.mm.plugin.exdevice.h.b)localObject2);
              ad.aLL().cS(((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_deviceID, ((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_deviceType);
              ad.aLW();
              e.aq(((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_deviceID, false);
              break;
              localObject1 = paramString.tbC.iterator();
              while (((Iterator)localObject1).hasNext())
              {
                Object localObject5 = (axm)((Iterator)localObject1).next();
                localObject2 = ((axm)localObject5).sBd;
                localObject3 = ((axm)localObject5).sBc;
                if ((localObject3 != null) && (localObject2 != null) && (!bk.bl(((aop)localObject3).hQb)))
                {
                  y.i("MicroMsg.exdevice.GetBoundDeviceLogic", "ModHardDevice deviceId = %s, deviceType = %s, BindFlag = %s", new Object[] { ((aop)localObject3).hQb, ((aop)localObject3).syI, Integer.valueOf(((axm)localObject5).ttS) });
                  localObject4 = ad.aLL().BG(((aop)localObject3).hQb);
                  if (2 == ((axm)localObject5).ttS)
                  {
                    y.w("MicroMsg.exdevice.GetBoundDeviceLogic", "This Device is unbind, Just leave. deviceId = %s, mac = %s, brandName = %s", new Object[] { ((aop)localObject3).hQb, ((aoq)localObject2).sAE, ((aoq)localObject2).tkr });
                    if (localObject4 != null)
                    {
                      i.d((com.tencent.mm.plugin.exdevice.h.b)localObject4);
                      ad.aLL().cS(((com.tencent.mm.plugin.exdevice.h.b)localObject4).field_deviceID, ((com.tencent.mm.plugin.exdevice.h.b)localObject4).field_deviceType);
                      ad.aLW();
                      e.aq(((com.tencent.mm.plugin.exdevice.h.b)localObject4).field_deviceID, false);
                    }
                  }
                  else
                  {
                    localObject5 = new com.tencent.mm.plugin.exdevice.h.b();
                    ((com.tencent.mm.plugin.exdevice.h.b)localObject5).field_deviceID = ((aop)localObject3).hQb;
                    ((com.tencent.mm.plugin.exdevice.h.b)localObject5).field_deviceType = ((aop)localObject3).syI;
                    ((com.tencent.mm.plugin.exdevice.h.b)localObject5).field_connProto = ((aoq)localObject2).tks;
                    ((com.tencent.mm.plugin.exdevice.h.b)localObject5).field_connStrategy = ((aoq)localObject2).tkt;
                    ((com.tencent.mm.plugin.exdevice.h.b)localObject5).field_closeStrategy = ((aoq)localObject2).tku;
                    if ((((aoq)localObject2).cMX == 2) && (localObject4 != null) && (((cc)localObject4).cMT != null)) {
                      ((aoq)localObject2).ffm = ((cc)localObject4).cMT;
                    }
                    ((com.tencent.mm.plugin.exdevice.h.b)localObject5).cZ(((aoq)localObject2).ffm);
                    ((com.tencent.mm.plugin.exdevice.h.b)localObject5).dX(((aoq)localObject2).tkA);
                    ((com.tencent.mm.plugin.exdevice.h.b)localObject5).dW(((aoq)localObject2).tkz);
                    ((com.tencent.mm.plugin.exdevice.h.b)localObject5).dV(((aoq)localObject2).tky);
                    ((com.tencent.mm.plugin.exdevice.h.b)localObject5).fH(((aoq)localObject2).tkB);
                    ((com.tencent.mm.plugin.exdevice.h.b)localObject5).setIconUrl(((aoq)localObject2).kSy);
                    ((com.tencent.mm.plugin.exdevice.h.b)localObject5).dU(((aoq)localObject2).kRP);
                    ((com.tencent.mm.plugin.exdevice.h.b)localObject5).fI(((aoq)localObject2).cMX);
                    ((com.tencent.mm.plugin.exdevice.h.b)localObject5).be(((aoq)localObject2).cMY);
                    ((com.tencent.mm.plugin.exdevice.h.b)localObject5).dY(((aoq)localObject2).cMZ);
                    ((com.tencent.mm.plugin.exdevice.h.b)localObject5).dZ(((aoq)localObject2).cNa);
                    ((com.tencent.mm.plugin.exdevice.h.b)localObject5).ea(((aoq)localObject2).cNb);
                    ((com.tencent.mm.plugin.exdevice.h.b)localObject5).eb(((aoq)localObject2).cNc);
                    ((com.tencent.mm.plugin.exdevice.h.b)localObject5).field_url = "";
                    ((com.tencent.mm.plugin.exdevice.h.b)localObject5).field_mac = com.tencent.mm.plugin.exdevice.j.b.BU(com.tencent.mm.plugin.exdevice.j.b.BV(((aoq)localObject2).sAE));
                    ((com.tencent.mm.plugin.exdevice.h.b)localObject5).field_md5Str = g.o(new String(((aop)localObject3).syI + ((aop)localObject3).hQb).getBytes());
                    ((com.tencent.mm.plugin.exdevice.h.b)localObject5).field_authKey = ((aoq)localObject2).syp;
                    ((com.tencent.mm.plugin.exdevice.h.b)localObject5).field_brandName = ((aoq)localObject2).tkr;
                    if (((com.tencent.mm.plugin.exdevice.h.b)localObject5).field_mac == 0L) {
                      ((com.tencent.mm.plugin.exdevice.h.b)localObject5).field_mac = System.currentTimeMillis();
                    }
                    boolean bool1;
                    if (localObject4 == null)
                    {
                      boolean bool2 = ad.aLL().b((com.tencent.mm.sdk.e.c)localObject5);
                      bool1 = bool2;
                      if (bool2)
                      {
                        ad.aLW();
                        e.aq(((com.tencent.mm.plugin.exdevice.h.b)localObject5).field_deviceID, true);
                        bool1 = bool2;
                      }
                    }
                    for (;;)
                    {
                      y.i("MicroMsg.exdevice.GetBoundDeviceLogic", "insert HardDeviceInfo %s, brandName = %s, deviceID = %s, deviceType = %s, connProto = %s, connStrategy = %s, closeStrategy = %s, mac = %s", new Object[] { Boolean.valueOf(bool1), ((com.tencent.mm.plugin.exdevice.h.b)localObject5).field_brandName, ((com.tencent.mm.plugin.exdevice.h.b)localObject5).field_deviceID, ((aop)localObject3).syI, ((com.tencent.mm.plugin.exdevice.h.b)localObject5).field_connProto, Integer.valueOf(((com.tencent.mm.plugin.exdevice.h.b)localObject5).field_connStrategy), Integer.valueOf(((com.tencent.mm.plugin.exdevice.h.b)localObject5).field_closeStrategy), Long.valueOf(((com.tencent.mm.plugin.exdevice.h.b)localObject5).field_mac) });
                      break;
                      if (ad.aLL().e((com.tencent.mm.plugin.exdevice.h.b)localObject5) == 0) {
                        bool1 = false;
                      } else {
                        bool1 = true;
                      }
                    }
                  }
                }
              }
              return;
            }
          }
        }
      });
      if (this.jvI != null) {
        this.jvI.fB(true);
      }
    } while ((this.dnm == null) || (!this.dnm.isShowing()));
    this.dnm.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.i
 * JD-Core Version:    0.7.0.1
 */