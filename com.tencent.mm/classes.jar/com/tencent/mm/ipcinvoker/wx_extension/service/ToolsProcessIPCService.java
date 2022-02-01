package com.tencent.mm.ipcinvoker.wx_extension.service;

import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.BaseIPCService;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.sdk.platformtools.aj;

public class ToolsProcessIPCService
  extends BaseIPCService
{
  static int gyv = 0;
  private static a gyw;
  
  public static void a(a parama)
  {
    gyw = parama;
  }
  
  public static <T extends b<InputType, ResultType>, InputType extends Parcelable, ResultType extends Parcelable> boolean a(InputType paramInputType, Class<T> paramClass)
  {
    AppMethodBeat.i(146441);
    boolean bool2 = h.a("com.tencent.mm:tools", paramInputType, paramClass, null);
    boolean bool1 = bool2;
    if (!ahO()) {
      if ((!h.a("com.tencent.mm:toolsmp", paramInputType, paramClass, null)) || (!bool2)) {
        break label46;
      }
    }
    label46:
    for (bool1 = true;; bool1 = false)
    {
      AppMethodBeat.o(146441);
      return bool1;
    }
  }
  
  public static <T extends b<InputType, ResultType>, InputType extends Parcelable, ResultType extends Parcelable> boolean a(InputType paramInputType, Class<T> paramClass, d<ResultType> paramd)
  {
    boolean bool3 = true;
    AppMethodBeat.i(146440);
    boolean bool1;
    if (aj.aQt(aj.getPackageName() + ":tools")) {
      if (h.a("com.tencent.mm:tools", paramInputType, paramClass, paramd)) {
        bool1 = true;
      }
    }
    for (;;)
    {
      boolean bool2 = bool1;
      if (!ahO())
      {
        bool2 = bool1;
        if (aj.aQt(aj.getPackageName() + ":toolsmp")) {
          if ((!h.a("com.tencent.mm:toolsmp", paramInputType, paramClass, paramd)) || (!bool1)) {
            break label121;
          }
        }
      }
      label121:
      for (bool1 = bool3;; bool1 = false)
      {
        bool2 = bool1;
        AppMethodBeat.o(146440);
        return bool2;
        bool1 = false;
        break;
      }
      bool1 = true;
    }
  }
  
  public static <T extends b<InputType, ResultType>, InputType extends Parcelable, ResultType extends Parcelable> boolean a(Class<T> paramClass, d<ResultType> paramd)
  {
    AppMethodBeat.i(146442);
    boolean bool = h.a("com.tencent.mm:tools", null, paramClass, paramd);
    AppMethodBeat.o(146442);
    return bool;
  }
  
  public static boolean ahO()
  {
    AppMethodBeat.i(146439);
    boolean bool;
    if (gyv == 0)
    {
      a locala = gyw;
      if (locala == null) {
        break label47;
      }
      bool = locala.ahO();
      if (!bool) {
        break label52;
      }
    }
    label47:
    label52:
    for (gyv = 1;; gyv = -1)
    {
      if (gyv <= 0) {
        break label59;
      }
      AppMethodBeat.o(146439);
      return true;
      bool = false;
      break;
    }
    label59:
    AppMethodBeat.o(146439);
    return false;
  }
  
  public final String getProcessName()
  {
    return "com.tencent.mm:tools";
  }
  
  public static abstract interface a
  {
    public abstract boolean ahO();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService
 * JD-Core Version:    0.7.0.1
 */