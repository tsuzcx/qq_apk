package com.tencent.mm.plugin.appbrand.phonenumber;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.jsapi.ac;
import com.tencent.mm.plugin.appbrand.permission.g;
import com.tencent.mm.plugin.appbrand.permission.h.a;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import d.g.b.p;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManageDialog;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/BaseRequestDialog;", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView;", "context", "Landroid/content/Context;", "appId", "", "(Landroid/content/Context;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "mItemAdapter", "Lcom/tencent/mm/plugin/appbrand/phonenumber/ItemAdapter;", "onAccept", "Lkotlin/Function0;", "", "getOnAccept", "()Lkotlin/jvm/functions/Function0;", "setOnAccept", "(Lkotlin/jvm/functions/Function0;)V", "onAddPhoneNumber", "getOnAddPhoneNumber", "setOnAddPhoneNumber", "onCancel", "getOnCancel", "setOnCancel", "onDeny", "getOnDeny", "setOnDeny", "onExplain", "getOnExplain", "setOnExplain", "onManagePhoneNumber", "getOnManagePhoneNumber", "setOnManagePhoneNumber", "onPhoneItemSelect", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "getOnPhoneItemSelect", "()Lkotlin/jvm/functions/Function1;", "setOnPhoneItemSelect", "(Lkotlin/jvm/functions/Function1;)V", "value", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "phoneItems", "getPhoneItems", "()Ljava/util/ArrayList;", "setPhoneItems", "(Ljava/util/ArrayList;)V", "createSecondaryExplainPresenterView", "Lcom/tencent/mm/plugin/appbrand/permission/IAuthorizePrivacyExplainPresenterView;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "content", "webviewOpener", "Lcom/tencent/mm/plugin/appbrand/jsapi/IExternalToolsHelper;", "dismiss", "getDialogHeight", "", "onBackPressedEvent", "", "onDismiss", "show", "showPrivacyExplainEntry", "luggage-wechat-full-sdk_release"})
public final class v
  extends a
  implements com.tencent.mm.plugin.appbrand.jsapi.autofill.b.a
{
  final String appId;
  ArrayList<PhoneItem> kEO;
  d.g.a.a<z> kEP;
  d.g.a.a<z> kER;
  d.g.a.a<z> kET;
  d.g.a.a<z> kEU;
  d.g.a.a<z> kEV;
  d.g.a.b<? super PhoneItem, z> lUA;
  private q lUy;
  d.g.a.a<z> lUz;
  
  public v(Context paramContext, String paramString)
  {
    super(paramContext);
    AppMethodBeat.i(148135);
    this.appId = paramString;
    this.kEO = new ArrayList();
    this.kEP = ((d.g.a.a)v.a.mpu);
    this.lUz = ((d.g.a.a)v.d.mpx);
    this.kER = ((d.g.a.a)v.c.mpw);
    this.kET = ((d.g.a.a)v.e.mpy);
    this.kEU = ((d.g.a.a)v.b.mpv);
    this.kEV = ((d.g.a.a)v.f.mpz);
    this.lUA = ((d.g.a.b)v.g.mpA);
    this.mnT = ((a.b)new a.b()
    {
      public final void vc(int paramAnonymousInt)
      {
        AppMethodBeat.i(148123);
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(148123);
          return;
          this.mpt.kEP.invoke();
          Object localObject1 = v.a(this.mpt);
          if (localObject1 != null) {}
          for (localObject1 = ((q)localObject1).kEO;; localObject1 = null)
          {
            if (localObject1 == null) {
              p.gkB();
            }
            Object localObject2 = ((ArrayList)localObject1).iterator();
            do
            {
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
              localObject1 = (PhoneItem)((Iterator)localObject2).next();
            } while (!((PhoneItem)localObject1).moN);
            localObject2 = this.mpt.lUA;
            p.g(localObject1, "phoneItem");
            ((d.g.a.b)localObject2).invoke(localObject1);
            AppMethodBeat.o(148123);
            return;
          }
          this.mpt.lUz.invoke();
          AppMethodBeat.o(148123);
          return;
          this.mpt.kER.invoke();
        }
      }
    });
    a((View.OnClickListener)new v.2(this));
    this.lUx.setOnClickListener((View.OnClickListener)new v.3(this));
    this.lUw.setVisibility(0);
    AppMethodBeat.o(148135);
  }
  
  public final g a(d paramd, String paramString, ac paramac)
  {
    AppMethodBeat.i(221019);
    p.h(paramd, "component");
    Context localContext = getContext();
    p.g(localContext, "this.context");
    paramString = new k(paramac, paramString, localContext, this.iFK.getMeasuredHeight());
    paramd = paramd.getWindowAndroid();
    p.g(paramd, "component.windowAndroid");
    if (paramd.aXi()) {
      paramString.setPosition(1);
    }
    paramd = (g)paramString;
    AppMethodBeat.o(221019);
    return paramd;
  }
  
  public final boolean aOS()
  {
    return false;
  }
  
  public final void gp(boolean paramBoolean)
  {
    AppMethodBeat.i(221017);
    Object localObject = this.mnR;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      ((ImageView)localObject).setVisibility(i);
      if (!paramBoolean) {
        break;
      }
      localObject = android.support.v4.content.b.l(getContext(), 2131230993);
      this.mnU = ((Drawable)localObject);
      this.mnR.setVisibility(8);
      if (localObject != null)
      {
        this.mnR.setImageDrawable(this.mnU);
        this.mnR.setVisibility(0);
      }
      super.a((View.OnClickListener)new v.i(this));
      AppMethodBeat.o(221017);
      return;
    }
    super.a(null);
    AppMethodBeat.o(221017);
  }
  
  public final void h(d paramd)
  {
    AppMethodBeat.i(221018);
    p.h(paramd, "component");
    super.setPosition(this.iGp);
    p.h(paramd, "$this$findPromptViewContainer");
    p.h(paramd, "$this$findPromptViewContainer");
    h.a.k(paramd).b((com.tencent.mm.plugin.appbrand.widget.dialog.k)this);
    AppMethodBeat.o(221018);
  }
  
  public final void onDismiss()
  {
    AppMethodBeat.i(148134);
    onCancel();
    AppMethodBeat.o(148134);
  }
  
  public final void setOnAddPhoneNumber(d.g.a.a<z> parama)
  {
    AppMethodBeat.i(221014);
    p.h(parama, "<set-?>");
    this.kEU = parama;
    AppMethodBeat.o(221014);
  }
  
  public final void setOnCancel(d.g.a.a<z> parama)
  {
    AppMethodBeat.i(221012);
    p.h(parama, "<set-?>");
    this.kER = parama;
    AppMethodBeat.o(221012);
  }
  
  public final void setOnDeny(d.g.a.a<z> parama)
  {
    AppMethodBeat.i(221011);
    p.h(parama, "<set-?>");
    this.lUz = parama;
    AppMethodBeat.o(221011);
  }
  
  public final void setOnExplain(d.g.a.a<z> parama)
  {
    AppMethodBeat.i(221013);
    p.h(parama, "<set-?>");
    this.kET = parama;
    AppMethodBeat.o(221013);
  }
  
  public final void setOnManagePhoneNumber(d.g.a.a<z> parama)
  {
    AppMethodBeat.i(221015);
    p.h(parama, "<set-?>");
    this.kEV = parama;
    AppMethodBeat.o(221015);
  }
  
  public final void setOnPhoneItemSelect(d.g.a.b<? super PhoneItem, z> paramb)
  {
    AppMethodBeat.i(221016);
    p.h(paramb, "<set-?>");
    this.lUA = paramb;
    AppMethodBeat.o(221016);
  }
  
  public final void setPhoneItems(ArrayList<PhoneItem> paramArrayList)
  {
    AppMethodBeat.i(148133);
    p.h(paramArrayList, "value");
    this.kEO.clear();
    this.kEO.addAll((Collection)paramArrayList);
    com.tencent.mm.plugin.appbrand.y.m.runOnUiThread((Runnable)new h(this));
    AppMethodBeat.o(148133);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(v paramv) {}
    
    public final void run()
    {
      AppMethodBeat.i(148132);
      Object localObject = this.mpt;
      String str = this.mpt.appId;
      Context localContext = this.mpt.getContext();
      p.g(localContext, "context");
      v.a((v)localObject, new q(str, localContext, this.mpt.kEO));
      this.mpt.anl.setAdapter((RecyclerView.a)v.a(this.mpt));
      if (this.mpt.kEO.size() == 0)
      {
        this.mpt.fVr.setVisibility(0);
        this.mpt.anl.setVisibility(8);
        this.mpt.lUx.setVisibility(8);
        AppMethodBeat.o(148132);
        return;
      }
      if (this.mpt.kEO.size() == 1)
      {
        this.mpt.fVr.setVisibility(8);
        this.mpt.anl.setVisibility(0);
        localObject = this.mpt.anl.getAdapter();
        if (localObject != null) {
          ((RecyclerView.a)localObject).notifyDataSetChanged();
        }
        this.mpt.lUx.setVisibility(0);
        this.mpt.lUx.setText((CharSequence)this.mpt.getContext().getString(2131756029));
        localObject = u.mps;
        u.bxp();
        AppMethodBeat.o(148132);
        return;
      }
      this.mpt.fVr.setVisibility(8);
      this.mpt.anl.setVisibility(0);
      this.mpt.lUx.setVisibility(0);
      localObject = this.mpt.anl.getAdapter();
      if (localObject != null) {
        ((RecyclerView.a)localObject).notifyDataSetChanged();
      }
      this.mpt.lUx.setText((CharSequence)this.mpt.getContext().getString(2131756027));
      localObject = u.mps;
      u.bxp();
      AppMethodBeat.o(148132);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.v
 * JD-Core Version:    0.7.0.1
 */