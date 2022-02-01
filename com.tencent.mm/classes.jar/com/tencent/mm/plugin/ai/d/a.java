package com.tencent.mm.plugin.ai.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.o.a;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;

public abstract class a<T extends IAutoDBItem>
  extends MAutoStorage
{
  protected o.a qpk;
  
  public a(o.a parama, IAutoDBItem.MAutoDBInfo paramMAutoDBInfo, String paramString, String[] paramArrayOfString)
  {
    super(parama, paramMAutoDBInfo, paramString, paramArrayOfString);
    this.qpk = parama;
    h.ahAA.g(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(267413);
        a.a(a.this);
        AppMethodBeat.o(267413);
      }
    }, "CLEAN_DB");
  }
  
  public abstract int caF();
  
  public abstract String caG();
  
  public abstract String tableName();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.d.a
 * JD-Core Version:    0.7.0.1
 */