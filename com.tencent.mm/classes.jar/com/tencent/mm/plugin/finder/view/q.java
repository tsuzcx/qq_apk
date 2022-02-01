package com.tencent.mm.plugin.finder.view;

import android.content.res.Resources;
import android.graphics.Paint;
import android.text.TextPaint;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.pluginsdk.ui.span.t;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.aw;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderTextClickSpan;", "Lcom/tencent/mm/pluginsdk/ui/span/PressableClickSpan;", "text", "", "textColor", "", "clickBgColor", "bold", "", "isTopic", "onClick", "Lkotlin/Function1;", "", "(Ljava/lang/String;IIZZLkotlin/jvm/functions/Function1;)V", "getBold", "()Z", "setBold", "(Z)V", "canClick", "getCanClick", "setCanClick", "getClickBgColor", "()I", "setClickBgColor", "(I)V", "isActivity", "setActivity", "isAtProfile", "setAtProfile", "isPoi", "setPoi", "setTopic", "getOnClick", "()Lkotlin/jvm/functions/Function1;", "setOnClick", "(Lkotlin/jvm/functions/Function1;)V", "shadowRadius", "", "getShadowRadius", "()F", "setShadowRadius", "(F)V", "getText", "()Ljava/lang/String;", "getTextColor", "setTextColor", "widget", "Landroid/view/View;", "setColor", "linkColor", "backgroundColor", "updateDrawState", "ds", "Landroid/text/TextPaint;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public class q
  extends t
{
  public static final a GDf;
  private static final int GDj;
  public boolean Abi;
  private int Abj;
  private b<? super String, ah> DMY;
  public boolean GDg;
  public boolean GDh;
  public boolean GDi;
  private boolean bold;
  public float shadowRadius;
  public final String text;
  private int textColor;
  public boolean zID;
  
  static
  {
    AppMethodBeat.i(344246);
    GDf = new a((byte)0);
    GDj = MMApplicationContext.getResources().getColor(e.b.hot_tab_BW_0_Alpha_0_1);
    AppMethodBeat.o(344246);
  }
  
  public q(String paramString, int paramInt1, int paramInt2, boolean paramBoolean, b<? super String, ah> paramb)
  {
    super(paramInt1, paramInt2);
    AppMethodBeat.i(344235);
    this.text = paramString;
    this.textColor = paramInt1;
    this.Abj = paramInt2;
    this.bold = false;
    this.GDg = paramBoolean;
    this.DMY = paramb;
    this.Abi = true;
    AppMethodBeat.o(344235);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(168418);
    s.u(paramView, "widget");
    if (this.Abi) {
      this.DMY.invoke(this.text);
    }
    AppMethodBeat.o(168418);
  }
  
  public void setColor(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(168419);
    super.setColor(paramInt1, paramInt2);
    this.textColor = paramInt1;
    this.Abj = paramInt2;
    AppMethodBeat.o(168419);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(344263);
    s.u(paramTextPaint, "ds");
    super.updateDrawState(paramTextPaint);
    if (this.bold) {
      aw.a((Paint)paramTextPaint, 0.8F);
    }
    if (this.shadowRadius > 0.0F) {
      paramTextPaint.setShadowLayer(this.shadowRadius, 0.0F, 0.0F, GDj);
    }
    AppMethodBeat.o(344263);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderTextClickSpan$Companion;", "", "()V", "SHADOW_COLOR", "", "getSHADOW_COLOR", "()I", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.q
 * JD-Core Version:    0.7.0.1
 */