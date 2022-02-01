package com.tencent.mm.plugin.finder.view;

import com.tencent.mm.g.a.hl;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.aqn;
import com.tencent.mm.sdk.b.c;
import d.g.a.a;
import d.g.b.q;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/view/FinderExposeChangedEventListener;", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderExposeInfoChangeEvent;", "()V", "tag", "", "getTag", "()Ljava/lang/String;", "setTag", "(Ljava/lang/String;)V", "callback", "", "event", "getFeedObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "feedId", "", "notifyAdapter", "", "exposeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderObjectExposeInfo;", "plugin-finder_release"})
public abstract class f
  extends c<hl>
{
  public abstract void a(long paramLong, aqn paramaqn);
  
  public abstract String getTag();
  
  public abstract FinderItem wv(long paramLong);
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<z>
  {
    a(f paramf, hl paramhl)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.f
 * JD-Core Version:    0.7.0.1
 */