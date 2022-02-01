package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.ClipboardManager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.x;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI;
import com.tencent.mm.plugin.webview.model.ay;
import com.tencent.mm.plugin.webview.model.ay.d;
import com.tencent.mm.plugin.webview.ui.tools.i;
import com.tencent.mm.plugin.webview.ui.tools.n.a;
import com.tencent.mm.protocal.protobuf.byj;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.tools.o;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.a.e.b;
import d.g.b.ad;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.util.Arrays;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MpMenuHelper;", "", "()V", "MENU_ID_CANCEL_HAO_KAN", "", "MENU_ID_CANCEL_MINIMIZE", "MENU_ID_COPY_LINK", "MENU_ID_EXPOSE", "MENU_ID_FAV", "MENU_ID_HAO_KAN", "MENU_ID_MINIMIZE", "MENU_ID_SEND_TO_FRIEND", "MENU_ID_SHARE_TO_TIMELINE", "MENU_ID_SHOW_BIZ", "TAG", "", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "isBottomSheetShowing", "", "mmBottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "msgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "onlyShowShareMenu", "shareExtInfo", "getShareExtInfo", "()Ljava/lang/String;", "setShareExtInfo", "(Ljava/lang/String;)V", "ui", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI;", "getUi$plugin_brandservice_release", "()Ljava/lang/ref/WeakReference;", "setUi$plugin_brandservice_release", "(Ljava/lang/ref/WeakReference;)V", "context", "copyLink", "", "doExpose", "fav", "goProfile", "hasShowMenuPermission", "id", "bitSet", "init", "isFinished", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onDestroy", "shareToTimeline", "shouldDisableMenuItem", "showMenu", "updateMenu", "plugin-brandservice_release"})
public final class p
{
  final String TAG = "MicroMsg.MpMenuHelper";
  public WeakReference<TmplShareWebViewToolUI> lZK;
  com.tencent.mm.ui.widget.a.e mIQ;
  public x otY;
  public com.tencent.mm.plugin.brandservice.ui.timeline.video.b ovq;
  boolean oyA;
  public String oyB = "";
  final int oyp;
  final int oyq = 1;
  final int oyr = 2;
  final int oys = 3;
  final int oyt = 4;
  final int oyu = 5;
  final int oyv = 6;
  final int oyw = 7;
  final int oyx = 8;
  final int oyy = 9;
  public boolean oyz;
  
  public final void Zv()
  {
    AppMethodBeat.i(7352);
    if (this.oyA) {
      jq(this.oyz);
    }
    AppMethodBeat.o(7352);
  }
  
