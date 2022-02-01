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
import com.tencent.mm.g.a.de;
import com.tencent.mm.plugin.emoji.model.d;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMTabView;
import com.tencent.mm.ui.ao;

public class EmojiStoreV2TabView
  extends RelativeLayout
{
  private Matrix mMatrix;
  private int plE;
  private int plF;
  private Bitmap plG;
  private LinearLayout plH;
  private ImageView plI;
  private MMTabView plJ;
  private MMTabView plK;
  private EmojiStoreV2TabView.a plL;
  protected View.OnClickListener plM;
  c<de> plN;
  
  public EmojiStoreV2TabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(109375);
    this.plF = 0;
    this.mMatrix = new Matrix();
    this.plM = new EmojiStoreV2TabView.1(this);
    this.plN = new c() {};
    init();
    AppMethodBeat.o(109375);
  }
  
  public EmojiStoreV2TabView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(109374);
    this.plF = 0;
    this.mMatrix = new Matrix();
    this.plM = new EmojiStoreV2TabView.1(this);
    this.plN = new c() {};
    init();
    AppMethodBeat.o(109374);
  }
  
  private MMTabView By(int paramInt)
  {
    AppMethodBeat.i(109382);
    MMTabView localMMTabView = new MMTabView(getContext(), paramInt);
    localMMTabView.setTag(Integer.valueOf(paramInt));
    localMMTabView.setOnClickListener(this.plM);
    AppMethodBeat.o(109382);
    return localMMTabView;
  }
  
  private void cer()
  {
    AppMethodBeat.i(109378);
    this.plH = new LinearLayout(getContext());
    this.plH.setBackgroundResource(2131101179);
    this.plH.setId(2131299446);
    this.plH.setOrientation(0);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    addView(this.plH, localLayoutParams);
    AppMethodBeat.o(109378);
  }
  
  private void ces()
  {
    AppMethodBeat.i(109379);
    this.plI = new ImageView(getContext());
    this.plI.setImageMatrix(this.mMatrix);
    this.plI.setScaleType(ImageView.ScaleType.MATRIX);
    this.plI.setId(2131299447);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, a.fromDPToPix(getContext(), 3));
    localLayoutParams.addRule(8, 2131299446);
    addView(this.plI, localLayoutParams);
    AppMethodBeat.o(109379);
  }
  
  private void cet()
  {
    AppMethodBeat.i(109380);
    this.plJ = By(0);
    if (!bs.isNullOrNil(d.cce().pau)) {
      this.plJ.setText(d.cce().pau);
    }
    for (;;)
    {
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(2131166928));
      localLayoutParams.weight = 1.0F;
      this.plH.addView(this.plJ, localLayoutParams);
      AppMethodBeat.o(109380);
      return;
      if (d.cce().pat) {
        this.plJ.setText(2131758334);
      } else {
        this.plJ.setText(2131758333);
      }
    }
  }
  
  private void ceu()
  {
    AppMethodBeat.i(109381);
    this.plK = By(1);
    this.plK.setText(2131758341);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(2131166928));
    localLayoutParams.weight = 1.0F;
    this.plH.addView(this.plK, localLayoutParams);
    AppMethodBeat.o(109381);
  }
  
  private void init()
  {
    AppMethodBeat.i(109377);
    cer();
    ces();
    cet();
    ceu();
    AppMethodBeat.o(109377);
  }
  
  public int getCurentIndex()
  {
    return this.plF;
  }
  
  public final void kq(boolean paramBoolean)
  {
    AppMethodBeat.i(109386);
    if (this.plK != null) {
      this.plK.wB(paramBoolean);
    }
    AppMethodBeat.o(109386);
  }
  
  public final void n(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(109383);
    this.mMatrix.setTranslate(this.plE * (paramInt + paramFloat), 0.0F);
    this.plI.setImageMatrix(this.mMatrix);
    AppMethodBeat.o(109383);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(109376);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.plE = ((paramInt3 - paramInt1) / 2);
    paramInt2 = this.plE;
    if (((this.plG == null) || (this.plG.getWidth() != paramInt2)) && (paramInt2 > 0)) {
      if (this.plG != null) {
        break label166;
      }
    }
    label166:
    for (paramInt1 = -1;; paramInt1 = this.plG.getWidth())
    {
      ac.w("MicroMsg.emoji.EmojiStoreV2TabView", "sharp width changed, from %d to %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.plG = Bitmap.createBitmap(paramInt2, a.fromDPToPix(getContext(), 3), Bitmap.Config.ARGB_8888);
      new Canvas(this.plG).drawColor(getResources().getColor(2131101171));
      n(this.plF, 0.0F);
      this.plI.setImageBitmap(this.plG);
      setTo(this.plF);
      AppMethodBeat.o(109376);
      return;
    }
  }
  
  public void setOnTabClickListener(EmojiStoreV2TabView.a parama)
  {
    this.plL = parama;
  }
  
  public void setPersonTabUnReadCount(String paramString)
  {
    AppMethodBeat.i(109385);
    if (this.plK != null) {
      this.plK.setUnread(paramString);
    }
    AppMethodBeat.o(109385);
  }
  
  public void setTo(int paramInt)
  {
    AppMethodBeat.i(109384);
    this.plF = paramInt;
    MMTabView localMMTabView = this.plJ;
    if (this.plF == 0)
    {
      paramInt = getResources().getColor(2131101171);
      localMMTabView.setTextColor(paramInt);
      localMMTabView = this.plK;
      if (this.plF != 1) {
        break label89;
      }
    }
    label89:
    for (paramInt = getResources().getColor(2131101171);; paramInt = ao.aJ(getContext(), 2130968584))
    {
      localMMTabView.setTextColor(paramInt);
      AppMethodBeat.o(109384);
      return;
      paramInt = ao.aJ(getContext(), 2130968584);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2TabView
 * JD-Core Version:    0.7.0.1
 */