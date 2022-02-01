package com.tencent.mm.plugin.choosemsgfile.logic.b;

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
  public final ImageView coverIv;
  public final CheckBox lDE;
  public final ProgressBar pRi;
  public final View wPZ;
  public final MMPinProgressBtn wQa;
  public final TextView wQb;
  public final TextView wQc;
  public final View wQd;
  public final TextView wQe;
  public final ImageView wQf;
  public final View wQg;
  public ImageView wQh;
  
  private m(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(123301);
    this.wPZ = paramView.findViewById(a.e.container_ll);
    this.coverIv = ((ImageView)paramView.findViewById(a.e.cover_iv));
    this.wQa = ((MMPinProgressBtn)paramView.findViewById(a.e.downloading_pb));
    this.pRi = ((ProgressBar)paramView.findViewById(a.e.loading_pb));
    this.wQd = paramView.findViewById(a.e.video_rl);
    this.wQe = ((TextView)paramView.findViewById(a.e.video_time_tv));
    this.wQb = ((TextView)paramView.findViewById(a.e.filename_tv));
    this.wQc = ((TextView)paramView.findViewById(a.e.filesize_tv));
    this.wQf = ((ImageView)paramView.findViewById(a.e.mask_iv));
    this.lDE = ((CheckBox)paramView.findViewById(a.e.select_cb));
    this.wQg = paramView.findViewById(a.e.select_v);
    this.wQh = ((ImageView)paramView.findViewById(a.e.error_iv));
    this.coverIv.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123299);
        Object localObject = new b();
        ((b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/choosemsgfile/logic/model/ViewHolderGrid$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
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
    this.wQg.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123300);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/choosemsgfile/logic/model/ViewHolderGrid$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        paramAnonymousView = (a)paramAnonymousView.getTag();
        if (paramAnonymousView == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/choosemsgfile/logic/model/ViewHolderGrid$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(123300);
          return;
        }
        boolean bool;
        if (!m.this.lDE.isChecked())
        {
          bool = true;
          if (paramAnonymousView.isEnable())
          {
            m.this.lDE.setChecked(bool);
            paramAnonymousView.a(bool, paramAnonymousView, m.this);
            if (bool) {
              break label145;
            }
            m.this.wQf.setVisibility(0);
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
          m.this.wQf.setVisibility(8);
        }
      }
    });
    AppMethodBeat.o(123301);
  }
  
  public static RecyclerView.v t(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(262591);
    paramViewGroup = new m(LayoutInflater.from(paramViewGroup.getContext()).inflate(a.f.choose_msg_file_item, paramViewGroup, false));
    AppMethodBeat.o(262591);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.logic.b.m
 * JD-Core Version:    0.7.0.1
 */