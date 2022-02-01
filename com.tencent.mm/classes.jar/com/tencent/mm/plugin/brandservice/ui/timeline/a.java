package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.arch.lifecycle.MutableLiveData;
import android.content.Intent;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.report.service.h;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class a
  extends RecyclerView.a<a>
{
  private long foF;
  private c fze;
  List<com.tencent.mm.plugin.brandservice.ui.timeline.b.a> nyB;
  Set<com.tencent.mm.plugin.brandservice.ui.timeline.b.a> nyC;
  MutableLiveData<Set<com.tencent.mm.plugin.brandservice.ui.timeline.b.a>> nyD;
  private int nyE;
  private long nyF;
  
  public a(List<com.tencent.mm.plugin.brandservice.ui.timeline.b.a> paramList, MutableLiveData<Set<com.tencent.mm.plugin.brandservice.ui.timeline.b.a>> paramMutableLiveData, long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(5840);
    this.nyB = paramList;
    this.nyC = new HashSet();
    this.nyD = paramMutableLiveData;
    paramMutableLiveData.setValue(this.nyC);
    paramList = new c.a();
    paramList.hKL = 2131231342;
    paramList.hKw = true;
    paramList.gLt = true;
    this.fze = paramList.aFT();
    this.nyF = paramLong1;
    this.foF = paramLong2;
    this.nyE = paramInt;
    AppMethodBeat.o(5840);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(5841);
    int i = this.nyB.size();
    AppMethodBeat.o(5841);
    return i;
  }
  
  static final class a
    extends RecyclerView.w
  {
    ImageView iKw;
    CheckBox nyJ;
    TextView nyK;
    TextView nyL;
    TextView nyM;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(5839);
      this.nyJ = ((CheckBox)paramView.findViewById(2131301220));
      this.nyK = ((TextView)paramView.findViewById(2131306109));
      this.nyL = ((TextView)paramView.findViewById(2131306147));
      this.nyM = ((TextView)paramView.findViewById(2131306119));
      this.iKw = ((ImageView)paramView.findViewById(2131301204));
      AppMethodBeat.o(5839);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a
 * JD-Core Version:    0.7.0.1
 */