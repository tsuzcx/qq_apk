package com.tencent.mm.emoji.c;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import d.g.b.k;
import d.y;
import java.util.HashMap;
import java.util.HashSet;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/upload/EmojiCaptureCallbackDispatcher;", "", "()V", "TAG", "", "callbackMap", "Ljava/util/HashMap;", "", "Ljava/util/HashSet;", "Lcom/tencent/mm/emoji/upload/EmojiCaptureCallback;", "Lkotlin/collections/HashSet;", "Lkotlin/collections/HashMap;", "broadcastResult", "", "timeEnter", "success", "", "md5", "dispatch", "registerCallback", "callback", "unregisterCallback", "plugin-emojisdk_release"})
public final class b
{
  private static final String TAG = "MicroMsg.EmojiCaptureCallbackDispatcher";
  private static final HashMap<Long, HashSet<a>> fWm;
  public static final b fWn;
  
  static
  {
    AppMethodBeat.i(105771);
    fWn = new b();
    TAG = "MicroMsg.EmojiCaptureCallbackDispatcher";
    fWm = new HashMap();
    AppMethodBeat.o(105771);
  }
  
  public static void a(long paramLong, a parama)
  {
    AppMethodBeat.i(105768);
    k.h(parama, "callback");
    c.g((d.g.a.a)new b(paramLong, parama));
    AppMethodBeat.o(105768);
  }
  
  public static void b(long paramLong, a parama)
  {
    AppMethodBeat.i(105769);
    k.h(parama, "callback");
    c.g((d.g.a.a)new c(paramLong, parama));
    AppMethodBeat.o(105769);
  }
  
  public static void b(long paramLong, boolean paramBoolean, final String paramString)
  {
    AppMethodBeat.i(105770);
    ac.i(TAG, "dispatch: " + paramLong + ", " + paramBoolean + ", " + paramString);
    c.g((d.g.a.a)new a(paramLong, paramBoolean, paramString));
    Object localObject = g.agO().agp();
    k.g(localObject, "MMKernel.process().current()");
    if (((h)localObject).ahL())
    {
      localObject = new Intent("com.tencent.mm.Emoji_Capture_Upload");
      ((Intent)localObject).putExtra("upload_time_enter", paramLong);
      ((Intent)localObject).putExtra("upload_success", paramBoolean);
      ((Intent)localObject).putExtra("upload_md5", paramString);
      ai.getContext().sendBroadcast((Intent)localObject);
    }
    AppMethodBeat.o(105770);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    a(long paramLong, boolean paramBoolean, String paramString)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    b(long paramLong, a parama)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    c(long paramLong, a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.c.b
 * JD-Core Version:    0.7.0.1
 */