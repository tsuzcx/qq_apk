package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.h;
import com.tencent.mm.al.c.a;
import com.tencent.mm.al.y;
import com.tencent.mm.b.p;
import com.tencent.mm.co.f;
import com.tencent.mm.plugin.appbrand.aa.i;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.ab;
import com.tencent.mm.plugin.appbrand.appcache.bb;
import com.tencent.mm.plugin.appbrand.appcache.bf;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaPluginCodeInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaWidgetInfo;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.protobuf.ate;
import com.tencent.mm.protocal.protobuf.atf;
import com.tencent.mm.protocal.protobuf.bmj;
import com.tencent.mm.protocal.protobuf.ckp;
import com.tencent.mm.protocal.protobuf.duo;
import com.tencent.mm.protocal.protobuf.ji;
import com.tencent.mm.protocal.protobuf.jj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class ac
  implements x
{
  final String appId;
  final int gXn;
  List<WxaAttributes.WxaWidgetInfo> huK;
  final int kJQ;
  List<WxaAttributes.WxaPluginCodeInfo> kJR;
  LinkedHashMap<String, i<WxaPkgWrappingInfo>> kJS;
  private final String kJT;
  private final AtomicInteger kJU;
  private volatile boolean kJV;
  private com.tencent.mm.plugin.appbrand.launching.f.a kJW;
  private PBool kJX;
  List<u> kJY;
  
  ac(String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3, List<WxaAttributes.WxaPluginCodeInfo> paramList, List<WxaAttributes.WxaWidgetInfo> paramList1, PBool paramPBool)
  {
    AppMethodBeat.i(174946);
    this.kJS = new LinkedHashMap();
    this.kJU = new AtomicInteger(0);
    this.kJV = false;
    this.kJY = new LinkedList();
    ad.i("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoHandler", "appId:%s,versionType:%s,desirePkgVersion:%s,instanceId:%s,scene:%d", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2, Integer.valueOf(paramInt3) });
    this.appId = paramString1;
    this.gXn = paramInt1;
    this.kJQ = paramInt2;
    this.kJR = paramList;
    this.huK = paramList1;
    this.kJW = new com.tencent.mm.plugin.appbrand.launching.f.a(paramString1, paramInt2, paramInt1, paramString2, paramInt3, this.kJR);
    this.kJX = paramPBool;
    this.kJT = paramString2;
    AppMethodBeat.o(174946);
  }
  
  private WxaPkgWrappingInfo aVF()
  {
    AppMethodBeat.i(174947);
    Object localObject1 = new i();
    int j = 12;
    int i = j;
    Object localObject2;
    if (this.huK != null)
    {
      i = j;
      if (this.huK.size() > 0)
      {
        localObject2 = this.huK.iterator();
        i = 12;
        if (((Iterator)localObject2).hasNext())
        {
          j = ((WxaAttributes.WxaWidgetInfo)((Iterator)localObject2).next()).deP;
          if (j != 22) {
            break label2136;
          }
          i = j;
        }
      }
    }
    label1161:
    label1427:
    label1492:
    label2136:
    for (;;)
    {
      break;
      localObject2 = m.b(this.appId, "__WITHOUT_MULTI_PLUGINCODE__", i, this.kJQ, this.gXn);
      if (localObject2 != null)
      {
        ad.i("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoHandler", "mainModulePkgInfo exists!");
        ((i)localObject1).value = localObject2;
        ad.i("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoHandler", "mainModulePkgType:%d", new Object[] { Integer.valueOf(i) });
        localObject2 = (WxaPkgWrappingInfo)((i)localObject1).value;
        localObject3 = this.kJR.iterator();
      }
      Object localObject5;
      Object localObject4;
      Object localObject6;
      for (;;)
      {
        if (!((Iterator)localObject3).hasNext()) {
          break label501;
        }
        localObject5 = (WxaAttributes.WxaPluginCodeInfo)((Iterator)localObject3).next();
        localObject4 = ((WxaAttributes.WxaPluginCodeInfo)localObject5).provider;
        localObject6 = ((WxaAttributes.WxaPluginCodeInfo)localObject5).md5;
        i = ((WxaAttributes.WxaPluginCodeInfo)localObject5).version;
        this.kJS.put(localObject6, new i());
        localObject5 = m.b((String)localObject4, "__PLUGINCODE__", 6, i, 0);
        if (localObject5 != null)
        {
          ad.i("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoHandler", "pluginPkgInfo exists!");
          ((i)this.kJS.get(((WxaPkgWrappingInfo)localObject5).md5)).value = localObject5;
          sI(3);
          continue;
          localObject2 = new u();
          localObject3 = new ckp();
          ((ckp)localObject3).dlB = this.appId;
          if (j.a.qD(this.gXn)) {
            ((u)localObject2).kIJ = m.Kh(new ab(this.appId, "__WITHOUT_MULTI_PLUGINCODE__", i).toString());
          }
          ((ckp)localObject3).CLK = this.gXn;
          ((ckp)localObject3).DyU = i;
          ((u)localObject2).kII = ((ckp)localObject3);
          ((u)localObject2).kIK = this.kJQ;
          this.kJY.add(localObject2);
          break;
        }
        localObject5 = new u();
        localObject6 = new ckp();
        ((ckp)localObject6).dlB = ((String)localObject4);
        ((ckp)localObject6).CLK = 0;
        ((ckp)localObject6).DyU = 6;
        ((u)localObject5).kII = ((ckp)localObject6);
        ((u)localObject5).kIJ = m.bF(new ab((String)localObject4, "/__plugin__/", 6).toString(), i);
        ((u)localObject5).kIK = i;
        this.kJY.add(localObject5);
        ad.i("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoHandler", "pluginCode localPkgVersion:%d", new Object[] { Integer.valueOf(((u)localObject5).kIJ) });
      }
      label501:
      ad.i("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoHandler", "todoDownloadPkgList size:%d", new Object[] { Integer.valueOf(this.kJY.size()) });
      if (this.kJY.size() == 0)
      {
        i = 0;
        if (i < this.kJR.size())
        {
          localObject1 = (WxaAttributes.WxaPluginCodeInfo)this.kJR.get(i);
          localObject3 = (i)this.kJS.get(((WxaAttributes.WxaPluginCodeInfo)localObject1).md5);
          if (localObject3 == null) {
            ad.e("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoHandler", "wxaPkgInfoPointer null!");
          }
          for (;;)
          {
            i += 1;
            break;
            localObject3 = (WxaPkgWrappingInfo)((i)localObject3).value;
            if (localObject3 == null)
            {
              ad.e("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoHandler", "wxaPkgInfoPointer value null!");
            }
            else if (bt.isNullOrNil(((WxaAttributes.WxaPluginCodeInfo)localObject1).md5))
            {
              ad.e("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoHandler", "pluginInfo md5 null!");
            }
            else
            {
              localObject4 = new ModulePkgInfo();
              ((ModulePkgInfo)localObject4).name = ("/__plugin__/" + ((WxaAttributes.WxaPluginCodeInfo)localObject1).provider);
              ((ModulePkgInfo)localObject4).md5 = ((WxaAttributes.WxaPluginCodeInfo)this.kJR.get(i)).md5;
              ((ModulePkgInfo)localObject4).pkgPath = ((WxaPkgWrappingInfo)localObject3).pkgPath;
              ((WxaPkgWrappingInfo)localObject2).iOT.add(localObject4);
            }
          }
        }
        this.kJX.value = true;
        AppMethodBeat.o(174947);
        return localObject2;
      }
      localObject2 = new ji();
      Object localObject3 = this.kJY.iterator();
      Object localObject7;
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (u)((Iterator)localObject3).next();
        localObject5 = ((u)localObject4).kII;
        localObject6 = new bmj();
        ((bmj)localObject6).CLL = ((u)localObject4).kIJ;
        ((bmj)localObject6).DAQ = 0;
        localObject7 = new ate();
        ((ate)localObject7).Dth = ((ckp)localObject5);
        ((ate)localObject7).Dti = ((bmj)localObject6);
        ((ate)localObject7).Dtj = 0;
        ((ate)localObject7).CLL = ((u)localObject4).kIK;
        String str;
        if (((ckp)localObject5).CLK == 1) {
          str = ((t)j.T(t.class)).bG(this.appId, this.gXn);
        }
        try
        {
          long l = h.qE(str).optLong("dev_key");
          ((ate)localObject7).Dtm = new p(l).intValue();
          ad.d("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoHandler", "uinL:%d", new Object[] { Long.valueOf(l) });
          if (((ckp)localObject5).CLK == 0)
          {
            ((ate)localObject7).Dtl = true;
            ((ji)localObject2).CEF.add(localObject7);
            localObject7 = new ate();
            ((ate)localObject7).Dth = ((ckp)localObject5);
            ((ate)localObject7).Dti = ((bmj)localObject6);
            ((ate)localObject7).Dtj = 0;
            ((ate)localObject7).CLL = ((u)localObject4).kIK;
            ((ate)localObject7).Dtl = false;
            ((ji)localObject2).CEF.add(localObject7);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ad.e("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoHandler", "opt devKey %s", new Object[] { localException });
          }
          ((ate)localObject7).Dtl = false;
          ((ji)localObject2).CEF.add(localObject7);
        }
      }
      localObject2 = y.a(new com.tencent.mm.plugin.appbrand.appcache.g((ji)localObject2));
      if ((localObject2 == null) || (((c.a)localObject2).errType != 0) || (((c.a)localObject2).errCode != 0))
      {
        if (localObject2 == null)
        {
          i = -1;
          if (localObject2 != null) {
            break label1161;
          }
        }
        for (j = -1;; j = ((c.a)localObject2).errCode)
        {
          ad.e("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoHandler", " cgi failed, %d %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          AppMethodBeat.o(174947);
          return null;
          i = ((c.a)localObject2).errType;
          break;
        }
      }
      ad.d("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoHandler", "back.resp.resp_list size:%d", new Object[] { Integer.valueOf(((jj)((c.a)localObject2).gUK).CEG.size()) });
      localObject2 = ((jj)((c.a)localObject2).gUK).CEG.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject8 = (atf)((Iterator)localObject2).next();
        if (((atf)localObject8).dhR == 0)
        {
          localObject3 = ((atf)localObject8).md5;
          localObject4 = ((atf)localObject8).url;
          localObject5 = ((atf)localObject8).Dth;
          localObject6 = ((ckp)localObject5).dlB;
          localObject7 = ((ckp)localObject5).DyR;
          i = ((ckp)localObject5).DyU;
          j = ((ckp)localObject5).CLK;
          int k = ((atf)localObject8).CLL;
          boolean bool1 = ((atf)localObject8).Dtn;
          boolean bool2 = ((atf)localObject8).Dto;
          ad.i("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoHandler", "appid:%s,pkgType:%d,md5:%s,url:%s,isPatch:%b,isZstd:%b", new Object[] { localObject6, Integer.valueOf(i), localObject3, localObject4, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          if (j == 0)
          {
            localObject8 = new duo();
            ((duo)localObject8).EIW = ((String)localObject3);
            ((duo)localObject8).CHC = k;
            j.aOK().a(new ab((String)localObject6, (String)localObject7, i).toString(), (duo)localObject8);
            localObject6 = this.kJY.iterator();
          }
          for (;;)
          {
            if (!((Iterator)localObject6).hasNext()) {
              break label1714;
            }
            localObject7 = (u)((Iterator)localObject6).next();
            localObject8 = ((u)localObject7).kII;
            if ((localObject8 != null) && (localObject5 != null))
            {
              j = 0;
              if ((bt.isNullOrNil(((ckp)localObject8).DyR)) && (bt.isNullOrNil(((ckp)localObject5).DyR)))
              {
                i = 1;
                if ((!((ckp)localObject8).dlB.equals(((ckp)localObject5).dlB)) || (((ckp)localObject8).DyU != ((ckp)localObject5).DyU) || (i == 0) || (((ckp)localObject8).CLK != ((ckp)localObject5).CLK)) {
                  break label1681;
                }
                i = 1;
              }
            }
            for (;;)
            {
              if (i == 0) {
                break label1689;
              }
              ((u)localObject7).md5 = ((String)localObject3);
              if (!bool1) {
                break label1691;
              }
              ((u)localObject7).kIN = ((String)localObject4);
              break label1427;
              localObject6 = j.aOK().a(new ab(this.appId, (String)localObject7, i).toString(), j, new String[] { "versionMd5", "downloadURL" });
              ((bb)localObject6).field_versionMd5 = ((String)localObject3);
              if (localObject6 == null) {
                break;
              }
              j.aOK().e((bb)localObject6);
              break;
              i = j;
              if (bt.isNullOrNil(((ckp)localObject8).DyR)) {
                break label1492;
              }
              i = j;
              if (bt.isNullOrNil(((ckp)localObject5).DyR)) {
                break label1492;
              }
              i = j;
              if (!((ckp)localObject8).DyR.equals(((ckp)localObject5).DyR)) {
                break label1492;
              }
              i = 1;
              break label1492;
              i = 0;
              continue;
              i = 0;
            }
            continue;
            if (bool2) {
              ((u)localObject7).kIM = ((String)localObject4);
            } else {
              ((u)localObject7).kIL = ((String)localObject4);
            }
          }
        }
        else
        {
          ad.e("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoHandler", "batch cgi error errcode:%d!", new Object[] { Integer.valueOf(((atf)localObject8).dhR) });
        }
      }
      localObject2 = new CountDownLatch(this.kJY.size());
      localObject3 = this.kJY.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (u)((Iterator)localObject3).next();
        localObject5 = aa.c.a((u)localObject4);
        ((aa)localObject5).a(k.Kf(this.kJT));
        ((aa)localObject5).a(new a((CountDownLatch)localObject2, (u)localObject4)
        {
          final long bgF()
          {
            AppMethodBeat.i(174938);
            long l = this.val$latch.getCount();
            AppMethodBeat.o(174938);
            return l;
          }
          
          final String bgG()
          {
            AppMethodBeat.i(174939);
            String str = "appId=" + this.kJZ.kII.dlB + " packgeType=" + this.kJZ.kII.DyU;
            AppMethodBeat.o(174939);
            return str;
          }
        });
        ((aa)localObject5).a(new aa.e()
        {
          public final void bgC()
          {
            AppMethodBeat.i(174941);
            if (this.kJZ.kII.DyU == 6) {
              ac.a(ac.this, 3);
            }
            ad.i("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoHandler", "plugin already downloaded, engineId[%s] version[%d]", new Object[] { this.kJZ.kII.dlB, Integer.valueOf(this.kJZ.kII.CLK) });
            AppMethodBeat.o(174941);
          }
          
          public final void bgD()
          {
            AppMethodBeat.i(174942);
            if (this.kJZ.kII.DyU == 6) {
              ac.a(ac.this, 4);
            }
            ad.i("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoHandler", "onPatchDownload");
            AppMethodBeat.o(174942);
          }
          
          public final void bgE()
          {
            AppMethodBeat.i(174943);
            ad.i("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoHandler", "onIntegrateDownload");
            if (this.kJZ.kII.DyU == 6) {
              ac.a(ac.this, 2);
            }
            AppMethodBeat.o(174943);
          }
          
          public final void c(WxaPkgWrappingInfo paramAnonymousWxaPkgWrappingInfo)
          {
            AppMethodBeat.i(174944);
            if (paramAnonymousWxaPkgWrappingInfo != null)
            {
              if (ac.this.kJS.containsKey(paramAnonymousWxaPkgWrappingInfo.md5))
              {
                ((i)ac.this.kJS.get(paramAnonymousWxaPkgWrappingInfo.md5)).value = paramAnonymousWxaPkgWrappingInfo;
                com.tencent.mm.co.g.fkM().i(new com.tencent.mm.vending.c.a() {}).fhm();
              }
            }
            else
            {
              this.val$latch.countDown();
              if (paramAnonymousWxaPkgWrappingInfo == null) {
                break label113;
              }
            }
            label113:
            for (paramAnonymousWxaPkgWrappingInfo = paramAnonymousWxaPkgWrappingInfo.toString();; paramAnonymousWxaPkgWrappingInfo = "null")
            {
              ad.i("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoHandler", "downloadPkgInfo :%s", new Object[] { paramAnonymousWxaPkgWrappingInfo });
              AppMethodBeat.o(174944);
              return;
              this.kKb.value = paramAnonymousWxaPkgWrappingInfo;
              break;
            }
          }
          
          public final void d(WxaPkgWrappingInfo paramAnonymousWxaPkgWrappingInfo)
          {
            AppMethodBeat.i(174945);
            if (paramAnonymousWxaPkgWrappingInfo != null)
            {
              if (ac.this.kJS.containsKey(paramAnonymousWxaPkgWrappingInfo.md5))
              {
                ac.sJ(0);
                AppMethodBeat.o(174945);
                return;
              }
              ac.sJ(7);
              AppMethodBeat.o(174945);
              return;
            }
            if (ac.this.kJS.containsKey(this.kJZ.md5))
            {
              ac.sJ(1);
              AppMethodBeat.o(174945);
              return;
            }
            ac.sJ(8);
            AppMethodBeat.o(174945);
          }
        });
        ((aa)localObject5).prepareAsync();
      }
      ((CountDownLatch)localObject2).await();
      ad.i("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoHandler", "both downloaded");
      if (this.kJV) {
        bgq();
      }
      if ((((i)localObject1).value == null) || (this.kJS.size() <= 0))
      {
        ad.i("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoHandler", "mainModule value or pluginCodeList result null!!");
        AppMethodBeat.o(174947);
        return null;
      }
      this.kJW.report();
      localObject1 = (WxaPkgWrappingInfo)((i)localObject1).value;
      i = 0;
      while (i < this.kJR.size())
      {
        localObject2 = (WxaAttributes.WxaPluginCodeInfo)this.kJR.get(i);
        localObject3 = (WxaPkgWrappingInfo)((i)this.kJS.get(((WxaAttributes.WxaPluginCodeInfo)this.kJR.get(i)).md5)).value;
        if ((localObject3 != null) && (!bt.isNullOrNil(((WxaAttributes.WxaPluginCodeInfo)this.kJR.get(i)).md5)))
        {
          localObject4 = new ModulePkgInfo();
          ((ModulePkgInfo)localObject4).name = ("/__plugin__/" + ((WxaAttributes.WxaPluginCodeInfo)localObject2).provider);
          ((ModulePkgInfo)localObject4).md5 = ((WxaAttributes.WxaPluginCodeInfo)this.kJR.get(i)).md5;
          ((ModulePkgInfo)localObject4).pkgPath = ((WxaPkgWrappingInfo)localObject3).pkgPath;
          ((WxaPkgWrappingInfo)localObject1).iOT.add(localObject4);
        }
        i += 1;
      }
      this.kJX.value = true;
      ad.d("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoHandler", "module rerange ok!");
      AppMethodBeat.o(174947);
      return localObject1;
    }
  }
  
  private void sI(int paramInt)
  {
    AppMethodBeat.i(174948);
    this.kJW.sV(paramInt);
    AppMethodBeat.o(174948);
  }
  
  public void bgi() {}
  
  public void bgq() {}
  
  public void onDownloadProgress(int paramInt) {}
  
  abstract class a
    implements aa.b
  {
    private int kKd = 0;
    
    private a() {}
    
    public final void b(WxaPkgLoadProgress paramWxaPkgLoadProgress)
    {
      ac.a(ac.this);
      ad.i("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoHandler", bgG() + " progress=" + paramWxaPkgLoadProgress.progress);
      long l = bgF();
      if (l == 0L) {
        ac.b(ac.this).set(100);
      }
      for (;;)
      {
        this.kKd = paramWxaPkgLoadProgress.progress;
        ac.c(ac.this);
        return;
        ac.b(ac.this).addAndGet(Math.round(Math.max(0, paramWxaPkgLoadProgress.progress - this.kKd) / (float)l));
      }
    }
    
    abstract long bgF();
    
    abstract String bgG();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ac
 * JD-Core Version:    0.7.0.1
 */