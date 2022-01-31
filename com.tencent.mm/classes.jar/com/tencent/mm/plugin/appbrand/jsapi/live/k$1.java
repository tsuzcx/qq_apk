package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.rtmp.ITXLiveBaseListener;

final class k$1
  implements ITXLiveBaseListener
{
  public final void OnLog(int paramInt, String paramString1, String paramString2)
  {
    switch (paramInt)
    {
    default: 
      y.d(paramString1, paramString2);
      return;
    case 0: 
      y.v(paramString1, paramString2);
      return;
    case 1: 
      y.d(paramString1, paramString2);
      return;
    case 2: 
      y.i(paramString1, paramString2);
      return;
    case 3: 
      y.w(paramString1, paramString2);
      return;
    case 4: 
      y.e(paramString1, paramString2);
      return;
    }
    y.f(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.k.1
 * JD-Core Version:    0.7.0.1
 */