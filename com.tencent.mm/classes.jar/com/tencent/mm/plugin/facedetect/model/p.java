package com.tencent.mm.plugin.facedetect.model;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.util.Base64;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.model.av;
import com.tencent.mm.plugin.facedetect.FaceProNative.FaceResult;
import com.tencent.mm.pluginsdk.g.a.a.m;
import com.tencent.mm.protocal.protobuf.jy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

public final class p
{
  public static Bitmap Np(String paramString)
  {
    AppMethodBeat.i(266);
    try
    {
      if (bo.isNullOrNil(paramString))
      {
        ab.i("MicroMsg.FaceUtils", "hy: username is null or nil. return");
        AppMethodBeat.o(266);
        return null;
      }
      Object localObject = a.a.mhL + ag.cE(paramString);
      if (!new com.tencent.mm.vfs.b((String)localObject).exists())
      {
        ab.w("MicroMsg.FaceUtils", "hy: no last file. return");
        AppMethodBeat.o(266);
        return null;
      }
      localObject = e.i((String)localObject, 0, -1);
      if (localObject != null)
      {
        paramString = p.a.e((byte[])localObject, Nq(paramString));
        if (paramString.length <= 0)
        {
          ab.w("MicroMsg.FaceUtils", "hy: decrypt err. return null");
          AppMethodBeat.o(266);
          return null;
        }
        paramString = com.tencent.mm.compatible.g.a.decodeByteArray(paramString, 0, paramString.length);
        AppMethodBeat.o(266);
        return paramString;
      }
      ab.w("MicroMsg.FaceUtils", "hy: nothing in file");
      AppMethodBeat.o(266);
      return null;
    }
    catch (Exception paramString)
    {
      ab.printErrStackTrace("MicroMsg.FaceUtils", paramString, "hy: err in encrypt", new Object[0]);
      AppMethodBeat.o(266);
    }
    return null;
  }
  
  private static String Nq(String paramString)
  {
    AppMethodBeat.i(268);
    paramString = Base64.encodeToString((paramString + paramString.hashCode()).getBytes(), 0);
    AppMethodBeat.o(268);
    return paramString;
  }
  
  public static String Nr(String paramString)
  {
    AppMethodBeat.i(282);
    paramString = com.tencent.mm.a.g.w((bo.yB() + ", " + paramString).getBytes());
    AppMethodBeat.o(282);
    return paramString;
  }
  
