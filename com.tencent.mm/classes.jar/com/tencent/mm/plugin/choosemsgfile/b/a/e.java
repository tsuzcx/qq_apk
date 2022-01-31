package com.tencent.mm.plugin.choosemsgfile.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;

public final class e
  extends c
{
  private String Cu;
  private long eaY;
  private com.tencent.mm.vending.e.a kEA;
  private bi kEz;
  
  public e(com.tencent.mm.plugin.choosemsgfile.b.b.a parama, a parama1, com.tencent.mm.vending.e.b paramb)
  {
    super(parama, parama1, paramb);
  }
  
  protected final boolean bgf()
  {
    AppMethodBeat.i(54266);
    com.tencent.mm.pluginsdk.model.app.b localb = ((com.tencent.mm.choosemsgfile.compat.b)g.E(com.tencent.mm.choosemsgfile.compat.b.class)).q(this.Cu, this.eaY);
    if (((com.tencent.mm.choosemsgfile.compat.b)g.E(com.tencent.mm.choosemsgfile.compat.b.class)).a(this.kEz, localb))
    {
      MsgFile localMsgFile = new MsgFile();
      localMsgFile.fileSize = this.kEs.bgn();
      localMsgFile.filePath = localb.field_fileFullPath;
      localMsgFile.fileName = this.kEs.getFileName();
      localMsgFile.type = "file";
      localMsgFile.elt = this.kEs.bgm();
      localMsgFile.timeStamp = (this.kEs.getTimeStamp() / 1000L);
      b(localMsgFile);
      AppMethodBeat.o(54266);
      return true;
    }
    AppMethodBeat.o(54266);
    return false;
  }
  
  protected final void bgg()
  {
    AppMethodBeat.i(54267);
    boolean bool = ((com.tencent.mm.choosemsgfile.compat.b)g.E(com.tencent.mm.choosemsgfile.compat.b.class)).a(this.Cu, this.kEz, new e.1(this));
    ab.i("MicroMsg.MsgFileWorker_File", "initOk:%b", new Object[] { Boolean.valueOf(bool) });
    if (!bool)
    {
      ab.i("MicroMsg.MsgFileWorker_File", "initOk fail");
      bgi();
    }
    AppMethodBeat.o(54267);
  }
  
  protected final boolean checkValid()
  {
    AppMethodBeat.i(54265);
    ab.i("MicroMsg.MsgFileWorker_File", "start %s", new Object[] { this });
    if ((this.kEs == null) || (this.kEs.kEz == null))
    {
      ab.e("MicroMsg.MsgFileWorker_File", "mMsgInfo is null, err");
      AppMethodBeat.o(54265);
      return false;
    }
    this.kEz = this.kEs.kEz;
    this.eaY = this.kEs.kEz.field_msgId;
    j.b localb = j.b.mY(this.kEz.field_content);
    if (localb == null)
    {
      ab.e("MicroMsg.MsgFileWorker_File", "parse msgContent error, %s", new Object[] { this.kEz.field_content });
      AppMethodBeat.o(54265);
      return false;
    }
    if ((bo.isNullOrNil(localb.cmN)) && (!bo.isNullOrNil(localb.fgL)))
    {
      ab.e("MicroMsg.MsgFileWorker_File", "msgContent format error, %s", new Object[] { this.kEz.field_content });
      localb.cmN = localb.fgL.hashCode();
    }
    this.Cu = localb.cmN;
    if (bo.isNullOrNil(this.Cu))
    {
      ab.e("MicroMsg.MsgFileWorker_File", "MediaId is null, err return");
      AppMethodBeat.o(54265);
      return false;
    }
    AppMethodBeat.o(54265);
    return true;
  }
  
  public final void dead()
  {
    AppMethodBeat.i(54268);
    ab.i("MicroMsg.MsgFileWorker_File", "dead");
    if (this.kEA != null) {
      this.kEA.dead();
    }
    AppMethodBeat.o(54268);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.a.e
 * JD-Core Version:    0.7.0.1
 */