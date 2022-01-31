package com.tencent.mm.plugin.emoji.ui.widget;

import android.content.Context;
import android.text.ClipboardManager;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.mm.plugin.emoji.f.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public class MMCopiableTextView
  extends EditText
  implements View.OnLongClickListener
{
  private final String TAG = "MicroMsg.MMCopiableTextView";
  private int hxB;
  private int jjF;
  
  public MMCopiableTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public MMCopiableTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    setOnLongClickListener(this);
    setLongClickable(true);
  }
  
  protected boolean getDefaultEditable()
  {
    return false;
  }
  
  protected void onCreateContextMenu(ContextMenu paramContextMenu) {}
  
  public boolean onLongClick(View paramView)
  {
    paramView = getEditableText().toString();
    if ((!bk.bl(paramView)) && (this.hxB > 0) && (this.jjF > 0) && (this.jjF > this.hxB))
    {
      ClipboardManager localClipboardManager = (ClipboardManager)getContext().getSystemService("clipboard");
      if (localClipboardManager != null)
      {
        localClipboardManager.setText(paramView.substring(this.hxB, this.jjF).trim());
        y.i("MicroMsg.MMCopiableTextView", "copy text :%s", new Object[] { localClipboardManager.getText() });
      }
      Toast.makeText(getContext(), f.h.app_copy_ok, 0).show();
    }
    return false;
  }
  
  public void setEndIndex(int paramInt)
  {
    this.jjF = paramInt;
  }
  
  public void setStartIndex(int paramInt)
  {
    this.hxB = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.widget.MMCopiableTextView
 * JD-Core Version:    0.7.0.1
 */