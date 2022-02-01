package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.nb;
import com.tencent.mm.f.a.nb.a;
import com.tencent.mm.f.b.a.na;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.be;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.multimediareport.g;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.plugin.sight.base.f;
import com.tencent.mm.plugin.video.c;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.u;
import java.io.File;
import java.util.HashMap;

public class r
  implements be
{
  public HashMap<String, a> mgY;
  private IListener<nb> mgZ;
  
  public r()
  {
    AppMethodBeat.i(126918);
    this.mgZ = new IListener()
    {
      private boolean a(nb paramAnonymousnb)
      {
        AppMethodBeat.i(126916);
        Log.d("MicroMsg.SubCoreMediaRpt", "get media info report event.");
        if (paramAnonymousnb == null)
        {
          AppMethodBeat.o(126916);
          return false;
        }
        String str1 = paramAnonymousnb.fLh.path;
        Object localObject2 = str1;
        Object localObject1 = str1;
        try
        {
          if (str1.endsWith(".tmp"))
          {
            localObject1 = str1;
            localObject2 = str1.substring(0, str1.lastIndexOf(".tmp"));
            localObject1 = localObject2;
            Log.i("MicroMsg.SubCoreMediaRpt", "media info event path[%s, %s]", new Object[] { localObject2, paramAnonymousnb.fLh.path });
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
        localObject2 = r.this;
        str1 = paramAnonymousnb.fLh.fLi;
        str2 = paramAnonymousnb.fLh.fLj;
        i = paramAnonymousnb.fLh.fLk;
        str3 = paramAnonymousnb.fLh.fileId;
        str4 = paramAnonymousnb.fLh.fLm;
        l1 = paramAnonymousnb.fLh.startTime;
        l2 = paramAnonymousnb.fLh.endTime;
        arrayOfString = paramAnonymousnb.fLh.fLl;
        j = paramAnonymousnb.fLh.fLn;
        k = paramAnonymousnb.fLh.fLo;
        paramAnonymousnb = paramAnonymousnb.fLh.fLp;
        h.aHJ().postToWorker(new r.2((r)localObject2, (String)localObject1, arrayOfString, str1, str2, i, str3, str4, l1, l2, j, k, paramAnonymousnb));
        AppMethodBeat.o(126916);
        return false;
      }
    };
    this.mgY = new HashMap();
    EventCenter.instance.addListener(this.mgZ);
    AppMethodBeat.o(126918);
  }
  
  public static r bqz()
  {
    AppMethodBeat.i(126919);
    r localr = (r)y.as(r.class);
    AppMethodBeat.o(126919);
    return localr;
  }
  
  public final int XG(String paramString)
  {
    AppMethodBeat.i(215973);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(215973);
      return 0;
    }
    paramString = (a)this.mgY.get(paramString);
    if (paramString != null)
    {
      int i = paramString.mhr;
      AppMethodBeat.o(215973);
      return i;
    }
    AppMethodBeat.o(215973);
    return 0;
  }
  
  public final void a(final com.tencent.mm.i.d paramd, final String paramString1, String paramString2, final long paramLong)
  {
    AppMethodBeat.i(215974);
    if ((paramd == null) || (Util.isNullOrNil(paramString1)))
    {
      AppMethodBeat.o(215974);
      return;
    }
    h.aHJ().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126914);
        r.a locala = (r.a)r.a(r.this).remove(paramString1);
        if (locala == null)
        {
          AppMethodBeat.o(126914);
          return;
        }
        int j = (int)u.bBQ(locala.mho);
        b localb = f.aYg(locala.mho);
        Object localObject1;
        long l1;
        if (!Util.isNullOrNil(locala.mhn))
        {
          localObject1 = f.aYg(locala.mhn);
          l1 = (int)u.bBQ(locala.mhn);
        }
        while ((localObject1 == null) || (localb == null))
        {
          Log.w("MicroMsg.SubCoreMediaRpt", "upload video but media info is null. %s", new Object[] { locala.mho });
          AppMethodBeat.o(126914);
          return;
          l1 = j;
          localObject1 = localb;
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
          l2 = locala.startTime;
          break;
        }
        Object localObject2 = ((StringBuffer)localObject2).toString();
        label274:
        Object localObject3 = new StringBuffer();
        ((StringBuffer)localObject3).append(locala.toUser).append(",").append(locala.hxy).append(",");
        ((StringBuffer)localObject3).append(k).append(",").append(paramd.field_fileId).append(",");
        ((StringBuffer)localObject3).append(paramd.field_mp4identifymd5).append(",").append(c.bfp(locala.mhp)).append(",");
        ((StringBuffer)localObject3).append(l2).append(",").append(l3).append(",");
        ((StringBuffer)localObject3).append(l1).append(",").append(((b)localObject1).videoDuration).append(",");
        ((StringBuffer)localObject3).append(((b)localObject1).videoBitrate / 1000).append(",").append(((b)localObject1).audioBitrate / 1000).append(",");
        ((StringBuffer)localObject3).append(((b)localObject1).frameRate).append(",").append(((b)localObject1).width).append(",");
        ((StringBuffer)localObject3).append(((b)localObject1).height).append(",").append(locala.mhq).append(",");
        ((StringBuffer)localObject3).append(j).append(",").append(localb.videoDuration).append(",");
        ((StringBuffer)localObject3).append(localb.videoBitrate / 1000).append(",").append(localb.audioBitrate / 1000).append(",");
        ((StringBuffer)localObject3).append(localb.frameRate).append(",").append(localb.width).append(",");
        ((StringBuffer)localObject3).append(localb.height).append(",").append(locala.mhr).append(",");
        ((StringBuffer)localObject3).append((String)localObject2).append(",").append(((b)localObject1).audioChannel).append(",").append(paramd.field_fileUrl);
        Log.i("MicroMsg.SubCoreMediaRpt", "upload video rpt %s", new Object[] { ((StringBuffer)localObject3).toString() });
        new na(((StringBuffer)localObject3).toString()).bpa();
        r.dW(localb.videoBitrate, locala.mhr);
        if (localb.Ifi == 1)
        {
          Log.i("MicroMsg.SubCoreMediaRpt", "ABA: New Path %s ", new Object[] { locala.mho });
          r.a(localb, locala.mhr);
        }
        localObject2 = new com.tencent.mm.plugin.multimediareport.d();
        ((com.tencent.mm.plugin.multimediareport.d)localObject2).FlS = paramLong;
        ((com.tencent.mm.plugin.multimediareport.d)localObject2).FlT = 2;
        ((com.tencent.mm.plugin.multimediareport.d)localObject2).source = 3;
        switch (locala.mhr)
        {
        case 3: 
        default: 
          ((com.tencent.mm.plugin.multimediareport.d)localObject2).source = 1;
          if (!Util.isNullOrNil(locala.hxy)) {
            ((com.tencent.mm.plugin.multimediareport.d)localObject2).source = 1;
          }
          ((com.tencent.mm.plugin.multimediareport.d)localObject2).sWA = locala.toUser;
          ((com.tencent.mm.plugin.multimediareport.d)localObject2).FlV = paramd.field_fileUrl;
          ((com.tencent.mm.plugin.multimediareport.d)localObject2).fileid = paramd.field_fileId;
          ((com.tencent.mm.plugin.multimediareport.d)localObject2).FlW = paramd.field_aesKey;
          ((com.tencent.mm.plugin.multimediareport.d)localObject2).md5 = paramd.field_filemd5;
          if (!Util.isNullOrNil(locala.mhn))
          {
            ((com.tencent.mm.plugin.multimediareport.d)localObject2).createtime = new File(locala.mhn).lastModified();
            label940:
            ((com.tencent.mm.plugin.multimediareport.d)localObject2).FlX = localb.width;
            ((com.tencent.mm.plugin.multimediareport.d)localObject2).FlY = localb.height;
            ((com.tencent.mm.plugin.multimediareport.d)localObject2).klF = localb.frameRate;
            ((com.tencent.mm.plugin.multimediareport.d)localObject2).FlZ = localb.getVideoDuration();
            if (!v.isH265Video(locala.mho)) {
              break label1139;
            }
            localObject1 = "h265";
            label996:
            ((com.tencent.mm.plugin.multimediareport.d)localObject2).Fmb = ((String)localObject1);
            if (!Util.isNullOrNil(paramd.field_thumbUrl)) {
              break label1147;
            }
            localObject1 = null;
            label1019:
            ((com.tencent.mm.plugin.multimediareport.d)localObject2).jEd = ((String)localObject1);
            ((com.tencent.mm.plugin.multimediareport.d)localObject2).Fmc = "aac";
            ((com.tencent.mm.plugin.multimediareport.d)localObject2).Fma = localb.audioSampleRate;
            ((com.tencent.mm.plugin.multimediareport.d)localObject2).uuid = this.mhc;
            i = 1;
            if (!Util.isNullOrNil(locala.toUser)) {
              break label1159;
            }
            i = 3;
          }
          break;
        }
        for (;;)
        {
          g.a((com.tencent.mm.plugin.multimediareport.d)localObject2, i, locala.startTime, locala.mho);
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
          ((com.tencent.mm.plugin.multimediareport.d)localObject2).createtime = locala.startTime;
          break label940;
          label1139:
          localObject1 = "h264";
          break label996;
          label1147:
          localObject1 = paramd.field_thumbUrl;
          break label1019;
          label1159:
          if (ab.Lj(locala.toUser)) {
            i = 2;
          }
        }
      }
    });
    AppMethodBeat.o(215974);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126920);
    a locala2 = (a)this.mgY.get(paramString2);
    a locala1 = locala2;
    if (locala2 == null) {
      locala1 = new a();
    }
    locala1.mhn = paramString1;
    locala1.mho = paramString2;
    locala1.toUser = paramString3;
    locala1.hxy = paramString4;
    locala1.mhp = paramString5;
    if (locala1.mhr != 0) {}
    for (int i = locala1.mhr;; i = paramInt1)
    {
      locala1.mhr = i;
      locala1.mhq = paramInt2;
      locala1.startTime = Util.nowMilliSecond();
      this.mgY.put(paramString2, locala1);
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
    public String fLm;
    public String hxy;
    public com.tencent.mm.i.d lQZ;
    public String mhn;
    public String mho;
    public String mhp;
    public int mhq;
    public int mhr;
    public long startTime;
    public String toUser;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvideo.r
 * JD-Core Version:    0.7.0.1
 */