package android.support.v4.widget;

import android.graphics.Rect;
import java.util.Comparator;

final class k$c<T>
  implements Comparator<T>
{
  private final Rect KA = new Rect();
  private final Rect KB = new Rect();
  private final boolean KC;
  private final k.a<T> KD;
  
  k$c(boolean paramBoolean, k.a<T> parama)
  {
    this.KC = paramBoolean;
    this.KD = parama;
  }
  
  public final int compare(T paramT1, T paramT2)
  {
    Rect localRect1 = this.KA;
    Rect localRect2 = this.KB;
    this.KD.b(paramT1, localRect1);
    this.KD.b(paramT2, localRect2);
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
            } while (!this.KC);
            return 1;
            if (localRect1.left <= localRect2.left) {
              break;
            }
          } while (this.KC);
          return 1;
        } while (localRect1.bottom < localRect2.bottom);
        if (localRect1.bottom > localRect2.bottom) {
          return 1;
        }
        if (localRect1.right >= localRect2.right) {
          break;
        }
      } while (!this.KC);
      return 1;
      if (localRect1.right <= localRect2.right) {
        break;
      }
    } while (this.KC);
    return 1;
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.v4.widget.k.c
 * JD-Core Version:    0.7.0.1
 */