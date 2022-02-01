package com.tencent.mm.plugin.account.model;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.RawContacts;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.acn;
import com.tencent.mm.b.g;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.account.ui.r.j;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.bx;

public final class b$b
  implements b.a
{
  private int pWs;
  private String pWt;
  private Uri uri;
  
  public b$b(int paramInt, String paramString, Uri paramUri)
  {
    this.pWs = paramInt;
    this.pWt = paramString;
    this.uri = paramUri;
  }
  
  private int d(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(127813);
    Object localObject = com.tencent.mm.plugin.account.b.getAddrUploadStg().SU(paramString1);
    if (paramContext == null)
    {
      Log.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "null context");
      AppMethodBeat.o(127813);
      return 1;
    }
    if (localObject == null)
    {
      Log.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "this user is not my friend");
      AppMethodBeat.o(127813);
      return 1;
    }
    localObject = ((com.tencent.mm.plugin.account.friend.model.a)localObject).getUsername();
    if (Util.isNullOrNil((String)localObject))
    {
      Log.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "get username failed, phonenum md5 is ".concat(String.valueOf(paramString1)));
      AppMethodBeat.o(127813);
      return 1;
    }
    if (((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().bxr((String)localObject))
    {
      com.tencent.mm.plugin.report.service.h.OAn.b(11157, new Object[] { Integer.valueOf(this.pWs) });
      switch (this.pWs)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(127813);
      return 1;
      paramString1 = new Intent();
      paramString1.putExtra("Chat_User", (String)localObject);
      paramString1.putExtra("finish_direct", true);
      paramString1.addFlags(67108864);
      com.tencent.mm.plugin.account.sdk.a.pFn.d(paramString1, paramContext);
      AppMethodBeat.o(127813);
      return 0;
      paramString1 = new acn();
      paramString1.ifU.hId = 5;
      paramString1.ifU.talker = ((String)localObject);
      paramString1.ifU.context = paramContext;
      paramString1.ifU.ifQ = 3;
      paramString1.publish();
      AppMethodBeat.o(127813);
      return 0;
      paramString1 = new acn();
      paramString1.ifU.hId = 5;
      paramString1.ifU.talker = ((String)localObject);
      paramString1.ifU.context = paramContext;
      paramString1.ifU.ifQ = 2;
      paramString1.publish();
      AppMethodBeat.o(127813);
      return 0;
      paramString1 = new Intent();
      paramString1.putExtra("sns_userName", (String)localObject);
      paramString1.addFlags(67108864);
      paramString1.putExtra("sns_adapter_type", 1);
      c.b(paramContext, "sns", ".ui.SnsUserUI", paramString1);
      AppMethodBeat.o(127813);
      return 0;
      if ((!Util.isNullOrNil(paramString3)) && (!Util.isNullOrNil(paramString2)))
      {
        if (!com.tencent.mm.pluginsdk.permission.b.s(paramContext, "android.permission.READ_CONTACTS"))
        {
          Log.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "no contact permission");
          AppMethodBeat.o(127813);
          return 1;
        }
        Toast.makeText(paramContext, paramContext.getString(r.j.contact_sync_chat_not_friend), 1).show();
        paramContext.getContentResolver().delete(ContactsContract.Data.CONTENT_URI, "_id = ?", new String[] { paramString2 });
        paramContext.getContentResolver().delete(ContactsContract.RawContacts.CONTENT_URI, "contact_id = ? AND account_type = ?", new String[] { paramString3, "com.tencent.mm.account" });
      }
    }
  }
  
  public final int er(Context paramContext)
  {
    AppMethodBeat.i(127812);
    com.tencent.mm.kernel.h.baC();
    if ((!com.tencent.mm.kernel.b.aZM()) || (com.tencent.mm.kernel.b.aZG()))
    {
      Log.d("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "not login, start bind login");
      AppMethodBeat.o(127812);
      return 3;
    }
    if (Util.isNullOrNil((String)com.tencent.mm.kernel.h.baE().ban().d(6, "")))
    {
      Log.d("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "not bind mobile, start bind mobie");
      AppMethodBeat.o(127812);
      return 2;
    }
    if (!com.tencent.mm.pluginsdk.permission.b.s(paramContext, "android.permission.READ_CONTACTS"))
    {
      Log.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "no contacts permission");
      AppMethodBeat.o(127812);
      return 1;
    }
    int i;
    if (this.uri != null)
    {
      Cursor localCursor = paramContext.getContentResolver().query(this.uri, new String[] { "contact_id", "_id", "data4" }, null, null, null);
      if (localCursor == null)
      {
        Log.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "query database err");
        AppMethodBeat.o(127812);
        return 1;
      }
      if (!localCursor.moveToFirst())
      {
        Log.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "query database err, move to first fail");
        localCursor.close();
        AppMethodBeat.o(127812);
        return 1;
      }
      i = localCursor.getColumnIndex("data4");
      if (i == -1)
      {
        Log.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "no data4 segment exist");
        localCursor.close();
        AppMethodBeat.o(127812);
        return 1;
      }
      Object localObject2 = "";
      String str1 = "";
      Object localObject1 = str1;
      try
      {
        String str2 = localCursor.getString(i);
        localObject1 = str1;
        localObject2 = str2;
        i = localCursor.getColumnIndex("contact_id");
        String str3;
        if (i >= 0)
        {
          localObject1 = str1;
          localObject2 = str2;
          str1 = localCursor.getString(i);
          localObject1 = str1;
          localObject2 = str2;
          i = localCursor.getColumnIndex("_id");
          if (i < 0) {
            break label373;
          }
          localObject1 = str1;
          localObject2 = str2;
          str3 = localCursor.getString(i);
        }
        label373:
        for (localObject1 = str3;; localObject1 = "")
        {
          localCursor.close();
          if (!Util.isNullOrNil(str2)) {
            break label465;
          }
          Log.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "null friendmobile");
          AppMethodBeat.o(127812);
          return 1;
          str1 = "";
          break;
        }
        i = d(paramContext, str2, (String)localObject1, str1);
      }
      catch (Exception paramContext)
      {
        Log.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "match error, %s\n%s", new Object[] { paramContext.getMessage(), Util.stackTraceToString(paramContext) });
        Log.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "result friendMobileMd5 %s contact_id %s data_id %s", new Object[] { localObject2, localObject1, "" });
        return 1;
      }
      finally
      {
        localCursor.close();
        AppMethodBeat.o(127812);
      }
      label465:
      AppMethodBeat.o(127812);
      return i;
    }
    if (!Util.isNullOrNil(this.pWt))
    {
      i = d(paramContext, g.getMessageDigest(com.tencent.mm.pluginsdk.b.Tu(this.pWt).getBytes()), null, null);
      AppMethodBeat.o(127812);
      return i;
    }
    Log.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "uri is null and the phone num is null");
    AppMethodBeat.o(127812);
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.b.b
 * JD-Core Version:    0.7.0.1
 */