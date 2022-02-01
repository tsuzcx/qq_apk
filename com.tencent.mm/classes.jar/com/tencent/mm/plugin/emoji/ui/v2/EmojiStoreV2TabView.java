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
import com.tencent.mm.cd.a;
import com.tencent.mm.g.a.dd;
import com.tencent.mm.plugin.emoji.model.d;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMTabView;
import com.tencent.mm.ui.ao;

public class EmojiStoreV2TabView
  extends RelativeLayout
{
  private Matrix mMatrix;
  private int oIe;
  private int oIf;
  private Bitmap oIg;
  private LinearLayout oIh;
  private ImageView oIi;
  private MMTabView oIj;
  private MMTabView oIk;
  private EmojiStoreV2TabView.a oIl;
  protected View.OnClickListener oIm;
  c<dd> oIn;
  
  public EmojiStoreV2TabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(109375);
    this.oIf = 0;
    this.mMatrix = new Matrix();
    this.oIm = new EmojiStoreV2TabView.1(this);
    this.oIn = new EmojiStoreV2TabView.2(this);
    init();
    AppMethodBeat.o(109375);
  }
  
  public EmojiStoreV2TabView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(109374);
    this.oIf = 0;
    this.mMatrix = new Matrix();
    this.oIm = new EmojiStoreV2TabView.1(this);
    this.oIn = new EmojiStoreV2TabView.2(this);
    init();
    AppMethodBeat.o(109374);
  }
  
  private MMTabView AG(int paramInt)
  {
    AppMethodBeat.i(109382);
    MMTabView localMMTabView = new MMTabView(getContext(), paramInt);
    localMMTabView.setTag(Integer.valueOf(paramInt));
    localMMTabView.setOnClickListener(this.oIm);
    AppMethodBeat.o(109382);
    return localMMTabView;
  }
  
  private void bXe()
  {
    AppMethodBeat.i(109378);
    this.oIh = new LinearLayout(getContext());
    this.oIh.setBackgroundResource(2131101179);
    this.oIh.setId(2131299446);
    this.oIh.setOrientation(0);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    addView(this.oIh, localLayoutParams);
    AppMethodBeat.o(109378);
  }
  
  private void bXf()
  {
    AppMethodBeat.i(109379);
    this.oIi = new ImageView(getContext());
    this.oIi.setImageMatrix(this.mMatrix);
    this.oIi.setScaleType(ImageView.ScaleType.MATRIX);
    this.oIi.setId(2131299447);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, a.fromDPToPix(getContext(), 3));
    localLayoutParams.addRule(8, 2131299446);
    addView(this.oIi, localLayoutParams);
    AppMethodBeat.o(109379);
  }
  
  private void bXg()
  {
    AppMethodBeat.i(109380);
    this.oIj = AG(0);
    if (!bt.isNullOrNil(d.bUR().owU)) {
      this.oIj.setText(d.bUR().owU);
    }
    for (;;)
    {
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(2131166928));
      localLayoutParams.weight = 1.0F;
      this.oIh.addView(this.oIj, localLayoutParams);
      AppMethodBeat.o(109380);
      return;
      if (d.bUR().owT) {
        this.oIj.setText(2131758334);
      } else {
        this.oIj.setText(2131758333);
      }
    }
  }
  
  private void bXh()
  {
    AppMethodBeat.i(109381);
    this.oIk = AG(1);
    this.oIk.setText(2131758341);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(2131166928));
    localLayoutParams.weight = 1.0F;
    this.oIh.addView(this.oIk, localLayoutParams);
    AppMethodBeat.o(109381);
  }
  
  private void init()
  {
    AppMethodBeat.i(109377);
    bXe();
    bXf();
    bXg();
    bXh();
    AppMethodBeat.o(109377);
  }
  
  public int getCurentIndex()
  {
    return this.oIf;
  }
  
  public final void jN(boolean paramBoolean)
  {
    AppMethodBeat.i(109386);
    if (this.oIk != null) {
      this.oIk.vz(paramBoolean);
    }
    AppMethodBeat.o(109386);
  }
  
  public final void n(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(109383);
    this.mMatrix.setTranslate(this.oIe * (paramInt + paramFloat), 0.0F);
    this.oIi.setImageMatrix(this.mMatrix);
    AppMethodBeat.o(109383);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(109376);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.oIe = ((paramInt3 - paramInt1) / 2);
    paramInt2 = this.oIe;
    if (((this.oIg == null) || (this.oIg.getWidth() != paramInt2)) && (paramInt2 > 0)) {
      if (this.oIg != null) {
        break label166;
      }
    }
    label166:
    for (paramInt1 = -1;; paramInt1 = this.oIg.getWidth())
    {
      ad.w("MicroMsg.emoji.EmojiStoreV2TabView", "sharp width changed, from %d to %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.oIg = Bitmap.createBitmap(paramInt2, a.fromDPToPix(getContext(), 3), Bitmap.Config.ARGB_8888);
      new Canvas(this.oIg).drawColor(getResources().getColor(2131101171));
      n(this.oIf, 0.0F);
      this.oIi.setImageBitmap(this.oIg);
      setTo(this.oIf);
      AppMethodBeat.o(109376);
      return;
    }
  }
  
  public void setOnTabClickListener(EmojiStoreV2TabView.a parama)
  {
    this.oIl = parama;
  }
  
  public void setPersonTabUnReadCount(String paramString)
  {
    AppMethodBeat.i(109385);
    if (this.oIk != null) {
      this.oIk.setUnread(paramString);
    }
    AppMethodBeat.o(109385);
  }
  
  public void setTo(int paramInt)
  {
    AppMethodBeat.i(109384);
    this.oIf = paramInt;
    MMTabView localMMTabView = this.oIj;
    if (this.oIf == 0)
    {
      paramInt = getResources().getColor(2131101171);
      localMMTabView.setTextColor(paramInt);
      localMMTabView = this.oIk;
      if (this.oIf != 1) {
        break label89;
      }
    }
    label89:
    for (paramInt = getResources().getColor(2131101171);; paramInt = ao.aD(getContext(), 2130968584))
    {
      localMMTabView.setTextColor(paramInt);
      AppMethodBeat.o(109384);
      return;
      paramInt = ao.aD(getContext(), 2130968584);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2TabView
 * JD-Core Version:    0.7.0.1
 */