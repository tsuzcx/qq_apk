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
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

public class GameNewClassifyView
  extends LinearLayout
  implements View.OnClickListener
{
  private LayoutInflater imq;
  private LinearLayout qlu;
  private int rXI;
  
  public GameNewClassifyView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final void a(dj paramdj, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(42315);
    if ((paramdj == null) || (bt.gL(paramdj.saZ)))
    {
      setVisibility(8);
      AppMethodBeat.o(42315);
      return;
    }
    this.rXI = paramInt2;
    if (this.imq == null) {
      this.imq = ((LayoutInflater)getContext().getSystemService("layout_inflater"));
    }
    this.qlu.removeAllViews();
    LinearLayout localLinearLayout;
    while (this.qlu.getChildCount() < paramdj.saZ.size())
    {
      localLinearLayout = (LinearLayout)this.imq.inflate(2131494363, this, false);
      localLinearLayout.setOnClickListener(this);
      this.qlu.addView(localLinearLayout, new LinearLayout.LayoutParams(-2, -2, 1.0F));
    }
    paramInt2 = 0;
    if (paramInt2 < this.qlu.getChildCount())
    {
      if (paramInt2 < paramdj.saZ.size()) {
        this.qlu.getChildAt(paramInt2).setVisibility(0);
      }
      for (;;)
      {
        paramInt2 += 1;
        break;
        this.qlu.getChildAt(paramInt2).setVisibility(8);
      }
    }
    paramInt2 = 0;
    while (paramInt2 < paramdj.saZ.size())
    {
      localLinearLayout = (LinearLayout)this.qlu.getChildAt(paramInt2);
      ImageView localImageView = (ImageView)localLinearLayout.findViewById(2131300367);
      TextView localTextView = (TextView)localLinearLayout.findViewById(2131300368);
      com.tencent.mm.plugin.game.f.e.cEB().l(localImageView, ((di)paramdj.saZ.get(paramInt2)).IconUrl);
      localTextView.setText(((di)paramdj.saZ.get(paramInt2)).Title);
      localLinearLayout.setTag(new a(((di)paramdj.saZ.get(paramInt2)).rZo, paramInt2 + 1, ((di)paramdj.saZ.get(paramInt2)).rZW));
      paramInt2 += 1;
    }
    setVisibility(0);
    if (paramInt1 == 2) {
      a.a(getContext(), 10, 1019, 0, null, this.rXI, null);
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
    if (!bt.isNullOrNil(paramView.url))
    {
      c.ax(getContext(), paramView.url);
      com.tencent.mm.game.report.e.a(getContext(), 10, 1019, paramView.position, 7, null, this.rXI, a.qh(paramView.extInfo));
    }
    AppMethodBeat.o(42316);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42314);
    super.onFinishInflate();
    this.imq = ((LayoutInflater)getContext().getSystemService("layout_inflater"));
    this.qlu = ((LinearLayout)findViewById(2131300497));
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