package com.tencent.mm.plugin.ext.provider;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.gm;
import com.tencent.mm.autogen.a.gm.b;
import com.tencent.mm.autogen.a.gn;
import com.tencent.mm.autogen.a.gn.b;
import com.tencent.mm.autogen.a.gv;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bw.a;
import com.tencent.mm.model.c;
import com.tencent.mm.network.g;
import com.tencent.mm.plugin.ext.key.AESUtil;
import com.tencent.mm.pluginsdk.d.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatAuthorities;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storagebase.e;
import java.util.List;

public final class ExtControlProviderSNS
  extends ExtContentProviderBase
{
  private static boolean mtE;
  private static MTimerHandler zPE;
  private static final String[] zPG;
  private static final UriMatcher zPg;
  private boolean hHp = false;
  private boolean hHq = false;
  private int hHr = 0;
  private String zPH = "";
  
  static
  {
    AppMethodBeat.i(24463);
    zPG = new String[] { "feedId", "desc", "url", "nickname", "avatar", "timestamp", "mediaCount", "type", "bigImgUrl", "firstImgWidth", "firstImgHeight" };
    UriMatcher localUriMatcher = new UriMatcher(-1);
    zPg = localUriMatcher;
    localUriMatcher.addURI(WeChatAuthorities.AUTHORITIES_PLUGIN_EXT_SNS(), "snsInfo", 17);
    mtE = false;
    zPE = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(24456);
        ExtControlProviderSNS.aAs();
        AppMethodBeat.o(24456);
        return false;
      }
    }, false);
    AppMethodBeat.o(24463);
  }
  
  private Cursor dOj()
  {
    AppMethodBeat.i(24462);
    Log.i("MicroMsg.ExtControlProviderSNS", "getSnsCursor() , needDownload = true");
    e locale = new e(zPG, (byte)0);
    Object localObject1 = new gm();
    ((gm)localObject1).hGF.hGH = this.zPH;
    if (!((gm)localObject1).publish())
    {
      locale.close();
      AppMethodBeat.o(24462);
      return null;
    }
    Cursor localCursor = ((gm)localObject1).hGG.hGA;
    if (localCursor != null) {}
    for (;;)
    {
      try
      {
        i = localCursor.getCount();
        Log.i("MicroMsg.ExtControlProviderSNS", "in getSnsCursor(), snsCount = ".concat(String.valueOf(i)));
        gn localgn;
        if ((i > 0) && (localCursor.moveToFirst()))
        {
          if (localCursor != null)
          {
            localgn = new gn();
            localgn.hGI.hGK = localCursor;
            if (!localgn.publish()) {
              Log.w("MicroMsg.ExtControlProviderSNS", "ExtGetSnsDataEvent publish error");
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
          Log.i("MicroMsg.ExtControlProviderSNS", "in getSnsCursor(), matrixCursor Count = " + locale.getCount());
          localCursor.close();
          AppMethodBeat.o(24462);
          return locale;
        }
        bh.bCz();
        Object localObject2 = c.bzA().bxu(localgn.hGJ.hGL);
        if ((localObject2 == null) || ((int)((com.tencent.mm.contact.d)localObject2).maN <= 0)) {
          continue;
        }
        String str3 = "";
        switch (localgn.hGJ.mediaType)
        {
        case 2: 
          if ((localgn.hGJ.hGQ == null) || (localgn.hGJ.hGQ.size() <= 0) || (getContext() == null)) {
            break label840;
          }
          Log.d("MicroMsg.ExtControlProviderSNS", "uris.size() = [%s]", new Object[] { Integer.valueOf(localgn.hGJ.hGQ.size()) });
          if ((i != 2) && (i != 6) && (i != 3) && (i != 4)) {
            break label840;
          }
          localObject1 = (String)localgn.hGJ.hGQ.get(0);
          String str2 = str3;
          if (localgn.hGJ.hGR != null)
          {
            str2 = str3;
            if (localgn.hGJ.hGR.size() > 0)
            {
              str2 = str3;
              if (getContext() != null)
              {
                Log.d("MicroMsg.ExtControlProviderSNS", "bigImgUris.size() = [%s], firstImgWidth = [%s], firstImgHeight = [%s]", new Object[] { Integer.valueOf(localgn.hGJ.hGR.size()), Integer.valueOf(localgn.hGJ.hGS), Integer.valueOf(localgn.hGJ.hGT) });
                if ((i != 2) && (i != 6) && (i != 3))
                {
                  str2 = str3;
                  if (i != 4) {}
                }
                else
                {
                  str2 = (String)localgn.hGJ.hGR.get(0);
                }
              }
            }
          }
          str3 = com.tencent.mm.modelavatar.d.Lz(localgn.hGJ.hGL);
          try
          {
            String str4 = AESUtil.mo(localgn.hGJ.hGM);
            String str5 = localgn.hGJ.hGN;
            String str6 = ((au)localObject2).aSV();
            localObject2 = str3;
            if (str3 == null) {
              localObject2 = "";
            }
            locale.addRow(new Object[] { str4, str5, localObject1, str6, localObject2, Long.valueOf(localgn.hGJ.hGO), Integer.valueOf(localgn.hGJ.hGP), Integer.valueOf(i), str2, Integer.valueOf(localgn.hGJ.hGS), Integer.valueOf(localgn.hGJ.hGT) });
          }
          catch (Exception localException1)
          {
            Log.e("MicroMsg.ExtControlProviderSNS", localException1.getMessage());
            Log.printErrStackTrace("MicroMsg.ExtControlProviderSNS", localException1, "", new Object[0]);
          }
          continue;
          i = 1;
        }
      }
      catch (Exception localException2)
      {
        Log.e("MicroMsg.ExtControlProviderSNS", localException2.getMessage());
        Log.printErrStackTrace("MicroMsg.ExtControlProviderSNS", localException2, "", new Object[0]);
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
      label840:
      String str1 = "";
      continue;
      i = 5;
    }
  }
  
  private static void iK(boolean paramBoolean)
  {
    AppMethodBeat.i(24459);
    if (paramBoolean)
    {
      mtE = true;
      zPE.startTimer(15000L);
      AppMethodBeat.o(24459);
      return;
    }
    zPE.startTimer(0L);
    AppMethodBeat.o(24459);
  }
  
  /* Error */
  private Cursor mp(long paramLong)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: sipush 24461
    //   5: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc 116
    //   10: ldc_w 348
    //   13: lload_1
    //   14: invokestatic 350	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   17: invokevirtual 172	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   20: invokestatic 123	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: ldc 116
    //   25: ldc_w 352
    //   28: iconst_1
    //   29: anewarray 265	java/lang/Object
    //   32: dup
    //   33: iconst_0
    //   34: lload_1
    //   35: invokestatic 319	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   38: aastore
    //   39: invokestatic 354	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   42: lload_1
    //   43: lconst_0
    //   44: lcmp
    //   45: ifne +64 -> 109
    //   48: invokestatic 218	com/tencent/mm/model/bh:bCz	()Lcom/tencent/mm/model/c;
    //   51: pop
    //   52: invokestatic 224	com/tencent/mm/model/c:bzA	()Lcom/tencent/mm/storage/bx;
    //   55: invokestatic 359	com/tencent/mm/model/z:bAM	()Ljava/lang/String;
    //   58: invokeinterface 239 2 0
    //   63: astore 4
    //   65: aload 4
    //   67: ifnull +12 -> 79
    //   70: aload 4
    //   72: getfield 245	com/tencent/mm/contact/d:maN	J
    //   75: l2i
    //   76: ifgt +51 -> 127
    //   79: ldc 116
    //   81: ldc_w 361
    //   84: invokestatic 332	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   87: iconst_0
    //   88: istore_3
    //   89: iload_3
    //   90: ifne +158 -> 248
    //   93: ldc 116
    //   95: ldc_w 363
    //   98: invokestatic 193	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   101: sipush 24461
    //   104: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: aconst_null
    //   108: areturn
    //   109: invokestatic 218	com/tencent/mm/model/bh:bCz	()Lcom/tencent/mm/model/c;
    //   112: pop
    //   113: invokestatic 224	com/tencent/mm/model/c:bzA	()Lcom/tencent/mm/storage/bx;
    //   116: lload_1
    //   117: invokeinterface 367 3 0
    //   122: astore 4
    //   124: goto -59 -> 65
    //   127: aload_0
    //   128: aload 4
    //   130: getfield 372	com/tencent/mm/autogen/b/az:field_type	I
    //   133: invokestatic 376	com/tencent/mm/contact/d:rs	(I)Z
    //   136: putfield 95	com/tencent/mm/plugin/ext/provider/ExtControlProviderSNS:hHp	Z
    //   139: aload_0
    //   140: aload 4
    //   142: getfield 379	com/tencent/mm/autogen/b/az:field_username	Ljava/lang/String;
    //   145: invokestatic 383	com/tencent/mm/model/z:Iy	(Ljava/lang/String;)Z
    //   148: putfield 97	com/tencent/mm/plugin/ext/provider/ExtControlProviderSNS:hHq	Z
    //   151: ldc 116
    //   153: ldc_w 385
    //   156: iconst_3
    //   157: anewarray 265	java/lang/Object
    //   160: dup
    //   161: iconst_0
    //   162: aload 4
    //   164: getfield 379	com/tencent/mm/autogen/b/az:field_username	Ljava/lang/String;
    //   167: aastore
    //   168: dup
    //   169: iconst_1
    //   170: aload_0
    //   171: getfield 95	com/tencent/mm/plugin/ext/provider/ExtControlProviderSNS:hHp	Z
    //   174: invokestatic 390	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   177: aastore
    //   178: dup
    //   179: iconst_2
    //   180: aload_0
    //   181: getfield 97	com/tencent/mm/plugin/ext/provider/ExtControlProviderSNS:hHq	Z
    //   184: invokestatic 390	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   187: aastore
    //   188: invokestatic 274	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   191: new 392	com/tencent/mm/pluginsdk/d/a/b
    //   194: dup
    //   195: invokespecial 393	com/tencent/mm/pluginsdk/d/a/b:<init>	()V
    //   198: astore 5
    //   200: aload 5
    //   202: ldc2_w 394
    //   205: new 8	com/tencent/mm/plugin/ext/provider/ExtControlProviderSNS$2
    //   208: dup
    //   209: aload_0
    //   210: aload 4
    //   212: aload 5
    //   214: invokespecial 398	com/tencent/mm/plugin/ext/provider/ExtControlProviderSNS$2:<init>	(Lcom/tencent/mm/plugin/ext/provider/ExtControlProviderSNS;Lcom/tencent/mm/storage/au;Lcom/tencent/mm/pluginsdk/d/a/b;)V
    //   217: invokevirtual 401	com/tencent/mm/pluginsdk/d/a/b:c	(JLjava/lang/Runnable;)V
    //   220: goto -131 -> 89
    //   223: astore 4
    //   225: ldc 116
    //   227: aload 4
    //   229: invokevirtual 329	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   232: invokestatic 332	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   235: ldc 116
    //   237: aload 4
    //   239: ldc 101
    //   241: iconst_0
    //   242: anewarray 265	java/lang/Object
    //   245: invokestatic 336	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   248: aload_0
    //   249: invokespecial 403	com/tencent/mm/plugin/ext/provider/ExtControlProviderSNS:dOj	()Landroid/database/Cursor;
    //   252: astore 4
    //   254: sipush 24461
    //   257: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   260: aload 4
    //   262: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	263	0	this	ExtControlProviderSNS
    //   0	263	1	paramLong	long
    //   1	89	3	i	int
    //   63	148	4	localau	au
    //   223	15	4	localException	Exception
    //   252	9	4	localCursor	Cursor
    //   198	15	5	localb	b
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
    Log.i("MicroMsg.ExtControlProviderSNS", "query() ".concat(String.valueOf(paramUri)));
    a(paramUri, getContext(), zPg);
    if (paramUri == null)
    {
      Mm(3);
      AppMethodBeat.o(24460);
      return null;
    }
    if ((Util.isNullOrNil(this.zPa)) || (Util.isNullOrNil(dOe())))
    {
      Mm(3);
      AppMethodBeat.o(24460);
      return null;
    }
    if (mtE)
    {
      Log.w("MicroMsg.ExtControlProviderSNS", "isBusy, return null");
      Mm(5);
      AppMethodBeat.o(24460);
      return null;
    }
    iK(true);
    if (!dak())
    {
      iK(false);
      Mm(1);
      paramUri = this.vsh;
      AppMethodBeat.o(24460);
      return paramUri;
    }
    if (!gh(getContext()))
    {
      Log.w("MicroMsg.ExtControlProviderSNS", "invalid appid ! return null");
      iK(false);
      Mm(2);
      AppMethodBeat.o(24460);
      return null;
    }
    if ((paramArrayOfString2 == null) || (paramArrayOfString2.length == 0))
    {
      Log.e("MicroMsg.ExtControlProviderSNS", "invaild selections");
      iK(false);
      Mm(3);
      AppMethodBeat.o(24460);
      return null;
    }
    paramArrayOfString1 = paramArrayOfString2[0];
    if (Util.isNullOrNil(paramArrayOfString1))
    {
      Log.e("MicroMsg.ExtControlProviderSNS", "userIdStr should not be null or nil");
      iK(false);
      Mm(3);
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
        switch (zPg.match(paramUri))
        {
        default: 
          paramUri = null;
          if (paramUri == null) {
            break label380;
          }
          Mm(0);
          iK(false);
          AppMethodBeat.o(24460);
          return paramUri;
          l = AESUtil.atw(paramArrayOfString1.trim());
          break;
        case 17: 
          paramUri = mp(l);
        }
      }
      catch (Exception paramUri)
      {
        Log.e("MicroMsg.ExtControlProviderSNS", paramUri.getMessage());
        Log.printErrStackTrace("MicroMsg.ExtControlProviderSNS", paramUri, "", new Object[0]);
        iK(false);
        Mm(4);
        AppMethodBeat.o(24460);
        return null;
      }
      continue;
      label380:
      Mm(4);
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