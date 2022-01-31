package com.tencent.mm.plugin.account.model;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.DataUsageFeedback;
import com.google.android.search.verification.client.SearchActionVerificationClientService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.a.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class VoiceActionService
  extends SearchActionVerificationClientService
{
  public final boolean a(Intent paramIntent, boolean paramBoolean)
  {
    AppMethodBeat.i(124711);
    if (!paramBoolean)
    {
      ab.i("MicroMsg.VoiceActionService", "Action is not verified");
      AppMethodBeat.o(124711);
      return false;
    }
    Object localObject = paramIntent.getStringExtra("com.google.android.voicesearch.extra.RECIPIENT_CONTACT_CHAT_ID");
    String str1 = paramIntent.getStringExtra("android.intent.extra.TEXT");
    String str2 = com.tencent.mm.a.g.w(com.tencent.mm.pluginsdk.a.xw((String)localObject).getBytes());
    str2 = com.tencent.mm.plugin.account.a.getAddrUploadStg().xa(str2).getUsername();
    com.tencent.mm.plugin.messenger.a.g.bPJ().K(str2, str1, t.oF(str2));
    for (;;)
    {
      try
      {
        str1 = paramIntent.getStringExtra("com.google.android.voicesearch.extra.RECIPIENT_CONTACT_URI");
        paramIntent = str1.split("/");
        if ((paramIntent == null) || (paramIntent.length <= 0)) {
          continue;
        }
        paramIntent = paramIntent[(paramIntent.length - 1)];
        if (!bo.isNullOrNil(paramIntent)) {
          continue;
        }
        ab.e("MicroMsg.VoiceActionService", "extract contact Id error, %s %s", new Object[] { str1, localObject });
      }
      catch (Exception paramIntent)
      {
        ab.printErrStackTrace("MicroMsg.VoiceActionService", paramIntent, "updateContactMarked error", new Object[0]);
        continue;
        paramIntent = getContentResolver().query(ContactsContract.Data.CONTENT_URI, new String[] { "_id" }, "contact_id=? AND data1=? AND account_type=? AND mimetype=?", new String[] { paramIntent, localObject, "com.tencent.mm.account", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voiceaction" }, null);
        if (paramIntent == null) {
          break;
        }
      }
      AppMethodBeat.o(124711);
      return true;
      paramIntent = "";
      continue;
      if (!com.tencent.mm.pluginsdk.permission.b.o(this, "android.permission.READ_CONTACTS"))
      {
        ab.e("MicroMsg.VoiceActionService", "no contacts permission");
      }
      else if (paramIntent.getCount() > 0)
      {
        paramIntent.moveToNext();
        long l = paramIntent.getLong(0);
        localObject = ContactsContract.DataUsageFeedback.FEEDBACK_URI.buildUpon().appendPath(String.valueOf(l)).appendQueryParameter("type", "short_text").build();
        if (getContentResolver().update((Uri)localObject, new ContentValues(), null, null) <= 0) {
          break label353;
        }
      }
    }
    label351:
    label353:
    for (paramBoolean = true;; paramBoolean = false)
    {
      ab.i("MicroMsg.VoiceActionService", "updateContactMarked: %b", new Object[] { Boolean.valueOf(paramBoolean) });
      for (;;)
      {
        if (paramIntent == null) {
          break label351;
        }
        paramIntent.close();
        break;
        ab.i("MicroMsg.VoiceActionService", "updateContactMarked: false");
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.VoiceActionService
 * JD-Core Version:    0.7.0.1
 */