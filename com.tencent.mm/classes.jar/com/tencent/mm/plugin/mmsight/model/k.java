package com.tencent.mm.plugin.mmsight.model;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.hardware.Camera.Parameters;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.x;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.base.t;

public final class k
{
  static int hBa;
  public static boolean tCK = true;
  public static boolean tCL = false;
  public static boolean tCM = false;
  public static p tCN;
  static double tCO;
  
  public static void a(Camera.Parameters paramParameters, boolean paramBoolean)
  {
    AppMethodBeat.i(89426);
    Object localObject2;
    if (tCL)
    {
      localObject1 = aj.getContext();
      localObject2 = aj.getResources();
      if (tCN == null) {}
      for (paramParameters = "";; paramParameters = Integer.valueOf(tCN.tCZ))
      {
        t.makeText((Context)localObject1, ((Resources)localObject2).getString(2131760316, new Object[] { paramParameters }), 1).show();
        AppMethodBeat.o(89426);
        return;
      }
    }
    ad.i("MicroMsg.MMSightRecorderConfig", "autoConfig, recorderOption: %s, isUseRecorderOption: %s", new Object[] { Integer.valueOf(ae.fFD.fEj), Boolean.valueOf(tCM) });
    if (tCM)
    {
      AppMethodBeat.o(89426);
      return;
    }
    Object localObject1 = com.tencent.mm.plugin.mmsight.d.cPz();
    int k;
    int i;
    int j;
    if ((CaptureMMProxy.getInstance() != null) && (!aj.cbv()))
    {
      k = com.tencent.mm.sdk.platformtools.bt.getInt(CaptureMMProxy.getInstance().getDynamicConfig("SightMediaCodecMinApiLevel"), 19);
      i = com.tencent.mm.sdk.platformtools.bt.getInt(CaptureMMProxy.getInstance().getDynamicConfig("Sight1080pRecordMinApiLevel"), 19);
      j = com.tencent.mm.sdk.platformtools.bt.getInt(CaptureMMProxy.getInstance().getDynamicConfig("Sight720pRecordMinApiLevel"), 19);
      ad.i("MicroMsg.MMSightRecorderConfig", "apiLevel: %s record1080pApiLevel: %s, record720pApiLevel: %s", new Object[] { Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j) });
      if ((ae.fFD.fEi != -1) && ((ae.fFD.fEi & 0x1) == 0)) {
        break label714;
      }
      if ((ae.fFD.fEi == -1) || ((ae.fFD.fEi & 0x1) == 0)) {
        break label467;
      }
      tCN.cPY().tDa = true;
      i = 1;
    }
    for (;;)
    {
      boolean bool;
      if (ae.fFD.fEd != -1)
      {
        localObject2 = tCN;
        if (ae.fFD.fEd == 1)
        {
          bool = true;
          label292:
          ((p)localObject2).gDs = bool;
          label299:
          if ((ae.fFD.fEi == -1) || ((ae.fFD.fEi & 0x2) != 0))
          {
            if ((ae.fFD.fEi == -1) || ((ae.fFD.fEi & 0x2) == 0)) {
              break label601;
            }
            paramParameters = tCN.cPW();
            paramParameters.tDa = false;
            paramParameters.cPX();
          }
        }
      }
      label712:
      for (;;)
      {
        tCN.tCZ = -1;
        ad.i("MicroMsg.MMSightRecorderConfig", "autoConfig parameter byserver %s", new Object[] { tCN.toString() });
        AppMethodBeat.o(89426);
        return;
        k = com.tencent.mm.sdk.platformtools.bt.getInt(((a)g.ab(a.class)).Zd().getValue("SightMediaCodecMinApiLevel"), 19);
        i = com.tencent.mm.sdk.platformtools.bt.getInt(((a)g.ab(a.class)).Zd().getValue("Sight1080pRecordMinApiLevel"), 19);
        j = com.tencent.mm.sdk.platformtools.bt.getInt(((a)g.ab(a.class)).Zd().getValue("Sight720pRecordMinApiLevel"), 19);
        break;
        label467:
        if ((!com.tencent.mm.compatible.util.d.lf(i)) || (hBa < 512) || (tCO < 1725.0D) || (Math.min(((Point)localObject1).x, ((Point)localObject1).y) < 1080)) {
          break label714;
        }
        localObject2 = tCN;
        ((p)localObject2).tDd = h.b(paramParameters, com.tencent.mm.plugin.mmsight.d.cPz(), ((p)localObject2).gCB.width * 2, paramBoolean);
        if ((((p)localObject2).tDd != null) && (((p)localObject2).tDd.tCB != null)) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label714;
          }
          tCN.cPY().tDa = true;
          i = 1;
          break;
        }
        bool = false;
        break label292;
        tCN.gDs = false;
        break label299;
        label601:
        if ((i == 0) && (com.tencent.mm.compatible.util.d.lf(j)) && (hBa >= 512) && (tCO >= 1725.0D) && (Math.min(((Point)localObject1).x, ((Point)localObject1).y) >= 720))
        {
          localObject1 = tCN;
          ((p)localObject1).tDd = h.b(paramParameters, com.tencent.mm.plugin.mmsight.d.cPz(), 720, paramBoolean);
          if ((((p)localObject1).tDd != null) && (((p)localObject1).tDd.tCB != null)) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label712;
            }
            tCN.cPW().tDa = true;
            break;
          }
        }
      }
      label714:
      i = 0;
    }
  }
  
  public static void a(h.c paramc)
  {
    AppMethodBeat.i(89429);
    if (paramc.tCB == null)
    {
      ad.i("MicroMsg.MMSightRecorderConfig", "checkMore start %s", new Object[] { paramc.toString() });
      paramc.tCB = paramc.tCE;
      paramc.tCC = paramc.tCF;
      paramc.tCD = paramc.tCG;
      if (Math.min(paramc.tCC.y, paramc.tCC.x) >= tCN.gCB.width + 16)
      {
        tCN.cPX();
        tCN.tDa = false;
        tCN.gDs = false;
        ad.i("MicroMsg.MMSightRecorderConfig", "checkMore out %s", new Object[] { paramc.toString() });
      }
    }
    AppMethodBeat.o(89429);
  }
  
  public static boolean cPQ()
  {
    AppMethodBeat.i(89428);
    if ((CaptureMMProxy.getInstance() != null) && (!aj.cbv()))
    {
      if (CaptureMMProxy.getInstance().getInt(ae.a.Fmv, -1) != -1)
      {
        AppMethodBeat.o(89428);
        return true;
      }
      AppMethodBeat.o(89428);
      return false;
    }
    g.afC();
    if (g.afB().afk().getInt(ae.a.Fmv, -1) != -1)
    {
      AppMethodBeat.o(89428);
      return true;
    }
    AppMethodBeat.o(89428);
    return false;
  }
  
  public static void cPR()
  {
    AppMethodBeat.i(89430);
    ad.i("MicroMsg.MMSightRecorderConfig", "initSimple");
    p localp = new p();
    tCN = localp;
    localp.gDs = false;
    tCN.tDa = false;
    if (com.tencent.mm.compatible.util.d.lf(19))
    {
      tCN.fEc = 2;
      AppMethodBeat.o(89430);
      return;
    }
    tCN.fEc = 1;
    AppMethodBeat.o(89430);
  }
  
  public static void d(VideoTransPara paramVideoTransPara)
  {
    boolean bool2 = true;
    AppMethodBeat.i(89427);
    Object localObject1 = a.tCQ;
    tCL = false;
    tCM = false;
    hBa = ((ActivityManager)aj.getContext().getSystemService("activity")).getLargeMemoryClass();
    tCO = com.tencent.mm.plugin.mmsight.d.fw(aj.getContext());
    Object localObject2 = com.tencent.mm.storage.bt.eMY();
    int i;
    label121:
    int n;
    int m;
    int k;
    int j;
    if ((CaptureMMProxy.getInstance() != null) && (!aj.cbv()))
    {
      i = com.tencent.mm.sdk.platformtools.bt.getInt(CaptureMMProxy.getInstance().getDynamicConfig("SightMediaCodecMinApiLevel"), 19);
      ad.i("MicroMsg.MMSightRecorderConfig", "MXM_DynaCfg_AV_Item_Key_SightMediaCodecMinApiLevel: %s", new Object[] { Integer.valueOf(i) });
      if ((CaptureMMProxy.getInstance() == null) || (aj.cbv())) {
        break label338;
      }
      ae.ph(CaptureMMProxy.getInstance().getDeviceInfoConfig());
      ad.i("MicroMsg.MMSightRecorderConfig", "init large memory class: %sMB, totalMemory: %sGB  fingerprint: %s mmSightRecorderInfo: %s", new Object[] { Integer.valueOf(hBa), Double.valueOf(tCO), localObject2, ae.fFD });
      if ((CaptureMMProxy.getInstance() == null) || (aj.cbv())) {
        break label357;
      }
      n = CaptureMMProxy.getInstance().getInt(ae.a.Fmv, -1);
      m = CaptureMMProxy.getInstance().getInt(ae.a.Fmy, 1);
      k = CaptureMMProxy.getInstance().getInt(ae.a.FvS, 1);
      j = CaptureMMProxy.getInstance().getInt(ae.a.FvT, 2);
      label220:
      localObject2 = p.a(n, paramVideoTransPara);
      tCN = (p)localObject2;
      if (localObject2 == null) {
        break label453;
      }
      paramVideoTransPara = tCN;
      if (m != 1) {
        break label434;
      }
      bool1 = true;
      label251:
      paramVideoTransPara.tDb = bool1;
      tCL = true;
      localObject1 = aj.getContext();
      localObject2 = aj.getResources();
      if (tCN != null) {
        break label440;
      }
    }
    label434:
    label440:
    for (paramVideoTransPara = "";; paramVideoTransPara = Integer.valueOf(tCN.tCZ))
    {
      t.makeText((Context)localObject1, ((Resources)localObject2).getString(2131760316, new Object[] { paramVideoTransPara }), 1).show();
      AppMethodBeat.o(89427);
      return;
      i = com.tencent.mm.sdk.platformtools.bt.getInt(((a)g.ab(a.class)).Zd().getValue("SightMediaCodecMinApiLevel"), 19);
      break;
      label338:
      g.afC();
      ae.ph(g.afB().afl().eMW());
      break label121;
      label357:
      g.afC();
      n = g.afB().afk().getInt(ae.a.Fmv, -1);
      g.afC();
      m = g.afB().afk().getInt(ae.a.Fmy, 1);
      g.afC();
      k = g.afB().afk().getInt(ae.a.FvS, 1);
      g.afC();
      j = g.afB().afk().getInt(ae.a.FvT, 2);
      break label220;
      bool1 = false;
      break label251;
    }
    label453:
    switch (1.tCP[localObject1.ordinal()])
    {
    default: 
      n = ae.fFD.fEj;
      ad.i("MicroMsg.MMSightRecorderConfig", "recorderOption: %s", new Object[] { Integer.valueOf(n) });
      if (n != -1) {
        tCN = p.a(n, paramVideoTransPara);
      }
      if (tCN == null) {
        break label575;
      }
      if (m != 1) {
        break;
      }
    }
    for (tCN.tDb = true;; tCN.tDb = false)
    {
      tCM = true;
      AppMethodBeat.o(89427);
      return;
      localObject1 = ae.fFE;
      n = 12;
      break;
    }
    label575:
    tCN = p.a(1, paramVideoTransPara);
    if (m == 1)
    {
      tCN.tDb = true;
      tCN.tCY = k;
      paramVideoTransPara = tCN;
      if (j != 2) {
        break label722;
      }
      bool1 = true;
      label615:
      paramVideoTransPara.oJA = bool1;
      if (ae.fFD.fEc == -1) {
        break label728;
      }
      tCN.fEc = ae.fFD.fEc;
      label643:
      if (ae.fFD.fEf != -1)
      {
        if (ae.fFD.fEf != 1) {
          break label755;
        }
        bool1 = true;
        label666:
        tCK = bool1;
      }
      if (ae.fFD.fEd == -1) {
        break label767;
      }
      paramVideoTransPara = tCN;
      if (ae.fFD.fEd != 1) {
        break label761;
      }
    }
    label722:
    label728:
    label755:
    label761:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramVideoTransPara.gDs = bool1;
      AppMethodBeat.o(89427);
      return;
      tCN.tDb = false;
      break;
      bool1 = false;
      break label615;
      if (com.tencent.mm.compatible.util.d.lf(i))
      {
        tCN.fEc = 2;
        break label643;
      }
      tCN.fEc = 1;
      break label643;
      bool1 = false;
      break label666;
    }
    label767:
    tCN.gDs = false;
    AppMethodBeat.o(89427);
  }
  
  public static boolean d(Point paramPoint)
  {
    AppMethodBeat.i(89425);
    if (tCL)
    {
      Context localContext = aj.getContext();
      Resources localResources = aj.getResources();
      if (tCN == null) {}
      for (paramPoint = "";; paramPoint = Integer.valueOf(tCN.tCZ))
      {
        t.makeText(localContext, localResources.getString(2131760316, new Object[] { paramPoint }), 1).show();
        AppMethodBeat.o(89425);
        return false;
      }
    }
    ad.i("MicroMsg.MMSightRecorderConfig", "checkMediaCodecHappy, deviceInfo recorderType: %s, recorderOption: %s, isUseRecorderOption: %s", new Object[] { Integer.valueOf(ae.fFD.fEc), Integer.valueOf(ae.fFD.fEj), Boolean.valueOf(tCM) });
    if (tCM)
    {
      AppMethodBeat.o(89425);
      return false;
    }
    if (ae.fFD.fEc != -1)
    {
      AppMethodBeat.o(89425);
      return true;
    }
    if ((tCN != null) && (1 == tCN.fEc))
    {
      AppMethodBeat.o(89425);
      return true;
    }
    if (paramPoint == null)
    {
      AppMethodBeat.o(89425);
      return false;
    }
    if ((com.tencent.mm.plugin.mmsight.d.GO(paramPoint.x)) && (com.tencent.mm.plugin.mmsight.d.GO(paramPoint.y)))
    {
      AppMethodBeat.o(89425);
      return true;
    }
    if (tCN != null)
    {
      ad.i("MicroMsg.MMSightRecorderConfig", "checkMediaCodecHappy not happy %s", new Object[] { paramPoint.toString() });
      tCN.fEc = 1;
    }
    AppMethodBeat.o(89425);
    return false;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(89424);
      tCQ = new a("MMSightCameraConfig", 0);
      tCR = new a("MMStoryCameraConfig", 1);
      tCS = new a[] { tCQ, tCR };
      AppMethodBeat.o(89424);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.k
 * JD-Core Version:    0.7.0.1
 */