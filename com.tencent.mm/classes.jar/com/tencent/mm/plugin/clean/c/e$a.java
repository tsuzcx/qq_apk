package com.tencent.mm.plugin.clean.c;

import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.storage.bi;
import java.io.File;

final class e$a
  extends com.tencent.mm.plugin.clean.c.a.a
{
  private a iBS;
  
  public e$a(e parame, a parama)
  {
    super(parame);
    this.iBS = parama;
  }
  
  public final void execute()
  {
    au.Hx();
    Object localObject = c.Fy().fd(this.iBS.bHR);
    if (((cs)localObject).field_msgId != 0L)
    {
      ((bi)localObject).cvy();
      au.Hx();
      c.Fy().a(this.iBS.bHR, (bi)localObject);
    }
    localObject = new File(this.iBS.filePath);
    e.a(this.iBR, (int)(e.d(this.iBR) + ((File)localObject).length()));
    ((File)localObject).delete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.c.e.a
 * JD-Core Version:    0.7.0.1
 */