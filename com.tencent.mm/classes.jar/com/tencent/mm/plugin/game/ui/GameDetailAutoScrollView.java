package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import java.util.ArrayList;
import java.util.List;

public class GameDetailAutoScrollView
  extends LinearLayout
{
  private int pVK;
  private aw uwE;
  private ArrayList<String> uxU;
  private ViewGroup uxV;
  private TextView uxW;
  private TextView uxX;
  private ViewGroup uxY;
  private TextView uxZ;
  private TextView uya;
  private Animation uyb;
  private Animation uyc;
  
  public GameDetailAutoScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(41975);
    this.uxU = new ArrayList();
    this.pVK = 0;
    this.uwE = new aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(41974);
        GameDetailAutoScrollView.a(GameDetailAutoScrollView.this);
        AppMethodBeat.o(41974);
        return true;
      }
    }, true);
    this.uxV = ((ViewGroup)LayoutInflater.from(paramContext).inflate(2131494280, this, false));
    this.uxW = ((TextView)this.uxV.findViewById(2131300376));
    this.uxX = ((TextView)this.uxV.findViewById(2131300377));
    addView(this.uxV);
    this.uxV.setVisibility(8);
    this.uxY = ((ViewGroup)LayoutInflater.from(paramContext).inflate(2131494280, this, false));
    this.uxZ = ((TextView)this.uxY.findViewById(2131300376));
    this.uya = ((TextView)this.uxY.findViewById(2131300377));
    addView(this.uxY);
    this.uxY.setVisibility(8);
    this.uyb = AnimationUtils.loadAnimation(paramContext, 2130772139);
    this.uyc = AnimationUtils.loadAnimation(paramContext, 2130772147);
    AppMethodBeat.o(41975);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(41977);
    super.onDetachedFromWindow();
    this.uwE.stopTimer();
    AppMethodBeat.o(41977);
  }
  
  public void setText(List<String> paramList)
  {
    AppMethodBeat.i(41976);
    this.uxU.clear();
    this.uwE.stopTimer();
    if ((paramList == null) || (paramList.size() == 0) || (paramList.size() % 2 != 0))
    {
      this.uxV.setVisibility(8);
      this.uxY.setVisibility(8);
      AppMethodBeat.o(41976);
      return;
    }
    this.uxU.addAll(paramList);
    this.pVK = 0;
    paramList = k.b(getContext(), (CharSequence)this.uxU.get(0), this.uxW.getTextSize());
    this.uxW.setText(paramList);
    this.uxX.setText((CharSequence)this.uxU.get(1));
    this.uxV.setVisibility(0);
    this.uxY.setVisibility(8);
    if (this.uxU.size() / 2 == 1)
    {
      AppMethodBeat.o(41976);
      return;
    }
    this.uwE.ay(5000L, 5000L);
    AppMethodBeat.o(41976);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDetailAutoScrollView
 * JD-Core Version:    0.7.0.1
 */