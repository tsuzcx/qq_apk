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
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import java.util.ArrayList;
import java.util.List;

public class AutoScrollTextView
  extends LinearLayout
{
  private int plF;
  private au tmI;
  private ArrayList<String> tnZ;
  private Animation tog;
  private Animation toh;
  private TextView twB;
  private TextView twC;
  
  public AutoScrollTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(42571);
    this.tnZ = new ArrayList();
    this.plF = 0;
    this.tmI = new au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(42570);
        AutoScrollTextView.a(AutoScrollTextView.this);
        AppMethodBeat.o(42570);
        return true;
      }
    }, true);
    this.twB = new TextView(paramContext, paramAttributeSet);
    this.twB.setVisibility(8);
    this.twC = new TextView(paramContext, paramAttributeSet);
    this.twC.setVisibility(8);
    addView(this.twB);
    addView(this.twC);
    setOrientation(1);
    setGravity(17);
    setPadding(0, 0, 0, 0);
    this.tog = AnimationUtils.loadAnimation(paramContext, 2130772139);
    this.toh = AnimationUtils.loadAnimation(paramContext, 2130772147);
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
    this.tmI.stopTimer();
    AppMethodBeat.o(42574);
  }
  
  public void setText(List<String> paramList)
  {
    AppMethodBeat.i(42572);
    this.tnZ.clear();
    this.tmI.stopTimer();
    if ((paramList == null) || (paramList.size() == 0))
    {
      this.twB.setVisibility(8);
      this.twC.setVisibility(8);
      AppMethodBeat.o(42572);
      return;
    }
    this.tnZ.addAll(paramList);
    c(this.twB, (String)this.tnZ.get(0));
    this.twB.setVisibility(0);
    this.plF = 0;
    if (this.tnZ.size() == 1)
    {
      AppMethodBeat.o(42572);
      return;
    }
    this.tmI.au(5000L, 5000L);
    AppMethodBeat.o(42572);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.widget.AutoScrollTextView
 * JD-Core Version:    0.7.0.1
 */