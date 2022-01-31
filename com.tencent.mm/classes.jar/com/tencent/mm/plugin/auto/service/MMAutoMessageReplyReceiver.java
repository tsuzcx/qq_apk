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
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.a.d;
import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.sdk.platformtools.y;

public class MMAutoMessageReplyReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = t.j(paramIntent, "key_username");
    if (str == null) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 20)
    {
      paramContext = RemoteInput.getResultsFromIntent(paramIntent);
      if (paramContext == null) {
        break label148;
      }
    }
    label143:
    label148:
    for (paramContext = paramContext.getCharSequence("key_voice_reply_text");; paramContext = null)
    {
      if (paramContext != null) {
        break label153;
      }
      y.i("MicroMsg.auto.MMAutoMessageReplyReceiver", "username %s reply null", new Object[] { str });
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
            break label143;
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
    label153:
    y.i("MicroMsg.auto.MMAutoMessageReplyReceiver", "username %s reply %s", new Object[] { str, paramContext.toString() });
    g.bhI().D(str, paramContext.toString(), s.hW(str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.auto.service.MMAutoMessageReplyReceiver
 * JD-Core Version:    0.7.0.1
 */