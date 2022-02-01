package com.tencent.mm.am;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.e;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.vfs.u;
import junit.framework.Assert;

public final class g
  implements i
{
  c lAI;
  m lAJ;
  boolean lAK;
  private boolean lAL;
  private boolean lAM;
  private QueueWorkerThread lAN;
  j lAs;
  
  public g()
  {
    AppMethodBeat.i(150274);
    this.lAs = null;
    this.lAI = null;
    this.lAJ = null;
    this.lAK = false;
    this.lAL = true;
    this.lAM = true;
    this.lAN = null;
    com.tencent.mm.kernel.h.aGY().a(158, this);
    AppMethodBeat.o(150274);
  }
  
  private int a(j paramj)
  {
    AppMethodBeat.i(150278);
    if ((this.lAN == null) || (this.lAN.isDead())) {
      this.lAN = new QueueWorkerThread(1, "get-hd-headimg", 1);
    }
    int i = this.lAN.add(new b(paramj));
    AppMethodBeat.o(150278);
    return i;
  }
  
  public final int a(String paramString, c paramc)
  {
    AppMethodBeat.i(150276);
    Assert.assertTrue("GetHDHeadImg must set callback", true);
    if (Util.isNullOrNil(paramString))
    {
      paramc.dL(3, -101);
      AppMethodBeat.o(150276);
      return -101;
    }
    this.lAI = paramc;
    if (as.PY(paramString)) {}
    for (String str = as.bvW(paramString);; str = paramString)
    {
      this.lAs = q.bhP().TS(str);
      Log.d("MicroMsg.GetHDHeadImgHelper", "GetHDHeadImg: %s", new Object[] { str });
      if ((this.lAs == null) || (!this.lAs.getUsername().equals(str)))
      {
        this.lAs = new j();
        this.lAs.username = str;
      }
      if (Util.isNullOrNil(this.lAs.bhH()))
      {
        Log.w("MicroMsg.GetHDHeadImgHelper", "dkhurl [%s] has NO URL flag:%d !", new Object[] { paramString, Integer.valueOf(this.lAs.hDc) });
        this.lAJ = new m(str);
        if (!com.tencent.mm.kernel.h.aGY().a(this.lAJ, 0))
        {
          paramc.dL(3, -102);
          AppMethodBeat.o(150276);
          return -102;
        }
        AppMethodBeat.o(150276);
        return 0;
      }
      if (a(this.lAs) == 0)
      {
        AppMethodBeat.o(150276);
        return 0;
      }
      paramc.dL(3, -103);
      AppMethodBeat.o(150276);
      return -103;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(150277);
    this.lAI.dL(paramInt1, paramInt2);
    AppMethodBeat.o(150277);
  }
  
  public final void qE()
  {
    AppMethodBeat.i(150275);
    com.tencent.mm.kernel.h.aGY().b(158, this);
    AppMethodBeat.o(150275);
  }
  
  final class a
    implements QueueWorkerThread.ThreadObject
  {
    boolean bqe;
    boolean isHevc = false;
    String lAO;
    String lAP;
    boolean lAQ = true;
    j lAs;
    
    public a(j paramj, String paramString1, String paramString2)
    {
      this.lAs = paramj;
      this.lAO = paramString1;
      this.lAP = paramString2;
      this.bqe = false;
    }
    
    public final boolean doInBackground()
    {
      AppMethodBeat.i(150269);
      Object localObject;
      String str1;
      String str2;
      if (this.bqe)
      {
        com.tencent.mm.plugin.report.service.h.IzE.el(138, 61);
        Log.i("MicroMsg.GetHDHeadImgHelper", "DecryptAvatar: decrypt %s", new Object[] { this.lAP });
        localObject = UtilsJni.DecryptAvatar(u.aY(this.lAP, 0, -1));
        if ((localObject != null) && (localObject.length > 0))
        {
          u.deleteFile(this.lAP);
          u.H(this.lAP, (byte[])localObject);
        }
      }
      else
      {
        if (!ImgUtil.isWXGF(this.lAP)) {
          break label331;
        }
        this.isHevc = true;
        Log.i("MicroMsg.GetHDHeadImgHelper", "DecryptAvatar: hevc to pic start");
        com.tencent.mm.plugin.report.service.h.IzE.el(138, 63);
        localObject = this.lAP + "_hevc";
        boolean bool1 = u.oo(this.lAP, (String)localObject);
        boolean bool2 = u.bBV(this.lAP);
        str1 = u.n(this.lAP, true);
        str2 = u.n((String)localObject, false);
        if ((str1 != null) && (str2 != null)) {
          break label278;
        }
        Log.i("MicroMsg.GetHDHeadImgHelper", "DecryptAvatar: uri is null %s, %s; path %s, %s; result %s, %s", new Object[] { str1, str2, this.lAP, localObject, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        com.tencent.mm.plugin.report.service.h.IzE.el(138, 65);
        AppMethodBeat.o(150269);
        return true;
      }
      com.tencent.mm.plugin.report.service.h.IzE.el(138, 62);
      Log.i("MicroMsg.GetHDHeadImgHelper", "DecryptAvatar: decrypt failed");
      AppMethodBeat.o(150269);
      return true;
      label278:
      int i = ((c)com.tencent.mm.kernel.h.ae(c.class)).nativeWxam2Pic(str2, str1);
      u.deleteFile((String)localObject);
      if (i != 0)
      {
        com.tencent.mm.plugin.report.service.h.IzE.el(138, 64);
        Log.i("MicroMsg.GetHDHeadImgHelper", "DecryptAvatar: hevc to pic failed");
        AppMethodBeat.o(150269);
        return true;
      }
      label331:
      this.lAQ = false;
      AppMethodBeat.o(150269);
      return true;
    }
    
    public final boolean onPostExecute()
    {
      AppMethodBeat.i(150270);
      if (g.this.lAK)
      {
        AppMethodBeat.o(150270);
        return false;
      }
      if (this.lAQ)
      {
        if ((this.isHevc) && (g.c(g.this)))
        {
          Log.i("MicroMsg.GetHDHeadImgHelper", "onPostExecute: first request hevc failed");
          g.d(g.this);
          g.e(g.this);
          g.b(g.this).add(new g.b(g.this, this.lAs));
        }
        for (;;)
        {
          AppMethodBeat.o(150270);
          return false;
          g.this.lAI.dL(3, -1);
        }
      }
      u.deleteFile(this.lAO);
      u.oo(this.lAP, this.lAO);
      m.bh(this.lAO, this.lAs.getUsername());
      g.this.lAI.dL(0, 0);
      AppMethodBeat.o(150270);
      return true;
    }
  }
  
  @SuppressLint({"DefaultLocale"})
  final class b
    implements QueueWorkerThread.ThreadObject
  {
    boolean bqe;
    public String lAO;
    String lAP;
    public boolean lAQ;
    private f.a lAS;
    public j lAv;
    
    public b(j paramj)
    {
      AppMethodBeat.i(150271);
      this.lAv = null;
      this.lAO = null;
      this.lAQ = true;
      this.bqe = false;
      this.lAv = paramj;
      q.bhz();
      this.lAO = f.N(paramj.getUsername(), true);
      this.lAP = (this.lAO + ".tmp");
      this.lAS = new f.a();
      AppMethodBeat.o(150271);
    }
    
    /* Error */
    public final boolean doInBackground()
    {
      // Byte code:
      //   0: ldc 92
      //   2: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 40	com/tencent/mm/am/g$b:lAv	Lcom/tencent/mm/am/j;
      //   9: ifnonnull +10 -> 19
      //   12: ldc 92
      //   14: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   17: iconst_0
      //   18: ireturn
      //   19: aload_0
      //   20: getfield 40	com/tencent/mm/am/g$b:lAv	Lcom/tencent/mm/am/j;
      //   23: invokevirtual 95	com/tencent/mm/am/j:bhH	()Ljava/lang/String;
      //   26: astore 6
      //   28: ldc 97
      //   30: invokestatic 103	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
      //   33: checkcast 97	com/tencent/mm/plugin/emoji/b/c
      //   36: invokeinterface 106 1 0
      //   41: istore_3
      //   42: ldc 108
      //   44: invokestatic 103	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
      //   47: checkcast 108	com/tencent/mm/plugin/expt/b/b
      //   50: getstatic 114	com/tencent/mm/plugin/expt/b/b$a:vFu	Lcom/tencent/mm/plugin/expt/b/b$a;
      //   53: iconst_0
      //   54: invokeinterface 118 3 0
      //   59: istore 4
      //   61: aload_0
      //   62: getfield 28	com/tencent/mm/am/g$b:lAR	Lcom/tencent/mm/am/g;
      //   65: invokestatic 121	com/tencent/mm/am/g:a	(Lcom/tencent/mm/am/g;)Z
      //   68: ifeq +1110 -> 1178
      //   71: iload_3
      //   72: ifeq +1106 -> 1178
      //   75: iload 4
      //   77: ifeq +1101 -> 1178
      //   80: ldc 123
      //   82: ldc 125
      //   84: invokestatic 130	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   87: aload 6
      //   89: ldc 132
      //   91: invokevirtual 138	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
      //   94: ifeq +321 -> 415
      //   97: new 66	java/lang/StringBuilder
      //   100: dup
      //   101: invokespecial 67	java/lang/StringBuilder:<init>	()V
      //   104: aload 6
      //   106: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   109: ldc 140
      //   111: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   114: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   117: astore 5
      //   119: getstatic 146	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
      //   122: sipush 138
      //   125: bipush 60
      //   127: invokevirtual 150	com/tencent/mm/plugin/report/service/h:el	(II)V
      //   130: aload 5
      //   132: astore 6
      //   134: invokestatic 154	com/tencent/mm/kernel/h:aHE	()Lcom/tencent/mm/kernel/b;
      //   137: invokevirtual 159	com/tencent/mm/kernel/b:aGM	()Z
      //   140: ifeq +1030 -> 1170
      //   143: new 66	java/lang/StringBuilder
      //   146: dup
      //   147: ldc 161
      //   149: invokespecial 164	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   152: getstatic 170	com/tencent/mm/plugin/comm/c$h:host_weixin_qq_com	I
      //   155: invokestatic 176	com/tencent/mm/sdk/platformtools/WeChatHosts:domainString	(I)Ljava/lang/String;
      //   158: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   161: ldc 178
      //   163: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   166: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   169: astore 5
      //   171: getstatic 183	com/tencent/mm/protocal/d:RAD	I
      //   174: istore_1
      //   175: invokestatic 154	com/tencent/mm/kernel/h:aHE	()Lcom/tencent/mm/kernel/b;
      //   178: pop
      //   179: aload 5
      //   181: iconst_4
      //   182: anewarray 4	java/lang/Object
      //   185: dup
      //   186: iconst_0
      //   187: iload_1
      //   188: invokestatic 189	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   191: aastore
      //   192: dup
      //   193: iconst_1
      //   194: invokestatic 193	com/tencent/mm/kernel/b:getUin	()I
      //   197: invokestatic 198	com/tencent/mm/b/p:getString	(I)Ljava/lang/String;
      //   200: aastore
      //   201: dup
      //   202: iconst_2
      //   203: invokestatic 204	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
      //   206: invokestatic 210	com/tencent/mm/sdk/platformtools/NetStatusUtil:getNetTypeForStat	(Landroid/content/Context;)I
      //   209: invokestatic 189	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   212: aastore
      //   213: dup
      //   214: iconst_3
      //   215: getstatic 216	com/tencent/mm/sdk/platformtools/ConnectivityCompat:Companion	Lcom/tencent/mm/sdk/platformtools/ConnectivityCompat$Companion;
      //   218: invokevirtual 221	com/tencent/mm/sdk/platformtools/ConnectivityCompat$Companion:getCompatMixStrength	()I
      //   221: invokestatic 189	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   224: aastore
      //   225: invokestatic 225	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   228: astore 7
      //   230: ldc 123
      //   232: ldc 227
      //   234: iconst_3
      //   235: anewarray 4	java/lang/Object
      //   238: dup
      //   239: iconst_0
      //   240: aload_0
      //   241: getfield 40	com/tencent/mm/am/g$b:lAv	Lcom/tencent/mm/am/j;
      //   244: invokevirtual 58	com/tencent/mm/am/j:getUsername	()Ljava/lang/String;
      //   247: aastore
      //   248: dup
      //   249: iconst_1
      //   250: aload 7
      //   252: aastore
      //   253: dup
      //   254: iconst_2
      //   255: aload 6
      //   257: aastore
      //   258: invokestatic 231	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   261: aload_0
      //   262: iconst_1
      //   263: putfield 44	com/tencent/mm/am/g$b:lAQ	Z
      //   266: ldc 108
      //   268: invokestatic 103	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
      //   271: checkcast 108	com/tencent/mm/plugin/expt/b/b
      //   274: getstatic 234	com/tencent/mm/plugin/expt/b/b$a:vUw	Lcom/tencent/mm/plugin/expt/b/b$a;
      //   277: iconst_0
      //   278: invokeinterface 118 3 0
      //   283: ifeq +158 -> 441
      //   286: aload 6
      //   288: invokestatic 240	com/tencent/mm/network/d:Zq	(Ljava/lang/String;)Lcom/tencent/mm/network/z;
      //   291: astore 5
      //   293: ldc 108
      //   295: invokestatic 103	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
      //   298: checkcast 108	com/tencent/mm/plugin/expt/b/b
      //   301: getstatic 243	com/tencent/mm/plugin/expt/b/b$a:vXk	Lcom/tencent/mm/plugin/expt/b/b$a;
      //   304: iconst_0
      //   305: invokeinterface 118 3 0
      //   310: istore_3
      //   311: aload 5
      //   313: checkcast 245	com/tencent/mm/network/z
      //   316: iload_3
      //   317: putfield 248	com/tencent/mm/network/z:mvU	Z
      //   320: aload 5
      //   322: checkcast 245	com/tencent/mm/network/z
      //   325: sipush 1223
      //   328: putfield 251	com/tencent/mm/network/z:mvT	I
      //   331: aload 5
      //   333: astore 8
      //   335: aload 8
      //   337: ldc 253
      //   339: invokeinterface 258 2 0
      //   344: aload 8
      //   346: ldc_w 260
      //   349: aload 7
      //   351: invokeinterface 263 3 0
      //   356: aload 8
      //   358: sipush 5000
      //   361: invokeinterface 266 2 0
      //   366: aload 8
      //   368: sipush 5000
      //   371: invokeinterface 269 2 0
      //   376: aload 8
      //   378: invokestatic 272	com/tencent/mm/network/d:a	(Lcom/tencent/mm/network/y;)I
      //   381: ifeq +116 -> 497
      //   384: ldc 123
      //   386: ldc_w 274
      //   389: iconst_1
      //   390: anewarray 4	java/lang/Object
      //   393: dup
      //   394: iconst_0
      //   395: aload 6
      //   397: aastore
      //   398: invokestatic 277	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   401: aload 8
      //   403: invokeinterface 280 1 0
      //   408: ldc 92
      //   410: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   413: iconst_1
      //   414: ireturn
      //   415: new 66	java/lang/StringBuilder
      //   418: dup
      //   419: invokespecial 67	java/lang/StringBuilder:<init>	()V
      //   422: aload 6
      //   424: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   427: ldc_w 282
      //   430: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   433: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   436: astore 5
      //   438: goto -319 -> 119
      //   441: aload 6
      //   443: aconst_null
      //   444: invokestatic 285	com/tencent/mm/network/d:a	(Ljava/lang/String;Lcom/tencent/mm/network/d$b;)Lcom/tencent/mm/network/x;
      //   447: astore 8
      //   449: goto -114 -> 335
      //   452: astore 5
      //   454: ldc 123
      //   456: ldc_w 287
      //   459: iconst_1
      //   460: anewarray 4	java/lang/Object
      //   463: dup
      //   464: iconst_0
      //   465: aload 5
      //   467: invokestatic 293	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   470: aastore
      //   471: invokestatic 277	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   474: ldc 123
      //   476: ldc_w 295
      //   479: iconst_1
      //   480: anewarray 4	java/lang/Object
      //   483: dup
      //   484: iconst_0
      //   485: aload 5
      //   487: invokevirtual 298	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   490: aastore
      //   491: invokestatic 277	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   494: goto -86 -> 408
      //   497: aload 8
      //   499: ldc_w 300
      //   502: iconst_0
      //   503: invokeinterface 304 3 0
      //   508: iconst_1
      //   509: if_icmpne +65 -> 574
      //   512: iconst_1
      //   513: istore_3
      //   514: aload_0
      //   515: iload_3
      //   516: putfield 46	com/tencent/mm/am/g$b:bqe	Z
      //   519: aload 8
      //   521: invokeinterface 308 1 0
      //   526: astore 5
      //   528: aload 5
      //   530: ifnonnull +94 -> 624
      //   533: ldc 123
      //   535: ldc_w 310
      //   538: iconst_1
      //   539: anewarray 4	java/lang/Object
      //   542: dup
      //   543: iconst_0
      //   544: aload 6
      //   546: aastore
      //   547: invokestatic 231	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   550: aload 8
      //   552: invokeinterface 280 1 0
      //   557: aload 5
      //   559: ifnull +8 -> 567
      //   562: aload 5
      //   564: invokevirtual 315	java/io/InputStream:close	()V
      //   567: ldc 92
      //   569: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   572: iconst_1
      //   573: ireturn
      //   574: iconst_0
      //   575: istore_3
      //   576: goto -62 -> 514
      //   579: astore 5
      //   581: ldc 123
      //   583: ldc_w 287
      //   586: iconst_1
      //   587: anewarray 4	java/lang/Object
      //   590: dup
      //   591: iconst_0
      //   592: aload 5
      //   594: invokestatic 293	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   597: aastore
      //   598: invokestatic 277	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   601: ldc 123
      //   603: ldc_w 295
      //   606: iconst_1
      //   607: anewarray 4	java/lang/Object
      //   610: dup
      //   611: iconst_0
      //   612: aload 5
      //   614: invokevirtual 298	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   617: aastore
      //   618: invokestatic 277	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   621: goto -54 -> 567
      //   624: sipush 1024
      //   627: newarray byte
      //   629: astore 7
      //   631: aload_0
      //   632: getfield 78	com/tencent/mm/am/g$b:lAP	Ljava/lang/String;
      //   635: invokestatic 321	com/tencent/mm/vfs/u:Te	(Ljava/lang/String;)Ljava/io/OutputStream;
      //   638: astore 6
      //   640: iconst_0
      //   641: istore_1
      //   642: aload 5
      //   644: aload 7
      //   646: invokevirtual 325	java/io/InputStream:read	([B)I
      //   649: istore_2
      //   650: iload_2
      //   651: iconst_m1
      //   652: if_icmpeq +19 -> 671
      //   655: aload 6
      //   657: aload 7
      //   659: iconst_0
      //   660: iload_2
      //   661: invokevirtual 331	java/io/OutputStream:write	([BII)V
      //   664: iload_1
      //   665: iload_2
      //   666: iadd
      //   667: istore_1
      //   668: goto -26 -> 642
      //   671: iload_1
      //   672: aload 8
      //   674: ldc_w 333
      //   677: aload 8
      //   679: invokeinterface 336 1 0
      //   684: invokeinterface 304 3 0
      //   689: if_icmpne +42 -> 731
      //   692: aload_0
      //   693: iconst_0
      //   694: putfield 44	com/tencent/mm/am/g$b:lAQ	Z
      //   697: aload 8
      //   699: invokeinterface 280 1 0
      //   704: aload 5
      //   706: ifnull +8 -> 714
      //   709: aload 5
      //   711: invokevirtual 315	java/io/InputStream:close	()V
      //   714: aload 6
      //   716: ifnull +8 -> 724
      //   719: aload 6
      //   721: invokevirtual 337	java/io/OutputStream:close	()V
      //   724: ldc 92
      //   726: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   729: iconst_1
      //   730: ireturn
      //   731: ldc 123
      //   733: ldc_w 339
      //   736: iconst_3
      //   737: anewarray 4	java/lang/Object
      //   740: dup
      //   741: iconst_0
      //   742: iload_1
      //   743: invokestatic 189	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   746: aastore
      //   747: dup
      //   748: iconst_1
      //   749: aload 8
      //   751: ldc_w 333
      //   754: invokeinterface 343 2 0
      //   759: aastore
      //   760: dup
      //   761: iconst_2
      //   762: aload 8
      //   764: invokeinterface 336 1 0
      //   769: invokestatic 189	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   772: aastore
      //   773: invokestatic 277	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   776: goto -79 -> 697
      //   779: astore 9
      //   781: aload 6
      //   783: astore 7
      //   785: aload 5
      //   787: astore 6
      //   789: aload 9
      //   791: astore 5
      //   793: ldc 123
      //   795: ldc_w 287
      //   798: iconst_1
      //   799: anewarray 4	java/lang/Object
      //   802: dup
      //   803: iconst_0
      //   804: aload 5
      //   806: invokestatic 293	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   809: aastore
      //   810: invokestatic 277	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   813: aload 8
      //   815: ifnull +10 -> 825
      //   818: aload 8
      //   820: invokeinterface 280 1 0
      //   825: aload 6
      //   827: ifnull +8 -> 835
      //   830: aload 6
      //   832: invokevirtual 315	java/io/InputStream:close	()V
      //   835: aload 7
      //   837: ifnull -113 -> 724
      //   840: aload 7
      //   842: invokevirtual 337	java/io/OutputStream:close	()V
      //   845: goto -121 -> 724
      //   848: astore 5
      //   850: ldc 123
      //   852: ldc_w 287
      //   855: iconst_1
      //   856: anewarray 4	java/lang/Object
      //   859: dup
      //   860: iconst_0
      //   861: aload 5
      //   863: invokestatic 293	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   866: aastore
      //   867: invokestatic 277	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   870: ldc 123
      //   872: ldc_w 295
      //   875: iconst_1
      //   876: anewarray 4	java/lang/Object
      //   879: dup
      //   880: iconst_0
      //   881: aload 5
      //   883: invokevirtual 298	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   886: aastore
      //   887: invokestatic 277	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   890: goto -166 -> 724
      //   893: astore 5
      //   895: ldc 123
      //   897: ldc_w 287
      //   900: iconst_1
      //   901: anewarray 4	java/lang/Object
      //   904: dup
      //   905: iconst_0
      //   906: aload 5
      //   908: invokestatic 293	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   911: aastore
      //   912: invokestatic 277	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   915: ldc 123
      //   917: ldc_w 295
      //   920: iconst_1
      //   921: anewarray 4	java/lang/Object
      //   924: dup
      //   925: iconst_0
      //   926: aload 5
      //   928: invokevirtual 298	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   931: aastore
      //   932: invokestatic 277	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   935: goto -211 -> 724
      //   938: astore 5
      //   940: aconst_null
      //   941: astore 6
      //   943: aconst_null
      //   944: astore 7
      //   946: aconst_null
      //   947: astore 8
      //   949: aload 8
      //   951: ifnull +10 -> 961
      //   954: aload 8
      //   956: invokeinterface 280 1 0
      //   961: aload 6
      //   963: ifnull +8 -> 971
      //   966: aload 6
      //   968: invokevirtual 315	java/io/InputStream:close	()V
      //   971: aload 7
      //   973: ifnull +8 -> 981
      //   976: aload 7
      //   978: invokevirtual 337	java/io/OutputStream:close	()V
      //   981: ldc 92
      //   983: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   986: aload 5
      //   988: athrow
      //   989: astore 6
      //   991: ldc 123
      //   993: ldc_w 287
      //   996: iconst_1
      //   997: anewarray 4	java/lang/Object
      //   1000: dup
      //   1001: iconst_0
      //   1002: aload 6
      //   1004: invokestatic 293	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   1007: aastore
      //   1008: invokestatic 277	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1011: ldc 123
      //   1013: ldc_w 295
      //   1016: iconst_1
      //   1017: anewarray 4	java/lang/Object
      //   1020: dup
      //   1021: iconst_0
      //   1022: aload 6
      //   1024: invokevirtual 298	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   1027: aastore
      //   1028: invokestatic 277	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1031: goto -50 -> 981
      //   1034: astore 9
      //   1036: aconst_null
      //   1037: astore 6
      //   1039: aconst_null
      //   1040: astore 7
      //   1042: aload 5
      //   1044: astore 8
      //   1046: aload 9
      //   1048: astore 5
      //   1050: goto -101 -> 949
      //   1053: astore 5
      //   1055: aconst_null
      //   1056: astore 6
      //   1058: aconst_null
      //   1059: astore 7
      //   1061: goto -112 -> 949
      //   1064: astore 9
      //   1066: aload 5
      //   1068: astore 6
      //   1070: aconst_null
      //   1071: astore 7
      //   1073: aload 9
      //   1075: astore 5
      //   1077: goto -128 -> 949
      //   1080: astore 10
      //   1082: aload 5
      //   1084: astore 7
      //   1086: aload 6
      //   1088: astore 9
      //   1090: aload 10
      //   1092: astore 5
      //   1094: aload 7
      //   1096: astore 6
      //   1098: aload 9
      //   1100: astore 7
      //   1102: goto -153 -> 949
      //   1105: astore 5
      //   1107: goto -158 -> 949
      //   1110: astore 5
      //   1112: aconst_null
      //   1113: astore 6
      //   1115: aconst_null
      //   1116: astore 7
      //   1118: aconst_null
      //   1119: astore 8
      //   1121: goto -328 -> 793
      //   1124: astore 9
      //   1126: aconst_null
      //   1127: astore 6
      //   1129: aconst_null
      //   1130: astore 7
      //   1132: aload 5
      //   1134: astore 8
      //   1136: aload 9
      //   1138: astore 5
      //   1140: goto -347 -> 793
      //   1143: astore 5
      //   1145: aconst_null
      //   1146: astore 6
      //   1148: aconst_null
      //   1149: astore 7
      //   1151: goto -358 -> 793
      //   1154: astore 9
      //   1156: aload 5
      //   1158: astore 6
      //   1160: aconst_null
      //   1161: astore 7
      //   1163: aload 9
      //   1165: astore 5
      //   1167: goto -374 -> 793
      //   1170: ldc_w 345
      //   1173: astore 7
      //   1175: goto -945 -> 230
      //   1178: goto -1044 -> 134
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1181	0	this	b
      //   174	569	1	i	int
      //   649	18	2	j	int
      //   41	535	3	bool1	boolean
      //   59	17	4	bool2	boolean
      //   117	320	5	localObject1	Object
      //   452	34	5	localException1	java.lang.Exception
      //   526	37	5	localInputStream	java.io.InputStream
      //   579	207	5	localException2	java.lang.Exception
      //   791	14	5	localObject2	Object
      //   848	34	5	localException3	java.lang.Exception
      //   893	34	5	localException4	java.lang.Exception
      //   938	105	5	localObject3	Object
      //   1048	1	5	localObject4	Object
      //   1053	14	5	localObject5	Object
      //   1075	18	5	localObject6	Object
      //   1105	1	5	localObject7	Object
      //   1110	23	5	localException5	java.lang.Exception
      //   1138	1	5	localObject8	Object
      //   1143	14	5	localException6	java.lang.Exception
      //   1165	1	5	localObject9	Object
      //   26	941	6	localObject10	Object
      //   989	34	6	localException7	java.lang.Exception
      //   1037	122	6	localObject11	Object
      //   228	946	7	localObject12	Object
      //   333	802	8	localObject13	Object
      //   779	11	9	localException8	java.lang.Exception
      //   1034	13	9	localObject14	Object
      //   1064	10	9	localObject15	Object
      //   1088	11	9	localObject16	Object
      //   1124	13	9	localException9	java.lang.Exception
      //   1154	10	9	localException10	java.lang.Exception
      //   1080	11	10	localObject17	Object
      // Exception table:
      //   from	to	target	type
      //   401	408	452	java/lang/Exception
      //   550	557	579	java/lang/Exception
      //   562	567	579	java/lang/Exception
      //   642	650	779	java/lang/Exception
      //   655	664	779	java/lang/Exception
      //   671	697	779	java/lang/Exception
      //   731	776	779	java/lang/Exception
      //   818	825	848	java/lang/Exception
      //   830	835	848	java/lang/Exception
      //   840	845	848	java/lang/Exception
      //   697	704	893	java/lang/Exception
      //   709	714	893	java/lang/Exception
      //   719	724	893	java/lang/Exception
      //   266	293	938	finally
      //   441	449	938	finally
      //   954	961	989	java/lang/Exception
      //   966	971	989	java/lang/Exception
      //   976	981	989	java/lang/Exception
      //   293	331	1034	finally
      //   335	401	1053	finally
      //   497	512	1053	finally
      //   514	528	1053	finally
      //   533	550	1064	finally
      //   624	640	1064	finally
      //   642	650	1080	finally
      //   655	664	1080	finally
      //   671	697	1080	finally
      //   731	776	1080	finally
      //   793	813	1105	finally
      //   266	293	1110	java/lang/Exception
      //   441	449	1110	java/lang/Exception
      //   293	331	1124	java/lang/Exception
      //   335	401	1143	java/lang/Exception
      //   497	512	1143	java/lang/Exception
      //   514	528	1143	java/lang/Exception
      //   533	550	1154	java/lang/Exception
      //   624	640	1154	java/lang/Exception
    }
    
    public final boolean onPostExecute()
    {
      AppMethodBeat.i(150273);
      if (g.this.lAK)
      {
        AppMethodBeat.o(150273);
        return false;
      }
      if ((this.lAQ) || (Util.isNullOrNil(this.lAO)))
      {
        g.this.lAI.dL(4, -1);
        AppMethodBeat.o(150273);
        return false;
      }
      Log.d("MicroMsg.GetHDHeadImgHelper", "dkavatar user:" + this.lAv.getUsername() + " urltime:" + this.lAS.avE());
      if (az.a.lts != null) {
        az.a.lts.dH((int)u.bBQ(this.lAP), 0);
      }
      g.b(g.this).add(new g.a(g.this, g.this.lAs, this.lAO, this.lAP));
      AppMethodBeat.o(150273);
      return true;
    }
  }
  
  public static abstract interface c
  {
    public abstract int dL(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.am.g
 * JD-Core Version:    0.7.0.1
 */