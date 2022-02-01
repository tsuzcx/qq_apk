package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.Typeface.CustomFallbackBuilder;
import android.graphics.fonts.Font;
import android.graphics.fonts.Font.Builder;
import android.graphics.fonts.FontFamily.Builder;
import android.graphics.fonts.FontStyle;
import androidx.core.content.a.c.b;
import androidx.core.content.a.c.c;
import androidx.core.d.e.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InputStream;

public final class j
  extends k
{
  public final Typeface a(Context paramContext, Resources paramResources, int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(196129);
    try
    {
      paramContext = new Font.Builder(paramResources, paramInt1).build();
      paramContext = new Typeface.CustomFallbackBuilder(new FontFamily.Builder(paramContext).build()).setStyle(paramContext.getStyle()).build();
      AppMethodBeat.o(196129);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(196129);
    }
    return null;
  }
  
  public final Typeface a(Context paramContext, c.b paramb, Resources paramResources, int paramInt)
  {
    AppMethodBeat.i(196116);
    for (;;)
    {
      int i;
      try
      {
        c.c[] arrayOfc = paramb.bqf;
        int k = arrayOfc.length;
        i = 0;
        paramContext = null;
        if (i < k)
        {
          paramb = arrayOfc[i];
          try
          {
            Font.Builder localBuilder = new Font.Builder(paramResources, paramb.bqk).setWeight(paramb.bqg);
            if (!paramb.bqh) {
              break label216;
            }
            j = 1;
            paramb = localBuilder.setSlant(j).setTtcIndex(paramb.bqj).setFontVariationSettings(paramb.bqi).build();
            if (paramContext == null)
            {
              paramb = new FontFamily.Builder(paramb);
              paramContext = paramb;
            }
            else
            {
              paramContext.addFont(paramb);
            }
          }
          catch (IOException paramb) {}
        }
        if (paramContext == null)
        {
          AppMethodBeat.o(196116);
          return null;
        }
        if ((paramInt & 0x1) != 0)
        {
          i = 700;
          break label222;
          paramb = new FontStyle(i, paramInt);
          paramContext = new Typeface.CustomFallbackBuilder(paramContext.build()).setStyle(paramb).build();
          AppMethodBeat.o(196116);
          return paramContext;
        }
        else
        {
          i = 400;
        }
      }
      catch (Exception paramContext)
      {
        AppMethodBeat.o(196116);
        return null;
      }
      paramInt = 0;
      continue;
      i += 1;
      continue;
      label216:
      int j = 0;
      continue;
      label222:
      if ((paramInt & 0x2) != 0) {
        paramInt = 1;
      }
    }
  }
  
  protected final Typeface a(Context paramContext, InputStream paramInputStream)
  {
    AppMethodBeat.i(196082);
    paramContext = new RuntimeException("Do not use this function in API 29 or later.");
    AppMethodBeat.o(196082);
    throw paramContext;
  }
  
  /* Error */
  public final Typeface a(Context paramContext, e.b[] paramArrayOfb, int paramInt)
  {
    // Byte code:
    //   0: ldc 122
    //   2: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokevirtual 128	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   9: astore 8
    //   11: aload_2
    //   12: arraylength
    //   13: istore 6
    //   15: iconst_0
    //   16: istore 4
    //   18: aconst_null
    //   19: astore_1
    //   20: iload 4
    //   22: iload 6
    //   24: if_icmpge +222 -> 246
    //   27: aload_2
    //   28: iload 4
    //   30: aaload
    //   31: astore 10
    //   33: aload_1
    //   34: astore 7
    //   36: aload 8
    //   38: aload 10
    //   40: getfield 134	androidx/core/d/e$b:mUri	Landroid/net/Uri;
    //   43: ldc 136
    //   45: aconst_null
    //   46: invokevirtual 142	android/content/ContentResolver:openFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/os/ParcelFileDescriptor;
    //   49: astore 9
    //   51: aload 9
    //   53: ifnonnull +34 -> 87
    //   56: aload_1
    //   57: astore 7
    //   59: aload 9
    //   61: ifnull +14 -> 75
    //   64: aload_1
    //   65: astore 7
    //   67: aload 9
    //   69: invokevirtual 147	android/os/ParcelFileDescriptor:close	()V
    //   72: aload_1
    //   73: astore 7
    //   75: iload 4
    //   77: iconst_1
    //   78: iadd
    //   79: istore 4
    //   81: aload 7
    //   83: astore_1
    //   84: goto -64 -> 20
    //   87: new 22	android/graphics/fonts/Font$Builder
    //   90: dup
    //   91: aload 9
    //   93: invokespecial 150	android/graphics/fonts/Font$Builder:<init>	(Landroid/os/ParcelFileDescriptor;)V
    //   96: aload 10
    //   98: getfield 151	androidx/core/d/e$b:bqg	I
    //   101: invokevirtual 81	android/graphics/fonts/Font$Builder:setWeight	(I)Landroid/graphics/fonts/Font$Builder;
    //   104: astore 7
    //   106: aload 10
    //   108: getfield 152	androidx/core/d/e$b:bqh	Z
    //   111: ifeq +70 -> 181
    //   114: iconst_1
    //   115: istore 5
    //   117: aload 7
    //   119: iload 5
    //   121: invokevirtual 88	android/graphics/fonts/Font$Builder:setSlant	(I)Landroid/graphics/fonts/Font$Builder;
    //   124: aload 10
    //   126: getfield 153	androidx/core/d/e$b:bqj	I
    //   129: invokevirtual 94	android/graphics/fonts/Font$Builder:setTtcIndex	(I)Landroid/graphics/fonts/Font$Builder;
    //   132: invokevirtual 29	android/graphics/fonts/Font$Builder:build	()Landroid/graphics/fonts/Font;
    //   135: astore 7
    //   137: aload_1
    //   138: ifnonnull +49 -> 187
    //   141: new 33	android/graphics/fonts/FontFamily$Builder
    //   144: dup
    //   145: aload 7
    //   147: invokespecial 36	android/graphics/fonts/FontFamily$Builder:<init>	(Landroid/graphics/fonts/Font;)V
    //   150: astore 7
    //   152: aload 7
    //   154: astore_1
    //   155: aload_1
    //   156: astore 7
    //   158: aload 9
    //   160: ifnull -85 -> 75
    //   163: aload_1
    //   164: astore 7
    //   166: aload 9
    //   168: invokevirtual 147	android/os/ParcelFileDescriptor:close	()V
    //   171: aload_1
    //   172: astore 7
    //   174: goto -99 -> 75
    //   177: astore_1
    //   178: goto -103 -> 75
    //   181: iconst_0
    //   182: istore 5
    //   184: goto -67 -> 117
    //   187: aload_1
    //   188: aload 7
    //   190: invokevirtual 106	android/graphics/fonts/FontFamily$Builder:addFont	(Landroid/graphics/fonts/Font;)Landroid/graphics/fonts/FontFamily$Builder;
    //   193: pop
    //   194: goto -39 -> 155
    //   197: astore 10
    //   199: aload 9
    //   201: ifnull +8 -> 209
    //   204: aload 9
    //   206: invokevirtual 147	android/os/ParcelFileDescriptor:close	()V
    //   209: aload_1
    //   210: astore 7
    //   212: ldc 122
    //   214: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   217: aload_1
    //   218: astore 7
    //   220: aload 10
    //   222: athrow
    //   223: astore_1
    //   224: ldc 122
    //   226: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   229: aconst_null
    //   230: areturn
    //   231: astore 9
    //   233: aload_1
    //   234: astore 7
    //   236: aload 10
    //   238: aload 9
    //   240: invokevirtual 159	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   243: goto -34 -> 209
    //   246: aload_1
    //   247: ifnonnull +10 -> 257
    //   250: ldc 122
    //   252: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   255: aconst_null
    //   256: areturn
    //   257: iload_3
    //   258: iconst_1
    //   259: iand
    //   260: ifeq +48 -> 308
    //   263: sipush 700
    //   266: istore 4
    //   268: goto +53 -> 321
    //   271: new 108	android/graphics/fonts/FontStyle
    //   274: dup
    //   275: iload 4
    //   277: iload_3
    //   278: invokespecial 111	android/graphics/fonts/FontStyle:<init>	(II)V
    //   281: astore_2
    //   282: new 31	android/graphics/Typeface$CustomFallbackBuilder
    //   285: dup
    //   286: aload_1
    //   287: invokevirtual 39	android/graphics/fonts/FontFamily$Builder:build	()Landroid/graphics/fonts/FontFamily;
    //   290: invokespecial 42	android/graphics/Typeface$CustomFallbackBuilder:<init>	(Landroid/graphics/fonts/FontFamily;)V
    //   293: aload_2
    //   294: invokevirtual 52	android/graphics/Typeface$CustomFallbackBuilder:setStyle	(Landroid/graphics/fonts/FontStyle;)Landroid/graphics/Typeface$CustomFallbackBuilder;
    //   297: invokevirtual 55	android/graphics/Typeface$CustomFallbackBuilder:build	()Landroid/graphics/Typeface;
    //   300: astore_1
    //   301: ldc 122
    //   303: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   306: aload_1
    //   307: areturn
    //   308: sipush 400
    //   311: istore 4
    //   313: goto +8 -> 321
    //   316: iconst_0
    //   317: istore_3
    //   318: goto -47 -> 271
    //   321: iload_3
    //   322: iconst_2
    //   323: iand
    //   324: ifeq -8 -> 316
    //   327: iconst_1
    //   328: istore_3
    //   329: goto -58 -> 271
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	332	0	this	j
    //   0	332	1	paramContext	Context
    //   0	332	2	paramArrayOfb	e.b[]
    //   0	332	3	paramInt	int
    //   16	296	4	i	int
    //   115	68	5	j	int
    //   13	12	6	k	int
    //   34	201	7	localObject1	java.lang.Object
    //   9	28	8	localContentResolver	android.content.ContentResolver
    //   49	156	9	localParcelFileDescriptor	android.os.ParcelFileDescriptor
    //   231	8	9	localThrowable	java.lang.Throwable
    //   31	94	10	localb	e.b
    //   197	40	10	localObject2	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   36	51	177	java/io/IOException
    //   67	72	177	java/io/IOException
    //   166	171	177	java/io/IOException
    //   212	217	177	java/io/IOException
    //   220	223	177	java/io/IOException
    //   236	243	177	java/io/IOException
    //   87	114	197	finally
    //   117	137	197	finally
    //   141	152	197	finally
    //   187	194	197	finally
    //   11	15	223	java/lang/Exception
    //   36	51	223	java/lang/Exception
    //   67	72	223	java/lang/Exception
    //   166	171	223	java/lang/Exception
    //   212	217	223	java/lang/Exception
    //   220	223	223	java/lang/Exception
    //   236	243	223	java/lang/Exception
    //   271	301	223	java/lang/Exception
    //   204	209	231	finally
  }
  
  protected final e.b a(e.b[] paramArrayOfb, int paramInt)
  {
    AppMethodBeat.i(196069);
    paramArrayOfb = new RuntimeException("Do not use this function in API 29 or later.");
    AppMethodBeat.o(196069);
    throw paramArrayOfb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.core.graphics.j
 * JD-Core Version:    0.7.0.1
 */