  public static boolean S(Activity paramActivity)
  {
    AppMethodBeat.i(269);
    boolean bool1 = com.tencent.mm.pluginsdk.permission.b.o(paramActivity, "android.permission.CAMERA");
    boolean bool2 = com.tencent.mm.pluginsdk.permission.b.o(paramActivity, "android.permission.RECORD_AUDIO");
    ab.d("MicroMsg.FaceUtils", "summerper checkPermission checkCamera[%b], checkAudio[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), bo.dtY(), paramActivity });
    ArrayList localArrayList = new ArrayList();
    if (!bool1) {
      localArrayList.add("android.permission.CAMERA");
    }
    if (!bool2) {
      localArrayList.add("android.permission.RECORD_AUDIO");
    }
    if ((!bool1) || (!bool2))
    {
      ab.i("MicroMsg.FaceUtils", "hy: above 23 and no permission. requesting...");
      android.support.v4.app.a.a(paramActivity, (String[])localArrayList.toArray(new String[localArrayList.size()]), 23);
      AppMethodBeat.o(269);
      return false;
    }
    AppMethodBeat.o(269);
    return true;
  }
  
  public static void T(Activity paramActivity)
  {
    AppMethodBeat.i(270);
    paramActivity.getWindow().setFlags(1024, 1024);
    AppMethodBeat.o(270);
  }
  
  public static String a(FaceProNative.FaceResult paramFaceResult)
  {
    AppMethodBeat.i(265);
    if ((paramFaceResult == null) || (paramFaceResult.result != 0))
    {
      ab.e("MicroMsg.FaceUtils", "alvinluo face result is null or result code not 0");
      AppMethodBeat.o(265);
      return null;
    }
    try
    {
      String str = buK();
      jy localjy = new jy();
      localjy.www = com.tencent.mm.bv.b.bL(paramFaceResult.sidedata);
      localjy.wwx = com.tencent.mm.bv.b.bL(paramFaceResult.data);
      d(localjy.toByteArray(), str);
      AppMethodBeat.o(265);
      return str;
    }
    catch (Exception paramFaceResult)
    {
      ab.printErrStackTrace("MicroMsg.FaceUtils", paramFaceResult, "", new Object[0]);
      AppMethodBeat.o(265);
    }
    return null;
  }
  
  public static boolean b(Bitmap paramBitmap, String paramString)
  {
    AppMethodBeat.i(267);
    if (paramBitmap == null) {}
    try
    {
      ab.w("MicroMsg.FaceUtils", "hy: bm is null. abort");
      AppMethodBeat.o(267);
      return false;
    }
    catch (Exception paramBitmap)
    {
      Object localObject1;
      Object localObject2;
      ab.printErrStackTrace("MicroMsg.FaceUtils", paramBitmap, "hy: err in encrypt", new Object[0]);
      AppMethodBeat.o(267);
    }
    if (bo.isNullOrNil(paramString))
    {
      ab.i("MicroMsg.FaceUtils", "hy: username is null or nil. return");
      AppMethodBeat.o(267);
      return false;
    }
    localObject1 = new com.tencent.mm.vfs.b(a.a.mhL);
    if (!((com.tencent.mm.vfs.b)localObject1).exists()) {
      ((com.tencent.mm.vfs.b)localObject1).mkdirs();
    }
    localObject1 = a.a.mhL + ag.cE(paramString);
    localObject2 = new com.tencent.mm.vfs.b((String)localObject1);
    if (!((com.tencent.mm.vfs.b)localObject2).exists())
    {
      ab.i("MicroMsg.FaceUtils", "hy: last file already exists. del");
      ((com.tencent.mm.vfs.b)localObject2).createNewFile();
    }
    localObject2 = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, 85, (OutputStream)localObject2);
    paramBitmap = ((ByteArrayOutputStream)localObject2).toByteArray();
    ((ByteArrayOutputStream)localObject2).close();
    if (paramBitmap != null)
    {
      paramBitmap = p.a.e(paramBitmap, Nq(paramString));
      if (paramBitmap.length <= 0)
      {
        ab.w("MicroMsg.FaceUtils", "hy: enc err. return null");
        AppMethodBeat.o(267);
        return false;
      }
      e.b((String)localObject1, paramBitmap, paramBitmap.length);
      AppMethodBeat.o(267);
      return true;
    }
    ab.w("MicroMsg.FaceUtils", "hy: nothing in stream");
    AppMethodBeat.o(267);
    return false;
    return false;
  }
  
  private static void buE()
  {
    AppMethodBeat.i(271);
    ab.i("MicroMsg.FaceUtils", "hy: trigger start download model file");
    com.tencent.mm.kernel.g.Rc().a(new m(42), 0);
    AppMethodBeat.o(271);
  }
  
