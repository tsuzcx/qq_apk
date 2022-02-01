package com.tencent.mm.plugin.ext.provider;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fu;
import com.tencent.mm.g.a.fu.b;
import com.tencent.mm.g.a.fv;
import com.tencent.mm.g.a.fv.b;
import com.tencent.mm.g.a.gd;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bu.a;
import com.tencent.mm.network.g;
import com.tencent.mm.plugin.ext.key.AESUtil;
import com.tencent.mm.pluginsdk.d.a.b;
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
  private static boolean hho;
  private static MTimerHandler sND;
  private static final String[] sNF;
  private static final UriMatcher sNf;
  private boolean dJL = false;
  private boolean dJM = false;
  private int dJN = 0;
  private String sNG = "";
  
  static
  {
    AppMethodBeat.i(24463);
    sNF = new String[] { "feedId", "desc", "url", "nickname", "avatar", "timestamp", "mediaCount", "type", "bigImgUrl", "firstImgWidth", "firstImgHeight" };
    UriMatcher localUriMatcher = new UriMatcher(-1);
    sNf = localUriMatcher;
    localUriMatcher.addURI(WeChatAuthorities.AUTHORITIES_PLUGIN_EXT_SNS(), "snsInfo", 17);
    hho = false;
    sND = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(24456);
        ExtControlProviderSNS.TT();
        AppMethodBeat.o(24456);
        return false;
      }
    }, false);
    AppMethodBeat.o(24463);
  }
  
  /* Error */
  private Cursor DD(long paramLong)
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
    //   46: invokestatic 154	com/tencent/mm/model/bg:aVF	()Lcom/tencent/mm/model/c;
    //   49: pop
    //   50: invokestatic 160	com/tencent/mm/model/c:aSN	()Lcom/tencent/mm/storage/bv;
    //   53: invokestatic 165	com/tencent/mm/model/z:aTY	()Ljava/lang/String;
    //   56: invokeinterface 171 2 0
    //   61: astore 4
    //   63: aload 4
    //   65: ifnull +12 -> 77
    //   68: aload 4
    //   70: getfield 177	com/tencent/mm/contact/c:gMZ	J
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
    //   105: invokestatic 154	com/tencent/mm/model/bg:aVF	()Lcom/tencent/mm/model/c;
    //   108: pop
    //   109: invokestatic 160	com/tencent/mm/model/c:aSN	()Lcom/tencent/mm/storage/bv;
    //   112: lload_1
    //   113: invokeinterface 191 3 0
    //   118: astore 4
    //   120: goto -57 -> 63
    //   123: aload_0
    //   124: aload 4
    //   126: getfield 196	com/tencent/mm/g/c/ax:field_type	I
    //   129: invokestatic 200	com/tencent/mm/contact/c:oR	(I)Z
    //   132: putfield 107	com/tencent/mm/plugin/ext/provider/ExtControlProviderSNS:dJL	Z
    //   135: aload_0
    //   136: aload 4
    //   138: getfield 203	com/tencent/mm/g/c/ax:field_username	Ljava/lang/String;
    //   141: invokestatic 207	com/tencent/mm/model/z:Im	(Ljava/lang/String;)Z
    //   144: putfield 109	com/tencent/mm/plugin/ext/provider/ExtControlProviderSNS:dJM	Z
    //   147: ldc 121
    //   149: ldc 209
    //   151: iconst_3
    //   152: anewarray 140	java/lang/Object
    //   155: dup
    //   156: iconst_0
    //   157: aload 4
    //   159: getfield 203	com/tencent/mm/g/c/ax:field_username	Ljava/lang/String;
    //   162: aastore
    //   163: dup
    //   164: iconst_1
    //   165: aload_0
    //   166: getfield 107	com/tencent/mm/plugin/ext/provider/ExtControlProviderSNS:dJL	Z
    //   169: invokestatic 214	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   172: aastore
    //   173: dup
    //   174: iconst_2
    //   175: aload_0
    //   176: getfield 109	com/tencent/mm/plugin/ext/provider/ExtControlProviderSNS:dJM	Z
    //   179: invokestatic 214	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   182: aastore
    //   183: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   186: new 219	com/tencent/mm/pluginsdk/d/a/b
    //   189: dup
    //   190: invokespecial 220	com/tencent/mm/pluginsdk/d/a/b:<init>	()V
    //   193: astore 5
    //   195: aload 5
    //   197: ldc2_w 221
    //   200: new 8	com/tencent/mm/plugin/ext/provider/ExtControlProviderSNS$2
    //   203: dup
    //   204: aload_0
    //   205: aload 4
    //   207: aload 5
    //   209: invokespecial 225	com/tencent/mm/plugin/ext/provider/ExtControlProviderSNS$2:<init>	(Lcom/tencent/mm/plugin/ext/provider/ExtControlProviderSNS;Lcom/tencent/mm/storage/as;Lcom/tencent/mm/pluginsdk/d/a/b;)V
    //   212: invokevirtual 229	com/tencent/mm/pluginsdk/d/a/b:c	(JLjava/lang/Runnable;)V
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
    //   244: invokespecial 240	com/tencent/mm/plugin/ext/provider/ExtControlProviderSNS:cSy	()Landroid/database/Cursor;
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
  
  private Cursor cSy()
  {
    AppMethodBeat.i(24462);
    Log.i("MicroMsg.ExtControlProviderSNS", "getSnsCursor() , needDownload = true");
    e locale = new e(sNF, (byte)0);
    Object localObject1 = new fu();
    ((fu)localObject1).dJb.dJd = this.sNG;
    if (!EventCenter.instance.publish((IEvent)localObject1))
    {
      locale.close();
      AppMethodBeat.o(24462);
      return null;
    }
    Cursor localCursor = ((fu)localObject1).dJc.dIU;
    if (localCursor != null) {}
    for (;;)
    {
      try
      {
        i = localCursor.getCount();
        Log.i("MicroMsg.ExtControlProviderSNS", "in getSnsCursor(), snsCount = ".concat(String.valueOf(i)));
        fv localfv;
        if ((i > 0) && (localCursor.moveToFirst()))
        {
          if (localCursor != null)
          {
            localfv = new fv();
            localfv.dJe.dJg = localCursor;
            if (!EventCenter.instance.publish(localfv)) {
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
        bg.aVF();
        Object localObject2 = com.tencent.mm.model.c.aSN().bjJ(localfv.dJf.dJh);
        if ((localObject2 == null) || ((int)((com.tencent.mm.contact.c)localObject2).gMZ <= 0)) {
          continue;
        }
        String str3 = "";
        switch (localfv.dJf.mediaType)
        {
        case 2: 
          if ((localfv.dJf.dJm == null) || (localfv.dJf.dJm.size() <= 0) || (getContext() == null)) {
            break label848;
          }
          Log.d("MicroMsg.ExtControlProviderSNS", "uris.size() = [%s]", new Object[] { Integer.valueOf(localfv.dJf.dJm.size()) });
          if ((i != 2) && (i != 6) && (i != 3) && (i != 4)) {
            break label848;
          }
          localObject1 = (String)localfv.dJf.dJm.get(0);
          String str2 = str3;
          if (localfv.dJf.dJn != null)
          {
            str2 = str3;
            if (localfv.dJf.dJn.size() > 0)
            {
              str2 = str3;
              if (getContext() != null)
              {
                Log.d("MicroMsg.ExtControlProviderSNS", "bigImgUris.size() = [%s], firstImgWidth = [%s], firstImgHeight = [%s]", new Object[] { Integer.valueOf(localfv.dJf.dJn.size()), Integer.valueOf(localfv.dJf.dJo), Integer.valueOf(localfv.dJf.dJp) });
                if ((i != 2) && (i != 6) && (i != 3))
                {
                  str2 = str3;
                  if (i != 4) {}
                }
                else
                {
                  str2 = (String)localfv.dJf.dJn.get(0);
                }
              }
            }
          }
          str3 = com.tencent.mm.aj.c.Me(localfv.dJf.dJh);
          try
          {
            String str4 = AESUtil.DC(localfv.dJf.dJi);
            String str5 = localfv.dJf.dJj;
            String str6 = ((as)localObject2).arJ();
            localObject2 = str3;
            if (str3 == null) {
              localObject2 = "";
            }
            locale.addRow(new Object[] { str4, str5, localObject1, str6, localObject2, Long.valueOf(localfv.dJf.dJk), Integer.valueOf(localfv.dJf.dJl), Integer.valueOf(i), str2, Integer.valueOf(localfv.dJf.dJo), Integer.valueOf(localfv.dJf.dJp) });
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
  
  private static void gW(boolean paramBoolean)
  {
    AppMethodBeat.i(24459);
    if (paramBoolean)
    {
      hho = true;
      sND.startTimer(15000L);
      AppMethodBeat.o(24459);
      return;
    }
    sND.startTimer(0L);
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
    a(paramUri, getContext(), sNf);
    if (paramUri == null)
    {
      HF(3);
      AppMethodBeat.o(24460);
      return null;
    }
    if ((Util.isNullOrNil(this.sMZ)) || (Util.isNullOrNil(cSt())))
    {
      HF(3);
      AppMethodBeat.o(24460);
      return null;
    }
    if (hho)
    {
      Log.w("MicroMsg.ExtControlProviderSNS", "isBusy, return null");
      HF(5);
      AppMethodBeat.o(24460);
      return null;
    }
    gW(true);
    if (!ckf())
    {
      gW(false);
      HF(1);
      paramUri = this.pem;
      AppMethodBeat.o(24460);
      return paramUri;
    }
    if (!fe(getContext()))
    {
      Log.w("MicroMsg.ExtControlProviderSNS", "invalid appid ! return null");
      gW(false);
      HF(2);
      AppMethodBeat.o(24460);
      return null;
    }
    if ((paramArrayOfString2 == null) || (paramArrayOfString2.length == 0))
    {
      Log.e("MicroMsg.ExtControlProviderSNS", "invaild selections");
      gW(false);
      HF(3);
      AppMethodBeat.o(24460);
      return null;
    }
    paramArrayOfString1 = paramArrayOfString2[0];
    if (Util.isNullOrNil(paramArrayOfString1))
    {
      Log.e("MicroMsg.ExtControlProviderSNS", "userIdStr should not be null or nil");
      gW(false);
      HF(3);
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
        switch (sNf.match(paramUri))
        {
        default: 
          paramUri = null;
          if (paramUri == null) {
            break label380;
          }
          HF(0);
          gW(false);
          AppMethodBeat.o(24460);
          return paramUri;
          l = AESUtil.aro(paramArrayOfString1.trim());
          break;
        case 17: 
          paramUri = DD(l);
        }
      }
      catch (Exception paramUri)
      {
        Log.e("MicroMsg.ExtControlProviderSNS", paramUri.getMessage());
        Log.printErrStackTrace("MicroMsg.ExtControlProviderSNS", paramUri, "", new Object[0]);
        gW(false);
        HF(4);
        AppMethodBeat.o(24460);
        return null;
      }
      continue;
      label380:
      HF(4);
    }
  }
  
  public final int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.provider.ExtControlProviderSNS
 * JD-Core Version:    0.7.0.1
 */