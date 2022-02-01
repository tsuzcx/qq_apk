package com.tencent.mm.plugin.emojicapture.api;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

public final class b
{
  public static void ax(Context paramContext, String paramString)
  {
    AppMethodBeat.i(104405);
    b(paramContext, null, 0, paramString, "");
    AppMethodBeat.o(104405);
  }
  
  public static void b(Context paramContext, int paramInt, String paramString)
  {
    AppMethodBeat.i(104403);
    b(paramContext, null, paramInt, null, paramString);
    AppMethodBeat.o(104403);
  }
  
  private static void b(Context paramContext, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(104406);
    long l1 = System.currentTimeMillis();
    int i;
    boolean bool;
    int j;
    if (!Util.isNullOrNil(paramString1))
    {
      i = 1;
      bool = ((a)g.ah(a.class)).isStickerEnable();
      j = ((a)g.ah(a.class)).stickerRecommendCount();
      if ((paramInt != 1) && (paramInt != 6)) {
        break label352;
      }
      com.tencent.mm.plugin.report.service.h.CyF.a(15982, new Object[] { Integer.valueOf(2), Long.valueOf(l1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(paramInt), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(j) });
    }
    for (;;)
    {
      try
      {
        Intent localIntent = new Intent(paramContext, Class.forName("com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureUI"));
        localIntent.putExtra("key_video_params", com.tencent.mm.modelcontrol.e.baZ().bba());
        localIntent.putExtra("key_enter_time", l1);
        localIntent.putExtra("enter_scene", paramInt);
        localIntent.putExtra("key_capture_max_duration", com.tencent.mm.n.h.aqJ().getInt("EmoticonCameraCaptureMaxDuration", 5));
        if (i != 0) {
          localIntent.putExtra("key_imitated_md5", paramString1);
        }
        localIntent.putExtra("sticker_enable", bool);
        if (paramString2 != null) {
          localIntent.putExtra("lens_id", paramString2);
        }
        localIntent.putExtra("username", paramString3);
        ((a)g.ah(a.class)).preCheck(paramContext, paramInt, new b.1(paramContext, localIntent));
        AppMethodBeat.o(104406);
        return;
      }
      catch (ClassNotFoundException paramContext)
      {
        label352:
        long l2;
        long l3;
        Log.printErrStackTrace("MicroMsg.TakeEmojiCapture", paramContext, "takeEmojiCapture failed", new Object[0]);
        AppMethodBeat.o(104406);
      }
      i = 0;
      break;
      if (paramInt == 2)
      {
        l2 = System.currentTimeMillis();
        l3 = g.aAh().azQ().a(ar.a.OgZ, l2);
        com.tencent.mm.plugin.report.service.h.CyF.a(15982, new Object[] { Integer.valueOf(1), Long.valueOf(l1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(paramInt), "", Integer.valueOf(0), Long.valueOf(l2 - l3), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(j) });
      }
    }
  }
  
  public static void fa(Context paramContext)
  {
    AppMethodBeat.i(104407);
    try
    {
      Object localObject = Class.forName("com.tencent.mm.plugin.emojicapture.ui.StickerPreviewUI");
      localObject = new Intent(paramContext, (Class)localObject);
      ((Intent)localObject).putExtra("sticker_url", null);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/emojicapture/api/TakeEmojiCapture", "startStickerPreview", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/emojicapture/api/TakeEmojiCapture", "startStickerPreview", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(104407);
      return;
    }
    catch (ClassNotFoundException paramContext)
    {
      Log.printErrStackTrace("MicroMsg.TakeEmojiCapture", paramContext, "start sticker preview failed", new Object[0]);
      AppMethodBeat.o(104407);
    }
  }
  
  public static void w(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(104404);
    if (Util.isNullOrNil(paramString1)) {}
    for (int i = 2;; i = 1)
    {
      b(paramContext, paramString1, i, null, paramString2);
      AppMethodBeat.o(104404);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.api.b
 * JD-Core Version:    0.7.0.1
 */