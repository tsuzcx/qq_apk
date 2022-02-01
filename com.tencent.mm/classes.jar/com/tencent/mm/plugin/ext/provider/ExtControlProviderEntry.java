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
import com.tencent.mm.contact.d;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.ext.b;
import com.tencent.mm.plugin.ext.key.AESUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatAuthorities;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.cs;
import com.tencent.mm.storage.ct;

@JgClassChecked(author=32, fComment="checked", lastDate="20141016", reviewer=20, vComment={com.jg.EType.PROVIDERCHECK})
public class ExtControlProviderEntry
  extends ExtContentProviderBase
{
  private static final UriMatcher wta;
  private String[] wsI = null;
  private int wsJ = -1;
  private boolean wtb = false;
  private Context wtc;
  
  static
  {
    AppMethodBeat.i(24426);
    UriMatcher localUriMatcher = new UriMatcher(-1);
    wta = localUriMatcher;
    localUriMatcher.addURI(WeChatAuthorities.AUTHORITIES_PLUGIN_EXT_ENTRY(), "view_profile", 2);
    wta.addURI(WeChatAuthorities.AUTHORITIES_PLUGIN_EXT_ENTRY(), "to_chatting", 3);
    wta.addURI(WeChatAuthorities.AUTHORITIES_PLUGIN_EXT_ENTRY(), "to_nearby", 4);
    wta.addURI(WeChatAuthorities.AUTHORITIES_PLUGIN_EXT_ENTRY(), "sns_comment_detail", 5);
    wta.addURI(WeChatAuthorities.AUTHORITIES_PLUGIN_EXT_ENTRY(), "share_time_line", 6);
    AppMethodBeat.o(24426);
  }
  
  public ExtControlProviderEntry() {}
  
  public ExtControlProviderEntry(String[] paramArrayOfString, int paramInt, Context paramContext)
  {
    this.wtb = true;
    this.wsI = paramArrayOfString;
    this.wsJ = paramInt;
    this.wtc = paramContext;
  }
  
  private Cursor A(String[] paramArrayOfString)
  {
    AppMethodBeat.i(24425);
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      Log.w("MicroMsg.ExtControlEntryProvider", "wrong args");
      Lp(3);
      AppMethodBeat.o(24425);
      return null;
    }
    paramArrayOfString = paramArrayOfString[0];
    if ((paramArrayOfString == null) || (paramArrayOfString.length() <= 0))
    {
      Log.w("MicroMsg.ExtControlEntryProvider", "wrong args");
      Lp(3);
      AppMethodBeat.o(24425);
      return null;
    }
    long l;
    try
    {
      l = AESUtil.azp(paramArrayOfString);
      if (l <= 0L)
      {
        Lp(3);
        AppMethodBeat.o(24425);
        return null;
      }
    }
    catch (Exception paramArrayOfString)
    {
      Log.w("MicroMsg.ExtControlEntryProvider", paramArrayOfString.getMessage());
      Log.printErrStackTrace("MicroMsg.ExtControlEntryProvider", paramArrayOfString, "", new Object[0]);
      Lp(3);
      AppMethodBeat.o(24425);
      return null;
    }
    if (this.wtc == null)
    {
      Lp(4);
      AppMethodBeat.o(24425);
      return null;
    }
    Object localObject = new Intent();
    ((Intent)localObject).setComponent(new ComponentName(MMApplicationContext.getApplicationId(), "com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI"));
    ((Intent)localObject).putExtra("INTENT_SNS_LOCAL_ID", (int)l);
    ((Intent)localObject).addCategory("android.intent.category.DEFAULT");
    ((Intent)localObject).addFlags(268435456);
    paramArrayOfString = this.wtc;
    localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(paramArrayOfString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/ext/provider/ExtControlProviderEntry", "toSnsCommentDetail", "([Ljava/lang/String;)Landroid/database/Cursor;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramArrayOfString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramArrayOfString, "com/tencent/mm/plugin/ext/provider/ExtControlProviderEntry", "toSnsCommentDetail", "([Ljava/lang/String;)Landroid/database/Cursor;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    Lp(0);
    paramArrayOfString = com.tencent.mm.pluginsdk.e.a.a.apu(1);
    AppMethodBeat.o(24425);
    return paramArrayOfString;
  }
  
  private Cursor a(String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(24424);
    Log.i("MicroMsg.ExtControlEntryProvider", "toChattingUI");
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      Log.w("MicroMsg.ExtControlEntryProvider", "wrong args");
      gm(3, 3601);
      paramArrayOfString = com.tencent.mm.pluginsdk.e.a.a.apu(3601);
      AppMethodBeat.o(24424);
      return paramArrayOfString;
    }
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.ExtControlEntryProvider", "callSource == null");
      gm(3, 3602);
      paramArrayOfString = com.tencent.mm.pluginsdk.e.a.a.apu(3602);
      AppMethodBeat.o(24424);
      return paramArrayOfString;
    }
    paramArrayOfString = paramArrayOfString[0];
    if ((paramArrayOfString == null) || (paramArrayOfString.length() <= 0))
    {
      Log.w("MicroMsg.ExtControlEntryProvider", "contactId == null");
      gm(3, 3603);
      paramArrayOfString = com.tencent.mm.pluginsdk.e.a.a.apu(3603);
      AppMethodBeat.o(24424);
      return paramArrayOfString;
    }
    int i;
    if ((paramString != null) && (paramString.equalsIgnoreCase("openapi")))
    {
      i = 1;
      if (i == 0) {
        break label287;
      }
    }
    for (;;)
    {
      try
      {
        paramArrayOfString = b.dhi().bxx(paramArrayOfString);
        if ((paramArrayOfString == null) || (Util.isNullOrNil(paramArrayOfString.field_openId)) || (Util.isNullOrNil(paramArrayOfString.field_username)))
        {
          Log.e("MicroMsg.ExtControlEntryProvider", "openidInApp is null");
          gm(3, 3604);
          paramArrayOfString = com.tencent.mm.pluginsdk.e.a.a.apu(3604);
          AppMethodBeat.o(24424);
          return paramArrayOfString;
          i = 0;
          break;
        }
        bh.beI();
        paramArrayOfString = com.tencent.mm.model.c.bbL().RG(paramArrayOfString.field_username);
        if ((paramArrayOfString != null) && ((int)paramArrayOfString.jxt > 0) && (this.wtc != null)) {
          break label351;
        }
        Log.e("MicroMsg.ExtControlEntryProvider", "wrong args ct");
        gm(3, 3605);
        paramArrayOfString = com.tencent.mm.pluginsdk.e.a.a.apu(3605);
        AppMethodBeat.o(24424);
        return paramArrayOfString;
      }
      catch (Exception paramArrayOfString)
      {
        label287:
        Log.w("MicroMsg.ExtControlEntryProvider", paramArrayOfString.getMessage());
        Log.printErrStackTrace("MicroMsg.ExtControlEntryProvider", paramArrayOfString, "", new Object[0]);
        ad(5, 4, 12);
        paramArrayOfString = com.tencent.mm.pluginsdk.e.a.a.apu(12);
        AppMethodBeat.o(24424);
        return paramArrayOfString;
      }
      bh.beI();
      paramArrayOfString = com.tencent.mm.model.c.bbL().UT(AESUtil.azp(paramArrayOfString));
    }
    label351:
    paramString = new Intent();
    paramString.setComponent(new ComponentName(MMApplicationContext.getApplicationId(), "com.tencent.mm.ui.chatting.ChattingUI"));
    paramString.putExtra("Chat_User", paramArrayOfString.field_username);
    paramString.putExtra("finish_direct", true);
    paramString.addFlags(268435456);
    paramString.addFlags(67108864);
    paramArrayOfString = this.wtc;
    paramString = new com.tencent.mm.hellhoundlib.b.a().bm(paramString);
    com.tencent.mm.hellhoundlib.a.a.b(paramArrayOfString, paramString.aFh(), "com/tencent/mm/plugin/ext/provider/ExtControlProviderEntry", "toChattingUI", "([Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramArrayOfString.startActivity((Intent)paramString.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramArrayOfString, "com/tencent/mm/plugin/ext/provider/ExtControlProviderEntry", "toChattingUI", "([Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ad(4, 0, 1);
    paramArrayOfString = com.tencent.mm.pluginsdk.e.a.a.apu(1);
    AppMethodBeat.o(24424);
    return paramArrayOfString;
  }
  
  private Cursor z(String[] paramArrayOfString)
  {
    AppMethodBeat.i(24423);
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      Log.w("MicroMsg.ExtControlEntryProvider", "wrong args");
      Lp(3);
      AppMethodBeat.o(24423);
      return null;
    }
    paramArrayOfString = paramArrayOfString[0];
    if ((paramArrayOfString == null) || (paramArrayOfString.length() <= 0))
    {
      Log.w("MicroMsg.ExtControlEntryProvider", "contactId == null");
      Lp(3);
      AppMethodBeat.o(24423);
      return null;
    }
    try
    {
      bh.beI();
      paramArrayOfString = com.tencent.mm.model.c.bbL().UT(AESUtil.azp(paramArrayOfString));
      if ((paramArrayOfString == null) || ((int)paramArrayOfString.jxt <= 0) || (this.wtc == null))
      {
        Lp(3);
        AppMethodBeat.o(24423);
        return null;
      }
    }
    catch (Exception paramArrayOfString)
    {
      Log.w("MicroMsg.ExtControlEntryProvider", paramArrayOfString.getMessage());
      Log.printErrStackTrace("MicroMsg.ExtControlEntryProvider", paramArrayOfString, "", new Object[0]);
      Lp(3);
      AppMethodBeat.o(24423);
      return null;
    }
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    localIntent.putExtra("Contact_User", paramArrayOfString.field_username);
    com.tencent.mm.by.c.b(this.wtc, "profile", ".ui.ContactInfoUI", localIntent);
    Lp(0);
    paramArrayOfString = com.tencent.mm.pluginsdk.e.a.a.apu(1);
    AppMethodBeat.o(24423);
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
    Log.i("MicroMsg.ExtControlEntryProvider", "ExtControlProviderEntry query() mIsLocalUsed :" + this.wtb);
    if (this.wtb)
    {
      a(paramUri, this.wtc, this.wsJ, this.wsI);
      if (Util.isNullOrNil(this.wsU))
      {
        Log.e("MicroMsg.ExtControlEntryProvider", "AppID == null");
        gm(3, 7);
        paramUri = com.tencent.mm.pluginsdk.e.a.a.apu(7);
        AppMethodBeat.o(24422);
        return paramUri;
      }
      if (Util.isNullOrNil(dht()))
      {
        Log.e("MicroMsg.ExtControlEntryProvider", "PkgName == null");
        gm(3, 6);
        paramUri = com.tencent.mm.pluginsdk.e.a.a.apu(6);
        AppMethodBeat.o(24422);
        return paramUri;
      }
      int i = dhu();
      if (i != 1)
      {
        Log.e("MicroMsg.ExtControlEntryProvider", "invalid appid ! return code = ".concat(String.valueOf(i)));
        gm(2, i);
        paramUri = com.tencent.mm.pluginsdk.e.a.a.apu(i);
        AppMethodBeat.o(24422);
        return paramUri;
      }
    }
    else
    {
      this.wtc = getContext();
      a(paramUri, this.wtc, wta);
      if (paramUri == null)
      {
        Lp(3);
        AppMethodBeat.o(24422);
        return null;
      }
      if ((Util.isNullOrNil(this.wsU)) || (Util.isNullOrNil(dht())))
      {
        Lp(3);
        paramUri = com.tencent.mm.pluginsdk.e.a.a.apu(3);
        AppMethodBeat.o(24422);
        return paramUri;
      }
      if (!cxw())
      {
        Lp(1);
        paramUri = this.sgp;
        AppMethodBeat.o(24422);
        return paramUri;
      }
      if (!fj(this.wtc))
      {
        Log.w("MicroMsg.ExtControlEntryProvider", "invalid appid ! return null");
        Lp(2);
        AppMethodBeat.o(24422);
        return null;
      }
    }
    paramArrayOfString1 = Util.nullAsNil(paramUri.getQueryParameter("source"));
    if (!this.wtb) {
      this.wsJ = wta.match(paramUri);
    }
    switch (this.wsJ)
    {
    default: 
      gm(3, 15);
      AppMethodBeat.o(24422);
      return null;
    case 2: 
      paramUri = z(paramArrayOfString2);
      AppMethodBeat.o(24422);
      return paramUri;
    case 3: 
      paramUri = a(paramArrayOfString2, paramArrayOfString1);
      AppMethodBeat.o(24422);
      return paramUri;
    case 4: 
      if (this.wtc == null)
      {
        Lp(4);
        AppMethodBeat.o(24422);
        return null;
      }
      paramArrayOfString1 = new Intent();
      paramArrayOfString1.setComponent(new ComponentName(MMApplicationContext.getApplicationId(), "com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI"));
      paramArrayOfString1.addFlags(268435456);
      paramUri = this.wtc;
      paramArrayOfString1 = new com.tencent.mm.hellhoundlib.b.a().bm(paramArrayOfString1);
      com.tencent.mm.hellhoundlib.a.a.b(paramUri, paramArrayOfString1.aFh(), "com/tencent/mm/plugin/ext/provider/ExtControlProviderEntry", "toNearBy", "()Landroid/database/Cursor;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramUri.startActivity((Intent)paramArrayOfString1.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramUri, "com/tencent/mm/plugin/ext/provider/ExtControlProviderEntry", "toNearBy", "()Landroid/database/Cursor;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      Lp(0);
      paramUri = com.tencent.mm.pluginsdk.e.a.a.apu(1);
      AppMethodBeat.o(24422);
      return paramUri;
    case 5: 
      paramUri = A(paramArrayOfString2);
      AppMethodBeat.o(24422);
      return paramUri;
    }
    if ((paramArrayOfString2 == null) || (paramArrayOfString2.length <= 0))
    {
      Log.w("MicroMsg.ExtControlEntryProvider", "wrong args");
      Lp(3);
      AppMethodBeat.o(24422);
      return null;
    }
    if (this.wtc == null)
    {
      Lp(4);
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
      paramUri = this.wtc;
      paramArrayOfString1 = new com.tencent.mm.hellhoundlib.b.a().bm(paramArrayOfString1);
      com.tencent.mm.hellhoundlib.a.a.b(paramUri, paramArrayOfString1.aFh(), "com/tencent/mm/plugin/ext/provider/ExtControlProviderEntry", "toShareTimeLine", "([Ljava/lang/String;)Landroid/database/Cursor;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramUri.startActivity((Intent)paramArrayOfString1.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramUri, "com/tencent/mm/plugin/ext/provider/ExtControlProviderEntry", "toShareTimeLine", "([Ljava/lang/String;)Landroid/database/Cursor;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      Lp(0);
      paramUri = com.tencent.mm.pluginsdk.e.a.a.apu(1);
      AppMethodBeat.o(24422);
      return paramUri;
    }
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.provider.ExtControlProviderEntry
 * JD-Core Version:    0.7.0.1
 */