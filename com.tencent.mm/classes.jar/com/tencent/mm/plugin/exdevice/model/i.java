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
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.b.g;
import com.tencent.mm.g.c.do;
import com.tencent.mm.model.bg;
import com.tencent.mm.protocal.protobuf.bjy;
import com.tencent.mm.protocal.protobuf.cat;
import com.tencent.mm.protocal.protobuf.cau;
import com.tencent.mm.protocal.protobuf.cpw;
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
  implements com.tencent.mm.ak.i
{
  ProgressDialog gtM;
  public WeakReference<a> hfj;
  private boolean rAj;
  
  static
  {
    AppMethodBeat.i(23374);
    rAi = new i("INSTANCE");
    rAk = new i[] { rAi };
    AppMethodBeat.o(23374);
  }
  
  private i()
  {
    AppMethodBeat.i(23368);
    this.rAj = false;
    Object localObject = MMApplicationContext.getContext().getSharedPreferences("exdevice_pref", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    bg.aVF();
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
  
  public static void CS(long paramLong)
  {
    AppMethodBeat.i(23371);
    Log.i("MicroMsg.exdevice.GetBoundDeviceLogic", "update get bound hard device time : %d", new Object[] { Long.valueOf(paramLong) });
    SharedPreferences.Editor localEditor = MMApplicationContext.getContext().getSharedPreferences("exdevice_pref", 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    bg.aVF();
    localEditor.putLong(com.tencent.mm.model.c.getUin(), paramLong).commit();
    AppMethodBeat.o(23371);
  }
  
  public final void a(Context paramContext, final a parama)
  {
    AppMethodBeat.i(23369);
    Log.i("MicroMsg.exdevice.GetBoundDeviceLogic", "startGetBoundHardDevices");
    if (this.rAj)
    {
      if (this.hfj == null) {
        this.hfj = new WeakReference(parama);
      }
      Log.i("MicroMsg.exdevice.GetBoundDeviceLogic", "getting bound device now, just leave");
      AppMethodBeat.o(23369);
      return;
    }
    final o localo = new o();
    if ((paramContext != null) && ((paramContext instanceof Activity)) && (!((Activity)paramContext).isFinishing()))
    {
      if ((this.gtM != null) && (this.gtM.isShowing()))
      {
        this.gtM.dismiss();
        this.gtM = null;
      }
      if ((!(paramContext instanceof LauncherUI)) && (!(paramContext instanceof ChattingUI)) && (!(paramContext instanceof BaseConversationUI)))
      {
        paramContext.getString(2131755998);
        this.gtM = h.b(paramContext, paramContext.getString(2131764943), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(23364);
            bg.azz().a(localo);
            if (i.a(i.this) != null) {
              i.a(i.this).dismiss();
            }
            i.b(i.this);
            if (parama != null) {
              parama.lP(false);
            }
            i.c(i.this);
            AppMethodBeat.o(23364);
          }
        });
      }
    }
    this.hfj = new WeakReference(parama);
    bg.azz().a(localo, 0);
    AppMethodBeat.o(23369);
  }
  
  public final boolean lQ(boolean paramBoolean)
  {
    AppMethodBeat.i(23370);
    if (this.rAj)
    {
      Log.i("MicroMsg.exdevice.GetBoundDeviceLogic", "Getting bound device now, just leave");
      AppMethodBeat.o(23370);
      return false;
    }
    long l1 = System.currentTimeMillis();
    SharedPreferences localSharedPreferences = MMApplicationContext.getContext().getSharedPreferences("exdevice_pref", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    bg.aVF();
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
    this.rAj = false;
    if ((paramq == null) || (paramInt2 != 0) || (paramInt1 != 0))
    {
      Log.e("MicroMsg.exdevice.GetBoundDeviceLogic", "do scene failed : %d, %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      if ((this.gtM != null) && (this.gtM.isShowing()))
      {
        this.gtM.dismiss();
        this.gtM = null;
      }
      AppMethodBeat.o(23372);
      return;
    }
    Log.i("MicroMsg.exdevice.GetBoundDeviceLogic", "scene.getType() = %s", new Object[] { Integer.valueOf(paramq.getType()) });
    if (paramq.getType() == 539)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.e("MicroMsg.exdevice.GetBoundDeviceLogic", "scene.getType() = %s, %s, %s", new Object[] { Integer.valueOf(paramq.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        if (this.hfj != null)
        {
          paramString = (a)this.hfj.get();
          if (paramString != null) {
            paramString.lP(false);
          }
        }
        if ((this.gtM != null) && (this.gtM.isShowing()))
        {
          this.gtM.dismiss();
          this.gtM = null;
        }
        AppMethodBeat.o(23372);
        return;
      }
      paramString = (o)paramq;
      if ((paramString.rr != null) && (paramString.rr.iLL.iLR != null)) {}
      for (paramString = (bjy)paramString.rr.iLL.iLR; (paramString == null) || (paramString.LTo == null); paramString = null)
      {
        if (this.hfj != null)
        {
          paramString = (a)this.hfj.get();
          if (paramString != null) {
            paramString.lP(false);
          }
        }
        if ((this.gtM != null) && (this.gtM.isShowing())) {
          this.gtM.dismiss();
        }
        AppMethodBeat.o(23372);
        return;
      }
      bg.aAk().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(23365);
          i.CS(Util.nowMilliSecond());
          Object localObject2 = ad.cKL();
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
              localObject3 = paramString.LTo.iterator();
              do
              {
                if (!((Iterator)localObject3).hasNext()) {
                  break;
                }
                localObject4 = ((cpw)((Iterator)localObject3).next()).KPD;
              } while ((!((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_deviceType.equals(((cat)localObject4).KLO)) || (!((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_deviceID.equals(((cat)localObject4).oTH)));
            }
            for (int i = 1;; i = 0)
            {
              if (i != 0) {
                break label957;
              }
              Log.d("MicroMsg.exdevice.GetBoundDeviceLogic", "delete deviceId %s, deviceType %s ", new Object[] { ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_deviceID, ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_deviceType });
              i.d((com.tencent.mm.plugin.exdevice.i.b)localObject2);
              ad.cKL().gd(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_deviceID, ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_deviceType);
              ad.cKW();
              e.aQ(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_deviceID, false);
              break;
              localObject1 = paramString.LTo.iterator();
              while (((Iterator)localObject1).hasNext())
              {
                Object localObject5 = (cpw)((Iterator)localObject1).next();
                localObject2 = ((cpw)localObject5).KPE;
                localObject3 = ((cpw)localObject5).KPD;
                if ((localObject3 != null) && (localObject2 != null) && (!Util.isNullOrNil(((cat)localObject3).oTH)))
                {
                  Log.i("MicroMsg.exdevice.GetBoundDeviceLogic", "ModHardDevice deviceId = %s, deviceType = %s, BindFlag = %s", new Object[] { ((cat)localObject3).oTH, ((cat)localObject3).KLO, Integer.valueOf(((cpw)localObject5).MvP) });
                  localObject4 = ad.cKL().anJ(((cat)localObject3).oTH);
                  if (2 == ((cpw)localObject5).MvP)
                  {
                    Log.w("MicroMsg.exdevice.GetBoundDeviceLogic", "This Device is unbind, Just leave. deviceId = %s, mac = %s, brandName = %s", new Object[] { ((cat)localObject3).oTH, ((cau)localObject2).KOS, ((cau)localObject2).MfY });
                    if (localObject4 != null)
                    {
                      i.d((com.tencent.mm.plugin.exdevice.i.b)localObject4);
                      ad.cKL().gd(((com.tencent.mm.plugin.exdevice.i.b)localObject4).field_deviceID, ((com.tencent.mm.plugin.exdevice.i.b)localObject4).field_deviceType);
                      ad.cKW();
                      e.aQ(((com.tencent.mm.plugin.exdevice.i.b)localObject4).field_deviceID, false);
                    }
                  }
                  else
                  {
                    localObject5 = new com.tencent.mm.plugin.exdevice.i.b();
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_deviceID = ((cat)localObject3).oTH;
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_deviceType = ((cat)localObject3).KLO;
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_connProto = ((cau)localObject2).MfZ;
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_connStrategy = ((cau)localObject2).Mga;
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_closeStrategy = ((cau)localObject2).Mgb;
                    if ((((cau)localObject2).fMf == 2) && (localObject4 != null) && (((do)localObject4).fMb != null)) {
                      ((cau)localObject2).ked = ((do)localObject4).fMb;
                    }
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).BC(((cau)localObject2).ked);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).Ct(((cau)localObject2).Mgh);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).Cs(((cau)localObject2).Mgg);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).Cr(((cau)localObject2).Mgf);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).nE(((cau)localObject2).Mgi);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).setIconUrl(((cau)localObject2).IconUrl);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).Cq(((cau)localObject2).xIy);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).nF(((cau)localObject2).fMf);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).yE(((cau)localObject2).fMg);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).Cu(((cau)localObject2).fMh);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).Cv(((cau)localObject2).fMi);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).Cw(((cau)localObject2).fMj);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).Cx(((cau)localObject2).fMk);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_url = "";
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_mac = com.tencent.mm.plugin.exdevice.k.b.anY(com.tencent.mm.plugin.exdevice.k.b.anZ(((cau)localObject2).KOS));
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_md5Str = g.getMessageDigest(new String(((cat)localObject3).KLO + ((cat)localObject3).oTH).getBytes());
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_authKey = ((cau)localObject2).KLg;
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_brandName = ((cau)localObject2).MfY;
                    if (((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_mac == 0L) {
                      ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_mac = System.currentTimeMillis();
                    }
                    boolean bool1;
                    if (localObject4 == null)
                    {
                      boolean bool2 = ad.cKL().insert((IAutoDBItem)localObject5);
                      bool1 = bool2;
                      if (bool2)
                      {
                        ad.cKW();
                        e.aQ(((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_deviceID, true);
                        bool1 = bool2;
                      }
                    }
                    for (;;)
                    {
                      Log.i("MicroMsg.exdevice.GetBoundDeviceLogic", "insert HardDeviceInfo %s, brandName = %s, deviceID = %s, deviceType = %s, connProto = %s, connStrategy = %s, closeStrategy = %s, mac = %s", new Object[] { Boolean.valueOf(bool1), ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_brandName, ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_deviceID, ((cat)localObject3).KLO, ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_connProto, Integer.valueOf(((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_connStrategy), Integer.valueOf(((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_closeStrategy), Long.valueOf(((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_mac) });
                      break;
                      if (ad.cKL().e((com.tencent.mm.plugin.exdevice.i.b)localObject5) == 0) {
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
      if (this.hfj != null)
      {
        paramString = (a)this.hfj.get();
        if (paramString != null) {
          paramString.lP(true);
        }
      }
    }
    if ((this.gtM != null) && (this.gtM.isShowing()))
    {
      this.gtM.dismiss();
      this.gtM = null;
    }
    AppMethodBeat.o(23372);
  }
  
  public static abstract interface a
  {
    public abstract void lP(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.i
 * JD-Core Version:    0.7.0.1
 */