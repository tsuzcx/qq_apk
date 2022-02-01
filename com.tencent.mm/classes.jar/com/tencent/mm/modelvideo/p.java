package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bk.e;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.n.a.a;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.c;
import com.tencent.mm.pluginsdk.model.l;
import com.tencent.mm.protocal.protobuf.byg;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Arrays;

public final class p
  implements w
{
  private VideoTransPara iwO = null;
  private VideoTransPara iwP = null;
  private String iwQ;
  Boolean iwR = Boolean.FALSE;
  private String srcPath;
  
  public final void Hx(String paramString)
  {
    AppMethodBeat.i(126944);
    o.aNh();
    this.srcPath = t.HJ(paramString);
    Object localObject1 = new StringBuilder();
    o.aNh();
    this.iwQ = (t.HJ(paramString) + ".tmp");
    ae.i("MicroMsg.TransferVideoMsgSendCallback", "srcPath： %s", new Object[] { this.srcPath });
    ae.i("MicroMsg.TransferVideoMsgSendCallback", "dstPath：%s", new Object[] { this.iwQ });
    this.iwR = Boolean.valueOf(e.Ik(this.srcPath));
    long l;
    if ((com.tencent.mm.vfs.o.fB(this.srcPath)) && (this.iwR.booleanValue()))
    {
      ae.i("MicroMsg.TransferVideoMsgSendCallback", "before video send, is h265");
      l = com.tencent.mm.sdk.platformtools.bu.HQ();
      if (!com.tencent.mm.vfs.o.fB(this.srcPath))
      {
        ae.e("MicroMsg.TransferVideoMsgSendCallback", "before video send, is h265 file not exist!");
        AppMethodBeat.o(126944);
        return;
      }
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 249L, 1L, false);
      this.iwP = e.Il(this.srcPath);
      this.iwO = e.a(this.iwP, this.srcPath);
      if ((this.iwP != null) && (this.iwO != null))
      {
        if (e.a(this.srcPath, this.iwQ, this.iwO) < 0) {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(354L, 250L, 1L, false);
        }
        com.tencent.mm.vfs.o.mG(this.iwQ, this.srcPath);
        com.tencent.mm.vfs.o.deleteFile(this.iwQ);
        paramString = u.Ia(paramString);
        if (paramString != null)
        {
          paramString.videoFormat = 1;
          paramString.dEu = 2;
          o.aNh().c(paramString);
        }
        ae.i("MicroMsg.TransferVideoMsgSendCallback", "transfer to h264 finish, used %sms", new Object[] { Long.valueOf(com.tencent.mm.sdk.platformtools.bu.aO(l)) });
      }
      AppMethodBeat.o(126944);
      return;
    }
    ae.i("MicroMsg.TransferVideoMsgSendCallback", "video format is h264，do not need to tranfer");
    localObject1 = u.Ia(paramString);
    if ((localObject1 != null) && (!com.tencent.mm.sdk.platformtools.bu.isNullOrNil(((s)localObject1).aNs())) && (com.tencent.mm.vfs.o.fB(((s)localObject1).aNs())))
    {
      Object localObject2 = ((s)localObject1).ixi;
      if ((localObject2 == null) || (!((byg)localObject2).Hlb))
      {
        localObject2 = ((s)localObject1).aNs();
        o.aNh();
        paramString = t.HJ(paramString);
        this.iwP = e.Il((String)localObject2);
        this.iwO = e.a(this.iwP, (String)localObject2);
        if ((!com.tencent.mm.vfs.o.fB(paramString)) && (this.iwP != null) && (this.iwO != null))
        {
          int[] arrayOfInt = new int[2];
          l.d((String)localObject2, arrayOfInt);
          l = com.tencent.mm.sdk.platformtools.bu.HQ();
          this.iwR = Boolean.valueOf(e.Ik((String)localObject2));
          ae.i("MicroMsg.TransferVideoMsgSendCallback", "before video send, local remux file path not exist, do remux here, outsize: %s, localDstFilePath: %s, importPath: %s, isH265: %s", new Object[] { Arrays.toString(arrayOfInt), paramString, localObject2, this.iwR });
          int i;
          if (this.iwR.booleanValue())
          {
            i = e.a((String)localObject2, paramString, this.iwO);
            ae.i("MicroMsg.TransferVideoMsgSendCallback", "transfer to h264 finish, used %sms %s", new Object[] { Long.valueOf(com.tencent.mm.sdk.platformtools.bu.aO(l)), Integer.valueOf(i) });
          }
          for (;;)
          {
            if (this.iwP.duration > 0)
            {
              ((s)localObject1).hKI = this.iwP.duration;
              o.aNh().c((s)localObject1);
            }
            AppMethodBeat.o(126944);
            return;
            i = SightVideoJNI.remuxingVFS((String)localObject2, paramString, arrayOfInt[0], arrayOfInt[1], this.iwO.videoBitrate, this.iwO.hXX, 8, this.iwO.hXW, 25.0F, this.iwO.fps, null, 0, c.zhk, 0, 51);
            ae.i("MicroMsg.TransferVideoMsgSendCallback", "remux finish: %s, used %sms", new Object[] { Integer.valueOf(i), Long.valueOf(com.tencent.mm.sdk.platformtools.bu.aO(l)) });
            ((a)com.tencent.mm.kernel.g.ab(a.class)).azN().an((String)localObject2, paramString, i);
          }
        }
        ae.i("MicroMsg.TransferVideoMsgSendCallback", "before video send, is a local capture video, do nothing");
      }
    }
    AppMethodBeat.o(126944);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvideo.p
 * JD-Core Version:    0.7.0.1
 */