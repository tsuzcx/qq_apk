package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.dl;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.emoji.model.e;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMTabView;

public class EmojiStoreV2TabView
  extends RelativeLayout
{
  private Matrix mMatrix;
  private int rmI;
  private int rmJ;
  private Bitmap rmK;
  private LinearLayout rmL;
  private ImageView rmM;
  private MMTabView rmN;
  private MMTabView rmO;
  private a rmP;
  protected View.OnClickListener rmQ;
  IListener<dl> rmR;
  
  public EmojiStoreV2TabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(109375);
    this.rmJ = 0;
    this.mMatrix = new Matrix();
    this.rmQ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109371);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2TabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        if (EmojiStoreV2TabView.a(EmojiStoreV2TabView.this) != null) {
          EmojiStoreV2TabView.a(EmojiStoreV2TabView.this).onTabClick(i);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2TabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(109371);
      }
    };
    this.rmR = new IListener() {};
    init();
    AppMethodBeat.o(109375);
  }
  
  public EmojiStoreV2TabView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(109374);
    this.rmJ = 0;
    this.mMatrix = new Matrix();
    this.rmQ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109371);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2TabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        if (EmojiStoreV2TabView.a(EmojiStoreV2TabView.this) != null) {
          EmojiStoreV2TabView.a(EmojiStoreV2TabView.this).onTabClick(i);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2TabView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(109371);
      }
    };
    this.rmR = new IListener() {};
    init();
    AppMethodBeat.o(109374);
  }
  
  private MMTabView Gd(int paramInt)
  {
    AppMethodBeat.i(109382);
    MMTabView localMMTabView = new MMTabView(getContext(), paramInt);
    localMMTabView.setTag(Integer.valueOf(paramInt));
    localMMTabView.setOnClickListener(this.rmQ);
    AppMethodBeat.o(109382);
    return localMMTabView;
  }
  
  private void cIm()
  {
    AppMethodBeat.i(109378);
    this.rmL = new LinearLayout(getContext());
    this.rmL.setBackgroundResource(2131101424);
    this.rmL.setId(2131300060);
    this.rmL.setOrientation(0);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    addView(this.rmL, localLayoutParams);
    AppMethodBeat.o(109378);
  }
  
  private void cIn()
  {
    AppMethodBeat.i(109379);
    this.rmM = new ImageView(getContext());
    this.rmM.setImageMatrix(this.mMatrix);
    this.rmM.setScaleType(ImageView.ScaleType.MATRIX);
    this.rmM.setId(2131300061);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, com.tencent.mm.cb.a.fromDPToPix(getContext(), 3));
    localLayoutParams.addRule(8, 2131300060);
    addView(this.rmM, localLayoutParams);
    AppMethodBeat.o(109379);
  }
  
  private void cIo()
  {
    AppMethodBeat.i(109380);
    this.rmN = Gd(0);
    if (!Util.isNullOrNil(e.cFX().rbo)) {
      this.rmN.setText(e.cFX().rbo);
    }
    for (;;)
    {
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(2131167063));
      localLayoutParams.weight = 1.0F;
      this.rmL.addView(this.rmN, localLayoutParams);
      AppMethodBeat.o(109380);
      return;
      if (e.cFX().rbn) {
        this.rmN.setText(2131758628);
      } else {
        this.rmN.setText(2131758627);
      }
    }
  }
  
  private void cIp()
  {
    AppMethodBeat.i(109381);
    this.rmO = Gd(1);
    this.rmO.setText(2131758635);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(2131167063));
    localLayoutParams.weight = 1.0F;
    this.rmL.addView(this.rmO, localLayoutParams);
    AppMethodBeat.o(109381);
  }
  
  private void init()
  {
    AppMethodBeat.i(109377);
    cIm();
    cIn();
    cIo();
    cIp();
    AppMethodBeat.o(109377);
  }
  
  public int getCurentIndex()
  {
    return this.rmJ;
  }
  
  public final void lC(boolean paramBoolean)
  {
    AppMethodBeat.i(109386);
    if (this.rmO != null) {
      this.rmO.Bk(paramBoolean);
    }
    AppMethodBeat.o(109386);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(109376);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.rmI = ((paramInt3 - paramInt1) / 2);
    paramInt2 = this.rmI;
    if (((this.rmK == null) || (this.rmK.getWidth() != paramInt2)) && (paramInt2 > 0)) {
      if (this.rmK != null) {
        break label166;
      }
    }
    label166:
    for (paramInt1 = -1;; paramInt1 = this.rmK.getWidth())
    {
      Log.w("MicroMsg.emoji.EmojiStoreV2TabView", "sharp width changed, from %d to %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.rmK = Bitmap.createBitmap(paramInt2, com.tencent.mm.cb.a.fromDPToPix(getContext(), 3), Bitmap.Config.ARGB_8888);
      new Canvas(this.rmK).drawColor(getResources().getColor(2131101414));
      p(this.rmJ, 0.0F);
      this.rmM.setImageBitmap(this.rmK);
      setTo(this.rmJ);
      AppMethodBeat.o(109376);
      return;
    }
  }
  
  public final void p(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(109383);
    this.mMatrix.setTranslate(this.rmI * (paramInt + paramFloat), 0.0F);
    this.rmM.setImageMatrix(this.mMatrix);
    AppMethodBeat.o(109383);
  }
  
  public void setOnTabClickListener(a parama)
  {
    this.rmP = parama;
  }
  
  public void setPersonTabUnReadCount(String paramString)
  {
    AppMethodBeat.i(109385);
    if (this.rmO != null) {
      this.rmO.setUnread(paramString);
    }
    AppMethodBeat.o(109385);
  }
  
  public void setTo(int paramInt)
  {
    AppMethodBeat.i(109384);
    this.rmJ = paramInt;
    MMTabView localMMTabView = this.rmN;
    if (this.rmJ == 0)
    {
      paramInt = getResources().getColor(2131101414);
      localMMTabView.setTextColor(paramInt);
      localMMTabView = this.rmO;
      if (this.rmJ != 1) {
        break label92;
      }
    }
    label92:
    for (paramInt = getResources().getColor(2131101414);; paramInt = getContext().getResources().getColor(2131099746))
    {
      localMMTabView.setTextColor(paramInt);
      AppMethodBeat.o(109384);
      return;
      paramInt = getContext().getResources().getColor(2131099746);
      break;
    }
  }
  
  public static abstract interface a
  {
    public abstract void onTabClick(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2TabView
 * JD-Core Version:    0.7.0.1
 */