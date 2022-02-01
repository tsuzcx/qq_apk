package com.tencent.mm.plugin.hld.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.a.b;
import com.tencent.mm.plugin.hld.a.d;
import com.tencent.mm.plugin.hld.candidate.ImeCandidateView;
import com.tencent.mm.plugin.hld.f.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.service.MMService;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/model/WxImeInterService;", "Lcom/tencent/mm/service/MMService;", "()V", "onCreate", "", "onStartCommand", "", "intent", "Landroid/content/Intent;", "flags", "startId", "Companion", "plugin-hld_release"})
public final class WxImeInterService
  extends MMService
{
  public static final a DEP;
  
  static
  {
    AppMethodBeat.i(211125);
    DEP = new a((byte)0);
    AppMethodBeat.o(211125);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(211117);
    super.onCreate();
    k localk = k.DDb;
    long l = this.kdD;
    if (!k.eEz()) {
      com.tencent.e.h.ZvG.d((Runnable)new k.i(l), "WxIme.ImeReporter");
    }
    AppMethodBeat.o(211117);
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(211123);
    Log.i("WxIme.WxImeInterService", "onStartCommand.");
    Object localObject;
    if (paramIntent != null)
    {
      if (paramIntent.getBooleanExtra("ime_switch_ime_to_default", false))
      {
        Log.i("WxIme.WxImeInterService", "IME_SWITCH_IME_TO_DEFAULT");
        localObject = (d)com.tencent.mm.kernel.h.ae(d.class);
        if (localObject != null)
        {
          localObject = ((d)localObject).eCD();
          if (localObject != null) {
            ((b)localObject).eCt();
          }
        }
      }
      if (paramIntent.getBooleanExtra("ime_close_wxime", false))
      {
        Log.i("WxIme.WxImeInterService", "IME_CLOSE_WXIME");
        localObject = com.tencent.mm.plugin.hld.f.l.DHK;
        localObject = MMApplicationContext.getContext();
        p.j(localObject, "MMApplicationContext.getContext()");
        p.k(localObject, "context");
        com.tencent.mm.plugin.hld.f.l.hd((Context)localObject);
        Log.w("WxIme.WxImeUtil", "closeIme " + com.tencent.mm.plugin.hld.f.l.gJ((Context)localObject));
        com.tencent.mm.plugin.hld.f.l.eHh();
      }
      if (paramIntent.getBooleanExtra("ime_first_fetch_cloud_resource_check", false))
      {
        Log.i("WxIme.WxImeInterService", "IME_FIRST_FETCH_CLOUD_RESOURCE_CHECK");
        localObject = com.tencent.mm.plugin.hld.f.l.DHK;
        com.tencent.mm.plugin.hld.f.l.eHi();
      }
      if (paramIntent.getBooleanExtra("ime_logout", false))
      {
        Log.i("WxIme.WxImeInterService", "IME_LOGOUT");
        localObject = n.DEn;
        n.eEH();
        localObject = c.DGO;
        c.eFX();
        localObject = g.DCm;
        localObject = g.eEl();
        if (localObject != null) {
          ImeCandidateView.a((ImeCandidateView)localObject);
        }
      }
      if (paramIntent.getBooleanExtra("ime_login", false))
      {
        Log.i("WxIme.WxImeInterService", "IME_LOGIN");
        localObject = n.DEn;
        n.eEH();
        localObject = c.DGO;
        c.eFX();
        localObject = g.DCm;
        localObject = g.eEl();
        if (localObject != null) {
          ImeCandidateView.a((ImeCandidateView)localObject);
        }
      }
      n localn;
      if (paramIntent.getBooleanExtra("ime_load_user_dict", false))
      {
        localObject = new StringBuilder("IME_LOAD_USER_DICT ");
        localn = n.DEn;
        Log.i("WxIme.WxImeInterService", n.eEB());
        localObject = n.DEn;
        if (n.eEB()) {
          localObject = c.DGO;
        }
      }
      if (paramIntent.getBooleanExtra("ime_load_contact", false))
      {
        localObject = new StringBuilder("IME_LOAD_CONTACT ");
        localn = n.DEn;
        Log.i("WxIme.WxImeInterService", n.eEB());
        localObject = n.DEn;
        if (n.eEB())
        {
          localObject = com.tencent.mm.plugin.hld.f.l.DHK;
          if (com.tencent.mm.plugin.hld.f.l.biq())
          {
            localObject = c.DGO;
            c.eFX();
          }
        }
      }
      if (paramIntent.getBooleanExtra("ime_mode_switch", false))
      {
        Log.i("WxIme.WxImeInterService", "IME_MODE_SWITCH");
        localObject = n.DEn;
        Log.i("WxIme.WxEngineMgr", "setNeedReInitEngine reInit:true mInitializeWait:" + n.DEi + " mInitializeSuccess:" + n.Dva);
        n.DEl = true;
        if (!n.DEi) {
          break label566;
        }
        localObject = n.mContext;
        if (localObject == null) {
          break label555;
        }
        n.gR((Context)localObject);
      }
    }
    for (;;)
    {
      if (paramIntent.getBooleanExtra("ime_finalize", false))
      {
        Log.i("WxIme.WxImeInterService", "IME_FINALIZE");
        localObject = n.DEn;
        n.finalize1();
      }
      if (paramIntent.getBooleanExtra("ime_reset_ime_setting", false))
      {
        Log.i("WxIme.WxImeInterService", "IME_RESET_IME_SETTING");
        localObject = com.tencent.mm.plugin.hld.f.i.DHq;
        com.tencent.mm.plugin.hld.f.i.eGH();
      }
      paramInt1 = super.onStartCommand(paramIntent, paramInt1, paramInt2);
      AppMethodBeat.o(211123);
      return paramInt1;
      label555:
      Log.e("WxIme.WxEngineMgr", "setNeedReInitEngine mContext is null??");
      continue;
      label566:
      if (n.Dva)
      {
        localObject = (d)com.tencent.mm.kernel.h.ae(d.class);
        if (localObject != null)
        {
          localObject = ((d)localObject).eCD();
          if ((localObject != null) && (!((b)localObject).eCq())) {
            n.finalize1();
          }
        }
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/model/WxImeInterService$Companion;", "", "()V", "TAG", "", "plugin-hld_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.model.WxImeInterService
 * JD-Core Version:    0.7.0.1
 */