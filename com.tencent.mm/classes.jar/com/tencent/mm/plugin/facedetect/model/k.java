package com.tencent.mm.plugin.facedetect.model;

import android.app.Activity;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.expansions.e;
import com.tencent.mm.plugin.expansions.e.d;
import com.tencent.mm.plugin.facedetect.FaceProNative.FaceResult;
import com.tencent.mm.plugin.facedetect.a.d;
import com.tencent.mm.protocal.protobuf.ng;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

public final class k
{
  public static boolean Mt(int paramInt)
  {
    AppMethodBeat.i(103797);
    String str = "";
    switch (paramInt)
    {
    }
    while (Util.isNullOrNil(str))
    {
      Log.w("MicroMsg.FaceUtils", "hy: no such path for type: %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(103797);
      return false;
      str = bg.okT.aM("LAST_LOGIN_FACE_MODEL_SDCARD_PATH_DETECT", "");
      continue;
      str = bg.okT.aM("LAST_LOGIN_FACE_MODEL_SDCARD_PATH_ALIGNMENT", "");
    }
    if (new u(str).jKS())
    {
      u localu = new u(Mu(paramInt));
      if (localu.jKS()) {
        localu.diJ();
      }
      y.O(str, Mu(paramInt), false);
      AppMethodBeat.o(103797);
      return true;
    }
    Log.e("MicroMsg.FaceUtils", "originFile file not exist");
    AppMethodBeat.o(103797);
    return false;
  }
  
  private static String Mu(int paramInt)
  {
    AppMethodBeat.i(103798);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(103798);
      return "";
    case 0: 
      str = dPb();
      AppMethodBeat.o(103798);
      return str;
    }
    String str = dPc();
    AppMethodBeat.o(103798);
    return str;
  }
  
  public static String a(FaceProNative.FaceResult paramFaceResult)
  {
    AppMethodBeat.i(103785);
    if ((paramFaceResult == null) || (paramFaceResult.result != 0))
    {
      Log.e("MicroMsg.FaceUtils", "alvinluo face result is null or result code not 0");
      AppMethodBeat.o(103785);
      return null;
    }
    try
    {
      String str = dPd();
      ng localng = new ng();
      localng.YOY = com.tencent.mm.bx.b.cX(paramFaceResult.sidedata);
      localng.YOZ = com.tencent.mm.bx.b.cX(paramFaceResult.data);
      e(localng.toByteArray(), str);
      AppMethodBeat.o(103785);
      return str;
    }
    catch (Exception paramFaceResult)
    {
      Log.printErrStackTrace("MicroMsg.FaceUtils", paramFaceResult, "", new Object[0]);
      AppMethodBeat.o(103785);
    }
    return null;
  }
  
