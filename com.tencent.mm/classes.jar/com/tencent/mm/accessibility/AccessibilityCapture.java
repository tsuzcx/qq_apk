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
import java.lang.reflect.Field;
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
    throw new UnsupportedOperationException("You should instantiate this class");
  }
  
  @TargetApi(16)
  public static void disableAccessibilityCapture(Context paramContext)
  {
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
        ((Field)localObject3).set(localObject1, Boolean.valueOf(false));
        if (iAccessibilityManagerInvocationHandler != null) {
          localField1.set(localObject1, iAccessibilityManagerInvocationHandler.getOriginalInstance());
        }
      }
      for (;;)
      {
        mEnable = false;
        mAPIProvider.d("MicroMsg.AccessibilityCapture", "accessibility set up end time: %d", new Object[] { Long.valueOf(SystemClock.elapsedRealtime()) });
        mAPIProvider.i("MicroMsg.AccessibilityCapture", "accessibility disabled", new Object[0]);
        return;
        mAPIProvider.i("MicroMsg.AccessibilityCapture", "need to set disable,mLock is not null.", new Object[0]);
        try
        {
          ((Field)localObject3).set(localObject1, Boolean.valueOf(false));
          if (iAccessibilityManagerInvocationHandler != null) {
            localField1.set(localObject1, iAccessibilityManagerInvocationHandler.getOriginalInstance());
          }
        }
        finally {}
      }
      return;
    }
    catch (Throwable paramContext)
    {
      mAPIProvider.printErrStackTrace("MicroMsg.AccessibilityCapture", paramContext, "failed to disable accessibility", new Object[0]);
    }
  }
  
  @TargetApi(16)
  public static void enableAccessibilityCapture(Context paramContext, AccessibilityCapture.APIProvider paramAPIProvider)
  {
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
        return;
        mAPIProvider.i("MicroMsg.AccessibilityCapture", "need to set enable,mLock is not null.", new Object[0]);
        try
        {
          setAccessibilityEnable();
        }
        finally {}
      }
      return;
    }
    catch (Throwable paramContext)
    {
      mAPIProvider.printErrStackTrace("MicroMsg.AccessibilityCapture", paramContext, "failed to enable accessibility", new Object[0]);
    }
  }
  
  private static boolean filter(AccessibilityEvent paramAccessibilityEvent)
  {
    int i = 1;
    int j = paramAccessibilityEvent.getEventType();
    boolean bool1;
    boolean bool2;
    if ((j == 1) || (j == 2) || (j == 4096) || (j == 4) || (j == 8192))
    {
      bool1 = true;
      bool2 = bool1;
      if (Build.VERSION.SDK_INT >= 23) {
        if (j != 8388608) {
          break label68;
        }
      }
    }
    for (;;)
    {
      bool2 = bool1 | i;
      return bool2;
      bool1 = false;
      break;
      label68:
      i = 0;
    }
  }
  
  private static boolean filterEventMerged(AccessibilityEvent paramAccessibilityEvent)
  {
    if ((paramAccessibilityEvent.getEventTime() - lastEventTime < 1000L) && (paramAccessibilityEvent.getEventType() == 4096)) {}
    while ((lastEventType == 8192) && (paramAccessibilityEvent.getEventType() == 8192)) {
      return false;
    }
    lastEventTime = paramAccessibilityEvent.getEventTime();
    lastEventType = paramAccessibilityEvent.getEventType();
    return true;
  }
  
  public static boolean isEnable()
  {
    return mEnable;
  }
  
  private static void logTarget(AccessibilityEvent paramAccessibilityEvent, View paramView, long paramLong)
  {
    Activity localActivity = Util.getActivityOfView(paramView);
    AccessibilityCapture.APIProvider localAPIProvider = mAPIProvider;
    String str2 = AccessibilityEvent.eventTypeToString(paramAccessibilityEvent.getEventType());
    String str3 = Util.getViewIdName(paramView).trim();
    if (localActivity == null) {}
    for (String str1 = "unknown";; str1 = localActivity.getClass().getName())
    {
      localAPIProvider.i("MicroMsg.AccessibilityCapture", "Event: %s, View's id: %s, Activity: %s, Time: %s", new Object[] { str2, str3, str1, Long.valueOf(paramAccessibilityEvent.getEventTime()) });
      mAPIProvider.onEvent(new AccessibilityCapture.Event(paramAccessibilityEvent, paramView, localActivity, paramLong));
      return;
    }
  }
  
  private static void notifyListeners(boolean paramBoolean)
  {
    try
    {
      Object localObject = AccessibilityManager.class.getDeclaredField("mAccessibilityStateChangeListeners");
      ((Field)localObject).setAccessible(true);
      localObject = ((CopyOnWriteArrayList)((Field)localObject).get(mManager)).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((AccessibilityManager.AccessibilityStateChangeListener)((Iterator)localObject).next()).onAccessibilityStateChanged(paramBoolean);
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  private static void post(AccessibilityEvent paramAccessibilityEvent)
  {
    long l = SystemClock.elapsedRealtime();
    mAPIProvider.d("MicroMsg.AccessibilityCapture", "[oneliang]before post event:event time" + paramAccessibilityEvent.getEventTime() + ",elspsed time:" + l, new Object[0]);
    mAPIProvider.post(new AccessibilityCapture.ViewSearchTask(paramAccessibilityEvent, l), "AccessibilityCapture search event's view");
  }
  
  /* Error */
  private static void setAccessibilityEnable()
  {
    // Byte code:
    //   0: getstatic 331	com/tencent/mm/accessibility/AccessibilityCapture:enableField	Ljava/lang/reflect/Field;
    //   3: ifnonnull +21 -> 24
    //   6: getstatic 60	com/tencent/mm/accessibility/AccessibilityCapture:managerClass	Ljava/lang/Class;
    //   9: ldc 178
    //   11: invokevirtual 142	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   14: astore_1
    //   15: aload_1
    //   16: putstatic 331	com/tencent/mm/accessibility/AccessibilityCapture:enableField	Ljava/lang/reflect/Field;
    //   19: aload_1
    //   20: iconst_1
    //   21: invokevirtual 148	java/lang/reflect/Field:setAccessible	(Z)V
    //   24: getstatic 331	com/tencent/mm/accessibility/AccessibilityCapture:enableField	Ljava/lang/reflect/Field;
    //   27: getstatic 176	com/tencent/mm/accessibility/AccessibilityCapture:mManager	Landroid/view/accessibility/AccessibilityManager;
    //   30: iconst_1
    //   31: invokestatic 188	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   34: invokevirtual 192	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   37: getstatic 60	com/tencent/mm/accessibility/AccessibilityCapture:managerClass	Ljava/lang/Class;
    //   40: ldc 136
    //   42: invokevirtual 142	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   45: astore_3
    //   46: aload_3
    //   47: iconst_1
    //   48: invokevirtual 148	java/lang/reflect/Field:setAccessible	(Z)V
    //   51: new 12	com/tencent/mm/accessibility/AccessibilityCapture$IAccessibilityManagerInvocationHandler
    //   54: dup
    //   55: aload_3
    //   56: getstatic 176	com/tencent/mm/accessibility/AccessibilityCapture:mManager	Landroid/view/accessibility/AccessibilityManager;
    //   59: invokevirtual 156	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   62: aconst_null
    //   63: invokespecial 334	com/tencent/mm/accessibility/AccessibilityCapture$IAccessibilityManagerInvocationHandler:<init>	(Ljava/lang/Object;Lcom/tencent/mm/accessibility/AccessibilityCapture$1;)V
    //   66: putstatic 62	com/tencent/mm/accessibility/AccessibilityCapture:iAccessibilityManagerInvocationHandler	Lcom/tencent/mm/accessibility/AccessibilityCapture$IAccessibilityManagerInvocationHandler;
    //   69: ldc 22
    //   71: invokestatic 338	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   74: astore_1
    //   75: ldc 2
    //   77: invokevirtual 342	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   80: astore_2
    //   81: getstatic 62	com/tencent/mm/accessibility/AccessibilityCapture:iAccessibilityManagerInvocationHandler	Lcom/tencent/mm/accessibility/AccessibilityCapture$IAccessibilityManagerInvocationHandler;
    //   84: astore 4
    //   86: aload_2
    //   87: iconst_1
    //   88: anewarray 138	java/lang/Class
    //   91: dup
    //   92: iconst_0
    //   93: aload_1
    //   94: aastore
    //   95: aload 4
    //   97: invokestatic 348	java/lang/reflect/Proxy:newProxyInstance	(Ljava/lang/ClassLoader;[Ljava/lang/Class;Ljava/lang/reflect/InvocationHandler;)Ljava/lang/Object;
    //   100: astore_2
    //   101: aload_3
    //   102: getstatic 176	com/tencent/mm/accessibility/AccessibilityCapture:mManager	Landroid/view/accessibility/AccessibilityManager;
    //   105: aload_2
    //   106: invokevirtual 192	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   109: iconst_1
    //   110: putstatic 52	com/tencent/mm/accessibility/AccessibilityCapture:mEnable	Z
    //   113: ldc 25
    //   115: invokestatic 338	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   118: astore_3
    //   119: getstatic 237	android/os/Build$VERSION:SDK_INT	I
    //   122: bipush 17
    //   124: if_icmple +204 -> 328
    //   127: getstatic 60	com/tencent/mm/accessibility/AccessibilityCapture:managerClass	Ljava/lang/Class;
    //   130: ldc_w 350
    //   133: invokevirtual 142	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   136: astore 4
    //   138: aload 4
    //   140: iconst_1
    //   141: invokevirtual 148	java/lang/reflect/Field:setAccessible	(Z)V
    //   144: aload 4
    //   146: getstatic 176	com/tencent/mm/accessibility/AccessibilityCapture:mManager	Landroid/view/accessibility/AccessibilityManager;
    //   149: invokevirtual 156	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   152: checkcast 352	java/lang/Integer
    //   155: invokevirtual 355	java/lang/Integer:intValue	()I
    //   158: istore_0
    //   159: new 10	com/tencent/mm/accessibility/AccessibilityCapture$IAccessibilityManagerClientInvocationHandler
    //   162: dup
    //   163: aconst_null
    //   164: invokespecial 358	com/tencent/mm/accessibility/AccessibilityCapture$IAccessibilityManagerClientInvocationHandler:<init>	(Lcom/tencent/mm/accessibility/AccessibilityCapture$1;)V
    //   167: astore 4
    //   169: ldc 2
    //   171: invokevirtual 342	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   174: iconst_1
    //   175: anewarray 138	java/lang/Class
    //   178: dup
    //   179: iconst_0
    //   180: aload_3
    //   181: aastore
    //   182: aload 4
    //   184: invokestatic 348	java/lang/reflect/Proxy:newProxyInstance	(Ljava/lang/ClassLoader;[Ljava/lang/Class;Ljava/lang/reflect/InvocationHandler;)Ljava/lang/Object;
    //   187: astore 4
    //   189: aload_1
    //   190: ldc_w 360
    //   193: iconst_2
    //   194: anewarray 138	java/lang/Class
    //   197: dup
    //   198: iconst_0
    //   199: aload_3
    //   200: aastore
    //   201: dup
    //   202: iconst_1
    //   203: getstatic 363	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   206: aastore
    //   207: invokevirtual 366	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   210: aload_2
    //   211: iconst_2
    //   212: anewarray 4	java/lang/Object
    //   215: dup
    //   216: iconst_0
    //   217: aload 4
    //   219: aastore
    //   220: dup
    //   221: iconst_1
    //   222: iload_0
    //   223: invokestatic 369	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   226: aastore
    //   227: invokevirtual 174	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   230: astore_1
    //   231: aload_1
    //   232: ifnull +46 -> 278
    //   235: aload_1
    //   236: instanceof 352
    //   239: ifeq +39 -> 278
    //   242: aload_1
    //   243: checkcast 352	java/lang/Integer
    //   246: invokevirtual 355	java/lang/Integer:intValue	()I
    //   249: istore_0
    //   250: getstatic 95	com/tencent/mm/accessibility/AccessibilityCapture:mAPIProvider	Lcom/tencent/mm/accessibility/AccessibilityCapture$APIProvider;
    //   253: ldc 31
    //   255: ldc_w 371
    //   258: iconst_1
    //   259: anewarray 4	java/lang/Object
    //   262: dup
    //   263: iconst_0
    //   264: iload_0
    //   265: invokestatic 369	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   268: aastore
    //   269: invokeinterface 183 4 0
    //   274: iload_0
    //   275: invokestatic 100	com/tencent/mm/accessibility/AccessibilityCapture:updateState	(I)V
    //   278: return
    //   279: astore_1
    //   280: getstatic 95	com/tencent/mm/accessibility/AccessibilityCapture:mAPIProvider	Lcom/tencent/mm/accessibility/AccessibilityCapture$APIProvider;
    //   283: ldc 31
    //   285: ldc_w 373
    //   288: iconst_1
    //   289: anewarray 4	java/lang/Object
    //   292: dup
    //   293: iconst_0
    //   294: aload_1
    //   295: aastore
    //   296: invokeinterface 376 4 0
    //   301: getstatic 77	com/tencent/mm/accessibility/AccessibilityCapture:mForwardEnable	Z
    //   304: ifne +16 -> 320
    //   307: getstatic 331	com/tencent/mm/accessibility/AccessibilityCapture:enableField	Ljava/lang/reflect/Field;
    //   310: getstatic 176	com/tencent/mm/accessibility/AccessibilityCapture:mManager	Landroid/view/accessibility/AccessibilityManager;
    //   313: iconst_0
    //   314: invokestatic 188	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   317: invokevirtual 192	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   320: new 378	com/tencent/mm/accessibility/AccessibilityCaptureNotSupportException
    //   323: dup
    //   324: invokespecial 379	com/tencent/mm/accessibility/AccessibilityCaptureNotSupportException:<init>	()V
    //   327: athrow
    //   328: new 10	com/tencent/mm/accessibility/AccessibilityCapture$IAccessibilityManagerClientInvocationHandler
    //   331: dup
    //   332: aconst_null
    //   333: invokespecial 358	com/tencent/mm/accessibility/AccessibilityCapture$IAccessibilityManagerClientInvocationHandler:<init>	(Lcom/tencent/mm/accessibility/AccessibilityCapture$1;)V
    //   336: astore 4
    //   338: ldc 2
    //   340: invokevirtual 342	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   343: iconst_1
    //   344: anewarray 138	java/lang/Class
    //   347: dup
    //   348: iconst_0
    //   349: aload_3
    //   350: aastore
    //   351: aload 4
    //   353: invokestatic 348	java/lang/reflect/Proxy:newProxyInstance	(Ljava/lang/ClassLoader;[Ljava/lang/Class;Ljava/lang/reflect/InvocationHandler;)Ljava/lang/Object;
    //   356: astore 4
    //   358: aload_1
    //   359: ldc_w 360
    //   362: iconst_2
    //   363: anewarray 138	java/lang/Class
    //   366: dup
    //   367: iconst_0
    //   368: aload_3
    //   369: aastore
    //   370: dup
    //   371: iconst_1
    //   372: getstatic 363	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   375: aastore
    //   376: invokevirtual 366	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   379: aload_2
    //   380: iconst_1
    //   381: anewarray 4	java/lang/Object
    //   384: dup
    //   385: iconst_0
    //   386: aload 4
    //   388: aastore
    //   389: invokevirtual 174	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   392: astore_1
    //   393: aload_1
    //   394: ifnull -116 -> 278
    //   397: aload_1
    //   398: instanceof 352
    //   401: ifeq -123 -> 278
    //   404: aload_1
    //   405: checkcast 352	java/lang/Integer
    //   408: invokevirtual 355	java/lang/Integer:intValue	()I
    //   411: istore_0
    //   412: getstatic 95	com/tencent/mm/accessibility/AccessibilityCapture:mAPIProvider	Lcom/tencent/mm/accessibility/AccessibilityCapture$APIProvider;
    //   415: ldc 31
    //   417: ldc_w 381
    //   420: iconst_1
    //   421: anewarray 4	java/lang/Object
    //   424: dup
    //   425: iconst_0
    //   426: iload_0
    //   427: invokestatic 369	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   430: aastore
    //   431: invokeinterface 183 4 0
    //   436: iload_0
    //   437: invokestatic 100	com/tencent/mm/accessibility/AccessibilityCapture:updateState	(I)V
    //   440: return
    //   441: astore_1
    //   442: getstatic 95	com/tencent/mm/accessibility/AccessibilityCapture:mAPIProvider	Lcom/tencent/mm/accessibility/AccessibilityCapture$APIProvider;
    //   445: ldc 31
    //   447: aload_1
    //   448: new 304	java/lang/StringBuilder
    //   451: dup
    //   452: ldc_w 383
    //   455: invokespecial 307	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   458: aload_1
    //   459: invokevirtual 386	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   462: invokevirtual 316	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   468: iconst_0
    //   469: anewarray 4	java/lang/Object
    //   472: invokeinterface 208 5 0
    //   477: iconst_1
    //   478: putstatic 77	com/tencent/mm/accessibility/AccessibilityCapture:mForwardEnable	Z
    //   481: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   158	279	0	i	int
    //   14	229	1	localObject1	Object
    //   279	80	1	localException	java.lang.Exception
    //   392	13	1	localObject2	Object
    //   441	18	1	localThrowable	Throwable
    //   80	300	2	localObject3	Object
    //   45	324	3	localObject4	Object
    //   84	303	4	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   101	109	279	java/lang/Exception
    //   113	231	441	java/lang/Throwable
    //   235	278	441	java/lang/Throwable
    //   328	393	441	java/lang/Throwable
    //   397	440	441	java/lang/Throwable
  }
  
  private static void updateState(int paramInt)
  {
    if ((paramInt & 0x1) != 0) {}
    for (paramInt = 1; paramInt != 0; paramInt = 0)
    {
      notifyListeners(true);
      mForwardEnable = true;
      return;
    }
    mForwardEnable = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.accessibility.AccessibilityCapture
 * JD-Core Version:    0.7.0.1
 */