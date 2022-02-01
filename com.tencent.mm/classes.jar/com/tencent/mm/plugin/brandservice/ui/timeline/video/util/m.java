package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.v;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.b;
import com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView;
import com.tencent.mm.plugin.brandservice.ui.widget.c;
import com.tencent.mm.plugin.brandservice.ui.widget.c.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.fu;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/KV17149;", "", "()V", "SPLITOR", "", "TAG", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "definitionAfter", "", "getDefinitionAfter", "()I", "setDefinitionAfter", "(I)V", "definitionBefore", "getDefinitionBefore", "setDefinitionBefore", "definitionOptions", "getDefinitionOptions", "()Ljava/lang/String;", "setDefinitionOptions", "(Ljava/lang/String;)V", "endPlayTime", "getEndPlayTime", "setEndPlayTime", "firstBuffering", "", "getFirstBuffering", "()Z", "setFirstBuffering", "(Z)V", "height", "getHeight", "setHeight", "isFans", "setFans", "playErrType", "getPlayErrType", "setPlayErrType", "realPlayTime", "getRealPlayTime", "setRealPlayTime", "stayTimeInPage", "getStayTimeInPage", "setStayTimeInPage", "videoView", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;", "getVideoView", "()Ljava/lang/ref/WeakReference;", "setVideoView", "(Ljava/lang/ref/WeakReference;)V", "width", "getWidth", "setWidth", "wifiTipsWordingType", "getWifiTipsWordingType", "setWifiTipsWordingType", "doReport", "", "eventType", "bufferingTime", "getPlayType", "playStatus", "init", "reportBuffering", "timeCost", "bufferType", "urlInfos", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/AppMsgVideoUrlInfo;", "Companion", "plugin-brandservice_release"})
public final class m
{
  private static WeakReference<m> oyg;
  public static final a oyh;
  private final String TAG = "MicroMsg.MPDataReportHelper";
  public int height;
  public b ovq;
  private final String oxV = ",";
  public int oxW;
  public int oxX;
  public int oxY;
  public String oxZ = "";
  public WeakReference<MPVideoView> oxf;
  public boolean oya;
  public boolean oyb = true;
  public int oyc;
  public int oyd;
  public int oye = 1;
  private String oyf = "";
  public int width;
  
  static
  {
    AppMethodBeat.i(179021);
    oyh = new a((byte)0);
    AppMethodBeat.o(179021);
  }
  
  public static int Al(int paramInt)
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
  
  public static final void Am(int paramInt)
  {
    AppMethodBeat.i(179022);
    a.Am(paramInt);
    AppMethodBeat.o(179022);
  }
  
  private final MPVideoView bSp()
  {
    AppMethodBeat.i(7324);
    if (this.oxf == null)
    {
      AppMethodBeat.o(7324);
      return null;
    }
    Object localObject = this.oxf;
    if (localObject != null)
    {
      localObject = (MPVideoView)((WeakReference)localObject).get();
      AppMethodBeat.o(7324);
      return localObject;
    }
    AppMethodBeat.o(7324);
    return null;
  }
  
