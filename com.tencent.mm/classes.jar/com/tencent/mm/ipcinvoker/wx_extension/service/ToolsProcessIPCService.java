package com.tencent.mm.ipcinvoker.wx_extension.service;

import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.BaseIPCService;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class ToolsProcessIPCService
  extends BaseIPCService
{
  public static final String dkO;
  static int hnR;
  private static a hnS;
  
  static
  {
    AppMethodBeat.i(225240);
    dkO = MMApplicationContext.getPackageName() + ":tools";
    hnR = 0;
    AppMethodBeat.o(225240);
  }
  
  public static void a(a parama)
  {
    hnS = parama;
  }
  
  public static <T extends b<InputType, ResultType>, InputType extends Parcelable, ResultType extends Parcelable> boolean a(InputType paramInputType, Class<T> paramClass)
  {
    AppMethodBeat.i(146441);
    boolean bool2 = h.a(dkO, paramInputType, paramClass, null);
    boolean bool1 = bool2;
    if (!ayt()) {
      if ((!h.a(ToolsMpProcessIPCService.dkO, paramInputType, paramClass, null)) || (!bool2)) {
        break label48;
      }
    }
    label48:
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
    if (MMApplicationContext.isProcessExist(MMApplicationContext.getPackageName() + ":tools")) {
      if (h.a(dkO, paramInputType, paramClass, paramd)) {
        bool1 = true;
      }
    }
    for (;;)
    {
      boolean bool2 = bool1;
      if (!ayt())
      {
        bool2 = bool1;
        if (MMApplicationContext.isProcessExist(MMApplicationContext.getPackageName() + ":toolsmp")) {
          if ((!h.a(ToolsMpProcessIPCService.dkO, paramInputType, paramClass, paramd)) || (!bool1)) {
            break label123;
          }
        }
      }
      label123:
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
    boolean bool = h.a(dkO, null, paramClass, paramd);
    AppMethodBeat.o(146442);
    return bool;
  }
  
  public static boolean ayt()
  {
    AppMethodBeat.i(146439);
    boolean bool;
    if (hnR == 0)
    {
      a locala = hnS;
      if (locala == null) {
        break label47;
      }
      bool = locala.ayt();
      if (!bool) {
        break label52;
      }
    }
    label47:
    label52:
    for (hnR = 1;; hnR = -1)
    {
      if (hnR <= 0) {
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
    return dkO;
  }
  
  public static abstract interface a
  {
    public abstract boolean ayt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService
 * JD-Core Version:    0.7.0.1
 */