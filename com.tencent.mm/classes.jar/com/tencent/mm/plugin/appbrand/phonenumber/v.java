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
import com.tencent.mm.plugin.appbrand.permission.f;
import com.tencent.mm.plugin.appbrand.r.a.c;
import d.g.b.p;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManageDialog;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/BaseRequestDialog;", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView;", "context", "Landroid/content/Context;", "appId", "", "(Landroid/content/Context;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "mItemAdapter", "Lcom/tencent/mm/plugin/appbrand/phonenumber/ItemAdapter;", "onAccept", "Lkotlin/Function0;", "", "getOnAccept", "()Lkotlin/jvm/functions/Function0;", "setOnAccept", "(Lkotlin/jvm/functions/Function0;)V", "onAddPhoneNumber", "getOnAddPhoneNumber", "setOnAddPhoneNumber", "onCancel", "getOnCancel", "setOnCancel", "onDeny", "getOnDeny", "setOnDeny", "onExplain", "getOnExplain", "setOnExplain", "onManagePhoneNumber", "getOnManagePhoneNumber", "setOnManagePhoneNumber", "onPhoneItemSelect", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "getOnPhoneItemSelect", "()Lkotlin/jvm/functions/Function1;", "setOnPhoneItemSelect", "(Lkotlin/jvm/functions/Function1;)V", "value", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "phoneItems", "getPhoneItems", "()Ljava/util/ArrayList;", "setPhoneItems", "(Ljava/util/ArrayList;)V", "createSecondaryExplainPresenterView", "Lcom/tencent/mm/plugin/appbrand/permission/IAuthorizePrivacyExplainPresenterView;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "content", "webviewOpener", "Lcom/tencent/mm/plugin/appbrand/jsapi/IExternalToolsHelper;", "dismiss", "getDialogHeight", "", "onBackPressedEvent", "", "onDismiss", "show", "showPrivacyExplainEntry", "luggage-wechat-full-sdk_release"})
public final class v
  extends a
  implements com.tencent.mm.plugin.appbrand.jsapi.autofill.b.a
{
  final String appId;
  d.g.a.a<z> kBA;
  d.g.a.a<z> kBC;
  d.g.a.a<z> kBE;
  d.g.a.a<z> kBF;
  d.g.a.a<z> kBG;
  ArrayList<PhoneItem> kBz;
  private q lPX;
  d.g.a.a<z> lPY;
  d.g.a.b<? super PhoneItem, z> lPZ;
  
  public v(Context paramContext, String paramString)
  {
    super(paramContext);
    AppMethodBeat.i(148135);
    this.appId = paramString;
    this.kBz = new ArrayList();
    this.kBA = ((d.g.a.a)v.a.mkx);
    this.lPY = ((d.g.a.a)v.d.mkA);
    this.kBC = ((d.g.a.a)v.c.mkz);
    this.kBE = ((d.g.a.a)v.e.mkB);
    this.kBF = ((d.g.a.a)v.b.mky);
    this.kBG = ((d.g.a.a)v.f.mkC);
    this.lPZ = ((d.g.a.b)v.g.mkD);
    this.miW = ((a.b)new a.b()
    {
      public final void uX(int paramAnonymousInt)
      {
        AppMethodBeat.i(148123);
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(148123);
          return;
          this.mkw.kBA.invoke();
          Object localObject1 = v.a(this.mkw);
          if (localObject1 != null) {}
          for (localObject1 = ((q)localObject1).kBz;; localObject1 = null)
          {
            if (localObject1 == null) {
              p.gfZ();
            }
            Object localObject2 = ((ArrayList)localObject1).iterator();
            do
            {
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
              localObject1 = (PhoneItem)((Iterator)localObject2).next();
            } while (!((PhoneItem)localObject1).mjQ);
            localObject2 = this.mkw.lPZ;
            p.g(localObject1, "phoneItem");
            ((d.g.a.b)localObject2).invoke(localObject1);
            AppMethodBeat.o(148123);
            return;
          }
          this.mkw.lPY.invoke();
          AppMethodBeat.o(148123);
          return;
          this.mkw.kBC.invoke();
        }
      }
    });
    a((View.OnClickListener)new v.2(this));
    this.lPW.setOnClickListener((View.OnClickListener)new v.3(this));
    this.lPV.setVisibility(0);
    AppMethodBeat.o(148135);
  }
  
  public final f a(d paramd, String paramString, ac paramac)
  {
    AppMethodBeat.i(192406);
    p.h(paramd, "component");
    Context localContext = getContext();
    p.g(localContext, "this.context");
    paramString = new k(paramac, paramString, localContext, this.iCR.getMeasuredHeight());
    paramd = paramd.getWindowAndroid();
    p.g(paramd, "component.windowAndroid");
    if (paramd.aWM()) {
      paramString.setPosition(1);
    }
    paramd = (f)paramString;
    AppMethodBeat.o(192406);
    return paramd;
  }
  
  public final boolean aOv()
  {
    return false;
  }
  
  public final void gr(boolean paramBoolean)
  {
    AppMethodBeat.i(192404);
    Object localObject = this.miU;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      ((ImageView)localObject).setVisibility(i);
      if (!paramBoolean) {
        break;
      }
      localObject = android.support.v4.content.b.l(getContext(), 2131230993);
      this.miX = ((Drawable)localObject);
      this.miU.setVisibility(8);
      if (localObject != null)
      {
        this.miU.setImageDrawable(this.miX);
        this.miU.setVisibility(0);
      }
      super.a((View.OnClickListener)new v.i(this));
      AppMethodBeat.o(192404);
      return;
    }
    super.a(null);
    AppMethodBeat.o(192404);
  }
  
  public final void h(d paramd)
  {
    AppMethodBeat.i(192405);
    p.h(paramd, "component");
    super.setPosition(this.iDw);
    paramd.aVE().b((com.tencent.mm.plugin.appbrand.widget.dialog.k)this);
    AppMethodBeat.o(192405);
  }
  
  public final void onDismiss()
  {
    AppMethodBeat.i(148134);
    onCancel();
    AppMethodBeat.o(148134);
  }
  
  public final void setOnAddPhoneNumber(d.g.a.a<z> parama)
  {
    AppMethodBeat.i(192401);
    p.h(parama, "<set-?>");
    this.kBF = parama;
    AppMethodBeat.o(192401);
  }
  
  public final void setOnCancel(d.g.a.a<z> parama)
  {
    AppMethodBeat.i(192399);
    p.h(parama, "<set-?>");
    this.kBC = parama;
    AppMethodBeat.o(192399);
  }
  
  public final void setOnDeny(d.g.a.a<z> parama)
  {
    AppMethodBeat.i(192398);
    p.h(parama, "<set-?>");
    this.lPY = parama;
    AppMethodBeat.o(192398);
  }
  
  public final void setOnExplain(d.g.a.a<z> parama)
  {
    AppMethodBeat.i(192400);
    p.h(parama, "<set-?>");
    this.kBE = parama;
    AppMethodBeat.o(192400);
  }
  
  public final void setOnManagePhoneNumber(d.g.a.a<z> parama)
  {
    AppMethodBeat.i(192402);
    p.h(parama, "<set-?>");
    this.kBG = parama;
    AppMethodBeat.o(192402);
  }
  
  public final void setOnPhoneItemSelect(d.g.a.b<? super PhoneItem, z> paramb)
  {
    AppMethodBeat.i(192403);
    p.h(paramb, "<set-?>");
    this.lPZ = paramb;
    AppMethodBeat.o(192403);
  }
  
  public final void setPhoneItems(ArrayList<PhoneItem> paramArrayList)
  {
    AppMethodBeat.i(148133);
    p.h(paramArrayList, "value");
    this.kBz.clear();
    this.kBz.addAll((Collection)paramArrayList);
    com.tencent.mm.plugin.appbrand.z.m.runOnUiThread((Runnable)new h(this));
    AppMethodBeat.o(148133);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(v paramv) {}
    
    public final void run()
    {
      AppMethodBeat.i(148132);
      Object localObject = this.mkw;
      String str = this.mkw.appId;
      Context localContext = this.mkw.getContext();
      p.g(localContext, "context");
      v.a((v)localObject, new q(str, localContext, this.mkw.kBz));
      this.mkw.anl.setAdapter((RecyclerView.a)v.a(this.mkw));
      if (this.mkw.kBz.size() == 0)
      {
        this.mkw.fTl.setVisibility(0);
        this.mkw.anl.setVisibility(8);
        this.mkw.lPW.setVisibility(8);
        AppMethodBeat.o(148132);
        return;
      }
      if (this.mkw.kBz.size() == 1)
      {
        this.mkw.fTl.setVisibility(8);
        this.mkw.anl.setVisibility(0);
        localObject = this.mkw.anl.getAdapter();
        if (localObject != null) {
          ((RecyclerView.a)localObject).notifyDataSetChanged();
        }
        this.mkw.lPW.setVisibility(0);
        this.mkw.lPW.setText((CharSequence)this.mkw.getContext().getString(2131756029));
        localObject = u.mkv;
        u.bwy();
        AppMethodBeat.o(148132);
        return;
      }
      this.mkw.fTl.setVisibility(8);
      this.mkw.anl.setVisibility(0);
      this.mkw.lPW.setVisibility(0);
      localObject = this.mkw.anl.getAdapter();
      if (localObject != null) {
        ((RecyclerView.a)localObject).notifyDataSetChanged();
      }
      this.mkw.lPW.setText((CharSequence)this.mkw.getContext().getString(2131756027));
      localObject = u.mkv;
      u.bwy();
      AppMethodBeat.o(148132);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.v
 * JD-Core Version:    0.7.0.1
 */