package androidx.recyclerview.widget;

import android.os.Build.VERSION;
import android.view.View;
import androidx.core.g.z;
import androidx.recyclerview.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class m
  implements l
{
  static final l bXo;
  
  static
  {
    AppMethodBeat.i(194775);
    bXo = new m();
    AppMethodBeat.o(194775);
  }
  
  public final void a(RecyclerView paramRecyclerView, View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(194788);
    float f3;
    float f1;
    int i;
    if ((Build.VERSION.SDK_INT >= 21) && (paramBoolean) && (paramView.getTag(a.b.item_touch_helper_previous_elevation) == null))
    {
      f3 = z.ag(paramView);
      int j = paramRecyclerView.getChildCount();
      f1 = 0.0F;
      i = 0;
      if (i < j)
      {
        View localView = paramRecyclerView.getChildAt(i);
        if (localView == paramView) {
          break label132;
        }
        float f2 = z.ag(localView);
        if (f2 <= f1) {
          break label132;
        }
        f1 = f2;
      }
    }
    label132:
    for (;;)
    {
      i += 1;
      break;
      z.k(paramView, 1.0F + f1);
      paramView.setTag(a.b.item_touch_helper_previous_elevation, Float.valueOf(f3));
      paramView.setTranslationX(paramFloat1);
      paramView.setTranslationY(paramFloat2);
      AppMethodBeat.o(194788);
      return;
    }
  }
  
  public final void bp(View paramView)
  {
    AppMethodBeat.i(194800);
    if (Build.VERSION.SDK_INT >= 21)
    {
      Object localObject = paramView.getTag(a.b.item_touch_helper_previous_elevation);
      if ((localObject != null) && ((localObject instanceof Float))) {
        z.k(paramView, ((Float)localObject).floatValue());
      }
      paramView.setTag(a.b.item_touch_helper_previous_elevation, null);
    }
    paramView.setTranslationX(0.0F);
    paramView.setTranslationY(0.0F);
    AppMethodBeat.o(194800);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.recyclerview.widget.m
 * JD-Core Version:    0.7.0.1
 */