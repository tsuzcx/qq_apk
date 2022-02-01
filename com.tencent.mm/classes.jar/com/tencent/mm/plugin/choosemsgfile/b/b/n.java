package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.choosemsgfile.a.e;
import com.tencent.mm.plugin.choosemsgfile.a.f;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

public final class n
  extends RecyclerView.v
{
  public final CheckBox jbE;
  public final TextView jbF;
  public final ImageView jiu;
  public final ImageView jmf;
  public final TextView kEs;
  public final View mND;
  public final ProgressBar mUB;
  public final LinearLayout tMH;
  public final MMPinProgressBtn tMK;
  public final ImageView tMR;
  public final View tMT;
  public final TextView timeTv;
  public final TextView titleTv;
  
  private n(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(123305);
    this.tMH = ((LinearLayout)paramView.findViewById(a.e.container_ll));
    this.jiu = ((ImageView)paramView.findViewById(a.e.avatar_iv));
    this.jbF = ((TextView)paramView.findViewById(a.e.name_tv));
    this.timeTv = ((TextView)paramView.findViewById(a.e.time_tv));
    this.jbE = ((CheckBox)paramView.findViewById(a.e.select_cb));
    this.tMT = paramView.findViewById(a.e.select_fl);
    this.tMR = ((ImageView)paramView.findViewById(a.e.error_iv));
    this.jmf = ((ImageView)paramView.findViewById(a.e.icon_iv));
    this.titleTv = ((TextView)paramView.findViewById(a.e.title_tv));
    this.kEs = ((TextView)paramView.findViewById(a.e.detail_tv));
    this.tMK = ((MMPinProgressBtn)paramView.findViewById(a.e.downloading_pb));
    this.mUB = ((ProgressBar)paramView.findViewById(a.e.loading_pb));
    this.mND = paramView.findViewById(a.e.divider);
    this.tMH.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123303);
        Object localObject = new b();
        ((b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/choosemsgfile/logic/model/ViewHolderList$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
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
    this.tMT.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123304);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/choosemsgfile/logic/model/ViewHolderList$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = (a)paramAnonymousView.getTag();
        if (paramAnonymousView == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/choosemsgfile/logic/model/ViewHolderList$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(123304);
          return;
        }
        if (!n.this.jbE.isChecked()) {}
        for (boolean bool = true;; bool = false)
        {
          if (paramAnonymousView.isEnable())
          {
            n.this.jbE.setChecked(bool);
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
  
  public static RecyclerView.v p(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(243276);
    paramViewGroup = new n(LayoutInflater.from(paramViewGroup.getContext()).inflate(a.f.choose_msg_file_list_item, paramViewGroup, false));
    AppMethodBeat.o(243276);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.b.n
 * JD-Core Version:    0.7.0.1
 */