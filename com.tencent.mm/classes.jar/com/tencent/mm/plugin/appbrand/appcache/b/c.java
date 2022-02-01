package com.tencent.mm.plugin.appbrand.appcache.b;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.a;
import com.tencent.mm.al.b.a;
import com.tencent.mm.cn.f;
import com.tencent.mm.cn.g;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.protocal.protobuf.cln;
import com.tencent.mm.protocal.protobuf.clo;
import com.tencent.mm.protocal.protobuf.dll;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vending.g.d.b;
import com.tencent.mm.vending.h.d;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/CgiPreDownloadCode;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/PreDownloadCodeResp;", "username", "", "path", "scene", "", "appId", "appType", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;I)V", "(Ljava/lang/String;Ljava/lang/String;I)V", "FUNC_ID", "getFUNC_ID", "()I", "TAG", "getTAG", "()Ljava/lang/String;", "URL", "getURL", "getAppId", "setAppId", "(Ljava/lang/String;)V", "getAppType", "setAppType", "(I)V", "endTime", "", "getEndTime", "()J", "setEndTime", "(J)V", "getPath", "getScene", "startTime", "getStartTime", "setStartTime", "getUsername", "wxaAttrStorage", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttrStorage;", "getWxaAttrStorage", "()Lcom/tencent/mm/plugin/appbrand/config/WxaAttrStorage;", "createSingleReqInfo", "Lcom/tencent/mm/protocal/protobuf/SyncVersionSingleReqInfo;", "execute", "", "splitDownloadURLCgi", "", "dealPluginOnly", "run", "Lcom/tencent/mm/wx/WxPipeline;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "plugin-appbrand-integration_release"})
public final class c
  extends com.tencent.mm.al.a<clo>
{
  final String TAG;
  private final String URL;
  String appId;
  int appType;
  long endTime;
  private final int jJL;
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
    this.jJL = 1479;
    this.startTime = System.currentTimeMillis();
    AppMethodBeat.o(50192);
  }
  
  public final f<a.a<clo>> aED()
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
    if ((com.tencent.mm.plugin.appbrand.config.u)j.aYP() == null)
    {
      localObject1 = g.c((com.tencent.mm.vending.g.c.a)new c(this));
      p.g(localObject1, "if (null == wxaAttrStora…    super.run()\n        }");
      AppMethodBeat.o(50189);
      return localObject1;
    }
    ad.i(this.TAG, "do cgi with username[" + this.username + "] appId:[" + this.appId + ']');
    localObject2 = new b.a();
    cln localcln = new cln();
    String str = this.username;
    Object localObject3 = this.appId;
    dll localdll = new dll();
    CharSequence localCharSequence = (CharSequence)localObject3;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      label250:
      if (i != 0) {
        break label447;
      }
      localdll.iht = ((String)localObject3);
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
      localObject1 = ((WxaAttributes)localObject1).ben();
      if (localObject1 == null) {
        break label518;
      }
    }
    label518:
    for (i = ((WxaAttributes.WxaVersionInfo)localObject1).aDD;; i = 0)
    {
      localdll.HzV = i;
      localdll.ujc = this.path;
      localcln.HeM = localdll;
      localcln.HeN = com.tencent.mm.plugin.appbrand.appcache.u.aZT();
      localcln.scene = this.scene;
      ((b.a)localObject2).c((com.tencent.mm.bx.a)localcln);
      ((b.a)localObject2).d((com.tencent.mm.bx.a)new clo());
      ((b.a)localObject2).Dl(this.URL);
      ((b.a)localObject2).oP(this.jJL);
      super.c(((b.a)localObject2).aDC());
      localObject1 = super.aED();
      break;
      i = 0;
      break label250;
      label412:
      i = 0;
      break label284;
      label417:
      localObject1 = (com.tencent.mm.plugin.appbrand.config.u)j.aYP();
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.appbrand.config.u)localObject1).e((String)localObject3, new String[0]);
        break label290;
      }
      localObject1 = null;
      break label290;
      label447:
      localdll.GNH = str;
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
        localObject3 = (com.tencent.mm.plugin.appbrand.config.u)j.aYP();
        if (localObject3 != null) {
          localObject1 = ((com.tencent.mm.plugin.appbrand.config.u)localObject3).d(str, new String[0]);
        }
      }
    }
  }
  
  public final void s(final boolean paramBoolean1, final boolean paramBoolean2)
  {
    AppMethodBeat.i(50190);
    h.LTJ.aP((Runnable)new a(this, paramBoolean1, paramBoolean2));
    AppMethodBeat.o(50190);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(c paramc, boolean paramBoolean1, boolean paramBoolean2) {}
    
    public final void run()
    {
      AppMethodBeat.i(50186);
      this.jJM.aED().a((d)d.LiM, (d.b)new d.b() {});
      AppMethodBeat.o(50186);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/PreDownloadCodeResp;", "kotlin.jvm.PlatformType", "call"})
  static final class b<_Ret>
    implements com.tencent.mm.vending.g.c.a<_Var>
  {
    b(c paramc) {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/PreDownloadCodeResp;", "kotlin.jvm.PlatformType", "call"})
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