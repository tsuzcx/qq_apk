package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.widget.ListView;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.KListView;
import com.tencent.kinda.gen.KListViewCallback;
import com.tencent.kinda.gen.KListViewOnScrollCallback;
import com.tencent.kinda.gen.KView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MMKListView
  extends MMKView<ListView>
  implements KListView
{
  private MMListViewAdapter adapter;
  private KListViewCallback mListViewCallback;
  
  private void binding()
  {
    AppMethodBeat.i(144925);
    this.adapter = new MMListViewAdapter(KindaContext.get(), this.mListViewCallback);
    ((ListView)getView()).setAdapter(this.adapter);
    AppMethodBeat.o(144925);
  }
  
  public void addFooter(KView paramKView) {}
  
  public void addHeader(KView paramKView) {}
  
  public ListView createView(Context paramContext)
  {
    AppMethodBeat.i(144924);
    paramContext = new ListView(paramContext);
    AppMethodBeat.o(144924);
    return paramContext;
  }
  
  public boolean getShowScrollBar()
  {
    return false;
  }
  
  public boolean getVertical()
  {
    return false;
  }
  
  public void setImpl(KListViewCallback paramKListViewCallback)
  {
    AppMethodBeat.i(144926);
    this.mListViewCallback = paramKListViewCallback;
    binding();
    AppMethodBeat.o(144926);
  }
  
  public void setOnScrollCallback(KListViewOnScrollCallback paramKListViewOnScrollCallback) {}
  
  public void setShowScrollBar(boolean paramBoolean) {}
  
  public void setVertical(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMKListView
 * JD-Core Version:    0.7.0.1
 */