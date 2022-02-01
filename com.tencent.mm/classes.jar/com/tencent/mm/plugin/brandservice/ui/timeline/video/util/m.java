package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.v;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.b;
import com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView;
import com.tencent.mm.plugin.brandservice.ui.widget.c;
import com.tencent.mm.plugin.brandservice.ui.widget.c.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.fp;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/KV17149;", "", "()V", "SPLITOR", "", "TAG", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "definitionAfter", "", "getDefinitionAfter", "()I", "setDefinitionAfter", "(I)V", "definitionBefore", "getDefinitionBefore", "setDefinitionBefore", "definitionOptions", "getDefinitionOptions", "()Ljava/lang/String;", "setDefinitionOptions", "(Ljava/lang/String;)V", "endPlayTime", "getEndPlayTime", "setEndPlayTime", "firstBuffering", "", "getFirstBuffering", "()Z", "setFirstBuffering", "(Z)V", "height", "getHeight", "setHeight", "isFans", "setFans", "playErrType", "getPlayErrType", "setPlayErrType", "realPlayTime", "getRealPlayTime", "setRealPlayTime", "stayTimeInPage", "getStayTimeInPage", "setStayTimeInPage", "videoView", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;", "getVideoView", "()Ljava/lang/ref/WeakReference;", "setVideoView", "(Ljava/lang/ref/WeakReference;)V", "width", "getWidth", "setWidth", "wifiTipsWordingType", "getWifiTipsWordingType", "setWifiTipsWordingType", "doReport", "", "eventType", "bufferingTime", "getPlayType", "playStatus", "init", "reportBuffering", "timeCost", "bufferType", "urlInfos", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/AppMsgVideoUrlInfo;", "Companion", "plugin-brandservice_release"})
public final class m
{
  private static WeakReference<m> nPe;
  public static final a nPf;
  private final String TAG = "MicroMsg.MPDataReportHelper";
  public int height;
  public b nMS;
  private final String nOT = ",";
  public int nOU;
  public int nOV;
  public int nOW;
  public String nOX = "";
  public boolean nOY;
  public boolean nOZ = true;
  public WeakReference<MPVideoView> nOd;
  public int nPa;
  public int nPb;
  public int nPc = 1;
  private String nPd = "";
  public int width;
  
  static
  {
    AppMethodBeat.i(179021);
    nPf = new a((byte)0);
    AppMethodBeat.o(179021);
  }
  
  private final MPVideoView bMO()
  {
    AppMethodBeat.i(7324);
    if (this.nOd == null)
    {
      AppMethodBeat.o(7324);
      return null;
    }
    Object localObject = this.nOd;
    if (localObject != null)
    {
      localObject = (MPVideoView)((WeakReference)localObject).get();
      AppMethodBeat.o(7324);
      return localObject;
    }
    AppMethodBeat.o(7324);
    return null;
  }
  
