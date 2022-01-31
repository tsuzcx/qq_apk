package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import com.google.android.gms.analytics.zzh;
import com.google.android.gms.common.internal.zzac;

public class zzsf$zza
  implements ServiceConnection
{
  private volatile zzta zzaeq;
  private volatile boolean zzaer;
  
  protected zzsf$zza(zzsf paramzzsf) {}
  
  /* Error */
  public void onServiceConnected(final ComponentName paramComponentName, android.os.IBinder paramIBinder)
  {
    // Byte code:
    //   0: ldc 33
    //   2: invokestatic 39	com/google/android/gms/common/internal/zzac:zzdj	(Ljava/lang/String;)V
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_2
    //   8: ifnonnull +19 -> 27
    //   11: aload_0
    //   12: getfield 21	com/google/android/gms/internal/zzsf$zza:zzaep	Lcom/google/android/gms/internal/zzsf;
    //   15: ldc 41
    //   17: invokevirtual 44	com/google/android/gms/internal/zzsf:zzbT	(Ljava/lang/String;)V
    //   20: aload_0
    //   21: invokevirtual 47	java/lang/Object:notifyAll	()V
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: aconst_null
    //   28: astore 4
    //   30: aconst_null
    //   31: astore_3
    //   32: aload 4
    //   34: astore_1
    //   35: aload_2
    //   36: invokeinterface 53 1 0
    //   41: astore 5
    //   43: aload 4
    //   45: astore_1
    //   46: ldc 55
    //   48: aload 5
    //   50: invokevirtual 61	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   53: ifeq +60 -> 113
    //   56: aload 4
    //   58: astore_1
    //   59: aload_2
    //   60: invokestatic 67	com/google/android/gms/internal/zzta$zza:zzam	(Landroid/os/IBinder;)Lcom/google/android/gms/internal/zzta;
    //   63: astore_2
    //   64: aload_2
    //   65: astore_1
    //   66: aload_0
    //   67: getfield 21	com/google/android/gms/internal/zzsf$zza:zzaep	Lcom/google/android/gms/internal/zzsf;
    //   70: ldc 69
    //   72: invokevirtual 72	com/google/android/gms/internal/zzsf:zzbP	(Ljava/lang/String;)V
    //   75: aload_2
    //   76: astore_1
    //   77: aload_1
    //   78: ifnonnull +74 -> 152
    //   81: invokestatic 78	com/google/android/gms/common/stats/zza:zzyJ	()Lcom/google/android/gms/common/stats/zza;
    //   84: aload_0
    //   85: getfield 21	com/google/android/gms/internal/zzsf$zza:zzaep	Lcom/google/android/gms/internal/zzsf;
    //   88: invokevirtual 82	com/google/android/gms/internal/zzsf:getContext	()Landroid/content/Context;
    //   91: aload_0
    //   92: getfield 21	com/google/android/gms/internal/zzsf$zza:zzaep	Lcom/google/android/gms/internal/zzsf;
    //   95: invokestatic 85	com/google/android/gms/internal/zzsf:zza	(Lcom/google/android/gms/internal/zzsf;)Lcom/google/android/gms/internal/zzsf$zza;
    //   98: invokevirtual 88	com/google/android/gms/common/stats/zza:zza	(Landroid/content/Context;Landroid/content/ServiceConnection;)V
    //   101: aload_0
    //   102: invokevirtual 47	java/lang/Object:notifyAll	()V
    //   105: aload_0
    //   106: monitorexit
    //   107: return
    //   108: astore_1
    //   109: aload_0
    //   110: monitorexit
    //   111: aload_1
    //   112: athrow
    //   113: aload 4
    //   115: astore_1
    //   116: aload_0
    //   117: getfield 21	com/google/android/gms/internal/zzsf$zza:zzaep	Lcom/google/android/gms/internal/zzsf;
    //   120: ldc 90
    //   122: aload 5
    //   124: invokevirtual 94	com/google/android/gms/internal/zzsf:zze	(Ljava/lang/String;Ljava/lang/Object;)V
    //   127: aload_3
    //   128: astore_1
    //   129: goto -52 -> 77
    //   132: astore_2
    //   133: aload_0
    //   134: getfield 21	com/google/android/gms/internal/zzsf$zza:zzaep	Lcom/google/android/gms/internal/zzsf;
    //   137: ldc 96
    //   139: invokevirtual 44	com/google/android/gms/internal/zzsf:zzbT	(Ljava/lang/String;)V
    //   142: goto -65 -> 77
    //   145: astore_1
    //   146: aload_0
    //   147: invokevirtual 47	java/lang/Object:notifyAll	()V
    //   150: aload_1
    //   151: athrow
    //   152: aload_0
    //   153: getfield 98	com/google/android/gms/internal/zzsf$zza:zzaer	Z
    //   156: ifne +34 -> 190
    //   159: aload_0
    //   160: getfield 21	com/google/android/gms/internal/zzsf$zza:zzaep	Lcom/google/android/gms/internal/zzsf;
    //   163: ldc 100
    //   165: invokevirtual 103	com/google/android/gms/internal/zzsf:zzbS	(Ljava/lang/String;)V
    //   168: aload_0
    //   169: getfield 21	com/google/android/gms/internal/zzsf$zza:zzaep	Lcom/google/android/gms/internal/zzsf;
    //   172: invokevirtual 107	com/google/android/gms/internal/zzsf:zznU	()Lcom/google/android/gms/analytics/zzh;
    //   175: new 11	com/google/android/gms/internal/zzsf$zza$1
    //   178: dup
    //   179: aload_0
    //   180: aload_1
    //   181: invokespecial 110	com/google/android/gms/internal/zzsf$zza$1:<init>	(Lcom/google/android/gms/internal/zzsf$zza;Lcom/google/android/gms/internal/zzta;)V
    //   184: invokevirtual 116	com/google/android/gms/analytics/zzh:zzg	(Ljava/lang/Runnable;)V
    //   187: goto -86 -> 101
    //   190: aload_0
    //   191: aload_1
    //   192: putfield 118	com/google/android/gms/internal/zzsf$zza:zzaeq	Lcom/google/android/gms/internal/zzta;
    //   195: goto -94 -> 101
    //   198: astore_1
    //   199: goto -98 -> 101
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	202	0	this	zza
    //   0	202	1	paramComponentName	ComponentName
    //   0	202	2	paramIBinder	android.os.IBinder
    //   31	97	3	localObject1	Object
    //   28	86	4	localObject2	Object
    //   41	82	5	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   20	26	108	finally
    //   101	107	108	finally
    //   109	111	108	finally
    //   146	152	108	finally
    //   35	43	132	android/os/RemoteException
    //   46	56	132	android/os/RemoteException
    //   59	64	132	android/os/RemoteException
    //   66	75	132	android/os/RemoteException
    //   116	127	132	android/os/RemoteException
    //   11	20	145	finally
    //   35	43	145	finally
    //   46	56	145	finally
    //   59	64	145	finally
    //   66	75	145	finally
    //   81	101	145	finally
    //   116	127	145	finally
    //   133	142	145	finally
    //   152	187	145	finally
    //   190	195	145	finally
    //   81	101	198	java/lang/IllegalArgumentException
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    zzac.zzdj("AnalyticsServiceConnection.onServiceDisconnected");
    this.zzaep.zznU().zzg(new zzsf.zza.2(this, paramComponentName));
  }
  
  /* Error */
  public zzta zzoq()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 21	com/google/android/gms/internal/zzsf$zza:zzaep	Lcom/google/android/gms/internal/zzsf;
    //   4: invokevirtual 134	com/google/android/gms/internal/zzsf:zzmR	()V
    //   7: new 136	android/content/Intent
    //   10: dup
    //   11: ldc 138
    //   13: invokespecial 140	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   16: astore_2
    //   17: aload_2
    //   18: new 142	android/content/ComponentName
    //   21: dup
    //   22: ldc 144
    //   24: ldc 146
    //   26: invokespecial 149	android/content/ComponentName:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: invokevirtual 153	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   32: pop
    //   33: aload_0
    //   34: getfield 21	com/google/android/gms/internal/zzsf$zza:zzaep	Lcom/google/android/gms/internal/zzsf;
    //   37: invokevirtual 82	com/google/android/gms/internal/zzsf:getContext	()Landroid/content/Context;
    //   40: astore_3
    //   41: aload_2
    //   42: ldc 155
    //   44: aload_3
    //   45: invokevirtual 160	android/content/Context:getPackageName	()Ljava/lang/String;
    //   48: invokevirtual 164	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   51: pop
    //   52: invokestatic 78	com/google/android/gms/common/stats/zza:zzyJ	()Lcom/google/android/gms/common/stats/zza;
    //   55: astore 4
    //   57: aload_0
    //   58: monitorenter
    //   59: aload_0
    //   60: aconst_null
    //   61: putfield 118	com/google/android/gms/internal/zzsf$zza:zzaeq	Lcom/google/android/gms/internal/zzta;
    //   64: aload_0
    //   65: iconst_1
    //   66: putfield 98	com/google/android/gms/internal/zzsf$zza:zzaer	Z
    //   69: aload 4
    //   71: aload_3
    //   72: aload_2
    //   73: aload_0
    //   74: getfield 21	com/google/android/gms/internal/zzsf$zza:zzaep	Lcom/google/android/gms/internal/zzsf;
    //   77: invokestatic 85	com/google/android/gms/internal/zzsf:zza	(Lcom/google/android/gms/internal/zzsf;)Lcom/google/android/gms/internal/zzsf$zza;
    //   80: sipush 129
    //   83: invokevirtual 167	com/google/android/gms/common/stats/zza:zza	(Landroid/content/Context;Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   86: istore_1
    //   87: aload_0
    //   88: getfield 21	com/google/android/gms/internal/zzsf$zza:zzaep	Lcom/google/android/gms/internal/zzsf;
    //   91: ldc 169
    //   93: iload_1
    //   94: invokestatic 175	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   97: invokevirtual 177	com/google/android/gms/internal/zzsf:zza	(Ljava/lang/String;Ljava/lang/Object;)V
    //   100: iload_1
    //   101: ifne +12 -> 113
    //   104: aload_0
    //   105: iconst_0
    //   106: putfield 98	com/google/android/gms/internal/zzsf$zza:zzaer	Z
    //   109: aload_0
    //   110: monitorexit
    //   111: aconst_null
    //   112: areturn
    //   113: aload_0
    //   114: aload_0
    //   115: getfield 21	com/google/android/gms/internal/zzsf$zza:zzaep	Lcom/google/android/gms/internal/zzsf;
    //   118: invokevirtual 181	com/google/android/gms/internal/zzsf:zznT	()Lcom/google/android/gms/internal/zzsp;
    //   121: invokevirtual 187	com/google/android/gms/internal/zzsp:zzpr	()J
    //   124: invokevirtual 191	java/lang/Object:wait	(J)V
    //   127: aload_0
    //   128: iconst_0
    //   129: putfield 98	com/google/android/gms/internal/zzsf$zza:zzaer	Z
    //   132: aload_0
    //   133: getfield 118	com/google/android/gms/internal/zzsf$zza:zzaeq	Lcom/google/android/gms/internal/zzta;
    //   136: astore_2
    //   137: aload_0
    //   138: aconst_null
    //   139: putfield 118	com/google/android/gms/internal/zzsf$zza:zzaeq	Lcom/google/android/gms/internal/zzta;
    //   142: aload_2
    //   143: ifnonnull +12 -> 155
    //   146: aload_0
    //   147: getfield 21	com/google/android/gms/internal/zzsf$zza:zzaep	Lcom/google/android/gms/internal/zzsf;
    //   150: ldc 193
    //   152: invokevirtual 44	com/google/android/gms/internal/zzsf:zzbT	(Ljava/lang/String;)V
    //   155: aload_0
    //   156: monitorexit
    //   157: aload_2
    //   158: areturn
    //   159: astore_2
    //   160: aload_0
    //   161: monitorexit
    //   162: aload_2
    //   163: athrow
    //   164: astore_2
    //   165: aload_0
    //   166: getfield 21	com/google/android/gms/internal/zzsf$zza:zzaep	Lcom/google/android/gms/internal/zzsf;
    //   169: ldc 195
    //   171: invokevirtual 103	com/google/android/gms/internal/zzsf:zzbS	(Ljava/lang/String;)V
    //   174: goto -47 -> 127
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	this	zza
    //   86	15	1	bool	boolean
    //   16	142	2	localObject1	Object
    //   159	4	2	localObject2	Object
    //   164	1	2	localInterruptedException	java.lang.InterruptedException
    //   40	32	3	localContext	android.content.Context
    //   55	15	4	localzza	com.google.android.gms.common.stats.zza
    // Exception table:
    //   from	to	target	type
    //   59	100	159	finally
    //   104	111	159	finally
    //   113	127	159	finally
    //   127	142	159	finally
    //   146	155	159	finally
    //   155	157	159	finally
    //   160	162	159	finally
    //   165	174	159	finally
    //   113	127	164	java/lang/InterruptedException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.internal.zzsf.zza
 * JD-Core Version:    0.7.0.1
 */