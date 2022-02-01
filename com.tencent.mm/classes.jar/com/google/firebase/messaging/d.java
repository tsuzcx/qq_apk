package com.google.firebase.messaging;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d
{
  static void a(String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(116802);
    Bundle localBundle = new Bundle();
    String str = paramIntent.getStringExtra("google.c.a.c_id");
    if (str != null) {
      localBundle.putString("_nmid", str);
    }
    str = paramIntent.getStringExtra("google.c.a.c_l");
    if (str != null) {
      localBundle.putString("_nmn", str);
    }
    str = paramIntent.getStringExtra("google.c.a.m_l");
    if (!TextUtils.isEmpty(str)) {
      localBundle.putString("label", str);
    }
    str = paramIntent.getStringExtra("from");
    if ((str != null) && (str.startsWith("/topics/"))) {}
    for (;;)
    {
      if (str != null) {
        localBundle.putString("_nt", str);
      }
      try
      {
        localBundle.putInt("_nmt", Integer.parseInt(paramIntent.getStringExtra("google.c.a.ts")));
        label116:
        if (paramIntent.hasExtra("google.c.a.udt")) {}
        try
        {
          localBundle.putInt("_ndt", Integer.parseInt(paramIntent.getStringExtra("google.c.a.udt")));
          label140:
          if (Log.isLoggable("FirebaseMessaging", 3))
          {
            paramIntent = String.valueOf(localBundle);
            new StringBuilder(String.valueOf(paramString).length() + 22 + String.valueOf(paramIntent).length()).append("Sending event=").append(paramString).append(" params=").append(paramIntent);
          }
          paramIntent = (com.google.firebase.analytics.connector.a)com.google.firebase.a.wn().w(com.google.firebase.analytics.connector.a.class);
          if (paramIntent != null)
          {
            paramIntent.logEvent("fcm", paramString, localBundle);
            AppMethodBeat.o(116802);
            return;
            str = null;
            continue;
          }
          AppMethodBeat.o(116802);
          return;
        }
        catch (NumberFormatException paramIntent)
        {
          break label140;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        break label116;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.firebase.messaging.d
 * JD-Core Version:    0.7.0.1
 */