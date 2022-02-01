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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

public final class n
  extends RecyclerView.w
{
  public final CheckBox fQc;
  public final TextView fQd;
  public final ImageView fRd;
  public final ImageView fUN;
  public final TextView gUs;
  public final View iVT;
  public final ProgressBar jcf;
  public final MMPinProgressBtn oSC;
  public final ImageView oSJ;
  public final View oSL;
  public final LinearLayout oSy;
  public final TextView timeTv;
  public final TextView titleTv;
  
  private n(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(123305);
    this.oSy = ((LinearLayout)paramView.findViewById(2131298738));
    this.fRd = ((ImageView)paramView.findViewById(2131297008));
    this.fQd = ((TextView)paramView.findViewById(2131302666));
    this.timeTv = ((TextView)paramView.findViewById(2131305822));
    this.fQc = ((CheckBox)paramView.findViewById(2131304502));
    this.oSL = paramView.findViewById(2131304515);
    this.oSJ = ((ImageView)paramView.findViewById(2131299520));
    this.fUN = ((ImageView)paramView.findViewById(2131300891));
    this.titleTv = ((TextView)paramView.findViewById(2131305948));
    this.gUs = ((TextView)paramView.findViewById(2131299061));
    this.oSC = ((MMPinProgressBtn)paramView.findViewById(2131299229));
    this.jcf = ((ProgressBar)paramView.findViewById(2131301506));
    this.iVT = paramView.findViewById(2131299154);
    this.oSy.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123303);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/choosemsgfile/logic/model/ViewHolderList$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
        localObject = (a)paramAnonymousView.getTag();
        if (localObject == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/choosemsgfile/logic/model/ViewHolderList$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(123303);
          return;
        }
        ((a)localObject).a(paramAnonymousView, (a)localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/choosemsgfile/logic/model/ViewHolderList$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(123303);
      }
    });
    this.oSL.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123304);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/choosemsgfile/logic/model/ViewHolderList$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = (a)paramAnonymousView.getTag();
        if (paramAnonymousView == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/choosemsgfile/logic/model/ViewHolderList$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(123304);
          return;
        }
        if (!n.this.fQc.isChecked()) {}
        for (boolean bool = true;; bool = false)
        {
          if (paramAnonymousView.isEnable())
          {
            n.this.fQc.setChecked(bool);
            paramAnonymousView.a(bool, paramAnonymousView, n.this);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/choosemsgfile/logic/model/ViewHolderList$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.b.n
 * JD-Core Version:    0.7.0.1
 */