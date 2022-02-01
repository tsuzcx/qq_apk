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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.b.g;
import com.tencent.mm.g.c.di;
import com.tencent.mm.model.bc;
import com.tencent.mm.protocal.protobuf.ayo;
import com.tencent.mm.protocal.protobuf.bob;
import com.tencent.mm.protocal.protobuf.boc;
import com.tencent.mm.protocal.protobuf.cau;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
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
  ProgressDialog fOC;
  private boolean qjn;
  public WeakReference<a> qjo;
  
  static
  {
    AppMethodBeat.i(23374);
    qjm = new i("INSTANCE");
    qjp = new i[] { qjm };
    AppMethodBeat.o(23374);
  }
  
  private i()
  {
    AppMethodBeat.i(23368);
    this.qjn = false;
    Object localObject = ak.getContext().getSharedPreferences("exdevice_pref", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    bc.aCg();
    long l = ((SharedPreferences)localObject).getLong(com.tencent.mm.model.c.getUin(), 0L);
    if (l != 0L)
    {
      ae.i("MicroMsg.exdevice.GetBoundDeviceLogic", "this user has get bound device, last time is %d", new Object[] { Long.valueOf(l) });
      AppMethodBeat.o(23368);
      return;
    }
    ae.i("MicroMsg.exdevice.GetBoundDeviceLogic", "the user has not get bound device yet");
    AppMethodBeat.o(23368);
  }
  
  public static void uO(long paramLong)
  {
    AppMethodBeat.i(23371);
    ae.i("MicroMsg.exdevice.GetBoundDeviceLogic", "update get bound hard device time : %d", new Object[] { Long.valueOf(paramLong) });
    SharedPreferences.Editor localEditor = ak.getContext().getSharedPreferences("exdevice_pref", 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    bc.aCg();
    localEditor.putLong(com.tencent.mm.model.c.getUin(), paramLong).commit();
    AppMethodBeat.o(23371);
  }
  
  public final void a(Context paramContext, final a parama)
  {
    AppMethodBeat.i(23369);
    ae.i("MicroMsg.exdevice.GetBoundDeviceLogic", "startGetBoundHardDevices");
    if (this.qjn)
    {
      if (this.qjo == null) {
        this.qjo = new WeakReference(parama);
      }
      ae.i("MicroMsg.exdevice.GetBoundDeviceLogic", "getting bound device now, just leave");
      AppMethodBeat.o(23369);
      return;
    }
    final o localo = new o();
    if ((paramContext != null) && ((paramContext instanceof Activity)) && (!((Activity)paramContext).isFinishing()))
    {
      if ((this.fOC != null) && (this.fOC.isShowing()))
      {
        this.fOC.dismiss();
        this.fOC = null;
      }
      if ((!(paramContext instanceof LauncherUI)) && (!(paramContext instanceof ChattingUI)) && (!(paramContext instanceof BaseConversationUI)))
      {
        paramContext.getString(2131755906);
        this.fOC = h.c(paramContext, paramContext.getString(2131762836), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(23364);
            bc.ajj().a(localo);
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
    this.qjo = new WeakReference(parama);
    bc.ajj().a(localo, 0);
    AppMethodBeat.o(23369);
  }
  
  public final boolean kO(boolean paramBoolean)
  {
    AppMethodBeat.i(23370);
    if (this.qjn)
    {
      ae.i("MicroMsg.exdevice.GetBoundDeviceLogic", "Getting bound device now, just leave");
      AppMethodBeat.o(23370);
      return false;
    }
    long l1 = System.currentTimeMillis();
    SharedPreferences localSharedPreferences = ak.getContext().getSharedPreferences("exdevice_pref", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    bc.aCg();
    long l2 = localSharedPreferences.getLong(com.tencent.mm.model.c.getUin(), 0L);
    if ((!paramBoolean) && (l1 - l2 < 86400000L))
    {
      ae.i("MicroMsg.exdevice.GetBoundDeviceLogic", "GetBoundHardDevices not now pp");
      AppMethodBeat.o(23370);
      return false;
    }
    AppMethodBeat.o(23370);
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(23372);
    ae.i("MicroMsg.exdevice.GetBoundDeviceLogic", "onSceneEnd errType = " + paramInt1 + ", errCode = " + paramInt2 + ",errMsg = " + paramString);
    this.qjn = false;
    if ((paramn == null) || (paramInt2 != 0) || (paramInt1 != 0))
    {
      ae.e("MicroMsg.exdevice.GetBoundDeviceLogic", "do scene failed : %d, %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      if ((this.fOC != null) && (this.fOC.isShowing()))
      {
        this.fOC.dismiss();
        this.fOC = null;
      }
      AppMethodBeat.o(23372);
      return;
    }
    ae.i("MicroMsg.exdevice.GetBoundDeviceLogic", "scene.getType() = %s", new Object[] { Integer.valueOf(paramn.getType()) });
    if (paramn.getType() == 539)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ae.e("MicroMsg.exdevice.GetBoundDeviceLogic", "scene.getType() = %s, %s, %s", new Object[] { Integer.valueOf(paramn.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        if (this.qjo != null)
        {
          paramString = (a)this.qjo.get();
          if (paramString != null) {
            paramString.kN(false);
          }
        }
        if ((this.fOC != null) && (this.fOC.isShowing()))
        {
          this.fOC.dismiss();
          this.fOC = null;
        }
        AppMethodBeat.o(23372);
        return;
      }
      paramString = (o)paramn;
      if ((paramString.rr != null) && (paramString.rr.hQE.hQJ != null)) {}
      for (paramString = (ayo)paramString.rr.hQE.hQJ; (paramString == null) || (paramString.GPi == null); paramString = null)
      {
        if (this.qjo != null)
        {
          paramString = (a)this.qjo.get();
          if (paramString != null) {
            paramString.kN(false);
          }
        }
        if ((this.fOC != null) && (this.fOC.isShowing())) {
          this.fOC.dismiss();
        }
        AppMethodBeat.o(23372);
        return;
      }
      bc.ajU().aw(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(23365);
          i.uO(bu.fpO());
          Object localObject2 = ad.cmJ();
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
              localObject3 = paramString.GPi.iterator();
              do
              {
                if (!((Iterator)localObject3).hasNext()) {
                  break;
                }
                localObject4 = ((cau)((Iterator)localObject3).next()).FVS;
              } while ((!((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_deviceType.equals(((bob)localObject4).FSh)) || (!((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_deviceID.equals(((bob)localObject4).nIM)));
            }
            for (int i = 1;; i = 0)
            {
              if (i != 0) {
                break label957;
              }
              ae.d("MicroMsg.exdevice.GetBoundDeviceLogic", "delete deviceId %s, deviceType %s ", new Object[] { ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_deviceID, ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_deviceType });
              i.d((com.tencent.mm.plugin.exdevice.i.b)localObject2);
              ad.cmJ().fK(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_deviceID, ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_deviceType);
              ad.cmU();
              e.aO(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_deviceID, false);
              break;
              localObject1 = paramString.GPi.iterator();
              while (((Iterator)localObject1).hasNext())
              {
                Object localObject5 = (cau)((Iterator)localObject1).next();
                localObject2 = ((cau)localObject5).FVT;
                localObject3 = ((cau)localObject5).FVS;
                if ((localObject3 != null) && (localObject2 != null) && (!bu.isNullOrNil(((bob)localObject3).nIM)))
                {
                  ae.i("MicroMsg.exdevice.GetBoundDeviceLogic", "ModHardDevice deviceId = %s, deviceType = %s, BindFlag = %s", new Object[] { ((bob)localObject3).nIM, ((bob)localObject3).FSh, Integer.valueOf(((cau)localObject5).Hou) });
                  localObject4 = ad.cmJ().adA(((bob)localObject3).nIM);
                  if (2 == ((cau)localObject5).Hou)
                  {
                    ae.w("MicroMsg.exdevice.GetBoundDeviceLogic", "This Device is unbind, Just leave. deviceId = %s, mac = %s, brandName = %s", new Object[] { ((bob)localObject3).nIM, ((boc)localObject2).FVh, ((boc)localObject2).HaX });
                    if (localObject4 != null)
                    {
                      i.d((com.tencent.mm.plugin.exdevice.i.b)localObject4);
                      ad.cmJ().fK(((com.tencent.mm.plugin.exdevice.i.b)localObject4).field_deviceID, ((com.tencent.mm.plugin.exdevice.i.b)localObject4).field_deviceType);
                      ad.cmU();
                      e.aO(((com.tencent.mm.plugin.exdevice.i.b)localObject4).field_deviceID, false);
                    }
                  }
                  else
                  {
                    localObject5 = new com.tencent.mm.plugin.exdevice.i.b();
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_deviceID = ((bob)localObject3).nIM;
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_deviceType = ((bob)localObject3).FSh;
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_connProto = ((boc)localObject2).HaY;
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_connStrategy = ((boc)localObject2).HaZ;
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_closeStrategy = ((boc)localObject2).Hba;
                    if ((((boc)localObject2).fhC == 2) && (localObject4 != null) && (((di)localObject4).fhy != null)) {
                      ((boc)localObject2).jga = ((di)localObject4).fhy;
                    }
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).tl(((boc)localObject2).jga);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).ud(((boc)localObject2).Hbg);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).uc(((boc)localObject2).Hbf);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).ub(((boc)localObject2).Hbe);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).kB(((boc)localObject2).Hbh);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).setIconUrl(((boc)localObject2).IconUrl);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).ua(((boc)localObject2).uqf);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).kC(((boc)localObject2).fhC);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).qL(((boc)localObject2).fhD);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).ue(((boc)localObject2).fhE);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).uf(((boc)localObject2).fhF);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).ug(((boc)localObject2).fhG);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).uh(((boc)localObject2).fhH);
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_url = "";
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_mac = com.tencent.mm.plugin.exdevice.k.b.adP(com.tencent.mm.plugin.exdevice.k.b.adQ(((boc)localObject2).FVh));
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_md5Str = g.getMessageDigest(new String(((bob)localObject3).FSh + ((bob)localObject3).nIM).getBytes());
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_authKey = ((boc)localObject2).FRz;
                    ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_brandName = ((boc)localObject2).HaX;
                    if (((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_mac == 0L) {
                      ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_mac = System.currentTimeMillis();
                    }
                    boolean bool1;
                    if (localObject4 == null)
                    {
                      boolean bool2 = ad.cmJ().insert((com.tencent.mm.sdk.e.c)localObject5);
                      bool1 = bool2;
                      if (bool2)
                      {
                        ad.cmU();
                        e.aO(((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_deviceID, true);
                        bool1 = bool2;
                      }
                    }
                    for (;;)
                    {
                      ae.i("MicroMsg.exdevice.GetBoundDeviceLogic", "insert HardDeviceInfo %s, brandName = %s, deviceID = %s, deviceType = %s, connProto = %s, connStrategy = %s, closeStrategy = %s, mac = %s", new Object[] { Boolean.valueOf(bool1), ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_brandName, ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_deviceID, ((bob)localObject3).FSh, ((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_connProto, Integer.valueOf(((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_connStrategy), Integer.valueOf(((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_closeStrategy), Long.valueOf(((com.tencent.mm.plugin.exdevice.i.b)localObject5).field_mac) });
                      break;
                      if (ad.cmJ().e((com.tencent.mm.plugin.exdevice.i.b)localObject5) == 0) {
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
      if (this.qjo != null)
      {
        paramString = (a)this.qjo.get();
        if (paramString != null) {
          paramString.kN(true);
        }
      }
    }
    if ((this.fOC != null) && (this.fOC.isShowing()))
    {
      this.fOC.dismiss();
      this.fOC = null;
    }
    AppMethodBeat.o(23372);
  }
  
  public static abstract interface a
  {
    public abstract void kN(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.i
 * JD-Core Version:    0.7.0.1
 */