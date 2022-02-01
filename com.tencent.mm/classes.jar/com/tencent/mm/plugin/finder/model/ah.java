package com.tencent.mm.plugin.finder.model;

import android.arch.lifecycle.MutableLiveData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.extension.reddot.h.a;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.view.recyclerview.g.b;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/model/FinderHeaderFullMergedData;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "msgNotifyData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderMsgNotifyData;", "privateMsgNotifyData", "Lcom/tencent/mm/plugin/finder/model/FinderPrivateMsgNotifyData;", "commentFailedNotifyDataList", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderCommentFailedNotifyData;", "(Lcom/tencent/mm/plugin/finder/model/FeedHeaderMsgNotifyData;Lcom/tencent/mm/plugin/finder/model/FinderPrivateMsgNotifyData;Ljava/util/concurrent/ConcurrentLinkedQueue;)V", "getCommentFailedNotifyDataList", "()Ljava/util/concurrent/ConcurrentLinkedQueue;", "getMsgNotifyData", "()Lcom/tencent/mm/plugin/finder/model/FeedHeaderMsgNotifyData;", "getPrivateMsgNotifyData", "()Lcom/tencent/mm/plugin/finder/model/FinderPrivateMsgNotifyData;", "compare", "", "obj", "getItemId", "", "getItemType", "isEmpty", "", "plugin-finder_release"})
public final class ah
  extends g.b
  implements i
{
  public final h msgNotifyData;
  public final bh tSf;
  public final ConcurrentLinkedQueue<f> tSj;
  
  public ah(h paramh, bh parambh, ConcurrentLinkedQueue<f> paramConcurrentLinkedQueue)
  {
    AppMethodBeat.i(248761);
    this.msgNotifyData = paramh;
    this.tSf = parambh;
    this.tSj = paramConcurrentLinkedQueue;
    AppMethodBeat.o(248761);
  }
  
  public final int a(i parami)
  {
    AppMethodBeat.i(248758);
    p.h(parami, "obj");
    AppMethodBeat.o(248758);
    return 2147483647;
  }
  
  public final int cxn()
  {
    return 2019;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(248760);
    Iterator localIterator = ((Iterable)this.tSj).iterator();
    Object localObject;
    int i;
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (((f)localObject).uNO != 1)
      {
        i = 1;
        label47:
        if (i == 0) {
          break label101;
        }
      }
    }
    for (;;)
    {
      if ((localObject != null) || (this.msgNotifyData.count > 0)) {
        break label108;
      }
      localObject = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
      localObject = (h.a)com.tencent.mm.plugin.finder.extension.reddot.h.daX().getValue();
      if ((localObject != null) && (((h.a)localObject).dEF == true)) {
        break label108;
      }
      AppMethodBeat.o(248760);
      return true;
      i = 0;
      break label47;
      label101:
      break;
      localObject = null;
    }
    label108:
    AppMethodBeat.o(248760);
    return false;
  }
  
  public final long lT()
  {
    AppMethodBeat.i(248759);
    long l = hashCode();
    AppMethodBeat.o(248759);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.ah
 * JD-Core Version:    0.7.0.1
 */