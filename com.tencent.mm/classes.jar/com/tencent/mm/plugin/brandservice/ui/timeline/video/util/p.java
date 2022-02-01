package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.v;
import com.tencent.mm.ag.x;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.br.c;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.model.ad;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI;
import com.tencent.mm.plugin.webview.model.az;
import com.tencent.mm.plugin.webview.model.az.d;
import com.tencent.mm.plugin.webview.ui.tools.j;
import com.tencent.mm.plugin.webview.ui.tools.o.a;
import com.tencent.mm.protocal.protobuf.cmb;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.ScreenShotUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.e.e;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.a.e.b;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import kotlin.g.b.ae;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MpMenuHelper;", "", "()V", "MENU_ID_CANCEL_HAO_KAN", "", "MENU_ID_CANCEL_MINIMIZE", "MENU_ID_COPY_LINK", "MENU_ID_EXPOSE", "MENU_ID_FAV", "MENU_ID_HAO_KAN", "MENU_ID_MINIMIZE", "MENU_ID_SEND_TO_FRIEND", "MENU_ID_SHARE_TO_TIMELINE", "MENU_ID_SHOW_BIZ", "TAG", "", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "isBottomSheetShowing", "", "mmBottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "msgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "onlyShowShareMenu", "shareExtInfo", "getShareExtInfo", "()Ljava/lang/String;", "setShareExtInfo", "(Ljava/lang/String;)V", "ui", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI;", "getUi$plugin_brandservice_release", "()Ljava/lang/ref/WeakReference;", "setUi$plugin_brandservice_release", "(Ljava/lang/ref/WeakReference;)V", "context", "copyLink", "", "doExpose", "fav", "goProfile", "hasShowMenuPermission", "id", "bitSet", "init", "isFinished", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onDestroy", "shareToTimeline", "shouldDisableMenuItem", "showMenu", "updateMenu", "plugin-brandservice_release"})
public final class p
{
  final String TAG = "MicroMsg.MpMenuHelper";
  com.tencent.mm.ui.widget.a.e nVN;
  public WeakReference<TmplShareWebViewToolUI> nhy;
  public x pHv;
  public com.tencent.mm.plugin.brandservice.ui.timeline.video.b pIL;
  final int pLT;
  final int pLU = 1;
  final int pLV = 2;
  final int pLW = 3;
  final int pLX = 4;
  final int pLY = 5;
  final int pLZ = 6;
  final int pMa = 7;
  final int pMb = 8;
  final int pMc = 9;
  public boolean pMd;
  boolean pMe;
  public String pMf = "";
  
  public final void ani()
  {
    AppMethodBeat.i(7352);
    if (this.pMe) {
      ks(this.pMd);
    }
    AppMethodBeat.o(7352);
  }
  
