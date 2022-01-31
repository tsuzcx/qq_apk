package com.tencent.mm.app;

import android.os.Build;
import com.tencent.tinker.lib.f.a;
import com.tencent.tinker.loader.app.ApplicationLike;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import org.xmlpull.v1.XmlPullParserException;

public final class s
{
  public static boolean a(StackTraceElement[] paramArrayOfStackTraceElement)
  {
    boolean bool2 = false;
    int j = paramArrayOfStackTraceElement.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        String str = paramArrayOfStackTraceElement[i].getClassName();
        if ((str != null) && ((str.contains("de.robv.android.xposed.XposedBridge")) || (str.contains("com.zte.heartyservice.SCC.FrameworkBridge")))) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static void b(Throwable paramThrowable)
  {
    ApplicationLike localApplicationLike = b.applicationLike;
    if ((localApplicationLike == null) || (localApplicationLike.getApplication() == null))
    {
      a.w("TinkerCrashProtect", "applicationlike is null", new Object[0]);
      return;
    }
    if (!com.tencent.tinker.lib.e.b.d(localApplicationLike))
    {
      a.w("TinkerCrashProtect", "tinker is not loaded", new Object[0]);
      return;
    }
    int i;
    label74:
    boolean bool;
    if ((Build.MODEL.contains("ZUK")) || (Build.MODEL.contains("zuk")))
    {
      i = 1;
      bool = false;
      label76:
      if (paramThrowable == null) {
        break label249;
      }
      if (bool) {
        break label256;
      }
      bool = a(paramThrowable.getStackTrace());
    }
    label256:
    for (;;)
    {
      if (bool) {
        if ((!(paramThrowable instanceof IllegalAccessError)) || (!paramThrowable.getMessage().contains("Class ref in pre-verified class resolved to unexpected implementation"))) {
          break label251;
        }
      }
      label249:
      label251:
      for (int j = 1;; j = 0)
      {
        if (j != 0)
        {
          a.e("TinkerCrashProtect", "have xposed: just clean tinker", new Object[0]);
          ShareTinkerInternals.ig(localApplicationLike.getApplication());
          com.tencent.tinker.lib.e.b.f(localApplicationLike);
          ShareTinkerInternals.ic(localApplicationLike.getApplication());
          return;
          i = 0;
          break label74;
        }
        if (i != 0)
        {
          a.w("TinkerCrashProtect", "it is zuk model here, crash:" + paramThrowable.getMessage(), new Object[0]);
          if (((paramThrowable instanceof XmlPullParserException)) && (paramThrowable.getMessage().contains("tag requires a 'drawable' attribute or child tag defining a drawable")))
          {
            a.e("TinkerCrashProtect", "have zuk parse error: just clean tinker", new Object[0]);
            ShareTinkerInternals.ig(localApplicationLike.getApplication());
            com.tencent.tinker.lib.e.b.f(localApplicationLike);
            ShareTinkerInternals.ic(localApplicationLike.getApplication());
            return;
          }
        }
        paramThrowable = paramThrowable.getCause();
        break label76;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.s
 * JD-Core Version:    0.7.0.1
 */