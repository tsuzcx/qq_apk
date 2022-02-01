package com.tencent.mm.plugin.choosemsgfile.logic.b;

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
  public final TextView descTv;
  public final CheckBox lDE;
  public final TextView lDF;
  public final ImageView lKK;
  public final ImageView lPb;
  public final View pKl;
  public final ProgressBar pRi;
  public final TextView timeTv;
  public final TextView titleTv;
  public final LinearLayout wPX;
  public final MMPinProgressBtn wQa;
  public final ImageView wQh;
  public final View wQj;
  
  private n(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(123305);
    this.wPX = ((LinearLayout)paramView.findViewById(a.e.container_ll));
    this.lKK = ((ImageView)paramView.findViewById(a.e.avatar_iv));
    this.lDF = ((TextView)paramView.findViewById(a.e.name_tv));
    this.timeTv = ((TextView)paramView.findViewById(a.e.time_tv));
    this.lDE = ((CheckBox)paramView.findViewById(a.e.select_cb));
    this.wQj = paramView.findViewById(a.e.select_fl);
    this.wQh = ((ImageView)paramView.findViewById(a.e.error_iv));
    this.lPb = ((ImageView)paramView.findViewById(a.e.icon_iv));
    this.titleTv = ((TextView)paramView.findViewById(a.e.title_tv));
    this.descTv = ((TextView)paramView.findViewById(a.e.detail_tv));
    this.wQa = ((MMPinProgressBtn)paramView.findViewById(a.e.downloading_pb));
    this.pRi = ((ProgressBar)paramView.findViewById(a.e.loading_pb));
    this.pKl = paramView.findViewById(a.e.divider);
    this.wPX.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123303);
        Object localObject = new b();
        ((b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/choosemsgfile/logic/model/ViewHolderList$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
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
    this.wQj.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123304);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/choosemsgfile/logic/model/ViewHolderList$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        paramAnonymousView = (a)paramAnonymousView.getTag();
        if (paramAnonymousView == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/choosemsgfile/logic/model/ViewHolderList$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(123304);
          return;
        }
        if (!n.this.lDE.isChecked()) {}
        for (boolean bool = true;; bool = false)
        {
          if (paramAnonymousView.isEnable())
          {
            n.this.lDE.setChecked(bool);
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
  
  public static RecyclerView.v t(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(262594);
    paramViewGroup = new n(LayoutInflater.from(paramViewGroup.getContext()).inflate(a.f.choose_msg_file_list_item, paramViewGroup, false));
    AppMethodBeat.o(262594);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.logic.b.n
 * JD-Core Version:    0.7.0.1
 */