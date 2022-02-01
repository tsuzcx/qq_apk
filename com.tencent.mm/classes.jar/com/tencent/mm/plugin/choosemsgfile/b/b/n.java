package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.support.v7.widget.RecyclerView.w;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

public final class n
  extends RecyclerView.w
{
  public final ImageView fBA;
  public final CheckBox fwP;
  public final TextView fwQ;
  public final ImageView fxQ;
  public final TextView gAI;
  public final View iCJ;
  public final ProgressBar iIW;
  public final LinearLayout opd;
  public final MMPinProgressBtn oph;
  public final ImageView opo;
  public final View opq;
  public final TextView timeTv;
  public final TextView titleTv;
  
  private n(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(123305);
    this.opd = ((LinearLayout)paramView.findViewById(2131298738));
    this.fxQ = ((ImageView)paramView.findViewById(2131297008));
    this.fwQ = ((TextView)paramView.findViewById(2131302666));
    this.timeTv = ((TextView)paramView.findViewById(2131305822));
    this.fwP = ((CheckBox)paramView.findViewById(2131304502));
    this.opq = paramView.findViewById(2131304515);
    this.opo = ((ImageView)paramView.findViewById(2131299520));
    this.fBA = ((ImageView)paramView.findViewById(2131300891));
    this.titleTv = ((TextView)paramView.findViewById(2131305948));
    this.gAI = ((TextView)paramView.findViewById(2131299061));
    this.oph = ((MMPinProgressBtn)paramView.findViewById(2131299229));
    this.iIW = ((ProgressBar)paramView.findViewById(2131301506));
    this.iCJ = paramView.findViewById(2131299154);
    this.opd.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123303);
        a locala = (a)paramAnonymousView.getTag();
        if (locala == null)
        {
          AppMethodBeat.o(123303);
          return;
        }
        locala.a(paramAnonymousView, locala);
        AppMethodBeat.o(123303);
      }
    });
    this.opq.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123304);
        paramAnonymousView = (a)paramAnonymousView.getTag();
        if (paramAnonymousView == null)
        {
          AppMethodBeat.o(123304);
          return;
        }
        if (!n.this.fwP.isChecked()) {}
        for (boolean bool = true;; bool = false)
        {
          if (paramAnonymousView.isEnable())
          {
            n.this.fwP.setChecked(bool);
            paramAnonymousView.a(bool, paramAnonymousView, n.this);
          }
          AppMethodBeat.o(123304);
          return;
        }
      }
    });
    AppMethodBeat.o(123305);
  }
  
  public static RecyclerView.w o(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(123306);
    paramViewGroup = new n(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131493533, paramViewGroup, false));
    AppMethodBeat.o(123306);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.b.n
 * JD-Core Version:    0.7.0.1
 */