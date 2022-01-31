package com.tencent.mm.plugin.appbrand.phonenumber;

import a.f.a.r;
import a.f.b.j;
import a.l;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import b.a.a.a.a.a.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.bn;
import java.util.ArrayList;
import java.util.Iterator;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
final class PhoneNumberManagerUI$c
  implements MenuItem.OnMenuItemClickListener
{
  PhoneNumberManagerUI$c(PhoneNumberManagerUI paramPhoneNumberManagerUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(134861);
    paramMenuItem = PhoneNumberManagerUI.b(this.iEr);
    label65:
    label77:
    PhoneItem localPhoneItem;
    bn localbn;
    if (paramMenuItem != null)
    {
      paramMenuItem = paramMenuItem.iDc;
      if (paramMenuItem != null)
      {
        paramMenuItem = Integer.valueOf(paramMenuItem.size());
        if (paramMenuItem == null) {
          j.ebi();
        }
        if (paramMenuItem.intValue() < 0) {
          break label213;
        }
        paramMenuItem = PhoneNumberManagerUI.b(this.iEr);
        if (paramMenuItem == null) {
          break label203;
        }
        paramMenuItem = paramMenuItem.iDc;
        if (paramMenuItem == null) {
          j.ebi();
        }
        localObject = paramMenuItem.iterator();
        if (!((Iterator)localObject).hasNext()) {
          break label213;
        }
        localPhoneItem = (PhoneItem)((Iterator)localObject).next();
        localbn = a.CKU.azy(PhoneNumberManagerUI.a(this.iEr));
        if (localbn != null)
        {
          paramMenuItem = a.CKU.azy(PhoneNumberManagerUI.a(this.iEr));
          if (paramMenuItem == null) {
            break label208;
          }
        }
      }
    }
    label203:
    label208:
    for (paramMenuItem = Long.valueOf(paramMenuItem.GQ());; paramMenuItem = null)
    {
      if (paramMenuItem == null) {
        j.ebi();
      }
      localbn.ef(paramMenuItem.longValue() + 1L);
      new g(PhoneNumberManagerUI.a(this.iEr), localPhoneItem.czF, 1).a((r)new PhoneNumberManagerUI.c.1(this, localPhoneItem));
      break label77;
      paramMenuItem = null;
      break;
      paramMenuItem = null;
      break label65;
    }
    label213:
    Object localObject = k.iDv;
    paramMenuItem = PhoneNumberManagerUI.b(this.iEr);
    if (paramMenuItem != null) {}
    for (paramMenuItem = paramMenuItem.iDc;; paramMenuItem = null)
    {
      if (paramMenuItem == null) {
        j.ebi();
      }
      ((k)localObject).o(paramMenuItem);
      this.iEr.finish();
      this.iEr.overridePendingTransition(2131034130, 2131034130);
      AppMethodBeat.o(134861);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberManagerUI.c
 * JD-Core Version:    0.7.0.1
 */