package com.tencent.mm.plugin.finder.live.viewmodel.data.business;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.ae.f;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bke;
import com.tencent.mm.protocal.protobuf.dit;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.ah.d;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.k.k;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveMsgSpeedControlSlice;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/IBusiness;", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "liveContext", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "MSG_TYPE_TO_PUTIN_CACHE", "", "", "SPEED_CONFIG", "Lcom/tencent/mm/protocal/protobuf/LiveMsgClientConfig;", "TEST_SPEED_CONFIG", "callBack", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler$CallBack;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "hasAddHistoryMsg", "", "historyMsgCacheList", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveMsgSpeedControlSlice$LiveMsgQueue;", "isUsingNewMsgInterval", "msgCacheList", "onMsgInCacheTimeExpired", "Lkotlin/Function1;", "Lkotlin/Pair;", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "", "timeHandler", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "checkAndChangNewMsgInterval", "checkConfig", "config", "filterMsgToCache", "remoteLiveMsg", "remoteLiveAppMsg", "isHistoryMsg", "isConfigSame", "other", "onCleared", "onLiveJoin", "saveConfig", "isLegal", "isSame", "print", "", "Companion", "LiveMsgQueue", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  extends c<com.tencent.mm.plugin.finder.live.model.context.a>
{
  public static final a EgP;
  private MTimerHandler.CallBack DdQ;
  private boolean EgQ;
  public volatile dit EgR;
  public final dit EgS;
  private b<? super r<? extends LinkedList<bke>, ? extends LinkedList<bdm>>, ah> EgT;
  private final List<Integer> EgU;
  private final b EgV;
  private final b EgW;
  private volatile boolean EgX;
  private MTimerHandler EgY;
  private final MMHandler handler;
  
  static
  {
    AppMethodBeat.i(356693);
    EgP = new a((byte)0);
    AppMethodBeat.o(356693);
  }
  
  public m(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    super(parama);
    AppMethodBeat.i(356602);
    parama = new dit();
    parama.aaNv = 100;
    parama.aaNw = 3;
    parama.aaNA = 0;
    parama.aaNy = 6;
    parama.aaNB = 0;
    ah localah = ah.aiuX;
    this.EgR = parama;
    parama = new dit();
    parama.aaNv = 100;
    parama.aaNw = 50;
    parama.aaNA = 0;
    parama.aaNy = 6;
    parama.aaNB = 0;
    localah = ah.aiuX;
    this.EgS = parama;
    this.EgU = p.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(20002), Integer.valueOf(20032), Integer.valueOf(20034) });
    parama = new MMHandler("MMFinder.LiveMsgSpeedControlSlice");
    parama.setLogging(false);
    localah = ah.aiuX;
    this.handler = parama;
    this.EgV = new b();
    this.EgW = new b();
    this.DdQ = new m..ExternalSyntheticLambda0(this);
    AppMethodBeat.o(356602);
  }
  
  private static String a(dit paramdit)
  {
    AppMethodBeat.i(356617);
    s.u(paramdit, "<this>");
    paramdit = s.X("config = ", f.dh(paramdit));
    AppMethodBeat.o(356617);
    return paramdit;
  }
  
  private static final void a(m paramm, boolean paramBoolean, ah.f paramf, ah.d paramd)
  {
    AppMethodBeat.i(356670);
    s.u(paramm, "this$0");
    s.u(paramf, "$tempList");
    s.u(paramd, "$insertSize");
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        localb = paramm.EgW;
        localb.addAll((Collection)paramf.aqH);
        if (paramm.EgV.size() > paramm.EgR.aaNv)
        {
          paramm.EgV.Qe(paramd.aixb);
          Log.i("MMFinder.LiveMsgSpeedControlSlice", "reach cache limit:" + paramm.EgR.aaNv + " del size:" + paramd.aixb);
        }
        paramf = ah.aiuX;
        return;
      }
      finally
      {
        b localb;
        AppMethodBeat.o(356670);
      }
      localb = paramm.EgV;
    }
  }
  
  /* Error */
  private static final boolean a(m paramm)
  {
    // Byte code:
    //   0: ldc_w 276
    //   3: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ldc 224
    //   9: invokestatic 134	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   12: aload_0
    //   13: monitorenter
    //   14: aload_0
    //   15: getfield 199	com/tencent/mm/plugin/finder/live/viewmodel/data/business/m:EgW	Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/m$b;
    //   18: checkcast 236	java/util/Collection
    //   21: invokeinterface 280 1 0
    //   26: ifne +147 -> 173
    //   29: iconst_1
    //   30: istore_1
    //   31: iload_1
    //   32: ifeq +146 -> 178
    //   35: aload_0
    //   36: getfield 199	com/tencent/mm/plugin/finder/live/viewmodel/data/business/m:EgW	Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/m$b;
    //   39: aload_0
    //   40: getfield 165	com/tencent/mm/plugin/finder/live/viewmodel/data/business/m:EgR	Lcom/tencent/mm/protocal/protobuf/dit;
    //   43: getfield 154	com/tencent/mm/protocal/protobuf/dit:aaNy	I
    //   46: invokevirtual 284	com/tencent/mm/plugin/finder/live/viewmodel/data/business/m$b:Qd	(I)Lkotlin/r;
    //   49: astore_2
    //   50: getstatic 290	com/tencent/mm/plugin/finder/live/util/u:DJC	Lcom/tencent/mm/plugin/finder/live/util/u;
    //   53: astore_3
    //   54: invokestatic 293	com/tencent/mm/plugin/finder/live/util/u:bgV	()Z
    //   57: ifeq +81 -> 138
    //   60: new 254	java/lang/StringBuilder
    //   63: dup
    //   64: ldc_w 295
    //   67: invokespecial 257	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   70: astore_3
    //   71: aload_2
    //   72: getfield 300	kotlin/r:bsC	Ljava/lang/Object;
    //   75: checkcast 302	java/util/LinkedList
    //   78: invokevirtual 303	java/util/LinkedList:size	()I
    //   81: istore_1
    //   82: ldc 185
    //   84: aload_3
    //   85: aload_2
    //   86: getfield 306	kotlin/r:bsD	Ljava/lang/Object;
    //   89: checkcast 302	java/util/LinkedList
    //   92: invokevirtual 303	java/util/LinkedList:size	()I
    //   95: iload_1
    //   96: iadd
    //   97: invokevirtual 261	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   100: ldc_w 308
    //   103: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: aload_0
    //   107: getfield 199	com/tencent/mm/plugin/finder/live/viewmodel/data/business/m:EgW	Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/m$b;
    //   110: invokevirtual 244	com/tencent/mm/plugin/finder/live/viewmodel/data/business/m$b:size	()I
    //   113: invokevirtual 261	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   116: ldc_w 310
    //   119: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: aload_0
    //   123: getfield 197	com/tencent/mm/plugin/finder/live/viewmodel/data/business/m:EgV	Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/m$b;
    //   126: invokevirtual 244	com/tencent/mm/plugin/finder/live/viewmodel/data/business/m$b:size	()I
    //   129: invokevirtual 261	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   132: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokestatic 313	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   138: aload_0
    //   139: invokespecial 316	com/tencent/mm/plugin/finder/live/viewmodel/data/business/m:ezg	()V
    //   142: aload_0
    //   143: getfield 318	com/tencent/mm/plugin/finder/live/viewmodel/data/business/m:EgT	Lkotlin/g/a/b;
    //   146: astore_3
    //   147: aload_3
    //   148: ifnull +15 -> 163
    //   151: aload_3
    //   152: aload_2
    //   153: invokeinterface 324 2 0
    //   158: pop
    //   159: getstatic 163	kotlin/ah:aiuX	Lkotlin/ah;
    //   162: astore_2
    //   163: aload_0
    //   164: monitorexit
    //   165: ldc_w 276
    //   168: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   171: iconst_1
    //   172: ireturn
    //   173: iconst_0
    //   174: istore_1
    //   175: goto -144 -> 31
    //   178: aload_0
    //   179: getfield 197	com/tencent/mm/plugin/finder/live/viewmodel/data/business/m:EgV	Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/m$b;
    //   182: aload_0
    //   183: getfield 165	com/tencent/mm/plugin/finder/live/viewmodel/data/business/m:EgR	Lcom/tencent/mm/protocal/protobuf/dit;
    //   186: getfield 148	com/tencent/mm/protocal/protobuf/dit:aaNw	I
    //   189: invokevirtual 284	com/tencent/mm/plugin/finder/live/viewmodel/data/business/m$b:Qd	(I)Lkotlin/r;
    //   192: astore_2
    //   193: goto -143 -> 50
    //   196: astore_2
    //   197: aload_0
    //   198: monitorexit
    //   199: ldc_w 276
    //   202: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   205: aload_2
    //   206: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	207	0	paramm	m
    //   30	145	1	i	int
    //   49	144	2	localObject1	Object
    //   196	10	2	localObject2	Object
    //   53	99	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   14	29	196	finally
    //   35	50	196	finally
    //   50	138	196	finally
    //   138	147	196	finally
    //   151	163	196	finally
    //   178	193	196	finally
  }
  
  public static boolean a(dit paramdit1, dit paramdit2)
  {
    AppMethodBeat.i(356622);
    s.u(paramdit1, "<this>");
    s.u(paramdit2, "other");
    if ((paramdit1.aaNA == paramdit2.aaNA) && (paramdit1.aaNw == paramdit2.aaNw) && (paramdit1.aaNv == paramdit2.aaNv) && (paramdit1.aaNB == paramdit2.aaNB) && (paramdit1.aaNy == paramdit2.aaNy))
    {
      AppMethodBeat.o(356622);
      return true;
    }
    AppMethodBeat.o(356622);
    return false;
  }
  
  /* Error */
  private static final void b(m paramm)
  {
    // Byte code:
    //   0: ldc_w 328
    //   3: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ldc 224
    //   9: invokestatic 134	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   12: aload_0
    //   13: monitorenter
    //   14: ldc 185
    //   16: ldc_w 330
    //   19: aload_0
    //   20: getfield 165	com/tencent/mm/plugin/finder/live/viewmodel/data/business/m:EgR	Lcom/tencent/mm/protocal/protobuf/dit;
    //   23: invokestatic 332	com/tencent/mm/plugin/finder/live/viewmodel/data/business/m:a	(Lcom/tencent/mm/protocal/protobuf/dit;)Ljava/lang/String;
    //   26: invokestatic 221	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   29: invokestatic 275	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: aload_0
    //   33: getfield 197	com/tencent/mm/plugin/finder/live/viewmodel/data/business/m:EgV	Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/m$b;
    //   36: invokevirtual 244	com/tencent/mm/plugin/finder/live/viewmodel/data/business/m$b:size	()I
    //   39: aload_0
    //   40: getfield 165	com/tencent/mm/plugin/finder/live/viewmodel/data/business/m:EgR	Lcom/tencent/mm/protocal/protobuf/dit;
    //   43: getfield 145	com/tencent/mm/protocal/protobuf/dit:aaNv	I
    //   46: isub
    //   47: istore_1
    //   48: iload_1
    //   49: ifle +11 -> 60
    //   52: aload_0
    //   53: getfield 197	com/tencent/mm/plugin/finder/live/viewmodel/data/business/m:EgV	Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/m$b;
    //   56: iload_1
    //   57: invokevirtual 252	com/tencent/mm/plugin/finder/live/viewmodel/data/business/m$b:Qe	(I)V
    //   60: aload_0
    //   61: getfield 334	com/tencent/mm/plugin/finder/live/viewmodel/data/business/m:EgY	Lcom/tencent/mm/sdk/platformtools/MTimerHandler;
    //   64: astore_2
    //   65: aload_2
    //   66: ifnull +7 -> 73
    //   69: aload_2
    //   70: invokevirtual 339	com/tencent/mm/sdk/platformtools/MTimerHandler:stopTimer	()V
    //   73: new 336	com/tencent/mm/sdk/platformtools/MTimerHandler
    //   76: dup
    //   77: ldc 185
    //   79: aload_0
    //   80: getfield 205	com/tencent/mm/plugin/finder/live/viewmodel/data/business/m:DdQ	Lcom/tencent/mm/sdk/platformtools/MTimerHandler$CallBack;
    //   83: iconst_1
    //   84: invokespecial 342	com/tencent/mm/sdk/platformtools/MTimerHandler:<init>	(Ljava/lang/String;Lcom/tencent/mm/sdk/platformtools/MTimerHandler$CallBack;Z)V
    //   87: astore_2
    //   88: aload_2
    //   89: iconst_0
    //   90: invokevirtual 343	com/tencent/mm/sdk/platformtools/MTimerHandler:setLogging	(Z)V
    //   93: getstatic 163	kotlin/ah:aiuX	Lkotlin/ah;
    //   96: astore_3
    //   97: aload_0
    //   98: aload_2
    //   99: putfield 334	com/tencent/mm/plugin/finder/live/viewmodel/data/business/m:EgY	Lcom/tencent/mm/sdk/platformtools/MTimerHandler;
    //   102: aload_0
    //   103: getfield 199	com/tencent/mm/plugin/finder/live/viewmodel/data/business/m:EgW	Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/m$b;
    //   106: checkcast 236	java/util/Collection
    //   109: invokeinterface 280 1 0
    //   114: ifne +49 -> 163
    //   117: iconst_1
    //   118: istore_1
    //   119: iload_1
    //   120: ifeq +48 -> 168
    //   123: aload_0
    //   124: getfield 165	com/tencent/mm/plugin/finder/live/viewmodel/data/business/m:EgR	Lcom/tencent/mm/protocal/protobuf/dit;
    //   127: getfield 157	com/tencent/mm/protocal/protobuf/dit:aaNB	I
    //   130: istore_1
    //   131: iload_1
    //   132: ifle +47 -> 179
    //   135: aload_0
    //   136: getfield 334	com/tencent/mm/plugin/finder/live/viewmodel/data/business/m:EgY	Lcom/tencent/mm/sdk/platformtools/MTimerHandler;
    //   139: astore_2
    //   140: aload_2
    //   141: ifnull +9 -> 150
    //   144: aload_2
    //   145: iload_1
    //   146: i2l
    //   147: invokevirtual 347	com/tencent/mm/sdk/platformtools/MTimerHandler:startTimer	(J)V
    //   150: getstatic 163	kotlin/ah:aiuX	Lkotlin/ah;
    //   153: astore_2
    //   154: aload_0
    //   155: monitorexit
    //   156: ldc_w 328
    //   159: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   162: return
    //   163: iconst_0
    //   164: istore_1
    //   165: goto -46 -> 119
    //   168: aload_0
    //   169: getfield 165	com/tencent/mm/plugin/finder/live/viewmodel/data/business/m:EgR	Lcom/tencent/mm/protocal/protobuf/dit;
    //   172: getfield 151	com/tencent/mm/protocal/protobuf/dit:aaNA	I
    //   175: istore_1
    //   176: goto -45 -> 131
    //   179: ldc 185
    //   181: new 254	java/lang/StringBuilder
    //   184: dup
    //   185: ldc_w 349
    //   188: invokespecial 257	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   191: aload_0
    //   192: getfield 165	com/tencent/mm/plugin/finder/live/viewmodel/data/business/m:EgR	Lcom/tencent/mm/protocal/protobuf/dit;
    //   195: getfield 151	com/tencent/mm/protocal/protobuf/dit:aaNA	I
    //   198: invokevirtual 261	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   201: ldc_w 351
    //   204: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: invokestatic 275	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   213: goto -63 -> 150
    //   216: astore_2
    //   217: aload_0
    //   218: monitorexit
    //   219: ldc_w 328
    //   222: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   225: aload_2
    //   226: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	227	0	paramm	m
    //   47	129	1	i	int
    //   64	90	2	localObject1	Object
    //   216	10	2	localObject2	Object
    //   96	1	3	localah	ah
    // Exception table:
    //   from	to	target	type
    //   14	48	216	finally
    //   52	60	216	finally
    //   60	65	216	finally
    //   69	73	216	finally
    //   73	117	216	finally
    //   123	131	216	finally
    //   135	140	216	finally
    //   144	150	216	finally
    //   150	154	216	finally
    //   168	176	216	finally
    //   179	213	216	finally
  }
  
  public static boolean b(dit paramdit)
  {
    AppMethodBeat.i(356630);
    s.u(paramdit, "<this>");
    if ((paramdit.aaNA >= 0) || (paramdit.aaNw > 0) || (paramdit.aaNv > 0) || (paramdit.aaNB > 0) || (paramdit.aaNy > 0))
    {
      AppMethodBeat.o(356630);
      return true;
    }
    AppMethodBeat.o(356630);
    return false;
  }
  
  private static final void c(m paramm)
  {
    AppMethodBeat.i(356659);
    s.u(paramm, "this$0");
    try
    {
      paramm.EgV.clear();
      paramm.EgW.clear();
      ah localah = ah.aiuX;
      return;
    }
    finally
    {
      AppMethodBeat.o(356659);
    }
  }
  
  private void ezg()
  {
    AppMethodBeat.i(356612);
    if ((this.EgW.isEmpty()) && (!this.EgX))
    {
      Log.i("MMFinder.LiveMsgSpeedControlSlice", s.X("checkAndChangNewMsgInterval, ", a(this.EgR)));
      Object localObject = this.EgY;
      if (localObject != null) {
        ((MTimerHandler)localObject).stopTimer();
      }
      this.EgX = true;
      if (this.EgR.aaNA > 0)
      {
        localObject = new MTimerHandler("MMFinder.LiveMsgSpeedControlSlice", this.DdQ, true);
        ((MTimerHandler)localObject).setLogging(false);
        ah localah = ah.aiuX;
        this.EgY = ((MTimerHandler)localObject);
        localObject = this.EgY;
        if (localObject != null)
        {
          ((MTimerHandler)localObject).startTimer(this.EgR.aaNA);
          AppMethodBeat.o(356612);
        }
      }
      else
      {
        localObject = this.EgT;
        if (localObject != null) {
          ((b)localObject).invoke(this.EgV.Qd(this.EgV.size()));
        }
      }
    }
    AppMethodBeat.o(356612);
  }
  
  public final void a(LinkedList<bke> paramLinkedList, LinkedList<bdm> paramLinkedList1, boolean paramBoolean)
  {
    AppMethodBeat.i(356747);
    s.u(paramLinkedList, "remoteLiveMsg");
    s.u(paramLinkedList1, "remoteLiveAppMsg");
    if ((paramBoolean) && (this.EgQ))
    {
      Log.i("MMFinder.LiveMsgSpeedControlSlice", "has been Add History Msg,return");
      AppMethodBeat.o(356747);
      return;
    }
    if (paramBoolean) {
      this.EgQ = true;
    }
    if (!((e)business(e.class)).Ect)
    {
      Log.i("MMFinder.LiveMsgSpeedControlSlice", "unable LiveRoom Comment,clear cache");
      this.handler.post(new m..ExternalSyntheticLambda2(this));
      AppMethodBeat.o(356747);
      return;
    }
    if (((this.EgR.aaNB <= 0) && (paramBoolean)) || ((this.EgR.aaNA <= 0) && (!paramBoolean))) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramLinkedList = com.tencent.mm.plugin.finder.live.util.u.DJC;
      if (com.tencent.mm.plugin.finder.live.util.u.bgV()) {
        Log.d("MMFinder.LiveMsgSpeedControlSlice", "no ctrol speed ,so dont fillter");
      }
      AppMethodBeat.o(356747);
      return;
    }
    ah.d locald = new ah.d();
    ah.f localf = new ah.f();
    localf.aqH = new ArrayList();
    paramLinkedList = paramLinkedList.iterator();
    s.s(paramLinkedList, "remoteLiveMsg.iterator()");
    while (paramLinkedList.hasNext())
    {
      Object localObject = paramLinkedList.next();
      s.s(localObject, "liveMsgIterator.next()");
      localObject = (bke)localObject;
      if (this.EgU.contains(Integer.valueOf(((bke)localObject).type)))
      {
        ((ArrayList)localf.aqH).add(localObject);
        paramLinkedList.remove();
        locald.aixb += 1;
      }
    }
    paramLinkedList = paramLinkedList1.iterator();
    s.s(paramLinkedList, "remoteLiveAppMsg.iterator()");
    while (paramLinkedList.hasNext())
    {
      paramLinkedList1 = paramLinkedList.next();
      s.s(paramLinkedList1, "liveAppMsgIterator.next()");
      paramLinkedList1 = (bdm)paramLinkedList1;
      if (this.EgU.contains(Integer.valueOf(paramLinkedList1.msg_type)))
      {
        ((ArrayList)localf.aqH).add(paramLinkedList1);
        paramLinkedList.remove();
        locald.aixb += 1;
      }
    }
    this.handler.post(new m..ExternalSyntheticLambda3(this, paramBoolean, localf, locald));
    AppMethodBeat.o(356747);
  }
  
  public final void an(b<? super r<? extends LinkedList<bke>, ? extends LinkedList<bdm>>, ah> paramb)
  {
    AppMethodBeat.i(356724);
    s.u(paramb, "onMsgInCacheTimeExpired");
    this.EgT = paramb;
    AppMethodBeat.o(356724);
  }
  
  public final void ezh()
  {
    AppMethodBeat.i(356732);
    this.handler.post(new m..ExternalSyntheticLambda1(this));
    AppMethodBeat.o(356732);
  }
  
  public final void onCleared()
  {
    AppMethodBeat.i(356757);
    MTimerHandler localMTimerHandler = this.EgY;
    if (localMTimerHandler != null) {
      localMTimerHandler.stopTimer();
    }
    this.EgY = null;
    this.EgQ = false;
    this.handler.removeCallbacksAndMessages(null);
    d.d("MMFinder.LiveMsgSpeedControlSlice", (kotlin.g.a.a)new c(this));
    this.EgT = null;
    AppMethodBeat.o(356757);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveMsgSpeedControlSlice$Companion;", "", "()V", "TAG", "", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveMsgSpeedControlSlice$LiveMsgQueue;", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "", "()V", "delMsg", "", "size", "", "pollMsg", "Lkotlin/Pair;", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends ConcurrentLinkedQueue<Object>
  {
    public final r<LinkedList<bke>, LinkedList<bdm>> Qd(int paramInt)
    {
      AppMethodBeat.i(356587);
      Object localObject1 = new LinkedList();
      LinkedList localLinkedList = new LinkedList();
      int i = 1;
      int j = k.qv(paramInt, size());
      if (j > 0) {
        paramInt = i;
      }
      for (;;)
      {
        Object localObject2 = poll();
        if (localObject2 != null)
        {
          if (!(localObject2 instanceof bke)) {
            break label93;
          }
          ((LinkedList)localObject1).add(localObject2);
        }
        while (paramInt == j)
        {
          localObject1 = new r(localObject1, localLinkedList);
          AppMethodBeat.o(356587);
          return localObject1;
          label93:
          if ((localObject2 instanceof bdm)) {
            localLinkedList.add(localObject2);
          }
        }
        paramInt += 1;
      }
    }
    
    public final void Qe(int paramInt)
    {
      AppMethodBeat.i(356594);
      int i = 1;
      int j = k.qv(paramInt, size());
      if (j > 0) {
        paramInt = i;
      }
      for (;;)
      {
        poll();
        if (paramInt == j)
        {
          AppMethodBeat.o(356594);
          return;
        }
        paramInt += 1;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    c(m paramm)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.business.m
 * JD-Core Version:    0.7.0.1
 */