package com.tencent.mm.emoji.sync;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.emoji.b.d.h.c;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/sync/EmojiSyncQueue;", "", "parallelCount", "", "(I)V", "coverCallback", "com/tencent/mm/emoji/sync/EmojiSyncQueue$coverCallback$1", "Lcom/tencent/mm/emoji/sync/EmojiSyncQueue$coverCallback$1;", "externalCallback", "Lcom/tencent/mm/emoji/sync/EmojiSyncQueue$SyncQueueCallback;", "getExternalCallback", "()Lcom/tencent/mm/emoji/sync/EmojiSyncQueue$SyncQueueCallback;", "setExternalCallback", "(Lcom/tencent/mm/emoji/sync/EmojiSyncQueue$SyncQueueCallback;)V", "pendingQueue", "Ljava/util/LinkedList;", "Lcom/tencent/mm/emoji/sync/EmojiSyncQueue$EmojiSyncData;", "runningQueue", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "addTask", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "checkStart", "destroy", "queue", "emojiList", "", "start", "EmojiSyncData", "SyncQueueCallback", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
{
  final int mnD;
  final LinkedList<a> mnE;
  final HashMap<String, a> mnF;
  b mnG;
  final d mnH;
  
  public i()
  {
    AppMethodBeat.i(242551);
    this.mnD = 3;
    this.mnE = new LinkedList();
    this.mnF = new HashMap();
    this.mnH = new d(this);
    AppMethodBeat.o(242551);
  }
  
  public final void ayO()
  {
    AppMethodBeat.i(242555);
    d.uiThread((a)new c(this));
    AppMethodBeat.o(242555);
  }
  
  public final void bA(final List<a> paramList)
  {
    AppMethodBeat.i(242553);
    s.u(paramList, "emojiList");
    d.uiThread((a)new e(this, paramList));
    AppMethodBeat.o(242553);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/sync/EmojiSyncQueue$EmojiSyncData;", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "index", "", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;I)V", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "getIndex", "()I", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    final int index;
    final EmojiInfo mgK;
    
    public a(EmojiInfo paramEmojiInfo, int paramInt)
    {
      AppMethodBeat.i(242602);
      this.mgK = paramEmojiInfo;
      this.index = paramInt;
      AppMethodBeat.o(242602);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/sync/EmojiSyncQueue$SyncQueueCallback;", "", "onState", "", "state", "", "emojiData", "Lcom/tencent/mm/emoji/sync/EmojiSyncQueue$EmojiSyncData;", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void a(int paramInt, i.a parama);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<ah>
  {
    c(i parami)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/emoji/sync/EmojiSyncQueue$coverCallback$1", "Lcom/tencent/mm/emoji/loader/request/Request$StateCallback;", "Landroid/graphics/Bitmap;", "onState", "", "state", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "result", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements h.c<Bitmap>
  {
    d(i parami) {}
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements a<ah>
    {
      a(i parami, EmojiInfo paramEmojiInfo, int paramInt)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements a<ah>
  {
    e(i parami, List<i.a> paramList)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.sync.i
 * JD-Core Version:    0.7.0.1
 */