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
import com.tencent.mm.protocal.protobuf.aep;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;

public final class s
  extends BaseAdapter
{
  private String cnv;
  private Context context;
  private LinkedList<s.a> fjy;
  
  public s(Context paramContext)
  {
    AppMethodBeat.i(112182);
    this.cnv = "";
    this.fjy = new LinkedList();
    this.context = paramContext;
    AppMethodBeat.o(112182);
  }
  
  public final void b(String paramString1, String paramString2, LinkedList<aep> paramLinkedList)
  {
    AppMethodBeat.i(112186);
    if (bo.es(paramLinkedList))
    {
      AppMethodBeat.o(112186);
      return;
    }
    this.cnv = paramString1;
    this.fjy.clear();
    s.a locala;
    if (bo.isNullOrNil(paramString1))
    {
      locala = new s.a();
      locala.type = 1;
      if (!bo.isNullOrNil(paramString2))
      {
        locala.text = paramString2;
        this.fjy.add(locala);
      }
    }
    else
    {
      paramString2 = paramLinkedList.iterator();
      label80:
      if (!paramString2.hasNext()) {
        break label206;
      }
      paramLinkedList = (aep)paramString2.next();
      locala = new s.a();
      if (!bo.isNullOrNil(paramString1)) {
        break label200;
      }
    }
    label200:
    for (int i = 2;; i = 3)
    {
      locala.type = i;
      locala.appId = paramLinkedList.npZ;
      locala.text = paramLinkedList.wXz;
      locala.description = paramLinkedList.woO;
      locala.actionType = paramLinkedList.wzE;
      locala.nDg = paramLinkedList.wXs;
      this.fjy.add(locala);
      break label80;
      locala.text = this.context.getString(2131300453);
      break;
    }
    label206:
    notifyDataSetChanged();
    AppMethodBeat.o(112186);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(112184);
    int i = this.fjy.size();
    AppMethodBeat.o(112184);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(112183);
    Object localObject = xn(paramInt);
    if (paramView == null)
    {
      paramView = View.inflate(this.context, 2130969816, null);
      paramViewGroup = new s.b((byte)0);
      paramViewGroup.gui = ((TextView)paramView.findViewById(2131824753));
      paramViewGroup.nDh = ((ViewGroup)paramViewGroup.gui.getParent());
      paramViewGroup.nDi = ((TextView)paramView.findViewById(2131824754));
      paramViewGroup.nDj = ((TextView)paramView.findViewById(2131824755));
      paramViewGroup.nDk = ((ViewGroup)paramViewGroup.nDi.getParent());
      paramViewGroup.nDl = ((TextView)paramView.findViewById(2131824756));
      paramViewGroup.nDm = ((ViewGroup)paramViewGroup.nDl.getParent().getParent());
      paramView.setTag(paramViewGroup);
      switch (((s.a)localObject).type)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(112183);
      return paramView;
      paramViewGroup = (s.b)paramView.getTag();
      break;
      paramViewGroup.nDh.setVisibility(0);
      paramViewGroup.nDk.setVisibility(8);
      paramViewGroup.nDm.setVisibility(8);
      paramViewGroup.nDh.setOnClickListener(null);
      paramViewGroup.gui.setText(((s.a)localObject).text);
      continue;
      paramViewGroup.nDh.setVisibility(8);
      paramViewGroup.nDk.setVisibility(0);
      paramViewGroup.nDm.setVisibility(8);
      paramViewGroup.nDi.setText(((s.a)localObject).text);
      paramViewGroup.nDj.setText(((s.a)localObject).description);
      continue;
      paramViewGroup.nDh.setVisibility(8);
      paramViewGroup.nDk.setVisibility(8);
      paramViewGroup.nDm.setVisibility(0);
      paramInt = this.context.getResources().getColor(2131690322);
      paramViewGroup.nDl.setTextColor(paramInt);
      paramInt = this.context.getResources().getColor(2131690127);
      int i = ((s.a)localObject).text.indexOf(this.cnv);
      if (i >= 0)
      {
        localObject = new SpannableString(((s.a)localObject).text);
        ((Spannable)localObject).setSpan(new ForegroundColorSpan(paramInt), i, this.cnv.length() + i, 33);
        paramViewGroup.nDl.setText((CharSequence)localObject);
      }
      else
      {
        paramViewGroup.nDl.setText(((s.a)localObject).text);
      }
    }
  }
  
  public final s.a xn(int paramInt)
  {
    AppMethodBeat.i(112185);
    s.a locala = (s.a)this.fjy.get(paramInt);
    AppMethodBeat.o(112185);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.s
 * JD-Core Version:    0.7.0.1
 */