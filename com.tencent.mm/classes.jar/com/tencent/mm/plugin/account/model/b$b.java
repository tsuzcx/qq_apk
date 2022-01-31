package com.tencent.mm.plugin.account.model;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.RawContacts;
import android.widget.Toast;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.td;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.account.ui.q.j;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.z;

public final class b$b
  implements b.a
{
  private String fjn;
  private int toScene;
  private Uri uri;
  
  public b$b(int paramInt, String paramString, Uri paramUri)
  {
    this.toScene = paramInt;
    this.fjn = paramString;
    this.uri = paramUri;
  }
  
  private int d(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    Object localObject = com.tencent.mm.plugin.account.b.getAddrUploadStg().pI(paramString1);
    if (paramContext == null)
    {
      y.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "null context");
      return 1;
    }
    if (localObject == null)
    {
      y.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "this user is not my friend");
      return 1;
    }
    localObject = ((com.tencent.mm.plugin.account.friend.a.a)localObject).getUsername();
    if (bk.bl((String)localObject))
    {
      y.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "get username failed, phonenum md5 is " + paramString1);
      return 1;
    }
    if (((j)com.tencent.mm.kernel.g.r(j.class)).Fw().abg((String)localObject))
    {
      h.nFQ.f(11157, new Object[] { Integer.valueOf(this.toScene) });
      switch (this.toScene)
      {
      }
    }
    for (;;)
    {
      return 1;
      paramString1 = new Intent();
      paramString1.putExtra("Chat_User", (String)localObject);
      paramString1.putExtra("finish_direct", true);
      paramString1.addFlags(67108864);
      com.tencent.mm.plugin.account.a.a.eUR.e(paramString1, paramContext);
      return 0;
      paramString1 = new td();
      paramString1.ccJ.bNb = 5;
      paramString1.ccJ.talker = ((String)localObject);
      paramString1.ccJ.context = paramContext;
      paramString1.ccJ.ccE = 3;
      com.tencent.mm.sdk.b.a.udP.m(paramString1);
      return 0;
      paramString1 = new td();
      paramString1.ccJ.bNb = 5;
      paramString1.ccJ.talker = ((String)localObject);
      paramString1.ccJ.context = paramContext;
      paramString1.ccJ.ccE = 2;
      com.tencent.mm.sdk.b.a.udP.m(paramString1);
      return 0;
      paramString1 = new Intent();
      paramString1.putExtra("sns_userName", (String)localObject);
      paramString1.addFlags(67108864);
      d.b(paramContext, "sns", ".ui.SnsUserUI", paramString1);
      return 0;
      if ((!bk.bl(paramString3)) && (!bk.bl(paramString2)))
      {
        if (!com.tencent.mm.pluginsdk.permission.a.j(paramContext, "android.permission.READ_CONTACTS"))
        {
          y.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "no contact permission");
          return 1;
        }
        Toast.makeText(paramContext, paramContext.getString(q.j.contact_sync_chat_not_friend), 1).show();
        paramContext.getContentResolver().delete(ContactsContract.Data.CONTENT_URI, "_id = ?", new String[] { paramString2 });
        paramContext.getContentResolver().delete(ContactsContract.RawContacts.CONTENT_URI, "contact_id = ? AND account_type = ?", new String[] { paramString3, "com.tencent.mm.account" });
      }
    }
  }
  
  public final int bY(Context paramContext)
  {
    if (paramContext == null)
    {
      y.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "null context");
      return 1;
    }
    com.tencent.mm.kernel.g.DN();
    if ((!com.tencent.mm.kernel.a.Db()) || (com.tencent.mm.kernel.a.CW()))
    {
      y.d("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "not login, start bind login");
      return 3;
    }
    if (bk.bl((String)com.tencent.mm.kernel.g.DP().Dz().get(6, "")))
    {
      y.d("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "not bind mobile, start bind mobie");
      return 2;
    }
    if (!com.tencent.mm.pluginsdk.permission.a.j(paramContext, "android.permission.READ_CONTACTS"))
    {
      y.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "no contacts permission");
      return 1;
    }
    String str1;
    Object localObject1;
    if (this.uri != null)
    {
      Cursor localCursor = paramContext.getContentResolver().query(this.uri, new String[] { "contact_id", "_id", "data4" }, null, null, null);
      if (localCursor == null)
      {
        y.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "query database err");
        return 1;
      }
      if (!localCursor.moveToFirst())
      {
        y.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "query database err, move to first fail");
        localCursor.close();
        return 1;
      }
      int i = localCursor.getColumnIndex("data4");
      if (i == -1)
      {
        y.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "no data4 segment exist");
        localCursor.close();
        return 1;
      }
      Object localObject2 = "";
      str1 = "";
      localObject1 = str1;
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
            break label346;
          }
          localObject1 = str1;
          localObject2 = str2;
          str3 = localCursor.getString(i);
        }
        label346:
        for (localObject1 = str3;; localObject1 = "")
        {
          localCursor.close();
          if (!bk.bl(str2)) {
            break label428;
          }
          y.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "null friendmobile");
          return 1;
          str1 = "";
          break;
        }
        return d(paramContext, str2, (String)localObject1, str1);
      }
      catch (Exception paramContext)
      {
        y.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "match error, %s\n%s", new Object[] { paramContext.getMessage(), bk.j(paramContext) });
        y.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "result friendMobileMd5 %s contact_id %s data_id %s", new Object[] { localObject2, localObject1, "" });
        return 1;
      }
      finally
      {
        localCursor.close();
      }
    }
    label428:
    if (!bk.bl(this.fjn)) {
      return d(paramContext, com.tencent.mm.a.g.o(com.tencent.mm.pluginsdk.a.qa(this.fjn).getBytes()), null, null);
    }
    y.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "uri is null and the phone num is null");
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.b.b
 * JD-Core Version:    0.7.0.1
 */