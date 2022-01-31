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
import com.tencent.mm.plugin.game.d.dh;
import com.tencent.mm.plugin.game.d.di;
import com.tencent.mm.plugin.game.e.a;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public class GameNewClassifyView
  extends LinearLayout
  implements View.OnClickListener
{
  private LayoutInflater exe;
  private LinearLayout mDJ;
  private int nok;
  
  public GameNewClassifyView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final void a(di paramdi, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(112119);
    if ((paramdi == null) || (bo.es(paramdi.nrw)))
    {
      setVisibility(8);
      AppMethodBeat.o(112119);
      return;
    }
    this.nok = paramInt2;
    if (this.exe == null) {
      this.exe = ((LayoutInflater)getContext().getSystemService("layout_inflater"));
    }
    this.mDJ.removeAllViews();
    LinearLayout localLinearLayout;
    while (this.mDJ.getChildCount() < paramdi.nrw.size())
    {
      localLinearLayout = (LinearLayout)this.exe.inflate(2130969800, this, false);
      localLinearLayout.setOnClickListener(this);
      this.mDJ.addView(localLinearLayout, new LinearLayout.LayoutParams(-2, -2, 1.0F));
    }
    paramInt2 = 0;
    if (paramInt2 < this.mDJ.getChildCount())
    {
      if (paramInt2 < paramdi.nrw.size()) {
        this.mDJ.getChildAt(paramInt2).setVisibility(0);
      }
      for (;;)
      {
        paramInt2 += 1;
        break;
        this.mDJ.getChildAt(paramInt2).setVisibility(8);
      }
    }
    paramInt2 = 0;
    while (paramInt2 < paramdi.nrw.size())
    {
      localLinearLayout = (LinearLayout)this.mDJ.getChildAt(paramInt2);
      ImageView localImageView = (ImageView)localLinearLayout.findViewById(2131824535);
      TextView localTextView = (TextView)localLinearLayout.findViewById(2131824536);
      e.bHE().i(localImageView, ((dh)paramdi.nrw.get(paramInt2)).IconUrl);
      localTextView.setText(((dh)paramdi.nrw.get(paramInt2)).Title);
      localLinearLayout.setTag(new GameNewClassifyView.a(((dh)paramdi.nrw.get(paramInt2)).npR, paramInt2 + 1, ((dh)paramdi.nrw.get(paramInt2)).nqt));
      paramInt2 += 1;
    }
    setVisibility(0);
    if (paramInt1 == 2) {
      a.a(getContext(), 10, 1019, 0, null, this.nok, null);
    }
    AppMethodBeat.o(112119);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(112120);
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof GameNewClassifyView.a)))
    {
      AppMethodBeat.o(112120);
      return;
    }
    paramView = (GameNewClassifyView.a)paramView.getTag();
    if (!bo.isNullOrNil(paramView.url))
    {
      com.tencent.mm.plugin.game.f.c.ax(getContext(), paramView.url);
      com.tencent.mm.game.report.c.a(getContext(), 10, 1019, paramView.position, 7, null, this.nok, a.lR(paramView.extInfo));
    }
    AppMethodBeat.o(112120);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(112118);
    super.onFinishInflate();
    this.exe = ((LayoutInflater)getContext().getSystemService("layout_inflater"));
    this.mDJ = ((LinearLayout)findViewById(2131824534));
    AppMethodBeat.o(112118);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameNewClassifyView
 * JD-Core Version:    0.7.0.1
 */