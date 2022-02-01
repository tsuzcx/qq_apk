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
import com.tencent.mm.protocal.protobuf.aek;
import com.tencent.mm.protocal.protobuf.akc;
import com.tencent.mm.protocal.protobuf.vr;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;

public final class l
  extends i
{
  View wJu;
  LinearLayout wJv;
  boolean wJw = false;
  
  public final void doE()
  {
    AppMethodBeat.i(113683);
    if (this.wJu != null) {
      this.wJu.setVisibility(8);
    }
    AppMethodBeat.o(113683);
  }
  
  public final void initView() {}
  
  public final void update()
  {
    AppMethodBeat.i(113682);
    if (this.wJu == null) {
      this.wJu = ((ViewStub)findViewById(a.d.wgg)).inflate();
    }
    Object localObject = this.wJs.dmk().djL().ZbI;
    ((TextView)this.wJu.findViewById(a.d.wjY)).setText(((akc)localObject).title);
    if ((((akc)localObject).Zrk != null) && (((akc)localObject).Zrk.size() > 0))
    {
      this.wJv = ((LinearLayout)this.wJu.findViewById(a.d.wjX));
      this.wJv.removeAllViews();
      final LinkedList localLinkedList = ((akc)localObject).Zrk;
      final LayoutInflater localLayoutInflater = (LayoutInflater)this.wJs.dmn().getSystemService("layout_inflater");
      if ((((akc)localObject).Zrj >= localLinkedList.size()) || (this.wJw))
      {
        this.wJu.findViewById(a.d.wjW).setVisibility(8);
        i = 0;
        while (i < localLinkedList.size())
        {
          localObject = (TextView)localLayoutInflater.inflate(a.e.wnK, null, false);
          ((TextView)localObject).setText(((aek)localLinkedList.get(i)).title);
          this.wJv.addView((View)localObject);
          i += 1;
        }
        this.wJv.invalidate();
        AppMethodBeat.o(113682);
        return;
      }
      int i = 0;
      while (i < ((akc)localObject).Zrj)
      {
        TextView localTextView = (TextView)localLayoutInflater.inflate(a.e.wnK, null, false);
        localTextView.setText(((aek)localLinkedList.get(i)).title);
        this.wJv.addView(localTextView);
        i += 1;
      }
      this.wJv.invalidate();
      this.wJu.findViewById(a.d.wjW).setVisibility(0);
      this.wJu.findViewById(a.d.wjW).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(113681);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          a.c("com/tencent/mm/plugin/card/ui/view/CardDetailTableView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          l.this.wJw = true;
          l.this.wJu.findViewById(a.d.wjW).setVisibility(8);
          int i = this.wJx.Zrj;
          while (i < localLinkedList.size())
          {
            paramAnonymousView = (TextView)localLayoutInflater.inflate(a.e.wnK, null, false);
            paramAnonymousView.setText(((aek)localLinkedList.get(i)).title);
            l.this.wJv.addView(paramAnonymousView);
            i += 1;
          }
          l.this.wJv.invalidate();
          a.a(this, "com/tencent/mm/plugin/card/ui/view/CardDetailTableView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(113681);
        }
      });
    }
    AppMethodBeat.o(113682);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.l
 * JD-Core Version:    0.7.0.1
 */