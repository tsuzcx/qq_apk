package com.tencent.kinda.framework.module.impl;

import android.os.Handler;
import android.os.Looper;
import com.tencent.kinda.gen.KCgi;
import com.tencent.kinda.gen.KNetworkMockManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.ac;

public class WXPNetSceneBase
  extends n
  implements k
{
  private static final String TAG = "MicroMsg.KindaLibWXPNetSceneBase";
  private KCgi cgi;
  private int cgiId;
  private String cgiUri;
  private int channelType;
  private KNetworkMockManager mockManager;
  private g onSceneEndCallback;
  private int reqCmdId;
  private byte[] requestData;
  private int respCmdId;
  private int retryCount;
  private int timeoutMs;
  private WXPCommReqResp wxpCommReqResp;
  
  public WXPNetSceneBase(int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4, int paramInt5, byte[] paramArrayOfByte, KCgi paramKCgi, KNetworkMockManager paramKNetworkMockManager)
  {
    AppMethodBeat.i(18701);
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
    ac.i("MicroMsg.KindaLibWXPNetSceneBase", "init scene: cgiId:%d, cgiUri:%s ", new Object[] { Integer.valueOf(paramInt2), paramString });
    AppMethodBeat.o(18701);
  }
  
  public void cancel()
  {
    AppMethodBeat.i(18705);
    ac.e("MicroMsg.KindaLibWXPNetSceneBase", "cancel: thread when doScene: %s, thread id: %d, cgiUri: %s", new Object[] { Thread.currentThread(), Long.valueOf(Thread.currentThread().getId()), this.cgiUri });
    super.cancel();
    if (this.cgi == null)
    {
      AppMethodBeat.o(18705);
      return;
    }
    this.cgi.onResp(1, null);
    AppMethodBeat.o(18705);
  }
  
  public int dispatch(e parame, q paramq, k paramk)
  {
    AppMethodBeat.i(18703);
    int i = super.dispatch(parame, paramq, paramk);
    AppMethodBeat.o(18703);
    return i;
  }
  
  public int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(18702);
    this.onSceneEndCallback = paramg;
    int i = dispatch(parame, this.wxpCommReqResp, this);
    AppMethodBeat.o(18702);
    return i;
  }
  
  public int getType()
  {
    return this.cgiId;
  }
  
  public void onGYNetEnd(int paramInt1, final int paramInt2, final int paramInt3, String paramString, final q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(18704);
    ac.i("MicroMsg.KindaLibWXPNetSceneBase", "onGYNetEnd: %s, , uri: %s errType %d errCode %d errMsg %s", new Object[] { Integer.valueOf(this.cgiId), this.cgiUri, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = (WXPCommReqResp.Resp)paramq.getRespObj();
    if (this.cgi == null)
    {
      AppMethodBeat.o(18704);
      return;
    }
    new Handler(Looper.getMainLooper()).post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(18700);
        if (paramInt2 == 0)
        {
          WXPNetSceneBase.this.cgi.onResp(0, paramq.getResponseWrapper().getData());
          AppMethodBeat.o(18700);
          return;
        }
        if ((paramInt2 == 4) && (paramInt3 == -102))
        {
          WXPNetSceneBase.this.cgi.onResp(351, null);
          AppMethodBeat.o(18700);
          return;
        }
        WXPNetSceneBase.this.cgi.onResp(1, null);
        AppMethodBeat.o(18700);
      }
    });
    this.onSceneEndCallback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(18704);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.module.impl.WXPNetSceneBase
 * JD-Core Version:    0.7.0.1
 */