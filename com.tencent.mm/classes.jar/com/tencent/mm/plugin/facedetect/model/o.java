package com.tencent.mm.plugin.facedetect.model;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.util.Base64;
import android.view.Window;
import com.tencent.mm.ah.p;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.facedetect.FaceProNative.FaceResult;
import com.tencent.mm.plugin.facedetect.a.d;
import com.tencent.mm.pluginsdk.g.a.a.m;
import com.tencent.mm.protocal.c.ig;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

public final class o
{
  public static Bitmap Co(String paramString)
  {
    try
    {
      if (bk.bl(paramString))
      {
        y.i("MicroMsg.FaceUtils", "hy: username is null or nil. return");
        return null;
      }
      localObject = a.a.jNz + ad.bB(paramString);
      if (!new com.tencent.mm.vfs.b((String)localObject).exists())
      {
        y.w("MicroMsg.FaceUtils", "hy: no last file. return");
        return null;
      }
    }
    catch (Exception paramString)
    {
      y.printErrStackTrace("MicroMsg.FaceUtils", paramString, "hy: err in encrypt", new Object[0]);
      return null;
    }
    Object localObject = com.tencent.mm.vfs.e.c((String)localObject, 0, -1);
    if (localObject != null)
    {
      paramString = o.a.g((byte[])localObject, Cp(paramString));
      if (paramString.length <= 0)
      {
        y.w("MicroMsg.FaceUtils", "hy: decrypt err. return null");
        return null;
      }
      return com.tencent.mm.compatible.g.a.decodeByteArray(paramString, 0, paramString.length);
    }
    y.w("MicroMsg.FaceUtils", "hy: nothing in file");
    return null;
  }
  
  private static String Cp(String paramString)
  {
    return Base64.encodeToString((paramString + paramString.hashCode()).getBytes(), 0);
  }
  
  public static String Cq(String paramString)
  {
    return com.tencent.mm.a.g.o((bk.UZ() + ", " + paramString).getBytes());
  }
  
  public static String a(FaceProNative.FaceResult paramFaceResult)
  {
    if ((paramFaceResult == null) || (paramFaceResult.result != 0))
    {
      y.e("MicroMsg.FaceUtils", "alvinluo face result is null or result code not 0");
      return null;
    }
    try
    {
      String str = aOG();
      ig localig = new ig();
      localig.sCb = com.tencent.mm.bv.b.bk(paramFaceResult.sidedata);
      localig.sCc = com.tencent.mm.bv.b.bk(paramFaceResult.data);
      f(localig.toByteArray(), str);
      return str;
    }
    catch (Exception paramFaceResult)
    {
      y.printErrStackTrace("MicroMsg.FaceUtils", paramFaceResult, "", new Object[0]);
    }
    return null;
  }
  
  public static boolean aOB()
  {
    Object localObject2 = aOD();
    Object localObject1 = aOE();
    boolean bool1;
    if ((bk.bl((String)localObject2)) || (bk.bl((String)localObject1)))
    {
      y.w("MicroMsg.FaceUtils", "hy: not valid model path. start ");
      bool1 = false;
      if (!bool1)
      {
        y.i("MicroMsg.FaceUtils", "hy: trigger start download model file");
        com.tencent.mm.kernel.g.Dk().a(new m(42), 0);
      }
      return bool1;
    }
    localObject2 = new com.tencent.mm.vfs.b((String)localObject2);
    localObject1 = new com.tencent.mm.vfs.b((String)localObject1);
    if ((!((com.tencent.mm.vfs.b)localObject2).exists()) && (!qN(0))) {
      y.e("MicroMsg.FaceUtils", "hy: no detect model in storage and sdcard");
    }
    for (boolean bool2 = false;; bool2 = true)
    {
      bool1 = bool2;
      if (((com.tencent.mm.vfs.b)localObject1).exists()) {
        break;
      }
      bool1 = bool2;
      if (qN(1)) {
        break;
      }
      y.e("MicroMsg.FaceUtils", "hy: no alignment model in storage and sdcard");
      bool1 = false;
      break;
    }
  }
  
