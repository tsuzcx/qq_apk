package androidx.core.g;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class z
{
  public static void a(ViewParent paramViewParent, View paramView, int paramInt)
  {
    AppMethodBeat.i(251812);
    if ((paramViewParent instanceof p))
    {
      ((p)paramViewParent).l(paramView, paramInt);
      AppMethodBeat.o(251812);
      return;
    }
    if (paramInt == 0)
    {
      if (Build.VERSION.SDK_INT >= 21) {
        try
        {
          paramViewParent.onStopNestedScroll(paramView);
          AppMethodBeat.o(251812);
          return;
        }
        catch (AbstractMethodError paramView)
        {
          new StringBuilder("ViewParent ").append(paramViewParent).append(" does not implement interface method onStopNestedScroll");
          AppMethodBeat.o(251812);
          return;
        }
      }
      if ((paramViewParent instanceof o)) {
        ((o)paramViewParent).onStopNestedScroll(paramView);
      }
    }
    AppMethodBeat.o(251812);
  }
  
  public static void a(ViewParent paramViewParent, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(251813);
    if ((paramViewParent instanceof q))
    {
      ((q)paramViewParent).b(paramInt4, paramInt5, paramArrayOfInt);
      AppMethodBeat.o(251813);
      return;
    }
    paramArrayOfInt[0] += paramInt3;
    paramArrayOfInt[1] += paramInt4;
    if ((paramViewParent instanceof p))
    {
      ((p)paramViewParent).a(paramView, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
      AppMethodBeat.o(251813);
      return;
    }
    if (paramInt5 == 0)
    {
      if (Build.VERSION.SDK_INT >= 21) {
        try
        {
          paramViewParent.onNestedScroll(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
          AppMethodBeat.o(251813);
          return;
        }
        catch (AbstractMethodError paramView)
        {
          new StringBuilder("ViewParent ").append(paramViewParent).append(" does not implement interface method onNestedScroll");
          AppMethodBeat.o(251813);
          return;
        }
      }
      if ((paramViewParent instanceof o)) {
        ((o)paramViewParent).onNestedScroll(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
      }
    }
    AppMethodBeat.o(251813);
  }
  
  public static void a(ViewParent paramViewParent, View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    AppMethodBeat.i(251814);
    if ((paramViewParent instanceof p))
    {
      ((p)paramViewParent).a(paramView, paramInt1, paramInt2, paramArrayOfInt, paramInt3);
      AppMethodBeat.o(251814);
      return;
    }
    if (paramInt3 == 0)
    {
      if (Build.VERSION.SDK_INT >= 21) {
        try
        {
          paramViewParent.onNestedPreScroll(paramView, paramInt1, paramInt2, paramArrayOfInt);
          AppMethodBeat.o(251814);
          return;
        }
        catch (AbstractMethodError paramView)
        {
          new StringBuilder("ViewParent ").append(paramViewParent).append(" does not implement interface method onNestedPreScroll");
          AppMethodBeat.o(251814);
          return;
        }
      }
      if ((paramViewParent instanceof o)) {
        ((o)paramViewParent).onNestedPreScroll(paramView, paramInt1, paramInt2, paramArrayOfInt);
      }
    }
    AppMethodBeat.o(251814);
  }
  
  public static boolean a(ViewParent paramViewParent, View paramView, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(251816);
    if (Build.VERSION.SDK_INT >= 21) {
      try
      {
        bool = paramViewParent.onNestedPreFling(paramView, paramFloat1, paramFloat2);
        AppMethodBeat.o(251816);
        return bool;
      }
      catch (AbstractMethodError paramView)
      {
        new StringBuilder("ViewParent ").append(paramViewParent).append(" does not implement interface method onNestedPreFling");
      }
    }
    while (!(paramViewParent instanceof o))
    {
      AppMethodBeat.o(251816);
      return false;
    }
    boolean bool = ((o)paramViewParent).onNestedPreFling(paramView, paramFloat1, paramFloat2);
    AppMethodBeat.o(251816);
    return bool;
  }
  
  public static boolean a(ViewParent paramViewParent, View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(251815);
    if (Build.VERSION.SDK_INT >= 21) {
      try
      {
        paramBoolean = paramViewParent.onNestedFling(paramView, paramFloat1, paramFloat2, paramBoolean);
        AppMethodBeat.o(251815);
        return paramBoolean;
      }
      catch (AbstractMethodError paramView)
      {
        new StringBuilder("ViewParent ").append(paramViewParent).append(" does not implement interface method onNestedFling");
      }
    }
    while (!(paramViewParent instanceof o))
    {
      AppMethodBeat.o(251815);
      return false;
    }
    paramBoolean = ((o)paramViewParent).onNestedFling(paramView, paramFloat1, paramFloat2, paramBoolean);
    AppMethodBeat.o(251815);
    return paramBoolean;
  }
  
  public static boolean a(ViewParent paramViewParent, View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(251809);
    if ((paramViewParent instanceof p))
    {
      bool = ((p)paramViewParent).a(paramView1, paramView2, paramInt1, paramInt2);
      AppMethodBeat.o(251809);
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
        AppMethodBeat.o(251809);
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
      AppMethodBeat.o(251809);
      return false;
    }
    boolean bool = ((o)paramViewParent).onStartNestedScroll(paramView1, paramView2, paramInt1);
    AppMethodBeat.o(251809);
    return bool;
  }
  
  @Deprecated
  public static boolean a(ViewParent paramViewParent, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(251807);
    boolean bool = paramViewParent.requestSendAccessibilityEvent(paramView, paramAccessibilityEvent);
    AppMethodBeat.o(251807);
    return bool;
  }
  
  public static void b(ViewParent paramViewParent, View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(251811);
    if ((paramViewParent instanceof p))
    {
      ((p)paramViewParent).b(paramView1, paramView2, paramInt1, paramInt2);
      AppMethodBeat.o(251811);
      return;
    }
    if (paramInt2 == 0)
    {
      if (Build.VERSION.SDK_INT >= 21) {
        try
        {
          paramViewParent.onNestedScrollAccepted(paramView1, paramView2, paramInt1);
          AppMethodBeat.o(251811);
          return;
        }
        catch (AbstractMethodError paramView1)
        {
          new StringBuilder("ViewParent ").append(paramViewParent).append(" does not implement interface method onNestedScrollAccepted");
          AppMethodBeat.o(251811);
          return;
        }
      }
      if ((paramViewParent instanceof o)) {
        ((o)paramViewParent).onNestedScrollAccepted(paramView1, paramView2, paramInt1);
      }
    }
    AppMethodBeat.o(251811);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.core.g.z
 * JD-Core Version:    0.7.0.1
 */