package androidx.core.g;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ac
{
  public static void a(ViewParent paramViewParent, View paramView, int paramInt)
  {
    AppMethodBeat.i(195794);
    if ((paramViewParent instanceof p))
    {
      ((p)paramViewParent).l(paramView, paramInt);
      AppMethodBeat.o(195794);
      return;
    }
    if (paramInt == 0)
    {
      if (Build.VERSION.SDK_INT >= 21) {
        try
        {
          paramViewParent.onStopNestedScroll(paramView);
          AppMethodBeat.o(195794);
          return;
        }
        catch (AbstractMethodError paramView)
        {
          new StringBuilder("ViewParent ").append(paramViewParent).append(" does not implement interface method onStopNestedScroll");
          AppMethodBeat.o(195794);
          return;
        }
      }
      if ((paramViewParent instanceof o)) {
        ((o)paramViewParent).onStopNestedScroll(paramView);
      }
    }
    AppMethodBeat.o(195794);
  }
  
  public static void a(ViewParent paramViewParent, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(195807);
    if ((paramViewParent instanceof q))
    {
      ((q)paramViewParent).b(paramInt4, paramInt5, paramArrayOfInt);
      AppMethodBeat.o(195807);
      return;
    }
    paramArrayOfInt[0] += paramInt3;
    paramArrayOfInt[1] += paramInt4;
    if ((paramViewParent instanceof p))
    {
      ((p)paramViewParent).a(paramView, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
      AppMethodBeat.o(195807);
      return;
    }
    if (paramInt5 == 0)
    {
      if (Build.VERSION.SDK_INT >= 21) {
        try
        {
          paramViewParent.onNestedScroll(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
          AppMethodBeat.o(195807);
          return;
        }
        catch (AbstractMethodError paramView)
        {
          new StringBuilder("ViewParent ").append(paramViewParent).append(" does not implement interface method onNestedScroll");
          AppMethodBeat.o(195807);
          return;
        }
      }
      if ((paramViewParent instanceof o)) {
        ((o)paramViewParent).onNestedScroll(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
      }
    }
    AppMethodBeat.o(195807);
  }
  
  public static void a(ViewParent paramViewParent, View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    AppMethodBeat.i(195823);
    if ((paramViewParent instanceof p))
    {
      ((p)paramViewParent).a(paramView, paramInt1, paramInt2, paramArrayOfInt, paramInt3);
      AppMethodBeat.o(195823);
      return;
    }
    if (paramInt3 == 0)
    {
      if (Build.VERSION.SDK_INT >= 21) {
        try
        {
          paramViewParent.onNestedPreScroll(paramView, paramInt1, paramInt2, paramArrayOfInt);
          AppMethodBeat.o(195823);
          return;
        }
        catch (AbstractMethodError paramView)
        {
          new StringBuilder("ViewParent ").append(paramViewParent).append(" does not implement interface method onNestedPreScroll");
          AppMethodBeat.o(195823);
          return;
        }
      }
      if ((paramViewParent instanceof o)) {
        ((o)paramViewParent).onNestedPreScroll(paramView, paramInt1, paramInt2, paramArrayOfInt);
      }
    }
    AppMethodBeat.o(195823);
  }
  
  public static boolean a(ViewParent paramViewParent, View paramView, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(195843);
    if (Build.VERSION.SDK_INT >= 21) {
      try
      {
        bool = paramViewParent.onNestedPreFling(paramView, paramFloat1, paramFloat2);
        AppMethodBeat.o(195843);
        return bool;
      }
      catch (AbstractMethodError paramView)
      {
        new StringBuilder("ViewParent ").append(paramViewParent).append(" does not implement interface method onNestedPreFling");
      }
    }
    while (!(paramViewParent instanceof o))
    {
      AppMethodBeat.o(195843);
      return false;
    }
    boolean bool = ((o)paramViewParent).onNestedPreFling(paramView, paramFloat1, paramFloat2);
    AppMethodBeat.o(195843);
    return bool;
  }
  
  public static boolean a(ViewParent paramViewParent, View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(195834);
    if (Build.VERSION.SDK_INT >= 21) {
      try
      {
        paramBoolean = paramViewParent.onNestedFling(paramView, paramFloat1, paramFloat2, paramBoolean);
        AppMethodBeat.o(195834);
        return paramBoolean;
      }
      catch (AbstractMethodError paramView)
      {
        new StringBuilder("ViewParent ").append(paramViewParent).append(" does not implement interface method onNestedFling");
      }
    }
    while (!(paramViewParent instanceof o))
    {
      AppMethodBeat.o(195834);
      return false;
    }
    paramBoolean = ((o)paramViewParent).onNestedFling(paramView, paramFloat1, paramFloat2, paramBoolean);
    AppMethodBeat.o(195834);
    return paramBoolean;
  }
  
  public static boolean a(ViewParent paramViewParent, View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(195768);
    if ((paramViewParent instanceof p))
    {
      bool = ((p)paramViewParent).a(paramView1, paramView2, paramInt1, paramInt2);
      AppMethodBeat.o(195768);
      return bool;
    }
    if (paramInt2 == 0)
    {
      if (Build.VERSION.SDK_INT < 21) {
        break label95;
      }
      try
      {
        bool = paramViewParent.onStartNestedScroll(paramView1, paramView2, paramInt1);
        AppMethodBeat.o(195768);
        return bool;
      }
      catch (AbstractMethodError paramView1)
      {
        new StringBuilder("ViewParent ").append(paramViewParent).append(" does not implement interface method onStartNestedScroll");
      }
    }
    label95:
    while (!(paramViewParent instanceof o))
    {
      AppMethodBeat.o(195768);
      return false;
    }
    boolean bool = ((o)paramViewParent).onStartNestedScroll(paramView1, paramView2, paramInt1);
    AppMethodBeat.o(195768);
    return bool;
  }
  
  @Deprecated
  public static boolean a(ViewParent paramViewParent, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(195746);
    boolean bool = paramViewParent.requestSendAccessibilityEvent(paramView, paramAccessibilityEvent);
    AppMethodBeat.o(195746);
    return bool;
  }
  
  public static void b(ViewParent paramViewParent, View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(195781);
    if ((paramViewParent instanceof p))
    {
      ((p)paramViewParent).b(paramView1, paramView2, paramInt1, paramInt2);
      AppMethodBeat.o(195781);
      return;
    }
    if (paramInt2 == 0)
    {
      if (Build.VERSION.SDK_INT >= 21) {
        try
        {
          paramViewParent.onNestedScrollAccepted(paramView1, paramView2, paramInt1);
          AppMethodBeat.o(195781);
          return;
        }
        catch (AbstractMethodError paramView1)
        {
          new StringBuilder("ViewParent ").append(paramViewParent).append(" does not implement interface method onNestedScrollAccepted");
          AppMethodBeat.o(195781);
          return;
        }
      }
      if ((paramViewParent instanceof o)) {
        ((o)paramViewParent).onNestedScrollAccepted(paramView1, paramView2, paramInt1);
      }
    }
    AppMethodBeat.o(195781);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.core.g.ac
 * JD-Core Version:    0.7.0.1
 */