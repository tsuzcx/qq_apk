package com.tencent.mm.plugin.mmsight.model;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.hardware.Camera.Parameters;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.y;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.v.a.a;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.co;
import com.tencent.mm.ui.base.aa;

public final class j
{
  public static boolean KVG = true;
  public static boolean KVH = false;
  public static boolean KVI = false;
  public static o KVJ;
  static double KVK;
  static int pch;
  
  public static void a(Camera.Parameters paramParameters, boolean paramBoolean)
  {
    AppMethodBeat.i(89426);
    Object localObject2;
    int i;
    if (KVH)
    {
      localObject1 = MMApplicationContext.getContext();
      localObject2 = MMApplicationContext.getResources();
      i = a.a.i_want_you_know;
      if (KVJ == null) {}
      for (paramParameters = "";; paramParameters = Integer.valueOf(KVJ.Ddk))
      {
        aa.makeText((Context)localObject1, ((Resources)localObject2).getString(i, new Object[] { paramParameters }), 1).show();
        AppMethodBeat.o(89426);
        return;
      }
    }
    Log.i("MicroMsg.MMSightRecorderConfig", "autoConfig, recorderOption: %s, isUseRecorderOption: %s", new Object[] { Integer.valueOf(af.lYf.lWF), Boolean.valueOf(KVI) });
    if (KVI)
    {
      AppMethodBeat.o(89426);
      return;
    }
    Object localObject1 = com.tencent.mm.plugin.mmsight.d.gbR();
    int k;
    int j;
    if ((CaptureMMProxy.getInstance() != null) && (!MMApplicationContext.isMMProcess()))
    {
      k = Util.getInt(CaptureMMProxy.getInstance().getDynamicConfig("SightMediaCodecMinApiLevel"), 19);
      i = Util.getInt(CaptureMMProxy.getInstance().getDynamicConfig("Sight1080pRecordMinApiLevel"), 19);
      j = Util.getInt(CaptureMMProxy.getInstance().getDynamicConfig("Sight720pRecordMinApiLevel"), 19);
      Log.i("MicroMsg.MMSightRecorderConfig", "apiLevel: %s record1080pApiLevel: %s, record720pApiLevel: %s", new Object[] { Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j) });
      if ((af.lYf.lWE != -1) && ((af.lYf.lWE & 0x1) == 0)) {
        break label717;
      }
      if ((af.lYf.lWE == -1) || ((af.lYf.lWE & 0x1) == 0)) {
        break label470;
      }
      KVJ.gcq().KVU = true;
      i = 1;
    }
    for (;;)
    {
      boolean bool;
      if (af.lYf.lWz != -1)
      {
        localObject2 = KVJ;
        if (af.lYf.lWz == 1)
        {
          bool = true;
          label295:
          ((o)localObject2).nME = bool;
          label302:
          if ((af.lYf.lWE == -1) || ((af.lYf.lWE & 0x2) != 0))
          {
            if ((af.lYf.lWE == -1) || ((af.lYf.lWE & 0x2) == 0)) {
              break label604;
            }
            paramParameters = KVJ.gco();
            paramParameters.KVU = false;
            paramParameters.gcp();
          }
        }
      }
      label715:
      for (;;)
      {
        KVJ.Ddk = -1;
        Log.i("MicroMsg.MMSightRecorderConfig", "autoConfig parameter byserver %s", new Object[] { KVJ.toString() });
        AppMethodBeat.o(89426);
        return;
        k = Util.getInt(((a)com.tencent.mm.kernel.h.ax(a.class)).aRC().getValue("SightMediaCodecMinApiLevel"), 19);
        i = Util.getInt(((a)com.tencent.mm.kernel.h.ax(a.class)).aRC().getValue("Sight1080pRecordMinApiLevel"), 19);
        j = Util.getInt(((a)com.tencent.mm.kernel.h.ax(a.class)).aRC().getValue("Sight720pRecordMinApiLevel"), 19);
        break;
        label470:
        if ((!com.tencent.mm.compatible.util.d.rb(i)) || (pch < 512) || (KVK < 1725.0D) || (Math.min(((Point)localObject1).x, ((Point)localObject1).y) < 1080)) {
          break label717;
        }
        localObject2 = KVJ;
        ((o)localObject2).KVX = h.b(paramParameters, com.tencent.mm.plugin.mmsight.d.gbR(), ((o)localObject2).nLH.width * 2, paramBoolean);
        if ((((o)localObject2).KVX != null) && (((o)localObject2).KVX.KVz != null)) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label717;
          }
          KVJ.gcq().KVU = true;
          i = 1;
          break;
        }
        bool = false;
        break label295;
        KVJ.nME = false;
        break label302;
        label604:
        if ((i == 0) && (com.tencent.mm.compatible.util.d.rb(j)) && (pch >= 512) && (KVK >= 1725.0D) && (Math.min(((Point)localObject1).x, ((Point)localObject1).y) >= 720))
        {
          localObject1 = KVJ;
          ((o)localObject1).KVX = h.b(paramParameters, com.tencent.mm.plugin.mmsight.d.gbR(), 720, paramBoolean);
          if ((((o)localObject1).KVX != null) && (((o)localObject1).KVX.KVz != null)) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label715;
            }
            KVJ.gco().KVU = true;
            break;
          }
        }
      }
      label717:
      i = 0;
    }
  }
  
  public static void a(h.c paramc)
  {
    AppMethodBeat.i(89429);
    if (paramc.KVz == null)
    {
      Log.i("MicroMsg.MMSightRecorderConfig", "checkMore start %s", new Object[] { paramc.toString() });
      paramc.KVz = paramc.KVC;
      paramc.KVA = paramc.KVD;
      paramc.KVB = paramc.KVE;
      if (Math.min(paramc.KVA.y, paramc.KVA.x) >= KVJ.nLH.width + 16)
      {
        KVJ.gcp();
        KVJ.KVU = false;
        KVJ.nME = false;
        Log.i("MicroMsg.MMSightRecorderConfig", "checkMore out %s", new Object[] { paramc.toString() });
      }
    }
    AppMethodBeat.o(89429);
  }
  
  public static void d(VideoTransPara paramVideoTransPara)
  {
    boolean bool2 = true;
    AppMethodBeat.i(89427);
    Object localObject1 = a.KVM;
    KVH = false;
    KVI = false;
    pch = ((ActivityManager)MMApplicationContext.getContext().getSystemService("activity")).getLargeMemoryClass();
    KVK = com.tencent.mm.plugin.mmsight.d.iR(MMApplicationContext.getContext());
    Object localObject2 = co.jcP();
    int i;
    label121:
    int n;
    int m;
    int k;
    int j;
    if ((CaptureMMProxy.getInstance() != null) && (!MMApplicationContext.isMMProcess()))
    {
      i = Util.getInt(CaptureMMProxy.getInstance().getDynamicConfig("SightMediaCodecMinApiLevel"), 19);
      Log.i("MicroMsg.MMSightRecorderConfig", "MXM_DynaCfg_AV_Item_Key_SightMediaCodecMinApiLevel: %s", new Object[] { Integer.valueOf(i) });
      if ((CaptureMMProxy.getInstance() == null) || (MMApplicationContext.isMMProcess())) {
        break label341;
      }
      af.Ds(CaptureMMProxy.getInstance().getDeviceInfoConfig());
      Log.i("MicroMsg.MMSightRecorderConfig", "init large memory class: %sMB, totalMemory: %sGB  fingerprint: %s mmSightRecorderInfo: %s", new Object[] { Integer.valueOf(pch), Double.valueOf(KVK), localObject2, af.lYf });
      if ((CaptureMMProxy.getInstance() == null) || (MMApplicationContext.isMMProcess())) {
        break label360;
      }
      n = CaptureMMProxy.getInstance().getInt(at.a.acOx, -1);
      m = CaptureMMProxy.getInstance().getInt(at.a.acOA, 1);
      k = CaptureMMProxy.getInstance().getInt(at.a.acZC, 1);
      j = CaptureMMProxy.getInstance().getInt(at.a.acZD, 2);
      label220:
      localObject2 = o.a(n, paramVideoTransPara);
      KVJ = (o)localObject2;
      if (localObject2 == null) {
        break label456;
      }
      paramVideoTransPara = KVJ;
      if (m != 1) {
        break label437;
      }
      bool1 = true;
      label251:
      paramVideoTransPara.KVV = bool1;
      KVH = true;
      localObject1 = MMApplicationContext.getContext();
      localObject2 = MMApplicationContext.getResources();
      i = a.a.i_want_you_know;
      if (KVJ != null) {
        break label443;
      }
    }
    label437:
    label443:
    for (paramVideoTransPara = "";; paramVideoTransPara = Integer.valueOf(KVJ.Ddk))
    {
      aa.makeText((Context)localObject1, ((Resources)localObject2).getString(i, new Object[] { paramVideoTransPara }), 1).show();
      AppMethodBeat.o(89427);
      return;
      i = Util.getInt(((a)com.tencent.mm.kernel.h.ax(a.class)).aRC().getValue("SightMediaCodecMinApiLevel"), 19);
      break;
      label341:
      com.tencent.mm.kernel.h.baF();
      af.Ds(com.tencent.mm.kernel.h.baE().bao().jcN());
      break label121;
      label360:
      com.tencent.mm.kernel.h.baF();
      n = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.acOx, -1);
      com.tencent.mm.kernel.h.baF();
      m = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.acOA, 1);
      com.tencent.mm.kernel.h.baF();
      k = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.acZC, 1);
      com.tencent.mm.kernel.h.baF();
      j = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.acZD, 2);
      break label220;
      bool1 = false;
      break label251;
    }
    label456:
    switch (1.KVL[localObject1.ordinal()])
    {
    default: 
      n = af.lYf.lWF;
      Log.i("MicroMsg.MMSightRecorderConfig", "recorderOption: %s", new Object[] { Integer.valueOf(n) });
      if (n != -1) {
        KVJ = o.a(n, paramVideoTransPara);
      }
      if (KVJ == null) {
        break label579;
      }
      if (m != 1) {
        break;
      }
    }
    for (KVJ.KVV = true;; KVJ.KVV = false)
    {
      KVI = true;
      AppMethodBeat.o(89427);
      return;
      localObject1 = af.lYg;
      n = 12;
      break;
    }
    label579:
    KVJ = o.a(1, paramVideoTransPara);
    if (m == 1)
    {
      KVJ.KVV = true;
      KVJ.KVT = k;
      paramVideoTransPara = KVJ;
      if (j != 2) {
        break label726;
      }
      bool1 = true;
      label619:
      paramVideoTransPara.ygy = bool1;
      if (af.lYf.lWy == -1) {
        break label732;
      }
      KVJ.lWy = af.lYf.lWy;
      label647:
      if (af.lYf.lWB != -1)
      {
        if (af.lYf.lWB != 1) {
          break label787;
        }
        bool1 = true;
        label670:
        KVG = bool1;
      }
      if (af.lYf.lWz == -1) {
        break label799;
      }
      paramVideoTransPara = KVJ;
      if (af.lYf.lWz != 1) {
        break label793;
      }
    }
    label785:
    label787:
    label793:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramVideoTransPara.nME = bool1;
      AppMethodBeat.o(89427);
      return;
      KVJ.KVV = false;
      break;
      label726:
      bool1 = false;
      break label619;
      label732:
      if (com.tencent.mm.compatible.util.d.rb(i)) {}
      for (KVJ.lWy = 2;; KVJ.lWy = 1)
      {
        if (!((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.zbv, false)) {
          break label785;
        }
        KVJ.lWy = 1;
        break;
      }
      break label647;
      bool1 = false;
      break label670;
    }
    label799:
    KVJ.nME = false;
    AppMethodBeat.o(89427);
  }
  
  public static boolean gch()
  {
    AppMethodBeat.i(89428);
    if ((CaptureMMProxy.getInstance() != null) && (!MMApplicationContext.isMMProcess()))
    {
      if (CaptureMMProxy.getInstance().getInt(at.a.acOx, -1) != -1)
      {
        AppMethodBeat.o(89428);
        return true;
      }
      AppMethodBeat.o(89428);
      return false;
    }
    com.tencent.mm.kernel.h.baF();
    if (com.tencent.mm.kernel.h.baE().ban().getInt(at.a.acOx, -1) != -1)
    {
      AppMethodBeat.o(89428);
      return true;
    }
    AppMethodBeat.o(89428);
    return false;
  }
  
  public static void gci()
  {
    AppMethodBeat.i(89430);
    Log.i("MicroMsg.MMSightRecorderConfig", "initSimple");
    o localo = new o();
    KVJ = localo;
    localo.nME = false;
    KVJ.KVU = false;
    if (com.tencent.mm.compatible.util.d.rb(19))
    {
      KVJ.lWy = 2;
      AppMethodBeat.o(89430);
      return;
    }
    KVJ.lWy = 1;
    AppMethodBeat.o(89430);
  }
  
  public static boolean k(Point paramPoint)
  {
    AppMethodBeat.i(89425);
    if (KVH)
    {
      Context localContext = MMApplicationContext.getContext();
      Resources localResources = MMApplicationContext.getResources();
      int i = a.a.i_want_you_know;
      if (KVJ == null) {}
      for (paramPoint = "";; paramPoint = Integer.valueOf(KVJ.Ddk))
      {
        aa.makeText(localContext, localResources.getString(i, new Object[] { paramPoint }), 1).show();
        AppMethodBeat.o(89425);
        return false;
      }
    }
    Log.i("MicroMsg.MMSightRecorderConfig", "checkMediaCodecHappy, deviceInfo recorderType: %s, recorderOption: %s, isUseRecorderOption: %s", new Object[] { Integer.valueOf(af.lYf.lWy), Integer.valueOf(af.lYf.lWF), Boolean.valueOf(KVI) });
    if (KVI)
    {
      AppMethodBeat.o(89425);
      return false;
    }
    if (af.lYf.lWy != -1)
    {
      AppMethodBeat.o(89425);
      return true;
    }
    if ((KVJ != null) && (1 == KVJ.lWy))
    {
      AppMethodBeat.o(89425);
      return true;
    }
    if (paramPoint == null)
    {
      AppMethodBeat.o(89425);
      return false;
    }
    if ((com.tencent.mm.plugin.mmsight.d.aaY(paramPoint.x)) && (com.tencent.mm.plugin.mmsight.d.aaY(paramPoint.y)))
    {
      AppMethodBeat.o(89425);
      return true;
    }
    if (KVJ != null)
    {
      Log.i("MicroMsg.MMSightRecorderConfig", "checkMediaCodecHappy not happy %s", new Object[] { paramPoint.toString() });
      KVJ.lWy = 1;
    }
    AppMethodBeat.o(89425);
    return false;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(89424);
      KVM = new a("MMSightCameraConfig", 0);
      KVN = new a("MMStoryCameraConfig", 1);
      KVO = new a[] { KVM, KVN };
      AppMethodBeat.o(89424);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.j
 * JD-Core Version:    0.7.0.1
 */