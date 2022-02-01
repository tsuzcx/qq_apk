package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.v;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.b;
import com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView;
import com.tencent.mm.plugin.brandservice.ui.widget.c;
import com.tencent.mm.plugin.brandservice.ui.widget.c.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.gh;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/KV17149;", "", "()V", "SPLITOR", "", "TAG", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "definitionAfter", "", "getDefinitionAfter", "()I", "setDefinitionAfter", "(I)V", "definitionBefore", "getDefinitionBefore", "setDefinitionBefore", "definitionOptions", "getDefinitionOptions", "()Ljava/lang/String;", "setDefinitionOptions", "(Ljava/lang/String;)V", "endPlayTime", "getEndPlayTime", "setEndPlayTime", "firstBuffering", "", "getFirstBuffering", "()Z", "setFirstBuffering", "(Z)V", "height", "getHeight", "setHeight", "isFans", "setFans", "playErrType", "getPlayErrType", "setPlayErrType", "realPlayTime", "getRealPlayTime", "setRealPlayTime", "stayTimeInPage", "getStayTimeInPage", "setStayTimeInPage", "videoView", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;", "getVideoView", "()Ljava/lang/ref/WeakReference;", "setVideoView", "(Ljava/lang/ref/WeakReference;)V", "width", "getWidth", "setWidth", "wifiTipsWordingType", "getWifiTipsWordingType", "setWifiTipsWordingType", "doReport", "", "eventType", "bufferingTime", "getPlayType", "playStatus", "init", "reportBuffering", "timeCost", "bufferType", "urlInfos", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/AppMsgVideoUrlInfo;", "Companion", "plugin-brandservice_release"})
public final class m
{
  private static WeakReference<m> pLK;
  public static final a pLL;
  private final String TAG = "MicroMsg.MPDataReportHelper";
  public int height;
  public b pIL;
  public WeakReference<MPVideoView> pKJ;
  public int pLA;
  public int pLB;
  public int pLC;
  public String pLD = "";
  public boolean pLE;
  public boolean pLF = true;
  public int pLG;
  public int pLH;
  public int pLI = 1;
  private String pLJ = "";
  private final String pLz = ",";
  public int width;
  
  static
  {
    AppMethodBeat.i(179021);
    pLL = new a((byte)0);
    AppMethodBeat.o(179021);
  }
  
  public static int DQ(int paramInt)
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
  
  public static final void DR(int paramInt)
  {
    AppMethodBeat.i(179022);
    a.DR(paramInt);
    AppMethodBeat.o(179022);
  }
  
  private final MPVideoView cpZ()
  {
    AppMethodBeat.i(7324);
    if (this.pKJ == null)
    {
      AppMethodBeat.o(7324);
      return null;
    }
    Object localObject = this.pKJ;
    if (localObject != null)
    {
      localObject = (MPVideoView)((WeakReference)localObject).get();
      AppMethodBeat.o(7324);
      return localObject;
    }
    AppMethodBeat.o(7324);
    return null;
  }
  
