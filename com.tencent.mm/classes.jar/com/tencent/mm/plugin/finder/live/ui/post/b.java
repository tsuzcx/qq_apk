package com.tencent.mm.plugin.finder.live.ui.post;

import android.content.Context;
import android.os.Build.VERSION;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.location.a.a;
import com.tencent.mm.protocal.protobuf.cqf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import java.util.Collection;
import java.util.List;
import kotlin.a.j;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/ui/post/PostLocationUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/pluginsdk/location/IGetLocationService$IGetLocationCallback;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "locationWidget", "Lcom/tencent/mm/plugin/finder/upload/postui/FinderLocationWidget;", "postDataManager", "Lcom/tencent/mm/plugin/finder/widget/post/PostDataManager;", "getPostDataManager", "()Lcom/tencent/mm/plugin/finder/widget/post/PostDataManager;", "postDataManager$delegate", "Lkotlin/Lazy;", "checkPermission", "", "initLocationWidget", "", "initView", "onGetLbsLifes", "city", "", "lifeList", "", "Lcom/tencent/mm/protocal/protobuf/LbsLife;", "onSelectLocation", "data", "Landroid/content/Intent;", "requestLocation", "restore", "plugin-finder_release"})
public final class b
  extends UIComponent
  implements a.a
{
  private final f yOG;
  com.tencent.mm.plugin.finder.upload.postui.c yOK;
  
  public b(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(279444);
    this.yOG = g.ar((kotlin.g.a.a)new b(paramAppCompatActivity));
    AppMethodBeat.o(279444);
  }
  
  final com.tencent.mm.plugin.finder.widget.post.c dEb()
  {
    AppMethodBeat.i(279439);
    com.tencent.mm.plugin.finder.widget.post.c localc = (com.tencent.mm.plugin.finder.widget.post.c)this.yOG.getValue();
    AppMethodBeat.o(279439);
    return localc;
  }
  
  final boolean dEc()
  {
    AppMethodBeat.i(279440);
    if ((Build.VERSION.SDK_INT < 23) && ((p.h("MNC", Build.VERSION.CODENAME) ^ true)))
    {
      AppMethodBeat.o(279440);
      return true;
    }
    try
    {
      int i = androidx.core.content.a.checkSelfPermission((Context)getActivity(), "android.permission.ACCESS_FINE_LOCATION");
      if (i == 0)
      {
        AppMethodBeat.o(279440);
        return true;
      }
    }
    catch (Exception localException)
    {
      Log.e("SimpleUIComponent", "check mpermission exception:%s.", new Object[] { localException });
      AppMethodBeat.o(279440);
      return true;
    }
    AppMethodBeat.o(279440);
    return false;
  }
  
  public final void t(String paramString, List<cqf> paramList)
  {
    AppMethodBeat.i(279442);
    Object localObject = (Collection)paramList;
    if ((localObject == null) || (((Collection)localObject).isEmpty())) {}
    for (int i = 1; i == 0; i = 0)
    {
      Log.i("SimpleUIComponent", "get lbsLife success");
      localObject = this.yOK;
      if (localObject == null) {
        p.bGy("locationWidget");
      }
      paramList = (cqf)j.lo(paramList);
      dEb();
      ((com.tencent.mm.plugin.finder.upload.postui.c)localObject).a(paramString, paramList);
      AppMethodBeat.o(279442);
      return;
    }
    paramString = this.yOK;
    if (paramString == null) {
      p.bGy("locationWidget");
    }
    paramString.dFd();
    AppMethodBeat.o(279442);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<x>
  {
    a(b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/widget/post/PostDataManager;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.widget.post.c>
  {
    b(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.ui.post.b
 * JD-Core Version:    0.7.0.1
 */