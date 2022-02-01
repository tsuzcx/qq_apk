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
import com.tencent.mm.protocal.protobuf.bgg;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class s
  extends BaseAdapter
{
  private Context context;
  private String dDv;
  private LinkedList<a> iAd;
  
  public s(Context paramContext)
  {
    AppMethodBeat.i(42380);
    this.dDv = "";
    this.iAd = new LinkedList();
    this.context = paramContext;
    AppMethodBeat.o(42380);
  }
  
  public final a OB(int paramInt)
  {
    AppMethodBeat.i(42383);
    a locala = (a)this.iAd.get(paramInt);
    AppMethodBeat.o(42383);
    return locala;
  }
  
  public final void b(String paramString1, String paramString2, LinkedList<bgg> paramLinkedList)
  {
    AppMethodBeat.i(42384);
    if (Util.isNullOrNil(paramLinkedList))
    {
      AppMethodBeat.o(42384);
      return;
    }
    this.dDv = paramString1;
    this.iAd.clear();
    a locala;
    if (Util.isNullOrNil(paramString1))
    {
      locala = new a();
      locala.type = 1;
      if (!Util.isNullOrNil(paramString2))
      {
        locala.text = paramString2;
        this.iAd.add(locala);
      }
    }
    else
    {
      paramString2 = paramLinkedList.iterator();
      label80:
      if (!paramString2.hasNext()) {
        break label206;
      }
      paramLinkedList = (bgg)paramString2.next();
      locala = new a();
      if (!Util.isNullOrNil(paramString1)) {
        break label200;
      }
    }
    label200:
    for (int i = 2;; i = 3)
    {
      locala.type = i;
      locala.appId = paramLinkedList.hik;
      locala.text = paramLinkedList.LPZ;
      locala.description = paramLinkedList.KHk;
      locala.actionType = paramLinkedList.KWb;
      locala.xWn = paramLinkedList.LPS;
      this.iAd.add(locala);
      break label80;
      locala.text = this.context.getString(2131761338);
      break;
    }
    label206:
    notifyDataSetChanged();
    AppMethodBeat.o(42384);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(42382);
    int i = this.iAd.size();
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
    Object localObject = OB(paramInt);
    if (paramView == null)
    {
      paramView = View.inflate(this.context, 2131494947, null);
      paramViewGroup = new b((byte)0);
      paramViewGroup.hbb = ((TextView)paramView.findViewById(2131302079));
      paramViewGroup.xWo = ((ViewGroup)paramViewGroup.hbb.getParent());
      paramViewGroup.xWp = ((TextView)paramView.findViewById(2131302078));
      paramViewGroup.xWq = ((TextView)paramView.findViewById(2131302076));
      paramViewGroup.xWr = ((ViewGroup)paramViewGroup.xWp.getParent());
      paramViewGroup.xWs = ((TextView)paramView.findViewById(2131302077));
      paramViewGroup.xWt = ((ViewGroup)paramViewGroup.xWs.getParent().getParent());
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
      paramViewGroup.xWo.setVisibility(0);
      paramViewGroup.xWr.setVisibility(8);
      paramViewGroup.xWt.setVisibility(8);
      paramViewGroup.xWo.setOnClickListener(null);
      paramViewGroup.hbb.setText(((a)localObject).text);
      continue;
      paramViewGroup.xWo.setVisibility(8);
      paramViewGroup.xWr.setVisibility(0);
      paramViewGroup.xWt.setVisibility(8);
      paramViewGroup.xWp.setText(((a)localObject).text);
      paramViewGroup.xWq.setText(((a)localObject).description);
      continue;
      paramViewGroup.xWo.setVisibility(8);
      paramViewGroup.xWr.setVisibility(8);
      paramViewGroup.xWt.setVisibility(0);
      paramInt = this.context.getResources().getColor(2131100904);
      paramViewGroup.xWs.setTextColor(paramInt);
      paramInt = this.context.getResources().getColor(2131100554);
      int i = ((a)localObject).text.indexOf(this.dDv);
      if (i >= 0)
      {
        localObject = new SpannableString(((a)localObject).text);
        ((Spannable)localObject).setSpan(new ForegroundColorSpan(paramInt), i, this.dDv.length() + i, 33);
        paramViewGroup.xWs.setText((CharSequence)localObject);
      }
      else
      {
        paramViewGroup.xWs.setText(((a)localObject).text);
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
    public String xWn;
  }
  
  static final class b
  {
    TextView hbb;
    ViewGroup xWo;
    TextView xWp;
    TextView xWq;
    ViewGroup xWr;
    TextView xWs;
    ViewGroup xWt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.s
 * JD-Core Version:    0.7.0.1
 */