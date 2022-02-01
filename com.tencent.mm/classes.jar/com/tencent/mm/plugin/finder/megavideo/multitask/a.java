package com.tencent.mm.plugin.finder.megavideo.multitask;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.megavideo.ui.f;
import com.tencent.mm.plugin.finder.report.ax;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.multitask.b.c;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.taskbar.api.b.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.atq;
import com.tencent.mm.protocal.protobuf.atr;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.byx;
import com.tencent.mm.protocal.protobuf.dne;
import com.tencent.mm.protocal.protobuf.dno;
import com.tencent.mm.protocal.protobuf.dnq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/megavideo/multitask/MegaVideoMultiTaskHelper;", "Lcom/tencent/mm/plugin/multitask/helper/PageMultiTaskHelper;", "context", "Landroid/content/Context;", "pageAdapter", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;)V", "getContext", "()Landroid/content/Context;", "isSupportExitToMultiTask", "", "()Z", "isSupportMultiTaskFBMenu", "isSupportSwipeToMultiTask", "value", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLPresenter;", "presenter", "getPresenter", "()Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLPresenter;", "setPresenter", "(Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLPresenter;)V", "addOrUpdateCurrentHistoryTaskInfo", "", "addOrUpdateCurrentHistoryTaskInfoWithoutBitmap", "fillMultiTaskInfo", "hasCurrentTaskBarInfo", "isSupportSwipeToHome", "onClose", "way", "", "ended", "onMenuMultiTaskSelected", "enterMultiTask", "onSwipePageAddToMultiTask", "reportAddToMultiTask", "isFromSwipe", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends c
{
  public static final a EzW;
  private static final b EzX;
  public f Ezo;
  private final Context context;
  
  static
  {
    AppMethodBeat.i(341832);
    EzW = new a((byte)0);
    EzX = new b();
    AppMethodBeat.o(341832);
  }
  
  public a(Context paramContext, com.tencent.mm.plugin.multitask.a.a parama)
  {
    super(parama);
    AppMethodBeat.i(341789);
    this.context = paramContext;
    AppMethodBeat.o(341789);
  }
  
  private static final void a(a parama)
  {
    AppMethodBeat.i(341813);
    s.u(parama, "this$0");
    parama.as(null);
    AppMethodBeat.o(341813);
  }
  
  private static final void b(a parama)
  {
    AppMethodBeat.i(341821);
    s.u(parama, "this$0");
    Object localObject = parama.LBU;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((com.tencent.mm.plugin.multitask.a.a)localObject).getBitmap())
    {
      parama.as(parama.aq((Bitmap)localObject));
      AppMethodBeat.o(341821);
      return;
    }
  }
  
  private final void sL(boolean paramBoolean)
  {
    l2 = 0L;
    AppMethodBeat.i(341806);
    localObject4 = new dnq();
    for (;;)
    {
      try
      {
        localObject1 = this.LCE;
        if (localObject1 != null) {
          continue;
        }
        localObject1 = null;
        ((dnq)localObject4).parseFrom((byte[])localObject1);
      }
      finally
      {
        Object localObject1;
        long l3;
        String str;
        Log.e("MegaVideoFloatBallHelper", "handleBallInfoClicked", new Object[] { localObject2 });
        continue;
        Object localObject6 = localObject2.fou();
        continue;
        Object localObject3 = localObject2.attachmentList;
        if (localObject3 != null) {
          continue;
        }
        localObject3 = null;
        continue;
        localObject3 = ((atr)localObject3).ZEi;
        if (localObject3 != null) {
          continue;
        }
        localObject3 = null;
        continue;
        localObject4 = ((Iterable)localObject3).iterator();
        if (!((Iterator)localObject4).hasNext()) {
          continue;
        }
        localObject3 = ((Iterator)localObject4).next();
        Object localObject5 = (atq)localObject3;
        Object localObject7 = av.GiL;
        s.s(localObject5, "it");
        if (!av.a((atq)localObject5)) {
          continue;
        }
        localObject3 = (atq)localObject3;
        if (localObject3 != null) {
          continue;
        }
        localObject3 = null;
        continue;
        localObject3 = null;
        continue;
        localObject3 = ((atq)localObject3).ZEf;
        if (localObject3 != null) {
          continue;
        }
        localObject3 = null;
        continue;
        localObject3 = ((byx)localObject3).ZXx;
        continue;
        int i = 3;
        continue;
        long l1 = ((dne)localObject3).id;
        continue;
        localObject5 = ((bui)localObject6).sessionId;
        localObject4 = localObject5;
        if (localObject5 != null) {
          continue;
        }
        localObject4 = "";
        continue;
        localObject7 = ((bui)localObject6).zIO;
        localObject5 = localObject7;
        if (localObject7 != null) {
          continue;
        }
        localObject5 = "";
        continue;
        localObject7 = ((bui)localObject6).zIB;
        localObject6 = localObject7;
        if (localObject7 != null) {
          continue;
        }
        localObject6 = "";
        continue;
        localObject3 = ((dne)localObject3).aaUv;
        l1 = l2;
        if (localObject3 == null) {
          continue;
        }
        l1 = ((dno)localObject3).hKN;
        continue;
      }
      localObject1 = as.GSQ;
      localObject1 = as.a.hu(this.context);
      if (localObject1 != null) {
        continue;
      }
      localObject6 = null;
      localObject1 = ((dnq)localObject4).aaUQ;
      s.s(localObject1, "floatBallInfo.cacheNewVideoList");
      localObject1 = (FinderObject)p.ae((List)localObject1, ((dnq)localObject4).aaUN);
      if (localObject1 != null) {
        continue;
      }
      localObject1 = null;
      localObject4 = ax.Fur;
      l3 = cn.bDw();
      if (!paramBoolean) {
        continue;
      }
      i = 1;
      if (localObject1 != null) {
        continue;
      }
      l1 = 0L;
      str = d.hF(l1);
      if (localObject6 != null) {
        continue;
      }
      localObject4 = "";
      if (localObject6 != null) {
        continue;
      }
      localObject5 = "";
      if (localObject6 != null) {
        continue;
      }
      localObject6 = "";
      if (localObject1 != null) {
        continue;
      }
      l1 = l2;
      ax.a(l3, i, 0, str, "", (String)localObject4, (String)localObject5, (String)localObject6, d.hF(l1));
      AppMethodBeat.o(341806);
      return;
      localObject1 = ((MultiTaskInfo)localObject1).field_data;
    }
  }
  
  public final boolean af(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(341884);
    paramBoolean = super.af(paramInt, paramBoolean);
    AppMethodBeat.o(341884);
    return paramBoolean;
  }
  
  public final boolean cBZ()
  {
    return false;
  }
  
  public final boolean cCa()
  {
    return true;
  }
  
  public final boolean cCc()
  {
    return true;
  }
  
  public final void cCe()
  {
    AppMethodBeat.i(341856);
    f localf = this.Ezo;
    if (localf != null) {
      localf.ai(true, true);
    }
    AppMethodBeat.o(341856);
  }
  
  public final boolean eCI()
  {
    return true;
  }
  
  public final void eCJ()
  {
    AppMethodBeat.i(341891);
    h.ahAA.bn(new a..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(341891);
  }
  
  public final void eCK()
  {
    AppMethodBeat.i(341897);
    h.ahAA.bn(new a..ExternalSyntheticLambda1(this));
    AppMethodBeat.o(341897);
  }
  
  public final void eCL()
  {
    AppMethodBeat.i(341910);
    sL(true);
    AppMethodBeat.o(341910);
  }
  
  public final void ke(boolean paramBoolean)
  {
    AppMethodBeat.i(341904);
    super.ke(paramBoolean);
    if (paramBoolean) {
      sL(false);
    }
    AppMethodBeat.o(341904);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/megavideo/multitask/MegaVideoMultiTaskHelper$Companion;", "", "()V", "TAG", "", "taskBarEventListener", "com/tencent/mm/plugin/finder/megavideo/multitask/MegaVideoMultiTaskHelper$Companion$taskBarEventListener$1", "Lcom/tencent/mm/plugin/finder/megavideo/multitask/MegaVideoMultiTaskHelper$Companion$taskBarEventListener$1;", "handleClickMultiTask", "", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "animateData", "Lcom/tencent/mm/protocal/protobuf/MultiTaskAnimData;", "isFromMultiTask", "", "activity", "Landroid/app/Activity;", "startListeningTaskBarEvent", "stopListeningTaskBarEvent", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    /* Error */
    public static void a(MultiTaskInfo paramMultiTaskInfo, com.tencent.mm.protocal.protobuf.drt paramdrt, boolean paramBoolean, android.app.Activity paramActivity)
    {
      // Byte code:
      //   0: ldc 43
      //   2: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: ldc 50
      //   8: invokestatic 56	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
      //   11: new 58	com/tencent/mm/protocal/protobuf/dnq
      //   14: dup
      //   15: invokespecial 59	com/tencent/mm/protocal/protobuf/dnq:<init>	()V
      //   18: astore 9
      //   20: aload 9
      //   22: aload_0
      //   23: getfield 65	com/tencent/mm/plugin/multitask/model/MultiTaskInfo:field_data	[B
      //   26: invokevirtual 69	com/tencent/mm/protocal/protobuf/dnq:parseFrom	([B)Lcom/tencent/mm/bx/a;
      //   29: pop
      //   30: new 71	android/content/Intent
      //   33: dup
      //   34: invokespecial 72	android/content/Intent:<init>	()V
      //   37: astore 8
      //   39: aload 9
      //   41: getfield 76	com/tencent/mm/protocal/protobuf/dnq:aaUQ	Ljava/util/LinkedList;
      //   44: astore 7
      //   46: aload 7
      //   48: ldc 78
      //   50: invokestatic 81	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
      //   53: aload 7
      //   55: checkcast 83	java/util/List
      //   58: aload 9
      //   60: getfield 87	com/tencent/mm/protocal/protobuf/dnq:aaUN	I
      //   63: invokestatic 93	kotlin/a/p:ae	(Ljava/util/List;I)Ljava/lang/Object;
      //   66: ifnonnull +27 -> 93
      //   69: ldc 95
      //   71: ldc 97
      //   73: aload 9
      //   75: getfield 87	com/tencent/mm/protocal/protobuf/dnq:aaUN	I
      //   78: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   81: invokestatic 107	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
      //   84: invokestatic 113	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   87: aload 9
      //   89: iconst_0
      //   90: putfield 87	com/tencent/mm/protocal/protobuf/dnq:aaUN	I
      //   93: aload 9
      //   95: aload_0
      //   96: getfield 117	com/tencent/mm/plugin/multitask/model/MultiTaskInfo:field_id	Ljava/lang/String;
      //   99: putfield 120	com/tencent/mm/protocal/protobuf/dnq:key	Ljava/lang/String;
      //   102: aload 9
      //   104: getfield 76	com/tencent/mm/protocal/protobuf/dnq:aaUQ	Ljava/util/LinkedList;
      //   107: astore 7
      //   109: aload 7
      //   111: ldc 78
      //   113: invokestatic 81	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
      //   116: aload 7
      //   118: checkcast 122	java/lang/Iterable
      //   121: astore 10
      //   123: new 124	java/util/ArrayList
      //   126: dup
      //   127: aload 10
      //   129: bipush 10
      //   131: invokestatic 127	kotlin/a/p:a	(Ljava/lang/Iterable;I)I
      //   134: invokespecial 129	java/util/ArrayList:<init>	(I)V
      //   137: checkcast 131	java/util/Collection
      //   140: astore 7
      //   142: aload 10
      //   144: invokeinterface 135 1 0
      //   149: astore 10
      //   151: aload 10
      //   153: invokeinterface 141 1 0
      //   158: ifeq +77 -> 235
      //   161: aload 10
      //   163: invokeinterface 145 1 0
      //   168: checkcast 147	com/tencent/mm/protocal/protobuf/FinderObject
      //   171: astore 11
      //   173: getstatic 153	com/tencent/mm/plugin/finder/storage/FinderItem:Companion	Lcom/tencent/mm/plugin/finder/storage/FinderItem$a;
      //   176: astore 12
      //   178: aload 11
      //   180: ldc 155
      //   182: invokestatic 81	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
      //   185: aload 11
      //   187: iconst_1
      //   188: invokestatic 160	com/tencent/mm/plugin/finder/storage/FinderItem$a:e	(Lcom/tencent/mm/protocal/protobuf/FinderObject;I)Lcom/tencent/mm/plugin/finder/storage/FinderItem;
      //   191: astore 11
      //   193: getstatic 166	com/tencent/mm/plugin/finder/storage/logic/d:FND	Lcom/tencent/mm/plugin/finder/storage/logic/d$a;
      //   196: astore 12
      //   198: aload 7
      //   200: aload 11
      //   202: invokestatic 171	com/tencent/mm/plugin/finder/storage/logic/d$a:a	(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;
      //   205: invokeinterface 175 2 0
      //   210: pop
      //   211: goto -60 -> 151
      //   214: astore 7
      //   216: ldc 95
      //   218: ldc 177
      //   220: iconst_1
      //   221: anewarray 4	java/lang/Object
      //   224: dup
      //   225: iconst_0
      //   226: aload 7
      //   228: aastore
      //   229: invokestatic 180	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   232: goto -202 -> 30
      //   235: aload 7
      //   237: checkcast 83	java/util/List
      //   240: aload 9
      //   242: getfield 87	com/tencent/mm/protocal/protobuf/dnq:aaUN	I
      //   245: invokestatic 93	kotlin/a/p:ae	(Ljava/util/List;I)Ljava/lang/Object;
      //   248: checkcast 182	com/tencent/mm/plugin/finder/model/BaseFinderFeed
      //   251: astore 7
      //   253: aload 7
      //   255: ifnonnull +302 -> 557
      //   258: aconst_null
      //   259: astore 7
      //   261: aload 7
      //   263: ifnonnull +304 -> 567
      //   266: new 184	java/util/LinkedList
      //   269: dup
      //   270: invokespecial 185	java/util/LinkedList:<init>	()V
      //   273: checkcast 83	java/util/List
      //   276: astore 7
      //   278: aload 7
      //   280: invokestatic 189	kotlin/a/p:oL	(Ljava/util/List;)Ljava/lang/Object;
      //   283: checkcast 182	com/tencent/mm/plugin/finder/model/BaseFinderFeed
      //   286: astore 10
      //   288: aload 10
      //   290: ifnull +69 -> 359
      //   293: aload 9
      //   295: getfield 193	com/tencent/mm/protocal/protobuf/dnq:aaUR	J
      //   298: invokestatic 199	com/tencent/mm/model/cn:bDw	()J
      //   301: lcmp
      //   302: ifle +25 -> 327
      //   305: getstatic 205	com/tencent/mm/plugin/finder/utils/av:GiL	Lcom/tencent/mm/plugin/finder/utils/av;
      //   308: astore 11
      //   310: aload 9
      //   312: getfield 87	com/tencent/mm/protocal/protobuf/dnq:aaUN	I
      //   315: aload 7
      //   317: aload 9
      //   319: getfield 209	com/tencent/mm/protocal/protobuf/dnq:lastBuffer	Lcom/tencent/mm/bx/b;
      //   322: aload 8
      //   324: invokestatic 212	com/tencent/mm/plugin/finder/utils/av:a	(ILjava/util/List;Lcom/tencent/mm/bx/b;Landroid/content/Intent;)V
      //   327: aload 8
      //   329: ldc 214
      //   331: aload 10
      //   333: getfield 218	com/tencent/mm/plugin/finder/model/BaseFinderFeed:feedObject	Lcom/tencent/mm/plugin/finder/storage/FinderItem;
      //   336: invokevirtual 221	com/tencent/mm/plugin/finder/storage/FinderItem:getId	()J
      //   339: invokevirtual 225	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
      //   342: pop
      //   343: aload 8
      //   345: ldc 227
      //   347: aload 10
      //   349: getfield 218	com/tencent/mm/plugin/finder/model/BaseFinderFeed:feedObject	Lcom/tencent/mm/plugin/finder/storage/FinderItem;
      //   352: invokevirtual 231	com/tencent/mm/plugin/finder/storage/FinderItem:getObjectNonceId	()Ljava/lang/String;
      //   355: invokevirtual 234	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
      //   358: pop
      //   359: aload 8
      //   361: ldc 236
      //   363: iconst_0
      //   364: invokevirtual 239	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
      //   367: pop
      //   368: aload 8
      //   370: ldc 241
      //   372: aload 9
      //   374: invokevirtual 245	com/tencent/mm/protocal/protobuf/dnq:toByteArray	()[B
      //   377: invokevirtual 248	android/content/Intent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
      //   380: pop
      //   381: aload 8
      //   383: ldc 250
      //   385: aload 9
      //   387: getfield 253	com/tencent/mm/protocal/protobuf/dnq:aaUO	I
      //   390: i2l
      //   391: ldc2_w 254
      //   394: lmul
      //   395: invokevirtual 225	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
      //   398: pop
      //   399: getstatic 261	com/tencent/mm/plugin/multitask/h:LBd	Lcom/tencent/mm/plugin/multitask/h;
      //   402: astore 7
      //   404: aload 8
      //   406: ldc_w 263
      //   409: aload_0
      //   410: invokestatic 267	com/tencent/mm/plugin/multitask/h:g	(Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;)Ljava/lang/String;
      //   413: invokevirtual 234	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
      //   416: pop
      //   417: aload_1
      //   418: ifnonnull +152 -> 570
      //   421: aconst_null
      //   422: astore_0
      //   423: aload_0
      //   424: ifnonnull +37 -> 461
      //   427: new 269	com/tencent/mm/protocal/protobuf/aet
      //   430: dup
      //   431: invokespecial 270	com/tencent/mm/protocal/protobuf/aet:<init>	()V
      //   434: astore_0
      //   435: iload_2
      //   436: ifne +240 -> 676
      //   439: iconst_1
      //   440: istore 6
      //   442: aload_0
      //   443: iload 6
      //   445: putfield 274	com/tencent/mm/protocal/protobuf/aet:ZmN	Z
      //   448: aload 8
      //   450: ldc_w 276
      //   453: aload_0
      //   454: invokevirtual 277	com/tencent/mm/protocal/protobuf/aet:toByteArray	()[B
      //   457: invokevirtual 248	android/content/Intent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
      //   460: pop
      //   461: aload 8
      //   463: ldc_w 278
      //   466: invokevirtual 282	android/content/Intent:addFlags	(I)Landroid/content/Intent;
      //   469: pop
      //   470: getstatic 288	com/tencent/mm/plugin/finder/feed/ui/FinderLongVideoTimelineUI:Bqh	Lcom/tencent/mm/plugin/finder/feed/ui/FinderLongVideoTimelineUI$a;
      //   473: astore_0
      //   474: iconst_0
      //   475: invokestatic 294	com/tencent/mm/plugin/finder/feed/ui/FinderLongVideoTimelineUI$a:Op	(I)I
      //   478: istore 5
      //   480: ldc_w 296
      //   483: invokestatic 302	com/tencent/mm/kernel/h:az	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
      //   486: checkcast 296	com/tencent/mm/plugin/findersdk/a/cn
      //   489: astore_0
      //   490: iload_2
      //   491: ifeq +191 -> 682
      //   494: bipush 18
      //   496: istore 4
      //   498: aload_0
      //   499: iload 4
      //   501: iconst_2
      //   502: iload 5
      //   504: aload 8
      //   506: invokeinterface 306 5 0
      //   511: pop
      //   512: getstatic 312	com/tencent/mm/plugin/finder/utils/a:GfO	Lcom/tencent/mm/plugin/finder/utils/a;
      //   515: astore_0
      //   516: aload_3
      //   517: ifnonnull +172 -> 689
      //   520: invokestatic 318	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
      //   523: astore_0
      //   524: aload_0
      //   525: ldc_w 320
      //   528: invokestatic 81	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
      //   531: aload_0
      //   532: aload 8
      //   534: invokestatic 324	com/tencent/mm/plugin/finder/utils/a:au	(Landroid/content/Context;Landroid/content/Intent;)V
      //   537: iload_2
      //   538: ifeq +13 -> 551
      //   541: aload_3
      //   542: ifnull +9 -> 551
      //   545: aload_3
      //   546: iconst_0
      //   547: iconst_0
      //   548: invokevirtual 330	android/app/Activity:overridePendingTransition	(II)V
      //   551: ldc 43
      //   553: invokestatic 333	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   556: return
      //   557: aload 7
      //   559: invokestatic 337	kotlin/a/p:listOf	(Ljava/lang/Object;)Ljava/util/List;
      //   562: astore 7
      //   564: goto -303 -> 261
      //   567: goto -289 -> 278
      //   570: new 269	com/tencent/mm/protocal/protobuf/aet
      //   573: dup
      //   574: invokespecial 270	com/tencent/mm/protocal/protobuf/aet:<init>	()V
      //   577: astore 7
      //   579: aload 7
      //   581: aload_1
      //   582: putfield 341	com/tencent/mm/protocal/protobuf/aet:ZmM	Lcom/tencent/mm/protocal/protobuf/drt;
      //   585: iload_2
      //   586: ifne +64 -> 650
      //   589: iconst_1
      //   590: istore 6
      //   592: aload 7
      //   594: iload 6
      //   596: putfield 274	com/tencent/mm/protocal/protobuf/aet:ZmN	Z
      //   599: aload_3
      //   600: ifnull +33 -> 633
      //   603: getstatic 347	com/tencent/mm/plugin/secdata/ui/a:PlI	Lcom/tencent/mm/plugin/secdata/ui/a$a;
      //   606: astore_0
      //   607: aload_3
      //   608: checkcast 349	android/content/Context
      //   611: invokestatic 355	com/tencent/mm/plugin/secdata/ui/a$a:jC	(Landroid/content/Context;)Lcom/tencent/mm/plugin/secdata/ui/a;
      //   614: astore_0
      //   615: aload_0
      //   616: ifnonnull +40 -> 656
      //   619: aconst_null
      //   620: astore_0
      //   621: aload_0
      //   622: ifnonnull +46 -> 668
      //   625: aconst_null
      //   626: astore_0
      //   627: aload 7
      //   629: aload_0
      //   630: putfield 358	com/tencent/mm/protocal/protobuf/aet:zIO	Ljava/lang/String;
      //   633: aload 8
      //   635: ldc_w 276
      //   638: aload 7
      //   640: invokevirtual 277	com/tencent/mm/protocal/protobuf/aet:toByteArray	()[B
      //   643: invokevirtual 248	android/content/Intent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
      //   646: astore_0
      //   647: goto -224 -> 423
      //   650: iconst_0
      //   651: istore 6
      //   653: goto -61 -> 592
      //   656: aload_0
      //   657: iconst_5
      //   658: invokevirtual 362	com/tencent/mm/plugin/secdata/ui/a:aiK	(I)Lcom/tencent/mm/bx/a;
      //   661: checkcast 364	com/tencent/mm/protocal/protobuf/dry
      //   664: astore_0
      //   665: goto -44 -> 621
      //   668: aload_0
      //   669: getfield 365	com/tencent/mm/protocal/protobuf/dry:zIO	Ljava/lang/String;
      //   672: astore_0
      //   673: goto -46 -> 627
      //   676: iconst_0
      //   677: istore 6
      //   679: goto -237 -> 442
      //   682: bipush 17
      //   684: istore 4
      //   686: goto -188 -> 498
      //   689: aload_3
      //   690: checkcast 349	android/content/Context
      //   693: astore_0
      //   694: goto -170 -> 524
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	697	0	paramMultiTaskInfo	MultiTaskInfo
      //   0	697	1	paramdrt	com.tencent.mm.protocal.protobuf.drt
      //   0	697	2	paramBoolean	boolean
      //   0	697	3	paramActivity	android.app.Activity
      //   496	189	4	i	int
      //   478	25	5	j	int
      //   440	238	6	bool	boolean
      //   44	155	7	localObject1	Object
      //   214	22	7	localObject2	Object
      //   251	388	7	localObject3	Object
      //   37	597	8	localIntent	android.content.Intent
      //   18	368	9	localdnq	dnq
      //   121	227	10	localObject4	Object
      //   171	138	11	localObject5	Object
      //   176	21	12	localObject6	Object
      // Exception table:
      //   from	to	target	type
      //   20	30	214	finally
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/megavideo/multitask/MegaVideoMultiTaskHelper$Companion$taskBarEventListener$1", "Lcom/tencent/mm/plugin/taskbar/api/ITaskBarViewService$ITaskBarEventListener;", "onTaskBarItemClicked", "", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "onTaskBarItemExposed", "onTaskBarItemRemoved", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements b.a
  {
    public final void a(MultiTaskInfo paramMultiTaskInfo)
    {
      AppMethodBeat.i(341785);
      s.u(paramMultiTaskInfo, "multiTaskInfo");
      AppMethodBeat.o(341785);
    }
    
    public final void b(MultiTaskInfo paramMultiTaskInfo)
    {
      AppMethodBeat.i(341795);
      s.u(paramMultiTaskInfo, "multiTaskInfo");
      a.a locala = a.EzW;
      a.a.a(paramMultiTaskInfo, null, false, null);
      AppMethodBeat.o(341795);
    }
    
    public final void c(MultiTaskInfo paramMultiTaskInfo)
    {
      AppMethodBeat.i(341801);
      s.u(paramMultiTaskInfo, "multiTaskInfo");
      AppMethodBeat.o(341801);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.multitask.a
 * JD-Core Version:    0.7.0.1
 */