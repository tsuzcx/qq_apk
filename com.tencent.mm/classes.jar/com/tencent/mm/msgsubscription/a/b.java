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
import com.tencent.mm.protocal.protobuf.cpf;
import com.tencent.mm.protocal.protobuf.dmw;
import com.tencent.mm.protocal.protobuf.dyl;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.protocal.protobuf.epd;
import com.tencent.mm.protocal.protobuf.epe;
import com.tencent.mm.protocal.protobuf.epf;
import com.tencent.mm.protocal.protobuf.epg;
import com.tencent.mm.protocal.protobuf.eph;
import com.tencent.mm.protocal.protobuf.epi;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg;", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase;", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IOnSceneEnd;", "username", "", "actionType", "", "(Ljava/lang/String;I)V", "isOpened", "", "(Ljava/lang/String;IZ)V", "appId", "(Ljava/lang/String;Ljava/lang/String;I)V", "getActionType", "()I", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "byteArray", "", "getByteArray", "()[B", "setByteArray", "([B)V", "extInfo", "itemList", "", "Lcom/tencent/mm/protocal/protobuf/SubscribeMsgItem;", "mSubscribeEndCallback", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$IOnNetSceneSubscribeEndCallback;", "popupScene", "rr", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IReqResp;", "sessionId", "subscribeUrl", "uIData", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "getUsername", "setUsername", "doScene", "dispatcher", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IDispatcher;", "getCallback", "getReq", "Lcom/tencent/mm/protocal/protobuf/SubscribeMsgReq;", "getResp", "Lcom/tencent/mm/protocal/protobuf/SubscribeMsgResp;", "getType", "onSceneEnd", "", "errType", "errCode", "errMsg", "scene", "setCallback", "callback", "Builder", "Companion", "IOnNetSceneSubscribeEndCallback", "wxbiz-msgsubscription-sdk_release"})
public final class b
  extends a
  implements a.b
{
  public static final b.b moZ;
  private final int actionType;
  private String appId;
  private String extInfo;
  private boolean mnS;
  private final List<epd> moS;
  private a.c moT;
  public c moU;
  private String moV;
  private SubscribeMsgRequestDialogUiData moW;
  private int moX;
  private byte[] moY;
  private String sessionId;
  public String username;
  
  static
  {
    AppMethodBeat.i(149573);
    moZ = new b.b((byte)0);
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
    this.mnS = paramBoolean;
    AppMethodBeat.o(149572);
  }
  
  public b(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(263638);
    this.username = paramString1;
    this.appId = paramString2;
    this.actionType = paramInt;
    this.moS = ((List)new ArrayList());
    this.moV = "";
    this.sessionId = "";
    this.extInfo = "";
    this.moY = new byte[0];
    AppMethodBeat.o(263638);
  }
  
  public final int a(a.a parama)
  {
    int i = 1;
    AppMethodBeat.i(174564);
    p.k(parama, "dispatcher");
    Object localObject1 = a.c.mtq;
    this.moT = a.c.a.a((dyl)new epe(), (dyy)new epf(), "/cgi-bin/mmbiz-bin/bizattr/subscribemsg");
    localObject1 = this.moT;
    if (localObject1 == null) {
      p.iCn();
    }
    localObject1 = ((a.c)localObject1).bsI();
    if (localObject1 == null)
    {
      parama = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.SubscribeMsgReq");
      AppMethodBeat.o(174564);
      throw parama;
    }
    localObject1 = (epe)localObject1;
    ((epe)localObject1).UrK = this.moX;
    ((epe)localObject1).SessionId = this.sessionId;
    ((epe)localObject1).UrL = this.extInfo;
    switch (this.actionType)
    {
    }
    label303:
    do
    {
      do
      {
        localObject1 = this.moT;
        if (localObject1 == null) {
          p.iCn();
        }
        i = parama.a((a.c)localObject1, (a.b)this, (a)this);
        AppMethodBeat.o(174564);
        return i;
        ((epe)localObject1).RTS = this.username;
        ((epe)localObject1).lVG = this.appId;
        ((epe)localObject1).RXp = this.actionType;
        ((epe)localObject1).COK.addAll((Collection)this.moS);
        if (((CharSequence)this.moV).length() > 0) {}
        while (i != 0)
        {
          ((epe)localObject1).UrI = this.moV;
          break;
          i = 0;
        }
        ((epe)localObject1).RTS = this.username;
        ((epe)localObject1).lVG = this.appId;
        ((epe)localObject1).RXp = this.actionType;
        ((epe)localObject1).RUc = 1;
        if (!this.mnS) {
          break;
        }
        i = 1;
        ((epe)localObject1).Urz = i;
        ((epe)localObject1).COK.addAll((Collection)this.moS);
      } while (this.actionType != 6);
      ((epe)localObject1).Tkb = new com.tencent.mm.cd.b(this.moY);
      ((epe)localObject1).UrJ = new dmw();
      localObject2 = this.moW;
    } while (localObject2 == null);
    ((epe)localObject1).UrJ.TUd = ((SubscribeMsgRequestDialogUiData)localObject2).mnx;
    ((epe)localObject1).UrJ.jUk = ((SubscribeMsgRequestDialogUiData)localObject2).opType;
    Object localObject2 = ((SubscribeMsgRequestDialogUiData)localObject2).mny.iterator();
    label403:
    LinkedList localLinkedList;
    eph localeph;
    if (((Iterator)localObject2).hasNext())
    {
      SubscribeMsgRequestDialogUiData.ItemUiData localItemUiData = (SubscribeMsgRequestDialogUiData.ItemUiData)((Iterator)localObject2).next();
      localLinkedList = ((epe)localObject1).UrJ.TUe;
      localeph = new eph();
      localeph.TBB = localItemUiData.lnb;
      localeph.Urx = localItemUiData.mnG;
      if (!localItemUiData.mnH) {
        break label495;
      }
    }
    label495:
    for (i = 1;; i = 0)
    {
      localeph.UrF = i;
      localLinkedList.add(localeph);
      break label403;
      break;
      i = 0;
      break label303;
    }
  }
  
  public final void aF(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(149567);
    p.k(paramArrayOfByte, "<set-?>");
    this.moY = paramArrayOfByte;
    AppMethodBeat.o(149567);
  }
  
  public final void k(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(174565);
    Object localObject2;
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      localObject2 = this.moU;
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
    Object localObject1 = this.moT;
    if (localObject1 == null) {
      p.iCn();
    }
    localObject1 = ((a.c)localObject1).bsJ();
    if (localObject1 == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.SubscribeMsgResp");
      AppMethodBeat.o(174565);
      throw paramString;
    }
    epf localepf = (epf)localObject1;
    c localc = this.moU;
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
      paramString = SubscribeMsgRequestResult.mob;
      p.k(localepf, "response");
      localArrayList = new ArrayList();
      paramString = localepf.CNn;
      p.j(paramString, "response.InfoList");
      paramString = ((Iterable)paramString).iterator();
      while (paramString.hasNext())
      {
        localObject2 = (epd)paramString.next();
        localObject3 = new ArrayList();
        localObject4 = ((epd)localObject2).Sar;
        p.j(localObject4, "it.KeyWordList");
        localObject4 = ((Iterable)localObject4).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (cpf)((Iterator)localObject4).next();
          ((ArrayList)localObject3).add(new o(((cpf)localObject5).CMP, ((cpf)localObject5).Izj));
        }
        p.j(localObject2, "it");
        localArrayList.add(new SubscribeMsgTmpItem((epd)localObject2, (ArrayList)localObject3));
      }
      if (localepf.UrQ == 1)
      {
        bool1 = true;
        paramString = localepf.UrO;
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
      localObject2 = localepf.UrN;
      if (localObject2 == null) {
        localObject2 = "";
      }
      for (;;)
      {
        int j = localepf.UrR;
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
        if (localepf.UrP == 1)
        {
          bool2 = true;
          if (localepf.Usd != 1) {
            break label1085;
          }
          bool3 = true;
          localObject3 = localepf.UrM;
          if (localObject3 != null)
          {
            localObject4 = ((epi)localObject3).mon;
            localObject3 = localObject4;
            if (localObject4 != null) {}
          }
          else
          {
            localObject3 = "";
          }
          localObject4 = localepf.UrM;
          if (localObject4 != null)
          {
            localObject5 = ((epi)localObject4).moo;
            localObject4 = localObject5;
            if (localObject5 != null) {}
          }
          else
          {
            localObject4 = "";
          }
          localObject5 = localepf.UrM;
          if (localObject5 != null)
          {
            localObject6 = ((epi)localObject5).mop;
            localObject5 = localObject6;
            if (localObject6 != null) {}
          }
          else
          {
            localObject5 = "";
          }
          localObject6 = localepf.UrM;
          if (localObject6 != null)
          {
            localObject7 = ((epi)localObject6).moq;
            localObject6 = localObject7;
            if (localObject7 != null) {}
          }
          else
          {
            localObject6 = "";
          }
          localObject7 = localepf.UrM;
          if (localObject7 != null)
          {
            localObject8 = ((epi)localObject7).mor;
            localObject7 = localObject8;
            if (localObject8 != null) {}
          }
          else
          {
            localObject7 = "";
          }
          localObject8 = localepf.UrM;
          if (localObject8 != null)
          {
            localObject9 = ((epi)localObject8).mos;
            localObject8 = localObject9;
            if (localObject9 != null) {}
          }
          else
          {
            localObject8 = "";
          }
          localObject9 = localepf.UrM;
          if (localObject9 != null)
          {
            localObject10 = ((epi)localObject9).mot;
            localObject9 = localObject10;
            if (localObject10 != null) {}
          }
          else
          {
            localObject9 = "";
          }
          localObject10 = localepf.UrM;
          if (localObject10 != null)
          {
            localObject11 = ((epi)localObject10).mou;
            localObject10 = localObject11;
            if (localObject11 != null) {}
          }
          else
          {
            localObject10 = "";
          }
          Object localObject11 = localepf.UrM;
          if (localObject11 != null)
          {
            localObject12 = ((epi)localObject11).mov;
            localObject11 = localObject12;
            if (localObject12 != null) {}
          }
          else
          {
            localObject11 = "";
          }
          Object localObject12 = localepf.UrM;
          if (localObject12 != null)
          {
            localObject13 = ((epi)localObject12).mow;
            localObject12 = localObject13;
            if (localObject13 != null) {}
          }
          else
          {
            localObject12 = "";
          }
          Object localObject13 = localepf.UrM;
          if (localObject13 != null)
          {
            String str = ((epi)localObject13).mox;
            localObject13 = str;
            if (str != null) {}
          }
          else
          {
            localObject13 = "";
          }
          localObject9 = new WordingInfo((String)localObject3, (String)localObject4, (String)localObject5, (String)localObject6, (String)localObject7, (String)localObject8, (String)localObject9, (String)localObject10, (String)localObject11, (String)localObject12, (String)localObject13);
          if (localepf.Urz != 1) {
            break label1091;
          }
          bool4 = true;
          if (localepf.UrV != 1) {
            break label1097;
          }
          bool5 = true;
          localObject3 = localepf.Tkb;
          if (localObject3 == null) {
            break label1103;
          }
          localObject3 = ((com.tencent.mm.cd.b)localObject3).toByteArray();
          k = localepf.Usb;
          localObject4 = localepf.Usc;
          if (localObject4 == null) {
            break label1111;
          }
        }
        for (int i = ((epg)localObject4).TxQ;; i = -1)
        {
          localObject4 = localepf.Usc;
          if (localObject4 != null)
          {
            localObject5 = ((epg)localObject4).Tna;
            localObject4 = localObject5;
            if (localObject5 != null) {}
          }
          else
          {
            localObject4 = "";
          }
          localObject5 = localepf.Usc;
          if (localObject5 != null)
          {
            localObject6 = ((epg)localObject5).Use;
            localObject5 = localObject6;
            if (localObject6 != null) {}
          }
          else
          {
            localObject5 = "";
          }
          localObject10 = new ShowInfo(i, (String)localObject4, (String)localObject5);
          localObject5 = localepf.UrZ;
          localObject4 = localObject5;
          if (localObject5 == null) {
            localObject4 = "";
          }
          localObject6 = localepf.Usa;
          localObject5 = localObject6;
          if (localObject6 == null) {
            localObject5 = "";
          }
          i = localepf.UrW;
          localObject7 = localepf.UrX;
          localObject6 = localObject7;
          if (localObject7 == null) {
            localObject6 = "";
          }
          boolean bool6 = localepf.UrY;
          localObject8 = localepf.UrL;
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
    AppMethodBeat.i(263637);
    p.k(paramString, "<set-?>");
    this.appId = paramString;
    AppMethodBeat.o(263637);
  }
  
  public final void setUsername(String paramString)
  {
    AppMethodBeat.i(263636);
    p.k(paramString, "<set-?>");
    this.username = paramString;
    AppMethodBeat.o(263636);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$Builder;", "", "()V", "Companion", "wxbiz-msgsubscription-sdk_release"})
  public static final class a
  {
    public static final a mpa;
    
    static
    {
      AppMethodBeat.i(149566);
      mpa = new a((byte)0);
      AppMethodBeat.o(149566);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$Builder$Companion;", "", "()V", "buildGetAllSubscribeStatusReq", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg;", "username", "", "callback", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$IOnNetSceneSubscribeEndCallback;", "buildGetSubscribeStatus", "appId", "subscribeUrl", "templateIds", "", "extInfo", "buildGetSubscribeStatusReq", "buildGetSubscribeUIStatusReq", "buildSubscribeReq", "templates", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "isOpened", "", "buildSubscribeReqForDialogRequest", "byteArray", "", "uIData", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "innerBuildSubscribeRequest", "action", "", "processExtInfo", "", "req", "wxbiz-msgsubscription-sdk_release"})
    public static final class a
    {
      public static b a(String paramString, b.c paramc)
      {
        AppMethodBeat.i(149564);
        p.k(paramString, "username");
        paramString = new b(paramString, 3);
        b.a(paramString, paramc);
        AppMethodBeat.o(149564);
        return paramString;
      }
      
      public static b a(String paramString1, String paramString2, String paramString3, List<String> paramList, String paramString4, b.c paramc)
      {
        AppMethodBeat.i(263584);
        p.k(paramString1, "username");
        p.k(paramString2, "appId");
        p.k(paramString3, "subscribeUrl");
        p.k(paramList, "templateIds");
        p.k(paramString4, "extInfo");
        paramString1 = new b(paramString1, paramString2, 2);
        a(paramString4, paramString1);
        b.a(paramString1, paramc);
        b.a(paramString1, paramString3);
        paramString2 = paramList.iterator();
        while (paramString2.hasNext())
        {
          paramString3 = (String)paramString2.next();
          paramList = b.a(paramString1);
          paramString4 = new epd();
          paramString4.TBB = paramString3;
          paramList.add(paramString4);
        }
        AppMethodBeat.o(263584);
        return paramString1;
      }
      
      public static b a(String paramString1, String paramString2, List<SubscribeMsgTmpItem> paramList, String paramString3, b.c paramc, boolean paramBoolean, byte[] paramArrayOfByte, SubscribeMsgRequestDialogUiData paramSubscribeMsgRequestDialogUiData)
      {
        AppMethodBeat.i(263582);
        p.k(paramString1, "username");
        p.k(paramString2, "appId");
        p.k(paramList, "templates");
        p.k(paramString3, "extInfo");
        p.k(paramArrayOfByte, "byteArray");
        paramString1 = a(paramString1, paramString2, paramBoolean, paramc, paramList, 6, paramArrayOfByte, paramSubscribeMsgRequestDialogUiData, paramString3);
        AppMethodBeat.o(263582);
        return paramString1;
      }
      
      private static b a(String paramString1, String paramString2, boolean paramBoolean, b.c paramc, List<SubscribeMsgTmpItem> paramList, int paramInt, byte[] paramArrayOfByte, SubscribeMsgRequestDialogUiData paramSubscribeMsgRequestDialogUiData, String paramString3)
      {
        AppMethodBeat.i(263585);
        paramString1 = new b(paramString1, paramInt, paramBoolean);
        paramString1.setAppId(paramString2);
        b.a(paramString1, paramc);
        paramString1.aF(paramArrayOfByte);
        b.a(paramString1, paramSubscribeMsgRequestDialogUiData);
        a(paramString3, paramString1);
        paramString2 = paramList.iterator();
        if (paramString2.hasNext())
        {
          paramc = (SubscribeMsgTmpItem)paramString2.next();
          paramList = b.a(paramString1);
          paramArrayOfByte = new epd();
          paramArrayOfByte.TBB = paramc.lnb;
          paramArrayOfByte.Uru = paramc.mod;
          paramArrayOfByte.Ury = paramc.mof;
          if (paramc.mnH)
          {
            paramInt = 1;
            label124:
            paramArrayOfByte.UrF = paramInt;
            if (!paramc.gZ) {
              break label167;
            }
          }
          label167:
          for (paramInt = 1;; paramInt = 0)
          {
            paramArrayOfByte.Urz = paramInt;
            paramList.add(paramArrayOfByte);
            break;
            paramInt = 0;
            break label124;
          }
        }
        AppMethodBeat.o(263585);
        return paramString1;
      }
      
      private static void a(String paramString, b paramb)
      {
        AppMethodBeat.i(263587);
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
              p.j(str, "ext.optString(\"sessionid\")");
              b.c(paramb, str);
              localObject = ((JSONObject)localObject).optString("username");
              p.j(localObject, "extUsername");
              if (((CharSequence)localObject).length() > 0) {}
              for (i = 1;; i = 0)
              {
                if (i != 0) {
                  paramb.setUsername((String)localObject);
                }
                Log.i("NetSceneSubscribeMsg", "alvinluo parseExtInfo scene: %s, sessionId: %s, username: %s, extInfo: %s", new Object[] { Integer.valueOf(b.b(paramb)), b.c(paramb), paramb.username, paramString });
                AppMethodBeat.o(263587);
                return;
                i = 0;
                break;
              }
              AppMethodBeat.o(263587);
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$IOnNetSceneSubscribeEndCallback;", "", "onNetSceneEndCallback", "", "errType", "", "errCode", "errMsg", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "wxbiz-msgsubscription-sdk_release"})
  public static abstract interface c
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.a.b
 * JD-Core Version:    0.7.0.1
 */