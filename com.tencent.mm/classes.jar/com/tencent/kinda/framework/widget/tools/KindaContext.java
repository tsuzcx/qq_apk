package com.tencent.kinda.framework.widget.tools;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import com.tencent.kinda.framework.app.UIPageFragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
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
    AppMethodBeat.i(145208);
    sActivityLifeCycleCallbacks = new KindaContext.1();
    AppMethodBeat.o(145208);
  }
  
  private static void clearNullContextOfStack()
  {
    AppMethodBeat.i(145205);
    if ((sContextStack == null) || (sContextStack.size() <= 0))
    {
      AppMethodBeat.o(145205);
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
    ab.i("KindaContext", "clearNullContextOfStack ref:[" + ((ArrayList)localObject1).size() + "]");
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (WeakReference)((Iterator)localObject1).next();
      sContextStack.remove(localObject2);
    }
    AppMethodBeat.o(145205);
  }
  
  public static Context get()
  {
    AppMethodBeat.i(145201);
    Context localContext = getUsableContext();
    AppMethodBeat.o(145201);
    return localContext;
  }
  
  public static Activity getTopOrUIPageFragmentActivity()
  {
    Object localObject5 = null;
    AppMethodBeat.i(145202);
    if (sContextStack == null)
    {
      ab.e("KindaContext", "KindaContext is null then return case1");
      AppMethodBeat.o(145202);
      return null;
    }
    clearNullContextOfStack();
    if (sContextStack.size() == 0)
    {
      ab.e("KindaContext", "KindaContext is stack is null then return case2");
      AppMethodBeat.o(145202);
      return null;
    }
    Stack localStack = new Stack();
    localStack.addAll(sContextStack);
    Object localObject4 = null;
    Object localObject1 = null;
    Object localObject2;
    Activity localActivity;
    do
    {
      Object localObject3;
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
    for (localObject1 = (UIPageFragmentActivity)localActivity;; localObject1 = localObject5)
    {
      if (localObject1 == null)
      {
        AppMethodBeat.o(145202);
        return localObject2;
      }
      AppMethodBeat.o(145202);
      return localObject1;
      localObject2 = localObject1;
    }
  }
  
  private static Context getUsableContext()
  {
    Context localContext = null;
    AppMethodBeat.i(145203);
    if (sContextStack == null)
    {
      ab.e("KindaContext", "KindaContext is null then getUsableContext return case1");
      AppMethodBeat.o(145203);
      return null;
    }
    clearNullContextOfStack();
    if (sContextStack.size() == 0)
    {
      ab.e("KindaContext", "KindaContext is stack is null then getUsableContext return case2");
      AppMethodBeat.o(145203);
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
        ab.d("KindaContext", "getUsableContext，sContextStack.pop：".concat(String.valueOf(localActivity)));
        localObject = getUsableContext();
      }
    }
    if (localObject == null) {
      ab.e("KindaContext", "getUsableContext get null and now sContextStack：\n" + printContextStack());
    }
    for (;;)
    {
      AppMethodBeat.o(145203);
      return localObject;
      ab.i("KindaContext", "getUsableContext get value：" + localObject.getClass().getCanonicalName());
    }
  }
  
  private static void init()
  {
    AppMethodBeat.i(145207);
    ((Application)ah.getContext()).registerActivityLifecycleCallbacks(sActivityLifeCycleCallbacks);
    AppMethodBeat.o(145207);
  }
  
  public static void init(Context paramContext)
  {
    AppMethodBeat.i(145200);
    if (sContextStack == null) {
      init();
    }
    sContextStack = new Stack();
    if ((paramContext instanceof Activity))
    {
      Activity localActivity = (Activity)paramContext;
      if ((!localActivity.isFinishing()) && (!localActivity.isDestroyed())) {
        sContextStack.push(new WeakReference(paramContext));
      }
      AppMethodBeat.o(145200);
      return;
    }
    sContextStack.push(new WeakReference(paramContext));
    AppMethodBeat.o(145200);
  }
  
  public static void popToContext(Context paramContext)
  {
    AppMethodBeat.i(145206);
    if (paramContext == null)
    {
      AppMethodBeat.o(145206);
      return;
    }
    ab.d("KindaContext", "popToContext run");
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
      if (i != 0) {
        do
        {
          localObject = (WeakReference)sContextStack.peek();
          if ((localObject != null) && (((WeakReference)localObject).get() == paramContext))
          {
            ab.d("KindaContext", "popToContext pop and break");
            AppMethodBeat.o(145206);
            return;
          }
          sContextStack.pop();
          ab.d("KindaContext", "popToContext pop context：" + paramContext.getClass().getCanonicalName());
        } while (sContextStack.size() > 0);
      }
      AppMethodBeat.o(145206);
      return;
    }
  }
  
  private static String printContextStack()
  {
    AppMethodBeat.i(145204);
    Object localObject = new StringBuilder();
    Iterator localIterator = sContextStack.iterator();
    while (localIterator.hasNext())
    {
      Context localContext = (Context)((WeakReference)localIterator.next()).get();
      if (localContext != null)
      {
        ((StringBuilder)localObject).append(localContext.getClass().getCanonicalName());
        ((StringBuilder)localObject).append("\n");
      }
      else
      {
        ((StringBuilder)localObject).append("null");
        ((StringBuilder)localObject).append("\n");
      }
    }
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(145204);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.tools.KindaContext
 * JD-Core Version:    0.7.0.1
 */