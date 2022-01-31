package com.tencent.mm.ipcinvoker;

import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class f
{
  public static <T extends i<InputType, ResultType>, InputType extends Parcelable, ResultType extends Parcelable> ResultType a(String paramString, InputType paramInputType, Class<T> paramClass)
  {
    AppMethodBeat.i(114032);
    if ((paramString == null) || (paramString.length() == 0))
    {
      com.tencent.mm.ipcinvoker.h.b.e("IPC.IPCInvoker", "invokeSync failed, process is null or nil.", new Object[0]);
      AppMethodBeat.o(114032);
      return null;
    }
    if (e.lZ(paramString))
    {
      paramString = ((i)k.b(paramClass, i.class)).S(paramInputType);
      if (paramString == null)
      {
        AppMethodBeat.o(114032);
        return null;
      }
      paramString = (Parcelable)paramString;
      AppMethodBeat.o(114032);
      return paramString;
    }
    com.tencent.mm.ipcinvoker.b.a locala = b.PK().lW(paramString);
    if (locala == null)
    {
      com.tencent.mm.ipcinvoker.h.b.e("IPC.IPCInvoker", "invokeSync failed, get bridge is null by process(%s).", new Object[] { paramString });
      AppMethodBeat.o(114032);
      return null;
    }
    try
    {
      paramString = locala.f(c(paramInputType), paramClass.getName());
      if (paramString == null)
      {
        AppMethodBeat.o(114032);
        return null;
      }
      paramString.setClassLoader(f.class.getClassLoader());
      paramString = paramString.getParcelable("__remote_task_result_data");
      AppMethodBeat.o(114032);
      return paramString;
    }
    catch (RemoteException paramString)
    {
      com.tencent.mm.ipcinvoker.h.b.d("IPC.IPCInvoker", "invokeSync failed, ipc invoke error : %s", new Object[] { paramString });
      AppMethodBeat.o(114032);
    }
    return null;
  }
  
  public static void a(String paramString, j paramj)
  {
    AppMethodBeat.i(114031);
    b localb = b.PK();
    Set localSet = (Set)localb.eDX.get(paramString);
    Object localObject = localSet;
    if (localSet == null) {
      localObject = new HashSet();
    }
    ((Set)localObject).add(paramj);
    localb.eDX.put(paramString, localObject);
    AppMethodBeat.o(114031);
  }
  
  public static <T extends a<InputType, ResultType>, InputType extends Parcelable, ResultType extends Parcelable> boolean a(String paramString, InputType paramInputType, Class<T> paramClass, c<ResultType> paramc)
  {
    AppMethodBeat.i(114030);
    if ((paramString == null) || (paramString.length() == 0))
    {
      com.tencent.mm.ipcinvoker.h.b.e("IPC.IPCInvoker", "invokeAsync failed, process is null or nil.", new Object[0]);
      AppMethodBeat.o(114030);
      return false;
    }
    if (paramClass == null)
    {
      com.tencent.mm.ipcinvoker.h.b.e("IPC.IPCInvoker", "invokeAsync failed, taskClass is null(process : %s).", new Object[] { paramString });
      AppMethodBeat.o(114030);
      return false;
    }
    boolean bool = l.r(new f.1(paramString, paramClass, paramInputType, paramc));
    AppMethodBeat.o(114030);
    return bool;
  }
  
  private static Bundle c(Parcelable paramParcelable)
  {
    AppMethodBeat.i(114033);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("__remote_task_data", paramParcelable);
    AppMethodBeat.o(114033);
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.f
 * JD-Core Version:    0.7.0.1
 */