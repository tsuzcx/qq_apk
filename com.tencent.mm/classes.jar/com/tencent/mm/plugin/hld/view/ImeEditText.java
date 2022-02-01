package com.tencent.mm.plugin.hld.view;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.Layout;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.MMEditText;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/view/ImeEditText;", "Lcom/tencent/mm/ui/widget/MMEditText;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ifProcessCallback", "", "imeEditTextCursorListener", "Lcom/tencent/mm/plugin/hld/view/ImeEditTextCursorListener;", "lastChangeTextTime", "", "mCurrentCursorIndex", "getMCurrentCursorIndex", "()I", "setMCurrentCursorIndex", "(I)V", "changeText", "", "onSelectionChanged", "selStart", "selEnd", "setImeEditTextCursorListener", "listener", "setSelection", "index", "Companion", "plugin-hld_release"})
public final class ImeEditText
  extends MMEditText
{
  public static final a DIf;
  private long DIb;
  private boolean DIc;
  private int DId = -1;
  private e DIe;
  
  static
  {
    AppMethodBeat.i(217234);
    DIf = new a((byte)0);
    AppMethodBeat.o(217234);
  }
  
  public ImeEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ImeEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void eHE()
  {
    AppMethodBeat.i(217229);
    this.DIb = System.currentTimeMillis();
    this.DIc = false;
    AppMethodBeat.o(217229);
  }
  
  public final int getMCurrentCursorIndex()
  {
    return this.DId;
  }
  
  protected final void onSelectionChanged(final int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(217231);
    super.onSelectionChanged(paramInt1, paramInt2);
    long l = System.currentTimeMillis() - this.DIb;
    Log.d("WxIme.ImeEditText", "onSelectionChanged selStart:" + paramInt1 + " selEnd:" + paramInt2 + " ifProcessCallback:" + this.DIc + " interTime:" + l);
    if ((l < 100L) && (paramInt1 == 0))
    {
      if (!this.DIc)
      {
        this.DIc = true;
        post((Runnable)new b(this));
        Log.d("WxIme.ImeEditText", "setSelection:" + length());
      }
      AppMethodBeat.o(217231);
      return;
    }
    post((Runnable)new c(this, paramInt1));
    AppMethodBeat.o(217231);
  }
  
  public final void setImeEditTextCursorListener(e parame)
  {
    this.DIe = parame;
  }
  
  public final void setMCurrentCursorIndex(int paramInt)
  {
    this.DId = paramInt;
  }
  
  public final void setSelection(int paramInt)
  {
    AppMethodBeat.i(217232);
    super.setSelection(paramInt);
    Log.d("WxIme.ImeEditText", "setSelection mCurrentCursorIndex:" + this.DId + " index:" + paramInt);
    this.DId = paramInt;
    AppMethodBeat.o(217232);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/view/ImeEditText$Companion;", "", "()V", "TAG", "", "plugin-hld_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(ImeEditText paramImeEditText) {}
    
    public final void run()
    {
      AppMethodBeat.i(210840);
      this.DIg.setSelection(this.DIg.length());
      AppMethodBeat.o(210840);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(ImeEditText paramImeEditText, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(211024);
      Object localObject = this.DIg.getLayout();
      if (localObject != null)
      {
        int i = ((Layout)localObject).getLineForOffset(this.DIg.getSelectionStart());
        int j = ((Layout)localObject).getLineBaseline(i);
        int k = ((Layout)localObject).getLineAscent(i);
        Rect localRect = new Rect();
        ((Layout)localObject).getLineBounds(i, localRect);
        int[] arrayOfInt = new int[2];
        this.DIg.getLocationOnScreen(arrayOfInt);
        Point localPoint = new Point();
        localPoint.x = ((int)(((Layout)localObject).getPrimaryHorizontal(this.DIg.getSelectionStart()) + arrayOfInt[0]));
        localPoint.y = (j + k + arrayOfInt[1] + localRect.bottom - localRect.top);
        Log.d("WxIme.ImeEditText", "x:" + localPoint.x + " y:" + localPoint.y + ' ' + (arrayOfInt[1] + (j + k)) + " lineHeight:" + this.DIg.getLineHeight());
        localObject = ImeEditText.a(this.DIg);
        if (localObject != null)
        {
          ((e)localObject).hI(localPoint.x, localPoint.y);
          AppMethodBeat.o(211024);
          return;
        }
        AppMethodBeat.o(211024);
        return;
      }
      AppMethodBeat.o(211024);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.view.ImeEditText
 * JD-Core Version:    0.7.0.1
 */