package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.d.aa;
import com.tencent.mm.plugin.game.widget.GameSmallAvatarList;
import com.tencent.mm.sdk.platformtools.bt;

public class GameFeedSocialInfoView
  extends LinearLayout
{
  private TextView kFd;
  private LinearLayout siQ;
  private GameSmallAvatarList siR;
  private TextView siS;
  private LinearLayout siT;
  
  public GameFeedSocialInfoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42128);
    super.onFinishInflate();
    this.siQ = ((LinearLayout)findViewById(2131297011));
    this.siR = ((GameSmallAvatarList)findViewById(2131297012));
    this.siS = ((TextView)findViewById(2131297003));
    this.siT = ((LinearLayout)findViewById(2131298996));
    this.kFd = ((TextView)findViewById(2131299007));
    AppMethodBeat.o(42128);
  }
  
  public void setData(aa paramaa)
  {
    AppMethodBeat.i(42129);
    if ((!bt.gL(paramaa.saC)) || (paramaa.saD != null))
    {
      this.siQ.setVisibility(0);
      this.siR.setData(paramaa.saC);
      if (paramaa.saD != null)
      {
        this.siS.setText(paramaa.saD);
        this.siS.setVisibility(0);
      }
    }
    while (paramaa.Desc != null)
    {
      this.siT.setVisibility(0);
      this.kFd.setText(paramaa.Desc);
      AppMethodBeat.o(42129);
      return;
      this.siS.setVisibility(8);
      continue;
      this.siQ.setVisibility(8);
    }
    this.siT.setVisibility(8);
    AppMethodBeat.o(42129);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedSocialInfoView
 * JD-Core Version:    0.7.0.1
 */