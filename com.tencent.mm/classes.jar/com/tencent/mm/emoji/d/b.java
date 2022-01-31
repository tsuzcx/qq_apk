package com.tencent.mm.emoji.d;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.HashMap;
import java.util.HashSet;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/emoji/upload/EmojiCaptureCallbackDispatcher;", "", "()V", "TAG", "", "callbackMap", "Ljava/util/HashMap;", "", "Ljava/util/HashSet;", "Lcom/tencent/mm/emoji/upload/EmojiCaptureCallback;", "Lkotlin/collections/HashSet;", "Lkotlin/collections/HashMap;", "broadcastResult", "", "timeEnter", "success", "", "md5", "dispatch", "registerCallback", "callback", "unregisterCallback", "plugin-emojisdk_release"})
public final class b
{
  private static final String TAG = "MicroMsg.EmojiCaptureCallbackDispatcher";
  private static final HashMap<Long, HashSet<a>> eyb;
  public static final b eyc;
  
  static
  {
    AppMethodBeat.i(63294);
    eyc = new b();
    TAG = "MicroMsg.EmojiCaptureCallbackDispatcher";
    eyb = new HashMap();
    AppMethodBeat.o(63294);
  }
  
  public static void a(long paramLong, a parama)
  {
    AppMethodBeat.i(63291);
    j.q(parama, "callback");
    com.tencent.mm.ab.b.b((a.f.a.a)new b.b(paramLong, parama));
    AppMethodBeat.o(63291);
  }
  
  public static void b(long paramLong, a parama)
  {
    AppMethodBeat.i(63292);
    j.q(parama, "callback");
    com.tencent.mm.ab.b.b((a.f.a.a)new b.c(paramLong, parama));
    AppMethodBeat.o(63292);
  }
  
  public static void b(long paramLong, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(63293);
    ab.i(TAG, "dispatch: " + paramLong + ", " + paramBoolean + ", " + paramString);
    com.tencent.mm.ab.b.b((a.f.a.a)new b.a(paramLong, paramBoolean, paramString));
    Object localObject = g.RI().Rj();
    j.p(localObject, "MMKernel.process().current()");
    if (((h)localObject).SD())
    {
      localObject = new Intent("com.tencent.mm.Emoji_Capture_Upload");
      ((Intent)localObject).putExtra("upload_time_enter", paramLong);
      ((Intent)localObject).putExtra("upload_success", paramBoolean);
      ((Intent)localObject).putExtra("upload_md5", paramString);
      ah.getContext().sendBroadcast((Intent)localObject);
    }
    AppMethodBeat.o(63293);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.emoji.d.b
 * JD-Core Version:    0.7.0.1
 */