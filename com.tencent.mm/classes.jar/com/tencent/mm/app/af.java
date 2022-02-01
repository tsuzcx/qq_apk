package com.tencent.mm.app;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.lib.e.b;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import org.xmlpull.v1.XmlPullParserException;

public final class af
{
  public static boolean b(StackTraceElement[] paramArrayOfStackTraceElement)
  {
    AppMethodBeat.i(125026);
    int j = paramArrayOfStackTraceElement.length;
    int i = 0;
    while (i < j)
    {
      String str = paramArrayOfStackTraceElement[i].getClassName();
      if ((str != null) && ((str.contains("de.robv.android.xposed.XposedBridge")) || (str.contains("com.zte.heartyservice.SCC.FrameworkBridge"))))
      {
        AppMethodBeat.o(125026);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(125026);
    return false;
  }
  
  public static void e(Throwable paramThrowable)
  {
    AppMethodBeat.i(125027);
    ApplicationLike localApplicationLike = d.cTo;
    if ((localApplicationLike == null) || (localApplicationLike.getApplication() == null))
    {
      ShareTinkerLog.v("TinkerCrashProtect", "applicationlike is null", new Object[0]);
      AppMethodBeat.o(125027);
      return;
    }
    if (!b.d(localApplicationLike))
    {
      ShareTinkerLog.v("TinkerCrashProtect", "tinker is not loaded", new Object[0]);
      AppMethodBeat.o(125027);
      return;
    }
    int i;
    boolean bool;
    if ((Build.MODEL.contains("ZUK")) || (Build.MODEL.contains("zuk")))
    {
      i = 1;
      bool = false;
      label91:
      if (paramThrowable == null) {
        break label276;
      }
      if (bool) {
        break label287;
      }
      bool = b(paramThrowable.getStackTrace());
    }
    label276:
    label282:
    label287:
    for (;;)
    {
      if (bool) {
        if ((!(paramThrowable instanceof IllegalAccessError)) || (!paramThrowable.getMessage().contains("Class ref in pre-verified class resolved to unexpected implementation"))) {
          break label282;
        }
      }
      for (int j = 1;; j = 0)
      {
        if (j != 0)
        {
          ShareTinkerLog.v("TinkerCrashProtect", "have xposed: just clean tinker", new Object[0]);
          ShareTinkerInternals.killAllOtherProcess(localApplicationLike.getApplication());
          b.f(localApplicationLike);
          ShareTinkerInternals.setTinkerDisableWithSharedPreferences(localApplicationLike.getApplication());
          AppMethodBeat.o(125027);
          return;
          i = 0;
          break;
        }
        if (i != 0)
        {
          ShareTinkerLog.v("TinkerCrashProtect", "it is zuk model here, crash:" + paramThrowable.getMessage(), new Object[0]);
          if (((paramThrowable instanceof XmlPullParserException)) && (paramThrowable.getMessage().contains("tag requires a 'drawable' attribute or child tag defining a drawable")))
          {
            ShareTinkerLog.v("TinkerCrashProtect", "have zuk parse error: just clean tinker", new Object[0]);
            ShareTinkerInternals.killAllOtherProcess(localApplicationLike.getApplication());
            b.f(localApplicationLike);
            ShareTinkerInternals.setTinkerDisableWithSharedPreferences(localApplicationLike.getApplication());
            AppMethodBeat.o(125027);
            return;
          }
        }
        paramThrowable = paramThrowable.getCause();
        break label91;
        AppMethodBeat.o(125027);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.af
 * JD-Core Version:    0.7.0.1
 */