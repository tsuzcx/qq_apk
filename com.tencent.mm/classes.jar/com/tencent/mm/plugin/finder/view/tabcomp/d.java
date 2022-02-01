package com.tencent.mm.plugin.finder.view.tabcomp;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderAlignTab;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTab;", "title", "", "(Ljava/lang/String;)V", "titleId", "", "(I)V", "tabView", "Landroid/view/View;", "getTabView", "()Landroid/view/View;", "setTabView", "(Landroid/view/View;)V", "getAlignView", "getUnderLineEndView", "getUnderLinePadding", "", "getUnderLinePosInTabLayout", "Lkotlin/Pair;", "getUnderLineStartView", "onTabInflated", "", "view", "Landroid/view/ViewGroup;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public class d
  extends i
{
  private View GJe;
  
  public d(int paramInt)
  {
    super(paramInt);
  }
  
  public void H(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(345555);
    super.H(paramViewGroup);
    I(paramViewGroup);
    AppMethodBeat.o(345555);
  }
  
  public final void I(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(345560);
    if (paramViewGroup != null)
    {
      ViewParent localViewParent = paramViewGroup.getParent();
      if (localViewParent == null)
      {
        paramViewGroup = new NullPointerException("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(345560);
        throw paramViewGroup;
      }
      this.GJe = ((View)localViewParent);
      paramViewGroup.setTag(this);
    }
    AppMethodBeat.o(345560);
  }
  
  public View fmp()
  {
    AppMethodBeat.i(345542);
    View localView = (View)getTitleTv();
    AppMethodBeat.o(345542);
    return localView;
  }
  
  public View fmq()
  {
    AppMethodBeat.i(345546);
    View localView = (View)getTitleTv();
    AppMethodBeat.o(345546);
    return localView;
  }
  
  public View fmr()
  {
    return null;
  }
  
  public final r<Integer, Integer> fms()
  {
    AppMethodBeat.i(345554);
    Object localObject = this.GJe;
    if (localObject != null)
    {
      int[] arrayOfInt1 = new int[2];
      arrayOfInt1[0] = 0;
      arrayOfInt1[1] = 0;
      ((View)localObject).getLocationOnScreen(arrayOfInt1);
      int[] arrayOfInt2 = new int[2];
      arrayOfInt2[0] = 0;
      arrayOfInt2[1] = 0;
      int[] arrayOfInt3 = new int[2];
      arrayOfInt3[0] = 0;
      arrayOfInt3[1] = 0;
      View localView1 = fmp();
      View localView2 = fmq();
      if (localView1 != null) {
        localView1.getLocationOnScreen(arrayOfInt2);
      }
      if (localView2 != null) {
        localView2.getLocationOnScreen(arrayOfInt3);
      }
      int k;
      int j;
      if (arrayOfInt2[0] < arrayOfInt1[0])
      {
        i = arrayOfInt1[0];
        k = arrayOfInt3[0];
        if (localView2 != null) {
          break label281;
        }
        j = 0;
        label132:
        k = j + k;
        j = k;
        if (k > arrayOfInt1[0] + ((View)localObject).getWidth()) {
          j = arrayOfInt1[0] + ((View)localObject).getWidth();
        }
        arrayOfInt2 = new int[2];
        arrayOfInt2[0] = 0;
        arrayOfInt2[1] = 0;
        if (j - i <= 0) {
          break label290;
        }
        j -= i;
        label188:
        int m = j - arrayOfInt2[0] - arrayOfInt2[1];
        k = i;
        if (m > 0)
        {
          k = i + arrayOfInt2[0];
          j = m;
        }
        k = ((View)localObject).getLeft() + (k - arrayOfInt1[0]);
        if (k + j <= ((View)localObject).getRight()) {
          break label295;
        }
      }
      label281:
      label290:
      label295:
      for (int i = ((View)localObject).getRight();; i = k + j)
      {
        localObject = new r(Integer.valueOf(k), Integer.valueOf(i));
        AppMethodBeat.o(345554);
        return localObject;
        i = arrayOfInt2[0];
        break;
        j = localView2.getWidth();
        break label132;
        j = 0;
        break label188;
      }
    }
    AppMethodBeat.o(345554);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.tabcomp.d
 * JD-Core Version:    0.7.0.1
 */