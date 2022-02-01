package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.loader.d;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.cgi.ay;
import com.tencent.mm.plugin.finder.loader.i;
import com.tencent.mm.plugin.finder.loader.i.a;
import com.tencent.mm.plugin.finder.report.h;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.plugin.finder.utils.m.a;
import com.tencent.mm.plugin.finder.utils.r;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.aqq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.a.e.b;
import d.v;
import d.z;
import java.util.HashMap;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/ui/FinderSelfQRCodeUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "MENU_ID_MORE_BTN", "", "MENU_ID_SAVE_TO_GALLERY", "MENU_ID_SHARE_TO_FRIEND", "TAG", "", "authIcon", "Landroid/widget/ImageView;", "authJob", "Landroid/widget/TextView;", "avatarIv", "loading", "Landroid/widget/ProgressBar;", "nickTv", "qrcode", "qrcodeContainer", "Landroid/view/View;", "refreshArea", "refreshIcon", "doExportImg", "", "filePath", "doGetQRCodeScene", "username", "genQRCodeBitmap", "Landroid/graphics/Bitmap;", "url", "getCommentScene", "getLayoutId", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class FinderSelfQRCodeUI
  extends MMFinderUI
  implements f
{
  private final String TAG = "Finder.FinderSelfQRCodeUI";
  private HashMap _$_findViewCache;
  private ImageView fRd;
  private TextView jhg;
  private ProgressBar ltc;
  private View oCb;
  private final int rMB = 100002;
  private TextView sEx;
  private ImageView sGc;
  private View sGd;
  private ImageView sGe;
  private final int sGf = 100001;
  private final int sGg = 100003;
  private ImageView sgf;
  
  private final void aiJ(String paramString)
  {
    AppMethodBeat.i(167577);
    Object localObject = this.ltc;
    if (localObject == null) {
      d.g.b.p.bcb("loading");
    }
    ((ProgressBar)localObject).setVisibility(0);
    localObject = this.sGd;
    if (localObject == null) {
      d.g.b.p.bcb("refreshArea");
    }
    ((View)localObject).setVisibility(8);
    paramString = new ay(paramString);
    com.tencent.mm.kernel.g.aiU().b((n)paramString);
    AppMethodBeat.o(167577);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(204143);
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
    AppMethodBeat.o(204143);
    return localView1;
  }
  
  public final int cAZ()
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
    d.g.b.p.g(localObject1, "findViewById(R.id.finder_avatar)");
    this.fRd = ((ImageView)localObject1);
    localObject1 = findViewById(2131300017);
    d.g.b.p.g(localObject1, "findViewById(R.id.finder_nickname)");
    this.jhg = ((TextView)localObject1);
    localObject1 = findViewById(2131296977);
    d.g.b.p.g(localObject1, "findViewById(R.id.auth_icon)");
    this.sgf = ((ImageView)localObject1);
    localObject1 = findViewById(2131296980);
    d.g.b.p.g(localObject1, "findViewById(R.id.auth_job)");
    this.sEx = ((TextView)localObject1);
    localObject1 = findViewById(2131300062);
    d.g.b.p.g(localObject1, "findViewById(R.id.finder_qrcode)");
    this.sGc = ((ImageView)localObject1);
    localObject1 = findViewById(2131303615);
    d.g.b.p.g(localObject1, "findViewById(R.id.qrcode_container)");
    this.oCb = ((View)localObject1);
    localObject1 = findViewById(2131301509);
    d.g.b.p.g(localObject1, "findViewById(R.id.loading_progress_bar)");
    this.ltc = ((ProgressBar)localObject1);
    localObject1 = findViewById(2131300063);
    d.g.b.p.g(localObject1, "findViewById(R.id.finder_refresh_qrcode)");
    this.sGd = ((View)localObject1);
    localObject1 = findViewById(2131300064);
    d.g.b.p.g(localObject1, "findViewById(R.id.finder_refresh_qrcode_icon)");
    this.sGe = ((ImageView)localObject1);
    localObject1 = com.tencent.mm.plugin.finder.api.c.rHn;
    localObject1 = u.aAu();
    d.g.b.p.g(localObject1, "ConfigStorageLogic.getMyFinderUsername()");
    final com.tencent.mm.plugin.finder.api.g localg = c.a.agW((String)localObject1);
    if (localg != null)
    {
      localObject1 = i.sja;
      localObject1 = i.cCC();
      Object localObject2 = new com.tencent.mm.plugin.finder.loader.a(localg.cxL());
      ImageView localImageView = this.fRd;
      if (localImageView == null) {
        d.g.b.p.bcb("avatarIv");
      }
      i locali = i.sja;
      ((d)localObject1).a(localObject2, localImageView, i.a(i.a.sjd));
      localObject1 = this.jhg;
      if (localObject1 == null) {
        d.g.b.p.bcb("nickTv");
      }
      ((TextView)localObject1).setText((CharSequence)localg.VC());
      localObject1 = localg.field_authInfo;
      int i;
      if (localObject1 != null)
      {
        i = ((FinderAuthInfo)localObject1).authIconType;
        localObject1 = this.sEx;
        if (localObject1 == null) {
          d.g.b.p.bcb("authJob");
        }
        ((TextView)localObject1).setVisibility(8);
        localObject1 = com.tencent.mm.plugin.finder.utils.p.sMo;
        localObject1 = this.sgf;
        if (localObject1 == null) {
          d.g.b.p.bcb("authIcon");
        }
        com.tencent.mm.plugin.finder.utils.p.a((ImageView)localObject1, localg.field_authInfo);
        if (i <= 0) {
          break label652;
        }
        switch (i)
        {
        }
      }
      for (;;)
      {
        com.tencent.mm.kernel.g.aiU().a(258, (f)this);
        aiJ(localg.getUsername());
        localObject1 = this.sGe;
        if (localObject1 == null) {
          d.g.b.p.bcb("refreshIcon");
        }
        ((ImageView)localObject1).setOnClickListener((View.OnClickListener)new b(this, localg));
        localObject1 = new com.tencent.mm.ui.widget.a.e((Context)this, 1, false);
        ((com.tencent.mm.ui.widget.a.e)localObject1).a((n.d)new c(this, localg));
        ((com.tencent.mm.ui.widget.a.e)localObject1).a((n.e)new d(this, localg));
        ((com.tencent.mm.ui.widget.a.e)localObject1).b((e.b)e.sGj);
        addIconOptionMenu(this.sGf, 2131230845, (MenuItem.OnMenuItemClickListener)new f((com.tencent.mm.ui.widget.a.e)localObject1));
        AppMethodBeat.o(167576);
        return;
        i = 0;
        break;
        localObject1 = this.sgf;
        if (localObject1 == null) {
          d.g.b.p.bcb("authIcon");
        }
        ((ImageView)localObject1).setVisibility(0);
        localObject1 = this.sEx;
        if (localObject1 == null) {
          d.g.b.p.bcb("authJob");
        }
        ((TextView)localObject1).setVisibility(0);
        localObject2 = this.sEx;
        if (localObject2 == null) {
          d.g.b.p.bcb("authJob");
        }
        localObject1 = localg.field_authInfo;
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
        localObject1 = this.sEx;
        if (localObject1 == null) {
          d.g.b.p.bcb("authJob");
        }
        ((TextView)localObject1).setVisibility(8);
        continue;
        label652:
        localObject1 = this.sEx;
        if (localObject1 == null) {
          d.g.b.p.bcb("authJob");
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
    setBackBtn((MenuItem.OnMenuItemClickListener)new g(this));
    AppMethodBeat.o(167575);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(167578);
    super.onDestroy();
    com.tencent.mm.kernel.g.aiU().b(258, (f)this);
    AppMethodBeat.o(167578);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(167579);
    ad.i(this.TAG, "errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
    ProgressBar localProgressBar = this.ltc;
    if (localProgressBar == null) {
      d.g.b.p.bcb("loading");
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
      paramString = ((ay)paramn).rJA;
      if (paramString != null) {}
      for (paramString = paramString.aEF(); paramString == null; paramString = null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderQRCodeResponse");
        AppMethodBeat.o(167579);
        throw paramString;
      }
      paramString = ((aqq)paramString).GoI;
      if (paramString != null)
      {
        paramString = paramString.getBytes();
        paramString = com.tencent.mm.sdk.platformtools.g.cr(paramString);
        ad.i(this.TAG, "qrcode url " + ((ay)paramn).cyK());
        if (paramString != null) {
          break label461;
        }
        if (bt.isNullOrNil(((ay)paramn).cyK())) {
          break label458;
        }
        paramString = ((ay)paramn).cyK();
        if (paramString == null) {
          d.g.b.p.gfZ();
        }
        paramn = com.tencent.mm.ak.c.CQ(u.aAu());
        d.g.b.p.g(paramn, "avatarBitmap");
        paramn = com.tencent.mm.sdk.platformtools.g.a(paramn, false, 0.5F * paramn.getWidth());
        float f = aq.ay((Context)this, 2131165299);
        d.g.b.p.g(paramn, "tempBitmap");
        f = f * 1.0F / paramn.getWidth();
        paramn = com.tencent.mm.sdk.platformtools.g.c(com.tencent.mm.sdk.platformtools.g.b(paramn, 0.0F, f, f), com.tencent.mm.sdk.platformtools.g.A(getResources().getDrawable(2131232371)));
        paramString = com.tencent.mm.bz.a.a.b((Context)this, paramn, paramString);
        label345:
        paramn = z.MKo;
      }
    }
    label458:
    label461:
    for (;;)
    {
      if (paramString != null)
      {
        paramn = this.sGc;
        if (paramn == null) {
          d.g.b.p.bcb("qrcode");
        }
        paramn.setImageBitmap(paramString);
        AppMethodBeat.o(167579);
        return;
        paramString = null;
        break;
      }
      AppMethodBeat.o(167579);
      return;
      paramn = this.sGd;
      if (paramn == null) {
        d.g.b.p.bcb("refreshArea");
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
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/ui/FinderSelfQRCodeUI$doExportImg$1", "Lcom/tencent/mm/platformtools/ExportFileUtil$ExportResultCallback;", "onExportFail", "", "srcPath", "", "destPath", "onExportSuccess", "plugin-finder_release"})
  public static final class a
    implements p.a
  {
    public final void bF(String paramString1, String paramString2)
    {
      AppMethodBeat.i(204141);
      d.g.b.p.h(paramString1, "srcPath");
      d.g.b.p.h(paramString2, "destPath");
      Toast.makeText((Context)this.sGh, (CharSequence)this.sGh.getString(2131760319, new Object[] { paramString2 }), 1).show();
      AppMethodBeat.o(204141);
    }
    
    public final void bG(String paramString1, String paramString2)
    {
      AppMethodBeat.i(204142);
      d.g.b.p.h(paramString1, "srcPath");
      d.g.b.p.h(paramString2, "destPath");
      Toast.makeText((Context)this.sGh, (CharSequence)this.sGh.getString(2131762779), 1).show();
      AppMethodBeat.o(204142);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/ui/FinderSelfQRCodeUI$initView$1$1"})
  static final class b
    implements View.OnClickListener
  {
    b(FinderSelfQRCodeUI paramFinderSelfQRCodeUI, com.tencent.mm.plugin.finder.api.g paramg) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167569);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderSelfQRCodeUI$initView$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      FinderSelfQRCodeUI.a(this.sGh, localg.getUsername());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderSelfQRCodeUI$initView$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(167569);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu", "com/tencent/mm/plugin/finder/ui/FinderSelfQRCodeUI$initView$1$2"})
  static final class c
    implements n.d
  {
    c(FinderSelfQRCodeUI paramFinderSelfQRCodeUI, com.tencent.mm.plugin.finder.api.g paramg) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      AppMethodBeat.i(167570);
      d.g.b.p.g(paraml, "it");
      if (paraml.fyP())
      {
        paraml.jI(FinderSelfQRCodeUI.a(this.sGh), 2131759322);
        paraml.jI(FinderSelfQRCodeUI.b(this.sGh), 2131759331);
      }
      AppMethodBeat.o(167570);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected", "com/tencent/mm/plugin/finder/ui/FinderSelfQRCodeUI$initView$1$3"})
  static final class d
    implements n.e
  {
    d(FinderSelfQRCodeUI paramFinderSelfQRCodeUI, com.tencent.mm.plugin.finder.api.g paramg) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(167571);
      d.g.b.p.g(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      if (paramInt == FinderSelfQRCodeUI.a(this.sGh))
      {
        m.a.a(m.sLy, (MMActivity)this.sGh, localg);
        AppMethodBeat.o(167571);
        return;
      }
      if (paramInt == FinderSelfQRCodeUI.b(this.sGh))
      {
        paramMenuItem = com.tencent.mm.sdk.platformtools.g.ga(FinderSelfQRCodeUI.c(this.sGh));
        if (paramMenuItem != null)
        {
          Object localObject = r.sNc;
          localObject = r.cLM();
          com.tencent.mm.sdk.platformtools.g.a(paramMenuItem, 80, Bitmap.CompressFormat.JPEG, (String)localObject, true);
          FinderSelfQRCodeUI.b(this.sGh, (String)localObject);
          com.tencent.mm.plugin.report.e.ygI.idkeyStat(1278L, 7L, 1L, false);
          paramMenuItem = h.soM;
          paramMenuItem = u.aAu();
          d.g.b.p.g(paramMenuItem, "ConfigStorageLogic.getMyFinderUsername()");
          h.ahN(paramMenuItem);
        }
      }
      AppMethodBeat.o(167571);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "onDismiss"})
  static final class e
    implements e.b
  {
    public static final e sGj;
    
    static
    {
      AppMethodBeat.i(167572);
      sGj = new e();
      AppMethodBeat.o(167572);
    }
    
    public final void onDismiss() {}
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class f
    implements MenuItem.OnMenuItemClickListener
  {
    f(com.tencent.mm.ui.widget.a.e parame) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167573);
      this.shX.cMW();
      AppMethodBeat.o(167573);
      return true;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class g
    implements MenuItem.OnMenuItemClickListener
  {
    g(FinderSelfQRCodeUI paramFinderSelfQRCodeUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167574);
      this.sGh.finish();
      AppMethodBeat.o(167574);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSelfQRCodeUI
 * JD-Core Version:    0.7.0.1
 */