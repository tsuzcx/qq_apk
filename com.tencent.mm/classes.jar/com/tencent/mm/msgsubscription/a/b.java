package com.tencent.mm.msgsubscription.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.ShowInfo;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestDialogUiData;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestDialogUiData.ItemUiData;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.WordingInfo;
import com.tencent.mm.msgsubscription.util.a;
import com.tencent.mm.msgsubscription.util.a.a;
import com.tencent.mm.msgsubscription.util.a.b;
import com.tencent.mm.msgsubscription.util.a.c;
import com.tencent.mm.msgsubscription.util.a.c.a;
import com.tencent.mm.protocal.protobuf.cgj;
import com.tencent.mm.protocal.protobuf.ddg;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.protocal.protobuf.efc;
import com.tencent.mm.protocal.protobuf.efd;
import com.tencent.mm.protocal.protobuf.efe;
import com.tencent.mm.protocal.protobuf.eff;
import com.tencent.mm.protocal.protobuf.efg;
import com.tencent.mm.protocal.protobuf.efh;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import kotlin.t;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg;", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase;", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IOnSceneEnd;", "username", "", "actionType", "", "(Ljava/lang/String;I)V", "isOpened", "", "(Ljava/lang/String;IZ)V", "appId", "(Ljava/lang/String;Ljava/lang/String;I)V", "getActionType", "()I", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "byteArray", "", "getByteArray", "()[B", "setByteArray", "([B)V", "extInfo", "itemList", "", "Lcom/tencent/mm/protocal/protobuf/SubscribeMsgItem;", "mSubscribeEndCallback", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$IOnNetSceneSubscribeEndCallback;", "popupScene", "rr", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IReqResp;", "sessionId", "subscribeUrl", "uIData", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "getUsername", "setUsername", "doScene", "dispatcher", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IDispatcher;", "getCallback", "getReq", "Lcom/tencent/mm/protocal/protobuf/SubscribeMsgReq;", "getResp", "Lcom/tencent/mm/protocal/protobuf/SubscribeMsgResp;", "getType", "onSceneEnd", "", "errType", "errCode", "errMsg", "scene", "setCallback", "callback", "Builder", "Companion", "IOnNetSceneSubscribeEndCallback", "wxbiz-msgsubscription-sdk_release"})
public final class b
  extends a
  implements a.b
{
  public static final b.b jzt;
  private final int actionType;
  private String appId;
  private String extInfo;
  private boolean jyo;
  private final List<efc> jzm;
  private a.c jzn;
  public c jzo;
  private String jzp;
  private SubscribeMsgRequestDialogUiData jzq;
  private int jzr;
  private byte[] jzs;
  private String sessionId;
  public String username;
  
  static
  {
    AppMethodBeat.i(149573);
    jzt = new b.b((byte)0);
    AppMethodBeat.o(149573);
  }
  
  public b(String paramString, int paramInt)
  {
    this(paramString, "", paramInt);
    AppMethodBeat.i(149571);
    AppMethodBeat.o(149571);
  }
  
  public b(String paramString, int paramInt, boolean paramBoolean)
  {
    this(paramString, paramInt);
    AppMethodBeat.i(149572);
    this.jyo = paramBoolean;
    AppMethodBeat.o(149572);
  }
  
  public b(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(194266);
    this.username = paramString1;
    this.appId = paramString2;
    this.actionType = paramInt;
    this.jzm = ((List)new ArrayList());
    this.jzp = "";
    this.sessionId = "";
    this.extInfo = "";
    this.jzs = new byte[0];
    AppMethodBeat.o(194266);
  }
  
  public final int a(a.a parama)
  {
    int i = 1;
    AppMethodBeat.i(174564);
    p.h(parama, "dispatcher");
    Object localObject1 = a.c.jCZ;
    this.jzn = a.c.a.a((dop)new efd(), (dpc)new efe(), "/cgi-bin/mmbiz-bin/bizattr/subscribemsg");
    localObject1 = this.jzn;
    if (localObject1 == null) {
      p.hyc();
    }
    localObject1 = ((a.c)localObject1).bjh();
    if (localObject1 == null)
    {
      parama = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.SubscribeMsgReq");
      AppMethodBeat.o(174564);
      throw parama;
    }
    localObject1 = (efd)localObject1;
    ((efd)localObject1).Nfh = this.jzr;
    ((efd)localObject1).SessionId = this.sessionId;
    ((efd)localObject1).Nfi = this.extInfo;
    switch (this.actionType)
    {
    case 4: 
    default: 
      localObject1 = this.jzn;
      if (localObject1 == null) {
        p.hyc();
      }
      i = parama.a((a.c)localObject1, (a.b)this, (a)this);
      AppMethodBeat.o(174564);
      return i;
    case 2: 
    case 3: 
    case 5: 
      ((efd)localObject1).KSV = this.username;
      ((efd)localObject1).jfi = this.appId;
      ((efd)localObject1).KWb = this.actionType;
      ((efd)localObject1).xKD.addAll((Collection)this.jzm);
      if (((CharSequence)this.jzp).length() > 0) {}
      while (i != 0)
      {
        ((efd)localObject1).Nff = this.jzp;
        break;
        i = 0;
      }
    }
    ((efd)localObject1).KSV = this.username;
    ((efd)localObject1).jfi = this.appId;
    ((efd)localObject1).KWb = this.actionType;
    ((efd)localObject1).KTf = 1;
    if (this.jyo) {}
    for (i = 1;; i = 0)
    {
      ((efd)localObject1).NeZ = i;
      ((efd)localObject1).xKD.addAll((Collection)this.jzm);
      if (this.actionType != 6) {
        break;
      }
      ((efd)localObject1).Buffer = new com.tencent.mm.bw.b(this.jzs);
      ((efd)localObject1).Nfg = new ddg();
      Object localObject2 = this.jzq;
      if (localObject2 == null) {
        break;
      }
      ((efd)localObject1).Nfg.MIp = ((SubscribeMsgRequestDialogUiData)localObject2).jxU;
      ((efd)localObject1).Nfg.him = ((SubscribeMsgRequestDialogUiData)localObject2).opType;
      localObject2 = ((SubscribeMsgRequestDialogUiData)localObject2).jxV.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        SubscribeMsgRequestDialogUiData.ItemUiData localItemUiData = (SubscribeMsgRequestDialogUiData.ItemUiData)((Iterator)localObject2).next();
        LinkedList localLinkedList = ((efd)localObject1).Nfg.MIq;
        efg localefg = new efg();
        localefg.Mqy = localItemUiData.ixM;
        localefg.NeX = localItemUiData.jyd;
        localLinkedList.add(localefg);
      }
      break;
    }
  }
  
  public final void au(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(149567);
    p.h(paramArrayOfByte, "<set-?>");
    this.jzs = paramArrayOfByte;
    AppMethodBeat.o(149567);
  }
  
  public final void k(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(174565);
    Object localObject2;
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      localObject2 = this.jzo;
      if (localObject2 != null)
      {
        localObject1 = paramString;
        if (paramString == null) {
          localObject1 = "";
        }
        ((c)localObject2).a(paramInt1, paramInt2, (String)localObject1, null);
        AppMethodBeat.o(174565);
        return;
      }
      AppMethodBeat.o(174565);
      return;
    }
    Object localObject1 = this.jzn;
    if (localObject1 == null) {
      p.hyc();
    }
    localObject1 = ((a.c)localObject1).bji();
    if (localObject1 == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.SubscribeMsgResp");
      AppMethodBeat.o(174565);
      throw paramString;
    }
    efe localefe = (efe)localObject1;
    c localc = this.jzo;
    ArrayList localArrayList;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    boolean bool1;
    if (localc != null)
    {
      localObject1 = paramString;
      if (paramString == null) {
        localObject1 = "";
      }
      paramString = SubscribeMsgRequestResult.jyx;
      p.h(localefe, "response");
      localArrayList = new ArrayList();
      paramString = localefe.xJg;
      p.g(paramString, "response.InfoList");
      paramString = ((Iterable)paramString).iterator();
      while (paramString.hasNext())
      {
        localObject2 = (efc)paramString.next();
        localObject3 = new ArrayList();
        localObject4 = ((efc)localObject2).KZi;
        p.g(localObject4, "it.KeyWordList");
        localObject4 = ((Iterable)localObject4).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (cgj)((Iterator)localObject4).next();
          ((ArrayList)localObject3).add(new o(((cgj)localObject5).Name, ((cgj)localObject5).Cyk));
        }
        p.g(localObject2, "it");
        localArrayList.add(new SubscribeMsgTmpItem((efc)localObject2, (ArrayList)localObject3));
      }
      if (localefe.Nfn == 1)
      {
        bool1 = true;
        paramString = localefe.Nfl;
        if (paramString != null) {
          break label1127;
        }
        paramString = "";
      }
    }
    label386:
    label781:
    label793:
    label812:
    label1085:
    label1091:
    label1097:
    label1103:
    label1111:
    label1127:
    for (;;)
    {
      localObject2 = localefe.Nfk;
      if (localObject2 == null) {
        localObject2 = "";
      }
      for (;;)
      {
        int j = localefe.Nfo;
        boolean bool2;
        label374:
        boolean bool3;
        Object localObject6;
        Object localObject7;
        Object localObject8;
        Object localObject9;
        Object localObject10;
        boolean bool4;
        boolean bool5;
        int k;
        if (localefe.Nfm == 1)
        {
          bool2 = true;
          if (localefe.NfA != 1) {
            break label1085;
          }
          bool3 = true;
          localObject3 = localefe.Nfj;
          if (localObject3 != null)
          {
            localObject4 = ((efh)localObject3).jyH;
            localObject3 = localObject4;
            if (localObject4 != null) {}
          }
          else
          {
            localObject3 = "";
          }
          localObject4 = localefe.Nfj;
          if (localObject4 != null)
          {
            localObject5 = ((efh)localObject4).jyI;
            localObject4 = localObject5;
            if (localObject5 != null) {}
          }
          else
          {
            localObject4 = "";
          }
          localObject5 = localefe.Nfj;
          if (localObject5 != null)
          {
            localObject6 = ((efh)localObject5).jyJ;
            localObject5 = localObject6;
            if (localObject6 != null) {}
          }
          else
          {
            localObject5 = "";
          }
          localObject6 = localefe.Nfj;
          if (localObject6 != null)
          {
            localObject7 = ((efh)localObject6).jyK;
            localObject6 = localObject7;
            if (localObject7 != null) {}
          }
          else
          {
            localObject6 = "";
          }
          localObject7 = localefe.Nfj;
          if (localObject7 != null)
          {
            localObject8 = ((efh)localObject7).jyL;
            localObject7 = localObject8;
            if (localObject8 != null) {}
          }
          else
          {
            localObject7 = "";
          }
          localObject8 = localefe.Nfj;
          if (localObject8 != null)
          {
            localObject9 = ((efh)localObject8).jyM;
            localObject8 = localObject9;
            if (localObject9 != null) {}
          }
          else
          {
            localObject8 = "";
          }
          localObject9 = localefe.Nfj;
          if (localObject9 != null)
          {
            localObject10 = ((efh)localObject9).jyN;
            localObject9 = localObject10;
            if (localObject10 != null) {}
          }
          else
          {
            localObject9 = "";
          }
          localObject10 = localefe.Nfj;
          if (localObject10 != null)
          {
            localObject11 = ((efh)localObject10).jyO;
            localObject10 = localObject11;
            if (localObject11 != null) {}
          }
          else
          {
            localObject10 = "";
          }
          Object localObject11 = localefe.Nfj;
          if (localObject11 != null)
          {
            localObject12 = ((efh)localObject11).jyP;
            localObject11 = localObject12;
            if (localObject12 != null) {}
          }
          else
          {
            localObject11 = "";
          }
          Object localObject12 = localefe.Nfj;
          if (localObject12 != null)
          {
            localObject13 = ((efh)localObject12).jyQ;
            localObject12 = localObject13;
            if (localObject13 != null) {}
          }
          else
          {
            localObject12 = "";
          }
          Object localObject13 = localefe.Nfj;
          if (localObject13 != null)
          {
            String str = ((efh)localObject13).jyR;
            localObject13 = str;
            if (str != null) {}
          }
          else
          {
            localObject13 = "";
          }
          localObject9 = new WordingInfo((String)localObject3, (String)localObject4, (String)localObject5, (String)localObject6, (String)localObject7, (String)localObject8, (String)localObject9, (String)localObject10, (String)localObject11, (String)localObject12, (String)localObject13);
          if (localefe.NeZ != 1) {
            break label1091;
          }
          bool4 = true;
          if (localefe.Nfs != 1) {
            break label1097;
          }
          bool5 = true;
          localObject3 = localefe.Buffer;
          if (localObject3 == null) {
            break label1103;
          }
          localObject3 = ((com.tencent.mm.bw.b)localObject3).toByteArray();
          k = localefe.Nfy;
          localObject4 = localefe.Nfz;
          if (localObject4 == null) {
            break label1111;
          }
        }
        for (int i = ((eff)localObject4).MmV;; i = -1)
        {
          localObject4 = localefe.Nfz;
          if (localObject4 != null)
          {
            localObject5 = ((eff)localObject4).Mdz;
            localObject4 = localObject5;
            if (localObject5 != null) {}
          }
          else
          {
            localObject4 = "";
          }
          localObject5 = localefe.Nfz;
          if (localObject5 != null)
          {
            localObject6 = ((eff)localObject5).NfB;
            localObject5 = localObject6;
            if (localObject6 != null) {}
          }
          else
          {
            localObject5 = "";
          }
          localObject10 = new ShowInfo(i, (String)localObject4, (String)localObject5);
          localObject5 = localefe.Nfw;
          localObject4 = localObject5;
          if (localObject5 == null) {
            localObject4 = "";
          }
          localObject6 = localefe.Nfx;
          localObject5 = localObject6;
          if (localObject6 == null) {
            localObject5 = "";
          }
          i = localefe.Nft;
          localObject7 = localefe.Nfu;
          localObject6 = localObject7;
          if (localObject7 == null) {
            localObject6 = "";
          }
          boolean bool6 = localefe.Nfv;
          localObject8 = localefe.Nfi;
          localObject7 = localObject8;
          if (localObject8 == null) {
            localObject7 = "";
          }
          localc.a(paramInt1, paramInt2, (String)localObject1, new SubscribeMsgRequestResult(bool1, paramString, (String)localObject2, j, localArrayList, bool2, bool3, (WordingInfo)localObject9, bool4, bool5, (byte[])localObject3, k, (ShowInfo)localObject10, (String)localObject4, (String)localObject5, i, (String)localObject6, bool6, (String)localObject7));
          AppMethodBeat.o(174565);
          return;
          bool1 = false;
          break;
          bool2 = false;
          break label374;
          bool3 = false;
          break label386;
          bool4 = false;
          break label781;
          bool5 = false;
          break label793;
          localObject3 = new byte[0];
          break label812;
        }
        AppMethodBeat.o(174565);
        return;
      }
    }
  }
  
  public final void setAppId(String paramString)
  {
    AppMethodBeat.i(194265);
    p.h(paramString, "<set-?>");
    this.appId = paramString;
    AppMethodBeat.o(194265);
  }
  
  public final void setUsername(String paramString)
  {
    AppMethodBeat.i(194264);
    p.h(paramString, "<set-?>");
    this.username = paramString;
    AppMethodBeat.o(194264);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$Builder;", "", "()V", "Companion", "wxbiz-msgsubscription-sdk_release"})
  public static final class a
  {
    public static final a jzu;
    
    static
    {
      AppMethodBeat.i(149566);
      jzu = new a((byte)0);
      AppMethodBeat.o(149566);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$Builder$Companion;", "", "()V", "buildGetAllSubscribeStatusReq", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg;", "username", "", "callback", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$IOnNetSceneSubscribeEndCallback;", "buildGetSubscribeStatus", "appId", "subscribeUrl", "templateIds", "", "extInfo", "buildGetSubscribeStatusReq", "buildGetSubscribeUIStatusReq", "buildSubscribeReq", "templates", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "isOpened", "", "buildSubscribeReqForDialogRequest", "byteArray", "", "uIData", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "innerBuildSubscribeRequest", "action", "", "processExtInfo", "", "req", "wxbiz-msgsubscription-sdk_release"})
    public static final class a
    {
      public static b a(String paramString, b.c paramc)
      {
        AppMethodBeat.i(149564);
        p.h(paramString, "username");
        paramString = new b(paramString, 3);
        b.a(paramString, paramc);
        AppMethodBeat.o(149564);
        return paramString;
      }
      
      public static b a(String paramString1, String paramString2, String paramString3, List<String> paramList, String paramString4, b.c paramc)
      {
        AppMethodBeat.i(194260);
        p.h(paramString1, "username");
        p.h(paramString2, "appId");
        p.h(paramString3, "subscribeUrl");
        p.h(paramList, "templateIds");
        p.h(paramString4, "extInfo");
        paramString1 = new b(paramString1, paramString2, 2);
        a(paramString4, paramString1);
        b.a(paramString1, paramc);
        b.a(paramString1, paramString3);
        paramString2 = paramList.iterator();
        while (paramString2.hasNext())
        {
          paramString3 = (String)paramString2.next();
          paramList = b.a(paramString1);
          paramString4 = new efc();
          paramString4.Mqy = paramString3;
          paramList.add(paramString4);
        }
        AppMethodBeat.o(194260);
        return paramString1;
      }
      
      public static b a(String paramString1, String paramString2, List<SubscribeMsgTmpItem> paramList, String paramString3, b.c paramc, boolean paramBoolean, byte[] paramArrayOfByte, SubscribeMsgRequestDialogUiData paramSubscribeMsgRequestDialogUiData)
      {
        AppMethodBeat.i(194259);
        p.h(paramString1, "username");
        p.h(paramString2, "appId");
        p.h(paramList, "templates");
        p.h(paramString3, "extInfo");
        p.h(paramArrayOfByte, "byteArray");
        paramString1 = a(paramString1, paramString2, paramBoolean, paramc, paramList, 6, paramArrayOfByte, paramSubscribeMsgRequestDialogUiData, paramString3);
        AppMethodBeat.o(194259);
        return paramString1;
      }
      
      private static b a(String paramString1, String paramString2, boolean paramBoolean, b.c paramc, List<SubscribeMsgTmpItem> paramList, int paramInt, byte[] paramArrayOfByte, SubscribeMsgRequestDialogUiData paramSubscribeMsgRequestDialogUiData, String paramString3)
      {
        AppMethodBeat.i(194261);
        paramString1 = new b(paramString1, paramInt, paramBoolean);
        paramString1.setAppId(paramString2);
        b.a(paramString1, paramc);
        paramString1.au(paramArrayOfByte);
        b.a(paramString1, paramSubscribeMsgRequestDialogUiData);
        a(paramString3, paramString1);
        paramString2 = paramList.iterator();
        if (paramString2.hasNext())
        {
          paramc = (SubscribeMsgTmpItem)paramString2.next();
          paramList = b.a(paramString1);
          paramArrayOfByte = new efc();
          paramArrayOfByte.Mqy = paramc.ixM;
          paramArrayOfByte.NeU = paramc.jyz;
          paramArrayOfByte.NeY = paramc.jyB;
          if (paramc.VC) {}
          for (paramInt = 1;; paramInt = 0)
          {
            paramArrayOfByte.NeZ = paramInt;
            paramList.add(paramArrayOfByte);
            break;
          }
        }
        AppMethodBeat.o(194261);
        return paramString1;
      }
      
      private static void a(String paramString, b paramb)
      {
        AppMethodBeat.i(194263);
        int i;
        if (((CharSequence)paramString).length() > 0) {
          i = 1;
        }
        for (;;)
        {
          if (i != 0)
          {
            b.b(paramb, paramString);
            try
            {
              Object localObject = new JSONObject(paramString);
              b.a(paramb, ((JSONObject)localObject).optInt("scene"));
              String str = ((JSONObject)localObject).optString("sessionid");
              p.g(str, "ext.optString(\"sessionid\")");
              b.c(paramb, str);
              localObject = ((JSONObject)localObject).optString("username");
              p.g(localObject, "extUsername");
              if (((CharSequence)localObject).length() > 0) {}
              for (i = 1;; i = 0)
              {
                if (i != 0) {
                  paramb.setUsername((String)localObject);
                }
                Log.i("NetSceneSubscribeMsg", "alvinluo parseExtInfo scene: %s, sessionId: %s, username: %s, extInfo: %s", new Object[] { Integer.valueOf(b.b(paramb)), b.c(paramb), paramb.username, paramString });
                AppMethodBeat.o(194263);
                return;
                i = 0;
                break;
              }
              AppMethodBeat.o(194263);
            }
            catch (Exception paramString)
            {
              Log.printErrStackTrace("NetSceneSubscribeMsg", (Throwable)paramString, "parse extInfo exception", new Object[0]);
            }
          }
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$IOnNetSceneSubscribeEndCallback;", "", "onNetSceneEndCallback", "", "errType", "", "errCode", "errMsg", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "wxbiz-msgsubscription-sdk_release"})
  public static abstract interface c
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.a.b
 * JD-Core Version:    0.7.0.1
 */