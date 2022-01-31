package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.kinda.gen.KListViewCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class MMListViewAdapter
  extends BaseAdapter
{
  private static final String TAG = "MicroMsg.MMListViewAdapter";
  private Context mContext;
  private KListViewCallback mListViewCallback;
  
  public MMListViewAdapter(Context paramContext, KListViewCallback paramKListViewCallback)
  {
    this.mContext = paramContext;
    this.mListViewCallback = paramKListViewCallback;
  }
  
  public int getCount()
  {
    AppMethodBeat.i(145118);
    int i = this.mListViewCallback.getCount();
    AppMethodBeat.o(145118);
    return i;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(145119);
    paramInt = this.mListViewCallback.getViewType(paramInt);
    AppMethodBeat.o(145119);
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = null;
    AppMethodBeat.i(145121);
    ab.i("MicroMsg.MMListViewAdapter", "getView %s %s", new Object[] { Integer.valueOf(paramInt), paramView });
    if (paramView != null) {}
    for (paramView = (MMKViewLayout)paramView.getTag();; paramView = null)
    {
      KListViewCallback localKListViewCallback = this.mListViewCallback;
      if (paramView == null) {
        paramView = paramViewGroup;
      }
      for (;;)
      {
        paramView = localKListViewCallback.fillData(paramInt, paramView);
        paramViewGroup = (MMKView)paramView;
        paramViewGroup.getView().setTag(paramView);
        paramView = paramViewGroup.getView();
        AppMethodBeat.o(145121);
        return paramView;
      }
    }
  }
  
  public int getViewTypeCount()
  {
    AppMethodBeat.i(145120);
    int i = this.mListViewCallback.getViewTypeCount();
    AppMethodBeat.o(145120);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMListViewAdapter
 * JD-Core Version:    0.7.0.1
 */