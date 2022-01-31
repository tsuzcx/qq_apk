package com.tencent.mm.plugin.card.ui.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.plugin.card.a.a;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.ui.a.g;
import com.tencent.mm.plugin.card.ui.n;
import com.tencent.mm.protocal.c.mg;
import com.tencent.mm.ui.MMActivity;

public final class d
  extends i
{
  private TextView ipN;
  private View ixP;
  private TextView ixQ;
  private TextView ixR;
  
  public final void aCU()
  {
    this.ixP.setVisibility(8);
  }
  
  public final void initView()
  {
    this.ixP = findViewById(a.d.advertise_layout);
    this.ixQ = ((TextView)findViewById(a.d.advertise_text));
    this.ipN = ((TextView)findViewById(a.d.share_detail_tv));
    this.ixR = ((TextView)findViewById(a.d.card_private_setting_tv));
    this.ixQ.setOnClickListener(this.iya.aBI());
    this.ixP.setVisibility(8);
  }
  
  public final void update()
  {
    b localb = this.iya.aBE();
    Object localObject1 = this.iya.aBH();
    this.ixP.setVisibility(0);
    if (!TextUtils.isEmpty(localb.azx().sIB))
    {
      this.ixQ.setVisibility(0);
      this.ixQ.setText(localb.azx().sIB);
      if ((localb.aze()) || ((localb.azd()) && (localb.azg()))) {
        this.ixQ.setTextColor(((MMActivity)localObject1).getResources().getColor(a.a.white));
      }
    }
    Object localObject2;
    for (;;)
    {
      localObject2 = this.ixP.findViewById(a.d.card_setting_layout_container);
      if (!this.iya.aBJ().aCR()) {
        break label528;
      }
      ((View)localObject2).setVisibility(0);
      this.ixR.setText(((MMActivity)localObject1).getString(a.g.card_share_card_private_setting));
      this.ixR.setTextColor(((MMActivity)localObject1).getResources().getColor(a.a.white));
      int i = ((MMActivity)localObject1).getResources().getDimensionPixelOffset(a.b.NormalPadding);
      localObject2 = (Button)this.ixP.findViewById(a.d.card_private_setting_btn);
      ShapeDrawable localShapeDrawable1 = l.b((Context)localObject1, ((MMActivity)localObject1).getResources().getColor(a.a.white), i);
      ShapeDrawable localShapeDrawable2 = l.cx(((MMActivity)localObject1).getResources().getColor(a.a.white), i);
      StateListDrawable localStateListDrawable = new StateListDrawable();
      localStateListDrawable.addState(new int[] { 16842919 }, localShapeDrawable2);
      localStateListDrawable.addState(new int[0], localShapeDrawable1);
      ((Button)localObject2).setBackgroundDrawable(localStateListDrawable);
      i = l.yR(localb.azx().color);
      int j = ((MMActivity)localObject1).getResources().getColor(a.a.white);
      ((Button)localObject2).setTextColor(new ColorStateList(new int[][] { { 16842919, 16842910 }, new int[0] }, new int[] { i, j }));
      ((Button)localObject2).setOnClickListener(this.iya.aBI());
      localObject1 = this.ixP.findViewById(a.d.middle_divider);
      localObject2 = this.ixP.findViewById(a.d.card_hongbao_layout);
      if (localb.azx().sIP != 1) {
        break;
      }
      ((View)localObject1).setVisibility(0);
      ((View)localObject2).setVisibility(0);
      return;
      if ((localb.azd()) && (localb.azf()))
      {
        this.ixQ.setTextColor(((MMActivity)localObject1).getResources().getColor(a.a.card_advertise_text_color));
        this.ixP.setBackgroundColor(((MMActivity)localObject1).getResources().getColor(a.a.card_bg_color));
      }
      else
      {
        this.ixQ.setTextColor(((MMActivity)localObject1).getResources().getColor(a.a.white));
        continue;
        this.ixQ.setVisibility(8);
      }
    }
    ((View)localObject1).setVisibility(8);
    ((View)localObject2).setVisibility(8);
    return;
    label528:
    ((View)localObject2).setVisibility(8);
  }
  
  public final void yH(String paramString)
  {
    this.ixR.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.d
 * JD-Core Version:    0.7.0.1
 */