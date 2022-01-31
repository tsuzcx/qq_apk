package com.tencent.mm.plugin.label.ui;

import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.label.a.a;
import com.tencent.mm.plugin.label.a.b;
import com.tencent.mm.plugin.label.e;
import com.tencent.mm.plugin.label.ui.widget.MMLabelPanel;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bv;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

final class ContactLabelUI$12
  implements Runnable
{
  ContactLabelUI$12(ContactLabelUI paramContactLabelUI) {}
  
  public final void run()
  {
    Object localObject2 = null;
    Object localObject1 = null;
    Object localObject3 = null;
    ContactLabelUI.g(this.lCj).clear();
    ContactLabelUI.h(this.lCj).clear();
    if (ContactLabelUI.b(this.lCj) != null)
    {
      if (ContactLabelUI.d(this.lCj))
      {
        au.Hx();
        localObject2 = c.Fx().Id(ContactLabelUI.i(this.lCj));
        localObject1 = localObject3;
        if (localObject2 != null) {
          localObject1 = ((bv)localObject2).field_contactLabels;
        }
        localObject3 = localObject1;
        if (bk.bl((String)localObject1))
        {
          au.Hx();
          ad localad = c.Fw().abl(ContactLabelUI.i(this.lCj));
          localObject3 = localad.field_encryptUsername;
          localObject2 = localObject1;
          if (!bk.bl((String)localObject3))
          {
            au.Hx();
            localObject3 = c.Fx().Id((String)localObject3);
            localObject2 = localObject1;
            if (localObject3 != null) {
              localObject2 = ((bv)localObject3).field_contactLabels;
            }
          }
          localObject3 = localObject2;
          if (bk.bl((String)localObject2))
          {
            localObject1 = localad.field_username;
            au.Hx();
            localObject1 = c.Fx().Id((String)localObject1);
            localObject3 = localObject2;
            if (localObject1 != null) {
              localObject3 = ((bv)localObject1).field_contactLabels;
            }
          }
        }
        localObject1 = (ArrayList)a.bdA().Gm((String)localObject3);
        ContactLabelUI.b(this.lCj).a((Collection)localObject1, (List)localObject1);
        ContactLabelUI.a(this.lCj, (ArrayList)localObject1);
      }
    }
    else if (ContactLabelUI.c(this.lCj) != null)
    {
      ContactLabelUI.b(this.lCj, e.bdz().cuh());
      if ((ContactLabelUI.j(this.lCj) == null) || (ContactLabelUI.j(this.lCj).size() <= 0)) {
        break label405;
      }
      ContactLabelUI.d(this.lCj);
      ContactLabelUI.c(this.lCj).a((Collection)localObject1, ContactLabelUI.j(this.lCj));
      if (ContactLabelUI.k(this.lCj))
      {
        h.nFQ.f(11346, new Object[] { Integer.valueOf(0), Integer.valueOf(1) });
        ContactLabelUI.l(this.lCj);
      }
    }
    for (;;)
    {
      ContactLabelUI.a(this.lCj, ContactLabelUI.a.lCl);
      return;
      au.Hx();
      localObject3 = c.Fw().abl(ContactLabelUI.i(this.lCj));
      localObject1 = localObject2;
      if (localObject3 == null) {
        break;
      }
      localObject3 = ((ao)localObject3).field_contactLabelIds;
      localObject1 = localObject2;
      if (bk.bl((String)localObject3)) {
        break;
      }
      localObject1 = (ArrayList)a.bdA().Gn((String)localObject3);
      break;
      label405:
      if (ContactLabelUI.k(this.lCj))
      {
        h.nFQ.f(11346, new Object[] { Integer.valueOf(0), Integer.valueOf(0) });
        ContactLabelUI.l(this.lCj);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelUI.12
 * JD-Core Version:    0.7.0.1
 */