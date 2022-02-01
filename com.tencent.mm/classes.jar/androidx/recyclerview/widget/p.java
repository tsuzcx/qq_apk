package androidx.recyclerview.widget;

import android.graphics.PointF;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class p
  extends x
{
  private s bYd;
  private s bYe;
  
  private static int a(RecyclerView.LayoutManager paramLayoutManager, View paramView, s params)
  {
    AppMethodBeat.i(194862);
    int j = params.bs(paramView);
    int k = params.bw(paramView) / 2;
    if (paramLayoutManager.getClipToPadding()) {}
    for (int i = params.JE() + params.JG() / 2;; i = params.getEnd() / 2)
    {
      AppMethodBeat.o(194862);
      return k + j - i;
    }
  }
  
  private int a(RecyclerView.LayoutManager paramLayoutManager, s params, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194871);
    int[] arrayOfInt = bI(paramInt1, paramInt2);
    float f = b(paramLayoutManager, params);
    if (f <= 0.0F)
    {
      AppMethodBeat.o(194871);
      return 0;
    }
    if (Math.abs(arrayOfInt[0]) > Math.abs(arrayOfInt[1])) {}
    for (paramInt1 = arrayOfInt[0];; paramInt1 = arrayOfInt[1])
    {
      paramInt1 = Math.round(paramInt1 / f);
      AppMethodBeat.o(194871);
      return paramInt1;
    }
  }
  
  private static View a(RecyclerView.LayoutManager paramLayoutManager, s params)
  {
    Object localObject = null;
    AppMethodBeat.i(194884);
    int n = paramLayoutManager.getChildCount();
    if (n == 0)
    {
      AppMethodBeat.o(194884);
      return null;
    }
    int j;
    int k;
    if (paramLayoutManager.getClipToPadding())
    {
      j = params.JE() + params.JG() / 2;
      int i = 2147483647;
      k = 0;
      label51:
      if (k >= n) {
        break label120;
      }
      View localView = paramLayoutManager.getChildAt(k);
      int m = Math.abs(params.bs(localView) + params.bw(localView) / 2 - j);
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
      j = params.getEnd() / 2;
      break;
      label120:
      AppMethodBeat.o(194884);
      return localObject;
    }
  }
  
  private static float b(RecyclerView.LayoutManager paramLayoutManager, s params)
  {
    AppMethodBeat.i(194890);
    int i = 2147483647;
    int k = -2147483648;
    int i2 = paramLayoutManager.getChildCount();
    if (i2 == 0)
    {
      AppMethodBeat.o(194890);
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
        AppMethodBeat.o(194890);
        return 1.0F;
      }
      j = Math.min(params.bs(localObject1), params.bs(localObject2));
      j = Math.max(params.bt(localObject1), params.bt(localObject2)) - j;
      if (j == 0)
      {
        AppMethodBeat.o(194890);
        return 1.0F;
      }
      float f = j * 1.0F / (k - i + 1);
      AppMethodBeat.o(194890);
      return f;
      label218:
      j = k;
      i = m;
      localObject1 = localObject3;
    }
  }
  
  private s b(RecyclerView.LayoutManager paramLayoutManager)
  {
    AppMethodBeat.i(194895);
    if ((this.bYd == null) || (this.bYd.bYg != paramLayoutManager)) {
      this.bYd = s.e(paramLayoutManager);
    }
    paramLayoutManager = this.bYd;
    AppMethodBeat.o(194895);
    return paramLayoutManager;
  }
  
  private s c(RecyclerView.LayoutManager paramLayoutManager)
  {
    AppMethodBeat.i(194902);
    if ((this.bYe == null) || (this.bYe.bYg != paramLayoutManager)) {
      this.bYe = s.d(paramLayoutManager);
    }
    paramLayoutManager = this.bYe;
    AppMethodBeat.o(194902);
    return paramLayoutManager;
  }
  
  public int a(RecyclerView.LayoutManager paramLayoutManager, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194924);
    if (!(paramLayoutManager instanceof RecyclerView.r.b))
    {
      AppMethodBeat.o(194924);
      return -1;
    }
    int j = paramLayoutManager.getItemCount();
    if (j == 0)
    {
      AppMethodBeat.o(194924);
      return -1;
    }
    Object localObject = a(paramLayoutManager);
    if (localObject == null)
    {
      AppMethodBeat.o(194924);
      return -1;
    }
    int k = paramLayoutManager.getPosition((View)localObject);
    if (k == -1)
    {
      AppMethodBeat.o(194924);
      return -1;
    }
    localObject = ((RecyclerView.r.b)paramLayoutManager).fM(j - 1);
    if (localObject == null)
    {
      AppMethodBeat.o(194924);
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
      AppMethodBeat.o(194924);
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
    AppMethodBeat.o(194924);
    return paramInt2;
  }
  
  public View a(RecyclerView.LayoutManager paramLayoutManager)
  {
    AppMethodBeat.i(194931);
    if (paramLayoutManager.canScrollVertically())
    {
      paramLayoutManager = a(paramLayoutManager, b(paramLayoutManager));
      AppMethodBeat.o(194931);
      return paramLayoutManager;
    }
    if (paramLayoutManager.canScrollHorizontally())
    {
      paramLayoutManager = a(paramLayoutManager, c(paramLayoutManager));
      AppMethodBeat.o(194931);
      return paramLayoutManager;
    }
    AppMethodBeat.o(194931);
    return null;
  }
  
  public int[] a(RecyclerView.LayoutManager paramLayoutManager, View paramView)
  {
    AppMethodBeat.i(194913);
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
      AppMethodBeat.o(194913);
      return arrayOfInt;
      arrayOfInt[0] = 0;
      break;
      label63:
      arrayOfInt[1] = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.recyclerview.widget.p
 * JD-Core Version:    0.7.0.1
 */