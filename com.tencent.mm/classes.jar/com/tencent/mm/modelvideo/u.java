package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.oi;
import com.tencent.mm.autogen.mmdata.rpt.bk;
import com.tencent.mm.autogen.mmdata.rpt.qh;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.be;
import com.tencent.mm.modelcdntran.k;
import com.tencent.mm.plugin.multimediareport.g;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.plugin.video.c;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storagebase.h.b;
import java.io.File;
import java.util.HashMap;

public class u
  implements be
{
  public HashMap<String, a> pai;
  private IListener<oi> paj;
  
  public u()
  {
    AppMethodBeat.i(126918);
    this.paj = new SubCoreMediaRpt.3(this, com.tencent.mm.app.f.hfK);
    this.pai = new HashMap();
    this.paj.alive();
    AppMethodBeat.o(126918);
  }
  
  public static u bOf()
  {
    AppMethodBeat.i(126919);
    u localu = (u)com.tencent.mm.model.y.aL(u.class);
    AppMethodBeat.o(126919);
    return localu;
  }
  
  public final int PI(String paramString)
  {
    AppMethodBeat.i(241263);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(241263);
      return 0;
    }
    paramString = (a)this.pai.get(paramString);
    if (paramString != null)
    {
      int i = paramString.paC;
      AppMethodBeat.o(241263);
      return i;
    }
    AppMethodBeat.o(241263);
    return 0;
  }
  
  public final void a(final com.tencent.mm.g.d paramd, final String paramString1, String paramString2, final long paramLong)
  {
    AppMethodBeat.i(241267);
    if ((paramd == null) || (Util.isNullOrNil(paramString1)))
    {
      AppMethodBeat.o(241267);
      return;
    }
    h.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126914);
        u.a locala = (u.a)u.a(u.this).remove(paramString1);
        if (locala == null)
        {
          AppMethodBeat.o(126914);
          return;
        }
        int j = (int)com.tencent.mm.vfs.y.bEl(locala.paz);
        b localb = com.tencent.mm.plugin.sight.base.f.aVX(locala.paz);
        Object localObject1;
        long l1;
        if (!Util.isNullOrNil(locala.pax))
        {
          localObject1 = com.tencent.mm.plugin.sight.base.f.aVX(locala.pax);
          l1 = (int)com.tencent.mm.vfs.y.bEl(locala.pax);
        }
        while ((localObject1 == null) || (localb == null))
        {
          Log.w("MicroMsg.SubCoreMediaRpt", "upload video but media info is null. %s", new Object[] { locala.paz });
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
        Object localObject3;
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
        long l5 = l3 - l2;
        long l4;
        if (l5 > 0L)
        {
          l4 = ((float)paramd.field_fileLength / 1024.0F / ((float)l5 / 1000.0F));
          localObject3 = new StringBuffer();
          ((StringBuffer)localObject3).append(locala.toUser).append(",").append(locala.jUr).append(",");
          ((StringBuffer)localObject3).append(k).append(",").append(paramd.field_fileId).append(",");
          ((StringBuffer)localObject3).append(paramd.field_mp4identifymd5).append(",").append(c.beW(locala.paA)).append(",");
          ((StringBuffer)localObject3).append(l2).append(",").append(l3).append(",");
          ((StringBuffer)localObject3).append(l1).append(",").append(((b)localObject1).videoDuration).append(",");
          ((StringBuffer)localObject3).append(((b)localObject1).videoBitrate / 1000).append(",").append(((b)localObject1).audioBitrate / 1000).append(",");
          ((StringBuffer)localObject3).append(((b)localObject1).frameRate).append(",").append(((b)localObject1).width).append(",");
          ((StringBuffer)localObject3).append(((b)localObject1).height).append(",").append(locala.paB).append(",");
          ((StringBuffer)localObject3).append(j).append(",").append(localb.videoDuration).append(",");
          ((StringBuffer)localObject3).append(localb.videoBitrate / 1000).append(",").append(localb.audioBitrate / 1000).append(",");
          ((StringBuffer)localObject3).append(localb.frameRate).append(",").append(localb.width).append(",");
          ((StringBuffer)localObject3).append(localb.height).append(",").append(locala.paC).append(",");
          ((StringBuffer)localObject3).append((String)localObject2).append(",").append(((b)localObject1).audioChannel).append(",").append(paramd.field_fileUrl).append(",");
          ((StringBuffer)localObject3).append(l4).append(",").append(l5);
          Log.i("MicroMsg.SubCoreMediaRpt", "upload video rpt %s", new Object[] { ((StringBuffer)localObject3).toString() });
          new qh(((StringBuffer)localObject3).toString()).bMH();
          u.eO(localb.videoBitrate, locala.paC);
          if (localb.Oby == 1)
          {
            Log.i("MicroMsg.SubCoreMediaRpt", "ABA: New Path %s ", new Object[] { locala.paz });
            u.a(localb, locala.paC);
          }
          localObject2 = new com.tencent.mm.plugin.multimediareport.d();
          ((com.tencent.mm.plugin.multimediareport.d)localObject2).LhU = paramLong;
          ((com.tencent.mm.plugin.multimediareport.d)localObject2).LhV = 2;
          ((com.tencent.mm.plugin.multimediareport.d)localObject2).source = 3;
          switch (locala.paC)
          {
          case 3: 
          default: 
            ((com.tencent.mm.plugin.multimediareport.d)localObject2).source = 1;
            label894:
            if (!Util.isNullOrNil(locala.jUr)) {
              ((com.tencent.mm.plugin.multimediareport.d)localObject2).source = 1;
            }
            ((com.tencent.mm.plugin.multimediareport.d)localObject2).waL = locala.toUser;
            ((com.tencent.mm.plugin.multimediareport.d)localObject2).LhX = paramd.field_fileUrl;
            ((com.tencent.mm.plugin.multimediareport.d)localObject2).fileid = paramd.field_fileId;
            ((com.tencent.mm.plugin.multimediareport.d)localObject2).LhY = paramd.field_aesKey;
            ((com.tencent.mm.plugin.multimediareport.d)localObject2).md5 = paramd.field_filemd5;
            if (!Util.isNullOrNil(locala.pax))
            {
              ((com.tencent.mm.plugin.multimediareport.d)localObject2).createtime = new File(locala.pax).lastModified();
              label1000:
              ((com.tencent.mm.plugin.multimediareport.d)localObject2).LhZ = localb.width;
              ((com.tencent.mm.plugin.multimediareport.d)localObject2).Lia = localb.height;
              ((com.tencent.mm.plugin.multimediareport.d)localObject2).mMK = localb.frameRate;
              ((com.tencent.mm.plugin.multimediareport.d)localObject2).Lib = localb.getVideoDuration();
              if (!y.isH265Video(locala.paz)) {
                break label1205;
              }
              localObject1 = "h265";
              label1056:
              ((com.tencent.mm.plugin.multimediareport.d)localObject2).Lid = ((String)localObject1);
              if (!Util.isNullOrNil(paramd.field_thumbUrl)) {
                break label1213;
              }
              localObject1 = null;
              label1079:
              ((com.tencent.mm.plugin.multimediareport.d)localObject2).mdZ = ((String)localObject1);
              ((com.tencent.mm.plugin.multimediareport.d)localObject2).Lie = "aac";
              ((com.tencent.mm.plugin.multimediareport.d)localObject2).Lic = localb.audioSampleRate;
              ((com.tencent.mm.plugin.multimediareport.d)localObject2).uuid = this.pam;
              i = 1;
              if (!Util.isNullOrNil(locala.toUser)) {
                break label1225;
              }
              i = 3;
            }
            break;
          }
        }
        for (;;)
        {
          g.a((com.tencent.mm.plugin.multimediareport.d)localObject2, i, locala.startTime, locala.paz);
          AppMethodBeat.o(126914);
          return;
          l4 = 0L;
          break;
          ((com.tencent.mm.plugin.multimediareport.d)localObject2).source = 2;
          break label894;
          ((com.tencent.mm.plugin.multimediareport.d)localObject2).source = 3;
          break label894;
          ((com.tencent.mm.plugin.multimediareport.d)localObject2).source = 2;
          break label894;
          ((com.tencent.mm.plugin.multimediareport.d)localObject2).source = 3;
          break label894;
          ((com.tencent.mm.plugin.multimediareport.d)localObject2).createtime = locala.startTime;
          break label1000;
          label1205:
          localObject1 = "h264";
          break label1056;
          label1213:
          localObject1 = paramd.field_thumbUrl;
          break label1079;
          label1225:
          if (au.bwE(locala.toUser)) {
            i = 2;
          }
        }
      }
    });
    AppMethodBeat.o(241267);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126920);
    a locala2 = (a)this.pai.get(paramString2);
    a locala1 = locala2;
    if (locala2 == null) {
      locala1 = new a();
    }
    locala1.pax = paramString1;
    locala1.paz = paramString2;
    locala1.toUser = paramString3;
    locala1.jUr = paramString4;
    locala1.paA = paramString5;
    if (locala1.paC != 0) {}
    for (int i = locala1.paC;; i = paramInt1)
    {
      locala1.paC = i;
      locala1.paB = paramInt2;
      locala1.startTime = Util.nowMilliSecond();
      this.pai.put(paramString2, locala1);
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
    public String hQU;
    public String jUr;
    public com.tencent.mm.g.d oJJ;
    public String paA;
    public int paB;
    public int paC;
    public String pax;
    public String paz;
    public long startTime;
    public String toUser;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelvideo.u
 * JD-Core Version:    0.7.0.1
 */