package com.tencent.mm.plugin.game.widget;

import android.content.Context;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.game.g.a;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.am;
import java.util.ArrayList;
import java.util.List;

public class AutoScrollTextView
  extends LinearLayout
{
  private int jiU = 0;
  private am kXj = new am(new AutoScrollTextView.1(this), true);
  private ArrayList<String> kYI = new ArrayList();
  private Animation kYP;
  private Animation kYQ;
  private TextView lgF;
  private TextView lgG;
  
  public AutoScrollTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.lgF = new TextView(paramContext, paramAttributeSet);
    this.lgF.setVisibility(8);
    this.lgG = new TextView(paramContext, paramAttributeSet);
    this.lgG.setVisibility(8);
    addView(this.lgF);
    addView(this.lgG);
    setOrientation(1);
    setGravity(17);
    setPadding(0, 0, 0, 0);
    this.kYP = AnimationUtils.loadAnimation(paramContext, g.a.slide_bottom_in);
    this.kYQ = AnimationUtils.loadAnimation(paramContext, g.a.slide_top_out);
  }
  
  private void b(TextView paramTextView, String paramString)
  {
    paramTextView.setText(new SpannableString(j.a(getContext(), paramString, paramTextView.getTextSize())));
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.kXj.stopTimer();
  }
  
  public void setText(List<String> paramList)
  {
    this.kYI.clear();
    this.kXj.stopTimer();
    if ((paramList == null) || (paramList.size() == 0))
    {
      this.lgF.setVisibility(8);
      this.lgG.setVisibility(8);
    }
    do
    {
      return;
      this.kYI.addAll(paramList);
      b(this.lgF, (String)this.kYI.get(0));
      this.lgF.setVisibility(0);
      this.jiU = 0;
    } while (this.kYI.size() == 1);
    this.kXj.S(5000L, 5000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.widget.AutoScrollTextView
 * JD-Core Version:    0.7.0.1
 */