  public static int zs(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    case 2: 
    default: 
      return 4;
    case 0: 
      return 3;
    case 3: 
      return 9;
    }
    return 10;
  }
  
  public static final void zt(int paramInt)
  {
    AppMethodBeat.i(179022);
    a.zt(paramInt);
    AppMethodBeat.o(179022);
  }
  
  public final void J(LinkedList<fp> paramLinkedList)
  {
    AppMethodBeat.i(7321);
    k.h(paramLinkedList, "urlInfos");
    StringBuilder localStringBuilder = new StringBuilder();
    paramLinkedList = paramLinkedList.iterator();
    if (paramLinkedList.hasNext())
    {
      fp localfp = (fp)paramLinkedList.next();
      if (((CharSequence)localStringBuilder).length() > 0) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          localStringBuilder.append(";");
        }
        localStringBuilder.append(localfp.DSI);
        break;
      }
    }
    paramLinkedList = localStringBuilder.toString();
    k.g(paramLinkedList, "sb.toString()");
    this.nPd = paramLinkedList;
    AppMethodBeat.o(7321);
  }
  
  public final void eN(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(7322);
    if ((paramInt1 < 0) || (paramInt1 > 3600000L))
    {
      AppMethodBeat.o(7322);
      return;
    }
    eb(paramInt2, paramInt1);
    if (this.nOZ)
    {
      this.nOZ = false;
      eb(16, paramInt1);
      ac.v(this.TAG, "[KEY_TIME] reportBuffering firstBuffering = ".concat(String.valueOf(paramInt1)));
      AppMethodBeat.o(7322);
      return;
    }
    eb(17, paramInt1);
    AppMethodBeat.o(7322);
  }
  
  public final void eb(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(7323);
    int j = com.tencent.mm.ah.m.Yu();
    int i = j;
    if (j == 100) {
      i = -1;
    }
    if ((this.nOU < 0) || (this.nOU > 86400000L)) {
      this.nOU = 0;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(i);
    localStringBuilder.append(this.nOT);
    Object localObject1 = this.nMS;
    if (localObject1 == null) {
      k.aVY("controller");
    }
    localStringBuilder.append(((b)localObject1).TC());
    localStringBuilder.append(this.nOT);
    localObject1 = this.nMS;
    if (localObject1 == null) {
      k.aVY("controller");
    }
    localStringBuilder.append(((b)localObject1).hlF);
    localStringBuilder.append(this.nOT);
    localObject1 = this.nMS;
    if (localObject1 == null) {
      k.aVY("controller");
    }
    localStringBuilder.append(((b)localObject1).idx);
    localStringBuilder.append(this.nOT);
    localObject1 = this.nMS;
    if (localObject1 == null) {
      k.aVY("controller");
    }
    localStringBuilder.append(((b)localObject1).nLD);
    localStringBuilder.append(this.nOT);
    localObject1 = this.nMS;
    if (localObject1 == null) {
      k.aVY("controller");
    }
    localStringBuilder.append(((b)localObject1).nLA);
    localStringBuilder.append(this.nOT);
    localObject1 = this.nMS;
    if (localObject1 == null) {
      k.aVY("controller");
    }
    localStringBuilder.append(((b)localObject1).hhd);
    localStringBuilder.append(this.nOT);
    localObject1 = this.nMS;
    if (localObject1 == null) {
      k.aVY("controller");
    }
    localStringBuilder.append(((b)localObject1).bMH().hlh);
    localStringBuilder.append(this.nOT);
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(this.nOT);
    localStringBuilder.append((int)(System.currentTimeMillis() / 1000L));
    localStringBuilder.append(this.nOT);
    localStringBuilder.append(this.nOU);
    localStringBuilder.append(this.nOT);
    localStringBuilder.append(this.nOV);
    localStringBuilder.append(this.nOT);
    localStringBuilder.append(this.nOW);
    localStringBuilder.append(this.nOT);
    localObject1 = this.nMS;
    if (localObject1 == null) {
      k.aVY("controller");
    }
    localStringBuilder.append(((b)localObject1).scene);
    localStringBuilder.append(this.nOT);
    localObject1 = this.nMS;
    if (localObject1 == null) {
      k.aVY("controller");
    }
    localStringBuilder.append(((b)localObject1).nLC);
    localStringBuilder.append(this.nOT);
    localStringBuilder.append(this.nOX);
    localStringBuilder.append(this.nOT);
    if (this.nOY)
    {
      i = 1;
      localStringBuilder.append(i);
      localStringBuilder.append(this.nOT);
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(this.nOT);
      localStringBuilder.append(this.height);
      localStringBuilder.append(this.nOT);
      localStringBuilder.append(this.width);
      localStringBuilder.append(this.nOT);
      localStringBuilder.append(0);
      localStringBuilder.append(this.nOT);
      localStringBuilder.append(0);
      localStringBuilder.append(this.nOT);
      localStringBuilder.append(this.nOT);
      localStringBuilder.append(2);
      localStringBuilder.append(this.nOT);
      localStringBuilder.append(0);
      localStringBuilder.append(this.nOT);
      localStringBuilder.append(this.nPa);
      localStringBuilder.append(this.nOT);
      if (paramInt1 != 22) {
        break label1480;
      }
      i = this.nPb;
      label722:
      localStringBuilder.append(i);
      localStringBuilder.append(this.nOT);
      if (bMO() == null) {
        break label1485;
      }
      localObject1 = bMO();
      if (localObject1 == null) {
        k.fOy();
      }
      if (!((MPVideoView)localObject1).bjb()) {
        break label1485;
      }
      i = 1;
      label770:
      localStringBuilder.append(i);
      localStringBuilder.append(this.nOT);
      localStringBuilder.append(this.nOT);
      localObject1 = bMO();
      if (localObject1 == null) {
        break label1490;
      }
      localObject1 = Integer.valueOf(((MPVideoView)localObject1).getCurrPosMs());
      label818:
      localStringBuilder.append(localObject1);
      localStringBuilder.append(this.nOT);
      if ((paramInt1 != 22) && (paramInt1 != 21)) {
        break label1496;
      }
      localObject1 = this.nPd;
      label854:
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(this.nOT);
      localStringBuilder.append(0);
      localStringBuilder.append(this.nOT);
      localStringBuilder.append(this.nOT);
      localStringBuilder.append(0);
      localStringBuilder.append(this.nOT);
      localStringBuilder.append(0);
      localStringBuilder.append(this.nOT);
      localStringBuilder.append(0);
      localStringBuilder.append(this.nOT);
      if (paramInt1 != 14) {
        break label1503;
      }
      localObject1 = this.nMS;
      if (localObject1 == null) {
        k.aVY("controller");
      }
      i = ((b)localObject1).bMM();
      label978:
      localStringBuilder.append(i);
      localStringBuilder.append(this.nOT);
      if (paramInt1 != 14) {
        break label1508;
      }
      i = this.nPc;
      label1006:
      localStringBuilder.append(i);
      localStringBuilder.append(this.nOT);
      localObject1 = this.nMS;
      if (localObject1 == null) {
        k.aVY("controller");
      }
      localStringBuilder.append(((b)localObject1).hgY);
      localStringBuilder.append(this.nOT);
      localObject1 = this.nMS;
      if (localObject1 == null) {
        k.aVY("controller");
      }
      localStringBuilder.append(((b)localObject1).nLF);
      localStringBuilder.append(this.nOT);
      localObject1 = this.nMS;
      if (localObject1 == null) {
        k.aVY("controller");
      }
      localStringBuilder.append(((b)localObject1).nLG);
      localStringBuilder.append(this.nOT);
      localStringBuilder.append(this.nOT);
      localObject1 = a.nNE;
      if (!a.bNy()) {
        break label1513;
      }
      i = 1;
      label1157:
      localStringBuilder.append(i);
      localStringBuilder.append(this.nOT);
      if (paramInt1 != 32) {
        break label1518;
      }
    }
    for (;;)
    {
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(this.nOT);
      if (paramInt1 == 43)
      {
        localObject1 = c.nQW;
        localObject1 = c.bNW();
        if (localObject1 != null)
        {
          localObject2 = ((c.a)localObject1).desc;
          localObject1 = localObject2;
          if (localObject2 != null) {
            break label1238;
          }
        }
      }
      localObject1 = "";
      label1238:
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(this.nOT);
      if (paramInt1 == 43)
      {
        localObject1 = c.nQW;
        localObject1 = c.bNX();
        if (localObject1 != null)
        {
          localObject2 = ((c.a)localObject1).desc;
          localObject1 = localObject2;
          if (localObject2 != null) {
            break label1297;
          }
        }
      }
      localObject1 = "";
      label1297:
      localStringBuilder.append((String)localObject1);
      localObject1 = this.TAG;
      Object localObject2 = this.nMS;
      if (localObject2 == null) {
        k.aVY("controller");
      }
      localObject2 = ((b)localObject2).nLF;
      b localb = this.nMS;
      if (localb == null) {
        k.aVY("controller");
      }
      ac.d((String)localObject1, "alvinluo reportKV17149 channelSessionId: %s, landingPageType: %d", new Object[] { localObject2, Integer.valueOf(localb.nLG) });
      localObject1 = localStringBuilder.toString();
      k.g(localObject1, "sb.toString()");
      ac.d(this.TAG, "eventType: " + paramInt1 + " reportData: " + (String)localObject1);
      h.wUl.kvStat(17149, (String)localObject1);
      if (paramInt1 != 3) {
        break label1523;
      }
      localObject1 = this.nMS;
      if (localObject1 == null) {
        k.aVY("controller");
      }
      ((b)localObject1).nLw.zu(0);
      AppMethodBeat.o(7323);
      return;
      i = 0;
      break;
      label1480:
      i = 0;
      break label722;
      label1485:
      i = 2;
      break label770;
      label1490:
      localObject1 = null;
      break label818;
      label1496:
      localObject1 = "";
      break label854;
      label1503:
      i = 0;
      break label978;
      label1508:
      i = 0;
      break label1006;
      label1513:
      i = 0;
      break label1157;
      label1518:
      paramInt2 = 0;
    }
    label1523:
    if (paramInt1 == 4)
    {
      localObject1 = this.nMS;
      if (localObject1 == null) {
        k.aVY("controller");
      }
      ((b)localObject1).nLw.zu(1);
      AppMethodBeat.o(7323);
      return;
    }
    if (paramInt1 == 10)
    {
      localObject1 = this.nMS;
      if (localObject1 == null) {
        k.aVY("controller");
      }
      ((b)localObject1).nLw.zu(2);
    }
    AppMethodBeat.o(7323);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/KV17149$Companion;", "", "()V", "kv17149Ref", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/KV17149;", "getKv17149Ref", "()Ljava/lang/ref/WeakReference;", "setKv17149Ref", "(Ljava/lang/ref/WeakReference;)V", "quickReport", "", "eventType", "", "bufferingTime", "plugin-brandservice_release"})
  public static final class a
  {
    public static void zt(int paramInt)
    {
      AppMethodBeat.i(179020);
      Object localObject = m.bNE();
      if (localObject != null)
      {
        localObject = (m)((WeakReference)localObject).get();
        if (localObject != null)
        {
          ((m)localObject).eb(paramInt, 0);
          AppMethodBeat.o(179020);
          return;
        }
      }
      AppMethodBeat.o(179020);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m
 * JD-Core Version:    0.7.0.1
 */