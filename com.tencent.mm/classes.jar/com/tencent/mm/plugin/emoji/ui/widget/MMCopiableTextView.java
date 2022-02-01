package com.tencent.mm.plugin.emoji.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Util;

public class MMCopiableTextView
  extends EditText
  implements View.OnLongClickListener
{
  private final String TAG;
  private int owQ;
  private int rnu;
  
  public MMCopiableTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(109429);
    this.TAG = "MicroMsg.MMCopiableTextView";
    init();
    AppMethodBeat.o(109429);
  }
  
  public MMCopiableTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(109430);
    this.TAG = "MicroMsg.MMCopiableTextView";
    init();
    AppMethodBeat.o(109430);
  }
  
  private void init()
  {
    AppMethodBeat.i(109431);
    setOnLongClickListener(this);
    setLongClickable(true);
    AppMethodBeat.o(109431);
  }
  
  protected boolean getDefaultEditable()
  {
    return false;
  }
  
  protected void onCreateContextMenu(ContextMenu paramContextMenu) {}
  
  public boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(109432);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/emoji/ui/widget/MMCopiableTextView", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
    paramView = getEditableText().toString();
    if ((!Util.isNullOrNil(paramView)) && (this.owQ > 0) && (this.rnu > 0) && (this.rnu > this.owQ))
    {
      ClipboardHelper.setText(paramView.substring(this.owQ, this.rnu).trim());
      Toast.makeText(getContext(), 2131755773, 0).show();
    }
    a.a(false, this, "com/tencent/mm/plugin/emoji/ui/widget/MMCopiableTextView", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(109432);
    return false;
  }
  
  public void setEndIndex(int paramInt)
  {
    this.rnu = paramInt;
  }
  
  public void setStartIndex(int paramInt)
  {
    this.owQ = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.widget.MMCopiableTextView
 * JD-Core Version:    0.7.0.1
 */