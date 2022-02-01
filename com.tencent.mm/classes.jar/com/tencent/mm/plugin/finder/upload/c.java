package com.tencent.mm.plugin.finder.upload;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gz;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.g.h;
import com.tencent.mm.model.ce;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.report.i.b;
import com.tencent.mm.plugin.finder.report.i.c;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.f;
import com.tencent.mm.plugin.finder.storage.m;
import com.tencent.mm.plugin.finder.utils.n;
import com.tencent.mm.plugin.finder.utils.p;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.vlog.model.l.a;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.protocal.protobuf.FinderMediaReportInfo;
import com.tencent.mm.protocal.protobuf.FinderMediaReportObject;
import com.tencent.mm.protocal.protobuf.aad;
import com.tencent.mm.protocal.protobuf.bqs;
import com.tencent.mm.protocal.protobuf.bqt;
import com.tencent.mm.protocal.protobuf.brc;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.dix;
import com.tencent.mm.protocal.protobuf.dqk;
import com.tencent.mm.protocal.protobuf.yn;
import com.tencent.mm.protocal.protobuf.yo;
import com.tencent.mm.protocal.protobuf.yp;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;
import d.a.j;
import d.g.b.k;
import d.g.b.v.a;
import d.g.b.v.c;
import d.g.b.v.d;
import d.y;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/upload/FinderMediaProcessTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "finderObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "getFinderObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFinderObj", "call", "", "exportMedia", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "remuxComposition", "", "startRemuxerTick", "", "index", "outputPath", "", "videoParams", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "mediaReportObject", "Lcom/tencent/mm/protocal/protobuf/FinderMediaReportObject;", "remuxNormalVideo", "videoWidth", "videoHeight", "width", "height", "bitrate", "localFinderMedia", "musicPath", "mixType", "onUpdateProgress", "Lkotlin/Function1;", "", "uniqueId", "updateMedia", "localMedia", "reportObject", "updateProgress", "avgProgress", "Companion", "plugin-finder_release"})
public final class c
  extends com.tencent.mm.loader.g.c
{
  private static final String TAG = "Finder.FinderMediaProcessTask";
  public static final a rME;
  FinderItem rMD;
  
  static
  {
    AppMethodBeat.i(167735);
    rME = new a((byte)0);
    TAG = "Finder.FinderMediaProcessTask";
    AppMethodBeat.o(167735);
  }
  
  public c(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(167734);
    this.rMD = paramFinderItem;
    AppMethodBeat.o(167734);
  }
  
  /* Error */
  private final int a(final long paramLong, final int paramInt1, String paramString1, int paramInt2, int paramInt3, int paramInt4, final int paramInt5, int paramInt6, final VideoTransPara paramVideoTransPara, bqs parambqs, final FinderMediaReportObject paramFinderMediaReportObject, String paramString2, int paramInt7, d.g.a.b<? super java.lang.Float, y> paramb)
  {
    // Byte code:
    //   0: ldc 102
    //   2: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 104	d/g/b/v$d
    //   8: dup
    //   9: invokespecial 105	d/g/b/v$d:<init>	()V
    //   12: astore 16
    //   14: aload 16
    //   16: iconst_m1
    //   17: putfield 109	d/g/b/v$d:KUO	I
    //   20: new 111	java/lang/Object
    //   23: dup
    //   24: invokespecial 112	java/lang/Object:<init>	()V
    //   27: astore 17
    //   29: new 114	d/g/b/v$a
    //   32: dup
    //   33: invokespecial 115	d/g/b/v$a:<init>	()V
    //   36: astore 18
    //   38: aload 18
    //   40: iconst_0
    //   41: putfield 119	d/g/b/v$a:KUL	Z
    //   44: aload 11
    //   46: getfield 124	com/tencent/mm/protocal/protobuf/bqs:url	Ljava/lang/String;
    //   49: astore 19
    //   51: aload 19
    //   53: ldc 126
    //   55: invokestatic 129	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   58: aload 11
    //   60: getfield 133	com/tencent/mm/protocal/protobuf/bqs:rvh	Lcom/tencent/mm/protocal/protobuf/brc;
    //   63: getfield 139	com/tencent/mm/protocal/protobuf/brc:Fgj	Lcom/tencent/mm/protocal/protobuf/dqk;
    //   66: astore 20
    //   68: aload 20
    //   70: ldc 141
    //   72: invokestatic 129	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   75: new 143	com/tencent/mm/plugin/finder/video/l
    //   78: dup
    //   79: aload 13
    //   81: aload 19
    //   83: iload 14
    //   85: aload 4
    //   87: aload 20
    //   89: invokestatic 146	com/tencent/mm/plugin/finder/upload/c$a:a	(Lcom/tencent/mm/protocal/protobuf/dqk;)Landroid/graphics/Rect;
    //   92: iload 7
    //   94: iload 8
    //   96: iload 9
    //   98: aload 10
    //   100: getfield 151	com/tencent/mm/modelcontrol/VideoTransPara:audioBitrate	I
    //   103: aload 10
    //   105: getfield 154	com/tencent/mm/modelcontrol/VideoTransPara:audioSampleRate	I
    //   108: aload 10
    //   110: getfield 157	com/tencent/mm/modelcontrol/VideoTransPara:gOt	I
    //   113: aload 10
    //   115: getfield 160	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   118: aload 11
    //   120: getfield 133	com/tencent/mm/protocal/protobuf/bqs:rvh	Lcom/tencent/mm/protocal/protobuf/brc;
    //   123: getfield 163	com/tencent/mm/protocal/protobuf/brc:cSh	I
    //   126: i2l
    //   127: aload 11
    //   129: getfield 133	com/tencent/mm/protocal/protobuf/bqs:rvh	Lcom/tencent/mm/protocal/protobuf/brc;
    //   132: getfield 166	com/tencent/mm/protocal/protobuf/brc:hbI	I
    //   135: i2l
    //   136: new 168	com/tencent/mm/plugin/finder/upload/c$e
    //   139: dup
    //   140: aload 15
    //   142: invokespecial 171	com/tencent/mm/plugin/finder/upload/c$e:<init>	(Ld/g/a/b;)V
    //   145: checkcast 173	d/g/a/b
    //   148: new 11	com/tencent/mm/plugin/finder/upload/c$f
    //   151: dup
    //   152: aload_0
    //   153: aload 16
    //   155: iload_3
    //   156: aload 12
    //   158: lload_1
    //   159: iload 7
    //   161: iload 8
    //   163: aload 10
    //   165: aload 17
    //   167: aload 18
    //   169: invokespecial 176	com/tencent/mm/plugin/finder/upload/c$f:<init>	(Lcom/tencent/mm/plugin/finder/upload/c;Ld/g/b/v$d;ILcom/tencent/mm/protocal/protobuf/FinderMediaReportObject;JIILcom/tencent/mm/modelcontrol/VideoTransPara;Ljava/lang/Object;Ld/g/b/v$a;)V
    //   172: checkcast 173	d/g/a/b
    //   175: iload 5
    //   177: iload 6
    //   179: invokespecial 179	com/tencent/mm/plugin/finder/video/l:<init>	(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Landroid/graphics/Rect;IIIIIIIJJLd/g/a/b;Ld/g/a/b;II)V
    //   182: astore 4
    //   184: aload 4
    //   186: invokevirtual 183	com/tencent/mm/plugin/finder/video/l:arc	()I
    //   189: pop
    //   190: aload 17
    //   192: monitorenter
    //   193: aload 18
    //   195: getfield 119	d/g/b/v$a:KUL	Z
    //   198: ifne +58 -> 256
    //   201: getstatic 82	com/tencent/mm/plugin/finder/upload/c:TAG	Ljava/lang/String;
    //   204: ldc 185
    //   206: iload_3
    //   207: invokestatic 191	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   210: invokevirtual 195	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   213: invokestatic 200	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   216: aload 17
    //   218: invokevirtual 203	java/lang/Object:wait	()V
    //   221: getstatic 82	com/tencent/mm/plugin/finder/upload/c:TAG	Ljava/lang/String;
    //   224: new 205	java/lang/StringBuilder
    //   227: dup
    //   228: ldc 207
    //   230: invokespecial 210	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   233: iload_3
    //   234: invokevirtual 214	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   237: ldc 216
    //   239: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: aload 16
    //   244: getfield 109	d/g/b/v$d:KUO	I
    //   247: invokevirtual 214	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   250: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   253: invokestatic 200	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   256: getstatic 229	d/y:KTp	Ld/y;
    //   259: astore 4
    //   261: aload 17
    //   263: monitorexit
    //   264: aload 16
    //   266: getfield 109	d/g/b/v$d:KUO	I
    //   269: istore_3
    //   270: ldc 102
    //   272: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   275: iload_3
    //   276: ireturn
    //   277: astore 4
    //   279: getstatic 82	com/tencent/mm/plugin/finder/upload/c:TAG	Ljava/lang/String;
    //   282: aload 4
    //   284: ldc 231
    //   286: iconst_0
    //   287: anewarray 111	java/lang/Object
    //   290: invokestatic 235	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   293: getstatic 241	com/tencent/mm/plugin/finder/report/i$b:ryD	Lcom/tencent/mm/plugin/finder/report/i$b;
    //   296: astore 4
    //   298: invokestatic 244	com/tencent/mm/plugin/finder/report/i$b:cwZ	()V
    //   301: aload_0
    //   302: getstatic 250	com/tencent/mm/loader/g/h:gLO	Lcom/tencent/mm/loader/g/h;
    //   305: invokevirtual 253	com/tencent/mm/plugin/finder/upload/c:a	(Lcom/tencent/mm/loader/g/h;)V
    //   308: aload 16
    //   310: getfield 109	d/g/b/v$d:KUO	I
    //   313: istore_3
    //   314: ldc 102
    //   316: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   319: iload_3
    //   320: ireturn
    //   321: astore 4
    //   323: aload 17
    //   325: monitorexit
    //   326: ldc 102
    //   328: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   331: aload 4
    //   333: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	334	0	this	c
    //   0	334	1	paramLong	long
    //   0	334	3	paramInt1	int
    //   0	334	4	paramString1	String
    //   0	334	5	paramInt2	int
    //   0	334	6	paramInt3	int
    //   0	334	7	paramInt4	int
    //   0	334	8	paramInt5	int
    //   0	334	9	paramInt6	int
    //   0	334	10	paramVideoTransPara	VideoTransPara
    //   0	334	11	parambqs	bqs
    //   0	334	12	paramFinderMediaReportObject	FinderMediaReportObject
    //   0	334	13	paramString2	String
    //   0	334	14	paramInt7	int
    //   0	334	15	paramb	d.g.a.b<? super java.lang.Float, y>
    //   12	297	16	locald	v.d
    //   27	297	17	localObject	Object
    //   36	158	18	locala	v.a
    //   49	33	19	str	String
    //   66	22	20	localdqk	dqk
    // Exception table:
    //   from	to	target	type
    //   44	184	277	java/lang/Throwable
    //   193	256	321	finally
    //   256	261	321	finally
  }
  
  private final int a(long paramLong, int paramInt, String paramString, VideoTransPara paramVideoTransPara, bqs parambqs, FinderMediaReportObject paramFinderMediaReportObject)
  {
    AppMethodBeat.i(203500);
    ac.i(TAG, "remuxComposition outputPath:".concat(String.valueOf(paramString)));
    yo localyo = parambqs.FfQ;
    v.d locald = new v.d();
    locald.KUO = -1;
    yp localyp = localyo.AmP;
    localyp.poB = paramString;
    Object localObject = new Object();
    v.a locala = new v.a();
    locala.KUL = false;
    com.tencent.mm.plugin.vlog.model.a locala1 = new com.tencent.mm.plugin.vlog.model.a();
    locala1.retryCount = parambqs.rvh.retryCount;
    locala1.uzZ = true;
    parambqs = com.tencent.mm.plugin.finder.storage.b.rCU;
    if (com.tencent.mm.plugin.finder.storage.b.cyb()) {
      locala1.r(paramVideoTransPara);
    }
    parambqs = (d.g.a.b)new c.c(this);
    k.h(parambqs, "callback");
    locala1.AmM = parambqs;
    k.g(localyo, "videoCompositionInfo");
    locala1.a(localyo, (d.g.a.b)new c.d(this, locald, paramInt, paramFinderMediaReportObject, paramLong, paramString, localyp, paramVideoTransPara, localyo, localObject, locala));
    try
    {
      if (!locala.KUL)
      {
        ac.i(TAG, "wait ".concat(String.valueOf(paramInt)));
        localObject.wait();
        ac.i(TAG, "notify " + paramInt + ", " + locald.KUO);
      }
      paramString = y.KTp;
      paramInt = locald.KUO;
      AppMethodBeat.o(203500);
      return paramInt;
    }
    finally
    {
      AppMethodBeat.o(203500);
    }
  }
  
  public final void aZ(float paramFloat)
  {
    AppMethodBeat.i(167733);
    float f = paramFloat;
    if (paramFloat > 1.0F) {
      f = 1.0F;
    }
    Object localObject = com.tencent.mm.plugin.finder.storage.b.rCU;
    int i = (int)(com.tencent.mm.plugin.finder.storage.b.cys() * f);
    ac.i(TAG, "feed " + this.rMD.getLocalId() + " updateProgress  " + f + ", " + i);
    if (this.rMD.getPostInfo().FfV < i)
    {
      this.rMD.getPostInfo().FfV = i;
      localObject = com.tencent.mm.plugin.finder.storage.logic.b.rFl;
      com.tencent.mm.plugin.finder.storage.logic.b.a.h(this.rMD);
    }
    localObject = com.tencent.mm.sdk.b.a.GpY;
    gz localgz = new gz();
    localgz.dhW.dcd = this.rMD.getLocalId();
    localgz.dhW.progress = this.rMD.getPostInfo().FfV;
    ((com.tencent.mm.sdk.b.a)localObject).l((com.tencent.mm.sdk.b.b)localgz);
    AppMethodBeat.o(167733);
  }
  
  public final String acg()
  {
    AppMethodBeat.i(167732);
    long l = this.rMD.getLocalId();
    AppMethodBeat.o(167732);
    return String.valueOf(l);
  }
  
  public final void call()
  {
    AppMethodBeat.i(167731);
    this.rMD.trackPost("mediaProcess");
    Object localObject4 = (List)new ArrayList();
    Object localObject1 = (Iterable)this.rMD.getMediaList();
    int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = ((Iterator)localObject1).next();
      if (i < 0) {
        j.fOc();
      }
      localObject3 = (bqs)localObject3;
      if ((this.rMD.isNeedCrop(i)) && (this.rMD.getCropInfo(i) != null)) {
        ((List)localObject4).add(localObject3);
      }
      if ((this.rMD.isNeedVideoCompositionPlay(i)) && (this.rMD.getCropInfo(i) != null)) {
        ((List)localObject4).add(localObject3);
      }
      i += 1;
    }
    localObject1 = com.tencent.mm.plugin.finder.storage.b.rCU;
    if ((com.tencent.mm.plugin.finder.storage.b.cyv()) && (ac.getLogLevel() >= 0))
    {
      ac.i(TAG, "debug blocking, sleep.....");
      Thread.sleep(1000000L);
    }
    if (((List)localObject4).size() <= 0)
    {
      ac.i(TAG, "nothing need to be processed");
      aZ(1.0F);
      a(h.gLN);
      AppMethodBeat.o(167731);
      return;
    }
    ac.i(TAG, "process media count " + ((List)localObject4).size());
    localObject1 = i.c.ryP;
    i.c.cxh();
    localObject1 = com.tencent.mm.plugin.finder.storage.b.rCU;
    Object localObject5 = com.tencent.mm.plugin.finder.storage.b.cxZ();
    ac.i(TAG, "FinderMediaProcessTask videoParams ".concat(String.valueOf(localObject5)));
    localObject1 = (Iterable)localObject4;
    int j = 0;
    Iterator localIterator = ((Iterable)localObject1).iterator();
    int m;
    bqs localbqs;
    boolean bool;
    Object localObject6;
    long l;
    String str;
    int n;
    Object localObject7;
    Object localObject8;
    label589:
    label745:
    float f1;
    label650:
    float f2;
    int k;
    if (localIterator.hasNext())
    {
      localObject1 = localIterator.next();
      m = j + 1;
      if (j < 0) {
        j.fOc();
      }
      localbqs = (bqs)localObject1;
      i = localbqs.rvh.retryCount;
      localObject1 = com.tencent.mm.plugin.finder.storage.b.rCU;
      if (i > com.tencent.mm.plugin.finder.storage.b.cyq())
      {
        a(h.gLO);
        AppMethodBeat.o(167731);
        return;
      }
      localObject1 = localbqs.rvh;
      ((brc)localObject1).retryCount += 1;
      localObject1 = com.tencent.mm.plugin.finder.storage.logic.b.rFl;
      com.tencent.mm.plugin.finder.storage.logic.b.a.h(this.rMD);
      localObject1 = n.rPN;
      bool = n.c(localbqs);
      localObject6 = new FinderMediaReportObject();
      ((FinderMediaReportObject)localObject6).mediaType = localbqs.mediaType;
      ((FinderMediaReportObject)localObject6).origin = new FinderMediaReportInfo();
      l = bs.Gn();
      localObject1 = new com.tencent.mm.plugin.finder.loader.l(localbqs, m.rEd, 0, null, 12);
      localObject3 = p.rQw;
      str = p.a((com.tencent.mm.plugin.finder.loader.l)localObject1, String.valueOf(this.rMD.getCreateTime()));
      localObject3 = null;
      n = 1;
      i = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pWi, 1);
      localObject7 = TAG;
      localObject8 = new StringBuilder("process: config: ").append(i).append(", trackSize: ");
      localObject1 = localbqs.FfQ;
      if (localObject1 != null)
      {
        localObject1 = ((yo)localObject1).Esk;
        if (localObject1 != null)
        {
          localObject1 = Integer.valueOf(((LinkedList)localObject1).size());
          localObject8 = ((StringBuilder)localObject8).append(localObject1).append(", editSize: ");
          localObject1 = localbqs.FfQ;
          if (localObject1 == null) {
            break label1859;
          }
          localObject1 = ((yo)localObject1).AmQ;
          if (localObject1 == null) {
            break label1859;
          }
          localObject1 = ((yn)localObject1).Esi;
          if (localObject1 == null) {
            break label1859;
          }
          localObject1 = Integer.valueOf(((LinkedList)localObject1).size());
          ac.i((String)localObject7, localObject1);
          if (i != 1) {
            break label3548;
          }
          localObject1 = localbqs.FfQ;
          if (localObject1 == null) {
            break label1865;
          }
          localObject1 = ((yo)localObject1).Esk;
          if (localObject1 == null) {
            break label1865;
          }
          if (((LinkedList)localObject1).size() != 1) {
            break label3548;
          }
          localObject1 = localbqs.FfQ;
          if (localObject1 == null) {
            break label1872;
          }
          localObject1 = ((yo)localObject1).AmQ;
          if (localObject1 == null) {
            break label1872;
          }
          localObject1 = ((yn)localObject1).Esi;
          if (localObject1 == null) {
            break label1872;
          }
          i = ((LinkedList)localObject1).size();
          if (i != 0) {
            break label3548;
          }
          ac.i(TAG, "process, force use normal video");
          localObject1 = (dix)localbqs.FfQ.Esk.get(0);
          i = SightVideoJNI.getMp4RotateVFS(((dix)localObject1).path);
          localbqs.rvh.cSh = ((int)(localbqs.FfQ.Esl + ((dix)localObject1).Aox));
          localbqs.rvh.hbI = ((int)(localbqs.FfQ.Esm + ((dix)localObject1).Aox));
          f1 = ((dix)localObject1).AoA;
          f2 = ((dix)localObject1).AoC;
          k = ((Number)((dix)localObject1).FSo.Eur.Fjc.get(2)).intValue();
          localObject3 = ((dix)localObject1).FSo.Eur.Fjc.get(0);
          k.g(localObject3, "track.cropInfo.contentRect.values[0]");
          f1 = 1.0F * (f1 * f2) / (k - ((Number)localObject3).intValue());
          localObject3 = new dqk();
          k = ((Number)((dix)localObject1).FSo.Eup.Fjc.get(0)).intValue();
          localObject7 = ((dix)localObject1).FSo.Eur.Fjc.get(0);
          k.g(localObject7, "track.cropInfo.contentRect.values[0]");
          ((dqk)localObject3).left = ((int)((k - ((Number)localObject7).intValue()) * f1));
          k = ((Number)((dix)localObject1).FSo.Eup.Fjc.get(1)).intValue();
          localObject7 = ((dix)localObject1).FSo.Eur.Fjc.get(1);
          k.g(localObject7, "track.cropInfo.contentRect.values[1]");
          ((dqk)localObject3).bottom = ((int)((k - ((Number)localObject7).intValue()) * f1));
          k = ((Number)((dix)localObject1).FSo.Eup.Fjc.get(2)).intValue();
          localObject7 = ((dix)localObject1).FSo.Eur.Fjc.get(0);
          k.g(localObject7, "track.cropInfo.contentRect.values[0]");
          ((dqk)localObject3).right = ((int)((k - ((Number)localObject7).intValue()) * f1));
          k = ((Number)((dix)localObject1).FSo.Eup.Fjc.get(3)).intValue();
          localObject7 = ((dix)localObject1).FSo.Eur.Fjc.get(1);
          k.g(localObject7, "track.cropInfo.contentRect.values[1]");
          ((dqk)localObject3).top = ((int)((k - ((Number)localObject7).intValue()) * f1));
          localObject7 = y.KTp;
          localbqs.rvh.Fgj = ((dqk)localObject3);
          k = ((Number)((dix)localObject1).FSo.Eur.Fjc.get(2)).intValue();
          localObject7 = ((dix)localObject1).FSo.Eur.Fjc.get(0);
          k.g(localObject7, "track.cropInfo.contentRect.values[0]");
          k = (int)((k - ((Number)localObject7).intValue()) * f1);
          n = ((Number)((dix)localObject1).FSo.Eur.Fjc.get(3)).intValue();
          localObject7 = ((dix)localObject1).FSo.Eur.Fjc.get(1);
          k.g(localObject7, "track.cropInfo.contentRect.values[1]");
          n = (int)((n - ((Number)localObject7).intValue()) * f1);
          f2 = (localbqs.rvh.Fgj.right - localbqs.rvh.Fgj.left) * 1.0F / localbqs.FfQ.AmP.gNU;
          f1 = f2;
          if (f2 > 1.0F) {
            f1 = 1.0F;
          }
          localbqs.rvh.width = ((int)(localbqs.FfQ.AmP.gNU * f1));
          localbqs.rvh.height = ((int)(f1 * localbqs.FfQ.AmP.gNV));
          if (i != 90) {
            break label1877;
          }
          localObject7 = new dqk();
          ((dqk)localObject7).left = ((dqk)localObject3).bottom;
          ((dqk)localObject7).top = ((dqk)localObject3).right;
          ((dqk)localObject7).right = ((dqk)localObject3).top;
          ((dqk)localObject7).bottom = ((dqk)localObject3).left;
          localbqs.rvh.Fgj = ((dqk)localObject7);
          label1497:
          localbqs.url = ((dix)localObject1).path;
          localObject1 = localbqs.FfQ.gUk;
          bool = localbqs.FfQ.AnX;
          if (bs.isNullOrNil((String)localObject1)) {
            break label2039;
          }
          i = 1;
          label1537:
          if (!bool) {
            break label2049;
          }
          if (i == 0) {
            break label2044;
          }
          i = 3;
          label1548:
          ac.i(TAG, "process, time: [" + localbqs.rvh.cSh + ", " + localbqs.rvh.hbI + "], size: [" + localbqs.rvh.width + ", " + localbqs.rvh.height + "], crop: [" + localbqs.rvh.Fgj.left + ", " + localbqs.rvh.Fgj.top + ", " + localbqs.rvh.Fgj.right + ", " + localbqs.rvh.Fgj.bottom + "], mixType: " + i);
          bool = true;
          n = i;
        }
      }
    }
    for (;;)
    {
      if (bool)
      {
        ((FinderMediaReportObject)localObject6).origin.fileSize = ((int)i.aSp(localbqs.url));
        localObject3 = com.tencent.mm.plugin.sight.base.e.asx(localbqs.url);
        int i1 = 0;
        int i2 = 0;
        if (localObject3 != null)
        {
          ((FinderMediaReportObject)localObject6).origin.videoDuration = ((com.tencent.mm.plugin.sight.base.a)localObject3).videoDuration;
          ((FinderMediaReportObject)localObject6).origin.width = ((com.tencent.mm.plugin.sight.base.a)localObject3).width;
          ((FinderMediaReportObject)localObject6).origin.height = ((com.tencent.mm.plugin.sight.base.a)localObject3).height;
          ((FinderMediaReportObject)localObject6).origin.videoBitrate = ((com.tencent.mm.plugin.sight.base.a)localObject3).videoBitrate;
          i1 = ((com.tencent.mm.plugin.sight.base.a)localObject3).width;
          i2 = ((com.tencent.mm.plugin.sight.base.a)localObject3).height;
          localObject7 = y.KTp;
        }
        if (localObject3 == null)
        {
          a(h.gLO);
          AppMethodBeat.o(167731);
          return;
          localObject1 = null;
          break label589;
          label1859:
          localObject1 = null;
          break label650;
          label1865:
          localObject1 = localObject3;
          continue;
          label1872:
          i = 0;
          break label745;
          label1877:
          if (i == 180)
          {
            localObject7 = new dqk();
            ((dqk)localObject7).left = (k - ((dqk)localObject3).right);
            ((dqk)localObject7).top = (n - ((dqk)localObject3).bottom);
            ((dqk)localObject7).right = (k - ((dqk)localObject3).left);
            ((dqk)localObject7).bottom = (n - ((dqk)localObject3).top);
            localbqs.rvh.Fgj = ((dqk)localObject7);
            break label1497;
          }
          if (i != 270) {
            break label1497;
          }
          localObject7 = new dqk();
          ((dqk)localObject7).left = (n - ((dqk)localObject3).top);
          ((dqk)localObject7).top = (k - ((dqk)localObject3).left);
          ((dqk)localObject7).right = (n - ((dqk)localObject3).bottom);
          ((dqk)localObject7).bottom = (k - ((dqk)localObject3).right);
          localbqs.rvh.Fgj = ((dqk)localObject7);
          break label1497;
          label2039:
          i = 0;
          break label1537;
          label2044:
          i = 1;
          break label1548;
          label2049:
          if (i != 0)
          {
            i = 2;
            break label1548;
          }
          i = 0;
          break label1548;
        }
        localObject7 = new v.c();
        ((v.c)localObject7).KUN = 0.0F;
        int i3 = SightVideoJNI.getMp4RotateVFS(localbqs.url);
        i = localbqs.rvh.width;
        k = localbqs.rvh.height;
        if ((i3 == 90) || (i3 == 270))
        {
          i = localbqs.rvh.height;
          k = localbqs.rvh.width;
        }
        int i6 = ((VideoTransPara)localObject5).videoBitrate;
        localObject8 = i.b.ryD;
        i.b.cwY();
        ac.i(TAG, "video rotate:" + i3 + ", width:" + i + ", height:" + k + " url " + localbqs.url + " thumbUrl: " + localbqs.thumbUrl + " size:" + bs.qz(i.aSp(localbqs.url)));
        localObject8 = localbqs.url;
        k.g(localObject8, "it.url");
        f1 = ((com.tencent.mm.plugin.sight.base.a)localObject3).getVideoDuration();
        f2 = localbqs.rvh.cSh / 1000.0F;
        k.g(localObject5, "videoParams");
        localObject8 = a.a((String)localObject8, i, k, f1, f2, (VideoTransPara)localObject5);
        int i5 = i;
        int i4 = k;
        i3 = i6;
        if (((c.a.a)localObject8).errCode == 0)
        {
          i5 = i;
          i4 = k;
          i3 = i6;
          if (((c.a.a)localObject8).width > 0)
          {
            i5 = i;
            i4 = k;
            i3 = i6;
            if (((c.a.a)localObject8).height > 0)
            {
              i5 = i;
              i4 = k;
              i3 = i6;
              if (((c.a.a)localObject8).bitrate > 0)
              {
                i5 = ((c.a.a)localObject8).width;
                i4 = ((c.a.a)localObject8).height;
                i3 = ((c.a.a)localObject8).bitrate;
                ac.i(TAG, "video abaResult, width:" + i5 + ", height:" + i4 + ", " + i3);
              }
            }
          }
        }
        i = a(l, j, str, i1, i2, d.IJ(i5), d.IJ(i4), i3, (VideoTransPara)localObject5, localbqs, (FinderMediaReportObject)localObject6, (String)localObject1, n, (d.g.a.b)new c.b((v.c)localObject7, j, this, (VideoTransPara)localObject5, (List)localObject4));
        bs.aO(l);
        if (i < 0)
        {
          a(h.gLO);
          AppMethodBeat.o(167731);
          return;
        }
        localObject1 = com.tencent.mm.plugin.vlog.model.l.AnC;
        localObject3 = com.tencent.mm.plugin.vlog.model.l.aye(str);
        if ((localObject3 == null) || (((l.a)localObject3).width <= 0) || (((l.a)localObject3).height <= 0) || (((l.a)localObject3).clj <= 0.0F))
        {
          localObject4 = TAG;
          localObject5 = new StringBuilder("normal video remuxVideo file error: ");
          if (localObject3 != null)
          {
            localObject1 = Integer.valueOf(((l.a)localObject3).width);
            localObject5 = ((StringBuilder)localObject5).append(localObject1).append(' ');
            if (localObject3 == null) {
              break label2684;
            }
          }
          label2684:
          for (localObject1 = Integer.valueOf(((l.a)localObject3).height);; localObject1 = null)
          {
            ac.i((String)localObject4, localObject1);
            localObject1 = i.b.ryD;
            i.b.cwZ();
            localObject1 = i.b.ryD;
            i.b.cxa();
            a(h.gLO);
            AppMethodBeat.o(167731);
            return;
            localObject1 = null;
            break;
          }
        }
        if (((c.a.a)localObject8).rMF == null) {
          break label3543;
        }
      }
      for (;;)
      {
        try
        {
          SightVideoJNI.addReportMetadata(str, ((c.a.a)localObject8).rMF, ((VideoTransPara)localObject5).hCL, 0);
          i = 1;
        }
        catch (Throwable localThrowable)
        {
          i = 1;
          continue;
        }
        aZ(1.0F);
        localObject3 = this.rMD.getMediaList();
        localObject7 = ((Iterable)localObject3).iterator();
        if (((Iterator)localObject7).hasNext())
        {
          localObject1 = ((Iterator)localObject7).next();
          localObject8 = (bqs)localObject1;
          if (!k.g(localbqs.mediaId, ((bqs)localObject8).mediaId)) {
            continue;
          }
          localObject1 = (bqs)localObject1;
          if (localObject1 == null) {
            break label3517;
          }
          k.h(localObject5, "videoParams");
          k.h(localbqs, "localMedia");
          k.h(str, "outputPath");
          k.h(localObject1, "media");
          k.h(localObject6, "reportObject");
          k = ((VideoTransPara)localObject5).hCK;
          n = (int)(localbqs.height / localbqs.width * k);
          localObject7 = e.rMX;
          k.h(str, "input");
          localObject7 = p.rQw;
          localObject7 = p.aeL(str);
          ac.i(e.TAG, "genVideoThumbFileForPost input:" + str + ", targetWidth:" + k + ", targetHeight:" + n + ", thumbRect:" + null + ", dstPath:" + (String)localObject7);
          localObject7 = e.a(str, k, n, null, (String)localObject7);
          ((bqs)localObject1).FfS = ((FinderMediaReportObject)localObject6);
          ((bqs)localObject1).url = str;
          ((bqs)localObject1).thumbUrl = ((String)localObject7);
          ((bqs)localObject1).FfP = false;
          ((bqs)localObject1).mediaId = ah.dg(localbqs.url);
          ((bqs)localObject1).fileSize = ((int)i.aSp(str));
          ((bqs)localObject1).FfS.target = new FinderMediaReportInfo();
          ((bqs)localObject1).FfS.target.fileSize = ((bqs)localObject1).fileSize;
          localObject6 = ((bqs)localObject1).FfQ;
          if (localObject6 != null) {
            ((yo)localObject6).Esn = false;
          }
          localObject6 = com.tencent.mm.plugin.sight.base.e.asx(str);
          if (localObject6 != null)
          {
            ((bqs)localObject1).videoDuration = ((com.tencent.mm.plugin.sight.base.a)localObject6).getVideoDuration();
            ((bqs)localObject1).FfS.target.videoDuration = ((com.tencent.mm.plugin.sight.base.a)localObject6).videoDuration;
            ((bqs)localObject1).FfS.target.width = ((com.tencent.mm.plugin.sight.base.a)localObject6).width;
            ((bqs)localObject1).FfS.target.height = ((com.tencent.mm.plugin.sight.base.a)localObject6).height;
            ((bqs)localObject1).FfS.target.videoBitrate = ((com.tencent.mm.plugin.sight.base.a)localObject6).videoBitrate;
          }
          ac.i(TAG, "processList index " + j + " url " + localbqs.url + " thumbUrl: " + localbqs.thumbUrl + " newMd5: " + ah.dg(localbqs.url) + " size:" + bs.qz(i.aSp(localbqs.url)));
          this.rMD.setMediaList((LinkedList)localObject3);
          localObject1 = this.rMD.field_reportObject;
          if (localObject1 != null)
          {
            ((FinderFeedReportObject)localObject1).remuxEndTime = ce.azJ();
            ((FinderFeedReportObject)localObject1).remuxType = i;
            localObject1 = y.KTp;
          }
          ((PluginFinder)g.ad(PluginFinder.class)).getFeedStorage().a(this.rMD.getLocalId(), this.rMD);
          j = m;
          break;
          k.g(localObject5, "videoParams");
          if (a(l, j, str, (VideoTransPara)localObject5, localbqs, (FinderMediaReportObject)localObject6) < 0)
          {
            a(h.gLO);
            AppMethodBeat.o(167731);
            return;
          }
          localObject2 = com.tencent.mm.plugin.vlog.model.l.AnC;
          localObject3 = com.tencent.mm.plugin.vlog.model.l.aye(str);
          if ((localObject3 != null) && (((l.a)localObject3).width > 0) && (((l.a)localObject3).height > 0) && (((l.a)localObject3).clj > 0.0F)) {
            break label3538;
          }
          localObject4 = TAG;
          localObject5 = new StringBuilder("remuxVideo file error: ");
          if (localObject3 != null)
          {
            localObject2 = Integer.valueOf(((l.a)localObject3).width);
            localObject5 = ((StringBuilder)localObject5).append(localObject2).append(' ');
            if (localObject3 == null) {
              break label3505;
            }
          }
          label3505:
          for (localObject2 = Integer.valueOf(((l.a)localObject3).height);; localObject2 = null)
          {
            ac.i((String)localObject4, localObject2);
            a(h.gLO);
            AppMethodBeat.o(167731);
            return;
            localObject2 = null;
            break;
          }
        }
        localObject2 = null;
        continue;
        label3517:
        j = m;
        break;
        a(h.gLN);
        AppMethodBeat.o(167731);
        return;
        label3538:
        i = 2;
        continue;
        label3543:
        i = 1;
      }
      label3548:
      Object localObject2 = localObject3;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/upload/FinderMediaProcessTask$Companion;", "", "()V", "RemuxTypeNormalVideo", "", "RemuxTypeTavkit", "TAG", "", "getTAG", "()Ljava/lang/String;", "checkRemuxVideo", "path", "width", "height", "videoParams", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "localId", "", "convertViewRect", "Landroid/graphics/Rect;", "viewRect", "Lcom/tencent/mm/protocal/protobuf/ViewRect;", "getABAResult", "Lcom/tencent/mm/plugin/finder/upload/FinderMediaProcessTask$Companion$ABAResult;", "input", "durationSec", "", "startTimeSec", "videoTransPara", "ABAResult", "plugin-finder_release"})
  public static final class a
  {
    public static int a(String paramString, int paramInt1, int paramInt2, VideoTransPara paramVideoTransPara, long paramLong)
    {
      AppMethodBeat.i(167727);
      k.h(paramVideoTransPara, "videoParams");
      long l = i.aSp(paramString);
      Object localObject = i.b.ryD;
      i.b.uy(l);
      localObject = com.tencent.mm.plugin.finder.storage.b.rCU;
      if (l > com.tencent.mm.plugin.finder.storage.b.cyc())
      {
        ac.i(c.access$getTAG$cp(), "checkRemuxVideo need remux zip");
        localObject = i.b.ryD;
        i.b.cxb();
        l = bs.Gn();
        localObject = paramString + ".remux";
        paramInt1 = SightVideoJNI.remuxingVFS(paramString, (String)localObject, paramInt1, paramInt2, paramVideoTransPara.videoBitrate, com.tencent.mm.plugin.sight.base.c.xCr, 8, 2, 25.0F, paramVideoTransPara.fps, null, 0, com.tencent.mm.plugin.sight.base.c.xCq, 0, 51);
        ac.i(c.access$getTAG$cp(), "checkRemuxVideo remux cost:" + bs.aO(l) + "ms, ret:" + paramInt1 + " localId:" + paramLong);
        paramVideoTransPara = i.b.ryD;
        i.b.uz(bs.aO(l));
        if (paramInt1 >= 0)
        {
          i.ma((String)localObject, paramString);
          paramLong = i.aSp((String)localObject);
          paramString = i.b.ryD;
          i.b.uA(paramLong);
          paramString = com.tencent.mm.plugin.finder.storage.b.rCU;
          if (paramLong > com.tencent.mm.plugin.finder.storage.b.cyc())
          {
            AppMethodBeat.o(167727);
            return -3;
          }
          AppMethodBeat.o(167727);
          return 0;
        }
        paramString = i.b.ryD;
        i.b.cxc();
        AppMethodBeat.o(167727);
        return -2;
      }
      ac.i(c.access$getTAG$cp(), "checkRemuxVideo, no need remux");
      AppMethodBeat.o(167727);
      return 0;
    }
    
    public static Rect a(dqk paramdqk)
    {
      AppMethodBeat.i(167726);
      k.h(paramdqk, "viewRect");
      paramdqk = new Rect(paramdqk.left, paramdqk.top, paramdqk.right, paramdqk.bottom);
      AppMethodBeat.o(167726);
      return paramdqk;
    }
    
    public static a a(String paramString, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, VideoTransPara paramVideoTransPara)
    {
      AppMethodBeat.i(167728);
      k.h(paramString, "input");
      k.h(paramVideoTransPara, "videoTransPara");
      for (;;)
      {
        try
        {
          com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.rCU;
          if (!com.tencent.mm.plugin.finder.storage.b.cyb()) {
            continue;
          }
          paramString = AdaptiveAdjustBitrate.a(paramString, paramInt2, paramInt1, paramVideoTransPara.fps, paramVideoTransPara.videoBitrate, paramFloat1, paramFloat2, 4, paramVideoTransPara.hCN, paramVideoTransPara.hCO, paramVideoTransPara.hCP, paramVideoTransPara.hCQ, paramVideoTransPara.hCR, paramVideoTransPara.hCS, paramVideoTransPara.hCT);
          j = paramVideoTransPara.videoBitrate;
          i = -1;
          if ((paramString == null) || (paramString[3] <= 0)) {
            break label245;
          }
          j = paramString[0] * 1000;
          i = 0;
          ac.i(c.access$getTAG$cp(), "getABAResult use videoBitrate:".concat(String.valueOf(j)));
        }
        catch (Throwable paramString)
        {
          int j;
          label139:
          paramString = new a(-1, 0, 0, 0, null);
          AppMethodBeat.o(167728);
          return paramString;
        }
        ac.i(c.access$getTAG$cp(), "ABA:  finder video bitrate:" + j + " width: " + k + " height:" + paramInt1);
        if (o.aJz() != null) {
          com.tencent.mm.an.e.q(paramString);
        }
        paramString = new a(i, k, paramInt1, j, paramString);
        AppMethodBeat.o(167728);
        return paramString;
        label245:
        do
        {
          k = paramInt1;
          paramInt1 = paramInt2;
          break label139;
          if (paramString[4] > 0) {
            break;
          }
        } while ((paramString == null) || (paramString[5] <= 0));
        int k = paramString[1];
        paramInt1 = paramString[2];
        int i = 0;
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/upload/FinderMediaProcessTask$Companion$ABAResult;", "", "errCode", "", "width", "height", "bitrate", "abaParams", "", "(IIII[I)V", "getAbaParams", "()[I", "getBitrate", "()I", "getErrCode", "getHeight", "getWidth", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder_release"})
    public static final class a
    {
      public final int bitrate;
      public final int errCode;
      public final int height;
      public final int[] rMF;
      public final int width;
      
      public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
      {
        this.errCode = paramInt1;
        this.width = paramInt2;
        this.height = paramInt3;
        this.bitrate = paramInt4;
        this.rMF = paramArrayOfInt;
      }
      
      public final boolean equals(Object paramObject)
      {
        AppMethodBeat.i(167725);
        if (this != paramObject)
        {
          if ((paramObject instanceof a))
          {
            paramObject = (a)paramObject;
            if ((this.errCode != paramObject.errCode) || (this.width != paramObject.width) || (this.height != paramObject.height) || (this.bitrate != paramObject.bitrate) || (!k.g(this.rMF, paramObject.rMF))) {}
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
        int[] arrayOfInt = this.rMF;
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
        String str = "ABAResult(errCode=" + this.errCode + ", width=" + this.width + ", height=" + this.height + ", bitrate=" + this.bitrate + ", abaParams=" + Arrays.toString(this.rMF) + ")";
        AppMethodBeat.o(167723);
        return str;
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.b<String, y>
  {
    f(c paramc, v.d paramd, int paramInt1, FinderMediaReportObject paramFinderMediaReportObject, long paramLong, int paramInt2, int paramInt3, VideoTransPara paramVideoTransPara, Object paramObject, v.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.c
 * JD-Core Version:    0.7.0.1
 */