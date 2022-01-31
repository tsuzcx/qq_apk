package a.j.b.a.c.e.a;

import a.j.b.a.c.e.a.w;
import a.j.b.a.c.e.a.w.b;
import a.j.b.a.c.e.a.w.b.b;
import a.j.b.a.c.e.a.y;
import a.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.List;

public final class d
  implements c
{
  private final a.y CoU;
  private final a.w CoV;
  
  public d(a.y paramy, a.w paramw)
  {
    AppMethodBeat.i(121080);
    this.CoU = paramy;
    this.CoV = paramw;
    AppMethodBeat.o(121080);
  }
  
  private final t<List<String>, List<String>, Boolean> Vr(int paramInt)
  {
    AppMethodBeat.i(121079);
    Object localObject1 = new LinkedList();
    LinkedList localLinkedList = new LinkedList();
    boolean bool = false;
    if (paramInt != -1)
    {
      a.w.b localb = this.CoV.UG(paramInt);
      Object localObject2 = this.CoU;
      a.f.b.j.p(localb, "proto");
      localObject2 = ((a.y)localObject2).getString(localb.CmF);
      a.w.b.b localb1 = localb.CmG;
      if (localb1 == null) {
        a.f.b.j.ebi();
      }
      switch (e.bLo[localb1.ordinal()])
      {
      }
      for (;;)
      {
        paramInt = localb.CmE;
        break;
        localLinkedList.addFirst(localObject2);
        continue;
        ((LinkedList)localObject1).addFirst(localObject2);
        continue;
        localLinkedList.addFirst(localObject2);
        bool = true;
      }
    }
    localObject1 = new t(localObject1, localLinkedList, Boolean.valueOf(bool));
    AppMethodBeat.o(121079);
    return localObject1;
  }
  
  public final String Vp(int paramInt)
  {
    AppMethodBeat.i(121077);
    Object localObject2 = Vr(paramInt);
    Object localObject1 = (List)((t)localObject2).first;
    localObject2 = a.a.j.a((Iterable)((t)localObject2).second, (CharSequence)".", null, null, 0, null, null, 62);
    if (((List)localObject1).isEmpty())
    {
      AppMethodBeat.o(121077);
      return localObject2;
    }
    localObject1 = a.a.j.a((Iterable)localObject1, (CharSequence)"/", null, null, 0, null, null, 62) + '/' + (String)localObject2;
    AppMethodBeat.o(121077);
    return localObject1;
  }
  
  public final boolean Vq(int paramInt)
  {
    AppMethodBeat.i(121078);
    boolean bool = ((Boolean)Vr(paramInt).BMe).booleanValue();
    AppMethodBeat.o(121078);
    return bool;
  }
  
  public final String getString(int paramInt)
  {
    AppMethodBeat.i(121076);
    String str = this.CoU.getString(paramInt);
    a.f.b.j.p(str, "strings.getString(index)");
    AppMethodBeat.o(121076);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.j.b.a.c.e.a.d
 * JD-Core Version:    0.7.0.1
 */