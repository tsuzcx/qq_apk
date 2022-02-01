package com.tencent.mm.plugin.card.ui.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.ui.n;
import com.tencent.mm.protocal.protobuf.acg;
import com.tencent.mm.protocal.protobuf.ahl;
import com.tencent.mm.protocal.protobuf.ua;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;

public final class l
  extends i
{
  View tFV;
  LinearLayout tFW;
  boolean tFX = false;
  
  public final void cKY()
  {
    AppMethodBeat.i(113683);
    if (this.tFV != null) {
      this.tFV.setVisibility(8);
    }
    AppMethodBeat.o(113683);
  }
  
  public final void initView() {}
  
  public final void update()
  {
    AppMethodBeat.i(113682);
    if (this.tFV == null) {
      this.tFV = ((ViewStub)findViewById(a.d.tbT)).inflate();
    }
    Object localObject = this.tFT.cIS().cGt().SdO;
    ((TextView)this.tFV.findViewById(a.d.tfC)).setText(((ahl)localObject).title);
    if ((((ahl)localObject).Ssc != null) && (((ahl)localObject).Ssc.size() > 0))
    {
      this.tFW = ((LinearLayout)this.tFV.findViewById(a.d.tfB));
      this.tFW.removeAllViews();
      final LinkedList localLinkedList = ((ahl)localObject).Ssc;
      final LayoutInflater localLayoutInflater = (LayoutInflater)this.tFT.cIV().getSystemService("layout_inflater");
      if ((((ahl)localObject).Ssb >= localLinkedList.size()) || (this.tFX))
      {
        this.tFV.findViewById(a.d.tfA).setVisibility(8);
        i = 0;
        while (i < localLinkedList.size())
        {
          localObject = (TextView)localLayoutInflater.inflate(a.e.tjn, null, false);
          ((TextView)localObject).setText(((acg)localLinkedList.get(i)).title);
          this.tFW.addView((View)localObject);
          i += 1;
        }
        this.tFW.invalidate();
        AppMethodBeat.o(113682);
        return;
      }
      int i = 0;
      while (i < ((ahl)localObject).Ssb)
      {
        TextView localTextView = (TextView)localLayoutInflater.inflate(a.e.tjn, null, false);
        localTextView.setText(((acg)localLinkedList.get(i)).title);
        this.tFW.addView(localTextView);
        i += 1;
      }
      this.tFW.invalidate();
      this.tFV.findViewById(a.d.tfA).setVisibility(0);
      this.tFV.findViewById(a.d.tfA).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(113681);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          a.c("com/tencent/mm/plugin/card/ui/view/CardDetailTableView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          l.this.tFX = true;
          l.this.tFV.findViewById(a.d.tfA).setVisibility(8);
          int i = this.tFY.Ssb;
          while (i < localLinkedList.size())
          {
            paramAnonymousView = (TextView)localLayoutInflater.inflate(a.e.tjn, null, false);
            paramAnonymousView.setText(((acg)localLinkedList.get(i)).title);
            l.this.tFW.addView(paramAnonymousView);
            i += 1;
          }
          l.this.tFW.invalidate();
          a.a(this, "com/tencent/mm/plugin/card/ui/view/CardDetailTableView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(113681);
        }
      });
    }
    AppMethodBeat.o(113682);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.l
 * JD-Core Version:    0.7.0.1
 */