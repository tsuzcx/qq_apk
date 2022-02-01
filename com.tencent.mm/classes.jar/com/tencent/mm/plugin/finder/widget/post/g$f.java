package com.tencent.mm.plugin.finder.widget.post;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.upload.e;
import com.tencent.mm.protocal.protobuf.brc;
import com.tencent.mm.protocal.protobuf.dqk;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.vfs.i;
import d.a.j;
import d.g.b.k;
import d.g.b.v.a;
import d.l;
import java.util.ArrayList;
import java.util.Iterator;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
final class g$f
  implements Runnable
{
  g$f(g paramg, ArrayList paramArrayList) {}
  
  public final void run()
  {
    AppMethodBeat.i(204888);
    Object localObject1 = this.siV.siN;
    if (localObject1 == null) {
      k.fOy();
    }
    Iterator localIterator = ((Iterable)localObject1).iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      localObject1 = localIterator.next();
      if (i < 0) {
        j.fOc();
      }
      localObject1 = (String)localObject1;
      v.a locala = new v.a();
      boolean bool;
      if (i == 0)
      {
        bool = true;
        label78:
        locala.KUL = bool;
        if ((this.siL == null) || (this.siL.size() <= i) || (bs.isNullOrNil((String)this.siL.get(i)))) {
          break label256;
        }
        localObject1 = (String)this.siL.get(i);
      }
      for (;;)
      {
        Object localObject2;
        if ((locala.KUL) && (!bs.isNullOrNil(g.b(this.siV))) && (i.eA(g.b(this.siV))))
        {
          localObject2 = f.decodeFile(g.b(this.siV));
          if (localObject2 != null)
          {
            ap.f((Runnable)new g.f.a((Bitmap)localObject2, locala, this));
            locala.KUL = false;
          }
        }
        if (!bs.isNullOrNil((String)localObject1))
        {
          localObject2 = f.decodeFile((String)localObject1);
          if (localObject2 != null) {
            ap.f((Runnable)new g.f.b((String)localObject1, i, locala, (Bitmap)localObject2, this));
          }
        }
        i += 1;
        break;
        bool = false;
        break label78;
        label256:
        if ((this.siV.siO.size() > i) && (this.siV.siO.get(i) != null))
        {
          localObject2 = e.rMX;
          localObject2 = this.siV.siO.get(i);
          if (localObject2 == null) {
            k.fOy();
          }
          localObject2 = ((brc)localObject2).Fgl;
          k.g(localObject2, "cropInfoList[index]!!.thumbRect");
          localObject1 = e.a((String)localObject1, (dqk)localObject2);
        }
        else
        {
          localObject2 = g.siT;
          ac.w(g.access$getTAG$cp(), "no thumb & no thumbRect");
          localObject2 = e.rMX;
          localObject1 = e.aeq((String)localObject1);
        }
      }
    }
    AppMethodBeat.o(204888);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.widget.post.g.f
 * JD-Core Version:    0.7.0.1
 */