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
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.cy;
import com.tencent.mm.model.az;
import com.tencent.mm.protocal.protobuf.aua;
import com.tencent.mm.protocal.protobuf.bjb;
import com.tencent.mm.protocal.protobuf.bjc;
import com.tencent.mm.protocal.protobuf.bvl;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.conversation.BaseConversationUI;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public enum i
  implements com.tencent.mm.ak.g
{
  ProgressDialog fts;
  private boolean pzd;
  public WeakReference<a> pze;
  
  static
  {
    AppMethodBeat.i(23374);
    pzc = new i("INSTANCE");
    pzf = new i[] { pzc };
    AppMethodBeat.o(23374);
  }
  
  private i()
  {
    AppMethodBeat.i(23368);
    this.pzd = false;
    Object localObject = ai.getContext().getSharedPreferences("exdevice_pref", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    az.ayM();
    long l = ((SharedPreferences)localObject).getLong(com.tencent.mm.model.c.getUin(), 0L);
    if (l != 0L)
    {
      ac.i("MicroMsg.exdevice.GetBoundDeviceLogic", "this user has get bound device, last time is %d", new Object[] { Long.valueOf(l) });
      AppMethodBeat.o(23368);
      return;
    }
    ac.i("MicroMsg.exdevice.GetBoundDeviceLogic", "the user has not get bound device yet");
    AppMethodBeat.o(23368);
  }
  
  public static void sz(long paramLong)
  {
    AppMethodBeat.i(23371);
    ac.i("MicroMsg.exdevice.GetBoundDeviceLogic", "update get bound hard device time : %d", new Object[] { Long.valueOf(paramLong) });
    SharedPreferences.Editor localEditor = ai.getContext().getSharedPreferences("exdevice_pref", 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    az.ayM();
    localEditor.putLong(com.tencent.mm.model.c.getUin(), paramLong).commit();
    AppMethodBeat.o(23371);
  }
  
  public final void a(Context paramContext, final a parama)
  {
    AppMethodBeat.i(23369);
    ac.i("MicroMsg.exdevice.GetBoundDeviceLogic", "startGetBoundHardDevices");
    if (this.pzd)
    {
      if (this.pze == null) {
        this.pze = new WeakReference(parama);
      }
      ac.i("MicroMsg.exdevice.GetBoundDeviceLogic", "getting bound device now, just leave");
      AppMethodBeat.o(23369);
      return;
    }
    final o localo = new o();
    if ((paramContext != null) && ((paramContext instanceof Activity)) && (!((Activity)paramContext).isFinishing()))
    {
      if ((this.fts != null) && (this.fts.isShowing()))
      {
        this.fts.dismiss();
        this.fts = null;
      }
      if ((!(paramContext instanceof LauncherUI)) && (!(paramContext instanceof ChattingUI)) && (!(paramContext instanceof BaseConversationUI)))
      {
        paramContext.getString(2131755906);
        this.fts = h.c(paramContext, paramContext.getString(2131762836), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(23364);
            az.agi().a(localo);
            if (i.a(i.this) != null) {
              i.a(i.this).dismiss();
            }
            i.b(i.this);
            if (parama != null) {
              parama.kC(false);
            }
            i.c(i.this);
            AppMethodBeat.o(23364);
          }
        });
      }
    }
    this.pze = new WeakReference(parama);
    az.agi().a(localo, 0);
    AppMethodBeat.o(23369);
  }
  
  public final boolean kD(boolean paramBoolean)
  {
    AppMethodBeat.i(23370);
    if (this.pzd)
    {
      ac.i("MicroMsg.exdevice.GetBoundDeviceLogic", "Getting bound device now, just leave");
      AppMethodBeat.o(23370);
      return false;
    }
    long l1 = System.currentTimeMillis();
    SharedPreferences localSharedPreferences = ai.getContext().getSharedPreferences("exdevice_pref", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    az.ayM();
    long l2 = localSharedPreferences.getLong(com.tencent.mm.model.c.getUin(), 0L);
    if ((!paramBoolean) && (l1 - l2 < 86400000L))
    {
      ac.i("MicroMsg.exdevice.GetBoundDeviceLogic", "GetBoundHardDevices not now pp");
      AppMethodBeat.o(23370);
      return false;
    }
    AppMethodBeat.o(23370);
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(23372);
    ac.i("MicroMsg.exdevice.GetBoundDeviceLogic", "onSceneEnd errType = " + paramInt1 + ", errCode = " + paramInt2 + ",errMsg = " + paramString);
    this.pzd = false;
    if ((paramn == null) || (paramInt2 != 0) || (paramInt1 != 0))
    {
      ac.e("MicroMsg.exdevice.GetBoundDeviceLogic", "do scene failed : %d, %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      if ((this.fts != null) && (this.fts.isShowing()))
      {
        this.fts.dismiss();
        this.fts = null;
      }
      AppMethodBeat.o(23372);
      return;
    }
    ac.i("MicroMsg.exdevice.GetBoundDeviceLogic", "scene.getType() = %s", new Object[] { Integer.valueOf(paramn.getType()) });
    if (paramn.getType() == 539)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ac.e("MicroMsg.exdevice.GetBoundDeviceLogic", "scene.getType() = %s, %s, %s", new Object[] { Integer.valueOf(paramn.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        if (this.pze != null)
        {
          paramString = (a)this.pze.get();
          if (paramString != null) {
            paramString.kC(false);
          }
        }
        if ((this.fts != null) && (this.fts.isShowing()))
        {
          this.fts.dismiss();
          this.fts = null;
        }
        AppMethodBeat.o(23372);
        return;
      }
      paramString = (o)paramn;
      if ((paramString.rr != null) && (paramString.rr.hvs.hvw != null)) {}
      for (paramString = (aua)paramString.rr.hvs.hvw; (paramString == null) || (paramString.EMF == null); paramString = null)
      {
        if (this.pze != null)
        {
          paramString = (a)this.pze.get();
          if (paramString != null) {
            paramString.kC(false);
          }
        }
        if ((this.fts != null) && (this.fts.isShowing())) {
          this.fts.dismiss();
        }
        AppMethodBeat.o(23372);
        return;
      }
      az.agU().az(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(23365);
          i.sz(bs.eWj());
          Object localObject2 = ad.cgP();
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
              localObject3 = paramString.EMF.iterator();
              do
              {
                if (!((Iterator)localObject3).hasNext()) {
                  break;
                }
                localObject4 = ((bvl)((Iterator)localObject3).next()).DYb;
              } while ((!((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_deviceType.equals(((bjb)localObject4).DUp)) || (!((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_deviceID.equals(((bjb)localObject4).ncU)));
            }
            for (int i = 1;; i = 0)
            {
              if (i != 0) {
                break label957;
              }
              ac.d("MicroMsg.exdevice.GetBoundDeviceLogic", "delete deviceId %s, deviceType %s ", new Object[] { ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_deviceID, ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_deviceType });
              i.d((com.tencent.mm.plugin.exdevice.i.b)localObject2);
              ad.cgP().fw(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_deviceID, ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_deviceType);
              ad.cha();
              e.aK(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_deviceID, false);
              break;
              localObject1 = paramString.EMF.iterator();
              while (((Iterator)localObject1).hasNext())
              {
                Object localObject5 = (bvl)((Iterator)localObject1).next();
                localObject2 = ((bvl)localObject5).DYc;
                localObject3 = ((bvl)localObject5).DYb;
                if ((localObject3 != null) && (localObject2 != null) && (!bs.isNullOrNil(((bjb)localObject3).ncU)))
                {
                  ac.i("MicroMsg.exdevice.GetBoundDeviceLogic", "ModHardDevice deviceId = %s, deviceType = %s, BindFlag = %s", new Object[] { ((bjb)localObject3).ncU, ((bjb)localObject3).DUp, Integer.valueOf(((bvl)localObject5).Fll) });
                  localObject4 = ad.cgP().Zd(((bjb)localObject3).ncU);
                  if (2 == ((bvl)localObject5).Fll)
                  {
                    ac.w("MicroMsg.exdevice.GetBoundDeviceLogic", "This Device is unbind, Just leave. deviceId = %s, mac = %s, brandName = %s", new Object[] { ((bjb)localObject3).ncU, ((bjc)localObject2).DXq, ((bjc)localObject2).EXZ });
                    if (localObject4 != null)
                    {
                      i.d((com.tencent.mm.plugin.exdevice.i.b)localObject4);
                      ad.cgP().fw(((com.tencent.mm.plugin.exdevice.i.b)localObject4).field_deviceID, ((com.tencent.mm.plugin.exdevice.i.b)localObject4).field_deviceType);
                      ad.cha();
                      e.aK(((com.tencent.mm.plugin.exdevice.i.b)localObject4).field_deviceID, false);
                    }
                  }
                  else
                  {
                    localObject5 = new com.tencent.mm.plugin.exdevice.i.b();
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_deviceID = ((bjb)localObject3).ncU;
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_deviceType = ((bjb)localObject3).DUp;
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_connProto = ((bjc)localObject2).EYa;
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_connStrategy = ((bjc)localObject2).EYb;
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_closeStrategy = ((bjc)localObject2).EYc;
                    if ((((bjc)localObject2).eNj == 2) && (localObject4 != null) && (((cy)localObject4).eNf != null)) {
                      ((bjc)localObject2).iJY = ((cy)localObject4).eNf;
                    }
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).qg(((bjc)localObject2).iJY);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).qZ(((bjc)localObject2).EYi);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).qY(((bjc)localObject2).EYh);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).qX(((bjc)localObject2).EYg);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).kb(((bjc)localObject2).EYj);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).qV(((bjc)localObject2).IconUrl);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).qW(((bjc)localObject2).thh);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).kc(((bjc)localObject2).eNj);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).oy(((bjc)localObject2).eNk);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).ra(((bjc)localObject2).eNl);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).rb(((bjc)localObject2).eNm);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).rc(((bjc)localObject2).eNn);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).rd(((bjc)localObject2).eNo);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_url = "";
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_mac = com.tencent.mm.plugin.exdevice.k.b.Zs(com.tencent.mm.plugin.exdevice.k.b.Zt(((bjc)localObject2).DXq));
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_md5Str = com.tencent.mm.b.g.getMessageDigest(new String(((bjb)localObject3).DUp + ((bjb)localObject3).ncU).getBytes());
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_authKey = ((bjc)localObject2).DTH;
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_brandName = ((bjc)localObject2).EXZ;
                    if (((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_mac == 0L) {
                      ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_mac = System.currentTimeMillis();
                    }
                    boolean bool1;
                    if (localObject4 == null)
                    {
                      boolean bool2 = ad.cgP().insert((com.tencent.mm.sdk.e.c)localObject5);
                      bool1 = bool2;
                      if (bool2)
                      {
                        ad.cha();
                        e.aK(((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_deviceID, true);
                        bool1 = bool2;
                      }
                    }
                    for (;;)
                    {
                      ac.i("MicroMsg.exdevice.GetBoundDeviceLogic", "insert HardDeviceInfo %s, brandName = %s, deviceID = %s, deviceType = %s, connProto = %s, connStrategy = %s, closeStrategy = %s, mac = %s", new Object[] { Boolean.valueOf(bool1), ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_brandName, ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_deviceID, ((bjb)localObject3).DUp, ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_connProto, Integer.valueOf(((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_connStrategy), Integer.valueOf(((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_closeStrategy), Long.valueOf(((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_mac) });
                      break;
                      if (ad.cgP().e((com.tencent.mm.plugin.exdevice.i.b)localObject5) == 0) {
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
      if (this.pze != null)
      {
        paramString = (a)this.pze.get();
        if (paramString != null) {
          paramString.kC(true);
        }
      }
    }
    if ((this.fts != null) && (this.fts.isShowing()))
    {
      this.fts.dismiss();
      this.fts = null;
    }
    AppMethodBeat.o(23372);
  }
  
  public static abstract interface a
  {
    public abstract void kC(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.i
 * JD-Core Version:    0.7.0.1
 */