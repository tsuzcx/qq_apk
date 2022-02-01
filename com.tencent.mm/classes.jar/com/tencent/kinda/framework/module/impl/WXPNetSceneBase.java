package com.tencent.kinda.framework.module.impl;

import android.os.Handler;
import android.os.Looper;
import com.tencent.kinda.gen.KCgi;
import com.tencent.kinda.gen.KNetworkMockManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.ae.a.a;
import com.tencent.mm.plugin.ae.a.c;
import com.tencent.mm.sdk.platformtools.Log;

public class WXPNetSceneBase
  extends p
  implements m
{
  private static final String TAG = "MicroMsg.KindaLibWXPNetSceneBase";
  private KCgi cgi;
  private int cgiId;
  private String cgiUri;
  private h onSceneEndCallback;
  private int respCmdId;
  private WXPCommReqResp wxpCommReqResp;
  
  public WXPNetSceneBase(int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4, int paramInt5, byte[] paramArrayOfByte, KCgi paramKCgi, KNetworkMockManager paramKNetworkMockManager)
  {
    AppMethodBeat.i(18701);
    this.respCmdId = 0;
    this.cgiId = paramInt2;
    this.cgiUri = paramString;
    this.cgi = paramKCgi;
    this.wxpCommReqResp = new WXPCommReqResp(paramArrayOfByte, paramString, paramInt2, paramInt1, this.respCmdId, true, paramInt5, paramInt4, paramKCgi.getRouteInfo(), paramKNetworkMockManager);
    setIsKinda(true);
    Log.i("MicroMsg.KindaLibWXPNetSceneBase", "init scene: cgiId:%d, cgiUri:%s ", new Object[] { Integer.valueOf(paramInt2), paramString });
    AppMethodBeat.o(18701);
  }
  
  private void clearField()
  {
    this.cgi = null;
    if (this.wxpCommReqResp != null) {
      this.wxpCommReqResp = null;
    }
  }
  
  public void cancel()
  {
    AppMethodBeat.i(18705);
    Log.e("MicroMsg.KindaLibWXPNetSceneBase", "cancel: thread when doScene: %s, thread id: %d, cgiUri: %s", new Object[] { Thread.currentThread(), Long.valueOf(Thread.currentThread().getId()), this.cgiUri });
    super.cancel();
    if (this.cgi == null)
    {
      AppMethodBeat.o(18705);
      return;
    }
    this.cgi.onResp(1, null);
    clearField();
    AppMethodBeat.o(18705);
  }
  
  public int dispatch(g paramg, s params, m paramm)
  {
    AppMethodBeat.i(18703);
    int i = super.dispatch(paramg, params, paramm);
    AppMethodBeat.o(18703);
    return i;
  }
  
  public int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(18702);
    this.onSceneEndCallback = paramh;
    c.gxP().An(true);
    int i = dispatch(paramg, this.wxpCommReqResp, this);
    AppMethodBeat.o(18702);
    return i;
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(226682);
    super.finalize();
    AppMethodBeat.o(226682);
  }
  
  public int getType()
  {
    return this.cgiId;
  }
  
  public void onGYNetEnd(int paramInt1, final int paramInt2, final int paramInt3, String paramString, final s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(18704);
    Log.i("MicroMsg.KindaLibWXPNetSceneBase", "onGYNetEnd: %s, , uri: %s errType %d errCode %d errMsg %s", new Object[] { Integer.valueOf(this.cgiId), this.cgiUri, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    params = (WXPCommReqResp.Resp)params.getRespObj();
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
        if (WXPNetSceneBase.this.cgi == null)
        {
          AppMethodBeat.o(18700);
          return;
        }
        if (paramInt2 == 0) {
          WXPNetSceneBase.this.cgi.onResp(0, params.getResponseWrapper().getData());
        }
        for (;;)
        {
          WXPNetSceneBase.access$100(WXPNetSceneBase.this);
          AppMethodBeat.o(18700);
          return;
          if ((paramInt2 == 4) && (paramInt3 == -102)) {
            WXPNetSceneBase.this.cgi.onResp(351, null);
          } else {
            WXPNetSceneBase.this.cgi.onResp(1, null);
          }
        }
      }
    });
    this.onSceneEndCallback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(18704);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.framework.module.impl.WXPNetSceneBase
 * JD-Core Version:    0.7.0.1
 */