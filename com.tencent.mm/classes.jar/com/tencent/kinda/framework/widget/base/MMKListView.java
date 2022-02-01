package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.widget.ListView;
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
    AppMethodBeat.i(19081);
    this.adapter = new MMListViewAdapter(this.mContext, this.mListViewCallback);
    ((ListView)getView()).setAdapter(this.adapter);
    AppMethodBeat.o(19081);
  }
  
  public void addFooter(KView paramKView) {}
  
  public void addHeader(KView paramKView) {}
  
  public ListView createView(Context paramContext)
  {
    AppMethodBeat.i(19080);
    paramContext = new ListView(paramContext);
    AppMethodBeat.o(19080);
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
    AppMethodBeat.i(19082);
    this.mListViewCallback = paramKListViewCallback;
    binding();
    AppMethodBeat.o(19082);
  }
  
  public void setOnScrollCallback(KListViewOnScrollCallback paramKListViewOnScrollCallback) {}
  
  public void setShowScrollBar(boolean paramBoolean) {}
  
  public void setVertical(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMKListView
 * JD-Core Version:    0.7.0.1
 */