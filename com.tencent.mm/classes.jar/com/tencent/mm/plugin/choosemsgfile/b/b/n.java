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
  public final CheckBox fSi;
  public final TextView fSj;
  public final ImageView fTj;
  public final ImageView fWT;
  public final TextView gXb;
  public final View iYM;
  public final ProgressBar jeY;
  public final LinearLayout oZa;
  public final MMPinProgressBtn oZe;
  public final ImageView oZl;
  public final View oZn;
  public final TextView timeTv;
  public final TextView titleTv;
  
  private n(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(123305);
    this.oZa = ((LinearLayout)paramView.findViewById(2131298738));
    this.fTj = ((ImageView)paramView.findViewById(2131297008));
    this.fSj = ((TextView)paramView.findViewById(2131302666));
    this.timeTv = ((TextView)paramView.findViewById(2131305822));
    this.fSi = ((CheckBox)paramView.findViewById(2131304502));
    this.oZn = paramView.findViewById(2131304515);
    this.oZl = ((ImageView)paramView.findViewById(2131299520));
    this.fWT = ((ImageView)paramView.findViewById(2131300891));
    this.titleTv = ((TextView)paramView.findViewById(2131305948));
    this.gXb = ((TextView)paramView.findViewById(2131299061));
    this.oZe = ((MMPinProgressBtn)paramView.findViewById(2131299229));
    this.jeY = ((ProgressBar)paramView.findViewById(2131301506));
    this.iYM = paramView.findViewById(2131299154);
    this.oZa.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123303);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/choosemsgfile/logic/model/ViewHolderList$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
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
    this.oZn.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123304);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/choosemsgfile/logic/model/ViewHolderList$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = (a)paramAnonymousView.getTag();
        if (paramAnonymousView == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/choosemsgfile/logic/model/ViewHolderList$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(123304);
          return;
        }
        if (!n.this.fSi.isChecked()) {}
        for (boolean bool = true;; bool = false)
        {
          if (paramAnonymousView.isEnable())
          {
            n.this.fSi.setChecked(bool);
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