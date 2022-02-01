package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.fr;
import com.tencent.mm.autogen.b.ee;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.g.a;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelimage.j;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.modelvideo.aa;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.modelvideo.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.model.app.as;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.protocal.protobuf.dan;
import com.tencent.mm.protocal.protobuf.dao;
import com.tencent.mm.protocal.protobuf.dap;
import com.tencent.mm.protocal.protobuf.daq;
import com.tencent.mm.protocal.protobuf.dar;
import com.tencent.mm.protocal.protobuf.das;
import com.tencent.mm.protocal.protobuf.dat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.cc.c;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.util.Map;

public final class e
{
  static String ypA = "send_data_outdate";
  static String ypx = "send_data_sucess";
  static String ypy = "send_data_failed";
  static String ypz = "send_data_sending";
  
  static String a(com.tencent.mm.plugin.exdevice.i.b paramb)
  {
    AppMethodBeat.i(274606);
    if (paramb == null)
    {
      AppMethodBeat.o(274606);
      return "";
    }
    String str = null;
    if (!Util.isNullOrNil(paramb.kDc)) {
      str = paramb.kDc;
    }
    for (;;)
    {
      paramb = Util.nullAsNil(str);
      AppMethodBeat.o(274606);
      return paramb;
      if (!Util.isNullOrNil(paramb.kDd)) {
        str = paramb.kDd;
      } else if (paramb.field_mac != 0L) {
        str = com.tencent.mm.plugin.exdevice.k.b.lO(paramb.field_mac);
      } else if (!Util.isNullOrNil(paramb.field_deviceID)) {
        str = paramb.field_deviceID;
      }
    }
  }
  
