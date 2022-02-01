package android.support.v4.widget;

import android.graphics.Rect;
import java.util.Comparator;

final class k
{
  public static <L, T> T a(L paramL, b<L, T> paramb, a<T> parama, T paramT, Rect paramRect, int paramInt)
  {
    Rect localRect1 = new Rect(paramRect);
    Object localObject1;
    Rect localRect2;
    int j;
    label103:
    int i;
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    case 17: 
      localRect1.offset(paramRect.width() + 1, 0);
      localObject1 = null;
      int k = paramb.K(paramL);
      localRect2 = new Rect();
      j = 0;
      if (j < k)
      {
        Object localObject2 = paramb.get(paramL, j);
        if (localObject2 == paramT) {
          break label333;
        }
        parama.b(localObject2, localRect2);
        if (a(paramRect, localRect2, paramInt)) {
          if (!a(paramRect, localRect1, paramInt))
          {
            i = 1;
            label164:
            if (i == 0) {
              break label333;
            }
            localRect1.set(localRect2);
            localObject1 = localObject2;
          }
        }
      }
      break;
    }
    label333:
    for (;;)
    {
      j += 1;
      break label103;
      localRect1.offset(-(paramRect.width() + 1), 0);
      break;
      localRect1.offset(0, paramRect.height() + 1);
      break;
      localRect1.offset(0, -(paramRect.height() + 1));
      break;
      if (a(paramInt, paramRect, localRect2, localRect1))
      {
        i = 1;
        break label164;
      }
      if ((!a(paramInt, paramRect, localRect1, localRect2)) && (x(c(paramInt, paramRect, localRect2), g(paramInt, paramRect, localRect2)) < x(c(paramInt, paramRect, localRect1), g(paramInt, paramRect, localRect1))))
      {
        i = 1;
        break label164;
      }
      i = 0;
      break label164;
      return localObject1;
    }
  }
  
  private static boolean a(int paramInt, Rect paramRect1, Rect paramRect2)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    case 17: 
    case 66: 
      if ((paramRect2.bottom < paramRect1.top) || (paramRect2.top > paramRect1.bottom)) {
        break;
      }
    }
    do
    {
      return true;
      return false;
    } while ((paramRect2.right >= paramRect1.left) && (paramRect2.left <= paramRect1.right));
    return false;
  }
  
  private static boolean a(int paramInt, Rect paramRect1, Rect paramRect2, Rect paramRect3)
  {
    boolean bool2 = true;
    boolean bool1 = a(paramInt, paramRect1, paramRect2);
    if ((a(paramInt, paramRect1, paramRect3)) || (!bool1)) {
      bool1 = false;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return bool1;
            bool1 = bool2;
          } while (!b(paramInt, paramRect1, paramRect3));
          bool1 = bool2;
        } while (paramInt == 17);
        bool1 = bool2;
      } while (paramInt == 66);
      bool1 = bool2;
    } while (c(paramInt, paramRect1, paramRect2) < e(paramInt, paramRect1, paramRect3));
    return false;
  }
  
  private static boolean a(Rect paramRect1, Rect paramRect2, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    case 17: 
      if (((paramRect1.right <= paramRect2.right) && (paramRect1.left < paramRect2.right)) || (paramRect1.left <= paramRect2.left)) {
        break;
      }
    }
    do
    {
      do
      {
        do
        {
          return true;
          return false;
        } while (((paramRect1.left < paramRect2.left) || (paramRect1.right <= paramRect2.left)) && (paramRect1.right < paramRect2.right));
        return false;
      } while (((paramRect1.bottom > paramRect2.bottom) || (paramRect1.top >= paramRect2.bottom)) && (paramRect1.top > paramRect2.top));
      return false;
    } while (((paramRect1.top < paramRect2.top) || (paramRect1.bottom <= paramRect2.top)) && (paramRect1.bottom < paramRect2.bottom));
    return false;
  }
  
  private static boolean b(int paramInt, Rect paramRect1, Rect paramRect2)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    case 17: 
      if (paramRect1.left < paramRect2.right) {
        break;
      }
    }
    do
    {
      do
      {
        do
        {
          return true;
          return false;
        } while (paramRect1.right <= paramRect2.left);
        return false;
      } while (paramRect1.top >= paramRect2.bottom);
      return false;
    } while (paramRect1.bottom <= paramRect2.top);
    return false;
  }
  
  private static int c(int paramInt, Rect paramRect1, Rect paramRect2)
  {
    return Math.max(0, d(paramInt, paramRect1, paramRect2));
  }
  
  private static int d(int paramInt, Rect paramRect1, Rect paramRect2)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    case 17: 
      return paramRect1.left - paramRect2.right;
    case 66: 
      return paramRect2.left - paramRect1.right;
    case 33: 
      return paramRect1.top - paramRect2.bottom;
    }
    return paramRect2.top - paramRect1.bottom;
  }
  
  private static int e(int paramInt, Rect paramRect1, Rect paramRect2)
  {
    return Math.max(1, f(paramInt, paramRect1, paramRect2));
  }
  
  private static int f(int paramInt, Rect paramRect1, Rect paramRect2)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    case 17: 
      return paramRect1.left - paramRect2.left;
    case 66: 
      return paramRect2.right - paramRect1.right;
    case 33: 
      return paramRect1.top - paramRect2.top;
    }
    return paramRect2.bottom - paramRect1.bottom;
  }
  
  private static int g(int paramInt, Rect paramRect1, Rect paramRect2)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    case 17: 
    case 66: 
      return Math.abs(paramRect1.top + paramRect1.height() / 2 - (paramRect2.top + paramRect2.height() / 2));
    }
    return Math.abs(paramRect1.left + paramRect1.width() / 2 - (paramRect2.left + paramRect2.width() / 2));
  }
  
  private static int x(int paramInt1, int paramInt2)
  {
    return paramInt1 * 13 * paramInt1 + paramInt2 * paramInt2;
  }
  
  public static abstract interface a<T>
  {
    public abstract void b(T paramT, Rect paramRect);
  }
  
  public static abstract interface b<T, V>
  {
    public abstract int K(T paramT);
    
    public abstract V get(T paramT, int paramInt);
  }
  
  static final class c<T>
    implements Comparator<T>
  {
    private final Rect Sw = new Rect();
    private final Rect Sx = new Rect();
    private final boolean Sy;
    private final k.a<T> Sz;
    
    c(boolean paramBoolean, k.a<T> parama)
    {
      this.Sy = paramBoolean;
      this.Sz = parama;
    }
    
    public final int compare(T paramT1, T paramT2)
    {
      Rect localRect1 = this.Sw;
      Rect localRect2 = this.Sx;
      this.Sz.b(paramT1, localRect1);
      this.Sz.b(paramT2, localRect2);
      if (localRect1.top < localRect2.top) {}
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return -1;
                if (localRect1.top > localRect2.top) {
                  return 1;
                }
                if (localRect1.left >= localRect2.left) {
                  break;
                }
              } while (!this.Sy);
              return 1;
              if (localRect1.left <= localRect2.left) {
                break;
              }
            } while (this.Sy);
            return 1;
          } while (localRect1.bottom < localRect2.bottom);
          if (localRect1.bottom > localRect2.bottom) {
            return 1;
          }
          if (localRect1.right >= localRect2.right) {
            break;
          }
        } while (!this.Sy);
        return 1;
        if (localRect1.right <= localRect2.right) {
          break;
        }
      } while (this.Sy);
      return 1;
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v4.widget.k
 * JD-Core Version:    0.7.0.1
 */