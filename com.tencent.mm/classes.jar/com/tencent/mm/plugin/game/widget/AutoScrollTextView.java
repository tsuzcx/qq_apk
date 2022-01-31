package com.tencent.mm.plugin.game.widget;

import android.content.Context;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import java.util.ArrayList;
import java.util.List;

public class AutoScrollTextView
  extends LinearLayout
{
  private int lrL;
  private TextView nEA;
  private TextView nEz;
  private ap nvk;
  private ArrayList<String> nwF;
  private Animation nwM;
  private Animation nwN;
  
  public AutoScrollTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(112366);
    this.nwF = new ArrayList();
    this.lrL = 0;
    this.nvk = new ap(new ap.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(112365);
        AutoScrollTextView.a(AutoScrollTextView.this);
        AppMethodBeat.o(112365);
        return true;
      }
    }, true);
    this.nEz = new TextView(paramContext, paramAttributeSet);
    this.nEz.setVisibility(8);
    this.nEA = new TextView(paramContext, paramAttributeSet);
    this.nEA.setVisibility(8);
    addView(this.nEz);
    addView(this.nEA);
    setOrientation(1);
    setGravity(17);
    setPadding(0, 0, 0, 0);
    this.nwM = AnimationUtils.loadAnimation(paramContext, 2131034261);
    this.nwN = AnimationUtils.loadAnimation(paramContext, 2131034269);
    AppMethodBeat.o(112366);
  }
  
  private void b(TextView paramTextView, String paramString)
  {
    AppMethodBeat.i(112368);
    paramTextView.setText(new SpannableString(j.b(getContext(), paramString, paramTextView.getTextSize())));
    AppMethodBeat.o(112368);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(112369);
    super.onDetachedFromWindow();
    this.nvk.stopTimer();
    AppMethodBeat.o(112369);
  }
  
  public void setText(List<String> paramList)
  {
    AppMethodBeat.i(112367);
    this.nwF.clear();
    this.nvk.stopTimer();
    if ((paramList == null) || (paramList.size() == 0))
    {
      this.nEz.setVisibility(8);
      this.nEA.setVisibility(8);
      AppMethodBeat.o(112367);
      return;
    }
    this.nwF.addAll(paramList);
    b(this.nEz, (String)this.nwF.get(0));
    this.nEz.setVisibility(0);
    this.lrL = 0;
    if (this.nwF.size() == 1)
    {
      AppMethodBeat.o(112367);
      return;
    }
    this.nvk.ag(5000L, 5000L);
    AppMethodBeat.o(112367);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.widget.AutoScrollTextView
 * JD-Core Version:    0.7.0.1
 */