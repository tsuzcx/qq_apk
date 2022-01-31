package com.tencent.mm.plugin.hp.tinker;

import com.tencent.tinker.lib.f.a;
import com.tencent.tinker.lib.f.b;

final class TinkerPatchResultService$1
  implements Runnable
{
  TinkerPatchResultService$1(TinkerPatchResultService paramTinkerPatchResultService) {}
  
  public final void run()
  {
    a.w("Tinker.TinkerPatchResultService", "actually kill tinker patch service!", new Object[0]);
    b.hO(this.lnr.getApplicationContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.tinker.TinkerPatchResultService.1
 * JD-Core Version:    0.7.0.1
 */