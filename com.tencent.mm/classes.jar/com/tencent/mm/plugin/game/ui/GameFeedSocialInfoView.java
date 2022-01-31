package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.d.y;
import com.tencent.mm.plugin.game.widget.GameSmallAvatarList;
import com.tencent.mm.sdk.platformtools.bo;

public class GameFeedSocialInfoView
  extends LinearLayout
{
  private TextView kPB;
  private LinearLayout nzq;
  private GameSmallAvatarList nzr;
  private TextView nzs;
  private LinearLayout nzt;
  
  public GameFeedSocialInfoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(111948);
    super.onFinishInflate();
    this.nzq = ((LinearLayout)findViewById(2131824771));
    this.nzr = ((GameSmallAvatarList)findViewById(2131824772));
    this.nzs = ((TextView)findViewById(2131824773));
    this.nzt = ((LinearLayout)findViewById(2131821115));
    this.kPB = ((TextView)findViewById(2131824774));
    AppMethodBeat.o(111948);
  }
  
  public void setData(y paramy)
  {
    AppMethodBeat.i(111949);
    if ((!bo.es(paramy.nqZ)) || (paramy.nra != null))
    {
      this.nzq.setVisibility(0);
      this.nzr.setData(paramy.nqZ);
      if (paramy.nra != null)
      {
        this.nzs.setText(paramy.nra);
        this.nzs.setVisibility(0);
      }
    }
    while (paramy.Desc != null)
    {
      this.nzt.setVisibility(0);
      this.kPB.setText(paramy.Desc);
      AppMethodBeat.o(111949);
      return;
      this.nzs.setVisibility(8);
      continue;
      this.nzq.setVisibility(8);
    }
    this.nzt.setVisibility(8);
    AppMethodBeat.o(111949);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedSocialInfoView
 * JD-Core Version:    0.7.0.1
 */