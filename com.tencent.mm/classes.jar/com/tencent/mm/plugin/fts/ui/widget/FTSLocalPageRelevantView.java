package com.tencent.mm.plugin.fts.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bvm;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FTSLocalPageRelevantView
  extends LinearLayout
  implements View.OnClickListener
{
  public String hng;
  public LinearLayout jja;
  private FTSLocalPageRelevantView.b nbd;
  public List<bvm> nbe;
  public String query;
  
  public FTSLocalPageRelevantView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(62138);
    this.nbd = null;
    this.query = null;
    this.hng = null;
    this.nbe = null;
    post(new FTSLocalPageRelevantView.1(this));
    AppMethodBeat.o(62138);
  }
  
  public FTSLocalPageRelevantView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.nbd = null;
    this.query = null;
    this.hng = null;
    this.nbe = null;
  }
  
  public FTSLocalPageRelevantView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.nbd = null;
    this.query = null;
    this.hng = null;
    this.nbe = null;
  }
  
  public static List<bvm> bX(List<bvm> paramList)
  {
    AppMethodBeat.i(62141);
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bvm localbvm = (bvm)paramList.next();
      if (!bo.isNullOrNil(localbvm.xJd)) {
        localLinkedList.add(localbvm);
      }
    }
    AppMethodBeat.o(62141);
    return localLinkedList;
  }
  
  public final void b(List<bvm> paramList, LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(62140);
    paramLinearLayout.removeAllViews();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (bvm)localIterator.next();
      if (localObject != null)
      {
        View localView = LayoutInflater.from(paramLinearLayout.getContext()).inflate(2130969682, paramLinearLayout, false);
        TextView localTextView = (TextView)localView.findViewById(2131820946);
        localView.setOnClickListener(new FTSLocalPageRelevantView.2(this));
        localTextView.setText(((bvm)localObject).xJd);
        int i = paramList.indexOf(localObject);
        if ((paramList != null) && (i < paramList.size())) {}
        for (localObject = new FTSLocalPageRelevantView.a(this, (bvm)paramList.get(i), i + 1);; localObject = null)
        {
          localView.setTag(localObject);
          paramLinearLayout.addView(localView);
          break;
        }
      }
    }
    AppMethodBeat.o(62140);
  }
  
  public String getQuery()
  {
    if (this.query != null) {
      return this.query;
    }
    return "";
  }
  
  public String getSearchId()
  {
    if (this.hng != null) {
      return this.hng;
    }
    return "";
  }
  
  public String getWordList()
  {
    AppMethodBeat.i(62142);
    Object localObject = new StringBuilder("");
    if (this.nbe != null)
    {
      Iterator localIterator = this.nbe.iterator();
      while (localIterator.hasNext())
      {
        bvm localbvm = (bvm)localIterator.next();
        if (((StringBuilder)localObject).length() > 0) {
          ((StringBuilder)localObject).append("|");
        }
        ((StringBuilder)localObject).append(localbvm.xJd);
      }
    }
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(62142);
    return localObject;
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(62139);
    if ((this.nbd != null) && (paramView.getTag() != null) && ((paramView.getTag() instanceof FTSLocalPageRelevantView.a)))
    {
      paramView = (FTSLocalPageRelevantView.a)paramView.getTag();
      this.nbd.a(paramView.nbg, this.hng, paramView.position);
    }
    AppMethodBeat.o(62139);
  }
  
  public void setOnRelevantClickListener(FTSLocalPageRelevantView.b paramb)
  {
    this.nbd = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.FTSLocalPageRelevantView
 * JD-Core Version:    0.7.0.1
 */