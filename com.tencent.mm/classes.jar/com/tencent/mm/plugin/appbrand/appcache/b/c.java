package com.tencent.mm.plugin.appbrand.appcache.b;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a.a;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.cm.f;
import com.tencent.mm.cm.g;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.v;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.u;
import com.tencent.mm.protocal.protobuf.cmh;
import com.tencent.mm.protocal.protobuf.cmi;
import com.tencent.mm.protocal.protobuf.dmi;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vending.g.d.b;
import com.tencent.mm.vending.h.d;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/CgiPreDownloadCode;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/PreDownloadCodeResp;", "username", "", "path", "scene", "", "appId", "appType", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;I)V", "(Ljava/lang/String;Ljava/lang/String;I)V", "FUNC_ID", "getFUNC_ID", "()I", "TAG", "getTAG", "()Ljava/lang/String;", "URL", "getURL", "getAppId", "setAppId", "(Ljava/lang/String;)V", "getAppType", "setAppType", "(I)V", "endTime", "", "getEndTime", "()J", "setEndTime", "(J)V", "getPath", "getScene", "startTime", "getStartTime", "setStartTime", "getUsername", "wxaAttrStorage", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttrStorage;", "getWxaAttrStorage", "()Lcom/tencent/mm/plugin/appbrand/config/WxaAttrStorage;", "createSingleReqInfo", "Lcom/tencent/mm/protocal/protobuf/SyncVersionSingleReqInfo;", "execute", "", "splitDownloadURLCgi", "", "dealPluginOnly", "run", "Lcom/tencent/mm/wx/WxPipeline;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "plugin-appbrand-integration_release"})
public final class c
  extends com.tencent.mm.ak.a<cmi>
{
  final String TAG;
  private final String URL;
  String appId;
  int appType;
  long endTime;
  private final int jMN;
  private final String path;
  final int scene;
  long startTime;
  final String username;
  
  public c()
  {
    this(null, 7);
  }
  
  public c(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    this(null, paramString1, paramInt1);
    this.appId = paramString2;
    this.appType = paramInt2;
  }
  
  public c(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(50192);
    this.username = paramString1;
    this.path = paramString2;
    this.scene = paramInt;
    this.TAG = "MicroMsg.AppBrand.CgiPreDownloadCode";
    this.URL = "/cgi-bin/mmbiz-bin/wxasync/wxaapp_predownloadcode";
    this.jMN = 1479;
    this.startTime = System.currentTimeMillis();
    AppMethodBeat.o(50192);
  }
  
  public final f<a.a<cmi>> aET()
  {
    Object localObject1 = null;
    int j = 1;
    AppMethodBeat.i(50189);
    Object localObject2 = (CharSequence)this.username;
    if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label107;
      }
      localObject2 = (CharSequence)this.appId;
      if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
        break label102;
      }
    }
    label102:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label107;
      }
      localObject1 = g.c((com.tencent.mm.vending.g.c.a)new b(this));
      p.g(localObject1, "pipelineExt {\n          …          )\n            }");
      AppMethodBeat.o(50189);
      return localObject1;
      i = 0;
      break;
    }
    label107:
    if ((u)j.aZl() == null)
    {
      localObject1 = g.c((com.tencent.mm.vending.g.c.a)new c(this));
      p.g(localObject1, "if (null == wxaAttrStora…    super.run()\n        }");
      AppMethodBeat.o(50189);
      return localObject1;
    }
    ae.i(this.TAG, "do cgi with username[" + this.username + "] appId:[" + this.appId + ']');
    localObject2 = new b.a();
    cmh localcmh = new cmh();
    String str = this.username;
    Object localObject3 = this.appId;
    dmi localdmi = new dmi();
    CharSequence localCharSequence = (CharSequence)localObject3;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      label250:
      if (i != 0) {
        break label447;
      }
      localdmi.ikm = ((String)localObject3);
      localObject1 = (CharSequence)localObject3;
      i = j;
      if (localObject1 != null)
      {
        if (((CharSequence)localObject1).length() != 0) {
          break label412;
        }
        i = j;
      }
      label284:
      if (i == 0) {
        break label417;
      }
      localObject1 = null;
      label290:
      if (localObject1 == null) {
        break label518;
      }
      localObject1 = ((WxaAttributes)localObject1).beV();
      if (localObject1 == null) {
        break label518;
      }
    }
    label518:
    for (i = ((WxaAttributes.WxaVersionInfo)localObject1).aDD;; i = 0)
    {
      localdmi.HTI = i;
      localdmi.uuA = this.path;
      localcmh.Hym = localdmi;
      localcmh.Hyn = v.bas();
      localcmh.scene = this.scene;
      ((b.a)localObject2).c((com.tencent.mm.bw.a)localcmh);
      ((b.a)localObject2).d((com.tencent.mm.bw.a)new cmi());
      ((b.a)localObject2).DN(this.URL);
      ((b.a)localObject2).oS(this.jMN);
      super.c(((b.a)localObject2).aDS());
      localObject1 = super.aET();
      break;
      i = 0;
      break label250;
      label412:
      i = 0;
      break label284;
      label417:
      localObject1 = (u)j.aZl();
      if (localObject1 != null)
      {
        localObject1 = ((u)localObject1).e((String)localObject3, new String[0]);
        break label290;
      }
      localObject1 = null;
      break label290;
      label447:
      localdmi.Hhh = str;
      localObject3 = (CharSequence)str;
      if ((localObject3 == null) || (((CharSequence)localObject3).length() == 0))
      {
        i = 1;
        label478:
        if (i == 0) {
          break label490;
        }
      }
      for (;;)
      {
        break;
        i = 0;
        break label478;
        label490:
        localObject3 = (u)j.aZl();
        if (localObject3 != null) {
          localObject1 = ((u)localObject3).d(str, new String[0]);
        }
      }
    }
  }
  
  public final void s(final boolean paramBoolean1, final boolean paramBoolean2)
  {
    AppMethodBeat.i(50190);
    h.MqF.aM((Runnable)new a(this, paramBoolean1, paramBoolean2));
    AppMethodBeat.o(50190);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(c paramc, boolean paramBoolean1, boolean paramBoolean2) {}
    
    public final void run()
    {
      AppMethodBeat.i(50186);
      this.jMO.aET().a((d)d.LFo, (d.b)new d.b() {});
      AppMethodBeat.o(50186);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/PreDownloadCodeResp;", "kotlin.jvm.PlatformType", "call"})
  static final class b<_Ret>
    implements com.tencent.mm.vending.g.c.a<_Var>
  {
    b(c paramc) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/PreDownloadCodeResp;", "kotlin.jvm.PlatformType", "call"})
  static final class c<_Ret>
    implements com.tencent.mm.vending.g.c.a<_Var>
  {
    c(c paramc) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.c
 * JD-Core Version:    0.7.0.1
 */