  public static String aOC()
  {
    if (a.jNx) {}
    for (String str = h.getExternalStorageDirectory().getAbsolutePath() + "/face_detect";; str = ae.getContext().getFilesDir().getParent() + "/face_detect")
    {
      com.tencent.mm.vfs.b localb = new com.tencent.mm.vfs.b(str);
      if (!localb.exists())
      {
        y.i("MicroMsg.FaceUtils", "hy: face dir not exist. mk dir");
        localb.mkdirs();
      }
      return str;
    }
  }
  
  public static String aOD()
  {
    return aOC() + "/ufdmtcc.bin";
  }
  
  public static String aOE()
  {
    return aOC() + "/ufat.bin";
  }
  
  public static String aOF()
  {
    return aOC() + "/PE.dat";
  }
  
  public static String aOG()
  {
    return aOC() + "/release_out.fd";
  }
  
  public static boolean b(Bitmap paramBitmap, String paramString)
  {
    if (paramBitmap == null) {}
    try
    {
      y.w("MicroMsg.FaceUtils", "hy: bm is null. abort");
      return false;
    }
    catch (Exception paramBitmap)
    {
      y.printErrStackTrace("MicroMsg.FaceUtils", paramBitmap, "hy: err in encrypt", new Object[0]);
      return false;
    }
    if (bk.bl(paramString))
    {
      y.i("MicroMsg.FaceUtils", "hy: username is null or nil. return");
      return false;
    }
    Object localObject1 = new com.tencent.mm.vfs.b(a.a.jNz);
    if (!((com.tencent.mm.vfs.b)localObject1).exists()) {
      ((com.tencent.mm.vfs.b)localObject1).mkdirs();
    }
    localObject1 = a.a.jNz + ad.bB(paramString);
    Object localObject2 = new com.tencent.mm.vfs.b((String)localObject1);
    if (!((com.tencent.mm.vfs.b)localObject2).exists())
    {
      y.i("MicroMsg.FaceUtils", "hy: last file already exists. del");
      ((com.tencent.mm.vfs.b)localObject2).createNewFile();
    }
    localObject2 = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, 85, (OutputStream)localObject2);
    paramBitmap = ((ByteArrayOutputStream)localObject2).toByteArray();
    ((ByteArrayOutputStream)localObject2).close();
    if (paramBitmap != null)
    {
      paramBitmap = o.a.g(paramBitmap, Cp(paramString));
      if (paramBitmap.length <= 0)
      {
        y.w("MicroMsg.FaceUtils", "hy: enc err. return null");
        return false;
      }
      com.tencent.mm.vfs.e.b((String)localObject1, paramBitmap, paramBitmap.length);
      return true;
    }
    y.w("MicroMsg.FaceUtils", "hy: nothing in stream");
    return false;
  }
  
  public static void f(byte[] paramArrayOfByte, String paramString)
  {
    try
    {
      com.tencent.mm.vfs.e.b(paramString, paramArrayOfByte, paramArrayOfByte.length);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      y.printErrStackTrace("MicroMsg.FaceUtils", paramArrayOfByte, "hy: err in save debug jpeg", new Object[0]);
    }
  }
  
  public static Bitmap m(String paramString, Bitmap paramBitmap)
  {
    long l1 = System.currentTimeMillis();
    if (paramBitmap == null) {
      paramBitmap = null;
    }
    for (;;)
    {
      y.i("MicroMsg.FaceUtils", "hy: blur using %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
      int i = 1;
      Object localObject = paramBitmap;
      int j;
      if (paramBitmap == null)
      {
        y.w("MicroMsg.FaceUtils", "hy: null on blur. use default");
        j = 0;
        paramBitmap = Co(paramString);
        localObject = paramBitmap;
        i = j;
        if (paramBitmap == null)
        {
          localObject = c.EX(a.d.face_black);
          i = j;
        }
      }
      if (i != 0) {
        com.tencent.mm.sdk.f.e.post(new o.1((Bitmap)localObject, paramString), "FaceUtils_SaveFile");
      }
      return localObject;
      long l2 = System.currentTimeMillis();
      paramBitmap = Bitmap.createScaledBitmap(paramBitmap, Math.round(paramBitmap.getWidth() * 0.1F), Math.round(paramBitmap.getHeight() * 0.1F), false);
      paramBitmap = paramBitmap.copy(paramBitmap.getConfig(), true);
      int i12 = paramBitmap.getWidth();
      int i13 = paramBitmap.getHeight();
      localObject = new int[i12 * i13];
      y.e("pix", i12 + " " + i13 + " " + localObject.length);
      paramBitmap.getPixels((int[])localObject, 0, i12, 0, 0, i12, i13);
      int i16 = i12 - 1;
      int i14 = i13 - 1;
      int i15 = i12 * i13;
      int[] arrayOfInt1 = new int[i15];
      int[] arrayOfInt2 = new int[i15];
      int[] arrayOfInt3 = new int[i15];
      int[] arrayOfInt4 = new int[Math.max(i12, i13)];
      int[] arrayOfInt5 = new int[246016];
      i = 0;
      while (i < 246016)
      {
        arrayOfInt5[i] = (i / 961);
        i += 1;
      }
      int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { 61, 3 });
      int i6 = 0;
      int i7 = 0;
      int i5 = 0;
      int i8;
      int k;
      int m;
      int n;
      int i1;
      int i2;
      int i3;
      int i4;
      int i9;
      int[] arrayOfInt6;
      int i10;
      int i11;
      for (;;)
      {
        if (i5 >= i13) {
          break label914;
        }
        if (b.ek(l2))
        {
          paramBitmap = null;
          break;
        }
        i8 = -30;
        i = 0;
        j = 0;
        k = 0;
        m = 0;
        n = 0;
        i1 = 0;
        i2 = 0;
        i3 = 0;
        i4 = 0;
        if (i8 <= 30)
        {
          i9 = localObject[(Math.min(i16, Math.max(i8, 0)) + i7)];
          arrayOfInt6 = arrayOfInt[(i8 + 30)];
          arrayOfInt6[0] = ((0xFF0000 & i9) >> 16);
          arrayOfInt6[1] = ((0xFF00 & i9) >> 8);
          arrayOfInt6[2] = (i9 & 0xFF);
          i9 = 31 - Math.abs(i8);
          i4 += arrayOfInt6[0] * i9;
          i3 += arrayOfInt6[1] * i9;
          i2 += i9 * arrayOfInt6[2];
          if (i8 > 0)
          {
            k += arrayOfInt6[0];
            j += arrayOfInt6[1];
            i += arrayOfInt6[2];
          }
          for (;;)
          {
            i8 += 1;
            break;
            i1 += arrayOfInt6[0];
            n += arrayOfInt6[1];
            m += arrayOfInt6[2];
          }
        }
        i10 = 30;
        if (b.ek(l2))
        {
          paramBitmap = null;
          break;
        }
        i11 = 0;
        i9 = i4;
        i8 = i3;
        i4 = i2;
        i2 = i11;
        i3 = i10;
        while (i2 < i12)
        {
          arrayOfInt1[i7] = arrayOfInt5[i9];
          arrayOfInt2[i7] = arrayOfInt5[i8];
          arrayOfInt3[i7] = arrayOfInt5[i4];
          arrayOfInt6 = arrayOfInt[((i3 - 30 + 61) % 61)];
          int i17 = arrayOfInt6[0];
          i11 = arrayOfInt6[1];
          i10 = arrayOfInt6[2];
          if (i5 == 0) {
            arrayOfInt4[i2] = Math.min(i2 + 30 + 1, i16);
          }
          int i18 = localObject[(arrayOfInt4[i2] + i6)];
          arrayOfInt6[0] = ((0xFF0000 & i18) >> 16);
          arrayOfInt6[1] = ((0xFF00 & i18) >> 8);
          arrayOfInt6[2] = (i18 & 0xFF);
          k += arrayOfInt6[0];
          j += arrayOfInt6[1];
          i += arrayOfInt6[2];
          i9 = i9 - i1 + k;
          i8 = i8 - n + j;
          i4 = i4 - m + i;
          i3 = (i3 + 1) % 61;
          arrayOfInt6 = arrayOfInt[(i3 % 61)];
          i1 = i1 - i17 + arrayOfInt6[0];
          n = n - i11 + arrayOfInt6[1];
          m = m - i10 + arrayOfInt6[2];
          k -= arrayOfInt6[0];
          j -= arrayOfInt6[1];
          i -= arrayOfInt6[2];
          i7 += 1;
          i2 += 1;
        }
        i6 += i12;
        i5 += 1;
      }
      label914:
      i = 0;
      for (;;)
      {
        if (i >= i12) {
          break label1526;
        }
        i7 = i12 * -30;
        if (b.ek(l2))
        {
          paramBitmap = null;
          break;
        }
        i6 = -30;
        i2 = 0;
        j = 0;
        k = 0;
        m = 0;
        n = 0;
        i1 = 0;
        i3 = 0;
        i4 = 0;
        i5 = 0;
        if (i6 <= 30)
        {
          i8 = Math.max(0, i7) + i;
          arrayOfInt6 = arrayOfInt[(i6 + 30)];
          arrayOfInt6[0] = arrayOfInt1[i8];
          arrayOfInt6[1] = arrayOfInt2[i8];
          arrayOfInt6[2] = arrayOfInt3[i8];
          i9 = 31 - Math.abs(i6);
          i5 += arrayOfInt1[i8] * i9;
          i4 += arrayOfInt2[i8] * i9;
          i8 = i3 + arrayOfInt3[i8] * i9;
          if (i6 > 0)
          {
            k += arrayOfInt6[0];
            j += arrayOfInt6[1];
            i2 += arrayOfInt6[2];
          }
          for (;;)
          {
            i3 = i7;
            if (i6 < i14) {
              i3 = i7 + i12;
            }
            i6 += 1;
            i7 = i3;
            i3 = i8;
            break;
            i1 += arrayOfInt6[0];
            n += arrayOfInt6[1];
            m += arrayOfInt6[2];
          }
        }
        i10 = 30;
        if (b.ek(l2))
        {
          paramBitmap = null;
          break;
        }
        i11 = 0;
        i9 = i2;
        i8 = i;
        i7 = i5;
        i6 = i4;
        i5 = i3;
        i2 = i11;
        i4 = i10;
        i3 = i8;
        i8 = k;
        k = j;
        j = i9;
        while (i2 < i13)
        {
          localObject[i3] = (0xFF000000 & localObject[i3] | arrayOfInt5[i7] << 16 | arrayOfInt5[i6] << 8 | arrayOfInt5[i5]);
          arrayOfInt6 = arrayOfInt[((i4 - 30 + 61) % 61)];
          i11 = arrayOfInt6[0];
          i10 = arrayOfInt6[1];
          i9 = arrayOfInt6[2];
          if (i == 0) {
            arrayOfInt4[i2] = (Math.min(i2 + 31, i14) * i12);
          }
          i16 = arrayOfInt4[i2] + i;
          arrayOfInt6[0] = arrayOfInt1[i16];
          arrayOfInt6[1] = arrayOfInt2[i16];
          arrayOfInt6[2] = arrayOfInt3[i16];
          i8 += arrayOfInt6[0];
          k += arrayOfInt6[1];
          j += arrayOfInt6[2];
          i7 = i7 - i1 + i8;
          i6 = i6 - n + k;
          i5 = i5 - m + j;
          i4 = (i4 + 1) % 61;
          arrayOfInt6 = arrayOfInt[i4];
          i1 = i1 - i11 + arrayOfInt6[0];
          n = n - i10 + arrayOfInt6[1];
          m = m - i9 + arrayOfInt6[2];
          i8 -= arrayOfInt6[0];
          i9 = arrayOfInt6[1];
          j -= arrayOfInt6[2];
          i3 += i12;
          i2 += 1;
          k -= i9;
        }
        i += 1;
      }
      label1526:
      y.e("pix", i12 + " " + i13 + " " + i15);
      paramBitmap.setPixels((int[])localObject, 0, i12, 0, 0, i12, i13);
    }
  }
  
  /* Error */
  public static void n(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 18
    //   2: ldc_w 422
    //   5: iconst_2
    //   6: anewarray 4	java/lang/Object
    //   9: dup
    //   10: iconst_0
    //   11: aload_1
    //   12: aastore
    //   13: dup
    //   14: iconst_1
    //   15: aload_2
    //   16: aastore
    //   17: invokestatic 319	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   20: new 54	com/tencent/mm/vfs/b
    //   23: dup
    //   24: aload_2
    //   25: invokespecial 57	com/tencent/mm/vfs/b:<init>	(Ljava/lang/String;)V
    //   28: astore 6
    //   30: aload_0
    //   31: invokevirtual 426	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   34: aload_1
    //   35: invokevirtual 432	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   38: astore_0
    //   39: new 434	com/tencent/mm/vfs/f
    //   42: dup
    //   43: aload 6
    //   45: invokespecial 437	com/tencent/mm/vfs/f:<init>	(Lcom/tencent/mm/vfs/b;)V
    //   48: astore 5
    //   50: aload 5
    //   52: astore 4
    //   54: aload_0
    //   55: astore_2
    //   56: sipush 1024
    //   59: newarray byte
    //   61: astore 7
    //   63: aload 5
    //   65: astore 4
    //   67: aload_0
    //   68: astore_2
    //   69: aload_0
    //   70: aload 7
    //   72: invokevirtual 443	java/io/InputStream:read	([B)I
    //   75: istore_3
    //   76: iload_3
    //   77: iconst_m1
    //   78: if_icmpeq +64 -> 142
    //   81: aload 5
    //   83: astore 4
    //   85: aload_0
    //   86: astore_2
    //   87: aload 5
    //   89: aload 7
    //   91: iconst_0
    //   92: iload_3
    //   93: invokevirtual 449	java/io/OutputStream:write	([BII)V
    //   96: goto -33 -> 63
    //   99: astore_2
    //   100: aload 5
    //   102: astore_1
    //   103: aload_2
    //   104: astore 5
    //   106: aload_1
    //   107: astore 4
    //   109: aload_0
    //   110: astore_2
    //   111: ldc 18
    //   113: aload 5
    //   115: ldc_w 451
    //   118: iconst_0
    //   119: anewarray 4	java/lang/Object
    //   122: invokestatic 72	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   125: aload_0
    //   126: ifnull +7 -> 133
    //   129: aload_0
    //   130: invokevirtual 452	java/io/InputStream:close	()V
    //   133: aload_1
    //   134: ifnull +7 -> 141
    //   137: aload_1
    //   138: invokevirtual 453	java/io/OutputStream:close	()V
    //   141: return
    //   142: aload 5
    //   144: astore 4
    //   146: aload_0
    //   147: astore_2
    //   148: aload 5
    //   150: invokevirtual 456	java/io/OutputStream:flush	()V
    //   153: aload 5
    //   155: astore 4
    //   157: aload_0
    //   158: astore_2
    //   159: ldc 18
    //   161: ldc_w 458
    //   164: iconst_2
    //   165: anewarray 4	java/lang/Object
    //   168: dup
    //   169: iconst_0
    //   170: aload_1
    //   171: aastore
    //   172: dup
    //   173: iconst_1
    //   174: aload 6
    //   176: invokevirtual 461	com/tencent/mm/vfs/b:length	()J
    //   179: invokestatic 316	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   182: aastore
    //   183: invokestatic 319	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   186: aload_0
    //   187: ifnull +7 -> 194
    //   190: aload_0
    //   191: invokevirtual 452	java/io/InputStream:close	()V
    //   194: aload 5
    //   196: invokevirtual 453	java/io/OutputStream:close	()V
    //   199: return
    //   200: astore_0
    //   201: return
    //   202: astore_1
    //   203: aconst_null
    //   204: astore 4
    //   206: aconst_null
    //   207: astore_0
    //   208: aload_0
    //   209: ifnull +7 -> 216
    //   212: aload_0
    //   213: invokevirtual 452	java/io/InputStream:close	()V
    //   216: aload 4
    //   218: ifnull +8 -> 226
    //   221: aload 4
    //   223: invokevirtual 453	java/io/OutputStream:close	()V
    //   226: aload_1
    //   227: athrow
    //   228: astore_0
    //   229: goto -3 -> 226
    //   232: astore_1
    //   233: aconst_null
    //   234: astore 4
    //   236: goto -28 -> 208
    //   239: astore_1
    //   240: aload_2
    //   241: astore_0
    //   242: goto -34 -> 208
    //   245: astore_0
    //   246: return
    //   247: astore 5
    //   249: aconst_null
    //   250: astore_1
    //   251: aconst_null
    //   252: astore_0
    //   253: goto -147 -> 106
    //   256: astore 5
    //   258: aconst_null
    //   259: astore_1
    //   260: goto -154 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	263	0	paramContext	Context
    //   0	263	1	paramString1	String
    //   0	263	2	paramString2	String
    //   75	18	3	i	int
    //   52	183	4	localObject1	Object
    //   48	147	5	localObject2	Object
    //   247	1	5	localException1	Exception
    //   256	1	5	localException2	Exception
    //   28	147	6	localb	com.tencent.mm.vfs.b
    //   61	29	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   56	63	99	java/lang/Exception
    //   69	76	99	java/lang/Exception
    //   87	96	99	java/lang/Exception
    //   148	153	99	java/lang/Exception
    //   159	186	99	java/lang/Exception
    //   190	194	200	java/lang/Exception
    //   194	199	200	java/lang/Exception
    //   20	39	202	finally
    //   212	216	228	java/lang/Exception
    //   221	226	228	java/lang/Exception
    //   39	50	232	finally
    //   56	63	239	finally
    //   69	76	239	finally
    //   87	96	239	finally
    //   111	125	239	finally
    //   148	153	239	finally
    //   159	186	239	finally
    //   129	133	245	java/lang/Exception
    //   137	141	245	java/lang/Exception
    //   20	39	247	java/lang/Exception
    //   39	50	256	java/lang/Exception
  }
  
  public static boolean qN(int paramInt)
  {
    String str = "";
    switch (paramInt)
    {
    }
    while (bk.bl(str))
    {
      y.w("MicroMsg.FaceUtils", "hy: no such path for type: %d", new Object[] { Integer.valueOf(paramInt) });
      return false;
      str = at.dVC.L("LAST_LOGIN_FACE_MODEL_SDCARD_PATH_DETECT", "");
      continue;
      str = at.dVC.L("LAST_LOGIN_FACE_MODEL_SDCARD_PATH_ALIGNMENT", "");
    }
    if (new com.tencent.mm.vfs.b(str).exists())
    {
      com.tencent.mm.vfs.b localb = new com.tencent.mm.vfs.b(qO(paramInt));
      if (localb.exists()) {
        localb.delete();
      }
      com.tencent.mm.vfs.e.r(str, qO(paramInt));
      return true;
    }
    y.e("MicroMsg.FaceUtils", "originFile file not exist");
    return false;
  }
  
  public static String qO(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 0: 
      return aOD();
    }
    return aOE();
  }
  
  public static boolean y(Activity paramActivity)
  {
    boolean bool1 = true;
    boolean bool3 = com.tencent.mm.pluginsdk.permission.a.j(paramActivity, "android.permission.CAMERA");
    boolean bool2 = com.tencent.mm.pluginsdk.permission.a.j(paramActivity, "android.permission.RECORD_AUDIO");
    y.d("MicroMsg.FaceUtils", "summerper checkPermission checkCamera[%b], checkAudio[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool2), bk.csb(), paramActivity });
    ArrayList localArrayList = new ArrayList();
    if (!bool3) {
      localArrayList.add("android.permission.CAMERA");
    }
    if (!bool2) {
      localArrayList.add("android.permission.RECORD_AUDIO");
    }
    if ((!bool3) || (!bool2))
    {
      y.i("MicroMsg.FaceUtils", "hy: above 23 and no permission. requesting...");
      android.support.v4.app.a.a(paramActivity, (String[])localArrayList.toArray(new String[localArrayList.size()]), 23);
      bool1 = false;
    }
    return bool1;
  }
  
  public static void z(Activity paramActivity)
  {
    paramActivity.getWindow().setFlags(1024, 1024);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.o
 * JD-Core Version:    0.7.0.1
 */