  static boolean a(dao paramdao, long paramLong)
  {
    AppMethodBeat.i(274621);
    int i = -1;
    Object localObject5 = null;
    Object localObject2 = "";
    bh.bCz();
    Object localObject4 = com.tencent.mm.model.c.bzD().sl(paramLong);
    if ((localObject4 == null) || (((fi)localObject4).field_msgId == 0L))
    {
      localObject2 = "";
      if ((localObject2 == null) || (((String)localObject2).length() <= 0)) {
        break label1974;
      }
      localObject1 = new u((String)localObject2);
      localObject4 = ((u)localObject1).getName();
      i = (int)((u)localObject1).length();
      if (((String)localObject4).lastIndexOf(".") == -1) {
        break label1968;
      }
      localObject1 = ((String)localObject4).substring(((String)localObject4).lastIndexOf(".") + 1);
      label113:
      localObject5 = y.bub((String)localObject2);
      Log.i("MicroMsg.exdevice.ExDeviceUtil", "fileSize %s , fileMd5 %s", new Object[] { Integer.valueOf(i), localObject5 });
      localObject2 = localObject1;
    }
    for (Object localObject1 = localObject5;; localObject1 = localObject5)
    {
      bh.bCz();
      Object localObject6 = com.tencent.mm.model.c.bzD().sl(paramLong);
      if ((localObject6 == null) || (((fi)localObject6).field_msgId == 0L))
      {
        Log.w("MicroMsg.exdevice.ExDeviceUtil", "msgInfo or msgInfo.getMsgId() = 0");
        AppMethodBeat.o(274621);
        return false;
        int j = ((cc)localObject4).getType();
        localObject1 = ((fi)localObject4).field_content;
        if (((cc)localObject4).fxR())
        {
          localObject4 = k.b.Hf((String)localObject1);
          if ((localObject4 != null) && ((((k.b)localObject4).type == 6) || (((k.b)localObject4).type == 2)))
          {
            localObject1 = as.cWJ().bpI(((k.b)localObject4).hzM);
            if (localObject1 != null) {
              localObject1 = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath;
            }
          }
        }
        for (;;)
        {
          localObject2 = localObject1;
          break;
          Log.e("MicroMsg.exdevice.ExDeviceUtil", "getFilePath attInfo is null");
          localObject1 = localObject2;
          continue;
          localObject1 = localObject2;
          if (localObject4 != null)
          {
            localObject1 = localObject2;
            if (((k.b)localObject4).type != 3)
            {
              localObject1 = localObject2;
              if (((k.b)localObject4).type == 5)
              {
                localObject1 = localObject2;
                continue;
                if (j == 3)
                {
                  localObject4 = r.bKa().af((cc)localObject4);
                  localObject1 = localObject2;
                  if (localObject4 != null)
                  {
                    localObject2 = r.bKa().NY(((com.tencent.mm.modelimage.h)localObject4).oGr);
                    localObject1 = localObject2;
                    if (Util.isNullOrNil((String)localObject2)) {
                      localObject1 = r.bKa().NY(((com.tencent.mm.modelimage.h)localObject4).oGt);
                    }
                  }
                }
                else if (j != 62)
                {
                  localObject1 = localObject2;
                  if (j != 43) {}
                }
                else
                {
                  v.bOh();
                  localObject1 = aa.PX(((fi)localObject4).field_imgPath);
                }
              }
            }
          }
        }
      }
      if (((cc)localObject6).fxR())
      {
        localObject4 = k.b.Hf(((fi)localObject6).field_content);
        if (localObject4 == null)
        {
          Log.e("MicroMsg.exdevice.ExDeviceUtil", "get content is null");
          AppMethodBeat.o(274621);
          return false;
        }
        if ((((k.b)localObject4).type == 3) || (((k.b)localObject4).type == 76))
        {
          localObject1 = new dar();
          ((dar)localObject1).hAP = ((k.b)localObject4).title;
          ((dar)localObject1).aaGk = ((k.b)localObject4).description;
          ((dar)localObject1).Url = ((k.b)localObject4).url;
          ((dar)localObject1).aaGl = ((k.b)localObject4).nRc;
          ((dar)localObject1).ZjC = ((k.b)localObject4).nRx;
          ((dar)localObject1).aaGm = ((k.b)localObject4).nRy;
          ((dar)localObject1).IKJ = ((k.b)localObject4).appName;
          if (Util.isNullOrNil(((dar)localObject1).IKJ))
          {
            localObject2 = com.tencent.mm.pluginsdk.model.app.h.is(((k.b)localObject4).appId, ((k.b)localObject4).appVersion);
            if (localObject2 != null) {
              ((dar)localObject1).IKJ = ((g)localObject2).field_appName;
            }
          }
          ((dar)localObject1).aaGn = ((k.b)localObject4).nRr;
          ((dar)localObject1).aaGo = ((k.b)localObject4).nRs;
          ((dar)localObject1).aaGp = ((k.b)localObject4).nRv;
          paramdao.aaGb = ((dar)localObject1);
          paramdao.aaGa = 1;
          AppMethodBeat.o(274621);
          return true;
        }
        if (((k.b)localObject4).type == 6)
        {
          localObject5 = new dan();
          ((dan)localObject5).IGU = ((k.b)localObject4).title;
          ((dan)localObject5).crp = ((k.b)localObject4).nRe;
          if (Util.isNullOrNil(((dan)localObject5).crp)) {
            ((dan)localObject5).crp = ((String)localObject2);
          }
          localObject2 = ah.lw(paramLong);
          if (localObject2 != null)
          {
            Log.i("MicroMsg.exdevice.ExDeviceUtil", "gen from record");
            ((dan)localObject5).YKw = ((com.tencent.mm.plugin.exdevice.i.d)localObject2).field_fileid;
            ((dan)localObject5).ZaN = ((com.tencent.mm.plugin.exdevice.i.d)localObject2).field_aeskey;
            ((dan)localObject5).Md5 = ((com.tencent.mm.plugin.exdevice.i.d)localObject2).field_md5;
            ((dan)localObject5).vhE = ((com.tencent.mm.plugin.exdevice.i.d)localObject2).field_size;
            if (((dan)localObject5).vhE == 0) {
              ((dan)localObject5).vhE = i;
            }
            if (Util.isNullOrNil(((dan)localObject5).Md5)) {
              ((dan)localObject5).Md5 = ((String)localObject1);
            }
            if ((((k.b)localObject4).nRh == 0) && (((k.b)localObject4).nRd <= 26214400)) {
              break label975;
            }
          }
          label975:
          for (i = a.lwb;; i = a.MediaType_FILE)
          {
            ((dan)localObject5).aaFZ = i;
            Log.i("MicroMsg.exdevice.ExDeviceUtil", "fileMsg fileId %s aesKey %s cdn %d md5 %s fileSize %d name %s type %s", new Object[] { ((dan)localObject5).YKw, ((dan)localObject5).ZaN, Integer.valueOf(((dan)localObject5).aaFZ), ((dan)localObject5).Md5, Integer.valueOf(((dan)localObject5).vhE), ((dan)localObject5).IGU, ((dan)localObject5).crp });
            paramdao.aaGe = ((dan)localObject5);
            paramdao.aaGa = 4;
            AppMethodBeat.o(274621);
            return true;
            ((dan)localObject5).YKw = ((k.b)localObject4).nRq;
            ((dan)localObject5).ZaN = ((k.b)localObject4).aesKey;
            ((dan)localObject5).Md5 = ((k.b)localObject4).filemd5;
            ((dan)localObject5).vhE = ((k.b)localObject4).nRd;
            break;
          }
        }
        if (((k.b)localObject4).type == 5)
        {
          localObject1 = new das();
          ((das)localObject1).Url = ((k.b)localObject4).url;
          ((das)localObject1).hAP = ((k.b)localObject4).title;
          ((das)localObject1).aaGk = ((k.b)localObject4).description;
          ((das)localObject1).IKJ = ((k.b)localObject4).appName;
          if (Util.isNullOrNil(((das)localObject1).IKJ))
          {
            localObject2 = com.tencent.mm.pluginsdk.model.app.h.is(((k.b)localObject4).appId, ((k.b)localObject4).appVersion);
            if (localObject2 != null) {
              ((das)localObject1).IKJ = ((g)localObject2).field_appName;
            }
          }
          paramdao.aaGf = ((das)localObject1);
          paramdao.aaGa = 5;
          AppMethodBeat.o(274621);
          return true;
        }
      }
      else
      {
        if (((cc)localObject6).getType() == 3)
        {
          localObject5 = new dap();
          localObject6 = r.bKa().G(((fi)localObject6).field_talker, ((fi)localObject6).field_msgSvrId);
          ((dap)localObject5).IGU = ((String)localObject4);
          ((dap)localObject5).crp = ((String)localObject2);
          if (Util.isNullOrNil(((dap)localObject5).crp)) {
            ((dap)localObject5).crp = ".jpg";
          }
          localObject2 = ah.lw(paramLong);
          if (localObject2 != null)
          {
            Log.i("MicroMsg.exdevice.ExDeviceUtil", "gen from record");
            ((dap)localObject5).YKw = ((com.tencent.mm.plugin.exdevice.i.d)localObject2).field_fileid;
            ((dap)localObject5).ZaN = ((com.tencent.mm.plugin.exdevice.i.d)localObject2).field_aeskey;
            ((dap)localObject5).Md5 = ((com.tencent.mm.plugin.exdevice.i.d)localObject2).field_md5;
            ((dap)localObject5).vhE = ((com.tencent.mm.plugin.exdevice.i.d)localObject2).field_size;
            if (((dap)localObject5).Md5 == null) {
              ((dap)localObject5).Md5 = ((String)localObject1);
            }
            i = ((com.tencent.mm.modelimage.h)localObject6).oGu;
            ((dap)localObject5).aaFZ = 3;
            if (i == 1) {
              break label1474;
            }
          }
          label1474:
          for (((dap)localObject5).aaFZ = 2;; ((dap)localObject5).aaFZ = 1)
          {
            for (;;)
            {
              paramdao.aaGd = ((dap)localObject5);
              paramdao.aaGa = 3;
              Log.i("MicroMsg.exdevice.ExDeviceUtil", "imageMsg fileId %s aesKey %s cdn %d md5 %s size %d type %s", new Object[] { ((dap)localObject5).YKw, ((dap)localObject5).ZaN, Integer.valueOf(((dap)localObject5).aaFZ), ((dap)localObject5).Md5, Integer.valueOf(((dap)localObject5).vhE), ((dap)localObject5).crp });
              AppMethodBeat.o(274621);
              return true;
              ((dap)localObject5).YKw = ((com.tencent.mm.modelimage.h)localObject6).getFileId();
              ((dap)localObject5).ZaN = ((com.tencent.mm.modelimage.h)localObject6).getAesKey();
              localObject2 = null;
              localObject4 = XmlParser.parseXml(((com.tencent.mm.modelimage.h)localObject6).oGC, "msg", null);
              if (localObject4 != null) {
                localObject2 = (String)((Map)localObject4).get(".msg.img.$md5");
              }
              ((dap)localObject5).Md5 = ((String)localObject2);
              ((dap)localObject5).vhE = i;
              if (((dap)localObject5).vhE != 0) {
                break;
              }
              localObject2 = (String)((Map)localObject4).get(".msg.img.$length");
              if (localObject2 == null) {
                break;
              }
              try
              {
                ((dap)localObject5).vhE = Integer.parseInt((String)localObject2);
              }
              catch (NumberFormatException localNumberFormatException)
              {
                Log.w("MicroMsg.exdevice.ExDeviceUtil", "wrong size");
              }
            }
            break;
          }
        }
        if (((cc)localObject6).getType() == 48)
        {
          bh.bCz();
          localObject1 = com.tencent.mm.model.c.bzD().aLV(((fi)localObject6).field_content);
          localObject3 = new daq();
          ((daq)localObject3).X = ((float)((cc.c)localObject1).KbW);
          ((daq)localObject3).Y = ((float)((cc.c)localObject1).KbX);
          ((daq)localObject3).aaGi = ((cc.c)localObject1).hQp;
          ((daq)localObject3).ILD = ((cc.c)localObject1).label;
          ((daq)localObject3).aaGj = ((cc.c)localObject1).poiName;
          paramdao.aaGc = ((daq)localObject3);
          paramdao.aaGa = 2;
          AppMethodBeat.o(274621);
          return true;
        }
        if (((cc)localObject6).getType() == 43)
        {
          localObject5 = new dat();
          localObject6 = v.bOh().PR(((fi)localObject6).field_imgPath);
          Object localObject7 = XmlParser.parseXml(((z)localObject6).bOu(), "msg", null);
          if (localObject7 == null)
          {
            Log.w("MicroMsg.exdevice.ExDeviceUtil", "cdntra parse video recv xml failed");
            AppMethodBeat.o(274621);
            return false;
          }
          String str1 = (String)((Map)localObject7).get(".msg.videomsg.$md5");
          String str2 = (String)((Map)localObject7).get(".msg.videomsg.$cdnvideourl");
          localObject7 = (String)((Map)localObject7).get(".msg.videomsg.$aeskey");
          ((dat)localObject5).IGU = ((String)localObject4);
          if (Util.isNullOrNil(((dat)localObject5).IGU)) {
            ((dat)localObject5).IGU = ((z)localObject6).getFileName();
          }
          ((dat)localObject5).crp = ((String)localObject3);
          localObject3 = ah.lw(paramLong);
          if (localObject3 != null)
          {
            Log.i("MicroMsg.exdevice.ExDeviceUtil", "gen from record");
            ((dat)localObject5).fileid = ((com.tencent.mm.plugin.exdevice.i.d)localObject3).field_fileid;
            ((dat)localObject5).aeskey = ((com.tencent.mm.plugin.exdevice.i.d)localObject3).field_aeskey;
            ((dat)localObject5).Md5 = ((com.tencent.mm.plugin.exdevice.i.d)localObject3).field_md5;
          }
          for (((dat)localObject5).vhE = ((com.tencent.mm.plugin.exdevice.i.d)localObject3).field_size;; ((dat)localObject5).vhE = ((z)localObject6).osy)
          {
            if (Util.isNullOrNil(((dat)localObject5).Md5)) {
              ((dat)localObject5).Md5 = ((String)localObject1);
            }
            ((dat)localObject5).aaFZ = a.MediaType_VIDEO;
            paramdao.aaGg = ((dat)localObject5);
            paramdao.aaGa = 6;
            Log.i("MicroMsg.exdevice.ExDeviceUtil", "videoMsg url %s aesKey %s cdn %d Type %s Size %d Md5 %s Name %s type %s", new Object[] { ((dat)localObject5).fileid, ((dat)localObject5).aeskey, Integer.valueOf(((dat)localObject5).aaFZ), ((dat)localObject5).crp, Integer.valueOf(((dat)localObject5).vhE), ((dat)localObject5).Md5, ((dat)localObject5).IGU, ((dat)localObject5).crp });
            AppMethodBeat.o(274621);
            return true;
            ((dat)localObject5).fileid = str2;
            ((dat)localObject5).aeskey = ((String)localObject7);
            ((dat)localObject5).Md5 = str1;
          }
        }
      }
      AppMethodBeat.o(274621);
      return false;
      label1968:
      localObject1 = null;
      break label113;
      label1974:
      Object localObject3 = null;
      localObject4 = null;
    }
  }
  
