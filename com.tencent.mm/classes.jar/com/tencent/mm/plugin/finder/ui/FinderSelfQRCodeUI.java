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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.cgi.ce;
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.utils.al;
import com.tencent.mm.plugin.finder.utils.s;
import com.tencent.mm.plugin.finder.utils.s.a;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.baz;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderSelfQRCodeUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "MENU_ID_MORE_BTN", "", "MENU_ID_SAVE_TO_GALLERY", "MENU_ID_SHARE_TO_FRIEND", "TAG", "", "authIcon", "Landroid/widget/ImageView;", "authJob", "Landroid/widget/TextView;", "avatarIv", "loading", "Landroid/widget/ProgressBar;", "nickTv", "qrcode", "qrcodeContainer", "Landroid/view/View;", "refreshArea", "refreshIcon", "doExportImg", "", "filePath", "doGetQRCodeScene", "username", "genQRCodeBitmap", "Landroid/graphics/Bitmap;", "url", "getCommentScene", "getLayoutId", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class FinderSelfQRCodeUI
  extends MMFinderUI
  implements i
{
  private final String TAG = "Finder.FinderSelfQRCodeUI";
  private HashMap _$_findViewCache;
  private ImageView gyr;
  private TextView kib;
  private ProgressBar mEz;
  private View pWr;
  private final int tzX = 100002;
  private ImageView vMF;
  private TextView vMG;
  private ImageView vNU;
  private View vNV;
  private ImageView vNW;
  private final int vNX = 100001;
  private final int vNY = 100003;
  
  private final void avS(String paramString)
  {
    AppMethodBeat.i(167577);
    Object localObject = this.mEz;
    if (localObject == null) {
      p.btv("loading");
    }
    ((ProgressBar)localObject).setVisibility(0);
    localObject = this.vNV;
    if (localObject == null) {
      p.btv("refreshArea");
    }
    ((View)localObject).setVisibility(8);
    paramString = new ce(paramString);
    com.tencent.mm.kernel.g.azz().b((q)paramString);
    AppMethodBeat.o(167577);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(252660);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(252660);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(252659);
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
    AppMethodBeat.o(252659);
    return localView1;
  }
  
  public final int getCommentScene()
  {
    return 10;
  }
  
  public final int getLayoutId()
  {
    return 2131494624;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(167576);
    Object localObject1 = findViewById(2131300773);
    p.g(localObject1, "findViewById(R.id.finder_avatar)");
    this.gyr = ((ImageView)localObject1);
    localObject1 = findViewById(2131301380);
    p.g(localObject1, "findViewById(R.id.finder_nickname)");
    this.kib = ((TextView)localObject1);
    localObject1 = findViewById(2131297096);
    p.g(localObject1, "findViewById(R.id.auth_icon)");
    this.vMF = ((ImageView)localObject1);
    localObject1 = findViewById(2131297098);
    p.g(localObject1, "findViewById(R.id.auth_job)");
    this.vMG = ((TextView)localObject1);
    localObject1 = findViewById(2131301460);
    p.g(localObject1, "findViewById(R.id.finder_qrcode)");
    this.vNU = ((ImageView)localObject1);
    localObject1 = findViewById(2131306393);
    p.g(localObject1, "findViewById(R.id.qrcode_container)");
    this.pWr = ((View)localObject1);
    localObject1 = findViewById(2131303712);
    p.g(localObject1, "findViewById(R.id.loading_progress_bar)");
    this.mEz = ((ProgressBar)localObject1);
    localObject1 = findViewById(2131301463);
    p.g(localObject1, "findViewById(R.id.finder_refresh_qrcode)");
    this.vNV = ((View)localObject1);
    localObject1 = findViewById(2131301464);
    p.g(localObject1, "findViewById(R.id.finder_refresh_qrcode_icon)");
    this.vNW = ((ImageView)localObject1);
    localObject1 = com.tencent.mm.plugin.finder.api.c.tsp;
    final com.tencent.mm.plugin.finder.api.g localg = c.a.asG(z.aUg());
    if (localg != null)
    {
      localObject1 = com.tencent.mm.plugin.finder.loader.m.uJa;
      localObject1 = com.tencent.mm.plugin.finder.loader.m.dka();
      Object localObject2 = new com.tencent.mm.plugin.finder.loader.a(localg.cXH());
      ImageView localImageView = this.gyr;
      if (localImageView == null) {
        p.btv("avatarIv");
      }
      com.tencent.mm.plugin.finder.loader.m localm = com.tencent.mm.plugin.finder.loader.m.uJa;
      ((com.tencent.mm.loader.d)localObject1).a(localObject2, localImageView, com.tencent.mm.plugin.finder.loader.m.a(m.a.uJe));
      localObject1 = this.kib;
      if (localObject1 == null) {
        p.btv("nickTv");
      }
      ((TextView)localObject1).setText((CharSequence)localg.getNickname());
      localObject1 = localg.field_authInfo;
      int i;
      if (localObject1 != null)
      {
        i = ((FinderAuthInfo)localObject1).authIconType;
        localObject1 = this.vMG;
        if (localObject1 == null) {
          p.btv("authJob");
        }
        ((TextView)localObject1).setVisibility(8);
        localObject1 = y.vXH;
        localObject1 = this.vMF;
        if (localObject1 == null) {
          p.btv("authIcon");
        }
        y.a((ImageView)localObject1, localg.field_authInfo);
        if (i <= 0) {
          break label644;
        }
        switch (i)
        {
        }
      }
      for (;;)
      {
        com.tencent.mm.kernel.g.azz().a(258, (i)this);
        avS(localg.getUsername());
        localObject1 = this.vNW;
        if (localObject1 == null) {
          p.btv("refreshIcon");
        }
        ((ImageView)localObject1).setOnClickListener((View.OnClickListener)new b(this, localg));
        localObject1 = new com.tencent.mm.ui.widget.a.e((Context)this, 1, false);
        ((com.tencent.mm.ui.widget.a.e)localObject1).a((o.f)new c(this, localg));
        ((com.tencent.mm.ui.widget.a.e)localObject1).a((o.g)new d(this, localg));
        ((com.tencent.mm.ui.widget.a.e)localObject1).b((e.b)e.vOb);
        addIconOptionMenu(this.vNX, 2131230858, (MenuItem.OnMenuItemClickListener)new f((com.tencent.mm.ui.widget.a.e)localObject1));
        AppMethodBeat.o(167576);
        return;
        i = 0;
        break;
        localObject1 = this.vMF;
        if (localObject1 == null) {
          p.btv("authIcon");
        }
        ((ImageView)localObject1).setVisibility(0);
        localObject1 = this.vMG;
        if (localObject1 == null) {
          p.btv("authJob");
        }
        ((TextView)localObject1).setVisibility(0);
        localObject2 = this.vMG;
        if (localObject2 == null) {
          p.btv("authJob");
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
        localObject1 = this.vMG;
        if (localObject1 == null) {
          p.btv("authJob");
        }
        ((TextView)localObject1).setVisibility(8);
        continue;
        label644:
        localObject1 = this.vMG;
        if (localObject1 == null) {
          p.btv("authJob");
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
    com.tencent.mm.kernel.g.azz().b(258, (i)this);
    AppMethodBeat.o(167578);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(167579);
    Log.i(this.TAG, "errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
    ProgressBar localProgressBar = this.mEz;
    if (localProgressBar == null) {
      p.btv("loading");
    }
    localProgressBar.setVisibility(8);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramq == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderQRCode");
        AppMethodBeat.o(167579);
        throw paramString;
      }
      paramString = ((ce)paramq).tvD;
      if (paramString != null) {}
      for (paramString = paramString.aYK(); paramString == null; paramString = null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderQRCodeResponse");
        AppMethodBeat.o(167579);
        throw paramString;
      }
      paramString = ((baz)paramString).LKD;
      if (paramString != null)
      {
        paramString = paramString.zy;
        paramString = BitmapUtil.decodeByteArray(paramString);
        Log.i(this.TAG, "qrcode url " + ((ce)paramq).cZd());
        if (paramString != null) {
          break label462;
        }
        if (Util.isNullOrNil(((ce)paramq).cZd())) {
          break label459;
        }
        paramString = ((ce)paramq).cZd();
        if (paramString == null) {
          p.hyc();
        }
        paramq = com.tencent.mm.aj.c.Mc(z.aUg());
        p.g(paramq, "avatarBitmap");
        paramq = BitmapUtil.getRoundedCornerBitmap(paramq, false, 0.5F * paramq.getWidth());
        float f = at.aH((Context)this, 2131165310);
        p.g(paramq, "tempBitmap");
        f = f * 1.0F / paramq.getWidth();
        paramq = BitmapUtil.createLayerBitmap(BitmapUtil.rotateAndScale(paramq, 0.0F, f, f), BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(2131232716)), true);
        paramString = com.tencent.mm.by.a.a.b((Context)this, paramq, paramString);
        label346:
        paramq = x.SXb;
      }
    }
    label459:
    label462:
    for (;;)
    {
      if (paramString != null)
      {
        paramq = this.vNU;
        if (paramq == null) {
          p.btv("qrcode");
        }
        paramq.setImageBitmap(paramString);
        AppMethodBeat.o(167579);
        return;
        paramString = null;
        break;
      }
      AppMethodBeat.o(167579);
      return;
      paramq = this.vNV;
      if (paramq == null) {
        p.btv("refreshArea");
      }
      paramq.setVisibility(0);
      if (Util.isNullOrNil(paramString)) {
        paramString = getString(2131762444);
      }
      for (;;)
      {
        u.makeText((Context)this, (CharSequence)paramString, 1).show();
        AppMethodBeat.o(167579);
        return;
      }
      break label346;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/FinderSelfQRCodeUI$doExportImg$1", "Lcom/tencent/mm/platformtools/ExportFileUtil$ExportResultCallback;", "onExportFail", "", "srcPath", "", "destPath", "onExportSuccess", "plugin-finder_release"})
  public static final class a
    implements p.a
  {
    public final void bP(String paramString1, String paramString2)
    {
      AppMethodBeat.i(252657);
      p.h(paramString1, "srcPath");
      p.h(paramString2, "destPath");
      Toast.makeText((Context)this.vNZ, (CharSequence)this.vNZ.getString(2131761762, new Object[] { paramString2 }), 1).show();
      AppMethodBeat.o(252657);
    }
    
    public final void bQ(String paramString1, String paramString2)
    {
      AppMethodBeat.i(252658);
      p.h(paramString1, "srcPath");
      p.h(paramString2, "destPath");
      Toast.makeText((Context)this.vNZ, (CharSequence)this.vNZ.getString(2131764864), 1).show();
      AppMethodBeat.o(252658);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/ui/FinderSelfQRCodeUI$initView$1$1"})
  static final class b
    implements View.OnClickListener
  {
    b(FinderSelfQRCodeUI paramFinderSelfQRCodeUI, com.tencent.mm.plugin.finder.api.g paramg) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167569);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderSelfQRCodeUI$initView$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      FinderSelfQRCodeUI.a(this.vNZ, localg.getUsername());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderSelfQRCodeUI$initView$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(167569);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu", "com/tencent/mm/plugin/finder/ui/FinderSelfQRCodeUI$initView$1$2"})
  static final class c
    implements o.f
  {
    c(FinderSelfQRCodeUI paramFinderSelfQRCodeUI, com.tencent.mm.plugin.finder.api.g paramg) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramm)
    {
      AppMethodBeat.i(167570);
      p.g(paramm, "it");
      if (paramm.gKQ())
      {
        paramm.kV(FinderSelfQRCodeUI.a(this.vNZ), 2131760481);
        paramm.kV(FinderSelfQRCodeUI.b(this.vNZ), 2131760519);
      }
      AppMethodBeat.o(167570);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected", "com/tencent/mm/plugin/finder/ui/FinderSelfQRCodeUI$initView$1$3"})
  static final class d
    implements o.g
  {
    d(FinderSelfQRCodeUI paramFinderSelfQRCodeUI, com.tencent.mm.plugin.finder.api.g paramg) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(167571);
      p.g(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      if (paramInt == FinderSelfQRCodeUI.a(this.vNZ))
      {
        s.a.a(s.vWt, (MMActivity)this.vNZ, localg);
        AppMethodBeat.o(167571);
        return;
      }
      if (paramInt == FinderSelfQRCodeUI.b(this.vNZ))
      {
        paramMenuItem = BitmapUtil.getBitmapFromView(FinderSelfQRCodeUI.c(this.vNZ));
        if (paramMenuItem != null)
        {
          Object localObject = al.waC;
          localObject = al.dED();
          BitmapUtil.saveBitmapToImage(paramMenuItem, 80, Bitmap.CompressFormat.JPEG, (String)localObject, true);
          FinderSelfQRCodeUI.b(this.vNZ, (String)localObject);
          com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1278L, 7L, 1L, false);
          paramMenuItem = k.vfA;
          paramMenuItem = z.aUg();
          p.g(paramMenuItem, "ConfigStorageLogic.getMyFinderUsername()");
          k.auK(paramMenuItem);
        }
      }
      AppMethodBeat.o(167571);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onDismiss"})
  static final class e
    implements e.b
  {
    public static final e vOb;
    
    static
    {
      AppMethodBeat.i(167572);
      vOb = new e();
      AppMethodBeat.o(167572);
    }
    
    public final void onDismiss() {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class f
    implements MenuItem.OnMenuItemClickListener
  {
    f(com.tencent.mm.ui.widget.a.e parame) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167573);
      this.nkZ.dGm();
      AppMethodBeat.o(167573);
      return true;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class g
    implements MenuItem.OnMenuItemClickListener
  {
    g(FinderSelfQRCodeUI paramFinderSelfQRCodeUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167574);
      this.vNZ.finish();
      AppMethodBeat.o(167574);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSelfQRCodeUI
 * JD-Core Version:    0.7.0.1
 */