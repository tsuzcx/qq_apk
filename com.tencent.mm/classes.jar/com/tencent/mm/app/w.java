package com.tencent.mm.app;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.xh;
import com.tencent.mm.g.a.xh.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class w
{
  private static final ay cJs;
  private static final boolean[] cJt;
  private static final boolean[] cJu;
  
  static
  {
    AppMethodBeat.i(209989);
    cJs = new ay("PatchLagFixerRpt", TimeUnit.DAYS.toMillis(1L));
    cJt = new boolean[] { false };
    cJu = new boolean[] { false };
    AppMethodBeat.o(209989);
  }
  
  public static boolean KF()
  {
    AppMethodBeat.i(209970);
    if (!com.tencent.tinker.lib.e.b.c(d.cIg))
    {
      ac.i("MicroMsg.PatchLagFixer", "[+] No patch was loaded, do not need to do fix.");
      AppMethodBeat.o(209970);
      return false;
    }
    if (KJ())
    {
      ac.i("MicroMsg.PatchLagFixer", "[+] Patch odex is exist, do not need to do fix.");
      AppMethodBeat.o(209970);
      return false;
    }
    AppMethodBeat.o(209970);
    return true;
  }
  
  public static boolean KG()
  {
    synchronized (cJu)
    {
      int i = cJu[0];
      return i;
    }
  }
  
  public static void KH()
  {
    AppMethodBeat.i(209972);
    Object localObject1 = new xh();
    ((xh)localObject1).dAb.dgL = 2;
    com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
    boolean bool1 = ((xh)localObject1).dAc.dAd;
    boolean bool2 = com.tencent.mm.r.a.aaZ();
    if ((bool1) || (bool2))
    {
      ac.w("MicroMsg.PatchLagFixer", "[!] We are on voip or multi-talking, skip restart.");
      AppMethodBeat.o(209972);
      return;
    }
    ac.i("MicroMsg.PatchLagFixer", "[+] Do restart WeChat now.");
    ac.eUR();
    hm(64);
    MMAppMgr.bA(ai.getContext());
    localObject1 = ((ActivityManager)ai.getContext().getSystemService("activity")).getRunningAppProcesses().iterator();
    label259:
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject1).next();
      if ((((ActivityManager.RunningAppProcessInfo)localObject2).uid == Process.myUid()) && (((ActivityManager.RunningAppProcessInfo)localObject2).pid != Process.myPid()) && (((ActivityManager.RunningAppProcessInfo)localObject2).processName != null)) {
        if (((ActivityManager.RunningAppProcessInfo)localObject2).processName.endsWith(":tools"))
        {
          Process.killProcess(((ActivityManager.RunningAppProcessInfo)localObject2).pid);
        }
        else if (((ActivityManager.RunningAppProcessInfo)localObject2).processName.endsWith(":toolsmp"))
        {
          Process.killProcess(((ActivityManager.RunningAppProcessInfo)localObject2).pid);
        }
        else
        {
          String[] arrayOfString = g.gia;
          int j = arrayOfString.length;
          int i = 0;
          for (;;)
          {
            if (i >= j) {
              break label259;
            }
            String str = arrayOfString[i];
            if (((ActivityManager.RunningAppProcessInfo)localObject2).processName.endsWith(str))
            {
              Process.killProcess(((ActivityManager.RunningAppProcessInfo)localObject2).pid);
              break;
            }
            i += 1;
          }
        }
      }
    }
    Object localObject2 = new Intent(ai.getContext(), LauncherUI.class);
    ((Intent)localObject2).setAction("android.intent.action.MAIN");
    ((Intent)localObject2).addCategory("android.intent.category.LAUNCHER");
    ((Intent)localObject2).addFlags(67108864);
    ((Intent)localObject2).addFlags(268435456);
    localObject1 = ai.getContext();
    localObject2 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject2);
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aeD(), "com/tencent/mm/app/PatchLagFixer", "restartWeChat", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/app/PatchLagFixer", "restartWeChat", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(209972);
  }
  
  private static File KI()
  {
    AppMethodBeat.i(209973);
    Object localObject2 = d.cIg;
    if ((localObject2 == null) || (((ApplicationLike)localObject2).getApplication() == null))
    {
      localObject1 = new TinkerRuntimeException("tinkerApplication is null");
      AppMethodBeat.o(209973);
      throw ((Throwable)localObject1);
    }
    Object localObject1 = SharePatchFileUtil.getPatchDirectory(((ApplicationLike)localObject2).getApplication());
    localObject2 = SharePatchFileUtil.getPatchVersionDirectory(com.tencent.tinker.lib.e.b.d((ApplicationLike)localObject2));
    localObject1 = new File((File)localObject1, (String)localObject2 + "/dex/tinker_classN.apk");
    AppMethodBeat.o(209973);
    return localObject1;
  }
  
  private static boolean KJ()
  {
    AppMethodBeat.i(209974);
    File localFile = KI();
    String str1 = com.tencent.mm.vfs.i.aSu(localFile.getName()) + ".odex";
    int i = 0;
    while (i < 2)
    {
      String str2 = new String[] { "arm", "arm64" }[i];
      if (new File(localFile.getParentFile(), "oat/" + str2 + "/" + str1).exists())
      {
        AppMethodBeat.o(209974);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(209974);
    return false;
  }
  
  /* Error */
  private static void a(android.os.IBinder paramIBinder, int paramInt, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: ldc_w 546
    //   6: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: invokestatic 552	android/os/Binder:clearCallingIdentity	()J
    //   12: lstore 5
    //   14: invokestatic 558	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   17: astore 7
    //   19: invokestatic 558	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   22: astore 8
    //   24: aload 7
    //   26: ldc_w 560
    //   29: invokevirtual 563	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   32: aload 7
    //   34: aload_2
    //   35: invokevirtual 566	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   38: aload 7
    //   40: aload_3
    //   41: invokevirtual 566	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   44: aload 7
    //   46: iconst_1
    //   47: invokevirtual 569	android/os/Parcel:writeInt	(I)V
    //   50: aload_0
    //   51: iload_1
    //   52: aload 7
    //   54: aload 8
    //   56: iconst_0
    //   57: invokeinterface 575 5 0
    //   62: ifne +75 -> 137
    //   65: new 577	java/lang/IllegalStateException
    //   68: dup
    //   69: ldc_w 579
    //   72: invokespecial 580	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   75: astore_0
    //   76: ldc_w 546
    //   79: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   82: aload_0
    //   83: athrow
    //   84: astore_0
    //   85: new 577	java/lang/IllegalStateException
    //   88: dup
    //   89: aload_0
    //   90: invokespecial 583	java/lang/IllegalStateException:<init>	(Ljava/lang/Throwable;)V
    //   93: astore_0
    //   94: ldc_w 546
    //   97: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   100: aload_0
    //   101: athrow
    //   102: astore_0
    //   103: aload 8
    //   105: astore_2
    //   106: lload 5
    //   108: invokestatic 587	android/os/Binder:restoreCallingIdentity	(J)V
    //   111: aload_2
    //   112: ifnull +7 -> 119
    //   115: aload_2
    //   116: invokevirtual 590	android/os/Parcel:recycle	()V
    //   119: aload 7
    //   121: ifnull +8 -> 129
    //   124: aload 7
    //   126: invokevirtual 590	android/os/Parcel:recycle	()V
    //   129: ldc_w 546
    //   132: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   135: aload_0
    //   136: athrow
    //   137: aload 8
    //   139: invokevirtual 593	android/os/Parcel:readException	()V
    //   142: aload 8
    //   144: invokevirtual 596	android/os/Parcel:readInt	()I
    //   147: ifeq +68 -> 215
    //   150: iload 4
    //   152: istore_1
    //   153: iload_1
    //   154: ifne +11 -> 165
    //   157: ldc 65
    //   159: ldc_w 598
    //   162: invokestatic 124	com/tencent/mm/sdk/platformtools/ac:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   165: lload 5
    //   167: invokestatic 587	android/os/Binder:restoreCallingIdentity	(J)V
    //   170: aload 8
    //   172: ifnull +8 -> 180
    //   175: aload 8
    //   177: invokevirtual 590	android/os/Parcel:recycle	()V
    //   180: aload 7
    //   182: ifnull +38 -> 220
    //   185: aload 7
    //   187: invokevirtual 590	android/os/Parcel:recycle	()V
    //   190: ldc_w 546
    //   193: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   196: return
    //   197: astore_0
    //   198: new 577	java/lang/IllegalStateException
    //   201: dup
    //   202: aload_0
    //   203: invokespecial 583	java/lang/IllegalStateException:<init>	(Ljava/lang/Throwable;)V
    //   206: astore_0
    //   207: ldc_w 546
    //   210: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   213: aload_0
    //   214: athrow
    //   215: iconst_0
    //   216: istore_1
    //   217: goto -64 -> 153
    //   220: ldc_w 546
    //   223: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   226: return
    //   227: astore_0
    //   228: aconst_null
    //   229: astore_2
    //   230: aconst_null
    //   231: astore 7
    //   233: goto -127 -> 106
    //   236: astore_0
    //   237: aconst_null
    //   238: astore_2
    //   239: goto -133 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	242	0	paramIBinder	android.os.IBinder
    //   0	242	1	paramInt	int
    //   0	242	2	paramString1	String
    //   0	242	3	paramString2	String
    //   1	150	4	i	int
    //   12	154	5	l	long
    //   17	215	7	localParcel1	android.os.Parcel
    //   22	154	8	localParcel2	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   50	84	84	android/os/RemoteException
    //   24	50	102	finally
    //   50	84	102	finally
    //   85	102	102	finally
    //   137	142	102	finally
    //   142	150	102	finally
    //   157	165	102	finally
    //   198	215	102	finally
    //   137	142	197	java/lang/Throwable
    //   14	19	227	finally
    //   19	24	236	finally
  }
  
  public static void br(Context paramContext)
  {
    int i = 0;
    AppMethodBeat.i(209971);
    if (KG())
    {
      ac.i("MicroMsg.PatchLagFixer", "[+] DexOpt is done, skip this invocation.");
      AppMethodBeat.o(209971);
      return;
    }
    if (aw.aKT("patch_lag_fixer_counter").getInt("call_count_" + com.tencent.mm.sdk.platformtools.h.GqE, 0) > 5) {
      i = 1;
    }
    if (i != 0)
    {
      ac.w("MicroMsg.PatchLagFixer", "[!] Call too many times, skip at this version.");
      AppMethodBeat.o(209971);
      return;
    }
    synchronized (cJt)
    {
      if (cJt[0] != 0)
      {
        ac.w("MicroMsg.PatchLagFixer", "[+] DexOpt is already triggered and not finish, skip this invocation.");
        AppMethodBeat.o(209971);
        return;
      }
      com.tencent.e.h.JZN.aS(new Runnable()
      {
        /* Error */
        public final void run()
        {
          // Byte code:
          //   0: ldc 24
          //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
          //   5: invokestatic 34	com/tencent/mm/app/w:KK	()[Z
          //   8: astore_1
          //   9: aload_1
          //   10: monitorenter
          //   11: invokestatic 34	com/tencent/mm/app/w:KK	()[Z
          //   14: iconst_0
          //   15: baload
          //   16: ifne +61 -> 77
          //   19: invokestatic 34	com/tencent/mm/app/w:KK	()[Z
          //   22: iconst_0
          //   23: iconst_1
          //   24: bastore
          //   25: aload_1
          //   26: monitorexit
          //   27: invokestatic 37	com/tencent/mm/app/w:KL	()[Z
          //   30: astore_1
          //   31: aload_1
          //   32: monitorenter
          //   33: invokestatic 37	com/tencent/mm/app/w:KL	()[Z
          //   36: iconst_0
          //   37: iconst_0
          //   38: bastore
          //   39: aload_1
          //   40: monitorexit
          //   41: getstatic 43	com/tencent/mm/app/d:cIg	Lcom/tencent/tinker/entry/ApplicationLike;
          //   44: invokestatic 49	com/tencent/tinker/lib/e/b:c	(Lcom/tencent/tinker/entry/ApplicationLike;)Z
          //   47: ifne +141 -> 188
          //   50: ldc 51
          //   52: ldc 53
          //   54: invokestatic 59	com/tencent/mm/sdk/platformtools/ac:w	(Ljava/lang/String;Ljava/lang/String;)V
          //   57: invokestatic 34	com/tencent/mm/app/w:KK	()[Z
          //   60: astore_1
          //   61: aload_1
          //   62: monitorenter
          //   63: invokestatic 34	com/tencent/mm/app/w:KK	()[Z
          //   66: iconst_0
          //   67: iconst_0
          //   68: bastore
          //   69: aload_1
          //   70: monitorexit
          //   71: ldc 24
          //   73: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   76: return
          //   77: aload_1
          //   78: monitorexit
          //   79: ldc 24
          //   81: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   84: return
          //   85: astore_2
          //   86: aload_1
          //   87: monitorexit
          //   88: ldc 24
          //   90: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   93: aload_2
          //   94: athrow
          //   95: astore_2
          //   96: aload_1
          //   97: monitorexit
          //   98: ldc 24
          //   100: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   103: aload_2
          //   104: athrow
          //   105: astore_1
          //   106: bipush 61
          //   108: bipush 63
          //   110: invokestatic 66	com/tencent/mm/app/w:cd	(II)V
          //   113: iconst_3
          //   114: anewarray 4	java/lang/Object
          //   117: dup
          //   118: iconst_0
          //   119: iconst_3
          //   120: invokestatic 72	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   123: aastore
          //   124: dup
          //   125: iconst_1
          //   126: invokestatic 78	com/tencent/mm/sdk/platformtools/ai:getProcessName	()Ljava/lang/String;
          //   129: aastore
          //   130: dup
          //   131: iconst_2
          //   132: aload_1
          //   133: invokestatic 84	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
          //   136: aastore
          //   137: invokestatic 88	com/tencent/mm/app/w:f	([Ljava/lang/Object;)V
          //   140: invokestatic 91	com/tencent/mm/app/w:KR	()V
          //   143: invokestatic 94	com/tencent/mm/app/w:access$300	()V
          //   146: ldc 51
          //   148: aload_1
          //   149: ldc 96
          //   151: iconst_0
          //   152: anewarray 4	java/lang/Object
          //   155: invokestatic 100	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
          //   158: invokestatic 34	com/tencent/mm/app/w:KK	()[Z
          //   161: astore_1
          //   162: aload_1
          //   163: monitorenter
          //   164: invokestatic 34	com/tencent/mm/app/w:KK	()[Z
          //   167: iconst_0
          //   168: iconst_0
          //   169: bastore
          //   170: aload_1
          //   171: monitorexit
          //   172: ldc 24
          //   174: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   177: return
          //   178: astore_2
          //   179: aload_1
          //   180: monitorexit
          //   181: ldc 24
          //   183: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   186: aload_2
          //   187: athrow
          //   188: getstatic 106	android/os/Build$VERSION:SDK_INT	I
          //   191: bipush 29
          //   193: if_icmpeq +40 -> 233
          //   196: ldc 51
          //   198: ldc 108
          //   200: invokestatic 59	com/tencent/mm/sdk/platformtools/ac:w	(Ljava/lang/String;Ljava/lang/String;)V
          //   203: invokestatic 34	com/tencent/mm/app/w:KK	()[Z
          //   206: astore_1
          //   207: aload_1
          //   208: monitorenter
          //   209: invokestatic 34	com/tencent/mm/app/w:KK	()[Z
          //   212: iconst_0
          //   213: iconst_0
          //   214: bastore
          //   215: aload_1
          //   216: monitorexit
          //   217: ldc 24
          //   219: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   222: return
          //   223: astore_2
          //   224: aload_1
          //   225: monitorexit
          //   226: ldc 24
          //   228: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   231: aload_2
          //   232: athrow
          //   233: ldc 110
          //   235: getstatic 116	android/os/Build:MANUFACTURER	Ljava/lang/String;
          //   238: invokevirtual 122	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
          //   241: ifne +73 -> 314
          //   244: ldc 124
          //   246: getstatic 116	android/os/Build:MANUFACTURER	Ljava/lang/String;
          //   249: invokevirtual 122	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
          //   252: ifne +62 -> 314
          //   255: ldc 126
          //   257: getstatic 116	android/os/Build:MANUFACTURER	Ljava/lang/String;
          //   260: invokevirtual 122	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
          //   263: ifne +51 -> 314
          //   266: ldc 128
          //   268: getstatic 116	android/os/Build:MANUFACTURER	Ljava/lang/String;
          //   271: invokevirtual 122	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
          //   274: ifne +40 -> 314
          //   277: ldc 51
          //   279: ldc 130
          //   281: invokestatic 59	com/tencent/mm/sdk/platformtools/ac:w	(Ljava/lang/String;Ljava/lang/String;)V
          //   284: invokestatic 34	com/tencent/mm/app/w:KK	()[Z
          //   287: astore_1
          //   288: aload_1
          //   289: monitorenter
          //   290: invokestatic 34	com/tencent/mm/app/w:KK	()[Z
          //   293: iconst_0
          //   294: iconst_0
          //   295: bastore
          //   296: aload_1
          //   297: monitorexit
          //   298: ldc 24
          //   300: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   303: return
          //   304: astore_2
          //   305: aload_1
          //   306: monitorexit
          //   307: ldc 24
          //   309: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   312: aload_2
          //   313: athrow
          //   314: ldc 51
          //   316: ldc 132
          //   318: invokestatic 134	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
          //   321: invokestatic 137	com/tencent/mm/app/w:KM	()V
          //   324: invokestatic 94	com/tencent/mm/app/w:access$300	()V
          //   327: invokestatic 140	com/tencent/mm/app/w:KN	()V
          //   330: invokestatic 144	com/tencent/mm/app/w:KO	()Z
          //   333: ifeq +96 -> 429
          //   336: ldc 51
          //   338: ldc 146
          //   340: invokestatic 134	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
          //   343: bipush 61
          //   345: bipush 70
          //   347: invokestatic 66	com/tencent/mm/app/w:cd	(II)V
          //   350: invokestatic 149	com/tencent/mm/app/w:KP	()V
          //   353: invokestatic 37	com/tencent/mm/app/w:KL	()[Z
          //   356: astore_1
          //   357: aload_1
          //   358: monitorenter
          //   359: invokestatic 37	com/tencent/mm/app/w:KL	()[Z
          //   362: iconst_0
          //   363: iconst_1
          //   364: bastore
          //   365: aload_1
          //   366: monitorexit
          //   367: invokestatic 34	com/tencent/mm/app/w:KK	()[Z
          //   370: astore_1
          //   371: aload_1
          //   372: monitorenter
          //   373: invokestatic 34	com/tencent/mm/app/w:KK	()[Z
          //   376: iconst_0
          //   377: iconst_0
          //   378: bastore
          //   379: aload_1
          //   380: monitorexit
          //   381: ldc 24
          //   383: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   386: return
          //   387: astore_2
          //   388: aload_1
          //   389: monitorexit
          //   390: ldc 24
          //   392: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   395: aload_2
          //   396: athrow
          //   397: astore_2
          //   398: invokestatic 34	com/tencent/mm/app/w:KK	()[Z
          //   401: astore_1
          //   402: aload_1
          //   403: monitorenter
          //   404: invokestatic 34	com/tencent/mm/app/w:KK	()[Z
          //   407: iconst_0
          //   408: iconst_0
          //   409: bastore
          //   410: aload_1
          //   411: monitorexit
          //   412: ldc 24
          //   414: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   417: aload_2
          //   418: athrow
          //   419: astore_2
          //   420: aload_1
          //   421: monitorexit
          //   422: ldc 24
          //   424: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   427: aload_2
          //   428: athrow
          //   429: aload_0
          //   430: getfield 16	com/tencent/mm/app/w$1:val$context	Landroid/content/Context;
          //   433: invokestatic 152	com/tencent/mm/app/w:bs	(Landroid/content/Context;)V
          //   436: invokestatic 144	com/tencent/mm/app/w:KO	()Z
          //   439: ifeq +164 -> 603
          //   442: ldc 51
          //   444: ldc 154
          //   446: invokestatic 134	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
          //   449: bipush 61
          //   451: bipush 62
          //   453: invokestatic 66	com/tencent/mm/app/w:cd	(II)V
          //   456: invokestatic 149	com/tencent/mm/app/w:KP	()V
          //   459: invokestatic 37	com/tencent/mm/app/w:KL	()[Z
          //   462: astore_1
          //   463: aload_1
          //   464: monitorenter
          //   465: invokestatic 37	com/tencent/mm/app/w:KL	()[Z
          //   468: iconst_0
          //   469: iconst_1
          //   470: bastore
          //   471: aload_1
          //   472: monitorexit
          //   473: invokestatic 34	com/tencent/mm/app/w:KK	()[Z
          //   476: astore_1
          //   477: aload_1
          //   478: monitorenter
          //   479: invokestatic 34	com/tencent/mm/app/w:KK	()[Z
          //   482: iconst_0
          //   483: iconst_0
          //   484: bastore
          //   485: aload_1
          //   486: monitorexit
          //   487: ldc 24
          //   489: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   492: return
          //   493: astore_2
          //   494: aload_1
          //   495: monitorexit
          //   496: ldc 24
          //   498: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   501: aload_2
          //   502: athrow
          //   503: astore_1
          //   504: ldc 51
          //   506: aload_1
          //   507: ldc 156
          //   509: iconst_0
          //   510: anewarray 4	java/lang/Object
          //   513: invokestatic 100	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
          //   516: aload_0
          //   517: getfield 16	com/tencent/mm/app/w$1:val$context	Landroid/content/Context;
          //   520: invokestatic 160	com/tencent/mm/app/w:KQ	()Ljava/io/File;
          //   523: invokevirtual 165	java/io/File:getAbsolutePath	()Ljava/lang/String;
          //   526: invokestatic 169	com/tencent/mm/app/w:r	(Landroid/content/Context;Ljava/lang/String;)V
          //   529: invokestatic 144	com/tencent/mm/app/w:KO	()Z
          //   532: ifeq +108 -> 640
          //   535: ldc 51
          //   537: ldc 171
          //   539: invokestatic 134	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
          //   542: bipush 71
          //   544: bipush 72
          //   546: invokestatic 66	com/tencent/mm/app/w:cd	(II)V
          //   549: bipush 61
          //   551: bipush 62
          //   553: invokestatic 66	com/tencent/mm/app/w:cd	(II)V
          //   556: invokestatic 149	com/tencent/mm/app/w:KP	()V
          //   559: invokestatic 37	com/tencent/mm/app/w:KL	()[Z
          //   562: astore_1
          //   563: aload_1
          //   564: monitorenter
          //   565: invokestatic 37	com/tencent/mm/app/w:KL	()[Z
          //   568: iconst_0
          //   569: iconst_1
          //   570: bastore
          //   571: aload_1
          //   572: monitorexit
          //   573: invokestatic 34	com/tencent/mm/app/w:KK	()[Z
          //   576: astore_1
          //   577: aload_1
          //   578: monitorenter
          //   579: invokestatic 34	com/tencent/mm/app/w:KK	()[Z
          //   582: iconst_0
          //   583: iconst_0
          //   584: bastore
          //   585: aload_1
          //   586: monitorexit
          //   587: ldc 24
          //   589: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   592: return
          //   593: astore_2
          //   594: aload_1
          //   595: monitorexit
          //   596: ldc 24
          //   598: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   601: aload_2
          //   602: athrow
          //   603: new 173	java/lang/IllegalStateException
          //   606: dup
          //   607: ldc 175
          //   609: invokespecial 178	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
          //   612: astore_1
          //   613: ldc 24
          //   615: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   618: aload_1
          //   619: athrow
          //   620: astore_2
          //   621: aload_1
          //   622: monitorexit
          //   623: ldc 24
          //   625: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   628: aload_2
          //   629: athrow
          //   630: astore_2
          //   631: aload_1
          //   632: monitorexit
          //   633: ldc 24
          //   635: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   638: aload_2
          //   639: athrow
          //   640: bipush 71
          //   642: bipush 73
          //   644: invokestatic 66	com/tencent/mm/app/w:cd	(II)V
          //   647: new 173	java/lang/IllegalStateException
          //   650: dup
          //   651: ldc 180
          //   653: invokespecial 178	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
          //   656: astore_1
          //   657: ldc 24
          //   659: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   662: aload_1
          //   663: athrow
          //   664: astore_2
          //   665: aload_1
          //   666: monitorexit
          //   667: ldc 24
          //   669: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   672: aload_2
          //   673: athrow
          //   674: astore_2
          //   675: aload_1
          //   676: monitorexit
          //   677: ldc 24
          //   679: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   682: aload_2
          //   683: athrow
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	684	0	this	1
          //   105	44	1	localThrowable1	Throwable
          //   503	4	1	localThrowable2	Throwable
          //   85	9	2	localObject2	Object
          //   95	9	2	localObject3	Object
          //   178	9	2	localObject4	Object
          //   223	9	2	localObject5	Object
          //   304	9	2	localObject6	Object
          //   387	9	2	localObject7	Object
          //   397	21	2	localObject8	Object
          //   419	9	2	localObject9	Object
          //   493	9	2	localObject10	Object
          //   593	9	2	localObject11	Object
          //   620	9	2	localObject12	Object
          //   630	9	2	localObject13	Object
          //   664	9	2	localObject14	Object
          //   674	9	2	localObject15	Object
          // Exception table:
          //   from	to	target	type
          //   11	27	85	finally
          //   77	79	85	finally
          //   86	88	85	finally
          //   33	41	95	finally
          //   96	98	95	finally
          //   27	33	105	java/lang/Throwable
          //   41	57	105	java/lang/Throwable
          //   98	105	105	java/lang/Throwable
          //   188	203	105	java/lang/Throwable
          //   233	284	105	java/lang/Throwable
          //   314	359	105	java/lang/Throwable
          //   390	397	105	java/lang/Throwable
          //   504	565	105	java/lang/Throwable
          //   623	630	105	java/lang/Throwable
          //   640	664	105	java/lang/Throwable
          //   63	71	178	finally
          //   179	181	178	finally
          //   209	217	223	finally
          //   224	226	223	finally
          //   290	298	304	finally
          //   305	307	304	finally
          //   359	367	387	finally
          //   388	390	387	finally
          //   27	33	397	finally
          //   41	57	397	finally
          //   98	105	397	finally
          //   106	158	397	finally
          //   188	203	397	finally
          //   233	284	397	finally
          //   314	359	397	finally
          //   390	397	397	finally
          //   429	465	397	finally
          //   496	503	397	finally
          //   504	565	397	finally
          //   603	620	397	finally
          //   623	630	397	finally
          //   640	664	397	finally
          //   373	381	419	finally
          //   420	422	419	finally
          //   465	473	493	finally
          //   494	496	493	finally
          //   429	465	503	java/lang/Throwable
          //   496	503	503	java/lang/Throwable
          //   603	620	503	java/lang/Throwable
          //   479	487	593	finally
          //   594	596	593	finally
          //   565	573	620	finally
          //   621	623	620	finally
          //   579	587	630	finally
          //   631	633	630	finally
          //   164	172	664	finally
          //   665	667	664	finally
          //   404	412	674	finally
          //   675	677	674	finally
        }
      });
      AppMethodBeat.o(209971);
      return;
    }
  }
  
  private static void hm(int paramInt)
  {
    AppMethodBeat.i(209977);
    if (cJs.aLa("rpt_898_".concat(String.valueOf(paramInt)))) {
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(898L, paramInt, 1L, true);
    }
    AppMethodBeat.o(209977);
  }
  
  /* Error */
  private static void triggerPMDexOptImpl2(android.os.IBinder paramIBinder, int paramInt, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc_w 722
    //   3: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 552	android/os/Binder:clearCallingIdentity	()J
    //   9: lstore 4
    //   11: invokestatic 558	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   14: astore 6
    //   16: invokestatic 558	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   19: astore 7
    //   21: aload 6
    //   23: ldc_w 560
    //   26: invokevirtual 563	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   29: aload 6
    //   31: aload_2
    //   32: invokevirtual 566	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   35: aload 6
    //   37: aload_3
    //   38: invokevirtual 566	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   41: aload 6
    //   43: iconst_0
    //   44: invokevirtual 569	android/os/Parcel:writeInt	(I)V
    //   47: aload 6
    //   49: iconst_0
    //   50: invokevirtual 569	android/os/Parcel:writeInt	(I)V
    //   53: aload_0
    //   54: iload_1
    //   55: aload 6
    //   57: aload 7
    //   59: iconst_0
    //   60: invokeinterface 575 5 0
    //   65: ifne +75 -> 140
    //   68: new 577	java/lang/IllegalStateException
    //   71: dup
    //   72: ldc_w 579
    //   75: invokespecial 580	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   78: astore_0
    //   79: ldc_w 722
    //   82: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   85: aload_0
    //   86: athrow
    //   87: astore_0
    //   88: new 577	java/lang/IllegalStateException
    //   91: dup
    //   92: aload_0
    //   93: invokespecial 583	java/lang/IllegalStateException:<init>	(Ljava/lang/Throwable;)V
    //   96: astore_0
    //   97: ldc_w 722
    //   100: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   103: aload_0
    //   104: athrow
    //   105: astore_0
    //   106: aload 7
    //   108: astore_2
    //   109: lload 4
    //   111: invokestatic 587	android/os/Binder:restoreCallingIdentity	(J)V
    //   114: aload_2
    //   115: ifnull +7 -> 122
    //   118: aload_2
    //   119: invokevirtual 590	android/os/Parcel:recycle	()V
    //   122: aload 6
    //   124: ifnull +8 -> 132
    //   127: aload 6
    //   129: invokevirtual 590	android/os/Parcel:recycle	()V
    //   132: ldc_w 722
    //   135: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   138: aload_0
    //   139: athrow
    //   140: aload 7
    //   142: invokevirtual 593	android/os/Parcel:readException	()V
    //   145: lload 4
    //   147: invokestatic 587	android/os/Binder:restoreCallingIdentity	(J)V
    //   150: aload 7
    //   152: ifnull +8 -> 160
    //   155: aload 7
    //   157: invokevirtual 590	android/os/Parcel:recycle	()V
    //   160: aload 6
    //   162: ifnull +33 -> 195
    //   165: aload 6
    //   167: invokevirtual 590	android/os/Parcel:recycle	()V
    //   170: ldc_w 722
    //   173: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   176: return
    //   177: astore_0
    //   178: new 577	java/lang/IllegalStateException
    //   181: dup
    //   182: aload_0
    //   183: invokespecial 583	java/lang/IllegalStateException:<init>	(Ljava/lang/Throwable;)V
    //   186: astore_0
    //   187: ldc_w 722
    //   190: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   193: aload_0
    //   194: athrow
    //   195: ldc_w 722
    //   198: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   201: return
    //   202: astore_0
    //   203: aconst_null
    //   204: astore_2
    //   205: aconst_null
    //   206: astore 6
    //   208: goto -99 -> 109
    //   211: astore_0
    //   212: aconst_null
    //   213: astore_2
    //   214: goto -105 -> 109
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	217	0	paramIBinder	android.os.IBinder
    //   0	217	1	paramInt	int
    //   0	217	2	paramString1	String
    //   0	217	3	paramString2	String
    //   9	137	4	l	long
    //   14	193	6	localParcel1	android.os.Parcel
    //   19	137	7	localParcel2	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   53	87	87	android/os/RemoteException
    //   21	53	105	finally
    //   53	87	105	finally
    //   88	105	105	finally
    //   140	145	105	finally
    //   178	195	105	finally
    //   140	145	177	java/lang/Throwable
    //   11	16	202	finally
    //   16	21	211	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.w
 * JD-Core Version:    0.7.0.1
 */