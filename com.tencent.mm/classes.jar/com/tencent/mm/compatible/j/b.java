package com.tencent.mm.compatible.j;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import com.tencent.mm.compatible.a.a;
import com.tencent.mm.sdk.platformtools.y;

public final class b
{
  public static boolean q(Activity paramActivity)
  {
    Intent localIntent = new Intent("android.media.action.VIDEO_CAPTURE");
    localIntent.putExtra("android.intent.extra.videoQuality", 0);
    a.a(8, new b.1(localIntent));
    try
    {
      paramActivity.startActivityForResult(localIntent, 4372);
      return true;
    }
    catch (ActivityNotFoundException paramActivity)
    {
      y.printErrStackTrace("MicroMsg.TakeVideoUtil", paramActivity, "", new Object[0]);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.compatible.j.b
 * JD-Core Version:    0.7.0.1
 */