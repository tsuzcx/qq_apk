package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.cb.a;
import com.tencent.mm.h.a.cu;
import com.tencent.mm.plugin.emoji.f.b;
import com.tencent.mm.plugin.emoji.f.c;
import com.tencent.mm.plugin.emoji.f.e;
import com.tencent.mm.plugin.emoji.f.h;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.MMTabView;

public class EmojiStoreV2TabView
  extends RelativeLayout
{
  private int jiT;
  private int jiU = 0;
  private Bitmap jiV;
  private LinearLayout jiW;
  private ImageView jiX;
  private MMTabView jiY;
  private MMTabView jiZ;
  private EmojiStoreV2TabView.a jja;
  protected View.OnClickListener jjb = new EmojiStoreV2TabView.1(this);
  c<cu> jjc = new EmojiStoreV2TabView.2(this);
  private Matrix mMatrix = new Matrix();
  
  public EmojiStoreV2TabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public EmojiStoreV2TabView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    this.jiW = new LinearLayout(getContext());
    this.jiW.setBackgroundResource(f.b.white);
    this.jiW.setId(f.e.emoji_store_tab_container);
    this.jiW.setOrientation(0);
    Object localObject = new RelativeLayout.LayoutParams(-1, -2);
    addView(this.jiW, (ViewGroup.LayoutParams)localObject);
    this.jiX = new ImageView(getContext());
    this.jiX.setImageMatrix(this.mMatrix);
    this.jiX.setScaleType(ImageView.ScaleType.MATRIX);
    this.jiX.setId(f.e.emoji_store_tab_shape);
    localObject = new RelativeLayout.LayoutParams(-1, a.fromDPToPix(getContext(), 3));
    ((RelativeLayout.LayoutParams)localObject).addRule(8, f.e.emoji_store_tab_container);
    addView(this.jiX, (ViewGroup.LayoutParams)localObject);
    this.jiY = qb(0);
    if (i.getEmojiStorageMgr().cuS()) {
      this.jiY.setText(f.h.emoji_store_main_tab_friends);
    }
    for (;;)
    {
      localObject = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(f.c.topTabbarHeight));
      ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
      this.jiW.addView(this.jiY, (ViewGroup.LayoutParams)localObject);
      this.jiZ = qb(1);
      this.jiZ.setText(f.h.emoji_store_person_tab_more);
      localObject = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(f.c.topTabbarHeight));
      ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
      this.jiW.addView(this.jiZ, (ViewGroup.LayoutParams)localObject);
      return;
      this.jiY.setText(f.h.emoji_store_main_tab);
    }
  }
  
  private MMTabView qb(int paramInt)
  {
    MMTabView localMMTabView = new MMTabView(getContext(), paramInt);
    localMMTabView.setTag(Integer.valueOf(paramInt));
    localMMTabView.setOnClickListener(this.jjb);
    return localMMTabView;
  }
  
  public final void fo(boolean paramBoolean)
  {
    if (this.jiZ != null) {
      this.jiZ.mV(paramBoolean);
    }
  }
  
  public int getCurentIndex()
  {
    return this.jiU;
  }
  
  public final void i(int paramInt, float paramFloat)
  {
    this.mMatrix.setTranslate(this.jiT * (paramInt + paramFloat), 0.0F);
    this.jiX.setImageMatrix(this.mMatrix);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.jiT = ((paramInt3 - paramInt1) / 2);
    paramInt2 = this.jiT;
    if ((this.jiV == null) || (this.jiV.getWidth() != paramInt2)) {
      if (this.jiV != null) {
        break label150;
      }
    }
    label150:
    for (paramInt1 = -1;; paramInt1 = this.jiV.getWidth())
    {
      y.w("MicroMsg.emoji.EmojiStoreV2TabView", "sharp width changed, from %d to %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.jiV = Bitmap.createBitmap(paramInt2, a.fromDPToPix(getContext(), 3), Bitmap.Config.ARGB_8888);
      new Canvas(this.jiV).drawColor(getResources().getColor(f.b.wechat_green));
      i(this.jiU, 0.0F);
      this.jiX.setImageBitmap(this.jiV);
      setTo(this.jiU);
      return;
    }
  }
  
  public void setOnTabClickListener(EmojiStoreV2TabView.a parama)
  {
    this.jja = parama;
  }
  
  public void setPersonTabUnReadCount(String paramString)
  {
    if (this.jiZ != null) {
      this.jiZ.setUnread(paramString);
    }
  }
  
  public void setTo(int paramInt)
  {
    this.jiU = paramInt;
    MMTabView localMMTabView = this.jiY;
    if (this.jiU == 0)
    {
      localColorStateList = getResources().getColorStateList(f.b.wechat_green);
      localMMTabView.setTextColor(localColorStateList);
      localMMTabView = this.jiZ;
      if (this.jiU != 1) {
        break label77;
      }
    }
    label77:
    for (ColorStateList localColorStateList = getResources().getColorStateList(f.b.wechat_green);; localColorStateList = getResources().getColorStateList(f.b.launcher_tab_text_selector))
    {
      localMMTabView.setTextColor(localColorStateList);
      return;
      localColorStateList = getResources().getColorStateList(f.b.launcher_tab_text_selector);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2TabView
 * JD-Core Version:    0.7.0.1
 */