package com.tencent.mm.plugin.mmsight;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Point;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.media.MediaMetadataRetriever;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.i;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.af;
import com.tencent.mm.vfs.b;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public final class d
{
  private static boolean oFA;
  private static int oFB;
  private static int oFC;
  private static ConcurrentHashMap<String, Long> oFD;
  private static float oFz;
  
  static
  {
    AppMethodBeat.i(76424);
    oFz = 0.01F;
    oFA = false;
    oFB = 0;
    oFC = 0;
    oFD = new ConcurrentHashMap();
    AppMethodBeat.o(76424);
  }
  
  public static String TU(String paramString)
  {
    AppMethodBeat.i(140117);
    int i = oFB;
    oFB = i + 1;
    b localb1 = new b(String.format("%s/tempvideo%s.mp4", new Object[] { paramString, Integer.valueOf(i) }));
    if (localb1.exists()) {
      localb1.delete();
    }
    b localb2 = new b(com.tencent.mm.vfs.j.p(localb1.dQJ()) + ".remux");
    if (localb2.exists()) {
      localb2.delete();
    }
    localb2 = new b(localb1.dQK() + ".thumb");
    if (localb2.exists()) {
      localb2.delete();
    }
    localb2 = new b(localb1.dQK() + ".soundmp4");
    if (localb2.exists()) {
      localb2.delete();
    }
    i.O(new d.1(oFB - 3, paramString));
    paramString = com.tencent.mm.vfs.j.p(localb1.dQJ());
    AppMethodBeat.o(140117);
    return paramString;
  }
  
  public static String TV(String paramString)
  {
    AppMethodBeat.i(76401);
    paramString = new b(String.format("%s/%s.mp4", new Object[] { paramString, Long.valueOf(System.currentTimeMillis()) }));
    if (paramString.exists()) {
      paramString.delete();
    }
    paramString = com.tencent.mm.vfs.j.p(paramString.dQJ());
    AppMethodBeat.o(76401);
    return paramString;
  }
  
  public static String TW(String paramString)
  {
    AppMethodBeat.i(140118);
    paramString = bo.bf(paramString, "") + ".thumb";
    AppMethodBeat.o(140118);
    return paramString;
  }
  
  public static String TX(String paramString)
  {
    AppMethodBeat.i(76412);
    try
    {
      paramString = com.tencent.mm.plugin.sight.base.d.TX(paramString);
      AppMethodBeat.o(76412);
      return paramString;
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.MMSightUtil", "getMediaInfo error: %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(76412);
    }
    return null;
  }
  
  public static String TY(String paramString)
  {
    AppMethodBeat.i(76413);
    paramString = com.tencent.mm.compatible.util.e.esr + String.format("%s%d.%s", new Object[] { "wx_camera_", Long.valueOf(System.currentTimeMillis()), paramString });
    AppMethodBeat.o(76413);
    return paramString;
  }
  
  public static void TZ(String paramString)
  {
    AppMethodBeat.i(76414);
    ab.i("MicroMsg.MMSightUtil", "setTime key %s %s", new Object[] { paramString, bo.dtY().toString() });
    oFD.put(paramString, Long.valueOf(System.currentTimeMillis()));
    AppMethodBeat.o(76414);
  }
  
  public static long Ua(String paramString)
  {
    AppMethodBeat.i(76415);
    if (oFD.containsKey(paramString))
    {
      long l1 = ((Long)oFD.get(paramString)).longValue();
      long l2 = System.currentTimeMillis();
      AppMethodBeat.o(76415);
      return l2 - l1;
    }
    AppMethodBeat.o(76415);
    return 0L;
  }
  
  public static Point a(Point paramPoint1, Point paramPoint2, boolean paramBoolean)
  {
    AppMethodBeat.i(76405);
    paramPoint1 = a(paramPoint1, paramPoint2, paramBoolean, false);
    AppMethodBeat.o(76405);
    return paramPoint1;
  }
  
  public static Point a(Point paramPoint1, Point paramPoint2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(76406);
    int n = paramPoint2.x;
    int i1 = paramPoint2.y;
    int j;
    int k;
    label37:
    int i;
    if (paramBoolean1)
    {
      j = paramPoint1.y;
      if (!paramBoolean1) {
        break label206;
      }
      k = paramPoint1.x;
      int m = (int)(n * (k / j));
      i = m;
      if (m % 2 != 0) {
        i = m - 1;
      }
      float f = i1;
      j = (int)(j / k * f);
      if (!paramBoolean2) {
        break label229;
      }
      i = eE(i, paramPoint2.y);
    }
    label206:
    label229:
    for (;;)
    {
      ab.i("MicroMsg.MMSightUtil", "getCropPreviewSizeWithHeight, previewSize: %s, displaySize: %s, width: %s, newHeight: %s makeMediaCodecHappy %s, newWidth: %s, isRoate: %s", new Object[] { paramPoint2, paramPoint1, Integer.valueOf(n), Integer.valueOf(i), Boolean.valueOf(paramBoolean2), Integer.valueOf(j), Boolean.valueOf(paramBoolean1) });
      if ((i <= paramPoint2.y) && (n <= paramPoint2.x))
      {
        paramPoint1 = new Point(n, i);
        AppMethodBeat.o(76406);
        return paramPoint1;
        j = paramPoint1.x;
        break;
        k = paramPoint1.y;
        break label37;
      }
      ab.i("MicroMsg.MMSightUtil", "can not adapt to screen");
      AppMethodBeat.o(76406);
      return null;
    }
  }
  
  public static void a(com.tencent.mm.plugin.mmsight.model.a.d paramd, SightParams paramSightParams)
  {
    AppMethodBeat.i(76400);
    String str1 = paramSightParams.oFS;
    String str2 = paramSightParams.oFQ;
    paramSightParams = paramSightParams.oFR;
    if ((!bo.isNullOrNil(str1)) && (!bo.isNullOrNil(str2)) && (!bo.isNullOrNil(paramSightParams)))
    {
      ab.i("MicroMsg.MMSightUtil", "setMMSightRecorderPathByTalker, fileName: %s, filePath: %s, thumbPath: %s", new Object[] { str1, str2, paramSightParams });
      paramd.setFilePath(str2);
      paramd.mV(paramSightParams);
    }
    for (;;)
    {
      paramSightParams = CaptureMMProxy.getInstance().getSubCoreImageFullPath("capture_" + System.currentTimeMillis());
      ab.i("MicroMsg.MMSightUtil", "captureImagePath %s", new Object[] { paramSightParams });
      paramd.mW(paramSightParams);
      AppMethodBeat.o(76400);
      return;
      paramSightParams = TU(CaptureMMProxy.getInstance().getAccVideoPath());
      str1 = TW(paramSightParams);
      ab.i("MicroMsg.MMSightUtil", "setMMSightRecorderPathDefault, filePath: %s, thumbPath: %s", new Object[] { paramSightParams, str1 });
      paramd.setFilePath(paramSightParams);
      paramd.mV(str1);
    }
  }
  
  public static boolean a(int paramInt1, int paramInt2, int paramInt3, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(76421);
    float f;
    int i;
    int j;
    if ((paramInt3 > 0) && (Math.min(paramInt1, paramInt2) > paramInt3)) {
      if (paramInt1 < paramInt2)
      {
        f = paramInt1 * 1.0F / paramInt3;
        i = (int)(paramInt2 / f);
        j = paramInt3;
      }
    }
    for (boolean bool = true;; bool = false)
    {
      paramPInt1.value = j;
      paramPInt2.value = i;
      ab.d("MicroMsg.MMSightUtil", "check bitmap size result[%b] raw[%d %d] minSize[%d] out[%d %d]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value) });
      AppMethodBeat.o(76421);
      return bool;
      f = paramInt2 * 1.0F / paramInt3;
      j = (int)(paramInt1 / f);
      i = paramInt3;
      break;
      i = paramInt2;
      j = paramInt1;
    }
  }
  
  public static boolean a(Context paramContext, Point paramPoint, boolean paramBoolean)
  {
    AppMethodBeat.i(76404);
    paramContext = ex(paramContext);
    float f2 = paramContext.y / paramContext.x;
    if (paramBoolean) {}
    for (float f1 = paramPoint.x / paramPoint.y;; f1 = paramPoint.y / paramPoint.x)
    {
      float f3 = Math.abs(f2 - f1);
      ab.i("MicroMsg.MMSightUtil", "checkIfNeedUsePreviewLarge: previewSize: %s, displaySize: %s, displayRatio: %s, previewRatio: %s, diff: %s", new Object[] { paramPoint, paramContext, Float.valueOf(f2), Float.valueOf(f1), Float.valueOf(f3) });
      if (f3 <= oFz) {
        break;
      }
      AppMethodBeat.o(76404);
      return true;
    }
    AppMethodBeat.o(76404);
    return false;
  }
  
  public static Bitmap aw(String paramString, long paramLong)
  {
    AppMethodBeat.i(76418);
    if ((bo.isNullOrNil(paramString)) || (!com.tencent.mm.vfs.e.cN(paramString)))
    {
      ab.e("MicroMsg.MMSightUtil", "getVideoThumb, %s not exist!!", new Object[] { paramString });
      AppMethodBeat.o(76418);
      return null;
    }
    ab.i("MicroMsg.MMSightUtil", "getVideoThumb, %s", new Object[] { paramString });
    for (;;)
    {
      try
      {
        Object localObject = new MediaMetadataRetriever();
        ((MediaMetadataRetriever)localObject).setDataSource(paramString);
        int j = bo.getInt(((MediaMetadataRetriever)localObject).extractMetadata(18), -1);
        int i = bo.getInt(((MediaMetadataRetriever)localObject).extractMetadata(19), -1);
        int k = SightVideoJNI.getMp4Rotate(paramString);
        ab.i("MicroMsg.MMSightUtil", "getVideoThumb, width: %s, height: %s, rotate: %s", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(k) });
        Bitmap localBitmap = ((MediaMetadataRetriever)localObject).getFrameAtTime(paramLong, 2);
        ((MediaMetadataRetriever)localObject).release();
        if (localBitmap != null)
        {
          AppMethodBeat.o(76418);
          return localBitmap;
        }
        ab.i("MicroMsg.MMSightUtil", "use MediaMetadataRetriever failed, try ffmpeg");
        if ((j <= 0) || (i <= 0))
        {
          localObject = SightVideoJNI.getSimpleMp4Info(paramString);
          ab.i("MicroMsg.MMSightUtil", "getSimpleMp4Info: %s", new Object[] { localObject });
          localObject = new JSONObject((String)localObject);
          j = ((JSONObject)localObject).getInt("videoWidth");
          i = ((JSONObject)localObject).getInt("videoHeight");
          paramString = MP4MuxerJNI.getVideoThumb(paramString, j, i);
          if (paramString == null)
          {
            ab.e("MicroMsg.MMSightUtil", "getVideoThumb, error, can not get rgb byte!!");
            AppMethodBeat.o(76418);
            return null;
          }
          paramString = ByteBuffer.wrap(paramString);
          localObject = Bitmap.createBitmap(j, i, Bitmap.Config.ARGB_8888);
          ((Bitmap)localObject).copyPixelsFromBuffer(paramString);
          paramString = (String)localObject;
          if (k > 0) {
            paramString = com.tencent.mm.sdk.platformtools.d.b((Bitmap)localObject, k);
          }
          AppMethodBeat.o(76418);
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        ab.printErrStackTrace("MicroMsg.MMSightUtil", paramString, "get video thumb error! %s", new Object[] { paramString.getMessage() });
        AppMethodBeat.o(76418);
        return null;
      }
    }
  }
  
  public static Point b(Point paramPoint1, Point paramPoint2, boolean paramBoolean)
  {
    AppMethodBeat.i(76407);
    paramPoint1 = b(paramPoint1, paramPoint2, paramBoolean, false);
    AppMethodBeat.o(76407);
    return paramPoint1;
  }
  
  public static Point b(Point paramPoint1, Point paramPoint2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(76408);
    int k = paramPoint2.x;
    int m = paramPoint2.y;
    int i;
    if (paramBoolean1)
    {
      i = paramPoint1.y;
      if (!paramBoolean1) {
        break label181;
      }
    }
    label181:
    for (int j = paramPoint1.x;; j = paramPoint1.y)
    {
      float f = m;
      j = (int)(i / j * f);
      i = j;
      if (j % 2 != 0) {
        i = j + 1;
      }
      j = i;
      if (paramBoolean2) {
        j = eE(i, paramPoint2.y);
      }
      ab.i("MicroMsg.MMSightUtil", "getCropPreviewSizeWithHeight, previewSize: %s, displaySize: %s, width: %s, newWidth: %s, makeMediaCodecHappy %s, , isRoate: %s", new Object[] { paramPoint2, paramPoint1, Integer.valueOf(k), Integer.valueOf(j), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean1) });
      if (j > paramPoint2.x) {
        break label190;
      }
      paramPoint1 = new Point(j, m);
      AppMethodBeat.o(76408);
      return paramPoint1;
      i = paramPoint1.x;
      break;
    }
    label190:
    ab.i("MicroMsg.MMSightUtil", "can not adapt to screen");
    AppMethodBeat.o(76408);
    return null;
  }
  
  public static Point bQE()
  {
    AppMethodBeat.i(76403);
    Point localPoint = af.hQ(ah.getContext());
    AppMethodBeat.o(76403);
    return localPoint;
  }
  
  public static String cn(List<Camera.Size> paramList)
  {
    AppMethodBeat.i(76409);
    StringBuffer localStringBuffer = new StringBuffer();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Camera.Size localSize = (Camera.Size)paramList.next();
      localStringBuffer.append("size: " + localSize.height + "," + localSize.width + ";");
    }
    paramList = localStringBuffer.toString();
    AppMethodBeat.o(76409);
    return paramList;
  }
  
  public static String co(List<Camera.Size> paramList)
  {
    AppMethodBeat.i(76410);
    StringBuffer localStringBuffer = new StringBuffer();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Camera.Size localSize = (Camera.Size)paramList.next();
      localStringBuffer.append("size: " + localSize.height + "," + localSize.width + " " + localSize.height * 1.0D / localSize.width + "||");
    }
    paramList = localStringBuffer.toString();
    AppMethodBeat.o(76410);
    return paramList;
  }
  
  public static byte[] d(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(76420);
    if (paramInt3 == 0)
    {
      AppMethodBeat.o(76420);
      return paramArrayOfByte;
    }
    byte[] arrayOfByte = com.tencent.mm.plugin.mmsight.model.a.j.oJp.f(Integer.valueOf(paramArrayOfByte.length));
    int i5 = paramInt1 * paramInt2;
    int m;
    int n;
    label58:
    int i1;
    if (paramInt3 % 180 != 0)
    {
      m = 1;
      if (paramInt3 % 270 == 0) {
        break label258;
      }
      n = 1;
      if (paramInt3 < 180) {
        break label264;
      }
      i1 = 1;
      label68:
      paramInt3 = 0;
    }
    for (;;)
    {
      if (paramInt3 >= paramInt2) {
        break label302;
      }
      int i = 0;
      label78:
      if (i < paramInt1)
      {
        int i6 = (paramInt3 >> 1) * paramInt1 + i5 + (i & 0xFFFFFFFE);
        int i2;
        label108:
        int i3;
        label116:
        int j;
        if (m != 0)
        {
          i2 = paramInt2;
          if (m == 0) {
            break label276;
          }
          i3 = paramInt1;
          if (m == 0) {
            break label282;
          }
          j = paramInt3;
          label124:
          if (m == 0) {
            break label289;
          }
        }
        for (int k = i;; k = paramInt3)
        {
          int i4 = j;
          if (n != 0) {
            i4 = i2 - j - 1;
          }
          j = k;
          if (i1 != 0) {
            j = i3 - k - 1;
          }
          k = (j >> 1) * i2 + i5 + (i4 & 0xFFFFFFFE);
          arrayOfByte[(j * i2 + i4)] = ((byte)(paramArrayOfByte[(paramInt3 * paramInt1 + i)] & 0xFF));
          arrayOfByte[k] = ((byte)(paramArrayOfByte[i6] & 0xFF));
          arrayOfByte[(k + 1)] = ((byte)(paramArrayOfByte[(i6 + 1)] & 0xFF));
          i += 1;
          break label78;
          m = 0;
          break;
          n = 0;
          break label58;
          i1 = 0;
          break label68;
          i2 = paramInt1;
          break label108;
          i3 = paramInt2;
          break label116;
          j = i;
          break label124;
        }
      }
      label258:
      label264:
      label276:
      label282:
      label289:
      paramInt3 += 1;
    }
    label302:
    com.tencent.mm.plugin.mmsight.model.a.j.oJp.O(paramArrayOfByte);
    AppMethodBeat.o(76420);
    return arrayOfByte;
  }
  
  private static int e(String paramString, InputStream paramInputStream)
  {
    AppMethodBeat.i(76417);
    byte[] arrayOfByte = new byte[1024];
    for (;;)
    {
      int m;
      int i;
      try
      {
        m = paramInputStream.read(arrayOfByte);
        j = 0;
      }
      catch (NumberFormatException paramString)
      {
        int n;
        AppMethodBeat.o(76417);
        return 0;
      }
      catch (IOException paramString)
      {
        continue;
      }
      int k = i;
      if (j < m)
      {
        n = j - i;
        k = i;
        if (arrayOfByte[j] == paramString.charAt(n))
        {
          if (n == paramString.length() - 1)
          {
            if ((j < 1024) && (arrayOfByte[j] != 10))
            {
              if (Character.isDigit(arrayOfByte[j]))
              {
                i = j + 1;
                if ((i < 1024) && (Character.isDigit(arrayOfByte[i])))
                {
                  i += 1;
                  continue;
                }
                i = bo.apV(new String(arrayOfByte, 0, j, i - j));
                AppMethodBeat.o(76417);
                return i;
              }
              j += 1;
              continue;
            }
            AppMethodBeat.o(76417);
            return 0;
          }
          j += 1;
          continue;
        }
      }
      int j = k + 1;
      if (j < m) {
        if (arrayOfByte[j] != 10)
        {
          k = j;
          if (j != 0) {}
        }
        else
        {
          i = j;
          if (arrayOfByte[j] == 10) {
            i = j + 1;
          }
          j = i;
        }
      }
    }
  }
  
  public static ArrayList<Camera.Size> e(Camera.Parameters paramParameters)
  {
    AppMethodBeat.i(76411);
    paramParameters = new ArrayList(paramParameters.getSupportedPreviewSizes());
    Collections.sort(paramParameters, new d.a((byte)0));
    AppMethodBeat.o(76411);
    return paramParameters;
  }
  
  public static int eE(int paramInt1, int paramInt2)
  {
    int i = paramInt1 % 16;
    if (i == 0) {
      return paramInt1;
    }
    int j = 16 - i + paramInt1;
    if (j < paramInt2) {
      return j;
    }
    return paramInt1 - i;
  }
  
  public static Point ex(Context paramContext)
  {
    AppMethodBeat.i(76402);
    Point localPoint = af.hQ(paramContext);
    if ((!oFA) && (af.hO(paramContext))) {
      localPoint.y -= af.fx(paramContext);
    }
    AppMethodBeat.o(76402);
    return localPoint;
  }
  
  /* Error */
  public static int ey(Context paramContext)
  {
    // Byte code:
    //   0: ldc_w 590
    //   3: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: getstatic 595	android/os/Build$VERSION:SDK_INT	I
    //   9: bipush 16
    //   11: if_icmplt +49 -> 60
    //   14: new 597	android/app/ActivityManager$MemoryInfo
    //   17: dup
    //   18: invokespecial 598	android/app/ActivityManager$MemoryInfo:<init>	()V
    //   21: astore 6
    //   23: aload_0
    //   24: ldc_w 600
    //   27: invokevirtual 606	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   30: checkcast 608	android/app/ActivityManager
    //   33: aload 6
    //   35: invokevirtual 612	android/app/ActivityManager:getMemoryInfo	(Landroid/app/ActivityManager$MemoryInfo;)V
    //   38: aload 6
    //   40: getfield 616	android/app/ActivityManager$MemoryInfo:totalMem	J
    //   43: l2d
    //   44: ldc2_w 617
    //   47: ddiv
    //   48: d2i
    //   49: istore 5
    //   51: ldc_w 590
    //   54: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   57: iload 5
    //   59: ireturn
    //   60: new 620	java/io/FileInputStream
    //   63: dup
    //   64: ldc_w 622
    //   67: invokespecial 623	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   70: astore_0
    //   71: ldc_w 625
    //   74: aload_0
    //   75: invokestatic 627	com/tencent/mm/plugin/mmsight/d:e	(Ljava/lang/String;Ljava/io/InputStream;)I
    //   78: istore 5
    //   80: iload 5
    //   82: i2d
    //   83: dstore_3
    //   84: dload_3
    //   85: dstore_1
    //   86: dload_3
    //   87: dconst_0
    //   88: dcmpl
    //   89: ifle +9 -> 98
    //   92: dload_3
    //   93: ldc2_w 617
    //   96: ddiv
    //   97: dstore_1
    //   98: aload_0
    //   99: invokevirtual 630	java/io/InputStream:close	()V
    //   102: dload_1
    //   103: d2i
    //   104: istore 5
    //   106: ldc_w 590
    //   109: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   112: iload 5
    //   114: ireturn
    //   115: astore 6
    //   117: aload_0
    //   118: invokevirtual 630	java/io/InputStream:close	()V
    //   121: ldc_w 590
    //   124: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   127: aload 6
    //   129: athrow
    //   130: astore_0
    //   131: dconst_0
    //   132: dstore_1
    //   133: goto -31 -> 102
    //   136: astore_0
    //   137: goto -35 -> 102
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	paramContext	Context
    //   85	48	1	d1	double
    //   83	10	3	d2	double
    //   49	64	5	i	int
    //   21	18	6	localMemoryInfo	android.app.ActivityManager.MemoryInfo
    //   115	13	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   71	80	115	finally
    //   60	71	130	java/io/IOException
    //   117	130	130	java/io/IOException
    //   98	102	136	java/io/IOException
  }
  
  public static void jm(boolean paramBoolean)
  {
    oFA = paramBoolean;
  }
  
  public static Bitmap ut(String paramString)
  {
    AppMethodBeat.i(76419);
    paramString = aw(paramString, 0L);
    AppMethodBeat.o(76419);
    return paramString;
  }
  
  public static int zn(int paramInt)
  {
    int i = paramInt;
    if (paramInt % 16 == 0) {
      return paramInt;
    }
    for (;;)
    {
      paramInt = i;
      if (i % 16 == 0) {
        break;
      }
      i += 1;
    }
  }
  
  public static boolean zo(int paramInt)
  {
    return paramInt % 16 == 0;
  }
  
  public static int zp(int paramInt)
  {
    AppMethodBeat.i(76422);
    paramInt = eE(paramInt, 2147483647);
    AppMethodBeat.o(76422);
    return paramInt;
  }
  
  public static int zq(int paramInt)
  {
    AppMethodBeat.i(76423);
    int i = paramInt % 32;
    if (i == 0)
    {
      AppMethodBeat.o(76423);
      return paramInt;
    }
    int j = paramInt - Math.min(32, i);
    if (j < 2147483647)
    {
      AppMethodBeat.o(76423);
      return j;
    }
    AppMethodBeat.o(76423);
    return paramInt - i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.d
 * JD-Core Version:    0.7.0.1
 */