package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.as.o;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.g.b;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;

public class GameLibraryCategoriesView
  extends LinearLayout
  implements View.OnClickListener
{
  private int kQh;
  private LinearLayout kjd;
  private int lcu;
  private int lcv;
  private Context mContext;
  
  public GameLibraryCategoriesView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
  }
  
  public void onClick(View paramView)
  {
    if (!(paramView.getTag() instanceof GameLibraryCategoriesView.a)) {
      return;
    }
    paramView = (GameLibraryCategoriesView.a)paramView.getTag();
    int i = 7;
    if (!bk.bl(paramView.lcy)) {
      c.an(this.mContext, paramView.lcy);
    }
    for (;;)
    {
      b.a(this.mContext, 11, paramView.lcw + 100, paramView.position, i, this.kQh, null);
      return;
      Intent localIntent = new Intent(this.mContext, GameCategoryUI.class);
      localIntent.putExtra("extra_type", 1);
      localIntent.putExtra("extra_category_id", paramView.lcw);
      localIntent.putExtra("extra_category_name", paramView.lcx);
      localIntent.putExtra("game_report_from_scene", paramView.lcw + 100);
      this.mContext.startActivity(localIntent);
      i = 6;
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.kjd = ((LinearLayout)findViewById(g.e.game_library_categories_container));
    int i = ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay().getWidth();
    this.lcu = (i * 100 / 750);
    this.lcv = ((i - this.lcu * 6) / 14);
    this.kjd.setPadding(this.lcv, com.tencent.mm.cb.a.fromDPToPix(this.mContext, 12), this.lcv, com.tencent.mm.cb.a.fromDPToPix(this.mContext, 12));
  }
  
  public void setData(LinkedList<GameLibraryCategoriesView.a> paramLinkedList)
  {
    if ((paramLinkedList == null) || (paramLinkedList.size() == 0))
    {
      y.e("MicroMsg.GameLibraryCategoriesView", "No categories");
      setVisibility(8);
    }
    for (;;)
    {
      return;
      setVisibility(0);
      this.kjd.removeAllViews();
      paramLinkedList = paramLinkedList.iterator();
      while (paramLinkedList.hasNext())
      {
        Object localObject1 = (GameLibraryCategoriesView.a)paramLinkedList.next();
        LinearLayout localLinearLayout = new LinearLayout(this.mContext);
        localLinearLayout.setOrientation(1);
        Object localObject2 = new ImageView(this.mContext);
        Object localObject3 = ImageView.ScaleType.MATRIX;
        ((ImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_XY);
        localObject3 = o.ON();
        String str = ((GameLibraryCategoriesView.a)localObject1).fJY;
        c.a locala = new c.a();
        locala.ere = true;
        ((com.tencent.mm.as.a.a)localObject3).a(str, (ImageView)localObject2, locala.OV());
        localLinearLayout.addView((View)localObject2, this.lcu, this.lcu);
        localObject2 = new TextView(this.mContext);
        ((TextView)localObject2).setText(((GameLibraryCategoriesView.a)localObject1).lcx);
        ((TextView)localObject2).setTextSize(1, 14.0F);
        ((TextView)localObject2).setTextColor(getResources().getColor(g.b.hint_text_color));
        ((TextView)localObject2).setSingleLine(true);
        ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
        ((TextView)localObject2).setGravity(17);
        ((TextView)localObject2).setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        ((TextView)localObject2).setPadding(0, com.tencent.mm.cb.a.fromDPToPix(this.mContext, 6), 0, 0);
        localLinearLayout.addView((View)localObject2);
        localLinearLayout.setTag(localObject1);
        localLinearLayout.setOnClickListener(this);
        localObject1 = new LinearLayout.LayoutParams(-1, -2);
        ((LinearLayout.LayoutParams)localObject1).setMargins(this.lcv, 0, this.lcv, 0);
        this.kjd.addView(localLinearLayout, (ViewGroup.LayoutParams)localObject1);
      }
    }
  }
  
  public void setSourceScene(int paramInt)
  {
    this.kQh = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameLibraryCategoriesView
 * JD-Core Version:    0.7.0.1
 */