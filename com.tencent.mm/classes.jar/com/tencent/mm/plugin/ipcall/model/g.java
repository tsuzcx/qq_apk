package com.tencent.mm.plugin.ipcall.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.az;
import com.tencent.mm.network.n.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.ipcall.model.b.a.a;
import com.tencent.mm.plugin.ipcall.model.b.b.a;
import com.tencent.mm.plugin.ipcall.model.d.b;
import com.tencent.mm.plugin.ipcall.model.e.k;
import com.tencent.mm.plugin.ipcall.model.e.o;
import com.tencent.mm.plugin.ipcall.model.g.e;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.chr;
import com.tencent.mm.protocal.protobuf.chv;
import com.tencent.mm.protocal.protobuf.chx;
import com.tencent.mm.protocal.protobuf.chy;
import com.tencent.mm.protocal.protobuf.chz;
import com.tencent.mm.protocal.protobuf.cia;
import com.tencent.mm.protocal.protobuf.cib;
import com.tencent.mm.protocal.protobuf.cie;
import com.tencent.mm.protocal.protobuf.cig;
import com.tencent.mm.protocal.protobuf.cih;
import com.tencent.mm.protocal.protobuf.cii;
import com.tencent.mm.protocal.protobuf.cny;
import com.tencent.mm.protocal.protobuf.cnz;
import com.tencent.mm.protocal.protobuf.dqz;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.LinkedList;

