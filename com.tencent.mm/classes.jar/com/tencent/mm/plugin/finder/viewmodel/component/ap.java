package com.tencent.mm.plugin.finder.viewmodel.component;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.feed.ak.b;
import com.tencent.mm.plugin.finder.feed.ak.c;
import com.tencent.mm.plugin.finder.feed.c.a;
import com.tencent.mm.plugin.finder.feed.c.b;
import com.tencent.mm.plugin.finder.feed.model.FinderPoiRelateLoader;
import com.tencent.mm.plugin.finder.feed.ui.FinderPoiRelateListUI;
import com.tencent.mm.pluginsdk.location.LocationIntent;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderPoiRelateListUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderPoiRelateLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderPoiRelateLoader;", "feedLoader$delegate", "Lkotlin/Lazy;", "poiActivity", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderPoiRelateListUI;", "getPoiActivity", "()Lcom/tencent/mm/plugin/finder/feed/ui/FinderPoiRelateListUI;", "poiActivity$delegate", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderPoiRelateUIContract$PoiRelatePresenter;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/feed/FinderPoiRelateUIContract$PoiRelatePresenter;", "presenter$delegate", "username", "", "getUsername", "()Ljava/lang/String;", "username$delegate", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderPoiRelateUIContract$PoiRelateViewCallback;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/feed/FinderPoiRelateUIContract$PoiRelateViewCallback;", "viewCallback$delegate", "getLayoutId", "", "initView", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ap
  extends UIComponent
{
  public static final a GSF;
  private final j AYa;
  final j BlK;
  private final j Bqv;
  private final j Bqw;
  private final j GSG;
  
  static
  {
    AppMethodBeat.i(338193);
    GSF = new a((byte)0);
    AppMethodBeat.o(338193);
  }
  
  public ap(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(338129);
    this.GSG = kotlin.k.cm((a)new c(this));
    this.Bqv = kotlin.k.cm((a)new d(this));
    this.Bqw = kotlin.k.cm((a)new f(this));
    this.AYa = kotlin.k.cm((a)new b(this));
    this.BlK = kotlin.k.cm((a)e.GSI);
    AppMethodBeat.o(338129);
  }
  
  private static final void D(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(338163);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(338163);
  }
  
  private static final void a(ap paramap, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(338154);
    s.u(paramap, "this$0");
    paramDialogInterface.dismiss();
    b.lx((Context)paramap.getActivity());
    AppMethodBeat.o(338154);
  }
  
  private final ak.b fol()
  {
    AppMethodBeat.i(338140);
    ak.b localb = (ak.b)this.Bqv.getValue();
    AppMethodBeat.o(338140);
    return localb;
  }
  
  private final ak.c fom()
  {
    AppMethodBeat.i(338146);
    ak.c localc = (ak.c)this.Bqw.getValue();
    AppMethodBeat.o(338146);
    return localc;
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_poi_relative_list_layout;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(338244);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 16666)
    {
      if (paramInt2 == -1)
      {
        if (paramIntent == null) {}
        for (paramIntent = null; paramIntent == null; paramIntent = paramIntent.getParcelableExtra("KLocationIntent"))
        {
          paramIntent = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.pluginsdk.location.LocationIntent");
          AppMethodBeat.o(338244);
          throw paramIntent;
        }
        Object localObject = (LocationIntent)paramIntent;
        Log.i("Finder.FinderPoiRelativeListUIC", s.X("locationIntent: ", ((LocationIntent)localObject).bbZ()));
        paramIntent = new ArrayList();
        paramIntent.add(((LocationIntent)localObject).Kcd);
        localObject = new Intent();
        ((Intent)localObject).putExtra("extra_poi_list", (Serializable)paramIntent);
        getContext().setResult(-1, (Intent)localObject);
        getContext().finish();
        AppMethodBeat.o(338244);
        return;
      }
      Log.i("Finder.FinderPoiRelativeListUIC", "map search result : cancel");
    }
    AppMethodBeat.o(338244);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(338228);
    super.onCreate(paramBundle);
    fom().a((c.a)fol());
    fol().a((c.b)fom());
    AppMethodBeat.o(338228);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(338234);
    super.onDestroy();
    fol().onDetach();
    AppMethodBeat.o(338234);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(338256);
    s.u(paramArrayOfString, "permissions");
    s.u(paramArrayOfInt, "grantResults");
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    if (paramArrayOfInt.length == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.i("Finder.FinderPoiRelativeListUIC", "onRequestPermissionsResult grantResults length 0");
      AppMethodBeat.o(338256);
      return;
    }
    if (paramInt == 64)
    {
      if (paramArrayOfInt[0] == 0)
      {
        fom().ecu();
        AppMethodBeat.o(338256);
        return;
      }
      com.tencent.mm.ui.base.k.a((Context)getActivity(), getString(e.h.permission_location_request_again_msg), getString(e.h.permission_tips_title), getString(e.h.jump_to_settings), getString(e.h.button_cancel), false, new ap..ExternalSyntheticLambda0(this), ap..ExternalSyntheticLambda1.INSTANCE);
    }
    AppMethodBeat.o(338256);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderPoiRelateListUIC$Companion;", "", "()V", "REQUEST_CODE_GET_ADDRESS_FROM_POI", "", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/model/FinderPoiRelateLoader;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<FinderPoiRelateLoader>
  {
    b(ap paramap)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderPoiRelateListUI;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<FinderPoiRelateListUI>
  {
    c(ap paramap)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/FinderPoiRelateUIContract$PoiRelatePresenter;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements a<ak.b>
  {
    d(ap paramap)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements a<String>
  {
    public static final e GSI;
    
    static
    {
      AppMethodBeat.i(337614);
      GSI = new e();
      AppMethodBeat.o(337614);
    }
    
    e()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/FinderPoiRelateUIContract$PoiRelateViewCallback;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements a<ak.c>
  {
    f(ap paramap)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.ap
 * JD-Core Version:    0.7.0.1
 */