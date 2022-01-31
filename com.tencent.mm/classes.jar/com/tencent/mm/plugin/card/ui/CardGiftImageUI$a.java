package com.tencent.mm.plugin.card.ui;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.f;
import com.tencent.mm.sdk.platformtools.y;
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
    Object localObject = x.pg(CardGiftImageUI.b(this.itG));
    if (localObject == null)
    {
      y.w("MicroMsg.CardGiftImageUI", "get image fail");
      if (paramView != null)
      {
        localObject = paramView;
        if (!(paramView instanceof MultiTouchImageView)) {}
      }
      else
      {
        localObject = View.inflate(paramViewGroup.getContext(), a.e.card_image_ui_item, null);
        ((ImageView)((View)localObject).findViewById(a.d.image_iv)).setImageResource(a.f.download_image_icon);
        ((View)localObject).setLayoutParams(new Gallery.LayoutParams(-1, -1));
      }
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
      return paramView;
      paramView = (MultiTouchImageView)paramView;
      paramView.fs(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardGiftImageUI.a
 * JD-Core Version:    0.7.0.1
 */