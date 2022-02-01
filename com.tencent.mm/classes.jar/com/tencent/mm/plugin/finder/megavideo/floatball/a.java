package com.tencent.mm.plugin.finder.megavideo.floatball;

import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.finder.feed.ui.FinderLongVideoTimelineUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLongVideoTimelineUI.a;
import com.tencent.mm.plugin.finder.model.ca;
import com.tencent.mm.plugin.finder.report.ax;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.dnq;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.k;
import kotlin.o;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/megavideo/floatball/FinderMegaVideoMiniViewHelper;", "Lcom/tencent/mm/plugin/finder/floatball/BaseFinderMiniViewHelper;", "()V", "addMiniView", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "needPost", "", "megaVideoFeedId", "", "feedId", "generateWindowClickListener", "Landroid/view/View$OnClickListener;", "removeMiniView", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.plugin.finder.floatball.a
{
  public static final a Ezy;
  private static final kotlin.j<a> nqI;
  
  static
  {
    AppMethodBeat.i(341803);
    Ezy = new a((byte)0);
    nqI = k.a(o.aiuF, (kotlin.g.a.a)b.Ezz);
    AppMethodBeat.o(341803);
  }
  
  public a()
  {
    AppMethodBeat.i(341769);
    z localz = z.FrZ;
    J(22, z.bUm());
    cYv().mUU = 17;
    AppMethodBeat.o(341769);
  }
  
  /* Error */
  private static final void a(a parama, android.view.View paramView)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore 5
    //   3: ldc 109
    //   5: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: new 111	java/lang/Object
    //   11: dup
    //   12: invokespecial 112	java/lang/Object:<init>	()V
    //   15: astore 7
    //   17: new 114	com/tencent/mm/hellhoundlib/b/b
    //   20: dup
    //   21: invokespecial 115	com/tencent/mm/hellhoundlib/b/b:<init>	()V
    //   24: astore 8
    //   26: aload 8
    //   28: aload_0
    //   29: invokevirtual 119	com/tencent/mm/hellhoundlib/b/b:cH	(Ljava/lang/Object;)V
    //   32: aload 8
    //   34: aload_1
    //   35: invokevirtual 119	com/tencent/mm/hellhoundlib/b/b:cH	(Ljava/lang/Object;)V
    //   38: ldc 121
    //   40: ldc 123
    //   42: ldc 125
    //   44: ldc 127
    //   46: aload 7
    //   48: aload 8
    //   50: invokevirtual 131	com/tencent/mm/hellhoundlib/b/b:aYj	()[Ljava/lang/Object;
    //   53: invokestatic 137	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V
    //   56: aload_0
    //   57: ldc 139
    //   59: invokestatic 145	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   62: new 147	android/content/Intent
    //   65: dup
    //   66: invokespecial 148	android/content/Intent:<init>	()V
    //   69: astore_1
    //   70: aload_1
    //   71: ldc 150
    //   73: iconst_1
    //   74: invokevirtual 154	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   77: pop
    //   78: aload_0
    //   79: invokevirtual 158	com/tencent/mm/plugin/finder/megavideo/floatball/a:egj	()Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoMiniView;
    //   82: getfield 164	com/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoMiniView:nnu	Z
    //   85: ifne +205 -> 290
    //   88: aload_0
    //   89: invokevirtual 158	com/tencent/mm/plugin/finder/megavideo/floatball/a:egj	()Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoMiniView;
    //   92: invokevirtual 168	com/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoMiniView:getVideoView	()Lcom/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy;
    //   95: astore 7
    //   97: aload 7
    //   99: ifnull +191 -> 290
    //   102: aload 7
    //   104: invokevirtual 174	com/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy:getCurrentPlayMs	()J
    //   107: lstore_3
    //   108: aload_1
    //   109: ldc 176
    //   111: lload_3
    //   112: invokevirtual 179	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   115: pop
    //   116: aload_0
    //   117: invokevirtual 158	com/tencent/mm/plugin/finder/megavideo/floatball/a:egj	()Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoMiniView;
    //   120: invokevirtual 168	com/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoMiniView:getVideoView	()Lcom/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy;
    //   123: astore 7
    //   125: aload 7
    //   127: ifnonnull +168 -> 295
    //   130: fconst_1
    //   131: fstore_2
    //   132: aload_1
    //   133: ldc 181
    //   135: fload_2
    //   136: invokevirtual 184	android/content/Intent:putExtra	(Ljava/lang/String;F)Landroid/content/Intent;
    //   139: pop
    //   140: aload_0
    //   141: getfield 188	com/tencent/mm/plugin/finder/megavideo/floatball/a:vjV	Lcom/tencent/mm/plugin/ball/model/BallInfo;
    //   144: ldc 190
    //   146: invokevirtual 196	com/tencent/mm/plugin/ball/model/BallInfo:getByteArrayExtra	(Ljava/lang/String;)[B
    //   149: astore 8
    //   151: new 198	com/tencent/mm/protocal/protobuf/dnq
    //   154: dup
    //   155: invokespecial 199	com/tencent/mm/protocal/protobuf/dnq:<init>	()V
    //   158: astore 7
    //   160: aload 7
    //   162: aload 8
    //   164: invokevirtual 203	com/tencent/mm/protocal/protobuf/dnq:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   167: pop
    //   168: aload 7
    //   170: getfield 207	com/tencent/mm/protocal/protobuf/dnq:aaUQ	Ljava/util/LinkedList;
    //   173: astore 8
    //   175: aload 8
    //   177: ldc 209
    //   179: invokestatic 212	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   182: aload 8
    //   184: checkcast 214	java/lang/Iterable
    //   187: astore 9
    //   189: new 216	java/util/ArrayList
    //   192: dup
    //   193: aload 9
    //   195: bipush 10
    //   197: invokestatic 221	kotlin/a/p:a	(Ljava/lang/Iterable;I)I
    //   200: invokespecial 223	java/util/ArrayList:<init>	(I)V
    //   203: checkcast 225	java/util/Collection
    //   206: astore 8
    //   208: aload 9
    //   210: invokeinterface 229 1 0
    //   215: astore 9
    //   217: aload 9
    //   219: invokeinterface 235 1 0
    //   224: ifeq +103 -> 327
    //   227: aload 9
    //   229: invokeinterface 239 1 0
    //   234: checkcast 241	com/tencent/mm/protocal/protobuf/FinderObject
    //   237: astore 10
    //   239: getstatic 246	com/tencent/mm/plugin/finder/storage/FinderItem:Companion	Lcom/tencent/mm/plugin/finder/storage/FinderItem$a;
    //   242: astore 11
    //   244: aload 10
    //   246: ldc 248
    //   248: invokestatic 212	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   251: aload 10
    //   253: iconst_1
    //   254: invokestatic 254	com/tencent/mm/plugin/finder/storage/FinderItem$a:e	(Lcom/tencent/mm/protocal/protobuf/FinderObject;I)Lcom/tencent/mm/plugin/finder/storage/FinderItem;
    //   257: astore 10
    //   259: getstatic 260	com/tencent/mm/plugin/finder/storage/logic/d:FND	Lcom/tencent/mm/plugin/finder/storage/logic/d$a;
    //   262: astore 11
    //   264: aload 10
    //   266: invokestatic 265	com/tencent/mm/plugin/finder/storage/logic/d$a:a	(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;
    //   269: astore 10
    //   271: aload 10
    //   273: iconst_1
    //   274: putfield 270	com/tencent/mm/plugin/finder/model/BaseFinderFeed:ignoreLongTerm	Z
    //   277: aload 8
    //   279: aload 10
    //   281: invokeinterface 274 2 0
    //   286: pop
    //   287: goto -70 -> 217
    //   290: lconst_0
    //   291: lstore_3
    //   292: goto -184 -> 108
    //   295: aload 7
    //   297: invokevirtual 278	com/tencent/mm/plugin/finder/video/FinderThumbPlayerProxy:getPlaySpeedRatio	()F
    //   300: fstore_2
    //   301: goto -169 -> 132
    //   304: astore 8
    //   306: ldc_w 280
    //   309: ldc_w 282
    //   312: iconst_1
    //   313: anewarray 111	java/lang/Object
    //   316: dup
    //   317: iconst_0
    //   318: aload 8
    //   320: aastore
    //   321: invokestatic 287	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   324: goto -156 -> 168
    //   327: aload 8
    //   329: checkcast 289	java/util/List
    //   332: astore 8
    //   334: getstatic 295	com/tencent/mm/plugin/finder/utils/av:GiL	Lcom/tencent/mm/plugin/finder/utils/av;
    //   337: astore 9
    //   339: aload 7
    //   341: getfield 298	com/tencent/mm/protocal/protobuf/dnq:aaUN	I
    //   344: aload 8
    //   346: aload 7
    //   348: getfield 302	com/tencent/mm/protocal/protobuf/dnq:lastBuffer	Lcom/tencent/mm/bx/b;
    //   351: aload_1
    //   352: invokestatic 305	com/tencent/mm/plugin/finder/utils/av:a	(ILjava/util/List;Lcom/tencent/mm/bx/b;Landroid/content/Intent;)V
    //   355: aload_1
    //   356: ldc_w 307
    //   359: aload 7
    //   361: getfield 310	com/tencent/mm/protocal/protobuf/dnq:aaUP	I
    //   364: invokevirtual 313	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   367: pop
    //   368: aload_1
    //   369: ldc 190
    //   371: aload 7
    //   373: invokevirtual 317	com/tencent/mm/protocal/protobuf/dnq:toByteArray	()[B
    //   376: invokevirtual 320	android/content/Intent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   379: pop
    //   380: aload_1
    //   381: ldc_w 322
    //   384: aload_0
    //   385: getfield 188	com/tencent/mm/plugin/finder/megavideo/floatball/a:vjV	Lcom/tencent/mm/plugin/ball/model/BallInfo;
    //   388: ldc_w 322
    //   391: iconst_0
    //   392: invokevirtual 326	com/tencent/mm/plugin/ball/model/BallInfo:getIntExtra	(Ljava/lang/String;I)I
    //   395: invokevirtual 313	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   398: pop
    //   399: aload_1
    //   400: ldc_w 328
    //   403: aload_0
    //   404: getfield 188	com/tencent/mm/plugin/finder/megavideo/floatball/a:vjV	Lcom/tencent/mm/plugin/ball/model/BallInfo;
    //   407: ldc_w 328
    //   410: ldc_w 329
    //   413: invokevirtual 333	com/tencent/mm/plugin/ball/model/BallInfo:fy	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   416: invokevirtual 336	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   419: pop
    //   420: aload_1
    //   421: ldc_w 337
    //   424: invokevirtual 341	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   427: pop
    //   428: ldc_w 343
    //   431: invokestatic 349	com/tencent/mm/kernel/h:az	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   434: checkcast 343	com/tencent/mm/plugin/findersdk/a/cn
    //   437: bipush 8
    //   439: bipush 6
    //   441: bipush 45
    //   443: aload_1
    //   444: invokeinterface 353 5 0
    //   449: astore 7
    //   451: getstatic 359	com/tencent/mm/plugin/finder/utils/a:GfO	Lcom/tencent/mm/plugin/finder/utils/a;
    //   454: astore 9
    //   456: invokestatic 365	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   459: astore 9
    //   461: aload 9
    //   463: ldc_w 367
    //   466: invokestatic 212	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   469: aload 9
    //   471: aload_1
    //   472: iconst_1
    //   473: invokestatic 371	com/tencent/mm/plugin/finder/utils/a:h	(Landroid/content/Context;Landroid/content/Intent;Z)V
    //   476: aload_0
    //   477: getfield 188	com/tencent/mm/plugin/finder/megavideo/floatball/a:vjV	Lcom/tencent/mm/plugin/ball/model/BallInfo;
    //   480: ldc_w 328
    //   483: ldc_w 329
    //   486: invokevirtual 333	com/tencent/mm/plugin/ball/model/BallInfo:fy	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   489: astore_0
    //   490: getstatic 377	com/tencent/mm/plugin/finder/report/ax:Fur	Lcom/tencent/mm/plugin/finder/report/ax;
    //   493: astore_1
    //   494: aload_0
    //   495: ldc_w 379
    //   498: invokestatic 212	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   501: aload 8
    //   503: invokestatic 383	kotlin/a/p:oL	(Ljava/util/List;)Ljava/lang/Object;
    //   506: checkcast 267	com/tencent/mm/plugin/finder/model/BaseFinderFeed
    //   509: astore_1
    //   510: aload_1
    //   511: ifnonnull +59 -> 570
    //   514: lload 5
    //   516: lstore_3
    //   517: lload_3
    //   518: invokestatic 389	com/tencent/mm/ae/d:hF	(J)Ljava/lang/String;
    //   521: astore_1
    //   522: aload 7
    //   524: ldc_w 391
    //   527: invokestatic 212	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   530: iconst_1
    //   531: aload_0
    //   532: iconst_0
    //   533: aload_1
    //   534: ldc_w 329
    //   537: aload 7
    //   539: ldc_w 329
    //   542: iconst_1
    //   543: invokestatic 394	com/tencent/mm/plugin/finder/report/ax:a	(ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   546: new 111	java/lang/Object
    //   549: dup
    //   550: invokespecial 112	java/lang/Object:<init>	()V
    //   553: ldc 121
    //   555: ldc 123
    //   557: ldc 125
    //   559: ldc 127
    //   561: invokestatic 397	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   564: ldc 109
    //   566: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   569: return
    //   570: aload_1
    //   571: invokevirtual 400	com/tencent/mm/plugin/finder/model/BaseFinderFeed:bZA	()J
    //   574: lstore_3
    //   575: goto -58 -> 517
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	578	0	parama	a
    //   0	578	1	paramView	android.view.View
    //   131	170	2	f	float
    //   107	468	3	l1	long
    //   1	514	5	l2	long
    //   15	523	7	localObject1	Object
    //   24	254	8	localObject2	Object
    //   304	24	8	localObject3	Object
    //   332	170	8	localList	List
    //   187	283	9	localObject4	Object
    //   237	43	10	localObject5	Object
    //   242	21	11	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   160	168	304	finally
  }
  
  public final void a(com.tencent.mm.view.recyclerview.j paramj, boolean paramBoolean, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(341822);
    s.u(paramj, "holder");
    b(paramj, paramBoolean);
    long l = com.tencent.mm.model.cn.bDw();
    String str2 = s.X("uin_", Long.valueOf(l));
    this.vjV.fx("KEY_FLOAT_BALL_MINI_SESSION_ID", str2);
    Object localObject1 = as.GSQ;
    paramj = paramj.context;
    s.s(paramj, "holder.context");
    paramj = as.a.hu(paramj);
    Object localObject3;
    label97:
    label107:
    Object localObject2;
    label117:
    String str1;
    if (paramj == null)
    {
      localObject3 = null;
      paramj = ax.Fur;
      String str3 = d.hF(paramLong1);
      if (localObject3 != null) {
        break label208;
      }
      paramj = "";
      if (localObject3 != null) {
        break label230;
      }
      localObject1 = "";
      if (localObject3 != null) {
        break label254;
      }
      localObject2 = "";
      ax.a(3, str2, 0, str3, paramj, (String)localObject1, (String)localObject2, true);
      paramj = ax.Fur;
      str1 = d.hF(paramLong1);
      if (localObject3 != null) {
        break label278;
      }
      paramj = "";
      label151:
      if (localObject3 != null) {
        break label300;
      }
      localObject1 = "";
      label161:
      if (localObject3 != null) {
        break label324;
      }
      localObject2 = "";
    }
    for (;;)
    {
      ax.a(l, 2, 0, str1, str2, paramj, (String)localObject1, (String)localObject2, d.hF(paramLong2));
      AppMethodBeat.o(341822);
      return;
      localObject3 = paramj.fou();
      break;
      label208:
      localObject1 = ((bui)localObject3).sessionId;
      paramj = (com.tencent.mm.view.recyclerview.j)localObject1;
      if (localObject1 != null) {
        break label97;
      }
      paramj = "";
      break label97;
      label230:
      localObject2 = ((bui)localObject3).zIO;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label107;
      }
      localObject1 = "";
      break label107;
      label254:
      str1 = ((bui)localObject3).zIB;
      localObject2 = str1;
      if (str1 != null) {
        break label117;
      }
      localObject2 = "";
      break label117;
      label278:
      localObject1 = ((bui)localObject3).sessionId;
      paramj = (com.tencent.mm.view.recyclerview.j)localObject1;
      if (localObject1 != null) {
        break label151;
      }
      paramj = "";
      break label151;
      label300:
      localObject2 = ((bui)localObject3).zIO;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label161;
      }
      localObject1 = "";
      break label161;
      label324:
      localObject3 = ((bui)localObject3).zIB;
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
    }
  }
  
  public final View.OnClickListener egk()
  {
    AppMethodBeat.i(341838);
    a..ExternalSyntheticLambda0 localExternalSyntheticLambda0 = new a..ExternalSyntheticLambda0(this);
    AppMethodBeat.o(341838);
    return localExternalSyntheticLambda0;
  }
  
  public final boolean ego()
  {
    AppMethodBeat.i(341830);
    boolean bool = super.ego();
    Object localObject2;
    Object localObject1;
    if (bool)
    {
      localObject2 = this.vjV.getByteArrayExtra("KEY_VIDEO_FLOAT_BALL_INFO");
      localObject1 = new dnq();
    }
    try
    {
      ((dnq)localObject1).parseFrom((byte[])localObject2);
      localObject2 = FinderLongVideoTimelineUI.Bqh;
      int i = FinderLongVideoTimelineUI.a.Op(((dnq)localObject1).aaUP);
      localObject2 = ((com.tencent.mm.plugin.findersdk.a.cn)h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).fillContextIdToIntent(8, 6, i, null);
      localObject1 = ((dnq)localObject1).aaUQ;
      s.s(localObject1, "floatBallInfo.cacheNewVideoList");
      localObject1 = (FinderObject)p.oL((List)localObject1);
      if (localObject1 == null)
      {
        localObject1 = null;
        String str = this.vjV.fy("KEY_FLOAT_BALL_MINI_SESSION_ID", "");
        ax localax = ax.Fur;
        s.s(str, "miniSessionId");
        if (localObject1 != null) {
          break label226;
        }
        l = 0L;
        localObject1 = d.hF(l);
        s.s(localObject2, "contextId");
        ax.a(5, str, 0, (String)localObject1, "", (String)localObject2, "", true);
        AppMethodBeat.o(341830);
        return bool;
      }
    }
    finally
    {
      for (;;)
      {
        Log.e("FinderMegaVideoMiniViewHelper", "handleBallInfoClicked", new Object[] { localObject3 });
        continue;
        localObject1 = new ca((FinderObject)localObject1);
        continue;
        label226:
        long l = ((ca)localObject1).bZA();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/megavideo/floatball/FinderMegaVideoMiniViewHelper$Companion;", "", "()V", "KEY_OPEN_FROM_VIDEO_FLOAT_BALL", "", "TAG", "instance", "Lcom/tencent/mm/plugin/finder/megavideo/floatball/FinderMegaVideoMiniViewHelper;", "getInstance", "()Lcom/tencent/mm/plugin/finder/megavideo/floatball/FinderMegaVideoMiniViewHelper;", "instance$delegate", "Lkotlin/Lazy;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static a eCH()
    {
      AppMethodBeat.i(341760);
      a locala = (a)a.blL().getValue();
      AppMethodBeat.o(341760);
      return locala;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/megavideo/floatball/FinderMegaVideoMiniViewHelper;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<a>
  {
    public static final b Ezz;
    
    static
    {
      AppMethodBeat.i(341758);
      Ezz = new b();
      AppMethodBeat.o(341758);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.floatball.a
 * JD-Core Version:    0.7.0.1
 */