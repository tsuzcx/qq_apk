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
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/media/widget/camera2/CameraUtil;", "", "()V", "BACK_CAMERA", "", "getBACK_CAMERA", "()I", "FRONT_CAMERA", "getFRONT_CAMERA", "IMAGE_STREAM", "", "getIMAGE_STREAM", "()Ljava/lang/String;", "ORIENTATION_0", "getORIENTATION_0", "ORIENTATION_180", "getORIENTATION_180", "ORIENTATION_270", "getORIENTATION_270", "ORIENTATION_90", "getORIENTATION_90", "OTHER_CAMERA", "getOTHER_CAMERA", "PREVIEW_STREAM", "getPREVIEW_STREAM", "RECORD_STREAM", "getRECORD_STREAM", "TAG", "fbLevel", "getFbLevel", "setFbLevel", "(Ljava/lang/String;)V", "isDebugFaceBeauty", "", "()Z", "setDebugFaceBeauty", "(Z)V", "isDenoisyVendorOn", "setDenoisyVendorOn", "isFaceBeautyVendorOn", "setFaceBeautyVendorOn", "isHDRCheckerVendorOn", "setHDRCheckerVendorOn", "isHDRRetOn", "Ljava/lang/Boolean;", "isHDRVendorOn", "setHDRVendorOn", "isStabilizationOn", "setStabilizationOn", "isUseBackCamera", "mBackCameraId", "getMBackCameraId", "mCameraManager", "Landroid/hardware/camera2/CameraManager;", "getMCameraManager", "()Landroid/hardware/camera2/CameraManager;", "setMCameraManager", "(Landroid/hardware/camera2/CameraManager;)V", "value", "mCurrentCameraId", "getMCurrentCameraId", "setMCurrentCameraId", "mCurrentImageFormat", "getMCurrentImageFormat", "setMCurrentImageFormat", "(I)V", "mFrontCameraId", "getMFrontCameraId", "mScreenSize", "Landroid/graphics/Point;", "getMScreenSize", "()Landroid/graphics/Point;", "setMScreenSize", "(Landroid/graphics/Point;)V", "mSensorOrientation", "getMSensorOrientation", "setMSensorOrientation", "mSupportHardWardLevel", "getMSupportHardWardLevel", "mSupportImageFormats", "", "getMSupportImageFormats", "()[I", "mSupportImageSizes", "", "Landroid/util/Size;", "getMSupportImageSizes", "()[Landroid/util/Size;", "mSupportPreviewSizes", "getMSupportPreviewSizes", "mSupportRecordSizes", "getMSupportRecordSizes", "mSupportRequestVendorTags", "Ljava/util/ArrayList;", "Lcom/tencent/mm/media/widget/camera2/effect/request/WCCameraEffectRequestTag;", "Lkotlin/collections/ArrayList;", "getMSupportRequestVendorTags", "()Ljava/util/ArrayList;", "setMSupportRequestVendorTags", "(Ljava/util/ArrayList;)V", "mSupportResultVendorTags", "Lcom/tencent/mm/media/widget/camera2/effect/result/WCCameraEffectResultTag;", "getMSupportResultVendorTags", "setMSupportResultVendorTags", "mSupportSessionVendorType", "Lcom/tencent/mm/media/widget/camera2/effect/sessionType/WCCameraEffectSessionType;", "getMSupportSessionVendorType", "setMSupportSessionVendorType", "onHDRCheckerResult", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "ret", "", "getOnHDRCheckerResult", "()Lkotlin/jvm/functions/Function1;", "setOnHDRCheckerResult", "(Lkotlin/jvm/functions/Function1;)V", "skinRate", "getSkinRate", "setSkinRate", "slimRate", "getSlimRate", "setSlimRate", "checkHDRValue", "result", "Landroid/hardware/camera2/CaptureResult;", "configAllFaceBeautyTag", "builder", "Landroid/hardware/camera2/CaptureRequest$Builder;", "configCaptureSessionType", "requestList", "", "configDenoisy", "configFaceBeauty", "configHDR", "configHDRChecker", "configStabilization", "configVendorTagValue", "tag", "getCamera2SupportHardWardLevel", "id", "getCameraId", "getCameraOrientation", "getFlashMode", "getFormatNames", "format", "getHardWardSupportLevelNames", "level", "getSupportImageFormat", "getSupportImageSize", "(Ljava/lang/String;I)[Landroid/util/Size;", "getSupportPreviewSize", "(Ljava/lang/String;)[Landroid/util/Size;", "getSupportRecordSize", "initAllParameters", "initConfigParameters", "isSettleBySessionType", "isVendorDenoisySupported", "isVendorFaceBeautySupported", "isVendorHDRCheckerSupported", "isVendorHDRSupported", "printSupportFormat", "formats", "printSupportSize", "sizes", "type", "([Landroid/util/Size;Ljava/lang/String;)V", "resumeAllCameraEffect", "setFlashMode", "mode", "setFlashOn", "isOn", "plugin-mediaeditor_release"})
public final class d
{
  private static final String TAG = "MicroMsg.CameraUtil";
  private static d.g.a.b<? super Boolean, z> hsS;
  private static final int htA = 270;
  private static final String htB = "preview";
  private static final String htC = "record";
  private static final String htD = "image";
  static String htE;
  private static int htF = 0;
  static int htG = 0;
  private static Point htH;
  private static boolean htI = false;
  private static boolean htJ = false;
  private static boolean htK = false;
  private static boolean htL = false;
  private static boolean htM = false;
  private static String htN;
  private static int htO = 0;
  private static int htP = 0;
  private static boolean htQ = false;
  private static Boolean htR;
  private static ArrayList<com.tencent.mm.media.widget.b.a.a.a> htS;
  private static ArrayList<com.tencent.mm.media.widget.b.a.b.a> htT;
  private static ArrayList<com.tencent.mm.media.widget.b.a.c.a> htU;
  public static final d htV;
  static CameraManager htt;
  static final int htu = 1;
  static final int htv = 0;
  private static final int htw = 2;
  private static final int htx = 0;
  private static final int hty = 90;
  private static final int htz = 180;
  
  static
  {
    AppMethodBeat.i(94114);
    htV = new d();
    TAG = "MicroMsg.CameraUtil";
    htu = 1;
    htw = 2;
    hty = 90;
    htz = 180;
    htA = 270;
    htB = "preview";
    htC = "record";
    htD = "image";
    htF = 35;
    htG = htx;
    htI = true;
    htK = true;
    htL = com.tencent.mm.media.widget.d.a.ayA();
    htM = true;
    htO = 40;
    htP = 40;
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
    String str = htE;
    if (str == null) {
      p.gkB();
    }
    paramBuilder = ((Iterable)new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, str, htS).ac(paramList)).iterator();
    while (paramBuilder.hasNext())
    {
      paramList = (String)paramBuilder.next();
      ae.i(TAG, "request tag %s", new Object[] { paramList });
      localArrayList.add(paramList);
    }
    paramBuilder = htU;
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
        int i = paramBuilder.hvO;
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
    htt = paramCameraManager;
  }
  
  public static void a(CaptureRequest.Builder paramBuilder, String paramString, int paramInt)
  {
    AppMethodBeat.i(94111);
    p.h(paramBuilder, "builder");
    p.h(paramString, "tag");
    Object localObject = com.tencent.mm.media.widget.b.a.a.b.hvz;
    if (p.i(paramString, com.tencent.mm.media.widget.b.a.a.b.axz()))
    {
      paramString = htE;
      if (paramString == null) {
        p.gkB();
      }
      paramString = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, paramString, htS);
      paramBuilder = com.tencent.mm.media.widget.b.a.a.b.hvz;
      localObject = com.tencent.mm.media.widget.b.a.a.b.axy();
      paramBuilder = com.tencent.mm.media.widget.b.a.a.b.hvz;
      String str = com.tencent.mm.media.widget.b.a.a.b.axz();
      paramBuilder = com.tencent.mm.media.widget.b.a.b.huO;
      int j = com.tencent.mm.media.widget.b.a.b.axs();
      p.h(localObject, "key");
      paramBuilder = paramString.hvq;
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
        if (!p.i(locala.hvi, localObject)) {
          break label267;
        }
        Integer localInteger = locala.hvj;
        if ((localInteger != null) && ((localInteger.intValue() & paramString.hvo) == 0)) {
          break label267;
        }
        localInteger = locala.hvn;
        if ((localInteger != null) && ((localInteger.intValue() & j) == 0)) {
          break label267;
        }
        if (str == null) {
          break label261;
        }
        bool = p.i(locala.hvk, str);
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
        if (!(paramBuilder.hvl instanceof ArrayList)) {
          break label236;
        }
        paramBuilder = paramBuilder.hvl;
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
      htN = (String)paramBuilder;
    }
    for (;;)
    {
      htQ = true;
      AppMethodBeat.o(94111);
      return;
      paramBuilder = com.tencent.mm.media.widget.b.a.a.b.hvz;
      if (p.i(paramString, com.tencent.mm.media.widget.b.a.a.b.axA()))
      {
        htO = paramInt;
      }
      else
      {
        paramBuilder = com.tencent.mm.media.widget.b.a.a.b.hvz;
        if (p.i(paramString, com.tencent.mm.media.widget.b.a.a.b.axB())) {
          htP = paramInt;
        }
      }
    }
  }
  
  public static void a(CaptureResult paramCaptureResult)
  {
    Object localObject2 = null;
    AppMethodBeat.i(94110);
    p.h(paramCaptureResult, "result");
    if ((htT != null) && (htK))
    {
      Object localObject1 = htE;
      if (localObject1 == null) {
        p.gkB();
      }
      com.tencent.mm.media.widget.b.a.b.b localb = new com.tencent.mm.media.widget.b.a.b.b(paramCaptureResult, (String)localObject1, htT);
      localObject1 = com.tencent.mm.media.widget.b.a.b.b.hvI;
      String str = com.tencent.mm.media.widget.b.a.b.b.axG();
      localObject1 = com.tencent.mm.media.widget.b.a.b.huO;
      int j = com.tencent.mm.media.widget.b.a.b.axs();
      p.h(str, "key");
      localObject1 = localb.hvG;
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
        if (p.i(((com.tencent.mm.media.widget.b.a.b.a)localObject4).hvi, str))
        {
          Integer localInteger = ((com.tencent.mm.media.widget.b.a.b.a)localObject4).hvj;
          if ((localInteger == null) || ((localInteger.intValue() & localb.hvo) != 0))
          {
            localObject4 = ((com.tencent.mm.media.widget.b.a.b.a)localObject4).hvn;
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
        localObject1 = htE;
        if (localObject1 == null) {
          p.gkB();
        }
        localb = new com.tencent.mm.media.widget.b.a.b.b(paramCaptureResult, (String)localObject1, htT);
        paramCaptureResult = com.tencent.mm.media.widget.b.a.b.b.hvI;
        str = com.tencent.mm.media.widget.b.a.b.b.axG();
        p.h(str, "key");
        paramCaptureResult = localObject2;
        if (localb.hvF.get(localb.yT(str)) != null)
        {
          p.h(str, "key");
          paramCaptureResult = localb.hvG;
          if (paramCaptureResult != null)
          {
            localObject1 = ((Iterable)paramCaptureResult).iterator();
            label294:
            if (!((Iterator)localObject1).hasNext()) {
              break label479;
            }
            paramCaptureResult = ((Iterator)localObject1).next();
            localObject3 = (com.tencent.mm.media.widget.b.a.b.a)paramCaptureResult;
            if (!p.i(((com.tencent.mm.media.widget.b.a.b.a)localObject3).hvi, str)) {
              break label474;
            }
            localObject3 = ((com.tencent.mm.media.widget.b.a.b.a)localObject3).hvj;
            if ((localObject3 != null) && ((((Integer)localObject3).intValue() & localb.hvo) == 0)) {
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
        if (((p.i(htR, paramCaptureResult) ^ true)) && (paramCaptureResult != null))
        {
          htR = paramCaptureResult;
          paramCaptureResult = hsS;
          if (paramCaptureResult != null)
          {
            localObject1 = htR;
            if (localObject1 == null) {
              p.gkB();
            }
            paramCaptureResult.invoke(localObject1);
          }
          paramCaptureResult = htR;
          if (paramCaptureResult == null) {
            p.gkB();
          }
          if (paramCaptureResult.booleanValue())
          {
            htI = true;
            htJ = false;
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
            localObject1 = paramCaptureResult.hvE;
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
              paramCaptureResult = localb.hvF.get(localb.yT(str));
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
              paramCaptureResult = localb.hvF.get(localb.yT(str));
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
              paramCaptureResult = localb.hvF.get(localb.yT(str));
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
              paramCaptureResult = localb.hvF.get(localb.yT(str));
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
          htI = false;
          htJ = true;
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
    if (com.tencent.mm.media.widget.d.a.ayB())
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
    ae.i(TAG, "Print currentCamera " + htE + " support " + paramString + " sizes " + localStringBuffer);
    AppMethodBeat.o(94101);
  }
  
  public static String axc()
  {
    return htE;
  }
  
  public static boolean axd()
  {
    AppMethodBeat.i(94097);
    boolean bool = p.i(htE, oc(htu));
    AppMethodBeat.o(94097);
    return bool;
  }
  
  public static int axe()
  {
    return htF;
  }
  
  public static int axf()
  {
    return htG;
  }
  
  public static Point axg()
  {
    return htH;
  }
  
  public static void axh()
  {
    htI = true;
    htJ = false;
    htK = true;
    htM = true;
    htN = null;
    htO = 40;
    htP = 40;
    htQ = false;
    htR = null;
  }
  
  public static Size[] axi()
  {
    AppMethodBeat.i(94098);
    Object localObject2 = htE;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = oc(htu);
    }
    localObject2 = htt;
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
        p.gkB();
      }
      a((Size[])localObject1, htB);
      if (localObject1 == null) {
        p.gkB();
      }
      AppMethodBeat.o(94098);
      return localObject1;
      localObject1 = null;
      break;
    }
  }
  
  public static Size[] axj()
  {
    AppMethodBeat.i(94099);
    Object localObject2 = htE;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = oc(htu);
    }
    int i = htF;
    localObject2 = htt;
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
        p.gkB();
      }
      a((Size[])localObject1, htD);
      if (localObject1 == null) {
        p.gkB();
      }
      AppMethodBeat.o(94099);
      return localObject1;
      localObject1 = null;
      break;
    }
  }
  
  public static boolean axk()
  {
    AppMethodBeat.i(94113);
    ArrayList localArrayList = htU;
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
    Object localObject1 = htE;
    if (localObject1 == null) {
      p.gkB();
    }
    localObject1 = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, htS);
    Object localObject2 = com.tencent.mm.media.widget.b.a.a.b.hvz;
    localObject2 = com.tencent.mm.media.widget.b.a.a.b.axD();
    com.tencent.mm.media.widget.b.a.b localb = com.tencent.mm.media.widget.b.a.b.huO;
    if (((com.tencent.mm.media.widget.b.a.a.b)localObject1).ad((String)localObject2, com.tencent.mm.media.widget.b.a.b.axt()))
    {
      localObject1 = htE;
      if (localObject1 == null) {
        p.gkB();
      }
      paramBuilder = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, htS);
      localObject1 = com.tencent.mm.media.widget.b.a.a.b.hvz;
      localObject1 = com.tencent.mm.media.widget.b.a.a.b.axD();
      boolean bool = htI;
      localObject2 = com.tencent.mm.media.widget.b.a.b.huO;
      paramBuilder.b((String)localObject1, bool, com.tencent.mm.media.widget.b.a.b.axt());
    }
    AppMethodBeat.o(94104);
  }
  
  public static void c(Point paramPoint)
  {
    htH = paramPoint;
  }
  
  public static void c(CaptureRequest.Builder paramBuilder)
  {
    AppMethodBeat.i(94105);
    p.h(paramBuilder, "builder");
    Object localObject1;
    Object localObject2;
    Object localObject3;
    boolean bool;
    if (!htQ)
    {
      localObject1 = htE;
      if (localObject1 == null) {
        p.gkB();
      }
      localObject1 = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, htS);
      localObject2 = com.tencent.mm.media.widget.b.a.a.b.hvz;
      localObject2 = com.tencent.mm.media.widget.b.a.a.b.axy();
      localObject3 = com.tencent.mm.media.widget.b.a.b.huO;
      if (((com.tencent.mm.media.widget.b.a.a.b)localObject1).ad((String)localObject2, com.tencent.mm.media.widget.b.a.b.axs()))
      {
        localObject1 = htE;
        if (localObject1 == null) {
          p.gkB();
        }
        paramBuilder = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, htS);
        localObject1 = com.tencent.mm.media.widget.b.a.a.b.hvz;
        localObject1 = com.tencent.mm.media.widget.b.a.a.b.axy();
        bool = htM;
        localObject2 = com.tencent.mm.media.widget.b.a.b.huO;
        paramBuilder.b((String)localObject1, bool, com.tencent.mm.media.widget.b.a.b.axs());
        AppMethodBeat.o(94105);
      }
    }
    else
    {
      p.h(paramBuilder, "builder");
      localObject1 = htE;
      if (localObject1 == null) {
        p.gkB();
      }
      localObject1 = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, htS);
      localObject2 = com.tencent.mm.media.widget.b.a.a.b.hvz;
      localObject2 = com.tencent.mm.media.widget.b.a.a.b.axy();
      localObject3 = com.tencent.mm.media.widget.b.a.a.b.hvz;
      localObject3 = com.tencent.mm.media.widget.b.a.a.b.axz();
      bool = htM;
      Object localObject4 = htN;
      if (localObject4 == null) {
        p.gkB();
      }
      com.tencent.mm.media.widget.b.a.b localb = com.tencent.mm.media.widget.b.a.b.huO;
      int i = com.tencent.mm.media.widget.b.a.b.axs();
      p.h(localObject2, "key");
      p.h(localObject3, "child");
      ((com.tencent.mm.media.widget.b.a.a.b)localObject1).a((String)localObject2, (String)localObject3, bool, localObject4, i);
      localObject1 = htE;
      if (localObject1 == null) {
        p.gkB();
      }
      localObject1 = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, htS);
      localObject2 = com.tencent.mm.media.widget.b.a.a.b.hvz;
      localObject2 = com.tencent.mm.media.widget.b.a.a.b.axy();
      localObject3 = com.tencent.mm.media.widget.b.a.a.b.hvz;
      localObject3 = com.tencent.mm.media.widget.b.a.a.b.axA();
      bool = htM;
      i = htO;
      localObject4 = com.tencent.mm.media.widget.b.a.b.huO;
      ((com.tencent.mm.media.widget.b.a.a.b)localObject1).a((String)localObject2, (String)localObject3, bool, i, com.tencent.mm.media.widget.b.a.b.axs());
      localObject1 = htE;
      if (localObject1 == null) {
        p.gkB();
      }
      paramBuilder = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, htS);
      localObject1 = com.tencent.mm.media.widget.b.a.a.b.hvz;
      localObject1 = com.tencent.mm.media.widget.b.a.a.b.axy();
      localObject2 = com.tencent.mm.media.widget.b.a.a.b.hvz;
      localObject2 = com.tencent.mm.media.widget.b.a.a.b.axB();
      bool = htM;
      i = htP;
      localObject3 = com.tencent.mm.media.widget.b.a.b.huO;
      paramBuilder.a((String)localObject1, (String)localObject2, bool, i, com.tencent.mm.media.widget.b.a.b.axs());
    }
    AppMethodBeat.o(94105);
  }
  
  public static void d(CaptureRequest.Builder paramBuilder)
  {
    AppMethodBeat.i(94106);
    p.h(paramBuilder, "builder");
    Object localObject1 = htE;
    if (localObject1 == null) {
      p.gkB();
    }
    localObject1 = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, htS);
    Object localObject2 = com.tencent.mm.media.widget.b.a.a.b.hvz;
    localObject2 = com.tencent.mm.media.widget.b.a.a.b.axC();
    com.tencent.mm.media.widget.b.a.b localb = com.tencent.mm.media.widget.b.a.b.huO;
    if (((com.tencent.mm.media.widget.b.a.a.b)localObject1).ad((String)localObject2, com.tencent.mm.media.widget.b.a.b.axt()))
    {
      localObject1 = htE;
      if (localObject1 == null) {
        p.gkB();
      }
      paramBuilder = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, htS);
      localObject1 = com.tencent.mm.media.widget.b.a.a.b.hvz;
      localObject1 = com.tencent.mm.media.widget.b.a.a.b.axC();
      boolean bool = htJ;
      localObject2 = com.tencent.mm.media.widget.b.a.b.huO;
      paramBuilder.b((String)localObject1, bool, com.tencent.mm.media.widget.b.a.b.axt());
    }
    AppMethodBeat.o(94106);
  }
  
  public static void e(CaptureRequest.Builder paramBuilder)
  {
    AppMethodBeat.i(94107);
    p.h(paramBuilder, "builder");
    Object localObject1 = htE;
    if (localObject1 == null) {
      p.gkB();
    }
    localObject1 = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, htS);
    Object localObject2 = com.tencent.mm.media.widget.b.a.a.b.hvz;
    localObject2 = com.tencent.mm.media.widget.b.a.a.b.axF();
    com.tencent.mm.media.widget.b.a.b localb = com.tencent.mm.media.widget.b.a.b.huO;
    if (((com.tencent.mm.media.widget.b.a.a.b)localObject1).ad((String)localObject2, com.tencent.mm.media.widget.b.a.b.axs()))
    {
      localObject1 = htE;
      if (localObject1 == null) {
        p.gkB();
      }
      paramBuilder = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, htS);
      localObject1 = com.tencent.mm.media.widget.b.a.a.b.hvz;
      localObject1 = com.tencent.mm.media.widget.b.a.a.b.axF();
      boolean bool = htK;
      localObject2 = com.tencent.mm.media.widget.b.a.b.huO;
      paramBuilder.b((String)localObject1, bool, com.tencent.mm.media.widget.b.a.b.axs());
    }
    AppMethodBeat.o(94107);
  }
  
  public static void em(boolean paramBoolean)
  {
    htI = paramBoolean;
  }
  
  public static void en(boolean paramBoolean)
  {
    htJ = paramBoolean;
  }
  
  public static void eo(boolean paramBoolean)
  {
    htK = paramBoolean;
  }
  
  public static void ep(boolean paramBoolean)
  {
    htL = paramBoolean;
  }
  
  public static void eq(boolean paramBoolean)
  {
    htM = paramBoolean;
  }
  
  public static void f(CaptureRequest.Builder paramBuilder)
  {
    AppMethodBeat.i(94108);
    p.h(paramBuilder, "builder");
    Object localObject1 = htE;
    if (localObject1 == null) {
      p.gkB();
    }
    localObject1 = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, htS);
    Object localObject2 = com.tencent.mm.media.widget.b.a.a.b.hvz;
    localObject2 = com.tencent.mm.media.widget.b.a.a.b.axE();
    com.tencent.mm.media.widget.b.a.b localb = com.tencent.mm.media.widget.b.a.b.huO;
    if (((com.tencent.mm.media.widget.b.a.a.b)localObject1).ad((String)localObject2, com.tencent.mm.media.widget.b.a.b.axu()))
    {
      localObject1 = htE;
      if (localObject1 == null) {
        p.gkB();
      }
      paramBuilder = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, htS);
      localObject1 = com.tencent.mm.media.widget.b.a.a.b.hvz;
      localObject1 = com.tencent.mm.media.widget.b.a.a.b.axE();
      boolean bool = htL;
      localObject2 = com.tencent.mm.media.widget.b.a.b.huO;
      paramBuilder.b((String)localObject1, bool, com.tencent.mm.media.widget.b.a.b.axu());
    }
    AppMethodBeat.o(94108);
  }
  
  public static void g(CaptureRequest.Builder paramBuilder)
  {
    AppMethodBeat.i(94109);
    p.h(paramBuilder, "builder");
    Object localObject = htS;
    if (localObject != null)
    {
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.media.widget.b.a.a.a locala = (com.tencent.mm.media.widget.b.a.a.a)((Iterator)localObject).next();
        ae.i(TAG, "close effect :  " + locala.hvm);
        com.tencent.mm.media.widget.b.a.b.a(paramBuilder, locala, false);
      }
      AppMethodBeat.o(94109);
      return;
    }
    AppMethodBeat.o(94109);
  }
  
  public static void k(ArrayList<com.tencent.mm.media.widget.b.a.a.a> paramArrayList)
  {
    htS = paramArrayList;
  }
  
  public static void l(ArrayList<com.tencent.mm.media.widget.b.a.b.a> paramArrayList)
  {
    htT = paramArrayList;
  }
  
  public static void m(ArrayList<com.tencent.mm.media.widget.b.a.c.a> paramArrayList)
  {
    htU = paramArrayList;
  }
  
  public static void o(d.g.a.b<? super Boolean, z> paramb)
  {
    hsS = paramb;
  }
  
  static String oc(int paramInt)
  {
    AppMethodBeat.i(94100);
    Object localObject1 = htt;
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
      CameraManager localCameraManager = htt;
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
    ae.e(TAG, "can not find the id: %s in camera manage", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(94100);
    return String.valueOf(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.d
 * JD-Core Version:    0.7.0.1
 */