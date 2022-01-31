package com.tencent.mm.booter;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.kernel.l;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.sdk.platformtools.y;

public final class b
{
  public static boolean s(Context paramContext, String paramString)
  {
    if (((!paramString.equals("noop")) || ((e.uem) && (e.uel))) && (l.bm(paramContext)))
    {
      y.i("MicroMsg.CoreServiceHelper", "fully exited, no need to start service");
      return false;
    }
    y.d("MicroMsg.CoreServiceHelper", "ensure service running, type=" + paramString);
    Intent localIntent = new Intent(paramContext, CoreService.class);
    localIntent.setFlags(268435456);
    localIntent.putExtra("START_TYPE", paramString);
    paramContext.startService(localIntent);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.booter.b
 * JD-Core Version:    0.7.0.1
 */