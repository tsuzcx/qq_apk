package com.tencent.mm.accessibility.core.providerdebuged;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.core.provider.Provider;
import com.tencent.mm.accessibility.uitl.AccUtil;
import com.tencent.mm.kiss.widget.textview.StaticTextView;
import com.tencent.neattextview.textview.view.NeatTextView;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/accessibility/core/providerdebuged/TextLinespaceShower;", "Lcom/tencent/mm/accessibility/core/provider/Provider;", "()V", "dealNodeInfo", "", "view", "Landroid/view/View;", "nodeInfo", "Landroid/view/accessibility/AccessibilityNodeInfo;", "getAuthority", "", "plugin-autoaccessibility_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class TextLinespaceShower
  extends Provider
{
  public static final TextLinespaceShower INSTANCE;
  
  static
  {
    AppMethodBeat.i(234180);
    INSTANCE = new TextLinespaceShower();
    AppMethodBeat.o(234180);
  }
  
  public final void dealNodeInfo(View paramView, AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    AppMethodBeat.i(234198);
    s.u(paramView, "view");
    s.u(paramAccessibilityNodeInfo, "nodeInfo");
    if ((paramView instanceof TextView))
    {
      paramAccessibilityNodeInfo.getExtras().putInt("MM_lineCount", ((TextView)paramView).getLineCount());
      paramAccessibilityNodeInfo.getExtras().putFloat("MM_lineSpacingMultiplier", ((TextView)paramView).getLineSpacingMultiplier());
      AppMethodBeat.o(234198);
      return;
    }
    if ((paramView instanceof NeatTextView))
    {
      paramAccessibilityNodeInfo.getExtras().putInt("MM_lineCount", ((NeatTextView)paramView).getLineCount());
      paramAccessibilityNodeInfo.getExtras().putFloat("MM_lineSpacingMultiplier", ((NeatTextView)paramView).getWrappedTextView().getLineSpacingMultiplier());
      AppMethodBeat.o(234198);
      return;
    }
    if ((paramView instanceof StaticTextView))
    {
      paramAccessibilityNodeInfo.getExtras().putInt("MM_lineCount", ((StaticTextView)paramView).getLineCount());
      paramAccessibilityNodeInfo.getExtras().putFloat("MM_lineSpacingMultiplier", ((StaticTextView)paramView).getLineSpacingMultiplier());
    }
    AppMethodBeat.o(234198);
  }
  
  public final int getAuthority()
  {
    AppMethodBeat.i(234203);
    if (AccUtil.INSTANCE.isEnableShowTextLinespace())
    {
      AppMethodBeat.o(234203);
      return 1;
    }
    AppMethodBeat.o(234203);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.accessibility.core.providerdebuged.TextLinespaceShower
 * JD-Core Version:    0.7.0.1
 */