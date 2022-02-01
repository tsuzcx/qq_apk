package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.arch.lifecycle.MutableLiveData;
import android.content.Intent;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.a.c;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.bs.d;
import com.tencent.mm.plugin.report.service.h;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class a
  extends RecyclerView.a<a>
{
  private long fll;
  private c fvx;
  List<com.tencent.mm.plugin.brandservice.ui.timeline.b.a> mWc;
  Set<com.tencent.mm.plugin.brandservice.ui.timeline.b.a> mWd;
  MutableLiveData<Set<com.tencent.mm.plugin.brandservice.ui.timeline.b.a>> mWe;
  private int mWf;
  private long mWg;
  
  public a(List<com.tencent.mm.plugin.brandservice.ui.timeline.b.a> paramList, MutableLiveData<Set<com.tencent.mm.plugin.brandservice.ui.timeline.b.a>> paramMutableLiveData, long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(5840);
    this.mWc = paramList;
    this.mWd = new HashSet();
    this.mWe = paramMutableLiveData;
    paramMutableLiveData.setValue(this.mWd);
    paramList = new c.a();
    paramList.hki = 2131231342;
    paramList.hjT = true;
    paramList.gkG = true;
    this.fvx = paramList.azc();
    this.mWg = paramLong1;
    this.fll = paramLong2;
    this.mWf = paramInt;
    AppMethodBeat.o(5840);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(5841);
    int i = this.mWc.size();
    AppMethodBeat.o(5841);
    return i;
  }
  
  static final class a
    extends RecyclerView.v
  {
    ImageView ikp;
    CheckBox mWk;
    TextView mWl;
    TextView mWm;
    TextView mWn;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(5839);
      this.mWk = ((CheckBox)paramView.findViewById(2131301220));
      this.mWl = ((TextView)paramView.findViewById(2131306109));
      this.mWm = ((TextView)paramView.findViewById(2131306147));
      this.mWn = ((TextView)paramView.findViewById(2131306119));
      this.ikp = ((ImageView)paramView.findViewById(2131301204));
      AppMethodBeat.o(5839);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a
 * JD-Core Version:    0.7.0.1
 */