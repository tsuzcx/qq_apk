package com.tencent.mm.plugin.label.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.label.a.a;
import com.tencent.mm.plugin.label.a.b;
import com.tencent.mm.plugin.label.e;
import com.tencent.mm.plugin.label.ui.widget.MMLabelPanel;
import com.tencent.mm.plugin.messenger.foundation.a.a.m;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bo;
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
    AppMethodBeat.i(22676);
    ContactLabelUI.g(this.nZv).clear();
    ContactLabelUI.h(this.nZv).clear();
    Object localObject1 = null;
    Object localObject2 = null;
    Object localObject3;
    if (ContactLabelUI.b(this.nZv) != null)
    {
      if (ContactLabelUI.d(this.nZv))
      {
        localObject1 = null;
        aw.aaz();
        localObject2 = c.YB().TM(ContactLabelUI.i(this.nZv));
        if (localObject2 != null) {
          localObject1 = ((bv)localObject2).field_contactLabels;
        }
        localObject3 = localObject1;
        if (bo.isNullOrNil((String)localObject1))
        {
          aw.aaz();
          ad localad = c.YA().arw(ContactLabelUI.i(this.nZv));
          localObject3 = localad.field_encryptUsername;
          localObject2 = localObject1;
          if (!bo.isNullOrNil((String)localObject3))
          {
            aw.aaz();
            localObject3 = c.YB().TM((String)localObject3);
            localObject2 = localObject1;
            if (localObject3 != null) {
              localObject2 = ((bv)localObject3).field_contactLabels;
            }
          }
          localObject3 = localObject2;
          if (bo.isNullOrNil((String)localObject2))
          {
            localObject1 = localad.field_username;
            aw.aaz();
            localObject1 = c.YB().TM((String)localObject1);
            localObject3 = localObject2;
            if (localObject1 != null) {
              localObject3 = ((bv)localObject1).field_contactLabels;
            }
          }
        }
        localObject1 = (ArrayList)a.bKV().RP((String)localObject3);
        ContactLabelUI.b(this.nZv).a((Collection)localObject1, (List)localObject1);
        ContactLabelUI.a(this.nZv, (ArrayList)localObject1);
      }
    }
    else if (ContactLabelUI.c(this.nZv) != null)
    {
      ContactLabelUI.b(this.nZv, e.bKU().dwG());
      if ((ContactLabelUI.j(this.nZv) == null) || (ContactLabelUI.j(this.nZv).size() <= 0)) {
        break label415;
      }
      ContactLabelUI.d(this.nZv);
      ContactLabelUI.c(this.nZv).a((Collection)localObject1, ContactLabelUI.j(this.nZv));
      if (ContactLabelUI.k(this.nZv))
      {
        h.qsU.e(11346, new Object[] { Integer.valueOf(0), Integer.valueOf(1) });
        ContactLabelUI.l(this.nZv);
      }
    }
    for (;;)
    {
      ContactLabelUI.a(this.nZv, ContactLabelUI.a.nZx);
      AppMethodBeat.o(22676);
      return;
      aw.aaz();
      localObject3 = c.YA().arw(ContactLabelUI.i(this.nZv));
      localObject1 = localObject2;
      if (localObject3 == null) {
        break;
      }
      localObject3 = ((aq)localObject3).field_contactLabelIds;
      localObject1 = localObject2;
      if (bo.isNullOrNil((String)localObject3)) {
        break;
      }
      localObject1 = (ArrayList)a.bKV().RQ((String)localObject3);
      break;
      label415:
      if (ContactLabelUI.k(this.nZv))
      {
        h.qsU.e(11346, new Object[] { Integer.valueOf(0), Integer.valueOf(0) });
        ContactLabelUI.l(this.nZv);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelUI.12
 * JD-Core Version:    0.7.0.1
 */