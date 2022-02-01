package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.protobuf.ai;
import com.tencent.mm.plugin.game.widget.GameSmallAvatarList;
import com.tencent.mm.sdk.platformtools.Util;

public class GameFeedSocialInfoView
  extends LinearLayout
{
  private LinearLayout CWM;
  private GameSmallAvatarList CWN;
  private TextView CWO;
  private LinearLayout CWP;
  private TextView mMA;
  
  public GameFeedSocialInfoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42128);
    super.onFinishInflate();
    this.CWM = ((LinearLayout)findViewById(g.e.avatar_layout));
    this.CWN = ((GameSmallAvatarList)findViewById(g.e.avatar_list));
    this.CWO = ((TextView)findViewById(g.e.avatar_desc));
    this.CWP = ((LinearLayout)findViewById(g.e.desc));
    this.mMA = ((TextView)findViewById(g.e.desc_text));
    AppMethodBeat.o(42128);
  }
  
  public void setData(ai paramai)
  {
    AppMethodBeat.i(42129);
    if ((!Util.isNullOrNil(paramai.COl)) || (paramai.COm != null))
    {
      this.CWM.setVisibility(0);
      this.CWN.setData(paramai.COl);
      if (paramai.COm != null)
      {
        this.CWO.setText(paramai.COm);
        this.CWO.setVisibility(0);
      }
    }
    while (paramai.CMB != null)
    {
      this.CWP.setVisibility(0);
      this.mMA.setText(paramai.CMB);
      AppMethodBeat.o(42129);
      return;
      this.CWO.setVisibility(8);
      continue;
      this.CWM.setVisibility(8);
    }
    this.CWP.setVisibility(8);
    AppMethodBeat.o(42129);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedSocialInfoView
 * JD-Core Version:    0.7.0.1
 */