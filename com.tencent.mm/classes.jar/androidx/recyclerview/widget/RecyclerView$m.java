package androidx.recyclerview.widget;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class RecyclerView$m
{
  SparseArray<RecyclerView.m.a> bZR;
  int bZS;
  
  public RecyclerView$m()
  {
    AppMethodBeat.i(194994);
    this.bZR = new SparseArray();
    this.bZS = 0;
    AppMethodBeat.o(194994);
  }
  
  static long v(long paramLong1, long paramLong2)
  {
    if (paramLong1 == 0L) {
      return paramLong2;
    }
    return paramLong1 / 4L * 3L + paramLong2 / 4L;
  }
  
  final boolean b(int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(195036);
    long l = fZ(paramInt).bZV;
    if ((l == 0L) || (l + paramLong1 < paramLong2))
    {
      AppMethodBeat.o(195036);
      return true;
    }
    AppMethodBeat.o(195036);
    return false;
  }
  
  public final void bD(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(195015);
    Object localObject = fZ(paramInt1);
    ((RecyclerView.m.a)localObject).bZU = paramInt2;
    localObject = ((RecyclerView.m.a)localObject).bZT;
    while (((ArrayList)localObject).size() > paramInt2) {
      ((ArrayList)localObject).remove(((ArrayList)localObject).size() - 1);
    }
    AppMethodBeat.o(195015);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(195008);
    int i = 0;
    while (i < this.bZR.size())
    {
      ((RecyclerView.m.a)this.bZR.valueAt(i)).bZT.clear();
      i += 1;
    }
    AppMethodBeat.o(195008);
  }
  
  final void d(int paramInt, long paramLong)
  {
    AppMethodBeat.i(195030);
    RecyclerView.m.a locala = fZ(paramInt);
    locala.bZV = v(locala.bZV, paramLong);
    AppMethodBeat.o(195030);
  }
  
  final void detach()
  {
    this.bZS -= 1;
  }
  
  public RecyclerView.v fY(int paramInt)
  {
    AppMethodBeat.i(195021);
    Object localObject = (RecyclerView.m.a)this.bZR.get(paramInt);
    if ((localObject != null) && (!((RecyclerView.m.a)localObject).bZT.isEmpty()))
    {
      localObject = ((RecyclerView.m.a)localObject).bZT;
      localObject = (RecyclerView.v)((ArrayList)localObject).remove(((ArrayList)localObject).size() - 1);
      AppMethodBeat.o(195021);
      return localObject;
    }
    AppMethodBeat.o(195021);
    return null;
  }
  
  final RecyclerView.m.a fZ(int paramInt)
  {
    AppMethodBeat.i(195049);
    RecyclerView.m.a locala2 = (RecyclerView.m.a)this.bZR.get(paramInt);
    RecyclerView.m.a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new RecyclerView.m.a();
      this.bZR.put(paramInt, locala1);
    }
    AppMethodBeat.o(195049);
    return locala1;
  }
  
  public void u(RecyclerView.v paramv)
  {
    AppMethodBeat.i(195027);
    int i = paramv.caO;
    ArrayList localArrayList = fZ(i).bZT;
    if (((RecyclerView.m.a)this.bZR.get(i)).bZU <= localArrayList.size())
    {
      AppMethodBeat.o(195027);
      return;
    }
    paramv.resetInternal();
    localArrayList.add(paramv);
    AppMethodBeat.o(195027);
  }
  
  final void vX()
  {
    this.bZS += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.recyclerview.widget.RecyclerView.m
 * JD-Core Version:    0.7.0.1
 */