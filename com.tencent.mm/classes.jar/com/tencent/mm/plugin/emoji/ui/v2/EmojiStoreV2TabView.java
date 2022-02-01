package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Context;
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
import com.tencent.mm.cc.a;
import com.tencent.mm.g.a.dh;
import com.tencent.mm.plugin.emoji.model.d;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMTabView;

public class EmojiStoreV2TabView
  extends RelativeLayout
{
  private Matrix mMatrix;
  private int pPe;
  private int pPf;
  private Bitmap pPg;
  private LinearLayout pPh;
  private ImageView pPi;
  private MMTabView pPj;
  private MMTabView pPk;
  private EmojiStoreV2TabView.a pPl;
  protected View.OnClickListener pPm;
  c<dh> pPn;
  
  public EmojiStoreV2TabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(109375);
    this.pPf = 0;
    this.mMatrix = new Matrix();
    this.pPm = new EmojiStoreV2TabView.1(this);
    this.pPn = new c() {};
    init();
    AppMethodBeat.o(109375);
  }
  
  public EmojiStoreV2TabView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(109374);
    this.pPf = 0;
    this.mMatrix = new Matrix();
    this.pPm = new EmojiStoreV2TabView.1(this);
    this.pPn = new c() {};
    init();
    AppMethodBeat.o(109374);
  }
  
  private MMTabView Cg(int paramInt)
  {
    AppMethodBeat.i(109382);
    MMTabView localMMTabView = new MMTabView(getContext(), paramInt);
    localMMTabView.setTag(Integer.valueOf(paramInt));
    localMMTabView.setOnClickListener(this.pPm);
    AppMethodBeat.o(109382);
    return localMMTabView;
  }
  
  private void ciU()
  {
    AppMethodBeat.i(109378);
    this.pPh = new LinearLayout(getContext());
    this.pPh.setBackgroundResource(2131101179);
    this.pPh.setId(2131299446);
    this.pPh.setOrientation(0);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    addView(this.pPh, localLayoutParams);
    AppMethodBeat.o(109378);
  }
  
  private void ciV()
  {
    AppMethodBeat.i(109379);
    this.pPi = new ImageView(getContext());
    this.pPi.setImageMatrix(this.mMatrix);
    this.pPi.setScaleType(ImageView.ScaleType.MATRIX);
    this.pPi.setId(2131299447);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, a.fromDPToPix(getContext(), 3));
    localLayoutParams.addRule(8, 2131299446);
    addView(this.pPi, localLayoutParams);
    AppMethodBeat.o(109379);
  }
  
  private void ciW()
  {
    AppMethodBeat.i(109380);
    this.pPj = Cg(0);
    if (!bt.isNullOrNil(d.cgI().pEe)) {
      this.pPj.setText(d.cgI().pEe);
    }
    for (;;)
    {
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(2131166928));
      localLayoutParams.weight = 1.0F;
      this.pPh.addView(this.pPj, localLayoutParams);
      AppMethodBeat.o(109380);
      return;
      if (d.cgI().pEd) {
        this.pPj.setText(2131758334);
      } else {
        this.pPj.setText(2131758333);
      }
    }
  }
  
  private void ciX()
  {
    AppMethodBeat.i(109381);
    this.pPk = Cg(1);
    this.pPk.setText(2131758341);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(2131166928));
    localLayoutParams.weight = 1.0F;
    this.pPh.addView(this.pPk, localLayoutParams);
    AppMethodBeat.o(109381);
  }
  
  private void init()
  {
    AppMethodBeat.i(109377);
    ciU();
    ciV();
    ciW();
    ciX();
    AppMethodBeat.o(109377);
  }
  
  public int getCurentIndex()
  {
    return this.pPf;
  }
  
  public final void kB(boolean paramBoolean)
  {
    AppMethodBeat.i(109386);
    if (this.pPk != null) {
      this.pPk.xn(paramBoolean);
    }
    AppMethodBeat.o(109386);
  }
  
  public final void o(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(109383);
    this.mMatrix.setTranslate(this.pPe * (paramInt + paramFloat), 0.0F);
    this.pPi.setImageMatrix(this.mMatrix);
    AppMethodBeat.o(109383);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(109376);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.pPe = ((paramInt3 - paramInt1) / 2);
    paramInt2 = this.pPe;
    if (((this.pPg == null) || (this.pPg.getWidth() != paramInt2)) && (paramInt2 > 0)) {
      if (this.pPg != null) {
        break label166;
      }
    }
    label166:
    for (paramInt1 = -1;; paramInt1 = this.pPg.getWidth())
    {
      ad.w("MicroMsg.emoji.EmojiStoreV2TabView", "sharp width changed, from %d to %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.pPg = Bitmap.createBitmap(paramInt2, a.fromDPToPix(getContext(), 3), Bitmap.Config.ARGB_8888);
      new Canvas(this.pPg).drawColor(getResources().getColor(2131101171));
      o(this.pPf, 0.0F);
      this.pPi.setImageBitmap(this.pPg);
      setTo(this.pPf);
      AppMethodBeat.o(109376);
      return;
    }
  }
  
  public void setOnTabClickListener(EmojiStoreV2TabView.a parama)
  {
    this.pPl = parama;
  }
  
  public void setPersonTabUnReadCount(String paramString)
  {
    AppMethodBeat.i(109385);
    if (this.pPk != null) {
      this.pPk.setUnread(paramString);
    }
    AppMethodBeat.o(109385);
  }
  
  public void setTo(int paramInt)
  {
    AppMethodBeat.i(109384);
    this.pPf = paramInt;
    MMTabView localMMTabView = this.pPj;
    if (this.pPf == 0)
    {
      paramInt = getResources().getColor(2131101171);
      localMMTabView.setTextColor(paramInt);
      localMMTabView = this.pPk;
      if (this.pPf != 1) {
        break label92;
      }
    }
    label92:
    for (paramInt = getResources().getColor(2131101171);; paramInt = getContext().getResources().getColor(2131099732))
    {
      localMMTabView.setTextColor(paramInt);
      AppMethodBeat.o(109384);
      return;
      paramInt = getContext().getResources().getColor(2131099732);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2TabView
 * JD-Core Version:    0.7.0.1
 */