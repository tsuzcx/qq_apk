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
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI;
import com.tencent.mm.plugin.webview.model.ax;
import com.tencent.mm.plugin.webview.model.ax.d;
import com.tencent.mm.plugin.webview.ui.tools.i;
import com.tencent.mm.plugin.webview.ui.tools.n.a;
import com.tencent.mm.protocal.protobuf.btb;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.a.e.b;
import d.g.b.k;
import d.g.b.z;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.util.Arrays;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MpMenuHelper;", "", "()V", "MENU_ID_CANCEL_HAO_KAN", "", "MENU_ID_CANCEL_MINIMIZE", "MENU_ID_COPY_LINK", "MENU_ID_EXPOSE", "MENU_ID_FAV", "MENU_ID_HAO_KAN", "MENU_ID_MINIMIZE", "MENU_ID_SEND_TO_FRIEND", "MENU_ID_SHARE_TO_TIMELINE", "MENU_ID_SHOW_BIZ", "TAG", "", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "isBottomSheetShowing", "", "mmBottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "msgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "onlyShowShareMenu", "shareExtInfo", "getShareExtInfo", "()Ljava/lang/String;", "setShareExtInfo", "(Ljava/lang/String;)V", "ui", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI;", "getUi$plugin_brandservice_release", "()Ljava/lang/ref/WeakReference;", "setUi$plugin_brandservice_release", "(Ljava/lang/ref/WeakReference;)V", "context", "copyLink", "", "doExpose", "fav", "goProfile", "hasShowMenuPermission", "id", "bitSet", "init", "isFinished", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onDestroy", "shareToTimeline", "shouldDisableMenuItem", "showMenu", "updateMenu", "plugin-brandservice_release"})
public final class o
{
  final String TAG = "MicroMsg.MpMenuHelper";
  public WeakReference<TmplShareWebViewToolUI> lvU;
  com.tencent.mm.ui.widget.a.e mdB;
  public x nLB;
  public com.tencent.mm.plugin.brandservice.ui.timeline.video.b nMS;
  final int nPi;
  final int nPj = 1;
  final int nPk = 2;
  final int nPl = 3;
  final int nPm = 4;
  final int nPn = 5;
  final int nPo = 6;
  final int nPp = 7;
  final int nPq = 8;
  final int nPr = 9;
  public boolean nPs;
  boolean nPt;
  public String nPu = "";
  
  public final void WT()
  {
    AppMethodBeat.i(7352);
    if (this.nPt) {
      jg(this.nPs);
    }
    AppMethodBeat.o(7352);
  }
  
