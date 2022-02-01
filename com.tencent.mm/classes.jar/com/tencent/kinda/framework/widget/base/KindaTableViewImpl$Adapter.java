package com.tencent.kinda.framework.widget.base;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import com.tencent.kinda.gen.KTableViewCellManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
import junit.framework.Assert;

class KindaTableViewImpl$Adapter
  extends BaseAdapter
{
  private KindaTableViewImpl$Adapter(KindaTableViewImpl paramKindaTableViewImpl) {}
  
  public int getCount()
  {
    AppMethodBeat.i(199491);
    int i = KindaTableViewImpl.access$300(this.this$0).size();
    AppMethodBeat.o(199491);
    return i;
  }
  
  public KTableViewCellManager getItem(int paramInt)
  {
    AppMethodBeat.i(199492);
    KTableViewCellManager localKTableViewCellManager = (KTableViewCellManager)KindaTableViewImpl.access$300(this.this$0).get(paramInt);
    AppMethodBeat.o(199492);
    return localKTableViewCellManager;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(199493);
    ad.v("MicroMsg.KindaTableViewImplV2", "get view for: %s", new Object[] { Integer.valueOf(paramInt) });
    paramView = ((KTableViewCellManager)KindaTableViewImpl.access$300(this.this$0).get(paramInt)).getView();
    Assert.assertTrue("kViewLayout must be MMKViewLayout!", paramView instanceof MMKViewLayout);
    KindaTableViewImpl.access$400(this.this$0).put(Integer.valueOf(paramInt), new WeakReference(((MMKViewLayout)paramView).getView()));
    ((MMKViewLayout)paramView).getView().setTag("test_position_".concat(String.valueOf(paramInt)));
    paramView = (ViewGroup)((MMKViewLayout)paramView).getView();
    if (paramView.getParent() != null) {
      ((ViewGroup)paramView.getParent()).removeView(paramView);
    }
    paramViewGroup = new FrameLayout(this.this$0.mContext);
    paramViewGroup.addView(paramView);
    AppMethodBeat.o(199493);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.KindaTableViewImpl.Adapter
 * JD-Core Version:    0.7.0.1
 */