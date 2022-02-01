package com.tencent.mm.plugin.emojicapture.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.ContextThemeWrapper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;

public final class b
{
  public static void am(Context paramContext, String paramString)
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
    if (!bt.isNullOrNil(paramString1))
    {
      i = 1;
      bool = ((a)com.tencent.mm.kernel.g.ad(a.class)).isStickerEnable();
      j = ((a)com.tencent.mm.kernel.g.ad(a.class)).stickerRecommendCount();
      if ((paramInt != 1) && (paramInt != 6)) {
        break label352;
      }
      com.tencent.mm.plugin.report.service.g.yhR.f(15982, new Object[] { Integer.valueOf(2), Long.valueOf(l1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(paramInt), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(j) });
    }
    for (;;)
    {
      try
      {
        final Intent localIntent = new Intent(paramContext, Class.forName("com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureUI"));
        localIntent.putExtra("key_video_params", d.aGQ().aGR());
        localIntent.putExtra("key_enter_time", l1);
        localIntent.putExtra("enter_scene", paramInt);
        localIntent.putExtra("key_capture_max_duration", com.tencent.mm.n.g.acA().getInt("EmoticonCameraCaptureMaxDuration", 5));
        if (i != 0) {
          localIntent.putExtra("key_imitated_md5", paramString1);
        }
        localIntent.putExtra("sticker_enable", bool);
        if (paramString2 != null) {
          localIntent.putExtra("lens_id", paramString2);
        }
        localIntent.putExtra("username", paramString3);
        ((a)com.tencent.mm.kernel.g.ad(a.class)).preCheck(paramContext, paramInt, new a.a()
        {
          public final void ge(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(104401);
            if (paramAnonymousBoolean)
            {
              if ((this.val$context instanceof Activity))
              {
                ((Activity)this.val$context).startActivityForResult(localIntent, this.val$requestCode);
                AppMethodBeat.o(104401);
                return;
              }
              if ((this.val$context instanceof ContextThemeWrapper))
              {
                localContext = ((ContextThemeWrapper)this.val$context).getBaseContext();
                if ((localContext instanceof Activity))
                {
                  ((Activity)localContext).startActivityForResult(localIntent, this.val$requestCode);
                  AppMethodBeat.o(104401);
                  return;
                }
                localContext = this.val$context;
                localObject = localIntent;
                localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
                com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/emojicapture/api/TakeEmojiCapture$1", "onCheckResult", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
                com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/plugin/emojicapture/api/TakeEmojiCapture$1", "onCheckResult", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(104401);
                return;
              }
              Context localContext = this.val$context;
              Object localObject = localIntent;
              localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/emojicapture/api/TakeEmojiCapture$1", "onCheckResult", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
              com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/plugin/emojicapture/api/TakeEmojiCapture$1", "onCheckResult", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
            AppMethodBeat.o(104401);
          }
        });
        AppMethodBeat.o(104406);
        return;
      }
      catch (ClassNotFoundException paramContext)
      {
        label352:
        long l2;
        long l3;
        ad.printErrStackTrace("MicroMsg.TakeEmojiCapture", paramContext, "takeEmojiCapture failed", new Object[0]);
        AppMethodBeat.o(104406);
      }
      i = 0;
      break;
      if (paramInt == 2)
      {
        l2 = System.currentTimeMillis();
        l3 = com.tencent.mm.kernel.g.ajC().ajl().a(al.a.IEc, l2);
        com.tencent.mm.plugin.report.service.g.yhR.f(15982, new Object[] { Integer.valueOf(1), Long.valueOf(l1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(paramInt), "", Integer.valueOf(0), Long.valueOf(l2 - l3), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(j) });
      }
    }
  }
  
  public static void eC(Context paramContext)
  {
    AppMethodBeat.i(104407);
    try
    {
      Object localObject = Class.forName("com.tencent.mm.plugin.emojicapture.ui.StickerPreviewUI");
      localObject = new Intent(paramContext, (Class)localObject);
      ((Intent)localObject).putExtra("sticker_url", null);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/emojicapture/api/TakeEmojiCapture", "startStickerPreview", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/emojicapture/api/TakeEmojiCapture", "startStickerPreview", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(104407);
      return;
    }
    catch (ClassNotFoundException paramContext)
    {
      ad.printErrStackTrace("MicroMsg.TakeEmojiCapture", paramContext, "start sticker preview failed", new Object[0]);
      AppMethodBeat.o(104407);
    }
  }
  
  public static void x(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(104404);
    if (bt.isNullOrNil(paramString1)) {}
    for (int i = 2;; i = 1)
    {
      b(paramContext, paramString1, i, null, paramString2);
      AppMethodBeat.o(104404);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.api.b
 * JD-Core Version:    0.7.0.1
 */