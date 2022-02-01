package com.tencent.mm.plugin.finder.profile.widget;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.openim.model.q;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.profile.uic.h.c;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.findersdk.a.bw;
import com.tencent.mm.protocal.protobuf.auc;
import com.tencent.mm.protocal.protobuf.aud;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bzb;
import com.tencent.mm.ui.base.w;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.ah.f;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;
import kotlin.n.n;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/widget/HeaderEnterpriseAddWidget;", "", "header", "Landroid/view/View;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Landroid/view/View;Landroidx/appcompat/app/AppCompatActivity;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getActivity", "()Landroidx/appcompat/app/AppCompatActivity;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "dialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "enterpriseAdd", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "getEnterpriseAdd", "()Landroid/widget/RelativeLayout;", "enterpriseAdd$delegate", "Lkotlin/Lazy;", "enterpriseName", "Landroid/widget/TextView;", "getEnterpriseName", "()Landroid/widget/TextView;", "enterpriseName$delegate", "isAddEnterpriseClick", "", "dismissDialog", "", "handleEnterprise", "username", "", "profileContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "handleSearchContactEnd", "scene", "Lcom/tencent/mm/openim/model/NetSceneSearchOpenIMContact;", "reportWecomFriend", "action", "", "contactId", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  private final bui Auc;
  private final j FgR;
  private final j FgS;
  public boolean FgT;
  public final AppCompatActivity activity;
  public w rYw;
  
  public b(View paramView, AppCompatActivity paramAppCompatActivity, bui parambui)
  {
    AppMethodBeat.i(349299);
    this.activity = paramAppCompatActivity;
    this.Auc = parambui;
    this.FgR = k.cm((kotlin.g.a.a)new a(paramView));
    this.FgS = k.cm((kotlin.g.a.a)new b(paramView));
    AppMethodBeat.o(349299);
  }
  
  private static final void a(b paramb, ah.f paramf, View paramView)
  {
    AppMethodBeat.i(349330);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramf);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/widget/HeaderEnterpriseAddWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramb, "this$0");
    kotlin.g.b.s.u(paramf, "$contactId");
    if (!paramb.FgT)
    {
      paramb.FgT = true;
      com.tencent.mm.kernel.h.aZW().a((p)new q((String)paramf.aqH, true), 0);
      paramb.rYw = w.a(paramb.eKF().getContext(), (CharSequence)paramb.eKF().getContext().getString(e.h.loading_tips_1), true, 3, null);
      paramb.bA(1, (String)paramf.aqH);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/profile/widget/HeaderEnterpriseAddWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(349330);
  }
  
  private final void bA(int paramInt, String paramString)
  {
    AppMethodBeat.i(349316);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("finderusername", com.tencent.mm.model.z.bAW());
    localJSONObject.put("kfcontactid", paramString);
    paramString = com.tencent.mm.plugin.finder.report.z.FrZ;
    paramString = localJSONObject.toString();
    kotlin.g.b.s.s(paramString, "kvJson.toString()");
    com.tencent.mm.plugin.finder.report.z.b(paramInt, "finder_add_wecom_fri", n.bV(paramString, ",", ";"), this.Auc);
    AppMethodBeat.o(349316);
  }
  
  private final RelativeLayout eKF()
  {
    AppMethodBeat.i(349306);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.FgR.getValue();
    AppMethodBeat.o(349306);
    return localRelativeLayout;
  }
  
  public final void b(String paramString, m paramm)
  {
    int k = 1;
    AppMethodBeat.i(349354);
    kotlin.g.b.s.u(paramString, "username");
    ah.f localf = new ah.f();
    Object localObject = com.tencent.mm.plugin.finder.profile.uic.h.FdM;
    localObject = (h.c)com.tencent.mm.plugin.finder.profile.uic.h.access$getUserExtInfoCache$cp().get(paramString);
    label84:
    label102:
    label114:
    int j;
    if (localObject == null)
    {
      localObject = "";
      localf.aqH = localObject;
      localObject = com.tencent.mm.plugin.finder.profile.uic.h.FdM;
      paramString = (h.c)com.tencent.mm.plugin.finder.profile.uic.h.access$getUserExtInfoCache$cp().get(paramString);
      if (paramString != null) {
        break label322;
      }
      localObject = "";
      if (((CharSequence)localf.aqH).length() != 0) {
        break label359;
      }
      i = 1;
      if (i != 0)
      {
        if (paramm != null) {
          break label364;
        }
        paramString = "";
        localf.aqH = paramString;
      }
      if (((CharSequence)localf.aqH).length() <= 0) {
        break label500;
      }
      i = 1;
      label138:
      paramString = av.GiL;
      if (av.fgg() != 6) {
        break label505;
      }
      j = 1;
      label153:
      boolean bool = ((bw)com.tencent.mm.kernel.h.ax(bw.class)).aBu();
      if ((i == 0) || (j != 0) || (bool)) {
        break label516;
      }
      if (eKF().getVisibility() != 0)
      {
        eKF().setVisibility(0);
        bA(0, (String)localf.aqH);
      }
      if (((CharSequence)localObject).length() <= 0) {
        break label511;
      }
    }
    label322:
    label359:
    label364:
    label500:
    label505:
    label511:
    for (int i = k;; i = 0)
    {
      if (i != 0) {
        ((TextView)this.FgS.getValue()).setText((CharSequence)localObject);
      }
      eKF().setOnClickListener(new b..ExternalSyntheticLambda0(this, localf));
      AppMethodBeat.o(349354);
      return;
      localObject = ((h.c)localObject).FeJ;
      if (localObject == null)
      {
        localObject = "";
        break;
      }
      String str = ((bzb)localObject).ZUc;
      localObject = str;
      if (str != null) {
        break;
      }
      localObject = "";
      break;
      paramString = paramString.FeJ;
      if (paramString == null)
      {
        localObject = "";
        break label84;
      }
      paramString = paramString.aaid;
      localObject = paramString;
      if (paramString != null) {
        break label84;
      }
      localObject = "";
      break label84;
      i = 0;
      break label102;
      paramString = paramm.field_bindInfoList;
      if (paramString == null)
      {
        paramString = "";
        break label114;
      }
      paramString = paramString.bind_info;
      if (paramString == null)
      {
        paramString = "";
        break label114;
      }
      paramm = ((Iterable)paramString).iterator();
      if (paramm.hasNext())
      {
        paramString = paramm.next();
        if (((auc)paramString).ZEC == 2)
        {
          i = 1;
          if (i == 0) {
            break label458;
          }
        }
      }
      for (;;)
      {
        paramString = (auc)paramString;
        if (paramString != null) {
          break label465;
        }
        paramString = "";
        break;
        i = 0;
        break label435;
        break label406;
        paramString = null;
      }
      paramString = paramString.ZED;
      if (paramString == null)
      {
        paramString = "";
        break label114;
      }
      paramString = paramString.ZUc;
      if (paramString == null)
      {
        paramString = "";
        break label114;
      }
      break label114;
      i = 0;
      break label138;
      j = 0;
      break label153;
    }
    label406:
    label435:
    label458:
    label465:
    eKF().setVisibility(8);
    label516:
    AppMethodBeat.o(349354);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<RelativeLayout>
  {
    a(View paramView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<TextView>
  {
    b(View paramView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.widget.b
 * JD-Core Version:    0.7.0.1
 */