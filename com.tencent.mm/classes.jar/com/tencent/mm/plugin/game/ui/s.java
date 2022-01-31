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
import com.tencent.mm.plugin.game.g.b;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.plugin.game.g.i;
import com.tencent.mm.protocal.c.zw;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.Iterator;
import java.util.LinkedList;

public final class s
  extends BaseAdapter
{
  private String bGm = "";
  private Context context;
  private LinkedList<s.a> dTx = new LinkedList();
  
  public s(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final void a(String paramString1, String paramString2, LinkedList<zw> paramLinkedList)
  {
    if (bk.dk(paramLinkedList)) {
      return;
    }
    this.bGm = paramString1;
    this.dTx.clear();
    s.a locala;
    if (bk.bl(paramString1))
    {
      locala = new s.a();
      locala.type = 1;
      if (!bk.bl(paramString2))
      {
        locala.text = paramString2;
        this.dTx.add(locala);
      }
    }
    else
    {
      paramString2 = paramLinkedList.iterator();
      label70:
      if (!paramString2.hasNext()) {
        break label197;
      }
      paramLinkedList = (zw)paramString2.next();
      locala = new s.a();
      if (!bk.bl(paramString1)) {
        break label191;
      }
    }
    label191:
    for (int i = 2;; i = 3)
    {
      locala.type = i;
      locala.appId = paramLinkedList.kRX;
      locala.text = paramLinkedList.sZg;
      locala.description = paramLinkedList.sxZ;
      locala.actionType = paramLinkedList.sYX;
      locala.lfl = paramLinkedList.sYY;
      this.dTx.add(locala);
      break label70;
      locala.text = this.context.getString(g.i.game_search_recmd_title);
      break;
    }
    label197:
    notifyDataSetChanged();
  }
  
  public final int getCount()
  {
    return this.dTx.size();
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = sn(paramInt);
    if (paramView == null)
    {
      paramView = View.inflate(this.context, g.f.game_search_recmd_item, null);
      paramViewGroup = new s.b((byte)0);
      paramViewGroup.fcy = ((TextView)paramView.findViewById(g.e.game_search_recmd_title));
      paramViewGroup.lfm = ((ViewGroup)paramViewGroup.fcy.getParent());
      paramViewGroup.lfn = ((TextView)paramView.findViewById(g.e.game_search_recmd_keyword_hot));
      paramViewGroup.lfo = ((TextView)paramView.findViewById(g.e.game_search_description));
      paramViewGroup.lfp = ((ViewGroup)paramViewGroup.lfn.getParent());
      paramViewGroup.lfq = ((TextView)paramView.findViewById(g.e.game_search_recmd_keyword));
      paramViewGroup.lfr = ((ViewGroup)paramViewGroup.lfq.getParent().getParent());
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      switch (((s.a)localObject).type)
      {
      default: 
        return paramView;
        paramViewGroup = (s.b)paramView.getTag();
      }
    }
    paramViewGroup.lfm.setVisibility(0);
    paramViewGroup.lfp.setVisibility(8);
    paramViewGroup.lfr.setVisibility(8);
    paramViewGroup.lfm.setOnClickListener(null);
    paramViewGroup.fcy.setText(((s.a)localObject).text);
    return paramView;
    paramViewGroup.lfm.setVisibility(8);
    paramViewGroup.lfp.setVisibility(0);
    paramViewGroup.lfr.setVisibility(8);
    paramViewGroup.lfn.setText(((s.a)localObject).text);
    paramViewGroup.lfo.setText(((s.a)localObject).description);
    return paramView;
    paramViewGroup.lfm.setVisibility(8);
    paramViewGroup.lfp.setVisibility(8);
    paramViewGroup.lfr.setVisibility(0);
    paramInt = this.context.getResources().getColor(g.b.normal_text_color);
    paramViewGroup.lfq.setTextColor(paramInt);
    paramInt = this.context.getResources().getColor(g.b.gc_search_recmd_keyword_match);
    int i = ((s.a)localObject).text.indexOf(this.bGm);
    if (i >= 0)
    {
      localObject = new SpannableString(((s.a)localObject).text);
      ((Spannable)localObject).setSpan(new ForegroundColorSpan(paramInt), i, this.bGm.length() + i, 33);
      paramViewGroup.lfq.setText((CharSequence)localObject);
      return paramView;
    }
    paramViewGroup.lfq.setText(((s.a)localObject).text);
    return paramView;
  }
  
  public final s.a sn(int paramInt)
  {
    return (s.a)this.dTx.get(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.s
 * JD-Core Version:    0.7.0.1
 */