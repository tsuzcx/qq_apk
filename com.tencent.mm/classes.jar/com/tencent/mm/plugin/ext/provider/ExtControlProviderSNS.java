package com.tencent.mm.plugin.ext.provider;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.e;
import com.tencent.mm.g.a.fg;
import com.tencent.mm.g.a.fg.b;
import com.tencent.mm.g.a.fh;
import com.tencent.mm.g.a.fh.b;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.util.List;

@JgClassChecked(author=32, fComment="checked", lastDate="20141016", reviewer=20, vComment={com.jg.EType.PROVIDERCHECK})
public final class ExtControlProviderSNS
  extends ExtContentProviderBase
{
  private static boolean ezJ;
  private static ap meM;
  private static final String[] meO;
  private static final UriMatcher meo;
  private boolean ctI = false;
  private boolean ctJ = false;
  private int ctK = 0;
  private String meP = "";
  
  static
  {
    AppMethodBeat.i(20384);
    meO = new String[] { "feedId", "desc", "url", "nickname", "avatar", "timestamp", "mediaCount", "type", "bigImgUrl", "firstImgWidth", "firstImgHeight" };
    UriMatcher localUriMatcher = new UriMatcher(-1);
    meo = localUriMatcher;
    localUriMatcher.addURI("com.tencent.mm.plugin.ext.SNS", "snsInfo", 17);
    ezJ = false;
    meM = new ap(new ExtControlProviderSNS.1(), false);
    AppMethodBeat.o(20384);
  }
  
  private Cursor btI()
  {
    AppMethodBeat.i(20383);
    ab.i("MicroMsg.ExtControlProviderSNS", "getSnsCursor() , needDownload = true");
    e locale = new e(meO, (byte)0);
    Object localObject1 = new fg();
    ((fg)localObject1).csX.csZ = this.meP;
    if (!com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject1))
    {
      locale.close();
      AppMethodBeat.o(20383);
      return null;
    }
    Cursor localCursor = ((fg)localObject1).csY.csQ;
    if (localCursor != null) {}
    for (;;)
    {
      try
      {
        i = localCursor.getCount();
        ab.i("MicroMsg.ExtControlProviderSNS", "in getSnsCursor(), snsCount = ".concat(String.valueOf(i)));
        fh localfh;
        if ((i > 0) && (localCursor.moveToFirst()))
        {
          if (localCursor != null)
          {
            localfh = new fh();
            localfh.cta.ctc = localCursor;
            if (!com.tencent.mm.sdk.b.a.ymk.l(localfh)) {
              ab.w("MicroMsg.ExtControlProviderSNS", "ExtGetSnsDataEvent publish error");
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
          ab.i("MicroMsg.ExtControlProviderSNS", "in getSnsCursor(), matrixCursor Count = " + locale.getCount());
          localCursor.close();
          AppMethodBeat.o(20383);
          return locale;
        }
        aw.aaz();
        Object localObject2 = c.YA().aru(localfh.ctb.ctd);
        if ((localObject2 == null) || ((int)((com.tencent.mm.n.a)localObject2).euF <= 0)) {
          continue;
        }
        String str3 = "";
        switch (localfh.ctb.cth)
        {
        case 2: 
          if ((localfh.ctb.ctj == null) || (localfh.ctb.ctj.size() <= 0) || (getContext() == null)) {
            break label816;
          }
          ab.d("MicroMsg.ExtControlProviderSNS", "uris.size() = [%s]", new Object[] { Integer.valueOf(localfh.ctb.ctj.size()) });
          if ((i != 2) && (i != 6) && (i != 3) && (i != 4)) {
            break label816;
          }
          localObject1 = (String)localfh.ctb.ctj.get(0);
          String str2 = str3;
          if (localfh.ctb.ctk != null)
          {
            str2 = str3;
            if (localfh.ctb.ctk.size() > 0)
            {
              str2 = str3;
              if (getContext() != null)
              {
                ab.d("MicroMsg.ExtControlProviderSNS", "bigImgUris.size() = [%s], firstImgWidth = [%s], firstImgHeight = [%s]", new Object[] { Integer.valueOf(localfh.ctb.ctk.size()), Integer.valueOf(localfh.ctb.ctl), Integer.valueOf(localfh.ctb.ctm) });
                if ((i != 2) && (i != 6) && (i != 3))
                {
                  str2 = str3;
                  if (i != 4) {}
                }
                else
                {
                  str2 = (String)localfh.ctb.ctk.get(0);
                }
              }
            }
          }
          str3 = com.tencent.mm.ah.b.qS(localfh.ctb.ctd);
          try
          {
            String str4 = com.tencent.mm.plugin.ext.a.a.jF(localfh.ctb.cte);
            String str5 = localfh.ctb.ctf;
            String str6 = ((ad)localObject2).Of();
            localObject2 = str3;
            if (str3 == null) {
              localObject2 = "";
            }
            locale.addRow(new Object[] { str4, str5, localObject1, str6, localObject2, Long.valueOf(localfh.ctb.ctg), Integer.valueOf(localfh.ctb.cti), Integer.valueOf(i), str2, Integer.valueOf(localfh.ctb.ctl), Integer.valueOf(localfh.ctb.ctm) });
          }
          catch (Exception localException1)
          {
            ab.e("MicroMsg.ExtControlProviderSNS", localException1.getMessage());
            ab.printErrStackTrace("MicroMsg.ExtControlProviderSNS", localException1, "", new Object[0]);
          }
          continue;
          i = 1;
        }
      }
      catch (Exception localException2)
      {
        ab.e("MicroMsg.ExtControlProviderSNS", localException2.getMessage());
        ab.printErrStackTrace("MicroMsg.ExtControlProviderSNS", localException2, "", new Object[0]);
        if (localCursor != null) {
          localCursor.close();
        }
        locale.close();
        AppMethodBeat.o(20383);
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
  
  private static void dR(boolean paramBoolean)
  {
    AppMethodBeat.i(20380);
    if (paramBoolean)
    {
      ezJ = true;
      meM.ag(15000L, 15000L);
      AppMethodBeat.o(20380);
      return;
    }
    meM.ag(0L, 0L);
    AppMethodBeat.o(20380);
  }
  
  /* Error */
  private Cursor jG(long paramLong)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: sipush 20382
    //   5: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc 118
    //   10: ldc_w 359
    //   13: lload_1
    //   14: invokestatic 361	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   17: invokevirtual 181	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   20: invokestatic 125	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: ldc 118
    //   25: ldc_w 363
    //   28: iconst_1
    //   29: anewarray 274	java/lang/Object
    //   32: dup
    //   33: iconst_0
    //   34: lload_1
    //   35: invokestatic 328	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   38: aastore
    //   39: invokestatic 365	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   42: lload_1
    //   43: lconst_0
    //   44: lcmp
    //   45: ifne +64 -> 109
    //   48: invokestatic 227	com/tencent/mm/model/aw:aaz	()Lcom/tencent/mm/model/c;
    //   51: pop
    //   52: invokestatic 233	com/tencent/mm/model/c:YA	()Lcom/tencent/mm/storage/bd;
    //   55: invokestatic 370	com/tencent/mm/model/r:Zn	()Ljava/lang/String;
    //   58: invokeinterface 248 2 0
    //   63: astore 4
    //   65: aload 4
    //   67: ifnull +12 -> 79
    //   70: aload 4
    //   72: getfield 254	com/tencent/mm/n/a:euF	J
    //   75: l2i
    //   76: ifgt +51 -> 127
    //   79: ldc 118
    //   81: ldc_w 372
    //   84: invokestatic 341	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   87: iconst_0
    //   88: istore_3
    //   89: iload_3
    //   90: ifne +158 -> 248
    //   93: ldc 118
    //   95: ldc_w 374
    //   98: invokestatic 201	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   101: sipush 20382
    //   104: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: aconst_null
    //   108: areturn
    //   109: invokestatic 227	com/tencent/mm/model/aw:aaz	()Lcom/tencent/mm/model/c;
    //   112: pop
    //   113: invokestatic 233	com/tencent/mm/model/c:YA	()Lcom/tencent/mm/storage/bd;
    //   116: lload_1
    //   117: invokeinterface 378 3 0
    //   122: astore 4
    //   124: goto -59 -> 65
    //   127: aload_0
    //   128: aload 4
    //   130: getfield 383	com/tencent/mm/g/c/aq:field_type	I
    //   133: invokestatic 387	com/tencent/mm/n/a:je	(I)Z
    //   136: putfield 99	com/tencent/mm/plugin/ext/provider/ExtControlProviderSNS:ctI	Z
    //   139: aload_0
    //   140: aload 4
    //   142: getfield 390	com/tencent/mm/g/c/aq:field_username	Ljava/lang/String;
    //   145: invokestatic 394	com/tencent/mm/model/r:nB	(Ljava/lang/String;)Z
    //   148: putfield 101	com/tencent/mm/plugin/ext/provider/ExtControlProviderSNS:ctJ	Z
    //   151: ldc 118
    //   153: ldc_w 396
    //   156: iconst_3
    //   157: anewarray 274	java/lang/Object
    //   160: dup
    //   161: iconst_0
    //   162: aload 4
    //   164: getfield 390	com/tencent/mm/g/c/aq:field_username	Ljava/lang/String;
    //   167: aastore
    //   168: dup
    //   169: iconst_1
    //   170: aload_0
    //   171: getfield 99	com/tencent/mm/plugin/ext/provider/ExtControlProviderSNS:ctI	Z
    //   174: invokestatic 401	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   177: aastore
    //   178: dup
    //   179: iconst_2
    //   180: aload_0
    //   181: getfield 101	com/tencent/mm/plugin/ext/provider/ExtControlProviderSNS:ctJ	Z
    //   184: invokestatic 401	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   187: aastore
    //   188: invokestatic 283	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   191: new 403	com/tencent/mm/pluginsdk/d/a/b
    //   194: dup
    //   195: invokespecial 404	com/tencent/mm/pluginsdk/d/a/b:<init>	()V
    //   198: astore 5
    //   200: aload 5
    //   202: ldc2_w 405
    //   205: new 408	com/tencent/mm/plugin/ext/provider/ExtControlProviderSNS$2
    //   208: dup
    //   209: aload_0
    //   210: aload 4
    //   212: aload 5
    //   214: invokespecial 411	com/tencent/mm/plugin/ext/provider/ExtControlProviderSNS$2:<init>	(Lcom/tencent/mm/plugin/ext/provider/ExtControlProviderSNS;Lcom/tencent/mm/storage/ad;Lcom/tencent/mm/pluginsdk/d/a/b;)V
    //   217: invokevirtual 414	com/tencent/mm/pluginsdk/d/a/b:b	(JLjava/lang/Runnable;)V
    //   220: goto -131 -> 89
    //   223: astore 4
    //   225: ldc 118
    //   227: aload 4
    //   229: invokevirtual 338	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   232: invokestatic 341	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   235: ldc 118
    //   237: aload 4
    //   239: ldc 105
    //   241: iconst_0
    //   242: anewarray 274	java/lang/Object
    //   245: invokestatic 345	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   248: aload_0
    //   249: invokespecial 416	com/tencent/mm/plugin/ext/provider/ExtControlProviderSNS:btI	()Landroid/database/Cursor;
    //   252: astore 4
    //   254: sipush 20382
    //   257: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   260: aload 4
    //   262: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	263	0	this	ExtControlProviderSNS
    //   0	263	1	paramLong	long
    //   1	89	3	i	int
    //   63	148	4	localad	ad
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
    AppMethodBeat.i(20381);
    ab.i("MicroMsg.ExtControlProviderSNS", "query() ".concat(String.valueOf(paramUri)));
    a(paramUri, getContext(), meo);
    if (paramUri == null)
    {
      vA(3);
      AppMethodBeat.o(20381);
      return null;
    }
    if ((bo.isNullOrNil(this.mei)) || (bo.isNullOrNil(btD())))
    {
      vA(3);
      AppMethodBeat.o(20381);
      return null;
    }
    if (ezJ)
    {
      ab.w("MicroMsg.ExtControlProviderSNS", "isBusy, return null");
      vA(5);
      AppMethodBeat.o(20381);
      return null;
    }
    dR(true);
    if (!aVH())
    {
      dR(false);
      vA(1);
      paramUri = this.jLW;
      AppMethodBeat.o(20381);
      return paramUri;
    }
    if (!dO(getContext()))
    {
      ab.w("MicroMsg.ExtControlProviderSNS", "invalid appid ! return null");
      dR(false);
      vA(2);
      AppMethodBeat.o(20381);
      return null;
    }
    if ((paramArrayOfString2 == null) || (paramArrayOfString2.length == 0))
    {
      ab.e("MicroMsg.ExtControlProviderSNS", "invaild selections");
      dR(false);
      vA(3);
      AppMethodBeat.o(20381);
      return null;
    }
    paramArrayOfString1 = paramArrayOfString2[0];
    if (bo.isNullOrNil(paramArrayOfString1))
    {
      ab.e("MicroMsg.ExtControlProviderSNS", "userIdStr should not be null or nil");
      dR(false);
      vA(3);
      AppMethodBeat.o(20381);
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
        switch (meo.match(paramUri))
        {
        default: 
          paramUri = null;
          if (paramUri == null) {
            break label380;
          }
          vA(0);
          dR(false);
          AppMethodBeat.o(20381);
          return paramUri;
          l = com.tencent.mm.plugin.ext.a.a.Nc(paramArrayOfString1.trim());
          break;
        case 17: 
          paramUri = jG(l);
        }
      }
      catch (Exception paramUri)
      {
        ab.e("MicroMsg.ExtControlProviderSNS", paramUri.getMessage());
        ab.printErrStackTrace("MicroMsg.ExtControlProviderSNS", paramUri, "", new Object[0]);
        dR(false);
        vA(4);
        AppMethodBeat.o(20381);
        return null;
      }
      continue;
      label380:
      vA(4);
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