package com.tencent.mm.plugin.finder.storage;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.GridLayoutManager.b;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.ad;
import com.tencent.mm.plugin.finder.convert.ai;
import com.tencent.mm.plugin.finder.convert.cd;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.finder.viewmodel.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.view.recyclerview.e;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/FinderProfileGridLayoutConfig;", "Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "gridSpanCount", "", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "isSelfFlag", "", "username", "", "(ILcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;ZLjava/lang/String;)V", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getGridSpanCount", "()I", "getDefaultConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "getItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "extraMap", "Lkotlin/Function1;", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "context", "Landroid/content/Context;", "getViewPool", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "Lcom/tencent/mm/ui/MMActivity;", "plugin-finder_release"})
public class ae
  extends ak
{
  private final int Amp;
  final String username;
  final BaseFinderFeedLoader xnX;
  final boolean xnY;
  
  public ae(BaseFinderFeedLoader paramBaseFinderFeedLoader, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(288754);
    this.Amp = 3;
    this.xnX = paramBaseFinderFeedLoader;
    this.xnY = paramBoolean;
    this.username = paramString;
    AppMethodBeat.o(288754);
  }
  
  public static e<?> Qk(int paramInt)
  {
    AppMethodBeat.i(288752);
    Object localObject = aj.AGc;
    aj.em("FinderProfileGridLayoutConfig", paramInt);
    localObject = (e)new com.tencent.mm.plugin.finder.convert.f();
    AppMethodBeat.o(288752);
    return localObject;
  }
  
  public com.tencent.mm.view.recyclerview.f O(final b<? super Integer, ? extends e<?>> paramb)
  {
    AppMethodBeat.i(288751);
    paramb = (com.tencent.mm.view.recyclerview.f)new a(this, paramb);
    AppMethodBeat.o(288751);
    return paramb;
  }
  
  public final RecyclerView.LayoutManager eW(Context paramContext)
  {
    AppMethodBeat.i(288749);
    p.k(paramContext, "context");
    paramContext = new GridLayoutManager(this.Amp);
    paramContext.a((GridLayoutManager.b)new c());
    paramContext.setItemPrefetchEnabled(true);
    paramContext = (RecyclerView.LayoutManager)paramContext;
    AppMethodBeat.o(288749);
    return paramContext;
  }
  
  public final RecyclerView.m g(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(288753);
    p.k(paramMMActivity, "context");
    g localg = g.Xox;
    paramMMActivity = ((c)g.b((AppCompatActivity)paramMMActivity).i(c.class)).BgW;
    AppMethodBeat.o(288753);
    return paramMMActivity;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(288750);
    RecyclerView.h localh = (RecyclerView.h)new ae.b();
    AppMethodBeat.o(288750);
    return localh;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/storage/FinderProfileGridLayoutConfig$getItemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.view.recyclerview.f
  {
    a(b paramb) {}
    
    public final e<?> yx(int paramInt)
    {
      AppMethodBeat.i(225400);
      switch (paramInt)
      {
      default: 
        localObject = paramb;
        if (localObject != null)
        {
          e locale = (e)((b)localObject).invoke(Integer.valueOf(paramInt));
          localObject = locale;
          if (locale != null) {}
        }
        else
        {
          localObject = ae.Qk(paramInt);
        }
        AppMethodBeat.o(225400);
        return localObject;
      case 4: 
      case 3002: 
        localObject = (e)new cd(this.Amq.xnX, this.Amq.username, this.Amq.xnY, (byte)0);
        AppMethodBeat.o(225400);
        return localObject;
      case 2: 
      case 3001: 
        localObject = (e)new cd(this.Amq.xnX, this.Amq.username, this.Amq.xnY, (byte)0);
        AppMethodBeat.o(225400);
        return localObject;
      case -3: 
        localObject = (e)new ai();
        AppMethodBeat.o(225400);
        return localObject;
      }
      Object localObject = (e)new ad();
      AppMethodBeat.o(225400);
      return localObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/storage/FinderProfileGridLayoutConfig$getLayoutManager$1", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "getSpanSize", "", "position", "plugin-finder_release"})
  public static final class c
    extends GridLayoutManager.b
  {
    public final int cx(int paramInt)
    {
      return 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.ae
 * JD-Core Version:    0.7.0.1
 */