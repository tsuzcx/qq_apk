package com.tencent.mm.plugin.ext.provider;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.d.a.b;

final class ExtControlProviderSearchContact$1
  implements Runnable
{
  ExtControlProviderSearchContact$1(ExtControlProviderSearchContact paramExtControlProviderSearchContact, Cursor paramCursor, b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(20385);
    ExtControlProviderSearchContact.a(this.meT, ExtControlProviderSearchContact.e(this.hcU));
    this.jMg.countDown();
    AppMethodBeat.o(20385);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.provider.ExtControlProviderSearchContact.1
 * JD-Core Version:    0.7.0.1
 */