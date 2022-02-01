package com.tencent.mm.plugin.fts.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.protocal.protobuf.cvs;
import java.util.Iterator;
import java.util.List;

public class FTSLocalPageRelevantView
  extends LinearLayout
  implements View.OnClickListener
{
  private String keN = null;
  private String query = null;
  private b tCY = null;
  private List<cvs> tCZ = null;
  
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
    if (this.keN != null) {
      return this.keN;
    }
    return "";
  }
  
  public String getWordList()
  {
    AppMethodBeat.i(112265);
    Object localObject = new StringBuilder("");
    if (this.tCZ != null)
    {
      Iterator localIterator = this.tCZ.iterator();
      while (localIterator.hasNext())
      {
        cvs localcvs = (cvs)localIterator.next();
        if (((StringBuilder)localObject).length() > 0) {
          ((StringBuilder)localObject).append("|");
        }
        ((StringBuilder)localObject).append(localcvs.HdP);
      }
    }
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(112265);
    return localObject;
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(112264);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/fts/ui/widget/FTSLocalPageRelevantView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    if ((this.tCY != null) && (paramView.getTag() != null) && ((paramView.getTag() instanceof a))) {
      paramView.getTag();
    }
    a.a(this, "com/tencent/mm/plugin/fts/ui/widget/FTSLocalPageRelevantView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(112264);
  }
  
  public void setOnRelevantClickListener(b paramb)
  {
    this.tCY = paramb;
  }
  
  final class a {}
  
  public static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.FTSLocalPageRelevantView
 * JD-Core Version:    0.7.0.1
 */