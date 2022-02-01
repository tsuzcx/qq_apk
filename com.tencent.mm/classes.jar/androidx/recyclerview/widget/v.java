package androidx.recyclerview.widget;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class v
{
  static int a(RecyclerView.s params, s params1, View paramView1, View paramView2, RecyclerView.LayoutManager paramLayoutManager, boolean paramBoolean)
  {
    AppMethodBeat.i(194867);
    if ((paramLayoutManager.getChildCount() == 0) || (params.getItemCount() == 0) || (paramView1 == null) || (paramView2 == null))
    {
      AppMethodBeat.o(194867);
      return 0;
    }
    if (!paramBoolean)
    {
      i = Math.abs(paramLayoutManager.getPosition(paramView1) - paramLayoutManager.getPosition(paramView2));
      AppMethodBeat.o(194867);
      return i + 1;
    }
    int i = params1.bt(paramView2);
    int j = params1.bs(paramView1);
    i = Math.min(params1.JG(), i - j);
    AppMethodBeat.o(194867);
    return i;
  }
  
  static int a(RecyclerView.s params, s params1, View paramView1, View paramView2, RecyclerView.LayoutManager paramLayoutManager, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(194857);
    if ((paramLayoutManager.getChildCount() == 0) || (params.getItemCount() == 0) || (paramView1 == null) || (paramView2 == null))
    {
      AppMethodBeat.o(194857);
      return 0;
    }
    int i = Math.min(paramLayoutManager.getPosition(paramView1), paramLayoutManager.getPosition(paramView2));
    int j = Math.max(paramLayoutManager.getPosition(paramView1), paramLayoutManager.getPosition(paramView2));
    if (paramBoolean2) {}
    for (i = Math.max(0, params.getItemCount() - j - 1); !paramBoolean1; i = Math.max(0, i))
    {
      AppMethodBeat.o(194857);
      return i;
    }
    j = Math.abs(params1.bt(paramView2) - params1.bs(paramView1));
    int k = Math.abs(paramLayoutManager.getPosition(paramView1) - paramLayoutManager.getPosition(paramView2));
    float f = j / (k + 1);
    i = Math.round(i * f + (params1.JE() - params1.bs(paramView1)));
    AppMethodBeat.o(194857);
    return i;
  }
  
  static int b(RecyclerView.s params, s params1, View paramView1, View paramView2, RecyclerView.LayoutManager paramLayoutManager, boolean paramBoolean)
  {
    AppMethodBeat.i(194882);
    if ((paramLayoutManager.getChildCount() == 0) || (params.getItemCount() == 0) || (paramView1 == null) || (paramView2 == null))
    {
      AppMethodBeat.o(194882);
      return 0;
    }
    if (!paramBoolean)
    {
      i = params.getItemCount();
      AppMethodBeat.o(194882);
      return i;
    }
    int i = params1.bt(paramView2);
    int j = params1.bs(paramView1);
    int k = Math.abs(paramLayoutManager.getPosition(paramView1) - paramLayoutManager.getPosition(paramView2));
    i = (int)((i - j) / (k + 1) * params.getItemCount());
    AppMethodBeat.o(194882);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.recyclerview.widget.v
 * JD-Core Version:    0.7.0.1
 */