package com.tencent.mm.plugin.card.ui.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.ui.n;
import com.tencent.mm.protocal.protobuf.acm;
import com.tencent.mm.protocal.protobuf.qy;
import com.tencent.mm.protocal.protobuf.yg;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;

public final class l
  extends i
{
  View oli;
  LinearLayout olj;
  boolean olk = false;
  
  public final void bTM()
  {
    AppMethodBeat.i(113683);
    if (this.oli != null) {
      this.oli.setVisibility(8);
    }
    AppMethodBeat.o(113683);
  }
  
  public final void initView() {}
  
  public final void update()
  {
    AppMethodBeat.i(113682);
    if (this.oli == null) {
      this.oli = ((ViewStub)findViewById(2131297786)).inflate();
    }
    Object localObject = this.olg.bRG().bPj().Eip;
    ((TextView)this.oli.findViewById(2131299056)).setText(((acm)localObject).title);
    if ((((acm)localObject).EuY != null) && (((acm)localObject).EuY.size() > 0))
    {
      this.olj = ((LinearLayout)this.oli.findViewById(2131299055));
      this.olj.removeAllViews();
      final LinkedList localLinkedList = ((acm)localObject).EuY;
      final LayoutInflater localLayoutInflater = (LayoutInflater)this.olg.bRJ().getSystemService("layout_inflater");
      if ((((acm)localObject).EuX >= localLinkedList.size()) || (this.olk))
      {
        this.oli.findViewById(2131299054).setVisibility(8);
        i = 0;
        while (i < localLinkedList.size())
        {
          localObject = (TextView)localLayoutInflater.inflate(2131493357, null, false);
          ((TextView)localObject).setText(((yg)localLinkedList.get(i)).title);
          this.olj.addView((View)localObject);
          i += 1;
        }
        this.olj.invalidate();
        AppMethodBeat.o(113682);
        return;
      }
      int i = 0;
      while (i < ((acm)localObject).EuX)
      {
        TextView localTextView = (TextView)localLayoutInflater.inflate(2131493357, null, false);
        localTextView.setText(((yg)localLinkedList.get(i)).title);
        this.olj.addView(localTextView);
        i += 1;
      }
      this.olj.invalidate();
      this.oli.findViewById(2131299054).setVisibility(0);
      this.oli.findViewById(2131299054).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(113681);
          l.this.olk = true;
          l.this.oli.findViewById(2131299054).setVisibility(8);
          int i = this.oll.EuX;
          while (i < localLinkedList.size())
          {
            paramAnonymousView = (TextView)localLayoutInflater.inflate(2131493357, null, false);
            paramAnonymousView.setText(((yg)localLinkedList.get(i)).title);
            l.this.olj.addView(paramAnonymousView);
            i += 1;
          }
          l.this.olj.invalidate();
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