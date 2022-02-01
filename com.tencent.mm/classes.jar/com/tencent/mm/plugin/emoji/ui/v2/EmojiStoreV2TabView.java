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
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.ea;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.plugin.emoji.h.c;
import com.tencent.mm.plugin.emoji.h.e;
import com.tencent.mm.plugin.emoji.h.h;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMTabView;

public class EmojiStoreV2TabView
  extends RelativeLayout
{
  private Matrix avQ;
  private int xYF;
  private int xYG;
  private Bitmap xYH;
  private LinearLayout xYI;
  private ImageView xYJ;
  private MMTabView xYK;
  private MMTabView xYL;
  private EmojiStoreV2TabView.a xYM;
  protected View.OnClickListener xYN;
  IListener<ea> xYO;
  
  public EmojiStoreV2TabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(109375);
    this.xYG = 0;
    this.avQ = new Matrix();
    this.xYN = new EmojiStoreV2TabView.1(this);
    this.xYO = new EmojiStoreV2TabView.2(this, f.hfK);
    init();
    AppMethodBeat.o(109375);
  }
  
  public EmojiStoreV2TabView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(109374);
    this.xYG = 0;
    this.avQ = new Matrix();
    this.xYN = new EmojiStoreV2TabView.1(this);
    this.xYO = new EmojiStoreV2TabView.2(this, f.hfK);
    init();
    AppMethodBeat.o(109374);
  }
  
  private MMTabView Kv(int paramInt)
  {
    AppMethodBeat.i(109382);
    MMTabView localMMTabView = new MMTabView(getContext(), paramInt);
    localMMTabView.setTag(Integer.valueOf(paramInt));
    localMMTabView.setOnClickListener(this.xYN);
    AppMethodBeat.o(109382);
    return localMMTabView;
  }
  
  private void dCA()
  {
    AppMethodBeat.i(109379);
    this.xYJ = new ImageView(getContext());
    this.xYJ.setImageMatrix(this.avQ);
    this.xYJ.setScaleType(ImageView.ScaleType.MATRIX);
    this.xYJ.setId(h.e.emoji_store_tab_shape);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, a.fromDPToPix(getContext(), 3));
    localLayoutParams.addRule(8, h.e.emoji_store_tab_container);
    addView(this.xYJ, localLayoutParams);
    AppMethodBeat.o(109379);
  }
  
  private void dCB()
  {
    AppMethodBeat.i(109380);
    this.xYK = Kv(0);
    if (!Util.isNullOrNil(j.dzN().xMJ)) {
      this.xYK.setText(j.dzN().xMJ);
    }
    for (;;)
    {
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(h.c.topTabbarHeight));
      localLayoutParams.weight = 1.0F;
      this.xYI.addView(this.xYK, localLayoutParams);
      AppMethodBeat.o(109380);
      return;
      if (j.dzN().xMI) {
        this.xYK.setText(h.h.emoji_store_main_tab_friends);
      } else {
        this.xYK.setText(h.h.emoji_store_main_tab);
      }
    }
  }
  
  private void dCC()
  {
    AppMethodBeat.i(109381);
    this.xYL = Kv(1);
    this.xYL.setText(h.h.emoji_store_person_tab_more);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(h.c.topTabbarHeight));
    localLayoutParams.weight = 1.0F;
    this.xYI.addView(this.xYL, localLayoutParams);
    AppMethodBeat.o(109381);
  }
  
  private void dCz()
  {
    AppMethodBeat.i(109378);
    this.xYI = new LinearLayout(getContext());
    this.xYI.setBackgroundResource(h.b.white);
    this.xYI.setId(h.e.emoji_store_tab_container);
    this.xYI.setOrientation(0);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    addView(this.xYI, localLayoutParams);
    AppMethodBeat.o(109378);
  }
  
  private void init()
  {
    AppMethodBeat.i(109377);
    dCz();
    dCA();
    dCB();
    dCC();
    AppMethodBeat.o(109377);
  }
  
  public int getCurentIndex()
  {
    return this.xYG;
  }
  
  public final void ok(boolean paramBoolean)
  {
    AppMethodBeat.i(109386);
    if (this.xYL != null) {
      this.xYL.ol(paramBoolean);
    }
    AppMethodBeat.o(109386);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(109376);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.xYF = ((paramInt3 - paramInt1) / 2);
    paramInt2 = this.xYF;
    if (((this.xYH == null) || (this.xYH.getWidth() != paramInt2)) && (paramInt2 > 0)) {
      if (this.xYH != null) {
        break label168;
      }
    }
    label168:
    for (paramInt1 = -1;; paramInt1 = this.xYH.getWidth())
    {
      Log.w("MicroMsg.emoji.EmojiStoreV2TabView", "sharp width changed, from %d to %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.xYH = Bitmap.createBitmap(paramInt2, a.fromDPToPix(getContext(), 3), Bitmap.Config.ARGB_8888);
      new Canvas(this.xYH).drawColor(getResources().getColor(h.b.wechat_green));
      t(this.xYG, 0.0F);
      this.xYJ.setImageBitmap(this.xYH);
      setTo(this.xYG);
      AppMethodBeat.o(109376);
      return;
    }
  }
  
  public void setOnTabClickListener(EmojiStoreV2TabView.a parama)
  {
    this.xYM = parama;
  }
  
  public void setPersonTabUnReadCount(String paramString)
  {
    AppMethodBeat.i(109385);
    if (this.xYL != null) {
      this.xYL.setUnread(paramString);
    }
    AppMethodBeat.o(109385);
  }
  
  public void setTo(int paramInt)
  {
    AppMethodBeat.i(109384);
    this.xYG = paramInt;
    MMTabView localMMTabView = this.xYK;
    if (this.xYG == 0)
    {
      paramInt = getResources().getColor(h.b.wechat_green);
      localMMTabView.setTextColor(paramInt);
      localMMTabView = this.xYL;
      if (this.xYG != 1) {
        break label92;
      }
    }
    label92:
    for (paramInt = getResources().getColor(h.b.wechat_green);; paramInt = getContext().getResources().getColor(h.b.FG_0))
    {
      localMMTabView.setTextColor(paramInt);
      AppMethodBeat.o(109384);
      return;
      paramInt = getContext().getResources().getColor(h.b.FG_0);
      break;
    }
  }
  
  public final void t(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(109383);
    this.avQ.setTranslate(this.xYF * (paramInt + paramFloat), 0.0F);
    this.xYJ.setImageMatrix(this.avQ);
    AppMethodBeat.o(109383);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2TabView
 * JD-Core Version:    0.7.0.1
 */