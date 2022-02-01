package com.tencent.mm.am;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bu;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import junit.framework.Assert;

public abstract class p
{
  private static final long DEFAULT_RETURN_TIMEOUT = 600000L;
  private static final int LIMIT_NOT_INITIALIZED = -99;
  private static final String TAG = "MicroMsg.NetSceneBase";
  private g dispatcher;
  private boolean hasCallbackToQueue;
  private s irr;
  private boolean isCanceled = false;
  private boolean isKinda = false;
  protected long lastdispatch = Util.currentTicks();
  private int limit = -99;
  private int netId = -1;
  private int priority = 0;
  private h queueCallback;
  private v remoteCB;
  
  protected boolean accept(p paramp)
  {
    return false;
  }
  
  protected boolean acceptConcurrent(p paramp)
  {
    return false;
  }
  
  protected void cancel()
  {
    Log.i("MicroMsg.NetSceneBase", "cancel: %d, hash:%d, type:%d", new Object[] { Integer.valueOf(this.netId), Integer.valueOf(hashCode()), Integer.valueOf(getType()) });
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
  
  protected int dispatch(g paramg, final s params, final m paramm)
  {
    prepareDispatcher(paramg);
    this.irr = params;
    paramm = bu.a(paramm, this);
    int i = bu.bCS();
    if (i != 0) {
      return i;
    }
    if (this.limit == -99)
    {
      this.limit = securityLimitCount();
      Log.i("MicroMsg.NetSceneBase", "initilized security limit count to " + this.limit);
    }
    if (securityLimitCount() > 1) {
      switch (p.2.ouc[securityVerificationChecked(params).ordinal()])
      {
      default: 
        Assert.assertTrue("invalid security verification status", false);
      }
    }
    while (securityLimitCountReach())
    {
      Log.e("MicroMsg.NetSceneBase", "dispatch failed, scene limited for security, current limit=" + securityLimitCount());
      setSecurityCheckError(p.a.oue);
      this.netId = -1;
      return this.netId;
      Assert.assertTrue("scene security verification not passed, type=" + params.getType() + ", uri=" + params.getUri() + ", CHECK NOW", false);
      continue;
      Log.e("MicroMsg.NetSceneBase", "scene security verification not passed, type=" + params.getType() + ", uri=" + params.getUri());
      this.limit -= 1;
      setSecurityCheckError(p.a.oud);
      this.netId = -1;
      return this.netId;
    }
    this.limit -= 1;
    x localx = new x(params);
    if ((this.remoteCB != null) && (!isSupportConcurrent())) {
      this.remoteCB.cancel();
    }
    this.remoteCB = new v(params, paramm, this, this.queueCallback, paramg);
    this.netId = paramg.a(localx, this.remoteCB);
    Log.i("MicroMsg.NetSceneBase", "dispatcher send, %s", new Object[] { Integer.valueOf(this.netId) });
    if (this.netId < 0)
    {
      Log.i("MicroMsg.NetSceneBase", "dispatcher send, %s, ThreadID:%s, getType:%s", new Object[] { Integer.valueOf(this.netId), Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(params.getType()) });
      new MMHandler().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(132308);
          Log.i("MicroMsg.NetSceneBase", "dispatcher send, %s, ThreadID:%s, getType:%s", new Object[] { Integer.valueOf(p.this.netId), Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(params.getType()) });
          paramm.onGYNetEnd(-1, 3, -1, "send to network failed", params, null);
          Log.i("MicroMsg.NetSceneBase", "dispatcher send, %s, ThreadID:%s, getType:%s", new Object[] { Integer.valueOf(p.this.netId), Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(params.getType()) });
          AppMethodBeat.o(132308);
        }
      });
      return 99999999;
    }
    paramg = this.remoteCB;
    paramg.handler.postDelayed(paramg.ouK, 330000L);
    return this.netId;
  }
  
  public g dispatcher()
  {
    return this.dispatcher;
  }
  
  public abstract int doScene(g paramg, h paramh);
  
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
  
  public s getReqResp()
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
  
  protected void prepareDispatcher(g paramg)
  {
    this.lastdispatch = Util.currentTicks();
    this.dispatcher = paramg;
  }
  
  public void reset()
  {
    this.lastdispatch = Util.currentTicks();
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
  
  protected p.b securityVerificationChecked(s params)
  {
    return p.b.oug;
  }
  
  public void setHasCallbackToQueue(boolean paramBoolean)
  {
    this.hasCallbackToQueue = paramBoolean;
  }
  
  public void setIsKinda(boolean paramBoolean)
  {
    this.isKinda = paramBoolean;
  }
  
  public void setOnSceneEnd(h paramh)
  {
    this.queueCallback = paramh;
  }
  
  public void setPriority(int paramInt)
  {
    this.priority = paramInt;
  }
  
  protected void setSecurityCheckError(p.a parama) {}
  
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.am.p
 * JD-Core Version:    0.7.0.1
 */