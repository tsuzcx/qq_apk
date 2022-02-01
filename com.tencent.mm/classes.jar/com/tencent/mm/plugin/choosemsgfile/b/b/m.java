package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.support.v7.widget.RecyclerView.w;
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
  extends RecyclerView.w
{
  public final CheckBox fSi;
  public final ProgressBar jeY;
  public final View oZc;
  public final ImageView oZd;
  public final MMPinProgressBtn oZe;
  public final TextView oZf;
  public final TextView oZg;
  public final View oZh;
  public final TextView oZi;
  public final ImageView oZj;
  public final View oZk;
  public ImageView oZl;
  
  private m(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(123301);
    this.oZc = paramView.findViewById(2131298738);
    this.oZd = ((ImageView)paramView.findViewById(2131298824));
    this.oZe = ((MMPinProgressBtn)paramView.findViewById(2131299229));
    this.jeY = ((ProgressBar)paramView.findViewById(2131301506));
    this.oZh = paramView.findViewById(2131306391);
    this.oZi = ((TextView)paramView.findViewById(2131306401));
    this.oZf = ((TextView)paramView.findViewById(2131299933));
    this.oZg = ((TextView)paramView.findViewById(2131299934));
    this.oZj = ((ImageView)paramView.findViewById(2131302165));
    this.fSi = ((CheckBox)paramView.findViewById(2131304502));
    this.oZk = paramView.findViewById(2131304539);
    this.oZl = ((ImageView)paramView.findViewById(2131299520));
    this.oZd.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123299);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/choosemsgfile/logic/model/ViewHolderGrid$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
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
    this.oZk.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123300);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/choosemsgfile/logic/model/ViewHolderGrid$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = (a)paramAnonymousView.getTag();
        if (paramAnonymousView == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/choosemsgfile/logic/model/ViewHolderGrid$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(123300);
          return;
        }
        boolean bool;
        if (!m.this.fSi.isChecked())
        {
          bool = true;
          if (paramAnonymousView.isEnable())
          {
            m.this.fSi.setChecked(bool);
            paramAnonymousView.a(bool, paramAnonymousView, m.this);
            if (bool) {
              break label145;
            }
            m.this.oZj.setVisibility(0);
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
          m.this.oZj.setVisibility(8);
        }
      }
    });
    AppMethodBeat.o(123301);
  }
  
  public static RecyclerView.w o(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(123302);
    paramViewGroup = new m(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131493532, paramViewGroup, false));
    AppMethodBeat.o(123302);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.b.m
 * JD-Core Version:    0.7.0.1
 */