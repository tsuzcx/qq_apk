package com.tencent.mm.plugin.choosemsgfile.logic.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.choosemsgfile.compat.b.a;
import com.tencent.mm.choosemsgfile.compat.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.message.k.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;

public final class e
  extends c
{
  private String cY;
  private long lul;
  private cc wPy;
  private com.tencent.mm.vending.e.a wPz;
  
  public e(com.tencent.mm.plugin.choosemsgfile.logic.b.a parama, a parama1, com.tencent.mm.vending.e.b paramb)
  {
    super(parama, parama1, paramb);
  }
  
  protected final void cCw()
  {
    AppMethodBeat.i(123239);
    boolean bool = ((com.tencent.mm.choosemsgfile.compat.b)h.ax(com.tencent.mm.choosemsgfile.compat.b.class)).a(this.cY, this.wPy, new b.b()
    {
      public final void v(int paramAnonymousInt, final String paramAnonymousString)
      {
        AppMethodBeat.i(123236);
        Log.i("MicroMsg.MsgFileWorker_File", "InitAttachInfoCallback errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        if (paramAnonymousInt == 0)
        {
          paramAnonymousString = ((com.tencent.mm.choosemsgfile.compat.b)h.ax(com.tencent.mm.choosemsgfile.compat.b.class)).q(e.a(e.this), e.b(e.this));
          ((com.tencent.mm.choosemsgfile.compat.b)h.ax(com.tencent.mm.choosemsgfile.compat.b.class)).a(paramAnonymousString);
          e.a(e.this, ((com.tencent.mm.choosemsgfile.compat.b)h.ax(com.tencent.mm.choosemsgfile.compat.b.class)).a(e.b(e.this), e.a(e.this), new b.a()
          {
            public final void dA(int paramAnonymous2Int1, int paramAnonymous2Int2)
            {
              AppMethodBeat.i(123235);
              e.this.gA(paramAnonymous2Int1, paramAnonymous2Int2);
              AppMethodBeat.o(123235);
            }
            
            public final void u(int paramAnonymous2Int, String paramAnonymous2String)
            {
              AppMethodBeat.i(123234);
              Log.i("MicroMsg.MsgFileWorker_File", "DownloadCallback errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymous2Int), paramAnonymous2String });
              if (paramAnonymous2Int == 0)
              {
                paramAnonymous2String = new MsgFile();
                paramAnonymous2String.fileSize = e.this.wPs.dqt();
                paramAnonymous2String.filePath = paramAnonymousString.field_fileFullPath;
                paramAnonymous2String.fileName = e.this.wPs.getFileName();
                paramAnonymous2String.type = "file";
                paramAnonymous2String.lPJ = e.this.wPs.getFileExt();
                paramAnonymous2String.timeStamp = (e.this.wPs.getTimeStamp() / 1000L);
                e.this.b(paramAnonymous2String);
                AppMethodBeat.o(123234);
                return;
              }
              if (paramAnonymous2Int == 1)
              {
                e.this.dqn();
                AppMethodBeat.o(123234);
                return;
              }
              Log.e("MicroMsg.MsgFileWorker_File", "download %s fail", new Object[] { e.this.wPs });
              e.this.dqo();
              AppMethodBeat.o(123234);
            }
          }));
          AppMethodBeat.o(123236);
          return;
        }
        Log.e("MicroMsg.MsgFileWorker_File", "init %s fail", new Object[] { e.this.wPs });
        e.this.dqo();
        AppMethodBeat.o(123236);
      }
    });
    Log.i("MicroMsg.MsgFileWorker_File", "initOk:%b", new Object[] { Boolean.valueOf(bool) });
    if (!bool)
    {
      Log.i("MicroMsg.MsgFileWorker_File", "initOk fail");
      dqo();
    }
    AppMethodBeat.o(123239);
  }
  
  protected final boolean checkValid()
  {
    AppMethodBeat.i(123237);
    Log.i("MicroMsg.MsgFileWorker_File", "start %s", new Object[] { this });
    if ((this.wPs == null) || (this.wPs.wPy == null))
    {
      Log.e("MicroMsg.MsgFileWorker_File", "mMsgInfo is null, err");
      AppMethodBeat.o(123237);
      return false;
    }
    this.wPy = this.wPs.wPy;
    this.lul = this.wPs.wPy.field_msgId;
    k.b localb = k.b.Hf(this.wPy.field_content);
    if (localb == null)
    {
      Log.e("MicroMsg.MsgFileWorker_File", "parse msgContent error, %s", new Object[] { this.wPy.field_content });
      AppMethodBeat.o(123237);
      return false;
    }
    if ((Util.isNullOrNil(localb.hzM)) && (!Util.isNullOrNil(localb.nRq)))
    {
      Log.e("MicroMsg.MsgFileWorker_File", "msgContent format error, %s", new Object[] { this.wPy.field_content });
      localb.hzM = localb.nRq.hashCode();
    }
    this.cY = localb.hzM;
    if (Util.isNullOrNil(this.cY))
    {
      Log.e("MicroMsg.MsgFileWorker_File", "MediaId is null, err return");
      AppMethodBeat.o(123237);
      return false;
    }
    AppMethodBeat.o(123237);
    return true;
  }
  
  public final void dead()
  {
    AppMethodBeat.i(123240);
    Log.i("MicroMsg.MsgFileWorker_File", "dead");
    if (this.wPz != null) {
      this.wPz.dead();
    }
    AppMethodBeat.o(123240);
  }
  
  protected final boolean dqm()
  {
    AppMethodBeat.i(123238);
    com.tencent.mm.pluginsdk.model.app.c localc = ((com.tencent.mm.choosemsgfile.compat.b)h.ax(com.tencent.mm.choosemsgfile.compat.b.class)).q(this.cY, this.lul);
    if (((com.tencent.mm.choosemsgfile.compat.b)h.ax(com.tencent.mm.choosemsgfile.compat.b.class)).a(this.wPy, localc))
    {
      MsgFile localMsgFile = new MsgFile();
      localMsgFile.fileSize = this.wPs.dqt();
      localMsgFile.filePath = localc.field_fileFullPath;
      localMsgFile.fileName = this.wPs.getFileName();
      localMsgFile.type = "file";
      localMsgFile.lPJ = this.wPs.getFileExt();
      localMsgFile.timeStamp = (this.wPs.getTimeStamp() / 1000L);
      b(localMsgFile);
      AppMethodBeat.o(123238);
      return true;
    }
    AppMethodBeat.o(123238);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.logic.a.e
 * JD-Core Version:    0.7.0.1
 */