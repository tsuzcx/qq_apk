package androidx.customview.a;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;

final class b
{
  private static int H(int paramInt1, int paramInt2)
  {
    return paramInt1 * 13 * paramInt1 + paramInt2 * paramInt2;
  }
  
  public static <L, T> T a(L paramL, b<L, T> paramb, a<T> parama, T paramT, Rect paramRect, int paramInt)
  {
    AppMethodBeat.i(197736);
    Rect localRect1 = new Rect(paramRect);
    Object localObject1;
    Rect localRect2;
    int j;
    label114:
    int i;
    switch (paramInt)
    {
    default: 
      paramL = new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
      AppMethodBeat.o(197736);
      throw paramL;
    case 17: 
      localRect1.offset(paramRect.width() + 1, 0);
      localObject1 = null;
      int k = paramb.E(paramL);
      localRect2 = new Rect();
      j = 0;
      if (j < k)
      {
        Object localObject2 = paramb.b(paramL, j);
        if (localObject2 == paramT) {
          break label349;
        }
        parama.a(localObject2, localRect2);
        if (a(paramRect, localRect2, paramInt)) {
          if (!a(paramRect, localRect1, paramInt))
          {
            i = 1;
            label175:
            if (i == 0) {
              break label349;
            }
            localRect1.set(localRect2);
            localObject1 = localObject2;
          }
        }
      }
      break;
    }
    label349:
    for (;;)
    {
      j += 1;
      break label114;
      localRect1.offset(-(paramRect.width() + 1), 0);
      break;
      localRect1.offset(0, paramRect.height() + 1);
      break;
      localRect1.offset(0, -(paramRect.height() + 1));
      break;
      if (a(paramInt, paramRect, localRect2, localRect1))
      {
        i = 1;
        break label175;
      }
      if ((!a(paramInt, paramRect, localRect1, localRect2)) && (H(c(paramInt, paramRect, localRect2), g(paramInt, paramRect, localRect2)) < H(c(paramInt, paramRect, localRect1), g(paramInt, paramRect, localRect1))))
      {
        i = 1;
        break label175;
      }
      i = 0;
      break label175;
      AppMethodBeat.o(197736);
      return localObject1;
    }
  }
  
  private static boolean a(int paramInt, Rect paramRect1, Rect paramRect2)
  {
    AppMethodBeat.i(197751);
    switch (paramInt)
    {
    default: 
      paramRect1 = new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
      AppMethodBeat.o(197751);
      throw paramRect1;
    case 17: 
    case 66: 
      if ((paramRect2.bottom >= paramRect1.top) && (paramRect2.top <= paramRect1.bottom))
      {
        AppMethodBeat.o(197751);
        return true;
      }
      AppMethodBeat.o(197751);
      return false;
    }
    if ((paramRect2.right >= paramRect1.left) && (paramRect2.left <= paramRect1.right))
    {
      AppMethodBeat.o(197751);
      return true;
    }
    AppMethodBeat.o(197751);
    return false;
  }
  
  private static boolean a(int paramInt, Rect paramRect1, Rect paramRect2, Rect paramRect3)
  {
    AppMethodBeat.i(197737);
    boolean bool = a(paramInt, paramRect1, paramRect2);
    if ((a(paramInt, paramRect1, paramRect3)) || (!bool))
    {
      AppMethodBeat.o(197737);
      return false;
    }
    if (!b(paramInt, paramRect1, paramRect3))
    {
      AppMethodBeat.o(197737);
      return true;
    }
    if ((paramInt == 17) || (paramInt == 66))
    {
      AppMethodBeat.o(197737);
      return true;
    }
    if (c(paramInt, paramRect1, paramRect2) < e(paramInt, paramRect1, paramRect3))
    {
      AppMethodBeat.o(197737);
      return true;
    }
    AppMethodBeat.o(197737);
    return false;
  }
  
