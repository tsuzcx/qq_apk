package a.a;

import a.i.d;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/collections/ReversedList;", "T", "Lkotlin/collections/AbstractMutableList;", "delegate", "", "(Ljava/util/List;)V", "size", "", "getSize", "()I", "add", "", "index", "element", "(ILjava/lang/Object;)V", "clear", "get", "(I)Ljava/lang/Object;", "removeAt", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"})
public final class ai<T>
  extends c<T>
{
  private final List<T> BMC;
  
  public ai(List<T> paramList)
  {
    AppMethodBeat.i(56036);
    this.BMC = paramList;
    AppMethodBeat.o(56036);
  }
  
  public final void add(int paramInt, T paramT)
  {
    AppMethodBeat.i(56035);
    List localList = this.BMC;
    int i = size();
    if (paramInt < 0) {}
    while (i < paramInt)
    {
      paramT = (Throwable)new IndexOutOfBoundsException("Position index " + paramInt + " must be in range [" + new d(0, size()) + "].");
      AppMethodBeat.o(56035);
      throw paramT;
    }
    localList.add(size() - paramInt, paramT);
    AppMethodBeat.o(56035);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(56032);
    this.BMC.clear();
    AppMethodBeat.o(56032);
  }
  
  public final T get(int paramInt)
  {
    AppMethodBeat.i(56031);
    Object localObject = this.BMC.get(r.v(this, paramInt));
    AppMethodBeat.o(56031);
    return localObject;
  }
  
  public final int getSize()
  {
    AppMethodBeat.i(56030);
    int i = this.BMC.size();
    AppMethodBeat.o(56030);
    return i;
  }
  
  public final T removeAt(int paramInt)
  {
    AppMethodBeat.i(56033);
    Object localObject = this.BMC.remove(r.v(this, paramInt));
    AppMethodBeat.o(56033);
    return localObject;
  }
  
  public final T set(int paramInt, T paramT)
  {
    AppMethodBeat.i(56034);
    paramT = this.BMC.set(r.v(this, paramInt), paramT);
    AppMethodBeat.o(56034);
    return paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     a.a.ai
 * JD-Core Version:    0.7.0.1
 */