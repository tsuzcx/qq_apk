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
import com.tencent.mm.plugin.game.g.b;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.plugin.game.g.i;
import com.tencent.mm.protocal.protobuf.bni;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class s
  extends BaseAdapter
{
  private Context context;
  private String fwe;
  private LinkedList<a> lpz;
  
  public s(Context paramContext)
  {
    AppMethodBeat.i(42380);
    this.fwe = "";
    this.lpz = new LinkedList();
    this.context = paramContext;
    AppMethodBeat.o(42380);
  }
  
  public final a TV(int paramInt)
  {
    AppMethodBeat.i(42383);
    a locala = (a)this.lpz.get(paramInt);
    AppMethodBeat.o(42383);
    return locala;
  }
  
  public final void a(String paramString1, String paramString2, LinkedList<bni> paramLinkedList)
  {
    AppMethodBeat.i(42384);
    if (Util.isNullOrNil(paramLinkedList))
    {
      AppMethodBeat.o(42384);
      return;
    }
    this.fwe = paramString1;
    this.lpz.clear();
    a locala;
    if (Util.isNullOrNil(paramString1))
    {
      locala = new a();
      locala.type = 1;
      if (!Util.isNullOrNil(paramString2))
      {
        locala.text = paramString2;
        this.lpz.add(locala);
      }
    }
    else
    {
      paramString2 = paramLinkedList.iterator();
      label80:
      if (!paramString2.hasNext()) {
        break label207;
      }
      paramLinkedList = (bni)paramString2.next();
      locala = new a();
      if (!Util.isNullOrNil(paramString1)) {
        break label201;
      }
    }
    label201:
    for (int i = 2;; i = 3)
    {
      locala.type = i;
      locala.appId = paramLinkedList.jUi;
      locala.text = paramLinkedList.SYt;
      locala.description = paramLinkedList.RIC;
      locala.actionType = paramLinkedList.RXp;
      locala.Dax = paramLinkedList.SYm;
      this.lpz.add(locala);
      break label80;
      locala.text = this.context.getString(g.i.Cko);
      break;
    }
    label207:
    notifyDataSetChanged();
    AppMethodBeat.o(42384);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(42382);
    int i = this.lpz.size();
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
    Object localObject = TV(paramInt);
    if (paramView == null)
    {
      paramView = View.inflate(this.context, g.f.Cod, null);
      paramViewGroup = new b((byte)0);
      paramViewGroup.jMg = ((TextView)paramView.findViewById(g.e.Cko));
      paramViewGroup.Day = ((ViewGroup)paramViewGroup.jMg.getParent());
      paramViewGroup.Daz = ((TextView)paramView.findViewById(g.e.Ckn));
      paramViewGroup.DaA = ((TextView)paramView.findViewById(g.e.Ckl));
      paramViewGroup.DaB = ((ViewGroup)paramViewGroup.Daz.getParent());
      paramViewGroup.DaC = ((TextView)paramView.findViewById(g.e.Ckm));
      paramViewGroup.DaD = ((ViewGroup)paramViewGroup.DaC.getParent().getParent());
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
      paramViewGroup.Day.setVisibility(0);
      paramViewGroup.DaB.setVisibility(8);
      paramViewGroup.DaD.setVisibility(8);
      paramViewGroup.Day.setOnClickListener(null);
      paramViewGroup.jMg.setText(((a)localObject).text);
      continue;
      paramViewGroup.Day.setVisibility(8);
      paramViewGroup.DaB.setVisibility(0);
      paramViewGroup.DaD.setVisibility(8);
      paramViewGroup.Daz.setText(((a)localObject).text);
      paramViewGroup.DaA.setText(((a)localObject).description);
      continue;
      paramViewGroup.Day.setVisibility(8);
      paramViewGroup.DaB.setVisibility(8);
      paramViewGroup.DaD.setVisibility(0);
      paramInt = this.context.getResources().getColor(g.b.normal_text_color);
      paramViewGroup.DaC.setTextColor(paramInt);
      paramInt = this.context.getResources().getColor(g.b.CgK);
      int i = ((a)localObject).text.indexOf(this.fwe);
      if (i >= 0)
      {
        localObject = new SpannableString(((a)localObject).text);
        ((Spannable)localObject).setSpan(new ForegroundColorSpan(paramInt), i, this.fwe.length() + i, 33);
        paramViewGroup.DaC.setText((CharSequence)localObject);
      }
      else
      {
        paramViewGroup.DaC.setText(((a)localObject).text);
      }
    }
  }
  
  public static final class a
  {
    public String Dax;
    public int actionType;
    public String appId;
    public String description;
    public String text;
    public int type;
  }
  
  static final class b
  {
    TextView DaA;
    ViewGroup DaB;
    TextView DaC;
    ViewGroup DaD;
    ViewGroup Day;
    TextView Daz;
    TextView jMg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.s
 * JD-Core Version:    0.7.0.1
 */