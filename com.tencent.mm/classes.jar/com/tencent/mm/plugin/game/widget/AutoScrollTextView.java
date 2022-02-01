package com.tencent.mm.plugin.game.widget;

import android.content.Context;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.h.a;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import java.util.ArrayList;
import java.util.List;

public class AutoScrollTextView
  extends LinearLayout
{
  private MTimerHandler INf;
  private Animation IOB;
  private Animation IOC;
  private ArrayList<String> IOu;
  private TextView IYw;
  private TextView IYx;
  private int xYG;
  
  public AutoScrollTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(42571);
    this.IOu = new ArrayList();
    this.xYG = 0;
    this.INf = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(42570);
        AutoScrollTextView.a(AutoScrollTextView.this);
        AppMethodBeat.o(42570);
        return true;
      }
    }, true);
    this.IYw = new TextView(paramContext, paramAttributeSet);
    this.IYw.setVisibility(8);
    this.IYx = new TextView(paramContext, paramAttributeSet);
    this.IYx.setVisibility(8);
    addView(this.IYw);
    addView(this.IYx);
    setOrientation(1);
    setGravity(17);
    setPadding(0, 0, 0, 0);
    this.IOB = AnimationUtils.loadAnimation(paramContext, h.a.slide_bottom_in);
    this.IOC = AnimationUtils.loadAnimation(paramContext, h.a.slide_top_out);
    AppMethodBeat.o(42571);
  }
  
  private void f(TextView paramTextView, String paramString)
  {
    AppMethodBeat.i(42573);
    paramTextView.setText(new SpannableString(p.b(getContext(), paramString, paramTextView.getTextSize())));
    AppMethodBeat.o(42573);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(42574);
    super.onDetachedFromWindow();
    this.INf.stopTimer();
    AppMethodBeat.o(42574);
  }
  
  public void setText(List<String> paramList)
  {
    AppMethodBeat.i(42572);
    this.IOu.clear();
    this.INf.stopTimer();
    if ((paramList == null) || (paramList.size() == 0))
    {
      this.IYw.setVisibility(8);
      this.IYx.setVisibility(8);
      AppMethodBeat.o(42572);
      return;
    }
    this.IOu.addAll(paramList);
    f(this.IYw, (String)this.IOu.get(0));
    this.IYw.setVisibility(0);
    this.xYG = 0;
    if (this.IOu.size() == 1)
    {
      AppMethodBeat.o(42572);
      return;
    }
    this.INf.startTimer(5000L);
    AppMethodBeat.o(42572);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.widget.AutoScrollTextView
 * JD-Core Version:    0.7.0.1
 */