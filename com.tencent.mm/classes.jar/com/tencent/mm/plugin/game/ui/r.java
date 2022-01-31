package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.game.f.b;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.f.e.a.a;
import com.tencent.mm.plugin.game.g.b;
import com.tencent.mm.plugin.game.g.c;
import com.tencent.mm.plugin.game.g.d;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.plugin.game.g.h;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class r
  extends BaseAdapter
{
  boolean bGq = false;
  Context context;
  ArrayList<r.b> iBu;
  int kQn = 0;
  int lcn = 0;
  boolean leG = false;
  int leH = 0;
  int leI = 0;
  int leJ = 0;
  int leK = 0;
  private int leL;
  boolean leM = false;
  boolean leN = false;
  private ArrayList<r.d> leO;
  
  public r(Context paramContext)
  {
    this.context = paramContext;
    this.iBu = null;
    this.leL = paramContext.getResources().getColor(g.b.gc_search_recmd_keyword_match);
  }
  
  private void a(TextView paramTextView, String paramString)
  {
    if (!bk.bl(paramString))
    {
      if (this.leO == null) {
        this.leO = new ArrayList();
      }
      for (;;)
      {
        paramString = new StringBuilder(paramString);
        localObject = new r.d(this, (byte)0);
        for (int i = paramString.indexOf("<em>"); i >= 0; i = paramString.indexOf("<em>"))
        {
          ((r.d)localObject).start = i;
          paramString.delete(i, i + 4);
          i = paramString.indexOf("</em>");
          if (i < 0) {
            break;
          }
          ((r.d)localObject).end = i;
          paramString.delete(i, i + 5);
          this.leO.add(localObject);
        }
        this.leO.clear();
      }
      paramString = new SpannableString(paramString.toString());
      Object localObject = this.leO.iterator();
      while (((Iterator)localObject).hasNext())
      {
        r.d locald = (r.d)((Iterator)localObject).next();
        if (locald.start < locald.end) {
          paramString.setSpan(new ForegroundColorSpan(this.leL), locald.start, locald.end, 33);
        }
      }
      paramTextView.setText(paramString);
      paramTextView.setVisibility(0);
      return;
    }
    paramTextView.setVisibility(8);
  }
  
  public final int getCount()
  {
    if (this.iBu == null) {
      return 0;
    }
    return this.iBu.size();
  }
  
  public final Object getItem(int paramInt)
  {
    return this.iBu.get(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getItemViewType(int paramInt)
  {
    return ((r.b)getItem(paramInt)).type;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    r.b localb = (r.b)getItem(paramInt);
    Object localObject1;
    label78:
    Object localObject2;
    if (paramView == null)
    {
      localObject1 = new r.a((byte)0);
      paramView = this.context;
      switch (localb.type)
      {
      case 4: 
      default: 
        paramInt = 0;
        localObject2 = View.inflate(paramView, paramInt, null);
        ((r.a)localObject1).contentView = ((View)localObject2).findViewById(g.e.game_item_content_layout);
        ((r.a)localObject1).leS = ((ImageView)((View)localObject2).findViewById(g.e.game_item_icon));
        ((r.a)localObject1).leT = ((TextView)((View)localObject2).findViewById(g.e.game_item_name));
        ((r.a)localObject1).leU = ((TextView)((View)localObject2).findViewById(g.e.game_item_brief));
        ((r.a)localObject1).leV = ((TextView)((View)localObject2).findViewById(g.e.game_item_desc));
        ((r.a)localObject1).leW = ((TextView)((View)localObject2).findViewById(g.e.game_item_play));
        ((r.a)localObject1).leX = ((View)localObject2).findViewById(g.e.game_item_divide_view);
        ((r.a)localObject1).leY = ((TextView)((View)localObject2).findViewById(g.e.source_name));
        ((r.a)localObject1).leZ = ((TextView)((View)localObject2).findViewById(g.e.create_time));
        ((View)localObject2).setTag(localObject1);
        paramViewGroup = (ViewGroup)localObject1;
        paramView = (View)localObject2;
        if (((r.a)localObject1).leT != null)
        {
          paramViewGroup = (ViewGroup)localObject1;
          paramView = (View)localObject2;
          if (((r.a)localObject1).leV != null)
          {
            paramView = ((r.a)localObject1).leT;
            paramViewGroup = ((r.a)localObject1).leV;
            paramView.getViewTreeObserver().addOnGlobalLayoutListener(new r.1(this, paramView, paramViewGroup));
            paramView = (View)localObject2;
            paramViewGroup = (ViewGroup)localObject1;
          }
        }
        label294:
        switch (localb.type)
        {
        }
        break;
      }
    }
    for (;;)
    {
      switch (localb.type)
      {
      case 4: 
      default: 
        return paramView;
        paramInt = g.f.game_search_game_item_layout;
        break label78;
        paramInt = g.f.game_search_web_item_layout;
        break label78;
        paramInt = g.f.game_search_title_item_layout;
        break label78;
        paramInt = g.f.game_search_more_item_layout;
        break label78;
        paramInt = g.f.game_search_nores_item_layout;
        break label78;
        paramInt = g.f.game_search_similar_game_item_layout;
        break label78;
        paramViewGroup = (r.a)paramView.getTag();
        break label294;
        if (!bk.bl(localb.iconUrl))
        {
          localObject1 = new e.a.a();
          ((e.a.a)localObject1).erd = false;
          ((e.a.a)localObject1).erf = false;
          e.baw().a(paramViewGroup.leS, localb.iconUrl, ((e.a.a)localObject1).bax());
        }
        a(paramViewGroup.leT, localb.name);
        a(paramViewGroup.leU, localb.lfa);
        a(paramViewGroup.leV, localb.fGK);
        continue;
        if (!bk.bl(localb.iconUrl))
        {
          localObject1 = new e.a.a();
          ((e.a.a)localObject1).erd = false;
          ((e.a.a)localObject1).erf = false;
          ((e.a.a)localObject1).lgz = true;
          e.baw().a(paramViewGroup.leS, localb.iconUrl, ((e.a.a)localObject1).bax());
          paramViewGroup.leS.setVisibility(0);
          label599:
          a(paramViewGroup.leT, localb.name);
          a(paramViewGroup.leV, localb.fGK);
          if (bk.bl(localb.dXh)) {
            break label719;
          }
          paramViewGroup.leY.setText(j.b(this.context, localb.dXh));
          paramViewGroup.leY.setVisibility(0);
        }
        for (;;)
        {
          if (localb.createTime <= 0L) {
            break label731;
          }
          paramViewGroup.leZ.setText(b.g(this.context, localb.createTime * 1000L));
          paramViewGroup.leZ.setVisibility(0);
          break;
          paramViewGroup.leS.setVisibility(8);
          break label599;
          label719:
          paramViewGroup.leY.setVisibility(8);
        }
        label731:
        paramViewGroup.leZ.setVisibility(8);
        continue;
        if (!bk.bl(localb.iconUrl))
        {
          localObject1 = new e.a.a();
          ((e.a.a)localObject1).erd = false;
          ((e.a.a)localObject1).erf = false;
          e.baw().a(paramViewGroup.leS, localb.iconUrl, ((e.a.a)localObject1).bax());
        }
        a(paramViewGroup.leT, localb.name);
        a(paramViewGroup.leU, localb.lfa);
        a(paramViewGroup.leV, localb.fGK);
        localObject1 = paramViewGroup.leW;
        localObject2 = localb.lfd;
        StringBuilder localStringBuilder = new StringBuilder();
        if (!bk.dk((List)localObject2))
        {
          int i = ((LinkedList)localObject2).size();
          paramInt = 0;
          while (paramInt < i - 1)
          {
            localStringBuilder.append((String)((LinkedList)localObject2).get(paramInt) + "\n");
            paramInt += 1;
          }
          localStringBuilder.append((String)((LinkedList)localObject2).get(i - 1));
          ((TextView)localObject1).setVisibility(0);
          ((TextView)localObject1).setText(localStringBuilder.toString());
        }
        else
        {
          ((TextView)localObject1).setVisibility(8);
          continue;
          paramViewGroup.leV.setText(localb.name);
          continue;
          paramViewGroup.leS.setImageResource(g.h.search_more_button_icon);
          paramViewGroup.leT.setText(localb.name);
        }
        break;
      }
    }
    if (localb.lfh) {
      paramViewGroup.contentView.setBackgroundResource(g.d.comm_list_item_selector_no_divider);
    }
    for (;;)
    {
      paramInt = this.context.getResources().getDimensionPixelSize(g.c.SearchNormalPadding);
      paramViewGroup.contentView.setPadding(0, paramInt, 0, paramInt);
      return paramView;
      paramViewGroup.contentView.setBackgroundResource(g.d.comm_list_item_selector);
    }
    if (localb.lfg)
    {
      paramViewGroup.leX.setVisibility(8);
      return paramView;
    }
    paramViewGroup.leX.setVisibility(0);
    return paramView;
  }
  
  public final int getViewTypeCount()
  {
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.r
 * JD-Core Version:    0.7.0.1
 */