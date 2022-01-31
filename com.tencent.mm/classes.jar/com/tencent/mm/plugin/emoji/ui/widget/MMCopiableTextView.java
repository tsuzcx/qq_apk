package com.tencent.mm.plugin.emoji.ui.widget;

import android.content.Context;
import android.text.ClipboardManager;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public class MMCopiableTextView
  extends EditText
  implements View.OnLongClickListener
{
  private final String TAG;
  private int jpL;
  private int lsx;
  
  public MMCopiableTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(53855);
    this.TAG = "MicroMsg.MMCopiableTextView";
    init();
    AppMethodBeat.o(53855);
  }
  
  public MMCopiableTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(53856);
    this.TAG = "MicroMsg.MMCopiableTextView";
    init();
    AppMethodBeat.o(53856);
  }
  
  private void init()
  {
    AppMethodBeat.i(53857);
    setOnLongClickListener(this);
    setLongClickable(true);
    AppMethodBeat.o(53857);
  }
  
  protected boolean getDefaultEditable()
  {
    return false;
  }
  
  protected void onCreateContextMenu(ContextMenu paramContextMenu) {}
  
  public boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(53858);
    paramView = getEditableText().toString();
    if ((!bo.isNullOrNil(paramView)) && (this.jpL > 0) && (this.lsx > 0) && (this.lsx > this.jpL))
    {
      ClipboardManager localClipboardManager = (ClipboardManager)ah.getContext().getSystemService("clipboard");
      if (localClipboardManager != null)
      {
        localClipboardManager.setText(paramView.substring(this.jpL, this.lsx).trim());
        ab.i("MicroMsg.MMCopiableTextView", "copy text :%s", new Object[] { localClipboardManager.getText() });
      }
      Toast.makeText(getContext(), 2131296896, 0).show();
    }
    AppMethodBeat.o(53858);
    return false;
  }
  
  public void setEndIndex(int paramInt)
  {
    this.lsx = paramInt;
  }
  
  public void setStartIndex(int paramInt)
  {
    this.jpL = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.widget.MMCopiableTextView
 * JD-Core Version:    0.7.0.1
 */