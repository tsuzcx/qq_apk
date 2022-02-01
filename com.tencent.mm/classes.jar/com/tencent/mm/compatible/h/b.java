package com.tencent.mm.compatible.h;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.a.a;
import com.tencent.mm.compatible.a.a.a;
import com.tencent.mm.sdk.platformtools.ac;

public final class b
{
  public static boolean w(Activity paramActivity)
  {
    AppMethodBeat.i(155922);
    Intent localIntent = new Intent("android.media.action.VIDEO_CAPTURE");
    localIntent.putExtra("android.intent.extra.videoQuality", 0);
    a.a(8, new a.a()
    {
      public final void run()
      {
        AppMethodBeat.i(155921);
        this.fKq.putExtra("android.intent.extra.durationLimit", 30);
        this.fKq.putExtra("android.intent.extra.sizeLimit", 10485760);
        AppMethodBeat.o(155921);
      }
    });
    try
    {
      paramActivity.startActivityForResult(localIntent, 4372);
      AppMethodBeat.o(155922);
      return true;
    }
    catch (ActivityNotFoundException paramActivity)
    {
      ac.printErrStackTrace("MicroMsg.TakeVideoUtil", paramActivity, "", new Object[0]);
      AppMethodBeat.o(155922);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.h.b
 * JD-Core Version:    0.7.0.1
 */