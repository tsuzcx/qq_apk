package android.support.design.transformation;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.design.a.h;
import android.support.design.a.j;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.CoordinatorLayout.d;
import android.support.v4.view.u;
import android.util.AttributeSet;
import android.view.View;
import java.util.HashMap;
import java.util.Map;

public class FabTransformationSheetBehavior
  extends FabTransformationBehavior
{
  private Map<View, Integer> mR;
  
  public FabTransformationSheetBehavior() {}
  
  public FabTransformationSheetBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected final boolean a(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = paramView2.getParent();
    if ((localObject instanceof CoordinatorLayout))
    {
      localObject = (CoordinatorLayout)localObject;
      int k = ((CoordinatorLayout)localObject).getChildCount();
      if ((Build.VERSION.SDK_INT >= 16) && (paramBoolean1)) {
        this.mR = new HashMap(k);
      }
      int i = 0;
      if (i < k)
      {
        View localView = ((CoordinatorLayout)localObject).getChildAt(i);
        int j;
        if (((localView.getLayoutParams() instanceof CoordinatorLayout.d)) && ((((CoordinatorLayout.d)localView.getLayoutParams()).qC instanceof FabTransformationScrimBehavior)))
        {
          j = 1;
          label103:
          if ((localView != paramView2) && (j == 0))
          {
            if (paramBoolean1) {
              break label176;
            }
            if ((this.mR != null) && (this.mR.containsKey(localView))) {
              u.p(localView, ((Integer)this.mR.get(localView)).intValue());
            }
          }
        }
        for (;;)
        {
          i += 1;
          break;
          j = 0;
          break label103;
          label176:
          if (Build.VERSION.SDK_INT >= 16) {
            this.mR.put(localView, Integer.valueOf(localView.getImportantForAccessibility()));
          }
          u.p(localView, 4);
        }
      }
      if (!paramBoolean1) {
        this.mR = null;
      }
    }
    return super.a(paramView1, paramView2, paramBoolean1, paramBoolean2);
  }
  
  protected final FabTransformationBehavior.a h(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 2130837519;; i = 2130837518)
    {
      FabTransformationBehavior.a locala = new FabTransformationBehavior.a();
      locala.mM = h.k(paramContext, i);
      locala.mN = new j();
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.transformation.FabTransformationSheetBehavior
 * JD-Core Version:    0.7.0.1
 */