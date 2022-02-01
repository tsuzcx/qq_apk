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
import com.tencent.mm.protocal.protobuf.aaf;
import com.tencent.mm.protocal.protobuf.aem;
import com.tencent.mm.protocal.protobuf.sr;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;

public final class l
  extends i
{
  View oOD;
  LinearLayout oOE;
  boolean oOF = false;
  
  public final void bYr()
  {
    AppMethodBeat.i(113683);
    if (this.oOD != null) {
      this.oOD.setVisibility(8);
    }
    AppMethodBeat.o(113683);
  }
  
  public final void initView() {}
  
  public final void update()
  {
    AppMethodBeat.i(113682);
    if (this.oOD == null) {
      this.oOD = ((ViewStub)findViewById(2131297786)).inflate();
    }
    Object localObject = this.oOB.bWl().bTO().FPz;
    ((TextView)this.oOD.findViewById(2131299056)).setText(((aem)localObject).title);
    if ((((aem)localObject).Gcs != null) && (((aem)localObject).Gcs.size() > 0))
    {
      this.oOE = ((LinearLayout)this.oOD.findViewById(2131299055));
      this.oOE.removeAllViews();
      final LinkedList localLinkedList = ((aem)localObject).Gcs;
      final LayoutInflater localLayoutInflater = (LayoutInflater)this.oOB.bWo().getSystemService("layout_inflater");
      if ((((aem)localObject).Gcr >= localLinkedList.size()) || (this.oOF))
      {
        this.oOD.findViewById(2131299054).setVisibility(8);
        i = 0;
        while (i < localLinkedList.size())
        {
          localObject = (TextView)localLayoutInflater.inflate(2131493357, null, false);
          ((TextView)localObject).setText(((aaf)localLinkedList.get(i)).title);
          this.oOE.addView((View)localObject);
          i += 1;
        }
        this.oOE.invalidate();
        AppMethodBeat.o(113682);
        return;
      }
      int i = 0;
      while (i < ((aem)localObject).Gcr)
      {
        TextView localTextView = (TextView)localLayoutInflater.inflate(2131493357, null, false);
        localTextView.setText(((aaf)localLinkedList.get(i)).title);
        this.oOE.addView(localTextView);
        i += 1;
      }
      this.oOE.invalidate();
      this.oOD.findViewById(2131299054).setVisibility(0);
      this.oOD.findViewById(2131299054).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(113681);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          a.b("com/tencent/mm/plugin/card/ui/view/CardDetailTableView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          l.this.oOF = true;
          l.this.oOD.findViewById(2131299054).setVisibility(8);
          int i = this.oOG.Gcr;
          while (i < localLinkedList.size())
          {
            paramAnonymousView = (TextView)localLayoutInflater.inflate(2131493357, null, false);
            paramAnonymousView.setText(((aaf)localLinkedList.get(i)).title);
            l.this.oOE.addView(paramAnonymousView);
            i += 1;
          }
          l.this.oOE.invalidate();
          a.a(this, "com/tencent/mm/plugin/card/ui/view/CardDetailTableView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(113681);
        }
      });
    }
    AppMethodBeat.o(113682);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.l
 * JD-Core Version:    0.7.0.1
 */