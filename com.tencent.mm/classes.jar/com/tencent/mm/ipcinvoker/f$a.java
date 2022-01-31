package com.tencent.mm.ipcinvoker;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.b.b.a;

final class f$a
  extends b.a
  implements com.tencent.mm.ipcinvoker.f.c
{
  String dGD;
  c dGK;
  
  f$a(String paramString, c paramc)
  {
    this.dGK = paramc;
    this.dGD = paramString;
    com.tencent.mm.ipcinvoker.f.b.a(paramString, this);
    com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCInvokeCallbackWrapper", "keep ref of callback(%s)", new Object[] { Integer.valueOf(paramc.hashCode()) });
  }
  
  protected final void finalize()
  {
    recycle();
    com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCInvokeCallbackWrapper", "finalize(%s)", new Object[] { Integer.valueOf(hashCode()) });
    super.finalize();
  }
  
  public final void g(Bundle paramBundle)
  {
    c localc = this.dGK;
    if (localc == null)
    {
      com.tencent.mm.ipcinvoker.h.b.w("IPC.IPCInvokeCallbackWrapper", "callback failed, ref has been release", new Object[0]);
      return;
    }
    if (paramBundle == null)
    {
      localc.U(null);
      return;
    }
    paramBundle.setClassLoader(f.class.getClassLoader());
    if (paramBundle.getBoolean("__command_release_ref"))
    {
      com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCInvokeCallbackWrapper", "release ref of callback(%s)", new Object[] { Integer.valueOf(localc.hashCode()) });
      recycle();
      return;
    }
    localc.U(paramBundle.getParcelable("__remote_task_result_data"));
  }
  
  public final void recycle()
  {
    this.dGK = null;
    com.tencent.mm.ipcinvoker.f.b.b(this.dGD, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.f.a
 * JD-Core Version:    0.7.0.1
 */