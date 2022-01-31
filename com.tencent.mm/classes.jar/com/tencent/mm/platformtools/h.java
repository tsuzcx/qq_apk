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
import com.tencent.mm.h.c.ao;
import com.tencent.mm.m.e;
import com.tencent.mm.plugin.account.friend.a.b;
import com.tencent.mm.plugin.account.ui.q.j;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bd;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class h
  implements Runnable
{
  private String bRj;
  private Account eRo;
  private h.a eRp;
  private Looper eRq;
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
    this.mContext = paramContext;
    this.eRo = paramAccount;
    this.username = paramString1;
    this.bRj = paramString2;
    y.i("MicroMsg.ContactsOperations", "username = " + paramString1 + ", " + paramString2);
  }
  
  private void UK()
  {
    Object localObject2;
    for (;;)
    {
      Object localObject5;
      try
      {
        if (!com.tencent.mm.kernel.g.DK())
        {
          y.d("MicroMsg.ContactsOperations", "account not ready, quit this operation");
          quit();
          return;
        }
        localObject5 = ((b)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).pJ("select  *  from addr_upload2 where ( addr_upload2.username IS NOT NULL AND addr_upload2.status!=\"0\" AND addr_upload2.username!=\"" + bk.pl("") + "\" )");
        if (((List)localObject5).size() == 0)
        {
          y.e("MicroMsg.ContactsOperations", "there is no wechat friend in this phone");
          quit();
          continue;
        }
        localHashMap = new HashMap();
      }
      finally {}
      HashMap localHashMap;
      localObject2 = ContactsContract.RawContacts.CONTENT_URI.buildUpon().appendQueryParameter("account_name", this.eRo.name).appendQueryParameter("account_type", this.eRo.type).build();
      if (!com.tencent.mm.pluginsdk.permission.a.j(this.mContext, "android.permission.READ_CONTACTS")) {
        y.e("MicroMsg.ContactsOperations", "no contact permission");
      } else {
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
            Object localObject7;
            Object localObject6;
            String str;
            boolean bool;
            localObject2 = null;
            y.printErrStackTrace("MicroMsg.ContactsOperations", localException1, "", new Object[] { "" });
            Object localObject4 = localObject2;
            continue;
            localObject2 = ((com.tencent.mm.plugin.account.friend.a.a)localObject7).Wx();
            continue;
            pa(((com.tencent.mm.plugin.account.friend.a.a)localObject7).ffg);
            continue;
            this.eRp.execute();
            quit();
          }
          try
          {
            y.e("MicroMsg.ContactsOperations", "query get no user");
            localObject3 = localObject2;
            if (localObject3 != null) {
              ((Cursor)localObject3).close();
            }
            if ((pb("vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip.video")) || (pb("vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip"))) {
              break label548;
            }
            i = 1;
          }
          catch (Exception localException2)
          {
            continue;
            i = 0;
            continue;
          }
          this.eRp = new h.a(this, this.mContext.getContentResolver());
          localObject3 = ((List)localObject5).iterator();
          if (!((Iterator)localObject3).hasNext()) {
            continue;
          }
          localObject7 = (com.tencent.mm.plugin.account.friend.a.a)((Iterator)localObject3).next();
          localObject5 = ((com.tencent.mm.plugin.account.friend.a.a)localObject7).getUsername();
          localObject6 = ((j)com.tencent.mm.kernel.g.r(j.class)).Fw().abl((String)localObject5);
          if ((localObject6 == null) || (!com.tencent.mm.n.a.gR(((ao)localObject6).field_type))) {
            continue;
          }
          if (!bk.bl(((com.tencent.mm.plugin.account.friend.a.a)localObject7).Wx())) {
            continue;
          }
          localObject2 = ((com.tencent.mm.plugin.account.friend.a.a)localObject7).WA();
          str = ((com.tencent.mm.plugin.account.friend.a.a)localObject7).WD();
          localObject7 = ((com.tencent.mm.plugin.account.friend.a.a)localObject7).ffg;
          localObject6 = ((ao)localObject6).signature;
          if ((localHashMap.get(localObject7) == null) || (i != 0))
          {
            if (localHashMap.get(localObject7) != null) {
              pa((String)localObject7);
            }
            e((String)localObject2, str, (String)localObject7, (String)localObject5);
          }
          this.eRp.execute();
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
    y.d("MicroMsg.ContactsOperations", "add wechat contact: displayname:" + paramString1 + ", phoneNum:" + paramString2 + ", " + paramString3 + ", username:" + paramString4);
    paramString4 = ContentProviderOperation.newInsert(ContactsContract.RawContacts.CONTENT_URI);
    paramString4.withValue("account_name", this.eRo.name);
    paramString4.withValue("account_type", this.eRo.type);
    paramString4.withValue("sync1", paramString3);
    this.eRp.a(paramString4.build());
    paramString4 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
    paramString4.withValueBackReference("raw_contact_id", 0);
    paramString4.withValue("mimetype", "vnd.android.cursor.item/name");
    paramString4.withValue("data1", paramString1);
    this.eRp.a(paramString4.build());
    paramString1 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
    paramString1.withValueBackReference("raw_contact_id", 0);
    paramString1.withValue("mimetype", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.profile");
    paramString1.withValue("data1", paramString2);
    paramString1.withValue("data2", this.mContext.getString(q.j.app_name));
    paramString1.withValue("data3", this.mContext.getString(q.j.contact_sync_action_chat));
    paramString1.withValue("data4", paramString3);
    this.eRp.a(paramString1.build());
    if ("1".equals(com.tencent.mm.m.g.AA().getValue("VOIPCallType")))
    {
      paramString1 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
      paramString1.withValueBackReference("raw_contact_id", 0);
      paramString1.withValue("mimetype", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip.video");
      paramString1.withValue("data1", paramString2);
      paramString1.withValue("data2", this.mContext.getString(q.j.app_name));
      paramString1.withValue("data3", this.mContext.getString(q.j.contact_sync_action_chat_voip_video));
      paramString1.withValue("data4", paramString3);
      this.eRp.a(paramString1.build());
    }
    for (;;)
    {
      paramString1 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
      paramString1.withValueBackReference("raw_contact_id", 0);
      paramString1.withValue("mimetype", "vnd.android.cursor.item/vnd.com.tencent.mm.plugin.sns.timeline");
      paramString1.withValue("data1", paramString2);
      paramString1.withValue("data2", this.mContext.getString(q.j.app_name));
      paramString1.withValue("data3", this.mContext.getString(q.j.contact_sync_action_view_timeline));
      paramString1.withValue("data4", paramString3);
      this.eRp.a(paramString1.build());
      paramString1 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
      paramString1.withValueBackReference("raw_contact_id", 0);
      paramString1.withValue("mimetype", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voiceaction");
      paramString1.withValue("data1", paramString2);
      paramString1.withValue("data2", this.mContext.getString(q.j.app_name));
      paramString1.withValue("data3", "");
      paramString1.withValue("data4", paramString3);
      this.eRp.a(paramString1.build());
      return;
      paramString1 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
      paramString1.withValueBackReference("raw_contact_id", 0);
      paramString1.withValue("mimetype", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip");
      paramString1.withValue("data1", paramString2);
      paramString1.withValue("data2", this.mContext.getString(q.j.app_name));
      paramString1.withValue("data3", this.mContext.getString(q.j.contact_sync_action_chat_voip));
      paramString1.withValue("data4", paramString3);
      this.eRp.a(paramString1.build());
    }
  }
  
  private void pa(String paramString)
  {
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.ContactsOperations", "delete wechat contact fail, phoneNum5 is null");
      return;
    }
    if (!com.tencent.mm.pluginsdk.permission.a.j(this.mContext, "android.permission.READ_CONTACTS"))
    {
      y.e("MicroMsg.ContactsOperations", "no contact permission");
      return;
    }
    try
    {
      paramString = this.mContext.getContentResolver().query(ContactsContract.Data.CONTENT_URI, new String[] { "contact_id", "_id" }, "(mimetype= ? or mimetype= ? or mimetype= ? or mimetype= ? or mimetype= ?) AND data4 = ?", new String[] { "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.profile", "vnd.android.cursor.item/vnd.com.tencent.mm.plugin.sns.timeline", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip.video", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voiceaction", paramString }, null);
      if (paramString == null)
      {
        y.e("MicroMsg.ContactsOperations", "get null cursor");
        return;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        y.e("MicroMsg.ContactsOperations", "query fail, match error %s \n %s", new Object[] { paramString.getMessage(), bk.j(paramString) });
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
          if ((!bk.bl(str1)) && (!bk.bl(str2)))
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
        y.e("MicroMsg.ContactsOperations", "delete wechat contact failed : " + localException.getMessage());
        continue;
      }
      paramString.close();
      return;
      str1 = "";
      continue;
      str2 = "";
    }
  }
  
  private boolean pb(String paramString)
  {
    boolean bool2 = false;
    if (!com.tencent.mm.pluginsdk.permission.a.j(this.mContext, "android.permission.READ_CONTACTS")) {
      y.e("MicroMsg.ContactsOperations", "no contact permission");
    }
    for (;;)
    {
      return bool2;
      try
      {
        localCursor = this.mContext.getContentResolver().query(ContactsContract.Data.CONTENT_URI, new String[] { "contact_id" }, "mimetype= ?", new String[] { paramString }, null);
        if (localCursor == null) {}
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          try
          {
            if (localCursor.getCount() <= 0) {
              break label153;
            }
            y.d("MicroMsg.ContactsOperations", "has minetype:" + paramString);
            bool1 = true;
            bool2 = bool1;
            if (localCursor == null) {
              break;
            }
            localCursor.close();
            return bool1;
          }
          catch (Exception paramString)
          {
            Cursor localCursor;
            continue;
          }
          paramString = paramString;
          localCursor = null;
          y.e("MicroMsg.ContactsOperations", "hasMIMEType search failed : " + paramString.getMessage());
          boolean bool1 = true;
          continue;
          label153:
          bool1 = false;
        }
      }
    }
  }
  
  private void quit()
  {
    if (this.eRq != null) {
      this.eRq.quit();
    }
  }
  
  public final void run()
  {
    Looper.prepare();
    this.eRq = Looper.myLooper();
    long l = System.currentTimeMillis();
    y.i("MicroMsg.ContactsOperations", "start time:" + l);
    if (!com.tencent.mm.kernel.g.DN().Dc())
    {
      y.w("MicroMsg.ContactsOperations", "account not ready, quit this operation");
      quit();
      return;
    }
    if ((bk.bl(this.username)) && (bk.bl(this.bRj))) {
      UK();
    }
    for (;;)
    {
      y.i("MicroMsg.ContactsOperations", "end time:" + System.currentTimeMillis());
      Looper.loop();
      return;
      if (!bk.bl(this.bRj)) {
        break;
      }
      locala = ((b)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).pH(this.username);
      if ((locala != null) && (!bk.bl(locala.ffg))) {
        pa(locala.ffg);
      }
      quit();
    }
    com.tencent.mm.plugin.account.friend.a.a locala = ((b)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).pH(this.username);
    if ((locala == null) || (bk.bl(locala.ffg))) {
      locala = ((b)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).pH(this.bRj);
    }
    for (;;)
    {
      for (;;)
      {
        if ((locala != null) && (!bk.bl(locala.ffg))) {
          try
          {
            if (!com.tencent.mm.pluginsdk.permission.a.j(this.mContext, "android.permission.READ_CONTACTS")) {
              y.e("MicroMsg.ContactsOperations", "no contact permission");
            }
          }
          catch (Exception localException)
          {
            y.printErrStackTrace("MicroMsg.ContactsOperations", localException, "", new Object[] { "" });
          }
        }
      }
      for (;;)
      {
        quit();
        break;
        Object localObject1 = ContactsContract.RawContacts.CONTENT_URI.buildUpon().appendQueryParameter("account_name", this.eRo.name).appendQueryParameter("account_type", this.eRo.type).build();
        Object localObject2 = this.mContext.getContentResolver();
        String str = "deleted=\"0\" AND sync1=\"" + localException.ffg + "\"";
        localObject2 = ((ContentResolver)localObject2).query((Uri)localObject1, new String[] { "sync1", "_id" }, str, null, null);
        if ((localObject2 == null) || (((Cursor)localObject2).getCount() == 0)) {
          if (!bk.bl(localException.Wx())) {
            break label484;
          }
        }
        label484:
        for (localObject1 = localException.WA();; localObject1 = localException.Wx())
        {
          this.eRp = new h.a(this, this.mContext.getContentResolver());
          e((String)localObject1, localException.WD(), localException.ffg, this.username);
          this.eRp.execute();
          if (localObject2 == null) {
            break;
          }
          ((Cursor)localObject2).close();
          break;
        }
        y.d("MicroMsg.ContactsOperations", "query addrupload is null " + this.username);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.platformtools.h
 * JD-Core Version:    0.7.0.1
 */