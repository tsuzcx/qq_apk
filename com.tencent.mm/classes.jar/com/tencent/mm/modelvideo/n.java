package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.f;
import com.tencent.mm.g.a.mk;
import com.tencent.mm.g.a.mk.a;
import com.tencent.mm.g.b.a.an;
import com.tencent.mm.g.b.a.ki;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.plugin.video.c;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.s;
import java.util.HashMap;

public class n
  implements bd
{
  public HashMap<String, a> jrv;
  private IListener<mk> jrw;
  
  public n()
  {
    AppMethodBeat.i(126918);
    this.jrw = new IListener()
    {
      private boolean a(mk paramAnonymousmk)
      {
        AppMethodBeat.i(126916);
        Log.d("MicroMsg.SubCoreMediaRpt", "get media info report event.");
        if (paramAnonymousmk == null)
        {
          AppMethodBeat.o(126916);
          return false;
        }
        String str1 = paramAnonymousmk.dRK.path;
        Object localObject2 = str1;
        Object localObject1 = str1;
        try
        {
          if (str1.endsWith(".tmp"))
          {
            localObject1 = str1;
            localObject2 = str1.substring(0, str1.lastIndexOf(".tmp"));
            localObject1 = localObject2;
            Log.i("MicroMsg.SubCoreMediaRpt", "media info event path[%s, %s]", new Object[] { localObject2, paramAnonymousmk.dRK.path });
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
        str1 = paramAnonymousmk.dRK.dRL;
        str2 = paramAnonymousmk.dRK.dRM;
        i = paramAnonymousmk.dRK.dRN;
        str3 = paramAnonymousmk.dRK.fileId;
        str4 = paramAnonymousmk.dRK.dRP;
        l1 = paramAnonymousmk.dRK.startTime;
        l2 = paramAnonymousmk.dRK.endTime;
        arrayOfString = paramAnonymousmk.dRK.dRO;
        j = paramAnonymousmk.dRK.dRQ;
        k = paramAnonymousmk.dRK.dRR;
        paramAnonymousmk = paramAnonymousmk.dRK.dRS;
        com.tencent.mm.kernel.g.aAk().postToWorker(new n.2((n)localObject2, (String)localObject1, arrayOfString, str1, str2, i, str3, str4, l1, l2, j, k, paramAnonymousmk));
        AppMethodBeat.o(126916);
        return false;
      }
    };
    this.jrv = new HashMap();
    EventCenter.instance.addListener(this.jrw);
    AppMethodBeat.o(126918);
  }
  
  public static n bhh()
  {
    AppMethodBeat.i(126919);
    n localn = (n)y.at(n.class);
    AppMethodBeat.o(126919);
    return localn;
  }
  
  public final int Qj(String paramString)
  {
    AppMethodBeat.i(240872);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(240872);
      return 0;
    }
    paramString = (a)this.jrv.get(paramString);
    if (paramString != null)
    {
      int i = paramString.jrO;
      AppMethodBeat.o(240872);
      return i;
    }
    AppMethodBeat.o(240872);
    return 0;
  }
  
  public final void a(final com.tencent.mm.i.d paramd, final String paramString1, String paramString2, final long paramLong)
  {
    AppMethodBeat.i(240873);
    if ((paramd == null) || (Util.isNullOrNil(paramString1)))
    {
      AppMethodBeat.o(240873);
      return;
    }
    com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126914);
        n.a locala1 = (n.a)n.a(n.this).remove(paramString1);
        if (locala1 == null)
        {
          AppMethodBeat.o(126914);
          return;
        }
        int j = (int)s.boW(locala1.jrL);
        com.tencent.mm.plugin.sight.base.a locala = e.aNx(locala1.jrL);
        Object localObject1;
        long l1;
        if (!Util.isNullOrNil(locala1.jrK))
        {
          localObject1 = e.aNx(locala1.jrK);
          l1 = (int)s.boW(locala1.jrK);
        }
        while ((localObject1 == null) || (locala == null))
        {
          Log.w("MicroMsg.SubCoreMediaRpt", "upload video but media info is null. %s", new Object[] { locala1.jrL });
          AppMethodBeat.o(126914);
          return;
          l1 = j;
          localObject1 = locala;
        }
        int k = NetStatusUtil.getIOSOldNetType(MMApplicationContext.getContext());
        long l2;
        if (paramd.field_startTime != 0L)
        {
          l2 = paramd.field_startTime;
          if (paramd.field_endTime == 0L) {
            break label259;
          }
        }
        int i;
        label259:
        for (long l3 = paramd.field_endTime;; l3 = Util.nowMilliSecond())
        {
          localObject2 = null;
          if (paramd.field_usedSvrIps == null) {
            break label274;
          }
          localObject2 = new StringBuffer();
          localObject3 = paramd.field_usedSvrIps;
          int m = localObject3.length;
          i = 0;
          while (i < m)
          {
            ((StringBuffer)localObject2).append(localObject3[i]).append("|");
            i += 1;
          }
          l2 = locala1.startTime;
          break;
        }
        Object localObject2 = ((StringBuffer)localObject2).toString();
        label274:
        Object localObject3 = new StringBuffer();
        ((StringBuffer)localObject3).append(locala1.toUser).append(",").append(locala1.fqK).append(",");
        ((StringBuffer)localObject3).append(k).append(",").append(paramd.field_fileId).append(",");
        ((StringBuffer)localObject3).append(paramd.field_mp4identifymd5).append(",").append(c.aTR(locala1.jrM)).append(",");
        ((StringBuffer)localObject3).append(l2).append(",").append(l3).append(",");
        ((StringBuffer)localObject3).append(l1).append(",").append(((com.tencent.mm.plugin.sight.base.a)localObject1).videoDuration).append(",");
        ((StringBuffer)localObject3).append(((com.tencent.mm.plugin.sight.base.a)localObject1).videoBitrate / 1000).append(",").append(((com.tencent.mm.plugin.sight.base.a)localObject1).audioBitrate / 1000).append(",");
        ((StringBuffer)localObject3).append(((com.tencent.mm.plugin.sight.base.a)localObject1).frameRate).append(",").append(((com.tencent.mm.plugin.sight.base.a)localObject1).width).append(",");
        ((StringBuffer)localObject3).append(((com.tencent.mm.plugin.sight.base.a)localObject1).height).append(",").append(locala1.jrN).append(",");
        ((StringBuffer)localObject3).append(j).append(",").append(locala.videoDuration).append(",");
        ((StringBuffer)localObject3).append(locala.videoBitrate / 1000).append(",").append(locala.audioBitrate / 1000).append(",");
        ((StringBuffer)localObject3).append(locala.frameRate).append(",").append(locala.width).append(",");
        ((StringBuffer)localObject3).append(locala.height).append(",").append(locala1.jrO).append(",");
        ((StringBuffer)localObject3).append((String)localObject2).append(",").append(((com.tencent.mm.plugin.sight.base.a)localObject1).audioChannel).append(",").append(paramd.field_fileUrl);
        Log.i("MicroMsg.SubCoreMediaRpt", "upload video rpt %s", new Object[] { ((StringBuffer)localObject3).toString() });
        new ki(((StringBuffer)localObject3).toString()).bfK();
        n.dz(locala.videoBitrate, locala1.jrO);
        if (locala.Cir == 1)
        {
          Log.i("MicroMsg.SubCoreMediaRpt", "ABA: New Path %s ", new Object[] { locala1.jrL });
          n.a(locala, locala1.jrO);
        }
        localObject2 = new com.tencent.mm.plugin.multimediareport.d();
        ((com.tencent.mm.plugin.multimediareport.d)localObject2).zGI = paramLong;
        ((com.tencent.mm.plugin.multimediareport.d)localObject2).zGJ = 2;
        ((com.tencent.mm.plugin.multimediareport.d)localObject2).source = 3;
        switch (locala1.jrO)
        {
        case 3: 
        default: 
          ((com.tencent.mm.plugin.multimediareport.d)localObject2).source = 1;
          if (!Util.isNullOrNil(locala1.fqK)) {
            ((com.tencent.mm.plugin.multimediareport.d)localObject2).source = 1;
          }
          ((com.tencent.mm.plugin.multimediareport.d)localObject2).pPz = locala1.toUser;
          ((com.tencent.mm.plugin.multimediareport.d)localObject2).zGL = paramd.field_fileUrl;
          ((com.tencent.mm.plugin.multimediareport.d)localObject2).fileid = paramd.field_fileId;
          ((com.tencent.mm.plugin.multimediareport.d)localObject2).zGM = paramd.field_aesKey;
          ((com.tencent.mm.plugin.multimediareport.d)localObject2).md5 = paramd.field_filemd5;
          ((com.tencent.mm.plugin.multimediareport.d)localObject2).createtime = locala1.startTime;
          ((com.tencent.mm.plugin.multimediareport.d)localObject2).zGN = locala.width;
          ((com.tencent.mm.plugin.multimediareport.d)localObject2).zGO = locala.height;
          ((com.tencent.mm.plugin.multimediareport.d)localObject2).hyI = locala.frameRate;
          ((com.tencent.mm.plugin.multimediareport.d)localObject2).zGP = locala.getVideoDuration();
          if (r.isH265Video(locala1.jrL))
          {
            localObject1 = "h265";
            label975:
            ((com.tencent.mm.plugin.multimediareport.d)localObject2).zGR = ((String)localObject1);
            if (!Util.isNullOrNil(paramd.field_thumbUrl)) {
              break label1113;
            }
            localObject1 = null;
            label998:
            ((com.tencent.mm.plugin.multimediareport.d)localObject2).gTB = ((String)localObject1);
            ((com.tencent.mm.plugin.multimediareport.d)localObject2).zGS = "aac";
            ((com.tencent.mm.plugin.multimediareport.d)localObject2).zGQ = locala.audioSampleRate;
            ((com.tencent.mm.plugin.multimediareport.d)localObject2).uuid = this.jrz;
            i = 1;
            if (!Util.isNullOrNil(locala1.toUser)) {
              break label1125;
            }
            i = 3;
          }
          break;
        }
        for (;;)
        {
          com.tencent.mm.plugin.multimediareport.g.a((com.tencent.mm.plugin.multimediareport.d)localObject2, i, locala1.startTime, locala1.jrL);
          AppMethodBeat.o(126914);
          return;
          ((com.tencent.mm.plugin.multimediareport.d)localObject2).source = 2;
          break;
          ((com.tencent.mm.plugin.multimediareport.d)localObject2).source = 3;
          break;
          ((com.tencent.mm.plugin.multimediareport.d)localObject2).source = 2;
          break;
          ((com.tencent.mm.plugin.multimediareport.d)localObject2).source = 3;
          break;
          localObject1 = "h264";
          break label975;
          label1113:
          localObject1 = paramd.field_thumbUrl;
          break label998;
          label1125:
          if (ab.Eq(locala1.toUser)) {
            i = 2;
          }
        }
      }
    });
    AppMethodBeat.o(240873);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126920);
    a locala2 = (a)this.jrv.get(paramString2);
    a locala1 = locala2;
    if (locala2 == null) {
      locala1 = new a();
    }
    locala1.jrK = paramString1;
    locala1.jrL = paramString2;
    locala1.toUser = paramString3;
    locala1.fqK = paramString4;
    locala1.jrM = paramString5;
    if (locala1.jrO != 0) {}
    for (int i = locala1.jrO;; i = paramInt1)
    {
      locala1.jrO = i;
      locala1.jrN = paramInt2;
      locala1.startTime = Util.nowMilliSecond();
      this.jrv.put(paramString2, locala1);
      Log.i("MicroMsg.SubCoreMediaRpt", "note video upload path[%s, %s] toUser %s msgSource %s snsInfoId %s sendScene %d cpStatus %d", new Object[] { paramString1, paramString2, paramString3, paramString4, paramString5, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(126920);
      return;
    }
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
    public String dRP;
    public String fqK;
    public com.tencent.mm.i.d jaC;
    public String jrK;
    public String jrL;
    public String jrM;
    public int jrN;
    public int jrO;
    public long startTime;
    public String toUser;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvideo.n
 * JD-Core Version:    0.7.0.1
 */