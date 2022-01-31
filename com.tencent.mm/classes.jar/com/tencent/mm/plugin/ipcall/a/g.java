package com.tencent.mm.plugin.ipcall.a;

import android.content.Context;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.ipcall.a.a.a.a;
import com.tencent.mm.plugin.ipcall.a.a.b.a;
import com.tencent.mm.plugin.ipcall.a.c.b;
import com.tencent.mm.plugin.ipcall.a.d.k;
import com.tencent.mm.plugin.ipcall.a.d.o;
import com.tencent.mm.plugin.ipcall.a.f.e;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.c.bft;
import com.tencent.mm.protocal.c.bfx;
import com.tencent.mm.protocal.c.bfz;
import com.tencent.mm.protocal.c.bga;
import com.tencent.mm.protocal.c.bgb;
import com.tencent.mm.protocal.c.bgc;
import com.tencent.mm.protocal.c.bgd;
import com.tencent.mm.protocal.c.bgg;
import com.tencent.mm.protocal.c.bgi;
import com.tencent.mm.protocal.c.bgj;
import com.tencent.mm.protocal.c.bgk;
import com.tencent.mm.protocal.c.bly;
import com.tencent.mm.protocal.c.cec;
import com.tencent.mm.protocal.c.gd;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;

public final class g
  implements a.a, b.a
{
  public boolean bWb = false;
  public int loI = 0;
  public int loJ = 0;
  public int loK = 0;
  public boolean loL = false;
  public boolean loM = false;
  public g.a loN;
  public com.tencent.mm.plugin.ipcall.a.f.d loO = new com.tencent.mm.plugin.ipcall.a.f.d();
  com.tencent.mm.plugin.ipcall.a.f.i loP = new com.tencent.mm.plugin.ipcall.a.f.i();
  com.tencent.mm.plugin.ipcall.a.f.a loQ = new com.tencent.mm.plugin.ipcall.a.f.a();
  com.tencent.mm.plugin.ipcall.a.f.h loR = new com.tencent.mm.plugin.ipcall.a.f.h();
  com.tencent.mm.plugin.ipcall.a.f.c loS = new com.tencent.mm.plugin.ipcall.a.f.c();
  public e loT = new e();
  com.tencent.mm.plugin.ipcall.a.f.g loU = new com.tencent.mm.plugin.ipcall.a.f.g();
  com.tencent.mm.plugin.ipcall.a.f.f loV = new com.tencent.mm.plugin.ipcall.a.f.f();
  public com.tencent.mm.plugin.ipcall.a.a.c loW;
  public boolean loX = false;
  public boolean loY = false;
  com.tencent.mm.network.n loZ = new g.1(this);
  
  private boolean c(int paramInt1, Object paramObject, int paramInt2, int paramInt3)
  {
    if ((this.loW == null) || (paramObject == null))
    {
      y.e("MicroMsg.IPCallSvrLogic", "callInfo = null or result = null");
      return true;
    }
    Object localObject1;
    label463:
    label595:
    label1386:
    Object localObject2;
    switch (paramInt1)
    {
    case 7: 
    default: 
    case 1: 
    case 3: 
    case 4: 
    case 8: 
      label653:
      label834:
      do
      {
        for (;;)
        {
          return false;
          if (!(paramObject instanceof com.tencent.mm.plugin.ipcall.a.d.i))
          {
            y.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo invited result error");
            return true;
          }
          localObject1 = (com.tencent.mm.plugin.ipcall.a.d.i)paramObject;
          paramObject = ((com.tencent.mm.plugin.ipcall.a.d.i)localObject1).lrG;
          if (this.loW.lpG != ((com.tencent.mm.plugin.ipcall.a.d.i)localObject1).lrF.tAC)
          {
            y.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo invited finished but invite id not the same, now room inviteId:%d, before room inviteId:%d", new Object[] { Integer.valueOf(this.loW.lpG), Integer.valueOf(((com.tencent.mm.plugin.ipcall.a.d.i)localObject1).lrF.tAC) });
            return true;
          }
          y.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo invited finished invite id:%d", new Object[] { Integer.valueOf(this.loW.lpG) });
          localObject1 = i.bci();
          paramInt1 = this.loW.lpG;
          if (((b)localObject1).lpG == paramInt1)
          {
            y.d("MicroMsg.IPCallReportHelper", "setInviteCgiRet: %d", new Object[] { Integer.valueOf(paramInt3) });
            ((b)localObject1).lqY = paramInt3;
          }
          if ((paramInt2 == 0) && (paramInt3 == 0))
          {
            if (this.loW != null)
            {
              this.loW.lpD = paramObject.sST;
              this.loW.lpE = paramObject.sSU;
              this.loW.lpF = paramObject.tAE;
              this.loW.lpL = paramObject.tAN;
              this.loW.lpN = (paramObject.tAO * 1000);
              this.loW.lpU = paramObject.lpU;
              this.loW.lpV = paramObject.lpV;
              this.loW.hID = paramObject.syZ;
              this.loW.lqb = paramObject.tAP;
              this.loW.lqg = paramObject.tAQ;
              if (paramObject.lqc > 0) {
                this.loW.lqc = paramObject.lqc;
              }
              this.loW.lpW = paramObject.lpW;
              this.loW.lpX = paramObject.lpX;
              this.loW.lpT = paramObject.tAS;
              if (paramObject.lpZ > 0)
              {
                this.loW.lpZ = (paramObject.lpZ - 1);
                y.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo zhengxue[ENCRYPT] got encryptStrategy[" + this.loW.lpZ + "] from Invite resp");
                this.loW.lqa = paramObject.tAR;
                y.d("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo NextInvite:%d", new Object[] { Integer.valueOf(paramObject.lpO) });
                if (paramObject.lpO <= 0) {
                  break label595;
                }
                this.loW.lpS = false;
              }
              for (this.loW.lpO = paramObject.lpO;; this.loW.lpO = 0)
              {
                this.loW.lpK = paramObject.lpK;
                this.loW.lpJ = paramObject.lpJ;
                this.loW.jxl = paramInt3;
                this.loW.jxm = bk.pm(aa.a(paramObject.tFx.sAn));
                break;
                y.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo zhengxue[ENCRYPT] got no encryptStrategy from Invite resp");
                this.loW.lpZ = 2;
                break label463;
                this.loW.lpS = true;
              }
            }
          }
          else
          {
            y.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo invite failed");
            if (paramObject.tFx != null)
            {
              if (paramInt3 == 433)
              {
                y.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo account overdue");
                this.loW.lpP = true;
                if (paramObject.lpO <= 0) {
                  break label834;
                }
                this.loW.lpS = false;
              }
              for (this.loW.lpO = paramObject.lpO;; this.loW.lpO = 0)
              {
                this.loW.lpK = paramObject.lpK;
                this.loW.lpJ = paramObject.lpJ;
                this.loW.jxl = paramInt3;
                if (paramObject.tFx == null) {
                  break;
                }
                this.loW.jxm = bk.pm(aa.a(paramObject.tFx.sAn));
                y.d("MicroMsg.IPCallSvrLogic", "ErrLevel:%d,ErrCode:%d,ErrMsg:%s", new Object[] { Integer.valueOf(paramObject.lpJ), Integer.valueOf(paramInt3), this.loW.jxm });
                break;
                if (paramInt3 == 434)
                {
                  y.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo restrict call");
                  this.loW.lpQ = true;
                  break label653;
                }
                if (paramInt3 != 435) {
                  break label653;
                }
                y.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo phonenumber invalid");
                this.loW.lpR = true;
                break label653;
                this.loW.lpS = true;
              }
            }
            this.loW.lpK = "";
            this.loW.lpJ = 2;
            this.loW.jxm = ae.getContext().getString(R.l.callout_failed_network);
            this.loW.jxl = paramInt3;
            continue;
            if (!(paramObject instanceof com.tencent.mm.plugin.ipcall.a.d.a))
            {
              y.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo cancel result error");
              return true;
            }
            y.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo cancel finished errType:%d,errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
            paramObject = (com.tencent.mm.plugin.ipcall.a.d.a)paramObject;
            if (this.loW.lpG != paramObject.lro.tAC)
            {
              y.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo cancel finished but invite id not the same, now room inviteId:%d, before room inviteId:%d", new Object[] { Integer.valueOf(this.loW.lpG), Integer.valueOf(paramObject.lro.tAC) });
              return true;
              if (!(paramObject instanceof com.tencent.mm.plugin.ipcall.a.d.n))
              {
                y.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown result error");
                return true;
              }
              paramObject = (com.tencent.mm.plugin.ipcall.a.d.n)paramObject;
              if (this.loW.lpD != paramObject.lrP.sST)
              {
                y.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown finished but room id not the same, now room roomId:%d, before room roomId:%d", new Object[] { Integer.valueOf(this.loW.lpD), Integer.valueOf(paramObject.lrP.sST) });
                return true;
              }
              if ((paramInt2 == 0) && (paramInt3 == 0))
              {
                y.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown success!");
                this.loW.goN = 5;
              }
              else
              {
                y.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown failed");
              }
            }
          }
        }
        if (!(paramObject instanceof bgb))
        {
          y.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo notify result error");
          return true;
        }
        y.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo notify finished");
        paramObject = (bgb)paramObject;
        if (this.loW.lpD != paramObject.sST)
        {
          y.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown finished but room id not the same, now room roomId:%d, before room roomId:%d", new Object[] { Integer.valueOf(this.loW.lpD), Integer.valueOf(paramObject.sST) });
          return true;
        }
      } while ((paramInt2 != 0) || (paramInt3 != 0));
      this.loW.lpY = paramObject.lpY;
      y.d("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo updateNotifyCallInfo, UserStatuslist.size: %d", new Object[] { Integer.valueOf(paramObject.tAT.size()) });
      paramObject = paramObject.tAT.iterator();
      while (paramObject.hasNext())
      {
        localObject1 = (bgk)paramObject.next();
        if (this.loW.lpL != ((bgk)localObject1).tBc) {
          break label1475;
        }
        y.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo update self userStatus, memberId: %d, status: %d, syncKey: %d", new Object[] { Integer.valueOf(this.loW.lpL), Integer.valueOf(((bgk)localObject1).tzB), Integer.valueOf(((bgk)localObject1).tBd) });
        if (((bgk)localObject1).tBd > this.loW.lpM)
        {
          this.loW.lpM = ((bgk)localObject1).tBd;
          if (((bgk)localObject1).tzB != 0) {
            this.loW.goN = ((bgk)localObject1).tzB;
          }
        }
        if ((((bgk)localObject1).jxl == 404) || (((bgk)localObject1).jxl == 484))
        {
          y.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo notify phonenumber invalid");
          this.loW.lpR = true;
        }
        this.loW.jxm = ((bgk)localObject1).jxm;
        this.loW.jxl = ((bgk)localObject1).jxl;
        this.loW.lpJ = ((bgk)localObject1).lpJ;
        this.loW.lpK = ((bgk)localObject1).lpK;
      }
      label1475:
      y.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo update others userStatus, memberId: %d, status: %d, syncKey: %d", new Object[] { Integer.valueOf(((bgk)localObject1).tBc), Integer.valueOf(((bgk)localObject1).tzB), Integer.valueOf(((bgk)localObject1).tBd) });
      paramInt1 = 0;
      localObject2 = this.loW.lqd.iterator();
      label1534:
      if (((Iterator)localObject2).hasNext())
      {
        com.tencent.mm.plugin.ipcall.a.a.d locald = (com.tencent.mm.plugin.ipcall.a.a.d)((Iterator)localObject2).next();
        if (locald.iEo != ((bgk)localObject1).tBc) {
          break label2441;
        }
        if (((bgk)localObject1).tBd > locald.lpM)
        {
          locald.lpM = ((bgk)localObject1).tBd;
          if (((bgk)localObject1).tzB != 0) {
            locald.dJB = ((bgk)localObject1).tzB;
          }
        }
        paramInt1 = 1;
      }
      break;
    }
    label2438:
    label2439:
    label2441:
    for (;;)
    {
      break label1534;
      if (paramInt1 != 0) {
        break label1386;
      }
      localObject2 = new com.tencent.mm.plugin.ipcall.a.a.d();
      ((com.tencent.mm.plugin.ipcall.a.a.d)localObject2).iEo = ((bgk)localObject1).tBc;
      ((com.tencent.mm.plugin.ipcall.a.a.d)localObject2).dJB = ((bgk)localObject1).tzB;
      ((com.tencent.mm.plugin.ipcall.a.a.d)localObject2).lpM = ((bgk)localObject1).tBd;
      this.loW.lqd.add(localObject2);
      break label1386;
      if (!(paramObject instanceof k))
      {
        y.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo redirect result error");
        return true;
      }
      paramObject = (k)paramObject;
      localObject1 = paramObject.lrK;
      if (this.loW.lpD != paramObject.lrJ.sST)
      {
        y.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo redirect finished but room id not the same, now room roomId:%d, before room roomId:%d", new Object[] { Integer.valueOf(this.loW.lpD), Integer.valueOf(paramObject.lrJ.sST) });
        return true;
      }
      if ((paramInt2 == 0) && (paramInt3 == 0))
      {
        y.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo redirect success");
        this.loW.hID = ((bgd)localObject1).syZ;
        this.loW.lqb = ((bgd)localObject1).tAP;
        break;
      }
      y.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo redirect failed");
      break;
      if (!(paramObject instanceof o))
      {
        y.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync result error");
        return true;
      }
      y.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync finished errType:%d,errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      localObject1 = (o)paramObject;
      paramObject = ((o)localObject1).lrS;
      if (this.loW.lpD != ((o)localObject1).lrR.sST)
      {
        y.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync finished but room id not the same, now room roomId:%d, before room roomId:%d", new Object[] { Integer.valueOf(this.loW.lpD), Integer.valueOf(((o)localObject1).lrR.sST) });
        return true;
      }
      if ((paramInt2 != 0) || (paramInt3 != 0)) {
        break;
      }
      y.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync roomId: %d, status: %d, memberId: %d, syncKey: %d", new Object[] { Integer.valueOf(paramObject.sST), Integer.valueOf(paramObject.tBb), Integer.valueOf(paramObject.tBc), Integer.valueOf(paramObject.tAZ) });
      if ((paramObject.sST != this.loW.lpD) || (paramObject.sSU != this.loW.lpE)) {
        break;
      }
      if (paramObject.tBc == this.loW.lpL)
      {
        y.d("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync update self status");
        if (paramObject.tAZ > this.loW.lpM)
        {
          this.loW.lpM = paramObject.tAZ;
          if (paramObject.tBb != 0) {
            this.loW.goN = paramObject.tBb;
          }
        }
      }
      for (;;)
      {
        label2084:
        if ((paramObject.jxl == 404) || (paramObject.jxl == 484))
        {
          y.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync phonenumber invalid");
          this.loW.lpR = true;
        }
        this.loW.jxm = paramObject.jxm;
        this.loW.jxl = paramObject.jxl;
        this.loW.lpJ = paramObject.lpJ;
        this.loW.lpK = paramObject.lpK;
        this.loW.lpY = paramObject.lpY;
        break;
        y.d("MicroMsg.IPCallSvrLogic", " handleServiceResultCallInfosync update others status");
        localObject1 = this.loW.lqd.iterator();
        paramInt1 = 0;
        label2200:
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (com.tencent.mm.plugin.ipcall.a.a.d)((Iterator)localObject1).next();
          if (((com.tencent.mm.plugin.ipcall.a.a.d)localObject2).iEo != paramObject.tBc) {
            break label2438;
          }
          if (paramObject.tAZ > ((com.tencent.mm.plugin.ipcall.a.a.d)localObject2).lpM)
          {
            ((com.tencent.mm.plugin.ipcall.a.a.d)localObject2).lpM = paramObject.tAZ;
            if (paramObject.tBb != 0) {
              ((com.tencent.mm.plugin.ipcall.a.a.d)localObject2).dJB = paramObject.tBb;
            }
          }
          paramInt1 = 1;
        }
        for (;;)
        {
          break label2200;
          if (paramInt1 != 0) {
            break label2439;
          }
          localObject1 = new com.tencent.mm.plugin.ipcall.a.a.d();
          ((com.tencent.mm.plugin.ipcall.a.a.d)localObject1).iEo = paramObject.tBc;
          ((com.tencent.mm.plugin.ipcall.a.a.d)localObject1).dJB = paramObject.tBb;
          ((com.tencent.mm.plugin.ipcall.a.a.d)localObject1).lpM = paramObject.tAZ;
          this.loW.lqd.add(localObject1);
          break label2084;
          if (!(paramObject instanceof com.tencent.mm.plugin.ipcall.a.d.h))
          {
            y.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo heartbeat result error");
            return true;
          }
          y.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo heartbeat finished errType:%d,errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
          paramObject = (com.tencent.mm.plugin.ipcall.a.d.h)paramObject;
          if (this.loW.lpD == paramObject.lrD.sST) {
            break;
          }
          y.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo heartbeat finished but room id not the same, now room roomId:%d, before room roomId:%d", new Object[] { Integer.valueOf(this.loW.lpD), Integer.valueOf(paramObject.lrD.sST) });
          return true;
        }
      }
    }
  }
  
  private void gQ(boolean paramBoolean)
  {
    y.i("MicroMsg.IPCallSvrLogic", "handleInvite, success: %b, isLaunchCancel: %b, isLaunchShutdown: %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.loL), Boolean.valueOf(this.loM) });
    if ((this.loL) || (this.loM)) {
      y.i("MicroMsg.IPCallSvrLogic", "handleInvite, ignore this");
    }
    label112:
    do
    {
      return;
      if (paramBoolean)
      {
        if (this.loN != null)
        {
          if (this.loW.lpS) {
            break label112;
          }
          this.loN.bbD();
        }
        for (;;)
        {
          y.i("MicroMsg.IPCallSvrLogic", "start sync");
          this.loP.a(this.loW);
          return;
          this.loN.bby();
        }
      }
    } while (this.loN == null);
    if (this.loW.lpP)
    {
      this.loN.z(this.loW.lpK, this.loW.jxm, this.loW.lpJ);
      return;
    }
    if (this.loW.lpQ)
    {
      this.loN.A(this.loW.lpK, this.loW.jxm, this.loW.lpJ);
      return;
    }
    if (this.loW.lpR)
    {
      this.loN.B(this.loW.lpK, this.loW.jxm, this.loW.lpJ);
      return;
    }
    if (!this.loW.lpS)
    {
      this.loN.bbD();
      return;
    }
    this.loN.y(this.loW.lpK, this.loW.jxm, this.loW.lpJ);
  }
  
  private void gR(boolean paramBoolean)
  {
    y.i("MicroMsg.IPCallSvrLogic", "handleHeartbeat, success: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      this.loI += 1;
      if (this.loI >= 2)
      {
        y.e("MicroMsg.IPCallSvrLogic", "heartbeat failed twice!");
        this.loS.stop();
        if ((i.bck().bcd()) && (this.loN != null)) {
          this.loN.bbC();
        }
      }
      return;
    }
    this.loI = 0;
  }
  
  private void gS(boolean paramBoolean)
  {
    int i = 1;
    y.i("MicroMsg.IPCallSvrLogic", "handleSync, success: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((paramBoolean) && (i.bch().lqJ)) {
      i.bch().sI(this.loW.lpY);
    }
    if (!paramBoolean)
    {
      y.e("MicroMsg.IPCallSvrLogic", "sync failed!");
      this.loP.stop();
      if (i.bck().mCurrentState == 3) {
        if ((i != 0) && (this.loN != null)) {
          this.loN.bK(this.loW.jxm, this.loW.lpJ);
        }
      }
    }
    while ((this.loW == null) || (!paramBoolean)) {
      for (;;)
      {
        return;
        i = 0;
      }
    }
    sH(this.loW.bcx());
  }
  
  private void gT(boolean paramBoolean)
  {
    y.i("MicroMsg.IPCallSvrLogic", "handleNotify, success: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((paramBoolean) && (i.bch().lqJ)) {
      i.bch().sI(this.loW.lpY);
    }
    if ((this.loW != null) && (paramBoolean))
    {
      int i = this.loW.bcx();
      if ((i == 2) || (i == 1))
      {
        if (!this.loY)
        {
          o localo = new o(this.loW.lpD, this.loW.lpE, this.loW.bcw(), this.loW.lpF, false);
          au.Dk().a(localo, 0);
        }
      }
      else {
        sH(this.loW.bcx());
      }
    }
    else
    {
      return;
    }
    y.i("MicroMsg.IPCallSvrLogic", "current status has jni accepted, ignore notify accept");
  }
  
  private void gU(boolean paramBoolean)
  {
    Object localObject2 = null;
    y.i("MicroMsg.IPCallSvrLogic", "handleRedirect, isSuccess: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    com.tencent.mm.plugin.ipcall.a.c.a locala;
    com.tencent.mm.plugin.ipcall.a.a.c localc;
    if (paramBoolean)
    {
      locala = i.bch();
      localc = this.loW;
      y.i("MicroMsg.IPCallEngineManager", "redirectSvrAddr");
      if ((localc == null) || (localc.hID == null) || (localc.hID.size() <= 0)) {
        break label136;
      }
    }
    label136:
    for (cec localcec = com.tencent.mm.plugin.ipcall.b.c.ab(localc.hID);; localcec = null)
    {
      Object localObject1 = localObject2;
      if (localc != null)
      {
        localObject1 = localObject2;
        if (localc.lqb != null)
        {
          localObject1 = localObject2;
          if (localc.lqb.size() > 0) {
            localObject1 = com.tencent.mm.plugin.ipcall.b.c.ab(localc.lqb);
          }
        }
      }
      locala.lqG.a(localcec, localcec, (cec)localObject1, 0, 0);
      return;
    }
  }
  
  private void n(boolean paramBoolean, int paramInt)
  {
    y.i("MicroMsg.IPCallSvrLogic", "handleCancel, success: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((!paramBoolean) && (paramInt < 0) && (this.loK <= 0))
    {
      this.loK += 1;
      y.i("MicroMsg.IPCallSvrLogic", "cancel failed, retry count: %d", new Object[] { Integer.valueOf(this.loK) });
      this.loQ.a(this.loW);
    }
  }
  
  private void o(boolean paramBoolean, int paramInt)
  {
    y.i("MicroMsg.IPCallSvrLogic", "handleUserSelfShutdown, success: %b, isFromNotify: %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.loR.lsC) });
    if ((!paramBoolean) && (paramInt < 0) && (this.loJ <= 0))
    {
      this.loJ += 1;
      y.i("MicroMsg.IPCallSvrLogic", "shutdown failed, retry count: %d, isFromNotify: %b", new Object[] { Integer.valueOf(this.loJ), Boolean.valueOf(this.loR.lsC) });
      this.loR.a(this.loW);
    }
  }
  
  public final void a(int paramInt1, m paramm, int paramInt2, int paramInt3)
  {
    if (c(paramInt1, paramm, paramInt2, paramInt3))
    {
      y.i("MicroMsg.IPCallSvrLogic", "onTimerSuccess different room ignore");
      return;
    }
    switch (paramInt1)
    {
    case 3: 
    case 4: 
    default: 
      return;
    case 2: 
      gS(true);
      return;
    }
    gR(true);
  }
  
  public final void a(int paramInt1, Object paramObject, int paramInt2, int paramInt3)
  {
    if (c(paramInt1, paramObject, paramInt2, paramInt3))
    {
      y.i("MicroMsg.IPCallSvrLogic", "onServiceResult different room ignore");
      return;
    }
    switch (paramInt1)
    {
    case 2: 
    case 5: 
    case 7: 
    default: 
      return;
    case 1: 
      gQ(true);
      return;
    case 3: 
      n(true, paramInt3);
      return;
    case 4: 
      o(true, paramInt3);
      return;
    case 8: 
      gT(true);
      return;
    }
    gU(true);
  }
  
  public final void b(int paramInt1, m paramm, int paramInt2, int paramInt3)
  {
    if (c(paramInt1, paramm, paramInt2, paramInt3))
    {
      y.i("MicroMsg.IPCallSvrLogic", "onTimerFailed different room ignore");
      return;
    }
    switch (paramInt1)
    {
    case 3: 
    case 4: 
    default: 
      return;
    case 2: 
      gS(false);
      return;
    }
    gR(false);
  }
  
  public final void b(int paramInt1, Object paramObject, int paramInt2, int paramInt3)
  {
    if (c(paramInt1, paramObject, paramInt2, paramInt3))
    {
      y.i("MicroMsg.IPCallSvrLogic", "onServiceFailed different room ignore");
      return;
    }
    switch (paramInt1)
    {
    case 2: 
    case 5: 
    case 7: 
    default: 
      return;
    case 1: 
      gQ(false);
      return;
    case 3: 
      n(false, paramInt3);
      return;
    case 4: 
      o(false, paramInt3);
      return;
    case 8: 
      gT(false);
      return;
    }
    gU(false);
  }
  
  public final void bce()
  {
    if (this.loW.lqi) {
      y.e("MicroMsg.IPCallSvrLogic", "cancelIPCall, already accept");
    }
    this.loL = true;
    y.i("MicroMsg.IPCallSvrLogic", "cancelIPCall, roomId: %d, inviteId: %d", new Object[] { Integer.valueOf(this.loW.lpD), Integer.valueOf(this.loW.lpG) });
    this.loS.stop();
    this.loP.stop();
    this.loQ.a(this.loW);
    this.loU.a(this.loW);
  }
  
  public final void sG(int paramInt)
  {
    if (!this.loW.lqi) {
      y.e("MicroMsg.IPCallSvrLogic", "shutdownIPCall, user not accept");
    }
    y.i("MicroMsg.IPCallSvrLogic", "shutdownIPCall, roomId: %d, inviteId: %d", new Object[] { Integer.valueOf(this.loW.lpD), Integer.valueOf(this.loW.lpG) });
    this.loM = true;
    this.loS.stop();
    this.loP.stop();
    this.loR.lsC = false;
    this.loR.lsB = paramInt;
    this.loR.a(this.loW);
    this.loU.a(this.loW);
  }
  
  public final boolean sH(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1;
    switch (paramInt)
    {
    default: 
      y.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, do nothing:%d", new Object[] { Integer.valueOf(paramInt) });
      bool1 = false;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        return bool1;
                        y.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, user accept, isLaunchCancel: %b, isLaunchShutdown: %b", new Object[] { Boolean.valueOf(this.loL), Boolean.valueOf(this.loM) });
                        bool1 = bool2;
                      } while (this.loL);
                      bool1 = bool2;
                    } while (this.loM);
                    this.loP.stop();
                    bool1 = bool2;
                  } while (this.bWb);
                  this.bWb = true;
                  if (this.loW != null) {
                    this.loW.lqi = true;
                  }
                  if (this.loN != null) {
                    this.loN.bbA();
                  }
                  this.loS.a(this.loW);
                  return true;
                  y.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, user busy");
                  this.loP.stop();
                  this.loS.stop();
                  bool1 = bool2;
                } while (this.loN == null);
                this.loN.bJ(this.loW.jxm, this.loW.lpJ);
                return true;
                y.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, user ringing");
                bool1 = bool2;
              } while (this.loX);
              this.loX = true;
              bool1 = bool2;
            } while (this.loN == null);
            this.loN.bbz();
            return true;
            y.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, other side user shutdown");
            bool1 = bool2;
          } while (this.loN == null);
          this.loN.bbB();
          return true;
          y.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, user unavailable");
          if (!this.loW.lpR) {
            break;
          }
          bool1 = bool2;
        } while (this.loN == null);
        this.loN.B(this.loW.lpK, this.loW.jxm, this.loW.lpJ);
        return true;
        bool1 = bool2;
      } while (this.loN == null);
      this.loN.bI(this.loW.jxm, this.loW.lpJ);
      return true;
      y.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, shutdown overdue");
      this.loW.lpP = true;
      bool1 = bool2;
    } while (this.loN == null);
    this.loN.z(this.loW.lpK, this.loW.jxm, this.loW.lpJ);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.g
 * JD-Core Version:    0.7.0.1
 */