package com.google.android.material.transformation;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.d;
import androidx.core.g.w;
import com.google.android.material.a.a;
import com.google.android.material.a.h;
import com.google.android.material.a.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public class FabTransformationSheetBehavior
  extends FabTransformationBehavior
{
  private Map<View, Integer> bxJ;
  
  public FabTransformationSheetBehavior() {}
  
  public FabTransformationSheetBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected final boolean a(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(240798);
    Object localObject = paramView2.getParent();
    if ((localObject instanceof CoordinatorLayout))
    {
      localObject = (CoordinatorLayout)localObject;
      int k = ((CoordinatorLayout)localObject).getChildCount();
      if ((Build.VERSION.SDK_INT >= 16) && (paramBoolean1)) {
        this.bxJ = new HashMap(k);
      }
      int i = 0;
      if (i < k)
      {
        View localView = ((CoordinatorLayout)localObject).getChildAt(i);
        int j;
        if (((localView.getLayoutParams() instanceof CoordinatorLayout.d)) && ((((CoordinatorLayout.d)localView.getLayoutParams()).Hq instanceof FabTransformationScrimBehavior)))
        {
          j = 1;
          label108:
          if ((localView != paramView2) && (j == 0))
          {
            if (paramBoolean1) {
              break label181;
            }
            if ((this.bxJ != null) && (this.bxJ.containsKey(localView))) {
              w.p(localView, ((Integer)this.bxJ.get(localView)).intValue());
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
            this.bxJ.put(localView, Integer.valueOf(localView.getImportantForAccessibility()));
          }
          w.p(localView, 4);
        }
      }
      if (!paramBoolean1) {
        this.bxJ = null;
      }
    }
    paramBoolean1 = super.a(paramView1, paramView2, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(240798);
    return paramBoolean1;
  }
  
  protected final FabTransformationBehavior.a j(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(240796);
    if (paramBoolean) {}
    for (int i = a.a.mtrl_fab_transformation_sheet_expand_spec;; i = a.a.mtrl_fab_transformation_sheet_collapse_spec)
    {
      FabTransformationBehavior.a locala = new FabTransformationBehavior.a();
      locala.bHD = h.y(paramContext, i);
      locala.bHE = new j();
      AppMethodBeat.o(240796);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.transformation.FabTransformationSheetBehavior
 * JD-Core Version:    0.7.0.1
 */