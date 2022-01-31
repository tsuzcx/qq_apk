package com.tencent.mm.plugin.ipcall.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.ipcall.a.a.a.a;
import com.tencent.mm.plugin.ipcall.a.a.b.a;
import com.tencent.mm.plugin.ipcall.a.c.b;
import com.tencent.mm.plugin.ipcall.a.d.k;
import com.tencent.mm.plugin.ipcall.a.d.o;
import com.tencent.mm.plugin.ipcall.a.f.e;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bnz;
import com.tencent.mm.protocal.protobuf.bod;
import com.tencent.mm.protocal.protobuf.bof;
import com.tencent.mm.protocal.protobuf.bog;
import com.tencent.mm.protocal.protobuf.boh;
import com.tencent.mm.protocal.protobuf.boi;
import com.tencent.mm.protocal.protobuf.boj;
import com.tencent.mm.protocal.protobuf.bom;
import com.tencent.mm.protocal.protobuf.boo;
import com.tencent.mm.protocal.protobuf.bop;
import com.tencent.mm.protocal.protobuf.boq;
import com.tencent.mm.protocal.protobuf.crn;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;

public final class g
  implements a.a, b.a
{
  public boolean cDO;
  public int nMe;
  public int nMf;
  public int nMg;
  public boolean nMh;
  public boolean nMi;
  public g.a nMj;
  public com.tencent.mm.plugin.ipcall.a.f.d nMk;
  com.tencent.mm.plugin.ipcall.a.f.i nMl;
  com.tencent.mm.plugin.ipcall.a.f.a nMm;
  com.tencent.mm.plugin.ipcall.a.f.h nMn;
  com.tencent.mm.plugin.ipcall.a.f.c nMo;
  public e nMp;
  com.tencent.mm.plugin.ipcall.a.f.g nMq;
  com.tencent.mm.plugin.ipcall.a.f.f nMr;
  public com.tencent.mm.plugin.ipcall.a.a.c nMs;
  public boolean nMt;
  public boolean nMu;
  com.tencent.mm.network.n nMv;
  
  public g()
  {
    AppMethodBeat.i(21744);
    this.nMe = 0;
    this.nMf = 0;
    this.nMg = 0;
    this.nMh = false;
    this.nMi = false;
    this.nMt = false;
    this.cDO = false;
    this.nMu = false;
    this.nMv = new g.1(this);
    this.nMk = new com.tencent.mm.plugin.ipcall.a.f.d();
    this.nMl = new com.tencent.mm.plugin.ipcall.a.f.i();
    this.nMm = new com.tencent.mm.plugin.ipcall.a.f.a();
    this.nMn = new com.tencent.mm.plugin.ipcall.a.f.h();
    this.nMo = new com.tencent.mm.plugin.ipcall.a.f.c();
    this.nMp = new e();
    this.nMq = new com.tencent.mm.plugin.ipcall.a.f.g();
    this.nMr = new com.tencent.mm.plugin.ipcall.a.f.f();
    AppMethodBeat.o(21744);
  }
  
  private boolean c(int paramInt1, Object paramObject, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(21759);
    if ((this.nMs == null) || (paramObject == null))
    {
      ab.e("MicroMsg.IPCallSvrLogic", "callInfo = null or result = null");
      AppMethodBeat.o(21759);
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
          AppMethodBeat.o(21759);
          return false;
          if (!(paramObject instanceof com.tencent.mm.plugin.ipcall.a.d.i))
          {
            ab.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo invited result error");
            AppMethodBeat.o(21759);
            return true;
          }
          paramObject = (com.tencent.mm.plugin.ipcall.a.d.i)paramObject;
          localObject1 = paramObject.nPc;
          if (this.nMs.nNc != paramObject.nPb.xCk)
          {
            ab.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo invited finished but invite id not the same, now room inviteId:%d, before room inviteId:%d", new Object[] { Integer.valueOf(this.nMs.nNc), Integer.valueOf(paramObject.nPb.xCk) });
            AppMethodBeat.o(21759);
            return true;
          }
          ab.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo invited finished invite id:%d", new Object[] { Integer.valueOf(this.nMs.nNc) });
          i.bJp().ey(this.nMs.nNc, paramInt3);
          if ((paramInt2 == 0) && (paramInt3 == 0))
          {
            if (this.nMs != null)
            {
              this.nMs.nMZ = ((bog)localObject1).wQP;
              this.nMs.nNa = ((bog)localObject1).wQQ;
              this.nMs.nNb = ((bog)localObject1).xCm;
              this.nMs.nNh = ((bog)localObject1).xCv;
              this.nMs.nNj = (((bog)localObject1).xCw * 1000);
              this.nMs.nNq = ((bog)localObject1).nNq;
              this.nMs.nNr = ((bog)localObject1).nNr;
              this.nMs.jCd = ((bog)localObject1).wtb;
              this.nMs.nNx = ((bog)localObject1).xCx;
              this.nMs.nNC = ((bog)localObject1).xCy;
              if (((bog)localObject1).nNy > 0) {
                this.nMs.nNy = ((bog)localObject1).nNy;
              }
              this.nMs.nNs = ((bog)localObject1).nNs;
              this.nMs.nNt = ((bog)localObject1).nNt;
              this.nMs.nNp = ((bog)localObject1).xCA;
              if (((bog)localObject1).nNv > 0)
              {
                this.nMs.nNv = (((bog)localObject1).nNv - 1);
                ab.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo zhengxue[ENCRYPT] got encryptStrategy[" + this.nMs.nNv + "] from Invite resp");
                this.nMs.nNw = ((bog)localObject1).xCz;
                ab.d("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo NextInvite:%d", new Object[] { Integer.valueOf(((bog)localObject1).nNk) });
                if (((bog)localObject1).nNk <= 0) {
                  break label613;
                }
                this.nMs.nNo = false;
              }
              for (this.nMs.nNk = ((bog)localObject1).nNk;; this.nMs.nNk = 0)
              {
                this.nMs.nNg = ((bog)localObject1).nNg;
                this.nMs.nNf = ((bog)localObject1).nNf;
                this.nMs.lGK = paramInt3;
                this.nMs.lGL = bo.nullAsNil(aa.a(((bog)localObject1).BaseResponse.ErrMsg));
                break;
                ab.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo zhengxue[ENCRYPT] got no encryptStrategy from Invite resp");
                this.nMs.nNv = 2;
                break label474;
                this.nMs.nNo = true;
              }
            }
          }
          else
          {
            ab.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo invite failed");
            if (((bog)localObject1).BaseResponse != null)
            {
              if (paramInt3 == 433)
              {
                ab.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo account overdue");
                this.nMs.nNl = true;
                if (((bog)localObject1).nNk <= 0) {
                  break label860;
                }
                this.nMs.nNo = false;
              }
              for (this.nMs.nNk = ((bog)localObject1).nNk;; this.nMs.nNk = 0)
              {
                this.nMs.nNg = ((bog)localObject1).nNg;
                this.nMs.nNf = ((bog)localObject1).nNf;
                this.nMs.lGK = paramInt3;
                if (((bog)localObject1).getBaseResponse() == null) {
                  break;
                }
                this.nMs.lGL = bo.nullAsNil(aa.a(((bog)localObject1).BaseResponse.ErrMsg));
                ab.d("MicroMsg.IPCallSvrLogic", "ErrLevel:%d,ErrCode:%d,ErrMsg:%s", new Object[] { Integer.valueOf(((bog)localObject1).nNf), Integer.valueOf(paramInt3), this.nMs.lGL });
                break;
                if (paramInt3 == 434)
                {
                  ab.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo restrict call");
                  this.nMs.nNm = true;
                  break label672;
                }
                if (paramInt3 != 435) {
                  break label672;
                }
                ab.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo phonenumber invalid");
                this.nMs.nNn = true;
                break label672;
                this.nMs.nNo = true;
              }
            }
            this.nMs.nNg = "";
            this.nMs.nNf = 2;
            this.nMs.lGL = ah.getContext().getString(2131297835);
            this.nMs.lGK = paramInt3;
            continue;
            if (!(paramObject instanceof com.tencent.mm.plugin.ipcall.a.d.a))
            {
              ab.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo cancel result error");
              AppMethodBeat.o(21759);
              return true;
            }
            ab.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo cancel finished errType:%d,errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
            paramObject = (com.tencent.mm.plugin.ipcall.a.d.a)paramObject;
            if (this.nMs.nNc != paramObject.nOK.xCk)
            {
              ab.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo cancel finished but invite id not the same, now room inviteId:%d, before room inviteId:%d", new Object[] { Integer.valueOf(this.nMs.nNc), Integer.valueOf(paramObject.nOK.xCk) });
              AppMethodBeat.o(21759);
              return true;
              if (!(paramObject instanceof com.tencent.mm.plugin.ipcall.a.d.n))
              {
                ab.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown result error");
                AppMethodBeat.o(21759);
                return true;
              }
              paramObject = (com.tencent.mm.plugin.ipcall.a.d.n)paramObject;
              if (this.nMs.nMZ != paramObject.nPl.wQP)
              {
                ab.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown finished but room id not the same, now room roomId:%d, before room roomId:%d", new Object[] { Integer.valueOf(this.nMs.nMZ), Integer.valueOf(paramObject.nPl.wQP) });
                AppMethodBeat.o(21759);
                return true;
              }
              if ((paramInt2 == 0) && (paramInt3 == 0))
              {
                ab.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown success!");
                this.nMs.hIJ = 5;
              }
              else
              {
                ab.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown failed");
              }
            }
          }
        }
        if (!(paramObject instanceof boh))
        {
          ab.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo notify result error");
          AppMethodBeat.o(21759);
          return true;
        }
        ab.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo notify finished");
        paramObject = (boh)paramObject;
        if (this.nMs.nMZ != paramObject.wQP)
        {
          ab.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown finished but room id not the same, now room roomId:%d, before room roomId:%d", new Object[] { Integer.valueOf(this.nMs.nMZ), Integer.valueOf(paramObject.wQP) });
          AppMethodBeat.o(21759);
          return true;
        }
      } while ((paramInt2 != 0) || (paramInt3 != 0));
      this.nMs.nNu = paramObject.nNu;
      ab.d("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo updateNotifyCallInfo, UserStatuslist.size: %d", new Object[] { Integer.valueOf(paramObject.xCB.size()) });
      paramObject = paramObject.xCB.iterator();
      while (paramObject.hasNext())
      {
        localObject1 = (boq)paramObject.next();
        if (this.nMs.nNh != ((boq)localObject1).xCK) {
          break label1537;
        }
        ab.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo update self userStatus, memberId: %d, status: %d, syncKey: %d", new Object[] { Integer.valueOf(this.nMs.nNh), Integer.valueOf(((boq)localObject1).xCL), Integer.valueOf(((boq)localObject1).xCM) });
        if (((boq)localObject1).xCM > this.nMs.nNi)
        {
          this.nMs.nNi = ((boq)localObject1).xCM;
          if (((boq)localObject1).xCL != 0) {
            this.nMs.hIJ = ((boq)localObject1).xCL;
          }
        }
        label1448:
        if ((((boq)localObject1).lGK == 404) || (((boq)localObject1).lGK == 484))
        {
          ab.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo notify phonenumber invalid");
          this.nMs.nNn = true;
        }
        this.nMs.lGL = ((boq)localObject1).lGL;
        this.nMs.lGK = ((boq)localObject1).lGK;
        this.nMs.nNf = ((boq)localObject1).nNf;
        this.nMs.nNg = ((boq)localObject1).nNg;
      }
      label1537:
      ab.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo update others userStatus, memberId: %d, status: %d, syncKey: %d", new Object[] { Integer.valueOf(((boq)localObject1).xCK), Integer.valueOf(((boq)localObject1).xCL), Integer.valueOf(((boq)localObject1).xCM) });
      paramInt1 = 0;
      localObject2 = this.nMs.nNz.iterator();
      label1596:
      if (((Iterator)localObject2).hasNext())
      {
        com.tencent.mm.plugin.ipcall.a.a.d locald = (com.tencent.mm.plugin.ipcall.a.a.d)((Iterator)localObject2).next();
        if (locald.kJx != ((boq)localObject1).xCK) {
          break label2539;
        }
        if (((boq)localObject1).xCM > locald.nNi)
        {
          locald.nNi = ((boq)localObject1).xCM;
          if (((boq)localObject1).xCL != 0) {
            locald.eHa = ((boq)localObject1).xCL;
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
      localObject2 = new com.tencent.mm.plugin.ipcall.a.a.d();
      ((com.tencent.mm.plugin.ipcall.a.a.d)localObject2).kJx = ((boq)localObject1).xCK;
      ((com.tencent.mm.plugin.ipcall.a.a.d)localObject2).eHa = ((boq)localObject1).xCL;
      ((com.tencent.mm.plugin.ipcall.a.a.d)localObject2).nNi = ((boq)localObject1).xCM;
      this.nMs.nNz.add(localObject2);
      break label1448;
      if (!(paramObject instanceof k))
      {
        ab.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo redirect result error");
        AppMethodBeat.o(21759);
        return true;
      }
      paramObject = (k)paramObject;
      localObject1 = paramObject.nPg;
      if (this.nMs.nMZ != paramObject.nPf.wQP)
      {
        ab.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo redirect finished but room id not the same, now room roomId:%d, before room roomId:%d", new Object[] { Integer.valueOf(this.nMs.nMZ), Integer.valueOf(paramObject.nPf.wQP) });
        AppMethodBeat.o(21759);
        return true;
      }
      if ((paramInt2 == 0) && (paramInt3 == 0))
      {
        ab.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo redirect success");
        this.nMs.jCd = ((boj)localObject1).wtb;
        this.nMs.nNx = ((boj)localObject1).xCx;
        break;
      }
      ab.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo redirect failed");
      break;
      if (!(paramObject instanceof o))
      {
        ab.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync result error");
        AppMethodBeat.o(21759);
        return true;
      }
      ab.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync finished errType:%d,errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      localObject1 = (o)paramObject;
      paramObject = ((o)localObject1).nPo;
      if (this.nMs.nMZ != ((o)localObject1).nPn.wQP)
      {
        ab.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync finished but room id not the same, now room roomId:%d, before room roomId:%d", new Object[] { Integer.valueOf(this.nMs.nMZ), Integer.valueOf(((o)localObject1).nPn.wQP) });
        AppMethodBeat.o(21759);
        return true;
      }
      if ((paramInt2 != 0) || (paramInt3 != 0)) {
        break;
      }
      ab.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync roomId: %d, status: %d, memberId: %d, syncKey: %d", new Object[] { Integer.valueOf(paramObject.wQP), Integer.valueOf(paramObject.xCJ), Integer.valueOf(paramObject.xCK), Integer.valueOf(paramObject.xCH) });
      if ((paramObject.wQP != this.nMs.nMZ) || (paramObject.wQQ != this.nMs.nNa)) {
        break;
      }
      if (paramObject.xCK == this.nMs.nNh)
      {
        ab.d("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync update self status");
        if (paramObject.xCH > this.nMs.nNi)
        {
          this.nMs.nNi = paramObject.xCH;
          if (paramObject.xCJ != 0) {
            this.nMs.hIJ = paramObject.xCJ;
          }
        }
      }
      for (;;)
      {
        label2170:
        if ((paramObject.lGK == 404) || (paramObject.lGK == 484))
        {
          ab.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync phonenumber invalid");
          this.nMs.nNn = true;
        }
        this.nMs.lGL = paramObject.lGL;
        this.nMs.lGK = paramObject.lGK;
        this.nMs.nNf = paramObject.nNf;
        this.nMs.nNg = paramObject.nNg;
        this.nMs.nNu = paramObject.nNu;
        break;
        ab.d("MicroMsg.IPCallSvrLogic", " handleServiceResultCallInfosync update others status");
        localObject1 = this.nMs.nNz.iterator();
        paramInt1 = 0;
        label2286:
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (com.tencent.mm.plugin.ipcall.a.a.d)((Iterator)localObject1).next();
          if (((com.tencent.mm.plugin.ipcall.a.a.d)localObject2).kJx != paramObject.xCK) {
            break label2536;
          }
          if (paramObject.xCH > ((com.tencent.mm.plugin.ipcall.a.a.d)localObject2).nNi)
          {
            ((com.tencent.mm.plugin.ipcall.a.a.d)localObject2).nNi = paramObject.xCH;
            if (paramObject.xCJ != 0) {
              ((com.tencent.mm.plugin.ipcall.a.a.d)localObject2).eHa = paramObject.xCJ;
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
          localObject1 = new com.tencent.mm.plugin.ipcall.a.a.d();
          ((com.tencent.mm.plugin.ipcall.a.a.d)localObject1).kJx = paramObject.xCK;
          ((com.tencent.mm.plugin.ipcall.a.a.d)localObject1).eHa = paramObject.xCJ;
          ((com.tencent.mm.plugin.ipcall.a.a.d)localObject1).nNi = paramObject.xCH;
          this.nMs.nNz.add(localObject1);
          break label2170;
          if (!(paramObject instanceof com.tencent.mm.plugin.ipcall.a.d.h))
          {
            ab.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo heartbeat result error");
            AppMethodBeat.o(21759);
            return true;
          }
          ab.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo heartbeat finished errType:%d,errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
          paramObject = (com.tencent.mm.plugin.ipcall.a.d.h)paramObject;
          if (this.nMs.nMZ == paramObject.nOZ.wQP) {
            break;
          }
          ab.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo heartbeat finished but room id not the same, now room roomId:%d, before room roomId:%d", new Object[] { Integer.valueOf(this.nMs.nMZ), Integer.valueOf(paramObject.nOZ.wQP) });
          AppMethodBeat.o(21759);
          return true;
        }
      }
    }
  }
  
  private void iA(boolean paramBoolean)
  {
    AppMethodBeat.i(21748);
    ab.i("MicroMsg.IPCallSvrLogic", "handleHeartbeat, success: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      this.nMe += 1;
      if (this.nMe >= 2)
      {
        ab.e("MicroMsg.IPCallSvrLogic", "heartbeat failed twice!");
        this.nMo.stop();
        if ((i.bJr().bJk()) && (this.nMj != null))
        {
          this.nMj.bIK();
          AppMethodBeat.o(21748);
        }
      }
    }
    else
    {
      this.nMe = 0;
    }
    AppMethodBeat.o(21748);
  }
  
  private void iB(boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(21751);
    ab.i("MicroMsg.IPCallSvrLogic", "handleSync, success: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((paramBoolean) && (i.bJo().nOf)) {
      i.bJo().xJ(this.nMs.nNu);
    }
    if (!paramBoolean)
    {
      ab.e("MicroMsg.IPCallSvrLogic", "sync failed!");
      this.nMl.stop();
      if (i.bJr().mCurrentState == 3) {}
      for (;;)
      {
        if ((i != 0) && (this.nMj != null)) {
          this.nMj.cx(this.nMs.lGL, this.nMs.nNf);
        }
        AppMethodBeat.o(21751);
        return;
        i = 0;
      }
    }
    if ((this.nMs != null) && (paramBoolean)) {
      xI(this.nMs.bJE());
    }
    AppMethodBeat.o(21751);
  }
  
  private void iC(boolean paramBoolean)
  {
    AppMethodBeat.i(21752);
    ab.i("MicroMsg.IPCallSvrLogic", "handleNotify, success: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((paramBoolean) && (i.bJo().nOf)) {
      i.bJo().xJ(this.nMs.nNu);
    }
    if ((this.nMs != null) && (paramBoolean))
    {
      int i = this.nMs.bJE();
      if ((i == 2) || (i == 1))
      {
        if (!this.nMu)
        {
          o localo = new o(this.nMs.nMZ, this.nMs.nNa, this.nMs.bJD(), this.nMs.nNb, false);
          aw.Rc().a(localo, 0);
        }
      }
      else {
        xI(this.nMs.bJE());
      }
    }
    else
    {
      AppMethodBeat.o(21752);
      return;
    }
    ab.i("MicroMsg.IPCallSvrLogic", "current status has jni accepted, ignore notify accept");
    AppMethodBeat.o(21752);
  }
  
  private void iD(boolean paramBoolean)
  {
    Object localObject2 = null;
    AppMethodBeat.i(21754);
    ab.i("MicroMsg.IPCallSvrLogic", "handleRedirect, isSuccess: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    com.tencent.mm.plugin.ipcall.a.c.a locala;
    com.tencent.mm.plugin.ipcall.a.a.c localc;
    if (paramBoolean)
    {
      locala = i.bJo();
      localc = this.nMs;
      ab.i("MicroMsg.IPCallEngineManager", "redirectSvrAddr");
      if ((localc == null) || (localc.jCd == null) || (localc.jCd.size() <= 0)) {
        break label148;
      }
    }
    label148:
    for (crn localcrn = com.tencent.mm.plugin.ipcall.b.c.aj(localc.jCd);; localcrn = null)
    {
      Object localObject1 = localObject2;
      if (localc != null)
      {
        localObject1 = localObject2;
        if (localc.nNx != null)
        {
          localObject1 = localObject2;
          if (localc.nNx.size() > 0) {
            localObject1 = com.tencent.mm.plugin.ipcall.b.c.aj(localc.nNx);
          }
        }
      }
      locala.nOc.a(localcrn, localcrn, (crn)localObject1, 0, 0);
      AppMethodBeat.o(21754);
      return;
    }
  }
  
  private void iz(boolean paramBoolean)
  {
    AppMethodBeat.i(21747);
    ab.i("MicroMsg.IPCallSvrLogic", "handleInvite, success: %b, isLaunchCancel: %b, isLaunchShutdown: %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.nMh), Boolean.valueOf(this.nMi) });
    if ((this.nMh) || (this.nMi))
    {
      ab.i("MicroMsg.IPCallSvrLogic", "handleInvite, ignore this");
      AppMethodBeat.o(21747);
      return;
    }
    if (paramBoolean)
    {
      if (this.nMj != null)
      {
        if (this.nMs.nNo) {
          break label130;
        }
        this.nMj.bIL();
      }
      for (;;)
      {
        ab.i("MicroMsg.IPCallSvrLogic", "start sync");
        this.nMl.a(this.nMs);
        AppMethodBeat.o(21747);
        return;
        label130:
        this.nMj.bIG();
      }
    }
    if (this.nMj != null)
    {
      if (this.nMs.nNl)
      {
        this.nMj.G(this.nMs.nNg, this.nMs.lGL, this.nMs.nNf);
        AppMethodBeat.o(21747);
        return;
      }
      if (this.nMs.nNm)
      {
        this.nMj.H(this.nMs.nNg, this.nMs.lGL, this.nMs.nNf);
        AppMethodBeat.o(21747);
        return;
      }
      if (this.nMs.nNn)
      {
        this.nMj.I(this.nMs.nNg, this.nMs.lGL, this.nMs.nNf);
        AppMethodBeat.o(21747);
        return;
      }
      if (!this.nMs.nNo)
      {
        this.nMj.bIL();
        AppMethodBeat.o(21747);
        return;
      }
      this.nMj.F(this.nMs.nNg, this.nMs.lGL, this.nMs.nNf);
    }
    AppMethodBeat.o(21747);
  }
  
  private void x(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(21749);
    ab.i("MicroMsg.IPCallSvrLogic", "handleCancel, success: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((!paramBoolean) && (paramInt < 0) && (this.nMg <= 0))
    {
      this.nMg += 1;
      ab.i("MicroMsg.IPCallSvrLogic", "cancel failed, retry count: %d", new Object[] { Integer.valueOf(this.nMg) });
      this.nMm.a(this.nMs);
      AppMethodBeat.o(21749);
      return;
    }
    AppMethodBeat.o(21749);
  }
  
  private void y(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(21750);
    ab.i("MicroMsg.IPCallSvrLogic", "handleUserSelfShutdown, success: %b, isFromNotify: %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.nMn.nPX) });
    if ((!paramBoolean) && (paramInt < 0) && (this.nMf <= 0))
    {
      this.nMf += 1;
      ab.i("MicroMsg.IPCallSvrLogic", "shutdown failed, retry count: %d, isFromNotify: %b", new Object[] { Integer.valueOf(this.nMf), Boolean.valueOf(this.nMn.nPX) });
      this.nMn.a(this.nMs);
      AppMethodBeat.o(21750);
      return;
    }
    AppMethodBeat.o(21750);
  }
  
  public final void a(int paramInt1, m paramm, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(21757);
    if (c(paramInt1, paramm, paramInt2, paramInt3))
    {
      ab.i("MicroMsg.IPCallSvrLogic", "onTimerSuccess different room ignore");
      AppMethodBeat.o(21757);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(21757);
      return;
      iB(true);
      AppMethodBeat.o(21757);
      return;
      iA(true);
    }
  }
  
  public final void a(int paramInt1, Object paramObject, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(21755);
    if (c(paramInt1, paramObject, paramInt2, paramInt3))
    {
      ab.i("MicroMsg.IPCallSvrLogic", "onServiceResult different room ignore");
      AppMethodBeat.o(21755);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(21755);
      return;
      iz(true);
      AppMethodBeat.o(21755);
      return;
      x(true, paramInt3);
      AppMethodBeat.o(21755);
      return;
      y(true, paramInt3);
      AppMethodBeat.o(21755);
      return;
      iC(true);
      AppMethodBeat.o(21755);
      return;
      iD(true);
    }
  }
  
  public final void b(int paramInt1, m paramm, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(21758);
    if (c(paramInt1, paramm, paramInt2, paramInt3))
    {
      ab.i("MicroMsg.IPCallSvrLogic", "onTimerFailed different room ignore");
      AppMethodBeat.o(21758);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(21758);
      return;
      iB(false);
      AppMethodBeat.o(21758);
      return;
      iA(false);
    }
  }
  
  public final void b(int paramInt1, Object paramObject, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(21756);
    if (c(paramInt1, paramObject, paramInt2, paramInt3))
    {
      ab.i("MicroMsg.IPCallSvrLogic", "onServiceFailed different room ignore");
      AppMethodBeat.o(21756);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(21756);
      return;
      iz(false);
      AppMethodBeat.o(21756);
      return;
      x(false, paramInt3);
      AppMethodBeat.o(21756);
      return;
      y(false, paramInt3);
      AppMethodBeat.o(21756);
      return;
      iC(false);
      AppMethodBeat.o(21756);
      return;
      iD(false);
    }
  }
  
  public final void bJl()
  {
    AppMethodBeat.i(21745);
    if (this.nMs.nNE) {
      ab.e("MicroMsg.IPCallSvrLogic", "cancelIPCall, already accept");
    }
    this.nMh = true;
    ab.i("MicroMsg.IPCallSvrLogic", "cancelIPCall, roomId: %d, inviteId: %d", new Object[] { Integer.valueOf(this.nMs.nMZ), Integer.valueOf(this.nMs.nNc) });
    this.nMo.stop();
    this.nMl.stop();
    this.nMm.a(this.nMs);
    this.nMq.a(this.nMs);
    AppMethodBeat.o(21745);
  }
  
  public final void xH(int paramInt)
  {
    AppMethodBeat.i(21746);
    if (!this.nMs.nNE) {
      ab.e("MicroMsg.IPCallSvrLogic", "shutdownIPCall, user not accept");
    }
    ab.i("MicroMsg.IPCallSvrLogic", "shutdownIPCall, roomId: %d, inviteId: %d", new Object[] { Integer.valueOf(this.nMs.nMZ), Integer.valueOf(this.nMs.nNc) });
    this.nMi = true;
    this.nMo.stop();
    this.nMl.stop();
    this.nMn.nPX = false;
    this.nMn.nPW = paramInt;
    this.nMn.a(this.nMs);
    this.nMq.a(this.nMs);
    AppMethodBeat.o(21746);
  }
  
  public final boolean xI(int paramInt)
  {
    AppMethodBeat.i(21753);
    switch (paramInt)
    {
    default: 
      ab.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, do nothing:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(21753);
      return false;
    case 2: 
      ab.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, user accept, isLaunchCancel: %b, isLaunchShutdown: %b", new Object[] { Boolean.valueOf(this.nMh), Boolean.valueOf(this.nMi) });
      if ((this.nMh) || (this.nMi))
      {
        AppMethodBeat.o(21753);
        return true;
      }
      this.nMl.stop();
      if (!this.cDO)
      {
        this.cDO = true;
        if (this.nMs != null) {
          this.nMs.nNE = true;
        }
        if (this.nMj != null) {
          this.nMj.bII();
        }
        this.nMo.a(this.nMs);
      }
      AppMethodBeat.o(21753);
      return true;
    case 3: 
      ab.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, user busy");
      this.nMl.stop();
      this.nMo.stop();
      if (this.nMj != null) {
        this.nMj.cw(this.nMs.lGL, this.nMs.nNf);
      }
      AppMethodBeat.o(21753);
      return true;
    case 1: 
      ab.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, user ringing");
      if (!this.nMt)
      {
        this.nMt = true;
        if (this.nMj != null) {
          this.nMj.bIH();
        }
      }
      AppMethodBeat.o(21753);
      return true;
    case 5: 
      ab.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, other side user shutdown");
      if (this.nMj != null) {
        this.nMj.bIJ();
      }
      AppMethodBeat.o(21753);
      return true;
    case 4: 
    case 7: 
    case 8: 
      ab.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, user unavailable");
      if (this.nMs.nNn) {
        if (this.nMj != null) {
          this.nMj.I(this.nMs.nNg, this.nMs.lGL, this.nMs.nNf);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(21753);
        return true;
        if (this.nMj != null) {
          this.nMj.cv(this.nMs.lGL, this.nMs.nNf);
        }
      }
    }
    ab.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, shutdown overdue");
    this.nMs.nNl = true;
    if (this.nMj != null) {
      this.nMj.G(this.nMs.nNg, this.nMs.lGL, this.nMs.nNf);
    }
    AppMethodBeat.o(21753);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.g
 * JD-Core Version:    0.7.0.1
 */