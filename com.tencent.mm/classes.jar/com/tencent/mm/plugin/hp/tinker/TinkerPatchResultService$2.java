package com.tencent.mm.plugin.hp.tinker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelmulti.l.a;

final class TinkerPatchResultService$2
  implements l.a
{
  TinkerPatchResultService$2(TinkerPatchResultService paramTinkerPatchResultService) {}
  
  public final void da(boolean paramBoolean)
  {
    AppMethodBeat.i(90662);
    boolean bool1 = TinkerPatchResultService.access$000();
    boolean bool2 = com.tencent.mm.r.a.Ok();
    if ((!paramBoolean) && (!bool1) && (!bool2))
    {
      TinkerPatchResultService.a(this.nKK);
      AppMethodBeat.o(90662);
      return;
    }
    com.tencent.tinker.lib.f.a.w("Tinker.TinkerPatchResultService", "not hit condition, skip suicide this time. cond: screenOn: %s, voip: %s, multiTalk: %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    AppMethodBeat.o(90662);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.tinker.TinkerPatchResultService.2
 * JD-Core Version:    0.7.0.1
 */