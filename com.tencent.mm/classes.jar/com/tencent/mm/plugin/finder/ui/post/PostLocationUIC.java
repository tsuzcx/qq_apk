package com.tencent.mm.plugin.finder.ui.post;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.content.b;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.location.a.a;
import com.tencent.mm.protocal.protobuf.chj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import java.util.Collection;
import java.util.List;
import kotlin.a.j;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/post/PostLocationUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/pluginsdk/location/IGetLocationService$IGetLocationCallback;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "locationWidget", "Lcom/tencent/mm/plugin/finder/upload/postui/FinderLocationWidget;", "postDataManager", "Lcom/tencent/mm/plugin/finder/widget/post/PostDataManager;", "getPostDataManager", "()Lcom/tencent/mm/plugin/finder/widget/post/PostDataManager;", "postDataManager$delegate", "Lkotlin/Lazy;", "checkPermission", "", "initLocationWidget", "", "initView", "onGetLbsLifes", "city", "", "lifeList", "", "Lcom/tencent/mm/protocal/protobuf/LbsLife;", "onSelectLocation", "data", "Landroid/content/Intent;", "requestLocation", "restore", "plugin-finder_release"})
public final class PostLocationUIC
  extends UIComponent
  implements a.a
{
  com.tencent.mm.plugin.finder.upload.postui.c uHb;
  private final f vQW;
  
  public PostLocationUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(252959);
    this.vQW = g.ah((a)new b(paramAppCompatActivity));
    AppMethodBeat.o(252959);
  }
  
  final boolean TW()
  {
    AppMethodBeat.i(252957);
    if ((Build.VERSION.SDK_INT < 23) && ((p.j("MNC", Build.VERSION.CODENAME) ^ true)))
    {
      AppMethodBeat.o(252957);
      return true;
    }
    try
    {
      int i = b.checkSelfPermission((Context)getActivity(), "android.permission.ACCESS_FINE_LOCATION");
      if (i == 0)
      {
        AppMethodBeat.o(252957);
        return true;
      }
    }
    catch (Exception localException)
    {
      Log.e("SimpleUIComponent", "check mpermission exception:%s.", new Object[] { localException });
      AppMethodBeat.o(252957);
      return true;
    }
    AppMethodBeat.o(252957);
    return false;
  }
  
  final com.tencent.mm.plugin.finder.widget.post.c dAD()
  {
    AppMethodBeat.i(252956);
    com.tencent.mm.plugin.finder.widget.post.c localc = (com.tencent.mm.plugin.finder.widget.post.c)this.vQW.getValue();
    AppMethodBeat.o(252956);
    return localc;
  }
  
  public final void s(String paramString, List<chj> paramList)
  {
    AppMethodBeat.i(252958);
    Object localObject = (Collection)paramList;
    if ((localObject == null) || (((Collection)localObject).isEmpty())) {}
    for (int i = 1; i == 0; i = 0)
    {
      Log.i("SimpleUIComponent", "get lbsLife success");
      localObject = this.uHb;
      if (localObject == null) {
        p.btv("locationWidget");
      }
      paramList = (chj)j.ks(paramList);
      dAD();
      ((com.tencent.mm.plugin.finder.upload.postui.c)localObject).a(paramString, paramList);
      AppMethodBeat.o(252958);
      return;
    }
    paramString = this.uHb;
    if (paramString == null) {
      p.btv("locationWidget");
    }
    paramString.diy();
    AppMethodBeat.o(252958);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<x>
  {
    a(PostLocationUIC paramPostLocationUIC)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/widget/post/PostDataManager;", "invoke"})
  static final class b
    extends q
    implements a<com.tencent.mm.plugin.finder.widget.post.c>
  {
    b(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.post.PostLocationUIC
 * JD-Core Version:    0.7.0.1
 */