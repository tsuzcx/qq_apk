package com.tencent.mm.plugin.backup.backupui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.b.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;

final class a$a
  implements b.a
{
  private final WeakReference<a> jGI;
  
  a$a(a parama)
  {
    AppMethodBeat.i(17711);
    this.jGI = new WeakReference(parama);
    AppMethodBeat.o(17711);
  }
  
  public final void re(int paramInt)
  {
    AppMethodBeat.i(17712);
    a locala = (a)this.jGI.get();
    if (locala != null)
    {
      a.a(locala, paramInt);
      AppMethodBeat.o(17712);
      return;
    }
    ab.e(a.access$100(), "BackupChatBanner WeakReference is null!");
    AppMethodBeat.o(17712);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupui.a.a
 * JD-Core Version:    0.7.0.1
 */