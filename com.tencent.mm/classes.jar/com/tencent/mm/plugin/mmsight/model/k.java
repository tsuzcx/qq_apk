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
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.base.t;

public final class k
{
  static int iuX;
  public static boolean vOn = true;
  public static boolean vOo = false;
  public static boolean vOp = false;
  public static p vOq;
  static double vOr;
  
  public static void a(Camera.Parameters paramParameters, boolean paramBoolean)
  {
    AppMethodBeat.i(89426);
    Object localObject2;
    if (vOo)
    {
      localObject1 = aj.getContext();
      localObject2 = aj.getResources();
      if (vOq == null) {}
      for (paramParameters = "";; paramParameters = Integer.valueOf(vOq.vOC))
      {
        t.makeText((Context)localObject1, ((Resources)localObject2).getString(2131760316, new Object[] { paramParameters }), 1).show();
        AppMethodBeat.o(89426);
        return;
      }
    }
    ad.i("MicroMsg.MMSightRecorderConfig", "autoConfig, recorderOption: %s, isUseRecorderOption: %s", new Object[] { Integer.valueOf(ae.gcL.gbq), Boolean.valueOf(vOp) });
    if (vOp)
    {
      AppMethodBeat.o(89426);
      return;
    }
    Object localObject1 = com.tencent.mm.plugin.mmsight.d.dmE();
    int k;
    int i;
    int j;
    if ((CaptureMMProxy.getInstance() != null) && (!aj.cnC()))
    {
      k = bt.getInt(CaptureMMProxy.getInstance().getDynamicConfig("SightMediaCodecMinApiLevel"), 19);
      i = bt.getInt(CaptureMMProxy.getInstance().getDynamicConfig("Sight1080pRecordMinApiLevel"), 19);
      j = bt.getInt(CaptureMMProxy.getInstance().getDynamicConfig("Sight720pRecordMinApiLevel"), 19);
      ad.i("MicroMsg.MMSightRecorderConfig", "apiLevel: %s record1080pApiLevel: %s, record720pApiLevel: %s", new Object[] { Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j) });
      if ((ae.gcL.gbp != -1) && ((ae.gcL.gbp & 0x1) == 0)) {
        break label714;
      }
      if ((ae.gcL.gbp == -1) || ((ae.gcL.gbp & 0x1) == 0)) {
        break label467;
      }
      vOq.dnc().vOD = true;
      i = 1;
    }
    for (;;)
    {
      boolean bool;
      if (ae.gcL.gbk != -1)
      {
        localObject2 = vOq;
        if (ae.gcL.gbk == 1)
        {
          bool = true;
          label292:
          ((p)localObject2).hwb = bool;
          label299:
          if ((ae.gcL.gbp == -1) || ((ae.gcL.gbp & 0x2) != 0))
          {
            if ((ae.gcL.gbp == -1) || ((ae.gcL.gbp & 0x2) == 0)) {
              break label601;
            }
            paramParameters = vOq.dna();
            paramParameters.vOD = false;
            paramParameters.dnb();
          }
        }
      }
      label712:
      for (;;)
      {
        vOq.vOC = -1;
        ad.i("MicroMsg.MMSightRecorderConfig", "autoConfig parameter byserver %s", new Object[] { vOq.toString() });
        AppMethodBeat.o(89426);
        return;
        k = bt.getInt(((a)g.ab(a.class)).acA().getValue("SightMediaCodecMinApiLevel"), 19);
        i = bt.getInt(((a)g.ab(a.class)).acA().getValue("Sight1080pRecordMinApiLevel"), 19);
        j = bt.getInt(((a)g.ab(a.class)).acA().getValue("Sight720pRecordMinApiLevel"), 19);
        break;
        label467:
        if ((!com.tencent.mm.compatible.util.d.ly(i)) || (iuX < 512) || (vOr < 1725.0D) || (Math.min(((Point)localObject1).x, ((Point)localObject1).y) < 1080)) {
          break label714;
        }
        localObject2 = vOq;
        ((p)localObject2).vOG = h.b(paramParameters, com.tencent.mm.plugin.mmsight.d.dmE(), ((p)localObject2).hvh.width * 2, paramBoolean);
        if ((((p)localObject2).vOG != null) && (((p)localObject2).vOG.vOe != null)) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label714;
          }
          vOq.dnc().vOD = true;
          i = 1;
          break;
        }
        bool = false;
        break label292;
        vOq.hwb = false;
        break label299;
        label601:
        if ((i == 0) && (com.tencent.mm.compatible.util.d.ly(j)) && (iuX >= 512) && (vOr >= 1725.0D) && (Math.min(((Point)localObject1).x, ((Point)localObject1).y) >= 720))
        {
          localObject1 = vOq;
          ((p)localObject1).vOG = h.b(paramParameters, com.tencent.mm.plugin.mmsight.d.dmE(), 720, paramBoolean);
          if ((((p)localObject1).vOG != null) && (((p)localObject1).vOG.vOe != null)) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label712;
            }
            vOq.dna().vOD = true;
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
    if (paramc.vOe == null)
    {
      ad.i("MicroMsg.MMSightRecorderConfig", "checkMore start %s", new Object[] { paramc.toString() });
      paramc.vOe = paramc.vOh;
      paramc.vOf = paramc.vOi;
      paramc.vOg = paramc.vOj;
      if (Math.min(paramc.vOf.y, paramc.vOf.x) >= vOq.hvh.width + 16)
      {
        vOq.dnb();
        vOq.vOD = false;
        vOq.hwb = false;
        ad.i("MicroMsg.MMSightRecorderConfig", "checkMore out %s", new Object[] { paramc.toString() });
      }
    }
    AppMethodBeat.o(89429);
  }
  
  public static void d(VideoTransPara paramVideoTransPara)
  {
    boolean bool2 = true;
    AppMethodBeat.i(89427);
    Object localObject1 = k.a.vOt;
    vOo = false;
    vOp = false;
    iuX = ((ActivityManager)aj.getContext().getSystemService("activity")).getLargeMemoryClass();
    vOr = com.tencent.mm.plugin.mmsight.d.fN(aj.getContext());
    Object localObject2 = cc.fsJ();
    int i;
    label121:
    int n;
    int m;
    int k;
    int j;
    if ((CaptureMMProxy.getInstance() != null) && (!aj.cnC()))
    {
      i = bt.getInt(CaptureMMProxy.getInstance().getDynamicConfig("SightMediaCodecMinApiLevel"), 19);
      ad.i("MicroMsg.MMSightRecorderConfig", "MXM_DynaCfg_AV_Item_Key_SightMediaCodecMinApiLevel: %s", new Object[] { Integer.valueOf(i) });
      if ((CaptureMMProxy.getInstance() == null) || (aj.cnC())) {
        break label338;
      }
      ae.vi(CaptureMMProxy.getInstance().getDeviceInfoConfig());
      ad.i("MicroMsg.MMSightRecorderConfig", "init large memory class: %sMB, totalMemory: %sGB  fingerprint: %s mmSightRecorderInfo: %s", new Object[] { Integer.valueOf(iuX), Double.valueOf(vOr), localObject2, ae.gcL });
      if ((CaptureMMProxy.getInstance() == null) || (aj.cnC())) {
        break label357;
      }
      n = CaptureMMProxy.getInstance().getInt(al.a.IwC, -1);
      m = CaptureMMProxy.getInstance().getInt(al.a.IwF, 1);
      k = CaptureMMProxy.getInstance().getInt(al.a.IGs, 1);
      j = CaptureMMProxy.getInstance().getInt(al.a.IGt, 2);
      label220:
      localObject2 = p.a(n, paramVideoTransPara);
      vOq = (p)localObject2;
      if (localObject2 == null) {
        break label453;
      }
      paramVideoTransPara = vOq;
      if (m != 1) {
        break label434;
      }
      bool1 = true;
      label251:
      paramVideoTransPara.vOE = bool1;
      vOo = true;
      localObject1 = aj.getContext();
      localObject2 = aj.getResources();
      if (vOq != null) {
        break label440;
      }
    }
    label434:
    label440:
    for (paramVideoTransPara = "";; paramVideoTransPara = Integer.valueOf(vOq.vOC))
    {
      t.makeText((Context)localObject1, ((Resources)localObject2).getString(2131760316, new Object[] { paramVideoTransPara }), 1).show();
      AppMethodBeat.o(89427);
      return;
      i = bt.getInt(((a)g.ab(a.class)).acA().getValue("SightMediaCodecMinApiLevel"), 19);
      break;
      label338:
      g.ajD();
      ae.vi(g.ajC().ajm().fsH());
      break label121;
      label357:
      g.ajD();
      n = g.ajC().ajl().getInt(al.a.IwC, -1);
      g.ajD();
      m = g.ajC().ajl().getInt(al.a.IwF, 1);
      g.ajD();
      k = g.ajC().ajl().getInt(al.a.IGs, 1);
      g.ajD();
      j = g.ajC().ajl().getInt(al.a.IGt, 2);
      break label220;
      bool1 = false;
      break label251;
    }
    label453:
    switch (k.1.vOs[localObject1.ordinal()])
    {
    default: 
      n = ae.gcL.gbq;
      ad.i("MicroMsg.MMSightRecorderConfig", "recorderOption: %s", new Object[] { Integer.valueOf(n) });
      if (n != -1) {
        vOq = p.a(n, paramVideoTransPara);
      }
      if (vOq == null) {
        break label575;
      }
      if (m != 1) {
        break;
      }
    }
    for (vOq.vOE = true;; vOq.vOE = false)
    {
      vOp = true;
      AppMethodBeat.o(89427);
      return;
      localObject1 = ae.gcM;
      n = 12;
      break;
    }
    label575:
    vOq = p.a(1, paramVideoTransPara);
    if (m == 1)
    {
      vOq.vOE = true;
      vOq.vOB = k;
      paramVideoTransPara = vOq;
      if (j != 2) {
        break label722;
      }
      bool1 = true;
      label615:
      paramVideoTransPara.pQy = bool1;
      if (ae.gcL.gbj == -1) {
        break label728;
      }
      vOq.gbj = ae.gcL.gbj;
      label643:
      if (ae.gcL.gbm != -1)
      {
        if (ae.gcL.gbm != 1) {
          break label755;
        }
        bool1 = true;
        label666:
        vOn = bool1;
      }
      if (ae.gcL.gbk == -1) {
        break label767;
      }
      paramVideoTransPara = vOq;
      if (ae.gcL.gbk != 1) {
        break label761;
      }
    }
    label722:
    label728:
    label755:
    label761:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramVideoTransPara.hwb = bool1;
      AppMethodBeat.o(89427);
      return;
      vOq.vOE = false;
      break;
      bool1 = false;
      break label615;
      if (com.tencent.mm.compatible.util.d.ly(i))
      {
        vOq.gbj = 2;
        break label643;
      }
      vOq.gbj = 1;
      break label643;
      bool1 = false;
      break label666;
    }
    label767:
    vOq.hwb = false;
    AppMethodBeat.o(89427);
  }
  
  public static boolean dmU()
  {
    AppMethodBeat.i(89428);
    if ((CaptureMMProxy.getInstance() != null) && (!aj.cnC()))
    {
      if (CaptureMMProxy.getInstance().getInt(al.a.IwC, -1) != -1)
      {
        AppMethodBeat.o(89428);
        return true;
      }
      AppMethodBeat.o(89428);
      return false;
    }
    g.ajD();
    if (g.ajC().ajl().getInt(al.a.IwC, -1) != -1)
    {
      AppMethodBeat.o(89428);
      return true;
    }
    AppMethodBeat.o(89428);
    return false;
  }
  
  public static void dmV()
  {
    AppMethodBeat.i(89430);
    ad.i("MicroMsg.MMSightRecorderConfig", "initSimple");
    p localp = new p();
    vOq = localp;
    localp.hwb = false;
    vOq.vOD = false;
    if (com.tencent.mm.compatible.util.d.ly(19))
    {
      vOq.gbj = 2;
      AppMethodBeat.o(89430);
      return;
    }
    vOq.gbj = 1;
    AppMethodBeat.o(89430);
  }
  
  public static boolean g(Point paramPoint)
  {
    AppMethodBeat.i(89425);
    if (vOo)
    {
      Context localContext = aj.getContext();
      Resources localResources = aj.getResources();
      if (vOq == null) {}
      for (paramPoint = "";; paramPoint = Integer.valueOf(vOq.vOC))
      {
        t.makeText(localContext, localResources.getString(2131760316, new Object[] { paramPoint }), 1).show();
        AppMethodBeat.o(89425);
        return false;
      }
    }
    ad.i("MicroMsg.MMSightRecorderConfig", "checkMediaCodecHappy, deviceInfo recorderType: %s, recorderOption: %s, isUseRecorderOption: %s", new Object[] { Integer.valueOf(ae.gcL.gbj), Integer.valueOf(ae.gcL.gbq), Boolean.valueOf(vOp) });
    if (vOp)
    {
      AppMethodBeat.o(89425);
      return false;
    }
    if (ae.gcL.gbj != -1)
    {
      AppMethodBeat.o(89425);
      return true;
    }
    if ((vOq != null) && (1 == vOq.gbj))
    {
      AppMethodBeat.o(89425);
      return true;
    }
    if (paramPoint == null)
    {
      AppMethodBeat.o(89425);
      return false;
    }
    if ((com.tencent.mm.plugin.mmsight.d.Kh(paramPoint.x)) && (com.tencent.mm.plugin.mmsight.d.Kh(paramPoint.y)))
    {
      AppMethodBeat.o(89425);
      return true;
    }
    if (vOq != null)
    {
      ad.i("MicroMsg.MMSightRecorderConfig", "checkMediaCodecHappy not happy %s", new Object[] { paramPoint.toString() });
      vOq.gbj = 1;
    }
    AppMethodBeat.o(89425);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.k
 * JD-Core Version:    0.7.0.1
 */