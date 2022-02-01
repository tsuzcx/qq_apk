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
import com.tencent.mm.R.l;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.b.g;
import com.tencent.mm.f.c.ds;
import com.tencent.mm.model.bh;
import com.tencent.mm.protocal.protobuf.brh;
import com.tencent.mm.protocal.protobuf.ceq;
import com.tencent.mm.protocal.protobuf.ciu;
import com.tencent.mm.protocal.protobuf.civ;
import com.tencent.mm.protocal.protobuf.cym;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.conversation.BaseConversationUI;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public enum i
  implements com.tencent.mm.an.i
{
  ProgressDialog iXX;
  public WeakReference<a> jRb;
  private boolean vfQ;
  
  static
  {
    AppMethodBeat.i(23374);
    vfP = new i("INSTANCE");
    vfR = new i[] { vfP };
    AppMethodBeat.o(23374);
  }
  
  private i()
  {
    AppMethodBeat.i(23368);
    this.vfQ = false;
    Object localObject = MMApplicationContext.getContext().getSharedPreferences("exdevice_pref", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    bh.beI();
    long l = ((SharedPreferences)localObject).getLong(com.tencent.mm.model.c.getUin(), 0L);
    if (l != 0L)
    {
      Log.i("MicroMsg.exdevice.GetBoundDeviceLogic", "this user has get bound device, last time is %d", new Object[] { Long.valueOf(l) });
      AppMethodBeat.o(23368);
      return;
    }
    Log.i("MicroMsg.exdevice.GetBoundDeviceLogic", "the user has not get bound device yet");
    AppMethodBeat.o(23368);
  }
  
  public static void Jg(long paramLong)
  {
    AppMethodBeat.i(23371);
    Log.i("MicroMsg.exdevice.GetBoundDeviceLogic", "update get bound hard device time : %d", new Object[] { Long.valueOf(paramLong) });
    SharedPreferences.Editor localEditor = MMApplicationContext.getContext().getSharedPreferences("exdevice_pref", 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    bh.beI();
    localEditor.putLong(com.tencent.mm.model.c.getUin(), paramLong).commit();
    AppMethodBeat.o(23371);
  }
  
  private static void cZn()
  {
    AppMethodBeat.i(286380);
    Log.i("MicroMsg.exdevice.GetBoundDeviceLogic", "startGetUserBindIotDevices");
    bh.aGY().cancel(6693);
    r localr = new r();
    bh.aGY().a(localr, 0);
    AppMethodBeat.o(286380);
  }
  
  public final void a(Context paramContext, final a parama)
  {
    AppMethodBeat.i(23369);
    Log.i("MicroMsg.exdevice.GetBoundDeviceLogic", "startGetBoundHardDevices");
    if (this.vfQ)
    {
      if (this.jRb == null) {
        this.jRb = new WeakReference(parama);
      }
      Log.i("MicroMsg.exdevice.GetBoundDeviceLogic", "getting bound device now, just leave");
      AppMethodBeat.o(23369);
      return;
    }
    final o localo = new o();
    if ((paramContext != null) && ((paramContext instanceof Activity)) && (!((Activity)paramContext).isFinishing()))
    {
      if ((this.iXX != null) && (this.iXX.isShowing()))
      {
        this.iXX.dismiss();
        this.iXX = null;
      }
      if ((!(paramContext instanceof LauncherUI)) && (!(paramContext instanceof ChattingUI)) && (!(paramContext instanceof BaseConversationUI)))
      {
        paramContext.getString(R.l.app_tip);
        this.iXX = h.b(paramContext, paramContext.getString(R.l.eRw), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(23364);
            bh.aGY().a(localo);
            if (i.a(i.this) != null) {
              i.a(i.this).dismiss();
            }
            i.b(i.this);
            if (parama != null) {
              parama.na(false);
            }
            i.c(i.this);
            AppMethodBeat.o(23364);
          }
        });
      }
    }
    this.jRb = new WeakReference(parama);
    bh.aGY().a(localo, 0);
    this.vfQ = true;
    cZn();
    AppMethodBeat.o(23369);
  }
  
  public final boolean nb(boolean paramBoolean)
  {
    AppMethodBeat.i(23370);
    if (this.vfQ)
    {
      Log.i("MicroMsg.exdevice.GetBoundDeviceLogic", "Getting bound device now, just leave");
      AppMethodBeat.o(23370);
      return false;
    }
    long l1 = System.currentTimeMillis();
    SharedPreferences localSharedPreferences = MMApplicationContext.getContext().getSharedPreferences("exdevice_pref", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    bh.beI();
    long l2 = localSharedPreferences.getLong(com.tencent.mm.model.c.getUin(), 0L);
    if ((!paramBoolean) && (l1 - l2 < 86400000L))
    {
      Log.i("MicroMsg.exdevice.GetBoundDeviceLogic", "GetBoundHardDevices not now pp");
      AppMethodBeat.o(23370);
      return false;
    }
    AppMethodBeat.o(23370);
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, q paramq)
  {
    AppMethodBeat.i(23372);
    Log.i("MicroMsg.exdevice.GetBoundDeviceLogic", "onSceneEnd errType = " + paramInt1 + ", errCode = " + paramInt2 + ",errMsg = " + paramString);
    if (paramq == null)
    {
      Log.e("MicroMsg.exdevice.GetBoundDeviceLogic", "scene == null, do scene failed : %d, %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      if ((this.iXX != null) && (this.iXX.isShowing()))
      {
        this.iXX.dismiss();
        this.iXX = null;
      }
      AppMethodBeat.o(23372);
      return;
    }
    Log.i("MicroMsg.exdevice.GetBoundDeviceLogic", "scene.getType() = %s", new Object[] { Integer.valueOf(paramq.getType()) });
    if (paramq.getType() == 539)
    {
      this.vfQ = false;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.e("MicroMsg.exdevice.GetBoundDeviceLogic", "scene.getType() = %s, %s, %s", new Object[] { Integer.valueOf(paramq.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        if (this.jRb != null)
        {
          paramString = (a)this.jRb.get();
          if (paramString != null) {
            paramString.na(false);
          }
        }
        if ((this.iXX != null) && (this.iXX.isShowing()))
        {
          this.iXX.dismiss();
          this.iXX = null;
        }
        AppMethodBeat.o(23372);
        return;
      }
      paramString = (o)paramq;
      if ((paramString.rr != null) && (d.c.b(paramString.rr.lBS) != null)) {}
      for (paramString = (brh)d.c.b(paramString.rr.lBS); (paramString == null) || (paramString.TbY == null); paramString = null)
      {
        if (this.jRb != null)
        {
          paramString = (a)this.jRb.get();
          if (paramString != null) {
            paramString.na(false);
          }
        }
        if ((this.iXX != null) && (this.iXX.isShowing())) {
          this.iXX.dismiss();
        }
        AppMethodBeat.o(23372);
        return;
      }
      bh.aHJ().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(23365);
          i.Jg(Util.nowMilliSecond());
          Object localObject2 = ae.cZx();
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
              localObject3 = paramString.TbY.iterator();
              do
              {
                if (!((Iterator)localObject3).hasNext()) {
                  break;
                }
                localObject4 = ((cym)((Iterator)localObject3).next()).RQB;
              } while ((!((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_deviceType.equals(((ciu)localObject4).RMK)) || (!((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_deviceID.equals(((ciu)localObject4).rVF)));
            }
            for (int i = 1;; i = 0)
            {
              if (i != 0) {
                break label957;
              }
              Log.d("MicroMsg.exdevice.GetBoundDeviceLogic", "delete deviceId %s, deviceType %s ", new Object[] { ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_deviceID, ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_deviceType });
              i.d((com.tencent.mm.plugin.exdevice.i.b)localObject2);
              ae.cZx().gs(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_deviceID, ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_deviceType);
              ae.cZJ();
              e.aT(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_deviceID, false);
              break;
              localObject1 = paramString.TbY.iterator();
              while (((Iterator)localObject1).hasNext())
              {
                Object localObject5 = (cym)((Iterator)localObject1).next();
                localObject2 = ((cym)localObject5).RQC;
                localObject3 = ((cym)localObject5).RQB;
                if ((localObject3 != null) && (localObject2 != null) && (!Util.isNullOrNil(((ciu)localObject3).rVF)))
                {
                  Log.i("MicroMsg.exdevice.GetBoundDeviceLogic", "ModHardDevice deviceId = %s, deviceType = %s, BindFlag = %s", new Object[] { ((ciu)localObject3).rVF, ((ciu)localObject3).RMK, Integer.valueOf(((cym)localObject5).TGN) });
                  localObject4 = ae.cZx().avI(((ciu)localObject3).rVF);
                  if (2 == ((cym)localObject5).TGN)
                  {
                    Log.w("MicroMsg.exdevice.GetBoundDeviceLogic", "This Device is unbind, Just leave. deviceId = %s, mac = %s, brandName = %s", new Object[] { ((ciu)localObject3).rVF, ((civ)localObject2).RPQ, ((civ)localObject2).TpK });
                    if (localObject4 != null)
                    {
                      i.d((com.tencent.mm.plugin.exdevice.i.b)localObject4);
                      ae.cZx().gs(((com.tencent.mm.plugin.exdevice.i.b)localObject4).field_deviceID, ((com.tencent.mm.plugin.exdevice.i.b)localObject4).field_deviceType);
                      ae.cZJ();
                      e.aT(((com.tencent.mm.plugin.exdevice.i.b)localObject4).field_deviceID, false);
                    }
                  }
                  else
                  {
                    localObject5 = new com.tencent.mm.plugin.exdevice.i.b();
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_deviceID = ((ciu)localObject3).rVF;
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_deviceType = ((ciu)localObject3).RMK;
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_connProto = ((civ)localObject2).TpL;
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_connStrategy = ((civ)localObject2).TpM;
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_closeStrategy = ((civ)localObject2).TpN;
                    if ((((civ)localObject2).idX == 2) && (localObject4 != null) && (((ds)localObject4).idS != null)) {
                      ((civ)localObject2).mVD = ((ds)localObject4).idS;
                    }
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).Iq(((civ)localObject2).mVD);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).Jh(((civ)localObject2).TpT);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).Jg(((civ)localObject2).TpS);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).Jf(((civ)localObject2).TpR);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).pT(((civ)localObject2).TpU);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).setIconUrl(((civ)localObject2).CNj);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).Je(((civ)localObject2).CMD);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).pU(((civ)localObject2).idX);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).EF(((civ)localObject2).idY);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).Ji(((civ)localObject2).idZ);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).Jj(((civ)localObject2).iea);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).Jk(((civ)localObject2).ieb);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).Jl(((civ)localObject2).iec);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_url = "";
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_mac = com.tencent.mm.plugin.exdevice.k.b.avW(com.tencent.mm.plugin.exdevice.k.b.avX(((civ)localObject2).RPQ));
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_md5Str = g.getMessageDigest(new String(((ciu)localObject3).RMK + ((ciu)localObject3).rVF).getBytes());
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_authKey = ((civ)localObject2).RMc;
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_brandName = ((civ)localObject2).TpK;
                    if (((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_mac == 0L) {
                      ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_mac = System.currentTimeMillis();
                    }
                    boolean bool1;
                    if (localObject4 == null)
                    {
                      boolean bool2 = ae.cZx().insert((IAutoDBItem)localObject5);
                      bool1 = bool2;
                      if (bool2)
                      {
                        ae.cZJ();
                        e.aT(((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_deviceID, true);
                        bool1 = bool2;
                      }
                    }
                    for (;;)
                    {
                      Log.i("MicroMsg.exdevice.GetBoundDeviceLogic", "insert HardDeviceInfo %s, brandName = %s, deviceID = %s, deviceType = %s, connProto = %s, connStrategy = %s, closeStrategy = %s, mac = %s", new Object[] { Boolean.valueOf(bool1), ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_brandName, ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_deviceID, ((ciu)localObject3).RMK, ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_connProto, Integer.valueOf(((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_connStrategy), Integer.valueOf(((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_closeStrategy), Long.valueOf(((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_mac) });
                      break;
                      if (ae.cZx().e((com.tencent.mm.plugin.exdevice.i.b)localObject5) == 0) {
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
      if (this.jRb != null)
      {
        paramString = (a)this.jRb.get();
        if (paramString != null) {
          paramString.na(true);
        }
      }
      if ((this.iXX != null) && (this.iXX.isShowing()))
      {
        this.iXX.dismiss();
        this.iXX = null;
      }
      AppMethodBeat.o(23372);
      return;
    }
    if (paramq.getType() == 6693)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.e("MicroMsg.exdevice.GetBoundDeviceLogic", "scene.getType() = %s, %s, %s", new Object[] { Integer.valueOf(paramq.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        AppMethodBeat.o(23372);
        return;
      }
      paramString = (r)paramq;
      if ((paramString.rr != null) && (d.c.b(paramString.rr.lBS) != null)) {}
      for (paramString = (ceq)d.c.b(paramString.rr.lBS); paramString == null; paramString = null)
      {
        Log.e("MicroMsg.exdevice.GetBoundDeviceLogic", "nsResp == null, bind iot device");
        AppMethodBeat.o(23372);
        return;
      }
      Log.i("MicroMsg.exdevice.GetBoundDeviceLogic", "device_cnt:%d", new Object[] { Integer.valueOf(paramString.Tmj) });
      ae.Kg(paramString.Tmj);
    }
    AppMethodBeat.o(23372);
  }
  
  public static abstract interface a
  {
    public abstract void na(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.i
 * JD-Core Version:    0.7.0.1
 */