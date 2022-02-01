package androidx.recyclerview.widget;

import android.graphics.PointF;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class q
  extends z
{
  private u ajA;
  private u ajz;
  
  private static int a(RecyclerView.LayoutManager paramLayoutManager, View paramView, u paramu)
  {
    AppMethodBeat.i(261898);
    int j = paramu.aZ(paramView);
    int k = paramu.bd(paramView) / 2;
    if (paramLayoutManager.getClipToPadding()) {}
    for (int i = paramu.kT() + paramu.kV() / 2;; i = paramu.getEnd() / 2)
    {
      AppMethodBeat.o(261898);
      return k + j - i;
    }
  }
  
  private int a(RecyclerView.LayoutManager paramLayoutManager, u paramu, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(261899);
    int[] arrayOfInt = aO(paramInt1, paramInt2);
    float f = b(paramLayoutManager, paramu);
    if (f <= 0.0F)
    {
      AppMethodBeat.o(261899);
      return 0;
    }
    if (Math.abs(arrayOfInt[0]) > Math.abs(arrayOfInt[1])) {}
    for (paramInt1 = arrayOfInt[0];; paramInt1 = arrayOfInt[1])
    {
      paramInt1 = Math.round(paramInt1 / f);
      AppMethodBeat.o(261899);
      return paramInt1;
    }
  }
  
  private static View a(RecyclerView.LayoutManager paramLayoutManager, u paramu)
  {
    Object localObject = null;
    AppMethodBeat.i(261901);
    int n = paramLayoutManager.getChildCount();
    if (n == 0)
    {
      AppMethodBeat.o(261901);
      return null;
    }
    int j;
    int k;
    if (paramLayoutManager.getClipToPadding())
    {
      j = paramu.kT() + paramu.kV() / 2;
      int i = 2147483647;
      k = 0;
      label51:
      if (k >= n) {
        break label120;
      }
      View localView = paramLayoutManager.getChildAt(k);
      int m = Math.abs(paramu.aZ(localView) + paramu.bd(localView) / 2 - j);
      if (m >= i) {
        break label128;
      }
      localObject = localView;
      i = m;
    }
    label128:
    for (;;)
    {
      k += 1;
      break label51;
      j = paramu.getEnd() / 2;
      break;
      label120:
      AppMethodBeat.o(261901);
      return localObject;
    }
  }
  
  private static float b(RecyclerView.LayoutManager paramLayoutManager, u paramu)
  {
    AppMethodBeat.i(261902);
    int i = 2147483647;
    int k = -2147483648;
    int i2 = paramLayoutManager.getChildCount();
    if (i2 == 0)
    {
      AppMethodBeat.o(261902);
      return 1.0F;
    }
    int n = 0;
    Object localObject2 = null;
    Object localObject1 = null;
    int m;
    Object localObject3;
    int j;
    if (n < i2)
    {
      View localView = paramLayoutManager.getChildAt(n);
      int i1 = paramLayoutManager.getPosition(localView);
      m = i;
      localObject3 = localObject1;
      if (i1 == -1) {
        break label218;
      }
      j = i;
      if (i1 < i)
      {
        j = i1;
        localObject1 = localView;
      }
      m = j;
      localObject3 = localObject1;
      if (i1 <= k) {
        break label218;
      }
      localObject2 = localView;
      i = j;
      j = i1;
    }
    for (;;)
    {
      n += 1;
      k = j;
      break;
      if ((localObject1 == null) || (localObject2 == null))
      {
        AppMethodBeat.o(261902);
        return 1.0F;
      }
      j = Math.min(paramu.aZ(localObject1), paramu.aZ(localObject2));
      j = Math.max(paramu.ba(localObject1), paramu.ba(localObject2)) - j;
      if (j == 0)
      {
        AppMethodBeat.o(261902);
        return 1.0F;
      }
      float f = j * 1.0F / (k - i + 1);
      AppMethodBeat.o(261902);
      return f;
      label218:
      j = k;
      i = m;
      localObject1 = localObject3;
    }
  }
  
  private u b(RecyclerView.LayoutManager paramLayoutManager)
  {
    AppMethodBeat.i(261904);
    if ((this.ajz == null) || (this.ajz.ajD != paramLayoutManager)) {
      this.ajz = u.e(paramLayoutManager);
    }
    paramLayoutManager = this.ajz;
    AppMethodBeat.o(261904);
    return paramLayoutManager;
  }
  
  private u c(RecyclerView.LayoutManager paramLayoutManager)
  {
    AppMethodBeat.i(261906);
    if ((this.ajA == null) || (this.ajA.ajD != paramLayoutManager)) {
      this.ajA = u.d(paramLayoutManager);
    }
    paramLayoutManager = this.ajA;
    AppMethodBeat.o(261906);
    return paramLayoutManager;
  }
  
  public int a(RecyclerView.LayoutManager paramLayoutManager, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(261894);
    if (!(paramLayoutManager instanceof RecyclerView.r.b))
    {
      AppMethodBeat.o(261894);
      return -1;
    }
    int j = paramLayoutManager.getItemCount();
    if (j == 0)
    {
      AppMethodBeat.o(261894);
      return -1;
    }
    Object localObject = a(paramLayoutManager);
    if (localObject == null)
    {
      AppMethodBeat.o(261894);
      return -1;
    }
    int k = paramLayoutManager.getPosition((View)localObject);
    if (k == -1)
    {
      AppMethodBeat.o(261894);
      return -1;
    }
    localObject = ((RecyclerView.r.b)paramLayoutManager).cB(j - 1);
    if (localObject == null)
    {
      AppMethodBeat.o(261894);
      return -1;
    }
    if (paramLayoutManager.canScrollHorizontally())
    {
      int i = a(paramLayoutManager, c(paramLayoutManager), paramInt1, 0);
      paramInt1 = i;
      if (((PointF)localObject).x < 0.0F) {
        paramInt1 = -i;
      }
      if (!paramLayoutManager.canScrollVertically()) {
        break label203;
      }
      i = a(paramLayoutManager, b(paramLayoutManager), 0, paramInt2);
      paramInt2 = i;
      if (((PointF)localObject).y < 0.0F) {
        paramInt2 = -i;
      }
      label180:
      if (!paramLayoutManager.canScrollVertically()) {
        break label208;
      }
    }
    for (;;)
    {
      if (paramInt2 != 0) {
        break label213;
      }
      AppMethodBeat.o(261894);
      return -1;
      paramInt1 = 0;
      break;
      label203:
      paramInt2 = 0;
      break label180;
      label208:
      paramInt2 = paramInt1;
    }
    label213:
    paramInt2 = k + paramInt2;
    paramInt1 = paramInt2;
    if (paramInt2 < 0) {
      paramInt1 = 0;
    }
    paramInt2 = paramInt1;
    if (paramInt1 >= j) {
      paramInt2 = j - 1;
    }
    AppMethodBeat.o(261894);
    return paramInt2;
  }
  
  public View a(RecyclerView.LayoutManager paramLayoutManager)
  {
    AppMethodBeat.i(261897);
    if (paramLayoutManager.canScrollVertically())
    {
      paramLayoutManager = a(paramLayoutManager, b(paramLayoutManager));
      AppMethodBeat.o(261897);
      return paramLayoutManager;
    }
    if (paramLayoutManager.canScrollHorizontally())
    {
      paramLayoutManager = a(paramLayoutManager, c(paramLayoutManager));
      AppMethodBeat.o(261897);
      return paramLayoutManager;
    }
    AppMethodBeat.o(261897);
    return null;
  }
  
  public int[] a(RecyclerView.LayoutManager paramLayoutManager, View paramView)
  {
    AppMethodBeat.i(261891);
    int[] arrayOfInt = new int[2];
    if (paramLayoutManager.canScrollHorizontally())
    {
      arrayOfInt[0] = a(paramLayoutManager, paramView, c(paramLayoutManager));
      if (!paramLayoutManager.canScrollVertically()) {
        break label63;
      }
      arrayOfInt[1] = a(paramLayoutManager, paramView, b(paramLayoutManager));
    }
    for (;;)
    {
      AppMethodBeat.o(261891);
      return arrayOfInt;
      arrayOfInt[0] = 0;
      break;
      label63:
      arrayOfInt[1] = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.recyclerview.widget.q
 * JD-Core Version:    0.7.0.1
 */