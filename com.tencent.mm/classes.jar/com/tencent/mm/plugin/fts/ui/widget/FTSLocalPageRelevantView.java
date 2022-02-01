package com.tencent.mm.plugin.fts.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cqn;
import java.util.Iterator;
import java.util.List;

public class FTSLocalPageRelevantView
  extends LinearLayout
  implements View.OnClickListener
{
  private String jKB = null;
  private String query = null;
  private b sGf = null;
  private List<cqn> sGg = null;
  
  public FTSLocalPageRelevantView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public FTSLocalPageRelevantView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
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
    if (this.jKB != null) {
      return this.jKB;
    }
    return "";
  }
  
  public String getWordList()
  {
    AppMethodBeat.i(112265);
    Object localObject = new StringBuilder("");
    if (this.sGg != null)
    {
      Iterator localIterator = this.sGg.iterator();
      while (localIterator.hasNext())
      {
        cqn localcqn = (cqn)localIterator.next();
        if (((StringBuilder)localObject).length() > 0) {
          ((StringBuilder)localObject).append("|");
        }
        ((StringBuilder)localObject).append(localcqn.FtK);
      }
    }
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(112265);
    return localObject;
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(112264);
    if ((this.sGf != null) && (paramView.getTag() != null) && ((paramView.getTag() instanceof a))) {
      paramView.getTag();
    }
    AppMethodBeat.o(112264);
  }
  
  public void setOnRelevantClickListener(b paramb)
  {
    this.sGf = paramb;
  }
  
  final class a {}
  
  public static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.FTSLocalPageRelevantView
 * JD-Core Version:    0.7.0.1
 */