package com.tencent.mm.plugin.ext.provider;

import android.content.ContentValues;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.contact.d;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.plugin.ext.key.AESUtil;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class ExtControlProviderSearchContact
  extends ExtContentProviderBase
{
  private static List<String> lMF;
  private static final String[] zPG;
  private Cursor zPK = null;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(24467);
    zPG = new String[] { "userId", "nickname", "avatar", "content", "msgId", "msgType" };
    lMF = new ArrayList();
    String[] arrayOfString = ab.oko;
    int j = arrayOfString.length;
    while (i < j)
    {
      String str = arrayOfString[i];
      lMF.add(str);
      i += 1;
    }
    lMF.add("officialaccounts");
    lMF.add("helper_entry");
    AppMethodBeat.o(24467);
  }
  
  public static Cursor h(Cursor paramCursor)
  {
    AppMethodBeat.i(24466);
    com.tencent.mm.storagebase.e locale = new com.tencent.mm.storagebase.e(zPG, (byte)0);
    for (;;)
    {
      try
      {
        if (paramCursor.moveToFirst())
        {
          int i = 0;
          i += 1;
          localObject2 = new au();
          ((au)localObject2).convertFrom(paramCursor);
          if (!au.bwE(((az)localObject2).field_username))
          {
            localObject3 = q.bFG().b(((az)localObject2).field_username, true, 0, null);
            if (localObject3 != null)
            {
              localObject1 = new ByteArrayOutputStream();
              ((Bitmap)localObject3).compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject1);
              bh.bCz();
              localObject3 = c.bzD().gb(((az)localObject2).field_username, 1);
              if ((localObject3 == null) || (localObject3.length != 1)) {
                continue;
              }
              String str1 = AESUtil.mo((int)((d)localObject2).maN);
              String str2 = ((au)localObject2).aSV();
              if (localObject1 != null) {
                continue;
              }
              localObject1 = null;
              if (localObject3[0].getType() != 1) {
                break label402;
              }
              localObject2 = localObject3[0].field_content;
              locale.addRow(new Object[] { str1, str2, localObject1, localObject2, AESUtil.mo(localObject3[0].field_msgId), Integer.valueOf(com.tencent.mm.plugin.ext.b.b.aR(localObject3[0])) });
            }
          }
          else
          {
            if ((paramCursor.moveToNext()) && (i < 15)) {
              break label399;
            }
          }
        }
        else
        {
          paramCursor.close();
          AppMethodBeat.o(24466);
          return locale;
        }
        Log.w("MicroMsg.ExtControlProviderSearchContact", "get useravatar is null");
        Object localObject1 = null;
        continue;
        localObject1 = ((ByteArrayOutputStream)localObject1).toByteArray();
        continue;
        Log.w("MicroMsg.ExtControlProviderSearchContact", "get msginfo failed");
        Object localObject3 = AESUtil.mo((int)((d)localObject2).maN);
        localObject2 = ((au)localObject2).aSV();
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
        Log.e("MicroMsg.ExtControlProviderSearchContact", localException.getMessage());
        Log.printErrStackTrace("MicroMsg.ExtControlProviderSearchContact", localException, "", new Object[0]);
        if (paramCursor != null) {
          paramCursor.close();
        }
        locale.close();
        AppMethodBeat.o(24466);
        return null;
      }
      continue;
      label399:
      continue;
      label402:
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
  
  public Cursor query(final Uri paramUri, final String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    AppMethodBeat.i(24465);
    Log.d("MicroMsg.ExtControlProviderSearchContact", "query()");
    a(paramUri, getContext(), 16);
    if (paramUri == null)
    {
      Mm(3);
      AppMethodBeat.o(24465);
      return null;
    }
    if ((Util.isNullOrNil(this.zPa)) || (Util.isNullOrNil(dOe())))
    {
      Mm(3);
      AppMethodBeat.o(24465);
      return null;
    }
    if (!dak())
    {
      Mm(1);
      paramUri = this.vsh;
      AppMethodBeat.o(24465);
      return paramUri;
    }
    if (!gh(getContext()))
    {
      Log.w("MicroMsg.ExtControlProviderSearchContact", "invalid appid ! return null");
      Mm(2);
      AppMethodBeat.o(24465);
      return null;
    }
    if ((paramArrayOfString2 == null) || (paramArrayOfString2.length == 0))
    {
      Log.e("MicroMsg.ExtControlProviderSearchContact", "invaild selections");
      Mm(3);
      AppMethodBeat.o(24465);
      return null;
    }
    paramUri = paramArrayOfString2[0].trim();
    if (Util.isNullOrNil(paramUri))
    {
      Log.e("MicroMsg.ExtControlProviderSearchContact", "filter should not be null or nil");
      Mm(3);
      AppMethodBeat.o(24465);
      return null;
    }
    paramUri = bh.bCz().oiu.a(paramUri, "@micromsg.no.verify.biz.qq.com", lMF, false, 1, null);
    if (paramUri == null)
    {
      Log.e("MicroMsg.ExtControlProviderSearchContact", "cursor is null");
      Mm(3);
      AppMethodBeat.o(24465);
      return null;
    }
    paramArrayOfString1 = new com.tencent.mm.pluginsdk.d.a.b();
    paramArrayOfString1.c(4000L, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24464);
        ExtControlProviderSearchContact.a(ExtControlProviderSearchContact.this, ExtControlProviderSearchContact.h(paramUri));
        paramArrayOfString1.asP();
        AppMethodBeat.o(24464);
      }
    });
    if (this.zPK != null) {
      Mm(0);
    }
    for (;;)
    {
      paramUri = this.zPK;
      AppMethodBeat.o(24465);
      return paramUri;
      Mm(4);
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