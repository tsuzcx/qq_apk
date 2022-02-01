package com.tencent.mm.aj;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.e;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.vfs.s;
import junit.framework.Assert;

public final class f
  implements com.tencent.mm.ak.i
{
  c iKC;
  l iKD;
  boolean iKE;
  boolean iKF;
  boolean iKG;
  QueueWorkerThread iKH;
  i iKn;
  
  public f()
  {
    AppMethodBeat.i(150274);
    this.iKn = null;
    this.iKC = null;
    this.iKD = null;
    this.iKE = false;
    this.iKF = true;
    this.iKG = true;
    this.iKH = null;
    g.azz().a(158, this);
    AppMethodBeat.o(150274);
  }
  
  private int a(i parami)
  {
    AppMethodBeat.i(150278);
    if ((this.iKH == null) || (this.iKH.isDead())) {
      this.iKH = new QueueWorkerThread(1, "get-hd-headimg", 1);
    }
    int i = this.iKH.add(new b(parami));
    AppMethodBeat.o(150278);
    return i;
  }
  
  public final int a(String paramString, c paramc)
  {
    AppMethodBeat.i(150276);
    Assert.assertTrue("GetHDHeadImg must set callback", true);
    if (Util.isNullOrNil(paramString))
    {
      paramc.dp(3, -101);
      AppMethodBeat.o(150276);
      return -101;
    }
    this.iKC = paramc;
    if (as.IG(paramString)) {}
    for (String str = as.bjz(paramString);; str = paramString)
    {
      this.iKn = p.aYB().Mx(str);
      Log.d("MicroMsg.GetHDHeadImgHelper", "GetHDHeadImg: %s", new Object[] { str });
      if ((this.iKn == null) || (!this.iKn.getUsername().equals(str)))
      {
        this.iKn = new i();
        this.iKn.username = str;
      }
      if (Util.isNullOrNil(this.iKn.aYt()))
      {
        Log.w("MicroMsg.GetHDHeadImgHelper", "dkhurl [%s] has NO URL flag:%d !", new Object[] { paramString, Integer.valueOf(this.iKn.fuz) });
        this.iKD = new l(str);
        if (!g.azz().a(this.iKD, 0))
        {
          paramc.dp(3, -102);
          AppMethodBeat.o(150276);
          return -102;
        }
        AppMethodBeat.o(150276);
        return 0;
      }
      if (a(this.iKn) == 0)
      {
        AppMethodBeat.o(150276);
        return 0;
      }
      paramc.dp(3, -103);
      AppMethodBeat.o(150276);
      return -103;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(150277);
    this.iKC.dp(paramInt1, paramInt2);
    AppMethodBeat.o(150277);
  }
  
  public final void sQ()
  {
    AppMethodBeat.i(150275);
    g.azz().b(158, this);
    AppMethodBeat.o(150275);
  }
  
  final class a
    implements QueueWorkerThread.ThreadObject
  {
    boolean aGI = true;
    boolean bGA;
    String iKI;
    String iKJ;
    i iKn;
    boolean isHevc = false;
    
    public a(i parami, String paramString1, String paramString2)
    {
      this.iKn = parami;
      this.iKI = paramString1;
      this.iKJ = paramString2;
      this.bGA = false;
    }
    
    public final boolean doInBackground()
    {
      AppMethodBeat.i(150269);
      Object localObject;
      String str1;
      String str2;
      if (this.bGA)
      {
        h.CyF.dN(138, 61);
        Log.i("MicroMsg.GetHDHeadImgHelper", "DecryptAvatar: decrypt %s", new Object[] { this.iKJ });
        localObject = UtilsJni.DecryptAvatar(s.aW(this.iKJ, 0, -1));
        if ((localObject != null) && (localObject.length > 0))
        {
          s.deleteFile(this.iKJ);
          s.f(this.iKJ, (byte[])localObject, localObject.length);
        }
      }
      else
      {
        if (!ImgUtil.isWXGF(this.iKJ)) {
          break label334;
        }
        this.isHevc = true;
        Log.i("MicroMsg.GetHDHeadImgHelper", "DecryptAvatar: hevc to pic start");
        h.CyF.dN(138, 63);
        localObject = this.iKJ + "_hevc";
        boolean bool1 = s.nx(this.iKJ, (String)localObject);
        boolean bool2 = s.bpa(this.iKJ);
        str1 = s.k(this.iKJ, true);
        str2 = s.k((String)localObject, false);
        if ((str1 != null) && (str2 != null)) {
          break label281;
        }
        Log.i("MicroMsg.GetHDHeadImgHelper", "DecryptAvatar: uri is null %s, %s; path %s, %s; result %s, %s", new Object[] { str1, str2, this.iKJ, localObject, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        h.CyF.dN(138, 65);
        AppMethodBeat.o(150269);
        return true;
      }
      h.CyF.dN(138, 62);
      Log.i("MicroMsg.GetHDHeadImgHelper", "DecryptAvatar: decrypt failed");
      AppMethodBeat.o(150269);
      return true;
      label281:
      int i = ((c)g.af(c.class)).nativeWxam2Pic(str2, str1);
      s.deleteFile((String)localObject);
      if (i != 0)
      {
        h.CyF.dN(138, 64);
        Log.i("MicroMsg.GetHDHeadImgHelper", "DecryptAvatar: hevc to pic failed");
        AppMethodBeat.o(150269);
        return true;
      }
      label334:
      this.aGI = false;
      AppMethodBeat.o(150269);
      return true;
    }
    
    public final boolean onPostExecute()
    {
      AppMethodBeat.i(150270);
      if (f.this.iKE)
      {
        AppMethodBeat.o(150270);
        return false;
      }
      if (this.aGI)
      {
        if ((this.isHevc) && (f.this.iKF))
        {
          Log.i("MicroMsg.GetHDHeadImgHelper", "onPostExecute: first request hevc failed");
          f.this.iKF = false;
          f.this.iKG = false;
          f.this.iKH.add(new f.b(f.this, this.iKn));
        }
        for (;;)
        {
          AppMethodBeat.o(150270);
          return false;
          f.this.iKC.dp(3, -1);
        }
      }
      s.deleteFile(this.iKI);
      s.nx(this.iKJ, this.iKI);
      l.bc(this.iKI, this.iKn.getUsername());
      f.this.iKC.dp(0, 0);
      AppMethodBeat.o(150270);
      return true;
    }
  }
  
  @SuppressLint({"DefaultLocale"})
  final class b
    implements QueueWorkerThread.ThreadObject
  {
    public boolean aGI;
    boolean bGA;
    public String iKI;
    String iKJ;
    private com.tencent.mm.compatible.util.f.a iKL;
    public i iKq;
    
    public b(i parami)
    {
      AppMethodBeat.i(150271);
      this.iKq = null;
      this.iKI = null;
      this.aGI = true;
      this.bGA = false;
      this.iKq = parami;
      p.aYn();
      this.iKI = e.L(parami.getUsername(), true);
      this.iKJ = (this.iKI + ".tmp");
      this.iKL = new com.tencent.mm.compatible.util.f.a();
      AppMethodBeat.o(150271);
    }
    
    /* Error */
    public final boolean doInBackground()
    {
      // Byte code:
      //   0: ldc 92
      //   2: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 40	com/tencent/mm/aj/f$b:iKq	Lcom/tencent/mm/aj/i;
      //   9: ifnonnull +10 -> 19
      //   12: ldc 92
      //   14: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   17: iconst_0
      //   18: ireturn
      //   19: aload_0
      //   20: getfield 40	com/tencent/mm/aj/f$b:iKq	Lcom/tencent/mm/aj/i;
      //   23: invokevirtual 95	com/tencent/mm/aj/i:aYt	()Ljava/lang/String;
      //   26: astore 6
      //   28: ldc 97
      //   30: invokestatic 103	com/tencent/mm/kernel/g:af	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
      //   33: checkcast 97	com/tencent/mm/plugin/emoji/b/c
      //   36: invokeinterface 106 1 0
      //   41: istore_3
      //   42: ldc 108
      //   44: invokestatic 103	com/tencent/mm/kernel/g:af	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
      //   47: checkcast 108	com/tencent/mm/plugin/expt/b/b
      //   50: getstatic 114	com/tencent/mm/plugin/expt/b/b$a:rYw	Lcom/tencent/mm/plugin/expt/b/b$a;
      //   53: iconst_0
      //   54: invokeinterface 118 3 0
      //   59: istore 4
      //   61: aload_0
      //   62: getfield 28	com/tencent/mm/aj/f$b:iKK	Lcom/tencent/mm/aj/f;
      //   65: getfield 121	com/tencent/mm/aj/f:iKG	Z
      //   68: ifeq +1109 -> 1177
      //   71: iload_3
      //   72: ifeq +1105 -> 1177
      //   75: iload 4
      //   77: ifeq +1100 -> 1177
      //   80: ldc 123
      //   82: ldc 125
      //   84: invokestatic 130	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   87: aload 6
      //   89: ldc 132
      //   91: invokevirtual 138	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
      //   94: ifeq +319 -> 413
      //   97: new 66	java/lang/StringBuilder
      //   100: dup
      //   101: invokespecial 67	java/lang/StringBuilder:<init>	()V
      //   104: aload 6
      //   106: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   109: ldc 140
      //   111: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   114: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   117: astore 5
      //   119: getstatic 146	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
      //   122: sipush 138
      //   125: bipush 60
      //   127: invokevirtual 150	com/tencent/mm/plugin/report/service/h:dN	(II)V
      //   130: aload 5
      //   132: astore 6
      //   134: invokestatic 154	com/tencent/mm/kernel/g:aAf	()Lcom/tencent/mm/kernel/a;
      //   137: invokevirtual 159	com/tencent/mm/kernel/a:azp	()Z
      //   140: ifeq +1029 -> 1169
      //   143: new 66	java/lang/StringBuilder
      //   146: dup
      //   147: ldc 161
      //   149: invokespecial 164	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   152: ldc 165
      //   154: invokestatic 171	com/tencent/mm/sdk/platformtools/WeChatHosts:domainString	(I)Ljava/lang/String;
      //   157: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   160: ldc 173
      //   162: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   165: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   168: astore 5
      //   170: getstatic 179	com/tencent/mm/protocal/d:KyO	I
      //   173: istore_1
      //   174: invokestatic 154	com/tencent/mm/kernel/g:aAf	()Lcom/tencent/mm/kernel/a;
      //   177: pop
      //   178: aload 5
      //   180: iconst_4
      //   181: anewarray 4	java/lang/Object
      //   184: dup
      //   185: iconst_0
      //   186: iload_1
      //   187: invokestatic 185	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   190: aastore
      //   191: dup
      //   192: iconst_1
      //   193: invokestatic 189	com/tencent/mm/kernel/a:getUin	()I
      //   196: invokestatic 194	com/tencent/mm/b/p:getString	(I)Ljava/lang/String;
      //   199: aastore
      //   200: dup
      //   201: iconst_2
      //   202: invokestatic 200	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
      //   205: invokestatic 206	com/tencent/mm/sdk/platformtools/NetStatusUtil:getNetTypeForStat	(Landroid/content/Context;)I
      //   208: invokestatic 185	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   211: aastore
      //   212: dup
      //   213: iconst_3
      //   214: invokestatic 200	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
      //   217: invokestatic 209	com/tencent/mm/sdk/platformtools/NetStatusUtil:getStrength	(Landroid/content/Context;)I
      //   220: invokestatic 185	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   223: aastore
      //   224: invokestatic 213	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   227: astore 7
      //   229: ldc 123
      //   231: ldc 215
      //   233: iconst_3
      //   234: anewarray 4	java/lang/Object
      //   237: dup
      //   238: iconst_0
      //   239: aload_0
      //   240: getfield 40	com/tencent/mm/aj/f$b:iKq	Lcom/tencent/mm/aj/i;
      //   243: invokevirtual 58	com/tencent/mm/aj/i:getUsername	()Ljava/lang/String;
      //   246: aastore
      //   247: dup
      //   248: iconst_1
      //   249: aload 7
      //   251: aastore
      //   252: dup
      //   253: iconst_2
      //   254: aload 6
      //   256: aastore
      //   257: invokestatic 219	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   260: aload_0
      //   261: iconst_1
      //   262: putfield 44	com/tencent/mm/aj/f$b:aGI	Z
      //   265: ldc 108
      //   267: invokestatic 103	com/tencent/mm/kernel/g:af	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
      //   270: checkcast 108	com/tencent/mm/plugin/expt/b/b
      //   273: getstatic 222	com/tencent/mm/plugin/expt/b/b$a:skc	Lcom/tencent/mm/plugin/expt/b/b$a;
      //   276: iconst_0
      //   277: invokeinterface 118 3 0
      //   282: ifeq +157 -> 439
      //   285: aload 6
      //   287: invokestatic 228	com/tencent/mm/network/d:RQ	(Ljava/lang/String;)Lcom/tencent/mm/network/z;
      //   290: astore 5
      //   292: ldc 108
      //   294: invokestatic 103	com/tencent/mm/kernel/g:af	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
      //   297: checkcast 108	com/tencent/mm/plugin/expt/b/b
      //   300: getstatic 231	com/tencent/mm/plugin/expt/b/b$a:smr	Lcom/tencent/mm/plugin/expt/b/b$a;
      //   303: iconst_0
      //   304: invokeinterface 118 3 0
      //   309: istore_3
      //   310: aload 5
      //   312: checkcast 233	com/tencent/mm/network/z
      //   315: iload_3
      //   316: putfield 236	com/tencent/mm/network/z:jFr	Z
      //   319: aload 5
      //   321: checkcast 233	com/tencent/mm/network/z
      //   324: sipush 1223
      //   327: putfield 239	com/tencent/mm/network/z:jFq	I
      //   330: aload 5
      //   332: astore 8
      //   334: aload 8
      //   336: ldc 241
      //   338: invokeinterface 246 2 0
      //   343: aload 8
      //   345: ldc 248
      //   347: aload 7
      //   349: invokeinterface 251 3 0
      //   354: aload 8
      //   356: sipush 5000
      //   359: invokeinterface 254 2 0
      //   364: aload 8
      //   366: sipush 5000
      //   369: invokeinterface 257 2 0
      //   374: aload 8
      //   376: invokestatic 260	com/tencent/mm/network/d:a	(Lcom/tencent/mm/network/y;)I
      //   379: ifeq +116 -> 495
      //   382: ldc 123
      //   384: ldc_w 262
      //   387: iconst_1
      //   388: anewarray 4	java/lang/Object
      //   391: dup
      //   392: iconst_0
      //   393: aload 6
      //   395: aastore
      //   396: invokestatic 265	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   399: aload 8
      //   401: invokeinterface 268 1 0
      //   406: ldc 92
      //   408: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   411: iconst_1
      //   412: ireturn
      //   413: new 66	java/lang/StringBuilder
      //   416: dup
      //   417: invokespecial 67	java/lang/StringBuilder:<init>	()V
      //   420: aload 6
      //   422: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   425: ldc_w 270
      //   428: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   431: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   434: astore 5
      //   436: goto -317 -> 119
      //   439: aload 6
      //   441: aconst_null
      //   442: invokestatic 273	com/tencent/mm/network/d:a	(Ljava/lang/String;Lcom/tencent/mm/network/d$b;)Lcom/tencent/mm/network/x;
      //   445: astore 8
      //   447: goto -113 -> 334
      //   450: astore 5
      //   452: ldc 123
      //   454: ldc_w 275
      //   457: iconst_1
      //   458: anewarray 4	java/lang/Object
      //   461: dup
      //   462: iconst_0
      //   463: aload 5
      //   465: invokestatic 281	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   468: aastore
      //   469: invokestatic 265	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   472: ldc 123
      //   474: ldc_w 283
      //   477: iconst_1
      //   478: anewarray 4	java/lang/Object
      //   481: dup
      //   482: iconst_0
      //   483: aload 5
      //   485: invokevirtual 286	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   488: aastore
      //   489: invokestatic 265	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   492: goto -86 -> 406
      //   495: aload 8
      //   497: ldc_w 288
      //   500: iconst_0
      //   501: invokeinterface 292 3 0
      //   506: iconst_1
      //   507: if_icmpne +65 -> 572
      //   510: iconst_1
      //   511: istore_3
      //   512: aload_0
      //   513: iload_3
      //   514: putfield 46	com/tencent/mm/aj/f$b:bGA	Z
      //   517: aload 8
      //   519: invokeinterface 296 1 0
      //   524: astore 5
      //   526: aload 5
      //   528: ifnonnull +94 -> 622
      //   531: ldc 123
      //   533: ldc_w 298
      //   536: iconst_1
      //   537: anewarray 4	java/lang/Object
      //   540: dup
      //   541: iconst_0
      //   542: aload 6
      //   544: aastore
      //   545: invokestatic 219	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   548: aload 8
      //   550: invokeinterface 268 1 0
      //   555: aload 5
      //   557: ifnull +8 -> 565
      //   560: aload 5
      //   562: invokevirtual 303	java/io/InputStream:close	()V
      //   565: ldc 92
      //   567: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   570: iconst_1
      //   571: ireturn
      //   572: iconst_0
      //   573: istore_3
      //   574: goto -62 -> 512
      //   577: astore 5
      //   579: ldc 123
      //   581: ldc_w 275
      //   584: iconst_1
      //   585: anewarray 4	java/lang/Object
      //   588: dup
      //   589: iconst_0
      //   590: aload 5
      //   592: invokestatic 281	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   595: aastore
      //   596: invokestatic 265	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   599: ldc 123
      //   601: ldc_w 283
      //   604: iconst_1
      //   605: anewarray 4	java/lang/Object
      //   608: dup
      //   609: iconst_0
      //   610: aload 5
      //   612: invokevirtual 286	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   615: aastore
      //   616: invokestatic 265	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   619: goto -54 -> 565
      //   622: sipush 1024
      //   625: newarray byte
      //   627: astore 7
      //   629: aload_0
      //   630: getfield 78	com/tencent/mm/aj/f$b:iKJ	Ljava/lang/String;
      //   633: iconst_0
      //   634: invokestatic 309	com/tencent/mm/vfs/s:dw	(Ljava/lang/String;Z)Ljava/io/OutputStream;
      //   637: astore 6
      //   639: iconst_0
      //   640: istore_1
      //   641: aload 5
      //   643: aload 7
      //   645: invokevirtual 313	java/io/InputStream:read	([B)I
      //   648: istore_2
      //   649: iload_2
      //   650: iconst_m1
      //   651: if_icmpeq +19 -> 670
      //   654: aload 6
      //   656: aload 7
      //   658: iconst_0
      //   659: iload_2
      //   660: invokevirtual 319	java/io/OutputStream:write	([BII)V
      //   663: iload_1
      //   664: iload_2
      //   665: iadd
      //   666: istore_1
      //   667: goto -26 -> 641
      //   670: iload_1
      //   671: aload 8
      //   673: ldc_w 321
      //   676: aload 8
      //   678: invokeinterface 324 1 0
      //   683: invokeinterface 292 3 0
      //   688: if_icmpne +42 -> 730
      //   691: aload_0
      //   692: iconst_0
      //   693: putfield 44	com/tencent/mm/aj/f$b:aGI	Z
      //   696: aload 8
      //   698: invokeinterface 268 1 0
      //   703: aload 5
      //   705: ifnull +8 -> 713
      //   708: aload 5
      //   710: invokevirtual 303	java/io/InputStream:close	()V
      //   713: aload 6
      //   715: ifnull +8 -> 723
      //   718: aload 6
      //   720: invokevirtual 325	java/io/OutputStream:close	()V
      //   723: ldc 92
      //   725: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   728: iconst_1
      //   729: ireturn
      //   730: ldc 123
      //   732: ldc_w 327
      //   735: iconst_3
      //   736: anewarray 4	java/lang/Object
      //   739: dup
      //   740: iconst_0
      //   741: iload_1
      //   742: invokestatic 185	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   745: aastore
      //   746: dup
      //   747: iconst_1
      //   748: aload 8
      //   750: ldc_w 321
      //   753: invokeinterface 331 2 0
      //   758: aastore
      //   759: dup
      //   760: iconst_2
      //   761: aload 8
      //   763: invokeinterface 324 1 0
      //   768: invokestatic 185	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   771: aastore
      //   772: invokestatic 265	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   775: goto -79 -> 696
      //   778: astore 9
      //   780: aload 6
      //   782: astore 7
      //   784: aload 5
      //   786: astore 6
      //   788: aload 9
      //   790: astore 5
      //   792: ldc 123
      //   794: ldc_w 275
      //   797: iconst_1
      //   798: anewarray 4	java/lang/Object
      //   801: dup
      //   802: iconst_0
      //   803: aload 5
      //   805: invokestatic 281	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   808: aastore
      //   809: invokestatic 265	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   812: aload 8
      //   814: ifnull +10 -> 824
      //   817: aload 8
      //   819: invokeinterface 268 1 0
      //   824: aload 6
      //   826: ifnull +8 -> 834
      //   829: aload 6
      //   831: invokevirtual 303	java/io/InputStream:close	()V
      //   834: aload 7
      //   836: ifnull -113 -> 723
      //   839: aload 7
      //   841: invokevirtual 325	java/io/OutputStream:close	()V
      //   844: goto -121 -> 723
      //   847: astore 5
      //   849: ldc 123
      //   851: ldc_w 275
      //   854: iconst_1
      //   855: anewarray 4	java/lang/Object
      //   858: dup
      //   859: iconst_0
      //   860: aload 5
      //   862: invokestatic 281	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   865: aastore
      //   866: invokestatic 265	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   869: ldc 123
      //   871: ldc_w 283
      //   874: iconst_1
      //   875: anewarray 4	java/lang/Object
      //   878: dup
      //   879: iconst_0
      //   880: aload 5
      //   882: invokevirtual 286	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   885: aastore
      //   886: invokestatic 265	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   889: goto -166 -> 723
      //   892: astore 5
      //   894: ldc 123
      //   896: ldc_w 275
      //   899: iconst_1
      //   900: anewarray 4	java/lang/Object
      //   903: dup
      //   904: iconst_0
      //   905: aload 5
      //   907: invokestatic 281	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   910: aastore
      //   911: invokestatic 265	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   914: ldc 123
      //   916: ldc_w 283
      //   919: iconst_1
      //   920: anewarray 4	java/lang/Object
      //   923: dup
      //   924: iconst_0
      //   925: aload 5
      //   927: invokevirtual 286	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   930: aastore
      //   931: invokestatic 265	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   934: goto -211 -> 723
      //   937: astore 5
      //   939: aconst_null
      //   940: astore 6
      //   942: aconst_null
      //   943: astore 7
      //   945: aconst_null
      //   946: astore 8
      //   948: aload 8
      //   950: ifnull +10 -> 960
      //   953: aload 8
      //   955: invokeinterface 268 1 0
      //   960: aload 6
      //   962: ifnull +8 -> 970
      //   965: aload 6
      //   967: invokevirtual 303	java/io/InputStream:close	()V
      //   970: aload 7
      //   972: ifnull +8 -> 980
      //   975: aload 7
      //   977: invokevirtual 325	java/io/OutputStream:close	()V
      //   980: ldc 92
      //   982: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   985: aload 5
      //   987: athrow
      //   988: astore 6
      //   990: ldc 123
      //   992: ldc_w 275
      //   995: iconst_1
      //   996: anewarray 4	java/lang/Object
      //   999: dup
      //   1000: iconst_0
      //   1001: aload 6
      //   1003: invokestatic 281	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   1006: aastore
      //   1007: invokestatic 265	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1010: ldc 123
      //   1012: ldc_w 283
      //   1015: iconst_1
      //   1016: anewarray 4	java/lang/Object
      //   1019: dup
      //   1020: iconst_0
      //   1021: aload 6
      //   1023: invokevirtual 286	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   1026: aastore
      //   1027: invokestatic 265	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1030: goto -50 -> 980
      //   1033: astore 9
      //   1035: aconst_null
      //   1036: astore 6
      //   1038: aconst_null
      //   1039: astore 7
      //   1041: aload 5
      //   1043: astore 8
      //   1045: aload 9
      //   1047: astore 5
      //   1049: goto -101 -> 948
      //   1052: astore 5
      //   1054: aconst_null
      //   1055: astore 6
      //   1057: aconst_null
      //   1058: astore 7
      //   1060: goto -112 -> 948
      //   1063: astore 9
      //   1065: aload 5
      //   1067: astore 6
      //   1069: aconst_null
      //   1070: astore 7
      //   1072: aload 9
      //   1074: astore 5
      //   1076: goto -128 -> 948
      //   1079: astore 10
      //   1081: aload 5
      //   1083: astore 7
      //   1085: aload 6
      //   1087: astore 9
      //   1089: aload 10
      //   1091: astore 5
      //   1093: aload 7
      //   1095: astore 6
      //   1097: aload 9
      //   1099: astore 7
      //   1101: goto -153 -> 948
      //   1104: astore 5
      //   1106: goto -158 -> 948
      //   1109: astore 5
      //   1111: aconst_null
      //   1112: astore 6
      //   1114: aconst_null
      //   1115: astore 7
      //   1117: aconst_null
      //   1118: astore 8
      //   1120: goto -328 -> 792
      //   1123: astore 9
      //   1125: aconst_null
      //   1126: astore 6
      //   1128: aconst_null
      //   1129: astore 7
      //   1131: aload 5
      //   1133: astore 8
      //   1135: aload 9
      //   1137: astore 5
      //   1139: goto -347 -> 792
      //   1142: astore 5
      //   1144: aconst_null
      //   1145: astore 6
      //   1147: aconst_null
      //   1148: astore 7
      //   1150: goto -358 -> 792
      //   1153: astore 9
      //   1155: aload 5
      //   1157: astore 6
      //   1159: aconst_null
      //   1160: astore 7
      //   1162: aload 9
      //   1164: astore 5
      //   1166: goto -374 -> 792
      //   1169: ldc_w 333
      //   1172: astore 7
      //   1174: goto -945 -> 229
      //   1177: goto -1043 -> 134
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1180	0	this	b
      //   173	569	1	i	int
      //   648	18	2	j	int
      //   41	533	3	bool1	boolean
      //   59	17	4	bool2	boolean
      //   117	318	5	localObject1	Object
      //   450	34	5	localException1	java.lang.Exception
      //   524	37	5	localInputStream	java.io.InputStream
      //   577	208	5	localException2	java.lang.Exception
      //   790	14	5	localObject2	Object
      //   847	34	5	localException3	java.lang.Exception
      //   892	34	5	localException4	java.lang.Exception
      //   937	105	5	localObject3	Object
      //   1047	1	5	localObject4	Object
      //   1052	14	5	localObject5	Object
      //   1074	18	5	localObject6	Object
      //   1104	1	5	localObject7	Object
      //   1109	23	5	localException5	java.lang.Exception
      //   1137	1	5	localObject8	Object
      //   1142	14	5	localException6	java.lang.Exception
      //   1164	1	5	localObject9	Object
      //   26	940	6	localObject10	Object
      //   988	34	6	localException7	java.lang.Exception
      //   1036	122	6	localObject11	Object
      //   227	946	7	localObject12	Object
      //   332	802	8	localObject13	Object
      //   778	11	9	localException8	java.lang.Exception
      //   1033	13	9	localObject14	Object
      //   1063	10	9	localObject15	Object
      //   1087	11	9	localObject16	Object
      //   1123	13	9	localException9	java.lang.Exception
      //   1153	10	9	localException10	java.lang.Exception
      //   1079	11	10	localObject17	Object
      // Exception table:
      //   from	to	target	type
      //   399	406	450	java/lang/Exception
      //   548	555	577	java/lang/Exception
      //   560	565	577	java/lang/Exception
      //   641	649	778	java/lang/Exception
      //   654	663	778	java/lang/Exception
      //   670	696	778	java/lang/Exception
      //   730	775	778	java/lang/Exception
      //   817	824	847	java/lang/Exception
      //   829	834	847	java/lang/Exception
      //   839	844	847	java/lang/Exception
      //   696	703	892	java/lang/Exception
      //   708	713	892	java/lang/Exception
      //   718	723	892	java/lang/Exception
      //   265	292	937	finally
      //   439	447	937	finally
      //   953	960	988	java/lang/Exception
      //   965	970	988	java/lang/Exception
      //   975	980	988	java/lang/Exception
      //   292	330	1033	finally
      //   334	399	1052	finally
      //   495	510	1052	finally
      //   512	526	1052	finally
      //   531	548	1063	finally
      //   622	639	1063	finally
      //   641	649	1079	finally
      //   654	663	1079	finally
      //   670	696	1079	finally
      //   730	775	1079	finally
      //   792	812	1104	finally
      //   265	292	1109	java/lang/Exception
      //   439	447	1109	java/lang/Exception
      //   292	330	1123	java/lang/Exception
      //   334	399	1142	java/lang/Exception
      //   495	510	1142	java/lang/Exception
      //   512	526	1142	java/lang/Exception
      //   531	548	1153	java/lang/Exception
      //   622	639	1153	java/lang/Exception
    }
    
    public final boolean onPostExecute()
    {
      AppMethodBeat.i(150273);
      if (f.this.iKE)
      {
        AppMethodBeat.o(150273);
        return false;
      }
      if ((this.aGI) || (Util.isNullOrNil(this.iKI)))
      {
        f.this.iKC.dp(4, -1);
        AppMethodBeat.o(150273);
        return false;
      }
      Log.d("MicroMsg.GetHDHeadImgHelper", "dkavatar user:" + this.iKq.getUsername() + " urltime:" + this.iKL.apr());
      if (ay.a.iDr != null) {
        ay.a.iDr.dl((int)s.boW(this.iKJ), 0);
      }
      f.this.iKH.add(new f.a(f.this, f.this.iKn, this.iKI, this.iKJ));
      AppMethodBeat.o(150273);
      return true;
    }
  }
  
  public static abstract interface c
  {
    public abstract int dp(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aj.f
 * JD-Core Version:    0.7.0.1
 */