package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.support.v7.widget.RecyclerView.v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

public final class m
  extends RecyclerView.v
{
  public final CheckBox fti;
  public final ProgressBar iiP;
  public final View nMf;
  public final ImageView nMg;
  public final MMPinProgressBtn nMh;
  public final TextView nMi;
  public final TextView nMj;
  public final View nMk;
  public final TextView nMl;
  public final ImageView nMm;
  public final View nMn;
  public ImageView nMo;
  
  private m(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(123301);
    this.nMf = paramView.findViewById(2131298738);
    this.nMg = ((ImageView)paramView.findViewById(2131298824));
    this.nMh = ((MMPinProgressBtn)paramView.findViewById(2131299229));
    this.iiP = ((ProgressBar)paramView.findViewById(2131301506));
    this.nMk = paramView.findViewById(2131306391);
    this.nMl = ((TextView)paramView.findViewById(2131306401));
    this.nMi = ((TextView)paramView.findViewById(2131299933));
    this.nMj = ((TextView)paramView.findViewById(2131299934));
    this.nMm = ((ImageView)paramView.findViewById(2131302165));
    this.fti = ((CheckBox)paramView.findViewById(2131304502));
    this.nMn = paramView.findViewById(2131304539);
    this.nMo = ((ImageView)paramView.findViewById(2131299520));
    this.nMg.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123299);
        a locala = (a)paramAnonymousView.getTag();
        if (locala == null)
        {
          AppMethodBeat.o(123299);
          return;
        }
        locala.a(paramAnonymousView, locala);
        AppMethodBeat.o(123299);
      }
    });
    this.nMn.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123300);
        paramAnonymousView = (a)paramAnonymousView.getTag();
        if (paramAnonymousView == null)
        {
          AppMethodBeat.o(123300);
          return;
        }
        boolean bool;
        if (!m.this.fti.isChecked()) {
          bool = true;
        }
        while (paramAnonymousView.isEnable())
        {
          m.this.fti.setChecked(bool);
          paramAnonymousView.a(bool, paramAnonymousView, m.this);
          if (!bool)
          {
            m.this.nMm.setVisibility(0);
            AppMethodBeat.o(123300);
            return;
            bool = false;
          }
          else
          {
            m.this.nMm.setVisibility(8);
          }
        }
        AppMethodBeat.o(123300);
      }
    });
    AppMethodBeat.o(123301);
  }
  
  public static RecyclerView.v o(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(123302);
    paramViewGroup = new m(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131493532, paramViewGroup, false));
    AppMethodBeat.o(123302);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.b.m
 * JD-Core Version:    0.7.0.1
 */