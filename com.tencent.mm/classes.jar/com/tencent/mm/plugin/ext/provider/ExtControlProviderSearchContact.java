package com.tencent.mm.plugin.ext.provider;

import android.content.ContentValues;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.d;
import com.tencent.mm.aj.p;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.ext.key.AESUtil;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storagebase.e;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

@JgClassChecked(author=32, fComment="checked", lastDate="20141016", reviewer=20, vComment={com.jg.EType.PROVIDERCHECK})
public class ExtControlProviderSearchContact
  extends ExtContentProviderBase
{
  private static List<String> gzY;
  private static final String[] sNF;
  private Cursor sNJ = null;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(24467);
    sNF = new String[] { "userId", "nickname", "avatar", "content", "msgId", "msgType" };
    gzY = new ArrayList();
    String[] arrayOfString = ab.iCO;
    int j = arrayOfString.length;
    while (i < j)
    {
      String str = arrayOfString[i];
      gzY.add(str);
      i += 1;
    }
    gzY.add("officialaccounts");
    gzY.add("helper_entry");
    AppMethodBeat.o(24467);
  }
  
  public static Cursor e(Cursor paramCursor)
  {
    AppMethodBeat.i(24466);
    e locale = new e(sNF, (byte)0);
    for (;;)
    {
      try
      {
        if (paramCursor.moveToFirst())
        {
          int i = 0;
          i += 1;
          localObject2 = new as();
          ((as)localObject2).convertFrom(paramCursor);
          if (!ab.Eq(((ax)localObject2).field_username))
          {
            localObject3 = p.aYD().K(((ax)localObject2).field_username, true);
            if (localObject3 != null)
            {
              localObject1 = new ByteArrayOutputStream();
              ((Bitmap)localObject3).compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject1);
              bg.aVF();
              localObject3 = com.tencent.mm.model.c.aSQ().eH(((ax)localObject2).field_username, 1);
              if ((localObject3 == null) || (localObject3.length != 1)) {
                continue;
              }
              String str1 = AESUtil.DC((int)((com.tencent.mm.contact.c)localObject2).gMZ);
              String str2 = ((as)localObject2).arJ();
              if (localObject1 != null) {
                continue;
              }
              localObject1 = null;
              if (localObject3[0].getType() != 1) {
                break label400;
              }
              localObject2 = localObject3[0].field_content;
              locale.addRow(new Object[] { str1, str2, localObject1, localObject2, AESUtil.DC(localObject3[0].field_msgId), Integer.valueOf(com.tencent.mm.plugin.ext.b.b.av(localObject3[0])) });
            }
          }
          else
          {
            if ((paramCursor.moveToNext()) && (i < 15)) {
              break label397;
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
        Object localObject3 = AESUtil.DC((int)((com.tencent.mm.contact.c)localObject2).gMZ);
        localObject2 = ((as)localObject2).arJ();
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
      label397:
      continue;
      label400:
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
      HF(3);
      AppMethodBeat.o(24465);
      return null;
    }
    if ((Util.isNullOrNil(this.sMZ)) || (Util.isNullOrNil(cSt())))
    {
      HF(3);
      AppMethodBeat.o(24465);
      return null;
    }
    if (!ckf())
    {
      HF(1);
      paramUri = this.pem;
      AppMethodBeat.o(24465);
      return paramUri;
    }
    if (!fe(getContext()))
    {
      Log.w("MicroMsg.ExtControlProviderSearchContact", "invalid appid ! return null");
      HF(2);
      AppMethodBeat.o(24465);
      return null;
    }
    if ((paramArrayOfString2 == null) || (paramArrayOfString2.length == 0))
    {
      Log.e("MicroMsg.ExtControlProviderSearchContact", "invaild selections");
      HF(3);
      AppMethodBeat.o(24465);
      return null;
    }
    paramUri = paramArrayOfString2[0].trim();
    if (Util.isNullOrNil(paramUri))
    {
      Log.e("MicroMsg.ExtControlProviderSearchContact", "filter should not be null or nil");
      HF(3);
      AppMethodBeat.o(24465);
      return null;
    }
    paramUri = bg.aVF().iBp.a(paramUri, "@micromsg.no.verify.biz.qq.com", gzY, false, 1, null);
    if (paramUri == null)
    {
      Log.e("MicroMsg.ExtControlProviderSearchContact", "cursor is null");
      HF(3);
      AppMethodBeat.o(24465);
      return null;
    }
    paramArrayOfString1 = new com.tencent.mm.pluginsdk.d.a.b();
    paramArrayOfString1.c(4000L, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24464);
        ExtControlProviderSearchContact.a(ExtControlProviderSearchContact.this, ExtControlProviderSearchContact.e(paramUri));
        paramArrayOfString1.countDown();
        AppMethodBeat.o(24464);
      }
    });
    if (this.sNJ != null) {
      HF(0);
    }
    for (;;)
    {
      paramUri = this.sNJ;
      AppMethodBeat.o(24465);
      return paramUri;
      HF(4);
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