  private static boolean a(Rect paramRect1, Rect paramRect2, int paramInt)
  {
    AppMethodBeat.i(197745);
    switch (paramInt)
    {
    default: 
      paramRect1 = new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
      AppMethodBeat.o(197745);
      throw paramRect1;
    case 17: 
      if (((paramRect1.right > paramRect2.right) || (paramRect1.left >= paramRect2.right)) && (paramRect1.left > paramRect2.left))
      {
        AppMethodBeat.o(197745);
        return true;
      }
      AppMethodBeat.o(197745);
      return false;
    case 66: 
      if (((paramRect1.left < paramRect2.left) || (paramRect1.right <= paramRect2.left)) && (paramRect1.right < paramRect2.right))
      {
        AppMethodBeat.o(197745);
        return true;
      }
      AppMethodBeat.o(197745);
      return false;
    case 33: 
      if (((paramRect1.bottom > paramRect2.bottom) || (paramRect1.top >= paramRect2.bottom)) && (paramRect1.top > paramRect2.top))
      {
        AppMethodBeat.o(197745);
        return true;
      }
      AppMethodBeat.o(197745);
      return false;
    }
    if (((paramRect1.top < paramRect2.top) || (paramRect1.bottom <= paramRect2.top)) && (paramRect1.bottom < paramRect2.bottom))
    {
      AppMethodBeat.o(197745);
      return true;
    }
    AppMethodBeat.o(197745);
    return false;
  }
  
  private static boolean b(int paramInt, Rect paramRect1, Rect paramRect2)
  {
    AppMethodBeat.i(197754);
    switch (paramInt)
    {
    default: 
      paramRect1 = new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
      AppMethodBeat.o(197754);
      throw paramRect1;
    case 17: 
      if (paramRect1.left >= paramRect2.right)
      {
        AppMethodBeat.o(197754);
        return true;
      }
      AppMethodBeat.o(197754);
      return false;
    case 66: 
      if (paramRect1.right <= paramRect2.left)
      {
        AppMethodBeat.o(197754);
        return true;
      }
      AppMethodBeat.o(197754);
      return false;
    case 33: 
      if (paramRect1.top >= paramRect2.bottom)
      {
        AppMethodBeat.o(197754);
        return true;
      }
      AppMethodBeat.o(197754);
      return false;
    }
    if (paramRect1.bottom <= paramRect2.top)
    {
      AppMethodBeat.o(197754);
      return true;
    }
    AppMethodBeat.o(197754);
    return false;
  }
  
  private static int c(int paramInt, Rect paramRect1, Rect paramRect2)
  {
    AppMethodBeat.i(197755);
    paramInt = Math.max(0, d(paramInt, paramRect1, paramRect2));
    AppMethodBeat.o(197755);
    return paramInt;
  }
  
  private static int d(int paramInt, Rect paramRect1, Rect paramRect2)
  {
    AppMethodBeat.i(197756);
    switch (paramInt)
    {
    default: 
      paramRect1 = new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
      AppMethodBeat.o(197756);
      throw paramRect1;
    case 17: 
      paramInt = paramRect1.left;
      i = paramRect2.right;
      AppMethodBeat.o(197756);
      return paramInt - i;
    case 66: 
      paramInt = paramRect2.left;
      i = paramRect1.right;
      AppMethodBeat.o(197756);
      return paramInt - i;
    case 33: 
      paramInt = paramRect1.top;
      i = paramRect2.bottom;
      AppMethodBeat.o(197756);
      return paramInt - i;
    }
    paramInt = paramRect2.top;
    int i = paramRect1.bottom;
    AppMethodBeat.o(197756);
    return paramInt - i;
  }
  
  private static int e(int paramInt, Rect paramRect1, Rect paramRect2)
  {
    AppMethodBeat.i(197758);
    paramInt = Math.max(1, f(paramInt, paramRect1, paramRect2));
    AppMethodBeat.o(197758);
    return paramInt;
  }
  
