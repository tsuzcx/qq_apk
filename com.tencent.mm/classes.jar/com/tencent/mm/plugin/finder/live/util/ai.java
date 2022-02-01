package com.tencent.mm.plugin.finder.live.util;

import androidx.lifecycle.x;
import com.tencent.d.a.a.a.b.c.a;
import com.tencent.d.a.a.a.b.c.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.finder.live.model.context.a;
import com.tencent.mm.plugin.finder.utils.bq;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bed;
import com.tencent.mm.protocal.protobuf.bel;
import com.tencent.mm.protocal.protobuf.bes;
import com.tencent.mm.protocal.protobuf.bfv;
import com.tencent.mm.protocal.protobuf.bgh;
import com.tencent.mm.protocal.protobuf.boi;
import com.tencent.mm.protocal.protobuf.bsr;
import com.tencent.mm.protocal.protobuf.edf;
import com.tencent.mm.protocal.protobuf.etk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aj;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/util/FinderLiveBoxUtil;", "", "()V", "fillBoxShareReport", "", "toUsers", "", "", "newChnlExtra", "", "genAtWxFriendCommentMsg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "boxId", "Lcom/tencent/mm/protocal/protobuf/FinderLiveBoxId;", "atUser", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "replyContent", "genLikeMsg", "likeMsg", "originLikeCount", "", "opType", "genLocationMsg", "location", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "extraFastCommentContent", "genReplyCommentMsg", "cdnServerIp", "genTextMsg", "content", "getChatDisplayName", "username", "nickname", "showDebugInfo", "", "getGroupMemberCount", "groupId", "getGroupUserName", "getSelfContact", "isChatRoomDisable", "isChatRoomDismiss", "isNotInChatRoom", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ai
{
  public static final ai akfD;
  
  static
  {
    AppMethodBeat.i(371123);
    akfD = new ai();
    AppMethodBeat.o(371123);
  }
  
  public static bdm a(bdm parambdm, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(371108);
    kotlin.g.b.s.u(parambdm, "likeMsg");
    bfv localbfv = parambdm.akjQ;
    if (localbfv != null)
    {
      localObject = (CharSequence)localbfv.id;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label60;
      }
    }
    label60:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(371108);
      return null;
    }
    Object localObject = new bdm();
    ((bdm)localObject).msg_type = 20062;
    etk localetk = new etk();
    localetk.abWe = parambdm.seq;
    localetk.akjQ = localbfv;
    localetk.YAN = paramInt2;
    localetk.akkK = paramInt1;
    parambdm = c.a.akmY;
    if (paramInt2 == c.a.a.kMH()) {
      localetk.akkK += 1;
    }
    for (;;)
    {
      localetk.akkK = Math.max(0, localetk.akkK);
      parambdm = ah.aiuX;
      ((bdm)localObject).ZNY = com.tencent.mm.bx.b.cX(localetk.toByteArray());
      ((bdm)localObject).ZOb = jKu();
      ((bdm)localObject).akjQ = localbfv;
      ((bdm)localObject).Tro = kotlin.g.b.s.X(z.bAM(), Long.valueOf(System.currentTimeMillis()));
      AppMethodBeat.o(371108);
      return localObject;
      parambdm = c.a.akmY;
      if (paramInt2 == c.a.a.kMI()) {
        localetk.akkK -= 1;
      }
    }
  }
  
  public static bdm a(bfv parambfv, bgh parambgh, String paramString1, String paramString2)
  {
    AppMethodBeat.i(371114);
    kotlin.g.b.s.u(parambfv, "boxId");
    kotlin.g.b.s.u(parambgh, "atUser");
    kotlin.g.b.s.u(paramString1, "replyContent");
    bdm localbdm = new bdm();
    localbdm.ZNW = parambgh;
    parambgh = new bes();
    parambgh.content = paramString1;
    paramString1 = new bsr();
    paramString1.aaav = paramString2;
    paramString2 = ah.aiuX;
    parambgh.ZPb = paramString1;
    paramString1 = ah.aiuX;
    localbdm.ZNY = com.tencent.mm.bx.b.cX(parambgh.toByteArray());
    localbdm.msg_type = 20002;
    localbdm.Tro = kotlin.g.b.s.X(z.bAM(), Long.valueOf(System.currentTimeMillis()));
    localbdm.ZOb = jKu();
    localbdm.akjQ = parambfv;
    AppMethodBeat.o(371114);
    return localbdm;
  }
  
  public static bdm a(bfv parambfv, boi paramboi, a parama, String paramString)
  {
    AppMethodBeat.i(371113);
    kotlin.g.b.s.u(parambfv, "boxId");
    kotlin.g.b.s.u(paramboi, "location");
    kotlin.g.b.s.u(parama, "liveData");
    parama = new bdm();
    bel localbel = new bel();
    localbel.location = paramboi;
    localbel.content = paramString;
    paramboi = ah.aiuX;
    parama.ZNY = com.tencent.mm.bx.b.cX(localbel.toByteArray());
    parama.msg_type = 20035;
    parama.Tro = kotlin.g.b.s.X(z.bAM(), Long.valueOf(System.currentTimeMillis()));
    parama.ZOb = jKu();
    parama.akjQ = parambfv;
    AppMethodBeat.o(371113);
    return parama;
  }
  
  public static bdm a(bfv parambfv, String paramString)
  {
    AppMethodBeat.i(371110);
    kotlin.g.b.s.u(parambfv, "boxId");
    kotlin.g.b.s.u(paramString, "content");
    bdm localbdm = new bdm();
    localbdm.msg_type = 20057;
    edf localedf = new edf();
    localedf.content = paramString;
    paramString = ah.aiuX;
    localbdm.ZNY = com.tencent.mm.bx.b.cX(localedf.toByteArray());
    localbdm.ZOb = jKu();
    localbdm.akjQ = parambfv;
    localbdm.Tro = kotlin.g.b.s.X(z.bAM(), Long.valueOf(System.currentTimeMillis()));
    AppMethodBeat.o(371110);
    return localbdm;
  }
  
  public static bdm a(bfv parambfv, List<? extends bgh> paramList, String paramString)
  {
    ah localah = null;
    AppMethodBeat.i(371112);
    kotlin.g.b.s.u(parambfv, "boxId");
    kotlin.g.b.s.u(paramList, "atUser");
    kotlin.g.b.s.u(paramString, "replyContent");
    bdm localbdm = new bdm();
    Iterator localIterator = ((Iterable)paramList).iterator();
    if (localIterator.hasNext())
    {
      Object localObject2 = localIterator.next();
      localObject1 = ((bgh)localObject2).contact;
      if (localObject1 == null)
      {
        localObject1 = null;
        label80:
        if (!kotlin.g.b.s.p(localObject1, "notify@all")) {
          break label204;
        }
        localObject1 = localObject2;
        label93:
        if ((bgh)localObject1 != null) {
          break label211;
        }
      }
    }
    for (Object localObject1 = localah;; localObject1 = ah.aiuX)
    {
      if (localObject1 == null)
      {
        localbdm.msg_type = 20034;
        localObject1 = new bed();
        ((bed)localObject1).content = paramString;
        ((bed)localObject1).ZOH = new LinkedList((Collection)paramList);
        paramList = ah.aiuX;
        localbdm.ZNY = com.tencent.mm.bx.b.cX(((bed)localObject1).toByteArray());
      }
      localbdm.ZOb = jKu();
      localbdm.Tro = kotlin.g.b.s.X(z.bAM(), Long.valueOf(System.currentTimeMillis()));
      localbdm.akjQ = parambfv;
      AppMethodBeat.o(371112);
      return localbdm;
      localObject1 = ((FinderContact)localObject1).username;
      break label80;
      label204:
      break;
      localObject1 = null;
      break label93;
      label211:
      localbdm.msg_type = 20032;
      localObject1 = new bed();
      ((bed)localObject1).content = paramString;
      localah = ah.aiuX;
      localbdm.ZNY = com.tencent.mm.bx.b.cX(((bed)localObject1).toByteArray());
    }
  }
  
  public static String bkH(String paramString)
  {
    AppMethodBeat.i(371117);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramString = z.bAM();
      kotlin.g.b.s.s(paramString, "getUsernameFromUserInfo()");
      AppMethodBeat.o(371117);
      return paramString;
    }
    try
    {
      paramString = ((com.tencent.mm.plugin.chatroom.a.b)h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(paramString);
      if (paramString == null)
      {
        Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "getGroupUserName member == null");
        paramString = z.bAM();
        kotlin.g.b.s.s(paramString, "getUsernameFromUserInfo()");
        AppMethodBeat.o(371117);
        return paramString;
      }
    }
    finally
    {
      Log.i("MicroMsg.BizTimeLineStorageLogicExKt", kotlin.g.b.s.X("getGroupUserName exception: ", paramString.getMessage()));
      paramString = z.bAM();
      kotlin.g.b.s.s(paramString, "getUsernameFromUserInfo()");
      AppMethodBeat.o(371117);
      return paramString;
    }
    paramString = paramString.field_selfDisplayName;
    localCharSequence = (CharSequence)paramString;
    if (localCharSequence != null)
    {
      if (localCharSequence.length() != 0) {
        break label267;
      }
      break label237;
      if (paramString == null)
      {
        paramString = z.bAO();
        localCharSequence = (CharSequence)paramString;
        if (localCharSequence == null) {
          break label252;
        }
        if (localCharSequence.length() != 0) {
          break label282;
        }
        break label252;
      }
    }
    for (;;)
    {
      label198:
      if (paramString == null)
      {
        paramString = z.bAM();
        kotlin.g.b.s.s(paramString, "getUsernameFromUserInfo()");
        AppMethodBeat.o(371117);
        return paramString;
      }
      AppMethodBeat.o(371117);
      return paramString;
      AppMethodBeat.o(371117);
      return paramString;
      label237:
      i = 1;
      label239:
      if (i == 0)
      {
        i = 1;
        label245:
        if (i == 0) {
          break label277;
        }
        break;
        label252:
        i = 1;
        label254:
        if (i != 0) {
          break label287;
        }
      }
      label267:
      label277:
      label282:
      label287:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label292;
        }
        break label198;
        i = 0;
        break label239;
        i = 0;
        break label245;
        paramString = null;
        break;
        i = 0;
        break label254;
      }
      label292:
      paramString = null;
    }
  }
  
  public static void e(List<String> paramList, Map<String, String> paramMap)
  {
    AppMethodBeat.i(371121);
    kotlin.g.b.s.u(paramList, "toUsers");
    kotlin.g.b.s.u(paramMap, "newChnlExtra");
    Object localObject1 = a.CMm;
    localObject1 = a.emY();
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = bq.akii;
      if (bq.B((a)localObject1) == true)
      {
        i = 1;
        if (i == 0) {
          break label258;
        }
        localObject1 = a.CMm;
        localObject1 = a.emY();
        if (localObject1 == null) {
          break label258;
        }
        localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)((a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.class);
        if (localObject1 == null) {
          break label258;
        }
        localObject1 = (bfv)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)localObject1).akgQ.getValue();
        if (localObject1 != null) {
          break label173;
        }
        localObject1 = "";
      }
    }
    for (;;)
    {
      localObject2 = (Iterable)paramList;
      paramList = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = ((Iterator)localObject2).next();
        if (n.rs((String)localObject3, "@chatroom")) {
          paramList.add(localObject3);
        }
      }
      i = 0;
      break;
      label173:
      localObject1 = ((bfv)localObject1).id;
      if (localObject1 == null) {
        localObject1 = "";
      }
    }
    paramList = (String)p.oN((List)paramList);
    if (paramList != null)
    {
      paramMap.put("group_box_number", localObject1);
      localObject1 = (CharSequence)paramList;
      if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
        break label265;
      }
      i = 1;
      if (i == 0) {
        break label270;
      }
    }
    label258:
    label265:
    label270:
    for (int i = 0;; i = ((c)h.az(c.class)).getMembersCountByChatRoomName(paramList))
    {
      paramMap.put("group_users_number", String.valueOf(i));
      AppMethodBeat.o(371121);
      return;
      i = 0;
      break;
    }
  }
  
  public static boolean isChatRoomDismiss(String paramString)
  {
    AppMethodBeat.i(371119);
    boolean bool = ((c)h.az(c.class)).isChatRoomDismiss(paramString);
    Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "isChatRoomDismiss " + paramString + ", " + bool);
    AppMethodBeat.o(371119);
    return bool;
  }
  
  public static boolean isNotInChatRoom(String paramString)
  {
    AppMethodBeat.i(371120);
    boolean bool = ((c)h.az(c.class)).isNotInChatRoom(paramString);
    Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "isNotInChatRoom " + paramString + ", " + bool);
    AppMethodBeat.o(371120);
    return bool;
  }
  
  private static bgh jKu()
  {
    AppMethodBeat.i(371115);
    bgh localbgh = new bgh();
    FinderContact localFinderContact = new FinderContact();
    localFinderContact.username = z.bAM();
    localFinderContact.nickname = z.bAO();
    localFinderContact.headUrl = "";
    ah localah = ah.aiuX;
    localbgh.contact = localFinderContact;
    AppMethodBeat.o(371115);
    return localbgh;
  }
  
  /* Error */
  public static String n(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 476
    //   3: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ldc 199
    //   9: invokestatic 83	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   12: aload_1
    //   13: ldc_w 477
    //   16: invokestatic 83	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   19: aload_2
    //   20: ldc_w 478
    //   23: invokestatic 83	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   26: iload_3
    //   27: ifeq +46 -> 73
    //   30: ldc_w 320
    //   33: new 438	java/lang/StringBuilder
    //   36: dup
    //   37: ldc_w 480
    //   40: invokespecial 443	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   43: aload_0
    //   44: invokevirtual 452	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: ldc_w 449
    //   50: invokevirtual 452	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: aload_1
    //   54: invokevirtual 452	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: ldc_w 482
    //   60: invokevirtual 452	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: aload_2
    //   64: invokevirtual 452	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 458	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: invokestatic 327	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   73: ldc_w 484
    //   76: invokestatic 308	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   79: checkcast 484	com/tencent/mm/plugin/messenger/foundation/a/n
    //   82: invokeinterface 488 1 0
    //   87: aload_1
    //   88: invokeinterface 494 2 0
    //   93: astore 9
    //   95: aload_1
    //   96: invokestatic 499	com/tencent/mm/model/aa:IE	(Ljava/lang/String;)Ljava/lang/String;
    //   99: astore 10
    //   101: aload 9
    //   103: aload 10
    //   105: checkcast 97	java/lang/CharSequence
    //   108: invokestatic 504	com/tencent/mm/openim/room/a/a:a	(Lcom/tencent/mm/storage/au;Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    //   111: astore 5
    //   113: aload 5
    //   115: ifnonnull +319 -> 434
    //   118: ldc_w 383
    //   121: astore 5
    //   123: aload 5
    //   125: astore 6
    //   127: aload 5
    //   129: astore 8
    //   131: aload 5
    //   133: checkcast 97	java/lang/CharSequence
    //   136: invokeinterface 101 1 0
    //   141: ifne +317 -> 458
    //   144: iconst_1
    //   145: istore 4
    //   147: aload 5
    //   149: astore 7
    //   151: iload 4
    //   153: ifeq +575 -> 728
    //   156: aload 5
    //   158: astore 6
    //   160: aload 5
    //   162: astore 8
    //   164: ldc_w 302
    //   167: invokestatic 308	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   170: checkcast 302	com/tencent/mm/plugin/chatroom/a/b
    //   173: invokeinterface 312 1 0
    //   178: aload_0
    //   179: invokeinterface 318 2 0
    //   184: astore 7
    //   186: aload 7
    //   188: ifnonnull +276 -> 464
    //   191: ldc_w 383
    //   194: astore 5
    //   196: aload 5
    //   198: astore 6
    //   200: aload 5
    //   202: astore 8
    //   204: aload 5
    //   206: checkcast 97	java/lang/CharSequence
    //   209: invokeinterface 101 1 0
    //   214: ifne +531 -> 745
    //   217: iconst_1
    //   218: istore 4
    //   220: aload 5
    //   222: astore 7
    //   224: iload 4
    //   226: ifeq +36 -> 262
    //   229: aload 5
    //   231: astore 6
    //   233: aload 5
    //   235: astore 8
    //   237: aload 9
    //   239: aload_1
    //   240: invokestatic 507	com/tencent/mm/model/aa:getDisplayName	(Ljava/lang/String;)Ljava/lang/String;
    //   243: checkcast 97	java/lang/CharSequence
    //   246: invokestatic 504	com/tencent/mm/openim/room/a/a:a	(Lcom/tencent/mm/storage/au;Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    //   249: astore 7
    //   251: aload 7
    //   253: ifnonnull +240 -> 493
    //   256: aload_2
    //   257: astore 5
    //   259: goto +476 -> 735
    //   262: aload 7
    //   264: astore 6
    //   266: aload 7
    //   268: astore 8
    //   270: aload 7
    //   272: checkcast 97	java/lang/CharSequence
    //   275: invokeinterface 101 1 0
    //   280: istore 4
    //   282: iload 4
    //   284: ifne +243 -> 527
    //   287: iconst_1
    //   288: istore 4
    //   290: iload 4
    //   292: ifeq +436 -> 728
    //   295: aload_2
    //   296: astore 5
    //   298: iload_3
    //   299: ifeq +68 -> 367
    //   302: ldc_w 320
    //   305: new 438	java/lang/StringBuilder
    //   308: dup
    //   309: ldc_w 509
    //   312: invokespecial 443	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   315: aload_0
    //   316: invokevirtual 452	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: ldc_w 449
    //   322: invokevirtual 452	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: aload_1
    //   326: invokevirtual 452	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: ldc_w 482
    //   332: invokevirtual 452	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: aload_2
    //   336: invokevirtual 452	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: ldc_w 511
    //   342: invokevirtual 452	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: aload 9
    //   347: invokevirtual 447	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   350: ldc_w 513
    //   353: invokevirtual 452	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: aload 10
    //   358: invokevirtual 447	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   361: invokevirtual 458	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   364: invokestatic 327	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   367: iload_3
    //   368: ifeq +57 -> 425
    //   371: ldc_w 320
    //   374: new 438	java/lang/StringBuilder
    //   377: dup
    //   378: ldc_w 515
    //   381: invokespecial 443	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   384: aload_0
    //   385: invokevirtual 452	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: ldc_w 449
    //   391: invokevirtual 452	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: aload_1
    //   395: invokevirtual 452	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: ldc_w 482
    //   401: invokevirtual 452	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   404: aload_2
    //   405: invokevirtual 452	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: ldc_w 517
    //   411: invokevirtual 452	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: aload 5
    //   416: invokevirtual 452	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: invokevirtual 458	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   422: invokestatic 327	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   425: ldc_w 476
    //   428: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   431: aload 5
    //   433: areturn
    //   434: aload 5
    //   436: invokevirtual 518	java/lang/Object:toString	()Ljava/lang/String;
    //   439: astore 6
    //   441: aload 6
    //   443: astore 5
    //   445: aload 6
    //   447: ifnonnull -324 -> 123
    //   450: ldc_w 383
    //   453: astore 5
    //   455: goto -332 -> 123
    //   458: iconst_0
    //   459: istore 4
    //   461: goto -314 -> 147
    //   464: aload 5
    //   466: astore 6
    //   468: aload 5
    //   470: astore 8
    //   472: aload 7
    //   474: aload_1
    //   475: invokevirtual 519	com/tencent/mm/storage/aj:getDisplayName	(Ljava/lang/String;)Ljava/lang/String;
    //   478: astore 5
    //   480: aload 5
    //   482: ifnonnull +260 -> 742
    //   485: ldc_w 383
    //   488: astore 5
    //   490: goto -294 -> 196
    //   493: aload 5
    //   495: astore 6
    //   497: aload 5
    //   499: astore 8
    //   501: aload 7
    //   503: invokevirtual 518	java/lang/Object:toString	()Ljava/lang/String;
    //   506: astore 5
    //   508: aload 5
    //   510: astore 6
    //   512: aload 6
    //   514: astore 5
    //   516: aload 6
    //   518: ifnonnull +217 -> 735
    //   521: aload_2
    //   522: astore 5
    //   524: goto +211 -> 735
    //   527: iconst_0
    //   528: istore 4
    //   530: goto -240 -> 290
    //   533: astore 5
    //   535: aload_2
    //   536: astore 8
    //   538: aload 8
    //   540: astore 6
    //   542: getstatic 525	com/tencent/mm/plugin/finder/utils/aw:Gjk	Lcom/tencent/mm/plugin/finder/utils/aw;
    //   545: astore 7
    //   547: aload 8
    //   549: astore 6
    //   551: aload 5
    //   553: ldc_w 526
    //   556: invokestatic 529	com/tencent/mm/plugin/finder/utils/aw:a	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   559: iload_3
    //   560: ifeq +56 -> 616
    //   563: ldc_w 320
    //   566: new 438	java/lang/StringBuilder
    //   569: dup
    //   570: ldc_w 515
    //   573: invokespecial 443	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   576: aload_0
    //   577: invokevirtual 452	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   580: ldc_w 449
    //   583: invokevirtual 452	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: aload_1
    //   587: invokevirtual 452	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: ldc_w 482
    //   593: invokevirtual 452	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: aload_2
    //   597: invokevirtual 452	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   600: ldc_w 517
    //   603: invokevirtual 452	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   606: aload_2
    //   607: invokevirtual 452	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   610: invokevirtual 458	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   613: invokestatic 327	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   616: ldc_w 476
    //   619: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   622: aload_2
    //   623: areturn
    //   624: astore 5
    //   626: aload_2
    //   627: astore 5
    //   629: iload_3
    //   630: ifeq +57 -> 687
    //   633: ldc_w 320
    //   636: new 438	java/lang/StringBuilder
    //   639: dup
    //   640: ldc_w 515
    //   643: invokespecial 443	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   646: aload_0
    //   647: invokevirtual 452	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   650: ldc_w 449
    //   653: invokevirtual 452	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   656: aload_1
    //   657: invokevirtual 452	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   660: ldc_w 482
    //   663: invokevirtual 452	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   666: aload_2
    //   667: invokevirtual 452	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: ldc_w 517
    //   673: invokevirtual 452	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   676: aload 5
    //   678: invokevirtual 452	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   681: invokevirtual 458	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   684: invokestatic 327	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   687: ldc_w 476
    //   690: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   693: aload 5
    //   695: areturn
    //   696: astore 5
    //   698: aload 6
    //   700: astore 5
    //   702: goto -73 -> 629
    //   705: astore 6
    //   707: goto -78 -> 629
    //   710: astore 5
    //   712: goto -174 -> 538
    //   715: astore 6
    //   717: aload 5
    //   719: astore 8
    //   721: aload 6
    //   723: astore 5
    //   725: goto -187 -> 538
    //   728: aload 7
    //   730: astore 5
    //   732: goto -434 -> 298
    //   735: aload 5
    //   737: astore 7
    //   739: goto -477 -> 262
    //   742: goto -546 -> 196
    //   745: iconst_0
    //   746: istore 4
    //   748: goto -528 -> 220
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	751	0	paramString1	String
    //   0	751	1	paramString2	String
    //   0	751	2	paramString3	String
    //   0	751	3	paramBoolean	boolean
    //   145	602	4	i	int
    //   111	412	5	localObject1	Object
    //   533	19	5	localException1	java.lang.Exception
    //   624	1	5	localObject2	Object
    //   627	67	5	str1	String
    //   696	1	5	localObject3	Object
    //   700	1	5	localObject4	Object
    //   710	8	5	localException2	java.lang.Exception
    //   723	13	5	localObject5	Object
    //   125	574	6	localObject6	Object
    //   705	1	6	localObject7	Object
    //   715	7	6	localException3	java.lang.Exception
    //   149	589	7	localObject8	Object
    //   129	591	8	localObject9	Object
    //   93	253	9	localau	com.tencent.mm.storage.au
    //   99	258	10	str2	String
    // Exception table:
    //   from	to	target	type
    //   73	113	533	java/lang/Exception
    //   434	441	533	java/lang/Exception
    //   73	113	624	finally
    //   434	441	624	finally
    //   131	144	696	finally
    //   164	186	696	finally
    //   204	217	696	finally
    //   237	251	696	finally
    //   270	282	696	finally
    //   472	480	696	finally
    //   501	508	696	finally
    //   542	547	696	finally
    //   551	559	696	finally
    //   302	367	705	finally
    //   131	144	710	java/lang/Exception
    //   164	186	710	java/lang/Exception
    //   204	217	710	java/lang/Exception
    //   237	251	710	java/lang/Exception
    //   270	282	710	java/lang/Exception
    //   472	480	710	java/lang/Exception
    //   501	508	710	java/lang/Exception
    //   302	367	715	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.util.ai
 * JD-Core Version:    0.7.0.1
 */