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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

public final class m
  extends RecyclerView.v
{
  public final CheckBox gxr;
  public final ProgressBar kdb;
  public final ImageView puw;
  public final View qob;
  public final MMPinProgressBtn qoc;
  public final TextView qod;
  public final TextView qoe;
  public final View qof;
  public final TextView qog;
  public final ImageView qoh;
  public final View qoi;
  public ImageView qoj;
  
  private m(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(123301);
    this.qob = paramView.findViewById(2131299179);
    this.puw = ((ImageView)paramView.findViewById(2131299289));
    this.qoc = ((MMPinProgressBtn)paramView.findViewById(2131299794));
    this.kdb = ((ProgressBar)paramView.findViewById(2131303709));
    this.qof = paramView.findViewById(2131309820);
    this.qog = ((TextView)paramView.findViewById(2131309832));
    this.qod = ((TextView)paramView.findViewById(2131300637));
    this.qoe = ((TextView)paramView.findViewById(2131300638));
    this.qoh = ((ImageView)paramView.findViewById(2131304507));
    this.gxr = ((CheckBox)paramView.findViewById(2131307508));
    this.qoi = paramView.findViewById(2131307563);
    this.qoj = ((ImageView)paramView.findViewById(2131300158));
    this.puw.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123299);
        Object localObject = new b();
        ((b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/choosemsgfile/logic/model/ViewHolderGrid$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
        localObject = (a)paramAnonymousView.getTag();
        if (localObject == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/choosemsgfile/logic/model/ViewHolderGrid$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(123299);
          return;
        }
        ((a)localObject).a(paramAnonymousView, (a)localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/choosemsgfile/logic/model/ViewHolderGrid$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(123299);
      }
    });
    this.qoi.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123300);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/choosemsgfile/logic/model/ViewHolderGrid$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = (a)paramAnonymousView.getTag();
        if (paramAnonymousView == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/choosemsgfile/logic/model/ViewHolderGrid$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(123300);
          return;
        }
        boolean bool;
        if (!m.this.gxr.isChecked())
        {
          bool = true;
          if (paramAnonymousView.isEnable())
          {
            m.this.gxr.setChecked(bool);
            paramAnonymousView.a(bool, paramAnonymousView, m.this);
            if (bool) {
              break label145;
            }
            m.this.qoh.setVisibility(0);
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/choosemsgfile/logic/model/ViewHolderGrid$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(123300);
          return;
          bool = false;
          break;
          label145:
          m.this.qoh.setVisibility(8);
        }
      }
    });
    AppMethodBeat.o(123301);
  }
  
  public static RecyclerView.v o(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(123302);
    paramViewGroup = new m(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131493644, paramViewGroup, false));
    AppMethodBeat.o(123302);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.b.m
 * JD-Core Version:    0.7.0.1
 */