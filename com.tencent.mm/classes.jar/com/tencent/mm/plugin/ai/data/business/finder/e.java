package com.tencent.mm.plugin.ai.data.business.finder;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.aan;
import com.tencent.mm.autogen.a.gh;
import com.tencent.mm.autogen.a.jo;
import com.tencent.mm.autogen.a.jq;
import com.tencent.mm.autogen.a.qi;
import com.tencent.mm.autogen.a.wv;
import com.tencent.mm.autogen.mmdata.rpt.ah;
import com.tencent.mm.autogen.mmdata.rpt.gp;
import com.tencent.mm.plugin.ai.c.a.a;
import com.tencent.mm.plugin.ai.data.business.global.b;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.findersdk.a.bl;
import com.tencent.mm.plugin.findersdk.a.ca;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.btw;
import com.tencent.mm.protocal.protobuf.bxh;
import com.tencent.mm.protocal.protobuf.bxi;
import com.tencent.mm.protocal.protobuf.bxq;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.util.HashSet;
import java.util.LinkedList;
import org.json.JSONObject;

public final class e
{
  private static e qlX;
  long qlO;
  private long qlP;
  private int qlQ;
  int qlR;
  private HashSet<Integer> qlS;
  private HashSet<Integer> qlT;
  public LinkedList<h> qlU;
  public LinkedList<h> qlV;
  private com.tencent.mm.autogen.mmdata.rpt.f qlW;
  public IListener<gh> qlY;
  public MMHandler qlZ;
  public IListener<wv> qli;
  public IListener<jq> qma;
  public IListener<aan> qmb;
  private a qmc;
  
