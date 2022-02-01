package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aql;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.LinkedList;

public final class s
  extends BaseAdapter
{
  private String cZL;
  private Context context;
  private LinkedList<a> hkS;
  
  public s(Context paramContext)
  {
    AppMethodBeat.i(42380);
    this.cZL = "";
    this.hkS = new LinkedList();
    this.context = paramContext;
    AppMethodBeat.o(42380);
  }
  
  public final a GJ(int paramInt)
  {
    AppMethodBeat.i(42383);
    a locala = (a)this.hkS.get(paramInt);
    AppMethodBeat.o(42383);
    return locala;
  }
  
  public final void b(String paramString1, String paramString2, LinkedList<aql> paramLinkedList)
  {
    AppMethodBeat.i(42384);
    if (bs.gY(paramLinkedList))
    {
      AppMethodBeat.o(42384);
      return;
    }
    this.cZL = paramString1;
    this.hkS.clear();
    a locala;
    if (bs.isNullOrNil(paramString1))
    {
      locala = new a();
      locala.type = 1;
      if (!bs.isNullOrNil(paramString2))
      {
        locala.text = paramString2;
        this.hkS.add(locala);
      }
    }
    else
    {
      paramString2 = paramLinkedList.iterator();
      label80:
      if (!paramString2.hasNext()) {
        break label206;
      }
      paramLinkedList = (aql)paramString2.next();
      locala = new a();
      if (!bs.isNullOrNil(paramString1)) {
        break label200;
      }
    }
    label200:
    for (int i = 2;; i = 3)
    {
      locala.type = i;
      locala.appId = paramLinkedList.fZx;
      locala.text = paramLinkedList.EJv;
      locala.description = paramLinkedList.DPS;
      locala.actionType = paramLinkedList.Edq;
      locala.tuy = paramLinkedList.EJo;
      this.hkS.add(locala);
      break label80;
      locala.text = this.context.getString(2131759975);
      break;
    }
    label206:
    notifyDataSetChanged();
    AppMethodBeat.o(42384);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(42382);
    int i = this.hkS.size();
    AppMethodBeat.o(42382);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(42381);
    Object localObject = GJ(paramInt);
    if (paramView == null)
    {
      paramView = View.inflate(this.context, 2131494381, null);
      paramViewGroup = new b((byte)0);
      paramViewGroup.fUk = ((TextView)paramView.findViewById(2131300547));
      paramViewGroup.tuz = ((ViewGroup)paramViewGroup.fUk.getParent());
      paramViewGroup.tuA = ((TextView)paramView.findViewById(2131300546));
      paramViewGroup.tuB = ((TextView)paramView.findViewById(2131300544));
      paramViewGroup.tuC = ((ViewGroup)paramViewGroup.tuA.getParent());
      paramViewGroup.tuD = ((TextView)paramView.findViewById(2131300545));
      paramViewGroup.tuE = ((ViewGroup)paramViewGroup.tuD.getParent().getParent());
      paramView.setTag(paramViewGroup);
      switch (((a)localObject).type)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(42381);
      return paramView;
      paramViewGroup = (b)paramView.getTag();
      break;
      paramViewGroup.tuz.setVisibility(0);
      paramViewGroup.tuC.setVisibility(8);
      paramViewGroup.tuE.setVisibility(8);
      paramViewGroup.tuz.setOnClickListener(null);
      paramViewGroup.fUk.setText(((a)localObject).text);
      continue;
      paramViewGroup.tuz.setVisibility(8);
      paramViewGroup.tuC.setVisibility(0);
      paramViewGroup.tuE.setVisibility(8);
      paramViewGroup.tuA.setText(((a)localObject).text);
      paramViewGroup.tuB.setText(((a)localObject).description);
      continue;
      paramViewGroup.tuz.setVisibility(8);
      paramViewGroup.tuC.setVisibility(8);
      paramViewGroup.tuE.setVisibility(0);
      paramInt = this.context.getResources().getColor(2131100711);
      paramViewGroup.tuD.setTextColor(paramInt);
      paramInt = this.context.getResources().getColor(2131100452);
      int i = ((a)localObject).text.indexOf(this.cZL);
      if (i >= 0)
      {
        localObject = new SpannableString(((a)localObject).text);
        ((Spannable)localObject).setSpan(new ForegroundColorSpan(paramInt), i, this.cZL.length() + i, 33);
        paramViewGroup.tuD.setText((CharSequence)localObject);
      }
      else
      {
        paramViewGroup.tuD.setText(((a)localObject).text);
      }
    }
  }
  
  public static final class a
  {
    public int actionType;
    public String appId;
    public String description;
    public String text;
    public String tuy;
    public int type;
  }
  
  static final class b
  {
    TextView fUk;
    TextView tuA;
    TextView tuB;
    ViewGroup tuC;
    TextView tuD;
    ViewGroup tuE;
    ViewGroup tuz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.s
 * JD-Core Version:    0.7.0.1
 */