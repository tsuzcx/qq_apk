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
import com.tencent.mm.protocal.protobuf.aux;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.LinkedList;

public final class s
  extends BaseAdapter
{
  private Context context;
  private String dmf;
  private LinkedList<a> hFT;
  
  public s(Context paramContext)
  {
    AppMethodBeat.i(42380);
    this.dmf = "";
    this.hFT = new LinkedList();
    this.context = paramContext;
    AppMethodBeat.o(42380);
  }
  
  public final a IA(int paramInt)
  {
    AppMethodBeat.i(42383);
    a locala = (a)this.hFT.get(paramInt);
    AppMethodBeat.o(42383);
    return locala;
  }
  
  public final void b(String paramString1, String paramString2, LinkedList<aux> paramLinkedList)
  {
    AppMethodBeat.i(42384);
    if (bu.ht(paramLinkedList))
    {
      AppMethodBeat.o(42384);
      return;
    }
    this.dmf = paramString1;
    this.hFT.clear();
    a locala;
    if (bu.isNullOrNil(paramString1))
    {
      locala = new a();
      locala.type = 1;
      if (!bu.isNullOrNil(paramString2))
      {
        locala.text = paramString2;
        this.hFT.add(locala);
      }
    }
    else
    {
      paramString2 = paramLinkedList.iterator();
      label80:
      if (!paramString2.hasNext()) {
        break label206;
      }
      paramLinkedList = (aux)paramString2.next();
      locala = new a();
      if (!bu.isNullOrNil(paramString1)) {
        break label200;
      }
    }
    label200:
    for (int i = 2;; i = 3)
    {
      locala.type = i;
      locala.appId = paramLinkedList.gvv;
      locala.text = paramLinkedList.GLV;
      locala.description = paramLinkedList.FNF;
      locala.actionType = paramLinkedList.GbY;
      locala.uEq = paramLinkedList.GLO;
      this.hFT.add(locala);
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
    int i = this.hFT.size();
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
    Object localObject = IA(paramInt);
    if (paramView == null)
    {
      paramView = View.inflate(this.context, 2131494381, null);
      paramViewGroup = new b((byte)0);
      paramViewGroup.gqi = ((TextView)paramView.findViewById(2131300547));
      paramViewGroup.uEr = ((ViewGroup)paramViewGroup.gqi.getParent());
      paramViewGroup.uEs = ((TextView)paramView.findViewById(2131300546));
      paramViewGroup.uEt = ((TextView)paramView.findViewById(2131300544));
      paramViewGroup.uEu = ((ViewGroup)paramViewGroup.uEs.getParent());
      paramViewGroup.uEv = ((TextView)paramView.findViewById(2131300545));
      paramViewGroup.uEw = ((ViewGroup)paramViewGroup.uEv.getParent().getParent());
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
      paramViewGroup.uEr.setVisibility(0);
      paramViewGroup.uEu.setVisibility(8);
      paramViewGroup.uEw.setVisibility(8);
      paramViewGroup.uEr.setOnClickListener(null);
      paramViewGroup.gqi.setText(((a)localObject).text);
      continue;
      paramViewGroup.uEr.setVisibility(8);
      paramViewGroup.uEu.setVisibility(0);
      paramViewGroup.uEw.setVisibility(8);
      paramViewGroup.uEs.setText(((a)localObject).text);
      paramViewGroup.uEt.setText(((a)localObject).description);
      continue;
      paramViewGroup.uEr.setVisibility(8);
      paramViewGroup.uEu.setVisibility(8);
      paramViewGroup.uEw.setVisibility(0);
      paramInt = this.context.getResources().getColor(2131100711);
      paramViewGroup.uEv.setTextColor(paramInt);
      paramInt = this.context.getResources().getColor(2131100452);
      int i = ((a)localObject).text.indexOf(this.dmf);
      if (i >= 0)
      {
        localObject = new SpannableString(((a)localObject).text);
        ((Spannable)localObject).setSpan(new ForegroundColorSpan(paramInt), i, this.dmf.length() + i, 33);
        paramViewGroup.uEv.setText((CharSequence)localObject);
      }
      else
      {
        paramViewGroup.uEv.setText(((a)localObject).text);
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
    public String uEq;
  }
  
  static final class b
  {
    TextView gqi;
    ViewGroup uEr;
    TextView uEs;
    TextView uEt;
    ViewGroup uEu;
    TextView uEv;
    ViewGroup uEw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.s
 * JD-Core Version:    0.7.0.1
 */