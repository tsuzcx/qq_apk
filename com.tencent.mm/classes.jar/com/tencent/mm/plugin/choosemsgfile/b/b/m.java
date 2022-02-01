package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.choosemsgfile.a.e;
import com.tencent.mm.plugin.choosemsgfile.a.f;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

public final class m
  extends RecyclerView.v
{
  public final CheckBox jbE;
  public final ProgressBar mUB;
  public final ImageView sDJ;
  public final View tMJ;
  public final MMPinProgressBtn tMK;
  public final TextView tML;
  public final TextView tMM;
  public final View tMN;
  public final TextView tMO;
  public final ImageView tMP;
  public final View tMQ;
  public ImageView tMR;
  
  private m(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(123301);
    this.tMJ = paramView.findViewById(a.e.container_ll);
    this.sDJ = ((ImageView)paramView.findViewById(a.e.cover_iv));
    this.tMK = ((MMPinProgressBtn)paramView.findViewById(a.e.downloading_pb));
    this.mUB = ((ProgressBar)paramView.findViewById(a.e.loading_pb));
    this.tMN = paramView.findViewById(a.e.video_rl);
    this.tMO = ((TextView)paramView.findViewById(a.e.video_time_tv));
    this.tML = ((TextView)paramView.findViewById(a.e.filename_tv));
    this.tMM = ((TextView)paramView.findViewById(a.e.filesize_tv));
    this.tMP = ((ImageView)paramView.findViewById(a.e.mask_iv));
    this.jbE = ((CheckBox)paramView.findViewById(a.e.select_cb));
    this.tMQ = paramView.findViewById(a.e.select_v);
    this.tMR = ((ImageView)paramView.findViewById(a.e.error_iv));
    this.sDJ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123299);
        Object localObject = new b();
        ((b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/choosemsgfile/logic/model/ViewHolderGrid$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
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
    this.tMQ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123300);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/choosemsgfile/logic/model/ViewHolderGrid$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = (a)paramAnonymousView.getTag();
        if (paramAnonymousView == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/choosemsgfile/logic/model/ViewHolderGrid$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(123300);
          return;
        }
        boolean bool;
        if (!m.this.jbE.isChecked())
        {
          bool = true;
          if (paramAnonymousView.isEnable())
          {
            m.this.jbE.setChecked(bool);
            paramAnonymousView.a(bool, paramAnonymousView, m.this);
            if (bool) {
              break label145;
            }
            m.this.tMP.setVisibility(0);
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
          m.this.tMP.setVisibility(8);
        }
      }
    });
    AppMethodBeat.o(123301);
  }
  
  public static RecyclerView.v p(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(243540);
    paramViewGroup = new m(LayoutInflater.from(paramViewGroup.getContext()).inflate(a.f.choose_msg_file_item, paramViewGroup, false));
    AppMethodBeat.o(243540);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.b.m
 * JD-Core Version:    0.7.0.1
 */