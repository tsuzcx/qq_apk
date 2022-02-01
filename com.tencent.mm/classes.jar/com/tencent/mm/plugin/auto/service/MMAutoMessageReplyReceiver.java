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
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.auto.a.a;
import com.tencent.mm.plugin.auto.a.b;
import com.tencent.mm.plugin.messenger.a.d;
import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.z;

public class MMAutoMessageReplyReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(21162);
    String str = z.getStringExtra(paramIntent, "key_username");
    if (str == null)
    {
      AppMethodBeat.o(21162);
      return;
    }
    if (Build.VERSION.SDK_INT >= 20)
    {
      paramContext = RemoteInput.getResultsFromIntent(paramIntent);
      if (paramContext == null) {
        break label166;
      }
    }
    label161:
    label166:
    for (paramContext = paramContext.getCharSequence("key_voice_reply_text");; paramContext = null)
    {
      if (paramContext != null) {
        break label171;
      }
      ae.i("MicroMsg.auto.MMAutoMessageReplyReceiver", "username %s reply null", new Object[] { str });
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
            break label161;
          }
          paramContext = (Bundle)paramContext.getExtras().getParcelable("android.remoteinput.resultsData");
          break;
          paramIntent = paramContext.getDescription();
          if (!paramIntent.hasMimeType("text/vnd.android.intent")) {
            paramContext = null;
          } else if (!paramIntent.getLabel().equals("android.remoteinput.results")) {
            paramContext = null;
          } else {
            paramContext = paramContext.getItemAt(0).getIntent();
          }
        }
      }
      paramContext = null;
      break;
    }
    label171:
    if (!a.bHK())
    {
      AppMethodBeat.o(21162);
      return;
    }
    if (!a.bHL())
    {
      ae.i("MicroMsg.auto.MMAutoMessageReplyReceiver", "not open car mode");
      AppMethodBeat.o(21162);
      return;
    }
    if (!a.bHM())
    {
      ae.i("MicroMsg.auto.MMAutoMessageReplyReceiver", "not install auto app");
      AppMethodBeat.o(21162);
      return;
    }
    paramIntent = b.nxI;
    b.tn(1L);
    ae.i("MicroMsg.auto.MMAutoMessageReplyReceiver", "username %s reply %s", new Object[] { str, paramContext.toString() });
    g.doC().aa(str, paramContext.toString(), x.Bb(str));
    AppMethodBeat.o(21162);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.auto.service.MMAutoMessageReplyReceiver
 * JD-Core Version:    0.7.0.1
 */