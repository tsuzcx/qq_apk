package com.tencent.mm.plugin.hld.view;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.Layout;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.MMEditText;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/view/ImeEditText;", "Lcom/tencent/mm/ui/widget/MMEditText;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ifProcessCallback", "", "imeEditTextCursorListener", "Lcom/tencent/mm/plugin/hld/view/ImeEditTextCursorListener;", "lastChangeTextTime", "", "mCurrentCursorIndex", "getMCurrentCursorIndex", "()I", "setMCurrentCursorIndex", "(I)V", "changeText", "", "onSelectionChanged", "selStart", "selEnd", "setImeEditTextCursorListener", "listener", "setSelection", "index", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ImeEditText
  extends MMEditText
{
  public static final ImeEditText.a Jzf;
  private long Jzg;
  private boolean Jzh;
  private int Jzi = -1;
  private d Jzj;
  
  static
  {
    AppMethodBeat.i(312593);
    Jzf = new ImeEditText.a((byte)0);
    AppMethodBeat.o(312593);
  }
  
  public ImeEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ImeEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private static final void a(ImeEditText paramImeEditText)
  {
    AppMethodBeat.i(312575);
    s.u(paramImeEditText, "this$0");
    paramImeEditText.setSelection(paramImeEditText.length());
    AppMethodBeat.o(312575);
  }
  
  private static final void a(ImeEditText paramImeEditText, int paramInt)
  {
    AppMethodBeat.i(312587);
    s.u(paramImeEditText, "this$0");
    Layout localLayout = paramImeEditText.getLayout();
    if (localLayout != null)
    {
      paramInt = localLayout.getLineForOffset(paramImeEditText.getSelectionStart());
      int i = localLayout.getLineBaseline(paramInt);
      int j = localLayout.getLineAscent(paramInt);
      Rect localRect = new Rect();
      localLayout.getLineBounds(paramInt, localRect);
      int[] arrayOfInt = new int[2];
      paramImeEditText.getLocationOnScreen(arrayOfInt);
      Point localPoint = new Point();
      localPoint.x = ((int)(localLayout.getPrimaryHorizontal(paramImeEditText.getSelectionStart()) + arrayOfInt[0]));
      localPoint.y = (i + j + arrayOfInt[1] + localRect.bottom - localRect.top);
      Log.d("WxIme.ImeEditText", "x:" + localPoint.x + " y:" + localPoint.y + ' ' + (arrayOfInt[1] + (i + j)) + " lineHeight:" + paramImeEditText.getLineHeight());
      paramImeEditText = paramImeEditText.Jzj;
      if (paramImeEditText != null) {
        paramImeEditText.jm(localPoint.x, localPoint.y);
      }
    }
    AppMethodBeat.o(312587);
  }
  
  public final void fPq()
  {
    AppMethodBeat.i(312629);
    this.Jzg = System.currentTimeMillis();
    this.Jzh = false;
    AppMethodBeat.o(312629);
  }
  
  public final int getMCurrentCursorIndex()
  {
    return this.Jzi;
  }
  
  protected final void onSelectionChanged(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(312643);
    super.onSelectionChanged(paramInt1, paramInt2);
    long l = System.currentTimeMillis() - this.Jzg;
    Log.d("WxIme.ImeEditText", "onSelectionChanged selStart:" + paramInt1 + " selEnd:" + paramInt2 + " ifProcessCallback:" + this.Jzh + " interTime:" + l);
    if ((l < 100L) && (paramInt1 == 0))
    {
      if (!this.Jzh)
      {
        this.Jzh = true;
        post(new ImeEditText..ExternalSyntheticLambda0(this));
        Log.d("WxIme.ImeEditText", s.X("setSelection:", Integer.valueOf(length())));
      }
      AppMethodBeat.o(312643);
      return;
    }
    post(new ImeEditText..ExternalSyntheticLambda1(this, paramInt1));
    AppMethodBeat.o(312643);
  }
  
  public final void setImeEditTextCursorListener(d paramd)
  {
    this.Jzj = paramd;
  }
  
  public final void setMCurrentCursorIndex(int paramInt)
  {
    this.Jzi = paramInt;
  }
  
  public final void setSelection(int paramInt)
  {
    AppMethodBeat.i(312647);
    super.setSelection(paramInt);
    Log.d("WxIme.ImeEditText", "setSelection mCurrentCursorIndex:" + this.Jzi + " index:" + paramInt);
    this.Jzi = paramInt;
    AppMethodBeat.o(312647);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.view.ImeEditText
 * JD-Core Version:    0.7.0.1
 */