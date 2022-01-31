package com.tencent.mm.d.a;

import com.eclipsesource.v8.JavaVoidCallback;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public class i
{
  private final AtomicInteger bzF = new AtomicInteger(0);
  public final HashMap<Integer, b> bzG = new HashMap();
  j bzH;
  private k bzI;
  private a bzJ = new i.4(this);
  
  public i(j paramj)
  {
    this.bzH = paramj;
  }
  
  public void a(b paramb, i.a parama)
  {
    y.i("MicroMsg.V8EngineWorkerManager", "hy: evaluating %s", new Object[] { parama.filePath });
    paramb.a(parama.filePath, parama.script, null);
  }
  
  public final int d(ArrayList<i.a> paramArrayList)
  {
    int j = this.bzF.addAndGet(1);
    this.bzI = k.tF();
    this.bzI.byZ = this.bzJ;
    b localb = this.bzI.ev(1);
    Object localObject = new i.2(this, j);
    localb.byY.i(new b.5(localb, (JavaVoidCallback)localObject, "postMessage"));
    localb.a(1, new i.1(this, localb));
    paramArrayList = paramArrayList.iterator();
    label157:
    while (paramArrayList.hasNext())
    {
      localObject = (i.a)paramArrayList.next();
      if (localObject != null)
      {
        if ((!bk.bl(((i.a)localObject).script)) || (!bk.bl(((i.a)localObject).filePath))) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label157;
          }
          a(localb, (i.a)localObject);
          break;
        }
      }
    }
    this.bzG.put(Integer.valueOf(j), localb);
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.d.a.i
 * JD-Core Version:    0.7.0.1
 */