package com.tencent.mm.ca;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public final class g
{
  public int ELu;
  public int ELv;
  public long ELw;
  public long ELx;
  public long ELy;
  public f ELz;
  
  private g(Context paramContext)
  {
    AppMethodBeat.i(189871);
    this.ELz = new f.b(paramContext, "recovery_setting");
    this.ELz.eCw();
    this.ELu = Math.max(this.ELz.getInt("setting_threshold_1", 3), 2);
    this.ELv = Math.max(this.ELz.getInt("setting_threshold_2", 4), 3);
    if (this.ELv < this.ELu) {
      this.ELv = this.ELu;
    }
    this.ELw = Math.max(this.ELz.getLong("setting_crash_interval", 10000L), 5000L);
    this.ELx = Math.max(this.ELz.getLong("setting_crash_minimal_interval", 1000L), 0L);
    this.ELy = Math.max(this.ELz.getLong("setting_reset_delay", 5000L), 1000L);
    AppMethodBeat.o(189871);
  }
  
  public static g hv(Context paramContext)
  {
    AppMethodBeat.i(189870);
    paramContext = new g(paramContext);
    AppMethodBeat.o(189870);
    return paramContext;
  }
  
  public static final class a
  {
    public final f ELz;
    public boolean mEnabled;
    
    private a(Context paramContext)
    {
      AppMethodBeat.i(189865);
      this.ELz = new f.a(paramContext, "recovery_enable").eCw();
      this.mEnabled = this.ELz.getBoolean("enable", true);
      AppMethodBeat.o(189865);
    }
    
    public static a hw(Context paramContext)
    {
      AppMethodBeat.i(189864);
      paramContext = new a(paramContext);
      AppMethodBeat.o(189864);
      return paramContext;
    }
  }
  
  public static final class b
  {
    public String ELA;
    private final f ELz;
    private final Context mContext;
    
    private b(Context paramContext)
    {
      AppMethodBeat.i(189867);
      this.mContext = paramContext;
      this.ELz = new f.b(paramContext, "recovery_log").eCA();
      this.ELA = this.ELz.getString("setting_log_path", new File(k.hB(paramContext), ".log").getAbsolutePath());
      AppMethodBeat.o(189867);
    }
    
    public static b hx(Context paramContext)
    {
      AppMethodBeat.i(189866);
      paramContext = new b(paramContext);
      AppMethodBeat.o(189866);
      return paramContext;
    }
    
    public final void eCD()
    {
      AppMethodBeat.i(189868);
      a.a.F(new File(this.ELA));
      AppMethodBeat.o(189868);
    }
    
    /* Error */
    public final String eCE()
    {
      // Byte code:
      //   0: ldc 91
      //   2: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: new 44	java/io/File
      //   8: dup
      //   9: aload_0
      //   10: getfield 67	com/tencent/mm/ca/g$b:ELA	Ljava/lang/String;
      //   13: invokespecial 81	java/io/File:<init>	(Ljava/lang/String;)V
      //   16: astore_1
      //   17: aload_1
      //   18: invokevirtual 95	java/io/File:exists	()Z
      //   21: ifne +10 -> 31
      //   24: ldc 91
      //   26: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   29: aconst_null
      //   30: areturn
      //   31: new 97	java/lang/StringBuilder
      //   34: dup
      //   35: invokespecial 98	java/lang/StringBuilder:<init>	()V
      //   38: astore_3
      //   39: new 100	java/io/BufferedReader
      //   42: dup
      //   43: new 102	java/io/FileReader
      //   46: dup
      //   47: aload_1
      //   48: invokespecial 104	java/io/FileReader:<init>	(Ljava/io/File;)V
      //   51: invokespecial 107	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
      //   54: astore_2
      //   55: aload_2
      //   56: astore_1
      //   57: aload_2
      //   58: invokevirtual 110	java/io/BufferedReader:readLine	()Ljava/lang/String;
      //   61: astore 4
      //   63: aload 4
      //   65: ifnull +46 -> 111
      //   68: aload_2
      //   69: astore_1
      //   70: aload_3
      //   71: aload 4
      //   73: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   76: pop
      //   77: aload_2
      //   78: astore_1
      //   79: aload_3
      //   80: bipush 10
      //   82: invokevirtual 117	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
      //   85: pop
      //   86: goto -31 -> 55
      //   89: astore_3
      //   90: aload_2
      //   91: astore_1
      //   92: ldc 119
      //   94: ldc 121
      //   96: aload_3
      //   97: invokestatic 127	com/tencent/mm/ca/a:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   100: aload_2
      //   101: invokestatic 133	com/tencent/mm/ca/k$b:closeQuietly	(Ljava/lang/Object;)V
      //   104: ldc 91
      //   106: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   109: aconst_null
      //   110: areturn
      //   111: aload_2
      //   112: invokestatic 133	com/tencent/mm/ca/k$b:closeQuietly	(Ljava/lang/Object;)V
      //   115: aload_3
      //   116: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   119: astore_1
      //   120: ldc 91
      //   122: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   125: aload_1
      //   126: areturn
      //   127: astore_2
      //   128: aconst_null
      //   129: astore_1
      //   130: aload_1
      //   131: invokestatic 133	com/tencent/mm/ca/k$b:closeQuietly	(Ljava/lang/Object;)V
      //   134: ldc 91
      //   136: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   139: aload_2
      //   140: athrow
      //   141: astore_2
      //   142: goto -12 -> 130
      //   145: astore_3
      //   146: aconst_null
      //   147: astore_2
      //   148: goto -58 -> 90
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	151	0	this	b
      //   16	115	1	localObject1	Object
      //   54	58	2	localBufferedReader	java.io.BufferedReader
      //   127	13	2	localObject2	Object
      //   141	1	2	localObject3	Object
      //   147	1	2	localObject4	Object
      //   38	42	3	localStringBuilder	java.lang.StringBuilder
      //   89	27	3	localIOException1	java.io.IOException
      //   145	1	3	localIOException2	java.io.IOException
      //   61	11	4	str	String
      // Exception table:
      //   from	to	target	type
      //   57	63	89	java/io/IOException
      //   70	77	89	java/io/IOException
      //   79	86	89	java/io/IOException
      //   39	55	127	finally
      //   57	63	141	finally
      //   70	77	141	finally
      //   79	86	141	finally
      //   92	100	141	finally
      //   39	55	145	java/io/IOException
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ca.g
 * JD-Core Version:    0.7.0.1
 */