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
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.a.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public class VoiceActionService
  extends SearchActionVerificationClientService
{
  public final boolean a(Intent paramIntent, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      y.i("MicroMsg.VoiceActionService", "Action is not verified");
      return false;
    }
    Object localObject = paramIntent.getStringExtra("com.google.android.voicesearch.extra.RECIPIENT_CONTACT_CHAT_ID");
    String str1 = paramIntent.getStringExtra("android.intent.extra.TEXT");
    String str2 = com.tencent.mm.a.g.o(com.tencent.mm.pluginsdk.a.qa((String)localObject).getBytes());
    str2 = com.tencent.mm.plugin.account.b.getAddrUploadStg().pI(str2).getUsername();
    com.tencent.mm.plugin.messenger.a.g.bhI().D(str2, str1, s.hW(str2));
    try
    {
      str1 = paramIntent.getStringExtra("com.google.android.voicesearch.extra.RECIPIENT_CONTACT_URI");
      paramIntent = str1.split("/");
      if ((paramIntent == null) || (paramIntent.length <= 0)) {
        break label335;
      }
      paramIntent = paramIntent[(paramIntent.length - 1)];
      if (bk.bl(paramIntent)) {
        y.e("MicroMsg.VoiceActionService", "extract contact Id error, %s %s", new Object[] { str1, localObject });
      } else if (!com.tencent.mm.pluginsdk.permission.a.j(this, "android.permission.READ_CONTACTS")) {
        y.e("MicroMsg.VoiceActionService", "no contacts permission");
      }
    }
    catch (Exception paramIntent)
    {
      y.printErrStackTrace("MicroMsg.VoiceActionService", paramIntent, "updateContactMarked error", new Object[0]);
    }
    paramIntent = getContentResolver().query(ContactsContract.Data.CONTENT_URI, new String[] { "_id" }, "contact_id=? AND data1=? AND account_type=? AND mimetype=?", new String[] { paramIntent, localObject, "com.tencent.mm.account", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voiceaction" }, null);
    if ((paramIntent != null) && (paramIntent.getCount() > 0))
    {
      paramIntent.moveToNext();
      long l = paramIntent.getLong(0);
      localObject = ContactsContract.DataUsageFeedback.FEEDBACK_URI.buildUpon().appendPath(String.valueOf(l)).appendQueryParameter("type", "short_text").build();
      if (getContentResolver().update((Uri)localObject, new ContentValues(), null, null) <= 0) {
        break label341;
      }
    }
    label335:
    label341:
    for (paramBoolean = true;; paramBoolean = false)
    {
      y.i("MicroMsg.VoiceActionService", "updateContactMarked: %b", new Object[] { Boolean.valueOf(paramBoolean) });
      while (paramIntent != null)
      {
        paramIntent.close();
        break;
        y.i("MicroMsg.VoiceActionService", "updateContactMarked: false");
      }
      return true;
      paramIntent = "";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.VoiceActionService
 * JD-Core Version:    0.7.0.1
 */