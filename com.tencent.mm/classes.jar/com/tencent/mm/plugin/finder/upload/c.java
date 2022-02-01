package com.tencent.mm.plugin.finder.upload;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.e;
import com.tencent.mm.g.a.hd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cf;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.report.n.b;
import com.tencent.mm.plugin.finder.report.n.c;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker.a;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.protocal.protobuf.FinderMediaReportInfo;
import com.tencent.mm.protocal.protobuf.FinderMediaReportObject;
import com.tencent.mm.protocal.protobuf.aam;
import com.tencent.mm.protocal.protobuf.aan;
import com.tencent.mm.protocal.protobuf.aao;
import com.tencent.mm.protocal.protobuf.acd;
import com.tencent.mm.protocal.protobuf.apb;
import com.tencent.mm.protocal.protobuf.bvf;
import com.tencent.mm.protocal.protobuf.bvg;
import com.tencent.mm.protocal.protobuf.bvp;
import com.tencent.mm.protocal.protobuf.cse;
import com.tencent.mm.protocal.protobuf.dom;
import com.tencent.mm.protocal.protobuf.dpu;
import com.tencent.mm.protocal.protobuf.dwe;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.q;
import d.g.b.y.a;
import d.g.b.y.c;
import d.g.b.y.d;
import d.z;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/upload/FinderMediaProcessTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "finderObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "getFinderObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFinderObj", "call", "", "exportMedia", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "remuxComposition", "Lkotlin/Pair;", "", "", "startRemuxerTick", "", "index", "outputPath", "", "videoParams", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "mediaReportObject", "Lcom/tencent/mm/protocal/protobuf/FinderMediaReportObject;", "remuxNormalVideo", "videoWidth", "videoHeight", "width", "height", "bitrate", "localFinderMedia", "musicPath", "mixType", "onUpdateProgress", "Lkotlin/Function1;", "uniqueId", "updateMedia", "localMedia", "reportObject", "audioQuality", "videoQuality", "updateProgress", "avgProgress", "Companion", "plugin-finder_release"})
public final class c
  extends com.tencent.mm.loader.g.c
{
  private static final String TAG = "Finder.LogPost.FinderMediaProcessTask";
  public static final a sIG;
  FinderItem sIF;
  
  static
  {
    AppMethodBeat.i(167735);
    sIG = new a((byte)0);
    TAG = "Finder.LogPost.FinderMediaProcessTask";
    AppMethodBeat.o(167735);
  }
  
  public c(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(167734);
    this.sIF = paramFinderItem;
    AppMethodBeat.o(167734);
  }
  
  /* Error */
  private final int a(final long paramLong, final int paramInt1, String paramString1, int paramInt2, int paramInt3, int paramInt4, final int paramInt5, int paramInt6, final VideoTransPara paramVideoTransPara, bvf parambvf, final FinderMediaReportObject paramFinderMediaReportObject, String paramString2, int paramInt7, d.g.a.b<? super Float, z> paramb)
  {
    // Byte code:
    //   0: ldc 113
    //   2: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 115	d/g/b/y$d
    //   8: dup
    //   9: invokespecial 116	d/g/b/y$d:<init>	()V
    //   12: astore 16
    //   14: aload 16
    //   16: iconst_m1
    //   17: putfield 120	d/g/b/y$d:MLT	I
    //   20: new 122	java/lang/Object
    //   23: dup
    //   24: invokespecial 123	java/lang/Object:<init>	()V
    //   27: astore 17
    //   29: new 125	d/g/b/y$a
    //   32: dup
    //   33: invokespecial 126	d/g/b/y$a:<init>	()V
    //   36: astore 18
    //   38: aload 18
    //   40: iconst_0
    //   41: putfield 130	d/g/b/y$a:MLQ	Z
    //   44: aload 11
    //   46: getfield 135	com/tencent/mm/protocal/protobuf/bvf:url	Ljava/lang/String;
    //   49: astore 19
    //   51: aload 19
    //   53: ldc 137
    //   55: invokestatic 140	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   58: aload 11
    //   60: getfield 144	com/tencent/mm/protocal/protobuf/bvf:skC	Lcom/tencent/mm/protocal/protobuf/bvp;
    //   63: getfield 150	com/tencent/mm/protocal/protobuf/bvp:GPL	Lcom/tencent/mm/protocal/protobuf/dwe;
    //   66: astore 20
    //   68: aload 20
    //   70: ldc 152
    //   72: invokestatic 140	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   75: new 154	com/tencent/mm/plugin/finder/video/l
    //   78: dup
    //   79: aload 13
    //   81: aload 19
    //   83: iload 14
    //   85: aload 4
    //   87: aload 20
    //   89: invokestatic 157	com/tencent/mm/plugin/finder/upload/c$a:a	(Lcom/tencent/mm/protocal/protobuf/dwe;)Landroid/graphics/Rect;
    //   92: iload 7
    //   94: iload 8
    //   96: iload 9
    //   98: aload 10
    //   100: getfield 162	com/tencent/mm/modelcontrol/VideoTransPara:audioBitrate	I
    //   103: aload 10
    //   105: getfield 165	com/tencent/mm/modelcontrol/VideoTransPara:audioSampleRate	I
    //   108: aload 10
    //   110: getfield 168	com/tencent/mm/modelcontrol/VideoTransPara:audioChannelCount	I
    //   113: aload 10
    //   115: getfield 171	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   118: aload 11
    //   120: getfield 144	com/tencent/mm/protocal/protobuf/bvf:skC	Lcom/tencent/mm/protocal/protobuf/bvp;
    //   123: getfield 174	com/tencent/mm/protocal/protobuf/bvp:ddx	I
    //   126: i2l
    //   127: aload 11
    //   129: getfield 144	com/tencent/mm/protocal/protobuf/bvf:skC	Lcom/tencent/mm/protocal/protobuf/bvp;
    //   132: getfield 177	com/tencent/mm/protocal/protobuf/bvp:htQ	I
    //   135: i2l
    //   136: aload 10
    //   138: getfield 180	com/tencent/mm/modelcontrol/VideoTransPara:hmx	I
    //   141: new 17	com/tencent/mm/plugin/finder/upload/c$e
    //   144: dup
    //   145: aload 15
    //   147: invokespecial 183	com/tencent/mm/plugin/finder/upload/c$e:<init>	(Ld/g/a/b;)V
    //   150: checkcast 185	d/g/a/b
    //   153: new 19	com/tencent/mm/plugin/finder/upload/c$f
    //   156: dup
    //   157: aload_0
    //   158: aload 16
    //   160: iload_3
    //   161: aload 12
    //   163: lload_1
    //   164: iload 7
    //   166: iload 8
    //   168: aload 10
    //   170: aload 17
    //   172: aload 18
    //   174: invokespecial 188	com/tencent/mm/plugin/finder/upload/c$f:<init>	(Lcom/tencent/mm/plugin/finder/upload/c;Ld/g/b/y$d;ILcom/tencent/mm/protocal/protobuf/FinderMediaReportObject;JIILcom/tencent/mm/modelcontrol/VideoTransPara;Ljava/lang/Object;Ld/g/b/y$a;)V
    //   177: checkcast 185	d/g/a/b
    //   180: iload 5
    //   182: iload 6
    //   184: invokespecial 191	com/tencent/mm/plugin/finder/video/l:<init>	(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Landroid/graphics/Rect;IIIIIIIJJILd/g/a/b;Ld/g/a/b;II)V
    //   187: astore 4
    //   189: aload 4
    //   191: invokevirtual 195	com/tencent/mm/plugin/finder/video/l:atP	()I
    //   194: pop
    //   195: aload 17
    //   197: monitorenter
    //   198: aload 18
    //   200: getfield 130	d/g/b/y$a:MLQ	Z
    //   203: ifne +58 -> 261
    //   206: getstatic 93	com/tencent/mm/plugin/finder/upload/c:TAG	Ljava/lang/String;
    //   209: ldc 197
    //   211: iload_3
    //   212: invokestatic 203	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   215: invokevirtual 207	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   218: invokestatic 212	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   221: aload 17
    //   223: invokevirtual 215	java/lang/Object:wait	()V
    //   226: getstatic 93	com/tencent/mm/plugin/finder/upload/c:TAG	Ljava/lang/String;
    //   229: new 217	java/lang/StringBuilder
    //   232: dup
    //   233: ldc 219
    //   235: invokespecial 222	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   238: iload_3
    //   239: invokevirtual 226	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   242: ldc 228
    //   244: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: aload 16
    //   249: getfield 120	d/g/b/y$d:MLT	I
    //   252: invokevirtual 226	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   255: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: invokestatic 212	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   261: getstatic 241	d/z:MKo	Ld/z;
    //   264: astore 4
    //   266: aload 17
    //   268: monitorexit
    //   269: aload 16
    //   271: getfield 120	d/g/b/y$d:MLT	I
    //   274: istore_3
    //   275: ldc 113
    //   277: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   280: iload_3
    //   281: ireturn
    //   282: astore 4
    //   284: getstatic 93	com/tencent/mm/plugin/finder/upload/c:TAG	Ljava/lang/String;
    //   287: aload 4
    //   289: ldc 243
    //   291: iconst_0
    //   292: anewarray 122	java/lang/Object
    //   295: invokestatic 247	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   298: getstatic 253	com/tencent/mm/plugin/finder/report/n$b:sqe	Lcom/tencent/mm/plugin/finder/report/n$b;
    //   301: astore 4
    //   303: invokestatic 256	com/tencent/mm/plugin/finder/report/n$b:cDH	()V
    //   306: aload_0
    //   307: getstatic 262	com/tencent/mm/loader/g/j:hfL	Lcom/tencent/mm/loader/g/j;
    //   310: invokevirtual 265	com/tencent/mm/plugin/finder/upload/c:a	(Lcom/tencent/mm/loader/g/j;)V
    //   313: aload 16
    //   315: getfield 120	d/g/b/y$d:MLT	I
    //   318: istore_3
    //   319: ldc 113
    //   321: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   324: iload_3
    //   325: ireturn
    //   326: astore 4
    //   328: aload 17
    //   330: monitorexit
    //   331: ldc 113
    //   333: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   336: aload 4
    //   338: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	339	0	this	c
    //   0	339	1	paramLong	long
    //   0	339	3	paramInt1	int
    //   0	339	4	paramString1	String
    //   0	339	5	paramInt2	int
    //   0	339	6	paramInt3	int
    //   0	339	7	paramInt4	int
    //   0	339	8	paramInt5	int
    //   0	339	9	paramInt6	int
    //   0	339	10	paramVideoTransPara	VideoTransPara
    //   0	339	11	parambvf	bvf
    //   0	339	12	paramFinderMediaReportObject	FinderMediaReportObject
    //   0	339	13	paramString2	String
    //   0	339	14	paramInt7	int
    //   0	339	15	paramb	d.g.a.b<? super Float, z>
    //   12	302	16	locald	y.d
    //   27	302	17	localObject	Object
    //   36	163	18	locala	y.a
    //   49	33	19	str	String
    //   66	22	20	localdwe	dwe
    // Exception table:
    //   from	to	target	type
    //   44	189	282	java/lang/Throwable
    //   198	261	326	finally
    //   261	266	326	finally
  }
  
  private final d.o<Integer, Float> a(final long paramLong, final int paramInt, String paramString, final VideoTransPara paramVideoTransPara, final bvf parambvf, final FinderMediaReportObject paramFinderMediaReportObject)
  {
    AppMethodBeat.i(204327);
    ad.i(TAG, "remuxComposition outputPath:".concat(String.valueOf(paramString)));
    final aan localaan = parambvf.GPu;
    final y.d locald = new y.d();
    locald.MLT = -1;
    final aao localaao = localaan.BEZ;
    localaao.pSc = paramString;
    final Object localObject = new Object();
    final y.a locala = new y.a();
    locala.MLQ = false;
    com.tencent.mm.plugin.vlog.model.d locald1 = new com.tencent.mm.plugin.vlog.model.d();
    locald1.retryCount = parambvf.skC.retryCount;
    locald1.vCC = true;
    parambvf = com.tencent.mm.plugin.finder.storage.b.sxa;
    if (com.tencent.mm.plugin.finder.storage.b.cFa()) {
      locald1.r(paramVideoTransPara);
    }
    parambvf = new y.c();
    parambvf.MLS = 0.0F;
    parambvf = (d.g.a.b)new c(this, parambvf);
    d.g.b.p.h(parambvf, "callback");
    locald1.BEV = parambvf;
    d.g.b.p.g(localaan, "videoCompositionInfo");
    float f = locald1.a(localaan, (d.g.a.b)new d(this, locald, paramInt, paramFinderMediaReportObject, paramLong, paramString, localaao, paramVideoTransPara, localaan, localObject, locala));
    try
    {
      if (!locala.MLQ)
      {
        ad.i(TAG, "wait ".concat(String.valueOf(paramInt)));
        localObject.wait();
        ad.i(TAG, "notify " + paramInt + ", " + locald.MLT);
      }
      paramString = z.MKo;
      paramString = new d.o(Integer.valueOf(locald.MLT), Float.valueOf(f));
      AppMethodBeat.o(204327);
      return paramString;
    }
    finally
    {
      AppMethodBeat.o(204327);
    }
  }
  
  public final String aeK()
  {
    AppMethodBeat.i(167732);
    long l = this.sIF.getLocalId();
    AppMethodBeat.o(167732);
    return String.valueOf(l);
  }
  
  public final void bc(float paramFloat)
  {
    AppMethodBeat.i(167733);
    float f = paramFloat;
    if (paramFloat > 1.0F) {
      f = 1.0F;
    }
    Object localObject = com.tencent.mm.plugin.finder.storage.b.sxa;
    int i = (int)(com.tencent.mm.plugin.finder.storage.b.cFv() * f);
    ad.i(TAG, "feed " + this.sIF.getLocalId() + " updateProgress  " + f + ", " + i);
    if (this.sIF.getPostInfo().GPz < i)
    {
      this.sIF.getPostInfo().GPz = i;
      localObject = com.tencent.mm.plugin.finder.storage.logic.b.sAs;
      com.tencent.mm.plugin.finder.storage.logic.b.a.i(this.sIF);
    }
    localObject = com.tencent.mm.sdk.b.a.IbL;
    hd localhd = new hd();
    localhd.dty.dnz = this.sIF.getLocalId();
    localhd.dty.progress = this.sIF.getPostInfo().GPz;
    ((com.tencent.mm.sdk.b.a)localObject).l((com.tencent.mm.sdk.b.b)localhd);
    AppMethodBeat.o(167733);
  }
  
  public final void call()
  {
    AppMethodBeat.i(167731);
    this.sIF.trackPost("mediaProcess");
    Object localObject1 = this.sIF.field_reportObject;
    if (localObject1 != null) {
      ((FinderFeedReportObject)localObject1).postStage = 2;
    }
    Object localObject5 = (List)new ArrayList();
    localObject1 = (Iterable)this.sIF.getMediaList();
    int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = ((Iterator)localObject1).next();
      if (i < 0) {
        d.a.j.gfB();
      }
      localObject3 = (bvf)localObject3;
      if ((this.sIF.isNeedCrop(i)) && (this.sIF.getCropInfo(i) != null)) {
        ((List)localObject5).add(localObject3);
      }
      if ((this.sIF.isNeedVideoCompositionPlay(i)) && (this.sIF.getCropInfo(i) != null)) {
        ((List)localObject5).add(localObject3);
      }
      i += 1;
    }
    localObject1 = com.tencent.mm.plugin.finder.storage.b.sxa;
    if ((com.tencent.mm.plugin.finder.storage.b.cFx()) && (ad.getLogLevel() >= 0))
    {
      ad.i(TAG, "debug blocking, sleep.....");
      Thread.sleep(30000L);
    }
    if (((List)localObject5).size() <= 0)
    {
      ad.i(TAG, "nothing need to be processed");
      bc(1.0F);
      a(com.tencent.mm.loader.g.j.hfK);
      AppMethodBeat.o(167731);
      return;
    }
    ad.i(TAG, "process media count " + ((List)localObject5).size());
    localObject1 = n.c.sqy;
    n.c.cDQ();
    localObject1 = com.tencent.mm.plugin.finder.storage.b.sxa;
    final VideoTransPara localVideoTransPara = com.tencent.mm.plugin.finder.storage.b.cEY();
    ad.i(TAG, "FinderMediaProcessTask videoParams ".concat(String.valueOf(localVideoTransPara)));
    Iterator localIterator = ((Iterable)localObject5).iterator();
    final int j = 0;
    int m;
    bvf localbvf;
    boolean bool4;
    Object localObject6;
    Object localObject7;
    Object localObject4;
    long l;
    int n;
    int i1;
    int i2;
    int i3;
    label845:
    label989:
    label1014:
    boolean bool3;
    label921:
    Object localObject8;
    label1048:
    label1121:
    boolean bool2;
    label1182:
    float f3;
    float f4;
    int i7;
    boolean bool5;
    float f1;
    float f2;
    int k;
    label1376:
    boolean bool1;
    if (localIterator.hasNext())
    {
      localObject1 = localIterator.next();
      m = j + 1;
      if (j < 0) {
        d.a.j.gfB();
      }
      localbvf = (bvf)localObject1;
      i = localbvf.skC.retryCount;
      localObject1 = com.tencent.mm.plugin.finder.storage.b.sxa;
      if (i > com.tencent.mm.plugin.finder.storage.b.cFt())
      {
        a(com.tencent.mm.loader.g.j.hfL);
        AppMethodBeat.o(167731);
        return;
      }
      localObject1 = localbvf.skC;
      ((bvp)localObject1).retryCount += 1;
      localObject1 = com.tencent.mm.plugin.finder.storage.logic.b.sAs;
      com.tencent.mm.plugin.finder.storage.logic.b.a.i(this.sIF);
      localObject1 = com.tencent.mm.plugin.finder.utils.p.sMo;
      bool4 = com.tencent.mm.plugin.finder.utils.p.d(localbvf);
      localObject6 = new FinderMediaReportObject();
      ((FinderMediaReportObject)localObject6).mediaType = localbvf.mediaType;
      ((FinderMediaReportObject)localObject6).origin = new FinderMediaReportInfo();
      ((FinderMediaReportObject)localObject6).multiMediaInfo = new LinkedList();
      localObject1 = localbvf.GPu;
      if (localObject1 != null)
      {
        localObject1 = ((aan)localObject1).FZu;
        if (localObject1 != null)
        {
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject7 = (dom)((Iterator)localObject1).next();
            localObject3 = new FinderMediaReportInfo();
            ((FinderMediaReportInfo)localObject3).fileSize = ((int)com.tencent.mm.vfs.i.aYo(((dom)localObject7).path));
            localObject4 = MultiMediaVideoChecker.BFV;
            localObject7 = ((dom)localObject7).path;
            d.g.b.p.g(localObject7, "track.path");
            localObject4 = ((MultiMediaVideoChecker)localObject4).aDk((String)localObject7);
            if (localObject4 != null)
            {
              ((FinderMediaReportInfo)localObject3).width = ((MultiMediaVideoChecker.a)localObject4).width;
              ((FinderMediaReportInfo)localObject3).height = ((MultiMediaVideoChecker.a)localObject4).height;
              ((FinderMediaReportInfo)localObject3).videoBitrate = ((MultiMediaVideoChecker.a)localObject4).bitrate;
              ((FinderMediaReportInfo)localObject3).videoDuration = ((int)((MultiMediaVideoChecker.a)localObject4).duration);
              ((FinderMediaReportInfo)localObject3).audioBitrate = ((MultiMediaVideoChecker.a)localObject4).audioBitrate;
              ((FinderMediaReportInfo)localObject3).fps = ((int)((MultiMediaVideoChecker.a)localObject4).cvL);
              ad.i(TAG, "put multiMediaInfo:".concat(String.valueOf(localObject4)));
              localObject4 = z.MKo;
            }
            ((FinderMediaReportObject)localObject6).multiMediaInfo.add(localObject3);
          }
          localObject1 = z.MKo;
        }
      }
      l = bt.HI();
      localObject1 = new m(localbvf, com.tencent.mm.plugin.finder.storage.r.syQ, 0, null, 12);
      localObject3 = com.tencent.mm.plugin.finder.utils.r.sNc;
      localObject7 = com.tencent.mm.plugin.finder.utils.r.a((m)localObject1, String.valueOf(this.sIF.getCreateTime()));
      localObject4 = null;
      n = 1;
      i1 = 2;
      i2 = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qAV, 0);
      i3 = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qHH, 1);
      localObject1 = localbvf.GPu;
      if (localObject1 != null)
      {
        localObject1 = ((aan)localObject1).FZu;
        if (localObject1 != null)
        {
          localObject1 = (dom)d.a.j.jd((List)localObject1);
          localObject3 = localbvf.GPu;
          if (localObject3 == null) {
            break label3205;
          }
          localObject3 = ((aan)localObject3).FZu;
          if ((localObject3 == null) || (((LinkedList)localObject3).size() != 1)) {
            break label3205;
          }
          localObject3 = localbvf.GPu;
          if (localObject3 == null) {
            break label3187;
          }
          localObject3 = ((aan)localObject3).BFa;
          if (localObject3 == null) {
            break label3187;
          }
          localObject3 = ((aam)localObject3).FZr;
          if (localObject3 == null) {
            break label3187;
          }
          i = ((LinkedList)localObject3).size();
          if (i != 0) {
            break label3205;
          }
          localObject3 = localbvf.GPu;
          if ((localObject3 == null) || (((aan)localObject3).BGn) || (localbvf.GPu.FZz != null) || (localObject1 == null)) {
            break label3205;
          }
          if (((dom)localObject1).HCX != null)
          {
            localObject3 = ((dom)localObject1).HCX;
            if (localObject3 == null) {
              break label3193;
            }
            localObject3 = ((dpu)localObject3).path;
            localObject3 = (CharSequence)localObject3;
            if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
              break label3199;
            }
            i = 1;
            if (i == 0) {
              break label3205;
            }
          }
          if (((dom)localObject1).hiy - ((dom)localObject1).startTimeMs != ((dom)localObject1).HCV - ((dom)localObject1).HCU) {
            break label3205;
          }
          bool3 = true;
          localObject3 = TAG;
          localObject8 = new StringBuilder("process: config: ").append(i2).append(", checkNoNeedRemux:").append(i3).append(", trackSize: ");
          localObject1 = localbvf.GPu;
          if (localObject1 == null) {
            break label3211;
          }
          localObject1 = ((aan)localObject1).FZu;
          if (localObject1 == null) {
            break label3211;
          }
          localObject1 = Integer.valueOf(((LinkedList)localObject1).size());
          localObject8 = ((StringBuilder)localObject8).append(localObject1).append(", editSize: ");
          localObject1 = localbvf.GPu;
          if (localObject1 == null) {
            break label3217;
          }
          localObject1 = ((aan)localObject1).BFa;
          if (localObject1 == null) {
            break label3217;
          }
          localObject1 = ((aam)localObject1).FZr;
          if (localObject1 == null) {
            break label3217;
          }
          localObject1 = Integer.valueOf(((LinkedList)localObject1).size());
          ad.i((String)localObject3, localObject1 + ", videoIsNoEffect:" + bool3);
          bool2 = false;
          if (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qDq, 0) == 1) {
            bool2 = true;
          }
          f3 = localVideoTransPara.audioBitrate / 1000.0F;
          f4 = localVideoTransPara.audioSampleRate;
          i7 = localVideoTransPara.audioChannelCount;
          bool5 = localbvf.GPu.BGm;
          f1 = 0.0F;
          f2 = 0.0F;
          k = i1;
          label1408:
          Object localObject9;
          if (i3 == 1)
          {
            k = i1;
            if (bool3)
            {
              localObject1 = (dom)localbvf.GPu.FZu.get(0);
              localObject3 = MultiMediaVideoChecker.BFV;
              localObject8 = ((dom)localObject1).path;
              d.g.b.p.g(localObject8, "track.path");
              localObject3 = ((MultiMediaVideoChecker)localObject3).aDk((String)localObject8);
              if (localObject3 == null) {
                break label3249;
              }
              if ((((MultiMediaVideoChecker.a)localObject3).dGc != 90) && (((MultiMediaVideoChecker.a)localObject3).dGc != 270)) {
                break label3223;
              }
              i = ((MultiMediaVideoChecker.a)localObject3).height;
              double d = i;
              if ((((MultiMediaVideoChecker.a)localObject3).dGc != 90) && (((MultiMediaVideoChecker.a)localObject3).dGc != 270)) {
                break label3233;
              }
              i = ((MultiMediaVideoChecker.a)localObject3).width;
              d = 1.0D * d / i;
              ad.i(TAG, "origin videoInfo:" + localObject3 + ", videoParams:" + localVideoTransPara + ", videoRatio:" + d);
              localObject8 = TAG;
              localObject9 = new StringBuilder("videoRatio in range:");
              com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sxa;
              localObject9 = ((StringBuilder)localObject9).append(com.tencent.mm.plugin.finder.storage.b.cHK().contains((Comparable)Double.valueOf(d))).append(", finderVideoRatioRange:");
              localb = com.tencent.mm.plugin.finder.storage.b.sxa;
              ad.i((String)localObject8, com.tencent.mm.plugin.finder.storage.b.cHK());
              if ((((MultiMediaVideoChecker.a)localObject3).vTf) || (((MultiMediaVideoChecker.a)localObject3).bitrate > localVideoTransPara.videoBitrate) || (((MultiMediaVideoChecker.a)localObject3).cvL > localVideoTransPara.fps)) {
                break label3243;
              }
              localObject3 = com.tencent.mm.plugin.finder.storage.b.sxa;
              if (!com.tencent.mm.plugin.finder.storage.b.cHK().contains((Comparable)Double.valueOf(d))) {
                break label3243;
              }
              bool1 = true;
              label1594:
              ad.i(TAG, "isVideoSizeMatch:".concat(String.valueOf(bool1)));
              k = i1;
              if (bool1)
              {
                localObject3 = new Rect();
                localObject8 = new Rect();
                localObject9 = ((dom)localObject1).HCW.GbI;
                d.g.b.p.g(localObject9, "track.cropInfo.cropRect");
                com.tencent.mm.plugin.vlog.model.f.a((cse)localObject9, (Rect)localObject3);
                localObject9 = ((dom)localObject1).HCW.GbK;
                d.g.b.p.g(localObject9, "track.cropInfo.contentRect");
                com.tencent.mm.plugin.vlog.model.f.a((cse)localObject9, (Rect)localObject8);
                ad.i(TAG, "cropRect:" + localObject3 + ", contentRect:" + localObject8 + ", track:[" + ((dom)localObject1).HCU + ", " + ((dom)localObject1).HCV + ", " + ((dom)localObject1).BMD + ']');
                k = i1;
                if (((dom)localObject1).HCU == 0L)
                {
                  k = i1;
                  if (((dom)localObject1).BMD - ((dom)localObject1).HCV <= 10L)
                  {
                    k = i1;
                    if (((dom)localObject1).BMD <= localVideoTransPara.duration * 1000)
                    {
                      k = i1;
                      if (d.g.b.p.i(localObject3, localObject8))
                      {
                        ad.i(TAG, "no need remux!!!");
                        k = 3;
                        com.tencent.mm.vfs.i.mz(((dom)localObject1).path, (String)localObject7);
                        localObject1 = n.b.sqe;
                        n.b.cDJ();
                      }
                    }
                  }
                }
              }
            }
          }
          i = k;
          if (k == 3) {
            break label4262;
          }
          bool1 = false;
          localObject1 = (dom)localbvf.GPu.FZu.get(0);
          if (bool3)
          {
            localObject3 = new Rect();
            localObject8 = new Rect();
            localObject9 = ((dom)localObject1).HCW.GbI;
            d.g.b.p.g(localObject9, "track.cropInfo.cropRect");
            com.tencent.mm.plugin.vlog.model.f.a((cse)localObject9, (Rect)localObject3);
            localObject9 = ((dom)localObject1).HCW.GbK;
            d.g.b.p.g(localObject9, "track.cropInfo.contentRect");
            com.tencent.mm.plugin.vlog.model.f.a((cse)localObject9, (Rect)localObject8);
            bool1 = ((Rect)localObject8).contains((Rect)localObject3);
            ad.i(TAG, "process: crop: " + localObject3 + ", content: " + localObject8);
          }
          if ((i2 != 1) || (!bool3) || (!bool1)) {
            break label5610;
          }
          ad.i(TAG, "process, force use normal video");
          i = SightVideoJNI.getMp4RotateVFS(((dom)localObject1).path);
          localbvf.skC.ddx = ((int)(localbvf.GPu.FZv + ((dom)localObject1).HCU));
          localbvf.skC.htQ = ((int)(localbvf.GPu.FZw + ((dom)localObject1).HCU));
          f1 = ((dom)localObject1).BGr;
          f2 = ((dom)localObject1).BGt;
          n = ((Number)((dom)localObject1).HCW.GbK.GSD.get(2)).intValue();
          localObject3 = ((dom)localObject1).HCW.GbK.GSD.get(0);
          d.g.b.p.g(localObject3, "track.cropInfo.contentRect.values[0]");
          f1 = 1.0F * (f1 * f2) / (n - ((Number)localObject3).intValue());
          localObject3 = new dwe();
          n = ((Number)((dom)localObject1).HCW.GbI.GSD.get(0)).intValue();
          localObject4 = ((dom)localObject1).HCW.GbK.GSD.get(0);
          d.g.b.p.g(localObject4, "track.cropInfo.contentRect.values[0]");
          ((dwe)localObject3).left = ((int)((n - ((Number)localObject4).intValue()) * f1));
          n = ((Number)((dom)localObject1).HCW.GbI.GSD.get(1)).intValue();
          localObject4 = ((dom)localObject1).HCW.GbK.GSD.get(1);
          d.g.b.p.g(localObject4, "track.cropInfo.contentRect.values[1]");
          ((dwe)localObject3).bottom = ((int)((n - ((Number)localObject4).intValue()) * f1));
          n = ((Number)((dom)localObject1).HCW.GbI.GSD.get(2)).intValue();
          localObject4 = ((dom)localObject1).HCW.GbK.GSD.get(0);
          d.g.b.p.g(localObject4, "track.cropInfo.contentRect.values[0]");
          ((dwe)localObject3).right = ((int)((n - ((Number)localObject4).intValue()) * f1));
          n = ((Number)((dom)localObject1).HCW.GbI.GSD.get(3)).intValue();
          localObject4 = ((dom)localObject1).HCW.GbK.GSD.get(1);
          d.g.b.p.g(localObject4, "track.cropInfo.contentRect.values[1]");
          ((dwe)localObject3).top = ((int)((n - ((Number)localObject4).intValue()) * f1));
          localObject4 = z.MKo;
          localbvf.skC.GPL = ((dwe)localObject3);
          n = ((Number)((dom)localObject1).HCW.GbK.GSD.get(2)).intValue();
          localObject4 = ((dom)localObject1).HCW.GbK.GSD.get(0);
          d.g.b.p.g(localObject4, "track.cropInfo.contentRect.values[0]");
          n = (int)((n - ((Number)localObject4).intValue()) * f1);
          i1 = ((Number)((dom)localObject1).HCW.GbK.GSD.get(3)).intValue();
          localObject4 = ((dom)localObject1).HCW.GbK.GSD.get(1);
          d.g.b.p.g(localObject4, "track.cropInfo.contentRect.values[1]");
          i1 = (int)((i1 - ((Number)localObject4).intValue()) * f1);
          f2 = (localbvf.skC.GPL.right - localbvf.skC.GPL.left) * 1.0F / localbvf.GPu.BEZ.targetWidth;
          f1 = f2;
          if (f2 > 1.0F) {
            f1 = 1.0F;
          }
          localbvf.skC.width = ((int)(localbvf.GPu.BEZ.targetWidth * f1));
          localbvf.skC.height = ((int)(f1 * localbvf.GPu.BEZ.targetHeight));
          if (i != 90) {
            break label3255;
          }
          localObject4 = new dwe();
          ((dwe)localObject4).left = ((dwe)localObject3).bottom;
          ((dwe)localObject4).top = ((dwe)localObject3).right;
          ((dwe)localObject4).right = ((dwe)localObject3).top;
          ((dwe)localObject4).bottom = ((dwe)localObject3).left;
          localbvf.skC.GPL = ((dwe)localObject4);
          label2773:
          localbvf.url = ((dom)localObject1).path;
          localObject1 = localbvf.GPu.hml;
          bool1 = localbvf.GPu.BGm;
          if (bt.isNullOrNil((String)localObject1)) {
            break label3419;
          }
          i = 1;
          label2814:
          if (!bool1) {
            break label3431;
          }
          if (i == 0) {
            break label3425;
          }
          i = 3;
          label2827:
          ad.i(TAG, "process, time: [" + localbvf.skC.ddx + ", " + localbvf.skC.htQ + "], size: [" + localbvf.skC.width + ", " + localbvf.skC.height + "], crop: [" + localbvf.skC.GPL.left + ", " + localbvf.skC.GPL.top + ", " + localbvf.skC.GPL.right + ", " + localbvf.skC.GPL.bottom + "], mixType: " + i);
          bool1 = true;
          n = i;
        }
      }
    }
    for (;;)
    {
      label3187:
      label3193:
      label3199:
      int i5;
      label3205:
      label3211:
      label3217:
      label3223:
      label3233:
      label3243:
      label3249:
      label3255:
      label3419:
      label3425:
      label3431:
      int i4;
      if (bool1)
      {
        ((FinderMediaReportObject)localObject6).origin.fileSize = ((int)com.tencent.mm.vfs.i.aYo(localbvf.url));
        localObject3 = MultiMediaVideoChecker.BFV;
        localObject4 = localbvf.url;
        d.g.b.p.g(localObject4, "it.url");
        localObject4 = ((MultiMediaVideoChecker)localObject3).aDk((String)localObject4);
        i1 = 0;
        i2 = 0;
        if (localObject4 != null)
        {
          ((FinderMediaReportObject)localObject6).origin.videoDuration = ((int)((MultiMediaVideoChecker.a)localObject4).duration);
          ((FinderMediaReportObject)localObject6).origin.width = ((MultiMediaVideoChecker.a)localObject4).width;
          ((FinderMediaReportObject)localObject6).origin.height = ((MultiMediaVideoChecker.a)localObject4).height;
          ((FinderMediaReportObject)localObject6).origin.videoBitrate = ((MultiMediaVideoChecker.a)localObject4).bitrate;
          ((FinderMediaReportObject)localObject6).origin.audioBitrate = ((MultiMediaVideoChecker.a)localObject4).audioBitrate;
          ((FinderMediaReportObject)localObject6).origin.fps = ((int)((MultiMediaVideoChecker.a)localObject4).cvL);
          i1 = ((MultiMediaVideoChecker.a)localObject4).width;
          i2 = ((MultiMediaVideoChecker.a)localObject4).height;
          localObject3 = z.MKo;
        }
        if (localObject4 == null)
        {
          a(com.tencent.mm.loader.g.j.hfL);
          AppMethodBeat.o(167731);
          return;
          localObject1 = null;
          break label845;
          i = 0;
          break label921;
          localObject3 = null;
          break label989;
          i = 0;
          break label1014;
          bool3 = false;
          break label1048;
          localObject1 = null;
          break label1121;
          localObject1 = null;
          break label1182;
          i = ((MultiMediaVideoChecker.a)localObject3).width;
          break label1376;
          i = ((MultiMediaVideoChecker.a)localObject3).height;
          break label1408;
          bool1 = false;
          break label1594;
          bool1 = false;
          break label1594;
          if (i == 180)
          {
            localObject4 = new dwe();
            ((dwe)localObject4).left = (n - ((dwe)localObject3).right);
            ((dwe)localObject4).top = (i1 - ((dwe)localObject3).bottom);
            ((dwe)localObject4).right = (n - ((dwe)localObject3).left);
            ((dwe)localObject4).bottom = (i1 - ((dwe)localObject3).top);
            localbvf.skC.GPL = ((dwe)localObject4);
            break label2773;
          }
          if (i != 270) {
            break label2773;
          }
          localObject4 = new dwe();
          ((dwe)localObject4).left = (i1 - ((dwe)localObject3).top);
          ((dwe)localObject4).top = (n - ((dwe)localObject3).left);
          ((dwe)localObject4).right = (i1 - ((dwe)localObject3).bottom);
          ((dwe)localObject4).bottom = (n - ((dwe)localObject3).right);
          localbvf.skC.GPL = ((dwe)localObject4);
          break label2773;
          i = 0;
          break label2814;
          i = 1;
          break label2827;
          if (i != 0)
          {
            i = 2;
            break label2827;
          }
          i = 0;
          break label2827;
        }
        localObject3 = new y.c();
        ((y.c)localObject3).MLS = 0.0F;
        i3 = SightVideoJNI.getMp4RotateVFS(localbvf.url);
        i = localbvf.skC.width;
        k = localbvf.skC.height;
        if ((i3 == 90) || (i3 == 270))
        {
          i = localbvf.skC.height;
          k = localbvf.skC.width;
        }
        int i6 = localVideoTransPara.videoBitrate;
        localObject8 = n.b.sqe;
        n.b.cDG();
        ad.i(TAG, "video rotate:" + i3 + ", width:" + i + ", height:" + k + " url " + localbvf.url + " thumbUrl: " + localbvf.thumbUrl + " size:" + bt.sy(com.tencent.mm.vfs.i.aYo(localbvf.url)));
        localObject8 = localbvf.url;
        d.g.b.p.g(localObject8, "it.url");
        f1 = (float)((MultiMediaVideoChecker.a)localObject4).duration;
        f2 = localbvf.skC.ddx / 1000.0F;
        d.g.b.p.g(localVideoTransPara, "videoParams");
        localObject4 = a.a((String)localObject8, i, k, f1, f2, localVideoTransPara);
        i5 = i;
        i4 = k;
        i3 = i6;
        if (((c.a.a)localObject4).errCode == 0)
        {
          i5 = i;
          i4 = k;
          i3 = i6;
          if (((c.a.a)localObject4).width > 0)
          {
            i5 = i;
            i4 = k;
            i3 = i6;
            if (((c.a.a)localObject4).height > 0)
            {
              i5 = i;
              i4 = k;
              i3 = i6;
              if (((c.a.a)localObject4).bitrate > 0)
              {
                i5 = ((c.a.a)localObject4).width;
                i4 = ((c.a.a)localObject4).height;
                i3 = ((c.a.a)localObject4).bitrate;
                ad.i(TAG, "video abaResult, width:" + i5 + ", height:" + i4 + ", " + i3);
              }
            }
          }
        }
        if ((((c.a.a)localObject4).sIH == null) || (((c.a.a)localObject4).sIH.length < 28)) {
          break label5605;
        }
      }
      label4262:
      label5422:
      label5556:
      label5562:
      label5568:
      label5605:
      for (f1 = localObject4.sIH[27];; f1 = 0.0F)
      {
        localObject8 = localbvf.url;
        d.g.b.p.g(localObject8, "it.url");
        f2 = a.a((String)localObject8, f3, f4, i7, bool2, bool5);
        ad.i(TAG, "qipengfeng, audio quality level: " + f2 + ", bitrate:" + f3 + ", samplerate:" + f4 + ", channels:" + i7 + ", enableAuQA:" + bool2 + ", useOriAu:" + bool5);
        i = a(l, j, (String)localObject7, i1, i2, com.tencent.mm.plugin.mmsight.d.Kg(i5), com.tencent.mm.plugin.mmsight.d.Kg(i4), i3, localVideoTransPara, localbvf, (FinderMediaReportObject)localObject6, (String)localObject1, n, (d.g.a.b)new b((y.c)localObject3, j, this, localVideoTransPara, (List)localObject5));
        bt.aO(l);
        if (i < 0)
        {
          a(com.tencent.mm.loader.g.j.hfL);
          AppMethodBeat.o(167731);
          return;
        }
        localObject3 = MultiMediaVideoChecker.BFV.aDk((String)localObject7);
        if ((localObject3 == null) || (((MultiMediaVideoChecker.a)localObject3).width <= 0) || (((MultiMediaVideoChecker.a)localObject3).height <= 0) || (((MultiMediaVideoChecker.a)localObject3).cvL <= 0.0F))
        {
          localObject4 = TAG;
          localObject5 = new StringBuilder("normal video remuxVideo file error: ");
          if (localObject3 != null)
          {
            localObject1 = Integer.valueOf(((MultiMediaVideoChecker.a)localObject3).width);
            localObject5 = ((StringBuilder)localObject5).append(localObject1).append(' ');
            if (localObject3 == null) {
              break label4219;
            }
          }
          label4219:
          for (localObject1 = Integer.valueOf(((MultiMediaVideoChecker.a)localObject3).height);; localObject1 = null)
          {
            ad.i((String)localObject4, localObject1);
            localObject1 = n.b.sqe;
            n.b.cDH();
            localObject1 = n.b.sqe;
            n.b.cDI();
            a(com.tencent.mm.loader.g.j.hfL);
            AppMethodBeat.o(167731);
            return;
            localObject1 = null;
            break;
          }
        }
        if (((c.a.a)localObject4).sIH != null) {}
        for (;;)
        {
          try
          {
            SightVideoJNI.addReportMetadata((String)localObject7, ((c.a.a)localObject4).sIH, localVideoTransPara.hVq, 0);
            f3 = f2;
            i = 1;
            f2 = f1;
            f1 = f3;
          }
          catch (Throwable localThrowable)
          {
            f3 = f1;
            f1 = f2;
            i = 1;
            f2 = f3;
            continue;
          }
          bc(1.0F);
          localObject3 = this.sIF.getMediaList();
          localObject4 = ((Iterable)localObject3).iterator();
          if (((Iterator)localObject4).hasNext())
          {
            localObject1 = ((Iterator)localObject4).next();
            localObject8 = (bvf)localObject1;
            if (!d.g.b.p.i(localbvf.mediaId, ((bvf)localObject8).mediaId)) {
              continue;
            }
            localObject1 = (bvf)localObject1;
            if (localObject1 == null) {
              break label5568;
            }
            d.g.b.p.g(localVideoTransPara, "videoParams");
            d.g.b.p.h(localVideoTransPara, "videoParams");
            d.g.b.p.h(localbvf, "localMedia");
            d.g.b.p.h(localObject7, "outputPath");
            d.g.b.p.h(localObject1, "media");
            d.g.b.p.h(localObject6, "reportObject");
            k = localVideoTransPara.hVp;
            n = (int)(localbvf.height / localbvf.width * k);
            localObject4 = f.sJc;
            d.g.b.p.h(localObject7, "input");
            localObject4 = com.tencent.mm.plugin.finder.utils.r.sNc;
            localObject4 = com.tencent.mm.plugin.finder.utils.r.ajf((String)localObject7);
            ad.i(f.TAG, "genVideoThumbFileForPost input:" + (String)localObject7 + ", targetWidth:" + k + ", targetHeight:" + n + ", thumbRect:" + null + ", dstPath:" + (String)localObject4);
            localObject4 = f.a((String)localObject7, k, n, null, (String)localObject4);
            localObject8 = com.tencent.mm.plugin.finder.storage.b.sxa;
            if (!com.tencent.mm.plugin.finder.storage.b.cIh()) {
              break label5550;
            }
            localObject8 = com.tencent.mm.plugin.finder.storage.b.sxa;
            k = AdaptiveAdjustBitrate.getVideoImageQuality(com.tencent.mm.plugin.finder.storage.b.cFb(), 0, k, n, 0.8F);
            ((bvf)localObject1).GPw = ((FinderMediaReportObject)localObject6);
            ((bvf)localObject1).url = ((String)localObject7);
            ((bvf)localObject1).thumbUrl = ((String)localObject4);
            ((bvf)localObject1).GPt = false;
            ((bvf)localObject1).mediaId = ai.ee(localbvf.url);
            ((bvf)localObject1).fileSize = ((int)com.tencent.mm.vfs.i.aYo((String)localObject7));
            ((bvf)localObject1).GPw.target = new FinderMediaReportInfo();
            ((bvf)localObject1).GPw.target.fileSize = ((bvf)localObject1).fileSize;
            ((bvf)localObject1).GPw.videoFinalSize = ((bvf)localObject1).GPw.target.fileSize;
            localObject4 = ((bvf)localObject1).GPu;
            if (localObject4 != null) {
              ((aan)localObject4).FZx = false;
            }
            if (((bvf)localObject1).codec_info == null) {
              ((bvf)localObject1).codec_info = new apb();
            }
            localObject4 = ((bvf)localObject1).codec_info;
            ((apb)localObject4).Gnw = f2;
            ((apb)localObject4).Gny = f1;
            ((apb)localObject4).Gnz = k;
            localObject6 = ((bvf)localObject1).GPu;
            if (localObject6 == null) {
              break label5556;
            }
            localObject6 = ((aan)localObject6).BFa;
            if (localObject6 == null) {
              break label5556;
            }
            localObject6 = ((aam)localObject6).FZr;
            if (localObject6 == null) {
              break label5556;
            }
            k = ((LinkedList)localObject6).size();
            if (k <= 0) {
              break label5562;
            }
            bool1 = true;
            ((apb)localObject4).GnB = bool1;
            ad.i(TAG, "codec_info video_score:" + ((apb)localObject4).Gnw + ",video_cover_score:" + ((apb)localObject4).Gnx + ",video_audio_score:" + ((apb)localObject4).Gny + ",thumb_score:" + ((apb)localObject4).Gnz + ",hdimg_score:" + ((apb)localObject4).GnA + ",has_stickers:" + ((apb)localObject4).GnB);
            if (((bvf)localObject1).GPw.codecInfo == null) {
              ((bvf)localObject1).GPw.codecInfo = ((bvf)localObject1).codec_info;
            }
            localObject4 = MultiMediaVideoChecker.BFV.aDk((String)localObject7);
            if (localObject4 != null)
            {
              ((bvf)localObject1).videoDuration = d.h.a.co((float)((MultiMediaVideoChecker.a)localObject4).duration / 1000.0F);
              ((bvf)localObject1).GPw.target.videoDuration = ((int)((MultiMediaVideoChecker.a)localObject4).duration);
              ((bvf)localObject1).GPw.target.width = ((MultiMediaVideoChecker.a)localObject4).width;
              ((bvf)localObject1).GPw.target.height = ((MultiMediaVideoChecker.a)localObject4).height;
              ((bvf)localObject1).GPw.target.videoBitrate = ((MultiMediaVideoChecker.a)localObject4).bitrate;
              ((bvf)localObject1).GPw.target.audioBitrate = ((MultiMediaVideoChecker.a)localObject4).audioBitrate;
              ((bvf)localObject1).GPw.target.fps = ((int)((MultiMediaVideoChecker.a)localObject4).cvL);
            }
            ad.i(TAG, "processList index " + j + " url " + localbvf.url + " thumbUrl: " + localbvf.thumbUrl + " newMd5: " + ai.ee(localbvf.url) + " size:" + bt.sy(com.tencent.mm.vfs.i.aYo(localbvf.url)));
            this.sIF.setMediaList((LinkedList)localObject3);
            localObject1 = this.sIF.field_reportObject;
            if (localObject1 != null)
            {
              ((FinderFeedReportObject)localObject1).remuxEndTime = cf.aCM();
              ((FinderFeedReportObject)localObject1).remuxType = i;
              localObject1 = z.MKo;
            }
            ((PluginFinder)g.ad(PluginFinder.class)).getFeedStorage().b(this.sIF.getLocalId(), this.sIF);
            j = m;
            break;
            d.g.b.p.g(localVideoTransPara, "videoParams");
            localObject2 = a(l, j, (String)localObject7, localVideoTransPara, localbvf, (FinderMediaReportObject)localObject6);
            i = ((Number)((d.o)localObject2).first).intValue();
            f2 = ((Number)((d.o)localObject2).second).floatValue();
            if (i < 0)
            {
              a(com.tencent.mm.loader.g.j.hfL);
              AppMethodBeat.o(167731);
              return;
            }
            localObject3 = MultiMediaVideoChecker.BFV.aDk((String)localObject7);
            if ((localObject3 == null) || (((MultiMediaVideoChecker.a)localObject3).width <= 0) || (((MultiMediaVideoChecker.a)localObject3).height <= 0) || (((MultiMediaVideoChecker.a)localObject3).cvL <= 0.0F))
            {
              localObject4 = TAG;
              localObject5 = new StringBuilder("remuxVideo file error: ");
              if (localObject3 != null)
              {
                localObject2 = Integer.valueOf(((MultiMediaVideoChecker.a)localObject3).width);
                localObject5 = ((StringBuilder)localObject5).append(localObject2).append(' ');
                if (localObject3 == null) {
                  break label5422;
                }
              }
              for (localObject2 = Integer.valueOf(((MultiMediaVideoChecker.a)localObject3).height);; localObject2 = null)
              {
                ad.i((String)localObject4, localObject2);
                a(com.tencent.mm.loader.g.j.hfL);
                AppMethodBeat.o(167731);
                return;
                localObject2 = null;
                break;
              }
            }
            localObject2 = localbvf.url;
            d.g.b.p.g(localObject2, "it.url");
            f1 = a.a((String)localObject2, f3, f4, i7, bool2, bool5);
            ad.i(TAG, "qipengfeng, audio quality level: " + f1 + ", bitrate:" + f3 + ", samplerate:" + f4 + ", channels:" + i7 + ", enableAuQA:" + bool2 + ", useOriAu:" + bool5);
            i = k;
            continue;
          }
          localObject2 = null;
          continue;
          k = 0;
          continue;
          k = 0;
          continue;
          bool1 = false;
          continue;
          j = m;
          break;
          a(com.tencent.mm.loader.g.j.hfK);
          AppMethodBeat.o(167731);
          return;
          f3 = f1;
          f1 = f2;
          i = 1;
          f2 = f3;
        }
      }
      label5550:
      label5610:
      bool1 = bool4;
      Object localObject2 = localObject4;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/upload/FinderMediaProcessTask$Companion;", "", "()V", "RemuxTypeNoNeedRemux", "", "RemuxTypeNormalVideo", "RemuxTypeTavkit", "TAG", "", "getTAG", "()Ljava/lang/String;", "checkRemuxVideo", "path", "width", "height", "videoParams", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "localId", "", "convertViewRect", "Landroid/graphics/Rect;", "viewRect", "Lcom/tencent/mm/protocal/protobuf/ViewRect;", "getABAResult", "Lcom/tencent/mm/plugin/finder/upload/FinderMediaProcessTask$Companion$ABAResult;", "input", "durationSec", "", "startTimeSec", "videoTransPara", "getAudioQualityLevel", "bitrate", "samplerate", "channels", "enableAuQA", "", "useOriAu", "ABAResult", "plugin-finder_release"})
  public static final class a
  {
    public static float a(String paramString, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(204321);
      d.g.b.p.h(paramString, "input");
      com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sxa;
      if (com.tencent.mm.plugin.finder.storage.b.cIh())
      {
        paramFloat1 = AdaptiveAdjustBitrate.b(paramString, paramFloat1, paramFloat2, paramInt, paramBoolean1, paramBoolean2);
        AppMethodBeat.o(204321);
        return paramFloat1;
      }
      AppMethodBeat.o(204321);
      return 0.0F;
    }
    
    public static int a(String paramString, int paramInt1, int paramInt2, VideoTransPara paramVideoTransPara, long paramLong)
    {
      AppMethodBeat.i(167727);
      d.g.b.p.h(paramVideoTransPara, "videoParams");
      long l = com.tencent.mm.vfs.i.aYo(paramString);
      Object localObject = n.b.sqe;
      n.b.wz(l);
      localObject = com.tencent.mm.plugin.finder.storage.b.sxa;
      if (l > com.tencent.mm.plugin.finder.storage.b.cFe())
      {
        localObject = com.tencent.mm.plugin.finder.storage.b.sxa;
        if (com.tencent.mm.plugin.finder.storage.b.cHU() != 1)
        {
          ad.i(c.access$getTAG$cp(), "checkRemuxVideo need remux zip");
          localObject = n.b.sqe;
          n.b.cDK();
          l = bt.HI();
          localObject = paramString + ".remux";
          paramInt1 = SightVideoJNI.remuxingVFS(paramString, (String)localObject, paramInt1, paramInt2, paramVideoTransPara.videoBitrate, com.tencent.mm.plugin.sight.base.c.yRb, 8, 2, 25.0F, paramVideoTransPara.fps, null, 0, com.tencent.mm.plugin.sight.base.c.yRa, 0, 51);
          ad.i(c.access$getTAG$cp(), "checkRemuxVideo remux cost:" + bt.aO(l) + "ms, ret:" + paramInt1 + " localId:" + paramLong);
          paramVideoTransPara = n.b.sqe;
          n.b.wA(bt.aO(l));
          if (paramInt1 >= 0)
          {
            com.tencent.mm.vfs.i.mA((String)localObject, paramString);
            paramLong = com.tencent.mm.vfs.i.aYo((String)localObject);
            paramString = n.b.sqe;
            n.b.wB(paramLong);
            paramString = com.tencent.mm.plugin.finder.storage.b.sxa;
            if (paramLong > com.tencent.mm.plugin.finder.storage.b.cFe())
            {
              AppMethodBeat.o(167727);
              return -3;
            }
            AppMethodBeat.o(167727);
            return 0;
          }
          paramString = n.b.sqe;
          n.b.cDL();
          AppMethodBeat.o(167727);
          return -2;
        }
      }
      ad.i(c.access$getTAG$cp(), "checkRemuxVideo, no need remux");
      AppMethodBeat.o(167727);
      return 0;
    }
    
    public static Rect a(dwe paramdwe)
    {
      AppMethodBeat.i(167726);
      d.g.b.p.h(paramdwe, "viewRect");
      paramdwe = new Rect(paramdwe.left, paramdwe.top, paramdwe.right, paramdwe.bottom);
      AppMethodBeat.o(167726);
      return paramdwe;
    }
    
    public static a a(String paramString, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, VideoTransPara paramVideoTransPara)
    {
      AppMethodBeat.i(167728);
      d.g.b.p.h(paramString, "input");
      d.g.b.p.h(paramVideoTransPara, "videoTransPara");
      for (;;)
      {
        try
        {
          com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sxa;
          if (!com.tencent.mm.plugin.finder.storage.b.cFa()) {
            continue;
          }
          paramString = AdaptiveAdjustBitrate.a(paramString, paramInt2, paramInt1, paramVideoTransPara.fps, paramVideoTransPara.videoBitrate, paramFloat1 / 1000.0F, paramFloat2 / 1000.0F, 4, paramVideoTransPara.hVs, paramVideoTransPara.hVt, paramVideoTransPara.hVu, paramVideoTransPara.hVv, paramVideoTransPara.hVw, paramVideoTransPara.hVx, paramVideoTransPara.hVy);
          j = paramVideoTransPara.videoBitrate;
          i = -1;
          if (paramString == null) {
            break label244;
          }
          j = paramString[0] * 1000;
          i = 0;
          ad.i(c.access$getTAG$cp(), "getABAResult use videoBitrate:".concat(String.valueOf(j)));
        }
        catch (Throwable paramString)
        {
          int j;
          paramString = new a(-1, 0, 0, 0, null);
          AppMethodBeat.o(167728);
          return paramString;
        }
        ad.i(c.access$getTAG$cp(), "ABA:  finder video bitrate:" + j + " width: " + k + " height:" + paramInt1);
        if (com.tencent.mm.modelvideo.o.aMK() != null) {
          e.q(paramString);
        }
        paramString = new a(i, k, paramInt1, j, paramString);
        AppMethodBeat.o(167728);
        return paramString;
        label244:
        while ((paramString == null) || (paramString[5] <= 0))
        {
          k = paramInt1;
          paramInt1 = paramInt2;
          break;
        }
        int k = paramString[1];
        paramInt1 = paramString[2];
        int i = 0;
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/upload/FinderMediaProcessTask$Companion$ABAResult;", "", "errCode", "", "width", "height", "bitrate", "abaParams", "", "(IIII[I)V", "getAbaParams", "()[I", "getBitrate", "()I", "getErrCode", "getHeight", "getWidth", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder_release"})
    public static final class a
    {
      public final int bitrate;
      public final int errCode;
      public final int height;
      public final int[] sIH;
      public final int width;
      
      public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
      {
        this.errCode = paramInt1;
        this.width = paramInt2;
        this.height = paramInt3;
        this.bitrate = paramInt4;
        this.sIH = paramArrayOfInt;
      }
      
      public final boolean equals(Object paramObject)
      {
        AppMethodBeat.i(167725);
        if (this != paramObject)
        {
          if ((paramObject instanceof a))
          {
            paramObject = (a)paramObject;
            if ((this.errCode != paramObject.errCode) || (this.width != paramObject.width) || (this.height != paramObject.height) || (this.bitrate != paramObject.bitrate) || (!d.g.b.p.i(this.sIH, paramObject.sIH))) {}
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
        int[] arrayOfInt = this.sIH;
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
        String str = "ABAResult(errCode=" + this.errCode + ", width=" + this.width + ", height=" + this.height + ", bitrate=" + this.bitrate + ", abaParams=" + Arrays.toString(this.sIH) + ")";
        AppMethodBeat.o(167723);
        return str;
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "invoke", "com/tencent/mm/plugin/finder/upload/FinderMediaProcessTask$call$2$3"})
  static final class b
    extends q
    implements d.g.a.b<Float, z>
  {
    b(y.c paramc, int paramInt, c paramc1, VideoTransPara paramVideoTransPara, List paramList)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "invoke"})
  static final class c
    extends q
    implements d.g.a.b<Float, z>
  {
    c(c paramc, y.c paramc1)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "result", "", "invoke"})
  static final class d
    extends q
    implements d.g.a.b<Boolean, z>
  {
    d(c paramc, y.d paramd, int paramInt, FinderMediaReportObject paramFinderMediaReportObject, long paramLong, String paramString, aao paramaao, VideoTransPara paramVideoTransPara, aan paramaan, Object paramObject, y.a parama)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "invoke"})
  static final class e
    extends q
    implements d.g.a.b<Float, z>
  {
    e(d.g.a.b paramb)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "invoke"})
  static final class f
    extends q
    implements d.g.a.b<String, z>
  {
    f(c paramc, y.d paramd, int paramInt1, FinderMediaReportObject paramFinderMediaReportObject, long paramLong, int paramInt2, int paramInt3, VideoTransPara paramVideoTransPara, Object paramObject, y.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.c
 * JD-Core Version:    0.7.0.1
 */