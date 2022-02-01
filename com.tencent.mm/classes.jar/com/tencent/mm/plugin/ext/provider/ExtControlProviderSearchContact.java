package com.tencent.mm.plugin.ext.provider;

import android.content.ContentValues;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.p;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.ext.key.AESUtil;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storagebase.e;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

@JgClassChecked(author=32, fComment="checked", lastDate="20141016", reviewer=20, vComment={com.jg.EType.PROVIDERCHECK})
public class ExtControlProviderSearchContact
  extends ExtContentProviderBase
{
  private static List<String> fvP;
  private static final String[] pLz;
  private Cursor pLD = null;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(24467);
    pLz = new String[] { "userId", "nickname", "avatar", "content", "msgId", "msgType" };
    fvP = new ArrayList();
    String[] arrayOfString = w.gMw;
    int j = arrayOfString.length;
    while (i < j)
    {
      String str = arrayOfString[i];
      fvP.add(str);
      i += 1;
    }
    fvP.add("officialaccounts");
    fvP.add("helper_entry");
    AppMethodBeat.o(24467);
  }
  
  public static Cursor f(Cursor paramCursor)
  {
    AppMethodBeat.i(24466);
    e locale = new e(pLz, (byte)0);
    for (;;)
    {
      try
      {
        if (paramCursor.moveToFirst())
        {
          int i = 0;
          i += 1;
          localObject2 = new af();
          ((af)localObject2).convertFrom(paramCursor);
          if (!w.pF(((au)localObject2).field_username))
          {
            localObject3 = p.auH().b(((au)localObject2).field_username, true, 0, null);
            if (localObject3 != null)
            {
              localObject1 = new ByteArrayOutputStream();
              ((Bitmap)localObject3).compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject1);
              az.arV();
              localObject3 = c.apO().dO(((au)localObject2).field_username, 1);
              if ((localObject3 == null) || (localObject3.length != 1)) {
                continue;
              }
              String str1 = AESUtil.pw((int)((com.tencent.mm.n.b)localObject2).fId);
              String str2 = ((af)localObject2).ZX();
              if (localObject1 != null) {
                continue;
              }
              localObject1 = null;
              if (localObject3[0].getType() != 1) {
                break label402;
              }
              localObject2 = localObject3[0].field_content;
              locale.addRow(new Object[] { str1, str2, localObject1, localObject2, AESUtil.pw(localObject3[0].field_msgId), Integer.valueOf(com.tencent.mm.plugin.ext.b.b.ai(localObject3[0])) });
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
        ad.w("MicroMsg.ExtControlProviderSearchContact", "get useravatar is null");
        Object localObject1 = null;
        continue;
        localObject1 = ((ByteArrayOutputStream)localObject1).toByteArray();
        continue;
        ad.w("MicroMsg.ExtControlProviderSearchContact", "get msginfo failed");
        Object localObject3 = AESUtil.pw((int)((com.tencent.mm.n.b)localObject2).fId);
        localObject2 = ((af)localObject2).ZX();
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
        ad.e("MicroMsg.ExtControlProviderSearchContact", localException.getMessage());
        ad.printErrStackTrace("MicroMsg.ExtControlProviderSearchContact", localException, "", new Object[0]);
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
    ad.d("MicroMsg.ExtControlProviderSearchContact", "query()");
    a(paramUri, getContext(), 16);
    if (paramUri == null)
    {
      BS(3);
      AppMethodBeat.o(24465);
      return null;
    }
    if ((com.tencent.mm.sdk.platformtools.bt.isNullOrNil(this.pKT)) || (com.tencent.mm.sdk.platformtools.bt.isNullOrNil(ceX())))
    {
      BS(3);
      AppMethodBeat.o(24465);
      return null;
    }
    if (!bBg())
    {
      BS(1);
      paramUri = this.mKX;
      AppMethodBeat.o(24465);
      return paramUri;
    }
    if (!ey(getContext()))
    {
      ad.w("MicroMsg.ExtControlProviderSearchContact", "invalid appid ! return null");
      BS(2);
      AppMethodBeat.o(24465);
      return null;
    }
    if ((paramArrayOfString2 == null) || (paramArrayOfString2.length == 0))
    {
      ad.e("MicroMsg.ExtControlProviderSearchContact", "invaild selections");
      BS(3);
      AppMethodBeat.o(24465);
      return null;
    }
    paramUri = paramArrayOfString2[0].trim();
    if (com.tencent.mm.sdk.platformtools.bt.isNullOrNil(paramUri))
    {
      ad.e("MicroMsg.ExtControlProviderSearchContact", "filter should not be null or nil");
      BS(3);
      AppMethodBeat.o(24465);
      return null;
    }
    paramUri = az.arV().gLz.a(paramUri, "@micromsg.no.verify.biz.qq.com", fvP, false, 1, null);
    if (paramUri == null)
    {
      ad.e("MicroMsg.ExtControlProviderSearchContact", "cursor is null");
      BS(3);
      AppMethodBeat.o(24465);
      return null;
    }
    paramArrayOfString1 = new com.tencent.mm.pluginsdk.d.a.b();
    paramArrayOfString1.b(4000L, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24464);
        ExtControlProviderSearchContact.a(ExtControlProviderSearchContact.this, ExtControlProviderSearchContact.f(paramUri));
        paramArrayOfString1.countDown();
        AppMethodBeat.o(24464);
      }
    });
    if (this.pLD != null) {
      BS(0);
    }
    for (;;)
    {
      paramUri = this.pLD;
      AppMethodBeat.o(24465);
      return paramUri;
      BS(4);
    }
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.provider.ExtControlProviderSearchContact
 * JD-Core Version:    0.7.0.1
 */