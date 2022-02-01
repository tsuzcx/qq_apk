package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.h;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.ak.y;
import com.tencent.mm.b.p;
import com.tencent.mm.cn.f;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.ab;
import com.tencent.mm.plugin.appbrand.appcache.bb;
import com.tencent.mm.plugin.appbrand.appcache.bf;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.au;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaPluginCodeInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionModuleInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaWidgetInfo;
import com.tencent.mm.plugin.appbrand.z.i;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.protobuf.awi;
import com.tencent.mm.protocal.protobuf.awj;
import com.tencent.mm.protocal.protobuf.bqz;
import com.tencent.mm.protocal.protobuf.cpw;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jo;
import com.tencent.mm.protocal.protobuf.jp;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class ad
  implements x
{
  final String appId;
  List<WxaAttributes.WxaWidgetInfo> hVm;
  final int hxM;
  final int llm;
  List<WxaAttributes.WxaPluginCodeInfo> lln;
  LinkedHashMap<String, i<WxaPkgWrappingInfo>> llo;
  private final String llp;
  private final AtomicInteger llq;
  private volatile boolean llr;
  private com.tencent.mm.plugin.appbrand.launching.f.a lls;
  private PBool llt;
  List<u> llu;
  List<WxaAttributes.WxaVersionModuleInfo> moduleList;
  
  ad(String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3, List<WxaAttributes.WxaVersionModuleInfo> paramList, List<WxaAttributes.WxaPluginCodeInfo> paramList1, List<WxaAttributes.WxaWidgetInfo> paramList2, PBool paramPBool)
  {
    AppMethodBeat.i(174962);
    this.llo = new LinkedHashMap();
    this.llq = new AtomicInteger(0);
    this.llr = false;
    this.llu = new LinkedList();
    ac.i("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoModuleHandler", "appId:%s,versionType:%s,desirePkgVersion:%s,instanceId:%s,scene:%d", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2, Integer.valueOf(paramInt3) });
    this.appId = paramString1;
    this.hxM = paramInt1;
    this.llm = paramInt2;
    this.lln = paramList1;
    this.hVm = paramList2;
    this.lls = new com.tencent.mm.plugin.appbrand.launching.f.a(paramString1, paramInt2, paramInt1, paramString2, paramInt3, this.lln);
    this.llt = paramPBool;
    this.llp = paramString2;
    this.moduleList = paramList;
    AppMethodBeat.o(174962);
  }
  
  private WxaPkgWrappingInfo bcD()
  {
    AppMethodBeat.i(174963);
    Object localObject1 = new i();
    int j = 13;
    int i = j;
    Object localObject2;
    if (this.hVm != null)
    {
      i = j;
      if (this.hVm.size() > 0)
      {
        localObject2 = this.hVm.iterator();
        i = 13;
        if (((Iterator)localObject2).hasNext())
        {
          j = ((WxaAttributes.WxaWidgetInfo)((Iterator)localObject2).next()).dcj;
          if (j != 23) {
            break label2286;
          }
          i = j;
        }
      }
    }
    label1237:
    label1509:
    label1771:
    label1773:
    label2286:
    for (;;)
    {
      break;
      localObject2 = m.b(this.appId, "__APP__", i, this.llm, this.hxM);
      if (localObject2 != null)
      {
        ac.i("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoModuleHandler", "mainModulePkgInfo exists!");
        ((i)localObject1).value = localObject2;
        ac.i("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoModuleHandler", "mainModulePkgType:%d", new Object[] { Integer.valueOf(i) });
        localObject2 = (WxaPkgWrappingInfo)((i)localObject1).value;
        localObject3 = this.lln.iterator();
      }
      Object localObject5;
      Object localObject4;
      Object localObject6;
      for (;;)
      {
        if (!((Iterator)localObject3).hasNext()) {
          break label509;
        }
        localObject5 = (WxaAttributes.WxaPluginCodeInfo)((Iterator)localObject3).next();
        localObject4 = ((WxaAttributes.WxaPluginCodeInfo)localObject5).provider;
        localObject6 = ((WxaAttributes.WxaPluginCodeInfo)localObject5).md5;
        i = ((WxaAttributes.WxaPluginCodeInfo)localObject5).version;
        this.llo.put(localObject6, new i());
        localObject5 = m.b((String)localObject4, "__PLUGINCODE__", 6, i, 0);
        if (localObject5 != null)
        {
          ac.i("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoModuleHandler", "pluginPkgInfo exists!");
          ((i)this.llo.get(((WxaPkgWrappingInfo)localObject5).md5)).value = localObject5;
          tz(3);
          continue;
          localObject2 = new u();
          localObject3 = new cpw();
          ((cpw)localObject3).djj = this.appId;
          if (j.a.rq(this.hxM)) {
            ((u)localObject2).lkf = m.Oo(new ab(this.appId, "__APP__", i).toString());
          }
          ((cpw)localObject3).Een = this.hxM;
          ((cpw)localObject3).EUq = i;
          ((cpw)localObject3).EUn = "__APP__";
          ((u)localObject2).lke = ((cpw)localObject3);
          ((u)localObject2).lkg = this.llm;
          this.llu.add(localObject2);
          break;
        }
        localObject5 = new u();
        localObject6 = new cpw();
        ((cpw)localObject6).djj = ((String)localObject4);
        ((cpw)localObject6).Een = 0;
        ((cpw)localObject6).EUq = 6;
        ((u)localObject5).lke = ((cpw)localObject6);
        ((u)localObject5).lkf = m.bJ(new ab((String)localObject4, "/__plugin__/", 6).toString(), i);
        ((u)localObject5).lkg = i;
        this.llu.add(localObject5);
        ac.i("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoModuleHandler", "pluginCode localPkgVersion:%d", new Object[] { Integer.valueOf(((u)localObject5).lkf) });
      }
      label509:
      ac.i("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoModuleHandler", "todoDownloadPkgList size:%d", new Object[] { Integer.valueOf(this.llu.size()) });
      if (this.llu.size() == 0)
      {
        i = 0;
        if (i < this.lln.size())
        {
          localObject1 = (WxaAttributes.WxaPluginCodeInfo)this.lln.get(i);
          localObject3 = (i)this.llo.get(((WxaAttributes.WxaPluginCodeInfo)localObject1).md5);
          if (localObject3 == null) {
            ac.e("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoModuleHandler", "wxaPkgInfoPointer null!");
          }
          for (;;)
          {
            i += 1;
            break;
            localObject3 = (WxaPkgWrappingInfo)((i)localObject3).value;
            if (localObject3 == null)
            {
              ac.e("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoModuleHandler", "wxaPkgInfoPointer value null!");
            }
            else if (bs.isNullOrNil(((WxaAttributes.WxaPluginCodeInfo)localObject1).md5))
            {
              ac.e("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoModuleHandler", "pluginInfo md5 null!");
            }
            else
            {
              localObject4 = new ModulePkgInfo();
              ((ModulePkgInfo)localObject4).name = ("/__plugin__/" + ((WxaAttributes.WxaPluginCodeInfo)localObject1).provider);
              ((ModulePkgInfo)localObject4).md5 = ((WxaAttributes.WxaPluginCodeInfo)this.lln.get(i)).md5;
              ((ModulePkgInfo)localObject4).pkgPath = ((WxaPkgWrappingInfo)localObject3).pkgPath;
              ((WxaPkgWrappingInfo)localObject2).jpd.add(localObject4);
            }
          }
        }
        localObject1 = this.moduleList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (WxaAttributes.WxaVersionModuleInfo)((Iterator)localObject1).next();
          if (!"__APP__".equals(((WxaAttributes.WxaVersionModuleInfo)localObject3).name))
          {
            localObject3 = au.a((WxaAttributes.WxaVersionModuleInfo)localObject3);
            ((WxaPkgWrappingInfo)localObject2).jpd.add(localObject3);
          }
        }
        this.llt.value = true;
        AppMethodBeat.o(174963);
        return localObject2;
      }
      localObject2 = new jo();
      Object localObject3 = this.llu.iterator();
      Object localObject7;
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (u)((Iterator)localObject3).next();
        localObject5 = ((u)localObject4).lke;
        localObject6 = new bqz();
        ((bqz)localObject6).Eeo = ((u)localObject4).lkf;
        ((bqz)localObject6).EWm = 0;
        localObject7 = new awi();
        ((awi)localObject7).EOl = ((cpw)localObject5);
        ((awi)localObject7).EOm = ((bqz)localObject6);
        ((awi)localObject7).EOn = 0;
        ((awi)localObject7).Eeo = ((u)localObject4).lkg;
        String str;
        if (((cpw)localObject5).Een == 1) {
          str = ((t)j.T(t.class)).bK(this.appId, this.hxM);
        }
        try
        {
          long l = h.tT(str).optLong("dev_key");
          ((awi)localObject7).EOq = new p(l).intValue();
          ac.d("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoModuleHandler", "uinL:%d", new Object[] { Long.valueOf(l) });
          if (((cpw)localObject5).Een == 0)
          {
            ((awi)localObject7).EOp = true;
            ((jo)localObject2).DXf.add(localObject7);
            localObject7 = new awi();
            ((awi)localObject7).EOl = ((cpw)localObject5);
            ((awi)localObject7).EOm = ((bqz)localObject6);
            ((awi)localObject7).EOn = 0;
            ((awi)localObject7).Eeo = ((u)localObject4).lkg;
            ((awi)localObject7).EOp = false;
            ((jo)localObject2).DXf.add(localObject7);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ac.e("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoModuleHandler", "opt devKey %s", new Object[] { localException });
          }
          ((awi)localObject7).EOp = false;
          ((jo)localObject2).DXf.add(localObject7);
        }
      }
      localObject2 = y.a(new com.tencent.mm.plugin.appbrand.appcache.g((jo)localObject2));
      if ((localObject2 == null) || (((c.a)localObject2).errType != 0) || (((c.a)localObject2).errCode != 0))
      {
        if (localObject2 == null)
        {
          i = -1;
          if (localObject2 != null) {
            break label1237;
          }
        }
        for (j = -1;; j = ((c.a)localObject2).errCode)
        {
          ac.e("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoModuleHandler", " cgi failed, %d %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          AppMethodBeat.o(174963);
          return null;
          i = ((c.a)localObject2).errType;
          break;
        }
      }
      ac.d("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoModuleHandler", "back.resp.resp_list size:%d", new Object[] { Integer.valueOf(((jp)((c.a)localObject2).hvj).DXg.size()) });
      localObject2 = ((jp)((c.a)localObject2).hvj).DXg.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject8 = (awj)((Iterator)localObject2).next();
        if (((awj)localObject8).dfm == 0)
        {
          localObject3 = ((awj)localObject8).md5;
          localObject4 = ((awj)localObject8).url;
          localObject5 = ((awj)localObject8).EOl;
          localObject6 = ((cpw)localObject5).djj;
          localObject7 = ((cpw)localObject5).EUn;
          i = ((cpw)localObject5).EUq;
          j = ((cpw)localObject5).Een;
          int k = ((awj)localObject8).Eeo;
          boolean bool1 = ((awj)localObject8).EOr;
          boolean bool2 = ((awj)localObject8).EOs;
          ac.i("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoModuleHandler", "appid:%s,modulename:%s,pkgType:%d,md5:%s,url:%s,isPatch:%b,isZstd:%b", new Object[] { localObject6, localObject7, Integer.valueOf(i), localObject3, localObject4, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          if (j == 0)
          {
            localObject8 = new eaf();
            ((eaf)localObject8).Ggi = ((String)localObject3);
            ((eaf)localObject8).Eae = k;
            j.aVC().a(new ab((String)localObject6, (String)localObject7, i).toString(), (eaf)localObject8);
            localObject6 = this.llu.iterator();
          }
          for (;;)
          {
            if (!((Iterator)localObject6).hasNext()) {
              break label1796;
            }
            localObject7 = (u)((Iterator)localObject6).next();
            localObject8 = ((u)localObject7).lke;
            if ((localObject8 != null) && (localObject5 != null))
            {
              j = 0;
              if ((bs.isNullOrNil(((cpw)localObject8).EUn)) && (bs.isNullOrNil(((cpw)localObject5).EUn)))
              {
                i = 1;
                if ((!((cpw)localObject8).djj.equals(((cpw)localObject5).djj)) || (((cpw)localObject8).EUq != ((cpw)localObject5).EUq) || (i == 0) || (((cpw)localObject8).Een != ((cpw)localObject5).Een)) {
                  break label1763;
                }
                i = 1;
              }
            }
            for (;;)
            {
              if (i == 0) {
                break label1771;
              }
              ((u)localObject7).md5 = ((String)localObject3);
              if (!bool1) {
                break label1773;
              }
              ((u)localObject7).lkj = ((String)localObject4);
              break label1509;
              localObject6 = j.aVC().a(new ab(this.appId, (String)localObject7, i).toString(), j, new String[] { "versionMd5", "downloadURL" });
              ((bb)localObject6).field_versionMd5 = ((String)localObject3);
              if (localObject6 == null) {
                break;
              }
              j.aVC().e((bb)localObject6);
              break;
              i = j;
              if (bs.isNullOrNil(((cpw)localObject8).EUn)) {
                break label1574;
              }
              i = j;
              if (bs.isNullOrNil(((cpw)localObject5).EUn)) {
                break label1574;
              }
              i = j;
              if (!((cpw)localObject8).EUn.equals(((cpw)localObject5).EUn)) {
                break label1574;
              }
              i = 1;
              break label1574;
              i = 0;
              continue;
              i = 0;
            }
            continue;
            if (bool2) {
              ((u)localObject7).lki = ((String)localObject4);
            } else {
              ((u)localObject7).lkh = ((String)localObject4);
            }
          }
        }
        else
        {
          ac.e("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoModuleHandler", "batch cgi error errcode:%d!", new Object[] { Integer.valueOf(((awj)localObject8).dfm) });
        }
      }
      localObject2 = new CountDownLatch(this.llu.size());
      localObject3 = this.llu.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (u)((Iterator)localObject3).next();
        localObject5 = aa.c.a((u)localObject4);
        ((aa)localObject5).a(k.Om(this.llp));
        ((aa)localObject5).a(new aa.e()
        {
          public final void bnw()
          {
            AppMethodBeat.i(174955);
            if (this.llv.lke.EUq == 6) {
              ad.a(ad.this, 3);
            }
            ac.i("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoModuleHandler", "plugin already downloaded, engineId[%s] version[%d]", new Object[] { this.llv.lke.djj, Integer.valueOf(this.llv.lke.Een) });
            AppMethodBeat.o(174955);
          }
          
          public final void bnx()
          {
            AppMethodBeat.i(174956);
            if (this.llv.lke.EUq == 6) {
              ad.a(ad.this, 4);
            }
            ac.d("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoModuleHandler", "onPatchDownload");
            AppMethodBeat.o(174956);
          }
          
          public final void bny()
          {
            AppMethodBeat.i(174957);
            ac.i("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoModuleHandler", "onIntegrateDownload");
            if (this.llv.lke.EUq == 6) {
              ad.a(ad.this, 2);
            }
            AppMethodBeat.o(174957);
          }
          
          public final void c(WxaPkgWrappingInfo paramAnonymousWxaPkgWrappingInfo)
          {
            AppMethodBeat.i(174958);
            if (paramAnonymousWxaPkgWrappingInfo != null)
            {
              if (ad.this.llo.containsKey(paramAnonymousWxaPkgWrappingInfo.md5))
              {
                ((i)ad.this.llo.get(paramAnonymousWxaPkgWrappingInfo.md5)).value = paramAnonymousWxaPkgWrappingInfo;
                com.tencent.mm.cn.g.fBc().i(new com.tencent.mm.vending.c.a() {}).fxo();
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
              ac.i("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoModuleHandler", "downloadPkgInfo :%s", new Object[] { paramAnonymousWxaPkgWrappingInfo });
              AppMethodBeat.o(174958);
              return;
              this.llx.value = paramAnonymousWxaPkgWrappingInfo;
              break;
            }
          }
          
          public final void d(WxaPkgWrappingInfo paramAnonymousWxaPkgWrappingInfo)
          {
            AppMethodBeat.i(174959);
            if (paramAnonymousWxaPkgWrappingInfo != null)
            {
              if (ad.this.llo.containsKey(paramAnonymousWxaPkgWrappingInfo.md5))
              {
                ad.tB(0);
                AppMethodBeat.o(174959);
                return;
              }
              ad.tB(9);
              AppMethodBeat.o(174959);
              return;
            }
            if (ad.this.llo.containsKey(this.llv.md5))
            {
              ad.tB(1);
              AppMethodBeat.o(174959);
              return;
            }
            ad.tB(10);
            AppMethodBeat.o(174959);
          }
        });
        ((aa)localObject5).a(new a((CountDownLatch)localObject2, (u)localObject4)
        {
          final String bnA()
          {
            AppMethodBeat.i(174961);
            String str = "appId=" + ad.this.appId + " provider=" + this.llv.lke.djj;
            AppMethodBeat.o(174961);
            return str;
          }
          
          final long bnz()
          {
            AppMethodBeat.i(174960);
            long l = this.val$latch.getCount();
            AppMethodBeat.o(174960);
            return l;
          }
        });
        ((aa)localObject5).prepareAsync();
      }
      ((CountDownLatch)localObject2).await();
      ac.i("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoModuleHandler", "both downloaded");
      if (this.llr) {
        bnk();
      }
      if ((((i)localObject1).value == null) || (this.llo.size() <= 0))
      {
        ac.i("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoModuleHandler", "mainModule value or pluginCodeList result null!!");
        AppMethodBeat.o(174963);
        return null;
      }
      this.lls.report();
      localObject1 = (WxaPkgWrappingInfo)((i)localObject1).value;
      i = 0;
      while (i < this.lln.size())
      {
        localObject2 = (WxaAttributes.WxaPluginCodeInfo)this.lln.get(i);
        localObject3 = (WxaPkgWrappingInfo)((i)this.llo.get(((WxaAttributes.WxaPluginCodeInfo)this.lln.get(i)).md5)).value;
        if ((localObject3 != null) && (!bs.isNullOrNil(((WxaAttributes.WxaPluginCodeInfo)this.lln.get(i)).md5)))
        {
          localObject4 = new ModulePkgInfo();
          ((ModulePkgInfo)localObject4).name = ("/__plugin__/" + ((WxaAttributes.WxaPluginCodeInfo)localObject2).provider);
          ((ModulePkgInfo)localObject4).md5 = ((WxaAttributes.WxaPluginCodeInfo)this.lln.get(i)).md5;
          ((ModulePkgInfo)localObject4).pkgPath = ((WxaPkgWrappingInfo)localObject3).pkgPath;
          ((WxaPkgWrappingInfo)localObject1).jpd.add(localObject4);
        }
        i += 1;
      }
      localObject2 = this.moduleList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (WxaAttributes.WxaVersionModuleInfo)((Iterator)localObject2).next();
        if (!"__APP__".equals(((WxaAttributes.WxaVersionModuleInfo)localObject3).name))
        {
          localObject3 = au.a((WxaAttributes.WxaVersionModuleInfo)localObject3);
          ((WxaPkgWrappingInfo)localObject1).jpd.add(localObject3);
        }
      }
      this.llt.value = true;
      ac.d("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoModuleHandler", "module rerange ok!");
      AppMethodBeat.o(174963);
      return localObject1;
    }
  }
  
  private void tz(int paramInt)
  {
    AppMethodBeat.i(174964);
    this.lls.tM(paramInt);
    AppMethodBeat.o(174964);
  }
  
  public void bnc() {}
  
  public void bnk() {}
  
  public void onDownloadProgress(int paramInt) {}
  
  abstract class a
    implements aa.b
  {
    private int llz = 0;
    
    private a() {}
    
    public final void a(WxaPkgLoadProgress paramWxaPkgLoadProgress)
    {
      ad.a(ad.this);
      ac.i("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoModuleHandler", bnA() + " progress=" + paramWxaPkgLoadProgress.progress);
      long l = bnz();
      if (l == 0L) {
        ad.b(ad.this).set(100);
      }
      for (;;)
      {
        this.llz = paramWxaPkgLoadProgress.progress;
        ad.c(ad.this);
        return;
        ad.b(ad.this).addAndGet(Math.round(Math.max(0, paramWxaPkgLoadProgress.progress - this.llz) / (float)l));
      }
    }
    
    abstract String bnA();
    
    abstract long bnz();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ad
 * JD-Core Version:    0.7.0.1
 */