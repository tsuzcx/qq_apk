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
import com.tencent.mm.br.d;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.ext.key.AESUtil;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.cd;
import com.tencent.mm.storage.ce;

@JgClassChecked(author=32, fComment="checked", lastDate="20141016", reviewer=20, vComment={com.jg.EType.PROVIDERCHECK})
public class ExtControlProviderEntry
  extends ExtContentProviderBase
{
  private static final UriMatcher qtG;
  private boolean qtH = false;
  private Context qtI;
  private String[] qto = null;
  private int qtp = -1;
  
  static
  {
    AppMethodBeat.i(24426);
    UriMatcher localUriMatcher = new UriMatcher(-1);
    qtG = localUriMatcher;
    localUriMatcher.addURI("com.tencent.mm.plugin.ext.entry", "view_profile", 2);
    qtG.addURI("com.tencent.mm.plugin.ext.entry", "to_chatting", 3);
    qtG.addURI("com.tencent.mm.plugin.ext.entry", "to_nearby", 4);
    qtG.addURI("com.tencent.mm.plugin.ext.entry", "sns_comment_detail", 5);
    qtG.addURI("com.tencent.mm.plugin.ext.entry", "share_time_line", 6);
    AppMethodBeat.o(24426);
  }
  
  public ExtControlProviderEntry() {}
  
  public ExtControlProviderEntry(String[] paramArrayOfString, int paramInt, Context paramContext)
  {
    this.qtH = true;
    this.qto = paramArrayOfString;
    this.qtp = paramInt;
    this.qtI = paramContext;
  }
  
  private Cursor a(String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(24424);
    ac.i("MicroMsg.ExtControlEntryProvider", "toChattingUI");
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      ac.w("MicroMsg.ExtControlEntryProvider", "wrong args");
      ft(3, 3601);
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Wo(3601);
      AppMethodBeat.o(24424);
      return paramArrayOfString;
    }
    if (bs.isNullOrNil(paramString))
    {
      ac.w("MicroMsg.ExtControlEntryProvider", "callSource == null");
      ft(3, 3602);
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Wo(3602);
      AppMethodBeat.o(24424);
      return paramArrayOfString;
    }
    paramArrayOfString = paramArrayOfString[0];
    if ((paramArrayOfString == null) || (paramArrayOfString.length() <= 0))
    {
      ac.w("MicroMsg.ExtControlEntryProvider", "contactId == null");
      ft(3, 3603);
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Wo(3603);
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
        paramArrayOfString = com.tencent.mm.plugin.ext.b.cmt().aOH(paramArrayOfString);
        if ((paramArrayOfString == null) || (bs.isNullOrNil(paramArrayOfString.field_openId)) || (bs.isNullOrNil(paramArrayOfString.field_username)))
        {
          ac.e("MicroMsg.ExtControlEntryProvider", "openidInApp is null");
          ft(3, 3604);
          paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Wo(3604);
          AppMethodBeat.o(24424);
          return paramArrayOfString;
          i = 0;
          break;
        }
        az.ayM();
        paramArrayOfString = c.awB().aNt(paramArrayOfString.field_username);
        if ((paramArrayOfString != null) && ((int)paramArrayOfString.fLJ > 0) && (this.qtI != null)) {
          break label350;
        }
        ac.e("MicroMsg.ExtControlEntryProvider", "wrong args ct");
        ft(3, 3605);
        paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Wo(3605);
        AppMethodBeat.o(24424);
        return paramArrayOfString;
      }
      catch (Exception paramArrayOfString)
      {
        label286:
        ac.w("MicroMsg.ExtControlEntryProvider", paramArrayOfString.getMessage());
        ac.printErrStackTrace("MicroMsg.ExtControlEntryProvider", paramArrayOfString, "", new Object[0]);
        Z(5, 4, 12);
        paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Wo(12);
        AppMethodBeat.o(24424);
        return paramArrayOfString;
      }
      az.ayM();
      paramArrayOfString = c.awB().AO(AESUtil.abT(paramArrayOfString));
    }
    label350:
    paramString = new Intent();
    paramString.setComponent(new ComponentName("com.tencent.mm", "com.tencent.mm.ui.chatting.ChattingUI"));
    paramString.putExtra("Chat_User", paramArrayOfString.field_username);
    paramString.putExtra("finish_direct", true);
    paramString.addFlags(268435456);
    paramString.addFlags(67108864);
    paramArrayOfString = this.qtI;
    paramString = new com.tencent.mm.hellhoundlib.b.a().ba(paramString);
    com.tencent.mm.hellhoundlib.a.a.a(paramArrayOfString, paramString.aeD(), "com/tencent/mm/plugin/ext/provider/ExtControlProviderEntry", "toChattingUI", "([Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramArrayOfString.startActivity((Intent)paramString.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramArrayOfString, "com/tencent/mm/plugin/ext/provider/ExtControlProviderEntry", "toChattingUI", "([Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    Z(4, 0, 1);
    paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Wo(1);
    AppMethodBeat.o(24424);
    return paramArrayOfString;
  }
  
  private Cursor x(String[] paramArrayOfString)
  {
    AppMethodBeat.i(24423);
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      ac.w("MicroMsg.ExtControlEntryProvider", "wrong args");
      CN(3);
      AppMethodBeat.o(24423);
      return null;
    }
    paramArrayOfString = paramArrayOfString[0];
    if ((paramArrayOfString == null) || (paramArrayOfString.length() <= 0))
    {
      ac.w("MicroMsg.ExtControlEntryProvider", "contactId == null");
      CN(3);
      AppMethodBeat.o(24423);
      return null;
    }
    try
    {
      az.ayM();
      paramArrayOfString = c.awB().AO(AESUtil.abT(paramArrayOfString));
      if ((paramArrayOfString == null) || ((int)paramArrayOfString.fLJ <= 0) || (this.qtI == null))
      {
        CN(3);
        AppMethodBeat.o(24423);
        return null;
      }
    }
    catch (Exception paramArrayOfString)
    {
      ac.w("MicroMsg.ExtControlEntryProvider", paramArrayOfString.getMessage());
      ac.printErrStackTrace("MicroMsg.ExtControlEntryProvider", paramArrayOfString, "", new Object[0]);
      CN(3);
      AppMethodBeat.o(24423);
      return null;
    }
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    localIntent.putExtra("Contact_User", paramArrayOfString.field_username);
    d.b(this.qtI, "profile", ".ui.ContactInfoUI", localIntent);
    CN(0);
    paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Wo(1);
    AppMethodBeat.o(24423);
    return paramArrayOfString;
  }
  
  private Cursor y(String[] paramArrayOfString)
  {
    AppMethodBeat.i(24425);
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      ac.w("MicroMsg.ExtControlEntryProvider", "wrong args");
      CN(3);
      AppMethodBeat.o(24425);
      return null;
    }
    paramArrayOfString = paramArrayOfString[0];
    if ((paramArrayOfString == null) || (paramArrayOfString.length() <= 0))
    {
      ac.w("MicroMsg.ExtControlEntryProvider", "wrong args");
      CN(3);
      AppMethodBeat.o(24425);
      return null;
    }
    long l;
    try
    {
      l = AESUtil.abT(paramArrayOfString);
      if (l <= 0L)
      {
        CN(3);
        AppMethodBeat.o(24425);
        return null;
      }
    }
    catch (Exception paramArrayOfString)
    {
      ac.w("MicroMsg.ExtControlEntryProvider", paramArrayOfString.getMessage());
      ac.printErrStackTrace("MicroMsg.ExtControlEntryProvider", paramArrayOfString, "", new Object[0]);
      CN(3);
      AppMethodBeat.o(24425);
      return null;
    }
    if (this.qtI == null)
    {
      CN(4);
      AppMethodBeat.o(24425);
      return null;
    }
    Object localObject = new Intent();
    ((Intent)localObject).setComponent(new ComponentName("com.tencent.mm", "com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI"));
    ((Intent)localObject).putExtra("INTENT_SNS_LOCAL_ID", (int)l);
    ((Intent)localObject).addCategory("android.intent.category.DEFAULT");
    ((Intent)localObject).addFlags(268435456);
    paramArrayOfString = this.qtI;
    localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramArrayOfString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/ext/provider/ExtControlProviderEntry", "toSnsCommentDetail", "([Ljava/lang/String;)Landroid/database/Cursor;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramArrayOfString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramArrayOfString, "com/tencent/mm/plugin/ext/provider/ExtControlProviderEntry", "toSnsCommentDetail", "([Ljava/lang/String;)Landroid/database/Cursor;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    CN(0);
    paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Wo(1);
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
    ac.i("MicroMsg.ExtControlEntryProvider", "ExtControlProviderEntry query() mIsLocalUsed :" + this.qtH);
    if (this.qtH)
    {
      a(paramUri, this.qtI, this.qtp, this.qto);
      if (bs.isNullOrNil(this.qtA))
      {
        ac.e("MicroMsg.ExtControlEntryProvider", "AppID == null");
        ft(3, 7);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Wo(7);
        AppMethodBeat.o(24422);
        return paramUri;
      }
      if (bs.isNullOrNil(cmE()))
      {
        ac.e("MicroMsg.ExtControlEntryProvider", "PkgName == null");
        ft(3, 6);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Wo(6);
        AppMethodBeat.o(24422);
        return paramUri;
      }
      int i = cmF();
      if (i != 1)
      {
        ac.e("MicroMsg.ExtControlEntryProvider", "invalid appid ! return code = ".concat(String.valueOf(i)));
        ft(2, i);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Wo(i);
        AppMethodBeat.o(24422);
        return paramUri;
      }
    }
    else
    {
      this.qtI = getContext();
      a(paramUri, this.qtI, qtG);
      if (paramUri == null)
      {
        CN(3);
        AppMethodBeat.o(24422);
        return null;
      }
      if ((bs.isNullOrNil(this.qtA)) || (bs.isNullOrNil(cmE())))
      {
        CN(3);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Wo(3);
        AppMethodBeat.o(24422);
        return paramUri;
      }
      if (!bIc())
      {
        CN(1);
        paramUri = this.nng;
        AppMethodBeat.o(24422);
        return paramUri;
      }
      if (!eG(this.qtI))
      {
        ac.w("MicroMsg.ExtControlEntryProvider", "invalid appid ! return null");
        CN(2);
        AppMethodBeat.o(24422);
        return null;
      }
    }
    paramArrayOfString1 = bs.nullAsNil(paramUri.getQueryParameter("source"));
    if (!this.qtH) {
      this.qtp = qtG.match(paramUri);
    }
    switch (this.qtp)
    {
    default: 
      ft(3, 15);
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
      if (this.qtI == null)
      {
        CN(4);
        AppMethodBeat.o(24422);
        return null;
      }
      paramArrayOfString1 = new Intent();
      paramArrayOfString1.setComponent(new ComponentName("com.tencent.mm", "com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI"));
      paramArrayOfString1.addFlags(268435456);
      paramUri = this.qtI;
      paramArrayOfString1 = new com.tencent.mm.hellhoundlib.b.a().ba(paramArrayOfString1);
      com.tencent.mm.hellhoundlib.a.a.a(paramUri, paramArrayOfString1.aeD(), "com/tencent/mm/plugin/ext/provider/ExtControlProviderEntry", "toNearBy", "()Landroid/database/Cursor;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramUri.startActivity((Intent)paramArrayOfString1.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramUri, "com/tencent/mm/plugin/ext/provider/ExtControlProviderEntry", "toNearBy", "()Landroid/database/Cursor;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      CN(0);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Wo(1);
      AppMethodBeat.o(24422);
      return paramUri;
    case 5: 
      paramUri = y(paramArrayOfString2);
      AppMethodBeat.o(24422);
      return paramUri;
    }
    if ((paramArrayOfString2 == null) || (paramArrayOfString2.length <= 0))
    {
      ac.w("MicroMsg.ExtControlEntryProvider", "wrong args");
      CN(3);
      AppMethodBeat.o(24422);
      return null;
    }
    if (this.qtI == null)
    {
      CN(4);
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
      paramUri = this.qtI;
      paramArrayOfString1 = new com.tencent.mm.hellhoundlib.b.a().ba(paramArrayOfString1);
      com.tencent.mm.hellhoundlib.a.a.a(paramUri, paramArrayOfString1.aeD(), "com/tencent/mm/plugin/ext/provider/ExtControlProviderEntry", "toShareTimeLine", "([Ljava/lang/String;)Landroid/database/Cursor;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramUri.startActivity((Intent)paramArrayOfString1.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramUri, "com/tencent/mm/plugin/ext/provider/ExtControlProviderEntry", "toShareTimeLine", "([Ljava/lang/String;)Landroid/database/Cursor;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      CN(0);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Wo(1);
      AppMethodBeat.o(24422);
      return paramUri;
    }
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.provider.ExtControlProviderEntry
 * JD-Core Version:    0.7.0.1
 */