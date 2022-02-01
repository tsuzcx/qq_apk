package com.tencent.mm.plugin.appbrand.phonenumber;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.luggage.m.a.f;
import com.tencent.luggage.m.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.o;
import com.tencent.mm.plugin.appbrand.jsapi.aj;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.plugin.appbrand.widget.dialog.e;
import com.tencent.mm.plugin.appbrand.widget.dialog.r;
import com.tencent.mm.ui.bb;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManageDialog;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/BasePhoneNumberManageDialog;", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView;", "context", "Landroid/content/Context;", "appId", "", "(Landroid/content/Context;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "mItemAdapter", "Lcom/tencent/mm/plugin/appbrand/phonenumber/ItemAdapter;", "onAccept", "Lkotlin/Function1;", "", "", "getOnAccept", "()Lkotlin/jvm/functions/Function1;", "setOnAccept", "(Lkotlin/jvm/functions/Function1;)V", "onAddPhoneNumber", "Lkotlin/Function0;", "getOnAddPhoneNumber", "()Lkotlin/jvm/functions/Function0;", "setOnAddPhoneNumber", "(Lkotlin/jvm/functions/Function0;)V", "onCancel", "getOnCancel", "setOnCancel", "onDeny", "getOnDeny", "setOnDeny", "onExplain", "getOnExplain", "setOnExplain", "onManagePhoneNumber", "getOnManagePhoneNumber", "setOnManagePhoneNumber", "onPhoneItemSelect", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "getOnPhoneItemSelect", "setOnPhoneItemSelect", "value", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "phoneItems", "getPhoneItems", "()Ljava/util/ArrayList;", "setPhoneItems", "(Ljava/util/ArrayList;)V", "createSecondaryExplainPresenterView", "Lcom/tencent/mm/plugin/appbrand/permission/IAuthorizePrivacyExplainPresenterView;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "content", "webviewOpener", "Lcom/tencent/mm/plugin/appbrand/jsapi/IExternalToolsHelper;", "dismiss", "getDialogHeight", "", "onBackPressedEvent", "onDismiss", "setDialogApplyWording", "wording", "setDialogRequestDesc", "setDialogSubDesc", "desc", "show", "showPrivacyExplainEntry", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class v
  extends a
  implements com.tencent.mm.plugin.appbrand.jsapi.autofill.a.a
{
  kotlin.g.a.a<ah> Uu;
  private final String appId;
  private ArrayList<PhoneItem> rIF;
  private kotlin.g.a.a<ah> rIK;
  private kotlin.g.a.a<ah> rIL;
  private kotlin.g.a.a<ah> rIM;
  private q thp;
  kotlin.g.a.b<? super Boolean, ah> thq;
  kotlin.g.a.a<ah> thr;
  kotlin.g.a.b<? super PhoneItem, ah> ths;
  
  public v(Context paramContext, String paramString)
  {
    super(paramContext);
    AppMethodBeat.i(148135);
    this.appId = paramString;
    this.rIF = new ArrayList();
    this.thq = ((kotlin.g.a.b)v.a.tHp);
    this.thr = ((kotlin.g.a.a)v.d.tHs);
    this.Uu = ((kotlin.g.a.a)v.c.tHr);
    this.rIK = ((kotlin.g.a.a)v.e.tHt);
    this.rIL = ((kotlin.g.a.a)v.b.tHq);
    this.rIM = ((kotlin.g.a.a)v.f.tHu);
    this.ths = ((kotlin.g.a.b)v.g.tHv);
    a((a.b)new a.b()
    {
      public final void CQ(int paramAnonymousInt)
      {
        AppMethodBeat.i(318904);
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(318904);
          return;
          this.tHo.thq.invoke(Boolean.valueOf(this.tHo.tgW.cBy()));
          Object localObject1 = v.b(this.tHo);
          if (localObject1 == null) {}
          for (localObject1 = null;; localObject1 = ((q)localObject1).rIF)
          {
            s.checkNotNull(localObject1);
            Object localObject2 = ((ArrayList)localObject1).iterator();
            do
            {
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
              localObject1 = (PhoneItem)((Iterator)localObject2).next();
            } while (!((PhoneItem)localObject1).tGP);
            localObject2 = this.tHo.ths;
            s.s(localObject1, "phoneItem");
            ((kotlin.g.a.b)localObject2).invoke(localObject1);
            AppMethodBeat.o(318904);
            return;
          }
          this.tHo.thr.invoke();
          AppMethodBeat.o(318904);
          return;
          this.tHo.Uu.invoke();
        }
      }
    });
    a(new v..ExternalSyntheticLambda0(this));
    cHh().setOnClickListener(new v..ExternalSyntheticLambda2(this));
    cHf().setVisibility(0);
    AppMethodBeat.o(148135);
  }
  
  private static final void a(v paramv)
  {
    AppMethodBeat.i(318881);
    s.u(paramv, "this$0");
    Object localObject = paramv.appId;
    Context localContext = paramv.getContext();
    s.s(localContext, "context");
    paramv.thp = new q((String)localObject, localContext, paramv.rIF);
    paramv.cHg().setAdapter((RecyclerView.a)paramv.thp);
    if (paramv.rIF.size() == 0)
    {
      paramv.cHi().setVisibility(0);
      paramv.cHg().setVisibility(8);
      paramv.cHh().setVisibility(8);
      AppMethodBeat.o(318881);
      return;
    }
    if (paramv.rIF.size() == 1)
    {
      paramv.cHi().setVisibility(8);
      paramv.cHg().setVisibility(0);
      localObject = paramv.cHg().getAdapter();
      if (localObject != null) {
        ((RecyclerView.a)localObject).bZE.notifyChanged();
      }
      paramv.cHh().setVisibility(0);
      paramv.cHh().setText((CharSequence)paramv.getContext().getString(a.g.appbrand_phone_number_use_other_phone_number));
      localObject = u.tHm;
      if (!u.cHB().cHs())
      {
        paramv.cHh().setVisibility(8);
        AppMethodBeat.o(318881);
      }
    }
    else
    {
      paramv.cHi().setVisibility(8);
      paramv.cHg().setVisibility(0);
      paramv.cHh().setVisibility(0);
      localObject = paramv.cHg().getAdapter();
      if (localObject != null) {
        ((RecyclerView.a)localObject).bZE.notifyChanged();
      }
      paramv.cHh().setText((CharSequence)paramv.getContext().getString(a.g.appbrand_phone_number_manager_phone_number));
      localObject = u.tHm;
      if (!u.cHB().cHs()) {
        paramv.cHh().setVisibility(8);
      }
    }
    AppMethodBeat.o(318881);
  }
  
  private static final void a(v paramv, View paramView)
  {
    AppMethodBeat.i(318887);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramv);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManageDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramv, "this$0");
    paramv.rIK.invoke();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManageDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(318887);
  }
  
  private static final void b(v paramv, View paramView)
  {
    AppMethodBeat.i(318891);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramv);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManageDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramv, "this$0");
    if (paramv.rIF.size() == 1) {
      paramv.rIL.invoke();
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManageDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(318891);
      return;
      paramv.rIM.invoke();
    }
  }
  
  private static final void c(v paramv, View paramView)
  {
    AppMethodBeat.i(318894);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramv);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManageDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramv, "this$0");
    paramv.rIK.invoke();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManageDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(318894);
  }
  
  private r j(com.tencent.mm.plugin.appbrand.g paramg)
  {
    AppMethodBeat.i(318872);
    paramg = com.tencent.mm.plugin.appbrand.jsapi.autofill.a.a.a.a((com.tencent.mm.plugin.appbrand.jsapi.autofill.a.a)this, paramg);
    AppMethodBeat.o(318872);
    return paramg;
  }
  
  public final com.tencent.mm.plugin.appbrand.permission.g a(com.tencent.mm.plugin.appbrand.g paramg, String paramString, aj paramaj)
  {
    AppMethodBeat.i(318998);
    s.u(paramg, "component");
    Context localContext = getContext();
    s.s(localContext, "this.context");
    paramString = new k(paramaj, paramString, localContext, cHe().getMeasuredHeight());
    if (paramg.getWindowAndroid().asu()) {
      paramString.setPosition(1);
    }
    paramg = (com.tencent.mm.plugin.appbrand.permission.g)paramString;
    AppMethodBeat.o(318998);
    return paramg;
  }
  
  public final boolean bQg()
  {
    return false;
  }
  
  public final void h(com.tencent.mm.plugin.appbrand.g paramg)
  {
    AppMethodBeat.i(318988);
    s.u(paramg, "component");
    super.setPosition(super.getPosition());
    j(paramg).b((com.tencent.mm.plugin.appbrand.widget.dialog.n)this);
    AppMethodBeat.o(318988);
  }
  
  public final void i(com.tencent.mm.plugin.appbrand.g paramg)
  {
    AppMethodBeat.i(318991);
    s.u(paramg, "component");
    j(paramg).c((com.tencent.mm.plugin.appbrand.widget.dialog.n)this);
    AppMethodBeat.o(318991);
  }
  
  public final void jc(boolean paramBoolean)
  {
    AppMethodBeat.i(318982);
    super.kC(paramBoolean);
    if (paramBoolean)
    {
      super.N(bb.m(getContext(), a.f.icon_info, androidx.core.content.a.w(getContext(), com.tencent.luggage.m.a.a.BW_0_Alpha_0_3)));
      super.afu(getContext().getString(a.g.app_brand_supplement_info));
      super.a(new v..ExternalSyntheticLambda1(this));
      AppMethodBeat.o(318982);
      return;
    }
    super.a(null);
    AppMethodBeat.o(318982);
  }
  
  public final void onDismiss()
  {
    AppMethodBeat.i(148134);
    onCancel();
    AppMethodBeat.o(148134);
  }
  
  public final void setDialogApplyWording(String paramString)
  {
    AppMethodBeat.i(318978);
    s.u(paramString, "wording");
    setApplyWording(paramString);
    AppMethodBeat.o(318978);
  }
  
  public final void setDialogRequestDesc(String paramString)
  {
    AppMethodBeat.i(318974);
    s.u(paramString, "wording");
    setRequestDesc(paramString);
    AppMethodBeat.o(318974);
  }
  
  public final void setDialogSubDesc(String paramString)
  {
    AppMethodBeat.i(318968);
    s.u(paramString, "desc");
    setSimpleDetailDesc(paramString);
    AppMethodBeat.o(318968);
  }
  
  public final void setOnAccept(kotlin.g.a.b<? super Boolean, ah> paramb)
  {
    AppMethodBeat.i(318928);
    s.u(paramb, "<set-?>");
    this.thq = paramb;
    AppMethodBeat.o(318928);
  }
  
  public final void setOnAddPhoneNumber(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(318949);
    s.u(parama, "<set-?>");
    this.rIL = parama;
    AppMethodBeat.o(318949);
  }
  
  public final void setOnCancel(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(318937);
    s.u(parama, "<set-?>");
    this.Uu = parama;
    AppMethodBeat.o(318937);
  }
  
  public final void setOnDeny(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(318931);
    s.u(parama, "<set-?>");
    this.thr = parama;
    AppMethodBeat.o(318931);
  }
  
  public final void setOnExplain(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(318942);
    s.u(parama, "<set-?>");
    this.rIK = parama;
    AppMethodBeat.o(318942);
  }
  
  public final void setOnManagePhoneNumber(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(318954);
    s.u(parama, "<set-?>");
    this.rIM = parama;
    AppMethodBeat.o(318954);
  }
  
  public final void setOnPhoneItemSelect(kotlin.g.a.b<? super PhoneItem, ah> paramb)
  {
    AppMethodBeat.i(318962);
    s.u(paramb, "<set-?>");
    this.ths = paramb;
    AppMethodBeat.o(318962);
  }
  
  public final void setPhoneItems(ArrayList<PhoneItem> paramArrayList)
  {
    AppMethodBeat.i(148133);
    s.u(paramArrayList, "value");
    this.rIF.clear();
    this.rIF.addAll((Collection)paramArrayList);
    o.runOnUiThread(new v..ExternalSyntheticLambda3(this));
    AppMethodBeat.o(148133);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.v
 * JD-Core Version:    0.7.0.1
 */