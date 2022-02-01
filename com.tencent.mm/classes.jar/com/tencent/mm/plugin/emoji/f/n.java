package com.tencent.mm.plugin.emoji.f;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.g.a.di;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.emoji.model.d;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.protocal.protobuf.GetEmotionListRequest;
import com.tencent.mm.protocal.protobuf.GetEmotionListResponse;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.emotion.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class n
  extends com.tencent.mm.ak.n
  implements com.tencent.mm.network.k
{
  private com.tencent.mm.ak.f callback;
  private final int mScene;
  public final int mType;
  public byte[] pME;
  public int pMG;
  boolean pMH;
  ArrayList<EmotionSummary> pMI;
  private final b rr;
  
  public n(int paramInt1, int paramInt2)
  {
    this(paramInt1, null, paramInt2);
  }
  
  public n(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    this(paramInt1, paramArrayOfByte, paramInt2, false);
  }
  
  public n(int paramInt1, byte[] paramArrayOfByte, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(108706);
    this.pMH = false;
    this.pMI = new ArrayList();
    this.pME = null;
    b.a locala = new b.a();
    locala.hQF = new GetEmotionListRequest();
    locala.hQG = new GetEmotionListResponse();
    locala.uri = "/cgi-bin/micromsg-bin/getemotionlist";
    locala.funcId = 411;
    locala.hQH = 210;
    locala.respCmdId = 1000000210;
    this.rr = locala.aDS();
    this.pME = paramArrayOfByte;
    this.mType = paramInt1;
    this.mScene = paramInt2;
    this.pMH = paramBoolean;
    ae.i("MicroMsg.emoji.NetSceneGetEmotionList", "NetSceneGetEmotionList: %s, %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(108706);
  }
  
  public static com.tencent.mm.plugin.emoji.model.f b(GetEmotionListResponse paramGetEmotionListResponse)
  {
    AppMethodBeat.i(108709);
    ae.d("MicroMsg.emoji.NetSceneGetEmotionList", "getEmotionListModel");
    if (paramGetEmotionListResponse == null)
    {
      AppMethodBeat.o(108709);
      return null;
    }
    com.tencent.mm.plugin.emoji.model.f localf = new com.tencent.mm.plugin.emoji.model.f();
    if (paramGetEmotionListResponse != null)
    {
      localf.pKM = paramGetEmotionListResponse.EmotionCount;
      Object localObject1 = new ArrayList();
      if ((paramGetEmotionListResponse.EmotionList != null) && (!paramGetEmotionListResponse.EmotionList.isEmpty()))
      {
        Object[] arrayOfObject = paramGetEmotionListResponse.EmotionList.toArray();
        if ((arrayOfObject != null) && (arrayOfObject.length > 0))
        {
          int j = arrayOfObject.length;
          int i = 0;
          while (i < j)
          {
            Object localObject2 = arrayOfObject[i];
            if ((localObject2 != null) && ((localObject2 instanceof EmotionSummary)))
            {
              localObject2 = (EmotionSummary)localObject2;
              if ((localObject2 != null) && (!bu.isNullOrNil(((EmotionSummary)localObject2).ProductID))) {
                ((List)localObject1).add(new com.tencent.mm.plugin.emoji.a.a.f((EmotionSummary)localObject2));
              }
            }
            i += 1;
          }
        }
      }
      localf.pKN = ((List)localObject1);
      localf.pKO = paramGetEmotionListResponse.Banner;
      localf.pKP = paramGetEmotionListResponse.NewBannerList;
      localObject1 = paramGetEmotionListResponse.CellSetList;
      if (localf.pKR == null)
      {
        localf.pKR = new LinkedList();
        localf.pKR.addAll((Collection)localObject1);
      }
      localf.pKQ = paramGetEmotionListResponse.BannerSetList;
    }
    AppMethodBeat.o(108709);
    return localf;
  }
  
  private void ciA()
  {
    AppMethodBeat.i(108710);
    GetEmotionListResponse localGetEmotionListResponse = ciz();
    if ((localGetEmotionListResponse != null) && (localGetEmotionListResponse.EmotionList != null) && (localGetEmotionListResponse.EmotionList.size() > 0))
    {
      this.pMI.addAll(localGetEmotionListResponse.EmotionList);
      AppMethodBeat.o(108710);
      return;
    }
    ae.w("MicroMsg.emoji.NetSceneGetEmotionList", "addSummaryList faild. response is null or emotion list is empty.");
    AppMethodBeat.o(108710);
  }
  
  public final GetEmotionListResponse ciz()
  {
    if (this.rr == null) {
      return null;
    }
    return (GetEmotionListResponse)this.rr.hQE.hQJ;
  }
  
  public int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(108707);
    this.callback = paramf;
    GetEmotionListRequest localGetEmotionListRequest = (GetEmotionListRequest)this.rr.hQD.hQJ;
    if (this.pME != null)
    {
      localGetEmotionListRequest.ReqBuf = z.al(this.pME);
      if (localGetEmotionListRequest.ReqBuf != null) {
        break label130;
      }
    }
    label130:
    for (paramf = "Buf is NULL";; paramf = localGetEmotionListRequest.ReqBuf.toString())
    {
      ae.d("MicroMsg.emoji.NetSceneGetEmotionList", paramf);
      localGetEmotionListRequest.ReqType = this.mType;
      localGetEmotionListRequest.Scene = this.mScene;
      if (this.mType == 7) {
        localGetEmotionListRequest.Category = this.pMG;
      }
      int i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(108707);
      return i;
      localGetEmotionListRequest.ReqBuf = new SKBuiltinBuffer_t();
      break;
    }
  }
  
  public int getType()
  {
    return 411;
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108708);
    ae.d("MicroMsg.emoji.NetSceneGetEmotionList", "ErrType:" + paramInt2 + "   errCode:" + paramInt3);
    if (this.mType == 8)
    {
      if ((paramInt2 == 0) && (paramInt3 == 0)) {
        g.ajR().ajA().set(am.a.IKL, Long.valueOf(System.currentTimeMillis()));
      }
    }
    else if (this.mType == 11)
    {
      if ((paramInt2 != 0) || (paramInt3 != 0)) {
        break label185;
      }
      g.ajR().ajA().set(am.a.IKP, Long.valueOf(System.currentTimeMillis()));
    }
    for (;;)
    {
      com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().JfX.a(this.mType, ciz());
      if ((paramInt2 == 0) || (paramInt2 == 4)) {
        break label214;
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(108708);
      return;
      g.ajR().ajA().set(am.a.IKL, Long.valueOf(System.currentTimeMillis() - 86400000L + 3600000L));
      break;
      label185:
      g.ajR().ajA().set(am.a.IKP, Long.valueOf(System.currentTimeMillis() - 28800000L + 600000L));
    }
    label214:
    paramArrayOfByte = (GetEmotionListResponse)((b)paramq).hQE.hQJ;
    if (paramArrayOfByte.ReqBuf != null) {
      this.pME = z.a(paramArrayOfByte.ReqBuf);
    }
    if (this.mType == 8)
    {
      if (paramInt3 == 0)
      {
        ciA();
        h.MqF.aO(new n.1(this));
        g.ajR().ajA().set(am.a.IKL, Long.valueOf(System.currentTimeMillis()));
      }
    }
    else
    {
      if ((this.mType != 1) && (this.mType != 9)) {
        break label525;
      }
      paramq = d.chY();
      paramArrayOfByte = ciz().EmotionExptConfig;
      if (!bu.lX(paramq.pKF, paramArrayOfByte))
      {
        paramq.pKF = paramArrayOfByte;
        paramq.chZ();
        g.ajR().ajA().set(am.a.IYI, paramArrayOfByte);
        a.IvT.l(new di());
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(108708);
      return;
      if (paramInt3 == 2)
      {
        ciA();
        ((GetEmotionListRequest)((b)paramq).hQD.hQJ).ReqBuf = ((GetEmotionListResponse)((b)paramq).hQE.hQJ).ReqBuf;
        doScene(dispatcher(), this.callback);
        break;
      }
      if (paramInt3 != 3) {
        break;
      }
      if (this.pMI != null) {
        this.pMI.clear();
      }
      ((GetEmotionListRequest)((b)paramq).hQD.hQJ).ReqBuf = new SKBuiltinBuffer_t();
      doScene(dispatcher(), this.callback);
      break;
      label525:
      if (this.mType == 5)
      {
        paramq = d.chY();
        paramArrayOfByte = ciz().EmotionExptConfig;
        if (!bu.lX(paramq.pKE, paramArrayOfByte))
        {
          paramq.pKE = paramArrayOfByte;
          paramq.chZ();
          g.ajR().ajA().set(am.a.IYJ, paramArrayOfByte);
          a.IvT.l(new di());
        }
      }
    }
  }
  
  public int securityLimitCount()
  {
    return 100;
  }
  
  public n.b securityVerificationChecked(q paramq)
  {
    return n.b.hRi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.n
 * JD-Core Version:    0.7.0.1
 */