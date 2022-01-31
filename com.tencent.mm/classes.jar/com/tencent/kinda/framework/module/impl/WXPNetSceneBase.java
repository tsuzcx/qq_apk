package com.tencent.kinda.framework.module.impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.tencent.kinda.gen.KCgi;
import com.tencent.kinda.gen.KNetworkMockManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.ab;

public class WXPNetSceneBase
  extends m
  implements k
{
  private static final String TAG = "MicroMsg.KindaLibWXPNetSceneBase";
  private KCgi cgi;
  private int cgiId;
  private String cgiUri;
  private int channelType;
  private KNetworkMockManager mockManager;
  private f onSceneEndCallback;
  private int reqCmdId;
  private byte[] requestData;
  private int respCmdId;
  private int retryCount;
  private int timeoutMs;
  private WXPCommReqResp wxpCommReqResp;
  
  public WXPNetSceneBase(int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4, int paramInt5, byte[] paramArrayOfByte, KCgi paramKCgi, KNetworkMockManager paramKNetworkMockManager)
  {
    AppMethodBeat.i(144590);
    this.reqCmdId = paramInt1;
    this.respCmdId = 0;
    this.cgiId = paramInt2;
    this.cgiUri = paramString;
    this.channelType = paramInt3;
    this.timeoutMs = paramInt4;
    this.retryCount = paramInt5;
    this.requestData = paramArrayOfByte;
    this.cgi = paramKCgi;
    this.mockManager = paramKNetworkMockManager;
    this.wxpCommReqResp = new WXPCommReqResp(paramArrayOfByte, paramString, paramInt2, paramInt1, this.respCmdId, true, paramInt5, paramInt4, paramKCgi.getRouteInfo(), this.mockManager);
    setIsKinda(true);
    ab.v("MicroMsg.KindaLibWXPNetSceneBase", "thread when init: %s, thread id: %d, pid: %d", new Object[] { Thread.currentThread(), Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(Process.myPid()) });
    ab.v("MicroMsg.KindaLibWXPNetSceneBase", "when init: cgiId:%d, cgiUri:%s ", new Object[] { Integer.valueOf(paramInt2), paramString });
    AppMethodBeat.o(144590);
  }
  
  public int dispatch(e parame, q paramq, k paramk)
  {
    AppMethodBeat.i(144592);
    int i = super.dispatch(parame, paramq, paramk);
    AppMethodBeat.o(144592);
    return i;
  }
  
  public int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(144591);
    ab.v("MicroMsg.KindaLibWXPNetSceneBase", "thread when doScene: %s, thread id: %d", new Object[] { Thread.currentThread(), Long.valueOf(Thread.currentThread().getId()) });
    this.onSceneEndCallback = paramf;
    int i = dispatch(parame, this.wxpCommReqResp, this);
    AppMethodBeat.o(144591);
    return i;
  }
  
  public int getType()
  {
    return this.cgiId;
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(144593);
    ab.i("MicroMsg.KindaLibWXPNetSceneBase", "thread when onGYNetEnd: %s, , thread id: %d errType %d errCode %d errMsg %s", new Object[] { Thread.currentThread(), Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = (WXPCommReqResp.Resp)paramq.getRespObj();
    if (this.cgi == null)
    {
      AppMethodBeat.o(144593);
      return;
    }
    new Handler(Looper.getMainLooper()).post(new WXPNetSceneBase.1(this, paramInt2, paramq, paramInt3));
    this.onSceneEndCallback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(144593);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.kinda.framework.module.impl.WXPNetSceneBase
 * JD-Core Version:    0.7.0.1
 */