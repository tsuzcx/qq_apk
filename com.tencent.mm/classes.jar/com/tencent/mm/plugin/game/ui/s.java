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
import com.tencent.mm.protocal.protobuf.auh;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;

public final class s
  extends BaseAdapter
{
  private Context context;
  private String dld;
  private LinkedList<a> hDb;
  
  public s(Context paramContext)
  {
    AppMethodBeat.i(42380);
    this.dld = "";
    this.hDb = new LinkedList();
    this.context = paramContext;
    AppMethodBeat.o(42380);
  }
  
  public final a Ic(int paramInt)
  {
    AppMethodBeat.i(42383);
    a locala = (a)this.hDb.get(paramInt);
    AppMethodBeat.o(42383);
    return locala;
  }
  
  public final void b(String paramString1, String paramString2, LinkedList<auh> paramLinkedList)
  {
    AppMethodBeat.i(42384);
    if (bt.hj(paramLinkedList))
    {
      AppMethodBeat.o(42384);
      return;
    }
    this.dld = paramString1;
    this.hDb.clear();
    a locala;
    if (bt.isNullOrNil(paramString1))
    {
      locala = new a();
      locala.type = 1;
      if (!bt.isNullOrNil(paramString2))
      {
        locala.text = paramString2;
        this.hDb.add(locala);
      }
    }
    else
    {
      paramString2 = paramLinkedList.iterator();
      label80:
      if (!paramString2.hasNext()) {
        break label206;
      }
      paramLinkedList = (auh)paramString2.next();
      locala = new a();
      if (!bt.isNullOrNil(paramString1)) {
        break label200;
      }
    }
    label200:
    for (int i = 2;; i = 3)
    {
      locala.type = i;
      locala.appId = paramLinkedList.gsT;
      locala.text = paramLinkedList.Gsx;
      locala.description = paramLinkedList.Fvh;
      locala.actionType = paramLinkedList.FJz;
      locala.usX = paramLinkedList.Gsq;
      this.hDb.add(locala);
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
    int i = this.hDb.size();
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
    Object localObject = Ic(paramInt);
    if (paramView == null)
    {
      paramView = View.inflate(this.context, 2131494381, null);
      paramViewGroup = new b((byte)0);
      paramViewGroup.gnM = ((TextView)paramView.findViewById(2131300547));
      paramViewGroup.usY = ((ViewGroup)paramViewGroup.gnM.getParent());
      paramViewGroup.usZ = ((TextView)paramView.findViewById(2131300546));
      paramViewGroup.uta = ((TextView)paramView.findViewById(2131300544));
      paramViewGroup.utb = ((ViewGroup)paramViewGroup.usZ.getParent());
      paramViewGroup.utc = ((TextView)paramView.findViewById(2131300545));
      paramViewGroup.utd = ((ViewGroup)paramViewGroup.utc.getParent().getParent());
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
      paramViewGroup.usY.setVisibility(0);
      paramViewGroup.utb.setVisibility(8);
      paramViewGroup.utd.setVisibility(8);
      paramViewGroup.usY.setOnClickListener(null);
      paramViewGroup.gnM.setText(((a)localObject).text);
      continue;
      paramViewGroup.usY.setVisibility(8);
      paramViewGroup.utb.setVisibility(0);
      paramViewGroup.utd.setVisibility(8);
      paramViewGroup.usZ.setText(((a)localObject).text);
      paramViewGroup.uta.setText(((a)localObject).description);
      continue;
      paramViewGroup.usY.setVisibility(8);
      paramViewGroup.utb.setVisibility(8);
      paramViewGroup.utd.setVisibility(0);
      paramInt = this.context.getResources().getColor(2131100711);
      paramViewGroup.utc.setTextColor(paramInt);
      paramInt = this.context.getResources().getColor(2131100452);
      int i = ((a)localObject).text.indexOf(this.dld);
      if (i >= 0)
      {
        localObject = new SpannableString(((a)localObject).text);
        ((Spannable)localObject).setSpan(new ForegroundColorSpan(paramInt), i, this.dld.length() + i, 33);
        paramViewGroup.utc.setText((CharSequence)localObject);
      }
      else
      {
        paramViewGroup.utc.setText(((a)localObject).text);
      }
    }
  }
  
  public static final class a
  {
    public int actionType;
    public String appId;
    public String description;
    public String text;
    public int type;
    public String usX;
  }
  
  static final class b
  {
    TextView gnM;
    ViewGroup usY;
    TextView usZ;
    TextView uta;
    ViewGroup utb;
    TextView utc;
    ViewGroup utd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.s
 * JD-Core Version:    0.7.0.1
 */