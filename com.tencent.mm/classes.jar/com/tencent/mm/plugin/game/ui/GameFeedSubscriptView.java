package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.d.ad;
import com.tencent.mm.plugin.game.d.n;
import com.tencent.mm.plugin.game.e.a;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.f.e.a.a;
import com.tencent.mm.sdk.platformtools.bo;

public class GameFeedSubscriptView
  extends LinearLayout
  implements View.OnClickListener
{
  private ImageView kPy;
  private ad nzp;
  private TextView nzu;
  private TextView nzv;
  private LinearLayout nzw;
  private TextView nzx;
  private TextView nzy;
  private TextView nzz;
  
  public GameFeedSubscriptView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void xi(int paramInt)
  {
    AppMethodBeat.i(111953);
    if (paramInt == 1) {}
    for (String str = a.V(this.nzp.nqt, "clickType", "leftCorner");; str = a.V(this.nzp.nqt, "clickType", "rightCorner"))
    {
      com.tencent.mm.game.report.c.a(getContext(), 10, 1024, this.nzp.nqv, 7, this.nzp.fKw, GameIndexListView.getSourceScene(), str);
      AppMethodBeat.o(111953);
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(111952);
    if (this.nzp == null)
    {
      AppMethodBeat.o(111952);
      return;
    }
    if ((paramView.getId() == 2131824627) || (paramView.getId() == 2131824628) || (paramView.getId() == 2131824630))
    {
      if ((this.nzp.nrs != null) && (!bo.isNullOrNil(this.nzp.nrs.npR)))
      {
        com.tencent.mm.plugin.game.f.c.ax(getContext(), this.nzp.nrs.npR);
        xi(1);
        AppMethodBeat.o(111952);
      }
    }
    else if ((paramView.getId() == 2131824629) && (this.nzp.nrt != null) && (!bo.isNullOrNil(this.nzp.nrt.npR)))
    {
      com.tencent.mm.plugin.game.f.c.ax(getContext(), this.nzp.nrt.npR);
      xi(2);
    }
    AppMethodBeat.o(111952);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(111950);
    super.onFinishInflate();
    View localView = LayoutInflater.from(getContext()).inflate(2130969753, this, true);
    this.nzu = ((TextView)localView.findViewById(2131824627));
    this.nzv = ((TextView)localView.findViewById(2131824628));
    this.nzw = ((LinearLayout)localView.findViewById(2131824630));
    this.kPy = ((ImageView)localView.findViewById(2131823820));
    this.nzx = ((TextView)localView.findViewById(2131821063));
    this.nzy = ((TextView)localView.findViewById(2131824631));
    this.nzz = ((TextView)localView.findViewById(2131824629));
    this.nzu.setOnClickListener(this);
    this.nzv.setOnClickListener(this);
    this.nzw.setOnClickListener(this);
    this.nzz.setOnClickListener(this);
    AppMethodBeat.o(111950);
  }
  
  public void setData(ad paramad)
  {
    AppMethodBeat.i(111951);
    if ((paramad == null) || ((paramad.nrs == null) && (paramad.nrt == null)))
    {
      setVisibility(8);
      AppMethodBeat.o(111951);
      return;
    }
    this.nzp = paramad;
    setVisibility(0);
    this.nzu.setVisibility(8);
    this.nzv.setVisibility(8);
    this.nzw.setVisibility(8);
    if (paramad.nrs != null) {
      switch (paramad.nrs.nqF)
      {
      }
    }
    while (paramad.nrt != null)
    {
      this.nzz.setText(paramad.nrt.Desc);
      this.nzz.setVisibility(0);
      AppMethodBeat.o(111951);
      return;
      this.nzu.setVisibility(0);
      this.nzu.setText(paramad.nrs.Desc);
      continue;
      this.nzv.setVisibility(0);
      this.nzv.setText(paramad.nrs.Desc);
      continue;
      this.nzw.setVisibility(0);
      if (!bo.isNullOrNil(paramad.nrs.nqE))
      {
        e.a.a locala = new e.a.a();
        locala.eOk = true;
        e.bHE().a(this.kPy, paramad.nrs.nqE, locala.bHF());
        this.kPy.setVisibility(0);
      }
      this.nzx.setText(paramad.nrs.Name);
      this.nzy.setText(paramad.nrs.Desc);
    }
    this.nzz.setVisibility(8);
    AppMethodBeat.o(111951);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedSubscriptView
 * JD-Core Version:    0.7.0.1
 */