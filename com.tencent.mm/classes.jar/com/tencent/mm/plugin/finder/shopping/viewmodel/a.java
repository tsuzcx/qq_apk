package com.tencent.mm.plugin.finder.shopping.viewmodel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.f;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.view.FinderLiveShoppingPriceView;
import com.tencent.mm.plugin.finder.live.view.convert.k;
import com.tencent.mm.plugin.finder.live.widget.ba;
import com.tencent.mm.plugin.finder.live.widget.ba.b;
import com.tencent.mm.plugin.finder.shopping.b;
import com.tencent.mm.plugin.finder.shopping.b.a;
import com.tencent.mm.plugin.finder.shopping.b.b;
import com.tencent.mm.protocal.protobuf.bzc;
import com.tencent.mm.protocal.protobuf.fce;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/shopping/viewmodel/FinderLiveShoppingManagerUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "presenter", "Lcom/tencent/mm/plugin/finder/shopping/FinderLiveShoppingManagerPresenter;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/shopping/FinderLiveShoppingManagerPresenter;", "setPresenter", "(Lcom/tencent/mm/plugin/finder/shopping/FinderLiveShoppingManagerPresenter;)V", "viewCallback", "Lcom/tencent/mm/plugin/finder/shopping/FinderLiveShoppingManagerViewCallback;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/shopping/FinderLiveShoppingManagerViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/shopping/FinderLiveShoppingManagerViewCallback;)V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends UIComponent
{
  private b FAe;
  public com.tencent.mm.plugin.finder.shopping.a FAj;
  
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(330510);
    AppMethodBeat.o(330510);
  }
  
  public final int getLayoutId()
  {
    return p.f.CfB;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(330533);
    super.onCreate(paramBundle);
    this.FAj = new com.tencent.mm.plugin.finder.shopping.a((Activity)getActivity());
    paramBundle = (Activity)getActivity();
    Object localObject1 = this.FAj;
    s.checkNotNull(localObject1);
    this.FAe = new b(paramBundle, (com.tencent.mm.plugin.finder.shopping.a)localObject1);
    localObject1 = this.FAj;
    Object localObject2;
    Object localObject3;
    if (localObject1 != null)
    {
      paramBundle = this.FAe;
      s.checkNotNull(paramBundle);
      s.u(paramBundle, "viewCallback");
      ((com.tencent.mm.plugin.finder.shopping.a)localObject1).FAe = paramBundle;
      paramBundle = ((com.tencent.mm.plugin.finder.shopping.a)localObject1).activity.getIntent().getSerializableExtra("KEY_PRODUCTLIST");
      if ((paramBundle instanceof List)) {}
      for (paramBundle = (List)paramBundle; paramBundle != null; paramBundle = null)
      {
        localObject2 = (Iterable)paramBundle;
        paramBundle = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject4 = (byte[])((Iterator)localObject2).next();
          localObject3 = ((com.tencent.mm.plugin.finder.shopping.a)localObject1).Eib;
          bzc localbzc = new bzc();
          localbzc.parseFrom((byte[])localObject4);
          localObject4 = ah.aiuX;
          paramBundle.add(Boolean.valueOf(((LinkedList)localObject3).add(new k(localbzc))));
        }
      }
      localObject2 = ((com.tencent.mm.plugin.finder.shopping.a)localObject1).activity.getIntent().getByteArrayExtra("KEY_PARAMS");
      if (localObject2 != null) {
        break label395;
      }
      paramBundle = null;
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.finder.shopping.a)localObject1).FAf = paramBundle;
      localObject2 = ((com.tencent.mm.plugin.finder.shopping.a)localObject1).TAG;
      localObject1 = ((com.tencent.mm.plugin.finder.shopping.a)localObject1).FAf;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null) {
        paramBundle = "";
      }
      Log.i((String)localObject2, s.X("init params:", f.dg(paramBundle)));
      paramBundle = this.FAe;
      if (paramBundle != null)
      {
        localObject1 = paramBundle.activity.findViewById(p.e.BUF);
        s.s(localObject1, "activity.findViewById(R.…inder_shopping_edit_area)");
        localObject2 = paramBundle.FAj.Eib;
        localObject3 = FinderLiveShoppingPriceView.DPr;
        localObject1 = new ba((View)localObject1, (LinkedList)localObject2, FinderLiveShoppingPriceView.evI(), (ba.b)new b.a(paramBundle));
        ((ba)localObject1).Eut.DSO = paramBundle.FAj.DSO;
        ba.a((ba)localObject1);
        ((ba)localObject1).Eut.DSS = ((m)new b.b(paramBundle));
        localObject2 = ah.aiuX;
        paramBundle.FAk = ((ba)localObject1);
      }
      AppMethodBeat.o(330533);
      return;
      label395:
      paramBundle = new fce();
      paramBundle.parseFrom((byte[])localObject2);
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(330543);
    super.onDestroy();
    com.tencent.mm.plugin.finder.shopping.a locala = this.FAj;
    if (locala != null) {
      locala.FAe = null;
    }
    AppMethodBeat.o(330543);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.shopping.viewmodel.a
 * JD-Core Version:    0.7.0.1
 */