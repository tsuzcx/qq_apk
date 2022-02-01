package com.tencent.mm.emoji.d;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashMap;
import java.util.HashSet;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/upload/EmojiCaptureCallbackDispatcher;", "", "()V", "TAG", "", "callbackMap", "Ljava/util/HashMap;", "", "Ljava/util/HashSet;", "Lcom/tencent/mm/emoji/upload/EmojiCaptureCallback;", "Lkotlin/collections/HashSet;", "Lkotlin/collections/HashMap;", "broadcastResult", "", "timeEnter", "success", "", "md5", "dispatch", "registerCallback", "callback", "unregisterCallback", "plugin-emojisdk_release"})
public final class b
{
  private static final String TAG = "MicroMsg.EmojiCaptureCallbackDispatcher";
  private static final HashMap<Long, HashSet<a>> hdu;
  public static final b hdv;
  
  static
  {
    AppMethodBeat.i(105771);
    hdv = new b();
    TAG = "MicroMsg.EmojiCaptureCallbackDispatcher";
    hdu = new HashMap();
    AppMethodBeat.o(105771);
  }
  
  public static void a(long paramLong, a parama)
  {
    AppMethodBeat.i(105768);
    p.h(parama, "callback");
    com.tencent.mm.ac.d.h((kotlin.g.a.a)new b(paramLong, parama));
    AppMethodBeat.o(105768);
  }
  
  public static void b(long paramLong, a parama)
  {
    AppMethodBeat.i(105769);
    p.h(parama, "callback");
    com.tencent.mm.ac.d.h((kotlin.g.a.a)new c(paramLong, parama));
    AppMethodBeat.o(105769);
  }
  
  public static void b(long paramLong, boolean paramBoolean, final String paramString)
  {
    AppMethodBeat.i(105770);
    Log.i(TAG, "dispatch: " + paramLong + ", " + paramBoolean + ", " + paramString);
    com.tencent.mm.ac.d.h((kotlin.g.a.a)new a(paramLong, paramBoolean, paramString));
    Object localObject = g.aAe().azG();
    p.g(localObject, "MMKernel.process().current()");
    if (((h)localObject).aBb())
    {
      localObject = new Intent("com.tencent.mm.Emoji_Capture_Upload");
      ((Intent)localObject).putExtra("upload_time_enter", paramLong);
      ((Intent)localObject).putExtra("upload_success", paramBoolean);
      ((Intent)localObject).putExtra("upload_md5", paramString);
      MMApplicationContext.getContext().sendBroadcast((Intent)localObject);
    }
    AppMethodBeat.o(105770);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<x>
  {
    a(long paramLong, boolean paramBoolean, String paramString)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(long paramLong, a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.d.b
 * JD-Core Version:    0.7.0.1
 */