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
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.b.ee;
import com.tencent.mm.model.bh;
import com.tencent.mm.protocal.protobuf.cfy;
import com.tencent.mm.protocal.protobuf.cus;
import com.tencent.mm.protocal.protobuf.cyx;
import com.tencent.mm.protocal.protobuf.cyy;
import com.tencent.mm.protocal.protobuf.dps;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.conversation.BaseConversationUI;
import com.tencent.threadpool.i;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public enum k
  implements com.tencent.mm.am.h
{
  ProgressDialog lzP;
  public WeakReference<a> mql;
  private boolean yrM;
  boolean yrN;
  
  static
  {
    AppMethodBeat.i(23374);
    yrL = new k("INSTANCE");
    yrO = new k[] { yrL };
    AppMethodBeat.o(23374);
  }
  
  private k()
  {
    AppMethodBeat.i(23368);
    this.yrM = false;
    this.yrN = false;
    Object localObject = MMApplicationContext.getContext().getSharedPreferences("exdevice_pref", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    bh.bCz();
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
  
  public static void lv(long paramLong)
  {
    AppMethodBeat.i(23371);
    Log.i("MicroMsg.exdevice.GetBoundDeviceLogic", "update get bound hard device time : %d", new Object[] { Long.valueOf(paramLong) });
    SharedPreferences.Editor localEditor = MMApplicationContext.getContext().getSharedPreferences("exdevice_pref", 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    bh.bCz();
    localEditor.putLong(com.tencent.mm.model.c.getUin(), paramLong).commit();
    AppMethodBeat.o(23371);
  }
  
  public final void a(Context paramContext, final a parama)
  {
    AppMethodBeat.i(23369);
    Log.i("MicroMsg.exdevice.GetBoundDeviceLogic", "startGetBoundHardDevices");
    if (this.yrM)
    {
      if (this.mql == null) {
        this.mql = new WeakReference(parama);
      }
      Log.i("MicroMsg.exdevice.GetBoundDeviceLogic", "getting bound device now, just leave");
      AppMethodBeat.o(23369);
      return;
    }
    final q localq = new q();
    if ((paramContext != null) && ((paramContext instanceof Activity)) && (!((Activity)paramContext).isFinishing()))
    {
      if ((this.lzP != null) && (this.lzP.isShowing()))
      {
        this.lzP.dismiss();
        this.lzP = null;
      }
      if ((!(paramContext instanceof LauncherUI)) && (!(paramContext instanceof ChattingUI)) && (!(paramContext instanceof BaseConversationUI)))
      {
        paramContext.getString(R.l.app_tip);
        this.lzP = com.tencent.mm.ui.base.k.b(paramContext, paramContext.getString(R.l.gUc), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(23364);
            bh.aZW().a(localq);
            if (k.a(k.this) != null) {
              k.a(k.this).dismiss();
            }
            k.b(k.this);
            if (parama != null) {
              parama.oz(false);
            }
            k.c(k.this);
            AppMethodBeat.o(23364);
          }
        });
      }
    }
    this.mql = new WeakReference(parama);
    bh.aZW().a(localq, 0);
    this.yrM = true;
    AppMethodBeat.o(23369);
  }
  
  public final void dFE()
  {
    AppMethodBeat.i(274644);
    if (this.yrN)
    {
      Log.i("MicroMsg.exdevice.GetBoundDeviceLogic", "getting iot device now, just leave");
      AppMethodBeat.o(274644);
      return;
    }
    Log.i("MicroMsg.exdevice.GetBoundDeviceLogic", "startGetUserBindIotDevices");
    bh.aZW().cancel(6693);
    t localt = new t();
    bh.aZW().a(localt, 0);
    this.yrN = true;
    AppMethodBeat.o(274644);
  }
  
  public final boolean oA(boolean paramBoolean)
  {
    AppMethodBeat.i(23370);
    if (this.yrM)
    {
      Log.i("MicroMsg.exdevice.GetBoundDeviceLogic", "Getting bound device now, just leave");
      AppMethodBeat.o(23370);
      return false;
    }
    long l1 = System.currentTimeMillis();
    SharedPreferences localSharedPreferences = MMApplicationContext.getContext().getSharedPreferences("exdevice_pref", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    bh.bCz();
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
  
  public final boolean oB(boolean paramBoolean)
  {
    AppMethodBeat.i(274659);
    if (this.yrN)
    {
      Log.i("MicroMsg.exdevice.GetBoundDeviceLogic", "Getting bound iotDevice now, just leave");
      AppMethodBeat.o(274659);
      return false;
    }
    if (paramBoolean)
    {
      AppMethodBeat.o(274659);
      return true;
    }
    long l = System.currentTimeMillis();
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("exdevice_kv");
    StringBuilder localStringBuilder = new StringBuilder();
    bh.bCz();
    if (l - localMultiProcessMMKV.getLong(com.tencent.mm.model.c.getUin() + "_iot", 0L) < 86400000L)
    {
      Log.i("MicroMsg.exdevice.GetBoundDeviceLogic", "GetBoundHardIotDevices not now");
      AppMethodBeat.o(274659);
      return false;
    }
    AppMethodBeat.o(274659);
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, p paramp)
  {
    AppMethodBeat.i(23372);
    Log.i("MicroMsg.exdevice.GetBoundDeviceLogic", "onSceneEnd errType = " + paramInt1 + ", errCode = " + paramInt2 + ",errMsg = " + paramString);
    if (paramp == null)
    {
      Log.e("MicroMsg.exdevice.GetBoundDeviceLogic", "scene == null, do scene failed : %d, %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      if ((this.lzP != null) && (this.lzP.isShowing()))
      {
        this.lzP.dismiss();
        this.lzP = null;
      }
      AppMethodBeat.o(23372);
      return;
    }
    Log.i("MicroMsg.exdevice.GetBoundDeviceLogic", "scene.getType() = %s", new Object[] { Integer.valueOf(paramp.getType()) });
    if (paramp.getType() == 539)
    {
      this.yrM = false;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.e("MicroMsg.exdevice.GetBoundDeviceLogic", "scene.getType() = %s, %s, %s", new Object[] { Integer.valueOf(paramp.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        if (this.mql != null)
        {
          paramString = (a)this.mql.get();
          if (paramString != null) {
            paramString.oz(false);
          }
        }
        if ((this.lzP != null) && (this.lzP.isShowing()))
        {
          this.lzP.dismiss();
          this.lzP = null;
        }
        AppMethodBeat.o(23372);
        return;
      }
      paramString = (q)paramp;
      if ((paramString.rr != null) && (c.c.b(paramString.rr.otC) != null)) {}
      for (paramString = (cfy)c.c.b(paramString.rr.otC); (paramString == null) || (paramString.aapk == null); paramString = null)
      {
        if (this.mql != null)
        {
          paramString = (a)this.mql.get();
          if (paramString != null) {
            paramString.oz(false);
          }
        }
        if ((this.lzP != null) && (this.lzP.isShowing())) {
          this.lzP.dismiss();
        }
        AppMethodBeat.o(23372);
        return;
      }
      Log.i("MicroMsg.exdevice.GetBoundDeviceLogic", "hard device_cnt:%d", new Object[] { Integer.valueOf(paramString.aapk.size()) });
      bh.baH().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(274641);
          k.lv(Util.nowMilliSecond());
          Object localObject2 = ah.dFO();
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
          label955:
          for (;;)
          {
            Object localObject4;
            if (((Iterator)localObject1).hasNext())
            {
              localObject2 = (com.tencent.mm.plugin.exdevice.i.b)((Iterator)localObject1).next();
              localObject3 = paramString.aapk.iterator();
              do
              {
                if (!((Iterator)localObject3).hasNext()) {
                  break;
                }
                localObject4 = ((dps)((Iterator)localObject3).next()).YNR;
              } while ((!((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_deviceType.equals(((cyx)localObject4).YJY)) || (!((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_deviceID.equals(((cyx)localObject4).vgV)));
            }
            for (int i = 1;; i = 0)
            {
              if (i != 0) {
                break label955;
              }
              Log.d("MicroMsg.exdevice.GetBoundDeviceLogic", "delete deviceId %s, deviceType %s ", new Object[] { ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_deviceID, ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_deviceType });
              k.d((com.tencent.mm.plugin.exdevice.i.b)localObject2);
              ah.dFO().gW(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_deviceID, ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_deviceType);
              ah.dGc();
              g.bf(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_deviceID, false);
              break;
              localObject1 = paramString.aapk.iterator();
              while (((Iterator)localObject1).hasNext())
              {
                Object localObject5 = (dps)((Iterator)localObject1).next();
                localObject2 = ((dps)localObject5).YNS;
                localObject3 = ((dps)localObject5).YNR;
                if ((localObject3 != null) && (localObject2 != null) && (!Util.isNullOrNil(((cyx)localObject3).vgV)))
                {
                  Log.i("MicroMsg.exdevice.GetBoundDeviceLogic", "ModHardDevice deviceId = %s, deviceType = %s, BindFlag = %s", new Object[] { ((cyx)localObject3).vgV, ((cyx)localObject3).YJY, Integer.valueOf(((dps)localObject5).aaWu) });
                  localObject4 = ah.dFO().apI(((cyx)localObject3).vgV);
                  if (2 == ((dps)localObject5).aaWu)
                  {
                    Log.w("MicroMsg.exdevice.GetBoundDeviceLogic", "This Device is unbind, Just leave. deviceId = %s, mac = %s, brandName = %s", new Object[] { ((cyx)localObject3).vgV, ((cyy)localObject2).YNe, ((cyy)localObject2).aaDM });
                    if (localObject4 != null)
                    {
                      k.d((com.tencent.mm.plugin.exdevice.i.b)localObject4);
                      ah.dFO().gW(((com.tencent.mm.plugin.exdevice.i.b)localObject4).field_deviceID, ((com.tencent.mm.plugin.exdevice.i.b)localObject4).field_deviceType);
                      ah.dGc();
                      g.bf(((com.tencent.mm.plugin.exdevice.i.b)localObject4).field_deviceID, false);
                    }
                  }
                  else
                  {
                    localObject5 = new com.tencent.mm.plugin.exdevice.i.b();
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_deviceID = ((cyx)localObject3).vgV;
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_deviceType = ((cyx)localObject3).YJY;
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_connProto = ((cyy)localObject2).aaDN;
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_connStrategy = ((cyy)localObject2).aaDO;
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_closeStrategy = ((cyy)localObject2).aaDP;
                    if ((((cyy)localObject2).kDh == 2) && (localObject4 != null) && (((ee)localObject4).kDc != null)) {
                      ((cyy)localObject2).pSk = ((ee)localObject4).kDc;
                    }
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).AV(((cyy)localObject2).pSk);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).BM(((cyy)localObject2).aaDV);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).BL(((cyy)localObject2).aaDU);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).BK(((cyy)localObject2).aaDT);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).pT(((cyy)localObject2).aaDW);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).setIconUrl(((cyy)localObject2).IHo);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).BJ(((cyy)localObject2).IGI);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).pU(((cyy)localObject2).kDh);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).gV(((cyy)localObject2).kDi);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).BN(((cyy)localObject2).kDj);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).BO(((cyy)localObject2).kDk);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).BP(((cyy)localObject2).kDl);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).BQ(((cyy)localObject2).kDm);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_url = "";
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_mac = com.tencent.mm.plugin.exdevice.k.b.apW(com.tencent.mm.plugin.exdevice.k.b.apY(((cyy)localObject2).YNe));
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_md5Str = com.tencent.mm.b.g.getMessageDigest(new String(((cyx)localObject3).YJY + ((cyx)localObject3).vgV).getBytes());
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_authKey = ((cyy)localObject2).YJq;
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_brandName = ((cyy)localObject2).aaDM;
                    if (((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_mac == 0L) {
                      ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_mac = System.currentTimeMillis();
                    }
                    boolean bool1;
                    if (localObject4 == null)
                    {
                      boolean bool2 = ah.dFO().insert((IAutoDBItem)localObject5);
                      bool1 = bool2;
                      if (bool2)
                      {
                        ah.dGc();
                        g.bf(((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_deviceID, true);
                        bool1 = bool2;
                      }
                    }
                    for (;;)
                    {
                      Log.i("MicroMsg.exdevice.GetBoundDeviceLogic", "insert HardDeviceInfo %s, brandName = %s, deviceID = %s, deviceType = %s, connProto = %s, connStrategy = %s, closeStrategy = %s, mac = %s", new Object[] { Boolean.valueOf(bool1), ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_brandName, ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_deviceID, ((cyx)localObject3).YJY, ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_connProto, Integer.valueOf(((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_connStrategy), Integer.valueOf(((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_closeStrategy), Long.valueOf(((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_mac) });
                      break;
                      if (ah.dFO().e((com.tencent.mm.plugin.exdevice.i.b)localObject5) == 0) {
                        bool1 = false;
                      } else {
                        bool1 = true;
                      }
                    }
                  }
                }
              }
              AppMethodBeat.o(274641);
              return;
            }
          }
        }
      });
      if (this.mql != null)
      {
        paramString = (a)this.mql.get();
        if (paramString != null) {
          paramString.oz(true);
        }
      }
      if ((this.lzP != null) && (this.lzP.isShowing()))
      {
        this.lzP.dismiss();
        this.lzP = null;
      }
      AppMethodBeat.o(23372);
      return;
    }
    if (paramp.getType() == 6693)
    {
      this.yrN = false;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.e("MicroMsg.exdevice.GetBoundDeviceLogic", "scene.getType() = %s, %s, %s", new Object[] { Integer.valueOf(paramp.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        AppMethodBeat.o(23372);
        return;
      }
      long l = Util.nowMilliSecond();
      Log.i("MicroMsg.exdevice.GetBoundDeviceLogic", "update get bound hard device time : %d", new Object[] { Long.valueOf(l) });
      paramString = MultiProcessMMKV.getMMKV("exdevice_kv");
      StringBuilder localStringBuilder = new StringBuilder();
      bh.bCz();
      paramString.putLong(com.tencent.mm.model.c.getUin() + "_iot", l);
      paramString = (t)paramp;
      if ((paramString.rr != null) && (c.c.b(paramString.rr.otC) != null)) {}
      for (paramString = (cus)c.c.b(paramString.rr.otC); paramString == null; paramString = null)
      {
        Log.e("MicroMsg.exdevice.GetBoundDeviceLogic", "nsResp == null, bind iot device");
        AppMethodBeat.o(23372);
        return;
      }
      Log.i("MicroMsg.exdevice.GetBoundDeviceLogic", "device_cnt:%d", new Object[] { Integer.valueOf(paramString.aaAi) });
      Log.i("MicroMsg.exdevice.GetBoundDeviceLogic", "device_list_size:%d", new Object[] { Integer.valueOf(paramString.aaAj.size()) });
      com.tencent.threadpool.h.ahAA.g(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(23365);
          ah.Lf(paramString.aaAi);
          ah.ac(paramString.aaAj);
          AppMethodBeat.o(23365);
        }
      }, "updateIotDevice");
    }
    AppMethodBeat.o(23372);
  }
  
  public static abstract interface a
  {
    public abstract void oz(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.k
 * JD-Core Version:    0.7.0.1
 */