package com.tencent.mm.ipcinvoker;

import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class f
{
  private static Bundle a(Parcelable paramParcelable)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("__remote_task_data", paramParcelable);
    return localBundle;
  }
  
  public static <T extends i<InputType, ResultType>, InputType extends Parcelable, ResultType extends Parcelable> ResultType a(String paramString, InputType paramInputType, Class<T> paramClass)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      com.tencent.mm.ipcinvoker.h.b.e("IPC.IPCInvoker", "invokeSync failed, process is null or nil.", new Object[0]);
      return null;
    }
    if (e.fE(paramString))
    {
      paramString = ((i)k.a(paramClass, i.class)).W(paramInputType);
      if (paramString == null) {
        return null;
      }
      return (Parcelable)paramString;
    }
    com.tencent.mm.ipcinvoker.b.a locala = b.BT().fB(paramString);
    if (locala == null)
    {
      com.tencent.mm.ipcinvoker.h.b.e("IPC.IPCInvoker", "invokeSync failed, get bridge is null by process(%s).", new Object[] { paramString });
      return null;
    }
    try
    {
      paramString = locala.e(a(paramInputType), paramClass.getName());
      if (paramString == null) {
        return null;
      }
      paramString.setClassLoader(f.class.getClassLoader());
      paramString = paramString.getParcelable("__remote_task_result_data");
      return paramString;
    }
    catch (RemoteException paramString)
    {
      com.tencent.mm.ipcinvoker.h.b.d("IPC.IPCInvoker", "invokeSync failed, ipc invoke error : %s", new Object[] { paramString });
    }
    return null;
  }
  
  public static void a(String paramString, j paramj)
  {
    b localb = b.BT();
    Set localSet = (Set)localb.dGu.get(paramString);
    Object localObject = localSet;
    if (localSet == null) {
      localObject = new HashSet();
    }
    ((Set)localObject).add(paramj);
    localb.dGu.put(paramString, localObject);
  }
  
  public static <T extends a<InputType, ResultType>, InputType extends Parcelable, ResultType extends Parcelable> boolean a(String paramString, InputType paramInputType, Class<T> paramClass, c<ResultType> paramc)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      com.tencent.mm.ipcinvoker.h.b.e("IPC.IPCInvoker", "invokeAsync failed, process is null or nil.", new Object[0]);
      return false;
    }
    if (paramClass == null)
    {
      com.tencent.mm.ipcinvoker.h.b.e("IPC.IPCInvoker", "invokeAsync failed, taskClass is null(process : %s).", new Object[] { paramString });
      return false;
    }
    return l.n(new f.1(paramString, paramClass, paramInputType, paramc));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.f
 * JD-Core Version:    0.7.0.1
 */