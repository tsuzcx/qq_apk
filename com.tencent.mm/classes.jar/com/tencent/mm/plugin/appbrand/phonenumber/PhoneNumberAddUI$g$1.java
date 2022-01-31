package com.tencent.mm.plugin.appbrand.phonenumber;

import a.f.b.j;
import a.l;
import android.support.v7.app.AppCompatActivity;
import b.a.a.a.a.a.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.bn;
import com.tencent.mm.protocal.protobuf.bzm;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class PhoneNumberAddUI$g$1
  implements Runnable
{
  PhoneNumberAddUI$g$1(PhoneNumberAddUI.g paramg, bzm parambzm) {}
  
  public final void run()
  {
    Object localObject3 = null;
    Object localObject1 = null;
    Object localObject2 = null;
    Object localObject4 = null;
    AppMethodBeat.i(134824);
    int i = this.iDG.status;
    h localh = h.iDb;
    if (i == h.aKI())
    {
      localObject2 = a.CKU.azy(this.iDF.iDB.appId);
      if (localObject2 != null)
      {
        localObject3 = a.CKU.azy(this.iDF.iDB.appId);
        localObject1 = localObject4;
        if (localObject3 != null) {
          localObject1 = Long.valueOf(((bn)localObject3).GI());
        }
        if (localObject1 == null) {
          j.ebi();
        }
        ((bn)localObject2).dX(((Long)localObject1).longValue() + 1L);
        AppMethodBeat.o(134824);
        return;
      }
      AppMethodBeat.o(134824);
      return;
    }
    localObject4 = h.iDb;
    if (i == h.aKJ())
    {
      localObject2 = a.CKU.azy(this.iDF.iDB.appId);
      if (localObject2 != null)
      {
        localObject4 = a.CKU.azy(this.iDF.iDB.appId);
        localObject1 = localObject3;
        if (localObject4 != null) {
          localObject1 = Long.valueOf(((bn)localObject4).GJ());
        }
        if (localObject1 == null) {
          j.ebi();
        }
        ((bn)localObject2).dY(((Long)localObject1).longValue() + 1L);
      }
      localObject1 = this.iDF.iDB;
      localObject2 = this.iDF.iDB.getContext().getString(2131296666);
      j.p(localObject2, "context.getString(R.stri…er_send_verify_code_fail)");
      PhoneNumberAddUI.a((PhoneNumberAddUI)localObject1, (String)localObject2);
      AppMethodBeat.o(134824);
      return;
    }
    localObject3 = h.iDb;
    if (i == h.aKK())
    {
      localObject2 = a.CKU.azy(this.iDF.iDB.appId);
      if (localObject2 != null)
      {
        localObject3 = a.CKU.azy(this.iDF.iDB.appId);
        if (localObject3 != null) {
          localObject1 = Long.valueOf(((bn)localObject3).GJ());
        }
        if (localObject1 == null) {
          j.ebi();
        }
        ((bn)localObject2).dY(((Long)localObject1).longValue() + 1L);
      }
      localObject1 = this.iDF.iDB;
      localObject2 = this.iDF.iDB.getContext().getString(2131296667);
      j.p(localObject2, "context.getString(R.stri…end_verify_code_frequent)");
      PhoneNumberAddUI.a((PhoneNumberAddUI)localObject1, (String)localObject2);
      AppMethodBeat.o(134824);
      return;
    }
    localObject3 = a.CKU.azy(this.iDF.iDB.appId);
    if (localObject3 != null)
    {
      localObject4 = a.CKU.azy(this.iDF.iDB.appId);
      localObject1 = localObject2;
      if (localObject4 != null) {
        localObject1 = Long.valueOf(((bn)localObject4).GJ());
      }
      if (localObject1 == null) {
        j.ebi();
      }
      ((bn)localObject3).dY(((Long)localObject1).longValue() + 1L);
    }
    localObject1 = this.iDF.iDB;
    localObject2 = this.iDF.iDB.getContext().getString(2131296666);
    j.p(localObject2, "context.getString(R.stri…er_send_verify_code_fail)");
    PhoneNumberAddUI.a((PhoneNumberAddUI)localObject1, (String)localObject2);
    AppMethodBeat.o(134824);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberAddUI.g.1
 * JD-Core Version:    0.7.0.1
 */