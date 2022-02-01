package com.tencent.kinda.framework.widget.tools;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.framework.app.UIPageFragmentActivity;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class KindaContext
{
  private static final String TAG = "KindaContext";
  private static Application.ActivityLifecycleCallbacks sActivityLifeCycleCallbacks;
  private static Stack<WeakReference<Context>> sContextStack;
  
  static
  {
    AppMethodBeat.i(19388);
    sActivityLifeCycleCallbacks = new Application.ActivityLifecycleCallbacks()
    {
      public final void onActivityCreated(Activity paramAnonymousActivity, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(19378);
        ae.d("KindaContext", "onActivityCreated：".concat(String.valueOf(paramAnonymousActivity)));
        if (KindaContext.sContextStack != null)
        {
          KindaContext.sContextStack.push(new WeakReference(paramAnonymousActivity));
          ae.i("KindaContext", "sContextStack.push：".concat(String.valueOf(paramAnonymousActivity)));
        }
        AppMethodBeat.o(19378);
      }
      
      public final void onActivityDestroyed(Activity paramAnonymousActivity) {}
      
      public final void onActivityPaused(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(19379);
        ae.d("KindaContext", "onActivityPaused：".concat(String.valueOf(paramAnonymousActivity)));
        WeakReference localWeakReference;
        if (paramAnonymousActivity.isFinishing())
        {
          Iterator localIterator = KindaContext.sContextStack.iterator();
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            localWeakReference = (WeakReference)localIterator.next();
          } while (localWeakReference.get() != paramAnonymousActivity);
        }
        for (;;)
        {
          if (localWeakReference != null)
          {
            KindaContext.sContextStack.remove(localWeakReference);
            ae.i("KindaContext", "The context is finishing, so sContextStack.remove:[" + paramAnonymousActivity + "]");
          }
          AppMethodBeat.o(19379);
          return;
          localWeakReference = null;
        }
      }
      
      public final void onActivityResumed(Activity paramAnonymousActivity) {}
      
      public final void onActivitySaveInstanceState(Activity paramAnonymousActivity, Bundle paramAnonymousBundle) {}
      
      public final void onActivityStarted(Activity paramAnonymousActivity) {}
      
      public final void onActivityStopped(Activity paramAnonymousActivity) {}
    };
    AppMethodBeat.o(19388);
  }
  
  private static void clearNullContextOfStack()
  {
    AppMethodBeat.i(19386);
    if ((sContextStack == null) || (sContextStack.size() <= 0))
    {
      AppMethodBeat.o(19386);
      return;
    }
    Object localObject1 = new ArrayList();
    Object localObject2 = sContextStack.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      WeakReference localWeakReference = (WeakReference)((Iterator)localObject2).next();
      if ((Context)localWeakReference.get() == null) {
        ((ArrayList)localObject1).add(localWeakReference);
      }
    }
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (WeakReference)((Iterator)localObject1).next();
      sContextStack.remove(localObject2);
      ae.i("KindaContext", "clearNullContextOfStack sContextStack.remove:[" + ((WeakReference)localObject2).get() + "]");
    }
    AppMethodBeat.o(19386);
  }
  
  public static Context get()
  {
    AppMethodBeat.i(19381);
    Context localContext = getUsableContext();
    AppMethodBeat.o(19381);
    return localContext;
  }
  
  public static Activity getTopOrUIPageFragmentActivity()
  {
    AppMethodBeat.i(19382);
    if (sContextStack == null)
    {
      ae.e("KindaContext", "KindaContext is null then return case1");
      AppMethodBeat.o(19382);
      return null;
    }
    clearNullContextOfStack();
    if (sContextStack.size() == 0)
    {
      ae.e("KindaContext", "KindaContext is stack is null then return case2");
      AppMethodBeat.o(19382);
      return null;
    }
    Stack localStack = new Stack();
    localStack.addAll(sContextStack);
    Object localObject4 = null;
    Object localObject1 = null;
    Object localObject2;
    Object localObject3;
    Activity localActivity;
    do
    {
      do
      {
        do
        {
          if (localStack.empty()) {
            break;
          }
          localObject2 = (WeakReference)localStack.pop();
          localObject3 = localObject4;
          if (localObject2 != null) {
            localObject3 = (Context)((WeakReference)localObject2).get();
          }
          localObject4 = localObject3;
        } while (!(localObject3 instanceof Activity));
        localActivity = (Activity)localObject3;
        localObject4 = localObject3;
      } while (localActivity.isFinishing());
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = localActivity;
      }
      localObject4 = localObject3;
      localObject1 = localObject2;
    } while (!(localActivity instanceof UIPageFragmentActivity));
    for (localObject1 = (UIPageFragmentActivity)localActivity;; localObject1 = localObject3)
    {
      localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = localObject2;
      }
      ae.i("KindaContext", "getTopOrUIPageFragmentActivity finally return [" + localObject3 + "]");
      AppMethodBeat.o(19382);
      return localObject3;
      localObject3 = null;
      localObject2 = localObject1;
    }
  }
  
  private static Context getUsableContext()
  {
    Context localContext = null;
    AppMethodBeat.i(19384);
    if (sContextStack == null)
    {
      ae.e("KindaContext", "The sContextStack is null then getUsableContext return null! case1");
      AppMethodBeat.o(19384);
      return null;
    }
    clearNullContextOfStack();
    String str = printContextStack();
    if (sContextStack.size() == 0)
    {
      ae.e("KindaContext", "The sContextStack is empty, so that return null! case2");
      AppMethodBeat.o(19384);
      return null;
    }
    Object localObject = (WeakReference)sContextStack.peek();
    if (localObject != null) {
      localContext = (Context)((WeakReference)localObject).get();
    }
    localObject = localContext;
    if ((localContext instanceof Activity))
    {
      Activity localActivity = (Activity)localContext;
      localObject = localContext;
      if (localActivity.isFinishing())
      {
        sContextStack.pop();
        ae.i("KindaContext", "getUsableContext，sContextStack.pop:[" + localActivity + "]");
        localObject = getUsableContext();
      }
    }
    if (localObject == null) {
      ae.e("KindaContext", "getUsableContext get null and the sContextStack before call：".concat(String.valueOf(str)));
    }
    for (;;)
    {
      AppMethodBeat.o(19384);
      return localObject;
      ae.i("KindaContext", "getUsableContext get value：".concat(String.valueOf(localObject)));
    }
  }
  
  private static void init()
  {
    AppMethodBeat.i(19387);
    ((Application)ak.getContext()).registerActivityLifecycleCallbacks(sActivityLifeCycleCallbacks);
    ae.i("KindaContext", "KindaContext has finish init.");
    AppMethodBeat.o(19387);
  }
  
  public static void initStack()
  {
    AppMethodBeat.i(19380);
    if (sContextStack == null)
    {
      sContextStack = new Stack();
      init();
      AppMethodBeat.o(19380);
      return;
    }
    sContextStack = new Stack();
    AppMethodBeat.o(19380);
  }
  
  public static void popToContext(Context paramContext)
  {
    AppMethodBeat.i(19383);
    if (paramContext == null)
    {
      AppMethodBeat.o(19383);
      return;
    }
    ae.d("KindaContext", "popToContext run");
    Object localObject = sContextStack.iterator();
    WeakReference localWeakReference;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localWeakReference = (WeakReference)((Iterator)localObject).next();
    } while ((localWeakReference.get() == null) || (paramContext != localWeakReference.get()));
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject = (WeakReference)sContextStack.peek();
        if ((localObject != null) && (((WeakReference)localObject).get() == paramContext))
        {
          ae.i("KindaContext", "popToContext break");
          AppMethodBeat.o(19383);
          return;
        }
        sContextStack.pop();
        if ((localObject == null) || (((WeakReference)localObject).get() == null)) {
          break label160;
        }
      }
      label160:
      for (localObject = localObject.toString();; localObject = "null")
      {
        ae.i("KindaContext", "popToContext pop context：".concat(String.valueOf(localObject)));
        if (sContextStack.size() > 0) {
          break;
        }
        AppMethodBeat.o(19383);
        return;
      }
    }
  }
  
  private static String printContextStack()
  {
    AppMethodBeat.i(19385);
    Object localObject = new StringBuilder("\n\t");
    Iterator localIterator = sContextStack.iterator();
    while (localIterator.hasNext())
    {
      Context localContext = (Context)((WeakReference)localIterator.next()).get();
      if (localContext != null)
      {
        ((StringBuilder)localObject).append(localContext.toString());
        ((StringBuilder)localObject).append("\n\t");
      }
      else
      {
        ((StringBuilder)localObject).append("null");
        ((StringBuilder)localObject).append("\n\t");
      }
    }
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(19385);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.tools.KindaContext
 * JD-Core Version:    0.7.0.1
 */