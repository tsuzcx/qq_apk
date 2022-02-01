package com.tencent.mm.compatible.i;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.a.a.a;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
{
  public static boolean x(Activity paramActivity)
  {
    AppMethodBeat.i(155922);
    Intent localIntent = new Intent("android.media.action.VIDEO_CAPTURE");
    localIntent.putExtra("android.intent.extra.videoQuality", 0);
    com.tencent.mm.compatible.a.a.a(8, new a.a()
    {
      public final void run()
      {
        AppMethodBeat.i(155921);
        b.this.putExtra("android.intent.extra.durationLimit", 30);
        b.this.putExtra("android.intent.extra.sizeLimit", 10485760);
        AppMethodBeat.o(155921);
      }
    });
    try
    {
      com.tencent.mm.hellhoundlib.a.a.a(paramActivity, c.a(4372, new com.tencent.mm.hellhoundlib.b.a()).cG(localIntent).aYi(), "com/tencent/mm/compatible/video/TakeVideoUtil", "takeVideoFromSys", "(Landroid/app/Activity;I)Z", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
      AppMethodBeat.o(155922);
      return true;
    }
    catch (ActivityNotFoundException paramActivity)
    {
      Log.printErrStackTrace("MicroMsg.TakeVideoUtil", paramActivity, "", new Object[0]);
      AppMethodBeat.o(155922);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.compatible.i.b
 * JD-Core Version:    0.7.0.1
 */