package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.game.d.w;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.f.e.a.a;
import com.tencent.mm.plugin.game.g.c;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.LinkedList;

public class GameFeedTitleDescView
  extends LinearLayout
{
  private TextView haW;
  private TextView iIV;
  private LinearLayout lbF;
  
  public GameFeedTitleDescView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final void a(String paramString1, String paramString2, LinkedList<w> paramLinkedList)
  {
    int k = 0;
    if ((bk.bl(paramString1)) && (bk.bl(paramString2)))
    {
      setVisibility(8);
      return;
    }
    setVisibility(0);
    int i;
    int j;
    label340:
    int m;
    if (!bk.dk(paramLinkedList))
    {
      this.lbF.setVisibility(0);
      ImageView localImageView;
      Object localObject1;
      while (this.lbF.getChildCount() < paramLinkedList.size() + 1)
      {
        localImageView = new ImageView(getContext());
        localObject1 = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(g.c.GameSmallAvatarSize), getResources().getDimensionPixelSize(g.c.GameSmallAvatarSize));
        ((LinearLayout.LayoutParams)localObject1).setMargins(0, 0, getResources().getDimensionPixelSize(g.c.GameMiniPadding), 0);
        ((LinearLayout.LayoutParams)localObject1).gravity = 16;
        localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.lbF.addView(localImageView, 0, (ViewGroup.LayoutParams)localObject1);
      }
      i = 0;
      for (;;)
      {
        j = i;
        if (i >= paramLinkedList.size()) {
          break;
        }
        Object localObject2 = (w)paramLinkedList.get(i);
        localImageView = (ImageView)this.lbF.getChildAt(i);
        localObject1 = e.baw();
        localObject2 = ((w)localObject2).kSF;
        e.a.a locala = new e.a.a();
        locala.erD = true;
        ((e)localObject1).a(localImageView, (String)localObject2, locala.bax(), null);
        localImageView.setVisibility(0);
        i += 1;
      }
      while (j < this.lbF.getChildCount() - 1)
      {
        this.lbF.getChildAt(j).setVisibility(8);
        j += 1;
      }
      if (!bk.bl(paramString1)) {
        ((TextView)this.lbF.getChildAt(j)).setText(paramString1);
      }
      this.haW.setVisibility(8);
      if (bk.bl(paramString2)) {
        break label451;
      }
      this.iIV.setText(paramString2);
      this.iIV.setVisibility(0);
      paramString2 = this.haW;
      i = c.getScreenWidth(getContext());
      j = ((ViewGroup)getParent()).getPaddingLeft();
      m = ((ViewGroup)getParent()).getPaddingRight();
      if (!bk.bl(paramString1)) {
        break label463;
      }
      i = k;
    }
    for (;;)
    {
      if (i <= 1) {
        break label496;
      }
      this.iIV.setMaxLines(1);
      return;
      this.lbF.setVisibility(8);
      if (!bk.bl(paramString1))
      {
        this.haW.setText(paramString1);
        this.haW.setVisibility(0);
        break;
      }
      this.haW.setVisibility(8);
      break;
      label451:
      this.iIV.setVisibility(8);
      break label340;
      label463:
      if (paramString2.getPaint().measureText(paramString1) > i - j - m) {
        i = 2;
      } else {
        i = 1;
      }
    }
    label496:
    this.iIV.setMaxLines(2);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    View localView = LayoutInflater.from(getContext()).inflate(g.f.game_feed_title_desc_view, this, true);
    this.lbF = ((LinearLayout)localView.findViewById(g.e.user_title_container));
    this.haW = ((TextView)localView.findViewById(g.e.title));
    this.iIV = ((TextView)localView.findViewById(g.e.desc));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedTitleDescView
 * JD-Core Version:    0.7.0.1
 */