package com.tencent.mm.plugin.ext.provider;

import android.content.ContentValues;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import com.jg.JgClassChecked;
import com.tencent.mm.ag.o;
import com.tencent.mm.cf.e;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bo;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

@JgClassChecked(author=32, fComment="checked", lastDate="20141016", reviewer=20, vComment={com.jg.EType.PROVIDERCHECK})
public class ExtControlProviderSearchContact
  extends ExtContentProviderBase
{
  private static List<String> dru;
  private static final String[] jKK;
  private Cursor jKO = null;
  
  static
  {
    int i = 0;
    jKK = new String[] { "userId", "nickname", "avatar", "content", "msgId", "msgType" };
    dru = new ArrayList();
    String[] arrayOfString = s.dVc;
    int j = arrayOfString.length;
    while (i < j)
    {
      String str = arrayOfString[i];
      dru.add(str);
      i += 1;
    }
    dru.add("officialaccounts");
    dru.add("helper_entry");
  }
  
  public static Cursor g(Cursor paramCursor)
  {
    e locale = new e(jKK, (byte)0);
    for (;;)
    {
      try
      {
        if (paramCursor.moveToFirst())
        {
          int i = 0;
          i += 1;
          localObject2 = new ad();
          ((ad)localObject2).d(paramCursor);
          if (!s.fn(((ao)localObject2).field_username))
          {
            localObject3 = o.Kj().b(((ao)localObject2).field_username, true, 0);
            if (localObject3 != null)
            {
              localObject1 = new ByteArrayOutputStream();
              ((Bitmap)localObject3).compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject1);
              au.Hx();
              localObject3 = com.tencent.mm.model.c.Fy().bV(((ao)localObject2).field_username, 1);
              if ((localObject3 == null) || (localObject3.length != 1)) {
                continue;
              }
              String str1 = com.tencent.mm.plugin.ext.a.a.ei((int)((com.tencent.mm.n.a)localObject2).dBe);
              String str2 = ((ad)localObject2).Bq();
              if (localObject1 != null) {
                continue;
              }
              localObject1 = null;
              if (localObject3[0].getType() != 1) {
                break label383;
              }
              localObject2 = localObject3[0].field_content;
              locale.addRow(new Object[] { str1, str2, localObject1, localObject2, com.tencent.mm.plugin.ext.a.a.ei(localObject3[0].field_msgId), Integer.valueOf(com.tencent.mm.plugin.ext.b.b.P(localObject3[0])) });
            }
          }
          else
          {
            if ((paramCursor.moveToNext()) && (i < 15)) {
              break label380;
            }
          }
        }
        else
        {
          paramCursor.close();
          return locale;
        }
        y.w("MicroMsg.ExtControlProviderSearchContact", "get useravatar is null");
        Object localObject1 = null;
        continue;
        localObject1 = ((ByteArrayOutputStream)localObject1).toByteArray();
        continue;
        y.w("MicroMsg.ExtControlProviderSearchContact", "get msginfo failed");
        Object localObject3 = com.tencent.mm.plugin.ext.a.a.ei((int)((com.tencent.mm.n.a)localObject2).dBe);
        localObject2 = ((ad)localObject2).Bq();
        if (localObject1 == null)
        {
          localObject1 = null;
          locale.addRow(new Object[] { localObject3, localObject2, localObject1, "", "0", Integer.valueOf(0) });
          continue;
        }
        byte[] arrayOfByte = localException.toByteArray();
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.ExtControlProviderSearchContact", localException.getMessage());
        y.printErrStackTrace("MicroMsg.ExtControlProviderSearchContact", localException, "", new Object[0]);
        if (paramCursor != null) {
          paramCursor.close();
        }
        locale.close();
        return null;
      }
      continue;
      label380:
      continue;
      label383:
      Object localObject2 = "";
    }
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
    y.d("MicroMsg.ExtControlProviderSearchContact", "query()");
    a(paramUri, getContext(), 16);
    if (paramUri == null)
    {
      qF(3);
      return null;
    }
    if ((bk.bl(this.jKd)) || (bk.bl(aNA())))
    {
      qF(3);
      return null;
    }
    if (!awd())
    {
      qF(1);
      return this.hSn;
    }
    if (!dc(getContext()))
    {
      y.w("MicroMsg.ExtControlProviderSearchContact", "invalid appid ! return null");
      qF(2);
      return null;
    }
    if ((paramArrayOfString2 == null) || (paramArrayOfString2.length == 0))
    {
      y.e("MicroMsg.ExtControlProviderSearchContact", "invaild selections");
      qF(3);
      return null;
    }
    paramUri = paramArrayOfString2[0].trim();
    if (bk.bl(paramUri))
    {
      y.e("MicroMsg.ExtControlProviderSearchContact", "filter should not be null or nil");
      qF(3);
      return null;
    }
    paramUri = au.Hx().dUi.a(paramUri, "@micromsg.no.verify.biz.qq.com", dru, false, 1, null);
    if (paramUri == null)
    {
      y.e("MicroMsg.ExtControlProviderSearchContact", "cursor is null");
      qF(3);
      return null;
    }
    paramArrayOfString1 = new com.tencent.mm.pluginsdk.d.a.b();
    paramArrayOfString1.b(4000L, new ExtControlProviderSearchContact.1(this, paramUri, paramArrayOfString1));
    if (this.jKO != null) {
      qF(0);
    }
    for (;;)
    {
      return this.jKO;
      qF(4);
    }
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.provider.ExtControlProviderSearchContact
 * JD-Core Version:    0.7.0.1
 */