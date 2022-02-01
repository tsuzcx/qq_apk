package com.tencent.mm.plugin.mmsight.model;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.hardware.Camera.Parameters;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.x;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.base.t;

public final class k
{
  static int ibB;
  public static boolean uLh = true;
  public static boolean uLi = false;
  public static boolean uLj = false;
  public static p uLk;
  static double uLl;
  
  public static void a(Camera.Parameters paramParameters, boolean paramBoolean)
  {
    AppMethodBeat.i(89426);
    Object localObject2;
    if (uLi)
    {
      localObject1 = ai.getContext();
      localObject2 = ai.getResources();
      if (uLk == null) {}
      for (paramParameters = "";; paramParameters = Integer.valueOf(uLk.uLw))
      {
        t.makeText((Context)localObject1, ((Resources)localObject2).getString(2131760316, new Object[] { paramParameters }), 1).show();
        AppMethodBeat.o(89426);
        return;
      }
    }
    ac.i("MicroMsg.MMSightRecorderConfig", "autoConfig, recorderOption: %s, isUseRecorderOption: %s", new Object[] { Integer.valueOf(com.tencent.mm.compatible.deviceinfo.ae.fJk.fHQ), Boolean.valueOf(uLj) });
    if (uLj)
    {
      AppMethodBeat.o(89426);
      return;
    }
    Object localObject1 = com.tencent.mm.plugin.mmsight.d.ddi();
    int k;
    int i;
    int j;
    if ((CaptureMMProxy.getInstance() != null) && (!ai.ciE()))
    {
      k = bs.getInt(CaptureMMProxy.getInstance().getDynamicConfig("SightMediaCodecMinApiLevel"), 19);
      i = bs.getInt(CaptureMMProxy.getInstance().getDynamicConfig("Sight1080pRecordMinApiLevel"), 19);
      j = bs.getInt(CaptureMMProxy.getInstance().getDynamicConfig("Sight720pRecordMinApiLevel"), 19);
      ac.i("MicroMsg.MMSightRecorderConfig", "apiLevel: %s record1080pApiLevel: %s, record720pApiLevel: %s", new Object[] { Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j) });
      if ((com.tencent.mm.compatible.deviceinfo.ae.fJk.fHP != -1) && ((com.tencent.mm.compatible.deviceinfo.ae.fJk.fHP & 0x1) == 0)) {
        break label714;
      }
      if ((com.tencent.mm.compatible.deviceinfo.ae.fJk.fHP == -1) || ((com.tencent.mm.compatible.deviceinfo.ae.fJk.fHP & 0x1) == 0)) {
        break label467;
      }
      uLk.ddG().uLx = true;
      i = 1;
    }
    for (;;)
    {
      boolean bool;
      if (com.tencent.mm.compatible.deviceinfo.ae.fJk.fHK != -1)
      {
        localObject2 = uLk;
        if (com.tencent.mm.compatible.deviceinfo.ae.fJk.fHK == 1)
        {
          bool = true;
          label292:
          ((p)localObject2).hdT = bool;
          label299:
          if ((com.tencent.mm.compatible.deviceinfo.ae.fJk.fHP == -1) || ((com.tencent.mm.compatible.deviceinfo.ae.fJk.fHP & 0x2) != 0))
          {
            if ((com.tencent.mm.compatible.deviceinfo.ae.fJk.fHP == -1) || ((com.tencent.mm.compatible.deviceinfo.ae.fJk.fHP & 0x2) == 0)) {
              break label601;
            }
            paramParameters = uLk.ddE();
            paramParameters.uLx = false;
            paramParameters.ddF();
          }
        }
      }
      label712:
      for (;;)
      {
        uLk.uLw = -1;
        ac.i("MicroMsg.MMSightRecorderConfig", "autoConfig parameter byserver %s", new Object[] { uLk.toString() });
        AppMethodBeat.o(89426);
        return;
        k = bs.getInt(((a)g.ab(a.class)).ZY().getValue("SightMediaCodecMinApiLevel"), 19);
        i = bs.getInt(((a)g.ab(a.class)).ZY().getValue("Sight1080pRecordMinApiLevel"), 19);
        j = bs.getInt(((a)g.ab(a.class)).ZY().getValue("Sight720pRecordMinApiLevel"), 19);
        break;
        label467:
        if ((!com.tencent.mm.compatible.util.d.kZ(i)) || (ibB < 512) || (uLl < 1725.0D) || (Math.min(((Point)localObject1).x, ((Point)localObject1).y) < 1080)) {
          break label714;
        }
        localObject2 = uLk;
        ((p)localObject2).uLA = h.b(paramParameters, com.tencent.mm.plugin.mmsight.d.ddi(), ((p)localObject2).hcZ.width * 2, paramBoolean);
        if ((((p)localObject2).uLA != null) && (((p)localObject2).uLA.uKY != null)) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label714;
          }
          uLk.ddG().uLx = true;
          i = 1;
          break;
        }
        bool = false;
        break label292;
        uLk.hdT = false;
        break label299;
        label601:
        if ((i == 0) && (com.tencent.mm.compatible.util.d.kZ(j)) && (ibB >= 512) && (uLl >= 1725.0D) && (Math.min(((Point)localObject1).x, ((Point)localObject1).y) >= 720))
        {
          localObject1 = uLk;
          ((p)localObject1).uLA = h.b(paramParameters, com.tencent.mm.plugin.mmsight.d.ddi(), 720, paramBoolean);
          if ((((p)localObject1).uLA != null) && (((p)localObject1).uLA.uKY != null)) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label712;
            }
            uLk.ddE().uLx = true;
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
    if (paramc.uKY == null)
    {
      ac.i("MicroMsg.MMSightRecorderConfig", "checkMore start %s", new Object[] { paramc.toString() });
      paramc.uKY = paramc.uLb;
      paramc.uKZ = paramc.uLc;
      paramc.uLa = paramc.uLd;
      if (Math.min(paramc.uKZ.y, paramc.uKZ.x) >= uLk.hcZ.width + 16)
      {
        uLk.ddF();
        uLk.uLx = false;
        uLk.hdT = false;
        ac.i("MicroMsg.MMSightRecorderConfig", "checkMore out %s", new Object[] { paramc.toString() });
      }
    }
    AppMethodBeat.o(89429);
  }
  
  public static void d(VideoTransPara paramVideoTransPara)
  {
    boolean bool2 = true;
    AppMethodBeat.i(89427);
    Object localObject1 = a.uLn;
    uLi = false;
    uLj = false;
    ibB = ((ActivityManager)ai.getContext().getSystemService("activity")).getLargeMemoryClass();
    uLl = com.tencent.mm.plugin.mmsight.d.fI(ai.getContext());
    Object localObject2 = bw.fcC();
    int i;
    label121:
    int n;
    int m;
    int k;
    int j;
    if ((CaptureMMProxy.getInstance() != null) && (!ai.ciE()))
    {
      i = bs.getInt(CaptureMMProxy.getInstance().getDynamicConfig("SightMediaCodecMinApiLevel"), 19);
      ac.i("MicroMsg.MMSightRecorderConfig", "MXM_DynaCfg_AV_Item_Key_SightMediaCodecMinApiLevel: %s", new Object[] { Integer.valueOf(i) });
      if ((CaptureMMProxy.getInstance() == null) || (ai.ciE())) {
        break label338;
      }
      com.tencent.mm.compatible.deviceinfo.ae.st(CaptureMMProxy.getInstance().getDeviceInfoConfig());
      ac.i("MicroMsg.MMSightRecorderConfig", "init large memory class: %sMB, totalMemory: %sGB  fingerprint: %s mmSightRecorderInfo: %s", new Object[] { Integer.valueOf(ibB), Double.valueOf(uLl), localObject2, com.tencent.mm.compatible.deviceinfo.ae.fJk });
      if ((CaptureMMProxy.getInstance() == null) || (ai.ciE())) {
        break label357;
      }
      n = CaptureMMProxy.getInstance().getInt(ah.a.GKk, -1);
      m = CaptureMMProxy.getInstance().getInt(ah.a.GKn, 1);
      k = CaptureMMProxy.getInstance().getInt(ah.a.GTM, 1);
      j = CaptureMMProxy.getInstance().getInt(ah.a.GTN, 2);
      label220:
      localObject2 = p.a(n, paramVideoTransPara);
      uLk = (p)localObject2;
      if (localObject2 == null) {
        break label453;
      }
      paramVideoTransPara = uLk;
      if (m != 1) {
        break label434;
      }
      bool1 = true;
      label251:
      paramVideoTransPara.uLy = bool1;
      uLi = true;
      localObject1 = ai.getContext();
      localObject2 = ai.getResources();
      if (uLk != null) {
        break label440;
      }
    }
    label434:
    label440:
    for (paramVideoTransPara = "";; paramVideoTransPara = Integer.valueOf(uLk.uLw))
    {
      t.makeText((Context)localObject1, ((Resources)localObject2).getString(2131760316, new Object[] { paramVideoTransPara }), 1).show();
      AppMethodBeat.o(89427);
      return;
      i = bs.getInt(((a)g.ab(a.class)).ZY().getValue("SightMediaCodecMinApiLevel"), 19);
      break;
      label338:
      g.agS();
      com.tencent.mm.compatible.deviceinfo.ae.st(g.agR().agB().fcA());
      break label121;
      label357:
      g.agS();
      n = g.agR().agA().getInt(ah.a.GKk, -1);
      g.agS();
      m = g.agR().agA().getInt(ah.a.GKn, 1);
      g.agS();
      k = g.agR().agA().getInt(ah.a.GTM, 1);
      g.agS();
      j = g.agR().agA().getInt(ah.a.GTN, 2);
      break label220;
      bool1 = false;
      break label251;
    }
    label453:
    switch (1.uLm[localObject1.ordinal()])
    {
    default: 
      n = com.tencent.mm.compatible.deviceinfo.ae.fJk.fHQ;
      ac.i("MicroMsg.MMSightRecorderConfig", "recorderOption: %s", new Object[] { Integer.valueOf(n) });
      if (n != -1) {
        uLk = p.a(n, paramVideoTransPara);
      }
      if (uLk == null) {
        break label575;
      }
      if (m != 1) {
        break;
      }
    }
    for (uLk.uLy = true;; uLk.uLy = false)
    {
      uLj = true;
      AppMethodBeat.o(89427);
      return;
      localObject1 = com.tencent.mm.compatible.deviceinfo.ae.fJl;
      n = 12;
      break;
    }
    label575:
    uLk = p.a(1, paramVideoTransPara);
    if (m == 1)
    {
      uLk.uLy = true;
      uLk.uLv = k;
      paramVideoTransPara = uLk;
      if (j != 2) {
        break label722;
      }
      bool1 = true;
      label615:
      paramVideoTransPara.pmY = bool1;
      if (com.tencent.mm.compatible.deviceinfo.ae.fJk.fHJ == -1) {
        break label728;
      }
      uLk.fHJ = com.tencent.mm.compatible.deviceinfo.ae.fJk.fHJ;
      label643:
      if (com.tencent.mm.compatible.deviceinfo.ae.fJk.fHM != -1)
      {
        if (com.tencent.mm.compatible.deviceinfo.ae.fJk.fHM != 1) {
          break label755;
        }
        bool1 = true;
        label666:
        uLh = bool1;
      }
      if (com.tencent.mm.compatible.deviceinfo.ae.fJk.fHK == -1) {
        break label767;
      }
      paramVideoTransPara = uLk;
      if (com.tencent.mm.compatible.deviceinfo.ae.fJk.fHK != 1) {
        break label761;
      }
    }
    label722:
    label728:
    label755:
    label761:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramVideoTransPara.hdT = bool1;
      AppMethodBeat.o(89427);
      return;
      uLk.uLy = false;
      break;
      bool1 = false;
      break label615;
      if (com.tencent.mm.compatible.util.d.kZ(i))
      {
        uLk.fHJ = 2;
        break label643;
      }
      uLk.fHJ = 1;
      break label643;
      bool1 = false;
      break label666;
    }
    label767:
    uLk.hdT = false;
    AppMethodBeat.o(89427);
  }
  
  public static boolean ddy()
  {
    AppMethodBeat.i(89428);
    if ((CaptureMMProxy.getInstance() != null) && (!ai.ciE()))
    {
      if (CaptureMMProxy.getInstance().getInt(ah.a.GKk, -1) != -1)
      {
        AppMethodBeat.o(89428);
        return true;
      }
      AppMethodBeat.o(89428);
      return false;
    }
    g.agS();
    if (g.agR().agA().getInt(ah.a.GKk, -1) != -1)
    {
      AppMethodBeat.o(89428);
      return true;
    }
    AppMethodBeat.o(89428);
    return false;
  }
  
  public static void ddz()
  {
    AppMethodBeat.i(89430);
    ac.i("MicroMsg.MMSightRecorderConfig", "initSimple");
    p localp = new p();
    uLk = localp;
    localp.hdT = false;
    uLk.uLx = false;
    if (com.tencent.mm.compatible.util.d.kZ(19))
    {
      uLk.fHJ = 2;
      AppMethodBeat.o(89430);
      return;
    }
    uLk.fHJ = 1;
    AppMethodBeat.o(89430);
  }
  
  public static boolean f(Point paramPoint)
  {
    AppMethodBeat.i(89425);
    if (uLi)
    {
      Context localContext = ai.getContext();
      Resources localResources = ai.getResources();
      if (uLk == null) {}
      for (paramPoint = "";; paramPoint = Integer.valueOf(uLk.uLw))
      {
        t.makeText(localContext, localResources.getString(2131760316, new Object[] { paramPoint }), 1).show();
        AppMethodBeat.o(89425);
        return false;
      }
    }
    ac.i("MicroMsg.MMSightRecorderConfig", "checkMediaCodecHappy, deviceInfo recorderType: %s, recorderOption: %s, isUseRecorderOption: %s", new Object[] { Integer.valueOf(com.tencent.mm.compatible.deviceinfo.ae.fJk.fHJ), Integer.valueOf(com.tencent.mm.compatible.deviceinfo.ae.fJk.fHQ), Boolean.valueOf(uLj) });
    if (uLj)
    {
      AppMethodBeat.o(89425);
      return false;
    }
    if (com.tencent.mm.compatible.deviceinfo.ae.fJk.fHJ != -1)
    {
      AppMethodBeat.o(89425);
      return true;
    }
    if ((uLk != null) && (1 == uLk.fHJ))
    {
      AppMethodBeat.o(89425);
      return true;
    }
    if (paramPoint == null)
    {
      AppMethodBeat.o(89425);
      return false;
    }
    if ((com.tencent.mm.plugin.mmsight.d.IK(paramPoint.x)) && (com.tencent.mm.plugin.mmsight.d.IK(paramPoint.y)))
    {
      AppMethodBeat.o(89425);
      return true;
    }
    if (uLk != null)
    {
      ac.i("MicroMsg.MMSightRecorderConfig", "checkMediaCodecHappy not happy %s", new Object[] { paramPoint.toString() });
      uLk.fHJ = 1;
    }
    AppMethodBeat.o(89425);
    return false;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(89424);
      uLn = new a("MMSightCameraConfig", 0);
      uLo = new a("MMStoryCameraConfig", 1);
      uLp = new a[] { uLn, uLo };
      AppMethodBeat.o(89424);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.k
 * JD-Core Version:    0.7.0.1
 */