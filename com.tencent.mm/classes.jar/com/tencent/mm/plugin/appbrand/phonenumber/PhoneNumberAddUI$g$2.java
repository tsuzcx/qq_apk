package com.tencent.mm.plugin.appbrand.phonenumber;

import a.f.b.j;
import a.l;
import android.support.v7.app.AppCompatActivity;
import b.a.a.a.a.a.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.bn;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class PhoneNumberAddUI$g$2
  implements Runnable
{
  PhoneNumberAddUI$g$2(PhoneNumberAddUI.g paramg) {}
  
  public final void run()
  {
    AppMethodBeat.i(134825);
    Object localObject2 = a.CKU.azy(this.iDF.iDB.appId);
    if (localObject2 != null)
    {
      localObject1 = a.CKU.azy(this.iDF.iDB.appId);
      if (localObject1 == null) {
        break label114;
      }
    }
    label114:
    for (Object localObject1 = Long.valueOf(((bn)localObject1).GJ());; localObject1 = null)
    {
      if (localObject1 == null) {
        j.ebi();
      }
      ((bn)localObject2).dY(((Long)localObject1).longValue() + 1L);
      localObject1 = this.iDF.iDB;
      localObject2 = this.iDF.iDB.getContext().getString(2131296666);
      j.p(localObject2, "context.getString(R.stri…er_send_verify_code_fail)");
      PhoneNumberAddUI.a((PhoneNumberAddUI)localObject1, (String)localObject2);
      AppMethodBeat.o(134825);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberAddUI.g.2
 * JD-Core Version:    0.7.0.1
 */