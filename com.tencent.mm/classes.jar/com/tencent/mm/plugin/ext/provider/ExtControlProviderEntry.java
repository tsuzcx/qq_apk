package com.tencent.mm.plugin.ext.provider;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.ext.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bz;
import com.tencent.mm.storage.ca;

@JgClassChecked(author=32, fComment="checked", lastDate="20141016", reviewer=20, vComment={com.jg.EType.PROVIDERCHECK})
public class ExtControlProviderEntry
  extends ExtContentProviderBase
{
  private static final UriMatcher meo;
  private String[] mdZ = null;
  private int mea = -1;
  private boolean mep = false;
  private Context meq;
  
  static
  {
    AppMethodBeat.i(20347);
    UriMatcher localUriMatcher = new UriMatcher(-1);
    meo = localUriMatcher;
    localUriMatcher.addURI("com.tencent.mm.plugin.ext.entry", "view_profile", 2);
    meo.addURI("com.tencent.mm.plugin.ext.entry", "to_chatting", 3);
    meo.addURI("com.tencent.mm.plugin.ext.entry", "to_nearby", 4);
    meo.addURI("com.tencent.mm.plugin.ext.entry", "sns_comment_detail", 5);
    meo.addURI("com.tencent.mm.plugin.ext.entry", "share_time_line", 6);
    AppMethodBeat.o(20347);
  }
  
  public ExtControlProviderEntry() {}
  
  public ExtControlProviderEntry(String[] paramArrayOfString, int paramInt, Context paramContext)
  {
    this.mep = true;
    this.mdZ = paramArrayOfString;
    this.mea = paramInt;
    this.meq = paramContext;
  }
  
  private Cursor a(String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(20345);
    ab.i("MicroMsg.ExtControlEntryProvider", "toChattingUI");
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      ab.w("MicroMsg.ExtControlEntryProvider", "wrong args");
      ej(3, 3601);
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Ls(3601);
      AppMethodBeat.o(20345);
      return paramArrayOfString;
    }
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.ExtControlEntryProvider", "callSource == null");
      ej(3, 3602);
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Ls(3602);
      AppMethodBeat.o(20345);
      return paramArrayOfString;
    }
    paramArrayOfString = paramArrayOfString[0];
    if ((paramArrayOfString == null) || (paramArrayOfString.length() <= 0))
    {
      ab.w("MicroMsg.ExtControlEntryProvider", "contactId == null");
      ej(3, 3603);
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Ls(3603);
      AppMethodBeat.o(20345);
      return paramArrayOfString;
    }
    int i;
    if ((paramString != null) && (paramString.equalsIgnoreCase("openapi")))
    {
      i = 1;
      if (i == 0) {
        break label286;
      }
    }
    for (;;)
    {
      try
      {
        paramArrayOfString = b.btt().asG(paramArrayOfString);
        if ((paramArrayOfString == null) || (bo.isNullOrNil(paramArrayOfString.field_openId)) || (bo.isNullOrNil(paramArrayOfString.field_username)))
        {
          ab.e("MicroMsg.ExtControlEntryProvider", "openidInApp is null");
          ej(3, 3604);
          paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Ls(3604);
          AppMethodBeat.o(20345);
          return paramArrayOfString;
          i = 0;
          break;
        }
        aw.aaz();
        paramArrayOfString = c.YA().arw(paramArrayOfString.field_username);
        if ((paramArrayOfString != null) && ((int)paramArrayOfString.euF > 0) && (this.meq != null)) {
          break label350;
        }
        ab.e("MicroMsg.ExtControlEntryProvider", "wrong args ct");
        ej(3, 3605);
        paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Ls(3605);
        AppMethodBeat.o(20345);
        return paramArrayOfString;
      }
      catch (Exception paramArrayOfString)
      {
        label286:
        ab.w("MicroMsg.ExtControlEntryProvider", paramArrayOfString.getMessage());
        ab.printErrStackTrace("MicroMsg.ExtControlEntryProvider", paramArrayOfString, "", new Object[0]);
        S(5, 4, 12);
        paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Ls(12);
        AppMethodBeat.o(20345);
        return paramArrayOfString;
      }
      aw.aaz();
      paramArrayOfString = c.YA().on(com.tencent.mm.plugin.ext.a.a.Nc(paramArrayOfString));
    }
    label350:
    paramString = new Intent();
    paramString.setComponent(new ComponentName("com.tencent.mm", "com.tencent.mm.ui.chatting.ChattingUI"));
    paramString.putExtra("Chat_User", paramArrayOfString.field_username);
    paramString.putExtra("finish_direct", true);
    paramString.addFlags(268435456);
    paramString.addFlags(67108864);
    this.meq.startActivity(paramString);
    S(4, 0, 1);
    paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Ls(1);
    AppMethodBeat.o(20345);
    return paramArrayOfString;
  }
  
  private Cursor r(String[] paramArrayOfString)
  {
    AppMethodBeat.i(20344);
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      ab.w("MicroMsg.ExtControlEntryProvider", "wrong args");
      vA(3);
      AppMethodBeat.o(20344);
      return null;
    }
    paramArrayOfString = paramArrayOfString[0];
    if ((paramArrayOfString == null) || (paramArrayOfString.length() <= 0))
    {
      ab.w("MicroMsg.ExtControlEntryProvider", "contactId == null");
      vA(3);
      AppMethodBeat.o(20344);
      return null;
    }
    try
    {
      aw.aaz();
      paramArrayOfString = c.YA().on(com.tencent.mm.plugin.ext.a.a.Nc(paramArrayOfString));
      if ((paramArrayOfString == null) || ((int)paramArrayOfString.euF <= 0) || (this.meq == null))
      {
        vA(3);
        AppMethodBeat.o(20344);
        return null;
      }
    }
    catch (Exception paramArrayOfString)
    {
      ab.w("MicroMsg.ExtControlEntryProvider", paramArrayOfString.getMessage());
      ab.printErrStackTrace("MicroMsg.ExtControlEntryProvider", paramArrayOfString, "", new Object[0]);
      vA(3);
      AppMethodBeat.o(20344);
      return null;
    }
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    localIntent.putExtra("Contact_User", paramArrayOfString.field_username);
    d.b(this.meq, "profile", ".ui.ContactInfoUI", localIntent);
    vA(0);
    paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Ls(1);
    AppMethodBeat.o(20344);
    return paramArrayOfString;
  }
  
  private Cursor s(String[] paramArrayOfString)
  {
    AppMethodBeat.i(20346);
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      ab.w("MicroMsg.ExtControlEntryProvider", "wrong args");
      vA(3);
      AppMethodBeat.o(20346);
      return null;
    }
    paramArrayOfString = paramArrayOfString[0];
    if ((paramArrayOfString == null) || (paramArrayOfString.length() <= 0))
    {
      ab.w("MicroMsg.ExtControlEntryProvider", "wrong args");
      vA(3);
      AppMethodBeat.o(20346);
      return null;
    }
    long l;
    try
    {
      l = com.tencent.mm.plugin.ext.a.a.Nc(paramArrayOfString);
      if (l <= 0L)
      {
        vA(3);
        AppMethodBeat.o(20346);
        return null;
      }
    }
    catch (Exception paramArrayOfString)
    {
      ab.w("MicroMsg.ExtControlEntryProvider", paramArrayOfString.getMessage());
      ab.printErrStackTrace("MicroMsg.ExtControlEntryProvider", paramArrayOfString, "", new Object[0]);
      vA(3);
      AppMethodBeat.o(20346);
      return null;
    }
    if (this.meq == null)
    {
      vA(4);
      AppMethodBeat.o(20346);
      return null;
    }
    paramArrayOfString = new Intent();
    paramArrayOfString.setComponent(new ComponentName("com.tencent.mm", "com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI"));
    paramArrayOfString.putExtra("INTENT_SNS_LOCAL_ID", (int)l);
    paramArrayOfString.addCategory("android.intent.category.DEFAULT");
    paramArrayOfString.addFlags(268435456);
    this.meq.startActivity(paramArrayOfString);
    vA(0);
    paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Ls(1);
    AppMethodBeat.o(20346);
    return paramArrayOfString;
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
  
  public String getType(Uri paramUri)
  {
    return null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    return null;
  }
  
  public boolean onCreate()
  {
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    AppMethodBeat.i(20343);
    ab.i("MicroMsg.ExtControlEntryProvider", "ExtControlProviderEntry query() mIsLocalUsed :" + this.mep);
    if (this.mep)
    {
      a(paramUri, this.meq, this.mea, this.mdZ);
      if (bo.isNullOrNil(this.mei))
      {
        ab.e("MicroMsg.ExtControlEntryProvider", "AppID == null");
        ej(3, 7);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Ls(7);
        AppMethodBeat.o(20343);
        return paramUri;
      }
      if (bo.isNullOrNil(btD()))
      {
        ab.e("MicroMsg.ExtControlEntryProvider", "PkgName == null");
        ej(3, 6);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Ls(6);
        AppMethodBeat.o(20343);
        return paramUri;
      }
      int i = btE();
      if (i != 1)
      {
        ab.e("MicroMsg.ExtControlEntryProvider", "invalid appid ! return code = ".concat(String.valueOf(i)));
        ej(2, i);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Ls(i);
        AppMethodBeat.o(20343);
        return paramUri;
      }
    }
    else
    {
      this.meq = getContext();
      a(paramUri, this.meq, meo);
      if (paramUri == null)
      {
        vA(3);
        AppMethodBeat.o(20343);
        return null;
      }
      if ((bo.isNullOrNil(this.mei)) || (bo.isNullOrNil(btD())))
      {
        vA(3);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Ls(3);
        AppMethodBeat.o(20343);
        return paramUri;
      }
      if (!aVH())
      {
        vA(1);
        paramUri = this.jLW;
        AppMethodBeat.o(20343);
        return paramUri;
      }
      if (!dO(this.meq))
      {
        ab.w("MicroMsg.ExtControlEntryProvider", "invalid appid ! return null");
        vA(2);
        AppMethodBeat.o(20343);
        return null;
      }
    }
    paramArrayOfString1 = bo.nullAsNil(paramUri.getQueryParameter("source"));
    if (!this.mep) {
      this.mea = meo.match(paramUri);
    }
    switch (this.mea)
    {
    default: 
      ej(3, 15);
      AppMethodBeat.o(20343);
      return null;
    case 2: 
      paramUri = r(paramArrayOfString2);
      AppMethodBeat.o(20343);
      return paramUri;
    case 3: 
      paramUri = a(paramArrayOfString2, paramArrayOfString1);
      AppMethodBeat.o(20343);
      return paramUri;
    case 4: 
      if (this.meq == null)
      {
        vA(4);
        AppMethodBeat.o(20343);
        return null;
      }
      paramUri = new Intent();
      paramUri.setComponent(new ComponentName("com.tencent.mm", "com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI"));
      paramUri.addFlags(268435456);
      this.meq.startActivity(paramUri);
      vA(0);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Ls(1);
      AppMethodBeat.o(20343);
      return paramUri;
    case 5: 
      paramUri = s(paramArrayOfString2);
      AppMethodBeat.o(20343);
      return paramUri;
    }
    if ((paramArrayOfString2 == null) || (paramArrayOfString2.length <= 0))
    {
      ab.w("MicroMsg.ExtControlEntryProvider", "wrong args");
      vA(3);
      AppMethodBeat.o(20343);
      return null;
    }
    if (this.meq == null)
    {
      vA(4);
      AppMethodBeat.o(20343);
      return null;
    }
    paramArrayOfString1 = new Intent();
    paramArrayOfString1.setComponent(new ComponentName("com.tencent.mm", "com.tencent.mm.ui.tools.ShareToTimeLineUI"));
    paramArrayOfString1.setAction("android.intent.action.SEND");
    paramArrayOfString1.addCategory("android.intent.category.DEFAULT");
    paramArrayOfString1.addFlags(268435456);
    if (paramArrayOfString2[1] == null) {}
    for (paramUri = "";; paramUri = paramArrayOfString2[1])
    {
      paramArrayOfString1.putExtra("android.intent.extra.TEXT", paramUri);
      if ((paramArrayOfString2[0] != null) && (paramArrayOfString2[0].trim().length() > 0)) {
        paramArrayOfString1.putExtra("android.intent.extra.STREAM", Uri.parse(paramArrayOfString2[0]));
      }
      paramArrayOfString1.putExtra("Ksnsupload_empty_img", true);
      paramArrayOfString1.setType("image/*");
      this.meq.startActivity(paramArrayOfString1);
      vA(0);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Ls(1);
      AppMethodBeat.o(20343);
      return paramUri;
    }
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.provider.ExtControlProviderEntry
 * JD-Core Version:    0.7.0.1
 */