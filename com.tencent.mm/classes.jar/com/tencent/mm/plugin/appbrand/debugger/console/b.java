package com.tencent.mm.plugin.appbrand.debugger.console;

import android.content.Context;
import androidx.appcompat.widget.AppCompatButton;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ba.c;
import com.tencent.mm.plugin.appbrand.ba.d;
import com.tencent.mm.plugin.appbrand.ba.e;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/debugger/console/ConsolePrintControlView;", "Landroidx/appcompat/widget/AppCompatButton;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends AppCompatButton
{
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(319779);
    setMinHeight(com.tencent.mm.cd.a.bs(paramContext, ba.d.SmallButtonHeight));
    setMinWidth(com.tencent.mm.cd.a.bs(paramContext, ba.d.SmallBtnWidth));
    setGravity(17);
    setTextSize(0, com.tencent.mm.cd.a.bs(paramContext, ba.d.SmallBtnTextSize));
    int i = com.tencent.mm.cd.a.bs(paramContext, ba.d.SmallBtnPadding);
    setPadding(i, 0, i, 0);
    setAllCaps(false);
    setTextColor(androidx.core.content.a.l(paramContext, ba.c.color_btn_text_selector));
    setBackgroundResource(ba.e.btn_solid_green_small);
    setText((CharSequence)"Console");
    AppMethodBeat.o(319779);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.console.b
 * JD-Core Version:    0.7.0.1
 */