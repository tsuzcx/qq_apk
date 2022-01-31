package com.tencent.mm.ipcinvoker.wx_extension.service;

import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.BaseIPCService;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.wx_extension.a.a.b;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.Map;

public class ToolsProcessIPCService
  extends BaseIPCService
{
  static int eFa = 0;
  
  public static boolean Qa()
  {
    AppMethodBeat.i(126226);
    Object localObject;
    int i;
    if (eFa == 0)
    {
      localObject = a.b.eEW;
      localObject = com.tencent.mm.ipcinvoker.wx_extension.a.a.me("100488");
      if (localObject != null) {
        break label48;
      }
      i = 0;
      if (i == 0) {
        break label121;
      }
    }
    label48:
    label76:
    label116:
    label121:
    for (eFa = 1;; eFa = -1)
    {
      if (eFa <= 0) {
        break label128;
      }
      AppMethodBeat.o(126226);
      return true;
      if ((((com.tencent.mm.storage.c)localObject).isValid()) && ("1".equals(((com.tencent.mm.storage.c)localObject).dvN().get("SAFEFLAG"))))
      {
        i = 1;
        if ((!((com.tencent.mm.storage.c)localObject).isValid()) || (!"1".equals(((com.tencent.mm.storage.c)localObject).dvN().get("TURNOFFTOOLMP")))) {
          break label116;
        }
      }
      for (int j = 1;; j = 0)
      {
        i &= j;
        break;
        i = 0;
        break label76;
      }
    }
    label128:
    AppMethodBeat.o(126226);
    return false;
  }
  
  public static <T extends com.tencent.mm.ipcinvoker.a<InputType, ResultType>, InputType extends Parcelable, ResultType extends Parcelable> boolean a(InputType paramInputType, Class<T> paramClass)
  {
    AppMethodBeat.i(126227);
    if (!ah.apj(ah.getPackageName() + ":tools"))
    {
      AppMethodBeat.o(126227);
      return false;
    }
    boolean bool = f.a("com.tencent.mm:tools", paramInputType, paramClass, null);
    AppMethodBeat.o(126227);
    return bool;
  }
  
  public static <T extends com.tencent.mm.ipcinvoker.a<InputType, ResultType>, InputType extends Parcelable, ResultType extends Parcelable> boolean a(InputType paramInputType, Class<T> paramClass, com.tencent.mm.ipcinvoker.c<ResultType> paramc)
  {
    AppMethodBeat.i(126229);
    boolean bool = f.a("com.tencent.mm:tools", paramInputType, paramClass, paramc);
    AppMethodBeat.o(126229);
    return bool;
  }
  
  public static <T extends com.tencent.mm.ipcinvoker.a<InputType, ResultType>, InputType extends Parcelable, ResultType extends Parcelable> boolean b(InputType paramInputType, Class<T> paramClass)
  {
    AppMethodBeat.i(126228);
    boolean bool2 = f.a("com.tencent.mm:tools", paramInputType, paramClass, null);
    boolean bool1 = bool2;
    if (!Qa()) {
      if ((!f.a("com.tencent.mm:toolsmp", paramInputType, paramClass, null)) || (!bool2)) {
        break label46;
      }
    }
    label46:
    for (bool1 = true;; bool1 = false)
    {
      AppMethodBeat.o(126228);
      return bool1;
    }
  }
  
  public final String getProcessName()
  {
    return "com.tencent.mm:tools";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService
 * JD-Core Version:    0.7.0.1
 */