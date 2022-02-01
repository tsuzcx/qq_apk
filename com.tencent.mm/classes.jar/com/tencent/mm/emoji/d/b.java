package com.tencent.mm.emoji.d;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashMap;
import java.util.HashSet;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/upload/EmojiCaptureCallbackDispatcher;", "", "()V", "TAG", "", "callbackMap", "Ljava/util/HashMap;", "", "Ljava/util/HashSet;", "Lcom/tencent/mm/emoji/upload/EmojiCaptureCallback;", "Lkotlin/collections/HashSet;", "Lkotlin/collections/HashMap;", "broadcastResult", "", "timeEnter", "success", "", "md5", "dispatch", "registerCallback", "callback", "unregisterCallback", "plugin-emojisdk_release"})
public final class b
{
  private static final String TAG = "MicroMsg.EmojiCaptureCallbackDispatcher";
  private static final HashMap<Long, HashSet<a>> jPb;
  public static final b jPc;
  
  static
  {
    AppMethodBeat.i(105771);
    jPc = new b();
    TAG = "MicroMsg.EmojiCaptureCallbackDispatcher";
    jPb = new HashMap();
    AppMethodBeat.o(105771);
  }
  
  public static void a(long paramLong, a parama)
  {
    AppMethodBeat.i(105768);
    p.k(parama, "callback");
    d.uiThread((kotlin.g.a.a)new b(paramLong, parama));
    AppMethodBeat.o(105768);
  }
  
  public static void b(long paramLong, a parama)
  {
    AppMethodBeat.i(105769);
    p.k(parama, "callback");
    d.uiThread((kotlin.g.a.a)new c(paramLong, parama));
    AppMethodBeat.o(105769);
  }
  
  public static void b(long paramLong, boolean paramBoolean, final String paramString)
  {
    AppMethodBeat.i(105770);
    Log.i(TAG, "dispatch: " + paramLong + ", " + paramBoolean + ", " + paramString);
    d.uiThread((kotlin.g.a.a)new a(paramLong, paramBoolean, paramString));
    Object localObject = com.tencent.mm.kernel.h.aHD().aHf();
    p.j(localObject, "MMKernel.process().current()");
    if (((com.tencent.mm.kernel.b.h)localObject).aIE())
    {
      localObject = new Intent("com.tencent.mm.Emoji_Capture_Upload");
      ((Intent)localObject).putExtra("upload_time_enter", paramLong);
      ((Intent)localObject).putExtra("upload_success", paramBoolean);
      ((Intent)localObject).putExtra("upload_md5", paramString);
      MMApplicationContext.getContext().sendBroadcast((Intent)localObject);
    }
    AppMethodBeat.o(105770);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<x>
  {
    a(long paramLong, boolean paramBoolean, String paramString)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(long paramLong, a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    c(long paramLong, a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.d.b
 * JD-Core Version:    0.7.0.1
 */