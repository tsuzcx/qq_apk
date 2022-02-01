package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.be.e;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.r.a.a;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.pluginsdk.model.q;
import com.tencent.mm.protocal.protobuf.dmb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.storage.cb;
import com.tencent.mm.vfs.y;
import java.util.Arrays;

public final class w
  implements ad
{
  private VideoTransPara paR = null;
  private VideoTransPara paS = null;
  private String paT;
  Boolean paU = Boolean.FALSE;
  private String srcPath;
  
  public final void PJ(String paramString)
  {
    AppMethodBeat.i(126944);
    z localz = v.bOh().PR(paramString);
    v.bOh();
    this.srcPath = aa.PX(paramString);
    Object localObject = new StringBuilder();
    v.bOh();
    this.paT = (aa.PX(paramString) + ".tmp");
    Log.i("MicroMsg.TransferVideoMsgSendCallback", "srcPath： %s", new Object[] { this.srcPath });
    Log.i("MicroMsg.TransferVideoMsgSendCallback", "dstPath：%s", new Object[] { this.paT });
    this.paU = Boolean.valueOf(e.Qy(this.srcPath));
    if (((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.zwy, 0) == 0) {}
    long l;
    for (boolean bool = true;; bool = false)
    {
      if (WeChatEnvironment.hasDebugger()) {
        bool = false;
      }
      Log.i("MicroMsg.TransferVideoMsgSendCallback", "needConvert hevc:%s", new Object[] { Boolean.valueOf(bool) });
      if ((!bool) || (!y.ZC(this.srcPath)) || (!this.paU.booleanValue())) {
        break label383;
      }
      Log.i("MicroMsg.TransferVideoMsgSendCallback", "before video send, is h265");
      l = Util.currentTicks();
      if (y.ZC(this.srcPath)) {
        break;
      }
      Log.e("MicroMsg.TransferVideoMsgSendCallback", "before video send, is h265 file not exist!");
      AppMethodBeat.o(126944);
      return;
    }
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 249L, 1L, false);
    this.paS = e.Qz(this.srcPath);
    this.paR = e.b(this.paS, this.srcPath);
    if ((this.paS != null) && (this.paR != null))
    {
      if (e.a(this.srcPath, this.paT, this.paR) < 0) {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(354L, 250L, 1L, false);
      }
      y.qn(this.paT, this.srcPath);
      y.deleteFile(this.paT);
      paramString = ab.Qo(paramString);
      if (paramString != null)
      {
        paramString.videoFormat = 1;
        paramString.eQp = 2;
        v.bOh().c(paramString);
      }
      Log.i("MicroMsg.TransferVideoMsgSendCallback", "transfer to h264 finish, used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
    }
    AppMethodBeat.o(126944);
    return;
    label383:
    Log.i("MicroMsg.TransferVideoMsgSendCallback", "video format is h264，do not need to tranfer");
    if ((localz != null) && (!Util.isNullOrNil(localz.bOt())) && (y.ZC(localz.bOt())))
    {
      localObject = localz.pbl;
      if ((localObject == null) || (!((dmb)localObject).aaSg))
      {
        localObject = localz.bOt();
        v.bOh();
        paramString = aa.PX(paramString);
        this.paS = e.Qz((String)localObject);
        this.paR = e.b(this.paS, (String)localObject);
        if ((!y.ZC(paramString)) && (this.paS != null) && (this.paR != null))
        {
          int[] arrayOfInt = new int[2];
          q.c((String)localObject, arrayOfInt);
          l = Util.currentTicks();
          this.paU = Boolean.valueOf(e.Qy((String)localObject));
          Log.i("MicroMsg.TransferVideoMsgSendCallback", "before video send, local remux file path not exist, do remux here, outsize: %s, localDstFilePath: %s, importPath: %s, isH265: %s", new Object[] { Arrays.toString(arrayOfInt), paramString, localObject, this.paU });
          int i;
          if (this.paU.booleanValue())
          {
            i = e.a((String)localObject, paramString, this.paR);
            Log.i("MicroMsg.TransferVideoMsgSendCallback", "transfer to h264 finish, used %sms %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(i) });
          }
          for (;;)
          {
            if (this.paS.duration > 0)
            {
              localz.omT = this.paS.duration;
              v.bOh().c(localz);
            }
            AppMethodBeat.o(126944);
            return;
            i = SightVideoJNI.remuxingVFS((String)localObject, paramString, arrayOfInt[0], arrayOfInt[1], this.paR.videoBitrate, this.paR.oBP, 8, this.paR.oBO, 25.0F, this.paR.fps, null, 0, d.PFi, 0, 51);
            Log.i("MicroMsg.TransferVideoMsgSendCallback", "remux finish: %s, used %sms", new Object[] { Integer.valueOf(i), Long.valueOf(Util.ticksToNow(l)) });
            ((a)com.tencent.mm.kernel.h.ax(a.class)).bzI().aO((String)localObject, paramString, i);
          }
        }
        Log.i("MicroMsg.TransferVideoMsgSendCallback", "before video send, is a local capture video, do nothing");
      }
    }
    AppMethodBeat.o(126944);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelvideo.w
 * JD-Core Version:    0.7.0.1
 */