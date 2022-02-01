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
import com.tencent.mm.aj.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.plugin.finder.api.b.a;
import com.tencent.mm.plugin.finder.cgi.ar;
import com.tencent.mm.plugin.finder.loader.h;
import com.tencent.mm.plugin.finder.loader.h.a;
import com.tencent.mm.plugin.finder.utils.k.a;
import com.tencent.mm.plugin.finder.utils.p;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.ane;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/ui/FinderSelfQRCodeUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "MENU_ID_MORE_BTN", "", "MENU_ID_SAVE_TO_GALLERY", "MENU_ID_SHARE_TO_FRIEND", "TAG", "", "authIcon", "Landroid/widget/ImageView;", "authJob", "Landroid/widget/TextView;", "avatarIv", "loading", "Landroid/widget/ProgressBar;", "nickTv", "qrcode", "qrcodeContainer", "Landroid/view/View;", "refreshArea", "refreshIcon", "doExportImg", "", "filePath", "doGetQRCodeScene", "username", "genQRCodeBitmap", "Landroid/graphics/Bitmap;", "url", "getCommentScene", "getLayoutId", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class FinderSelfQRCodeUI
  extends MMFinderUI
  implements com.tencent.mm.ak.g
{
  private final String TAG = "Finder.FinderSelfQRCodeUI";
  private HashMap _$_findViewCache;
  private ImageView fxQ;
  private TextView iNX;
  private ProgressBar kWd;
  private View nYH;
  private TextView rFt;
  private ImageView rLb;
  private View rLc;
  private ImageView rLd;
  private final int rLe = 100001;
  private final int rLf = 100002;
  private final int rLg = 100003;
  private ImageView rqZ;
  
  private final void aep(String paramString)
  {
    AppMethodBeat.i(167577);
    Object localObject = this.kWd;
    if (localObject == null) {
      d.g.b.k.aVY("loading");
    }
    ((ProgressBar)localObject).setVisibility(0);
    localObject = this.rLc;
    if (localObject == null) {
      d.g.b.k.aVY("refreshArea");
    }
    ((View)localObject).setVisibility(8);
    paramString = new ar(paramString);
    com.tencent.mm.kernel.g.agi().b((n)paramString);
    AppMethodBeat.o(167577);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(203342);
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
    AppMethodBeat.o(203342);
    return localView1;
  }
  
  public final int cuI()
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
    this.fxQ = ((ImageView)localObject1);
    localObject1 = findViewById(2131300017);
    d.g.b.k.g(localObject1, "findViewById(R.id.finder_nickname)");
    this.iNX = ((TextView)localObject1);
    localObject1 = findViewById(2131296977);
    d.g.b.k.g(localObject1, "findViewById(R.id.auth_icon)");
    this.rqZ = ((ImageView)localObject1);
    localObject1 = findViewById(2131296980);
    d.g.b.k.g(localObject1, "findViewById(R.id.auth_job)");
    this.rFt = ((TextView)localObject1);
    localObject1 = findViewById(2131300062);
    d.g.b.k.g(localObject1, "findViewById(R.id.finder_qrcode)");
    this.rLb = ((ImageView)localObject1);
    localObject1 = findViewById(2131303615);
    d.g.b.k.g(localObject1, "findViewById(R.id.qrcode_container)");
    this.nYH = ((View)localObject1);
    localObject1 = findViewById(2131301509);
    d.g.b.k.g(localObject1, "findViewById(R.id.loading_progress_bar)");
    this.kWd = ((ProgressBar)localObject1);
    localObject1 = findViewById(2131300063);
    d.g.b.k.g(localObject1, "findViewById(R.id.finder_refresh_qrcode)");
    this.rLc = ((View)localObject1);
    localObject1 = findViewById(2131300064);
    d.g.b.k.g(localObject1, "findViewById(R.id.finder_refresh_qrcode_icon)");
    this.rLd = ((ImageView)localObject1);
    localObject1 = com.tencent.mm.plugin.finder.api.b.qWt;
    localObject1 = u.axE();
    d.g.b.k.g(localObject1, "ConfigStorageLogic.getMyFinderUsername()");
    final com.tencent.mm.plugin.finder.api.f localf = b.a.adh((String)localObject1);
    if (localf != null)
    {
      localObject1 = h.rtK;
      localObject1 = h.cwo();
      Object localObject2 = new com.tencent.mm.plugin.finder.loader.a(localf.crZ());
      Object localObject3 = this.fxQ;
      if (localObject3 == null) {
        d.g.b.k.aVY("avatarIv");
      }
      h localh = h.rtK;
      ((com.tencent.mm.loader.d)localObject1).a(localObject2, (ImageView)localObject3, h.a(h.a.rtN));
      localObject1 = this.iNX;
      if (localObject1 == null) {
        d.g.b.k.aVY("nickTv");
      }
      ((TextView)localObject1).setText((CharSequence)localf.Tn());
      localObject1 = localf.field_authInfo;
      int i;
      if (localObject1 != null)
      {
        i = ((FinderAuthInfo)localObject1).authIconType;
        localObject1 = this.rFt;
        if (localObject1 == null) {
          d.g.b.k.aVY("authJob");
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
        com.tencent.mm.kernel.g.agi().a(258, (com.tencent.mm.ak.g)this);
        aep(localf.getUsername());
        localObject1 = this.rLd;
        if (localObject1 == null) {
          d.g.b.k.aVY("refreshIcon");
        }
        ((ImageView)localObject1).setOnClickListener((View.OnClickListener)new b(this, localf));
        localObject1 = new com.tencent.mm.ui.widget.a.e((Context)this, 1, false);
        ((com.tencent.mm.ui.widget.a.e)localObject1).a((n.c)new c(this, localf));
        ((com.tencent.mm.ui.widget.a.e)localObject1).a((n.d)new d(this, localf));
        ((com.tencent.mm.ui.widget.a.e)localObject1).b((e.b)e.rLj);
        addIconOptionMenu(this.rLe, 2131230845, (MenuItem.OnMenuItemClickListener)new f((com.tencent.mm.ui.widget.a.e)localObject1));
        AppMethodBeat.o(167576);
        return;
        i = 0;
        break;
        localObject1 = this.rqZ;
        if (localObject1 == null) {
          d.g.b.k.aVY("authIcon");
        }
        ((ImageView)localObject1).setVisibility(0);
        localObject1 = this.rFt;
        if (localObject1 == null) {
          d.g.b.k.aVY("authJob");
        }
        ((TextView)localObject1).setVisibility(0);
        localObject1 = this.rqZ;
        if (localObject1 == null) {
          d.g.b.k.aVY("authIcon");
        }
        localObject2 = (Context)getContext();
        localObject3 = getContext();
        d.g.b.k.g(localObject3, "context");
        ((ImageView)localObject1).setImageDrawable(am.k((Context)localObject2, 2131690481, ((AppCompatActivity)localObject3).getResources().getColor(2131099777)));
        localObject2 = this.rFt;
        if (localObject2 == null) {
          d.g.b.k.aVY("authJob");
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
        localObject1 = this.rqZ;
        if (localObject1 == null) {
          d.g.b.k.aVY("authIcon");
        }
        ((ImageView)localObject1).setVisibility(0);
        localObject1 = this.rqZ;
        if (localObject1 == null) {
          d.g.b.k.aVY("authIcon");
        }
        localObject2 = (Context)getContext();
        localObject3 = getContext();
        d.g.b.k.g(localObject3, "context");
        ((ImageView)localObject1).setImageDrawable(am.k((Context)localObject2, 2131690481, ((AppCompatActivity)localObject3).getResources().getColor(2131099689)));
        continue;
        localObject1 = this.rqZ;
        if (localObject1 == null) {
          d.g.b.k.aVY("authIcon");
        }
        ((ImageView)localObject1).setVisibility(8);
        localObject1 = this.rFt;
        if (localObject1 == null) {
          d.g.b.k.aVY("authJob");
        }
        ((TextView)localObject1).setVisibility(8);
        continue;
        label798:
        localObject1 = this.rqZ;
        if (localObject1 == null) {
          d.g.b.k.aVY("authIcon");
        }
        ((ImageView)localObject1).setVisibility(8);
        localObject1 = this.rFt;
        if (localObject1 == null) {
          d.g.b.k.aVY("authJob");
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
    com.tencent.mm.kernel.g.agi().b(258, (com.tencent.mm.ak.g)this);
    AppMethodBeat.o(167578);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(167579);
    ac.i(this.TAG, "errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
    ProgressBar localProgressBar = this.kWd;
    if (localProgressBar == null) {
      d.g.b.k.aVY("loading");
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
      paramString = ((ar)paramn).qYo;
      if (paramString != null) {}
      for (paramString = paramString.aBD(); paramString == null; paramString = null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderQRCodeResponse");
        AppMethodBeat.o(167579);
        throw paramString;
      }
      paramString = ((ane)paramString).EGl;
      if (paramString != null)
      {
        paramString = paramString.getBytes();
        paramString = com.tencent.mm.sdk.platformtools.f.ck(paramString);
        ac.i(this.TAG, "qrcode url " + ((ar)paramn).csP());
        if (paramString != null) {
          break label461;
        }
        if (bs.isNullOrNil(((ar)paramn).csP())) {
          break label458;
        }
        paramString = ((ar)paramn).csP();
        if (paramString == null) {
          d.g.b.k.fOy();
        }
        paramn = c.zR(u.axE());
        d.g.b.k.g(paramn, "avatarBitmap");
        paramn = com.tencent.mm.sdk.platformtools.f.a(paramn, false, 0.5F * paramn.getWidth());
        float f = ao.av((Context)this, 2131165299);
        d.g.b.k.g(paramn, "tempBitmap");
        f = f * 1.0F / paramn.getWidth();
        paramn = com.tencent.mm.sdk.platformtools.f.c(com.tencent.mm.sdk.platformtools.f.b(paramn, 0.0F, f, f), com.tencent.mm.sdk.platformtools.f.A(getResources().getDrawable(2131232371)));
        paramString = com.tencent.mm.by.a.a.b((Context)this, paramn, paramString);
        label345:
        paramn = y.KTp;
      }
    }
    label458:
    label461:
    for (;;)
    {
      if (paramString != null)
      {
        paramn = this.rLb;
        if (paramn == null) {
          d.g.b.k.aVY("qrcode");
        }
        paramn.setImageBitmap(paramString);
        AppMethodBeat.o(167579);
        return;
        paramString = null;
        break;
      }
      AppMethodBeat.o(167579);
      return;
      paramn = this.rLc;
      if (paramn == null) {
        d.g.b.k.aVY("refreshArea");
      }
      paramn.setVisibility(0);
      if (bs.isNullOrNil(paramString)) {
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
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/FinderSelfQRCodeUI$doExportImg$1", "Lcom/tencent/mm/platformtools/ExportFileUtil$ExportResultCallback;", "onExportFail", "", "srcPath", "", "destPath", "onExportSuccess", "plugin-finder_release"})
  public static final class a
    implements p.a
  {
    public final void bD(String paramString1, String paramString2)
    {
      AppMethodBeat.i(203340);
      d.g.b.k.h(paramString1, "srcPath");
      d.g.b.k.h(paramString2, "destPath");
      Toast.makeText((Context)this.rLh, (CharSequence)this.rLh.getString(2131760319, new Object[] { paramString2 }), 1).show();
      AppMethodBeat.o(203340);
    }
    
    public final void bE(String paramString1, String paramString2)
    {
      AppMethodBeat.i(203341);
      d.g.b.k.h(paramString1, "srcPath");
      d.g.b.k.h(paramString2, "destPath");
      Toast.makeText((Context)this.rLh, (CharSequence)this.rLh.getString(2131762779), 1).show();
      AppMethodBeat.o(203341);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/ui/FinderSelfQRCodeUI$initView$1$1"})
  static final class b
    implements View.OnClickListener
  {
    b(FinderSelfQRCodeUI paramFinderSelfQRCodeUI, com.tencent.mm.plugin.finder.api.f paramf) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167569);
      FinderSelfQRCodeUI.a(this.rLh, localf.getUsername());
      AppMethodBeat.o(167569);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu", "com/tencent/mm/plugin/finder/ui/FinderSelfQRCodeUI$initView$1$2"})
  static final class c
    implements n.c
  {
    c(FinderSelfQRCodeUI paramFinderSelfQRCodeUI, com.tencent.mm.plugin.finder.api.f paramf) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      AppMethodBeat.i(167570);
      d.g.b.k.g(paraml, "it");
      if (paraml.fiA())
      {
        paraml.jw(FinderSelfQRCodeUI.a(this.rLh), 2131759322);
        paraml.jw(FinderSelfQRCodeUI.b(this.rLh), 2131759331);
      }
      AppMethodBeat.o(167570);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected", "com/tencent/mm/plugin/finder/ui/FinderSelfQRCodeUI$initView$1$3"})
  static final class d
    implements n.d
  {
    d(FinderSelfQRCodeUI paramFinderSelfQRCodeUI, com.tencent.mm.plugin.finder.api.f paramf) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(167571);
      d.g.b.k.g(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      if (paramInt == FinderSelfQRCodeUI.a(this.rLh))
      {
        k.a.a(com.tencent.mm.plugin.finder.utils.k.rPa, (MMActivity)this.rLh, localf);
        AppMethodBeat.o(167571);
        return;
      }
      if (paramInt == FinderSelfQRCodeUI.b(this.rLh))
      {
        paramMenuItem = com.tencent.mm.sdk.platformtools.f.fL(FinderSelfQRCodeUI.c(this.rLh));
        if (paramMenuItem != null)
        {
          Object localObject = p.rQw;
          localObject = p.cDs();
          com.tencent.mm.sdk.platformtools.f.a(paramMenuItem, 80, Bitmap.CompressFormat.JPEG, (String)localObject, true);
          FinderSelfQRCodeUI.b(this.rLh, (String)localObject);
          com.tencent.mm.plugin.report.e.wTc.idkeyStat(1278L, 7L, 1L, false);
          paramMenuItem = com.tencent.mm.plugin.finder.report.d.rxr;
          paramMenuItem = u.axE();
          d.g.b.k.g(paramMenuItem, "ConfigStorageLogic.getMyFinderUsername()");
          com.tencent.mm.plugin.finder.report.d.adO(paramMenuItem);
        }
      }
      AppMethodBeat.o(167571);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "onDismiss"})
  static final class e
    implements e.b
  {
    public static final e rLj;
    
    static
    {
      AppMethodBeat.i(167572);
      rLj = new e();
      AppMethodBeat.o(167572);
    }
    
    public final void onDismiss() {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class f
    implements MenuItem.OnMenuItemClickListener
  {
    f(com.tencent.mm.ui.widget.a.e parame) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167573);
      this.rsL.cED();
      AppMethodBeat.o(167573);
      return true;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class g
    implements MenuItem.OnMenuItemClickListener
  {
    g(FinderSelfQRCodeUI paramFinderSelfQRCodeUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167574);
      this.rLh.finish();
      AppMethodBeat.o(167574);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSelfQRCodeUI
 * JD-Core Version:    0.7.0.1
 */