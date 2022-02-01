package com.tencent.mm.plugin.fav.model.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.ah;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.a.o;
import com.tencent.mm.plugin.fts.a.a.p;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.asi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class b
  extends com.tencent.mm.plugin.fts.a.b
{
  private com.tencent.mm.plugin.fts.a.j Aeh;
  private a Aei;
  private ISQLiteDatabase Aej;
  private MStorage.IOnStorageChange Aek;
  private com.tencent.mm.plugin.fts.a.m msU;
  
  public b()
  {
    AppMethodBeat.i(101572);
    this.Aek = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(101561);
        if (paramAnonymousMStorageEventData == null)
        {
          AppMethodBeat.o(101561);
          return;
        }
        int i = paramAnonymousMStorageEventData.eventId;
        if (paramAnonymousMStorageEventData.obj == null)
        {
          AppMethodBeat.o(101561);
          return;
        }
        long l = ((Long)paramAnonymousMStorageEventData.obj).longValue();
        if (l < 0L)
        {
          AppMethodBeat.o(101561);
          return;
        }
        Log.i("MicroMsg.FTS.FTS5SearchFavoriteLogic", "EventData: %s", new Object[] { paramAnonymousMStorageEventData });
        switch (i)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(101561);
          return;
          b.c(b.this).a(65576, new b.d(b.this, l, (byte)0));
          AppMethodBeat.o(101561);
          return;
          b.c(b.this).a(65576, new b.b(b.this, l));
        }
      }
    };
    AppMethodBeat.o(101572);
  }
  
  private int a(String[] paramArrayOfString, int[] paramArrayOfInt, long paramLong1, int paramInt, long paramLong2, String paramString)
  {
    AppMethodBeat.i(101575);
    int j = 0;
    String str2 = paramArrayOfString[0];
    String str1 = paramArrayOfString[1];
    paramArrayOfString = paramArrayOfString[2];
    int i = j;
    if (str2 != null)
    {
      i = j;
      if (str2.length() > 0)
      {
        if (!str2.equalsIgnoreCase(str1)) {
          break label188;
        }
        str1 = null;
        paramArrayOfString = null;
      }
    }
    label188:
    for (;;)
    {
      if ((str1 != null) && (str1.equalsIgnoreCase(paramArrayOfString))) {
        paramArrayOfString = null;
      }
      for (;;)
      {
        this.Aei.a(paramArrayOfInt[0], paramLong1, paramString, paramLong2, str2, paramInt);
        j = 1;
        i = j;
        if (str1 != null)
        {
          i = j;
          if (str1.length() > 0)
          {
            this.Aei.a(paramArrayOfInt[1], paramLong1, paramString, paramLong2, str1, paramInt);
            i = 2;
          }
        }
        if ((paramArrayOfString != null) && (paramArrayOfString.length() > 0))
        {
          this.Aei.a(paramArrayOfInt[2], paramLong1, paramString, paramLong2, paramArrayOfString, paramInt);
          i += 1;
        }
        for (;;)
        {
          AppMethodBeat.o(101575);
          return i;
        }
      }
    }
  }
  
  public final com.tencent.mm.plugin.fts.a.a.c a(l paraml)
  {
    AppMethodBeat.i(101571);
    if (paraml.qRb == 1) {}
    for (paraml = new f(paraml);; paraml = new e(paraml))
    {
      paraml = this.msU.a(-65536, paraml);
      AppMethodBeat.o(101571);
      return paraml;
    }
  }
  
  public final boolean aXx()
  {
    AppMethodBeat.i(101574);
    ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().remove(this.Aek);
    this.Aei = null;
    this.msU = null;
    AppMethodBeat.o(101574);
    return true;
  }
  
  public final String getName()
  {
    return "FTS5SearchFavoriteLogic";
  }
  
  public final boolean onCreate()
  {
    AppMethodBeat.i(101573);
    if (!((n)com.tencent.mm.kernel.h.az(n.class)).isFTSContextReady())
    {
      Log.i("MicroMsg.FTS.FTS5SearchFavoriteLogic", "Create Fail!");
      AppMethodBeat.o(101573);
      return false;
    }
    Log.i("MicroMsg.FTS.FTS5SearchFavoriteLogic", "Create Success!");
    this.msU = ((n)com.tencent.mm.kernel.h.az(n.class)).getFTSTaskDaemon();
    this.Aei = ((a)((n)com.tencent.mm.kernel.h.az(n.class)).getFTSIndexStorage(256));
    this.Aeh = ((n)com.tencent.mm.kernel.h.az(n.class)).getFTSMainDB();
    this.Aej = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().dQF();
    this.msU.a(131122, new a((byte)0));
    ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().add(this.Aek);
    AppMethodBeat.o(101573);
    return true;
  }
  
  final class a
    extends com.tencent.mm.plugin.fts.a.a.c
  {
    private HashSet<Long> Aem = null;
    private int Aen = 0;
    private int Aeo = 0;
    private int Aep = 0;
    private int mFailedCount = 0;
    
    private a() {}
    
    /* Error */
    public final boolean aXz()
    {
      // Byte code:
      //   0: ldc 43
      //   2: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 21	com/tencent/mm/plugin/fav/model/a/b$a:Ael	Lcom/tencent/mm/plugin/fav/model/a/b;
      //   9: invokestatic 53	com/tencent/mm/plugin/fav/model/a/b:b	(Lcom/tencent/mm/plugin/fav/model/a/b;)Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
      //   12: ifnonnull +17 -> 29
      //   15: ldc 55
      //   17: ldc 57
      //   19: invokestatic 63	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
      //   22: ldc 43
      //   24: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   27: iconst_1
      //   28: ireturn
      //   29: ldc 55
      //   31: ldc 68
      //   33: invokestatic 70	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   36: aload_0
      //   37: getfield 26	com/tencent/mm/plugin/fav/model/a/b$a:Aem	Ljava/util/HashSet;
      //   40: ifnonnull +151 -> 191
      //   43: aload_0
      //   44: new 72	java/util/HashSet
      //   47: dup
      //   48: invokespecial 73	java/util/HashSet:<init>	()V
      //   51: putfield 26	com/tencent/mm/plugin/fav/model/a/b$a:Aem	Ljava/util/HashSet;
      //   54: aload_0
      //   55: getfield 21	com/tencent/mm/plugin/fav/model/a/b$a:Ael	Lcom/tencent/mm/plugin/fav/model/a/b;
      //   58: invokestatic 76	com/tencent/mm/plugin/fav/model/a/b:a	(Lcom/tencent/mm/plugin/fav/model/a/b;)Lcom/tencent/mm/plugin/fav/model/a/a;
      //   61: getstatic 82	com/tencent/mm/plugin/fts/a/c:Hrb	[I
      //   64: iconst_0
      //   65: iconst_1
      //   66: iconst_0
      //   67: iconst_0
      //   68: iconst_0
      //   69: invokevirtual 87	com/tencent/mm/plugin/fav/model/a/a:a	([IZZZZZ)Landroid/database/Cursor;
      //   72: astore 6
      //   74: aload 6
      //   76: astore 5
      //   78: aload 6
      //   80: invokeinterface 92 1 0
      //   85: ifeq +83 -> 168
      //   88: aload 6
      //   90: astore 5
      //   92: aload 6
      //   94: iconst_0
      //   95: invokeinterface 96 2 0
      //   100: lstore_3
      //   101: aload 6
      //   103: astore 5
      //   105: aload_0
      //   106: getfield 26	com/tencent/mm/plugin/fav/model/a/b$a:Aem	Ljava/util/HashSet;
      //   109: lload_3
      //   110: invokestatic 102	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   113: invokevirtual 106	java/util/HashSet:add	(Ljava/lang/Object;)Z
      //   116: pop
      //   117: goto -43 -> 74
      //   120: astore 7
      //   122: aload 6
      //   124: astore 5
      //   126: ldc 43
      //   128: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   131: aload 6
      //   133: astore 5
      //   135: aload 7
      //   137: athrow
      //   138: astore 7
      //   140: aload 5
      //   142: astore 6
      //   144: aload 7
      //   146: astore 5
      //   148: aload 6
      //   150: ifnull +10 -> 160
      //   153: aload 6
      //   155: invokeinterface 109 1 0
      //   160: ldc 43
      //   162: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   165: aload 5
      //   167: athrow
      //   168: aload 6
      //   170: ifnull +10 -> 180
      //   173: aload 6
      //   175: invokeinterface 109 1 0
      //   180: aload_0
      //   181: aload_0
      //   182: getfield 26	com/tencent/mm/plugin/fav/model/a/b$a:Aem	Ljava/util/HashSet;
      //   185: invokevirtual 113	java/util/HashSet:size	()I
      //   188: putfield 28	com/tencent/mm/plugin/fav/model/a/b$a:Aen	I
      //   191: invokestatic 118	java/lang/Thread:interrupted	()Z
      //   194: ifeq +20 -> 214
      //   197: new 120	java/lang/InterruptedException
      //   200: dup
      //   201: invokespecial 121	java/lang/InterruptedException:<init>	()V
      //   204: astore 5
      //   206: ldc 43
      //   208: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   211: aload 5
      //   213: athrow
      //   214: aload_0
      //   215: getfield 21	com/tencent/mm/plugin/fav/model/a/b$a:Ael	Lcom/tencent/mm/plugin/fav/model/a/b;
      //   218: invokestatic 53	com/tencent/mm/plugin/fav/model/a/b:b	(Lcom/tencent/mm/plugin/fav/model/a/b;)Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
      //   221: ldc 123
      //   223: aconst_null
      //   224: invokeinterface 129 3 0
      //   229: astore 5
      //   231: bipush 50
      //   233: istore_1
      //   234: aload 5
      //   236: invokeinterface 92 1 0
      //   241: ifeq +202 -> 443
      //   244: invokestatic 118	java/lang/Thread:interrupted	()Z
      //   247: ifeq +62 -> 309
      //   250: aload_0
      //   251: getfield 21	com/tencent/mm/plugin/fav/model/a/b$a:Ael	Lcom/tencent/mm/plugin/fav/model/a/b;
      //   254: invokestatic 76	com/tencent/mm/plugin/fav/model/a/b:a	(Lcom/tencent/mm/plugin/fav/model/a/b;)Lcom/tencent/mm/plugin/fav/model/a/a;
      //   257: invokevirtual 132	com/tencent/mm/plugin/fav/model/a/a:commit	()V
      //   260: new 120	java/lang/InterruptedException
      //   263: dup
      //   264: invokespecial 121	java/lang/InterruptedException:<init>	()V
      //   267: astore 6
      //   269: ldc 43
      //   271: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   274: aload 6
      //   276: athrow
      //   277: astore 6
      //   279: ldc 43
      //   281: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   284: aload 6
      //   286: athrow
      //   287: astore 6
      //   289: aload 5
      //   291: ifnull +10 -> 301
      //   294: aload 5
      //   296: invokeinterface 109 1 0
      //   301: ldc 43
      //   303: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   306: aload 6
      //   308: athrow
      //   309: new 134	com/tencent/mm/plugin/fav/model/a/b$c
      //   312: dup
      //   313: aload_0
      //   314: getfield 21	com/tencent/mm/plugin/fav/model/a/b$a:Ael	Lcom/tencent/mm/plugin/fav/model/a/b;
      //   317: iconst_0
      //   318: invokespecial 136	com/tencent/mm/plugin/fav/model/a/b$c:<init>	(Lcom/tencent/mm/plugin/fav/model/a/b;B)V
      //   321: astore 6
      //   323: aload 6
      //   325: aload 5
      //   327: invokevirtual 140	com/tencent/mm/plugin/fav/model/a/b$c:convertFrom	(Landroid/database/Cursor;)V
      //   330: aload 6
      //   332: invokestatic 143	com/tencent/mm/plugin/fav/model/a/b:a	(Lcom/tencent/mm/plugin/fav/model/a/b$c;)Z
      //   335: ifne -101 -> 234
      //   338: aload_0
      //   339: getfield 26	com/tencent/mm/plugin/fav/model/a/b$a:Aem	Ljava/util/HashSet;
      //   342: aload 6
      //   344: getfield 147	com/tencent/mm/plugin/fav/model/a/b$c:localId	J
      //   347: invokestatic 102	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   350: invokevirtual 150	java/util/HashSet:remove	(Ljava/lang/Object;)Z
      //   353: ifne -119 -> 234
      //   356: iload_1
      //   357: bipush 50
      //   359: if_icmplt +274 -> 633
      //   362: aload_0
      //   363: getfield 21	com/tencent/mm/plugin/fav/model/a/b$a:Ael	Lcom/tencent/mm/plugin/fav/model/a/b;
      //   366: invokestatic 76	com/tencent/mm/plugin/fav/model/a/b:a	(Lcom/tencent/mm/plugin/fav/model/a/b;)Lcom/tencent/mm/plugin/fav/model/a/a;
      //   369: invokevirtual 132	com/tencent/mm/plugin/fav/model/a/a:commit	()V
      //   372: aload_0
      //   373: getfield 21	com/tencent/mm/plugin/fav/model/a/b$a:Ael	Lcom/tencent/mm/plugin/fav/model/a/b;
      //   376: invokestatic 76	com/tencent/mm/plugin/fav/model/a/b:a	(Lcom/tencent/mm/plugin/fav/model/a/b;)Lcom/tencent/mm/plugin/fav/model/a/a;
      //   379: invokevirtual 153	com/tencent/mm/plugin/fav/model/a/a:beginTransaction	()V
      //   382: iconst_0
      //   383: istore_2
      //   384: iload_2
      //   385: istore_1
      //   386: iload_2
      //   387: aload_0
      //   388: getfield 21	com/tencent/mm/plugin/fav/model/a/b$a:Ael	Lcom/tencent/mm/plugin/fav/model/a/b;
      //   391: aload 6
      //   393: invokestatic 156	com/tencent/mm/plugin/fav/model/a/b:a	(Lcom/tencent/mm/plugin/fav/model/a/b;Lcom/tencent/mm/plugin/fav/model/a/b$c;)I
      //   396: iadd
      //   397: istore_2
      //   398: iload_2
      //   399: istore_1
      //   400: aload_0
      //   401: aload_0
      //   402: getfield 30	com/tencent/mm/plugin/fav/model/a/b$a:Aeo	I
      //   405: iconst_1
      //   406: iadd
      //   407: putfield 30	com/tencent/mm/plugin/fav/model/a/b$a:Aeo	I
      //   410: iload_2
      //   411: istore_1
      //   412: goto -178 -> 234
      //   415: astore 6
      //   417: ldc 55
      //   419: aload 6
      //   421: ldc 158
      //   423: iconst_0
      //   424: anewarray 160	java/lang/Object
      //   427: invokestatic 164	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   430: aload_0
      //   431: aload_0
      //   432: getfield 34	com/tencent/mm/plugin/fav/model/a/b$a:mFailedCount	I
      //   435: iconst_1
      //   436: iadd
      //   437: putfield 34	com/tencent/mm/plugin/fav/model/a/b$a:mFailedCount	I
      //   440: goto -206 -> 234
      //   443: aload 5
      //   445: ifnull +10 -> 455
      //   448: aload 5
      //   450: invokeinterface 109 1 0
      //   455: aload_0
      //   456: getfield 21	com/tencent/mm/plugin/fav/model/a/b$a:Ael	Lcom/tencent/mm/plugin/fav/model/a/b;
      //   459: invokestatic 76	com/tencent/mm/plugin/fav/model/a/b:a	(Lcom/tencent/mm/plugin/fav/model/a/b;)Lcom/tencent/mm/plugin/fav/model/a/a;
      //   462: invokevirtual 132	com/tencent/mm/plugin/fav/model/a/a:commit	()V
      //   465: aload_0
      //   466: getfield 26	com/tencent/mm/plugin/fav/model/a/b$a:Aem	Ljava/util/HashSet;
      //   469: invokevirtual 168	java/util/HashSet:iterator	()Ljava/util/Iterator;
      //   472: astore 5
      //   474: aload 5
      //   476: invokeinterface 173 1 0
      //   481: ifeq +116 -> 597
      //   484: invokestatic 118	java/lang/Thread:interrupted	()Z
      //   487: ifeq +30 -> 517
      //   490: aload_0
      //   491: getfield 21	com/tencent/mm/plugin/fav/model/a/b$a:Ael	Lcom/tencent/mm/plugin/fav/model/a/b;
      //   494: invokestatic 76	com/tencent/mm/plugin/fav/model/a/b:a	(Lcom/tencent/mm/plugin/fav/model/a/b;)Lcom/tencent/mm/plugin/fav/model/a/a;
      //   497: invokevirtual 132	com/tencent/mm/plugin/fav/model/a/a:commit	()V
      //   500: new 120	java/lang/InterruptedException
      //   503: dup
      //   504: invokespecial 121	java/lang/InterruptedException:<init>	()V
      //   507: astore 5
      //   509: ldc 43
      //   511: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   514: aload 5
      //   516: athrow
      //   517: iload_1
      //   518: bipush 50
      //   520: if_icmplt +110 -> 630
      //   523: aload_0
      //   524: getfield 21	com/tencent/mm/plugin/fav/model/a/b$a:Ael	Lcom/tencent/mm/plugin/fav/model/a/b;
      //   527: invokestatic 76	com/tencent/mm/plugin/fav/model/a/b:a	(Lcom/tencent/mm/plugin/fav/model/a/b;)Lcom/tencent/mm/plugin/fav/model/a/a;
      //   530: invokevirtual 132	com/tencent/mm/plugin/fav/model/a/a:commit	()V
      //   533: aload_0
      //   534: getfield 21	com/tencent/mm/plugin/fav/model/a/b$a:Ael	Lcom/tencent/mm/plugin/fav/model/a/b;
      //   537: invokestatic 76	com/tencent/mm/plugin/fav/model/a/b:a	(Lcom/tencent/mm/plugin/fav/model/a/b;)Lcom/tencent/mm/plugin/fav/model/a/a;
      //   540: invokevirtual 153	com/tencent/mm/plugin/fav/model/a/a:beginTransaction	()V
      //   543: iconst_0
      //   544: istore_1
      //   545: aload 5
      //   547: invokeinterface 177 1 0
      //   552: checkcast 98	java/lang/Long
      //   555: invokevirtual 181	java/lang/Long:longValue	()J
      //   558: lstore_3
      //   559: aload_0
      //   560: getfield 21	com/tencent/mm/plugin/fav/model/a/b$a:Ael	Lcom/tencent/mm/plugin/fav/model/a/b;
      //   563: invokestatic 76	com/tencent/mm/plugin/fav/model/a/b:a	(Lcom/tencent/mm/plugin/fav/model/a/b;)Lcom/tencent/mm/plugin/fav/model/a/a;
      //   566: getstatic 82	com/tencent/mm/plugin/fts/a/c:Hrb	[I
      //   569: lload_3
      //   570: invokevirtual 185	com/tencent/mm/plugin/fav/model/a/a:c	([IJ)V
      //   573: iload_1
      //   574: iconst_1
      //   575: iadd
      //   576: istore_1
      //   577: aload_0
      //   578: aload_0
      //   579: getfield 32	com/tencent/mm/plugin/fav/model/a/b$a:Aep	I
      //   582: iconst_1
      //   583: iadd
      //   584: putfield 32	com/tencent/mm/plugin/fav/model/a/b$a:Aep	I
      //   587: aload 5
      //   589: invokeinterface 187 1 0
      //   594: goto -120 -> 474
      //   597: aload_0
      //   598: getfield 21	com/tencent/mm/plugin/fav/model/a/b$a:Ael	Lcom/tencent/mm/plugin/fav/model/a/b;
      //   601: invokestatic 76	com/tencent/mm/plugin/fav/model/a/b:a	(Lcom/tencent/mm/plugin/fav/model/a/b;)Lcom/tencent/mm/plugin/fav/model/a/a;
      //   604: invokevirtual 132	com/tencent/mm/plugin/fav/model/a/a:commit	()V
      //   607: ldc 43
      //   609: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   612: iconst_1
      //   613: ireturn
      //   614: astore 5
      //   616: aconst_null
      //   617: astore 6
      //   619: goto -471 -> 148
      //   622: astore 7
      //   624: aconst_null
      //   625: astore 6
      //   627: goto -505 -> 122
      //   630: goto -85 -> 545
      //   633: iload_1
      //   634: istore_2
      //   635: goto -251 -> 384
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	638	0	this	a
      //   233	401	1	i	int
      //   383	252	2	j	int
      //   100	470	3	l	long
      //   76	512	5	localObject1	Object
      //   614	1	5	localObject2	Object
      //   72	203	6	localObject3	Object
      //   277	8	6	localException1	Exception
      //   287	20	6	localObject4	Object
      //   321	71	6	localc	b.c
      //   415	5	6	localException2	Exception
      //   617	9	6	localObject5	Object
      //   120	16	7	localException3	Exception
      //   138	7	7	localObject6	Object
      //   622	1	7	localException4	Exception
      // Exception table:
      //   from	to	target	type
      //   78	88	120	java/lang/Exception
      //   92	101	120	java/lang/Exception
      //   105	117	120	java/lang/Exception
      //   78	88	138	finally
      //   92	101	138	finally
      //   105	117	138	finally
      //   126	131	138	finally
      //   135	138	138	finally
      //   234	277	277	java/lang/Exception
      //   309	356	277	java/lang/Exception
      //   362	382	277	java/lang/Exception
      //   417	440	277	java/lang/Exception
      //   234	277	287	finally
      //   279	287	287	finally
      //   309	356	287	finally
      //   362	382	287	finally
      //   386	398	287	finally
      //   400	410	287	finally
      //   417	440	287	finally
      //   386	398	415	java/lang/Exception
      //   400	410	415	java/lang/Exception
      //   54	74	614	finally
      //   54	74	622	java/lang/Exception
    }
    
    public final String coz()
    {
      AppMethodBeat.i(101563);
      String str = String.format("{new: %d exist: %d removed: %d failed: %d}", new Object[] { Integer.valueOf(this.Aeo), Integer.valueOf(this.Aen), Integer.valueOf(this.Aep), Integer.valueOf(this.mFailedCount) });
      AppMethodBeat.o(101563);
      return str;
    }
    
    public final int getId()
    {
      return 6;
    }
    
    public final String getName()
    {
      return "BuildFavoriteIndexTask";
    }
  }
  
  final class b
    extends com.tencent.mm.plugin.fts.a.a.c
  {
    private long Aeq;
    
    public b(long paramLong)
    {
      this.Aeq = paramLong;
    }
    
    public final boolean aXz()
    {
      AppMethodBeat.i(101564);
      Log.d("MicroMsg.FTS.FTS5SearchFavoriteLogic", "start to delete favorite item");
      long l = this.Aeq;
      b.a(b.this).c(com.tencent.mm.plugin.fts.a.c.Hrb, l);
      AppMethodBeat.o(101564);
      return true;
    }
    
    public final String coz()
    {
      AppMethodBeat.i(101565);
      String str = String.format("{favItemId: %d}", new Object[] { Long.valueOf(this.Aeq) });
      AppMethodBeat.o(101565);
      return str;
    }
    
    public final String getName()
    {
      return "DeleteFavItemTask";
    }
  }
  
  final class c
  {
    asi Aer;
    long egK;
    String hQQ;
    arv hXw;
    long localId;
    int type;
    
    private c() {}
    
    public final void convertFrom(Cursor paramCursor)
    {
      AppMethodBeat.i(101566);
      this.localId = paramCursor.getLong(0);
      this.type = paramCursor.getInt(1);
      this.egK = paramCursor.getLong(2);
      this.hQQ = paramCursor.getString(3);
      byte[] arrayOfByte = paramCursor.getBlob(4);
      if ((arrayOfByte == null) || (arrayOfByte.length == 0)) {
        Log.d("MicroMsg.FTS.FTS5SearchFavoriteLogic", "FavIndexItem protoData is null or data length is 0");
      }
      for (this.hXw = new arv();; this.hXw = ((arv)new arv().parseFrom(arrayOfByte)))
      {
        paramCursor = paramCursor.getBlob(5);
        if ((paramCursor != null) && (paramCursor.length != 0)) {
          break;
        }
        this.Aer = null;
        AppMethodBeat.o(101566);
        return;
      }
      this.Aer = ((asi)new asi().parseFrom(paramCursor));
      AppMethodBeat.o(101566);
    }
  }
  
  final class d
    extends com.tencent.mm.plugin.fts.a.a.c
  {
    private long Aeq;
    private int Aes;
    
    private d(long paramLong)
    {
      this.Aeq = paramLong;
    }
    
    public final boolean aXz()
    {
      AppMethodBeat.i(101567);
      if (b.b(b.this) == null)
      {
        Log.e("MicroMsg.FTS.FTS5SearchFavoriteLogic", "InsertFavItemTask: fav db is null");
        AppMethodBeat.o(101567);
        return true;
      }
      Log.d("MicroMsg.FTS.FTS5SearchFavoriteLogic", "start to insert favorite item");
      Cursor localCursor2 = b.b(b.this).rawQuery("SELECT localId, type, updateTime, fromUser, favProto, tagProto FROM FavItemInfo WHERE localId = ? AND flag <> -1;", new String[] { String.valueOf(this.Aeq) }, 2);
      Cursor localCursor3 = localCursor2;
      Cursor localCursor1 = localCursor2;
      Object localObject1 = localCursor2;
      try
      {
        if (localCursor2.moveToFirst())
        {
          localCursor1 = localCursor2;
          localObject1 = localCursor2;
          b.c localc = new b.c(b.this, (byte)0);
          localCursor1 = localCursor2;
          localObject1 = localCursor2;
          localc.convertFrom(localCursor2);
          localCursor1 = localCursor2;
          localObject1 = localCursor2;
          localCursor2.close();
          localCursor2 = null;
          Object localObject3 = null;
          localCursor3 = null;
          localCursor1 = localCursor2;
          localObject1 = localObject3;
          boolean bool = b.a(localc);
          if (bool)
          {
            AppMethodBeat.o(101567);
            return true;
          }
          localCursor1 = localCursor2;
          localObject1 = localObject3;
          b.a(b.this).beginTransaction();
          localCursor1 = localCursor2;
          localObject1 = localObject3;
          long l = this.Aeq;
          localCursor1 = localCursor2;
          localObject1 = localObject3;
          b.a(b.this).c(com.tencent.mm.plugin.fts.a.c.Hrb, l);
          localCursor1 = localCursor2;
          localObject1 = localObject3;
          this.Aes = b.a(b.this, localc);
          localCursor1 = localCursor2;
          localObject1 = localObject3;
          b.a(b.this).commit();
        }
        if (localCursor3 != null) {
          localCursor3.close();
        }
        AppMethodBeat.o(101567);
        return true;
      }
      catch (Exception localException)
      {
        localObject1 = localCursor1;
        AppMethodBeat.o(101567);
        localObject1 = localCursor1;
        throw localException;
      }
      finally
      {
        if (localObject1 != null) {
          ((Cursor)localObject1).close();
        }
        AppMethodBeat.o(101567);
      }
    }
    
    public final String coz()
    {
      AppMethodBeat.i(101568);
      String str = String.format("{favItemId: %d transactionCount: %d}", new Object[] { Long.valueOf(this.Aeq), Integer.valueOf(this.Aes) });
      AppMethodBeat.o(101568);
      return str;
    }
    
    public final String getName()
    {
      return "InsertFavItemTask";
    }
  }
  
  final class e
    extends k
  {
    e(l paraml)
    {
      super();
    }
    
    public final void a(com.tencent.mm.plugin.fts.a.a.m paramm)
    {
      AppMethodBeat.i(101569);
      paramm.FWt = com.tencent.mm.plugin.fts.a.a.j.cc(this.Htr.query, true);
      Object localObject1 = new HashMap();
      Object localObject2 = b.a(b.this).a(paramm.FWt, com.tencent.mm.plugin.fts.a.c.Hrb, null, false, false);
      while (((Cursor)localObject2).moveToNext())
      {
        p localp = new p().l((Cursor)localObject2);
        o localo = (o)((HashMap)localObject1).get(Long.valueOf(localp.HtI));
        if ((localo == null) || (d.j(com.tencent.mm.plugin.fts.a.c.Hrw, localp.subtype, localo.subtype) < 0)) {
          ((HashMap)localObject1).put(Long.valueOf(localp.HtI), localp);
        }
        if (Thread.interrupted())
        {
          ((Cursor)localObject2).close();
          paramm = new InterruptedException();
          AppMethodBeat.o(101569);
          throw paramm;
        }
      }
      ((Cursor)localObject2).close();
      if (Thread.interrupted())
      {
        paramm = new InterruptedException();
        AppMethodBeat.o(101569);
        throw paramm;
      }
      paramm.HtF = new ArrayList(((HashMap)localObject1).size());
      localObject1 = ((HashMap)localObject1).values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (p)((Iterator)localObject1).next();
        paramm.HtF.add(localObject2);
      }
      if (this.Htr.HtB != null) {
        Collections.sort(paramm.HtF, this.Htr.HtB);
      }
      AppMethodBeat.o(101569);
    }
    
    public final String getName()
    {
      return "SearchFavoriteTask";
    }
  }
  
  final class f
    extends k
  {
    f(l paraml)
    {
      super();
    }
    
    public final void a(com.tencent.mm.plugin.fts.a.a.m paramm)
    {
      AppMethodBeat.i(101570);
      paramm.FWt = com.tencent.mm.plugin.fts.a.a.j.cc(this.Htr.query, true);
      Object localObject1 = b.a(b.this);
      Object localObject2 = paramm.FWt;
      int i = this.Htr.Htz;
      localObject2 = ((com.tencent.mm.plugin.fts.a.a.j)localObject2).fxx();
      localObject2 = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' ORDER BY -timestamp, subtype limit " + (i + 1 + 1) + ";", new Object[] { ((a)localObject1).fxn(), ((a)localObject1).fxn(), ((a)localObject1).fxo(), ((a)localObject1).fxn(), ((a)localObject1).fxo(), ((a)localObject1).fxo(), localObject2 });
      localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject1).HqR.rawQuery((String)localObject2, null);
      paramm.HtF = new ArrayList();
      localObject2 = new HashSet();
      while (((Cursor)localObject1).moveToNext()) {
        if (((HashSet)localObject2).add(String.valueOf(((Cursor)localObject1).getLong(3))))
        {
          p localp = new p().l((Cursor)localObject1);
          paramm.HtF.add(localp);
          if (paramm.HtF.size() <= this.Htr.Htz) {
            if (Thread.interrupted())
            {
              ((Cursor)localObject1).close();
              paramm = new InterruptedException();
              AppMethodBeat.o(101570);
              throw paramm;
            }
          }
        }
      }
      if (localObject1 != null) {
        ((Cursor)localObject1).close();
      }
      if (Thread.interrupted())
      {
        paramm = new InterruptedException();
        AppMethodBeat.o(101570);
        throw paramm;
      }
      AppMethodBeat.o(101570);
    }
    
    public final int getId()
    {
      return 9;
    }
    
    public final String getName()
    {
      return "SearchTopFavoriteTask";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.model.a.b
 * JD-Core Version:    0.7.0.1
 */