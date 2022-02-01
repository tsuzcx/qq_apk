package com.tencent.mm.plugin.choosemsgfile.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.choosemsgfile.compat.b.a;
import com.tencent.mm.choosemsgfile.compat.b.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;

public final class e
  extends c
{
  private String LS;
  private long fIR;
  private bv oYw;
  private com.tencent.mm.vending.e.a oYx;
  
  public e(com.tencent.mm.plugin.choosemsgfile.b.b.a parama, a parama1, com.tencent.mm.vending.e.b paramb)
  {
    super(parama, parama1, paramb);
  }
  
  protected final void buf()
  {
    AppMethodBeat.i(123239);
    boolean bool = ((com.tencent.mm.choosemsgfile.compat.b)g.ab(com.tencent.mm.choosemsgfile.compat.b.class)).a(this.LS, this.oYw, new b.b()
    {
      public final void s(int paramAnonymousInt, final String paramAnonymousString)
      {
        AppMethodBeat.i(123236);
        ae.i("MicroMsg.MsgFileWorker_File", "InitAttachInfoCallback errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        if (paramAnonymousInt == 0)
        {
          paramAnonymousString = ((com.tencent.mm.choosemsgfile.compat.b)g.ab(com.tencent.mm.choosemsgfile.compat.b.class)).r(e.a(e.this), e.b(e.this));
          ((com.tencent.mm.choosemsgfile.compat.b)g.ab(com.tencent.mm.choosemsgfile.compat.b.class)).a(paramAnonymousString);
          e.a(e.this, ((com.tencent.mm.choosemsgfile.compat.b)g.ab(com.tencent.mm.choosemsgfile.compat.b.class)).a(e.b(e.this), e.a(e.this), new b.a()
          {
            public final void cq(int paramAnonymous2Int1, int paramAnonymous2Int2)
            {
              AppMethodBeat.i(123235);
              e.this.eY(paramAnonymous2Int1, paramAnonymous2Int2);
              AppMethodBeat.o(123235);
            }
            
            public final void r(int paramAnonymous2Int, String paramAnonymous2String)
            {
              AppMethodBeat.i(123234);
              ae.i("MicroMsg.MsgFileWorker_File", "DownloadCallback errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymous2Int), paramAnonymous2String });
              if (paramAnonymous2Int == 0)
              {
                paramAnonymous2String = new MsgFile();
                paramAnonymous2String.fileSize = e.this.oYp.caD();
                paramAnonymous2String.filePath = paramAnonymousString.field_fileFullPath;
                paramAnonymous2String.fileName = e.this.oYp.getFileName();
                paramAnonymous2String.type = "file";
                paramAnonymous2String.fXl = e.this.oYp.caC();
                paramAnonymous2String.timeStamp = (e.this.oYp.getTimeStamp() / 1000L);
                e.this.b(paramAnonymous2String);
                AppMethodBeat.o(123234);
                return;
              }
              if (paramAnonymous2Int == 1)
              {
                e.this.cax();
                AppMethodBeat.o(123234);
                return;
              }
              ae.e("MicroMsg.MsgFileWorker_File", "download %s fail", new Object[] { e.this.oYp });
              e.this.cay();
              AppMethodBeat.o(123234);
            }
          }));
          AppMethodBeat.o(123236);
          return;
        }
        ae.e("MicroMsg.MsgFileWorker_File", "init %s fail", new Object[] { e.this.oYp });
        e.this.cay();
        AppMethodBeat.o(123236);
      }
    });
    ae.i("MicroMsg.MsgFileWorker_File", "initOk:%b", new Object[] { Boolean.valueOf(bool) });
    if (!bool)
    {
      ae.i("MicroMsg.MsgFileWorker_File", "initOk fail");
      cay();
    }
    AppMethodBeat.o(123239);
  }
  
  protected final boolean caw()
  {
    AppMethodBeat.i(123238);
    com.tencent.mm.pluginsdk.model.app.c localc = ((com.tencent.mm.choosemsgfile.compat.b)g.ab(com.tencent.mm.choosemsgfile.compat.b.class)).r(this.LS, this.fIR);
    if (((com.tencent.mm.choosemsgfile.compat.b)g.ab(com.tencent.mm.choosemsgfile.compat.b.class)).a(this.oYw, localc))
    {
      MsgFile localMsgFile = new MsgFile();
      localMsgFile.fileSize = this.oYp.caD();
      localMsgFile.filePath = localc.field_fileFullPath;
      localMsgFile.fileName = this.oYp.getFileName();
      localMsgFile.type = "file";
      localMsgFile.fXl = this.oYp.caC();
      localMsgFile.timeStamp = (this.oYp.getTimeStamp() / 1000L);
      b(localMsgFile);
      AppMethodBeat.o(123238);
      return true;
    }
    AppMethodBeat.o(123238);
    return false;
  }
  
  protected final boolean checkValid()
  {
    AppMethodBeat.i(123237);
    ae.i("MicroMsg.MsgFileWorker_File", "start %s", new Object[] { this });
    if ((this.oYp == null) || (this.oYp.oYw == null))
    {
      ae.e("MicroMsg.MsgFileWorker_File", "mMsgInfo is null, err");
      AppMethodBeat.o(123237);
      return false;
    }
    this.oYw = this.oYp.oYw;
    this.fIR = this.oYp.oYw.field_msgId;
    k.b localb = k.b.zb(this.oYw.field_content);
    if (localb == null)
    {
      ae.e("MicroMsg.MsgFileWorker_File", "parse msgContent error, %s", new Object[] { this.oYw.field_content });
      AppMethodBeat.o(123237);
      return false;
    }
    if ((bu.isNullOrNil(localb.dlu)) && (!bu.isNullOrNil(localb.hCR)))
    {
      ae.e("MicroMsg.MsgFileWorker_File", "msgContent format error, %s", new Object[] { this.oYw.field_content });
      localb.dlu = localb.hCR.hashCode();
    }
    this.LS = localb.dlu;
    if (bu.isNullOrNil(this.LS))
    {
      ae.e("MicroMsg.MsgFileWorker_File", "MediaId is null, err return");
      AppMethodBeat.o(123237);
      return false;
    }
    AppMethodBeat.o(123237);
    return true;
  }
  
  public final void dead()
  {
    AppMethodBeat.i(123240);
    ae.i("MicroMsg.MsgFileWorker_File", "dead");
    if (this.oYx != null) {
      this.oYx.dead();
    }
    AppMethodBeat.o(123240);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.a.e
 * JD-Core Version:    0.7.0.1
 */