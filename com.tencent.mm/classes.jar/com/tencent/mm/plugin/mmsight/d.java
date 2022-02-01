package com.tencent.mm.plugin.mmsight;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Point;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.media.MediaMetadataRetriever;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.y;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.model.i;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.f;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo.WhichApp;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.ui.ar;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
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
  private static float EXS;
  private static boolean EXT;
  private static int EXU;
  private static int EXV;
  private static ConcurrentHashMap<String, Long> EXW;
  
  static
  {
    AppMethodBeat.i(89312);
    EXS = 0.01F;
    EXT = false;
    EXU = 0;
    EXV = 0;
    EXW = new ConcurrentHashMap();
    AppMethodBeat.o(89312);
  }
  
  public static int WV(int paramInt)
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
  
  public static boolean WW(int paramInt)
  {
    return paramInt % 16 == 0;
  }
  
  public static int WX(int paramInt)
  {
    AppMethodBeat.i(89310);
    paramInt = id(paramInt, 2147483647);
    AppMethodBeat.o(89310);
    return paramInt;
  }
  
  public static int WY(int paramInt)
  {
    AppMethodBeat.i(89311);
    int i = paramInt % 32;
    if (i == 0)
    {
      AppMethodBeat.o(89311);
      return paramInt;
    }
    int j = paramInt - Math.min(32, i);
    if (j < 2147483647)
    {
      AppMethodBeat.o(89311);
      return j;
    }
    AppMethodBeat.o(89311);
    return paramInt - i;
  }
  
  public static Bitmap Xd(String paramString)
  {
    AppMethodBeat.i(89307);
    paramString = bb(paramString, 0L);
    AppMethodBeat.o(89307);
    return paramString;
  }
  
  public static Point a(Point paramPoint1, Point paramPoint2, boolean paramBoolean)
  {
    AppMethodBeat.i(89292);
    paramPoint1 = a(paramPoint1, paramPoint2, paramBoolean, false);
    AppMethodBeat.o(89292);
    return paramPoint1;
  }
  
  public static Point a(Point paramPoint1, Point paramPoint2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(89293);
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
      i = id(i, paramPoint2.y);
    }
    label206:
    label229:
    for (;;)
    {
      Log.i("MicroMsg.MMSightUtil", "getCropPreviewSizeWithHeight, previewSize: %s, displaySize: %s, width: %s, newHeight: %s makeMediaCodecHappy %s, newWidth: %s, isRoate: %s", new Object[] { paramPoint2, paramPoint1, Integer.valueOf(n), Integer.valueOf(i), Boolean.valueOf(paramBoolean2), Integer.valueOf(j), Boolean.valueOf(paramBoolean1) });
      if ((i <= paramPoint2.y) && (n <= paramPoint2.x))
      {
        paramPoint1 = new Point(n, i);
        AppMethodBeat.o(89293);
        return paramPoint1;
        j = paramPoint1.x;
        break;
        k = paramPoint1.y;
        break label37;
      }
      Log.i("MicroMsg.MMSightUtil", "can not adapt to screen");
      AppMethodBeat.o(89293);
      return null;
    }
  }
  
  public static String a(Size[] paramArrayOfSize)
  {
    AppMethodBeat.i(89298);
    StringBuffer localStringBuffer = new StringBuffer();
    int j = paramArrayOfSize.length;
    int i = 0;
    while (i < j)
    {
      Size localSize = paramArrayOfSize[i];
      localStringBuffer.append("size: " + localSize.getHeight() + "," + localSize.getWidth() + " " + localSize.getHeight() * 1.0D / localSize.getWidth() + "||");
      i += 1;
    }
    paramArrayOfSize = localStringBuffer.toString();
    AppMethodBeat.o(89298);
    return paramArrayOfSize;
  }
  
  public static void a(com.tencent.mm.plugin.mmsight.model.a.d paramd, SightParams paramSightParams)
  {
    AppMethodBeat.i(89285);
    String str1 = paramSightParams.EYl;
    String str2 = paramSightParams.EYj;
    paramSightParams = paramSightParams.EYk;
    if ((!Util.isNullOrNil(str1)) && (!Util.isNullOrNil(str2)) && (!Util.isNullOrNil(paramSightParams)))
    {
      Log.i("MicroMsg.MMSightUtil", "setMMSightRecorderPathByTalker, fileName: %s, filePath: %s, thumbPath: %s", new Object[] { str1, str2, paramSightParams });
      paramd.setFilePath(str2);
      paramd.ON(paramSightParams);
    }
    for (;;)
    {
      paramSightParams = CaptureMMProxy.getInstance().getSubCoreImageFullPath("capture_" + System.currentTimeMillis());
      Log.i("MicroMsg.MMSightUtil", "captureImagePath %s", new Object[] { paramSightParams });
      paramd.OO(paramSightParams);
      AppMethodBeat.o(89285);
      return;
      paramSightParams = aPt(CaptureMMProxy.getInstance().getAccVideoPath());
      str1 = aPv(paramSightParams);
      Log.i("MicroMsg.MMSightUtil", "setMMSightRecorderPathDefault, filePath: %s, thumbPath: %s", new Object[] { paramSightParams, str1 });
      paramd.setFilePath(paramSightParams);
      paramd.ON(str1);
    }
  }
  
  public static boolean a(int paramInt1, int paramInt2, int paramInt3, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(89309);
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
      Log.d("MicroMsg.MMSightUtil", "check bitmap size result[%b] raw[%d %d] minSize[%d] out[%d %d]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value) });
      AppMethodBeat.o(89309);
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
    AppMethodBeat.i(89291);
    paramContext = hv(paramContext);
    float f2 = paramContext.y / paramContext.x;
    if (paramBoolean) {}
    for (float f1 = paramPoint.x / paramPoint.y;; f1 = paramPoint.y / paramPoint.x)
    {
      float f3 = Math.abs(f2 - f1);
      Log.i("MicroMsg.MMSightUtil", "checkIfNeedUsePreviewLarge: previewSize: %s, displaySize: %s, displayRatio: %s, previewRatio: %s, diff: %s", new Object[] { paramPoint, paramContext, Float.valueOf(f2), Float.valueOf(f1), Float.valueOf(f3) });
      if (f3 <= EXS) {
        break;
      }
      AppMethodBeat.o(89291);
      return true;
    }
    AppMethodBeat.o(89291);
    return false;
  }
  
  public static String aPt(String paramString)
  {
    AppMethodBeat.i(89286);
    int i = EXU;
    EXU = i + 1;
    q localq1 = new q(String.format("%s/tempvideo%s.mp4", new Object[] { paramString, Integer.valueOf(i) }));
    if (localq1.ifE()) {
      localq1.cFq();
    }
    q localq2 = new q(localq1.bOF() + ".remux");
    if (localq2.ifE()) {
      localq2.cFq();
    }
    localq2 = new q(localq1.ifG() + ".thumb");
    if (localq2.ifE()) {
      localq2.cFq();
    }
    localq2 = new q(localq1.ifG() + ".soundmp4");
    if (localq2.ifE()) {
      localq2.cFq();
    }
    i.am(new d.1(EXU - 3, paramString));
    paramString = localq1.bOF();
    AppMethodBeat.o(89286);
    return paramString;
  }
  
  public static String aPu(String paramString)
  {
    AppMethodBeat.i(89287);
    paramString = new q(String.format("%s/%s.mp4", new Object[] { paramString, Long.valueOf(System.currentTimeMillis()) }));
    if (paramString.ifE()) {
      paramString.cFq();
    }
    paramString = paramString.bOF();
    AppMethodBeat.o(89287);
    return paramString;
  }
  
  public static String aPv(String paramString)
  {
    AppMethodBeat.i(89288);
    paramString = Util.nullAs(paramString, "") + ".thumb";
    AppMethodBeat.o(89288);
    return paramString;
  }
  
  public static String aPw(String paramString)
  {
    AppMethodBeat.i(89300);
    try
    {
      paramString = f.aPw(paramString);
      AppMethodBeat.o(89300);
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.MMSightUtil", "getMediaInfo error: %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(89300);
    }
    return null;
  }
  
  public static void aPx(String paramString)
  {
    AppMethodBeat.i(89302);
    Log.i("MicroMsg.MMSightUtil", "setTime key %s %s", new Object[] { paramString, Util.getStack().toString() });
    EXW.put(paramString, Long.valueOf(System.currentTimeMillis()));
    AppMethodBeat.o(89302);
  }
  
  public static long aPy(String paramString)
  {
    AppMethodBeat.i(89303);
    if (EXW.containsKey(paramString))
    {
      long l1 = ((Long)EXW.get(paramString)).longValue();
      long l2 = System.currentTimeMillis();
      AppMethodBeat.o(89303);
      return l2 - l1;
    }
    AppMethodBeat.o(89303);
    return 0L;
  }
  
  public static Point b(Point paramPoint1, Point paramPoint2, boolean paramBoolean)
  {
    AppMethodBeat.i(89294);
    paramPoint1 = b(paramPoint1, paramPoint2, paramBoolean, false);
    AppMethodBeat.o(89294);
    return paramPoint1;
  }
  
  public static Point b(Point paramPoint1, Point paramPoint2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(89295);
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
        j = id(i, paramPoint2.y);
      }
      Log.i("MicroMsg.MMSightUtil", "getCropPreviewSizeWithHeight, previewSize: %s, displaySize: %s, width: %s, newWidth: %s, makeMediaCodecHappy %s, , isRoate: %s", new Object[] { paramPoint2, paramPoint1, Integer.valueOf(k), Integer.valueOf(j), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean1) });
      if (j > paramPoint2.x) {
        break label190;
      }
      paramPoint1 = new Point(j, m);
      AppMethodBeat.o(89295);
      return paramPoint1;
      i = paramPoint1.x;
      break;
    }
    label190:
    Log.i("MicroMsg.MMSightUtil", "can not adapt to screen");
    AppMethodBeat.o(89295);
    return null;
  }
  
  public static Bitmap bb(String paramString, long paramLong)
  {
    AppMethodBeat.i(89306);
    if ((Util.isNullOrNil(paramString)) || (!u.agG(paramString)))
    {
      Log.e("MicroMsg.MMSightUtil", "getVideoThumb, %s not exist!!", new Object[] { paramString });
      AppMethodBeat.o(89306);
      return null;
    }
    Log.i("MicroMsg.MMSightUtil", "getVideoThumb, %s", new Object[] { paramString });
    if ((af.juO != null) && (af.juO.jtJ == 1)) {}
    for (int i = 0;; i = 1) {
      for (;;)
      {
        try
        {
          int m = SightVideoJNI.getMp4RotateVFS(paramString);
          if (i != 0)
          {
            Object localObject = new com.tencent.mm.compatible.i.d();
            ((MediaMetadataRetriever)localObject).setDataSource(u.n(paramString, false));
            j = Util.getInt(((MediaMetadataRetriever)localObject).extractMetadata(18), -1);
            i = Util.getInt(((MediaMetadataRetriever)localObject).extractMetadata(19), -1);
            Log.i("MicroMsg.MMSightUtil", "getVideoThumb, width: %s, height: %s, rotate: %s", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(m) });
            Bitmap localBitmap = ((MediaMetadataRetriever)localObject).getFrameAtTime(paramLong, 2);
            Log.i("MicroMsg.MMSightUtil", "retriever.getFrameAtTime finish");
            ((MediaMetadataRetriever)localObject).release();
            if (localBitmap != null)
            {
              Log.i("MicroMsg.MMSightUtil", "use MediaMetadataRetriever, success! ");
              AppMethodBeat.o(89306);
              return localBitmap;
            }
            Log.i("MicroMsg.MMSightUtil", "use MediaMetadataRetriever failed, try ffmpeg");
            int k;
            if (j > 0)
            {
              k = i;
              if (i > 0) {}
            }
            else
            {
              localObject = SightVideoJNI.getSimpleMp4InfoVFS(paramString);
              Log.i("MicroMsg.MMSightUtil", "getSimpleMp4Info: %s", new Object[] { localObject });
              localObject = new JSONObject((String)localObject);
              j = ((JSONObject)localObject).getInt("videoWidth");
              k = ((JSONObject)localObject).getInt("videoHeight");
            }
            paramString = MP4MuxerJNI.getVideoThumbVFS(paramString, j, k);
            if (paramString == null)
            {
              Log.e("MicroMsg.MMSightUtil", "getVideoThumb, error, can not get rgb byte!!");
              AppMethodBeat.o(89306);
              return null;
            }
            paramString = ByteBuffer.wrap(paramString);
            localObject = Bitmap.createBitmap(j, k, Bitmap.Config.ARGB_8888);
            ((Bitmap)localObject).copyPixelsFromBuffer(paramString);
            paramString = (String)localObject;
            if (m > 0) {
              paramString = BitmapUtil.rotate((Bitmap)localObject, m);
            }
            AppMethodBeat.o(89306);
            return paramString;
          }
        }
        catch (Exception paramString)
        {
          Log.e("MicroMsg.MMSightUtil", "get video thumb error!");
          Log.printErrStackTrace("MicroMsg.MMSightUtil", paramString, "get video thumb error! %s", new Object[] { paramString.getMessage() });
          AppMethodBeat.o(89306);
          return null;
        }
        i = 0;
        int j = 0;
      }
    }
  }
  
  public static byte[] e(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(89308);
    if (paramInt3 == 0)
    {
      AppMethodBeat.o(89308);
      return paramArrayOfByte;
    }
    byte[] arrayOfByte = j.FbH.k(Integer.valueOf(paramArrayOfByte.length));
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
    j.FbH.as(paramArrayOfByte);
    AppMethodBeat.o(89308);
    return arrayOfByte;
  }
  
  public static Point eSY()
  {
    AppMethodBeat.i(89290);
    Point localPoint = ar.au(MMApplicationContext.getContext());
    AppMethodBeat.o(89290);
    return localPoint;
  }
  
  public static ArrayList<Camera.Size> f(Camera.Parameters paramParameters)
  {
    AppMethodBeat.i(89299);
    paramParameters = new ArrayList(paramParameters.getSupportedPreviewSizes());
    Collections.sort(paramParameters, new d.a((byte)0));
    AppMethodBeat.o(89299);
    return paramParameters;
  }
  
  public static String fZ(List<Camera.Size> paramList)
  {
    AppMethodBeat.i(89296);
    StringBuffer localStringBuffer = new StringBuffer();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Camera.Size localSize = (Camera.Size)paramList.next();
      localStringBuffer.append("size: " + localSize.height + "," + localSize.width + ";");
    }
    paramList = localStringBuffer.toString();
    AppMethodBeat.o(89296);
    return paramList;
  }
  
  public static String fl(String paramString, int paramInt)
  {
    AppMethodBeat.i(177006);
    paramString = new q(String.format("%s/%s.mp4", new Object[] { paramString, paramInt + System.currentTimeMillis() }));
    if (paramString.ifE()) {
      paramString.cFq();
    }
    paramString = paramString.bOF();
    AppMethodBeat.o(177006);
    return paramString;
  }
  
  public static String ga(List<Camera.Size> paramList)
  {
    AppMethodBeat.i(89297);
    StringBuffer localStringBuffer = new StringBuffer();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Camera.Size localSize = (Camera.Size)paramList.next();
      localStringBuffer.append("size: " + localSize.height + "," + localSize.width + " " + localSize.height * 1.0D / localSize.width + "||");
    }
    paramList = localStringBuffer.toString();
    AppMethodBeat.o(89297);
    return paramList;
  }
  
  public static String getExportImagePath(String paramString)
  {
    AppMethodBeat.i(89301);
    StringBuilder localStringBuilder = new StringBuilder().append(AndroidMediaUtil.getSysCameraDirPath());
    if (WeChatBrands.AppInfo.current().isMainland()) {}
    for (String str = "wx_camera_";; str = "w_camera_")
    {
      paramString = String.format("%s%d.%s", new Object[] { str, Long.valueOf(System.currentTimeMillis()), paramString });
      AppMethodBeat.o(89301);
      return paramString;
    }
  }
  
  public static Point hv(Context paramContext)
  {
    AppMethodBeat.i(89289);
    Point localPoint = ar.au(paramContext);
    if ((!EXT) && (ar.av(paramContext))) {
      localPoint.y -= ar.aB(paramContext);
    }
    AppMethodBeat.o(89289);
    return localPoint;
  }
  
  /* Error */
  public static int hw(Context paramContext)
  {
    // Byte code:
    //   0: ldc_w 619
    //   3: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: getstatic 624	android/os/Build$VERSION:SDK_INT	I
    //   9: bipush 16
    //   11: if_icmplt +49 -> 60
    //   14: new 626	android/app/ActivityManager$MemoryInfo
    //   17: dup
    //   18: invokespecial 627	android/app/ActivityManager$MemoryInfo:<init>	()V
    //   21: astore 6
    //   23: aload_0
    //   24: ldc_w 629
    //   27: invokevirtual 635	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   30: checkcast 637	android/app/ActivityManager
    //   33: aload 6
    //   35: invokevirtual 641	android/app/ActivityManager:getMemoryInfo	(Landroid/app/ActivityManager$MemoryInfo;)V
    //   38: aload 6
    //   40: getfield 645	android/app/ActivityManager$MemoryInfo:totalMem	J
    //   43: l2d
    //   44: ldc2_w 646
    //   47: ddiv
    //   48: d2i
    //   49: istore 5
    //   51: ldc_w 619
    //   54: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   57: iload 5
    //   59: ireturn
    //   60: ldc_w 649
    //   63: invokestatic 653	com/tencent/mm/vfs/u:Tf	(Ljava/lang/String;)Ljava/io/InputStream;
    //   66: astore_0
    //   67: ldc_w 655
    //   70: aload_0
    //   71: invokestatic 659	com/tencent/mm/plugin/mmsight/d:parseFileForValue	(Ljava/lang/String;Ljava/io/InputStream;)I
    //   74: istore 5
    //   76: iload 5
    //   78: i2d
    //   79: dstore_3
    //   80: dload_3
    //   81: dstore_1
    //   82: dload_3
    //   83: dconst_0
    //   84: dcmpl
    //   85: ifle +9 -> 94
    //   88: dload_3
    //   89: ldc2_w 646
    //   92: ddiv
    //   93: dstore_1
    //   94: aload_0
    //   95: invokevirtual 664	java/io/InputStream:close	()V
    //   98: dload_1
    //   99: d2i
    //   100: istore 5
    //   102: ldc_w 619
    //   105: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   108: iload 5
    //   110: ireturn
    //   111: astore 6
    //   113: aload_0
    //   114: invokevirtual 664	java/io/InputStream:close	()V
    //   117: ldc_w 619
    //   120: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   123: aload 6
    //   125: athrow
    //   126: astore_0
    //   127: dconst_0
    //   128: dstore_1
    //   129: goto -31 -> 98
    //   132: astore_0
    //   133: goto -35 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	paramContext	Context
    //   81	48	1	d1	double
    //   79	10	3	d2	double
    //   49	60	5	i	int
    //   21	18	6	localMemoryInfo	android.app.ActivityManager.MemoryInfo
    //   111	13	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   67	76	111	finally
    //   60	67	126	java/io/IOException
    //   113	126	126	java/io/IOException
    //   94	98	132	java/io/IOException
  }
  
  public static int id(int paramInt1, int paramInt2)
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
  
  private static int parseFileForValue(String paramString, InputStream paramInputStream)
  {
    AppMethodBeat.i(89305);
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
        AppMethodBeat.o(89305);
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
                i = Util.safeParseInt(new String(arrayOfByte, 0, j, i - j));
                AppMethodBeat.o(89305);
                return i;
              }
              j += 1;
              continue;
            }
            AppMethodBeat.o(89305);
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
  
  public static void ue(boolean paramBoolean)
  {
    EXT = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.d
 * JD-Core Version:    0.7.0.1
 */