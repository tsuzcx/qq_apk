package com.tencent.mm.emoji.sync;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/sync/EmojiSyncQueue;", "", "parallelCount", "", "(I)V", "coverCallback", "com/tencent/mm/emoji/sync/EmojiSyncQueue$coverCallback$1", "Lcom/tencent/mm/emoji/sync/EmojiSyncQueue$coverCallback$1;", "externalCallback", "Lcom/tencent/mm/emoji/sync/EmojiSyncQueue$SyncQueueCallback;", "getExternalCallback", "()Lcom/tencent/mm/emoji/sync/EmojiSyncQueue$SyncQueueCallback;", "setExternalCallback", "(Lcom/tencent/mm/emoji/sync/EmojiSyncQueue$SyncQueueCallback;)V", "pendingQueue", "Ljava/util/LinkedList;", "Lcom/tencent/mm/emoji/sync/EmojiSyncQueue$EmojiSyncData;", "runningQueue", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "addTask", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "checkStart", "destroy", "queue", "emojiList", "", "start", "EmojiSyncData", "SyncQueueCallback", "plugin-emojisdk_release"})
public final class i
{
  final LinkedList<a> jOK;
  final HashMap<String, a> jOL;
  b jOM;
  final d jON;
  final int jOO;
  
  public i()
  {
    AppMethodBeat.i(224092);
    this.jOO = 3;
    this.jOK = new LinkedList();
    this.jOL = new HashMap();
    this.jON = new d(this);
    AppMethodBeat.o(224092);
  }
  
  public final void aDx()
  {
    AppMethodBeat.i(224091);
    d.uiThread((a)new c(this));
    AppMethodBeat.o(224091);
  }
  
  public final void ab(final List<a> paramList)
  {
    AppMethodBeat.i(224089);
    p.k(paramList, "emojiList");
    d.uiThread((a)new e(this, paramList));
    AppMethodBeat.o(224089);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/sync/EmojiSyncQueue$EmojiSyncData;", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "index", "", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;I)V", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "getIndex", "()I", "plugin-emojisdk_release"})
  public static final class a
  {
    final int index;
    final EmojiInfo jHh;
    
    public a(EmojiInfo paramEmojiInfo, int paramInt)
    {
      AppMethodBeat.i(234076);
      this.jHh = paramEmojiInfo;
      this.index = paramInt;
      AppMethodBeat.o(234076);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/sync/EmojiSyncQueue$SyncQueueCallback;", "", "onState", "", "state", "", "emojiData", "Lcom/tencent/mm/emoji/sync/EmojiSyncQueue$EmojiSyncData;", "plugin-emojisdk_release"})
  public static abstract interface b
  {
    public abstract void a(int paramInt, i.a parama);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements a<x>
  {
    c(i parami)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/emoji/sync/EmojiSyncQueue$coverCallback$1", "Lcom/tencent/mm/emoji/loader/request/Request$StateCallback;", "Landroid/graphics/Bitmap;", "onState", "", "state", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "result", "plugin-emojisdk_release"})
  public static final class d
    implements com.tencent.mm.emoji.loader.d.i.c<Bitmap>
  {
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements a<x>
    {
      a(i.d paramd, EmojiInfo paramEmojiInfo, int paramInt)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements a<x>
  {
    e(i parami, List paramList)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.sync.i
 * JD-Core Version:    0.7.0.1
 */