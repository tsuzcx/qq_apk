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
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.ux;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.z;

public final class b$b
  implements b.a
{
  private String gAF;
  private int toScene;
  private Uri uri;
  
  public b$b(int paramInt, String paramString, Uri paramUri)
  {
    this.toScene = paramInt;
    this.gAF = paramString;
    this.uri = paramUri;
  }
  
  private int d(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(124660);
    Object localObject = com.tencent.mm.plugin.account.a.getAddrUploadStg().xa(paramString1);
    if (paramContext == null)
    {
      ab.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "null context");
      AppMethodBeat.o(124660);
      return 1;
    }
    if (localObject == null)
    {
      ab.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "this user is not my friend");
      AppMethodBeat.o(124660);
      return 1;
    }
    localObject = ((com.tencent.mm.plugin.account.friend.a.a)localObject).getUsername();
    if (bo.isNullOrNil((String)localObject))
    {
      ab.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "get username failed, phonenum md5 is ".concat(String.valueOf(paramString1)));
      AppMethodBeat.o(124660);
      return 1;
    }
    if (((j)com.tencent.mm.kernel.g.E(j.class)).YA().arr((String)localObject))
    {
      h.qsU.e(11157, new Object[] { Integer.valueOf(this.toScene) });
      switch (this.toScene)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(124660);
      return 1;
      paramString1 = new Intent();
      paramString1.putExtra("Chat_User", (String)localObject);
      paramString1.putExtra("finish_direct", true);
      paramString1.addFlags(67108864);
      com.tencent.mm.plugin.account.a.a.gmO.d(paramString1, paramContext);
      AppMethodBeat.o(124660);
      return 0;
      paramString1 = new ux();
      paramString1.cLs.cut = 5;
      paramString1.cLs.talker = ((String)localObject);
      paramString1.cLs.context = paramContext;
      paramString1.cLs.cLm = 3;
      com.tencent.mm.sdk.b.a.ymk.l(paramString1);
      AppMethodBeat.o(124660);
      return 0;
      paramString1 = new ux();
      paramString1.cLs.cut = 5;
      paramString1.cLs.talker = ((String)localObject);
      paramString1.cLs.context = paramContext;
      paramString1.cLs.cLm = 2;
      com.tencent.mm.sdk.b.a.ymk.l(paramString1);
      AppMethodBeat.o(124660);
      return 0;
      paramString1 = new Intent();
      paramString1.putExtra("sns_userName", (String)localObject);
      paramString1.addFlags(67108864);
      paramString1.putExtra("sns_adapter_type", 1);
      d.b(paramContext, "sns", ".ui.SnsUserUI", paramString1);
      AppMethodBeat.o(124660);
      return 0;
      if ((!bo.isNullOrNil(paramString3)) && (!bo.isNullOrNil(paramString2)))
      {
        if (!com.tencent.mm.pluginsdk.permission.b.o(paramContext, "android.permission.READ_CONTACTS"))
        {
          ab.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "no contact permission");
          AppMethodBeat.o(124660);
          return 1;
        }
        Toast.makeText(paramContext, paramContext.getString(2131298857), 1).show();
        paramContext.getContentResolver().delete(ContactsContract.Data.CONTENT_URI, "_id = ?", new String[] { paramString2 });
        paramContext.getContentResolver().delete(ContactsContract.RawContacts.CONTENT_URI, "contact_id = ? AND account_type = ?", new String[] { paramString3, "com.tencent.mm.account" });
      }
    }
  }
  
  public final int cE(Context paramContext)
  {
    AppMethodBeat.i(124659);
    com.tencent.mm.kernel.g.RJ();
    if ((!com.tencent.mm.kernel.a.QT()) || (com.tencent.mm.kernel.a.QP()))
    {
      ab.d("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "not login, start bind login");
      AppMethodBeat.o(124659);
      return 3;
    }
    if (bo.isNullOrNil((String)com.tencent.mm.kernel.g.RL().Ru().get(6, "")))
    {
      ab.d("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "not bind mobile, start bind mobie");
      AppMethodBeat.o(124659);
      return 2;
    }
    if (!com.tencent.mm.pluginsdk.permission.b.o(paramContext, "android.permission.READ_CONTACTS"))
    {
      ab.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "no contacts permission");
      AppMethodBeat.o(124659);
      return 1;
    }
    int i;
    if (this.uri != null)
    {
      Cursor localCursor = paramContext.getContentResolver().query(this.uri, new String[] { "contact_id", "_id", "data4" }, null, null, null);
      if (localCursor == null)
      {
        ab.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "query database err");
        AppMethodBeat.o(124659);
        return 1;
      }
      if (!localCursor.moveToFirst())
      {
        ab.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "query database err, move to first fail");
        localCursor.close();
        AppMethodBeat.o(124659);
        return 1;
      }
      i = localCursor.getColumnIndex("data4");
      if (i == -1)
      {
        ab.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "no data4 segment exist");
        localCursor.close();
        AppMethodBeat.o(124659);
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
          if (!bo.isNullOrNil(str2)) {
            break label465;
          }
          ab.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "null friendmobile");
          AppMethodBeat.o(124659);
          return 1;
          str1 = "";
          break;
        }
        i = d(paramContext, str2, (String)localObject1, str1);
      }
      catch (Exception paramContext)
      {
        ab.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "match error, %s\n%s", new Object[] { paramContext.getMessage(), bo.l(paramContext) });
        ab.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "result friendMobileMd5 %s contact_id %s data_id %s", new Object[] { localObject2, localObject1, "" });
        return 1;
      }
      finally
      {
        localCursor.close();
        AppMethodBeat.o(124659);
      }
      label465:
      AppMethodBeat.o(124659);
      return i;
    }
    if (!bo.isNullOrNil(this.gAF))
    {
      i = d(paramContext, com.tencent.mm.a.g.w(com.tencent.mm.pluginsdk.a.xw(this.gAF).getBytes()), null, null);
      AppMethodBeat.o(124659);
      return i;
    }
    ab.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "uri is null and the phone num is null");
    AppMethodBeat.o(124659);
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.b.b
 * JD-Core Version:    0.7.0.1
 */