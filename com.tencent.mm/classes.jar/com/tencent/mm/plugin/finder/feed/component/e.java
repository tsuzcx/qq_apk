package com.tencent.mm.plugin.finder.feed.component;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.feed.jumper.a;
import com.tencent.mm.plugin.finder.feed.jumper.b;
import com.tencent.mm.plugin.finder.feed.jumper.c;
import com.tencent.mm.plugin.finder.feed.jumper.g;
import com.tencent.mm.plugin.finder.feed.jumper.m;
import com.tencent.mm.plugin.finder.feed.jumper.o;
import com.tencent.mm.plugin.finder.feed.jumper.p;
import com.tencent.mm.plugin.finder.feed.jumper.q;
import com.tencent.mm.plugin.finder.feed.jumper.s;
import com.tencent.mm.plugin.finder.feed.jumper.t;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.r;
import kotlin.v;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/component/FinderAdFeedJumperUIC;", "Lcom/tencent/mm/plugin/finder/feed/component/FinderBaseAdFeedJumperUIC;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "enterTime", "", "getEnterTime", "()J", "getCacheHandler", "Lcom/tencent/mm/plugin/finder/feed/jumper/JumperCacheHandler;", "businessType", "", "getViewEventHandler", "Lcom/tencent/mm/plugin/finder/feed/jumper/JumperViewEventHandler;", "registerJumperObserver", "", "Lcom/tencent/mm/plugin/finder/feed/component/FinderBaseAdFeedJumperUIC$IGenerateObserver;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends f
{
  public final long enterTime;
  
  public e(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(364044);
    this.enterTime = cn.bDw();
    AppMethodBeat.o(364044);
  }
  
  public e(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(364050);
    this.enterTime = cn.bDw();
    AppMethodBeat.o(364050);
  }
  
  public final s NM(int paramInt)
  {
    AppMethodBeat.i(364067);
    switch (paramInt)
    {
    default: 
      locals = (s)new com.tencent.mm.plugin.finder.feed.jumper.f();
      AppMethodBeat.o(364067);
      return locals;
    case 1: 
      locals = (s)new c();
      AppMethodBeat.o(364067);
      return locals;
    case 2: 
      locals = (s)new b();
      AppMethodBeat.o(364067);
      return locals;
    case 3: 
      locals = (s)new p();
      AppMethodBeat.o(364067);
      return locals;
    case 6: 
      locals = (s)new g();
      AppMethodBeat.o(364067);
      return locals;
    case 13: 
      locals = (s)new o();
      AppMethodBeat.o(364067);
      return locals;
    }
    s locals = (s)new t();
    AppMethodBeat.o(364067);
    return locals;
  }
  
  public final q NN(int paramInt)
  {
    AppMethodBeat.i(364071);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(364071);
      return null;
    case 1: 
      localq = (q)new m();
      AppMethodBeat.o(364071);
      return localq;
    }
    q localq = (q)new a();
    AppMethodBeat.o(364071);
    return localq;
  }
  
  public final Map<Integer, f.c> edg()
  {
    AppMethodBeat.i(364058);
    Map localMap = ak.e(new r[] { v.Y(Integer.valueOf(1), new a()), v.Y(Integer.valueOf(2), new b()), v.Y(Integer.valueOf(3), new c()) });
    AppMethodBeat.o(364058);
    return localMap;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/component/FinderAdFeedJumperUIC$registerJumperObserver$1", "Lcom/tencent/mm/plugin/finder/feed/component/FinderBaseAdFeedJumperUIC$IGenerateObserver;", "generate", "Lcom/tencent/mm/plugin/finder/feed/component/FeedAdHotSpotJumperObserver;", "layoutId", "", "tagId", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements f.c
  {
    public final int edh()
    {
      return e.e.finder_feed_jump_info_tag_1;
    }
    
    public final int edi()
    {
      return e.f.finder_feed_ad_hotspot_layout;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/component/FinderAdFeedJumperUIC$registerJumperObserver$2", "Lcom/tencent/mm/plugin/finder/feed/component/FinderBaseAdFeedJumperUIC$IGenerateObserver;", "generate", "Lcom/tencent/mm/plugin/finder/feed/component/FeedAdCommonJumperObserver;", "layoutId", "", "tagId", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements f.c
  {
    public final int edh()
    {
      return e.e.finder_feed_jump_info_tag_2;
    }
    
    public final int edi()
    {
      return e.f.finder_feed_ad_common_layout;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/component/FinderAdFeedJumperUIC$registerJumperObserver$3", "Lcom/tencent/mm/plugin/finder/feed/component/FinderBaseAdFeedJumperUIC$IGenerateObserver;", "generate", "Lcom/tencent/mm/plugin/finder/feed/component/FeedAdPosJumperObserver;", "layoutId", "", "tagId", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements f.c
  {
    public final int edh()
    {
      return e.e.finder_feed_jump_info_tag_3;
    }
    
    public final int edi()
    {
      return e.f.finder_feed_strong_red_packet_layout;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.component.e
 * JD-Core Version:    0.7.0.1
 */