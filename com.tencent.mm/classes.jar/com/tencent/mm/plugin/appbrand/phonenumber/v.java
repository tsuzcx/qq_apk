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

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManageDialog;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/BaseRequestDialog;", "context", "Landroid/content/Context;", "appId", "", "(Landroid/content/Context;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "mItemAdapter", "Lcom/tencent/mm/plugin/appbrand/phonenumber/ItemAdapter;", "onAccept", "Lkotlin/Function0;", "", "getOnAccept", "()Lkotlin/jvm/functions/Function0;", "setOnAccept", "(Lkotlin/jvm/functions/Function0;)V", "onAddPhoneNumber", "getOnAddPhoneNumber", "setOnAddPhoneNumber", "onCancel", "getOnCancel", "setOnCancel", "onDeny", "getOnDeny", "setOnDeny", "onExplain", "getOnExplain", "setOnExplain", "onManagePhoneNumber", "getOnManagePhoneNumber", "setOnManagePhoneNumber", "onPhoneItemSelect", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "getOnPhoneItemSelect", "()Lkotlin/jvm/functions/Function1;", "setOnPhoneItemSelect", "(Lkotlin/jvm/functions/Function1;)V", "value", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "phoneItems", "getPhoneItems", "()Ljava/util/ArrayList;", "setPhoneItems", "(Ljava/util/ArrayList;)V", "getDialogHeight", "", "onBackPressedEvent", "", "onDismiss", "luggage-wechat-full-sdk_release"})
public final class v
  extends a
{
  final String appId;
  ArrayList<PhoneItem> kgL;
  d.g.a.a<y> kgM;
  public d.g.a.a<y> kgO;
  public d.g.a.a<y> kgQ;
  public d.g.a.a<y> kgR;
  public d.g.a.a<y> kgS;
  private q lKG;
  public d.g.a.a<y> lKH;
  public b<? super PhoneItem, y> lKI;
  
  public v(Context paramContext, String paramString)
  {
    super(paramContext);
    AppMethodBeat.i(148135);
    this.appId = paramString;
    this.kgL = new ArrayList();
    this.kgM = ((d.g.a.a)a.lKK);
    this.lKH = ((d.g.a.a)d.lKN);
    this.kgO = ((d.g.a.a)c.lKM);
    this.kgQ = ((d.g.a.a)e.lKO);
    this.kgR = ((d.g.a.a)b.lKL);
    this.kgS = ((d.g.a.a)f.lKP);
    this.lJi = ((a.b)new a.b()
    {
      public final void ut(int paramAnonymousInt)
      {
        AppMethodBeat.i(148123);
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(148123);
          return;
          this.lKJ.kgM.invoke();
          Object localObject1 = v.a(this.lKJ);
          if (localObject1 != null) {}
          for (localObject1 = ((q)localObject1).kgL;; localObject1 = null)
          {
            if (localObject1 == null) {
              k.fOy();
            }
            Object localObject2 = ((ArrayList)localObject1).iterator();
            do
            {
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
              localObject1 = (PhoneItem)((Iterator)localObject2).next();
            } while (!((PhoneItem)localObject1).lKa);
            localObject2 = this.lKJ.lKI;
            if (localObject2 == null) {
              break label143;
            }
            k.g(localObject1, "phoneItem");
            ((b)localObject2).ay(localObject1);
            AppMethodBeat.o(148123);
            return;
          }
          label143:
          AppMethodBeat.o(148123);
          return;
          this.lKJ.lKH.invoke();
          AppMethodBeat.o(148123);
          return;
          this.lKJ.kgO.invoke();
        }
      }
    });
    paramContext = paramContext.getResources();
    if (paramContext != null) {}
    for (paramContext = paramContext.getDrawable(2131230993);; paramContext = null)
    {
      this.lJj = paramContext;
      this.lJd.setVisibility(8);
      if (paramContext != null)
      {
        this.kgj.setImageDrawable(this.lJj);
        this.lJd.setVisibility(0);
      }
      paramContext = (View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(148124);
          this.lKJ.kgQ.invoke();
          AppMethodBeat.o(148124);
        }
      };
      this.lJd.setOnClickListener(paramContext);
      this.lJg.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(148125);
          switch (this.lKJ.kgL.size())
          {
          default: 
            this.lKJ.kgS.invoke();
            AppMethodBeat.o(148125);
            return;
          }
          this.lKJ.kgR.invoke();
          AppMethodBeat.o(148125);
        }
      });
      this.lJf.setVisibility(0);
      AppMethodBeat.o(148135);
      return;
    }
  }
  
  public final boolean aLl()
  {
    return false;
  }
  
  public final void onDismiss()
  {
    AppMethodBeat.i(148134);
    onCancel();
    AppMethodBeat.o(148134);
  }
  
  public final void x(ArrayList<PhoneItem> paramArrayList)
  {
    AppMethodBeat.i(148133);
    k.h(paramArrayList, "value");
    this.kgL.clear();
    this.kgL.addAll((Collection)paramArrayList);
    com.tencent.mm.plugin.appbrand.z.l.runOnUiThread((Runnable)new g(this));
    AppMethodBeat.o(148133);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public static final a lKK;
    
    static
    {
      AppMethodBeat.i(148126);
      lKK = new a();
      AppMethodBeat.o(148126);
    }
    
    a()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public static final b lKL;
    
    static
    {
      AppMethodBeat.i(148127);
      lKL = new b();
      AppMethodBeat.o(148127);
    }
    
    b()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public static final c lKM;
    
    static
    {
      AppMethodBeat.i(148128);
      lKM = new c();
      AppMethodBeat.o(148128);
    }
    
    c()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public static final d lKN;
    
    static
    {
      AppMethodBeat.i(148129);
      lKN = new d();
      AppMethodBeat.o(148129);
    }
    
    d()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public static final e lKO;
    
    static
    {
      AppMethodBeat.i(148130);
      lKO = new e();
      AppMethodBeat.o(148130);
    }
    
    e()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public static final f lKP;
    
    static
    {
      AppMethodBeat.i(148131);
      lKP = new f();
      AppMethodBeat.o(148131);
    }
    
    f()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(v paramv) {}
    
    public final void run()
    {
      AppMethodBeat.i(148132);
      Object localObject = this.lKJ;
      String str = this.lKJ.appId;
      Context localContext = this.lKJ.getContext();
      k.g(localContext, "context");
      v.a((v)localObject, new q(str, localContext, this.lKJ.kgL));
      this.lKJ.alu.setAdapter((RecyclerView.a)v.a(this.lKJ));
      if (this.lKJ.kgL.size() == 0)
      {
        this.lKJ.fzV.setVisibility(0);
        this.lKJ.alu.setVisibility(8);
        this.lKJ.lJg.setVisibility(8);
        AppMethodBeat.o(148132);
        return;
      }
      if (this.lKJ.kgL.size() == 1)
      {
        this.lKJ.fzV.setVisibility(8);
        this.lKJ.alu.setVisibility(0);
        localObject = this.lKJ.alu.getAdapter();
        if (localObject != null) {
          ((RecyclerView.a)localObject).notifyDataSetChanged();
        }
        this.lKJ.lJg.setVisibility(0);
        this.lKJ.lJg.setText((CharSequence)this.lKJ.getContext().getString(2131756029));
        localObject = u.lKF;
        u.bst();
        AppMethodBeat.o(148132);
        return;
      }
      this.lKJ.fzV.setVisibility(8);
      this.lKJ.alu.setVisibility(0);
      this.lKJ.lJg.setVisibility(0);
      localObject = this.lKJ.alu.getAdapter();
      if (localObject != null) {
        ((RecyclerView.a)localObject).notifyDataSetChanged();
      }
      this.lKJ.lJg.setText((CharSequence)this.lKJ.getContext().getString(2131756027));
      localObject = u.lKF;
      u.bst();
      AppMethodBeat.o(148132);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.v
 * JD-Core Version:    0.7.0.1
 */