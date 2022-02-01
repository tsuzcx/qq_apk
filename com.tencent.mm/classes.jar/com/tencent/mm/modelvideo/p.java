package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bk.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.m.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.c;
import com.tencent.mm.pluginsdk.model.m;
import com.tencent.mm.protocal.protobuf.cly;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bz;
import java.util.Arrays;

public final class p
  implements w
{
  private VideoTransPara jsd = null;
  private VideoTransPara jse = null;
  private String jsf;
  Boolean jsg = Boolean.FALSE;
  private String srcPath;
  
  public final void Qk(String paramString)
  {
    AppMethodBeat.i(126944);
    o.bhj();
    this.srcPath = t.Qw(paramString);
    Object localObject1 = new StringBuilder();
    o.bhj();
    this.jsf = (t.Qw(paramString) + ".tmp");
    Log.i("MicroMsg.TransferVideoMsgSendCallback", "srcPath： %s", new Object[] { this.srcPath });
    Log.i("MicroMsg.TransferVideoMsgSendCallback", "dstPath：%s", new Object[] { this.jsf });
    this.jsg = Boolean.valueOf(e.QW(this.srcPath));
    long l;
    if ((com.tencent.mm.vfs.s.YS(this.srcPath)) && (this.jsg.booleanValue()))
    {
      Log.i("MicroMsg.TransferVideoMsgSendCallback", "before video send, is h265");
      l = Util.currentTicks();
      if (!com.tencent.mm.vfs.s.YS(this.srcPath))
      {
        Log.e("MicroMsg.TransferVideoMsgSendCallback", "before video send, is h265 file not exist!");
        AppMethodBeat.o(126944);
        return;
      }
      h.CyF.idkeyStat(354L, 249L, 1L, false);
      this.jse = e.QX(this.srcPath);
      this.jsd = e.a(this.jse, this.srcPath);
      if ((this.jse != null) && (this.jsd != null))
      {
        if (e.a(this.srcPath, this.jsf, this.jsd) < 0) {
          h.CyF.idkeyStat(354L, 250L, 1L, false);
        }
        com.tencent.mm.vfs.s.nx(this.jsf, this.srcPath);
        com.tencent.mm.vfs.s.deleteFile(this.jsf);
        paramString = u.QN(paramString);
        if (paramString != null)
        {
          paramString.videoFormat = 1;
          paramString.cSx = 2;
          o.bhj().c(paramString);
        }
        Log.i("MicroMsg.TransferVideoMsgSendCallback", "transfer to h264 finish, used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
      }
      AppMethodBeat.o(126944);
      return;
    }
    Log.i("MicroMsg.TransferVideoMsgSendCallback", "video format is h264，do not need to tranfer");
    localObject1 = u.QN(paramString);
    if ((localObject1 != null) && (!Util.isNullOrNil(((s)localObject1).bhu())) && (com.tencent.mm.vfs.s.YS(((s)localObject1).bhu())))
    {
      Object localObject2 = ((s)localObject1).jsx;
      if ((localObject2 == null) || (!((cly)localObject2).Mrn))
      {
        localObject2 = ((s)localObject1).bhu();
        o.bhj();
        paramString = t.Qw(paramString);
        this.jse = e.QX((String)localObject2);
        this.jsd = e.a(this.jse, (String)localObject2);
        if ((!com.tencent.mm.vfs.s.YS(paramString)) && (this.jse != null) && (this.jsd != null))
        {
          int[] arrayOfInt = new int[2];
          m.d((String)localObject2, arrayOfInt);
          l = Util.currentTicks();
          this.jsg = Boolean.valueOf(e.QW((String)localObject2));
          Log.i("MicroMsg.TransferVideoMsgSendCallback", "before video send, local remux file path not exist, do remux here, outsize: %s, localDstFilePath: %s, importPath: %s, isH265: %s", new Object[] { Arrays.toString(arrayOfInt), paramString, localObject2, this.jsg });
          int i;
          if (this.jsg.booleanValue())
          {
            i = e.a((String)localObject2, paramString, this.jsd);
            Log.i("MicroMsg.TransferVideoMsgSendCallback", "transfer to h264 finish, used %sms %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(i) });
          }
          for (;;)
          {
            if (this.jse.duration > 0)
            {
              ((s)localObject1).iFw = this.jse.duration;
              o.bhj().c((s)localObject1);
            }
            AppMethodBeat.o(126944);
            return;
            i = SightVideoJNI.remuxingVFS((String)localObject2, paramString, arrayOfInt[0], arrayOfInt[1], this.jsd.videoBitrate, this.jsd.iSV, 8, this.jsd.iSU, 25.0F, this.jsd.fps, null, 0, c.Dmb, 0, 51);
            Log.i("MicroMsg.TransferVideoMsgSendCallback", "remux finish: %s, used %sms", new Object[] { Integer.valueOf(i), Long.valueOf(Util.ticksToNow(l)) });
            ((a)g.af(a.class)).aSV().ar((String)localObject2, paramString, i);
          }
        }
        Log.i("MicroMsg.TransferVideoMsgSendCallback", "before video send, is a local capture video, do nothing");
      }
    }
    AppMethodBeat.o(126944);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelvideo.p
 * JD-Core Version:    0.7.0.1
 */