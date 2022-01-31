package com.tencent.mm.plugin.ext.provider;

import com.tencent.mm.modelgeo.c;

final class ExtControlProviderNearBy$2
  implements Runnable
{
  ExtControlProviderNearBy$2(ExtControlProviderNearBy paramExtControlProviderNearBy) {}
  
  public final void run()
  {
    if (ExtControlProviderNearBy.a(this.jKJ) == null) {
      ExtControlProviderNearBy.a(this.jKJ, c.Ob());
    }
    ExtControlProviderNearBy.a(this.jKJ).a(ExtControlProviderNearBy.b(this.jKJ), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.provider.ExtControlProviderNearBy.2
 * JD-Core Version:    0.7.0.1
 */