  public static boolean as(Activity paramActivity)
  {
    AppMethodBeat.i(271889);
    boolean bool1 = com.tencent.mm.pluginsdk.permission.b.a(paramActivity, "android.permission.CAMERA", 16, "");
    Log.i("MicroMsg.FaceUtils", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool1), Util.getStack(), paramActivity });
    if (!bool1)
    {
      AppMethodBeat.o(271889);
      return false;
    }
    boolean bool2 = com.tencent.mm.pluginsdk.permission.b.a(paramActivity, "android.permission.RECORD_AUDIO", 80, "");
    Log.i("MicroMsg.FaceUtils", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool1), Util.getStack(), paramActivity });
    if (!bool2)
    {
      AppMethodBeat.o(271889);
      return false;
    }
    AppMethodBeat.o(271889);
    return true;
  }
  
  public static boolean at(Activity paramActivity)
  {
    AppMethodBeat.i(103789);
    boolean bool1 = com.tencent.mm.pluginsdk.permission.b.s(paramActivity, "android.permission.CAMERA");
    boolean bool2 = com.tencent.mm.pluginsdk.permission.b.s(paramActivity, "android.permission.RECORD_AUDIO");
    Log.d("MicroMsg.FaceUtils", "summerper checkPermission checkCamera[%b], checkAudio[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Util.getStack(), paramActivity });
    ArrayList localArrayList = new ArrayList();
    if (!bool1) {
      localArrayList.add("android.permission.CAMERA");
    }
    if (!bool2) {
      localArrayList.add("android.permission.RECORD_AUDIO");
    }
    if ((!bool1) || (!bool2))
    {
      Log.i("MicroMsg.FaceUtils", "hy: above 23 and no permission. requesting...");
      androidx.core.app.a.a(paramActivity, (String[])localArrayList.toArray(new String[localArrayList.size()]), 23);
      AppMethodBeat.o(103789);
      return false;
    }
    AppMethodBeat.o(103789);
    return true;
  }
  
  public static Bitmap atI(String paramString)
  {
    AppMethodBeat.i(103786);
    try
    {
      if (Util.isNullOrNil(paramString))
      {
        Log.i("MicroMsg.FaceUtils", "hy: username is null or nil. return");
        AppMethodBeat.o(103786);
        return null;
      }
      Object localObject = a.a.zSB + MD5Util.getMD5String(paramString);
      if (!new u((String)localObject).jKS())
      {
        Log.w("MicroMsg.FaceUtils", "hy: no last file. return");
        AppMethodBeat.o(103786);
        return null;
      }
      localObject = y.bi((String)localObject, 0, -1);
      if (localObject != null)
      {
        paramString = k.a.f((byte[])localObject, atJ(paramString));
        if ((paramString == null) || (paramString.length <= 0))
        {
          Log.w("MicroMsg.FaceUtils", "hy: decrypt err. return null");
          AppMethodBeat.o(103786);
          return null;
        }
        paramString = com.tencent.mm.compatible.f.a.decodeByteArray(paramString, 0, paramString.length);
        AppMethodBeat.o(103786);
        return paramString;
      }
      Log.w("MicroMsg.FaceUtils", "hy: nothing in file");
      AppMethodBeat.o(103786);
      return null;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.FaceUtils", paramString, "hy: err in encrypt", new Object[0]);
      AppMethodBeat.o(103786);
    }
    return null;
  }
  
  private static String atJ(String paramString)
  {
    AppMethodBeat.i(103788);
    paramString = Base64.encodeToString((paramString + paramString.hashCode()).getBytes(), 0);
    AppMethodBeat.o(103788);
    return paramString;
  }
  
  public static String atK(String paramString)
  {
    AppMethodBeat.i(103801);
    paramString = g.getMessageDigest((Util.currentTicks() + ", " + paramString).getBytes());
    AppMethodBeat.o(103801);
    return paramString;
  }
  
  public static boolean dOW()
  {
    boolean bool3 = false;
    AppMethodBeat.i(103791);
    Object localObject1 = dOX() + "/";
    Object localObject4 = dPa();
    Object localObject3 = dOZ();
    Object localObject2 = dOY();
    int j = localObject4.length;
    int i = 0;
    String str1;
    if (i < j)
    {
      String str2 = localObject4[i];
      str1 = (String)localObject1 + str2;
      str2 = "detector/".concat(String.valueOf(str2));
      if ((y.ZC(str1)) || (hz(str1, "face_detect/".concat(String.valueOf(str2))).booleanValue())) {}
    }
    for (boolean bool2 = false;; bool2 = true)
    {
      j = localObject3.length;
      i = 0;
      label138:
      boolean bool1 = bool2;
      if (i < j)
      {
        str1 = localObject3[i];
        localObject4 = (String)localObject1 + str1;
        str1 = "ufa/".concat(String.valueOf(str1));
        if ((!y.ZC((String)localObject4)) && (!hz((String)localObject4, "face_detect/".concat(String.valueOf(str1))).booleanValue())) {
          bool1 = false;
        }
      }
      else
      {
        j = localObject2.length;
        i = 0;
        label224:
        bool2 = bool1;
        if (i < j)
        {
          localObject4 = localObject2[i];
          localObject3 = "poseest/".concat(String.valueOf(localObject4));
          localObject4 = (String)localObject1 + (String)localObject4;
          if ((y.ZC((String)localObject4)) || (hz((String)localObject4, "face_detect/".concat(String.valueOf(localObject3))).booleanValue())) {
            break label363;
          }
          bool2 = false;
        }
        localObject2 = dPb();
        localObject1 = dPc();
        if ((!Util.isNullOrNil((String)localObject2)) && (!Util.isNullOrNil((String)localObject1))) {
          break label370;
        }
        Log.w("MicroMsg.FaceUtils", "hy: not valid model path. start ");
        bool1 = bool3;
      }
      for (;;)
      {
        AppMethodBeat.o(103791);
        return bool1;
        i += 1;
        break;
        i += 1;
        break label138;
        label363:
        i += 1;
        break label224;
        label370:
        localObject2 = new u((String)localObject2);
        localObject1 = new u((String)localObject1);
        bool1 = bool2;
        if (!((u)localObject2).jKS())
        {
          bool1 = bool2;
          if (!Mt(0))
          {
            Log.e("MicroMsg.FaceUtils", "hy: no detect model in storage and sdcard");
            bool1 = false;
          }
        }
        if ((!((u)localObject1).jKS()) && (!Mt(1)))
        {
          Log.e("MicroMsg.FaceUtils", "hy: no alignment model in storage and sdcard");
          bool1 = bool3;
        }
      }
    }
  }
  
  public static String dOX()
  {
    AppMethodBeat.i(103793);
    if (a.xJU) {}
    for (String str = com.tencent.mm.loader.i.b.bmz() + "face_detect";; str = com.tencent.mm.loader.i.b.bmq() + "face_detect")
    {
      u localu = new u(str);
      if (!localu.jKS())
      {
        Log.i("MicroMsg.FaceUtils", "hy: face dir not exist. mk dir");
        localu.jKY();
      }
      AppMethodBeat.o(103793);
      return str;
    }
  }
  
  public static String[] dOY()
  {
    return new String[] { "rotBasis.bin" };
  }
  
  public static String[] dOZ()
  {
    return new String[] { "align.rpdm", "align.stb", "align_bin.rpdc", "eye.rpdm", "eye_bin.rpdc" };
  }
  
  public static String[] dPa()
  {
    return new String[] { "net1_18.rpnmodel", "net1_18_bin.rpnproto", "net2_36.rpnmodel", "net2_36_bin.rpnproto" };
  }
  
  public static String dPb()
  {
    AppMethodBeat.i(103794);
    String str = dOX() + "/ufdmtcc.bin";
    AppMethodBeat.o(103794);
    return str;
  }
  
  public static String dPc()
  {
    AppMethodBeat.i(103795);
    String str = dOX() + "/ufat.bin";
    AppMethodBeat.o(103795);
    return str;
  }
  
  public static String dPd()
  {
    AppMethodBeat.i(103796);
    String str = dOX() + "/release_out.fd";
    AppMethodBeat.o(103796);
    return str;
  }
  
  public static void e(byte[] paramArrayOfByte, String paramString)
  {
    AppMethodBeat.i(103784);
    try
    {
      y.f(paramString, paramArrayOfByte, paramArrayOfByte.length);
      AppMethodBeat.o(103784);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      Log.printErrStackTrace("MicroMsg.FaceUtils", paramArrayOfByte, "hy: err in save debug jpeg", new Object[0]);
      AppMethodBeat.o(103784);
    }
  }
  
  public static boolean e(Bitmap paramBitmap, String paramString)
  {
    AppMethodBeat.i(103787);
    if (paramBitmap == null) {}
    try
    {
      Log.w("MicroMsg.FaceUtils", "hy: bm is null. abort");
      AppMethodBeat.o(103787);
      return false;
    }
    catch (Exception paramBitmap)
    {
      Object localObject1;
      Object localObject2;
      Log.printErrStackTrace("MicroMsg.FaceUtils", paramBitmap, "hy: err in encrypt", new Object[0]);
      AppMethodBeat.o(103787);
    }
    if (Util.isNullOrNil(paramString))
    {
      Log.i("MicroMsg.FaceUtils", "hy: username is null or nil. return");
      AppMethodBeat.o(103787);
      return false;
    }
    localObject1 = new u(a.a.zSB);
    if (!((u)localObject1).jKS()) {
      ((u)localObject1).jKY();
    }
    localObject1 = a.a.zSB + MD5Util.getMD5String(paramString);
    localObject2 = new u((String)localObject1);
    if (!((u)localObject2).jKS())
    {
      Log.i("MicroMsg.FaceUtils", "hy: last file already exists. del");
      ((u)localObject2).jKZ();
    }
    localObject2 = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, 85, (OutputStream)localObject2);
    paramBitmap = ((ByteArrayOutputStream)localObject2).toByteArray();
    ((ByteArrayOutputStream)localObject2).close();
    if (paramBitmap != null)
    {
      paramBitmap = k.a.f(paramBitmap, atJ(paramString));
      if ((paramBitmap == null) || (paramBitmap.length <= 0))
      {
        Log.w("MicroMsg.FaceUtils", "hy: enc err. return null");
        AppMethodBeat.o(103787);
        return false;
      }
      y.f((String)localObject1, paramBitmap, paramBitmap.length);
      AppMethodBeat.o(103787);
      return true;
    }
    Log.w("MicroMsg.FaceUtils", "hy: nothing in stream");
    AppMethodBeat.o(103787);
    return false;
    return false;
  }
  
  private static Boolean hz(String paramString1, String paramString2)
  {
    AppMethodBeat.i(103792);
    Log.i("MicroMsg.FaceUtils", "SDPath: " + paramString1 + " assetPath: " + paramString2);
    if (!e.dHF()) {
      n(MMApplicationContext.getContext(), paramString2, paramString1);
    }
    for (;;)
    {
      boolean bool = y.ZC(paramString1);
      AppMethodBeat.o(103792);
      return Boolean.valueOf(bool);
      AssetManager localAssetManager = e.tryGetAssets();
      if (localAssetManager == null)
      {
        paramString1 = Boolean.FALSE;
        AppMethodBeat.o(103792);
        return paramString1;
      }
      try
      {
        e.d.a(localAssetManager, paramString2, new File(paramString1));
      }
      catch (IOException paramString2) {}
    }
  }
  
  public static Bitmap l(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(103800);
    long l1 = System.currentTimeMillis();
    if (paramBitmap == null) {
      paramBitmap = null;
    }
    for (;;)
    {
      Log.i("MicroMsg.FaceUtils", "hy: blur using %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
      int i = 1;
      Object localObject = paramBitmap;
      int j;
      if (paramBitmap == null)
      {
        Log.w("MicroMsg.FaceUtils", "hy: null on blur. use default");
        j = 0;
        paramBitmap = atI(paramString);
        localObject = paramBitmap;
        i = j;
        if (paramBitmap == null)
        {
          localObject = BitmapUtil.getBitmapNative(a.d.face_black);
          i = j;
        }
      }
      if (i != 0) {
        h.ahAA.bp(new k.1((Bitmap)localObject, paramString));
      }
      AppMethodBeat.o(103800);
      return localObject;
      long l2 = System.currentTimeMillis();
      paramBitmap = Bitmap.createScaledBitmap(paramBitmap, Math.round(paramBitmap.getWidth() * 0.1F), Math.round(paramBitmap.getHeight() * 0.1F), false);
      paramBitmap = paramBitmap.copy(paramBitmap.getConfig(), true);
      int i14 = paramBitmap.getWidth();
      int i15 = paramBitmap.getHeight();
      localObject = new int[i14 * i15];
      Log.e("pix", i14 + " " + i15 + " " + localObject.length);
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
          break label981;
        }
        if (b.mq(l2))
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
        if (b.mq(l2))
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
      label981:
      i = 0;
      for (;;)
      {
        if (i >= i14) {
          break label1563;
        }
        i7 = i14 * -30;
        if (b.mq(l2))
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
        if (b.mq(l2))
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
      label1563:
      Log.e("pix", i14 + " " + i15 + " " + i17);
      paramBitmap.setPixels((int[])localObject, 0, i14, 0, 0, i14, i15);
    }
  }
  
  /* Error */
  public static void n(android.content.Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc_w 591
    //   3: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 25
    //   8: ldc_w 593
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
    //   23: invokestatic 169	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   26: aload_2
    //   27: invokestatic 599	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   30: ifne +7 -> 37
    //   33: aload_0
    //   34: ifnonnull +10 -> 44
    //   37: ldc_w 591
    //   40: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: return
    //   44: aload_2
    //   45: invokestatic 602	com/tencent/mm/vfs/y:bEo	(Ljava/lang/String;)Ljava/lang/String;
    //   48: invokestatic 605	com/tencent/mm/vfs/y:bDX	(Ljava/lang/String;)Z
    //   51: pop
    //   52: new 58	com/tencent/mm/vfs/u
    //   55: dup
    //   56: aload_2
    //   57: invokespecial 62	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   60: astore 6
    //   62: aload_0
    //   63: invokevirtual 610	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   66: aload_1
    //   67: invokevirtual 616	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   70: astore_0
    //   71: aload 6
    //   73: invokestatic 620	com/tencent/mm/vfs/y:ap	(Lcom/tencent/mm/vfs/u;)Ljava/io/OutputStream;
    //   76: astore 5
    //   78: aload 5
    //   80: astore 4
    //   82: aload_0
    //   83: astore_2
    //   84: sipush 1024
    //   87: newarray byte
    //   89: astore 7
    //   91: aload 5
    //   93: astore 4
    //   95: aload_0
    //   96: astore_2
    //   97: aload_0
    //   98: aload 7
    //   100: invokevirtual 626	java/io/InputStream:read	([B)I
    //   103: istore_3
    //   104: iload_3
    //   105: iconst_m1
    //   106: if_icmpeq +70 -> 176
    //   109: aload 5
    //   111: astore 4
    //   113: aload_0
    //   114: astore_2
    //   115: aload 5
    //   117: aload 7
    //   119: iconst_0
    //   120: iload_3
    //   121: invokevirtual 632	java/io/OutputStream:write	([BII)V
    //   124: goto -33 -> 91
    //   127: astore_2
    //   128: aload 5
    //   130: astore_1
    //   131: aload_2
    //   132: astore 5
    //   134: aload_1
    //   135: astore 4
    //   137: aload_0
    //   138: astore_2
    //   139: ldc 25
    //   141: aload 5
    //   143: ldc_w 634
    //   146: iconst_0
    //   147: anewarray 4	java/lang/Object
    //   150: invokestatic 146	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   153: aload_0
    //   154: ifnull +7 -> 161
    //   157: aload_0
    //   158: invokevirtual 635	java/io/InputStream:close	()V
    //   161: aload_1
    //   162: ifnull +7 -> 169
    //   165: aload_1
    //   166: invokevirtual 636	java/io/OutputStream:close	()V
    //   169: ldc_w 591
    //   172: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   175: return
    //   176: aload 5
    //   178: astore 4
    //   180: aload_0
    //   181: astore_2
    //   182: aload 5
    //   184: invokevirtual 639	java/io/OutputStream:flush	()V
    //   187: aload 5
    //   189: astore 4
    //   191: aload_0
    //   192: astore_2
    //   193: ldc 25
    //   195: ldc_w 641
    //   198: iconst_2
    //   199: anewarray 4	java/lang/Object
    //   202: dup
    //   203: iconst_0
    //   204: aload_1
    //   205: aastore
    //   206: dup
    //   207: iconst_1
    //   208: aload 6
    //   210: invokevirtual 644	com/tencent/mm/vfs/u:length	()J
    //   213: invokestatic 489	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   216: aastore
    //   217: invokestatic 169	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   220: aload_0
    //   221: ifnull +7 -> 228
    //   224: aload_0
    //   225: invokevirtual 635	java/io/InputStream:close	()V
    //   228: aload 5
    //   230: ifnull +8 -> 238
    //   233: aload 5
    //   235: invokevirtual 636	java/io/OutputStream:close	()V
    //   238: ldc_w 591
    //   241: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   244: return
    //   245: astore_0
    //   246: ldc_w 591
    //   249: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   252: return
    //   253: astore_0
    //   254: ldc_w 591
    //   257: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   260: return
    //   261: astore_1
    //   262: aconst_null
    //   263: astore 4
    //   265: aconst_null
    //   266: astore_0
    //   267: aload_0
    //   268: ifnull +7 -> 275
    //   271: aload_0
    //   272: invokevirtual 635	java/io/InputStream:close	()V
    //   275: aload 4
    //   277: ifnull +8 -> 285
    //   280: aload 4
    //   282: invokevirtual 636	java/io/OutputStream:close	()V
    //   285: ldc_w 591
    //   288: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   291: aload_1
    //   292: athrow
    //   293: astore_0
    //   294: goto -9 -> 285
    //   297: astore_1
    //   298: aconst_null
    //   299: astore 4
    //   301: goto -34 -> 267
    //   304: astore_1
    //   305: aload_2
    //   306: astore_0
    //   307: goto -40 -> 267
    //   310: astore 5
    //   312: aconst_null
    //   313: astore_1
    //   314: aconst_null
    //   315: astore_0
    //   316: goto -182 -> 134
    //   319: astore 5
    //   321: aconst_null
    //   322: astore_1
    //   323: goto -189 -> 134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	326	0	paramContext	android.content.Context
    //   0	326	1	paramString1	String
    //   0	326	2	paramString2	String
    //   103	18	3	i	int
    //   80	220	4	localObject1	Object
    //   76	158	5	localObject2	Object
    //   310	1	5	localException1	Exception
    //   319	1	5	localException2	Exception
    //   60	149	6	localu	u
    //   89	29	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   84	91	127	java/lang/Exception
    //   97	104	127	java/lang/Exception
    //   115	124	127	java/lang/Exception
    //   182	187	127	java/lang/Exception
    //   193	220	127	java/lang/Exception
    //   224	228	245	java/lang/Exception
    //   233	238	245	java/lang/Exception
    //   157	161	253	java/lang/Exception
    //   165	169	253	java/lang/Exception
    //   44	71	261	finally
    //   271	275	293	java/lang/Exception
    //   280	285	293	java/lang/Exception
    //   71	78	297	finally
    //   84	91	304	finally
    //   97	104	304	finally
    //   115	124	304	finally
    //   139	153	304	finally
    //   182	187	304	finally
    //   193	220	304	finally
    //   44	71	310	java/lang/Exception
    //   71	78	319	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.k
 * JD-Core Version:    0.7.0.1
 */