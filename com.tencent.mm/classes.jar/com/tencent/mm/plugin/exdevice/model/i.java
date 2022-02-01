package com.tencent.mm.plugin.exdevice.model;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.c.cw;
import com.tencent.mm.model.az;
import com.tencent.mm.protocal.protobuf.aqw;
import com.tencent.mm.protocal.protobuf.bfj;
import com.tencent.mm.protocal.protobuf.bfk;
import com.tencent.mm.protocal.protobuf.bqu;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.conversation.BaseConversationUI;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public enum i
  implements com.tencent.mm.al.g
{
  ProgressDialog fpP;
  private boolean oVS;
  public WeakReference<a> oVT;
  
  static
  {
    AppMethodBeat.i(23374);
    oVR = new i("INSTANCE");
    oVU = new i[] { oVR };
    AppMethodBeat.o(23374);
  }
  
  private i()
  {
    AppMethodBeat.i(23368);
    this.oVS = false;
    Object localObject = aj.getContext().getSharedPreferences("exdevice_pref", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    az.arV();
    long l = ((SharedPreferences)localObject).getLong(com.tencent.mm.model.c.getUin(), 0L);
    if (l != 0L)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.GetBoundDeviceLogic", "this user has get bound device, last time is %d", new Object[] { Long.valueOf(l) });
      AppMethodBeat.o(23368);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.GetBoundDeviceLogic", "the user has not get bound device yet");
    AppMethodBeat.o(23368);
  }
  
  public static void oN(long paramLong)
  {
    AppMethodBeat.i(23371);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.GetBoundDeviceLogic", "update get bound hard device time : %d", new Object[] { Long.valueOf(paramLong) });
    SharedPreferences.Editor localEditor = aj.getContext().getSharedPreferences("exdevice_pref", 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    az.arV();
    localEditor.putLong(com.tencent.mm.model.c.getUin(), paramLong).commit();
    AppMethodBeat.o(23371);
  }
  
  public final void a(Context paramContext, final a parama)
  {
    AppMethodBeat.i(23369);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.GetBoundDeviceLogic", "startGetBoundHardDevices");
    if (this.oVS)
    {
      if (this.oVT == null) {
        this.oVT = new WeakReference(parama);
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.GetBoundDeviceLogic", "getting bound device now, just leave");
      AppMethodBeat.o(23369);
      return;
    }
    final o localo = new o();
    if ((paramContext != null) && ((paramContext instanceof Activity)) && (!((Activity)paramContext).isFinishing()))
    {
      if ((this.fpP != null) && (this.fpP.isShowing()))
      {
        this.fpP.dismiss();
        this.fpP = null;
      }
      if ((!(paramContext instanceof LauncherUI)) && (!(paramContext instanceof ChattingUI)) && (!(paramContext instanceof BaseConversationUI)))
      {
        paramContext.getString(2131755906);
        this.fpP = h.c(paramContext, paramContext.getString(2131762836), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(23364);
            az.aeS().a(localo);
            if (i.a(i.this) != null) {
              i.a(i.this).dismiss();
            }
            i.b(i.this);
            if (parama != null) {
              parama.jY(false);
            }
            i.c(i.this);
            AppMethodBeat.o(23364);
          }
        });
      }
    }
    this.oVT = new WeakReference(parama);
    az.aeS().a(localo, 0);
    AppMethodBeat.o(23369);
  }
  
  public final boolean jZ(boolean paramBoolean)
  {
    AppMethodBeat.i(23370);
    if (this.oVS)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.GetBoundDeviceLogic", "Getting bound device now, just leave");
      AppMethodBeat.o(23370);
      return false;
    }
    long l1 = System.currentTimeMillis();
    SharedPreferences localSharedPreferences = aj.getContext().getSharedPreferences("exdevice_pref", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    az.arV();
    long l2 = localSharedPreferences.getLong(com.tencent.mm.model.c.getUin(), 0L);
    if ((!paramBoolean) && (l1 - l2 < 86400000L))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.GetBoundDeviceLogic", "GetBoundHardDevices not now pp");
      AppMethodBeat.o(23370);
      return false;
    }
    AppMethodBeat.o(23370);
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(23372);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.GetBoundDeviceLogic", "onSceneEnd errType = " + paramInt1 + ", errCode = " + paramInt2 + ",errMsg = " + paramString);
    this.oVS = false;
    if ((paramn == null) || (paramInt2 != 0) || (paramInt1 != 0))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.GetBoundDeviceLogic", "do scene failed : %d, %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      if ((this.fpP != null) && (this.fpP.isShowing()))
      {
        this.fpP.dismiss();
        this.fpP = null;
      }
      AppMethodBeat.o(23372);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.GetBoundDeviceLogic", "scene.getType() = %s", new Object[] { Integer.valueOf(paramn.getType()) });
    if (paramn.getType() == 539)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.GetBoundDeviceLogic", "scene.getType() = %s, %s, %s", new Object[] { Integer.valueOf(paramn.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        if (this.oVT != null)
        {
          paramString = (a)this.oVT.get();
          if (paramString != null) {
            paramString.jY(false);
          }
        }
        if ((this.fpP != null) && (this.fpP.isShowing()))
        {
          this.fpP.dismiss();
          this.fpP = null;
        }
        AppMethodBeat.o(23372);
        return;
      }
      paramString = (o)paramn;
      if ((paramString.rr != null) && (paramString.rr.gUT.gUX != null)) {}
      for (paramString = (aqw)paramString.rr.gUT.gUX; (paramString == null) || (paramString.DrD == null); paramString = null)
      {
        if (this.oVT != null)
        {
          paramString = (a)this.oVT.get();
          if (paramString != null) {
            paramString.jY(false);
          }
        }
        if ((this.fpP != null) && (this.fpP.isShowing())) {
          this.fpP.dismiss();
        }
        AppMethodBeat.o(23372);
        return;
      }
      az.afE().ax(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(23365);
          i.oN(bt.eGO());
          Object localObject2 = ad.bZG();
          Object localObject1 = new LinkedList();
          localObject2 = ((com.tencent.mm.plugin.exdevice.i.c)localObject2).getAll();
          Object localObject3;
          if ((localObject2 != null) && (((Cursor)localObject2).moveToFirst())) {
            do
            {
              localObject3 = new com.tencent.mm.plugin.exdevice.i.b();
              ((com.tencent.mm.plugin.exdevice.i.b)localObject3).convertFrom((Cursor)localObject2);
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
              localObject2 = (com.tencent.mm.plugin.exdevice.i.b)((Iterator)localObject1).next();
              localObject3 = paramString.DrD.iterator();
              do
              {
                if (!((Iterator)localObject3).hasNext()) {
                  break;
                }
                localObject4 = ((bqu)((Iterator)localObject3).next()).CFB;
              } while ((!((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_deviceType.equals(((bfj)localObject4).CBS)) || (!((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_deviceID.equals(((bfj)localObject4).mAT)));
            }
            for (int i = 1;; i = 0)
            {
              if (i != 0) {
                break label957;
              }
              com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.exdevice.GetBoundDeviceLogic", "delete deviceId %s, deviceType %s ", new Object[] { ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_deviceID, ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_deviceType });
              i.d((com.tencent.mm.plugin.exdevice.i.b)localObject2);
              ad.bZG().fj(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_deviceID, ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_deviceType);
              ad.bZR();
              e.aJ(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_deviceID, false);
              break;
              localObject1 = paramString.DrD.iterator();
              while (((Iterator)localObject1).hasNext())
              {
                Object localObject5 = (bqu)((Iterator)localObject1).next();
                localObject2 = ((bqu)localObject5).CFC;
                localObject3 = ((bqu)localObject5).CFB;
                if ((localObject3 != null) && (localObject2 != null) && (!bt.isNullOrNil(((bfj)localObject3).mAT)))
                {
                  com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.GetBoundDeviceLogic", "ModHardDevice deviceId = %s, deviceType = %s, BindFlag = %s", new Object[] { ((bfj)localObject3).mAT, ((bfj)localObject3).CBS, Integer.valueOf(((bqu)localObject5).DOU) });
                  localObject4 = ad.bZG().UR(((bfj)localObject3).mAT);
                  if (2 == ((bqu)localObject5).DOU)
                  {
                    com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.exdevice.GetBoundDeviceLogic", "This Device is unbind, Just leave. deviceId = %s, mac = %s, brandName = %s", new Object[] { ((bfj)localObject3).mAT, ((bfk)localObject2).CEQ, ((bfk)localObject2).DCD });
                    if (localObject4 != null)
                    {
                      i.d((com.tencent.mm.plugin.exdevice.i.b)localObject4);
                      ad.bZG().fj(((com.tencent.mm.plugin.exdevice.i.b)localObject4).field_deviceID, ((com.tencent.mm.plugin.exdevice.i.b)localObject4).field_deviceType);
                      ad.bZR();
                      e.aJ(((com.tencent.mm.plugin.exdevice.i.b)localObject4).field_deviceID, false);
                    }
                  }
                  else
                  {
                    localObject5 = new com.tencent.mm.plugin.exdevice.i.b();
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_deviceID = ((bfj)localObject3).mAT;
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_deviceType = ((bfj)localObject3).CBS;
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_connProto = ((bfk)localObject2).DCE;
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_connStrategy = ((bfk)localObject2).DCF;
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_closeStrategy = ((bfk)localObject2).DCG;
                    if ((((bfk)localObject2).eKr == 2) && (localObject4 != null) && (((cw)localObject4).eKn != null)) {
                      ((bfk)localObject2).ijR = ((cw)localObject4).eKn;
                    }
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).na(((bfk)localObject2).ijR);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).nT(((bfk)localObject2).DCM);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).nS(((bfk)localObject2).DCL);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).nR(((bfk)localObject2).DCK);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).kd(((bfk)localObject2).DCN);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).nP(((bfk)localObject2).IconUrl);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).nQ(((bfk)localObject2).rZo);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).ke(((bfk)localObject2).eKr);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).kW(((bfk)localObject2).eKs);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).nU(((bfk)localObject2).eKt);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).nV(((bfk)localObject2).eKu);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).nW(((bfk)localObject2).eKv);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).nX(((bfk)localObject2).eKw);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_url = "";
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_mac = com.tencent.mm.plugin.exdevice.k.b.Vg(com.tencent.mm.plugin.exdevice.k.b.Vh(((bfk)localObject2).CEQ));
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_md5Str = com.tencent.mm.b.g.getMessageDigest(new String(((bfj)localObject3).CBS + ((bfj)localObject3).mAT).getBytes());
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_authKey = ((bfk)localObject2).CBj;
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_brandName = ((bfk)localObject2).DCD;
                    if (((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_mac == 0L) {
                      ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_mac = System.currentTimeMillis();
                    }
                    boolean bool1;
                    if (localObject4 == null)
                    {
                      boolean bool2 = ad.bZG().insert((com.tencent.mm.sdk.e.c)localObject5);
                      bool1 = bool2;
                      if (bool2)
                      {
                        ad.bZR();
                        e.aJ(((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_deviceID, true);
                        bool1 = bool2;
                      }
                    }
                    for (;;)
                    {
                      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.GetBoundDeviceLogic", "insert HardDeviceInfo %s, brandName = %s, deviceID = %s, deviceType = %s, connProto = %s, connStrategy = %s, closeStrategy = %s, mac = %s", new Object[] { Boolean.valueOf(bool1), ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_brandName, ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_deviceID, ((bfj)localObject3).CBS, ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_connProto, Integer.valueOf(((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_connStrategy), Integer.valueOf(((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_closeStrategy), Long.valueOf(((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_mac) });
                      break;
                      if (ad.bZG().e((com.tencent.mm.plugin.exdevice.i.b)localObject5) == 0) {
                        bool1 = false;
                      } else {
                        bool1 = true;
                      }
                    }
                  }
                }
              }
              AppMethodBeat.o(23365);
              return;
            }
          }
        }
      });
      if (this.oVT != null)
      {
        paramString = (a)this.oVT.get();
        if (paramString != null) {
          paramString.jY(true);
        }
      }
    }
    if ((this.fpP != null) && (this.fpP.isShowing()))
    {
      this.fpP.dismiss();
      this.fpP = null;
    }
    AppMethodBeat.o(23372);
  }
  
  public static abstract interface a
  {
    public abstract void jY(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.i
 * JD-Core Version:    0.7.0.1
 */