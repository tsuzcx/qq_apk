package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.d.ab;
import com.tencent.mm.plugin.game.widget.GameSmallAvatarList;
import com.tencent.mm.sdk.platformtools.bt;

public class GameFeedSocialInfoView
  extends LinearLayout
{
  private TextView lDu;
  private LinearLayout upg;
  private GameSmallAvatarList uph;
  private TextView upi;
  private LinearLayout upj;
  
  public GameFeedSocialInfoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42128);
    super.onFinishInflate();
    this.upg = ((LinearLayout)findViewById(2131297011));
    this.uph = ((GameSmallAvatarList)findViewById(2131297012));
    this.upi = ((TextView)findViewById(2131297003));
    this.upj = ((LinearLayout)findViewById(2131298996));
    this.lDu = ((TextView)findViewById(2131299007));
    AppMethodBeat.o(42128);
  }
  
  public void setData(ab paramab)
  {
    AppMethodBeat.i(42129);
    if ((!bt.hj(paramab.ugp)) || (paramab.ugq != null))
    {
      this.upg.setVisibility(0);
      this.uph.setData(paramab.ugp);
      if (paramab.ugq != null)
      {
        this.upi.setText(paramab.ugq);
        this.upi.setVisibility(0);
      }
    }
    while (paramab.Desc != null)
    {
      this.upj.setVisibility(0);
      this.lDu.setText(paramab.Desc);
      AppMethodBeat.o(42129);
      return;
      this.upi.setVisibility(8);
      continue;
      this.upg.setVisibility(8);
    }
    this.upj.setVisibility(8);
    AppMethodBeat.o(42129);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedSocialInfoView
 * JD-Core Version:    0.7.0.1
 */