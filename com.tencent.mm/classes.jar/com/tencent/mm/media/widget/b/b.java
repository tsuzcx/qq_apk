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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/widget/camera2/CameraUtil;", "", "()V", "BACK_CAMERA", "", "getBACK_CAMERA", "()I", "FRONT_CAMERA", "getFRONT_CAMERA", "IMAGE_STREAM", "", "getIMAGE_STREAM", "()Ljava/lang/String;", "ORIENTATION_0", "getORIENTATION_0", "ORIENTATION_180", "getORIENTATION_180", "ORIENTATION_270", "getORIENTATION_270", "ORIENTATION_90", "getORIENTATION_90", "OTHER_CAMERA", "getOTHER_CAMERA", "PREVIEW_STREAM", "getPREVIEW_STREAM", "RECORD_STREAM", "getRECORD_STREAM", "TAG", "fbLevel", "getFbLevel", "setFbLevel", "(Ljava/lang/String;)V", "isDebugFaceBeauty", "", "()Z", "setDebugFaceBeauty", "(Z)V", "isDenoisyVendorOn", "setDenoisyVendorOn", "isFaceBeautyVendorOn", "setFaceBeautyVendorOn", "isHDRCheckerVendorOn", "setHDRCheckerVendorOn", "isHDRRetOn", "Ljava/lang/Boolean;", "isHDRVendorOn", "setHDRVendorOn", "isStabilizationOn", "setStabilizationOn", "isUseBackCamera", "mBackCameraId", "getMBackCameraId", "mCameraManager", "Landroid/hardware/camera2/CameraManager;", "getMCameraManager", "()Landroid/hardware/camera2/CameraManager;", "setMCameraManager", "(Landroid/hardware/camera2/CameraManager;)V", "value", "mCurrentCameraId", "getMCurrentCameraId", "setMCurrentCameraId", "mCurrentImageFormat", "getMCurrentImageFormat", "setMCurrentImageFormat", "(I)V", "mFrontCameraId", "getMFrontCameraId", "mScreenSize", "Landroid/graphics/Point;", "getMScreenSize", "()Landroid/graphics/Point;", "setMScreenSize", "(Landroid/graphics/Point;)V", "mSensorOrientation", "getMSensorOrientation", "setMSensorOrientation", "mSupportHardWardLevel", "getMSupportHardWardLevel", "mSupportImageFormats", "", "getMSupportImageFormats", "()[I", "mSupportImageSizes", "", "Landroid/util/Size;", "getMSupportImageSizes", "()[Landroid/util/Size;", "mSupportPreviewSizes", "getMSupportPreviewSizes", "mSupportRecordSizes", "getMSupportRecordSizes", "mSupportRequestVendorTags", "Ljava/util/ArrayList;", "Lcom/tencent/mm/media/widget/camera2/effect/request/WCCameraEffectRequestTag;", "Lkotlin/collections/ArrayList;", "getMSupportRequestVendorTags", "()Ljava/util/ArrayList;", "setMSupportRequestVendorTags", "(Ljava/util/ArrayList;)V", "mSupportResultVendorTags", "Lcom/tencent/mm/media/widget/camera2/effect/result/WCCameraEffectResultTag;", "getMSupportResultVendorTags", "setMSupportResultVendorTags", "mSupportSessionVendorType", "Lcom/tencent/mm/media/widget/camera2/effect/sessionType/WCCameraEffectSessionType;", "getMSupportSessionVendorType", "setMSupportSessionVendorType", "onHDRCheckerResult", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "ret", "", "getOnHDRCheckerResult", "()Lkotlin/jvm/functions/Function1;", "setOnHDRCheckerResult", "(Lkotlin/jvm/functions/Function1;)V", "skinRate", "getSkinRate", "setSkinRate", "slimRate", "getSlimRate", "setSlimRate", "checkHDRValue", "result", "Landroid/hardware/camera2/CaptureResult;", "configAllFaceBeautyTag", "builder", "Landroid/hardware/camera2/CaptureRequest$Builder;", "configCaptureSessionType", "requestList", "", "configDenoisy", "configFaceBeauty", "configHDR", "configHDRChecker", "configStabilization", "configVendorTagValue", "tag", "getCamera2SupportHardWardLevel", "id", "getCameraId", "getCameraOrientation", "getFlashMode", "getFormatNames", "format", "getHardWardSupportLevelNames", "level", "getSupportImageFormat", "getSupportImageSize", "(Ljava/lang/String;I)[Landroid/util/Size;", "getSupportPreviewSize", "(Ljava/lang/String;)[Landroid/util/Size;", "getSupportRecordSize", "initAllParameters", "initConfigParameters", "isSettleBySessionType", "isVendorDenoisySupported", "isVendorFaceBeautySupported", "isVendorHDRCheckerSupported", "isVendorHDRSupported", "printSupportFormat", "formats", "printSupportSize", "sizes", "type", "([Landroid/util/Size;Ljava/lang/String;)V", "resumeAllCameraEffect", "setFlashMode", "mode", "setFlashOn", "isOn", "plugin-mediaeditor_release"})
public final class b
{
  private static final String TAG = "MicroMsg.CameraUtil";
  private static kotlin.g.a.b<? super Boolean, x> imw;
  private static Boolean inA;
  private static ArrayList<com.tencent.mm.media.widget.b.a.a.a> inB;
  private static ArrayList<com.tencent.mm.media.widget.b.a.b.a> inC;
  private static ArrayList<com.tencent.mm.media.widget.b.a.c.a> inD;
  public static final b inE;
  static CameraManager inc;
  static final int ind = 1;
  static final int ine = 0;
  private static final int inf = 2;
  private static final int ing = 0;
  private static final int inh = 90;
  private static final int ini = 180;
  private static final int inj = 270;
  private static final String ink = "preview";
  private static final String inl = "record";
  private static final String inm = "image";
  static String inn;
  private static int ino;
  static int inp;
  private static Point inq;
  private static boolean inr;
  private static boolean ins;
  private static boolean jdField_int;
  private static boolean inu;
  private static boolean inv;
  private static String inw;
  private static int inx;
  private static int iny;
  private static boolean inz;
  
  static
  {
    AppMethodBeat.i(94114);
    inE = new b();
    TAG = "MicroMsg.CameraUtil";
    ind = 1;
    inf = 2;
    inh = 90;
    ini = 180;
    inj = 270;
    ink = "preview";
    inl = "record";
    inm = "image";
    ino = 35;
    inp = ing;
    inr = true;
    jdField_int = true;
    inu = com.tencent.mm.media.widget.d.b.aRE();
    inv = true;
    inx = 40;
    iny = 40;
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
    String str = inn;
    if (str == null) {
      p.hyc();
    }
    paramBuilder = ((Iterable)new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, str, inB).ak(paramList)).iterator();
    while (paramBuilder.hasNext())
    {
      paramList = (String)paramBuilder.next();
      Log.i(TAG, "request tag %s", new Object[] { paramList });
      localArrayList.add(paramList);
    }
    paramBuilder = inD;
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
        int i = paramBuilder.ipp;
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
    inc = paramCameraManager;
  }
  
  public static void a(CaptureRequest.Builder paramBuilder, String paramString, int paramInt)
  {
    AppMethodBeat.i(94111);
    p.h(paramBuilder, "builder");
    p.h(paramString, "tag");
    Object localObject = com.tencent.mm.media.widget.b.a.a.b.ipa;
    if (p.j(paramString, com.tencent.mm.media.widget.b.a.a.b.aPX()))
    {
      paramString = inn;
      if (paramString == null) {
        p.hyc();
      }
      paramString = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, paramString, inB);
      paramBuilder = com.tencent.mm.media.widget.b.a.a.b.ipa;
      localObject = com.tencent.mm.media.widget.b.a.a.b.aPW();
      paramBuilder = com.tencent.mm.media.widget.b.a.a.b.ipa;
      String str = com.tencent.mm.media.widget.b.a.a.b.aPX();
      paramBuilder = com.tencent.mm.media.widget.b.a.b.iop;
      int j = com.tencent.mm.media.widget.b.a.b.aPQ();
      p.h(localObject, "key");
      paramBuilder = paramString.ioR;
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
        if (!p.j(locala.ioJ, localObject)) {
          break label267;
        }
        Integer localInteger = locala.ioK;
        if ((localInteger != null) && ((localInteger.intValue() & paramString.ioP) == 0)) {
          break label267;
        }
        localInteger = locala.ioO;
        if ((localInteger != null) && ((localInteger.intValue() & j) == 0)) {
          break label267;
        }
        if (str == null) {
          break label261;
        }
        bool = p.j(locala.ioL, str);
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
        if (!(paramBuilder.ioM instanceof ArrayList)) {
          break label236;
        }
        paramBuilder = paramBuilder.ioM;
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
      inw = (String)paramBuilder;
    }
    for (;;)
    {
      inz = true;
      AppMethodBeat.o(94111);
      return;
      paramBuilder = com.tencent.mm.media.widget.b.a.a.b.ipa;
      if (p.j(paramString, com.tencent.mm.media.widget.b.a.a.b.aPY()))
      {
        inx = paramInt;
      }
      else
      {
        paramBuilder = com.tencent.mm.media.widget.b.a.a.b.ipa;
        if (p.j(paramString, com.tencent.mm.media.widget.b.a.a.b.aPZ())) {
          iny = paramInt;
        }
      }
    }
  }
  
  public static void a(CaptureResult paramCaptureResult)
  {
    Object localObject2 = null;
    AppMethodBeat.i(94110);
    p.h(paramCaptureResult, "result");
    if ((inC != null) && (jdField_int))
    {
      Object localObject1 = inn;
      if (localObject1 == null) {
        p.hyc();
      }
      com.tencent.mm.media.widget.b.a.b.b localb = new com.tencent.mm.media.widget.b.a.b.b(paramCaptureResult, (String)localObject1, inC);
      localObject1 = com.tencent.mm.media.widget.b.a.b.b.ipj;
      String str = com.tencent.mm.media.widget.b.a.b.b.aQe();
      localObject1 = com.tencent.mm.media.widget.b.a.b.iop;
      int j = com.tencent.mm.media.widget.b.a.b.aPQ();
      p.h(str, "key");
      localObject1 = localb.iph;
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
        if (p.j(((com.tencent.mm.media.widget.b.a.b.a)localObject4).ioJ, str))
        {
          Integer localInteger = ((com.tencent.mm.media.widget.b.a.b.a)localObject4).ioK;
          if ((localInteger == null) || ((localInteger.intValue() & localb.ioP) != 0))
          {
            localObject4 = ((com.tencent.mm.media.widget.b.a.b.a)localObject4).ioO;
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
        localObject1 = inn;
        if (localObject1 == null) {
          p.hyc();
        }
        localb = new com.tencent.mm.media.widget.b.a.b.b(paramCaptureResult, (String)localObject1, inC);
        paramCaptureResult = com.tencent.mm.media.widget.b.a.b.b.ipj;
        str = com.tencent.mm.media.widget.b.a.b.b.aQe();
        p.h(str, "key");
        paramCaptureResult = localObject2;
        if (localb.ipg.get(localb.Hv(str)) != null)
        {
          p.h(str, "key");
          paramCaptureResult = localb.iph;
          if (paramCaptureResult != null)
          {
            localObject1 = ((Iterable)paramCaptureResult).iterator();
            label294:
            if (!((Iterator)localObject1).hasNext()) {
              break label479;
            }
            paramCaptureResult = ((Iterator)localObject1).next();
            localObject3 = (com.tencent.mm.media.widget.b.a.b.a)paramCaptureResult;
            if (!p.j(((com.tencent.mm.media.widget.b.a.b.a)localObject3).ioJ, str)) {
              break label474;
            }
            localObject3 = ((com.tencent.mm.media.widget.b.a.b.a)localObject3).ioK;
            if ((localObject3 != null) && ((((Integer)localObject3).intValue() & localb.ioP) == 0)) {
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
        if (((p.j(inA, paramCaptureResult) ^ true)) && (paramCaptureResult != null))
        {
          inA = paramCaptureResult;
          paramCaptureResult = imw;
          if (paramCaptureResult != null)
          {
            localObject1 = inA;
            if (localObject1 == null) {
              p.hyc();
            }
            paramCaptureResult.invoke(localObject1);
          }
          paramCaptureResult = inA;
          if (paramCaptureResult == null) {
            p.hyc();
          }
          if (paramCaptureResult.booleanValue())
          {
            inr = true;
            ins = false;
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
            localObject1 = paramCaptureResult.ipf;
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
              paramCaptureResult = localb.ipg.get(localb.Hv(str));
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
              paramCaptureResult = localb.ipg.get(localb.Hv(str));
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
              paramCaptureResult = localb.ipg.get(localb.Hv(str));
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
              paramCaptureResult = localb.ipg.get(localb.Hv(str));
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
          inr = false;
          ins = true;
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
    if (com.tencent.mm.media.widget.d.b.aRF())
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
    Log.i(TAG, "Print currentCamera " + inn + " support " + paramString + " sizes " + localStringBuffer);
    AppMethodBeat.o(94101);
  }
  
  public static String aPA()
  {
    return inn;
  }
  
  public static boolean aPB()
  {
    AppMethodBeat.i(94097);
    boolean bool = p.j(inn, ry(ind));
    AppMethodBeat.o(94097);
    return bool;
  }
  
  public static int aPC()
  {
    return ino;
  }
  
  public static int aPD()
  {
    return inp;
  }
  
  public static Point aPE()
  {
    return inq;
  }
  
  public static void aPF()
  {
    inr = true;
    ins = false;
    jdField_int = true;
    inv = true;
    inw = null;
    inx = 40;
    iny = 40;
    inz = false;
    inA = null;
  }
  
  public static Size[] aPG()
  {
    AppMethodBeat.i(94098);
    Object localObject2 = inn;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = ry(ind);
    }
    localObject2 = inc;
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
        p.hyc();
      }
      a((Size[])localObject1, ink);
      if (localObject1 == null) {
        p.hyc();
      }
      AppMethodBeat.o(94098);
      return localObject1;
      localObject1 = null;
      break;
    }
  }
  
  public static Size[] aPH()
  {
    AppMethodBeat.i(94099);
    Object localObject2 = inn;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = ry(ind);
    }
    int i = ino;
    localObject2 = inc;
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
        p.hyc();
      }
      a((Size[])localObject1, inm);
      if (localObject1 == null) {
        p.hyc();
      }
      AppMethodBeat.o(94099);
      return localObject1;
      localObject1 = null;
      break;
    }
  }
  
  public static boolean aPI()
  {
    AppMethodBeat.i(94113);
    ArrayList localArrayList = inD;
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
    Object localObject1 = inn;
    if (localObject1 == null) {
      p.hyc();
    }
    localObject1 = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, inB);
    Object localObject2 = com.tencent.mm.media.widget.b.a.a.b.ipa;
    localObject2 = com.tencent.mm.media.widget.b.a.a.b.aQb();
    com.tencent.mm.media.widget.b.a.b localb = com.tencent.mm.media.widget.b.a.b.iop;
    if (((com.tencent.mm.media.widget.b.a.a.b)localObject1).af((String)localObject2, com.tencent.mm.media.widget.b.a.b.aPR()))
    {
      localObject1 = inn;
      if (localObject1 == null) {
        p.hyc();
      }
      paramBuilder = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, inB);
      localObject1 = com.tencent.mm.media.widget.b.a.a.b.ipa;
      localObject1 = com.tencent.mm.media.widget.b.a.a.b.aQb();
      boolean bool = inr;
      localObject2 = com.tencent.mm.media.widget.b.a.b.iop;
      paramBuilder.b((String)localObject1, bool, com.tencent.mm.media.widget.b.a.b.aPR());
    }
    AppMethodBeat.o(94104);
  }
  
  public static void c(CaptureRequest.Builder paramBuilder)
  {
    AppMethodBeat.i(94105);
    p.h(paramBuilder, "builder");
    Object localObject1;
    Object localObject2;
    Object localObject3;
    boolean bool;
    if (!inz)
    {
      localObject1 = inn;
      if (localObject1 == null) {
        p.hyc();
      }
      localObject1 = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, inB);
      localObject2 = com.tencent.mm.media.widget.b.a.a.b.ipa;
      localObject2 = com.tencent.mm.media.widget.b.a.a.b.aPW();
      localObject3 = com.tencent.mm.media.widget.b.a.b.iop;
      if (((com.tencent.mm.media.widget.b.a.a.b)localObject1).af((String)localObject2, com.tencent.mm.media.widget.b.a.b.aPQ()))
      {
        localObject1 = inn;
        if (localObject1 == null) {
          p.hyc();
        }
        paramBuilder = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, inB);
        localObject1 = com.tencent.mm.media.widget.b.a.a.b.ipa;
        localObject1 = com.tencent.mm.media.widget.b.a.a.b.aPW();
        bool = inv;
        localObject2 = com.tencent.mm.media.widget.b.a.b.iop;
        paramBuilder.b((String)localObject1, bool, com.tencent.mm.media.widget.b.a.b.aPQ());
        AppMethodBeat.o(94105);
      }
    }
    else
    {
      p.h(paramBuilder, "builder");
      localObject1 = inn;
      if (localObject1 == null) {
        p.hyc();
      }
      localObject1 = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, inB);
      localObject2 = com.tencent.mm.media.widget.b.a.a.b.ipa;
      localObject2 = com.tencent.mm.media.widget.b.a.a.b.aPW();
      localObject3 = com.tencent.mm.media.widget.b.a.a.b.ipa;
      localObject3 = com.tencent.mm.media.widget.b.a.a.b.aPX();
      bool = inv;
      Object localObject4 = inw;
      if (localObject4 == null) {
        p.hyc();
      }
      com.tencent.mm.media.widget.b.a.b localb = com.tencent.mm.media.widget.b.a.b.iop;
      int i = com.tencent.mm.media.widget.b.a.b.aPQ();
      p.h(localObject2, "key");
      p.h(localObject3, "child");
      ((com.tencent.mm.media.widget.b.a.a.b)localObject1).a((String)localObject2, (String)localObject3, bool, localObject4, i);
      localObject1 = inn;
      if (localObject1 == null) {
        p.hyc();
      }
      localObject1 = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, inB);
      localObject2 = com.tencent.mm.media.widget.b.a.a.b.ipa;
      localObject2 = com.tencent.mm.media.widget.b.a.a.b.aPW();
      localObject3 = com.tencent.mm.media.widget.b.a.a.b.ipa;
      localObject3 = com.tencent.mm.media.widget.b.a.a.b.aPY();
      bool = inv;
      i = inx;
      localObject4 = com.tencent.mm.media.widget.b.a.b.iop;
      ((com.tencent.mm.media.widget.b.a.a.b)localObject1).a((String)localObject2, (String)localObject3, bool, i, com.tencent.mm.media.widget.b.a.b.aPQ());
      localObject1 = inn;
      if (localObject1 == null) {
        p.hyc();
      }
      paramBuilder = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, inB);
      localObject1 = com.tencent.mm.media.widget.b.a.a.b.ipa;
      localObject1 = com.tencent.mm.media.widget.b.a.a.b.aPW();
      localObject2 = com.tencent.mm.media.widget.b.a.a.b.ipa;
      localObject2 = com.tencent.mm.media.widget.b.a.a.b.aPZ();
      bool = inv;
      i = iny;
      localObject3 = com.tencent.mm.media.widget.b.a.b.iop;
      paramBuilder.a((String)localObject1, (String)localObject2, bool, i, com.tencent.mm.media.widget.b.a.b.aPQ());
    }
    AppMethodBeat.o(94105);
  }
  
  public static void d(Point paramPoint)
  {
    inq = paramPoint;
  }
  
  public static void d(CaptureRequest.Builder paramBuilder)
  {
    AppMethodBeat.i(94106);
    p.h(paramBuilder, "builder");
    Object localObject1 = inn;
    if (localObject1 == null) {
      p.hyc();
    }
    localObject1 = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, inB);
    Object localObject2 = com.tencent.mm.media.widget.b.a.a.b.ipa;
    localObject2 = com.tencent.mm.media.widget.b.a.a.b.aQa();
    com.tencent.mm.media.widget.b.a.b localb = com.tencent.mm.media.widget.b.a.b.iop;
    if (((com.tencent.mm.media.widget.b.a.a.b)localObject1).af((String)localObject2, com.tencent.mm.media.widget.b.a.b.aPR()))
    {
      localObject1 = inn;
      if (localObject1 == null) {
        p.hyc();
      }
      paramBuilder = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, inB);
      localObject1 = com.tencent.mm.media.widget.b.a.a.b.ipa;
      localObject1 = com.tencent.mm.media.widget.b.a.a.b.aQa();
      boolean bool = ins;
      localObject2 = com.tencent.mm.media.widget.b.a.b.iop;
      paramBuilder.b((String)localObject1, bool, com.tencent.mm.media.widget.b.a.b.aPR());
    }
    AppMethodBeat.o(94106);
  }
  
  public static void e(CaptureRequest.Builder paramBuilder)
  {
    AppMethodBeat.i(94107);
    p.h(paramBuilder, "builder");
    Object localObject1 = inn;
    if (localObject1 == null) {
      p.hyc();
    }
    localObject1 = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, inB);
    Object localObject2 = com.tencent.mm.media.widget.b.a.a.b.ipa;
    localObject2 = com.tencent.mm.media.widget.b.a.a.b.aQd();
    com.tencent.mm.media.widget.b.a.b localb = com.tencent.mm.media.widget.b.a.b.iop;
    if (((com.tencent.mm.media.widget.b.a.a.b)localObject1).af((String)localObject2, com.tencent.mm.media.widget.b.a.b.aPQ()))
    {
      localObject1 = inn;
      if (localObject1 == null) {
        p.hyc();
      }
      paramBuilder = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, inB);
      localObject1 = com.tencent.mm.media.widget.b.a.a.b.ipa;
      localObject1 = com.tencent.mm.media.widget.b.a.a.b.aQd();
      boolean bool = jdField_int;
      localObject2 = com.tencent.mm.media.widget.b.a.b.iop;
      paramBuilder.b((String)localObject1, bool, com.tencent.mm.media.widget.b.a.b.aPQ());
    }
    AppMethodBeat.o(94107);
  }
  
  public static void f(CaptureRequest.Builder paramBuilder)
  {
    AppMethodBeat.i(94108);
    p.h(paramBuilder, "builder");
    Object localObject1 = inn;
    if (localObject1 == null) {
      p.hyc();
    }
    localObject1 = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, inB);
    Object localObject2 = com.tencent.mm.media.widget.b.a.a.b.ipa;
    localObject2 = com.tencent.mm.media.widget.b.a.a.b.aQc();
    com.tencent.mm.media.widget.b.a.b localb = com.tencent.mm.media.widget.b.a.b.iop;
    if (((com.tencent.mm.media.widget.b.a.a.b)localObject1).af((String)localObject2, com.tencent.mm.media.widget.b.a.b.aPS()))
    {
      localObject1 = inn;
      if (localObject1 == null) {
        p.hyc();
      }
      paramBuilder = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, inB);
      localObject1 = com.tencent.mm.media.widget.b.a.a.b.ipa;
      localObject1 = com.tencent.mm.media.widget.b.a.a.b.aQc();
      boolean bool = inu;
      localObject2 = com.tencent.mm.media.widget.b.a.b.iop;
      paramBuilder.b((String)localObject1, bool, com.tencent.mm.media.widget.b.a.b.aPS());
    }
    AppMethodBeat.o(94108);
  }
  
  public static void fc(boolean paramBoolean)
  {
    inr = paramBoolean;
  }
  
  public static void fd(boolean paramBoolean)
  {
    ins = paramBoolean;
  }
  
  public static void fe(boolean paramBoolean)
  {
    jdField_int = paramBoolean;
  }
  
  public static void ff(boolean paramBoolean)
  {
    inu = paramBoolean;
  }
  
  public static void fg(boolean paramBoolean)
  {
    inv = paramBoolean;
  }
  
  public static void g(CaptureRequest.Builder paramBuilder)
  {
    AppMethodBeat.i(94109);
    p.h(paramBuilder, "builder");
    Object localObject = inB;
    if (localObject != null)
    {
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.media.widget.b.a.a.a locala = (com.tencent.mm.media.widget.b.a.a.a)((Iterator)localObject).next();
        Log.i(TAG, "close effect :  " + locala.ioN);
        com.tencent.mm.media.widget.b.a.b.a(paramBuilder, locala, false);
      }
      AppMethodBeat.o(94109);
      return;
    }
    AppMethodBeat.o(94109);
  }
  
  public static void o(ArrayList<com.tencent.mm.media.widget.b.a.a.a> paramArrayList)
  {
    inB = paramArrayList;
  }
  
  public static void o(kotlin.g.a.b<? super Boolean, x> paramb)
  {
    imw = paramb;
  }
  
  public static void p(ArrayList<com.tencent.mm.media.widget.b.a.b.a> paramArrayList)
  {
    inC = paramArrayList;
  }
  
  public static void q(ArrayList<com.tencent.mm.media.widget.b.a.c.a> paramArrayList)
  {
    inD = paramArrayList;
  }
  
  static String ry(int paramInt)
  {
    AppMethodBeat.i(94100);
    Object localObject1 = inc;
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
      CameraManager localCameraManager = inc;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.b
 * JD-Core Version:    0.7.0.1
 */