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
import com.tencent.mm.protocal.protobuf.dfz;
import com.tencent.mm.protocal.protobuf.efk;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.fkc;
import com.tencent.mm.protocal.protobuf.fkd;
import com.tencent.mm.protocal.protobuf.fke;
import com.tencent.mm.protocal.protobuf.fkf;
import com.tencent.mm.protocal.protobuf.fkg;
import com.tencent.mm.protocal.protobuf.fkh;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.r;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg;", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase;", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IOnSceneEnd;", "username", "", "actionType", "", "(Ljava/lang/String;I)V", "isOpened", "", "(Ljava/lang/String;IZ)V", "appId", "(Ljava/lang/String;Ljava/lang/String;I)V", "getActionType", "()I", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "byteArray", "", "getByteArray", "()[B", "setByteArray", "([B)V", "extInfo", "itemList", "", "Lcom/tencent/mm/protocal/protobuf/SubscribeMsgItem;", "mSubscribeEndCallback", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$IOnNetSceneSubscribeEndCallback;", "popupScene", "rr", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IReqResp;", "sessionId", "subscribeUrl", "uIData", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "getUsername", "setUsername", "doScene", "dispatcher", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IDispatcher;", "getCallback", "getReq", "Lcom/tencent/mm/protocal/protobuf/SubscribeMsgReq;", "getResp", "Lcom/tencent/mm/protocal/protobuf/SubscribeMsgResp;", "getType", "onSceneEnd", "", "errType", "errCode", "errMsg", "scene", "setCallback", "callback", "Builder", "Companion", "IOnNetSceneSubscribeEndCallback", "wxbiz-msgsubscription-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends a
  implements a.b
{
  public static final b.b piG;
  private final int actionType;
  private String appId;
  private String extInfo;
  private boolean phG;
  private final List<fkc> piH;
  private a.c piI;
  public c piJ;
  private String piK;
  private SubscribeMsgRequestDialogUiData piL;
  private int piM;
  private byte[] piN;
  private String sessionId;
  public String username;
  
  static
  {
    AppMethodBeat.i(149573);
    piG = new b.b((byte)0);
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
    this.phG = paramBoolean;
    AppMethodBeat.o(149572);
  }
  
  public b(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(236503);
    this.username = paramString1;
    this.appId = paramString2;
    this.actionType = paramInt;
    this.piH = ((List)new ArrayList());
    this.piK = "";
    this.sessionId = "";
    this.extInfo = "";
    this.piN = new byte[0];
    AppMethodBeat.o(236503);
  }
  
  public final int a(a.a parama)
  {
    int i = 1;
    AppMethodBeat.i(174564);
    s.u(parama, "dispatcher");
    Object localObject1 = a.c.pmL;
    this.piI = a.c.a.a((erp)new fkd(), (esc)new fke(), "/cgi-bin/mmbiz-bin/bizattr/subscribemsg");
    localObject1 = this.piI;
    s.checkNotNull(localObject1);
    localObject1 = (fkd)((a.c)localObject1).bQp();
    ((fkd)localObject1).abKN = this.piM;
    ((fkd)localObject1).SessionId = this.sessionId;
    ((fkd)localObject1).abKO = this.extInfo;
    switch (this.actionType)
    {
    }
    label276:
    do
    {
      do
      {
        localObject1 = this.piI;
        s.checkNotNull(localObject1);
        i = parama.a((a.c)localObject1, (a.b)this, (a)this);
        AppMethodBeat.o(174564);
        return i;
        ((fkd)localObject1).YRs = this.username;
        ((fkd)localObject1).oOI = this.appId;
        ((fkd)localObject1).YVh = this.actionType;
        ((fkd)localObject1).IIU.addAll((Collection)this.piH);
        if (((CharSequence)this.piK).length() > 0) {}
        while (i != 0)
        {
          ((fkd)localObject1).abKL = this.piK;
          break;
          i = 0;
        }
        ((fkd)localObject1).YRs = this.username;
        ((fkd)localObject1).oOI = this.appId;
        ((fkd)localObject1).YVh = this.actionType;
        ((fkd)localObject1).YRD = 1;
        if (!this.phG) {
          break;
        }
        i = 1;
        ((fkd)localObject1).abKz = i;
        ((fkd)localObject1).IIU.addAll((Collection)this.piH);
      } while (this.actionType != 6);
      ((fkd)localObject1).aaxD = new com.tencent.mm.bx.b(this.piN);
      ((fkd)localObject1).abKM = new efk();
      localObject2 = this.piL;
    } while (localObject2 == null);
    ((fkd)localObject1).abKM.abkN = ((SubscribeMsgRequestDialogUiData)localObject2).phk;
    ((fkd)localObject1).abKM.muC = ((SubscribeMsgRequestDialogUiData)localObject2).opType;
    Object localObject2 = ((SubscribeMsgRequestDialogUiData)localObject2).phl.iterator();
    label376:
    Object localObject3;
    LinkedList localLinkedList;
    fkg localfkg;
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = (SubscribeMsgRequestDialogUiData.ItemUiData)((Iterator)localObject2).next();
      localLinkedList = ((fkd)localObject1).abKM.abkO;
      localfkg = new fkg();
      localfkg.aaQP = ((SubscribeMsgRequestDialogUiData.ItemUiData)localObject3).nSg;
      localfkg.abKx = ((SubscribeMsgRequestDialogUiData.ItemUiData)localObject3).pht;
      if (!((SubscribeMsgRequestDialogUiData.ItemUiData)localObject3).phu) {
        break label489;
      }
      i = 1;
      label446:
      localfkg.abKF = i;
      if (!((SubscribeMsgRequestDialogUiData.ItemUiData)localObject3).phv) {
        break label494;
      }
    }
    label489:
    label494:
    for (i = 1;; i = 0)
    {
      localfkg.abKI = i;
      localObject3 = ah.aiuX;
      localLinkedList.add(localfkg);
      break label376;
      break;
      i = 0;
      break label276;
      i = 0;
      break label446;
    }
  }
  
  public final void aF(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(149567);
    s.u(paramArrayOfByte, "<set-?>");
    this.piN = paramArrayOfByte;
    AppMethodBeat.o(149567);
  }
  
  public final void l(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(174565);
    Object localObject2;
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      localObject2 = this.piJ;
      if (localObject2 != null)
      {
        localObject1 = paramString;
        if (paramString == null) {
          localObject1 = "";
        }
        ((c)localObject2).a(paramInt1, paramInt2, (String)localObject1, null);
      }
      AppMethodBeat.o(174565);
      return;
    }
    Object localObject1 = this.piI;
    s.checkNotNull(localObject1);
    fke localfke = (fke)((a.c)localObject1).bQq();
    c localc = this.piJ;
    String str1;
    ArrayList localArrayList;
    Object localObject3;
    Object localObject4;
    boolean bool1;
    String str2;
    label304:
    String str3;
    label320:
    int j;
    boolean bool2;
    label339:
    boolean bool3;
    label351:
    label364:
    label380:
    Object localObject5;
    label396:
    label412:
    label428:
    label444:
    Object localObject6;
    label460:
    Object localObject7;
    label476:
    Object localObject8;
    label492:
    Object localObject9;
    label508:
    Object localObject10;
    label524:
    boolean bool4;
    label566:
    boolean bool5;
    label578:
    label590:
    int k;
    int i;
    if (localc != null)
    {
      str1 = paramString;
      if (paramString == null) {
        str1 = "";
      }
      paramString = SubscribeMsgRequestResult.phy;
      s.u(localfke, "response");
      localArrayList = new ArrayList();
      paramString = localfke.IHs;
      s.s(paramString, "response.InfoList");
      paramString = ((Iterable)paramString).iterator();
      while (paramString.hasNext())
      {
        localObject1 = (fkc)paramString.next();
        localObject2 = new ArrayList();
        localObject3 = ((fkc)localObject1).YYq;
        s.s(localObject3, "it.KeyWordList");
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (dfz)((Iterator)localObject3).next();
          ((ArrayList)localObject2).add(new r(((dfz)localObject4).IGU, ((dfz)localObject4).OzQ));
        }
        s.s(localObject1, "it");
        localArrayList.add(new SubscribeMsgTmpItem((fkc)localObject1, (ArrayList)localObject2));
      }
      if (localfke.abKT != 1) {
        break label819;
      }
      bool1 = true;
      str2 = localfke.abKR;
      if (str2 != null) {
        break label825;
      }
      str2 = "";
      str3 = localfke.abKQ;
      if (str3 != null) {
        break label828;
      }
      str3 = "";
      j = localfke.abKU;
      if (localfke.abKS != 1) {
        break label831;
      }
      bool2 = true;
      if (localfke.abLg != 1) {
        break label837;
      }
      bool3 = true;
      paramString = localfke.abKP;
      if (paramString != null) {
        break label843;
      }
      paramString = "";
      localObject1 = localfke.abKP;
      if (localObject1 != null) {
        break label863;
      }
      localObject1 = "";
      localObject2 = localfke.abKP;
      if (localObject2 != null) {
        break label886;
      }
      localObject2 = "";
      localObject3 = localfke.abKP;
      if (localObject3 != null) {
        break label909;
      }
      localObject3 = "";
      localObject4 = localfke.abKP;
      if (localObject4 != null) {
        break label932;
      }
      localObject4 = "";
      localObject5 = localfke.abKP;
      if (localObject5 != null) {
        break label955;
      }
      localObject5 = "";
      localObject6 = localfke.abKP;
      if (localObject6 != null) {
        break label978;
      }
      localObject6 = "";
      localObject7 = localfke.abKP;
      if (localObject7 != null) {
        break label1001;
      }
      localObject7 = "";
      localObject8 = localfke.abKP;
      if (localObject8 != null) {
        break label1024;
      }
      localObject8 = "";
      localObject9 = localfke.abKP;
      if (localObject9 != null) {
        break label1047;
      }
      localObject9 = "";
      localObject10 = localfke.abKP;
      if (localObject10 != null) {
        break label1070;
      }
      localObject10 = "";
      localObject6 = new WordingInfo(paramString, (String)localObject1, (String)localObject2, (String)localObject3, (String)localObject4, (String)localObject5, (String)localObject6, (String)localObject7, (String)localObject8, (String)localObject9, (String)localObject10);
      if (localfke.abKz != 1) {
        break label1093;
      }
      bool4 = true;
      if (localfke.abKY != 1) {
        break label1099;
      }
      bool5 = true;
      paramString = localfke.aaxD;
      if (paramString != null) {
        break label1105;
      }
      paramString = null;
      localObject2 = paramString;
      if (paramString == null) {
        localObject2 = new byte[0];
      }
      k = localfke.abLe;
      paramString = localfke.abLf;
      if (paramString != null) {
        break label1113;
      }
      i = -1;
      label622:
      paramString = localfke.abLf;
      if (paramString != null) {
        break label1122;
      }
      paramString = "";
      label635:
      localObject1 = localfke.abLf;
      if (localObject1 != null) {
        break label1142;
      }
      localObject1 = "";
    }
    for (;;)
    {
      localObject7 = new ShowInfo(i, paramString, (String)localObject1);
      localObject1 = localfke.abLc;
      paramString = (String)localObject1;
      if (localObject1 == null) {
        paramString = "";
      }
      localObject3 = localfke.abLd;
      localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = "";
      }
      i = localfke.abKZ;
      localObject4 = localfke.abLa;
      localObject3 = localObject4;
      if (localObject4 == null) {
        localObject3 = "";
      }
      boolean bool6 = localfke.abLb;
      localObject5 = localfke.abKO;
      localObject4 = localObject5;
      if (localObject5 == null) {
        localObject4 = "";
      }
      localc.a(paramInt1, paramInt2, str1, new SubscribeMsgRequestResult(bool1, str2, str3, j, localArrayList, bool2, bool3, (WordingInfo)localObject6, bool4, bool5, (byte[])localObject2, k, (ShowInfo)localObject7, paramString, (String)localObject1, i, (String)localObject3, bool6, (String)localObject4));
      AppMethodBeat.o(174565);
      return;
      label819:
      bool1 = false;
      break;
      label825:
      break label304;
      label828:
      break label320;
      label831:
      bool2 = false;
      break label339;
      label837:
      bool3 = false;
      break label351;
      label843:
      localObject1 = paramString.pie;
      paramString = (String)localObject1;
      if (localObject1 != null) {
        break label364;
      }
      paramString = "";
      break label364;
      label863:
      localObject2 = ((fkh)localObject1).pif;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label380;
      }
      localObject1 = "";
      break label380;
      label886:
      localObject3 = ((fkh)localObject2).pig;
      localObject2 = localObject3;
      if (localObject3 != null) {
        break label396;
      }
      localObject2 = "";
      break label396;
      label909:
      localObject4 = ((fkh)localObject3).pih;
      localObject3 = localObject4;
      if (localObject4 != null) {
        break label412;
      }
      localObject3 = "";
      break label412;
      label932:
      localObject5 = ((fkh)localObject4).pii;
      localObject4 = localObject5;
      if (localObject5 != null) {
        break label428;
      }
      localObject4 = "";
      break label428;
      label955:
      localObject6 = ((fkh)localObject5).pij;
      localObject5 = localObject6;
      if (localObject6 != null) {
        break label444;
      }
      localObject5 = "";
      break label444;
      label978:
      localObject7 = ((fkh)localObject6).pik;
      localObject6 = localObject7;
      if (localObject7 != null) {
        break label460;
      }
      localObject6 = "";
      break label460;
      label1001:
      localObject8 = ((fkh)localObject7).pil;
      localObject7 = localObject8;
      if (localObject8 != null) {
        break label476;
      }
      localObject7 = "";
      break label476;
      label1024:
      localObject9 = ((fkh)localObject8).pim;
      localObject8 = localObject9;
      if (localObject9 != null) {
        break label492;
      }
      localObject8 = "";
      break label492;
      label1047:
      localObject10 = ((fkh)localObject9).pio;
      localObject9 = localObject10;
      if (localObject10 != null) {
        break label508;
      }
      localObject9 = "";
      break label508;
      label1070:
      String str4 = ((fkh)localObject10).pip;
      localObject10 = str4;
      if (str4 != null) {
        break label524;
      }
      localObject10 = "";
      break label524;
      label1093:
      bool4 = false;
      break label566;
      label1099:
      bool5 = false;
      break label578;
      label1105:
      paramString = paramString.toByteArray();
      break label590;
      label1113:
      i = paramString.aaMx;
      break label622;
      label1122:
      localObject1 = paramString.aaBg;
      paramString = (String)localObject1;
      if (localObject1 != null) {
        break label635;
      }
      paramString = "";
      break label635;
      label1142:
      localObject3 = ((fkf)localObject1).abLh;
      localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = "";
      }
    }
  }
  
  public final void setAppId(String paramString)
  {
    AppMethodBeat.i(236559);
    s.u(paramString, "<set-?>");
    this.appId = paramString;
    AppMethodBeat.o(236559);
  }
  
  public final void setUsername(String paramString)
  {
    AppMethodBeat.i(236556);
    s.u(paramString, "<set-?>");
    this.username = paramString;
    AppMethodBeat.o(236556);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$Builder;", "", "()V", "Companion", "wxbiz-msgsubscription-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static final a piO;
    
    static
    {
      AppMethodBeat.i(149566);
      piO = new a((byte)0);
      AppMethodBeat.o(149566);
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$Builder$Companion;", "", "()V", "buildGetAllSubscribeStatusReq", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg;", "username", "", "callback", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$IOnNetSceneSubscribeEndCallback;", "buildGetSubscribeStatus", "appId", "subscribeUrl", "templateIds", "", "extInfo", "buildGetSubscribeStatusReq", "buildGetSubscribeUIStatusReq", "buildSubscribeReq", "templates", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "isOpened", "", "buildSubscribeReqForDialogRequest", "byteArray", "", "uIData", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "innerBuildSubscribeRequest", "action", "", "processExtInfo", "", "req", "wxbiz-msgsubscription-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
    {
      public static b a(String paramString, b.c paramc)
      {
        AppMethodBeat.i(149564);
        s.u(paramString, "username");
        paramString = new b(paramString, 3);
        b.a(paramString, paramc);
        AppMethodBeat.o(149564);
        return paramString;
      }
      
      public static b a(String paramString1, String paramString2, String paramString3, List<String> paramList, String paramString4, b.c paramc)
      {
        AppMethodBeat.i(236506);
        s.u(paramString1, "username");
        s.u(paramString2, "appId");
        s.u(paramString3, "subscribeUrl");
        s.u(paramList, "templateIds");
        s.u(paramString4, "extInfo");
        paramString1 = new b(paramString1, paramString2, 2);
        a(paramString4, paramString1);
        b.a(paramString1, paramc);
        b.a(paramString1, paramString3);
        paramString2 = paramList.iterator();
        while (paramString2.hasNext())
        {
          paramString4 = (String)paramString2.next();
          paramString3 = b.a(paramString1);
          paramList = new fkc();
          paramList.aaQP = paramString4;
          paramString4 = ah.aiuX;
          paramString3.add(paramList);
        }
        AppMethodBeat.o(236506);
        return paramString1;
      }
      
      public static b a(String paramString1, String paramString2, List<SubscribeMsgTmpItem> paramList, String paramString3, b.c paramc, boolean paramBoolean, byte[] paramArrayOfByte, SubscribeMsgRequestDialogUiData paramSubscribeMsgRequestDialogUiData)
      {
        AppMethodBeat.i(236502);
        s.u(paramString1, "username");
        s.u(paramString2, "appId");
        s.u(paramList, "templates");
        s.u(paramString3, "extInfo");
        s.u(paramArrayOfByte, "byteArray");
        paramString1 = a(paramString1, paramString2, paramBoolean, paramc, paramList, 6, paramArrayOfByte, paramSubscribeMsgRequestDialogUiData, paramString3);
        AppMethodBeat.o(236502);
        return paramString1;
      }
      
      private static b a(String paramString1, String paramString2, boolean paramBoolean, b.c paramc, List<SubscribeMsgTmpItem> paramList, int paramInt, byte[] paramArrayOfByte, SubscribeMsgRequestDialogUiData paramSubscribeMsgRequestDialogUiData, String paramString3)
      {
        AppMethodBeat.i(236517);
        paramString1 = new b(paramString1, paramInt, paramBoolean);
        paramString1.setAppId(paramString2);
        b.a(paramString1, paramc);
        paramString1.aF(paramArrayOfByte);
        b.a(paramString1, paramSubscribeMsgRequestDialogUiData);
        a(paramString3, paramString1);
        paramString2 = paramList.iterator();
        if (paramString2.hasNext())
        {
          paramArrayOfByte = (SubscribeMsgTmpItem)paramString2.next();
          paramc = b.a(paramString1);
          paramList = new fkc();
          paramList.aaQP = paramArrayOfByte.nSg;
          paramList.abKu = paramArrayOfByte.phR;
          paramList.abKy = paramArrayOfByte.phT;
          if (paramArrayOfByte.phu)
          {
            paramInt = 1;
            label128:
            paramList.abKF = paramInt;
            if (!paramArrayOfByte.pib) {
              break label194;
            }
            paramInt = 1;
            label146:
            paramList.abKI = paramInt;
            if (!paramArrayOfByte.hU) {
              break label200;
            }
          }
          label194:
          label200:
          for (paramInt = 1;; paramInt = 0)
          {
            paramList.abKz = paramInt;
            paramArrayOfByte = ah.aiuX;
            paramc.add(paramList);
            break;
            paramInt = 0;
            break label128;
            paramInt = 0;
            break label146;
          }
        }
        AppMethodBeat.o(236517);
        return paramString1;
      }
      
      private static void a(String paramString, b paramb)
      {
        AppMethodBeat.i(236528);
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
              s.s(str, "ext.optString(\"sessionid\")");
              b.c(paramb, str);
              localObject = ((JSONObject)localObject).optString("username");
              s.s(localObject, "extUsername");
              if (((CharSequence)localObject).length() > 0) {}
              for (i = 1;; i = 0)
              {
                if (i != 0) {
                  paramb.setUsername((String)localObject);
                }
                Log.i("NetSceneSubscribeMsg", "alvinluo parseExtInfo scene: %s, sessionId: %s, username: %s, extInfo: %s", new Object[] { Integer.valueOf(b.b(paramb)), b.c(paramb), paramb.username, paramString });
                AppMethodBeat.o(236528);
                return;
                i = 0;
                break;
              }
              AppMethodBeat.o(236528);
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
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$IOnNetSceneSubscribeEndCallback;", "", "onNetSceneEndCallback", "", "errType", "", "errCode", "errMsg", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "wxbiz-msgsubscription-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface c
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, SubscribeMsgRequestResult paramSubscribeMsgRequestResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.a.b
 * JD-Core Version:    0.7.0.1
 */