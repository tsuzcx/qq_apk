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
import com.tencent.mm.bs.d;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.ext.key.AESUtil;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.cb;

@JgClassChecked(author=32, fComment="checked", lastDate="20141016", reviewer=20, vComment={com.jg.EType.PROVIDERCHECK})
public class ExtControlProviderEntry
  extends ExtContentProviderBase
{
  private static final UriMatcher pKZ;
  private String[] pKH = null;
  private int pKI = -1;
  private boolean pLa = false;
  private Context pLb;
  
  static
  {
    AppMethodBeat.i(24426);
    UriMatcher localUriMatcher = new UriMatcher(-1);
    pKZ = localUriMatcher;
    localUriMatcher.addURI("com.tencent.mm.plugin.ext.entry", "view_profile", 2);
    pKZ.addURI("com.tencent.mm.plugin.ext.entry", "to_chatting", 3);
    pKZ.addURI("com.tencent.mm.plugin.ext.entry", "to_nearby", 4);
    pKZ.addURI("com.tencent.mm.plugin.ext.entry", "sns_comment_detail", 5);
    pKZ.addURI("com.tencent.mm.plugin.ext.entry", "share_time_line", 6);
    AppMethodBeat.o(24426);
  }
  
  public ExtControlProviderEntry() {}
  
  public ExtControlProviderEntry(String[] paramArrayOfString, int paramInt, Context paramContext)
  {
    this.pLa = true;
    this.pKH = paramArrayOfString;
    this.pKI = paramInt;
    this.pLb = paramContext;
  }
  
  private Cursor a(String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(24424);
    ad.i("MicroMsg.ExtControlEntryProvider", "toChattingUI");
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      ad.w("MicroMsg.ExtControlEntryProvider", "wrong args");
      fq(3, 3601);
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Ue(3601);
      AppMethodBeat.o(24424);
      return paramArrayOfString;
    }
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.ExtControlEntryProvider", "callSource == null");
      fq(3, 3602);
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Ue(3602);
      AppMethodBeat.o(24424);
      return paramArrayOfString;
    }
    paramArrayOfString = paramArrayOfString[0];
    if ((paramArrayOfString == null) || (paramArrayOfString.length() <= 0))
    {
      ad.w("MicroMsg.ExtControlEntryProvider", "contactId == null");
      fq(3, 3603);
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Ue(3603);
      AppMethodBeat.o(24424);
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
        paramArrayOfString = com.tencent.mm.plugin.ext.b.ceM().aJl(paramArrayOfString);
        if ((paramArrayOfString == null) || (bt.isNullOrNil(paramArrayOfString.field_openId)) || (bt.isNullOrNil(paramArrayOfString.field_username)))
        {
          ad.e("MicroMsg.ExtControlEntryProvider", "openidInApp is null");
          fq(3, 3604);
          paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Ue(3604);
          AppMethodBeat.o(24424);
          return paramArrayOfString;
          i = 0;
          break;
        }
        az.arV();
        paramArrayOfString = c.apM().aHY(paramArrayOfString.field_username);
        if ((paramArrayOfString != null) && ((int)paramArrayOfString.fId > 0) && (this.pLb != null)) {
          break label350;
        }
        ad.e("MicroMsg.ExtControlEntryProvider", "wrong args ct");
        fq(3, 3605);
        paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Ue(3605);
        AppMethodBeat.o(24424);
        return paramArrayOfString;
      }
      catch (Exception paramArrayOfString)
      {
        label286:
        ad.w("MicroMsg.ExtControlEntryProvider", paramArrayOfString.getMessage());
        ad.printErrStackTrace("MicroMsg.ExtControlEntryProvider", paramArrayOfString, "", new Object[0]);
        Y(5, 4, 12);
        paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Ue(12);
        AppMethodBeat.o(24424);
        return paramArrayOfString;
      }
      az.arV();
      paramArrayOfString = c.apM().wl(AESUtil.Xw(paramArrayOfString));
    }
    label350:
    paramString = new Intent();
    paramString.setComponent(new ComponentName("com.tencent.mm", "com.tencent.mm.ui.chatting.ChattingUI"));
    paramString.putExtra("Chat_User", paramArrayOfString.field_username);
    paramString.putExtra("finish_direct", true);
    paramString.addFlags(268435456);
    paramString.addFlags(67108864);
    paramArrayOfString = this.pLb;
    paramString = new com.tencent.mm.hellhoundlib.b.a().bd(paramString);
    com.tencent.mm.hellhoundlib.a.a.a(paramArrayOfString, paramString.adn(), "com/tencent/mm/plugin/ext/provider/ExtControlProviderEntry", "toChattingUI", "([Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramArrayOfString.startActivity((Intent)paramString.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramArrayOfString, "com/tencent/mm/plugin/ext/provider/ExtControlProviderEntry", "toChattingUI", "([Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    Y(4, 0, 1);
    paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Ue(1);
    AppMethodBeat.o(24424);
    return paramArrayOfString;
  }
  
  private Cursor x(String[] paramArrayOfString)
  {
    AppMethodBeat.i(24423);
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      ad.w("MicroMsg.ExtControlEntryProvider", "wrong args");
      BS(3);
      AppMethodBeat.o(24423);
      return null;
    }
    paramArrayOfString = paramArrayOfString[0];
    if ((paramArrayOfString == null) || (paramArrayOfString.length() <= 0))
    {
      ad.w("MicroMsg.ExtControlEntryProvider", "contactId == null");
      BS(3);
      AppMethodBeat.o(24423);
      return null;
    }
    try
    {
      az.arV();
      paramArrayOfString = c.apM().wl(AESUtil.Xw(paramArrayOfString));
      if ((paramArrayOfString == null) || ((int)paramArrayOfString.fId <= 0) || (this.pLb == null))
      {
        BS(3);
        AppMethodBeat.o(24423);
        return null;
      }
    }
    catch (Exception paramArrayOfString)
    {
      ad.w("MicroMsg.ExtControlEntryProvider", paramArrayOfString.getMessage());
      ad.printErrStackTrace("MicroMsg.ExtControlEntryProvider", paramArrayOfString, "", new Object[0]);
      BS(3);
      AppMethodBeat.o(24423);
      return null;
    }
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    localIntent.putExtra("Contact_User", paramArrayOfString.field_username);
    d.b(this.pLb, "profile", ".ui.ContactInfoUI", localIntent);
    BS(0);
    paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Ue(1);
    AppMethodBeat.o(24423);
    return paramArrayOfString;
  }
  
  private Cursor y(String[] paramArrayOfString)
  {
    AppMethodBeat.i(24425);
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      ad.w("MicroMsg.ExtControlEntryProvider", "wrong args");
      BS(3);
      AppMethodBeat.o(24425);
      return null;
    }
    paramArrayOfString = paramArrayOfString[0];
    if ((paramArrayOfString == null) || (paramArrayOfString.length() <= 0))
    {
      ad.w("MicroMsg.ExtControlEntryProvider", "wrong args");
      BS(3);
      AppMethodBeat.o(24425);
      return null;
    }
    long l;
    try
    {
      l = AESUtil.Xw(paramArrayOfString);
      if (l <= 0L)
      {
        BS(3);
        AppMethodBeat.o(24425);
        return null;
      }
    }
    catch (Exception paramArrayOfString)
    {
      ad.w("MicroMsg.ExtControlEntryProvider", paramArrayOfString.getMessage());
      ad.printErrStackTrace("MicroMsg.ExtControlEntryProvider", paramArrayOfString, "", new Object[0]);
      BS(3);
      AppMethodBeat.o(24425);
      return null;
    }
    if (this.pLb == null)
    {
      BS(4);
      AppMethodBeat.o(24425);
      return null;
    }
    Object localObject = new Intent();
    ((Intent)localObject).setComponent(new ComponentName("com.tencent.mm", "com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI"));
    ((Intent)localObject).putExtra("INTENT_SNS_LOCAL_ID", (int)l);
    ((Intent)localObject).addCategory("android.intent.category.DEFAULT");
    ((Intent)localObject).addFlags(268435456);
    paramArrayOfString = this.pLb;
    localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramArrayOfString, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/ext/provider/ExtControlProviderEntry", "toSnsCommentDetail", "([Ljava/lang/String;)Landroid/database/Cursor;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramArrayOfString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramArrayOfString, "com/tencent/mm/plugin/ext/provider/ExtControlProviderEntry", "toSnsCommentDetail", "([Ljava/lang/String;)Landroid/database/Cursor;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    BS(0);
    paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Ue(1);
    AppMethodBeat.o(24425);
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
    ad.i("MicroMsg.ExtControlEntryProvider", "ExtControlProviderEntry query() mIsLocalUsed :" + this.pLa);
    if (this.pLa)
    {
      a(paramUri, this.pLb, this.pKI, this.pKH);
      if (bt.isNullOrNil(this.pKT))
      {
        ad.e("MicroMsg.ExtControlEntryProvider", "AppID == null");
        fq(3, 7);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Ue(7);
        AppMethodBeat.o(24422);
        return paramUri;
      }
      if (bt.isNullOrNil(ceX()))
      {
        ad.e("MicroMsg.ExtControlEntryProvider", "PkgName == null");
        fq(3, 6);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Ue(6);
        AppMethodBeat.o(24422);
        return paramUri;
      }
      int i = ceY();
      if (i != 1)
      {
        ad.e("MicroMsg.ExtControlEntryProvider", "invalid appid ! return code = ".concat(String.valueOf(i)));
        fq(2, i);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Ue(i);
        AppMethodBeat.o(24422);
        return paramUri;
      }
    }
    else
    {
      this.pLb = getContext();
      a(paramUri, this.pLb, pKZ);
      if (paramUri == null)
      {
        BS(3);
        AppMethodBeat.o(24422);
        return null;
      }
      if ((bt.isNullOrNil(this.pKT)) || (bt.isNullOrNil(ceX())))
      {
        BS(3);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Ue(3);
        AppMethodBeat.o(24422);
        return paramUri;
      }
      if (!bBg())
      {
        BS(1);
        paramUri = this.mKX;
        AppMethodBeat.o(24422);
        return paramUri;
      }
      if (!ey(this.pLb))
      {
        ad.w("MicroMsg.ExtControlEntryProvider", "invalid appid ! return null");
        BS(2);
        AppMethodBeat.o(24422);
        return null;
      }
    }
    paramArrayOfString1 = bt.nullAsNil(paramUri.getQueryParameter("source"));
    if (!this.pLa) {
      this.pKI = pKZ.match(paramUri);
    }
    switch (this.pKI)
    {
    default: 
      fq(3, 15);
      AppMethodBeat.o(24422);
      return null;
    case 2: 
      paramUri = x(paramArrayOfString2);
      AppMethodBeat.o(24422);
      return paramUri;
    case 3: 
      paramUri = a(paramArrayOfString2, paramArrayOfString1);
      AppMethodBeat.o(24422);
      return paramUri;
    case 4: 
      if (this.pLb == null)
      {
        BS(4);
        AppMethodBeat.o(24422);
        return null;
      }
      paramArrayOfString1 = new Intent();
      paramArrayOfString1.setComponent(new ComponentName("com.tencent.mm", "com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI"));
      paramArrayOfString1.addFlags(268435456);
      paramUri = this.pLb;
      paramArrayOfString1 = new com.tencent.mm.hellhoundlib.b.a().bd(paramArrayOfString1);
      com.tencent.mm.hellhoundlib.a.a.a(paramUri, paramArrayOfString1.adn(), "com/tencent/mm/plugin/ext/provider/ExtControlProviderEntry", "toNearBy", "()Landroid/database/Cursor;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramUri.startActivity((Intent)paramArrayOfString1.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramUri, "com/tencent/mm/plugin/ext/provider/ExtControlProviderEntry", "toNearBy", "()Landroid/database/Cursor;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      BS(0);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Ue(1);
      AppMethodBeat.o(24422);
      return paramUri;
    case 5: 
      paramUri = y(paramArrayOfString2);
      AppMethodBeat.o(24422);
      return paramUri;
    }
    if ((paramArrayOfString2 == null) || (paramArrayOfString2.length <= 0))
    {
      ad.w("MicroMsg.ExtControlEntryProvider", "wrong args");
      BS(3);
      AppMethodBeat.o(24422);
      return null;
    }
    if (this.pLb == null)
    {
      BS(4);
      AppMethodBeat.o(24422);
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
      paramUri = this.pLb;
      paramArrayOfString1 = new com.tencent.mm.hellhoundlib.b.a().bd(paramArrayOfString1);
      com.tencent.mm.hellhoundlib.a.a.a(paramUri, paramArrayOfString1.adn(), "com/tencent/mm/plugin/ext/provider/ExtControlProviderEntry", "toShareTimeLine", "([Ljava/lang/String;)Landroid/database/Cursor;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramUri.startActivity((Intent)paramArrayOfString1.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramUri, "com/tencent/mm/plugin/ext/provider/ExtControlProviderEntry", "toShareTimeLine", "([Ljava/lang/String;)Landroid/database/Cursor;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      BS(0);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Ue(1);
      AppMethodBeat.o(24422);
      return paramUri;
    }
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.provider.ExtControlProviderEntry
 * JD-Core Version:    0.7.0.1
 */