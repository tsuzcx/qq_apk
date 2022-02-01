package com.tencent.mm.app;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.contact.c.a;
import java.util.HashMap;
import java.util.Map;

final class WorkerProfile$26
  implements c.a
{
  final Map<String, Integer> dnE;
  final Map<String, Integer> map;
  
  WorkerProfile$26(Context paramContext)
  {
    AppMethodBeat.i(19579);
    this.map = new HashMap();
    this.dnE = new HashMap();
    AppMethodBeat.o(19579);
  }
  
  public final String gu(String paramString)
  {
    AppMethodBeat.i(19580);
    if (this.map.containsKey(paramString))
    {
      paramString = this.val$context.getString(((Integer)this.map.get(paramString)).intValue());
      AppMethodBeat.o(19580);
      return paramString;
    }
    AppMethodBeat.o(19580);
    return null;
  }
  
  public final String gv(String paramString)
  {
    AppMethodBeat.i(19581);
    if (this.dnE.containsKey(paramString))
    {
      paramString = this.val$context.getString(((Integer)this.dnE.get(paramString)).intValue());
      AppMethodBeat.o(19581);
      return paramString;
    }
    AppMethodBeat.o(19581);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.WorkerProfile.26
 * JD-Core Version:    0.7.0.1
 */