package com.tencent.mm.plugin.appbrand.appcache.predownload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b;
import com.tencent.mm.am.b.a;
import com.tencent.mm.am.c.a;
import com.tencent.mm.autogen.mmdata.rpt.tq;
import com.tencent.mm.cp.g;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.ac;
import com.tencent.mm.protocal.protobuf.efz;
import com.tencent.mm.protocal.protobuf.ega;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.flb;
import com.tencent.mm.protocal.protobuf.flc;
import com.tencent.mm.protocal.protobuf.gmp;
import com.tencent.mm.protocal.protobuf.gmq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.h.d;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/CgiPreDownloadCode;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/PreDownloadCodeResp;", "username", "", "path", "scene", "", "appId", "appType", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;I)V", "(Ljava/lang/String;Ljava/lang/String;I)V", "FUNC_ID", "getFUNC_ID", "()I", "TAG", "getTAG", "()Ljava/lang/String;", "URL", "getURL", "getAppId", "setAppId", "(Ljava/lang/String;)V", "getAppType", "setAppType", "(I)V", "endTime", "", "getEndTime", "()J", "setEndTime", "(J)V", "getPath", "getScene", "startTime", "getStartTime", "setStartTime", "getUsername", "wxaAttrStorage", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttrStorage;", "getWxaAttrStorage", "()Lcom/tencent/mm/plugin/appbrand/config/WxaAttrStorage;", "createSingleReqInfo", "Lcom/tencent/mm/protocal/protobuf/SyncVersionSingleReqInfo;", "execute", "", "splitDownloadURLCgi", "", "dealPluginOnly", "run", "Lcom/tencent/mm/wx/WxPipeline;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends b<ega>
{
  private final String TAG;
  private final String URL;
  private String appId;
  private int appType;
  private long endTime;
  private final String path;
  private final int qIM;
  private final int scene;
  private long startTime;
  private final String username;
  
  public c()
  {
    this(null, 0, 7);
  }
  
  private c(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(50192);
    this.username = paramString1;
    this.path = paramString2;
    this.scene = paramInt;
    this.TAG = "MicroMsg.AppBrand.CgiPreDownloadCode";
    this.URL = "/cgi-bin/mmbiz-bin/wxasync/wxaapp_predownloadcode";
    this.qIM = 1479;
    this.startTime = System.currentTimeMillis();
    AppMethodBeat.o(50192);
  }
  
  public c(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2)
  {
    this(paramString1, paramString2, paramInt1);
    this.appId = paramString3;
    this.appType = paramInt2;
  }
  
  private static final void a(c paramc, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(320471);
    s.u(paramc, "this$0");
    paramc.bFJ().a((d)d.LOGIC, new c..ExternalSyntheticLambda2(paramc, paramBoolean1, paramBoolean2));
    AppMethodBeat.o(320471);
  }
  
  private static final void a(c paramc, boolean paramBoolean1, boolean paramBoolean2, b.a parama)
  {
    AppMethodBeat.i(320458);
    s.u(paramc, "this$0");
    if (parama == null)
    {
      Log.i(paramc.TAG, "onCgiBack NULL result");
      AppMethodBeat.o(320458);
      return;
    }
    Log.i(paramc.TAG, "onCgiBack errType[" + parama.errType + "], errCode[" + parama.errCode + "], errMsg[" + parama.errMsg + "], splitDownloadURLCgi[" + paramBoolean1 + "], dealPluginOnly[" + paramBoolean2 + "], splitPluginCode:[true]");
    paramc.endTime = System.currentTimeMillis();
    if (com.tencent.mm.plugin.appbrand.s.a.d(parama))
    {
      LinkedList localLinkedList = new LinkedList();
      localObject1 = (ega)parama.ott;
      if (localObject1 != null)
      {
        localObject1 = ((ega)localObject1).ablu;
        if (localObject1 != null) {
          localLinkedList.add(localObject1);
        }
      }
      localObject1 = (ega)parama.ott;
      if (localObject1 != null)
      {
        localObject1 = ((ega)localObject1).ablv;
        if (localObject1 != null) {
          localLinkedList.addAll((Collection)localObject1);
        }
      }
      Log.i(paramc.TAG, "cmdList size:[" + localLinkedList.size() + ']');
      if (paramBoolean2)
      {
        localObject2 = localLinkedList.iterator();
        label334:
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (flc)((Iterator)localObject2).next();
          localObject1 = ((flc)localObject3).abLE;
          if (localObject1 == null) {
            localObject1 = null;
          }
          for (;;)
          {
            if ((localObject1 == null) || (((Integer)localObject1).intValue() == 6)) {
              break label334;
            }
            ((flc)localObject3).abLE.achP = null;
            break;
            localObject1 = ((gmp)localObject1).achP;
            if (localObject1 == null) {
              localObject1 = null;
            } else {
              localObject1 = Integer.valueOf(((gmq)localObject1).acic);
            }
          }
        }
      }
      Object localObject2 = new HashSet();
      Object localObject3 = localLinkedList.iterator();
      flc localflc;
      label475:
      while (((Iterator)localObject3).hasNext())
      {
        localflc = (flc)((Iterator)localObject3).next();
        localObject1 = localflc.abLE;
        if (localObject1 == null) {
          localObject1 = null;
        }
        for (;;)
        {
          if (localObject1 == null) {
            break label475;
          }
          switch (((Integer)localObject1).intValue())
          {
          default: 
            break;
          case 12: 
          case 13: 
            localObject1 = localflc.abyJ;
            if (localObject1 == null) {
              break;
            }
            ((HashSet)localObject2).add(localObject1);
            break;
            localObject1 = ((gmp)localObject1).achP;
            if (localObject1 == null) {
              localObject1 = null;
            } else {
              localObject1 = Integer.valueOf(((gmq)localObject1).acic);
            }
            break;
          }
        }
      }
      int i;
      if (!((Collection)localObject2).isEmpty())
      {
        i = 1;
        if (i != 0) {
          localObject3 = localLinkedList.iterator();
        }
      }
      else
      {
        label505:
        label634:
        for (;;)
        {
          if (!((Iterator)localObject3).hasNext()) {
            break label636;
          }
          localflc = (flc)((Iterator)localObject3).next();
          String str = localflc.abyJ;
          if (str != null)
          {
            localObject1 = localflc.abLE;
            if (localObject1 == null) {
              localObject1 = null;
            }
            for (;;)
            {
              if (localObject1 == null) {
                break label634;
              }
              i = ((Integer)localObject1).intValue();
              if (((i != 0) && (i != 4)) || (!((HashSet)localObject2).contains(str))) {
                break label505;
              }
              localflc.abLE.achP = null;
              break label505;
              i = 0;
              break;
              localObject1 = ((gmp)localObject1).achP;
              if (localObject1 == null) {
                localObject1 = null;
              } else {
                localObject1 = Integer.valueOf(((gmq)localObject1).acic);
              }
            }
          }
        }
      }
      label636:
      e.a((List)localLinkedList, paramBoolean1, paramc.scene);
    }
    Object localObject1 = new tq();
    ((tq)localObject1).irj = ((tq)localObject1).F("UserName", paramc.username, true);
    ((tq)localObject1).imT = ((tq)localObject1).F("AppId", paramc.appId, true);
    ((tq)localObject1).jax = paramc.appType;
    ((tq)localObject1).iqr = paramc.scene;
    ((tq)localObject1).gC(paramc.endTime - paramc.startTime);
    ((tq)localObject1).gD(paramc.startTime);
    ((tq)localObject1).gE(paramc.endTime);
    ((tq)localObject1).jEF = parama.errType;
    ((tq)localObject1).iVU = com.tencent.mm.plugin.appbrand.report.quality.f.getNetworkType();
    ((tq)localObject1).bMH();
    AppMethodBeat.o(320458);
  }
  
  private static final b.a b(c paramc)
  {
    AppMethodBeat.i(320434);
    s.u(paramc, "this$0");
    paramc = b.a.a(3, -2, "EMPTY USERNAME OR APPID", (esc)new ega(), null, (b)paramc);
    AppMethodBeat.o(320434);
    return paramc;
  }
  
  private static final b.a c(c paramc)
  {
    AppMethodBeat.i(320438);
    s.u(paramc, "this$0");
    paramc = b.a.a(3, -2, "NULL wxaAttrStorage", (esc)new ega(), null, (b)paramc);
    AppMethodBeat.o(320438);
    return paramc;
  }
  
  public final void A(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(50190);
    h.ahAA.bk(new c..ExternalSyntheticLambda3(this, paramBoolean1, paramBoolean2));
    AppMethodBeat.o(50190);
  }
  
  public final com.tencent.mm.cp.f<b.a<ega>> bFJ()
  {
    Object localObject1 = null;
    AppMethodBeat.i(50189);
    Object localObject2 = (CharSequence)this.username;
    if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label99;
      }
      localObject2 = (CharSequence)this.appId;
      if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
        break label94;
      }
    }
    label94:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label99;
      }
      localObject1 = g.c(new c..ExternalSyntheticLambda0(this));
      s.s(localObject1, "{\n            pipelineEx…)\n            }\n        }");
      AppMethodBeat.o(50189);
      return localObject1;
      i = 0;
      break;
    }
    label99:
    if ((ac)n.cfc() == null)
    {
      localObject1 = g.c(new c..ExternalSyntheticLambda1(this));
      s.s(localObject1, "{\n            pipelineEx…)\n            }\n        }");
      AppMethodBeat.o(50189);
      return localObject1;
    }
    Log.i(this.TAG, "do cgi with username[" + this.username + "] appId:[" + this.appId + ']');
    localObject2 = new c.a();
    efz localefz = new efz();
    String str = this.username;
    Object localObject3 = this.appId;
    flb localflb = new flb();
    CharSequence localCharSequence = (CharSequence)localObject3;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i != 0) {
        break label438;
      }
      localflb.oOI = ((String)localObject3);
      localObject1 = (CharSequence)localObject3;
      if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
        break label403;
      }
      i = 1;
      label274:
      if (i == 0) {
        break label408;
      }
      localObject1 = null;
      label280:
      if (localObject1 != null) {
        break label509;
      }
      i = 0;
    }
    for (;;)
    {
      localflb.abLC = i;
      localflb.IcT = this.path;
      localefz.abls = localflb;
      localefz.ablt = true;
      localefz.scene = this.scene;
      localObject1 = ah.aiuX;
      ((c.a)localObject2).otE = ((com.tencent.mm.bx.a)localefz);
      ((c.a)localObject2).otF = ((com.tencent.mm.bx.a)new ega());
      ((c.a)localObject2).uri = this.URL;
      ((c.a)localObject2).funcId = this.qIM;
      localObject1 = ah.aiuX;
      super.c(((c.a)localObject2).bEF());
      localObject1 = super.bFJ();
      s.s(localObject1, "{\n            Log.i(TAG,…    super.run()\n        }");
      AppMethodBeat.o(50189);
      return localObject1;
      i = 0;
      break;
      label403:
      i = 0;
      break label274;
      label408:
      localObject1 = (ac)n.cfc();
      if (localObject1 == null)
      {
        localObject1 = null;
        break label280;
      }
      localObject1 = ((ac)localObject1).e((String)localObject3, new String[0]);
      break label280;
      label438:
      localflb.aaLU = str;
      localObject3 = (CharSequence)str;
      if ((localObject3 == null) || (((CharSequence)localObject3).length() == 0))
      {
        i = 1;
        label469:
        if (i == 0) {
          break label481;
        }
      }
      for (;;)
      {
        break;
        i = 0;
        break label469;
        label481:
        localObject3 = (ac)n.cfc();
        if (localObject3 != null) {
          localObject1 = ((ac)localObject3).d(str, new String[0]);
        }
      }
      label509:
      localObject1 = ((WxaAttributes)localObject1).clf();
      if (localObject1 == null) {
        i = 0;
      } else {
        i = ((WxaAttributes.WxaVersionInfo)localObject1).appVersion;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.c
 * JD-Core Version:    0.7.0.1
 */