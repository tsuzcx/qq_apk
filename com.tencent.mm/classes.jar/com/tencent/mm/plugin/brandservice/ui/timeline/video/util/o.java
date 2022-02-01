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
import com.tencent.mm.ai.x;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI;
import com.tencent.mm.plugin.webview.model.ax;
import com.tencent.mm.plugin.webview.model.ax.d;
import com.tencent.mm.plugin.webview.ui.tools.i;
import com.tencent.mm.plugin.webview.ui.tools.n.a;
import com.tencent.mm.protocal.protobuf.bol;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bt;
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

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MpMenuHelper;", "", "()V", "MENU_ID_CANCEL_HAO_KAN", "", "MENU_ID_CANCEL_MINIMIZE", "MENU_ID_COPY_LINK", "MENU_ID_EXPOSE", "MENU_ID_FAV", "MENU_ID_HAO_KAN", "MENU_ID_MINIMIZE", "MENU_ID_SEND_TO_FRIEND", "MENU_ID_SHARE_TO_TIMELINE", "MENU_ID_SHOW_BIZ", "TAG", "", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "isBottomSheetShowing", "", "mmBottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "msgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "onlyShowShareMenu", "ui", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI;", "getUi$plugin_brandservice_release", "()Ljava/lang/ref/WeakReference;", "setUi$plugin_brandservice_release", "(Ljava/lang/ref/WeakReference;)V", "context", "copyLink", "", "doExpose", "fav", "goProfile", "hasShowMenuPermission", "id", "bitSet", "init", "isFinished", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onDestroy", "shareToTimeline", "shouldDisableMenuItem", "showMenu", "updateMenu", "plugin-brandservice_release"})
public final class o
{
  final String TAG = "MicroMsg.MpMenuHelper";
  public WeakReference<TmplShareWebViewToolUI> kUk;
  com.tencent.mm.ui.widget.a.e lBF;
  public x niI;
  public com.tencent.mm.plugin.brandservice.ui.timeline.video.b njZ;
  final int nmi;
  final int nmj = 1;
  final int nmk = 2;
  final int nml = 3;
  final int nmm = 4;
  final int nmn = 5;
  final int nmo = 6;
  final int nmp = 7;
  final int nmq = 8;
  final int nmr = 9;
  public boolean nms;
  boolean nmt;
  
  public final void VV()
  {
    AppMethodBeat.i(7352);
    if (this.nmt) {
      iD(this.nms);
    }
    AppMethodBeat.o(7352);
  }
  
