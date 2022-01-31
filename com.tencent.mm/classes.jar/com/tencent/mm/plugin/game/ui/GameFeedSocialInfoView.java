package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.game.d.x;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.widget.GameSmallAvatarList;
import com.tencent.mm.sdk.platformtools.bk;

public class GameFeedSocialInfoView
  extends LinearLayout
{
  private TextView iIV;
  private LinearLayout lbv;
  private GameSmallAvatarList lbw;
  private TextView lbx;
  private LinearLayout lby;
  
  public GameFeedSocialInfoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.lbv = ((LinearLayout)findViewById(g.e.avatar_layout));
    this.lbw = ((GameSmallAvatarList)findViewById(g.e.avatar_list));
    this.lbx = ((TextView)findViewById(g.e.avatar_desc));
    this.lby = ((LinearLayout)findViewById(g.e.desc));
    this.iIV = ((TextView)findViewById(g.e.desc_text));
  }
  
  public void setData(x paramx)
  {
    if ((!bk.dk(paramx.kSZ)) || (paramx.kTa != null))
    {
      this.lbv.setVisibility(0);
      this.lbw.setData(paramx.kSZ);
      if (paramx.kTa != null)
      {
        this.lbx.setText(paramx.kTa);
        this.lbx.setVisibility(0);
      }
    }
    while (paramx.kRN != null)
    {
      this.lby.setVisibility(0);
      this.iIV.setText(paramx.kRN);
      return;
      this.lbx.setVisibility(8);
      continue;
      this.lbv.setVisibility(8);
    }
    this.lby.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedSocialInfoView
 * JD-Core Version:    0.7.0.1
 */