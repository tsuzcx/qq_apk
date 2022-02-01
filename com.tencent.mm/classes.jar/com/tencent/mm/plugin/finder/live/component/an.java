package com.tencent.mm.plugin.finder.live.component;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.ExportFileUtil;
import com.tencent.mm.platformtools.ExportFileUtil.a;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.cgi.bs;
import com.tencent.mm.plugin.finder.cgi.dx;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.p.d;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.g;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.report.q.av;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.findersdk.a.bn;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.plugin.g;
import com.tencent.mm.plugin.h.a;
import com.tencent.mm.protocal.protobuf.bkk;
import com.tencent.mm.protocal.protobuf.bkn;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.ui.widget.a.g.a;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveNoticeQRCodeUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "contact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "dialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "mAuthView", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getMAuthView", "()Landroid/widget/ImageView;", "mAuthView$delegate", "Lkotlin/Lazy;", "mAvatarView", "getMAvatarView", "mAvatarView$delegate", "mBackBtn", "Landroid/view/View;", "getMBackBtn", "()Landroid/view/View;", "mBackBtn$delegate", "mCodeDesc", "Landroid/widget/TextView;", "getMCodeDesc", "()Landroid/widget/TextView;", "mCodeDesc$delegate", "mDescView", "getMDescView", "mDescView$delegate", "mMoreBtn", "getMMoreBtn", "mMoreBtn$delegate", "mNameView", "getMNameView", "mNameView$delegate", "mQrCodeLogo", "getMQrCodeLogo", "mQrCodeLogo$delegate", "mQrCodeRootView", "getMQrCodeRootView", "mQrCodeRootView$delegate", "mQrCodeSaveView", "getMQrCodeSaveView", "mQrCodeSaveView$delegate", "mQrCodeView", "getMQrCodeView", "mQrCodeView$delegate", "mTimeView", "getMTimeView", "mTimeView$delegate", "mTitle", "getMTitle", "mTitle$delegate", "noticeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "doDelFinderNotice", "", "liveNoticeInfo", "doExportImg", "filePath", "", "doScene", "genQRCodeBitmap", "Landroid/graphics/Bitmap;", "url", "getLayoutId", "", "initData", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onQrCodeFailed", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "showOrDimissLoading", "show", "", "cancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class an
  extends UIComponent
  implements com.tencent.mm.am.h
{
  private static final String CAM;
  private static final String CAN;
  public static final an.a CAy;
  private bkk BvE;
  private final kotlin.j CAA;
  private final kotlin.j CAB;
  private final kotlin.j CAC;
  private final kotlin.j CAD;
  private final kotlin.j CAE;
  private final kotlin.j CAF;
  private final kotlin.j CAG;
  private final kotlin.j CAH;
  private final kotlin.j CAI;
  private final kotlin.j CAJ;
  private final kotlin.j CAK;
  private final kotlin.j CAL;
  private final kotlin.j CAz;
  private com.tencent.mm.plugin.finder.api.m contact;
  w rYw;
  
  static
  {
    AppMethodBeat.i(352907);
    CAy = new an.a((byte)0);
    com.tencent.mm.plugin.findersdk.a.m localm = com.tencent.mm.plugin.findersdk.a.m.Hce;
    CAM = com.tencent.mm.plugin.findersdk.a.m.frz();
    localm = com.tencent.mm.plugin.findersdk.a.m.Hce;
    CAN = com.tencent.mm.plugin.findersdk.a.m.frA();
    AppMethodBeat.o(352907);
  }
  
  public an(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(352791);
    this.CAz = k.cm((kotlin.g.a.a)new e(paramAppCompatActivity));
    this.CAA = k.cm((kotlin.g.a.a)new j(paramAppCompatActivity));
    this.CAB = k.cm((kotlin.g.a.a)new d(paramAppCompatActivity));
    this.CAC = k.cm((kotlin.g.a.a)new h(paramAppCompatActivity));
    this.CAD = k.cm((kotlin.g.a.a)new o(paramAppCompatActivity));
    this.CAE = k.cm((kotlin.g.a.a)new n(paramAppCompatActivity));
    this.CAF = k.cm((kotlin.g.a.a)new l(paramAppCompatActivity));
    this.CAG = k.cm((kotlin.g.a.a)new k(paramAppCompatActivity));
    this.CAH = k.cm((kotlin.g.a.a)new m(paramAppCompatActivity));
    this.CAI = k.cm((kotlin.g.a.a)new f(paramAppCompatActivity));
    this.CAJ = k.cm((kotlin.g.a.a)new i(paramAppCompatActivity));
    this.CAK = k.cm((kotlin.g.a.a)new p(paramAppCompatActivity));
    this.CAL = k.cm((kotlin.g.a.a)new g(paramAppCompatActivity));
    AppMethodBeat.o(352791);
  }
  
  private static final void a(an paraman)
  {
    AppMethodBeat.i(352852);
    kotlin.g.b.s.u(paraman, "this$0");
    paraman.a(true, (DialogInterface.OnCancelListener)new c(paraman));
    Object localObject = paraman.contact;
    if (localObject == null)
    {
      localObject = "";
      paraman = paraman.BvE;
      if (paraman != null) {
        break label102;
      }
      paraman = "";
    }
    for (;;)
    {
      paraman = new dx((String)localObject, paraman);
      com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)paraman, 0);
      AppMethodBeat.o(352852);
      return;
      String str = ((com.tencent.mm.plugin.finder.api.m)localObject).getUsername();
      localObject = str;
      if (str != null) {
        break;
      }
      localObject = "";
      break;
      label102:
      str = paraman.hAR;
      paraman = str;
      if (str == null) {
        paraman = "";
      }
    }
  }
  
  private static final void a(an paraman, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(352873);
    kotlin.g.b.s.u(paraman, "this$0");
    if (paramMenuItem.getItemId() == 1)
    {
      paramMenuItem = new g.a((Context)paraman.getActivity());
      paramMenuItem.aEX(p.h.CoZ);
      paramMenuItem.bDE(paraman.getActivity().getResources().getString(p.h.CoS)).NF(true);
      paramMenuItem.c(new an..ExternalSyntheticLambda5(paraman)).show();
    }
    AppMethodBeat.o(352873);
  }
  
  private static final void a(an paraman, View paramView)
  {
    AppMethodBeat.i(352858);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paraman);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/component/FinderLiveNoticeQRCodeUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paraman, "this$0");
    paraman.getActivity().finish();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/component/FinderLiveNoticeQRCodeUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(352858);
  }
  
  private static final void a(an paraman, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(352866);
    kotlin.g.b.s.u(paraman, "this$0");
    if (params.jmw())
    {
      com.tencent.mm.plugin.findersdk.a.m localm = com.tencent.mm.plugin.findersdk.a.m.Hce;
      params.a(com.tencent.mm.plugin.findersdk.a.m.frB(), paraman.getActivity().getResources().getColor(p.b.Red), (CharSequence)paraman.getActivity().getResources().getString(p.h.CoZ));
    }
    AppMethodBeat.o(352866);
  }
  
  private static final void a(an paraman, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(352871);
    kotlin.g.b.s.u(paraman, "this$0");
    Object localObject1;
    Object localObject2;
    if (paramBoolean)
    {
      localObject1 = paraman.BvE;
      if (localObject1 != null)
      {
        localObject2 = z.bAW();
        kotlin.g.b.s.s(localObject2, "getMyFinderUsername()");
        paramString = ((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).el((Context)paraman.getActivity());
        if (paramString != null) {
          break label141;
        }
      }
    }
    label141:
    for (paramString = null;; paramString = paramString.fou())
    {
      paramString = new bs((String)localObject2, (bkk)localObject1, 1, paramString);
      com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)paramString, 0);
      localObject2 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      q.av localav = q.av.DzU;
      localObject1 = ((bkk)localObject1).YSR;
      paramString = (String)localObject1;
      if (localObject1 == null) {
        paramString = "";
      }
      ((com.tencent.mm.plugin.finder.live.report.j)localObject2).a(localav, "", paramString);
      paraman.a(true, null);
      AppMethodBeat.o(352871);
      return;
    }
  }
  
  private final void a(boolean paramBoolean, final DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(352844);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new q(paramBoolean, this, paramOnCancelListener));
    AppMethodBeat.o(352844);
  }
  
  private static final void b(an paraman, View paramView)
  {
    AppMethodBeat.i(352876);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paraman);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/component/FinderLiveNoticeQRCodeUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paraman, "this$0");
    paramView = new f((Context)paraman.getActivity(), 1, true);
    paramView.Vtg = new an..ExternalSyntheticLambda3(paraman);
    paramView.GAC = new an..ExternalSyntheticLambda4(paraman);
    paramView.dDn();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/component/FinderLiveNoticeQRCodeUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(352876);
  }
  
  private static final void c(an paraman, View paramView)
  {
    AppMethodBeat.i(352884);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paraman);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/component/FinderLiveNoticeQRCodeUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(paraman, "this$0");
    localObject2 = (ce)com.tencent.mm.kernel.h.ax(ce.class);
    q.av localav = q.av.DzV;
    paramView = paraman.BvE;
    if (paramView == null) {
      paramView = "";
    }
    for (;;)
    {
      ((ce)localObject2).a(localav, "", paramView);
      paramView = BitmapUtil.getBitmapFromView((View)paraman.CAF.getValue());
      if (paramView != null)
      {
        localObject1 = ((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).bUk();
        BitmapUtil.saveBitmapToImage(paramView, 80, Bitmap.CompressFormat.JPEG, (String)localObject1, true);
        ExportFileUtil.a((Context)paraman.getActivity(), (String)localObject1, (ExportFileUtil.a)new b(paraman));
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/component/FinderLiveNoticeQRCodeUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(352884);
      return;
      localObject1 = paramView.YSR;
      paramView = (View)localObject1;
      if (localObject1 == null) {
        paramView = "";
      }
    }
  }
  
  private final TextView eiK()
  {
    AppMethodBeat.i(352799);
    TextView localTextView = (TextView)this.CAA.getValue();
    AppMethodBeat.o(352799);
    return localTextView;
  }
  
  private final TextView eiL()
  {
    AppMethodBeat.i(352804);
    TextView localTextView = (TextView)this.CAC.getValue();
    AppMethodBeat.o(352804);
    return localTextView;
  }
  
  private final TextView eiM()
  {
    AppMethodBeat.i(352811);
    TextView localTextView = (TextView)this.CAD.getValue();
    AppMethodBeat.o(352811);
    return localTextView;
  }
  
  private final TextView eiN()
  {
    AppMethodBeat.i(352818);
    TextView localTextView = (TextView)this.CAH.getValue();
    AppMethodBeat.o(352818);
    return localTextView;
  }
  
  private final View eiO()
  {
    AppMethodBeat.i(352822);
    View localView = (View)this.CAI.getValue();
    AppMethodBeat.o(352822);
    return localView;
  }
  
  private final View eiP()
  {
    AppMethodBeat.i(352830);
    View localView = (View)this.CAJ.getValue();
    AppMethodBeat.o(352830);
    return localView;
  }
  
  private final void eiQ()
  {
    AppMethodBeat.i(352837);
    aa.y((Context)getActivity(), getActivity().getResources().getString(p.h.Cpa), p.g.icons_filled_close);
    AppMethodBeat.o(352837);
  }
  
  public final int getLayoutId()
  {
    return p.f.CeL;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(353005);
    super.onCreate(paramBundle);
    paramBundle = getActivity().getIntent().getStringExtra(CAM);
    if (paramBundle != null)
    {
      localObject3 = com.tencent.mm.plugin.finder.api.d.AwY;
      this.contact = d.a.auT(paramBundle);
    }
    paramBundle = getActivity().getIntent().getByteArrayExtra(CAN);
    if (paramBundle != null)
    {
      this.BvE = new bkk();
      localObject3 = this.BvE;
      kotlin.g.b.s.checkNotNull(localObject3);
      ((bkk)localObject3).parseFrom(paramBundle);
    }
    com.tencent.mm.ui.aw.a((Paint)eiM().getPaint(), 0.8F);
    com.tencent.mm.ui.aw.a((Paint)eiK().getPaint(), 0.8F);
    ((TextView)this.CAK.getValue()).setTextSize(1, 14.0F);
    ((TextView)this.CAL.getValue()).setTextSize(1, 13.0F);
    eiK().setTextSize(1, 17.0F);
    eiL().setTextSize(1, 20.0F);
    eiM().setTextSize(1, 20.0F);
    eiN().setTextSize(1, 15.0F);
    paramBundle = this.contact;
    if (paramBundle == null) {
      paramBundle = null;
    }
    int i;
    for (;;)
    {
      if (paramBundle == null) {
        ((an)this).getActivity().finish();
      }
      paramBundle = this.BvE;
      if (paramBundle != null) {
        break;
      }
      if (localObject1 == null) {
        ((an)this).getActivity().finish();
      }
      i = getActivity().getResources().getDimensionPixelOffset(p.c.Edge_A);
      eiO().setPadding(i, bf.getStatusBarHeight((Context)getActivity()), i, 0);
      eiO().setOnClickListener(new an..ExternalSyntheticLambda0(this));
      eiP().setPadding(i, bf.getStatusBarHeight((Context)getActivity()), i, 0);
      eiP().setOnClickListener(new an..ExternalSyntheticLambda1(this));
      com.tencent.mm.kernel.h.aZW().a(4214, (com.tencent.mm.am.h)this);
      com.tencent.mm.kernel.h.aZW().a(6653, (com.tencent.mm.am.h)this);
      getRootView().post(new an..ExternalSyntheticLambda6(this));
      AppMethodBeat.o(353005);
      return;
      if (((CharSequence)paramBundle.getUsername()).length() > 0)
      {
        i = 1;
        label406:
        if (i == 0) {
          break label424;
        }
      }
      for (;;)
      {
        if (paramBundle != null) {
          break label429;
        }
        paramBundle = null;
        break;
        i = 0;
        break label406;
        label424:
        paramBundle = null;
      }
      label429:
      localObject3 = com.tencent.mm.plugin.finder.loader.p.ExI;
      localObject3 = com.tencent.mm.plugin.finder.loader.p.eCp();
      Object localObject4 = new com.tencent.mm.plugin.finder.loader.b(paramBundle.amx());
      ImageView localImageView = (ImageView)this.CAz.getValue();
      kotlin.g.b.s.s(localImageView, "mAvatarView");
      com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
      ((com.tencent.mm.loader.d)localObject3).a(localObject4, localImageView, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExM));
      eiK().setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b((Context)getActivity(), (CharSequence)paramBundle.getNickname()));
      localObject3 = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
      kotlin.g.b.s.s(localObject3, "service(IFinderCommonService::class.java)");
      localObject3 = (com.tencent.mm.plugin.h)localObject3;
      localObject4 = (ImageView)this.CAB.getValue();
      kotlin.g.b.s.s(localObject4, "mAuthView");
      h.a.a((com.tencent.mm.plugin.h)localObject3, (ImageView)localObject4, paramBundle.field_authInfo, 0, null, 12);
      paramBundle = ah.aiuX;
    }
    Object localObject3 = paramBundle.hAR;
    if (localObject3 != null) {
      if (((CharSequence)localObject3).length() > 0)
      {
        i = 1;
        label614:
        if (i != 1) {
          break label726;
        }
        i = 1;
        label621:
        if (i == 0) {
          break label731;
        }
        label625:
        if (paramBundle == null) {
          break label734;
        }
        localObject1 = paramBundle.YSR;
        if (localObject1 != null) {
          break label736;
        }
      }
    }
    label803:
    label806:
    for (;;)
    {
      if (localObject2 == null) {
        ((an)this).eiL().setVisibility(4);
      }
      localObject1 = eiM();
      localObject2 = getActivity().getResources();
      i = p.h.Cpd;
      localObject3 = com.tencent.mm.plugin.finder.utils.aw.Gjk;
      ((TextView)localObject1).setText((CharSequence)((Resources)localObject2).getString(i, new Object[] { com.tencent.mm.plugin.finder.utils.aw.a(paramBundle.startTime * 1000L, Boolean.TRUE, false, 4) }));
      localObject1 = ah.aiuX;
      break;
      i = 0;
      break label614;
      label726:
      i = 0;
      break label621;
      label731:
      paramBundle = null;
      break label625;
      label734:
      break;
      label736:
      if (((CharSequence)localObject1).length() > 0)
      {
        i = 1;
        label750:
        if (i == 0) {
          break label803;
        }
      }
      for (;;)
      {
        if (localObject1 == null) {
          break label806;
        }
        eiL().setVisibility(0);
        eiL().setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b((Context)getActivity(), (CharSequence)localObject1));
        localObject2 = ah.aiuX;
        break;
        i = 0;
        break label750;
        localObject1 = null;
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(353011);
    super.onDestroy();
    com.tencent.mm.kernel.h.aZW().b(4214, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.aZW().b(6653, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(353011);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    Object localObject1 = null;
    AppMethodBeat.i(353028);
    a(false, null);
    Object localObject2;
    if ((paramp instanceof dx)) {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localObject2 = ((dx)paramp).dWI();
        paramString = ((dx)paramp).dWI().ZTN;
        if (paramString == null)
        {
          paramString = null;
          paramString = BitmapUtil.decodeByteArray(paramString);
          Log.i("SimpleUIComponent", kotlin.g.b.s.X("qrcode url ", ((bkn)localObject2).YKR));
          if ((paramString != null) || (Util.isNullOrNil(((bkn)localObject2).YKR))) {
            break label503;
          }
          localObject2 = ((bkn)localObject2).YKR;
          if (localObject2 != null) {
            break label143;
          }
          paramString = null;
        }
      }
    }
    label143:
    label314:
    label461:
    label482:
    label503:
    for (;;)
    {
      if (paramString == null) {}
      for (paramString = (String)localObject1;; paramString = ah.aiuX)
      {
        if (paramString != null) {
          break label314;
        }
        ((an)this).eiQ();
        AppMethodBeat.o(353028);
        return;
        paramString = paramString.Op;
        break;
        paramString = this.contact;
        if (paramString == null) {
          paramString = "";
        }
        for (;;)
        {
          paramString = com.tencent.mm.modelavatar.d.a(paramString, false, -1, null);
          paramString = BitmapUtil.getRoundedCornerBitmap(paramString, false, 0.5F * paramString.getWidth());
          float f = bd.bs((Context)getActivity(), p.c.Edge_7A) * 1.0F / paramString.getWidth();
          paramString = BitmapUtil.createLayerBitmap(BitmapUtil.rotateAndScale(paramString, 0.0F, f, f), BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(p.d.finder_round_avatar_bg)), true);
          paramString = com.tencent.mm.bz.a.a.b((Context)getActivity(), paramString, (String)localObject2);
          break;
          paramp = paramString.getUsername();
          paramString = paramp;
          if (paramp == null) {
            paramString = "";
          }
        }
        ((ImageView)this.CAE.getValue()).setImageBitmap(paramString);
        eiN().setVisibility(0);
        eiN().setOnClickListener(new an..ExternalSyntheticLambda2(this));
      }
      AppMethodBeat.o(353028);
      return;
      eiQ();
      AppMethodBeat.o(353028);
      return;
      if (((paramp instanceof bs)) && (paramInt1 == 0) && (paramInt2 == 0))
      {
        localObject1 = (g)com.tencent.mm.kernel.h.ax(g.class);
        paramString = this.BvE;
        if (paramString != null) {
          break label461;
        }
        paramString = "";
        ((g)localObject1).Sw(paramString);
        localObject1 = new Intent();
        paramString = this.BvE;
        if (paramString != null) {
          break label482;
        }
        paramString = "";
      }
      for (;;)
      {
        ((Intent)localObject1).putExtra("ACTIVITY_RESULT_REMOVE_NOTICE_KEY", paramString);
        getActivity().setResult(1000, (Intent)localObject1);
        getActivity().finish();
        aa.db((Context)getContext(), getActivity().getResources().getString(p.h.CoT));
        AppMethodBeat.o(353028);
        return;
        paramp = paramString.hAR;
        paramString = paramp;
        if (paramp != null) {
          break;
        }
        paramString = "";
        break;
        paramp = paramString.hAR;
        paramString = paramp;
        if (paramp == null) {
          paramString = "";
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/component/FinderLiveNoticeQRCodeUIC$doExportImg$1", "Lcom/tencent/mm/platformtools/ExportFileUtil$ExportResultCallback;", "onExportFail", "", "srcPath", "", "destPath", "onExportSuccess", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements ExportFileUtil.a
  {
    b(an paraman) {}
    
    public final void cg(String paramString1, String paramString2)
    {
      AppMethodBeat.i(352803);
      kotlin.g.b.s.u(paramString1, "srcPath");
      kotlin.g.b.s.u(paramString2, "destPath");
      aa.y((Context)this.CAO.getActivity(), this.CAO.getActivity().getResources().getString(p.h.Cpc), p.g.icons_filled_done);
      AppMethodBeat.o(352803);
    }
    
    public final void ch(String paramString1, String paramString2)
    {
      AppMethodBeat.i(352810);
      kotlin.g.b.s.u(paramString1, "srcPath");
      kotlin.g.b.s.u(paramString2, "destPath");
      aa.y((Context)this.CAO.getActivity(), this.CAO.getActivity().getResources().getString(p.h.Cpb), p.g.icons_filled_close);
      AppMethodBeat.o(352810);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/component/FinderLiveNoticeQRCodeUIC$doScene$1", "Landroid/content/DialogInterface$OnCancelListener;", "onCancel", "", "dialog", "Landroid/content/DialogInterface;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements DialogInterface.OnCancelListener
  {
    c(an paraman) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(352798);
      this.CAO.getActivity().finish();
      AppMethodBeat.o(352798);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ImageView>
  {
    d(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ImageView>
  {
    e(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<View>
  {
    f(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<TextView>
  {
    g(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<TextView>
  {
    h(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<View>
  {
    i(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<TextView>
  {
    j(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends u
    implements kotlin.g.a.a<ImageView>
  {
    k(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends u
    implements kotlin.g.a.a<View>
  {
    l(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends u
    implements kotlin.g.a.a<TextView>
  {
    m(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends u
    implements kotlin.g.a.a<ImageView>
  {
    n(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class o
    extends u
    implements kotlin.g.a.a<TextView>
  {
    o(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class p
    extends u
    implements kotlin.g.a.a<TextView>
  {
    p(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class q
    extends u
    implements kotlin.g.a.a<ah>
  {
    q(boolean paramBoolean, an paraman, DialogInterface.OnCancelListener paramOnCancelListener)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.an
 * JD-Core Version:    0.7.0.1
 */