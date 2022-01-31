package com.tencent.mm.platformtools;

import android.accounts.Account;
import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Looper;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.RawContacts;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.m.e;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bd;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class h
  implements Runnable
{
  private String cyL;
  private Account gjj;
  private h.a gjk;
  private Looper gjl;
  private Context mContext;
  private String username;
  
  public h(Context paramContext, Account paramAccount)
  {
    this(paramContext, paramAccount, null, null);
  }
  
  public h(Context paramContext, Account paramAccount, String paramString)
  {
    this(paramContext, paramAccount, paramString, null);
  }
  
  public h(Context paramContext, Account paramAccount, String paramString1, String paramString2)
  {
    AppMethodBeat.i(124521);
    this.mContext = paramContext;
    this.gjj = paramAccount;
    this.username = paramString1;
    this.cyL = paramString2;
    ab.i("MicroMsg.ContactsOperations", "username = " + paramString1 + ", " + paramString2);
    AppMethodBeat.o(124521);
  }
  
  private void aoj()
  {
    Object localObject2;
    for (;;)
    {
      Object localObject5;
      try
      {
        AppMethodBeat.i(124524);
        if (!com.tencent.mm.kernel.g.RG())
        {
          ab.d("MicroMsg.ContactsOperations", "account not ready, quit this operation");
          quit();
          AppMethodBeat.o(124524);
          return;
        }
        localObject5 = ((com.tencent.mm.plugin.account.friend.a.b)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).xb("select  *  from addr_upload2 where ( addr_upload2.username IS NOT NULL AND addr_upload2.status!=\"0\" AND addr_upload2.username!=\"" + bo.wC("") + "\" )");
        if (((List)localObject5).size() == 0)
        {
          ab.e("MicroMsg.ContactsOperations", "there is no wechat friend in this phone");
          quit();
          AppMethodBeat.o(124524);
          continue;
        }
        localHashMap = new HashMap();
      }
      finally {}
      HashMap localHashMap;
      localObject2 = ContactsContract.RawContacts.CONTENT_URI.buildUpon().appendQueryParameter("account_name", this.gjj.name).appendQueryParameter("account_type", this.gjj.type).build();
      if (!com.tencent.mm.pluginsdk.permission.b.o(this.mContext, "android.permission.READ_CONTACTS"))
      {
        ab.e("MicroMsg.ContactsOperations", "no contact permission");
        AppMethodBeat.o(124524);
      }
      else
      {
        for (;;)
        {
          try
          {
            localObject2 = this.mContext.getContentResolver().query((Uri)localObject2, new String[] { "sync1", "_id" }, "deleted=\"0\"", null, null);
            if (localObject2 != null) {}
          }
          catch (Exception localException1)
          {
            Object localObject3;
            Object localObject6;
            String str;
            boolean bool;
            localObject2 = null;
            ab.printErrStackTrace("MicroMsg.ContactsOperations", localException1, "", new Object[] { "" });
            Object localObject4 = localObject2;
            continue;
            localObject2 = ((com.tencent.mm.plugin.account.friend.a.a)localObject6).apZ();
            continue;
            ws(((com.tencent.mm.plugin.account.friend.a.a)localObject6).gwO);
            continue;
            this.gjk.execute();
            quit();
            AppMethodBeat.o(124524);
          }
          try
          {
            ab.e("MicroMsg.ContactsOperations", "query get no user");
            localObject3 = localObject2;
            if (localObject3 != null) {
              ((Cursor)localObject3).close();
            }
            if ((wt("vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip.video")) || (wt("vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip"))) {
              break label563;
            }
            i = 1;
          }
          catch (Exception localException2)
          {
            continue;
            i = 0;
            continue;
          }
          this.gjk = new h.a(this, this.mContext.getContentResolver());
          localObject3 = ((List)localObject5).iterator();
          if (!((Iterator)localObject3).hasNext()) {
            continue;
          }
          localObject6 = (com.tencent.mm.plugin.account.friend.a.a)((Iterator)localObject3).next();
          localObject5 = ((com.tencent.mm.plugin.account.friend.a.a)localObject6).getUsername();
          localObject2 = ((j)com.tencent.mm.kernel.g.E(j.class)).YA().arw((String)localObject5);
          if ((localObject2 == null) || (!com.tencent.mm.n.a.je(((aq)localObject2).field_type))) {
            continue;
          }
          if (!bo.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject6).apZ())) {
            continue;
          }
          localObject2 = ((com.tencent.mm.plugin.account.friend.a.a)localObject6).aqc();
          str = ((com.tencent.mm.plugin.account.friend.a.a)localObject6).aqf();
          localObject6 = ((com.tencent.mm.plugin.account.friend.a.a)localObject6).gwO;
          if ((localHashMap.get(localObject6) == null) || (i != 0))
          {
            if (localHashMap.get(localObject6) != null) {
              ws((String)localObject6);
            }
            e((String)localObject2, str, (String)localObject6, (String)localObject5);
          }
          this.gjk.execute();
          continue;
          localObject3 = localObject2;
          if (((Cursor)localObject2).moveToFirst())
          {
            localHashMap.put(((Cursor)localObject2).getString(0), Long.valueOf(((Cursor)localObject2).getLong(1)));
            bool = ((Cursor)localObject2).moveToNext();
            if (!bool) {
              localObject3 = localObject2;
            }
          }
        }
      }
    }
  }
  
  private void e(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(124525);
    ab.d("MicroMsg.ContactsOperations", "add wechat contact: displayname:" + paramString1 + ", phoneNum:" + paramString2 + ", " + paramString3 + ", username:" + paramString4);
    paramString4 = ContentProviderOperation.newInsert(ContactsContract.RawContacts.CONTENT_URI);
    paramString4.withValue("account_name", this.gjj.name);
    paramString4.withValue("account_type", this.gjj.type);
    paramString4.withValue("sync1", paramString3);
    this.gjk.a(paramString4.build());
    paramString4 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
    paramString4.withValueBackReference("raw_contact_id", 0);
    paramString4.withValue("mimetype", "vnd.android.cursor.item/name");
    paramString4.withValue("data1", paramString1);
    this.gjk.a(paramString4.build());
    paramString1 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
    paramString1.withValueBackReference("raw_contact_id", 0);
    paramString1.withValue("mimetype", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.profile");
    paramString1.withValue("data1", paramString2);
    paramString1.withValue("data2", this.mContext.getString(2131297005));
    paramString1.withValue("data3", this.mContext.getString(2131298850));
    paramString1.withValue("data4", paramString3);
    this.gjk.a(paramString1.build());
    if ("1".equals(com.tencent.mm.m.g.Nq().getValue("VOIPCallType")))
    {
      paramString1 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
      paramString1.withValueBackReference("raw_contact_id", 0);
      paramString1.withValue("mimetype", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip.video");
      paramString1.withValue("data1", paramString2);
      paramString1.withValue("data2", this.mContext.getString(2131297005));
      paramString1.withValue("data3", this.mContext.getString(2131298852));
      paramString1.withValue("data4", paramString3);
      this.gjk.a(paramString1.build());
    }
    for (;;)
    {
      paramString1 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
      paramString1.withValueBackReference("raw_contact_id", 0);
      paramString1.withValue("mimetype", "vnd.android.cursor.item/vnd.com.tencent.mm.plugin.sns.timeline");
      paramString1.withValue("data1", paramString2);
      paramString1.withValue("data2", this.mContext.getString(2131297005));
      paramString1.withValue("data3", this.mContext.getString(2131298853));
      paramString1.withValue("data4", paramString3);
      this.gjk.a(paramString1.build());
      paramString1 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
      paramString1.withValueBackReference("raw_contact_id", 0);
      paramString1.withValue("mimetype", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voiceaction");
      paramString1.withValue("data1", paramString2);
      paramString1.withValue("data2", this.mContext.getString(2131297005));
      paramString1.withValue("data3", "");
      paramString1.withValue("data4", paramString3);
      this.gjk.a(paramString1.build());
      AppMethodBeat.o(124525);
      return;
      paramString1 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
      paramString1.withValueBackReference("raw_contact_id", 0);
      paramString1.withValue("mimetype", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip");
      paramString1.withValue("data1", paramString2);
      paramString1.withValue("data2", this.mContext.getString(2131297005));
      paramString1.withValue("data3", this.mContext.getString(2131298851));
      paramString1.withValue("data4", paramString3);
      this.gjk.a(paramString1.build());
    }
  }
  
  private void quit()
  {
    AppMethodBeat.i(124523);
    if (this.gjl != null) {
      this.gjl.quit();
    }
    AppMethodBeat.o(124523);
  }
  
  private void ws(String paramString)
  {
    AppMethodBeat.i(124526);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.ContactsOperations", "delete wechat contact fail, phoneNum5 is null");
      AppMethodBeat.o(124526);
      return;
    }
    if (!com.tencent.mm.pluginsdk.permission.b.o(this.mContext, "android.permission.READ_CONTACTS"))
    {
      ab.e("MicroMsg.ContactsOperations", "no contact permission");
      AppMethodBeat.o(124526);
      return;
    }
    try
    {
      paramString = this.mContext.getContentResolver().query(ContactsContract.Data.CONTENT_URI, new String[] { "contact_id", "_id" }, "(mimetype= ? or mimetype= ? or mimetype= ? or mimetype= ? or mimetype= ?) AND data4 = ?", new String[] { "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.profile", "vnd.android.cursor.item/vnd.com.tencent.mm.plugin.sns.timeline", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip.video", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voiceaction", paramString }, null);
      if (paramString == null)
      {
        ab.e("MicroMsg.ContactsOperations", "get null cursor");
        AppMethodBeat.o(124526);
        return;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ab.e("MicroMsg.ContactsOperations", "query fail, match error %s \n %s", new Object[] { paramString.getMessage(), bo.l(paramString) });
        paramString = null;
      }
    }
    for (;;)
    {
      try
      {
        if (paramString.moveToFirst())
        {
          int i = paramString.getColumnIndex("contact_id");
          if (i < 0) {
            continue;
          }
          str1 = paramString.getString(i);
          i = paramString.getColumnIndex("_id");
          if (i < 0) {
            continue;
          }
          str2 = paramString.getString(i);
          if ((!bo.isNullOrNil(str1)) && (!bo.isNullOrNil(str2)))
          {
            this.mContext.getContentResolver().delete(ContactsContract.Data.CONTENT_URI, "_id = ?", new String[] { str2 });
            this.mContext.getContentResolver().delete(ContactsContract.RawContacts.CONTENT_URI, "contact_id = ? AND account_type = ?", new String[] { str1, "com.tencent.mm.account" });
          }
          boolean bool = paramString.moveToNext();
          if (bool) {
            continue;
          }
        }
      }
      catch (Exception localException)
      {
        String str1;
        String str2;
        ab.e("MicroMsg.ContactsOperations", "delete wechat contact failed : " + localException.getMessage());
        continue;
      }
      paramString.close();
      AppMethodBeat.o(124526);
      return;
      str1 = "";
      continue;
      str2 = "";
    }
  }
  
  /* Error */
  private boolean wt(String paramString)
  {
    // Byte code:
    //   0: ldc_w 441
    //   3: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 38	com/tencent/mm/platformtools/h:mContext	Landroid/content/Context;
    //   10: ldc 169
    //   12: invokestatic 174	com/tencent/mm/pluginsdk/permission/b:o	(Landroid/content/Context;Ljava/lang/String;)Z
    //   15: ifne +18 -> 33
    //   18: ldc 46
    //   20: ldc 176
    //   22: invokestatic 130	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   25: ldc_w 441
    //   28: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: iconst_0
    //   32: ireturn
    //   33: aload_0
    //   34: getfield 38	com/tencent/mm/platformtools/h:mContext	Landroid/content/Context;
    //   37: invokevirtual 182	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   40: getstatic 348	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   43: iconst_1
    //   44: anewarray 184	java/lang/String
    //   47: dup
    //   48: iconst_0
    //   49: ldc_w 408
    //   52: aastore
    //   53: ldc_w 443
    //   56: iconst_1
    //   57: anewarray 184	java/lang/String
    //   60: dup
    //   61: iconst_0
    //   62: aload_1
    //   63: aastore
    //   64: aconst_null
    //   65: invokevirtual 196	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   68: astore_3
    //   69: aload_3
    //   70: ifnull +84 -> 154
    //   73: aload_3
    //   74: invokeinterface 446 1 0
    //   79: ifle +75 -> 154
    //   82: ldc 46
    //   84: ldc_w 448
    //   87: aload_1
    //   88: invokestatic 451	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   91: invokevirtual 454	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   94: invokestatic 88	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   97: iconst_1
    //   98: istore_2
    //   99: aload_3
    //   100: ifnull +9 -> 109
    //   103: aload_3
    //   104: invokeinterface 203 1 0
    //   109: ldc_w 441
    //   112: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   115: iload_2
    //   116: ireturn
    //   117: astore_1
    //   118: aconst_null
    //   119: astore_3
    //   120: ldc 46
    //   122: new 48	java/lang/StringBuilder
    //   125: dup
    //   126: ldc_w 456
    //   129: invokespecial 53	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   132: aload_1
    //   133: invokevirtual 417	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   136: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: invokestatic 130	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   145: iconst_1
    //   146: istore_2
    //   147: goto -48 -> 99
    //   150: astore_1
    //   151: goto -31 -> 120
    //   154: iconst_0
    //   155: istore_2
    //   156: goto -57 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	this	h
    //   0	159	1	paramString	String
    //   98	58	2	bool	boolean
    //   68	52	3	localCursor	Cursor
    // Exception table:
    //   from	to	target	type
    //   33	69	117	java/lang/Exception
    //   73	97	150	java/lang/Exception
  }
  
  public final void run()
  {
    AppMethodBeat.i(124522);
    Looper.prepare();
    this.gjl = Looper.myLooper();
    ab.i("MicroMsg.ContactsOperations", "start time:".concat(String.valueOf(System.currentTimeMillis())));
    if (!com.tencent.mm.kernel.g.RJ().QU())
    {
      ab.w("MicroMsg.ContactsOperations", "account not ready, quit this operation");
      quit();
      AppMethodBeat.o(124522);
      return;
    }
    if ((bo.isNullOrNil(this.username)) && (bo.isNullOrNil(this.cyL))) {
      aoj();
    }
    for (;;)
    {
      ab.i("MicroMsg.ContactsOperations", "end time:" + System.currentTimeMillis());
      Looper.loop();
      AppMethodBeat.o(124522);
      return;
      if (!bo.isNullOrNil(this.cyL)) {
        break;
      }
      locala = ((com.tencent.mm.plugin.account.friend.a.b)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).wX(this.username);
      if ((locala != null) && (!bo.isNullOrNil(locala.gwO))) {
        ws(locala.gwO);
      }
      quit();
    }
    com.tencent.mm.plugin.account.friend.a.a locala = ((com.tencent.mm.plugin.account.friend.a.b)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).wX(this.username);
    if ((locala == null) || (bo.isNullOrNil(locala.gwO))) {
      locala = ((com.tencent.mm.plugin.account.friend.a.b)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).wX(this.cyL);
    }
    for (;;)
    {
      for (;;)
      {
        if ((locala != null) && (!bo.isNullOrNil(locala.gwO))) {
          try
          {
            if (!com.tencent.mm.pluginsdk.permission.b.o(this.mContext, "android.permission.READ_CONTACTS")) {
              ab.e("MicroMsg.ContactsOperations", "no contact permission");
            }
          }
          catch (Exception localException)
          {
            ab.printErrStackTrace("MicroMsg.ContactsOperations", localException, "", new Object[] { "" });
          }
        }
      }
      for (;;)
      {
        quit();
        break;
        Object localObject1 = ContactsContract.RawContacts.CONTENT_URI.buildUpon().appendQueryParameter("account_name", this.gjj.name).appendQueryParameter("account_type", this.gjj.type).build();
        Object localObject2 = this.mContext.getContentResolver();
        String str = "deleted=\"0\" AND sync1=\"" + localException.gwO + "\"";
        localObject2 = ((ContentResolver)localObject2).query((Uri)localObject1, new String[] { "sync1", "_id" }, str, null, null);
        if ((localObject2 == null) || (((Cursor)localObject2).getCount() == 0)) {
          if (!bo.isNullOrNil(localException.apZ())) {
            break label482;
          }
        }
        label482:
        for (localObject1 = localException.aqc();; localObject1 = localException.apZ())
        {
          this.gjk = new h.a(this, this.mContext.getContentResolver());
          e((String)localObject1, localException.aqf(), localException.gwO, this.username);
          this.gjk.execute();
          if (localObject2 == null) {
            break;
          }
          ((Cursor)localObject2).close();
          break;
        }
        ab.d("MicroMsg.ContactsOperations", "query addrupload is null " + this.username);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.platformtools.h
 * JD-Core Version:    0.7.0.1
 */