public final class g
  implements a.a, b.a
{
  public boolean dsb;
  public int tHH;
  public int tHI;
  public int tHJ;
  public boolean tHK;
  public boolean tHL;
  public a tHM;
  public com.tencent.mm.plugin.ipcall.model.g.d tHN;
  com.tencent.mm.plugin.ipcall.model.g.i tHO;
  com.tencent.mm.plugin.ipcall.model.g.a tHP;
  com.tencent.mm.plugin.ipcall.model.g.h tHQ;
  com.tencent.mm.plugin.ipcall.model.g.c tHR;
  public e tHS;
  com.tencent.mm.plugin.ipcall.model.g.g tHT;
  com.tencent.mm.plugin.ipcall.model.g.f tHU;
  public com.tencent.mm.plugin.ipcall.model.b.c tHV;
  public boolean tHW;
  public boolean tHX;
  com.tencent.mm.network.n tHY;
  
  public g()
  {
    AppMethodBeat.i(25364);
    this.tHH = 0;
    this.tHI = 0;
    this.tHJ = 0;
    this.tHK = false;
    this.tHL = false;
    this.tHW = false;
    this.dsb = false;
    this.tHX = false;
    this.tHY = new n.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        int i = 0;
        AppMethodBeat.i(25363);
        ac.i("MicroMsg.IPCallSvrLogic", "onNetworkChange, st: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (i.cUw().tJI)
        {
          f localf = i.cUz();
          if ((localf.kTr == 4) || (localf.kTr == 5)) {
            i = 1;
          }
          if ((i != 0) && (paramAnonymousInt == 4) && (g.this.tHU != null)) {
            g.this.tHU.a(g.this.tHV);
          }
        }
        AppMethodBeat.o(25363);
      }
    };
    this.tHN = new com.tencent.mm.plugin.ipcall.model.g.d();
    this.tHO = new com.tencent.mm.plugin.ipcall.model.g.i();
    this.tHP = new com.tencent.mm.plugin.ipcall.model.g.a();
    this.tHQ = new com.tencent.mm.plugin.ipcall.model.g.h();
    this.tHR = new com.tencent.mm.plugin.ipcall.model.g.c();
    this.tHS = new e();
    this.tHT = new com.tencent.mm.plugin.ipcall.model.g.g();
    this.tHU = new com.tencent.mm.plugin.ipcall.model.g.f();
    AppMethodBeat.o(25364);
  }
  
  private void G(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(25369);
    ac.i("MicroMsg.IPCallSvrLogic", "handleCancel, success: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((!paramBoolean) && (paramInt < 0) && (this.tHJ <= 0))
    {
      this.tHJ += 1;
      ac.i("MicroMsg.IPCallSvrLogic", "cancel failed, retry count: %d", new Object[] { Integer.valueOf(this.tHJ) });
      this.tHP.a(this.tHV);
      AppMethodBeat.o(25369);
      return;
    }
    AppMethodBeat.o(25369);
  }
  
  private void H(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(25370);
    ac.i("MicroMsg.IPCallSvrLogic", "handleUserSelfShutdown, success: %b, isFromNotify: %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.tHQ.tLA) });
    if ((!paramBoolean) && (paramInt < 0) && (this.tHI <= 0))
    {
      this.tHI += 1;
      ac.i("MicroMsg.IPCallSvrLogic", "shutdown failed, retry count: %d, isFromNotify: %b", new Object[] { Integer.valueOf(this.tHI), Boolean.valueOf(this.tHQ.tLA) });
      this.tHQ.a(this.tHV);
      AppMethodBeat.o(25370);
      return;
    }
    AppMethodBeat.o(25370);
  }
  
  private boolean c(int paramInt1, Object paramObject, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(25379);
    if ((this.tHV == null) || (paramObject == null))
    {
      ac.e("MicroMsg.IPCallSvrLogic", "callInfo = null or result = null");
      AppMethodBeat.o(25379);
      return true;
    }
    Object localObject1;
    label474:
    label613:
    Object localObject2;
    switch (paramInt1)
    {
    case 7: 
    default: 
    case 1: 
    case 3: 
    case 4: 
    case 8: 
      label672:
      label860:
      do
      {
        for (;;)
        {
          AppMethodBeat.o(25379);
          return false;
          if (!(paramObject instanceof com.tencent.mm.plugin.ipcall.model.e.i))
          {
            ac.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo invited result error");
            AppMethodBeat.o(25379);
            return true;
          }
          paramObject = (com.tencent.mm.plugin.ipcall.model.e.i)paramObject;
          localObject1 = paramObject.tKF;
          if (this.tHV.tII != paramObject.tKE.FvR)
          {
            ac.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo invited finished but invite id not the same, now room inviteId:%d, before room inviteId:%d", new Object[] { Integer.valueOf(this.tHV.tII), Integer.valueOf(paramObject.tKE.FvR) });
            AppMethodBeat.o(25379);
            return true;
          }
          ac.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo invited finished invite id:%d", new Object[] { Integer.valueOf(this.tHV.tII) });
          i.cUx().gb(this.tHV.tII, paramInt3);
          if ((paramInt2 == 0) && (paramInt3 == 0))
          {
            if (this.tHV != null)
            {
              this.tHV.roomId = ((chy)localObject1).Exf;
              this.tHV.tIG = ((chy)localObject1).Exg;
              this.tHV.tIH = ((chy)localObject1).FvT;
              this.tHV.tIN = ((chy)localObject1).Fwc;
              this.tHV.tIP = (((chy)localObject1).Fwd * 1000);
              this.tHV.tIW = ((chy)localObject1).tIW;
              this.tHV.tIX = ((chy)localObject1).tIX;
              this.tHV.mVA = ((chy)localObject1).DVd;
              this.tHV.tJd = ((chy)localObject1).Fwe;
              this.tHV.tJi = ((chy)localObject1).Fwf;
              if (((chy)localObject1).tJe > 0) {
                this.tHV.tJe = ((chy)localObject1).tJe;
              }
              this.tHV.tIY = ((chy)localObject1).tIY;
              this.tHV.tIZ = ((chy)localObject1).tIZ;
              this.tHV.tIV = ((chy)localObject1).Fwh;
              if (((chy)localObject1).tJb > 0)
              {
                this.tHV.tJb = (((chy)localObject1).tJb - 1);
                ac.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo zhengxue[ENCRYPT] got encryptStrategy[" + this.tHV.tJb + "] from Invite resp");
                this.tHV.tJc = ((chy)localObject1).Fwg;
                ac.d("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo NextInvite:%d", new Object[] { Integer.valueOf(((chy)localObject1).tIQ) });
                if (((chy)localObject1).tIQ <= 0) {
                  break label613;
                }
                this.tHV.tIU = false;
              }
              for (this.tHV.tIQ = ((chy)localObject1).tIQ;; this.tHV.tIQ = 0)
              {
                this.tHV.tIM = ((chy)localObject1).tIM;
                this.tHV.tIL = ((chy)localObject1).tIL;
                this.tHV.pAG = paramInt3;
                this.tHV.pAH = bs.nullAsNil(z.a(((chy)localObject1).BaseResponse.ErrMsg));
                break;
                ac.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo zhengxue[ENCRYPT] got no encryptStrategy from Invite resp");
                this.tHV.tJb = 2;
                break label474;
                this.tHV.tIU = true;
              }
            }
          }
          else
          {
            ac.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo invite failed");
            if (((chy)localObject1).BaseResponse != null)
            {
              if (paramInt3 == 433)
              {
                ac.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo account overdue");
                this.tHV.tIR = true;
                if (((chy)localObject1).tIQ <= 0) {
                  break label860;
                }
                this.tHV.tIU = false;
              }
              for (this.tHV.tIQ = ((chy)localObject1).tIQ;; this.tHV.tIQ = 0)
              {
                this.tHV.tIM = ((chy)localObject1).tIM;
                this.tHV.tIL = ((chy)localObject1).tIL;
                this.tHV.pAG = paramInt3;
                if (((chy)localObject1).getBaseResponse() == null) {
                  break;
                }
                this.tHV.pAH = bs.nullAsNil(z.a(((chy)localObject1).BaseResponse.ErrMsg));
                ac.d("MicroMsg.IPCallSvrLogic", "ErrLevel:%d,ErrCode:%d,ErrMsg:%s", new Object[] { Integer.valueOf(((chy)localObject1).tIL), Integer.valueOf(paramInt3), this.tHV.pAH });
                break;
                if (paramInt3 == 434)
                {
                  ac.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo restrict call");
                  this.tHV.tIS = true;
                  break label672;
                }
                if (paramInt3 != 435) {
                  break label672;
                }
                ac.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo phonenumber invalid");
                this.tHV.tIT = true;
                break label672;
                this.tHV.tIU = true;
              }
            }
            this.tHV.tIM = "";
            this.tHV.tIL = 2;
            this.tHV.pAH = ai.getContext().getString(2131756764);
            this.tHV.pAG = paramInt3;
            continue;
            if (!(paramObject instanceof com.tencent.mm.plugin.ipcall.model.e.a))
            {
              ac.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo cancel result error");
              AppMethodBeat.o(25379);
              return true;
            }
            ac.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo cancel finished errType:%d,errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
            paramObject = (com.tencent.mm.plugin.ipcall.model.e.a)paramObject;
            if (this.tHV.tII != paramObject.tKn.FvR)
            {
              ac.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo cancel finished but invite id not the same, now room inviteId:%d, before room inviteId:%d", new Object[] { Integer.valueOf(this.tHV.tII), Integer.valueOf(paramObject.tKn.FvR) });
              AppMethodBeat.o(25379);
              return true;
              if (!(paramObject instanceof com.tencent.mm.plugin.ipcall.model.e.n))
              {
                ac.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown result error");
                AppMethodBeat.o(25379);
                return true;
              }
              paramObject = (com.tencent.mm.plugin.ipcall.model.e.n)paramObject;
              if (this.tHV.roomId != paramObject.tKO.Exf)
              {
                ac.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown finished but room id not the same, now room roomId:%d, before room roomId:%d", new Object[] { Integer.valueOf(this.tHV.roomId), Integer.valueOf(paramObject.tKO.Exf) });
                AppMethodBeat.o(25379);
                return true;
              }
              if ((paramInt2 == 0) && (paramInt3 == 0))
              {
                ac.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown success!");
                this.tHV.kmC = 5;
              }
              else
              {
                ac.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown failed");
              }
            }
          }
        }
        if (!(paramObject instanceof chz))
        {
          ac.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo notify result error");
          AppMethodBeat.o(25379);
          return true;
        }
        ac.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo notify finished");
        paramObject = (chz)paramObject;
        if (this.tHV.roomId != paramObject.Exf)
        {
          ac.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown finished but room id not the same, now room roomId:%d, before room roomId:%d", new Object[] { Integer.valueOf(this.tHV.roomId), Integer.valueOf(paramObject.Exf) });
          AppMethodBeat.o(25379);
          return true;
        }
      } while ((paramInt2 != 0) || (paramInt3 != 0));
      this.tHV.tJa = paramObject.tJa;
      ac.d("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo updateNotifyCallInfo, UserStatuslist.size: %d", new Object[] { Integer.valueOf(paramObject.Fwi.size()) });
      paramObject = paramObject.Fwi.iterator();
      while (paramObject.hasNext())
      {
        localObject1 = (cii)paramObject.next();
        if (this.tHV.tIN != ((cii)localObject1).Fwr) {
          break label1537;
        }
        ac.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo update self userStatus, memberId: %d, status: %d, syncKey: %d", new Object[] { Integer.valueOf(this.tHV.tIN), Integer.valueOf(((cii)localObject1).Fws), Integer.valueOf(((cii)localObject1).Fwt) });
        if (((cii)localObject1).Fwt > this.tHV.tIO)
        {
          this.tHV.tIO = ((cii)localObject1).Fwt;
          if (((cii)localObject1).Fws != 0) {
            this.tHV.kmC = ((cii)localObject1).Fws;
          }
        }
        label1448:
        if ((((cii)localObject1).pAG == 404) || (((cii)localObject1).pAG == 484))
        {
          ac.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo notify phonenumber invalid");
          this.tHV.tIT = true;
        }
        this.tHV.pAH = ((cii)localObject1).pAH;
        this.tHV.pAG = ((cii)localObject1).pAG;
        this.tHV.tIL = ((cii)localObject1).tIL;
        this.tHV.tIM = ((cii)localObject1).tIM;
      }
      label1537:
      ac.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo update others userStatus, memberId: %d, status: %d, syncKey: %d", new Object[] { Integer.valueOf(((cii)localObject1).Fwr), Integer.valueOf(((cii)localObject1).Fws), Integer.valueOf(((cii)localObject1).Fwt) });
      paramInt1 = 0;
      localObject2 = this.tHV.tJf.iterator();
      label1596:
      if (((Iterator)localObject2).hasNext())
      {
        com.tencent.mm.plugin.ipcall.model.b.d locald = (com.tencent.mm.plugin.ipcall.model.b.d)((Iterator)localObject2).next();
        if (locald.osF != ((cii)localObject1).Fwr) {
          break label2539;
        }
        if (((cii)localObject1).Fwt > locald.tIO)
        {
          locald.tIO = ((cii)localObject1).Fwt;
          if (((cii)localObject1).Fws != 0) {
            locald.ggN = ((cii)localObject1).Fws;
          }
        }
        paramInt1 = 1;
      }
      break;
    }
    label2536:
    label2537:
    label2539:
    for (;;)
    {
      break label1596;
      if (paramInt1 != 0) {
        break label1448;
      }
      localObject2 = new com.tencent.mm.plugin.ipcall.model.b.d();
      ((com.tencent.mm.plugin.ipcall.model.b.d)localObject2).osF = ((cii)localObject1).Fwr;
      ((com.tencent.mm.plugin.ipcall.model.b.d)localObject2).ggN = ((cii)localObject1).Fws;
      ((com.tencent.mm.plugin.ipcall.model.b.d)localObject2).tIO = ((cii)localObject1).Fwt;
      this.tHV.tJf.add(localObject2);
      break label1448;
      if (!(paramObject instanceof k))
      {
        ac.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo redirect result error");
        AppMethodBeat.o(25379);
        return true;
      }
      paramObject = (k)paramObject;
      localObject1 = paramObject.tKJ;
      if (this.tHV.roomId != paramObject.tKI.Exf)
      {
        ac.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo redirect finished but room id not the same, now room roomId:%d, before room roomId:%d", new Object[] { Integer.valueOf(this.tHV.roomId), Integer.valueOf(paramObject.tKI.Exf) });
        AppMethodBeat.o(25379);
        return true;
      }
      if ((paramInt2 == 0) && (paramInt3 == 0))
      {
        ac.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo redirect success");
        this.tHV.mVA = ((cib)localObject1).DVd;
        this.tHV.tJd = ((cib)localObject1).Fwe;
        break;
      }
      ac.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo redirect failed");
      break;
      if (!(paramObject instanceof o))
      {
        ac.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync result error");
        AppMethodBeat.o(25379);
        return true;
      }
      ac.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync finished errType:%d,errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      localObject1 = (o)paramObject;
      paramObject = ((o)localObject1).tKR;
      if (this.tHV.roomId != ((o)localObject1).tKQ.Exf)
      {
        ac.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync finished but room id not the same, now room roomId:%d, before room roomId:%d", new Object[] { Integer.valueOf(this.tHV.roomId), Integer.valueOf(((o)localObject1).tKQ.Exf) });
        AppMethodBeat.o(25379);
        return true;
      }
      if ((paramInt2 != 0) || (paramInt3 != 0)) {
        break;
      }
      ac.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync roomId: %d, status: %d, memberId: %d, syncKey: %d", new Object[] { Integer.valueOf(paramObject.Exf), Integer.valueOf(paramObject.Fwq), Integer.valueOf(paramObject.Fwr), Integer.valueOf(paramObject.Fwo) });
      if ((paramObject.Exf != this.tHV.roomId) || (paramObject.Exg != this.tHV.tIG)) {
        break;
      }
      if (paramObject.Fwr == this.tHV.tIN)
      {
        ac.d("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync update self status");
        if (paramObject.Fwo > this.tHV.tIO)
        {
          this.tHV.tIO = paramObject.Fwo;
          if (paramObject.Fwq != 0) {
            this.tHV.kmC = paramObject.Fwq;
          }
        }
      }
      for (;;)
      {
        label2170:
        if ((paramObject.pAG == 404) || (paramObject.pAG == 484))
        {
          ac.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync phonenumber invalid");
          this.tHV.tIT = true;
        }
        this.tHV.pAH = paramObject.pAH;
        this.tHV.pAG = paramObject.pAG;
        this.tHV.tIL = paramObject.tIL;
        this.tHV.tIM = paramObject.tIM;
        this.tHV.tJa = paramObject.tJa;
        break;
        ac.d("MicroMsg.IPCallSvrLogic", " handleServiceResultCallInfosync update others status");
        localObject1 = this.tHV.tJf.iterator();
        paramInt1 = 0;
        label2286:
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (com.tencent.mm.plugin.ipcall.model.b.d)((Iterator)localObject1).next();
          if (((com.tencent.mm.plugin.ipcall.model.b.d)localObject2).osF != paramObject.Fwr) {
            break label2536;
          }
          if (paramObject.Fwo > ((com.tencent.mm.plugin.ipcall.model.b.d)localObject2).tIO)
          {
            ((com.tencent.mm.plugin.ipcall.model.b.d)localObject2).tIO = paramObject.Fwo;
            if (paramObject.Fwq != 0) {
              ((com.tencent.mm.plugin.ipcall.model.b.d)localObject2).ggN = paramObject.Fwq;
            }
          }
          paramInt1 = 1;
        }
        for (;;)
        {
          break label2286;
          if (paramInt1 != 0) {
            break label2537;
          }
          localObject1 = new com.tencent.mm.plugin.ipcall.model.b.d();
          ((com.tencent.mm.plugin.ipcall.model.b.d)localObject1).osF = paramObject.Fwr;
          ((com.tencent.mm.plugin.ipcall.model.b.d)localObject1).ggN = paramObject.Fwq;
          ((com.tencent.mm.plugin.ipcall.model.b.d)localObject1).tIO = paramObject.Fwo;
          this.tHV.tJf.add(localObject1);
          break label2170;
          if (!(paramObject instanceof com.tencent.mm.plugin.ipcall.model.e.h))
          {
            ac.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo heartbeat result error");
            AppMethodBeat.o(25379);
            return true;
          }
          ac.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo heartbeat finished errType:%d,errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
          paramObject = (com.tencent.mm.plugin.ipcall.model.e.h)paramObject;
          if (this.tHV.roomId == paramObject.tKC.Exf) {
            break;
          }
          ac.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo heartbeat finished but room id not the same, now room roomId:%d, before room roomId:%d", new Object[] { Integer.valueOf(this.tHV.roomId), Integer.valueOf(paramObject.tKC.Exf) });
          AppMethodBeat.o(25379);
          return true;
        }
      }
    }
  }
  
  private void ni(boolean paramBoolean)
  {
    AppMethodBeat.i(25367);
    ac.i("MicroMsg.IPCallSvrLogic", "handleInvite, success: %b, isLaunchCancel: %b, isLaunchShutdown: %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.tHK), Boolean.valueOf(this.tHL) });
    if ((this.tHK) || (this.tHL))
    {
      ac.i("MicroMsg.IPCallSvrLogic", "handleInvite, ignore this");
      AppMethodBeat.o(25367);
      return;
    }
    if (paramBoolean)
    {
      if (this.tHM != null)
      {
        if (this.tHV.tIU) {
          break label130;
        }
        this.tHM.cTQ();
      }
      for (;;)
      {
        ac.i("MicroMsg.IPCallSvrLogic", "start sync");
        this.tHO.a(this.tHV);
        AppMethodBeat.o(25367);
        return;
        label130:
        this.tHM.cTL();
      }
    }
    if (this.tHM != null)
    {
      if (this.tHV.tIR)
      {
        this.tHM.T(this.tHV.tIM, this.tHV.pAH, this.tHV.tIL);
        AppMethodBeat.o(25367);
        return;
      }
      if (this.tHV.tIS)
      {
        this.tHM.U(this.tHV.tIM, this.tHV.pAH, this.tHV.tIL);
        AppMethodBeat.o(25367);
        return;
      }
      if (this.tHV.tIT)
      {
        this.tHM.V(this.tHV.tIM, this.tHV.pAH, this.tHV.tIL);
        AppMethodBeat.o(25367);
        return;
      }
      if (!this.tHV.tIU)
      {
        this.tHM.cTQ();
        AppMethodBeat.o(25367);
        return;
      }
      this.tHM.S(this.tHV.tIM, this.tHV.pAH, this.tHV.tIL);
    }
    AppMethodBeat.o(25367);
  }
  
  private void nj(boolean paramBoolean)
  {
    AppMethodBeat.i(25368);
    ac.i("MicroMsg.IPCallSvrLogic", "handleHeartbeat, success: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      this.tHH += 1;
      if (this.tHH >= 2)
      {
        ac.e("MicroMsg.IPCallSvrLogic", "heartbeat failed twice!");
        this.tHR.stop();
        if ((i.cUz().cUr()) && (this.tHM != null))
        {
          this.tHM.cTP();
          AppMethodBeat.o(25368);
        }
      }
    }
    else
    {
      this.tHH = 0;
    }
    AppMethodBeat.o(25368);
  }
  
  private void nk(boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(25371);
    ac.i("MicroMsg.IPCallSvrLogic", "handleSync, success: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((paramBoolean) && (i.cUw().tJI)) {
      i.cUw().Hg(this.tHV.tJa);
    }
    if (!paramBoolean)
    {
      ac.e("MicroMsg.IPCallSvrLogic", "sync failed!");
      this.tHO.stop();
      if (i.cUz().kTr == 3) {}
      for (;;)
      {
        if ((i != 0) && (this.tHM != null)) {
          this.tHM.dF(this.tHV.pAH, this.tHV.tIL);
        }
        AppMethodBeat.o(25371);
        return;
        i = 0;
      }
    }
    if ((this.tHV != null) && (paramBoolean)) {
      Hf(this.tHV.cUM());
    }
    AppMethodBeat.o(25371);
  }
  
  private void nl(boolean paramBoolean)
  {
    AppMethodBeat.i(25372);
    ac.i("MicroMsg.IPCallSvrLogic", "handleNotify, success: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((paramBoolean) && (i.cUw().tJI)) {
      i.cUw().Hg(this.tHV.tJa);
    }
    if ((this.tHV != null) && (paramBoolean))
    {
      int i = this.tHV.cUM();
      if ((i == 2) || (i == 1))
      {
        if (!this.tHX)
        {
          o localo = new o(this.tHV.roomId, this.tHV.tIG, this.tHV.cUL(), this.tHV.tIH, false);
          az.agi().a(localo, 0);
        }
      }
      else {
        Hf(this.tHV.cUM());
      }
    }
    else
    {
      AppMethodBeat.o(25372);
      return;
    }
    ac.i("MicroMsg.IPCallSvrLogic", "current status has jni accepted, ignore notify accept");
    AppMethodBeat.o(25372);
  }
  
  private void nm(boolean paramBoolean)
  {
    AppMethodBeat.i(25374);
    ac.i("MicroMsg.IPCallSvrLogic", "handleRedirect, isSuccess: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    com.tencent.mm.plugin.ipcall.model.d.a locala;
    Object localObject1;
    Object localObject2;
    if (paramBoolean)
    {
      locala = i.cUw();
      localObject1 = this.tHV;
      ac.i("MicroMsg.IPCallEngineManager", "redirectSvrAddr");
      if ((localObject1 != null) && (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).mVA != null) && (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).mVA.size() > 0)) {
        com.tencent.mm.plugin.ipcall.a.c.aF(((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).mVA);
      }
      if ((localObject1 != null) && (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).tJd != null) && (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).tJd.size() > 0)) {
        com.tencent.mm.plugin.ipcall.a.c.aF(((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).tJd);
      }
      localObject2 = new cnz();
      cny localcny = new cny();
      localcny.Evo = 0;
      localcny.Evp = "";
      localcny.Evq = "";
      localcny.Evr = 4;
      localcny.Evs = 4;
      localcny.Evt = 2;
      localcny.FBc = new dqz();
      localcny.FBd = new dqz();
      if ((localObject1 != null) && (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).mVA != null) && (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).mVA.size() > 0)) {
        localcny.FBc = com.tencent.mm.plugin.ipcall.a.c.aF(((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).mVA);
      }
      if ((localObject1 != null) && (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).tJd != null) && (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).tJd.size() > 0)) {
        localcny.FBd = com.tencent.mm.plugin.ipcall.a.c.aF(((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).tJd);
      }
      ((cnz)localObject2).FBf.add(localcny);
      ((cnz)localObject2).FBe = 1;
      localObject1 = null;
    }
    try
    {
      localObject2 = ((cnz)localObject2).toByteArray();
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i;
        ac.e("MicroMsg.IPCallEngineManager", "conn info to byte array fail..");
      }
    }
    if (localObject1 != null)
    {
      i = locala.tJF.AddNewRelayConns((byte[])localObject1, localObject1.length, 1);
      if (i != 0) {
        com.tencent.mm.plugin.voip.b.d.Loge("MicroMsg.IPCallEngineManager", "redirect relay conns fail ret:".concat(String.valueOf(i)));
      }
    }
    AppMethodBeat.o(25374);
  }
  
  public final void He(int paramInt)
  {
    AppMethodBeat.i(25366);
    if (!this.tHV.tJk) {
      ac.e("MicroMsg.IPCallSvrLogic", "shutdownIPCall, user not accept");
    }
    ac.i("MicroMsg.IPCallSvrLogic", "shutdownIPCall, roomId: %d, inviteId: %d", new Object[] { Integer.valueOf(this.tHV.roomId), Integer.valueOf(this.tHV.tII) });
    this.tHL = true;
    this.tHR.stop();
    this.tHO.stop();
    this.tHQ.tLA = false;
    this.tHQ.tLz = paramInt;
    this.tHQ.a(this.tHV);
    this.tHT.a(this.tHV);
    AppMethodBeat.o(25366);
  }
  
  public final boolean Hf(int paramInt)
  {
    AppMethodBeat.i(25373);
    switch (paramInt)
    {
    default: 
      ac.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, do nothing:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(25373);
      return false;
    case 2: 
      ac.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, user accept, isLaunchCancel: %b, isLaunchShutdown: %b", new Object[] { Boolean.valueOf(this.tHK), Boolean.valueOf(this.tHL) });
      if ((this.tHK) || (this.tHL))
      {
        AppMethodBeat.o(25373);
        return true;
      }
      this.tHO.stop();
      if (!this.dsb)
      {
        this.dsb = true;
        if (this.tHV != null) {
          this.tHV.tJk = true;
        }
        if (this.tHM != null) {
          this.tHM.cTN();
        }
        this.tHR.a(this.tHV);
      }
      AppMethodBeat.o(25373);
      return true;
    case 3: 
      ac.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, user busy");
      this.tHO.stop();
      this.tHR.stop();
      if (this.tHM != null) {
        this.tHM.dE(this.tHV.pAH, this.tHV.tIL);
      }
      AppMethodBeat.o(25373);
      return true;
    case 1: 
      ac.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, user ringing");
      if (!this.tHW)
      {
        this.tHW = true;
        if (this.tHM != null) {
          this.tHM.cTM();
        }
      }
      AppMethodBeat.o(25373);
      return true;
    case 5: 
      ac.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, other side user shutdown");
      if (this.tHM != null) {
        this.tHM.cTO();
      }
      AppMethodBeat.o(25373);
      return true;
    case 4: 
    case 7: 
    case 8: 
      ac.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, user unavailable");
      if (this.tHV.tIT) {
        if (this.tHM != null) {
          this.tHM.V(this.tHV.tIM, this.tHV.pAH, this.tHV.tIL);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(25373);
        return true;
        if (this.tHM != null) {
          this.tHM.dD(this.tHV.pAH, this.tHV.tIL);
        }
      }
    }
    ac.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, shutdown overdue");
    this.tHV.tIR = true;
    if (this.tHM != null) {
      this.tHM.T(this.tHV.tIM, this.tHV.pAH, this.tHV.tIL);
    }
    AppMethodBeat.o(25373);
    return true;
  }
  
  public final void a(int paramInt1, com.tencent.mm.ak.n paramn, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(25377);
    if (c(paramInt1, paramn, paramInt2, paramInt3))
    {
      ac.i("MicroMsg.IPCallSvrLogic", "onTimerSuccess different room ignore");
      AppMethodBeat.o(25377);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(25377);
      return;
      nk(true);
      AppMethodBeat.o(25377);
      return;
      nj(true);
    }
  }
  
  public final void a(int paramInt1, Object paramObject, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(25375);
    if (c(paramInt1, paramObject, paramInt2, paramInt3))
    {
      ac.i("MicroMsg.IPCallSvrLogic", "onServiceResult different room ignore");
      AppMethodBeat.o(25375);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(25375);
      return;
      ni(true);
      AppMethodBeat.o(25375);
      return;
      G(true, paramInt3);
      AppMethodBeat.o(25375);
      return;
      H(true, paramInt3);
      AppMethodBeat.o(25375);
      return;
      nl(true);
      AppMethodBeat.o(25375);
      return;
      nm(true);
    }
  }
  
  public final void b(int paramInt1, com.tencent.mm.ak.n paramn, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(25378);
    if (c(paramInt1, paramn, paramInt2, paramInt3))
    {
      ac.i("MicroMsg.IPCallSvrLogic", "onTimerFailed different room ignore");
      AppMethodBeat.o(25378);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(25378);
      return;
      nk(false);
      AppMethodBeat.o(25378);
      return;
      nj(false);
    }
  }
  
  public final void b(int paramInt1, Object paramObject, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(25376);
    if (c(paramInt1, paramObject, paramInt2, paramInt3))
    {
      ac.i("MicroMsg.IPCallSvrLogic", "onServiceFailed different room ignore");
      AppMethodBeat.o(25376);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(25376);
      return;
      ni(false);
      AppMethodBeat.o(25376);
      return;
      G(false, paramInt3);
      AppMethodBeat.o(25376);
      return;
      H(false, paramInt3);
      AppMethodBeat.o(25376);
      return;
      nl(false);
      AppMethodBeat.o(25376);
      return;
      nm(false);
    }
  }
  
  public final void cUs()
  {
    AppMethodBeat.i(25365);
    if (this.tHV.tJk) {
      ac.e("MicroMsg.IPCallSvrLogic", "cancelIPCall, already accept");
    }
    this.tHK = true;
    ac.i("MicroMsg.IPCallSvrLogic", "cancelIPCall, roomId: %d, inviteId: %d", new Object[] { Integer.valueOf(this.tHV.roomId), Integer.valueOf(this.tHV.tII) });
    this.tHR.stop();
    this.tHO.stop();
    this.tHP.a(this.tHV);
    this.tHT.a(this.tHV);
    AppMethodBeat.o(25365);
  }
  
  public static abstract interface a
  {
    public abstract void S(String paramString1, String paramString2, int paramInt);
    
    public abstract void T(String paramString1, String paramString2, int paramInt);
    
    public abstract void U(String paramString1, String paramString2, int paramInt);
    
    public abstract void V(String paramString1, String paramString2, int paramInt);
    
    public abstract void cTL();
    
    public abstract void cTM();
    
    public abstract void cTN();
    
    public abstract void cTO();
    
    public abstract void cTP();
    
    public abstract void cTQ();
    
    public abstract void dD(String paramString, int paramInt);
    
    public abstract void dE(String paramString, int paramInt);
    
    public abstract void dF(String paramString, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.g
 * JD-Core Version:    0.7.0.1
 */