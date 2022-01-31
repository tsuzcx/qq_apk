package com.tencent.mm.plugin.mall.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet_core.model.mall.a;
import com.tencent.mm.plugin.wallet_core.model.mall.b;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

public class BannerActView
  extends LinearLayout
{
  private TextView lYA = (TextView)LayoutInflater.from(getContext()).inflate(a.g.banner_activity_view, this, true).findViewById(a.f.mall_banner_wording);
  private List<a> lYy;
  private r lYz;
  
  public BannerActView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOnClickListener(new BannerActView.1(this));
  }
  
  public void setActivityList(List<a> paramList)
  {
    this.lYy = paramList;
    if ((this.lYy == null) || (this.lYy.size() <= 0)) {
      y.i("MicroMsg.BannerActivityView", "func[setActivityList] actList null");
    }
    while (!b.cT(this.lYy))
    {
      setVisibility(8);
      return;
    }
    this.lYA.setText(((a)this.lYy.get(0)).qzt);
    setVisibility(0);
  }
  
  public void setData(r paramr)
  {
    this.lYz = paramr;
    if (this.lYz != null)
    {
      this.lYA.setText(this.lYz.field_bulletin_content);
      setVisibility(0);
      return;
    }
    setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.BannerActView
 * JD-Core Version:    0.7.0.1
 */