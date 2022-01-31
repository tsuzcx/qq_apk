package com.tencent.mm.d.a;

import com.eclipsesource.v8.JavaVoidCallback;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public class t
{
  private final AtomicInteger ccu;
  public final HashMap<Integer, l> ccv;
  u ccw;
  private f ccx;
  
  public t(u paramu)
  {
    AppMethodBeat.i(113897);
    this.ccu = new AtomicInteger(0);
    this.ccv = new HashMap();
    this.ccx = new t.4(this);
    this.ccw = paramu;
    AppMethodBeat.o(113897);
  }
  
  protected void a(l paraml, t.a parama)
  {
    AppMethodBeat.i(113899);
    ab.i("MicroMsg.V8EngineWorkerManager", "hy: evaluating %s", new Object[] { parama.filePath });
    paraml.a(parama.filePath, parama.script, null);
    AppMethodBeat.o(113899);
  }
  
  public final int d(ArrayList<t.a> paramArrayList)
  {
    AppMethodBeat.i(113898);
    final int j = this.ccu.addAndGet(1);
    Object localObject1 = v.Cw();
    ((a)localObject1).cbf = this.ccx;
    localObject1 = ((v)localObject1).gg(1);
    Object localObject2 = new JavaVoidCallback()
    {
      public final void invoke(V8Object paramAnonymousV8Object, V8Array paramAnonymousV8Array)
      {
        AppMethodBeat.i(113892);
        if ((paramAnonymousV8Array.length() <= 0) || (paramAnonymousV8Array.getType(0) != 4))
        {
          AppMethodBeat.o(113892);
          return;
        }
        t.this.ccw.l(j, paramAnonymousV8Array.getString(0));
        AppMethodBeat.o(113892);
      }
    };
    ((l)localObject1).cbC.k(new l.11((l)localObject1, (JavaVoidCallback)localObject2, "postMessage"));
    ((l)localObject1).a(1, new t.1(this, (l)localObject1));
    paramArrayList = paramArrayList.iterator();
    label158:
    while (paramArrayList.hasNext())
    {
      localObject2 = (t.a)paramArrayList.next();
      if (localObject2 != null)
      {
        if ((!bo.isNullOrNil(((t.a)localObject2).script)) || (!bo.isNullOrNil(((t.a)localObject2).filePath))) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label158;
          }
          a((l)localObject1, (t.a)localObject2);
          break;
        }
      }
    }
    this.ccv.put(Integer.valueOf(j), localObject1);
    AppMethodBeat.o(113898);
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.d.a.t
 * JD-Core Version:    0.7.0.1
 */