  public e()
  {
    AppMethodBeat.i(267481);
    this.qlO = 0L;
    this.qlP = 300000L;
    this.qlQ = 0;
    this.qlR = 0;
    this.qlS = new HashSet();
    this.qlT = new HashSet();
    this.qlU = new LinkedList();
    this.qlV = new LinkedList();
    this.qlW = new com.tencent.mm.autogen.mmdata.rpt.f();
    this.qlY = new AiFinderLogic.1(this, com.tencent.mm.app.f.hfK);
    this.qlZ = new MMHandler(new MMHandler.Callback()
    {
      public final boolean handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(267503);
        if ((paramAnonymousMessage != null) && (paramAnonymousMessage.what == 2457))
        {
          e locale = e.this;
          int i = paramAnonymousMessage.arg1;
          if (locale.qlO > 0L)
          {
            long l = Util.nowMilliSecond();
            paramAnonymousMessage = new com.tencent.mm.autogen.mmdata.rpt.h();
            com.tencent.mm.autogen.mmdata.rpt.h localh = paramAnonymousMessage.en(locale.qlO).eo(l);
            localh.ijA = (l - locale.qlO);
            localh.ikj = -1;
            localh.ijZ = i;
            localh.bMH();
            com.tencent.mm.plugin.report.service.h.OAn.p(1559L, 49L, 1L);
            locale.qlO = 0L;
            Log.i("MicroMsg.AiFinderLogic", "can not get Finder red dot [%s]", new Object[] { paramAnonymousMessage.aIF() });
          }
        }
        AppMethodBeat.o(267503);
        return false;
      }
    });
    this.qma = new AiFinderLogic.3(this, com.tencent.mm.app.f.hfK);
    this.qmb = new AiFinderLogic.4(this, com.tencent.mm.app.f.hfK);
    this.qli = new AiFinderLogic.5(this, com.tencent.mm.app.f.hfK);
    this.qmc = null;
    AppMethodBeat.o(267481);
  }
  
  private static HashSet<Integer> TK(String paramString)
  {
    AppMethodBeat.i(267498);
    HashSet localHashSet = new HashSet();
    if (!Util.isNullOrNil(paramString))
    {
      paramString = paramString.split(",");
      if ((paramString != null) && (paramString.length > 0))
      {
        int j = paramString.length;
        int i = 0;
        while (i < j)
        {
          int k = Util.getInt(paramString[i], -1);
          if (k > 0) {
            localHashSet.add(Integer.valueOf(k));
          }
          i += 1;
        }
      }
    }
    AppMethodBeat.o(267498);
    return localHashSet;
  }
  
  public static void TL(String paramString)
  {
    AppMethodBeat.i(267518);
    ((cn)com.tencent.mm.kernel.h.az(cn.class)).getRedDotManager().TL(paramString);
    Log.i("MicroMsg.AiFinderLogic", "disposeRedDotAtPath path[%s]", new Object[] { paramString });
    AppMethodBeat.o(267518);
  }
  
  public static void a(bxh parambxh, int paramInt)
  {
    AppMethodBeat.i(267527);
    if ((parambxh.aace == null) || (parambxh.aace.isEmpty()))
    {
      Log.w("MicroMsg.AiFinderLogic", "notify finder red dot manager FinderTabTips is null");
      AppMethodBeat.o(267527);
      return;
    }
    qi localqi = new qi();
    localqi.hTw.hTx = parambxh;
    localqi.hTw.scene = paramInt;
    localqi.publish();
    AppMethodBeat.o(267527);
  }
  
  public static e bZM()
  {
    AppMethodBeat.i(267489);
    if (qlX == null) {
      qlX = new e();
    }
    e locale = qlX;
    AppMethodBeat.o(267489);
    return locale;
  }
  
  public static boolean bZO()
  {
    AppMethodBeat.i(267505);
    String str = com.tencent.mm.plugin.expt.e.d.dNI().a("reddot_expt_conf", "", false, false);
    if (Util.isNullOrNil(str))
    {
      AppMethodBeat.o(267505);
      return false;
    }
    try
    {
      int i = new JSONObject(str).optInt("use_reddot_recommend", -1);
      if (i == 0)
      {
        AppMethodBeat.o(267505);
        return true;
      }
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(267505);
    }
    return false;
  }
  
  public static long bZP()
  {
    AppMethodBeat.i(267512);
    long l = com.tencent.mm.plugin.ai.d.e.caH().qpt.TT("last_finder_sync_ms");
    AppMethodBeat.o(267512);
    return l;
  }
  
  private a bZU()
  {
    try
    {
      AppMethodBeat.i(267548);
      if (this.qmc == null) {
        this.qmc = new a();
      }
      a locala = this.qmc;
      AppMethodBeat.o(267548);
      return locala;
    }
    finally {}
  }
  
  private static boolean d(LinkedList<h> paramLinkedList, String paramString)
  {
    AppMethodBeat.i(267542);
    long l = Util.currentTicks();
    if (paramLinkedList.isEmpty())
    {
      AppMethodBeat.o(267542);
      return false;
    }
    int j = paramLinkedList.size() - 1;
    Object localObject1 = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().avp(paramString);
    int i;
    Object localObject2;
    if (localObject1 != null)
    {
      i = j;
      if (i >= 0)
      {
        localObject2 = ((h)paramLinkedList.get(i)).qmh;
        if (Util.isEqual(((bxq)localObject1).icon_url, (String)localObject2)) {}
      }
    }
    for (;;)
    {
      localObject1 = (h)paramLinkedList.remove(i);
      if (localObject1 == null)
      {
        AppMethodBeat.o(267542);
        return false;
        i -= 1;
        break;
      }
      localObject2 = new bxh();
      ((bxh)localObject2).aace.add(((h)localObject1).qmg);
      a((bxh)localObject2, (int)((h)localObject1).qmi);
      localObject1 = ((h)localObject1).qmg;
      if ((localObject1 == null) || (((bxi)localObject1).aagf == null)) {}
      for (;;)
      {
        Log.i("MicroMsg.AiFinderLogic", "pop cache to show cost[%d] path[%s] size[%d] findIndex[%d]", new Object[] { Long.valueOf(Util.ticksToNow(l)), paramString, Integer.valueOf(paramLinkedList.size()), Integer.valueOf(i) });
        AppMethodBeat.o(267542);
        return true;
        try
        {
          localObject1 = ((bxi)localObject1).aagf;
          localObject2 = new gp();
          ((gp)localObject2).ilm = 2;
          ((gp)localObject2).ikf = ((gp)localObject2).F("TipsId", ((btw)localObject1).ZYN, true);
          ((gp)localObject2).iki = ((gp)localObject2).F("CtrlType", ((btw)localObject1).type, true);
          ((gp)localObject2).ijZ = 0;
          ((gp)localObject2).bMH();
          Log.i("MicroMsg.AiFinderLogic", "reportCacheTabTips [%s]", new Object[] { ((gp)localObject2).aIF() });
        }
        catch (Exception localException) {}
      }
      i = j;
    }
  }
  
  /* Error */
  public final boolean a(String paramString1, bxi parambxi, String paramString2, long paramLong)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: iconst_0
    //   4: istore 9
    //   6: aload_0
    //   7: monitorenter
    //   8: ldc_w 503
    //   11: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   14: invokestatic 407	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   17: lstore 7
    //   19: aconst_null
    //   20: astore 10
    //   22: ldc_w 505
    //   25: aload_1
    //   26: invokevirtual 508	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   29: ifeq +33 -> 62
    //   32: aload_0
    //   33: getfield 78	com/tencent/mm/plugin/ai/data/business/finder/e:qlU	Ljava/util/LinkedList;
    //   36: astore 10
    //   38: aload 10
    //   40: ifnonnull +41 -> 81
    //   43: ldc 175
    //   45: ldc_w 510
    //   48: invokestatic 326	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   51: ldc_w 503
    //   54: invokestatic 120	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   57: aload_0
    //   58: monitorexit
    //   59: iload 9
    //   61: ireturn
    //   62: ldc_w 512
    //   65: aload_1
    //   66: invokevirtual 508	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   69: ifeq -31 -> 38
    //   72: aload_0
    //   73: getfield 80	com/tencent/mm/plugin/ai/data/business/finder/e:qlV	Ljava/util/LinkedList;
    //   76: astore 10
    //   78: goto -40 -> 38
    //   81: aload 10
    //   83: invokevirtual 411	java/util/LinkedList:size	()I
    //   86: bipush 10
    //   88: if_icmplt +9 -> 97
    //   91: aload 10
    //   93: invokevirtual 515	java/util/LinkedList:removeFirst	()Ljava/lang/Object;
    //   96: pop
    //   97: aload 10
    //   99: new 428	com/tencent/mm/plugin/ai/data/business/finder/h
    //   102: dup
    //   103: aload_2
    //   104: aload_3
    //   105: lload 4
    //   107: invokespecial 518	com/tencent/mm/plugin/ai/data/business/finder/h:<init>	(Lcom/tencent/mm/protocal/protobuf/bxi;Ljava/lang/String;J)V
    //   110: invokevirtual 449	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   113: pop
    //   114: lload 7
    //   116: invokestatic 466	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   119: lstore 4
    //   121: aload 10
    //   123: ifnull +10 -> 133
    //   126: aload 10
    //   128: invokevirtual 411	java/util/LinkedList:size	()I
    //   131: istore 6
    //   133: ldc 175
    //   135: ldc_w 520
    //   138: iconst_3
    //   139: anewarray 4	java/lang/Object
    //   142: dup
    //   143: iconst_0
    //   144: lload 4
    //   146: invokestatic 471	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   149: aastore
    //   150: dup
    //   151: iconst_1
    //   152: aload_1
    //   153: aastore
    //   154: dup
    //   155: iconst_2
    //   156: iload 6
    //   158: invokestatic 148	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   161: aastore
    //   162: invokestatic 182	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   165: ldc_w 503
    //   168: invokestatic 120	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   171: iconst_1
    //   172: istore 9
    //   174: goto -117 -> 57
    //   177: astore_1
    //   178: aload_0
    //   179: monitorexit
    //   180: aload_1
    //   181: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	this	e
    //   0	182	1	paramString1	String
    //   0	182	2	parambxi	bxi
    //   0	182	3	paramString2	String
    //   0	182	4	paramLong	long
    //   1	156	6	i	int
    //   17	98	7	l	long
    //   4	169	9	bool	boolean
    //   20	107	10	localLinkedList	LinkedList
    // Exception table:
    //   from	to	target	type
    //   8	19	177	finally
    //   22	38	177	finally
    //   43	57	177	finally
    //   62	78	177	finally
    //   81	97	177	finally
    //   97	121	177	finally
    //   126	133	177	finally
    //   133	171	177	finally
  }
  
  public final void bZN()
  {
    try
    {
      AppMethodBeat.i(267569);
      String str1 = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.zrv, "");
      this.qlS.clear();
      this.qlS.addAll(TK(str1));
      String str2 = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.zrw, "");
      this.qlT.clear();
      this.qlT.addAll(TK(str2));
      this.qlR = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.zrx, 0);
      this.qlP = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.zrk, 300000L);
      this.qlQ = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.zrl, 0);
      Log.i("MicroMsg.AiFinderLogic", "reset control cacheFinderSync[%d] finderSyncFreqControl[%d] cacheCtrlType[%s] disableScene[%s]", new Object[] { Integer.valueOf(this.qlR), Long.valueOf(this.qlP), str1, str2 });
      AppMethodBeat.o(267569);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  final void bZQ()
  {
    try
    {
      AppMethodBeat.i(267605);
      this.qlU.clear();
      AppMethodBeat.o(267605);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  final void bZR()
  {
    try
    {
      AppMethodBeat.i(267614);
      this.qlV.clear();
      AppMethodBeat.o(267614);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean bZS()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(267622);
        boolean bool1 = false;
        try
        {
          boolean bool2 = d(this.qlU, "FinderEntrance");
          bool1 = bool2;
          com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.OAn;
          if (!bool2) {
            continue;
          }
          l = 207L;
          bool1 = bool2;
          localh.p(1559L, l, 1L);
          bool1 = bool2;
        }
        catch (Exception localException)
        {
          long l;
          bZQ();
          com.tencent.mm.plugin.report.service.h.OAn.p(1559L, 190L, 1L);
          continue;
        }
        AppMethodBeat.o(267622);
        return bool1;
      }
      finally {}
      l = 208L;
    }
  }
  
  public final boolean bZT()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(267630);
        boolean bool1 = false;
        try
        {
          boolean bool2 = d(this.qlV, "FinderLiveEntrance");
          bool1 = bool2;
          com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.OAn;
          if (!bool2) {
            continue;
          }
          l = 217L;
          bool1 = bool2;
          localh.p(1559L, l, 1L);
          bool1 = bool2;
        }
        catch (Exception localException)
        {
          long l;
          bZR();
          com.tencent.mm.plugin.report.service.h.OAn.p(1559L, 191L, 1L);
          continue;
        }
        AppMethodBeat.o(267630);
        return bool1;
      }
      finally {}
      l = 218L;
    }
  }
  
  public final String cz(String paramString1, String paramString2)
  {
    AppMethodBeat.i(267640);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(267640);
      return "";
    }
    a locala = bZU();
    PString localPString = new PString();
    localPString.value = "";
    String str = com.tencent.mm.plugin.ai.d.e.caH().TX(paramString1);
    int i;
    if (!y.ZC(str)) {
      i = -1;
    }
    for (;;)
    {
      if (i != 0) {
        break label137;
      }
      try
      {
        paramString1 = y.bEn(localPString.value);
        AppMethodBeat.o(267640);
        return paramString1;
      }
      catch (Exception paramString1)
      {
        Log.printErrStackTrace("MicroMsg.AiFinderLogic", paramString1, "read file error", new Object[0]);
      }
      if (!a.cA(str, paramString2))
      {
        i = -2;
      }
      else
      {
        localPString.value = str;
        i = 0;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(267640);
      return "";
      label137:
      locala.l(paramString1, paramString2, false);
    }
  }
  
  public final boolean yJ(int paramInt)
  {
    AppMethodBeat.i(267590);
    long l1 = Util.currentTicks();
    if (bZO())
    {
      com.tencent.mm.plugin.report.service.h.OAn.p(1559L, 51L, 1L);
      AppMethodBeat.o(267590);
      return false;
    }
    if ((paramInt >= 10000) && (paramInt < 20000))
    {
      b.bZW();
      if (!b.bZX())
      {
        com.tencent.mm.plugin.report.service.h.OAn.p(1559L, 204L, 1L);
        AppMethodBeat.o(267590);
        return false;
      }
    }
    if ((paramInt >= 20000) && (paramInt < 30000))
    {
      b.bZW();
      boolean bool1;
      if (!b.ju(70368744177664L))
      {
        bool1 = true;
        boolean bool2 = ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu();
        boolean bool3 = ((cn)com.tencent.mm.kernel.h.az(cn.class)).getFinderUtilApi().fgF();
        Log.i("MicroMsg.AiFinderData", "[isShowNearEntrance] openNearbyLiveFriends:%s isEnable:%s, isTeenMode:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3), Boolean.valueOf(bool2) });
        if ((!bool3) || (!bool1) || (bool2)) {
          break label243;
        }
      }
      label243:
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label248;
        }
        b.bZW();
        if (b.cae()) {
          break label248;
        }
        com.tencent.mm.plugin.report.service.h.OAn.p(1559L, 214L, 1L);
        AppMethodBeat.o(267590);
        return false;
        bool1 = false;
        break;
      }
    }
    label248:
    long l2 = bZP();
    if (Util.milliSecondsToNow(l2) <= this.qlP)
    {
      Log.v("MicroMsg.AiFinderLogic", "finder syn freq control lastFinderSyncMs[%d] finderSyncFreqControl[%d]", new Object[] { Long.valueOf(l2), Long.valueOf(this.qlP) });
      com.tencent.mm.plugin.report.service.h.OAn.p(1559L, 203L, 1L);
      AppMethodBeat.o(267590);
      return false;
    }
    Object localObject;
    if (this.qlQ > 0)
    {
      com.tencent.mm.plugin.ai.d.e.caH();
      localObject = com.tencent.mm.plugin.ai.d.d.TW("calendar_statistics_sync");
      if ((localObject == null) || (((ah)localObject).iof < this.qlQ)) {}
    }
    for (int i = 1; i != 0; i = 0)
    {
      com.tencent.mm.plugin.report.service.h.OAn.p(1559L, 203L, 1L);
      AppMethodBeat.o(267590);
      return false;
    }
    if (paramInt > 0)
    {
      localObject = new jo();
      ((jo)localObject).hLe.hLf = true;
      ((jo)localObject).hLe.selector = 113149;
      ((jo)localObject).hLe.scene = paramInt;
      ((jo)localObject).publish();
      localObject = this.qlW;
      ((com.tencent.mm.autogen.mmdata.rpt.f)localObject).ijZ = paramInt;
      ((com.tencent.mm.autogen.mmdata.rpt.f)localObject).ijX = l2;
      ((com.tencent.mm.autogen.mmdata.rpt.f)localObject).ijY = Util.nowMilliSecond();
      ((com.tencent.mm.autogen.mmdata.rpt.f)localObject).bMH();
      com.tencent.mm.plugin.report.service.h.OAn.p(1559L, 240L, 1L);
      this.qlO = Util.nowMilliSecond();
      l1 = Util.nowMilliSecond();
      com.tencent.mm.plugin.ai.d.e.caH().qpt.Q("last_finder_sync_ms", l1);
      l1 = Util.currentTicks();
      com.tencent.mm.plugin.ai.d.e.caH();
      localObject = com.tencent.mm.plugin.ai.d.d.TW("calendar_statistics_sync");
      if (localObject != null)
      {
        if ((paramInt < 10000) || (paramInt >= 20000)) {
          break label614;
        }
        ((ah)localObject).ioc += 1L;
      }
      for (;;)
      {
        ((ah)localObject).iof += 1L;
        com.tencent.mm.plugin.ai.d.e.caH();
        com.tencent.mm.plugin.ai.d.d.a("calendar_statistics_sync", (ah)localObject);
        Log.i("MicroMsg.AiFinderLogic", "noteSyncCount info [%s] cost[%d]", new Object[] { ((ah)localObject).aIF(), Long.valueOf(Util.ticksToNow(l1)) });
        AppMethodBeat.o(267590);
        return true;
        label614:
        if ((paramInt >= 20000) && (paramInt < 30000)) {
          ((ah)localObject).iod += 1L;
        } else {
          ((ah)localObject).ioe += 1L;
        }
      }
    }
    Log.i("MicroMsg.AiFinderLogic", "start to finder sync [%d] cost[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Util.ticksToNow(l1)) });
    AppMethodBeat.o(267590);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.data.business.finder.e
 * JD-Core Version:    0.7.0.1
 */