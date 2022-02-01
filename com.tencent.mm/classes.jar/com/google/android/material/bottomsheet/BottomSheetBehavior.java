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
import androidx.core.g.z;
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
  int doI;
  private VelocityTracker doL;
  c dpd;
  private final c.a dpl;
  int dqA;
  int dqB;
  public boolean dqC;
  private boolean dqD;
  private boolean dqE;
  private int dqF;
  private boolean dqG;
  int dqH;
  WeakReference<View> dqI;
  public BottomSheetBehavior.a dqJ;
  private int dqK;
  boolean dqL;
  private Map<View, Integer> dqM;
  private boolean dqt;
  private float dqu;
  private int dqv;
  private boolean dqw;
  private int dqx;
  private int dqy;
  int dqz;
  public int state;
  WeakReference<V> viewRef;
  
  public BottomSheetBehavior()
  {
    AppMethodBeat.i(209463);
    this.dqt = true;
    this.state = 4;
    this.dpl = new c.a()
    {
      public final void F(int paramAnonymousInt)
      {
        AppMethodBeat.i(209480);
        if (paramAnonymousInt == 1) {
          BottomSheetBehavior.this.D(1);
        }
        AppMethodBeat.o(209480);
      }
      
      public final void a(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(209466);
        BottomSheetBehavior.this.E(paramAnonymousInt2);
        AppMethodBeat.o(209466);
      }
      
      public final int aM()
      {
        if (BottomSheetBehavior.this.dqC) {
          return BottomSheetBehavior.this.dqH;
        }
        return BottomSheetBehavior.this.dqB;
      }
      
      public final void b(View paramAnonymousView, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        int j = 3;
        AppMethodBeat.i(209491);
        int i;
        if (paramAnonymousFloat2 < 0.0F) {
          if (BottomSheetBehavior.a(BottomSheetBehavior.this)) {
            i = BottomSheetBehavior.this.dqz;
          }
        }
        while (BottomSheetBehavior.this.dpd.aD(paramAnonymousView.getLeft(), i))
        {
          BottomSheetBehavior.this.D(2);
          z.b(paramAnonymousView, new BottomSheetBehavior.b(BottomSheetBehavior.this, paramAnonymousView, j));
          AppMethodBeat.o(209491);
          return;
          if (paramAnonymousView.getTop() > BottomSheetBehavior.this.dqA)
          {
            i = BottomSheetBehavior.this.dqA;
            j = 6;
          }
          else
          {
            i = 0;
            continue;
            if ((BottomSheetBehavior.this.dqC) && (BottomSheetBehavior.this.b(paramAnonymousView, paramAnonymousFloat2)) && ((paramAnonymousView.getTop() > BottomSheetBehavior.this.dqB) || (Math.abs(paramAnonymousFloat1) < Math.abs(paramAnonymousFloat2))))
            {
              i = BottomSheetBehavior.this.dqH;
              j = 5;
            }
            else if ((paramAnonymousFloat2 == 0.0F) || (Math.abs(paramAnonymousFloat1) > Math.abs(paramAnonymousFloat2)))
            {
              i = paramAnonymousView.getTop();
              if (BottomSheetBehavior.a(BottomSheetBehavior.this))
              {
                if (Math.abs(i - BottomSheetBehavior.this.dqz) < Math.abs(i - BottomSheetBehavior.this.dqB))
                {
                  i = BottomSheetBehavior.this.dqz;
                }
                else
                {
                  i = BottomSheetBehavior.this.dqB;
                  j = 4;
                }
              }
              else if (i < BottomSheetBehavior.this.dqA)
              {
                if (i < Math.abs(i - BottomSheetBehavior.this.dqB))
                {
                  i = 0;
                }
                else
                {
                  i = BottomSheetBehavior.this.dqA;
                  j = 6;
                }
              }
              else if (Math.abs(i - BottomSheetBehavior.this.dqA) < Math.abs(i - BottomSheetBehavior.this.dqB))
              {
                i = BottomSheetBehavior.this.dqA;
                j = 6;
              }
              else
              {
                i = BottomSheetBehavior.this.dqB;
                j = 4;
              }
            }
            else
            {
              i = BottomSheetBehavior.this.dqB;
              j = 4;
            }
          }
        }
        BottomSheetBehavior.this.D(j);
        AppMethodBeat.o(209491);
      }
      
      public final boolean b(View paramAnonymousView, int paramAnonymousInt)
      {
        AppMethodBeat.i(209458);
        if (BottomSheetBehavior.this.state == 1)
        {
          AppMethodBeat.o(209458);
          return false;
        }
        if (BottomSheetBehavior.this.dqL)
        {
          AppMethodBeat.o(209458);
          return false;
        }
        if ((BottomSheetBehavior.this.state == 3) && (BottomSheetBehavior.this.doI == paramAnonymousInt))
        {
          View localView = (View)BottomSheetBehavior.this.dqI.get();
          if ((localView != null) && (localView.canScrollVertically(-1)))
          {
            AppMethodBeat.o(209458);
            return false;
          }
        }
        if ((BottomSheetBehavior.this.viewRef != null) && (BottomSheetBehavior.this.viewRef.get() == paramAnonymousView))
        {
          AppMethodBeat.o(209458);
          return true;
        }
        AppMethodBeat.o(209458);
        return false;
      }
      
      public final int c(View paramAnonymousView, int paramAnonymousInt)
      {
        AppMethodBeat.i(209505);
        int j = BottomSheetBehavior.b(BottomSheetBehavior.this);
        if (BottomSheetBehavior.this.dqC) {}
        for (int i = BottomSheetBehavior.this.dqH;; i = BottomSheetBehavior.this.dqB)
        {
          paramAnonymousInt = a.clamp(paramAnonymousInt, j, i);
          AppMethodBeat.o(209505);
          return paramAnonymousInt;
        }
      }
      
      public final int d(View paramAnonymousView, int paramAnonymousInt)
      {
        AppMethodBeat.i(209517);
        paramAnonymousInt = paramAnonymousView.getLeft();
        AppMethodBeat.o(209517);
        return paramAnonymousInt;
      }
    };
    AppMethodBeat.o(209463);
  }
  
  public BottomSheetBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(209478);
    this.dqt = true;
    this.state = 4;
    this.dpl = new c.a()
    {
      public final void F(int paramAnonymousInt)
      {
        AppMethodBeat.i(209480);
        if (paramAnonymousInt == 1) {
          BottomSheetBehavior.this.D(1);
        }
        AppMethodBeat.o(209480);
      }
      
      public final void a(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(209466);
        BottomSheetBehavior.this.E(paramAnonymousInt2);
        AppMethodBeat.o(209466);
      }
      
      public final int aM()
      {
        if (BottomSheetBehavior.this.dqC) {
          return BottomSheetBehavior.this.dqH;
        }
        return BottomSheetBehavior.this.dqB;
      }
      
      public final void b(View paramAnonymousView, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        int j = 3;
        AppMethodBeat.i(209491);
        int i;
        if (paramAnonymousFloat2 < 0.0F) {
          if (BottomSheetBehavior.a(BottomSheetBehavior.this)) {
            i = BottomSheetBehavior.this.dqz;
          }
        }
        while (BottomSheetBehavior.this.dpd.aD(paramAnonymousView.getLeft(), i))
        {
          BottomSheetBehavior.this.D(2);
          z.b(paramAnonymousView, new BottomSheetBehavior.b(BottomSheetBehavior.this, paramAnonymousView, j));
          AppMethodBeat.o(209491);
          return;
          if (paramAnonymousView.getTop() > BottomSheetBehavior.this.dqA)
          {
            i = BottomSheetBehavior.this.dqA;
            j = 6;
          }
          else
          {
            i = 0;
            continue;
            if ((BottomSheetBehavior.this.dqC) && (BottomSheetBehavior.this.b(paramAnonymousView, paramAnonymousFloat2)) && ((paramAnonymousView.getTop() > BottomSheetBehavior.this.dqB) || (Math.abs(paramAnonymousFloat1) < Math.abs(paramAnonymousFloat2))))
            {
              i = BottomSheetBehavior.this.dqH;
              j = 5;
            }
            else if ((paramAnonymousFloat2 == 0.0F) || (Math.abs(paramAnonymousFloat1) > Math.abs(paramAnonymousFloat2)))
            {
              i = paramAnonymousView.getTop();
              if (BottomSheetBehavior.a(BottomSheetBehavior.this))
              {
                if (Math.abs(i - BottomSheetBehavior.this.dqz) < Math.abs(i - BottomSheetBehavior.this.dqB))
                {
                  i = BottomSheetBehavior.this.dqz;
                }
                else
                {
                  i = BottomSheetBehavior.this.dqB;
                  j = 4;
                }
              }
              else if (i < BottomSheetBehavior.this.dqA)
              {
                if (i < Math.abs(i - BottomSheetBehavior.this.dqB))
                {
                  i = 0;
                }
                else
                {
                  i = BottomSheetBehavior.this.dqA;
                  j = 6;
                }
              }
              else if (Math.abs(i - BottomSheetBehavior.this.dqA) < Math.abs(i - BottomSheetBehavior.this.dqB))
              {
                i = BottomSheetBehavior.this.dqA;
                j = 6;
              }
              else
              {
                i = BottomSheetBehavior.this.dqB;
                j = 4;
              }
            }
            else
            {
              i = BottomSheetBehavior.this.dqB;
              j = 4;
            }
          }
        }
        BottomSheetBehavior.this.D(j);
        AppMethodBeat.o(209491);
      }
      
      public final boolean b(View paramAnonymousView, int paramAnonymousInt)
      {
        AppMethodBeat.i(209458);
        if (BottomSheetBehavior.this.state == 1)
        {
          AppMethodBeat.o(209458);
          return false;
        }
        if (BottomSheetBehavior.this.dqL)
        {
          AppMethodBeat.o(209458);
          return false;
        }
        if ((BottomSheetBehavior.this.state == 3) && (BottomSheetBehavior.this.doI == paramAnonymousInt))
        {
          View localView = (View)BottomSheetBehavior.this.dqI.get();
          if ((localView != null) && (localView.canScrollVertically(-1)))
          {
            AppMethodBeat.o(209458);
            return false;
          }
        }
        if ((BottomSheetBehavior.this.viewRef != null) && (BottomSheetBehavior.this.viewRef.get() == paramAnonymousView))
        {
          AppMethodBeat.o(209458);
          return true;
        }
        AppMethodBeat.o(209458);
        return false;
      }
      
      public final int c(View paramAnonymousView, int paramAnonymousInt)
      {
        AppMethodBeat.i(209505);
        int j = BottomSheetBehavior.b(BottomSheetBehavior.this);
        if (BottomSheetBehavior.this.dqC) {}
        for (int i = BottomSheetBehavior.this.dqH;; i = BottomSheetBehavior.this.dqB)
        {
          paramAnonymousInt = a.clamp(paramAnonymousInt, j, i);
          AppMethodBeat.o(209505);
          return paramAnonymousInt;
        }
      }
      
      public final int d(View paramAnonymousView, int paramAnonymousInt)
      {
        AppMethodBeat.i(209517);
        paramAnonymousInt = paramAnonymousView.getLeft();
        AppMethodBeat.o(209517);
        return paramAnonymousInt;
      }
    };
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.BottomSheetBehavior_Layout);
    TypedValue localTypedValue = paramAttributeSet.peekValue(a.k.BottomSheetBehavior_Layout_behavior_peekHeight);
    if ((localTypedValue != null) && (localTypedValue.data == -1))
    {
      setPeekHeight(localTypedValue.data);
      this.dqC = paramAttributeSet.getBoolean(a.k.BottomSheetBehavior_Layout_behavior_hideable, false);
      boolean bool = paramAttributeSet.getBoolean(a.k.BottomSheetBehavior_Layout_behavior_fitToContents, true);
      if (this.dqt != bool)
      {
        this.dqt = bool;
        if (this.viewRef != null) {
          VM();
        }
        if ((!this.dqt) || (this.state != 6)) {
          break label194;
        }
      }
    }
    label194:
    for (int i = 3;; i = this.state)
    {
      D(i);
      this.dqD = paramAttributeSet.getBoolean(a.k.BottomSheetBehavior_Layout_behavior_skipCollapsed, false);
      paramAttributeSet.recycle();
      this.dqu = ViewConfiguration.get(paramContext).getScaledMaximumFlingVelocity();
      AppMethodBeat.o(209478);
      return;
      setPeekHeight(paramAttributeSet.getDimensionPixelSize(a.k.BottomSheetBehavior_Layout_behavior_peekHeight, -1));
      break;
    }
  }
  
  private void VM()
  {
    AppMethodBeat.i(209487);
    if (this.dqt)
    {
      this.dqB = Math.max(this.dqH - this.dqy, this.dqz);
      AppMethodBeat.o(209487);
      return;
    }
    this.dqB = (this.dqH - this.dqy);
    AppMethodBeat.o(209487);
  }
  
  private int VN()
  {
    if (this.dqt) {
      return this.dqz;
    }
    return 0;
  }
  
  private View b(View paramView)
  {
    AppMethodBeat.i(209508);
    if (z.ar(paramView))
    {
      AppMethodBeat.o(209508);
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
          AppMethodBeat.o(209508);
          return localView;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(209508);
    return null;
  }
  
  private void bL(boolean paramBoolean)
  {
    AppMethodBeat.i(209544);
    if (this.viewRef == null)
    {
      AppMethodBeat.o(209544);
      return;
    }
    Object localObject = ((View)this.viewRef.get()).getParent();
    if (!(localObject instanceof CoordinatorLayout))
    {
      AppMethodBeat.o(209544);
      return;
    }
    localObject = (CoordinatorLayout)localObject;
    int j = ((CoordinatorLayout)localObject).getChildCount();
    int i;
    View localView;
    if ((Build.VERSION.SDK_INT >= 16) && (paramBoolean))
    {
      if (this.dqM == null) {
        this.dqM = new HashMap(j);
      }
    }
    else
    {
      i = 0;
      if (i >= j) {
        break label215;
      }
      localView = ((CoordinatorLayout)localObject).getChildAt(i);
      if (localView != this.viewRef.get())
      {
        if (paramBoolean) {
          break label178;
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
      AppMethodBeat.o(209544);
      return;
      label178:
      if (Build.VERSION.SDK_INT >= 16) {
        this.dqM.put(localView, Integer.valueOf(localView.getImportantForAccessibility()));
      }
      z.p(localView, 4);
    }
    label215:
    if (!paramBoolean) {
      this.dqM = null;
    }
    AppMethodBeat.o(209544);
  }
  
  public static <V extends View> BottomSheetBehavior<V> cC(V paramV)
  {
    AppMethodBeat.i(209529);
    paramV = paramV.getLayoutParams();
    if (!(paramV instanceof CoordinatorLayout.d))
    {
      paramV = new IllegalArgumentException("The view is not a child of CoordinatorLayout");
      AppMethodBeat.o(209529);
      throw paramV;
    }
    paramV = ((CoordinatorLayout.d)paramV).bnr;
    if (!(paramV instanceof BottomSheetBehavior))
    {
      paramV = new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
      AppMethodBeat.o(209529);
      throw paramV;
    }
    paramV = (BottomSheetBehavior)paramV;
    AppMethodBeat.o(209529);
    return paramV;
  }
  
  private void reset()
  {
    AppMethodBeat.i(209497);
    this.doI = -1;
    if (this.doL != null)
    {
      this.doL.recycle();
      this.doL = null;
    }
    AppMethodBeat.o(209497);
  }
  
  final void D(int paramInt)
  {
    AppMethodBeat.i(209725);
    if (this.state == paramInt)
    {
      AppMethodBeat.o(209725);
      return;
    }
    this.state = paramInt;
    if ((paramInt == 6) || (paramInt == 3)) {
      bL(true);
    }
    for (;;)
    {
      View localView = (View)this.viewRef.get();
      if ((localView != null) && (this.dqJ != null)) {
        this.dqJ.e(localView, paramInt);
      }
      AppMethodBeat.o(209725);
      return;
      if ((paramInt == 5) || (paramInt == 4)) {
        bL(false);
      }
    }
  }
  
  final void E(int paramInt)
  {
    AppMethodBeat.i(209758);
    View localView = (View)this.viewRef.get();
    if ((localView != null) && (this.dqJ != null))
    {
      if (paramInt > this.dqB)
      {
        this.dqJ.cD(localView);
        AppMethodBeat.o(209758);
        return;
      }
      BottomSheetBehavior.a locala = this.dqJ;
      VN();
      locala.cD(localView);
    }
    AppMethodBeat.o(209758);
  }
  
  public final Parcelable a(CoordinatorLayout paramCoordinatorLayout, V paramV)
  {
    AppMethodBeat.i(209580);
    paramCoordinatorLayout = new SavedState(super.a(paramCoordinatorLayout, paramV), this.state);
    AppMethodBeat.o(209580);
    return paramCoordinatorLayout;
  }
  
  final void a(View paramView, int paramInt)
  {
    AppMethodBeat.i(209746);
    int i;
    int j;
    if (paramInt == 4)
    {
      i = this.dqB;
      j = paramInt;
    }
    while (this.dpd.f(paramView, paramView.getLeft(), i))
    {
      D(2);
      z.b(paramView, new b(paramView, j));
      AppMethodBeat.o(209746);
      return;
      if (paramInt == 6)
      {
        int k = this.dqA;
        i = k;
        j = paramInt;
        if (this.dqt)
        {
          i = k;
          j = paramInt;
          if (k <= this.dqz)
          {
            i = this.dqz;
            j = 3;
          }
        }
      }
      else if (paramInt == 3)
      {
        i = VN();
        j = paramInt;
      }
      else if ((this.dqC) && (paramInt == 5))
      {
        i = this.dqH;
        j = paramInt;
      }
      else
      {
        paramView = new IllegalArgumentException("Illegal state argument: ".concat(String.valueOf(paramInt)));
        AppMethodBeat.o(209746);
        throw paramView;
      }
    }
    D(j);
    AppMethodBeat.o(209746);
  }
  
  public final void a(CoordinatorLayout paramCoordinatorLayout, V paramV, Parcelable paramParcelable)
  {
    AppMethodBeat.i(209594);
    paramParcelable = (SavedState)paramParcelable;
    super.a(paramCoordinatorLayout, paramV, paramParcelable.bxs);
    if ((paramParcelable.state == 1) || (paramParcelable.state == 2))
    {
      this.state = 4;
      AppMethodBeat.o(209594);
      return;
    }
    this.state = paramParcelable.state;
    AppMethodBeat.o(209594);
  }
  
  public final void a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, int paramInt)
  {
    AppMethodBeat.i(209678);
    if (paramV.getTop() == VN())
    {
      D(3);
      AppMethodBeat.o(209678);
      return;
    }
    if ((paramView != this.dqI.get()) || (!this.dqG))
    {
      AppMethodBeat.o(209678);
      return;
    }
    int i;
    if (this.dqF > 0)
    {
      i = VN();
      paramInt = 3;
      if (!this.dpd.f(paramV, paramV.getLeft(), i)) {
        break label361;
      }
      D(2);
      z.b(paramV, new b(paramV, paramInt));
    }
    for (;;)
    {
      this.dqG = false;
      AppMethodBeat.o(209678);
      return;
      if (this.dqC)
      {
        if (this.doL == null) {}
        for (float f = 0.0F;; f = this.doL.getYVelocity(this.doI))
        {
          if (!b(paramV, f)) {
            break label188;
          }
          i = this.dqH;
          paramInt = 5;
          break;
          this.doL.computeCurrentVelocity(1000, this.dqu);
        }
      }
      label188:
      if (this.dqF == 0)
      {
        paramInt = paramV.getTop();
        if (this.dqt)
        {
          if (Math.abs(paramInt - this.dqz) < Math.abs(paramInt - this.dqB))
          {
            i = this.dqz;
            paramInt = 3;
            break;
          }
          i = this.dqB;
          paramInt = 4;
          break;
        }
        if (paramInt < this.dqA)
        {
          if (paramInt < Math.abs(paramInt - this.dqB))
          {
            paramInt = 3;
            i = 0;
            break;
          }
          i = this.dqA;
          paramInt = 6;
          break;
        }
        if (Math.abs(paramInt - this.dqA) < Math.abs(paramInt - this.dqB))
        {
          i = this.dqA;
          paramInt = 6;
          break;
        }
        i = this.dqB;
        paramInt = 4;
        break;
      }
      i = this.dqB;
      paramInt = 4;
      break;
      label361:
      D(paramInt);
    }
  }
  
  public final void a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    AppMethodBeat.i(209661);
    if (paramInt3 == 1)
    {
      AppMethodBeat.o(209661);
      return;
    }
    if (paramView != (View)this.dqI.get())
    {
      AppMethodBeat.o(209661);
      return;
    }
    paramInt1 = paramV.getTop();
    paramInt3 = paramInt1 - paramInt2;
    if (paramInt2 > 0) {
      if (paramInt3 < VN())
      {
        paramArrayOfInt[1] = (paramInt1 - VN());
        z.s(paramV, -paramArrayOfInt[1]);
        D(3);
      }
    }
    for (;;)
    {
      E(paramV.getTop());
      this.dqF = paramInt2;
      this.dqG = true;
      AppMethodBeat.o(209661);
      return;
      paramArrayOfInt[1] = paramInt2;
      z.s(paramV, -paramInt2);
      D(1);
      continue;
      if ((paramInt2 < 0) && (!paramView.canScrollVertically(-1))) {
        if ((paramInt3 <= this.dqB) || (this.dqC))
        {
          paramArrayOfInt[1] = paramInt2;
          z.s(paramV, -paramInt2);
          D(1);
        }
        else
        {
          paramArrayOfInt[1] = (paramInt1 - this.dqB);
          z.s(paramV, -paramArrayOfInt[1]);
          D(4);
        }
      }
    }
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
  {
    AppMethodBeat.i(209607);
    if ((z.al(paramCoordinatorLayout)) && (!z.al(paramV))) {
      paramV.setFitsSystemWindows(true);
    }
    int i = paramV.getTop();
    paramCoordinatorLayout.h(paramV, paramInt);
    this.dqH = paramCoordinatorLayout.getHeight();
    if (this.dqw)
    {
      if (this.dqx == 0) {
        this.dqx = paramCoordinatorLayout.getResources().getDimensionPixelSize(a.d.design_bottom_sheet_peek_height_min);
      }
      this.dqy = Math.max(this.dqx, this.dqH - paramCoordinatorLayout.getWidth() * 9 / 16);
      this.dqz = Math.max(0, this.dqH - paramV.getHeight());
      this.dqA = (this.dqH / 2);
      VM();
      if (this.state != 3) {
        break label212;
      }
      z.s(paramV, VN());
    }
    for (;;)
    {
      if (this.dpd == null) {
        this.dpd = c.a(paramCoordinatorLayout, this.dpl);
      }
      this.viewRef = new WeakReference(paramV);
      this.dqI = new WeakReference(b(paramV));
      AppMethodBeat.o(209607);
      return true;
      this.dqy = this.dqv;
      break;
      label212:
      if (this.state == 6) {
        z.s(paramV, this.dqA);
      } else if ((this.dqC) && (this.state == 5)) {
        z.s(paramV, this.dqH);
      } else if (this.state == 4) {
        z.s(paramV, this.dqB);
      } else if ((this.state == 1) || (this.state == 2)) {
        z.s(paramV, i - paramV.getTop());
      }
    }
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(209621);
    if (!paramV.isShown())
    {
      this.dqE = true;
      AppMethodBeat.o(209621);
      return false;
    }
    int i = paramMotionEvent.getActionMasked();
    if (i == 0) {
      reset();
    }
    if (this.doL == null) {
      this.doL = VelocityTracker.obtain();
    }
    this.doL.addMovement(paramMotionEvent);
    switch (i)
    {
    }
    while ((!this.dqE) && (this.dpd != null) && (this.dpd.i(paramMotionEvent)))
    {
      AppMethodBeat.o(209621);
      return true;
      this.dqL = false;
      this.doI = -1;
      if (this.dqE)
      {
        this.dqE = false;
        AppMethodBeat.o(209621);
        return false;
        int j = (int)paramMotionEvent.getX();
        this.dqK = ((int)paramMotionEvent.getY());
        View localView;
        if (this.dqI != null)
        {
          localView = (View)this.dqI.get();
          label194:
          if ((localView != null) && (paramCoordinatorLayout.d(localView, j, this.dqK)))
          {
            this.doI = paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex());
            this.dqL = true;
          }
          if ((this.doI != -1) || (paramCoordinatorLayout.d(paramV, j, this.dqK))) {
            break label271;
          }
        }
        label271:
        for (boolean bool = true;; bool = false)
        {
          this.dqE = bool;
          break;
          localView = null;
          break label194;
        }
      }
    }
    if (this.dqI != null) {}
    for (paramV = (View)this.dqI.get(); (i == 2) && (paramV != null) && (!this.dqE) && (this.state != 1) && (!paramCoordinatorLayout.d(paramV, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) && (this.dpd != null) && (Math.abs(this.dqK - paramMotionEvent.getY()) > this.dpd.mTouchSlop); paramV = null)
    {
      AppMethodBeat.o(209621);
      return true;
    }
    AppMethodBeat.o(209621);
    return false;
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(209689);
    if ((paramView == this.dqI.get()) && ((this.state != 3) || (super.a(paramCoordinatorLayout, paramV, paramView, paramFloat1, paramFloat2))))
    {
      AppMethodBeat.o(209689);
      return true;
    }
    AppMethodBeat.o(209689);
    return false;
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    this.dqF = 0;
    this.dqG = false;
    if ((paramInt1 & 0x2) != 0) {
      bool = true;
    }
    return bool;
  }
  
  final boolean b(View paramView, float paramFloat)
  {
    AppMethodBeat.i(209734);
    if (this.dqD)
    {
      AppMethodBeat.o(209734);
      return true;
    }
    if (paramView.getTop() < this.dqB)
    {
      AppMethodBeat.o(209734);
      return false;
    }
    if (Math.abs(paramView.getTop() + 0.1F * paramFloat - this.dqB) / this.dqv > 0.5F)
    {
      AppMethodBeat.o(209734);
      return true;
    }
    AppMethodBeat.o(209734);
    return false;
  }
  
  public final boolean b(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(209637);
    if (!paramV.isShown())
    {
      AppMethodBeat.o(209637);
      return false;
    }
    int i = paramMotionEvent.getActionMasked();
    if ((this.state == 1) && (i == 0))
    {
      AppMethodBeat.o(209637);
      return true;
    }
    if (this.dpd != null) {
      this.dpd.j(paramMotionEvent);
    }
    if (i == 0) {
      reset();
    }
    if (this.doL == null) {
      this.doL = VelocityTracker.obtain();
    }
    this.doL.addMovement(paramMotionEvent);
    if ((i == 2) && (!this.dqE) && (Math.abs(this.dqK - paramMotionEvent.getY()) > this.dpd.mTouchSlop)) {
      this.dpd.B(paramV, paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex()));
    }
    if (!this.dqE)
    {
      AppMethodBeat.o(209637);
      return true;
    }
    AppMethodBeat.o(209637);
    return false;
  }
  
  public final void setPeekHeight(int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(209700);
    if (paramInt == -1)
    {
      if (this.dqw) {
        break label116;
      }
      this.dqw = true;
      paramInt = i;
    }
    for (;;)
    {
      if ((paramInt != 0) && (this.state == 4) && (this.viewRef != null))
      {
        View localView = (View)this.viewRef.get();
        if (localView != null) {
          localView.requestLayout();
        }
      }
      AppMethodBeat.o(209700);
      return;
      if ((this.dqw) || (this.dqv != paramInt))
      {
        this.dqw = false;
        this.dqv = Math.max(0, paramInt);
        this.dqB = (this.dqH - paramInt);
        paramInt = i;
      }
      else
      {
        label116:
        paramInt = 0;
      }
    }
  }
  
  public final void setState(int paramInt)
  {
    AppMethodBeat.i(209715);
    if (paramInt == this.state)
    {
      AppMethodBeat.o(209715);
      return;
    }
    if (this.viewRef == null)
    {
      if ((paramInt == 4) || (paramInt == 3) || (paramInt == 6) || ((this.dqC) && (paramInt == 5))) {
        this.state = paramInt;
      }
      AppMethodBeat.o(209715);
      return;
    }
    View localView = (View)this.viewRef.get();
    if (localView == null)
    {
      AppMethodBeat.o(209715);
      return;
    }
    ViewParent localViewParent = localView.getParent();
    if ((localViewParent != null) && (localViewParent.isLayoutRequested()) && (z.ay(localView)))
    {
      localView.post(new BottomSheetBehavior.1(this, localView, paramInt));
      AppMethodBeat.o(209715);
      return;
    }
    a(localView, paramInt);
    AppMethodBeat.o(209715);
  }
  
  protected static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    final int state;
    
    static
    {
      AppMethodBeat.i(209474);
      CREATOR = new Parcelable.ClassLoaderCreator() {};
      AppMethodBeat.o(209474);
    }
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      AppMethodBeat.i(209451);
      this.state = paramParcel.readInt();
      AppMethodBeat.o(209451);
    }
    
    public SavedState(Parcelable paramParcelable, int paramInt)
    {
      super();
      this.state = paramInt;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(209484);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.state);
      AppMethodBeat.o(209484);
    }
  }
  
  final class b
    implements Runnable
  {
    private final int dqP;
    private final View view;
    
    b(View paramView, int paramInt)
    {
      this.view = paramView;
      this.dqP = paramInt;
    }
    
    public final void run()
    {
      AppMethodBeat.i(209473);
      if ((BottomSheetBehavior.this.dpd != null) && (BottomSheetBehavior.this.dpd.Fx()))
      {
        z.b(this.view, this);
        AppMethodBeat.o(209473);
        return;
      }
      BottomSheetBehavior.this.D(this.dqP);
      AppMethodBeat.o(209473);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.bottomsheet.BottomSheetBehavior
 * JD-Core Version:    0.7.0.1
 */