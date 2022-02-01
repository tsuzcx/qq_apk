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
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bt;
import com.tencent.mm.model.c;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.ext.key.AESUtil;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storagebase.e;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

@JgClassChecked(author=32, fComment="checked", lastDate="20141016", reviewer=20, vComment={com.jg.EType.PROVIDERCHECK})
public class ExtControlProviderSearchContact
  extends ExtContentProviderBase
{
  private static List<String> fzw;
  private static final String[] quh;
  private Cursor qul = null;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(24467);
    quh = new String[] { "userId", "nickname", "avatar", "content", "msgId", "msgType" };
    fzw = new ArrayList();
    String[] arrayOfString = w.hmW;
    int j = arrayOfString.length;
    while (i < j)
    {
      String str = arrayOfString[i];
      fzw.add(str);
      i += 1;
    }
    fzw.add("officialaccounts");
    fzw.add("helper_entry");
    AppMethodBeat.o(24467);
  }
  
  public static Cursor e(Cursor paramCursor)
  {
    AppMethodBeat.i(24466);
    e locale = new e(quh, (byte)0);
    for (;;)
    {
      try
      {
        if (paramCursor.moveToFirst())
        {
          int i = 0;
          i += 1;
          localObject2 = new ai();
          ((ai)localObject2).convertFrom(paramCursor);
          if (!w.sQ(((av)localObject2).field_username))
          {
            localObject3 = p.aBy().b(((av)localObject2).field_username, true, 0, null);
            if (localObject3 != null)
            {
              localObject1 = new ByteArrayOutputStream();
              ((Bitmap)localObject3).compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject1);
              az.ayM();
              localObject3 = c.awD().dV(((av)localObject2).field_username, 1);
              if ((localObject3 == null) || (localObject3.length != 1)) {
                continue;
              }
              String str1 = AESUtil.tl((int)((com.tencent.mm.n.b)localObject2).fLJ);
              String str2 = ((ai)localObject2).aaS();
              if (localObject1 != null) {
                continue;
              }
              localObject1 = null;
              if (localObject3[0].getType() != 1) {
                break label402;
              }
              localObject2 = localObject3[0].field_content;
              locale.addRow(new Object[] { str1, str2, localObject1, localObject2, AESUtil.tl(localObject3[0].field_msgId), Integer.valueOf(com.tencent.mm.plugin.ext.b.b.ai(localObject3[0])) });
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
        ac.w("MicroMsg.ExtControlProviderSearchContact", "get useravatar is null");
        Object localObject1 = null;
        continue;
        localObject1 = ((ByteArrayOutputStream)localObject1).toByteArray();
        continue;
        ac.w("MicroMsg.ExtControlProviderSearchContact", "get msginfo failed");
        Object localObject3 = AESUtil.tl((int)((com.tencent.mm.n.b)localObject2).fLJ);
        localObject2 = ((ai)localObject2).aaS();
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
        ac.e("MicroMsg.ExtControlProviderSearchContact", localException.getMessage());
        ac.printErrStackTrace("MicroMsg.ExtControlProviderSearchContact", localException, "", new Object[0]);
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
    ac.d("MicroMsg.ExtControlProviderSearchContact", "query()");
    a(paramUri, getContext(), 16);
    if (paramUri == null)
    {
      CN(3);
      AppMethodBeat.o(24465);
      return null;
    }
    if ((bs.isNullOrNil(this.qtA)) || (bs.isNullOrNil(cmE())))
    {
      CN(3);
      AppMethodBeat.o(24465);
      return null;
    }
    if (!bIc())
    {
      CN(1);
      paramUri = this.nng;
      AppMethodBeat.o(24465);
      return paramUri;
    }
    if (!eG(getContext()))
    {
      ac.w("MicroMsg.ExtControlProviderSearchContact", "invalid appid ! return null");
      CN(2);
      AppMethodBeat.o(24465);
      return null;
    }
    if ((paramArrayOfString2 == null) || (paramArrayOfString2.length == 0))
    {
      ac.e("MicroMsg.ExtControlProviderSearchContact", "invaild selections");
      CN(3);
      AppMethodBeat.o(24465);
      return null;
    }
    paramUri = paramArrayOfString2[0].trim();
    if (bs.isNullOrNil(paramUri))
    {
      ac.e("MicroMsg.ExtControlProviderSearchContact", "filter should not be null or nil");
      CN(3);
      AppMethodBeat.o(24465);
      return null;
    }
    paramUri = az.ayM().hlZ.a(paramUri, "@micromsg.no.verify.biz.qq.com", fzw, false, 1, null);
    if (paramUri == null)
    {
      ac.e("MicroMsg.ExtControlProviderSearchContact", "cursor is null");
      CN(3);
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
    if (this.qul != null) {
      CN(0);
    }
    for (;;)
    {
      paramUri = this.qul;
      AppMethodBeat.o(24465);
      return paramUri;
      CN(4);
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