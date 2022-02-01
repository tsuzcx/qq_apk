package com.tencent.mm.plugin.appbrand.phonenumber;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.g.b.k;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManageDialog;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/BaseRequestDialog;", "context", "Landroid/content/Context;", "appId", "", "(Landroid/content/Context;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "mItemAdapter", "Lcom/tencent/mm/plugin/appbrand/phonenumber/ItemAdapter;", "onAccept", "Lkotlin/Function0;", "", "getOnAccept", "()Lkotlin/jvm/functions/Function0;", "setOnAccept", "(Lkotlin/jvm/functions/Function0;)V", "onAddPhoneNumber", "getOnAddPhoneNumber", "setOnAddPhoneNumber", "onCancel", "getOnCancel", "setOnCancel", "onDeny", "getOnDeny", "setOnDeny", "onExplain", "getOnExplain", "setOnExplain", "onManagePhoneNumber", "getOnManagePhoneNumber", "setOnManagePhoneNumber", "onPhoneItemSelect", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "getOnPhoneItemSelect", "()Lkotlin/jvm/functions/Function1;", "setOnPhoneItemSelect", "(Lkotlin/jvm/functions/Function1;)V", "value", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "phoneItems", "getPhoneItems", "()Ljava/util/ArrayList;", "setPhoneItems", "(Ljava/util/ArrayList;)V", "getDialogHeight", "", "onBackPressedEvent", "", "onDismiss", "luggage-wechat-full-sdk_release"})
public final class v
  extends a
{
  final String appId;
  ArrayList<PhoneItem> jGn;
  d.g.a.a<y> jGo;
  public d.g.a.a<y> jGq;
  public d.g.a.a<y> jGs;
  public d.g.a.a<y> jGt;
  public d.g.a.a<y> jGu;
  private q lkO;
  public d.g.a.a<y> lkP;
  public b<? super PhoneItem, y> lkQ;
  
  public v(Context paramContext, String paramString)
  {
    super(paramContext);
    AppMethodBeat.i(148135);
    this.appId = paramString;
    this.jGn = new ArrayList();
    this.jGo = ((d.g.a.a)v.a.lkS);
    this.lkP = ((d.g.a.a)v.d.lkV);
    this.jGq = ((d.g.a.a)v.c.lkU);
    this.jGs = ((d.g.a.a)v.e.lkW);
    this.jGt = ((d.g.a.a)v.b.lkT);
    this.jGu = ((d.g.a.a)v.f.lkX);
    this.ljq = ((a.b)new a.b()
    {
      public final void tD(int paramAnonymousInt)
      {
        AppMethodBeat.i(148123);
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(148123);
          return;
          this.lkR.jGo.invoke();
          Object localObject1 = v.a(this.lkR);
          if (localObject1 != null) {}
          for (localObject1 = ((q)localObject1).jGn;; localObject1 = null)
          {
            if (localObject1 == null) {
              k.fvU();
            }
            Object localObject2 = ((ArrayList)localObject1).iterator();
            do
            {
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
              localObject1 = (PhoneItem)((Iterator)localObject2).next();
            } while (!((PhoneItem)localObject1).lki);
            localObject2 = this.lkR.lkQ;
            if (localObject2 == null) {
              break label143;
            }
            k.g(localObject1, "phoneItem");
            ((b)localObject2).aA(localObject1);
            AppMethodBeat.o(148123);
            return;
          }
          label143:
          AppMethodBeat.o(148123);
          return;
          this.lkR.lkP.invoke();
          AppMethodBeat.o(148123);
          return;
          this.lkR.jGq.invoke();
        }
      }
    });
    paramContext = paramContext.getResources();
    if (paramContext != null) {}
    for (paramContext = paramContext.getDrawable(2131230993);; paramContext = null)
    {
      this.ljr = paramContext;
      this.ljl.setVisibility(8);
      if (paramContext != null)
      {
        this.jFL.setImageDrawable(this.ljr);
        this.ljl.setVisibility(0);
      }
      paramContext = (View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(148124);
          this.lkR.jGs.invoke();
          AppMethodBeat.o(148124);
        }
      };
      this.ljl.setOnClickListener(paramContext);
      this.ljo.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(148125);
          switch (this.lkR.jGn.size())
          {
          default: 
            this.lkR.jGu.invoke();
            AppMethodBeat.o(148125);
            return;
          }
          this.lkR.jGt.invoke();
          AppMethodBeat.o(148125);
        }
      });
      this.ljn.setVisibility(0);
      AppMethodBeat.o(148135);
      return;
    }
  }
  
  public final boolean aEu()
  {
    return false;
  }
  
  public final void onDismiss()
  {
    AppMethodBeat.i(148134);
    onCancel();
    AppMethodBeat.o(148134);
  }
  
  public final void s(ArrayList<PhoneItem> paramArrayList)
  {
    AppMethodBeat.i(148133);
    k.h(paramArrayList, "value");
    this.jGn.clear();
    this.jGn.addAll((Collection)paramArrayList);
    com.tencent.mm.plugin.appbrand.aa.l.runOnUiThread((Runnable)new g(this));
    AppMethodBeat.o(148133);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(v paramv) {}
    
    public final void run()
    {
      AppMethodBeat.i(148132);
      Object localObject = this.lkR;
      String str = this.lkR.appId;
      Context localContext = this.lkR.getContext();
      k.g(localContext, "context");
      v.a((v)localObject, new q(str, localContext, this.lkR.jGn));
      this.lkR.akA.setAdapter((RecyclerView.a)v.a(this.lkR));
      if (this.lkR.jGn.size() == 0)
      {
        this.lkR.fwo.setVisibility(0);
        this.lkR.akA.setVisibility(8);
        this.lkR.ljo.setVisibility(8);
        AppMethodBeat.o(148132);
        return;
      }
      if (this.lkR.jGn.size() == 1)
      {
        this.lkR.fwo.setVisibility(8);
        this.lkR.akA.setVisibility(0);
        localObject = this.lkR.akA.getAdapter();
        if (localObject != null) {
          ((RecyclerView.a)localObject).notifyDataSetChanged();
        }
        this.lkR.ljo.setVisibility(0);
        this.lkR.ljo.setText((CharSequence)this.lkR.getContext().getString(2131756029));
        localObject = u.lkN;
        u.blE();
        AppMethodBeat.o(148132);
        return;
      }
      this.lkR.fwo.setVisibility(8);
      this.lkR.akA.setVisibility(0);
      this.lkR.ljo.setVisibility(0);
      localObject = this.lkR.akA.getAdapter();
      if (localObject != null) {
        ((RecyclerView.a)localObject).notifyDataSetChanged();
      }
      this.lkR.ljo.setText((CharSequence)this.lkR.getContext().getString(2131756027));
      localObject = u.lkN;
      u.blE();
      AppMethodBeat.o(148132);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.v
 * JD-Core Version:    0.7.0.1
 */