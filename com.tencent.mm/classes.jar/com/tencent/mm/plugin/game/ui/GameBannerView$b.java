package com.tencent.mm.plugin.game.ui;

import android.graphics.drawable.Drawable;
import android.support.v4.view.n;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

final class GameBannerView$b
  extends n
{
  private GameBannerView$b(GameBannerView paramGameBannerView) {}
  
  public final void a(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    int i = GameBannerView.b(this.kXl).size();
    paramViewGroup.removeView((View)paramObject);
    y.i("MicroMsg.GameBannerView", "destroyItem : new positon = %d, now position = %d", new Object[] { Integer.valueOf(paramInt % i), Integer.valueOf(paramInt) });
  }
  
  public final boolean a(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public final Object b(ViewGroup paramViewGroup, int paramInt)
  {
    int i = paramInt % GameBannerView.b(this.kXl).size();
    View localView = View.inflate(GameBannerView.d(this.kXl), g.f.game_banner_view_item, null);
    localView.setTag(GameBannerView.b(this.kXl).get(i));
    localView.setOnClickListener(this.kXl);
    ImageView localImageView = (ImageView)localView.findViewById(g.e.game_ad_header_item_image);
    String str = ((GameBannerView.a)GameBannerView.b(this.kXl).get(i)).eaA;
    Drawable localDrawable = localImageView.getDrawable();
    if ((localDrawable != null) && ((localDrawable instanceof j))) {
      ((j)localDrawable).setUrl(str);
    }
    try
    {
      for (;;)
      {
        paramViewGroup.addView(localView, 0);
        y.i("MicroMsg.GameBannerView", "instantiateItem : new positon = %d, now position = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
        return localView;
        localImageView.setImageDrawable(new j(str, (byte)0));
      }
    }
    catch (Exception paramViewGroup)
    {
      for (;;)
      {
        y.e("MicroMsg.GameBannerView", "add view failed, " + paramViewGroup.getMessage());
      }
    }
  }
  
  public final int getCount()
  {
    if (GameBannerView.b(this.kXl).size() <= 1) {
      return GameBannerView.b(this.kXl).size();
    }
    return GameBannerView.b(this.kXl).size() * 1000 * 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameBannerView.b
 * JD-Core Version:    0.7.0.1
 */