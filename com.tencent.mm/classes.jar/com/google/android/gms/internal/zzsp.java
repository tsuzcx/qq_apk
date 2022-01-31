package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.zzac;
import java.util.HashSet;
import java.util.Set;

public class zzsp
{
  private final zzsc zzabn;
  private volatile Boolean zzaeZ;
  private String zzafa;
  private Set<Integer> zzafb;
  
  protected zzsp(zzsc paramzzsc)
  {
    zzac.zzw(paramzzsc);
    this.zzabn = paramzzsc;
  }
  
  /* Error */
  public boolean zzoW()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 31	com/google/android/gms/internal/zzsp:zzaeZ	Ljava/lang/Boolean;
    //   4: ifnonnull +119 -> 123
    //   7: aload_0
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 31	com/google/android/gms/internal/zzsp:zzaeZ	Ljava/lang/Boolean;
    //   13: ifnonnull +108 -> 121
    //   16: aload_0
    //   17: getfield 26	com/google/android/gms/internal/zzsp:zzabn	Lcom/google/android/gms/internal/zzsc;
    //   20: invokevirtual 37	com/google/android/gms/internal/zzsc:getContext	()Landroid/content/Context;
    //   23: invokevirtual 43	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   26: astore_3
    //   27: invokestatic 49	com/google/android/gms/common/util/zzu:zzzq	()Ljava/lang/String;
    //   30: astore_2
    //   31: aload_3
    //   32: ifnull +30 -> 62
    //   35: aload_3
    //   36: getfield 54	android/content/pm/ApplicationInfo:processName	Ljava/lang/String;
    //   39: astore_3
    //   40: aload_3
    //   41: ifnull +90 -> 131
    //   44: aload_3
    //   45: aload_2
    //   46: invokevirtual 60	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   49: ifeq +82 -> 131
    //   52: iconst_1
    //   53: istore_1
    //   54: aload_0
    //   55: iload_1
    //   56: invokestatic 66	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   59: putfield 31	com/google/android/gms/internal/zzsp:zzaeZ	Ljava/lang/Boolean;
    //   62: aload_0
    //   63: getfield 31	com/google/android/gms/internal/zzsp:zzaeZ	Ljava/lang/Boolean;
    //   66: ifnull +13 -> 79
    //   69: aload_0
    //   70: getfield 31	com/google/android/gms/internal/zzsp:zzaeZ	Ljava/lang/Boolean;
    //   73: invokevirtual 69	java/lang/Boolean:booleanValue	()Z
    //   76: ifne +19 -> 95
    //   79: ldc 71
    //   81: aload_2
    //   82: invokevirtual 60	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   85: ifeq +10 -> 95
    //   88: aload_0
    //   89: getstatic 74	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   92: putfield 31	com/google/android/gms/internal/zzsp:zzaeZ	Ljava/lang/Boolean;
    //   95: aload_0
    //   96: getfield 31	com/google/android/gms/internal/zzsp:zzaeZ	Ljava/lang/Boolean;
    //   99: ifnonnull +22 -> 121
    //   102: aload_0
    //   103: getstatic 74	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   106: putfield 31	com/google/android/gms/internal/zzsp:zzaeZ	Ljava/lang/Boolean;
    //   109: aload_0
    //   110: getfield 26	com/google/android/gms/internal/zzsp:zzabn	Lcom/google/android/gms/internal/zzsc;
    //   113: invokevirtual 78	com/google/android/gms/internal/zzsc:zznS	()Lcom/google/android/gms/internal/zztd;
    //   116: ldc 80
    //   118: invokevirtual 86	com/google/android/gms/internal/zztd:zzbT	(Ljava/lang/String;)V
    //   121: aload_0
    //   122: monitorexit
    //   123: aload_0
    //   124: getfield 31	com/google/android/gms/internal/zzsp:zzaeZ	Ljava/lang/Boolean;
    //   127: invokevirtual 69	java/lang/Boolean:booleanValue	()Z
    //   130: ireturn
    //   131: iconst_0
    //   132: istore_1
    //   133: goto -79 -> 54
    //   136: astore_2
    //   137: aload_0
    //   138: monitorexit
    //   139: aload_2
    //   140: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	this	zzsp
    //   53	80	1	bool	boolean
    //   30	52	2	str	String
    //   136	4	2	localObject1	Object
    //   26	19	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   9	31	136	finally
    //   35	40	136	finally
    //   44	52	136	finally
    //   54	62	136	finally
    //   62	79	136	finally
    //   79	95	136	finally
    //   95	121	136	finally
    //   121	123	136	finally
    //   137	139	136	finally
  }
  
  public boolean zzoX()
  {
    return ((Boolean)zzsw.zzafk.get()).booleanValue();
  }
  
  public int zzoY()
  {
    return ((Integer)zzsw.zzafD.get()).intValue();
  }
  
  public int zzoZ()
  {
    return ((Integer)zzsw.zzafH.get()).intValue();
  }
  
  public int zzpa()
  {
    return ((Integer)zzsw.zzafI.get()).intValue();
  }
  
  public int zzpb()
  {
    return ((Integer)zzsw.zzafJ.get()).intValue();
  }
  
  public long zzpc()
  {
    return ((Long)zzsw.zzafs.get()).longValue();
  }
  
  public long zzpd()
  {
    return ((Long)zzsw.zzafr.get()).longValue();
  }
  
  public long zzpe()
  {
    return ((Long)zzsw.zzafv.get()).longValue();
  }
  
  public long zzpf()
  {
    return ((Long)zzsw.zzafw.get()).longValue();
  }
  
  public int zzpg()
  {
    return ((Integer)zzsw.zzafx.get()).intValue();
  }
  
  public int zzph()
  {
    return ((Integer)zzsw.zzafy.get()).intValue();
  }
  
  public long zzpi()
  {
    return ((Integer)zzsw.zzafL.get()).intValue();
  }
  
  public String zzpj()
  {
    return (String)zzsw.zzafA.get();
  }
  
  public String zzpk()
  {
    return (String)zzsw.zzafz.get();
  }
  
  public String zzpl()
  {
    return (String)zzsw.zzafB.get();
  }
  
  public String zzpm()
  {
    return (String)zzsw.zzafC.get();
  }
  
  public zzsj zzpn()
  {
    return zzsj.zzbY((String)zzsw.zzafE.get());
  }
  
  public zzsm zzpo()
  {
    return zzsm.zzbZ((String)zzsw.zzafF.get());
  }
  
  public Set<Integer> zzpp()
  {
    String str1 = (String)zzsw.zzafK.get();
    String[] arrayOfString;
    HashSet localHashSet;
    int j;
    int i;
    if ((this.zzafb == null) || (this.zzafa == null) || (!this.zzafa.equals(str1)))
    {
      arrayOfString = TextUtils.split(str1, ",");
      localHashSet = new HashSet();
      j = arrayOfString.length;
      i = 0;
    }
    for (;;)
    {
      String str2;
      if (i < j) {
        str2 = arrayOfString[i];
      }
      try
      {
        localHashSet.add(Integer.valueOf(Integer.parseInt(str2)));
        label85:
        i += 1;
        continue;
        this.zzafa = str1;
        this.zzafb = localHashSet;
        return this.zzafb;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        break label85;
      }
    }
  }
  
  public long zzpq()
  {
    return ((Long)zzsw.zzafT.get()).longValue();
  }
  
  public long zzpr()
  {
    return ((Long)zzsw.zzafU.get()).longValue();
  }
  
  public long zzps()
  {
    return ((Long)zzsw.zzafX.get()).longValue();
  }
  
  public int zzpt()
  {
    return ((Integer)zzsw.zzafo.get()).intValue();
  }
  
  public int zzpu()
  {
    return ((Integer)zzsw.zzafq.get()).intValue();
  }
  
  public String zzpv()
  {
    return "google_analytics_v4.db";
  }
  
  public int zzpw()
  {
    return ((Integer)zzsw.zzafN.get()).intValue();
  }
  
  public int zzpx()
  {
    return ((Integer)zzsw.zzafO.get()).intValue();
  }
  
  public long zzpy()
  {
    return ((Long)zzsw.zzafP.get()).longValue();
  }
  
  public long zzpz()
  {
    return ((Long)zzsw.zzafY.get()).longValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.internal.zzsp
 * JD-Core Version:    0.7.0.1
 */