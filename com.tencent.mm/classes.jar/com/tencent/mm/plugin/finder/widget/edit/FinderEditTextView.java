package com.tencent.mm.plugin.finder.widget.edit;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.MMEditText;
import java.lang.reflect.Field;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/widget/edit/FinderEditTextView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "editText", "Lcom/tencent/mm/ui/widget/MMEditText;", "deleteChar", "", "getText", "init", "insertText", "text", "requestEditFocus", "setTextCursorDrawable", "resId", "setTextCursorVisible", "visible", "", "setTextGravity", "gravity", "setTextHint", "hint", "setTextInputType", "type", "setTextMaxLines", "maxLines", "plugin-finder_release"})
public final class FinderEditTextView
  extends FrameLayout
{
  public MMEditText AVN;
  private String TAG;
  
  public FinderEditTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168588);
    this.TAG = "Finder.FinderEditTextView";
    init();
    AppMethodBeat.o(168588);
  }
  
  public FinderEditTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(168589);
    this.TAG = "Finder.FinderEditTextView";
    init();
    AppMethodBeat.o(168589);
  }
  
  private final void init()
  {
    AppMethodBeat.i(168579);
    this.AVN = new MMEditText(getContext());
    Object localObject = new FrameLayout.LayoutParams(-1, -2);
    ((FrameLayout.LayoutParams)localObject).gravity = 16;
    MMEditText localMMEditText = this.AVN;
    if (localMMEditText == null) {
      p.bGy("editText");
    }
    addView((View)localMMEditText, (ViewGroup.LayoutParams)localObject);
    localObject = this.AVN;
    if (localObject == null) {
      p.bGy("editText");
    }
    ((MMEditText)localObject).setBackground(null);
    AppMethodBeat.o(168579);
  }
  
  public final void aGG(String paramString)
  {
    AppMethodBeat.i(168586);
    p.k(paramString, "text");
    MMEditText localMMEditText = this.AVN;
    if (localMMEditText == null) {
      p.bGy("editText");
    }
    localMMEditText.bBa(paramString);
    AppMethodBeat.o(168586);
  }
  
  public final String getText()
  {
    AppMethodBeat.i(168587);
    Object localObject = this.AVN;
    if (localObject == null) {
      p.bGy("editText");
    }
    localObject = ((MMEditText)localObject).getText().toString();
    AppMethodBeat.o(168587);
    return localObject;
  }
  
  public final void setTextCursorDrawable(int paramInt)
  {
    AppMethodBeat.i(168584);
    try
    {
      Field localField = TextView.class.getDeclaredField("mCursorDrawableRes");
      p.j(localField, "TextView::class.java.get…eld(\"mCursorDrawableRes\")");
      localField.setAccessible(true);
      MMEditText localMMEditText = this.AVN;
      if (localMMEditText == null) {
        p.bGy("editText");
      }
      localField.set(localMMEditText, Integer.valueOf(paramInt));
      AppMethodBeat.o(168584);
      return;
    }
    catch (Exception localException)
    {
      Log.e(this.TAG, "set cursor drawable error %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(168584);
    }
  }
  
  public final void setTextCursorVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(168583);
    MMEditText localMMEditText = this.AVN;
    if (localMMEditText == null) {
      p.bGy("editText");
    }
    localMMEditText.setCursorVisible(paramBoolean);
    AppMethodBeat.o(168583);
  }
  
  public final void setTextGravity(int paramInt)
  {
    AppMethodBeat.i(168581);
    MMEditText localMMEditText = this.AVN;
    if (localMMEditText == null) {
      p.bGy("editText");
    }
    localMMEditText.setGravity(paramInt);
    AppMethodBeat.o(168581);
  }
  
  public final void setTextHint(String paramString)
  {
    AppMethodBeat.i(168585);
    p.k(paramString, "hint");
    MMEditText localMMEditText = this.AVN;
    if (localMMEditText == null) {
      p.bGy("editText");
    }
    localMMEditText.setHint((CharSequence)paramString);
    AppMethodBeat.o(168585);
  }
  
  public final void setTextInputType(int paramInt)
  {
    AppMethodBeat.i(168582);
    MMEditText localMMEditText = this.AVN;
    if (localMMEditText == null) {
      p.bGy("editText");
    }
    localMMEditText.setInputType(paramInt);
    AppMethodBeat.o(168582);
  }
  
  public final void setTextMaxLines(int paramInt)
  {
    AppMethodBeat.i(168580);
    MMEditText localMMEditText = this.AVN;
    if (localMMEditText == null) {
      p.bGy("editText");
    }
    localMMEditText.setMaxLines(paramInt);
    AppMethodBeat.o(168580);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.widget.edit.FinderEditTextView
 * JD-Core Version:    0.7.0.1
 */