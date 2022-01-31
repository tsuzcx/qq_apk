package com.tencent.mm.ipcinvoker;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b.a.a;

final class BaseIPCService$1
  extends a.a
{
  BaseIPCService$1(BaseIPCService paramBaseIPCService) {}
  
  public final void a(Bundle paramBundle, String paramString, com.tencent.mm.ipcinvoker.b.b paramb)
  {
    AppMethodBeat.i(113998);
    if ((paramString == null) || (paramString.length() == 0))
    {
      com.tencent.mm.ipcinvoker.h.b.e("IPC.BaseIPCService", "invokeAsync failed, class is null or nil.", new Object[0]);
      AppMethodBeat.o(113998);
      return;
    }
    if (paramBundle == null)
    {
      com.tencent.mm.ipcinvoker.h.b.e("IPC.BaseIPCService", "invokeAsync failed, data is null.", new Object[0]);
      AppMethodBeat.o(113998);
      return;
    }
    paramBundle.setClassLoader(BaseIPCService.class.getClassLoader());
    paramBundle = paramBundle.getParcelable("__remote_task_data");
    a locala = (a)k.c(paramString, a.class);
    if (locala == null)
    {
      com.tencent.mm.ipcinvoker.h.b.e("IPC.BaseIPCService", "invokeAsync failed, can not newInstance by class %s.", new Object[] { paramString });
      AppMethodBeat.o(113998);
      return;
    }
    m.post(new BaseIPCService.1.1(this, locala, paramBundle, paramb, paramString));
    AppMethodBeat.o(113998);
  }
  
  public final Bundle f(Bundle paramBundle, String paramString)
  {
    AppMethodBeat.i(113999);
    if ((paramString == null) || (paramString.length() == 0))
    {
      com.tencent.mm.ipcinvoker.h.b.e("IPC.BaseIPCService", "invokeSync failed, class is null or nil.", new Object[0]);
      AppMethodBeat.o(113999);
      return null;
    }
    if (paramBundle == null)
    {
      com.tencent.mm.ipcinvoker.h.b.e("IPC.BaseIPCService", "invokeSync failed, data is null.", new Object[0]);
      AppMethodBeat.o(113999);
      return null;
    }
    i locali = (i)k.c(paramString, i.class);
    if (locali == null)
    {
      com.tencent.mm.ipcinvoker.h.b.e("IPC.BaseIPCService", "invokeSync failed, can not newInstance by class %s.", new Object[] { paramString });
      AppMethodBeat.o(113999);
      return null;
    }
    paramBundle.setClassLoader(BaseIPCService.class.getClassLoader());
    paramBundle = paramBundle.getParcelable("__remote_task_data");
    paramString = new Bundle();
    paramString.putParcelable("__remote_task_result_data", (Parcelable)locali.S(paramBundle));
    AppMethodBeat.o(113999);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.BaseIPCService.1
 * JD-Core Version:    0.7.0.1
 */