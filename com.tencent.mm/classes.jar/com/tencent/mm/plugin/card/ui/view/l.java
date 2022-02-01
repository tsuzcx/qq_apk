package com.tencent.mm.plugin.card.ui.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.card.ui.n;
import com.tencent.mm.protocal.protobuf.abz;
import com.tencent.mm.protocal.protobuf.agz;
import com.tencent.mm.protocal.protobuf.ty;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;

public final class l
  extends i
{
  View qjZ;
  LinearLayout qka;
  boolean qkb = false;
  
  public final void cxw()
  {
    AppMethodBeat.i(113683);
    if (this.qjZ != null) {
      this.qjZ.setVisibility(8);
    }
    AppMethodBeat.o(113683);
  }
  
  public final void initView() {}
  
  public final void update()
  {
    AppMethodBeat.i(113682);
    if (this.qjZ == null) {
      this.qjZ = ((ViewStub)findViewById(2131298101)).inflate();
    }
    Object localObject = this.qjX.cvq().csR().LcB;
    ((TextView)this.qjZ.findViewById(2131299562)).setText(((agz)localObject).title);
    if ((((agz)localObject).LqE != null) && (((agz)localObject).LqE.size() > 0))
    {
      this.qka = ((LinearLayout)this.qjZ.findViewById(2131299561));
      this.qka.removeAllViews();
      final LinkedList localLinkedList = ((agz)localObject).LqE;
      final LayoutInflater localLayoutInflater = (LayoutInflater)this.qjX.cvt().getSystemService("layout_inflater");
      if ((((agz)localObject).LqD >= localLinkedList.size()) || (this.qkb))
      {
        this.qjZ.findViewById(2131299560).setVisibility(8);
        i = 0;
        while (i < localLinkedList.size())
        {
          localObject = (TextView)localLayoutInflater.inflate(2131493448, null, false);
          ((TextView)localObject).setText(((abz)localLinkedList.get(i)).title);
          this.qka.addView((View)localObject);
          i += 1;
        }
        this.qka.invalidate();
        AppMethodBeat.o(113682);
        return;
      }
      int i = 0;
      while (i < ((agz)localObject).LqD)
      {
        TextView localTextView = (TextView)localLayoutInflater.inflate(2131493448, null, false);
        localTextView.setText(((abz)localLinkedList.get(i)).title);
        this.qka.addView(localTextView);
        i += 1;
      }
      this.qka.invalidate();
      this.qjZ.findViewById(2131299560).setVisibility(0);
      this.qjZ.findViewById(2131299560).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(113681);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          a.b("com/tencent/mm/plugin/card/ui/view/CardDetailTableView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          l.this.qkb = true;
          l.this.qjZ.findViewById(2131299560).setVisibility(8);
          int i = this.qkc.LqD;
          while (i < localLinkedList.size())
          {
            paramAnonymousView = (TextView)localLayoutInflater.inflate(2131493448, null, false);
            paramAnonymousView.setText(((abz)localLinkedList.get(i)).title);
            l.this.qka.addView(paramAnonymousView);
            i += 1;
          }
          l.this.qka.invalidate();
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