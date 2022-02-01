package com.tencent.mm.emoji.sync;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.LinkedList;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/sync/EmojiSyncLoaderIPC;", "Lcom/tencent/mm/emoji/sync/IEmojiSyncLoader;", "customType", "", "(I)V", "TAG", "", "callbackQueue", "Ljava/util/LinkedList;", "Lcom/tencent/mm/emoji/sync/EmojiSyncLoader$LoadCallback;", "getCustomType", "()I", "isLoadEnd", "", "syncCount", "targetSyncCount", "waitingIndex", "checkSyncEmoji", "", "start", "destroy", "getSyncCount", "getTargetSyncCount", "getWaitingIndex", "hasMore", "init", "loadMore", "registerCallback", "callback", "unregisterCallback", "updateData", "data", "Lcom/tencent/mm/emoji/sync/EmojiSyncLoaderIPC$EmojiSyncData;", "Companion", "EmojiSyncData", "plugin-emojisdk_release"})
public final class EmojiSyncLoaderIPC
  implements j
{
  public static final EmojiSyncLoaderIPC.a jOx;
  private String TAG;
  private final int jNY;
  private int jOd;
  private int jOe;
  private int jOf;
  private boolean jOg;
  private final LinkedList<g.i> jOi;
  
  static
  {
    AppMethodBeat.i(223137);
    jOx = new EmojiSyncLoaderIPC.a((byte)0);
    AppMethodBeat.o(223137);
  }
  
  public EmojiSyncLoaderIPC(int paramInt)
  {
    AppMethodBeat.i(223136);
    this.jNY = paramInt;
    this.TAG = "MicroMsg.EmojiSyncLoaderIPC";
    this.jOi = new LinkedList();
    Object localObject;
    if (this.jNY == 1) {
      localObject = this.TAG;
    }
    for (this.TAG = ((String)localObject + "_capture");; this.TAG = ((String)localObject + "_custom"))
    {
      localObject = new Bundle();
      ((Bundle)localObject).putInt("custom_type", this.jNY);
      com.tencent.mm.ipcinvoker.j.a(MMApplicationContext.getPackageName(), (Parcelable)localObject, k.class, (f)new f() {});
      AppMethodBeat.o(223136);
      return;
      localObject = this.TAG;
    }
  }
  
  public final void a(EmojiSyncData paramEmojiSyncData)
  {
    AppMethodBeat.i(223131);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("updateData: ");
    if (paramEmojiSyncData != null) {}
    for (Integer localInteger = Integer.valueOf(paramEmojiSyncData.jOe);; localInteger = null)
    {
      Log.i(str, localInteger);
      if (paramEmojiSyncData != null) {
        break;
      }
      AppMethodBeat.o(223131);
      return;
    }
    this.jOd = paramEmojiSyncData.jOd;
    this.jOe = paramEmojiSyncData.jOe;
    this.jOf = paramEmojiSyncData.jOf;
    this.jOg = paramEmojiSyncData.jOg;
    d.uiThread((a)new d(this));
    AppMethodBeat.o(223131);
  }
  
  public final void a(final g.i parami)
  {
    AppMethodBeat.i(223122);
    p.k(parami, "callback");
    d.uiThread((a)new b(this, parami));
    AppMethodBeat.o(223122);
  }
  
  public final void aDi()
  {
    AppMethodBeat.i(223127);
    Log.i(this.TAG, "loadMore: ");
    Bundle localBundle = new Bundle();
    localBundle.putInt("custom_type", this.jNY);
    com.tencent.mm.ipcinvoker.j.a(MMApplicationContext.getPackageName(), (Parcelable)localBundle, l.class);
    AppMethodBeat.o(223127);
  }
  
  public final int aDj()
  {
    return this.jOe;
  }
  
  public final int aDk()
  {
    return this.jOf;
  }
  
  public final boolean aDl()
  {
    return !this.jOg;
  }
  
  public final void b(final g.i parami)
  {
    AppMethodBeat.i(223125);
    p.k(parami, "callback");
    d.uiThread((a)new c(this, parami));
    AppMethodBeat.o(223125);
  }
  
  public final void destroy() {}
  
  public final void eD(boolean paramBoolean) {}
  
  public final void init() {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/sync/EmojiSyncLoaderIPC$EmojiSyncData;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "isLoadEnd", "", "()Z", "setLoadEnd", "(Z)V", "panelType", "", "getPanelType", "()I", "setPanelType", "(I)V", "syncCount", "getSyncCount", "setSyncCount", "targetSyncCount", "getTargetSyncCount", "setTargetSyncCount", "waitingIndex", "getWaitingIndex", "setWaitingIndex", "describeContents", "writeToParcel", "", "flags", "CREATOR", "plugin-emojisdk_release"})
  public static final class EmojiSyncData
    implements Parcelable
  {
    public static final a CREATOR;
    int jJL;
    int jOd;
    int jOe;
    int jOf;
    boolean jOg;
    
    static
    {
      AppMethodBeat.i(225908);
      CREATOR = new a((byte)0);
      AppMethodBeat.o(225908);
    }
    
    public EmojiSyncData() {}
    
    public EmojiSyncData(Parcel paramParcel)
    {
      this();
      AppMethodBeat.i(225906);
      this.jJL = paramParcel.readInt();
      this.jOd = paramParcel.readInt();
      this.jOe = paramParcel.readInt();
      this.jOf = paramParcel.readInt();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.jOg = bool;
        AppMethodBeat.o(225906);
        return;
      }
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(225901);
      p.k(paramParcel, "parcel");
      paramParcel.writeInt(this.jJL);
      paramParcel.writeInt(this.jOd);
      paramParcel.writeInt(this.jOe);
      paramParcel.writeInt(this.jOf);
      if (this.jOg) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        AppMethodBeat.o(225901);
        return;
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/sync/EmojiSyncLoaderIPC$EmojiSyncData$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/emoji/sync/EmojiSyncLoaderIPC$EmojiSyncData;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/emoji/sync/EmojiSyncLoaderIPC$EmojiSyncData;", "plugin-emojisdk_release"})
    public static final class a
      implements Parcelable.Creator<EmojiSyncLoaderIPC.EmojiSyncData>
    {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<x>
  {
    b(EmojiSyncLoaderIPC paramEmojiSyncLoaderIPC, g.i parami)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements a<x>
  {
    c(EmojiSyncLoaderIPC paramEmojiSyncLoaderIPC, g.i parami)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements a<x>
  {
    d(EmojiSyncLoaderIPC paramEmojiSyncLoaderIPC)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.sync.EmojiSyncLoaderIPC
 * JD-Core Version:    0.7.0.1
 */