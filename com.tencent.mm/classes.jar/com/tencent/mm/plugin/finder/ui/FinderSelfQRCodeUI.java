package com.tencent.mm.plugin.finder.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.c;
import com.tencent.mm.platformtools.ExportFileUtil;
import com.tencent.mm.platformtools.ExportFileUtil.a;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.cgi.dj;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.d;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.utils.an;
import com.tencent.mm.plugin.finder.utils.an.a;
import com.tencent.mm.plugin.finder.utils.bm;
import com.tencent.mm.plugin.h.a;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.btn;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashSet;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderSelfQRCodeUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "MENU_ID_MORE_BTN", "", "MENU_ID_SAVE_TO_GALLERY", "MENU_ID_SHARE_TO_FRIEND", "TAG", "", "authIcon", "Landroid/widget/ImageView;", "authJob", "Landroid/widget/TextView;", "avatarIv", "loading", "Landroid/widget/ProgressBar;", "nickTv", "qrcode", "qrcodeContainer", "Landroid/view/View;", "refreshArea", "refreshIcon", "doExportImg", "", "filePath", "doGetQRCodeScene", "username", "genQRCodeBitmap", "Landroid/graphics/Bitmap;", "url", "getCommentScene", "getLayoutId", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "superImportUIComponents", "set", "Ljava/util/HashSet;", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderSelfQRCodeUI
  extends MMFinderUI
  implements com.tencent.mm.am.h
{
  private ImageView FSM;
  private TextView FSN;
  private ImageView FTS;
  private View FTT;
  private ImageView FTU;
  private final int FTV = 100001;
  private final int FTW = 100002;
  private final int FTX = 100003;
  private final String TAG = "Finder.FinderSelfQRCodeUI";
  private ImageView lKK;
  private TextView pWj;
  private ProgressBar sIX;
  private View wwL;
  
  private static final void a(FinderSelfQRCodeUI paramFinderSelfQRCodeUI, m paramm, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(346636);
    kotlin.g.b.s.u(paramFinderSelfQRCodeUI, "this$0");
    paramInt = paramMenuItem.getItemId();
    if (paramInt == paramFinderSelfQRCodeUI.FTW)
    {
      paramMenuItem = an.GhR;
      an.a.a((MMActivity)paramFinderSelfQRCodeUI, paramm);
      AppMethodBeat.o(346636);
      return;
    }
    if (paramInt == paramFinderSelfQRCodeUI.FTX)
    {
      paramMenuItem = paramFinderSelfQRCodeUI.wwL;
      paramm = paramMenuItem;
      if (paramMenuItem == null)
      {
        kotlin.g.b.s.bIx("qrcodeContainer");
        paramm = null;
      }
      paramm = BitmapUtil.getBitmapFromView(paramm);
      if (paramm != null)
      {
        paramMenuItem = bm.GlZ;
        paramMenuItem = bm.bUk();
        BitmapUtil.saveBitmapToImage(paramm, 80, Bitmap.CompressFormat.JPEG, paramMenuItem, true);
        ExportFileUtil.a((Context)paramFinderSelfQRCodeUI, paramMenuItem, (ExportFileUtil.a)new a(paramFinderSelfQRCodeUI));
        com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1278L, 7L, 1L, false);
        paramFinderSelfQRCodeUI = com.tencent.mm.plugin.finder.report.z.FrZ;
        paramFinderSelfQRCodeUI = com.tencent.mm.model.z.bAW();
        kotlin.g.b.s.s(paramFinderSelfQRCodeUI, "getMyFinderUsername()");
        com.tencent.mm.plugin.finder.report.z.azU(paramFinderSelfQRCodeUI);
      }
    }
    AppMethodBeat.o(346636);
  }
  
  private static final void a(FinderSelfQRCodeUI paramFinderSelfQRCodeUI, m paramm, View paramView)
  {
    AppMethodBeat.i(346620);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderSelfQRCodeUI);
    localb.cH(paramm);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderSelfQRCodeUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramFinderSelfQRCodeUI, "this$0");
    paramFinderSelfQRCodeUI.aBd(paramm.getUsername());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/FinderSelfQRCodeUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(346620);
  }
  
  private static final void a(FinderSelfQRCodeUI paramFinderSelfQRCodeUI, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(346625);
    kotlin.g.b.s.u(paramFinderSelfQRCodeUI, "this$0");
    if (params.jmw())
    {
      params.oh(paramFinderSelfQRCodeUI.FTW, e.h.finder_profile_recommend);
      params.oh(paramFinderSelfQRCodeUI.FTX, e.h.finder_save_to_gallery);
    }
    AppMethodBeat.o(346625);
  }
  
  private static final boolean a(FinderSelfQRCodeUI paramFinderSelfQRCodeUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(346611);
    kotlin.g.b.s.u(paramFinderSelfQRCodeUI, "this$0");
    paramFinderSelfQRCodeUI.finish();
    AppMethodBeat.o(346611);
    return true;
  }
  
  private final void aBd(String paramString)
  {
    Object localObject2 = null;
    AppMethodBeat.i(167577);
    ProgressBar localProgressBar = this.sIX;
    Object localObject1 = localProgressBar;
    if (localProgressBar == null)
    {
      kotlin.g.b.s.bIx("loading");
      localObject1 = null;
    }
    ((ProgressBar)localObject1).setVisibility(0);
    localObject1 = this.FTT;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("refreshArea");
      localObject1 = localObject2;
    }
    for (;;)
    {
      ((View)localObject1).setVisibility(8);
      paramString = new dj(paramString);
      com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)paramString, 0);
      AppMethodBeat.o(167577);
      return;
    }
  }
  
  private static final boolean b(com.tencent.mm.ui.widget.a.f paramf, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(346646);
    kotlin.g.b.s.u(paramf, "$bottomSheet");
    paramf.dDn();
    AppMethodBeat.o(346646);
    return true;
  }
  
  private static final void fbM() {}
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getCommentScene()
  {
    return 10;
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_self_qrcode_ui;
  }
  
  public final void initView()
  {
    CharSequence localCharSequence = null;
    AppMethodBeat.i(167576);
    Object localObject1 = findViewById(e.e.finder_avatar);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.finder_avatar)");
    this.lKK = ((ImageView)localObject1);
    localObject1 = findViewById(e.e.finder_nickname);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.finder_nickname)");
    this.pWj = ((TextView)localObject1);
    localObject1 = findViewById(e.e.auth_icon);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.auth_icon)");
    this.FSM = ((ImageView)localObject1);
    localObject1 = findViewById(e.e.auth_job);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.auth_job)");
    this.FSN = ((TextView)localObject1);
    localObject1 = findViewById(e.e.finder_qrcode);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.finder_qrcode)");
    this.FTS = ((ImageView)localObject1);
    localObject1 = findViewById(e.e.qrcode_container);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.qrcode_container)");
    this.wwL = ((View)localObject1);
    localObject1 = findViewById(e.e.loading_progress_bar);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.loading_progress_bar)");
    this.sIX = ((ProgressBar)localObject1);
    localObject1 = findViewById(e.e.finder_refresh_qrcode);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.finder_refresh_qrcode)");
    this.FTT = ((View)localObject1);
    localObject1 = findViewById(e.e.finder_refresh_qrcode_icon);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.finder_refresh_qrcode_icon)");
    this.FTU = ((ImageView)localObject1);
    localObject1 = com.tencent.mm.plugin.finder.api.d.AwY;
    m localm = d.a.auT(com.tencent.mm.model.z.bAW());
    Object localObject2;
    int i;
    if (localm != null)
    {
      localObject1 = com.tencent.mm.plugin.finder.loader.p.ExI;
      Object localObject3 = com.tencent.mm.plugin.finder.loader.p.eCp();
      com.tencent.mm.plugin.finder.loader.b localb = new com.tencent.mm.plugin.finder.loader.b(localm.amx());
      localObject2 = this.lKK;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("avatarIv");
        localObject1 = null;
      }
      localObject2 = com.tencent.mm.plugin.finder.loader.p.ExI;
      ((com.tencent.mm.loader.d)localObject3).a(localb, (ImageView)localObject1, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExM));
      localObject1 = this.pWj;
      if (localObject1 != null) {
        break label633;
      }
      kotlin.g.b.s.bIx("nickTv");
      localObject1 = null;
      ((TextView)localObject1).setText((CharSequence)localm.getNickname());
      localObject1 = localm.field_authInfo;
      if (localObject1 != null) {
        break label636;
      }
      i = 0;
      label328:
      localObject2 = this.FSN;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("authJob");
        localObject1 = null;
      }
      ((TextView)localObject1).setVisibility(8);
      localObject1 = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
      kotlin.g.b.s.s(localObject1, "service(IFinderCommonService::class.java)");
      localObject3 = (com.tencent.mm.plugin.h)localObject1;
      localObject2 = this.FSM;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("authIcon");
        localObject1 = null;
      }
      h.a.a((com.tencent.mm.plugin.h)localObject3, (ImageView)localObject1, localm.field_authInfo, 0, null, 12);
      if (i <= 0) {
        break label792;
      }
      switch (i)
      {
      default: 
        label440:
        com.tencent.mm.kernel.h.aZW().a(258, (com.tencent.mm.am.h)this);
        aBd(localm.getUsername());
        localObject2 = this.FTU;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          kotlin.g.b.s.bIx("refreshIcon");
          localObject1 = null;
        }
        ((ImageView)localObject1).setOnClickListener(new FinderSelfQRCodeUI..ExternalSyntheticLambda2(this, localm));
        localObject1 = new com.tencent.mm.ui.widget.a.f((Context)this, 1, false);
        ((com.tencent.mm.ui.widget.a.f)localObject1).Vtg = new FinderSelfQRCodeUI..ExternalSyntheticLambda3(this);
        ((com.tencent.mm.ui.widget.a.f)localObject1).GAC = new FinderSelfQRCodeUI..ExternalSyntheticLambda4(this, localm);
        ((com.tencent.mm.ui.widget.a.f)localObject1).aeLi = FinderSelfQRCodeUI..ExternalSyntheticLambda5.INSTANCE;
        addIconOptionMenu(this.FTV, e.d.actionbar_icon_dark_more, new FinderSelfQRCodeUI..ExternalSyntheticLambda1((com.tencent.mm.ui.widget.a.f)localObject1));
        localObject1 = this.wwL;
        if (localObject1 == null)
        {
          kotlin.g.b.s.bIx("qrcodeContainer");
          localObject1 = null;
          label577:
          i = e.e.finder_accessibility_nickname_tag;
          localObject2 = this.pWj;
          if (localObject2 != null) {
            break label823;
          }
          kotlin.g.b.s.bIx("nickTv");
          localObject2 = localCharSequence;
        }
        break;
      }
    }
    label792:
    label823:
    for (;;)
    {
      localCharSequence = ((TextView)localObject2).getText();
      localObject2 = localCharSequence;
      if (localCharSequence == null) {
        localObject2 = (CharSequence)"";
      }
      ((View)localObject1).setTag(i, localObject2);
      AppMethodBeat.o(167576);
      return;
      label633:
      break;
      label636:
      i = ((FinderAuthInfo)localObject1).authIconType;
      break label328;
      localObject2 = this.FSM;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("authIcon");
        localObject1 = null;
      }
      ((ImageView)localObject1).setVisibility(0);
      localObject2 = this.FSN;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("authJob");
        localObject1 = null;
      }
      ((TextView)localObject1).setVisibility(0);
      localObject2 = this.FSN;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("authJob");
        localObject2 = null;
        label709:
        localObject1 = localm.field_authInfo;
        if (localObject1 != null) {
          break label737;
        }
        localObject1 = (CharSequence)"";
      }
      for (;;)
      {
        ((TextView)localObject2).setText((CharSequence)localObject1);
        break;
        break label709;
        label737:
        localObject1 = ((FinderAuthInfo)localObject1).authProfession;
        if (localObject1 == null) {
          localObject1 = (CharSequence)"";
        } else {
          localObject1 = (CharSequence)localObject1;
        }
      }
      localObject2 = this.FSN;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("authJob");
        localObject1 = null;
      }
      ((TextView)localObject1).setVisibility(8);
      break label440;
      localObject2 = this.FSN;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("authJob");
        localObject1 = null;
      }
      ((TextView)localObject1).setVisibility(8);
      break label440;
      break label577;
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167575);
    super.onCreate(paramBundle);
    setMMTitle("");
    initView();
    setBackBtn(new FinderSelfQRCodeUI..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(167575);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(167578);
    super.onDestroy();
    com.tencent.mm.kernel.h.aZW().b(258, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(167578);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    AppMethodBeat.i(167579);
    Log.i(this.TAG, "errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
    ProgressBar localProgressBar = this.sIX;
    Object localObject1 = localProgressBar;
    if (localProgressBar == null)
    {
      kotlin.g.b.s.bIx("loading");
      localObject1 = null;
    }
    ((ProgressBar)localObject1).setVisibility(8);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramp == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderQRCode");
        AppMethodBeat.o(167579);
        throw paramString;
      }
      paramString = ((dj)paramp).ACJ;
      if (paramString == null) {}
      for (paramString = null; paramString == null; paramString = c.c.b(paramString.otC))
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderQRCodeResponse");
        AppMethodBeat.o(167579);
        throw paramString;
      }
      paramString = ((btn)paramString).ZTN;
      if (paramString == null)
      {
        paramString = null;
        localObject1 = BitmapUtil.decodeByteArray(paramString);
        Log.i(this.TAG, kotlin.g.b.s.X("qrcode url ", ((dj)paramp).dWu()));
        paramString = (String)localObject1;
        if (localObject1 == null)
        {
          paramString = (String)localObject1;
          if (!Util.isNullOrNil(((dj)paramp).dWu()))
          {
            paramString = ((dj)paramp).dWu();
            kotlin.g.b.s.checkNotNull(paramString);
            paramp = com.tencent.mm.modelavatar.d.a(com.tencent.mm.model.z.bAW(), false, -1, null);
            paramp = BitmapUtil.getRoundedCornerBitmap(paramp, false, 0.5F * paramp.getWidth());
            float f = bd.bs((Context)this, e.c.Edge_7A) * 1.0F / paramp.getWidth();
            paramp = BitmapUtil.createLayerBitmap(BitmapUtil.rotateAndScale(paramp, 0.0F, f, f), BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(e.d.finder_round_avatar_bg)), true);
            paramString = com.tencent.mm.bz.a.a.b((Context)this, paramp, paramString);
          }
        }
        if (paramString == null) {
          break label444;
        }
        paramp = this.FTS;
        if (paramp != null) {
          break label384;
        }
        kotlin.g.b.s.bIx("qrcode");
        paramp = localObject2;
      }
      label384:
      for (;;)
      {
        paramp.setImageBitmap(paramString);
        AppMethodBeat.o(167579);
        return;
        paramString = paramString.Op;
        break;
      }
    }
    else
    {
      paramp = this.FTT;
      if (paramp != null) {
        break label451;
      }
      kotlin.g.b.s.bIx("refreshArea");
      paramp = localObject3;
      paramp.setVisibility(0);
      if (!Util.isNullOrNil(paramString)) {
        break label454;
      }
      paramString = getString(e.h.loading_failed);
    }
    label444:
    label451:
    label454:
    for (;;)
    {
      aa.makeText((Context)this, (CharSequence)paramString, 1).show();
      AppMethodBeat.o(167579);
      return;
      break;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(346690);
    kotlin.g.b.s.u(paramHashSet, "set");
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(com.tencent.mm.plugin.finder.accessibility.p.class);
    AppMethodBeat.o(346690);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/ui/FinderSelfQRCodeUI$doExportImg$1", "Lcom/tencent/mm/platformtools/ExportFileUtil$ExportResultCallback;", "onExportFail", "", "srcPath", "", "destPath", "onExportSuccess", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements ExportFileUtil.a
  {
    a(FinderSelfQRCodeUI paramFinderSelfQRCodeUI) {}
    
    public final void cg(String paramString1, String paramString2)
    {
      AppMethodBeat.i(347404);
      kotlin.g.b.s.u(paramString1, "srcPath");
      kotlin.g.b.s.u(paramString2, "destPath");
      Toast.makeText((Context)this.FTY, (CharSequence)this.FTY.getString(e.h.image_saved, new Object[] { paramString2 }), 1).show();
      AppMethodBeat.o(347404);
    }
    
    public final void ch(String paramString1, String paramString2)
    {
      AppMethodBeat.i(347409);
      kotlin.g.b.s.u(paramString1, "srcPath");
      kotlin.g.b.s.u(paramString2, "destPath");
      Toast.makeText((Context)this.FTY, (CharSequence)this.FTY.getString(e.h.save_image_err), 1).show();
      AppMethodBeat.o(347409);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSelfQRCodeUI
 * JD-Core Version:    0.7.0.1
 */