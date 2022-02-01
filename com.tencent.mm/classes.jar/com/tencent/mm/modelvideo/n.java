package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.f;
import com.tencent.mm.g.a.lt;
import com.tencent.mm.g.a.lt.a;
import com.tencent.mm.g.b.a.gs;
import com.tencent.mm.g.b.a.v;
import com.tencent.mm.i.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ax;
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
  implements ax
{
  public HashMap<String, a> ito;
  private com.tencent.mm.sdk.b.c<lt> itp;
  
  public n()
  {
    AppMethodBeat.i(126918);
    this.itp = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(lt paramAnonymouslt)
      {
        AppMethodBeat.i(126916);
        ad.d("MicroMsg.SubCoreMediaRpt", "get media info report event.");
        if (paramAnonymouslt == null)
        {
          AppMethodBeat.o(126916);
          return false;
        }
        String str1 = paramAnonymouslt.dyT.path;
        Object localObject2 = str1;
        Object localObject1 = str1;
        try
        {
          if (str1.endsWith(".tmp"))
          {
            localObject1 = str1;
            localObject2 = str1.substring(0, str1.lastIndexOf(".tmp"));
            localObject1 = localObject2;
            ad.i("MicroMsg.SubCoreMediaRpt", "media info event path[%s, %s]", new Object[] { localObject2, paramAnonymouslt.dyT.path });
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
        str1 = paramAnonymouslt.dyT.dyU;
        str2 = paramAnonymouslt.dyT.dyV;
        i = paramAnonymouslt.dyT.dyW;
        str3 = paramAnonymouslt.dyT.fileId;
        str4 = paramAnonymouslt.dyT.dyY;
        l1 = paramAnonymouslt.dyT.startTime;
        l2 = paramAnonymouslt.dyT.endTime;
        arrayOfString = paramAnonymouslt.dyT.dyX;
        j = paramAnonymouslt.dyT.dyZ;
        k = paramAnonymouslt.dyT.dza;
        paramAnonymouslt = paramAnonymouslt.dyT.dzb;
        g.ajF().ay(new n.2((n)localObject2, (String)localObject1, arrayOfString, str1, str2, i, str3, str4, l1, l2, j, k, paramAnonymouslt));
        AppMethodBeat.o(126916);
        return false;
      }
    };
    this.ito = new HashMap();
    com.tencent.mm.sdk.b.a.IbL.c(this.itp);
    AppMethodBeat.o(126918);
  }
  
  public static n aMH()
  {
    AppMethodBeat.i(126919);
    n localn = (n)t.ap(n.class);
    AppMethodBeat.o(126919);
    return localn;
  }
  
  public final int GU(String paramString)
  {
    AppMethodBeat.i(218863);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(218863);
      return 0;
    }
    paramString = (a)this.ito.get(paramString);
    if (paramString != null)
    {
      int i = paramString.itF;
      AppMethodBeat.o(218863);
      return i;
    }
    AppMethodBeat.o(218863);
    return 0;
  }
  
  public final void a(final d paramd, final String paramString)
  {
    AppMethodBeat.i(126921);
    if ((paramd == null) || (bt.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(126921);
      return;
    }
    g.ajF().ay(new Runnable()
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
        int j = (int)i.aYo(locala.itC);
        com.tencent.mm.plugin.sight.base.a locala2 = e.axx(locala.itC);
        com.tencent.mm.plugin.sight.base.a locala1;
        long l1;
        if (!bt.isNullOrNil(locala.itB))
        {
          locala1 = e.axx(locala.itB);
          l1 = (int)i.aYo(locala.itB);
        }
        while ((locala1 == null) || (locala2 == null))
        {
          ad.w("MicroMsg.SubCoreMediaRpt", "upload video but media info is null. %s", new Object[] { locala.itC });
          AppMethodBeat.o(126914);
          return;
          l1 = j;
          locala1 = locala2;
        }
        int k = ay.iT(aj.getContext());
        long l2;
        if (paramd.field_startTime != 0L)
        {
          l2 = paramd.field_startTime;
          if (paramd.field_endTime == 0L) {
            break label259;
          }
        }
        label259:
        for (long l3 = paramd.field_endTime;; l3 = bt.flT())
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
        ((StringBuffer)localObject2).append(locala.toUser).append(",").append(locala.eLs).append(",");
        ((StringBuffer)localObject2).append(k).append(",").append(paramd.field_fileId).append(",");
        ((StringBuffer)localObject2).append(paramd.field_mp4identifymd5).append(",").append(com.tencent.mm.plugin.video.c.aDi(locala.itD)).append(",");
        ((StringBuffer)localObject2).append(l2).append(",").append(l3).append(",");
        ((StringBuffer)localObject2).append(l1).append(",").append(locala1.videoDuration).append(",");
        ((StringBuffer)localObject2).append(locala1.videoBitrate / 1000).append(",").append(locala1.audioBitrate / 1000).append(",");
        ((StringBuffer)localObject2).append(locala1.frameRate).append(",").append(locala1.width).append(",");
        ((StringBuffer)localObject2).append(locala1.height).append(",").append(locala.itE).append(",");
        ((StringBuffer)localObject2).append(j).append(",").append(locala2.videoDuration).append(",");
        ((StringBuffer)localObject2).append(locala2.videoBitrate / 1000).append(",").append(locala2.audioBitrate / 1000).append(",");
        ((StringBuffer)localObject2).append(locala2.frameRate).append(",").append(locala2.width).append(",");
        ((StringBuffer)localObject2).append(locala2.height).append(",").append(locala.itF).append(",");
        ((StringBuffer)localObject2).append((String)localObject1).append(",").append(locala1.audioChannel).append(",").append(paramd.field_fileUrl);
        ad.i("MicroMsg.SubCoreMediaRpt", "upload video rpt %s", new Object[] { ((StringBuffer)localObject2).toString() });
        new gs(((StringBuffer)localObject2).toString()).aLk();
        n.dp(locala2.videoBitrate, locala.itF);
        if (locala2.xRz == 1)
        {
          ad.i("MicroMsg.SubCoreMediaRpt", "ABA: New Path %s ", new Object[] { locala.itC });
          n.a(locala2, locala.itF);
        }
        AppMethodBeat.o(126914);
      }
    });
    AppMethodBeat.o(126921);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126920);
    a locala2 = (a)this.ito.get(paramString2);
    a locala1 = locala2;
    if (locala2 == null) {
      locala1 = new a();
    }
    locala1.itB = paramString1;
    locala1.itC = paramString2;
    locala1.toUser = paramString3;
    locala1.eLs = paramString4;
    locala1.itD = paramString5;
    locala1.itF = paramInt1;
    locala1.itE = paramInt2;
    locala1.startTime = bt.flT();
    this.ito.put(paramString2, locala1);
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
    public String dyY;
    public String eLs;
    public d icO;
    public String itB;
    public String itC;
    public String itD;
    public int itE;
    public int itF;
    public long startTime;
    public String toUser;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvideo.n
 * JD-Core Version:    0.7.0.1
 */