  public final TmplShareWebViewToolUI bMK()
  {
    AppMethodBeat.i(7355);
    Object localObject = this.lvU;
    if (localObject == null) {
      k.aVY("ui");
    }
    if (((WeakReference)localObject).get() == null)
    {
      AppMethodBeat.o(7355);
      return null;
    }
    localObject = this.lvU;
    if (localObject == null) {
      k.aVY("ui");
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
    Object localObject = this.lvU;
    if (localObject == null) {
      k.aVY("ui");
    }
    if (((WeakReference)localObject).get() != null)
    {
      localObject = this.lvU;
      if (localObject == null) {
        k.aVY("ui");
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
  
  public final void jg(final boolean paramBoolean)
  {
    AppMethodBeat.i(7353);
    this.nPs = paramBoolean;
    if (!paramBoolean) {
      this.nPu = "";
    }
    if (isFinished())
    {
      ac.i(this.TAG, "showMenu return:isFinished=%b", new Object[] { Boolean.valueOf(isFinished()) });
      AppMethodBeat.o(7353);
      return;
    }
    Object localObject2;
    n.d locald;
    if (!this.nPt)
    {
      if (paramBoolean)
      {
        localObject1 = this.nMS;
        if (localObject1 == null) {
          k.aVY("controller");
        }
        if ((((com.tencent.mm.plugin.brandservice.ui.timeline.video.b)localObject1).hhc & 0x8) != 0)
        {
          localObject1 = this.nMS;
          if (localObject1 == null) {
            k.aVY("controller");
          }
          if ((((com.tencent.mm.plugin.brandservice.ui.timeline.video.b)localObject1).hhc & 0x10) != 0)
          {
            localObject2 = (Context)bMK();
            localObject1 = bMK();
            if (localObject1 != null) {}
            for (localObject1 = ((TmplShareWebViewToolUI)localObject1).getString(2131766260);; localObject1 = null)
            {
              com.tencent.mm.ui.base.h.cd((Context)localObject2, (String)localObject1);
              AppMethodBeat.o(7353);
              return;
            }
          }
        }
        this.mdB = new com.tencent.mm.ui.widget.a.e((Context)bMK(), 1, false);
      }
    }
    else
    {
      localObject1 = this.mdB;
      if (localObject1 != null) {
        ((com.tencent.mm.ui.widget.a.e)localObject1).b((e.b)new c(this));
      }
      localObject1 = this.mdB;
      if (localObject1 != null) {
        ((com.tencent.mm.ui.widget.a.e)localObject1).a((n.c)new d(this, paramBoolean));
      }
      locald = (n.d)new g(this);
      localObject1 = this.mdB;
      if (localObject1 != null) {
        ((com.tencent.mm.ui.widget.a.e)localObject1).a(locald);
      }
      localObject1 = this.mdB;
      if (localObject1 != null) {
        ((com.tencent.mm.ui.widget.a.e)localObject1).b((n.c)new e(this, paramBoolean));
      }
      localObject1 = bMK();
      if (localObject1 == null) {
        break label570;
      }
      localObject2 = ((TmplShareWebViewToolUI)localObject1).eyJ();
      label298:
      localObject1 = bMK();
      if ((localObject1 == null) || (((TmplShareWebViewToolUI)localObject1).CAq == null)) {
        break label576;
      }
    }
    label570:
    label576:
    for (Object localObject1 = com.tencent.mm.plugin.webview.ui.tools.n.aDs((String)localObject2);; localObject1 = null)
    {
      boolean bool = ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).isMpUrl((String)localObject2);
      if ((!paramBoolean) && (bool) && (localObject1 != null) && (((n.a)localObject1).isDataValid()))
      {
        localObject2 = LayoutInflater.from((Context)bMK()).inflate(2131494913, null);
        ImageView localImageView = (ImageView)((View)localObject2).findViewById(2131301214);
        Object localObject3 = (TextView)((View)localObject2).findViewById(2131306141);
        View localView = ((View)localObject2).findViewById(2131298761);
        k.g(localObject3, "nickNameTextView");
        ((TextView)localObject3).setText((CharSequence)((n.a)localObject1).CBi);
        localObject3 = new c.a().aFQ().aFR().pe(2131231875);
        com.tencent.mm.av.a.a.aFG().a(((n.a)localObject1).CBj, localImageView, ((c.a)localObject3).aFT());
        localView.setOnClickListener((View.OnClickListener)new f(this, (n.a)localObject1));
        com.tencent.mm.ui.tools.o.gC(localView);
        localObject1 = this.mdB;
        if (localObject1 != null) {
          ((com.tencent.mm.ui.widget.a.e)localObject1).J((View)localObject2, true);
        }
      }
      localObject1 = this.mdB;
      if (localObject1 != null) {
        ((com.tencent.mm.ui.widget.a.e)localObject1).b(locald);
      }
      localObject1 = this.mdB;
      if (localObject1 != null) {
        ((com.tencent.mm.ui.widget.a.e)localObject1).cED();
      }
      this.nPt = true;
      AppMethodBeat.o(7353);
      return;
      this.mdB = new com.tencent.mm.ui.widget.a.e((Context)bMK(), 0, true);
      break;
      localObject2 = null;
      break label298;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(7356);
    if (this.mdB != null)
    {
      com.tencent.mm.ui.widget.a.e locale = this.mdB;
      if (locale == null) {
        k.fOy();
      }
      if (locale.isShowing())
      {
        locale = this.mdB;
        if (locale == null) {
          k.fOy();
        }
        locale.bmi();
      }
    }
    AppMethodBeat.o(7356);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "bundle", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "onCallback"})
  public static final class a<T>
    implements com.tencent.mm.ipcinvoker.d<Bundle>
  {
    public a(o paramo) {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "bundle", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class b<T>
    implements com.tencent.mm.ipcinvoker.d<Bundle>
  {
    b(o paramo, Intent paramIntent) {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "onDismiss"})
  static final class c
    implements e.b
  {
    c(o paramo) {}
    
    public final void onDismiss()
    {
      this.nPv.nPt = false;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class d
    implements n.c
  {
    d(o paramo, boolean paramBoolean) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      AppMethodBeat.i(7347);
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(480L, 0L, 1L, false);
      paraml.clear();
      if (this.nPv.bMK() == null)
      {
        AppMethodBeat.o(7347);
        return;
      }
      if ((paramBoolean) && (o.a(this.nPv, 16)))
      {
        i = this.nPv.nPj;
        localObject1 = this.nPv.bMK();
        if (localObject1 != null)
        {
          localObject1 = ((TmplShareWebViewToolUI)localObject1).getString(2131762164);
          paraml.a(i, (CharSequence)localObject1, 2131689817, 0, o.b(this.nPv, 16));
        }
      }
      else
      {
        if (o.a(this.nPv, 8))
        {
          i = this.nPv.nPi;
          localObject1 = this.nPv.bMK();
          if (localObject1 == null) {
            break label301;
          }
          localObject1 = ((TmplShareWebViewToolUI)localObject1).getString(2131762163);
          label155:
          localObject1 = (CharSequence)localObject1;
          localObject3 = this.nPv.bMK();
          if (localObject3 == null) {
            k.fOy();
          }
          paraml.a(i, (CharSequence)localObject1, 2131690478, ((TmplShareWebViewToolUI)localObject3).getResources().getColor(2131099699), o.b(this.nPv, 8));
        }
        if ((!paramBoolean) && (o.a(this.nPv, 16)))
        {
          i = this.nPv.nPj;
          localObject1 = this.nPv.bMK();
          if (localObject1 == null) {
            break label307;
          }
        }
      }
      label301:
      label307:
      for (Object localObject1 = ((TmplShareWebViewToolUI)localObject1).getString(2131762164);; localObject1 = null)
      {
        paraml.a(i, (CharSequence)localObject1, 2131689817, 0, o.b(this.nPv, 16));
        if (!paramBoolean) {
          break label313;
        }
        AppMethodBeat.o(7347);
        return;
        localObject1 = null;
        break;
        localObject1 = null;
        break label155;
      }
      for (;;)
      {
        try
        {
          label313:
          localObject3 = new Bundle();
          localObject1 = this.nPv.bMK();
          if (localObject1 != null)
          {
            i = localObject1.hashCode();
            ((Bundle)localObject3).putInt("WebViewShare_BinderID", i);
            localObject1 = this.nPv.bMK();
            if (localObject1 == null) {
              continue;
            }
            localObject1 = ((TmplShareWebViewToolUI)localObject1).eEt();
            if (localObject1 == null) {
              continue;
            }
            localObject1 = ((MMWebView)localObject1).getUrl();
            ((Bundle)localObject3).putString("WebViewShare_wv_url", (String)localObject1);
            localObject1 = this.nPv.bMK();
            if (localObject1 == null) {
              continue;
            }
            localObject1 = ((TmplShareWebViewToolUI)localObject1).kYt;
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
          ac.e(this.nPv.TAG, "isSetHaoKan, e = " + localRemoteException1.getMessage());
          i = -1;
          continue;
          Object localObject2 = null;
          continue;
          if ((!o.a(this.nPv, 0)) || (i != 1)) {
            continue;
          }
          i = this.nPv.nPm;
          localObject2 = this.nPv.bMK();
          if (localObject2 != null)
          {
            localObject2 = ((TmplShareWebViewToolUI)localObject2).getString(2131762165);
            localObject2 = (CharSequence)localObject2;
            localObject3 = this.nPv.bMK();
            if (localObject3 == null) {
              k.fOy();
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
            if ((!o.a(this.nPv, 0)) || (i != 0)) {
              continue;
            }
            i = this.nPv.nPl;
            localObject1 = this.nPv.bMK();
            if (localObject1 == null) {
              continue;
            }
            localObject1 = ((TmplShareWebViewToolUI)localObject1).getString(2131762173);
            localObject1 = (CharSequence)localObject1;
            localObject3 = this.nPv.bMK();
            if (localObject3 == null) {
              k.fOy();
            }
            paraml.a(i, (CharSequence)localObject1, 2131689811, ((TmplShareWebViewToolUI)localObject3).getResources().getColor(2131099829));
          }
          if (o.a(this.nPv, 64))
          {
            i = this.nPv.nPk;
            localObject1 = this.nPv.bMK();
            if (localObject1 == null) {
              continue;
            }
            localObject1 = ((TmplShareWebViewToolUI)localObject1).getString(2131761941);
            paraml.a(i, (CharSequence)localObject1, 2131689808, 0, o.b(this.nPv, 64));
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
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class e
    implements n.c
  {
    e(o paramo, boolean paramBoolean) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      AppMethodBeat.i(7348);
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(480L, 0L, 1L, false);
      paraml.clear();
      if (this.nPv.bMK() == null)
      {
        AppMethodBeat.o(7348);
        return;
      }
      int i;
      if (!paramBoolean)
      {
        localObject1 = this.nPv.bMK();
        if (localObject1 == null) {
          k.fOy();
        }
        if (((TmplShareWebViewToolUI)localObject1).eDE() != null)
        {
          localObject1 = this.nPv.bMK();
          if (localObject1 == null) {
            k.fOy();
          }
          localObject1 = ((TmplShareWebViewToolUI)localObject1).eDE();
          k.g(localObject1, "context()!!.webViewFloatBallHelper");
          if (((com.tencent.mm.plugin.webview.ui.tools.b.a)localObject1).bcW())
          {
            localObject1 = this.nPv.bMK();
            if (localObject1 == null) {
              k.fOy();
            }
            if (((TmplShareWebViewToolUI)localObject1).eDE().bGo()) {
              break label418;
            }
            i = this.nPv.nPq;
            localObject1 = this.nPv.bMK();
            if (localObject1 == null) {
              break label413;
            }
            localObject1 = ((TmplShareWebViewToolUI)localObject1).getString(2131762178);
            paraml.a(i, (CharSequence)localObject1, 2131690574);
          }
        }
      }
      label165:
      Object localObject1 = this.nPv.bMK();
      label182:
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((TmplShareWebViewToolUI)localObject1).eyJ();
        localObject2 = this.nPv.bMK();
        if (localObject2 == null) {
          break label495;
        }
        localObject2 = ((TmplShareWebViewToolUI)localObject2).CAq;
        label203:
        if (localObject2 == null) {
          break label501;
        }
        localObject1 = com.tencent.mm.plugin.webview.ui.tools.n.aDs((String)localObject1);
        label213:
        if ((localObject1 != null) && (((n.a)localObject1).isDataValid())) {
          break label506;
        }
        i = 1;
        label226:
        if ((o.a(this.nPv, 1)) && (i != 0))
        {
          i = this.nPv.nPn;
          localObject1 = this.nPv.bMK();
          if (localObject1 == null) {
            break label511;
          }
          localObject1 = ((TmplShareWebViewToolUI)localObject1).getString(2131766258);
          paraml.a(i, (CharSequence)localObject1, 2131690612, o.b(this.nPv, 1));
        }
        label268:
        if (o.a(this.nPv, 0))
        {
          i = this.nPv.nPp;
          localObject1 = this.nPv.bMK();
          if (localObject1 == null) {
            break label516;
          }
          localObject1 = ((TmplShareWebViewToolUI)localObject1).getString(2131756596);
          label326:
          paraml.a(i, (CharSequence)localObject1, 2131690646, o.b(this.nPv, 0));
        }
        if (o.a(this.nPv, 32))
        {
          i = this.nPv.nPo;
          localObject1 = this.nPv.bMK();
          if (localObject1 == null) {
            break label521;
          }
        }
      }
      label516:
      label521:
      for (localObject1 = ((TmplShareWebViewToolUI)localObject1).getString(2131766247);; localObject1 = null)
      {
        paraml.a(i, (CharSequence)localObject1, 2131690588, o.b(this.nPv, 32));
        AppMethodBeat.o(7348);
        return;
        label413:
        localObject1 = null;
        break;
        label418:
        localObject1 = this.nPv.bMK();
        if (localObject1 == null) {
          k.fOy();
        }
        if (!((TmplShareWebViewToolUI)localObject1).eDE().bGo()) {
          break label165;
        }
        i = this.nPv.nPr;
        localObject1 = this.nPv.bMK();
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
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(o paramo, n.a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(175545);
      paramView = this.nPv.bMK();
      ax.d locald;
      if (paramView != null)
      {
        paramView = paramView.Cfc;
        if (paramView != null)
        {
          locald = paramView.eBM();
          if (locald != null)
          {
            paramView = this.nPv.lvU;
            if (paramView == null) {
              k.aVY("ui");
            }
            paramView = (TmplShareWebViewToolUI)paramView.get();
            if (paramView == null) {
              break label184;
            }
          }
        }
      }
      label184:
      for (paramView = paramView.bLL();; paramView = null)
      {
        locald.B(new Object[] { paramView, Integer.valueOf(38), Integer.valueOf(1) }).report();
        paramView = this.nPv.bMK();
        if (paramView != null)
        {
          paramView = paramView.CAj;
          if (paramView != null) {
            paramView.fs("Contact_Scene", 173);
          }
        }
        paramView = this.nPv.bMK();
        if (paramView != null) {
          paramView.aDq(this.nPy.hyx);
        }
        if (this.nPv.mdB == null) {
          break;
        }
        paramView = this.nPv.mdB;
        if (paramView == null) {
          break;
        }
        paramView.bmi();
        AppMethodBeat.o(175545);
        return;
      }
      AppMethodBeat.o(175545);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class g
    implements n.d
  {
    g(o paramo) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(7350);
      this.nPv.nPt = false;
      Object localObject1 = this.nPv.bMK();
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
          localObject2 = this.nPv.bMK();
          if (localObject2 == null) {
            break label291;
          }
          localObject2 = ((TmplShareWebViewToolUI)localObject2).getIntent();
          if (localObject2 == null) {
            break label291;
          }
          localObject2 = ((Intent)localObject2).getStringExtra("KAppId");
          localObject3 = this.nPv.bMK();
          if (localObject3 == null) {
            break label297;
          }
          localObject3 = ((TmplShareWebViewToolUI)localObject3).getIntent();
          if (localObject3 == null) {
            break label297;
          }
          localObject3 = ((Intent)localObject3).getStringExtra("srcUsername");
          k.g(paramMenuItem, "menuItem");
          paramInt = paramMenuItem.getItemId();
          if (paramInt != this.nPv.nPi) {
            break label315;
          }
          paramMenuItem = g.nOc;
          paramMenuItem = this.nPv.bMK();
          if (paramMenuItem == null) {
            k.fOy();
          }
          g.a((Context)paramMenuItem, o.a(this.nPv), o.b(this.nPv));
          paramMenuItem = this.nPv.bMK();
          if (paramMenuItem == null) {
            break label308;
          }
          paramMenuItem = paramMenuItem.Cfc;
          if (paramMenuItem == null) {
            break label308;
          }
          localObject4 = paramMenuItem.eBM();
          if (localObject4 == null) {
            break label308;
          }
          paramMenuItem = this.nPv.bMK();
          if (paramMenuItem == null) {
            break label303;
          }
        }
      }
      label291:
      label297:
      label303:
      for (paramMenuItem = paramMenuItem.bLL();; paramMenuItem = null)
      {
        ((ax.d)localObject4).B(new Object[] { paramMenuItem, Integer.valueOf(1), Integer.valueOf(1), localObject1, localObject2, localObject3 }).report();
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
      if (paramInt == this.nPv.nPj)
      {
        localObject4 = this.nPv;
        ac.i(((o)localObject4).TAG, "doTimeline");
        paramMenuItem = ((o)localObject4).lvU;
        if (paramMenuItem == null) {
          k.aVY("ui");
        }
        if (paramMenuItem.get() != null)
        {
          paramMenuItem = ((o)localObject4).lvU;
          if (paramMenuItem == null) {
            k.aVY("ui");
          }
          paramMenuItem = (TmplShareWebViewToolUI)paramMenuItem.get();
          if (paramMenuItem != null)
          {
            paramMenuItem = Boolean.valueOf(paramMenuItem.isFinishing());
            if (paramMenuItem == null) {
              k.fOy();
            }
            if (!paramMenuItem.booleanValue()) {
              break label530;
            }
          }
        }
        else
        {
          ac.i(((o)localObject4).TAG, "activity finished");
          paramMenuItem = this.nPv.bMK();
          if (paramMenuItem == null) {
            break label1339;
          }
          paramMenuItem = paramMenuItem.Cfc;
          if (paramMenuItem == null) {
            break label1339;
          }
          localObject4 = paramMenuItem.eBM();
          if (localObject4 == null) {
            break label1339;
          }
          paramMenuItem = this.nPv.bMK();
          if (paramMenuItem == null) {
            break label1334;
          }
        }
        for (paramMenuItem = paramMenuItem.bLL();; paramMenuItem = null)
        {
          ((ax.d)localObject4).B(new Object[] { paramMenuItem, Integer.valueOf(2), Integer.valueOf(1), localObject1, localObject2, localObject3 }).report();
          AppMethodBeat.o(7350);
          return;
          paramMenuItem = null;
          break;
          Intent localIntent = new Intent();
          paramMenuItem = ((o)localObject4).nLB;
          if (paramMenuItem == null) {
            k.aVY("msgInfo");
          }
          int i = paramMenuItem.hkX.videoWidth;
          paramInt = i;
          if (i <= 0) {
            paramInt = 150;
          }
          localIntent.putExtra("Ksnsupload_width", paramInt);
          localIntent.putExtra("Ksnsupload_height", paramInt);
          paramMenuItem = ((o)localObject4).nMS;
          if (paramMenuItem == null) {
            k.aVY("controller");
          }
          Object localObject5;
          if (paramMenuItem.bML())
          {
            paramMenuItem = ((o)localObject4).nMS;
            if (paramMenuItem == null) {
              k.aVY("controller");
            }
            paramMenuItem = paramMenuItem.nLH;
            if (paramMenuItem != null)
            {
              paramMenuItem = paramMenuItem.title;
              localIntent.putExtra("Ksnsupload_title", paramMenuItem);
              paramMenuItem = ((o)localObject4).nMS;
              if (paramMenuItem == null) {
                k.aVY("controller");
              }
              paramMenuItem = paramMenuItem.nLH;
              if (paramMenuItem == null) {
                break label1164;
              }
              paramMenuItem = paramMenuItem.hld;
              localIntent.putExtra("Ksnsupload_imgurl", paramMenuItem);
              paramMenuItem = ((o)localObject4).nMS;
              if (paramMenuItem == null) {
                k.aVY("controller");
              }
              localIntent.putExtra("Ksnsupload_link", paramMenuItem.url);
              paramMenuItem = ((o)localObject4).nLB;
              if (paramMenuItem == null) {
                k.aVY("msgInfo");
              }
              paramMenuItem = paramMenuItem.hkW;
              localObject5 = ((o)localObject4).nLB;
              if (localObject5 == null) {
                k.aVY("msgInfo");
              }
              if (bs.isNullOrNil(((x)localObject5).ddo)) {
                break label1232;
              }
              localObject5 = ((o)localObject4).nLB;
              if (localObject5 == null) {
                k.aVY("msgInfo");
              }
              localIntent.putExtra("src_username", ((x)localObject5).ddo);
              localObject5 = ((o)localObject4).nLB;
              if (localObject5 == null) {
                k.aVY("msgInfo");
              }
              localIntent.putExtra("src_displayname", ((x)localObject5).hkV);
              localIntent.putExtra("Ksnsupload_type", 1);
              localObject5 = ((o)localObject4).nMS;
              if (localObject5 == null) {
                k.aVY("controller");
              }
              localIntent.putExtra("ShareUrlOriginal", ((com.tencent.mm.plugin.brandservice.ui.timeline.video.b)localObject5).url);
              localIntent.putExtra("KPublisherId", paramMenuItem);
              localIntent.putExtra("need_result", true);
              localObject5 = ((o)localObject4).nMS;
              if (localObject5 == null) {
                k.aVY("controller");
              }
              if (!((com.tencent.mm.plugin.brandservice.ui.timeline.video.b)localObject5).bML()) {
                break label1297;
              }
              localObject5 = ((o)localObject4).nMS;
              if (localObject5 == null) {
                k.aVY("controller");
              }
              if (((com.tencent.mm.plugin.brandservice.ui.timeline.video.b)localObject5).nLH != null)
              {
                localObject5 = ((o)localObject4).nMS;
                if (localObject5 == null) {
                  k.aVY("controller");
                }
                localObject5 = ((com.tencent.mm.plugin.brandservice.ui.timeline.video.b)localObject5).nLH;
                if (localObject5 == null) {
                  k.fOy();
                }
                if (((btb)localObject5).hlf != null)
                {
                  localObject5 = ((o)localObject4).nMS;
                  if (localObject5 == null) {
                    k.aVY("controller");
                  }
                  localObject5 = ((com.tencent.mm.plugin.brandservice.ui.timeline.video.b)localObject5).nLH;
                  if (localObject5 == null) {
                    k.fOy();
                  }
                  localIntent.putExtra("ksnsupload_link_desc", ((btb)localObject5).hlf);
                }
              }
            }
          }
          for (;;)
          {
            paramMenuItem = y.xJ(paramMenuItem);
            localIntent.putExtra("reportSessionId", paramMenuItem);
            localObject5 = ((o)localObject4).lvU;
            if (localObject5 == null) {
              k.aVY("ui");
            }
            localObject5 = ((WeakReference)localObject5).get();
            if (localObject5 == null) {
              k.fOy();
            }
            localIntent.putExtra("BizVideoDetailUIExtras", ((TmplShareWebViewToolUI)localObject5).getIntent().getExtras());
            localObject5 = f.nOb;
            localObject5 = ((o)localObject4).nLB;
            if (localObject5 == null) {
              k.aVY("msgInfo");
            }
            com.tencent.mm.plugin.brandservice.ui.timeline.video.b localb = ((o)localObject4).nMS;
            if (localb == null) {
              k.aVY("controller");
            }
            k.g(paramMenuItem, "sessionId");
            f.a((x)localObject5, localb, paramMenuItem, (com.tencent.mm.ipcinvoker.d)new o.b((o)localObject4, localIntent));
            break;
            paramMenuItem = null;
            break label641;
            paramMenuItem = null;
            break label679;
            paramMenuItem = ((o)localObject4).nLB;
            if (paramMenuItem == null) {
              k.aVY("msgInfo");
            }
            localIntent.putExtra("Ksnsupload_title", paramMenuItem.hkX.title);
            paramMenuItem = ((o)localObject4).nLB;
            if (paramMenuItem == null) {
              k.aVY("msgInfo");
            }
            localIntent.putExtra("Ksnsupload_imgurl", paramMenuItem.hkX.hld);
            break label688;
            label1232:
            localObject5 = ((o)localObject4).nLB;
            if (localObject5 == null) {
              k.aVY("msgInfo");
            }
            localIntent.putExtra("src_username", ((x)localObject5).TC());
            localObject5 = ((o)localObject4).nLB;
            if (localObject5 == null) {
              k.aVY("msgInfo");
            }
            localIntent.putExtra("src_displayname", ((x)localObject5).hkV);
            break label825;
            localObject5 = ((o)localObject4).nLB;
            if (localObject5 == null) {
              k.aVY("msgInfo");
            }
            localIntent.putExtra("ksnsupload_link_desc", ((x)localObject5).hkX.hlf);
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
      if (paramInt == this.nPv.nPk)
      {
        paramMenuItem = this.nPv.bMK();
        if (paramMenuItem != null)
        {
          paramMenuItem = paramMenuItem.Cfc;
          if (paramMenuItem != null)
          {
            localObject1 = paramMenuItem.eBM();
            if (localObject1 != null)
            {
              paramMenuItem = this.nPv.bMK();
              if (paramMenuItem == null) {
                break label1553;
              }
              paramMenuItem = paramMenuItem.bLL();
              ((ax.d)localObject1).B(new Object[] { paramMenuItem, Integer.valueOf(3), Integer.valueOf(1) }).report();
            }
          }
        }
        localObject1 = this.nPv;
        paramMenuItem = e.nOa;
        paramMenuItem = ((o)localObject1).nLB;
        if (paramMenuItem == null) {
          k.aVY("msgInfo");
        }
        localObject2 = ((o)localObject1).nMS;
        if (localObject2 == null) {
          k.aVY("controller");
        }
        e.a(paramMenuItem, (com.tencent.mm.plugin.brandservice.ui.timeline.video.b)localObject2);
        localObject2 = (Context)((o)localObject1).bMK();
        paramMenuItem = ((o)localObject1).bMK();
        if (paramMenuItem != null) {}
        for (paramMenuItem = paramMenuItem.getString(2131758936);; paramMenuItem = null)
        {
          com.tencent.mm.ui.base.h.cd((Context)localObject2, paramMenuItem);
          paramMenuItem = ((o)localObject1).nMS;
          if (paramMenuItem == null) {
            k.aVY("controller");
          }
          paramMenuItem.nLw.aE(24, "");
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
      if (paramInt == this.nPv.nPn)
      {
        paramMenuItem = this.nPv.bMK();
        if (paramMenuItem != null)
        {
          paramMenuItem = paramMenuItem.Cfc;
          if (paramMenuItem != null)
          {
            localObject1 = paramMenuItem.eBM();
            if (localObject1 != null)
            {
              paramMenuItem = this.nPv.bMK();
              if (paramMenuItem == null) {
                break label1742;
              }
            }
          }
        }
        label1742:
        for (paramMenuItem = paramMenuItem.bLL();; paramMenuItem = null)
        {
          ((ax.d)localObject1).B(new Object[] { paramMenuItem, Integer.valueOf(4), Integer.valueOf(1) }).report();
          localObject1 = this.nPv;
          paramMenuItem = ((o)localObject1).nMS;
          if (paramMenuItem == null) {
            k.aVY("controller");
          }
          if ((paramMenuItem.hhc & 0x1) == 0) {
            break;
          }
          paramMenuItem = ((o)localObject1).TAG;
          localObject2 = new StringBuilder("not allow jump to profile ");
          localObject1 = ((o)localObject1).nMS;
          if (localObject1 == null) {
            k.aVY("controller");
          }
          ac.w(paramMenuItem, ((com.tencent.mm.plugin.brandservice.ui.timeline.video.b)localObject1).hhc);
          AppMethodBeat.o(7350);
          return;
        }
        if (((o)localObject1).bMK() != null)
        {
          paramMenuItem = ((o)localObject1).bMK();
          if (paramMenuItem == null) {
            break label1781;
          }
        }
        label1781:
        for (paramMenuItem = paramMenuItem.CAj; paramMenuItem == null; paramMenuItem = null)
        {
          AppMethodBeat.o(7350);
          return;
        }
        paramMenuItem = ((o)localObject1).bMK();
        if (paramMenuItem != null)
        {
          paramMenuItem = paramMenuItem.CAj;
          if (paramMenuItem != null) {
            paramMenuItem.fs("Contact_Scene", 153);
          }
        }
        paramMenuItem = ((o)localObject1).bMK();
        if (paramMenuItem != null)
        {
          localObject1 = ((o)localObject1).nMS;
          if (localObject1 == null) {
            k.aVY("controller");
          }
          paramMenuItem.aDq(((com.tencent.mm.plugin.brandservice.ui.timeline.video.b)localObject1).TC());
          AppMethodBeat.o(7350);
          return;
        }
        AppMethodBeat.o(7350);
        return;
      }
      label1553:
      if (paramInt == this.nPv.nPl)
      {
        paramMenuItem = this.nPv.bMK();
        if (paramMenuItem != null)
        {
          paramMenuItem = paramMenuItem.Cfc;
          if (paramMenuItem != null)
          {
            localObject1 = paramMenuItem.eBM();
            if (localObject1 != null)
            {
              paramMenuItem = this.nPv.bMK();
              if (paramMenuItem == null) {
                break label2000;
              }
            }
          }
        }
        label2000:
        for (paramMenuItem = paramMenuItem.bLL();; paramMenuItem = null)
        {
          ((ax.d)localObject1).B(new Object[] { paramMenuItem, Integer.valueOf(36), Integer.valueOf(1) }).report();
          com.tencent.mm.plugin.webview.j.f.a((Context)this.nPv.bMK(), o.a(this.nPv).hkX.title, (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(7349);
              if (paramAnonymousDialogInterface == null) {}
              for (paramAnonymousDialogInterface = "";; paramAnonymousDialogInterface = ((com.tencent.mm.ui.widget.a.d)paramAnonymousDialogInterface).fvm())
              {
                Object localObject = this.nPz.nPv.bMK();
                if (localObject == null) {
                  break;
                }
                localObject = ((TmplShareWebViewToolUI)localObject).Cjc;
                if (localObject == null) {
                  break;
                }
                ((com.tencent.mm.plugin.webview.c.f)localObject).v(1, paramAnonymousDialogInterface, 0);
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
      if (paramInt == this.nPv.nPm)
      {
        paramMenuItem = this.nPv.bMK();
        if (paramMenuItem != null)
        {
          paramMenuItem = paramMenuItem.Cfc;
          if (paramMenuItem != null)
          {
            localObject1 = paramMenuItem.eBM();
            if (localObject1 != null)
            {
              paramMenuItem = this.nPv.bMK();
              if (paramMenuItem == null) {
                break label2133;
              }
            }
          }
        }
        label2133:
        for (paramMenuItem = paramMenuItem.bLL();; paramMenuItem = null)
        {
          ((ax.d)localObject1).B(new Object[] { paramMenuItem, Integer.valueOf(37), Integer.valueOf(1) }).report();
          paramMenuItem = this.nPv.bMK();
          if (paramMenuItem == null) {
            break;
          }
          paramMenuItem = paramMenuItem.Cjc;
          if (paramMenuItem == null) {
            break;
          }
          paramMenuItem.v(0, "", 0);
          AppMethodBeat.o(7350);
          return;
        }
        AppMethodBeat.o(7350);
        return;
      }
      if (paramInt == this.nPv.nPo)
      {
        paramMenuItem = this.nPv.bMK();
        if (paramMenuItem != null)
        {
          paramMenuItem = paramMenuItem.Cfc;
          if (paramMenuItem != null)
          {
            localObject1 = paramMenuItem.eBM();
            if (localObject1 != null)
            {
              paramMenuItem = this.nPv.bMK();
              if (paramMenuItem == null) {
                break label2267;
              }
            }
          }
        }
        label2267:
        for (paramMenuItem = paramMenuItem.bLL();; paramMenuItem = null)
        {
          ((ax.d)localObject1).B(new Object[] { paramMenuItem, Integer.valueOf(5), Integer.valueOf(1) }).report();
          localObject1 = this.nPv;
          if (!((o)localObject1).isFinished()) {
            break;
          }
          ac.e(((o)localObject1).TAG, "copyLink fail, is finish");
          AppMethodBeat.o(7350);
          return;
        }
        paramMenuItem = ((o)localObject1).bMK();
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
              localObject2 = ((o)localObject1).nMS;
              if (localObject2 == null) {
                k.aVY("controller");
              }
              paramMenuItem.setText((CharSequence)((com.tencent.mm.plugin.brandservice.ui.timeline.video.b)localObject2).nLv);
              localObject2 = (Context)((o)localObject1).bMK();
              paramMenuItem = ((o)localObject1).bMK();
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
              ac.printErrStackTrace(((o)localObject1).TAG, (Throwable)paramMenuItem, "clip.setText error", new Object[0]);
              AppMethodBeat.o(7350);
              return;
            }
            paramMenuItem = null;
          }
        }
        ac.e(((o)localObject1).TAG, "clipboard manager is null");
        AppMethodBeat.o(7350);
        return;
      }
      if (paramInt == this.nPv.nPp)
      {
        paramMenuItem = this.nPv.bMK();
        if (paramMenuItem != null)
        {
          paramMenuItem = paramMenuItem.Cfc;
          if (paramMenuItem != null)
          {
            localObject1 = paramMenuItem.eBM();
            if (localObject1 != null)
            {
              paramMenuItem = this.nPv.bMK();
              if (paramMenuItem == null) {
                break label2898;
              }
              paramMenuItem = paramMenuItem.bLL();
              ((ax.d)localObject1).B(new Object[] { paramMenuItem, Integer.valueOf(11), Integer.valueOf(1) }).report();
            }
          }
        }
        localObject2 = this.nPv;
        paramMenuItem = ((o)localObject2).nLB;
        if (paramMenuItem == null) {
          k.aVY("msgInfo");
        }
        localObject3 = paramMenuItem.hkX.url;
        paramMenuItem = null;
        if (!bs.isNullOrNil((String)localObject3))
        {
          paramMenuItem = Uri.parse((String)localObject3);
          k.g(paramMenuItem, "uri");
          paramMenuItem = paramMenuItem.getHost();
        }
        if (!bs.isNullOrNil(paramMenuItem))
        {
          if (paramMenuItem == null) {
            k.fOy();
          }
          if (!d.n.n.nb(paramMenuItem, "mp.weixin.qq.com")) {}
        }
      }
      label3254:
      for (;;)
      {
        try
        {
          paramMenuItem = z.KUT;
          paramMenuItem = String.format("https://mp.weixin.qq.com/mp/infringement?url=%s#wechat_redirect", Arrays.copyOf(new Object[] { p.encode((String)localObject3, "utf-8") }, 1));
          k.g(paramMenuItem, "java.lang.String.format(format, *args)");
          if (!bs.isNullOrNil(paramMenuItem)) {
            break label3254;
          }
          paramMenuItem = z.KUT;
          paramMenuItem = String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", Arrays.copyOf(new Object[] { Integer.valueOf(34) }, 1));
          k.g(paramMenuItem, "java.lang.String.format(format, *args)");
          localObject4 = new Intent();
        }
        catch (UnsupportedEncodingException paramMenuItem)
        {
          label2898:
          ac.e(((o)localObject2).TAG, paramMenuItem.getMessage());
        }
        try
        {
          localObject1 = ((o)localObject2).bMK();
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
          localObject1 = k.E((String)localObject1, "/screenshot.jpg");
          com.tencent.mm.sdk.platformtools.f.a(bg.aV((Activity)((o)localObject2).bMK()), 75, Bitmap.CompressFormat.JPEG, (String)localObject1, true);
          ((Intent)localObject4).putExtra("k_webview_img", (String)localObject1);
        }
        catch (IOException localIOException)
        {
          ac.e(((o)localObject2).TAG, "[oneliang]save screen shot to file error, ex = " + localIOException.getMessage());
          continue;
        }
        ((Intent)localObject4).putExtra("rawUrl", paramMenuItem);
        ((Intent)localObject4).putExtra("k_expose_url", (String)localObject3);
        paramMenuItem = ((o)localObject2).nMS;
        if (paramMenuItem == null) {
          k.aVY("controller");
        }
        ((Intent)localObject4).putExtra("k_expose_web_scene", paramMenuItem.scene);
        ((Intent)localObject4).putExtra("showShare", false);
        com.tencent.mm.br.d.b((Context)((o)localObject2).bMK(), "webview", ".ui.tools.WebViewUI", (Intent)localObject4);
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
        if (paramInt == this.nPv.nPq)
        {
          paramMenuItem = this.nPv.bMK();
          if (paramMenuItem == null) {
            k.fOy();
          }
          paramMenuItem = paramMenuItem.Cfc;
          if (paramMenuItem == null) {
            k.fOy();
          }
          paramMenuItem = paramMenuItem.eBM();
          localTmplShareWebViewToolUI = this.nPv.bMK();
          if (localTmplShareWebViewToolUI == null) {
            k.fOy();
          }
          paramMenuItem.B(new Object[] { localTmplShareWebViewToolUI.bLL(), Integer.valueOf(33), Integer.valueOf(1) }).report();
          paramMenuItem = this.nPv.bMK();
          if (paramMenuItem == null) {
            k.fOy();
          }
          paramMenuItem.eDE().ga(true);
          AppMethodBeat.o(7350);
          return;
        }
        if (paramInt == this.nPv.nPr)
        {
          paramMenuItem = this.nPv.bMK();
          if (paramMenuItem == null) {
            k.fOy();
          }
          paramMenuItem = paramMenuItem.Cfc;
          if (paramMenuItem == null) {
            k.fOy();
          }
          paramMenuItem = paramMenuItem.eBM();
          localTmplShareWebViewToolUI = this.nPv.bMK();
          if (localTmplShareWebViewToolUI == null) {
            k.fOy();
          }
          paramMenuItem.B(new Object[] { localTmplShareWebViewToolUI.bLL(), Integer.valueOf(34), Integer.valueOf(1) }).report();
          paramMenuItem = this.nPv.bMK();
          if (paramMenuItem == null) {
            k.fOy();
          }
          paramMenuItem.eDE().ga(false);
          AppMethodBeat.o(7350);
          return;
        }
        ac.w(this.nPv.TAG, "wrong id: " + paramMenuItem.getItemId());
        AppMethodBeat.o(7350);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.o
 * JD-Core Version:    0.7.0.1
 */