  static Boolean aM(cc paramcc)
  {
    AppMethodBeat.i(274593);
    if ((paramcc == null) || (paramcc.field_msgId == 0L))
    {
      paramcc = Boolean.FALSE;
      AppMethodBeat.o(274593);
      return paramcc;
    }
    boolean bool2 = false;
    String str = paramcc.field_content;
    boolean bool1 = bool2;
    if (paramcc.fxR())
    {
      paramcc = k.b.Hf(str);
      bool1 = bool2;
      if (paramcc != null)
      {
        bool1 = bool2;
        if (paramcc.type == 6) {
          bool1 = true;
        }
      }
    }
    AppMethodBeat.o(274593);
    return Boolean.valueOf(bool1);
  }
  
  static Boolean aN(cc paramcc)
  {
    AppMethodBeat.i(274596);
    if ((paramcc == null) || (paramcc.field_msgId == 0L))
    {
      paramcc = Boolean.FALSE;
      AppMethodBeat.o(274596);
      return paramcc;
    }
    boolean bool = false;
    if (paramcc.getType() == 3) {
      bool = true;
    }
    AppMethodBeat.o(274596);
    return Boolean.valueOf(bool);
  }
  
  static Boolean aO(cc paramcc)
  {
    AppMethodBeat.i(274598);
    if ((paramcc == null) || (paramcc.field_msgId == 0L))
    {
      paramcc = Boolean.FALSE;
      AppMethodBeat.o(274598);
      return paramcc;
    }
    boolean bool = false;
    if (paramcc.jbK()) {
      bool = true;
    }
    AppMethodBeat.o(274598);
    return Boolean.valueOf(bool);
  }
  
