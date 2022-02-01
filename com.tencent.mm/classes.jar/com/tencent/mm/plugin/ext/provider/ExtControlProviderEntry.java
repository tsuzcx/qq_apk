package com.tencent.mm.plugin.ext.provider;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.contact.d;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.ext.SubCoreExt;
import com.tencent.mm.plugin.ext.key.AESUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatAuthorities;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cv;
import com.tencent.mm.storage.cw;

public class ExtControlProviderEntry
  extends ExtContentProviderBase
{
  private static final UriMatcher zPg;
  private String[] zOO = null;
  private int zOP = -1;
  private boolean zPh = false;
  private Context zPi;
  
  static
  {
    AppMethodBeat.i(24426);
    UriMatcher localUriMatcher = new UriMatcher(-1);
    zPg = localUriMatcher;
    localUriMatcher.addURI(WeChatAuthorities.AUTHORITIES_PLUGIN_EXT_ENTRY(), "view_profile", 2);
    zPg.addURI(WeChatAuthorities.AUTHORITIES_PLUGIN_EXT_ENTRY(), "to_chatting", 3);
    zPg.addURI(WeChatAuthorities.AUTHORITIES_PLUGIN_EXT_ENTRY(), "to_nearby", 4);
    zPg.addURI(WeChatAuthorities.AUTHORITIES_PLUGIN_EXT_ENTRY(), "sns_comment_detail", 5);
    zPg.addURI(WeChatAuthorities.AUTHORITIES_PLUGIN_EXT_ENTRY(), "share_time_line", 6);
    AppMethodBeat.o(24426);
  }
  
  public ExtControlProviderEntry() {}
  
  public ExtControlProviderEntry(String[] paramArrayOfString, int paramInt, Context paramContext)
  {
    this.zPh = true;
    this.zOO = paramArrayOfString;
    this.zOP = paramInt;
    this.zPi = paramContext;
  }
  
  private Cursor A(String[] paramArrayOfString)
  {
    AppMethodBeat.i(24423);
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      Log.w("MicroMsg.ExtControlEntryProvider", "wrong args");
      Mm(3);
      AppMethodBeat.o(24423);
      return null;
    }
    paramArrayOfString = paramArrayOfString[0];
    if ((paramArrayOfString == null) || (paramArrayOfString.length() <= 0))
    {
      Log.w("MicroMsg.ExtControlEntryProvider", "contactId == null");
      Mm(3);
      AppMethodBeat.o(24423);
      return null;
    }
    try
    {
      bh.bCz();
      paramArrayOfString = com.tencent.mm.model.c.bzA().zc(AESUtil.atw(paramArrayOfString));
      if ((paramArrayOfString == null) || ((int)paramArrayOfString.maN <= 0) || (this.zPi == null))
      {
        Mm(3);
        AppMethodBeat.o(24423);
        return null;
      }
    }
    catch (Exception paramArrayOfString)
    {
      Log.w("MicroMsg.ExtControlEntryProvider", paramArrayOfString.getMessage());
      Log.printErrStackTrace("MicroMsg.ExtControlEntryProvider", paramArrayOfString, "", new Object[0]);
      Mm(3);
      AppMethodBeat.o(24423);
      return null;
    }
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    localIntent.putExtra("Contact_User", paramArrayOfString.field_username);
    com.tencent.mm.br.c.b(this.zPi, "profile", ".ui.ContactInfoUI", localIntent);
    Mm(0);
    paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.avy(1);
    AppMethodBeat.o(24423);
    return paramArrayOfString;
  }
  
  private Cursor B(String[] paramArrayOfString)
  {
    AppMethodBeat.i(24425);
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      Log.w("MicroMsg.ExtControlEntryProvider", "wrong args");
      Mm(3);
      AppMethodBeat.o(24425);
      return null;
    }
    paramArrayOfString = paramArrayOfString[0];
    if ((paramArrayOfString == null) || (paramArrayOfString.length() <= 0))
    {
      Log.w("MicroMsg.ExtControlEntryProvider", "wrong args");
      Mm(3);
      AppMethodBeat.o(24425);
      return null;
    }
    long l;
    try
    {
      l = AESUtil.atw(paramArrayOfString);
      if (l <= 0L)
      {
        Mm(3);
        AppMethodBeat.o(24425);
        return null;
      }
    }
    catch (Exception paramArrayOfString)
    {
      Log.w("MicroMsg.ExtControlEntryProvider", paramArrayOfString.getMessage());
      Log.printErrStackTrace("MicroMsg.ExtControlEntryProvider", paramArrayOfString, "", new Object[0]);
      Mm(3);
      AppMethodBeat.o(24425);
      return null;
    }
    if (this.zPi == null)
    {
      Mm(4);
      AppMethodBeat.o(24425);
      return null;
    }
    Object localObject = new Intent();
    ((Intent)localObject).setComponent(new ComponentName(MMApplicationContext.getApplicationId(), "com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI"));
    ((Intent)localObject).putExtra("INTENT_SNS_LOCAL_ID", (int)l);
    ((Intent)localObject).addCategory("android.intent.category.DEFAULT");
    ((Intent)localObject).addFlags(268435456);
    paramArrayOfString = this.zPi;
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(paramArrayOfString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/ext/provider/ExtControlProviderEntry", "toSnsCommentDetail", "([Ljava/lang/String;)Landroid/database/Cursor;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramArrayOfString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramArrayOfString, "com/tencent/mm/plugin/ext/provider/ExtControlProviderEntry", "toSnsCommentDetail", "([Ljava/lang/String;)Landroid/database/Cursor;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    Mm(0);
    paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.avy(1);
    AppMethodBeat.o(24425);
    return paramArrayOfString;
  }
  
  private Cursor c(String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(24424);
    Log.i("MicroMsg.ExtControlEntryProvider", "toChattingUI");
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      Log.w("MicroMsg.ExtControlEntryProvider", "wrong args");
      hf(3, 3601);
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.avy(3601);
      AppMethodBeat.o(24424);
      return paramArrayOfString;
    }
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.ExtControlEntryProvider", "callSource == null");
      hf(3, 3602);
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.avy(3602);
      AppMethodBeat.o(24424);
      return paramArrayOfString;
    }
    paramArrayOfString = paramArrayOfString[0];
    if ((paramArrayOfString == null) || (paramArrayOfString.length() <= 0))
    {
      Log.w("MicroMsg.ExtControlEntryProvider", "contactId == null");
      hf(3, 3603);
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.avy(3603);
      AppMethodBeat.o(24424);
      return paramArrayOfString;
    }
    int i;
    if ((paramString != null) && (paramString.equalsIgnoreCase("openapi")))
    {
      i = 1;
      if (i == 0) {
        break label288;
      }
    }
    for (;;)
    {
      try
      {
        paramArrayOfString = SubCoreExt.dNT().byP(paramArrayOfString);
        if ((paramArrayOfString == null) || (Util.isNullOrNil(paramArrayOfString.field_openId)) || (Util.isNullOrNil(paramArrayOfString.field_username)))
        {
          Log.e("MicroMsg.ExtControlEntryProvider", "openidInApp is null");
          hf(3, 3604);
          paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.avy(3604);
          AppMethodBeat.o(24424);
          return paramArrayOfString;
          i = 0;
          break;
        }
        bh.bCz();
        paramArrayOfString = com.tencent.mm.model.c.bzA().JE(paramArrayOfString.field_username);
        if ((paramArrayOfString != null) && ((int)paramArrayOfString.maN > 0) && (this.zPi != null)) {
          break label352;
        }
        Log.e("MicroMsg.ExtControlEntryProvider", "wrong args ct");
        hf(3, 3605);
        paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.avy(3605);
        AppMethodBeat.o(24424);
        return paramArrayOfString;
      }
      catch (Exception paramArrayOfString)
      {
        label288:
        Log.w("MicroMsg.ExtControlEntryProvider", paramArrayOfString.getMessage());
        Log.printErrStackTrace("MicroMsg.ExtControlEntryProvider", paramArrayOfString, "", new Object[0]);
        au(5, 4, 12);
        paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.avy(12);
        AppMethodBeat.o(24424);
        return paramArrayOfString;
      }
      bh.bCz();
      paramArrayOfString = com.tencent.mm.model.c.bzA().zc(AESUtil.atw(paramArrayOfString));
    }
    label352:
    paramString = new Intent();
    paramString.setComponent(new ComponentName(MMApplicationContext.getApplicationId(), "com.tencent.mm.ui.chatting.ChattingUI"));
    paramString.putExtra("Chat_User", paramArrayOfString.field_username);
    paramString.putExtra("finish_direct", true);
    paramString.addFlags(268435456);
    paramString.addFlags(67108864);
    paramArrayOfString = this.zPi;
    paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
    com.tencent.mm.hellhoundlib.a.a.b(paramArrayOfString, paramString.aYi(), "com/tencent/mm/plugin/ext/provider/ExtControlProviderEntry", "toChattingUI", "([Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramArrayOfString.startActivity((Intent)paramString.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramArrayOfString, "com/tencent/mm/plugin/ext/provider/ExtControlProviderEntry", "toChattingUI", "([Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    au(4, 0, 1);
    paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.avy(1);
    AppMethodBeat.o(24424);
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
    AppMethodBeat.i(24422);
    Log.i("MicroMsg.ExtControlEntryProvider", "ExtControlProviderEntry query() mIsLocalUsed :" + this.zPh);
    if (this.zPh)
    {
      a(paramUri, this.zPi, this.zOP, this.zOO);
      if (Util.isNullOrNil(this.zPa))
      {
        Log.e("MicroMsg.ExtControlEntryProvider", "AppID == null");
        hf(3, 7);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.avy(7);
        AppMethodBeat.o(24422);
        return paramUri;
      }
      if (Util.isNullOrNil(dOe()))
      {
        Log.e("MicroMsg.ExtControlEntryProvider", "PkgName == null");
        hf(3, 6);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.avy(6);
        AppMethodBeat.o(24422);
        return paramUri;
      }
      int i = dOf();
      if (i != 1)
      {
        Log.e("MicroMsg.ExtControlEntryProvider", "invalid appid ! return code = ".concat(String.valueOf(i)));
        hf(2, i);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.avy(i);
        AppMethodBeat.o(24422);
        return paramUri;
      }
    }
    else
    {
      this.zPi = getContext();
      a(paramUri, this.zPi, zPg);
      if (paramUri == null)
      {
        Mm(3);
        AppMethodBeat.o(24422);
        return null;
      }
      if ((Util.isNullOrNil(this.zPa)) || (Util.isNullOrNil(dOe())))
      {
        Mm(3);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.avy(3);
        AppMethodBeat.o(24422);
        return paramUri;
      }
      if (!dak())
      {
        Mm(1);
        paramUri = this.vsh;
        AppMethodBeat.o(24422);
        return paramUri;
      }
      if (!gh(this.zPi))
      {
        Log.w("MicroMsg.ExtControlEntryProvider", "invalid appid ! return null");
        Mm(2);
        AppMethodBeat.o(24422);
        return null;
      }
    }
    paramArrayOfString1 = Util.nullAsNil(paramUri.getQueryParameter("source"));
    if (!this.zPh) {
      this.zOP = zPg.match(paramUri);
    }
    switch (this.zOP)
    {
    default: 
      hf(3, 15);
      AppMethodBeat.o(24422);
      return null;
    case 2: 
      paramUri = A(paramArrayOfString2);
      AppMethodBeat.o(24422);
      return paramUri;
    case 3: 
      paramUri = c(paramArrayOfString2, paramArrayOfString1);
      AppMethodBeat.o(24422);
      return paramUri;
    case 4: 
      if (this.zPi == null)
      {
        Mm(4);
        AppMethodBeat.o(24422);
        return null;
      }
      paramArrayOfString1 = new Intent();
      paramArrayOfString1.setComponent(new ComponentName(MMApplicationContext.getApplicationId(), "com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI"));
      paramArrayOfString1.addFlags(268435456);
      paramUri = this.zPi;
      paramArrayOfString1 = new com.tencent.mm.hellhoundlib.b.a().cG(paramArrayOfString1);
      com.tencent.mm.hellhoundlib.a.a.b(paramUri, paramArrayOfString1.aYi(), "com/tencent/mm/plugin/ext/provider/ExtControlProviderEntry", "toNearBy", "()Landroid/database/Cursor;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramUri.startActivity((Intent)paramArrayOfString1.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramUri, "com/tencent/mm/plugin/ext/provider/ExtControlProviderEntry", "toNearBy", "()Landroid/database/Cursor;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      Mm(0);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.avy(1);
      AppMethodBeat.o(24422);
      return paramUri;
    case 5: 
      paramUri = B(paramArrayOfString2);
      AppMethodBeat.o(24422);
      return paramUri;
    }
    if ((paramArrayOfString2 == null) || (paramArrayOfString2.length <= 0))
    {
      Log.w("MicroMsg.ExtControlEntryProvider", "wrong args");
      Mm(3);
      AppMethodBeat.o(24422);
      return null;
    }
    if (this.zPi == null)
    {
      Mm(4);
      AppMethodBeat.o(24422);
      return null;
    }
    paramArrayOfString1 = new Intent();
    paramArrayOfString1.setComponent(new ComponentName(MMApplicationContext.getApplicationId(), "com.tencent.mm.ui.tools.ShareToTimeLineUI"));
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
      paramUri = this.zPi;
      paramArrayOfString1 = new com.tencent.mm.hellhoundlib.b.a().cG(paramArrayOfString1);
      com.tencent.mm.hellhoundlib.a.a.b(paramUri, paramArrayOfString1.aYi(), "com/tencent/mm/plugin/ext/provider/ExtControlProviderEntry", "toShareTimeLine", "([Ljava/lang/String;)Landroid/database/Cursor;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramUri.startActivity((Intent)paramArrayOfString1.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramUri, "com/tencent/mm/plugin/ext/provider/ExtControlProviderEntry", "toShareTimeLine", "([Ljava/lang/String;)Landroid/database/Cursor;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      Mm(0);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.avy(1);
      AppMethodBeat.o(24422);
      return paramUri;
    }
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.provider.ExtControlProviderEntry
 * JD-Core Version:    0.7.0.1
 */