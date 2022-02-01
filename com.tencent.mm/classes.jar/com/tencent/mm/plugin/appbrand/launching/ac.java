package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.h;
import com.tencent.mm.ak.a.a;
import com.tencent.mm.ak.y;
import com.tencent.mm.b.p;
import com.tencent.mm.cm.f;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.ad;
import com.tencent.mm.plugin.appbrand.appcache.bd;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaPluginCodeInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaWidgetInfo;
import com.tencent.mm.plugin.appbrand.launching.report.c;
import com.tencent.mm.plugin.appbrand.y.i;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.protobuf.baw;
import com.tencent.mm.protocal.protobuf.bax;
import com.tencent.mm.protocal.protobuf.bwg;
import com.tencent.mm.protocal.protobuf.cvv;
import com.tencent.mm.protocal.protobuf.eia;
import com.tencent.mm.protocal.protobuf.jx;
import com.tencent.mm.protocal.protobuf.jy;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
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
  final int hSZ;
  List<WxaAttributes.WxaWidgetInfo> irC;
  final int lMU;
  List<WxaAttributes.WxaPluginCodeInfo> lMV;
  LinkedHashMap<String, i<WxaPkgWrappingInfo>> lMW;
  private final String lMX;
  private final AtomicInteger lMY;
  private volatile boolean lMZ;
  private c lNa;
  private PBool lNb;
  List<u> lNc;
  
  ac(String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3, List<WxaAttributes.WxaPluginCodeInfo> paramList, List<WxaAttributes.WxaWidgetInfo> paramList1, PBool paramPBool)
  {
    AppMethodBeat.i(174946);
    this.lMW = new LinkedHashMap();
    this.lMY = new AtomicInteger(0);
    this.lMZ = false;
    this.lNc = new LinkedList();
    ae.i("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoHandler", "appId:%s,versionType:%s,desirePkgVersion:%s,instanceId:%s,scene:%d", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2, Integer.valueOf(paramInt3) });
    this.appId = paramString1;
    this.hSZ = paramInt1;
    this.lMU = paramInt2;
    this.lMV = paramList;
    this.irC = paramList1;
    this.lNa = new c(paramString1, paramInt2, paramInt1, paramString2, paramInt3, this.lMV);
    this.lNb = paramPBool;
    this.lMX = paramString2;
    AppMethodBeat.o(174946);
  }
  
  private WxaPkgWrappingInfo bgP()
  {
    AppMethodBeat.i(174947);
    Object localObject1 = new i();
    int j = 12;
    int i = j;
    Object localObject2;
    if (this.irC != null)
    {
      i = j;
      if (this.irC.size() > 0)
      {
        localObject2 = this.irC.iterator();
        i = 12;
        if (((Iterator)localObject2).hasNext())
        {
          j = ((WxaAttributes.WxaWidgetInfo)((Iterator)localObject2).next()).doK;
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
      localObject2 = m.b(this.appId, "__WITHOUT_MULTI_PLUGINCODE__", i, this.lMU, this.hSZ);
      if (localObject2 != null)
      {
        ae.i("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoHandler", "mainModulePkgInfo exists!");
        ((i)localObject1).value = localObject2;
        ae.i("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoHandler", "mainModulePkgType:%d", new Object[] { Integer.valueOf(i) });
        localObject2 = (WxaPkgWrappingInfo)((i)localObject1).value;
        localObject3 = this.lMV.iterator();
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
        this.lMW.put(localObject6, new i());
        localObject5 = m.b((String)localObject4, "__PLUGINCODE__", 6, i, 0);
        if (localObject5 != null)
        {
          ae.i("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoHandler", "pluginPkgInfo exists!");
          ((i)this.lMW.get(((WxaPkgWrappingInfo)localObject5).md5)).value = localObject5;
          uj(3);
          continue;
          localObject2 = new u();
          localObject3 = new cvv();
          ((cvv)localObject3).dwb = this.appId;
          if (j.a.rT(this.hSZ)) {
            ((u)localObject2).lLN = m.Sv(new ad(this.appId, "__WITHOUT_MULTI_PLUGINCODE__", i).toString());
          }
          ((cvv)localObject3).Gdl = this.hSZ;
          ((cvv)localObject3).GXq = i;
          ((u)localObject2).lLM = ((cvv)localObject3);
          ((u)localObject2).lLO = this.lMU;
          this.lNc.add(localObject2);
          break;
        }
        localObject5 = new u();
        localObject6 = new cvv();
        ((cvv)localObject6).dwb = ((String)localObject4);
        ((cvv)localObject6).Gdl = 0;
        ((cvv)localObject6).GXq = 6;
        ((u)localObject5).lLM = ((cvv)localObject6);
        ((u)localObject5).lLN = m.bP(new ad((String)localObject4, "/__plugin__/", 6).toString(), i);
        ((u)localObject5).lLO = i;
        this.lNc.add(localObject5);
        ae.i("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoHandler", "pluginCode localPkgVersion:%d", new Object[] { Integer.valueOf(((u)localObject5).lLN) });
      }
      label501:
      ae.i("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoHandler", "todoDownloadPkgList size:%d", new Object[] { Integer.valueOf(this.lNc.size()) });
      if (this.lNc.size() == 0)
      {
        i = 0;
        if (i < this.lMV.size())
        {
          localObject1 = (WxaAttributes.WxaPluginCodeInfo)this.lMV.get(i);
          localObject3 = (i)this.lMW.get(((WxaAttributes.WxaPluginCodeInfo)localObject1).md5);
          if (localObject3 == null) {
            ae.e("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoHandler", "wxaPkgInfoPointer null!");
          }
          for (;;)
          {
            i += 1;
            break;
            localObject3 = (WxaPkgWrappingInfo)((i)localObject3).value;
            if (localObject3 == null)
            {
              ae.e("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoHandler", "wxaPkgInfoPointer value null!");
            }
            else if (bu.isNullOrNil(((WxaAttributes.WxaPluginCodeInfo)localObject1).md5))
            {
              ae.e("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoHandler", "pluginInfo md5 null!");
            }
            else
            {
              localObject4 = new ModulePkgInfo();
              ((ModulePkgInfo)localObject4).name = ("/__plugin__/" + ((WxaAttributes.WxaPluginCodeInfo)localObject1).provider);
              ((ModulePkgInfo)localObject4).md5 = ((WxaAttributes.WxaPluginCodeInfo)this.lMV.get(i)).md5;
              ((ModulePkgInfo)localObject4).pkgPath = ((WxaPkgWrappingInfo)localObject3).pkgPath;
              ((WxaPkgWrappingInfo)localObject2).jLY.add(localObject4);
            }
          }
        }
        this.lNb.value = true;
        AppMethodBeat.o(174947);
        return localObject2;
      }
      localObject2 = new jx();
      Object localObject3 = this.lNc.iterator();
      Object localObject7;
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (u)((Iterator)localObject3).next();
        localObject5 = ((u)localObject4).lLM;
        localObject6 = new bwg();
        ((bwg)localObject6).Gdm = ((u)localObject4).lLN;
        ((bwg)localObject6).GZl = 0;
        localObject7 = new baw();
        ((baw)localObject7).GQP = ((cvv)localObject5);
        ((baw)localObject7).GQQ = ((bwg)localObject6);
        ((baw)localObject7).GQR = 0;
        ((baw)localObject7).Gdm = ((u)localObject4).lLO;
        String str;
        if (((cvv)localObject5).Gdl == 1) {
          str = ((t)j.T(t.class)).bQ(this.appId, this.hSZ);
        }
        try
        {
          long l = h.xs(str).optLong("dev_key");
          ((baw)localObject7).GQU = new p(l).intValue();
          ae.d("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoHandler", "uinL:%d", new Object[] { Long.valueOf(l) });
          if (((cvv)localObject5).Gdl == 0)
          {
            ((baw)localObject7).GQT = true;
            ((jx)localObject2).FUW.add(localObject7);
            localObject7 = new baw();
            ((baw)localObject7).GQP = ((cvv)localObject5);
            ((baw)localObject7).GQQ = ((bwg)localObject6);
            ((baw)localObject7).GQR = 0;
            ((baw)localObject7).Gdm = ((u)localObject4).lLO;
            ((baw)localObject7).GQT = false;
            ((jx)localObject2).FUW.add(localObject7);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ae.e("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoHandler", "opt devKey %s", new Object[] { localException });
          }
          ((baw)localObject7).GQT = false;
          ((jx)localObject2).FUW.add(localObject7);
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
          ae.e("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoHandler", " cgi failed, %d %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          AppMethodBeat.o(174947);
          return null;
          i = ((a.a)localObject2).errType;
          break;
        }
      }
      ae.d("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoHandler", "back.resp.resp_list size:%d", new Object[] { Integer.valueOf(((jy)((a.a)localObject2).hQv).FUX.size()) });
      localObject2 = ((jy)((a.a)localObject2).hQv).FUX.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject8 = (bax)((Iterator)localObject2).next();
        if (((bax)localObject8).drN == 0)
        {
          localObject3 = ((bax)localObject8).md5;
          localObject4 = ((bax)localObject8).url;
          localObject5 = ((bax)localObject8).GQP;
          localObject6 = ((cvv)localObject5).dwb;
          localObject7 = ((cvv)localObject5).GXn;
          i = ((cvv)localObject5).GXq;
          j = ((cvv)localObject5).Gdl;
          int k = ((bax)localObject8).Gdm;
          boolean bool1 = ((bax)localObject8).GQV;
          boolean bool2 = ((bax)localObject8).GQW;
          ae.i("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoHandler", "appid:%s,pkgType:%d,md5:%s,url:%s,isPatch:%b,isZstd:%b", new Object[] { localObject6, Integer.valueOf(i), localObject3, localObject4, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          if (j == 0)
          {
            localObject8 = new eia();
            ((eia)localObject8).IlC = ((String)localObject3);
            ((eia)localObject8).FYj = k;
            j.aZu().a(new ad((String)localObject6, (String)localObject7, i).toString(), (eia)localObject8);
            localObject6 = this.lNc.iterator();
          }
          for (;;)
          {
            if (!((Iterator)localObject6).hasNext()) {
              break label1714;
            }
            localObject7 = (u)((Iterator)localObject6).next();
            localObject8 = ((u)localObject7).lLM;
            if ((localObject8 != null) && (localObject5 != null))
            {
              j = 0;
              if ((bu.isNullOrNil(((cvv)localObject8).GXn)) && (bu.isNullOrNil(((cvv)localObject5).GXn)))
              {
                i = 1;
                if ((!((cvv)localObject8).dwb.equals(((cvv)localObject5).dwb)) || (((cvv)localObject8).GXq != ((cvv)localObject5).GXq) || (i == 0) || (((cvv)localObject8).Gdl != ((cvv)localObject5).Gdl)) {
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
              ((u)localObject7).lLR = ((String)localObject4);
              break label1427;
              localObject6 = j.aZu().a(new ad(this.appId, (String)localObject7, i).toString(), j, new String[] { "versionMd5", "downloadURL" });
              ((bd)localObject6).field_versionMd5 = ((String)localObject3);
              if (localObject6 == null) {
                break;
              }
              j.aZu().e((bd)localObject6);
              break;
              i = j;
              if (bu.isNullOrNil(((cvv)localObject8).GXn)) {
                break label1492;
              }
              i = j;
              if (bu.isNullOrNil(((cvv)localObject5).GXn)) {
                break label1492;
              }
              i = j;
              if (!((cvv)localObject8).GXn.equals(((cvv)localObject5).GXn)) {
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
              ((u)localObject7).lLQ = ((String)localObject4);
            } else {
              ((u)localObject7).lLP = ((String)localObject4);
            }
          }
        }
        else
        {
          ae.e("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoHandler", "batch cgi error errcode:%d!", new Object[] { Integer.valueOf(((bax)localObject8).drN) });
        }
      }
      localObject2 = new CountDownLatch(this.lNc.size());
      localObject3 = this.lNc.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (u)((Iterator)localObject3).next();
        localObject5 = aa.c.a((u)localObject4);
        ((aa)localObject5).a(k.St(this.lMX));
        ((aa)localObject5).a(new a((CountDownLatch)localObject2, (u)localObject4)
        {
          final long brX()
          {
            AppMethodBeat.i(174938);
            long l = this.val$latch.getCount();
            AppMethodBeat.o(174938);
            return l;
          }
          
          final String brY()
          {
            AppMethodBeat.i(174939);
            String str = "appId=" + this.lNd.lLM.dwb + " packgeType=" + this.lNd.lLM.GXq;
            AppMethodBeat.o(174939);
            return str;
          }
        });
        ((aa)localObject5).a(new aa.e()
        {
          public final void brT()
          {
            AppMethodBeat.i(174941);
            if (this.lNd.lLM.GXq == 6) {
              ac.a(ac.this, 3);
            }
            ae.i("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoHandler", "plugin already downloaded, engineId[%s] version[%d]", new Object[] { this.lNd.lLM.dwb, Integer.valueOf(this.lNd.lLM.Gdl) });
            AppMethodBeat.o(174941);
          }
          
          public final void brU()
          {
            AppMethodBeat.i(174942);
            if (this.lNd.lLM.GXq == 6) {
              ac.a(ac.this, 4);
            }
            ae.i("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoHandler", "onPatchDownload");
            AppMethodBeat.o(174942);
          }
          
          public final void brV()
          {
            AppMethodBeat.i(174943);
            ae.i("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoHandler", "onIntegrateDownload");
            if (this.lNd.lLM.GXq == 6) {
              ac.a(ac.this, 2);
            }
            AppMethodBeat.o(174943);
          }
          
          public final void c(WxaPkgWrappingInfo paramAnonymousWxaPkgWrappingInfo)
          {
            AppMethodBeat.i(174944);
            if (paramAnonymousWxaPkgWrappingInfo != null)
            {
              if (ac.this.lMW.containsKey(paramAnonymousWxaPkgWrappingInfo.md5))
              {
                ((i)ac.this.lMW.get(paramAnonymousWxaPkgWrappingInfo.md5)).value = paramAnonymousWxaPkgWrappingInfo;
                com.tencent.mm.cm.g.fWL().i(new a() {}).fSw();
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
              ae.i("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoHandler", "downloadPkgInfo :%s", new Object[] { paramAnonymousWxaPkgWrappingInfo });
              AppMethodBeat.o(174944);
              return;
              this.lNf.value = paramAnonymousWxaPkgWrappingInfo;
              break;
            }
          }
          
          public final void d(WxaPkgWrappingInfo paramAnonymousWxaPkgWrappingInfo)
          {
            AppMethodBeat.i(174945);
            if (paramAnonymousWxaPkgWrappingInfo != null)
            {
              if (ac.this.lMW.containsKey(paramAnonymousWxaPkgWrappingInfo.md5))
              {
                ac.uk(0);
                AppMethodBeat.o(174945);
                return;
              }
              ac.uk(7);
              AppMethodBeat.o(174945);
              return;
            }
            if (ac.this.lMW.containsKey(this.lNd.md5))
            {
              ac.uk(1);
              AppMethodBeat.o(174945);
              return;
            }
            ac.uk(8);
            AppMethodBeat.o(174945);
          }
        });
        ((aa)localObject5).prepareAsync();
      }
      ((CountDownLatch)localObject2).await();
      ae.i("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoHandler", "both downloaded");
      if (this.lMZ) {
        brG();
      }
      if ((((i)localObject1).value == null) || (this.lMW.size() <= 0))
      {
        ae.i("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoHandler", "mainModule value or pluginCodeList result null!!");
        AppMethodBeat.o(174947);
        return null;
      }
      this.lNa.report();
      localObject1 = (WxaPkgWrappingInfo)((i)localObject1).value;
      i = 0;
      while (i < this.lMV.size())
      {
        localObject2 = (WxaAttributes.WxaPluginCodeInfo)this.lMV.get(i);
        localObject3 = (WxaPkgWrappingInfo)((i)this.lMW.get(((WxaAttributes.WxaPluginCodeInfo)this.lMV.get(i)).md5)).value;
        if ((localObject3 != null) && (!bu.isNullOrNil(((WxaAttributes.WxaPluginCodeInfo)this.lMV.get(i)).md5)))
        {
          localObject4 = new ModulePkgInfo();
          ((ModulePkgInfo)localObject4).name = ("/__plugin__/" + ((WxaAttributes.WxaPluginCodeInfo)localObject2).provider);
          ((ModulePkgInfo)localObject4).md5 = ((WxaAttributes.WxaPluginCodeInfo)this.lMV.get(i)).md5;
          ((ModulePkgInfo)localObject4).pkgPath = ((WxaPkgWrappingInfo)localObject3).pkgPath;
          ((WxaPkgWrappingInfo)localObject1).jLY.add(localObject4);
        }
        i += 1;
      }
      this.lNb.value = true;
      ae.d("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoHandler", "module rerange ok!");
      AppMethodBeat.o(174947);
      return localObject1;
    }
  }
  
  private void uj(int paramInt)
  {
    AppMethodBeat.i(174948);
    this.lNa.uw(paramInt);
    AppMethodBeat.o(174948);
  }
  
  public void brG() {}
  
  public void brx() {}
  
  public void onDownloadProgress(int paramInt) {}
  
  abstract class a
    implements aa.b
  {
    private int lNh = 0;
    
    private a() {}
    
    public final void a(WxaPkgLoadProgress paramWxaPkgLoadProgress)
    {
      ac.a(ac.this);
      ae.i("MicroMsg.AppBrand.LaunchCheckMultiPkgInfoHandler", brY() + " progress=" + paramWxaPkgLoadProgress.progress);
      long l = brX();
      if (l == 0L) {
        ac.b(ac.this).set(100);
      }
      for (;;)
      {
        this.lNh = paramWxaPkgLoadProgress.progress;
        ac.c(ac.this);
        return;
        ac.b(ac.this).addAndGet(Math.round(Math.max(0, paramWxaPkgLoadProgress.progress - this.lNh) / (float)l));
      }
    }
    
    abstract long brX();
    
    abstract String brY();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ac
 * JD-Core Version:    0.7.0.1
 */