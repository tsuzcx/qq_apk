package com.tencent.mm.mj_template.maas.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/maas/record/FrameCache;", "", "()V", "index", "", "pool", "Ljava/util/ArrayList;", "Ljava/nio/ByteBuffer;", "Lkotlin/collections/ArrayList;", "checkInit", "", "size", "nextFrame", "reset", "Companion", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d.a obk;
  private int index;
  private ArrayList<ByteBuffer> obl;
  
  static
  {
    AppMethodBeat.i(239986);
    obk = new d.a((byte)0);
    AppMethodBeat.o(239986);
  }
  
  public d()
  {
    AppMethodBeat.i(239980);
    this.obl = new ArrayList();
    AppMethodBeat.o(239980);
  }
  
  public final ByteBuffer bxF()
  {
    AppMethodBeat.i(240002);
    Object localObject = this.obl;
    int i = this.index;
    this.index = (i + 1);
    localObject = ((ArrayList)localObject).get(i % this.obl.size());
    s.s(localObject, "pool[index++ % pool.size]");
    ((ByteBuffer)localObject).clear();
    localObject = (ByteBuffer)localObject;
    AppMethodBeat.o(240002);
    return localObject;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(240012);
    this.obl.clear();
    this.index = 0;
    AppMethodBeat.o(240012);
  }
  
  public final void uJ(int paramInt)
  {
    AppMethodBeat.i(239994);
    Object localObject = (ByteBuffer)p.oL((List)this.obl);
    int i;
    if ((localObject != null) && (((ByteBuffer)localObject).capacity() == paramInt)) {
      i = 1;
    }
    while (i == 0)
    {
      localObject = ((Iterable)this.obl).iterator();
      for (;;)
      {
        if (((Iterator)localObject).hasNext())
        {
          ((ByteBuffer)((Iterator)localObject).next()).clear();
          continue;
          i = 0;
          break;
        }
      }
      this.obl.clear();
      i = 0;
      int j;
      do
      {
        j = i + 1;
        this.obl.add(ByteBuffer.allocateDirect(paramInt));
        i = j;
      } while (j <= 1);
    }
    AppMethodBeat.o(239994);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.mj_template.maas.a.d
 * JD-Core Version:    0.7.0.1
 */