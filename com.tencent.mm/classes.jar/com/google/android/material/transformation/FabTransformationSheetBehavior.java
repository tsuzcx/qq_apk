package com.google.android.material.transformation;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.d;
import androidx.core.g.z;
import com.google.android.material.a.a;
import com.google.android.material.a.h;
import com.google.android.material.a.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public class FabTransformationSheetBehavior
  extends FabTransformationBehavior
{
  private Map<View, Integer> dqM;
  
  public FabTransformationSheetBehavior() {}
  
  public FabTransformationSheetBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected final boolean a(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(209970);
    Object localObject = paramView2.getParent();
    if ((localObject instanceof CoordinatorLayout))
    {
      localObject = (CoordinatorLayout)localObject;
      int k = ((CoordinatorLayout)localObject).getChildCount();
      if ((Build.VERSION.SDK_INT >= 16) && (paramBoolean1)) {
        this.dqM = new HashMap(k);
      }
      int i = 0;
      if (i < k)
      {
        View localView = ((CoordinatorLayout)localObject).getChildAt(i);
        int j;
        if (((localView.getLayoutParams() instanceof CoordinatorLayout.d)) && ((((CoordinatorLayout.d)localView.getLayoutParams()).bnr instanceof FabTransformationScrimBehavior)))
        {
          j = 1;
          label108:
          if ((localView != paramView2) && (j == 0))
          {
            if (paramBoolean1) {
              break label181;
            }
            if ((this.dqM != null) && (this.dqM.containsKey(localView))) {
              z.p(localView, ((Integer)this.dqM.get(localView)).intValue());
            }
          }
        }
        for (;;)
        {
          i += 1;
          break;
          j = 0;
          break label108;
          label181:
          if (Build.VERSION.SDK_INT >= 16) {
            this.dqM.put(localView, Integer.valueOf(localView.getImportantForAccessibility()));
          }
          z.p(localView, 4);
        }
      }
      if (!paramBoolean1) {
        this.dqM = null;
      }
    }
    paramBoolean1 = super.a(paramView1, paramView2, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(209970);
    return paramBoolean1;
  }
  
  protected final FabTransformationBehavior.a j(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(209959);
    if (paramBoolean) {}
    for (int i = a.a.mtrl_fab_transformation_sheet_expand_spec;; i = a.a.mtrl_fab_transformation_sheet_collapse_spec)
    {
      FabTransformationBehavior.a locala = new FabTransformationBehavior.a();
      locala.dAC = h.B(paramContext, i);
      locala.dAD = new j();
      AppMethodBeat.o(209959);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.transformation.FabTransformationSheetBehavior
 * JD-Core Version:    0.7.0.1
 */