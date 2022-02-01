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
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.ext.b;
import com.tencent.mm.plugin.ext.key.AESUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatAuthorities;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.cr;
import com.tencent.mm.storage.cs;

@JgClassChecked(author=32, fComment="checked", lastDate="20141016", reviewer=20, vComment={com.jg.EType.PROVIDERCHECK})
public class ExtControlProviderEntry
  extends ExtContentProviderBase
{
  private static final UriMatcher sNf;
  private String[] sMN = null;
  private int sMO = -1;
  private boolean sNg = false;
  private Context sNh;
  
  static
  {
    AppMethodBeat.i(24426);
    UriMatcher localUriMatcher = new UriMatcher(-1);
    sNf = localUriMatcher;
    localUriMatcher.addURI(WeChatAuthorities.AUTHORITIES_PLUGIN_EXT_ENTRY(), "view_profile", 2);
    sNf.addURI(WeChatAuthorities.AUTHORITIES_PLUGIN_EXT_ENTRY(), "to_chatting", 3);
    sNf.addURI(WeChatAuthorities.AUTHORITIES_PLUGIN_EXT_ENTRY(), "to_nearby", 4);
    sNf.addURI(WeChatAuthorities.AUTHORITIES_PLUGIN_EXT_ENTRY(), "sns_comment_detail", 5);
    sNf.addURI(WeChatAuthorities.AUTHORITIES_PLUGIN_EXT_ENTRY(), "share_time_line", 6);
    AppMethodBeat.o(24426);
  }
  
  public ExtControlProviderEntry() {}
  
  public ExtControlProviderEntry(String[] paramArrayOfString, int paramInt, Context paramContext)
  {
    this.sNg = true;
    this.sMN = paramArrayOfString;
    this.sMO = paramInt;
    this.sNh = paramContext;
  }
  
  private Cursor A(String[] paramArrayOfString)
  {
    AppMethodBeat.i(24423);
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      Log.w("MicroMsg.ExtControlEntryProvider", "wrong args");
      HF(3);
      AppMethodBeat.o(24423);
      return null;
    }
    paramArrayOfString = paramArrayOfString[0];
    if ((paramArrayOfString == null) || (paramArrayOfString.length() <= 0))
    {
      Log.w("MicroMsg.ExtControlEntryProvider", "contactId == null");
      HF(3);
      AppMethodBeat.o(24423);
      return null;
    }
    try
    {
      bg.aVF();
      paramArrayOfString = com.tencent.mm.model.c.aSN().Nh(AESUtil.aro(paramArrayOfString));
      if ((paramArrayOfString == null) || ((int)paramArrayOfString.gMZ <= 0) || (this.sNh == null))
      {
        HF(3);
        AppMethodBeat.o(24423);
        return null;
      }
    }
    catch (Exception paramArrayOfString)
    {
      Log.w("MicroMsg.ExtControlEntryProvider", paramArrayOfString.getMessage());
      Log.printErrStackTrace("MicroMsg.ExtControlEntryProvider", paramArrayOfString, "", new Object[0]);
      HF(3);
      AppMethodBeat.o(24423);
      return null;
    }
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    localIntent.putExtra("Contact_User", paramArrayOfString.field_username);
    com.tencent.mm.br.c.b(this.sNh, "profile", ".ui.ContactInfoUI", localIntent);
    HF(0);
    paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.ahx(1);
    AppMethodBeat.o(24423);
    return paramArrayOfString;
  }
  
  private Cursor B(String[] paramArrayOfString)
  {
    AppMethodBeat.i(24425);
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      Log.w("MicroMsg.ExtControlEntryProvider", "wrong args");
      HF(3);
      AppMethodBeat.o(24425);
      return null;
    }
    paramArrayOfString = paramArrayOfString[0];
    if ((paramArrayOfString == null) || (paramArrayOfString.length() <= 0))
    {
      Log.w("MicroMsg.ExtControlEntryProvider", "wrong args");
      HF(3);
      AppMethodBeat.o(24425);
      return null;
    }
    long l;
    try
    {
      l = AESUtil.aro(paramArrayOfString);
      if (l <= 0L)
      {
        HF(3);
        AppMethodBeat.o(24425);
        return null;
      }
    }
    catch (Exception paramArrayOfString)
    {
      Log.w("MicroMsg.ExtControlEntryProvider", paramArrayOfString.getMessage());
      Log.printErrStackTrace("MicroMsg.ExtControlEntryProvider", paramArrayOfString, "", new Object[0]);
      HF(3);
      AppMethodBeat.o(24425);
      return null;
    }
    if (this.sNh == null)
    {
      HF(4);
      AppMethodBeat.o(24425);
      return null;
    }
    Object localObject = new Intent();
    ((Intent)localObject).setComponent(new ComponentName(MMApplicationContext.getApplicationId(), "com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI"));
    ((Intent)localObject).putExtra("INTENT_SNS_LOCAL_ID", (int)l);
    ((Intent)localObject).addCategory("android.intent.category.DEFAULT");
    ((Intent)localObject).addFlags(268435456);
    paramArrayOfString = this.sNh;
    localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramArrayOfString, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/ext/provider/ExtControlProviderEntry", "toSnsCommentDetail", "([Ljava/lang/String;)Landroid/database/Cursor;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramArrayOfString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramArrayOfString, "com/tencent/mm/plugin/ext/provider/ExtControlProviderEntry", "toSnsCommentDetail", "([Ljava/lang/String;)Landroid/database/Cursor;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    HF(0);
    paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.ahx(1);
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
      fP(3, 3601);
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.ahx(3601);
      AppMethodBeat.o(24424);
      return paramArrayOfString;
    }
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.ExtControlEntryProvider", "callSource == null");
      fP(3, 3602);
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.ahx(3602);
      AppMethodBeat.o(24424);
      return paramArrayOfString;
    }
    paramArrayOfString = paramArrayOfString[0];
    if ((paramArrayOfString == null) || (paramArrayOfString.length() <= 0))
    {
      Log.w("MicroMsg.ExtControlEntryProvider", "contactId == null");
      fP(3, 3603);
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.ahx(3603);
      AppMethodBeat.o(24424);
      return paramArrayOfString;
    }
    int i;
    if ((paramString != null) && (paramString.equalsIgnoreCase("openapi")))
    {
      i = 1;
      if (i == 0) {
        break label290;
      }
    }
    for (;;)
    {
      try
      {
        paramArrayOfString = b.cSi().bkX(paramArrayOfString);
        if ((paramArrayOfString == null) || (Util.isNullOrNil(paramArrayOfString.field_openId)) || (Util.isNullOrNil(paramArrayOfString.field_username)))
        {
          Log.e("MicroMsg.ExtControlEntryProvider", "openidInApp is null");
          fP(3, 3604);
          paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.ahx(3604);
          AppMethodBeat.o(24424);
          return paramArrayOfString;
          i = 0;
          break;
        }
        bg.aVF();
        paramArrayOfString = com.tencent.mm.model.c.aSN().Kn(paramArrayOfString.field_username);
        if ((paramArrayOfString != null) && ((int)paramArrayOfString.gMZ > 0) && (this.sNh != null)) {
          break label354;
        }
        Log.e("MicroMsg.ExtControlEntryProvider", "wrong args ct");
        fP(3, 3605);
        paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.ahx(3605);
        AppMethodBeat.o(24424);
        return paramArrayOfString;
      }
      catch (Exception paramArrayOfString)
      {
        label290:
        Log.w("MicroMsg.ExtControlEntryProvider", paramArrayOfString.getMessage());
        Log.printErrStackTrace("MicroMsg.ExtControlEntryProvider", paramArrayOfString, "", new Object[0]);
        ac(5, 4, 12);
        paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.ahx(12);
        AppMethodBeat.o(24424);
        return paramArrayOfString;
      }
      bg.aVF();
      paramArrayOfString = com.tencent.mm.model.c.aSN().Nh(AESUtil.aro(paramArrayOfString));
    }
    label354:
    paramString = new Intent();
    paramString.setComponent(new ComponentName(MMApplicationContext.getApplicationId(), "com.tencent.mm.ui.chatting.ChattingUI"));
    paramString.putExtra("Chat_User", paramArrayOfString.field_username);
    paramString.putExtra("finish_direct", true);
    paramString.addFlags(268435456);
    paramString.addFlags(67108864);
    paramArrayOfString = this.sNh;
    paramString = new com.tencent.mm.hellhoundlib.b.a().bl(paramString);
    com.tencent.mm.hellhoundlib.a.a.a(paramArrayOfString, paramString.axQ(), "com/tencent/mm/plugin/ext/provider/ExtControlProviderEntry", "toChattingUI", "([Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramArrayOfString.startActivity((Intent)paramString.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramArrayOfString, "com/tencent/mm/plugin/ext/provider/ExtControlProviderEntry", "toChattingUI", "([Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ac(4, 0, 1);
    paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.ahx(1);
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
    Log.i("MicroMsg.ExtControlEntryProvider", "ExtControlProviderEntry query() mIsLocalUsed :" + this.sNg);
    if (this.sNg)
    {
      a(paramUri, this.sNh, this.sMO, this.sMN);
      if (Util.isNullOrNil(this.sMZ))
      {
        Log.e("MicroMsg.ExtControlEntryProvider", "AppID == null");
        fP(3, 7);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.ahx(7);
        AppMethodBeat.o(24422);
        return paramUri;
      }
      if (Util.isNullOrNil(cSt()))
      {
        Log.e("MicroMsg.ExtControlEntryProvider", "PkgName == null");
        fP(3, 6);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.ahx(6);
        AppMethodBeat.o(24422);
        return paramUri;
      }
      int i = cSu();
      if (i != 1)
      {
        Log.e("MicroMsg.ExtControlEntryProvider", "invalid appid ! return code = ".concat(String.valueOf(i)));
        fP(2, i);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.ahx(i);
        AppMethodBeat.o(24422);
        return paramUri;
      }
    }
    else
    {
      this.sNh = getContext();
      a(paramUri, this.sNh, sNf);
      if (paramUri == null)
      {
        HF(3);
        AppMethodBeat.o(24422);
        return null;
      }
      if ((Util.isNullOrNil(this.sMZ)) || (Util.isNullOrNil(cSt())))
      {
        HF(3);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.ahx(3);
        AppMethodBeat.o(24422);
        return paramUri;
      }
      if (!ckf())
      {
        HF(1);
        paramUri = this.pem;
        AppMethodBeat.o(24422);
        return paramUri;
      }
      if (!fe(this.sNh))
      {
        Log.w("MicroMsg.ExtControlEntryProvider", "invalid appid ! return null");
        HF(2);
        AppMethodBeat.o(24422);
        return null;
      }
    }
    paramArrayOfString1 = Util.nullAsNil(paramUri.getQueryParameter("source"));
    if (!this.sNg) {
      this.sMO = sNf.match(paramUri);
    }
    switch (this.sMO)
    {
    default: 
      fP(3, 15);
      AppMethodBeat.o(24422);
      return null;
    case 2: 
      paramUri = A(paramArrayOfString2);
      AppMethodBeat.o(24422);
      return paramUri;
    case 3: 
      paramUri = a(paramArrayOfString2, paramArrayOfString1);
      AppMethodBeat.o(24422);
      return paramUri;
    case 4: 
      if (this.sNh == null)
      {
        HF(4);
        AppMethodBeat.o(24422);
        return null;
      }
      paramArrayOfString1 = new Intent();
      paramArrayOfString1.setComponent(new ComponentName(MMApplicationContext.getApplicationId(), "com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI"));
      paramArrayOfString1.addFlags(268435456);
      paramUri = this.sNh;
      paramArrayOfString1 = new com.tencent.mm.hellhoundlib.b.a().bl(paramArrayOfString1);
      com.tencent.mm.hellhoundlib.a.a.a(paramUri, paramArrayOfString1.axQ(), "com/tencent/mm/plugin/ext/provider/ExtControlProviderEntry", "toNearBy", "()Landroid/database/Cursor;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramUri.startActivity((Intent)paramArrayOfString1.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramUri, "com/tencent/mm/plugin/ext/provider/ExtControlProviderEntry", "toNearBy", "()Landroid/database/Cursor;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      HF(0);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.ahx(1);
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
      HF(3);
      AppMethodBeat.o(24422);
      return null;
    }
    if (this.sNh == null)
    {
      HF(4);
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
      paramUri = this.sNh;
      paramArrayOfString1 = new com.tencent.mm.hellhoundlib.b.a().bl(paramArrayOfString1);
      com.tencent.mm.hellhoundlib.a.a.a(paramUri, paramArrayOfString1.axQ(), "com/tencent/mm/plugin/ext/provider/ExtControlProviderEntry", "toShareTimeLine", "([Ljava/lang/String;)Landroid/database/Cursor;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramUri.startActivity((Intent)paramArrayOfString1.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramUri, "com/tencent/mm/plugin/ext/provider/ExtControlProviderEntry", "toShareTimeLine", "([Ljava/lang/String;)Landroid/database/Cursor;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      HF(0);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.ahx(1);
      AppMethodBeat.o(24422);
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