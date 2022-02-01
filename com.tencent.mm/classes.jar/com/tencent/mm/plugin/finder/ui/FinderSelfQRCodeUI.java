package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.loader.d;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.api.b.a;
import com.tencent.mm.plugin.finder.cgi.z;
import com.tencent.mm.plugin.finder.loader.h;
import com.tencent.mm.plugin.finder.loader.h.a;
import com.tencent.mm.plugin.finder.utils.g.a;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.aks;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.a.e.b;
import d.v;
import d.y;
import java.util.HashMap;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/ui/FinderSelfQRCodeUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "MENU_ID_MORE_BTN", "", "MENU_ID_SAVE_TO_GALLERY", "MENU_ID_SHARE_TO_FRIEND", "TAG", "", "authIcon", "Landroid/widget/ImageView;", "authJob", "Landroid/widget/TextView;", "avatarIv", "loading", "Landroid/widget/ProgressBar;", "nickTv", "qrcode", "qrcodeContainer", "Landroid/view/View;", "refreshArea", "refreshIcon", "doExportImg", "", "filePath", "doGetQRCodeScene", "username", "genQRCodeBitmap", "Landroid/graphics/Bitmap;", "url", "getCommentScene", "getLayoutId", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class FinderSelfQRCodeUI
  extends MMFinderUI
  implements com.tencent.mm.al.g
{
  private final String TAG = "Finder.FinderSelfQRCodeUI";
  private HashMap _$_findViewCache;
  private ImageView fuj;
  private TextView inR;
  private ProgressBar kuP;
  private View nvH;
  private ImageView qAi;
  private TextView qKL;
  private final int qPA = 100001;
  private final int qPB = 100002;
  private final int qPC = 100003;
  private ImageView qPx;
  private View qPy;
  private ImageView qPz;
  
  private final void ZD(String paramString)
  {
    AppMethodBeat.i(167577);
    Object localObject = this.kuP;
    if (localObject == null) {
      d.g.b.k.aPZ("loading");
    }
    ((ProgressBar)localObject).setVisibility(0);
    localObject = this.qPy;
    if (localObject == null) {
      d.g.b.k.aPZ("refreshArea");
    }
    ((View)localObject).setVisibility(8);
    paramString = new z(paramString);
    com.tencent.mm.kernel.g.aeS().b((n)paramString);
    AppMethodBeat.o(167577);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(199369);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(199369);
    return localView1;
  }
  
  public final int getCommentScene()
  {
    return 10;
  }
  
  public final int getLayoutId()
  {
    return 2131494107;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(167576);
    Object localObject1 = findViewById(2131299971);
    d.g.b.k.g(localObject1, "findViewById(R.id.finder_avatar)");
    this.fuj = ((ImageView)localObject1);
    localObject1 = findViewById(2131300017);
    d.g.b.k.g(localObject1, "findViewById(R.id.finder_nickname)");
    this.inR = ((TextView)localObject1);
    localObject1 = findViewById(2131296977);
    d.g.b.k.g(localObject1, "findViewById(R.id.auth_icon)");
    this.qAi = ((ImageView)localObject1);
    localObject1 = findViewById(2131296980);
    d.g.b.k.g(localObject1, "findViewById(R.id.auth_job)");
    this.qKL = ((TextView)localObject1);
    localObject1 = findViewById(2131300062);
    d.g.b.k.g(localObject1, "findViewById(R.id.finder_qrcode)");
    this.qPx = ((ImageView)localObject1);
    localObject1 = findViewById(2131303615);
    d.g.b.k.g(localObject1, "findViewById(R.id.qrcode_container)");
    this.nvH = ((View)localObject1);
    localObject1 = findViewById(2131301509);
    d.g.b.k.g(localObject1, "findViewById(R.id.loading_progress_bar)");
    this.kuP = ((ProgressBar)localObject1);
    localObject1 = findViewById(2131300063);
    d.g.b.k.g(localObject1, "findViewById(R.id.finder_refresh_qrcode)");
    this.qPy = ((View)localObject1);
    localObject1 = findViewById(2131300064);
    d.g.b.k.g(localObject1, "findViewById(R.id.finder_refresh_qrcode_icon)");
    this.qPz = ((ImageView)localObject1);
    localObject1 = com.tencent.mm.plugin.finder.api.b.qnX;
    localObject1 = u.aqO();
    d.g.b.k.g(localObject1, "ConfigStorageLogic.getMyFinderUsername()");
    final com.tencent.mm.plugin.finder.api.f localf = b.a.YL((String)localObject1);
    if (localf != null)
    {
      localObject1 = h.qCF;
      localObject1 = h.cmV();
      Object localObject2 = new com.tencent.mm.plugin.finder.loader.a(localf.cks());
      Object localObject3 = this.fuj;
      if (localObject3 == null) {
        d.g.b.k.aPZ("avatarIv");
      }
      h localh = h.qCF;
      ((d)localObject1).a(localObject2, (ImageView)localObject3, h.a(h.a.qCI));
      localObject1 = this.inR;
      if (localObject1 == null) {
        d.g.b.k.aPZ("nickTv");
      }
      ((TextView)localObject1).setText((CharSequence)localf.Su());
      localObject1 = localf.field_authInfo;
      int i;
      if (localObject1 != null)
      {
        i = ((FinderAuthInfo)localObject1).authIconType;
        localObject1 = this.qKL;
        if (localObject1 == null) {
          d.g.b.k.aPZ("authJob");
        }
        ((TextView)localObject1).setVisibility(8);
        if (i <= 0) {
          break label798;
        }
        switch (i)
        {
        }
      }
      for (;;)
      {
        com.tencent.mm.kernel.g.aeS().a(258, (com.tencent.mm.al.g)this);
        ZD(localf.getUsername());
        localObject1 = this.qPz;
        if (localObject1 == null) {
          d.g.b.k.aPZ("refreshIcon");
        }
        ((ImageView)localObject1).setOnClickListener((View.OnClickListener)new b(this, localf));
        localObject1 = new com.tencent.mm.ui.widget.a.e((Context)this, 1, false);
        ((com.tencent.mm.ui.widget.a.e)localObject1).a((n.c)new c(this, localf));
        ((com.tencent.mm.ui.widget.a.e)localObject1).a((n.d)new d(this, localf));
        ((com.tencent.mm.ui.widget.a.e)localObject1).b((e.b)e.qPF);
        addIconOptionMenu(this.qPA, 2131230845, (MenuItem.OnMenuItemClickListener)new f((com.tencent.mm.ui.widget.a.e)localObject1));
        AppMethodBeat.o(167576);
        return;
        i = 0;
        break;
        localObject1 = this.qAi;
        if (localObject1 == null) {
          d.g.b.k.aPZ("authIcon");
        }
        ((ImageView)localObject1).setVisibility(0);
        localObject1 = this.qKL;
        if (localObject1 == null) {
          d.g.b.k.aPZ("authJob");
        }
        ((TextView)localObject1).setVisibility(0);
        localObject1 = this.qAi;
        if (localObject1 == null) {
          d.g.b.k.aPZ("authIcon");
        }
        localObject2 = (Context)getContext();
        localObject3 = getContext();
        d.g.b.k.g(localObject3, "context");
        ((ImageView)localObject1).setImageDrawable(am.i((Context)localObject2, 2131690481, ((AppCompatActivity)localObject3).getResources().getColor(2131099777)));
        localObject2 = this.qKL;
        if (localObject2 == null) {
          d.g.b.k.aPZ("authJob");
        }
        localObject1 = localf.field_authInfo;
        if (localObject1 != null)
        {
          localObject1 = ((FinderAuthInfo)localObject1).authProfession;
          if (localObject1 == null) {}
        }
        for (localObject1 = (CharSequence)localObject1;; localObject1 = (CharSequence)"")
        {
          ((TextView)localObject2).setText((CharSequence)localObject1);
          break;
        }
        localObject1 = this.qAi;
        if (localObject1 == null) {
          d.g.b.k.aPZ("authIcon");
        }
        ((ImageView)localObject1).setVisibility(0);
        localObject1 = this.qAi;
        if (localObject1 == null) {
          d.g.b.k.aPZ("authIcon");
        }
        localObject2 = (Context)getContext();
        localObject3 = getContext();
        d.g.b.k.g(localObject3, "context");
        ((ImageView)localObject1).setImageDrawable(am.i((Context)localObject2, 2131690481, ((AppCompatActivity)localObject3).getResources().getColor(2131099689)));
        continue;
        localObject1 = this.qAi;
        if (localObject1 == null) {
          d.g.b.k.aPZ("authIcon");
        }
        ((ImageView)localObject1).setVisibility(8);
        localObject1 = this.qKL;
        if (localObject1 == null) {
          d.g.b.k.aPZ("authJob");
        }
        ((TextView)localObject1).setVisibility(8);
        continue;
        label798:
        localObject1 = this.qAi;
        if (localObject1 == null) {
          d.g.b.k.aPZ("authIcon");
        }
        ((ImageView)localObject1).setVisibility(8);
        localObject1 = this.qKL;
        if (localObject1 == null) {
          d.g.b.k.aPZ("authJob");
        }
        ((TextView)localObject1).setVisibility(8);
      }
    }
    AppMethodBeat.o(167576);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167575);
    super.onCreate(paramBundle);
    setMMTitle("");
    initView();
    setBackBtn((MenuItem.OnMenuItemClickListener)new FinderSelfQRCodeUI.g(this));
    AppMethodBeat.o(167575);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(167578);
    super.onDestroy();
    com.tencent.mm.kernel.g.aeS().b(258, (com.tencent.mm.al.g)this);
    AppMethodBeat.o(167578);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(167579);
    ad.i(this.TAG, "errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
    ProgressBar localProgressBar = this.kuP;
    if (localProgressBar == null) {
      d.g.b.k.aPZ("loading");
    }
    localProgressBar.setVisibility(8);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramn == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderQRCode");
        AppMethodBeat.o(167579);
        throw paramString;
      }
      paramString = ((z)paramn).qpm;
      if (paramString != null) {}
      for (paramString = paramString.auM(); paramString == null; paramString = null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderQRCodeResponse");
        AppMethodBeat.o(167579);
        throw paramString;
      }
      paramString = ((aks)paramString).Dmn;
      if (paramString != null)
      {
        paramString = paramString.getBytes();
        paramString = com.tencent.mm.sdk.platformtools.f.cl(paramString);
        ad.i(this.TAG, "qrcode url " + ((z)paramn).ckW());
        if (paramString != null) {
          break label461;
        }
        if (bt.isNullOrNil(((z)paramn).ckW())) {
          break label458;
        }
        paramString = ((z)paramn).ckW();
        if (paramString == null) {
          d.g.b.k.fvU();
        }
        paramn = c.vL(u.aqO());
        d.g.b.k.g(paramn, "avatarBitmap");
        paramn = com.tencent.mm.sdk.platformtools.f.a(paramn, false, 0.5F * paramn.getWidth());
        float f = ao.ap((Context)this, 2131165299);
        d.g.b.k.g(paramn, "tempBitmap");
        f = f * 1.0F / paramn.getWidth();
        paramn = com.tencent.mm.sdk.platformtools.f.c(com.tencent.mm.sdk.platformtools.f.b(paramn, 0.0F, f, f), com.tencent.mm.sdk.platformtools.f.B(getResources().getDrawable(2131232371)));
        paramString = com.tencent.mm.bz.a.a.b((Context)this, paramn, paramString);
        label345:
        paramn = y.JfV;
      }
    }
    label458:
    label461:
    for (;;)
    {
      if (paramString != null)
      {
        paramn = this.qPx;
        if (paramn == null) {
          d.g.b.k.aPZ("qrcode");
        }
        paramn.setImageBitmap(paramString);
        AppMethodBeat.o(167579);
        return;
        paramString = null;
        break;
      }
      AppMethodBeat.o(167579);
      return;
      paramn = this.qPy;
      if (paramn == null) {
        d.g.b.k.aPZ("refreshArea");
      }
      paramn.setVisibility(0);
      if (bt.isNullOrNil(paramString)) {
        paramString = getString(2131760707);
      }
      for (;;)
      {
        t.makeText((Context)this, (CharSequence)paramString, 1).show();
        AppMethodBeat.o(167579);
        return;
      }
      break label345;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/ui/FinderSelfQRCodeUI$initView$1$1"})
  static final class b
    implements View.OnClickListener
  {
    b(FinderSelfQRCodeUI paramFinderSelfQRCodeUI, com.tencent.mm.plugin.finder.api.f paramf) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167569);
      FinderSelfQRCodeUI.a(this.qPD, localf.getUsername());
      AppMethodBeat.o(167569);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu", "com/tencent/mm/plugin/finder/ui/FinderSelfQRCodeUI$initView$1$2"})
  static final class c
    implements n.c
  {
    c(FinderSelfQRCodeUI paramFinderSelfQRCodeUI, com.tencent.mm.plugin.finder.api.f paramf) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      AppMethodBeat.i(167570);
      d.g.b.k.g(paraml, "it");
      if (paraml.eSQ())
      {
        paraml.jj(FinderSelfQRCodeUI.a(this.qPD), 2131759322);
        paraml.jj(FinderSelfQRCodeUI.b(this.qPD), 2131759331);
      }
      AppMethodBeat.o(167570);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected", "com/tencent/mm/plugin/finder/ui/FinderSelfQRCodeUI$initView$1$3"})
  static final class d
    implements n.d
  {
    d(FinderSelfQRCodeUI paramFinderSelfQRCodeUI, com.tencent.mm.plugin.finder.api.f paramf) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(167571);
      d.g.b.k.g(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      if (paramInt == FinderSelfQRCodeUI.a(this.qPD))
      {
        g.a.a(com.tencent.mm.plugin.finder.utils.g.qSw, (MMActivity)this.qPD, localf);
        AppMethodBeat.o(167571);
        return;
      }
      if (paramInt == FinderSelfQRCodeUI.b(this.qPD))
      {
        paramMenuItem = com.tencent.mm.sdk.platformtools.f.fy(FinderSelfQRCodeUI.c(this.qPD));
        if (paramMenuItem != null)
        {
          Object localObject = com.tencent.mm.plugin.finder.utils.k.qTp;
          localObject = com.tencent.mm.plugin.finder.utils.k.csa();
          com.tencent.mm.sdk.platformtools.f.a(paramMenuItem, 80, Bitmap.CompressFormat.JPEG, (String)localObject, true);
          FinderSelfQRCodeUI.b(this.qPD, (String)localObject);
          com.tencent.mm.plugin.report.e.vIY.idkeyStat(1278L, 7L, 1L, false);
          paramMenuItem = com.tencent.mm.plugin.finder.report.b.qFq;
          paramMenuItem = u.aqO();
          d.g.b.k.g(paramMenuItem, "ConfigStorageLogic.getMyFinderUsername()");
          com.tencent.mm.plugin.finder.report.b.Zi(paramMenuItem);
        }
      }
      AppMethodBeat.o(167571);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "onDismiss"})
  static final class e
    implements e.b
  {
    public static final e qPF;
    
    static
    {
      AppMethodBeat.i(167572);
      qPF = new e();
      AppMethodBeat.o(167572);
    }
    
    public final void onDismiss() {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class f
    implements MenuItem.OnMenuItemClickListener
  {
    f(com.tencent.mm.ui.widget.a.e parame) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167573);
      this.qBK.csG();
      AppMethodBeat.o(167573);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSelfQRCodeUI
 * JD-Core Version:    0.7.0.1
 */