package com.tencent.mm.plugin.emojicapture.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.ContextThemeWrapper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.k.i;
import com.tencent.mm.modelcontrol.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;

public final class b
{
  public static void A(Context paramContext, String paramString1, String paramString2)
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
  
  public static void b(Context paramContext, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(104406);
    long l1 = System.currentTimeMillis();
    int i;
    boolean bool;
    int j;
    if (!Util.isNullOrNil(paramString1))
    {
      i = 1;
      bool = ((a)com.tencent.mm.kernel.h.az(a.class)).isStickerEnable();
      j = ((a)com.tencent.mm.kernel.h.az(a.class)).stickerRecommendCount();
      if ((paramInt != 1) && (paramInt != 6)) {
        break label352;
      }
      com.tencent.mm.plugin.report.service.h.OAn.b(15982, new Object[] { Integer.valueOf(2), Long.valueOf(l1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(paramInt), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(j) });
    }
    for (;;)
    {
      try
      {
        final Intent localIntent = new Intent(paramContext, Class.forName("com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureUI"));
        localIntent.putExtra("key_video_params", e.bIg().bIh());
        localIntent.putExtra("key_enter_time", l1);
        localIntent.putExtra("enter_scene", paramInt);
        localIntent.putExtra("key_capture_max_duration", i.aRC().getInt("EmoticonCameraCaptureMaxDuration", 5));
        if (i != 0) {
          localIntent.putExtra("key_imitated_md5", paramString1);
        }
        localIntent.putExtra("sticker_enable", bool);
        if (paramString2 != null) {
          localIntent.putExtra("lens_id", paramString2);
        }
        localIntent.putExtra("username", paramString3);
        ((a)com.tencent.mm.kernel.h.az(a.class)).preCheck(paramContext, paramInt, new a.a()
        {
          public final void onCheckResult(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(104401);
            if (paramAnonymousBoolean)
            {
              if ((b.this instanceof Activity))
              {
                localObject1 = (Activity)b.this;
                localObject2 = localIntent;
                com.tencent.mm.hellhoundlib.a.a.a(localObject1, c.a(this.val$requestCode, new com.tencent.mm.hellhoundlib.b.a()).cG(localObject2).aYi(), "com/tencent/mm/plugin/emojicapture/api/TakeEmojiCapture$1", "onCheckResult", "(Z)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
                AppMethodBeat.o(104401);
                return;
              }
              if ((b.this instanceof ContextThemeWrapper))
              {
                localObject1 = ((ContextThemeWrapper)b.this).getBaseContext();
                if ((localObject1 instanceof Activity))
                {
                  localObject1 = (Activity)localObject1;
                  localObject2 = localIntent;
                  com.tencent.mm.hellhoundlib.a.a.a(localObject1, c.a(this.val$requestCode, new com.tencent.mm.hellhoundlib.b.a()).cG(localObject2).aYi(), "com/tencent/mm/plugin/emojicapture/api/TakeEmojiCapture$1", "onCheckResult", "(Z)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
                  AppMethodBeat.o(104401);
                  return;
                }
                localObject1 = b.this;
                localObject2 = localIntent;
                localObject2 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
                com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/emojicapture/api/TakeEmojiCapture$1", "onCheckResult", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0));
                com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/emojicapture/api/TakeEmojiCapture$1", "onCheckResult", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(104401);
                return;
              }
              Object localObject1 = b.this;
              Object localObject2 = localIntent;
              localObject2 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
              com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/emojicapture/api/TakeEmojiCapture$1", "onCheckResult", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0));
              com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/emojicapture/api/TakeEmojiCapture$1", "onCheckResult", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
        Log.printErrStackTrace("MicroMsg.TakeEmojiCapture", paramContext, "takeEmojiCapture failed", new Object[0]);
        AppMethodBeat.o(104406);
      }
      i = 0;
      break;
      if (paramInt == 2)
      {
        l2 = System.currentTimeMillis();
        l3 = com.tencent.mm.kernel.h.baE().ban().a(at.a.acWY, l2);
        com.tencent.mm.plugin.report.service.h.OAn.b(15982, new Object[] { Integer.valueOf(1), Long.valueOf(l1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(paramInt), "", Integer.valueOf(0), Long.valueOf(l2 - l3), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(j) });
      }
    }
  }
  
  public static void d(Context paramContext, int paramInt, String paramString)
  {
    AppMethodBeat.i(104403);
    b(paramContext, null, paramInt, null, paramString);
    AppMethodBeat.o(104403);
  }
  
  public static void gb(Context paramContext)
  {
    AppMethodBeat.i(269281);
    try
    {
      Object localObject = Class.forName("com.tencent.mm.plugin.emojicapture.ui.StickerPreviewUI");
      localObject = new Intent(paramContext, (Class)localObject);
      ((Intent)localObject).putExtra("sticker_url", null);
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/emojicapture/api/TakeEmojiCapture", "startStickerPreview", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/emojicapture/api/TakeEmojiCapture", "startStickerPreview", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(269281);
      return;
    }
    catch (ClassNotFoundException paramContext)
    {
      Log.printErrStackTrace("MicroMsg.TakeEmojiCapture", paramContext, "start sticker preview failed", new Object[0]);
      AppMethodBeat.o(269281);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.api.b
 * JD-Core Version:    0.7.0.1
 */