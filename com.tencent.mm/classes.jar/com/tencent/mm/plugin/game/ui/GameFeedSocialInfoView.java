package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.protobuf.ah;
import com.tencent.mm.plugin.game.widget.GameSmallAvatarList;
import com.tencent.mm.sdk.platformtools.Util;

public class GameFeedSocialInfoView
  extends LinearLayout
{
  private TextView jVn;
  private LinearLayout xSB;
  private GameSmallAvatarList xSC;
  private TextView xSD;
  private LinearLayout xSE;
  
  public GameFeedSocialInfoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42128);
    super.onFinishInflate();
    this.xSB = ((LinearLayout)findViewById(2131297137));
    this.xSC = ((GameSmallAvatarList)findViewById(2131297139));
    this.xSD = ((TextView)findViewById(2131297129));
    this.xSE = ((LinearLayout)findViewById(2131299495));
    this.jVn = ((TextView)findViewById(2131299509));
    AppMethodBeat.o(42128);
  }
  
  public void setData(ah paramah)
  {
    AppMethodBeat.i(42129);
    if ((!Util.isNullOrNil(paramah.xKe)) || (paramah.xKf != null))
    {
      this.xSB.setVisibility(0);
      this.xSC.setData(paramah.xKe);
      if (paramah.xKf != null)
      {
        this.xSD.setText(paramah.xKf);
        this.xSD.setVisibility(0);
      }
    }
    while (paramah.Desc != null)
    {
      this.xSE.setVisibility(0);
      this.jVn.setText(paramah.Desc);
      AppMethodBeat.o(42129);
      return;
      this.xSD.setVisibility(8);
      continue;
      this.xSB.setVisibility(8);
    }
    this.xSE.setVisibility(8);
    AppMethodBeat.o(42129);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedSocialInfoView
 * JD-Core Version:    0.7.0.1
 */