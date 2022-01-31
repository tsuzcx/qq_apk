package com.tencent.mm.plugin.card.ui.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.ui.n;
import com.tencent.mm.protocal.protobuf.oj;
import com.tencent.mm.protocal.protobuf.uo;
import com.tencent.mm.protocal.protobuf.yf;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;

public final class l
  extends i
{
  View kBj;
  LinearLayout kBk;
  boolean kBl = false;
  
  public final void bfq()
  {
    AppMethodBeat.i(88756);
    if (this.kBj != null) {
      this.kBj.setVisibility(8);
    }
    AppMethodBeat.o(88756);
  }
  
  public final void initView() {}
  
  public final void update()
  {
    AppMethodBeat.i(88755);
    if (this.kBj == null) {
      this.kBj = ((ViewStub)findViewById(2131822086)).inflate();
    }
    Object localObject = this.kBh.bdv().bbe().wEd;
    ((TextView)this.kBj.findViewById(2131822067)).setText(((yf)localObject).title);
    if ((((yf)localObject).wPn != null) && (((yf)localObject).wPn.size() > 0))
    {
      this.kBk = ((LinearLayout)this.kBj.findViewById(2131822068));
      this.kBk.removeAllViews();
      LinkedList localLinkedList = ((yf)localObject).wPn;
      LayoutInflater localLayoutInflater = (LayoutInflater)this.kBh.bdy().getSystemService("layout_inflater");
      if ((((yf)localObject).wPm >= localLinkedList.size()) || (this.kBl))
      {
        this.kBj.findViewById(2131822069).setVisibility(8);
        i = 0;
        while (i < localLinkedList.size())
        {
          localObject = (TextView)localLayoutInflater.inflate(2130969006, null, false);
          ((TextView)localObject).setText(((uo)localLinkedList.get(i)).title);
          this.kBk.addView((View)localObject);
          i += 1;
        }
        this.kBk.invalidate();
        AppMethodBeat.o(88755);
        return;
      }
      int i = 0;
      while (i < ((yf)localObject).wPm)
      {
        TextView localTextView = (TextView)localLayoutInflater.inflate(2130969006, null, false);
        localTextView.setText(((uo)localLinkedList.get(i)).title);
        this.kBk.addView(localTextView);
        i += 1;
      }
      this.kBk.invalidate();
      this.kBj.findViewById(2131822069).setVisibility(0);
      this.kBj.findViewById(2131822069).setOnClickListener(new l.1(this, (yf)localObject, localLinkedList, localLayoutInflater));
    }
    AppMethodBeat.o(88755);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.l
 * JD-Core Version:    0.7.0.1
 */