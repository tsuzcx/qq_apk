package com.tencent.mm.plugin.game.widget;

import android.content.Context;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import java.util.ArrayList;
import java.util.List;

public class AutoScrollTextView
  extends LinearLayout
{
  private int oIf;
  private av seP;
  private ArrayList<String> sgg;
  private Animation sgn;
  private Animation sgo;
  private TextView soI;
  private TextView soJ;
  
  public AutoScrollTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(42571);
    this.sgg = new ArrayList();
    this.oIf = 0;
    this.seP = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(42570);
        AutoScrollTextView.a(AutoScrollTextView.this);
        AppMethodBeat.o(42570);
        return true;
      }
    }, true);
    this.soI = new TextView(paramContext, paramAttributeSet);
    this.soI.setVisibility(8);
    this.soJ = new TextView(paramContext, paramAttributeSet);
    this.soJ.setVisibility(8);
    addView(this.soI);
    addView(this.soJ);
    setOrientation(1);
    setGravity(17);
    setPadding(0, 0, 0, 0);
    this.sgn = AnimationUtils.loadAnimation(paramContext, 2130772139);
    this.sgo = AnimationUtils.loadAnimation(paramContext, 2130772147);
    AppMethodBeat.o(42571);
  }
  
  private void c(TextView paramTextView, String paramString)
  {
    AppMethodBeat.i(42573);
    paramTextView.setText(new SpannableString(k.b(getContext(), paramString, paramTextView.getTextSize())));
    AppMethodBeat.o(42573);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(42574);
    super.onDetachedFromWindow();
    this.seP.stopTimer();
    AppMethodBeat.o(42574);
  }
  
  public void setText(List<String> paramList)
  {
    AppMethodBeat.i(42572);
    this.sgg.clear();
    this.seP.stopTimer();
    if ((paramList == null) || (paramList.size() == 0))
    {
      this.soI.setVisibility(8);
      this.soJ.setVisibility(8);
      AppMethodBeat.o(42572);
      return;
    }
    this.sgg.addAll(paramList);
    c(this.soI, (String)this.sgg.get(0));
    this.soI.setVisibility(0);
    this.oIf = 0;
    if (this.sgg.size() == 1)
    {
      AppMethodBeat.o(42572);
      return;
    }
    this.seP.av(5000L, 5000L);
    AppMethodBeat.o(42572);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.widget.AutoScrollTextView
 * JD-Core Version:    0.7.0.1
 */