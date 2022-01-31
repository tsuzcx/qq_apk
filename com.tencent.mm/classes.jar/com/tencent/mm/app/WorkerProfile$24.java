package com.tencent.mm.app;

import android.content.Context;
import com.tencent.mm.n.a.a;
import java.util.HashMap;
import java.util.Map;

final class WorkerProfile$24
  implements a.a
{
  final Map<String, Integer> bxS = new HashMap();
  final Map<String, Integer> map = new HashMap();
  
  WorkerProfile$24(Context paramContext) {}
  
  public final String cx(String paramString)
  {
    if (this.map.containsKey(paramString)) {
      return this.val$context.getString(((Integer)this.map.get(paramString)).intValue());
    }
    return null;
  }
  
  public final String cy(String paramString)
  {
    if (this.bxS.containsKey(paramString)) {
      return this.val$context.getString(((Integer)this.bxS.get(paramString)).intValue());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.WorkerProfile.24
 * JD-Core Version:    0.7.0.1
 */