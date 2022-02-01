package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.support.v7.widget.RecyclerView.w;
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
  extends RecyclerView.w
{
  public final CheckBox fwP;
  public final ProgressBar iIW;
  public final View opf;
  public final ImageView opg;
  public final MMPinProgressBtn oph;
  public final TextView opi;
  public final TextView opj;
  public final View opk;
  public final TextView opl;
  public final ImageView opm;
  public final View opn;
  public ImageView opo;
  
  private m(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(123301);
    this.opf = paramView.findViewById(2131298738);
    this.opg = ((ImageView)paramView.findViewById(2131298824));
    this.oph = ((MMPinProgressBtn)paramView.findViewById(2131299229));
    this.iIW = ((ProgressBar)paramView.findViewById(2131301506));
    this.opk = paramView.findViewById(2131306391);
    this.opl = ((TextView)paramView.findViewById(2131306401));
    this.opi = ((TextView)paramView.findViewById(2131299933));
    this.opj = ((TextView)paramView.findViewById(2131299934));
    this.opm = ((ImageView)paramView.findViewById(2131302165));
    this.fwP = ((CheckBox)paramView.findViewById(2131304502));
    this.opn = paramView.findViewById(2131304539);
    this.opo = ((ImageView)paramView.findViewById(2131299520));
    this.opg.setOnClickListener(new View.OnClickListener()
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
    this.opn.setOnClickListener(new View.OnClickListener()
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
        if (!m.this.fwP.isChecked()) {
          bool = true;
        }
        while (paramAnonymousView.isEnable())
        {
          m.this.fwP.setChecked(bool);
          paramAnonymousView.a(bool, paramAnonymousView, m.this);
          if (!bool)
          {
            m.this.opm.setVisibility(0);
            AppMethodBeat.o(123300);
            return;
            bool = false;
          }
          else
          {
            m.this.opm.setVisibility(8);
          }
        }
        AppMethodBeat.o(123300);
      }
    });
    AppMethodBeat.o(123301);
  }
  
  public static RecyclerView.w o(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(123302);
    paramViewGroup = new m(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131493532, paramViewGroup, false));
    AppMethodBeat.o(123302);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.b.m
 * JD-Core Version:    0.7.0.1
 */