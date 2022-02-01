package com.tencent.mm.plugin.finder.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.m;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.live.viewmodel.c;
import com.tencent.mm.plugin.finder.live.viewmodel.f;
import com.tencent.mm.plugin.finder.live.viewmodel.g;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/FinderLivePresenter;", "Lcom/tencent/mm/plugin/finder/live/FinderLiveContract$Presenter;", "()V", "data", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveDataModel;", "getData", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveDataModel;", "hasPreload", "", "livePreload", "Lcom/tencent/mm/plugin/finder/feed/model/internal/Preload;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveData;", "loader", "Lcom/tencent/mm/plugin/finder/live/FinderLiveRelatedLoader;", "getLoader", "()Lcom/tencent/mm/plugin/finder/live/FinderLiveRelatedLoader;", "setLoader", "(Lcom/tencent/mm/plugin/finder/live/FinderLiveRelatedLoader;)V", "viewcall", "Lcom/tencent/mm/plugin/finder/live/FinderLiveViewCallback;", "canLoadMore", "flingUpType", "isEnableNestedScroll", "loadMoreData", "", "onAttach", "callback", "Lcom/tencent/mm/plugin/finder/live/FinderLiveContract$ViewCallback;", "onDetach", "preloadData", "newPos", "", "liveData", "Companion", "plugin-finder_release"})
public final class d
  implements c.a
{
  private static final String TAG = "FinderLivePresenter";
  public static final b ufv;
  private FinderLiveViewCallback ufr;
  private final m<c> ufs;
  private boolean uft;
  private FinderLiveRelatedLoader ufu;
  
  static
  {
    AppMethodBeat.i(245806);
    ufv = new b((byte)0);
    TAG = "FinderLivePresenter";
    AppMethodBeat.o(245806);
  }
  
  public d()
  {
    AppMethodBeat.i(245805);
    this.ufs = new m((byte)0);
    FinderLiveRelatedLoader localFinderLiveRelatedLoader = new FinderLiveRelatedLoader();
    Object localObject = o.ujN;
    localObject = o.dfY();
    if (localObject != null)
    {
      f localf = ((com.tencent.mm.plugin.finder.live.viewmodel.d)localObject).ufx;
      localObject = localf;
      if (localf != null) {}
    }
    else
    {
      localObject = new f();
    }
    p.h(localObject, "<set-?>");
    localFinderLiveRelatedLoader.ufx = ((f)localObject);
    localFinderLiveRelatedLoader.fetchEndCallback = ((b)new a(this));
    this.ufu = localFinderLiveRelatedLoader;
    AppMethodBeat.o(245805);
  }
  
  public static com.tencent.mm.plugin.finder.live.viewmodel.d deN()
  {
    AppMethodBeat.i(245796);
    Object localObject = o.ujN;
    localObject = o.dfY();
    AppMethodBeat.o(245796);
    return localObject;
  }
  
  public final boolean IX(int paramInt)
  {
    AppMethodBeat.i(245801);
    Log.i(TAG, "preloadData");
    if (this.uft)
    {
      Log.w(TAG, "return for hasPreload");
      AppMethodBeat.o(245801);
      return false;
    }
    if (paramInt != 0)
    {
      Log.w(TAG, "return for newPos:".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(245801);
      return false;
    }
    this.uft = true;
    Object localObject1 = o.ujN;
    if (o.dfY() != null)
    {
      localObject1 = o.ujN;
      localObject1 = o.dfZ();
      Object localObject2;
      label124:
      Object localObject3;
      if (localObject1 != null)
      {
        localObject2 = Long.valueOf(((g)localObject1).hFK);
        localObject1 = o.ujN;
        localObject1 = o.dfZ();
        if (localObject1 == null) {
          break label254;
        }
        localObject1 = ((g)localObject1).hwg;
        localObject3 = o.ujN;
        localObject3 = o.dfY();
        if (localObject3 == null) {
          break label260;
        }
        localObject3 = ((com.tencent.mm.plugin.finder.live.viewmodel.d)localObject3).ufx;
        label146:
        if (localObject3 == null) {
          break label271;
        }
        if (localObject2 == null) {
          break label266;
        }
      }
      label260:
      label266:
      for (long l = ((Long)localObject2).longValue();; l = 0L)
      {
        ((f)localObject3).hFK = l;
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = "";
        }
        ((f)localObject3).atS((String)localObject2);
        if (((f)localObject3).uiy != 1) {
          break label286;
        }
        if (localObject3 != null)
        {
          this.ufu.setPreload((com.tencent.mm.plugin.finder.feed.model.internal.j)this.ufs);
          this.ufu.a((f)localObject3);
          localObject1 = this.ufu;
          if (localObject1 != null) {
            ((FinderLiveRelatedLoader)localObject1).requestPreload();
          }
        }
        AppMethodBeat.o(245801);
        return true;
        localObject2 = null;
        break;
        label254:
        localObject1 = null;
        break label124;
        localObject3 = null;
        break label146;
      }
      label271:
      Log.w(TAG, "return for loaderParams is null");
      AppMethodBeat.o(245801);
      return false;
      label286:
      AppMethodBeat.o(245801);
      return false;
    }
    AppMethodBeat.o(245801);
    return false;
  }
  
  public final void a(c.b paramb)
  {
    AppMethodBeat.i(245802);
    p.h(paramb, "callback");
    if (!(paramb instanceof FinderLiveViewCallback)) {
      paramb = null;
    }
    for (;;)
    {
      this.ufr = ((FinderLiveViewCallback)paramb);
      FinderLiveViewCallback localFinderLiveViewCallback = this.ufr;
      if (localFinderLiveViewCallback != null)
      {
        paramb = o.ujN;
        com.tencent.mm.plugin.finder.live.viewmodel.d locald = o.dfY();
        paramb = locald;
        if (locald == null) {
          paramb = new com.tencent.mm.plugin.finder.live.viewmodel.d();
        }
        localFinderLiveViewCallback.a(paramb);
      }
      paramb = this.ufr;
      if (paramb != null)
      {
        paramb = paramb.ufI;
        if (paramb != null)
        {
          this.ufu.register((com.tencent.mm.view.j)paramb);
          AppMethodBeat.o(245802);
          return;
        }
      }
      AppMethodBeat.o(245802);
      return;
    }
  }
  
  public final void boE()
  {
    AppMethodBeat.i(245797);
    Object localObject1 = o.ujN;
    localObject1 = o.dfZ();
    Object localObject2;
    label43:
    Object localObject3;
    label65:
    long l;
    if (localObject1 != null)
    {
      localObject2 = Long.valueOf(((g)localObject1).hFK);
      localObject1 = o.ujN;
      localObject1 = o.dfZ();
      if (localObject1 == null) {
        break label149;
      }
      localObject1 = ((g)localObject1).hwg;
      localObject3 = o.ujN;
      localObject3 = o.dfY();
      if (localObject3 == null) {
        break label154;
      }
      localObject3 = ((com.tencent.mm.plugin.finder.live.viewmodel.d)localObject3).ufx;
      if (localObject3 == null) {
        break label165;
      }
      if (localObject2 == null) {
        break label160;
      }
      l = ((Long)localObject2).longValue();
      label81:
      ((f)localObject3).hFK = l;
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "";
      }
      ((f)localObject3).atS((String)localObject2);
      this.ufu.a((f)localObject3);
      this.ufu.requestLoadMore();
    }
    for (;;)
    {
      Log.i(TAG, "load more data params:".concat(String.valueOf(localObject3)));
      AppMethodBeat.o(245797);
      return;
      localObject2 = null;
      break;
      label149:
      localObject1 = null;
      break label43;
      label154:
      localObject3 = null;
      break label65;
      label160:
      l = 0L;
      break label81;
      label165:
      localObject1 = this.ufr;
      if (localObject1 != null)
      {
        localObject2 = o.ujN;
        ((FinderLiveViewCallback)localObject1).a(1000, o.dfY(), 0);
      }
    }
  }
  
  public final boolean deK()
  {
    AppMethodBeat.i(245798);
    if (!this.ufs.isLoading)
    {
      if (!this.uft)
      {
        Object localObject = o.ujN;
        localObject = o.dfY();
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.d)localObject).ufx;
          if ((localObject == null) || (((f)localObject).uiy != 1)) {}
        }
      }
    }
    else
    {
      Log.i(TAG, "canLoadMore isLoading:" + this.ufs.isLoading + " hasPreload:" + this.uft);
      AppMethodBeat.o(245798);
      return false;
    }
    AppMethodBeat.o(245798);
    return true;
  }
  
  public final boolean deL()
  {
    AppMethodBeat.i(245799);
    Object localObject = o.ujN;
    localObject = o.dfY();
    if (localObject != null)
    {
      if (!((com.tencent.mm.plugin.finder.live.viewmodel.d)localObject).diM())
      {
        f localf = ((com.tencent.mm.plugin.finder.live.viewmodel.d)localObject).ufx;
        if ((localf == null) || (localf.dLS != 2))
        {
          localf = ((com.tencent.mm.plugin.finder.live.viewmodel.d)localObject).ufx;
          if ((localf == null) || (localf.dLS != 2))
          {
            localf = ((com.tencent.mm.plugin.finder.live.viewmodel.d)localObject).ufx;
            if ((localf == null) || (localf.dLS != 1001))
            {
              localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.d)localObject).ufx;
              if ((localObject == null) || (((f)localObject).uiy != 1)) {
                break label103;
              }
            }
          }
        }
      }
      AppMethodBeat.o(245799);
      return true;
      label103:
      AppMethodBeat.o(245799);
      return false;
    }
    AppMethodBeat.o(245799);
    return false;
  }
  
  public final boolean deM()
  {
    AppMethodBeat.i(245800);
    Object localObject = o.ujN;
    localObject = o.dfY();
    if (localObject != null)
    {
      boolean bool = ((com.tencent.mm.plugin.finder.live.viewmodel.d)localObject).diM();
      AppMethodBeat.o(245800);
      return bool;
    }
    AppMethodBeat.o(245800);
    return false;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(245804);
    Object localObject = this.ufs;
    if (localObject != null) {
      ((m)localObject).clearCache();
    }
    localObject = this.ufr;
    if (localObject != null)
    {
      localObject = ((FinderLiveViewCallback)localObject).ufI;
      if (localObject != null) {
        this.ufu.unregister((com.tencent.mm.view.j)localObject);
      }
    }
    this.ufr = null;
    AppMethodBeat.o(245804);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveData;", "invoke", "com/tencent/mm/plugin/finder/live/FinderLivePresenter$loader$1$1"})
  static final class a
    extends q
    implements b<IResponse<c>, x>
  {
    a(d paramd)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/FinderLivePresenter$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.d
 * JD-Core Version:    0.7.0.1
 */