package com.tencent.mm.booter.notification;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.k.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.GreenManUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class e
  extends a
{
  public static String ltR = "com.tencent.preference.notification.key.unread.msg";
  public static String ltS = "com.tencent.preference.notification.key.unread.talker";
  public static String ltT = "com.tencent.preference.notification.key.all.notified.msgid";
  public com.tencent.mm.booter.notification.a.g hjR;
  Context mContext;
  
  public e()
  {
    AppMethodBeat.i(19958);
    this.mContext = MMApplicationContext.getContext();
    this.hjR = new com.tencent.mm.booter.notification.a.g(this.mContext);
    AppMethodBeat.o(19958);
  }
  
  static boolean Cx(String paramString)
  {
    AppMethodBeat.i(238921);
    try
    {
      paramString = com.tencent.mm.an.g.hU(paramString);
      if (paramString == null) {
        return false;
      }
      bh.bCz();
      paramString = com.tencent.mm.model.c.bzA().JE(paramString.aAX());
      if (paramString == null) {
        return false;
      }
      boolean bool = paramString.aGe();
      return bool;
    }
    finally
    {
      AppMethodBeat.o(238921);
    }
    return false;
  }
  
  public static void aKW()
  {
    AppMethodBeat.i(19972);
    h.aQD().edit().putString(ltT, "").apply();
    AppMethodBeat.o(19972);
  }
  
  public static Notification aKY()
  {
    AppMethodBeat.i(19959);
    Notification localNotification = new Notification();
    localNotification.icon = R.g.icon;
    localNotification.ledARGB = -16711936;
    localNotification.ledOnMS = 300;
    localNotification.ledOffMS = 1000;
    AppMethodBeat.o(19959);
    return localNotification;
  }
  
  public static int aKZ()
  {
    AppMethodBeat.i(19965);
    int i = h.aQD().getInt(ltR, 0);
    AppMethodBeat.o(19965);
    return i;
  }
  
  public static ArrayList<a> aLa()
  {
    AppMethodBeat.i(19966);
    try
    {
      ArrayList localArrayList1 = (ArrayList)com.tencent.mm.booter.notification.queue.c.Cz(h.aQD().getString(ltS, ""));
      if (localArrayList1 == null)
      {
        localArrayList1 = new ArrayList();
        AppMethodBeat.o(19966);
        return localArrayList1;
      }
      AppMethodBeat.o(19966);
      return localArrayList1;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      Log.printErrStackTrace("MicroMsg.Notification.AppMsg.Handle", localClassNotFoundException, "", new Object[0]);
      ArrayList localArrayList2 = new ArrayList();
      AppMethodBeat.o(19966);
      return localArrayList2;
    }
    catch (IOException localIOException)
    {
      Log.printErrStackTrace("MicroMsg.Notification.AppMsg.Handle", localIOException, "", new Object[0]);
      ArrayList localArrayList3 = new ArrayList();
      AppMethodBeat.o(19966);
      return localArrayList3;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.Notification.AppMsg.Handle", localException, "Justin_Exception:%s", new Object[] { localException.getMessage() });
      ArrayList localArrayList4 = new ArrayList();
      AppMethodBeat.o(19966);
      return localArrayList4;
    }
  }
  
  private static String aLb()
  {
    AppMethodBeat.i(19971);
    String str = h.aQD().getString(ltT, "");
    AppMethodBeat.o(19971);
    return str;
  }
  
  public static a c(List<a> paramList, String paramString)
  {
    AppMethodBeat.i(19964);
    if ((paramList == null) || (paramString == null))
    {
      AppMethodBeat.o(19964);
      return null;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      a locala = (a)paramList.next();
      if (locala.userName.equals(paramString))
      {
        AppMethodBeat.o(19964);
        return locala;
      }
    }
    AppMethodBeat.o(19964);
    return null;
  }
  
  public static void hg(long paramLong)
  {
    AppMethodBeat.i(19969);
    if (paramLong == 0L)
    {
      AppMethodBeat.o(19969);
      return;
    }
    String str2 = aLb();
    String str1 = str2;
    if (str2.length() > 3000) {
      str1 = str2.substring(str2.length() / 2, str2.length());
    }
    if (hh(paramLong))
    {
      AppMethodBeat.o(19969);
      return;
    }
    str1 = str1 + paramLong + "%";
    h.aQD().edit().putString(ltT, str1).apply();
    Log.d("MicroMsg.Notification.AppMsg.Handle", "setNotifiedMsgId: %s", new Object[] { str1 });
    AppMethodBeat.o(19969);
  }
  
  public static boolean hh(long paramLong)
  {
    AppMethodBeat.i(19970);
    if (paramLong == 0L)
    {
      AppMethodBeat.o(19970);
      return false;
    }
    String str = aLb();
    Log.d("MicroMsg.Notification.AppMsg.Handle", "isAlreadyNotified: %s, msgId: %d", new Object[] { str, Long.valueOf(paramLong) });
    if (str.contains(paramLong + "%"))
    {
      AppMethodBeat.o(19970);
      return true;
    }
    AppMethodBeat.o(19970);
    return false;
  }
  
  public static void k(ArrayList<a> paramArrayList)
  {
    AppMethodBeat.i(19967);
    if (paramArrayList == null)
    {
      h.aQD().edit().putString(ltS, "").apply();
      if (paramArrayList != null) {
        break label140;
      }
    }
    label140:
    for (paramArrayList = "null";; paramArrayList = paramArrayList.toString())
    {
      for (;;)
      {
        Log.i("MicroMsg.Notification.AppMsg.Handle", "saveTotalUnreadTalker %s", new Object[] { paramArrayList });
        AppMethodBeat.o(19967);
        return;
        try
        {
          ArrayList localArrayList = new ArrayList(paramArrayList);
          h.aQD().edit().putString(ltS, com.tencent.mm.booter.notification.queue.c.a(localArrayList)).apply();
        }
        catch (IOException localIOException)
        {
          Log.printErrStackTrace("MicroMsg.Notification.AppMsg.Handle", localIOException, "", new Object[0]);
          h.aQD().edit().putString(ltS, "").apply();
        }
      }
      break;
    }
  }
  
  public static void qi(int paramInt)
  {
    AppMethodBeat.i(19968);
    paramInt = Math.max(0, paramInt);
    h.aQD().edit().putInt(ltR, paramInt).apply();
    Log.i("MicroMsg.Notification.AppMsg.Handle", "saveTotalUnreadMsg %d", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(19968);
  }
  
  public final int a(NotificationItem paramNotificationItem, com.tencent.mm.booter.notification.a.g paramg)
  {
    AppMethodBeat.i(19961);
    if (GreenManUtil.isAppVisibleForeground(this.mContext))
    {
      Log.i("MicroMsg.Notification.AppMsg.Handle", "GreenManUtil.isAppVisibleForeground");
      if ((BuildInfo.DEBUG) || (BuildInfo.PRE_RELEASE))
      {
        Object localObject = ((ActivityManager)this.mContext.getSystemService("activity")).getRunningAppProcesses();
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
            if ((localRunningAppProcessInfo.processName.startsWith(MMApplicationContext.getApplicationId())) && (GreenManUtil.reflectProcessState(localRunningAppProcessInfo) == 3)) {
              GreenManUtil.dumpRunningServices(this.mContext);
            }
          }
        }
      }
    }
    else if ((Build.VERSION.SDK_INT >= 16) && (paramNotificationItem != null) && (paramNotificationItem.boX != null))
    {
      paramNotificationItem.boX.priority = 1;
      if (!h.aQE())
      {
        paramNotificationItem.boX.vibrate = new long[0];
        if ((!paramg.lvd) && (!paramg.lvc)) {
          paramNotificationItem.boX.priority = 0;
        }
      }
    }
    int i = super.a(paramNotificationItem, paramg);
    AppMethodBeat.o(19961);
    return i;
  }
  
  /* Error */
  public final Notification a(Notification paramNotification, int paramInt1, int paramInt2, PendingIntent paramPendingIntent1, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, int paramInt3, String paramString4, PendingIntent paramPendingIntent2, int paramInt4, String paramString5, PendingIntent paramPendingIntent3, String paramString6)
  {
    // Byte code:
    //   0: sipush 19963
    //   3: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 47	com/tencent/mm/booter/notification/e:mContext	Landroid/content/Context;
    //   10: invokestatic 384	com/tencent/mm/bq/a:iGp	()Ljava/lang/String;
    //   13: invokestatic 388	com/tencent/mm/bq/a:cA	(Landroid/content/Context;Ljava/lang/String;)Landroidx/core/app/f$d;
    //   16: astore 18
    //   18: iload_2
    //   19: istore 16
    //   21: iload_2
    //   22: iconst_m1
    //   23: if_icmpne +8 -> 31
    //   26: invokestatic 391	com/tencent/mm/bq/a:guX	()I
    //   29: istore 16
    //   31: aload 18
    //   33: getfield 394	androidx/core/app/f$d:boX	Landroid/app/Notification;
    //   36: ldc 133
    //   38: putfield 136	android/app/Notification:ledARGB	I
    //   41: aload 18
    //   43: getfield 394	androidx/core/app/f$d:boX	Landroid/app/Notification;
    //   46: sipush 300
    //   49: putfield 139	android/app/Notification:ledOnMS	I
    //   52: aload 18
    //   54: getfield 394	androidx/core/app/f$d:boX	Landroid/app/Notification;
    //   57: sipush 1000
    //   60: putfield 142	android/app/Notification:ledOffMS	I
    //   63: aload 18
    //   65: getfield 394	androidx/core/app/f$d:boX	Landroid/app/Notification;
    //   68: getfield 139	android/app/Notification:ledOnMS	I
    //   71: ifeq +421 -> 492
    //   74: aload 18
    //   76: getfield 394	androidx/core/app/f$d:boX	Landroid/app/Notification;
    //   79: getfield 142	android/app/Notification:ledOffMS	I
    //   82: ifeq +410 -> 492
    //   85: iconst_1
    //   86: istore_2
    //   87: aload 18
    //   89: getfield 394	androidx/core/app/f$d:boX	Landroid/app/Notification;
    //   92: astore 19
    //   94: aload 18
    //   96: getfield 394	androidx/core/app/f$d:boX	Landroid/app/Notification;
    //   99: getfield 397	android/app/Notification:flags	I
    //   102: istore 17
    //   104: iload_2
    //   105: ifeq +392 -> 497
    //   108: iconst_1
    //   109: istore_2
    //   110: aload 19
    //   112: iload_2
    //   113: iload 17
    //   115: bipush 254
    //   117: iand
    //   118: ior
    //   119: putfield 397	android/app/Notification:flags	I
    //   122: aload 18
    //   124: iload 16
    //   126: invokevirtual 401	androidx/core/app/f$d:eb	(I)Landroidx/core/app/f$d;
    //   129: aload 7
    //   131: invokevirtual 404	androidx/core/app/f$d:o	(Ljava/lang/CharSequence;)Landroidx/core/app/f$d;
    //   134: aload 4
    //   136: putfield 408	androidx/core/app/f$d:bor	Landroid/app/PendingIntent;
    //   139: invokestatic 413	com/tencent/mm/plugin/wear/model/a:inO	()Z
    //   142: ifeq +17 -> 159
    //   145: aload 18
    //   147: iconst_1
    //   148: putfield 416	androidx/core/app/f$d:boJ	Z
    //   151: ldc 171
    //   153: ldc_w 418
    //   156: invokestatic 308	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   159: aload 5
    //   161: ifnull +11 -> 172
    //   164: aload 18
    //   166: aload 5
    //   168: invokevirtual 421	androidx/core/app/f$d:l	(Ljava/lang/CharSequence;)Landroidx/core/app/f$d;
    //   171: pop
    //   172: aload 6
    //   174: ifnull +11 -> 185
    //   177: aload 18
    //   179: aload 6
    //   181: invokevirtual 424	androidx/core/app/f$d:m	(Ljava/lang/CharSequence;)Landroidx/core/app/f$d;
    //   184: pop
    //   185: aload 18
    //   187: getfield 394	androidx/core/app/f$d:boX	Landroid/app/Notification;
    //   190: iload_3
    //   191: putfield 427	android/app/Notification:defaults	I
    //   194: iload_3
    //   195: iconst_4
    //   196: iand
    //   197: ifeq +22 -> 219
    //   200: aload 18
    //   202: getfield 394	androidx/core/app/f$d:boX	Landroid/app/Notification;
    //   205: astore 4
    //   207: aload 4
    //   209: aload 4
    //   211: getfield 397	android/app/Notification:flags	I
    //   214: iconst_1
    //   215: ior
    //   216: putfield 397	android/app/Notification:flags	I
    //   219: aload 8
    //   221: ifnull +11 -> 232
    //   224: aload 18
    //   226: aload 8
    //   228: invokevirtual 430	androidx/core/app/f$d:i	(Landroid/graphics/Bitmap;)Landroidx/core/app/f$d;
    //   231: pop
    //   232: aload_1
    //   233: ifnull +41 -> 274
    //   236: aload_1
    //   237: getfield 434	android/app/Notification:sound	Landroid/net/Uri;
    //   240: ifnull +13 -> 253
    //   243: aload 18
    //   245: aload_1
    //   246: getfield 434	android/app/Notification:sound	Landroid/net/Uri;
    //   249: invokevirtual 437	androidx/core/app/f$d:d	(Landroid/net/Uri;)Landroidx/core/app/f$d;
    //   252: pop
    //   253: aload_1
    //   254: getfield 370	android/app/Notification:vibrate	[J
    //   257: ifnull +17 -> 274
    //   260: aload_1
    //   261: getfield 370	android/app/Notification:vibrate	[J
    //   264: astore_1
    //   265: aload 18
    //   267: getfield 394	androidx/core/app/f$d:boX	Landroid/app/Notification;
    //   270: aload_1
    //   271: putfield 370	android/app/Notification:vibrate	[J
    //   274: getstatic 354	android/os/Build$VERSION:SDK_INT	I
    //   277: bipush 16
    //   279: if_icmplt +87 -> 366
    //   282: aload 10
    //   284: ifnull +40 -> 324
    //   287: new 439	androidx/core/app/f$a$a
    //   290: dup
    //   291: iload 9
    //   293: aload 10
    //   295: aload 11
    //   297: invokespecial 442	androidx/core/app/f$a$a:<init>	(ILjava/lang/CharSequence;Landroid/app/PendingIntent;)V
    //   300: astore_1
    //   301: getstatic 354	android/os/Build$VERSION:SDK_INT	I
    //   304: bipush 29
    //   306: if_icmplt +8 -> 314
    //   309: aload_1
    //   310: iconst_0
    //   311: putfield 445	androidx/core/app/f$a$a:boe	Z
    //   314: aload 18
    //   316: aload_1
    //   317: invokevirtual 449	androidx/core/app/f$a$a:Dx	()Landroidx/core/app/f$a;
    //   320: invokevirtual 452	androidx/core/app/f$d:a	(Landroidx/core/app/f$a;)Landroidx/core/app/f$d;
    //   323: pop
    //   324: aload 13
    //   326: ifnull +40 -> 366
    //   329: new 439	androidx/core/app/f$a$a
    //   332: dup
    //   333: iload 12
    //   335: aload 13
    //   337: aload 14
    //   339: invokespecial 442	androidx/core/app/f$a$a:<init>	(ILjava/lang/CharSequence;Landroid/app/PendingIntent;)V
    //   342: astore_1
    //   343: getstatic 354	android/os/Build$VERSION:SDK_INT	I
    //   346: bipush 29
    //   348: if_icmplt +8 -> 356
    //   351: aload_1
    //   352: iconst_0
    //   353: putfield 445	androidx/core/app/f$a$a:boe	Z
    //   356: aload 18
    //   358: aload_1
    //   359: invokevirtual 449	androidx/core/app/f$a$a:Dx	()Landroidx/core/app/f$a;
    //   362: invokevirtual 452	androidx/core/app/f$d:a	(Landroidx/core/app/f$a;)Landroidx/core/app/f$d;
    //   365: pop
    //   366: getstatic 354	android/os/Build$VERSION:SDK_INT	I
    //   369: bipush 21
    //   371: if_icmplt +67 -> 438
    //   374: aload 18
    //   376: ldc_w 454
    //   379: putfield 457	androidx/core/app/f$d:boM	Ljava/lang/String;
    //   382: new 459	com/tencent/mm/autogen/a/ae
    //   385: dup
    //   386: invokespecial 460	com/tencent/mm/autogen/a/ae:<init>	()V
    //   389: astore_1
    //   390: aload_1
    //   391: getfield 464	com/tencent/mm/autogen/a/ae:hzZ	Lcom/tencent/mm/autogen/a/ae$a;
    //   394: aload 15
    //   396: putfield 469	com/tencent/mm/autogen/a/ae$a:username	Ljava/lang/String;
    //   399: aload_1
    //   400: getfield 464	com/tencent/mm/autogen/a/ae:hzZ	Lcom/tencent/mm/autogen/a/ae$a;
    //   403: aload 5
    //   405: putfield 472	com/tencent/mm/autogen/a/ae$a:title	Ljava/lang/String;
    //   408: aload_1
    //   409: invokevirtual 475	com/tencent/mm/autogen/a/ae:publish	()Z
    //   412: pop
    //   413: aload_1
    //   414: getfield 464	com/tencent/mm/autogen/a/ae:hzZ	Lcom/tencent/mm/autogen/a/ae$a;
    //   417: getfield 479	com/tencent/mm/autogen/a/ae$a:hAa	Landroidx/core/app/f$f;
    //   420: ifnull +18 -> 438
    //   423: aload_1
    //   424: getfield 464	com/tencent/mm/autogen/a/ae:hzZ	Lcom/tencent/mm/autogen/a/ae$a;
    //   427: getfield 479	com/tencent/mm/autogen/a/ae$a:hAa	Landroidx/core/app/f$f;
    //   430: aload 18
    //   432: invokeinterface 484 2 0
    //   437: pop
    //   438: aload 18
    //   440: iconst_1
    //   441: invokevirtual 488	androidx/core/app/f$d:aC	(Z)Landroidx/core/app/f$d;
    //   444: pop
    //   445: aload 18
    //   447: invokevirtual 491	androidx/core/app/f$d:DA	()Landroid/app/Notification;
    //   450: astore_1
    //   451: getstatic 354	android/os/Build$VERSION:SDK_INT	I
    //   454: bipush 29
    //   456: if_icmplt +28 -> 484
    //   459: ldc 124
    //   461: ldc_w 493
    //   464: invokestatic 499	com/tencent/mm/booter/notification/b:findField	(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   467: astore 4
    //   469: aload 4
    //   471: iconst_1
    //   472: invokevirtual 505	java/lang/reflect/Field:setAccessible	(Z)V
    //   475: aload 4
    //   477: aload_1
    //   478: getstatic 511	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   481: invokevirtual 515	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   484: sipush 19963
    //   487: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   490: aload_1
    //   491: areturn
    //   492: iconst_0
    //   493: istore_2
    //   494: goto -407 -> 87
    //   497: iconst_0
    //   498: istore_2
    //   499: goto -389 -> 110
    //   502: astore 4
    //   504: ldc 171
    //   506: aload 4
    //   508: ldc_w 517
    //   511: iconst_0
    //   512: anewarray 173	java/lang/Object
    //   515: invokestatic 179	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   518: goto -34 -> 484
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	521	0	this	e
    //   0	521	1	paramNotification	Notification
    //   0	521	2	paramInt1	int
    //   0	521	3	paramInt2	int
    //   0	521	4	paramPendingIntent1	PendingIntent
    //   0	521	5	paramString1	String
    //   0	521	6	paramString2	String
    //   0	521	7	paramString3	String
    //   0	521	8	paramBitmap	Bitmap
    //   0	521	9	paramInt3	int
    //   0	521	10	paramString4	String
    //   0	521	11	paramPendingIntent2	PendingIntent
    //   0	521	12	paramInt4	int
    //   0	521	13	paramString5	String
    //   0	521	14	paramPendingIntent3	PendingIntent
    //   0	521	15	paramString6	String
    //   19	106	16	i	int
    //   102	16	17	j	int
    //   16	430	18	locald	androidx.core.app.f.d
    //   92	19	19	localNotification	Notification
    // Exception table:
    //   from	to	target	type
    //   459	484	502	finally
  }
  
  public final Notification a(Notification paramNotification, int paramInt1, int paramInt2, PendingIntent paramPendingIntent, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, String paramString4)
  {
    AppMethodBeat.i(19962);
    paramNotification = a(paramNotification, paramInt1, paramInt2, paramPendingIntent, paramString1, paramString2, paramString3, paramBitmap, 0, null, null, 0, null, null, paramString4);
    AppMethodBeat.o(19962);
    return paramNotification;
  }
  
  public static final class a
    implements Serializable
  {
    public int hND;
    public String userName;
    
    public final String toString()
    {
      AppMethodBeat.i(19957);
      String str = "[" + this.userName + "(" + this.hND + ")]";
      AppMethodBeat.o(19957);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.booter.notification.e
 * JD-Core Version:    0.7.0.1
 */