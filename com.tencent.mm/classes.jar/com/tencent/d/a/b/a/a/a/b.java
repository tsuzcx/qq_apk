package com.tencent.d.a.b.a.a.a;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.d.a.b.a.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.findersdk.a.bl;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.protocal.protobuf.FinderTipsShowEntranceExtInfo;
import com.tencent.mm.protocal.protobuf.btw;
import com.tencent.mm.protocal.protobuf.btx;
import com.tencent.mm.protocal.protobuf.bxh;
import com.tencent.mm.protocal.protobuf.bxi;
import com.tencent.mm.protocal.protobuf.bxq;
import com.tencent.mm.protocal.protobuf.bxr;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/plugin/finder/nearby/api/config/red/NearbyRedDotGenerate;", "", "()V", "TAG", "", "currentRedDotData", "Lcom/tencent/plugin/finder/nearby/api/config/red/NearbyRedDotGenerate$RedDotData;", "fillNearbyEntrance", "", "ctrlInfo", "Lcom/tencent/mm/protocal/protobuf/FinderRedDotCtrlInfo;", "isEnterLiveRoom", "", "fillNearbyLiveRoom", "generateFinderRedDotExtInfo", "Lcom/tencent/mm/protocal/protobuf/FinderRedDotExtInfo;", "generateFinderTipsShowEntranceExtInfo", "Lcom/tencent/mm/protobuf/ByteString;", "generateFinderTipsShowInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "generateNearbyEntranceShowInfo", "generateNearbyTabShowInfo", "generateRedDot", "redDotType", "Lcom/tencent/plugin/finder/nearby/api/config/red/NearbyRedDotGenerate$RedDotType;", "getTabId", "", "saveCurrentTestRedDotData", "dataInit", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "RedDotData", "RedDotType", "plugin-finder-nearby-api_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b ahql;
  private static a ahqm;
  
  static
  {
    AppMethodBeat.i(216558);
    ahql = new b();
    AppMethodBeat.o(216558);
  }
  
  private static void a(btw parambtw, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(216513);
    Object localObject = jWB();
    ((btx)localObject).aabO = 0;
    if (paramBoolean) {
      i = 1;
    }
    ((btx)localObject).aabL = i;
    parambtw.aabz = new com.tencent.mm.bx.b(((btx)localObject).toByteArray());
    localObject = new LinkedList();
    bxq localbxq = jWE();
    localbxq.path = "FinderLiveEntrance";
    ah localah = ah.aiuX;
    ((LinkedList)localObject).add(localbxq);
    localbxq = jWC();
    localbxq.Nnp = "FinderLiveEntrance";
    localbxq.path = "NearbyLiveTab";
    localah = ah.aiuX;
    ((LinkedList)localObject).add(localbxq);
    parambtw.aabA = ((LinkedList)localObject);
    AppMethodBeat.o(216513);
  }
  
  private static void b(btw parambtw, boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(216524);
    Object localObject = jWB();
    ((btx)localObject).aabO = 1;
    if (paramBoolean) {}
    for (;;)
    {
      ((btx)localObject).aabL = i;
      parambtw.aabz = new com.tencent.mm.bx.b(((btx)localObject).toByteArray());
      localObject = new LinkedList();
      bxq localbxq = jWE();
      localbxq.path = "NearbyEntrance";
      ah localah = ah.aiuX;
      ((LinkedList)localObject).add(localbxq);
      localbxq = jWC();
      localbxq.path = "NearbyLiveTab";
      localbxq.Nnp = "NearbyEntrance";
      localah = ah.aiuX;
      ((LinkedList)localObject).add(localbxq);
      parambtw.aabA = ((LinkedList)localObject);
      AppMethodBeat.o(216524);
      return;
      i = 0;
    }
  }
  
  public static void ba(kotlin.g.a.b<? super a, ah> paramb)
  {
    Object localObject = null;
    AppMethodBeat.i(216490);
    s.u(paramb, "dataInit");
    ahqm = new a();
    a locala2 = ahqm;
    a locala1 = locala2;
    if (locala2 == null)
    {
      s.bIx("currentRedDotData");
      locala1 = null;
    }
    paramb.invoke(locala1);
    paramb = ahqm;
    if (paramb == null)
    {
      s.bIx("currentRedDotData");
      paramb = localObject;
    }
    for (;;)
    {
      Log.i("NearbyRedDotGenerate", s.X("saveCurrentTestRedDot currentRedDotData: ", paramb));
      AppMethodBeat.o(216490);
      return;
    }
  }
  
  private static int getTabId()
  {
    Object localObject2 = null;
    AppMethodBeat.i(216502);
    try
    {
      a locala2 = ahqm;
      a locala1 = locala2;
      if (locala2 == null)
      {
        s.bIx("currentRedDotData");
        locala1 = null;
      }
      int i = Integer.parseInt(locala1.ahqp);
      AppMethodBeat.o(216502);
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      localObject1 = ahqm;
      if (localObject1 != null) {
        break label76;
      }
    }
    s.bIx("currentRedDotData");
    Object localObject1 = localObject2;
    label76:
    for (;;)
    {
      Log.i("NearbyRedDotGenerate", s.X("saveCurrentTestRedDot NumberFormatException jumpTabId: ", ((a)localObject1).ahqp));
      AppMethodBeat.o(216502);
      return 0;
    }
  }
  
  private static btx jWB()
  {
    Object localObject2 = null;
    AppMethodBeat.i(216531);
    btx localbtx = new btx();
    localbtx.aabK = getTabId();
    a locala = ahqm;
    Object localObject1 = locala;
    if (locala == null)
    {
      s.bIx("currentRedDotData");
      localObject1 = null;
    }
    localbtx.object_id = ((a)localObject1).ahqn;
    localbtx.tab_type = 12;
    locala = ahqm;
    localObject1 = locala;
    if (locala == null)
    {
      s.bIx("currentRedDotData");
      localObject1 = null;
    }
    localbtx.object_nonce_id = ((a)localObject1).nonceId;
    locala = ahqm;
    localObject1 = locala;
    if (locala == null)
    {
      s.bIx("currentRedDotData");
      localObject1 = null;
    }
    localbtx.YIZ = ((a)localObject1).userName;
    locala = ahqm;
    localObject1 = locala;
    if (locala == null)
    {
      s.bIx("currentRedDotData");
      localObject1 = null;
    }
    localbtx.aabM = ((a)localObject1).finderNickName;
    localObject1 = ahqm;
    if (localObject1 == null)
    {
      s.bIx("currentRedDotData");
      localObject1 = localObject2;
    }
    for (;;)
    {
      localbtx.aabN = ((a)localObject1).coverUrl;
      AppMethodBeat.o(216531);
      return localbtx;
    }
  }
  
  private static bxq jWC()
  {
    AppMethodBeat.i(216538);
    bxq localbxq = jWD();
    localbxq.aagr = 2;
    localbxq.aags = new com.tencent.mm.bx.b(new bxr().toByteArray());
    localbxq.aagv = getTabId();
    localbxq.show_type = 15;
    AppMethodBeat.o(216538);
    return localbxq;
  }
  
  private static bxq jWD()
  {
    AppMethodBeat.i(216545);
    bxq localbxq = new bxq();
    localbxq.aagq = 1;
    AppMethodBeat.o(216545);
    return localbxq;
  }
  
  private static bxq jWE()
  {
    AppMethodBeat.i(216550);
    bxq localbxq = jWD();
    a locala2 = ahqm;
    a locala1 = locala2;
    if (locala2 == null)
    {
      s.bIx("currentRedDotData");
      locala1 = null;
    }
    localbxq.icon_url = locala1.ahqo;
    localbxq.title = "直播中";
    localbxq.aagr = 1;
    localbxq.show_type = 16;
    localbxq.aags = jWF();
    AppMethodBeat.o(216550);
    return localbxq;
  }
  
  private static com.tencent.mm.bx.b jWF()
  {
    AppMethodBeat.i(216553);
    FinderTipsShowEntranceExtInfo localFinderTipsShowEntranceExtInfo = new FinderTipsShowEntranceExtInfo();
    a locala = ahqm;
    Object localObject = locala;
    if (locala == null)
    {
      s.bIx("currentRedDotData");
      localObject = null;
    }
    localFinderTipsShowEntranceExtInfo.object_id = ((a)localObject).ahqn;
    localFinderTipsShowEntranceExtInfo.tab_type = 12;
    localObject = new com.tencent.mm.bx.b(localFinderTipsShowEntranceExtInfo.toByteArray());
    AppMethodBeat.o(216553);
    return localObject;
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(216563);
    s.u(paramb, "redDotType");
    if (ahqm == null)
    {
      AppMethodBeat.o(216563);
      return;
    }
    btw localbtw = new btw();
    localbtw.priority = 400000;
    localbtw.wso = 43200;
    localbtw.wso = 0;
    localbtw.type = 16;
    localbtw.ZYN = "test";
    bxh localbxh = new bxh();
    LinkedList localLinkedList = new LinkedList();
    Object localObject = new bxi();
    ((bxi)localObject).aagf = localbtw;
    ah localah = ah.aiuX;
    localLinkedList.add(localObject);
    localObject = ah.aiuX;
    localbxh.aace = localLinkedList;
    switch (c.$EnumSwitchMapping$0[paramb.ordinal()])
    {
    }
    for (;;)
    {
      ((cn)h.az(cn.class)).getRedDotManager().a(localbxh, "nearbyRedDotGenerateTest");
      ((a)h.ax(a.class)).resetCache();
      AppMethodBeat.o(216563);
      return;
      a(localbtw, true);
      continue;
      a(localbtw, false);
      continue;
      b(localbtw, true);
      continue;
      b(localbtw, false);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/plugin/finder/nearby/api/config/red/NearbyRedDotGenerate$RedDotData;", "", "feedObjectId", "", "redIconUrl", "", "jumpTabId", "nonceId", "userName", "finderNickName", "coverUrl", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCoverUrl", "()Ljava/lang/String;", "setCoverUrl", "(Ljava/lang/String;)V", "getFeedObjectId", "()J", "setFeedObjectId", "(J)V", "getFinderNickName", "setFinderNickName", "getJumpTabId", "setJumpTabId", "getNonceId", "setNonceId", "getRedIconUrl", "setRedIconUrl", "getUserName", "setUserName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-finder-nearby-api_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public long ahqn = 0L;
    public String ahqo;
    public String ahqp;
    public String coverUrl;
    public String finderNickName;
    public String nonceId;
    public String userName;
    
    private a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
    {
      this.ahqo = paramString1;
      this.ahqp = paramString2;
      this.nonceId = paramString3;
      this.userName = paramString4;
      this.finderNickName = paramString5;
      this.coverUrl = paramString6;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(216544);
      if (this == paramObject)
      {
        AppMethodBeat.o(216544);
        return true;
      }
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(216544);
        return false;
      }
      paramObject = (a)paramObject;
      if (this.ahqn != paramObject.ahqn)
      {
        AppMethodBeat.o(216544);
        return false;
      }
      if (!s.p(this.ahqo, paramObject.ahqo))
      {
        AppMethodBeat.o(216544);
        return false;
      }
      if (!s.p(this.ahqp, paramObject.ahqp))
      {
        AppMethodBeat.o(216544);
        return false;
      }
      if (!s.p(this.nonceId, paramObject.nonceId))
      {
        AppMethodBeat.o(216544);
        return false;
      }
      if (!s.p(this.userName, paramObject.userName))
      {
        AppMethodBeat.o(216544);
        return false;
      }
      if (!s.p(this.finderNickName, paramObject.finderNickName))
      {
        AppMethodBeat.o(216544);
        return false;
      }
      if (!s.p(this.coverUrl, paramObject.coverUrl))
      {
        AppMethodBeat.o(216544);
        return false;
      }
      AppMethodBeat.o(216544);
      return true;
    }
    
    public final int hashCode()
    {
      int i1 = 0;
      AppMethodBeat.i(216537);
      int i2 = q.a..ExternalSyntheticBackport0.m(this.ahqn);
      int i;
      int j;
      label35:
      int k;
      label44:
      int m;
      label54:
      int n;
      if (this.ahqo == null)
      {
        i = 0;
        if (this.ahqp != null) {
          break label123;
        }
        j = 0;
        if (this.nonceId != null) {
          break label134;
        }
        k = 0;
        if (this.userName != null) {
          break label145;
        }
        m = 0;
        if (this.finderNickName != null) {
          break label157;
        }
        n = 0;
        label64:
        if (this.coverUrl != null) {
          break label169;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(216537);
        return (n + (m + (k + (j + (i + i2 * 31) * 31) * 31) * 31) * 31) * 31 + i1;
        i = this.ahqo.hashCode();
        break;
        label123:
        j = this.ahqp.hashCode();
        break label35;
        label134:
        k = this.nonceId.hashCode();
        break label44;
        label145:
        m = this.userName.hashCode();
        break label54;
        label157:
        n = this.finderNickName.hashCode();
        break label64;
        label169:
        i1 = this.coverUrl.hashCode();
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(216529);
      String str = "feedObjectId: " + this.ahqn + "  redIconUrl: " + this.ahqo + " jumpTabId: " + this.ahqp + " nonceId: " + this.nonceId + " userName: " + this.userName + " finderNickName: " + this.finderNickName + " coverUrl: " + this.coverUrl;
      AppMethodBeat.o(216529);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/plugin/finder/nearby/api/config/red/NearbyRedDotGenerate$RedDotType;", "", "(Ljava/lang/String;I)V", "FIND_NEARBY_INDEPENDENT_LIVE_ROOM", "FIND_NEARBY_INDEPENDENT_LIVE_SQUARE", "FIND_NEARBY_LIVE_ROOM", "FIND_NEARBY_LIVE_SQUARE", "plugin-finder-nearby-api_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum b
  {
    static
    {
      AppMethodBeat.i(216542);
      ahqq = new b("FIND_NEARBY_INDEPENDENT_LIVE_ROOM", 0);
      ahqr = new b("FIND_NEARBY_INDEPENDENT_LIVE_SQUARE", 1);
      ahqs = new b("FIND_NEARBY_LIVE_ROOM", 2);
      ahqt = new b("FIND_NEARBY_LIVE_SQUARE", 3);
      ahqu = new b[] { ahqq, ahqr, ahqs, ahqt };
      AppMethodBeat.o(216542);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.d.a.b.a.a.a.b
 * JD-Core Version:    0.7.0.1
 */