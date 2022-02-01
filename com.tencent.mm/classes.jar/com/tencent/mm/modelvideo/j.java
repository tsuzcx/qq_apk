package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.autogen.mmdata.rpt.lq;
import com.tencent.mm.g.g.a;
import com.tencent.mm.g.g.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.br;
import com.tencent.mm.model.br.b;
import com.tencent.mm.modelcdntran.k;
import com.tencent.mm.modelcontrol.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cb;
import com.tencent.mm.vfs.y;
import java.io.ByteArrayOutputStream;
import java.util.Map;

public final class j
{
  public String hES;
  private g.b lxd;
  String lxg;
  private String mediaId;
  long msgId;
  private com.tencent.mm.g.h oYO;
  boolean oYZ;
  String oZa;
  private long oZb;
  long oZc;
  long oZd;
  int oZe;
  private String oZf;
  public long oZg;
  public boolean oZh;
  public a oZi;
  private g.a osH;
  
  public j(long paramLong)
  {
    AppMethodBeat.i(126843);
    this.oYZ = false;
    this.osH = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.g.c paramAnonymousc, com.tencent.mm.g.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(126841);
        if (paramAnonymousInt != 0)
        {
          Log.w("MicroMsg.NetScenePreloadVideoFake", "%d preload video error startRet[%d]", new Object[] { Integer.valueOf(j.this.hashCode()), Integer.valueOf(paramAnonymousInt) });
          if (j.this.oZi != null) {
            j.this.oZi.a(j.this, false, 0, 0);
          }
        }
        if (paramAnonymousc != null) {
          Log.d("MicroMsg.NetScenePreloadVideoFake", "%d preload video[%d %d] mediaId[%s]", new Object[] { Integer.valueOf(j.this.hashCode()), Long.valueOf(paramAnonymousc.field_finishedLength), Long.valueOf(paramAnonymousc.field_toltalLength), paramAnonymousString });
        }
        if (paramAnonymousd != null)
        {
          Log.i("MicroMsg.NetScenePreloadVideoFake", "%d preload video error [%d]", new Object[] { Integer.valueOf(j.this.hashCode()), Integer.valueOf(paramAnonymousd.field_retCode) });
          if (paramAnonymousd.field_retCode == 0) {
            break label205;
          }
          if (j.this.oZi != null) {
            j.this.oZi.a(j.this, false, 0, 0);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(126841);
          return 0;
          label205:
          Log.i("MicroMsg.NetScenePreloadVideoFake", "%d preload video download all video file", new Object[] { Integer.valueOf(j.this.hashCode()) });
          j.this.l(j.this.oZa, (int)paramAnonymousd.field_fileLength, j.this.lxg);
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] h(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return new byte[0];
      }
    };
    this.lxd = new g.b()
    {
      public final void b(String paramAnonymousString, com.tencent.mm.g.d paramAnonymousd)
      {
        AppMethodBeat.i(126842);
        if (paramAnonymousd == null)
        {
          Log.w("MicroMsg.NetScenePreloadVideoFake", "%s onPreload completed but sceneResult is null", new Object[] { Integer.valueOf(j.this.hashCode()) });
          if (j.this.oZi != null) {
            j.this.oZi.a(j.this, false, 0, 0);
          }
          AppMethodBeat.o(126842);
          return;
        }
        int i = (int)paramAnonymousd.field_recvedBytes;
        int j = (int)paramAnonymousd.field_fileLength;
        Log.i("MicroMsg.NetScenePreloadVideoFake", "%d onPreload Completed [%s] videoInfoName[%s] [%d, %d] videoFormat[%d]", new Object[] { Integer.valueOf(j.this.hashCode()), paramAnonymousString, j.this.oZa, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramAnonymousd.field_videoFormat) });
        if ((i > 0) && (j > 0)) {
          j.this.oZd = j.j(j.this.oZa, i, true);
        }
        boolean bool;
        if (j.this.oZi != null)
        {
          paramAnonymousString = j.this.oZi;
          j localj = j.this;
          if ((i > 0) && (j > 0))
          {
            bool = true;
            paramAnonymousString.a(localj, bool, i, j);
          }
        }
        else
        {
          j.this.oZc = Util.nowSecond();
          j.this.PD(paramAnonymousd.aLH());
          if (!j.this.oYZ) {
            break label342;
          }
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 142L, 1L, false);
          if (j.this.oZe != 1) {
            break label325;
          }
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 123L, 1L, false);
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, paramAnonymousd.field_videoFormat + 240, 1L, false);
          AppMethodBeat.o(126842);
          return;
          bool = false;
          break;
          label325:
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 124L, 1L, false);
        }
        label342:
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 143L, 1L, false);
        AppMethodBeat.o(126842);
      }
    };
    this.msgId = paramLong;
    this.oYZ = true;
    AppMethodBeat.o(126843);
  }
  
  public j(com.tencent.mm.g.h paramh, String paramString)
  {
    AppMethodBeat.i(126844);
    this.oYZ = false;
    this.osH = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.g.c paramAnonymousc, com.tencent.mm.g.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(126841);
        if (paramAnonymousInt != 0)
        {
          Log.w("MicroMsg.NetScenePreloadVideoFake", "%d preload video error startRet[%d]", new Object[] { Integer.valueOf(j.this.hashCode()), Integer.valueOf(paramAnonymousInt) });
          if (j.this.oZi != null) {
            j.this.oZi.a(j.this, false, 0, 0);
          }
        }
        if (paramAnonymousc != null) {
          Log.d("MicroMsg.NetScenePreloadVideoFake", "%d preload video[%d %d] mediaId[%s]", new Object[] { Integer.valueOf(j.this.hashCode()), Long.valueOf(paramAnonymousc.field_finishedLength), Long.valueOf(paramAnonymousc.field_toltalLength), paramAnonymousString });
        }
        if (paramAnonymousd != null)
        {
          Log.i("MicroMsg.NetScenePreloadVideoFake", "%d preload video error [%d]", new Object[] { Integer.valueOf(j.this.hashCode()), Integer.valueOf(paramAnonymousd.field_retCode) });
          if (paramAnonymousd.field_retCode == 0) {
            break label205;
          }
          if (j.this.oZi != null) {
            j.this.oZi.a(j.this, false, 0, 0);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(126841);
          return 0;
          label205:
          Log.i("MicroMsg.NetScenePreloadVideoFake", "%d preload video download all video file", new Object[] { Integer.valueOf(j.this.hashCode()) });
          j.this.l(j.this.oZa, (int)paramAnonymousd.field_fileLength, j.this.lxg);
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] h(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return new byte[0];
      }
    };
    this.lxd = new g.b()
    {
      public final void b(String paramAnonymousString, com.tencent.mm.g.d paramAnonymousd)
      {
        AppMethodBeat.i(126842);
        if (paramAnonymousd == null)
        {
          Log.w("MicroMsg.NetScenePreloadVideoFake", "%s onPreload completed but sceneResult is null", new Object[] { Integer.valueOf(j.this.hashCode()) });
          if (j.this.oZi != null) {
            j.this.oZi.a(j.this, false, 0, 0);
          }
          AppMethodBeat.o(126842);
          return;
        }
        int i = (int)paramAnonymousd.field_recvedBytes;
        int j = (int)paramAnonymousd.field_fileLength;
        Log.i("MicroMsg.NetScenePreloadVideoFake", "%d onPreload Completed [%s] videoInfoName[%s] [%d, %d] videoFormat[%d]", new Object[] { Integer.valueOf(j.this.hashCode()), paramAnonymousString, j.this.oZa, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramAnonymousd.field_videoFormat) });
        if ((i > 0) && (j > 0)) {
          j.this.oZd = j.j(j.this.oZa, i, true);
        }
        boolean bool;
        if (j.this.oZi != null)
        {
          paramAnonymousString = j.this.oZi;
          j localj = j.this;
          if ((i > 0) && (j > 0))
          {
            bool = true;
            paramAnonymousString.a(localj, bool, i, j);
          }
        }
        else
        {
          j.this.oZc = Util.nowSecond();
          j.this.PD(paramAnonymousd.aLH());
          if (!j.this.oYZ) {
            break label342;
          }
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 142L, 1L, false);
          if (j.this.oZe != 1) {
            break label325;
          }
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 123L, 1L, false);
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, paramAnonymousd.field_videoFormat + 240, 1L, false);
          AppMethodBeat.o(126842);
          return;
          bool = false;
          break;
          label325:
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 124L, 1L, false);
        }
        label342:
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 143L, 1L, false);
        AppMethodBeat.o(126842);
      }
    };
    this.oYO = paramh;
    this.hES = paramString;
    this.oYZ = false;
    AppMethodBeat.o(126844);
  }
  
  static int j(String paramString, int paramInt, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(126848);
    z localz = ab.Qo(paramString);
    int j;
    if (localz != null)
    {
      j = localz.hQV;
      if (paramBoolean)
      {
        localz.hQV = paramInt;
        Log.i("MicroMsg.NetScenePreloadVideoFake", "update video info[%s] preload[%d %d %d] isFinish[%b] ", new Object[] { paramString, Integer.valueOf(j), Integer.valueOf(paramInt), Integer.valueOf(localz.hQV), Boolean.valueOf(paramBoolean) });
        localz.pba = Util.nowSecond();
        localz.eQp = 1025;
        ab.f(localz);
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
      localz.hQV = (j + paramInt);
      break;
      break label114;
      AppMethodBeat.o(126848);
      return paramInt;
    }
  }
  
  private static boolean l(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(126850);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(126850);
      return false;
    }
    v.bOh();
    paramString2 = aa.PX(paramString2);
    if ((Util.isNullOrNil(paramString1)) || (paramInt <= 0) || (Util.isNullOrNil(paramString2)) || (!y.ZC(paramString2)))
    {
      Log.w("MicroMsg.NetScenePreloadVideoFake", "insert media duplication but args is error.[%d, %s, %s]", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
      AppMethodBeat.o(126850);
      return false;
    }
    boolean bool = ((com.tencent.mm.plugin.r.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.r.a.a.class)).bzI().W(paramString1, paramInt, paramString2);
    AppMethodBeat.o(126850);
    return bool;
  }
  
  final void PD(String paramString)
  {
    AppMethodBeat.i(126851);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.oZb).append(",");
    localStringBuffer.append(this.oZc).append(",");
    localStringBuffer.append(this.oZd).append(",");
    localStringBuffer.append(this.oZf).append(",");
    localStringBuffer.append(this.oZe).append(",");
    try
    {
      long l = this.oZd / 1024L / (this.oZc - this.oZb);
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
    localStringBuffer.append(this.oYO.hQQ).append(",");
    localStringBuffer.append(this.oYO.lxj).append(",");
    localStringBuffer.append(this.oYO.hQS).append(",");
    localStringBuffer.append(this.oYO.field_fileId).append(",");
    localStringBuffer.append(this.oYO.url).append(",");
    localStringBuffer.append(com.tencent.mm.plugin.video.c.beW(this.oYO.hQX));
    paramString = localStringBuffer.toString();
    Log.d("MicroMsg.NetScenePreloadVideoFake", "%d rpt content[%s]", new Object[] { Integer.valueOf(hashCode()), paramString });
    new lq(paramString).bMH();
    AppMethodBeat.o(126851);
  }
  
  public final int a(a parama)
  {
    AppMethodBeat.i(126847);
    this.oZi = parama;
    int i;
    label169:
    label197:
    Object localObject;
    String str1;
    int j;
    for (;;)
    {
      try
      {
        Log.i("MicroMsg.NetScenePreloadVideoFake", "%d preload begin msgId[%d]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(this.msgId) });
        if (this.oYZ)
        {
          parama = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(this.msgId);
          if (parama == null)
          {
            Log.w("MicroMsg.NetScenePreloadVideoFake", "%d check c2c task msg is null", new Object[] { Integer.valueOf(hashCode()) });
            parama = null;
            if (parama != null)
            {
              if (!au.bwE(parama.lxj)) {
                break label1047;
              }
              i = 2;
              this.oZe = i;
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 140L, 1L, false);
              if (this.oZe == 1) {
                com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 121L, 1L, false);
              }
            }
            else
            {
              if (this.oYO != null) {
                break label1034;
              }
              this.oYO = parama;
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
            localObject = br.JP(parama.jUr);
            if ((localObject == null) || (((br.b)localObject).omg <= 0))
            {
              Log.w("MicroMsg.NetScenePreloadVideoFake", "%d msgsource is null", new Object[] { Integer.valueOf(hashCode()) });
              parama = null;
              continue;
            }
            str1 = parama.field_imgPath;
            z localz = ab.Qo(str1);
            if (localz == null)
            {
              parama = null;
              continue;
            }
            parama = XmlParser.parseXml(localz.bOu(), "msg", null);
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
            String str7 = com.tencent.mm.modelcdntran.h.a("downvideo", localz.createTime, localz.bOs(), localz.getFileName());
            if (Util.isNullOrNil(str7))
            {
              Log.w("MicroMsg.NetScenePreloadVideoFake", "cdntra genClientId failed not use cdn file:%s", new Object[] { localz.getFileName() });
              parama = null;
              continue;
            }
            v.bOh();
            String str8 = aa.PX(str1);
            parama = new com.tencent.mm.g.h();
            parama.taskName = "task_NetScenePreloadVideoFake";
            parama.filename = str1;
            parama.lxg = str3;
            parama.lxh = j;
            parama.lxi = 2;
            parama.hQQ = localz.bOq();
            parama.lxj = localz.bOs();
            if (!au.bwE(localz.bOs())) {
              break label1037;
            }
            i = com.tencent.mm.model.v.getMembersCountByChatRoomName(localz.bOs());
            label560:
            parama.hQS = i;
            parama.field_mediaId = str7;
            parama.field_fullpath = str8;
            parama.field_fileType = com.tencent.mm.g.a.MediaType_VIDEO;
            parama.field_totalLen = j;
            parama.field_aesKey = str5;
            parama.field_fileId = str2;
            parama.field_priority = com.tencent.mm.g.a.lvZ;
            parama.field_wxmsgparam = str6;
            if (!au.bwE(localz.bOs())) {
              break label1042;
            }
            i = 1;
            label627:
            parama.field_chattype = i;
            parama.field_autostart = false;
            parama.field_requestVideoFormat = e.a(2, localz);
            parama.field_preloadRatio = ((br.b)localObject).omg;
            parama.heD = str4;
            continue;
          }
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 122L, 1L, false);
          continue;
        }
        if (!this.oZh) {
          break label1052;
        }
      }
      catch (Exception parama)
      {
        Log.printErrStackTrace("MicroMsg.NetScenePreloadVideoFake", parama, "", new Object[0]);
        this.oZi = null;
        AppMethodBeat.o(126847);
        return -1;
      }
      i = 4;
      label717:
      this.oZe = i;
      parama = this.oYO;
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 141L, 1L, false);
    }
    if (((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acNY, Integer.valueOf(-1))).intValue() == 2) {
      Log.i("MicroMsg.NetScenePreloadVideoFake", "command set do not check media duplication.");
    }
    for (;;)
    {
      if (i != 0)
      {
        Log.i("MicroMsg.NetScenePreloadVideoFake", "%d it already had video file", new Object[] { Integer.valueOf(hashCode()) });
        i = 0;
        break label197;
        if (parama.aLM()) {
          break label1057;
        }
        localObject = parama.lxg;
        i = parama.lxh;
        str1 = ((com.tencent.mm.plugin.r.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.r.a.a.class)).bzI().iI((String)localObject, i);
        j = i - (int)y.bEl(str1);
        if ((Util.isNullOrNil(str1)) || (j < 0) || (j > 16)) {
          break label1057;
        }
        Log.i("MicroMsg.NetScenePreloadVideoFake", "it had download this video[%d, %s, %s].", new Object[] { Integer.valueOf(i), localObject, str1 });
        y.O(str1, parama.field_fullpath, false);
        l(parama.filename, i, (String)localObject);
        i = 1;
        continue;
      }
      parama.lxd = this.lxd;
      parama.lwL = this.osH;
      parama.lxb = 2;
      this.lxg = parama.lxg;
      this.mediaId = parama.field_mediaId;
      this.oZa = parama.filename;
      this.oZb = Util.nowSecond();
      this.oZf = parama.heD;
      Log.i("MicroMsg.NetScenePreloadVideoFake", "%d send to cdn service task[%s]", new Object[] { Integer.valueOf(hashCode()), parama });
      k.bHW().b(parama, -1);
      i = 1;
      break label197;
      label1034:
      break label169;
      label1037:
      i = 0;
      break label560;
      label1042:
      i = 0;
      break label627;
      label1047:
      i = 1;
      break;
      label1052:
      i = 3;
      break label717;
      label1057:
      i = 0;
    }
  }
  
  public final String bNY()
  {
    AppMethodBeat.i(126845);
    if (this.oYZ)
    {
      str = this.msgId;
      AppMethodBeat.o(126845);
      return str;
    }
    String str = this.hES;
    AppMethodBeat.o(126845);
    return str;
  }
  
  final void l(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(126849);
    Log.i("MicroMsg.NetScenePreloadVideoFake", "%d update finish video [%s] [%d] [%s]", new Object[] { Integer.valueOf(hashCode()), paramString1, Integer.valueOf(paramInt), paramString2 });
    if (ab.Qo(paramString1) != null)
    {
      ab.be(paramString1, paramInt);
      l(paramInt, paramString2, paramString1);
    }
    AppMethodBeat.o(126849);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(126846);
    Log.i("MicroMsg.NetScenePreloadVideoFake", "%d stop preload video[%s]", new Object[] { Integer.valueOf(hashCode()), this.mediaId });
    if (!Util.isNullOrNil(this.mediaId))
    {
      com.tencent.mm.g.d locald = new com.tencent.mm.g.d();
      com.tencent.mm.modelcdntran.g localg = k.bHW();
      String str = this.mediaId;
      int i = 0;
      com.tencent.mm.g.g localg1 = (com.tencent.mm.g.g)localg.oAr.remove(str);
      if (localg1 != null)
      {
        k.bHX();
        i = com.tencent.mm.modelcdntran.d.c(str, locald);
        com.tencent.mm.plugin.report.service.h.OAn.b(10769, new Object[] { Integer.valueOf(com.tencent.mm.modelcdntran.h.oAS), Integer.valueOf(localg1.field_fileType), Long.valueOf(Util.nowMilliSecond() - localg1.field_startTime) });
      }
      localg.oAq.remove(str);
      localg.oAs.remove(str);
      Log.i("MicroMsg.CdnTransportService", "summersafecdn cdntra cancelRecvTask mediaid:%s mapremove:%s engine ret:%d", new Object[] { str, localg1, Integer.valueOf(i) });
      this.oZc = Util.nowSecond();
      this.oZd = j(this.oZa, (int)locald.field_recvedBytes, false);
      PD(locald.aLH());
    }
    this.oZi = null;
    AppMethodBeat.o(126846);
  }
  
  public static abstract interface a
  {
    public abstract void a(j paramj, boolean paramBoolean, int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelvideo.j
 * JD-Core Version:    0.7.0.1
 */