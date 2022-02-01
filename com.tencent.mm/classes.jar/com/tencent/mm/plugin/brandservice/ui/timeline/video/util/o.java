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
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI;
import com.tencent.mm.plugin.webview.model.ay;
import com.tencent.mm.plugin.webview.model.ay.d;
import com.tencent.mm.plugin.webview.ui.tools.i;
import com.tencent.mm.plugin.webview.ui.tools.n.a;
import com.tencent.mm.protocal.protobuf.bxp;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.a.e.b;
import d.g.b.p;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.util.Arrays;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MpMenuHelper;", "", "()V", "MENU_ID_CANCEL_HAO_KAN", "", "MENU_ID_CANCEL_MINIMIZE", "MENU_ID_COPY_LINK", "MENU_ID_EXPOSE", "MENU_ID_FAV", "MENU_ID_HAO_KAN", "MENU_ID_MINIMIZE", "MENU_ID_SEND_TO_FRIEND", "MENU_ID_SHARE_TO_TIMELINE", "MENU_ID_SHOW_BIZ", "TAG", "", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "isBottomSheetShowing", "", "mmBottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "msgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "onlyShowShareMenu", "shareExtInfo", "getShareExtInfo", "()Ljava/lang/String;", "setShareExtInfo", "(Ljava/lang/String;)V", "ui", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI;", "getUi$plugin_brandservice_release", "()Ljava/lang/ref/WeakReference;", "setUi$plugin_brandservice_release", "(Ljava/lang/ref/WeakReference;)V", "context", "copyLink", "", "doExpose", "fav", "goProfile", "hasShowMenuPermission", "id", "bitSet", "init", "isFinished", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onDestroy", "shareToTimeline", "shouldDisableMenuItem", "showMenu", "updateMenu", "plugin-brandservice_release"})
public final class o
{
  final String TAG = "MicroMsg.MpMenuHelper";
  public WeakReference<TmplShareWebViewToolUI> lVh;
  com.tencent.mm.ui.widget.a.e mDL;
  public x ooh;
  public com.tencent.mm.plugin.brandservice.ui.timeline.video.b opy;
  final int orO;
  final int orP = 1;
  final int orQ = 2;
  final int orR = 3;
  final int orS = 4;
  final int orT = 5;
  final int orU = 6;
  final int orV = 7;
  final int orW = 8;
  final int orX = 9;
  public boolean orY;
  boolean orZ;
  public String osa = "";
  
  public final void Zm()
  {
    AppMethodBeat.i(7352);
    if (this.orZ) {
      jr(this.orY);
    }
    AppMethodBeat.o(7352);
  }
  
