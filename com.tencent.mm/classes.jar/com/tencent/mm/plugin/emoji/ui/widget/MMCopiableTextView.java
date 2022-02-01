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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;

public class MMCopiableTextView
  extends EditText
  implements View.OnLongClickListener
{
  private final String TAG;
  private int mHD;
  private int pmq;
  
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
    paramView = getEditableText().toString();
    if ((!bs.isNullOrNil(paramView)) && (this.mHD > 0) && (this.pmq > 0) && (this.pmq > this.mHD))
    {
      ClipboardManager localClipboardManager = (ClipboardManager)ai.getContext().getSystemService("clipboard");
      if (localClipboardManager != null)
      {
        localClipboardManager.setText(paramView.substring(this.mHD, this.pmq).trim());
        ac.i("MicroMsg.MMCopiableTextView", "copy text :%s", new Object[] { localClipboardManager.getText() });
      }
      Toast.makeText(getContext(), 2131755702, 0).show();
    }
    AppMethodBeat.o(109432);
    return false;
  }
  
  public void setEndIndex(int paramInt)
  {
    this.pmq = paramInt;
  }
  
  public void setStartIndex(int paramInt)
  {
    this.mHD = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.widget.MMCopiableTextView
 * JD-Core Version:    0.7.0.1
 */