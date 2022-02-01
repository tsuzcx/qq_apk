package com.tencent.map.tools.internal;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public class u
{
  private static final String a;
  private File b;
  private File c;
  private Context d;
  private String e;
  private String f;
  private long g;
  private File h;
  
  static
  {
    AppMethodBeat.i(180858);
    a = u.class.getSimpleName();
    AppMethodBeat.o(180858);
  }
  
  public u(Context paramContext, File paramFile, String paramString)
  {
    AppMethodBeat.i(193543);
    this.e = "d";
    this.f = (this.e + "_");
    this.g = 20480L;
    if (paramContext == null)
    {
      AppMethodBeat.o(193543);
      return;
    }
    this.d = paramContext.getApplicationContext();
    this.b = paramFile;
    this.c = paramFile;
    this.e = paramString;
    this.f = (this.e + "_");
    this.g = 20480L;
    if (this.h == null)
    {
      paramContext = this.b;
      if (paramContext != null) {
        break label168;
      }
    }
    for (paramContext = null;; paramContext = new File(paramContext, this.e))
    {
      this.h = paramContext;
      if ((this.h != null) && (this.h.exists())) {
        this.h.delete();
      }
      AppMethodBeat.o(193543);
      return;
      label168:
      if (!paramContext.exists()) {
        paramContext.mkdirs();
      }
    }
  }
  
  /* Error */
  public final void a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc 98
    //   2: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ifnull +10 -> 16
    //   9: aload_1
    //   10: arraylength
    //   11: istore_2
    //   12: iload_2
    //   13: ifne +9 -> 22
    //   16: ldc 98
    //   18: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: return
    //   22: aload_0
    //   23: getfield 77	com/tencent/map/tools/internal/u:h	Ljava/io/File;
    //   26: astore 5
    //   28: aload 5
    //   30: ifnonnull +9 -> 39
    //   33: ldc 98
    //   35: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   38: return
    //   39: aload_0
    //   40: getfield 77	com/tencent/map/tools/internal/u:h	Ljava/io/File;
    //   43: invokevirtual 83	java/io/File:exists	()Z
    //   46: ifne +11 -> 57
    //   49: aload_0
    //   50: getfield 77	com/tencent/map/tools/internal/u:h	Ljava/io/File;
    //   53: invokevirtual 101	java/io/File:createNewFile	()Z
    //   56: pop
    //   57: new 103	java/io/BufferedOutputStream
    //   60: dup
    //   61: new 105	java/io/FileOutputStream
    //   64: dup
    //   65: aload_0
    //   66: getfield 77	com/tencent/map/tools/internal/u:h	Ljava/io/File;
    //   69: iconst_1
    //   70: invokespecial 108	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   73: invokespecial 111	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   76: astore 5
    //   78: aload 5
    //   80: aload_1
    //   81: invokevirtual 114	java/io/BufferedOutputStream:write	([B)V
    //   84: aload 5
    //   86: invokevirtual 117	java/io/BufferedOutputStream:flush	()V
    //   89: aload 5
    //   91: invokevirtual 120	java/io/BufferedOutputStream:close	()V
    //   94: aload_0
    //   95: getfield 77	com/tencent/map/tools/internal/u:h	Ljava/io/File;
    //   98: astore_1
    //   99: aload_0
    //   100: getfield 75	com/tencent/map/tools/internal/u:c	Ljava/io/File;
    //   103: astore 5
    //   105: aload 5
    //   107: ifnull +7 -> 114
    //   110: aload_1
    //   111: ifnonnull +64 -> 175
    //   114: ldc 98
    //   116: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   119: return
    //   120: astore_1
    //   121: aconst_null
    //   122: astore 5
    //   124: aload 5
    //   126: ifnull +22 -> 148
    //   129: aload 5
    //   131: invokevirtual 120	java/io/BufferedOutputStream:close	()V
    //   134: ldc 98
    //   136: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   139: return
    //   140: astore_1
    //   141: ldc 98
    //   143: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: return
    //   147: astore_1
    //   148: ldc 98
    //   150: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   153: return
    //   154: astore_1
    //   155: aconst_null
    //   156: astore 5
    //   158: aload 5
    //   160: ifnull +8 -> 168
    //   163: aload 5
    //   165: invokevirtual 120	java/io/BufferedOutputStream:close	()V
    //   168: ldc 98
    //   170: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   173: aload_1
    //   174: athrow
    //   175: invokestatic 126	java/lang/System:currentTimeMillis	()J
    //   178: lstore_3
    //   179: aload_1
    //   180: invokevirtual 129	java/io/File:length	()J
    //   183: aload_0
    //   184: getfield 63	com/tencent/map/tools/internal/u:g	J
    //   187: lcmp
    //   188: ifle +38 -> 226
    //   191: aload_1
    //   192: new 79	java/io/File
    //   195: dup
    //   196: aload 5
    //   198: new 47	java/lang/StringBuilder
    //   201: dup
    //   202: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   205: aload_0
    //   206: getfield 59	com/tencent/map/tools/internal/u:f	Ljava/lang/String;
    //   209: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: lload_3
    //   213: invokevirtual 132	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   216: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokespecial 92	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   222: invokevirtual 136	java/io/File:renameTo	(Ljava/io/File;)Z
    //   225: pop
    //   226: ldc 98
    //   228: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   231: return
    //   232: astore_1
    //   233: goto -139 -> 94
    //   236: astore 5
    //   238: goto -70 -> 168
    //   241: astore_1
    //   242: goto -84 -> 158
    //   245: astore_1
    //   246: goto -122 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	249	0	this	u
    //   0	249	1	paramArrayOfByte	byte[]
    //   11	2	2	i	int
    //   178	35	3	l	long
    //   26	171	5	localObject	Object
    //   236	1	5	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   57	78	120	java/io/IOException
    //   9	12	140	java/lang/Throwable
    //   22	28	140	java/lang/Throwable
    //   39	57	140	java/lang/Throwable
    //   89	94	140	java/lang/Throwable
    //   94	105	140	java/lang/Throwable
    //   129	134	140	java/lang/Throwable
    //   134	139	140	java/lang/Throwable
    //   163	168	140	java/lang/Throwable
    //   168	175	140	java/lang/Throwable
    //   175	226	140	java/lang/Throwable
    //   129	134	147	java/io/IOException
    //   57	78	154	finally
    //   89	94	232	java/io/IOException
    //   163	168	236	java/io/IOException
    //   78	89	241	finally
    //   78	89	245	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.map.tools.internal.u
 * JD-Core Version:    0.7.0.1
 */