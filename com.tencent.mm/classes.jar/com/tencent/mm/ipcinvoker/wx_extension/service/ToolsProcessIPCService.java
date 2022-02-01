package com.tencent.mm.ipcinvoker.wx_extension.service;

import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.BaseIPCService;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class ToolsProcessIPCService
  extends BaseIPCService
{
  public static final String PROCESS_NAME;
  static int mzM;
  private static a mzN;
  
  static
  {
    AppMethodBeat.i(235725);
    PROCESS_NAME = MMApplicationContext.getPackageName() + ":tools";
    mzM = 0;
    AppMethodBeat.o(235725);
  }
  
  public static void a(a parama)
  {
    mzN = parama;
  }
  
  public static <T extends d<InputType, ResultType>, InputType extends Parcelable, ResultType extends Parcelable> boolean a(InputType paramInputType, Class<T> paramClass)
  {
    AppMethodBeat.i(146441);
    boolean bool2 = j.a(PROCESS_NAME, paramInputType, paramClass, null);
    boolean bool1 = bool2;
    if (!aYM()) {
      if ((!j.a(ToolsMpProcessIPCService.PROCESS_NAME, paramInputType, paramClass, null)) || (!bool2)) {
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
  
  public static <T extends d<InputType, ResultType>, InputType extends Parcelable, ResultType extends Parcelable> boolean a(InputType paramInputType, Class<T> paramClass, f<ResultType> paramf)
  {
    boolean bool3 = true;
    AppMethodBeat.i(146440);
    boolean bool1;
    if (MMApplicationContext.isProcessExist(MMApplicationContext.getPackageName() + ":tools")) {
      if (j.a(PROCESS_NAME, paramInputType, paramClass, paramf)) {
        bool1 = true;
      }
    }
    for (;;)
    {
      boolean bool2 = bool1;
      if (!aYM())
      {
        bool2 = bool1;
        if (MMApplicationContext.isProcessExist(MMApplicationContext.getPackageName() + ":toolsmp")) {
          if ((!j.a(ToolsMpProcessIPCService.PROCESS_NAME, paramInputType, paramClass, paramf)) || (!bool1)) {
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
  
  public static <T extends d<InputType, ResultType>, InputType extends Parcelable, ResultType extends Parcelable> boolean a(Class<T> paramClass, f<ResultType> paramf)
  {
    AppMethodBeat.i(146442);
    boolean bool = j.a(PROCESS_NAME, null, paramClass, paramf);
    AppMethodBeat.o(146442);
    return bool;
  }
  
  public static boolean aYM()
  {
    AppMethodBeat.i(146439);
    boolean bool;
    if (mzM == 0)
    {
      a locala = mzN;
      if (locala == null) {
        break label47;
      }
      bool = locala.aYM();
      if (!bool) {
        break label52;
      }
    }
    label47:
    label52:
    for (mzM = 1;; mzM = -1)
    {
      if (mzM <= 0) {
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
    return PROCESS_NAME;
  }
  
  public static abstract interface a
  {
    public abstract boolean aYM();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService
 * JD-Core Version:    0.7.0.1
 */