package com.tencent.mm.loader;

import a.l;
import a.v;
import com.tencent.mm.loader.e.b.b;
import com.tencent.mm.loader.e.b.d;
import com.tencent.mm.loader.e.b.e;
import com.tencent.mm.loader.e.b.e.a;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/loader/Reaper$request$5$2", "Lcom/tencent/mm/loader/impr/target/IWaitUI;", "uiDone", "", "libimageloader_release"})
public final class f$b
  implements b
{
  f$b(f paramf, boolean paramBoolean) {}
  
  public final void Ta()
  {
    Object localObject = e.eOI;
    localObject = e.a.TL();
    d locald = this.eNe.SY();
    if (locald == null) {
      throw new v("null cannot be cast to non-null type com.tencent.mm.loader.impr.target.ResourceShowTarget<kotlin.Any>");
    }
    ((e)localObject).a(locald, this.eNe.eMZ, "may be hit cache");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.loader.f.b
 * JD-Core Version:    0.7.0.1
 */