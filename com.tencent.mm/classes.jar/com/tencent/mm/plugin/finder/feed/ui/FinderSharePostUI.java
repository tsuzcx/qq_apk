package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.publish.l.e;
import com.tencent.mm.plugin.finder.publish.l.f;
import com.tencent.mm.plugin.finder.publish.l.i;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.utils.am;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.utils.i;
import com.tencent.mm.plugin.findersdk.a.bw;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.protocal.protobuf.awt;
import com.tencent.mm.protocal.protobuf.buq;
import com.tencent.mm.protocal.protobuf.etj;
import com.tencent.mm.protocal.protobuf.fby;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.ah.a;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderSharePostUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "TAG", "", "fromOpenSdk", "", "getFromOpenSdk", "()Z", "setFromOpenSdk", "(Z)V", "loadingDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getLoadingDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setLoadingDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "onCancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "getOnCancelListener", "()Landroid/content/DialogInterface$OnCancelListener;", "setOnCancelListener", "(Landroid/content/DialogInterface$OnCancelListener;)V", "shareData", "Lcom/tencent/mm/protocal/protobuf/SharePostData;", "getShareData", "()Lcom/tencent/mm/protocal/protobuf/SharePostData;", "setShareData", "(Lcom/tencent/mm/protocal/protobuf/SharePostData;)V", "tipsMask", "Landroid/view/View;", "getTipsMask", "()Landroid/view/View;", "setTipsMask", "(Landroid/view/View;)V", "wording", "getWording", "()Ljava/lang/String;", "setWording", "(Ljava/lang/String;)V", "back", "", "checkPermission", "checkRemoteVideo", "rawPath", "videoInfo", "Lcom/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$VideoInfo;", "businessType", "appid", "dealShare", "fallback", "errcode", "", "errMsg", "getLayoutId", "getReportTag", "hasExtStatusFlag", "flag", "", "initMaskView", "insertMiaojianExtInfo", "miaojianExtInfo", "callback", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/FinderEventInfo;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "showTipsDialog", "showTipsToast", "Companion", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderSharePostUI
  extends MMFinderUI
{
  public static final FinderSharePostUI.a BrG;
  View BrH;
  public fby BrI;
  private boolean BrJ;
  private final String TAG;
  w loadingDialog;
  private DialogInterface.OnCancelListener qbI;
  private String wording;
  
  static
  {
    AppMethodBeat.i(365789);
    BrG = new FinderSharePostUI.a((byte)0);
    AppMethodBeat.o(365789);
  }
  
  public FinderSharePostUI()
  {
    AppMethodBeat.i(365626);
    this.TAG = "Finder.FinderSharePostUI";
    String str = MMApplicationContext.getContext().getString(l.i.app_waiting);
    s.s(str, "getContext().getString(R.string.app_waiting)");
    this.wording = str;
    AppMethodBeat.o(365626);
  }
  
  private final void Oq(final int paramInt)
  {
    AppMethodBeat.i(365649);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new j(this, paramInt));
    AppMethodBeat.o(365649);
  }
  
  private static final ah a(ah.f paramf, FinderSharePostUI paramFinderSharePostUI, kotlin.g.a.b paramb, b.a parama)
  {
    AppMethodBeat.i(365712);
    s.u(paramf, "$eventInfo");
    s.u(paramFinderSharePostUI, "this$0");
    s.u(paramb, "$callback");
    label48:
    int i;
    if ((parama.errType == 0) && (parama.errCode == 0)) {
      if (parama == null)
      {
        parama = null;
        paramf.aqH = parama;
        Log.i(paramFinderSharePostUI.TAG, s.X("eventInfo = ", paramf.aqH));
        paramFinderSharePostUI = (awt)paramf.aqH;
        if ((paramFinderSharePostUI == null) || (paramFinderSharePostUI.ZHK != 1)) {
          break label238;
        }
        i = 1;
        label87:
        if (i == 0) {
          break label244;
        }
        com.tencent.mm.plugin.report.service.h.OAn.p(1253L, 72L, 1L);
        paramb.invoke(null);
      }
    }
    for (;;)
    {
      paramf = ah.aiuX;
      AppMethodBeat.o(365712);
      return paramf;
      parama = (buq)parama.ott;
      if (parama == null)
      {
        parama = null;
        break;
      }
      parama = parama.aabt;
      if (parama == null)
      {
        parama = null;
        break;
      }
      parama = (awt)p.oL((List)parama);
      break;
      com.tencent.mm.plugin.report.service.h.OAn.p(1253L, 71L, 1L);
      Log.i(paramFinderSharePostUI.TAG, "errorType = " + parama.errType + " errorCode = " + parama.errCode + "  errorMsg = " + parama.errMsg);
      break label48;
      label238:
      i = 0;
      break label87;
      label244:
      paramb.invoke(paramf.aqH);
    }
  }
  
  private static final void a(FinderSharePostUI paramFinderSharePostUI, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(365666);
    s.u(paramFinderSharePostUI, "this$0");
    paramFinderSharePostUI.cLO();
    AppMethodBeat.o(365666);
  }
  
  private static final void a(FinderSharePostUI paramFinderSharePostUI, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(365692);
    s.u(paramFinderSharePostUI, "this$0");
    paramDialogInterface = paramFinderSharePostUI.efS().abBz;
    Object localObject;
    if (paramDialogInterface == null)
    {
      paramDialogInterface = "";
      localObject = paramFinderSharePostUI.efS().abBz;
      if (localObject != null) {
        break label84;
      }
      localObject = "";
    }
    for (;;)
    {
      paramFinderSharePostUI.e(-6, "teenmode", paramDialogInterface, (String)localObject);
      paramFinderSharePostUI.finish();
      AppMethodBeat.o(365692);
      return;
      localObject = paramDialogInterface.businessType;
      paramDialogInterface = (DialogInterface)localObject;
      if (localObject != null) {
        break;
      }
      paramDialogInterface = "";
      break;
      label84:
      String str = ((etj)localObject).appid;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
    }
  }
  
  private static final void a(FinderSharePostUI paramFinderSharePostUI, View paramView)
  {
    AppMethodBeat.i(365677);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderSharePostUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderSharePostUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderSharePostUI, "this$0");
    paramFinderSharePostUI.cLO();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/feed/ui/FinderSharePostUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(365677);
  }
  
  private final void cLO()
  {
    AppMethodBeat.i(365639);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(365639);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final void e(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(365898);
    s.u(paramString1, "errMsg");
    Log.i(this.TAG, "fallback errcode:" + paramInt + ", " + paramString1 + ", " + paramString3);
    if (!this.BrJ)
    {
      am localam = am.GhD;
      am.e(paramInt, paramString1, paramString2, paramString3);
    }
    AppMethodBeat.o(365898);
  }
  
  public final fby efS()
  {
    AppMethodBeat.i(365849);
    fby localfby = this.BrI;
    if (localfby != null)
    {
      AppMethodBeat.o(365849);
      return localfby;
    }
    s.bIx("shareData");
    AppMethodBeat.o(365849);
    return null;
  }
  
  public final String efe()
  {
    return this.TAG;
  }
  
  public final int getLayoutId()
  {
    return l.f.finder_share_post_ui;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    int k = 0;
    AppMethodBeat.i(365873);
    super.onCreate(paramBundle);
    paramBundle = getSupportActionBar();
    if (paramBundle != null) {
      paramBundle.hide();
    }
    this.BrH = findViewById(l.e.mask_finder_entrance_hide_tips);
    paramBundle = (TextView)findViewById(l.e.finder_entrance_hide_tips_title);
    s.s(paramBundle, "titleTv");
    i.setTextBold(paramBundle);
    paramBundle = (TextView)findViewById(l.e.finder_entrance_hide_tips_btn);
    s.s(paramBundle, "okBtn");
    i.setTextBold(paramBundle);
    paramBundle.setOnClickListener(new FinderSharePostUI..ExternalSyntheticLambda2(this));
    this.qbI = new FinderSharePostUI..ExternalSyntheticLambda0(this);
    this.loadingDialog = w.a((Context)getContext(), (CharSequence)this.wording, true, 0, this.qbI);
    paramBundle = (com.tencent.mm.bx.a)new fby();
    byte[] arrayOfByte = getIntent().getByteArrayExtra("KEY_POST_FROM_SHARE");
    try
    {
      paramBundle.parseFrom(arrayOfByte);
      paramBundle = (fby)paramBundle;
      if (paramBundle != null)
      {
        s.u(paramBundle, "<set-?>");
        this.BrI = paramBundle;
        paramBundle = efS().abBz;
        if (paramBundle == null)
        {
          bool1 = false;
          this.BrJ = bool1;
          bool2 = ((cn)com.tencent.mm.kernel.h.az(cn.class)).showFinderEntry();
          if ((z.bAR() & 0x0) == 0L) {
            break label384;
          }
          i = 1;
          if (i != 0) {
            break label389;
          }
          i = 1;
          paramBundle = av.GiL;
          j = av.fgg();
          bool1 = ((bw)com.tencent.mm.kernel.h.ax(bw.class)).aBu();
          paramBundle = com.tencent.mm.plugin.finder.storage.d.FAy;
          switch (((Number)com.tencent.mm.plugin.finder.storage.d.eSs().bmg()).intValue())
          {
          default: 
            if (!bool2)
            {
              Oq(l.i.finder_share_post_tips1);
              i = k;
              if (i == 0) {
                break label524;
              }
              com.tencent.mm.ae.d.B((kotlin.g.a.a)new h(this));
              AppMethodBeat.o(365873);
            }
            break;
          }
        }
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        Log.printDebugStack("safeParser", "", new Object[] { paramBundle });
        paramBundle = null;
        continue;
        boolean bool1 = paramBundle.BrJ;
        continue;
        label384:
        int i = 0;
        continue;
        label389:
        i = 0;
        continue;
        boolean bool2 = false;
        continue;
        int j = 1;
        continue;
        i = 0;
        continue;
        bool1 = true;
        continue;
        if (i == 0)
        {
          com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new i(this));
          i = k;
        }
        else if (j == 1)
        {
          Oq(l.i.finder_share_post_tips2);
          i = k;
        }
        else if (bool1)
        {
          paramBundle = this.loadingDialog;
          if (paramBundle != null) {
            paramBundle.dismiss();
          }
          k.a((Context)getContext(), getResources().getString(l.i.finder_teen_mode_title_enable), "", false, new FinderSharePostUI..ExternalSyntheticLambda1(this));
          i = k;
        }
        else
        {
          i = 1;
        }
      }
      cLO();
      label524:
      AppMethodBeat.o(365873);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void setTipsMask(View paramView)
  {
    this.BrH = paramView;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(FinderSharePostUI paramFinderSharePostUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(FinderSharePostUI paramFinderSharePostUI, String paramString1, String paramString2)
    {
      super();
    }
    
    private static final void a(FinderSharePostUI paramFinderSharePostUI, String paramString1, String paramString2, DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(364283);
      s.u(paramFinderSharePostUI, "this$0");
      paramFinderSharePostUI.e(-7, "", paramString1, paramString2);
      FinderSharePostUI.b(paramFinderSharePostUI);
      AppMethodBeat.o(364283);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(FinderSharePostUI paramFinderSharePostUI, String paramString1, String paramString2)
    {
      super();
    }
    
    private static final void a(FinderSharePostUI paramFinderSharePostUI, String paramString1, String paramString2, DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(364355);
      s.u(paramFinderSharePostUI, "this$0");
      paramFinderSharePostUI.e(-8, "", paramString1, paramString2);
      FinderSharePostUI.b(paramFinderSharePostUI);
      AppMethodBeat.o(364355);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(FinderSharePostUI paramFinderSharePostUI, String paramString1, String paramString2)
    {
      super();
    }
    
    private static final void a(FinderSharePostUI paramFinderSharePostUI, String paramString1, String paramString2, DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(364358);
      s.u(paramFinderSharePostUI, "this$0");
      paramFinderSharePostUI.e(-9, "", paramString1, paramString2);
      FinderSharePostUI.b(paramFinderSharePostUI);
      AppMethodBeat.o(364358);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ah>
  {
    f(FinderSharePostUI paramFinderSharePostUI)
    {
      super();
    }
    
    private static final void b(FinderSharePostUI paramFinderSharePostUI, DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(364383);
      s.u(paramFinderSharePostUI, "this$0");
      FinderSharePostUI.b(paramFinderSharePostUI);
      AppMethodBeat.o(364383);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "eventInfo", "Lcom/tencent/mm/protocal/protobuf/FinderEventInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.b<awt, ah>
  {
    g(String paramString1, int paramInt1, String paramString2, FinderSharePostUI paramFinderSharePostUI, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, ah.a parama, String paramString7, String paramString8, ah.f<String> paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<ah>
  {
    h(FinderSharePostUI paramFinderSharePostUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<ah>
  {
    i(FinderSharePostUI paramFinderSharePostUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<ah>
  {
    j(FinderSharePostUI paramFinderSharePostUI, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderSharePostUI
 * JD-Core Version:    0.7.0.1
 */