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
import com.tencent.mm.plugin.game.h.b;
import com.tencent.mm.plugin.game.h.e;
import com.tencent.mm.plugin.game.h.f;
import com.tencent.mm.plugin.game.h.i;
import com.tencent.mm.protocal.protobuf.cbf;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class s
  extends BaseAdapter
{
  private Context context;
  private String hAB;
  private LinkedList<a> nUC;
  
  public s(Context paramContext)
  {
    AppMethodBeat.i(42380);
    this.hAB = "";
    this.nUC = new LinkedList();
    this.context = paramContext;
    AppMethodBeat.o(42380);
  }
  
  public final a XP(int paramInt)
  {
    AppMethodBeat.i(42383);
    a locala = (a)this.nUC.get(paramInt);
    AppMethodBeat.o(42383);
    return locala;
  }
  
  public final void a(String paramString1, String paramString2, LinkedList<cbf> paramLinkedList)
  {
    AppMethodBeat.i(42384);
    if (Util.isNullOrNil(paramLinkedList))
    {
      AppMethodBeat.o(42384);
      return;
    }
    this.hAB = paramString1;
    this.nUC.clear();
    a locala;
    if (Util.isNullOrNil(paramString1))
    {
      locala = new a();
      locala.type = 1;
      if (!Util.isNullOrNil(paramString2))
      {
        locala.text = paramString2;
        this.nUC.add(locala);
      }
    }
    else
    {
      paramString2 = paramLinkedList.iterator();
      label80:
      if (!paramString2.hasNext()) {
        break label207;
      }
      paramLinkedList = (cbf)paramString2.next();
      locala = new a();
      if (!Util.isNullOrNil(paramString1)) {
        break label201;
      }
    }
    label201:
    for (int i = 2;; i = 3)
    {
      locala.type = i;
      locala.appId = paramLinkedList.muA;
      locala.text = paramLinkedList.aakv;
      locala.description = paramLinkedList.crB;
      locala.actionType = paramLinkedList.YVh;
      locala.IUL = paramLinkedList.aako;
      this.nUC.add(locala);
      break label80;
      locala.text = this.context.getString(h.i.HWw);
      break;
    }
    label207:
    notifyDataSetChanged();
    AppMethodBeat.o(42384);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(42382);
    int i = this.nUC.size();
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
    Object localObject = XP(paramInt);
    if (paramView == null)
    {
      paramView = View.inflate(this.context, h.f.Ial, null);
      paramViewGroup = new b((byte)0);
      paramViewGroup.mll = ((TextView)paramView.findViewById(h.e.HWw));
      paramViewGroup.IUM = ((ViewGroup)paramViewGroup.mll.getParent());
      paramViewGroup.IUN = ((TextView)paramView.findViewById(h.e.HWv));
      paramViewGroup.IUO = ((TextView)paramView.findViewById(h.e.HWt));
      paramViewGroup.IUP = ((ViewGroup)paramViewGroup.IUN.getParent());
      paramViewGroup.IUQ = ((TextView)paramView.findViewById(h.e.HWu));
      paramViewGroup.IUR = ((ViewGroup)paramViewGroup.IUQ.getParent().getParent());
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
      paramViewGroup.IUM.setVisibility(0);
      paramViewGroup.IUP.setVisibility(8);
      paramViewGroup.IUR.setVisibility(8);
      paramViewGroup.IUM.setOnClickListener(null);
      paramViewGroup.mll.setText(((a)localObject).text);
      continue;
      paramViewGroup.IUM.setVisibility(8);
      paramViewGroup.IUP.setVisibility(0);
      paramViewGroup.IUR.setVisibility(8);
      paramViewGroup.IUN.setText(((a)localObject).text);
      paramViewGroup.IUO.setText(((a)localObject).description);
      continue;
      paramViewGroup.IUM.setVisibility(8);
      paramViewGroup.IUP.setVisibility(8);
      paramViewGroup.IUR.setVisibility(0);
      paramInt = this.context.getResources().getColor(h.b.normal_text_color);
      paramViewGroup.IUQ.setTextColor(paramInt);
      paramInt = this.context.getResources().getColor(h.b.HST);
      int i = ((a)localObject).text.indexOf(this.hAB);
      if (i >= 0)
      {
        localObject = new SpannableString(((a)localObject).text);
        ((Spannable)localObject).setSpan(new ForegroundColorSpan(paramInt), i, this.hAB.length() + i, 33);
        paramViewGroup.IUQ.setText((CharSequence)localObject);
      }
      else
      {
        paramViewGroup.IUQ.setText(((a)localObject).text);
      }
    }
  }
  
  public static final class a
  {
    public String IUL;
    public int actionType;
    public String appId;
    public String description;
    public String text;
    public int type;
  }
  
  static final class b
  {
    ViewGroup IUM;
    TextView IUN;
    TextView IUO;
    ViewGroup IUP;
    TextView IUQ;
    ViewGroup IUR;
    TextView mll;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.s
 * JD-Core Version:    0.7.0.1
 */