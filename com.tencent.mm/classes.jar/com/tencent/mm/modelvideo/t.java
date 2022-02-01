package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bm.e;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.s.a.a;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.protocal.protobuf.cuv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.storage.bz;
import com.tencent.mm.vfs.u;
import java.util.Arrays;

public final class t
  implements aa
{
  private VideoTransPara mhG = null;
  private VideoTransPara mhH = null;
  private String mhI;
  Boolean mhJ = Boolean.FALSE;
  private String srcPath;
  
  public final void XH(String paramString)
  {
    AppMethodBeat.i(126944);
    s.bqB();
    this.srcPath = x.XT(paramString);
    Object localObject1 = new StringBuilder();
    s.bqB();
    this.mhI = (x.XT(paramString) + ".tmp");
    Log.i("MicroMsg.TransferVideoMsgSendCallback", "srcPath： %s", new Object[] { this.srcPath });
    Log.i("MicroMsg.TransferVideoMsgSendCallback", "dstPath：%s", new Object[] { this.mhI });
    this.mhJ = Boolean.valueOf(e.Yt(this.srcPath));
    if (((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.wcy, 0) == 0) {}
    long l;
    for (boolean bool = true;; bool = false)
    {
      if (WeChatEnvironment.hasDebugger()) {
        bool = false;
      }
      Log.i("MicroMsg.TransferVideoMsgSendCallback", "needConvert hevc:%s", new Object[] { Boolean.valueOf(bool) });
      if ((!bool) || (!u.agG(this.srcPath)) || (!this.mhJ.booleanValue())) {
        break label374;
      }
      Log.i("MicroMsg.TransferVideoMsgSendCallback", "before video send, is h265");
      l = Util.currentTicks();
      if (u.agG(this.srcPath)) {
        break;
      }
      Log.e("MicroMsg.TransferVideoMsgSendCallback", "before video send, is h265 file not exist!");
      AppMethodBeat.o(126944);
      return;
    }
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 249L, 1L, false);
    this.mhH = e.Yu(this.srcPath);
    this.mhG = e.a(this.mhH, this.srcPath);
    if ((this.mhH != null) && (this.mhG != null))
    {
      if (e.a(this.srcPath, this.mhI, this.mhG) < 0) {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(354L, 250L, 1L, false);
      }
      u.oo(this.mhI, this.srcPath);
      u.deleteFile(this.mhI);
      paramString = y.Yk(paramString);
      if (paramString != null)
      {
        paramString.videoFormat = 1;
        paramString.cUP = 2;
        s.bqB().c(paramString);
      }
      Log.i("MicroMsg.TransferVideoMsgSendCallback", "transfer to h264 finish, used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
    }
    AppMethodBeat.o(126944);
    return;
    label374:
    Log.i("MicroMsg.TransferVideoMsgSendCallback", "video format is h264，do not need to tranfer");
    localObject1 = y.Yk(paramString);
    if ((localObject1 != null) && (!Util.isNullOrNil(((w)localObject1).bqN())) && (u.agG(((w)localObject1).bqN())))
    {
      Object localObject2 = ((w)localObject1).mia;
      if ((localObject2 == null) || (!((cuv)localObject2).TCA))
      {
        localObject2 = ((w)localObject1).bqN();
        s.bqB();
        paramString = x.XT(paramString);
        this.mhH = e.Yu((String)localObject2);
        this.mhG = e.a(this.mhH, (String)localObject2);
        if ((!u.agG(paramString)) && (this.mhH != null) && (this.mhG != null))
        {
          int[] arrayOfInt = new int[2];
          o.c((String)localObject2, arrayOfInt);
          l = Util.currentTicks();
          this.mhJ = Boolean.valueOf(e.Yt((String)localObject2));
          Log.i("MicroMsg.TransferVideoMsgSendCallback", "before video send, local remux file path not exist, do remux here, outsize: %s, localDstFilePath: %s, importPath: %s, isH265: %s", new Object[] { Arrays.toString(arrayOfInt), paramString, localObject2, this.mhJ });
          int i;
          if (this.mhJ.booleanValue())
          {
            i = e.a((String)localObject2, paramString, this.mhG);
            Log.i("MicroMsg.TransferVideoMsgSendCallback", "transfer to h264 finish, used %sms %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(i) });
          }
          for (;;)
          {
            if (this.mhH.duration > 0)
            {
              ((w)localObject1).lvw = this.mhH.duration;
              s.bqB().c((w)localObject1);
            }
            AppMethodBeat.o(126944);
            return;
            i = SightVideoJNI.remuxingVFS((String)localObject2, paramString, arrayOfInt[0], arrayOfInt[1], this.mhG.videoBitrate, this.mhG.lJn, 8, this.mhG.lJm, 25.0F, this.mhG.fps, null, 0, d.JrG, 0, 51);
            Log.i("MicroMsg.TransferVideoMsgSendCallback", "remux finish: %s, used %sms", new Object[] { Integer.valueOf(i), Long.valueOf(Util.ticksToNow(l)) });
            ((a)com.tencent.mm.kernel.h.ae(a.class)).bbT().aB((String)localObject2, paramString, i);
          }
        }
        Log.i("MicroMsg.TransferVideoMsgSendCallback", "before video send, is a local capture video, do nothing");
      }
    }
    AppMethodBeat.o(126944);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvideo.t
 * JD-Core Version:    0.7.0.1
 */