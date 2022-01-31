package com.tencent.mm.plugin.emojicapture.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.m.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class b
{
  public static void ae(Context paramContext, String paramString)
  {
    long l = System.currentTimeMillis();
    boolean bool;
    if (!bk.bl(paramString))
    {
      bool = true;
      if (!bool) {
        break label181;
      }
      h.nFQ.f(15982, new Object[] { Integer.valueOf(2), Long.valueOf(l), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
    }
    for (;;)
    {
      try
      {
        Intent localIntent = new Intent(paramContext, Class.forName("com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureUI"));
        localIntent.putExtra("key_video_params", com.tencent.mm.modelcontrol.d.Nl().Nm());
        localIntent.putExtra("key_video_path", com.tencent.mm.plugin.sight.base.d.bAU());
        localIntent.putExtra("key_enter_time", l);
        localIntent.putExtra("key_capture_max_duration", com.tencent.mm.m.g.AA().getInt("EmoticonCameraCaptureMaxDuration", 5));
        if (bool) {
          localIntent.putExtra("key_imitated_md5", paramString);
        }
        if (((a)com.tencent.mm.kernel.g.t(a.class)).preCheck(paramContext, localIntent, bool)) {
          paramContext.startActivity(localIntent);
        }
        return;
      }
      catch (ClassNotFoundException paramContext)
      {
        label181:
        y.printErrStackTrace("MicroMsg.TakeEmojiCapture", paramContext, "takeEmojiCapture failed", new Object[0]);
      }
      bool = false;
      break;
      h.nFQ.f(15982, new Object[] { Integer.valueOf(1), Long.valueOf(l), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.a.b
 * JD-Core Version:    0.7.0.1
 */