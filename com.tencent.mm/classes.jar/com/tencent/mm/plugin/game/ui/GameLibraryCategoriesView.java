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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.o;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;

public class GameLibraryCategoriesView
  extends LinearLayout
  implements View.OnClickListener
{
  private Context mContext;
  private LinearLayout mDJ;
  private int nAp;
  private int nAq;
  private int nok;
  
  public GameLibraryCategoriesView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(112012);
    if (!(paramView.getTag() instanceof GameLibraryCategoriesView.a))
    {
      AppMethodBeat.o(112012);
      return;
    }
    paramView = (GameLibraryCategoriesView.a)paramView.getTag();
    int i = 7;
    if (!bo.isNullOrNil(paramView.nAt)) {
      com.tencent.mm.plugin.game.f.c.ax(this.mContext, paramView.nAt);
    }
    for (;;)
    {
      com.tencent.mm.game.report.c.a(this.mContext, 11, paramView.nAr + 100, paramView.position, i, this.nok, null);
      AppMethodBeat.o(112012);
      return;
      Intent localIntent = new Intent(this.mContext, GameCategoryUI.class);
      localIntent.putExtra("extra_type", 1);
      localIntent.putExtra("extra_category_id", paramView.nAr);
      localIntent.putExtra("extra_category_name", paramView.nAs);
      localIntent.putExtra("game_report_from_scene", paramView.nAr + 100);
      this.mContext.startActivity(localIntent);
      i = 6;
    }
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(112010);
    super.onFinishInflate();
    this.mDJ = ((LinearLayout)findViewById(2131824675));
    int i = ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay().getWidth();
    this.nAp = (i * 100 / 750);
    this.nAq = ((i - this.nAp * 6) / 14);
    this.mDJ.setPadding(this.nAq, com.tencent.mm.cb.a.fromDPToPix(this.mContext, 12), this.nAq, com.tencent.mm.cb.a.fromDPToPix(this.mContext, 12));
    AppMethodBeat.o(112010);
  }
  
  public void setData(LinkedList<GameLibraryCategoriesView.a> paramLinkedList)
  {
    AppMethodBeat.i(112011);
    if ((paramLinkedList == null) || (paramLinkedList.size() == 0))
    {
      ab.e("MicroMsg.GameLibraryCategoriesView", "No categories");
      setVisibility(8);
      AppMethodBeat.o(112011);
      return;
    }
    setVisibility(0);
    this.mDJ.removeAllViews();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      Object localObject1 = (GameLibraryCategoriesView.a)paramLinkedList.next();
      LinearLayout localLinearLayout = new LinearLayout(this.mContext);
      localLinearLayout.setOrientation(1);
      Object localObject2 = new ImageView(this.mContext);
      Object localObject3 = ImageView.ScaleType.MATRIX;
      ((ImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_XY);
      localObject3 = o.ahG();
      String str = ((GameLibraryCategoriesView.a)localObject1).hcN;
      c.a locala = new c.a();
      locala.eNL = true;
      ((com.tencent.mm.at.a.a)localObject3).a(str, (ImageView)localObject2, locala.ahY());
      localLinearLayout.addView((View)localObject2, this.nAp, this.nAp);
      localObject2 = new TextView(this.mContext);
      ((TextView)localObject2).setText(((GameLibraryCategoriesView.a)localObject1).nAs);
      ((TextView)localObject2).setTextSize(1, 14.0F);
      ((TextView)localObject2).setTextColor(getResources().getColor(2131690168));
      ((TextView)localObject2).setSingleLine(true);
      ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
      ((TextView)localObject2).setGravity(17);
      ((TextView)localObject2).setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
      ((TextView)localObject2).setPadding(0, com.tencent.mm.cb.a.fromDPToPix(this.mContext, 6), 0, 0);
      localLinearLayout.addView((View)localObject2);
      localLinearLayout.setTag(localObject1);
      localLinearLayout.setOnClickListener(this);
      localObject1 = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject1).setMargins(this.nAq, 0, this.nAq, 0);
      this.mDJ.addView(localLinearLayout, (ViewGroup.LayoutParams)localObject1);
    }
    AppMethodBeat.o(112011);
  }
  
  public void setSourceScene(int paramInt)
  {
    this.nok = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameLibraryCategoriesView
 * JD-Core Version:    0.7.0.1
 */