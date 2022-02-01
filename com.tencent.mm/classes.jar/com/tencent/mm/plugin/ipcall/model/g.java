package com.tencent.mm.plugin.ipcall.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.model.ba;
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
import com.tencent.mm.protocal.protobuf.cmr;
import com.tencent.mm.protocal.protobuf.cmv;
import com.tencent.mm.protocal.protobuf.cmx;
import com.tencent.mm.protocal.protobuf.cmy;
import com.tencent.mm.protocal.protobuf.cmz;
import com.tencent.mm.protocal.protobuf.cna;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.cne;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.protocal.protobuf.cnh;
import com.tencent.mm.protocal.protobuf.cni;
import com.tencent.mm.protocal.protobuf.ctb;
import com.tencent.mm.protocal.protobuf.ctc;
import com.tencent.mm.protocal.protobuf.dwt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;

public final class g
  implements a.a, b.a
{
  public boolean dDV;
  public com.tencent.mm.plugin.ipcall.model.g.d uKA;
  com.tencent.mm.plugin.ipcall.model.g.i uKB;
  com.tencent.mm.plugin.ipcall.model.g.a uKC;
  com.tencent.mm.plugin.ipcall.model.g.h uKD;
  com.tencent.mm.plugin.ipcall.model.g.c uKE;
  public e uKF;
  com.tencent.mm.plugin.ipcall.model.g.g uKG;
  com.tencent.mm.plugin.ipcall.model.g.f uKH;
  public com.tencent.mm.plugin.ipcall.model.b.c uKI;
  public boolean uKJ;
  public boolean uKK;
  com.tencent.mm.network.n uKL;
  public int uKu;
  public int uKv;
  public int uKw;
  public boolean uKx;
  public boolean uKy;
  public a uKz;
  
  public g()
  {
    AppMethodBeat.i(25364);
    this.uKu = 0;
    this.uKv = 0;
    this.uKw = 0;
    this.uKx = false;
    this.uKy = false;
    this.uKJ = false;
    this.dDV = false;
    this.uKK = false;
    this.uKL = new n.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        int i = 0;
        AppMethodBeat.i(25363);
        ad.i("MicroMsg.IPCallSvrLogic", "onNetworkChange, st: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (i.ddH().uMv)
        {
          f localf = i.ddK();
          if ((localf.lpU == 4) || (localf.lpU == 5)) {
            i = 1;
          }
          if ((i != 0) && (paramAnonymousInt == 4) && (g.this.uKH != null)) {
            g.this.uKH.a(g.this.uKI);
          }
        }
        AppMethodBeat.o(25363);
      }
    };
    this.uKA = new com.tencent.mm.plugin.ipcall.model.g.d();
    this.uKB = new com.tencent.mm.plugin.ipcall.model.g.i();
    this.uKC = new com.tencent.mm.plugin.ipcall.model.g.a();
    this.uKD = new com.tencent.mm.plugin.ipcall.model.g.h();
    this.uKE = new com.tencent.mm.plugin.ipcall.model.g.c();
    this.uKF = new e();
    this.uKG = new com.tencent.mm.plugin.ipcall.model.g.g();
    this.uKH = new com.tencent.mm.plugin.ipcall.model.g.f();
    AppMethodBeat.o(25364);
  }
  
  private void G(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(25369);
    ad.i("MicroMsg.IPCallSvrLogic", "handleCancel, success: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((!paramBoolean) && (paramInt < 0) && (this.uKw <= 0))
    {
      this.uKw += 1;
      ad.i("MicroMsg.IPCallSvrLogic", "cancel failed, retry count: %d", new Object[] { Integer.valueOf(this.uKw) });
      this.uKC.a(this.uKI);
      AppMethodBeat.o(25369);
      return;
    }
    AppMethodBeat.o(25369);
  }
  
  private void H(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(25370);
    ad.i("MicroMsg.IPCallSvrLogic", "handleUserSelfShutdown, success: %b, isFromNotify: %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.uKD.uOn) });
    if ((!paramBoolean) && (paramInt < 0) && (this.uKv <= 0))
    {
      this.uKv += 1;
      ad.i("MicroMsg.IPCallSvrLogic", "shutdown failed, retry count: %d, isFromNotify: %b", new Object[] { Integer.valueOf(this.uKv), Boolean.valueOf(this.uKD.uOn) });
      this.uKD.a(this.uKI);
      AppMethodBeat.o(25370);
      return;
    }
    AppMethodBeat.o(25370);
  }
  
  private boolean c(int paramInt1, Object paramObject, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(25379);
    if ((this.uKI == null) || (paramObject == null))
    {
      ad.e("MicroMsg.IPCallSvrLogic", "callInfo = null or result = null");
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
            ad.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo invited result error");
            AppMethodBeat.o(25379);
            return true;
          }
          paramObject = (com.tencent.mm.plugin.ipcall.model.e.i)paramObject;
          localObject1 = paramObject.uNs;
          if (this.uKI.uLv != paramObject.uNr.HfX)
          {
            ad.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo invited finished but invite id not the same, now room inviteId:%d, before room inviteId:%d", new Object[] { Integer.valueOf(this.uKI.uLv), Integer.valueOf(paramObject.uNr.HfX) });
            AppMethodBeat.o(25379);
            return true;
          }
          ad.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo invited finished invite id:%d", new Object[] { Integer.valueOf(this.uKI.uLv) });
          i.ddI().gs(this.uKI.uLv, paramInt3);
          if ((paramInt2 == 0) && (paramInt3 == 0))
          {
            if (this.uKI != null)
            {
              this.uKI.roomId = ((cmy)localObject1).GeI;
              this.uKI.uLt = ((cmy)localObject1).GeJ;
              this.uKI.uLu = ((cmy)localObject1).HfZ;
              this.uKI.uLA = ((cmy)localObject1).Hgi;
              this.uKI.uLC = (((cmy)localObject1).Hgj * 1000);
              this.uKI.uLJ = ((cmy)localObject1).uLJ;
              this.uKI.uLK = ((cmy)localObject1).uLK;
              this.uKI.nvX = ((cmy)localObject1).FAy;
              this.uKI.uLQ = ((cmy)localObject1).Hgk;
              this.uKI.uLV = ((cmy)localObject1).Hgl;
              if (((cmy)localObject1).uLR > 0) {
                this.uKI.uLR = ((cmy)localObject1).uLR;
              }
              this.uKI.uLL = ((cmy)localObject1).uLL;
              this.uKI.uLM = ((cmy)localObject1).uLM;
              this.uKI.uLI = ((cmy)localObject1).Hgn;
              if (((cmy)localObject1).uLO > 0)
              {
                this.uKI.uLO = (((cmy)localObject1).uLO - 1);
                ad.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo zhengxue[ENCRYPT] got encryptStrategy[" + this.uKI.uLO + "] from Invite resp");
                this.uKI.uLP = ((cmy)localObject1).Hgm;
                ad.d("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo NextInvite:%d", new Object[] { Integer.valueOf(((cmy)localObject1).uLD) });
                if (((cmy)localObject1).uLD <= 0) {
                  break label613;
                }
                this.uKI.uLH = false;
              }
              for (this.uKI.uLD = ((cmy)localObject1).uLD;; this.uKI.uLD = 0)
              {
                this.uKI.uLz = ((cmy)localObject1).uLz;
                this.uKI.uLy = ((cmy)localObject1).uLy;
                this.uKI.qel = paramInt3;
                this.uKI.qem = bt.nullAsNil(z.a(((cmy)localObject1).BaseResponse.ErrMsg));
                break;
                ad.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo zhengxue[ENCRYPT] got no encryptStrategy from Invite resp");
                this.uKI.uLO = 2;
                break label474;
                this.uKI.uLH = true;
              }
            }
          }
          else
          {
            ad.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo invite failed");
            if (((cmy)localObject1).BaseResponse != null)
            {
              if (paramInt3 == 433)
              {
                ad.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo account overdue");
                this.uKI.uLE = true;
                if (((cmy)localObject1).uLD <= 0) {
                  break label860;
                }
                this.uKI.uLH = false;
              }
              for (this.uKI.uLD = ((cmy)localObject1).uLD;; this.uKI.uLD = 0)
              {
                this.uKI.uLz = ((cmy)localObject1).uLz;
                this.uKI.uLy = ((cmy)localObject1).uLy;
                this.uKI.qel = paramInt3;
                if (((cmy)localObject1).getBaseResponse() == null) {
                  break;
                }
                this.uKI.qem = bt.nullAsNil(z.a(((cmy)localObject1).BaseResponse.ErrMsg));
                ad.d("MicroMsg.IPCallSvrLogic", "ErrLevel:%d,ErrCode:%d,ErrMsg:%s", new Object[] { Integer.valueOf(((cmy)localObject1).uLy), Integer.valueOf(paramInt3), this.uKI.qem });
                break;
                if (paramInt3 == 434)
                {
                  ad.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo restrict call");
                  this.uKI.uLF = true;
                  break label672;
                }
                if (paramInt3 != 435) {
                  break label672;
                }
                ad.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo phonenumber invalid");
                this.uKI.uLG = true;
                break label672;
                this.uKI.uLH = true;
              }
            }
            this.uKI.uLz = "";
            this.uKI.uLy = 2;
            this.uKI.qem = aj.getContext().getString(2131756764);
            this.uKI.qel = paramInt3;
            continue;
            if (!(paramObject instanceof com.tencent.mm.plugin.ipcall.model.e.a))
            {
              ad.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo cancel result error");
              AppMethodBeat.o(25379);
              return true;
            }
            ad.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo cancel finished errType:%d,errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
            paramObject = (com.tencent.mm.plugin.ipcall.model.e.a)paramObject;
            if (this.uKI.uLv != paramObject.uNa.HfX)
            {
              ad.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo cancel finished but invite id not the same, now room inviteId:%d, before room inviteId:%d", new Object[] { Integer.valueOf(this.uKI.uLv), Integer.valueOf(paramObject.uNa.HfX) });
              AppMethodBeat.o(25379);
              return true;
              if (!(paramObject instanceof com.tencent.mm.plugin.ipcall.model.e.n))
              {
                ad.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown result error");
                AppMethodBeat.o(25379);
                return true;
              }
              paramObject = (com.tencent.mm.plugin.ipcall.model.e.n)paramObject;
              if (this.uKI.roomId != paramObject.uNB.GeI)
              {
                ad.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown finished but room id not the same, now room roomId:%d, before room roomId:%d", new Object[] { Integer.valueOf(this.uKI.roomId), Integer.valueOf(paramObject.uNB.GeI) });
                AppMethodBeat.o(25379);
                return true;
              }
              if ((paramInt2 == 0) && (paramInt3 == 0))
              {
                ad.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown success!");
                this.uKI.kHC = 5;
              }
              else
              {
                ad.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown failed");
              }
            }
          }
        }
        if (!(paramObject instanceof cmz))
        {
          ad.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo notify result error");
          AppMethodBeat.o(25379);
          return true;
        }
        ad.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo notify finished");
        paramObject = (cmz)paramObject;
        if (this.uKI.roomId != paramObject.GeI)
        {
          ad.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown finished but room id not the same, now room roomId:%d, before room roomId:%d", new Object[] { Integer.valueOf(this.uKI.roomId), Integer.valueOf(paramObject.GeI) });
          AppMethodBeat.o(25379);
          return true;
        }
      } while ((paramInt2 != 0) || (paramInt3 != 0));
      this.uKI.uLN = paramObject.uLN;
      ad.d("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo updateNotifyCallInfo, UserStatuslist.size: %d", new Object[] { Integer.valueOf(paramObject.Hgo.size()) });
      paramObject = paramObject.Hgo.iterator();
      while (paramObject.hasNext())
      {
        localObject1 = (cni)paramObject.next();
        if (this.uKI.uLA != ((cni)localObject1).Hgx) {
          break label1537;
        }
        ad.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo update self userStatus, memberId: %d, status: %d, syncKey: %d", new Object[] { Integer.valueOf(this.uKI.uLA), Integer.valueOf(((cni)localObject1).Hgy), Integer.valueOf(((cni)localObject1).Hgz) });
        if (((cni)localObject1).Hgz > this.uKI.uLB)
        {
          this.uKI.uLB = ((cni)localObject1).Hgz;
          if (((cni)localObject1).Hgy != 0) {
            this.uKI.kHC = ((cni)localObject1).Hgy;
          }
        }
        label1448:
        if ((((cni)localObject1).qel == 404) || (((cni)localObject1).qel == 484))
        {
          ad.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo notify phonenumber invalid");
          this.uKI.uLG = true;
        }
        this.uKI.qem = ((cni)localObject1).qem;
        this.uKI.qel = ((cni)localObject1).qel;
        this.uKI.uLy = ((cni)localObject1).uLy;
        this.uKI.uLz = ((cni)localObject1).uLz;
      }
      label1537:
      ad.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo update others userStatus, memberId: %d, status: %d, syncKey: %d", new Object[] { Integer.valueOf(((cni)localObject1).Hgx), Integer.valueOf(((cni)localObject1).Hgy), Integer.valueOf(((cni)localObject1).Hgz) });
      paramInt1 = 0;
      localObject2 = this.uKI.uLS.iterator();
      label1596:
      if (((Iterator)localObject2).hasNext())
      {
        com.tencent.mm.plugin.ipcall.model.b.d locald = (com.tencent.mm.plugin.ipcall.model.b.d)((Iterator)localObject2).next();
        if (locald.oWb != ((cni)localObject1).Hgx) {
          break label2539;
        }
        if (((cni)localObject1).Hgz > locald.uLB)
        {
          locald.uLB = ((cni)localObject1).Hgz;
          if (((cni)localObject1).Hgy != 0) {
            locald.gAx = ((cni)localObject1).Hgy;
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
      ((com.tencent.mm.plugin.ipcall.model.b.d)localObject2).oWb = ((cni)localObject1).Hgx;
      ((com.tencent.mm.plugin.ipcall.model.b.d)localObject2).gAx = ((cni)localObject1).Hgy;
      ((com.tencent.mm.plugin.ipcall.model.b.d)localObject2).uLB = ((cni)localObject1).Hgz;
      this.uKI.uLS.add(localObject2);
      break label1448;
      if (!(paramObject instanceof k))
      {
        ad.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo redirect result error");
        AppMethodBeat.o(25379);
        return true;
      }
      paramObject = (k)paramObject;
      localObject1 = paramObject.uNw;
      if (this.uKI.roomId != paramObject.uNv.GeI)
      {
        ad.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo redirect finished but room id not the same, now room roomId:%d, before room roomId:%d", new Object[] { Integer.valueOf(this.uKI.roomId), Integer.valueOf(paramObject.uNv.GeI) });
        AppMethodBeat.o(25379);
        return true;
      }
      if ((paramInt2 == 0) && (paramInt3 == 0))
      {
        ad.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo redirect success");
        this.uKI.nvX = ((cnb)localObject1).FAy;
        this.uKI.uLQ = ((cnb)localObject1).Hgk;
        break;
      }
      ad.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo redirect failed");
      break;
      if (!(paramObject instanceof o))
      {
        ad.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync result error");
        AppMethodBeat.o(25379);
        return true;
      }
      ad.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync finished errType:%d,errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      localObject1 = (o)paramObject;
      paramObject = ((o)localObject1).uNE;
      if (this.uKI.roomId != ((o)localObject1).uND.GeI)
      {
        ad.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync finished but room id not the same, now room roomId:%d, before room roomId:%d", new Object[] { Integer.valueOf(this.uKI.roomId), Integer.valueOf(((o)localObject1).uND.GeI) });
        AppMethodBeat.o(25379);
        return true;
      }
      if ((paramInt2 != 0) || (paramInt3 != 0)) {
        break;
      }
      ad.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync roomId: %d, status: %d, memberId: %d, syncKey: %d", new Object[] { Integer.valueOf(paramObject.GeI), Integer.valueOf(paramObject.Hgw), Integer.valueOf(paramObject.Hgx), Integer.valueOf(paramObject.Hgu) });
      if ((paramObject.GeI != this.uKI.roomId) || (paramObject.GeJ != this.uKI.uLt)) {
        break;
      }
      if (paramObject.Hgx == this.uKI.uLA)
      {
        ad.d("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync update self status");
        if (paramObject.Hgu > this.uKI.uLB)
        {
          this.uKI.uLB = paramObject.Hgu;
          if (paramObject.Hgw != 0) {
            this.uKI.kHC = paramObject.Hgw;
          }
        }
      }
      for (;;)
      {
        label2170:
        if ((paramObject.qel == 404) || (paramObject.qel == 484))
        {
          ad.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync phonenumber invalid");
          this.uKI.uLG = true;
        }
        this.uKI.qem = paramObject.qem;
        this.uKI.qel = paramObject.qel;
        this.uKI.uLy = paramObject.uLy;
        this.uKI.uLz = paramObject.uLz;
        this.uKI.uLN = paramObject.uLN;
        break;
        ad.d("MicroMsg.IPCallSvrLogic", " handleServiceResultCallInfosync update others status");
        localObject1 = this.uKI.uLS.iterator();
        paramInt1 = 0;
        label2286:
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (com.tencent.mm.plugin.ipcall.model.b.d)((Iterator)localObject1).next();
          if (((com.tencent.mm.plugin.ipcall.model.b.d)localObject2).oWb != paramObject.Hgx) {
            break label2536;
          }
          if (paramObject.Hgu > ((com.tencent.mm.plugin.ipcall.model.b.d)localObject2).uLB)
          {
            ((com.tencent.mm.plugin.ipcall.model.b.d)localObject2).uLB = paramObject.Hgu;
            if (paramObject.Hgw != 0) {
              ((com.tencent.mm.plugin.ipcall.model.b.d)localObject2).gAx = paramObject.Hgw;
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
          ((com.tencent.mm.plugin.ipcall.model.b.d)localObject1).oWb = paramObject.Hgx;
          ((com.tencent.mm.plugin.ipcall.model.b.d)localObject1).gAx = paramObject.Hgw;
          ((com.tencent.mm.plugin.ipcall.model.b.d)localObject1).uLB = paramObject.Hgu;
          this.uKI.uLS.add(localObject1);
          break label2170;
          if (!(paramObject instanceof com.tencent.mm.plugin.ipcall.model.e.h))
          {
            ad.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo heartbeat result error");
            AppMethodBeat.o(25379);
            return true;
          }
          ad.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo heartbeat finished errType:%d,errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
          paramObject = (com.tencent.mm.plugin.ipcall.model.e.h)paramObject;
          if (this.uKI.roomId == paramObject.uNp.GeI) {
            break;
          }
          ad.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo heartbeat finished but room id not the same, now room roomId:%d, before room roomId:%d", new Object[] { Integer.valueOf(this.uKI.roomId), Integer.valueOf(paramObject.uNp.GeI) });
          AppMethodBeat.o(25379);
          return true;
        }
      }
    }
  }
  
  private void nC(boolean paramBoolean)
  {
    AppMethodBeat.i(25367);
    ad.i("MicroMsg.IPCallSvrLogic", "handleInvite, success: %b, isLaunchCancel: %b, isLaunchShutdown: %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.uKx), Boolean.valueOf(this.uKy) });
    if ((this.uKx) || (this.uKy))
    {
      ad.i("MicroMsg.IPCallSvrLogic", "handleInvite, ignore this");
      AppMethodBeat.o(25367);
      return;
    }
    if (paramBoolean)
    {
      if (this.uKz != null)
      {
        if (this.uKI.uLH) {
          break label130;
        }
        this.uKz.ddb();
      }
      for (;;)
      {
        ad.i("MicroMsg.IPCallSvrLogic", "start sync");
        this.uKB.a(this.uKI);
        AppMethodBeat.o(25367);
        return;
        label130:
        this.uKz.dcW();
      }
    }
    if (this.uKz != null)
    {
      if (this.uKI.uLE)
      {
        this.uKz.W(this.uKI.uLz, this.uKI.qem, this.uKI.uLy);
        AppMethodBeat.o(25367);
        return;
      }
      if (this.uKI.uLF)
      {
        this.uKz.X(this.uKI.uLz, this.uKI.qem, this.uKI.uLy);
        AppMethodBeat.o(25367);
        return;
      }
      if (this.uKI.uLG)
      {
        this.uKz.Y(this.uKI.uLz, this.uKI.qem, this.uKI.uLy);
        AppMethodBeat.o(25367);
        return;
      }
      if (!this.uKI.uLH)
      {
        this.uKz.ddb();
        AppMethodBeat.o(25367);
        return;
      }
      this.uKz.V(this.uKI.uLz, this.uKI.qem, this.uKI.uLy);
    }
    AppMethodBeat.o(25367);
  }
  
  private void nD(boolean paramBoolean)
  {
    AppMethodBeat.i(25368);
    ad.i("MicroMsg.IPCallSvrLogic", "handleHeartbeat, success: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      this.uKu += 1;
      if (this.uKu >= 2)
      {
        ad.e("MicroMsg.IPCallSvrLogic", "heartbeat failed twice!");
        this.uKE.stop();
        if ((i.ddK().ddC()) && (this.uKz != null))
        {
          this.uKz.dda();
          AppMethodBeat.o(25368);
        }
      }
    }
    else
    {
      this.uKu = 0;
    }
    AppMethodBeat.o(25368);
  }
  
  private void nE(boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(25371);
    ad.i("MicroMsg.IPCallSvrLogic", "handleSync, success: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((paramBoolean) && (i.ddH().uMv)) {
      i.ddH().IC(this.uKI.uLN);
    }
    if (!paramBoolean)
    {
      ad.e("MicroMsg.IPCallSvrLogic", "sync failed!");
      this.uKB.stop();
      if (i.ddK().lpU == 3) {}
      for (;;)
      {
        if ((i != 0) && (this.uKz != null)) {
          this.uKz.dW(this.uKI.qem, this.uKI.uLy);
        }
        AppMethodBeat.o(25371);
        return;
        i = 0;
      }
    }
    if ((this.uKI != null) && (paramBoolean)) {
      IB(this.uKI.ddX());
    }
    AppMethodBeat.o(25371);
  }
  
  private void nF(boolean paramBoolean)
  {
    AppMethodBeat.i(25372);
    ad.i("MicroMsg.IPCallSvrLogic", "handleNotify, success: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((paramBoolean) && (i.ddH().uMv)) {
      i.ddH().IC(this.uKI.uLN);
    }
    if ((this.uKI != null) && (paramBoolean))
    {
      int i = this.uKI.ddX();
      if ((i == 2) || (i == 1))
      {
        if (!this.uKK)
        {
          o localo = new o(this.uKI.roomId, this.uKI.uLt, this.uKI.ddW(), this.uKI.uLu, false);
          ba.aiU().a(localo, 0);
        }
      }
      else {
        IB(this.uKI.ddX());
      }
    }
    else
    {
      AppMethodBeat.o(25372);
      return;
    }
    ad.i("MicroMsg.IPCallSvrLogic", "current status has jni accepted, ignore notify accept");
    AppMethodBeat.o(25372);
  }
  
  private void nG(boolean paramBoolean)
  {
    AppMethodBeat.i(25374);
    ad.i("MicroMsg.IPCallSvrLogic", "handleRedirect, isSuccess: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    com.tencent.mm.plugin.ipcall.model.d.a locala;
    Object localObject1;
    Object localObject2;
    if (paramBoolean)
    {
      locala = i.ddH();
      localObject1 = this.uKI;
      ad.i("MicroMsg.IPCallEngineManager", "redirectSvrAddr");
      if ((localObject1 != null) && (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).nvX != null) && (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).nvX.size() > 0)) {
        com.tencent.mm.plugin.ipcall.a.c.aH(((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).nvX);
      }
      if ((localObject1 != null) && (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).uLQ != null) && (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).uLQ.size() > 0)) {
        com.tencent.mm.plugin.ipcall.a.c.aH(((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).uLQ);
      }
      localObject2 = new ctc();
      ctb localctb = new ctb();
      localctb.GcK = 0;
      localctb.GcL = "";
      localctb.GcM = "";
      localctb.GcN = 4;
      localctb.GcO = 4;
      localctb.GcP = 2;
      localctb.Hlp = new dwt();
      localctb.Hlq = new dwt();
      if ((localObject1 != null) && (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).nvX != null) && (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).nvX.size() > 0)) {
        localctb.Hlp = com.tencent.mm.plugin.ipcall.a.c.aH(((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).nvX);
      }
      if ((localObject1 != null) && (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).uLQ != null) && (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).uLQ.size() > 0)) {
        localctb.Hlq = com.tencent.mm.plugin.ipcall.a.c.aH(((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).uLQ);
      }
      ((ctc)localObject2).Hls.add(localctb);
      ((ctc)localObject2).Hlr = 1;
      localObject1 = null;
    }
    try
    {
      localObject2 = ((ctc)localObject2).toByteArray();
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i;
        ad.e("MicroMsg.IPCallEngineManager", "conn info to byte array fail..");
      }
    }
    if (localObject1 != null)
    {
      i = locala.uMs.AddNewRelayConns((byte[])localObject1, localObject1.length, 1);
      if (i != 0) {
        com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.IPCallEngineManager", "redirect relay conns fail ret:".concat(String.valueOf(i)));
      }
    }
    AppMethodBeat.o(25374);
  }
  
  public final void IA(int paramInt)
  {
    AppMethodBeat.i(25366);
    if (!this.uKI.uLX) {
      ad.e("MicroMsg.IPCallSvrLogic", "shutdownIPCall, user not accept");
    }
    ad.i("MicroMsg.IPCallSvrLogic", "shutdownIPCall, roomId: %d, inviteId: %d", new Object[] { Integer.valueOf(this.uKI.roomId), Integer.valueOf(this.uKI.uLv) });
    this.uKy = true;
    this.uKE.stop();
    this.uKB.stop();
    this.uKD.uOn = false;
    this.uKD.uOm = paramInt;
    this.uKD.a(this.uKI);
    this.uKG.a(this.uKI);
    AppMethodBeat.o(25366);
  }
  
  public final boolean IB(int paramInt)
  {
    AppMethodBeat.i(25373);
    switch (paramInt)
    {
    default: 
      ad.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, do nothing:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(25373);
      return false;
    case 2: 
      ad.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, user accept, isLaunchCancel: %b, isLaunchShutdown: %b", new Object[] { Boolean.valueOf(this.uKx), Boolean.valueOf(this.uKy) });
      if ((this.uKx) || (this.uKy))
      {
        AppMethodBeat.o(25373);
        return true;
      }
      this.uKB.stop();
      if (!this.dDV)
      {
        this.dDV = true;
        if (this.uKI != null) {
          this.uKI.uLX = true;
        }
        if (this.uKz != null) {
          this.uKz.dcY();
        }
        this.uKE.a(this.uKI);
      }
      AppMethodBeat.o(25373);
      return true;
    case 3: 
      ad.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, user busy");
      this.uKB.stop();
      this.uKE.stop();
      if (this.uKz != null) {
        this.uKz.dV(this.uKI.qem, this.uKI.uLy);
      }
      AppMethodBeat.o(25373);
      return true;
    case 1: 
      ad.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, user ringing");
      if (!this.uKJ)
      {
        this.uKJ = true;
        if (this.uKz != null) {
          this.uKz.dcX();
        }
      }
      AppMethodBeat.o(25373);
      return true;
    case 5: 
      ad.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, other side user shutdown");
      if (this.uKz != null) {
        this.uKz.dcZ();
      }
      AppMethodBeat.o(25373);
      return true;
    case 4: 
    case 7: 
    case 8: 
      ad.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, user unavailable");
      if (this.uKI.uLG) {
        if (this.uKz != null) {
          this.uKz.Y(this.uKI.uLz, this.uKI.qem, this.uKI.uLy);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(25373);
        return true;
        if (this.uKz != null) {
          this.uKz.dU(this.uKI.qem, this.uKI.uLy);
        }
      }
    }
    ad.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, shutdown overdue");
    this.uKI.uLE = true;
    if (this.uKz != null) {
      this.uKz.W(this.uKI.uLz, this.uKI.qem, this.uKI.uLy);
    }
    AppMethodBeat.o(25373);
    return true;
  }
  
  public final void a(int paramInt1, com.tencent.mm.al.n paramn, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(25377);
    if (c(paramInt1, paramn, paramInt2, paramInt3))
    {
      ad.i("MicroMsg.IPCallSvrLogic", "onTimerSuccess different room ignore");
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
      nE(true);
      AppMethodBeat.o(25377);
      return;
      nD(true);
    }
  }
  
  public final void a(int paramInt1, Object paramObject, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(25375);
    if (c(paramInt1, paramObject, paramInt2, paramInt3))
    {
      ad.i("MicroMsg.IPCallSvrLogic", "onServiceResult different room ignore");
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
      nC(true);
      AppMethodBeat.o(25375);
      return;
      G(true, paramInt3);
      AppMethodBeat.o(25375);
      return;
      H(true, paramInt3);
      AppMethodBeat.o(25375);
      return;
      nF(true);
      AppMethodBeat.o(25375);
      return;
      nG(true);
    }
  }
  
  public final void b(int paramInt1, com.tencent.mm.al.n paramn, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(25378);
    if (c(paramInt1, paramn, paramInt2, paramInt3))
    {
      ad.i("MicroMsg.IPCallSvrLogic", "onTimerFailed different room ignore");
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
      nE(false);
      AppMethodBeat.o(25378);
      return;
      nD(false);
    }
  }
  
  public final void b(int paramInt1, Object paramObject, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(25376);
    if (c(paramInt1, paramObject, paramInt2, paramInt3))
    {
      ad.i("MicroMsg.IPCallSvrLogic", "onServiceFailed different room ignore");
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
      nC(false);
      AppMethodBeat.o(25376);
      return;
      G(false, paramInt3);
      AppMethodBeat.o(25376);
      return;
      H(false, paramInt3);
      AppMethodBeat.o(25376);
      return;
      nF(false);
      AppMethodBeat.o(25376);
      return;
      nG(false);
    }
  }
  
  public final void ddD()
  {
    AppMethodBeat.i(25365);
    if (this.uKI.uLX) {
      ad.e("MicroMsg.IPCallSvrLogic", "cancelIPCall, already accept");
    }
    this.uKx = true;
    ad.i("MicroMsg.IPCallSvrLogic", "cancelIPCall, roomId: %d, inviteId: %d", new Object[] { Integer.valueOf(this.uKI.roomId), Integer.valueOf(this.uKI.uLv) });
    this.uKE.stop();
    this.uKB.stop();
    this.uKC.a(this.uKI);
    this.uKG.a(this.uKI);
    AppMethodBeat.o(25365);
  }
  
  public static abstract interface a
  {
    public abstract void V(String paramString1, String paramString2, int paramInt);
    
    public abstract void W(String paramString1, String paramString2, int paramInt);
    
    public abstract void X(String paramString1, String paramString2, int paramInt);
    
    public abstract void Y(String paramString1, String paramString2, int paramInt);
    
    public abstract void dU(String paramString, int paramInt);
    
    public abstract void dV(String paramString, int paramInt);
    
    public abstract void dW(String paramString, int paramInt);
    
    public abstract void dcW();
    
    public abstract void dcX();
    
    public abstract void dcY();
    
    public abstract void dcZ();
    
    public abstract void dda();
    
    public abstract void ddb();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.g
 * JD-Core Version:    0.7.0.1
 */