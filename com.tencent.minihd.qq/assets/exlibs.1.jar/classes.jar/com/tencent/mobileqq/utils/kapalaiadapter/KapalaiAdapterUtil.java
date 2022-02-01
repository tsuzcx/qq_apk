package com.tencent.mobileqq.utils.kapalaiadapter;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.Notification.Builder;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Build;
import android.os.Build.VERSION;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.EditText;
import com.tencent.mobileqq.utils.kapalaiadapter.sdcardmountinforutil.SDCardMountInforUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import kut;

public class KapalaiAdapterUtil
{
  public int a;
  private DualSimManager a;
  
  private KapalaiAdapterUtil()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsKapalaiadapterDualSimManager = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqUtilsKapalaiadapterDualSimManager = DualSimManager.a();
  }
  
  public static KapalaiAdapterUtil a()
  {
    return kut.a;
  }
  
  private Camera b()
  {
    Object localObject2 = null;
    try
    {
      localObject1 = Camera.open();
      Camera.Parameters localParameters;
      if ((localObject1 != null) && (localObject1 == null)) {
        break label57;
      }
      ((Camera)localObject1).release();
    }
    catch (Exception localException1)
    {
      try
      {
        localParameters = ((Camera)localObject1).getParameters();
        if (localParameters != null)
        {
          localParameters.set("video_input", "secondary");
          ((Camera)localObject1).setParameters(localParameters);
        }
        return localObject1;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Object localObject1;
        }
      }
      localException1 = localException1;
      localObject1 = null;
    }
    localObject1 = localObject2;
    localException1.printStackTrace();
    return localObject1;
  }
  
  private Camera c()
  {
    Object localObject2 = null;
    try
    {
      localObject1 = Camera.open();
      Camera.Parameters localParameters;
      if ((localObject1 != null) && (localObject1 == null)) {
        break label57;
      }
      ((Camera)localObject1).release();
    }
    catch (Exception localException1)
    {
      try
      {
        localParameters = ((Camera)localObject1).getParameters();
        if (localParameters != null)
        {
          localParameters.set("device", "/dev/video1");
          ((Camera)localObject1).setParameters(localParameters);
        }
        return localObject1;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Object localObject1;
        }
      }
      localException1 = localException1;
      localObject1 = null;
    }
    localObject1 = localObject2;
    localException1.printStackTrace();
    return localObject1;
  }
  
  private Camera d()
  {
    Object localObject2 = null;
    try
    {
      localObject1 = Camera.open();
      Method localMethod;
      if ((localObject1 != null) && (localObject1 == null)) {
        break label76;
      }
      ((Camera)localObject1).release();
    }
    catch (Exception localException1)
    {
      try
      {
        localMethod = localObject1.getClass().getMethod("setSensorID", new Class[] { Integer.TYPE });
        if (localMethod != null) {
          localMethod.invoke(localObject1, new Object[] { Integer.valueOf(1) });
        }
        return localObject1;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Object localObject1;
        }
      }
      localException1 = localException1;
      localObject1 = null;
    }
    localObject1 = localObject2;
    localException1.printStackTrace();
    return localObject1;
  }
  
  private Camera e()
  {
    Camera localCamera = null;
    try
    {
      Class localClass = Class.forName("android.hardware.Camera");
      Method localMethod = localClass.getMethod("setCurrentCamera", new Class[] { Integer.TYPE });
      if (localMethod != null)
      {
        localMethod.invoke(localClass, new Object[] { Integer.valueOf(1) });
        localCamera = Camera.open();
      }
      return localCamera;
    }
    catch (Exception localException)
    {
      if (0 != 0) {
        throw new NullPointerException();
      }
      localException.printStackTrace();
    }
    return null;
  }
  
  @TargetApi(9)
  private Camera f()
  {
    Camera localCamera = null;
    try
    {
      if (VersionUtils.c()) {
        localCamera = Camera.open();
      }
      return localCamera;
    }
    catch (Exception localException)
    {
      if (0 != 0) {
        throw new NullPointerException();
      }
      localException.printStackTrace();
    }
    return null;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @TargetApi(16)
  public Notification a(Context paramContext, int paramInt)
  {
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT < 11)
        {
          paramContext = new Notification(paramInt, null, System.currentTimeMillis());
          localObject = paramContext;
          if (paramContext == null) {
            localObject = new Notification(paramInt, null, System.currentTimeMillis());
          }
          return localObject;
        }
        paramContext = new Notification.Builder(paramContext);
        Object localObject = Class.forName("android.app.Notification$Builder").getDeclaredMethod("setInternalApp", new Class[] { Integer.TYPE });
        if (localObject != null)
        {
          ((Method)localObject).invoke(paramContext, new Object[] { Integer.valueOf(1) });
          if (Build.VERSION.SDK_INT >= 16)
          {
            paramContext = paramContext.build();
            continue;
          }
          if ((Build.VERSION.SDK_INT < 16) && (Build.VERSION.SDK_INT >= 11))
          {
            paramContext = paramContext.getNotification();
            continue;
            return null;
          }
        }
      }
      catch (Exception paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.e("newNotificationForMeizu", 2, paramContext.getMessage());
        }
        if (0 == 0) {
          return new Notification(paramInt, null, System.currentTimeMillis());
        }
      }
      finally
      {
        if (0 == 0) {
          new Notification(paramInt, null, System.currentTimeMillis());
        }
      }
      paramContext = null;
    }
  }
  
  /* Error */
  @TargetApi(11)
  public Notification a(Intent paramIntent, Bitmap paramBitmap, String paramString1, String paramString2, String paramString3, boolean paramBoolean, com.tencent.mobileqq.app.QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: aload 7
    //   2: invokevirtual 176	com/tencent/mobileqq/app/QQAppInterface:b	()Z
    //   5: istore 10
    //   7: invokestatic 182	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   10: iconst_0
    //   11: aload_1
    //   12: ldc 183
    //   14: invokestatic 189	android/app/PendingIntent:getActivity	(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;
    //   17: astore 11
    //   19: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   22: ifeq +29 -> 51
    //   25: ldc 191
    //   27: iconst_2
    //   28: new 193	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   35: ldc 196
    //   37: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload 11
    //   42: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 209	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   51: ldc 210
    //   53: istore 9
    //   55: aload_1
    //   56: ldc 212
    //   58: iconst_m1
    //   59: invokevirtual 218	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   62: sipush 1008
    //   65: if_icmpne +137 -> 202
    //   68: getstatic 224	com/tencent/mobileqq/app/AppConstants:T	Ljava/lang/String;
    //   71: aload_1
    //   72: ldc 226
    //   74: invokevirtual 230	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   77: invokevirtual 236	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   80: ifeq +114 -> 194
    //   83: iload 9
    //   85: istore 8
    //   87: getstatic 126	android/os/Build$VERSION:SDK_INT	I
    //   90: bipush 11
    //   92: if_icmpge +196 -> 288
    //   95: new 128	android/app/Notification
    //   98: dup
    //   99: iload 8
    //   101: aload_3
    //   102: invokestatic 134	java/lang/System:currentTimeMillis	()J
    //   105: invokespecial 137	android/app/Notification:<init>	(ILjava/lang/CharSequence;J)V
    //   108: astore_1
    //   109: aload_1
    //   110: aload 11
    //   112: putfield 240	android/app/Notification:contentIntent	Landroid/app/PendingIntent;
    //   115: iload 10
    //   117: ifeq +24 -> 141
    //   120: aload_1
    //   121: aload_1
    //   122: getfield 243	android/app/Notification:flags	I
    //   125: bipush 32
    //   127: ior
    //   128: putfield 243	android/app/Notification:flags	I
    //   131: aload_1
    //   132: aload_1
    //   133: getfield 243	android/app/Notification:flags	I
    //   136: iconst_2
    //   137: ior
    //   138: putfield 243	android/app/Notification:flags	I
    //   141: invokestatic 182	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   144: aload 7
    //   146: invokestatic 248	com/tencent/mobileqq/util/NotifyLightUtil:a	(Landroid/content/Context;Lcom/tencent/common/app/AppInterface;)Z
    //   149: ifeq +43 -> 192
    //   152: invokestatic 254	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   155: bipush 11
    //   157: invokevirtual 258	java/util/Calendar:get	(I)I
    //   160: pop
    //   161: aload_1
    //   162: aload_1
    //   163: getfield 243	android/app/Notification:flags	I
    //   166: iconst_1
    //   167: ior
    //   168: putfield 243	android/app/Notification:flags	I
    //   171: aload_1
    //   172: ldc_w 259
    //   175: putfield 262	android/app/Notification:ledARGB	I
    //   178: aload_1
    //   179: sipush 2000
    //   182: putfield 265	android/app/Notification:ledOffMS	I
    //   185: aload_1
    //   186: sipush 2000
    //   189: putfield 268	android/app/Notification:ledOnMS	I
    //   192: aload_1
    //   193: areturn
    //   194: ldc_w 269
    //   197: istore 8
    //   199: goto -112 -> 87
    //   202: aload_1
    //   203: ldc 212
    //   205: iconst_m1
    //   206: invokevirtual 218	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   209: sipush 1010
    //   212: if_icmpne +29 -> 241
    //   215: getstatic 272	com/tencent/mobileqq/app/AppConstants:au	Ljava/lang/String;
    //   218: invokestatic 275	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   221: aload_1
    //   222: ldc 226
    //   224: invokevirtual 230	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   227: invokevirtual 236	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   230: ifeq +11 -> 241
    //   233: ldc_w 276
    //   236: istore 8
    //   238: goto -151 -> 87
    //   241: iload 9
    //   243: istore 8
    //   245: aload_1
    //   246: ldc 212
    //   248: iconst_m1
    //   249: invokevirtual 218	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   252: sipush 1001
    //   255: if_icmpne -168 -> 87
    //   258: iload 9
    //   260: istore 8
    //   262: getstatic 279	com/tencent/mobileqq/app/AppConstants:af	Ljava/lang/String;
    //   265: invokestatic 275	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   268: aload_1
    //   269: ldc 226
    //   271: invokevirtual 230	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   274: invokevirtual 236	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   277: ifeq -190 -> 87
    //   280: ldc_w 280
    //   283: istore 8
    //   285: goto -198 -> 87
    //   288: new 139	android/app/Notification$Builder
    //   291: dup
    //   292: invokestatic 182	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   295: invokespecial 142	android/app/Notification$Builder:<init>	(Landroid/content/Context;)V
    //   298: iload 8
    //   300: invokevirtual 284	android/app/Notification$Builder:setSmallIcon	(I)Landroid/app/Notification$Builder;
    //   303: iconst_1
    //   304: invokevirtual 288	android/app/Notification$Builder:setAutoCancel	(Z)Landroid/app/Notification$Builder;
    //   307: invokestatic 134	java/lang/System:currentTimeMillis	()J
    //   310: invokevirtual 292	android/app/Notification$Builder:setWhen	(J)Landroid/app/Notification$Builder;
    //   313: aload_3
    //   314: invokevirtual 296	android/app/Notification$Builder:setTicker	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   317: astore_1
    //   318: iload 10
    //   320: ifeq +9 -> 329
    //   323: aload_1
    //   324: iconst_1
    //   325: invokevirtual 299	android/app/Notification$Builder:setOngoing	(Z)Landroid/app/Notification$Builder;
    //   328: pop
    //   329: ldc 144
    //   331: invokestatic 103	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   334: ldc 146
    //   336: iconst_1
    //   337: anewarray 76	java/lang/Class
    //   340: dup
    //   341: iconst_0
    //   342: getstatic 82	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   345: aastore
    //   346: invokevirtual 149	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   349: astore 12
    //   351: aload 12
    //   353: ifnull +21 -> 374
    //   356: aload 12
    //   358: aload_1
    //   359: iconst_1
    //   360: anewarray 4	java/lang/Object
    //   363: dup
    //   364: iconst_0
    //   365: iconst_1
    //   366: invokestatic 90	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   369: aastore
    //   370: invokevirtual 96	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   373: pop
    //   374: invokestatic 182	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   377: aload 7
    //   379: invokestatic 248	com/tencent/mobileqq/util/NotifyLightUtil:a	(Landroid/content/Context;Lcom/tencent/common/app/AppInterface;)Z
    //   382: ifeq +26 -> 408
    //   385: invokestatic 254	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   388: bipush 11
    //   390: invokevirtual 258	java/util/Calendar:get	(I)I
    //   393: pop
    //   394: aload_1
    //   395: ldc_w 259
    //   398: sipush 2000
    //   401: sipush 2000
    //   404: invokevirtual 303	android/app/Notification$Builder:setLights	(III)Landroid/app/Notification$Builder;
    //   407: pop
    //   408: iload 6
    //   410: ifeq +55 -> 465
    //   413: aload_2
    //   414: ifnull +9 -> 423
    //   417: aload_1
    //   418: aload_2
    //   419: invokevirtual 307	android/app/Notification$Builder:setLargeIcon	(Landroid/graphics/Bitmap;)Landroid/app/Notification$Builder;
    //   422: pop
    //   423: aload_1
    //   424: aload 4
    //   426: invokevirtual 310	android/app/Notification$Builder:setContentTitle	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   429: aload 5
    //   431: invokevirtual 313	android/app/Notification$Builder:setContentText	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   434: aload 11
    //   436: invokevirtual 317	android/app/Notification$Builder:setContentIntent	(Landroid/app/PendingIntent;)Landroid/app/Notification$Builder;
    //   439: pop
    //   440: getstatic 126	android/os/Build$VERSION:SDK_INT	I
    //   443: bipush 16
    //   445: if_icmplt +50 -> 495
    //   448: aload_1
    //   449: invokevirtual 153	android/app/Notification$Builder:build	()Landroid/app/Notification;
    //   452: astore_1
    //   453: aload_1
    //   454: areturn
    //   455: astore 12
    //   457: aload 12
    //   459: invokevirtual 62	java/lang/Exception:printStackTrace	()V
    //   462: goto -88 -> 374
    //   465: aload_1
    //   466: aload 4
    //   468: invokevirtual 310	android/app/Notification$Builder:setContentTitle	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   471: aload 5
    //   473: invokevirtual 313	android/app/Notification$Builder:setContentText	(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;
    //   476: aload 11
    //   478: invokevirtual 317	android/app/Notification$Builder:setContentIntent	(Landroid/app/PendingIntent;)Landroid/app/Notification$Builder;
    //   481: pop
    //   482: aload_2
    //   483: ifnull -43 -> 440
    //   486: aload_1
    //   487: aload_2
    //   488: invokevirtual 307	android/app/Notification$Builder:setLargeIcon	(Landroid/graphics/Bitmap;)Landroid/app/Notification$Builder;
    //   491: pop
    //   492: goto -52 -> 440
    //   495: getstatic 126	android/os/Build$VERSION:SDK_INT	I
    //   498: bipush 16
    //   500: if_icmpge +16 -> 516
    //   503: getstatic 126	android/os/Build$VERSION:SDK_INT	I
    //   506: bipush 11
    //   508: if_icmplt +8 -> 516
    //   511: aload_1
    //   512: invokevirtual 156	android/app/Notification$Builder:getNotification	()Landroid/app/Notification;
    //   515: areturn
    //   516: new 128	android/app/Notification
    //   519: dup
    //   520: iload 8
    //   522: aload_3
    //   523: invokestatic 134	java/lang/System:currentTimeMillis	()J
    //   526: invokespecial 137	android/app/Notification:<init>	(ILjava/lang/CharSequence;J)V
    //   529: astore_1
    //   530: aload_1
    //   531: areturn
    //   532: astore_1
    //   533: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   536: ifeq +14 -> 550
    //   539: ldc_w 319
    //   542: iconst_2
    //   543: aload_1
    //   544: invokevirtual 167	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   547: invokestatic 170	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   550: new 128	android/app/Notification
    //   553: dup
    //   554: iload 8
    //   556: aload_3
    //   557: invokestatic 134	java/lang/System:currentTimeMillis	()J
    //   560: invokespecial 137	android/app/Notification:<init>	(ILjava/lang/CharSequence;J)V
    //   563: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	564	0	this	KapalaiAdapterUtil
    //   0	564	1	paramIntent	Intent
    //   0	564	2	paramBitmap	Bitmap
    //   0	564	3	paramString1	String
    //   0	564	4	paramString2	String
    //   0	564	5	paramString3	String
    //   0	564	6	paramBoolean	boolean
    //   0	564	7	paramQQAppInterface	com.tencent.mobileqq.app.QQAppInterface
    //   85	470	8	i	int
    //   53	206	9	j	int
    //   5	314	10	bool	boolean
    //   17	460	11	localPendingIntent	android.app.PendingIntent
    //   349	8	12	localMethod	Method
    //   455	3	12	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   329	351	455	java/lang/Exception
    //   356	374	455	java/lang/Exception
    //   440	453	532	java/lang/Exception
    //   495	516	532	java/lang/Exception
    //   516	530	532	java/lang/Exception
  }
  
  public Intent a(Intent paramIntent)
  {
    paramIntent.putExtra(a(), Integer.parseInt(c()));
    return null;
  }
  
  public Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    if (paramBitmap != null) {
      return Bitmap.createScaledBitmap(paramBitmap, paramInt, paramInt, true);
    }
    return null;
  }
  
  public Camera a()
  {
    Camera localCamera = null;
    if (Build.MANUFACTURER.equalsIgnoreCase("HTC")) {
      localCamera = b();
    }
    do
    {
      return localCamera;
      if (Build.MANUFACTURER.equalsIgnoreCase("YuLong")) {
        return c();
      }
      if (Build.MANUFACTURER.equalsIgnoreCase("HISENSE")) {
        return d();
      }
      if (Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) {
        return e();
      }
    } while (!Build.MANUFACTURER.equalsIgnoreCase("LENOVO"));
    return f();
  }
  
  public String a()
  {
    return DualSimManager.a;
  }
  
  public String a(Camera.Parameters paramParameters)
  {
    String str = "off";
    List localList = paramParameters.getSupportedFlashModes();
    if (localList.contains("torch")) {
      paramParameters = "torch";
    }
    do
    {
      return paramParameters;
      if (localList.contains("on")) {
        return "on";
      }
      paramParameters = str;
    } while (!localList.contains("auto"));
    return "auto";
  }
  
  public ArrayList a(Context paramContext)
  {
    ArrayList localArrayList1 = b(paramContext);
    if ((localArrayList1 == null) || (localArrayList1.size() < 1)) {
      return null;
    }
    ArrayList localArrayList2 = new ArrayList();
    int i = 0;
    while (i < localArrayList1.size())
    {
      String str = (String)localArrayList1.get(i);
      if (SDCardMountInforUtil.a(paramContext).a(str)) {
        localArrayList2.add(str);
      }
      i += 1;
    }
    return localArrayList2;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(Intent paramIntent)
  {
    paramIntent.setFlags(337641472);
  }
  
  public void a(Window paramWindow)
  {
    paramWindow.setType(2004);
  }
  
  public void a(WindowManager.LayoutParams paramLayoutParams)
  {
    paramLayoutParams.screenBrightness = 0.035F;
  }
  
  public void a(EditText paramEditText)
  {
    if (paramEditText != null) {
      paramEditText.setSelection(this.jdField_a_of_type_Int);
    }
  }
  
  public boolean a()
  {
    return (!this.jdField_a_of_type_ComTencentMobileqqUtilsKapalaiadapterDualSimManager.a(0)) && (this.jdField_a_of_type_ComTencentMobileqqUtilsKapalaiadapterDualSimManager.a(1));
  }
  
  public boolean a(int paramInt, String paramString1, String paramString2, ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3)
  {
    return DualSimManager.a().a(paramInt, paramString1, paramString2, paramArrayList1, paramArrayList2, paramArrayList3);
  }
  
  public boolean a(Context paramContext, String paramString)
  {
    return SDCardMountInforUtil.a(paramContext).a(paramString);
  }
  
  public boolean a(Camera.Parameters paramParameters, Context paramContext)
  {
    return (paramParameters.getSupportedFlashModes() != null) && (paramContext.getPackageManager().hasSystemFeature("android.hardware.camera.flash")) && (paramParameters.getSupportedFlashModes().size() > 1);
  }
  
  public int b()
  {
    return 1;
  }
  
  public String b()
  {
    return DualSimManager.b;
  }
  
  public ArrayList b(Context paramContext)
  {
    return SDCardMountInforUtil.a(paramContext).a();
  }
  
  public void b(Window paramWindow)
  {
    paramWindow.setType(2);
  }
  
  public String c()
  {
    return DualSimManager.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.kapalaiadapter.KapalaiAdapterUtil
 * JD-Core Version:    0.7.0.1
 */