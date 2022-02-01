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
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/widget/camera2/CameraUtil;", "", "()V", "BACK_CAMERA", "", "getBACK_CAMERA", "()I", "FRONT_CAMERA", "getFRONT_CAMERA", "IMAGE_STREAM", "", "getIMAGE_STREAM", "()Ljava/lang/String;", "ORIENTATION_0", "getORIENTATION_0", "ORIENTATION_180", "getORIENTATION_180", "ORIENTATION_270", "getORIENTATION_270", "ORIENTATION_90", "getORIENTATION_90", "OTHER_CAMERA", "getOTHER_CAMERA", "PREVIEW_STREAM", "getPREVIEW_STREAM", "RECORD_STREAM", "getRECORD_STREAM", "TAG", "fbLevel", "getFbLevel", "setFbLevel", "(Ljava/lang/String;)V", "isDebugFaceBeauty", "", "()Z", "setDebugFaceBeauty", "(Z)V", "isDenoisyVendorOn", "setDenoisyVendorOn", "isFaceBeautyVendorOn", "setFaceBeautyVendorOn", "isHDRCheckerVendorOn", "setHDRCheckerVendorOn", "isHDRRetOn", "Ljava/lang/Boolean;", "isHDRVendorOn", "setHDRVendorOn", "isStabilizationOn", "setStabilizationOn", "isUseBackCamera", "mBackCameraId", "getMBackCameraId", "mCameraManager", "Landroid/hardware/camera2/CameraManager;", "getMCameraManager", "()Landroid/hardware/camera2/CameraManager;", "setMCameraManager", "(Landroid/hardware/camera2/CameraManager;)V", "value", "mCurrentCameraId", "getMCurrentCameraId", "setMCurrentCameraId", "mCurrentImageFormat", "getMCurrentImageFormat", "setMCurrentImageFormat", "(I)V", "mFrontCameraId", "getMFrontCameraId", "mScreenSize", "Landroid/graphics/Point;", "getMScreenSize", "()Landroid/graphics/Point;", "setMScreenSize", "(Landroid/graphics/Point;)V", "mSensorOrientation", "getMSensorOrientation", "setMSensorOrientation", "mSupportHardWardLevel", "getMSupportHardWardLevel", "mSupportImageFormats", "", "getMSupportImageFormats", "()[I", "mSupportImageSizes", "", "Landroid/util/Size;", "getMSupportImageSizes", "()[Landroid/util/Size;", "mSupportPreviewSizes", "getMSupportPreviewSizes", "mSupportRecordSizes", "getMSupportRecordSizes", "mSupportRequestVendorTags", "Ljava/util/ArrayList;", "Lcom/tencent/mm/media/widget/camera2/effect/request/WCCameraEffectRequestTag;", "Lkotlin/collections/ArrayList;", "getMSupportRequestVendorTags", "()Ljava/util/ArrayList;", "setMSupportRequestVendorTags", "(Ljava/util/ArrayList;)V", "mSupportResultVendorTags", "Lcom/tencent/mm/media/widget/camera2/effect/result/WCCameraEffectResultTag;", "getMSupportResultVendorTags", "setMSupportResultVendorTags", "mSupportSessionVendorType", "Lcom/tencent/mm/media/widget/camera2/effect/sessionType/WCCameraEffectSessionType;", "getMSupportSessionVendorType", "setMSupportSessionVendorType", "onHDRCheckerResult", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "ret", "", "getOnHDRCheckerResult", "()Lkotlin/jvm/functions/Function1;", "setOnHDRCheckerResult", "(Lkotlin/jvm/functions/Function1;)V", "skinRate", "getSkinRate", "setSkinRate", "slimRate", "getSlimRate", "setSlimRate", "checkHDRValue", "result", "Landroid/hardware/camera2/CaptureResult;", "configAllFaceBeautyTag", "builder", "Landroid/hardware/camera2/CaptureRequest$Builder;", "configCaptureSessionType", "requestList", "", "configDenoisy", "configFaceBeauty", "configHDR", "configHDRChecker", "configStabilization", "configVendorTagValue", "tag", "getCamera2SupportHardWardLevel", "id", "getCameraId", "getCameraOrientation", "getFlashMode", "getFormatNames", "format", "getHardWardSupportLevelNames", "level", "getSupportImageFormat", "getSupportImageSize", "(Ljava/lang/String;I)[Landroid/util/Size;", "getSupportPreviewSize", "(Ljava/lang/String;)[Landroid/util/Size;", "getSupportRecordSize", "initAllParameters", "initConfigParameters", "isSettleBySessionType", "isVendorDenoisySupported", "isVendorFaceBeautySupported", "isVendorHDRCheckerSupported", "isVendorHDRSupported", "printSupportFormat", "formats", "printSupportSize", "sizes", "type", "([Landroid/util/Size;Ljava/lang/String;)V", "resumeAllCameraEffect", "setFlashMode", "mode", "setFlashOn", "isOn", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  static CameraManager Fk;
  private static final int ORIENTATION_0 = 0;
  private static final int ORIENTATION_180;
  private static final int ORIENTATION_270;
  private static final int ORIENTATION_90;
  private static final String TAG;
  private static kotlin.g.a.b<? super Boolean, ah> nGB;
  public static final c nGZ;
  static final int nHa;
  private static final int nHb = 0;
  private static final int nHc;
  private static final String nHd;
  private static final String nHe;
  private static final String nHf;
  static String nHg;
  private static int nHh;
  static int nHi;
  private static Point nHj;
  private static boolean nHk;
  private static boolean nHl;
  private static boolean nHm;
  private static boolean nHn;
  private static boolean nHo;
  private static String nHp;
  private static int nHq;
  private static int nHr;
  private static boolean nHs;
  private static Boolean nHt;
  private static ArrayList<com.tencent.mm.media.widget.b.a.a.a> nHu;
  private static ArrayList<com.tencent.mm.media.widget.b.a.b.a> nHv;
  private static ArrayList<com.tencent.mm.media.widget.b.a.c.a> nHw;
  
  static
  {
    AppMethodBeat.i(94114);
    nGZ = new c();
    TAG = "MicroMsg.CameraUtil";
    nHa = 1;
    nHc = 2;
    ORIENTATION_90 = 90;
    ORIENTATION_180 = 180;
    ORIENTATION_270 = 270;
    nHd = "preview";
    nHe = "record";
    nHf = "image";
    nHh = 35;
    nHi = ORIENTATION_0;
    nHk = true;
    nHm = true;
    nHn = com.tencent.mm.media.widget.d.c.bvs();
    nHo = true;
    nHq = 40;
    nHr = 40;
    AppMethodBeat.o(94114);
  }
  
  public static void I(kotlin.g.a.b<? super Boolean, ah> paramb)
  {
    nGB = paramb;
  }
  
  public static int a(CaptureRequest.Builder paramBuilder)
  {
    AppMethodBeat.i(94102);
    s.u(paramBuilder, "builder");
    Integer localInteger = (Integer)paramBuilder.get(CaptureRequest.CONTROL_AE_MODE);
    label43:
    label47:
    label51:
    int i;
    if (localInteger == null)
    {
      paramBuilder = (Integer)paramBuilder.get(CaptureRequest.FLASH_MODE);
      if (paramBuilder != null) {
        break label81;
      }
      if (paramBuilder != null) {
        break label96;
      }
      if (paramBuilder != null) {
        break label109;
      }
      i = 0;
    }
    for (;;)
    {
      if (i != 0)
      {
        AppMethodBeat.o(94102);
        return 1;
        if (localInteger.intValue() != 2) {
          break;
        }
        AppMethodBeat.o(94102);
        return 3;
        label81:
        if (paramBuilder.intValue() != 0) {
          break label43;
        }
      }
      AppMethodBeat.o(94102);
      return 2;
      label96:
      if (paramBuilder.intValue() != 2) {
        break label47;
      }
      i = 1;
      continue;
      label109:
      if (paramBuilder.intValue() != 1) {
        break label51;
      }
      i = 1;
    }
  }
  
  public static int a(CaptureRequest.Builder paramBuilder, List<String> paramList)
  {
    AppMethodBeat.i(94112);
    s.u(paramBuilder, "builder");
    ArrayList localArrayList = new ArrayList();
    String str = nHg;
    s.checkNotNull(str);
    paramBuilder = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, str, nHu).bJ(paramList);
    if (paramBuilder != null)
    {
      paramBuilder = ((Iterable)paramBuilder).iterator();
      while (paramBuilder.hasNext())
      {
        paramList = (String)paramBuilder.next();
        Log.i(TAG, "request tag %s", new Object[] { paramList });
        localArrayList.add(paramList);
      }
    }
    paramBuilder = nHw;
    if (paramBuilder == null)
    {
      AppMethodBeat.o(94112);
      return 0;
    }
    paramList = ((Iterable)paramBuilder).iterator();
    do
    {
      if (!paramList.hasNext()) {
        break;
      }
      paramBuilder = paramList.next();
    } while (!((com.tencent.mm.media.widget.b.a.c.a)paramBuilder).u(localArrayList));
    for (;;)
    {
      paramBuilder = (com.tencent.mm.media.widget.b.a.c.a)paramBuilder;
      if (paramBuilder != null) {
        break;
      }
      AppMethodBeat.o(94112);
      return 0;
      paramBuilder = null;
    }
    int i = paramBuilder.nJe;
    AppMethodBeat.o(94112);
    return i;
  }
  
  public static void a(CameraManager paramCameraManager)
  {
    Fk = paramCameraManager;
  }
  
  public static void a(CaptureRequest.Builder paramBuilder, String paramString, int paramInt)
  {
    AppMethodBeat.i(94111);
    s.u(paramBuilder, "builder");
    s.u(paramString, "tag");
    Object localObject = com.tencent.mm.media.widget.b.a.a.b.nIE;
    if (s.p(paramString, com.tencent.mm.media.widget.b.a.a.b.btN()))
    {
      paramString = nHg;
      s.checkNotNull(paramString);
      paramString = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, paramString, nHu);
      paramBuilder = com.tencent.mm.media.widget.b.a.a.b.nIE;
      localObject = com.tencent.mm.media.widget.b.a.a.b.btM();
      paramBuilder = com.tencent.mm.media.widget.b.a.a.b.nIE;
      String str = com.tencent.mm.media.widget.b.a.a.b.btN();
      paramBuilder = com.tencent.mm.media.widget.b.a.b.nIb;
      int j = com.tencent.mm.media.widget.b.a.b.btG();
      s.u(localObject, "key");
      paramBuilder = paramString.nIG;
      if (paramBuilder == null)
      {
        paramBuilder = null;
        if ((paramBuilder == null) || (!(paramBuilder.nIB instanceof ArrayList))) {
          break label346;
        }
        paramBuilder = paramBuilder.nIB;
        if (paramBuilder == null)
        {
          paramBuilder = new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<*>{ kotlin.collections.TypeAliasesKt.ArrayList<*> }");
          AppMethodBeat.o(94111);
          throw paramBuilder;
        }
      }
      else
      {
        Iterator localIterator = ((Iterable)paramBuilder).iterator();
        label155:
        int i;
        label219:
        label248:
        boolean bool;
        if (localIterator.hasNext())
        {
          paramBuilder = localIterator.next();
          com.tencent.mm.media.widget.b.a.a.a locala = (com.tencent.mm.media.widget.b.a.a.a)paramBuilder;
          if (s.p(locala.nIy, localObject))
          {
            Integer localInteger = locala.nIz;
            if ((localInteger != null) && ((localInteger.intValue() & paramString.nIH) == 0))
            {
              i = 1;
              if (i != 0) {
                break label304;
              }
              localInteger = locala.nID;
              if ((localInteger == null) || ((localInteger.intValue() & j) != 0)) {
                break label293;
              }
              i = 1;
              if (i != 0) {
                break label304;
              }
              if (str == null) {
                break label298;
              }
              bool = s.p(locala.nIA, str);
              label269:
              if (!bool) {
                break label304;
              }
              i = 1;
              label276:
              if (i == 0) {
                break label307;
              }
            }
          }
        }
        for (;;)
        {
          paramBuilder = (com.tencent.mm.media.widget.b.a.a.a)paramBuilder;
          break;
          i = 0;
          break label219;
          label293:
          i = 0;
          break label248;
          label298:
          bool = true;
          break label269;
          label304:
          i = 0;
          break label276;
          label307:
          break label155;
          paramBuilder = null;
        }
      }
      label346:
      for (paramBuilder = ((ArrayList)paramBuilder).get(paramInt); paramBuilder == null; paramBuilder = null)
      {
        paramBuilder = new NullPointerException("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(94111);
        throw paramBuilder;
      }
      nHp = (String)paramBuilder;
    }
    for (;;)
    {
      nHs = true;
      AppMethodBeat.o(94111);
      return;
      paramBuilder = com.tencent.mm.media.widget.b.a.a.b.nIE;
      if (s.p(paramString, com.tencent.mm.media.widget.b.a.a.b.btO()))
      {
        nHq = paramInt;
      }
      else
      {
        paramBuilder = com.tencent.mm.media.widget.b.a.a.b.nIE;
        if (s.p(paramString, com.tencent.mm.media.widget.b.a.a.b.btP())) {
          nHr = paramInt;
        }
      }
    }
  }
  
  public static void a(CaptureResult paramCaptureResult)
  {
    Object localObject2 = null;
    AppMethodBeat.i(94110);
    s.u(paramCaptureResult, "result");
    if ((nHv != null) && (nHm))
    {
      Object localObject1 = nHg;
      s.checkNotNull(localObject1);
      com.tencent.mm.media.widget.b.a.b.b localb = new com.tencent.mm.media.widget.b.a.b.b(paramCaptureResult, (String)localObject1, nHv);
      localObject1 = com.tencent.mm.media.widget.b.a.b.b.nIV;
      String str = com.tencent.mm.media.widget.b.a.b.b.btU();
      localObject1 = com.tencent.mm.media.widget.b.a.b.nIb;
      int j = com.tencent.mm.media.widget.b.a.b.btG();
      s.u(str, "key");
      localObject1 = localb.nIX;
      int i;
      if (localObject1 == null)
      {
        localObject1 = null;
        if (localObject1 != null) {
          break label453;
        }
        i = 0;
        label93:
        if (i == 0) {
          break label926;
        }
        localObject1 = nHg;
        s.checkNotNull(localObject1);
        localb = new com.tencent.mm.media.widget.b.a.b.b(paramCaptureResult, (String)localObject1, nHv);
        paramCaptureResult = com.tencent.mm.media.widget.b.a.b.b.nIV;
        str = com.tencent.mm.media.widget.b.a.b.b.btU();
        s.u(str, "key");
        paramCaptureResult = localObject2;
        if (localb.nIW.get(localb.GY(str)) != null)
        {
          s.u(str, "key");
          paramCaptureResult = localb.nIX;
          if (paramCaptureResult != null) {
            break label458;
          }
          paramCaptureResult = null;
          if (paramCaptureResult != null) {
            break label564;
          }
          localObject1 = null;
          label183:
          paramCaptureResult = localObject2;
          if (localObject1 != null) {
            switch (((String)localObject1).hashCode())
            {
            default: 
              paramCaptureResult = localObject2;
            }
          }
        }
      }
      for (;;)
      {
        if ((!s.p(nHt, paramCaptureResult)) && (paramCaptureResult != null))
        {
          nHt = paramCaptureResult;
          paramCaptureResult = nGB;
          if (paramCaptureResult != null)
          {
            localObject1 = nHt;
            s.checkNotNull(localObject1);
            paramCaptureResult.invoke(localObject1);
          }
          paramCaptureResult = nHt;
          s.checkNotNull(paramCaptureResult);
          if (paramCaptureResult.booleanValue())
          {
            nHk = true;
            nHl = false;
            AppMethodBeat.o(94110);
            return;
            Object localObject3 = ((Iterable)localObject1).iterator();
            label322:
            if (((Iterator)localObject3).hasNext())
            {
              localObject1 = ((Iterator)localObject3).next();
              Object localObject4 = (com.tencent.mm.media.widget.b.a.b.a)localObject1;
              if (s.p(((com.tencent.mm.media.widget.b.a.b.a)localObject4).nIy, str))
              {
                Integer localInteger = ((com.tencent.mm.media.widget.b.a.b.a)localObject4).nIz;
                if ((localInteger != null) && ((localInteger.intValue() & localb.nIH) == 0))
                {
                  i = 1;
                  if (i != 0) {
                    break label443;
                  }
                  localObject4 = ((com.tencent.mm.media.widget.b.a.b.a)localObject4).nID;
                  if ((localObject4 == null) || ((((Integer)localObject4).intValue() & j) != 0)) {
                    break label438;
                  }
                  i = 1;
                  if (i != 0) {
                    break label443;
                  }
                  i = 1;
                  if (i == 0) {
                    break label446;
                  }
                }
              }
            }
            for (;;)
            {
              label387:
              label415:
              label421:
              localObject1 = (com.tencent.mm.media.widget.b.a.b.a)localObject1;
              break;
              i = 0;
              break label387;
              label438:
              i = 0;
              break label415;
              label443:
              i = 0;
              break label421;
              label446:
              break label322;
              localObject1 = null;
            }
            label453:
            i = 1;
            break label93;
            label458:
            localObject1 = ((Iterable)paramCaptureResult).iterator();
            label468:
            if (((Iterator)localObject1).hasNext())
            {
              paramCaptureResult = ((Iterator)localObject1).next();
              localObject3 = (com.tencent.mm.media.widget.b.a.b.a)paramCaptureResult;
              if (s.p(((com.tencent.mm.media.widget.b.a.b.a)localObject3).nIy, str))
              {
                localObject3 = ((com.tencent.mm.media.widget.b.a.b.a)localObject3).nIz;
                if ((localObject3 != null) && ((((Integer)localObject3).intValue() & localb.nIH) == 0))
                {
                  i = 1;
                  if (i != 0) {
                    break label554;
                  }
                  i = 1;
                  if (i == 0) {
                    break label557;
                  }
                }
              }
            }
            for (;;)
            {
              label531:
              label537:
              paramCaptureResult = (com.tencent.mm.media.widget.b.a.b.a)paramCaptureResult;
              break;
              i = 0;
              break label531;
              label554:
              i = 0;
              break label537;
              label557:
              break label468;
              paramCaptureResult = null;
            }
            label564:
            localObject1 = paramCaptureResult.nIU;
            break label183;
            paramCaptureResult = localObject2;
            if (!((String)localObject1).equals("Byte")) {
              continue;
            }
            paramCaptureResult = localb.nIW.get(localb.GY(str));
            if (paramCaptureResult == null)
            {
              paramCaptureResult = new NullPointerException("null cannot be cast to non-null type kotlin.Byte");
              AppMethodBeat.o(94110);
              throw paramCaptureResult;
              paramCaptureResult = localObject2;
              if (!((String)localObject1).equals("String")) {
                continue;
              }
              paramCaptureResult = localb.nIW.get(localb.GY(str));
              if (paramCaptureResult == null)
              {
                paramCaptureResult = new NullPointerException("null cannot be cast to non-null type kotlin.String");
                AppMethodBeat.o(94110);
                throw paramCaptureResult;
                paramCaptureResult = localObject2;
                if (!((String)localObject1).equals("Boolean")) {
                  continue;
                }
                paramCaptureResult = localb.nIW.get(localb.GY(str));
                if (paramCaptureResult == null)
                {
                  paramCaptureResult = new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                  AppMethodBeat.o(94110);
                  throw paramCaptureResult;
                  paramCaptureResult = localObject2;
                  if (!((String)localObject1).equals("Int")) {
                    continue;
                  }
                  paramCaptureResult = localb.nIW.get(localb.GY(str));
                  if (paramCaptureResult == null)
                  {
                    paramCaptureResult = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                    AppMethodBeat.o(94110);
                    throw paramCaptureResult;
                  }
                }
                else
                {
                  paramCaptureResult = Boolean.valueOf(((Boolean)paramCaptureResult).booleanValue());
                }
              }
              else
              {
                localObject1 = (String)paramCaptureResult;
                if (s.p(localObject1, "false"))
                {
                  paramCaptureResult = Boolean.FALSE;
                  continue;
                }
                paramCaptureResult = localObject2;
                if (!s.p(localObject1, "true")) {
                  continue;
                }
                paramCaptureResult = Boolean.TRUE;
                continue;
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
                break;
              }
            }
            i = ((Byte)paramCaptureResult).byteValue();
            if (i == 0)
            {
              paramCaptureResult = Boolean.FALSE;
              continue;
            }
            paramCaptureResult = localObject2;
            if (i != 1) {
              continue;
            }
            paramCaptureResult = Boolean.TRUE;
            continue;
          }
          nHk = false;
          nHl = true;
        }
      }
    }
    label926:
    AppMethodBeat.o(94110);
  }
  
  public static void a(boolean paramBoolean, CaptureRequest.Builder paramBuilder)
  {
    AppMethodBeat.i(94103);
    s.u(paramBuilder, "builder");
    if (com.tencent.mm.media.widget.d.c.bvt())
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
    Log.i(TAG, "Print currentCamera " + nHg + " support " + paramString + " sizes " + localStringBuffer);
    AppMethodBeat.o(94101);
  }
  
  public static void b(CaptureRequest.Builder paramBuilder)
  {
    AppMethodBeat.i(94104);
    s.u(paramBuilder, "builder");
    Object localObject1 = nHg;
    s.checkNotNull(localObject1);
    localObject1 = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, nHu);
    Object localObject2 = com.tencent.mm.media.widget.b.a.a.b.nIE;
    localObject2 = com.tencent.mm.media.widget.b.a.a.b.btR();
    com.tencent.mm.media.widget.b.a.b localb = com.tencent.mm.media.widget.b.a.b.nIb;
    if (((com.tencent.mm.media.widget.b.a.a.b)localObject1).aG((String)localObject2, com.tencent.mm.media.widget.b.a.b.btH()))
    {
      localObject1 = nHg;
      s.checkNotNull(localObject1);
      paramBuilder = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, nHu);
      localObject1 = com.tencent.mm.media.widget.b.a.a.b.nIE;
      localObject1 = com.tencent.mm.media.widget.b.a.a.b.btR();
      boolean bool = nHk;
      localObject2 = com.tencent.mm.media.widget.b.a.b.nIb;
      paramBuilder.b((String)localObject1, bool, com.tencent.mm.media.widget.b.a.b.btH());
    }
    AppMethodBeat.o(94104);
  }
  
  public static String btk()
  {
    AppMethodBeat.i(237548);
    String str = us(nHa);
    AppMethodBeat.o(237548);
    return str;
  }
  
  public static String btl()
  {
    AppMethodBeat.i(237551);
    String str = us(nHb);
    AppMethodBeat.o(237551);
    return str;
  }
  
  public static String btm()
  {
    return nHg;
  }
  
  public static boolean btn()
  {
    AppMethodBeat.i(94097);
    boolean bool = s.p(nHg, us(nHa));
    AppMethodBeat.o(94097);
    return bool;
  }
  
  public static int bto()
  {
    return nHh;
  }
  
  public static int btp()
  {
    return nHi;
  }
  
  public static Point btq()
  {
    return nHj;
  }
  
  public static void btr()
  {
    nHk = true;
    nHl = false;
    nHm = true;
    nHo = true;
    nHp = null;
    nHq = 40;
    nHr = 40;
    nHs = false;
    nHt = null;
  }
  
  public static Size[] bts()
  {
    AppMethodBeat.i(94098);
    Object localObject2 = nHg;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = us(nHa);
    }
    localObject2 = Fk;
    if (localObject2 == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        break label91;
      }
    }
    label91:
    for (localObject1 = null;; localObject1 = ((StreamConfigurationMap)localObject1).getOutputSizes(SurfaceTexture.class))
    {
      s.checkNotNull(localObject1);
      a((Size[])localObject1, nHd);
      s.checkNotNull(localObject1);
      AppMethodBeat.o(94098);
      return localObject1;
      localObject1 = ((CameraManager)localObject2).getCameraCharacteristics((String)localObject1);
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = (StreamConfigurationMap)((CameraCharacteristics)localObject1).get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
      break;
    }
  }
  
  public static Size[] btt()
  {
    AppMethodBeat.i(94099);
    Object localObject2 = nHg;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = us(nHa);
    }
    int i = nHh;
    localObject2 = Fk;
    if (localObject2 == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        break label95;
      }
    }
    label95:
    for (localObject1 = null;; localObject1 = ((StreamConfigurationMap)localObject1).getOutputSizes(i))
    {
      s.checkNotNull(localObject1);
      a((Size[])localObject1, nHf);
      s.checkNotNull(localObject1);
      AppMethodBeat.o(94099);
      return localObject1;
      localObject1 = ((CameraManager)localObject2).getCameraCharacteristics((String)localObject1);
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = (StreamConfigurationMap)((CameraCharacteristics)localObject1).get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
      break;
    }
  }
  
  public static boolean btu()
  {
    AppMethodBeat.i(94113);
    ArrayList localArrayList = nHw;
    if (localArrayList == null)
    {
      AppMethodBeat.o(94113);
      return false;
    }
    if (!((Collection)localArrayList).isEmpty())
    {
      AppMethodBeat.o(94113);
      return true;
    }
    AppMethodBeat.o(94113);
    return false;
  }
  
  public static void c(CaptureRequest.Builder paramBuilder)
  {
    AppMethodBeat.i(94105);
    s.u(paramBuilder, "builder");
    Object localObject1;
    Object localObject2;
    Object localObject3;
    boolean bool;
    if (!nHs)
    {
      localObject1 = nHg;
      s.checkNotNull(localObject1);
      localObject1 = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, nHu);
      localObject2 = com.tencent.mm.media.widget.b.a.a.b.nIE;
      localObject2 = com.tencent.mm.media.widget.b.a.a.b.btM();
      localObject3 = com.tencent.mm.media.widget.b.a.b.nIb;
      if (((com.tencent.mm.media.widget.b.a.a.b)localObject1).aG((String)localObject2, com.tencent.mm.media.widget.b.a.b.btG()))
      {
        localObject1 = nHg;
        s.checkNotNull(localObject1);
        paramBuilder = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, nHu);
        localObject1 = com.tencent.mm.media.widget.b.a.a.b.nIE;
        localObject1 = com.tencent.mm.media.widget.b.a.a.b.btM();
        bool = nHo;
        localObject2 = com.tencent.mm.media.widget.b.a.b.nIb;
        paramBuilder.b((String)localObject1, bool, com.tencent.mm.media.widget.b.a.b.btG());
        AppMethodBeat.o(94105);
      }
    }
    else
    {
      s.u(paramBuilder, "builder");
      localObject1 = nHg;
      s.checkNotNull(localObject1);
      localObject1 = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, nHu);
      localObject2 = com.tencent.mm.media.widget.b.a.a.b.nIE;
      localObject2 = com.tencent.mm.media.widget.b.a.a.b.btM();
      localObject3 = com.tencent.mm.media.widget.b.a.a.b.nIE;
      localObject3 = com.tencent.mm.media.widget.b.a.a.b.btN();
      bool = nHo;
      Object localObject4 = nHp;
      s.checkNotNull(localObject4);
      com.tencent.mm.media.widget.b.a.b localb = com.tencent.mm.media.widget.b.a.b.nIb;
      int i = com.tencent.mm.media.widget.b.a.b.btG();
      s.u(localObject2, "key");
      s.u(localObject3, "child");
      ((com.tencent.mm.media.widget.b.a.a.b)localObject1).a((String)localObject2, (String)localObject3, bool, localObject4, i);
      localObject1 = nHg;
      s.checkNotNull(localObject1);
      localObject1 = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, nHu);
      localObject2 = com.tencent.mm.media.widget.b.a.a.b.nIE;
      localObject2 = com.tencent.mm.media.widget.b.a.a.b.btM();
      localObject3 = com.tencent.mm.media.widget.b.a.a.b.nIE;
      localObject3 = com.tencent.mm.media.widget.b.a.a.b.btO();
      bool = nHo;
      i = nHq;
      localObject4 = com.tencent.mm.media.widget.b.a.b.nIb;
      ((com.tencent.mm.media.widget.b.a.a.b)localObject1).a((String)localObject2, (String)localObject3, bool, i, com.tencent.mm.media.widget.b.a.b.btG());
      localObject1 = nHg;
      s.checkNotNull(localObject1);
      paramBuilder = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, nHu);
      localObject1 = com.tencent.mm.media.widget.b.a.a.b.nIE;
      localObject1 = com.tencent.mm.media.widget.b.a.a.b.btM();
      localObject2 = com.tencent.mm.media.widget.b.a.a.b.nIE;
      localObject2 = com.tencent.mm.media.widget.b.a.a.b.btP();
      bool = nHo;
      i = nHr;
      localObject3 = com.tencent.mm.media.widget.b.a.b.nIb;
      paramBuilder.a((String)localObject1, (String)localObject2, bool, i, com.tencent.mm.media.widget.b.a.b.btG());
    }
    AppMethodBeat.o(94105);
  }
  
  public static void d(CaptureRequest.Builder paramBuilder)
  {
    AppMethodBeat.i(94106);
    s.u(paramBuilder, "builder");
    Object localObject1 = nHg;
    s.checkNotNull(localObject1);
    localObject1 = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, nHu);
    Object localObject2 = com.tencent.mm.media.widget.b.a.a.b.nIE;
    localObject2 = com.tencent.mm.media.widget.b.a.a.b.btQ();
    com.tencent.mm.media.widget.b.a.b localb = com.tencent.mm.media.widget.b.a.b.nIb;
    if (((com.tencent.mm.media.widget.b.a.a.b)localObject1).aG((String)localObject2, com.tencent.mm.media.widget.b.a.b.btH()))
    {
      localObject1 = nHg;
      s.checkNotNull(localObject1);
      paramBuilder = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, nHu);
      localObject1 = com.tencent.mm.media.widget.b.a.a.b.nIE;
      localObject1 = com.tencent.mm.media.widget.b.a.a.b.btQ();
      boolean bool = nHl;
      localObject2 = com.tencent.mm.media.widget.b.a.b.nIb;
      paramBuilder.b((String)localObject1, bool, com.tencent.mm.media.widget.b.a.b.btH());
    }
    AppMethodBeat.o(94106);
  }
  
  public static void e(Point paramPoint)
  {
    nHj = paramPoint;
  }
  
  public static void e(CaptureRequest.Builder paramBuilder)
  {
    AppMethodBeat.i(94107);
    s.u(paramBuilder, "builder");
    Object localObject1 = nHg;
    s.checkNotNull(localObject1);
    localObject1 = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, nHu);
    Object localObject2 = com.tencent.mm.media.widget.b.a.a.b.nIE;
    localObject2 = com.tencent.mm.media.widget.b.a.a.b.btT();
    com.tencent.mm.media.widget.b.a.b localb = com.tencent.mm.media.widget.b.a.b.nIb;
    if (((com.tencent.mm.media.widget.b.a.a.b)localObject1).aG((String)localObject2, com.tencent.mm.media.widget.b.a.b.btG()))
    {
      localObject1 = nHg;
      s.checkNotNull(localObject1);
      paramBuilder = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, nHu);
      localObject1 = com.tencent.mm.media.widget.b.a.a.b.nIE;
      localObject1 = com.tencent.mm.media.widget.b.a.a.b.btT();
      boolean bool = nHm;
      localObject2 = com.tencent.mm.media.widget.b.a.b.nIb;
      paramBuilder.b((String)localObject1, bool, com.tencent.mm.media.widget.b.a.b.btG());
    }
    AppMethodBeat.o(94107);
  }
  
  public static void f(CaptureRequest.Builder paramBuilder)
  {
    AppMethodBeat.i(94108);
    s.u(paramBuilder, "builder");
    Object localObject1 = nHg;
    s.checkNotNull(localObject1);
    localObject1 = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, nHu);
    Object localObject2 = com.tencent.mm.media.widget.b.a.a.b.nIE;
    localObject2 = com.tencent.mm.media.widget.b.a.a.b.btS();
    com.tencent.mm.media.widget.b.a.b localb = com.tencent.mm.media.widget.b.a.b.nIb;
    if (((com.tencent.mm.media.widget.b.a.a.b)localObject1).aG((String)localObject2, com.tencent.mm.media.widget.b.a.b.btI()))
    {
      localObject1 = nHg;
      s.checkNotNull(localObject1);
      paramBuilder = new com.tencent.mm.media.widget.b.a.a.b(paramBuilder, (String)localObject1, nHu);
      localObject1 = com.tencent.mm.media.widget.b.a.a.b.nIE;
      localObject1 = com.tencent.mm.media.widget.b.a.a.b.btS();
      boolean bool = nHn;
      localObject2 = com.tencent.mm.media.widget.b.a.b.nIb;
      paramBuilder.b((String)localObject1, bool, com.tencent.mm.media.widget.b.a.b.btI());
    }
    AppMethodBeat.o(94108);
  }
  
  public static void g(CaptureRequest.Builder paramBuilder)
  {
    AppMethodBeat.i(94109);
    s.u(paramBuilder, "builder");
    Object localObject = nHu;
    if (localObject != null)
    {
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.media.widget.b.a.a.a locala = (com.tencent.mm.media.widget.b.a.a.a)((Iterator)localObject).next();
        Log.i(TAG, s.X("close effect :  ", locala.nIC));
        com.tencent.mm.media.widget.b.a.b.a(paramBuilder, locala, false);
      }
    }
    AppMethodBeat.o(94109);
  }
  
  public static void gA(boolean paramBoolean)
  {
    nHl = paramBoolean;
  }
  
  public static void gB(boolean paramBoolean)
  {
    nHm = paramBoolean;
  }
  
  public static void gC(boolean paramBoolean)
  {
    nHn = paramBoolean;
  }
  
  public static void gD(boolean paramBoolean)
  {
    nHo = paramBoolean;
  }
  
  public static void gz(boolean paramBoolean)
  {
    nHk = paramBoolean;
  }
  
  public static void r(ArrayList<com.tencent.mm.media.widget.b.a.a.a> paramArrayList)
  {
    nHu = paramArrayList;
  }
  
  public static void s(ArrayList<com.tencent.mm.media.widget.b.a.b.a> paramArrayList)
  {
    nHv = paramArrayList;
  }
  
  public static void t(ArrayList<com.tencent.mm.media.widget.b.a.c.a> paramArrayList)
  {
    nHw = paramArrayList;
  }
  
  static String us(int paramInt)
  {
    AppMethodBeat.i(94100);
    Object localObject1 = Fk;
    int i;
    label30:
    String str;
    Object localObject2;
    label54:
    label77:
    int j;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 == null) {
        break label144;
      }
      int k = localObject1.length;
      i = 0;
      if (i >= k) {
        break label144;
      }
      str = localObject1[i];
      localObject2 = Fk;
      if (localObject2 != null) {
        break label111;
      }
      localObject2 = null;
      if (localObject2 != null)
      {
        localObject2 = (Integer)((CameraCharacteristics)localObject2).get(CameraCharacteristics.LENS_FACING);
        if (localObject2 != null) {
          break label123;
        }
      }
      j = 0;
      label79:
      if (j == 0) {
        break label137;
      }
    }
    label137:
    label144:
    for (localObject1 = str;; localObject1 = null)
    {
      if (localObject1 == null) {
        break label150;
      }
      AppMethodBeat.o(94100);
      return localObject1;
      localObject1 = ((CameraManager)localObject1).getCameraIdList();
      break;
      label111:
      localObject2 = ((CameraManager)localObject2).getCameraCharacteristics(str);
      break label54;
      label123:
      if (((Integer)localObject2).intValue() != paramInt) {
        break label77;
      }
      j = 1;
      break label79;
      i += 1;
      break label30;
    }
    label150:
    Log.e(TAG, "can not find the id: %s in camera manage", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(94100);
    return String.valueOf(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.c
 * JD-Core Version:    0.7.0.1
 */