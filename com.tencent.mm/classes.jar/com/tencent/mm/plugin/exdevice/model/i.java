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
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.b.g;
import com.tencent.mm.g.c.di;
import com.tencent.mm.model.ba;
import com.tencent.mm.protocal.protobuf.axy;
import com.tencent.mm.protocal.protobuf.bnj;
import com.tencent.mm.protocal.protobuf.bnk;
import com.tencent.mm.protocal.protobuf.caa;
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
  implements f
{
  ProgressDialog fMu;
  private boolean qcI;
  public WeakReference<a> qcJ;
  
  static
  {
    AppMethodBeat.i(23374);
    qcH = new i("INSTANCE");
    qcK = new i[] { qcH };
    AppMethodBeat.o(23374);
  }
  
  private i()
  {
    AppMethodBeat.i(23368);
    this.qcI = false;
    Object localObject = aj.getContext().getSharedPreferences("exdevice_pref", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    ba.aBQ();
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
  
  public static void ux(long paramLong)
  {
    AppMethodBeat.i(23371);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.GetBoundDeviceLogic", "update get bound hard device time : %d", new Object[] { Long.valueOf(paramLong) });
    SharedPreferences.Editor localEditor = aj.getContext().getSharedPreferences("exdevice_pref", 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    ba.aBQ();
    localEditor.putLong(com.tencent.mm.model.c.getUin(), paramLong).commit();
    AppMethodBeat.o(23371);
  }
  
  public final void a(Context paramContext, final a parama)
  {
    AppMethodBeat.i(23369);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.GetBoundDeviceLogic", "startGetBoundHardDevices");
    if (this.qcI)
    {
      if (this.qcJ == null) {
        this.qcJ = new WeakReference(parama);
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.GetBoundDeviceLogic", "getting bound device now, just leave");
      AppMethodBeat.o(23369);
      return;
    }
    final o localo = new o();
    if ((paramContext != null) && ((paramContext instanceof Activity)) && (!((Activity)paramContext).isFinishing()))
    {
      if ((this.fMu != null) && (this.fMu.isShowing()))
      {
        this.fMu.dismiss();
        this.fMu = null;
      }
      if ((!(paramContext instanceof LauncherUI)) && (!(paramContext instanceof ChattingUI)) && (!(paramContext instanceof BaseConversationUI)))
      {
        paramContext.getString(2131755906);
        this.fMu = h.c(paramContext, paramContext.getString(2131762836), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(23364);
            ba.aiU().a(localo);
            if (i.a(i.this) != null) {
              i.a(i.this).dismiss();
            }
            i.b(i.this);
            if (parama != null) {
              parama.kN(false);
            }
            i.c(i.this);
            AppMethodBeat.o(23364);
          }
        });
      }
    }
    this.qcJ = new WeakReference(parama);
    ba.aiU().a(localo, 0);
    AppMethodBeat.o(23369);
  }
  
  public final boolean kO(boolean paramBoolean)
  {
    AppMethodBeat.i(23370);
    if (this.qcI)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.GetBoundDeviceLogic", "Getting bound device now, just leave");
      AppMethodBeat.o(23370);
      return false;
    }
    long l1 = System.currentTimeMillis();
    SharedPreferences localSharedPreferences = aj.getContext().getSharedPreferences("exdevice_pref", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    ba.aBQ();
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
    this.qcI = false;
    if ((paramn == null) || (paramInt2 != 0) || (paramInt1 != 0))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.GetBoundDeviceLogic", "do scene failed : %d, %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      if ((this.fMu != null) && (this.fMu.isShowing()))
      {
        this.fMu.dismiss();
        this.fMu = null;
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
        if (this.qcJ != null)
        {
          paramString = (a)this.qcJ.get();
          if (paramString != null) {
            paramString.kN(false);
          }
        }
        if ((this.fMu != null) && (this.fMu.isShowing()))
        {
          this.fMu.dismiss();
          this.fMu = null;
        }
        AppMethodBeat.o(23372);
        return;
      }
      paramString = (o)paramn;
      if ((paramString.rr != null) && (paramString.rr.hNL.hNQ != null)) {}
      for (paramString = (axy)paramString.rr.hNL.hNQ; (paramString == null) || (paramString.GvJ == null); paramString = null)
      {
        if (this.qcJ != null)
        {
          paramString = (a)this.qcJ.get();
          if (paramString != null) {
            paramString.kN(false);
          }
        }
        if ((this.fMu != null) && (this.fMu.isShowing())) {
          this.fMu.dismiss();
        }
        AppMethodBeat.o(23372);
        return;
      }
      ba.ajF().ay(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(23365);
          i.ux(bt.flT());
          Object localObject2 = ad.clt();
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
              localObject3 = paramString.GvJ.iterator();
              do
              {
                if (!((Iterator)localObject3).hasNext()) {
                  break;
                }
                localObject4 = ((caa)((Iterator)localObject3).next()).FDx;
              } while ((!((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_deviceType.equals(((bnj)localObject4).FzJ)) || (!((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_deviceID.equals(((bnj)localObject4).nDr)));
            }
            for (int i = 1;; i = 0)
            {
              if (i != 0) {
                break label957;
              }
              com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.exdevice.GetBoundDeviceLogic", "delete deviceId %s, deviceType %s ", new Object[] { ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_deviceID, ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_deviceType });
              i.d((com.tencent.mm.plugin.exdevice.i.b)localObject2);
              ad.clt().fG(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_deviceID, ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_deviceType);
              ad.clE();
              e.aM(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_deviceID, false);
              break;
              localObject1 = paramString.GvJ.iterator();
              while (((Iterator)localObject1).hasNext())
              {
                Object localObject5 = (caa)((Iterator)localObject1).next();
                localObject2 = ((caa)localObject5).FDy;
                localObject3 = ((caa)localObject5).FDx;
                if ((localObject3 != null) && (localObject2 != null) && (!bt.isNullOrNil(((bnj)localObject3).nDr)))
                {
                  com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.GetBoundDeviceLogic", "ModHardDevice deviceId = %s, deviceType = %s, BindFlag = %s", new Object[] { ((bnj)localObject3).nDr, ((bnj)localObject3).FzJ, Integer.valueOf(((caa)localObject5).GUT) });
                  localObject4 = ad.clt().acJ(((bnj)localObject3).nDr);
                  if (2 == ((caa)localObject5).GUT)
                  {
                    com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.exdevice.GetBoundDeviceLogic", "This Device is unbind, Just leave. deviceId = %s, mac = %s, brandName = %s", new Object[] { ((bnj)localObject3).nDr, ((bnk)localObject2).FCM, ((bnk)localObject2).GHv });
                    if (localObject4 != null)
                    {
                      i.d((com.tencent.mm.plugin.exdevice.i.b)localObject4);
                      ad.clt().fG(((com.tencent.mm.plugin.exdevice.i.b)localObject4).field_deviceID, ((com.tencent.mm.plugin.exdevice.i.b)localObject4).field_deviceType);
                      ad.clE();
                      e.aM(((com.tencent.mm.plugin.exdevice.i.b)localObject4).field_deviceID, false);
                    }
                  }
                  else
                  {
                    localObject5 = new com.tencent.mm.plugin.exdevice.i.b();
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_deviceID = ((bnj)localObject3).nDr;
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_deviceType = ((bnj)localObject3).FzJ;
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_connProto = ((bnk)localObject2).GHw;
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_connStrategy = ((bnk)localObject2).GHx;
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_closeStrategy = ((bnk)localObject2).GHy;
                    if ((((bnk)localObject2).ffF == 2) && (localObject4 != null) && (((di)localObject4).ffB != null)) {
                      ((bnk)localObject2).jdh = ((di)localObject4).ffB;
                    }
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).sQ(((bnk)localObject2).jdh);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).tI(((bnk)localObject2).GHE);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).tH(((bnk)localObject2).GHD);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).tG(((bnk)localObject2).GHC);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).kz(((bnk)localObject2).GHF);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).setIconUrl(((bnk)localObject2).IconUrl);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).tF(((bnk)localObject2).ueY);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).kA(((bnk)localObject2).ffF);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).qy(((bnk)localObject2).ffG);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).tJ(((bnk)localObject2).ffH);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).tK(((bnk)localObject2).ffI);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).tL(((bnk)localObject2).ffJ);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).tM(((bnk)localObject2).ffK);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_url = "";
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_mac = com.tencent.mm.plugin.exdevice.k.b.acY(com.tencent.mm.plugin.exdevice.k.b.acZ(((bnk)localObject2).FCM));
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_md5Str = g.getMessageDigest(new String(((bnj)localObject3).FzJ + ((bnj)localObject3).nDr).getBytes());
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_authKey = ((bnk)localObject2).Fzb;
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_brandName = ((bnk)localObject2).GHv;
                    if (((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_mac == 0L) {
                      ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_mac = System.currentTimeMillis();
                    }
                    boolean bool1;
                    if (localObject4 == null)
                    {
                      boolean bool2 = ad.clt().insert((com.tencent.mm.sdk.e.c)localObject5);
                      bool1 = bool2;
                      if (bool2)
                      {
                        ad.clE();
                        e.aM(((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_deviceID, true);
                        bool1 = bool2;
                      }
                    }
                    for (;;)
                    {
                      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.GetBoundDeviceLogic", "insert HardDeviceInfo %s, brandName = %s, deviceID = %s, deviceType = %s, connProto = %s, connStrategy = %s, closeStrategy = %s, mac = %s", new Object[] { Boolean.valueOf(bool1), ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_brandName, ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_deviceID, ((bnj)localObject3).FzJ, ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_connProto, Integer.valueOf(((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_connStrategy), Integer.valueOf(((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_closeStrategy), Long.valueOf(((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_mac) });
                      break;
                      if (ad.clt().e((com.tencent.mm.plugin.exdevice.i.b)localObject5) == 0) {
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
      if (this.qcJ != null)
      {
        paramString = (a)this.qcJ.get();
        if (paramString != null) {
          paramString.kN(true);
        }
      }
    }
    if ((this.fMu != null) && (this.fMu.isShowing()))
    {
      this.fMu.dismiss();
      this.fMu = null;
    }
    AppMethodBeat.o(23372);
  }
  
  public static abstract interface a
  {
    public abstract void kN(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.i
 * JD-Core Version:    0.7.0.1
 */