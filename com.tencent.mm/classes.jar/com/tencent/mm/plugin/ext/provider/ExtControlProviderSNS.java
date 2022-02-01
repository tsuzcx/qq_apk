package com.tencent.mm.plugin.ext.provider;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fn;
import com.tencent.mm.g.a.fn.b;
import com.tencent.mm.g.a.fo;
import com.tencent.mm.g.a.fo.b;
import com.tencent.mm.g.a.fw;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bn.a;
import com.tencent.mm.plugin.ext.key.AESUtil;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import java.util.List;

@JgClassChecked(author=32, fComment="checked", lastDate="20141016", reviewer=20, vComment={com.jg.EType.PROVIDERCHECK})
public final class ExtControlProviderSNS
  extends ExtContentProviderBase
{
  private static boolean fYC;
  private static final UriMatcher qtG;
  private static au quf;
  private static final String[] quh;
  private boolean dfY = false;
  private boolean dfZ = false;
  private int dga = 0;
  private String qui = "";
  
  static
  {
    AppMethodBeat.i(24463);
    quh = new String[] { "feedId", "desc", "url", "nickname", "avatar", "timestamp", "mediaCount", "type", "bigImgUrl", "firstImgWidth", "firstImgHeight" };
    UriMatcher localUriMatcher = new UriMatcher(-1);
    qtG = localUriMatcher;
    localUriMatcher.addURI("com.tencent.mm.plugin.ext.SNS", "snsInfo", 17);
    fYC = false;
    quf = new au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(24456);
        ExtControlProviderSNS.adZ();
        AppMethodBeat.o(24456);
        return false;
      }
    }, false);
    AppMethodBeat.o(24463);
  }
  
  private Cursor cmJ()
  {
    AppMethodBeat.i(24462);
    ac.i("MicroMsg.ExtControlProviderSNS", "getSnsCursor() , needDownload = true");
    com.tencent.mm.storagebase.e locale = new com.tencent.mm.storagebase.e(quh, (byte)0);
    Object localObject1 = new fn();
    ((fn)localObject1).dfo.dfq = this.qui;
    if (!a.GpY.l((com.tencent.mm.sdk.b.b)localObject1))
    {
      locale.close();
      AppMethodBeat.o(24462);
      return null;
    }
    Cursor localCursor = ((fn)localObject1).dfp.dfh;
    if (localCursor != null) {}
    for (;;)
    {
      try
      {
        i = localCursor.getCount();
        ac.i("MicroMsg.ExtControlProviderSNS", "in getSnsCursor(), snsCount = ".concat(String.valueOf(i)));
        fo localfo;
        if ((i > 0) && (localCursor.moveToFirst()))
        {
          if (localCursor != null)
          {
            localfo = new fo();
            localfo.dfr.dft = localCursor;
            if (!a.GpY.l(localfo)) {
              ac.w("MicroMsg.ExtControlProviderSNS", "ExtGetSnsDataEvent publish error");
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
          ac.i("MicroMsg.ExtControlProviderSNS", "in getSnsCursor(), matrixCursor Count = " + locale.getCount());
          localCursor.close();
          AppMethodBeat.o(24462);
          return locale;
        }
        az.ayM();
        Object localObject2 = com.tencent.mm.model.c.awB().aNr(localfo.dfs.dfu);
        if ((localObject2 == null) || ((int)((com.tencent.mm.n.b)localObject2).fLJ <= 0)) {
          continue;
        }
        String str3 = "";
        switch (localfo.dfs.mediaType)
        {
        case 2: 
          if ((localfo.dfs.dfz == null) || (localfo.dfs.dfz.size() <= 0) || (getContext() == null)) {
            break label816;
          }
          ac.d("MicroMsg.ExtControlProviderSNS", "uris.size() = [%s]", new Object[] { Integer.valueOf(localfo.dfs.dfz.size()) });
          if ((i != 2) && (i != 6) && (i != 3) && (i != 4)) {
            break label816;
          }
          localObject1 = (String)localfo.dfs.dfz.get(0);
          String str2 = str3;
          if (localfo.dfs.dfA != null)
          {
            str2 = str3;
            if (localfo.dfs.dfA.size() > 0)
            {
              str2 = str3;
              if (getContext() != null)
              {
                ac.d("MicroMsg.ExtControlProviderSNS", "bigImgUris.size() = [%s], firstImgWidth = [%s], firstImgHeight = [%s]", new Object[] { Integer.valueOf(localfo.dfs.dfA.size()), Integer.valueOf(localfo.dfs.dfB), Integer.valueOf(localfo.dfs.dfC) });
                if ((i != 2) && (i != 6) && (i != 3))
                {
                  str2 = str3;
                  if (i != 4) {}
                }
                else
                {
                  str2 = (String)localfo.dfs.dfA.get(0);
                }
              }
            }
          }
          str3 = com.tencent.mm.aj.c.zT(localfo.dfs.dfu);
          try
          {
            String str4 = AESUtil.tl(localfo.dfs.dfv);
            String str5 = localfo.dfs.dfw;
            String str6 = ((ai)localObject2).aaS();
            localObject2 = str3;
            if (str3 == null) {
              localObject2 = "";
            }
            locale.addRow(new Object[] { str4, str5, localObject1, str6, localObject2, Long.valueOf(localfo.dfs.dfx), Integer.valueOf(localfo.dfs.dfy), Integer.valueOf(i), str2, Integer.valueOf(localfo.dfs.dfB), Integer.valueOf(localfo.dfs.dfC) });
          }
          catch (Exception localException1)
          {
            ac.e("MicroMsg.ExtControlProviderSNS", localException1.getMessage());
            ac.printErrStackTrace("MicroMsg.ExtControlProviderSNS", localException1, "", new Object[0]);
          }
          continue;
          i = 1;
        }
      }
      catch (Exception localException2)
      {
        ac.e("MicroMsg.ExtControlProviderSNS", localException2.getMessage());
        ac.printErrStackTrace("MicroMsg.ExtControlProviderSNS", localException2, "", new Object[0]);
        if (localCursor != null) {
          localCursor.close();
        }
        locale.close();
        AppMethodBeat.o(24462);
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
      label816:
      String str1 = "";
      continue;
      i = 5;
    }
  }
  
  private static void fV(boolean paramBoolean)
  {
    AppMethodBeat.i(24459);
    if (paramBoolean)
    {
      fYC = true;
      quf.au(15000L, 15000L);
      AppMethodBeat.o(24459);
      return;
    }
    quf.au(0L, 0L);
    AppMethodBeat.o(24459);
  }
  
  /* Error */
  private Cursor tm(long paramLong)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: sipush 24461
    //   5: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc 124
    //   10: ldc_w 363
    //   13: lload_1
    //   14: invokestatic 365	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   17: invokevirtual 187	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   20: invokestatic 131	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: ldc 124
    //   25: ldc_w 367
    //   28: iconst_1
    //   29: anewarray 280	java/lang/Object
    //   32: dup
    //   33: iconst_0
    //   34: lload_1
    //   35: invokestatic 334	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   38: aastore
    //   39: invokestatic 369	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   42: lload_1
    //   43: lconst_0
    //   44: lcmp
    //   45: ifne +64 -> 109
    //   48: invokestatic 233	com/tencent/mm/model/az:ayM	()Lcom/tencent/mm/model/c;
    //   51: pop
    //   52: invokestatic 239	com/tencent/mm/model/c:awB	()Lcom/tencent/mm/storage/bj;
    //   55: invokestatic 374	com/tencent/mm/model/u:axw	()Ljava/lang/String;
    //   58: invokeinterface 254 2 0
    //   63: astore 4
    //   65: aload 4
    //   67: ifnull +12 -> 79
    //   70: aload 4
    //   72: getfield 260	com/tencent/mm/n/b:fLJ	J
    //   75: l2i
    //   76: ifgt +51 -> 127
    //   79: ldc 124
    //   81: ldc_w 376
    //   84: invokestatic 347	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   87: iconst_0
    //   88: istore_3
    //   89: iload_3
    //   90: ifne +158 -> 248
    //   93: ldc 124
    //   95: ldc_w 378
    //   98: invokestatic 207	com/tencent/mm/sdk/platformtools/ac:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   101: sipush 24461
    //   104: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: aconst_null
    //   108: areturn
    //   109: invokestatic 233	com/tencent/mm/model/az:ayM	()Lcom/tencent/mm/model/c;
    //   112: pop
    //   113: invokestatic 239	com/tencent/mm/model/c:awB	()Lcom/tencent/mm/storage/bj;
    //   116: lload_1
    //   117: invokeinterface 382 3 0
    //   122: astore 4
    //   124: goto -59 -> 65
    //   127: aload_0
    //   128: aload 4
    //   130: getfield 387	com/tencent/mm/g/c/av:field_type	I
    //   133: invokestatic 391	com/tencent/mm/n/b:ln	(I)Z
    //   136: putfield 103	com/tencent/mm/plugin/ext/provider/ExtControlProviderSNS:dfY	Z
    //   139: aload_0
    //   140: aload 4
    //   142: getfield 394	com/tencent/mm/g/c/av:field_username	Ljava/lang/String;
    //   145: invokestatic 398	com/tencent/mm/model/u:wh	(Ljava/lang/String;)Z
    //   148: putfield 105	com/tencent/mm/plugin/ext/provider/ExtControlProviderSNS:dfZ	Z
    //   151: ldc 124
    //   153: ldc_w 400
    //   156: iconst_3
    //   157: anewarray 280	java/lang/Object
    //   160: dup
    //   161: iconst_0
    //   162: aload 4
    //   164: getfield 394	com/tencent/mm/g/c/av:field_username	Ljava/lang/String;
    //   167: aastore
    //   168: dup
    //   169: iconst_1
    //   170: aload_0
    //   171: getfield 103	com/tencent/mm/plugin/ext/provider/ExtControlProviderSNS:dfY	Z
    //   174: invokestatic 405	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   177: aastore
    //   178: dup
    //   179: iconst_2
    //   180: aload_0
    //   181: getfield 105	com/tencent/mm/plugin/ext/provider/ExtControlProviderSNS:dfZ	Z
    //   184: invokestatic 405	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   187: aastore
    //   188: invokestatic 289	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   191: new 407	com/tencent/mm/pluginsdk/d/a/b
    //   194: dup
    //   195: invokespecial 408	com/tencent/mm/pluginsdk/d/a/b:<init>	()V
    //   198: astore 5
    //   200: aload 5
    //   202: ldc2_w 409
    //   205: new 8	com/tencent/mm/plugin/ext/provider/ExtControlProviderSNS$2
    //   208: dup
    //   209: aload_0
    //   210: aload 4
    //   212: aload 5
    //   214: invokespecial 413	com/tencent/mm/plugin/ext/provider/ExtControlProviderSNS$2:<init>	(Lcom/tencent/mm/plugin/ext/provider/ExtControlProviderSNS;Lcom/tencent/mm/storage/ai;Lcom/tencent/mm/pluginsdk/d/a/b;)V
    //   217: invokevirtual 416	com/tencent/mm/pluginsdk/d/a/b:c	(JLjava/lang/Runnable;)V
    //   220: goto -131 -> 89
    //   223: astore 4
    //   225: ldc 124
    //   227: aload 4
    //   229: invokevirtual 344	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   232: invokestatic 347	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   235: ldc 124
    //   237: aload 4
    //   239: ldc 109
    //   241: iconst_0
    //   242: anewarray 280	java/lang/Object
    //   245: invokestatic 351	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   248: aload_0
    //   249: invokespecial 418	com/tencent/mm/plugin/ext/provider/ExtControlProviderSNS:cmJ	()Landroid/database/Cursor;
    //   252: astore 4
    //   254: sipush 24461
    //   257: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   260: aload 4
    //   262: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	263	0	this	ExtControlProviderSNS
    //   0	263	1	paramLong	long
    //   1	89	3	i	int
    //   63	148	4	localai	ai
    //   223	15	4	localException	Exception
    //   252	9	4	localCursor	Cursor
    //   198	15	5	localb	com.tencent.mm.pluginsdk.d.a.b
    // Exception table:
    //   from	to	target	type
    //   23	42	223	java/lang/Exception
    //   48	65	223	java/lang/Exception
    //   70	79	223	java/lang/Exception
    //   79	87	223	java/lang/Exception
    //   93	101	223	java/lang/Exception
    //   109	124	223	java/lang/Exception
    //   127	220	223	java/lang/Exception
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
    AppMethodBeat.i(24460);
    ac.i("MicroMsg.ExtControlProviderSNS", "query() ".concat(String.valueOf(paramUri)));
    a(paramUri, getContext(), qtG);
    if (paramUri == null)
    {
      CN(3);
      AppMethodBeat.o(24460);
      return null;
    }
    if ((bs.isNullOrNil(this.qtA)) || (bs.isNullOrNil(cmE())))
    {
      CN(3);
      AppMethodBeat.o(24460);
      return null;
    }
    if (fYC)
    {
      ac.w("MicroMsg.ExtControlProviderSNS", "isBusy, return null");
      CN(5);
      AppMethodBeat.o(24460);
      return null;
    }
    fV(true);
    if (!bIc())
    {
      fV(false);
      CN(1);
      paramUri = this.nng;
      AppMethodBeat.o(24460);
      return paramUri;
    }
    if (!eG(getContext()))
    {
      ac.w("MicroMsg.ExtControlProviderSNS", "invalid appid ! return null");
      fV(false);
      CN(2);
      AppMethodBeat.o(24460);
      return null;
    }
    if ((paramArrayOfString2 == null) || (paramArrayOfString2.length == 0))
    {
      ac.e("MicroMsg.ExtControlProviderSNS", "invaild selections");
      fV(false);
      CN(3);
      AppMethodBeat.o(24460);
      return null;
    }
    paramArrayOfString1 = paramArrayOfString2[0];
    if (bs.isNullOrNil(paramArrayOfString1))
    {
      ac.e("MicroMsg.ExtControlProviderSNS", "userIdStr should not be null or nil");
      fV(false);
      CN(3);
      AppMethodBeat.o(24460);
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
        switch (qtG.match(paramUri))
        {
        default: 
          paramUri = null;
          if (paramUri == null) {
            break label380;
          }
          CN(0);
          fV(false);
          AppMethodBeat.o(24460);
          return paramUri;
          l = AESUtil.abT(paramArrayOfString1.trim());
          break;
        case 17: 
          paramUri = tm(l);
        }
      }
      catch (Exception paramUri)
      {
        ac.e("MicroMsg.ExtControlProviderSNS", paramUri.getMessage());
        ac.printErrStackTrace("MicroMsg.ExtControlProviderSNS", paramUri, "", new Object[0]);
        fV(false);
        CN(4);
        AppMethodBeat.o(24460);
        return null;
      }
      continue;
      label380:
      CN(4);
    }
  }
  
  public final int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.provider.ExtControlProviderSNS
 * JD-Core Version:    0.7.0.1
 */