  public static boolean buF()
  {
    boolean bool2 = false;
    AppMethodBeat.i(272);
    Object localObject2 = buH();
    Object localObject1 = buI();
    if ((bo.isNullOrNil((String)localObject2)) || (bo.isNullOrNil((String)localObject1)))
    {
      ab.w("MicroMsg.FaceUtils", "hy: not valid model path. start ");
      bool1 = bool2;
      if (!bool1) {
        buE();
      }
      AppMethodBeat.o(272);
      return bool1;
    }
    localObject2 = new com.tencent.mm.vfs.b((String)localObject2);
    localObject1 = new com.tencent.mm.vfs.b((String)localObject1);
    if ((!((com.tencent.mm.vfs.b)localObject2).exists()) && (!vI(0))) {
      ab.e("MicroMsg.FaceUtils", "hy: no detect model in storage and sdcard");
    }
    for (boolean bool1 = false;; bool1 = true)
    {
      if ((!((com.tencent.mm.vfs.b)localObject1).exists()) && (!vI(1)))
      {
        ab.e("MicroMsg.FaceUtils", "hy: no alignment model in storage and sdcard");
        bool1 = bool2;
        break;
      }
      break;
    }
  }
  
  public static String buG()
  {
    AppMethodBeat.i(273);
    if (a.mhJ) {}
    for (String str = h.getExternalStorageDirectory().getAbsolutePath() + "/face_detect";; str = ah.getContext().getFilesDir().getParent() + "/face_detect")
    {
      com.tencent.mm.vfs.b localb = new com.tencent.mm.vfs.b(str);
      if (!localb.exists())
      {
        ab.i("MicroMsg.FaceUtils", "hy: face dir not exist. mk dir");
        localb.mkdirs();
      }
      AppMethodBeat.o(273);
      return str;
    }
  }
  
  public static String buH()
  {
    AppMethodBeat.i(274);
    String str = buG() + "/ufdmtcc.bin";
    AppMethodBeat.o(274);
    return str;
  }
  
  public static String buI()
  {
    AppMethodBeat.i(275);
    String str = buG() + "/ufat.bin";
    AppMethodBeat.o(275);
    return str;
  }
  
  public static String buJ()
  {
    AppMethodBeat.i(276);
    String str = buG() + "/PE.dat";
    AppMethodBeat.o(276);
    return str;
  }
  
  public static String buK()
  {
    AppMethodBeat.i(277);
    String str = buG() + "/release_out.fd";
    AppMethodBeat.o(277);
    return str;
  }
  
  public static void d(byte[] paramArrayOfByte, String paramString)
  {
    AppMethodBeat.i(264);
    try
    {
      e.b(paramString, paramArrayOfByte, paramArrayOfByte.length);
      AppMethodBeat.o(264);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      ab.printErrStackTrace("MicroMsg.FaceUtils", paramArrayOfByte, "hy: err in save debug jpeg", new Object[0]);
      AppMethodBeat.o(264);
    }
  }
  
