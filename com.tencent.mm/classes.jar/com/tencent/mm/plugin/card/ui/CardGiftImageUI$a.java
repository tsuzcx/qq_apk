package com.tencent.mm.plugin.card.ui;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.sdk.platformtools.ac;
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
    AppMethodBeat.i(113327);
    Object localObject = u.FE(CardGiftImageUI.b(this.odb));
    if (localObject == null)
    {
      ac.w("MicroMsg.CardGiftImageUI", "get image fail");
      if (paramView != null)
      {
        localObject = paramView;
        if (!(paramView instanceof MultiTouchImageView)) {}
      }
      else
      {
        localObject = View.inflate(paramViewGroup.getContext(), 2131493308, null);
        ((ImageView)((View)localObject).findViewById(2131300943)).setImageResource(2131690066);
        ((View)localObject).setLayoutParams(new Gallery.LayoutParams(-1, -1));
      }
      AppMethodBeat.o(113327);
      return localObject;
    }
    paramViewGroup = paramViewGroup.getContext();
    if ((paramView == null) || (!(paramView instanceof MultiTouchImageView))) {
      paramView = new MultiTouchImageView(paramViewGroup, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight(), (byte)0);
    }
    for (;;)
    {
      paramView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
      paramView.setImageBitmap((Bitmap)localObject);
      paramView.setMaxZoomDoubleTab(true);
      AppMethodBeat.o(113327);
      return paramView;
      paramView = (MultiTouchImageView)paramView;
      paramView.cF(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardGiftImageUI.a
 * JD-Core Version:    0.7.0.1
 */