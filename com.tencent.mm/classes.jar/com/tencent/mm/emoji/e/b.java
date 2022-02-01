package com.tencent.mm.emoji.e;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashMap;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/upload/EmojiCaptureCallbackDispatcher;", "", "()V", "TAG", "", "callbackMap", "Ljava/util/HashMap;", "", "Ljava/util/HashSet;", "Lcom/tencent/mm/emoji/upload/EmojiCaptureCallback;", "Lkotlin/collections/HashSet;", "Lkotlin/collections/HashMap;", "broadcastResult", "", "timeEnter", "success", "", "md5", "dispatch", "registerCallback", "callback", "unregisterCallback", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  private static final String TAG;
  public static final b mnS;
  private static final HashMap<Long, HashSet<a>> mnT;
  
  static
  {
    AppMethodBeat.i(105771);
    mnS = new b();
    TAG = "MicroMsg.EmojiCaptureCallbackDispatcher";
    mnT = new HashMap();
    AppMethodBeat.o(105771);
  }
  
  public static void a(long paramLong, a parama)
  {
    AppMethodBeat.i(105768);
    s.u(parama, "callback");
    d.uiThread((kotlin.g.a.a)new b(paramLong, parama));
    AppMethodBeat.o(105768);
  }
  
  public static void b(long paramLong, a parama)
  {
    AppMethodBeat.i(105769);
    s.u(parama, "callback");
    d.uiThread((kotlin.g.a.a)new c(paramLong, parama));
    AppMethodBeat.o(105769);
  }
  
  public static void b(long paramLong, boolean paramBoolean, final String paramString)
  {
    AppMethodBeat.i(105770);
    Log.i(TAG, "dispatch: " + paramLong + ", " + paramBoolean + ", " + paramString);
    d.uiThread((kotlin.g.a.a)new a(paramLong, paramBoolean, paramString));
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bbA())
    {
      Intent localIntent = new Intent("com.tencent.mm.Emoji_Capture_Upload");
      localIntent.putExtra("upload_time_enter", paramLong);
      localIntent.putExtra("upload_success", paramBoolean);
      localIntent.putExtra("upload_md5", paramString);
      MMApplicationContext.getContext().sendBroadcast(localIntent);
    }
    AppMethodBeat.o(105770);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(long paramLong, boolean paramBoolean, String paramString)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(long paramLong, a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(long paramLong, a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.e.b
 * JD-Core Version:    0.7.0.1
 */