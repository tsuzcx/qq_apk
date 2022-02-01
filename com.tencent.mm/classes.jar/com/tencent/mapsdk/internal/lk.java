package com.tencent.mapsdk.internal;

import com.tencent.map.tools.net.NetManager;
import com.tencent.map.tools.net.NetRequest.NetRequestBuilder;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

public class lk
  extends lc
{
  private NetResponse a;
  
  private static InputStream a(InputStream paramInputStream)
  {
    return paramInputStream;
  }
  
  protected void a(NetRequest.NetRequestBuilder paramNetRequestBuilder) {}
  
  protected void a(NetResponse paramNetResponse) {}
  
  public final void b()
  {
    AppMethodBeat.i(222598);
    super.b();
    if (this.a != null) {
      kb.a(this.a.getInputStream());
    }
    AppMethodBeat.o(222598);
  }
  
  public InputStream e(String paramString)
  {
    AppMethodBeat.i(222577);
    NetRequest.NetRequestBuilder localNetRequestBuilder = NetManager.getInstance().builder().url(paramString);
    a(localNetRequestBuilder);
    this.a = localNetRequestBuilder.doStream();
    paramString = null;
    if (this.a != null)
    {
      paramString = this.a.getInputStream();
      a(this.a);
    }
    for (;;)
    {
      AppMethodBeat.o(222577);
      return paramString;
      a(new NetResponse(localNetRequestBuilder.getNetRequest()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.lk
 * JD-Core Version:    0.7.0.1
 */