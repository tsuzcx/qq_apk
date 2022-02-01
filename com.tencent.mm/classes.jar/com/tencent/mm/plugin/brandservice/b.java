package com.tencent.mm.plugin.brandservice;

import android.content.Context;
import android.content.Intent;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;

public final class b
  implements n
{
  public static m mIG;
  public static l mIH;
  
  public static void a(String paramString, Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(5534);
    if (paramLong > 0L)
    {
      com.tencent.e.h.ZvG.a(paramRunnable, paramLong, paramString);
      AppMethodBeat.o(5534);
      return;
    }
    com.tencent.e.h.ZvG.d(paramRunnable, paramString);
    AppMethodBeat.o(5534);
  }
  
  public static void am(Runnable paramRunnable)
  {
    AppMethodBeat.i(265409);
    a("BrandServiceWorkerThread", paramRunnable, 0L);
    AppMethodBeat.o(265409);
  }
  
  public static void an(Runnable paramRunnable)
  {
    AppMethodBeat.i(265410);
    a("BrandServiceWorkerThread", paramRunnable, 500L);
    AppMethodBeat.o(265410);
  }
  
  public static void b(String paramString, Context paramContext)
  {
    AppMethodBeat.i(265406);
    Log.i("MicroMsg.BrandService.BrandServiceApplication", "startChattingUI");
    paramString = new Intent().putExtra("Chat_User", paramString);
    paramString.putExtra("finish_direct", true);
    paramString.putExtra("chat_from_scene", 2);
    paramString.putExtra("specific_chat_from_scene", 4);
    paramString.putExtra("img_gallery_enter_from_chatting_ui", true);
    mIG.d(paramString, paramContext);
    AppMethodBeat.o(265406);
  }
  
  public static Object cyA()
  {
    AppMethodBeat.i(265408);
    com.tencent.mm.kernel.h.aHH();
    Object localObject = com.tencent.mm.kernel.h.aHG().aHp().b(196610, null);
    if (localObject == null) {}
    for (String str = "null";; str = localObject.toString())
    {
      Log.i("MicroMsg.BrandService.BrandServiceApplication", "get config, key[%d], value[%s]", new Object[] { Integer.valueOf(196610), str });
      AppMethodBeat.o(265408);
      return localObject;
    }
  }
  
  public static void d(Intent paramIntent, Context paramContext)
  {
    AppMethodBeat.i(265407);
    Log.i("MicroMsg.BrandService.BrandServiceApplication", "startChattingUI");
    mIG.d(paramIntent, paramContext);
    AppMethodBeat.o(265407);
  }
  
  public static void n(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(5533);
    if (paramObject == null) {}
    for (String str = "null";; str = paramObject.toString())
    {
      Log.i("MicroMsg.BrandService.BrandServiceApplication", "set config, key[%d], value[%s]", new Object[] { Integer.valueOf(paramInt), str });
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHG().aHp().i(paramInt, paramObject);
      AppMethodBeat.o(5533);
      return;
    }
  }
  
  public final void a(l paraml)
  {
    mIH = paraml;
  }
  
  public final void a(m paramm)
  {
    mIG = paramm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b
 * JD-Core Version:    0.7.0.1
 */