package com.tencent.mm.ipcinvoker.wx_extension.service;

import android.os.Parcelable;
import com.tencent.mm.ipcinvoker.BaseIPCService;
import com.tencent.mm.ipcinvoker.a;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.f;

public class ToolsProcessIPCService
  extends BaseIPCService
{
  public static <T extends a<InputType, ResultType>, InputType extends Parcelable, ResultType extends Parcelable> boolean a(InputType paramInputType, Class<T> paramClass)
  {
    boolean bool = f.a("com.tencent.mm:tools", paramInputType, paramClass, null);
    return (f.a("com.tencent.mm:toolsmp", paramInputType, paramClass, null)) && (bool);
  }
  
  public static <T extends a<InputType, ResultType>, InputType extends Parcelable, ResultType extends Parcelable> boolean a(InputType paramInputType, Class<T> paramClass, c<ResultType> paramc)
  {
    return f.a("com.tencent.mm:tools", paramInputType, paramClass, paramc);
  }
  
  public final String getProcessName()
  {
    return "com.tencent.mm:tools";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService
 * JD-Core Version:    0.7.0.1
 */