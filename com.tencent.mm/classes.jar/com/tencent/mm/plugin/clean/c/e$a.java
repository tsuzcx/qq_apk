package com.tencent.mm.plugin.clean.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.storage.bi;
import java.io.File;

final class e$a
  extends com.tencent.mm.plugin.clean.c.a.a
{
  private a kGZ;
  
  public e$a(e parame, a parama)
  {
    super(parame);
    this.kGZ = parama;
  }
  
  public final void execute()
  {
    AppMethodBeat.i(18702);
    aw.aaz();
    Object localObject = c.YC().kB(this.kGZ.cpg);
    if (((dd)localObject).field_msgId != 0L)
    {
      ((bi)localObject).dyd();
      aw.aaz();
      c.YC().a(this.kGZ.cpg, (bi)localObject);
    }
    localObject = new File(this.kGZ.filePath);
    e.a(this.kGY, (int)(e.d(this.kGY) + ((File)localObject).length()));
    ((File)localObject).delete();
    AppMethodBeat.o(18702);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.c.e.a
 * JD-Core Version:    0.7.0.1
 */