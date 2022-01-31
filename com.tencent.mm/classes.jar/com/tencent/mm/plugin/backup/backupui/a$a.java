package com.tencent.mm.plugin.backup.backupui;

import com.tencent.mm.plugin.backup.b.b.a;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;

final class a$a
  implements b.a
{
  private final WeakReference<a> hNf;
  
  a$a(a parama)
  {
    this.hNf = new WeakReference(parama);
  }
  
  public final void ns(int paramInt)
  {
    a locala = (a)this.hNf.get();
    if (locala != null)
    {
      a.a(locala, paramInt);
      return;
    }
    y.e(a.access$100(), "BackupChatBanner WeakReference is null!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupui.a.a
 * JD-Core Version:    0.7.0.1
 */