  public final TmplShareWebViewToolUI bFx()
  {
    AppMethodBeat.i(7355);
    Object localObject = this.kUk;
    if (localObject == null) {
      k.aPZ("ui");
    }
    if (((WeakReference)localObject).get() == null)
    {
      AppMethodBeat.o(7355);
      return null;
    }
    localObject = this.kUk;
    if (localObject == null) {
      k.aPZ("ui");
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
  
  public final void iD(final boolean paramBoolean)
  {
    AppMethodBeat.i(7353);
    this.nms = paramBoolean;
    if (isFinished())
    {
      ad.i(this.TAG, "showMenu return:isFinished=%b", new Object[] { Boolean.valueOf(isFinished()) });
      AppMethodBeat.o(7353);
      return;
    }
    Object localObject2;
    n.d locald;
    if (!this.nmt)
    {
      if (paramBoolean)
      {
        localObject1 = this.njZ;
        if (localObject1 == null) {
          k.aPZ("controller");
        }
        if ((((com.tencent.mm.plugin.brandservice.ui.timeline.video.b)localObject1).gGB & 0x8) != 0)
        {
          localObject1 = this.njZ;
          if (localObject1 == null) {
            k.aPZ("controller");
          }
          if ((((com.tencent.mm.plugin.brandservice.ui.timeline.video.b)localObject1).gGB & 0x10) != 0)
          {
            localObject2 = (Context)bFx();
            localObject1 = bFx();
            if (localObject1 != null) {}
            for (localObject1 = ((TmplShareWebViewToolUI)localObject1).getString(2131766260);; localObject1 = null)
            {
              com.tencent.mm.ui.base.h.cc((Context)localObject2, (String)localObject1);
              AppMethodBeat.o(7353);
              return;
            }
          }
        }
        this.lBF = new com.tencent.mm.ui.widget.a.e((Context)bFx(), 1, false);
      }
    }
    else
    {
      localObject1 = this.lBF;
      if (localObject1 != null) {
        ((com.tencent.mm.ui.widget.a.e)localObject1).b((e.b)new c(this));
      }
      localObject1 = this.lBF;
      if (localObject1 != null) {
        ((com.tencent.mm.ui.widget.a.e)localObject1).a((n.c)new d(this, paramBoolean));
      }
      locald = (n.d)new g(this);
      localObject1 = this.lBF;
      if (localObject1 != null) {
        ((com.tencent.mm.ui.widget.a.e)localObject1).a(locald);
      }
      localObject1 = this.lBF;
      if (localObject1 != null) {
        ((com.tencent.mm.ui.widget.a.e)localObject1).b((n.c)new e(this, paramBoolean));
      }
      localObject1 = bFx();
      if (localObject1 == null) {
        break label560;
      }
      localObject2 = ((TmplShareWebViewToolUI)localObject1).ejo();
      label288:
      localObject1 = bFx();
      if ((localObject1 == null) || (((TmplShareWebViewToolUI)localObject1).Bid == null)) {
        break label566;
      }
    }
    label560:
    label566:
    for (Object localObject1 = com.tencent.mm.plugin.webview.ui.tools.n.ayb((String)localObject2);; localObject1 = null)
    {
      boolean bool = ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).isMpUrl((String)localObject2);
      if ((!paramBoolean) && (bool) && (localObject1 != null) && (((n.a)localObject1).isDataValid()))
      {
        localObject2 = LayoutInflater.from((Context)bFx()).inflate(2131494913, null);
        ImageView localImageView = (ImageView)((View)localObject2).findViewById(2131301214);
        Object localObject3 = (TextView)((View)localObject2).findViewById(2131306141);
        View localView = ((View)localObject2).findViewById(2131298761);
        k.g(localObject3, "nickNameTextView");
        ((TextView)localObject3).setText((CharSequence)((n.a)localObject1).BiV);
        localObject3 = new c.a().ayZ().aza().oq(2131231875);
        com.tencent.mm.aw.a.a.ayO().a(((n.a)localObject1).BiW, localImageView, ((c.a)localObject3).azc());
        localView.setOnClickListener((View.OnClickListener)new f(this, (n.a)localObject1));
        com.tencent.mm.ui.tools.o.go(localView);
        localObject1 = this.lBF;
        if (localObject1 != null) {
          ((com.tencent.mm.ui.widget.a.e)localObject1).J((View)localObject2, true);
        }
      }
      localObject1 = this.lBF;
      if (localObject1 != null) {
        ((com.tencent.mm.ui.widget.a.e)localObject1).b(locald);
      }
      localObject1 = this.lBF;
      if (localObject1 != null) {
        ((com.tencent.mm.ui.widget.a.e)localObject1).csG();
      }
      this.nmt = true;
      AppMethodBeat.o(7353);
      return;
      this.lBF = new com.tencent.mm.ui.widget.a.e((Context)bFx(), 0, true);
      break;
      localObject2 = null;
      break label288;
    }
  }
  
  final boolean isFinished()
  {
    AppMethodBeat.i(7357);
    Object localObject = this.kUk;
    if (localObject == null) {
      k.aPZ("ui");
    }
    if (((WeakReference)localObject).get() != null)
    {
      localObject = this.kUk;
      if (localObject == null) {
        k.aPZ("ui");
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
  
  public final void onDestroy()
  {
    AppMethodBeat.i(7356);
    if (this.lBF != null)
    {
      com.tencent.mm.ui.widget.a.e locale = this.lBF;
      if (locale == null) {
        k.fvU();
      }
      if (locale.isShowing())
      {
        locale = this.lBF;
        if (locale == null) {
          k.fvU();
        }
        locale.bfo();
      }
    }
    AppMethodBeat.o(7356);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "bundle", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "onCallback"})
  public static final class a<T>
    implements com.tencent.mm.ipcinvoker.d<Bundle>
  {
    public a(o paramo) {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "bundle", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class b<T>
    implements com.tencent.mm.ipcinvoker.d<Bundle>
  {
    b(o paramo, Intent paramIntent) {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "onDismiss"})
  static final class c
    implements e.b
  {
    c(o paramo) {}
    
    public final void onDismiss()
    {
      this.nmu.nmt = false;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class d
    implements n.c
  {
    d(o paramo, boolean paramBoolean) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      AppMethodBeat.i(7347);
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(480L, 0L, 1L, false);
      paraml.clear();
      if (this.nmu.bFx() == null)
      {
        AppMethodBeat.o(7347);
        return;
      }
      if ((paramBoolean) && (o.a(this.nmu, 16)))
      {
        i = this.nmu.nmj;
        localObject1 = this.nmu.bFx();
        if (localObject1 != null)
        {
          localObject1 = ((TmplShareWebViewToolUI)localObject1).getString(2131762164);
          paraml.a(i, (CharSequence)localObject1, 2131689817, 0, o.b(this.nmu, 16));
        }
      }
      else
      {
        if (o.a(this.nmu, 8))
        {
          i = this.nmu.nmi;
          localObject1 = this.nmu.bFx();
          if (localObject1 == null) {
            break label301;
          }
          localObject1 = ((TmplShareWebViewToolUI)localObject1).getString(2131762163);
          label155:
          localObject1 = (CharSequence)localObject1;
          localObject3 = this.nmu.bFx();
          if (localObject3 == null) {
            k.fvU();
          }
          paraml.a(i, (CharSequence)localObject1, 2131690478, ((TmplShareWebViewToolUI)localObject3).getResources().getColor(2131099699), o.b(this.nmu, 8));
        }
        if ((!paramBoolean) && (o.a(this.nmu, 16)))
        {
          i = this.nmu.nmj;
          localObject1 = this.nmu.bFx();
          if (localObject1 == null) {
            break label307;
          }
        }
      }
      label301:
      label307:
      for (Object localObject1 = ((TmplShareWebViewToolUI)localObject1).getString(2131762164);; localObject1 = null)
      {
        paraml.a(i, (CharSequence)localObject1, 2131689817, 0, o.b(this.nmu, 16));
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
          localObject1 = this.nmu.bFx();
          if (localObject1 != null)
          {
            i = localObject1.hashCode();
            ((Bundle)localObject3).putInt("WebViewShare_BinderID", i);
            localObject1 = this.nmu.bFx();
            if (localObject1 == null) {
              continue;
            }
            localObject1 = ((TmplShareWebViewToolUI)localObject1).eoY();
            if (localObject1 == null) {
              continue;
            }
            localObject1 = ((MMWebView)localObject1).getUrl();
            ((Bundle)localObject3).putString("WebViewShare_wv_url", (String)localObject1);
            localObject1 = this.nmu.bFx();
            if (localObject1 == null) {
              continue;
            }
            localObject1 = ((TmplShareWebViewToolUI)localObject1).kxf;
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
          ad.e(this.nmu.TAG, "isSetHaoKan, e = " + localRemoteException1.getMessage());
          i = -1;
          continue;
          Object localObject2 = null;
          continue;
          if ((!o.a(this.nmu, 0)) || (i != 1)) {
            continue;
          }
          i = this.nmu.nmm;
          localObject2 = this.nmu.bFx();
          if (localObject2 != null)
          {
            localObject2 = ((TmplShareWebViewToolUI)localObject2).getString(2131762165);
            localObject2 = (CharSequence)localObject2;
            localObject3 = this.nmu.bFx();
            if (localObject3 == null) {
              k.fvU();
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
            if ((!o.a(this.nmu, 0)) || (i != 0)) {
              continue;
            }
            i = this.nmu.nml;
            localObject1 = this.nmu.bFx();
            if (localObject1 == null) {
              continue;
            }
            localObject1 = ((TmplShareWebViewToolUI)localObject1).getString(2131762173);
            localObject1 = (CharSequence)localObject1;
            localObject3 = this.nmu.bFx();
            if (localObject3 == null) {
              k.fvU();
            }
            paraml.a(i, (CharSequence)localObject1, 2131689811, ((TmplShareWebViewToolUI)localObject3).getResources().getColor(2131099829));
          }
          if (o.a(this.nmu, 64))
          {
            i = this.nmu.nmk;
            localObject1 = this.nmu.bFx();
            if (localObject1 == null) {
              continue;
            }
            localObject1 = ((TmplShareWebViewToolUI)localObject1).getString(2131761941);
            paraml.a(i, (CharSequence)localObject1, 2131689808, 0, o.b(this.nmu, 64));
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
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class e
    implements n.c
  {
    e(o paramo, boolean paramBoolean) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      AppMethodBeat.i(7348);
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(480L, 0L, 1L, false);
      paraml.clear();
      if (this.nmu.bFx() == null)
      {
        AppMethodBeat.o(7348);
        return;
      }
      int i;
      if (!paramBoolean)
      {
        localObject1 = this.nmu.bFx();
        if (localObject1 == null) {
          k.fvU();
        }
        if (((TmplShareWebViewToolUI)localObject1).eoj() != null)
        {
          localObject1 = this.nmu.bFx();
          if (localObject1 == null) {
            k.fvU();
          }
          localObject1 = ((TmplShareWebViewToolUI)localObject1).eoj();
          k.g(localObject1, "context()!!.webViewFloatBallHelper");
          if (((com.tencent.mm.plugin.webview.ui.tools.b.a)localObject1).aVY())
          {
            localObject1 = this.nmu.bFx();
            if (localObject1 == null) {
              k.fvU();
            }
            if (((TmplShareWebViewToolUI)localObject1).eoj().bzs()) {
              break label418;
            }
            i = this.nmu.nmq;
            localObject1 = this.nmu.bFx();
            if (localObject1 == null) {
              break label413;
            }
            localObject1 = ((TmplShareWebViewToolUI)localObject1).getString(2131762178);
            paraml.a(i, (CharSequence)localObject1, 2131690574);
          }
        }
      }
      label165:
      Object localObject1 = this.nmu.bFx();
      label182:
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((TmplShareWebViewToolUI)localObject1).ejo();
        localObject2 = this.nmu.bFx();
        if (localObject2 == null) {
          break label495;
        }
        localObject2 = ((TmplShareWebViewToolUI)localObject2).Bid;
        label203:
        if (localObject2 == null) {
          break label501;
        }
        localObject1 = com.tencent.mm.plugin.webview.ui.tools.n.ayb((String)localObject1);
        label213:
        if ((localObject1 != null) && (((n.a)localObject1).isDataValid())) {
          break label506;
        }
        i = 1;
        label226:
        if ((o.a(this.nmu, 1)) && (i != 0))
        {
          i = this.nmu.nmn;
          localObject1 = this.nmu.bFx();
          if (localObject1 == null) {
            break label511;
          }
          localObject1 = ((TmplShareWebViewToolUI)localObject1).getString(2131766258);
          paraml.a(i, (CharSequence)localObject1, 2131690612, o.b(this.nmu, 1));
        }
        label268:
        if (o.a(this.nmu, 0))
        {
          i = this.nmu.nmp;
          localObject1 = this.nmu.bFx();
          if (localObject1 == null) {
            break label516;
          }
          localObject1 = ((TmplShareWebViewToolUI)localObject1).getString(2131756596);
          label326:
          paraml.a(i, (CharSequence)localObject1, 2131690646, o.b(this.nmu, 0));
        }
        if (o.a(this.nmu, 32))
        {
          i = this.nmu.nmo;
          localObject1 = this.nmu.bFx();
          if (localObject1 == null) {
            break label521;
          }
        }
      }
      label516:
      label521:
      for (localObject1 = ((TmplShareWebViewToolUI)localObject1).getString(2131766247);; localObject1 = null)
      {
        paraml.a(i, (CharSequence)localObject1, 2131690588, o.b(this.nmu, 32));
        AppMethodBeat.o(7348);
        return;
        label413:
        localObject1 = null;
        break;
        label418:
        localObject1 = this.nmu.bFx();
        if (localObject1 == null) {
          k.fvU();
        }
        if (!((TmplShareWebViewToolUI)localObject1).eoj().bzs()) {
          break label165;
        }
        i = this.nmu.nmr;
        localObject1 = this.nmu.bFx();
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
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(o paramo, n.a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(175545);
      paramView = this.nmu.bFx();
      ax.d locald;
      if (paramView != null)
      {
        paramView = paramView.AMJ;
        if (paramView != null)
        {
          locald = paramView.emr();
          if (locald != null)
          {
            paramView = this.nmu.kUk;
            if (paramView == null) {
              k.aPZ("ui");
            }
            paramView = (TmplShareWebViewToolUI)paramView.get();
            if (paramView == null) {
              break label184;
            }
          }
        }
      }
      label184:
      for (paramView = paramView.bEx();; paramView = null)
      {
        locald.z(new Object[] { paramView, Integer.valueOf(38), Integer.valueOf(1) }).report();
        paramView = this.nmu.bFx();
        if (paramView != null)
        {
          paramView = paramView.BhW;
          if (paramView != null) {
            paramView.fk("Contact_Scene", 173);
          }
        }
        paramView = this.nmu.bFx();
        if (paramView != null) {
          paramView.axZ(this.nmy.gXY);
        }
        if (this.nmu.lBF == null) {
          break;
        }
        paramView = this.nmu.lBF;
        if (paramView == null) {
          break;
        }
        paramView.bfo();
        AppMethodBeat.o(175545);
        return;
      }
      AppMethodBeat.o(175545);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class g
    implements n.d
  {
    g(o paramo) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(7350);
      this.nmu.nmt = false;
      Object localObject1 = this.nmu.bFx();
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
          localObject2 = this.nmu.bFx();
          if (localObject2 == null) {
            break label291;
          }
          localObject2 = ((TmplShareWebViewToolUI)localObject2).getIntent();
          if (localObject2 == null) {
            break label291;
          }
          localObject2 = ((Intent)localObject2).getStringExtra("KAppId");
          localObject3 = this.nmu.bFx();
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
          if (paramInt != this.nmu.nmi) {
            break label315;
          }
          paramMenuItem = g.nlc;
          paramMenuItem = this.nmu.bFx();
          if (paramMenuItem == null) {
            k.fvU();
          }
          g.a((Context)paramMenuItem, o.a(this.nmu), o.b(this.nmu));
          paramMenuItem = this.nmu.bFx();
          if (paramMenuItem == null) {
            break label308;
          }
          paramMenuItem = paramMenuItem.AMJ;
          if (paramMenuItem == null) {
            break label308;
          }
          localObject4 = paramMenuItem.emr();
          if (localObject4 == null) {
            break label308;
          }
          paramMenuItem = this.nmu.bFx();
          if (paramMenuItem == null) {
            break label303;
          }
        }
      }
      label291:
      label297:
      label303:
      for (paramMenuItem = paramMenuItem.bEx();; paramMenuItem = null)
      {
        ((ax.d)localObject4).z(new Object[] { paramMenuItem, Integer.valueOf(1), Integer.valueOf(1), localObject1, localObject2, localObject3 }).report();
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
      if (paramInt == this.nmu.nmj)
      {
        localObject4 = this.nmu;
        ad.i(((o)localObject4).TAG, "doTimeline");
        paramMenuItem = ((o)localObject4).kUk;
        if (paramMenuItem == null) {
          k.aPZ("ui");
        }
        if (paramMenuItem.get() != null)
        {
          paramMenuItem = ((o)localObject4).kUk;
          if (paramMenuItem == null) {
            k.aPZ("ui");
          }
          paramMenuItem = (TmplShareWebViewToolUI)paramMenuItem.get();
          if (paramMenuItem != null)
          {
            paramMenuItem = Boolean.valueOf(paramMenuItem.isFinishing());
            if (paramMenuItem == null) {
              k.fvU();
            }
            if (!paramMenuItem.booleanValue()) {
              break label530;
            }
          }
        }
        else
        {
          ad.i(((o)localObject4).TAG, "activity finished");
          paramMenuItem = this.nmu.bFx();
          if (paramMenuItem == null) {
            break label1339;
          }
          paramMenuItem = paramMenuItem.AMJ;
          if (paramMenuItem == null) {
            break label1339;
          }
          localObject4 = paramMenuItem.emr();
          if (localObject4 == null) {
            break label1339;
          }
          paramMenuItem = this.nmu.bFx();
          if (paramMenuItem == null) {
            break label1334;
          }
        }
        for (paramMenuItem = paramMenuItem.bEx();; paramMenuItem = null)
        {
          ((ax.d)localObject4).z(new Object[] { paramMenuItem, Integer.valueOf(2), Integer.valueOf(1), localObject1, localObject2, localObject3 }).report();
          AppMethodBeat.o(7350);
          return;
          paramMenuItem = null;
          break;
          Intent localIntent = new Intent();
          paramMenuItem = ((o)localObject4).niI;
          if (paramMenuItem == null) {
            k.aPZ("msgInfo");
          }
          int i = paramMenuItem.gKx.videoWidth;
          paramInt = i;
          if (i <= 0) {
            paramInt = 150;
          }
          localIntent.putExtra("Ksnsupload_width", paramInt);
          localIntent.putExtra("Ksnsupload_height", paramInt);
          paramMenuItem = ((o)localObject4).njZ;
          if (paramMenuItem == null) {
            k.aPZ("controller");
          }
          Object localObject5;
          if (paramMenuItem.bFy())
          {
            paramMenuItem = ((o)localObject4).njZ;
            if (paramMenuItem == null) {
              k.aPZ("controller");
            }
            paramMenuItem = paramMenuItem.niO;
            if (paramMenuItem != null)
            {
              paramMenuItem = paramMenuItem.title;
              localIntent.putExtra("Ksnsupload_title", paramMenuItem);
              paramMenuItem = ((o)localObject4).njZ;
              if (paramMenuItem == null) {
                k.aPZ("controller");
              }
              paramMenuItem = paramMenuItem.niO;
              if (paramMenuItem == null) {
                break label1164;
              }
              paramMenuItem = paramMenuItem.gKD;
              localIntent.putExtra("Ksnsupload_imgurl", paramMenuItem);
              paramMenuItem = ((o)localObject4).njZ;
              if (paramMenuItem == null) {
                k.aPZ("controller");
              }
              localIntent.putExtra("Ksnsupload_link", paramMenuItem.url);
              paramMenuItem = ((o)localObject4).niI;
              if (paramMenuItem == null) {
                k.aPZ("msgInfo");
              }
              paramMenuItem = paramMenuItem.gKw;
              localObject5 = ((o)localObject4).niI;
              if (localObject5 == null) {
                k.aPZ("msgInfo");
              }
              if (bt.isNullOrNil(((x)localObject5).dfT)) {
                break label1232;
              }
              localObject5 = ((o)localObject4).niI;
              if (localObject5 == null) {
                k.aPZ("msgInfo");
              }
              localIntent.putExtra("src_username", ((x)localObject5).dfT);
              localObject5 = ((o)localObject4).niI;
              if (localObject5 == null) {
                k.aPZ("msgInfo");
              }
              localIntent.putExtra("src_displayname", ((x)localObject5).gKv);
              localIntent.putExtra("Ksnsupload_type", 1);
              localObject5 = ((o)localObject4).njZ;
              if (localObject5 == null) {
                k.aPZ("controller");
              }
              localIntent.putExtra("ShareUrlOriginal", ((com.tencent.mm.plugin.brandservice.ui.timeline.video.b)localObject5).url);
              localIntent.putExtra("KPublisherId", paramMenuItem);
              localIntent.putExtra("need_result", true);
              localObject5 = ((o)localObject4).njZ;
              if (localObject5 == null) {
                k.aPZ("controller");
              }
              if (!((com.tencent.mm.plugin.brandservice.ui.timeline.video.b)localObject5).bFy()) {
                break label1297;
              }
              localObject5 = ((o)localObject4).njZ;
              if (localObject5 == null) {
                k.aPZ("controller");
              }
              if (((com.tencent.mm.plugin.brandservice.ui.timeline.video.b)localObject5).niO != null)
              {
                localObject5 = ((o)localObject4).njZ;
                if (localObject5 == null) {
                  k.aPZ("controller");
                }
                localObject5 = ((com.tencent.mm.plugin.brandservice.ui.timeline.video.b)localObject5).niO;
                if (localObject5 == null) {
                  k.fvU();
                }
                if (((bol)localObject5).gKF != null)
                {
                  localObject5 = ((o)localObject4).njZ;
                  if (localObject5 == null) {
                    k.aPZ("controller");
                  }
                  localObject5 = ((com.tencent.mm.plugin.brandservice.ui.timeline.video.b)localObject5).niO;
                  if (localObject5 == null) {
                    k.fvU();
                  }
                  localIntent.putExtra("ksnsupload_link_desc", ((bol)localObject5).gKF);
                }
              }
            }
          }
          for (;;)
          {
            paramMenuItem = y.tD(paramMenuItem);
            localIntent.putExtra("reportSessionId", paramMenuItem);
            localObject5 = ((o)localObject4).kUk;
            if (localObject5 == null) {
              k.aPZ("ui");
            }
            localObject5 = ((WeakReference)localObject5).get();
            if (localObject5 == null) {
              k.fvU();
            }
            localIntent.putExtra("BizVideoDetailUIExtras", ((TmplShareWebViewToolUI)localObject5).getIntent().getExtras());
            localObject5 = f.nlb;
            localObject5 = ((o)localObject4).niI;
            if (localObject5 == null) {
              k.aPZ("msgInfo");
            }
            com.tencent.mm.plugin.brandservice.ui.timeline.video.b localb = ((o)localObject4).njZ;
            if (localb == null) {
              k.aPZ("controller");
            }
            k.g(paramMenuItem, "sessionId");
            f.a((x)localObject5, localb, paramMenuItem, (com.tencent.mm.ipcinvoker.d)new o.b((o)localObject4, localIntent));
            break;
            paramMenuItem = null;
            break label641;
            paramMenuItem = null;
            break label679;
            paramMenuItem = ((o)localObject4).niI;
            if (paramMenuItem == null) {
              k.aPZ("msgInfo");
            }
            localIntent.putExtra("Ksnsupload_title", paramMenuItem.gKx.title);
            paramMenuItem = ((o)localObject4).niI;
            if (paramMenuItem == null) {
              k.aPZ("msgInfo");
            }
            localIntent.putExtra("Ksnsupload_imgurl", paramMenuItem.gKx.gKD);
            break label688;
            label1232:
            localObject5 = ((o)localObject4).niI;
            if (localObject5 == null) {
              k.aPZ("msgInfo");
            }
            localIntent.putExtra("src_username", ((x)localObject5).SI());
            localObject5 = ((o)localObject4).niI;
            if (localObject5 == null) {
              k.aPZ("msgInfo");
            }
            localIntent.putExtra("src_displayname", ((x)localObject5).gKv);
            break label825;
            localObject5 = ((o)localObject4).niI;
            if (localObject5 == null) {
              k.aPZ("msgInfo");
            }
            localIntent.putExtra("ksnsupload_link_desc", ((x)localObject5).gKx.gKF);
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
      if (paramInt == this.nmu.nmk)
      {
        paramMenuItem = this.nmu.bFx();
        if (paramMenuItem != null)
        {
          paramMenuItem = paramMenuItem.AMJ;
          if (paramMenuItem != null)
          {
            localObject1 = paramMenuItem.emr();
            if (localObject1 != null)
            {
              paramMenuItem = this.nmu.bFx();
              if (paramMenuItem == null) {
                break label1550;
              }
              paramMenuItem = paramMenuItem.bEx();
              ((ax.d)localObject1).z(new Object[] { paramMenuItem, Integer.valueOf(3), Integer.valueOf(1) }).report();
            }
          }
        }
        localObject1 = this.nmu;
        paramMenuItem = e.nla;
        paramMenuItem = ((o)localObject1).niI;
        if (paramMenuItem == null) {
          k.aPZ("msgInfo");
        }
        localObject2 = ((o)localObject1).njZ;
        if (localObject2 == null) {
          k.aPZ("controller");
        }
        e.a(paramMenuItem, (com.tencent.mm.plugin.brandservice.ui.timeline.video.b)localObject2);
        localObject2 = (Context)((o)localObject1).bFx();
        paramMenuItem = ((o)localObject1).bFx();
        if (paramMenuItem != null) {}
        for (paramMenuItem = paramMenuItem.getString(2131758936);; paramMenuItem = null)
        {
          com.tencent.mm.ui.base.h.cc((Context)localObject2, paramMenuItem);
          paramMenuItem = ((o)localObject1).njZ;
          if (paramMenuItem == null) {
            k.aPZ("controller");
          }
          paramMenuItem.niD.yD(24);
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
      if (paramInt == this.nmu.nmn)
      {
        paramMenuItem = this.nmu.bFx();
        if (paramMenuItem != null)
        {
          paramMenuItem = paramMenuItem.AMJ;
          if (paramMenuItem != null)
          {
            localObject1 = paramMenuItem.emr();
            if (localObject1 != null)
            {
              paramMenuItem = this.nmu.bFx();
              if (paramMenuItem == null) {
                break label1739;
              }
            }
          }
        }
        label1739:
        for (paramMenuItem = paramMenuItem.bEx();; paramMenuItem = null)
        {
          ((ax.d)localObject1).z(new Object[] { paramMenuItem, Integer.valueOf(4), Integer.valueOf(1) }).report();
          localObject1 = this.nmu;
          paramMenuItem = ((o)localObject1).njZ;
          if (paramMenuItem == null) {
            k.aPZ("controller");
          }
          if ((paramMenuItem.gGB & 0x1) == 0) {
            break;
          }
          paramMenuItem = ((o)localObject1).TAG;
          localObject2 = new StringBuilder("not allow jump to profile ");
          localObject1 = ((o)localObject1).njZ;
          if (localObject1 == null) {
            k.aPZ("controller");
          }
          ad.w(paramMenuItem, ((com.tencent.mm.plugin.brandservice.ui.timeline.video.b)localObject1).gGB);
          AppMethodBeat.o(7350);
          return;
        }
        if (((o)localObject1).bFx() != null)
        {
          paramMenuItem = ((o)localObject1).bFx();
          if (paramMenuItem == null) {
            break label1778;
          }
        }
        label1778:
        for (paramMenuItem = paramMenuItem.BhW; paramMenuItem == null; paramMenuItem = null)
        {
          AppMethodBeat.o(7350);
          return;
        }
        paramMenuItem = ((o)localObject1).bFx();
        if (paramMenuItem != null)
        {
          paramMenuItem = paramMenuItem.BhW;
          if (paramMenuItem != null) {
            paramMenuItem.fk("Contact_Scene", 153);
          }
        }
        paramMenuItem = ((o)localObject1).bFx();
        if (paramMenuItem != null)
        {
          localObject1 = ((o)localObject1).njZ;
          if (localObject1 == null) {
            k.aPZ("controller");
          }
          paramMenuItem.axZ(((com.tencent.mm.plugin.brandservice.ui.timeline.video.b)localObject1).SI());
          AppMethodBeat.o(7350);
          return;
        }
        AppMethodBeat.o(7350);
        return;
      }
      label1550:
      if (paramInt == this.nmu.nml)
      {
        paramMenuItem = this.nmu.bFx();
        if (paramMenuItem != null)
        {
          paramMenuItem = paramMenuItem.AMJ;
          if (paramMenuItem != null)
          {
            localObject1 = paramMenuItem.emr();
            if (localObject1 != null)
            {
              paramMenuItem = this.nmu.bFx();
              if (paramMenuItem == null) {
                break label1997;
              }
            }
          }
        }
        label1997:
        for (paramMenuItem = paramMenuItem.bEx();; paramMenuItem = null)
        {
          ((ax.d)localObject1).z(new Object[] { paramMenuItem, Integer.valueOf(36), Integer.valueOf(1) }).report();
          com.tencent.mm.plugin.webview.j.f.a((Context)this.nmu.bFx(), o.a(this.nmu).gKx.title, (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(7349);
              if (paramAnonymousDialogInterface == null) {}
              for (paramAnonymousDialogInterface = "";; paramAnonymousDialogInterface = ((com.tencent.mm.ui.widget.a.d)paramAnonymousDialogInterface).ffq())
              {
                Object localObject = this.nmz.nmu.bFx();
                if (localObject == null) {
                  break;
                }
                localObject = ((TmplShareWebViewToolUI)localObject).AQP;
                if (localObject == null) {
                  break;
                }
                ((com.tencent.mm.plugin.webview.c.f)localObject).t(1, paramAnonymousDialogInterface, 0);
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
      if (paramInt == this.nmu.nmm)
      {
        paramMenuItem = this.nmu.bFx();
        if (paramMenuItem != null)
        {
          paramMenuItem = paramMenuItem.AMJ;
          if (paramMenuItem != null)
          {
            localObject1 = paramMenuItem.emr();
            if (localObject1 != null)
            {
              paramMenuItem = this.nmu.bFx();
              if (paramMenuItem == null) {
                break label2130;
              }
            }
          }
        }
        label2130:
        for (paramMenuItem = paramMenuItem.bEx();; paramMenuItem = null)
        {
          ((ax.d)localObject1).z(new Object[] { paramMenuItem, Integer.valueOf(37), Integer.valueOf(1) }).report();
          paramMenuItem = this.nmu.bFx();
          if (paramMenuItem == null) {
            break;
          }
          paramMenuItem = paramMenuItem.AQP;
          if (paramMenuItem == null) {
            break;
          }
          paramMenuItem.t(0, "", 0);
          AppMethodBeat.o(7350);
          return;
        }
        AppMethodBeat.o(7350);
        return;
      }
      if (paramInt == this.nmu.nmo)
      {
        paramMenuItem = this.nmu.bFx();
        if (paramMenuItem != null)
        {
          paramMenuItem = paramMenuItem.AMJ;
          if (paramMenuItem != null)
          {
            localObject1 = paramMenuItem.emr();
            if (localObject1 != null)
            {
              paramMenuItem = this.nmu.bFx();
              if (paramMenuItem == null) {
                break label2264;
              }
            }
          }
        }
        label2264:
        for (paramMenuItem = paramMenuItem.bEx();; paramMenuItem = null)
        {
          ((ax.d)localObject1).z(new Object[] { paramMenuItem, Integer.valueOf(5), Integer.valueOf(1) }).report();
          localObject1 = this.nmu;
          if (!((o)localObject1).isFinished()) {
            break;
          }
          ad.e(((o)localObject1).TAG, "copyLink fail, is finish");
          AppMethodBeat.o(7350);
          return;
        }
        paramMenuItem = ((o)localObject1).bFx();
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
              localObject2 = ((o)localObject1).njZ;
              if (localObject2 == null) {
                k.aPZ("controller");
              }
              paramMenuItem.setText((CharSequence)((com.tencent.mm.plugin.brandservice.ui.timeline.video.b)localObject2).niC);
              localObject2 = (Context)((o)localObject1).bFx();
              paramMenuItem = ((o)localObject1).bFx();
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
              ad.printErrStackTrace(((o)localObject1).TAG, (Throwable)paramMenuItem, "clip.setText error", new Object[0]);
              AppMethodBeat.o(7350);
              return;
            }
            paramMenuItem = null;
          }
        }
        ad.e(((o)localObject1).TAG, "clipboard manager is null");
        AppMethodBeat.o(7350);
        return;
      }
      if (paramInt == this.nmu.nmp)
      {
        paramMenuItem = this.nmu.bFx();
        if (paramMenuItem != null)
        {
          paramMenuItem = paramMenuItem.AMJ;
          if (paramMenuItem != null)
          {
            localObject1 = paramMenuItem.emr();
            if (localObject1 != null)
            {
              paramMenuItem = this.nmu.bFx();
              if (paramMenuItem == null) {
                break label2895;
              }
              paramMenuItem = paramMenuItem.bEx();
              ((ax.d)localObject1).z(new Object[] { paramMenuItem, Integer.valueOf(11), Integer.valueOf(1) }).report();
            }
          }
        }
        localObject2 = this.nmu;
        paramMenuItem = ((o)localObject2).niI;
        if (paramMenuItem == null) {
          k.aPZ("msgInfo");
        }
        localObject3 = paramMenuItem.gKx.url;
        paramMenuItem = null;
        if (!bt.isNullOrNil((String)localObject3))
        {
          paramMenuItem = Uri.parse((String)localObject3);
          k.g(paramMenuItem, "uri");
          paramMenuItem = paramMenuItem.getHost();
        }
        if (!bt.isNullOrNil(paramMenuItem))
        {
          if (paramMenuItem == null) {
            k.fvU();
          }
          if (!d.n.n.mA(paramMenuItem, "mp.weixin.qq.com")) {}
        }
      }
      label3251:
      for (;;)
      {
        try
        {
          paramMenuItem = z.Jhz;
          paramMenuItem = String.format("https://mp.weixin.qq.com/mp/infringement?url=%s#wechat_redirect", Arrays.copyOf(new Object[] { p.encode((String)localObject3, "utf-8") }, 1));
          k.g(paramMenuItem, "java.lang.String.format(format, *args)");
          if (!bt.isNullOrNil(paramMenuItem)) {
            break label3251;
          }
          paramMenuItem = z.Jhz;
          paramMenuItem = String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", Arrays.copyOf(new Object[] { Integer.valueOf(34) }, 1));
          k.g(paramMenuItem, "java.lang.String.format(format, *args)");
          localObject4 = new Intent();
        }
        catch (UnsupportedEncodingException paramMenuItem)
        {
          label2895:
          ad.e(((o)localObject2).TAG, paramMenuItem.getMessage());
        }
        try
        {
          localObject1 = ((o)localObject2).bFx();
          if (localObject1 == null) {
            break label2918;
          }
          localObject1 = ((TmplShareWebViewToolUI)localObject1).getDir("expose", 0);
          if (localObject1 != null) {
            ((File)localObject1).mkdirs();
          }
          if (localObject1 == null) {
            break label2924;
          }
          localObject1 = ((File)localObject1).getAbsolutePath();
          localObject1 = k.C((String)localObject1, "/screenshot.jpg");
          com.tencent.mm.sdk.platformtools.f.a(bh.aR((Activity)((o)localObject2).bFx()), 75, Bitmap.CompressFormat.JPEG, (String)localObject1, true);
          ((Intent)localObject4).putExtra("k_webview_img", (String)localObject1);
        }
        catch (IOException localIOException)
        {
          ad.e(((o)localObject2).TAG, "[oneliang]save screen shot to file error, ex = " + localIOException.getMessage());
          continue;
        }
        ((Intent)localObject4).putExtra("rawUrl", paramMenuItem);
        ((Intent)localObject4).putExtra("k_expose_url", (String)localObject3);
        paramMenuItem = ((o)localObject2).njZ;
        if (paramMenuItem == null) {
          k.aPZ("controller");
        }
        ((Intent)localObject4).putExtra("k_expose_web_scene", paramMenuItem.scene);
        ((Intent)localObject4).putExtra("showShare", false);
        com.tencent.mm.bs.d.b((Context)((o)localObject2).bFx(), "webview", ".ui.tools.WebViewUI", (Intent)localObject4);
        AppMethodBeat.o(7350);
        return;
        paramMenuItem = null;
        break;
        paramMenuItem = null;
        continue;
        label2918:
        localObject1 = null;
        continue;
        label2924:
        localObject1 = null;
        continue;
        TmplShareWebViewToolUI localTmplShareWebViewToolUI;
        if (paramInt == this.nmu.nmq)
        {
          paramMenuItem = this.nmu.bFx();
          if (paramMenuItem == null) {
            k.fvU();
          }
          paramMenuItem = paramMenuItem.AMJ;
          if (paramMenuItem == null) {
            k.fvU();
          }
          paramMenuItem = paramMenuItem.emr();
          localTmplShareWebViewToolUI = this.nmu.bFx();
          if (localTmplShareWebViewToolUI == null) {
            k.fvU();
          }
          paramMenuItem.z(new Object[] { localTmplShareWebViewToolUI.bEx(), Integer.valueOf(33), Integer.valueOf(1) }).report();
          paramMenuItem = this.nmu.bFx();
          if (paramMenuItem == null) {
            k.fvU();
          }
          paramMenuItem.eoj().fE(true);
          AppMethodBeat.o(7350);
          return;
        }
        if (paramInt == this.nmu.nmr)
        {
          paramMenuItem = this.nmu.bFx();
          if (paramMenuItem == null) {
            k.fvU();
          }
          paramMenuItem = paramMenuItem.AMJ;
          if (paramMenuItem == null) {
            k.fvU();
          }
          paramMenuItem = paramMenuItem.emr();
          localTmplShareWebViewToolUI = this.nmu.bFx();
          if (localTmplShareWebViewToolUI == null) {
            k.fvU();
          }
          paramMenuItem.z(new Object[] { localTmplShareWebViewToolUI.bEx(), Integer.valueOf(34), Integer.valueOf(1) }).report();
          paramMenuItem = this.nmu.bFx();
          if (paramMenuItem == null) {
            k.fvU();
          }
          paramMenuItem.eoj().fE(false);
          AppMethodBeat.o(7350);
          return;
        }
        ad.w(this.nmu.TAG, "wrong id: " + paramMenuItem.getItemId());
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