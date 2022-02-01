package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.d.di;
import com.tencent.mm.plugin.game.d.dj;
import com.tencent.mm.plugin.game.e.a;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.LinkedList;

public class GameNewClassifyView
  extends LinearLayout
  implements View.OnClickListener
{
  private LayoutInflater iMw;
  private LinearLayout qTW;
  private int tfA;
  
  public GameNewClassifyView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final void a(dj paramdj, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(42315);
    if ((paramdj == null) || (bs.gY(paramdj.tiT)))
    {
      setVisibility(8);
      AppMethodBeat.o(42315);
      return;
    }
    this.tfA = paramInt2;
    if (this.iMw == null) {
      this.iMw = ((LayoutInflater)getContext().getSystemService("layout_inflater"));
    }
    this.qTW.removeAllViews();
    LinearLayout localLinearLayout;
    while (this.qTW.getChildCount() < paramdj.tiT.size())
    {
      localLinearLayout = (LinearLayout)this.iMw.inflate(2131494363, this, false);
      localLinearLayout.setOnClickListener(this);
      this.qTW.addView(localLinearLayout, new LinearLayout.LayoutParams(-2, -2, 1.0F));
    }
    paramInt2 = 0;
    if (paramInt2 < this.qTW.getChildCount())
    {
      if (paramInt2 < paramdj.tiT.size()) {
        this.qTW.getChildAt(paramInt2).setVisibility(0);
      }
      for (;;)
      {
        paramInt2 += 1;
        break;
        this.qTW.getChildAt(paramInt2).setVisibility(8);
      }
    }
    paramInt2 = 0;
    while (paramInt2 < paramdj.tiT.size())
    {
      localLinearLayout = (LinearLayout)this.qTW.getChildAt(paramInt2);
      ImageView localImageView = (ImageView)localLinearLayout.findViewById(2131300367);
      TextView localTextView = (TextView)localLinearLayout.findViewById(2131300368);
      com.tencent.mm.plugin.game.f.e.cRL().l(localImageView, ((di)paramdj.tiT.get(paramInt2)).IconUrl);
      localTextView.setText(((di)paramdj.tiT.get(paramInt2)).Title);
      localLinearLayout.setTag(new a(((di)paramdj.tiT.get(paramInt2)).thh, paramInt2 + 1, ((di)paramdj.tiT.get(paramInt2)).thP));
      paramInt2 += 1;
    }
    setVisibility(0);
    if (paramInt1 == 2) {
      a.a(getContext(), 10, 1019, 0, null, this.tfA, null);
    }
    AppMethodBeat.o(42315);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42316);
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof a)))
    {
      AppMethodBeat.o(42316);
      return;
    }
    paramView = (a)paramView.getTag();
    if (!bs.isNullOrNil(paramView.url))
    {
      c.ay(getContext(), paramView.url);
      com.tencent.mm.game.report.e.a(getContext(), 10, 1019, paramView.position, 7, null, this.tfA, a.tu(paramView.extInfo));
    }
    AppMethodBeat.o(42316);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42314);
    super.onFinishInflate();
    this.iMw = ((LayoutInflater)getContext().getSystemService("layout_inflater"));
    this.qTW = ((LinearLayout)findViewById(2131300497));
    AppMethodBeat.o(42314);
  }
  
  static final class a
  {
    public String extInfo;
    public int position;
    public String url;
    
    public a(String paramString1, int paramInt, String paramString2)
    {
      this.url = paramString1;
      this.position = paramInt;
      this.extInfo = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameNewClassifyView
 * JD-Core Version:    0.7.0.1
 */