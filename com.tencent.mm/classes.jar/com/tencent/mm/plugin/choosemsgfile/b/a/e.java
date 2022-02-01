package com.tencent.mm.plugin.choosemsgfile.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.choosemsgfile.compat.b.a;
import com.tencent.mm.choosemsgfile.compat.b.b;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;

public final class e
  extends c
{
  private String Kc;
  private long foF;
  private com.tencent.mm.vending.e.a ooA;
  private bo ooz;
  
  public e(com.tencent.mm.plugin.choosemsgfile.b.b.a parama, a parama1, com.tencent.mm.vending.e.b paramb)
  {
    super(parama, parama1, paramb);
  }
  
  protected final boolean bUC()
  {
    AppMethodBeat.i(123238);
    com.tencent.mm.pluginsdk.model.app.c localc = ((com.tencent.mm.choosemsgfile.compat.b)g.ab(com.tencent.mm.choosemsgfile.compat.b.class)).q(this.Kc, this.foF);
    if (((com.tencent.mm.choosemsgfile.compat.b)g.ab(com.tencent.mm.choosemsgfile.compat.b.class)).a(this.ooz, localc))
    {
      MsgFile localMsgFile = new MsgFile();
      localMsgFile.fileSize = this.oos.bUJ();
      localMsgFile.filePath = localc.field_fileFullPath;
      localMsgFile.fileName = this.oos.getFileName();
      localMsgFile.type = "file";
      localMsgFile.fBR = this.oos.bUI();
      localMsgFile.timeStamp = (this.oos.getTimeStamp() / 1000L);
      b(localMsgFile);
      AppMethodBeat.o(123238);
      return true;
    }
    AppMethodBeat.o(123238);
    return false;
  }
  
  protected final void bpv()
  {
    AppMethodBeat.i(123239);
    boolean bool = ((com.tencent.mm.choosemsgfile.compat.b)g.ab(com.tencent.mm.choosemsgfile.compat.b.class)).a(this.Kc, this.ooz, new b.b()
    {
      public final void s(int paramAnonymousInt, final String paramAnonymousString)
      {
        AppMethodBeat.i(123236);
        ac.i("MicroMsg.MsgFileWorker_File", "InitAttachInfoCallback errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        if (paramAnonymousInt == 0)
        {
          paramAnonymousString = ((com.tencent.mm.choosemsgfile.compat.b)g.ab(com.tencent.mm.choosemsgfile.compat.b.class)).q(e.a(e.this), e.b(e.this));
          ((com.tencent.mm.choosemsgfile.compat.b)g.ab(com.tencent.mm.choosemsgfile.compat.b.class)).a(paramAnonymousString);
          e.a(e.this, ((com.tencent.mm.choosemsgfile.compat.b)g.ab(com.tencent.mm.choosemsgfile.compat.b.class)).a(e.b(e.this), e.a(e.this), new b.a()
          {
            public final void co(int paramAnonymous2Int1, int paramAnonymous2Int2)
            {
              AppMethodBeat.i(123235);
              e.this.eT(paramAnonymous2Int1, paramAnonymous2Int2);
              AppMethodBeat.o(123235);
            }
            
            public final void r(int paramAnonymous2Int, String paramAnonymous2String)
            {
              AppMethodBeat.i(123234);
              ac.i("MicroMsg.MsgFileWorker_File", "DownloadCallback errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymous2Int), paramAnonymous2String });
              if (paramAnonymous2Int == 0)
              {
                paramAnonymous2String = new MsgFile();
                paramAnonymous2String.fileSize = e.this.oos.bUJ();
                paramAnonymous2String.filePath = paramAnonymousString.field_fileFullPath;
                paramAnonymous2String.fileName = e.this.oos.getFileName();
                paramAnonymous2String.type = "file";
                paramAnonymous2String.fBR = e.this.oos.bUI();
                paramAnonymous2String.timeStamp = (e.this.oos.getTimeStamp() / 1000L);
                e.this.b(paramAnonymous2String);
                AppMethodBeat.o(123234);
                return;
              }
              if (paramAnonymous2Int == 1)
              {
                e.this.bUD();
                AppMethodBeat.o(123234);
                return;
              }
              ac.e("MicroMsg.MsgFileWorker_File", "download %s fail", new Object[] { e.this.oos });
              e.this.bUE();
              AppMethodBeat.o(123234);
            }
          }));
          AppMethodBeat.o(123236);
          return;
        }
        ac.e("MicroMsg.MsgFileWorker_File", "init %s fail", new Object[] { e.this.oos });
        e.this.bUE();
        AppMethodBeat.o(123236);
      }
    });
    ac.i("MicroMsg.MsgFileWorker_File", "initOk:%b", new Object[] { Boolean.valueOf(bool) });
    if (!bool)
    {
      ac.i("MicroMsg.MsgFileWorker_File", "initOk fail");
      bUE();
    }
    AppMethodBeat.o(123239);
  }
  
  protected final boolean checkValid()
  {
    AppMethodBeat.i(123237);
    ac.i("MicroMsg.MsgFileWorker_File", "start %s", new Object[] { this });
    if ((this.oos == null) || (this.oos.ooz == null))
    {
      ac.e("MicroMsg.MsgFileWorker_File", "mMsgInfo is null, err");
      AppMethodBeat.o(123237);
      return false;
    }
    this.ooz = this.oos.ooz;
    this.foF = this.oos.ooz.field_msgId;
    k.b localb = k.b.vA(this.ooz.field_content);
    if (localb == null)
    {
      ac.e("MicroMsg.MsgFileWorker_File", "parse msgContent error, %s", new Object[] { this.ooz.field_content });
      AppMethodBeat.o(123237);
      return false;
    }
    if ((bs.isNullOrNil(localb.cZa)) && (!bs.isNullOrNil(localb.hhU)))
    {
      ac.e("MicroMsg.MsgFileWorker_File", "msgContent format error, %s", new Object[] { this.ooz.field_content });
      localb.cZa = localb.hhU.hashCode();
    }
    this.Kc = localb.cZa;
    if (bs.isNullOrNil(this.Kc))
    {
      ac.e("MicroMsg.MsgFileWorker_File", "MediaId is null, err return");
      AppMethodBeat.o(123237);
      return false;
    }
    AppMethodBeat.o(123237);
    return true;
  }
  
  public final void dead()
  {
    AppMethodBeat.i(123240);
    ac.i("MicroMsg.MsgFileWorker_File", "dead");
    if (this.ooA != null) {
      this.ooA.dead();
    }
    AppMethodBeat.o(123240);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.a.e
 * JD-Core Version:    0.7.0.1
 */