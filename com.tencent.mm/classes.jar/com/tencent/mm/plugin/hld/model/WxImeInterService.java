package com.tencent.mm.plugin.hld.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.hld.a.b;
import com.tencent.mm.plugin.hld.a.d;
import com.tencent.mm.plugin.hld.candidate.ImeCandidateView;
import com.tencent.mm.plugin.hld.f.c;
import com.tencent.mm.plugin.hld.f.i;
import com.tencent.mm.plugin.hld.f.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.service.MMService;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/model/WxImeInterService;", "Lcom/tencent/mm/service/MMService;", "()V", "onCreate", "", "onStartCommand", "", "intent", "Landroid/content/Intent;", "flags", "startId", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class WxImeInterService
  extends MMService
{
  public static final WxImeInterService.a Jwy;
  
  static
  {
    AppMethodBeat.i(312035);
    Jwy = new WxImeInterService.a((byte)0);
    AppMethodBeat.o(312035);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(312048);
    super.onCreate();
    k localk = k.JvH;
    k.rN(this.mDN);
    AppMethodBeat.o(312048);
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(312072);
    Log.i("WxIme.WxImeInterService", "onStartCommand.");
    if (paramIntent != null)
    {
      Object localObject;
      if (paramIntent.getBooleanExtra("ime_switch_ime_to_default", false))
      {
        Log.i("WxIme.WxImeInterService", "IME_SWITCH_IME_TO_DEFAULT");
        localObject = (d)h.ax(d.class);
        if (localObject != null)
        {
          localObject = ((d)localObject).fKG();
          if (localObject != null) {
            ((b)localObject).fKw();
          }
        }
      }
      if (paramIntent.getBooleanExtra("ime_close_wxime", false))
      {
        Log.i("WxIme.WxImeInterService", "IME_CLOSE_WXIME");
        localObject = l.JyV;
        localObject = MMApplicationContext.getContext();
        s.s(localObject, "getContext()");
        s.u(localObject, "context");
        l.iy((Context)localObject);
        Log.w("WxIme.WxImeUtil", s.X("closeIme ", Boolean.valueOf(l.ic((Context)localObject))));
        l.fOQ();
      }
      if (paramIntent.getBooleanExtra("ime_first_fetch_cloud_resource_check", false))
      {
        Log.i("WxIme.WxImeInterService", "IME_FIRST_FETCH_CLOUD_RESOURCE_CHECK");
        localObject = l.JyV;
        l.fOR();
      }
      if (paramIntent.getBooleanExtra("ime_logout", false))
      {
        Log.i("WxIme.WxImeInterService", "IME_LOGOUT");
        localObject = n.JvW;
        n.fMK();
        localObject = c.Jyj;
        localObject = g.JuL;
        localObject = g.fMn();
        if (localObject != null) {
          ImeCandidateView.a((ImeCandidateView)localObject);
        }
      }
      if (paramIntent.getBooleanExtra("ime_login", false))
      {
        Log.i("WxIme.WxImeInterService", "IME_LOGIN");
        localObject = n.JvW;
        n.fMK();
        localObject = c.Jyj;
        localObject = g.JuL;
        localObject = g.fMn();
        if (localObject != null) {
          ImeCandidateView.a((ImeCandidateView)localObject);
        }
      }
      if (paramIntent.getBooleanExtra("ime_load_user_dict", false))
      {
        localObject = n.JvW;
        Log.i("WxIme.WxImeInterService", s.X("IME_LOAD_USER_DICT ", Boolean.valueOf(n.fMF())));
        localObject = n.JvW;
        if (n.fMF()) {
          localObject = c.Jyj;
        }
      }
      if (paramIntent.getBooleanExtra("ime_load_contact", false))
      {
        localObject = n.JvW;
        Log.i("WxIme.WxImeInterService", s.X("IME_LOAD_CONTACT ", Boolean.valueOf(n.fMF())));
        localObject = n.JvW;
        if (n.fMF())
        {
          localObject = l.JyV;
          if (l.bGa()) {
            localObject = c.Jyj;
          }
        }
      }
      if (paramIntent.getBooleanExtra("ime_mode_switch", false))
      {
        Log.i("WxIme.WxImeInterService", "IME_MODE_SWITCH");
        localObject = n.JvW;
        n.fML();
      }
      if (paramIntent.getBooleanExtra("ime_finalize", false))
      {
        Log.i("WxIme.WxImeInterService", "IME_FINALIZE");
        localObject = n.JvW;
        n.finalize1();
      }
      if (paramIntent.getBooleanExtra("ime_reset_ime_setting", false))
      {
        Log.i("WxIme.WxImeInterService", "IME_RESET_IME_SETTING");
        localObject = i.JyA;
        i.fOt();
      }
    }
    paramInt1 = super.onStartCommand(paramIntent, paramInt1, paramInt2);
    AppMethodBeat.o(312072);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.model.WxImeInterService
 * JD-Core Version:    0.7.0.1
 */