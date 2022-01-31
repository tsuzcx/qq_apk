package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.support.v7.widget.RecyclerView.v;
import android.view.LayoutInflater;
import android.view.View;
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
  public final ProgressBar gvS;
  public final View kFe;
  public final MMPinProgressBtn kFf;
  public final TextView kFg;
  public final TextView kFh;
  public final View kFi;
  public final TextView kFj;
  public final ImageView kFk;
  public final CheckBox kFl;
  public final View kFm;
  public ImageView kFn;
  public final ImageView kha;
  
  private m(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(54329);
    this.kFe = paramView.findViewById(2131822806);
    this.kha = ((ImageView)paramView.findViewById(2131821891));
    this.kFf = ((MMPinProgressBtn)paramView.findViewById(2131822683));
    this.gvS = ((ProgressBar)paramView.findViewById(2131821643));
    this.kFi = paramView.findViewById(2131822811);
    this.kFj = ((TextView)paramView.findViewById(2131822813));
    this.kFg = ((TextView)paramView.findViewById(2131822809));
    this.kFh = ((TextView)paramView.findViewById(2131822810));
    this.kFk = ((ImageView)paramView.findViewById(2131822779));
    this.kFl = ((CheckBox)paramView.findViewById(2131821631));
    this.kFm = paramView.findViewById(2131822814);
    this.kFn = ((ImageView)paramView.findViewById(2131822491));
    this.kha.setOnClickListener(new m.1(this));
    this.kFm.setOnClickListener(new m.2(this));
    AppMethodBeat.o(54329);
  }
  
  public static RecyclerView.v m(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(54330);
    paramViewGroup = new m(LayoutInflater.from(paramViewGroup.getContext()).inflate(2130969150, paramViewGroup, false));
    AppMethodBeat.o(54330);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.b.m
 * JD-Core Version:    0.7.0.1
 */