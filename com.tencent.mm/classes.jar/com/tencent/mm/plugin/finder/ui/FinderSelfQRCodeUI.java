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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.loader.d;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.cgi.az;
import com.tencent.mm.plugin.finder.loader.i.a;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.plugin.finder.utils.m.a;
import com.tencent.mm.plugin.finder.utils.r;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.a.e.b;
import d.z;
import java.util.HashMap;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/ui/FinderSelfQRCodeUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "MENU_ID_MORE_BTN", "", "MENU_ID_SAVE_TO_GALLERY", "MENU_ID_SHARE_TO_FRIEND", "TAG", "", "authIcon", "Landroid/widget/ImageView;", "authJob", "Landroid/widget/TextView;", "avatarIv", "loading", "Landroid/widget/ProgressBar;", "nickTv", "qrcode", "qrcodeContainer", "Landroid/view/View;", "refreshArea", "refreshIcon", "doExportImg", "", "filePath", "doGetQRCodeScene", "username", "genQRCodeBitmap", "Landroid/graphics/Bitmap;", "url", "getCommentScene", "getLayoutId", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class FinderSelfQRCodeUI
  extends MMFinderUI
  implements f
{
  private final String TAG = "Finder.FinderSelfQRCodeUI";
  private HashMap _$_findViewCache;
  private ImageView fTj;
  private TextView jjZ;
  private ProgressBar lxB;
  private View oID;
  private final int rUO = 100002;
  private TextView sPw;
  private ImageView sRb;
  private View sRc;
  private ImageView sRd;
  private final int sRe = 100001;
  private final int sRf = 100003;
  private ImageView soY;
  
  private final void ajG(String paramString)
  {
    AppMethodBeat.i(167577);
    Object localObject = this.lxB;
    if (localObject == null) {
      d.g.b.p.bdF("loading");
    }
    ((ProgressBar)localObject).setVisibility(0);
    localObject = this.sRc;
    if (localObject == null) {
      d.g.b.p.bdF("refreshArea");
    }
    ((View)localObject).setVisibility(8);
    paramString = new az(paramString);
    com.tencent.mm.kernel.g.ajj().b((n)paramString);
    AppMethodBeat.o(167577);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(204740);
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
    AppMethodBeat.o(204740);
    return localView1;
  }
  
  public final int cCL()
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
    this.fTj = ((ImageView)localObject1);
    localObject1 = findViewById(2131300017);
    d.g.b.p.g(localObject1, "findViewById(R.id.finder_nickname)");
    this.jjZ = ((TextView)localObject1);
    localObject1 = findViewById(2131296977);
    d.g.b.p.g(localObject1, "findViewById(R.id.auth_icon)");
    this.soY = ((ImageView)localObject1);
    localObject1 = findViewById(2131296980);
    d.g.b.p.g(localObject1, "findViewById(R.id.auth_job)");
    this.sPw = ((TextView)localObject1);
    localObject1 = findViewById(2131300062);
    d.g.b.p.g(localObject1, "findViewById(R.id.finder_qrcode)");
    this.sRb = ((ImageView)localObject1);
    localObject1 = findViewById(2131303615);
    d.g.b.p.g(localObject1, "findViewById(R.id.qrcode_container)");
    this.oID = ((View)localObject1);
    localObject1 = findViewById(2131301509);
    d.g.b.p.g(localObject1, "findViewById(R.id.loading_progress_bar)");
    this.lxB = ((ProgressBar)localObject1);
    localObject1 = findViewById(2131300063);
    d.g.b.p.g(localObject1, "findViewById(R.id.finder_refresh_qrcode)");
    this.sRc = ((View)localObject1);
    localObject1 = findViewById(2131300064);
    d.g.b.p.g(localObject1, "findViewById(R.id.finder_refresh_qrcode_icon)");
    this.sRd = ((ImageView)localObject1);
    localObject1 = com.tencent.mm.plugin.finder.api.c.rPy;
    final com.tencent.mm.plugin.finder.api.g localg = c.a.ahT(com.tencent.mm.model.v.aAK());
    if (localg != null)
    {
      localObject1 = com.tencent.mm.plugin.finder.loader.i.srW;
      localObject1 = com.tencent.mm.plugin.finder.loader.i.cEo();
      Object localObject2 = new com.tencent.mm.plugin.finder.loader.a(localg.czm());
      ImageView localImageView = this.fTj;
      if (localImageView == null) {
        d.g.b.p.bdF("avatarIv");
      }
      com.tencent.mm.plugin.finder.loader.i locali = com.tencent.mm.plugin.finder.loader.i.srW;
      ((d)localObject1).a(localObject2, localImageView, com.tencent.mm.plugin.finder.loader.i.a(i.a.srZ));
      localObject1 = this.jjZ;
      if (localObject1 == null) {
        d.g.b.p.bdF("nickTv");
      }
      ((TextView)localObject1).setText((CharSequence)localg.VK());
      localObject1 = localg.field_authInfo;
      int i;
      if (localObject1 != null)
      {
        i = ((FinderAuthInfo)localObject1).authIconType;
        localObject1 = this.sPw;
        if (localObject1 == null) {
          d.g.b.p.bdF("authJob");
        }
        ((TextView)localObject1).setVisibility(8);
        localObject1 = com.tencent.mm.plugin.finder.utils.p.sXz;
        localObject1 = this.soY;
        if (localObject1 == null) {
          d.g.b.p.bdF("authIcon");
        }
        com.tencent.mm.plugin.finder.utils.p.a((ImageView)localObject1, localg.field_authInfo);
        if (i <= 0) {
          break label644;
        }
        switch (i)
        {
        }
      }
      for (;;)
      {
        com.tencent.mm.kernel.g.ajj().a(258, (f)this);
        ajG(localg.getUsername());
        localObject1 = this.sRd;
        if (localObject1 == null) {
          d.g.b.p.bdF("refreshIcon");
        }
        ((ImageView)localObject1).setOnClickListener((View.OnClickListener)new b(this, localg));
        localObject1 = new com.tencent.mm.ui.widget.a.e((Context)this, 1, false);
        ((com.tencent.mm.ui.widget.a.e)localObject1).a((n.d)new c(this, localg));
        ((com.tencent.mm.ui.widget.a.e)localObject1).a((n.e)new d(this, localg));
        ((com.tencent.mm.ui.widget.a.e)localObject1).b((e.b)FinderSelfQRCodeUI.e.sRi);
        addIconOptionMenu(this.sRe, 2131230845, (MenuItem.OnMenuItemClickListener)new FinderSelfQRCodeUI.f((com.tencent.mm.ui.widget.a.e)localObject1));
        AppMethodBeat.o(167576);
        return;
        i = 0;
        break;
        localObject1 = this.soY;
        if (localObject1 == null) {
          d.g.b.p.bdF("authIcon");
        }
        ((ImageView)localObject1).setVisibility(0);
        localObject1 = this.sPw;
        if (localObject1 == null) {
          d.g.b.p.bdF("authJob");
        }
        ((TextView)localObject1).setVisibility(0);
        localObject2 = this.sPw;
        if (localObject2 == null) {
          d.g.b.p.bdF("authJob");
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
        localObject1 = this.sPw;
        if (localObject1 == null) {
          d.g.b.p.bdF("authJob");
        }
        ((TextView)localObject1).setVisibility(8);
        continue;
        label644:
        localObject1 = this.sPw;
        if (localObject1 == null) {
          d.g.b.p.bdF("authJob");
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
    com.tencent.mm.kernel.g.ajj().b(258, (f)this);
    AppMethodBeat.o(167578);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(167579);
    ae.i(this.TAG, "errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
    ProgressBar localProgressBar = this.lxB;
    if (localProgressBar == null) {
      d.g.b.p.bdF("loading");
    }
    localProgressBar.setVisibility(8);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramn == null)
      {
        paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderQRCode");
        AppMethodBeat.o(167579);
        throw paramString;
      }
      paramString = ((az)paramn).rRO;
      if (paramString != null) {}
      for (paramString = paramString.aEV(); paramString == null; paramString = null)
      {
        paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderQRCodeResponse");
        AppMethodBeat.o(167579);
        throw paramString;
      }
      paramString = ((arf)paramString).GHY;
      if (paramString != null)
      {
        paramString = paramString.getBytes();
        paramString = h.cu(paramString);
        ae.i(this.TAG, "qrcode url " + ((az)paramn).cAl());
        if (paramString != null) {
          break label461;
        }
        if (bu.isNullOrNil(((az)paramn).cAl())) {
          break label458;
        }
        paramString = ((az)paramn).cAl();
        if (paramString == null) {
          d.g.b.p.gkB();
        }
        paramn = com.tencent.mm.aj.c.Ds(com.tencent.mm.model.v.aAK());
        d.g.b.p.g(paramn, "avatarBitmap");
        paramn = h.a(paramn, false, 0.5F * paramn.getWidth());
        float f = aq.ay((Context)this, 2131165299);
        d.g.b.p.g(paramn, "tempBitmap");
        f = f * 1.0F / paramn.getWidth();
        paramn = h.c(h.b(paramn, 0.0F, f, f), h.B(getResources().getDrawable(2131232371)));
        paramString = com.tencent.mm.by.a.a.b((Context)this, paramn, paramString);
        label345:
        paramn = z.Nhr;
      }
    }
    label458:
    label461:
    for (;;)
    {
      if (paramString != null)
      {
        paramn = this.sRb;
        if (paramn == null) {
          d.g.b.p.bdF("qrcode");
        }
        paramn.setImageBitmap(paramString);
        AppMethodBeat.o(167579);
        return;
        paramString = null;
        break;
      }
      AppMethodBeat.o(167579);
      return;
      paramn = this.sRc;
      if (paramn == null) {
        d.g.b.p.bdF("refreshArea");
      }
      paramn.setVisibility(0);
      if (bu.isNullOrNil(paramString)) {
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
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/ui/FinderSelfQRCodeUI$doExportImg$1", "Lcom/tencent/mm/platformtools/ExportFileUtil$ExportResultCallback;", "onExportFail", "", "srcPath", "", "destPath", "onExportSuccess", "plugin-finder_release"})
  public static final class a
    implements p.a
  {
    public final void bF(String paramString1, String paramString2)
    {
      AppMethodBeat.i(204738);
      d.g.b.p.h(paramString1, "srcPath");
      d.g.b.p.h(paramString2, "destPath");
      Toast.makeText((Context)this.sRg, (CharSequence)this.sRg.getString(2131760319, new Object[] { paramString2 }), 1).show();
      AppMethodBeat.o(204738);
    }
    
    public final void bG(String paramString1, String paramString2)
    {
      AppMethodBeat.i(204739);
      d.g.b.p.h(paramString1, "srcPath");
      d.g.b.p.h(paramString2, "destPath");
      Toast.makeText((Context)this.sRg, (CharSequence)this.sRg.getString(2131762779), 1).show();
      AppMethodBeat.o(204739);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/ui/FinderSelfQRCodeUI$initView$1$1"})
  static final class b
    implements View.OnClickListener
  {
    b(FinderSelfQRCodeUI paramFinderSelfQRCodeUI, com.tencent.mm.plugin.finder.api.g paramg) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167569);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderSelfQRCodeUI$initView$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      FinderSelfQRCodeUI.a(this.sRg, localg.getUsername());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderSelfQRCodeUI$initView$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(167569);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu", "com/tencent/mm/plugin/finder/ui/FinderSelfQRCodeUI$initView$1$2"})
  static final class c
    implements n.d
  {
    c(FinderSelfQRCodeUI paramFinderSelfQRCodeUI, com.tencent.mm.plugin.finder.api.g paramg) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      AppMethodBeat.i(167570);
      d.g.b.p.g(paraml, "it");
      if (paraml.fCR())
      {
        paraml.jM(FinderSelfQRCodeUI.a(this.sRg), 2131759322);
        paraml.jM(FinderSelfQRCodeUI.b(this.sRg), 2131759331);
      }
      AppMethodBeat.o(167570);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected", "com/tencent/mm/plugin/finder/ui/FinderSelfQRCodeUI$initView$1$3"})
  static final class d
    implements n.e
  {
    d(FinderSelfQRCodeUI paramFinderSelfQRCodeUI, com.tencent.mm.plugin.finder.api.g paramg) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(167571);
      d.g.b.p.g(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      if (paramInt == FinderSelfQRCodeUI.a(this.sRg))
      {
        m.a.a(m.sWJ, (MMActivity)this.sRg, localg);
        AppMethodBeat.o(167571);
        return;
      }
      if (paramInt == FinderSelfQRCodeUI.b(this.sRg))
      {
        paramMenuItem = h.fZ(FinderSelfQRCodeUI.c(this.sRg));
        if (paramMenuItem != null)
        {
          Object localObject = r.sYn;
          localObject = r.cOu();
          h.a(paramMenuItem, 80, Bitmap.CompressFormat.JPEG, (String)localObject, true);
          FinderSelfQRCodeUI.b(this.sRg, (String)localObject);
          com.tencent.mm.plugin.report.e.ywz.idkeyStat(1278L, 7L, 1L, false);
          paramMenuItem = com.tencent.mm.plugin.finder.report.i.syT;
          paramMenuItem = com.tencent.mm.model.v.aAK();
          d.g.b.p.g(paramMenuItem, "ConfigStorageLogic.getMyFinderUsername()");
          com.tencent.mm.plugin.finder.report.i.aiL(paramMenuItem);
        }
      }
      AppMethodBeat.o(167571);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class g
    implements MenuItem.OnMenuItemClickListener
  {
    g(FinderSelfQRCodeUI paramFinderSelfQRCodeUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167574);
      this.sRg.finish();
      AppMethodBeat.o(167574);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSelfQRCodeUI
 * JD-Core Version:    0.7.0.1
 */