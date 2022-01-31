package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.game.g.a;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.am;
import java.util.ArrayList;
import java.util.List;

public class GameDetailAutoScrollView
  extends LinearLayout
{
  private int jiU = 0;
  private am kXj = new am(new GameDetailAutoScrollView.1(this), true);
  private ArrayList<String> kYI = new ArrayList();
  private ViewGroup kYJ;
  private TextView kYK;
  private TextView kYL;
  private ViewGroup kYM;
  private TextView kYN;
  private TextView kYO;
  private Animation kYP;
  private Animation kYQ;
  
  public GameDetailAutoScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.kYJ = ((ViewGroup)LayoutInflater.from(paramContext).inflate(g.f.game_detail2_brief_item, this, false));
    this.kYK = ((TextView)this.kYJ.findViewById(g.e.game_detail_brief_item_text1));
    this.kYL = ((TextView)this.kYJ.findViewById(g.e.game_detail_brief_item_text2));
    addView(this.kYJ);
    this.kYJ.setVisibility(8);
    this.kYM = ((ViewGroup)LayoutInflater.from(paramContext).inflate(g.f.game_detail2_brief_item, this, false));
    this.kYN = ((TextView)this.kYM.findViewById(g.e.game_detail_brief_item_text1));
    this.kYO = ((TextView)this.kYM.findViewById(g.e.game_detail_brief_item_text2));
    addView(this.kYM);
    this.kYM.setVisibility(8);
    this.kYP = AnimationUtils.loadAnimation(paramContext, g.a.slide_bottom_in);
    this.kYQ = AnimationUtils.loadAnimation(paramContext, g.a.slide_top_out);
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
    if ((paramList == null) || (paramList.size() == 0) || (paramList.size() % 2 != 0))
    {
      this.kYJ.setVisibility(8);
      this.kYM.setVisibility(8);
    }
    do
    {
      return;
      this.kYI.addAll(paramList);
      this.jiU = 0;
      paramList = j.a(getContext(), (CharSequence)this.kYI.get(0), this.kYK.getTextSize());
      this.kYK.setText(paramList);
      this.kYL.setText((CharSequence)this.kYI.get(1));
      this.kYJ.setVisibility(0);
      this.kYM.setVisibility(8);
    } while (this.kYI.size() / 2 == 1);
    this.kXj.S(5000L, 5000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDetailAutoScrollView
 * JD-Core Version:    0.7.0.1
 */