  static Boolean aP(cc paramcc)
  {
    AppMethodBeat.i(274601);
    if ((paramcc == null) || (paramcc.field_msgId == 0L))
    {
      paramcc = Boolean.FALSE;
      AppMethodBeat.o(274601);
      return paramcc;
    }
    boolean bool = false;
    if (paramcc.getType() == 62) {
      bool = true;
    }
    AppMethodBeat.o(274601);
    return Boolean.valueOf(bool);
  }
  
  static Boolean aQ(cc paramcc)
  {
    AppMethodBeat.i(274604);
    if ((paramcc == null) || (paramcc.field_msgId == 0L))
    {
      paramcc = Boolean.FALSE;
      AppMethodBeat.o(274604);
      return paramcc;
    }
    boolean bool = false;
    if (paramcc.getType() == 43) {
      bool = true;
    }
    AppMethodBeat.o(274604);
    return Boolean.valueOf(bool);
  }
  
  /* Error */
  static String ag(String paramString, long paramLong)
  {
    // Byte code:
    //   0: ldc_w 607
    //   3: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ifnonnull +11 -> 18
    //   10: ldc_w 607
    //   13: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   16: aconst_null
    //   17: areturn
    //   18: aload_0
    //   19: iconst_0
    //   20: aload_0
    //   21: ldc_w 609
    //   24: invokevirtual 127	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   27: invokevirtual 612	java/lang/String:substring	(II)Ljava/lang/String;
    //   30: astore_3
    //   31: new 614	java/lang/StringBuilder
    //   34: dup
    //   35: ldc_w 616
    //   38: invokespecial 617	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   41: aload_0
    //   42: invokevirtual 620	java/lang/String:hashCode	()I
    //   45: invokevirtual 624	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   48: invokevirtual 627	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: astore 4
    //   53: new 614	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 628	java/lang/StringBuilder:<init>	()V
    //   60: aload_3
    //   61: invokevirtual 631	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: ldc_w 609
    //   67: invokevirtual 631	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: aload 4
    //   72: invokevirtual 631	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: invokevirtual 627	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: astore 6
    //   80: new 110	com/tencent/mm/vfs/u
    //   83: dup
    //   84: aload 6
    //   86: invokespecial 114	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   89: astore_3
    //   90: lload_1
    //   91: lconst_0
    //   92: lcmp
    //   93: ifne +117 -> 210
    //   96: new 633	com/tencent/mm/vfs/aa
    //   99: dup
    //   100: aload_3
    //   101: invokespecial 636	com/tencent/mm/vfs/aa:<init>	(Lcom/tencent/mm/vfs/u;)V
    //   104: astore_3
    //   105: aload_0
    //   106: invokestatic 640	com/tencent/mm/vfs/y:Lh	(Ljava/lang/String;)Ljava/io/InputStream;
    //   109: astore_0
    //   110: aload_0
    //   111: astore 5
    //   113: aload_3
    //   114: astore 4
    //   116: sipush 1024
    //   119: newarray byte
    //   121: astore 7
    //   123: aload_0
    //   124: astore 5
    //   126: aload_3
    //   127: astore 4
    //   129: aload_0
    //   130: aload 7
    //   132: invokevirtual 646	java/io/InputStream:read	([B)I
    //   135: iconst_m1
    //   136: if_icmpeq +96 -> 232
    //   139: aload_0
    //   140: astore 5
    //   142: aload_3
    //   143: astore 4
    //   145: aload_3
    //   146: aload 7
    //   148: invokevirtual 652	java/io/OutputStream:write	([B)V
    //   151: goto -28 -> 123
    //   154: astore 6
    //   156: aload_0
    //   157: astore 5
    //   159: aload_3
    //   160: astore 4
    //   162: ldc 138
    //   164: ldc_w 654
    //   167: iconst_1
    //   168: anewarray 4	java/lang/Object
    //   171: dup
    //   172: iconst_0
    //   173: aload 6
    //   175: invokevirtual 657	java/io/IOException:getMessage	()Ljava/lang/String;
    //   178: aastore
    //   179: invokestatic 659	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   182: aload_3
    //   183: ifnull +11 -> 194
    //   186: aload_3
    //   187: invokevirtual 662	java/io/OutputStream:flush	()V
    //   190: aload_3
    //   191: invokevirtual 665	java/io/OutputStream:close	()V
    //   194: aload_0
    //   195: ifnull +7 -> 202
    //   198: aload_0
    //   199: invokevirtual 666	java/io/InputStream:close	()V
    //   202: ldc_w 607
    //   205: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   208: aconst_null
    //   209: areturn
    //   210: new 668	com/tencent/mm/modelsfs/b
    //   213: dup
    //   214: aload_3
    //   215: lload_1
    //   216: invokespecial 671	com/tencent/mm/modelsfs/b:<init>	(Lcom/tencent/mm/vfs/u;J)V
    //   219: astore_3
    //   220: goto -115 -> 105
    //   223: astore 6
    //   225: aconst_null
    //   226: astore_0
    //   227: aconst_null
    //   228: astore_3
    //   229: goto -73 -> 156
    //   232: aload_3
    //   233: invokevirtual 662	java/io/OutputStream:flush	()V
    //   236: aload_3
    //   237: invokevirtual 665	java/io/OutputStream:close	()V
    //   240: aload_0
    //   241: ifnull +7 -> 248
    //   244: aload_0
    //   245: invokevirtual 666	java/io/InputStream:close	()V
    //   248: ldc_w 607
    //   251: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   254: aload 6
    //   256: areturn
    //   257: astore_0
    //   258: ldc 138
    //   260: aload_0
    //   261: ldc 42
    //   263: iconst_0
    //   264: anewarray 4	java/lang/Object
    //   267: invokestatic 675	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   270: ldc_w 607
    //   273: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   276: aconst_null
    //   277: areturn
    //   278: astore_0
    //   279: ldc 138
    //   281: aload_0
    //   282: ldc 42
    //   284: iconst_0
    //   285: anewarray 4	java/lang/Object
    //   288: invokestatic 675	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   291: ldc_w 607
    //   294: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   297: aconst_null
    //   298: areturn
    //   299: astore_0
    //   300: ldc 138
    //   302: aload_0
    //   303: ldc 42
    //   305: iconst_0
    //   306: anewarray 4	java/lang/Object
    //   309: invokestatic 675	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   312: ldc_w 607
    //   315: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   318: aconst_null
    //   319: areturn
    //   320: astore_0
    //   321: ldc 138
    //   323: aload_0
    //   324: ldc 42
    //   326: iconst_0
    //   327: anewarray 4	java/lang/Object
    //   330: invokestatic 675	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   333: ldc_w 607
    //   336: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   339: aconst_null
    //   340: areturn
    //   341: astore_0
    //   342: aconst_null
    //   343: astore 5
    //   345: aconst_null
    //   346: astore_3
    //   347: aload_3
    //   348: ifnull +11 -> 359
    //   351: aload_3
    //   352: invokevirtual 662	java/io/OutputStream:flush	()V
    //   355: aload_3
    //   356: invokevirtual 665	java/io/OutputStream:close	()V
    //   359: aload 5
    //   361: ifnull +8 -> 369
    //   364: aload 5
    //   366: invokevirtual 666	java/io/InputStream:close	()V
    //   369: ldc_w 607
    //   372: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   375: aload_0
    //   376: athrow
    //   377: astore_0
    //   378: ldc 138
    //   380: aload_0
    //   381: ldc 42
    //   383: iconst_0
    //   384: anewarray 4	java/lang/Object
    //   387: invokestatic 675	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   390: ldc_w 607
    //   393: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   396: aconst_null
    //   397: areturn
    //   398: astore_0
    //   399: ldc 138
    //   401: aload_0
    //   402: ldc 42
    //   404: iconst_0
    //   405: anewarray 4	java/lang/Object
    //   408: invokestatic 675	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   411: ldc_w 607
    //   414: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   417: aconst_null
    //   418: areturn
    //   419: astore_0
    //   420: aconst_null
    //   421: astore 5
    //   423: goto -76 -> 347
    //   426: astore_0
    //   427: aload 4
    //   429: astore_3
    //   430: goto -83 -> 347
    //   433: astore 6
    //   435: aconst_null
    //   436: astore_0
    //   437: goto -281 -> 156
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	440	0	paramString	String
    //   0	440	1	paramLong	long
    //   30	400	3	localObject1	Object
    //   51	377	4	localObject2	Object
    //   111	311	5	str1	String
    //   78	7	6	str2	String
    //   154	20	6	localIOException1	java.io.IOException
    //   223	32	6	localIOException2	java.io.IOException
    //   433	1	6	localIOException3	java.io.IOException
    //   121	26	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   116	123	154	java/io/IOException
    //   129	139	154	java/io/IOException
    //   145	151	154	java/io/IOException
    //   80	90	223	java/io/IOException
    //   96	105	223	java/io/IOException
    //   210	220	223	java/io/IOException
    //   232	240	257	java/io/IOException
    //   244	248	278	java/io/IOException
    //   186	194	299	java/io/IOException
    //   198	202	320	java/io/IOException
    //   80	90	341	finally
    //   96	105	341	finally
    //   210	220	341	finally
    //   351	359	377	java/io/IOException
    //   364	369	398	java/io/IOException
    //   105	110	419	finally
    //   116	123	426	finally
    //   129	139	426	finally
    //   145	151	426	finally
    //   162	182	426	finally
    //   105	110	433	java/io/IOException
  }
  
