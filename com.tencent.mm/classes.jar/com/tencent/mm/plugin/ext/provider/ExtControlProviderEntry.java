package com.tencent.mm.plugin.ext.provider;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import com.jg.JgClassChecked;
import com.tencent.mm.br.d;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.ext.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bz;
import com.tencent.mm.storage.ca;

@JgClassChecked(author=32, fComment="checked", lastDate="20141016", reviewer=20, vComment={com.jg.EType.PROVIDERCHECK})
public class ExtControlProviderEntry
  extends ExtContentProviderBase
{
  private static final UriMatcher jKj;
  private String[] jJU = null;
  private int jJV = -1;
  private boolean jKk = false;
  private Context jKl;
  
  static
  {
    UriMatcher localUriMatcher = new UriMatcher(-1);
    jKj = localUriMatcher;
    localUriMatcher.addURI("com.tencent.mm.plugin.ext.entry", "view_profile", 2);
    jKj.addURI("com.tencent.mm.plugin.ext.entry", "to_chatting", 3);
    jKj.addURI("com.tencent.mm.plugin.ext.entry", "to_nearby", 4);
    jKj.addURI("com.tencent.mm.plugin.ext.entry", "sns_comment_detail", 5);
    jKj.addURI("com.tencent.mm.plugin.ext.entry", "share_time_line", 6);
  }
  
  public ExtControlProviderEntry() {}
  
  public ExtControlProviderEntry(String[] paramArrayOfString, int paramInt, Context paramContext)
  {
    this.jKk = true;
    this.jJU = paramArrayOfString;
    this.jJV = paramInt;
    this.jKl = paramContext;
  }
  
  private Cursor b(String[] paramArrayOfString, String paramString)
  {
    y.i("MicroMsg.ExtControlEntryProvider", "toChattingUI");
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      y.w("MicroMsg.ExtControlEntryProvider", "wrong args");
      cL(3, 3601);
      return com.tencent.mm.pluginsdk.d.a.a.DA(3601);
    }
    if (bk.bl(paramString))
    {
      y.w("MicroMsg.ExtControlEntryProvider", "callSource == null");
      cL(3, 3602);
      return com.tencent.mm.pluginsdk.d.a.a.DA(3602);
    }
    paramArrayOfString = paramArrayOfString[0];
    if ((paramArrayOfString == null) || (paramArrayOfString.length() <= 0))
    {
      y.w("MicroMsg.ExtControlEntryProvider", "contactId == null");
      cL(3, 3603);
      return com.tencent.mm.pluginsdk.d.a.a.DA(3603);
    }
    if ((paramString != null) && (paramString.equalsIgnoreCase("openapi"))) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {}
      for (;;)
      {
        try
        {
          paramArrayOfString = b.aNq().acu(paramArrayOfString);
          if ((paramArrayOfString == null) || (bk.bl(paramArrayOfString.field_openId)) || (bk.bl(paramArrayOfString.field_username)))
          {
            y.e("MicroMsg.ExtControlEntryProvider", "openidInApp is null");
            cL(3, 3604);
            return com.tencent.mm.pluginsdk.d.a.a.DA(3604);
          }
          au.Hx();
          paramArrayOfString = c.Fw().abl(paramArrayOfString.field_username);
          if ((paramArrayOfString != null) && ((int)paramArrayOfString.dBe > 0) && (this.jKl != null)) {
            break;
          }
          y.e("MicroMsg.ExtControlEntryProvider", "wrong args ct");
          cL(3, 3605);
          return com.tencent.mm.pluginsdk.d.a.a.DA(3605);
        }
        catch (Exception paramArrayOfString)
        {
          y.w("MicroMsg.ExtControlEntryProvider", paramArrayOfString.getMessage());
          y.printErrStackTrace("MicroMsg.ExtControlEntryProvider", paramArrayOfString, "", new Object[0]);
          G(5, 4, 12);
          return com.tencent.mm.pluginsdk.d.a.a.DA(12);
        }
        au.Hx();
        paramArrayOfString = c.Fw().hE(com.tencent.mm.plugin.ext.a.a.Cb(paramArrayOfString));
      }
      paramString = new Intent();
      paramString.setComponent(new ComponentName("com.tencent.mm", "com.tencent.mm.ui.chatting.ChattingUI"));
      paramString.putExtra("Chat_User", paramArrayOfString.field_username);
      paramString.putExtra("finish_direct", true);
      paramString.addFlags(268435456);
      paramString.addFlags(67108864);
      this.jKl.startActivity(paramString);
      G(4, 0, 1);
      return com.tencent.mm.pluginsdk.d.a.a.DA(1);
    }
  }
  
  private Cursor n(String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      y.w("MicroMsg.ExtControlEntryProvider", "wrong args");
      qF(3);
      return null;
    }
    paramArrayOfString = paramArrayOfString[0];
    if ((paramArrayOfString == null) || (paramArrayOfString.length() <= 0))
    {
      y.w("MicroMsg.ExtControlEntryProvider", "contactId == null");
      qF(3);
      return null;
    }
    try
    {
      au.Hx();
      paramArrayOfString = c.Fw().hE(com.tencent.mm.plugin.ext.a.a.Cb(paramArrayOfString));
      if ((paramArrayOfString == null) || ((int)paramArrayOfString.dBe <= 0) || (this.jKl == null))
      {
        qF(3);
        return null;
      }
    }
    catch (Exception paramArrayOfString)
    {
      y.w("MicroMsg.ExtControlEntryProvider", paramArrayOfString.getMessage());
      y.printErrStackTrace("MicroMsg.ExtControlEntryProvider", paramArrayOfString, "", new Object[0]);
      qF(3);
      return null;
    }
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    localIntent.putExtra("Contact_User", paramArrayOfString.field_username);
    d.b(this.jKl, "profile", ".ui.ContactInfoUI", localIntent);
    qF(0);
    return com.tencent.mm.pluginsdk.d.a.a.DA(1);
  }
  
  private Cursor o(String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      y.w("MicroMsg.ExtControlEntryProvider", "wrong args");
      qF(3);
      return null;
    }
    paramArrayOfString = paramArrayOfString[0];
    if ((paramArrayOfString == null) || (paramArrayOfString.length() <= 0))
    {
      y.w("MicroMsg.ExtControlEntryProvider", "wrong args");
      qF(3);
      return null;
    }
    long l;
    try
    {
      l = com.tencent.mm.plugin.ext.a.a.Cb(paramArrayOfString);
      if (l <= 0L)
      {
        qF(3);
        return null;
      }
    }
    catch (Exception paramArrayOfString)
    {
      y.w("MicroMsg.ExtControlEntryProvider", paramArrayOfString.getMessage());
      y.printErrStackTrace("MicroMsg.ExtControlEntryProvider", paramArrayOfString, "", new Object[0]);
      qF(3);
      return null;
    }
    if (this.jKl == null)
    {
      qF(4);
      return null;
    }
    paramArrayOfString = new Intent();
    paramArrayOfString.setComponent(new ComponentName("com.tencent.mm", "com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI"));
    paramArrayOfString.putExtra("INTENT_SNS_LOCAL_ID", (int)l);
    paramArrayOfString.addCategory("android.intent.category.DEFAULT");
    paramArrayOfString.addFlags(268435456);
    this.jKl.startActivity(paramArrayOfString);
    qF(0);
    return com.tencent.mm.pluginsdk.d.a.a.DA(1);
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
    y.i("MicroMsg.ExtControlEntryProvider", "ExtControlProviderEntry query() mIsLocalUsed :" + this.jKk);
    if (this.jKk)
    {
      a(paramUri, this.jKl, this.jJV, this.jJU);
      if (bk.bl(this.jKd))
      {
        y.e("MicroMsg.ExtControlEntryProvider", "AppID == null");
        cL(3, 7);
        return com.tencent.mm.pluginsdk.d.a.a.DA(7);
      }
      if (bk.bl(aNA()))
      {
        y.e("MicroMsg.ExtControlEntryProvider", "PkgName == null");
        cL(3, 6);
        return com.tencent.mm.pluginsdk.d.a.a.DA(6);
      }
      int i = aNB();
      if (i != 1)
      {
        y.e("MicroMsg.ExtControlEntryProvider", "invalid appid ! return code = " + i);
        cL(2, i);
        return com.tencent.mm.pluginsdk.d.a.a.DA(i);
      }
    }
    else
    {
      this.jKl = getContext();
      a(paramUri, this.jKl, jKj);
      if (paramUri == null)
      {
        qF(3);
        return null;
      }
      if ((bk.bl(this.jKd)) || (bk.bl(aNA())))
      {
        qF(3);
        return com.tencent.mm.pluginsdk.d.a.a.DA(3);
      }
      if (!awd())
      {
        qF(1);
        return this.hSn;
      }
      if (!dc(this.jKl))
      {
        y.w("MicroMsg.ExtControlEntryProvider", "invalid appid ! return null");
        qF(2);
        return null;
      }
    }
    paramArrayOfString1 = bk.pm(paramUri.getQueryParameter("source"));
    if (!this.jKk) {
      this.jJV = jKj.match(paramUri);
    }
    switch (this.jJV)
    {
    default: 
      cL(3, 15);
      return null;
    case 2: 
      return n(paramArrayOfString2);
    case 3: 
      return b(paramArrayOfString2, paramArrayOfString1);
    case 4: 
      if (this.jKl == null)
      {
        qF(4);
        return null;
      }
      paramUri = new Intent();
      paramUri.setComponent(new ComponentName("com.tencent.mm", "com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI"));
      paramUri.addFlags(268435456);
      this.jKl.startActivity(paramUri);
      qF(0);
      return com.tencent.mm.pluginsdk.d.a.a.DA(1);
    case 5: 
      return o(paramArrayOfString2);
    }
    if ((paramArrayOfString2 == null) || (paramArrayOfString2.length <= 0))
    {
      y.w("MicroMsg.ExtControlEntryProvider", "wrong args");
      qF(3);
      return null;
    }
    if (this.jKl == null)
    {
      qF(4);
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
      this.jKl.startActivity(paramArrayOfString1);
      qF(0);
      return com.tencent.mm.pluginsdk.d.a.a.DA(1);
    }
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.provider.ExtControlProviderEntry
 * JD-Core Version:    0.7.0.1
 */