package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.networking.b;
import com.tencent.mm.plugin.appbrand.networking.e;
import com.tencent.mm.plugin.appbrand.task.f;
import com.tencent.mm.sdk.platformtools.ab;

final class o$9
  implements f
{
  o$9(o paramo) {}
  
  private boolean am(String paramString, int paramInt)
  {
    AppMethodBeat.i(154837);
    if (this.gRv.gRl == null)
    {
      ab.e("MicroMsg.AppBrandRuntimeWC", "AppBrandRuntimeController checkTokenOk with reason[%s], get NULL mRemoteController from runtime", new Object[] { paramString });
      AppMethodBeat.o(154837);
      return true;
    }
    if (paramInt == this.gRv.gRl.hashCode())
    {
      AppMethodBeat.o(154837);
      return true;
    }
    AppMethodBeat.o(154837);
    return false;
  }
  
  public final void ni(int paramInt)
  {
    AppMethodBeat.i(154838);
    if (am("finish", paramInt)) {
      this.gRv.finish();
    }
    AppMethodBeat.o(154838);
  }
  
  public final void onNetworkChange(int paramInt)
  {
    AppMethodBeat.i(154839);
    if (am("onNetworkChange", paramInt))
    {
      b localb = (b)this.gRv.E(b.class);
      if ((localb instanceof e)) {
        ((e)localb).aIx();
      }
    }
    AppMethodBeat.o(154839);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o.9
 * JD-Core Version:    0.7.0.1
 */