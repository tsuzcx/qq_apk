package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.e;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.ci;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.utils.ac;
import com.tencent.mm.plugin.finder.utils.ac.a;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.bhn;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderSelfQRCodeUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "MENU_ID_MORE_BTN", "", "MENU_ID_SAVE_TO_GALLERY", "MENU_ID_SHARE_TO_FRIEND", "TAG", "", "authIcon", "Landroid/widget/ImageView;", "authJob", "Landroid/widget/TextView;", "avatarIv", "loading", "Landroid/widget/ProgressBar;", "nickTv", "qrcode", "qrcodeContainer", "Landroid/view/View;", "refreshArea", "refreshIcon", "doExportImg", "", "filePath", "doGetQRCodeScene", "username", "genQRCodeBitmap", "Landroid/graphics/Bitmap;", "url", "getCommentScene", "getLayoutId", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class FinderSelfQRCodeUI
  extends MMFinderUI
  implements com.tencent.mm.an.i
{
  private ImageView Atw;
  private TextView Atx;
  private ImageView AuM;
  private View AuN;
  private ImageView AuO;
  private final int AuP = 100001;
  private final int AuQ = 100003;
  private final String TAG = "Finder.FinderSelfQRCodeUI";
  private HashMap _$_findViewCache;
  private ImageView jiu;
  private TextView mZA;
  private ProgressBar pDL;
  private View tso;
  private final int xhJ = 100002;
  
  private final void aFh(String paramString)
  {
    AppMethodBeat.i(167577);
    Object localObject = this.pDL;
    if (localObject == null) {
      p.bGy("loading");
    }
    ((ProgressBar)localObject).setVisibility(0);
    localObject = this.AuN;
    if (localObject == null) {
      p.bGy("refreshArea");
    }
    ((View)localObject).setVisibility(8);
    paramString = new ci(paramString);
    h.aGY().b((q)paramString);
    AppMethodBeat.o(167577);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(282006);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(282006);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(282005);
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
    AppMethodBeat.o(282005);
    return localView1;
  }
  
  public final int getCommentScene()
  {
    return 10;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_self_qrcode_ui;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(167576);
    Object localObject1 = findViewById(b.f.finder_avatar);
    p.j(localObject1, "findViewById(R.id.finder_avatar)");
    this.jiu = ((ImageView)localObject1);
    localObject1 = findViewById(b.f.finder_nickname);
    p.j(localObject1, "findViewById(R.id.finder_nickname)");
    this.mZA = ((TextView)localObject1);
    localObject1 = findViewById(b.f.auth_icon);
    p.j(localObject1, "findViewById(R.id.auth_icon)");
    this.Atw = ((ImageView)localObject1);
    localObject1 = findViewById(b.f.auth_job);
    p.j(localObject1, "findViewById(R.id.auth_job)");
    this.Atx = ((TextView)localObject1);
    localObject1 = findViewById(b.f.finder_qrcode);
    p.j(localObject1, "findViewById(R.id.finder_qrcode)");
    this.AuM = ((ImageView)localObject1);
    localObject1 = findViewById(b.f.qrcode_container);
    p.j(localObject1, "findViewById(R.id.qrcode_container)");
    this.tso = ((View)localObject1);
    localObject1 = findViewById(b.f.loading_progress_bar);
    p.j(localObject1, "findViewById(R.id.loading_progress_bar)");
    this.pDL = ((ProgressBar)localObject1);
    localObject1 = findViewById(b.f.finder_refresh_qrcode);
    p.j(localObject1, "findViewById(R.id.finder_refresh_qrcode)");
    this.AuN = ((View)localObject1);
    localObject1 = findViewById(b.f.finder_refresh_qrcode_icon);
    p.j(localObject1, "findViewById(R.id.finder_refresh_qrcode_icon)");
    this.AuO = ((ImageView)localObject1);
    localObject1 = com.tencent.mm.plugin.finder.api.d.wZQ;
    final com.tencent.mm.plugin.finder.api.i locali = d.a.aAK(z.bdh());
    if (locali != null)
    {
      localObject1 = com.tencent.mm.plugin.finder.loader.t.ztT;
      localObject1 = com.tencent.mm.plugin.finder.loader.t.dJh();
      Object localObject2 = new com.tencent.mm.plugin.finder.loader.e(locali.Mm());
      ImageView localImageView = this.jiu;
      if (localImageView == null) {
        p.bGy("avatarIv");
      }
      com.tencent.mm.plugin.finder.loader.t localt = com.tencent.mm.plugin.finder.loader.t.ztT;
      ((com.tencent.mm.loader.d)localObject1).a(localObject2, localImageView, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztX));
      localObject1 = this.mZA;
      if (localObject1 == null) {
        p.bGy("nickTv");
      }
      ((TextView)localObject1).setText((CharSequence)locali.getNickname());
      localObject1 = locali.field_authInfo;
      int i;
      if (localObject1 != null)
      {
        i = ((FinderAuthInfo)localObject1).authIconType;
        localObject1 = this.Atx;
        if (localObject1 == null) {
          p.bGy("authJob");
        }
        ((TextView)localObject1).setVisibility(8);
        localObject1 = aj.AGc;
        localObject1 = this.Atw;
        if (localObject1 == null) {
          p.bGy("authIcon");
        }
        aj.a((ImageView)localObject1, locali.field_authInfo);
        if (i <= 0) {
          break label656;
        }
        switch (i)
        {
        }
      }
      for (;;)
      {
        h.aGY().a(258, (com.tencent.mm.an.i)this);
        aFh(locali.getUsername());
        localObject1 = this.AuO;
        if (localObject1 == null) {
          p.bGy("refreshIcon");
        }
        ((ImageView)localObject1).setOnClickListener((View.OnClickListener)new b(this, locali));
        localObject1 = new com.tencent.mm.ui.widget.a.e((Context)this, 1, false);
        ((com.tencent.mm.ui.widget.a.e)localObject1).a((q.f)new c(this, locali));
        ((com.tencent.mm.ui.widget.a.e)localObject1).a((q.g)new d(this, locali));
        ((com.tencent.mm.ui.widget.a.e)localObject1).b((e.b)e.AuT);
        addIconOptionMenu(this.AuP, b.e.actionbar_icon_dark_more, (MenuItem.OnMenuItemClickListener)new f((com.tencent.mm.ui.widget.a.e)localObject1));
        AppMethodBeat.o(167576);
        return;
        i = 0;
        break;
        localObject1 = this.Atw;
        if (localObject1 == null) {
          p.bGy("authIcon");
        }
        ((ImageView)localObject1).setVisibility(0);
        localObject1 = this.Atx;
        if (localObject1 == null) {
          p.bGy("authJob");
        }
        ((TextView)localObject1).setVisibility(0);
        localObject2 = this.Atx;
        if (localObject2 == null) {
          p.bGy("authJob");
        }
        localObject1 = locali.field_authInfo;
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
        localObject1 = this.Atx;
        if (localObject1 == null) {
          p.bGy("authJob");
        }
        ((TextView)localObject1).setVisibility(8);
        continue;
        label656:
        localObject1 = this.Atx;
        if (localObject1 == null) {
          p.bGy("authJob");
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
    h.aGY().b(258, (com.tencent.mm.an.i)this);
    AppMethodBeat.o(167578);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(167579);
    Log.i(this.TAG, "errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
    ProgressBar localProgressBar = this.pDL;
    if (localProgressBar == null) {
      p.bGy("loading");
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
      paramString = ((ci)paramq).xdl;
      if (paramString != null) {}
      for (paramString = paramString.bhY(); paramString == null; paramString = null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderQRCodeResponse");
        AppMethodBeat.o(167579);
        throw paramString;
      }
      paramString = ((bhn)paramString).SNf;
      if (paramString != null)
      {
        paramString = paramString.UH;
        paramString = BitmapUtil.decodeByteArray(paramString);
        Log.i(this.TAG, "qrcode url " + ((ci)paramq).doU());
        if (paramString != null) {
          break label462;
        }
        if (Util.isNullOrNil(((ci)paramq).doU())) {
          break label459;
        }
        paramString = ((ci)paramq).doU();
        if (paramString == null) {
          p.iCn();
        }
        paramq = com.tencent.mm.am.d.Tx(z.bdh());
        p.j(paramq, "avatarBitmap");
        paramq = BitmapUtil.getRoundedCornerBitmap(paramq, false, 0.5F * paramq.getWidth());
        float f = aw.aZ((Context)this, b.d.Edge_7A);
        p.j(paramq, "tempBitmap");
        f = f * 1.0F / paramq.getWidth();
        paramq = BitmapUtil.createLayerBitmap(BitmapUtil.rotateAndScale(paramq, 0.0F, f, f), BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(b.e.finder_round_avatar_bg)), true);
        paramString = com.tencent.mm.cf.a.a.b((Context)this, paramq, paramString);
        label346:
        paramq = x.aazN;
      }
    }
    label459:
    label462:
    for (;;)
    {
      if (paramString != null)
      {
        paramq = this.AuM;
        if (paramq == null) {
          p.bGy("qrcode");
        }
        paramq.setImageBitmap(paramString);
        AppMethodBeat.o(167579);
        return;
        paramString = null;
        break;
      }
      AppMethodBeat.o(167579);
      return;
      paramq = this.AuN;
      if (paramq == null) {
        p.bGy("refreshArea");
      }
      paramq.setVisibility(0);
      if (Util.isNullOrNil(paramString)) {
        paramString = getString(b.j.loading_failed);
      }
      for (;;)
      {
        w.makeText((Context)this, (CharSequence)paramString, 1).show();
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/FinderSelfQRCodeUI$doExportImg$1", "Lcom/tencent/mm/platformtools/ExportFileUtil$ExportResultCallback;", "onExportFail", "", "srcPath", "", "destPath", "onExportSuccess", "plugin-finder_release"})
  public static final class a
    implements p.a
  {
    public final void bT(String paramString1, String paramString2)
    {
      AppMethodBeat.i(270136);
      p.k(paramString1, "srcPath");
      p.k(paramString2, "destPath");
      Toast.makeText((Context)this.AuR, (CharSequence)this.AuR.getString(b.j.image_saved, new Object[] { paramString2 }), 1).show();
      AppMethodBeat.o(270136);
    }
    
    public final void bU(String paramString1, String paramString2)
    {
      AppMethodBeat.i(270138);
      p.k(paramString1, "srcPath");
      p.k(paramString2, "destPath");
      Toast.makeText((Context)this.AuR, (CharSequence)this.AuR.getString(b.j.save_image_err), 1).show();
      AppMethodBeat.o(270138);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/ui/FinderSelfQRCodeUI$initView$1$1"})
  static final class b
    implements View.OnClickListener
  {
    b(FinderSelfQRCodeUI paramFinderSelfQRCodeUI, com.tencent.mm.plugin.finder.api.i parami) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167569);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderSelfQRCodeUI$initView$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      FinderSelfQRCodeUI.a(this.AuR, locali.getUsername());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderSelfQRCodeUI$initView$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(167569);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu", "com/tencent/mm/plugin/finder/ui/FinderSelfQRCodeUI$initView$1$2"})
  static final class c
    implements q.f
  {
    c(FinderSelfQRCodeUI paramFinderSelfQRCodeUI, com.tencent.mm.plugin.finder.api.i parami) {}
    
    public final void onCreateMMMenu(o paramo)
    {
      AppMethodBeat.i(167570);
      p.j(paramo, "it");
      if (paramo.hJO())
      {
        paramo.mn(FinderSelfQRCodeUI.a(this.AuR), b.j.finder_profile_recommend);
        paramo.mn(FinderSelfQRCodeUI.b(this.AuR), b.j.finder_save_to_gallery);
      }
      AppMethodBeat.o(167570);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected", "com/tencent/mm/plugin/finder/ui/FinderSelfQRCodeUI$initView$1$3"})
  static final class d
    implements q.g
  {
    d(FinderSelfQRCodeUI paramFinderSelfQRCodeUI, com.tencent.mm.plugin.finder.api.i parami) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(167571);
      p.j(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      if (paramInt == FinderSelfQRCodeUI.a(this.AuR))
      {
        ac.a.a(ac.AEJ, (MMActivity)this.AuR, locali);
        AppMethodBeat.o(167571);
        return;
      }
      if (paramInt == FinderSelfQRCodeUI.b(this.AuR))
      {
        paramMenuItem = BitmapUtil.getBitmapFromView(FinderSelfQRCodeUI.c(this.AuR));
        if (paramMenuItem != null)
        {
          Object localObject = av.AJz;
          localObject = av.egq();
          BitmapUtil.saveBitmapToImage(paramMenuItem, 80, Bitmap.CompressFormat.JPEG, (String)localObject, true);
          FinderSelfQRCodeUI.b(this.AuR, (String)localObject);
          f.Iyx.idkeyStat(1278L, 7L, 1L, false);
          paramMenuItem = n.zWF;
          paramMenuItem = z.bdh();
          p.j(paramMenuItem, "ConfigStorageLogic.getMyFinderUsername()");
          n.aEd(paramMenuItem);
        }
      }
      AppMethodBeat.o(167571);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onDismiss"})
  static final class e
    implements e.b
  {
    public static final e AuT;
    
    static
    {
      AppMethodBeat.i(167572);
      AuT = new e();
      AppMethodBeat.o(167572);
    }
    
    public final void onDismiss() {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class f
    implements MenuItem.OnMenuItemClickListener
  {
    f(com.tencent.mm.ui.widget.a.e parame) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167573);
      this.qmB.eik();
      AppMethodBeat.o(167573);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class g
    implements MenuItem.OnMenuItemClickListener
  {
    g(FinderSelfQRCodeUI paramFinderSelfQRCodeUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167574);
      this.AuR.finish();
      AppMethodBeat.o(167574);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSelfQRCodeUI
 * JD-Core Version:    0.7.0.1
 */