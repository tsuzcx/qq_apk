package com.tencent.mm.plugin.appbrand.ui.recommend;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RatingBar;
import android.widget.TextView;
import com.tencent.mm.modelappbrand.a.a;
import com.tencent.mm.modelappbrand.a.f;
import com.tencent.mm.plugin.appbrand.y.d;
import com.tencent.mm.plugin.appbrand.y.e;
import com.tencent.mm.plugin.appbrand.y.h;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.protocal.c.bjt;
import com.tencent.mm.protocal.c.mm;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public final class b
  extends RecyclerView.a
{
  private LayoutInflater Lu;
  Context context;
  private final Map<String, String> hhX = new HashMap();
  LinkedList<bjt> hkd = new LinkedList();
  private Vector<TextView> hke = new Vector();
  boolean hkf = false;
  b.a hkg;
  
  public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject = paramViewGroup.getContext();
    if (this.Lu == null) {
      this.Lu = LayoutInflater.from((Context)localObject);
    }
    localObject = this.Lu.inflate(y.h.app_brand_launcher_recommend_item, null);
    if (this.context == null) {
      this.context = paramViewGroup.getContext();
    }
    return new b.b(this, (View)localObject);
  }
  
  public final void a(RecyclerView.v paramv, int paramInt)
  {
    bjt localbjt = mu(paramInt);
    if (localbjt == null) {}
    label279:
    label1185:
    label1195:
    for (;;)
    {
      return;
      b.b localb = (b.b)paramv;
      b.b.a(localb).setText(localbjt.nickname);
      if (!TextUtils.isEmpty(localbjt.tDy))
      {
        b.b.b(localb).setText(localbjt.tDy);
        b.b.b(localb).setVisibility(0);
        if (TextUtils.isEmpty(localbjt.tDB)) {
          break label279;
        }
        b.b.c(localb).setText(localbjt.tDB);
        b.b.c(localb).setVisibility(0);
        label98:
        a(b.b.d(localb), localbjt, false);
        if (!this.hkf) {
          break label302;
        }
        b.b.f(localb).setVisibility(8);
        label127:
        if (localbjt.tDz <= 0.0D) {
          break label1172;
        }
        b.b.g(localb).setVisibility(0);
        paramv = String.format("%.1f", new Object[] { Double.valueOf(localbjt.tDz) });
        b.b.h(localb).setText(this.context.getString(y.j.app_brand_recommend_score_text, new Object[] { paramv }));
        b.b.i(localb).setNumStars(5);
        b.b.i(localb).setRating((float)localbjt.tDz);
        b.b.i(localb).setStepSize(0.1F);
        label226:
        if (paramInt != getItemCount() - 1) {
          break label1185;
        }
        b.b.e(localb).setVisibility(8);
      }
      for (;;)
      {
        if (this.hkg == null) {
          break label1195;
        }
        this.hkg.a(paramInt, localbjt);
        return;
        b.b.b(localb).setVisibility(8);
        break;
        b.b.c(localb).setText("");
        b.b.c(localb).setVisibility(8);
        break label98;
        label302:
        if ((localbjt.tDA == null) || (localbjt.tDA.size() == 0))
        {
          b.b.f(localb).setVisibility(8);
          break label127;
        }
        if (b.b.f(localb).getVisibility() != 0) {
          b.b.f(localb).setVisibility(0);
        }
        int k = b.b.f(localb).getChildCount();
        int j = localbjt.tDA.size();
        Object localObject1;
        if (j > k)
        {
          i = 0;
          while (i < j - k)
          {
            paramv = null;
            if (!this.hke.isEmpty()) {
              paramv = (TextView)this.hke.remove(this.hke.size() - 1);
            }
            localObject1 = paramv;
            if (paramv == null)
            {
              localObject1 = new TextView(this.context);
              ((TextView)localObject1).setTextSize(2, 12.0F);
              ((TextView)localObject1).setTextColor(this.context.getResources().getColor(y.d.app_brand_recommend_item_category_item_text_color));
              ((TextView)localObject1).setEllipsize(TextUtils.TruncateAt.END);
              ((TextView)localObject1).setMaxLines(1);
              ((TextView)localObject1).setBackgroundColor(this.context.getResources().getColor(y.d.app_brand_recommend_item_category_item_bg));
              ((TextView)localObject1).setGravity(17);
            }
            paramv = new LinearLayout.LayoutParams(-1, -1);
            paramv.height = this.context.getResources().getDimensionPixelOffset(y.e.app_brand_recommend_item_category_item_height);
            paramv.weight = 1.0F;
            paramv.leftMargin = this.context.getResources().getDimensionPixelOffset(y.e.app_brand_recommend_item_category_item_margin);
            paramv.rightMargin = this.context.getResources().getDimensionPixelOffset(y.e.app_brand_recommend_item_category_item_margin);
            b.b.f(localb).addView((View)localObject1);
            i += 1;
          }
        }
        if (j < k)
        {
          i = 0;
          while (i < k - j)
          {
            paramv = (TextView)b.b.f(localb).getChildAt(k - 1 - i);
            b.b.f(localb).removeView(paramv);
            this.hke.add(paramv);
            i += 1;
          }
        }
        int i = 0;
        while (i < j)
        {
          paramv = (TextView)b.b.f(localb).getChildAt(i);
          localObject1 = (mm)localbjt.tDA.get(i);
          paramv.setText(((mm)localObject1).sJp);
          paramv.setTag(localObject1);
          k = this.context.getResources().getDimensionPixelOffset(y.e.app_brand_recommend_item_category_item_lr_padding);
          int m = this.context.getResources().getDimensionPixelOffset(y.e.app_brand_recommend_item_category_item_tb_padding);
          paramv.setPadding(k, m, k, m);
          paramv.setGravity(17);
          paramv.setOnClickListener(new b.1(this));
          k = this.context.getResources().getDimensionPixelSize(y.e.app_brand_recommend_item_category_item_radius);
          localObject1 = this.context;
          m = this.context.getResources().getColor(y.d.app_brand_recommend_item_category_item_bg);
          int n = ((Context)localObject1).getResources().getDimensionPixelSize(y.e.OneDPPadding);
          localObject1 = new float[8];
          localObject1[0] = k;
          localObject1[1] = k;
          localObject1[2] = k;
          localObject1[3] = k;
          localObject1[4] = k;
          localObject1[5] = k;
          localObject1[6] = k;
          localObject1[7] = k;
          Object localObject2 = new ShapeDrawable(new RoundRectShape((float[])localObject1, new RectF(n, n, n, n), (float[])localObject1));
          localObject1 = ((ShapeDrawable)localObject2).getPaint();
          ((Paint)localObject1).setColor(m);
          ((Paint)localObject1).setStrokeWidth(n);
          m = this.context.getResources().getColor(y.d.app_brand_recommend_item_category_item_bg);
          Object localObject3 = new ShapeDrawable(new RoundRectShape(new float[] { k, k, k, k, k, k, k, k }, null, null));
          ((ShapeDrawable)localObject3).getPaint().setColor(m);
          localObject1 = new StateListDrawable();
          ((StateListDrawable)localObject1).addState(new int[] { 16842919 }, (Drawable)localObject2);
          ((StateListDrawable)localObject1).addState(new int[0], (Drawable)localObject3);
          k = this.context.getResources().getColor(y.d.app_brand_recommend_item_category_item_text_color);
          m = this.context.getResources().getColor(y.d.app_brand_recommend_item_category_item_text_color);
          localObject2 = new int[] { 16842919, 16842910 };
          localObject3 = new int[0];
          paramv.setBackgroundDrawable((Drawable)localObject1);
          paramv.setTextColor(new ColorStateList(new int[][] { localObject2, localObject3 }, new int[] { k, m }));
          i += 1;
        }
        break label127;
        b.b.g(localb).setVisibility(8);
        break label226;
        b.b.e(localb).setVisibility(0);
      }
    }
  }
  
  public final void a(RecyclerView.v paramv, int paramInt, List paramList)
  {
    super.a(paramv, paramInt, paramList);
  }
  
  final void a(ImageView paramImageView, bjt parambjt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (!bk.bl(parambjt.mTc))
      {
        parambjt = (String)this.hhX.get(parambjt.mTc);
        if (!bk.bl(parambjt))
        {
          parambjt = com.tencent.mm.modelappbrand.a.b.JD().jG(parambjt);
          if ((parambjt != null) && (!parambjt.isRecycled())) {
            paramImageView.setImageBitmap(parambjt);
          }
          return;
        }
      }
      paramImageView.setImageDrawable(a.JC());
      return;
    }
    paramImageView = com.tencent.mm.modelappbrand.a.b.JD().a(paramImageView, parambjt.mTc, a.JC(), f.eaL);
    this.hhX.put(parambjt.mTc, paramImageView);
  }
  
  public final int getItemCount()
  {
    return this.hkd.size();
  }
  
  public final long getItemId(int paramInt)
  {
    bjt localbjt = mu(paramInt);
    if (localbjt == null) {
      return 0L;
    }
    return (localbjt.nickname + localbjt.tDy).hashCode();
  }
  
  public final int getItemViewType(int paramInt)
  {
    return 1;
  }
  
  public final boolean isEmpty()
  {
    return (this.hkd == null) || (this.hkd.size() == 0);
  }
  
  public final bjt mu(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > this.hkd.size())) {
      return null;
    }
    return (bjt)this.hkd.get(paramInt);
  }
  
  public final void setData(LinkedList<bjt> paramLinkedList)
  {
    this.hkd.clear();
    this.hkd.addAll(paramLinkedList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.b
 * JD-Core Version:    0.7.0.1
 */