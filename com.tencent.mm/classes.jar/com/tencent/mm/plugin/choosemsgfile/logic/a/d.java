package com.tencent.mm.plugin.choosemsgfile.logic.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.plugin.choosemsgfile.logic.b.e;
import com.tencent.mm.plugin.choosemsgfile.logic.b.j;
import com.tencent.mm.vending.e.b;

public final class d
  extends c
{
  private int Sc;
  private int tK;
  
  public d(com.tencent.mm.plugin.choosemsgfile.logic.b.a parama, a parama1, b paramb)
  {
    super(parama, parama1, paramb);
    AppMethodBeat.i(123229);
    this.Sc = 0;
    this.tK = parama.dqt();
    AppMethodBeat.o(123229);
  }
  
  private void callback()
  {
    AppMethodBeat.i(123232);
    if (dqq())
    {
      MsgFile localMsgFile = new MsgFile();
      localMsgFile.fileSize = this.wPs.dqt();
      localMsgFile.filePath = "only for test";
      localMsgFile.fileName = (this.wPs.getFileName() + "." + localMsgFile.lPJ);
      localMsgFile.type = "file";
      localMsgFile.lPJ = this.wPs.getFileExt();
      localMsgFile.timeStamp = this.wPs.getTimeStamp();
      b(localMsgFile);
      AppMethodBeat.o(123232);
      return;
    }
    dqo();
    AppMethodBeat.o(123232);
  }
  
  private boolean dqp()
  {
    if ((this.wPs instanceof j)) {
      throw null;
    }
    if ((this.wPs instanceof e)) {
      throw null;
    }
    return false;
  }
  
  private boolean dqq()
  {
    if ((this.wPs instanceof j)) {
      throw null;
    }
    if ((this.wPs instanceof e)) {
      throw null;
    }
    return false;
  }
  
  protected final void cCw()
  {
    AppMethodBeat.i(123231);
    if ((this.wPs instanceof j))
    {
      AppMethodBeat.o(123231);
      throw null;
    }
    if ((this.wPs instanceof e))
    {
      AppMethodBeat.o(123231);
      throw null;
    }
    callback();
    AppMethodBeat.o(123231);
  }
  
  protected final boolean checkValid()
  {
    if ((this.wPs instanceof j)) {
      throw null;
    }
    if ((this.wPs instanceof e)) {
      throw null;
    }
    return false;
  }
  
  protected final boolean dqm()
  {
    AppMethodBeat.i(123230);
    if (dqp()) {
      callback();
    }
    boolean bool = dqp();
    AppMethodBeat.o(123230);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.logic.a.d
 * JD-Core Version:    0.7.0.1
 */