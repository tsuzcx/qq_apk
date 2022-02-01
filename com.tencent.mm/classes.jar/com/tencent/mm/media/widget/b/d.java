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
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/media/widget/camera2/CameraUtil;", "", "()V", "BACK_CAMERA", "", "getBACK_CAMERA", "()I", "FRONT_CAMERA", "getFRONT_CAMERA", "IMAGE_STREAM", "", "getIMAGE_STREAM", "()Ljava/lang/String;", "ORIENTATION_0", "getORIENTATION_0", "ORIENTATION_180", "getORIENTATION_180", "ORIENTATION_270", "getORIENTATION_270", "ORIENTATION_90", "getORIENTATION_90", "OTHER_CAMERA", "getOTHER_CAMERA", "PREVIEW_STREAM", "getPREVIEW_STREAM", "RECORD_STREAM", "getRECORD_STREAM", "TAG", "fbLevel", "getFbLevel", "setFbLevel", "(Ljava/lang/String;)V", "isDebugFaceBeauty", "", "()Z", "setDebugFaceBeauty", "(Z)V", "isDenoisyVendorOn", "setDenoisyVendorOn", "isFaceBeautyVendorOn", "setFaceBeautyVendorOn", "isHDRCheckerVendorOn", "setHDRCheckerVendorOn", "isHDRRetOn", "Ljava/lang/Boolean;", "isHDRVendorOn", "setHDRVendorOn", "isStabilizationOn", "setStabilizationOn", "isUseBackCamera", "mBackCameraId", "getMBackCameraId", "mCameraManager", "Landroid/hardware/camera2/CameraManager;", "getMCameraManager", "()Landroid/hardware/camera2/CameraManager;", "setMCameraManager", "(Landroid/hardware/camera2/CameraManager;)V", "value", "mCurrentCameraId", "getMCurrentCameraId", "setMCurrentCameraId", "mCurrentImageFormat", "getMCurrentImageFormat", "setMCurrentImageFormat", "(I)V", "mFrontCameraId", "getMFrontCameraId", "mScreenSize", "Landroid/graphics/Point;", "getMScreenSize", "()Landroid/graphics/Point;", "setMScreenSize", "(Landroid/graphics/Point;)V", "mSensorOrientation", "getMSensorOrientation", "setMSensorOrientation", "mSupportHardWardLevel", "getMSupportHardWardLevel", "mSupportImageFormats", "", "getMSupportImageFormats", "()[I", "mSupportImageSizes", "", "Landroid/util/Size;", "getMSupportImageSizes", "()[Landroid/util/Size;", "mSupportPreviewSizes", "getMSupportPreviewSizes", "mSupportRecordSizes", "getMSupportRecordSizes", "mSupportRequestVendorTags", "Ljava/util/ArrayList;", "Lcom/tencent/mm/media/widget/camera2/effect/request/WCCameraEffectRequestTag;", "Lkotlin/collections/ArrayList;", "getMSupportRequestVendorTags", "()Ljava/util/ArrayList;", "setMSupportRequestVendorTags", "(Ljava/util/ArrayList;)V", "mSupportResultVendorTags", "Lcom/tencent/mm/media/widget/camera2/effect/result/WCCameraEffectResultTag;", "getMSupportResultVendorTags", "setMSupportResultVendorTags", "mSupportSessionVendorType", "Lcom/tencent/mm/media/widget/camera2/effect/sessionType/WCCameraEffectSessionType;", "getMSupportSessionVendorType", "setMSupportSessionVendorType", "onHDRCheckerResult", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "ret", "", "getOnHDRCheckerResult", "()Lkotlin/jvm/functions/Function1;", "setOnHDRCheckerResult", "(Lkotlin/jvm/functions/Function1;)V", "skinRate", "getSkinRate", "setSkinRate", "slimRate", "getSlimRate", "setSlimRate", "checkHDRValue", "result", "Landroid/hardware/camera2/CaptureResult;", "configAllFaceBeautyTag", "builder", "Landroid/hardware/camera2/CaptureRequest$Builder;", "configCaptureSessionType", "requestList", "", "configDenoisy", "configFaceBeauty", "configHDR", "configHDRChecker", "configStabilization", "configVendorTagValue", "tag", "getCamera2SupportHardWardLevel", "id", "getCameraId", "getCameraOrientation", "getFlashMode", "getFormatNames", "format", "getHardWardSupportLevelNames", "level", "getSupportImageFormat", "getSupportImageSize", "(Ljava/lang/String;I)[Landroid/util/Size;", "getSupportPreviewSize", "(Ljava/lang/String;)[Landroid/util/Size;", "getSupportRecordSize", "initAllParameters", "initConfigParameters", "isSettleBySessionType", "isVendorDenoisySupported", "isVendorFaceBeautySupported", "isVendorHDRCheckerSupported", "isVendorHDRSupported", "printSupportFormat", "formats", "printSupportSize", "sizes", "type", "([Landroid/util/Size;Ljava/lang/String;)V", "resumeAllCameraEffect", "setFlashMode", "mode", "setFlashOn", "isOn", "plugin-mediaeditor_release"})
public final class d
{
  private static final String TAG = "MicroMsg.CameraUtil";
  private static d.g.a.b<? super Boolean, y> gXY;
  static final int gYA = 1;
  static final int gYB = 0;
  private static final int gYC = 2;
  private static final int gYD = 0;
  private static final int gYE = 90;
  private static final int gYF = 180;
  private static final int gYG = 270;
  private static final String gYH = "preview";
  private static final String gYI = "record";
  private static final String gYJ = "image";
  static String gYK;
  private static int gYL;
  static int gYM;
  private static Point gYN;
  private static boolean gYO;
  private static boolean gYP;
  private static boolean gYQ;
  private static boolean gYR;
  private static boolean gYS;
  private static String gYT;
  private static int gYU;
  private static int gYV;
  private static boolean gYW;
  private static Boolean gYX;
  private static ArrayList<com.tencent.mm.media.widget.b.a.a.a> gYY;
  private static ArrayList<com.tencent.mm.media.widget.b.a.b.a> gYZ;
  static CameraManager gYz;
  private static ArrayList<com.tencent.mm.media.widget.b.a.c.a> gZa;
  public static final d gZb;
  
  static
  {
    AppMethodBeat.i(94114);
    gZb = new d();
    TAG = "MicroMsg.CameraUtil";
    gYA = 1;
    gYC = 2;
    gYE = 90;
    gYF = 180;
    gYG = 270;
    gYH = "preview";
    gYI = "record";
    gYJ = "image";
    gYL = 35;
    gYM = gYD;
    gYO = true;
    gYQ = true;
    gYR = com.tencent.mm.media.widget.d.a.avy();
    gYS = true;
    gYU = 40;
    gYV = 40;
    AppMethodBeat.o(94114);
  }
  
  public static int a(CaptureRequest.Builder paramBuilder)
  {
    AppMethodBeat.i(94102);
    k.h(paramBuilder, "builder");
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
    k.h(paramBuilder, "builder");
    ArrayList localArrayList = new ArrayList();
    String str = gYK;
    if (str == null) {
      k.fOy();
    }
    paramBuilder = ((Iterable)new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, str, gYY).ab(paramList)).iterator();
    while (paramBuilder.hasNext())
    {
      paramList = (String)paramBuilder.next();
      ac.i(TAG, "request tag %s", new Object[] { paramList });
      localArrayList.add(paramList);
    }
    paramBuilder = gZa;
    if (paramBuilder != null)
    {
      paramList = ((Iterable)paramBuilder).iterator();
      do
      {
        if (!paramList.hasNext()) {
          break;
        }
        paramBuilder = paramList.next();
      } while (!((com.tencent.mm.media.widget.b.a.c.a)paramBuilder).n(localArrayList));
      for (;;)
      {
        paramBuilder = (com.tencent.mm.media.widget.b.a.c.a)paramBuilder;
        if (paramBuilder == null) {
          break;
        }
        int i = paramBuilder.haU;
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
    gYz = paramCameraManager;
  }
  
  public static void a(CaptureRequest.Builder paramBuilder, String paramString, int paramInt)
  {
    AppMethodBeat.i(94111);
    k.h(paramBuilder, "builder");
    k.h(paramString, "tag");
    Object localObject = com.tencent.mm.media.widget.b.a.a.b.haF;
    if (k.g(paramString, com.tencent.mm.media.widget.b.a.a.b.aux()))
    {
      paramString = gYK;
      if (paramString == null) {
        k.fOy();
      }
      paramString = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, paramString, gYY);
      paramBuilder = com.tencent.mm.media.widget.b.a.a.b.haF;
      localObject = com.tencent.mm.media.widget.b.a.a.b.auw();
      paramBuilder = com.tencent.mm.media.widget.b.a.a.b.haF;
      String str = com.tencent.mm.media.widget.b.a.a.b.aux();
      paramBuilder = com.tencent.mm.media.widget.b.a.b.gZU;
      int j = com.tencent.mm.media.widget.b.a.b.auq();
      k.h(localObject, "key");
      paramBuilder = paramString.haw;
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
        if (!k.g(locala.hao, localObject)) {
          break label267;
        }
        Integer localInteger = locala.hap;
        if ((localInteger != null) && ((localInteger.intValue() & paramString.hau) == 0)) {
          break label267;
        }
        localInteger = locala.hat;
        if ((localInteger != null) && ((localInteger.intValue() & j) == 0)) {
          break label267;
        }
        if (str == null) {
          break label261;
        }
        bool = k.g(locala.haq, str);
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
        paramBuilder = new v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(94111);
        throw paramBuilder;
        bool = true;
        break label216;
        i = 0;
        break label223;
        break;
        paramBuilder = null;
        break label227;
        if (!(paramBuilder.har instanceof ArrayList)) {
          break label236;
        }
        paramBuilder = paramBuilder.har;
        if (paramBuilder == null)
        {
          paramBuilder = new v("null cannot be cast to non-null type kotlin.collections.ArrayList<*> /* = java.util.ArrayList<*> */");
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
      gYT = (String)paramBuilder;
    }
    for (;;)
    {
      gYW = true;
      AppMethodBeat.o(94111);
      return;
      paramBuilder = com.tencent.mm.media.widget.b.a.a.b.haF;
      if (k.g(paramString, com.tencent.mm.media.widget.b.a.a.b.auy()))
      {
        gYU = paramInt;
      }
      else
      {
        paramBuilder = com.tencent.mm.media.widget.b.a.a.b.haF;
        if (k.g(paramString, com.tencent.mm.media.widget.b.a.a.b.auz())) {
          gYV = paramInt;
        }
      }
    }
  }
  
  public static void a(CaptureResult paramCaptureResult)
  {
    Object localObject2 = null;
    AppMethodBeat.i(94110);
    k.h(paramCaptureResult, "result");
    if ((gYZ != null) && (gYQ))
    {
      Object localObject1 = gYK;
      if (localObject1 == null) {
        k.fOy();
      }
      com.tencent.mm.media.widget.b.a.b.b localb = new com.tencent.mm.media.widget.b.a.b.b(paramCaptureResult, (String)localObject1, gYZ);
      localObject1 = com.tencent.mm.media.widget.b.a.b.b.haO;
      String str = com.tencent.mm.media.widget.b.a.b.b.auE();
      localObject1 = com.tencent.mm.media.widget.b.a.b.gZU;
      int j = com.tencent.mm.media.widget.b.a.b.auq();
      k.h(str, "key");
      localObject1 = localb.haM;
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
        if (k.g(((com.tencent.mm.media.widget.b.a.b.a)localObject4).hao, str))
        {
          Integer localInteger = ((com.tencent.mm.media.widget.b.a.b.a)localObject4).hap;
          if ((localInteger == null) || ((localInteger.intValue() & localb.hau) != 0))
          {
            localObject4 = ((com.tencent.mm.media.widget.b.a.b.a)localObject4).hat;
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
        localObject1 = gYK;
        if (localObject1 == null) {
          k.fOy();
        }
        localb = new com.tencent.mm.media.widget.b.a.b.b(paramCaptureResult, (String)localObject1, gYZ);
        paramCaptureResult = com.tencent.mm.media.widget.b.a.b.b.haO;
        str = com.tencent.mm.media.widget.b.a.b.b.auE();
        k.h(str, "key");
        paramCaptureResult = localObject2;
        if (localb.haL.get(localb.vs(str)) != null)
        {
          k.h(str, "key");
          paramCaptureResult = localb.haM;
          if (paramCaptureResult != null)
          {
            localObject1 = ((Iterable)paramCaptureResult).iterator();
            label294:
            if (!((Iterator)localObject1).hasNext()) {
              break label479;
            }
            paramCaptureResult = ((Iterator)localObject1).next();
            localObject3 = (com.tencent.mm.media.widget.b.a.b.a)paramCaptureResult;
            if (!k.g(((com.tencent.mm.media.widget.b.a.b.a)localObject3).hao, str)) {
              break label474;
            }
            localObject3 = ((com.tencent.mm.media.widget.b.a.b.a)localObject3).hap;
            if ((localObject3 != null) && ((((Integer)localObject3).intValue() & localb.hau) == 0)) {
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
        if (((k.g(gYX, paramCaptureResult) ^ true)) && (paramCaptureResult != null))
        {
          gYX = paramCaptureResult;
          paramCaptureResult = gXY;
          if (paramCaptureResult != null)
          {
            localObject1 = gYX;
            if (localObject1 == null) {
              k.fOy();
            }
            paramCaptureResult.ay(localObject1);
          }
          paramCaptureResult = gYX;
          if (paramCaptureResult == null) {
            k.fOy();
          }
          if (paramCaptureResult.booleanValue())
          {
            gYO = true;
            gYP = false;
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
            localObject1 = paramCaptureResult.haK;
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
              paramCaptureResult = localb.haL.get(localb.vs(str));
              if (paramCaptureResult == null)
              {
                paramCaptureResult = new v("null cannot be cast to non-null type kotlin.String");
                AppMethodBeat.o(94110);
                throw paramCaptureResult;
              }
            case 2086184: 
              paramCaptureResult = localObject2;
              if (!((String)localObject1).equals("Byte")) {
                continue;
              }
              paramCaptureResult = localb.haL.get(localb.vs(str));
              if (paramCaptureResult == null)
              {
                paramCaptureResult = new v("null cannot be cast to non-null type kotlin.Byte");
                AppMethodBeat.o(94110);
                throw paramCaptureResult;
              }
            case 1729365000: 
              paramCaptureResult = localObject2;
              if (!((String)localObject1).equals("Boolean")) {
                continue;
              }
              paramCaptureResult = localb.haL.get(localb.vs(str));
              if (paramCaptureResult == null)
              {
                paramCaptureResult = new v("null cannot be cast to non-null type kotlin.Boolean");
                AppMethodBeat.o(94110);
                throw paramCaptureResult;
              }
            case 73679: 
              paramCaptureResult = localObject2;
              if (!((String)localObject1).equals("Int")) {
                continue;
              }
              paramCaptureResult = localb.haL.get(localb.vs(str));
              if (paramCaptureResult == null)
              {
                paramCaptureResult = new v("null cannot be cast to non-null type kotlin.Int");
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
          gYO = false;
          gYP = true;
        }
      }
    }
    label948:
    AppMethodBeat.o(94110);
  }
  
  public static void a(boolean paramBoolean, CaptureRequest.Builder paramBuilder)
  {
    AppMethodBeat.i(94103);
    k.h(paramBuilder, "builder");
    if (com.tencent.mm.media.widget.d.a.avz())
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
    ac.i(TAG, "Print currentCamera " + gYK + " support " + paramString + " sizes " + localStringBuffer);
    AppMethodBeat.o(94101);
  }
  
  public static String aua()
  {
    return gYK;
  }
  
  public static boolean aub()
  {
    AppMethodBeat.i(94097);
    boolean bool = k.g(gYK, nA(gYA));
    AppMethodBeat.o(94097);
    return bool;
  }
  
  public static int auc()
  {
    return gYL;
  }
  
  public static int aud()
  {
    return gYM;
  }
  
  public static Point aue()
  {
    return gYN;
  }
  
  public static void auf()
  {
    gYO = true;
    gYP = false;
    gYQ = true;
    gYS = true;
    gYT = null;
    gYU = 40;
    gYV = 40;
    gYW = false;
    gYX = null;
  }
  
  public static Size[] aug()
  {
    AppMethodBeat.i(94098);
    Object localObject2 = gYK;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = nA(gYA);
    }
    localObject2 = gYz;
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
        k.fOy();
      }
      a((Size[])localObject1, gYH);
      if (localObject1 == null) {
        k.fOy();
      }
      AppMethodBeat.o(94098);
      return localObject1;
      localObject1 = null;
      break;
    }
  }
  
  public static Size[] auh()
  {
    AppMethodBeat.i(94099);
    Object localObject2 = gYK;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = nA(gYA);
    }
    int i = gYL;
    localObject2 = gYz;
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
        k.fOy();
      }
      a((Size[])localObject1, gYJ);
      if (localObject1 == null) {
        k.fOy();
      }
      AppMethodBeat.o(94099);
      return localObject1;
      localObject1 = null;
      break;
    }
  }
  
  public static boolean aui()
  {
    AppMethodBeat.i(94113);
    ArrayList localArrayList = gZa;
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
    k.h(paramBuilder, "builder");
    Object localObject1 = gYK;
    if (localObject1 == null) {
      k.fOy();
    }
    localObject1 = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, gYY);
    Object localObject2 = com.tencent.mm.media.widget.b.a.a.b.haF;
    localObject2 = com.tencent.mm.media.widget.b.a.a.b.auB();
    com.tencent.mm.media.widget.b.a.b localb = com.tencent.mm.media.widget.b.a.b.gZU;
    if (((com.tencent.mm.media.widget.b.a.a.b)localObject1).Y((String)localObject2, com.tencent.mm.media.widget.b.a.b.aur()))
    {
      localObject1 = gYK;
      if (localObject1 == null) {
        k.fOy();
      }
      paramBuilder = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, gYY);
      localObject1 = com.tencent.mm.media.widget.b.a.a.b.haF;
      localObject1 = com.tencent.mm.media.widget.b.a.a.b.auB();
      boolean bool = gYO;
      localObject2 = com.tencent.mm.media.widget.b.a.b.gZU;
      paramBuilder.b((String)localObject1, bool, com.tencent.mm.media.widget.b.a.b.aur());
    }
    AppMethodBeat.o(94104);
  }
  
  public static void c(Point paramPoint)
  {
    gYN = paramPoint;
  }
  
  public static void c(CaptureRequest.Builder paramBuilder)
  {
    AppMethodBeat.i(94105);
    k.h(paramBuilder, "builder");
    Object localObject1;
    Object localObject2;
    Object localObject3;
    boolean bool;
    if (!gYW)
    {
      localObject1 = gYK;
      if (localObject1 == null) {
        k.fOy();
      }
      localObject1 = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, gYY);
      localObject2 = com.tencent.mm.media.widget.b.a.a.b.haF;
      localObject2 = com.tencent.mm.media.widget.b.a.a.b.auw();
      localObject3 = com.tencent.mm.media.widget.b.a.b.gZU;
      if (((com.tencent.mm.media.widget.b.a.a.b)localObject1).Y((String)localObject2, com.tencent.mm.media.widget.b.a.b.auq()))
      {
        localObject1 = gYK;
        if (localObject1 == null) {
          k.fOy();
        }
        paramBuilder = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, gYY);
        localObject1 = com.tencent.mm.media.widget.b.a.a.b.haF;
        localObject1 = com.tencent.mm.media.widget.b.a.a.b.auw();
        bool = gYS;
        localObject2 = com.tencent.mm.media.widget.b.a.b.gZU;
        paramBuilder.b((String)localObject1, bool, com.tencent.mm.media.widget.b.a.b.auq());
        AppMethodBeat.o(94105);
      }
    }
    else
    {
      k.h(paramBuilder, "builder");
      localObject1 = gYK;
      if (localObject1 == null) {
        k.fOy();
      }
      localObject1 = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, gYY);
      localObject2 = com.tencent.mm.media.widget.b.a.a.b.haF;
      localObject2 = com.tencent.mm.media.widget.b.a.a.b.auw();
      localObject3 = com.tencent.mm.media.widget.b.a.a.b.haF;
      localObject3 = com.tencent.mm.media.widget.b.a.a.b.aux();
      bool = gYS;
      Object localObject4 = gYT;
      if (localObject4 == null) {
        k.fOy();
      }
      com.tencent.mm.media.widget.b.a.b localb = com.tencent.mm.media.widget.b.a.b.gZU;
      int i = com.tencent.mm.media.widget.b.a.b.auq();
      k.h(localObject2, "key");
      k.h(localObject3, "child");
      ((com.tencent.mm.media.widget.b.a.a.b)localObject1).a((String)localObject2, (String)localObject3, bool, localObject4, i);
      localObject1 = gYK;
      if (localObject1 == null) {
        k.fOy();
      }
      localObject1 = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, gYY);
      localObject2 = com.tencent.mm.media.widget.b.a.a.b.haF;
      localObject2 = com.tencent.mm.media.widget.b.a.a.b.auw();
      localObject3 = com.tencent.mm.media.widget.b.a.a.b.haF;
      localObject3 = com.tencent.mm.media.widget.b.a.a.b.auy();
      bool = gYS;
      i = gYU;
      localObject4 = com.tencent.mm.media.widget.b.a.b.gZU;
      ((com.tencent.mm.media.widget.b.a.a.b)localObject1).a((String)localObject2, (String)localObject3, bool, i, com.tencent.mm.media.widget.b.a.b.auq());
      localObject1 = gYK;
      if (localObject1 == null) {
        k.fOy();
      }
      paramBuilder = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, gYY);
      localObject1 = com.tencent.mm.media.widget.b.a.a.b.haF;
      localObject1 = com.tencent.mm.media.widget.b.a.a.b.auw();
      localObject2 = com.tencent.mm.media.widget.b.a.a.b.haF;
      localObject2 = com.tencent.mm.media.widget.b.a.a.b.auz();
      bool = gYS;
      i = gYV;
      localObject3 = com.tencent.mm.media.widget.b.a.b.gZU;
      paramBuilder.a((String)localObject1, (String)localObject2, bool, i, com.tencent.mm.media.widget.b.a.b.auq());
    }
    AppMethodBeat.o(94105);
  }
  
  public static void d(CaptureRequest.Builder paramBuilder)
  {
    AppMethodBeat.i(94106);
    k.h(paramBuilder, "builder");
    Object localObject1 = gYK;
    if (localObject1 == null) {
      k.fOy();
    }
    localObject1 = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, gYY);
    Object localObject2 = com.tencent.mm.media.widget.b.a.a.b.haF;
    localObject2 = com.tencent.mm.media.widget.b.a.a.b.auA();
    com.tencent.mm.media.widget.b.a.b localb = com.tencent.mm.media.widget.b.a.b.gZU;
    if (((com.tencent.mm.media.widget.b.a.a.b)localObject1).Y((String)localObject2, com.tencent.mm.media.widget.b.a.b.aur()))
    {
      localObject1 = gYK;
      if (localObject1 == null) {
        k.fOy();
      }
      paramBuilder = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, gYY);
      localObject1 = com.tencent.mm.media.widget.b.a.a.b.haF;
      localObject1 = com.tencent.mm.media.widget.b.a.a.b.auA();
      boolean bool = gYP;
      localObject2 = com.tencent.mm.media.widget.b.a.b.gZU;
      paramBuilder.b((String)localObject1, bool, com.tencent.mm.media.widget.b.a.b.aur());
    }
    AppMethodBeat.o(94106);
  }
  
  public static void e(CaptureRequest.Builder paramBuilder)
  {
    AppMethodBeat.i(94107);
    k.h(paramBuilder, "builder");
    Object localObject1 = gYK;
    if (localObject1 == null) {
      k.fOy();
    }
    localObject1 = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, gYY);
    Object localObject2 = com.tencent.mm.media.widget.b.a.a.b.haF;
    localObject2 = com.tencent.mm.media.widget.b.a.a.b.auD();
    com.tencent.mm.media.widget.b.a.b localb = com.tencent.mm.media.widget.b.a.b.gZU;
    if (((com.tencent.mm.media.widget.b.a.a.b)localObject1).Y((String)localObject2, com.tencent.mm.media.widget.b.a.b.auq()))
    {
      localObject1 = gYK;
      if (localObject1 == null) {
        k.fOy();
      }
      paramBuilder = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, gYY);
      localObject1 = com.tencent.mm.media.widget.b.a.a.b.haF;
      localObject1 = com.tencent.mm.media.widget.b.a.a.b.auD();
      boolean bool = gYQ;
      localObject2 = com.tencent.mm.media.widget.b.a.b.gZU;
      paramBuilder.b((String)localObject1, bool, com.tencent.mm.media.widget.b.a.b.auq());
    }
    AppMethodBeat.o(94107);
  }
  
  public static void ei(boolean paramBoolean)
  {
    gYO = paramBoolean;
  }
  
  public static void ej(boolean paramBoolean)
  {
    gYP = paramBoolean;
  }
  
  public static void ek(boolean paramBoolean)
  {
    gYQ = paramBoolean;
  }
  
  public static void el(boolean paramBoolean)
  {
    gYR = paramBoolean;
  }
  
  public static void em(boolean paramBoolean)
  {
    gYS = paramBoolean;
  }
  
  public static void f(CaptureRequest.Builder paramBuilder)
  {
    AppMethodBeat.i(94108);
    k.h(paramBuilder, "builder");
    Object localObject1 = gYK;
    if (localObject1 == null) {
      k.fOy();
    }
    localObject1 = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, gYY);
    Object localObject2 = com.tencent.mm.media.widget.b.a.a.b.haF;
    localObject2 = com.tencent.mm.media.widget.b.a.a.b.auC();
    com.tencent.mm.media.widget.b.a.b localb = com.tencent.mm.media.widget.b.a.b.gZU;
    if (((com.tencent.mm.media.widget.b.a.a.b)localObject1).Y((String)localObject2, com.tencent.mm.media.widget.b.a.b.aus()))
    {
      localObject1 = gYK;
      if (localObject1 == null) {
        k.fOy();
      }
      paramBuilder = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, gYY);
      localObject1 = com.tencent.mm.media.widget.b.a.a.b.haF;
      localObject1 = com.tencent.mm.media.widget.b.a.a.b.auC();
      boolean bool = gYR;
      localObject2 = com.tencent.mm.media.widget.b.a.b.gZU;
      paramBuilder.b((String)localObject1, bool, com.tencent.mm.media.widget.b.a.b.aus());
    }
    AppMethodBeat.o(94108);
  }
  
  public static void g(CaptureRequest.Builder paramBuilder)
  {
    AppMethodBeat.i(94109);
    k.h(paramBuilder, "builder");
    Object localObject = gYY;
    if (localObject != null)
    {
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.media.widget.b.a.a.a locala = (com.tencent.mm.media.widget.b.a.a.a)((Iterator)localObject).next();
        ac.i(TAG, "close effect :  " + locala.has);
        com.tencent.mm.media.widget.b.a.b.a(paramBuilder, locala, false);
      }
      AppMethodBeat.o(94109);
      return;
    }
    AppMethodBeat.o(94109);
  }
  
  public static void k(ArrayList<com.tencent.mm.media.widget.b.a.a.a> paramArrayList)
  {
    gYY = paramArrayList;
  }
  
  public static void l(ArrayList<com.tencent.mm.media.widget.b.a.b.a> paramArrayList)
  {
    gYZ = paramArrayList;
  }
  
  public static void m(ArrayList<com.tencent.mm.media.widget.b.a.c.a> paramArrayList)
  {
    gZa = paramArrayList;
  }
  
  public static void n(d.g.a.b<? super Boolean, y> paramb)
  {
    gXY = paramb;
  }
  
  static String nA(int paramInt)
  {
    AppMethodBeat.i(94100);
    Object localObject1 = gYz;
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
      CameraManager localCameraManager = gYz;
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
    ac.e(TAG, "can not find the id: %s in camera manage", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(94100);
    return String.valueOf(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.d
 * JD-Core Version:    0.7.0.1
 */