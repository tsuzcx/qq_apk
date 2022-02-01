package com.tencent.mm.network;

import com.tencent.mars.mm.MMLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.bt;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

final class t$6
  extends bo<Object>
{
  t$6(t paramt, int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    super(1000L, null, (byte)0);
  }
  
  public final Object run()
  {
    AppMethodBeat.i(132777);
    Object localObject;
    if (this.cOj == 3)
    {
      localObject = new Date();
      ((Date)localObject).setTime(bt.eGO() - 86400000L * this.hLo);
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
      MMLogic.uploadFile(b.aii() + "crash_" + localSimpleDateFormat.format((Date)localObject) + ".txt", this.fqK, "");
    }
    for (;;)
    {
      AppMethodBeat.o(132777);
      return null;
      if (this.cOj == 2)
      {
        ad.eFw();
        int i = this.hLo;
        boolean bool = this.hLp;
        localObject = this.fqK;
        MMLogic.uploadLog(new int[] { i }, bool, (String)localObject, "");
      }
      else
      {
        ad.eFw();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.network.t.6
 * JD-Core Version:    0.7.0.1
 */