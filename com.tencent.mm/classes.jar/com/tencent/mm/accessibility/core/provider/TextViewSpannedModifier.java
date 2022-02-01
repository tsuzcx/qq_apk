package com.tencent.mm.accessibility.core.provider;

import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.uitl.AccUtil;
import com.tencent.neattextview.textview.view.NeatTextView;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/accessibility/core/provider/TextViewSpannedModifier;", "Lcom/tencent/mm/accessibility/core/provider/Provider;", "()V", "TAG", "", "dealAccEvent", "", "view", "Landroid/view/View;", "event", "Landroid/view/accessibility/AccessibilityEvent;", "getAuthority", "", "getIfOnlyClickableSpan", "Landroid/text/style/ClickableSpan;", "plugin-autoaccessibility_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class TextViewSpannedModifier
  extends Provider
{
  public static final TextViewSpannedModifier INSTANCE;
  public static final String TAG = "MicroMsg.Acc.TextViewSpannedModifier";
  
  static
  {
    AppMethodBeat.i(234287);
    INSTANCE = new TextViewSpannedModifier();
    AppMethodBeat.o(234287);
  }
  
  private final ClickableSpan getIfOnlyClickableSpan(View paramView)
  {
    AppMethodBeat.i(234283);
    if ((!(paramView instanceof NeatTextView)) && (!(paramView instanceof TextView)))
    {
      AppMethodBeat.o(234283);
      return null;
    }
    CharSequence localCharSequence;
    if ((paramView instanceof TextView))
    {
      localCharSequence = ((TextView)paramView).getText();
      s.s(localCharSequence, "{\n                view.text\n            }");
    }
    while (!(localCharSequence instanceof Spanned))
    {
      logMsg("MicroMsg.Acc.TextViewSpannedModifier", paramView, "TextViewSpannedModifier," + localCharSequence + " type wrong:" + localCharSequence.getClass() + ' ');
      AppMethodBeat.o(234283);
      return null;
      if ((paramView instanceof NeatTextView))
      {
        localCharSequence = ((NeatTextView)paramView).jPy();
        s.s(localCharSequence, "{\n                view._getText()\n            }");
      }
      else
      {
        AppMethodBeat.o(234283);
        return null;
      }
    }
    ClickableSpan[] arrayOfClickableSpan = (ClickableSpan[])((Spanned)localCharSequence).getSpans(0, localCharSequence.length(), ClickableSpan.class);
    if ((arrayOfClickableSpan.length == 1) && (arrayOfClickableSpan[0] != null))
    {
      logMsg("MicroMsg.Acc.TextViewSpannedModifier", paramView, "TextViewSpannedModifier," + localCharSequence + " success get Span");
      paramView = arrayOfClickableSpan[0];
      if (paramView == null)
      {
        paramView = new NullPointerException("null cannot be cast to non-null type android.text.style.ClickableSpan");
        AppMethodBeat.o(234283);
        throw paramView;
      }
      AppMethodBeat.o(234283);
      return paramView;
    }
    AppMethodBeat.o(234283);
    return null;
  }
  
  public final void dealAccEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(234295);
    s.u(paramView, "view");
    s.u(paramAccessibilityEvent, "event");
    if ((paramAccessibilityEvent.getEventType() == 1) && (AccUtil.INSTANCE.isAccessibilityEnabled()))
    {
      paramAccessibilityEvent = getIfOnlyClickableSpan(paramView);
      if (paramAccessibilityEvent != null) {
        paramAccessibilityEvent.onClick(paramView);
      }
    }
    AppMethodBeat.o(234295);
  }
  
  public final int getAuthority()
  {
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.accessibility.core.provider.TextViewSpannedModifier
 * JD-Core Version:    0.7.0.1
 */