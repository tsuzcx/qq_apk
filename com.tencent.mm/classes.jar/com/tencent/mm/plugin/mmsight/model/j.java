package com.tencent.mm.plugin.mmsight.model;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.hardware.Camera.Parameters;
import android.widget.Toast;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.e.t;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.t.a.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.bs;
import com.tencent.mm.ui.base.s;

public final class j
{
  static int eIy;
  private static boolean mhA = false;
  public static o mhB;
  static double mhC;
  public static boolean mhy = true;
  private static boolean mhz = false;
  
  public static void a(Camera.Parameters paramParameters, boolean paramBoolean)
  {
    Object localObject2;
    if (mhz)
    {
      localObject1 = ae.getContext();
      localObject2 = ae.getResources();
      i = a.a.i_want_you_know;
      if (mhB == null)
      {
        paramParameters = "";
        s.makeText((Context)localObject1, ((Resources)localObject2).getString(i, new Object[] { paramParameters }), 1).show();
      }
    }
    do
    {
      return;
      paramParameters = Integer.valueOf(mhB.mhK);
      break;
      y.i("MicroMsg.MMSightRecorderConfig", "autoConfig, recorderOption: %s, isUseRecorderOption: %s", new Object[] { Integer.valueOf(q.dyk.dyz), Boolean.valueOf(mhA) });
    } while (mhA);
    Object localObject1 = com.tencent.mm.plugin.mmsight.d.biC();
    int i = bk.getInt(CaptureMMProxy.getInstance().getDynamicConfig("SightMediaCodecMinApiLevel"), 19);
    int k = bk.getInt(CaptureMMProxy.getInstance().getDynamicConfig("Sight1080pRecordMinApiLevel"), 19);
    int j = bk.getInt(CaptureMMProxy.getInstance().getDynamicConfig("Sight720pRecordMinApiLevel"), 19);
    y.i("MicroMsg.MMSightRecorderConfig", "apiLevel: %s record1080pApiLevel: %s, record720pApiLevel: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j) });
    if ((q.dyk.dyy == -1) || ((q.dyk.dyy & 0x1) != 0)) {
      if ((q.dyk.dyy != -1) && ((q.dyk.dyy & 0x1) != 0))
      {
        mhB.bjc().mhM = true;
        i = 1;
      }
    }
    for (;;)
    {
      boolean bool;
      if (q.dyk.dyt != -1)
      {
        localObject2 = mhB;
        if (q.dyk.dyt == 1)
        {
          bool = true;
          label267:
          ((o)localObject2).mhL = bool;
          label274:
          if ((q.dyk.dyy == -1) || ((q.dyk.dyy & 0x2) != 0))
          {
            if ((q.dyk.dyy == -1) || ((q.dyk.dyy & 0x2) == 0)) {
              break label496;
            }
            paramParameters = mhB.bja();
            paramParameters.mhM = false;
            paramParameters.bjb();
          }
        }
      }
      label607:
      for (;;)
      {
        mhB.mhK = -1;
        y.i("MicroMsg.MMSightRecorderConfig", "autoConfig parameter byserver %s", new Object[] { mhB.toString() });
        return;
        if ((!com.tencent.mm.compatible.util.d.gF(k)) || (eIy < 512) || (mhC < 1725.0D) || (Math.min(((Point)localObject1).x, ((Point)localObject1).y) < 1080)) {
          break label609;
        }
        localObject2 = mhB;
        ((o)localObject2).mhP = g.b(paramParameters, com.tencent.mm.plugin.mmsight.d.biC(), ((o)localObject2).mfr.width * 2, paramBoolean);
        if ((((o)localObject2).mhP != null) && (((o)localObject2).mhP.jkk != null)) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label609;
          }
          mhB.bjc().mhM = true;
          i = 1;
          break;
        }
        bool = false;
        break label267;
        mhB.mhL = false;
        break label274;
        label496:
        if ((i == 0) && (com.tencent.mm.compatible.util.d.gF(j)) && (eIy >= 512) && (mhC >= 1725.0D) && (Math.min(((Point)localObject1).x, ((Point)localObject1).y) >= 720))
        {
          localObject1 = mhB;
          ((o)localObject1).mhP = g.b(paramParameters, com.tencent.mm.plugin.mmsight.d.biC(), 720, paramBoolean);
          if ((((o)localObject1).mhP != null) && (((o)localObject1).mhP.jkk != null)) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label607;
            }
            mhB.bja().mhM = true;
            break;
          }
        }
      }
      label609:
      i = 0;
    }
  }
  
  public static void a(g.b paramb)
  {
    if (paramb.jkk == null)
    {
      y.i("MicroMsg.MMSightRecorderConfig", "checkMore start %s", new Object[] { paramb.toString() });
      paramb.jkk = paramb.mhs;
      paramb.mhq = paramb.mht;
      paramb.mhr = paramb.mhu;
      if (Math.min(paramb.mhq.y, paramb.mhq.x) >= mhB.mfr.width + 16)
      {
        mhB.bjb();
        mhB.mhM = false;
        mhB.mhL = false;
        y.i("MicroMsg.MMSightRecorderConfig", "checkMore out %s", new Object[] { paramb.toString() });
      }
    }
  }
  
  public static void biT()
  {
    y.i("MicroMsg.MMSightRecorderConfig", "initSimple");
    o localo = new o();
    mhB = localo;
    localo.mhL = false;
    mhB.mhM = false;
    if (com.tencent.mm.compatible.util.d.gF(19))
    {
      mhB.dys = 2;
      return;
    }
    mhB.dys = 1;
  }
  
  public static void c(VideoTransPara paramVideoTransPara)
  {
    boolean bool2 = true;
    mhz = false;
    mhA = false;
    eIy = ((ActivityManager)ae.getContext().getSystemService("activity")).getLargeMemoryClass();
    mhC = com.tencent.mm.plugin.mmsight.d.dM(ae.getContext());
    Object localObject = bs.cwc();
    int k = bk.getInt(CaptureMMProxy.getInstance().getDynamicConfig("SightMediaCodecMinApiLevel"), 19);
    y.i("MicroMsg.MMSightRecorderConfig", "MXM_DynaCfg_AV_Item_Key_SightMediaCodecMinApiLevel: %s", new Object[] { Integer.valueOf(k) });
    if (CaptureMMProxy.getInstance() != null) {
      q.fa(CaptureMMProxy.getInstance().getDeviceInfoConfig());
    }
    y.i("MicroMsg.MMSightRecorderConfig", "init large memory class: %sMB, totalMemory: %sGB  fingerprint: %s mmSightRecorderInfo: %s", new Object[] { Integer.valueOf(eIy), Double.valueOf(mhC), localObject, q.dyk });
    int j;
    int i;
    if (CaptureMMProxy.getInstance() != null)
    {
      j = CaptureMMProxy.getInstance().getInt(ac.a.utS, -1);
      i = CaptureMMProxy.getInstance().getInt(ac.a.utV, 1);
    }
    for (;;)
    {
      localObject = o.a(j, paramVideoTransPara);
      mhB = (o)localObject;
      if (localObject != null)
      {
        Resources localResources;
        if (i == 1)
        {
          mhB.mhN = true;
          mhz = true;
          localObject = ae.getContext();
          localResources = ae.getResources();
          i = a.a.i_want_you_know;
          if (mhB != null) {
            break label250;
          }
        }
        label250:
        for (paramVideoTransPara = "";; paramVideoTransPara = Integer.valueOf(mhB.mhK))
        {
          s.makeText((Context)localObject, localResources.getString(i, new Object[] { paramVideoTransPara }), 1).show();
          return;
          mhB.mhN = false;
          break;
        }
      }
      j = q.dyk.dyz;
      y.i("MicroMsg.MMSightRecorderConfig", "recorderOption: %s", new Object[] { Integer.valueOf(j) });
      if (j != -1) {
        mhB = o.a(j, paramVideoTransPara);
      }
      if (mhB != null)
      {
        if (i == 1) {}
        for (mhB.mhN = true;; mhB.mhN = false)
        {
          mhA = true;
          return;
        }
      }
      mhB = o.a(1, paramVideoTransPara);
      if (i == 1)
      {
        mhB.mhN = true;
        if (q.dyk.dys == -1) {
          break label450;
        }
        mhB.dys = q.dyk.dys;
        label377:
        if (q.dyk.dyv != -1)
        {
          if (q.dyk.dyv != 1) {
            break label477;
          }
          bool1 = true;
          mhy = bool1;
        }
        label400:
        if (q.dyk.dyt == -1) {
          break label489;
        }
        paramVideoTransPara = mhB;
        if (q.dyk.dyt != 1) {
          break label483;
        }
      }
      label450:
      label477:
      label483:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        paramVideoTransPara.mhL = bool1;
        return;
        mhB.mhN = false;
        break;
        if (com.tencent.mm.compatible.util.d.gF(k))
        {
          mhB.dys = 2;
          break label377;
        }
        mhB.dys = 1;
        break label377;
        bool1 = false;
        break label400;
      }
      label489:
      mhB.mhL = false;
      return;
      i = 1;
      j = -1;
    }
  }
  
  public static boolean f(Point paramPoint)
  {
    if (mhz)
    {
      Context localContext = ae.getContext();
      Resources localResources = ae.getResources();
      int i = a.a.i_want_you_know;
      if (mhB == null) {}
      for (paramPoint = "";; paramPoint = Integer.valueOf(mhB.mhK))
      {
        s.makeText(localContext, localResources.getString(i, new Object[] { paramPoint }), 1).show();
        return false;
      }
    }
    y.i("MicroMsg.MMSightRecorderConfig", "checkMediaCodecHappy, deviceInfo recorderType: %s, recorderOption: %s, isUseRecorderOption: %s", new Object[] { Integer.valueOf(q.dyk.dys), Integer.valueOf(q.dyk.dyz), Boolean.valueOf(mhA) });
    if (mhA) {
      return false;
    }
    if (q.dyk.dys != -1) {
      return true;
    }
    if ((mhB != null) && (1 == mhB.dys)) {
      return true;
    }
    if (paramPoint == null) {
      return false;
    }
    if ((com.tencent.mm.plugin.mmsight.d.tU(paramPoint.x)) && (com.tencent.mm.plugin.mmsight.d.tU(paramPoint.y))) {
      return true;
    }
    if (mhB != null)
    {
      y.i("MicroMsg.MMSightRecorderConfig", "checkMediaCodecHappy not happy %s", new Object[] { paramPoint.toString() });
      mhB.dys = 1;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.j
 * JD-Core Version:    0.7.0.1
 */