  public static Bitmap n(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(281);
    long l1 = System.currentTimeMillis();
    if (paramBitmap == null) {
      paramBitmap = null;
    }
    for (;;)
    {
      ab.i("MicroMsg.FaceUtils", "hy: blur using %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
      int i = 1;
      Object localObject = paramBitmap;
      int j;
      if (paramBitmap == null)
      {
        ab.w("MicroMsg.FaceUtils", "hy: null on blur. use default");
        j = 0;
        paramBitmap = Np(paramString);
        localObject = paramBitmap;
        i = j;
        if (paramBitmap == null)
        {
          localObject = com.tencent.mm.sdk.platformtools.d.Na(2130838677);
          i = j;
        }
      }
      if (i != 0) {
        com.tencent.mm.sdk.g.d.post(new p.1((Bitmap)localObject, paramString), "FaceUtils_SaveFile");
      }
      AppMethodBeat.o(281);
      return localObject;
      long l2 = System.currentTimeMillis();
      paramBitmap = Bitmap.createScaledBitmap(paramBitmap, Math.round(paramBitmap.getWidth() * 0.1F), Math.round(paramBitmap.getHeight() * 0.1F), false);
      paramBitmap = paramBitmap.copy(paramBitmap.getConfig(), true);
      int i14 = paramBitmap.getWidth();
      int i15 = paramBitmap.getHeight();
      localObject = new int[i14 * i15];
      ab.e("pix", i14 + " " + i15 + " " + localObject.length);
      paramBitmap.getPixels((int[])localObject, 0, i14, 0, 0, i14, i15);
      int i18 = i14 - 1;
      int i16 = i15 - 1;
      int i17 = i14 * i15;
      int[] arrayOfInt1 = new int[i17];
      int[] arrayOfInt2 = new int[i17];
      int[] arrayOfInt3 = new int[i17];
      int[] arrayOfInt4 = new int[Math.max(i14, i15)];
      int[] arrayOfInt5 = new int[246016];
      i = 0;
      while (i < 246016)
      {
        arrayOfInt5[i] = (i / 961);
        i += 1;
      }
      int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { 61, 3 });
      int i6 = 0;
      int i5 = 0;
      int i7 = 0;
      int i8;
      int i4;
      int i2;
      int n;
      int i3;
      int i1;
      int k;
      int m;
      int i9;
      int[] arrayOfInt6;
      int i12;
      int i10;
      int i11;
      for (;;)
      {
        if (i6 >= i15) {
          break label978;
        }
        if (b.jH(l2))
        {
          paramBitmap = null;
          break;
        }
        i8 = -30;
        i4 = 0;
        i2 = 0;
        n = 0;
        i3 = 0;
        i1 = 0;
        i = 0;
        j = 0;
        k = 0;
        m = 0;
        if (i8 <= 30)
        {
          i9 = localObject[(Math.min(i18, Math.max(i8, 0)) + i7)];
          arrayOfInt6 = arrayOfInt[(i8 + 30)];
          arrayOfInt6[0] = ((0xFF0000 & i9) >> 16);
          arrayOfInt6[1] = ((0xFF00 & i9) >> 8);
          arrayOfInt6[2] = (i9 & 0xFF);
          i9 = 31 - Math.abs(i8);
          j += arrayOfInt6[0] * i9;
          k += arrayOfInt6[1] * i9;
          m += i9 * arrayOfInt6[2];
          if (i8 > 0)
          {
            i4 += arrayOfInt6[0];
            i2 += arrayOfInt6[1];
            n += arrayOfInt6[2];
          }
          for (;;)
          {
            i8 += 1;
            break;
            i3 += arrayOfInt6[0];
            i1 += arrayOfInt6[1];
            i += arrayOfInt6[2];
          }
        }
        int i13 = 30;
        if (b.jH(l2))
        {
          paramBitmap = null;
          break;
        }
        i12 = 0;
        i9 = i4;
        i8 = i2;
        i4 = n;
        i10 = i3;
        i11 = i1;
        n = i13;
        i1 = m;
        i2 = k;
        i3 = j;
        m = i;
        i = i11;
        j = i10;
        k = i12;
        while (k < i14)
        {
          arrayOfInt1[i7] = arrayOfInt5[i3];
          arrayOfInt2[i7] = arrayOfInt5[i2];
          arrayOfInt3[i7] = arrayOfInt5[i1];
          arrayOfInt6 = arrayOfInt[((n - 30 + 61) % 61)];
          i11 = arrayOfInt6[0];
          i10 = arrayOfInt6[1];
          int i19 = arrayOfInt6[2];
          if (i6 == 0) {
            arrayOfInt4[k] = Math.min(k + 30 + 1, i18);
          }
          i12 = localObject[(arrayOfInt4[k] + i5)];
          arrayOfInt6[0] = ((0xFF0000 & i12) >> 16);
          arrayOfInt6[1] = ((0xFF00 & i12) >> 8);
          arrayOfInt6[2] = (i12 & 0xFF);
          i9 += arrayOfInt6[0];
          i8 += arrayOfInt6[1];
          i4 = arrayOfInt6[2] + i4;
          i3 = i3 - j + i9;
          i2 = i2 - i + i8;
          i1 = i1 - m + i4;
          n = (n + 1) % 61;
          arrayOfInt6 = arrayOfInt[(n % 61)];
          i13 = arrayOfInt6[0];
          i12 = arrayOfInt6[1];
          m = m - i19 + arrayOfInt6[2];
          int i21 = arrayOfInt6[0];
          int i20 = arrayOfInt6[1];
          i19 = arrayOfInt6[2];
          i7 += 1;
          k += 1;
          i9 -= i21;
          i8 -= i20;
          i4 -= i19;
          j = j - i11 + i13;
          i = i - i10 + i12;
        }
        i6 += 1;
        i5 += i14;
      }
      label978:
      i = 0;
      for (;;)
      {
        if (i >= i14) {
          break label1560;
        }
        i7 = i14 * -30;
        if (b.jH(l2))
        {
          paramBitmap = null;
          break;
        }
        i6 = -30;
        i5 = 0;
        k = 0;
        j = 0;
        m = 0;
        n = 0;
        i1 = 0;
        i2 = 0;
        i3 = 0;
        i4 = 0;
        if (i6 <= 30)
        {
          i9 = Math.max(0, i7) + i;
          arrayOfInt6 = arrayOfInt[(i6 + 30)];
          arrayOfInt6[0] = arrayOfInt1[i9];
          arrayOfInt6[1] = arrayOfInt2[i9];
          arrayOfInt6[2] = arrayOfInt3[i9];
          i10 = 31 - Math.abs(i6);
          i8 = i2 + arrayOfInt1[i9] * i10;
          i3 += arrayOfInt2[i9] * i10;
          i4 += arrayOfInt3[i9] * i10;
          if (i6 > 0)
          {
            i5 += arrayOfInt6[0];
            k += arrayOfInt6[1];
            j += arrayOfInt6[2];
          }
          for (;;)
          {
            i2 = i7;
            if (i6 < i16) {
              i2 = i7 + i14;
            }
            i6 += 1;
            i7 = i2;
            i2 = i8;
            break;
            m += arrayOfInt6[0];
            n += arrayOfInt6[1];
            i1 += arrayOfInt6[2];
          }
        }
        i7 = 30;
        if (b.jH(l2))
        {
          paramBitmap = null;
          break;
        }
        i9 = 0;
        i8 = i5;
        i6 = i;
        i5 = i9;
        while (i5 < i15)
        {
          localObject[i6] = (0xFF000000 & localObject[i6] | arrayOfInt5[i2] << 16 | arrayOfInt5[i3] << 8 | arrayOfInt5[i4]);
          arrayOfInt6 = arrayOfInt[((i7 - 30 + 61) % 61)];
          i11 = arrayOfInt6[0];
          i10 = arrayOfInt6[1];
          i9 = arrayOfInt6[2];
          if (i == 0) {
            arrayOfInt4[i5] = (Math.min(i5 + 31, i16) * i14);
          }
          i12 = arrayOfInt4[i5] + i;
          arrayOfInt6[0] = arrayOfInt1[i12];
          arrayOfInt6[1] = arrayOfInt2[i12];
          arrayOfInt6[2] = arrayOfInt3[i12];
          i8 += arrayOfInt6[0];
          k += arrayOfInt6[1];
          j += arrayOfInt6[2];
          i2 = i2 - m + i8;
          i3 = i3 - n + k;
          i4 = i4 - i1 + j;
          i7 = (i7 + 1) % 61;
          arrayOfInt6 = arrayOfInt[i7];
          m = m - i11 + arrayOfInt6[0];
          n = n - i10 + arrayOfInt6[1];
          i1 = i1 - i9 + arrayOfInt6[2];
          i8 -= arrayOfInt6[0];
          i9 = arrayOfInt6[1];
          j -= arrayOfInt6[2];
          i6 += i14;
          i5 += 1;
          k -= i9;
        }
        i += 1;
      }
      label1560:
      ab.e("pix", i14 + " " + i15 + " " + i17);
      paramBitmap.setPixels((int[])localObject, 0, i14, 0, 0, i14, i15);
    }
  }
  
