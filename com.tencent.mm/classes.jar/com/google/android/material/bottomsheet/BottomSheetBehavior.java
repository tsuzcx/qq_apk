package com.google.android.material.bottomsheet;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout.d;
import androidx.core.b.a;
import androidx.core.g.w;
import androidx.customview.a.c;
import androidx.customview.a.c.a;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.a.d;
import com.google.android.material.a.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class BottomSheetBehavior<V extends View>
  extends CoordinatorLayout.Behavior<V>
{
  WeakReference<V> aFW;
  int bvF;
  private VelocityTracker bvI;
  c bwa;
  private final c.a bwi;
  private boolean bxA;
  private boolean bxB;
  private int bxC;
  private boolean bxD;
  int bxE;
  WeakReference<View> bxF;
  public BottomSheetBehavior.a bxG;
  private int bxH;
  boolean bxI;
  private Map<View, Integer> bxJ;
  private boolean bxq;
  private float bxr;
  private int bxs;
  private boolean bxt;
  private int bxu;
  private int bxv;
  int bxw;
  int bxx;
  int bxy;
  public boolean bxz;
  int state;
  
  public BottomSheetBehavior()
  {
    AppMethodBeat.i(235371);
    this.bxq = true;
    this.state = 4;
    this.bwi = new c.a()
    {
      public final void G(int paramAnonymousInt)
      {
        AppMethodBeat.i(235313);
        if (paramAnonymousInt == 1) {
          BottomSheetBehavior.this.E(1);
        }
        AppMethodBeat.o(235313);
      }
      
      public final int U()
      {
        if (BottomSheetBehavior.this.bxz) {
          return BottomSheetBehavior.this.bxE;
        }
        return BottomSheetBehavior.this.bxy;
      }
      
      public final void a(View paramAnonymousView, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        int j = 3;
        AppMethodBeat.i(235315);
        int i;
        if (paramAnonymousFloat2 < 0.0F) {
          if (BottomSheetBehavior.a(BottomSheetBehavior.this)) {
            i = BottomSheetBehavior.this.bxw;
          }
        }
        while (BottomSheetBehavior.this.bwa.I(paramAnonymousView.getLeft(), i))
        {
          BottomSheetBehavior.this.E(2);
          w.a(paramAnonymousView, new BottomSheetBehavior.b(BottomSheetBehavior.this, paramAnonymousView, j));
          AppMethodBeat.o(235315);
          return;
          if (paramAnonymousView.getTop() > BottomSheetBehavior.this.bxx)
          {
            i = BottomSheetBehavior.this.bxx;
            j = 6;
          }
          else
          {
            i = 0;
            continue;
            if ((BottomSheetBehavior.this.bxz) && (BottomSheetBehavior.this.a(paramAnonymousView, paramAnonymousFloat2)) && ((paramAnonymousView.getTop() > BottomSheetBehavior.this.bxy) || (Math.abs(paramAnonymousFloat1) < Math.abs(paramAnonymousFloat2))))
            {
              i = BottomSheetBehavior.this.bxE;
              j = 5;
            }
            else if ((paramAnonymousFloat2 == 0.0F) || (Math.abs(paramAnonymousFloat1) > Math.abs(paramAnonymousFloat2)))
            {
              i = paramAnonymousView.getTop();
              if (BottomSheetBehavior.a(BottomSheetBehavior.this))
              {
                if (Math.abs(i - BottomSheetBehavior.this.bxw) < Math.abs(i - BottomSheetBehavior.this.bxy))
                {
                  i = BottomSheetBehavior.this.bxw;
                }
                else
                {
                  i = BottomSheetBehavior.this.bxy;
                  j = 4;
                }
              }
              else if (i < BottomSheetBehavior.this.bxx)
              {
                if (i < Math.abs(i - BottomSheetBehavior.this.bxy))
                {
                  i = 0;
                }
                else
                {
                  i = BottomSheetBehavior.this.bxx;
                  j = 6;
                }
              }
              else if (Math.abs(i - BottomSheetBehavior.this.bxx) < Math.abs(i - BottomSheetBehavior.this.bxy))
              {
                i = BottomSheetBehavior.this.bxx;
                j = 6;
              }
              else
              {
                i = BottomSheetBehavior.this.bxy;
                j = 4;
              }
            }
            else
            {
              i = BottomSheetBehavior.this.bxy;
              j = 4;
            }
          }
        }
        BottomSheetBehavior.this.E(j);
        AppMethodBeat.o(235315);
      }
      
      public final void a(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(235310);
        BottomSheetBehavior.this.F(paramAnonymousInt2);
        AppMethodBeat.o(235310);
      }
      
      public final boolean b(View paramAnonymousView, int paramAnonymousInt)
      {
        AppMethodBeat.i(235308);
        if (BottomSheetBehavior.this.state == 1)
        {
          AppMethodBeat.o(235308);
          return false;
        }
        if (BottomSheetBehavior.this.bxI)
        {
          AppMethodBeat.o(235308);
          return false;
        }
        if ((BottomSheetBehavior.this.state == 3) && (BottomSheetBehavior.this.bvF == paramAnonymousInt))
        {
          View localView = (View)BottomSheetBehavior.this.bxF.get();
          if ((localView != null) && (localView.canScrollVertically(-1)))
          {
            AppMethodBeat.o(235308);
            return false;
          }
        }
        if ((BottomSheetBehavior.this.aFW != null) && (BottomSheetBehavior.this.aFW.get() == paramAnonymousView))
        {
          AppMethodBeat.o(235308);
          return true;
        }
        AppMethodBeat.o(235308);
        return false;
      }
      
      public final int c(View paramAnonymousView, int paramAnonymousInt)
      {
        AppMethodBeat.i(235317);
        int j = BottomSheetBehavior.b(BottomSheetBehavior.this);
        if (BottomSheetBehavior.this.bxz) {}
        for (int i = BottomSheetBehavior.this.bxE;; i = BottomSheetBehavior.this.bxy)
        {
          paramAnonymousInt = a.clamp(paramAnonymousInt, j, i);
          AppMethodBeat.o(235317);
          return paramAnonymousInt;
        }
      }
      
      public final int d(View paramAnonymousView, int paramAnonymousInt)
      {
        AppMethodBeat.i(235318);
        paramAnonymousInt = paramAnonymousView.getLeft();
        AppMethodBeat.o(235318);
        return paramAnonymousInt;
      }
    };
    AppMethodBeat.o(235371);
  }
  
  public BottomSheetBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(235374);
    this.bxq = true;
    this.state = 4;
    this.bwi = new c.a()
    {
      public final void G(int paramAnonymousInt)
      {
        AppMethodBeat.i(235313);
        if (paramAnonymousInt == 1) {
          BottomSheetBehavior.this.E(1);
        }
        AppMethodBeat.o(235313);
      }
      
      public final int U()
      {
        if (BottomSheetBehavior.this.bxz) {
          return BottomSheetBehavior.this.bxE;
        }
        return BottomSheetBehavior.this.bxy;
      }
      
      public final void a(View paramAnonymousView, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        int j = 3;
        AppMethodBeat.i(235315);
        int i;
        if (paramAnonymousFloat2 < 0.0F) {
          if (BottomSheetBehavior.a(BottomSheetBehavior.this)) {
            i = BottomSheetBehavior.this.bxw;
          }
        }
        while (BottomSheetBehavior.this.bwa.I(paramAnonymousView.getLeft(), i))
        {
          BottomSheetBehavior.this.E(2);
          w.a(paramAnonymousView, new BottomSheetBehavior.b(BottomSheetBehavior.this, paramAnonymousView, j));
          AppMethodBeat.o(235315);
          return;
          if (paramAnonymousView.getTop() > BottomSheetBehavior.this.bxx)
          {
            i = BottomSheetBehavior.this.bxx;
            j = 6;
          }
          else
          {
            i = 0;
            continue;
            if ((BottomSheetBehavior.this.bxz) && (BottomSheetBehavior.this.a(paramAnonymousView, paramAnonymousFloat2)) && ((paramAnonymousView.getTop() > BottomSheetBehavior.this.bxy) || (Math.abs(paramAnonymousFloat1) < Math.abs(paramAnonymousFloat2))))
            {
              i = BottomSheetBehavior.this.bxE;
              j = 5;
            }
            else if ((paramAnonymousFloat2 == 0.0F) || (Math.abs(paramAnonymousFloat1) > Math.abs(paramAnonymousFloat2)))
            {
              i = paramAnonymousView.getTop();
              if (BottomSheetBehavior.a(BottomSheetBehavior.this))
              {
                if (Math.abs(i - BottomSheetBehavior.this.bxw) < Math.abs(i - BottomSheetBehavior.this.bxy))
                {
                  i = BottomSheetBehavior.this.bxw;
                }
                else
                {
                  i = BottomSheetBehavior.this.bxy;
                  j = 4;
                }
              }
              else if (i < BottomSheetBehavior.this.bxx)
              {
                if (i < Math.abs(i - BottomSheetBehavior.this.bxy))
                {
                  i = 0;
                }
                else
                {
                  i = BottomSheetBehavior.this.bxx;
                  j = 6;
                }
              }
              else if (Math.abs(i - BottomSheetBehavior.this.bxx) < Math.abs(i - BottomSheetBehavior.this.bxy))
              {
                i = BottomSheetBehavior.this.bxx;
                j = 6;
              }
              else
              {
                i = BottomSheetBehavior.this.bxy;
                j = 4;
              }
            }
            else
            {
              i = BottomSheetBehavior.this.bxy;
              j = 4;
            }
          }
        }
        BottomSheetBehavior.this.E(j);
        AppMethodBeat.o(235315);
      }
      
      public final void a(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(235310);
        BottomSheetBehavior.this.F(paramAnonymousInt2);
        AppMethodBeat.o(235310);
      }
      
      public final boolean b(View paramAnonymousView, int paramAnonymousInt)
      {
        AppMethodBeat.i(235308);
        if (BottomSheetBehavior.this.state == 1)
        {
          AppMethodBeat.o(235308);
          return false;
        }
        if (BottomSheetBehavior.this.bxI)
        {
          AppMethodBeat.o(235308);
          return false;
        }
        if ((BottomSheetBehavior.this.state == 3) && (BottomSheetBehavior.this.bvF == paramAnonymousInt))
        {
          View localView = (View)BottomSheetBehavior.this.bxF.get();
          if ((localView != null) && (localView.canScrollVertically(-1)))
          {
            AppMethodBeat.o(235308);
            return false;
          }
        }
        if ((BottomSheetBehavior.this.aFW != null) && (BottomSheetBehavior.this.aFW.get() == paramAnonymousView))
        {
          AppMethodBeat.o(235308);
          return true;
        }
        AppMethodBeat.o(235308);
        return false;
      }
      
      public final int c(View paramAnonymousView, int paramAnonymousInt)
      {
        AppMethodBeat.i(235317);
        int j = BottomSheetBehavior.b(BottomSheetBehavior.this);
        if (BottomSheetBehavior.this.bxz) {}
        for (int i = BottomSheetBehavior.this.bxE;; i = BottomSheetBehavior.this.bxy)
        {
          paramAnonymousInt = a.clamp(paramAnonymousInt, j, i);
          AppMethodBeat.o(235317);
          return paramAnonymousInt;
        }
      }
      
      public final int d(View paramAnonymousView, int paramAnonymousInt)
      {
        AppMethodBeat.i(235318);
        paramAnonymousInt = paramAnonymousView.getLeft();
        AppMethodBeat.o(235318);
        return paramAnonymousInt;
      }
    };
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.BottomSheetBehavior_Layout);
    TypedValue localTypedValue = paramAttributeSet.peekValue(a.k.BottomSheetBehavior_Layout_behavior_peekHeight);
    if ((localTypedValue != null) && (localTypedValue.data == -1))
    {
      D(localTypedValue.data);
      this.bxz = paramAttributeSet.getBoolean(a.k.BottomSheetBehavior_Layout_behavior_hideable, false);
      boolean bool = paramAttributeSet.getBoolean(a.k.BottomSheetBehavior_Layout_behavior_fitToContents, true);
      if (this.bxq != bool)
      {
        this.bxq = bool;
        if (this.aFW != null) {
          wn();
        }
        if ((!this.bxq) || (this.state != 6)) {
          break label194;
        }
      }
    }
    label194:
    for (int i = 3;; i = this.state)
    {
      E(i);
      this.bxA = paramAttributeSet.getBoolean(a.k.BottomSheetBehavior_Layout_behavior_skipCollapsed, false);
      paramAttributeSet.recycle();
      this.bxr = ViewConfiguration.get(paramContext).getScaledMaximumFlingVelocity();
      AppMethodBeat.o(235374);
      return;
      D(paramAttributeSet.getDimensionPixelSize(a.k.BottomSheetBehavior_Layout_behavior_peekHeight, -1));
      break;
    }
  }
  
  private View b(View paramView)
  {
    AppMethodBeat.i(235414);
    if (w.ae(paramView))
    {
      AppMethodBeat.o(235414);
      return paramView;
    }
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int j = paramView.getChildCount();
      int i = 0;
      while (i < j)
      {
        View localView = b(paramView.getChildAt(i));
        if (localView != null)
        {
          AppMethodBeat.o(235414);
          return localView;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(235414);
    return null;
  }
  
  private void be(boolean paramBoolean)
  {
    AppMethodBeat.i(235423);
    if (this.aFW == null)
    {
      AppMethodBeat.o(235423);
      return;
    }
    Object localObject = ((View)this.aFW.get()).getParent();
    if (!(localObject instanceof CoordinatorLayout))
    {
      AppMethodBeat.o(235423);
      return;
    }
    localObject = (CoordinatorLayout)localObject;
    int j = ((CoordinatorLayout)localObject).getChildCount();
    int i;
    View localView;
    if ((Build.VERSION.SDK_INT >= 16) && (paramBoolean))
    {
      if (this.bxJ == null) {
        this.bxJ = new HashMap(j);
      }
    }
    else
    {
      i = 0;
      if (i >= j) {
        break label215;
      }
      localView = ((CoordinatorLayout)localObject).getChildAt(i);
      if (localView != this.aFW.get())
      {
        if (paramBoolean) {
          break label178;
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
      AppMethodBeat.o(235423);
      return;
      label178:
      if (Build.VERSION.SDK_INT >= 16) {
        this.bxJ.put(localView, Integer.valueOf(localView.getImportantForAccessibility()));
      }
      w.p(localView, 4);
    }
    label215:
    if (!paramBoolean) {
      this.bxJ = null;
    }
    AppMethodBeat.o(235423);
  }
  
  public static <V extends View> BottomSheetBehavior<V> cg(V paramV)
  {
    AppMethodBeat.i(235421);
    paramV = paramV.getLayoutParams();
    if (!(paramV instanceof CoordinatorLayout.d))
    {
      paramV = new IllegalArgumentException("The view is not a child of CoordinatorLayout");
      AppMethodBeat.o(235421);
      throw paramV;
    }
    paramV = ((CoordinatorLayout.d)paramV).Hq;
    if (!(paramV instanceof BottomSheetBehavior))
    {
      paramV = new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
      AppMethodBeat.o(235421);
      throw paramV;
    }
    paramV = (BottomSheetBehavior)paramV;
    AppMethodBeat.o(235421);
    return paramV;
  }
  
  private void reset()
  {
    AppMethodBeat.i(235410);
    this.bvF = -1;
    if (this.bvI != null)
    {
      this.bvI.recycle();
      this.bvI = null;
    }
    AppMethodBeat.o(235410);
  }
  
  private void wn()
  {
    AppMethodBeat.i(235407);
    if (this.bxq)
    {
      this.bxy = Math.max(this.bxE - this.bxv, this.bxw);
      AppMethodBeat.o(235407);
      return;
    }
    this.bxy = (this.bxE - this.bxv);
    AppMethodBeat.o(235407);
  }
  
  private int wo()
  {
    if (this.bxq) {
      return this.bxw;
    }
    return 0;
  }
  
  public final void D(int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(235399);
    if (paramInt == -1)
    {
      if (this.bxt) {
        break label116;
      }
      this.bxt = true;
      paramInt = i;
    }
    for (;;)
    {
      if ((paramInt != 0) && (this.state == 4) && (this.aFW != null))
      {
        View localView = (View)this.aFW.get();
        if (localView != null) {
          localView.requestLayout();
        }
      }
      AppMethodBeat.o(235399);
      return;
      if ((this.bxt) || (this.bxs != paramInt))
      {
        this.bxt = false;
        this.bxs = Math.max(0, paramInt);
        this.bxy = (this.bxE - paramInt);
        paramInt = i;
      }
      else
      {
        label116:
        paramInt = 0;
      }
    }
  }
  
  final void E(int paramInt)
  {
    AppMethodBeat.i(235406);
    if (this.state == paramInt)
    {
      AppMethodBeat.o(235406);
      return;
    }
    this.state = paramInt;
    if ((paramInt == 6) || (paramInt == 3)) {
      be(true);
    }
    for (;;)
    {
      View localView = (View)this.aFW.get();
      if ((localView != null) && (this.bxG != null)) {
        this.bxG.e(localView, paramInt);
      }
      AppMethodBeat.o(235406);
      return;
      if ((paramInt == 5) || (paramInt == 4)) {
        be(false);
      }
    }
  }
  
  final void F(int paramInt)
  {
    AppMethodBeat.i(235419);
    View localView = (View)this.aFW.get();
    if ((localView != null) && (this.bxG != null))
    {
      if (paramInt > this.bxy)
      {
        this.bxG.ch(localView);
        AppMethodBeat.o(235419);
        return;
      }
      BottomSheetBehavior.a locala = this.bxG;
      wo();
      locala.ch(localView);
    }
    AppMethodBeat.o(235419);
  }
  
  public final Parcelable a(CoordinatorLayout paramCoordinatorLayout, V paramV)
  {
    AppMethodBeat.i(235378);
    paramCoordinatorLayout = new SavedState(super.a(paramCoordinatorLayout, paramV), this.state);
    AppMethodBeat.o(235378);
    return paramCoordinatorLayout;
  }
  
  final void a(View paramView, int paramInt)
  {
    AppMethodBeat.i(235417);
    int i;
    int j;
    if (paramInt == 4)
    {
      i = this.bxy;
      j = paramInt;
    }
    while (this.bwa.f(paramView, paramView.getLeft(), i))
    {
      E(2);
      w.a(paramView, new b(paramView, j));
      AppMethodBeat.o(235417);
      return;
      if (paramInt == 6)
      {
        int k = this.bxx;
        i = k;
        j = paramInt;
        if (this.bxq)
        {
          i = k;
          j = paramInt;
          if (k <= this.bxw)
          {
            i = this.bxw;
            j = 3;
          }
        }
      }
      else if (paramInt == 3)
      {
        i = wo();
        j = paramInt;
      }
      else if ((this.bxz) && (paramInt == 5))
      {
        i = this.bxE;
        j = paramInt;
      }
      else
      {
        paramView = new IllegalArgumentException("Illegal state argument: ".concat(String.valueOf(paramInt)));
        AppMethodBeat.o(235417);
        throw paramView;
      }
    }
    E(j);
    AppMethodBeat.o(235417);
  }
  
  public final void a(CoordinatorLayout paramCoordinatorLayout, V paramV, Parcelable paramParcelable)
  {
    AppMethodBeat.i(235379);
    paramParcelable = (SavedState)paramParcelable;
    super.a(paramCoordinatorLayout, paramV, paramParcelable.Rb);
    if ((paramParcelable.state == 1) || (paramParcelable.state == 2))
    {
      this.state = 4;
      AppMethodBeat.o(235379);
      return;
    }
    this.state = paramParcelable.state;
    AppMethodBeat.o(235379);
  }
  
  public final void a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, int paramInt)
  {
    AppMethodBeat.i(235396);
    if (paramV.getTop() == wo())
    {
      E(3);
      AppMethodBeat.o(235396);
      return;
    }
    if ((paramView != this.bxF.get()) || (!this.bxD))
    {
      AppMethodBeat.o(235396);
      return;
    }
    int i;
    if (this.bxC > 0)
    {
      i = wo();
      paramInt = 3;
      if (!this.bwa.f(paramV, paramV.getLeft(), i)) {
        break label361;
      }
      E(2);
      w.a(paramV, new b(paramV, paramInt));
    }
    for (;;)
    {
      this.bxD = false;
      AppMethodBeat.o(235396);
      return;
      if (this.bxz)
      {
        if (this.bvI == null) {}
        for (float f = 0.0F;; f = this.bvI.getYVelocity(this.bvF))
        {
          if (!a(paramV, f)) {
            break label188;
          }
          i = this.bxE;
          paramInt = 5;
          break;
          this.bvI.computeCurrentVelocity(1000, this.bxr);
        }
      }
      label188:
      if (this.bxC == 0)
      {
        paramInt = paramV.getTop();
        if (this.bxq)
        {
          if (Math.abs(paramInt - this.bxw) < Math.abs(paramInt - this.bxy))
          {
            i = this.bxw;
            paramInt = 3;
            break;
          }
          i = this.bxy;
          paramInt = 4;
          break;
        }
        if (paramInt < this.bxx)
        {
          if (paramInt < Math.abs(paramInt - this.bxy))
          {
            paramInt = 3;
            i = 0;
            break;
          }
          i = this.bxx;
          paramInt = 6;
          break;
        }
        if (Math.abs(paramInt - this.bxx) < Math.abs(paramInt - this.bxy))
        {
          i = this.bxx;
          paramInt = 6;
          break;
        }
        i = this.bxy;
        paramInt = 4;
        break;
      }
      i = this.bxy;
      paramInt = 4;
      break;
      label361:
      E(paramInt);
    }
  }
  
  public final void a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    AppMethodBeat.i(235393);
    if (paramInt3 == 1)
    {
      AppMethodBeat.o(235393);
      return;
    }
    if (paramView != (View)this.bxF.get())
    {
      AppMethodBeat.o(235393);
      return;
    }
    paramInt1 = paramV.getTop();
    paramInt3 = paramInt1 - paramInt2;
    if (paramInt2 > 0) {
      if (paramInt3 < wo())
      {
        paramArrayOfInt[1] = (paramInt1 - wo());
        w.s(paramV, -paramArrayOfInt[1]);
        E(3);
      }
    }
    for (;;)
    {
      F(paramV.getTop());
      this.bxC = paramInt2;
      this.bxD = true;
      AppMethodBeat.o(235393);
      return;
      paramArrayOfInt[1] = paramInt2;
      w.s(paramV, -paramInt2);
      E(1);
      continue;
      if ((paramInt2 < 0) && (!paramView.canScrollVertically(-1))) {
        if ((paramInt3 <= this.bxy) || (this.bxz))
        {
          paramArrayOfInt[1] = paramInt2;
          w.s(paramV, -paramInt2);
          E(1);
        }
        else
        {
          paramArrayOfInt[1] = (paramInt1 - this.bxy);
          w.s(paramV, -paramArrayOfInt[1]);
          E(4);
        }
      }
    }
  }
  
  public final void a(BottomSheetBehavior.a parama)
  {
    this.bxG = parama;
  }
  
  final boolean a(View paramView, float paramFloat)
  {
    AppMethodBeat.i(235412);
    if (this.bxA)
    {
      AppMethodBeat.o(235412);
      return true;
    }
    if (paramView.getTop() < this.bxy)
    {
      AppMethodBeat.o(235412);
      return false;
    }
    if (Math.abs(paramView.getTop() + 0.1F * paramFloat - this.bxy) / this.bxs > 0.5F)
    {
      AppMethodBeat.o(235412);
      return true;
    }
    AppMethodBeat.o(235412);
    return false;
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
  {
    AppMethodBeat.i(235383);
    if ((w.Z(paramCoordinatorLayout)) && (!w.Z(paramV))) {
      paramV.setFitsSystemWindows(true);
    }
    int i = paramV.getTop();
    paramCoordinatorLayout.h(paramV, paramInt);
    this.bxE = paramCoordinatorLayout.getHeight();
    if (this.bxt)
    {
      if (this.bxu == 0) {
        this.bxu = paramCoordinatorLayout.getResources().getDimensionPixelSize(a.d.design_bottom_sheet_peek_height_min);
      }
      this.bxv = Math.max(this.bxu, this.bxE - paramCoordinatorLayout.getWidth() * 9 / 16);
      this.bxw = Math.max(0, this.bxE - paramV.getHeight());
      this.bxx = (this.bxE / 2);
      wn();
      if (this.state != 3) {
        break label212;
      }
      w.s(paramV, wo());
    }
    for (;;)
    {
      if (this.bwa == null) {
        this.bwa = c.a(paramCoordinatorLayout, this.bwi);
      }
      this.aFW = new WeakReference(paramV);
      this.bxF = new WeakReference(b(paramV));
      AppMethodBeat.o(235383);
      return true;
      this.bxv = this.bxs;
      break;
      label212:
      if (this.state == 6) {
        w.s(paramV, this.bxx);
      } else if ((this.bxz) && (this.state == 5)) {
        w.s(paramV, this.bxE);
      } else if (this.state == 4) {
        w.s(paramV, this.bxy);
      } else if ((this.state == 1) || (this.state == 2)) {
        w.s(paramV, i - paramV.getTop());
      }
    }
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(235386);
    if (!paramV.isShown())
    {
      this.bxB = true;
      AppMethodBeat.o(235386);
      return false;
    }
    int i = paramMotionEvent.getActionMasked();
    if (i == 0) {
      reset();
    }
    if (this.bvI == null) {
      this.bvI = VelocityTracker.obtain();
    }
    this.bvI.addMovement(paramMotionEvent);
    switch (i)
    {
    }
    while ((!this.bxB) && (this.bwa != null) && (this.bwa.i(paramMotionEvent)))
    {
      AppMethodBeat.o(235386);
      return true;
      this.bxI = false;
      this.bvF = -1;
      if (this.bxB)
      {
        this.bxB = false;
        AppMethodBeat.o(235386);
        return false;
        int j = (int)paramMotionEvent.getX();
        this.bxH = ((int)paramMotionEvent.getY());
        View localView;
        if (this.bxF != null)
        {
          localView = (View)this.bxF.get();
          label194:
          if ((localView != null) && (paramCoordinatorLayout.d(localView, j, this.bxH)))
          {
            this.bvF = paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex());
            this.bxI = true;
          }
          if ((this.bvF != -1) || (paramCoordinatorLayout.d(paramV, j, this.bxH))) {
            break label271;
          }
        }
        label271:
        for (boolean bool = true;; bool = false)
        {
          this.bxB = bool;
          break;
          localView = null;
          break label194;
        }
      }
    }
    if (this.bxF != null) {}
    for (paramV = (View)this.bxF.get(); (i == 2) && (paramV != null) && (!this.bxB) && (this.state != 1) && (!paramCoordinatorLayout.d(paramV, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) && (this.bwa != null) && (Math.abs(this.bxH - paramMotionEvent.getY()) > this.bwa.mTouchSlop); paramV = null)
    {
      AppMethodBeat.o(235386);
      return true;
    }
    AppMethodBeat.o(235386);
    return false;
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(235398);
    if ((paramView == this.bxF.get()) && ((this.state != 3) || (super.a(paramCoordinatorLayout, paramV, paramView, paramFloat1, paramFloat2))))
    {
      AppMethodBeat.o(235398);
      return true;
    }
    AppMethodBeat.o(235398);
    return false;
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    this.bxC = 0;
    this.bxD = false;
    if ((paramInt1 & 0x2) != 0) {
      bool = true;
    }
    return bool;
  }
  
  public final boolean b(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(235389);
    if (!paramV.isShown())
    {
      AppMethodBeat.o(235389);
      return false;
    }
    int i = paramMotionEvent.getActionMasked();
    if ((this.state == 1) && (i == 0))
    {
      AppMethodBeat.o(235389);
      return true;
    }
    if (this.bwa != null) {
      this.bwa.j(paramMotionEvent);
    }
    if (i == 0) {
      reset();
    }
    if (this.bvI == null) {
      this.bvI = VelocityTracker.obtain();
    }
    this.bvI.addMovement(paramMotionEvent);
    if ((i == 2) && (!this.bxB) && (Math.abs(this.bxH - paramMotionEvent.getY()) > this.bwa.mTouchSlop)) {
      this.bwa.x(paramV, paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex()));
    }
    if (!this.bxB)
    {
      AppMethodBeat.o(235389);
      return true;
    }
    AppMethodBeat.o(235389);
    return false;
  }
  
  public final void bd(boolean paramBoolean)
  {
    this.bxz = paramBoolean;
  }
  
  public final void setState(int paramInt)
  {
    AppMethodBeat.i(235403);
    if (paramInt == this.state)
    {
      AppMethodBeat.o(235403);
      return;
    }
    if (this.aFW == null)
    {
      if ((paramInt == 4) || (paramInt == 3) || (paramInt == 6) || ((this.bxz) && (paramInt == 5))) {
        this.state = paramInt;
      }
      AppMethodBeat.o(235403);
      return;
    }
    View localView = (View)this.aFW.get();
    if (localView == null)
    {
      AppMethodBeat.o(235403);
      return;
    }
    ViewParent localViewParent = localView.getParent();
    if ((localViewParent != null) && (localViewParent.isLayoutRequested()) && (w.al(localView)))
    {
      localView.post(new BottomSheetBehavior.1(this, localView, paramInt));
      AppMethodBeat.o(235403);
      return;
    }
    a(localView, paramInt);
    AppMethodBeat.o(235403);
  }
  
  protected static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    final int state;
    
    static
    {
      AppMethodBeat.i(235342);
      CREATOR = new Parcelable.ClassLoaderCreator() {};
      AppMethodBeat.o(235342);
    }
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      AppMethodBeat.i(235338);
      this.state = paramParcel.readInt();
      AppMethodBeat.o(235338);
    }
    
    public SavedState(Parcelable paramParcelable, int paramInt)
    {
      super();
      this.state = paramInt;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(235340);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.state);
      AppMethodBeat.o(235340);
    }
  }
  
  final class b
    implements Runnable
  {
    private final int bxM;
    private final View view;
    
    b(View paramView, int paramInt)
    {
      this.view = paramView;
      this.bxM = paramInt;
    }
    
    public final void run()
    {
      AppMethodBeat.i(235347);
      if ((BottomSheetBehavior.this.bwa != null) && (BottomSheetBehavior.this.bwa.hM()))
      {
        w.a(this.view, this);
        AppMethodBeat.o(235347);
        return;
      }
      BottomSheetBehavior.this.E(this.bxM);
      AppMethodBeat.o(235347);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.bottomsheet.BottomSheetBehavior
 * JD-Core Version:    0.7.0.1
 */