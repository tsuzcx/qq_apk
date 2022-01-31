package com.tencent.mm.plugin.choosemsgfile.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.d;
import com.tencent.mm.at.o;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;

public final class f
  extends c
{
  private com.tencent.mm.at.e kEE;
  private bi kEz;
  
  public f(com.tencent.mm.plugin.choosemsgfile.b.b.a parama, a parama1, com.tencent.mm.vending.e.b paramb)
  {
    super(parama, parama1, paramb);
  }
  
  private void IW(String paramString)
  {
    AppMethodBeat.i(54278);
    MsgFile localMsgFile = new MsgFile();
    localMsgFile.fileSize = ((int)com.tencent.mm.vfs.e.avI(paramString));
    localMsgFile.filePath = paramString;
    localMsgFile.fileName = this.kEE.fDM;
    localMsgFile.type = "image";
    localMsgFile.elt = com.tencent.mm.plugin.choosemsgfile.b.d.b.cP(localMsgFile.fileName);
    localMsgFile.timeStamp = this.kEE.fDT;
    b(localMsgFile);
    AppMethodBeat.o(54278);
  }
  
  private void a(com.tencent.mm.plugin.choosemsgfile.b.b.b paramb)
  {
    AppMethodBeat.i(54277);
    MsgFile localMsgFile = new MsgFile();
    localMsgFile.fileSize = paramb.bgn();
    localMsgFile.filePath = ((com.tencent.mm.choosemsgfile.compat.b)g.E(com.tencent.mm.choosemsgfile.compat.b.class)).e(this.kEz);
    localMsgFile.fileName = (paramb.getFileName() + "." + localMsgFile.elt);
    localMsgFile.type = "image";
    localMsgFile.elt = paramb.bgm();
    localMsgFile.timeStamp = paramb.getTimeStamp();
    b(localMsgFile);
    AppMethodBeat.o(54277);
  }
  
  protected final boolean bgf()
  {
    AppMethodBeat.i(54275);
    if (this.kEz.getType() == 268435505)
    {
      if (com.tencent.mm.vfs.e.cN(((com.tencent.mm.choosemsgfile.compat.b)g.E(com.tencent.mm.choosemsgfile.compat.b.class)).e(this.kEz)))
      {
        if ((this.kEs instanceof com.tencent.mm.plugin.choosemsgfile.b.b.b)) {
          a((com.tencent.mm.plugin.choosemsgfile.b.b.b)this.kEs);
        }
        for (;;)
        {
          AppMethodBeat.o(54275);
          return true;
          ab.e("MicroMsg.MsgFileWorker_Image", "mMsgItem isn't AppMsgImageMsgItem, err");
          bgi();
        }
      }
    }
    else if (this.kEE.ahg())
    {
      String str = ((com.tencent.mm.choosemsgfile.compat.b)g.E(com.tencent.mm.choosemsgfile.compat.b.class)).a(this.kEz, this.kEE);
      if (!bo.isNullOrNil(str))
      {
        IW(str);
        AppMethodBeat.o(54275);
        return true;
      }
    }
    AppMethodBeat.o(54275);
    return false;
  }
  
  protected final void bgg()
  {
    AppMethodBeat.i(54276);
    if (this.kEz.getType() == 268435505)
    {
      ((com.tencent.mm.choosemsgfile.compat.b)g.E(com.tencent.mm.choosemsgfile.compat.b.class)).a(this.kEz, new f.1(this));
      AppMethodBeat.o(54276);
      return;
    }
    ab.i("MicroMsg.MsgFileWorker_Image", "isOk:%b", new Object[] { Boolean.valueOf(o.ahD().a(this.kEE.fDL, this.kEz.field_msgId, 0, Long.valueOf(this.kEz.field_msgId), 2130838228, new f.2(this))) });
    AppMethodBeat.o(54276);
  }
  
  protected final boolean checkValid()
  {
    AppMethodBeat.i(54274);
    if ((this.kEs == null) || (this.kEs.kEz == null))
    {
      ab.e("MicroMsg.MsgFileWorker_Image", "mMsgInfo is null, return");
      bgi();
      AppMethodBeat.o(54274);
      return false;
    }
    this.kEz = this.kEs.kEz;
    if (this.kEz.dyc())
    {
      ab.e("MicroMsg.MsgFileWorker_Image", "mMsgInfo:%s is clean, return", new Object[] { this.kEz });
      AppMethodBeat.o(54274);
      return false;
    }
    if (!((com.tencent.mm.choosemsgfile.compat.b)g.E(com.tencent.mm.choosemsgfile.compat.b.class)).c(this.kEz))
    {
      ab.e("MicroMsg.MsgFileWorker_Image", "mMsgInfo is not img msg, return");
      AppMethodBeat.o(54274);
      return false;
    }
    if (this.kEz.getType() == 268435505)
    {
      AppMethodBeat.o(54274);
      return true;
    }
    this.kEE = ((com.tencent.mm.choosemsgfile.compat.b)g.E(com.tencent.mm.choosemsgfile.compat.b.class)).d(this.kEz);
    if (this.kEE == null)
    {
      ab.e("MicroMsg.MsgFileWorker_Image", "mImgInfo is null, return");
      AppMethodBeat.o(54274);
      return false;
    }
    AppMethodBeat.o(54274);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.a.f
 * JD-Core Version:    0.7.0.1
 */