  /* Error */
  public static void p(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: sipush 280
    //   3: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 24
    //   8: ldc_w 486
    //   11: iconst_2
    //   12: anewarray 4	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: aload_1
    //   18: aastore
    //   19: dup
    //   20: iconst_1
    //   21: aload_2
    //   22: aastore
    //   23: invokestatic 387	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   26: new 62	com/tencent/mm/vfs/b
    //   29: dup
    //   30: aload_2
    //   31: invokespecial 65	com/tencent/mm/vfs/b:<init>	(Ljava/lang/String;)V
    //   34: astore 6
    //   36: aload_0
    //   37: invokevirtual 490	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   40: aload_1
    //   41: invokevirtual 496	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   44: astore_0
    //   45: new 498	com/tencent/mm/vfs/f
    //   48: dup
    //   49: aload 6
    //   51: invokespecial 501	com/tencent/mm/vfs/f:<init>	(Lcom/tencent/mm/vfs/b;)V
    //   54: astore 5
    //   56: aload 5
    //   58: astore 4
    //   60: aload_0
    //   61: astore_2
    //   62: sipush 1024
    //   65: newarray byte
    //   67: astore 7
    //   69: aload 5
    //   71: astore 4
    //   73: aload_0
    //   74: astore_2
    //   75: aload_0
    //   76: aload 7
    //   78: invokevirtual 507	java/io/InputStream:read	([B)I
    //   81: istore_3
    //   82: iload_3
    //   83: iconst_m1
    //   84: if_icmpeq +70 -> 154
    //   87: aload 5
    //   89: astore 4
    //   91: aload_0
    //   92: astore_2
    //   93: aload 5
    //   95: aload 7
    //   97: iconst_0
    //   98: iload_3
    //   99: invokevirtual 513	java/io/OutputStream:write	([BII)V
    //   102: goto -33 -> 69
    //   105: astore_2
    //   106: aload 5
    //   108: astore_1
    //   109: aload_2
    //   110: astore 5
    //   112: aload_1
    //   113: astore 4
    //   115: aload_0
    //   116: astore_2
    //   117: ldc 24
    //   119: aload 5
    //   121: ldc_w 515
    //   124: iconst_0
    //   125: anewarray 4	java/lang/Object
    //   128: invokestatic 102	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   131: aload_0
    //   132: ifnull +7 -> 139
    //   135: aload_0
    //   136: invokevirtual 516	java/io/InputStream:close	()V
    //   139: aload_1
    //   140: ifnull +7 -> 147
    //   143: aload_1
    //   144: invokevirtual 517	java/io/OutputStream:close	()V
    //   147: sipush 280
    //   150: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   153: return
    //   154: aload 5
    //   156: astore 4
    //   158: aload_0
    //   159: astore_2
    //   160: aload 5
    //   162: invokevirtual 520	java/io/OutputStream:flush	()V
    //   165: aload 5
    //   167: astore 4
    //   169: aload_0
    //   170: astore_2
    //   171: ldc 24
    //   173: ldc_w 522
    //   176: iconst_2
    //   177: anewarray 4	java/lang/Object
    //   180: dup
    //   181: iconst_0
    //   182: aload_1
    //   183: aastore
    //   184: dup
    //   185: iconst_1
    //   186: aload 6
    //   188: invokevirtual 525	com/tencent/mm/vfs/b:length	()J
    //   191: invokestatic 385	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   194: aastore
    //   195: invokestatic 387	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   198: aload_0
    //   199: ifnull +7 -> 206
    //   202: aload_0
    //   203: invokevirtual 516	java/io/InputStream:close	()V
    //   206: aload 5
    //   208: invokevirtual 517	java/io/OutputStream:close	()V
    //   211: sipush 280
    //   214: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   217: return
    //   218: astore_0
    //   219: sipush 280
    //   222: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   225: return
    //   226: astore_0
    //   227: sipush 280
    //   230: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   233: return
    //   234: astore_1
    //   235: aconst_null
    //   236: astore 4
    //   238: aconst_null
    //   239: astore_0
    //   240: aload_0
    //   241: ifnull +7 -> 248
    //   244: aload_0
    //   245: invokevirtual 516	java/io/InputStream:close	()V
    //   248: aload 4
    //   250: ifnull +8 -> 258
    //   253: aload 4
    //   255: invokevirtual 517	java/io/OutputStream:close	()V
    //   258: sipush 280
    //   261: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   264: aload_1
    //   265: athrow
    //   266: astore_0
    //   267: goto -9 -> 258
    //   270: astore_1
    //   271: aconst_null
    //   272: astore 4
    //   274: goto -34 -> 240
    //   277: astore_1
    //   278: aload_2
    //   279: astore_0
    //   280: goto -40 -> 240
    //   283: astore 5
    //   285: aconst_null
    //   286: astore_1
    //   287: aconst_null
    //   288: astore_0
    //   289: goto -177 -> 112
    //   292: astore 5
    //   294: aconst_null
    //   295: astore_1
    //   296: goto -184 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	299	0	paramContext	Context
    //   0	299	1	paramString1	String
    //   0	299	2	paramString2	String
    //   81	18	3	i	int
    //   58	215	4	localObject1	Object
    //   54	153	5	localObject2	Object
    //   283	1	5	localException1	Exception
    //   292	1	5	localException2	Exception
    //   34	153	6	localb	com.tencent.mm.vfs.b
    //   67	29	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   62	69	105	java/lang/Exception
    //   75	82	105	java/lang/Exception
    //   93	102	105	java/lang/Exception
    //   160	165	105	java/lang/Exception
    //   171	198	105	java/lang/Exception
    //   202	206	218	java/lang/Exception
    //   206	211	218	java/lang/Exception
    //   135	139	226	java/lang/Exception
    //   143	147	226	java/lang/Exception
    //   26	45	234	finally
    //   244	248	266	java/lang/Exception
    //   253	258	266	java/lang/Exception
    //   45	56	270	finally
    //   62	69	277	finally
    //   75	82	277	finally
    //   93	102	277	finally
    //   117	131	277	finally
    //   160	165	277	finally
    //   171	198	277	finally
    //   26	45	283	java/lang/Exception
    //   45	56	292	java/lang/Exception
  }
  
