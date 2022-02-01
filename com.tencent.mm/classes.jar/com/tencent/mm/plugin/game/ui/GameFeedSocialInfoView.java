package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.d.ag;
import com.tencent.mm.plugin.game.widget.GameSmallAvatarList;
import com.tencent.mm.sdk.platformtools.bu;

public class GameFeedSocialInfoView
  extends LinearLayout
{
  private TextView lHT;
  private LinearLayout uAC;
  private GameSmallAvatarList uAD;
  private TextView uAE;
  private LinearLayout uAF;
  
  public GameFeedSocialInfoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42128);
    super.onFinishInflate();
    this.uAC = ((LinearLayout)findViewById(2131297011));
    this.uAD = ((GameSmallAvatarList)findViewById(2131297012));
    this.uAE = ((TextView)findViewById(2131297003));
    this.uAF = ((LinearLayout)findViewById(2131298996));
    this.lHT = ((TextView)findViewById(2131299007));
    AppMethodBeat.o(42128);
  }
  
  public void setData(ag paramag)
  {
    AppMethodBeat.i(42129);
    if ((!bu.ht(paramag.urM)) || (paramag.urN != null))
    {
      this.uAC.setVisibility(0);
      this.uAD.setData(paramag.urM);
      if (paramag.urN != null)
      {
        this.uAE.setText(paramag.urN);
        this.uAE.setVisibility(0);
      }
    }
    while (paramag.Desc != null)
    {
      this.uAF.setVisibility(0);
      this.lHT.setText(paramag.Desc);
      AppMethodBeat.o(42129);
      return;
      this.uAE.setVisibility(8);
      continue;
      this.uAC.setVisibility(8);
    }
    this.uAF.setVisibility(8);
    AppMethodBeat.o(42129);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedSocialInfoView
 * JD-Core Version:    0.7.0.1
 */