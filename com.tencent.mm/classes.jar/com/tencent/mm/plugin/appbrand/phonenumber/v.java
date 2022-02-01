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
import com.tencent.mm.plugin.appbrand.jsapi.ag;
import com.tencent.mm.plugin.appbrand.permission.g;
import com.tencent.mm.plugin.appbrand.permission.h.a;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManageDialog;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/BaseRequestDialog;", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView;", "context", "Landroid/content/Context;", "appId", "", "(Landroid/content/Context;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "mItemAdapter", "Lcom/tencent/mm/plugin/appbrand/phonenumber/ItemAdapter;", "onAccept", "Lkotlin/Function0;", "", "getOnAccept", "()Lkotlin/jvm/functions/Function0;", "setOnAccept", "(Lkotlin/jvm/functions/Function0;)V", "onAddPhoneNumber", "getOnAddPhoneNumber", "setOnAddPhoneNumber", "onCancel", "getOnCancel", "setOnCancel", "onDeny", "getOnDeny", "setOnDeny", "onExplain", "getOnExplain", "setOnExplain", "onManagePhoneNumber", "getOnManagePhoneNumber", "setOnManagePhoneNumber", "onPhoneItemSelect", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "getOnPhoneItemSelect", "()Lkotlin/jvm/functions/Function1;", "setOnPhoneItemSelect", "(Lkotlin/jvm/functions/Function1;)V", "value", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "phoneItems", "getPhoneItems", "()Ljava/util/ArrayList;", "setPhoneItems", "(Ljava/util/ArrayList;)V", "createSecondaryExplainPresenterView", "Lcom/tencent/mm/plugin/appbrand/permission/IAuthorizePrivacyExplainPresenterView;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "content", "webviewOpener", "Lcom/tencent/mm/plugin/appbrand/jsapi/IExternalToolsHelper;", "dismiss", "getDialogHeight", "", "onBackPressedEvent", "", "onDismiss", "show", "showPrivacyExplainEntry", "luggage-wechat-full-sdk_release"})
public final class v
  extends a
  implements com.tencent.mm.plugin.appbrand.jsapi.autofill.b.a
{
  final String appId;
  ArrayList<PhoneItem> lJn;
  kotlin.g.a.a<x> lJo;
  kotlin.g.a.a<x> lJq;
  kotlin.g.a.a<x> lJt;
  kotlin.g.a.a<x> lJu;
  kotlin.g.a.a<x> lJv;
  private q nch;
  kotlin.g.a.a<x> nci;
  kotlin.g.a.b<? super PhoneItem, x> ncj;
  
  public v(Context paramContext, String paramString)
  {
    super(paramContext);
    AppMethodBeat.i(148135);
    this.appId = paramString;
    this.lJn = new ArrayList();
    this.lJo = ((kotlin.g.a.a)a.nAg);
    this.nci = ((kotlin.g.a.a)d.nAj);
    this.lJq = ((kotlin.g.a.a)c.nAi);
    this.lJt = ((kotlin.g.a.a)e.nAk);
    this.lJu = ((kotlin.g.a.a)b.nAh);
    this.lJv = ((kotlin.g.a.a)f.nAl);
    this.ncj = ((kotlin.g.a.b)g.nAm);
    this.nyF = ((a.b)new a.b()
    {
      public final void yU(int paramAnonymousInt)
      {
        AppMethodBeat.i(148123);
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(148123);
          return;
          this.nAf.lJo.invoke();
          Object localObject1 = v.a(this.nAf);
          if (localObject1 != null) {}
          for (localObject1 = ((q)localObject1).lJn;; localObject1 = null)
          {
            if (localObject1 == null) {
              p.hyc();
            }
            Object localObject2 = ((ArrayList)localObject1).iterator();
            do
            {
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
              localObject1 = (PhoneItem)((Iterator)localObject2).next();
            } while (!((PhoneItem)localObject1).nzz);
            localObject2 = this.nAf.ncj;
            p.g(localObject1, "phoneItem");
            ((kotlin.g.a.b)localObject2).invoke(localObject1);
            AppMethodBeat.o(148123);
            return;
          }
          this.nAf.nci.invoke();
          AppMethodBeat.o(148123);
          return;
          this.nAf.lJq.invoke();
        }
      }
    });
    a((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(148124);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManageDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        this.nAf.lJt.invoke();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManageDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(148124);
      }
    });
    this.ncg.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(148125);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManageDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        switch (this.nAf.lJn.size())
        {
        default: 
          this.nAf.lJv.invoke();
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManageDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(148125);
          return;
          this.nAf.lJu.invoke();
        }
      }
    });
    this.ncf.setVisibility(0);
    AppMethodBeat.o(148135);
  }
  
  public final g a(d paramd, String paramString, ag paramag)
  {
    AppMethodBeat.i(230159);
    p.h(paramd, "component");
    Context localContext = getContext();
    p.g(localContext, "this.context");
    paramString = new k(paramag, paramString, localContext, this.jBN.getMeasuredHeight());
    paramd = paramd.getWindowAndroid();
    p.g(paramd, "component.windowAndroid");
    if (paramd.bsj()) {
      paramString.setPosition(1);
    }
    paramd = (g)paramString;
    AppMethodBeat.o(230159);
    return paramd;
  }
  
  public final boolean bjb()
  {
    return false;
  }
  
  public final void h(d paramd)
  {
    AppMethodBeat.i(230158);
    p.h(paramd, "component");
    super.setPosition(this.jCs);
    p.h(paramd, "$this$findPromptViewContainer");
    p.h(paramd, "$this$findPromptViewContainer");
    h.a.k(paramd).b((com.tencent.mm.plugin.appbrand.widget.dialog.k)this);
    AppMethodBeat.o(230158);
  }
  
  public final void hm(boolean paramBoolean)
  {
    AppMethodBeat.i(230157);
    Object localObject = this.nyD;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      ((ImageView)localObject).setVisibility(i);
      if (!paramBoolean) {
        break;
      }
      localObject = android.support.v4.content.b.l(getContext(), 2131231024);
      this.nyG = ((Drawable)localObject);
      this.nyD.setVisibility(8);
      if (localObject != null)
      {
        this.nyD.setImageDrawable(this.nyG);
        this.nyD.setVisibility(0);
      }
      super.a((View.OnClickListener)new i(this));
      AppMethodBeat.o(230157);
      return;
    }
    super.a(null);
    AppMethodBeat.o(230157);
  }
  
  public final void onDismiss()
  {
    AppMethodBeat.i(148134);
    onCancel();
    AppMethodBeat.o(148134);
  }
  
  public final void setOnAddPhoneNumber(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(230154);
    p.h(parama, "<set-?>");
    this.lJu = parama;
    AppMethodBeat.o(230154);
  }
  
  public final void setOnCancel(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(230152);
    p.h(parama, "<set-?>");
    this.lJq = parama;
    AppMethodBeat.o(230152);
  }
  
  public final void setOnDeny(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(230151);
    p.h(parama, "<set-?>");
    this.nci = parama;
    AppMethodBeat.o(230151);
  }
  
  public final void setOnExplain(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(230153);
    p.h(parama, "<set-?>");
    this.lJt = parama;
    AppMethodBeat.o(230153);
  }
  
  public final void setOnManagePhoneNumber(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(230155);
    p.h(parama, "<set-?>");
    this.lJv = parama;
    AppMethodBeat.o(230155);
  }
  
  public final void setOnPhoneItemSelect(kotlin.g.a.b<? super PhoneItem, x> paramb)
  {
    AppMethodBeat.i(230156);
    p.h(paramb, "<set-?>");
    this.ncj = paramb;
    AppMethodBeat.o(230156);
  }
  
  public final void setPhoneItems(ArrayList<PhoneItem> paramArrayList)
  {
    AppMethodBeat.i(148133);
    p.h(paramArrayList, "value");
    this.lJn.clear();
    this.lJn.addAll((Collection)paramArrayList);
    com.tencent.mm.plugin.appbrand.ac.m.runOnUiThread((Runnable)new h(this));
    AppMethodBeat.o(148133);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    public static final a nAg;
    
    static
    {
      AppMethodBeat.i(148126);
      nAg = new a();
      AppMethodBeat.o(148126);
    }
    
    a()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    public static final b nAh;
    
    static
    {
      AppMethodBeat.i(148127);
      nAh = new b();
      AppMethodBeat.o(148127);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    public static final c nAi;
    
    static
    {
      AppMethodBeat.i(148128);
      nAi = new c();
      AppMethodBeat.o(148128);
    }
    
    c()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    public static final d nAj;
    
    static
    {
      AppMethodBeat.i(148129);
      nAj = new d();
      AppMethodBeat.o(148129);
    }
    
    d()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    public static final e nAk;
    
    static
    {
      AppMethodBeat.i(148130);
      nAk = new e();
      AppMethodBeat.o(148130);
    }
    
    e()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    public static final f nAl;
    
    static
    {
      AppMethodBeat.i(148131);
      nAl = new f();
      AppMethodBeat.o(148131);
    }
    
    f()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.b<PhoneItem, x>
  {
    public static final g nAm;
    
    static
    {
      AppMethodBeat.i(230149);
      nAm = new g();
      AppMethodBeat.o(230149);
    }
    
    g()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(v paramv) {}
    
    public final void run()
    {
      AppMethodBeat.i(148132);
      Object localObject = this.nAf;
      String str = this.nAf.appId;
      Context localContext = this.nAf.getContext();
      p.g(localContext, "context");
      v.a((v)localObject, new q(str, localContext, this.nAf.lJn));
      this.nAf.mRecyclerView.setAdapter((RecyclerView.a)v.a(this.nAf));
      if (this.nAf.lJn.size() == 0)
      {
        this.nAf.gAy.setVisibility(0);
        this.nAf.mRecyclerView.setVisibility(8);
        this.nAf.ncg.setVisibility(8);
        AppMethodBeat.o(148132);
        return;
      }
      if (this.nAf.lJn.size() == 1)
      {
        this.nAf.gAy.setVisibility(8);
        this.nAf.mRecyclerView.setVisibility(0);
        localObject = this.nAf.mRecyclerView.getAdapter();
        if (localObject != null) {
          ((RecyclerView.a)localObject).notifyDataSetChanged();
        }
        this.nAf.ncg.setVisibility(0);
        this.nAf.ncg.setText((CharSequence)this.nAf.getContext().getString(2131756144));
        localObject = u.nAe;
        u.bTz();
        AppMethodBeat.o(148132);
        return;
      }
      this.nAf.gAy.setVisibility(8);
      this.nAf.mRecyclerView.setVisibility(0);
      this.nAf.ncg.setVisibility(0);
      localObject = this.nAf.mRecyclerView.getAdapter();
      if (localObject != null) {
        ((RecyclerView.a)localObject).notifyDataSetChanged();
      }
      this.nAf.ncg.setText((CharSequence)this.nAf.getContext().getString(2131756142));
      localObject = u.nAe;
      u.bTz();
      AppMethodBeat.o(148132);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class i
    implements View.OnClickListener
  {
    i(v paramv) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(230150);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManageDialog$showPrivacyExplainEntry$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.nAf.lJt.invoke();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManageDialog$showPrivacyExplainEntry$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(230150);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.v
 * JD-Core Version:    0.7.0.1
 */