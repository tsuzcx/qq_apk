package com.tencent.mm.plugin.ipcall.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.model.bg;
import com.tencent.mm.network.p;
import com.tencent.mm.network.p.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.ipcall.model.b.a.a;
import com.tencent.mm.plugin.ipcall.model.b.b.a;
import com.tencent.mm.plugin.ipcall.model.d.b;
import com.tencent.mm.plugin.ipcall.model.e.k;
import com.tencent.mm.plugin.ipcall.model.e.n;
import com.tencent.mm.plugin.ipcall.model.e.o;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.dff;
import com.tencent.mm.protocal.protobuf.dfj;
import com.tencent.mm.protocal.protobuf.dfl;
import com.tencent.mm.protocal.protobuf.dfm;
import com.tencent.mm.protocal.protobuf.dfn;
import com.tencent.mm.protocal.protobuf.dfo;
import com.tencent.mm.protocal.protobuf.dfp;
import com.tencent.mm.protocal.protobuf.dfs;
import com.tencent.mm.protocal.protobuf.dfu;
import com.tencent.mm.protocal.protobuf.dfv;
import com.tencent.mm.protocal.protobuf.dfw;
import com.tencent.mm.protocal.protobuf.dml;
import com.tencent.mm.protocal.protobuf.dmm;
import com.tencent.mm.protocal.protobuf.esr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class g
  implements a.a, b.a
{
  public boolean dWM;
  public int yoI;
  public int yoJ;
  public int yoK;
  public boolean yoL;
  public boolean yoM;
  public a yoN;
  public com.tencent.mm.plugin.ipcall.model.g.d yoO;
  com.tencent.mm.plugin.ipcall.model.g.i yoP;
  com.tencent.mm.plugin.ipcall.model.g.a yoQ;
  com.tencent.mm.plugin.ipcall.model.g.h yoR;
  com.tencent.mm.plugin.ipcall.model.g.c yoS;
  public com.tencent.mm.plugin.ipcall.model.g.e yoT;
  com.tencent.mm.plugin.ipcall.model.g.g yoU;
  com.tencent.mm.plugin.ipcall.model.g.f yoV;
  public com.tencent.mm.plugin.ipcall.model.b.c yoW;
  public boolean yoX;
  public boolean yoY;
  p yoZ;
  
  public g()
  {
    AppMethodBeat.i(25364);
    this.yoI = 0;
    this.yoJ = 0;
    this.yoK = 0;
    this.yoL = false;
    this.yoM = false;
    this.yoX = false;
    this.dWM = false;
    this.yoY = false;
    this.yoZ = new p.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        int i = 0;
        AppMethodBeat.i(25363);
        Log.i("MicroMsg.IPCallSvrLogic", "onNetworkChange, st: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (i.eat().yqI)
        {
          f localf = i.eaw();
          if ((localf.mAT == 4) || (localf.mAT == 5)) {
            i = 1;
          }
          if ((i != 0) && (paramAnonymousInt == 4) && (g.this.yoV != null)) {
            g.this.yoV.a(g.this.yoW);
          }
        }
        AppMethodBeat.o(25363);
      }
    };
    this.yoO = new com.tencent.mm.plugin.ipcall.model.g.d();
    this.yoP = new com.tencent.mm.plugin.ipcall.model.g.i();
    this.yoQ = new com.tencent.mm.plugin.ipcall.model.g.a();
    this.yoR = new com.tencent.mm.plugin.ipcall.model.g.h();
    this.yoS = new com.tencent.mm.plugin.ipcall.model.g.c();
    this.yoT = new com.tencent.mm.plugin.ipcall.model.g.e();
    this.yoU = new com.tencent.mm.plugin.ipcall.model.g.g();
    this.yoV = new com.tencent.mm.plugin.ipcall.model.g.f();
    AppMethodBeat.o(25364);
  }
  
  private void L(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(25369);
    Log.i("MicroMsg.IPCallSvrLogic", "handleCancel, success: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((!paramBoolean) && (paramInt < 0) && (this.yoK <= 0))
    {
      this.yoK += 1;
      Log.i("MicroMsg.IPCallSvrLogic", "cancel failed, retry count: %d", new Object[] { Integer.valueOf(this.yoK) });
      this.yoQ.a(this.yoW);
      AppMethodBeat.o(25369);
      return;
    }
    AppMethodBeat.o(25369);
  }
  
  private void M(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(25370);
    Log.i("MicroMsg.IPCallSvrLogic", "handleUserSelfShutdown, success: %b, isFromNotify: %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.yoR.ysA) });
    if ((!paramBoolean) && (paramInt < 0) && (this.yoJ <= 0))
    {
      this.yoJ += 1;
      Log.i("MicroMsg.IPCallSvrLogic", "shutdown failed, retry count: %d, isFromNotify: %b", new Object[] { Integer.valueOf(this.yoJ), Boolean.valueOf(this.yoR.ysA) });
      this.yoR.a(this.yoW);
      AppMethodBeat.o(25370);
      return;
    }
    AppMethodBeat.o(25370);
  }
  
  private boolean c(int paramInt1, Object paramObject, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(25379);
    if ((this.yoW == null) || (paramObject == null))
    {
      Log.e("MicroMsg.IPCallSvrLogic", "callInfo = null or result = null");
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
            Log.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo invited result error");
            AppMethodBeat.o(25379);
            return true;
          }
          paramObject = (com.tencent.mm.plugin.ipcall.model.e.i)paramObject;
          localObject1 = paramObject.yrF;
          if (this.yoW.ypJ != paramObject.yrE.MKg)
          {
            Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo invited finished but invite id not the same, now room inviteId:%d, before room inviteId:%d", new Object[] { Integer.valueOf(this.yoW.ypJ), Integer.valueOf(paramObject.yrE.MKg) });
            AppMethodBeat.o(25379);
            return true;
          }
          Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo invited finished invite id:%d", new Object[] { Integer.valueOf(this.yoW.ypJ) });
          i.eau().gQ(this.yoW.ypJ, paramInt3);
          if ((paramInt2 == 0) && (paramInt3 == 0))
          {
            if (this.yoW != null)
            {
              this.yoW.roomId = ((dfm)localObject1).LsZ;
              this.yoW.ypH = ((dfm)localObject1).Lta;
              this.yoW.ypI = ((dfm)localObject1).MKi;
              this.yoW.ypO = ((dfm)localObject1).MKr;
              this.yoW.ypQ = (((dfm)localObject1).MKs * 1000);
              this.yoW.ypX = ((dfm)localObject1).ypX;
              this.yoW.ypY = ((dfm)localObject1).ypY;
              this.yoW.oMr = ((dfm)localObject1).KMD;
              this.yoW.yqe = ((dfm)localObject1).MKt;
              this.yoW.yqj = ((dfm)localObject1).MKu;
              if (((dfm)localObject1).yqf > 0) {
                this.yoW.yqf = ((dfm)localObject1).yqf;
              }
              this.yoW.ypZ = ((dfm)localObject1).ypZ;
              this.yoW.yqa = ((dfm)localObject1).yqa;
              this.yoW.ypW = ((dfm)localObject1).MKw;
              if (((dfm)localObject1).yqc > 0)
              {
                this.yoW.yqc = (((dfm)localObject1).yqc - 1);
                Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo zhengxue[ENCRYPT] got encryptStrategy[" + this.yoW.yqc + "] from Invite resp");
                this.yoW.yqd = ((dfm)localObject1).MKv;
                Log.d("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo NextInvite:%d", new Object[] { Integer.valueOf(((dfm)localObject1).ypR) });
                if (((dfm)localObject1).ypR <= 0) {
                  break label613;
                }
                this.yoW.ypV = false;
              }
              for (this.yoW.ypR = ((dfm)localObject1).ypR;; this.yoW.ypR = 0)
              {
                this.yoW.ypN = ((dfm)localObject1).ypN;
                this.yoW.ypM = ((dfm)localObject1).ypM;
                this.yoW.rBL = paramInt3;
                this.yoW.rBM = Util.nullAsNil(z.a(((dfm)localObject1).BaseResponse.ErrMsg));
                break;
                Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo zhengxue[ENCRYPT] got no encryptStrategy from Invite resp");
                this.yoW.yqc = 2;
                break label474;
                this.yoW.ypV = true;
              }
            }
          }
          else
          {
            Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo invite failed");
            if (((dfm)localObject1).BaseResponse != null)
            {
              if (paramInt3 == 433)
              {
                Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo account overdue");
                this.yoW.ypS = true;
                if (((dfm)localObject1).ypR <= 0) {
                  break label860;
                }
                this.yoW.ypV = false;
              }
              for (this.yoW.ypR = ((dfm)localObject1).ypR;; this.yoW.ypR = 0)
              {
                this.yoW.ypN = ((dfm)localObject1).ypN;
                this.yoW.ypM = ((dfm)localObject1).ypM;
                this.yoW.rBL = paramInt3;
                if (((dfm)localObject1).getBaseResponse() == null) {
                  break;
                }
                this.yoW.rBM = Util.nullAsNil(z.a(((dfm)localObject1).BaseResponse.ErrMsg));
                Log.d("MicroMsg.IPCallSvrLogic", "ErrLevel:%d,ErrCode:%d,ErrMsg:%s", new Object[] { Integer.valueOf(((dfm)localObject1).ypM), Integer.valueOf(paramInt3), this.yoW.rBM });
                break;
                if (paramInt3 == 434)
                {
                  Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo restrict call");
                  this.yoW.ypT = true;
                  break label672;
                }
                if (paramInt3 != 435) {
                  break label672;
                }
                Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo phonenumber invalid");
                this.yoW.ypU = true;
                break label672;
                this.yoW.ypV = true;
              }
            }
            this.yoW.ypN = "";
            this.yoW.ypM = 2;
            this.yoW.rBM = MMApplicationContext.getContext().getString(2131756927);
            this.yoW.rBL = paramInt3;
            continue;
            if (!(paramObject instanceof com.tencent.mm.plugin.ipcall.model.e.a))
            {
              Log.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo cancel result error");
              AppMethodBeat.o(25379);
              return true;
            }
            Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo cancel finished errType:%d,errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
            paramObject = (com.tencent.mm.plugin.ipcall.model.e.a)paramObject;
            if (this.yoW.ypJ != paramObject.yrn.MKg)
            {
              Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo cancel finished but invite id not the same, now room inviteId:%d, before room inviteId:%d", new Object[] { Integer.valueOf(this.yoW.ypJ), Integer.valueOf(paramObject.yrn.MKg) });
              AppMethodBeat.o(25379);
              return true;
              if (!(paramObject instanceof n))
              {
                Log.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown result error");
                AppMethodBeat.o(25379);
                return true;
              }
              paramObject = (n)paramObject;
              if (this.yoW.roomId != paramObject.yrO.LsZ)
              {
                Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown finished but room id not the same, now room roomId:%d, before room roomId:%d", new Object[] { Integer.valueOf(this.yoW.roomId), Integer.valueOf(paramObject.yrO.LsZ) });
                AppMethodBeat.o(25379);
                return true;
              }
              if ((paramInt2 == 0) && (paramInt3 == 0))
              {
                Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown success!");
                this.yoW.lPy = 5;
              }
              else
              {
                Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown failed");
              }
            }
          }
        }
        if (!(paramObject instanceof dfn))
        {
          Log.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo notify result error");
          AppMethodBeat.o(25379);
          return true;
        }
        Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo notify finished");
        paramObject = (dfn)paramObject;
        if (this.yoW.roomId != paramObject.LsZ)
        {
          Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown finished but room id not the same, now room roomId:%d, before room roomId:%d", new Object[] { Integer.valueOf(this.yoW.roomId), Integer.valueOf(paramObject.LsZ) });
          AppMethodBeat.o(25379);
          return true;
        }
      } while ((paramInt2 != 0) || (paramInt3 != 0));
      this.yoW.yqb = paramObject.yqb;
      Log.d("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo updateNotifyCallInfo, UserStatuslist.size: %d", new Object[] { Integer.valueOf(paramObject.MKx.size()) });
      paramObject = paramObject.MKx.iterator();
      while (paramObject.hasNext())
      {
        localObject1 = (dfw)paramObject.next();
        if (this.yoW.ypO != ((dfw)localObject1).MKG) {
          break label1537;
        }
        Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo update self userStatus, memberId: %d, status: %d, syncKey: %d", new Object[] { Integer.valueOf(this.yoW.ypO), Integer.valueOf(((dfw)localObject1).MKH), Integer.valueOf(((dfw)localObject1).MKI) });
        if (((dfw)localObject1).MKI > this.yoW.ypP)
        {
          this.yoW.ypP = ((dfw)localObject1).MKI;
          if (((dfw)localObject1).MKH != 0) {
            this.yoW.lPy = ((dfw)localObject1).MKH;
          }
        }
        label1448:
        if ((((dfw)localObject1).rBL == 404) || (((dfw)localObject1).rBL == 484))
        {
          Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo notify phonenumber invalid");
          this.yoW.ypU = true;
        }
        this.yoW.rBM = ((dfw)localObject1).rBM;
        this.yoW.rBL = ((dfw)localObject1).rBL;
        this.yoW.ypM = ((dfw)localObject1).ypM;
        this.yoW.ypN = ((dfw)localObject1).ypN;
      }
      label1537:
      Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo update others userStatus, memberId: %d, status: %d, syncKey: %d", new Object[] { Integer.valueOf(((dfw)localObject1).MKG), Integer.valueOf(((dfw)localObject1).MKH), Integer.valueOf(((dfw)localObject1).MKI) });
      paramInt1 = 0;
      localObject2 = this.yoW.yqg.iterator();
      label1596:
      if (((Iterator)localObject2).hasNext())
      {
        com.tencent.mm.plugin.ipcall.model.b.d locald = (com.tencent.mm.plugin.ipcall.model.b.d)((Iterator)localObject2).next();
        if (locald.qrD != ((dfw)localObject1).MKG) {
          break label2539;
        }
        if (((dfw)localObject1).MKI > locald.ypP)
        {
          locald.ypP = ((dfw)localObject1).MKI;
          if (((dfw)localObject1).MKH != 0) {
            locald.hpS = ((dfw)localObject1).MKH;
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
      ((com.tencent.mm.plugin.ipcall.model.b.d)localObject2).qrD = ((dfw)localObject1).MKG;
      ((com.tencent.mm.plugin.ipcall.model.b.d)localObject2).hpS = ((dfw)localObject1).MKH;
      ((com.tencent.mm.plugin.ipcall.model.b.d)localObject2).ypP = ((dfw)localObject1).MKI;
      this.yoW.yqg.add(localObject2);
      break label1448;
      if (!(paramObject instanceof k))
      {
        Log.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo redirect result error");
        AppMethodBeat.o(25379);
        return true;
      }
      paramObject = (k)paramObject;
      localObject1 = paramObject.yrJ;
      if (this.yoW.roomId != paramObject.yrI.LsZ)
      {
        Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo redirect finished but room id not the same, now room roomId:%d, before room roomId:%d", new Object[] { Integer.valueOf(this.yoW.roomId), Integer.valueOf(paramObject.yrI.LsZ) });
        AppMethodBeat.o(25379);
        return true;
      }
      if ((paramInt2 == 0) && (paramInt3 == 0))
      {
        Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo redirect success");
        this.yoW.oMr = ((dfp)localObject1).KMD;
        this.yoW.yqe = ((dfp)localObject1).MKt;
        break;
      }
      Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo redirect failed");
      break;
      if (!(paramObject instanceof o))
      {
        Log.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync result error");
        AppMethodBeat.o(25379);
        return true;
      }
      Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync finished errType:%d,errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      localObject1 = (o)paramObject;
      paramObject = ((o)localObject1).yrR;
      if (this.yoW.roomId != ((o)localObject1).yrQ.LsZ)
      {
        Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync finished but room id not the same, now room roomId:%d, before room roomId:%d", new Object[] { Integer.valueOf(this.yoW.roomId), Integer.valueOf(((o)localObject1).yrQ.LsZ) });
        AppMethodBeat.o(25379);
        return true;
      }
      if ((paramInt2 != 0) || (paramInt3 != 0)) {
        break;
      }
      Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync roomId: %d, status: %d, memberId: %d, syncKey: %d", new Object[] { Integer.valueOf(paramObject.LsZ), Integer.valueOf(paramObject.MKF), Integer.valueOf(paramObject.MKG), Integer.valueOf(paramObject.MKD) });
      if ((paramObject.LsZ != this.yoW.roomId) || (paramObject.Lta != this.yoW.ypH)) {
        break;
      }
      if (paramObject.MKG == this.yoW.ypO)
      {
        Log.d("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync update self status");
        if (paramObject.MKD > this.yoW.ypP)
        {
          this.yoW.ypP = paramObject.MKD;
          if (paramObject.MKF != 0) {
            this.yoW.lPy = paramObject.MKF;
          }
        }
      }
      for (;;)
      {
        label2170:
        if ((paramObject.rBL == 404) || (paramObject.rBL == 484))
        {
          Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync phonenumber invalid");
          this.yoW.ypU = true;
        }
        this.yoW.rBM = paramObject.rBM;
        this.yoW.rBL = paramObject.rBL;
        this.yoW.ypM = paramObject.ypM;
        this.yoW.ypN = paramObject.ypN;
        this.yoW.yqb = paramObject.yqb;
        break;
        Log.d("MicroMsg.IPCallSvrLogic", " handleServiceResultCallInfosync update others status");
        localObject1 = this.yoW.yqg.iterator();
        paramInt1 = 0;
        label2286:
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (com.tencent.mm.plugin.ipcall.model.b.d)((Iterator)localObject1).next();
          if (((com.tencent.mm.plugin.ipcall.model.b.d)localObject2).qrD != paramObject.MKG) {
            break label2536;
          }
          if (paramObject.MKD > ((com.tencent.mm.plugin.ipcall.model.b.d)localObject2).ypP)
          {
            ((com.tencent.mm.plugin.ipcall.model.b.d)localObject2).ypP = paramObject.MKD;
            if (paramObject.MKF != 0) {
              ((com.tencent.mm.plugin.ipcall.model.b.d)localObject2).hpS = paramObject.MKF;
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
          ((com.tencent.mm.plugin.ipcall.model.b.d)localObject1).qrD = paramObject.MKG;
          ((com.tencent.mm.plugin.ipcall.model.b.d)localObject1).hpS = paramObject.MKF;
          ((com.tencent.mm.plugin.ipcall.model.b.d)localObject1).ypP = paramObject.MKD;
          this.yoW.yqg.add(localObject1);
          break label2170;
          if (!(paramObject instanceof com.tencent.mm.plugin.ipcall.model.e.h))
          {
            Log.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo heartbeat result error");
            AppMethodBeat.o(25379);
            return true;
          }
          Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo heartbeat finished errType:%d,errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
          paramObject = (com.tencent.mm.plugin.ipcall.model.e.h)paramObject;
          if (this.yoW.roomId == paramObject.yrC.LsZ) {
            break;
          }
          Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo heartbeat finished but room id not the same, now room roomId:%d, before room roomId:%d", new Object[] { Integer.valueOf(this.yoW.roomId), Integer.valueOf(paramObject.yrC.LsZ) });
          AppMethodBeat.o(25379);
          return true;
        }
      }
    }
  }
  
  private void qp(boolean paramBoolean)
  {
    AppMethodBeat.i(25367);
    Log.i("MicroMsg.IPCallSvrLogic", "handleInvite, success: %b, isLaunchCancel: %b, isLaunchShutdown: %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.yoL), Boolean.valueOf(this.yoM) });
    if ((this.yoL) || (this.yoM))
    {
      Log.i("MicroMsg.IPCallSvrLogic", "handleInvite, ignore this");
      AppMethodBeat.o(25367);
      return;
    }
    if (paramBoolean)
    {
      if (this.yoN != null)
      {
        if (this.yoW.ypV) {
          break label130;
        }
        this.yoN.dZN();
      }
      for (;;)
      {
        Log.i("MicroMsg.IPCallSvrLogic", "start sync");
        this.yoP.a(this.yoW);
        AppMethodBeat.o(25367);
        return;
        label130:
        this.yoN.dZI();
      }
    }
    if (this.yoN != null)
    {
      if (this.yoW.ypS)
      {
        this.yoN.Y(this.yoW.ypN, this.yoW.rBM, this.yoW.ypM);
        AppMethodBeat.o(25367);
        return;
      }
      if (this.yoW.ypT)
      {
        this.yoN.Z(this.yoW.ypN, this.yoW.rBM, this.yoW.ypM);
        AppMethodBeat.o(25367);
        return;
      }
      if (this.yoW.ypU)
      {
        this.yoN.aa(this.yoW.ypN, this.yoW.rBM, this.yoW.ypM);
        AppMethodBeat.o(25367);
        return;
      }
      if (!this.yoW.ypV)
      {
        this.yoN.dZN();
        AppMethodBeat.o(25367);
        return;
      }
      this.yoN.X(this.yoW.ypN, this.yoW.rBM, this.yoW.ypM);
    }
    AppMethodBeat.o(25367);
  }
  
  private void qq(boolean paramBoolean)
  {
    AppMethodBeat.i(25368);
    Log.i("MicroMsg.IPCallSvrLogic", "handleHeartbeat, success: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      this.yoI += 1;
      if (this.yoI >= 2)
      {
        Log.e("MicroMsg.IPCallSvrLogic", "heartbeat failed twice!");
        this.yoS.stop();
        if ((i.eaw().eao()) && (this.yoN != null))
        {
          this.yoN.dZM();
          AppMethodBeat.o(25368);
        }
      }
    }
    else
    {
      this.yoI = 0;
    }
    AppMethodBeat.o(25368);
  }
  
  private void qr(boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(25371);
    Log.i("MicroMsg.IPCallSvrLogic", "handleSync, success: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((paramBoolean) && (i.eat().yqI)) {
      i.eat().Pd(this.yoW.yqb);
    }
    if (!paramBoolean)
    {
      Log.e("MicroMsg.IPCallSvrLogic", "sync failed!");
      this.yoP.stop();
      if (i.eaw().mAT == 3) {}
      for (;;)
      {
        if ((i != 0) && (this.yoN != null)) {
          this.yoN.er(this.yoW.rBM, this.yoW.ypM);
        }
        AppMethodBeat.o(25371);
        return;
        i = 0;
      }
    }
    if ((this.yoW != null) && (paramBoolean)) {
      Pc(this.yoW.eaJ());
    }
    AppMethodBeat.o(25371);
  }
  
  private void qs(boolean paramBoolean)
  {
    AppMethodBeat.i(25372);
    Log.i("MicroMsg.IPCallSvrLogic", "handleNotify, success: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((paramBoolean) && (i.eat().yqI)) {
      i.eat().Pd(this.yoW.yqb);
    }
    if ((this.yoW != null) && (paramBoolean))
    {
      int i = this.yoW.eaJ();
      if ((i == 2) || (i == 1))
      {
        if (!this.yoY)
        {
          o localo = new o(this.yoW.roomId, this.yoW.ypH, this.yoW.eaI(), this.yoW.ypI, false);
          bg.azz().a(localo, 0);
        }
      }
      else {
        Pc(this.yoW.eaJ());
      }
    }
    else
    {
      AppMethodBeat.o(25372);
      return;
    }
    Log.i("MicroMsg.IPCallSvrLogic", "current status has jni accepted, ignore notify accept");
    AppMethodBeat.o(25372);
  }
  
  private void qt(boolean paramBoolean)
  {
    AppMethodBeat.i(25374);
    Log.i("MicroMsg.IPCallSvrLogic", "handleRedirect, isSuccess: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    com.tencent.mm.plugin.ipcall.model.d.a locala;
    Object localObject1;
    Object localObject2;
    if (paramBoolean)
    {
      locala = i.eat();
      localObject1 = this.yoW;
      Log.i("MicroMsg.IPCallEngineManager", "redirectSvrAddr");
      if ((localObject1 != null) && (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).oMr != null) && (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).oMr.size() > 0)) {
        com.tencent.mm.plugin.ipcall.a.c.bc(((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).oMr);
      }
      if ((localObject1 != null) && (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).yqe != null) && (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).yqe.size() > 0)) {
        com.tencent.mm.plugin.ipcall.a.c.bc(((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).yqe);
      }
      localObject2 = new dmm();
      dml localdml = new dml();
      localdml.LqX = 0;
      localdml.LqY = "";
      localdml.LqZ = "";
      localdml.Lra = 4;
      localdml.Lrb = 4;
      localdml.Lrc = 2;
      localdml.MPX = new esr();
      localdml.MPY = new esr();
      if ((localObject1 != null) && (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).oMr != null) && (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).oMr.size() > 0)) {
        localdml.MPX = com.tencent.mm.plugin.ipcall.a.c.bc(((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).oMr);
      }
      if ((localObject1 != null) && (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).yqe != null) && (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).yqe.size() > 0)) {
        localdml.MPY = com.tencent.mm.plugin.ipcall.a.c.bc(((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).yqe);
      }
      ((dmm)localObject2).MQa.add(localdml);
      ((dmm)localObject2).MPZ = 1;
      localObject1 = null;
    }
    try
    {
      localObject2 = ((dmm)localObject2).toByteArray();
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i;
        Log.e("MicroMsg.IPCallEngineManager", "conn info to byte array fail..");
      }
    }
    if (localObject1 != null)
    {
      i = locala.yqF.AddNewRelayConns((byte[])localObject1, localObject1.length, 1);
      if (i != 0) {
        com.tencent.mm.plugin.voip.b.e.Loge("MicroMsg.IPCallEngineManager", "redirect relay conns fail ret:".concat(String.valueOf(i)));
      }
    }
    AppMethodBeat.o(25374);
  }
  
  public final void Pb(int paramInt)
  {
    AppMethodBeat.i(25366);
    if (!this.yoW.yqk) {
      Log.e("MicroMsg.IPCallSvrLogic", "shutdownIPCall, user not accept");
    }
    Log.i("MicroMsg.IPCallSvrLogic", "shutdownIPCall, roomId: %d, inviteId: %d", new Object[] { Integer.valueOf(this.yoW.roomId), Integer.valueOf(this.yoW.ypJ) });
    this.yoM = true;
    this.yoS.stop();
    this.yoP.stop();
    this.yoR.ysA = false;
    this.yoR.ysz = paramInt;
    this.yoR.a(this.yoW);
    this.yoU.a(this.yoW);
    AppMethodBeat.o(25366);
  }
  
  public final boolean Pc(int paramInt)
  {
    AppMethodBeat.i(25373);
    switch (paramInt)
    {
    default: 
      Log.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, do nothing:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(25373);
      return false;
    case 2: 
      Log.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, user accept, isLaunchCancel: %b, isLaunchShutdown: %b", new Object[] { Boolean.valueOf(this.yoL), Boolean.valueOf(this.yoM) });
      if ((this.yoL) || (this.yoM))
      {
        AppMethodBeat.o(25373);
        return true;
      }
      this.yoP.stop();
      if (!this.dWM)
      {
        this.dWM = true;
        if (this.yoW != null) {
          this.yoW.yqk = true;
        }
        if (this.yoN != null) {
          this.yoN.dZK();
        }
        this.yoS.a(this.yoW);
      }
      AppMethodBeat.o(25373);
      return true;
    case 3: 
      Log.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, user busy");
      this.yoP.stop();
      this.yoS.stop();
      if (this.yoN != null) {
        this.yoN.eq(this.yoW.rBM, this.yoW.ypM);
      }
      AppMethodBeat.o(25373);
      return true;
    case 1: 
      Log.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, user ringing");
      if (!this.yoX)
      {
        this.yoX = true;
        if (this.yoN != null) {
          this.yoN.dZJ();
        }
      }
      AppMethodBeat.o(25373);
      return true;
    case 5: 
      Log.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, other side user shutdown");
      if (this.yoN != null) {
        this.yoN.dZL();
      }
      AppMethodBeat.o(25373);
      return true;
    case 4: 
    case 7: 
    case 8: 
      Log.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, user unavailable");
      if (this.yoW.ypU) {
        if (this.yoN != null) {
          this.yoN.aa(this.yoW.ypN, this.yoW.rBM, this.yoW.ypM);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(25373);
        return true;
        if (this.yoN != null) {
          this.yoN.ep(this.yoW.rBM, this.yoW.ypM);
        }
      }
    }
    Log.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, shutdown overdue");
    this.yoW.ypS = true;
    if (this.yoN != null) {
      this.yoN.Y(this.yoW.ypN, this.yoW.rBM, this.yoW.ypM);
    }
    AppMethodBeat.o(25373);
    return true;
  }
  
  public final void a(int paramInt1, q paramq, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(25377);
    if (c(paramInt1, paramq, paramInt2, paramInt3))
    {
      Log.i("MicroMsg.IPCallSvrLogic", "onTimerSuccess different room ignore");
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
      qr(true);
      AppMethodBeat.o(25377);
      return;
      qq(true);
    }
  }
  
  public final void a(int paramInt1, Object paramObject, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(25375);
    if (c(paramInt1, paramObject, paramInt2, paramInt3))
    {
      Log.i("MicroMsg.IPCallSvrLogic", "onServiceResult different room ignore");
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
      qp(true);
      AppMethodBeat.o(25375);
      return;
      L(true, paramInt3);
      AppMethodBeat.o(25375);
      return;
      M(true, paramInt3);
      AppMethodBeat.o(25375);
      return;
      qs(true);
      AppMethodBeat.o(25375);
      return;
      qt(true);
    }
  }
  
  public final void b(int paramInt1, q paramq, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(25378);
    if (c(paramInt1, paramq, paramInt2, paramInt3))
    {
      Log.i("MicroMsg.IPCallSvrLogic", "onTimerFailed different room ignore");
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
      qr(false);
      AppMethodBeat.o(25378);
      return;
      qq(false);
    }
  }
  
  public final void b(int paramInt1, Object paramObject, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(25376);
    if (c(paramInt1, paramObject, paramInt2, paramInt3))
    {
      Log.i("MicroMsg.IPCallSvrLogic", "onServiceFailed different room ignore");
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
      qp(false);
      AppMethodBeat.o(25376);
      return;
      L(false, paramInt3);
      AppMethodBeat.o(25376);
      return;
      M(false, paramInt3);
      AppMethodBeat.o(25376);
      return;
      qs(false);
      AppMethodBeat.o(25376);
      return;
      qt(false);
    }
  }
  
  public final void eap()
  {
    AppMethodBeat.i(25365);
    if (this.yoW.yqk) {
      Log.e("MicroMsg.IPCallSvrLogic", "cancelIPCall, already accept");
    }
    this.yoL = true;
    Log.i("MicroMsg.IPCallSvrLogic", "cancelIPCall, roomId: %d, inviteId: %d", new Object[] { Integer.valueOf(this.yoW.roomId), Integer.valueOf(this.yoW.ypJ) });
    this.yoS.stop();
    this.yoP.stop();
    this.yoQ.a(this.yoW);
    this.yoU.a(this.yoW);
    AppMethodBeat.o(25365);
  }
  
  public static abstract interface a
  {
    public abstract void X(String paramString1, String paramString2, int paramInt);
    
    public abstract void Y(String paramString1, String paramString2, int paramInt);
    
    public abstract void Z(String paramString1, String paramString2, int paramInt);
    
    public abstract void aa(String paramString1, String paramString2, int paramInt);
    
    public abstract void dZI();
    
    public abstract void dZJ();
    
    public abstract void dZK();
    
    public abstract void dZL();
    
    public abstract void dZM();
    
    public abstract void dZN();
    
    public abstract void ep(String paramString, int paramInt);
    
    public abstract void eq(String paramString, int paramInt);
    
    public abstract void er(String paramString, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.g
 * JD-Core Version:    0.7.0.1
 */