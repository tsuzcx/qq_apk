package com.tencent.mm.plugin.mmsight.model;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.hardware.Camera.Parameters;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.compatible.e.w;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.bs;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.t;

public final class j
{
  static int fYn;
  public static boolean oHD = true;
  public static boolean oHE = false;
  public static boolean oHF = false;
  public static o oHG;
  static double oHH;
  
  public static void a(Camera.Parameters paramParameters, boolean paramBoolean)
  {
    AppMethodBeat.i(76527);
    Object localObject2;
    if (oHE)
    {
      localObject1 = ah.getContext();
      localObject2 = ah.getResources();
      if (oHG == null) {}
      for (paramParameters = "";; paramParameters = Integer.valueOf(oHG.oHR))
      {
        t.makeText((Context)localObject1, ((Resources)localObject2).getString(2131300719, new Object[] { paramParameters }), 1).show();
        AppMethodBeat.o(76527);
        return;
      }
    }
    ab.i("MicroMsg.MMSightRecorderConfig", "autoConfig, recorderOption: %s, isUseRecorderOption: %s", new Object[] { Integer.valueOf(ac.erB.eqR), Boolean.valueOf(oHF) });
    if (oHF)
    {
      AppMethodBeat.o(76527);
      return;
    }
    Object localObject1 = com.tencent.mm.plugin.mmsight.d.bQE();
    int k;
    int i;
    int j;
    if ((CaptureMMProxy.getInstance() != null) && (!ah.brt()))
    {
      k = bo.getInt(CaptureMMProxy.getInstance().getDynamicConfig("SightMediaCodecMinApiLevel"), 19);
      i = bo.getInt(CaptureMMProxy.getInstance().getDynamicConfig("Sight1080pRecordMinApiLevel"), 19);
      j = bo.getInt(CaptureMMProxy.getInstance().getDynamicConfig("Sight720pRecordMinApiLevel"), 19);
      ab.i("MicroMsg.MMSightRecorderConfig", "apiLevel: %s record1080pApiLevel: %s, record720pApiLevel: %s", new Object[] { Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j) });
      if ((ac.erB.eqQ != -1) && ((ac.erB.eqQ & 0x1) == 0)) {
        break label714;
      }
      if ((ac.erB.eqQ == -1) || ((ac.erB.eqQ & 0x1) == 0)) {
        break label467;
      }
      oHG.bRe().oHS = true;
      i = 1;
    }
    for (;;)
    {
      boolean bool;
      if (ac.erB.eqL != -1)
      {
        localObject2 = oHG;
        if (ac.erB.eqL == 1)
        {
          bool = true;
          label292:
          ((o)localObject2).fdl = bool;
          label299:
          if ((ac.erB.eqQ == -1) || ((ac.erB.eqQ & 0x2) != 0))
          {
            if ((ac.erB.eqQ == -1) || ((ac.erB.eqQ & 0x2) == 0)) {
              break label601;
            }
            paramParameters = oHG.bRc();
            paramParameters.oHS = false;
            paramParameters.bRd();
          }
        }
      }
      label712:
      for (;;)
      {
        oHG.oHR = -1;
        ab.i("MicroMsg.MMSightRecorderConfig", "autoConfig parameter byserver %s", new Object[] { oHG.toString() });
        AppMethodBeat.o(76527);
        return;
        k = bo.getInt(((a)com.tencent.mm.kernel.g.E(a.class)).Nq().getValue("SightMediaCodecMinApiLevel"), 19);
        i = bo.getInt(((a)com.tencent.mm.kernel.g.E(a.class)).Nq().getValue("Sight1080pRecordMinApiLevel"), 19);
        j = bo.getInt(((a)com.tencent.mm.kernel.g.E(a.class)).Nq().getValue("Sight720pRecordMinApiLevel"), 19);
        break;
        label467:
        if ((!com.tencent.mm.compatible.util.d.fv(i)) || (fYn < 512) || (oHH < 1725.0D) || (Math.min(((Point)localObject1).x, ((Point)localObject1).y) < 1080)) {
          break label714;
        }
        localObject2 = oHG;
        ((o)localObject2).oHV = g.a(paramParameters, com.tencent.mm.plugin.mmsight.d.bQE(), ((o)localObject2).fcu.width * 2, paramBoolean);
        if ((((o)localObject2).oHV != null) && (((o)localObject2).oHV.oHu != null)) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label714;
          }
          oHG.bRe().oHS = true;
          i = 1;
          break;
        }
        bool = false;
        break label292;
        oHG.fdl = false;
        break label299;
        label601:
        if ((i == 0) && (com.tencent.mm.compatible.util.d.fv(j)) && (fYn >= 512) && (oHH >= 1725.0D) && (Math.min(((Point)localObject1).x, ((Point)localObject1).y) >= 720))
        {
          localObject1 = oHG;
          ((o)localObject1).oHV = g.a(paramParameters, com.tencent.mm.plugin.mmsight.d.bQE(), 720, paramBoolean);
          if ((((o)localObject1).oHV != null) && (((o)localObject1).oHV.oHu != null)) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label712;
            }
            oHG.bRc().oHS = true;
            break;
          }
        }
      }
      label714:
      i = 0;
    }
  }
  
  public static void a(g.b paramb)
  {
    AppMethodBeat.i(76529);
    if (paramb.oHu == null)
    {
      ab.i("MicroMsg.MMSightRecorderConfig", "checkMore start %s", new Object[] { paramb.toString() });
      paramb.oHu = paramb.oHx;
      paramb.oHv = paramb.oHy;
      paramb.oHw = paramb.oHz;
      if (Math.min(paramb.oHv.y, paramb.oHv.x) >= oHG.fcu.width + 16)
      {
        oHG.bRd();
        oHG.oHS = false;
        oHG.fdl = false;
        ab.i("MicroMsg.MMSightRecorderConfig", "checkMore out %s", new Object[] { paramb.toString() });
      }
    }
    AppMethodBeat.o(76529);
  }
  
  public static boolean bQV()
  {
    AppMethodBeat.i(140125);
    if ((CaptureMMProxy.getInstance() != null) && (!ah.brt()))
    {
      if (CaptureMMProxy.getInstance().getInt(ac.a.yDV, -1) != -1)
      {
        AppMethodBeat.o(140125);
        return true;
      }
      AppMethodBeat.o(140125);
      return false;
    }
    com.tencent.mm.kernel.g.RM();
    if (com.tencent.mm.kernel.g.RL().Ru().getInt(ac.a.yDV, -1) != -1)
    {
      AppMethodBeat.o(140125);
      return true;
    }
    AppMethodBeat.o(140125);
    return false;
  }
  
  public static void bQW()
  {
    AppMethodBeat.i(76530);
    ab.i("MicroMsg.MMSightRecorderConfig", "initSimple");
    o localo = new o();
    oHG = localo;
    localo.fdl = false;
    oHG.oHS = false;
    if (com.tencent.mm.compatible.util.d.fv(19))
    {
      oHG.eqK = 2;
      AppMethodBeat.o(76530);
      return;
    }
    oHG.eqK = 1;
    AppMethodBeat.o(76530);
  }
  
  public static void d(VideoTransPara paramVideoTransPara)
  {
    boolean bool2 = true;
    AppMethodBeat.i(76528);
    Object localObject1 = j.a.oHJ;
    oHE = false;
    oHF = false;
    fYn = ((ActivityManager)ah.getContext().getSystemService("activity")).getLargeMemoryClass();
    oHH = com.tencent.mm.plugin.mmsight.d.ey(ah.getContext());
    Object localObject2 = bs.dyO();
    int i;
    label121:
    int k;
    int j;
    if ((CaptureMMProxy.getInstance() != null) && (!ah.brt()))
    {
      i = bo.getInt(CaptureMMProxy.getInstance().getDynamicConfig("SightMediaCodecMinApiLevel"), 19);
      ab.i("MicroMsg.MMSightRecorderConfig", "MXM_DynaCfg_AV_Item_Key_SightMediaCodecMinApiLevel: %s", new Object[] { Integer.valueOf(i) });
      if ((CaptureMMProxy.getInstance() == null) || (ah.brt())) {
        break label312;
      }
      ac.ll(CaptureMMProxy.getInstance().getDeviceInfoConfig());
      ab.i("MicroMsg.MMSightRecorderConfig", "init large memory class: %sMB, totalMemory: %sGB  fingerprint: %s mmSightRecorderInfo: %s", new Object[] { Integer.valueOf(fYn), Double.valueOf(oHH), localObject2, ac.erB });
      if ((CaptureMMProxy.getInstance() == null) || (ah.brt())) {
        break label331;
      }
      k = CaptureMMProxy.getInstance().getInt(ac.a.yDV, -1);
      j = CaptureMMProxy.getInstance().getInt(ac.a.yDY, 1);
      label196:
      localObject2 = o.a(k, paramVideoTransPara);
      oHG = (o)localObject2;
      if (localObject2 == null) {
        break label389;
      }
      paramVideoTransPara = oHG;
      if (j != 1) {
        break label370;
      }
      bool1 = true;
      label225:
      paramVideoTransPara.oHT = bool1;
      oHE = true;
      localObject1 = ah.getContext();
      localObject2 = ah.getResources();
      if (oHG != null) {
        break label376;
      }
    }
    label312:
    label331:
    label370:
    label376:
    for (paramVideoTransPara = "";; paramVideoTransPara = Integer.valueOf(oHG.oHR))
    {
      t.makeText((Context)localObject1, ((Resources)localObject2).getString(2131300719, new Object[] { paramVideoTransPara }), 1).show();
      AppMethodBeat.o(76528);
      return;
      i = bo.getInt(((a)com.tencent.mm.kernel.g.E(a.class)).Nq().getValue("SightMediaCodecMinApiLevel"), 19);
      break;
      com.tencent.mm.kernel.g.RM();
      ac.ll(com.tencent.mm.kernel.g.RL().Rv().dyM());
      break label121;
      com.tencent.mm.kernel.g.RM();
      k = com.tencent.mm.kernel.g.RL().Ru().getInt(ac.a.yDV, -1);
      com.tencent.mm.kernel.g.RM();
      j = com.tencent.mm.kernel.g.RL().Ru().getInt(ac.a.yDY, 1);
      break label196;
      bool1 = false;
      break label225;
    }
    label389:
    switch (1.oHI[localObject1.ordinal()])
    {
    default: 
      k = ac.erB.eqR;
      ab.i("MicroMsg.MMSightRecorderConfig", "recorderOption: %s", new Object[] { Integer.valueOf(k) });
      if (k != -1) {
        oHG = o.a(k, paramVideoTransPara);
      }
      if (oHG == null) {
        break label505;
      }
      if (j != 1) {
        break;
      }
    }
    for (oHG.oHT = true;; oHG.oHT = false)
    {
      oHF = true;
      AppMethodBeat.o(76528);
      return;
      localObject1 = ac.erC;
      k = 12;
      break;
    }
    label505:
    oHG = o.a(1, paramVideoTransPara);
    if (j == 1)
    {
      oHG.oHT = true;
      if (ac.erB.eqK == -1) {
        break label626;
      }
      oHG.eqK = ac.erB.eqK;
      label547:
      if (ac.erB.eqN != -1)
      {
        if (ac.erB.eqN != 1) {
          break label653;
        }
        bool1 = true;
        label570:
        oHD = bool1;
      }
      if (ac.erB.eqL == -1) {
        break label665;
      }
      paramVideoTransPara = oHG;
      if (ac.erB.eqL != 1) {
        break label659;
      }
    }
    label653:
    label659:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramVideoTransPara.fdl = bool1;
      AppMethodBeat.o(76528);
      return;
      oHG.oHT = false;
      break;
      label626:
      if (com.tencent.mm.compatible.util.d.fv(i))
      {
        oHG.eqK = 2;
        break label547;
      }
      oHG.eqK = 1;
      break label547;
      bool1 = false;
      break label570;
    }
    label665:
    oHG.fdl = false;
    AppMethodBeat.o(76528);
  }
  
  public static boolean d(Point paramPoint)
  {
    AppMethodBeat.i(76526);
    if (oHE)
    {
      Context localContext = ah.getContext();
      Resources localResources = ah.getResources();
      if (oHG == null) {}
      for (paramPoint = "";; paramPoint = Integer.valueOf(oHG.oHR))
      {
        t.makeText(localContext, localResources.getString(2131300719, new Object[] { paramPoint }), 1).show();
        AppMethodBeat.o(76526);
        return false;
      }
    }
    ab.i("MicroMsg.MMSightRecorderConfig", "checkMediaCodecHappy, deviceInfo recorderType: %s, recorderOption: %s, isUseRecorderOption: %s", new Object[] { Integer.valueOf(ac.erB.eqK), Integer.valueOf(ac.erB.eqR), Boolean.valueOf(oHF) });
    if (oHF)
    {
      AppMethodBeat.o(76526);
      return false;
    }
    if (ac.erB.eqK != -1)
    {
      AppMethodBeat.o(76526);
      return true;
    }
    if ((oHG != null) && (1 == oHG.eqK))
    {
      AppMethodBeat.o(76526);
      return true;
    }
    if (paramPoint == null)
    {
      AppMethodBeat.o(76526);
      return false;
    }
    if ((com.tencent.mm.plugin.mmsight.d.zo(paramPoint.x)) && (com.tencent.mm.plugin.mmsight.d.zo(paramPoint.y)))
    {
      AppMethodBeat.o(76526);
      return true;
    }
    if (oHG != null)
    {
      ab.i("MicroMsg.MMSightRecorderConfig", "checkMediaCodecHappy not happy %s", new Object[] { paramPoint.toString() });
      oHG.eqK = 1;
    }
    AppMethodBeat.o(76526);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.j
 * JD-Core Version:    0.7.0.1
 */