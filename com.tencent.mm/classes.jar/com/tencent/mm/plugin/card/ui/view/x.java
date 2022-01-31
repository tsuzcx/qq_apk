package com.tencent.mm.plugin.card.ui.view;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.sharecard.model.r;
import com.tencent.mm.plugin.card.ui.a.g;
import com.tencent.mm.plugin.card.ui.n;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;

public final class x
  extends i
{
  MMActivity hxN;
  private View iyA;
  private ImageView iyB;
  private TextView iyC;
  private TextView iyD;
  private ImageView iyE;
  View iyF;
  private LinearLayout iyG;
  private View.OnClickListener iyH = new x.1(this);
  private boolean iyy = false;
  private View iyz;
  
  public final void aCU()
  {
    this.iyz.setVisibility(8);
  }
  
  public final void initView()
  {
    this.iyz = findViewById(a.d.share_users_info_header_layout);
    this.iyA = findViewById(a.d.share_users_top_layout);
    this.iyB = ((ImageView)findViewById(a.d.share_user_avatar));
    this.iyC = ((TextView)findViewById(a.d.share_user_name));
    this.iyD = ((TextView)findViewById(a.d.share_user_tips));
    this.iyE = ((ImageView)findViewById(a.d.share_user_select_arrowhead));
    this.iyz.setVisibility(8);
    this.iyF = findViewById(a.d.share_users_bottom_layout);
    this.iyG = ((LinearLayout)findViewById(a.d.share_users_container_layout));
    this.iyF.setVisibility(8);
    this.hxN = this.iya.aBH();
  }
  
  public final void update()
  {
    Object localObject4 = this.iya.aBE();
    Object localObject3 = com.tencent.mm.plugin.card.sharecard.a.b.yr(((com.tencent.mm.plugin.card.base.b)localObject4).azC());
    Object localObject1 = this.iya.aBJ();
    Object localObject2;
    Object localObject5;
    Object localObject6;
    label349:
    int i;
    if (((g)localObject1).aCD())
    {
      this.iyz.setVisibility(0);
      if (com.tencent.mm.plugin.card.sharecard.a.b.yq(((com.tencent.mm.plugin.card.base.b)localObject4).azC()) > 1) {
        this.iyA.setOnClickListener(this.iya.aBI());
      }
      for (;;)
      {
        localObject4 = this.iya.aBE();
        if (!this.iya.aBF()) {
          break;
        }
        this.iyB.setVisibility(8);
        this.iyC.setVisibility(8);
        this.iyD.setVisibility(0);
        this.iyE.setImageResource(a.c.card_select_arrow_up);
        this.iyD.setText(this.hxN.getString(a.g.card_share_card_select_tips));
        if (!this.iya.aBF()) {
          break label879;
        }
        this.iyF.setVisibility(0);
        if ((this.iyG.getChildCount() != 0) || (localObject3 == null)) {
          break label749;
        }
        localObject1 = (LayoutInflater)this.hxN.getSystemService("layout_inflater");
        localObject2 = ((ArrayList)localObject3).iterator();
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label736;
          }
          localObject3 = (r)((Iterator)localObject2).next();
          localObject4 = ((LayoutInflater)localObject1).inflate(a.e.share_user_info_item, this.iyG, false);
          Object localObject7 = (ImageView)((View)localObject4).findViewById(a.d.user_avatar_img);
          localObject5 = (TextView)((View)localObject4).findViewById(a.d.user_name);
          localObject6 = (TextView)((View)localObject4).findViewById(a.d.share_count);
          if (!TextUtils.isEmpty(((r)localObject3).ipb))
          {
            com.tencent.mm.pluginsdk.ui.a.b.a((ImageView)localObject7, ((r)localObject3).ipb);
            localObject7 = l.yU(((r)localObject3).ipb);
            if (TextUtils.isEmpty((CharSequence)localObject7)) {
              break;
            }
            ((TextView)localObject5).setText(j.e(this.hxN, (CharSequence)localObject7, this.hxN.getResources().getDimensionPixelOffset(com.tencent.mm.plugin.card.a.b.SmallestTextSize)));
          }
          ((TextView)localObject6).setText("x " + ((r)localObject3).share_count);
          ((View)localObject4).setTag(localObject3);
          ((View)localObject4).setOnClickListener(this.iyH);
          localObject5 = (ImageView)((View)localObject4).findViewById(a.d.user_avatar_select);
          localObject6 = (ImageView)((View)localObject4).findViewById(a.d.user_avatar_mask);
          if (!((r)localObject3).ipd) {
            break label719;
          }
          ((ImageView)localObject5).setVisibility(0);
          ((ImageView)localObject6).setVisibility(0);
          label437:
          this.iyG.addView((View)localObject4);
        }
        this.iyE.setVisibility(8);
        this.iyF.setVisibility(8);
        this.iyG.removeAllViews();
        this.iya.aBG();
      }
      this.iyB.setVisibility(0);
      this.iyC.setVisibility(0);
      this.iyD.setVisibility(8);
      if (com.tencent.mm.plugin.card.sharecard.a.b.yq(((com.tencent.mm.plugin.card.base.b)localObject4).azC()) <= 1)
      {
        this.iyE.setVisibility(8);
        label534:
        if ((localObject3 == null) || (((ArrayList)localObject3).size() <= 0)) {
          break label1063;
        }
        i = 0;
        label549:
        if (i >= ((ArrayList)localObject3).size()) {
          break label1063;
        }
        localObject1 = (r)((ArrayList)localObject3).get(i);
        if (!((r)localObject1).ipd) {
          break label701;
        }
      }
    }
    label1058:
    label1063:
    for (localObject1 = ((r)localObject1).ipb;; localObject1 = "")
    {
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = localObject1;
        if (!TextUtils.isEmpty(((com.tencent.mm.plugin.card.base.b)localObject4).azD())) {
          localObject2 = ((com.tencent.mm.plugin.card.base.b)localObject4).azD();
        }
      }
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break;
      }
      com.tencent.mm.pluginsdk.ui.a.b.a(this.iyB, (String)localObject2);
      localObject1 = this.hxN.getString(a.g.card_share_card_users, new Object[] { l.yU((String)localObject2) });
      this.iyC.setText(j.e(this.hxN, (CharSequence)localObject1, this.hxN.getResources().getDimensionPixelOffset(com.tencent.mm.plugin.card.a.b.NormalTextSize)));
      break;
      this.iyE.setVisibility(0);
      this.iyE.setImageResource(a.c.card_select_arrow_down);
      break label534;
      label701:
      i += 1;
      break label549;
      ((TextView)localObject5).setText("");
      break label349;
      label719:
      ((ImageView)localObject5).setVisibility(8);
      ((ImageView)localObject6).setVisibility(8);
      break label437;
      label736:
      this.iyG.invalidate();
      this.iyy = true;
      label748:
      return;
      label749:
      i = 0;
      if (i < this.iyG.getChildCount())
      {
        localObject2 = this.iyG.getChildAt(i);
        if ((localObject3 == null) || (((ArrayList)localObject3).size() < this.iyG.getChildCount())) {
          break label1058;
        }
      }
      for (localObject1 = (r)((ArrayList)localObject3).get(i);; localObject1 = null)
      {
        localObject4 = (ImageView)((View)localObject2).findViewById(a.d.user_avatar_select);
        localObject2 = (ImageView)((View)localObject2).findViewById(a.d.user_avatar_mask);
        if ((localObject1 != null) && (((r)localObject1).ipd))
        {
          ((ImageView)localObject4).setVisibility(0);
          ((ImageView)localObject2).setVisibility(0);
        }
        for (;;)
        {
          i += 1;
          break;
          ((ImageView)localObject4).setVisibility(8);
          ((ImageView)localObject2).setVisibility(8);
        }
        this.iyG.invalidate();
        break;
        label879:
        this.iyF.setVisibility(8);
        this.iyG.removeAllViews();
        break;
        if (((g)localObject1).aCD()) {
          break label748;
        }
        this.iyz.setVisibility(0);
        this.iyB.setVisibility(0);
        this.iyC.setVisibility(0);
        this.iyD.setVisibility(8);
        this.iyE.setVisibility(8);
        localObject2 = "";
        localObject1 = localObject2;
        if (TextUtils.isEmpty(""))
        {
          localObject1 = localObject2;
          if (!TextUtils.isEmpty(((com.tencent.mm.plugin.card.base.b)localObject4).azD())) {
            localObject1 = ((com.tencent.mm.plugin.card.base.b)localObject4).azD();
          }
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          com.tencent.mm.pluginsdk.ui.a.b.a(this.iyB, (String)localObject1);
          localObject1 = this.hxN.getString(a.g.card_share_card_users, new Object[] { l.yU((String)localObject1) });
          this.iyC.setText(j.e(this.hxN, (CharSequence)localObject1, this.hxN.getResources().getDimensionPixelOffset(com.tencent.mm.plugin.card.a.b.NormalTextSize)));
        }
        this.iyy = true;
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.x
 * JD-Core Version:    0.7.0.1
 */