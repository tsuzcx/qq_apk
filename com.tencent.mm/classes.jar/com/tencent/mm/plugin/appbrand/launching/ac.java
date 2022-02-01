package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.h;
import com.tencent.mm.al.a.a;
import com.tencent.mm.al.y;
import com.tencent.mm.b.p;
import com.tencent.mm.cn.f;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.bc;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaPluginCodeInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaWidgetInfo;
import com.tencent.mm.plugin.appbrand.launching.report.c;
import com.tencent.mm.plugin.appbrand.z.i;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.protobuf.bag;
import com.tencent.mm.protocal.protobuf.bah;
import com.tencent.mm.protocal.protobuf.bvm;
import com.tencent.mm.protocal.protobuf.cvb;
import com.tencent.mm.protocal.protobuf.egj;
import com.tencent.mm.protocal.protobuf.jx;
import com.tencent.mm.protocal.protobuf.jy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vending.c.a;
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
  final int hQh;
  List<WxaAttributes.WxaWidgetInfo> ioH;
  private c lIA;
  private PBool lIB;
  List<u> lIC;
  final int lIu;
  List<WxaAttributes.WxaPluginCodeInfo> lIv;
  LinkedHashMap<String, i<WxaPkgWrappingInfo>> lIw;
  private final String lIx;
  private final AtomicInteger lIy;
  private volatile boolean lIz;
  
  ac(String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3, List<WxaAttributes.WxaPluginCodeInfo> paramList, List<WxaAttributes.WxaWidgetInfo> paramList1, PBool paramPBool)
  {
    AppMethodBeat.i(174946);
    this.lIw = new LinkedHashMap();
    this.lIy = new AtomicInteger(0);
    this.lIz = false;
    this.lIC = new LinkedList();
    ad.i("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoHandler", "appId:%s,versionType:%s,desirePkgVersion:%s,instanceId:%s,scene:%d", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2, Integer.valueOf(paramInt3) });
    this.appId = paramString1;
    this.hQh = paramInt1;
    this.lIu = paramInt2;
    this.lIv = paramList;
    this.ioH = paramList1;
    this.lIA = new c(paramString1, paramInt2, paramInt1, paramString2, paramInt3, this.lIv);
    this.lIB = paramPBool;
    this.lIx = paramString2;
    AppMethodBeat.o(174946);
  }
  
  private WxaPkgWrappingInfo bgh()
  {
    AppMethodBeat.i(174947);
    Object localObject1 = new i();
    int j = 12;
    int i = j;
    Object localObject2;
    if (this.ioH != null)
    {
      i = j;
      if (this.ioH.size() > 0)
      {
        localObject2 = this.ioH.iterator();
        i = 12;
        if (((Iterator)localObject2).hasNext())
        {
          j = ((WxaAttributes.WxaWidgetInfo)((Iterator)localObject2).next()).dnF;
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
      localObject2 = m.b(this.appId, "__WITHOUT_MULTI_PLUGINCODE__", i, this.lIu, this.hQh);
      if (localObject2 != null)
      {
        ad.i("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoHandler", "mainModulePkgInfo exists!");
        ((i)localObject1).value = localObject2;
        ad.i("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoHandler", "mainModulePkgType:%d", new Object[] { Integer.valueOf(i) });
        localObject2 = (WxaPkgWrappingInfo)((i)localObject1).value;
        localObject3 = this.lIv.iterator();
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
        this.lIw.put(localObject6, new i());
        localObject5 = m.b((String)localObject4, "__PLUGINCODE__", 6, i, 0);
        if (localObject5 != null)
        {
          ad.i("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoHandler", "pluginPkgInfo exists!");
          ((i)this.lIw.get(((WxaPkgWrappingInfo)localObject5).md5)).value = localObject5;
          ud(3);
          continue;
          localObject2 = new u();
          localObject3 = new cvb();
          ((cvb)localObject3).duW = this.appId;
          if (j.a.rQ(this.hQh)) {
            ((u)localObject2).lHn = m.RM(new com.tencent.mm.plugin.appbrand.appcache.ac(this.appId, "__WITHOUT_MULTI_PLUGINCODE__", i).toString());
          }
          ((cvb)localObject3).FKM = this.hQh;
          ((cvb)localObject3).GDN = i;
          ((u)localObject2).lHm = ((cvb)localObject3);
          ((u)localObject2).lHo = this.lIu;
          this.lIC.add(localObject2);
          break;
        }
        localObject5 = new u();
        localObject6 = new cvb();
        ((cvb)localObject6).duW = ((String)localObject4);
        ((cvb)localObject6).FKM = 0;
        ((cvb)localObject6).GDN = 6;
        ((u)localObject5).lHm = ((cvb)localObject6);
        ((u)localObject5).lHn = m.bM(new com.tencent.mm.plugin.appbrand.appcache.ac((String)localObject4, "/__plugin__/", 6).toString(), i);
        ((u)localObject5).lHo = i;
        this.lIC.add(localObject5);
        ad.i("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoHandler", "pluginCode localPkgVersion:%d", new Object[] { Integer.valueOf(((u)localObject5).lHn) });
      }
      label501:
      ad.i("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoHandler", "todoDownloadPkgList size:%d", new Object[] { Integer.valueOf(this.lIC.size()) });
      if (this.lIC.size() == 0)
      {
        i = 0;
        if (i < this.lIv.size())
        {
          localObject1 = (WxaAttributes.WxaPluginCodeInfo)this.lIv.get(i);
          localObject3 = (i)this.lIw.get(((WxaAttributes.WxaPluginCodeInfo)localObject1).md5);
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
              ((ModulePkgInfo)localObject4).md5 = ((WxaAttributes.WxaPluginCodeInfo)this.lIv.get(i)).md5;
              ((ModulePkgInfo)localObject4).pkgPath = ((WxaPkgWrappingInfo)localObject3).pkgPath;
              ((WxaPkgWrappingInfo)localObject2).jIX.add(localObject4);
            }
          }
        }
        this.lIB.value = true;
        AppMethodBeat.o(174947);
        return localObject2;
      }
      localObject2 = new jx();
      Object localObject3 = this.lIC.iterator();
      Object localObject7;
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (u)((Iterator)localObject3).next();
        localObject5 = ((u)localObject4).lHm;
        localObject6 = new bvm();
        ((bvm)localObject6).FKN = ((u)localObject4).lHn;
        ((bvm)localObject6).GFJ = 0;
        localObject7 = new bag();
        ((bag)localObject7).Gxp = ((cvb)localObject5);
        ((bag)localObject7).Gxq = ((bvm)localObject6);
        ((bag)localObject7).Gxr = 0;
        ((bag)localObject7).FKN = ((u)localObject4).lHo;
        String str;
        if (((cvb)localObject5).FKM == 1) {
          str = ((t)j.T(t.class)).bN(this.appId, this.hQh);
        }
        try
        {
          long l = h.wJ(str).optLong("dev_key");
          ((bag)localObject7).Gxu = new p(l).intValue();
          ad.d("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoHandler", "uinL:%d", new Object[] { Long.valueOf(l) });
          if (((cvb)localObject5).FKM == 0)
          {
            ((bag)localObject7).Gxt = true;
            ((jx)localObject2).FCB.add(localObject7);
            localObject7 = new bag();
            ((bag)localObject7).Gxp = ((cvb)localObject5);
            ((bag)localObject7).Gxq = ((bvm)localObject6);
            ((bag)localObject7).Gxr = 0;
            ((bag)localObject7).FKN = ((u)localObject4).lHo;
            ((bag)localObject7).Gxt = false;
            ((jx)localObject2).FCB.add(localObject7);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ad.e("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoHandler", "opt devKey %s", new Object[] { localException });
          }
          ((bag)localObject7).Gxt = false;
          ((jx)localObject2).FCB.add(localObject7);
        }
      }
      localObject2 = y.a(new com.tencent.mm.plugin.appbrand.appcache.g((jx)localObject2));
      if ((localObject2 == null) || (((a.a)localObject2).errType != 0) || (((a.a)localObject2).errCode != 0))
      {
        if (localObject2 == null)
        {
          i = -1;
          if (localObject2 != null) {
            break label1161;
          }
        }
        for (j = -1;; j = ((a.a)localObject2).errCode)
        {
          ad.e("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoHandler", " cgi failed, %d %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          AppMethodBeat.o(174947);
          return null;
          i = ((a.a)localObject2).errType;
          break;
        }
      }
      ad.d("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoHandler", "back.resp.resp_list size:%d", new Object[] { Integer.valueOf(((jy)((a.a)localObject2).hNC).FCC.size()) });
      localObject2 = ((jy)((a.a)localObject2).hNC).FCC.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject8 = (bah)((Iterator)localObject2).next();
        if (((bah)localObject8).dqI == 0)
        {
          localObject3 = ((bah)localObject8).md5;
          localObject4 = ((bah)localObject8).url;
          localObject5 = ((bah)localObject8).Gxp;
          localObject6 = ((cvb)localObject5).duW;
          localObject7 = ((cvb)localObject5).GDK;
          i = ((cvb)localObject5).GDN;
          j = ((cvb)localObject5).FKM;
          int k = ((bah)localObject8).FKN;
          boolean bool1 = ((bah)localObject8).Gxv;
          boolean bool2 = ((bah)localObject8).Gxw;
          ad.i("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoHandler", "appid:%s,pkgType:%d,md5:%s,url:%s,isPatch:%b,isZstd:%b", new Object[] { localObject6, Integer.valueOf(i), localObject3, localObject4, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          if (j == 0)
          {
            localObject8 = new egj();
            ((egj)localObject8).HRv = ((String)localObject3);
            ((egj)localObject8).FFN = k;
            j.aYX().a(new com.tencent.mm.plugin.appbrand.appcache.ac((String)localObject6, (String)localObject7, i).toString(), (egj)localObject8);
            localObject6 = this.lIC.iterator();
          }
          for (;;)
          {
            if (!((Iterator)localObject6).hasNext()) {
              break label1714;
            }
            localObject7 = (u)((Iterator)localObject6).next();
            localObject8 = ((u)localObject7).lHm;
            if ((localObject8 != null) && (localObject5 != null))
            {
              j = 0;
              if ((bt.isNullOrNil(((cvb)localObject8).GDK)) && (bt.isNullOrNil(((cvb)localObject5).GDK)))
              {
                i = 1;
                if ((!((cvb)localObject8).duW.equals(((cvb)localObject5).duW)) || (((cvb)localObject8).GDN != ((cvb)localObject5).GDN) || (i == 0) || (((cvb)localObject8).FKM != ((cvb)localObject5).FKM)) {
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
              ((u)localObject7).lHr = ((String)localObject4);
              break label1427;
              localObject6 = j.aYX().a(new com.tencent.mm.plugin.appbrand.appcache.ac(this.appId, (String)localObject7, i).toString(), j, new String[] { "versionMd5", "downloadURL" });
              ((bc)localObject6).field_versionMd5 = ((String)localObject3);
              if (localObject6 == null) {
                break;
              }
              j.aYX().e((bc)localObject6);
              break;
              i = j;
              if (bt.isNullOrNil(((cvb)localObject8).GDK)) {
                break label1492;
              }
              i = j;
              if (bt.isNullOrNil(((cvb)localObject5).GDK)) {
                break label1492;
              }
              i = j;
              if (!((cvb)localObject8).GDK.equals(((cvb)localObject5).GDK)) {
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
              ((u)localObject7).lHq = ((String)localObject4);
            } else {
              ((u)localObject7).lHp = ((String)localObject4);
            }
          }
        }
        else
        {
          ad.e("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoHandler", "batch cgi error errcode:%d!", new Object[] { Integer.valueOf(((bah)localObject8).dqI) });
        }
      }
      localObject2 = new CountDownLatch(this.lIC.size());
      localObject3 = this.lIC.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (u)((Iterator)localObject3).next();
        localObject5 = aa.c.a((u)localObject4);
        ((aa)localObject5).a(k.RK(this.lIx));
        ((aa)localObject5).a(new a((CountDownLatch)localObject2, (u)localObject4)
        {
          final long brm()
          {
            AppMethodBeat.i(174938);
            long l = this.val$latch.getCount();
            AppMethodBeat.o(174938);
            return l;
          }
          
          final String brn()
          {
            AppMethodBeat.i(174939);
            String str = "appId=" + this.lID.lHm.duW + " packgeType=" + this.lID.lHm.GDN;
            AppMethodBeat.o(174939);
            return str;
          }
        });
        ((aa)localObject5).a(new aa.e()
        {
          public final void bri()
          {
            AppMethodBeat.i(174941);
            if (this.lID.lHm.GDN == 6) {
              ac.a(ac.this, 3);
            }
            ad.i("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoHandler", "plugin already downloaded, engineId[%s] version[%d]", new Object[] { this.lID.lHm.duW, Integer.valueOf(this.lID.lHm.FKM) });
            AppMethodBeat.o(174941);
          }
          
          public final void brj()
          {
            AppMethodBeat.i(174942);
            if (this.lID.lHm.GDN == 6) {
              ac.a(ac.this, 4);
            }
            ad.i("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoHandler", "onPatchDownload");
            AppMethodBeat.o(174942);
          }
          
          public final void brk()
          {
            AppMethodBeat.i(174943);
            ad.i("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoHandler", "onIntegrateDownload");
            if (this.lID.lHm.GDN == 6) {
              ac.a(ac.this, 2);
            }
            AppMethodBeat.o(174943);
          }
          
          public final void c(WxaPkgWrappingInfo paramAnonymousWxaPkgWrappingInfo)
          {
            AppMethodBeat.i(174944);
            if (paramAnonymousWxaPkgWrappingInfo != null)
            {
              if (ac.this.lIw.containsKey(paramAnonymousWxaPkgWrappingInfo.md5))
              {
                ((i)ac.this.lIw.get(paramAnonymousWxaPkgWrappingInfo.md5)).value = paramAnonymousWxaPkgWrappingInfo;
                com.tencent.mm.cn.g.fSm().i(new a() {}).fOb();
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
              this.lIF.value = paramAnonymousWxaPkgWrappingInfo;
              break;
            }
          }
          
          public final void d(WxaPkgWrappingInfo paramAnonymousWxaPkgWrappingInfo)
          {
            AppMethodBeat.i(174945);
            if (paramAnonymousWxaPkgWrappingInfo != null)
            {
              if (ac.this.lIw.containsKey(paramAnonymousWxaPkgWrappingInfo.md5))
              {
                ac.ue(0);
                AppMethodBeat.o(174945);
                return;
              }
              ac.ue(7);
              AppMethodBeat.o(174945);
              return;
            }
            if (ac.this.lIw.containsKey(this.lID.md5))
            {
              ac.ue(1);
              AppMethodBeat.o(174945);
              return;
            }
            ac.ue(8);
            AppMethodBeat.o(174945);
          }
        });
        ((aa)localObject5).prepareAsync();
      }
      ((CountDownLatch)localObject2).await();
      ad.i("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoHandler", "both downloaded");
      if (this.lIz) {
        bqW();
      }
      if ((((i)localObject1).value == null) || (this.lIw.size() <= 0))
      {
        ad.i("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoHandler", "mainModule value or pluginCodeList result null!!");
        AppMethodBeat.o(174947);
        return null;
      }
      this.lIA.report();
      localObject1 = (WxaPkgWrappingInfo)((i)localObject1).value;
      i = 0;
      while (i < this.lIv.size())
      {
        localObject2 = (WxaAttributes.WxaPluginCodeInfo)this.lIv.get(i);
        localObject3 = (WxaPkgWrappingInfo)((i)this.lIw.get(((WxaAttributes.WxaPluginCodeInfo)this.lIv.get(i)).md5)).value;
        if ((localObject3 != null) && (!bt.isNullOrNil(((WxaAttributes.WxaPluginCodeInfo)this.lIv.get(i)).md5)))
        {
          localObject4 = new ModulePkgInfo();
          ((ModulePkgInfo)localObject4).name = ("/__plugin__/" + ((WxaAttributes.WxaPluginCodeInfo)localObject2).provider);
          ((ModulePkgInfo)localObject4).md5 = ((WxaAttributes.WxaPluginCodeInfo)this.lIv.get(i)).md5;
          ((ModulePkgInfo)localObject4).pkgPath = ((WxaPkgWrappingInfo)localObject3).pkgPath;
          ((WxaPkgWrappingInfo)localObject1).jIX.add(localObject4);
        }
        i += 1;
      }
      this.lIB.value = true;
      ad.d("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoHandler", "module rerange ok!");
      AppMethodBeat.o(174947);
      return localObject1;
    }
  }
  
  private void ud(int paramInt)
  {
    AppMethodBeat.i(174948);
    this.lIA.uq(paramInt);
    AppMethodBeat.o(174948);
  }
  
  public void bqN() {}
  
  public void bqW() {}
  
  public void onDownloadProgress(int paramInt) {}
  
  abstract class a
    implements aa.b
  {
    private int lIH = 0;
    
    private a() {}
    
    public final void a(WxaPkgLoadProgress paramWxaPkgLoadProgress)
    {
      ac.a(ac.this);
      ad.i("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoHandler", brn() + " progress=" + paramWxaPkgLoadProgress.progress);
      long l = brm();
      if (l == 0L) {
        ac.b(ac.this).set(100);
      }
      for (;;)
      {
        this.lIH = paramWxaPkgLoadProgress.progress;
        ac.c(ac.this);
        return;
        ac.b(ac.this).addAndGet(Math.round(Math.max(0, paramWxaPkgLoadProgress.progress - this.lIH) / (float)l));
      }
    }
    
    abstract long brm();
    
    abstract String brn();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ac
 * JD-Core Version:    0.7.0.1
 */