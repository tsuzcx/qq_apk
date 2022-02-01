package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.f;
import com.tencent.mm.g.a.lu;
import com.tencent.mm.g.a.lu.a;
import com.tencent.mm.g.b.a.gu;
import com.tencent.mm.g.b.a.v;
import com.tencent.mm.i.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.o;
import java.util.HashMap;

public class n
  implements com.tencent.mm.model.az
{
  public HashMap<String, a> iwi;
  private com.tencent.mm.sdk.b.c<lu> iwj;
  
  public n()
  {
    AppMethodBeat.i(126918);
    this.iwj = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(lu paramAnonymouslu)
      {
        AppMethodBeat.i(126916);
        ae.d("MicroMsg.SubCoreMediaRpt", "get media info report event.");
        if (paramAnonymouslu == null)
        {
          AppMethodBeat.o(126916);
          return false;
        }
        String str1 = paramAnonymouslu.dzY.path;
        Object localObject2 = str1;
        Object localObject1 = str1;
        try
        {
          if (str1.endsWith(".tmp"))
          {
            localObject1 = str1;
            localObject2 = str1.substring(0, str1.lastIndexOf(".tmp"));
            localObject1 = localObject2;
            ae.i("MicroMsg.SubCoreMediaRpt", "media info event path[%s, %s]", new Object[] { localObject2, paramAnonymouslu.dzY.path });
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
        str1 = paramAnonymouslu.dzY.dzZ;
        str2 = paramAnonymouslu.dzY.dAa;
        i = paramAnonymouslu.dzY.dAb;
        str3 = paramAnonymouslu.dzY.fileId;
        str4 = paramAnonymouslu.dzY.dAd;
        l1 = paramAnonymouslu.dzY.startTime;
        l2 = paramAnonymouslu.dzY.endTime;
        arrayOfString = paramAnonymouslu.dzY.dAc;
        j = paramAnonymouslu.dzY.dAe;
        k = paramAnonymouslu.dzY.dAf;
        paramAnonymouslu = paramAnonymouslu.dzY.dAg;
        g.ajU().aw(new n.2((n)localObject2, (String)localObject1, arrayOfString, str1, str2, i, str3, str4, l1, l2, j, k, paramAnonymouslu));
        AppMethodBeat.o(126916);
        return false;
      }
    };
    this.iwi = new HashMap();
    com.tencent.mm.sdk.b.a.IvT.c(this.iwj);
    AppMethodBeat.o(126918);
  }
  
  public static n aNf()
  {
    AppMethodBeat.i(126919);
    n localn = (n)u.ap(n.class);
    AppMethodBeat.o(126919);
    return localn;
  }
  
  public final int Hw(String paramString)
  {
    AppMethodBeat.i(217480);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(217480);
      return 0;
    }
    paramString = (a)this.iwi.get(paramString);
    if (paramString != null)
    {
      int i = paramString.iwz;
      AppMethodBeat.o(217480);
      return i;
    }
    AppMethodBeat.o(217480);
    return 0;
  }
  
  public final void a(final d paramd, final String paramString)
  {
    AppMethodBeat.i(126921);
    if ((paramd == null) || (bu.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(126921);
      return;
    }
    g.ajU().aw(new Runnable()
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
        int j = (int)o.aZR(locala.iww);
        com.tencent.mm.plugin.sight.base.a locala2 = e.ayN(locala.iww);
        com.tencent.mm.plugin.sight.base.a locala1;
        long l1;
        if (!bu.isNullOrNil(locala.iwv))
        {
          locala1 = e.ayN(locala.iwv);
          l1 = (int)o.aZR(locala.iwv);
        }
        while ((locala1 == null) || (locala2 == null))
        {
          ae.w("MicroMsg.SubCoreMediaRpt", "upload video but media info is null. %s", new Object[] { locala.iww });
          AppMethodBeat.o(126914);
          return;
          l1 = j;
          locala1 = locala2;
        }
        int k = com.tencent.mm.sdk.platformtools.az.iY(ak.getContext());
        long l2;
        if (paramd.field_startTime != 0L)
        {
          l2 = paramd.field_startTime;
          if (paramd.field_endTime == 0L) {
            break label259;
          }
        }
        label259:
        for (long l3 = paramd.field_endTime;; l3 = bu.fpO())
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
        ((StringBuffer)localObject2).append(locala.toUser).append(",").append(locala.eNd).append(",");
        ((StringBuffer)localObject2).append(k).append(",").append(paramd.field_fileId).append(",");
        ((StringBuffer)localObject2).append(paramd.field_mp4identifymd5).append(",").append(com.tencent.mm.plugin.video.c.aEB(locala.iwx)).append(",");
        ((StringBuffer)localObject2).append(l2).append(",").append(l3).append(",");
        ((StringBuffer)localObject2).append(l1).append(",").append(locala1.videoDuration).append(",");
        ((StringBuffer)localObject2).append(locala1.videoBitrate / 1000).append(",").append(locala1.audioBitrate / 1000).append(",");
        ((StringBuffer)localObject2).append(locala1.frameRate).append(",").append(locala1.width).append(",");
        ((StringBuffer)localObject2).append(locala1.height).append(",").append(locala.iwy).append(",");
        ((StringBuffer)localObject2).append(j).append(",").append(locala2.videoDuration).append(",");
        ((StringBuffer)localObject2).append(locala2.videoBitrate / 1000).append(",").append(locala2.audioBitrate / 1000).append(",");
        ((StringBuffer)localObject2).append(locala2.frameRate).append(",").append(locala2.width).append(",");
        ((StringBuffer)localObject2).append(locala2.height).append(",").append(locala.iwz).append(",");
        ((StringBuffer)localObject2).append((String)localObject1).append(",").append(locala1.audioChannel).append(",").append(paramd.field_fileUrl);
        ae.i("MicroMsg.SubCoreMediaRpt", "upload video rpt %s", new Object[] { ((StringBuffer)localObject2).toString() });
        new gu(((StringBuffer)localObject2).toString()).aLH();
        n.dp(locala2.videoBitrate, locala.iwz);
        if (locala2.yhs == 1)
        {
          ae.i("MicroMsg.SubCoreMediaRpt", "ABA: New Path %s ", new Object[] { locala.iww });
          n.a(locala2, locala.iwz);
        }
        AppMethodBeat.o(126914);
      }
    });
    AppMethodBeat.o(126921);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126920);
    a locala2 = (a)this.iwi.get(paramString2);
    a locala1 = locala2;
    if (locala2 == null) {
      locala1 = new a();
    }
    locala1.iwv = paramString1;
    locala1.iww = paramString2;
    locala1.toUser = paramString3;
    locala1.eNd = paramString4;
    locala1.iwx = paramString5;
    locala1.iwz = paramInt1;
    locala1.iwy = paramInt2;
    locala1.startTime = bu.fpO();
    this.iwi.put(paramString2, locala1);
    ae.i("MicroMsg.SubCoreMediaRpt", "note video upload path[%s, %s] toUser %s msgSource %s snsInfoId %s sendScene %d cpStatus %d", new Object[] { paramString1, paramString2, paramString3, paramString4, paramString5, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
    public String dAd;
    public String eNd;
    public d ifH;
    public String iwv;
    public String iww;
    public String iwx;
    public int iwy;
    public int iwz;
    public long startTime;
    public String toUser;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvideo.n
 * JD-Core Version:    0.7.0.1
 */