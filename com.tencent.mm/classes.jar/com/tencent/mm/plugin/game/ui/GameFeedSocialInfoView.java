package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.d.aa;
import com.tencent.mm.plugin.game.widget.GameSmallAvatarList;
import com.tencent.mm.sdk.platformtools.bs;

public class GameFeedSocialInfoView
  extends LinearLayout
{
  private TextView lgw;
  private LinearLayout tqJ;
  private GameSmallAvatarList tqK;
  private TextView tqL;
  private LinearLayout tqM;
  
  public GameFeedSocialInfoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42128);
    super.onFinishInflate();
    this.tqJ = ((LinearLayout)findViewById(2131297011));
    this.tqK = ((GameSmallAvatarList)findViewById(2131297012));
    this.tqL = ((TextView)findViewById(2131297003));
    this.tqM = ((LinearLayout)findViewById(2131298996));
    this.lgw = ((TextView)findViewById(2131299007));
    AppMethodBeat.o(42128);
  }
  
  public void setData(aa paramaa)
  {
    AppMethodBeat.i(42129);
    if ((!bs.gY(paramaa.tiw)) || (paramaa.tix != null))
    {
      this.tqJ.setVisibility(0);
      this.tqK.setData(paramaa.tiw);
      if (paramaa.tix != null)
      {
        this.tqL.setText(paramaa.tix);
        this.tqL.setVisibility(0);
      }
    }
    while (paramaa.Desc != null)
    {
      this.tqM.setVisibility(0);
      this.lgw.setText(paramaa.Desc);
      AppMethodBeat.o(42129);
      return;
      this.tqL.setVisibility(8);
      continue;
      this.tqJ.setVisibility(8);
    }
    this.tqM.setVisibility(8);
    AppMethodBeat.o(42129);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedSocialInfoView
 * JD-Core Version:    0.7.0.1
 */