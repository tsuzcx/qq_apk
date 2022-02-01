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
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.ww;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bg;

public final class b$b
  implements b.a
{
  private String ioa;
  private int toScene;
  private Uri uri;
  
  public b$b(int paramInt, String paramString, Uri paramUri)
  {
    this.toScene = paramInt;
    this.ioa = paramString;
    this.uri = paramUri;
  }
  
  private int b(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(127813);
    Object localObject = com.tencent.mm.plugin.account.a.getAddrUploadStg().Cf(paramString1);
    if (paramContext == null)
    {
      ad.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "null context");
      AppMethodBeat.o(127813);
      return 1;
    }
    if (localObject == null)
    {
      ad.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "this user is not my friend");
      AppMethodBeat.o(127813);
      return 1;
    }
    localObject = ((com.tencent.mm.plugin.account.friend.a.a)localObject).getUsername();
    if (bt.isNullOrNil((String)localObject))
    {
      ad.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "get username failed, phonenum md5 is ".concat(String.valueOf(paramString1)));
      AppMethodBeat.o(127813);
      return 1;
    }
    if (((k)com.tencent.mm.kernel.g.ab(k.class)).apM().aHT((String)localObject))
    {
      h.vKh.f(11157, new Object[] { Integer.valueOf(this.toScene) });
      switch (this.toScene)
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
      com.tencent.mm.plugin.account.a.a.hYt.d(paramString1, paramContext);
      AppMethodBeat.o(127813);
      return 0;
      paramString1 = new ww();
      paramString1.dCp.djq = 5;
      paramString1.dCp.talker = ((String)localObject);
      paramString1.dCp.context = paramContext;
      paramString1.dCp.dCj = 3;
      com.tencent.mm.sdk.b.a.ESL.l(paramString1);
      AppMethodBeat.o(127813);
      return 0;
      paramString1 = new ww();
      paramString1.dCp.djq = 5;
      paramString1.dCp.talker = ((String)localObject);
      paramString1.dCp.context = paramContext;
      paramString1.dCp.dCj = 2;
      com.tencent.mm.sdk.b.a.ESL.l(paramString1);
      AppMethodBeat.o(127813);
      return 0;
      paramString1 = new Intent();
      paramString1.putExtra("sns_userName", (String)localObject);
      paramString1.addFlags(67108864);
      paramString1.putExtra("sns_adapter_type", 1);
      d.b(paramContext, "sns", ".ui.SnsUserUI", paramString1);
      AppMethodBeat.o(127813);
      return 0;
      if ((!bt.isNullOrNil(paramString3)) && (!bt.isNullOrNil(paramString2)))
      {
        if (!com.tencent.mm.pluginsdk.permission.b.o(paramContext, "android.permission.READ_CONTACTS"))
        {
          ad.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "no contact permission");
          AppMethodBeat.o(127813);
          return 1;
        }
        Toast.makeText(paramContext, paramContext.getString(2131757935), 1).show();
        paramContext.getContentResolver().delete(ContactsContract.Data.CONTENT_URI, "_id = ?", new String[] { paramString2 });
        paramContext.getContentResolver().delete(ContactsContract.RawContacts.CONTENT_URI, "contact_id = ? AND account_type = ?", new String[] { paramString3, "com.tencent.mm.account" });
      }
    }
  }
  
  public final int cY(Context paramContext)
  {
    AppMethodBeat.i(127812);
    com.tencent.mm.kernel.g.afz();
    if ((!com.tencent.mm.kernel.a.aeH()) || (com.tencent.mm.kernel.a.aeC()))
    {
      ad.d("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "not login, start bind login");
      AppMethodBeat.o(127812);
      return 3;
    }
    if (bt.isNullOrNil((String)com.tencent.mm.kernel.g.afB().afk().get(6, "")))
    {
      ad.d("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "not bind mobile, start bind mobie");
      AppMethodBeat.o(127812);
      return 2;
    }
    if (!com.tencent.mm.pluginsdk.permission.b.o(paramContext, "android.permission.READ_CONTACTS"))
    {
      ad.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "no contacts permission");
      AppMethodBeat.o(127812);
      return 1;
    }
    int i;
    if (this.uri != null)
    {
      Cursor localCursor = paramContext.getContentResolver().query(this.uri, new String[] { "contact_id", "_id", "data4" }, null, null, null);
      if (localCursor == null)
      {
        ad.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "query database err");
        AppMethodBeat.o(127812);
        return 1;
      }
      if (!localCursor.moveToFirst())
      {
        ad.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "query database err, move to first fail");
        localCursor.close();
        AppMethodBeat.o(127812);
        return 1;
      }
      i = localCursor.getColumnIndex("data4");
      if (i == -1)
      {
        ad.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "no data4 segment exist");
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
          if (!bt.isNullOrNil(str2)) {
            break label465;
          }
          ad.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "null friendmobile");
          AppMethodBeat.o(127812);
          return 1;
          str1 = "";
          break;
        }
        i = b(paramContext, str2, (String)localObject1, str1);
      }
      catch (Exception paramContext)
      {
        ad.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "match error, %s\n%s", new Object[] { paramContext.getMessage(), bt.m(paramContext) });
        ad.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "result friendMobileMd5 %s contact_id %s data_id %s", new Object[] { localObject2, localObject1, "" });
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
    if (!bt.isNullOrNil(this.ioa))
    {
      i = b(paramContext, com.tencent.mm.b.g.getMessageDigest(com.tencent.mm.pluginsdk.a.CD(this.ioa).getBytes()), null, null);
      AppMethodBeat.o(127812);
      return i;
    }
    ad.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "uri is null and the phone num is null");
    AppMethodBeat.o(127812);
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.b.b
 * JD-Core Version:    0.7.0.1
 */