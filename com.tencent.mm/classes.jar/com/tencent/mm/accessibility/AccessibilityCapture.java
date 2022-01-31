package com.tencent.mm.accessibility;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public final class AccessibilityCapture
{
  public static final long EVENT_MIN_INTERVAL = 1000L;
  private static final String INTERFACE_IACCESSIBILITYMANAGER = "android.view.accessibility.IAccessibilityManager";
  private static final String INTERFACE_IACCESSIBILITYMANAGERCLIENT = "android.view.accessibility.IAccessibilityManagerClient";
  private static final int STATE_FLAG_ACCESSIBILITY_ENABLED = 1;
  private static final String TAG = "MicroMsg.AccessibilityCapture";
  private static Field enableField;
  private static AccessibilityCapture.IAccessibilityManagerInvocationHandler iAccessibilityManagerInvocationHandler = null;
  private static Field idField;
  private static long lastEventTime;
  private static int lastEventType;
  private static AccessibilityCapture.APIProvider mAPIProvider;
  private static boolean mEnable = false;
  private static boolean mForwardEnable;
  private static AccessibilityManager mManager;
  private static Class<AccessibilityManager> managerClass;
  
  static
  {
    lastEventTime = 0L;
    lastEventType = 0;
    managerClass = AccessibilityManager.class;
  }
  
  private AccessibilityCapture()
  {
    AppMethodBeat.i(118630);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("You should instantiate this class");
    AppMethodBeat.o(118630);
    throw localUnsupportedOperationException;
  }
  
  @TargetApi(16)
  public static void disableAccessibilityCapture(Context paramContext)
  {
    AppMethodBeat.i(118634);
    try
    {
      mAPIProvider.d("MicroMsg.AccessibilityCapture", "accessibility set up start time: %d", new Object[] { Long.valueOf(SystemClock.elapsedRealtime()) });
      Field localField1 = AccessibilityManager.class.getDeclaredField("mService");
      localField1.setAccessible(true);
      Object localObject1 = AccessibilityManager.class.getDeclaredField("sInstance");
      ((Field)localObject1).setAccessible(true);
      Field localField2 = AccessibilityManager.class.getDeclaredField("mLock");
      localField2.setAccessible(true);
      Object localObject3 = (AccessibilityManager)((Field)localObject1).get(null);
      localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = (AccessibilityManager)AccessibilityManager.class.getDeclaredMethod("getInstance", new Class[] { Context.class }).invoke(null, new Object[] { paramContext.getApplicationContext() });
      }
      paramContext = localField2.get(mManager);
      localObject3 = AccessibilityManager.class.getDeclaredField("mIsEnabled");
      ((Field)localObject3).setAccessible(true);
      if (paramContext == null)
      {
        mAPIProvider.i("MicroMsg.AccessibilityCapture", "need to set disable,mLock is null.", new Object[0]);
        ((Field)localObject3).set(localObject1, Boolean.FALSE);
        if (iAccessibilityManagerInvocationHandler != null) {
          localField1.set(localObject1, iAccessibilityManagerInvocationHandler.getOriginalInstance());
        }
      }
      for (;;)
      {
        mEnable = false;
        mAPIProvider.d("MicroMsg.AccessibilityCapture", "accessibility set up end time: %d", new Object[] { Long.valueOf(SystemClock.elapsedRealtime()) });
        mAPIProvider.i("MicroMsg.AccessibilityCapture", "accessibility disabled", new Object[0]);
        AppMethodBeat.o(118634);
        return;
        mAPIProvider.i("MicroMsg.AccessibilityCapture", "need to set disable,mLock is not null.", new Object[0]);
        try
        {
          ((Field)localObject3).set(localObject1, Boolean.FALSE);
          if (iAccessibilityManagerInvocationHandler != null) {
            localField1.set(localObject1, iAccessibilityManagerInvocationHandler.getOriginalInstance());
          }
        }
        finally
        {
          AppMethodBeat.o(118634);
        }
      }
      return;
    }
    catch (Throwable paramContext)
    {
      mAPIProvider.printErrStackTrace("MicroMsg.AccessibilityCapture", paramContext, "failed to disable accessibility", new Object[0]);
      AppMethodBeat.o(118634);
    }
  }
  
  @TargetApi(16)
  public static void enableAccessibilityCapture(Context paramContext, AccessibilityCapture.APIProvider paramAPIProvider)
  {
    AppMethodBeat.i(118632);
    try
    {
      mAPIProvider = paramAPIProvider;
      paramAPIProvider.d("MicroMsg.AccessibilityCapture", "accessibility set up start time: %d", new Object[] { Long.valueOf(SystemClock.elapsedRealtime()) });
      if (idField == null)
      {
        paramAPIProvider = View.class.getDeclaredField("mAccessibilityViewId");
        idField = paramAPIProvider;
        paramAPIProvider.setAccessible(true);
      }
      Object localObject = AccessibilityManager.class.getDeclaredField("sInstance");
      ((Field)localObject).setAccessible(true);
      paramAPIProvider = AccessibilityManager.class.getDeclaredField("mLock");
      paramAPIProvider.setAccessible(true);
      localObject = (AccessibilityManager)((Field)localObject).get(null);
      mManager = (AccessibilityManager)localObject;
      if (localObject == null) {
        mManager = (AccessibilityManager)AccessibilityManager.class.getDeclaredMethod("getInstance", new Class[] { Context.class }).invoke(null, new Object[] { paramContext.getApplicationContext() });
      }
      paramContext = paramAPIProvider.get(mManager);
      if (paramContext == null)
      {
        mAPIProvider.i("MicroMsg.AccessibilityCapture", "need to set enable,mLock is null.", new Object[0]);
        setAccessibilityEnable();
      }
      for (;;)
      {
        mAPIProvider.d("MicroMsg.AccessibilityCapture", "accessibility set up end time: %d", new Object[] { Long.valueOf(SystemClock.elapsedRealtime()) });
        mAPIProvider.i("MicroMsg.AccessibilityCapture", "accessibility enabled", new Object[0]);
        AppMethodBeat.o(118632);
        return;
        mAPIProvider.i("MicroMsg.AccessibilityCapture", "need to set enable,mLock is not null.", new Object[0]);
        try
        {
          setAccessibilityEnable();
        }
        finally
        {
          AppMethodBeat.o(118632);
        }
      }
      return;
    }
    catch (Throwable paramContext)
    {
      mAPIProvider.printErrStackTrace("MicroMsg.AccessibilityCapture", paramContext, "failed to enable accessibility", new Object[0]);
      AppMethodBeat.o(118632);
    }
  }
  
  private static boolean filter(AccessibilityEvent paramAccessibilityEvent)
  {
    int i = 1;
    AppMethodBeat.i(118636);
    int j = paramAccessibilityEvent.getEventType();
    boolean bool1;
    boolean bool2;
    if ((j == 1) || (j == 2) || (j == 4096) || (j == 4) || (j == 8192))
    {
      bool1 = true;
      bool2 = bool1;
      if (Build.VERSION.SDK_INT >= 23) {
        if (j != 8388608) {
          break label79;
        }
      }
    }
    for (;;)
    {
      bool2 = bool1 | i;
      AppMethodBeat.o(118636);
      return bool2;
      bool1 = false;
      break;
      label79:
      i = 0;
    }
  }
  
  private static boolean filterEventMerged(AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(118637);
    if ((paramAccessibilityEvent.getEventTime() - lastEventTime < 1000L) && (paramAccessibilityEvent.getEventType() == 4096))
    {
      AppMethodBeat.o(118637);
      return false;
    }
    if ((lastEventType == 8192) && (paramAccessibilityEvent.getEventType() == 8192))
    {
      AppMethodBeat.o(118637);
      return false;
    }
    lastEventTime = paramAccessibilityEvent.getEventTime();
    lastEventType = paramAccessibilityEvent.getEventType();
    AppMethodBeat.o(118637);
    return true;
  }
  
  public static boolean isEnable()
  {
    return mEnable;
  }
  
  private static void logTarget(AccessibilityEvent paramAccessibilityEvent, View paramView, long paramLong)
  {
    AppMethodBeat.i(118638);
    Activity localActivity = Util.getActivityOfView(paramView);
    AccessibilityCapture.APIProvider localAPIProvider = mAPIProvider;
    String str2 = AccessibilityEvent.eventTypeToString(paramAccessibilityEvent.getEventType());
    String str3 = Util.getViewIdName(paramView).trim();
    if (localActivity == null) {}
    for (String str1 = "unknown";; str1 = localActivity.getClass().getName())
    {
      localAPIProvider.i("MicroMsg.AccessibilityCapture", "Event: %s, View's id: %s, Activity: %s, Time: %s", new Object[] { str2, str3, str1, Long.valueOf(paramAccessibilityEvent.getEventTime()) });
      mAPIProvider.onEvent(new AccessibilityCapture.Event(paramAccessibilityEvent, paramView, localActivity, paramLong));
      AppMethodBeat.o(118638);
      return;
    }
  }
  
  private static void notifyListeners(boolean paramBoolean)
  {
    AppMethodBeat.i(118633);
    try
    {
      Object localObject = AccessibilityManager.class.getDeclaredField("mAccessibilityStateChangeListeners");
      ((Field)localObject).setAccessible(true);
      localObject = ((CopyOnWriteArrayList)((Field)localObject).get(mManager)).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((AccessibilityManager.AccessibilityStateChangeListener)((Iterator)localObject).next()).onAccessibilityStateChanged(paramBoolean);
      }
      AppMethodBeat.o(118633);
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(118633);
      return;
    }
  }
  
  private static void post(AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(118635);
    long l = SystemClock.elapsedRealtime();
    mAPIProvider.d("MicroMsg.AccessibilityCapture", "[oneliang]before post event:event time" + paramAccessibilityEvent.getEventTime() + ",elspsed time:" + l, new Object[0]);
    mAPIProvider.post(new AccessibilityCapture.ViewSearchTask(paramAccessibilityEvent, l), "AccessibilityCapture search event's view");
    AppMethodBeat.o(118635);
  }
  
  /* Error */
  private static void setAccessibilityEnable()
  {
    // Byte code:
    //   0: ldc_w 352
    //   3: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: getstatic 354	com/tencent/mm/accessibility/AccessibilityCapture:enableField	Ljava/lang/reflect/Field;
    //   9: ifnonnull +21 -> 30
    //   12: getstatic 61	com/tencent/mm/accessibility/AccessibilityCapture:managerClass	Ljava/lang/Class;
    //   15: ldc 194
    //   17: invokevirtual 158	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   20: astore_1
    //   21: aload_1
    //   22: putstatic 354	com/tencent/mm/accessibility/AccessibilityCapture:enableField	Ljava/lang/reflect/Field;
    //   25: aload_1
    //   26: iconst_1
    //   27: invokevirtual 164	java/lang/reflect/Field:setAccessible	(Z)V
    //   30: getstatic 354	com/tencent/mm/accessibility/AccessibilityCapture:enableField	Ljava/lang/reflect/Field;
    //   33: getstatic 192	com/tencent/mm/accessibility/AccessibilityCapture:mManager	Landroid/view/accessibility/AccessibilityManager;
    //   36: getstatic 357	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   39: invokevirtual 208	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   42: getstatic 61	com/tencent/mm/accessibility/AccessibilityCapture:managerClass	Ljava/lang/Class;
    //   45: ldc 152
    //   47: invokevirtual 158	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   50: astore_3
    //   51: aload_3
    //   52: iconst_1
    //   53: invokevirtual 164	java/lang/reflect/Field:setAccessible	(Z)V
    //   56: new 13	com/tencent/mm/accessibility/AccessibilityCapture$IAccessibilityManagerInvocationHandler
    //   59: dup
    //   60: aload_3
    //   61: getstatic 192	com/tencent/mm/accessibility/AccessibilityCapture:mManager	Landroid/view/accessibility/AccessibilityManager;
    //   64: invokevirtual 172	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   67: aconst_null
    //   68: invokespecial 360	com/tencent/mm/accessibility/AccessibilityCapture$IAccessibilityManagerInvocationHandler:<init>	(Ljava/lang/Object;Lcom/tencent/mm/accessibility/AccessibilityCapture$1;)V
    //   71: putstatic 63	com/tencent/mm/accessibility/AccessibilityCapture:iAccessibilityManagerInvocationHandler	Lcom/tencent/mm/accessibility/AccessibilityCapture$IAccessibilityManagerInvocationHandler;
    //   74: ldc 23
    //   76: invokestatic 364	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   79: astore_1
    //   80: ldc 2
    //   82: invokevirtual 368	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   85: astore_2
    //   86: getstatic 63	com/tencent/mm/accessibility/AccessibilityCapture:iAccessibilityManagerInvocationHandler	Lcom/tencent/mm/accessibility/AccessibilityCapture$IAccessibilityManagerInvocationHandler;
    //   89: astore 4
    //   91: aload_2
    //   92: iconst_1
    //   93: anewarray 154	java/lang/Class
    //   96: dup
    //   97: iconst_0
    //   98: aload_1
    //   99: aastore
    //   100: aload 4
    //   102: invokestatic 374	java/lang/reflect/Proxy:newProxyInstance	(Ljava/lang/ClassLoader;[Ljava/lang/Class;Ljava/lang/reflect/InvocationHandler;)Ljava/lang/Object;
    //   105: astore_2
    //   106: aload_3
    //   107: getstatic 192	com/tencent/mm/accessibility/AccessibilityCapture:mManager	Landroid/view/accessibility/AccessibilityManager;
    //   110: aload_2
    //   111: invokevirtual 208	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   114: iconst_1
    //   115: putstatic 53	com/tencent/mm/accessibility/AccessibilityCapture:mEnable	Z
    //   118: ldc 26
    //   120: invokestatic 364	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   123: astore_3
    //   124: getstatic 255	android/os/Build$VERSION:SDK_INT	I
    //   127: bipush 17
    //   129: if_icmple +217 -> 346
    //   132: getstatic 61	com/tencent/mm/accessibility/AccessibilityCapture:managerClass	Ljava/lang/Class;
    //   135: ldc_w 376
    //   138: invokevirtual 158	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   141: astore 4
    //   143: aload 4
    //   145: iconst_1
    //   146: invokevirtual 164	java/lang/reflect/Field:setAccessible	(Z)V
    //   149: aload 4
    //   151: getstatic 192	com/tencent/mm/accessibility/AccessibilityCapture:mManager	Landroid/view/accessibility/AccessibilityManager;
    //   154: invokevirtual 172	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   157: checkcast 378	java/lang/Integer
    //   160: invokevirtual 381	java/lang/Integer:intValue	()I
    //   163: istore_0
    //   164: new 10	com/tencent/mm/accessibility/AccessibilityCapture$IAccessibilityManagerClientInvocationHandler
    //   167: dup
    //   168: aconst_null
    //   169: invokespecial 384	com/tencent/mm/accessibility/AccessibilityCapture$IAccessibilityManagerClientInvocationHandler:<init>	(Lcom/tencent/mm/accessibility/AccessibilityCapture$1;)V
    //   172: astore 4
    //   174: ldc 2
    //   176: invokevirtual 368	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   179: iconst_1
    //   180: anewarray 154	java/lang/Class
    //   183: dup
    //   184: iconst_0
    //   185: aload_3
    //   186: aastore
    //   187: aload 4
    //   189: invokestatic 374	java/lang/reflect/Proxy:newProxyInstance	(Ljava/lang/ClassLoader;[Ljava/lang/Class;Ljava/lang/reflect/InvocationHandler;)Ljava/lang/Object;
    //   192: astore 4
    //   194: aload_1
    //   195: ldc_w 386
    //   198: iconst_2
    //   199: anewarray 154	java/lang/Class
    //   202: dup
    //   203: iconst_0
    //   204: aload_3
    //   205: aastore
    //   206: dup
    //   207: iconst_1
    //   208: getstatic 389	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   211: aastore
    //   212: invokevirtual 392	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   215: aload_2
    //   216: iconst_2
    //   217: anewarray 4	java/lang/Object
    //   220: dup
    //   221: iconst_0
    //   222: aload 4
    //   224: aastore
    //   225: dup
    //   226: iconst_1
    //   227: iload_0
    //   228: invokestatic 395	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   231: aastore
    //   232: invokevirtual 190	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   235: astore_1
    //   236: aload_1
    //   237: ifnull +46 -> 283
    //   240: aload_1
    //   241: instanceof 378
    //   244: ifeq +39 -> 283
    //   247: aload_1
    //   248: checkcast 378	java/lang/Integer
    //   251: invokevirtual 381	java/lang/Integer:intValue	()I
    //   254: istore_0
    //   255: getstatic 109	com/tencent/mm/accessibility/AccessibilityCapture:mAPIProvider	Lcom/tencent/mm/accessibility/AccessibilityCapture$APIProvider;
    //   258: ldc 32
    //   260: ldc_w 397
    //   263: iconst_1
    //   264: anewarray 4	java/lang/Object
    //   267: dup
    //   268: iconst_0
    //   269: iload_0
    //   270: invokestatic 395	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   273: aastore
    //   274: invokeinterface 198 4 0
    //   279: iload_0
    //   280: invokestatic 114	com/tencent/mm/accessibility/AccessibilityCapture:updateState	(I)V
    //   283: ldc_w 352
    //   286: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   289: return
    //   290: astore_1
    //   291: getstatic 109	com/tencent/mm/accessibility/AccessibilityCapture:mAPIProvider	Lcom/tencent/mm/accessibility/AccessibilityCapture$APIProvider;
    //   294: ldc 32
    //   296: ldc_w 399
    //   299: iconst_1
    //   300: anewarray 4	java/lang/Object
    //   303: dup
    //   304: iconst_0
    //   305: aload_1
    //   306: aastore
    //   307: invokeinterface 402 4 0
    //   312: getstatic 88	com/tencent/mm/accessibility/AccessibilityCapture:mForwardEnable	Z
    //   315: ifne +15 -> 330
    //   318: getstatic 354	com/tencent/mm/accessibility/AccessibilityCapture:enableField	Ljava/lang/reflect/Field;
    //   321: getstatic 192	com/tencent/mm/accessibility/AccessibilityCapture:mManager	Landroid/view/accessibility/AccessibilityManager;
    //   324: getstatic 204	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   327: invokevirtual 208	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   330: new 404	com/tencent/mm/accessibility/AccessibilityCaptureNotSupportException
    //   333: dup
    //   334: invokespecial 405	com/tencent/mm/accessibility/AccessibilityCaptureNotSupportException:<init>	()V
    //   337: astore_1
    //   338: ldc_w 352
    //   341: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   344: aload_1
    //   345: athrow
    //   346: new 10	com/tencent/mm/accessibility/AccessibilityCapture$IAccessibilityManagerClientInvocationHandler
    //   349: dup
    //   350: aconst_null
    //   351: invokespecial 384	com/tencent/mm/accessibility/AccessibilityCapture$IAccessibilityManagerClientInvocationHandler:<init>	(Lcom/tencent/mm/accessibility/AccessibilityCapture$1;)V
    //   354: astore 4
    //   356: ldc 2
    //   358: invokevirtual 368	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   361: iconst_1
    //   362: anewarray 154	java/lang/Class
    //   365: dup
    //   366: iconst_0
    //   367: aload_3
    //   368: aastore
    //   369: aload 4
    //   371: invokestatic 374	java/lang/reflect/Proxy:newProxyInstance	(Ljava/lang/ClassLoader;[Ljava/lang/Class;Ljava/lang/reflect/InvocationHandler;)Ljava/lang/Object;
    //   374: astore 4
    //   376: aload_1
    //   377: ldc_w 386
    //   380: iconst_2
    //   381: anewarray 154	java/lang/Class
    //   384: dup
    //   385: iconst_0
    //   386: aload_3
    //   387: aastore
    //   388: dup
    //   389: iconst_1
    //   390: getstatic 389	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   393: aastore
    //   394: invokevirtual 392	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   397: aload_2
    //   398: iconst_1
    //   399: anewarray 4	java/lang/Object
    //   402: dup
    //   403: iconst_0
    //   404: aload 4
    //   406: aastore
    //   407: invokevirtual 190	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   410: astore_1
    //   411: aload_1
    //   412: ifnull +46 -> 458
    //   415: aload_1
    //   416: instanceof 378
    //   419: ifeq +39 -> 458
    //   422: aload_1
    //   423: checkcast 378	java/lang/Integer
    //   426: invokevirtual 381	java/lang/Integer:intValue	()I
    //   429: istore_0
    //   430: getstatic 109	com/tencent/mm/accessibility/AccessibilityCapture:mAPIProvider	Lcom/tencent/mm/accessibility/AccessibilityCapture$APIProvider;
    //   433: ldc 32
    //   435: ldc_w 407
    //   438: iconst_1
    //   439: anewarray 4	java/lang/Object
    //   442: dup
    //   443: iconst_0
    //   444: iload_0
    //   445: invokestatic 395	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   448: aastore
    //   449: invokeinterface 198 4 0
    //   454: iload_0
    //   455: invokestatic 114	com/tencent/mm/accessibility/AccessibilityCapture:updateState	(I)V
    //   458: ldc_w 352
    //   461: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   464: return
    //   465: astore_1
    //   466: getstatic 109	com/tencent/mm/accessibility/AccessibilityCapture:mAPIProvider	Lcom/tencent/mm/accessibility/AccessibilityCapture$APIProvider;
    //   469: ldc 32
    //   471: aload_1
    //   472: new 326	java/lang/StringBuilder
    //   475: dup
    //   476: ldc_w 409
    //   479: invokespecial 329	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   482: aload_1
    //   483: invokevirtual 412	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   486: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: invokevirtual 341	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   492: iconst_0
    //   493: anewarray 4	java/lang/Object
    //   496: invokeinterface 224 5 0
    //   501: iconst_1
    //   502: putstatic 88	com/tencent/mm/accessibility/AccessibilityCapture:mForwardEnable	Z
    //   505: ldc_w 352
    //   508: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   511: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   163	292	0	i	int
    //   20	228	1	localObject1	Object
    //   290	16	1	localException	java.lang.Exception
    //   337	86	1	localObject2	Object
    //   465	18	1	localThrowable	Throwable
    //   85	313	2	localObject3	Object
    //   50	337	3	localObject4	Object
    //   89	316	4	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   106	114	290	java/lang/Exception
    //   118	236	465	java/lang/Throwable
    //   240	283	465	java/lang/Throwable
    //   283	289	465	java/lang/Throwable
    //   346	411	465	java/lang/Throwable
    //   415	458	465	java/lang/Throwable
  }
  
  private static void updateState(int paramInt)
  {
    AppMethodBeat.i(118639);
    if ((paramInt & 0x1) != 0) {}
    for (paramInt = 1; paramInt != 0; paramInt = 0)
    {
      notifyListeners(true);
      mForwardEnable = true;
      AppMethodBeat.o(118639);
      return;
    }
    mForwardEnable = false;
    AppMethodBeat.o(118639);
  }
  
  static class IAccessibilityManagerClientInvocationHandler
    implements InvocationHandler
  {
    public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(118624);
      paramObject = paramMethod.getName();
      paramMethod = paramMethod.getParameterTypes();
      if ((paramObject.equals("setState")) && (paramMethod.length == 1) && (paramMethod[0].equals(Integer.TYPE)))
      {
        paramObject = paramArrayOfObject[0];
        if ((paramObject == null) || (!(paramObject instanceof Integer)))
        {
          AppMethodBeat.o(118624);
          return null;
        }
        int i = ((Integer)paramObject).intValue();
        AccessibilityCapture.mAPIProvider.i("MicroMsg.AccessibilityCapture", "setState %d", new Object[] { Integer.valueOf(i) });
        AccessibilityCapture.access$700(i);
      }
      AppMethodBeat.o(118624);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.accessibility.AccessibilityCapture
 * JD-Core Version:    0.7.0.1
 */