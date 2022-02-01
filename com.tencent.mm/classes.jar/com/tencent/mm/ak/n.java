package com.tencent.mm.ak;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bl;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import junit.framework.Assert;

public abstract class n
{
  private static final long DEFAULT_RETURN_TIMEOUT = 600000L;
  private static final int LIMIT_NOT_INITIALIZED = -99;
  private static final String TAG = "MicroMsg.NetSceneBase";
  private e dispatcher;
  private boolean hasCallbackToQueue;
  private q irr;
  private boolean isCanceled = false;
  private boolean isKinda = false;
  protected long lastdispatch = bs.Gn();
  private int limit = -99;
  private int netId = -1;
  private int priority = 0;
  private g queueCallback;
  private t remoteCB;
  
  protected boolean accept(n paramn)
  {
    return false;
  }
  
  protected boolean acceptConcurrent(n paramn)
  {
    return false;
  }
  
  protected void cancel()
  {
    ac.i("MicroMsg.NetSceneBase", "cancel: %d, hash:%d, type:%d", new Object[] { Integer.valueOf(this.netId), Integer.valueOf(hashCode()), Integer.valueOf(getType()) });
    this.isCanceled = true;
    if (this.remoteCB != null) {
      this.remoteCB.cancel();
    }
    if ((this.netId != -1) && (this.dispatcher != null))
    {
      int i = this.netId;
      this.netId = -1;
      this.dispatcher.cancel(i);
    }
  }
  
  protected int dispatch(e parame, final q paramq, final k paramk)
  {
    prepareDispatcher(parame);
    this.irr = paramq;
    paramk = bl.a(paramk);
    int i = bl.azf();
    if (i != 0) {
      return i;
    }
    if (this.limit == -99)
    {
      this.limit = securityLimitCount();
      ac.i("MicroMsg.NetSceneBase", "initilized security limit count to " + this.limit);
    }
    if (securityLimitCount() > 1) {
      switch (2.hvV[securityVerificationChecked(paramq).ordinal()])
      {
      default: 
        Assert.assertTrue("invalid security verification status", false);
      }
    }
    while (securityLimitCountReach())
    {
      ac.e("MicroMsg.NetSceneBase", "dispatch failed, scene limited for security, current limit=" + securityLimitCount());
      setSecurityCheckError(a.hvX);
      this.netId = -1;
      return this.netId;
      Assert.assertTrue("scene security verification not passed, type=" + paramq.getType() + ", uri=" + paramq.getUri() + ", CHECK NOW", false);
      continue;
      ac.e("MicroMsg.NetSceneBase", "scene security verification not passed, type=" + paramq.getType() + ", uri=" + paramq.getUri());
      this.limit -= 1;
      setSecurityCheckError(a.hvW);
      this.netId = -1;
      return this.netId;
    }
    this.limit -= 1;
    v localv = new v(paramq);
    if ((this.remoteCB != null) && (!isSupportConcurrent())) {
      this.remoteCB.cancel();
    }
    this.remoteCB = new t(paramq, paramk, this, this.queueCallback, parame);
    this.netId = parame.a(localv, this.remoteCB);
    ac.i("MicroMsg.NetSceneBase", "dispatcher send, %s", new Object[] { Integer.valueOf(this.netId) });
    if (this.netId < 0)
    {
      ac.i("MicroMsg.NetSceneBase", "dispatcher send, %s, ThreadID:%s, getType:%s", new Object[] { Integer.valueOf(this.netId), Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(paramq.getType()) });
      new ao().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(132308);
          ac.i("MicroMsg.NetSceneBase", "dispatcher send, %s, ThreadID:%s, getType:%s", new Object[] { Integer.valueOf(n.this.netId), Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(paramq.getType()) });
          paramk.onGYNetEnd(-1, 3, -1, "send to network failed", paramq, null);
          ac.i("MicroMsg.NetSceneBase", "dispatcher send, %s, ThreadID:%s, getType:%s", new Object[] { Integer.valueOf(n.this.netId), Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(paramq.getType()) });
          AppMethodBeat.o(132308);
        }
      });
      return 99999999;
    }
    parame = this.remoteCB;
    parame.handler.postDelayed(parame.hwB, 330000L);
    return this.netId;
  }
  
  public e dispatcher()
  {
    return this.dispatcher;
  }
  
  public abstract int doScene(e parame, g paramg);
  
  public String getInfo()
  {
    return "";
  }
  
  public boolean getIsKinda()
  {
    return this.isKinda;
  }
  
  public int getMMReqRespHash()
  {
    if (this.irr == null) {
      return 0;
    }
    return this.irr.hashCode();
  }
  
  public int getPriority()
  {
    return this.priority;
  }
  
  public q getReqResp()
  {
    return this.irr;
  }
  
  protected long getReturnTimeout()
  {
    return 600000L;
  }
  
  public abstract int getType();
  
  public boolean hasCallBackToQueue()
  {
    return this.hasCallbackToQueue;
  }
  
  public boolean isCanceled()
  {
    return this.isCanceled;
  }
  
  protected boolean isSupportConcurrent()
  {
    return false;
  }
  
  public boolean needCheckCallback()
  {
    return securityLimitCount() == 1;
  }
  
  protected void prepareDispatcher(e parame)
  {
    this.lastdispatch = bs.Gn();
    this.dispatcher = parame;
  }
  
  public void reset()
  {
    this.lastdispatch = bs.Gn();
    this.netId = -1;
    this.limit = -99;
  }
  
  protected int securityLimitCount()
  {
    return 1;
  }
  
  protected boolean securityLimitCountReach()
  {
    return this.limit <= 0;
  }
  
  protected b securityVerificationChecked(q paramq)
  {
    return b.hvZ;
  }
  
  public void setHasCallbackToQueue(boolean paramBoolean)
  {
    this.hasCallbackToQueue = paramBoolean;
  }
  
  public void setIsKinda(boolean paramBoolean)
  {
    this.isKinda = paramBoolean;
  }
  
  public void setOnSceneEnd(g paramg)
  {
    this.queueCallback = paramg;
  }
  
  public void setPriority(int paramInt)
  {
    this.priority = paramInt;
  }
  
  protected void setSecurityCheckError(a parama) {}
  
  public boolean uniqueInNetsceneQueue()
  {
    return false;
  }
  
  @Deprecated
  protected void updateDispatchId(int paramInt) {}
  
  protected void updateDispatchIdNew(int paramInt)
  {
    this.netId = paramInt;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(132312);
      hvW = new a("EStatusCheckFailed", 0);
      hvX = new a("EReachMaxLimit", 1);
      hvY = new a[] { hvW, hvX };
      AppMethodBeat.o(132312);
    }
    
    private a() {}
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(132315);
      hvZ = new b("EUnchecked", 0);
      hwa = new b("EOk", 1);
      hwb = new b("EFailed", 2);
      hwc = new b[] { hvZ, hwa, hwb };
      AppMethodBeat.o(132315);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ak.n
 * JD-Core Version:    0.7.0.1
 */