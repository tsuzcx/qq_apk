package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.f;
import com.tencent.mm.g.a.lb;
import com.tencent.mm.g.a.lb.a;
import com.tencent.mm.g.b.a.eb;
import com.tencent.mm.g.b.a.q;
import com.tencent.mm.i.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.i;
import java.util.HashMap;

public class n
  implements aw
{
  public HashMap<String, a> hzs;
  private com.tencent.mm.sdk.b.c<lb> hzt;
  
  public n()
  {
    AppMethodBeat.i(126918);
    this.hzt = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(lb paramAnonymouslb)
      {
        AppMethodBeat.i(126916);
        ad.d("MicroMsg.SubCoreMediaRpt", "get media info report event.");
        if (paramAnonymouslb == null)
        {
          AppMethodBeat.o(126916);
          return false;
        }
        String str1 = paramAnonymouslb.dpu.path;
        Object localObject2 = str1;
        Object localObject1 = str1;
        try
        {
          if (str1.endsWith(".tmp"))
          {
            localObject1 = str1;
            localObject2 = str1.substring(0, str1.lastIndexOf(".tmp"));
            localObject1 = localObject2;
            ad.i("MicroMsg.SubCoreMediaRpt", "media info event path[%s, %s]", new Object[] { localObject2, paramAnonymouslb.dpu.path });
          }
          localObject1 = localObject2;
        }
        catch (Exception localException)
        {
          label103:
          String str2;
          int i;
          String str3;
          String str4;
          long l1;
          long l2;
          String[] arrayOfString;
          int j;
          int k;
          break label103;
        }
        localObject2 = n.this;
        str1 = paramAnonymouslb.dpu.dpv;
        str2 = paramAnonymouslb.dpu.dpw;
        i = paramAnonymouslb.dpu.dpx;
        str3 = paramAnonymouslb.dpu.fileId;
        str4 = paramAnonymouslb.dpu.dpz;
        l1 = paramAnonymouslb.dpu.startTime;
        l2 = paramAnonymouslb.dpu.endTime;
        arrayOfString = paramAnonymouslb.dpu.dpy;
        j = paramAnonymouslb.dpu.dpA;
        k = paramAnonymouslb.dpu.dpB;
        paramAnonymouslb = paramAnonymouslb.dpu.dpC;
        g.afE().ax(new n.2((n)localObject2, (String)localObject1, arrayOfString, str1, str2, i, str3, str4, l1, l2, j, k, paramAnonymouslb));
        AppMethodBeat.o(126916);
        return false;
      }
    };
    this.hzs = new HashMap();
    com.tencent.mm.sdk.b.a.ESL.c(this.hzt);
    AppMethodBeat.o(126918);
  }
  
  public static n aCG()
  {
    AppMethodBeat.i(126919);
    n localn = (n)t.ap(n.class);
    AppMethodBeat.o(126919);
    return localn;
  }
  
  public final void a(final d paramd, final String paramString)
  {
    AppMethodBeat.i(126921);
    if ((paramd == null) || (bt.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(126921);
      return;
    }
    g.afE().ax(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126914);
        n.a locala = (n.a)n.a(n.this).remove(paramString);
        if (locala == null)
        {
          AppMethodBeat.o(126914);
          return;
        }
        int j = (int)i.aMN(locala.hzG);
        com.tencent.mm.plugin.sight.base.a locala2 = e.ano(locala.hzG);
        com.tencent.mm.plugin.sight.base.a locala1;
        long l1;
        if (!bt.isNullOrNil(locala.hzF))
        {
          locala1 = e.ano(locala.hzF);
          l1 = (int)i.aMN(locala.hzF);
        }
        while ((locala1 == null) || (locala2 == null))
        {
          ad.w("MicroMsg.SubCoreMediaRpt", "upload video but media info is null. %s", new Object[] { locala.hzG });
          AppMethodBeat.o(126914);
          return;
          l1 = j;
          locala1 = locala2;
        }
        int k = ay.iy(aj.getContext());
        long l2;
        if (paramd.field_startTime != 0L)
        {
          l2 = paramd.field_startTime;
          if (paramd.field_endTime == 0L) {
            break label259;
          }
        }
        label259:
        for (long l3 = paramd.field_endTime;; l3 = bt.eGO())
        {
          localObject1 = null;
          if (paramd.field_usedSvrIps == null) {
            break label274;
          }
          localObject1 = new StringBuffer();
          localObject2 = paramd.field_usedSvrIps;
          int m = localObject2.length;
          int i = 0;
          while (i < m)
          {
            ((StringBuffer)localObject1).append(localObject2[i]).append("|");
            i += 1;
          }
          l2 = locala.startTime;
          break;
        }
        Object localObject1 = ((StringBuffer)localObject1).toString();
        label274:
        Object localObject2 = new StringBuffer();
        ((StringBuffer)localObject2).append(locala.toUser).append(",").append(locala.esh).append(",");
        ((StringBuffer)localObject2).append(k).append(",").append(paramd.field_fileId).append(",");
        ((StringBuffer)localObject2).append(paramd.field_mp4identifymd5).append(",").append(com.tencent.mm.plugin.video.c.asU(locala.hzH)).append(",");
        ((StringBuffer)localObject2).append(l2).append(",").append(l3).append(",");
        ((StringBuffer)localObject2).append(l1).append(",").append(locala1.videoDuration).append(",");
        ((StringBuffer)localObject2).append(locala1.videoBitrate / 1000).append(",").append(locala1.audioBitrate / 1000).append(",");
        ((StringBuffer)localObject2).append(locala1.frameRate).append(",").append(locala1.width).append(",");
        ((StringBuffer)localObject2).append(locala1.height).append(",").append(locala.hzI).append(",");
        ((StringBuffer)localObject2).append(j).append(",").append(locala2.videoDuration).append(",");
        ((StringBuffer)localObject2).append(locala2.videoBitrate / 1000).append(",").append(locala2.audioBitrate / 1000).append(",");
        ((StringBuffer)localObject2).append(locala2.frameRate).append(",").append(locala2.width).append(",");
        ((StringBuffer)localObject2).append(locala2.height).append(",").append(locala.hzJ).append(",");
        ((StringBuffer)localObject2).append((String)localObject1).append(",").append(locala1.audioChannel).append(",").append(paramd.field_fileUrl);
        ad.i("MicroMsg.SubCoreMediaRpt", "upload video rpt %s", new Object[] { ((StringBuffer)localObject2).toString() });
        new eb(((StringBuffer)localObject2).toString()).aBj();
        n.dn(locala2.videoBitrate, locala.hzJ);
        if (locala2.vtP == 1)
        {
          ad.i("MicroMsg.SubCoreMediaRpt", "ABA: New Path %s ", new Object[] { locala.hzG });
          n.a(locala2, locala.hzJ);
        }
        AppMethodBeat.o(126914);
      }
    });
    AppMethodBeat.o(126921);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126920);
    a locala2 = (a)this.hzs.get(paramString2);
    a locala1 = locala2;
    if (locala2 == null) {
      locala1 = new a();
    }
    locala1.hzF = paramString1;
    locala1.hzG = paramString2;
    locala1.toUser = paramString3;
    locala1.esh = paramString4;
    locala1.hzH = paramString5;
    locala1.hzJ = paramInt1;
    locala1.hzI = paramInt2;
    locala1.startTime = bt.eGO();
    this.hzs.put(paramString2, locala1);
    ad.i("MicroMsg.SubCoreMediaRpt", "note video upload path[%s, %s] toUser %s msgSource %s snsInfoId %s sendScene %d cpStatus %d", new Object[] { paramString1, paramString2, paramString3, paramString4, paramString5, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(126920);
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean) {}
  
  public void onAccountRelease() {}
  
  public void onSdcardMount(boolean paramBoolean) {}
  
  public final class a
  {
    public String dpz;
    public String esh;
    public d hyW;
    public String hzF;
    public String hzG;
    public String hzH;
    public int hzI;
    public int hzJ;
    public long startTime;
    public String toUser;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvideo.n
 * JD-Core Version:    0.7.0.1
 */