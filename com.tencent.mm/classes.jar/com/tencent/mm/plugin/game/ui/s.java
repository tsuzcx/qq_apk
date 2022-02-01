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
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;

public final class s
  extends BaseAdapter
{
  private Context context;
  private String dcm;
  private LinkedList<a> gKs;
  
  public s(Context paramContext)
  {
    AppMethodBeat.i(42380);
    this.dcm = "";
    this.gKs = new LinkedList();
    this.context = paramContext;
    AppMethodBeat.o(42380);
  }
  
  public final a EN(int paramInt)
  {
    AppMethodBeat.i(42383);
    a locala = (a)this.gKs.get(paramInt);
    AppMethodBeat.o(42383);
    return locala;
  }
  
  public final void b(String paramString1, String paramString2, LinkedList<anh> paramLinkedList)
  {
    AppMethodBeat.i(42384);
    if (bt.gL(paramLinkedList))
    {
      AppMethodBeat.o(42384);
      return;
    }
    this.dcm = paramString1;
    this.gKs.clear();
    a locala;
    if (bt.isNullOrNil(paramString1))
    {
      locala = new a();
      locala.type = 1;
      if (!bt.isNullOrNil(paramString2))
      {
        locala.text = paramString2;
        this.gKs.add(locala);
      }
    }
    else
    {
      paramString2 = paramLinkedList.iterator();
      label80:
      if (!paramString2.hasNext()) {
        break label206;
      }
      paramLinkedList = (anh)paramString2.next();
      locala = new a();
      if (!bt.isNullOrNil(paramString1)) {
        break label200;
      }
    }
    label200:
    for (int i = 2;; i = 3)
    {
      locala.type = i;
      locala.appId = paramLinkedList.fVC;
      locala.text = paramLinkedList.Dov;
      locala.description = paramLinkedList.Cxw;
      locala.actionType = paramLinkedList.CKO;
      locala.smF = paramLinkedList.Doo;
      this.gKs.add(locala);
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
    int i = this.gKs.size();
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
    Object localObject = EN(paramInt);
    if (paramView == null)
    {
      paramView = View.inflate(this.context, 2131494381, null);
      paramViewGroup = new b((byte)0);
      paramViewGroup.fQp = ((TextView)paramView.findViewById(2131300547));
      paramViewGroup.smG = ((ViewGroup)paramViewGroup.fQp.getParent());
      paramViewGroup.smH = ((TextView)paramView.findViewById(2131300546));
      paramViewGroup.smI = ((TextView)paramView.findViewById(2131300544));
      paramViewGroup.smJ = ((ViewGroup)paramViewGroup.smH.getParent());
      paramViewGroup.smK = ((TextView)paramView.findViewById(2131300545));
      paramViewGroup.smL = ((ViewGroup)paramViewGroup.smK.getParent().getParent());
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
      paramViewGroup.smG.setVisibility(0);
      paramViewGroup.smJ.setVisibility(8);
      paramViewGroup.smL.setVisibility(8);
      paramViewGroup.smG.setOnClickListener(null);
      paramViewGroup.fQp.setText(((a)localObject).text);
      continue;
      paramViewGroup.smG.setVisibility(8);
      paramViewGroup.smJ.setVisibility(0);
      paramViewGroup.smL.setVisibility(8);
      paramViewGroup.smH.setText(((a)localObject).text);
      paramViewGroup.smI.setText(((a)localObject).description);
      continue;
      paramViewGroup.smG.setVisibility(8);
      paramViewGroup.smJ.setVisibility(8);
      paramViewGroup.smL.setVisibility(0);
      paramInt = this.context.getResources().getColor(2131100711);
      paramViewGroup.smK.setTextColor(paramInt);
      paramInt = this.context.getResources().getColor(2131100452);
      int i = ((a)localObject).text.indexOf(this.dcm);
      if (i >= 0)
      {
        localObject = new SpannableString(((a)localObject).text);
        ((Spannable)localObject).setSpan(new ForegroundColorSpan(paramInt), i, this.dcm.length() + i, 33);
        paramViewGroup.smK.setText((CharSequence)localObject);
      }
      else
      {
        paramViewGroup.smK.setText(((a)localObject).text);
      }
    }
  }
  
  public static final class a
  {
    public int actionType;
    public String appId;
    public String description;
    public String smF;
    public String text;
    public int type;
  }
  
  static final class b
  {
    TextView fQp;
    ViewGroup smG;
    TextView smH;
    TextView smI;
    ViewGroup smJ;
    TextView smK;
    ViewGroup smL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.s
 * JD-Core Version:    0.7.0.1
 */