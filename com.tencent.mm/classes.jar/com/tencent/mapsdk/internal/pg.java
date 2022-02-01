package com.tencent.mapsdk.internal;

import android.content.Context;
import com.tencent.mapsdk.core.components.protocol.jce.conf.CSFileUpdateReq;
import com.tencent.mapsdk.core.components.protocol.jce.conf.FileUpdateReq;
import com.tencent.mapsdk.core.components.protocol.jce.conf.FileUpdateRsp;
import com.tencent.mapsdk.vector.VectorMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class pg
{
  public static volatile Map<String, List<WeakReference<bg>>> e;
  public volatile boolean a;
  String b;
  mb c;
  mf d;
  public WeakReference<bg> f;
  String g;
  String h;
  String i;
  String j;
  String k;
  
  static
  {
    AppMethodBeat.i(225572);
    e = new HashMap();
    AppMethodBeat.o(225572);
  }
  
  public pg(Context paramContext, bg parambg, String paramString)
  {
    AppMethodBeat.i(225414);
    this.a = false;
    this.d = mf.a(paramContext, null);
    this.b = "";
    if ((parambg != null) && (parambg.b != null) && (parambg.b.e_ != null)) {
      this.b = ((VectorMap)parambg.b.e_).x();
    }
    this.f = new WeakReference(parambg);
    this.g = paramString;
    this.c = md.a(paramContext, this.g);
    if (this.c != null) {
      this.c.a(new String[] { "mapPoiIconIndoorVersion", "poiIconIndoorMd5" });
    }
    AppMethodBeat.o(225414);
  }
  
  private void a(FileUpdateRsp paramFileUpdateRsp)
  {
    AppMethodBeat.i(225498);
    if (paramFileUpdateRsp.iFileUpdated != 1)
    {
      AppMethodBeat.o(225498);
      return;
    }
    String str = paramFileUpdateRsp.sName;
    int m = -1;
    switch (str.hashCode())
    {
    default: 
      switch (m)
      {
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(225498);
      return;
      if (!str.equals("mapconfig")) {
        break;
      }
      m = 0;
      break;
      if (!str.equals("poi_icon")) {
        break;
      }
      m = 1;
      break;
      if (!str.equals("map_icon")) {
        break;
      }
      m = 2;
      break;
      if (!str.equals("indoormap_style")) {
        break;
      }
      m = 3;
      break;
      if (!str.equals("indoormap_style_night")) {
        break;
      }
      m = 4;
      break;
      if (!str.equals("escalator_night")) {
        break;
      }
      m = 5;
      break;
      if (!str.equals("indoorpoi_icon_3d")) {
        break;
      }
      m = 6;
      break;
      if (!str.equals("indoorpoi_icon_3d_night")) {
        break;
      }
      m = 7;
      break;
      this.c.a("mapConfigVersion", paramFileUpdateRsp.iVersion);
      this.c.a("mapConfigZipMd5", paramFileUpdateRsp.sMd5);
      AppMethodBeat.o(225498);
      return;
      this.c.a("poiIconVersion", paramFileUpdateRsp.iVersion);
      this.c.a("mapPoiIconZipMd5", paramFileUpdateRsp.sMd5);
      AppMethodBeat.o(225498);
      return;
      this.c.a("mapIconVersion", paramFileUpdateRsp.iVersion);
      this.c.a("mapIconZipMd5", paramFileUpdateRsp.sMd5);
      AppMethodBeat.o(225498);
      return;
      this.c.a("indoormap_style_version", paramFileUpdateRsp.iVersion);
      this.c.a("indoormap_style_md5", paramFileUpdateRsp.sMd5);
      AppMethodBeat.o(225498);
      return;
      this.c.a("indoormap_style_night_version", paramFileUpdateRsp.iVersion);
      this.c.a("indoormap_style_night_md5", paramFileUpdateRsp.sMd5);
      AppMethodBeat.o(225498);
      return;
      this.c.a("escalator_night_version", paramFileUpdateRsp.iVersion);
      this.c.a("escalator_night_md5", paramFileUpdateRsp.sMd5);
      AppMethodBeat.o(225498);
      return;
      this.c.a("mapPoiIcon3dIndoorVersion", paramFileUpdateRsp.iVersion);
      this.c.a("poiIcon3dIndoorMd5", paramFileUpdateRsp.sMd5);
      AppMethodBeat.o(225498);
      return;
      this.c.a("indoorpoi_icon_3d_night_version", paramFileUpdateRsp.iVersion);
      this.c.a("indoorpoi_icon_3d_night_md5", paramFileUpdateRsp.sMd5);
    }
  }
  
  private void a(String paramString, fo paramfo)
  {
    AppMethodBeat.i(225436);
    String str = a();
    if (e.containsKey(str))
    {
      a(str, this.f);
      AppMethodBeat.o(225436);
      return;
    }
    a(str, this.f);
    kl.b("REQ_CONFIG_UPDATE");
    jw.b(new a(this, paramString, paramfo));
    AppMethodBeat.o(225436);
  }
  
  private void a(boolean paramBoolean)
  {
    AppMethodBeat.i(225490);
    this.c.a("mapConfigLastCheckTime", System.currentTimeMillis());
    kb.c(this.j);
    kb.c(this.k);
    long l = System.currentTimeMillis();
    if (!paramBoolean) {
      l = 0L;
    }
    for (;;)
    {
      Object localObject1 = (List)e.get(a());
      if (localObject1 == null)
      {
        AppMethodBeat.o(225490);
        return;
      }
      int n = ((List)localObject1).size();
      localObject1 = (WeakReference[])((List)localObject1).toArray(new WeakReference[n]);
      int m = 0;
      if (m < n)
      {
        VectorMap localVectorMap;
        gq localgq;
        if (localObject1[m] != null)
        {
          Object localObject2 = (bg)localObject1[m].get();
          if (localObject2 != null)
          {
            sj localsj = ((bg)localObject2).b;
            if ((localsj != null) && (localsj.e_ != null))
            {
              localVectorMap = (VectorMap)localsj.e_;
              localgq = localsj.aB.d;
              if (!this.a) {
                break label330;
              }
              Object localObject3 = localVectorMap.o.r;
              if (localObject3 != null) {
                ((w)localObject3).c();
              }
              if (((bg)localObject2).e != null)
              {
                localObject3 = ((bg)localObject2).e;
                localObject2 = (mk)localsj.d_;
                if (localObject2 != null)
                {
                  localObject3 = ((qn)localObject3).a(((qn)localObject3).e);
                  if (localObject3 != null) {
                    ((mk)localObject2).i.b(((qm)localObject3).a);
                  }
                }
              }
              localVectorMap.o.v = true;
              if (localsj.aB != null) {
                localsj.aB.E();
              }
              localsj.aF = true;
              if (localgq != null)
              {
                localgq.a().a(false, l);
                localgq.a().b(paramBoolean, l);
              }
            }
          }
        }
        for (;;)
        {
          localVectorMap.n = true;
          m += 1;
          break;
          label330:
          if ((!paramBoolean) && (localgq != null)) {
            localgq.a().b(paramBoolean, l);
          }
        }
      }
      e.clear();
      md.b();
      kl.d("REQ_CONFIG_UPDATE");
      AppMethodBeat.o(225490);
      return;
    }
  }
  
  /* Error */
  private boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc_w 344
    //   3: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 84	com/tencent/mapsdk/internal/pg:f	Ljava/lang/ref/WeakReference;
    //   10: ifnull +39 -> 49
    //   13: aload_0
    //   14: getfield 84	com/tencent/mapsdk/internal/pg:f	Ljava/lang/ref/WeakReference;
    //   17: invokevirtual 230	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   20: checkcast 62	com/tencent/mapsdk/internal/bg
    //   23: astore 7
    //   25: aload 7
    //   27: ifnull +22 -> 49
    //   30: aload 7
    //   32: getfield 65	com/tencent/mapsdk/internal/bg:b	Lcom/tencent/mapsdk/internal/sj;
    //   35: ifnull +14 -> 49
    //   38: aload 7
    //   40: getfield 65	com/tencent/mapsdk/internal/bg:b	Lcom/tencent/mapsdk/internal/sj;
    //   43: getfield 71	com/tencent/mapsdk/internal/bn:e_	Lcom/tencent/mapsdk/internal/bk;
    //   46: ifnonnull +11 -> 57
    //   49: ldc_w 344
    //   52: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: iconst_0
    //   56: ireturn
    //   57: aload 7
    //   59: getfield 65	com/tencent/mapsdk/internal/bg:b	Lcom/tencent/mapsdk/internal/sj;
    //   62: getfield 71	com/tencent/mapsdk/internal/bn:e_	Lcom/tencent/mapsdk/internal/bk;
    //   65: checkcast 73	com/tencent/mapsdk/vector/VectorMap
    //   68: astore 8
    //   70: new 346	java/io/File
    //   73: dup
    //   74: aload_1
    //   75: invokespecial 348	java/io/File:<init>	(Ljava/lang/String;)V
    //   78: astore 7
    //   80: aload 7
    //   82: invokevirtual 351	java/io/File:exists	()Z
    //   85: ifeq +11 -> 96
    //   88: aload 7
    //   90: invokevirtual 354	java/io/File:isDirectory	()Z
    //   93: ifne +24 -> 117
    //   96: ldc_w 356
    //   99: aload_1
    //   100: invokestatic 360	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   103: invokevirtual 364	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   106: invokestatic 368	com/tencent/mapsdk/internal/kh:c	(Ljava/lang/String;)V
    //   109: ldc_w 344
    //   112: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   115: iconst_0
    //   116: ireturn
    //   117: aload 7
    //   119: invokevirtual 372	java/io/File:listFiles	()[Ljava/io/File;
    //   122: astore 9
    //   124: aload 9
    //   126: ifnonnull +11 -> 137
    //   129: ldc_w 344
    //   132: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   135: iconst_0
    //   136: ireturn
    //   137: iconst_1
    //   138: istore 5
    //   140: aconst_null
    //   141: astore_1
    //   142: aload 9
    //   144: arraylength
    //   145: istore 4
    //   147: iconst_0
    //   148: istore_3
    //   149: iload_3
    //   150: iload 4
    //   152: if_icmpge +272 -> 424
    //   155: aload 9
    //   157: iload_3
    //   158: aaload
    //   159: astore 10
    //   161: new 374	java/io/FileInputStream
    //   164: dup
    //   165: aload 10
    //   167: invokespecial 377	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   170: astore 7
    //   172: aload 10
    //   174: invokevirtual 380	java/io/File:length	()J
    //   177: l2i
    //   178: newarray byte
    //   180: astore_1
    //   181: aload 7
    //   183: aload_1
    //   184: iconst_0
    //   185: aload_1
    //   186: arraylength
    //   187: invokevirtual 386	java/io/InputStream:read	([BII)I
    //   190: pop
    //   191: aload_2
    //   192: aload_0
    //   193: getfield 388	com/tencent/mapsdk/internal/pg:h	Ljava/lang/String;
    //   196: invokevirtual 128	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   199: ifeq +97 -> 296
    //   202: aload 10
    //   204: invokevirtual 391	java/io/File:getName	()Ljava/lang/String;
    //   207: astore 10
    //   209: aload 8
    //   211: getfield 243	com/tencent/mapsdk/vector/VectorMap:o	Lcom/tencent/mapsdk/internal/mk;
    //   214: getfield 249	com/tencent/mapsdk/internal/mk:r	Lcom/tencent/mapsdk/internal/w;
    //   217: astore 11
    //   219: aload 11
    //   221: ifnonnull +28 -> 249
    //   224: iconst_0
    //   225: istore 6
    //   227: iload 6
    //   229: iload 5
    //   231: iand
    //   232: istore 5
    //   234: aload 7
    //   236: invokestatic 394	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   239: iload_3
    //   240: iconst_1
    //   241: iadd
    //   242: istore_3
    //   243: aload 7
    //   245: astore_1
    //   246: goto -97 -> 149
    //   249: aload 11
    //   251: getfield 397	com/tencent/mapsdk/internal/w:b	Lcom/tencent/mapsdk/internal/nt;
    //   254: ifnonnull +9 -> 263
    //   257: iconst_0
    //   258: istore 6
    //   260: goto -33 -> 227
    //   263: new 346	java/io/File
    //   266: dup
    //   267: aload 11
    //   269: getfield 397	com/tencent/mapsdk/internal/w:b	Lcom/tencent/mapsdk/internal/nt;
    //   272: invokeinterface 401 1 0
    //   277: invokespecial 348	java/io/File:<init>	(Ljava/lang/String;)V
    //   280: aload 10
    //   282: aload_1
    //   283: aload 11
    //   285: getfield 404	com/tencent/mapsdk/internal/w:d	Ljava/util/concurrent/locks/Lock;
    //   288: invokestatic 407	com/tencent/mapsdk/internal/w:a	(Ljava/io/File;Ljava/lang/String;[BLjava/util/concurrent/locks/Lock;)Z
    //   291: istore 6
    //   293: goto -66 -> 227
    //   296: aload_2
    //   297: aload_0
    //   298: getfield 409	com/tencent/mapsdk/internal/pg:i	Ljava/lang/String;
    //   301: invokevirtual 128	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   304: ifeq +148 -> 452
    //   307: aload 10
    //   309: invokevirtual 391	java/io/File:getName	()Ljava/lang/String;
    //   312: astore 10
    //   314: aload 8
    //   316: getfield 243	com/tencent/mapsdk/vector/VectorMap:o	Lcom/tencent/mapsdk/internal/mk;
    //   319: getfield 249	com/tencent/mapsdk/internal/mk:r	Lcom/tencent/mapsdk/internal/w;
    //   322: astore 11
    //   324: aload 11
    //   326: ifnonnull +9 -> 335
    //   329: iconst_0
    //   330: istore 6
    //   332: goto +123 -> 455
    //   335: aload 11
    //   337: getfield 397	com/tencent/mapsdk/internal/w:b	Lcom/tencent/mapsdk/internal/nt;
    //   340: ifnonnull +9 -> 349
    //   343: iconst_0
    //   344: istore 6
    //   346: goto +109 -> 455
    //   349: new 346	java/io/File
    //   352: dup
    //   353: aload 11
    //   355: getfield 397	com/tencent/mapsdk/internal/w:b	Lcom/tencent/mapsdk/internal/nt;
    //   358: invokeinterface 411 1 0
    //   363: invokespecial 348	java/io/File:<init>	(Ljava/lang/String;)V
    //   366: aload 10
    //   368: aload_1
    //   369: aload 11
    //   371: getfield 413	com/tencent/mapsdk/internal/w:e	Ljava/util/concurrent/locks/Lock;
    //   374: invokestatic 407	com/tencent/mapsdk/internal/w:a	(Ljava/io/File;Ljava/lang/String;[BLjava/util/concurrent/locks/Lock;)Z
    //   377: istore 6
    //   379: goto +76 -> 455
    //   382: astore_1
    //   383: aload 7
    //   385: astore_1
    //   386: aload_1
    //   387: invokestatic 394	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   390: aload_1
    //   391: astore 7
    //   393: goto -154 -> 239
    //   396: astore_1
    //   397: aload 7
    //   399: astore_1
    //   400: aload_1
    //   401: invokestatic 394	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   404: aload_1
    //   405: astore 7
    //   407: goto -168 -> 239
    //   410: astore_1
    //   411: aload 7
    //   413: invokestatic 394	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   416: ldc_w 344
    //   419: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   422: aload_1
    //   423: athrow
    //   424: ldc_w 344
    //   427: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   430: iload 5
    //   432: ireturn
    //   433: astore_2
    //   434: aload_1
    //   435: astore 7
    //   437: aload_2
    //   438: astore_1
    //   439: goto -28 -> 411
    //   442: astore 7
    //   444: goto -44 -> 400
    //   447: astore 7
    //   449: goto -63 -> 386
    //   452: goto -218 -> 234
    //   455: iload 6
    //   457: iload 5
    //   459: iand
    //   460: istore 5
    //   462: goto -228 -> 234
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	465	0	this	pg
    //   0	465	1	paramString1	String
    //   0	465	2	paramString2	String
    //   148	95	3	m	int
    //   145	8	4	n	int
    //   138	323	5	bool1	boolean
    //   225	235	6	bool2	boolean
    //   23	413	7	localObject1	Object
    //   442	1	7	localIOException	java.io.IOException
    //   447	1	7	localFileNotFoundException	java.io.FileNotFoundException
    //   68	247	8	localVectorMap	VectorMap
    //   122	34	9	arrayOfFile	java.io.File[]
    //   159	208	10	localObject2	Object
    //   217	153	11	localw	w
    // Exception table:
    //   from	to	target	type
    //   172	219	382	java/io/FileNotFoundException
    //   249	257	382	java/io/FileNotFoundException
    //   263	293	382	java/io/FileNotFoundException
    //   296	324	382	java/io/FileNotFoundException
    //   335	343	382	java/io/FileNotFoundException
    //   349	379	382	java/io/FileNotFoundException
    //   172	219	396	java/io/IOException
    //   249	257	396	java/io/IOException
    //   263	293	396	java/io/IOException
    //   296	324	396	java/io/IOException
    //   335	343	396	java/io/IOException
    //   349	379	396	java/io/IOException
    //   172	219	410	finally
    //   249	257	410	finally
    //   263	293	410	finally
    //   296	324	410	finally
    //   335	343	410	finally
    //   349	379	410	finally
    //   161	172	433	finally
    //   161	172	442	java/io/IOException
    //   161	172	447	java/io/FileNotFoundException
  }
  
  private List<FileUpdateRsp> b(String paramString, fo paramfo)
  {
    AppMethodBeat.i(225455);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new FileUpdateReq("mapconfig", this.c.b("mapConfigVersion"), this.c.a("mapConfigZipMd5")));
    localArrayList.add(new FileUpdateReq("poi_icon", this.c.b("poiIconVersion"), this.c.a("mapPoiIconZipMd5")));
    localArrayList.add(new FileUpdateReq("map_icon", this.c.b("mapIconVersion"), this.c.a("mapIconZipMd5")));
    localArrayList.add(new FileUpdateReq("escalator_night", this.c.b("escalator_night_version"), this.c.a("escalator_night_md5")));
    if ((paramfo != null) && (paramfo.a()))
    {
      localArrayList.add(new FileUpdateReq("indoormap_style", this.c.b("indoormap_style_version"), this.c.a("indoormap_style_md5")));
      localArrayList.add(new FileUpdateReq("indoormap_style_night", this.c.b("indoormap_style_night_version"), this.c.a("indoormap_style_night_md5")));
      localArrayList.add(new FileUpdateReq("indoorpoi_icon_3d", this.c.b("mapPoiIcon3dIndoorVersion"), this.c.a("poiIcon3dIndoorMd5")));
      localArrayList.add(new FileUpdateReq("indoorpoi_icon_3d_night", this.c.b("indoorpoi_icon_3d_night_version"), this.c.a("indoorpoi_icon_3d_night_md5")));
    }
    paramfo = a();
    paramString = new CSFileUpdateReq(localArrayList, paramfo, gw.l(), null, this.b, paramString);
    this.h = this.d.a(this.g);
    this.i = this.d.b(this.g);
    this.j = (this.d.c(this.g) + "config/");
    this.k = (this.d.c(this.g) + "assets/");
    kb.a(this.j);
    kb.a(this.k);
    paramString = new pe().a(this.d.c(this.g) + "config/", this.d.c(this.g) + "assets/", paramfo, paramString, this);
    AppMethodBeat.o(225455);
    return paramString;
  }
  
  private void b()
  {
    AppMethodBeat.i(225422);
    if (this.c == null)
    {
      AppMethodBeat.o(225422);
      return;
    }
    this.c.a(new String[] { "mapPoiIconIndoorVersion", "poiIconIndoorMd5" });
    AppMethodBeat.o(225422);
  }
  
  private WeakReference<bg>[] c()
  {
    AppMethodBeat.i(225509);
    Object localObject = (List)e.get(a());
    if (localObject == null)
    {
      AppMethodBeat.o(225509);
      return null;
    }
    localObject = (WeakReference[])((List)localObject).toArray(new WeakReference[((List)localObject).size()]);
    AppMethodBeat.o(225509);
    return localObject;
  }
  
  public final String a()
  {
    AppMethodBeat.i(225578);
    String str = this.g;
    if (gz.a(this.g)) {
      str = gw.a();
    }
    AppMethodBeat.o(225578);
    return str;
  }
  
  /* Error */
  public final void a(String paramString, WeakReference<bg> paramWeakReference)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 484
    //   5: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 40	com/tencent/mapsdk/internal/pg:e	Ljava/util/Map;
    //   11: aload_1
    //   12: invokeinterface 320 2 0
    //   17: ifeq +37 -> 54
    //   20: getstatic 40	com/tencent/mapsdk/internal/pg:e	Ljava/util/Map;
    //   23: aload_1
    //   24: invokeinterface 216 2 0
    //   29: checkcast 218	java/util/List
    //   32: astore_1
    //   33: aload_1
    //   34: ifnull +11 -> 45
    //   37: aload_1
    //   38: aload_2
    //   39: invokeinterface 485 2 0
    //   44: pop
    //   45: ldc_w 484
    //   48: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   51: aload_0
    //   52: monitorexit
    //   53: return
    //   54: new 417	java/util/ArrayList
    //   57: dup
    //   58: invokespecial 418	java/util/ArrayList:<init>	()V
    //   61: astore_3
    //   62: aload_3
    //   63: aload_2
    //   64: invokeinterface 485 2 0
    //   69: pop
    //   70: getstatic 40	com/tencent/mapsdk/internal/pg:e	Ljava/util/Map;
    //   73: aload_1
    //   74: aload_3
    //   75: invokeinterface 489 3 0
    //   80: pop
    //   81: ldc_w 484
    //   84: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   87: goto -36 -> 51
    //   90: astore_1
    //   91: aload_0
    //   92: monitorexit
    //   93: aload_1
    //   94: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	pg
    //   0	95	1	paramString	String
    //   0	95	2	paramWeakReference	WeakReference<bg>
    //   61	14	3	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   2	33	90	finally
    //   37	45	90	finally
    //   45	51	90	finally
    //   54	87	90	finally
  }
  
  public static final class a
    implements Runnable
  {
    private final WeakReference<pg> a;
    private final String b;
    private final fo c;
    
    public a(pg parampg, String paramString, fo paramfo)
    {
      AppMethodBeat.i(224245);
      this.a = new WeakReference(parampg);
      this.b = paramString;
      this.c = paramfo;
      AppMethodBeat.o(224245);
    }
    
    public final void run()
    {
      AppMethodBeat.i(224266);
      if ((this.a != null) && (this.a.get() != null))
      {
        pg localpg = (pg)this.a.get();
        Object localObject1 = this.b;
        Object localObject2 = this.c;
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(new FileUpdateReq("mapconfig", localpg.c.b("mapConfigVersion"), localpg.c.a("mapConfigZipMd5")));
        localArrayList.add(new FileUpdateReq("poi_icon", localpg.c.b("poiIconVersion"), localpg.c.a("mapPoiIconZipMd5")));
        localArrayList.add(new FileUpdateReq("map_icon", localpg.c.b("mapIconVersion"), localpg.c.a("mapIconZipMd5")));
        localArrayList.add(new FileUpdateReq("escalator_night", localpg.c.b("escalator_night_version"), localpg.c.a("escalator_night_md5")));
        if ((localObject2 != null) && (((fo)localObject2).a()))
        {
          localArrayList.add(new FileUpdateReq("indoormap_style", localpg.c.b("indoormap_style_version"), localpg.c.a("indoormap_style_md5")));
          localArrayList.add(new FileUpdateReq("indoormap_style_night", localpg.c.b("indoormap_style_night_version"), localpg.c.a("indoormap_style_night_md5")));
          localArrayList.add(new FileUpdateReq("indoorpoi_icon_3d", localpg.c.b("mapPoiIcon3dIndoorVersion"), localpg.c.a("poiIcon3dIndoorMd5")));
          localArrayList.add(new FileUpdateReq("indoorpoi_icon_3d_night", localpg.c.b("indoorpoi_icon_3d_night_version"), localpg.c.a("indoorpoi_icon_3d_night_md5")));
        }
        localObject2 = localpg.a();
        localObject1 = new CSFileUpdateReq(localArrayList, (String)localObject2, gw.l(), null, localpg.b, (String)localObject1);
        localpg.h = localpg.d.a(localpg.g);
        localpg.i = localpg.d.b(localpg.g);
        localpg.j = (localpg.d.c(localpg.g) + "config/");
        localpg.k = (localpg.d.c(localpg.g) + "assets/");
        kb.a(localpg.j);
        kb.a(localpg.k);
        localObject1 = new pe().a(localpg.d.c(localpg.g) + "config/", localpg.d.c(localpg.g) + "assets/", (String)localObject2, (CSFileUpdateReq)localObject1, localpg);
        if (localObject1 != null)
        {
          if (localpg.a)
          {
            if ((!pg.a(localpg, pg.a(localpg), pg.b(localpg))) || (!pg.a(localpg, pg.c(localpg), pg.d(localpg))))
            {
              localpg.a = false;
              pg.a(localpg, false);
              AppMethodBeat.o(224266);
              return;
            }
            int i = 0;
            while (i < ((List)localObject1).size())
            {
              pg.a(localpg, (FileUpdateRsp)((List)localObject1).get(i));
              i += 1;
            }
          }
          pg.a(localpg, true);
          AppMethodBeat.o(224266);
          return;
        }
        localpg.a = false;
        pg.a(localpg, false);
      }
      AppMethodBeat.o(224266);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.pg
 * JD-Core Version:    0.7.0.1
 */