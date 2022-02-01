package com.tencent.luggage.game.d.a.a;

import com.tencent.luggage.sdk.b.a.c.c;
import com.tencent.magicbrush.handler.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;

final class a$5
  implements b
{
  a$5(a parama) {}
  
  public final String a(final String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(190405);
    if (this.ckh.El() == null)
    {
      AppMethodBeat.o(190405);
      return "";
    }
    try
    {
      paramString1 = ((c)this.ckh.El()).b(paramString1, paramString2, paramInt, paramBoolean);
      AppMethodBeat.o(190405);
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      ad.printErrStackTrace("Luggage.AppBrandGameServiceLogicImp", paramString1, "IMBInvokeHandler.invoke", new Object[0]);
      aq.f(new Runnable()
      {
        public final void run()
        {
          throw paramString1;
        }
      });
      AppMethodBeat.o(190405);
    }
    return "";
  }
  
  public final String[] getAsyncableJsApis()
  {
    AppMethodBeat.i(190406);
    if (this.ckh.El() == null)
    {
      AppMethodBeat.o(190406);
      return null;
    }
    String[] arrayOfString = ((c)this.ckh.El()).getAsyncableJsApis();
    AppMethodBeat.o(190406);
    return arrayOfString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.luggage.game.d.a.a.a.5
 * JD-Core Version:    0.7.0.1
 */