  public final TmplShareWebViewToolUI bRk()
  {
    AppMethodBeat.i(7355);
    Object localObject = this.lVh;
    if (localObject == null) {
      p.bcb("ui");
    }
    if (((WeakReference)localObject).get() == null)
    {
      AppMethodBeat.o(7355);
      return null;
    }
    localObject = this.lVh;
    if (localObject == null) {
      p.bcb("ui");
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
    Object localObject = this.lVh;
    if (localObject == null) {
      p.bcb("ui");
    }
    if (((WeakReference)localObject).get() != null)
    {
      localObject = this.lVh;
      if (localObject == null) {
        p.bcb("ui");
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
  
  public final void jr(final boolean paramBoolean)
  {
    AppMethodBeat.i(7353);
    this.orY = paramBoolean;
    if (!paramBoolean) {
      this.osa = "";
    }
    if (isFinished())
    {
      com.tencent.mm.sdk.platformtools.ad.i(this.TAG, "showMenu return:isFinished=%b", new Object[] { Boolean.valueOf(isFinished()) });
      AppMethodBeat.o(7353);
      return;
    }
    Object localObject2;
    n.e locale;
    if (!this.orZ)
    {
      if (paramBoolean)
      {
        localObject1 = this.opy;
        if (localObject1 == null) {
          p.bcb("controller");
        }
        if ((((com.tencent.mm.plugin.brandservice.ui.timeline.video.b)localObject1).hzl & 0x8) != 0)
        {
          localObject1 = this.opy;
          if (localObject1 == null) {
            p.bcb("controller");
          }
          if ((((com.tencent.mm.plugin.brandservice.ui.timeline.video.b)localObject1).hzl & 0x10) != 0)
          {
            localObject2 = (Context)bRk();
            localObject1 = bRk();
            if (localObject1 != null) {}
            for (localObject1 = ((TmplShareWebViewToolUI)localObject1).getString(2131766260);; localObject1 = null)
            {
              h.ci((Context)localObject2, (String)localObject1);
              AppMethodBeat.o(7353);
              return;
            }
          }
        }
        this.mDL = new com.tencent.mm.ui.widget.a.e((Context)bRk(), 1, false);
      }
    }
    else
    {
      localObject1 = this.mDL;
      if (localObject1 != null) {
        ((com.tencent.mm.ui.widget.a.e)localObject1).b((e.b)new c(this));
      }
      localObject1 = this.mDL;
      if (localObject1 != null) {
        ((com.tencent.mm.ui.widget.a.e)localObject1).a((n.d)new d(this, paramBoolean));
      }
      locale = (n.e)new g(this);
      localObject1 = this.mDL;
      if (localObject1 != null) {
        ((com.tencent.mm.ui.widget.a.e)localObject1).a(locale);
      }
      localObject1 = this.mDL;
      if (localObject1 != null) {
        ((com.tencent.mm.ui.widget.a.e)localObject1).b((n.d)new e(this, paramBoolean));
      }
      localObject1 = bRk();
      if (localObject1 == null) {
        break label570;
      }
      localObject2 = ((TmplShareWebViewToolUI)localObject1).eNy();
      label298:
      localObject1 = bRk();
      if ((localObject1 == null) || (((TmplShareWebViewToolUI)localObject1).EdY == null)) {
        break label576;
      }
    }
    label570:
    label576:
    for (Object localObject1 = com.tencent.mm.plugin.webview.ui.tools.n.aIT((String)localObject2);; localObject1 = null)
    {
      boolean bool = ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).isMpUrl((String)localObject2);
      if ((!paramBoolean) && (bool) && (localObject1 != null) && (((n.a)localObject1).isDataValid()))
      {
        localObject2 = LayoutInflater.from((Context)bRk()).inflate(2131494913, null);
        ImageView localImageView = (ImageView)((View)localObject2).findViewById(2131301214);
        Object localObject3 = (TextView)((View)localObject2).findViewById(2131306141);
        View localView = ((View)localObject2).findViewById(2131298761);
        p.g(localObject3, "nickNameTextView");
        ((TextView)localObject3).setText((CharSequence)((n.a)localObject1).EeQ);
        localObject3 = new c.a().aIZ().aJa().pH(2131231875);
        com.tencent.mm.aw.a.a.aIP().a(((n.a)localObject1).EeR, localImageView, ((c.a)localObject3).aJc());
        localView.setOnClickListener((View.OnClickListener)new f(this, (n.a)localObject1));
        com.tencent.mm.ui.tools.o.gT(localView);
        localObject1 = this.mDL;
        if (localObject1 != null) {
          ((com.tencent.mm.ui.widget.a.e)localObject1).K((View)localObject2, true);
        }
      }
      localObject1 = this.mDL;
      if (localObject1 != null) {
        ((com.tencent.mm.ui.widget.a.e)localObject1).b(locale);
      }
      localObject1 = this.mDL;
      if (localObject1 != null) {
        ((com.tencent.mm.ui.widget.a.e)localObject1).cMW();
      }
      this.orZ = true;
      AppMethodBeat.o(7353);
      return;
      this.mDL = new com.tencent.mm.ui.widget.a.e((Context)bRk(), 0, true);
      break;
      localObject2 = null;
      break label298;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(7356);
    if (this.mDL != null)
    {
      com.tencent.mm.ui.widget.a.e locale = this.mDL;
      if (locale == null) {
        p.gfZ();
      }
      if (locale.isShowing())
      {
        locale = this.mDL;
        if (locale == null) {
          p.gfZ();
        }
        locale.bpT();
      }
    }
    AppMethodBeat.o(7356);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "bundle", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "onCallback"})
  public static final class a<T>
    implements com.tencent.mm.ipcinvoker.d<Bundle>
  {
    public a(o paramo) {}
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "bundle", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class b<T>
    implements com.tencent.mm.ipcinvoker.d<Bundle>
  {
    b(o paramo, Intent paramIntent) {}
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "onDismiss"})
  static final class c
    implements e.b
  {
    c(o paramo) {}
    
    public final void onDismiss()
    {
      this.osb.orZ = false;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class d
    implements n.d
  {
    d(o paramo, boolean paramBoolean) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      AppMethodBeat.i(7347);
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(480L, 0L, 1L, false);
      paraml.clear();
      if (this.osb.bRk() == null)
      {
        AppMethodBeat.o(7347);
        return;
      }
      if (o.a(this.osb, 8))
      {
        i = this.osb.orO;
        localObject1 = this.osb.bRk();
        if (localObject1 != null)
        {
          localObject1 = ((TmplShareWebViewToolUI)localObject1).getString(2131762163);
          localObject1 = (CharSequence)localObject1;
          localObject3 = this.osb.bRk();
          if (localObject3 == null) {
            p.gfZ();
          }
          paraml.a(i, (CharSequence)localObject1, 2131690478, ((TmplShareWebViewToolUI)localObject3).getResources().getColor(2131099699), o.b(this.osb, 8));
        }
      }
      else if (o.a(this.osb, 16))
      {
        i = this.osb.orP;
        localObject1 = this.osb.bRk();
        if (localObject1 == null) {
          break label221;
        }
      }
      label221:
      for (Object localObject1 = ((TmplShareWebViewToolUI)localObject1).getString(2131762164);; localObject1 = null)
      {
        paraml.a(i, (CharSequence)localObject1, 2131689817, 0, o.b(this.osb, 16));
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
          localObject1 = this.osb.bRk();
          if (localObject1 != null)
          {
            i = localObject1.hashCode();
            ((Bundle)localObject3).putInt("WebViewShare_BinderID", i);
            localObject1 = this.osb.bRk();
            if (localObject1 == null) {
              continue;
            }
            localObject1 = ((TmplShareWebViewToolUI)localObject1).eTl();
            if (localObject1 == null) {
              continue;
            }
            localObject1 = ((MMWebView)localObject1).getUrl();
            ((Bundle)localObject3).putString("WebViewShare_wv_url", (String)localObject1);
            localObject1 = this.osb.bRk();
            if (localObject1 == null) {
              continue;
            }
            localObject1 = ((TmplShareWebViewToolUI)localObject1).lvv;
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
          com.tencent.mm.sdk.platformtools.ad.e(this.osb.TAG, "isSetHaoKan, e = " + localRemoteException1.getMessage());
          i = -1;
          continue;
          Object localObject2 = null;
          continue;
          if ((!o.a(this.osb, 0)) || (i != 1)) {
            continue;
          }
          i = this.osb.orS;
          localObject2 = this.osb.bRk();
          if (localObject2 != null)
          {
            localObject2 = ((TmplShareWebViewToolUI)localObject2).getString(2131762165);
            localObject2 = (CharSequence)localObject2;
            localObject3 = this.osb.bRk();
            if (localObject3 == null) {
              p.gfZ();
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
            if ((!o.a(this.osb, 0)) || (i != 0)) {
              continue;
            }
            i = this.osb.orR;
            localObject1 = this.osb.bRk();
            if (localObject1 == null) {
              continue;
            }
            localObject1 = ((TmplShareWebViewToolUI)localObject1).getString(2131762173);
            localObject1 = (CharSequence)localObject1;
            localObject3 = this.osb.bRk();
            if (localObject3 == null) {
              p.gfZ();
            }
            paraml.a(i, (CharSequence)localObject1, 2131689811, ((TmplShareWebViewToolUI)localObject3).getResources().getColor(2131099829));
          }
          if (o.a(this.osb, 64))
          {
            i = this.osb.orQ;
            localObject1 = this.osb.bRk();
            if (localObject1 == null) {
              continue;
            }
            localObject1 = ((TmplShareWebViewToolUI)localObject1).getString(2131761941);
            paraml.a(i, (CharSequence)localObject1, 2131689808, 0, o.b(this.osb, 64));
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
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class e
    implements n.d
  {
    e(o paramo, boolean paramBoolean) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      AppMethodBeat.i(7348);
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(480L, 0L, 1L, false);
      paraml.clear();
      if (this.osb.bRk() == null)
      {
        AppMethodBeat.o(7348);
        return;
      }
      int i;
      if (!paramBoolean)
      {
        localObject1 = this.osb.bRk();
        if (localObject1 == null) {
          p.gfZ();
        }
        if (((TmplShareWebViewToolUI)localObject1).eSw() != null)
        {
          localObject1 = this.osb.bRk();
          if (localObject1 == null) {
            p.gfZ();
          }
          localObject1 = ((TmplShareWebViewToolUI)localObject1).eSw();
          p.g(localObject1, "context()!!.webViewFloatBallHelper");
          if (((com.tencent.mm.plugin.webview.ui.tools.floatball.a)localObject1).bgA())
          {
            localObject1 = this.osb.bRk();
            if (localObject1 == null) {
              p.gfZ();
            }
            if (((TmplShareWebViewToolUI)localObject1).eSw().bKz()) {
              break label418;
            }
            i = this.osb.orW;
            localObject1 = this.osb.bRk();
            if (localObject1 == null) {
              break label413;
            }
            localObject1 = ((TmplShareWebViewToolUI)localObject1).getString(2131762178);
            paraml.a(i, (CharSequence)localObject1, 2131690574);
          }
        }
      }
      label165:
      Object localObject1 = this.osb.bRk();
      label182:
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((TmplShareWebViewToolUI)localObject1).eNy();
        localObject2 = this.osb.bRk();
        if (localObject2 == null) {
          break label495;
        }
        localObject2 = ((TmplShareWebViewToolUI)localObject2).EdY;
        label203:
        if (localObject2 == null) {
          break label501;
        }
        localObject1 = com.tencent.mm.plugin.webview.ui.tools.n.aIT((String)localObject1);
        label213:
        if ((localObject1 != null) && (((n.a)localObject1).isDataValid())) {
          break label506;
        }
        i = 1;
        label226:
        if ((o.a(this.osb, 1)) && (i != 0))
        {
          i = this.osb.orT;
          localObject1 = this.osb.bRk();
          if (localObject1 == null) {
            break label511;
          }
          localObject1 = ((TmplShareWebViewToolUI)localObject1).getString(2131766258);
          paraml.a(i, (CharSequence)localObject1, 2131690612, o.b(this.osb, 1));
        }
        label268:
        if (o.a(this.osb, 0))
        {
          i = this.osb.orV;
          localObject1 = this.osb.bRk();
          if (localObject1 == null) {
            break label516;
          }
          localObject1 = ((TmplShareWebViewToolUI)localObject1).getString(2131756596);
          label326:
          paraml.a(i, (CharSequence)localObject1, 2131690646, o.b(this.osb, 0));
        }
        if (o.a(this.osb, 32))
        {
          i = this.osb.orU;
          localObject1 = this.osb.bRk();
          if (localObject1 == null) {
            break label521;
          }
        }
      }
      label516:
      label521:
      for (localObject1 = ((TmplShareWebViewToolUI)localObject1).getString(2131766247);; localObject1 = null)
      {
        paraml.a(i, (CharSequence)localObject1, 2131690588, o.b(this.osb, 32));
        AppMethodBeat.o(7348);
        return;
        label413:
        localObject1 = null;
        break;
        label418:
        localObject1 = this.osb.bRk();
        if (localObject1 == null) {
          p.gfZ();
        }
        if (!((TmplShareWebViewToolUI)localObject1).eSw().bKz()) {
          break label165;
        }
        i = this.osb.orX;
        localObject1 = this.osb.bRk();
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
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(o paramo, n.a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(175545);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/video/util/MpMenuHelper$showMenu$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      paramView = this.osb.bRk();
      if (paramView != null)
      {
        paramView = paramView.DIg;
        if (paramView != null)
        {
          localObject = paramView.eQG();
          if (localObject != null)
          {
            paramView = this.osb.lVh;
            if (paramView == null) {
              p.bcb("ui");
            }
            paramView = (TmplShareWebViewToolUI)paramView.get();
            if (paramView == null) {
              break label225;
            }
          }
        }
      }
      label225:
      for (paramView = paramView.bQm();; paramView = null)
      {
        ((ay.d)localObject).C(new Object[] { paramView, Integer.valueOf(38), Integer.valueOf(1) }).report();
        paramView = this.osb.bRk();
        if (paramView != null)
        {
          paramView = paramView.EdR;
          if (paramView != null) {
            paramView.fP("Contact_Scene", 173);
          }
        }
        paramView = this.osb.bRk();
        if (paramView != null) {
          paramView.aIR(this.ose.hQR);
        }
        if (this.osb.mDL != null)
        {
          paramView = this.osb.mDL;
          if (paramView != null) {
            paramView.bpT();
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/video/util/MpMenuHelper$showMenu$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(175545);
        return;
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class g
    implements n.e
  {
    g(o paramo) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(7350);
      this.osb.orZ = false;
      Object localObject1 = this.osb.bRk();
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
          localObject2 = this.osb.bRk();
          if (localObject2 == null) {
            break label291;
          }
          localObject2 = ((TmplShareWebViewToolUI)localObject2).getIntent();
          if (localObject2 == null) {
            break label291;
          }
          localObject2 = ((Intent)localObject2).getStringExtra("KAppId");
          localObject3 = this.osb.bRk();
          if (localObject3 == null) {
            break label297;
          }
          localObject3 = ((TmplShareWebViewToolUI)localObject3).getIntent();
          if (localObject3 == null) {
            break label297;
          }
          localObject3 = ((Intent)localObject3).getStringExtra("srcUsername");
          p.g(paramMenuItem, "menuItem");
          paramInt = paramMenuItem.getItemId();
          if (paramInt != this.osb.orO) {
            break label315;
          }
          paramMenuItem = g.oqI;
          paramMenuItem = this.osb.bRk();
          if (paramMenuItem == null) {
            p.gfZ();
          }
          g.a((Context)paramMenuItem, o.a(this.osb), o.b(this.osb));
          paramMenuItem = this.osb.bRk();
          if (paramMenuItem == null) {
            break label308;
          }
          paramMenuItem = paramMenuItem.DIg;
          if (paramMenuItem == null) {
            break label308;
          }
          localObject4 = paramMenuItem.eQG();
          if (localObject4 == null) {
            break label308;
          }
          paramMenuItem = this.osb.bRk();
          if (paramMenuItem == null) {
            break label303;
          }
        }
      }
      label291:
      label297:
      label303:
      for (paramMenuItem = paramMenuItem.bQm();; paramMenuItem = null)
      {
        ((ay.d)localObject4).C(new Object[] { paramMenuItem, Integer.valueOf(1), Integer.valueOf(1), localObject1, localObject2, localObject3 }).report();
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
      if (paramInt == this.osb.orP)
      {
        localObject4 = this.osb;
        com.tencent.mm.sdk.platformtools.ad.i(((o)localObject4).TAG, "doTimeline");
        paramMenuItem = ((o)localObject4).lVh;
        if (paramMenuItem == null) {
          p.bcb("ui");
        }
        if (paramMenuItem.get() != null)
        {
          paramMenuItem = ((o)localObject4).lVh;
          if (paramMenuItem == null) {
            p.bcb("ui");
          }
          paramMenuItem = (TmplShareWebViewToolUI)paramMenuItem.get();
          if (paramMenuItem != null)
          {
            paramMenuItem = Boolean.valueOf(paramMenuItem.isFinishing());
            if (paramMenuItem == null) {
              p.gfZ();
            }
            if (!paramMenuItem.booleanValue()) {
              break label530;
            }
          }
        }
        else
        {
          com.tencent.mm.sdk.platformtools.ad.i(((o)localObject4).TAG, "activity finished");
          paramMenuItem = this.osb.bRk();
          if (paramMenuItem == null) {
            break label1339;
          }
          paramMenuItem = paramMenuItem.DIg;
          if (paramMenuItem == null) {
            break label1339;
          }
          localObject4 = paramMenuItem.eQG();
          if (localObject4 == null) {
            break label1339;
          }
          paramMenuItem = this.osb.bRk();
          if (paramMenuItem == null) {
            break label1334;
          }
        }
        for (paramMenuItem = paramMenuItem.bQm();; paramMenuItem = null)
        {
          ((ay.d)localObject4).C(new Object[] { paramMenuItem, Integer.valueOf(2), Integer.valueOf(1), localObject1, localObject2, localObject3 }).report();
          AppMethodBeat.o(7350);
          return;
          paramMenuItem = null;
          break;
          Intent localIntent = new Intent();
          paramMenuItem = ((o)localObject4).ooh;
          if (paramMenuItem == null) {
            p.bcb("msgInfo");
          }
          int i = paramMenuItem.hDg.videoWidth;
          paramInt = i;
          if (i <= 0) {
            paramInt = 150;
          }
          localIntent.putExtra("Ksnsupload_width", paramInt);
          localIntent.putExtra("Ksnsupload_height", paramInt);
          paramMenuItem = ((o)localObject4).opy;
          if (paramMenuItem == null) {
            p.bcb("controller");
          }
          Object localObject5;
          if (paramMenuItem.bRl())
          {
            paramMenuItem = ((o)localObject4).opy;
            if (paramMenuItem == null) {
              p.bcb("controller");
            }
            paramMenuItem = paramMenuItem.oon;
            if (paramMenuItem != null)
            {
              paramMenuItem = paramMenuItem.title;
              localIntent.putExtra("Ksnsupload_title", paramMenuItem);
              paramMenuItem = ((o)localObject4).opy;
              if (paramMenuItem == null) {
                p.bcb("controller");
              }
              paramMenuItem = paramMenuItem.oon;
              if (paramMenuItem == null) {
                break label1164;
              }
              paramMenuItem = paramMenuItem.hDm;
              localIntent.putExtra("Ksnsupload_imgurl", paramMenuItem);
              paramMenuItem = ((o)localObject4).opy;
              if (paramMenuItem == null) {
                p.bcb("controller");
              }
              localIntent.putExtra("Ksnsupload_link", paramMenuItem.url);
              paramMenuItem = ((o)localObject4).ooh;
              if (paramMenuItem == null) {
                p.bcb("msgInfo");
              }
              paramMenuItem = paramMenuItem.hDf;
              localObject5 = ((o)localObject4).ooh;
              if (localObject5 == null) {
                p.bcb("msgInfo");
              }
              if (bt.isNullOrNil(((x)localObject5).doK)) {
                break label1232;
              }
              localObject5 = ((o)localObject4).ooh;
              if (localObject5 == null) {
                p.bcb("msgInfo");
              }
              localIntent.putExtra("src_username", ((x)localObject5).doK);
              localObject5 = ((o)localObject4).ooh;
              if (localObject5 == null) {
                p.bcb("msgInfo");
              }
              localIntent.putExtra("src_displayname", ((x)localObject5).hDe);
              localIntent.putExtra("Ksnsupload_type", 1);
              localObject5 = ((o)localObject4).opy;
              if (localObject5 == null) {
                p.bcb("controller");
              }
              localIntent.putExtra("ShareUrlOriginal", ((com.tencent.mm.plugin.brandservice.ui.timeline.video.b)localObject5).url);
              localIntent.putExtra("KPublisherId", paramMenuItem);
              localIntent.putExtra("need_result", true);
              localObject5 = ((o)localObject4).opy;
              if (localObject5 == null) {
                p.bcb("controller");
              }
              if (!((com.tencent.mm.plugin.brandservice.ui.timeline.video.b)localObject5).bRl()) {
                break label1297;
              }
              localObject5 = ((o)localObject4).opy;
              if (localObject5 == null) {
                p.bcb("controller");
              }
              if (((com.tencent.mm.plugin.brandservice.ui.timeline.video.b)localObject5).oon != null)
              {
                localObject5 = ((o)localObject4).opy;
                if (localObject5 == null) {
                  p.bcb("controller");
                }
                localObject5 = ((com.tencent.mm.plugin.brandservice.ui.timeline.video.b)localObject5).oon;
                if (localObject5 == null) {
                  p.gfZ();
                }
                if (((bxp)localObject5).hDo != null)
                {
                  localObject5 = ((o)localObject4).opy;
                  if (localObject5 == null) {
                    p.bcb("controller");
                  }
                  localObject5 = ((com.tencent.mm.plugin.brandservice.ui.timeline.video.b)localObject5).oon;
                  if (localObject5 == null) {
                    p.gfZ();
                  }
                  localIntent.putExtra("ksnsupload_link_desc", ((bxp)localObject5).hDo);
                }
              }
            }
          }
          for (;;)
          {
            paramMenuItem = y.AH(paramMenuItem);
            localIntent.putExtra("reportSessionId", paramMenuItem);
            localObject5 = ((o)localObject4).lVh;
            if (localObject5 == null) {
              p.bcb("ui");
            }
            localObject5 = ((WeakReference)localObject5).get();
            if (localObject5 == null) {
              p.gfZ();
            }
            localIntent.putExtra("BizVideoDetailUIExtras", ((TmplShareWebViewToolUI)localObject5).getIntent().getExtras());
            localObject5 = f.oqH;
            localObject5 = ((o)localObject4).ooh;
            if (localObject5 == null) {
              p.bcb("msgInfo");
            }
            com.tencent.mm.plugin.brandservice.ui.timeline.video.b localb = ((o)localObject4).opy;
            if (localb == null) {
              p.bcb("controller");
            }
            p.g(paramMenuItem, "sessionId");
            f.a((x)localObject5, localb, paramMenuItem, (com.tencent.mm.ipcinvoker.d)new o.b((o)localObject4, localIntent));
            break;
            paramMenuItem = null;
            break label641;
            paramMenuItem = null;
            break label679;
            paramMenuItem = ((o)localObject4).ooh;
            if (paramMenuItem == null) {
              p.bcb("msgInfo");
            }
            localIntent.putExtra("Ksnsupload_title", paramMenuItem.hDg.title);
            paramMenuItem = ((o)localObject4).ooh;
            if (paramMenuItem == null) {
              p.bcb("msgInfo");
            }
            localIntent.putExtra("Ksnsupload_imgurl", paramMenuItem.hDg.hDm);
            break label688;
            label1232:
            localObject5 = ((o)localObject4).ooh;
            if (localObject5 == null) {
              p.bcb("msgInfo");
            }
            localIntent.putExtra("src_username", ((x)localObject5).VS());
            localObject5 = ((o)localObject4).ooh;
            if (localObject5 == null) {
              p.bcb("msgInfo");
            }
            localIntent.putExtra("src_displayname", ((x)localObject5).hDe);
            break label825;
            localObject5 = ((o)localObject4).ooh;
            if (localObject5 == null) {
              p.bcb("msgInfo");
            }
            localIntent.putExtra("ksnsupload_link_desc", ((x)localObject5).hDg.hDo);
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
      if (paramInt == this.osb.orQ)
      {
        paramMenuItem = this.osb.bRk();
        if (paramMenuItem != null)
        {
          paramMenuItem = paramMenuItem.DIg;
          if (paramMenuItem != null)
          {
            localObject1 = paramMenuItem.eQG();
            if (localObject1 != null)
            {
              paramMenuItem = this.osb.bRk();
              if (paramMenuItem == null) {
                break label1553;
              }
              paramMenuItem = paramMenuItem.bQm();
              ((ay.d)localObject1).C(new Object[] { paramMenuItem, Integer.valueOf(3), Integer.valueOf(1) }).report();
            }
          }
        }
        localObject1 = this.osb;
        paramMenuItem = e.oqG;
        paramMenuItem = ((o)localObject1).ooh;
        if (paramMenuItem == null) {
          p.bcb("msgInfo");
        }
        localObject2 = ((o)localObject1).opy;
        if (localObject2 == null) {
          p.bcb("controller");
        }
        e.a(paramMenuItem, (com.tencent.mm.plugin.brandservice.ui.timeline.video.b)localObject2);
        localObject2 = (Context)((o)localObject1).bRk();
        paramMenuItem = ((o)localObject1).bRk();
        if (paramMenuItem != null) {}
        for (paramMenuItem = paramMenuItem.getString(2131758936);; paramMenuItem = null)
        {
          h.ci((Context)localObject2, paramMenuItem);
          paramMenuItem = ((o)localObject1).opy;
          if (paramMenuItem == null) {
            p.bcb("controller");
          }
          paramMenuItem.ooc.aH(24, "");
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
      if (paramInt == this.osb.orT)
      {
        paramMenuItem = this.osb.bRk();
        if (paramMenuItem != null)
        {
          paramMenuItem = paramMenuItem.DIg;
          if (paramMenuItem != null)
          {
            localObject1 = paramMenuItem.eQG();
            if (localObject1 != null)
            {
              paramMenuItem = this.osb.bRk();
              if (paramMenuItem == null) {
                break label1742;
              }
            }
          }
        }
        label1742:
        for (paramMenuItem = paramMenuItem.bQm();; paramMenuItem = null)
        {
          ((ay.d)localObject1).C(new Object[] { paramMenuItem, Integer.valueOf(4), Integer.valueOf(1) }).report();
          localObject1 = this.osb;
          paramMenuItem = ((o)localObject1).opy;
          if (paramMenuItem == null) {
            p.bcb("controller");
          }
          if ((paramMenuItem.hzl & 0x1) == 0) {
            break;
          }
          paramMenuItem = ((o)localObject1).TAG;
          localObject2 = new StringBuilder("not allow jump to profile ");
          localObject1 = ((o)localObject1).opy;
          if (localObject1 == null) {
            p.bcb("controller");
          }
          com.tencent.mm.sdk.platformtools.ad.w(paramMenuItem, ((com.tencent.mm.plugin.brandservice.ui.timeline.video.b)localObject1).hzl);
          AppMethodBeat.o(7350);
          return;
        }
        if (((o)localObject1).bRk() != null)
        {
          paramMenuItem = ((o)localObject1).bRk();
          if (paramMenuItem == null) {
            break label1781;
          }
        }
        label1781:
        for (paramMenuItem = paramMenuItem.EdR; paramMenuItem == null; paramMenuItem = null)
        {
          AppMethodBeat.o(7350);
          return;
        }
        paramMenuItem = ((o)localObject1).bRk();
        if (paramMenuItem != null)
        {
          paramMenuItem = paramMenuItem.EdR;
          if (paramMenuItem != null) {
            paramMenuItem.fP("Contact_Scene", 153);
          }
        }
        paramMenuItem = ((o)localObject1).bRk();
        if (paramMenuItem != null)
        {
          localObject1 = ((o)localObject1).opy;
          if (localObject1 == null) {
            p.bcb("controller");
          }
          paramMenuItem.aIR(((com.tencent.mm.plugin.brandservice.ui.timeline.video.b)localObject1).VS());
          AppMethodBeat.o(7350);
          return;
        }
        AppMethodBeat.o(7350);
        return;
      }
      label1553:
      if (paramInt == this.osb.orR)
      {
        paramMenuItem = this.osb.bRk();
        if (paramMenuItem != null)
        {
          paramMenuItem = paramMenuItem.DIg;
          if (paramMenuItem != null)
          {
            localObject1 = paramMenuItem.eQG();
            if (localObject1 != null)
            {
              paramMenuItem = this.osb.bRk();
              if (paramMenuItem == null) {
                break label2000;
              }
            }
          }
        }
        label2000:
        for (paramMenuItem = paramMenuItem.bQm();; paramMenuItem = null)
        {
          ((ay.d)localObject1).C(new Object[] { paramMenuItem, Integer.valueOf(36), Integer.valueOf(1) }).report();
          com.tencent.mm.plugin.webview.j.g.a((Context)this.osb.bRk(), o.a(this.osb).hDg.title, (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(7349);
              if (paramAnonymousDialogInterface == null) {}
              for (paramAnonymousDialogInterface = "";; paramAnonymousDialogInterface = ((com.tencent.mm.ui.widget.a.d)paramAnonymousDialogInterface).fLY())
              {
                Object localObject = this.osf.osb.bRk();
                if (localObject == null) {
                  break;
                }
                localObject = ((TmplShareWebViewToolUI)localObject).DzP;
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
      if (paramInt == this.osb.orS)
      {
        paramMenuItem = this.osb.bRk();
        if (paramMenuItem != null)
        {
          paramMenuItem = paramMenuItem.DIg;
          if (paramMenuItem != null)
          {
            localObject1 = paramMenuItem.eQG();
            if (localObject1 != null)
            {
              paramMenuItem = this.osb.bRk();
              if (paramMenuItem == null) {
                break label2133;
              }
            }
          }
        }
        label2133:
        for (paramMenuItem = paramMenuItem.bQm();; paramMenuItem = null)
        {
          ((ay.d)localObject1).C(new Object[] { paramMenuItem, Integer.valueOf(37), Integer.valueOf(1) }).report();
          paramMenuItem = this.osb.bRk();
          if (paramMenuItem == null) {
            break;
          }
          paramMenuItem = paramMenuItem.DzP;
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
      if (paramInt == this.osb.orU)
      {
        paramMenuItem = this.osb.bRk();
        if (paramMenuItem != null)
        {
          paramMenuItem = paramMenuItem.DIg;
          if (paramMenuItem != null)
          {
            localObject1 = paramMenuItem.eQG();
            if (localObject1 != null)
            {
              paramMenuItem = this.osb.bRk();
              if (paramMenuItem == null) {
                break label2267;
              }
            }
          }
        }
        label2267:
        for (paramMenuItem = paramMenuItem.bQm();; paramMenuItem = null)
        {
          ((ay.d)localObject1).C(new Object[] { paramMenuItem, Integer.valueOf(5), Integer.valueOf(1) }).report();
          localObject1 = this.osb;
          if (!((o)localObject1).isFinished()) {
            break;
          }
          com.tencent.mm.sdk.platformtools.ad.e(((o)localObject1).TAG, "copyLink fail, is finish");
          AppMethodBeat.o(7350);
          return;
        }
        paramMenuItem = ((o)localObject1).bRk();
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
              localObject2 = ((o)localObject1).opy;
              if (localObject2 == null) {
                p.bcb("controller");
              }
              paramMenuItem.setText((CharSequence)((com.tencent.mm.plugin.brandservice.ui.timeline.video.b)localObject2).oob);
              localObject2 = (Context)((o)localObject1).bRk();
              paramMenuItem = ((o)localObject1).bRk();
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
              com.tencent.mm.sdk.platformtools.ad.printErrStackTrace(((o)localObject1).TAG, (Throwable)paramMenuItem, "clip.setText error", new Object[0]);
              AppMethodBeat.o(7350);
              return;
            }
            paramMenuItem = null;
          }
        }
        com.tencent.mm.sdk.platformtools.ad.e(((o)localObject1).TAG, "clipboard manager is null");
        AppMethodBeat.o(7350);
        return;
      }
      if (paramInt == this.osb.orV)
      {
        paramMenuItem = this.osb.bRk();
        if (paramMenuItem != null)
        {
          paramMenuItem = paramMenuItem.DIg;
          if (paramMenuItem != null)
          {
            localObject1 = paramMenuItem.eQG();
            if (localObject1 != null)
            {
              paramMenuItem = this.osb.bRk();
              if (paramMenuItem == null) {
                break label2898;
              }
              paramMenuItem = paramMenuItem.bQm();
              ((ay.d)localObject1).C(new Object[] { paramMenuItem, Integer.valueOf(11), Integer.valueOf(1) }).report();
            }
          }
        }
        localObject2 = this.osb;
        paramMenuItem = ((o)localObject2).ooh;
        if (paramMenuItem == null) {
          p.bcb("msgInfo");
        }
        localObject3 = paramMenuItem.hDg.url;
        paramMenuItem = null;
        if (!bt.isNullOrNil((String)localObject3))
        {
          paramMenuItem = Uri.parse((String)localObject3);
          p.g(paramMenuItem, "uri");
          paramMenuItem = paramMenuItem.getHost();
        }
        if (!bt.isNullOrNil(paramMenuItem))
        {
          if (paramMenuItem == null) {
            p.gfZ();
          }
          if (!d.n.n.nz(paramMenuItem, "mp.weixin.qq.com")) {}
        }
      }
      label3254:
      for (;;)
      {
        try
        {
          paramMenuItem = d.g.b.ad.MLZ;
          paramMenuItem = String.format("https://mp.weixin.qq.com/mp/infringement?url=%s#wechat_redirect", Arrays.copyOf(new Object[] { q.encode((String)localObject3, "utf-8") }, 1));
          p.g(paramMenuItem, "java.lang.String.format(format, *args)");
          if (!bt.isNullOrNil(paramMenuItem)) {
            break label3254;
          }
          paramMenuItem = d.g.b.ad.MLZ;
          paramMenuItem = String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", Arrays.copyOf(new Object[] { Integer.valueOf(34) }, 1));
          p.g(paramMenuItem, "java.lang.String.format(format, *args)");
          localObject4 = new Intent();
        }
        catch (UnsupportedEncodingException paramMenuItem)
        {
          label2898:
          com.tencent.mm.sdk.platformtools.ad.e(((o)localObject2).TAG, paramMenuItem.getMessage());
        }
        try
        {
          localObject1 = ((o)localObject2).bRk();
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
          localObject1 = p.C((String)localObject1, "/screenshot.jpg");
          com.tencent.mm.sdk.platformtools.g.a(bh.aV((Activity)((o)localObject2).bRk()), 75, Bitmap.CompressFormat.JPEG, (String)localObject1, true);
          ((Intent)localObject4).putExtra("k_webview_img", (String)localObject1);
        }
        catch (IOException localIOException)
        {
          com.tencent.mm.sdk.platformtools.ad.e(((o)localObject2).TAG, "[oneliang]save screen shot to file error, ex = " + localIOException.getMessage());
          continue;
        }
        ((Intent)localObject4).putExtra("rawUrl", paramMenuItem);
        ((Intent)localObject4).putExtra("k_expose_url", (String)localObject3);
        paramMenuItem = ((o)localObject2).opy;
        if (paramMenuItem == null) {
          p.bcb("controller");
        }
        ((Intent)localObject4).putExtra("k_expose_web_scene", paramMenuItem.scene);
        ((Intent)localObject4).putExtra("showShare", false);
        com.tencent.mm.bs.d.b((Context)((o)localObject2).bRk(), "webview", ".ui.tools.WebViewUI", (Intent)localObject4);
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
        if (paramInt == this.osb.orW)
        {
          paramMenuItem = this.osb.bRk();
          if (paramMenuItem == null) {
            p.gfZ();
          }
          paramMenuItem = paramMenuItem.DIg;
          if (paramMenuItem == null) {
            p.gfZ();
          }
          paramMenuItem = paramMenuItem.eQG();
          localTmplShareWebViewToolUI = this.osb.bRk();
          if (localTmplShareWebViewToolUI == null) {
            p.gfZ();
          }
          paramMenuItem.C(new Object[] { localTmplShareWebViewToolUI.bQm(), Integer.valueOf(33), Integer.valueOf(1) }).report();
          paramMenuItem = this.osb.bRk();
          if (paramMenuItem == null) {
            p.gfZ();
          }
          paramMenuItem.eSw().gf(true);
          AppMethodBeat.o(7350);
          return;
        }
        if (paramInt == this.osb.orX)
        {
          paramMenuItem = this.osb.bRk();
          if (paramMenuItem == null) {
            p.gfZ();
          }
          paramMenuItem = paramMenuItem.DIg;
          if (paramMenuItem == null) {
            p.gfZ();
          }
          paramMenuItem = paramMenuItem.eQG();
          localTmplShareWebViewToolUI = this.osb.bRk();
          if (localTmplShareWebViewToolUI == null) {
            p.gfZ();
          }
          paramMenuItem.C(new Object[] { localTmplShareWebViewToolUI.bQm(), Integer.valueOf(34), Integer.valueOf(1) }).report();
          paramMenuItem = this.osb.bRk();
          if (paramMenuItem == null) {
            p.gfZ();
          }
          paramMenuItem.eSw().gf(false);
          AppMethodBeat.o(7350);
          return;
        }
        com.tencent.mm.sdk.platformtools.ad.w(this.osb.TAG, "wrong id: " + paramMenuItem.getItemId());
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