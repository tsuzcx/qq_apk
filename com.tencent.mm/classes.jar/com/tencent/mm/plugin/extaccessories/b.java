package com.tencent.mm.plugin.extaccessories;

import com.samsung.android.sdk.look.writingbuddy.SlookWritingBuddy;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.g.a.og;
import com.tencent.mm.g.a.og.a;
import com.tencent.mm.model.at;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.io.File;
import java.util.HashMap;

public final class b
  implements at
{
  String eHR;
  private a mfQ;
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.d> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(20469);
    ab.d("MicroMsg.extaccessories.SubCoreExtAccessories", "SubCoreExtAccessories reset");
    if (this.mfQ == null) {
      this.mfQ = new a();
    }
    a.ymk.c(this.mfQ);
    aw.RO().o(new b.1(this), 5000L);
    AppMethodBeat.o(20469);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(20470);
    ab.d("MicroMsg.extaccessories.SubCoreExtAccessories", "SubCoreExtAccessories release");
    if (this.mfQ != null) {
      a.ymk.d(this.mfQ);
    }
    AppMethodBeat.o(20470);
  }
  
  public final void onSdcardMount(boolean paramBoolean)
  {
    AppMethodBeat.i(20468);
    aw.aaz();
    this.eHR = com.tencent.mm.model.c.getAccPath();
    File localFile = new File(this.eHR);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    localFile = new File(this.eHR + "image/spen/");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    AppMethodBeat.o(20468);
  }
  
  public static final class a
    extends com.tencent.mm.sdk.b.c<og>
  {
    public a()
    {
      AppMethodBeat.i(20465);
      this.__eventId = og.class.getName().hashCode();
      AppMethodBeat.o(20465);
    }
    
    private boolean a(og paramog)
    {
      AppMethodBeat.i(20466);
      if (!(paramog instanceof og))
      {
        ab.f("MicroMsg.extaccessories.SubCoreExtAccessories", "mismatched event");
        AppMethodBeat.o(20466);
        return false;
      }
      ab.d("MicroMsg.extaccessories.SubCoreExtAccessories", "RegistSpenBuddyEvent");
      if ((paramog.cEQ != null) && (paramog.cEQ.cES != null) && (paramog.cEQ.cER != null)) {}
      try
      {
        new SlookWritingBuddy(paramog.cEQ.cES).setImageWritingListener(new SubCoreExtAccessories.RegistSpenBuddyEventListener.1(this, paramog));
        AppMethodBeat.o(20466);
        return true;
      }
      catch (Exception paramog)
      {
        for (;;)
        {
          ab.e("MicroMsg.extaccessories.SubCoreExtAccessories", "exception in writingBuddy %s", new Object[] { paramog.getMessage() });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.extaccessories.b
 * JD-Core Version:    0.7.0.1
 */