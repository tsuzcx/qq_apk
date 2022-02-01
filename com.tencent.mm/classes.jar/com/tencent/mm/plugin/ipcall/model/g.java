package com.tencent.mm.plugin.ipcall.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
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
import com.tencent.mm.protocal.protobuf.cco;
import com.tencent.mm.protocal.protobuf.ccs;
import com.tencent.mm.protocal.protobuf.ccu;
import com.tencent.mm.protocal.protobuf.ccv;
import com.tencent.mm.protocal.protobuf.ccw;
import com.tencent.mm.protocal.protobuf.ccx;
import com.tencent.mm.protocal.protobuf.ccy;
import com.tencent.mm.protocal.protobuf.cdb;
import com.tencent.mm.protocal.protobuf.cdd;
import com.tencent.mm.protocal.protobuf.cde;
import com.tencent.mm.protocal.protobuf.cdf;
import com.tencent.mm.protocal.protobuf.cir;
import com.tencent.mm.protocal.protobuf.cis;
import com.tencent.mm.protocal.protobuf.dli;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;

public final class g
  implements a.a, b.a
{
  public boolean duq;
  public boolean sAa;
  public boolean sAb;
  public a sAc;
  public com.tencent.mm.plugin.ipcall.model.g.d sAd;
  com.tencent.mm.plugin.ipcall.model.g.i sAe;
  com.tencent.mm.plugin.ipcall.model.g.a sAf;
  com.tencent.mm.plugin.ipcall.model.g.h sAg;
  com.tencent.mm.plugin.ipcall.model.g.c sAh;
  public e sAi;
  com.tencent.mm.plugin.ipcall.model.g.g sAj;
  com.tencent.mm.plugin.ipcall.model.g.f sAk;
  public com.tencent.mm.plugin.ipcall.model.b.c sAl;
  public boolean sAm;
  public boolean sAn;
  com.tencent.mm.network.n sAo;
  public int szX;
  public int szY;
  public int szZ;
  
  public g()
  {
    AppMethodBeat.i(25364);
    this.szX = 0;
    this.szY = 0;
    this.szZ = 0;
    this.sAa = false;
    this.sAb = false;
    this.sAm = false;
    this.duq = false;
    this.sAn = false;
    this.sAo = new n.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        int i = 0;
        AppMethodBeat.i(25363);
        ad.i("MicroMsg.IPCallSvrLogic", "onNetworkChange, st: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (i.cHl().sCa)
        {
          f localf = i.cHo();
          if ((localf.ksb == 4) || (localf.ksb == 5)) {
            i = 1;
          }
          if ((i != 0) && (paramAnonymousInt == 4) && (g.this.sAk != null)) {
            g.this.sAk.a(g.this.sAl);
          }
        }
        AppMethodBeat.o(25363);
      }
    };
    this.sAd = new com.tencent.mm.plugin.ipcall.model.g.d();
    this.sAe = new com.tencent.mm.plugin.ipcall.model.g.i();
    this.sAf = new com.tencent.mm.plugin.ipcall.model.g.a();
    this.sAg = new com.tencent.mm.plugin.ipcall.model.g.h();
    this.sAh = new com.tencent.mm.plugin.ipcall.model.g.c();
    this.sAi = new e();
    this.sAj = new com.tencent.mm.plugin.ipcall.model.g.g();
    this.sAk = new com.tencent.mm.plugin.ipcall.model.g.f();
    AppMethodBeat.o(25364);
  }
  
  private void F(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(25369);
    ad.i("MicroMsg.IPCallSvrLogic", "handleCancel, success: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((!paramBoolean) && (paramInt < 0) && (this.szZ <= 0))
    {
      this.szZ += 1;
      ad.i("MicroMsg.IPCallSvrLogic", "cancel failed, retry count: %d", new Object[] { Integer.valueOf(this.szZ) });
      this.sAf.a(this.sAl);
      AppMethodBeat.o(25369);
      return;
    }
    AppMethodBeat.o(25369);
  }
  
  private void G(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(25370);
    ad.i("MicroMsg.IPCallSvrLogic", "handleUserSelfShutdown, success: %b, isFromNotify: %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.sAg.sDS) });
    if ((!paramBoolean) && (paramInt < 0) && (this.szY <= 0))
    {
      this.szY += 1;
      ad.i("MicroMsg.IPCallSvrLogic", "shutdown failed, retry count: %d, isFromNotify: %b", new Object[] { Integer.valueOf(this.szY), Boolean.valueOf(this.sAg.sDS) });
      this.sAg.a(this.sAl);
      AppMethodBeat.o(25370);
      return;
    }
    AppMethodBeat.o(25370);
  }
  
  private boolean c(int paramInt1, Object paramObject, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(25379);
    if ((this.sAl == null) || (paramObject == null))
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
          localObject1 = paramObject.sCX;
          if (this.sAl.sBa != paramObject.sCW.DYV)
          {
            ad.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo invited finished but invite id not the same, now room inviteId:%d, before room inviteId:%d", new Object[] { Integer.valueOf(this.sAl.sBa), Integer.valueOf(paramObject.sCW.DYV) });
            AppMethodBeat.o(25379);
            return true;
          }
          ad.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo invited finished invite id:%d", new Object[] { Integer.valueOf(this.sAl.sBa) });
          i.cHm().fU(this.sAl.sBa, paramInt3);
          if ((paramInt2 == 0) && (paramInt3 == 0))
          {
            if (this.sAl != null)
            {
              this.sAl.roomId = ((ccv)localObject1).DdZ;
              this.sAl.sAY = ((ccv)localObject1).Dea;
              this.sAl.sAZ = ((ccv)localObject1).DYX;
              this.sAl.sBf = ((ccv)localObject1).DZg;
              this.sAl.sBh = (((ccv)localObject1).DZh * 1000);
              this.sAl.sBo = ((ccv)localObject1).sBo;
              this.sAl.sBp = ((ccv)localObject1).sBp;
              this.sAl.mty = ((ccv)localObject1).CCG;
              this.sAl.sBv = ((ccv)localObject1).DZi;
              this.sAl.sBA = ((ccv)localObject1).DZj;
              if (((ccv)localObject1).sBw > 0) {
                this.sAl.sBw = ((ccv)localObject1).sBw;
              }
              this.sAl.sBq = ((ccv)localObject1).sBq;
              this.sAl.sBr = ((ccv)localObject1).sBr;
              this.sAl.sBn = ((ccv)localObject1).DZl;
              if (((ccv)localObject1).sBt > 0)
              {
                this.sAl.sBt = (((ccv)localObject1).sBt - 1);
                ad.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo zhengxue[ENCRYPT] got encryptStrategy[" + this.sAl.sBt + "] from Invite resp");
                this.sAl.sBu = ((ccv)localObject1).DZk;
                ad.d("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo NextInvite:%d", new Object[] { Integer.valueOf(((ccv)localObject1).sBi) });
                if (((ccv)localObject1).sBi <= 0) {
                  break label613;
                }
                this.sAl.sBm = false;
              }
              for (this.sAl.sBi = ((ccv)localObject1).sBi;; this.sAl.sBi = 0)
              {
                this.sAl.sBe = ((ccv)localObject1).sBe;
                this.sAl.sBd = ((ccv)localObject1).sBd;
                this.sAl.oXv = paramInt3;
                this.sAl.oXw = bt.nullAsNil(z.a(((ccv)localObject1).BaseResponse.ErrMsg));
                break;
                ad.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo zhengxue[ENCRYPT] got no encryptStrategy from Invite resp");
                this.sAl.sBt = 2;
                break label474;
                this.sAl.sBm = true;
              }
            }
          }
          else
          {
            ad.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo invite failed");
            if (((ccv)localObject1).BaseResponse != null)
            {
              if (paramInt3 == 433)
              {
                ad.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo account overdue");
                this.sAl.sBj = true;
                if (((ccv)localObject1).sBi <= 0) {
                  break label860;
                }
                this.sAl.sBm = false;
              }
              for (this.sAl.sBi = ((ccv)localObject1).sBi;; this.sAl.sBi = 0)
              {
                this.sAl.sBe = ((ccv)localObject1).sBe;
                this.sAl.sBd = ((ccv)localObject1).sBd;
                this.sAl.oXv = paramInt3;
                if (((ccv)localObject1).getBaseResponse() == null) {
                  break;
                }
                this.sAl.oXw = bt.nullAsNil(z.a(((ccv)localObject1).BaseResponse.ErrMsg));
                ad.d("MicroMsg.IPCallSvrLogic", "ErrLevel:%d,ErrCode:%d,ErrMsg:%s", new Object[] { Integer.valueOf(((ccv)localObject1).sBd), Integer.valueOf(paramInt3), this.sAl.oXw });
                break;
                if (paramInt3 == 434)
                {
                  ad.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo restrict call");
                  this.sAl.sBk = true;
                  break label672;
                }
                if (paramInt3 != 435) {
                  break label672;
                }
                ad.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo phonenumber invalid");
                this.sAl.sBl = true;
                break label672;
                this.sAl.sBm = true;
              }
            }
            this.sAl.sBe = "";
            this.sAl.sBd = 2;
            this.sAl.oXw = aj.getContext().getString(2131756764);
            this.sAl.oXv = paramInt3;
            continue;
            if (!(paramObject instanceof com.tencent.mm.plugin.ipcall.model.e.a))
            {
              ad.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo cancel result error");
              AppMethodBeat.o(25379);
              return true;
            }
            ad.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo cancel finished errType:%d,errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
            paramObject = (com.tencent.mm.plugin.ipcall.model.e.a)paramObject;
            if (this.sAl.sBa != paramObject.sCF.DYV)
            {
              ad.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo cancel finished but invite id not the same, now room inviteId:%d, before room inviteId:%d", new Object[] { Integer.valueOf(this.sAl.sBa), Integer.valueOf(paramObject.sCF.DYV) });
              AppMethodBeat.o(25379);
              return true;
              if (!(paramObject instanceof com.tencent.mm.plugin.ipcall.model.e.n))
              {
                ad.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown result error");
                AppMethodBeat.o(25379);
                return true;
              }
              paramObject = (com.tencent.mm.plugin.ipcall.model.e.n)paramObject;
              if (this.sAl.roomId != paramObject.sDg.DdZ)
              {
                ad.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown finished but room id not the same, now room roomId:%d, before room roomId:%d", new Object[] { Integer.valueOf(this.sAl.roomId), Integer.valueOf(paramObject.sDg.DdZ) });
                AppMethodBeat.o(25379);
                return true;
              }
              if ((paramInt2 == 0) && (paramInt3 == 0))
              {
                ad.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown success!");
                this.sAl.jMb = 5;
              }
              else
              {
                ad.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown failed");
              }
            }
          }
        }
        if (!(paramObject instanceof ccw))
        {
          ad.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo notify result error");
          AppMethodBeat.o(25379);
          return true;
        }
        ad.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo notify finished");
        paramObject = (ccw)paramObject;
        if (this.sAl.roomId != paramObject.DdZ)
        {
          ad.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo shutdown finished but room id not the same, now room roomId:%d, before room roomId:%d", new Object[] { Integer.valueOf(this.sAl.roomId), Integer.valueOf(paramObject.DdZ) });
          AppMethodBeat.o(25379);
          return true;
        }
      } while ((paramInt2 != 0) || (paramInt3 != 0));
      this.sAl.sBs = paramObject.sBs;
      ad.d("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo updateNotifyCallInfo, UserStatuslist.size: %d", new Object[] { Integer.valueOf(paramObject.DZm.size()) });
      paramObject = paramObject.DZm.iterator();
      while (paramObject.hasNext())
      {
        localObject1 = (cdf)paramObject.next();
        if (this.sAl.sBf != ((cdf)localObject1).DZv) {
          break label1537;
        }
        ad.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo update self userStatus, memberId: %d, status: %d, syncKey: %d", new Object[] { Integer.valueOf(this.sAl.sBf), Integer.valueOf(((cdf)localObject1).DZw), Integer.valueOf(((cdf)localObject1).DZx) });
        if (((cdf)localObject1).DZx > this.sAl.sBg)
        {
          this.sAl.sBg = ((cdf)localObject1).DZx;
          if (((cdf)localObject1).DZw != 0) {
            this.sAl.jMb = ((cdf)localObject1).DZw;
          }
        }
        label1448:
        if ((((cdf)localObject1).oXv == 404) || (((cdf)localObject1).oXv == 484))
        {
          ad.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo notify phonenumber invalid");
          this.sAl.sBl = true;
        }
        this.sAl.oXw = ((cdf)localObject1).oXw;
        this.sAl.oXv = ((cdf)localObject1).oXv;
        this.sAl.sBd = ((cdf)localObject1).sBd;
        this.sAl.sBe = ((cdf)localObject1).sBe;
      }
      label1537:
      ad.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo update others userStatus, memberId: %d, status: %d, syncKey: %d", new Object[] { Integer.valueOf(((cdf)localObject1).DZv), Integer.valueOf(((cdf)localObject1).DZw), Integer.valueOf(((cdf)localObject1).DZx) });
      paramInt1 = 0;
      localObject2 = this.sAl.sBx.iterator();
      label1596:
      if (((Iterator)localObject2).hasNext())
      {
        com.tencent.mm.plugin.ipcall.model.b.d locald = (com.tencent.mm.plugin.ipcall.model.b.d)((Iterator)localObject2).next();
        if (locald.nPB != ((cdf)localObject1).DZv) {
          break label2539;
        }
        if (((cdf)localObject1).DZx > locald.sBg)
        {
          locald.sBg = ((cdf)localObject1).DZx;
          if (((cdf)localObject1).DZw != 0) {
            locald.gch = ((cdf)localObject1).DZw;
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
      ((com.tencent.mm.plugin.ipcall.model.b.d)localObject2).nPB = ((cdf)localObject1).DZv;
      ((com.tencent.mm.plugin.ipcall.model.b.d)localObject2).gch = ((cdf)localObject1).DZw;
      ((com.tencent.mm.plugin.ipcall.model.b.d)localObject2).sBg = ((cdf)localObject1).DZx;
      this.sAl.sBx.add(localObject2);
      break label1448;
      if (!(paramObject instanceof k))
      {
        ad.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo redirect result error");
        AppMethodBeat.o(25379);
        return true;
      }
      paramObject = (k)paramObject;
      localObject1 = paramObject.sDb;
      if (this.sAl.roomId != paramObject.sDa.DdZ)
      {
        ad.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo redirect finished but room id not the same, now room roomId:%d, before room roomId:%d", new Object[] { Integer.valueOf(this.sAl.roomId), Integer.valueOf(paramObject.sDa.DdZ) });
        AppMethodBeat.o(25379);
        return true;
      }
      if ((paramInt2 == 0) && (paramInt3 == 0))
      {
        ad.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo redirect success");
        this.sAl.mty = ((ccy)localObject1).CCG;
        this.sAl.sBv = ((ccy)localObject1).DZi;
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
      paramObject = ((o)localObject1).sDj;
      if (this.sAl.roomId != ((o)localObject1).sDi.DdZ)
      {
        ad.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync finished but room id not the same, now room roomId:%d, before room roomId:%d", new Object[] { Integer.valueOf(this.sAl.roomId), Integer.valueOf(((o)localObject1).sDi.DdZ) });
        AppMethodBeat.o(25379);
        return true;
      }
      if ((paramInt2 != 0) || (paramInt3 != 0)) {
        break;
      }
      ad.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync roomId: %d, status: %d, memberId: %d, syncKey: %d", new Object[] { Integer.valueOf(paramObject.DdZ), Integer.valueOf(paramObject.DZu), Integer.valueOf(paramObject.DZv), Integer.valueOf(paramObject.DZs) });
      if ((paramObject.DdZ != this.sAl.roomId) || (paramObject.Dea != this.sAl.sAY)) {
        break;
      }
      if (paramObject.DZv == this.sAl.sBf)
      {
        ad.d("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync update self status");
        if (paramObject.DZs > this.sAl.sBg)
        {
          this.sAl.sBg = paramObject.DZs;
          if (paramObject.DZu != 0) {
            this.sAl.jMb = paramObject.DZu;
          }
        }
      }
      for (;;)
      {
        label2170:
        if ((paramObject.oXv == 404) || (paramObject.oXv == 484))
        {
          ad.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo sync phonenumber invalid");
          this.sAl.sBl = true;
        }
        this.sAl.oXw = paramObject.oXw;
        this.sAl.oXv = paramObject.oXv;
        this.sAl.sBd = paramObject.sBd;
        this.sAl.sBe = paramObject.sBe;
        this.sAl.sBs = paramObject.sBs;
        break;
        ad.d("MicroMsg.IPCallSvrLogic", " handleServiceResultCallInfosync update others status");
        localObject1 = this.sAl.sBx.iterator();
        paramInt1 = 0;
        label2286:
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (com.tencent.mm.plugin.ipcall.model.b.d)((Iterator)localObject1).next();
          if (((com.tencent.mm.plugin.ipcall.model.b.d)localObject2).nPB != paramObject.DZv) {
            break label2536;
          }
          if (paramObject.DZs > ((com.tencent.mm.plugin.ipcall.model.b.d)localObject2).sBg)
          {
            ((com.tencent.mm.plugin.ipcall.model.b.d)localObject2).sBg = paramObject.DZs;
            if (paramObject.DZu != 0) {
              ((com.tencent.mm.plugin.ipcall.model.b.d)localObject2).gch = paramObject.DZu;
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
          ((com.tencent.mm.plugin.ipcall.model.b.d)localObject1).nPB = paramObject.DZv;
          ((com.tencent.mm.plugin.ipcall.model.b.d)localObject1).gch = paramObject.DZu;
          ((com.tencent.mm.plugin.ipcall.model.b.d)localObject1).sBg = paramObject.DZs;
          this.sAl.sBx.add(localObject1);
          break label2170;
          if (!(paramObject instanceof com.tencent.mm.plugin.ipcall.model.e.h))
          {
            ad.e("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo heartbeat result error");
            AppMethodBeat.o(25379);
            return true;
          }
          ad.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo heartbeat finished errType:%d,errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
          paramObject = (com.tencent.mm.plugin.ipcall.model.e.h)paramObject;
          if (this.sAl.roomId == paramObject.sCU.DdZ) {
            break;
          }
          ad.i("MicroMsg.IPCallSvrLogic", "handleServiceResultCallInfo heartbeat finished but room id not the same, now room roomId:%d, before room roomId:%d", new Object[] { Integer.valueOf(this.sAl.roomId), Integer.valueOf(paramObject.sCU.DdZ) });
          AppMethodBeat.o(25379);
          return true;
        }
      }
    }
  }
  
  private void mp(boolean paramBoolean)
  {
    AppMethodBeat.i(25367);
    ad.i("MicroMsg.IPCallSvrLogic", "handleInvite, success: %b, isLaunchCancel: %b, isLaunchShutdown: %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.sAa), Boolean.valueOf(this.sAb) });
    if ((this.sAa) || (this.sAb))
    {
      ad.i("MicroMsg.IPCallSvrLogic", "handleInvite, ignore this");
      AppMethodBeat.o(25367);
      return;
    }
    if (paramBoolean)
    {
      if (this.sAc != null)
      {
        if (this.sAl.sBm) {
          break label130;
        }
        this.sAc.cGG();
      }
      for (;;)
      {
        ad.i("MicroMsg.IPCallSvrLogic", "start sync");
        this.sAe.a(this.sAl);
        AppMethodBeat.o(25367);
        return;
        label130:
        this.sAc.cGB();
      }
    }
    if (this.sAc != null)
    {
      if (this.sAl.sBj)
      {
        this.sAc.S(this.sAl.sBe, this.sAl.oXw, this.sAl.sBd);
        AppMethodBeat.o(25367);
        return;
      }
      if (this.sAl.sBk)
      {
        this.sAc.T(this.sAl.sBe, this.sAl.oXw, this.sAl.sBd);
        AppMethodBeat.o(25367);
        return;
      }
      if (this.sAl.sBl)
      {
        this.sAc.U(this.sAl.sBe, this.sAl.oXw, this.sAl.sBd);
        AppMethodBeat.o(25367);
        return;
      }
      if (!this.sAl.sBm)
      {
        this.sAc.cGG();
        AppMethodBeat.o(25367);
        return;
      }
      this.sAc.R(this.sAl.sBe, this.sAl.oXw, this.sAl.sBd);
    }
    AppMethodBeat.o(25367);
  }
  
  private void mq(boolean paramBoolean)
  {
    AppMethodBeat.i(25368);
    ad.i("MicroMsg.IPCallSvrLogic", "handleHeartbeat, success: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      this.szX += 1;
      if (this.szX >= 2)
      {
        ad.e("MicroMsg.IPCallSvrLogic", "heartbeat failed twice!");
        this.sAh.stop();
        if ((i.cHo().cHg()) && (this.sAc != null))
        {
          this.sAc.cGF();
          AppMethodBeat.o(25368);
        }
      }
    }
    else
    {
      this.szX = 0;
    }
    AppMethodBeat.o(25368);
  }
  
  private void mr(boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(25371);
    ad.i("MicroMsg.IPCallSvrLogic", "handleSync, success: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((paramBoolean) && (i.cHl().sCa)) {
      i.cHl().Fl(this.sAl.sBs);
    }
    if (!paramBoolean)
    {
      ad.e("MicroMsg.IPCallSvrLogic", "sync failed!");
      this.sAe.stop();
      if (i.cHo().ksb == 3) {}
      for (;;)
      {
        if ((i != 0) && (this.sAc != null)) {
          this.sAc.dz(this.sAl.oXw, this.sAl.sBd);
        }
        AppMethodBeat.o(25371);
        return;
        i = 0;
      }
    }
    if ((this.sAl != null) && (paramBoolean)) {
      Fk(this.sAl.cHB());
    }
    AppMethodBeat.o(25371);
  }
  
  private void ms(boolean paramBoolean)
  {
    AppMethodBeat.i(25372);
    ad.i("MicroMsg.IPCallSvrLogic", "handleNotify, success: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((paramBoolean) && (i.cHl().sCa)) {
      i.cHl().Fl(this.sAl.sBs);
    }
    if ((this.sAl != null) && (paramBoolean))
    {
      int i = this.sAl.cHB();
      if ((i == 2) || (i == 1))
      {
        if (!this.sAn)
        {
          o localo = new o(this.sAl.roomId, this.sAl.sAY, this.sAl.cHA(), this.sAl.sAZ, false);
          az.aeS().a(localo, 0);
        }
      }
      else {
        Fk(this.sAl.cHB());
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
  
  private void mt(boolean paramBoolean)
  {
    AppMethodBeat.i(25374);
    ad.i("MicroMsg.IPCallSvrLogic", "handleRedirect, isSuccess: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    com.tencent.mm.plugin.ipcall.model.d.a locala;
    Object localObject1;
    Object localObject2;
    if (paramBoolean)
    {
      locala = i.cHl();
      localObject1 = this.sAl;
      ad.i("MicroMsg.IPCallEngineManager", "redirectSvrAddr");
      if ((localObject1 != null) && (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).mty != null) && (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).mty.size() > 0)) {
        com.tencent.mm.plugin.ipcall.a.c.ay(((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).mty);
      }
      if ((localObject1 != null) && (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).sBv != null) && (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).sBv.size() > 0)) {
        com.tencent.mm.plugin.ipcall.a.c.ay(((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).sBv);
      }
      localObject2 = new cis();
      cir localcir = new cir();
      localcir.Dch = 0;
      localcir.Dci = "";
      localcir.Dcj = "";
      localcir.Dck = 4;
      localcir.Dcl = 4;
      localcir.Dcm = 2;
      localcir.Eec = new dli();
      localcir.Eed = new dli();
      if ((localObject1 != null) && (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).mty != null) && (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).mty.size() > 0)) {
        localcir.Eec = com.tencent.mm.plugin.ipcall.a.c.ay(((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).mty);
      }
      if ((localObject1 != null) && (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).sBv != null) && (((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).sBv.size() > 0)) {
        localcir.Eed = com.tencent.mm.plugin.ipcall.a.c.ay(((com.tencent.mm.plugin.ipcall.model.b.c)localObject1).sBv);
      }
      ((cis)localObject2).Eef.add(localcir);
      ((cis)localObject2).Eee = 1;
      localObject1 = null;
    }
    try
    {
      localObject2 = ((cis)localObject2).toByteArray();
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
      i = locala.sBX.AddNewRelayConns((byte[])localObject1, localObject1.length, 1);
      if (i != 0) {
        com.tencent.mm.plugin.voip.b.c.Loge("MicroMsg.IPCallEngineManager", "redirect relay conns fail ret:".concat(String.valueOf(i)));
      }
    }
    AppMethodBeat.o(25374);
  }
  
  public final void Fj(int paramInt)
  {
    AppMethodBeat.i(25366);
    if (!this.sAl.sBC) {
      ad.e("MicroMsg.IPCallSvrLogic", "shutdownIPCall, user not accept");
    }
    ad.i("MicroMsg.IPCallSvrLogic", "shutdownIPCall, roomId: %d, inviteId: %d", new Object[] { Integer.valueOf(this.sAl.roomId), Integer.valueOf(this.sAl.sBa) });
    this.sAb = true;
    this.sAh.stop();
    this.sAe.stop();
    this.sAg.sDS = false;
    this.sAg.sDR = paramInt;
    this.sAg.a(this.sAl);
    this.sAj.a(this.sAl);
    AppMethodBeat.o(25366);
  }
  
  public final boolean Fk(int paramInt)
  {
    AppMethodBeat.i(25373);
    switch (paramInt)
    {
    default: 
      ad.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, do nothing:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(25373);
      return false;
    case 2: 
      ad.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, user accept, isLaunchCancel: %b, isLaunchShutdown: %b", new Object[] { Boolean.valueOf(this.sAa), Boolean.valueOf(this.sAb) });
      if ((this.sAa) || (this.sAb))
      {
        AppMethodBeat.o(25373);
        return true;
      }
      this.sAe.stop();
      if (!this.duq)
      {
        this.duq = true;
        if (this.sAl != null) {
          this.sAl.sBC = true;
        }
        if (this.sAc != null) {
          this.sAc.cGD();
        }
        this.sAh.a(this.sAl);
      }
      AppMethodBeat.o(25373);
      return true;
    case 3: 
      ad.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, user busy");
      this.sAe.stop();
      this.sAh.stop();
      if (this.sAc != null) {
        this.sAc.dy(this.sAl.oXw, this.sAl.sBd);
      }
      AppMethodBeat.o(25373);
      return true;
    case 1: 
      ad.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, user ringing");
      if (!this.sAm)
      {
        this.sAm = true;
        if (this.sAc != null) {
          this.sAc.cGC();
        }
      }
      AppMethodBeat.o(25373);
      return true;
    case 5: 
      ad.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, other side user shutdown");
      if (this.sAc != null) {
        this.sAc.cGE();
      }
      AppMethodBeat.o(25373);
      return true;
    case 4: 
    case 7: 
    case 8: 
      ad.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, user unavailable");
      if (this.sAl.sBl) {
        if (this.sAc != null) {
          this.sAc.U(this.sAl.sBe, this.sAl.oXw, this.sAl.sBd);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(25373);
        return true;
        if (this.sAc != null) {
          this.sAc.dx(this.sAl.oXw, this.sAl.sBd);
        }
      }
    }
    ad.i("MicroMsg.IPCallSvrLogic", "handleSyncStatus, shutdown overdue");
    this.sAl.sBj = true;
    if (this.sAc != null) {
      this.sAc.S(this.sAl.sBe, this.sAl.oXw, this.sAl.sBd);
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
      mr(true);
      AppMethodBeat.o(25377);
      return;
      mq(true);
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
      mp(true);
      AppMethodBeat.o(25375);
      return;
      F(true, paramInt3);
      AppMethodBeat.o(25375);
      return;
      G(true, paramInt3);
      AppMethodBeat.o(25375);
      return;
      ms(true);
      AppMethodBeat.o(25375);
      return;
      mt(true);
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
      mr(false);
      AppMethodBeat.o(25378);
      return;
      mq(false);
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
      mp(false);
      AppMethodBeat.o(25376);
      return;
      F(false, paramInt3);
      AppMethodBeat.o(25376);
      return;
      G(false, paramInt3);
      AppMethodBeat.o(25376);
      return;
      ms(false);
      AppMethodBeat.o(25376);
      return;
      mt(false);
    }
  }
  
  public final void cHh()
  {
    AppMethodBeat.i(25365);
    if (this.sAl.sBC) {
      ad.e("MicroMsg.IPCallSvrLogic", "cancelIPCall, already accept");
    }
    this.sAa = true;
    ad.i("MicroMsg.IPCallSvrLogic", "cancelIPCall, roomId: %d, inviteId: %d", new Object[] { Integer.valueOf(this.sAl.roomId), Integer.valueOf(this.sAl.sBa) });
    this.sAh.stop();
    this.sAe.stop();
    this.sAf.a(this.sAl);
    this.sAj.a(this.sAl);
    AppMethodBeat.o(25365);
  }
  
  public static abstract interface a
  {
    public abstract void R(String paramString1, String paramString2, int paramInt);
    
    public abstract void S(String paramString1, String paramString2, int paramInt);
    
    public abstract void T(String paramString1, String paramString2, int paramInt);
    
    public abstract void U(String paramString1, String paramString2, int paramInt);
    
    public abstract void cGB();
    
    public abstract void cGC();
    
    public abstract void cGD();
    
    public abstract void cGE();
    
    public abstract void cGF();
    
    public abstract void cGG();
    
    public abstract void dx(String paramString, int paramInt);
    
    public abstract void dy(String paramString, int paramInt);
    
    public abstract void dz(String paramString, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.g
 * JD-Core Version:    0.7.0.1
 */