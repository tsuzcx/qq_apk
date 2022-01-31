package com.tencent.mm.app;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.n.a.a;
import java.util.HashMap;
import java.util.Map;

final class WorkerProfile$27
  implements a.a
{
  final Map<String, Integer> bZU;
  final Map<String, Integer> map;
  
  WorkerProfile$27(Context paramContext)
  {
    AppMethodBeat.i(138597);
    this.map = new HashMap();
    this.bZU = new HashMap();
    AppMethodBeat.o(138597);
  }
  
  public final String dK(String paramString)
  {
    AppMethodBeat.i(138598);
    if (this.map.containsKey(paramString))
    {
      paramString = this.val$context.getString(((Integer)this.map.get(paramString)).intValue());
      AppMethodBeat.o(138598);
      return paramString;
    }
    AppMethodBeat.o(138598);
    return null;
  }
  
  public final String dL(String paramString)
  {
    AppMethodBeat.i(138599);
    if (this.bZU.containsKey(paramString))
    {
      paramString = this.val$context.getString(((Integer)this.bZU.get(paramString)).intValue());
      AppMethodBeat.o(138599);
      return paramString;
    }
    AppMethodBeat.o(138599);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.app.WorkerProfile.27
 * JD-Core Version:    0.7.0.1
 */