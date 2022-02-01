package com.tencent.mm.plugin.finder.view;

import com.tencent.mm.g.a.hf;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.amp;
import com.tencent.mm.sdk.b.c;
import d.g.a.a;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/view/FinderExposeChangedEventListener;", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderExposeInfoChangeEvent;", "()V", "tag", "", "getTag", "()Ljava/lang/String;", "setTag", "(Ljava/lang/String;)V", "callback", "", "event", "getFeedObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "feedId", "", "notifyAdapter", "", "exposeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderObjectExposeInfo;", "plugin-finder_release"})
public abstract class e
  extends c<hf>
{
  public abstract void a(long paramLong, amp paramamp);
  
  public abstract String getTag();
  
  public abstract FinderItem uf(long paramLong);
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements a<y>
  {
    a(e parame, hf paramhf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.e
 * JD-Core Version:    0.7.0.1
 */