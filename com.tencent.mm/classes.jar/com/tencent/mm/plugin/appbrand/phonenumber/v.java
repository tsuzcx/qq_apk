package com.tencent.mm.plugin.appbrand.phonenumber;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.luggage.l.a.f;
import com.tencent.luggage.l.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.jsapi.ag;
import com.tencent.mm.plugin.appbrand.jsapi.autofill.b.a.a;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.plugin.appbrand.widget.dialog.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManageDialog;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/BaseRequestDialog;", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView;", "context", "Landroid/content/Context;", "appId", "", "(Landroid/content/Context;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "mItemAdapter", "Lcom/tencent/mm/plugin/appbrand/phonenumber/ItemAdapter;", "onAccept", "Lkotlin/Function0;", "", "getOnAccept", "()Lkotlin/jvm/functions/Function0;", "setOnAccept", "(Lkotlin/jvm/functions/Function0;)V", "onAddPhoneNumber", "getOnAddPhoneNumber", "setOnAddPhoneNumber", "onCancel", "getOnCancel", "setOnCancel", "onDeny", "getOnDeny", "setOnDeny", "onExplain", "getOnExplain", "setOnExplain", "onManagePhoneNumber", "getOnManagePhoneNumber", "setOnManagePhoneNumber", "onPhoneItemSelect", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "getOnPhoneItemSelect", "()Lkotlin/jvm/functions/Function1;", "setOnPhoneItemSelect", "(Lkotlin/jvm/functions/Function1;)V", "value", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "phoneItems", "getPhoneItems", "()Ljava/util/ArrayList;", "setPhoneItems", "(Ljava/util/ArrayList;)V", "createSecondaryExplainPresenterView", "Lcom/tencent/mm/plugin/appbrand/permission/IAuthorizePrivacyExplainPresenterView;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "content", "webviewOpener", "Lcom/tencent/mm/plugin/appbrand/jsapi/IExternalToolsHelper;", "dismiss", "getDialogHeight", "", "onBackPressedEvent", "", "onDismiss", "show", "showPrivacyExplainEntry", "luggage-wechat-full-sdk_release"})
public final class v
  extends a
  implements com.tencent.mm.plugin.appbrand.jsapi.autofill.b.a
{
  final String appId;
  ArrayList<PhoneItem> oFB;
  kotlin.g.a.a<x> oFC;
  kotlin.g.a.a<x> oFE;
  kotlin.g.a.a<x> oFH;
  kotlin.g.a.a<x> oFI;
  kotlin.g.a.a<x> oFJ;
  private q qcv;
  kotlin.g.a.a<x> qcw;
  b<? super PhoneItem, x> qcx;
  
  public v(Context paramContext, String paramString)
  {
    super(paramContext);
    AppMethodBeat.i(148135);
    this.appId = paramString;
    this.oFB = new ArrayList();
    this.oFC = ((kotlin.g.a.a)v.a.qCr);
    this.qcw = ((kotlin.g.a.a)v.d.qCu);
    this.oFE = ((kotlin.g.a.a)v.c.qCt);
    this.oFH = ((kotlin.g.a.a)v.e.qCv);
    this.oFI = ((kotlin.g.a.a)v.b.qCs);
    this.oFJ = ((kotlin.g.a.a)v.f.qCw);
    this.qcx = ((b)v.g.qCx);
    this.qAQ = ((a.b)new a.b()
    {
      public final void Cz(int paramAnonymousInt)
      {
        AppMethodBeat.i(148123);
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(148123);
          return;
          this.qCq.oFC.invoke();
          Object localObject1 = v.a(this.qCq);
          if (localObject1 != null) {}
          for (localObject1 = ((q)localObject1).oFB;; localObject1 = null)
          {
            if (localObject1 == null) {
              p.iCn();
            }
            Object localObject2 = ((ArrayList)localObject1).iterator();
            do
            {
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
              localObject1 = (PhoneItem)((Iterator)localObject2).next();
            } while (!((PhoneItem)localObject1).qBK);
            localObject2 = this.qCq.qcx;
            p.j(localObject1, "phoneItem");
            ((b)localObject2).invoke(localObject1);
            AppMethodBeat.o(148123);
            return;
          }
          this.qCq.qcw.invoke();
          AppMethodBeat.o(148123);
          return;
          this.qCq.oFE.invoke();
        }
      }
    });
    a((View.OnClickListener)new v.2(this));
    this.qcu.setOnClickListener((View.OnClickListener)new v.3(this));
    cgo().setVisibility(0);
    AppMethodBeat.o(148135);
  }
  
  private com.tencent.mm.plugin.appbrand.widget.dialog.l o(com.tencent.mm.plugin.appbrand.g paramg)
  {
    AppMethodBeat.i(244231);
    p.k(paramg, "$this$findPromptViewContainer");
    paramg = a.a.e(paramg);
    AppMethodBeat.o(244231);
    return paramg;
  }
  
  public final com.tencent.mm.plugin.appbrand.permission.g a(com.tencent.mm.plugin.appbrand.g paramg, String paramString, ag paramag)
  {
    AppMethodBeat.i(244230);
    p.k(paramg, "component");
    Context localContext = getContext();
    p.j(localContext, "this.context");
    paramString = new k(paramag, paramString, localContext, cgn().getMeasuredHeight());
    paramg = paramg.getWindowAndroid();
    p.j(paramg, "component.windowAndroid");
    if (paramg.Sd()) {
      paramString.setPosition(1);
    }
    paramg = (com.tencent.mm.plugin.appbrand.permission.g)paramString;
    AppMethodBeat.o(244230);
    return paramg;
  }
  
  public final boolean bsB()
  {
    return false;
  }
  
  public final void i(com.tencent.mm.plugin.appbrand.g paramg)
  {
    AppMethodBeat.i(244227);
    p.k(paramg, "component");
    super.setPosition(super.getPosition());
    o(paramg).a((j)this);
    AppMethodBeat.o(244227);
  }
  
  public final void id(boolean paramBoolean)
  {
    AppMethodBeat.i(244226);
    super.jp(paramBoolean);
    if (paramBoolean)
    {
      super.E(androidx.core.content.a.m(getContext(), a.f.icon_info));
      super.a((View.OnClickListener)new v.i(this));
      AppMethodBeat.o(244226);
      return;
    }
    super.a(null);
    AppMethodBeat.o(244226);
  }
  
  public final void j(com.tencent.mm.plugin.appbrand.g paramg)
  {
    AppMethodBeat.i(244228);
    p.k(paramg, "component");
    o(paramg).b((j)this);
    AppMethodBeat.o(244228);
  }
  
  public final void onDismiss()
  {
    AppMethodBeat.i(148134);
    onCancel();
    AppMethodBeat.o(148134);
  }
  
  public final void setOnAddPhoneNumber(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(244222);
    p.k(parama, "<set-?>");
    this.oFI = parama;
    AppMethodBeat.o(244222);
  }
  
  public final void setOnCancel(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(244220);
    p.k(parama, "<set-?>");
    this.oFE = parama;
    AppMethodBeat.o(244220);
  }
  
  public final void setOnDeny(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(244219);
    p.k(parama, "<set-?>");
    this.qcw = parama;
    AppMethodBeat.o(244219);
  }
  
  public final void setOnExplain(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(244221);
    p.k(parama, "<set-?>");
    this.oFH = parama;
    AppMethodBeat.o(244221);
  }
  
  public final void setOnManagePhoneNumber(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(244224);
    p.k(parama, "<set-?>");
    this.oFJ = parama;
    AppMethodBeat.o(244224);
  }
  
  public final void setOnPhoneItemSelect(b<? super PhoneItem, x> paramb)
  {
    AppMethodBeat.i(244225);
    p.k(paramb, "<set-?>");
    this.qcx = paramb;
    AppMethodBeat.o(244225);
  }
  
  public final void setPhoneItems(ArrayList<PhoneItem> paramArrayList)
  {
    AppMethodBeat.i(148133);
    p.k(paramArrayList, "value");
    this.oFB.clear();
    this.oFB.addAll((Collection)paramArrayList);
    m.runOnUiThread((Runnable)new h(this));
    AppMethodBeat.o(148133);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(v paramv) {}
    
    public final void run()
    {
      AppMethodBeat.i(148132);
      Object localObject = this.qCq;
      String str = this.qCq.appId;
      Context localContext = this.qCq.getContext();
      p.j(localContext, "context");
      v.a((v)localObject, new q(str, localContext, this.qCq.oFB));
      this.qCq.mRecyclerView.setAdapter((RecyclerView.a)v.a(this.qCq));
      if (this.qCq.oFB.size() == 0)
      {
        this.qCq.jkB.setVisibility(0);
        this.qCq.mRecyclerView.setVisibility(8);
        this.qCq.qcu.setVisibility(8);
        AppMethodBeat.o(148132);
        return;
      }
      if (this.qCq.oFB.size() == 1)
      {
        this.qCq.jkB.setVisibility(8);
        this.qCq.mRecyclerView.setVisibility(0);
        localObject = this.qCq.mRecyclerView.getAdapter();
        if (localObject != null) {
          ((RecyclerView.a)localObject).notifyDataSetChanged();
        }
        this.qCq.qcu.setVisibility(0);
        this.qCq.qcu.setText((CharSequence)this.qCq.getContext().getString(a.g.appbrand_phone_number_use_other_phone_number));
        localObject = u.qCp;
        u.cgE();
        AppMethodBeat.o(148132);
        return;
      }
      this.qCq.jkB.setVisibility(8);
      this.qCq.mRecyclerView.setVisibility(0);
      this.qCq.qcu.setVisibility(0);
      localObject = this.qCq.mRecyclerView.getAdapter();
      if (localObject != null) {
        ((RecyclerView.a)localObject).notifyDataSetChanged();
      }
      this.qCq.qcu.setText((CharSequence)this.qCq.getContext().getString(a.g.appbrand_phone_number_manager_phone_number));
      localObject = u.qCp;
      u.cgE();
      AppMethodBeat.o(148132);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.v
 * JD-Core Version:    0.7.0.1
 */