  public final void L(LinkedList<gh> paramLinkedList)
  {
    AppMethodBeat.i(7321);
    p.h(paramLinkedList, "urlInfos");
    StringBuilder localStringBuilder = new StringBuilder();
    paramLinkedList = paramLinkedList.iterator();
    if (paramLinkedList.hasNext())
    {
      gh localgh = (gh)paramLinkedList.next();
      if (((CharSequence)localStringBuilder).length() > 0) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          localStringBuilder.append(";");
        }
        localStringBuilder.append(localgh.KKg);
        break;
      }
    }
    paramLinkedList = localStringBuilder.toString();
    p.g(paramLinkedList, "sb.toString()");
    this.pLJ = paramLinkedList;
    AppMethodBeat.o(7321);
  }
  
  public final void er(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(7323);
    int j = com.tencent.mm.ag.m.ape();
    int i = j;
    if (j == 100) {
      i = -1;
    }
    if ((this.pLA < 0) || (this.pLA > 86400000L)) {
      this.pLA = 0;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(i);
    localStringBuilder.append(this.pLz);
    Object localObject1 = this.pIL;
    if (localObject1 == null) {
      p.btv("controller");
    }
    localStringBuilder.append(((b)localObject1).ajO());
    localStringBuilder.append(this.pLz);
    localObject1 = this.pIL;
    if (localObject1 == null) {
      p.btv("controller");
    }
    localStringBuilder.append(((b)localObject1).iAQ);
    localStringBuilder.append(this.pLz);
    localObject1 = this.pIL;
    if (localObject1 == null) {
      p.btv("controller");
    }
    localStringBuilder.append(((b)localObject1).idx);
    localStringBuilder.append(this.pLz);
    localObject1 = this.pIL;
    if (localObject1 == null) {
      p.btv("controller");
    }
    localStringBuilder.append(((b)localObject1).pHx);
    localStringBuilder.append(this.pLz);
    localObject1 = this.pIL;
    if (localObject1 == null) {
      p.btv("controller");
    }
    localStringBuilder.append(((b)localObject1).pHu);
    localStringBuilder.append(this.pLz);
    localObject1 = this.pIL;
    if (localObject1 == null) {
      p.btv("controller");
    }
    localStringBuilder.append(((b)localObject1).vid);
    localStringBuilder.append(this.pLz);
    localObject1 = this.pIL;
    if (localObject1 == null) {
      p.btv("controller");
    }
    localStringBuilder.append(((b)localObject1).cpS().iAs);
    localStringBuilder.append(this.pLz);
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(this.pLz);
    localStringBuilder.append((int)(System.currentTimeMillis() / 1000L));
    localStringBuilder.append(this.pLz);
    localStringBuilder.append(this.pLA);
    localStringBuilder.append(this.pLz);
    localStringBuilder.append(this.pLB);
    localStringBuilder.append(this.pLz);
    localStringBuilder.append(this.pLC);
    localStringBuilder.append(this.pLz);
    localObject1 = this.pIL;
    if (localObject1 == null) {
      p.btv("controller");
    }
    localStringBuilder.append(((b)localObject1).scene);
    localStringBuilder.append(this.pLz);
    localObject1 = this.pIL;
    if (localObject1 == null) {
      p.btv("controller");
    }
    localStringBuilder.append(((b)localObject1).pHw);
    localStringBuilder.append(this.pLz);
    localStringBuilder.append(this.pLD);
    localStringBuilder.append(this.pLz);
    if (this.pLE)
    {
      i = 1;
      localStringBuilder.append(i);
      localStringBuilder.append(this.pLz);
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(this.pLz);
      localStringBuilder.append(this.height);
      localStringBuilder.append(this.pLz);
      localStringBuilder.append(this.width);
      localStringBuilder.append(this.pLz);
      localStringBuilder.append(0);
      localStringBuilder.append(this.pLz);
      localStringBuilder.append(0);
      localStringBuilder.append(this.pLz);
      localStringBuilder.append(this.pLz);
      localStringBuilder.append(2);
      localStringBuilder.append(this.pLz);
      localStringBuilder.append(0);
      localStringBuilder.append(this.pLz);
      localStringBuilder.append(this.pLG);
      localStringBuilder.append(this.pLz);
      if (paramInt1 != 22) {
        break label1480;
      }
      i = this.pLH;
      label722:
      localStringBuilder.append(i);
      localStringBuilder.append(this.pLz);
      if (cpZ() == null) {
        break label1485;
      }
      localObject1 = cpZ();
      if (localObject1 == null) {
        p.hyc();
      }
      if (!((MPVideoView)localObject1).bJb()) {
        break label1485;
      }
      i = 1;
      label770:
      localStringBuilder.append(i);
      localStringBuilder.append(this.pLz);
      localStringBuilder.append(this.pLz);
      localObject1 = cpZ();
      if (localObject1 == null) {
        break label1490;
      }
      localObject1 = Integer.valueOf(((MPVideoView)localObject1).getCurrPosMs());
      label818:
      localStringBuilder.append(localObject1);
      localStringBuilder.append(this.pLz);
      if ((paramInt1 != 22) && (paramInt1 != 21)) {
        break label1496;
      }
      localObject1 = this.pLJ;
      label854:
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(this.pLz);
      localStringBuilder.append(0);
      localStringBuilder.append(this.pLz);
      localStringBuilder.append(this.pLz);
      localStringBuilder.append(0);
      localStringBuilder.append(this.pLz);
      localStringBuilder.append(0);
      localStringBuilder.append(this.pLz);
      localStringBuilder.append(0);
      localStringBuilder.append(this.pLz);
      if (paramInt1 != 14) {
        break label1503;
      }
      localObject1 = this.pIL;
      if (localObject1 == null) {
        p.btv("controller");
      }
      i = ((b)localObject1).cpX();
      label978:
      localStringBuilder.append(i);
      localStringBuilder.append(this.pLz);
      if (paramInt1 != 14) {
        break label1508;
      }
      i = this.pLI;
      label1006:
      localStringBuilder.append(i);
      localStringBuilder.append(this.pLz);
      localObject1 = this.pIL;
      if (localObject1 == null) {
        p.btv("controller");
      }
      localStringBuilder.append(((b)localObject1).iwc);
      localStringBuilder.append(this.pLz);
      localObject1 = this.pIL;
      if (localObject1 == null) {
        p.btv("controller");
      }
      localStringBuilder.append(((b)localObject1).pHz);
      localStringBuilder.append(this.pLz);
      localObject1 = this.pIL;
      if (localObject1 == null) {
        p.btv("controller");
      }
      localStringBuilder.append(((b)localObject1).pHA);
      localStringBuilder.append(this.pLz);
      localStringBuilder.append(this.pLz);
      localObject1 = a.pKk;
      if (!a.cqV()) {
        break label1513;
      }
      i = 1;
      label1157:
      localStringBuilder.append(i);
      localStringBuilder.append(this.pLz);
      if (paramInt1 != 32) {
        break label1518;
      }
    }
    for (;;)
    {
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(this.pLz);
      if (paramInt1 == 43)
      {
        localObject1 = c.pNP;
        localObject1 = c.crx();
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
      localStringBuilder.append(this.pLz);
      if (paramInt1 == 43)
      {
        localObject1 = c.pNP;
        localObject1 = c.cry();
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
      Object localObject2 = this.pIL;
      if (localObject2 == null) {
        p.btv("controller");
      }
      localObject2 = ((b)localObject2).pHz;
      b localb = this.pIL;
      if (localb == null) {
        p.btv("controller");
      }
      Log.d((String)localObject1, "alvinluo reportKV17149 channelSessionId: %s, landingPageType: %d", new Object[] { localObject2, Integer.valueOf(localb.pHA) });
      localObject1 = localStringBuilder.toString();
      p.g(localObject1, "sb.toString()");
      Log.d(this.TAG, "eventType: " + paramInt1 + " reportData: " + (String)localObject1);
      h.CyF.kvStat(17149, (String)localObject1);
      if (paramInt1 != 3) {
        break label1523;
      }
      localObject1 = this.pIL;
      if (localObject1 == null) {
        p.btv("controller");
      }
      ((b)localObject1).pHq.DS(0);
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
      localObject1 = this.pIL;
      if (localObject1 == null) {
        p.btv("controller");
      }
      ((b)localObject1).pHq.DS(1);
      AppMethodBeat.o(7323);
      return;
    }
    if (paramInt1 == 10)
    {
      localObject1 = this.pIL;
      if (localObject1 == null) {
        p.btv("controller");
      }
      ((b)localObject1).pHq.DS(2);
    }
    AppMethodBeat.o(7323);
  }
  
  public final void ff(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(7322);
    if ((paramInt1 < 0) || (paramInt1 > 3600000L))
    {
      AppMethodBeat.o(7322);
      return;
    }
    er(paramInt2, paramInt1);
    if (this.pLF)
    {
      this.pLF = false;
      er(16, paramInt1);
      Log.v(this.TAG, "[KEY_TIME] reportBuffering firstBuffering = ".concat(String.valueOf(paramInt1)));
      AppMethodBeat.o(7322);
      return;
    }
    er(17, paramInt1);
    AppMethodBeat.o(7322);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/KV17149$Companion;", "", "()V", "kv17149Ref", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/KV17149;", "getKv17149Ref", "()Ljava/lang/ref/WeakReference;", "setKv17149Ref", "(Ljava/lang/ref/WeakReference;)V", "quickReport", "", "eventType", "", "bufferingTime", "plugin-brandservice_release"})
  public static final class a
  {
    public static void DR(int paramInt)
    {
      AppMethodBeat.i(179020);
      Object localObject = m.crb();
      if (localObject != null)
      {
        localObject = (m)((WeakReference)localObject).get();
        if (localObject != null)
        {
          ((m)localObject).er(paramInt, 0);
          AppMethodBeat.o(179020);
          return;
        }
      }
      AppMethodBeat.o(179020);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m
 * JD-Core Version:    0.7.0.1
 */