package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bl.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.n.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.c;
import com.tencent.mm.pluginsdk.model.l;
import com.tencent.mm.protocal.protobuf.boj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bk;
import com.tencent.mm.vfs.i;
import java.util.Arrays;

public final class p
  implements w
{
  Boolean hAa = Boolean.FALSE;
  private VideoTransPara hzX = null;
  private VideoTransPara hzY = null;
  private String hzZ;
  private String srcPath;
  
  public final void zJ(String paramString)
  {
    AppMethodBeat.i(126944);
    o.aCI();
    this.srcPath = t.zQ(paramString);
    Object localObject1 = new StringBuilder();
    o.aCI();
    this.hzZ = (t.zQ(paramString) + ".tmp");
    ad.i("MicroMsg.TransferVideoMsgSendCallback", "srcPath： %s", new Object[] { this.srcPath });
    ad.i("MicroMsg.TransferVideoMsgSendCallback", "dstPath：%s", new Object[] { this.hzZ });
    this.hAa = Boolean.valueOf(e.Ao(this.srcPath));
    long l;
    if ((i.eK(this.srcPath)) && (this.hAa.booleanValue()))
    {
      ad.i("MicroMsg.TransferVideoMsgSendCallback", "before video send, is h265");
      l = bt.GC();
      if (!i.eK(this.srcPath))
      {
        ad.e("MicroMsg.TransferVideoMsgSendCallback", "before video send, is h265 file not exist!");
        AppMethodBeat.o(126944);
        return;
      }
      h.vKh.idkeyStat(354L, 249L, 1L, false);
      this.hzY = e.Ap(this.srcPath);
      this.hzX = e.a(this.hzY, this.srcPath);
      if ((this.hzY != null) && (this.hzX != null))
      {
        if (e.a(this.srcPath, this.hzZ, this.hzX) < 0) {
          h.vKh.idkeyStat(354L, 250L, 1L, false);
        }
        i.lD(this.hzZ, this.srcPath);
        i.deleteFile(this.hzZ);
        paramString = u.Ae(paramString);
        if (paramString != null)
        {
          paramString.videoFormat = 1;
          paramString.dtM = 2;
          o.aCI().c(paramString);
        }
        ad.i("MicroMsg.TransferVideoMsgSendCallback", "transfer to h264 finish, used %sms", new Object[] { Long.valueOf(bt.aS(l)) });
      }
      AppMethodBeat.o(126944);
      return;
    }
    ad.i("MicroMsg.TransferVideoMsgSendCallback", "video format is h264，do not need to tranfer");
    localObject1 = u.Ae(paramString);
    if ((localObject1 != null) && (!bt.isNullOrNil(((s)localObject1).aCS())) && (i.eK(((s)localObject1).aCS())))
    {
      Object localObject2 = ((s)localObject1).hAr;
      if ((localObject2 == null) || (!((boj)localObject2).DLK))
      {
        localObject2 = ((s)localObject1).aCS();
        o.aCI();
        paramString = t.zQ(paramString);
        this.hzY = e.Ap((String)localObject2);
        this.hzX = e.a(this.hzY, (String)localObject2);
        if ((!i.eK(paramString)) && (this.hzY != null) && (this.hzX != null))
        {
          int[] arrayOfInt = new int[2];
          l.d((String)localObject2, arrayOfInt);
          l = bt.GC();
          this.hAa = Boolean.valueOf(e.Ao((String)localObject2));
          ad.i("MicroMsg.TransferVideoMsgSendCallback", "before video send, local remux file path not exist, do remux here, outsize: %s, localDstFilePath: %s, importPath: %s, isH265: %s", new Object[] { Arrays.toString(arrayOfInt), paramString, localObject2, this.hAa });
          int i;
          if (this.hAa.booleanValue())
          {
            i = e.a((String)localObject2, paramString, this.hzX);
            ad.i("MicroMsg.TransferVideoMsgSendCallback", "transfer to h264 finish, used %sms %s", new Object[] { Long.valueOf(bt.aS(l)), Integer.valueOf(i) });
          }
          for (;;)
          {
            if (this.hzY.duration > 0)
            {
              ((s)localObject1).gOY = this.hzY.duration;
              o.aCI().c((s)localObject1);
            }
            AppMethodBeat.o(126944);
            return;
            i = SightVideoJNI.remuxingVFS((String)localObject2, paramString, arrayOfInt[0], arrayOfInt[1], this.hzX.videoBitrate, this.hzX.hbY, 8, this.hzX.hbX, 25.0F, this.hzX.fps, null, 0, c.wqZ, 0, 51);
            ad.i("MicroMsg.TransferVideoMsgSendCallback", "remux finish: %s, used %sms", new Object[] { Integer.valueOf(i), Long.valueOf(bt.aS(l)) });
            ((a)g.ab(a.class)).apT().ag((String)localObject2, paramString, i);
          }
        }
        ad.i("MicroMsg.TransferVideoMsgSendCallback", "before video send, is a local capture video, do nothing");
      }
    }
    AppMethodBeat.o(126944);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelvideo.p
 * JD-Core Version:    0.7.0.1
 */