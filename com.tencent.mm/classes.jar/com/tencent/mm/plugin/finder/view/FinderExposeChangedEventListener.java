package com.tencent.mm.plugin.finder.view;

import androidx.lifecycle.q;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.it;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.brh;
import com.tencent.mm.sdk.event.IListener;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderExposeChangedEventListener;", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderExposeInfoChangeEvent;", "()V", "tag", "", "getTag", "()Ljava/lang/String;", "setTag", "(Ljava/lang/String;)V", "callback", "", "event", "getFeedObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "feedId", "", "notifyAdapter", "", "exposeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderObjectExposeInfo;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class FinderExposeChangedEventListener
  extends IListener<it>
{
  public FinderExposeChangedEventListener()
  {
    super((q)f.hfK);
  }
  
  public abstract void a(long paramLong, brh parambrh);
  
  public abstract String getTag();
  
  public abstract FinderItem np(long paramLong);
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<ah>
  {
    a(it paramit, FinderExposeChangedEventListener paramFinderExposeChangedEventListener)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderExposeChangedEventListener
 * JD-Core Version:    0.7.0.1
 */