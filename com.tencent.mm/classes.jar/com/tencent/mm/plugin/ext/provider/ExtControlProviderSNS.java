package com.tencent.mm.plugin.ext.provider;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import com.jg.JgClassChecked;
import com.tencent.mm.cf.e;
import com.tencent.mm.h.a.fd;
import com.tencent.mm.h.a.fd.b;
import com.tencent.mm.h.a.fe;
import com.tencent.mm.h.a.fe.b;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.util.List;

@JgClassChecked(author=32, fComment="checked", lastDate="20141016", reviewer=20, vComment={com.jg.EType.PROVIDERCHECK})
public final class ExtControlProviderSNS
  extends ExtContentProviderBase
{
  private static boolean dCs = false;
  private static am jKI = new am(new ExtControlProviderSNS.1(), false);
  private static final String[] jKK = { "feedId", "desc", "url", "nickname", "avatar", "timestamp", "mediaCount", "type", "bigImgUrl", "firstImgWidth", "firstImgHeight" };
  private static final UriMatcher jKj;
  private boolean bMn = false;
  private boolean bMo = false;
  private int bMp = 0;
  private String jKL = "";
  
  static
  {
    UriMatcher localUriMatcher = new UriMatcher(-1);
    jKj = localUriMatcher;
    localUriMatcher.addURI("com.tencent.mm.plugin.ext.SNS", "snsInfo", 17);
  }
  
  private Cursor aNF()
  {
    y.i("MicroMsg.ExtControlProviderSNS", "getSnsCursor() , needDownload = true");
    e locale = new e(jKK, (byte)0);
    Object localObject1 = new fd();
    ((fd)localObject1).bLD.bLF = this.jKL;
    if (!com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1))
    {
      locale.close();
      return null;
    }
    Cursor localCursor = ((fd)localObject1).bLE.bLw;
    if (localCursor != null) {}
    for (;;)
    {
      try
      {
        i = localCursor.getCount();
        y.i("MicroMsg.ExtControlProviderSNS", "in getSnsCursor(), snsCount = " + i);
        fe localfe;
        if ((i > 0) && (localCursor.moveToFirst()))
        {
          if (localCursor != null)
          {
            localfe = new fe();
            localfe.bLG.bLI = localCursor;
            if (!com.tencent.mm.sdk.b.a.udP.m(localfe)) {
              y.w("MicroMsg.ExtControlProviderSNS", "ExtGetSnsDataEvent publish error");
            }
          }
          else
          {
            if (localCursor.moveToNext()) {
              continue;
            }
          }
        }
        else
        {
          y.i("MicroMsg.ExtControlProviderSNS", "in getSnsCursor(), matrixCursor Count = " + locale.getCount());
          localCursor.close();
          break label808;
        }
        au.Hx();
        Object localObject2 = c.Fw().abj(localfe.bLH.bLJ);
        if ((localObject2 == null) || ((int)((com.tencent.mm.n.a)localObject2).dBe <= 0)) {
          continue;
        }
        String str3 = "";
        switch (localfe.bLH.bLN)
        {
        case 2: 
          if ((localfe.bLH.bLP == null) || (localfe.bLH.bLP.size() <= 0) || (getContext() == null)) {
            break label802;
          }
          y.d("MicroMsg.ExtControlProviderSNS", "uris.size() = [%s]", new Object[] { Integer.valueOf(localfe.bLH.bLP.size()) });
          if ((i != 2) && (i != 6) && (i != 3) && (i != 4)) {
            break label802;
          }
          localObject1 = (String)localfe.bLH.bLP.get(0);
          String str2 = str3;
          if (localfe.bLH.bLQ != null)
          {
            str2 = str3;
            if (localfe.bLH.bLQ.size() > 0)
            {
              str2 = str3;
              if (getContext() != null)
              {
                y.d("MicroMsg.ExtControlProviderSNS", "bigImgUris.size() = [%s], firstImgWidth = [%s], firstImgHeight = [%s]", new Object[] { Integer.valueOf(localfe.bLH.bLQ.size()), Integer.valueOf(localfe.bLH.bLR), Integer.valueOf(localfe.bLH.bLS) });
                if ((i != 2) && (i != 6) && (i != 3))
                {
                  str2 = str3;
                  if (i != 4) {}
                }
                else
                {
                  str2 = (String)localfe.bLH.bLQ.get(0);
                }
              }
            }
          }
          str3 = com.tencent.mm.ag.b.jZ(localfe.bLH.bLJ);
          try
          {
            String str4 = com.tencent.mm.plugin.ext.a.a.ei(localfe.bLH.bLK);
            String str5 = localfe.bLH.bLL;
            String str6 = ((ad)localObject2).Bq();
            localObject2 = str3;
            if (str3 == null) {
              localObject2 = "";
            }
            locale.addRow(new Object[] { str4, str5, localObject1, str6, localObject2, Long.valueOf(localfe.bLH.bLM), Integer.valueOf(localfe.bLH.bLO), Integer.valueOf(i), str2, Integer.valueOf(localfe.bLH.bLR), Integer.valueOf(localfe.bLH.bLS) });
          }
          catch (Exception localException1)
          {
            y.e("MicroMsg.ExtControlProviderSNS", localException1.getMessage());
            y.printErrStackTrace("MicroMsg.ExtControlProviderSNS", localException1, "", new Object[0]);
          }
          continue;
          i = 1;
        }
      }
      catch (Exception localException2)
      {
        y.e("MicroMsg.ExtControlProviderSNS", localException2.getMessage());
        y.printErrStackTrace("MicroMsg.ExtControlProviderSNS", localException2, "", new Object[0]);
        if (localCursor != null) {
          localCursor.close();
        }
        locale.close();
        return null;
      }
      continue;
      int i = 2;
      continue;
      i = 3;
      continue;
      i = 6;
      continue;
      i = 4;
      continue;
      label802:
      String str1 = "";
      continue;
      label808:
      return locale;
      i = 5;
    }
  }
  
  private static void cN(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      dCs = true;
      jKI.S(15000L, 15000L);
      return;
    }
    jKI.S(0L, 0L);
  }
  
  private Cursor ej(long paramLong)
  {
    int i = 1;
    y.i("MicroMsg.ExtControlProviderSNS", "handleGetSnsInfo() userId = " + paramLong);
    try
    {
      y.i("MicroMsg.ExtControlProviderSNS", "startGetSNSInfo, userId=[%s]", new Object[] { Long.valueOf(paramLong) });
      ad localad;
      if (paramLong == 0L)
      {
        au.Hx();
        localad = c.Fw().abj(q.Gj());
        if ((localad != null) && ((int)localad.dBe > 0)) {
          break label122;
        }
        y.e("MicroMsg.ExtControlProviderSNS", "ct == null");
        i = 0;
      }
      for (;;)
      {
        if (i != 0) {
          break label243;
        }
        y.w("MicroMsg.ExtControlProviderSNS", "startGetSNSInfo() return false");
        return null;
        au.Hx();
        localad = c.Fw().hE(paramLong);
        break;
        label122:
        this.bMn = com.tencent.mm.n.a.gR(localad.field_type);
        this.bMo = q.gS(localad.field_username);
        y.d("MicroMsg.ExtControlProviderSNS", "ct.getUsername()=[%s], isFriend=[%s], isSelf=[%s]", new Object[] { localad.field_username, Boolean.valueOf(this.bMn), Boolean.valueOf(this.bMo) });
        com.tencent.mm.pluginsdk.d.a.b localb = new com.tencent.mm.pluginsdk.d.a.b();
        localb.b(10000L, new ExtControlProviderSNS.2(this, localad, localb));
      }
      return aNF();
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.ExtControlProviderSNS", localException.getMessage());
      y.printErrStackTrace("MicroMsg.ExtControlProviderSNS", localException, "", new Object[0]);
    }
  }
  
  public final int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
  
  public final String getType(Uri paramUri)
  {
    return null;
  }
  
  public final Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    return null;
  }
  
  public final boolean onCreate()
  {
    return false;
  }
  
  public final Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    y.i("MicroMsg.ExtControlProviderSNS", "query() " + paramUri);
    a(paramUri, getContext(), jKj);
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
    if (dCs)
    {
      y.w("MicroMsg.ExtControlProviderSNS", "isBusy, return null");
      qF(5);
      return null;
    }
    cN(true);
    if (!awd())
    {
      cN(false);
      qF(1);
      return this.hSn;
    }
    if (!dc(getContext()))
    {
      y.w("MicroMsg.ExtControlProviderSNS", "invalid appid ! return null");
      cN(false);
      qF(2);
      return null;
    }
    if ((paramArrayOfString2 == null) || (paramArrayOfString2.length == 0))
    {
      y.e("MicroMsg.ExtControlProviderSNS", "invaild selections");
      cN(false);
      qF(3);
      return null;
    }
    paramArrayOfString1 = paramArrayOfString2[0];
    if (bk.bl(paramArrayOfString1))
    {
      y.e("MicroMsg.ExtControlProviderSNS", "userIdStr should not be null or nil");
      cN(false);
      qF(3);
      return null;
    }
    for (;;)
    {
      try
      {
        boolean bool = "0".equals(paramArrayOfString1.trim());
        long l;
        if (bool) {
          l = 0L;
        }
        switch (jKj.match(paramUri))
        {
        default: 
          paramUri = null;
          if (paramUri == null) {
            break label334;
          }
          qF(0);
          cN(false);
          return paramUri;
          l = Long.valueOf(com.tencent.mm.plugin.ext.a.a.Cb(paramArrayOfString1.trim())).longValue();
          break;
        case 17: 
          paramUri = ej(l);
        }
      }
      catch (Exception paramUri)
      {
        y.e("MicroMsg.ExtControlProviderSNS", paramUri.getMessage());
        y.printErrStackTrace("MicroMsg.ExtControlProviderSNS", paramUri, "", new Object[0]);
        cN(false);
        qF(4);
        return null;
      }
      continue;
      label334:
      qF(4);
    }
  }
  
  public final int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.provider.ExtControlProviderSNS
 * JD-Core Version:    0.7.0.1
 */