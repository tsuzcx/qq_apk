package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.h.e;
import com.tencent.mm.plugin.game.protobuf.aj;
import com.tencent.mm.plugin.game.widget.GameSmallAvatarList;
import com.tencent.mm.sdk.platformtools.Util;

public class GameFeedSocialInfoView
  extends LinearLayout
{
  private LinearLayout IRd;
  private GameSmallAvatarList IRe;
  private TextView IRf;
  private LinearLayout IRg;
  private TextView pJi;
  
  public GameFeedSocialInfoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42128);
    super.onFinishInflate();
    this.IRd = ((LinearLayout)findViewById(h.e.avatar_layout));
    this.IRe = ((GameSmallAvatarList)findViewById(h.e.avatar_list));
    this.IRf = ((TextView)findViewById(h.e.avatar_desc));
    this.IRg = ((LinearLayout)findViewById(h.e.desc));
    this.pJi = ((TextView)findViewById(h.e.desc_text));
    AppMethodBeat.o(42128);
  }
  
  public void setData(aj paramaj)
  {
    AppMethodBeat.i(42129);
    if ((!Util.isNullOrNil(paramaj.IIv)) || (paramaj.IIw != null))
    {
      this.IRd.setVisibility(0);
      this.IRe.setData(paramaj.IIv);
      if (paramaj.IIw != null)
      {
        this.IRf.setText(paramaj.IIw);
        this.IRf.setVisibility(0);
      }
    }
    while (paramaj.IGG != null)
    {
      this.IRg.setVisibility(0);
      this.pJi.setText(paramaj.IGG);
      AppMethodBeat.o(42129);
      return;
      this.IRf.setVisibility(8);
      continue;
      this.IRd.setVisibility(8);
    }
    this.IRg.setVisibility(8);
    AppMethodBeat.o(42129);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedSocialInfoView
 * JD-Core Version:    0.7.0.1
 */