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
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/media/widget/camera2/CameraUtil;", "", "()V", "BACK_CAMERA", "", "getBACK_CAMERA", "()I", "FRONT_CAMERA", "getFRONT_CAMERA", "IMAGE_STREAM", "", "getIMAGE_STREAM", "()Ljava/lang/String;", "ORIENTATION_0", "getORIENTATION_0", "ORIENTATION_180", "getORIENTATION_180", "ORIENTATION_270", "getORIENTATION_270", "ORIENTATION_90", "getORIENTATION_90", "OTHER_CAMERA", "getOTHER_CAMERA", "PREVIEW_STREAM", "getPREVIEW_STREAM", "RECORD_STREAM", "getRECORD_STREAM", "TAG", "fbLevel", "getFbLevel", "setFbLevel", "(Ljava/lang/String;)V", "isDebugFaceBeauty", "", "()Z", "setDebugFaceBeauty", "(Z)V", "isDenoisyVendorOn", "setDenoisyVendorOn", "isFaceBeautyVendorOn", "setFaceBeautyVendorOn", "isHDRCheckerVendorOn", "setHDRCheckerVendorOn", "isHDRRetOn", "Ljava/lang/Boolean;", "isHDRVendorOn", "setHDRVendorOn", "isStabilizationOn", "setStabilizationOn", "isUseBackCamera", "mBackCameraId", "getMBackCameraId", "mCameraManager", "Landroid/hardware/camera2/CameraManager;", "getMCameraManager", "()Landroid/hardware/camera2/CameraManager;", "setMCameraManager", "(Landroid/hardware/camera2/CameraManager;)V", "value", "mCurrentCameraId", "getMCurrentCameraId", "setMCurrentCameraId", "mCurrentImageFormat", "getMCurrentImageFormat", "setMCurrentImageFormat", "(I)V", "mFrontCameraId", "getMFrontCameraId", "mScreenSize", "Landroid/graphics/Point;", "getMScreenSize", "()Landroid/graphics/Point;", "setMScreenSize", "(Landroid/graphics/Point;)V", "mSensorOrientation", "getMSensorOrientation", "setMSensorOrientation", "mSupportHardWardLevel", "getMSupportHardWardLevel", "mSupportImageFormats", "", "getMSupportImageFormats", "()[I", "mSupportImageSizes", "", "Landroid/util/Size;", "getMSupportImageSizes", "()[Landroid/util/Size;", "mSupportPreviewSizes", "getMSupportPreviewSizes", "mSupportRecordSizes", "getMSupportRecordSizes", "mSupportRequestVendorTags", "Ljava/util/ArrayList;", "Lcom/tencent/mm/media/widget/camera2/effect/request/WCCameraEffectRequestTag;", "Lkotlin/collections/ArrayList;", "getMSupportRequestVendorTags", "()Ljava/util/ArrayList;", "setMSupportRequestVendorTags", "(Ljava/util/ArrayList;)V", "mSupportResultVendorTags", "Lcom/tencent/mm/media/widget/camera2/effect/result/WCCameraEffectResultTag;", "getMSupportResultVendorTags", "setMSupportResultVendorTags", "mSupportSessionVendorType", "Lcom/tencent/mm/media/widget/camera2/effect/sessionType/WCCameraEffectSessionType;", "getMSupportSessionVendorType", "setMSupportSessionVendorType", "onHDRCheckerResult", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "ret", "", "getOnHDRCheckerResult", "()Lkotlin/jvm/functions/Function1;", "setOnHDRCheckerResult", "(Lkotlin/jvm/functions/Function1;)V", "skinRate", "getSkinRate", "setSkinRate", "slimRate", "getSlimRate", "setSlimRate", "checkHDRValue", "result", "Landroid/hardware/camera2/CaptureResult;", "configAllFaceBeautyTag", "builder", "Landroid/hardware/camera2/CaptureRequest$Builder;", "configCaptureSessionType", "requestList", "", "configDenoisy", "configFaceBeauty", "configHDR", "configHDRChecker", "configStabilization", "configVendorTagValue", "tag", "getCamera2SupportHardWardLevel", "id", "getCameraId", "getCameraOrientation", "getFlashMode", "getFormatNames", "format", "getHardWardSupportLevelNames", "level", "getSupportImageFormat", "getSupportImageSize", "(Ljava/lang/String;I)[Landroid/util/Size;", "getSupportPreviewSize", "(Ljava/lang/String;)[Landroid/util/Size;", "getSupportRecordSize", "initAllParameters", "initConfigParameters", "isSettleBySessionType", "isVendorDenoisySupported", "isVendorFaceBeautySupported", "isVendorHDRCheckerSupported", "isVendorHDRSupported", "printSupportFormat", "formats", "printSupportSize", "sizes", "type", "([Landroid/util/Size;Ljava/lang/String;)V", "resumeAllCameraEffect", "setFlashMode", "mode", "setFlashOn", "isOn", "plugin-mediaeditor_release"})
public final class d
{
  private static final String TAG = "MicroMsg.CameraUtil";
  static CameraManager hqF;
  static final int hqG = 1;
  static final int hqH = 0;
  private static final int hqI = 2;
  private static final int hqJ = 0;
  private static final int hqK = 90;
  private static final int hqL = 180;
  private static final int hqM = 270;
  private static final String hqN = "preview";
  private static final String hqO = "record";
  private static final String hqP = "image";
  static String hqQ;
  private static int hqR;
  static int hqS;
  private static Point hqT;
  private static boolean hqU;
  private static boolean hqV;
  private static boolean hqW;
  private static boolean hqX;
  private static boolean hqY;
  private static String hqZ;
  private static d.g.a.b<? super Boolean, z> hqe;
  private static int hra;
  private static int hrb;
  private static boolean hrc;
  private static Boolean hrd;
  private static ArrayList<com.tencent.mm.media.widget.b.a.a.a> hre;
  private static ArrayList<com.tencent.mm.media.widget.b.a.b.a> hrf;
  private static ArrayList<com.tencent.mm.media.widget.b.a.c.a> hrg;
  public static final d hrh;
  
  static
  {
    AppMethodBeat.i(94114);
    hrh = new d();
    TAG = "MicroMsg.CameraUtil";
    hqG = 1;
    hqI = 2;
    hqK = 90;
    hqL = 180;
    hqM = 270;
    hqN = "preview";
    hqO = "record";
    hqP = "image";
    hqR = 35;
    hqS = hqJ;
    hqU = true;
    hqW = true;
    hqX = com.tencent.mm.media.widget.d.a.ayl();
    hqY = true;
    hra = 40;
    hrb = 40;
    AppMethodBeat.o(94114);
  }
  
  public static int a(CaptureRequest.Builder paramBuilder)
  {
    AppMethodBeat.i(94102);
    p.h(paramBuilder, "builder");
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
    p.h(paramBuilder, "builder");
    ArrayList localArrayList = new ArrayList();
    String str = hqQ;
    if (str == null) {
      p.gfZ();
    }
    paramBuilder = ((Iterable)new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, str, hre).ac(paramList)).iterator();
    while (paramBuilder.hasNext())
    {
      paramList = (String)paramBuilder.next();
      ad.i(TAG, "request tag %s", new Object[] { paramList });
      localArrayList.add(paramList);
    }
    paramBuilder = hrg;
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
        int i = paramBuilder.hta;
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
    hqF = paramCameraManager;
  }
  
  public static void a(CaptureRequest.Builder paramBuilder, String paramString, int paramInt)
  {
    AppMethodBeat.i(94111);
    p.h(paramBuilder, "builder");
    p.h(paramString, "tag");
    Object localObject = com.tencent.mm.media.widget.b.a.a.b.hsL;
    if (p.i(paramString, com.tencent.mm.media.widget.b.a.a.b.axk()))
    {
      paramString = hqQ;
      if (paramString == null) {
        p.gfZ();
      }
      paramString = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, paramString, hre);
      paramBuilder = com.tencent.mm.media.widget.b.a.a.b.hsL;
      localObject = com.tencent.mm.media.widget.b.a.a.b.axj();
      paramBuilder = com.tencent.mm.media.widget.b.a.a.b.hsL;
      String str = com.tencent.mm.media.widget.b.a.a.b.axk();
      paramBuilder = com.tencent.mm.media.widget.b.a.b.hsa;
      int j = com.tencent.mm.media.widget.b.a.b.axd();
      p.h(localObject, "key");
      paramBuilder = paramString.hsC;
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
        if (!p.i(locala.hsu, localObject)) {
          break label267;
        }
        Integer localInteger = locala.hsv;
        if ((localInteger != null) && ((localInteger.intValue() & paramString.hsA) == 0)) {
          break label267;
        }
        localInteger = locala.hsz;
        if ((localInteger != null) && ((localInteger.intValue() & j) == 0)) {
          break label267;
        }
        if (str == null) {
          break label261;
        }
        bool = p.i(locala.hsw, str);
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
        if (!(paramBuilder.hsx instanceof ArrayList)) {
          break label236;
        }
        paramBuilder = paramBuilder.hsx;
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
      hqZ = (String)paramBuilder;
    }
    for (;;)
    {
      hrc = true;
      AppMethodBeat.o(94111);
      return;
      paramBuilder = com.tencent.mm.media.widget.b.a.a.b.hsL;
      if (p.i(paramString, com.tencent.mm.media.widget.b.a.a.b.axl()))
      {
        hra = paramInt;
      }
      else
      {
        paramBuilder = com.tencent.mm.media.widget.b.a.a.b.hsL;
        if (p.i(paramString, com.tencent.mm.media.widget.b.a.a.b.axm())) {
          hrb = paramInt;
        }
      }
    }
  }
  
  public static void a(CaptureResult paramCaptureResult)
  {
    Object localObject2 = null;
    AppMethodBeat.i(94110);
    p.h(paramCaptureResult, "result");
    if ((hrf != null) && (hqW))
    {
      Object localObject1 = hqQ;
      if (localObject1 == null) {
        p.gfZ();
      }
      com.tencent.mm.media.widget.b.a.b.b localb = new com.tencent.mm.media.widget.b.a.b.b(paramCaptureResult, (String)localObject1, hrf);
      localObject1 = com.tencent.mm.media.widget.b.a.b.b.hsU;
      String str = com.tencent.mm.media.widget.b.a.b.b.axr();
      localObject1 = com.tencent.mm.media.widget.b.a.b.hsa;
      int j = com.tencent.mm.media.widget.b.a.b.axd();
      p.h(str, "key");
      localObject1 = localb.hsS;
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
        if (p.i(((com.tencent.mm.media.widget.b.a.b.a)localObject4).hsu, str))
        {
          Integer localInteger = ((com.tencent.mm.media.widget.b.a.b.a)localObject4).hsv;
          if ((localInteger == null) || ((localInteger.intValue() & localb.hsA) != 0))
          {
            localObject4 = ((com.tencent.mm.media.widget.b.a.b.a)localObject4).hsz;
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
        localObject1 = hqQ;
        if (localObject1 == null) {
          p.gfZ();
        }
        localb = new com.tencent.mm.media.widget.b.a.b.b(paramCaptureResult, (String)localObject1, hrf);
        paramCaptureResult = com.tencent.mm.media.widget.b.a.b.b.hsU;
        str = com.tencent.mm.media.widget.b.a.b.b.axr();
        p.h(str, "key");
        paramCaptureResult = localObject2;
        if (localb.hsR.get(localb.yj(str)) != null)
        {
          p.h(str, "key");
          paramCaptureResult = localb.hsS;
          if (paramCaptureResult != null)
          {
            localObject1 = ((Iterable)paramCaptureResult).iterator();
            label294:
            if (!((Iterator)localObject1).hasNext()) {
              break label479;
            }
            paramCaptureResult = ((Iterator)localObject1).next();
            localObject3 = (com.tencent.mm.media.widget.b.a.b.a)paramCaptureResult;
            if (!p.i(((com.tencent.mm.media.widget.b.a.b.a)localObject3).hsu, str)) {
              break label474;
            }
            localObject3 = ((com.tencent.mm.media.widget.b.a.b.a)localObject3).hsv;
            if ((localObject3 != null) && ((((Integer)localObject3).intValue() & localb.hsA) == 0)) {
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
        if (((p.i(hrd, paramCaptureResult) ^ true)) && (paramCaptureResult != null))
        {
          hrd = paramCaptureResult;
          paramCaptureResult = hqe;
          if (paramCaptureResult != null)
          {
            localObject1 = hrd;
            if (localObject1 == null) {
              p.gfZ();
            }
            paramCaptureResult.invoke(localObject1);
          }
          paramCaptureResult = hrd;
          if (paramCaptureResult == null) {
            p.gfZ();
          }
          if (paramCaptureResult.booleanValue())
          {
            hqU = true;
            hqV = false;
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
            localObject1 = paramCaptureResult.hsQ;
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
              paramCaptureResult = localb.hsR.get(localb.yj(str));
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
              paramCaptureResult = localb.hsR.get(localb.yj(str));
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
              paramCaptureResult = localb.hsR.get(localb.yj(str));
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
              paramCaptureResult = localb.hsR.get(localb.yj(str));
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
          hqU = false;
          hqV = true;
        }
      }
    }
    label948:
    AppMethodBeat.o(94110);
  }
  
  public static void a(boolean paramBoolean, CaptureRequest.Builder paramBuilder)
  {
    AppMethodBeat.i(94103);
    p.h(paramBuilder, "builder");
    if (com.tencent.mm.media.widget.d.a.aym())
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
    ad.i(TAG, "Print currentCamera " + hqQ + " support " + paramString + " sizes " + localStringBuffer);
    AppMethodBeat.o(94101);
  }
  
  public static String awN()
  {
    return hqQ;
  }
  
  public static boolean awO()
  {
    AppMethodBeat.i(94097);
    boolean bool = p.i(hqQ, nZ(hqG));
    AppMethodBeat.o(94097);
    return bool;
  }
  
  public static int awP()
  {
    return hqR;
  }
  
  public static int awQ()
  {
    return hqS;
  }
  
  public static Point awR()
  {
    return hqT;
  }
  
  public static void awS()
  {
    hqU = true;
    hqV = false;
    hqW = true;
    hqY = true;
    hqZ = null;
    hra = 40;
    hrb = 40;
    hrc = false;
    hrd = null;
  }
  
  public static Size[] awT()
  {
    AppMethodBeat.i(94098);
    Object localObject2 = hqQ;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = nZ(hqG);
    }
    localObject2 = hqF;
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
        p.gfZ();
      }
      a((Size[])localObject1, hqN);
      if (localObject1 == null) {
        p.gfZ();
      }
      AppMethodBeat.o(94098);
      return localObject1;
      localObject1 = null;
      break;
    }
  }
  
  public static Size[] awU()
  {
    AppMethodBeat.i(94099);
    Object localObject2 = hqQ;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = nZ(hqG);
    }
    int i = hqR;
    localObject2 = hqF;
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
        p.gfZ();
      }
      a((Size[])localObject1, hqP);
      if (localObject1 == null) {
        p.gfZ();
      }
      AppMethodBeat.o(94099);
      return localObject1;
      localObject1 = null;
      break;
    }
  }
  
  public static boolean awV()
  {
    AppMethodBeat.i(94113);
    ArrayList localArrayList = hrg;
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
    p.h(paramBuilder, "builder");
    Object localObject1 = hqQ;
    if (localObject1 == null) {
      p.gfZ();
    }
    localObject1 = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, hre);
    Object localObject2 = com.tencent.mm.media.widget.b.a.a.b.hsL;
    localObject2 = com.tencent.mm.media.widget.b.a.a.b.axo();
    com.tencent.mm.media.widget.b.a.b localb = com.tencent.mm.media.widget.b.a.b.hsa;
    if (((com.tencent.mm.media.widget.b.a.a.b)localObject1).ac((String)localObject2, com.tencent.mm.media.widget.b.a.b.axe()))
    {
      localObject1 = hqQ;
      if (localObject1 == null) {
        p.gfZ();
      }
      paramBuilder = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, hre);
      localObject1 = com.tencent.mm.media.widget.b.a.a.b.hsL;
      localObject1 = com.tencent.mm.media.widget.b.a.a.b.axo();
      boolean bool = hqU;
      localObject2 = com.tencent.mm.media.widget.b.a.b.hsa;
      paramBuilder.b((String)localObject1, bool, com.tencent.mm.media.widget.b.a.b.axe());
    }
    AppMethodBeat.o(94104);
  }
  
  public static void c(Point paramPoint)
  {
    hqT = paramPoint;
  }
  
  public static void c(CaptureRequest.Builder paramBuilder)
  {
    AppMethodBeat.i(94105);
    p.h(paramBuilder, "builder");
    Object localObject1;
    Object localObject2;
    Object localObject3;
    boolean bool;
    if (!hrc)
    {
      localObject1 = hqQ;
      if (localObject1 == null) {
        p.gfZ();
      }
      localObject1 = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, hre);
      localObject2 = com.tencent.mm.media.widget.b.a.a.b.hsL;
      localObject2 = com.tencent.mm.media.widget.b.a.a.b.axj();
      localObject3 = com.tencent.mm.media.widget.b.a.b.hsa;
      if (((com.tencent.mm.media.widget.b.a.a.b)localObject1).ac((String)localObject2, com.tencent.mm.media.widget.b.a.b.axd()))
      {
        localObject1 = hqQ;
        if (localObject1 == null) {
          p.gfZ();
        }
        paramBuilder = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, hre);
        localObject1 = com.tencent.mm.media.widget.b.a.a.b.hsL;
        localObject1 = com.tencent.mm.media.widget.b.a.a.b.axj();
        bool = hqY;
        localObject2 = com.tencent.mm.media.widget.b.a.b.hsa;
        paramBuilder.b((String)localObject1, bool, com.tencent.mm.media.widget.b.a.b.axd());
        AppMethodBeat.o(94105);
      }
    }
    else
    {
      p.h(paramBuilder, "builder");
      localObject1 = hqQ;
      if (localObject1 == null) {
        p.gfZ();
      }
      localObject1 = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, hre);
      localObject2 = com.tencent.mm.media.widget.b.a.a.b.hsL;
      localObject2 = com.tencent.mm.media.widget.b.a.a.b.axj();
      localObject3 = com.tencent.mm.media.widget.b.a.a.b.hsL;
      localObject3 = com.tencent.mm.media.widget.b.a.a.b.axk();
      bool = hqY;
      Object localObject4 = hqZ;
      if (localObject4 == null) {
        p.gfZ();
      }
      com.tencent.mm.media.widget.b.a.b localb = com.tencent.mm.media.widget.b.a.b.hsa;
      int i = com.tencent.mm.media.widget.b.a.b.axd();
      p.h(localObject2, "key");
      p.h(localObject3, "child");
      ((com.tencent.mm.media.widget.b.a.a.b)localObject1).a((String)localObject2, (String)localObject3, bool, localObject4, i);
      localObject1 = hqQ;
      if (localObject1 == null) {
        p.gfZ();
      }
      localObject1 = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, hre);
      localObject2 = com.tencent.mm.media.widget.b.a.a.b.hsL;
      localObject2 = com.tencent.mm.media.widget.b.a.a.b.axj();
      localObject3 = com.tencent.mm.media.widget.b.a.a.b.hsL;
      localObject3 = com.tencent.mm.media.widget.b.a.a.b.axl();
      bool = hqY;
      i = hra;
      localObject4 = com.tencent.mm.media.widget.b.a.b.hsa;
      ((com.tencent.mm.media.widget.b.a.a.b)localObject1).a((String)localObject2, (String)localObject3, bool, i, com.tencent.mm.media.widget.b.a.b.axd());
      localObject1 = hqQ;
      if (localObject1 == null) {
        p.gfZ();
      }
      paramBuilder = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, hre);
      localObject1 = com.tencent.mm.media.widget.b.a.a.b.hsL;
      localObject1 = com.tencent.mm.media.widget.b.a.a.b.axj();
      localObject2 = com.tencent.mm.media.widget.b.a.a.b.hsL;
      localObject2 = com.tencent.mm.media.widget.b.a.a.b.axm();
      bool = hqY;
      i = hrb;
      localObject3 = com.tencent.mm.media.widget.b.a.b.hsa;
      paramBuilder.a((String)localObject1, (String)localObject2, bool, i, com.tencent.mm.media.widget.b.a.b.axd());
    }
    AppMethodBeat.o(94105);
  }
  
  public static void d(CaptureRequest.Builder paramBuilder)
  {
    AppMethodBeat.i(94106);
    p.h(paramBuilder, "builder");
    Object localObject1 = hqQ;
    if (localObject1 == null) {
      p.gfZ();
    }
    localObject1 = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, hre);
    Object localObject2 = com.tencent.mm.media.widget.b.a.a.b.hsL;
    localObject2 = com.tencent.mm.media.widget.b.a.a.b.axn();
    com.tencent.mm.media.widget.b.a.b localb = com.tencent.mm.media.widget.b.a.b.hsa;
    if (((com.tencent.mm.media.widget.b.a.a.b)localObject1).ac((String)localObject2, com.tencent.mm.media.widget.b.a.b.axe()))
    {
      localObject1 = hqQ;
      if (localObject1 == null) {
        p.gfZ();
      }
      paramBuilder = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, hre);
      localObject1 = com.tencent.mm.media.widget.b.a.a.b.hsL;
      localObject1 = com.tencent.mm.media.widget.b.a.a.b.axn();
      boolean bool = hqV;
      localObject2 = com.tencent.mm.media.widget.b.a.b.hsa;
      paramBuilder.b((String)localObject1, bool, com.tencent.mm.media.widget.b.a.b.axe());
    }
    AppMethodBeat.o(94106);
  }
  
  public static void e(CaptureRequest.Builder paramBuilder)
  {
    AppMethodBeat.i(94107);
    p.h(paramBuilder, "builder");
    Object localObject1 = hqQ;
    if (localObject1 == null) {
      p.gfZ();
    }
    localObject1 = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, hre);
    Object localObject2 = com.tencent.mm.media.widget.b.a.a.b.hsL;
    localObject2 = com.tencent.mm.media.widget.b.a.a.b.axq();
    com.tencent.mm.media.widget.b.a.b localb = com.tencent.mm.media.widget.b.a.b.hsa;
    if (((com.tencent.mm.media.widget.b.a.a.b)localObject1).ac((String)localObject2, com.tencent.mm.media.widget.b.a.b.axd()))
    {
      localObject1 = hqQ;
      if (localObject1 == null) {
        p.gfZ();
      }
      paramBuilder = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, hre);
      localObject1 = com.tencent.mm.media.widget.b.a.a.b.hsL;
      localObject1 = com.tencent.mm.media.widget.b.a.a.b.axq();
      boolean bool = hqW;
      localObject2 = com.tencent.mm.media.widget.b.a.b.hsa;
      paramBuilder.b((String)localObject1, bool, com.tencent.mm.media.widget.b.a.b.axd());
    }
    AppMethodBeat.o(94107);
  }
  
  public static void ek(boolean paramBoolean)
  {
    hqU = paramBoolean;
  }
  
  public static void el(boolean paramBoolean)
  {
    hqV = paramBoolean;
  }
  
  public static void em(boolean paramBoolean)
  {
    hqW = paramBoolean;
  }
  
  public static void en(boolean paramBoolean)
  {
    hqX = paramBoolean;
  }
  
  public static void eo(boolean paramBoolean)
  {
    hqY = paramBoolean;
  }
  
  public static void f(CaptureRequest.Builder paramBuilder)
  {
    AppMethodBeat.i(94108);
    p.h(paramBuilder, "builder");
    Object localObject1 = hqQ;
    if (localObject1 == null) {
      p.gfZ();
    }
    localObject1 = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, hre);
    Object localObject2 = com.tencent.mm.media.widget.b.a.a.b.hsL;
    localObject2 = com.tencent.mm.media.widget.b.a.a.b.axp();
    com.tencent.mm.media.widget.b.a.b localb = com.tencent.mm.media.widget.b.a.b.hsa;
    if (((com.tencent.mm.media.widget.b.a.a.b)localObject1).ac((String)localObject2, com.tencent.mm.media.widget.b.a.b.axf()))
    {
      localObject1 = hqQ;
      if (localObject1 == null) {
        p.gfZ();
      }
      paramBuilder = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, hre);
      localObject1 = com.tencent.mm.media.widget.b.a.a.b.hsL;
      localObject1 = com.tencent.mm.media.widget.b.a.a.b.axp();
      boolean bool = hqX;
      localObject2 = com.tencent.mm.media.widget.b.a.b.hsa;
      paramBuilder.b((String)localObject1, bool, com.tencent.mm.media.widget.b.a.b.axf());
    }
    AppMethodBeat.o(94108);
  }
  
  public static void g(CaptureRequest.Builder paramBuilder)
  {
    AppMethodBeat.i(94109);
    p.h(paramBuilder, "builder");
    Object localObject = hre;
    if (localObject != null)
    {
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.media.widget.b.a.a.a locala = (com.tencent.mm.media.widget.b.a.a.a)((Iterator)localObject).next();
        ad.i(TAG, "close effect :  " + locala.hsy);
        com.tencent.mm.media.widget.b.a.b.a(paramBuilder, locala, false);
      }
      AppMethodBeat.o(94109);
      return;
    }
    AppMethodBeat.o(94109);
  }
  
  public static void k(ArrayList<com.tencent.mm.media.widget.b.a.a.a> paramArrayList)
  {
    hre = paramArrayList;
  }
  
  public static void l(ArrayList<com.tencent.mm.media.widget.b.a.b.a> paramArrayList)
  {
    hrf = paramArrayList;
  }
  
  public static void m(ArrayList<com.tencent.mm.media.widget.b.a.c.a> paramArrayList)
  {
    hrg = paramArrayList;
  }
  
  static String nZ(int paramInt)
  {
    AppMethodBeat.i(94100);
    Object localObject1 = hqF;
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
      CameraManager localCameraManager = hqF;
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
    ad.e(TAG, "can not find the id: %s in camera manage", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(94100);
    return String.valueOf(paramInt);
  }
  
  public static void o(d.g.a.b<? super Boolean, z> paramb)
  {
    hqe = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.d
 * JD-Core Version:    0.7.0.1
 */