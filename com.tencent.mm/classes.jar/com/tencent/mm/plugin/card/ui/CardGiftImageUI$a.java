package com.tencent.mm.plugin.card.ui;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.MultiTouchImageView;

final class CardGiftImageUI$a
  extends BaseAdapter
{
  private CardGiftImageUI$a(CardGiftImageUI paramCardGiftImageUI) {}
  
  public final int getCount()
  {
    return 1;
  }
  
  public final Object getItem(int paramInt)
  {
    return null;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(88402);
    Object localObject = x.wx(CardGiftImageUI.b(this.kuL));
    if (localObject == null)
    {
      ab.w("MicroMsg.CardGiftImageUI", "get image fail");
      if (paramView != null)
      {
        localObject = paramView;
        if (!(paramView instanceof MultiTouchImageView)) {}
      }
      else
      {
        localObject = View.inflate(paramViewGroup.getContext(), 2130968957, null);
        ((ImageView)((View)localObject).findViewById(2131822243)).setImageResource(2131231253);
        ((View)localObject).setLayoutParams(new Gallery.LayoutParams(-1, -1));
      }
      AppMethodBeat.o(88402);
      return localObject;
    }
    paramViewGroup = paramViewGroup.getContext();
    if ((paramView == null) || (!(paramView instanceof MultiTouchImageView))) {
      paramView = new MultiTouchImageView(paramViewGroup, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
    }
    for (;;)
    {
      paramView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
      paramView.setImageBitmap((Bitmap)localObject);
      paramView.setMaxZoomDoubleTab(true);
      AppMethodBeat.o(88402);
      return paramView;
      paramView = (MultiTouchImageView)paramView;
      paramView.cb(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardGiftImageUI.a
 * JD-Core Version:    0.7.0.1
 */