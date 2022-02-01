package com.tencent.mm.plugin.ipcall.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.am.s;
import com.tencent.mm.model.bh;
import com.tencent.mm.network.p.a;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.ipcall.model.b.a.a;
import com.tencent.mm.plugin.ipcall.model.b.b.a;
import com.tencent.mm.plugin.ipcall.model.d.b;
import com.tencent.mm.plugin.ipcall.model.e.k;
import com.tencent.mm.plugin.ipcall.model.e.n;
import com.tencent.mm.plugin.ipcall.model.e.o;
import com.tencent.mm.plugin.ipcall.model.g.e;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.protobuf.eht;
import com.tencent.mm.protocal.protobuf.ehx;
import com.tencent.mm.protocal.protobuf.ehz;
import com.tencent.mm.protocal.protobuf.eia;
import com.tencent.mm.protocal.protobuf.eib;
import com.tencent.mm.protocal.protobuf.eic;
import com.tencent.mm.protocal.protobuf.eid;
import com.tencent.mm.protocal.protobuf.eig;
import com.tencent.mm.protocal.protobuf.eii;
import com.tencent.mm.protocal.protobuf.eij;
import com.tencent.mm.protocal.protobuf.eik;
import com.tencent.mm.protocal.protobuf.epe;
import com.tencent.mm.protocal.protobuf.epf;
import com.tencent.mm.protocal.protobuf.fzo;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class g
  implements a.a, b.a
{
  public int JFZ;
  public int JGa;
  public int JGb;
  public boolean JGc;
  public boolean JGd;
  public a JGe;
  public com.tencent.mm.plugin.ipcall.model.g.d JGf;
  com.tencent.mm.plugin.ipcall.model.g.i JGg;
  com.tencent.mm.plugin.ipcall.model.g.a JGh;
  com.tencent.mm.plugin.ipcall.model.g.h JGi;
  com.tencent.mm.plugin.ipcall.model.g.c JGj;
  public e JGk;
  com.tencent.mm.plugin.ipcall.model.g.g JGl;
  com.tencent.mm.plugin.ipcall.model.g.f JGm;
  public com.tencent.mm.plugin.ipcall.model.b.c JGn;
  public boolean JGo;
  public boolean JGp;
  com.tencent.mm.network.p JGq;
  public boolean hWt;
  
  public g()
  {
    AppMethodBeat.i(25364);
    this.JFZ = 0;
    this.JGa = 0;
    this.JGb = 0;
    this.JGc = false;
    this.JGd = false;
    this.JGo = false;
    this.hWt = false;
    this.JGp = false;
    this.JGq = new p.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        int i = 0;
        AppMethodBeat.i(25363);
        Log.i("MicroMsg.IPCallSvrLogic", "onNetworkChange, st: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (h.fRr().JHU)
        {
          f localf = h.fRu();
          if ((localf.sEu == 4) || (localf.sEu == 5)) {
            i = 1;
          }
          if ((i != 0) && (paramAnonymousInt == 4) && (g.this.JGm != null)) {
            g.this.JGm.a(g.this.JGn);
          }
        }
        AppMethodBeat.o(25363);
      }
    };
    this.JGf = new com.tencent.mm.plugin.ipcall.model.g.d();
    this.JGg = new com.tencent.mm.plugin.ipcall.model.g.i();
    this.JGh = new com.tencent.mm.plugin.ipcall.model.g.a();
    this.JGi = new com.tencent.mm.plugin.ipcall.model.g.h();
    this.JGj = new com.tencent.mm.plugin.ipcall.model.g.c();
    this.JGk = new e();
    this.JGl = new com.tencent.mm.plugin.ipcall.model.g.g();
    this.JGm = new com.tencent.mm.plugin.ipcall.model.g.f();
    AppMethodBeat.o(25364);
  }
  
  private void Z(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(25369);
    Log.i("MicroMsg.IPCallSvrLogic", "handleCancel, success: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((!paramBoolean) && (paramInt < 0) && (this.JGb <= 0))
    {
      this.JGb += 1;
      Log.i("MicroMsg.IPCallSvrLogic", "cancel failed, retry count: %d", new Object[] { Integer.valueOf(this.JGb) });
      this.JGh.a(this.JGn);
      AppMethodBeat.o(25369);
      return;
    }
    AppMethodBeat.o(25369);
  }
  
  private void aa(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(25370);
    Log.i("MicroMsg.IPCallSvrLogic", "handleUserSelfShutdown, success: %b, isFromNotify: %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.JGi.JJM) });
    if ((!paramBoolean) && (paramInt < 0) && (this.JGa <= 0))
    {
      this.JGa += 1;
      Log.i("MicroMsg.IPCallSvrLogic", "shutdown failed, retry count: %d, isFromNotify: %b", new Object[] { Integer.valueOf(this.JGa), Boolean.valueOf(this.JGi.JJM) });
      this.JGi.a(this.JGn);
      AppMethodBeat.o(25370);
      return;
    }
    AppMethodBeat.o(25370);
  }
  
  private boolean c(int paramInt1, Object paramObject, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(25379);
    if ((this.JGn == null) || (paramObject == null))
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
          localObject1 = paramObject.JIR;
          if (this.JGn.JGW != paramObject.JIQ.abmP)
          {
            Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo invited finished but invite id not the same, now room inviteId:%d, before room inviteId:%d", new Object[] { Integer.valueOf(this.JGn.JGW), Integer.valueOf(paramObject.JIQ.abmP) });
            AppMethodBeat.o(25379);
            return true;
          }
          Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo invited finished invite id:%d", new Object[] { Integer.valueOf(this.JGn.JGW) });
          h.fRs().jy(this.JGn.JGW, paramInt3);
          if ((paramInt2 == 0) && (paramInt3 == 0))
          {
            if (this.JGn != null)
            {
              this.JGn.roomId = ((eia)localObject1).Zvz;
              this.JGn.Hnt = ((eia)localObject1).ZvA;
              this.JGn.JGV = ((eia)localObject1).abmR;
              this.JGn.JHb = ((eia)localObject1).abna;
              this.JGn.JHd = (((eia)localObject1).abnb * 1000);
              this.JGn.JHk = ((eia)localObject1).JHk;
              this.JGn.JHl = ((eia)localObject1).JHl;
              this.JGn.uZA = ((eia)localObject1).YKL;
              this.JGn.JHr = ((eia)localObject1).abnc;
              this.JGn.JHw = ((eia)localObject1).abnd;
              if (((eia)localObject1).JHs > 0) {
                this.JGn.JHs = ((eia)localObject1).JHs;
              }
              this.JGn.JHm = ((eia)localObject1).JHm;
              this.JGn.JHn = ((eia)localObject1).JHn;
              this.JGn.JHj = ((eia)localObject1).abnf;
              if (((eia)localObject1).JHp > 0)
              {
                this.JGn.JHp = (((eia)localObject1).JHp - 1);
                Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo zhengxue[ENCRYPT] got encryptStrategy[" + this.JGn.JHp + "] from Invite resp");
                this.JGn.JHq = ((eia)localObject1).abne;
                Log.d("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo NextInvite:%d", new Object[] { Integer.valueOf(((eia)localObject1).JHe) });
                if (((eia)localObject1).JHe <= 0) {
                  break label613;
                }
                this.JGn.JHi = false;
              }
              for (this.JGn.JHe = ((eia)localObject1).JHe;; this.JGn.JHe = 0)
              {
                this.JGn.JHa = ((eia)localObject1).JHa;
                this.JGn.JGZ = ((eia)localObject1).JGZ;
                this.JGn.ytv = paramInt3;
                this.JGn.ytw = Util.nullAsNil(w.a(((eia)localObject1).BaseResponse.akjO));
                break;
                Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo zhengxue[ENCRYPT] got no encryptStrategy from Invite resp");
                this.JGn.JHp = 2;
                break label474;
                this.JGn.JHi = true;
              }
            }
          }
          else
          {
            Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo invite failed");
            if (((eia)localObject1).BaseResponse != null)
            {
              if (paramInt3 == 433)
              {
                Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo account overdue");
                this.JGn.JHf = true;
                if (((eia)localObject1).JHe <= 0) {
                  break label860;
                }
                this.JGn.JHi = false;
              }
              for (this.JGn.JHe = ((eia)localObject1).JHe;; this.JGn.JHe = 0)
              {
                this.JGn.JHa = ((eia)localObject1).JHa;
                this.JGn.JGZ = ((eia)localObject1).JGZ;
                this.JGn.ytv = paramInt3;
                if (((eia)localObject1).getBaseResponse() == null) {
                  break;
                }
                this.JGn.ytw = Util.nullAsNil(w.a(((eia)localObject1).BaseResponse.akjO));
                Log.d("MicroMsg.IPCallSvrLogic", "ErrLevel:%d,ErrCode:%d,ErrMsg:%s", new Object[] { Integer.valueOf(((eia)localObject1).JGZ), Integer.valueOf(paramInt3), this.JGn.ytw });
                break;
                if (paramInt3 == 434)
                {
                  Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo restrict call");
                  this.JGn.JHg = true;
                  break label672;
                }
                if (paramInt3 != 435) {
                  break label672;
                }
                Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo phonenumber invalid");
                this.JGn.JHh = true;
                break label672;
                this.JGn.JHi = true;
              }
            }
            this.JGn.JHa = "";
            this.JGn.JGZ = 2;
            this.JGn.ytw = MMApplicationContext.getContext().getString(R.l.gwb);
            this.JGn.ytv = paramInt3;
            continue;
            if (!(paramObject instanceof com.tencent.mm.plugin.ipcall.model.e.a))
            {
              Log.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo cancel result error");
              AppMethodBeat.o(25379);
              return true;
            }
            Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo cancel finished errType:%d,errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
            paramObject = (com.tencent.mm.plugin.ipcall.model.e.a)paramObject;
            if (this.JGn.JGW != paramObject.JIz.abmP)
            {
              Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo cancel finished but invite id not the same, now room inviteId:%d, before room inviteId:%d", new Object[] { Integer.valueOf(this.JGn.JGW), Integer.valueOf(paramObject.JIz.abmP) });
              AppMethodBeat.o(25379);
              return true;
              if (!(paramObject instanceof n))
              {
                Log.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown result error");
                AppMethodBeat.o(25379);
                return true;
              }
              paramObject = (n)paramObject;
              if (this.JGn.roomId != paramObject.JJa.Zvz)
              {
                Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown finished but room id not the same, now room roomId:%d, before room roomId:%d", new Object[] { Integer.valueOf(this.JGn.roomId), Integer.valueOf(paramObject.JJa.Zvz) });
                AppMethodBeat.o(25379);
                return true;
              }
              if ((paramInt2 == 0) && (paramInt3 == 0))
              {
                Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown success!");
                this.JGn.rPN = 5;
              }
              else
              {
                Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown failed");
              }
            }
          }
        }
        if (!(paramObject instanceof eib))
        {
          Log.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo notify result error");
          AppMethodBeat.o(25379);
          return true;
        }
        Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo notify finished");
        paramObject = (eib)paramObject;
        if (this.JGn.roomId != paramObject.Zvz)
        {
          Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown finished but room id not the same, now room roomId:%d, before room roomId:%d", new Object[] { Integer.valueOf(this.JGn.roomId), Integer.valueOf(paramObject.Zvz) });
          AppMethodBeat.o(25379);
          return true;
        }
      } while ((paramInt2 != 0) || (paramInt3 != 0));
      this.JGn.JHo = paramObject.JHo;
      Log.d("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo updateNotifyCallInfo, UserStatuslist.size: %d", new Object[] { Integer.valueOf(paramObject.abng.size()) });
      paramObject = paramObject.abng.iterator();
      while (paramObject.hasNext())
      {
        localObject1 = (eik)paramObject.next();
        if (this.JGn.JHb != ((eik)localObject1).abnp) {
          break label1537;
        }
        Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo update self userStatus, memberId: %d, status: %d, syncKey: %d", new Object[] { Integer.valueOf(this.JGn.JHb), Integer.valueOf(((eik)localObject1).abnq), Integer.valueOf(((eik)localObject1).abnr) });
        if (((eik)localObject1).abnr > this.JGn.JHc)
        {
          this.JGn.JHc = ((eik)localObject1).abnr;
          if (((eik)localObject1).abnq != 0) {
            this.JGn.rPN = ((eik)localObject1).abnq;
          }
        }
        label1448:
        if ((((eik)localObject1).ytv == 404) || (((eik)localObject1).ytv == 484))
        {
          Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo notify phonenumber invalid");
          this.JGn.JHh = true;
        }
        this.JGn.ytw = ((eik)localObject1).ytw;
        this.JGn.ytv = ((eik)localObject1).ytv;
        this.JGn.JGZ = ((eik)localObject1).JGZ;
        this.JGn.JHa = ((eik)localObject1).JHa;
      }
      label1537:
      Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo update others userStatus, memberId: %d, status: %d, syncKey: %d", new Object[] { Integer.valueOf(((eik)localObject1).abnp), Integer.valueOf(((eik)localObject1).abnq), Integer.valueOf(((eik)localObject1).abnr) });
      paramInt1 = 0;
      localObject2 = this.JGn.JHt.iterator();
      label1596:
      if (((Iterator)localObject2).hasNext())
      {
        com.tencent.mm.plugin.ipcall.model.b.d locald = (com.tencent.mm.plugin.ipcall.model.b.d)((Iterator)localObject2).next();
        if (locald.wTC != ((eik)localObject1).abnp) {
          break label2539;
        }
        if (((eik)localObject1).abnr > locald.JHc)
        {
          locald.JHc = ((eik)localObject1).abnr;
          if (((eik)localObject1).abnq != 0) {
            locald.mBT = ((eik)localObject1).abnq;
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
      ((com.tencent.mm.plugin.ipcall.model.b.d)localObject2).wTC = ((eik)localObject1).abnp;
      ((com.tencent.mm.plugin.ipcall.model.b.d)localObject2).mBT = ((eik)localObject1).abnq;
      ((com.tencent.mm.plugin.ipcall.model.b.d)localObject2).JHc = ((eik)localObject1).abnr;
      this.JGn.JHt.add(localObject2);
      break label1448;
      if (!(paramObject instanceof k))
      {
        Log.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo redirect result error");
        AppMethodBeat.o(25379);
        return true;
      }
      paramObject = (k)paramObject;
      localObject1 = paramObject.JIV;
      if (this.JGn.roomId != paramObject.JIU.Zvz)
      {
        Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo redirect finished but room id not the same, now room roomId:%d, before room roomId:%d", new Object[] { Integer.valueOf(this.JGn.roomId), Integer.valueOf(paramObject.JIU.Zvz) });
        AppMethodBeat.o(25379);
        return true;
      }
      if ((paramInt2 == 0) && (paramInt3 == 0))
      {
        Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo redirect success");
        this.JGn.uZA = ((eid)localObject1).YKL;
        this.JGn.JHr = ((eid)localObject1).abnc;
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
      paramObject = ((o)localObject1).JJd;
      if (this.JGn.roomId != ((o)localObject1).JJc.Zvz)
      {
        Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync finished but room id not the same, now room roomId:%d, before room roomId:%d", new Object[] { Integer.valueOf(this.JGn.roomId), Integer.valueOf(((o)localObject1).JJc.Zvz) });
        AppMethodBeat.o(25379);
        return true;
      }
      if ((paramInt2 != 0) || (paramInt3 != 0)) {
        break;
      }
      Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync roomId: %d, status: %d, memberId: %d, syncKey: %d", new Object[] { Integer.valueOf(paramObject.Zvz), Integer.valueOf(paramObject.abno), Integer.valueOf(paramObject.abnp), Integer.valueOf(paramObject.abnm) });
      if ((paramObject.Zvz != this.JGn.roomId) || (paramObject.ZvA != this.JGn.Hnt)) {
        break;
      }
      if (paramObject.abnp == this.JGn.JHb)
      {
        Log.d("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync update self status");
        if (paramObject.abnm > this.JGn.JHc)
        {
          this.JGn.JHc = paramObject.abnm;
          if (paramObject.abno != 0) {
            this.JGn.rPN = paramObject.abno;
          }
        }
      }
      for (;;)
      {
        label2170:
        if ((paramObject.ytv == 404) || (paramObject.ytv == 484))
        {
          Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync phonenumber invalid");
          this.JGn.JHh = true;
        }
        this.JGn.ytw = paramObject.ytw;
        this.JGn.ytv = paramObject.ytv;
        this.JGn.JGZ = paramObject.JGZ;
        this.JGn.JHa = paramObject.JHa;
        this.JGn.JHo = paramObject.JHo;
        break;
        Log.d("MicroMsg.IPCallSvrLogic", " handleServiceResultCallInfosync update others status");
        localObject1 = this.JGn.JHt.iterator();
        paramInt1 = 0;
        label2286:
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (com.tencent.mm.plugin.ipcall.model.b.d)((Iterator)localObject1).next();
          if (((com.tencent.mm.plugin.ipcall.model.b.d)localObject2).wTC != paramObject.abnp) {
            break label2536;
          }
          if (paramObject.abnm > ((com.tencent.mm.plugin.ipcall.model.b.d)localObject2).JHc)
          {
            ((com.tencent.mm.plugin.ipcall.model.b.d)localObject2).JHc = paramObject.abnm;
            if (paramObject.abno != 0) {
              ((com.tencent.mm.plugin.ipcall.model.b.d)localObject2).mBT = paramObject.abno;
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
          ((com.tencent.mm.plugin.ipcall.model.b.d)localObject1).wTC = paramObject.abnp;
          ((com.tencent.mm.plugin.ipcall.model.b.d)localObject1).mBT = paramObject.abno;
          ((com.tencent.mm.plugin.ipcall.model.b.d)localObject1).JHc = paramObject.abnm;
          this.JGn.JHt.add(localObject1);
          break label2170;
          if (!(paramObject instanceof com.tencent.mm.plugin.ipcall.model.e.h))
          {
            Log.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo heartbeat result error");
            AppMethodBeat.o(25379);
            return true;
          }
          Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo heartbeat finished errType:%d,errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
          paramObject = (com.tencent.mm.plugin.ipcall.model.e.h)paramObject;
          if (this.JGn.roomId == paramObject.JIO.Zvz) {
            break;
          }
          Log.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo heartbeat finished but room id not the same, now room roomId:%d, before room roomId:%d", new Object[] { Integer.valueOf(this.JGn.roomId), Integer.valueOf(paramObject.JIO.Zvz) });
          AppMethodBeat.o(25379);
          return true;
        }
      }
    }
  }
  
  private void xC(boolean paramBoolean)
  {
    AppMethodBeat.i(25367);
    Log.i("MicroMsg.IPCallSvrLogic", "handleInvite, success: %b, isLaunchCancel: %b, isLaunchShutdown: %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.JGc), Boolean.valueOf(this.JGd) });
    if ((this.JGc) || (this.JGd))
    {
      Log.i("MicroMsg.IPCallSvrLogic", "handleInvite, ignore this");
      AppMethodBeat.o(25367);
      return;
    }
    if (paramBoolean)
    {
      if (this.JGe != null)
      {
        if (this.JGn.JHi) {
          break label130;
        }
        this.JGe.fQK();
      }
      for (;;)
      {
        Log.i("MicroMsg.IPCallSvrLogic", "start sync");
        this.JGg.a(this.JGn);
        AppMethodBeat.o(25367);
        return;
        label130:
        this.JGe.fQG();
      }
    }
    if (this.JGe != null)
    {
      if (this.JGn.JHf)
      {
        this.JGe.aj(this.JGn.JHa, this.JGn.ytw, this.JGn.JGZ);
        AppMethodBeat.o(25367);
        return;
      }
      if (this.JGn.JHg)
      {
        this.JGe.ak(this.JGn.JHa, this.JGn.ytw, this.JGn.JGZ);
        AppMethodBeat.o(25367);
        return;
      }
      if (this.JGn.JHh)
      {
        this.JGe.al(this.JGn.JHa, this.JGn.ytw, this.JGn.JGZ);
        AppMethodBeat.o(25367);
        return;
      }
      if (!this.JGn.JHi)
      {
        this.JGe.fQK();
        AppMethodBeat.o(25367);
        return;
      }
      this.JGe.ai(this.JGn.JHa, this.JGn.ytw, this.JGn.JGZ);
    }
    AppMethodBeat.o(25367);
  }
  
  private void xD(boolean paramBoolean)
  {
    AppMethodBeat.i(25368);
    Log.i("MicroMsg.IPCallSvrLogic", "handleHeartbeat, success: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      this.JFZ += 1;
      if (this.JFZ >= 2)
      {
        Log.e("MicroMsg.IPCallSvrLogic", "heartbeat failed twice!");
        this.JGj.stop();
        if ((h.fRu().fRm()) && (this.JGe != null))
        {
          this.JGe.fQJ();
          AppMethodBeat.o(25368);
        }
      }
    }
    else
    {
      this.JFZ = 0;
    }
    AppMethodBeat.o(25368);
  }
  
  private void xE(boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(25371);
    Log.i("MicroMsg.IPCallSvrLogic", "handleSync, success: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((paramBoolean) && (h.fRr().JHU)) {
      h.fRr().Zh(this.JGn.JHo);
    }
    if (!paramBoolean)
    {
      Log.e("MicroMsg.IPCallSvrLogic", "sync failed!");
      this.JGg.stop();
      if (h.fRu().sEu == 3) {}
      for (;;)
      {
        if ((i != 0) && (this.JGe != null)) {
          this.JGe.fJ(this.JGn.ytw, this.JGn.JGZ);
        }
        AppMethodBeat.o(25371);
        return;
        i = 0;
      }
    }
    if ((this.JGn != null) && (paramBoolean)) {
      Zg(this.JGn.fRI());
    }
    AppMethodBeat.o(25371);
  }
  
  private void xF(boolean paramBoolean)
  {
    AppMethodBeat.i(25372);
    Log.i("MicroMsg.IPCallSvrLogic", "handleNotify, success: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((paramBoolean) && (h.fRr().JHU)) {
      h.fRr().Zh(this.JGn.JHo);
    }
    if ((this.JGn != null) && (paramBoolean))
    {
      int i = this.JGn.fRI();
      if ((i == 2) || (i == 1))
      {
        if (!this.JGp)
        {
          o localo = new o(this.JGn.roomId, this.JGn.Hnt, this.JGn.fRH(), this.JGn.JGV, false);
          bh.aZW().a(localo, 0);
        }
      }
      else {
        Zg(this.JGn.fRI());
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
  
  private void xG(boolean paramBoolean)
  {
    AppMethodBeat.i(25374);
    Log.i("MicroMsg.IPCallSvrLogic", "handleRedirect, isSuccess: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    com.tencent.mm.plugin.ipcall.model.d.a locala;
    Object localObject1;
    Object localObject2;
    if (paramBoolean)
    {
      locala = h.fRr();
      localObject1 = this.JGn;
      Log.i("MicroMsg.IPCallEngineManager", "redirectSvrAddr");
      if ((localObject1 != null) && (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).uZA != null) && (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).uZA.size() > 0)) {
        com.tencent.mm.plugin.ipcall.a.c.bC(((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).uZA);
      }
      if ((localObject1 != null) && (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).JHr != null) && (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).JHr.size() > 0)) {
        com.tencent.mm.plugin.ipcall.a.c.bC(((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).JHr);
      }
      localObject2 = new epf();
      epe localepe = new epe();
      localepe.ZrC = 0;
      localepe.ZrD = "";
      localepe.ZrE = "";
      localepe.ZrF = 4;
      localepe.ZrG = 4;
      localepe.ZrH = 2;
      localepe.abto = new fzo();
      localepe.abtp = new fzo();
      if ((localObject1 != null) && (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).uZA != null) && (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).uZA.size() > 0)) {
        localepe.abto = com.tencent.mm.plugin.ipcall.a.c.bC(((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).uZA);
      }
      if ((localObject1 != null) && (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).JHr != null) && (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).JHr.size() > 0)) {
        localepe.abtp = com.tencent.mm.plugin.ipcall.a.c.bC(((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).JHr);
      }
      ((epf)localObject2).abtr.add(localepe);
      ((epf)localObject2).abtq = 1;
      localObject1 = null;
    }
    try
    {
      localObject2 = ((epf)localObject2).toByteArray();
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
      i = locala.JHR.AddNewRelayConns((byte[])localObject1, localObject1.length, 1);
      if (i != 0) {
        com.tencent.mm.plugin.voip.f.g.Loge("MicroMsg.IPCallEngineManager", "redirect relay conns fail ret:".concat(String.valueOf(i)));
      }
    }
    AppMethodBeat.o(25374);
  }
  
  public final void Zf(int paramInt)
  {
    AppMethodBeat.i(25366);
    if (!this.JGn.JHx) {
      Log.e("MicroMsg.IPCallSvrLogic", "shutdownIPCall, user not accept");
    }
    Log.i("MicroMsg.IPCallSvrLogic", "shutdownIPCall, roomId: %d, inviteId: %d", new Object[] { Integer.valueOf(this.JGn.roomId), Integer.valueOf(this.JGn.JGW) });
    this.JGd = true;
    this.JGj.stop();
    this.JGg.stop();
    this.JGi.JJM = false;
    this.JGi.JJL = paramInt;
    this.JGi.a(this.JGn);
    this.JGl.a(this.JGn);
    AppMethodBeat.o(25366);
  }
  
  public final boolean Zg(int paramInt)
  {
    AppMethodBeat.i(25373);
    switch (paramInt)
    {
    default: 
      Log.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, do nothing:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(25373);
      return false;
    case 2: 
      Log.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, user accept, isLaunchCancel: %b, isLaunchShutdown: %b", new Object[] { Boolean.valueOf(this.JGc), Boolean.valueOf(this.JGd) });
      if ((this.JGc) || (this.JGd))
      {
        AppMethodBeat.o(25373);
        return true;
      }
      this.JGg.stop();
      if (!this.hWt)
      {
        this.hWt = true;
        if (this.JGn != null) {
          this.JGn.JHx = true;
        }
        if (this.JGe != null) {
          this.JGe.fwj();
        }
        this.JGj.a(this.JGn);
      }
      AppMethodBeat.o(25373);
      return true;
    case 3: 
      Log.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, user busy");
      this.JGg.stop();
      this.JGj.stop();
      if (this.JGe != null) {
        this.JGe.fI(this.JGn.ytw, this.JGn.JGZ);
      }
      AppMethodBeat.o(25373);
      return true;
    case 1: 
      Log.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, user ringing");
      if (!this.JGo)
      {
        this.JGo = true;
        if (this.JGe != null) {
          this.JGe.fQH();
        }
      }
      AppMethodBeat.o(25373);
      return true;
    case 5: 
      Log.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, other side user shutdown");
      if (this.JGe != null) {
        this.JGe.fQI();
      }
      AppMethodBeat.o(25373);
      return true;
    case 4: 
    case 7: 
    case 8: 
      Log.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, user unavailable");
      if (this.JGn.JHh) {
        if (this.JGe != null) {
          this.JGe.al(this.JGn.JHa, this.JGn.ytw, this.JGn.JGZ);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(25373);
        return true;
        if (this.JGe != null) {
          this.JGe.fH(this.JGn.ytw, this.JGn.JGZ);
        }
      }
    }
    Log.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, shutdown overdue");
    this.JGn.JHf = true;
    if (this.JGe != null) {
      this.JGe.aj(this.JGn.JHa, this.JGn.ytw, this.JGn.JGZ);
    }
    AppMethodBeat.o(25373);
    return true;
  }
  
  public final void a(int paramInt1, com.tencent.mm.am.p paramp, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(25377);
    if (c(paramInt1, paramp, paramInt2, paramInt3))
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
      xE(true);
      AppMethodBeat.o(25377);
      return;
      xD(true);
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
      xC(true);
      AppMethodBeat.o(25375);
      return;
      Z(true, paramInt3);
      AppMethodBeat.o(25375);
      return;
      aa(true, paramInt3);
      AppMethodBeat.o(25375);
      return;
      xF(true);
      AppMethodBeat.o(25375);
      return;
      xG(true);
    }
  }
  
  public final void b(int paramInt1, com.tencent.mm.am.p paramp, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(25378);
    if (c(paramInt1, paramp, paramInt2, paramInt3))
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
      xE(false);
      AppMethodBeat.o(25378);
      return;
      xD(false);
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
      xC(false);
      AppMethodBeat.o(25376);
      return;
      Z(false, paramInt3);
      AppMethodBeat.o(25376);
      return;
      aa(false, paramInt3);
      AppMethodBeat.o(25376);
      return;
      xF(false);
      AppMethodBeat.o(25376);
      return;
      xG(false);
    }
  }
  
  public final void fRn()
  {
    AppMethodBeat.i(25365);
    if (this.JGn.JHx) {
      Log.e("MicroMsg.IPCallSvrLogic", "cancelIPCall, already accept");
    }
    this.JGc = true;
    Log.i("MicroMsg.IPCallSvrLogic", "cancelIPCall, roomId: %d, inviteId: %d", new Object[] { Integer.valueOf(this.JGn.roomId), Integer.valueOf(this.JGn.JGW) });
    this.JGj.stop();
    this.JGg.stop();
    this.JGh.a(this.JGn);
    this.JGl.a(this.JGn);
    AppMethodBeat.o(25365);
  }
  
  public static abstract interface a
  {
    public abstract void ai(String paramString1, String paramString2, int paramInt);
    
    public abstract void aj(String paramString1, String paramString2, int paramInt);
    
    public abstract void ak(String paramString1, String paramString2, int paramInt);
    
    public abstract void al(String paramString1, String paramString2, int paramInt);
    
    public abstract void fH(String paramString, int paramInt);
    
    public abstract void fI(String paramString, int paramInt);
    
    public abstract void fJ(String paramString, int paramInt);
    
    public abstract void fQG();
    
    public abstract void fQH();
    
    public abstract void fQI();
    
    public abstract void fQJ();
    
    public abstract void fQK();
    
    public abstract void fwj();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.g
 * JD-Core Version:    0.7.0.1
 */