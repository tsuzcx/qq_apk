package com.tencent.mm.plugin.auto.service;

import android.app.RemoteInput;
import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipDescription;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.auto.model.a;
import com.tencent.mm.plugin.auto.model.b;
import com.tencent.mm.plugin.messenger.a.d;
import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;

public class MMAutoMessageReplyReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(21162);
    String str = IntentUtil.getStringExtra(paramIntent, "key_username");
    if (str == null)
    {
      AppMethodBeat.o(21162);
      return;
    }
    if (Build.VERSION.SDK_INT >= 20)
    {
      paramContext = RemoteInput.getResultsFromIntent(paramIntent);
      if (paramContext == null) {
        break label171;
      }
    }
    label166:
    label171:
    for (paramContext = paramContext.getCharSequence("key_voice_reply_text");; paramContext = null)
    {
      if (paramContext != null) {
        break label176;
      }
      Log.i("MicroMsg.auto.MMAutoMessageReplyReceiver", "username %s reply null", new Object[] { str });
      AppMethodBeat.o(21162);
      return;
      if (Build.VERSION.SDK_INT >= 16)
      {
        paramContext = paramIntent.getClipData();
        if (paramContext == null) {
          paramContext = null;
        }
        for (;;)
        {
          if (paramContext == null) {
            break label166;
          }
          paramContext = (Bundle)paramContext.getExtras().getParcelable("android.remoteinput.resultsData");
          break;
          paramIntent = paramContext.getDescription();
          if (!paramIntent.hasMimeType("text/vnd.android.intent")) {
            paramContext = null;
          } else if (!paramIntent.getLabel().toString().contentEquals("android.remoteinput.results")) {
            paramContext = null;
          } else {
            paramContext = paramContext.getItemAt(0).getIntent();
          }
        }
      }
      paramContext = null;
      break;
    }
    label176:
    if (!a.cUy())
    {
      AppMethodBeat.o(21162);
      return;
    }
    if (!a.cUz())
    {
      Log.i("MicroMsg.auto.MMAutoMessageReplyReceiver", "not open car mode");
      AppMethodBeat.o(21162);
      return;
    }
    if (!a.cUA())
    {
      Log.i("MicroMsg.auto.MMAutoMessageReplyReceiver", "not install auto app");
      AppMethodBeat.o(21162);
      return;
    }
    paramIntent = b.uVJ;
    b.jX(1L);
    Log.i("MicroMsg.auto.MMAutoMessageReplyReceiver", "username %s reply %s", new Object[] { str, paramContext.toString() });
    g.gaI().ap(str, paramContext.toString(), ab.IX(str));
    AppMethodBeat.o(21162);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.auto.service.MMAutoMessageReplyReceiver
 * JD-Core Version:    0.7.0.1
 */