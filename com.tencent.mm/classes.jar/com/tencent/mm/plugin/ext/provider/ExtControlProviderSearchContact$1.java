package com.tencent.mm.plugin.ext.provider;

import android.database.Cursor;
import com.tencent.mm.pluginsdk.d.a.b;

final class ExtControlProviderSearchContact$1
  implements Runnable
{
  ExtControlProviderSearchContact$1(ExtControlProviderSearchContact paramExtControlProviderSearchContact, Cursor paramCursor, b paramb) {}
  
  public final void run()
  {
    ExtControlProviderSearchContact.a(this.jKP, ExtControlProviderSearchContact.g(this.fKf));
    this.hSx.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.provider.ExtControlProviderSearchContact.1
 * JD-Core Version:    0.7.0.1
 */