package com.tencent.mm.plugin.label.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.plugin.label.ui.widget.d;
import com.tencent.mm.ui.widget.MMTextView;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public class e
  extends RecyclerView.v
  implements d
{
  public MMTextView JXj;
  public TextView JXk;
  public View JXl;
  public LinearLayout JXm;
  public CheckBox JXn;
  public WeImageView JXo;
  public TextView JXp;
  private Context mContext;
  
  public e(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(26323);
    this.mContext = paramView.getContext();
    this.JXl = paramView.findViewById(R.h.fMG);
    this.JXj = ((MMTextView)paramView.findViewById(R.h.fMb));
    this.JXk = ((TextView)paramView.findViewById(R.h.fMa));
    this.JXm = ((LinearLayout)paramView.findViewById(R.h.fLZ));
    this.JXn = ((CheckBox)paramView.findViewById(R.h.fBv));
    this.JXo = ((WeImageView)paramView.findViewById(R.h.fBt));
    this.JXp = ((TextView)paramView.findViewById(R.h.fMH));
    AppMethodBeat.o(26323);
  }
  
  public final void fTB()
  {
    AppMethodBeat.i(268752);
    this.JXl.setBackgroundColor(this.mContext.getResources().getColor(R.e.BG_1));
    AppMethodBeat.o(268752);
  }
  
  public final void fTs()
  {
    AppMethodBeat.i(268746);
    this.JXl.setBackground(this.mContext.getResources().getDrawable(R.g.settings_line));
    AppMethodBeat.o(268746);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.e
 * JD-Core Version:    0.7.0.1
 */