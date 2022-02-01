package com.tencent.mm.plugin.ext.provider;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.gb;
import com.tencent.mm.f.a.gb.b;
import com.tencent.mm.f.a.gc;
import com.tencent.mm.f.a.gc.b;
import com.tencent.mm.f.a.gk;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.model.c;
import com.tencent.mm.network.g;
import com.tencent.mm.plugin.ext.key.AESUtil;
import com.tencent.mm.pluginsdk.e.a.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatAuthorities;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storagebase.e;
import java.util.List;

@JgClassChecked(author=32, fComment="checked", lastDate="20141016", reviewer=20, vComment={com.jg.EType.PROVIDERCHECK})
public final class ExtControlProviderSNS
  extends ExtContentProviderBase
{
  private static boolean jTm;
  private static final String[] wtA;
  private static final UriMatcher wta;
  private static MTimerHandler wty;
  private boolean fCA = false;
  private boolean fCB = false;
  private int fCC = 0;
  private String wtB = "";
  
  static
  {
    AppMethodBeat.i(24463);
    wtA = new String[] { "feedId", "desc", "url", "nickname", "avatar", "timestamp", "mediaCount", "type", "bigImgUrl", "firstImgWidth", "firstImgHeight" };
    UriMatcher localUriMatcher = new UriMatcher(-1);
    wta = localUriMatcher;
    localUriMatcher.addURI(WeChatAuthorities.AUTHORITIES_PLUGIN_EXT_SNS(), "snsInfo", 17);
    jTm = false;
    wty = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(24456);
        ExtControlProviderSNS.Yy();
        AppMethodBeat.o(24456);
        return false;
      }
    }, false);
    AppMethodBeat.o(24463);
  }
  
  /* Error */
  private Cursor JR(long paramLong)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: sipush 24461
    //   5: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc 121
    //   10: ldc 123
    //   12: lload_1
    //   13: invokestatic 127	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   16: invokevirtual 131	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   19: invokestatic 136	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: ldc 121
    //   24: ldc 138
    //   26: iconst_1
    //   27: anewarray 140	java/lang/Object
    //   30: dup
    //   31: iconst_0
    //   32: lload_1
    //   33: invokestatic 145	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   36: aastore
    //   37: invokestatic 148	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   40: lload_1
    //   41: lconst_0
    //   42: lcmp
    //   43: ifne +62 -> 105
    //   46: invokestatic 154	com/tencent/mm/model/bh:beI	()Lcom/tencent/mm/model/c;
    //   49: pop
    //   50: invokestatic 160	com/tencent/mm/model/c:bbL	()Lcom/tencent/mm/storage/bv;
    //   53: invokestatic 165	com/tencent/mm/model/z:bcZ	()Ljava/lang/String;
    //   56: invokeinterface 171 2 0
    //   61: astore 4
    //   63: aload 4
    //   65: ifnull +12 -> 77
    //   68: aload 4
    //   70: getfield 177	com/tencent/mm/contact/d:jxt	J
    //   73: l2i
    //   74: ifgt +49 -> 123
    //   77: ldc 121
    //   79: ldc 179
    //   81: invokestatic 182	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   84: iconst_0
    //   85: istore_3
    //   86: iload_3
    //   87: ifne +156 -> 243
    //   90: ldc 121
    //   92: ldc 184
    //   94: invokestatic 187	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   97: sipush 24461
    //   100: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   103: aconst_null
    //   104: areturn
    //   105: invokestatic 154	com/tencent/mm/model/bh:beI	()Lcom/tencent/mm/model/c;
    //   108: pop
    //   109: invokestatic 160	com/tencent/mm/model/c:bbL	()Lcom/tencent/mm/storage/bv;
    //   112: lload_1
    //   113: invokeinterface 191 3 0
    //   118: astore 4
    //   120: goto -57 -> 63
    //   123: aload_0
    //   124: aload 4
    //   126: getfield 196	com/tencent/mm/f/c/ax:field_type	I
    //   129: invokestatic 200	com/tencent/mm/contact/d:rk	(I)Z
    //   132: putfield 107	com/tencent/mm/plugin/ext/provider/ExtControlProviderSNS:fCA	Z
    //   135: aload_0
    //   136: aload 4
    //   138: getfield 203	com/tencent/mm/f/c/ax:field_username	Ljava/lang/String;
    //   141: invokestatic 207	com/tencent/mm/model/z:PD	(Ljava/lang/String;)Z
    //   144: putfield 109	com/tencent/mm/plugin/ext/provider/ExtControlProviderSNS:fCB	Z
    //   147: ldc 121
    //   149: ldc 209
    //   151: iconst_3
    //   152: anewarray 140	java/lang/Object
    //   155: dup
    //   156: iconst_0
    //   157: aload 4
    //   159: getfield 203	com/tencent/mm/f/c/ax:field_username	Ljava/lang/String;
    //   162: aastore
    //   163: dup
    //   164: iconst_1
    //   165: aload_0
    //   166: getfield 107	com/tencent/mm/plugin/ext/provider/ExtControlProviderSNS:fCA	Z
    //   169: invokestatic 214	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   172: aastore
    //   173: dup
    //   174: iconst_2
    //   175: aload_0
    //   176: getfield 109	com/tencent/mm/plugin/ext/provider/ExtControlProviderSNS:fCB	Z
    //   179: invokestatic 214	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   182: aastore
    //   183: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   186: new 219	com/tencent/mm/pluginsdk/e/a/b
    //   189: dup
    //   190: invokespecial 220	com/tencent/mm/pluginsdk/e/a/b:<init>	()V
    //   193: astore 5
    //   195: aload 5
    //   197: ldc2_w 221
    //   200: new 8	com/tencent/mm/plugin/ext/provider/ExtControlProviderSNS$2
    //   203: dup
    //   204: aload_0
    //   205: aload 4
    //   207: aload 5
    //   209: invokespecial 225	com/tencent/mm/plugin/ext/provider/ExtControlProviderSNS$2:<init>	(Lcom/tencent/mm/plugin/ext/provider/ExtControlProviderSNS;Lcom/tencent/mm/storage/as;Lcom/tencent/mm/pluginsdk/e/a/b;)V
    //   212: invokevirtual 229	com/tencent/mm/pluginsdk/e/a/b:c	(JLjava/lang/Runnable;)V
    //   215: goto -129 -> 86
    //   218: astore 4
    //   220: ldc 121
    //   222: aload 4
    //   224: invokevirtual 232	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   227: invokestatic 182	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   230: ldc 121
    //   232: aload 4
    //   234: ldc 113
    //   236: iconst_0
    //   237: anewarray 140	java/lang/Object
    //   240: invokestatic 236	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   243: aload_0
    //   244: invokespecial 240	com/tencent/mm/plugin/ext/provider/ExtControlProviderSNS:dhy	()Landroid/database/Cursor;
    //   247: astore 4
    //   249: sipush 24461
    //   252: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   255: aload 4
    //   257: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	258	0	this	ExtControlProviderSNS
    //   0	258	1	paramLong	long
    //   1	86	3	i	int
    //   61	145	4	localas	as
    //   218	15	4	localException	Exception
    //   247	9	4	localCursor	Cursor
    //   193	15	5	localb	b
    // Exception table:
    //   from	to	target	type
    //   22	40	218	java/lang/Exception
    //   46	63	218	java/lang/Exception
    //   68	77	218	java/lang/Exception
    //   77	84	218	java/lang/Exception
    //   90	97	218	java/lang/Exception
    //   105	120	218	java/lang/Exception
    //   123	215	218	java/lang/Exception
  }
  
  private Cursor dhy()
  {
    AppMethodBeat.i(24462);
    Log.i("MicroMsg.ExtControlProviderSNS", "getSnsCursor() , needDownload = true");
    e locale = new e(wtA, (byte)0);
    Object localObject1 = new gb();
    ((gb)localObject1).fBQ.fBS = this.wtB;
    if (!EventCenter.instance.publish((IEvent)localObject1))
    {
      locale.close();
      AppMethodBeat.o(24462);
      return null;
    }
    Cursor localCursor = ((gb)localObject1).fBR.fBL;
    if (localCursor != null) {}
    for (;;)
    {
      try
      {
        i = localCursor.getCount();
        Log.i("MicroMsg.ExtControlProviderSNS", "in getSnsCursor(), snsCount = ".concat(String.valueOf(i)));
        gc localgc;
        if ((i > 0) && (localCursor.moveToFirst()))
        {
          if (localCursor != null)
          {
            localgc = new gc();
            localgc.fBT.fBV = localCursor;
            if (!EventCenter.instance.publish(localgc)) {
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
        bh.beI();
        Object localObject2 = c.bbL().bwg(localgc.fBU.fBW);
        if ((localObject2 == null) || ((int)((com.tencent.mm.contact.d)localObject2).jxt <= 0)) {
          continue;
        }
        String str3 = "";
        switch (localgc.fBU.mediaType)
        {
        case 2: 
          if ((localgc.fBU.fCb == null) || (localgc.fBU.fCb.size() <= 0) || (getContext() == null)) {
            break label848;
          }
          Log.d("MicroMsg.ExtControlProviderSNS", "uris.size() = [%s]", new Object[] { Integer.valueOf(localgc.fBU.fCb.size()) });
          if ((i != 2) && (i != 6) && (i != 3) && (i != 4)) {
            break label848;
          }
          localObject1 = (String)localgc.fBU.fCb.get(0);
          String str2 = str3;
          if (localgc.fBU.fCc != null)
          {
            str2 = str3;
            if (localgc.fBU.fCc.size() > 0)
            {
              str2 = str3;
              if (getContext() != null)
              {
                Log.d("MicroMsg.ExtControlProviderSNS", "bigImgUris.size() = [%s], firstImgWidth = [%s], firstImgHeight = [%s]", new Object[] { Integer.valueOf(localgc.fBU.fCc.size()), Integer.valueOf(localgc.fBU.fCd), Integer.valueOf(localgc.fBU.fCe) });
                if ((i != 2) && (i != 6) && (i != 3))
                {
                  str2 = str3;
                  if (i != 4) {}
                }
                else
                {
                  str2 = (String)localgc.fBU.fCc.get(0);
                }
              }
            }
          }
          str3 = com.tencent.mm.am.d.Tz(localgc.fBU.fBW);
          try
          {
            String str4 = AESUtil.JQ(localgc.fBU.fBX);
            String str5 = localgc.fBU.fBY;
            String str6 = ((as)localObject2).ays();
            localObject2 = str3;
            if (str3 == null) {
              localObject2 = "";
            }
            locale.addRow(new Object[] { str4, str5, localObject1, str6, localObject2, Long.valueOf(localgc.fBU.fBZ), Integer.valueOf(localgc.fBU.fCa), Integer.valueOf(i), str2, Integer.valueOf(localgc.fBU.fCd), Integer.valueOf(localgc.fBU.fCe) });
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
      label848:
      String str1 = "";
      continue;
      i = 5;
    }
  }
  
  private static void hN(boolean paramBoolean)
  {
    AppMethodBeat.i(24459);
    if (paramBoolean)
    {
      jTm = true;
      wty.startTimer(15000L);
      AppMethodBeat.o(24459);
      return;
    }
    wty.startTimer(0L);
    AppMethodBeat.o(24459);
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
    a(paramUri, getContext(), wta);
    if (paramUri == null)
    {
      Lp(3);
      AppMethodBeat.o(24460);
      return null;
    }
    if ((Util.isNullOrNil(this.wsU)) || (Util.isNullOrNil(dht())))
    {
      Lp(3);
      AppMethodBeat.o(24460);
      return null;
    }
    if (jTm)
    {
      Log.w("MicroMsg.ExtControlProviderSNS", "isBusy, return null");
      Lp(5);
      AppMethodBeat.o(24460);
      return null;
    }
    hN(true);
    if (!cxw())
    {
      hN(false);
      Lp(1);
      paramUri = this.sgp;
      AppMethodBeat.o(24460);
      return paramUri;
    }
    if (!fj(getContext()))
    {
      Log.w("MicroMsg.ExtControlProviderSNS", "invalid appid ! return null");
      hN(false);
      Lp(2);
      AppMethodBeat.o(24460);
      return null;
    }
    if ((paramArrayOfString2 == null) || (paramArrayOfString2.length == 0))
    {
      Log.e("MicroMsg.ExtControlProviderSNS", "invaild selections");
      hN(false);
      Lp(3);
      AppMethodBeat.o(24460);
      return null;
    }
    paramArrayOfString1 = paramArrayOfString2[0];
    if (Util.isNullOrNil(paramArrayOfString1))
    {
      Log.e("MicroMsg.ExtControlProviderSNS", "userIdStr should not be null or nil");
      hN(false);
      Lp(3);
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
        switch (wta.match(paramUri))
        {
        default: 
          paramUri = null;
          if (paramUri == null) {
            break label380;
          }
          Lp(0);
          hN(false);
          AppMethodBeat.o(24460);
          return paramUri;
          l = AESUtil.azp(paramArrayOfString1.trim());
          break;
        case 17: 
          paramUri = JR(l);
        }
      }
      catch (Exception paramUri)
      {
        Log.e("MicroMsg.ExtControlProviderSNS", paramUri.getMessage());
        Log.printErrStackTrace("MicroMsg.ExtControlProviderSNS", paramUri, "", new Object[0]);
        hN(false);
        Lp(4);
        AppMethodBeat.o(24460);
        return null;
      }
      continue;
      label380:
      Lp(4);
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