  public final TmplShareWebViewToolUI cpV()
  {
    AppMethodBeat.i(7355);
    Object localObject = this.nhy;
    if (localObject == null) {
      kotlin.g.b.p.btv("ui");
    }
    if (((WeakReference)localObject).get() == null)
    {
      AppMethodBeat.o(7355);
      return null;
    }
    localObject = this.nhy;
    if (localObject == null) {
      kotlin.g.b.p.btv("ui");
    }
    localObject = ((WeakReference)localObject).get();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI");
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
    Object localObject = this.nhy;
    if (localObject == null) {
      kotlin.g.b.p.btv("ui");
    }
    if (((WeakReference)localObject).get() != null)
    {
      localObject = this.nhy;
      if (localObject == null) {
        kotlin.g.b.p.btv("ui");
      }
      localObject = ((WeakReference)localObject).get();
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI");
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
  
  public final void ks(final boolean paramBoolean)
  {
    AppMethodBeat.i(7353);
    this.pMd = paramBoolean;
    if (!paramBoolean) {
      this.pMf = "";
    }
    if (isFinished())
    {
      Log.i(this.TAG, "showMenu return:isFinished=%b", new Object[] { Boolean.valueOf(isFinished()) });
      AppMethodBeat.o(7353);
      return;
    }
    Object localObject2;
    o.g localg;
    if (!this.pMe)
    {
      if (paramBoolean)
      {
        localObject1 = this.pIL;
        if (localObject1 == null) {
          kotlin.g.b.p.btv("controller");
        }
        if ((((com.tencent.mm.plugin.brandservice.ui.timeline.video.b)localObject1).iwg & 0x8) != 0)
        {
          localObject1 = this.pIL;
          if (localObject1 == null) {
            kotlin.g.b.p.btv("controller");
          }
          if ((((com.tencent.mm.plugin.brandservice.ui.timeline.video.b)localObject1).iwg & 0x10) != 0)
          {
            localObject2 = (Context)cpV();
            localObject1 = cpV();
            if (localObject1 != null) {}
            for (localObject1 = ((TmplShareWebViewToolUI)localObject1).getString(2131768771);; localObject1 = null)
            {
              com.tencent.mm.ui.base.h.cA((Context)localObject2, (String)localObject1);
              AppMethodBeat.o(7353);
              return;
            }
          }
        }
        this.nVN = new com.tencent.mm.ui.widget.a.e((Context)cpV(), 1, false);
      }
    }
    else
    {
      localObject1 = this.nVN;
      if (localObject1 != null) {
        ((com.tencent.mm.ui.widget.a.e)localObject1).b((e.b)new c(this));
      }
      localObject1 = this.nVN;
      if (localObject1 != null) {
        ((com.tencent.mm.ui.widget.a.e)localObject1).a((o.f)new d(this, paramBoolean));
      }
      localg = (o.g)new g(this);
      localObject1 = this.nVN;
      if (localObject1 != null) {
        ((com.tencent.mm.ui.widget.a.e)localObject1).a(localg);
      }
      localObject1 = this.nVN;
      if (localObject1 != null) {
        ((com.tencent.mm.ui.widget.a.e)localObject1).b((o.f)new e(this, paramBoolean));
      }
      localObject1 = cpV();
      if (localObject1 == null) {
        break label570;
      }
      localObject2 = ((TmplShareWebViewToolUI)localObject1).fZM();
      label298:
      localObject1 = cpV();
      if ((localObject1 == null) || (((TmplShareWebViewToolUI)localObject1).ILE == null)) {
        break label576;
      }
    }
    label570:
    label576:
    for (Object localObject1 = com.tencent.mm.plugin.webview.ui.tools.o.baw((String)localObject2);; localObject1 = null)
    {
      boolean bool = ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).isMpUrl((String)localObject2);
      if ((!paramBoolean) && (bool) && (localObject1 != null) && (((o.a)localObject1).isDataValid()))
      {
        localObject2 = LayoutInflater.from((Context)cpV()).inflate(2131495652, null);
        ImageView localImageView = (ImageView)((View)localObject2).findViewById(2131302895);
        Object localObject3 = (TextView)((View)localObject2).findViewById(2131309510);
        View localView = ((View)localObject2).findViewById(2131299205);
        kotlin.g.b.p.g(localObject3, "nickNameTextView");
        ((TextView)localObject3).setText((CharSequence)((o.a)localObject1).Jkn);
        localObject3 = new c.a().bdq().bdt().ty(2131231957);
        com.tencent.mm.av.a.a.bdb().a(((o.a)localObject1).Jko, localImageView, ((c.a)localObject3).bdv());
        localView.setOnClickListener((View.OnClickListener)new f(this, (o.a)localObject1));
        com.tencent.mm.ui.tools.o.hp(localView);
        localObject1 = this.nVN;
        if (localObject1 != null) {
          ((com.tencent.mm.ui.widget.a.e)localObject1).V((View)localObject2, true);
        }
      }
      localObject1 = this.nVN;
      if (localObject1 != null) {
        ((com.tencent.mm.ui.widget.a.e)localObject1).b(localg);
      }
      localObject1 = this.nVN;
      if (localObject1 != null) {
        ((com.tencent.mm.ui.widget.a.e)localObject1).dGm();
      }
      this.pMe = true;
      AppMethodBeat.o(7353);
      return;
      this.nVN = new com.tencent.mm.ui.widget.a.e((Context)cpV(), 0, true);
      break;
      localObject2 = null;
      break label298;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(7356);
    if (this.nVN != null)
    {
      com.tencent.mm.ui.widget.a.e locale = this.nVN;
      if (locale == null) {
        kotlin.g.b.p.hyc();
      }
      if (locale.isShowing())
      {
        locale = this.nVN;
        if (locale == null) {
          kotlin.g.b.p.hyc();
        }
        locale.bMo();
      }
    }
    AppMethodBeat.o(7356);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "bundle", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "onCallback"})
  public static final class a<T>
    implements com.tencent.mm.ipcinvoker.d<Bundle>
  {
    public a(p paramp) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "bundle", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class b<T>
    implements com.tencent.mm.ipcinvoker.d<Bundle>
  {
    b(p paramp, Intent paramIntent) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onDismiss"})
  static final class c
    implements e.b
  {
    c(p paramp) {}
    
    public final void onDismiss()
    {
      this.pMg.pMe = false;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class d
    implements o.f
  {
    d(p paramp, boolean paramBoolean) {}
    
    public final void onCreateMMMenu(m paramm)
    {
      AppMethodBeat.i(7347);
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(480L, 0L, 1L, false);
      paramm.clear();
      if (this.pMg.cpV() == null)
      {
        AppMethodBeat.o(7347);
        return;
      }
      if (p.a(this.pMg, 8))
      {
        i = this.pMg.pLT;
        localObject1 = this.pMg.cpV();
        if (localObject1 != null)
        {
          localObject1 = ((TmplShareWebViewToolUI)localObject1).getString(2131764184);
          localObject1 = (CharSequence)localObject1;
          localObject3 = this.pMg.cpV();
          if (localObject3 == null) {
            kotlin.g.b.p.hyc();
          }
          paramm.a(i, (CharSequence)localObject1, 2131690674, ((TmplShareWebViewToolUI)localObject3).getResources().getColor(2131099710), p.b(this.pMg, 8));
        }
      }
      else if (p.a(this.pMg, 16))
      {
        i = this.pMg.pLU;
        localObject1 = this.pMg.cpV();
        if (localObject1 == null) {
          break label221;
        }
      }
      label221:
      for (Object localObject1 = ((TmplShareWebViewToolUI)localObject1).getString(2131764185);; localObject1 = null)
      {
        paramm.a(i, (CharSequence)localObject1, 2131689830, 0, p.b(this.pMg, 16));
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
          localObject1 = this.pMg.cpV();
          if (localObject1 != null)
          {
            i = localObject1.hashCode();
            ((Bundle)localObject3).putInt("WebViewShare_BinderID", i);
            localObject1 = this.pMg.cpV();
            if (localObject1 == null) {
              continue;
            }
            localObject1 = ((TmplShareWebViewToolUI)localObject1).gfW();
            if (localObject1 == null) {
              continue;
            }
            localObject1 = ((MMWebView)localObject1).getUrl();
            ((Bundle)localObject3).putString("WebViewShare_wv_url", (String)localObject1);
            localObject1 = this.pMg.cpV();
            if (localObject1 == null) {
              continue;
            }
            localObject1 = ((TmplShareWebViewToolUI)localObject1).mHh;
            if (localObject1 == null) {
              continue;
            }
            localObject1 = ((com.tencent.mm.plugin.webview.stub.e)localObject1).j(109, (Bundle)localObject3);
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
          Log.e(this.pMg.TAG, "isSetHaoKan, e = " + localRemoteException1.getMessage());
          i = -1;
          continue;
          Object localObject2 = null;
          continue;
          if ((!p.a(this.pMg, 0)) || (i != 1)) {
            continue;
          }
          i = this.pMg.pLX;
          localObject2 = this.pMg.cpV();
          if (localObject2 != null)
          {
            localObject2 = ((TmplShareWebViewToolUI)localObject2).getString(2131764186);
            localObject2 = (CharSequence)localObject2;
            localObject3 = this.pMg.cpV();
            if (localObject3 == null) {
              kotlin.g.b.p.hyc();
            }
            paramm.a(i, (CharSequence)localObject2, 2131689810, ((TmplShareWebViewToolUI)localObject3).getResources().getColor(2131099845));
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
            if ((!p.a(this.pMg, 0)) || (i != 0)) {
              continue;
            }
            i = this.pMg.pLW;
            localObject1 = this.pMg.cpV();
            if (localObject1 == null) {
              continue;
            }
            localObject1 = ((TmplShareWebViewToolUI)localObject1).getString(2131764194);
            localObject1 = (CharSequence)localObject1;
            localObject3 = this.pMg.cpV();
            if (localObject3 == null) {
              kotlin.g.b.p.hyc();
            }
            paramm.a(i, (CharSequence)localObject1, 2131689824, ((TmplShareWebViewToolUI)localObject3).getResources().getColor(2131099845));
          }
          if (p.a(this.pMg, 64))
          {
            i = this.pMg.pLV;
            localObject1 = this.pMg.cpV();
            if (localObject1 == null) {
              continue;
            }
            localObject1 = ((TmplShareWebViewToolUI)localObject1).getString(2131763947);
            paramm.a(i, (CharSequence)localObject1, 2131689821, 0, p.b(this.pMg, 64));
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class e
    implements o.f
  {
    e(p paramp, boolean paramBoolean) {}
    
    public final void onCreateMMMenu(m paramm)
    {
      AppMethodBeat.i(7348);
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(480L, 0L, 1L, false);
      paramm.clear();
      if (this.pMg.cpV() == null)
      {
        AppMethodBeat.o(7348);
        return;
      }
      int i;
      if (!paramBoolean)
      {
        localObject1 = this.pMg.cpV();
        if (localObject1 == null) {
          kotlin.g.b.p.hyc();
        }
        if (((TmplShareWebViewToolUI)localObject1).gff() != null)
        {
          localObject1 = this.pMg.cpV();
          if (localObject1 == null) {
            kotlin.g.b.p.hyc();
          }
          if (((TmplShareWebViewToolUI)localObject1).gff().bPq())
          {
            i = this.pMg.pMb;
            localObject1 = this.pMg.cpV();
            if (localObject1 == null) {
              break label380;
            }
            localObject1 = ((TmplShareWebViewToolUI)localObject1).getString(2131764199);
            paramm.b(i, (CharSequence)localObject1, 2131690846);
          }
        }
      }
      Object localObject1 = this.pMg.cpV();
      label149:
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((TmplShareWebViewToolUI)localObject1).fZM();
        localObject2 = this.pMg.cpV();
        if (localObject2 == null) {
          break label390;
        }
        localObject2 = ((TmplShareWebViewToolUI)localObject2).ILE;
        label170:
        if (localObject2 == null) {
          break label396;
        }
        localObject1 = com.tencent.mm.plugin.webview.ui.tools.o.baw((String)localObject1);
        label180:
        if ((localObject1 != null) && (((o.a)localObject1).isDataValid())) {
          break label401;
        }
        i = 1;
        label193:
        if ((p.a(this.pMg, 1)) && (i != 0))
        {
          i = this.pMg.pLY;
          localObject1 = this.pMg.cpV();
          if (localObject1 == null) {
            break label406;
          }
          localObject1 = ((TmplShareWebViewToolUI)localObject1).getString(2131768769);
          label235:
          paramm.a(i, (CharSequence)localObject1, 2131690857, p.b(this.pMg, 1));
        }
        if (p.a(this.pMg, 0))
        {
          i = this.pMg.pMa;
          localObject1 = this.pMg.cpV();
          if (localObject1 == null) {
            break label411;
          }
          localObject1 = ((TmplShareWebViewToolUI)localObject1).getString(2131756736);
          label293:
          paramm.a(i, (CharSequence)localObject1, 2131690898, p.b(this.pMg, 0));
        }
        if (p.a(this.pMg, 32))
        {
          i = this.pMg.pLZ;
          localObject1 = this.pMg.cpV();
          if (localObject1 == null) {
            break label416;
          }
        }
      }
      label390:
      label396:
      label401:
      label406:
      label411:
      label416:
      for (localObject1 = ((TmplShareWebViewToolUI)localObject1).getString(2131768758);; localObject1 = null)
      {
        paramm.a(i, (CharSequence)localObject1, 2131690823, p.b(this.pMg, 32));
        AppMethodBeat.o(7348);
        return;
        label380:
        localObject1 = null;
        break;
        localObject1 = null;
        break label149;
        localObject2 = null;
        break label170;
        localObject1 = null;
        break label180;
        i = 0;
        break label193;
        localObject1 = null;
        break label235;
        localObject1 = null;
        break label293;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(p paramp, o.a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(175545);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/video/util/MpMenuHelper$showMenu$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = this.pMg.cpV();
      if (paramView != null)
      {
        paramView = paramView.IMs;
        if (paramView != null)
        {
          localObject = paramView.gdh();
          if (localObject != null)
          {
            paramView = this.pMg.nhy;
            if (paramView == null) {
              kotlin.g.b.p.btv("ui");
            }
            paramView = (TmplShareWebViewToolUI)paramView.get();
            if (paramView == null) {
              break label225;
            }
          }
        }
      }
      label225:
      for (paramView = paramView.coX();; paramView = null)
      {
        ((az.d)localObject).C(new Object[] { paramView, Integer.valueOf(38), Integer.valueOf(1) }).report();
        paramView = this.pMg.cpV();
        if (paramView != null)
        {
          paramView = paramView.Jjm;
          if (paramView != null) {
            paramView.gx("Contact_Scene", 173);
          }
        }
        paramView = this.pMg.cpV();
        if (paramView != null) {
          paramView.bas(this.pMj.brandUsername);
        }
        if (this.pMg.nVN != null)
        {
          paramView = this.pMg.nVN;
          if (paramView != null) {
            paramView.bMo();
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/video/util/MpMenuHelper$showMenu$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(175545);
        return;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class g
    implements o.g
  {
    g(p paramp) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(7350);
      this.pMg.pMe = false;
      Object localObject1 = this.pMg.cpV();
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
          localObject2 = this.pMg.cpV();
          if (localObject2 == null) {
            break label291;
          }
          localObject2 = ((TmplShareWebViewToolUI)localObject2).getIntent();
          if (localObject2 == null) {
            break label291;
          }
          localObject2 = ((Intent)localObject2).getStringExtra("KAppId");
          localObject3 = this.pMg.cpV();
          if (localObject3 == null) {
            break label297;
          }
          localObject3 = ((TmplShareWebViewToolUI)localObject3).getIntent();
          if (localObject3 == null) {
            break label297;
          }
          localObject3 = ((Intent)localObject3).getStringExtra("srcUsername");
          kotlin.g.b.p.g(paramMenuItem, "menuItem");
          paramInt = paramMenuItem.getItemId();
          if (paramInt != this.pMg.pLT) {
            break label315;
          }
          paramMenuItem = g.pKI;
          paramMenuItem = this.pMg.cpV();
          if (paramMenuItem == null) {
            kotlin.g.b.p.hyc();
          }
          g.a((Context)paramMenuItem, p.a(this.pMg), p.b(this.pMg));
          paramMenuItem = this.pMg.cpV();
          if (paramMenuItem == null) {
            break label308;
          }
          paramMenuItem = paramMenuItem.IMs;
          if (paramMenuItem == null) {
            break label308;
          }
          localObject4 = paramMenuItem.gdh();
          if (localObject4 == null) {
            break label308;
          }
          paramMenuItem = this.pMg.cpV();
          if (paramMenuItem == null) {
            break label303;
          }
        }
      }
      label291:
      label297:
      label303:
      for (paramMenuItem = paramMenuItem.coX();; paramMenuItem = null)
      {
        ((az.d)localObject4).C(new Object[] { paramMenuItem, Integer.valueOf(1), Integer.valueOf(1), localObject1, localObject2, localObject3 }).report();
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
      if (paramInt == this.pMg.pLU)
      {
        localObject4 = this.pMg;
        Log.i(((p)localObject4).TAG, "doTimeline");
        paramMenuItem = ((p)localObject4).nhy;
        if (paramMenuItem == null) {
          kotlin.g.b.p.btv("ui");
        }
        if (paramMenuItem.get() != null)
        {
          paramMenuItem = ((p)localObject4).nhy;
          if (paramMenuItem == null) {
            kotlin.g.b.p.btv("ui");
          }
          paramMenuItem = (TmplShareWebViewToolUI)paramMenuItem.get();
          if (paramMenuItem != null)
          {
            paramMenuItem = Boolean.valueOf(paramMenuItem.isFinishing());
            if (paramMenuItem == null) {
              kotlin.g.b.p.hyc();
            }
            if (!paramMenuItem.booleanValue()) {
              break label530;
            }
          }
        }
        else
        {
          Log.i(((p)localObject4).TAG, "activity finished");
          paramMenuItem = this.pMg.cpV();
          if (paramMenuItem == null) {
            break label1344;
          }
          paramMenuItem = paramMenuItem.IMs;
          if (paramMenuItem == null) {
            break label1344;
          }
          localObject4 = paramMenuItem.gdh();
          if (localObject4 == null) {
            break label1344;
          }
          paramMenuItem = this.pMg.cpV();
          if (paramMenuItem == null) {
            break label1339;
          }
        }
        for (paramMenuItem = paramMenuItem.coX();; paramMenuItem = null)
        {
          ((az.d)localObject4).C(new Object[] { paramMenuItem, Integer.valueOf(2), Integer.valueOf(1), localObject1, localObject2, localObject3 }).report();
          AppMethodBeat.o(7350);
          return;
          paramMenuItem = null;
          break;
          Intent localIntent = new Intent();
          paramMenuItem = ((p)localObject4).pHv;
          if (paramMenuItem == null) {
            kotlin.g.b.p.btv("msgInfo");
          }
          int i = paramMenuItem.iAi.videoWidth;
          paramInt = i;
          if (i <= 0) {
            paramInt = 150;
          }
          localIntent.putExtra("Ksnsupload_width", paramInt);
          localIntent.putExtra("Ksnsupload_height", paramInt);
          paramMenuItem = ((p)localObject4).pIL;
          if (paramMenuItem == null) {
            kotlin.g.b.p.btv("controller");
          }
          Object localObject5;
          if (paramMenuItem.cpW())
          {
            paramMenuItem = ((p)localObject4).pIL;
            if (paramMenuItem == null) {
              kotlin.g.b.p.btv("controller");
            }
            paramMenuItem = paramMenuItem.pHB;
            if (paramMenuItem != null)
            {
              paramMenuItem = paramMenuItem.title;
              localIntent.putExtra("Ksnsupload_title", paramMenuItem);
              paramMenuItem = ((p)localObject4).pIL;
              if (paramMenuItem == null) {
                kotlin.g.b.p.btv("controller");
              }
              paramMenuItem = paramMenuItem.pHB;
              if (paramMenuItem == null) {
                break label1164;
              }
              paramMenuItem = paramMenuItem.iAo;
              localIntent.putExtra("Ksnsupload_imgurl", paramMenuItem);
              paramMenuItem = ((p)localObject4).pIL;
              if (paramMenuItem == null) {
                kotlin.g.b.p.btv("controller");
              }
              localIntent.putExtra("Ksnsupload_link", paramMenuItem.url);
              paramMenuItem = ((p)localObject4).pHv;
              if (paramMenuItem == null) {
                kotlin.g.b.p.btv("msgInfo");
              }
              paramMenuItem = paramMenuItem.iAh;
              localObject5 = ((p)localObject4).pHv;
              if (localObject5 == null) {
                kotlin.g.b.p.btv("msgInfo");
              }
              if (Util.isNullOrNil(((x)localObject5).dHc)) {
                break label1232;
              }
              localObject5 = ((p)localObject4).pHv;
              if (localObject5 == null) {
                kotlin.g.b.p.btv("msgInfo");
              }
              localIntent.putExtra("src_username", ((x)localObject5).dHc);
              localObject5 = ((p)localObject4).pHv;
              if (localObject5 == null) {
                kotlin.g.b.p.btv("msgInfo");
              }
              localIntent.putExtra("src_displayname", ((x)localObject5).iAg);
              localIntent.putExtra("Ksnsupload_type", 1);
              localObject5 = ((p)localObject4).pIL;
              if (localObject5 == null) {
                kotlin.g.b.p.btv("controller");
              }
              localIntent.putExtra("ShareUrlOriginal", ((com.tencent.mm.plugin.brandservice.ui.timeline.video.b)localObject5).url);
              localIntent.putExtra("KPublisherId", paramMenuItem);
              localIntent.putExtra("need_result", true);
              localObject5 = ((p)localObject4).pIL;
              if (localObject5 == null) {
                kotlin.g.b.p.btv("controller");
              }
              if (!((com.tencent.mm.plugin.brandservice.ui.timeline.video.b)localObject5).cpW()) {
                break label1297;
              }
              localObject5 = ((p)localObject4).pIL;
              if (localObject5 == null) {
                kotlin.g.b.p.btv("controller");
              }
              if (((com.tencent.mm.plugin.brandservice.ui.timeline.video.b)localObject5).pHB != null)
              {
                localObject5 = ((p)localObject4).pIL;
                if (localObject5 == null) {
                  kotlin.g.b.p.btv("controller");
                }
                localObject5 = ((com.tencent.mm.plugin.brandservice.ui.timeline.video.b)localObject5).pHB;
                if (localObject5 == null) {
                  kotlin.g.b.p.hyc();
                }
                if (((cmb)localObject5).iAq != null)
                {
                  localObject5 = ((p)localObject4).pIL;
                  if (localObject5 == null) {
                    kotlin.g.b.p.btv("controller");
                  }
                  localObject5 = ((com.tencent.mm.plugin.brandservice.ui.timeline.video.b)localObject5).pHB;
                  if (localObject5 == null) {
                    kotlin.g.b.p.hyc();
                  }
                  localIntent.putExtra("ksnsupload_link_desc", ((cmb)localObject5).iAq);
                }
              }
            }
          }
          for (;;)
          {
            paramMenuItem = ad.JX(paramMenuItem);
            localIntent.putExtra("reportSessionId", paramMenuItem);
            localObject5 = ((p)localObject4).nhy;
            if (localObject5 == null) {
              kotlin.g.b.p.btv("ui");
            }
            localObject5 = ((WeakReference)localObject5).get();
            if (localObject5 == null) {
              kotlin.g.b.p.hyc();
            }
            localIntent.putExtra("BizVideoDetailUIExtras", ((TmplShareWebViewToolUI)localObject5).getIntent().getExtras());
            localObject5 = f.pKH;
            localObject5 = ((p)localObject4).pHv;
            if (localObject5 == null) {
              kotlin.g.b.p.btv("msgInfo");
            }
            com.tencent.mm.plugin.brandservice.ui.timeline.video.b localb = ((p)localObject4).pIL;
            if (localb == null) {
              kotlin.g.b.p.btv("controller");
            }
            kotlin.g.b.p.g(paramMenuItem, "sessionId");
            f.a((x)localObject5, localb, paramMenuItem, (com.tencent.mm.ipcinvoker.d)new p.b((p)localObject4, localIntent));
            break;
            paramMenuItem = null;
            break label641;
            paramMenuItem = null;
            break label679;
            paramMenuItem = ((p)localObject4).pHv;
            if (paramMenuItem == null) {
              kotlin.g.b.p.btv("msgInfo");
            }
            localIntent.putExtra("Ksnsupload_title", paramMenuItem.iAi.title);
            paramMenuItem = ((p)localObject4).pHv;
            if (paramMenuItem == null) {
              kotlin.g.b.p.btv("msgInfo");
            }
            localIntent.putExtra("Ksnsupload_imgurl", paramMenuItem.iAi.iAo);
            break label688;
            label1232:
            localObject5 = ((p)localObject4).pHv;
            if (localObject5 == null) {
              kotlin.g.b.p.btv("msgInfo");
            }
            localIntent.putExtra("src_username", ((x)localObject5).ajO());
            localObject5 = ((p)localObject4).pHv;
            if (localObject5 == null) {
              kotlin.g.b.p.btv("msgInfo");
            }
            localIntent.putExtra("src_displayname", ((x)localObject5).iAg);
            break label825;
            localObject5 = ((p)localObject4).pHv;
            if (localObject5 == null) {
              kotlin.g.b.p.btv("msgInfo");
            }
            kotlin.g.b.p.g(localIntent.putExtra("ksnsupload_link_desc", ((x)localObject5).iAi.iAq), "intent.putExtra(Constant…esc, msgInfo.item.digest)");
          }
        }
        label1344:
        AppMethodBeat.o(7350);
        return;
      }
      label530:
      label679:
      label688:
      label825:
      label1339:
      if (paramInt == this.pMg.pLV)
      {
        paramMenuItem = this.pMg.cpV();
        if (paramMenuItem != null)
        {
          paramMenuItem = paramMenuItem.IMs;
          if (paramMenuItem != null)
          {
            localObject1 = paramMenuItem.gdh();
            if (localObject1 != null)
            {
              paramMenuItem = this.pMg.cpV();
              if (paramMenuItem == null) {
                break label1558;
              }
              paramMenuItem = paramMenuItem.coX();
              ((az.d)localObject1).C(new Object[] { paramMenuItem, Integer.valueOf(3), Integer.valueOf(1) }).report();
            }
          }
        }
        localObject1 = this.pMg;
        paramMenuItem = e.pKG;
        paramMenuItem = ((p)localObject1).pHv;
        if (paramMenuItem == null) {
          kotlin.g.b.p.btv("msgInfo");
        }
        localObject2 = ((p)localObject1).pIL;
        if (localObject2 == null) {
          kotlin.g.b.p.btv("controller");
        }
        e.a(paramMenuItem, (com.tencent.mm.plugin.brandservice.ui.timeline.video.b)localObject2);
        localObject2 = (Context)((p)localObject1).cpV();
        paramMenuItem = ((p)localObject1).cpV();
        if (paramMenuItem != null) {}
        for (paramMenuItem = paramMenuItem.getString(2131759260);; paramMenuItem = null)
        {
          com.tencent.mm.ui.base.h.cA((Context)localObject2, paramMenuItem);
          paramMenuItem = ((p)localObject1).pIL;
          if (paramMenuItem == null) {
            kotlin.g.b.p.btv("controller");
          }
          paramMenuItem.pHq.aL(24, "");
          AppMethodBeat.o(7350);
          return;
          paramMenuItem = null;
          break;
        }
      }
      label641:
      label1164:
      label1297:
      label1558:
      if (paramInt == this.pMg.pLY)
      {
        paramMenuItem = this.pMg.cpV();
        if (paramMenuItem != null)
        {
          paramMenuItem = paramMenuItem.IMs;
          if (paramMenuItem != null)
          {
            localObject1 = paramMenuItem.gdh();
            if (localObject1 != null)
            {
              paramMenuItem = this.pMg.cpV();
              if (paramMenuItem == null) {
                break label1747;
              }
            }
          }
        }
        label1747:
        for (paramMenuItem = paramMenuItem.coX();; paramMenuItem = null)
        {
          ((az.d)localObject1).C(new Object[] { paramMenuItem, Integer.valueOf(4), Integer.valueOf(1) }).report();
          localObject1 = this.pMg;
          paramMenuItem = ((p)localObject1).pIL;
          if (paramMenuItem == null) {
            kotlin.g.b.p.btv("controller");
          }
          if ((paramMenuItem.iwg & 0x1) == 0) {
            break;
          }
          paramMenuItem = ((p)localObject1).TAG;
          localObject2 = new StringBuilder("not allow jump to profile ");
          localObject1 = ((p)localObject1).pIL;
          if (localObject1 == null) {
            kotlin.g.b.p.btv("controller");
          }
          Log.w(paramMenuItem, ((com.tencent.mm.plugin.brandservice.ui.timeline.video.b)localObject1).iwg);
          AppMethodBeat.o(7350);
          return;
        }
        if (((p)localObject1).cpV() != null)
        {
          paramMenuItem = ((p)localObject1).cpV();
          if (paramMenuItem == null) {
            break label1786;
          }
        }
        label1786:
        for (paramMenuItem = paramMenuItem.Jjm; paramMenuItem == null; paramMenuItem = null)
        {
          AppMethodBeat.o(7350);
          return;
        }
        paramMenuItem = ((p)localObject1).cpV();
        if (paramMenuItem != null)
        {
          paramMenuItem = paramMenuItem.Jjm;
          if (paramMenuItem != null) {
            paramMenuItem.gx("Contact_Scene", 153);
          }
        }
        paramMenuItem = ((p)localObject1).cpV();
        if (paramMenuItem != null)
        {
          localObject1 = ((p)localObject1).pIL;
          if (localObject1 == null) {
            kotlin.g.b.p.btv("controller");
          }
          paramMenuItem.bas(((com.tencent.mm.plugin.brandservice.ui.timeline.video.b)localObject1).ajO());
          AppMethodBeat.o(7350);
          return;
        }
        AppMethodBeat.o(7350);
        return;
      }
      if (paramInt == this.pMg.pLW)
      {
        paramMenuItem = this.pMg.cpV();
        if (paramMenuItem != null)
        {
          paramMenuItem = paramMenuItem.IMs;
          if (paramMenuItem != null)
          {
            localObject1 = paramMenuItem.gdh();
            if (localObject1 != null)
            {
              paramMenuItem = this.pMg.cpV();
              if (paramMenuItem == null) {
                break label2005;
              }
            }
          }
        }
        label2005:
        for (paramMenuItem = paramMenuItem.coX();; paramMenuItem = null)
        {
          ((az.d)localObject1).C(new Object[] { paramMenuItem, Integer.valueOf(36), Integer.valueOf(1) }).report();
          com.tencent.mm.plugin.webview.k.g.a((Context)this.pMg.cpV(), p.a(this.pMg).iAi.title, (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(7349);
              if (paramAnonymousDialogInterface == null) {}
              for (paramAnonymousDialogInterface = "";; paramAnonymousDialogInterface = ((com.tencent.mm.ui.widget.a.d)paramAnonymousDialogInterface).hbk())
              {
                Object localObject = this.pMk.pMg.cpV();
                if (localObject == null) {
                  break;
                }
                localObject = ((TmplShareWebViewToolUI)localObject).IBw;
                if (localObject == null) {
                  break;
                }
                ((com.tencent.mm.plugin.webview.d.h)localObject).w(1, paramAnonymousDialogInterface, 0);
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
      if (paramInt == this.pMg.pLX)
      {
        paramMenuItem = this.pMg.cpV();
        if (paramMenuItem != null)
        {
          paramMenuItem = paramMenuItem.IMs;
          if (paramMenuItem != null)
          {
            localObject1 = paramMenuItem.gdh();
            if (localObject1 != null)
            {
              paramMenuItem = this.pMg.cpV();
              if (paramMenuItem == null) {
                break label2138;
              }
            }
          }
        }
        label2138:
        for (paramMenuItem = paramMenuItem.coX();; paramMenuItem = null)
        {
          ((az.d)localObject1).C(new Object[] { paramMenuItem, Integer.valueOf(37), Integer.valueOf(1) }).report();
          paramMenuItem = this.pMg.cpV();
          if (paramMenuItem == null) {
            break;
          }
          paramMenuItem = paramMenuItem.IBw;
          if (paramMenuItem == null) {
            break;
          }
          paramMenuItem.w(0, "", 0);
          AppMethodBeat.o(7350);
          return;
        }
        AppMethodBeat.o(7350);
        return;
      }
      if (paramInt == this.pMg.pLZ)
      {
        paramMenuItem = this.pMg.cpV();
        if (paramMenuItem != null)
        {
          paramMenuItem = paramMenuItem.IMs;
          if (paramMenuItem != null)
          {
            localObject1 = paramMenuItem.gdh();
            if (localObject1 != null)
            {
              paramMenuItem = this.pMg.cpV();
              if (paramMenuItem == null) {
                break label2269;
              }
            }
          }
        }
        label2269:
        for (paramMenuItem = paramMenuItem.coX();; paramMenuItem = null)
        {
          ((az.d)localObject1).C(new Object[] { paramMenuItem, Integer.valueOf(5), Integer.valueOf(1) }).report();
          paramMenuItem = this.pMg;
          if (!paramMenuItem.isFinished()) {
            break;
          }
          Log.e(paramMenuItem.TAG, "copyLink fail, is finish");
          AppMethodBeat.o(7350);
          return;
        }
        localObject1 = (Context)paramMenuItem.cpV();
        localObject2 = paramMenuItem.pIL;
        if (localObject2 == null) {
          kotlin.g.b.p.btv("controller");
        }
        ClipboardHelper.setText((Context)localObject1, (CharSequence)((com.tencent.mm.plugin.brandservice.ui.timeline.video.b)localObject2).pHp);
        localObject1 = (Context)paramMenuItem.cpV();
        paramMenuItem = paramMenuItem.cpV();
        if (paramMenuItem != null) {}
        for (paramMenuItem = paramMenuItem.getString(2131768759);; paramMenuItem = null)
        {
          Toast.makeText((Context)localObject1, (CharSequence)paramMenuItem, 0).show();
          AppMethodBeat.o(7350);
          return;
        }
      }
      if (paramInt == this.pMg.pMa)
      {
        paramMenuItem = this.pMg.cpV();
        if (paramMenuItem != null)
        {
          paramMenuItem = paramMenuItem.IMs;
          if (paramMenuItem != null)
          {
            localObject1 = paramMenuItem.gdh();
            if (localObject1 != null)
            {
              paramMenuItem = this.pMg.cpV();
              if (paramMenuItem == null) {
                break label2832;
              }
              paramMenuItem = paramMenuItem.coX();
              ((az.d)localObject1).C(new Object[] { paramMenuItem, Integer.valueOf(11), Integer.valueOf(1) }).report();
            }
          }
        }
        localObject2 = this.pMg;
        paramMenuItem = ((p)localObject2).pHv;
        if (paramMenuItem == null) {
          kotlin.g.b.p.btv("msgInfo");
        }
        localObject3 = paramMenuItem.iAi.url;
        paramMenuItem = null;
        if (!Util.isNullOrNil((String)localObject3))
        {
          paramMenuItem = Uri.parse((String)localObject3);
          kotlin.g.b.p.g(paramMenuItem, "uri");
          paramMenuItem = paramMenuItem.getHost();
        }
        if (!Util.isNullOrNil(paramMenuItem))
        {
          if (paramMenuItem == null) {
            kotlin.g.b.p.hyc();
          }
          localObject1 = WeChatHosts.domainString(2131761726);
          kotlin.g.b.p.g(localObject1, "domainString(R.string.host_mp_weixin_qq_com)");
          if (!kotlin.n.n.J(paramMenuItem, (String)localObject1, false)) {}
        }
      }
      label2832:
      label2855:
      label2861:
      label3165:
      for (;;)
      {
        try
        {
          paramMenuItem = ae.SYK;
          paramMenuItem = e.e.OyV;
          kotlin.g.b.p.g(paramMenuItem, "ConstantsUI.ExposeUI.KExposeMPUrl");
          paramMenuItem = String.format(paramMenuItem, Arrays.copyOf(new Object[] { q.encode((String)localObject3, "utf-8") }, 1));
          kotlin.g.b.p.g(paramMenuItem, "java.lang.String.format(format, *args)");
          if (!Util.isNullOrNil(paramMenuItem)) {
            break label3165;
          }
          paramMenuItem = ae.SYK;
          paramMenuItem = e.e.OyU;
          kotlin.g.b.p.g(paramMenuItem, "ConstantsUI.ExposeUI.KExposeH5Url");
          paramMenuItem = String.format(paramMenuItem, Arrays.copyOf(new Object[] { Integer.valueOf(34) }, 1));
          kotlin.g.b.p.g(paramMenuItem, "java.lang.String.format(format, *args)");
          localObject4 = new Intent();
        }
        catch (UnsupportedEncodingException paramMenuItem)
        {
          Log.e(((p)localObject2).TAG, paramMenuItem.getMessage());
        }
        try
        {
          localObject1 = ((p)localObject2).cpV();
          if (localObject1 == null) {
            break label2855;
          }
          localObject1 = ((TmplShareWebViewToolUI)localObject1).getDir("expose", 0);
          if (localObject1 != null) {
            ((File)localObject1).mkdirs();
          }
          if (localObject1 == null) {
            break label2861;
          }
          localObject1 = ((File)localObject1).getAbsolutePath();
          localObject1 = kotlin.g.b.p.I((String)localObject1, "/screenshot.jpg");
          BitmapUtil.saveBitmapToImage(ScreenShotUtil.takeScreenShot((Activity)((p)localObject2).cpV()), 75, Bitmap.CompressFormat.JPEG, (String)localObject1, true);
          ((Intent)localObject4).putExtra("k_webview_img", (String)localObject1);
        }
        catch (IOException localIOException)
        {
          Log.e(((p)localObject2).TAG, "[oneliang]save screen shot to file error, ex = " + localIOException.getMessage());
          continue;
        }
        ((Intent)localObject4).putExtra("rawUrl", paramMenuItem);
        ((Intent)localObject4).putExtra("k_expose_url", (String)localObject3);
        paramMenuItem = ((p)localObject2).pIL;
        if (paramMenuItem == null) {
          kotlin.g.b.p.btv("controller");
        }
        ((Intent)localObject4).putExtra("k_expose_web_scene", paramMenuItem.scene);
        ((Intent)localObject4).putExtra("showShare", false);
        c.b((Context)((p)localObject2).cpV(), "webview", ".ui.tools.WebViewUI", (Intent)localObject4);
        AppMethodBeat.o(7350);
        return;
        paramMenuItem = null;
        break;
        paramMenuItem = null;
        continue;
        localObject1 = null;
        continue;
        localObject1 = null;
        continue;
        TmplShareWebViewToolUI localTmplShareWebViewToolUI;
        if (paramInt == this.pMg.pMb)
        {
          paramMenuItem = this.pMg.cpV();
          if (paramMenuItem == null) {
            kotlin.g.b.p.hyc();
          }
          paramMenuItem = paramMenuItem.IMs;
          if (paramMenuItem == null) {
            kotlin.g.b.p.hyc();
          }
          paramMenuItem = paramMenuItem.gdh();
          localTmplShareWebViewToolUI = this.pMg.cpV();
          if (localTmplShareWebViewToolUI == null) {
            kotlin.g.b.p.hyc();
          }
          paramMenuItem.C(new Object[] { localTmplShareWebViewToolUI.coX(), Integer.valueOf(33), Integer.valueOf(1) }).report();
          paramMenuItem = this.pMg.cpV();
          if (paramMenuItem == null) {
            kotlin.g.b.p.hyc();
          }
          paramMenuItem.gff().ic(true);
          AppMethodBeat.o(7350);
          return;
        }
        if (paramInt == this.pMg.pMc)
        {
          paramMenuItem = this.pMg.cpV();
          if (paramMenuItem == null) {
            kotlin.g.b.p.hyc();
          }
          paramMenuItem = paramMenuItem.IMs;
          if (paramMenuItem == null) {
            kotlin.g.b.p.hyc();
          }
          paramMenuItem = paramMenuItem.gdh();
          localTmplShareWebViewToolUI = this.pMg.cpV();
          if (localTmplShareWebViewToolUI == null) {
            kotlin.g.b.p.hyc();
          }
          paramMenuItem.C(new Object[] { localTmplShareWebViewToolUI.coX(), Integer.valueOf(34), Integer.valueOf(1) }).report();
          AppMethodBeat.o(7350);
          return;
        }
        Log.w(this.pMg.TAG, "wrong id: " + paramMenuItem.getItemId());
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