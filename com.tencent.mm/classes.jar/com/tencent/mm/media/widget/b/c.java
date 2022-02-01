package com.tencent.mm.media.widget.b;

import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureRequest.Builder;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/widget/camera2/CameraUtil;", "", "()V", "BACK_CAMERA", "", "getBACK_CAMERA", "()I", "FRONT_CAMERA", "getFRONT_CAMERA", "IMAGE_STREAM", "", "getIMAGE_STREAM", "()Ljava/lang/String;", "ORIENTATION_0", "getORIENTATION_0", "ORIENTATION_180", "getORIENTATION_180", "ORIENTATION_270", "getORIENTATION_270", "ORIENTATION_90", "getORIENTATION_90", "OTHER_CAMERA", "getOTHER_CAMERA", "PREVIEW_STREAM", "getPREVIEW_STREAM", "RECORD_STREAM", "getRECORD_STREAM", "TAG", "fbLevel", "getFbLevel", "setFbLevel", "(Ljava/lang/String;)V", "isDebugFaceBeauty", "", "()Z", "setDebugFaceBeauty", "(Z)V", "isDenoisyVendorOn", "setDenoisyVendorOn", "isFaceBeautyVendorOn", "setFaceBeautyVendorOn", "isHDRCheckerVendorOn", "setHDRCheckerVendorOn", "isHDRRetOn", "Ljava/lang/Boolean;", "isHDRVendorOn", "setHDRVendorOn", "isStabilizationOn", "setStabilizationOn", "isUseBackCamera", "mBackCameraId", "getMBackCameraId", "mCameraManager", "Landroid/hardware/camera2/CameraManager;", "getMCameraManager", "()Landroid/hardware/camera2/CameraManager;", "setMCameraManager", "(Landroid/hardware/camera2/CameraManager;)V", "value", "mCurrentCameraId", "getMCurrentCameraId", "setMCurrentCameraId", "mCurrentImageFormat", "getMCurrentImageFormat", "setMCurrentImageFormat", "(I)V", "mFrontCameraId", "getMFrontCameraId", "mScreenSize", "Landroid/graphics/Point;", "getMScreenSize", "()Landroid/graphics/Point;", "setMScreenSize", "(Landroid/graphics/Point;)V", "mSensorOrientation", "getMSensorOrientation", "setMSensorOrientation", "mSupportHardWardLevel", "getMSupportHardWardLevel", "mSupportImageFormats", "", "getMSupportImageFormats", "()[I", "mSupportImageSizes", "", "Landroid/util/Size;", "getMSupportImageSizes", "()[Landroid/util/Size;", "mSupportPreviewSizes", "getMSupportPreviewSizes", "mSupportRecordSizes", "getMSupportRecordSizes", "mSupportRequestVendorTags", "Ljava/util/ArrayList;", "Lcom/tencent/mm/media/widget/camera2/effect/request/WCCameraEffectRequestTag;", "Lkotlin/collections/ArrayList;", "getMSupportRequestVendorTags", "()Ljava/util/ArrayList;", "setMSupportRequestVendorTags", "(Ljava/util/ArrayList;)V", "mSupportResultVendorTags", "Lcom/tencent/mm/media/widget/camera2/effect/result/WCCameraEffectResultTag;", "getMSupportResultVendorTags", "setMSupportResultVendorTags", "mSupportSessionVendorType", "Lcom/tencent/mm/media/widget/camera2/effect/sessionType/WCCameraEffectSessionType;", "getMSupportSessionVendorType", "setMSupportSessionVendorType", "onHDRCheckerResult", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "ret", "", "getOnHDRCheckerResult", "()Lkotlin/jvm/functions/Function1;", "setOnHDRCheckerResult", "(Lkotlin/jvm/functions/Function1;)V", "skinRate", "getSkinRate", "setSkinRate", "slimRate", "getSlimRate", "setSlimRate", "checkHDRValue", "result", "Landroid/hardware/camera2/CaptureResult;", "configAllFaceBeautyTag", "builder", "Landroid/hardware/camera2/CaptureRequest$Builder;", "configCaptureSessionType", "requestList", "", "configDenoisy", "configFaceBeauty", "configHDR", "configHDRChecker", "configStabilization", "configVendorTagValue", "tag", "getCamera2SupportHardWardLevel", "id", "getCameraId", "getCameraOrientation", "getFlashMode", "getFormatNames", "format", "getHardWardSupportLevelNames", "level", "getSupportImageFormat", "getSupportImageSize", "(Ljava/lang/String;I)[Landroid/util/Size;", "getSupportPreviewSize", "(Ljava/lang/String;)[Landroid/util/Size;", "getSupportRecordSize", "initAllParameters", "initConfigParameters", "isSettleBySessionType", "isVendorDenoisySupported", "isVendorFaceBeautySupported", "isVendorHDRCheckerSupported", "isVendorHDRSupported", "printSupportFormat", "formats", "printSupportSize", "sizes", "type", "([Landroid/util/Size;Ljava/lang/String;)V", "resumeAllCameraEffect", "setFlashMode", "mode", "setFlashOn", "isOn", "plugin-mediaeditor_release"})
public final class c
{
  private static final String TAG = "MicroMsg.CameraUtil";
  private static kotlin.g.a.b<? super Boolean, x> lbx;
  private static int lcA = 0;
  private static int lcB = 0;
  private static boolean lcC = false;
  private static Boolean lcD;
  private static ArrayList<com.tencent.mm.media.widget.b.a.a.a> lcE;
  private static ArrayList<com.tencent.mm.media.widget.b.a.b.a> lcF;
  private static ArrayList<com.tencent.mm.media.widget.b.a.c.a> lcG;
  public static final c lcH;
  static CameraManager lcf;
  static final int lcg = 1;
  static final int lch = 0;
  private static final int lci = 2;
  private static final int lcj = 0;
  private static final int lck = 90;
  private static final int lcl = 180;
  private static final int lcm = 270;
  private static final String lcn = "preview";
  private static final String lco = "record";
  private static final String lcp = "image";
  static String lcq;
  private static int lcr;
  static int lcs;
  private static Point lct;
  private static boolean lcu;
  private static boolean lcv;
  private static boolean lcw;
  private static boolean lcx;
  private static boolean lcy;
  private static String lcz;
  
  static
  {
    AppMethodBeat.i(94114);
    lcH = new c();
    TAG = "MicroMsg.CameraUtil";
    lcg = 1;
    lci = 2;
    lck = 90;
    lcl = 180;
    lcm = 270;
    lcn = "preview";
    lco = "record";
    lcp = "image";
    lcr = 35;
    lcs = lcj;
    lcu = true;
    lcw = true;
    lcx = com.tencent.mm.media.widget.d.c.bay();
    lcy = true;
    lcA = 40;
    lcB = 40;
    AppMethodBeat.o(94114);
  }
  
  public static int a(CaptureRequest.Builder paramBuilder)
  {
    AppMethodBeat.i(94102);
    p.k(paramBuilder, "builder");
    Integer localInteger = (Integer)paramBuilder.get(CaptureRequest.CONTROL_AE_MODE);
    if (localInteger == null)
    {
      paramBuilder = (Integer)paramBuilder.get(CaptureRequest.FLASH_MODE);
      if (paramBuilder != null) {
        break label75;
      }
      label43:
      if (paramBuilder != null) {
        break label85;
      }
    }
    label75:
    label85:
    while (paramBuilder.intValue() != 2)
    {
      if (paramBuilder != null) {
        break label101;
      }
      do
      {
        AppMethodBeat.o(94102);
        return 2;
        if (localInteger.intValue() != 2) {
          break;
        }
        AppMethodBeat.o(94102);
        return 3;
      } while (paramBuilder.intValue() == 0);
      break label43;
    }
    for (;;)
    {
      AppMethodBeat.o(94102);
      return 1;
      label101:
      if (paramBuilder.intValue() != 1) {
        break;
      }
    }
  }
  
  public static int a(CaptureRequest.Builder paramBuilder, List<String> paramList)
  {
    AppMethodBeat.i(94112);
    p.k(paramBuilder, "builder");
    ArrayList localArrayList = new ArrayList();
    String str = lcq;
    if (str == null) {
      p.iCn();
    }
    paramBuilder = ((Iterable)new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, str, lcE).ai(paramList)).iterator();
    while (paramBuilder.hasNext())
    {
      paramList = (String)paramBuilder.next();
      Log.i(TAG, "request tag %s", new Object[] { paramList });
      localArrayList.add(paramList);
    }
    paramBuilder = lcG;
    if (paramBuilder != null)
    {
      paramList = ((Iterable)paramBuilder).iterator();
      do
      {
        if (!paramList.hasNext()) {
          break;
        }
        paramBuilder = paramList.next();
      } while (!((com.tencent.mm.media.widget.b.a.c.a)paramBuilder).r(localArrayList));
      for (;;)
      {
        paramBuilder = (com.tencent.mm.media.widget.b.a.c.a)paramBuilder;
        if (paramBuilder == null) {
          break;
        }
        int i = paramBuilder.leu;
        AppMethodBeat.o(94112);
        return i;
        paramBuilder = null;
      }
    }
    AppMethodBeat.o(94112);
    return 0;
  }
  
  public static void a(CameraManager paramCameraManager)
  {
    lcf = paramCameraManager;
  }
  
  public static void a(CaptureRequest.Builder paramBuilder, String paramString, int paramInt)
  {
    AppMethodBeat.i(94111);
    p.k(paramBuilder, "builder");
    p.k(paramString, "tag");
    Object localObject = com.tencent.mm.media.widget.b.a.a.b.lef;
    if (p.h(paramString, com.tencent.mm.media.widget.b.a.a.b.aYO()))
    {
      paramString = lcq;
      if (paramString == null) {
        p.iCn();
      }
      paramString = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, paramString, lcE);
      paramBuilder = com.tencent.mm.media.widget.b.a.a.b.lef;
      localObject = com.tencent.mm.media.widget.b.a.a.b.aYN();
      paramBuilder = com.tencent.mm.media.widget.b.a.a.b.lef;
      String str = com.tencent.mm.media.widget.b.a.a.b.aYO();
      paramBuilder = com.tencent.mm.media.widget.b.a.b.ldu;
      int j = com.tencent.mm.media.widget.b.a.b.aYH();
      p.k(localObject, "key");
      paramBuilder = paramString.ldW;
      boolean bool;
      label216:
      int i;
      if (paramBuilder != null)
      {
        Iterator localIterator = ((Iterable)paramBuilder).iterator();
        if (!localIterator.hasNext()) {
          break label272;
        }
        paramBuilder = localIterator.next();
        com.tencent.mm.media.widget.b.a.a.a locala = (com.tencent.mm.media.widget.b.a.a.a)paramBuilder;
        if (!p.h(locala.ldO, localObject)) {
          break label267;
        }
        Integer localInteger = locala.ldP;
        if ((localInteger != null) && ((localInteger.intValue() & paramString.ldU) == 0)) {
          break label267;
        }
        localInteger = locala.ldT;
        if ((localInteger != null) && ((localInteger.intValue() & j) == 0)) {
          break label267;
        }
        if (str == null) {
          break label261;
        }
        bool = p.h(locala.ldQ, str);
        if (!bool) {
          break label267;
        }
        i = 1;
        label223:
        if (i == 0) {
          break label270;
        }
        label227:
        paramBuilder = (com.tencent.mm.media.widget.b.a.a.a)paramBuilder;
        if (paramBuilder != null) {
          break label277;
        }
      }
      label236:
      for (paramBuilder = null;; paramBuilder = ((ArrayList)paramBuilder).get(paramInt))
      {
        if (paramBuilder != null) {
          break label327;
        }
        paramBuilder = new t("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(94111);
        throw paramBuilder;
        bool = true;
        break label216;
        i = 0;
        break label223;
        break;
        paramBuilder = null;
        break label227;
        if (!(paramBuilder.ldR instanceof ArrayList)) {
          break label236;
        }
        paramBuilder = paramBuilder.ldR;
        if (paramBuilder == null)
        {
          paramBuilder = new t("null cannot be cast to non-null type kotlin.collections.ArrayList<*> /* = java.util.ArrayList<*> */");
          AppMethodBeat.o(94111);
          throw paramBuilder;
        }
      }
      label261:
      label267:
      label270:
      label272:
      label277:
      label327:
      lcz = (String)paramBuilder;
    }
    for (;;)
    {
      lcC = true;
      AppMethodBeat.o(94111);
      return;
      paramBuilder = com.tencent.mm.media.widget.b.a.a.b.lef;
      if (p.h(paramString, com.tencent.mm.media.widget.b.a.a.b.aYP()))
      {
        lcA = paramInt;
      }
      else
      {
        paramBuilder = com.tencent.mm.media.widget.b.a.a.b.lef;
        if (p.h(paramString, com.tencent.mm.media.widget.b.a.a.b.aYQ())) {
          lcB = paramInt;
        }
      }
    }
  }
  
  public static void a(CaptureResult paramCaptureResult)
  {
    Object localObject2 = null;
    AppMethodBeat.i(94110);
    p.k(paramCaptureResult, "result");
    if ((lcF != null) && (lcw))
    {
      Object localObject1 = lcq;
      if (localObject1 == null) {
        p.iCn();
      }
      com.tencent.mm.media.widget.b.a.b.b localb = new com.tencent.mm.media.widget.b.a.b.b(paramCaptureResult, (String)localObject1, lcF);
      localObject1 = com.tencent.mm.media.widget.b.a.b.b.leo;
      String str = com.tencent.mm.media.widget.b.a.b.b.aYV();
      localObject1 = com.tencent.mm.media.widget.b.a.b.ldu;
      int j = com.tencent.mm.media.widget.b.a.b.aYH();
      p.k(str, "key");
      localObject1 = localb.lem;
      Object localObject3;
      int i;
      if (localObject1 != null)
      {
        localObject3 = ((Iterable)localObject1).iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break label464;
        }
        localObject1 = ((Iterator)localObject3).next();
        Object localObject4 = (com.tencent.mm.media.widget.b.a.b.a)localObject1;
        if (p.h(((com.tencent.mm.media.widget.b.a.b.a)localObject4).ldO, str))
        {
          Integer localInteger = ((com.tencent.mm.media.widget.b.a.b.a)localObject4).ldP;
          if ((localInteger == null) || ((localInteger.intValue() & localb.ldU) != 0))
          {
            localObject4 = ((com.tencent.mm.media.widget.b.a.b.a)localObject4).ldT;
            if ((localObject4 == null) || ((((Integer)localObject4).intValue() & j) != 0))
            {
              i = 1;
              label186:
              if (i == 0) {
                break label462;
              }
              label190:
              if ((com.tencent.mm.media.widget.b.a.b.a)localObject1 != null) {
                break label469;
              }
            }
          }
        }
      }
      else
      {
        i = 0;
        label199:
        if (i == 0) {
          break label948;
        }
        localObject1 = lcq;
        if (localObject1 == null) {
          p.iCn();
        }
        localb = new com.tencent.mm.media.widget.b.a.b.b(paramCaptureResult, (String)localObject1, lcF);
        paramCaptureResult = com.tencent.mm.media.widget.b.a.b.b.leo;
        str = com.tencent.mm.media.widget.b.a.b.b.aYV();
        p.k(str, "key");
        paramCaptureResult = localObject2;
        if (localb.lel.get(localb.OI(str)) != null)
        {
          p.k(str, "key");
          paramCaptureResult = localb.lem;
          if (paramCaptureResult != null)
          {
            localObject1 = ((Iterable)paramCaptureResult).iterator();
            label294:
            if (!((Iterator)localObject1).hasNext()) {
              break label479;
            }
            paramCaptureResult = ((Iterator)localObject1).next();
            localObject3 = (com.tencent.mm.media.widget.b.a.b.a)paramCaptureResult;
            if (!p.h(((com.tencent.mm.media.widget.b.a.b.a)localObject3).ldO, str)) {
              break label474;
            }
            localObject3 = ((com.tencent.mm.media.widget.b.a.b.a)localObject3).ldP;
            if ((localObject3 != null) && ((((Integer)localObject3).intValue() & localb.ldU) == 0)) {
              break label474;
            }
            i = 1;
            label357:
            if (i == 0) {
              break label477;
            }
            label361:
            paramCaptureResult = (com.tencent.mm.media.widget.b.a.b.a)paramCaptureResult;
            if (paramCaptureResult != null) {
              break label484;
            }
          }
          localObject1 = null;
          label372:
          if (localObject1 != null) {
            break label492;
          }
          paramCaptureResult = localObject2;
        }
      }
      for (;;)
      {
        if (((p.h(lcD, paramCaptureResult) ^ true)) && (paramCaptureResult != null))
        {
          lcD = paramCaptureResult;
          paramCaptureResult = lbx;
          if (paramCaptureResult != null)
          {
            localObject1 = lcD;
            if (localObject1 == null) {
              p.iCn();
            }
            paramCaptureResult.invoke(localObject1);
          }
          paramCaptureResult = lcD;
          if (paramCaptureResult == null) {
            p.iCn();
          }
          if (paramCaptureResult.booleanValue())
          {
            lcu = true;
            lcv = false;
            AppMethodBeat.o(94110);
            return;
            i = 0;
            break label186;
            label462:
            break;
            label464:
            localObject1 = null;
            break label190;
            label469:
            i = 1;
            break label199;
            label474:
            i = 0;
            break label357;
            label477:
            break label294;
            label479:
            paramCaptureResult = null;
            break label361;
            label484:
            localObject1 = paramCaptureResult.lek;
            break label372;
            label492:
            switch (((String)localObject1).hashCode())
            {
            default: 
              paramCaptureResult = localObject2;
              break;
            case -1808118735: 
              paramCaptureResult = localObject2;
              if (!((String)localObject1).equals("String")) {
                continue;
              }
              paramCaptureResult = localb.lel.get(localb.OI(str));
              if (paramCaptureResult == null)
              {
                paramCaptureResult = new t("null cannot be cast to non-null type kotlin.String");
                AppMethodBeat.o(94110);
                throw paramCaptureResult;
              }
            case 2086184: 
              paramCaptureResult = localObject2;
              if (!((String)localObject1).equals("Byte")) {
                continue;
              }
              paramCaptureResult = localb.lel.get(localb.OI(str));
              if (paramCaptureResult == null)
              {
                paramCaptureResult = new t("null cannot be cast to non-null type kotlin.Byte");
                AppMethodBeat.o(94110);
                throw paramCaptureResult;
              }
            case 1729365000: 
              paramCaptureResult = localObject2;
              if (!((String)localObject1).equals("Boolean")) {
                continue;
              }
              paramCaptureResult = localb.lel.get(localb.OI(str));
              if (paramCaptureResult == null)
              {
                paramCaptureResult = new t("null cannot be cast to non-null type kotlin.Boolean");
                AppMethodBeat.o(94110);
                throw paramCaptureResult;
              }
            case 73679: 
              paramCaptureResult = localObject2;
              if (!((String)localObject1).equals("Int")) {
                continue;
              }
              paramCaptureResult = localb.lel.get(localb.OI(str));
              if (paramCaptureResult == null)
              {
                paramCaptureResult = new t("null cannot be cast to non-null type kotlin.Int");
                AppMethodBeat.o(94110);
                throw paramCaptureResult;
                paramCaptureResult = (Boolean)paramCaptureResult;
                continue;
                localObject1 = (String)paramCaptureResult;
                switch (((String)localObject1).hashCode())
                {
                default: 
                  paramCaptureResult = localObject2;
                  break;
                case 3569038: 
                  paramCaptureResult = localObject2;
                  if (!((String)localObject1).equals("true")) {
                    continue;
                  }
                  paramCaptureResult = Boolean.TRUE;
                  break;
                case 97196323: 
                  paramCaptureResult = localObject2;
                  if (!((String)localObject1).equals("false")) {
                    continue;
                  }
                  paramCaptureResult = Boolean.FALSE;
                  break;
                }
              }
              switch (((Integer)paramCaptureResult).intValue())
              {
              default: 
                paramCaptureResult = localObject2;
                break;
              case 0: 
                paramCaptureResult = Boolean.FALSE;
                break;
              case 1: 
                paramCaptureResult = Boolean.TRUE;
                continue;
                switch (((Byte)paramCaptureResult).byteValue())
                {
                default: 
                  paramCaptureResult = localObject2;
                  break;
                case 0: 
                  paramCaptureResult = Boolean.FALSE;
                  break;
                case 1: 
                  paramCaptureResult = Boolean.TRUE;
                }
                break;
              }
              break;
            }
          }
          lcu = false;
          lcv = true;
        }
      }
    }
    label948:
    AppMethodBeat.o(94110);
  }
  
  public static void a(boolean paramBoolean, CaptureRequest.Builder paramBuilder)
  {
    AppMethodBeat.i(94103);
    p.k(paramBuilder, "builder");
    if (com.tencent.mm.media.widget.d.c.baz())
    {
      if (paramBoolean)
      {
        paramBuilder.set(CaptureRequest.FLASH_MODE, Integer.valueOf(1));
        AppMethodBeat.o(94103);
        return;
      }
      paramBuilder.set(CaptureRequest.FLASH_MODE, Integer.valueOf(0));
      AppMethodBeat.o(94103);
      return;
    }
    if (paramBoolean)
    {
      paramBuilder.set(CaptureRequest.FLASH_MODE, Integer.valueOf(2));
      AppMethodBeat.o(94103);
      return;
    }
    paramBuilder.set(CaptureRequest.FLASH_MODE, Integer.valueOf(0));
    AppMethodBeat.o(94103);
  }
  
  private static void a(Size[] paramArrayOfSize, String paramString)
  {
    AppMethodBeat.i(94101);
    StringBuffer localStringBuffer = new StringBuffer();
    int j = paramArrayOfSize.length;
    int i = 0;
    while (i < j)
    {
      Size localSize = paramArrayOfSize[i];
      localStringBuffer.append("size: " + localSize.getHeight() + ',' + localSize.getWidth() + " ratios " + localSize.getHeight() * 1.0D / localSize.getWidth() + "||");
      i += 1;
    }
    Log.i(TAG, "Print currentCamera " + lcq + " support " + paramString + " sizes " + localStringBuffer);
    AppMethodBeat.o(94101);
  }
  
  public static String aYo()
  {
    return lcq;
  }
  
  public static boolean aYp()
  {
    AppMethodBeat.i(94097);
    boolean bool = p.h(lcq, us(lcg));
    AppMethodBeat.o(94097);
    return bool;
  }
  
  public static int aYq()
  {
    return lcr;
  }
  
  public static int aYr()
  {
    return lcs;
  }
  
  public static Point aYs()
  {
    return lct;
  }
  
  public static void aYt()
  {
    lcu = true;
    lcv = false;
    lcw = true;
    lcy = true;
    lcz = null;
    lcA = 40;
    lcB = 40;
    lcC = false;
    lcD = null;
  }
  
  public static Size[] aYu()
  {
    AppMethodBeat.i(94098);
    Object localObject2 = lcq;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = us(lcg);
    }
    localObject2 = lcf;
    if (localObject2 != null)
    {
      localObject1 = ((CameraManager)localObject2).getCameraCharacteristics((String)localObject1);
      if (localObject1 != null)
      {
        localObject1 = (StreamConfigurationMap)((CameraCharacteristics)localObject1).get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (localObject1 == null) {
          break label98;
        }
      }
    }
    label98:
    for (localObject1 = ((StreamConfigurationMap)localObject1).getOutputSizes(SurfaceTexture.class);; localObject1 = null)
    {
      if (localObject1 == null) {
        p.iCn();
      }
      a((Size[])localObject1, lcn);
      if (localObject1 == null) {
        p.iCn();
      }
      AppMethodBeat.o(94098);
      return localObject1;
      localObject1 = null;
      break;
    }
  }
  
  public static Size[] aYv()
  {
    AppMethodBeat.i(94099);
    Object localObject2 = lcq;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = us(lcg);
    }
    int i = lcr;
    localObject2 = lcf;
    if (localObject2 != null)
    {
      localObject1 = ((CameraManager)localObject2).getCameraCharacteristics((String)localObject1);
      if (localObject1 != null)
      {
        localObject1 = (StreamConfigurationMap)((CameraCharacteristics)localObject1).get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (localObject1 == null) {
          break label100;
        }
      }
    }
    label100:
    for (localObject1 = ((StreamConfigurationMap)localObject1).getOutputSizes(i);; localObject1 = null)
    {
      if (localObject1 == null) {
        p.iCn();
      }
      a((Size[])localObject1, lcp);
      if (localObject1 == null) {
        p.iCn();
      }
      AppMethodBeat.o(94099);
      return localObject1;
      localObject1 = null;
      break;
    }
  }
  
  public static boolean aYw()
  {
    AppMethodBeat.i(94113);
    ArrayList localArrayList = lcG;
    if (localArrayList != null)
    {
      if (!((Collection)localArrayList).isEmpty())
      {
        AppMethodBeat.o(94113);
        return true;
      }
      AppMethodBeat.o(94113);
      return false;
    }
    AppMethodBeat.o(94113);
    return false;
  }
  
  public static void b(CaptureRequest.Builder paramBuilder)
  {
    AppMethodBeat.i(94104);
    p.k(paramBuilder, "builder");
    Object localObject1 = lcq;
    if (localObject1 == null) {
      p.iCn();
    }
    localObject1 = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, lcE);
    Object localObject2 = com.tencent.mm.media.widget.b.a.a.b.lef;
    localObject2 = com.tencent.mm.media.widget.b.a.a.b.aYS();
    com.tencent.mm.media.widget.b.a.b localb = com.tencent.mm.media.widget.b.a.b.ldu;
    if (((com.tencent.mm.media.widget.b.a.a.b)localObject1).ax((String)localObject2, com.tencent.mm.media.widget.b.a.b.aYI()))
    {
      localObject1 = lcq;
      if (localObject1 == null) {
        p.iCn();
      }
      paramBuilder = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, lcE);
      localObject1 = com.tencent.mm.media.widget.b.a.a.b.lef;
      localObject1 = com.tencent.mm.media.widget.b.a.a.b.aYS();
      boolean bool = lcu;
      localObject2 = com.tencent.mm.media.widget.b.a.b.ldu;
      paramBuilder.c((String)localObject1, bool, com.tencent.mm.media.widget.b.a.b.aYI());
    }
    AppMethodBeat.o(94104);
  }
  
  public static void c(CaptureRequest.Builder paramBuilder)
  {
    AppMethodBeat.i(94105);
    p.k(paramBuilder, "builder");
    Object localObject1;
    Object localObject2;
    Object localObject3;
    boolean bool;
    if (!lcC)
    {
      localObject1 = lcq;
      if (localObject1 == null) {
        p.iCn();
      }
      localObject1 = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, lcE);
      localObject2 = com.tencent.mm.media.widget.b.a.a.b.lef;
      localObject2 = com.tencent.mm.media.widget.b.a.a.b.aYN();
      localObject3 = com.tencent.mm.media.widget.b.a.b.ldu;
      if (((com.tencent.mm.media.widget.b.a.a.b)localObject1).ax((String)localObject2, com.tencent.mm.media.widget.b.a.b.aYH()))
      {
        localObject1 = lcq;
        if (localObject1 == null) {
          p.iCn();
        }
        paramBuilder = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, lcE);
        localObject1 = com.tencent.mm.media.widget.b.a.a.b.lef;
        localObject1 = com.tencent.mm.media.widget.b.a.a.b.aYN();
        bool = lcy;
        localObject2 = com.tencent.mm.media.widget.b.a.b.ldu;
        paramBuilder.c((String)localObject1, bool, com.tencent.mm.media.widget.b.a.b.aYH());
        AppMethodBeat.o(94105);
      }
    }
    else
    {
      p.k(paramBuilder, "builder");
      localObject1 = lcq;
      if (localObject1 == null) {
        p.iCn();
      }
      localObject1 = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, lcE);
      localObject2 = com.tencent.mm.media.widget.b.a.a.b.lef;
      localObject2 = com.tencent.mm.media.widget.b.a.a.b.aYN();
      localObject3 = com.tencent.mm.media.widget.b.a.a.b.lef;
      localObject3 = com.tencent.mm.media.widget.b.a.a.b.aYO();
      bool = lcy;
      Object localObject4 = lcz;
      if (localObject4 == null) {
        p.iCn();
      }
      com.tencent.mm.media.widget.b.a.b localb = com.tencent.mm.media.widget.b.a.b.ldu;
      int i = com.tencent.mm.media.widget.b.a.b.aYH();
      p.k(localObject2, "key");
      p.k(localObject3, "child");
      ((com.tencent.mm.media.widget.b.a.a.b)localObject1).a((String)localObject2, (String)localObject3, bool, localObject4, i);
      localObject1 = lcq;
      if (localObject1 == null) {
        p.iCn();
      }
      localObject1 = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, lcE);
      localObject2 = com.tencent.mm.media.widget.b.a.a.b.lef;
      localObject2 = com.tencent.mm.media.widget.b.a.a.b.aYN();
      localObject3 = com.tencent.mm.media.widget.b.a.a.b.lef;
      localObject3 = com.tencent.mm.media.widget.b.a.a.b.aYP();
      bool = lcy;
      i = lcA;
      localObject4 = com.tencent.mm.media.widget.b.a.b.ldu;
      ((com.tencent.mm.media.widget.b.a.a.b)localObject1).a((String)localObject2, (String)localObject3, bool, i, com.tencent.mm.media.widget.b.a.b.aYH());
      localObject1 = lcq;
      if (localObject1 == null) {
        p.iCn();
      }
      paramBuilder = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, lcE);
      localObject1 = com.tencent.mm.media.widget.b.a.a.b.lef;
      localObject1 = com.tencent.mm.media.widget.b.a.a.b.aYN();
      localObject2 = com.tencent.mm.media.widget.b.a.a.b.lef;
      localObject2 = com.tencent.mm.media.widget.b.a.a.b.aYQ();
      bool = lcy;
      i = lcB;
      localObject3 = com.tencent.mm.media.widget.b.a.b.ldu;
      paramBuilder.a((String)localObject1, (String)localObject2, bool, i, com.tencent.mm.media.widget.b.a.b.aYH());
    }
    AppMethodBeat.o(94105);
  }
  
  public static void d(Point paramPoint)
  {
    lct = paramPoint;
  }
  
  public static void d(CaptureRequest.Builder paramBuilder)
  {
    AppMethodBeat.i(94106);
    p.k(paramBuilder, "builder");
    Object localObject1 = lcq;
    if (localObject1 == null) {
      p.iCn();
    }
    localObject1 = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, lcE);
    Object localObject2 = com.tencent.mm.media.widget.b.a.a.b.lef;
    localObject2 = com.tencent.mm.media.widget.b.a.a.b.aYR();
    com.tencent.mm.media.widget.b.a.b localb = com.tencent.mm.media.widget.b.a.b.ldu;
    if (((com.tencent.mm.media.widget.b.a.a.b)localObject1).ax((String)localObject2, com.tencent.mm.media.widget.b.a.b.aYI()))
    {
      localObject1 = lcq;
      if (localObject1 == null) {
        p.iCn();
      }
      paramBuilder = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, lcE);
      localObject1 = com.tencent.mm.media.widget.b.a.a.b.lef;
      localObject1 = com.tencent.mm.media.widget.b.a.a.b.aYR();
      boolean bool = lcv;
      localObject2 = com.tencent.mm.media.widget.b.a.b.ldu;
      paramBuilder.c((String)localObject1, bool, com.tencent.mm.media.widget.b.a.b.aYI());
    }
    AppMethodBeat.o(94106);
  }
  
  public static void e(CaptureRequest.Builder paramBuilder)
  {
    AppMethodBeat.i(94107);
    p.k(paramBuilder, "builder");
    Object localObject1 = lcq;
    if (localObject1 == null) {
      p.iCn();
    }
    localObject1 = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, lcE);
    Object localObject2 = com.tencent.mm.media.widget.b.a.a.b.lef;
    localObject2 = com.tencent.mm.media.widget.b.a.a.b.aYU();
    com.tencent.mm.media.widget.b.a.b localb = com.tencent.mm.media.widget.b.a.b.ldu;
    if (((com.tencent.mm.media.widget.b.a.a.b)localObject1).ax((String)localObject2, com.tencent.mm.media.widget.b.a.b.aYH()))
    {
      localObject1 = lcq;
      if (localObject1 == null) {
        p.iCn();
      }
      paramBuilder = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, lcE);
      localObject1 = com.tencent.mm.media.widget.b.a.a.b.lef;
      localObject1 = com.tencent.mm.media.widget.b.a.a.b.aYU();
      boolean bool = lcw;
      localObject2 = com.tencent.mm.media.widget.b.a.b.ldu;
      paramBuilder.c((String)localObject1, bool, com.tencent.mm.media.widget.b.a.b.aYH());
    }
    AppMethodBeat.o(94107);
  }
  
  public static void f(CaptureRequest.Builder paramBuilder)
  {
    AppMethodBeat.i(94108);
    p.k(paramBuilder, "builder");
    Object localObject1 = lcq;
    if (localObject1 == null) {
      p.iCn();
    }
    localObject1 = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, lcE);
    Object localObject2 = com.tencent.mm.media.widget.b.a.a.b.lef;
    localObject2 = com.tencent.mm.media.widget.b.a.a.b.aYT();
    com.tencent.mm.media.widget.b.a.b localb = com.tencent.mm.media.widget.b.a.b.ldu;
    if (((com.tencent.mm.media.widget.b.a.a.b)localObject1).ax((String)localObject2, com.tencent.mm.media.widget.b.a.b.aYJ()))
    {
      localObject1 = lcq;
      if (localObject1 == null) {
        p.iCn();
      }
      paramBuilder = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, lcE);
      localObject1 = com.tencent.mm.media.widget.b.a.a.b.lef;
      localObject1 = com.tencent.mm.media.widget.b.a.a.b.aYT();
      boolean bool = lcx;
      localObject2 = com.tencent.mm.media.widget.b.a.b.ldu;
      paramBuilder.c((String)localObject1, bool, com.tencent.mm.media.widget.b.a.b.aYJ());
    }
    AppMethodBeat.o(94108);
  }
  
  public static void fL(boolean paramBoolean)
  {
    lcu = paramBoolean;
  }
  
  public static void fM(boolean paramBoolean)
  {
    lcv = paramBoolean;
  }
  
  public static void fN(boolean paramBoolean)
  {
    lcw = paramBoolean;
  }
  
  public static void fO(boolean paramBoolean)
  {
    lcx = paramBoolean;
  }
  
  public static void fP(boolean paramBoolean)
  {
    lcy = paramBoolean;
  }
  
  public static void g(CaptureRequest.Builder paramBuilder)
  {
    AppMethodBeat.i(94109);
    p.k(paramBuilder, "builder");
    Object localObject = lcE;
    if (localObject != null)
    {
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.media.widget.b.a.a.a locala = (com.tencent.mm.media.widget.b.a.a.a)((Iterator)localObject).next();
        Log.i(TAG, "close effect :  " + locala.ldS);
        com.tencent.mm.media.widget.b.a.b.a(paramBuilder, locala, false);
      }
      AppMethodBeat.o(94109);
      return;
    }
    AppMethodBeat.o(94109);
  }
  
  public static void o(ArrayList<com.tencent.mm.media.widget.b.a.a.a> paramArrayList)
  {
    lcE = paramArrayList;
  }
  
  public static void o(kotlin.g.a.b<? super Boolean, x> paramb)
  {
    lbx = paramb;
  }
  
  public static void p(ArrayList<com.tencent.mm.media.widget.b.a.b.a> paramArrayList)
  {
    lcF = paramArrayList;
  }
  
  public static void q(ArrayList<com.tencent.mm.media.widget.b.a.c.a> paramArrayList)
  {
    lcG = paramArrayList;
  }
  
  static String us(int paramInt)
  {
    AppMethodBeat.i(94100);
    Object localObject1 = lcf;
    int i;
    label34:
    Object localObject2;
    label71:
    label89:
    label94:
    int j;
    if (localObject1 != null)
    {
      localObject1 = ((CameraManager)localObject1).getCameraIdList();
      if (localObject1 == null) {
        break label170;
      }
      int k = localObject1.length;
      i = 0;
      if (i >= k) {
        break label164;
      }
      Object localObject3 = localObject1[i];
      localObject2 = (String)localObject3;
      CameraManager localCameraManager = lcf;
      if (localCameraManager == null) {
        break label131;
      }
      localObject2 = localCameraManager.getCameraCharacteristics((String)localObject2);
      if (localObject2 == null) {
        break label137;
      }
      localObject2 = (Integer)((CameraCharacteristics)localObject2).get(CameraCharacteristics.LENS_FACING);
      if (localObject2 != null) {
        break label143;
      }
      j = 0;
      label96:
      if (j == 0) {
        break label157;
      }
      localObject1 = localObject3;
    }
    label104:
    for (localObject1 = (String)localObject1;; localObject1 = null)
    {
      if (localObject1 == null) {
        break label176;
      }
      AppMethodBeat.o(94100);
      return localObject1;
      localObject1 = null;
      break;
      localObject2 = null;
      break label71;
      localObject2 = null;
      break label89;
      if (((Integer)localObject2).intValue() != paramInt) {
        break label94;
      }
      j = 1;
      break label96;
      i += 1;
      break label34;
      localObject1 = null;
      break label104;
    }
    label131:
    label137:
    label143:
    label157:
    label164:
    label170:
    label176:
    Log.e(TAG, "can not find the id: %s in camera manage", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(94100);
    return String.valueOf(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.c
 * JD-Core Version:    0.7.0.1
 */