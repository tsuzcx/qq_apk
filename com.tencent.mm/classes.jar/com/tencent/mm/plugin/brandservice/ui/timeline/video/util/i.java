package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import a.f.b.j;
import a.l;
import a.v;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.s;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.b.d;
import com.tencent.mm.ui.widget.b.d.a;
import java.lang.ref.WeakReference;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MpMenuHelper;", "", "()V", "MENU_ID_CANCEL_HAO_KAN", "", "MENU_ID_COPY_LINK", "MENU_ID_EXPOSE", "MENU_ID_FAV", "MENU_ID_HAO_KAN", "MENU_ID_SEND_TO_FRIEND", "MENU_ID_SHARE_TO_TIMELINE", "MENU_ID_SHOW_BIZ", "TAG", "", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "isBottomSheetShowing", "", "mmBottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "msgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "onlyShowShareMenu", "ui", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI;", "getUi$plugin_brandservice_release", "()Ljava/lang/ref/WeakReference;", "setUi$plugin_brandservice_release", "(Ljava/lang/ref/WeakReference;)V", "context", "copyLink", "", "doExpose", "fav", "goProfile", "hasShowMenuPermission", "id", "bitSet", "init", "isFinished", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "shareToTimeline", "shouldDisableMenuItem", "showMenu", "updateMenu", "plugin-brandservice_release"})
public final class i
{
  final String TAG = "MicroMsg.MpMenuHelper";
  public WeakReference<TmplShareWebViewToolUI> hkv;
  private d iOd;
  s jXm;
  b jXn;
  final int kiA = 1;
  final int kiB = 2;
  final int kiC = 3;
  final int kiD = 4;
  final int kiE = 5;
  final int kiF = 6;
  final int kiG = 7;
  public boolean kiH;
  public boolean kiI;
  final int kiz;
  
  public final void a(TmplShareWebViewToolUI paramTmplShareWebViewToolUI, s params, b paramb)
  {
    AppMethodBeat.i(152978);
    j.q(paramTmplShareWebViewToolUI, "ui");
    j.q(params, "msgInfo");
    j.q(paramb, "controller");
    this.hkv = new WeakReference(paramTmplShareWebViewToolUI);
    this.jXm = params;
    this.jXn = paramb;
    AppMethodBeat.o(152978);
  }
  
  public final TmplShareWebViewToolUI aZT()
  {
    AppMethodBeat.i(152981);
    Object localObject = this.hkv;
    if (localObject == null) {
      j.ays("ui");
    }
    if (((WeakReference)localObject).get() == null)
    {
      AppMethodBeat.o(152981);
      return null;
    }
    localObject = this.hkv;
    if (localObject == null) {
      j.ays("ui");
    }
    localObject = ((WeakReference)localObject).get();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI");
      AppMethodBeat.o(152981);
      throw ((Throwable)localObject);
    }
    localObject = (TmplShareWebViewToolUI)localObject;
    AppMethodBeat.o(152981);
    return localObject;
  }
  
  public final void fS(boolean paramBoolean)
  {
    AppMethodBeat.i(152979);
    this.kiH = paramBoolean;
    if (isFinished())
    {
      ab.i(this.TAG, "showMenu return:isFinished=%b", new Object[] { Boolean.valueOf(isFinished()) });
      AppMethodBeat.o(152979);
      return;
    }
    Object localObject;
    if (!this.kiI)
    {
      if (!paramBoolean) {
        break label282;
      }
      localObject = this.jXn;
      if (localObject == null) {
        j.ays("controller");
      }
      if ((((b)localObject).fgk & 0x8) != 0)
      {
        localObject = this.jXn;
        if (localObject == null) {
          j.ays("controller");
        }
        if ((((b)localObject).fgk & 0x10) != 0)
        {
          Context localContext = (Context)aZT();
          localObject = aZT();
          if (localObject != null) {}
          for (localObject = ((TmplShareWebViewToolUI)localObject).getString(2131306012);; localObject = null)
          {
            h.bL(localContext, (String)localObject);
            AppMethodBeat.o(152979);
            return;
          }
        }
      }
    }
    label282:
    for (this.iOd = new d((Context)aZT(), 1, false);; this.iOd = new d((Context)aZT(), 0, true))
    {
      localObject = this.iOd;
      if (localObject != null) {
        ((d)localObject).a((d.a)new i.c(this));
      }
      localObject = this.iOd;
      if (localObject != null) {
        ((d)localObject).a((n.c)new i.d(this, paramBoolean));
      }
      localObject = this.iOd;
      if (localObject != null) {
        ((d)localObject).a((n.d)new i.e(this));
      }
      localObject = this.iOd;
      if (localObject != null) {
        ((d)localObject).r((CharSequence)" ", 1);
      }
      localObject = this.iOd;
      if (localObject != null) {
        ((d)localObject).crd();
      }
      this.kiI = true;
      AppMethodBeat.o(152979);
      return;
    }
  }
  
  final boolean isFinished()
  {
    AppMethodBeat.i(15341);
    Object localObject = this.hkv;
    if (localObject == null) {
      j.ays("ui");
    }
    if (((WeakReference)localObject).get() != null)
    {
      localObject = this.hkv;
      if (localObject == null) {
        j.ays("ui");
      }
      localObject = ((WeakReference)localObject).get();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI");
        AppMethodBeat.o(15341);
        throw ((Throwable)localObject);
      }
      if (!((TmplShareWebViewToolUI)localObject).isFinishing()) {}
    }
    else
    {
      AppMethodBeat.o(15341);
      return true;
    }
    AppMethodBeat.o(15341);
    return false;
  }
  
  public final boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject1 = null;
    String str = null;
    AppMethodBeat.i(152980);
    Object localObject2;
    if (paramInt1 == 1)
    {
      if (paramInt2 == -1)
      {
        localObject1 = (Context)aZT();
        localObject2 = aZT();
        paramIntent = str;
        if (localObject2 != null) {
          paramIntent = ((TmplShareWebViewToolUI)localObject2).getString(2131297740);
        }
        h.bL((Context)localObject1, paramIntent);
        if (!this.kiH) {
          break label98;
        }
      }
      label98:
      for (paramInt1 = 11;; paramInt1 = 2)
      {
        paramIntent = this.jXn;
        if (paramIntent == null) {
          j.ays("controller");
        }
        paramIntent.kfr.sK(paramInt1);
        AppMethodBeat.o(152980);
        return true;
      }
    }
    if (paramInt1 == 2)
    {
      if (paramInt2 == -1) {
        if (paramIntent == null) {
          break label206;
        }
      }
      label206:
      for (str = paramIntent.getStringExtra("Select_Conv_User");; str = null)
      {
        if (paramIntent != null) {
          localObject1 = paramIntent.getStringExtra("custom_send_text");
        }
        if (str != null)
        {
          paramIntent = c.khX;
          paramIntent = this.jXm;
          if (paramIntent == null) {
            j.ays("msgInfo");
          }
          localObject2 = this.jXn;
          if (localObject2 == null) {
            j.ays("controller");
          }
          c.a(str, paramIntent, (String)localObject1, (b)localObject2, (com.tencent.mm.ipcinvoker.c)new i.a(this));
        }
        AppMethodBeat.o(152980);
        return true;
      }
    }
    AppMethodBeat.o(152980);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i
 * JD-Core Version:    0.7.0.1
 */