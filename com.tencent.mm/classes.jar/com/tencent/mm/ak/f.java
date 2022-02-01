package com.tencent.mm.ak;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.e;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.be.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.storage.af;
import junit.framework.Assert;

public final class f
  implements com.tencent.mm.al.g
{
  c gTL;
  l gTM;
  boolean gTN;
  boolean gTO;
  boolean gTP;
  be gTQ;
  i gTw;
  
  public f()
  {
    AppMethodBeat.i(150274);
    this.gTw = null;
    this.gTL = null;
    this.gTM = null;
    this.gTN = false;
    this.gTO = true;
    this.gTP = true;
    this.gTQ = null;
    com.tencent.mm.kernel.g.aeS().a(158, this);
    AppMethodBeat.o(150274);
  }
  
  private int a(i parami)
  {
    AppMethodBeat.i(150278);
    if ((this.gTQ == null) || (this.gTQ.eGm())) {
      this.gTQ = new be(1, "get-hd-headimg", 1);
    }
    int i = this.gTQ.c(new b(parami));
    AppMethodBeat.o(150278);
    return i;
  }
  
  public final int a(String paramString, c paramc)
  {
    AppMethodBeat.i(150276);
    Assert.assertTrue("GetHDHeadImg must set callback", true);
    if (bt.isNullOrNil(paramString))
    {
      paramc.dd(3, -101);
      AppMethodBeat.o(150276);
      return -101;
    }
    this.gTL = paramc;
    if (af.st(paramString)) {}
    for (String str = af.aHM(paramString);; str = paramString)
    {
      this.gTw = p.auF().we(str);
      ad.d("MicroMsg.GetHDHeadImgHelper", "GetHDHeadImg: %s", new Object[] { str });
      if ((this.gTw == null) || (!this.gTw.getUsername().equals(str)))
      {
        this.gTw = new i();
        this.gTw.username = str;
      }
      if (bt.isNullOrNil(this.gTw.aux()))
      {
        ad.w("MicroMsg.GetHDHeadImgHelper", "dkhurl [%s] has NO URL flag:%d !", new Object[] { paramString, Integer.valueOf(this.gTw.evo) });
        this.gTM = new l(str);
        if (!com.tencent.mm.kernel.g.aeS().a(this.gTM, 0))
        {
          paramc.dd(3, -102);
          AppMethodBeat.o(150276);
          return -102;
        }
        AppMethodBeat.o(150276);
        return 0;
      }
      if (a(this.gTw) == 0)
      {
        AppMethodBeat.o(150276);
        return 0;
      }
      paramc.dd(3, -103);
      AppMethodBeat.o(150276);
      return -103;
    }
  }
  
  public final void auu()
  {
    AppMethodBeat.i(150275);
    com.tencent.mm.kernel.g.aeS().b(158, this);
    AppMethodBeat.o(150275);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(150277);
    this.gTL.dd(paramInt1, paramInt2);
    AppMethodBeat.o(150277);
  }
  
  final class a
    implements be.a
  {
    boolean aEj = true;
    boolean bym;
    boolean fSS = false;
    String gTR;
    String gTS;
    i gTw;
    
    public a(i parami, String paramString1, String paramString2)
    {
      this.gTw = parami;
      this.gTR = paramString1;
      this.gTS = paramString2;
      this.bym = false;
    }
    
    public final boolean aus()
    {
      AppMethodBeat.i(150269);
      Object localObject;
      String str1;
      String str2;
      if (this.bym)
      {
        h.vKh.dB(138, 61);
        ad.i("MicroMsg.GetHDHeadImgHelper", "DecryptAvatar: decrypt %s", new Object[] { this.gTS });
        localObject = UtilsJni.DecryptAvatar(com.tencent.mm.vfs.i.aR(this.gTS, 0, -1));
        if ((localObject != null) && (localObject.length > 0))
        {
          com.tencent.mm.vfs.i.deleteFile(this.gTS);
          com.tencent.mm.vfs.i.f(this.gTS, (byte[])localObject, localObject.length);
        }
      }
      else
      {
        if (!t.aFn(this.gTS)) {
          break label334;
        }
        this.fSS = true;
        ad.i("MicroMsg.GetHDHeadImgHelper", "DecryptAvatar: hevc to pic start");
        h.vKh.dB(138, 63);
        localObject = this.gTS + "_hevc";
        boolean bool1 = com.tencent.mm.vfs.i.lD(this.gTS, (String)localObject);
        boolean bool2 = com.tencent.mm.vfs.i.aMR(this.gTS);
        str1 = com.tencent.mm.vfs.i.k(this.gTS, true);
        str2 = com.tencent.mm.vfs.i.k((String)localObject, false);
        if ((str1 != null) && (str2 != null)) {
          break label281;
        }
        ad.i("MicroMsg.GetHDHeadImgHelper", "DecryptAvatar: uri is null %s, %s; path %s, %s; result %s, %s", new Object[] { str1, str2, this.gTS, localObject, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        h.vKh.dB(138, 65);
        AppMethodBeat.o(150269);
        return true;
      }
      h.vKh.dB(138, 62);
      ad.i("MicroMsg.GetHDHeadImgHelper", "DecryptAvatar: decrypt failed");
      AppMethodBeat.o(150269);
      return true;
      label281:
      int i = ((c)com.tencent.mm.kernel.g.ab(c.class)).nativeWxam2Pic(str2, str1);
      com.tencent.mm.vfs.i.deleteFile((String)localObject);
      if (i != 0)
      {
        h.vKh.dB(138, 64);
        ad.i("MicroMsg.GetHDHeadImgHelper", "DecryptAvatar: hevc to pic failed");
        AppMethodBeat.o(150269);
        return true;
      }
      label334:
      this.aEj = false;
      AppMethodBeat.o(150269);
      return true;
    }
    
    public final boolean aut()
    {
      AppMethodBeat.i(150270);
      if (f.this.gTN)
      {
        AppMethodBeat.o(150270);
        return false;
      }
      if (this.aEj)
      {
        if ((this.fSS) && (f.this.gTO))
        {
          ad.i("MicroMsg.GetHDHeadImgHelper", "onPostExecute: first request hevc failed");
          f.this.gTO = false;
          f.this.gTP = false;
          f.this.gTQ.c(new f.b(f.this, this.gTw));
        }
        for (;;)
        {
          AppMethodBeat.o(150270);
          return false;
          f.this.gTL.dd(3, -1);
        }
      }
      com.tencent.mm.vfs.i.deleteFile(this.gTR);
      com.tencent.mm.vfs.i.lD(this.gTS, this.gTR);
      l.aP(this.gTR, this.gTw.getUsername());
      f.this.gTL.dd(0, 0);
      AppMethodBeat.o(150270);
      return true;
    }
  }
  
  @SuppressLint({"DefaultLocale"})
  final class b
    implements be.a
  {
    public boolean aEj;
    boolean bym;
    public String gTR;
    String gTS;
    private com.tencent.mm.compatible.util.f.a gTU;
    public i gTz;
    
    public b(i parami)
    {
      AppMethodBeat.i(150271);
      this.gTz = null;
      this.gTR = null;
      this.aEj = true;
      this.bym = false;
      this.gTz = parami;
      p.auq();
      this.gTR = e.I(parami.getUsername(), true);
      this.gTS = (this.gTR + ".tmp");
      this.gTU = new com.tencent.mm.compatible.util.f.a();
      AppMethodBeat.o(150271);
    }
    
    /* Error */
    public final boolean aus()
    {
      // Byte code:
      //   0: ldc 92
      //   2: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 40	com/tencent/mm/ak/f$b:gTz	Lcom/tencent/mm/ak/i;
      //   9: ifnonnull +10 -> 19
      //   12: ldc 92
      //   14: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   17: iconst_0
      //   18: ireturn
      //   19: aload_0
      //   20: getfield 40	com/tencent/mm/ak/f$b:gTz	Lcom/tencent/mm/ak/i;
      //   23: invokevirtual 95	com/tencent/mm/ak/i:aux	()Ljava/lang/String;
      //   26: astore 6
      //   28: ldc 97
      //   30: invokestatic 103	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
      //   33: checkcast 97	com/tencent/mm/plugin/emoji/b/c
      //   36: invokeinterface 106 1 0
      //   41: istore_3
      //   42: ldc 108
      //   44: invokestatic 103	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
      //   47: checkcast 108	com/tencent/mm/plugin/expt/a/b
      //   50: getstatic 114	com/tencent/mm/plugin/expt/a/b$a:ppP	Lcom/tencent/mm/plugin/expt/a/b$a;
      //   53: iconst_0
      //   54: invokeinterface 118 3 0
      //   59: istore 4
      //   61: aload_0
      //   62: getfield 28	com/tencent/mm/ak/f$b:gTT	Lcom/tencent/mm/ak/f;
      //   65: getfield 121	com/tencent/mm/ak/f:gTP	Z
      //   68: ifeq +1053 -> 1121
      //   71: iload_3
      //   72: ifeq +1049 -> 1121
      //   75: iload 4
      //   77: ifeq +1044 -> 1121
      //   80: ldc 123
      //   82: ldc 125
      //   84: invokestatic 130	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   87: aload 6
      //   89: ldc 132
      //   91: invokevirtual 138	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
      //   94: ifeq +264 -> 358
      //   97: new 66	java/lang/StringBuilder
      //   100: dup
      //   101: invokespecial 67	java/lang/StringBuilder:<init>	()V
      //   104: aload 6
      //   106: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   109: ldc 140
      //   111: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   114: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   117: astore 5
      //   119: getstatic 146	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
      //   122: sipush 138
      //   125: bipush 60
      //   127: invokevirtual 150	com/tencent/mm/plugin/report/service/h:dB	(II)V
      //   130: aload 5
      //   132: astore 6
      //   134: invokestatic 154	com/tencent/mm/kernel/g:afz	()Lcom/tencent/mm/kernel/a;
      //   137: invokevirtual 159	com/tencent/mm/kernel/a:aeI	()Z
      //   140: ifeq +973 -> 1113
      //   143: getstatic 164	com/tencent/mm/protocal/d:CpK	I
      //   146: istore_1
      //   147: invokestatic 154	com/tencent/mm/kernel/g:afz	()Lcom/tencent/mm/kernel/a;
      //   150: pop
      //   151: ldc 166
      //   153: iconst_4
      //   154: anewarray 4	java/lang/Object
      //   157: dup
      //   158: iconst_0
      //   159: iload_1
      //   160: invokestatic 172	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   163: aastore
      //   164: dup
      //   165: iconst_1
      //   166: invokestatic 176	com/tencent/mm/kernel/a:getUin	()I
      //   169: invokestatic 182	com/tencent/mm/b/p:getString	(I)Ljava/lang/String;
      //   172: aastore
      //   173: dup
      //   174: iconst_2
      //   175: invokestatic 188	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
      //   178: invokestatic 194	com/tencent/mm/sdk/platformtools/ay:getNetTypeForStat	(Landroid/content/Context;)I
      //   181: invokestatic 172	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   184: aastore
      //   185: dup
      //   186: iconst_3
      //   187: invokestatic 188	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
      //   190: invokestatic 197	com/tencent/mm/sdk/platformtools/ay:getStrength	(Landroid/content/Context;)I
      //   193: invokestatic 172	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   196: aastore
      //   197: invokestatic 201	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   200: astore 7
      //   202: ldc 123
      //   204: ldc 203
      //   206: iconst_3
      //   207: anewarray 4	java/lang/Object
      //   210: dup
      //   211: iconst_0
      //   212: aload_0
      //   213: getfield 40	com/tencent/mm/ak/f$b:gTz	Lcom/tencent/mm/ak/i;
      //   216: invokevirtual 58	com/tencent/mm/ak/i:getUsername	()Ljava/lang/String;
      //   219: aastore
      //   220: dup
      //   221: iconst_1
      //   222: aload 7
      //   224: aastore
      //   225: dup
      //   226: iconst_2
      //   227: aload 6
      //   229: aastore
      //   230: invokestatic 207	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   233: aload_0
      //   234: iconst_1
      //   235: putfield 44	com/tencent/mm/ak/f$b:aEj	Z
      //   238: ldc 108
      //   240: invokestatic 103	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
      //   243: checkcast 108	com/tencent/mm/plugin/expt/a/b
      //   246: getstatic 210	com/tencent/mm/plugin/expt/a/b$a:pvR	Lcom/tencent/mm/plugin/expt/a/b$a;
      //   249: iconst_0
      //   250: invokeinterface 118 3 0
      //   255: ifeq +128 -> 383
      //   258: aload 6
      //   260: invokestatic 216	com/tencent/mm/network/b:AY	(Ljava/lang/String;)Lcom/tencent/mm/network/x;
      //   263: astore 5
      //   265: aload 5
      //   267: checkcast 218	com/tencent/mm/network/x
      //   270: sipush 1223
      //   273: putfield 221	com/tencent/mm/network/x:hMg	I
      //   276: aload 5
      //   278: astore 8
      //   280: aload 8
      //   282: ldc 223
      //   284: invokeinterface 229 2 0
      //   289: aload 8
      //   291: ldc 231
      //   293: aload 7
      //   295: invokeinterface 234 3 0
      //   300: aload 8
      //   302: sipush 5000
      //   305: invokeinterface 237 2 0
      //   310: aload 8
      //   312: sipush 5000
      //   315: invokeinterface 240 2 0
      //   320: aload 8
      //   322: invokestatic 243	com/tencent/mm/network/b:a	(Lcom/tencent/mm/network/w;)I
      //   325: ifeq +114 -> 439
      //   328: ldc 123
      //   330: ldc 245
      //   332: iconst_1
      //   333: anewarray 4	java/lang/Object
      //   336: dup
      //   337: iconst_0
      //   338: aload 6
      //   340: aastore
      //   341: invokestatic 248	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   344: aload 8
      //   346: invokeinterface 251 1 0
      //   351: ldc 92
      //   353: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   356: iconst_1
      //   357: ireturn
      //   358: new 66	java/lang/StringBuilder
      //   361: dup
      //   362: invokespecial 67	java/lang/StringBuilder:<init>	()V
      //   365: aload 6
      //   367: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   370: ldc 253
      //   372: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   375: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   378: astore 5
      //   380: goto -261 -> 119
      //   383: aload 6
      //   385: aconst_null
      //   386: invokestatic 256	com/tencent/mm/network/b:a	(Ljava/lang/String;Lcom/tencent/mm/network/b$b;)Lcom/tencent/mm/network/v;
      //   389: astore 8
      //   391: goto -111 -> 280
      //   394: astore 5
      //   396: ldc 123
      //   398: ldc_w 258
      //   401: iconst_1
      //   402: anewarray 4	java/lang/Object
      //   405: dup
      //   406: iconst_0
      //   407: aload 5
      //   409: invokestatic 264	com/tencent/mm/sdk/platformtools/bt:m	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   412: aastore
      //   413: invokestatic 248	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   416: ldc 123
      //   418: ldc_w 266
      //   421: iconst_1
      //   422: anewarray 4	java/lang/Object
      //   425: dup
      //   426: iconst_0
      //   427: aload 5
      //   429: invokevirtual 269	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   432: aastore
      //   433: invokestatic 248	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   436: goto -85 -> 351
      //   439: aload 8
      //   441: ldc_w 271
      //   444: iconst_0
      //   445: invokeinterface 275 3 0
      //   450: iconst_1
      //   451: if_icmpne +65 -> 516
      //   454: iconst_1
      //   455: istore_3
      //   456: aload_0
      //   457: iload_3
      //   458: putfield 46	com/tencent/mm/ak/f$b:bym	Z
      //   461: aload 8
      //   463: invokeinterface 279 1 0
      //   468: astore 5
      //   470: aload 5
      //   472: ifnonnull +94 -> 566
      //   475: ldc 123
      //   477: ldc_w 281
      //   480: iconst_1
      //   481: anewarray 4	java/lang/Object
      //   484: dup
      //   485: iconst_0
      //   486: aload 6
      //   488: aastore
      //   489: invokestatic 207	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   492: aload 8
      //   494: invokeinterface 251 1 0
      //   499: aload 5
      //   501: ifnull +8 -> 509
      //   504: aload 5
      //   506: invokevirtual 286	java/io/InputStream:close	()V
      //   509: ldc 92
      //   511: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   514: iconst_1
      //   515: ireturn
      //   516: iconst_0
      //   517: istore_3
      //   518: goto -62 -> 456
      //   521: astore 5
      //   523: ldc 123
      //   525: ldc_w 258
      //   528: iconst_1
      //   529: anewarray 4	java/lang/Object
      //   532: dup
      //   533: iconst_0
      //   534: aload 5
      //   536: invokestatic 264	com/tencent/mm/sdk/platformtools/bt:m	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   539: aastore
      //   540: invokestatic 248	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   543: ldc 123
      //   545: ldc_w 266
      //   548: iconst_1
      //   549: anewarray 4	java/lang/Object
      //   552: dup
      //   553: iconst_0
      //   554: aload 5
      //   556: invokevirtual 269	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   559: aastore
      //   560: invokestatic 248	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   563: goto -54 -> 509
      //   566: sipush 1024
      //   569: newarray byte
      //   571: astore 7
      //   573: aload_0
      //   574: getfield 78	com/tencent/mm/ak/f$b:gTS	Ljava/lang/String;
      //   577: iconst_0
      //   578: invokestatic 292	com/tencent/mm/vfs/i:cM	(Ljava/lang/String;Z)Ljava/io/OutputStream;
      //   581: astore 6
      //   583: iconst_0
      //   584: istore_1
      //   585: aload 5
      //   587: aload 7
      //   589: invokevirtual 296	java/io/InputStream:read	([B)I
      //   592: istore_2
      //   593: iload_2
      //   594: iconst_m1
      //   595: if_icmpeq +19 -> 614
      //   598: aload 6
      //   600: aload 7
      //   602: iconst_0
      //   603: iload_2
      //   604: invokevirtual 302	java/io/OutputStream:write	([BII)V
      //   607: iload_1
      //   608: iload_2
      //   609: iadd
      //   610: istore_1
      //   611: goto -26 -> 585
      //   614: iload_1
      //   615: aload 8
      //   617: ldc_w 304
      //   620: aload 8
      //   622: invokeinterface 307 1 0
      //   627: invokeinterface 275 3 0
      //   632: if_icmpne +42 -> 674
      //   635: aload_0
      //   636: iconst_0
      //   637: putfield 44	com/tencent/mm/ak/f$b:aEj	Z
      //   640: aload 8
      //   642: invokeinterface 251 1 0
      //   647: aload 5
      //   649: ifnull +8 -> 657
      //   652: aload 5
      //   654: invokevirtual 286	java/io/InputStream:close	()V
      //   657: aload 6
      //   659: ifnull +8 -> 667
      //   662: aload 6
      //   664: invokevirtual 308	java/io/OutputStream:close	()V
      //   667: ldc 92
      //   669: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   672: iconst_1
      //   673: ireturn
      //   674: ldc 123
      //   676: ldc_w 310
      //   679: iconst_3
      //   680: anewarray 4	java/lang/Object
      //   683: dup
      //   684: iconst_0
      //   685: iload_1
      //   686: invokestatic 172	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   689: aastore
      //   690: dup
      //   691: iconst_1
      //   692: aload 8
      //   694: ldc_w 304
      //   697: invokeinterface 314 2 0
      //   702: aastore
      //   703: dup
      //   704: iconst_2
      //   705: aload 8
      //   707: invokeinterface 307 1 0
      //   712: invokestatic 172	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   715: aastore
      //   716: invokestatic 248	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   719: goto -79 -> 640
      //   722: astore 9
      //   724: aload 6
      //   726: astore 7
      //   728: aload 5
      //   730: astore 6
      //   732: aload 9
      //   734: astore 5
      //   736: ldc 123
      //   738: ldc_w 258
      //   741: iconst_1
      //   742: anewarray 4	java/lang/Object
      //   745: dup
      //   746: iconst_0
      //   747: aload 5
      //   749: invokestatic 264	com/tencent/mm/sdk/platformtools/bt:m	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   752: aastore
      //   753: invokestatic 248	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   756: aload 8
      //   758: ifnull +10 -> 768
      //   761: aload 8
      //   763: invokeinterface 251 1 0
      //   768: aload 6
      //   770: ifnull +8 -> 778
      //   773: aload 6
      //   775: invokevirtual 286	java/io/InputStream:close	()V
      //   778: aload 7
      //   780: ifnull -113 -> 667
      //   783: aload 7
      //   785: invokevirtual 308	java/io/OutputStream:close	()V
      //   788: goto -121 -> 667
      //   791: astore 5
      //   793: ldc 123
      //   795: ldc_w 258
      //   798: iconst_1
      //   799: anewarray 4	java/lang/Object
      //   802: dup
      //   803: iconst_0
      //   804: aload 5
      //   806: invokestatic 264	com/tencent/mm/sdk/platformtools/bt:m	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   809: aastore
      //   810: invokestatic 248	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   813: ldc 123
      //   815: ldc_w 266
      //   818: iconst_1
      //   819: anewarray 4	java/lang/Object
      //   822: dup
      //   823: iconst_0
      //   824: aload 5
      //   826: invokevirtual 269	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   829: aastore
      //   830: invokestatic 248	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   833: goto -166 -> 667
      //   836: astore 5
      //   838: ldc 123
      //   840: ldc_w 258
      //   843: iconst_1
      //   844: anewarray 4	java/lang/Object
      //   847: dup
      //   848: iconst_0
      //   849: aload 5
      //   851: invokestatic 264	com/tencent/mm/sdk/platformtools/bt:m	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   854: aastore
      //   855: invokestatic 248	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   858: ldc 123
      //   860: ldc_w 266
      //   863: iconst_1
      //   864: anewarray 4	java/lang/Object
      //   867: dup
      //   868: iconst_0
      //   869: aload 5
      //   871: invokevirtual 269	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   874: aastore
      //   875: invokestatic 248	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   878: goto -211 -> 667
      //   881: astore 5
      //   883: aconst_null
      //   884: astore 6
      //   886: aconst_null
      //   887: astore 7
      //   889: aconst_null
      //   890: astore 8
      //   892: aload 8
      //   894: ifnull +10 -> 904
      //   897: aload 8
      //   899: invokeinterface 251 1 0
      //   904: aload 6
      //   906: ifnull +8 -> 914
      //   909: aload 6
      //   911: invokevirtual 286	java/io/InputStream:close	()V
      //   914: aload 7
      //   916: ifnull +8 -> 924
      //   919: aload 7
      //   921: invokevirtual 308	java/io/OutputStream:close	()V
      //   924: ldc 92
      //   926: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   929: aload 5
      //   931: athrow
      //   932: astore 6
      //   934: ldc 123
      //   936: ldc_w 258
      //   939: iconst_1
      //   940: anewarray 4	java/lang/Object
      //   943: dup
      //   944: iconst_0
      //   945: aload 6
      //   947: invokestatic 264	com/tencent/mm/sdk/platformtools/bt:m	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   950: aastore
      //   951: invokestatic 248	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   954: ldc 123
      //   956: ldc_w 266
      //   959: iconst_1
      //   960: anewarray 4	java/lang/Object
      //   963: dup
      //   964: iconst_0
      //   965: aload 6
      //   967: invokevirtual 269	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   970: aastore
      //   971: invokestatic 248	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   974: goto -50 -> 924
      //   977: astore 9
      //   979: aconst_null
      //   980: astore 6
      //   982: aconst_null
      //   983: astore 7
      //   985: aload 5
      //   987: astore 8
      //   989: aload 9
      //   991: astore 5
      //   993: goto -101 -> 892
      //   996: astore 5
      //   998: aconst_null
      //   999: astore 6
      //   1001: aconst_null
      //   1002: astore 7
      //   1004: goto -112 -> 892
      //   1007: astore 9
      //   1009: aload 5
      //   1011: astore 6
      //   1013: aconst_null
      //   1014: astore 7
      //   1016: aload 9
      //   1018: astore 5
      //   1020: goto -128 -> 892
      //   1023: astore 10
      //   1025: aload 5
      //   1027: astore 7
      //   1029: aload 6
      //   1031: astore 9
      //   1033: aload 10
      //   1035: astore 5
      //   1037: aload 7
      //   1039: astore 6
      //   1041: aload 9
      //   1043: astore 7
      //   1045: goto -153 -> 892
      //   1048: astore 5
      //   1050: goto -158 -> 892
      //   1053: astore 5
      //   1055: aconst_null
      //   1056: astore 6
      //   1058: aconst_null
      //   1059: astore 7
      //   1061: aconst_null
      //   1062: astore 8
      //   1064: goto -328 -> 736
      //   1067: astore 9
      //   1069: aconst_null
      //   1070: astore 6
      //   1072: aconst_null
      //   1073: astore 7
      //   1075: aload 5
      //   1077: astore 8
      //   1079: aload 9
      //   1081: astore 5
      //   1083: goto -347 -> 736
      //   1086: astore 5
      //   1088: aconst_null
      //   1089: astore 6
      //   1091: aconst_null
      //   1092: astore 7
      //   1094: goto -358 -> 736
      //   1097: astore 9
      //   1099: aload 5
      //   1101: astore 6
      //   1103: aconst_null
      //   1104: astore 7
      //   1106: aload 9
      //   1108: astore 5
      //   1110: goto -374 -> 736
      //   1113: ldc_w 316
      //   1116: astore 7
      //   1118: goto -916 -> 202
      //   1121: goto -987 -> 134
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1124	0	this	b
      //   146	540	1	i	int
      //   592	18	2	j	int
      //   41	477	3	bool1	boolean
      //   59	17	4	bool2	boolean
      //   117	262	5	localObject1	Object
      //   394	34	5	localException1	java.lang.Exception
      //   468	37	5	localInputStream	java.io.InputStream
      //   521	208	5	localException2	java.lang.Exception
      //   734	14	5	localObject2	Object
      //   791	34	5	localException3	java.lang.Exception
      //   836	34	5	localException4	java.lang.Exception
      //   881	105	5	localObject3	Object
      //   991	1	5	localObject4	Object
      //   996	14	5	localObject5	Object
      //   1018	18	5	localObject6	Object
      //   1048	1	5	localObject7	Object
      //   1053	23	5	localException5	java.lang.Exception
      //   1081	1	5	localObject8	Object
      //   1086	14	5	localException6	java.lang.Exception
      //   1108	1	5	localObject9	Object
      //   26	884	6	localObject10	Object
      //   932	34	6	localException7	java.lang.Exception
      //   980	122	6	localObject11	Object
      //   200	917	7	localObject12	Object
      //   278	800	8	localObject13	Object
      //   722	11	9	localException8	java.lang.Exception
      //   977	13	9	localObject14	Object
      //   1007	10	9	localObject15	Object
      //   1031	11	9	localObject16	Object
      //   1067	13	9	localException9	java.lang.Exception
      //   1097	10	9	localException10	java.lang.Exception
      //   1023	11	10	localObject17	Object
      // Exception table:
      //   from	to	target	type
      //   344	351	394	java/lang/Exception
      //   492	499	521	java/lang/Exception
      //   504	509	521	java/lang/Exception
      //   585	593	722	java/lang/Exception
      //   598	607	722	java/lang/Exception
      //   614	640	722	java/lang/Exception
      //   674	719	722	java/lang/Exception
      //   761	768	791	java/lang/Exception
      //   773	778	791	java/lang/Exception
      //   783	788	791	java/lang/Exception
      //   640	647	836	java/lang/Exception
      //   652	657	836	java/lang/Exception
      //   662	667	836	java/lang/Exception
      //   238	265	881	finally
      //   383	391	881	finally
      //   897	904	932	java/lang/Exception
      //   909	914	932	java/lang/Exception
      //   919	924	932	java/lang/Exception
      //   265	276	977	finally
      //   280	344	996	finally
      //   439	454	996	finally
      //   456	470	996	finally
      //   475	492	1007	finally
      //   566	583	1007	finally
      //   585	593	1023	finally
      //   598	607	1023	finally
      //   614	640	1023	finally
      //   674	719	1023	finally
      //   736	756	1048	finally
      //   238	265	1053	java/lang/Exception
      //   383	391	1053	java/lang/Exception
      //   265	276	1067	java/lang/Exception
      //   280	344	1086	java/lang/Exception
      //   439	454	1086	java/lang/Exception
      //   456	470	1086	java/lang/Exception
      //   475	492	1097	java/lang/Exception
      //   566	583	1097	java/lang/Exception
    }
    
    public final boolean aut()
    {
      AppMethodBeat.i(150273);
      if (f.this.gTN)
      {
        AppMethodBeat.o(150273);
        return false;
      }
      if ((this.aEj) || (bt.isNullOrNil(this.gTR)))
      {
        f.this.gTL.dd(4, -1);
        AppMethodBeat.o(150273);
        return false;
      }
      ad.d("MicroMsg.GetHDHeadImgHelper", "dkavatar user:" + this.gTz.getUsername() + " urltime:" + this.gTU.XK());
      if (ar.a.gMX != null) {
        ar.a.gMX.cZ((int)com.tencent.mm.vfs.i.aMN(this.gTS), 0);
      }
      f.this.gTQ.c(new f.a(f.this, f.this.gTw, this.gTR, this.gTS));
      AppMethodBeat.o(150273);
      return true;
    }
  }
  
  public static abstract interface c
  {
    public abstract int dd(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ak.f
 * JD-Core Version:    0.7.0.1
 */