package com.tencent.mm.plugin.ext.provider;

import android.content.ContentValues;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.o;
import com.tencent.mm.cg.e;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
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
  private static List<String> ejc;
  private static final String[] meO;
  private Cursor meS = null;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(20388);
    meO = new String[] { "userId", "nickname", "avatar", "content", "msgId", "msgType" };
    ejc = new ArrayList();
    String[] arrayOfString = t.fll;
    int j = arrayOfString.length;
    while (i < j)
    {
      String str = arrayOfString[i];
      ejc.add(str);
      i += 1;
    }
    ejc.add("officialaccounts");
    ejc.add("helper_entry");
    AppMethodBeat.o(20388);
  }
  
  public static Cursor e(Cursor paramCursor)
  {
    AppMethodBeat.i(20387);
    e locale = new e(meO, (byte)0);
    for (;;)
    {
      try
      {
        if (paramCursor.moveToFirst())
        {
          int i = 0;
          i += 1;
          localObject2 = new ad();
          ((ad)localObject2).convertFrom(paramCursor);
          if (!t.lA(((aq)localObject2).field_username))
          {
            localObject3 = o.adi().c(((aq)localObject2).field_username, true, 0);
            if (localObject3 != null)
            {
              localObject1 = new ByteArrayOutputStream();
              ((Bitmap)localObject3).compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject1);
              aw.aaz();
              localObject3 = com.tencent.mm.model.c.YC().cM(((aq)localObject2).field_username, 1);
              if ((localObject3 == null) || (localObject3.length != 1)) {
                continue;
              }
              String str1 = com.tencent.mm.plugin.ext.a.a.jF((int)((com.tencent.mm.n.a)localObject2).euF);
              String str2 = ((ad)localObject2).Of();
              if (localObject1 != null) {
                continue;
              }
              localObject1 = null;
              if (localObject3[0].getType() != 1) {
                break label401;
              }
              localObject2 = localObject3[0].field_content;
              locale.addRow(new Object[] { str1, str2, localObject1, localObject2, com.tencent.mm.plugin.ext.a.a.jF(localObject3[0].field_msgId), Integer.valueOf(com.tencent.mm.plugin.ext.b.b.V(localObject3[0])) });
            }
          }
          else
          {
            if ((paramCursor.moveToNext()) && (i < 15)) {
              break label398;
            }
          }
        }
        else
        {
          paramCursor.close();
          AppMethodBeat.o(20387);
          return locale;
        }
        ab.w("MicroMsg.ExtControlProviderSearchContact", "get useravatar is null");
        Object localObject1 = null;
        continue;
        localObject1 = ((ByteArrayOutputStream)localObject1).toByteArray();
        continue;
        ab.w("MicroMsg.ExtControlProviderSearchContact", "get msginfo failed");
        Object localObject3 = com.tencent.mm.plugin.ext.a.a.jF((int)((com.tencent.mm.n.a)localObject2).euF);
        localObject2 = ((ad)localObject2).Of();
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
        ab.e("MicroMsg.ExtControlProviderSearchContact", localException.getMessage());
        ab.printErrStackTrace("MicroMsg.ExtControlProviderSearchContact", localException, "", new Object[0]);
        if (paramCursor != null) {
          paramCursor.close();
        }
        locale.close();
        AppMethodBeat.o(20387);
        return null;
      }
      continue;
      label398:
      continue;
      label401:
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
    AppMethodBeat.i(20386);
    ab.d("MicroMsg.ExtControlProviderSearchContact", "query()");
    a(paramUri, getContext(), 16);
    if (paramUri == null)
    {
      vA(3);
      AppMethodBeat.o(20386);
      return null;
    }
    if ((bo.isNullOrNil(this.mei)) || (bo.isNullOrNil(btD())))
    {
      vA(3);
      AppMethodBeat.o(20386);
      return null;
    }
    if (!aVH())
    {
      vA(1);
      paramUri = this.jLW;
      AppMethodBeat.o(20386);
      return paramUri;
    }
    if (!dO(getContext()))
    {
      ab.w("MicroMsg.ExtControlProviderSearchContact", "invalid appid ! return null");
      vA(2);
      AppMethodBeat.o(20386);
      return null;
    }
    if ((paramArrayOfString2 == null) || (paramArrayOfString2.length == 0))
    {
      ab.e("MicroMsg.ExtControlProviderSearchContact", "invaild selections");
      vA(3);
      AppMethodBeat.o(20386);
      return null;
    }
    paramUri = paramArrayOfString2[0].trim();
    if (bo.isNullOrNil(paramUri))
    {
      ab.e("MicroMsg.ExtControlProviderSearchContact", "filter should not be null or nil");
      vA(3);
      AppMethodBeat.o(20386);
      return null;
    }
    paramUri = aw.aaz().fkr.a(paramUri, "@micromsg.no.verify.biz.qq.com", ejc, false, 1, null);
    if (paramUri == null)
    {
      ab.e("MicroMsg.ExtControlProviderSearchContact", "cursor is null");
      vA(3);
      AppMethodBeat.o(20386);
      return null;
    }
    paramArrayOfString1 = new com.tencent.mm.pluginsdk.d.a.b();
    paramArrayOfString1.b(4000L, new ExtControlProviderSearchContact.1(this, paramUri, paramArrayOfString1));
    if (this.meS != null) {
      vA(0);
    }
    for (;;)
    {
      paramUri = this.meS;
      AppMethodBeat.o(20386);
      return paramUri;
      vA(4);
    }
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.provider.ExtControlProviderSearchContact
 * JD-Core Version:    0.7.0.1
 */