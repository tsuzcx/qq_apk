package com.tencent.mm.plugin.brandservice;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.threadpool.i;

public final class b
  implements n
{
  public static m pFn;
  public static l pFo;
  
  public static void G(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(5533);
    if (paramObject == null) {}
    for (String str = "null";; str = paramObject.toString())
    {
      Log.i("MicroMsg.BrandService.BrandServiceApplication", "set config, key[%d], value[%s]", new Object[] { Integer.valueOf(paramInt), str });
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baE().ban().B(paramInt, paramObject);
      AppMethodBeat.o(5533);
      return;
    }
  }
  
  public static void a(String paramString, Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(5534);
    if (paramLong > 0L)
    {
      com.tencent.threadpool.h.ahAA.a(paramRunnable, paramLong, paramString);
      AppMethodBeat.o(5534);
      return;
    }
    com.tencent.threadpool.h.ahAA.g(paramRunnable, paramString);
    AppMethodBeat.o(5534);
  }
  
  public static void au(Runnable paramRunnable)
  {
    AppMethodBeat.i(301518);
    a("BrandServiceWorkerThread", paramRunnable, 0L);
    AppMethodBeat.o(301518);
  }
  
  public static void av(Runnable paramRunnable)
  {
    AppMethodBeat.i(301521);
    a("BrandServiceWorkerThread", paramRunnable, 500L);
    AppMethodBeat.o(301521);
  }
  
  public static void b(String paramString, Context paramContext)
  {
    AppMethodBeat.i(301500);
    Log.i("MicroMsg.BrandService.BrandServiceApplication", "startChattingUI");
    paramString = new Intent().putExtra("Chat_User", paramString);
    paramString.putExtra("finish_direct", true);
    paramString.putExtra("chat_from_scene", 2);
    paramString.putExtra("specific_chat_from_scene", 4);
    paramString.putExtra("img_gallery_enter_from_chatting_ui", true);
    pFn.d(paramString, paramContext);
    AppMethodBeat.o(301500);
  }
  
  public static void d(Intent paramIntent, Context paramContext)
  {
    AppMethodBeat.i(301504);
    Log.i("MicroMsg.BrandService.BrandServiceApplication", "startChattingUI");
    pFn.d(paramIntent, paramContext);
    AppMethodBeat.o(301504);
  }
  
  public static Object dbv()
  {
    AppMethodBeat.i(301510);
    com.tencent.mm.kernel.h.baF();
    Object localObject = com.tencent.mm.kernel.h.baE().ban().d(196610, null);
    if (localObject == null) {}
    for (String str = "null";; str = localObject.toString())
    {
      Log.i("MicroMsg.BrandService.BrandServiceApplication", "get config, key[%d], value[%s]", new Object[] { Integer.valueOf(196610), str });
      AppMethodBeat.o(301510);
      return localObject;
    }
  }
  
  public final void a(l paraml)
  {
    pFo = paraml;
  }
  
  public final void a(m paramm)
  {
    pFn = paramm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b
 * JD-Core Version:    0.7.0.1
 */