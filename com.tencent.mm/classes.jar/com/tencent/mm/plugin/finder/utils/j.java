package com.tencent.mm.plugin.finder.utils;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.e.a;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.plugin.findersdk.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/FinderContextManager;", "", "()V", "TAG", "", "TYPE_APPLICATION_CONTEXT", "TYPE_FINDER_TOP_ACTIVITY_CONTEXT", "TYPE_TOP_ACTIVITY_CONTEXT", "topActivityRef", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "getFinderContext", "Landroid/content/Context;", "getTopActivity", "onPause", "", "activity", "onResume", "report", "type", "contextName", "tryGetFinderContext", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
{
  public static final j Gge;
  private static WeakReference<Activity> Ggf;
  
  static
  {
    AppMethodBeat.i(333686);
    Gge = new j();
    AppMethodBeat.o(333686);
  }
  
  public static void aL(Activity paramActivity)
  {
    AppMethodBeat.i(333667);
    s.u(paramActivity, "activity");
    Log.i("Finder.FinderContextManager", s.X("update top activity: ", paramActivity.getClass().getSimpleName()));
    Ggf = new WeakReference(paramActivity);
    AppMethodBeat.o(333667);
  }
  
  public static void aM(Activity paramActivity)
  {
    AppMethodBeat.i(333672);
    s.u(paramActivity, "activity");
    Log.i("Finder.FinderContextManager", "remove top activity");
    Ggf = null;
    AppMethodBeat.o(333672);
  }
  
  public static Activity feL()
  {
    AppMethodBeat.i(333653);
    Object localObject = Ggf;
    if (localObject == null)
    {
      AppMethodBeat.o(333653);
      return null;
    }
    localObject = (Activity)((WeakReference)localObject).get();
    AppMethodBeat.o(333653);
    return localObject;
  }
  
  private static void report(String paramString1, final String paramString2)
  {
    AppMethodBeat.i(333679);
    s.u(paramString1, "type");
    s.u(paramString2, "contextName");
    Log.i("Finder.FinderContextManager", "report type = " + paramString1 + ", contextName = " + paramString2);
    e.a.a((e)b.HbT, paramString1, false, null, false, (a)new a(paramString1, paramString2), 28);
    AppMethodBeat.o(333679);
  }
  
  public static Context tryGetFinderContext()
  {
    AppMethodBeat.i(333658);
    Context localContext = MMApplicationContext.getContext();
    for (;;)
    {
      try
      {
        Object localObject1 = feL();
        String str;
        if (localObject1 != null)
        {
          str = localObject1.getClass().getSimpleName();
          Log.i("Finder.FinderContextManager", s.X("tryGetFinderContext finderTopActivity: ", str));
          s.s(str, "contextName");
          report("finderSpamGetFinderContext", str);
          localObject1 = (Context)localObject1;
          if (s.p(localObject1, localContext))
          {
            str = localContext.getClass().getSimpleName();
            Log.i("Finder.FinderContextManager", s.X("tryGetFinderContext fallbackContext: ", str));
            s.s(str, "contextName");
            report("finderSpamGetApplicationContext", str);
          }
          s.s(localObject1, "context");
          AppMethodBeat.o(333658);
          return localObject1;
        }
        localObject1 = AppForegroundDelegate.aCe();
        if (localObject1 == null)
        {
          localObject1 = null;
          if (localObject1 == null) {
            break label218;
          }
          str = localObject1.getClass().getSimpleName();
          Log.i("Finder.FinderContextManager", s.X("tryGetFinderContext appTopActivity: ", str));
          localObject1 = (Context)localObject1;
          s.s(str, "contextName");
          report("finderSpamGetWechatContext", str);
          continue;
        }
        localObject3 = (Activity)((WeakReference)localObject3).get();
      }
      finally
      {
        Log.e("Finder.FinderContextManager", "tryGetFinderContext get activity failed", new Object[] { localObject2 });
        localObject3 = localContext.getClass().getSimpleName();
        s.s(localObject3, "contextName");
        report("finderSpamGetApplicationContext", (String)localObject3);
        s.s(localContext, "fallbackContext");
        AppMethodBeat.o(333658);
        return localContext;
      }
      continue;
      label218:
      Object localObject3 = localContext;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<String>
  {
    a(String paramString1, String paramString2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.j
 * JD-Core Version:    0.7.0.1
 */