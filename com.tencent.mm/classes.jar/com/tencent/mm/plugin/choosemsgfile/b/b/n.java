package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.support.v7.widget.RecyclerView.v;
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
  extends RecyclerView.v
{
  public final ImageView gBZ;
  public final CheckBox gxr;
  public final TextView gxs;
  public final ImageView gyr;
  public final TextView hPW;
  public final View jWr;
  public final ProgressBar kdb;
  public final LinearLayout qnZ;
  public final MMPinProgressBtn qoc;
  public final ImageView qoj;
  public final View qol;
  public final TextView timeTv;
  public final TextView titleTv;
  
  private n(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(123305);
    this.qnZ = ((LinearLayout)paramView.findViewById(2131299179));
    this.gyr = ((ImageView)paramView.findViewById(2131297134));
    this.gxs = ((TextView)paramView.findViewById(2131305220));
    this.timeTv = ((TextView)paramView.findViewById(2131309101));
    this.gxr = ((CheckBox)paramView.findViewById(2131307508));
    this.qol = paramView.findViewById(2131307526);
    this.qoj = ((ImageView)paramView.findViewById(2131300158));
    this.gBZ = ((ImageView)paramView.findViewById(2131302497));
    this.titleTv = ((TextView)paramView.findViewById(2131309249));
    this.hPW = ((TextView)paramView.findViewById(2131299567));
    this.qoc = ((MMPinProgressBtn)paramView.findViewById(2131299794));
    this.kdb = ((ProgressBar)paramView.findViewById(2131303709));
    this.jWr = paramView.findViewById(2131299682);
    this.qnZ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123303);
        Object localObject = new b();
        ((b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/choosemsgfile/logic/model/ViewHolderList$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
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
    this.qol.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123304);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/choosemsgfile/logic/model/ViewHolderList$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = (a)paramAnonymousView.getTag();
        if (paramAnonymousView == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/choosemsgfile/logic/model/ViewHolderList$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(123304);
          return;
        }
        if (!n.this.gxr.isChecked()) {}
        for (boolean bool = true;; bool = false)
        {
          if (paramAnonymousView.isEnable())
          {
            n.this.gxr.setChecked(bool);
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
  
  public static RecyclerView.v o(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(123306);
    paramViewGroup = new n(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131493645, paramViewGroup, false));
    AppMethodBeat.o(123306);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.b.n
 * JD-Core Version:    0.7.0.1
 */