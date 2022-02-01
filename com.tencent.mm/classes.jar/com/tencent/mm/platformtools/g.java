package com.tencent.mm.platformtools;

import android.accounts.Account;
import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentResolver;
import android.content.Context;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.RemoteException;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.RawContacts;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.m.e;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bg;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class g
  implements Runnable
{
  private String doQ;
  private Account hTO;
  private a hTP;
  private Context mContext;
  private String username;
  
  public g(Context paramContext, Account paramAccount)
  {
    this(paramContext, paramAccount, null, null);
  }
  
  public g(Context paramContext, Account paramAccount, String paramString)
  {
    this(paramContext, paramAccount, paramString, null);
  }
  
  public g(Context paramContext, Account paramAccount, String paramString1, String paramString2)
  {
    AppMethodBeat.i(127679);
    this.mContext = paramContext;
    this.hTO = paramAccount;
    this.username = paramString1;
    this.doQ = paramString2;
    ad.i("MicroMsg.ContactsOperations", "username = " + paramString1 + ", " + paramString2);
    AppMethodBeat.o(127679);
  }
  
  private void Bt(String paramString)
  {
    AppMethodBeat.i(127684);
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.ContactsOperations", "delete wechat contact fail, phoneNum5 is null");
      AppMethodBeat.o(127684);
      return;
    }
    if (!com.tencent.mm.pluginsdk.permission.b.o(this.mContext, "android.permission.READ_CONTACTS"))
    {
      ad.e("MicroMsg.ContactsOperations", "no contact permission");
      AppMethodBeat.o(127684);
      return;
    }
    try
    {
      paramString = this.mContext.getContentResolver().query(ContactsContract.Data.CONTENT_URI, new String[] { "contact_id", "_id" }, "(mimetype= ? or mimetype= ? or mimetype= ? or mimetype= ? or mimetype= ?) AND data4 = ?", new String[] { "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.profile", "vnd.android.cursor.item/vnd.com.tencent.mm.plugin.sns.timeline", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip.video", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voiceaction", paramString }, null);
      if (paramString == null)
      {
        ad.e("MicroMsg.ContactsOperations", "get null cursor");
        AppMethodBeat.o(127684);
        return;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ad.e("MicroMsg.ContactsOperations", "query fail, match error %s \n %s", new Object[] { paramString.getMessage(), bt.m(paramString) });
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
          if ((!bt.isNullOrNil(str1)) && (!bt.isNullOrNil(str2)))
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
        ad.e("MicroMsg.ContactsOperations", "delete wechat contact failed : " + localException.getMessage());
        continue;
      }
      paramString.close();
      AppMethodBeat.o(127684);
      return;
      str1 = "";
      continue;
      str2 = "";
    }
  }
  
  /* Error */
  private boolean Bu(String paramString)
  {
    // Byte code:
    //   0: ldc 183
    //   2: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 37	com/tencent/mm/platformtools/g:mContext	Landroid/content/Context;
    //   9: ldc 87
    //   11: invokestatic 92	com/tencent/mm/pluginsdk/permission/b:o	(Landroid/content/Context;Ljava/lang/String;)Z
    //   14: ifne +17 -> 31
    //   17: ldc 45
    //   19: ldc 94
    //   21: invokestatic 85	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   24: ldc 183
    //   26: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: iconst_0
    //   30: ireturn
    //   31: aload_0
    //   32: getfield 37	com/tencent/mm/platformtools/g:mContext	Landroid/content/Context;
    //   35: invokevirtual 100	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   38: getstatic 106	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   41: iconst_1
    //   42: anewarray 108	java/lang/String
    //   45: dup
    //   46: iconst_0
    //   47: ldc 110
    //   49: aastore
    //   50: ldc 185
    //   52: iconst_1
    //   53: anewarray 108	java/lang/String
    //   56: dup
    //   57: iconst_0
    //   58: aload_1
    //   59: aastore
    //   60: aconst_null
    //   61: invokevirtual 130	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   64: astore_3
    //   65: aload_3
    //   66: ifnull +81 -> 147
    //   69: aload_3
    //   70: invokeinterface 189 1 0
    //   75: ifle +72 -> 147
    //   78: ldc 45
    //   80: ldc 191
    //   82: aload_1
    //   83: invokestatic 195	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   86: invokevirtual 199	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   89: invokestatic 202	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: iconst_1
    //   93: istore_2
    //   94: aload_3
    //   95: ifnull +9 -> 104
    //   98: aload_3
    //   99: invokeinterface 177 1 0
    //   104: ldc 183
    //   106: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   109: iload_2
    //   110: ireturn
    //   111: astore_1
    //   112: aconst_null
    //   113: astore_3
    //   114: ldc 45
    //   116: new 47	java/lang/StringBuilder
    //   119: dup
    //   120: ldc 204
    //   122: invokespecial 52	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   125: aload_1
    //   126: invokevirtual 137	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   129: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokestatic 85	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   138: iconst_1
    //   139: istore_2
    //   140: goto -46 -> 94
    //   143: astore_1
    //   144: goto -30 -> 114
    //   147: iconst_0
    //   148: istore_2
    //   149: goto -55 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	this	g
    //   0	152	1	paramString	String
    //   93	56	2	bool	boolean
    //   64	50	3	localCursor	Cursor
    // Exception table:
    //   from	to	target	type
    //   31	65	111	java/lang/Exception
    //   69	92	143	java/lang/Exception
  }
  
  private void aGr()
  {
    Object localObject2;
    for (;;)
    {
      Object localObject5;
      try
      {
        AppMethodBeat.i(127682);
        if (!com.tencent.mm.kernel.g.afw())
        {
          ad.d("MicroMsg.ContactsOperations", "account not ready, quit this operation");
          ad.w("MicroMsg.ContactsOperations", "quit...");
          AppMethodBeat.o(127682);
          return;
        }
        localObject5 = ((com.tencent.mm.plugin.account.friend.a.b)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).Cg("select  *  from addr_upload2 where ( addr_upload2.username IS NOT NULL AND addr_upload2.status!=\"0\" AND addr_upload2.username!=\"" + bt.aFQ("") + "\" )");
        if (((List)localObject5).size() == 0)
        {
          ad.e("MicroMsg.ContactsOperations", "there is no wechat friend in this phone");
          ad.w("MicroMsg.ContactsOperations", "quit...");
          AppMethodBeat.o(127682);
          continue;
        }
        localHashMap = new HashMap();
      }
      finally {}
      HashMap localHashMap;
      localObject2 = ContactsContract.RawContacts.CONTENT_URI.buildUpon().appendQueryParameter("account_name", this.hTO.name).appendQueryParameter("account_type", this.hTO.type).build();
      if (!com.tencent.mm.pluginsdk.permission.b.o(this.mContext, "android.permission.READ_CONTACTS"))
      {
        ad.e("MicroMsg.ContactsOperations", "no contact permission");
        AppMethodBeat.o(127682);
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
            ad.printErrStackTrace("MicroMsg.ContactsOperations", localException1, "", new Object[] { "" });
            Object localObject4 = localObject2;
            continue;
            localObject2 = ((com.tencent.mm.plugin.account.friend.a.a)localObject6).aIv();
            continue;
            Bt(((com.tencent.mm.plugin.account.friend.a.a)localObject6).ijL);
            continue;
            this.hTP.execute();
            ad.w("MicroMsg.ContactsOperations", "quit...");
            AppMethodBeat.o(127682);
          }
          try
          {
            ad.e("MicroMsg.ContactsOperations", "query get no user");
            localObject3 = localObject2;
            if (localObject3 != null) {
              ((Cursor)localObject3).close();
            }
            if ((Bu("vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip.video")) || (Bu("vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip"))) {
              break label578;
            }
            i = 1;
          }
          catch (Exception localException2)
          {
            continue;
            i = 0;
            continue;
          }
          this.hTP = new a(this.mContext.getContentResolver());
          localObject3 = ((List)localObject5).iterator();
          if (!((Iterator)localObject3).hasNext()) {
            continue;
          }
          localObject6 = (com.tencent.mm.plugin.account.friend.a.a)((Iterator)localObject3).next();
          localObject5 = ((com.tencent.mm.plugin.account.friend.a.a)localObject6).getUsername();
          localObject2 = ((k)com.tencent.mm.kernel.g.ab(k.class)).apM().aHY((String)localObject5);
          if ((localObject2 == null) || (!com.tencent.mm.n.b.ls(((au)localObject2).field_type))) {
            continue;
          }
          if (!bt.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject6).aIv())) {
            continue;
          }
          localObject2 = ((com.tencent.mm.plugin.account.friend.a.a)localObject6).getNickName();
          str = ((com.tencent.mm.plugin.account.friend.a.a)localObject6).aIA();
          localObject6 = ((com.tencent.mm.plugin.account.friend.a.a)localObject6).ijL;
          if ((localHashMap.get(localObject6) == null) || (i != 0))
          {
            if (localHashMap.get(localObject6) != null) {
              Bt((String)localObject6);
            }
            e((String)localObject2, str, (String)localObject6, (String)localObject5);
          }
          this.hTP.execute();
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
    AppMethodBeat.i(127683);
    ad.d("MicroMsg.ContactsOperations", "add wechat contact: displayname:" + paramString1 + ", phoneNum:" + paramString2 + ", " + paramString3 + ", username:" + paramString4);
    paramString4 = ContentProviderOperation.newInsert(ContactsContract.RawContacts.CONTENT_URI);
    paramString4.withValue("account_name", this.hTO.name);
    paramString4.withValue("account_type", this.hTO.type);
    paramString4.withValue("sync1", paramString3);
    this.hTP.a(paramString4.build());
    paramString4 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
    paramString4.withValueBackReference("raw_contact_id", 0);
    paramString4.withValue("mimetype", "vnd.android.cursor.item/name");
    paramString4.withValue("data1", paramString1);
    this.hTP.a(paramString4.build());
    paramString1 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
    paramString1.withValueBackReference("raw_contact_id", 0);
    paramString1.withValue("mimetype", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.profile");
    paramString1.withValue("data1", paramString2);
    paramString1.withValue("data2", this.mContext.getString(2131755822));
    paramString1.withValue("data3", this.mContext.getString(2131757928));
    paramString1.withValue("data4", paramString3);
    this.hTP.a(paramString1.build());
    if ("1".equals(com.tencent.mm.m.g.Zd().getValue("VOIPCallType")))
    {
      paramString1 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
      paramString1.withValueBackReference("raw_contact_id", 0);
      paramString1.withValue("mimetype", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip.video");
      paramString1.withValue("data1", paramString2);
      paramString1.withValue("data2", this.mContext.getString(2131755822));
      paramString1.withValue("data3", this.mContext.getString(2131757930));
      paramString1.withValue("data4", paramString3);
      this.hTP.a(paramString1.build());
    }
    for (;;)
    {
      paramString1 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
      paramString1.withValueBackReference("raw_contact_id", 0);
      paramString1.withValue("mimetype", "vnd.android.cursor.item/vnd.com.tencent.mm.plugin.sns.timeline");
      paramString1.withValue("data1", paramString2);
      paramString1.withValue("data2", this.mContext.getString(2131755822));
      paramString1.withValue("data3", this.mContext.getString(2131757931));
      paramString1.withValue("data4", paramString3);
      this.hTP.a(paramString1.build());
      paramString1 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
      paramString1.withValueBackReference("raw_contact_id", 0);
      paramString1.withValue("mimetype", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voiceaction");
      paramString1.withValue("data1", paramString2);
      paramString1.withValue("data2", this.mContext.getString(2131755822));
      paramString1.withValue("data3", "");
      paramString1.withValue("data4", paramString3);
      this.hTP.a(paramString1.build());
      AppMethodBeat.o(127683);
      return;
      paramString1 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
      paramString1.withValueBackReference("raw_contact_id", 0);
      paramString1.withValue("mimetype", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip");
      paramString1.withValue("data1", paramString2);
      paramString1.withValue("data2", this.mContext.getString(2131755822));
      paramString1.withValue("data3", this.mContext.getString(2131757929));
      paramString1.withValue("data4", paramString3);
      this.hTP.a(paramString1.build());
    }
  }
  
  public final void run()
  {
    AppMethodBeat.i(127680);
    ad.i("MicroMsg.ContactsOperations", "start time:".concat(String.valueOf(System.currentTimeMillis())));
    if (!com.tencent.mm.kernel.g.afz().aeI())
    {
      ad.w("MicroMsg.ContactsOperations", "account not ready, quit this operation");
      ad.w("MicroMsg.ContactsOperations", "quit...");
      AppMethodBeat.o(127680);
      return;
    }
    if ((bt.isNullOrNil(this.username)) && (bt.isNullOrNil(this.doQ))) {
      aGr();
    }
    for (;;)
    {
      ad.i("MicroMsg.ContactsOperations", "end time:" + System.currentTimeMillis());
      AppMethodBeat.o(127680);
      return;
      if (!bt.isNullOrNil(this.doQ)) {
        break;
      }
      locala = ((com.tencent.mm.plugin.account.friend.a.b)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).Cc(this.username);
      if ((locala != null) && (!bt.isNullOrNil(locala.ijL))) {
        Bt(locala.ijL);
      }
      ad.w("MicroMsg.ContactsOperations", "quit...");
    }
    com.tencent.mm.plugin.account.friend.a.a locala = ((com.tencent.mm.plugin.account.friend.a.b)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).Cc(this.username);
    if ((locala == null) || (bt.isNullOrNil(locala.ijL))) {
      locala = ((com.tencent.mm.plugin.account.friend.a.b)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).Cc(this.doQ);
    }
    for (;;)
    {
      for (;;)
      {
        if ((locala != null) && (!bt.isNullOrNil(locala.ijL))) {
          try
          {
            if (!com.tencent.mm.pluginsdk.permission.b.o(this.mContext, "android.permission.READ_CONTACTS")) {
              ad.e("MicroMsg.ContactsOperations", "no contact permission");
            }
          }
          catch (Exception localException)
          {
            ad.printErrStackTrace("MicroMsg.ContactsOperations", localException, "", new Object[] { "" });
          }
        }
      }
      for (;;)
      {
        ad.w("MicroMsg.ContactsOperations", "quit...");
        break;
        Object localObject1 = ContactsContract.RawContacts.CONTENT_URI.buildUpon().appendQueryParameter("account_name", this.hTO.name).appendQueryParameter("account_type", this.hTO.type).build();
        Object localObject2 = this.mContext.getContentResolver();
        String str = "deleted=\"0\" AND sync1=\"" + localException.ijL + "\"";
        localObject2 = ((ContentResolver)localObject2).query((Uri)localObject1, new String[] { "sync1", "_id" }, str, null, null);
        if ((localObject2 == null) || (((Cursor)localObject2).getCount() == 0)) {
          if (!bt.isNullOrNil(localException.aIv())) {
            break label481;
          }
        }
        label481:
        for (localObject1 = localException.getNickName();; localObject1 = localException.aIv())
        {
          this.hTP = new a(this.mContext.getContentResolver());
          e((String)localObject1, localException.aIA(), localException.ijL, this.username);
          this.hTP.execute();
          if (localObject2 == null) {
            break;
          }
          ((Cursor)localObject2).close();
          break;
        }
        ad.d("MicroMsg.ContactsOperations", "query addrupload is null " + this.username);
      }
    }
  }
  
  public final class a
  {
    private final String TAG;
    private final ContentResolver hTQ;
    ArrayList<ContentProviderOperation> hTR;
    
    public a(ContentResolver paramContentResolver)
    {
      AppMethodBeat.i(127676);
      this.TAG = "MicroMsg.BatchOperation";
      this.hTQ = paramContentResolver;
      this.hTR = new ArrayList();
      AppMethodBeat.o(127676);
    }
    
    public final void a(ContentProviderOperation paramContentProviderOperation)
    {
      AppMethodBeat.i(127677);
      this.hTR.add(paramContentProviderOperation);
      AppMethodBeat.o(127677);
    }
    
    public final void execute()
    {
      AppMethodBeat.i(127678);
      if (this.hTR.size() == 0)
      {
        ad.d("MicroMsg.BatchOperation", "no batch operation");
        AppMethodBeat.o(127678);
        return;
      }
      if (!com.tencent.mm.pluginsdk.permission.b.o(g.a(g.this), "android.permission.READ_CONTACTS"))
      {
        ad.e("MicroMsg.BatchOperation", "no contact permission");
        AppMethodBeat.o(127678);
        return;
      }
      try
      {
        this.hTQ.applyBatch("com.android.contacts", this.hTR);
        this.hTR.clear();
        AppMethodBeat.o(127678);
        return;
      }
      catch (OperationApplicationException localOperationApplicationException)
      {
        for (;;)
        {
          ad.e("MicroMsg.BatchOperation", "apply batch operation failed", new Object[] { localOperationApplicationException.toString() });
        }
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          ad.e("MicroMsg.BatchOperation", "apply batch operation failed", new Object[] { localRemoteException.toString() });
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.e("MicroMsg.BatchOperation", "apply batch operation failed", new Object[] { localException.toString() });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.platformtools.g
 * JD-Core Version:    0.7.0.1
 */