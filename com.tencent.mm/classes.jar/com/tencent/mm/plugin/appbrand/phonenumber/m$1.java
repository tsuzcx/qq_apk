package com.tencent.mm.plugin.appbrand.phonenumber;

import a.f.a.a;
import a.f.a.b;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManageDialog$1", "Lcom/tencent/mm/plugin/appbrand/phonenumber/BaseRequestDialog$Listener;", "onMsg", "", "resultCode", "", "plugin-appbrand-integration_release"})
public final class m$1
  implements a.b
{
  public final void pr(int paramInt)
  {
    AppMethodBeat.i(143954);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(143954);
      return;
      this.iEc.iDV.invoke();
      Object localObject1 = m.a(this.iEc);
      if (localObject1 != null) {}
      for (localObject1 = ((j)localObject1).iDe;; localObject1 = null)
      {
        if (localObject1 == null) {
          a.f.b.j.ebi();
        }
        Object localObject2 = ((ArrayList)localObject1).iterator();
        do
        {
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject1 = (PhoneItem)((Iterator)localObject2).next();
        } while (!((PhoneItem)localObject1).iDt);
        localObject2 = this.iEc.iEb;
        if (localObject2 == null) {
          break label143;
        }
        a.f.b.j.p(localObject1, "phoneItem");
        ((b)localObject2).S(localObject1);
        AppMethodBeat.o(143954);
        return;
      }
      label143:
      AppMethodBeat.o(143954);
      return;
      this.iEc.iDW.invoke();
      AppMethodBeat.o(143954);
      return;
      this.iEc.iDX.invoke();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.m.1
 * JD-Core Version:    0.7.0.1
 */