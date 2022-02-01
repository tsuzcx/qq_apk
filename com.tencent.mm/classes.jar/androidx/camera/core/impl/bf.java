package androidx.camera.core.impl;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class bf
{
  public final List<bg> Np;
  
  public bf()
  {
    AppMethodBeat.i(198803);
    this.Np = new ArrayList();
    AppMethodBeat.o(198803);
  }
  
  public static void a(List<int[]> paramList, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    AppMethodBeat.i(198812);
    if (paramInt2 >= paramArrayOfInt.length)
    {
      paramList.add((int[])paramArrayOfInt.clone());
      AppMethodBeat.o(198812);
      return;
    }
    int i = 0;
    if (i < paramInt1)
    {
      j = 0;
      label43:
      if (j >= paramInt2) {
        break label104;
      }
      if (i != paramArrayOfInt[j]) {}
    }
    label104:
    for (int j = 1;; j = 0)
    {
      if (j == 0)
      {
        paramArrayOfInt[paramInt2] = i;
        a(paramList, paramInt1, paramArrayOfInt, paramInt2 + 1);
      }
      i += 1;
      break;
      j += 1;
      break label43;
      AppMethodBeat.o(198812);
      return;
    }
  }
  
  public final boolean a(bg parambg)
  {
    AppMethodBeat.i(198821);
    boolean bool = this.Np.add(parambg);
    AppMethodBeat.o(198821);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.impl.bf
 * JD-Core Version:    0.7.0.1
 */