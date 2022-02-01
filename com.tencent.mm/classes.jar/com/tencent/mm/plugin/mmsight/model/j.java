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
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.v.a.a;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.cl;
import com.tencent.mm.ui.base.w;

public final class j
{
  public static boolean EZU = true;
  public static boolean EZV = false;
  public static boolean EZW = false;
  public static o EZX;
  static double EZY;
  static int miK;
  
  public static void a(Camera.Parameters paramParameters, boolean paramBoolean)
  {
    AppMethodBeat.i(89426);
    Object localObject2;
    int i;
    if (EZV)
    {
      localObject1 = MMApplicationContext.getContext();
      localObject2 = MMApplicationContext.getResources();
      i = a.a.i_want_you_know;
      if (EZX == null) {}
      for (paramParameters = "";; paramParameters = Integer.valueOf(EZX.Faj))
      {
        w.makeText((Context)localObject1, ((Resources)localObject2).getString(i, new Object[] { paramParameters }), 1).show();
        AppMethodBeat.o(89426);
        return;
      }
    }
    Log.i("MicroMsg.MMSightRecorderConfig", "autoConfig, recorderOption: %s, isUseRecorderOption: %s", new Object[] { Integer.valueOf(af.juO.jto), Boolean.valueOf(EZW) });
    if (EZW)
    {
      AppMethodBeat.o(89426);
      return;
    }
    Object localObject1 = com.tencent.mm.plugin.mmsight.d.eSY();
    int k;
    int j;
    if ((CaptureMMProxy.getInstance() != null) && (!MMApplicationContext.isMMProcess()))
    {
      k = Util.getInt(CaptureMMProxy.getInstance().getDynamicConfig("SightMediaCodecMinApiLevel"), 19);
      i = Util.getInt(CaptureMMProxy.getInstance().getDynamicConfig("Sight1080pRecordMinApiLevel"), 19);
      j = Util.getInt(CaptureMMProxy.getInstance().getDynamicConfig("Sight720pRecordMinApiLevel"), 19);
      Log.i("MicroMsg.MMSightRecorderConfig", "apiLevel: %s record1080pApiLevel: %s, record720pApiLevel: %s", new Object[] { Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j) });
      if ((af.juO.jtn != -1) && ((af.juO.jtn & 0x1) == 0)) {
        break label717;
      }
      if ((af.juO.jtn == -1) || ((af.juO.jtn & 0x1) == 0)) {
        break label470;
      }
      EZX.eTx().Fak = true;
      i = 1;
    }
    for (;;)
    {
      boolean bool;
      if (af.juO.jti != -1)
      {
        localObject2 = EZX;
        if (af.juO.jti == 1)
        {
          bool = true;
          label295:
          ((o)localObject2).lhV = bool;
          label302:
          if ((af.juO.jtn == -1) || ((af.juO.jtn & 0x2) != 0))
          {
            if ((af.juO.jtn == -1) || ((af.juO.jtn & 0x2) == 0)) {
              break label604;
            }
            paramParameters = EZX.eTv();
            paramParameters.Fak = false;
            paramParameters.eTw();
          }
        }
      }
      label715:
      for (;;)
      {
        EZX.Faj = -1;
        Log.i("MicroMsg.MMSightRecorderConfig", "autoConfig parameter byserver %s", new Object[] { EZX.toString() });
        AppMethodBeat.o(89426);
        return;
        k = Util.getInt(((a)com.tencent.mm.kernel.h.ae(a.class)).axc().getValue("SightMediaCodecMinApiLevel"), 19);
        i = Util.getInt(((a)com.tencent.mm.kernel.h.ae(a.class)).axc().getValue("Sight1080pRecordMinApiLevel"), 19);
        j = Util.getInt(((a)com.tencent.mm.kernel.h.ae(a.class)).axc().getValue("Sight720pRecordMinApiLevel"), 19);
        break;
        label470:
        if ((!com.tencent.mm.compatible.util.d.qV(i)) || (miK < 512) || (EZY < 1725.0D) || (Math.min(((Point)localObject1).x, ((Point)localObject1).y) < 1080)) {
          break label717;
        }
        localObject2 = EZX;
        ((o)localObject2).Fan = h.b(paramParameters, com.tencent.mm.plugin.mmsight.d.eSY(), ((o)localObject2).lgX.width * 2, paramBoolean);
        if ((((o)localObject2).Fan != null) && (((o)localObject2).Fan.EZN != null)) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label717;
          }
          EZX.eTx().Fak = true;
          i = 1;
          break;
        }
        bool = false;
        break label295;
        EZX.lhV = false;
        break label302;
        label604:
        if ((i == 0) && (com.tencent.mm.compatible.util.d.qV(j)) && (miK >= 512) && (EZY >= 1725.0D) && (Math.min(((Point)localObject1).x, ((Point)localObject1).y) >= 720))
        {
          localObject1 = EZX;
          ((o)localObject1).Fan = h.b(paramParameters, com.tencent.mm.plugin.mmsight.d.eSY(), 720, paramBoolean);
          if ((((o)localObject1).Fan != null) && (((o)localObject1).Fan.EZN != null)) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label715;
            }
            EZX.eTv().Fak = true;
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
    if (paramc.EZN == null)
    {
      Log.i("MicroMsg.MMSightRecorderConfig", "checkMore start %s", new Object[] { paramc.toString() });
      paramc.EZN = paramc.EZQ;
      paramc.EZO = paramc.EZR;
      paramc.EZP = paramc.EZS;
      if (Math.min(paramc.EZO.y, paramc.EZO.x) >= EZX.lgX.width + 16)
      {
        EZX.eTw();
        EZX.Fak = false;
        EZX.lhV = false;
        Log.i("MicroMsg.MMSightRecorderConfig", "checkMore out %s", new Object[] { paramc.toString() });
      }
    }
    AppMethodBeat.o(89429);
  }
  
  public static void d(VideoTransPara paramVideoTransPara)
  {
    boolean bool2 = true;
    AppMethodBeat.i(89427);
    Object localObject1 = j.a.Faa;
    EZV = false;
    EZW = false;
    miK = ((ActivityManager)MMApplicationContext.getContext().getSystemService("activity")).getLargeMemoryClass();
    EZY = com.tencent.mm.plugin.mmsight.d.hw(MMApplicationContext.getContext());
    Object localObject2 = cl.hAM();
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
      af.KN(CaptureMMProxy.getInstance().getDeviceInfoConfig());
      Log.i("MicroMsg.MMSightRecorderConfig", "init large memory class: %sMB, totalMemory: %sGB  fingerprint: %s mmSightRecorderInfo: %s", new Object[] { Integer.valueOf(miK), Double.valueOf(EZY), localObject2, af.juO });
      if ((CaptureMMProxy.getInstance() == null) || (MMApplicationContext.isMMProcess())) {
        break label360;
      }
      n = CaptureMMProxy.getInstance().getInt(ar.a.Vnc, -1);
      m = CaptureMMProxy.getInstance().getInt(ar.a.Vnf, 1);
      k = CaptureMMProxy.getInstance().getInt(ar.a.VxP, 1);
      j = CaptureMMProxy.getInstance().getInt(ar.a.VxQ, 2);
      label220:
      localObject2 = o.a(n, paramVideoTransPara);
      EZX = (o)localObject2;
      if (localObject2 == null) {
        break label456;
      }
      paramVideoTransPara = EZX;
      if (m != 1) {
        break label437;
      }
      bool1 = true;
      label251:
      paramVideoTransPara.Fal = bool1;
      EZV = true;
      localObject1 = MMApplicationContext.getContext();
      localObject2 = MMApplicationContext.getResources();
      i = a.a.i_want_you_know;
      if (EZX != null) {
        break label443;
      }
    }
    label437:
    label443:
    for (paramVideoTransPara = "";; paramVideoTransPara = Integer.valueOf(EZX.Faj))
    {
      w.makeText((Context)localObject1, ((Resources)localObject2).getString(i, new Object[] { paramVideoTransPara }), 1).show();
      AppMethodBeat.o(89427);
      return;
      i = Util.getInt(((a)com.tencent.mm.kernel.h.ae(a.class)).axc().getValue("SightMediaCodecMinApiLevel"), 19);
      break;
      label341:
      com.tencent.mm.kernel.h.aHH();
      af.KN(com.tencent.mm.kernel.h.aHG().aHq().hAK());
      break label121;
      label360:
      com.tencent.mm.kernel.h.aHH();
      n = com.tencent.mm.kernel.h.aHG().aHp().getInt(ar.a.Vnc, -1);
      com.tencent.mm.kernel.h.aHH();
      m = com.tencent.mm.kernel.h.aHG().aHp().getInt(ar.a.Vnf, 1);
      com.tencent.mm.kernel.h.aHH();
      k = com.tencent.mm.kernel.h.aHG().aHp().getInt(ar.a.VxP, 1);
      com.tencent.mm.kernel.h.aHH();
      j = com.tencent.mm.kernel.h.aHG().aHp().getInt(ar.a.VxQ, 2);
      break label220;
      bool1 = false;
      break label251;
    }
    label456:
    switch (j.1.EZZ[localObject1.ordinal()])
    {
    default: 
      n = af.juO.jto;
      Log.i("MicroMsg.MMSightRecorderConfig", "recorderOption: %s", new Object[] { Integer.valueOf(n) });
      if (n != -1) {
        EZX = o.a(n, paramVideoTransPara);
      }
      if (EZX == null) {
        break label579;
      }
      if (m != 1) {
        break;
      }
    }
    for (EZX.Fal = true;; EZX.Fal = false)
    {
      EZW = true;
      AppMethodBeat.o(89427);
      return;
      localObject1 = af.juP;
      n = 12;
      break;
    }
    label579:
    EZX = o.a(1, paramVideoTransPara);
    if (m == 1)
    {
      EZX.Fal = true;
      EZX.Fai = k;
      paramVideoTransPara = EZX;
      if (j != 2) {
        break label726;
      }
      bool1 = true;
      label619:
      paramVideoTransPara.uTJ = bool1;
      if (af.juO.jth == -1) {
        break label732;
      }
      EZX.jth = af.juO.jth;
      label647:
      if (af.juO.jtk != -1)
      {
        if (af.juO.jtk != 1) {
          break label787;
        }
        bool1 = true;
        label670:
        EZU = bool1;
      }
      if (af.juO.jti == -1) {
        break label799;
      }
      paramVideoTransPara = EZX;
      if (af.juO.jti != 1) {
        break label793;
      }
    }
    label785:
    label787:
    label793:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramVideoTransPara.lhV = bool1;
      AppMethodBeat.o(89427);
      return;
      EZX.Fal = false;
      break;
      label726:
      bool1 = false;
      break label619;
      label732:
      if (com.tencent.mm.compatible.util.d.qV(i)) {}
      for (EZX.jth = 2;; EZX.jth = 1)
      {
        if (!((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.vKV, false)) {
          break label785;
        }
        EZX.jth = 1;
        break;
      }
      break label647;
      bool1 = false;
      break label670;
    }
    label799:
    EZX.lhV = false;
    AppMethodBeat.o(89427);
  }
  
  public static boolean eTo()
  {
    AppMethodBeat.i(89428);
    if ((CaptureMMProxy.getInstance() != null) && (!MMApplicationContext.isMMProcess()))
    {
      if (CaptureMMProxy.getInstance().getInt(ar.a.Vnc, -1) != -1)
      {
        AppMethodBeat.o(89428);
        return true;
      }
      AppMethodBeat.o(89428);
      return false;
    }
    com.tencent.mm.kernel.h.aHH();
    if (com.tencent.mm.kernel.h.aHG().aHp().getInt(ar.a.Vnc, -1) != -1)
    {
      AppMethodBeat.o(89428);
      return true;
    }
    AppMethodBeat.o(89428);
    return false;
  }
  
  public static void eTp()
  {
    AppMethodBeat.i(89430);
    Log.i("MicroMsg.MMSightRecorderConfig", "initSimple");
    o localo = new o();
    EZX = localo;
    localo.lhV = false;
    EZX.Fak = false;
    if (com.tencent.mm.compatible.util.d.qV(19))
    {
      EZX.jth = 2;
      AppMethodBeat.o(89430);
      return;
    }
    EZX.jth = 1;
    AppMethodBeat.o(89430);
  }
  
  public static boolean i(Point paramPoint)
  {
    AppMethodBeat.i(89425);
    if (EZV)
    {
      Context localContext = MMApplicationContext.getContext();
      Resources localResources = MMApplicationContext.getResources();
      int i = a.a.i_want_you_know;
      if (EZX == null) {}
      for (paramPoint = "";; paramPoint = Integer.valueOf(EZX.Faj))
      {
        w.makeText(localContext, localResources.getString(i, new Object[] { paramPoint }), 1).show();
        AppMethodBeat.o(89425);
        return false;
      }
    }
    Log.i("MicroMsg.MMSightRecorderConfig", "checkMediaCodecHappy, deviceInfo recorderType: %s, recorderOption: %s, isUseRecorderOption: %s", new Object[] { Integer.valueOf(af.juO.jth), Integer.valueOf(af.juO.jto), Boolean.valueOf(EZW) });
    if (EZW)
    {
      AppMethodBeat.o(89425);
      return false;
    }
    if (af.juO.jth != -1)
    {
      AppMethodBeat.o(89425);
      return true;
    }
    if ((EZX != null) && (1 == EZX.jth))
    {
      AppMethodBeat.o(89425);
      return true;
    }
    if (paramPoint == null)
    {
      AppMethodBeat.o(89425);
      return false;
    }
    if ((com.tencent.mm.plugin.mmsight.d.WW(paramPoint.x)) && (com.tencent.mm.plugin.mmsight.d.WW(paramPoint.y)))
    {
      AppMethodBeat.o(89425);
      return true;
    }
    if (EZX != null)
    {
      Log.i("MicroMsg.MMSightRecorderConfig", "checkMediaCodecHappy not happy %s", new Object[] { paramPoint.toString() });
      EZX.jth = 1;
    }
    AppMethodBeat.o(89425);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.j
 * JD-Core Version:    0.7.0.1
 */