  /* Error */
  static byte[] apr(String paramString)
  {
    // Byte code:
    //   0: ldc_w 680
    //   3: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 138
    //   8: ldc_w 682
    //   11: iconst_1
    //   12: anewarray 4	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: aload_0
    //   18: aastore
    //   19: invokestatic 685	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   22: aload_0
    //   23: aconst_null
    //   24: invokestatic 690	com/tencent/mm/network/d:a	(Ljava/lang/String;Lcom/tencent/mm/network/d$b;)Lcom/tencent/mm/network/y;
    //   27: astore_2
    //   28: aload_2
    //   29: ldc_w 692
    //   32: invokevirtual 697	com/tencent/mm/network/y:Rx	(Ljava/lang/String;)V
    //   35: aload_2
    //   36: sipush 25000
    //   39: invokevirtual 700	com/tencent/mm/network/y:xx	(I)V
    //   42: aload_2
    //   43: sipush 25000
    //   46: invokevirtual 703	com/tencent/mm/network/y:xy	(I)V
    //   49: aload_2
    //   50: invokevirtual 707	com/tencent/mm/network/y:getInputStream	()Ljava/io/InputStream;
    //   53: astore_3
    //   54: aload_2
    //   55: invokevirtual 710	com/tencent/mm/network/y:getResponseCode	()I
    //   58: sipush 200
    //   61: if_icmpne +243 -> 304
    //   64: new 712	java/io/ByteArrayOutputStream
    //   67: dup
    //   68: invokespecial 713	java/io/ByteArrayOutputStream:<init>	()V
    //   71: astore_0
    //   72: aload_2
    //   73: astore 7
    //   75: aload_3
    //   76: astore 6
    //   78: aload_0
    //   79: astore 5
    //   81: sipush 1024
    //   84: newarray byte
    //   86: astore 4
    //   88: aload_2
    //   89: astore 7
    //   91: aload_3
    //   92: astore 6
    //   94: aload_0
    //   95: astore 5
    //   97: aload_3
    //   98: aload 4
    //   100: invokevirtual 646	java/io/InputStream:read	([B)I
    //   103: istore_1
    //   104: iload_1
    //   105: iconst_m1
    //   106: if_icmpeq +79 -> 185
    //   109: aload_2
    //   110: astore 7
    //   112: aload_3
    //   113: astore 6
    //   115: aload_0
    //   116: astore 5
    //   118: aload_0
    //   119: aload 4
    //   121: iconst_0
    //   122: iload_1
    //   123: invokevirtual 716	java/io/ByteArrayOutputStream:write	([BII)V
    //   126: goto -38 -> 88
    //   129: astore 4
    //   131: aload_2
    //   132: astore 7
    //   134: aload_3
    //   135: astore 6
    //   137: aload_0
    //   138: astore 5
    //   140: ldc 138
    //   142: aload 4
    //   144: ldc 42
    //   146: iconst_0
    //   147: anewarray 4	java/lang/Object
    //   150: invokestatic 675	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   153: aload_0
    //   154: ifnull +7 -> 161
    //   157: aload_0
    //   158: invokevirtual 717	java/io/ByteArrayOutputStream:close	()V
    //   161: aload_3
    //   162: ifnull +7 -> 169
    //   165: aload_3
    //   166: invokevirtual 666	java/io/InputStream:close	()V
    //   169: aload_2
    //   170: ifnull +7 -> 177
    //   173: aload_2
    //   174: invokevirtual 720	com/tencent/mm/network/y:disconnect	()V
    //   177: ldc_w 680
    //   180: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   183: aconst_null
    //   184: areturn
    //   185: aload_2
    //   186: astore 7
    //   188: aload_3
    //   189: astore 6
    //   191: aload_0
    //   192: astore 5
    //   194: aload_0
    //   195: invokevirtual 717	java/io/ByteArrayOutputStream:close	()V
    //   198: aload_2
    //   199: astore 7
    //   201: aload_3
    //   202: astore 6
    //   204: aload_0
    //   205: astore 5
    //   207: aload_3
    //   208: invokevirtual 666	java/io/InputStream:close	()V
    //   211: aload_2
    //   212: ifnull +16 -> 228
    //   215: aload_2
    //   216: astore 7
    //   218: aload_3
    //   219: astore 6
    //   221: aload_0
    //   222: astore 5
    //   224: aload_2
    //   225: invokevirtual 720	com/tencent/mm/network/y:disconnect	()V
    //   228: aload_2
    //   229: astore 7
    //   231: aload_3
    //   232: astore 6
    //   234: aload_0
    //   235: astore 5
    //   237: aload_0
    //   238: invokevirtual 724	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   241: astore 4
    //   243: aload_0
    //   244: invokevirtual 717	java/io/ByteArrayOutputStream:close	()V
    //   247: aload_3
    //   248: ifnull +7 -> 255
    //   251: aload_3
    //   252: invokevirtual 666	java/io/InputStream:close	()V
    //   255: aload_2
    //   256: ifnull +7 -> 263
    //   259: aload_2
    //   260: invokevirtual 720	com/tencent/mm/network/y:disconnect	()V
    //   263: ldc_w 680
    //   266: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   269: aload 4
    //   271: areturn
    //   272: astore_0
    //   273: ldc 138
    //   275: aload_0
    //   276: ldc 42
    //   278: iconst_0
    //   279: anewarray 4	java/lang/Object
    //   282: invokestatic 675	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   285: goto -38 -> 247
    //   288: astore_0
    //   289: ldc 138
    //   291: aload_0
    //   292: ldc 42
    //   294: iconst_0
    //   295: anewarray 4	java/lang/Object
    //   298: invokestatic 675	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   301: goto -46 -> 255
    //   304: aload_3
    //   305: ifnull +7 -> 312
    //   308: aload_3
    //   309: invokevirtual 666	java/io/InputStream:close	()V
    //   312: aload_2
    //   313: ifnull -136 -> 177
    //   316: aload_2
    //   317: invokevirtual 720	com/tencent/mm/network/y:disconnect	()V
    //   320: goto -143 -> 177
    //   323: astore_0
    //   324: ldc 138
    //   326: aload_0
    //   327: ldc 42
    //   329: iconst_0
    //   330: anewarray 4	java/lang/Object
    //   333: invokestatic 675	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   336: goto -24 -> 312
    //   339: astore_0
    //   340: ldc 138
    //   342: aload_0
    //   343: ldc 42
    //   345: iconst_0
    //   346: anewarray 4	java/lang/Object
    //   349: invokestatic 675	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   352: goto -191 -> 161
    //   355: astore_0
    //   356: ldc 138
    //   358: aload_0
    //   359: ldc 42
    //   361: iconst_0
    //   362: anewarray 4	java/lang/Object
    //   365: invokestatic 675	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   368: goto -199 -> 169
    //   371: astore_0
    //   372: aconst_null
    //   373: astore 7
    //   375: aconst_null
    //   376: astore_3
    //   377: aconst_null
    //   378: astore_2
    //   379: aload_2
    //   380: ifnull +7 -> 387
    //   383: aload_2
    //   384: invokevirtual 717	java/io/ByteArrayOutputStream:close	()V
    //   387: aload_3
    //   388: ifnull +7 -> 395
    //   391: aload_3
    //   392: invokevirtual 666	java/io/InputStream:close	()V
    //   395: aload 7
    //   397: ifnull +8 -> 405
    //   400: aload 7
    //   402: invokevirtual 720	com/tencent/mm/network/y:disconnect	()V
    //   405: ldc_w 680
    //   408: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   411: aload_0
    //   412: athrow
    //   413: astore_2
    //   414: ldc 138
    //   416: aload_2
    //   417: ldc 42
    //   419: iconst_0
    //   420: anewarray 4	java/lang/Object
    //   423: invokestatic 675	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   426: goto -39 -> 387
    //   429: astore_2
    //   430: ldc 138
    //   432: aload_2
    //   433: ldc 42
    //   435: iconst_0
    //   436: anewarray 4	java/lang/Object
    //   439: invokestatic 675	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   442: goto -47 -> 395
    //   445: astore_0
    //   446: aconst_null
    //   447: astore_3
    //   448: aconst_null
    //   449: astore 4
    //   451: aload_2
    //   452: astore 7
    //   454: aload 4
    //   456: astore_2
    //   457: goto -78 -> 379
    //   460: astore_0
    //   461: aconst_null
    //   462: astore 4
    //   464: aload_2
    //   465: astore 7
    //   467: aload 4
    //   469: astore_2
    //   470: goto -91 -> 379
    //   473: astore_0
    //   474: aload 6
    //   476: astore_3
    //   477: aload 5
    //   479: astore_2
    //   480: goto -101 -> 379
    //   483: astore 4
    //   485: aconst_null
    //   486: astore_2
    //   487: aconst_null
    //   488: astore_3
    //   489: aconst_null
    //   490: astore_0
    //   491: goto -360 -> 131
    //   494: astore 4
    //   496: aconst_null
    //   497: astore_3
    //   498: aconst_null
    //   499: astore_0
    //   500: goto -369 -> 131
    //   503: astore 4
    //   505: aconst_null
    //   506: astore_0
    //   507: goto -376 -> 131
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	510	0	paramString	String
    //   103	20	1	i	int
    //   27	357	2	localy	com.tencent.mm.network.y
    //   413	4	2	localIOException1	java.io.IOException
    //   429	23	2	localIOException2	java.io.IOException
    //   456	31	2	localObject1	Object
    //   53	445	3	localObject2	Object
    //   86	34	4	arrayOfByte1	byte[]
    //   129	14	4	localException1	java.lang.Exception
    //   241	227	4	arrayOfByte2	byte[]
    //   483	1	4	localException2	java.lang.Exception
    //   494	1	4	localException3	java.lang.Exception
    //   503	1	4	localException4	java.lang.Exception
    //   79	399	5	str	String
    //   76	399	6	localObject3	Object
    //   73	393	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   81	88	129	java/lang/Exception
    //   97	104	129	java/lang/Exception
    //   118	126	129	java/lang/Exception
    //   194	198	129	java/lang/Exception
    //   207	211	129	java/lang/Exception
    //   224	228	129	java/lang/Exception
    //   237	243	129	java/lang/Exception
    //   243	247	272	java/io/IOException
    //   251	255	288	java/io/IOException
    //   308	312	323	java/io/IOException
    //   157	161	339	java/io/IOException
    //   165	169	355	java/io/IOException
    //   22	28	371	finally
    //   383	387	413	java/io/IOException
    //   391	395	429	java/io/IOException
    //   28	54	445	finally
    //   54	72	460	finally
    //   81	88	473	finally
    //   97	104	473	finally
    //   118	126	473	finally
    //   140	153	473	finally
    //   194	198	473	finally
    //   207	211	473	finally
    //   224	228	473	finally
    //   237	243	473	finally
    //   22	28	483	java/lang/Exception
    //   28	54	494	java/lang/Exception
    //   54	72	503	java/lang/Exception
  }
  
  static void ee(String paramString, int paramInt)
  {
    AppMethodBeat.i(274627);
    fr localfr = new fr();
    localfr.hFV.hEl = paramString;
    if (paramInt >= 100) {}
    for (localfr.hFV.hFX = ypx;; localfr.hFV.hFX = ypz)
    {
      localfr.hFV.progress = paramInt;
      localfr.publish();
      AppMethodBeat.o(274627);
      return;
    }
  }
  
  static void gR(String paramString1, String paramString2)
  {
    AppMethodBeat.i(274623);
    fr localfr = new fr();
    localfr.hFV.hFX = paramString2;
    localfr.hFV.hEl = paramString1;
    localfr.publish();
    AppMethodBeat.o(274623);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.e
 * JD-Core Version:    0.7.0.1
 */