package com.tencent.mm.plugin.ipcall.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bc;
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
import com.tencent.mm.protocal.protobuf.cnl;
import com.tencent.mm.protocal.protobuf.cnp;
import com.tencent.mm.protocal.protobuf.cnr;
import com.tencent.mm.protocal.protobuf.cns;
import com.tencent.mm.protocal.protobuf.cnt;
import com.tencent.mm.protocal.protobuf.cnu;
import com.tencent.mm.protocal.protobuf.cnv;
import com.tencent.mm.protocal.protobuf.cny;
import com.tencent.mm.protocal.protobuf.coa;
import com.tencent.mm.protocal.protobuf.cob;
import com.tencent.mm.protocal.protobuf.coc;
import com.tencent.mm.protocal.protobuf.ctv;
import com.tencent.mm.protocal.protobuf.ctw;
import com.tencent.mm.protocal.protobuf.dyk;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.LinkedList;

public final class g
  implements a.a, b.a
{
  public boolean dFa;
  public int uWh;
  public int uWi;
  public int uWj;
  public boolean uWk;
  public boolean uWl;
  public a uWm;
  public com.tencent.mm.plugin.ipcall.model.g.d uWn;
  com.tencent.mm.plugin.ipcall.model.g.i uWo;
  com.tencent.mm.plugin.ipcall.model.g.a uWp;
  com.tencent.mm.plugin.ipcall.model.g.h uWq;
  com.tencent.mm.plugin.ipcall.model.g.c uWr;
  public e uWs;
  com.tencent.mm.plugin.ipcall.model.g.g uWt;
  com.tencent.mm.plugin.ipcall.model.g.f uWu;
  public com.tencent.mm.plugin.ipcall.model.b.c uWv;
  public boolean uWw;
  public boolean uWx;
  com.tencent.mm.network.n uWy;
  
  public g()
  {
    AppMethodBeat.i(25364);
    this.uWh = 0;
    this.uWi = 0;
    this.uWj = 0;
    this.uWk = false;
    this.uWl = false;
    this.uWw = false;
    this.dFa = false;
    this.uWx = false;
    this.uWy = new n.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        int i = 0;
        AppMethodBeat.i(25363);
        ae.i("MicroMsg.IPCallSvrLogic", "onNetworkChange, st: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (i.dgz().uYi)
        {
          f localf = i.dgC();
          if ((localf.lur == 4) || (localf.lur == 5)) {
            i = 1;
          }
          if ((i != 0) && (paramAnonymousInt == 4) && (g.this.uWu != null)) {
            g.this.uWu.a(g.this.uWv);
          }
        }
        AppMethodBeat.o(25363);
      }
    };
    this.uWn = new com.tencent.mm.plugin.ipcall.model.g.d();
    this.uWo = new com.tencent.mm.plugin.ipcall.model.g.i();
    this.uWp = new com.tencent.mm.plugin.ipcall.model.g.a();
    this.uWq = new com.tencent.mm.plugin.ipcall.model.g.h();
    this.uWr = new com.tencent.mm.plugin.ipcall.model.g.c();
    this.uWs = new e();
    this.uWt = new com.tencent.mm.plugin.ipcall.model.g.g();
    this.uWu = new com.tencent.mm.plugin.ipcall.model.g.f();
    AppMethodBeat.o(25364);
  }
  
  private void I(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(25369);
    ae.i("MicroMsg.IPCallSvrLogic", "handleCancel, success: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((!paramBoolean) && (paramInt < 0) && (this.uWj <= 0))
    {
      this.uWj += 1;
      ae.i("MicroMsg.IPCallSvrLogic", "cancel failed, retry count: %d", new Object[] { Integer.valueOf(this.uWj) });
      this.uWp.a(this.uWv);
      AppMethodBeat.o(25369);
      return;
    }
    AppMethodBeat.o(25369);
  }
  
  private void J(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(25370);
    ae.i("MicroMsg.IPCallSvrLogic", "handleUserSelfShutdown, success: %b, isFromNotify: %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.uWq.vaa) });
    if ((!paramBoolean) && (paramInt < 0) && (this.uWi <= 0))
    {
      this.uWi += 1;
      ae.i("MicroMsg.IPCallSvrLogic", "shutdown failed, retry count: %d, isFromNotify: %b", new Object[] { Integer.valueOf(this.uWi), Boolean.valueOf(this.uWq.vaa) });
      this.uWq.a(this.uWv);
      AppMethodBeat.o(25370);
      return;
    }
    AppMethodBeat.o(25370);
  }
  
  private boolean c(int paramInt1, Object paramObject, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(25379);
    if ((this.uWv == null) || (paramObject == null))
    {
      ae.e("MicroMsg.IPCallSvrLogic", "callInfo = null or result = null");
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
            ae.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo invited result error");
            AppMethodBeat.o(25379);
            return true;
          }
          paramObject = (com.tencent.mm.plugin.ipcall.model.e.i)paramObject;
          localObject1 = paramObject.uZf;
          if (this.uWv.uXi != paramObject.uZe.Hzx)
          {
            ae.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo invited finished but invite id not the same, now room inviteId:%d, before room inviteId:%d", new Object[] { Integer.valueOf(this.uWv.uXi), Integer.valueOf(paramObject.uZe.Hzx) });
            AppMethodBeat.o(25379);
            return true;
          }
          ae.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo invited finished invite id:%d", new Object[] { Integer.valueOf(this.uWv.uXi) });
          i.dgA().gs(this.uWv.uXi, paramInt3);
          if ((paramInt2 == 0) && (paramInt3 == 0))
          {
            if (this.uWv != null)
            {
              this.uWv.roomId = ((cns)localObject1).Gxq;
              this.uWv.uXg = ((cns)localObject1).Gxr;
              this.uWv.uXh = ((cns)localObject1).Hzz;
              this.uWv.uXn = ((cns)localObject1).HzI;
              this.uWv.uXp = (((cns)localObject1).HzJ * 1000);
              this.uWv.uXw = ((cns)localObject1).uXw;
              this.uWv.uXx = ((cns)localObject1).uXx;
              this.uWv.nBs = ((cns)localObject1).FSU;
              this.uWv.uXD = ((cns)localObject1).HzK;
              this.uWv.uXI = ((cns)localObject1).HzL;
              if (((cns)localObject1).uXE > 0) {
                this.uWv.uXE = ((cns)localObject1).uXE;
              }
              this.uWv.uXy = ((cns)localObject1).uXy;
              this.uWv.uXz = ((cns)localObject1).uXz;
              this.uWv.uXv = ((cns)localObject1).HzN;
              if (((cns)localObject1).uXB > 0)
              {
                this.uWv.uXB = (((cns)localObject1).uXB - 1);
                ae.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo zhengxue[ENCRYPT] got encryptStrategy[" + this.uWv.uXB + "] from Invite resp");
                this.uWv.uXC = ((cns)localObject1).HzM;
                ae.d("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo NextInvite:%d", new Object[] { Integer.valueOf(((cns)localObject1).uXq) });
                if (((cns)localObject1).uXq <= 0) {
                  break label613;
                }
                this.uWv.uXu = false;
              }
              for (this.uWv.uXq = ((cns)localObject1).uXq;; this.uWv.uXq = 0)
              {
                this.uWv.uXm = ((cns)localObject1).uXm;
                this.uWv.uXl = ((cns)localObject1).uXl;
                this.uWv.qkQ = paramInt3;
                this.uWv.qkR = bu.nullAsNil(z.a(((cns)localObject1).BaseResponse.ErrMsg));
                break;
                ae.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo zhengxue[ENCRYPT] got no encryptStrategy from Invite resp");
                this.uWv.uXB = 2;
                break label474;
                this.uWv.uXu = true;
              }
            }
          }
          else
          {
            ae.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo invite failed");
            if (((cns)localObject1).BaseResponse != null)
            {
              if (paramInt3 == 433)
              {
                ae.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo account overdue");
                this.uWv.uXr = true;
                if (((cns)localObject1).uXq <= 0) {
                  break label860;
                }
                this.uWv.uXu = false;
              }
              for (this.uWv.uXq = ((cns)localObject1).uXq;; this.uWv.uXq = 0)
              {
                this.uWv.uXm = ((cns)localObject1).uXm;
                this.uWv.uXl = ((cns)localObject1).uXl;
                this.uWv.qkQ = paramInt3;
                if (((cns)localObject1).getBaseResponse() == null) {
                  break;
                }
                this.uWv.qkR = bu.nullAsNil(z.a(((cns)localObject1).BaseResponse.ErrMsg));
                ae.d("MicroMsg.IPCallSvrLogic", "ErrLevel:%d,ErrCode:%d,ErrMsg:%s", new Object[] { Integer.valueOf(((cns)localObject1).uXl), Integer.valueOf(paramInt3), this.uWv.qkR });
                break;
                if (paramInt3 == 434)
                {
                  ae.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo restrict call");
                  this.uWv.uXs = true;
                  break label672;
                }
                if (paramInt3 != 435) {
                  break label672;
                }
                ae.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo phonenumber invalid");
                this.uWv.uXt = true;
                break label672;
                this.uWv.uXu = true;
              }
            }
            this.uWv.uXm = "";
            this.uWv.uXl = 2;
            this.uWv.qkR = ak.getContext().getString(2131756764);
            this.uWv.qkQ = paramInt3;
            continue;
            if (!(paramObject instanceof com.tencent.mm.plugin.ipcall.model.e.a))
            {
              ae.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo cancel result error");
              AppMethodBeat.o(25379);
              return true;
            }
            ae.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo cancel finished errType:%d,errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
            paramObject = (com.tencent.mm.plugin.ipcall.model.e.a)paramObject;
            if (this.uWv.uXi != paramObject.uYN.Hzx)
            {
              ae.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo cancel finished but invite id not the same, now room inviteId:%d, before room inviteId:%d", new Object[] { Integer.valueOf(this.uWv.uXi), Integer.valueOf(paramObject.uYN.Hzx) });
              AppMethodBeat.o(25379);
              return true;
              if (!(paramObject instanceof com.tencent.mm.plugin.ipcall.model.e.n))
              {
                ae.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown result error");
                AppMethodBeat.o(25379);
                return true;
              }
              paramObject = (com.tencent.mm.plugin.ipcall.model.e.n)paramObject;
              if (this.uWv.roomId != paramObject.uZo.Gxq)
              {
                ae.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown finished but room id not the same, now room roomId:%d, before room roomId:%d", new Object[] { Integer.valueOf(this.uWv.roomId), Integer.valueOf(paramObject.uZo.Gxq) });
                AppMethodBeat.o(25379);
                return true;
              }
              if ((paramInt2 == 0) && (paramInt3 == 0))
              {
                ae.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown success!");
                this.uWv.kKR = 5;
              }
              else
              {
                ae.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown failed");
              }
            }
          }
        }
        if (!(paramObject instanceof cnt))
        {
          ae.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo notify result error");
          AppMethodBeat.o(25379);
          return true;
        }
        ae.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo notify finished");
        paramObject = (cnt)paramObject;
        if (this.uWv.roomId != paramObject.Gxq)
        {
          ae.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown finished but room id not the same, now room roomId:%d, before room roomId:%d", new Object[] { Integer.valueOf(this.uWv.roomId), Integer.valueOf(paramObject.Gxq) });
          AppMethodBeat.o(25379);
          return true;
        }
      } while ((paramInt2 != 0) || (paramInt3 != 0));
      this.uWv.uXA = paramObject.uXA;
      ae.d("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo updateNotifyCallInfo, UserStatuslist.size: %d", new Object[] { Integer.valueOf(paramObject.HzO.size()) });
      paramObject = paramObject.HzO.iterator();
      while (paramObject.hasNext())
      {
        localObject1 = (coc)paramObject.next();
        if (this.uWv.uXn != ((coc)localObject1).HzX) {
          break label1537;
        }
        ae.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo update self userStatus, memberId: %d, status: %d, syncKey: %d", new Object[] { Integer.valueOf(this.uWv.uXn), Integer.valueOf(((coc)localObject1).HzY), Integer.valueOf(((coc)localObject1).HzZ) });
        if (((coc)localObject1).HzZ > this.uWv.uXo)
        {
          this.uWv.uXo = ((coc)localObject1).HzZ;
          if (((coc)localObject1).HzY != 0) {
            this.uWv.kKR = ((coc)localObject1).HzY;
          }
        }
        label1448:
        if ((((coc)localObject1).qkQ == 404) || (((coc)localObject1).qkQ == 484))
        {
          ae.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo notify phonenumber invalid");
          this.uWv.uXt = true;
        }
        this.uWv.qkR = ((coc)localObject1).qkR;
        this.uWv.qkQ = ((coc)localObject1).qkQ;
        this.uWv.uXl = ((coc)localObject1).uXl;
        this.uWv.uXm = ((coc)localObject1).uXm;
      }
      label1537:
      ae.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo update others userStatus, memberId: %d, status: %d, syncKey: %d", new Object[] { Integer.valueOf(((coc)localObject1).HzX), Integer.valueOf(((coc)localObject1).HzY), Integer.valueOf(((coc)localObject1).HzZ) });
      paramInt1 = 0;
      localObject2 = this.uWv.uXF.iterator();
      label1596:
      if (((Iterator)localObject2).hasNext())
      {
        com.tencent.mm.plugin.ipcall.model.b.d locald = (com.tencent.mm.plugin.ipcall.model.b.d)((Iterator)localObject2).next();
        if (locald.pcE != ((coc)localObject1).HzX) {
          break label2539;
        }
        if (((coc)localObject1).HzZ > locald.uXo)
        {
          locald.uXo = ((coc)localObject1).HzZ;
          if (((coc)localObject1).HzY != 0) {
            locald.gDe = ((coc)localObject1).HzY;
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
      ((com.tencent.mm.plugin.ipcall.model.b.d)localObject2).pcE = ((coc)localObject1).HzX;
      ((com.tencent.mm.plugin.ipcall.model.b.d)localObject2).gDe = ((coc)localObject1).HzY;
      ((com.tencent.mm.plugin.ipcall.model.b.d)localObject2).uXo = ((coc)localObject1).HzZ;
      this.uWv.uXF.add(localObject2);
      break label1448;
      if (!(paramObject instanceof k))
      {
        ae.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo redirect result error");
        AppMethodBeat.o(25379);
        return true;
      }
      paramObject = (k)paramObject;
      localObject1 = paramObject.uZj;
      if (this.uWv.roomId != paramObject.uZi.Gxq)
      {
        ae.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo redirect finished but room id not the same, now room roomId:%d, before room roomId:%d", new Object[] { Integer.valueOf(this.uWv.roomId), Integer.valueOf(paramObject.uZi.Gxq) });
        AppMethodBeat.o(25379);
        return true;
      }
      if ((paramInt2 == 0) && (paramInt3 == 0))
      {
        ae.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo redirect success");
        this.uWv.nBs = ((cnv)localObject1).FSU;
        this.uWv.uXD = ((cnv)localObject1).HzK;
        break;
      }
      ae.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo redirect failed");
      break;
      if (!(paramObject instanceof o))
      {
        ae.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync result error");
        AppMethodBeat.o(25379);
        return true;
      }
      ae.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync finished errType:%d,errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      localObject1 = (o)paramObject;
      paramObject = ((o)localObject1).uZr;
      if (this.uWv.roomId != ((o)localObject1).uZq.Gxq)
      {
        ae.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync finished but room id not the same, now room roomId:%d, before room roomId:%d", new Object[] { Integer.valueOf(this.uWv.roomId), Integer.valueOf(((o)localObject1).uZq.Gxq) });
        AppMethodBeat.o(25379);
        return true;
      }
      if ((paramInt2 != 0) || (paramInt3 != 0)) {
        break;
      }
      ae.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync roomId: %d, status: %d, memberId: %d, syncKey: %d", new Object[] { Integer.valueOf(paramObject.Gxq), Integer.valueOf(paramObject.HzW), Integer.valueOf(paramObject.HzX), Integer.valueOf(paramObject.HzU) });
      if ((paramObject.Gxq != this.uWv.roomId) || (paramObject.Gxr != this.uWv.uXg)) {
        break;
      }
      if (paramObject.HzX == this.uWv.uXn)
      {
        ae.d("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync update self status");
        if (paramObject.HzU > this.uWv.uXo)
        {
          this.uWv.uXo = paramObject.HzU;
          if (paramObject.HzW != 0) {
            this.uWv.kKR = paramObject.HzW;
          }
        }
      }
      for (;;)
      {
        label2170:
        if ((paramObject.qkQ == 404) || (paramObject.qkQ == 484))
        {
          ae.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync phonenumber invalid");
          this.uWv.uXt = true;
        }
        this.uWv.qkR = paramObject.qkR;
        this.uWv.qkQ = paramObject.qkQ;
        this.uWv.uXl = paramObject.uXl;
        this.uWv.uXm = paramObject.uXm;
        this.uWv.uXA = paramObject.uXA;
        break;
        ae.d("MicroMsg.IPCallSvrLogic", " handleServiceResultCallInfosync update others status");
        localObject1 = this.uWv.uXF.iterator();
        paramInt1 = 0;
        label2286:
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (com.tencent.mm.plugin.ipcall.model.b.d)((Iterator)localObject1).next();
          if (((com.tencent.mm.plugin.ipcall.model.b.d)localObject2).pcE != paramObject.HzX) {
            break label2536;
          }
          if (paramObject.HzU > ((com.tencent.mm.plugin.ipcall.model.b.d)localObject2).uXo)
          {
            ((com.tencent.mm.plugin.ipcall.model.b.d)localObject2).uXo = paramObject.HzU;
            if (paramObject.HzW != 0) {
              ((com.tencent.mm.plugin.ipcall.model.b.d)localObject2).gDe = paramObject.HzW;
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
          ((com.tencent.mm.plugin.ipcall.model.b.d)localObject1).pcE = paramObject.HzX;
          ((com.tencent.mm.plugin.ipcall.model.b.d)localObject1).gDe = paramObject.HzW;
          ((com.tencent.mm.plugin.ipcall.model.b.d)localObject1).uXo = paramObject.HzU;
          this.uWv.uXF.add(localObject1);
          break label2170;
          if (!(paramObject instanceof com.tencent.mm.plugin.ipcall.model.e.h))
          {
            ae.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo heartbeat result error");
            AppMethodBeat.o(25379);
            return true;
          }
          ae.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo heartbeat finished errType:%d,errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
          paramObject = (com.tencent.mm.plugin.ipcall.model.e.h)paramObject;
          if (this.uWv.roomId == paramObject.uZc.Gxq) {
            break;
          }
          ae.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo heartbeat finished but room id not the same, now room roomId:%d, before room roomId:%d", new Object[] { Integer.valueOf(this.uWv.roomId), Integer.valueOf(paramObject.uZc.Gxq) });
          AppMethodBeat.o(25379);
          return true;
        }
      }
    }
  }
  
  private void nG(boolean paramBoolean)
  {
    AppMethodBeat.i(25367);
    ae.i("MicroMsg.IPCallSvrLogic", "handleInvite, success: %b, isLaunchCancel: %b, isLaunchShutdown: %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.uWk), Boolean.valueOf(this.uWl) });
    if ((this.uWk) || (this.uWl))
    {
      ae.i("MicroMsg.IPCallSvrLogic", "handleInvite, ignore this");
      AppMethodBeat.o(25367);
      return;
    }
    if (paramBoolean)
    {
      if (this.uWm != null)
      {
        if (this.uWv.uXu) {
          break label130;
        }
        this.uWm.dfT();
      }
      for (;;)
      {
        ae.i("MicroMsg.IPCallSvrLogic", "start sync");
        this.uWo.a(this.uWv);
        AppMethodBeat.o(25367);
        return;
        label130:
        this.uWm.dfO();
      }
    }
    if (this.uWm != null)
    {
      if (this.uWv.uXr)
      {
        this.uWm.W(this.uWv.uXm, this.uWv.qkR, this.uWv.uXl);
        AppMethodBeat.o(25367);
        return;
      }
      if (this.uWv.uXs)
      {
        this.uWm.X(this.uWv.uXm, this.uWv.qkR, this.uWv.uXl);
        AppMethodBeat.o(25367);
        return;
      }
      if (this.uWv.uXt)
      {
        this.uWm.Y(this.uWv.uXm, this.uWv.qkR, this.uWv.uXl);
        AppMethodBeat.o(25367);
        return;
      }
      if (!this.uWv.uXu)
      {
        this.uWm.dfT();
        AppMethodBeat.o(25367);
        return;
      }
      this.uWm.V(this.uWv.uXm, this.uWv.qkR, this.uWv.uXl);
    }
    AppMethodBeat.o(25367);
  }
  
  private void nH(boolean paramBoolean)
  {
    AppMethodBeat.i(25368);
    ae.i("MicroMsg.IPCallSvrLogic", "handleHeartbeat, success: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      this.uWh += 1;
      if (this.uWh >= 2)
      {
        ae.e("MicroMsg.IPCallSvrLogic", "heartbeat failed twice!");
        this.uWr.stop();
        if ((i.dgC().dgu()) && (this.uWm != null))
        {
          this.uWm.dfS();
          AppMethodBeat.o(25368);
        }
      }
    }
    else
    {
      this.uWh = 0;
    }
    AppMethodBeat.o(25368);
  }
  
  private void nI(boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(25371);
    ae.i("MicroMsg.IPCallSvrLogic", "handleSync, success: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((paramBoolean) && (i.dgz().uYi)) {
      i.dgz().Ja(this.uWv.uXA);
    }
    if (!paramBoolean)
    {
      ae.e("MicroMsg.IPCallSvrLogic", "sync failed!");
      this.uWo.stop();
      if (i.dgC().lur == 3) {}
      for (;;)
      {
        if ((i != 0) && (this.uWm != null)) {
          this.uWm.ec(this.uWv.qkR, this.uWv.uXl);
        }
        AppMethodBeat.o(25371);
        return;
        i = 0;
      }
    }
    if ((this.uWv != null) && (paramBoolean)) {
      IZ(this.uWv.dgP());
    }
    AppMethodBeat.o(25371);
  }
  
  private void nJ(boolean paramBoolean)
  {
    AppMethodBeat.i(25372);
    ae.i("MicroMsg.IPCallSvrLogic", "handleNotify, success: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((paramBoolean) && (i.dgz().uYi)) {
      i.dgz().Ja(this.uWv.uXA);
    }
    if ((this.uWv != null) && (paramBoolean))
    {
      int i = this.uWv.dgP();
      if ((i == 2) || (i == 1))
      {
        if (!this.uWx)
        {
          o localo = new o(this.uWv.roomId, this.uWv.uXg, this.uWv.dgO(), this.uWv.uXh, false);
          bc.ajj().a(localo, 0);
        }
      }
      else {
        IZ(this.uWv.dgP());
      }
    }
    else
    {
      AppMethodBeat.o(25372);
      return;
    }
    ae.i("MicroMsg.IPCallSvrLogic", "current status has jni accepted, ignore notify accept");
    AppMethodBeat.o(25372);
  }
  
  private void nK(boolean paramBoolean)
  {
    AppMethodBeat.i(25374);
    ae.i("MicroMsg.IPCallSvrLogic", "handleRedirect, isSuccess: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    com.tencent.mm.plugin.ipcall.model.d.a locala;
    Object localObject1;
    Object localObject2;
    if (paramBoolean)
    {
      locala = i.dgz();
      localObject1 = this.uWv;
      ae.i("MicroMsg.IPCallEngineManager", "redirectSvrAddr");
      if ((localObject1 != null) && (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).nBs != null) && (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).nBs.size() > 0)) {
        com.tencent.mm.plugin.ipcall.a.c.aH(((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).nBs);
      }
      if ((localObject1 != null) && (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).uXD != null) && (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).uXD.size() > 0)) {
        com.tencent.mm.plugin.ipcall.a.c.aH(((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).uXD);
      }
      localObject2 = new ctw();
      ctv localctv = new ctv();
      localctv.Gvr = 0;
      localctv.Gvs = "";
      localctv.Gvt = "";
      localctv.Gvu = 4;
      localctv.Gvv = 4;
      localctv.Gvw = 2;
      localctv.HEP = new dyk();
      localctv.HEQ = new dyk();
      if ((localObject1 != null) && (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).nBs != null) && (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).nBs.size() > 0)) {
        localctv.HEP = com.tencent.mm.plugin.ipcall.a.c.aH(((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).nBs);
      }
      if ((localObject1 != null) && (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).uXD != null) && (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).uXD.size() > 0)) {
        localctv.HEQ = com.tencent.mm.plugin.ipcall.a.c.aH(((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).uXD);
      }
      ((ctw)localObject2).HES.add(localctv);
      ((ctw)localObject2).HER = 1;
      localObject1 = null;
    }
    try
    {
      localObject2 = ((ctw)localObject2).toByteArray();
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i;
        ae.e("MicroMsg.IPCallEngineManager", "conn info to byte array fail..");
      }
    }
    if (localObject1 != null)
    {
      i = locala.uYf.AddNewRelayConns((byte[])localObject1, localObject1.length, 1);
      if (i != 0) {
        com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.IPCallEngineManager", "redirect relay conns fail ret:".concat(String.valueOf(i)));
      }
    }
    AppMethodBeat.o(25374);
  }
  
  public final void IY(int paramInt)
  {
    AppMethodBeat.i(25366);
    if (!this.uWv.uXK) {
      ae.e("MicroMsg.IPCallSvrLogic", "shutdownIPCall, user not accept");
    }
    ae.i("MicroMsg.IPCallSvrLogic", "shutdownIPCall, roomId: %d, inviteId: %d", new Object[] { Integer.valueOf(this.uWv.roomId), Integer.valueOf(this.uWv.uXi) });
    this.uWl = true;
    this.uWr.stop();
    this.uWo.stop();
    this.uWq.vaa = false;
    this.uWq.uZZ = paramInt;
    this.uWq.a(this.uWv);
    this.uWt.a(this.uWv);
    AppMethodBeat.o(25366);
  }
  
  public final boolean IZ(int paramInt)
  {
    AppMethodBeat.i(25373);
    switch (paramInt)
    {
    default: 
      ae.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, do nothing:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(25373);
      return false;
    case 2: 
      ae.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, user accept, isLaunchCancel: %b, isLaunchShutdown: %b", new Object[] { Boolean.valueOf(this.uWk), Boolean.valueOf(this.uWl) });
      if ((this.uWk) || (this.uWl))
      {
        AppMethodBeat.o(25373);
        return true;
      }
      this.uWo.stop();
      if (!this.dFa)
      {
        this.dFa = true;
        if (this.uWv != null) {
          this.uWv.uXK = true;
        }
        if (this.uWm != null) {
          this.uWm.dfQ();
        }
        this.uWr.a(this.uWv);
      }
      AppMethodBeat.o(25373);
      return true;
    case 3: 
      ae.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, user busy");
      this.uWo.stop();
      this.uWr.stop();
      if (this.uWm != null) {
        this.uWm.eb(this.uWv.qkR, this.uWv.uXl);
      }
      AppMethodBeat.o(25373);
      return true;
    case 1: 
      ae.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, user ringing");
      if (!this.uWw)
      {
        this.uWw = true;
        if (this.uWm != null) {
          this.uWm.dfP();
        }
      }
      AppMethodBeat.o(25373);
      return true;
    case 5: 
      ae.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, other side user shutdown");
      if (this.uWm != null) {
        this.uWm.dfR();
      }
      AppMethodBeat.o(25373);
      return true;
    case 4: 
    case 7: 
    case 8: 
      ae.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, user unavailable");
      if (this.uWv.uXt) {
        if (this.uWm != null) {
          this.uWm.Y(this.uWv.uXm, this.uWv.qkR, this.uWv.uXl);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(25373);
        return true;
        if (this.uWm != null) {
          this.uWm.ea(this.uWv.qkR, this.uWv.uXl);
        }
      }
    }
    ae.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, shutdown overdue");
    this.uWv.uXr = true;
    if (this.uWm != null) {
      this.uWm.W(this.uWv.uXm, this.uWv.qkR, this.uWv.uXl);
    }
    AppMethodBeat.o(25373);
    return true;
  }
  
  public final void a(int paramInt1, com.tencent.mm.ak.n paramn, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(25377);
    if (c(paramInt1, paramn, paramInt2, paramInt3))
    {
      ae.i("MicroMsg.IPCallSvrLogic", "onTimerSuccess different room ignore");
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
      nI(true);
      AppMethodBeat.o(25377);
      return;
      nH(true);
    }
  }
  
  public final void a(int paramInt1, Object paramObject, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(25375);
    if (c(paramInt1, paramObject, paramInt2, paramInt3))
    {
      ae.i("MicroMsg.IPCallSvrLogic", "onServiceResult different room ignore");
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
      nG(true);
      AppMethodBeat.o(25375);
      return;
      I(true, paramInt3);
      AppMethodBeat.o(25375);
      return;
      J(true, paramInt3);
      AppMethodBeat.o(25375);
      return;
      nJ(true);
      AppMethodBeat.o(25375);
      return;
      nK(true);
    }
  }
  
  public final void b(int paramInt1, com.tencent.mm.ak.n paramn, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(25378);
    if (c(paramInt1, paramn, paramInt2, paramInt3))
    {
      ae.i("MicroMsg.IPCallSvrLogic", "onTimerFailed different room ignore");
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
      nI(false);
      AppMethodBeat.o(25378);
      return;
      nH(false);
    }
  }
  
  public final void b(int paramInt1, Object paramObject, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(25376);
    if (c(paramInt1, paramObject, paramInt2, paramInt3))
    {
      ae.i("MicroMsg.IPCallSvrLogic", "onServiceFailed different room ignore");
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
      nG(false);
      AppMethodBeat.o(25376);
      return;
      I(false, paramInt3);
      AppMethodBeat.o(25376);
      return;
      J(false, paramInt3);
      AppMethodBeat.o(25376);
      return;
      nJ(false);
      AppMethodBeat.o(25376);
      return;
      nK(false);
    }
  }
  
  public final void dgv()
  {
    AppMethodBeat.i(25365);
    if (this.uWv.uXK) {
      ae.e("MicroMsg.IPCallSvrLogic", "cancelIPCall, already accept");
    }
    this.uWk = true;
    ae.i("MicroMsg.IPCallSvrLogic", "cancelIPCall, roomId: %d, inviteId: %d", new Object[] { Integer.valueOf(this.uWv.roomId), Integer.valueOf(this.uWv.uXi) });
    this.uWr.stop();
    this.uWo.stop();
    this.uWp.a(this.uWv);
    this.uWt.a(this.uWv);
    AppMethodBeat.o(25365);
  }
  
  public static abstract interface a
  {
    public abstract void V(String paramString1, String paramString2, int paramInt);
    
    public abstract void W(String paramString1, String paramString2, int paramInt);
    
    public abstract void X(String paramString1, String paramString2, int paramInt);
    
    public abstract void Y(String paramString1, String paramString2, int paramInt);
    
    public abstract void dfO();
    
    public abstract void dfP();
    
    public abstract void dfQ();
    
    public abstract void dfR();
    
    public abstract void dfS();
    
    public abstract void dfT();
    
    public abstract void ea(String paramString, int paramInt);
    
    public abstract void eb(String paramString, int paramInt);
    
    public abstract void ec(String paramString, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.g
 * JD-Core Version:    0.7.0.1
 */