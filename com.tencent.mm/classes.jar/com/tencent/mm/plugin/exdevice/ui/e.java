package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.d.a.a.a.b.b.e;
import com.tencent.d.a.a.a.b.b.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.a.zp;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.z;
import com.tencent.mm.modelavatar.j;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.exdevice.g.a.g;
import com.tencent.mm.plugin.sport.a.d;
import com.tencent.mm.pluginsdk.platformtools.f;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.brs;
import com.tencent.mm.protocal.protobuf.cuz;
import com.tencent.mm.protocal.protobuf.dwa;
import com.tencent.mm.protocal.protobuf.fhb;
import com.tencent.mm.protocal.protobuf.fhc;
import com.tencent.mm.protocal.protobuf.fhw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.ah.d;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/exdevice/ui/SportProfileUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "appName", "", "getAppName", "()Ljava/lang/String;", "setAppName", "(Ljava/lang/String;)V", "hasWinterOlympic", "", "getHasWinterOlympic", "()Z", "setHasWinterOlympic", "(Z)V", "value", "Lcom/tencent/mm/protocal/protobuf/GetUserRankDetailResponse;", "profileData", "getProfileData", "()Lcom/tencent/mm/protocal/protobuf/GetUserRankDetailResponse;", "setProfileData", "(Lcom/tencent/mm/protocal/protobuf/GetUserRankDetailResponse;)V", "rankId", "getRankId", "setRankId", "sportRecordList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/SportRecord;", "getSportRecordList", "()Ljava/util/LinkedList;", "setSportRecordList", "(Ljava/util/LinkedList;)V", "winterOlympicsSportRecord", "getWinterOlympicsSportRecord", "()Lcom/tencent/mm/protocal/protobuf/SportRecord;", "setWinterOlympicsSportRecord", "(Lcom/tencent/mm/protocal/protobuf/SportRecord;)V", "inflateItemView", "Landroid/view/View;", "viewType", "", "initSportRecordList", "", "detailResponse", "setFixedTextSize", "textView", "Landroid/widget/TextView;", "size", "", "startSportHistoryActivity", "username", "updateItemView", "itemView", "position", "AddFollowBtnViewHolder", "Companion", "GoalViewHolder", "OtherBtnViewHolder", "ProfileViewHolder", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends UIComponent
{
  public static final e.b yEH;
  String appName;
  public LinkedList<LinkedList<fhc>> yAO;
  public cuz yEI;
  private boolean yEJ;
  public fhc yEK;
  String yuk;
  
  static
  {
    AppMethodBeat.i(274800);
    yEH = new e.b((byte)0);
    AppMethodBeat.o(274800);
  }
  
  public e(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(274750);
    this.yAO = new LinkedList();
    AppMethodBeat.o(274750);
  }
  
  private static final void a(int paramInt, ah.d paramd, String paramString1, e parame, String paramString2, String paramString3, View paramView)
  {
    AppMethodBeat.i(274774);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).sc(paramInt);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramd);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramString1);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(parame);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramString2);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramString3);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/exdevice/ui/SportProfileUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(paramd, "$step");
    kotlin.g.b.s.u(paramString1, "$username");
    kotlin.g.b.s.u(parame, "this$0");
    d.g(48, paramInt, paramd.aixb, "2022_hj");
    paramd = q.bFE();
    if (paramd == null)
    {
      paramd = null;
      if (paramd != null) {
        break label325;
      }
      Log.w("SimpleUIComponent", kotlin.g.b.s.X("updateItemView: imgFlag is null. username:", paramString1));
      paramd = "";
    }
    label325:
    for (;;)
    {
      localObject2 = aa.getDisplayName(paramString1);
      Log.i("SimpleUIComponent", "updateItemView: winterOlympicLayout OnClickListener avatarUrl:" + paramd + " nickName:" + localObject2);
      paramView = (com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class);
      parame = (Context)parame.getContext();
      localObject1 = new brs();
      ((brs)localObject1).ZVq = paramString3;
      ((brs)localObject1).ZVs = paramd;
      ((brs)localObject1).ZVr = ((String)localObject2);
      paramd = ah.aiuX;
      paramd = new dwa();
      paramString3 = b.e.ahon;
      paramd.abbK = b.e.a.jWa();
      paramd.hLv = paramString1;
      paramString1 = ah.aiuX;
      paramView.gotoLive(parame, paramString2, (brs)localObject1, paramd);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/exdevice/ui/SportProfileUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(274774);
      return;
      paramd = paramd.LS(paramString1);
      if (paramd == null)
      {
        paramd = null;
        break;
      }
      paramd = paramd.bFw();
      break;
    }
  }
  
  private final void a(TextView paramTextView, float paramFloat)
  {
    AppMethodBeat.i(274753);
    com.tencent.mm.plugin.finder.accessibility.a locala = com.tencent.mm.plugin.finder.accessibility.a.Ate;
    paramTextView.setTextSize(1, com.tencent.mm.plugin.finder.accessibility.a.g((Context)getContext(), paramFloat));
    AppMethodBeat.o(274753);
  }
  
  private static final void a(e.c paramc, WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(274778);
    kotlin.g.b.s.u(paramc, "$holder");
    kotlin.g.b.s.u(paramWxaAttributes, "$info");
    Object localObject = paramc.pJc;
    if (localObject != null) {
      ((TextView)localObject).setText((CharSequence)paramWxaAttributes.field_nickname);
    }
    localObject = new c.a();
    ((c.a)localObject).nrc = true;
    ((c.a)localObject).oKo = true;
    localObject = ((c.a)localObject).bKx();
    r.bKe().a(paramWxaAttributes.field_smallHeadURL, paramc.rIe, (com.tencent.mm.modelimage.loader.a.c)localObject);
    AppMethodBeat.o(274778);
  }
  
  private static final void a(e parame, View paramView)
  {
    AppMethodBeat.i(274756);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parame);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/exdevice/ui/SportProfileUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(parame, "this$0");
    d.rG(8);
    paramView = new AppBrandStatObject();
    paramView.scene = 1063;
    ((t)com.tencent.mm.kernel.h.ax(t.class)).a((Context)parame.getActivity(), null, "wx3fca79fc5715b185", 0, 0, "", paramView);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/exdevice/ui/SportProfileUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(274756);
  }
  
  private static final void a(e parame, fhc paramfhc, WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(274794);
    kotlin.g.b.s.u(parame, "this$0");
    kotlin.g.b.s.u(paramfhc, "$sportRecord");
    if (paramWxaAttributes != null)
    {
      g.a locala = new g.a(MMApplicationContext.getContext());
      locala.bDE(parame.getActivity().getString(R.l.top_story_open_appbrand, new Object[] { paramWxaAttributes.field_nickname })).NF(true);
      locala.aEX(R.l.app_accept);
      locala.c(new e..ExternalSyntheticLambda10(paramWxaAttributes, paramfhc)).show();
    }
    AppMethodBeat.o(274794);
  }
  
  private static final void a(e parame, String paramString, View paramView)
  {
    AppMethodBeat.i(274765);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parame);
    localb.cH(paramString);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/exdevice/ui/SportProfileUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(parame, "this$0");
    kotlin.g.b.s.u(paramString, "$username");
    paramView = new Intent((Context)parame.getActivity(), SportHistoryUI.class);
    paramView.putExtra("username", paramString);
    parame = parame.getActivity();
    paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramView);
    com.tencent.mm.hellhoundlib.a.a.b(parame, paramString.aYi(), "com/tencent/mm/plugin/exdevice/ui/SportProfileUIC", "startSportHistoryActivity", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    parame.startActivity((Intent)paramString.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(parame, "com/tencent/mm/plugin/exdevice/ui/SportProfileUIC", "startSportHistoryActivity", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/exdevice/ui/SportProfileUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(274765);
  }
  
  private static final void a(fhc paramfhc, e parame, View paramView)
  {
    AppMethodBeat.i(274797);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramfhc);
    localb.cH(parame);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/exdevice/ui/SportProfileUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramfhc, "$sportRecord");
    kotlin.g.b.s.u(parame, "this$0");
    ((com.tencent.mm.plugin.appbrand.service.s)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.s.class)).b(paramfhc.appId, new e..ExternalSyntheticLambda9(parame, paramfhc));
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/exdevice/ui/SportProfileUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(274797);
  }
  
  private static final void a(String paramString, e parame, View paramView)
  {
    AppMethodBeat.i(274772);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramString);
    localb.cH(parame);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/exdevice/ui/SportProfileUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramString, "$username");
    kotlin.g.b.s.u(parame, "this$0");
    paramView = new Intent();
    paramView.putExtra("Contact_User", paramString);
    com.tencent.mm.br.c.b((Context)parame.getActivity(), "profile", ".ui.ContactInfoUI", paramView);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/exdevice/ui/SportProfileUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(274772);
  }
  
  private static final void b(WxaAttributes paramWxaAttributes, fhc paramfhc, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(274790);
    kotlin.g.b.s.u(paramWxaAttributes, "$wxaAttributes");
    kotlin.g.b.s.u(paramfhc, "$sportRecord");
    if (paramBoolean)
    {
      paramString = new zp();
      paramString.icM.userName = paramWxaAttributes.field_username;
      paramString.icM.icO = paramfhc.abHG;
      paramString.icM.scene = 1171;
      paramString.publish();
    }
    AppMethodBeat.o(274790);
  }
  
  private static final void b(e.c paramc, WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(274787);
    kotlin.g.b.s.u(paramc, "$holder");
    if (paramWxaAttributes != null) {
      com.tencent.threadpool.h.ahAA.bk(new e..ExternalSyntheticLambda11(paramc, paramWxaAttributes));
    }
    AppMethodBeat.o(274787);
  }
  
  private static final void b(e parame, View paramView)
  {
    AppMethodBeat.i(274759);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parame);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/exdevice/ui/SportProfileUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(parame, "this$0");
    paramView = new Intent((Context)parame.getActivity(), ExdeviceFollowsUI.class);
    parame = parame.getActivity();
    paramView = new com.tencent.mm.hellhoundlib.b.a().cG(paramView);
    com.tencent.mm.hellhoundlib.a.a.b(parame, paramView.aYi(), "com/tencent/mm/plugin/exdevice/ui/SportProfileUIC", "updateItemView$lambda-5", "(Lcom/tencent/mm/plugin/exdevice/ui/SportProfileUIC;Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    parame.startActivity((Intent)paramView.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(parame, "com/tencent/mm/plugin/exdevice/ui/SportProfileUIC", "updateItemView$lambda-5", "(Lcom/tencent/mm/plugin/exdevice/ui/SportProfileUIC;Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/exdevice/ui/SportProfileUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(274759);
  }
  
  private static final void c(e parame, View paramView)
  {
    AppMethodBeat.i(274761);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parame);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/exdevice/ui/SportProfileUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(parame, "this$0");
    if ((parame.getActivity() instanceof ExdeviceProfileUI))
    {
      parame = (ExdeviceProfileUI)parame.getActivity();
      d.rG(17);
      paramView = new ArrayList();
      paramView.add(parame.sWX);
      bh.aZW().a(new g(paramView, parame.yBp), 0);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/exdevice/ui/SportProfileUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(274761);
  }
  
  private static final void d(e parame, View paramView)
  {
    AppMethodBeat.i(274769);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(parame);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/exdevice/ui/SportProfileUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(parame, "this$0");
    if ((!Util.isNullOrNil(parame.yuk)) && (!kotlin.g.b.s.p("#", parame.yuk)))
    {
      localObject2 = new Intent((Context)parame.getActivity(), ExdeviceLikeUI.class);
      localObject1 = parame.appName;
      paramView = (View)localObject1;
      if (localObject1 == null) {
        paramView = "";
      }
      ((Intent)localObject2).putExtra("app_username", paramView);
      localObject1 = parame.yuk;
      paramView = (View)localObject1;
      if (localObject1 == null) {
        paramView = "";
      }
      ((Intent)localObject2).putExtra("rank_id", paramView);
      ((Intent)localObject2).putExtra("key_is_like_read_only", true);
      parame = parame.getActivity();
      paramView = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
      com.tencent.mm.hellhoundlib.a.a.b(parame, paramView.aYi(), "com/tencent/mm/plugin/exdevice/ui/SportProfileUIC", "updateItemView$lambda-8", "(Lcom/tencent/mm/plugin/exdevice/ui/SportProfileUIC;Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      parame.startActivity((Intent)paramView.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(parame, "com/tencent/mm/plugin/exdevice/ui/SportProfileUIC", "updateItemView$lambda-8", "(Lcom/tencent/mm/plugin/exdevice/ui/SportProfileUIC;Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/exdevice/ui/SportProfileUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(274769);
  }
  
  public final void a(int paramInt1, View paramView, String paramString, int paramInt2)
  {
    AppMethodBeat.i(274852);
    kotlin.g.b.s.u(paramView, "itemView");
    kotlin.g.b.s.u(paramString, "username");
    label274:
    label447:
    label506:
    Object localObject2;
    label525:
    label550:
    label609:
    Object localObject5;
    label782:
    label824:
    label858:
    label863:
    label887:
    Object localObject6;
    label896:
    label924:
    label942:
    label947:
    label988:
    Object localObject4;
    Object localObject7;
    Object localObject8;
    Object localObject9;
    switch (paramInt1)
    {
    default: 
      paramView = ah.aiuX;
    case 2: 
      do
      {
        AppMethodBeat.o(274852);
        return;
        paramView = paramView.getTag();
        if (paramView == null)
        {
          paramView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.exdevice.ui.SportProfileUIC.OtherBtnViewHolder");
          AppMethodBeat.o(274852);
          throw paramView;
        }
        paramView = (e.d)paramView;
        paramString = paramView.yEP;
        if (paramString != null)
        {
          paramString.setOnClickListener(new e..ExternalSyntheticLambda1(this));
          paramString = ah.aiuX;
        }
        paramView = paramView.yEO;
      } while (paramView == null);
      paramView.setOnClickListener(new e..ExternalSyntheticLambda4(this));
      paramView = ah.aiuX;
      AppMethodBeat.o(274852);
      return;
    case 3: 
      paramView = paramView.getTag();
      if (paramView == null)
      {
        paramView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.exdevice.ui.SportProfileUIC.AddFollowBtnViewHolder");
        AppMethodBeat.o(274852);
        throw paramView;
      }
      paramView = (e.a)paramView;
      if (!kotlin.g.b.s.p(paramString, z.bAM()))
      {
        paramString = this.yEI;
        if ((paramString != null) && (paramString.yug == true))
        {
          paramInt1 = 1;
          if (paramInt1 != 0) {
            break label274;
          }
          paramString = paramView.yEL;
          if (paramString != null) {
            paramString.setVisibility(0);
          }
          paramView = paramView.yEL;
          if (paramView != null)
          {
            paramView.setOnClickListener(new e..ExternalSyntheticLambda2(this));
            paramView = ah.aiuX;
          }
        }
      }
      for (;;)
      {
        paramView = ah.aiuX;
        AppMethodBeat.o(274852);
        return;
        paramInt1 = 0;
        break;
        paramView = paramView.yEL;
        if (paramView != null) {
          paramView.setVisibility(8);
        }
      }
    case 0: 
      paramView = paramView.getTag();
      if (paramView == null)
      {
        paramView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.exdevice.ui.SportProfileUIC.ProfileViewHolder");
        AppMethodBeat.o(274852);
        throw paramView;
      }
      localObject1 = (e)paramView;
      a.b.g(((e)localObject1).xaN, paramString);
      paramView = ((e)localObject1).yER;
      if (paramView == null)
      {
        paramView = null;
        aw.d((Paint)paramView);
        paramView = ((e)localObject1).yEQ;
        if (paramView != null) {
          paramView.setText((CharSequence)aa.getDisplayName(paramString));
        }
        paramView = ((e)localObject1).wRf;
        if (paramView != null) {
          paramView.setText((CharSequence)f.formatTime(getActivity().getString(R.l.fmt_date), cn.getSyncServerTimeSecond()));
        }
        paramView = ((e)localObject1).wRf;
        if (paramView != null)
        {
          paramView.setOnClickListener(new e..ExternalSyntheticLambda5(this, paramString));
          paramView = ah.aiuX;
        }
        paramView = this.yEI;
        if (paramView != null) {
          break label782;
        }
        paramInt1 = 0;
        paramView = ((e)localObject1).yES;
        if (paramView != null) {
          paramView.setText((CharSequence)String.valueOf(paramInt1));
        }
        if (paramInt1 < 10000) {
          break label824;
        }
        paramView = ((e)localObject1).yES;
        if (paramView != null)
        {
          paramView.setTextColor(getActivity().getResources().getColor(R.e.fky));
          paramView = ah.aiuX;
        }
        paramView = this.yEI;
        if ((paramView == null) || (paramView.LXq != true)) {
          break label858;
        }
        paramInt1 = 1;
        if (paramInt1 == 0) {
          break label863;
        }
        paramView = ((e)localObject1).yEV;
        if (paramView != null)
        {
          paramView.setImageResource(R.k.device_rank_item_liked);
          paramView = ah.aiuX;
        }
        if (kotlin.g.b.s.p(paramString, z.bAM()))
        {
          paramView = ((e)localObject1).yEV;
          if (paramView != null)
          {
            paramView.setOnClickListener(new e..ExternalSyntheticLambda3(this));
            paramView = ah.aiuX;
          }
        }
        paramView = ((e)localObject1).yAA;
        if (paramView != null)
        {
          localObject2 = this.yEI;
          if (localObject2 != null) {
            break label887;
          }
          paramInt1 = 0;
          paramView.setText((CharSequence)String.valueOf(paramInt1));
        }
        paramView = ((e)localObject1).yEN;
        if (paramView != null)
        {
          paramView.removeAllViews();
          paramView = ah.aiuX;
        }
        paramView = this.yEI;
        if (paramView != null) {
          break label896;
        }
        paramView = null;
      }
      for (;;)
      {
        if (paramView == null)
        {
          paramView = ((e)localObject1).yEN;
          if (paramView != null) {
            paramView.setVisibility(8);
          }
          paramView = ((e)localObject1).yET;
          if (paramView != null) {
            paramView.setVisibility(8);
          }
          paramView = ah.aiuX;
        }
        paramView = ((e)localObject1).xaN;
        if (paramView != null)
        {
          paramView.setOnClickListener(new e..ExternalSyntheticLambda7(paramString, this));
          paramView = ah.aiuX;
        }
        localObject5 = this.yEK;
        if (localObject5 != null) {
          break label988;
        }
        paramView = null;
        if (paramView == null)
        {
          if (!((e)this).yEJ)
          {
            paramView = ((e)localObject1).yEW;
            if (paramView != null) {
              paramView.setVisibility(8);
            }
          }
          paramView = ah.aiuX;
        }
        paramView = ah.aiuX;
        AppMethodBeat.o(274852);
        return;
        paramView = paramView.getPaint();
        break;
        paramView = paramView.YGC;
        if (paramView == null)
        {
          paramInt1 = 0;
          break label447;
        }
        paramView = (fhw)p.oN((List)paramView);
        if (paramView == null)
        {
          paramInt1 = 0;
          break label447;
        }
        paramInt1 = paramView.rBp;
        break label447;
        paramView = ((e)localObject1).yES;
        if (paramView == null) {
          break label506;
        }
        paramView.setTextColor(getActivity().getResources().getColor(R.e.fkx));
        paramView = ah.aiuX;
        break label506;
        paramInt1 = 0;
        break label525;
        paramView = ((e)localObject1).yEV;
        if (paramView == null) {
          break label550;
        }
        paramView.setImageResource(R.k.device_rank_item_unliked);
        paramView = ah.aiuX;
        break label550;
        paramInt1 = ((cuz)localObject2).ZqA;
        break label609;
        paramView = paramView.aaAB;
        if (paramView == null)
        {
          paramView = null;
        }
        else
        {
          if (!((Collection)paramView).isEmpty())
          {
            paramInt1 = 1;
            if (paramInt1 == 0) {
              break label942;
            }
          }
          for (;;)
          {
            if (paramView != null) {
              break label947;
            }
            paramView = null;
            break;
            paramInt1 = 0;
            break label924;
            paramView = null;
          }
          paramView = ((e)localObject1).yEN;
          if (paramView != null) {
            paramView.setVisibility(0);
          }
          paramView = ((e)localObject1).yET;
          if (paramView != null) {
            paramView.setVisibility(0);
          }
          paramView = ah.aiuX;
          paramView = ah.aiuX;
        }
      }
      if (((fhc)localObject5).abHH == 2) {
        this.yEJ = true;
      }
      for (;;)
      {
        try
        {
          localObject6 = new JSONObject(((fhc)localObject5).abHG);
          ((JSONObject)localObject6).optString("rank");
          localObject2 = ((JSONObject)localObject6).optString("profile1_pre");
          localObject3 = ((JSONObject)localObject6).optString("profile1_suf");
          paramView = ((JSONObject)localObject6).optString("profile2");
          localObject4 = ((JSONObject)localObject6).optString("rank_num");
          localObject6 = ((JSONObject)localObject6).optString("finder_username");
          localObject7 = ((e)localObject1).yEW;
          if (localObject7 != null)
          {
            ((ViewGroup)localObject7).setVisibility(0);
            localObject8 = new ah.d();
            localObject9 = this.yEI;
            if (localObject9 != null) {
              continue;
            }
            paramInt1 = 0;
            ((ah.d)localObject8).aixb = paramInt1;
            localObject9 = this.yEI;
            if (localObject9 != null) {
              continue;
            }
            paramInt1 = 0;
            localObject9 = com.tencent.mm.ui.component.k.aeZF;
            if (!((com.tencent.mm.ui.chatting.m.c)com.tencent.mm.ui.component.k.d(getActivity()).q(com.tencent.mm.ui.chatting.m.c.class)).jxe().contains(((fhc)localObject5).abHG))
            {
              d.g(47, paramInt1, ((ah.d)localObject8).aixb, "2022_hj");
              localObject9 = com.tencent.mm.ui.component.k.aeZF;
              localObject9 = ((com.tencent.mm.ui.chatting.m.c)com.tencent.mm.ui.component.k.d(getActivity()).q(com.tencent.mm.ui.chatting.m.c.class)).jxe();
              localObject5 = ((fhc)localObject5).abHG;
              kotlin.g.b.s.s(localObject5, "record.sportUrl");
              ((Set)localObject9).add(localObject5);
            }
            ((ViewGroup)localObject7).setOnClickListener(new e..ExternalSyntheticLambda0(paramInt1, (ah.d)localObject8, paramString, this, (String)localObject6, (String)localObject4));
            paramString = ah.aiuX;
            paramString = ah.aiuX;
          }
          paramString = ((e)localObject1).yEX;
          if (paramString != null)
          {
            aw.d((Paint)paramString.getPaint());
            paramString.setText((CharSequence)(localObject2 + localObject4 + localObject3));
            paramString = ah.aiuX;
            paramString = ah.aiuX;
          }
          paramString = ((e)localObject1).yEY;
          if (paramString != null) {
            paramString.setText((CharSequence)paramView);
          }
        }
        finally
        {
          paramString = ((e)localObject1).yEW;
          if (paramString == null) {
            continue;
          }
          paramString.setVisibility(8);
          Log.e("SimpleUIComponent", kotlin.g.b.s.X("updateItemView: ", paramView));
          continue;
        }
        paramView = ah.aiuX;
        paramView = ah.aiuX;
        break;
        localObject9 = ((cuz)localObject9).YGC;
        if (localObject9 == null)
        {
          paramInt1 = 0;
        }
        else
        {
          localObject9 = (fhw)p.oN((List)localObject9);
          if (localObject9 == null)
          {
            paramInt1 = 0;
          }
          else
          {
            paramInt1 = ((fhw)localObject9).rBp;
            continue;
            paramInt1 = ((cuz)localObject9).ZqA;
          }
        }
      }
    }
    paramView = paramView.getTag();
    if (paramView == null)
    {
      paramView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.exdevice.ui.SportProfileUIC.GoalViewHolder");
      AppMethodBeat.o(274852);
      throw paramView;
    }
    Object localObject1 = (e.c)paramView;
    paramView = (Collection)this.yAO;
    if ((paramView == null) || (paramView.isEmpty()))
    {
      paramInt1 = 1;
      if ((paramInt1 != 0) || (paramInt2 > this.yAO.size())) {
        break label2715;
      }
      paramView = this.yAO.get(paramInt2 - 1);
      kotlin.g.b.s.s(paramView, "sportRecordList[position - 1]");
      localObject2 = (LinkedList)paramView;
      if (!((Collection)localObject2).isEmpty()) {
        break label1594;
      }
      paramInt1 = 1;
      label1555:
      if (paramInt1 == 0)
      {
        paramView = ((e.c)localObject1).yEN;
        if ((paramView == null) || (paramView.getChildCount() != 0)) {
          break label1599;
        }
      }
    }
    label1594:
    label1599:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 != 0) {
        break label1604;
      }
      AppMethodBeat.o(274852);
      return;
      paramInt1 = 0;
      break;
      paramInt1 = 0;
      break label1555;
    }
    label1604:
    paramView = ((LinkedList)localObject2).get(0);
    kotlin.g.b.s.s(paramView, "list[0]");
    Object localObject3 = (fhc)paramView;
    if (((fhc)localObject3).abHH == 0) {
      if (!kotlin.g.b.s.p("21f9d636b41b25be", ((fhc)localObject3).appId))
      {
        ((com.tencent.mm.plugin.appbrand.service.s)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.s.class)).b(((fhc)localObject3).appId, new e..ExternalSyntheticLambda8((e.c)localObject1));
        paramView = ((e.c)localObject1).yEN;
        if (paramView != null)
        {
          paramView.setOnClickListener(new e..ExternalSyntheticLambda6((fhc)localObject3, this));
          paramView = ah.aiuX;
        }
        label1702:
        paramString = ((Iterable)localObject2).iterator();
        label1713:
        if (!paramString.hasNext()) {
          break label2715;
        }
        localObject2 = (fhc)paramString.next();
        paramView = (CharSequence)((fhc)localObject2).abHD;
        if ((paramView != null) && (paramView.length() != 0)) {
          break label2680;
        }
        paramInt1 = 1;
        label1757:
        if (paramInt1 != 0) {
          break label2683;
        }
        localObject3 = getActivity().getLayoutInflater().inflate(R.i.gjz, (ViewGroup)((e.c)localObject1).yEN, false);
        if (localObject3 != null) {
          break label2685;
        }
        paramView = null;
        label1792:
        if (paramView != null) {
          paramView.setText((CharSequence)((fhc)localObject2).abHD);
        }
        if (localObject3 != null)
        {
          paramView = (TextView)((View)localObject3).findViewById(R.h.fUC);
          if (paramView != null)
          {
            paramView.setText((CharSequence)String.valueOf(((fhc)localObject2).abHE));
            aw.d((Paint)paramView.getPaint());
            paramView = ah.aiuX;
          }
        }
        if (localObject3 != null) {
          break label2700;
        }
      }
    }
    label2308:
    label2700:
    for (paramView = null;; paramView = (TextView)((View)localObject3).findViewById(R.h.fUF))
    {
      if (paramView != null) {
        paramView.setText((CharSequence)((fhc)localObject2).abHF);
      }
      paramView = ((e.c)localObject1).yEN;
      if (paramView == null) {
        break label1713;
      }
      paramView.addView((View)localObject3);
      paramView = ah.aiuX;
      break label1713;
      paramView = ((e.c)localObject1).pJc;
      if (paramView != null)
      {
        paramView.setText(R.l.gWv);
        paramView = ah.aiuX;
      }
      paramView = ((e.c)localObject1).rIe;
      if (paramView != null)
      {
        paramView.setImageResource(R.k.icons_outlined_apple_watch);
        paramView = ah.aiuX;
      }
      paramView = ((e.c)localObject1).rIe;
      if (paramView != null)
      {
        paramView.setColorFilter(com.tencent.mm.cd.a.w((Context)getContext(), R.e.Purple_100));
        paramView = ah.aiuX;
      }
      paramView = this.yEI;
      if (paramView != null)
      {
        paramView = paramView.ZqB;
        if (paramView != null) {
          if (!((Collection)paramView).isEmpty())
          {
            paramInt1 = 1;
            if (paramInt1 != 1) {
              break label2395;
            }
            paramInt1 = 1;
            label2016:
            if (paramInt1 == 0)
            {
              paramView = this.yEI;
              if (paramView != null) {
                break label2400;
              }
              paramView = null;
              label2031:
              kotlin.g.b.s.checkNotNull(paramView);
              if (paramView.intValue() < 3) {
                break;
              }
            }
            localObject4 = getActivity().getLayoutInflater().inflate(R.i.gjw, (ViewGroup)((e.c)localObject1).yEN, false);
            localObject5 = (LinearLayout)((View)localObject4).findViewById(R.h.fXY);
            paramView = this.yEI;
            if (paramView != null) {
              break label2425;
            }
            paramView = null;
            label2091:
            if (paramView == null) {
              break label2488;
            }
            localObject6 = ((Iterable)paramView).iterator();
            label2106:
            if (!((Iterator)localObject6).hasNext()) {
              break label2484;
            }
            localObject8 = (fhb)((Iterator)localObject6).next();
            localObject7 = (LinearLayout)getActivity().getLayoutInflater().inflate(R.i.gjz, (ViewGroup)((e.c)localObject1).yEN, false);
            if (localObject7 != null) {
              break label2433;
            }
            paramString = null;
            label2162:
            if (paramString != null)
            {
              paramString.setText((CharSequence)((fhb)localObject8).abHA);
              a(paramString, 14.0F);
              paramString = ah.aiuX;
              paramString = ah.aiuX;
            }
            paramString = (int)((fhb)localObject8).abHx + '/' + (int)((fhb)localObject8).abHy;
            if (localObject7 != null)
            {
              localObject9 = (TextView)((LinearLayout)localObject7).findViewById(R.h.fUC);
              if (localObject9 != null)
              {
                ((TextView)localObject9).setText((CharSequence)paramString);
                aw.d((Paint)((TextView)localObject9).getPaint());
              }
            }
            switch (((fhb)localObject8).abHz)
            {
            default: 
              paramInt1 = R.e.black;
              ((TextView)localObject9).setTextColor(((TextView)localObject9).getContext().getResources().getColor(paramInt1));
              a((TextView)localObject9, 17.0F);
              paramString = ah.aiuX;
              if (localObject7 != null) {
                break;
              }
            }
          }
        }
      }
      for (paramString = null;; paramString = (TextView)((LinearLayout)localObject7).findViewById(R.h.fUF))
      {
        if (paramString != null)
        {
          paramString.setText((CharSequence)((fhb)localObject8).abHB);
          a(paramString, 14.0F);
          paramString = ah.aiuX;
          paramString = ah.aiuX;
        }
        ((LinearLayout)localObject5).addView((View)localObject7);
        break label2106;
        paramInt1 = 0;
        break;
        label2395:
        paramInt1 = 0;
        break label2016;
        label2400:
        paramView = paramView.ZqB;
        if (paramView == null)
        {
          paramView = null;
          break label2031;
        }
        paramView = Integer.valueOf(paramView.size());
        break label2031;
        label2425:
        paramView = paramView.ZqB;
        break label2091;
        paramString = (TextView)((LinearLayout)localObject7).findViewById(R.h.fUB);
        break label2162;
        paramInt1 = R.e.fks;
        break label2308;
        paramInt1 = R.e.fkr;
        break label2308;
        paramInt1 = R.e.fkq;
        break label2308;
      }
      label2484:
      paramString = ah.aiuX;
      label2488:
      if (localObject4 == null) {
        paramString = null;
      }
      while (paramString != null)
      {
        if (paramView != null)
        {
          paramView = ((Iterable)paramView).iterator();
          for (;;)
          {
            if (paramView.hasNext())
            {
              localObject5 = (fhb)paramView.next();
              paramString.a(((fhb)localObject5).abHz, ((fhb)localObject5).abHx, ((fhb)localObject5).abHy);
              continue;
              paramString = (ColorfulCircleProgress)((View)localObject4).findViewById(R.h.fJg);
              break;
            }
          }
          paramView = ah.aiuX;
        }
        paramView = ah.aiuX;
      }
      paramView = ((e.c)localObject1).yEN;
      if (paramView == null) {
        break;
      }
      paramView.addView((View)localObject4);
      paramView = ah.aiuX;
      break;
      if (((fhc)localObject3).abHH != 1) {
        break label1702;
      }
      paramView = ((e.c)localObject1).pJc;
      if (paramView != null) {
        paramView.setText((CharSequence)((fhc)localObject3).appName);
      }
      paramView = new c.a();
      paramView.oKn = true;
      paramView.oKp = true;
      paramView.nrc = true;
      paramView = paramView.bKx();
      r.bKe().a(((fhc)localObject3).phA, ((e.c)localObject1).rIe, paramView);
      break label1702;
      label2680:
      paramInt1 = 0;
      break label1757;
      label2683:
      break label1713;
      label2685:
      paramView = (TextView)((View)localObject3).findViewById(R.h.fUB);
      break label1792;
    }
    label2433:
    label2715:
    paramView = ah.aiuX;
    AppMethodBeat.o(274852);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/exdevice/ui/SportProfileUIC$ProfileViewHolder;", "", "(Lcom/tencent/mm/plugin/exdevice/ui/SportProfileUIC;)V", "likeIcon", "Landroid/widget/ImageView;", "getLikeIcon", "()Landroid/widget/ImageView;", "setLikeIcon", "(Landroid/widget/ImageView;)V", "mAvatarIv", "getMAvatarIv", "setMAvatarIv", "mDateTv", "Landroid/widget/TextView;", "getMDateTv", "()Landroid/widget/TextView;", "setMDateTv", "(Landroid/widget/TextView;)V", "mLikeCountTv", "getMLikeCountTv", "setMLikeCountTv", "mNickNameTv", "getMNickNameTv", "setMNickNameTv", "mSportLayout", "Landroid/widget/LinearLayout;", "getMSportLayout", "()Landroid/widget/LinearLayout;", "setMSportLayout", "(Landroid/widget/LinearLayout;)V", "mSportLayoutDivider", "Landroid/view/View;", "getMSportLayoutDivider", "()Landroid/view/View;", "setMSportLayoutDivider", "(Landroid/view/View;)V", "mStepTv", "getMStepTv", "setMStepTv", "mTodaySportsTv", "getMTodaySportsTv", "setMTodaySportsTv", "todayLayout", "getTodayLayout", "setTodayLayout", "tvJoinRunning", "getTvJoinRunning", "setTvJoinRunning", "tvNumberTorchRunner", "getTvNumberTorchRunner", "setTvNumberTorchRunner", "winterOlympicLayout", "Landroid/view/ViewGroup;", "getWinterOlympicLayout", "()Landroid/view/ViewGroup;", "setWinterOlympicLayout", "(Landroid/view/ViewGroup;)V", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class e
  {
    TextView wRf;
    ImageView xaN;
    TextView yAA;
    LinearLayout yEN;
    TextView yEQ;
    TextView yER;
    TextView yES;
    View yET;
    View yEU;
    ImageView yEV;
    ViewGroup yEW;
    TextView yEX;
    TextView yEY;
    
    public e()
    {
      AppMethodBeat.i(274686);
      AppMethodBeat.o(274686);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.e
 * JD-Core Version:    0.7.0.1
 */