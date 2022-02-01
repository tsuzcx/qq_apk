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
import com.tencent.mm.protocal.protobuf.aai;
import com.tencent.mm.protocal.protobuf.aev;
import com.tencent.mm.protocal.protobuf.st;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;

public final class l
  extends i
{
  View oVf;
  LinearLayout oVg;
  boolean oVh = false;
  
  public final void bZG()
  {
    AppMethodBeat.i(113683);
    if (this.oVf != null) {
      this.oVf.setVisibility(8);
    }
    AppMethodBeat.o(113683);
  }
  
  public final void initView() {}
  
  public final void update()
  {
    AppMethodBeat.i(113682);
    if (this.oVf == null) {
      this.oVf = ((ViewStub)findViewById(2131297786)).inflate();
    }
    Object localObject = this.oVd.bXA().bVd().GhY;
    ((TextView)this.oVf.findViewById(2131299056)).setText(((aev)localObject).title);
    if ((((aev)localObject).GuZ != null) && (((aev)localObject).GuZ.size() > 0))
    {
      this.oVg = ((LinearLayout)this.oVf.findViewById(2131299055));
      this.oVg.removeAllViews();
      final LinkedList localLinkedList = ((aev)localObject).GuZ;
      final LayoutInflater localLayoutInflater = (LayoutInflater)this.oVd.bXD().getSystemService("layout_inflater");
      if ((((aev)localObject).GuY >= localLinkedList.size()) || (this.oVh))
      {
        this.oVf.findViewById(2131299054).setVisibility(8);
        i = 0;
        while (i < localLinkedList.size())
        {
          localObject = (TextView)localLayoutInflater.inflate(2131493357, null, false);
          ((TextView)localObject).setText(((aai)localLinkedList.get(i)).title);
          this.oVg.addView((View)localObject);
          i += 1;
        }
        this.oVg.invalidate();
        AppMethodBeat.o(113682);
        return;
      }
      int i = 0;
      while (i < ((aev)localObject).GuY)
      {
        TextView localTextView = (TextView)localLayoutInflater.inflate(2131493357, null, false);
        localTextView.setText(((aai)localLinkedList.get(i)).title);
        this.oVg.addView(localTextView);
        i += 1;
      }
      this.oVg.invalidate();
      this.oVf.findViewById(2131299054).setVisibility(0);
      this.oVf.findViewById(2131299054).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(113681);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          a.b("com/tencent/mm/plugin/card/ui/view/CardDetailTableView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          l.this.oVh = true;
          l.this.oVf.findViewById(2131299054).setVisibility(8);
          int i = this.oVi.GuY;
          while (i < localLinkedList.size())
          {
            paramAnonymousView = (TextView)localLayoutInflater.inflate(2131493357, null, false);
            paramAnonymousView.setText(((aai)localLinkedList.get(i)).title);
            l.this.oVg.addView(paramAnonymousView);
            i += 1;
          }
          l.this.oVg.invalidate();
          a.a(this, "com/tencent/mm/plugin/card/ui/view/CardDetailTableView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(113681);
        }
      });
    }
    AppMethodBeat.o(113682);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.l
 * JD-Core Version:    0.7.0.1
 */