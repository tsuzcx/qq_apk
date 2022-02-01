package com.tencent.mm.plugin.finder.upload;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gx;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ce;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.report.e.b;
import com.tencent.mm.plugin.finder.report.e.c;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.protocal.protobuf.FinderMediaReportInfo;
import com.tencent.mm.protocal.protobuf.FinderMediaReportObject;
import com.tencent.mm.protocal.protobuf.bmd;
import com.tencent.mm.protocal.protobuf.bme;
import com.tencent.mm.protocal.protobuf.bmm;
import com.tencent.mm.protocal.protobuf.dkt;
import com.tencent.mm.protocal.protobuf.dxw;
import com.tencent.mm.protocal.protobuf.dxx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bt;
import d.a.j;
import d.g.b.v.a;
import d.g.b.v.b;
import d.g.b.v.c;
import d.y;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/upload/FinderMediaProcessTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "finderObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "getFinderObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFinderObj", "call", "", "exportMedia", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "remuxComposition", "", "startRemuxerTick", "", "index", "outputPath", "", "videoParams", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "mediaReportObject", "Lcom/tencent/mm/protocal/protobuf/FinderMediaReportObject;", "remuxNormalVideo", "videoWidth", "videoHeight", "width", "height", "bitrate", "localFinderMedia", "onUpdateProgress", "Lkotlin/Function1;", "", "uniqueId", "updateMedia", "localMedia", "reportObject", "updateProgress", "avgProgress", "Companion", "plugin-finder_release"})
public final class c
  extends com.tencent.mm.loader.g.c
{
  private static final String TAG = "Finder.FinderMediaProcessTask";
  public static final a qQG;
  FinderItem qQF;
  
  static
  {
    AppMethodBeat.i(167735);
    qQG = new a((byte)0);
    TAG = "Finder.FinderMediaProcessTask";
    AppMethodBeat.o(167735);
  }
  
  public c(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(167734);
    this.qQF = paramFinderItem;
    AppMethodBeat.o(167734);
  }
  
  /* Error */
  private final int a(final long paramLong, final int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, final int paramInt5, int paramInt6, final VideoTransPara paramVideoTransPara, bmd parambmd, final FinderMediaReportObject paramFinderMediaReportObject, d.g.a.b<? super Float, y> paramb)
  {
    // Byte code:
    //   0: ldc 108
    //   2: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 110	d/g/b/v$c
    //   8: dup
    //   9: invokespecial 111	d/g/b/v$c:<init>	()V
    //   12: astore 14
    //   14: aload 14
    //   16: iconst_m1
    //   17: putfield 115	d/g/b/v$c:Jhu	I
    //   20: new 117	java/lang/Object
    //   23: dup
    //   24: invokespecial 118	java/lang/Object:<init>	()V
    //   27: astore 15
    //   29: new 120	d/g/b/v$a
    //   32: dup
    //   33: invokespecial 121	d/g/b/v$a:<init>	()V
    //   36: astore 16
    //   38: aload 16
    //   40: iconst_0
    //   41: putfield 125	d/g/b/v$a:Jhs	Z
    //   44: aload 11
    //   46: getfield 130	com/tencent/mm/protocal/protobuf/bmd:url	Ljava/lang/String;
    //   49: astore 17
    //   51: aload 17
    //   53: ldc 132
    //   55: invokestatic 135	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   58: aload 11
    //   60: getfield 139	com/tencent/mm/protocal/protobuf/bmd:qDR	Lcom/tencent/mm/protocal/protobuf/bmm;
    //   63: getfield 145	com/tencent/mm/protocal/protobuf/bmm:DJU	Lcom/tencent/mm/protocal/protobuf/dkt;
    //   66: astore 18
    //   68: aload 18
    //   70: ldc 147
    //   72: invokestatic 135	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   75: new 149	com/tencent/mm/plugin/finder/video/g
    //   78: dup
    //   79: aload 17
    //   81: aload 4
    //   83: aload 18
    //   85: invokestatic 152	com/tencent/mm/plugin/finder/upload/c$a:a	(Lcom/tencent/mm/protocal/protobuf/dkt;)Landroid/graphics/Rect;
    //   88: iload 7
    //   90: iload 8
    //   92: iload 9
    //   94: aload 10
    //   96: getfield 157	com/tencent/mm/modelcontrol/VideoTransPara:audioBitrate	I
    //   99: aload 10
    //   101: getfield 160	com/tencent/mm/modelcontrol/VideoTransPara:audioSampleRate	I
    //   104: aload 10
    //   106: getfield 163	com/tencent/mm/modelcontrol/VideoTransPara:gnH	I
    //   109: aload 10
    //   111: getfield 166	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   114: aload 11
    //   116: getfield 139	com/tencent/mm/protocal/protobuf/bmd:qDR	Lcom/tencent/mm/protocal/protobuf/bmm;
    //   119: getfield 169	com/tencent/mm/protocal/protobuf/bmm:cUL	I
    //   122: i2l
    //   123: aload 11
    //   125: getfield 139	com/tencent/mm/protocal/protobuf/bmd:qDR	Lcom/tencent/mm/protocal/protobuf/bmm;
    //   128: getfield 172	com/tencent/mm/protocal/protobuf/bmm:gBm	I
    //   131: i2l
    //   132: new 17	com/tencent/mm/plugin/finder/upload/c$e
    //   135: dup
    //   136: aload 13
    //   138: invokespecial 175	com/tencent/mm/plugin/finder/upload/c$e:<init>	(Ld/g/a/b;)V
    //   141: checkcast 177	d/g/a/b
    //   144: new 19	com/tencent/mm/plugin/finder/upload/c$f
    //   147: dup
    //   148: aload_0
    //   149: aload 14
    //   151: iload_3
    //   152: aload 12
    //   154: lload_1
    //   155: iload 7
    //   157: iload 8
    //   159: aload 10
    //   161: aload 15
    //   163: aload 16
    //   165: invokespecial 180	com/tencent/mm/plugin/finder/upload/c$f:<init>	(Lcom/tencent/mm/plugin/finder/upload/c;Ld/g/b/v$c;ILcom/tencent/mm/protocal/protobuf/FinderMediaReportObject;JIILcom/tencent/mm/modelcontrol/VideoTransPara;Ljava/lang/Object;Ld/g/b/v$a;)V
    //   168: checkcast 177	d/g/a/b
    //   171: iload 5
    //   173: iload 6
    //   175: invokespecial 183	com/tencent/mm/plugin/finder/video/g:<init>	(Ljava/lang/String;Ljava/lang/String;Landroid/graphics/Rect;IIIIIIIJJLd/g/a/b;Ld/g/a/b;II)V
    //   178: astore 4
    //   180: aload 4
    //   182: invokevirtual 187	com/tencent/mm/plugin/finder/video/g:akd	()I
    //   185: pop
    //   186: aload 15
    //   188: monitorenter
    //   189: aload 16
    //   191: getfield 125	d/g/b/v$a:Jhs	Z
    //   194: ifne +58 -> 252
    //   197: getstatic 88	com/tencent/mm/plugin/finder/upload/c:TAG	Ljava/lang/String;
    //   200: ldc 189
    //   202: iload_3
    //   203: invokestatic 195	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   206: invokevirtual 199	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   209: invokestatic 204	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   212: aload 15
    //   214: invokevirtual 207	java/lang/Object:wait	()V
    //   217: getstatic 88	com/tencent/mm/plugin/finder/upload/c:TAG	Ljava/lang/String;
    //   220: new 209	java/lang/StringBuilder
    //   223: dup
    //   224: ldc 211
    //   226: invokespecial 214	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   229: iload_3
    //   230: invokevirtual 218	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   233: ldc 220
    //   235: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: aload 14
    //   240: getfield 115	d/g/b/v$c:Jhu	I
    //   243: invokevirtual 218	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   246: invokevirtual 227	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   249: invokestatic 204	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   252: getstatic 233	d/y:JfV	Ld/y;
    //   255: astore 4
    //   257: aload 15
    //   259: monitorexit
    //   260: aload 14
    //   262: getfield 115	d/g/b/v$c:Jhu	I
    //   265: istore_3
    //   266: ldc 108
    //   268: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   271: iload_3
    //   272: ireturn
    //   273: astore 4
    //   275: getstatic 88	com/tencent/mm/plugin/finder/upload/c:TAG	Ljava/lang/String;
    //   278: aload 4
    //   280: ldc 235
    //   282: iconst_0
    //   283: anewarray 117	java/lang/Object
    //   286: invokestatic 239	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   289: getstatic 245	com/tencent/mm/plugin/finder/report/e$b:qFJ	Lcom/tencent/mm/plugin/finder/report/e$b;
    //   292: astore 4
    //   294: invokestatic 248	com/tencent/mm/plugin/finder/report/e$b:cnE	()V
    //   297: aload_0
    //   298: getstatic 254	com/tencent/mm/loader/g/h:glb	Lcom/tencent/mm/loader/g/h;
    //   301: invokevirtual 257	com/tencent/mm/plugin/finder/upload/c:a	(Lcom/tencent/mm/loader/g/h;)V
    //   304: aload 14
    //   306: getfield 115	d/g/b/v$c:Jhu	I
    //   309: istore_3
    //   310: ldc 108
    //   312: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   315: iload_3
    //   316: ireturn
    //   317: astore 4
    //   319: aload 15
    //   321: monitorexit
    //   322: ldc 108
    //   324: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   327: aload 4
    //   329: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	330	0	this	c
    //   0	330	1	paramLong	long
    //   0	330	3	paramInt1	int
    //   0	330	4	paramString	String
    //   0	330	5	paramInt2	int
    //   0	330	6	paramInt3	int
    //   0	330	7	paramInt4	int
    //   0	330	8	paramInt5	int
    //   0	330	9	paramInt6	int
    //   0	330	10	paramVideoTransPara	VideoTransPara
    //   0	330	11	parambmd	bmd
    //   0	330	12	paramFinderMediaReportObject	FinderMediaReportObject
    //   0	330	13	paramb	d.g.a.b<? super Float, y>
    //   12	293	14	localc	v.c
    //   27	293	15	localObject	Object
    //   36	154	16	locala	v.a
    //   49	31	17	str	String
    //   66	18	18	localdkt	dkt
    // Exception table:
    //   from	to	target	type
    //   44	180	273	java/lang/Throwable
    //   189	252	317	finally
    //   252	257	317	finally
  }
  
  private final int a(final long paramLong, final int paramInt, String paramString, final VideoTransPara paramVideoTransPara, bmd parambmd, final FinderMediaReportObject paramFinderMediaReportObject)
  {
    AppMethodBeat.i(199524);
    ad.i(TAG, "remuxComposition outputPath:".concat(String.valueOf(paramString)));
    final dxw localdxw = parambmd.LzL;
    final v.c localc = new v.c();
    localc.Jhu = -1;
    final dxx localdxx = localdxw.Lqd;
    localdxx.oLh = paramString;
    final Object localObject = new Object();
    final v.a locala = new v.a();
    locala.Jhs = false;
    com.tencent.mm.plugin.vlog.model.k localk = new com.tencent.mm.plugin.vlog.model.k();
    localk.retryCount = parambmd.qDR.retryCount;
    localk.trF = true;
    parambmd = com.tencent.mm.plugin.finder.storage.b.qJA;
    if (com.tencent.mm.plugin.finder.storage.b.coE()) {
      localk.r(paramVideoTransPara);
    }
    parambmd = (d.g.a.b)new c(this);
    d.g.b.k.h(parambmd, "callback");
    localk.Lqa = parambmd;
    d.g.b.k.g(localdxw, "videoCompositionInfo");
    localk.a(localdxw, (d.g.a.b)new d(this, localc, paramInt, paramFinderMediaReportObject, paramLong, paramString, localdxx, paramVideoTransPara, localdxw, localObject, locala));
    try
    {
      if (!locala.Jhs)
      {
        ad.i(TAG, "wait ".concat(String.valueOf(paramInt)));
        localObject.wait();
        ad.i(TAG, "notify " + paramInt + ", " + localc.Jhu);
      }
      paramString = y.JfV;
      paramInt = localc.Jhu;
      AppMethodBeat.o(199524);
      return paramInt;
    }
    finally
    {
      AppMethodBeat.o(199524);
    }
  }
  
  public final void aT(float paramFloat)
  {
    AppMethodBeat.i(167733);
    float f = paramFloat;
    if (paramFloat > 1.0F) {
      f = 1.0F;
    }
    Object localObject = com.tencent.mm.plugin.finder.storage.b.qJA;
    int i = (int)(com.tencent.mm.plugin.finder.storage.b.coV() * f);
    ad.i(TAG, "feed " + this.qQF.getLocalId() + " updateProgress  " + f + ", " + i);
    if (this.qQF.getPostInfo().DJH < i)
    {
      this.qQF.getPostInfo().DJH = i;
      localObject = com.tencent.mm.plugin.finder.storage.logic.b.qKG;
      b.a.g(this.qQF);
    }
    localObject = com.tencent.mm.sdk.b.a.ESL;
    gx localgx = new gx();
    localgx.dky.deI = this.qQF.getLocalId();
    localgx.dky.progress = this.qQF.getPostInfo().DJH;
    ((com.tencent.mm.sdk.b.a)localObject).l((com.tencent.mm.sdk.b.b)localgx);
    AppMethodBeat.o(167733);
  }
  
  public final String abi()
  {
    AppMethodBeat.i(167732);
    long l = this.qQF.getLocalId();
    AppMethodBeat.o(167732);
    return String.valueOf(l);
  }
  
  public final void call()
  {
    AppMethodBeat.i(167731);
    this.qQF.trackPost("mediaProcess");
    final List localList = (List)new ArrayList();
    Object localObject1 = (Iterable)this.qQF.getMediaList();
    final int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        j.fvx();
      }
      localObject2 = (bmd)localObject2;
      if ((this.qQF.isNeedCrop(i)) && (this.qQF.getCropInfo(i) != null)) {
        localList.add(localObject2);
      }
      if ((this.qQF.isNeedVideoCompositionPlay(i)) && (this.qQF.getCropInfo(i) != null)) {
        localList.add(localObject2);
      }
      i += 1;
    }
    localObject1 = com.tencent.mm.plugin.finder.storage.b.qJA;
    if ((com.tencent.mm.plugin.finder.storage.b.coY()) && (ad.getLogLevel() >= 0))
    {
      ad.i(TAG, "debug blocking, sleep.....");
      Thread.sleep(1000000L);
    }
    if (localList.size() <= 0)
    {
      ad.i(TAG, "nothing need to be processed");
      aT(1.0F);
      a(com.tencent.mm.loader.g.h.gla);
      AppMethodBeat.o(167731);
      return;
    }
    ad.i(TAG, "process media count " + localList.size());
    localObject1 = e.c.qFV;
    e.c.cnL();
    localObject1 = com.tencent.mm.plugin.finder.storage.b.qJA;
    Object localObject2 = com.tencent.mm.plugin.finder.storage.b.coC();
    ad.i(TAG, "FinderMediaProcessTask videoParams ".concat(String.valueOf(localObject2)));
    localObject1 = (Iterable)localList;
    i = 0;
    Iterator localIterator = ((Iterable)localObject1).iterator();
    for (;;)
    {
      int m;
      bmd localbmd1;
      int j;
      Object localObject3;
      long l;
      Object localObject4;
      Object localObject5;
      int k;
      Object localObject6;
      if (localIterator.hasNext())
      {
        localObject1 = localIterator.next();
        m = i + 1;
        if (i < 0) {
          j.fvx();
        }
        localbmd1 = (bmd)localObject1;
        j = localbmd1.qDR.retryCount;
        localObject1 = com.tencent.mm.plugin.finder.storage.b.qJA;
        if (j > com.tencent.mm.plugin.finder.storage.b.coR())
        {
          a(com.tencent.mm.loader.g.h.glb);
          AppMethodBeat.o(167731);
          return;
        }
        localObject1 = localbmd1.qDR;
        ((bmm)localObject1).retryCount += 1;
        localObject1 = com.tencent.mm.plugin.finder.storage.logic.b.qKG;
        b.a.g(this.qQF);
        localObject1 = com.tencent.mm.plugin.finder.utils.i.qTa;
        boolean bool = com.tencent.mm.plugin.finder.utils.i.c(localbmd1);
        localObject3 = new FinderMediaReportObject();
        ((FinderMediaReportObject)localObject3).mediaType = localbmd1.mediaType;
        ((FinderMediaReportObject)localObject3).origin = new FinderMediaReportInfo();
        l = bt.GC();
        localObject1 = new com.tencent.mm.plugin.finder.loader.l(localbmd1, com.tencent.mm.plugin.finder.storage.h.KXa, 0, null, 12);
        localObject4 = com.tencent.mm.plugin.finder.utils.k.qTp;
        localObject4 = com.tencent.mm.plugin.finder.utils.k.a((com.tencent.mm.plugin.finder.loader.l)localObject1, String.valueOf(this.qQF.getCreateTime()));
        if (bool)
        {
          ((FinderMediaReportObject)localObject3).origin.fileSize = ((int)com.tencent.mm.vfs.i.aMN(localbmd1.url));
          localObject5 = com.tencent.mm.plugin.sight.base.e.ano(localbmd1.url);
          if (localObject5 != null)
          {
            ((FinderMediaReportObject)localObject3).origin.videoDuration = ((com.tencent.mm.plugin.sight.base.a)localObject5).videoDuration;
            ((FinderMediaReportObject)localObject3).origin.width = ((com.tencent.mm.plugin.sight.base.a)localObject5).width;
            ((FinderMediaReportObject)localObject3).origin.height = ((com.tencent.mm.plugin.sight.base.a)localObject5).height;
            ((FinderMediaReportObject)localObject3).origin.videoBitrate = ((com.tencent.mm.plugin.sight.base.a)localObject5).videoBitrate;
          }
          localObject1 = new v.b();
          ((v.b)localObject1).Jht = 0.0F;
          int n = SightVideoJNI.getMp4RotateVFS(localbmd1.url);
          j = localbmd1.qDR.width;
          k = localbmd1.qDR.height;
          int i4 = ((com.tencent.mm.plugin.sight.base.a)localObject5).width;
          int i5 = ((com.tencent.mm.plugin.sight.base.a)localObject5).height;
          if ((n == 90) || (n == 270))
          {
            j = localbmd1.qDR.height;
            k = localbmd1.qDR.width;
          }
          int i3 = ((VideoTransPara)localObject2).videoBitrate;
          localObject6 = e.b.qFJ;
          e.b.cnD();
          ad.i(TAG, "video rotate:" + n + ", width:" + j + ", height:" + k + " url " + localbmd1.url + " thumbUrl: " + localbmd1.thumbUrl + " size:" + bt.mK(com.tencent.mm.vfs.i.aMN(localbmd1.url)));
          localObject6 = localbmd1.url;
          d.g.b.k.g(localObject6, "it.url");
          if (localObject5 != null) {}
          for (float f1 = ((com.tencent.mm.plugin.sight.base.a)localObject5).getVideoDuration();; f1 = 10.0F)
          {
            float f2 = localbmd1.qDR.cUL / 1000.0F;
            d.g.b.k.g(localObject2, "videoParams");
            localObject5 = a.a((String)localObject6, j, k, f1, f2, (VideoTransPara)localObject2);
            int i2 = j;
            int i1 = k;
            n = i3;
            if (((c.a.a)localObject5).errCode == 0)
            {
              i2 = j;
              i1 = k;
              n = i3;
              if (((c.a.a)localObject5).width > 0)
              {
                i2 = j;
                i1 = k;
                n = i3;
                if (((c.a.a)localObject5).height > 0)
                {
                  i2 = j;
                  i1 = k;
                  n = i3;
                  if (((c.a.a)localObject5).bitrate > 0)
                  {
                    i2 = ((c.a.a)localObject5).width;
                    i1 = ((c.a.a)localObject5).height;
                    n = ((c.a.a)localObject5).bitrate;
                    ad.i(TAG, "video abaResult, width:" + i2 + ", height:" + i1 + ", " + n);
                  }
                }
              }
            }
            j = a(l, i, (String)localObject4, i4, i5, i2, i1, n, (VideoTransPara)localObject2, localbmd1, (FinderMediaReportObject)localObject3, (d.g.a.b)new b((v.b)localObject1, i, this, (VideoTransPara)localObject2, localList));
            bt.aS(l);
            if (j >= 0) {
              break;
            }
            a(com.tencent.mm.loader.g.h.glb);
            AppMethodBeat.o(167731);
            return;
          }
          if (((c.a.a)localObject5).qQH == null) {}
        }
      }
      try
      {
        SightVideoJNI.addReportMetadata((String)localObject4, ((c.a.a)localObject5).qQH, ((VideoTransPara)localObject2).hcj, 0);
        label1105:
        aT(1.0F);
        localObject5 = this.qQF.getMediaList();
        localObject6 = ((Iterable)localObject5).iterator();
        bmd localbmd2;
        do
        {
          if (!((Iterator)localObject6).hasNext()) {
            break;
          }
          localObject1 = ((Iterator)localObject6).next();
          localbmd2 = (bmd)localObject1;
        } while (!d.g.b.k.g(localbmd1.mediaId, localbmd2.mediaId));
        for (;;)
        {
          localObject1 = (bmd)localObject1;
          if (localObject1 == null) {
            break label1740;
          }
          d.g.b.k.h(localObject2, "videoParams");
          d.g.b.k.h(localbmd1, "localMedia");
          d.g.b.k.h(localObject4, "outputPath");
          d.g.b.k.h(localObject1, "media");
          d.g.b.k.h(localObject3, "reportObject");
          j = ((VideoTransPara)localObject2).hci;
          k = (int)(localbmd1.height / localbmd1.width * j);
          localObject6 = e.qQW;
          d.g.b.k.h(localObject4, "input");
          localObject6 = com.tencent.mm.plugin.finder.utils.k.qTp;
          localObject6 = com.tencent.mm.plugin.finder.utils.k.ZY((String)localObject4);
          ad.i(e.TAG, "genVideoThumbFileForPost input:" + (String)localObject4 + ", targetWidth:" + j + ", targetHeight:" + k + ", thumbRect:" + null + ", dstPath:" + (String)localObject6);
          localObject6 = e.a((String)localObject4, j, k, null, (String)localObject6);
          ((bmd)localObject1).DJE = ((FinderMediaReportObject)localObject3);
          ((bmd)localObject1).url = ((String)localObject4);
          ((bmd)localObject1).thumbUrl = ((String)localObject6);
          ((bmd)localObject1).DJD = false;
          ((bmd)localObject1).mediaId = ai.du(localbmd1.url);
          ((bmd)localObject1).fileSize = ((int)com.tencent.mm.vfs.i.aMN((String)localObject4));
          ((bmd)localObject1).DJE.target = new FinderMediaReportInfo();
          ((bmd)localObject1).DJE.target.fileSize = ((bmd)localObject1).fileSize;
          localObject3 = ((bmd)localObject1).LzL;
          if (localObject3 != null) {
            ((dxw)localObject3).LwV = false;
          }
          localObject3 = com.tencent.mm.plugin.sight.base.e.ano((String)localObject4);
          if (localObject3 != null)
          {
            ((bmd)localObject1).videoDuration = ((com.tencent.mm.plugin.sight.base.a)localObject3).getVideoDuration();
            ((bmd)localObject1).DJE.target.videoDuration = ((com.tencent.mm.plugin.sight.base.a)localObject3).videoDuration;
            ((bmd)localObject1).DJE.target.width = ((com.tencent.mm.plugin.sight.base.a)localObject3).width;
            ((bmd)localObject1).DJE.target.height = ((com.tencent.mm.plugin.sight.base.a)localObject3).height;
            ((bmd)localObject1).DJE.target.videoBitrate = ((com.tencent.mm.plugin.sight.base.a)localObject3).videoBitrate;
          }
          ad.i(TAG, "processList index " + i + " url " + localbmd1.url + " thumbUrl: " + localbmd1.thumbUrl + " newMd5: " + ai.du(localbmd1.url) + " size:" + bt.mK(com.tencent.mm.vfs.i.aMN(localbmd1.url)));
          this.qQF.setMediaList((LinkedList)localObject5);
          localObject1 = this.qQF.field_reportObject;
          if (localObject1 != null) {
            ((FinderFeedReportObject)localObject1).remuxEndTime = ce.asS();
          }
          ((PluginFinder)g.ad(PluginFinder.class)).getFeedStorage().a(this.qQF.getLocalId(), this.qQF);
          i = m;
          break;
          d.g.b.k.g(localObject2, "videoParams");
          if (a(l, i, (String)localObject4, (VideoTransPara)localObject2, localbmd1, (FinderMediaReportObject)localObject3) >= 0) {
            break label1105;
          }
          a(com.tencent.mm.loader.g.h.glb);
          AppMethodBeat.o(167731);
          return;
          localObject1 = null;
        }
        label1740:
        i = m;
        continue;
        a(com.tencent.mm.loader.g.h.gla);
        AppMethodBeat.o(167731);
        return;
      }
      catch (Throwable localThrowable)
      {
        break label1105;
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/upload/FinderMediaProcessTask$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "checkRemuxVideo", "", "path", "width", "height", "videoParams", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "localId", "", "convertViewRect", "Landroid/graphics/Rect;", "viewRect", "Lcom/tencent/mm/protocal/protobuf/ViewRect;", "getABAResult", "Lcom/tencent/mm/plugin/finder/upload/FinderMediaProcessTask$Companion$ABAResult;", "input", "durationSec", "", "startTimeSec", "videoTransPara", "ABAResult", "plugin-finder_release"})
  public static final class a
  {
    public static int a(String paramString, int paramInt1, int paramInt2, VideoTransPara paramVideoTransPara, long paramLong)
    {
      AppMethodBeat.i(167727);
      d.g.b.k.h(paramVideoTransPara, "videoParams");
      long l = com.tencent.mm.vfs.i.aMN(paramString);
      Object localObject = e.b.qFJ;
      e.b.qn(l);
      localObject = com.tencent.mm.plugin.finder.storage.b.qJA;
      if (l > com.tencent.mm.plugin.finder.storage.b.coF())
      {
        ad.i(c.access$getTAG$cp(), "checkRemuxVideo need remux zip");
        localObject = e.b.qFJ;
        e.b.cnF();
        l = bt.GC();
        localObject = paramString + ".remux";
        paramInt1 = SightVideoJNI.remuxingVFS(paramString, (String)localObject, paramInt1, paramInt2, paramVideoTransPara.videoBitrate, com.tencent.mm.plugin.sight.base.c.wra, 8, 2, 25.0F, paramVideoTransPara.fps, null, 0, com.tencent.mm.plugin.sight.base.c.wqZ, 0, 51);
        ad.i(c.access$getTAG$cp(), "checkRemuxVideo remux cost:" + bt.aS(l) + "ms, ret:" + paramInt1 + " localId:" + paramLong);
        paramVideoTransPara = e.b.qFJ;
        e.b.qo(bt.aS(l));
        if (paramInt1 >= 0)
        {
          com.tencent.mm.vfs.i.lD((String)localObject, paramString);
          paramLong = com.tencent.mm.vfs.i.aMN((String)localObject);
          paramString = e.b.qFJ;
          e.b.qp(paramLong);
          paramString = com.tencent.mm.plugin.finder.storage.b.qJA;
          if (paramLong > com.tencent.mm.plugin.finder.storage.b.coF())
          {
            AppMethodBeat.o(167727);
            return -3;
          }
          AppMethodBeat.o(167727);
          return 0;
        }
        paramString = e.b.qFJ;
        e.b.cnG();
        AppMethodBeat.o(167727);
        return -2;
      }
      ad.i(c.access$getTAG$cp(), "checkRemuxVideo, no need remux");
      AppMethodBeat.o(167727);
      return 0;
    }
    
    public static Rect a(dkt paramdkt)
    {
      AppMethodBeat.i(167726);
      d.g.b.k.h(paramdkt, "viewRect");
      paramdkt = new Rect(paramdkt.left, paramdkt.top, paramdkt.right, paramdkt.bottom);
      AppMethodBeat.o(167726);
      return paramdkt;
    }
    
    public static a a(String paramString, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, VideoTransPara paramVideoTransPara)
    {
      AppMethodBeat.i(167728);
      d.g.b.k.h(paramString, "input");
      d.g.b.k.h(paramVideoTransPara, "videoTransPara");
      for (;;)
      {
        try
        {
          com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.qJA;
          if (!com.tencent.mm.plugin.finder.storage.b.coE()) {
            continue;
          }
          paramString = AdaptiveAdjustBitrate.a(paramString, paramInt2, paramInt1, paramVideoTransPara.fps, paramVideoTransPara.videoBitrate, paramFloat1, paramFloat2, 4, paramVideoTransPara.hcl, paramVideoTransPara.hcm, paramVideoTransPara.hcn, paramVideoTransPara.hco, paramVideoTransPara.hcp, paramVideoTransPara.hcq);
          j = paramVideoTransPara.videoBitrate;
          i = -1;
          if ((paramString == null) || (paramString[3] <= 0)) {
            break label238;
          }
          j = paramString[0] * 1000;
          i = 0;
          ad.i(c.access$getTAG$cp(), "getABAResult use videoBitrate:".concat(String.valueOf(j)));
        }
        catch (Throwable paramString)
        {
          int j;
          label134:
          paramString = new a(-1, 0, 0, 0, null);
          AppMethodBeat.o(167728);
          return paramString;
        }
        ad.i(c.access$getTAG$cp(), "ABA:  finder video bitrate:" + j + " width: " + k + " height:" + paramInt1);
        if (o.aCJ() != null) {
          com.tencent.mm.ao.e.p(paramString);
        }
        paramString = new a(i, k, paramInt1, j, paramString);
        AppMethodBeat.o(167728);
        return paramString;
        label238:
        do
        {
          k = paramInt1;
          paramInt1 = paramInt2;
          break label134;
          if (paramString[4] > 0) {
            break;
          }
        } while ((paramString == null) || (paramString[5] <= 0));
        int k = paramString[1];
        paramInt1 = paramString[2];
        int i = 0;
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/upload/FinderMediaProcessTask$Companion$ABAResult;", "", "errCode", "", "width", "height", "bitrate", "abaParams", "", "(IIII[I)V", "getAbaParams", "()[I", "getBitrate", "()I", "getErrCode", "getHeight", "getWidth", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder_release"})
    public static final class a
    {
      public final int bitrate;
      public final int errCode;
      public final int height;
      public final int[] qQH;
      public final int width;
      
      public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
      {
        this.errCode = paramInt1;
        this.width = paramInt2;
        this.height = paramInt3;
        this.bitrate = paramInt4;
        this.qQH = paramArrayOfInt;
      }
      
      public final boolean equals(Object paramObject)
      {
        AppMethodBeat.i(167725);
        if (this != paramObject)
        {
          if ((paramObject instanceof a))
          {
            paramObject = (a)paramObject;
            if ((this.errCode != paramObject.errCode) || (this.width != paramObject.width) || (this.height != paramObject.height) || (this.bitrate != paramObject.bitrate) || (!d.g.b.k.g(this.qQH, paramObject.qQH))) {}
          }
        }
        else
        {
          AppMethodBeat.o(167725);
          return true;
        }
        AppMethodBeat.o(167725);
        return false;
      }
      
      public final int hashCode()
      {
        AppMethodBeat.i(167724);
        int j = this.errCode;
        int k = this.width;
        int m = this.height;
        int n = this.bitrate;
        int[] arrayOfInt = this.qQH;
        if (arrayOfInt != null) {}
        for (int i = Arrays.hashCode(arrayOfInt);; i = 0)
        {
          AppMethodBeat.o(167724);
          return i + (((j * 31 + k) * 31 + m) * 31 + n) * 31;
        }
      }
      
      public final String toString()
      {
        AppMethodBeat.i(167723);
        String str = "ABAResult(errCode=" + this.errCode + ", width=" + this.width + ", height=" + this.height + ", bitrate=" + this.bitrate + ", abaParams=" + Arrays.toString(this.qQH) + ")";
        AppMethodBeat.o(167723);
        return str;
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "", "invoke", "com/tencent/mm/plugin/finder/upload/FinderMediaProcessTask$call$2$2"})
  static final class b
    extends d.g.b.l
    implements d.g.a.b<Float, y>
  {
    b(v.b paramb, int paramInt, c paramc, VideoTransPara paramVideoTransPara, List paramList)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.b<Float, y>
  {
    c(c paramc)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "result", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.b<Boolean, y>
  {
    d(c paramc, v.c paramc1, int paramInt, FinderMediaReportObject paramFinderMediaReportObject, long paramLong, String paramString, dxx paramdxx, VideoTransPara paramVideoTransPara, dxw paramdxw, Object paramObject, v.a parama)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.b<Float, y>
  {
    e(d.g.a.b paramb)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.b<String, y>
  {
    f(c paramc, v.c paramc1, int paramInt1, FinderMediaReportObject paramFinderMediaReportObject, long paramLong, int paramInt2, int paramInt3, VideoTransPara paramVideoTransPara, Object paramObject, v.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.c
 * JD-Core Version:    0.7.0.1
 */