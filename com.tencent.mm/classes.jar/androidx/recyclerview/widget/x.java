package androidx.recyclerview.widget;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class x
{
  static int a(RecyclerView.s params, u paramu, View paramView1, View paramView2, RecyclerView.LayoutManager paramLayoutManager, boolean paramBoolean)
  {
    AppMethodBeat.i(262769);
    if ((paramLayoutManager.getChildCount() == 0) || (params.getItemCount() == 0) || (paramView1 == null) || (paramView2 == null))
    {
      AppMethodBeat.o(262769);
      return 0;
    }
    if (!paramBoolean)
    {
      i = Math.abs(paramLayoutManager.getPosition(paramView1) - paramLayoutManager.getPosition(paramView2));
      AppMethodBeat.o(262769);
      return i + 1;
    }
    int i = paramu.ba(paramView2);
    int j = paramu.aZ(paramView1);
    i = Math.min(paramu.kV(), i - j);
    AppMethodBeat.o(262769);
    return i;
  }
  
  static int a(RecyclerView.s params, u paramu, View paramView1, View paramView2, RecyclerView.LayoutManager paramLayoutManager, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(262768);
    if ((paramLayoutManager.getChildCount() == 0) || (params.getItemCount() == 0) || (paramView1 == null) || (paramView2 == null))
    {
      AppMethodBeat.o(262768);
      return 0;
    }
    int i = Math.min(paramLayoutManager.getPosition(paramView1), paramLayoutManager.getPosition(paramView2));
    int j = Math.max(paramLayoutManager.getPosition(paramView1), paramLayoutManager.getPosition(paramView2));
    if (paramBoolean2) {}
    for (i = Math.max(0, params.getItemCount() - j - 1); !paramBoolean1; i = Math.max(0, i))
    {
      AppMethodBeat.o(262768);
      return i;
    }
    j = Math.abs(paramu.ba(paramView2) - paramu.aZ(paramView1));
    int k = Math.abs(paramLayoutManager.getPosition(paramView1) - paramLayoutManager.getPosition(paramView2));
    float f = j / (k + 1);
    i = Math.round(i * f + (paramu.kT() - paramu.aZ(paramView1)));
    AppMethodBeat.o(262768);
    return i;
  }
  
  static int b(RecyclerView.s params, u paramu, View paramView1, View paramView2, RecyclerView.LayoutManager paramLayoutManager, boolean paramBoolean)
  {
    AppMethodBeat.i(262770);
    if ((paramLayoutManager.getChildCount() == 0) || (params.getItemCount() == 0) || (paramView1 == null) || (paramView2 == null))
    {
      AppMethodBeat.o(262770);
      return 0;
    }
    if (!paramBoolean)
    {
      i = params.getItemCount();
      AppMethodBeat.o(262770);
      return i;
    }
    int i = paramu.ba(paramView2);
    int j = paramu.aZ(paramView1);
    int k = Math.abs(paramLayoutManager.getPosition(paramView1) - paramLayoutManager.getPosition(paramView2));
    i = (int)((i - j) / (k + 1) * params.getItemCount());
    AppMethodBeat.o(262770);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.recyclerview.widget.x
 * JD-Core Version:    0.7.0.1
 */