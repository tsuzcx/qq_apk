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
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.g.a.cx;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.MMTabView;

public class EmojiStoreV2TabView
  extends RelativeLayout
{
  private int lrK;
  private int lrL;
  private Bitmap lrM;
  private LinearLayout lrN;
  private ImageView lrO;
  private MMTabView lrP;
  private MMTabView lrQ;
  private EmojiStoreV2TabView.a lrR;
  protected View.OnClickListener lrS;
  c<cx> lrT;
  private Matrix mMatrix;
  
  public EmojiStoreV2TabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(53803);
    this.lrL = 0;
    this.mMatrix = new Matrix();
    this.lrS = new EmojiStoreV2TabView.1(this);
    this.lrT = new EmojiStoreV2TabView.2(this);
    init();
    AppMethodBeat.o(53803);
  }
  
  public EmojiStoreV2TabView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(53802);
    this.lrL = 0;
    this.mMatrix = new Matrix();
    this.lrS = new EmojiStoreV2TabView.1(this);
    this.lrT = new EmojiStoreV2TabView.2(this);
    init();
    AppMethodBeat.o(53802);
  }
  
  private void bns()
  {
    AppMethodBeat.i(53806);
    this.lrN = new LinearLayout(getContext());
    this.lrN.setBackgroundResource(2131690709);
    this.lrN.setId(2131820597);
    this.lrN.setOrientation(0);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    addView(this.lrN, localLayoutParams);
    AppMethodBeat.o(53806);
  }
  
  private void bnt()
  {
    AppMethodBeat.i(53807);
    this.lrO = new ImageView(getContext());
    this.lrO.setImageMatrix(this.mMatrix);
    this.lrO.setScaleType(ImageView.ScaleType.MATRIX);
    this.lrO.setId(2131820598);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, a.fromDPToPix(getContext(), 3));
    localLayoutParams.addRule(8, 2131820597);
    addView(this.lrO, localLayoutParams);
    AppMethodBeat.o(53807);
  }
  
  private void bnu()
  {
    AppMethodBeat.i(53808);
    this.lrP = ux(0);
    if (i.getEmojiStorageMgr().dxv()) {
      this.lrP.setText(2131299208);
    }
    for (;;)
    {
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(2131428762));
      localLayoutParams.weight = 1.0F;
      this.lrN.addView(this.lrP, localLayoutParams);
      AppMethodBeat.o(53808);
      return;
      this.lrP.setText(2131299207);
    }
  }
  
  private void bnv()
  {
    AppMethodBeat.i(53809);
    this.lrQ = ux(1);
    this.lrQ.setText(2131299215);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(2131428762));
    localLayoutParams.weight = 1.0F;
    this.lrN.addView(this.lrQ, localLayoutParams);
    AppMethodBeat.o(53809);
  }
  
  private void init()
  {
    AppMethodBeat.i(53805);
    bns();
    bnt();
    bnu();
    bnv();
    AppMethodBeat.o(53805);
  }
  
  private MMTabView ux(int paramInt)
  {
    AppMethodBeat.i(53810);
    MMTabView localMMTabView = new MMTabView(getContext(), paramInt);
    localMMTabView.setTag(Integer.valueOf(paramInt));
    localMMTabView.setOnClickListener(this.lrS);
    AppMethodBeat.o(53810);
    return localMMTabView;
  }
  
  public final void gQ(boolean paramBoolean)
  {
    AppMethodBeat.i(53814);
    if (this.lrQ != null) {
      this.lrQ.qs(paramBoolean);
    }
    AppMethodBeat.o(53814);
  }
  
  public int getCurentIndex()
  {
    return this.lrL;
  }
  
  public final void k(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(53811);
    this.mMatrix.setTranslate(this.lrK * (paramInt + paramFloat), 0.0F);
    this.lrO.setImageMatrix(this.mMatrix);
    AppMethodBeat.o(53811);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(53804);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.lrK = ((paramInt3 - paramInt1) / 2);
    paramInt2 = this.lrK;
    if (((this.lrM == null) || (this.lrM.getWidth() != paramInt2)) && (paramInt2 > 0)) {
      if (this.lrM != null) {
        break label164;
      }
    }
    label164:
    for (paramInt1 = -1;; paramInt1 = this.lrM.getWidth())
    {
      ab.w("MicroMsg.emoji.EmojiStoreV2TabView", "sharp width changed, from %d to %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.lrM = Bitmap.createBitmap(paramInt2, a.fromDPToPix(getContext(), 3), Bitmap.Config.ARGB_8888);
      new Canvas(this.lrM).drawColor(getResources().getColor(2131690701));
      k(this.lrL, 0.0F);
      this.lrO.setImageBitmap(this.lrM);
      setTo(this.lrL);
      AppMethodBeat.o(53804);
      return;
    }
  }
  
  public void setOnTabClickListener(EmojiStoreV2TabView.a parama)
  {
    this.lrR = parama;
  }
  
  public void setPersonTabUnReadCount(String paramString)
  {
    AppMethodBeat.i(53813);
    if (this.lrQ != null) {
      this.lrQ.setUnread(paramString);
    }
    AppMethodBeat.o(53813);
  }
  
  public void setTo(int paramInt)
  {
    AppMethodBeat.i(53812);
    this.lrL = paramInt;
    MMTabView localMMTabView = this.lrP;
    if (this.lrL == 0)
    {
      localColorStateList = getResources().getColorStateList(2131690701);
      localMMTabView.setTextColor(localColorStateList);
      localMMTabView = this.lrQ;
      if (this.lrL != 1) {
        break label89;
      }
    }
    label89:
    for (ColorStateList localColorStateList = getResources().getColorStateList(2131690701);; localColorStateList = getResources().getColorStateList(2131690759))
    {
      localMMTabView.setTextColor(localColorStateList);
      AppMethodBeat.o(53812);
      return;
      localColorStateList = getResources().getColorStateList(2131690759);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2TabView
 * JD-Core Version:    0.7.0.1
 */