  public final TmplShareWebViewToolUI bSl()
  {
    AppMethodBeat.i(7355);
    Object localObject = this.lZK;
    if (localObject == null) {
      d.g.b.p.bdF("ui");
    }
    if (((WeakReference)localObject).get() == null)
    {
      AppMethodBeat.o(7355);
      return null;
    }
    localObject = this.lZK;
    if (localObject == null) {
      d.g.b.p.bdF("ui");
    }
    localObject = ((WeakReference)localObject).get();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI");
      AppMethodBeat.o(7355);
      throw ((Throwable)localObject);
    }
    localObject = (TmplShareWebViewToolUI)localObject;
    AppMethodBeat.o(7355);
    return localObject;
  }
  
  final boolean isFinished()
  {
    AppMethodBeat.i(7357);
    Object localObject = this.lZK;
    if (localObject == null) {
      d.g.b.p.bdF("ui");
    }
    if (((WeakReference)localObject).get() != null)
    {
      localObject = this.lZK;
      if (localObject == null) {
        d.g.b.p.bdF("ui");
      }
      localObject = ((WeakReference)localObject).get();
      if (localObject == null)
      {
        localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI");
        AppMethodBeat.o(7357);
        throw ((Throwable)localObject);
      }
      if (!((TmplShareWebViewToolUI)localObject).isFinishing()) {}
    }
    else
    {
      AppMethodBeat.o(7357);
      return true;
    }
    AppMethodBeat.o(7357);
    return false;
  }
  
  public final void jq(final boolean paramBoolean)
  {
    AppMethodBeat.i(7353);
    this.oyz = paramBoolean;
    if (!paramBoolean) {
      this.oyB = "";
    }
    if (isFinished())
    {
      ae.i(this.TAG, "showMenu return:isFinished=%b", new Object[] { Boolean.valueOf(isFinished()) });
      AppMethodBeat.o(7353);
      return;
    }
    Object localObject2;
    n.e locale;
    if (!this.oyA)
    {
      if (paramBoolean)
      {
        localObject1 = this.ovq;
        if (localObject1 == null) {
          d.g.b.p.bdF("controller");
        }
        if ((((com.tencent.mm.plugin.brandservice.ui.timeline.video.b)localObject1).hBZ & 0x8) != 0)
        {
          localObject1 = this.ovq;
          if (localObject1 == null) {
            d.g.b.p.bdF("controller");
          }
          if ((((com.tencent.mm.plugin.brandservice.ui.timeline.video.b)localObject1).hBZ & 0x10) != 0)
          {
            localObject2 = (Context)bSl();
            localObject1 = bSl();
            if (localObject1 != null) {}
            for (localObject1 = ((TmplShareWebViewToolUI)localObject1).getString(2131766260);; localObject1 = null)
            {
              com.tencent.mm.ui.base.h.cj((Context)localObject2, (String)localObject1);
              AppMethodBeat.o(7353);
              return;
            }
          }
        }
        this.mIQ = new com.tencent.mm.ui.widget.a.e((Context)bSl(), 1, false);
      }
    }
    else
    {
      localObject1 = this.mIQ;
      if (localObject1 != null) {
        ((com.tencent.mm.ui.widget.a.e)localObject1).b((e.b)new c(this));
      }
      localObject1 = this.mIQ;
      if (localObject1 != null) {
        ((com.tencent.mm.ui.widget.a.e)localObject1).a((n.d)new d(this, paramBoolean));
      }
      locale = (n.e)new g(this);
      localObject1 = this.mIQ;
      if (localObject1 != null) {
        ((com.tencent.mm.ui.widget.a.e)localObject1).a(locale);
      }
      localObject1 = this.mIQ;
      if (localObject1 != null) {
        ((com.tencent.mm.ui.widget.a.e)localObject1).b((n.d)new e(this, paramBoolean));
      }
      localObject1 = bSl();
      if (localObject1 == null) {
        break label570;
      }
      localObject2 = ((TmplShareWebViewToolUI)localObject1).eRj();
      label298:
      localObject1 = bSl();
      if ((localObject1 == null) || (((TmplShareWebViewToolUI)localObject1).Ewa == null)) {
        break label576;
      }
    }
    label570:
    label576:
    for (Object localObject1 = com.tencent.mm.plugin.webview.ui.tools.n.aKm((String)localObject2);; localObject1 = null)
    {
      boolean bool = ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).isMpUrl((String)localObject2);
      if ((!paramBoolean) && (bool) && (localObject1 != null) && (((n.a)localObject1).isDataValid()))
      {
        localObject2 = LayoutInflater.from((Context)bSl()).inflate(2131494913, null);
        ImageView localImageView = (ImageView)((View)localObject2).findViewById(2131301214);
        Object localObject3 = (TextView)((View)localObject2).findViewById(2131306141);
        View localView = ((View)localObject2).findViewById(2131298761);
        d.g.b.p.g(localObject3, "nickNameTextView");
        ((TextView)localObject3).setText((CharSequence)((n.a)localObject1).EwT);
        localObject3 = new c.a().aJr().aJs().pK(2131231875);
        com.tencent.mm.av.a.a.aJh().a(((n.a)localObject1).EwU, localImageView, ((c.a)localObject3).aJu());
        localView.setOnClickListener((View.OnClickListener)new f(this, (n.a)localObject1));
        o.gY(localView);
        localObject1 = this.mIQ;
        if (localObject1 != null) {
          ((com.tencent.mm.ui.widget.a.e)localObject1).P((View)localObject2, true);
        }
      }
      localObject1 = this.mIQ;
      if (localObject1 != null) {
        ((com.tencent.mm.ui.widget.a.e)localObject1).b(locale);
      }
      localObject1 = this.mIQ;
      if (localObject1 != null) {
        ((com.tencent.mm.ui.widget.a.e)localObject1).cPF();
      }
      this.oyA = true;
      AppMethodBeat.o(7353);
      return;
      this.mIQ = new com.tencent.mm.ui.widget.a.e((Context)bSl(), 0, true);
      break;
      localObject2 = null;
      break label298;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(7356);
    if (this.mIQ != null)
    {
      com.tencent.mm.ui.widget.a.e locale = this.mIQ;
      if (locale == null) {
        d.g.b.p.gkB();
      }
      if (locale.isShowing())
      {
        locale = this.mIQ;
        if (locale == null) {
          d.g.b.p.gkB();
        }
        locale.bqD();
      }
    }
    AppMethodBeat.o(7356);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "bundle", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "onCallback"})
  public static final class a<T>
    implements com.tencent.mm.ipcinvoker.d<Bundle>
  {
    public a(p paramp) {}
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "bundle", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class b<T>
    implements com.tencent.mm.ipcinvoker.d<Bundle>
  {
    b(p paramp, Intent paramIntent) {}
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "onDismiss"})
  static final class c
    implements e.b
  {
    c(p paramp) {}
    
    public final void onDismiss()
    {
      this.oyC.oyA = false;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class d
    implements n.d
  {
    d(p paramp, boolean paramBoolean) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      AppMethodBeat.i(7347);
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(480L, 0L, 1L, false);
      paraml.clear();
      if (this.oyC.bSl() == null)
      {
        AppMethodBeat.o(7347);
        return;
      }
      if (p.a(this.oyC, 8))
      {
        i = this.oyC.oyp;
        localObject1 = this.oyC.bSl();
        if (localObject1 != null)
        {
          localObject1 = ((TmplShareWebViewToolUI)localObject1).getString(2131762163);
          localObject1 = (CharSequence)localObject1;
          localObject3 = this.oyC.bSl();
          if (localObject3 == null) {
            d.g.b.p.gkB();
          }
          paraml.a(i, (CharSequence)localObject1, 2131690478, ((TmplShareWebViewToolUI)localObject3).getResources().getColor(2131099699), p.b(this.oyC, 8));
        }
      }
      else if (p.a(this.oyC, 16))
      {
        i = this.oyC.oyq;
        localObject1 = this.oyC.bSl();
        if (localObject1 == null) {
          break label221;
        }
      }
      label221:
      for (Object localObject1 = ((TmplShareWebViewToolUI)localObject1).getString(2131762164);; localObject1 = null)
      {
        paraml.a(i, (CharSequence)localObject1, 2131689817, 0, p.b(this.oyC, 16));
        if (!paramBoolean) {
          break label227;
        }
        AppMethodBeat.o(7347);
        return;
        localObject1 = null;
        break;
      }
      for (;;)
      {
        try
        {
          label227:
          localObject3 = new Bundle();
          localObject1 = this.oyC.bSl();
          if (localObject1 != null)
          {
            i = localObject1.hashCode();
            ((Bundle)localObject3).putInt("WebViewShare_BinderID", i);
            localObject1 = this.oyC.bSl();
            if (localObject1 == null) {
              continue;
            }
            localObject1 = ((TmplShareWebViewToolUI)localObject1).eWY();
            if (localObject1 == null) {
              continue;
            }
            localObject1 = ((MMWebView)localObject1).getUrl();
            ((Bundle)localObject3).putString("WebViewShare_wv_url", (String)localObject1);
            localObject1 = this.oyC.bSl();
            if (localObject1 == null) {
              continue;
            }
            localObject1 = ((TmplShareWebViewToolUI)localObject1).lzT;
            if (localObject1 == null) {
              continue;
            }
            localObject1 = ((com.tencent.mm.plugin.webview.stub.e)localObject1).k(109, (Bundle)localObject3);
            if (localObject1 == null) {
              continue;
            }
            i = ((Bundle)localObject1).getInt("key_hao_kan_permission", 0);
          }
        }
        catch (RemoteException localRemoteException1)
        {
          int k;
          int j = -1;
          ae.e(this.oyC.TAG, "isSetHaoKan, e = " + localRemoteException1.getMessage());
          i = -1;
          continue;
          Object localObject2 = null;
          continue;
          if ((!p.a(this.oyC, 0)) || (i != 1)) {
            continue;
          }
          i = this.oyC.oyt;
          localObject2 = this.oyC.bSl();
          if (localObject2 != null)
          {
            localObject2 = ((TmplShareWebViewToolUI)localObject2).getString(2131762165);
            localObject2 = (CharSequence)localObject2;
            localObject3 = this.oyC.bSl();
            if (localObject3 == null) {
              d.g.b.p.gkB();
            }
            paraml.a(i, (CharSequence)localObject2, 2131689798, ((TmplShareWebViewToolUI)localObject3).getResources().getColor(2131099829));
            continue;
          }
          localObject2 = null;
          continue;
          localObject2 = null;
          continue;
          i = -1;
          j = -1;
          continue;
        }
        try
        {
          k = ((Bundle)localObject1).getInt("key_hao_kan_recommand", -1);
          j = i;
          i = k;
          if (j == 1)
          {
            if ((!p.a(this.oyC, 0)) || (i != 0)) {
              continue;
            }
            i = this.oyC.oys;
            localObject1 = this.oyC.bSl();
            if (localObject1 == null) {
              continue;
            }
            localObject1 = ((TmplShareWebViewToolUI)localObject1).getString(2131762173);
            localObject1 = (CharSequence)localObject1;
            localObject3 = this.oyC.bSl();
            if (localObject3 == null) {
              d.g.b.p.gkB();
            }
            paraml.a(i, (CharSequence)localObject1, 2131689811, ((TmplShareWebViewToolUI)localObject3).getResources().getColor(2131099829));
          }
          if (p.a(this.oyC, 64))
          {
            i = this.oyC.oyr;
            localObject1 = this.oyC.bSl();
            if (localObject1 == null) {
              continue;
            }
            localObject1 = ((TmplShareWebViewToolUI)localObject1).getString(2131761941);
            paraml.a(i, (CharSequence)localObject1, 2131689808, 0, p.b(this.oyC, 64));
          }
          AppMethodBeat.o(7347);
          return;
        }
        catch (RemoteException localRemoteException2)
        {
          j = i;
          continue;
        }
        i = 0;
        continue;
        localObject1 = null;
        continue;
        localObject1 = null;
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class e
    implements n.d
  {
    e(p paramp, boolean paramBoolean) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      AppMethodBeat.i(7348);
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(480L, 0L, 1L, false);
      paraml.clear();
      if (this.oyC.bSl() == null)
      {
        AppMethodBeat.o(7348);
        return;
      }
      int i;
      if (!paramBoolean)
      {
        localObject1 = this.oyC.bSl();
        if (localObject1 == null) {
          d.g.b.p.gkB();
        }
        if (((TmplShareWebViewToolUI)localObject1).eWi() != null)
        {
          localObject1 = this.oyC.bSl();
          if (localObject1 == null) {
            d.g.b.p.gkB();
          }
          localObject1 = ((TmplShareWebViewToolUI)localObject1).eWi();
          d.g.b.p.g(localObject1, "context()!!.webViewFloatBallHelper");
          if (((com.tencent.mm.plugin.webview.ui.tools.floatball.a)localObject1).bhi())
          {
            localObject1 = this.oyC.bSl();
            if (localObject1 == null) {
              d.g.b.p.gkB();
            }
            if (((TmplShareWebViewToolUI)localObject1).eWi().bLw()) {
              break label418;
            }
            i = this.oyC.oyx;
            localObject1 = this.oyC.bSl();
            if (localObject1 == null) {
              break label413;
            }
            localObject1 = ((TmplShareWebViewToolUI)localObject1).getString(2131762178);
            paraml.a(i, (CharSequence)localObject1, 2131690574);
          }
        }
      }
      label165:
      Object localObject1 = this.oyC.bSl();
      label182:
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((TmplShareWebViewToolUI)localObject1).eRj();
        localObject2 = this.oyC.bSl();
        if (localObject2 == null) {
          break label495;
        }
        localObject2 = ((TmplShareWebViewToolUI)localObject2).Ewa;
        label203:
        if (localObject2 == null) {
          break label501;
        }
        localObject1 = com.tencent.mm.plugin.webview.ui.tools.n.aKm((String)localObject1);
        label213:
        if ((localObject1 != null) && (((n.a)localObject1).isDataValid())) {
          break label506;
        }
        i = 1;
        label226:
        if ((p.a(this.oyC, 1)) && (i != 0))
        {
          i = this.oyC.oyu;
          localObject1 = this.oyC.bSl();
          if (localObject1 == null) {
            break label511;
          }
          localObject1 = ((TmplShareWebViewToolUI)localObject1).getString(2131766258);
          paraml.a(i, (CharSequence)localObject1, 2131690612, p.b(this.oyC, 1));
        }
        label268:
        if (p.a(this.oyC, 0))
        {
          i = this.oyC.oyw;
          localObject1 = this.oyC.bSl();
          if (localObject1 == null) {
            break label516;
          }
          localObject1 = ((TmplShareWebViewToolUI)localObject1).getString(2131756596);
          label326:
          paraml.a(i, (CharSequence)localObject1, 2131690646, p.b(this.oyC, 0));
        }
        if (p.a(this.oyC, 32))
        {
          i = this.oyC.oyv;
          localObject1 = this.oyC.bSl();
          if (localObject1 == null) {
            break label521;
          }
        }
      }
      label516:
      label521:
      for (localObject1 = ((TmplShareWebViewToolUI)localObject1).getString(2131766247);; localObject1 = null)
      {
        paraml.a(i, (CharSequence)localObject1, 2131690588, p.b(this.oyC, 32));
        AppMethodBeat.o(7348);
        return;
        label413:
        localObject1 = null;
        break;
        label418:
        localObject1 = this.oyC.bSl();
        if (localObject1 == null) {
          d.g.b.p.gkB();
        }
        if (!((TmplShareWebViewToolUI)localObject1).eWi().bLw()) {
          break label165;
        }
        i = this.oyC.oyy;
        localObject1 = this.oyC.bSl();
        if (localObject1 != null) {}
        for (localObject1 = ((TmplShareWebViewToolUI)localObject1).getString(2131762168);; localObject1 = null)
        {
          paraml.a(i, (CharSequence)localObject1, 2131690573);
          break;
        }
        localObject1 = null;
        break label182;
        label495:
        localObject2 = null;
        break label203;
        label501:
        localObject1 = null;
        break label213;
        label506:
        i = 0;
        break label226;
        label511:
        localObject1 = null;
        break label268;
        localObject1 = null;
        break label326;
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(p paramp, n.a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(175545);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/video/util/MpMenuHelper$showMenu$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      paramView = this.oyC.bSl();
      if (paramView != null)
      {
        paramView = paramView.Eae;
        if (paramView != null)
        {
          localObject = paramView.eUs();
          if (localObject != null)
          {
            paramView = this.oyC.lZK;
            if (paramView == null) {
              d.g.b.p.bdF("ui");
            }
            paramView = (TmplShareWebViewToolUI)paramView.get();
            if (paramView == null) {
              break label225;
            }
          }
        }
      }
      label225:
      for (paramView = paramView.bRn();; paramView = null)
      {
        ((ay.d)localObject).B(new Object[] { paramView, Integer.valueOf(38), Integer.valueOf(1) }).report();
        paramView = this.oyC.bSl();
        if (paramView != null)
        {
          paramView = paramView.EvT;
          if (paramView != null) {
            paramView.fZ("Contact_Scene", 173);
          }
        }
        paramView = this.oyC.bSl();
        if (paramView != null) {
          paramView.aKk(this.oyF.hTJ);
        }
        if (this.oyC.mIQ != null)
        {
          paramView = this.oyC.mIQ;
          if (paramView != null) {
            paramView.bqD();
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/video/util/MpMenuHelper$showMenu$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(175545);
        return;
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class g
    implements n.e
  {
    g(p paramp) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(7350);
      this.oyC.oyA = false;
      Object localObject1 = this.oyC.bSl();
      Object localObject2;
      label84:
      Object localObject3;
      label119:
      Object localObject4;
      if (localObject1 != null)
      {
        localObject1 = ((TmplShareWebViewToolUI)localObject1).getIntent();
        if (localObject1 != null)
        {
          localObject1 = ((Intent)localObject1).getStringExtra("KPublisherId");
          localObject2 = this.oyC.bSl();
          if (localObject2 == null) {
            break label291;
          }
          localObject2 = ((TmplShareWebViewToolUI)localObject2).getIntent();
          if (localObject2 == null) {
            break label291;
          }
          localObject2 = ((Intent)localObject2).getStringExtra("KAppId");
          localObject3 = this.oyC.bSl();
          if (localObject3 == null) {
            break label297;
          }
          localObject3 = ((TmplShareWebViewToolUI)localObject3).getIntent();
          if (localObject3 == null) {
            break label297;
          }
          localObject3 = ((Intent)localObject3).getStringExtra("srcUsername");
          d.g.b.p.g(paramMenuItem, "menuItem");
          paramInt = paramMenuItem.getItemId();
          if (paramInt != this.oyC.oyp) {
            break label315;
          }
          paramMenuItem = g.oxe;
          paramMenuItem = this.oyC.bSl();
          if (paramMenuItem == null) {
            d.g.b.p.gkB();
          }
          g.a((Context)paramMenuItem, p.a(this.oyC), p.b(this.oyC));
          paramMenuItem = this.oyC.bSl();
          if (paramMenuItem == null) {
            break label308;
          }
          paramMenuItem = paramMenuItem.Eae;
          if (paramMenuItem == null) {
            break label308;
          }
          localObject4 = paramMenuItem.eUs();
          if (localObject4 == null) {
            break label308;
          }
          paramMenuItem = this.oyC.bSl();
          if (paramMenuItem == null) {
            break label303;
          }
        }
      }
      label291:
      label297:
      label303:
      for (paramMenuItem = paramMenuItem.bRn();; paramMenuItem = null)
      {
        ((ay.d)localObject4).B(new Object[] { paramMenuItem, Integer.valueOf(1), Integer.valueOf(1), localObject1, localObject2, localObject3 }).report();
        AppMethodBeat.o(7350);
        return;
        localObject1 = null;
        break;
        localObject2 = null;
        break label84;
        localObject3 = null;
        break label119;
      }
      label308:
      AppMethodBeat.o(7350);
      return;
      label315:
      if (paramInt == this.oyC.oyq)
      {
        localObject4 = this.oyC;
        ae.i(((p)localObject4).TAG, "doTimeline");
        paramMenuItem = ((p)localObject4).lZK;
        if (paramMenuItem == null) {
          d.g.b.p.bdF("ui");
        }
        if (paramMenuItem.get() != null)
        {
          paramMenuItem = ((p)localObject4).lZK;
          if (paramMenuItem == null) {
            d.g.b.p.bdF("ui");
          }
          paramMenuItem = (TmplShareWebViewToolUI)paramMenuItem.get();
          if (paramMenuItem != null)
          {
            paramMenuItem = Boolean.valueOf(paramMenuItem.isFinishing());
            if (paramMenuItem == null) {
              d.g.b.p.gkB();
            }
            if (!paramMenuItem.booleanValue()) {
              break label530;
            }
          }
        }
        else
        {
          ae.i(((p)localObject4).TAG, "activity finished");
          paramMenuItem = this.oyC.bSl();
          if (paramMenuItem == null) {
            break label1339;
          }
          paramMenuItem = paramMenuItem.Eae;
          if (paramMenuItem == null) {
            break label1339;
          }
          localObject4 = paramMenuItem.eUs();
          if (localObject4 == null) {
            break label1339;
          }
          paramMenuItem = this.oyC.bSl();
          if (paramMenuItem == null) {
            break label1334;
          }
        }
        for (paramMenuItem = paramMenuItem.bRn();; paramMenuItem = null)
        {
          ((ay.d)localObject4).B(new Object[] { paramMenuItem, Integer.valueOf(2), Integer.valueOf(1), localObject1, localObject2, localObject3 }).report();
          AppMethodBeat.o(7350);
          return;
          paramMenuItem = null;
          break;
          Intent localIntent = new Intent();
          paramMenuItem = ((p)localObject4).otY;
          if (paramMenuItem == null) {
            d.g.b.p.bdF("msgInfo");
          }
          int i = paramMenuItem.hFY.videoWidth;
          paramInt = i;
          if (i <= 0) {
            paramInt = 150;
          }
          localIntent.putExtra("Ksnsupload_width", paramInt);
          localIntent.putExtra("Ksnsupload_height", paramInt);
          paramMenuItem = ((p)localObject4).ovq;
          if (paramMenuItem == null) {
            d.g.b.p.bdF("controller");
          }
          Object localObject5;
          if (paramMenuItem.bSm())
          {
            paramMenuItem = ((p)localObject4).ovq;
            if (paramMenuItem == null) {
              d.g.b.p.bdF("controller");
            }
            paramMenuItem = paramMenuItem.oue;
            if (paramMenuItem != null)
            {
              paramMenuItem = paramMenuItem.title;
              localIntent.putExtra("Ksnsupload_title", paramMenuItem);
              paramMenuItem = ((p)localObject4).ovq;
              if (paramMenuItem == null) {
                d.g.b.p.bdF("controller");
              }
              paramMenuItem = paramMenuItem.oue;
              if (paramMenuItem == null) {
                break label1164;
              }
              paramMenuItem = paramMenuItem.hGe;
              localIntent.putExtra("Ksnsupload_imgurl", paramMenuItem);
              paramMenuItem = ((p)localObject4).ovq;
              if (paramMenuItem == null) {
                d.g.b.p.bdF("controller");
              }
              localIntent.putExtra("Ksnsupload_link", paramMenuItem.url);
              paramMenuItem = ((p)localObject4).otY;
              if (paramMenuItem == null) {
                d.g.b.p.bdF("msgInfo");
              }
              paramMenuItem = paramMenuItem.hFX;
              localObject5 = ((p)localObject4).otY;
              if (localObject5 == null) {
                d.g.b.p.bdF("msgInfo");
              }
              if (bu.isNullOrNil(((x)localObject5).dpP)) {
                break label1232;
              }
              localObject5 = ((p)localObject4).otY;
              if (localObject5 == null) {
                d.g.b.p.bdF("msgInfo");
              }
              localIntent.putExtra("src_username", ((x)localObject5).dpP);
              localObject5 = ((p)localObject4).otY;
              if (localObject5 == null) {
                d.g.b.p.bdF("msgInfo");
              }
              localIntent.putExtra("src_displayname", ((x)localObject5).hFW);
              localIntent.putExtra("Ksnsupload_type", 1);
              localObject5 = ((p)localObject4).ovq;
              if (localObject5 == null) {
                d.g.b.p.bdF("controller");
              }
              localIntent.putExtra("ShareUrlOriginal", ((com.tencent.mm.plugin.brandservice.ui.timeline.video.b)localObject5).url);
              localIntent.putExtra("KPublisherId", paramMenuItem);
              localIntent.putExtra("need_result", true);
              localObject5 = ((p)localObject4).ovq;
              if (localObject5 == null) {
                d.g.b.p.bdF("controller");
              }
              if (!((com.tencent.mm.plugin.brandservice.ui.timeline.video.b)localObject5).bSm()) {
                break label1297;
              }
              localObject5 = ((p)localObject4).ovq;
              if (localObject5 == null) {
                d.g.b.p.bdF("controller");
              }
              if (((com.tencent.mm.plugin.brandservice.ui.timeline.video.b)localObject5).oue != null)
              {
                localObject5 = ((p)localObject4).ovq;
                if (localObject5 == null) {
                  d.g.b.p.bdF("controller");
                }
                localObject5 = ((com.tencent.mm.plugin.brandservice.ui.timeline.video.b)localObject5).oue;
                if (localObject5 == null) {
                  d.g.b.p.gkB();
                }
                if (((byj)localObject5).hGg != null)
                {
                  localObject5 = ((p)localObject4).ovq;
                  if (localObject5 == null) {
                    d.g.b.p.bdF("controller");
                  }
                  localObject5 = ((com.tencent.mm.plugin.brandservice.ui.timeline.video.b)localObject5).oue;
                  if (localObject5 == null) {
                    d.g.b.p.gkB();
                  }
                  localIntent.putExtra("ksnsupload_link_desc", ((byj)localObject5).hGg);
                }
              }
            }
          }
          for (;;)
          {
            paramMenuItem = z.Br(paramMenuItem);
            localIntent.putExtra("reportSessionId", paramMenuItem);
            localObject5 = ((p)localObject4).lZK;
            if (localObject5 == null) {
              d.g.b.p.bdF("ui");
            }
            localObject5 = ((WeakReference)localObject5).get();
            if (localObject5 == null) {
              d.g.b.p.gkB();
            }
            localIntent.putExtra("BizVideoDetailUIExtras", ((TmplShareWebViewToolUI)localObject5).getIntent().getExtras());
            localObject5 = f.oxd;
            localObject5 = ((p)localObject4).otY;
            if (localObject5 == null) {
              d.g.b.p.bdF("msgInfo");
            }
            com.tencent.mm.plugin.brandservice.ui.timeline.video.b localb = ((p)localObject4).ovq;
            if (localb == null) {
              d.g.b.p.bdF("controller");
            }
            d.g.b.p.g(paramMenuItem, "sessionId");
            f.a((x)localObject5, localb, paramMenuItem, (com.tencent.mm.ipcinvoker.d)new p.b((p)localObject4, localIntent));
            break;
            paramMenuItem = null;
            break label641;
            paramMenuItem = null;
            break label679;
            paramMenuItem = ((p)localObject4).otY;
            if (paramMenuItem == null) {
              d.g.b.p.bdF("msgInfo");
            }
            localIntent.putExtra("Ksnsupload_title", paramMenuItem.hFY.title);
            paramMenuItem = ((p)localObject4).otY;
            if (paramMenuItem == null) {
              d.g.b.p.bdF("msgInfo");
            }
            localIntent.putExtra("Ksnsupload_imgurl", paramMenuItem.hFY.hGe);
            break label688;
            label1232:
            localObject5 = ((p)localObject4).otY;
            if (localObject5 == null) {
              d.g.b.p.bdF("msgInfo");
            }
            localIntent.putExtra("src_username", ((x)localObject5).Wa());
            localObject5 = ((p)localObject4).otY;
            if (localObject5 == null) {
              d.g.b.p.bdF("msgInfo");
            }
            localIntent.putExtra("src_displayname", ((x)localObject5).hFW);
            break label825;
            localObject5 = ((p)localObject4).otY;
            if (localObject5 == null) {
              d.g.b.p.bdF("msgInfo");
            }
            localIntent.putExtra("ksnsupload_link_desc", ((x)localObject5).hFY.hGg);
          }
        }
        AppMethodBeat.o(7350);
        return;
      }
      label530:
      label679:
      label688:
      label825:
      label1339:
      if (paramInt == this.oyC.oyr)
      {
        paramMenuItem = this.oyC.bSl();
        if (paramMenuItem != null)
        {
          paramMenuItem = paramMenuItem.Eae;
          if (paramMenuItem != null)
          {
            localObject1 = paramMenuItem.eUs();
            if (localObject1 != null)
            {
              paramMenuItem = this.oyC.bSl();
              if (paramMenuItem == null) {
                break label1553;
              }
              paramMenuItem = paramMenuItem.bRn();
              ((ay.d)localObject1).B(new Object[] { paramMenuItem, Integer.valueOf(3), Integer.valueOf(1) }).report();
            }
          }
        }
        localObject1 = this.oyC;
        paramMenuItem = e.oxc;
        paramMenuItem = ((p)localObject1).otY;
        if (paramMenuItem == null) {
          d.g.b.p.bdF("msgInfo");
        }
        localObject2 = ((p)localObject1).ovq;
        if (localObject2 == null) {
          d.g.b.p.bdF("controller");
        }
        e.a(paramMenuItem, (com.tencent.mm.plugin.brandservice.ui.timeline.video.b)localObject2);
        localObject2 = (Context)((p)localObject1).bSl();
        paramMenuItem = ((p)localObject1).bSl();
        if (paramMenuItem != null) {}
        for (paramMenuItem = paramMenuItem.getString(2131758936);; paramMenuItem = null)
        {
          com.tencent.mm.ui.base.h.cj((Context)localObject2, paramMenuItem);
          paramMenuItem = ((p)localObject1).ovq;
          if (paramMenuItem == null) {
            d.g.b.p.bdF("controller");
          }
          paramMenuItem.otT.aG(24, "");
          AppMethodBeat.o(7350);
          return;
          paramMenuItem = null;
          break;
        }
      }
      label641:
      label1164:
      label1297:
      label1334:
      if (paramInt == this.oyC.oyu)
      {
        paramMenuItem = this.oyC.bSl();
        if (paramMenuItem != null)
        {
          paramMenuItem = paramMenuItem.Eae;
          if (paramMenuItem != null)
          {
            localObject1 = paramMenuItem.eUs();
            if (localObject1 != null)
            {
              paramMenuItem = this.oyC.bSl();
              if (paramMenuItem == null) {
                break label1742;
              }
            }
          }
        }
        label1742:
        for (paramMenuItem = paramMenuItem.bRn();; paramMenuItem = null)
        {
          ((ay.d)localObject1).B(new Object[] { paramMenuItem, Integer.valueOf(4), Integer.valueOf(1) }).report();
          localObject1 = this.oyC;
          paramMenuItem = ((p)localObject1).ovq;
          if (paramMenuItem == null) {
            d.g.b.p.bdF("controller");
          }
          if ((paramMenuItem.hBZ & 0x1) == 0) {
            break;
          }
          paramMenuItem = ((p)localObject1).TAG;
          localObject2 = new StringBuilder("not allow jump to profile ");
          localObject1 = ((p)localObject1).ovq;
          if (localObject1 == null) {
            d.g.b.p.bdF("controller");
          }
          ae.w(paramMenuItem, ((com.tencent.mm.plugin.brandservice.ui.timeline.video.b)localObject1).hBZ);
          AppMethodBeat.o(7350);
          return;
        }
        if (((p)localObject1).bSl() != null)
        {
          paramMenuItem = ((p)localObject1).bSl();
          if (paramMenuItem == null) {
            break label1781;
          }
        }
        label1781:
        for (paramMenuItem = paramMenuItem.EvT; paramMenuItem == null; paramMenuItem = null)
        {
          AppMethodBeat.o(7350);
          return;
        }
        paramMenuItem = ((p)localObject1).bSl();
        if (paramMenuItem != null)
        {
          paramMenuItem = paramMenuItem.EvT;
          if (paramMenuItem != null) {
            paramMenuItem.fZ("Contact_Scene", 153);
          }
        }
        paramMenuItem = ((p)localObject1).bSl();
        if (paramMenuItem != null)
        {
          localObject1 = ((p)localObject1).ovq;
          if (localObject1 == null) {
            d.g.b.p.bdF("controller");
          }
          paramMenuItem.aKk(((com.tencent.mm.plugin.brandservice.ui.timeline.video.b)localObject1).Wa());
          AppMethodBeat.o(7350);
          return;
        }
        AppMethodBeat.o(7350);
        return;
      }
      label1553:
      if (paramInt == this.oyC.oys)
      {
        paramMenuItem = this.oyC.bSl();
        if (paramMenuItem != null)
        {
          paramMenuItem = paramMenuItem.Eae;
          if (paramMenuItem != null)
          {
            localObject1 = paramMenuItem.eUs();
            if (localObject1 != null)
            {
              paramMenuItem = this.oyC.bSl();
              if (paramMenuItem == null) {
                break label2000;
              }
            }
          }
        }
        label2000:
        for (paramMenuItem = paramMenuItem.bRn();; paramMenuItem = null)
        {
          ((ay.d)localObject1).B(new Object[] { paramMenuItem, Integer.valueOf(36), Integer.valueOf(1) }).report();
          com.tencent.mm.plugin.webview.j.g.a((Context)this.oyC.bSl(), p.a(this.oyC).hFY.title, (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(7349);
              if (paramAnonymousDialogInterface == null) {}
              for (paramAnonymousDialogInterface = "";; paramAnonymousDialogInterface = ((com.tencent.mm.ui.widget.a.d)paramAnonymousDialogInterface).fQs())
              {
                Object localObject = this.oyG.oyC.bSl();
                if (localObject == null) {
                  break;
                }
                localObject = ((TmplShareWebViewToolUI)localObject).DRx;
                if (localObject == null) {
                  break;
                }
                ((com.tencent.mm.plugin.webview.c.f)localObject).u(1, paramAnonymousDialogInterface, 0);
                AppMethodBeat.o(7349);
                return;
              }
              AppMethodBeat.o(7349);
            }
          });
          AppMethodBeat.o(7350);
          return;
        }
      }
      if (paramInt == this.oyC.oyt)
      {
        paramMenuItem = this.oyC.bSl();
        if (paramMenuItem != null)
        {
          paramMenuItem = paramMenuItem.Eae;
          if (paramMenuItem != null)
          {
            localObject1 = paramMenuItem.eUs();
            if (localObject1 != null)
            {
              paramMenuItem = this.oyC.bSl();
              if (paramMenuItem == null) {
                break label2133;
              }
            }
          }
        }
        label2133:
        for (paramMenuItem = paramMenuItem.bRn();; paramMenuItem = null)
        {
          ((ay.d)localObject1).B(new Object[] { paramMenuItem, Integer.valueOf(37), Integer.valueOf(1) }).report();
          paramMenuItem = this.oyC.bSl();
          if (paramMenuItem == null) {
            break;
          }
          paramMenuItem = paramMenuItem.DRx;
          if (paramMenuItem == null) {
            break;
          }
          paramMenuItem.u(0, "", 0);
          AppMethodBeat.o(7350);
          return;
        }
        AppMethodBeat.o(7350);
        return;
      }
      if (paramInt == this.oyC.oyv)
      {
        paramMenuItem = this.oyC.bSl();
        if (paramMenuItem != null)
        {
          paramMenuItem = paramMenuItem.Eae;
          if (paramMenuItem != null)
          {
            localObject1 = paramMenuItem.eUs();
            if (localObject1 != null)
            {
              paramMenuItem = this.oyC.bSl();
              if (paramMenuItem == null) {
                break label2267;
              }
            }
          }
        }
        label2267:
        for (paramMenuItem = paramMenuItem.bRn();; paramMenuItem = null)
        {
          ((ay.d)localObject1).B(new Object[] { paramMenuItem, Integer.valueOf(5), Integer.valueOf(1) }).report();
          localObject1 = this.oyC;
          if (!((p)localObject1).isFinished()) {
            break;
          }
          ae.e(((p)localObject1).TAG, "copyLink fail, is finish");
          AppMethodBeat.o(7350);
          return;
        }
        paramMenuItem = ((p)localObject1).bSl();
        if (paramMenuItem != null)
        {
          paramMenuItem = paramMenuItem.getApplication();
          if (paramMenuItem == null) {}
        }
        for (paramMenuItem = paramMenuItem.getSystemService("clipboard"); paramMenuItem == null; paramMenuItem = null)
        {
          paramMenuItem = new d.v("null cannot be cast to non-null type android.text.ClipboardManager");
          AppMethodBeat.o(7350);
          throw paramMenuItem;
        }
        paramMenuItem = (ClipboardManager)paramMenuItem;
        if (paramMenuItem != null) {
          for (;;)
          {
            try
            {
              localObject2 = ((p)localObject1).ovq;
              if (localObject2 == null) {
                d.g.b.p.bdF("controller");
              }
              paramMenuItem.setText((CharSequence)((com.tencent.mm.plugin.brandservice.ui.timeline.video.b)localObject2).otS);
              localObject2 = (Context)((p)localObject1).bSl();
              paramMenuItem = ((p)localObject1).bSl();
              if (paramMenuItem != null)
              {
                paramMenuItem = paramMenuItem.getString(2131766248);
                Toast.makeText((Context)localObject2, (CharSequence)paramMenuItem, 0).show();
                AppMethodBeat.o(7350);
                return;
              }
            }
            catch (Exception paramMenuItem)
            {
              ae.printErrStackTrace(((p)localObject1).TAG, (Throwable)paramMenuItem, "clip.setText error", new Object[0]);
              AppMethodBeat.o(7350);
              return;
            }
            paramMenuItem = null;
          }
        }
        ae.e(((p)localObject1).TAG, "clipboard manager is null");
        AppMethodBeat.o(7350);
        return;
      }
      if (paramInt == this.oyC.oyw)
      {
        paramMenuItem = this.oyC.bSl();
        if (paramMenuItem != null)
        {
          paramMenuItem = paramMenuItem.Eae;
          if (paramMenuItem != null)
          {
            localObject1 = paramMenuItem.eUs();
            if (localObject1 != null)
            {
              paramMenuItem = this.oyC.bSl();
              if (paramMenuItem == null) {
                break label2898;
              }
              paramMenuItem = paramMenuItem.bRn();
              ((ay.d)localObject1).B(new Object[] { paramMenuItem, Integer.valueOf(11), Integer.valueOf(1) }).report();
            }
          }
        }
        localObject2 = this.oyC;
        paramMenuItem = ((p)localObject2).otY;
        if (paramMenuItem == null) {
          d.g.b.p.bdF("msgInfo");
        }
        localObject3 = paramMenuItem.hFY.url;
        paramMenuItem = null;
        if (!bu.isNullOrNil((String)localObject3))
        {
          paramMenuItem = Uri.parse((String)localObject3);
          d.g.b.p.g(paramMenuItem, "uri");
          paramMenuItem = paramMenuItem.getHost();
        }
        if (!bu.isNullOrNil(paramMenuItem))
        {
          if (paramMenuItem == null) {
            d.g.b.p.gkB();
          }
          if (!d.n.n.nF(paramMenuItem, "mp.weixin.qq.com")) {}
        }
      }
      label3254:
      for (;;)
      {
        try
        {
          paramMenuItem = ad.Njc;
          paramMenuItem = String.format("https://mp.weixin.qq.com/mp/infringement?url=%s#wechat_redirect", Arrays.copyOf(new Object[] { q.encode((String)localObject3, "utf-8") }, 1));
          d.g.b.p.g(paramMenuItem, "java.lang.String.format(format, *args)");
          if (!bu.isNullOrNil(paramMenuItem)) {
            break label3254;
          }
          paramMenuItem = ad.Njc;
          paramMenuItem = String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", Arrays.copyOf(new Object[] { Integer.valueOf(34) }, 1));
          d.g.b.p.g(paramMenuItem, "java.lang.String.format(format, *args)");
          localObject4 = new Intent();
        }
        catch (UnsupportedEncodingException paramMenuItem)
        {
          label2898:
          ae.e(((p)localObject2).TAG, paramMenuItem.getMessage());
        }
        try
        {
          localObject1 = ((p)localObject2).bSl();
          if (localObject1 == null) {
            break label2921;
          }
          localObject1 = ((TmplShareWebViewToolUI)localObject1).getDir("expose", 0);
          if (localObject1 != null) {
            ((File)localObject1).mkdirs();
          }
          if (localObject1 == null) {
            break label2927;
          }
          localObject1 = ((File)localObject1).getAbsolutePath();
          localObject1 = d.g.b.p.C((String)localObject1, "/screenshot.jpg");
          com.tencent.mm.sdk.platformtools.h.a(bi.aW((Activity)((p)localObject2).bSl()), 75, Bitmap.CompressFormat.JPEG, (String)localObject1, true);
          ((Intent)localObject4).putExtra("k_webview_img", (String)localObject1);
        }
        catch (IOException localIOException)
        {
          ae.e(((p)localObject2).TAG, "[oneliang]save screen shot to file error, ex = " + localIOException.getMessage());
          continue;
        }
        ((Intent)localObject4).putExtra("rawUrl", paramMenuItem);
        ((Intent)localObject4).putExtra("k_expose_url", (String)localObject3);
        paramMenuItem = ((p)localObject2).ovq;
        if (paramMenuItem == null) {
          d.g.b.p.bdF("controller");
        }
        ((Intent)localObject4).putExtra("k_expose_web_scene", paramMenuItem.scene);
        ((Intent)localObject4).putExtra("showShare", false);
        com.tencent.mm.br.d.b((Context)((p)localObject2).bSl(), "webview", ".ui.tools.WebViewUI", (Intent)localObject4);
        AppMethodBeat.o(7350);
        return;
        paramMenuItem = null;
        break;
        paramMenuItem = null;
        continue;
        label2921:
        localObject1 = null;
        continue;
        label2927:
        localObject1 = null;
        continue;
        TmplShareWebViewToolUI localTmplShareWebViewToolUI;
        if (paramInt == this.oyC.oyx)
        {
          paramMenuItem = this.oyC.bSl();
          if (paramMenuItem == null) {
            d.g.b.p.gkB();
          }
          paramMenuItem = paramMenuItem.Eae;
          if (paramMenuItem == null) {
            d.g.b.p.gkB();
          }
          paramMenuItem = paramMenuItem.eUs();
          localTmplShareWebViewToolUI = this.oyC.bSl();
          if (localTmplShareWebViewToolUI == null) {
            d.g.b.p.gkB();
          }
          paramMenuItem.B(new Object[] { localTmplShareWebViewToolUI.bRn(), Integer.valueOf(33), Integer.valueOf(1) }).report();
          paramMenuItem = this.oyC.bSl();
          if (paramMenuItem == null) {
            d.g.b.p.gkB();
          }
          paramMenuItem.eWi().iK(true);
          AppMethodBeat.o(7350);
          return;
        }
        if (paramInt == this.oyC.oyy)
        {
          paramMenuItem = this.oyC.bSl();
          if (paramMenuItem == null) {
            d.g.b.p.gkB();
          }
          paramMenuItem = paramMenuItem.Eae;
          if (paramMenuItem == null) {
            d.g.b.p.gkB();
          }
          paramMenuItem = paramMenuItem.eUs();
          localTmplShareWebViewToolUI = this.oyC.bSl();
          if (localTmplShareWebViewToolUI == null) {
            d.g.b.p.gkB();
          }
          paramMenuItem.B(new Object[] { localTmplShareWebViewToolUI.bRn(), Integer.valueOf(34), Integer.valueOf(1) }).report();
          paramMenuItem = this.oyC.bSl();
          if (paramMenuItem == null) {
            d.g.b.p.gkB();
          }
          paramMenuItem.eWi().iK(false);
          AppMethodBeat.o(7350);
          return;
        }
        ae.w(this.oyC.TAG, "wrong id: " + paramMenuItem.getItemId());
        AppMethodBeat.o(7350);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.p
 * JD-Core Version:    0.7.0.1
 */