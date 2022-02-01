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
import com.tencent.mm.cb.a;
import com.tencent.mm.g.a.di;
import com.tencent.mm.plugin.emoji.model.d;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMTabView;

public class EmojiStoreV2TabView
  extends RelativeLayout
{
  private Matrix mMatrix;
  private int pVJ;
  private int pVK;
  private Bitmap pVL;
  private LinearLayout pVM;
  private ImageView pVN;
  private MMTabView pVO;
  private MMTabView pVP;
  private EmojiStoreV2TabView.a pVQ;
  protected View.OnClickListener pVR;
  c<di> pVS;
  
  public EmojiStoreV2TabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(109375);
    this.pVK = 0;
    this.mMatrix = new Matrix();
    this.pVR = new EmojiStoreV2TabView.1(this);
    this.pVS = new c() {};
    init();
    AppMethodBeat.o(109375);
  }
  
  public EmojiStoreV2TabView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(109374);
    this.pVK = 0;
    this.mMatrix = new Matrix();
    this.pVR = new EmojiStoreV2TabView.1(this);
    this.pVS = new c() {};
    init();
    AppMethodBeat.o(109374);
  }
  
  private MMTabView Cs(int paramInt)
  {
    AppMethodBeat.i(109382);
    MMTabView localMMTabView = new MMTabView(getContext(), paramInt);
    localMMTabView.setTag(Integer.valueOf(paramInt));
    localMMTabView.setOnClickListener(this.pVR);
    AppMethodBeat.o(109382);
    return localMMTabView;
  }
  
  private void ckk()
  {
    AppMethodBeat.i(109378);
    this.pVM = new LinearLayout(getContext());
    this.pVM.setBackgroundResource(2131101179);
    this.pVM.setId(2131299446);
    this.pVM.setOrientation(0);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    addView(this.pVM, localLayoutParams);
    AppMethodBeat.o(109378);
  }
  
  private void ckl()
  {
    AppMethodBeat.i(109379);
    this.pVN = new ImageView(getContext());
    this.pVN.setImageMatrix(this.mMatrix);
    this.pVN.setScaleType(ImageView.ScaleType.MATRIX);
    this.pVN.setId(2131299447);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, a.fromDPToPix(getContext(), 3));
    localLayoutParams.addRule(8, 2131299446);
    addView(this.pVN, localLayoutParams);
    AppMethodBeat.o(109379);
  }
  
  private void ckm()
  {
    AppMethodBeat.i(109380);
    this.pVO = Cs(0);
    if (!bu.isNullOrNil(d.chY().pKI)) {
      this.pVO.setText(d.chY().pKI);
    }
    for (;;)
    {
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(2131166928));
      localLayoutParams.weight = 1.0F;
      this.pVM.addView(this.pVO, localLayoutParams);
      AppMethodBeat.o(109380);
      return;
      if (d.chY().pKH) {
        this.pVO.setText(2131758334);
      } else {
        this.pVO.setText(2131758333);
      }
    }
  }
  
  private void ckn()
  {
    AppMethodBeat.i(109381);
    this.pVP = Cs(1);
    this.pVP.setText(2131758341);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(2131166928));
    localLayoutParams.weight = 1.0F;
    this.pVM.addView(this.pVP, localLayoutParams);
    AppMethodBeat.o(109381);
  }
  
  private void init()
  {
    AppMethodBeat.i(109377);
    ckk();
    ckl();
    ckm();
    ckn();
    AppMethodBeat.o(109377);
  }
  
  public int getCurentIndex()
  {
    return this.pVK;
  }
  
  public final void kA(boolean paramBoolean)
  {
    AppMethodBeat.i(109386);
    if (this.pVP != null) {
      this.pVP.xv(paramBoolean);
    }
    AppMethodBeat.o(109386);
  }
  
  public final void o(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(109383);
    this.mMatrix.setTranslate(this.pVJ * (paramInt + paramFloat), 0.0F);
    this.pVN.setImageMatrix(this.mMatrix);
    AppMethodBeat.o(109383);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(109376);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.pVJ = ((paramInt3 - paramInt1) / 2);
    paramInt2 = this.pVJ;
    if (((this.pVL == null) || (this.pVL.getWidth() != paramInt2)) && (paramInt2 > 0)) {
      if (this.pVL != null) {
        break label166;
      }
    }
    label166:
    for (paramInt1 = -1;; paramInt1 = this.pVL.getWidth())
    {
      ae.w("MicroMsg.emoji.EmojiStoreV2TabView", "sharp width changed, from %d to %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.pVL = Bitmap.createBitmap(paramInt2, a.fromDPToPix(getContext(), 3), Bitmap.Config.ARGB_8888);
      new Canvas(this.pVL).drawColor(getResources().getColor(2131101171));
      o(this.pVK, 0.0F);
      this.pVN.setImageBitmap(this.pVL);
      setTo(this.pVK);
      AppMethodBeat.o(109376);
      return;
    }
  }
  
  public void setOnTabClickListener(EmojiStoreV2TabView.a parama)
  {
    this.pVQ = parama;
  }
  
  public void setPersonTabUnReadCount(String paramString)
  {
    AppMethodBeat.i(109385);
    if (this.pVP != null) {
      this.pVP.setUnread(paramString);
    }
    AppMethodBeat.o(109385);
  }
  
  public void setTo(int paramInt)
  {
    AppMethodBeat.i(109384);
    this.pVK = paramInt;
    MMTabView localMMTabView = this.pVO;
    if (this.pVK == 0)
    {
      paramInt = getResources().getColor(2131101171);
      localMMTabView.setTextColor(paramInt);
      localMMTabView = this.pVP;
      if (this.pVK != 1) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2TabView
 * JD-Core Version:    0.7.0.1
 */