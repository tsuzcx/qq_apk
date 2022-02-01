package com.tencent.mapsdk.internal;

import android.text.TextUtils;
import com.tencent.map.tools.net.NetManager;
import com.tencent.map.tools.net.NetRequest.NetRequestBuilder;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class li
  extends lc
{
  public final byte[] f(String paramString)
  {
    AppMethodBeat.i(222609);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(222609);
      return null;
    }
    NetResponse localNetResponse = NetManager.getInstance().builder().url(paramString).doGet();
    if ((localNetResponse != null) && (localNetResponse.available()))
    {
      paramString = localNetResponse.data;
      AppMethodBeat.o(222609);
      return paramString;
    }
    paramString = super.f(paramString);
    AppMethodBeat.o(222609);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.li
 * JD-Core Version:    0.7.0.1
 */