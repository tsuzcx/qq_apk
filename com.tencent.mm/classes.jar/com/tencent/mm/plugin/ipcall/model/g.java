package com.tencent.mm.plugin.ipcall.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.model.bh;
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
import com.tencent.mm.protocal.protobuf.doz;
import com.tencent.mm.protocal.protobuf.dpd;
import com.tencent.mm.protocal.protobuf.dpf;
import com.tencent.mm.protocal.protobuf.dpg;
import com.tencent.mm.protocal.protobuf.dph;
import com.tencent.mm.protocal.protobuf.dpi;
import com.tencent.mm.protocal.protobuf.dpj;
import com.tencent.mm.protocal.protobuf.dpm;
import com.tencent.mm.protocal.protobuf.dpo;
import com.tencent.mm.protocal.protobuf.dpp;
import com.tencent.mm.protocal.protobuf.dpq;
import com.tencent.mm.protocal.protobuf.dwc;
import com.tencent.mm.protocal.protobuf.dwd;
import com.tencent.mm.protocal.protobuf.fdc;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class g
  implements a.a, b.a
{
  public int DOK;
  public int DOL;
  public int DOM;
  public boolean DON;
  public boolean DOO;
  public a DOP;
  public com.tencent.mm.plugin.ipcall.model.g.d DOQ;
  com.tencent.mm.plugin.ipcall.model.g.i DOR;
  com.tencent.mm.plugin.ipcall.model.g.a DOS;
  com.tencent.mm.plugin.ipcall.model.g.h DOT;
  com.tencent.mm.plugin.ipcall.model.g.c DOU;
  public com.tencent.mm.plugin.ipcall.model.g.e DOV;
  com.tencent.mm.plugin.ipcall.model.g.g DOW;
  com.tencent.mm.plugin.ipcall.model.g.f DOX;
  public com.tencent.mm.plugin.ipcall.model.b.c DOY;
  public boolean DOZ;
  public boolean DPa;
  p DPb;
  public boolean fQy;
  
  public g()
  {
    AppMethodBeat.i(25364);
    this.DOK = 0;
    this.DOL = 0;
    this.DOM = 0;
    this.DON = false;
    this.DOO = false;
    this.DOZ = false;
    this.fQy = false;
    this.DPa = false;
    this.DPb = new p.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        int i = 0;
        AppMethodBeat.i(25363);
        Log.i("MicroMsg.IPCallSvrLogic", "onNetworkChange, st: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (i.eJr().DQK)
        {
          f localf = i.eJu();
          if ((localf.pzp == 4) || (localf.pzp == 5)) {
            i = 1;
          }
          if ((i != 0) && (paramAnonymousInt == 4) && (g.this.DOX != null)) {
            g.this.DOX.a(g.this.DOY);
          }
        }
        AppMethodBeat.o(25363);
      }
    };
    this.DOQ = new com.tencent.mm.plugin.ipcall.model.g.d();
    this.DOR = new com.tencent.mm.plugin.ipcall.model.g.i();
    this.DOS = new com.tencent.mm.plugin.ipcall.model.g.a();
    this.DOT = new com.tencent.mm.plugin.ipcall.model.g.h();
    this.DOU = new com.tencent.mm.plugin.ipcall.model.g.c();
    this.DOV = new com.tencent.mm.plugin.ipcall.model.g.e();
    this.DOW = new com.tencent.mm.plugin.ipcall.model.g.g();
    this.DOX = new com.tencent.mm.plugin.ipcall.model.g.f();
    AppMethodBeat.o(25364);
  }
  
  private void X(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(25369);
    Log.i("MicroMsg.IPCallSvrLogic", "handleCancel, success: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((!paramBoolean) && (paramInt < 0) && (this.DOM <= 0))
    {
      this.DOM += 1;
      Log.i("MicroMsg.IPCallSvrLogic", "cancel failed, retry count: %d", new Object[] { Integer.valueOf(this.DOM) });
      this.DOS.a(this.DOY);
      AppMethodBeat.o(25369);
      return;
    }
    AppMethodBeat.o(25369);
  }
  
  private void Y(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(25370);
    Log.i("MicroMsg.IPCallSvrLogic", "handleUserSelfShutdown, success: %b, isFromNotify: %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.DOT.DSC) });
    if ((!paramBoolean) && (paramInt < 0) && (this.DOL <= 0))
    {
      this.DOL += 1;
      Log.i("MicroMsg.IPCallSvrLogic", "shutdown failed, retry count: %d, isFromNotify: %b", new Object[] { Integer.valueOf(this.DOL), Boolean.valueOf(this.DOT.DSC) });
      this.DOT.a(this.DOY);
      AppMethodBeat.o(25370);
      return;
    }
    AppMethodBeat.o(25370);
  }
  
  private boolean c(int paramInt1, Object paramObject, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(25379);
    if ((this.DOY == null) || (paramObject == null))
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
          localObject1 = paramObject.DRH;
          if (this.DOY.DPL != paramObject.DRG.TWa)
          {
            Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo invited finished but invite id not the same, now room inviteId:%d, before room inviteId:%d", new Object[] { Integer.valueOf(this.DOY.DPL), Integer.valueOf(paramObject.DRG.TWa) });
            AppMethodBeat.o(25379);
            return true;
          }
          Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo invited finished invite id:%d", new Object[] { Integer.valueOf(this.DOY.DPL) });
          i.eJs().hU(this.DOY.DPL, paramInt3);
          if ((paramInt2 == 0) && (paramInt3 == 0))
          {
            if (this.DOY != null)
            {
              this.DOY.roomId = ((dpg)localObject1).Svu;
              this.DOY.DPJ = ((dpg)localObject1).Svv;
              this.DOY.DPK = ((dpg)localObject1).TWc;
              this.DOY.DPQ = ((dpg)localObject1).TWl;
              this.DOY.DPS = (((dpg)localObject1).TWm * 1000);
              this.DOY.DPZ = ((dpg)localObject1).DPZ;
              this.DOY.DQa = ((dpg)localObject1).DQa;
              this.DOY.rOm = ((dpg)localObject1).RNx;
              this.DOY.DQg = ((dpg)localObject1).TWn;
              this.DOY.DQl = ((dpg)localObject1).TWo;
              if (((dpg)localObject1).DQh > 0) {
                this.DOY.DQh = ((dpg)localObject1).DQh;
              }
              this.DOY.DQb = ((dpg)localObject1).DQb;
              this.DOY.DQc = ((dpg)localObject1).DQc;
              this.DOY.DPY = ((dpg)localObject1).TWq;
              if (((dpg)localObject1).DQe > 0)
              {
                this.DOY.DQe = (((dpg)localObject1).DQe - 1);
                Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo zhengxue[ENCRYPT] got encryptStrategy[" + this.DOY.DQe + "] from Invite resp");
                this.DOY.DQf = ((dpg)localObject1).TWp;
                Log.d("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo NextInvite:%d", new Object[] { Integer.valueOf(((dpg)localObject1).DPT) });
                if (((dpg)localObject1).DPT <= 0) {
                  break label613;
                }
                this.DOY.DPX = false;
              }
              for (this.DOY.DPT = ((dpg)localObject1).DPT;; this.DOY.DPT = 0)
              {
                this.DOY.DPP = ((dpg)localObject1).DPP;
                this.DOY.DPO = ((dpg)localObject1).DPO;
                this.DOY.vht = paramInt3;
                this.DOY.vhu = Util.nullAsNil(z.a(((dpg)localObject1).BaseResponse.Tef));
                break;
                Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo zhengxue[ENCRYPT] got no encryptStrategy from Invite resp");
                this.DOY.DQe = 2;
                break label474;
                this.DOY.DPX = true;
              }
            }
          }
          else
          {
            Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo invite failed");
            if (((dpg)localObject1).BaseResponse != null)
            {
              if (paramInt3 == 433)
              {
                Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo account overdue");
                this.DOY.DPU = true;
                if (((dpg)localObject1).DPT <= 0) {
                  break label860;
                }
                this.DOY.DPX = false;
              }
              for (this.DOY.DPT = ((dpg)localObject1).DPT;; this.DOY.DPT = 0)
              {
                this.DOY.DPP = ((dpg)localObject1).DPP;
                this.DOY.DPO = ((dpg)localObject1).DPO;
                this.DOY.vht = paramInt3;
                if (((dpg)localObject1).getBaseResponse() == null) {
                  break;
                }
                this.DOY.vhu = Util.nullAsNil(z.a(((dpg)localObject1).BaseResponse.Tef));
                Log.d("MicroMsg.IPCallSvrLogic", "ErrLevel:%d,ErrCode:%d,ErrMsg:%s", new Object[] { Integer.valueOf(((dpg)localObject1).DPO), Integer.valueOf(paramInt3), this.DOY.vhu });
                break;
                if (paramInt3 == 434)
                {
                  Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo restrict call");
                  this.DOY.DPV = true;
                  break label672;
                }
                if (paramInt3 != 435) {
                  break label672;
                }
                Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo phonenumber invalid");
                this.DOY.DPW = true;
                break label672;
                this.DOY.DPX = true;
              }
            }
            this.DOY.DPP = "";
            this.DOY.DPO = 2;
            this.DOY.vhu = MMApplicationContext.getContext().getString(R.l.etF);
            this.DOY.vht = paramInt3;
            continue;
            if (!(paramObject instanceof com.tencent.mm.plugin.ipcall.model.e.a))
            {
              Log.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo cancel result error");
              AppMethodBeat.o(25379);
              return true;
            }
            Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo cancel finished errType:%d,errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
            paramObject = (com.tencent.mm.plugin.ipcall.model.e.a)paramObject;
            if (this.DOY.DPL != paramObject.DRp.TWa)
            {
              Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo cancel finished but invite id not the same, now room inviteId:%d, before room inviteId:%d", new Object[] { Integer.valueOf(this.DOY.DPL), Integer.valueOf(paramObject.DRp.TWa) });
              AppMethodBeat.o(25379);
              return true;
              if (!(paramObject instanceof n))
              {
                Log.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown result error");
                AppMethodBeat.o(25379);
                return true;
              }
              paramObject = (n)paramObject;
              if (this.DOY.roomId != paramObject.DRQ.Svu)
              {
                Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown finished but room id not the same, now room roomId:%d, before room roomId:%d", new Object[] { Integer.valueOf(this.DOY.roomId), Integer.valueOf(paramObject.DRQ.Svu) });
                AppMethodBeat.o(25379);
                return true;
              }
              if ((paramInt2 == 0) && (paramInt3 == 0))
              {
                Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown success!");
                this.DOY.oLS = 5;
              }
              else
              {
                Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown failed");
              }
            }
          }
        }
        if (!(paramObject instanceof dph))
        {
          Log.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo notify result error");
          AppMethodBeat.o(25379);
          return true;
        }
        Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo notify finished");
        paramObject = (dph)paramObject;
        if (this.DOY.roomId != paramObject.Svu)
        {
          Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown finished but room id not the same, now room roomId:%d, before room roomId:%d", new Object[] { Integer.valueOf(this.DOY.roomId), Integer.valueOf(paramObject.Svu) });
          AppMethodBeat.o(25379);
          return true;
        }
      } while ((paramInt2 != 0) || (paramInt3 != 0));
      this.DOY.DQd = paramObject.DQd;
      Log.d("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo updateNotifyCallInfo, UserStatuslist.size: %d", new Object[] { Integer.valueOf(paramObject.TWr.size()) });
      paramObject = paramObject.TWr.iterator();
      while (paramObject.hasNext())
      {
        localObject1 = (dpq)paramObject.next();
        if (this.DOY.DPQ != ((dpq)localObject1).TWA) {
          break label1537;
        }
        Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo update self userStatus, memberId: %d, status: %d, syncKey: %d", new Object[] { Integer.valueOf(this.DOY.DPQ), Integer.valueOf(((dpq)localObject1).TWB), Integer.valueOf(((dpq)localObject1).TWC) });
        if (((dpq)localObject1).TWC > this.DOY.DPR)
        {
          this.DOY.DPR = ((dpq)localObject1).TWC;
          if (((dpq)localObject1).TWB != 0) {
            this.DOY.oLS = ((dpq)localObject1).TWB;
          }
        }
        label1448:
        if ((((dpq)localObject1).vht == 404) || (((dpq)localObject1).vht == 484))
        {
          Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo notify phonenumber invalid");
          this.DOY.DPW = true;
        }
        this.DOY.vhu = ((dpq)localObject1).vhu;
        this.DOY.vht = ((dpq)localObject1).vht;
        this.DOY.DPO = ((dpq)localObject1).DPO;
        this.DOY.DPP = ((dpq)localObject1).DPP;
      }
      label1537:
      Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo update others userStatus, memberId: %d, status: %d, syncKey: %d", new Object[] { Integer.valueOf(((dpq)localObject1).TWA), Integer.valueOf(((dpq)localObject1).TWB), Integer.valueOf(((dpq)localObject1).TWC) });
      paramInt1 = 0;
      localObject2 = this.DOY.DQi.iterator();
      label1596:
      if (((Iterator)localObject2).hasNext())
      {
        com.tencent.mm.plugin.ipcall.model.b.d locald = (com.tencent.mm.plugin.ipcall.model.b.d)((Iterator)localObject2).next();
        if (locald.tQm != ((dpq)localObject1).TWA) {
          break label2539;
        }
        if (((dpq)localObject1).TWC > locald.DPR)
        {
          locald.DPR = ((dpq)localObject1).TWC;
          if (((dpq)localObject1).TWB != 0) {
            locald.kbN = ((dpq)localObject1).TWB;
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
      ((com.tencent.mm.plugin.ipcall.model.b.d)localObject2).tQm = ((dpq)localObject1).TWA;
      ((com.tencent.mm.plugin.ipcall.model.b.d)localObject2).kbN = ((dpq)localObject1).TWB;
      ((com.tencent.mm.plugin.ipcall.model.b.d)localObject2).DPR = ((dpq)localObject1).TWC;
      this.DOY.DQi.add(localObject2);
      break label1448;
      if (!(paramObject instanceof k))
      {
        Log.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo redirect result error");
        AppMethodBeat.o(25379);
        return true;
      }
      paramObject = (k)paramObject;
      localObject1 = paramObject.DRL;
      if (this.DOY.roomId != paramObject.DRK.Svu)
      {
        Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo redirect finished but room id not the same, now room roomId:%d, before room roomId:%d", new Object[] { Integer.valueOf(this.DOY.roomId), Integer.valueOf(paramObject.DRK.Svu) });
        AppMethodBeat.o(25379);
        return true;
      }
      if ((paramInt2 == 0) && (paramInt3 == 0))
      {
        Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo redirect success");
        this.DOY.rOm = ((dpj)localObject1).RNx;
        this.DOY.DQg = ((dpj)localObject1).TWn;
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
      paramObject = ((o)localObject1).DRT;
      if (this.DOY.roomId != ((o)localObject1).DRS.Svu)
      {
        Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync finished but room id not the same, now room roomId:%d, before room roomId:%d", new Object[] { Integer.valueOf(this.DOY.roomId), Integer.valueOf(((o)localObject1).DRS.Svu) });
        AppMethodBeat.o(25379);
        return true;
      }
      if ((paramInt2 != 0) || (paramInt3 != 0)) {
        break;
      }
      Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync roomId: %d, status: %d, memberId: %d, syncKey: %d", new Object[] { Integer.valueOf(paramObject.Svu), Integer.valueOf(paramObject.TWz), Integer.valueOf(paramObject.TWA), Integer.valueOf(paramObject.TWx) });
      if ((paramObject.Svu != this.DOY.roomId) || (paramObject.Svv != this.DOY.DPJ)) {
        break;
      }
      if (paramObject.TWA == this.DOY.DPQ)
      {
        Log.d("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync update self status");
        if (paramObject.TWx > this.DOY.DPR)
        {
          this.DOY.DPR = paramObject.TWx;
          if (paramObject.TWz != 0) {
            this.DOY.oLS = paramObject.TWz;
          }
        }
      }
      for (;;)
      {
        label2170:
        if ((paramObject.vht == 404) || (paramObject.vht == 484))
        {
          Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync phonenumber invalid");
          this.DOY.DPW = true;
        }
        this.DOY.vhu = paramObject.vhu;
        this.DOY.vht = paramObject.vht;
        this.DOY.DPO = paramObject.DPO;
        this.DOY.DPP = paramObject.DPP;
        this.DOY.DQd = paramObject.DQd;
        break;
        Log.d("MicroMsg.IPCallSvrLogic", " handleServiceResultCallInfosync update others status");
        localObject1 = this.DOY.DQi.iterator();
        paramInt1 = 0;
        label2286:
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (com.tencent.mm.plugin.ipcall.model.b.d)((Iterator)localObject1).next();
          if (((com.tencent.mm.plugin.ipcall.model.b.d)localObject2).tQm != paramObject.TWA) {
            break label2536;
          }
          if (paramObject.TWx > ((com.tencent.mm.plugin.ipcall.model.b.d)localObject2).DPR)
          {
            ((com.tencent.mm.plugin.ipcall.model.b.d)localObject2).DPR = paramObject.TWx;
            if (paramObject.TWz != 0) {
              ((com.tencent.mm.plugin.ipcall.model.b.d)localObject2).kbN = paramObject.TWz;
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
          ((com.tencent.mm.plugin.ipcall.model.b.d)localObject1).tQm = paramObject.TWA;
          ((com.tencent.mm.plugin.ipcall.model.b.d)localObject1).kbN = paramObject.TWz;
          ((com.tencent.mm.plugin.ipcall.model.b.d)localObject1).DPR = paramObject.TWx;
          this.DOY.DQi.add(localObject1);
          break label2170;
          if (!(paramObject instanceof com.tencent.mm.plugin.ipcall.model.e.h))
          {
            Log.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo heartbeat result error");
            AppMethodBeat.o(25379);
            return true;
          }
          Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo heartbeat finished errType:%d,errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
          paramObject = (com.tencent.mm.plugin.ipcall.model.e.h)paramObject;
          if (this.DOY.roomId == paramObject.DRE.Svu) {
            break;
          }
          Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo heartbeat finished but room id not the same, now room roomId:%d, before room roomId:%d", new Object[] { Integer.valueOf(this.DOY.roomId), Integer.valueOf(paramObject.DRE.Svu) });
          AppMethodBeat.o(25379);
          return true;
        }
      }
    }
  }
  
  private void tr(boolean paramBoolean)
  {
    AppMethodBeat.i(25367);
    Log.i("MicroMsg.IPCallSvrLogic", "handleInvite, success: %b, isLaunchCancel: %b, isLaunchShutdown: %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.DON), Boolean.valueOf(this.DOO) });
    if ((this.DON) || (this.DOO))
    {
      Log.i("MicroMsg.IPCallSvrLogic", "handleInvite, ignore this");
      AppMethodBeat.o(25367);
      return;
    }
    if (paramBoolean)
    {
      if (this.DOP != null)
      {
        if (this.DOY.DPX) {
          break label130;
        }
        this.DOP.eIK();
      }
      for (;;)
      {
        Log.i("MicroMsg.IPCallSvrLogic", "start sync");
        this.DOR.a(this.DOY);
        AppMethodBeat.o(25367);
        return;
        label130:
        this.DOP.eIF();
      }
    }
    if (this.DOP != null)
    {
      if (this.DOY.DPU)
      {
        this.DOP.ac(this.DOY.DPP, this.DOY.vhu, this.DOY.DPO);
        AppMethodBeat.o(25367);
        return;
      }
      if (this.DOY.DPV)
      {
        this.DOP.ad(this.DOY.DPP, this.DOY.vhu, this.DOY.DPO);
        AppMethodBeat.o(25367);
        return;
      }
      if (this.DOY.DPW)
      {
        this.DOP.ae(this.DOY.DPP, this.DOY.vhu, this.DOY.DPO);
        AppMethodBeat.o(25367);
        return;
      }
      if (!this.DOY.DPX)
      {
        this.DOP.eIK();
        AppMethodBeat.o(25367);
        return;
      }
      this.DOP.ab(this.DOY.DPP, this.DOY.vhu, this.DOY.DPO);
    }
    AppMethodBeat.o(25367);
  }
  
  private void ts(boolean paramBoolean)
  {
    AppMethodBeat.i(25368);
    Log.i("MicroMsg.IPCallSvrLogic", "handleHeartbeat, success: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      this.DOK += 1;
      if (this.DOK >= 2)
      {
        Log.e("MicroMsg.IPCallSvrLogic", "heartbeat failed twice!");
        this.DOU.stop();
        if ((i.eJu().eJm()) && (this.DOP != null))
        {
          this.DOP.eIJ();
          AppMethodBeat.o(25368);
        }
      }
    }
    else
    {
      this.DOK = 0;
    }
    AppMethodBeat.o(25368);
  }
  
  private void tt(boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(25371);
    Log.i("MicroMsg.IPCallSvrLogic", "handleSync, success: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((paramBoolean) && (i.eJr().DQK)) {
      i.eJr().Vm(this.DOY.DQd);
    }
    if (!paramBoolean)
    {
      Log.e("MicroMsg.IPCallSvrLogic", "sync failed!");
      this.DOR.stop();
      if (i.eJu().pzp == 3) {}
      for (;;)
      {
        if ((i != 0) && (this.DOP != null)) {
          this.DOP.eR(this.DOY.vhu, this.DOY.DPO);
        }
        AppMethodBeat.o(25371);
        return;
        i = 0;
      }
    }
    if ((this.DOY != null) && (paramBoolean)) {
      Vl(this.DOY.eJH());
    }
    AppMethodBeat.o(25371);
  }
  
  private void tu(boolean paramBoolean)
  {
    AppMethodBeat.i(25372);
    Log.i("MicroMsg.IPCallSvrLogic", "handleNotify, success: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((paramBoolean) && (i.eJr().DQK)) {
      i.eJr().Vm(this.DOY.DQd);
    }
    if ((this.DOY != null) && (paramBoolean))
    {
      int i = this.DOY.eJH();
      if ((i == 2) || (i == 1))
      {
        if (!this.DPa)
        {
          o localo = new o(this.DOY.roomId, this.DOY.DPJ, this.DOY.eJG(), this.DOY.DPK, false);
          bh.aGY().a(localo, 0);
        }
      }
      else {
        Vl(this.DOY.eJH());
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
  
  private void tv(boolean paramBoolean)
  {
    AppMethodBeat.i(25374);
    Log.i("MicroMsg.IPCallSvrLogic", "handleRedirect, isSuccess: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    com.tencent.mm.plugin.ipcall.model.d.a locala;
    Object localObject1;
    Object localObject2;
    if (paramBoolean)
    {
      locala = i.eJr();
      localObject1 = this.DOY;
      Log.i("MicroMsg.IPCallEngineManager", "redirectSvrAddr");
      if ((localObject1 != null) && (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).rOm != null) && (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).rOm.size() > 0)) {
        com.tencent.mm.plugin.ipcall.a.c.bv(((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).rOm);
      }
      if ((localObject1 != null) && (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).DQg != null) && (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).DQg.size() > 0)) {
        com.tencent.mm.plugin.ipcall.a.c.bv(((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).DQg);
      }
      localObject2 = new dwd();
      dwc localdwc = new dwc();
      localdwc.Ssu = 0;
      localdwc.Ssv = "";
      localdwc.Ssw = "";
      localdwc.Ssx = 4;
      localdwc.Ssy = 4;
      localdwc.Ssz = 2;
      localdwc.Ucb = new fdc();
      localdwc.Ucc = new fdc();
      if ((localObject1 != null) && (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).rOm != null) && (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).rOm.size() > 0)) {
        localdwc.Ucb = com.tencent.mm.plugin.ipcall.a.c.bv(((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).rOm);
      }
      if ((localObject1 != null) && (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).DQg != null) && (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).DQg.size() > 0)) {
        localdwc.Ucc = com.tencent.mm.plugin.ipcall.a.c.bv(((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).DQg);
      }
      ((dwd)localObject2).Uce.add(localdwc);
      ((dwd)localObject2).Ucd = 1;
      localObject1 = null;
    }
    try
    {
      localObject2 = ((dwd)localObject2).toByteArray();
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
      i = locala.DQH.AddNewRelayConns((byte[])localObject1, localObject1.length, 1);
      if (i != 0) {
        com.tencent.mm.plugin.voip.c.e.Loge("MicroMsg.IPCallEngineManager", "redirect relay conns fail ret:".concat(String.valueOf(i)));
      }
    }
    AppMethodBeat.o(25374);
  }
  
  public final void Vk(int paramInt)
  {
    AppMethodBeat.i(25366);
    if (!this.DOY.DQm) {
      Log.e("MicroMsg.IPCallSvrLogic", "shutdownIPCall, user not accept");
    }
    Log.i("MicroMsg.IPCallSvrLogic", "shutdownIPCall, roomId: %d, inviteId: %d", new Object[] { Integer.valueOf(this.DOY.roomId), Integer.valueOf(this.DOY.DPL) });
    this.DOO = true;
    this.DOU.stop();
    this.DOR.stop();
    this.DOT.DSC = false;
    this.DOT.DSB = paramInt;
    this.DOT.a(this.DOY);
    this.DOW.a(this.DOY);
    AppMethodBeat.o(25366);
  }
  
  public final boolean Vl(int paramInt)
  {
    AppMethodBeat.i(25373);
    switch (paramInt)
    {
    default: 
      Log.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, do nothing:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(25373);
      return false;
    case 2: 
      Log.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, user accept, isLaunchCancel: %b, isLaunchShutdown: %b", new Object[] { Boolean.valueOf(this.DON), Boolean.valueOf(this.DOO) });
      if ((this.DON) || (this.DOO))
      {
        AppMethodBeat.o(25373);
        return true;
      }
      this.DOR.stop();
      if (!this.fQy)
      {
        this.fQy = true;
        if (this.DOY != null) {
          this.DOY.DQm = true;
        }
        if (this.DOP != null) {
          this.DOP.eIH();
        }
        this.DOU.a(this.DOY);
      }
      AppMethodBeat.o(25373);
      return true;
    case 3: 
      Log.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, user busy");
      this.DOR.stop();
      this.DOU.stop();
      if (this.DOP != null) {
        this.DOP.eQ(this.DOY.vhu, this.DOY.DPO);
      }
      AppMethodBeat.o(25373);
      return true;
    case 1: 
      Log.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, user ringing");
      if (!this.DOZ)
      {
        this.DOZ = true;
        if (this.DOP != null) {
          this.DOP.eIG();
        }
      }
      AppMethodBeat.o(25373);
      return true;
    case 5: 
      Log.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, other side user shutdown");
      if (this.DOP != null) {
        this.DOP.eII();
      }
      AppMethodBeat.o(25373);
      return true;
    case 4: 
    case 7: 
    case 8: 
      Log.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, user unavailable");
      if (this.DOY.DPW) {
        if (this.DOP != null) {
          this.DOP.ae(this.DOY.DPP, this.DOY.vhu, this.DOY.DPO);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(25373);
        return true;
        if (this.DOP != null) {
          this.DOP.eP(this.DOY.vhu, this.DOY.DPO);
        }
      }
    }
    Log.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, shutdown overdue");
    this.DOY.DPU = true;
    if (this.DOP != null) {
      this.DOP.ac(this.DOY.DPP, this.DOY.vhu, this.DOY.DPO);
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
      tt(true);
      AppMethodBeat.o(25377);
      return;
      ts(true);
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
      tr(true);
      AppMethodBeat.o(25375);
      return;
      X(true, paramInt3);
      AppMethodBeat.o(25375);
      return;
      Y(true, paramInt3);
      AppMethodBeat.o(25375);
      return;
      tu(true);
      AppMethodBeat.o(25375);
      return;
      tv(true);
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
      tt(false);
      AppMethodBeat.o(25378);
      return;
      ts(false);
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
      tr(false);
      AppMethodBeat.o(25376);
      return;
      X(false, paramInt3);
      AppMethodBeat.o(25376);
      return;
      Y(false, paramInt3);
      AppMethodBeat.o(25376);
      return;
      tu(false);
      AppMethodBeat.o(25376);
      return;
      tv(false);
    }
  }
  
  public final void eJn()
  {
    AppMethodBeat.i(25365);
    if (this.DOY.DQm) {
      Log.e("MicroMsg.IPCallSvrLogic", "cancelIPCall, already accept");
    }
    this.DON = true;
    Log.i("MicroMsg.IPCallSvrLogic", "cancelIPCall, roomId: %d, inviteId: %d", new Object[] { Integer.valueOf(this.DOY.roomId), Integer.valueOf(this.DOY.DPL) });
    this.DOU.stop();
    this.DOR.stop();
    this.DOS.a(this.DOY);
    this.DOW.a(this.DOY);
    AppMethodBeat.o(25365);
  }
  
  public static abstract interface a
  {
    public abstract void ab(String paramString1, String paramString2, int paramInt);
    
    public abstract void ac(String paramString1, String paramString2, int paramInt);
    
    public abstract void ad(String paramString1, String paramString2, int paramInt);
    
    public abstract void ae(String paramString1, String paramString2, int paramInt);
    
    public abstract void eIF();
    
    public abstract void eIG();
    
    public abstract void eIH();
    
    public abstract void eII();
    
    public abstract void eIJ();
    
    public abstract void eIK();
    
    public abstract void eP(String paramString, int paramInt);
    
    public abstract void eQ(String paramString, int paramInt);
    
    public abstract void eR(String paramString, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.g
 * JD-Core Version:    0.7.0.1
 */