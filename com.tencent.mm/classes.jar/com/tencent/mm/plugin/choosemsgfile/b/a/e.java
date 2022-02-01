package com.tencent.mm.plugin.choosemsgfile.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.choosemsgfile.compat.b.a;
import com.tencent.mm.choosemsgfile.compat.b.b;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;

public final class e
  extends c
{
  private String Mc;
  private long gof;
  private ca qnv;
  private com.tencent.mm.vending.e.a qnw;
  
  public e(com.tencent.mm.plugin.choosemsgfile.b.b.a parama, a parama1, com.tencent.mm.vending.e.b paramb)
  {
    super(parama, parama1, paramb);
  }
  
  protected final void bPM()
  {
    AppMethodBeat.i(123239);
    boolean bool = ((com.tencent.mm.choosemsgfile.compat.b)g.af(com.tencent.mm.choosemsgfile.compat.b.class)).a(this.Mc, this.qnv, new b.b()
    {
      public final void u(int paramAnonymousInt, final String paramAnonymousString)
      {
        AppMethodBeat.i(123236);
        Log.i("MicroMsg.MsgFileWorker_File", "InitAttachInfoCallback errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        if (paramAnonymousInt == 0)
        {
          paramAnonymousString = ((com.tencent.mm.choosemsgfile.compat.b)g.af(com.tencent.mm.choosemsgfile.compat.b.class)).s(e.a(e.this), e.b(e.this));
          ((com.tencent.mm.choosemsgfile.compat.b)g.af(com.tencent.mm.choosemsgfile.compat.b.class)).a(paramAnonymousString);
          e.a(e.this, ((com.tencent.mm.choosemsgfile.compat.b)g.af(com.tencent.mm.choosemsgfile.compat.b.class)).a(e.b(e.this), e.a(e.this), new b.a()
          {
            public final void cs(int paramAnonymous2Int1, int paramAnonymous2Int2)
            {
              AppMethodBeat.i(123235);
              e.this.fl(paramAnonymous2Int1, paramAnonymous2Int2);
              AppMethodBeat.o(123235);
            }
            
            public final void t(int paramAnonymous2Int, String paramAnonymous2String)
            {
              AppMethodBeat.i(123234);
              Log.i("MicroMsg.MsgFileWorker_File", "DownloadCallback errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymous2Int), paramAnonymous2String });
              if (paramAnonymous2Int == 0)
              {
                paramAnonymous2String = new MsgFile();
                paramAnonymous2String.fileSize = e.this.qno.cyt();
                paramAnonymous2String.filePath = paramAnonymousString.field_fileFullPath;
                paramAnonymous2String.fileName = e.this.qno.getFileName();
                paramAnonymous2String.type = "file";
                paramAnonymous2String.gCr = e.this.qno.getFileExt();
                paramAnonymous2String.timeStamp = (e.this.qno.getTimeStamp() / 1000L);
                e.this.b(paramAnonymous2String);
                AppMethodBeat.o(123234);
                return;
              }
              if (paramAnonymous2Int == 1)
              {
                e.this.cyo();
                AppMethodBeat.o(123234);
                return;
              }
              Log.e("MicroMsg.MsgFileWorker_File", "download %s fail", new Object[] { e.this.qno });
              e.this.cyp();
              AppMethodBeat.o(123234);
            }
          }));
          AppMethodBeat.o(123236);
          return;
        }
        Log.e("MicroMsg.MsgFileWorker_File", "init %s fail", new Object[] { e.this.qno });
        e.this.cyp();
        AppMethodBeat.o(123236);
      }
    });
    Log.i("MicroMsg.MsgFileWorker_File", "initOk:%b", new Object[] { Boolean.valueOf(bool) });
    if (!bool)
    {
      Log.i("MicroMsg.MsgFileWorker_File", "initOk fail");
      cyp();
    }
    AppMethodBeat.o(123239);
  }
  
  protected final boolean checkValid()
  {
    AppMethodBeat.i(123237);
    Log.i("MicroMsg.MsgFileWorker_File", "start %s", new Object[] { this });
    if ((this.qno == null) || (this.qno.qnv == null))
    {
      Log.e("MicroMsg.MsgFileWorker_File", "mMsgInfo is null, err");
      AppMethodBeat.o(123237);
      return false;
    }
    this.qnv = this.qno.qnv;
    this.gof = this.qno.qnv.field_msgId;
    k.b localb = k.b.HD(this.qnv.field_content);
    if (localb == null)
    {
      Log.e("MicroMsg.MsgFileWorker_File", "parse msgContent error, %s", new Object[] { this.qnv.field_content });
      AppMethodBeat.o(123237);
      return false;
    }
    if ((Util.isNullOrNil(localb.dCK)) && (!Util.isNullOrNil(localb.iwW)))
    {
      Log.e("MicroMsg.MsgFileWorker_File", "msgContent format error, %s", new Object[] { this.qnv.field_content });
      localb.dCK = localb.iwW.hashCode();
    }
    this.Mc = localb.dCK;
    if (Util.isNullOrNil(this.Mc))
    {
      Log.e("MicroMsg.MsgFileWorker_File", "MediaId is null, err return");
      AppMethodBeat.o(123237);
      return false;
    }
    AppMethodBeat.o(123237);
    return true;
  }
  
  protected final boolean cyn()
  {
    AppMethodBeat.i(123238);
    com.tencent.mm.pluginsdk.model.app.c localc = ((com.tencent.mm.choosemsgfile.compat.b)g.af(com.tencent.mm.choosemsgfile.compat.b.class)).s(this.Mc, this.gof);
    if (((com.tencent.mm.choosemsgfile.compat.b)g.af(com.tencent.mm.choosemsgfile.compat.b.class)).a(this.qnv, localc))
    {
      MsgFile localMsgFile = new MsgFile();
      localMsgFile.fileSize = this.qno.cyt();
      localMsgFile.filePath = localc.field_fileFullPath;
      localMsgFile.fileName = this.qno.getFileName();
      localMsgFile.type = "file";
      localMsgFile.gCr = this.qno.getFileExt();
      localMsgFile.timeStamp = (this.qno.getTimeStamp() / 1000L);
      b(localMsgFile);
      AppMethodBeat.o(123238);
      return true;
    }
    AppMethodBeat.o(123238);
    return false;
  }
  
  public final void dead()
  {
    AppMethodBeat.i(123240);
    Log.i("MicroMsg.MsgFileWorker_File", "dead");
    if (this.qnw != null) {
      this.qnw.dead();
    }
    AppMethodBeat.o(123240);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.a.e
 * JD-Core Version:    0.7.0.1
 */