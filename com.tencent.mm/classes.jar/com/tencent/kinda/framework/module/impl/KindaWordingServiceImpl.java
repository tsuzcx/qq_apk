package com.tencent.kinda.framework.module.impl;

import android.content.Context;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.KWordingService;
import com.tencent.kinda.gen.Wording;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class KindaWordingServiceImpl
  implements KWordingService
{
  public Wording getWording(String paramString1, String paramString2)
  {
    AppMethodBeat.i(18665);
    String str = "title";
    paramString2 = "desc";
    Wording localWording = new Wording(true, "entryTip", "title", "subTitle", "desc", "subDesc");
    Context localContext = KindaContext.get();
    if (paramString1.equals("valid_date"))
    {
      if (localContext != null)
      {
        str = localContext.getString(2131765115);
        paramString2 = localContext.getString(2131765116);
      }
      paramString2 = new Wording(true, "entryTip", str, "subTitle", paramString2, "subDesc");
    }
    for (;;)
    {
      AppMethodBeat.o(18665);
      return paramString2;
      if (paramString1.equals("cvv"))
      {
        if (localContext != null)
        {
          str = localContext.getString(2131757985);
          paramString2 = localContext.getString(2131757983);
        }
        paramString2 = new Wording(true, "entryTip", str, "subTitle", paramString2, "subDesc");
      }
      else
      {
        paramString2 = localWording;
        if (!paramString1.equals("phone_number"))
        {
          paramString2 = localWording;
          if (!paramString1.equals("sms"))
          {
            paramString1.equals("person");
            paramString2 = localWording;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.framework.module.impl.KindaWordingServiceImpl
 * JD-Core Version:    0.7.0.1
 */