  public static boolean vI(int paramInt)
  {
    AppMethodBeat.i(278);
    String str = "";
    switch (paramInt)
    {
    }
    while (bo.isNullOrNil(str))
    {
      ab.w("MicroMsg.FaceUtils", "hy: no such path for type: %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(278);
      return false;
      str = av.flM.Y("LAST_LOGIN_FACE_MODEL_SDCARD_PATH_DETECT", "");
      continue;
      str = av.flM.Y("LAST_LOGIN_FACE_MODEL_SDCARD_PATH_ALIGNMENT", "");
    }
    if (new com.tencent.mm.vfs.b(str).exists())
    {
      com.tencent.mm.vfs.b localb = new com.tencent.mm.vfs.b(vJ(paramInt));
      if (localb.exists()) {
        localb.delete();
      }
      e.C(str, vJ(paramInt));
      AppMethodBeat.o(278);
      return true;
    }
    ab.e("MicroMsg.FaceUtils", "originFile file not exist");
    AppMethodBeat.o(278);
    return false;
  }
  
  public static String vJ(int paramInt)
  {
    AppMethodBeat.i(279);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(279);
      return "";
    case 0: 
      str = buH();
      AppMethodBeat.o(279);
      return str;
    }
    String str = buI();
    AppMethodBeat.o(279);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.p
 * JD-Core Version:    0.7.0.1
 */