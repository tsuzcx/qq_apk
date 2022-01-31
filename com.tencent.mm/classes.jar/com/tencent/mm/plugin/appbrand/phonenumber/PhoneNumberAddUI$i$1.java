package com.tencent.mm.plugin.appbrand.phonenumber;

import a.f.a.r;
import a.f.b.j;
import a.l;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.support.v7.app.AppCompatActivity;
import b.a.a.a.a.a.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.bn;
import com.tencent.mm.protocal.protobuf.tg;
import com.tencent.mm.ui.widget.MMSwitchBtn;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class PhoneNumberAddUI$i$1
  implements Runnable
{
  PhoneNumberAddUI$i$1(PhoneNumberAddUI.i parami, tg paramtg) {}
  
  public final void run()
  {
    Object localObject4 = null;
    Object localObject1 = null;
    Object localObject3 = null;
    Object localObject2 = null;
    AppMethodBeat.i(134832);
    int i = this.iDJ.status;
    Object localObject5 = h.iDb;
    if (i == h.aKL())
    {
      localObject3 = a.CKU.azy(this.iDI.iDB.appId);
      if (localObject3 != null)
      {
        localObject1 = a.CKU.azy(this.iDI.iDB.appId);
        if (localObject1 == null) {
          break label229;
        }
      }
      label229:
      for (localObject1 = Long.valueOf(((bn)localObject1).GL());; localObject1 = null)
      {
        if (localObject1 == null) {
          j.ebi();
        }
        ((bn)localObject3).ea(((Long)localObject1).longValue() + 1L);
        localObject3 = this.iDJ.iDp;
        localObject4 = this.iDJ.aRj;
        localObject5 = this.iDJ.wLG;
        MMSwitchBtn localMMSwitchBtn = this.iDI.iDB.iDy;
        localObject1 = localObject2;
        if (localMMSwitchBtn != null) {
          localObject1 = Boolean.valueOf(localMMSwitchBtn.dOH());
        }
        if (localObject1 == null) {
          j.ebi();
        }
        if (!((Boolean)localObject1).booleanValue()) {
          break;
        }
        new g(this.iDI.iDB.appId, this.iDI.iDB.czF, 0).a((r)new PhoneNumberAddUI.i.1.1(this, (String)localObject5, (String)localObject3, (String)localObject4));
        AppMethodBeat.o(134832);
        return;
      }
      localObject1 = k.iDv;
      localObject1 = this.iDI.iDB.czF;
      j.p(localObject5, "showMobile");
      j.p(localObject3, "encryptedData");
      j.p(localObject4, "iv");
      k.b(new PhoneItem((String)localObject1, (String)localObject5, (String)localObject3, (String)localObject4));
      this.iDI.iDB.finish();
      AppMethodBeat.o(134832);
      return;
    }
    localObject2 = h.iDb;
    if (i == h.aKM())
    {
      localObject2 = a.CKU.azy(this.iDI.iDB.appId);
      if (localObject2 != null)
      {
        localObject3 = a.CKU.azy(this.iDI.iDB.appId);
        localObject1 = localObject4;
        if (localObject3 != null) {
          localObject1 = Long.valueOf(((bn)localObject3).GM());
        }
        if (localObject1 == null) {
          j.ebi();
        }
        ((bn)localObject2).eb(((Long)localObject1).longValue() + 1L);
      }
      localObject1 = this.iDI.iDB;
      localObject2 = this.iDI.iDB.getContext().getString(2131296667);
      j.p(localObject2, "context.getString(R.stri…end_verify_code_frequent)");
      PhoneNumberAddUI.a((PhoneNumberAddUI)localObject1, (String)localObject2);
      AppMethodBeat.o(134832);
      return;
    }
    localObject2 = h.iDb;
    if (i == h.aKN())
    {
      localObject2 = a.CKU.azy(this.iDI.iDB.appId);
      if (localObject2 != null)
      {
        localObject3 = a.CKU.azy(this.iDI.iDB.appId);
        if (localObject3 != null) {
          localObject1 = Long.valueOf(((bn)localObject3).GM());
        }
        if (localObject1 == null) {
          j.ebi();
        }
        ((bn)localObject2).eb(((Long)localObject1).longValue() + 1L);
      }
      com.tencent.mm.ui.base.h.a((Context)this.iDI.iDB.getContext(), this.iDI.iDB.getContext().getString(2131296669), "", false, (DialogInterface.OnClickListener)PhoneNumberAddUI.i.1.2.iDO);
      AppMethodBeat.o(134832);
      return;
    }
    localObject2 = a.CKU.azy(this.iDI.iDB.appId);
    if (localObject2 != null)
    {
      localObject4 = a.CKU.azy(this.iDI.iDB.appId);
      localObject1 = localObject3;
      if (localObject4 != null) {
        localObject1 = Long.valueOf(((bn)localObject4).GM());
      }
      if (localObject1 == null) {
        j.ebi();
      }
      ((bn)localObject2).eb(((Long)localObject1).longValue() + 1L);
    }
    localObject1 = this.iDI.iDB;
    localObject2 = this.iDI.iDB.getContext().getString(2131296672);
    j.p(localObject2, "context.getString(R.stri…_number_verify_code_fail)");
    PhoneNumberAddUI.a((PhoneNumberAddUI)localObject1, (String)localObject2);
    AppMethodBeat.o(134832);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberAddUI.i.1
 * JD-Core Version:    0.7.0.1
 */