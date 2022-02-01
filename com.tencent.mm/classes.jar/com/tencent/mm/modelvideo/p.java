package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bl.e;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.n.a.a;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.c;
import com.tencent.mm.pluginsdk.model.l;
import com.tencent.mm.protocal.protobuf.bxm;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.i;
import java.util.Arrays;

public final class p
  implements w
{
  private VideoTransPara itU = null;
  private VideoTransPara itV = null;
  private String itW;
  Boolean itX = Boolean.FALSE;
  private String srcPath;
  
  public final void GV(String paramString)
  {
    AppMethodBeat.i(126944);
    o.aMJ();
    this.srcPath = t.Hh(paramString);
    Object localObject1 = new StringBuilder();
    o.aMJ();
    this.itW = (t.Hh(paramString) + ".tmp");
    ad.i("MicroMsg.TransferVideoMsgSendCallback", "srcPath： %s", new Object[] { this.srcPath });
    ad.i("MicroMsg.TransferVideoMsgSendCallback", "dstPath：%s", new Object[] { this.itW });
    this.itX = Boolean.valueOf(e.HI(this.srcPath));
    long l;
    if ((i.fv(this.srcPath)) && (this.itX.booleanValue()))
    {
      ad.i("MicroMsg.TransferVideoMsgSendCallback", "before video send, is h265");
      l = com.tencent.mm.sdk.platformtools.bt.HI();
      if (!i.fv(this.srcPath))
      {
        ad.e("MicroMsg.TransferVideoMsgSendCallback", "before video send, is h265 file not exist!");
        AppMethodBeat.o(126944);
        return;
      }
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 249L, 1L, false);
      this.itV = e.HJ(this.srcPath);
      this.itU = e.a(this.itV, this.srcPath);
      if ((this.itV != null) && (this.itU != null))
      {
        if (e.a(this.srcPath, this.itW, this.itU) < 0) {
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(354L, 250L, 1L, false);
        }
        i.mA(this.itW, this.srcPath);
        i.deleteFile(this.itW);
        paramString = u.Hy(paramString);
        if (paramString != null)
        {
          paramString.videoFormat = 1;
          paramString.dDp = 2;
          o.aMJ().c(paramString);
        }
        ad.i("MicroMsg.TransferVideoMsgSendCallback", "transfer to h264 finish, used %sms", new Object[] { Long.valueOf(com.tencent.mm.sdk.platformtools.bt.aO(l)) });
      }
      AppMethodBeat.o(126944);
      return;
    }
    ad.i("MicroMsg.TransferVideoMsgSendCallback", "video format is h264，do not need to tranfer");
    localObject1 = u.Hy(paramString);
    if ((localObject1 != null) && (!com.tencent.mm.sdk.platformtools.bt.isNullOrNil(((s)localObject1).aMU())) && (i.fv(((s)localObject1).aMU())))
    {
      Object localObject2 = ((s)localObject1).iuo;
      if ((localObject2 == null) || (!((bxm)localObject2).GRA))
      {
        localObject2 = ((s)localObject1).aMU();
        o.aMJ();
        paramString = t.Hh(paramString);
        this.itV = e.HJ((String)localObject2);
        this.itU = e.a(this.itV, (String)localObject2);
        if ((!i.fv(paramString)) && (this.itV != null) && (this.itU != null))
        {
          int[] arrayOfInt = new int[2];
          l.d((String)localObject2, arrayOfInt);
          l = com.tencent.mm.sdk.platformtools.bt.HI();
          this.itX = Boolean.valueOf(e.HI((String)localObject2));
          ad.i("MicroMsg.TransferVideoMsgSendCallback", "before video send, local remux file path not exist, do remux here, outsize: %s, localDstFilePath: %s, importPath: %s, isH265: %s", new Object[] { Arrays.toString(arrayOfInt), paramString, localObject2, this.itX });
          int i;
          if (this.itX.booleanValue())
          {
            i = e.a((String)localObject2, paramString, this.itU);
            ad.i("MicroMsg.TransferVideoMsgSendCallback", "transfer to h264 finish, used %sms %s", new Object[] { Long.valueOf(com.tencent.mm.sdk.platformtools.bt.aO(l)), Integer.valueOf(i) });
          }
          for (;;)
          {
            if (this.itV.duration > 0)
            {
              ((s)localObject1).hHQ = this.itV.duration;
              o.aMJ().c((s)localObject1);
            }
            AppMethodBeat.o(126944);
            return;
            i = SightVideoJNI.remuxingVFS((String)localObject2, paramString, arrayOfInt[0], arrayOfInt[1], this.itU.videoBitrate, this.itU.hVf, 8, this.itU.hVe, 25.0F, this.itU.fps, null, 0, c.yRa, 0, 51);
            ad.i("MicroMsg.TransferVideoMsgSendCallback", "remux finish: %s, used %sms", new Object[] { Integer.valueOf(i), Long.valueOf(com.tencent.mm.sdk.platformtools.bt.aO(l)) });
            ((a)com.tencent.mm.kernel.g.ab(a.class)).azx().al((String)localObject2, paramString, i);
          }
        }
        ad.i("MicroMsg.TransferVideoMsgSendCallback", "before video send, is a local capture video, do nothing");
      }
    }
    AppMethodBeat.o(126944);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvideo.p
 * JD-Core Version:    0.7.0.1
 */