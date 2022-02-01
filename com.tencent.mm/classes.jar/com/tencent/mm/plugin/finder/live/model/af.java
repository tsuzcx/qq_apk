package com.tencent.mm.plugin.finder.live.model;

import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.live.model.cgi.av;
import com.tencent.mm.plugin.finder.live.model.cgi.av.a;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bnk;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.fky;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.v;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/FinderLivePollingService;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveSyncExtraInfo$CallBack;", "()V", "cmdIdToCallback", "Landroid/util/SparseArray;", "Lcom/tencent/mm/plugin/finder/live/model/FinderLivePollingService$PollingEventCallback;", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "cmdIdToRequestingCommandMap", "", "", "Lcom/tencent/mm/plugin/finder/live/model/FinderLivePollingService$Command;", "doPollingRequestRunnable", "Ljava/lang/Runnable;", "enabledCmdIds", "", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "liveContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "pendingCommandList", "Ljava/util/PriorityQueue;", "batchCommandGapSec", "checkNextPollingRequestTime", "", "dumpCurrentState", "", "enableCmdIds", "cmdIds", "", "enableCmdIds$plugin_finder_live_release", "filterDuplicatePendingCommand", "init", "liveBuContext", "init$plugin_finder_live_release", "notifyCmdIds", "notifyCmdIds$plugin_finder_live_release", "onCgiBack", "cgi", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveSyncExtraInfo;", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveSyncExtraInfoResponse;", "release", "release$plugin_finder_live_release", "startPolling", "T", "R", "cmdId", "req", "callback", "(ILcom/tencent/mm/protobuf/BaseProtoBuf;Lcom/tencent/mm/plugin/finder/live/model/FinderLivePollingService$PollingEventCallback;)V", "stopPolling", "updateCmdIdDisabledState", "disabled", "", "doRequestNow", "updateReq", "(ILcom/tencent/mm/protobuf/BaseProtoBuf;)V", "log", "Command", "Companion", "PollingEventCallback", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class af
  implements av.a
{
  public static final af.b CGC;
  private com.tencent.mm.plugin.finder.live.model.context.a CBK;
  private final PriorityQueue<a<? extends com.tencent.mm.bx.a>> CGD;
  private Map<Integer, a<? extends com.tencent.mm.bx.a>> CGE;
  private final SparseArray<af.c<? extends com.tencent.mm.bx.a>> CGF;
  private final List<Integer> CGG;
  private final Runnable CGH;
  private final MMHandler handler;
  
  static
  {
    AppMethodBeat.i(359365);
    CGC = new af.b((byte)0);
    AppMethodBeat.o(359365);
  }
  
  public af()
  {
    AppMethodBeat.i(359214);
    this.CGD = new PriorityQueue();
    this.CGE = ((Map)new HashMap());
    this.CGF = new SparseArray();
    this.CGG = ((List)new LinkedList());
    this.handler = new MMHandler("FinderLivePollingService");
    this.CGH = new af..ExternalSyntheticLambda3(this);
    AppMethodBeat.o(359214);
  }
  
  private static final void a(int paramInt, com.tencent.mm.bx.a parama, af paramaf)
  {
    AppMethodBeat.i(359321);
    s.u(parama, "$req");
    s.u(paramaf, "this$0");
    Log.i("MicroMsg.FinderLivePollingService", "update req for " + paramInt + ' ' + parama);
    Iterator localIterator = ((Iterable)paramaf.CGD).iterator();
    Object localObject;
    int i;
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (((a)localObject).cmdId == paramInt)
      {
        i = 1;
        label94:
        if (i == 0) {
          break label168;
        }
        label98:
        if (!(localObject instanceof a)) {
          break label176;
        }
        localObject = (a)localObject;
        label113:
        if (localObject != null) {
          ((a)localObject).i(parama);
        }
        paramaf = paramaf.CGE.get(Integer.valueOf(paramInt));
        if (!(paramaf instanceof a)) {
          break label182;
        }
      }
    }
    label168:
    label176:
    label182:
    for (paramaf = (a)paramaf;; paramaf = null)
    {
      if (paramaf != null) {
        paramaf.i(parama);
      }
      AppMethodBeat.o(359321);
      return;
      i = 0;
      break label94;
      break;
      localObject = null;
      break label98;
      localObject = null;
      break label113;
    }
  }
  
  private static final void a(int paramInt, af paramaf)
  {
    AppMethodBeat.i(359313);
    s.u(paramaf, "this$0");
    Log.i("MicroMsg.FinderLivePollingService", "stopPolling " + paramInt + ' ' + paramaf.eld());
    paramaf.CGF.remove(paramInt);
    p.a((Iterable)paramaf.CGD, (kotlin.g.a.b)new af.e(paramInt));
    paramaf.CGE.remove(Integer.valueOf(paramInt));
    paramaf.ela();
    AppMethodBeat.o(359313);
  }
  
  private static final void a(af paramaf)
  {
    AppMethodBeat.i(359276);
    s.u(paramaf, "this$0");
    if (paramaf.CBK == null) {
      Log.i("MicroMsg.FinderLivePollingService", s.X("doPollingRequestRunnable liveContext is null, cancel:", paramaf.eld()));
    }
    long l1 = SystemClock.uptimeMillis();
    Object localObject2 = new LinkedList();
    Object localObject1 = paramaf.CGD.iterator();
    s.s(localObject1, "pendingCommandList.iterator()");
    Object localObject3 = new StringBuilder();
    Object localObject4;
    while (((Iterator)localObject1).hasNext())
    {
      localObject4 = (a)((Iterator)localObject1).next();
      if (((a)localObject4).tVS > elb() * 1000 + l1) {
        break;
      }
      if (!((a)localObject4).CGI)
      {
        ((LinkedList)localObject2).add(localObject4);
        ((StringBuilder)localObject3).append(((a)localObject4).toString()).append(",");
        ((Iterator)localObject1).remove();
      }
    }
    Log.i("MicroMsg.FinderLivePollingService", "doPollingRequest mergeGap:" + elb() + ", " + localObject3 + ' ' + paramaf.eld());
    localObject3 = paramaf.CBK;
    if (localObject3 != null)
    {
      localObject1 = paramaf.CGE;
      Object localObject5 = (Iterable)localObject2;
      localObject4 = (Collection)new ArrayList(p.a((Iterable)localObject5, 10));
      localObject5 = ((Iterable)localObject5).iterator();
      Object localObject6;
      while (((Iterator)localObject5).hasNext())
      {
        localObject6 = (a)((Iterator)localObject5).next();
        ((Collection)localObject4).add(v.Y(Integer.valueOf(((a)localObject6).cmdId), localObject6));
      }
      ak.a((Map)localObject1, (Iterable)localObject4);
      int i;
      long l2;
      if (h.baE().ban().getInt(at.a.adaO, 4) == 3)
      {
        i = 1;
        l1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((com.tencent.mm.plugin.finder.live.model.context.a)localObject3).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId;
        l2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((com.tencent.mm.plugin.finder.live.model.context.a)localObject3).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN;
        localObject4 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((com.tencent.mm.plugin.finder.live.model.context.a)localObject3).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).nonceId;
        localObject5 = ((e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject3).business(e.class)).mIC;
        if (i == 0) {
          break label538;
        }
      }
      Collection localCollection;
      label538:
      for (localObject1 = z.bAW();; localObject1 = null)
      {
        localObject6 = com.tencent.mm.bx.b.cX(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((com.tencent.mm.plugin.finder.live.model.context.a)localObject3).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).mZp);
        Object localObject7 = (Iterable)localObject2;
        localCollection = (Collection)new ArrayList(p.a((Iterable)localObject7, 10));
        localObject7 = ((Iterable)localObject7).iterator();
        while (((Iterator)localObject7).hasNext())
        {
          a locala = (a)((Iterator)localObject7).next();
          fky localfky = new fky();
          localfky.Tps = locala.cmdId;
          localfky.ZQU = com.tencent.mm.bx.b.cX(locala.AzQ.toByteArray());
          localCollection.add(localfky);
        }
        i = 0;
        break;
      }
      localObject1 = new av(l1, l2, (String)localObject4, (String)localObject5, (String)localObject1, (com.tencent.mm.bx.b)localObject6, new LinkedList((Collection)localCollection), ((e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject3).business(e.class)).EeF, (av.a)paramaf);
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((a)((Iterator)localObject2).next()).CGK = ((c)localObject1);
      }
      ((av)localObject1).bFJ();
    }
    paramaf.ela();
    AppMethodBeat.o(359276);
  }
  
  private static final void a(af paramaf, int paramInt, com.tencent.mm.bx.a parama, af.c paramc)
  {
    AppMethodBeat.i(359305);
    s.u(paramaf, "this$0");
    s.u(parama, "$req");
    s.u(paramc, "$callback");
    if (paramaf.CBK == null)
    {
      Log.w("MicroMsg.FinderLivePollingService", "startPolling but liveContext = null: " + paramInt + ", " + paramaf.eld());
      AppMethodBeat.o(359305);
      return;
    }
    Log.i("MicroMsg.FinderLivePollingService", "startPolling " + paramInt + ' ' + parama + ' ' + paramaf.eld());
    paramaf.CGF.put(paramInt, paramc);
    parama = new a(paramInt, parama);
    p.a((Iterable)paramaf.CGD, (kotlin.g.a.b)new af.d(paramInt));
    paramaf.CGE.remove(Integer.valueOf(paramInt));
    if (!paramaf.CGG.contains(Integer.valueOf(paramInt)))
    {
      Log.i("MicroMsg.FinderLivePollingService", s.X("startPolling but cmdId not in enabled list ", Integer.valueOf(paramInt)));
      parama.qB(true);
    }
    paramaf.CGD.add(parama);
    paramaf.ela();
    AppMethodBeat.o(359305);
  }
  
  /* Error */
  private static final void a(af paramaf, av paramav, int paramInt1, int paramInt2, bnk parambnk, String paramString)
  {
    // Byte code:
    //   0: ldc_w 513
    //   3: invokestatic 106	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ldc 212
    //   9: invokestatic 210	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   12: aload_1
    //   13: ldc_w 515
    //   16: invokestatic 210	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   19: aload 4
    //   21: ldc_w 517
    //   24: invokestatic 210	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   27: aload_0
    //   28: getfield 301	com/tencent/mm/plugin/finder/live/model/af:CBK	Lcom/tencent/mm/plugin/finder/live/model/context/a;
    //   31: astore 8
    //   33: aload 8
    //   35: ifnonnull +65 -> 100
    //   38: lconst_0
    //   39: lstore 6
    //   41: aload_1
    //   42: getfield 521	com/tencent/mm/plugin/finder/live/model/cgi/av:CKH	Lcom/tencent/mm/protocal/protobuf/bnj;
    //   45: getfield 526	com/tencent/mm/protocal/protobuf/bnj:mMJ	J
    //   48: lload 6
    //   50: lcmp
    //   51: ifeq +101 -> 152
    //   54: ldc 214
    //   56: new 216	java/lang/StringBuilder
    //   59: dup
    //   60: ldc_w 528
    //   63: invokespecial 219	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   66: aload_1
    //   67: getfield 521	com/tencent/mm/plugin/finder/live/model/cgi/av:CKH	Lcom/tencent/mm/protocal/protobuf/bnj;
    //   70: getfield 526	com/tencent/mm/protocal/protobuf/bnj:mMJ	J
    //   73: invokevirtual 531	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   76: ldc_w 533
    //   79: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: lload 6
    //   84: invokevirtual 531	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   87: invokevirtual 233	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: invokestatic 488	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   93: ldc_w 513
    //   96: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: return
    //   100: aload 8
    //   102: ldc_w 391
    //   105: invokevirtual 397	com/tencent/mm/plugin/finder/live/model/context/a:business	(Ljava/lang/Class;)Landroidx/lifecycle/af;
    //   108: checkcast 391	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f
    //   111: astore 8
    //   113: aload 8
    //   115: ifnonnull +9 -> 124
    //   118: lconst_0
    //   119: lstore 6
    //   121: goto -80 -> 41
    //   124: aload 8
    //   126: getfield 401	com/tencent/mm/plugin/finder/live/viewmodel/data/business/f:liveInfo	Lcom/tencent/mm/protocal/protobuf/bip;
    //   129: astore 8
    //   131: aload 8
    //   133: ifnonnull +9 -> 142
    //   136: lconst_0
    //   137: lstore 6
    //   139: goto -98 -> 41
    //   142: aload 8
    //   144: getfield 406	com/tencent/mm/protocal/protobuf/bip:liveId	J
    //   147: lstore 6
    //   149: goto -108 -> 41
    //   152: iload_2
    //   153: ifne +582 -> 735
    //   156: iload_3
    //   157: ifne +578 -> 735
    //   160: aload 4
    //   162: getfield 539	com/tencent/mm/protocal/protobuf/bnk:ZVT	Ljava/util/LinkedList;
    //   165: ifnull +570 -> 735
    //   168: ldc 214
    //   170: new 216	java/lang/StringBuilder
    //   173: dup
    //   174: ldc_w 541
    //   177: invokespecial 219	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   180: aload 4
    //   182: getfield 539	com/tencent/mm/protocal/protobuf/bnk:ZVT	Ljava/util/LinkedList;
    //   185: invokevirtual 544	java/util/LinkedList:size	()I
    //   188: invokevirtual 223	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   191: bipush 32
    //   193: invokevirtual 226	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   196: aload_0
    //   197: invokespecial 276	com/tencent/mm/plugin/finder/live/model/af:eld	()Ljava/lang/String;
    //   200: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: invokevirtual 233	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: invokestatic 238	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   209: aload 4
    //   211: getfield 539	com/tencent/mm/protocal/protobuf/bnk:ZVT	Ljava/util/LinkedList;
    //   214: astore 4
    //   216: aload 4
    //   218: ifnull +819 -> 1037
    //   221: aload 4
    //   223: checkcast 240	java/lang/Iterable
    //   226: invokestatic 548	kotlin/a/p:l	(Ljava/lang/Iterable;)Ljava/util/List;
    //   229: astore 4
    //   231: aload 4
    //   233: ifnull +804 -> 1037
    //   236: aload 4
    //   238: checkcast 240	java/lang/Iterable
    //   241: invokeinterface 244 1 0
    //   246: astore 5
    //   248: aload 5
    //   250: invokeinterface 250 1 0
    //   255: ifeq +782 -> 1037
    //   258: aload 5
    //   260: invokeinterface 254 1 0
    //   265: checkcast 550	com/tencent/mm/protocal/protobuf/fkz
    //   268: astore 8
    //   270: aload 8
    //   272: getfield 553	com/tencent/mm/protocal/protobuf/fkz:ret	I
    //   275: ifne +355 -> 630
    //   278: aload_0
    //   279: getfield 179	com/tencent/mm/plugin/finder/live/model/af:CGF	Landroid/util/SparseArray;
    //   282: aload 8
    //   284: getfield 554	com/tencent/mm/protocal/protobuf/fkz:Tps	I
    //   287: invokevirtual 557	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   290: checkcast 13	com/tencent/mm/plugin/finder/live/model/af$c
    //   293: astore 9
    //   295: aload 9
    //   297: ifnonnull +112 -> 409
    //   300: ldc 214
    //   302: new 216	java/lang/StringBuilder
    //   305: dup
    //   306: ldc_w 559
    //   309: invokespecial 219	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   312: aload 8
    //   314: getfield 554	com/tencent/mm/protocal/protobuf/fkz:Tps	I
    //   317: invokevirtual 223	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   320: ldc_w 561
    //   323: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: invokevirtual 233	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   329: invokestatic 238	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   332: aload_0
    //   333: getfield 174	com/tencent/mm/plugin/finder/live/model/af:CGE	Ljava/util/Map;
    //   336: aload 8
    //   338: getfield 554	com/tencent/mm/protocal/protobuf/fkz:Tps	I
    //   341: invokestatic 266	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   344: invokeinterface 270 2 0
    //   349: checkcast 8	com/tencent/mm/plugin/finder/live/model/af$a
    //   352: astore 4
    //   354: aload 4
    //   356: ifnonnull +201 -> 557
    //   359: aconst_null
    //   360: astore 4
    //   362: aload 4
    //   364: ifnonnull -116 -> 248
    //   367: ldc 214
    //   369: new 216	java/lang/StringBuilder
    //   372: dup
    //   373: ldc_w 563
    //   376: invokespecial 219	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   379: aload 8
    //   381: getfield 554	com/tencent/mm/protocal/protobuf/fkz:Tps	I
    //   384: invokevirtual 223	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   387: ldc_w 565
    //   390: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: aload_0
    //   394: invokespecial 276	com/tencent/mm/plugin/finder/live/model/af:eld	()Ljava/lang/String;
    //   397: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: invokevirtual 233	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   403: invokestatic 238	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   406: goto -158 -> 248
    //   409: aload 8
    //   411: getfield 568	com/tencent/mm/protocal/protobuf/fkz:ZQV	Lcom/tencent/mm/bx/b;
    //   414: astore 10
    //   416: aload 10
    //   418: ifnonnull +23 -> 441
    //   421: ldc 214
    //   423: ldc_w 570
    //   426: invokestatic 488	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   429: ldc_w 570
    //   432: ldc_w 571
    //   435: invokestatic 210	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   438: goto -106 -> 332
    //   441: aload 9
    //   443: getfield 575	com/tencent/mm/plugin/finder/live/model/af$c:CGL	Ljava/lang/Class;
    //   446: iconst_0
    //   447: anewarray 577	java/lang/Class
    //   450: invokevirtual 581	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   453: iconst_0
    //   454: anewarray 4	java/lang/Object
    //   457: invokevirtual 587	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   460: checkcast 445	com/tencent/mm/bx/a
    //   463: astore 4
    //   465: aload 10
    //   467: invokevirtual 588	com/tencent/mm/bx/b:toByteArray	()[B
    //   470: astore 10
    //   472: aload 4
    //   474: aload 10
    //   476: invokevirtual 592	com/tencent/mm/bx/a:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   479: pop
    //   480: aload 4
    //   482: ifnull -150 -> 332
    //   485: aload 9
    //   487: aload 4
    //   489: invokevirtual 595	com/tencent/mm/plugin/finder/live/model/af$c:g	(Lcom/tencent/mm/bx/a;)V
    //   492: goto -160 -> 332
    //   495: astore 4
    //   497: ldc_w 597
    //   500: aload 4
    //   502: invokestatic 307	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   505: ldc_w 571
    //   508: invokestatic 210	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   511: ldc 214
    //   513: aload 4
    //   515: checkcast 599	java/lang/Throwable
    //   518: ldc_w 601
    //   521: iconst_0
    //   522: anewarray 4	java/lang/Object
    //   525: invokestatic 605	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   528: goto -196 -> 332
    //   531: astore 4
    //   533: ldc_w 607
    //   536: ldc_w 608
    //   539: iconst_1
    //   540: anewarray 4	java/lang/Object
    //   543: dup
    //   544: iconst_0
    //   545: aload 4
    //   547: aastore
    //   548: invokestatic 612	com/tencent/mm/sdk/platformtools/Log:printDebugStack	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   551: aconst_null
    //   552: astore 4
    //   554: goto -74 -> 480
    //   557: ldc 214
    //   559: new 216	java/lang/StringBuilder
    //   562: dup
    //   563: ldc_w 614
    //   566: invokespecial 219	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   569: aload 4
    //   571: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   574: ldc_w 616
    //   577: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   580: aload 8
    //   582: getfield 619	com/tencent/mm/protocal/protobuf/fkz:abLz	I
    //   585: invokevirtual 223	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   588: ldc_w 621
    //   591: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   594: invokestatic 624	com/tencent/mm/plugin/finder/live/model/af$b:ele	()I
    //   597: invokevirtual 223	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   600: invokevirtual 233	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   603: invokestatic 238	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   606: aload 4
    //   608: aload 8
    //   610: getfield 619	com/tencent/mm/protocal/protobuf/fkz:abLz	I
    //   613: invokestatic 624	com/tencent/mm/plugin/finder/live/model/af$b:ele	()I
    //   616: invokestatic 630	kotlin/k/k:qu	(II)I
    //   619: putfield 633	com/tencent/mm/plugin/finder/live/model/af$a:CGJ	I
    //   622: getstatic 639	kotlin/ah:aiuX	Lkotlin/ah;
    //   625: astore 4
    //   627: goto -265 -> 362
    //   630: aload_0
    //   631: getfield 179	com/tencent/mm/plugin/finder/live/model/af:CGF	Landroid/util/SparseArray;
    //   634: aload 8
    //   636: getfield 554	com/tencent/mm/protocal/protobuf/fkz:Tps	I
    //   639: invokevirtual 557	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   642: checkcast 13	com/tencent/mm/plugin/finder/live/model/af$c
    //   645: ifnonnull +78 -> 723
    //   648: ldc 214
    //   650: new 216	java/lang/StringBuilder
    //   653: dup
    //   654: ldc_w 559
    //   657: invokespecial 219	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   660: aload 8
    //   662: getfield 554	com/tencent/mm/protocal/protobuf/fkz:Tps	I
    //   665: invokevirtual 223	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   668: ldc_w 561
    //   671: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   674: invokevirtual 233	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   677: invokestatic 238	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   680: ldc 214
    //   682: new 216	java/lang/StringBuilder
    //   685: dup
    //   686: ldc_w 641
    //   689: invokespecial 219	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   692: aload 8
    //   694: getfield 554	com/tencent/mm/protocal/protobuf/fkz:Tps	I
    //   697: invokevirtual 223	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   700: ldc_w 643
    //   703: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   706: aload 8
    //   708: getfield 553	com/tencent/mm/protocal/protobuf/fkz:ret	I
    //   711: invokevirtual 223	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   714: invokevirtual 233	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   717: invokestatic 488	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   720: goto -472 -> 248
    //   723: ldc_w 645
    //   726: ldc_w 571
    //   729: invokestatic 210	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   732: goto -52 -> 680
    //   735: aload_0
    //   736: getfield 174	com/tencent/mm/plugin/finder/live/model/af:CGE	Ljava/util/Map;
    //   739: astore 8
    //   741: new 647	java/util/LinkedHashMap
    //   744: dup
    //   745: invokespecial 648	java/util/LinkedHashMap:<init>	()V
    //   748: checkcast 172	java/util/Map
    //   751: astore 4
    //   753: aload 8
    //   755: invokeinterface 652 1 0
    //   760: invokeinterface 655 1 0
    //   765: astore 8
    //   767: aload 8
    //   769: invokeinterface 250 1 0
    //   774: ifeq +60 -> 834
    //   777: aload 8
    //   779: invokeinterface 254 1 0
    //   784: checkcast 657	java/util/Map$Entry
    //   787: astore 9
    //   789: aload 9
    //   791: invokeinterface 660 1 0
    //   796: checkcast 8	com/tencent/mm/plugin/finder/live/model/af$a
    //   799: getfield 470	com/tencent/mm/plugin/finder/live/model/af$a:CGK	Lcom/tencent/mm/plugin/findersdk/b/c;
    //   802: aload_1
    //   803: invokestatic 664	kotlin/g/b/s:p	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   806: ifeq -39 -> 767
    //   809: aload 4
    //   811: aload 9
    //   813: invokeinterface 667 1 0
    //   818: aload 9
    //   820: invokeinterface 660 1 0
    //   825: invokeinterface 670 3 0
    //   830: pop
    //   831: goto -64 -> 767
    //   834: aload 4
    //   836: invokeinterface 652 1 0
    //   841: invokeinterface 655 1 0
    //   846: astore 4
    //   848: aload 4
    //   850: invokeinterface 250 1 0
    //   855: ifeq +129 -> 984
    //   858: aload 4
    //   860: invokeinterface 254 1 0
    //   865: checkcast 657	java/util/Map$Entry
    //   868: astore 8
    //   870: aload_0
    //   871: getfield 179	com/tencent/mm/plugin/finder/live/model/af:CGF	Landroid/util/SparseArray;
    //   874: aload 8
    //   876: invokeinterface 660 1 0
    //   881: checkcast 8	com/tencent/mm/plugin/finder/live/model/af$a
    //   884: getfield 257	com/tencent/mm/plugin/finder/live/model/af$a:cmdId	I
    //   887: invokevirtual 557	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   890: checkcast 13	com/tencent/mm/plugin/finder/live/model/af$c
    //   893: ifnonnull +46 -> 939
    //   896: ldc 214
    //   898: new 216	java/lang/StringBuilder
    //   901: dup
    //   902: ldc_w 559
    //   905: invokespecial 219	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   908: aload 8
    //   910: invokeinterface 660 1 0
    //   915: checkcast 8	com/tencent/mm/plugin/finder/live/model/af$a
    //   918: getfield 257	com/tencent/mm/plugin/finder/live/model/af$a:cmdId	I
    //   921: invokevirtual 223	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   924: ldc_w 561
    //   927: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   930: invokevirtual 233	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   933: invokestatic 238	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   936: goto -88 -> 848
    //   939: new 216	java/lang/StringBuilder
    //   942: dup
    //   943: ldc_w 672
    //   946: invokespecial 219	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   949: iload_2
    //   950: invokevirtual 223	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   953: bipush 32
    //   955: invokevirtual 226	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   958: iload_3
    //   959: invokevirtual 223	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   962: bipush 32
    //   964: invokevirtual 226	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   967: aload 5
    //   969: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   972: invokevirtual 233	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   975: ldc_w 571
    //   978: invokestatic 210	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   981: goto -133 -> 848
    //   984: ldc 214
    //   986: new 216	java/lang/StringBuilder
    //   989: dup
    //   990: ldc_w 674
    //   993: invokespecial 219	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   996: iload_2
    //   997: invokevirtual 223	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1000: bipush 32
    //   1002: invokevirtual 226	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   1005: iload_3
    //   1006: invokevirtual 223	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1009: bipush 32
    //   1011: invokevirtual 226	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   1014: aload 5
    //   1016: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1019: bipush 32
    //   1021: invokevirtual 226	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   1024: aload_0
    //   1025: invokespecial 276	com/tencent/mm/plugin/finder/live/model/af:eld	()Ljava/lang/String;
    //   1028: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1031: invokevirtual 233	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1034: invokestatic 677	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1037: aload_0
    //   1038: getfield 174	com/tencent/mm/plugin/finder/live/model/af:CGE	Ljava/util/Map;
    //   1041: astore 5
    //   1043: new 647	java/util/LinkedHashMap
    //   1046: dup
    //   1047: invokespecial 648	java/util/LinkedHashMap:<init>	()V
    //   1050: checkcast 172	java/util/Map
    //   1053: astore 4
    //   1055: aload 5
    //   1057: invokeinterface 652 1 0
    //   1062: invokeinterface 655 1 0
    //   1067: astore 5
    //   1069: aload 5
    //   1071: invokeinterface 250 1 0
    //   1076: ifeq +118 -> 1194
    //   1079: aload 5
    //   1081: invokeinterface 254 1 0
    //   1086: checkcast 657	java/util/Map$Entry
    //   1089: astore 8
    //   1091: aload 8
    //   1093: invokeinterface 660 1 0
    //   1098: checkcast 8	com/tencent/mm/plugin/finder/live/model/af$a
    //   1101: astore 9
    //   1103: aload 9
    //   1105: getfield 470	com/tencent/mm/plugin/finder/live/model/af$a:CGK	Lcom/tencent/mm/plugin/findersdk/b/c;
    //   1108: aload_1
    //   1109: invokestatic 664	kotlin/g/b/s:p	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1112: ifeq +77 -> 1189
    //   1115: aload 9
    //   1117: aconst_null
    //   1118: putfield 470	com/tencent/mm/plugin/finder/live/model/af$a:CGK	Lcom/tencent/mm/plugin/findersdk/b/c;
    //   1121: aload 9
    //   1123: getfield 332	com/tencent/mm/plugin/finder/live/model/af$a:CGI	Z
    //   1126: ifne +22 -> 1148
    //   1129: aload 9
    //   1131: invokestatic 313	android/os/SystemClock:uptimeMillis	()J
    //   1134: aload 9
    //   1136: getfield 633	com/tencent/mm/plugin/finder/live/model/af$a:CGJ	I
    //   1139: sipush 1000
    //   1142: imul
    //   1143: i2l
    //   1144: ladd
    //   1145: putfield 324	com/tencent/mm/plugin/finder/live/model/af$a:tVS	J
    //   1148: aload_0
    //   1149: getfield 167	com/tencent/mm/plugin/finder/live/model/af:CGD	Ljava/util/PriorityQueue;
    //   1152: aload 9
    //   1154: invokevirtual 510	java/util/PriorityQueue:add	(Ljava/lang/Object;)Z
    //   1157: pop
    //   1158: iconst_0
    //   1159: istore_2
    //   1160: iload_2
    //   1161: ifeq -92 -> 1069
    //   1164: aload 4
    //   1166: aload 8
    //   1168: invokeinterface 667 1 0
    //   1173: aload 8
    //   1175: invokeinterface 660 1 0
    //   1180: invokeinterface 670 3 0
    //   1185: pop
    //   1186: goto -117 -> 1069
    //   1189: iconst_1
    //   1190: istore_2
    //   1191: goto -31 -> 1160
    //   1194: aload_0
    //   1195: aload 4
    //   1197: invokestatic 681	kotlin/a/ak:dw	(Ljava/util/Map;)Ljava/util/Map;
    //   1200: putfield 174	com/tencent/mm/plugin/finder/live/model/af:CGE	Ljava/util/Map;
    //   1203: aload_0
    //   1204: invokespecial 298	com/tencent/mm/plugin/finder/live/model/af:ela	()V
    //   1207: ldc_w 513
    //   1210: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1213: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1214	0	paramaf	af
    //   0	1214	1	paramav	av
    //   0	1214	2	paramInt1	int
    //   0	1214	3	paramInt2	int
    //   0	1214	4	parambnk	bnk
    //   0	1214	5	paramString	String
    //   39	109	6	l	long
    //   31	1143	8	localObject1	Object
    //   293	860	9	localObject2	Object
    //   414	61	10	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   441	472	495	java/lang/Exception
    //   485	492	495	java/lang/Exception
    //   533	551	495	java/lang/Exception
    //   472	480	531	java/lang/Exception
  }
  
  private static final void a(af paramaf, com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    AppMethodBeat.i(359327);
    s.u(paramaf, "this$0");
    s.u(parama, "$liveBuContext");
    Log.i("MicroMsg.FinderLivePollingService", s.X("init ", paramaf.eld()));
    paramaf.CBK = parama;
    AppMethodBeat.o(359327);
  }
  
  private static final void a(List paramList, af paramaf)
  {
    AppMethodBeat.i(359348);
    s.u(paramList, "$cmdIds");
    s.u(paramaf, "this$0");
    Object localObject1;
    int i;
    int j;
    if (paramList.size() == paramaf.CGG.size())
    {
      localObject1 = ((Iterable)paramList).iterator();
      i = 1;
      j = i;
      if (!((Iterator)localObject1).hasNext()) {
        break label99;
      }
      j = ((Number)((Iterator)localObject1).next()).intValue();
      if (paramaf.CGG.contains(Integer.valueOf(j))) {
        break label477;
      }
      i = 0;
    }
    label256:
    label396:
    label477:
    for (;;)
    {
      break;
      j = 0;
      label99:
      if (j != 0)
      {
        AppMethodBeat.o(359348);
        return;
      }
      Log.i("MicroMsg.FinderLivePollingService", "enableCmdIds old: " + gu(paramaf.CGG) + " new:" + gu(paramList) + ' ' + paramaf.eld());
      Object localObject2 = (Iterable)paramList;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      Object localObject3;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        i = ((Number)localObject3).intValue();
        if (!paramaf.CGG.contains(Integer.valueOf(i))) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label256;
          }
          ((Collection)localObject1).add(localObject3);
          break;
        }
      }
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        paramaf.h(((Number)((Iterator)localObject1).next()).intValue(), false, true);
      }
      localObject2 = (Iterable)paramaf.CGG;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        if (!paramList.contains(Integer.valueOf(((Number)localObject3).intValue()))) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label396;
          }
          ((Collection)localObject1).add(localObject3);
          break;
        }
      }
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        a(paramaf, ((Number)((Iterator)localObject1).next()).intValue());
      }
      paramaf.CGG.clear();
      paramaf.CGG.addAll((Collection)paramList);
      paramaf.ela();
      AppMethodBeat.o(359348);
      return;
    }
  }
  
  private static final void b(af paramaf)
  {
    AppMethodBeat.i(359337);
    s.u(paramaf, "this$0");
    Log.i("MicroMsg.FinderLivePollingService", s.X("release ", paramaf.eld()));
    paramaf.handler.removeCallbacks(paramaf.CGH);
    paramaf.CBK = null;
    paramaf.CGD.clear();
    Iterator localIterator = ((Iterable)paramaf.CGE.values()).iterator();
    while (localIterator.hasNext())
    {
      c localc = ((a)localIterator.next()).CGK;
      if (localc != null) {
        localc.cancel();
      }
    }
    paramaf.CGE.clear();
    paramaf.CGF.clear();
    paramaf.CGG.clear();
    AppMethodBeat.o(359337);
  }
  
  private static final void b(List paramList, af paramaf)
  {
    AppMethodBeat.i(359359);
    s.u(paramList, "$cmdIds");
    s.u(paramaf, "this$0");
    if (paramList.isEmpty())
    {
      AppMethodBeat.o(359359);
      return;
    }
    Log.i("MicroMsg.FinderLivePollingService", "notifyCmdIds " + gu(paramList) + ' ' + paramaf.eld());
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      int i = ((Number)paramList.next()).intValue();
      if (!paramaf.CGG.contains(Integer.valueOf(i))) {
        paramaf.CGG.add(Integer.valueOf(i));
      }
      paramaf.h(i, false, true);
    }
    paramaf.ela();
    AppMethodBeat.o(359359);
  }
  
  private final void ela()
  {
    AppMethodBeat.i(359227);
    this.handler.removeCallbacks(this.CGH);
    Object localObject = new HashSet();
    Iterator localIterator = this.CGD.iterator();
    s.s(localIterator, "pendingCommandList.iterator()");
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (((HashSet)localObject).contains(Integer.valueOf(locala.cmdId)))
      {
        Log.w("MicroMsg.FinderLivePollingService", s.X("duplicate pending command found, remove it ", eld()));
        localIterator.remove();
      }
      else
      {
        ((HashSet)localObject).add(Integer.valueOf(locala.cmdId));
      }
    }
    localObject = (a)this.CGD.peek();
    if (localObject == null)
    {
      localObject = null;
      if (localObject == null) {
        Log.i("MicroMsg.FinderLivePollingService", s.X("checkNextPollingRequestTime pendingList is empty ", eld()));
      }
      AppMethodBeat.o(359227);
      return;
    }
    if (((a)localObject).CGI) {
      Log.i("MicroMsg.FinderLivePollingService", s.X("checkNextPollingRequestTime first command is disabled ", eld()));
    }
    for (;;)
    {
      localObject = ah.aiuX;
      break;
      long l = ((a)localObject).tVS;
      if ((l == 0L) || (l <= SystemClock.uptimeMillis()))
      {
        Log.i("MicroMsg.FinderLivePollingService", "checkNextPollingRequestTime doRequestNow:" + localObject + ' ' + eld());
        this.handler.post(this.CGH);
      }
      else
      {
        Log.i("MicroMsg.FinderLivePollingService", "checkNextPollingRequestTime pendingRequest:" + localObject + ' ' + eld());
        this.handler.postAtTime(this.CGH, l);
      }
    }
  }
  
  private static int elb()
  {
    AppMethodBeat.i(359235);
    com.tencent.d.a.a.a.a.a locala = com.tencent.d.a.a.a.a.a.ahiX;
    int i = ((Number)com.tencent.d.a.a.a.a.a.jUm().bmg()).intValue();
    AppMethodBeat.o(359235);
    return i;
  }
  
  private final String eld()
  {
    AppMethodBeat.i(359252);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" || pendingCommandList: [");
    Iterator localIterator = ((Iterable)this.CGD).iterator();
    while (localIterator.hasNext()) {
      ((StringBuilder)localObject).append(((a)localIterator.next()).toString()).append(",");
    }
    ((StringBuilder)localObject).append("] requestingCommandList: [");
    localIterator = ((Iterable)this.CGE.values()).iterator();
    while (localIterator.hasNext()) {
      ((StringBuilder)localObject).append(((a)localIterator.next()).toString()).append(",");
    }
    ((StringBuilder)localObject).append("] enabledCmdIds:[" + gu(this.CGG) + "] now:[" + SystemClock.uptimeMillis() + ']');
    localObject = ((StringBuilder)localObject).toString();
    s.s(localObject, "sb.toString()");
    AppMethodBeat.o(359252);
    return localObject;
  }
  
  private static String gu(List<Integer> paramList)
  {
    AppMethodBeat.i(359259);
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext()) {
      localStringBuilder.append(((Number)paramList.next()).intValue()).append(",");
    }
    paramList = localStringBuilder.toString();
    s.s(paramList, "sb.toString()");
    AppMethodBeat.o(359259);
    return paramList;
  }
  
  private final void h(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(359239);
    Object localObject = (a)this.CGE.get(Integer.valueOf(paramInt));
    if (localObject != null) {
      ((a)localObject).qB(paramBoolean1);
    }
    Iterator localIterator = ((Iterable)this.CGD).iterator();
    int i;
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (((a)localObject).cmdId == paramInt)
      {
        i = 1;
        label83:
        if (i == 0) {
          break label207;
        }
        label88:
        localObject = (a)localObject;
        if (localObject != null)
        {
          this.CGD.remove(localObject);
          ((a)localObject).qB(paramBoolean1);
          if (!paramBoolean1) {
            if (!paramBoolean2) {
              break label215;
            }
          }
        }
      }
    }
    label207:
    label215:
    for (long l = 0L;; l = SystemClock.uptimeMillis() + ((a)localObject).CGJ * 1000)
    {
      ((a)localObject).tVS = l;
      this.CGD.add(localObject);
      Log.i("MicroMsg.FinderLivePollingService", "updateCmdIdDisabledState " + paramInt + ' ' + paramBoolean1 + ' ' + paramBoolean2 + ' ' + eld());
      AppMethodBeat.o(359239);
      return;
      i = 0;
      break label83;
      break;
      localObject = null;
      break label88;
    }
  }
  
  public final void OQ(int paramInt)
  {
    AppMethodBeat.i(359439);
    this.handler.post(new af..ExternalSyntheticLambda1(paramInt, this));
    AppMethodBeat.o(359439);
  }
  
  public final <T extends com.tencent.mm.bx.a, R extends com.tencent.mm.bx.a> void a(int paramInt, T paramT, af.c<R> paramc)
  {
    AppMethodBeat.i(359431);
    s.u(paramT, "req");
    s.u(paramc, "callback");
    this.handler.post(new af..ExternalSyntheticLambda4(this, paramInt, paramT, paramc));
    AppMethodBeat.o(359431);
  }
  
  public final void a(av paramav, int paramInt1, int paramInt2, String paramString, bnk parambnk)
  {
    AppMethodBeat.i(359420);
    s.u(paramav, "cgi");
    s.u(parambnk, "resp");
    this.handler.post(new af..ExternalSyntheticLambda5(this, paramav, paramInt1, paramInt2, parambnk, paramString));
    AppMethodBeat.o(359420);
  }
  
  public final void elc()
  {
    AppMethodBeat.i(359466);
    this.handler.post(new af..ExternalSyntheticLambda2(this));
    AppMethodBeat.o(359466);
  }
  
  public final void g(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    AppMethodBeat.i(359454);
    s.u(parama, "liveBuContext");
    this.handler.post(new af..ExternalSyntheticLambda6(this, parama));
    AppMethodBeat.o(359454);
  }
  
  public final void gs(List<Integer> paramList)
  {
    AppMethodBeat.i(359470);
    s.u(paramList, "cmdIds");
    this.handler.post(new af..ExternalSyntheticLambda8(paramList, this));
    AppMethodBeat.o(359470);
  }
  
  public final void gt(List<Integer> paramList)
  {
    AppMethodBeat.i(359474);
    s.u(paramList, "cmdIds");
    this.handler.post(new af..ExternalSyntheticLambda7(paramList, this));
    AppMethodBeat.o(359474);
  }
  
  public final <T extends com.tencent.mm.bx.a> void h(T paramT)
  {
    AppMethodBeat.i(359446);
    s.u(paramT, "req");
    this.handler.post(new af..ExternalSyntheticLambda0(9, paramT, this));
    AppMethodBeat.o(359446);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/FinderLivePollingService$Command;", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "", "cmdId", "", "req", "(ILcom/tencent/mm/protobuf/BaseProtoBuf;)V", "getCmdId", "()I", "value", "", "disabled", "getDisabled", "()Z", "setDisabled", "(Z)V", "intervalSec", "getIntervalSec", "setIntervalSec", "(I)V", "getReq", "()Lcom/tencent/mm/protobuf/BaseProtoBuf;", "setReq", "(Lcom/tencent/mm/protobuf/BaseProtoBuf;)V", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "requestTime", "", "getRequestTime", "()J", "setRequestTime", "(J)V", "requestingCgi", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "getRequestingCgi", "()Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "setRequestingCgi", "(Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;)V", "compareTo", "other", "toString", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a<T extends com.tencent.mm.bx.a>
    implements Comparable<a<T>>
  {
    T AzQ;
    boolean CGI;
    int CGJ;
    c<? extends esc> CGK;
    final int cmdId;
    long tVS;
    
    public a(int paramInt, T paramT)
    {
      AppMethodBeat.i(360077);
      this.cmdId = paramInt;
      this.AzQ = paramT;
      paramT = af.CGC;
      this.CGJ = af.b.ele();
      AppMethodBeat.o(360077);
    }
    
    public final void i(T paramT)
    {
      AppMethodBeat.i(360083);
      s.u(paramT, "<set-?>");
      this.AzQ = paramT;
      AppMethodBeat.o(360083);
    }
    
    public final void qB(boolean paramBoolean)
    {
      this.CGI = paramBoolean;
      if (paramBoolean) {
        this.tVS = 9223372036854775807L;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(360101);
      String str = "Command(cmdId=" + this.cmdId + ", disabled=" + this.CGI + ", req=" + this.AzQ + ", intervalSec=" + this.CGJ + ", requestTime=" + this.tVS + ", requestingCgi=" + this.CGK + ')';
      AppMethodBeat.o(360101);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.af
 * JD-Core Version:    0.7.0.1
 */