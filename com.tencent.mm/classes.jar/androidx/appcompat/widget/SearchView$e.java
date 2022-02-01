package androidx.appcompat.widget;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SearchView$e
  extends TouchDelegate
{
  private final View vi;
  private final Rect vj;
  private final Rect vk;
  private final Rect vl;
  private final int vm;
  private boolean vn;
  
  public SearchView$e(Rect paramRect1, Rect paramRect2, View paramView)
  {
    super(paramRect1, paramView);
    AppMethodBeat.i(241774);
    this.vm = ViewConfiguration.get(paramView.getContext()).getScaledTouchSlop();
    this.vj = new Rect();
    this.vl = new Rect();
    this.vk = new Rect();
    a(paramRect1, paramRect2);
    this.vi = paramView;
    AppMethodBeat.o(241774);
  }
  
  public final void a(Rect paramRect1, Rect paramRect2)
  {
    AppMethodBeat.i(241775);
    this.vj.set(paramRect1);
    this.vl.set(paramRect1);
    this.vl.inset(-this.vm, -this.vm);
    this.vk.set(paramRect2);
    AppMethodBeat.o(241775);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool3 = false;
    AppMethodBeat.i(241777);
    int j = (int)paramMotionEvent.getX();
    int k = (int)paramMotionEvent.getY();
    int i;
    boolean bool1;
    label61:
    boolean bool2;
    switch (paramMotionEvent.getAction())
    {
    default: 
      i = 1;
      bool1 = false;
      bool2 = bool3;
      if (bool1)
      {
        if ((i == 0) || (this.vk.contains(j, k))) {
          break label212;
        }
        paramMotionEvent.setLocation(this.vi.getWidth() / 2, this.vi.getHeight() / 2);
      }
      break;
    }
    for (;;)
    {
      bool2 = this.vi.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(241777);
      return bool2;
      if (!this.vj.contains(j, k)) {
        break;
      }
      this.vn = true;
      i = 1;
      bool1 = true;
      break label61;
      bool2 = this.vn;
      bool1 = bool2;
      if (bool2)
      {
        bool1 = bool2;
        if (!this.vl.contains(j, k))
        {
          i = 0;
          bool1 = bool2;
          break label61;
          bool1 = this.vn;
          this.vn = false;
        }
      }
      i = 1;
      break label61;
      label212:
      paramMotionEvent.setLocation(j - this.vk.left, k - this.vk.top);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.appcompat.widget.SearchView.e
 * JD-Core Version:    0.7.0.1
 */