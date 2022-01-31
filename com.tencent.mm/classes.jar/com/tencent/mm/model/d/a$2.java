package com.tencent.mm.model.d;

import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.al.b;
import java.util.Iterator;
import java.util.LinkedList;

public final class a$2
  implements al.b
{
  public a$2(a parama) {}
  
  public final String Jf()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("worker thread id = " + au.DS().mnU.getLooper().getThread().getId() + "[" + au.DS().crd() + "]\n");
    localStringBuilder.append("#cpu freq(KHz)[max=" + m.yS() + ", min=" + m.yT() + ", cur=" + m.yU() + "]\n");
    Object localObject = new LinkedList(a.d(this.dZq));
    Iterator localIterator = ((LinkedList)localObject).iterator();
    localStringBuilder.append("#done tasks size = " + ((LinkedList)localObject).size() + '\n');
    if (localIterator != null)
    {
      int i = 0;
      while ((localIterator.hasNext()) && (i < a.j(this.dZq)))
      {
        localObject = (a.a)localIterator.next();
        localStringBuilder.append("[index = " + i + " | taskinfo:" + ((a.a)localObject).info + "]\n");
        i += 1;
      }
    }
    localStringBuilder.append("\n#waiting" + au.DS().crf().dump(false));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.d.a.2
 * JD-Core Version:    0.7.0.1
 */