  public final void J(LinkedList<fu> paramLinkedList)
  {
    AppMethodBeat.i(7321);
    p.h(paramLinkedList, "urlInfos");
    StringBuilder localStringBuilder = new StringBuilder();
    paramLinkedList = paramLinkedList.iterator();
    if (paramLinkedList.hasNext())
    {
      fu localfu = (fu)paramLinkedList.next();
      if (((CharSequence)localStringBuilder).length() > 0) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          localStringBuilder.append(";");
        }
        localStringBuilder.append(localfu.FQz);
        break;
      }
    }
    paramLinkedList = localStringBuilder.toString();
    p.g(paramLinkedList, "sb.toString()");
    this.oyf = paramLinkedList;
    AppMethodBeat.o(7321);
  }
  
  public final void eS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(7322);
    if ((paramInt1 < 0) || (paramInt1 > 3600000L))
    {
      AppMethodBeat.o(7322);
      return;
    }
    ed(paramInt2, paramInt1);
    if (this.oyb)
    {
      this.oyb = false;
      ed(16, paramInt1);
      ae.v(this.TAG, "[KEY_TIME] reportBuffering firstBuffering = ".concat(String.valueOf(paramInt1)));
      AppMethodBeat.o(7322);
      return;
    }
    ed(17, paramInt1);
    AppMethodBeat.o(7322);
  }
  
  public final void ed(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(7323);
    int j = com.tencent.mm.ah.m.abf();
    int i = j;
    if (j == 100) {
      i = -1;
    }
    if ((this.oxW < 0) || (this.oxW > 86400000L)) {
      this.oxW = 0;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(i);
    localStringBuilder.append(this.oxV);
    Object localObject1 = this.ovq;
    if (localObject1 == null) {
      p.bdF("controller");
    }
    localStringBuilder.append(((b)localObject1).Wa());
    localStringBuilder.append(this.oxV);
    localObject1 = this.ovq;
    if (localObject1 == null) {
      p.bdF("controller");
    }
    localStringBuilder.append(((b)localObject1).hGH);
    localStringBuilder.append(this.oxV);
    localObject1 = this.ovq;
    if (localObject1 == null) {
      p.bdF("controller");
    }
    localStringBuilder.append(((b)localObject1).idx);
    localStringBuilder.append(this.oxV);
    localObject1 = this.ovq;
    if (localObject1 == null) {
      p.bdF("controller");
    }
    localStringBuilder.append(((b)localObject1).oua);
    localStringBuilder.append(this.oxV);
    localObject1 = this.ovq;
    if (localObject1 == null) {
      p.bdF("controller");
    }
    localStringBuilder.append(((b)localObject1).otX);
    localStringBuilder.append(this.oxV);
    localObject1 = this.ovq;
    if (localObject1 == null) {
      p.bdF("controller");
    }
    localStringBuilder.append(((b)localObject1).hCa);
    localStringBuilder.append(this.oxV);
    localObject1 = this.ovq;
    if (localObject1 == null) {
      p.bdF("controller");
    }
    localStringBuilder.append(((b)localObject1).bSi().hGi);
    localStringBuilder.append(this.oxV);
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(this.oxV);
    localStringBuilder.append((int)(System.currentTimeMillis() / 1000L));
    localStringBuilder.append(this.oxV);
    localStringBuilder.append(this.oxW);
    localStringBuilder.append(this.oxV);
    localStringBuilder.append(this.oxX);
    localStringBuilder.append(this.oxV);
    localStringBuilder.append(this.oxY);
    localStringBuilder.append(this.oxV);
    localObject1 = this.ovq;
    if (localObject1 == null) {
      p.bdF("controller");
    }
    localStringBuilder.append(((b)localObject1).scene);
    localStringBuilder.append(this.oxV);
    localObject1 = this.ovq;
    if (localObject1 == null) {
      p.bdF("controller");
    }
    localStringBuilder.append(((b)localObject1).otZ);
    localStringBuilder.append(this.oxV);
    localStringBuilder.append(this.oxZ);
    localStringBuilder.append(this.oxV);
    if (this.oya)
    {
      i = 1;
      localStringBuilder.append(i);
      localStringBuilder.append(this.oxV);
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(this.oxV);
      localStringBuilder.append(this.height);
      localStringBuilder.append(this.oxV);
      localStringBuilder.append(this.width);
      localStringBuilder.append(this.oxV);
      localStringBuilder.append(0);
      localStringBuilder.append(this.oxV);
      localStringBuilder.append(0);
      localStringBuilder.append(this.oxV);
      localStringBuilder.append(this.oxV);
      localStringBuilder.append(2);
      localStringBuilder.append(this.oxV);
      localStringBuilder.append(0);
      localStringBuilder.append(this.oxV);
      localStringBuilder.append(this.oyc);
      localStringBuilder.append(this.oxV);
      if (paramInt1 != 22) {
        break label1480;
      }
      i = this.oyd;
      label722:
      localStringBuilder.append(i);
      localStringBuilder.append(this.oxV);
      if (bSp() == null) {
        break label1485;
      }
      localObject1 = bSp();
      if (localObject1 == null) {
        p.gkB();
      }
      if (!((MPVideoView)localObject1).bnx()) {
        break label1485;
      }
      i = 1;
      label770:
      localStringBuilder.append(i);
      localStringBuilder.append(this.oxV);
      localStringBuilder.append(this.oxV);
      localObject1 = bSp();
      if (localObject1 == null) {
        break label1490;
      }
      localObject1 = Integer.valueOf(((MPVideoView)localObject1).getCurrPosMs());
      label818:
      localStringBuilder.append(localObject1);
      localStringBuilder.append(this.oxV);
      if ((paramInt1 != 22) && (paramInt1 != 21)) {
        break label1496;
      }
      localObject1 = this.oyf;
      label854:
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(this.oxV);
      localStringBuilder.append(0);
      localStringBuilder.append(this.oxV);
      localStringBuilder.append(this.oxV);
      localStringBuilder.append(0);
      localStringBuilder.append(this.oxV);
      localStringBuilder.append(0);
      localStringBuilder.append(this.oxV);
      localStringBuilder.append(0);
      localStringBuilder.append(this.oxV);
      if (paramInt1 != 14) {
        break label1503;
      }
      localObject1 = this.ovq;
      if (localObject1 == null) {
        p.bdF("controller");
      }
      i = ((b)localObject1).bSn();
      label978:
      localStringBuilder.append(i);
      localStringBuilder.append(this.oxV);
      if (paramInt1 != 14) {
        break label1508;
      }
      i = this.oye;
      label1006:
      localStringBuilder.append(i);
      localStringBuilder.append(this.oxV);
      localObject1 = this.ovq;
      if (localObject1 == null) {
        p.bdF("controller");
      }
      localStringBuilder.append(((b)localObject1).hBV);
      localStringBuilder.append(this.oxV);
      localObject1 = this.ovq;
      if (localObject1 == null) {
        p.bdF("controller");
      }
      localStringBuilder.append(((b)localObject1).ouc);
      localStringBuilder.append(this.oxV);
      localObject1 = this.ovq;
      if (localObject1 == null) {
        p.bdF("controller");
      }
      localStringBuilder.append(((b)localObject1).oud);
      localStringBuilder.append(this.oxV);
      localStringBuilder.append(this.oxV);
      localObject1 = a.owG;
      if (!a.bTk()) {
        break label1513;
      }
      i = 1;
      label1157:
      localStringBuilder.append(i);
      localStringBuilder.append(this.oxV);
      if (paramInt1 != 32) {
        break label1518;
      }
    }
    for (;;)
    {
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(this.oxV);
      if (paramInt1 == 43)
      {
        localObject1 = c.oAe;
        localObject1 = c.bTK();
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
      localStringBuilder.append(this.oxV);
      if (paramInt1 == 43)
      {
        localObject1 = c.oAe;
        localObject1 = c.bTL();
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
      Object localObject2 = this.ovq;
      if (localObject2 == null) {
        p.bdF("controller");
      }
      localObject2 = ((b)localObject2).ouc;
      b localb = this.ovq;
      if (localb == null) {
        p.bdF("controller");
      }
      ae.d((String)localObject1, "alvinluo reportKV17149 channelSessionId: %s, landingPageType: %d", new Object[] { localObject2, Integer.valueOf(localb.oud) });
      localObject1 = localStringBuilder.toString();
      p.g(localObject1, "sb.toString()");
      ae.d(this.TAG, "eventType: " + paramInt1 + " reportData: " + (String)localObject1);
      g.yxI.kvStat(17149, (String)localObject1);
      if (paramInt1 != 3) {
        break label1523;
      }
      localObject1 = this.ovq;
      if (localObject1 == null) {
        p.bdF("controller");
      }
      ((b)localObject1).otT.An(0);
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
      localObject1 = this.ovq;
      if (localObject1 == null) {
        p.bdF("controller");
      }
      ((b)localObject1).otT.An(1);
      AppMethodBeat.o(7323);
      return;
    }
    if (paramInt1 == 10)
    {
      localObject1 = this.ovq;
      if (localObject1 == null) {
        p.bdF("controller");
      }
      ((b)localObject1).otT.An(2);
    }
    AppMethodBeat.o(7323);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/KV17149$Companion;", "", "()V", "kv17149Ref", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/KV17149;", "getKv17149Ref", "()Ljava/lang/ref/WeakReference;", "setKv17149Ref", "(Ljava/lang/ref/WeakReference;)V", "quickReport", "", "eventType", "", "bufferingTime", "plugin-brandservice_release"})
  public static final class a
  {
    public static void Am(int paramInt)
    {
      AppMethodBeat.i(179020);
      Object localObject = m.bTq();
      if (localObject != null)
      {
        localObject = (m)((WeakReference)localObject).get();
        if (localObject != null)
        {
          ((m)localObject).ed(paramInt, 0);
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