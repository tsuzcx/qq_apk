package com.tencent.mm.emoji.sync;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/sync/EmojiSyncLoaderIPC;", "Lcom/tencent/mm/emoji/sync/IEmojiSyncLoader;", "customType", "", "(I)V", "TAG", "", "callbackQueue", "Ljava/util/LinkedList;", "Lcom/tencent/mm/emoji/sync/EmojiSyncLoader$LoadCallback;", "getCustomType", "()I", "isLoadEnd", "", "syncCount", "targetSyncCount", "waitingIndex", "checkSyncEmoji", "", "start", "destroy", "getSyncCount", "getTargetSyncCount", "getWaitingIndex", "hasMore", "init", "loadMore", "registerCallback", "callback", "unregisterCallback", "updateData", "data", "Lcom/tencent/mm/emoji/sync/EmojiSyncLoaderIPC$EmojiSyncData;", "Companion", "EmojiSyncData", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class EmojiSyncLoaderIPC
  implements j
{
  public static final EmojiSyncLoaderIPC.a mnr;
  private String TAG;
  private final int mmT;
  private int mna;
  private int mnb;
  private int mnd;
  private boolean mne;
  private final LinkedList<g.i> mng;
  
  static
  {
    AppMethodBeat.i(242582);
    mnr = new EmojiSyncLoaderIPC.a((byte)0);
    AppMethodBeat.o(242582);
  }
  
  public EmojiSyncLoaderIPC(int paramInt)
  {
    AppMethodBeat.i(242570);
    this.mmT = paramInt;
    this.TAG = "MicroMsg.EmojiSyncLoaderIPC";
    this.mng = new LinkedList();
    if (this.mmT == 1) {}
    for (this.TAG = s.X(this.TAG, "_capture");; this.TAG = s.X(this.TAG, "_custom"))
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("custom_type", this.mmT);
      com.tencent.mm.ipcinvoker.j.a(MMApplicationContext.getPackageName(), (Parcelable)localBundle, k.class, new EmojiSyncLoaderIPC..ExternalSyntheticLambda0(this));
      AppMethodBeat.o(242570);
      return;
    }
  }
  
  private static final void a(EmojiSyncLoaderIPC paramEmojiSyncLoaderIPC, Bundle paramBundle)
  {
    AppMethodBeat.i(242573);
    s.u(paramEmojiSyncLoaderIPC, "this$0");
    Log.i(paramEmojiSyncLoaderIPC.TAG, s.X("init data callback: ", paramBundle));
    if (paramBundle == null) {}
    for (paramBundle = null;; paramBundle = (EmojiSyncLoaderIPC.EmojiSyncData)paramBundle.getParcelable("data"))
    {
      paramEmojiSyncLoaderIPC.a(paramBundle);
      AppMethodBeat.o(242573);
      return;
    }
  }
  
  public final void a(EmojiSyncLoaderIPC.EmojiSyncData paramEmojiSyncData)
  {
    AppMethodBeat.i(242601);
    String str = this.TAG;
    if (paramEmojiSyncData == null) {}
    for (Object localObject = null;; localObject = Integer.valueOf(paramEmojiSyncData.mnb))
    {
      Log.i(str, s.X("updateData: ", localObject));
      if (paramEmojiSyncData != null) {
        break;
      }
      AppMethodBeat.o(242601);
      return;
    }
    this.mna = paramEmojiSyncData.mna;
    this.mnb = paramEmojiSyncData.mnb;
    this.mnd = paramEmojiSyncData.mnd;
    this.mne = paramEmojiSyncData.mne;
    d.uiThread((a)new d(this));
    AppMethodBeat.o(242601);
  }
  
  public final void a(final g.i parami)
  {
    AppMethodBeat.i(242590);
    s.u(parami, "callback");
    d.uiThread((a)new b(this, parami));
    AppMethodBeat.o(242590);
  }
  
  public final void aWi()
  {
    AppMethodBeat.i(242595);
    Log.i(this.TAG, "loadMore: ");
    Bundle localBundle = new Bundle();
    localBundle.putInt("custom_type", this.mmT);
    com.tencent.mm.ipcinvoker.j.a(MMApplicationContext.getPackageName(), (Parcelable)localBundle, l.class);
    AppMethodBeat.o(242595);
  }
  
  public final int aWj()
  {
    return this.mnb;
  }
  
  public final int aWk()
  {
    return this.mnd;
  }
  
  public final boolean aWl()
  {
    return !this.mne;
  }
  
  public final void b(final g.i parami)
  {
    AppMethodBeat.i(242594);
    s.u(parami, "callback");
    d.uiThread((a)new c(this, parami));
    AppMethodBeat.o(242594);
  }
  
  public final void destroy() {}
  
  public final void fo(boolean paramBoolean) {}
  
  public final void init() {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<ah>
  {
    b(EmojiSyncLoaderIPC paramEmojiSyncLoaderIPC, g.i parami)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<ah>
  {
    c(EmojiSyncLoaderIPC paramEmojiSyncLoaderIPC, g.i parami)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements a<ah>
  {
    d(EmojiSyncLoaderIPC paramEmojiSyncLoaderIPC)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.emoji.sync.EmojiSyncLoaderIPC
 * JD-Core Version:    0.7.0.1
 */