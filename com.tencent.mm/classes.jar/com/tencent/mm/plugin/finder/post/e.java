package com.tencent.mm.plugin.finder.post;

import android.content.Context;
import android.os.Build.VERSION;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.api.h;
import com.tencent.mm.plugin.finder.widget.post.c;
import com.tencent.mm.pluginsdk.location.a.a;
import com.tencent.mm.protocal.protobuf.dgz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/post/PostLocationUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/pluginsdk/location/IGetLocationService$IGetLocationCallback;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "locationWidget", "Lcom/tencent/mm/plugin/finder/api/IFinderLocationWidget;", "postDataManager", "Lcom/tencent/mm/plugin/finder/widget/post/PostDataManager;", "getPostDataManager", "()Lcom/tencent/mm/plugin/finder/widget/post/PostDataManager;", "postDataManager$delegate", "Lkotlin/Lazy;", "checkPermission", "", "initLocationWidget", "", "initView", "onGetLbsLifes", "city", "", "lifeList", "", "Lcom/tencent/mm/protocal/protobuf/LbsLife;", "onSelectLocation", "data", "Landroid/content/Intent;", "requestLocation", "restore", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends UIComponent
  implements a.a
{
  private final j ETb;
  h EsQ;
  
  public e(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(349429);
    this.ETb = k.cm((kotlin.g.a.a)new b(paramAppCompatActivity));
    AppMethodBeat.o(349429);
  }
  
  final boolean eBW()
  {
    AppMethodBeat.i(349470);
    if ((Build.VERSION.SDK_INT < 23) && (!s.p("MNC", Build.VERSION.CODENAME)))
    {
      AppMethodBeat.o(349470);
      return true;
    }
    try
    {
      int i = androidx.core.content.a.checkSelfPermission((Context)getActivity(), "android.permission.ACCESS_FINE_LOCATION");
      if (i == 0)
      {
        AppMethodBeat.o(349470);
        return true;
      }
    }
    catch (Exception localException)
    {
      Log.e("SimpleUIComponent", "check mpermission exception:%s.", new Object[] { localException });
      AppMethodBeat.o(349470);
      return true;
    }
    AppMethodBeat.o(349470);
    return false;
  }
  
  final c eHl()
  {
    AppMethodBeat.i(349456);
    c localc = (c)this.ETb.getValue();
    AppMethodBeat.o(349456);
    return localc;
  }
  
  public final void onGetLbsLifes(String paramString, List<dgz> paramList)
  {
    h localh2 = null;
    h localh1 = null;
    AppMethodBeat.i(349487);
    Collection localCollection = (Collection)paramList;
    int i;
    if ((localCollection == null) || (localCollection.isEmpty()))
    {
      i = 1;
      if (i != 0) {
        break label101;
      }
      Log.i("SimpleUIComponent", "get lbsLife success");
      localh2 = this.EsQ;
      if (localh2 != null) {
        break label94;
      }
      s.bIx("locationWidget");
    }
    for (;;)
    {
      paramList = (dgz)p.oK(paramList);
      eHl();
      localh1.a(paramString, paramList);
      AppMethodBeat.o(349487);
      return;
      i = 0;
      break;
      label94:
      localh1 = localh2;
    }
    label101:
    paramString = this.EsQ;
    if (paramString == null)
    {
      s.bIx("locationWidget");
      paramString = localh2;
    }
    for (;;)
    {
      paramString.dUm();
      AppMethodBeat.o(349487);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/widget/post/PostDataManager;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<c>
  {
    b(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.post.e
 * JD-Core Version:    0.7.0.1
 */