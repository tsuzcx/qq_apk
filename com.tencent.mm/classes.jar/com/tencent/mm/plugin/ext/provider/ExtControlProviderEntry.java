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
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.ext.b;
import com.tencent.mm.plugin.ext.key.AESUtil;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.ck;
import com.tencent.mm.storage.cl;

@JgClassChecked(author=32, fComment="checked", lastDate="20141016", reviewer=20, vComment={com.jg.EType.PROVIDERCHECK})
public class ExtControlProviderEntry
  extends ExtContentProviderBase
{
  private static final UriMatcher rlA;
  private boolean rlB = false;
  private Context rlC;
  private String[] rli = null;
  private int rlj = -1;
  
  static
  {
    AppMethodBeat.i(24426);
    UriMatcher localUriMatcher = new UriMatcher(-1);
    rlA = localUriMatcher;
    localUriMatcher.addURI("com.tencent.mm.plugin.ext.entry", "view_profile", 2);
    rlA.addURI("com.tencent.mm.plugin.ext.entry", "to_chatting", 3);
    rlA.addURI("com.tencent.mm.plugin.ext.entry", "to_nearby", 4);
    rlA.addURI("com.tencent.mm.plugin.ext.entry", "sns_comment_detail", 5);
    rlA.addURI("com.tencent.mm.plugin.ext.entry", "share_time_line", 6);
    AppMethodBeat.o(24426);
  }
  
  public ExtControlProviderEntry() {}
  
  public ExtControlProviderEntry(String[] paramArrayOfString, int paramInt, Context paramContext)
  {
    this.rlB = true;
    this.rli = paramArrayOfString;
    this.rlj = paramInt;
    this.rlC = paramContext;
  }
  
  private Cursor a(String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(24424);
    ae.i("MicroMsg.ExtControlEntryProvider", "toChattingUI");
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      ae.w("MicroMsg.ExtControlEntryProvider", "wrong args");
      fz(3, 3601);
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.YL(3601);
      AppMethodBeat.o(24424);
      return paramArrayOfString;
    }
    if (bu.isNullOrNil(paramString))
    {
      ae.w("MicroMsg.ExtControlEntryProvider", "callSource == null");
      fz(3, 3602);
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.YL(3602);
      AppMethodBeat.o(24424);
      return paramArrayOfString;
    }
    paramArrayOfString = paramArrayOfString[0];
    if ((paramArrayOfString == null) || (paramArrayOfString.length() <= 0))
    {
      ae.w("MicroMsg.ExtControlEntryProvider", "contactId == null");
      fz(3, 3603);
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.YL(3603);
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
        paramArrayOfString = b.ctA().aVZ(paramArrayOfString);
        if ((paramArrayOfString == null) || (bu.isNullOrNil(paramArrayOfString.field_openId)) || (bu.isNullOrNil(paramArrayOfString.field_username)))
        {
          ae.e("MicroMsg.ExtControlEntryProvider", "openidInApp is null");
          fz(3, 3604);
          paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.YL(3604);
          AppMethodBeat.o(24424);
          return paramArrayOfString;
          i = 0;
          break;
        }
        bc.aCg();
        paramArrayOfString = com.tencent.mm.model.c.azF().BH(paramArrayOfString.field_username);
        if ((paramArrayOfString != null) && ((int)paramArrayOfString.ght > 0) && (this.rlC != null)) {
          break label350;
        }
        ae.e("MicroMsg.ExtControlEntryProvider", "wrong args ct");
        fz(3, 3605);
        paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.YL(3605);
        AppMethodBeat.o(24424);
        return paramArrayOfString;
      }
      catch (Exception paramArrayOfString)
      {
        label286:
        ae.w("MicroMsg.ExtControlEntryProvider", paramArrayOfString.getMessage());
        ae.printErrStackTrace("MicroMsg.ExtControlEntryProvider", paramArrayOfString, "", new Object[0]);
        ab(5, 4, 12);
        paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.YL(12);
        AppMethodBeat.o(24424);
        return paramArrayOfString;
      }
      bc.aCg();
      paramArrayOfString = com.tencent.mm.model.c.azF().Ed(AESUtil.agE(paramArrayOfString));
    }
    label350:
    paramString = new Intent();
    paramString.setComponent(new ComponentName("com.tencent.mm", "com.tencent.mm.ui.chatting.ChattingUI"));
    paramString.putExtra("Chat_User", paramArrayOfString.field_username);
    paramString.putExtra("finish_direct", true);
    paramString.addFlags(268435456);
    paramString.addFlags(67108864);
    paramArrayOfString = this.rlC;
    paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramString);
    com.tencent.mm.hellhoundlib.a.a.a(paramArrayOfString, paramString.ahE(), "com/tencent/mm/plugin/ext/provider/ExtControlProviderEntry", "toChattingUI", "([Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramArrayOfString.startActivity((Intent)paramString.mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramArrayOfString, "com/tencent/mm/plugin/ext/provider/ExtControlProviderEntry", "toChattingUI", "([Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ab(4, 0, 1);
    paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.YL(1);
    AppMethodBeat.o(24424);
    return paramArrayOfString;
  }
  
  private Cursor y(String[] paramArrayOfString)
  {
    AppMethodBeat.i(24423);
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      ae.w("MicroMsg.ExtControlEntryProvider", "wrong args");
      DS(3);
      AppMethodBeat.o(24423);
      return null;
    }
    paramArrayOfString = paramArrayOfString[0];
    if ((paramArrayOfString == null) || (paramArrayOfString.length() <= 0))
    {
      ae.w("MicroMsg.ExtControlEntryProvider", "contactId == null");
      DS(3);
      AppMethodBeat.o(24423);
      return null;
    }
    try
    {
      bc.aCg();
      paramArrayOfString = com.tencent.mm.model.c.azF().Ed(AESUtil.agE(paramArrayOfString));
      if ((paramArrayOfString == null) || ((int)paramArrayOfString.ght <= 0) || (this.rlC == null))
      {
        DS(3);
        AppMethodBeat.o(24423);
        return null;
      }
    }
    catch (Exception paramArrayOfString)
    {
      ae.w("MicroMsg.ExtControlEntryProvider", paramArrayOfString.getMessage());
      ae.printErrStackTrace("MicroMsg.ExtControlEntryProvider", paramArrayOfString, "", new Object[0]);
      DS(3);
      AppMethodBeat.o(24423);
      return null;
    }
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    localIntent.putExtra("Contact_User", paramArrayOfString.field_username);
    d.b(this.rlC, "profile", ".ui.ContactInfoUI", localIntent);
    DS(0);
    paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.YL(1);
    AppMethodBeat.o(24423);
    return paramArrayOfString;
  }
  
  private Cursor z(String[] paramArrayOfString)
  {
    AppMethodBeat.i(24425);
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      ae.w("MicroMsg.ExtControlEntryProvider", "wrong args");
      DS(3);
      AppMethodBeat.o(24425);
      return null;
    }
    paramArrayOfString = paramArrayOfString[0];
    if ((paramArrayOfString == null) || (paramArrayOfString.length() <= 0))
    {
      ae.w("MicroMsg.ExtControlEntryProvider", "wrong args");
      DS(3);
      AppMethodBeat.o(24425);
      return null;
    }
    long l;
    try
    {
      l = AESUtil.agE(paramArrayOfString);
      if (l <= 0L)
      {
        DS(3);
        AppMethodBeat.o(24425);
        return null;
      }
    }
    catch (Exception paramArrayOfString)
    {
      ae.w("MicroMsg.ExtControlEntryProvider", paramArrayOfString.getMessage());
      ae.printErrStackTrace("MicroMsg.ExtControlEntryProvider", paramArrayOfString, "", new Object[0]);
      DS(3);
      AppMethodBeat.o(24425);
      return null;
    }
    if (this.rlC == null)
    {
      DS(4);
      AppMethodBeat.o(24425);
      return null;
    }
    Object localObject = new Intent();
    ((Intent)localObject).setComponent(new ComponentName("com.tencent.mm", "com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI"));
    ((Intent)localObject).putExtra("INTENT_SNS_LOCAL_ID", (int)l);
    ((Intent)localObject).addCategory("android.intent.category.DEFAULT");
    ((Intent)localObject).addFlags(268435456);
    paramArrayOfString = this.rlC;
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramArrayOfString, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/ext/provider/ExtControlProviderEntry", "toSnsCommentDetail", "([Ljava/lang/String;)Landroid/database/Cursor;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramArrayOfString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramArrayOfString, "com/tencent/mm/plugin/ext/provider/ExtControlProviderEntry", "toSnsCommentDetail", "([Ljava/lang/String;)Landroid/database/Cursor;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    DS(0);
    paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.YL(1);
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
    ae.i("MicroMsg.ExtControlEntryProvider", "ExtControlProviderEntry query() mIsLocalUsed :" + this.rlB);
    if (this.rlB)
    {
      a(paramUri, this.rlC, this.rlj, this.rli);
      if (bu.isNullOrNil(this.rlu))
      {
        ae.e("MicroMsg.ExtControlEntryProvider", "AppID == null");
        fz(3, 7);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.YL(7);
        AppMethodBeat.o(24422);
        return paramUri;
      }
      if (bu.isNullOrNil(ctL()))
      {
        ae.e("MicroMsg.ExtControlEntryProvider", "PkgName == null");
        fz(3, 6);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.YL(6);
        AppMethodBeat.o(24422);
        return paramUri;
      }
      int i = ctM();
      if (i != 1)
      {
        ae.e("MicroMsg.ExtControlEntryProvider", "invalid appid ! return code = ".concat(String.valueOf(i)));
        fz(2, i);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.YL(i);
        AppMethodBeat.o(24422);
        return paramUri;
      }
    }
    else
    {
      this.rlC = getContext();
      a(paramUri, this.rlC, rlA);
      if (paramUri == null)
      {
        DS(3);
        AppMethodBeat.o(24422);
        return null;
      }
      if ((bu.isNullOrNil(this.rlu)) || (bu.isNullOrNil(ctL())))
      {
        DS(3);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.YL(3);
        AppMethodBeat.o(24422);
        return paramUri;
      }
      if (!bNl())
      {
        DS(1);
        paramUri = this.nTy;
        AppMethodBeat.o(24422);
        return paramUri;
      }
      if (!eK(this.rlC))
      {
        ae.w("MicroMsg.ExtControlEntryProvider", "invalid appid ! return null");
        DS(2);
        AppMethodBeat.o(24422);
        return null;
      }
    }
    paramArrayOfString1 = bu.nullAsNil(paramUri.getQueryParameter("source"));
    if (!this.rlB) {
      this.rlj = rlA.match(paramUri);
    }
    switch (this.rlj)
    {
    default: 
      fz(3, 15);
      AppMethodBeat.o(24422);
      return null;
    case 2: 
      paramUri = y(paramArrayOfString2);
      AppMethodBeat.o(24422);
      return paramUri;
    case 3: 
      paramUri = a(paramArrayOfString2, paramArrayOfString1);
      AppMethodBeat.o(24422);
      return paramUri;
    case 4: 
      if (this.rlC == null)
      {
        DS(4);
        AppMethodBeat.o(24422);
        return null;
      }
      paramArrayOfString1 = new Intent();
      paramArrayOfString1.setComponent(new ComponentName("com.tencent.mm", "com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI"));
      paramArrayOfString1.addFlags(268435456);
      paramUri = this.rlC;
      paramArrayOfString1 = new com.tencent.mm.hellhoundlib.b.a().bc(paramArrayOfString1);
      com.tencent.mm.hellhoundlib.a.a.a(paramUri, paramArrayOfString1.ahE(), "com/tencent/mm/plugin/ext/provider/ExtControlProviderEntry", "toNearBy", "()Landroid/database/Cursor;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramUri.startActivity((Intent)paramArrayOfString1.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramUri, "com/tencent/mm/plugin/ext/provider/ExtControlProviderEntry", "toNearBy", "()Landroid/database/Cursor;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      DS(0);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.YL(1);
      AppMethodBeat.o(24422);
      return paramUri;
    case 5: 
      paramUri = z(paramArrayOfString2);
      AppMethodBeat.o(24422);
      return paramUri;
    }
    if ((paramArrayOfString2 == null) || (paramArrayOfString2.length <= 0))
    {
      ae.w("MicroMsg.ExtControlEntryProvider", "wrong args");
      DS(3);
      AppMethodBeat.o(24422);
      return null;
    }
    if (this.rlC == null)
    {
      DS(4);
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
      paramUri = this.rlC;
      paramArrayOfString1 = new com.tencent.mm.hellhoundlib.b.a().bc(paramArrayOfString1);
      com.tencent.mm.hellhoundlib.a.a.a(paramUri, paramArrayOfString1.ahE(), "com/tencent/mm/plugin/ext/provider/ExtControlProviderEntry", "toShareTimeLine", "([Ljava/lang/String;)Landroid/database/Cursor;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramUri.startActivity((Intent)paramArrayOfString1.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramUri, "com/tencent/mm/plugin/ext/provider/ExtControlProviderEntry", "toShareTimeLine", "([Ljava/lang/String;)Landroid/database/Cursor;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      DS(0);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.YL(1);
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