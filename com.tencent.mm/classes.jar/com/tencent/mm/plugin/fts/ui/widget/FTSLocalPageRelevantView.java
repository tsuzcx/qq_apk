package com.tencent.mm.plugin.fts.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.fts.ui.n.d;
import com.tencent.mm.plugin.fts.ui.n.e;
import com.tencent.mm.protocal.c.bma;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FTSLocalPageRelevantView
  extends LinearLayout
  implements View.OnClickListener
{
  public String bVk = null;
  public String fTF = null;
  public LinearLayout fXV;
  private FTSLocalPageRelevantView.b kEF = null;
  public List<bma> kEG = null;
  
  public FTSLocalPageRelevantView(Context paramContext)
  {
    super(paramContext);
    post(new FTSLocalPageRelevantView.1(this));
  }
  
  public FTSLocalPageRelevantView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public FTSLocalPageRelevantView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public static List<bma> bC(List<bma> paramList)
  {
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bma localbma = (bma)paramList.next();
      if (!bk.bl(localbma.tFy)) {
        localLinkedList.add(localbma);
      }
    }
    return localLinkedList;
  }
  
  public final void a(List<bma> paramList, LinearLayout paramLinearLayout)
  {
    paramLinearLayout.removeAllViews();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (bma)localIterator.next();
      if (localObject != null)
      {
        View localView = LayoutInflater.from(paramLinearLayout.getContext()).inflate(n.e.fts_websearch_relevant_item, paramLinearLayout, false);
        TextView localTextView = (TextView)localView.findViewById(n.d.content);
        localView.setOnClickListener(new FTSLocalPageRelevantView.2(this));
        localTextView.setText(((bma)localObject).tFy);
        int i = paramList.indexOf(localObject);
        if ((paramList != null) && (i < paramList.size())) {}
        for (localObject = new FTSLocalPageRelevantView.a(this, (bma)paramList.get(i), i + 1);; localObject = null)
        {
          localView.setTag(localObject);
          paramLinearLayout.addView(localView);
          break;
        }
      }
    }
  }
  
  public String getQuery()
  {
    if (this.bVk != null) {
      return this.bVk;
    }
    return "";
  }
  
  public String getSearchId()
  {
    if (this.fTF != null) {
      return this.fTF;
    }
    return "";
  }
  
  public String getWordList()
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    if (this.kEG != null)
    {
      Iterator localIterator = this.kEG.iterator();
      while (localIterator.hasNext())
      {
        bma localbma = (bma)localIterator.next();
        if (localStringBuilder.length() > 0) {
          localStringBuilder.append("|");
        }
        localStringBuilder.append(localbma.tFy);
      }
    }
    return localStringBuilder.toString();
  }
  
  public void onClick(View paramView)
  {
    if ((this.kEF != null) && (paramView.getTag() != null) && ((paramView.getTag() instanceof FTSLocalPageRelevantView.a)))
    {
      paramView = (FTSLocalPageRelevantView.a)paramView.getTag();
      this.kEF.a(paramView.kEI, this.fTF, paramView.position);
    }
  }
  
  public void setOnRelevantClickListener(FTSLocalPageRelevantView.b paramb)
  {
    this.kEF = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.FTSLocalPageRelevantView
 * JD-Core Version:    0.7.0.1
 */