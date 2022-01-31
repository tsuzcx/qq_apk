package com.tencent.mm.plugin.extaccessories;

import com.samsung.android.sdk.look.writingbuddy.SlookWritingBuddy;
import com.tencent.mm.h.a.nj;
import com.tencent.mm.h.a.nj.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.y;

public final class b$a
  extends c<nj>
{
  public b$a()
  {
    this.udX = nj.class.getName().hashCode();
  }
  
  private boolean a(nj paramnj)
  {
    if (!(paramnj instanceof nj))
    {
      y.f("MicroMsg.extaccessories.SubCoreExtAccessories", "mismatched event");
      return false;
    }
    y.d("MicroMsg.extaccessories.SubCoreExtAccessories", "RegistSpenBuddyEvent");
    if ((paramnj.bWZ != null) && (paramnj.bWZ.bXb != null) && (paramnj.bWZ.bXa != null)) {}
    try
    {
      new SlookWritingBuddy(paramnj.bWZ.bXb).setImageWritingListener(new SubCoreExtAccessories.RegistSpenBuddyEventListener.1(this, paramnj));
      return true;
    }
    catch (Exception paramnj)
    {
      for (;;)
      {
        y.e("MicroMsg.extaccessories.SubCoreExtAccessories", "exception in writingBuddy %s", new Object[] { paramnj.getMessage() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.extaccessories.b.a
 * JD-Core Version:    0.7.0.1
 */