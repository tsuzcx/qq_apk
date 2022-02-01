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
import com.tencent.mm.g.a.yb;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bp;

public final class b$b
  implements b.a
{
  private String jhp;
  private int toScene;
  private Uri uri;
  
  public b$b(int paramInt, String paramString, Uri paramUri)
  {
    this.toScene = paramInt;
    this.jhp = paramString;
    this.uri = paramUri;
  }
  
  private int b(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(127813);
    Object localObject = com.tencent.mm.plugin.account.a.getAddrUploadStg().Jx(paramString1);
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
    if (((l)com.tencent.mm.kernel.g.ab(l.class)).azp().aTg((String)localObject))
    {
      com.tencent.mm.plugin.report.service.g.yhR.f(11157, new Object[] { Integer.valueOf(this.toScene) });
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
      com.tencent.mm.plugin.account.a.a.iRG.d(paramString1, paramContext);
      AppMethodBeat.o(127813);
      return 0;
      paramString1 = new yb();
      paramString1.dMo.dsi = 5;
      paramString1.dMo.talker = ((String)localObject);
      paramString1.dMo.context = paramContext;
      paramString1.dMo.dMk = 3;
      com.tencent.mm.sdk.b.a.IbL.l(paramString1);
      AppMethodBeat.o(127813);
      return 0;
      paramString1 = new yb();
      paramString1.dMo.dsi = 5;
      paramString1.dMo.talker = ((String)localObject);
      paramString1.dMo.context = paramContext;
      paramString1.dMo.dMk = 2;
      com.tencent.mm.sdk.b.a.IbL.l(paramString1);
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
        if (!com.tencent.mm.pluginsdk.permission.b.n(paramContext, "android.permission.READ_CONTACTS"))
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
  
  public final int df(Context paramContext)
  {
    AppMethodBeat.i(127812);
    com.tencent.mm.kernel.g.ajA();
    if ((!com.tencent.mm.kernel.a.aiJ()) || (com.tencent.mm.kernel.a.aiE()))
    {
      ad.d("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "not login, start bind login");
      AppMethodBeat.o(127812);
      return 3;
    }
    if (bt.isNullOrNil((String)com.tencent.mm.kernel.g.ajC().ajl().get(6, "")))
    {
      ad.d("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "not bind mobile, start bind mobie");
      AppMethodBeat.o(127812);
      return 2;
    }
    if (!com.tencent.mm.pluginsdk.permission.b.n(paramContext, "android.permission.READ_CONTACTS"))
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
        ad.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "match error, %s\n%s", new Object[] { paramContext.getMessage(), bt.n(paramContext) });
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
    if (!bt.isNullOrNil(this.jhp))
    {
      i = b(paramContext, com.tencent.mm.b.g.getMessageDigest(com.tencent.mm.pluginsdk.b.JV(this.jhp).getBytes()), null, null);
      AppMethodBeat.o(127812);
      return i;
    }
    ad.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "uri is null and the phone num is null");
    AppMethodBeat.o(127812);
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.b.b
 * JD-Core Version:    0.7.0.1
 */