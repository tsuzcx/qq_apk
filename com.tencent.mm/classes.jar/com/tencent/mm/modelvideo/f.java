package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.b;
import com.tencent.mm.g.b.a.hb;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.i.g.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.bp.b;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.bz;
import java.io.ByteArrayOutputStream;
import java.util.Map;

public final class f
{
  public String dHp;
  private g.b gqQ;
  String gqS;
  private g.a iZc;
  boolean jqC;
  String jqD;
  private long jqE;
  long jqF;
  long jqG;
  int jqH;
  private String jqI;
  public long jqJ;
  public boolean jqK;
  public a jqL;
  private com.tencent.mm.i.h jqr;
  private String mediaId;
  long msgId;
  
  public f(long paramLong)
  {
    AppMethodBeat.i(126843);
    this.jqC = false;
    this.iZc = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(126841);
        if (paramAnonymousInt != 0)
        {
          Log.w("MicroMsg.NetScenePreloadVideoFake", "%d preload video error startRet[%d]", new Object[] { Integer.valueOf(f.this.hashCode()), Integer.valueOf(paramAnonymousInt) });
          if (f.this.jqL != null) {
            f.this.jqL.a(f.this, false, 0, 0);
          }
        }
        if (paramAnonymousc != null) {
          Log.d("MicroMsg.NetScenePreloadVideoFake", "%d preload video[%d %d] mediaId[%s]", new Object[] { Integer.valueOf(f.this.hashCode()), Long.valueOf(paramAnonymousc.field_finishedLength), Long.valueOf(paramAnonymousc.field_toltalLength), paramAnonymousString });
        }
        if (paramAnonymousd != null)
        {
          Log.i("MicroMsg.NetScenePreloadVideoFake", "%d preload video error [%d]", new Object[] { Integer.valueOf(f.this.hashCode()), Integer.valueOf(paramAnonymousd.field_retCode) });
          if (paramAnonymousd.field_retCode == 0) {
            break label205;
          }
          if (f.this.jqL != null) {
            f.this.jqL.a(f.this, false, 0, 0);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(126841);
          return 0;
          label205:
          Log.i("MicroMsg.NetScenePreloadVideoFake", "%d preload video download all video file", new Object[] { Integer.valueOf(f.this.hashCode()) });
          f.this.l(f.this.jqD, (int)paramAnonymousd.field_fileLength, f.this.gqS);
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return new byte[0];
      }
    };
    this.gqQ = new g.b()
    {
      public final void b(String paramAnonymousString, d paramAnonymousd)
      {
        AppMethodBeat.i(126842);
        if (paramAnonymousd == null)
        {
          Log.w("MicroMsg.NetScenePreloadVideoFake", "%s onPreload completed but sceneResult is null", new Object[] { Integer.valueOf(f.this.hashCode()) });
          if (f.this.jqL != null) {
            f.this.jqL.a(f.this, false, 0, 0);
          }
          AppMethodBeat.o(126842);
          return;
        }
        int i = (int)paramAnonymousd.field_recvedBytes;
        int j = (int)paramAnonymousd.field_fileLength;
        Log.i("MicroMsg.NetScenePreloadVideoFake", "%d onPreload Completed [%s] videoInfoName[%s] [%d, %d] videoFormat[%d]", new Object[] { Integer.valueOf(f.this.hashCode()), paramAnonymousString, f.this.jqD, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramAnonymousd.field_videoFormat) });
        if ((i > 0) && (j > 0)) {
          f.this.jqG = f.e(f.this.jqD, i, true);
        }
        boolean bool;
        if (f.this.jqL != null)
        {
          paramAnonymousString = f.this.jqL;
          f localf = f.this;
          if ((i > 0) && (j > 0))
          {
            bool = true;
            paramAnonymousString.a(localf, bool, i, j);
          }
        }
        else
        {
          f.this.jqF = Util.nowSecond();
          f.this.Qe(paramAnonymousd.alM());
          if (!f.this.jqC) {
            break label342;
          }
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 142L, 1L, false);
          if (f.this.jqH != 1) {
            break label325;
          }
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 123L, 1L, false);
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, paramAnonymousd.field_videoFormat + 240, 1L, false);
          AppMethodBeat.o(126842);
          return;
          bool = false;
          break;
          label325:
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 124L, 1L, false);
        }
        label342:
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 143L, 1L, false);
        AppMethodBeat.o(126842);
      }
    };
    this.msgId = paramLong;
    this.jqC = true;
    AppMethodBeat.o(126843);
  }
  
  public f(com.tencent.mm.i.h paramh, String paramString)
  {
    AppMethodBeat.i(126844);
    this.jqC = false;
    this.iZc = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(126841);
        if (paramAnonymousInt != 0)
        {
          Log.w("MicroMsg.NetScenePreloadVideoFake", "%d preload video error startRet[%d]", new Object[] { Integer.valueOf(f.this.hashCode()), Integer.valueOf(paramAnonymousInt) });
          if (f.this.jqL != null) {
            f.this.jqL.a(f.this, false, 0, 0);
          }
        }
        if (paramAnonymousc != null) {
          Log.d("MicroMsg.NetScenePreloadVideoFake", "%d preload video[%d %d] mediaId[%s]", new Object[] { Integer.valueOf(f.this.hashCode()), Long.valueOf(paramAnonymousc.field_finishedLength), Long.valueOf(paramAnonymousc.field_toltalLength), paramAnonymousString });
        }
        if (paramAnonymousd != null)
        {
          Log.i("MicroMsg.NetScenePreloadVideoFake", "%d preload video error [%d]", new Object[] { Integer.valueOf(f.this.hashCode()), Integer.valueOf(paramAnonymousd.field_retCode) });
          if (paramAnonymousd.field_retCode == 0) {
            break label205;
          }
          if (f.this.jqL != null) {
            f.this.jqL.a(f.this, false, 0, 0);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(126841);
          return 0;
          label205:
          Log.i("MicroMsg.NetScenePreloadVideoFake", "%d preload video download all video file", new Object[] { Integer.valueOf(f.this.hashCode()) });
          f.this.l(f.this.jqD, (int)paramAnonymousd.field_fileLength, f.this.gqS);
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return new byte[0];
      }
    };
    this.gqQ = new g.b()
    {
      public final void b(String paramAnonymousString, d paramAnonymousd)
      {
        AppMethodBeat.i(126842);
        if (paramAnonymousd == null)
        {
          Log.w("MicroMsg.NetScenePreloadVideoFake", "%s onPreload completed but sceneResult is null", new Object[] { Integer.valueOf(f.this.hashCode()) });
          if (f.this.jqL != null) {
            f.this.jqL.a(f.this, false, 0, 0);
          }
          AppMethodBeat.o(126842);
          return;
        }
        int i = (int)paramAnonymousd.field_recvedBytes;
        int j = (int)paramAnonymousd.field_fileLength;
        Log.i("MicroMsg.NetScenePreloadVideoFake", "%d onPreload Completed [%s] videoInfoName[%s] [%d, %d] videoFormat[%d]", new Object[] { Integer.valueOf(f.this.hashCode()), paramAnonymousString, f.this.jqD, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramAnonymousd.field_videoFormat) });
        if ((i > 0) && (j > 0)) {
          f.this.jqG = f.e(f.this.jqD, i, true);
        }
        boolean bool;
        if (f.this.jqL != null)
        {
          paramAnonymousString = f.this.jqL;
          f localf = f.this;
          if ((i > 0) && (j > 0))
          {
            bool = true;
            paramAnonymousString.a(localf, bool, i, j);
          }
        }
        else
        {
          f.this.jqF = Util.nowSecond();
          f.this.Qe(paramAnonymousd.alM());
          if (!f.this.jqC) {
            break label342;
          }
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 142L, 1L, false);
          if (f.this.jqH != 1) {
            break label325;
          }
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 123L, 1L, false);
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, paramAnonymousd.field_videoFormat + 240, 1L, false);
          AppMethodBeat.o(126842);
          return;
          bool = false;
          break;
          label325:
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 124L, 1L, false);
        }
        label342:
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 143L, 1L, false);
        AppMethodBeat.o(126842);
      }
    };
    this.jqr = paramh;
    this.dHp = paramString;
    this.jqC = false;
    AppMethodBeat.o(126844);
  }
  
  static int e(String paramString, int paramInt, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(126848);
    s locals = u.QN(paramString);
    int j;
    if (locals != null)
    {
      j = locals.dRQ;
      if (paramBoolean)
      {
        locals.dRQ = paramInt;
        Log.i("MicroMsg.NetScenePreloadVideoFake", "update video info[%s] preload[%d %d %d] isFinish[%b] ", new Object[] { paramString, Integer.valueOf(j), Integer.valueOf(paramInt), Integer.valueOf(locals.dRQ), Boolean.valueOf(paramBoolean) });
        locals.jsm = Util.nowSecond();
        locals.cSx = 1025;
        u.f(locals);
        if (!paramBoolean) {
          break label139;
        }
        paramInt -= j;
        label114:
        if (paramInt >= 0) {
          break label149;
        }
        paramInt = i;
      }
    }
    label139:
    label149:
    for (;;)
    {
      AppMethodBeat.o(126848);
      return paramInt;
      locals.dRQ = (j + paramInt);
      break;
      break label114;
      AppMethodBeat.o(126848);
      return paramInt;
    }
  }
  
  private static boolean i(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(126850);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(126850);
      return false;
    }
    o.bhj();
    paramString2 = t.Qw(paramString2);
    if ((Util.isNullOrNil(paramString1)) || (paramInt <= 0) || (Util.isNullOrNil(paramString2)) || (!com.tencent.mm.vfs.s.YS(paramString2)))
    {
      Log.w("MicroMsg.NetScenePreloadVideoFake", "insert media duplication but args is error.[%d, %s, %s]", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
      AppMethodBeat.o(126850);
      return false;
    }
    boolean bool = ((com.tencent.mm.plugin.m.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.m.a.a.class)).aSV().P(paramString1, paramInt, paramString2);
    AppMethodBeat.o(126850);
    return bool;
  }
  
  final void Qe(String paramString)
  {
    AppMethodBeat.i(126851);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.jqE).append(",");
    localStringBuffer.append(this.jqF).append(",");
    localStringBuffer.append(this.jqG).append(",");
    localStringBuffer.append(this.jqI).append(",");
    localStringBuffer.append(this.jqH).append(",");
    try
    {
      long l = this.jqG / 1024L / (this.jqF - this.jqE);
      i = (int)l;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = 0;
      }
    }
    localStringBuffer.append(i).append(",");
    localStringBuffer.append(0).append(",");
    localStringBuffer.append(paramString).append(",");
    localStringBuffer.append(this.jqr.dRL).append(",");
    localStringBuffer.append(this.jqr.gqV).append(",");
    localStringBuffer.append(this.jqr.dRN).append(",");
    localStringBuffer.append(this.jqr.field_fileId).append(",");
    localStringBuffer.append(this.jqr.url).append(",");
    localStringBuffer.append(com.tencent.mm.plugin.video.c.aTR(this.jqr.dRS));
    paramString = localStringBuffer.toString();
    Log.d("MicroMsg.NetScenePreloadVideoFake", "%d rpt content[%s]", new Object[] { Integer.valueOf(hashCode()), paramString });
    new hb(paramString).bfK();
    AppMethodBeat.o(126851);
  }
  
  public final int a(a parama)
  {
    AppMethodBeat.i(126847);
    this.jqL = parama;
    Object localObject;
    int i;
    label187:
    label215:
    String str1;
    int j;
    for (;;)
    {
      try
      {
        Log.i("MicroMsg.NetScenePreloadVideoFake", "%d preload begin msgId[%d]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(this.msgId) });
        if (this.jqC)
        {
          parama = ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(this.msgId);
          localObject = bp.Ky(parama.fqK);
          if ((localObject == null) || (((bp.b)localObject).iEG <= 0))
          {
            Log.w("MicroMsg.NetScenePreloadVideoFake", "%d msgsource is null", new Object[] { Integer.valueOf(hashCode()) });
            parama = null;
            if (parama != null)
            {
              if (!ab.Eq(parama.gqV)) {
                break label1015;
              }
              i = 2;
              this.jqH = i;
              com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 140L, 1L, false);
              if (this.jqH == 1) {
                com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 121L, 1L, false);
              }
            }
            else
            {
              if (this.jqr != null) {
                break label1002;
              }
              this.jqr = parama;
              if (parama != null) {
                break;
              }
              Log.w("MicroMsg.NetScenePreloadVideoFake", "%d preload task is null", new Object[] { Integer.valueOf(hashCode()) });
              i = 0;
              if (i == 0) {
                continue;
              }
              AppMethodBeat.o(126847);
              return 0;
            }
          }
          else
          {
            str1 = parama.field_imgPath;
            s locals = u.QN(str1);
            if (locals == null)
            {
              parama = null;
              continue;
            }
            parama = XmlParser.parseXml(locals.bhv(), "msg", null);
            if (parama == null)
            {
              Log.w("MicroMsg.NetScenePreloadVideoFake", "cdntra parse video recv xml failed");
              parama = null;
              continue;
            }
            String str2 = (String)parama.get(".msg.videomsg.$cdnvideourl");
            if (Util.isNullOrNil(str2))
            {
              Log.w("MicroMsg.NetScenePreloadVideoFake", "cdntra parse video recv xml failed");
              parama = null;
              continue;
            }
            j = Util.getInt((String)parama.get(".msg.videomsg.$length"), 0);
            String str3 = (String)parama.get(".msg.videomsg.$md5");
            String str4 = (String)parama.get(".msg.videomsg.$newmd5");
            String str5 = (String)parama.get(".msg.videomsg.$aeskey");
            String str6 = (String)parama.get(".msg.videomsg.$fileparam");
            String str7 = com.tencent.mm.an.c.a("downvideo", locals.createTime, locals.getUser(), locals.getFileName());
            if (Util.isNullOrNil(str7))
            {
              Log.w("MicroMsg.NetScenePreloadVideoFake", "cdntra genClientId failed not use cdn file:%s", new Object[] { locals.getFileName() });
              parama = null;
              continue;
            }
            o.bhj();
            String str8 = t.Qw(str1);
            parama = new com.tencent.mm.i.h();
            parama.taskName = "task_NetScenePreloadVideoFake";
            parama.filename = str1;
            parama.gqS = str3;
            parama.gqT = j;
            parama.gqU = 2;
            parama.dRL = locals.bhs();
            parama.gqV = locals.getUser();
            if (!ab.Eq(locals.getUser())) {
              break label1005;
            }
            i = v.Ie(locals.getUser());
            label529:
            parama.dRN = i;
            parama.field_mediaId = str7;
            parama.field_fullpath = str8;
            parama.field_fileType = com.tencent.mm.i.a.MediaType_VIDEO;
            parama.field_totalLen = j;
            parama.field_aesKey = str5;
            parama.field_fileId = str2;
            parama.field_priority = com.tencent.mm.i.a.gpM;
            parama.field_wxmsgparam = str6;
            if (!ab.Eq(locals.getUser())) {
              break label1010;
            }
            i = 1;
            label596:
            parama.field_chattype = i;
            parama.field_autostart = false;
            parama.field_requestVideoFormat = com.tencent.mm.modelcontrol.e.a(2, locals);
            parama.field_preloadRatio = ((bp.b)localObject).iEG;
            parama.djw = str4;
            continue;
          }
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 122L, 1L, false);
          continue;
        }
        if (!this.jqK) {
          break label1020;
        }
      }
      catch (Exception parama)
      {
        Log.printErrStackTrace("MicroMsg.NetScenePreloadVideoFake", parama, "", new Object[0]);
        this.jqL = null;
        AppMethodBeat.o(126847);
        return -1;
      }
      i = 4;
      label686:
      this.jqH = i;
      parama = this.jqr;
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(354L, 141L, 1L, false);
    }
    if (((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NYD, Integer.valueOf(-1))).intValue() == 2) {
      Log.i("MicroMsg.NetScenePreloadVideoFake", "command set do not check media duplication.");
    }
    for (;;)
    {
      if (i != 0)
      {
        Log.i("MicroMsg.NetScenePreloadVideoFake", "%d it already had video file", new Object[] { Integer.valueOf(hashCode()) });
        i = 0;
        break label215;
        if (parama.alR()) {
          break label1025;
        }
        localObject = parama.gqS;
        i = parama.gqT;
        str1 = ((com.tencent.mm.plugin.m.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.m.a.a.class)).aSV().gS((String)localObject, i);
        j = i - (int)com.tencent.mm.vfs.s.boW(str1);
        if ((Util.isNullOrNil(str1)) || (j < 0) || (j > 16)) {
          break label1025;
        }
        Log.i("MicroMsg.NetScenePreloadVideoFake", "it had download this video[%d, %s, %s].", new Object[] { Integer.valueOf(i), localObject, str1 });
        com.tencent.mm.vfs.s.nw(str1, parama.field_fullpath);
        l(parama.filename, i, (String)localObject);
        i = 1;
        continue;
      }
      parama.gqQ = this.gqQ;
      parama.gqy = this.iZc;
      parama.gqO = 2;
      this.gqS = parama.gqS;
      this.mediaId = parama.field_mediaId;
      this.jqD = parama.filename;
      this.jqE = Util.nowSecond();
      this.jqI = parama.djw;
      Log.i("MicroMsg.NetScenePreloadVideoFake", "%d send to cdn service task[%s]", new Object[] { Integer.valueOf(hashCode()), parama });
      com.tencent.mm.an.f.baQ().b(parama, -1);
      i = 1;
      break label215;
      label1002:
      break label187;
      label1005:
      i = 0;
      break label529;
      label1010:
      i = 0;
      break label596;
      label1015:
      i = 1;
      break;
      label1020:
      i = 3;
      break label686;
      label1025:
      i = 0;
    }
  }
  
  public final String bha()
  {
    AppMethodBeat.i(126845);
    if (this.jqC)
    {
      str = this.msgId;
      AppMethodBeat.o(126845);
      return str;
    }
    String str = this.dHp;
    AppMethodBeat.o(126845);
    return str;
  }
  
  final void l(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(126849);
    Log.i("MicroMsg.NetScenePreloadVideoFake", "%d update finish video [%s] [%d] [%s]", new Object[] { Integer.valueOf(hashCode()), paramString1, Integer.valueOf(paramInt), paramString2 });
    if (u.QN(paramString1) != null)
    {
      u.ay(paramString1, paramInt);
      i(paramInt, paramString2, paramString1);
    }
    AppMethodBeat.o(126849);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(126846);
    Log.i("MicroMsg.NetScenePreloadVideoFake", "%d stop preload video[%s]", new Object[] { Integer.valueOf(hashCode()), this.mediaId });
    if (!Util.isNullOrNil(this.mediaId))
    {
      d locald = new d();
      b localb = com.tencent.mm.an.f.baQ();
      String str = this.mediaId;
      int i = 0;
      com.tencent.mm.i.g localg = (com.tencent.mm.i.g)localb.iRA.remove(str);
      if (localg != null)
      {
        com.tencent.mm.an.f.baR();
        i = com.tencent.mm.an.a.c(str, locald);
        com.tencent.mm.plugin.report.service.h.CyF.a(10769, new Object[] { Integer.valueOf(com.tencent.mm.an.c.iSb), Integer.valueOf(localg.field_fileType), Long.valueOf(Util.nowMilliSecond() - localg.field_startTime) });
      }
      localb.iRz.remove(str);
      localb.iRB.remove(str);
      Log.i("MicroMsg.CdnTransportService", "summersafecdn cdntra cancelRecvTask mediaid:%s mapremove:%s engine ret:%d", new Object[] { str, localg, Integer.valueOf(i) });
      this.jqF = Util.nowSecond();
      this.jqG = e(this.jqD, (int)locald.field_recvedBytes, false);
      Qe(locald.alM());
    }
    this.jqL = null;
    AppMethodBeat.o(126846);
  }
  
  public static abstract interface a
  {
    public abstract void a(f paramf, boolean paramBoolean, int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvideo.f
 * JD-Core Version:    0.7.0.1
 */