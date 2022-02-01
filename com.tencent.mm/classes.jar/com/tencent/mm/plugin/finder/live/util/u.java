package com.tencent.mm.plugin.finder.live.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.f;
import com.tencent.mm.live.core.core.a.b;
import com.tencent.mm.live.core.core.a.b.a;
import com.tencent.mm.live.core.core.e.j;
import com.tencent.mm.live.core.core.e.l;
import com.tencent.mm.live.core.core.e.a.a;
import com.tencent.mm.live.model.j;
import com.tencent.mm.plugin.finder.live.model.am;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.l;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.protocal.protobuf.bcz;
import com.tencent.mm.protocal.protobuf.bke;
import com.tencent.mm.protocal.protobuf.cbv;
import com.tencent.mm.protocal.protobuf.cbw;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/util/LiveUtil;", "", "()V", "TAG", "", "addSysMsg", "", "content", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "getAliasInfoList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAliasInfo;", "getDebugFinderLiveContact", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "giftFuncEnableByContactFlag", "", "contactFlag", "", "giftFuncEnableBySwitchFlag", "switchFlag", "isAnchorLive", "isAnchorLiveWithoutSndDevice", "isBuyProductMicUser", "userAttrFlag", "isFollowMicUser", "isRewardMicUser", "isTest", "micSettingBuyProduct", "flag", "micSettingFollow", "micSettingReward", "printAnchorStatus", "tag", "anchorStatus", "", "printVisitorRoleInfo", "prefix", "visitorRoleList", "curVisitorRoleType", "visitorRoleModifyTime", "logInfo", "Lcom/tencent/mm/protocal/protobuf/GameRankSwitch;", "Lcom/tencent/mm/protocal/protobuf/GameRankSwitchInfo;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class u
{
  public static final u DJC;
  
  static
  {
    AppMethodBeat.i(351433);
    DJC = new u();
    AppMethodBeat.o(351433);
  }
  
  public static String a(String paramString, LinkedList<bcz> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(351328);
    s.u(paramString, "prefix");
    s.u(paramLinkedList, "visitorRoleList");
    StringBuilder localStringBuilder1 = new StringBuilder("[printVisitorRoleInfo]" + paramString + ":curVisitorRoleType:" + paramInt + ";visitorRoleModifyTime:0;");
    synchronized ((Iterable)paramLinkedList)
    {
      Iterator localIterator = ???.iterator();
      paramInt = 0;
      while (localIterator.hasNext())
      {
        paramString = localIterator.next();
        if (paramInt < 0) {
          p.kkW();
        }
        paramLinkedList = (bcz)paramString;
        StringBuilder localStringBuilder2 = new StringBuilder("[").append(paramInt).append(':');
        paramString = paramLinkedList;
        if (paramLinkedList == null) {
          paramString = "";
        }
        localStringBuilder1.append(f.dg(paramString) + ']');
        paramInt += 1;
      }
      paramString = ah.aiuX;
      paramString = localStringBuilder1.toString();
      s.s(paramString, "msg.toString()");
      AppMethodBeat.o(351328);
      return paramString;
    }
  }
  
  public static void a(cbw paramcbw, String paramString)
  {
    AppMethodBeat.i(351426);
    s.u(paramcbw, "<this>");
    s.u(paramString, "TAG");
    paramcbw = paramcbw.aalh;
    if (paramcbw != null)
    {
      paramcbw = ((Iterable)paramcbw).iterator();
      while (paramcbw.hasNext())
      {
        cbv localcbv = (cbv)paramcbw.next();
        if (localcbv != null)
        {
          s.u(localcbv, "<this>");
          s.u(paramString, "TAG");
          Log.i(paramString, "GameRankSwitch appid:" + localcbv.ZGM + ", name:" + localcbv.aale + ", enable:" + localcbv.aalf);
        }
      }
    }
    AppMethodBeat.o(351426);
  }
  
  public static void a(String paramString, com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    AppMethodBeat.i(351334);
    s.u(paramString, "content");
    s.u(parama, "liveData");
    bke localbke = new bke();
    localbke.type = 10001;
    localbke.content = paramString;
    paramString = ah.aiuX;
    paramString = new am(localbke);
    ((l)((e)parama.business(e.class)).business(l.class)).EgE.add(paramString);
    paramString = j.mXT;
    j.bhf();
    AppMethodBeat.o(351334);
  }
  
  public static boolean bUC()
  {
    AppMethodBeat.i(351343);
    b.a locala = b.mMo;
    boolean bool = b.a.bek();
    AppMethodBeat.o(351343);
    return bool;
  }
  
  public static boolean bUx()
  {
    AppMethodBeat.i(351296);
    Object localObject = b.mMo;
    if (!b.a.bek())
    {
      localObject = com.tencent.mm.live.core.core.e.a.mRf;
      if (!a.a.bek()) {}
    }
    else
    {
      AppMethodBeat.o(351296);
      return true;
    }
    AppMethodBeat.o(351296);
    return false;
  }
  
  public static boolean bgV()
  {
    AppMethodBeat.i(351394);
    if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.DEBUG) || (WeChatEnvironment.hasDebugger()))
    {
      AppMethodBeat.o(351394);
      return true;
    }
    AppMethodBeat.o(351394);
    return false;
  }
  
  /* Error */
  public static LinkedList<bcz> euA()
  {
    // Byte code:
    //   0: ldc_w 287
    //   3: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 289	java/util/LinkedList
    //   9: dup
    //   10: invokespecial 290	java/util/LinkedList:<init>	()V
    //   13: astore_0
    //   14: invokestatic 296	com/tencent/mm/kernel/h:baE	()Lcom/tencent/mm/kernel/f;
    //   17: invokevirtual 302	com/tencent/mm/kernel/f:ban	()Lcom/tencent/mm/storage/aq;
    //   20: getstatic 308	com/tencent/mm/storage/at$a:adaP	Lcom/tencent/mm/storage/at$a;
    //   23: aconst_null
    //   24: invokevirtual 314	com/tencent/mm/storage/aq:get	(Lcom/tencent/mm/storage/at$a;Ljava/lang/Object;)Ljava/lang/Object;
    //   27: checkcast 316	java/lang/String
    //   30: astore_1
    //   31: new 318	com/tencent/mm/protocal/protobuf/bda
    //   34: dup
    //   35: invokespecial 319	com/tencent/mm/protocal/protobuf/bda:<init>	()V
    //   38: astore_2
    //   39: aload_1
    //   40: ifnull +24 -> 64
    //   43: aload_1
    //   44: getstatic 325	kotlin/n/d:ISO_8859_1	Ljava/nio/charset/Charset;
    //   47: invokevirtual 329	java/lang/String:getBytes	(Ljava/nio/charset/Charset;)[B
    //   50: astore_1
    //   51: aload_1
    //   52: ldc_w 331
    //   55: invokestatic 156	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   58: aload_2
    //   59: aload_1
    //   60: invokevirtual 335	com/tencent/mm/protocal/protobuf/bda:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   63: pop
    //   64: aload_2
    //   65: getfield 338	com/tencent/mm/protocal/protobuf/bda:ZMv	Ljava/util/LinkedList;
    //   68: astore_1
    //   69: aload_1
    //   70: ldc_w 340
    //   73: invokestatic 156	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   76: aload_1
    //   77: astore_0
    //   78: ldc_w 342
    //   81: ldc_w 344
    //   84: aload_2
    //   85: invokestatic 142	com/tencent/mm/ae/f:dg	(Ljava/lang/Object;)Lorg/json/JSONObject;
    //   88: invokestatic 348	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   91: invokestatic 192	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   94: ldc_w 287
    //   97: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   100: aload_1
    //   101: areturn
    //   102: astore_2
    //   103: aload_0
    //   104: astore_1
    //   105: aload_1
    //   106: astore_0
    //   107: getstatic 354	com/tencent/mm/plugin/finder/utils/aw:Gjk	Lcom/tencent/mm/plugin/finder/utils/aw;
    //   110: astore_3
    //   111: aload_1
    //   112: astore_0
    //   113: aload_2
    //   114: ldc_w 356
    //   117: aload_2
    //   118: invokevirtual 359	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   121: invokestatic 348	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   124: invokestatic 362	com/tencent/mm/plugin/finder/utils/aw:a	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   127: ldc_w 287
    //   130: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   133: aload_1
    //   134: areturn
    //   135: astore_1
    //   136: ldc_w 287
    //   139: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   142: aload_0
    //   143: areturn
    //   144: astore_1
    //   145: goto -9 -> 136
    //   148: astore_2
    //   149: goto -44 -> 105
    // Local variable table:
    //   start	length	slot	name	signature
    //   13	130	0	localObject1	Object
    //   30	104	1	localObject2	Object
    //   135	1	1	localObject3	Object
    //   144	1	1	localObject4	Object
    //   38	47	2	localbda	com.tencent.mm.protocal.protobuf.bda
    //   102	16	2	localException1	java.lang.Exception
    //   148	1	2	localException2	java.lang.Exception
    //   110	1	3	localaw	aw
    // Exception table:
    //   from	to	target	type
    //   14	39	102	java/lang/Exception
    //   43	64	102	java/lang/Exception
    //   64	76	102	java/lang/Exception
    //   14	39	135	finally
    //   43	64	135	finally
    //   64	76	135	finally
    //   78	94	144	finally
    //   107	111	144	finally
    //   113	127	144	finally
    //   78	94	148	java/lang/Exception
  }
  
  public static void ey(String paramString, int paramInt)
  {
    AppMethodBeat.i(351414);
    s.u(paramString, "tag");
    Log.i(paramString, "check AnchorStatus1, tag:" + paramString + ", status:" + paramInt + ", BAN_COMMENT:" + com.tencent.mm.ae.d.ee(paramInt, 8) + ", SHOPPING:" + com.tencent.mm.ae.d.ee(paramInt, 16) + ", GIFT:" + com.tencent.mm.ae.d.ee(paramInt, 128) + ", BAN_LIKE:" + com.tencent.mm.ae.d.ee(paramInt, 512) + ", LINK_MIC:" + com.tencent.mm.ae.d.ee(paramInt, 64) + ", ");
    Log.i(paramString, "check AnchorStatus2, tag:" + paramString + ", status:" + paramInt + ", ENTER_BACKGROUND:" + com.tencent.mm.ae.d.ee(paramInt, 1) + ", CALL_INTERRUPTION:" + com.tencent.mm.ae.d.ee(paramInt, 2) + ", RECORD_SCREEN_ON:" + com.tencent.mm.ae.d.ee(paramInt, 4) + ", BREAK_LIVE_RULE:" + com.tencent.mm.ae.d.ee(paramInt, 32) + ", AUDIO_MODE:" + com.tencent.mm.ae.d.ee(paramInt, 256) + ", SCREEN_SHARE:" + com.tencent.mm.ae.d.ee(paramInt, 1024) + ", HIDE_AUDIENCE_NICKNAME:" + com.tencent.mm.ae.d.ee(paramInt, 8192) + ", DISABLE_SHOW_BIZ:" + com.tencent.mm.ae.d.ee(paramInt, 4096) + ", ");
    AppMethodBeat.o(351414);
  }
  
  public static boolean oE(long paramLong)
  {
    AppMethodBeat.i(351282);
    boolean bool1 = com.tencent.mm.ae.d.ee((int)paramLong, 2);
    boolean bool2 = ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu();
    boolean bool3 = ((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).bUb();
    Log.i("LiveUtil", "giftFuncEnableBySwitchFlag isTeenMode:" + bool2 + " pagEnable:" + bool3 + " enableGiftBySwitchFlag:" + bool1 + " switchFlag:" + paramLong);
    if ((bool1) && (bool3) && (!bool2))
    {
      AppMethodBeat.o(351282);
      return true;
    }
    AppMethodBeat.o(351282);
    return false;
  }
  
  public static boolean oF(long paramLong)
  {
    AppMethodBeat.i(351289);
    boolean bool1 = com.tencent.mm.ae.d.ee((int)paramLong, 1);
    boolean bool2 = ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu();
    aw localaw = aw.Gjk;
    boolean bool3 = aw.fgx();
    boolean bool4 = ((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).bUb();
    Log.i("LiveUtil", "giftFuncEnableByContactFlag isTeenMode:" + bool2 + " pagEnable:" + bool4 + " enableGiftByContactFlag:" + bool1 + " regChina:" + bool3 + " switchFlag:" + paramLong);
    if ((bool1) && (!bool2) && (bool4))
    {
      AppMethodBeat.o(351289);
      return true;
    }
    AppMethodBeat.o(351289);
    return false;
  }
  
  public static boolean oG(long paramLong)
  {
    AppMethodBeat.i(351350);
    int i = (int)paramLong;
    e.j localj = e.j.mLf;
    boolean bool = com.tencent.mm.ae.d.ee(i, e.j.bdo());
    AppMethodBeat.o(351350);
    return bool;
  }
  
  public static boolean oH(long paramLong)
  {
    AppMethodBeat.i(351355);
    int i = (int)paramLong;
    e.j localj = e.j.mLf;
    boolean bool = com.tencent.mm.ae.d.ee(i, e.j.bdn());
    AppMethodBeat.o(351355);
    return bool;
  }
  
  public static boolean oI(long paramLong)
  {
    AppMethodBeat.i(351361);
    int i = (int)paramLong;
    e.j localj = e.j.mLf;
    boolean bool = com.tencent.mm.ae.d.ee(i, e.j.bdp());
    AppMethodBeat.o(351361);
    return bool;
  }
  
  public static boolean oJ(long paramLong)
  {
    AppMethodBeat.i(351369);
    int i = (int)paramLong;
    e.l locall = e.l.mLn;
    boolean bool = com.tencent.mm.ae.d.ee(i, e.l.bdu());
    AppMethodBeat.o(351369);
    return bool;
  }
  
  public static boolean oK(long paramLong)
  {
    AppMethodBeat.i(351376);
    int i = (int)paramLong;
    e.l locall = e.l.mLn;
    boolean bool = com.tencent.mm.ae.d.ee(i, e.l.bdt());
    AppMethodBeat.o(351376);
    return bool;
  }
  
  public static boolean oL(long paramLong)
  {
    AppMethodBeat.i(351388);
    int i = (int)paramLong;
    e.l locall = e.l.mLn;
    boolean bool = com.tencent.mm.ae.d.ee(i, e.l.bdv());
    AppMethodBeat.o(351388);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.util.u
 * JD-Core Version:    0.7.0.1
 */