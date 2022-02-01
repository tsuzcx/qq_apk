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
import com.tencent.mm.protocal.protobuf.abn;
import com.tencent.mm.protocal.protobuf.qo;
import com.tencent.mm.protocal.protobuf.xo;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;

public final class l
  extends i
{
  View nIi;
  LinearLayout nIj;
  boolean nIk = false;
  
  public final void bMB()
  {
    AppMethodBeat.i(113683);
    if (this.nIi != null) {
      this.nIi.setVisibility(8);
    }
    AppMethodBeat.o(113683);
  }
  
  public final void initView() {}
  
  public final void update()
  {
    AppMethodBeat.i(113682);
    if (this.nIi == null) {
      this.nIi = ((ViewStub)findViewById(2131297786)).inflate();
    }
    Object localObject = this.nIg.bKt().bHW().CPE;
    ((TextView)this.nIi.findViewById(2131299056)).setText(((abn)localObject).title);
    if ((((abn)localObject).DbR != null) && (((abn)localObject).DbR.size() > 0))
    {
      this.nIj = ((LinearLayout)this.nIi.findViewById(2131299055));
      this.nIj.removeAllViews();
      final LinkedList localLinkedList = ((abn)localObject).DbR;
      final LayoutInflater localLayoutInflater = (LayoutInflater)this.nIg.bKw().getSystemService("layout_inflater");
      if ((((abn)localObject).DbQ >= localLinkedList.size()) || (this.nIk))
      {
        this.nIi.findViewById(2131299054).setVisibility(8);
        i = 0;
        while (i < localLinkedList.size())
        {
          localObject = (TextView)localLayoutInflater.inflate(2131493357, null, false);
          ((TextView)localObject).setText(((xo)localLinkedList.get(i)).title);
          this.nIj.addView((View)localObject);
          i += 1;
        }
        this.nIj.invalidate();
        AppMethodBeat.o(113682);
        return;
      }
      int i = 0;
      while (i < ((abn)localObject).DbQ)
      {
        TextView localTextView = (TextView)localLayoutInflater.inflate(2131493357, null, false);
        localTextView.setText(((xo)localLinkedList.get(i)).title);
        this.nIj.addView(localTextView);
        i += 1;
      }
      this.nIj.invalidate();
      this.nIi.findViewById(2131299054).setVisibility(0);
      this.nIi.findViewById(2131299054).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(113681);
          l.this.nIk = true;
          l.this.nIi.findViewById(2131299054).setVisibility(8);
          int i = this.nIl.DbQ;
          while (i < localLinkedList.size())
          {
            paramAnonymousView = (TextView)localLayoutInflater.inflate(2131493357, null, false);
            paramAnonymousView.setText(((xo)localLinkedList.get(i)).title);
            l.this.nIj.addView(paramAnonymousView);
            i += 1;
          }
          l.this.nIj.invalidate();
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