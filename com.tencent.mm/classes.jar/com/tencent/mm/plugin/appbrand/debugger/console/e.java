package com.tencent.mm.plugin.appbrand.debugger.console;

import android.content.Context;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.method.MovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ForegroundColorSpan;
import androidx.appcompat.widget.AppCompatTextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ba.c;
import com.tencent.mm.plugin.appbrand.ba.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/debugger/console/ConsolePrintView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "lineQueue", "Ljava/util/LinkedList;", "", "printContent", "Landroid/text/SpannableStringBuilder;", "appendDebugLine", "", "msg", "appendErrorLine", "appendInfoLine", "appendLineWithColor", "color", "", "appendVerboseLine", "appendWarnLine", "clear", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends AppCompatTextView
{
  private static final boolean DEBUG = false;
  public static final e.a rfG;
  final LinkedList<String> rfH;
  SpannableStringBuilder rfI;
  
  static
  {
    AppMethodBeat.i(319807);
    rfG = new e.a((byte)0);
    AppMethodBeat.o(319807);
  }
  
  public e(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(319783);
    setTextSize(0, com.tencent.mm.cd.a.bs(paramContext, ba.d.SmallerTextSize));
    setVerticalScrollBarEnabled(true);
    setMovementMethod((MovementMethod)new ScrollingMovementMethod());
    this.rfH = new LinkedList();
    this.rfI = new SpannableStringBuilder();
    AppMethodBeat.o(319783);
  }
  
  private static final void a(e parame)
  {
    AppMethodBeat.i(319799);
    s.u(parame, "this$0");
    int i = parame.getLayout().getLineTop(parame.getLineCount()) - parame.getHeight();
    if (i > 0) {
      parame.scrollTo(0, i);
    }
    AppMethodBeat.o(319799);
  }
  
  private final void cr(String paramString, int paramInt)
  {
    AppMethodBeat.i(319791);
    if (1000 <= this.rfH.size())
    {
      localObject = (String)this.rfH.removeFirst();
      this.rfI.delete(0, ((String)localObject).length());
    }
    Object localObject = new SpannableString((CharSequence)paramString);
    ((SpannableString)localObject).setSpan(new ForegroundColorSpan(paramInt), 0, paramString.length(), 33);
    this.rfI.append((CharSequence)localObject);
    setText((CharSequence)this.rfI);
    post(new e..ExternalSyntheticLambda0(this));
    this.rfH.addLast(paramString);
    AppMethodBeat.o(319791);
  }
  
  public final void Yo(String paramString)
  {
    AppMethodBeat.i(319825);
    s.u(paramString, "msg");
    if (DEBUG) {
      Log.d("MicroMsg.AppBrand.ConsolePrintView", s.X("appendVerboseLine, msg: ", paramString));
    }
    cr("[V]" + paramString + '\n', androidx.core.content.a.w(getContext(), ba.c.FG_2));
    AppMethodBeat.o(319825);
  }
  
  public final void Yp(String paramString)
  {
    AppMethodBeat.i(319831);
    s.u(paramString, "msg");
    if (DEBUG) {
      Log.d("MicroMsg.AppBrand.ConsolePrintView", s.X("appendDebugLine, msg: ", paramString));
    }
    cr("[D]" + paramString + '\n', androidx.core.content.a.w(getContext(), ba.c.FG_0));
    AppMethodBeat.o(319831);
  }
  
  public final void Yq(String paramString)
  {
    AppMethodBeat.i(319837);
    s.u(paramString, "msg");
    if (DEBUG) {
      Log.d("MicroMsg.AppBrand.ConsolePrintView", s.X("appendInfoLine, msg: ", paramString));
    }
    cr("[I]" + paramString + '\n', androidx.core.content.a.w(getContext(), ba.c.FG_0));
    AppMethodBeat.o(319837);
  }
  
  public final void Yr(String paramString)
  {
    AppMethodBeat.i(319844);
    s.u(paramString, "msg");
    if (DEBUG) {
      Log.d("MicroMsg.AppBrand.ConsolePrintView", s.X("appendWarnLine, msg: ", paramString));
    }
    cr("[W]" + paramString + '\n', androidx.core.content.a.w(getContext(), ba.c.Orange_80_CARE));
    AppMethodBeat.o(319844);
  }
  
  public final void Ys(String paramString)
  {
    AppMethodBeat.i(319849);
    s.u(paramString, "msg");
    if (DEBUG) {
      Log.d("MicroMsg.AppBrand.ConsolePrintView", s.X("appendErrorLine, msg: ", paramString));
    }
    cr("[E]" + paramString + '\n', androidx.core.content.a.w(getContext(), ba.c.Red_80_CARE));
    AppMethodBeat.o(319849);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.console.e
 * JD-Core Version:    0.7.0.1
 */