package com.tencent.mm.opensdk.channel.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;

public final class a
{
  public static boolean a(Context paramContext, a.a parama)
  {
    AppMethodBeat.i(128139);
    if (paramContext == null)
    {
      Log.e("MicroMsg.SDK.MMessage", "send fail, invalid argument");
      AppMethodBeat.o(128139);
      return false;
    }
    if (d.b(parama.action))
    {
      Log.e("MicroMsg.SDK.MMessage", "send fail, action is null");
      AppMethodBeat.o(128139);
      return false;
    }
    String str1 = null;
    if (!d.b(parama.a)) {
      str1 = parama.a + ".permission.MM_MESSAGE";
    }
    Intent localIntent = new Intent(parama.action);
    if (parama.bundle != null) {
      localIntent.putExtras(parama.bundle);
    }
    String str2 = paramContext.getPackageName();
    localIntent.putExtra("_mmessage_sdkVersion", 620954624);
    localIntent.putExtra("_mmessage_appPackage", str2);
    localIntent.putExtra("_mmessage_content", parama.content);
    localIntent.putExtra("_mmessage_support_content_type", parama.b);
    localIntent.putExtra("_mmessage_checksum", b.a(parama.content, 620954624, str2));
    paramContext.sendBroadcast(localIntent, str1);
    Log.d("MicroMsg.SDK.MMessage", "send mm message, intent=" + localIntent + ", perm=" + str1);
    AppMethodBeat.o(128139);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.opensdk.channel.a.a
 * JD-Core Version:    0.7.0.1
 */