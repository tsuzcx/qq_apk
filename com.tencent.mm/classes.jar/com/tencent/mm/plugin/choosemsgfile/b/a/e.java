package com.tencent.mm.plugin.choosemsgfile.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.choosemsgfile.compat.b.a;
import com.tencent.mm.choosemsgfile.compat.b.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;

public final class e
  extends c
{
  private String LS;
  private long fGN;
  private bu oRU;
  private com.tencent.mm.vending.e.a oRV;
  
  public e(com.tencent.mm.plugin.choosemsgfile.b.b.a parama, a parama1, com.tencent.mm.vending.e.b paramb)
  {
    super(parama, parama1, paramb);
  }
  
  protected final boolean bZh()
  {
    AppMethodBeat.i(123238);
    com.tencent.mm.pluginsdk.model.app.c localc = ((com.tencent.mm.choosemsgfile.compat.b)g.ab(com.tencent.mm.choosemsgfile.compat.b.class)).r(this.LS, this.fGN);
    if (((com.tencent.mm.choosemsgfile.compat.b)g.ab(com.tencent.mm.choosemsgfile.compat.b.class)).a(this.oRU, localc))
    {
      MsgFile localMsgFile = new MsgFile();
      localMsgFile.fileSize = this.oRN.bZo();
      localMsgFile.filePath = localc.field_fileFullPath;
      localMsgFile.fileName = this.oRN.getFileName();
      localMsgFile.type = "file";
      localMsgFile.fVf = this.oRN.bZn();
      localMsgFile.timeStamp = (this.oRN.getTimeStamp() / 1000L);
      b(localMsgFile);
      AppMethodBeat.o(123238);
      return true;
    }
    AppMethodBeat.o(123238);
    return false;
  }
  
  protected final void btu()
  {
    AppMethodBeat.i(123239);
    boolean bool = ((com.tencent.mm.choosemsgfile.compat.b)g.ab(com.tencent.mm.choosemsgfile.compat.b.class)).a(this.LS, this.oRU, new b.b()
    {
      public final void s(int paramAnonymousInt, final String paramAnonymousString)
      {
        AppMethodBeat.i(123236);
        ad.i("MicroMsg.MsgFileWorker_File", "InitAttachInfoCallback errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        if (paramAnonymousInt == 0)
        {
          paramAnonymousString = ((com.tencent.mm.choosemsgfile.compat.b)g.ab(com.tencent.mm.choosemsgfile.compat.b.class)).r(e.a(e.this), e.b(e.this));
          ((com.tencent.mm.choosemsgfile.compat.b)g.ab(com.tencent.mm.choosemsgfile.compat.b.class)).a(paramAnonymousString);
          e.a(e.this, ((com.tencent.mm.choosemsgfile.compat.b)g.ab(com.tencent.mm.choosemsgfile.compat.b.class)).a(e.b(e.this), e.a(e.this), new b.a()
          {
            public final void cq(int paramAnonymous2Int1, int paramAnonymous2Int2)
            {
              AppMethodBeat.i(123235);
              e.this.eX(paramAnonymous2Int1, paramAnonymous2Int2);
              AppMethodBeat.o(123235);
            }
            
            public final void r(int paramAnonymous2Int, String paramAnonymous2String)
            {
              AppMethodBeat.i(123234);
              ad.i("MicroMsg.MsgFileWorker_File", "DownloadCallback errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymous2Int), paramAnonymous2String });
              if (paramAnonymous2Int == 0)
              {
                paramAnonymous2String = new MsgFile();
                paramAnonymous2String.fileSize = e.this.oRN.bZo();
                paramAnonymous2String.filePath = paramAnonymousString.field_fileFullPath;
                paramAnonymous2String.fileName = e.this.oRN.getFileName();
                paramAnonymous2String.type = "file";
                paramAnonymous2String.fVf = e.this.oRN.bZn();
                paramAnonymous2String.timeStamp = (e.this.oRN.getTimeStamp() / 1000L);
                e.this.b(paramAnonymous2String);
                AppMethodBeat.o(123234);
                return;
              }
              if (paramAnonymous2Int == 1)
              {
                e.this.bZi();
                AppMethodBeat.o(123234);
                return;
              }
              ad.e("MicroMsg.MsgFileWorker_File", "download %s fail", new Object[] { e.this.oRN });
              e.this.bZj();
              AppMethodBeat.o(123234);
            }
          }));
          AppMethodBeat.o(123236);
          return;
        }
        ad.e("MicroMsg.MsgFileWorker_File", "init %s fail", new Object[] { e.this.oRN });
        e.this.bZj();
        AppMethodBeat.o(123236);
      }
    });
    ad.i("MicroMsg.MsgFileWorker_File", "initOk:%b", new Object[] { Boolean.valueOf(bool) });
    if (!bool)
    {
      ad.i("MicroMsg.MsgFileWorker_File", "initOk fail");
      bZj();
    }
    AppMethodBeat.o(123239);
  }
  
  protected final boolean checkValid()
  {
    AppMethodBeat.i(123237);
    ad.i("MicroMsg.MsgFileWorker_File", "start %s", new Object[] { this });
    if ((this.oRN == null) || (this.oRN.oRU == null))
    {
      ad.e("MicroMsg.MsgFileWorker_File", "mMsgInfo is null, err");
      AppMethodBeat.o(123237);
      return false;
    }
    this.oRU = this.oRN.oRU;
    this.fGN = this.oRN.oRU.field_msgId;
    k.b localb = k.b.yr(this.oRU.field_content);
    if (localb == null)
    {
      ad.e("MicroMsg.MsgFileWorker_File", "parse msgContent error, %s", new Object[] { this.oRU.field_content });
      AppMethodBeat.o(123237);
      return false;
    }
    if ((bt.isNullOrNil(localb.dks)) && (!bt.isNullOrNil(localb.hAd)))
    {
      ad.e("MicroMsg.MsgFileWorker_File", "msgContent format error, %s", new Object[] { this.oRU.field_content });
      localb.dks = localb.hAd.hashCode();
    }
    this.LS = localb.dks;
    if (bt.isNullOrNil(this.LS))
    {
      ad.e("MicroMsg.MsgFileWorker_File", "MediaId is null, err return");
      AppMethodBeat.o(123237);
      return false;
    }
    AppMethodBeat.o(123237);
    return true;
  }
  
  public final void dead()
  {
    AppMethodBeat.i(123240);
    ad.i("MicroMsg.MsgFileWorker_File", "dead");
    if (this.oRV != null) {
      this.oRV.dead();
    }
    AppMethodBeat.o(123240);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.a.e
 * JD-Core Version:    0.7.0.1
 */