  private static int f(int paramInt, Rect paramRect1, Rect paramRect2)
  {
    AppMethodBeat.i(197760);
    switch (paramInt)
    {
    default: 
      paramRect1 = new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
      AppMethodBeat.o(197760);
      throw paramRect1;
    case 17: 
      paramInt = paramRect1.left;
      i = paramRect2.left;
      AppMethodBeat.o(197760);
      return paramInt - i;
    case 66: 
      paramInt = paramRect2.right;
      i = paramRect1.right;
      AppMethodBeat.o(197760);
      return paramInt - i;
    case 33: 
      paramInt = paramRect1.top;
      i = paramRect2.top;
      AppMethodBeat.o(197760);
      return paramInt - i;
    }
    paramInt = paramRect2.bottom;
    int i = paramRect1.bottom;
    AppMethodBeat.o(197760);
    return paramInt - i;
  }
  
  private static int g(int paramInt, Rect paramRect1, Rect paramRect2)
  {
    AppMethodBeat.i(197761);
    switch (paramInt)
    {
    default: 
      paramRect1 = new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
      AppMethodBeat.o(197761);
      throw paramRect1;
    case 17: 
    case 66: 
      paramInt = Math.abs(paramRect1.top + paramRect1.height() / 2 - (paramRect2.top + paramRect2.height() / 2));
      AppMethodBeat.o(197761);
      return paramInt;
    }
    paramInt = Math.abs(paramRect1.left + paramRect1.width() / 2 - (paramRect2.left + paramRect2.width() / 2));
    AppMethodBeat.o(197761);
    return paramInt;
  }
  
  public static abstract interface a<T>
  {
    public abstract void a(T paramT, Rect paramRect);
  }
  
  public static abstract interface b<T, V>
  {
    public abstract int E(T paramT);
    
    public abstract V b(T paramT, int paramInt);
  }
  
  static final class c<T>
    implements Comparator<T>
  {
    private final Rect Rd;
    private final Rect Re;
    private final boolean Rf;
    private final b.a<T> Rg;
    
    c(boolean paramBoolean, b.a<T> parama)
    {
      AppMethodBeat.i(197727);
      this.Rd = new Rect();
      this.Re = new Rect();
      this.Rf = paramBoolean;
      this.Rg = parama;
      AppMethodBeat.o(197727);
    }
    
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(197732);
      Rect localRect1 = this.Rd;
      Rect localRect2 = this.Re;
      this.Rg.a(paramT1, localRect1);
      this.Rg.a(paramT2, localRect2);
      if (localRect1.top < localRect2.top)
      {
        AppMethodBeat.o(197732);
        return -1;
      }
      if (localRect1.top > localRect2.top)
      {
        AppMethodBeat.o(197732);
        return 1;
      }
      if (localRect1.left < localRect2.left)
      {
        if (this.Rf)
        {
          AppMethodBeat.o(197732);
          return 1;
        }
        AppMethodBeat.o(197732);
        return -1;
      }
      if (localRect1.left > localRect2.left)
      {
        if (this.Rf)
        {
          AppMethodBeat.o(197732);
          return -1;
        }
        AppMethodBeat.o(197732);
        return 1;
      }
      if (localRect1.bottom < localRect2.bottom)
      {
        AppMethodBeat.o(197732);
        return -1;
      }
      if (localRect1.bottom > localRect2.bottom)
      {
        AppMethodBeat.o(197732);
        return 1;
      }
      if (localRect1.right < localRect2.right)
      {
        if (this.Rf)
        {
          AppMethodBeat.o(197732);
          return 1;
        }
        AppMethodBeat.o(197732);
        return -1;
      }
      if (localRect1.right > localRect2.right)
      {
        if (this.Rf)
        {
          AppMethodBeat.o(197732);
          return -1;
        }
        AppMethodBeat.o(197732);
        return 1;
      }
      AppMethodBeat.o(197732);
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.customview.a.b
 * JD-Core Version:    0.7.0.1
 */