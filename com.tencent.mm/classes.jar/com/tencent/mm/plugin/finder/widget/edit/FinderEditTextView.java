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
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/widget/edit/FinderEditTextView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "editText", "Lcom/tencent/mm/ui/widget/MMEditText;", "deleteChar", "", "getText", "init", "insertText", "text", "requestEditFocus", "setTextCursorDrawable", "resId", "setTextCursorVisible", "visible", "", "setTextGravity", "gravity", "setTextHint", "hint", "setTextInputType", "type", "setTextMaxLines", "maxLines", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderEditTextView
  extends FrameLayout
{
  public MMEditText GBE;
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
    this.GBE = new MMEditText(getContext());
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
    localLayoutParams.gravity = 16;
    MMEditText localMMEditText2 = this.GBE;
    MMEditText localMMEditText1 = localMMEditText2;
    if (localMMEditText2 == null)
    {
      s.bIx("editText");
      localMMEditText1 = null;
    }
    addView((View)localMMEditText1, (ViewGroup.LayoutParams)localLayoutParams);
    localMMEditText2 = this.GBE;
    localMMEditText1 = localMMEditText2;
    if (localMMEditText2 == null)
    {
      s.bIx("editText");
      localMMEditText1 = null;
    }
    localMMEditText1.setBackground(null);
    AppMethodBeat.o(168579);
  }
  
  public final void aCV(String paramString)
  {
    AppMethodBeat.i(168586);
    s.u(paramString, "text");
    MMEditText localMMEditText2 = this.GBE;
    MMEditText localMMEditText1 = localMMEditText2;
    if (localMMEditText2 == null)
    {
      s.bIx("editText");
      localMMEditText1 = null;
    }
    localMMEditText1.bDt(paramString);
    AppMethodBeat.o(168586);
  }
  
  public final String getText()
  {
    AppMethodBeat.i(168587);
    MMEditText localMMEditText = this.GBE;
    Object localObject = localMMEditText;
    if (localMMEditText == null)
    {
      s.bIx("editText");
      localObject = null;
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
      localField.setAccessible(true);
      MMEditText localMMEditText2 = this.GBE;
      MMEditText localMMEditText1 = localMMEditText2;
      if (localMMEditText2 == null)
      {
        s.bIx("editText");
        localMMEditText1 = null;
      }
      localField.set(localMMEditText1, Integer.valueOf(paramInt));
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
    MMEditText localMMEditText2 = this.GBE;
    MMEditText localMMEditText1 = localMMEditText2;
    if (localMMEditText2 == null)
    {
      s.bIx("editText");
      localMMEditText1 = null;
    }
    localMMEditText1.setCursorVisible(paramBoolean);
    AppMethodBeat.o(168583);
  }
  
  public final void setTextGravity(int paramInt)
  {
    AppMethodBeat.i(168581);
    MMEditText localMMEditText2 = this.GBE;
    MMEditText localMMEditText1 = localMMEditText2;
    if (localMMEditText2 == null)
    {
      s.bIx("editText");
      localMMEditText1 = null;
    }
    localMMEditText1.setGravity(paramInt);
    AppMethodBeat.o(168581);
  }
  
  public final void setTextHint(String paramString)
  {
    AppMethodBeat.i(168585);
    s.u(paramString, "hint");
    MMEditText localMMEditText2 = this.GBE;
    MMEditText localMMEditText1 = localMMEditText2;
    if (localMMEditText2 == null)
    {
      s.bIx("editText");
      localMMEditText1 = null;
    }
    localMMEditText1.setHint((CharSequence)paramString);
    AppMethodBeat.o(168585);
  }
  
  public final void setTextInputType(int paramInt)
  {
    AppMethodBeat.i(168582);
    MMEditText localMMEditText2 = this.GBE;
    MMEditText localMMEditText1 = localMMEditText2;
    if (localMMEditText2 == null)
    {
      s.bIx("editText");
      localMMEditText1 = null;
    }
    localMMEditText1.setInputType(paramInt);
    AppMethodBeat.o(168582);
  }
  
  public final void setTextMaxLines(int paramInt)
  {
    AppMethodBeat.i(168580);
    MMEditText localMMEditText2 = this.GBE;
    MMEditText localMMEditText1 = localMMEditText2;
    if (localMMEditText2 == null)
    {
      s.bIx("editText");
      localMMEditText1 = null;
    }
    localMMEditText1.setMaxLines(paramInt);
    AppMethodBeat.o(168580);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.widget.edit.FinderEditTextView
 * JD-Core Version:    0.7.0.1
 */