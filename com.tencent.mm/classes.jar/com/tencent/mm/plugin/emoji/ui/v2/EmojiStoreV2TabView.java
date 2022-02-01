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
import com.tencent.mm.ci.a;
import com.tencent.mm.f.a.dq;
import com.tencent.mm.plugin.emoji.i.b;
import com.tencent.mm.plugin.emoji.i.c;
import com.tencent.mm.plugin.emoji.i.e;
import com.tencent.mm.plugin.emoji.i.h;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMTabView;

public class EmojiStoreV2TabView
  extends RelativeLayout
{
  private Matrix aqj;
  private int uPU;
  private int uPV;
  private Bitmap uPW;
  private LinearLayout uPX;
  private ImageView uPY;
  private MMTabView uPZ;
  private MMTabView uQa;
  private EmojiStoreV2TabView.a uQb;
  protected View.OnClickListener uQc;
  IListener<dq> uQd;
  
  public EmojiStoreV2TabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(109375);
    this.uPV = 0;
    this.aqj = new Matrix();
    this.uQc = new EmojiStoreV2TabView.1(this);
    this.uQd = new IListener() {};
    init();
    AppMethodBeat.o(109375);
  }
  
  public EmojiStoreV2TabView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(109374);
    this.uPV = 0;
    this.aqj = new Matrix();
    this.uQc = new EmojiStoreV2TabView.1(this);
    this.uQd = new IListener() {};
    init();
    AppMethodBeat.o(109374);
  }
  
  private MMTabView JK(int paramInt)
  {
    AppMethodBeat.i(109382);
    MMTabView localMMTabView = new MMTabView(getContext(), paramInt);
    localMMTabView.setTag(Integer.valueOf(paramInt));
    localMMTabView.setOnClickListener(this.uQc);
    AppMethodBeat.o(109382);
    return localMMTabView;
  }
  
  private void cWT()
  {
    AppMethodBeat.i(109378);
    this.uPX = new LinearLayout(getContext());
    this.uPX.setBackgroundResource(i.b.white);
    this.uPX.setId(i.e.emoji_store_tab_container);
    this.uPX.setOrientation(0);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    addView(this.uPX, localLayoutParams);
    AppMethodBeat.o(109378);
  }
  
  private void cWU()
  {
    AppMethodBeat.i(109379);
    this.uPY = new ImageView(getContext());
    this.uPY.setImageMatrix(this.aqj);
    this.uPY.setScaleType(ImageView.ScaleType.MATRIX);
    this.uPY.setId(i.e.emoji_store_tab_shape);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, a.fromDPToPix(getContext(), 3));
    localLayoutParams.addRule(8, i.e.emoji_store_tab_container);
    addView(this.uPY, localLayoutParams);
    AppMethodBeat.o(109379);
  }
  
  private void cWV()
  {
    AppMethodBeat.i(109380);
    this.uPZ = JK(0);
    if (!Util.isNullOrNil(j.cUG().uEs)) {
      this.uPZ.setText(j.cUG().uEs);
    }
    for (;;)
    {
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(i.c.topTabbarHeight));
      localLayoutParams.weight = 1.0F;
      this.uPX.addView(this.uPZ, localLayoutParams);
      AppMethodBeat.o(109380);
      return;
      if (j.cUG().uEr) {
        this.uPZ.setText(i.h.emoji_store_main_tab_friends);
      } else {
        this.uPZ.setText(i.h.emoji_store_main_tab);
      }
    }
  }
  
  private void cWW()
  {
    AppMethodBeat.i(109381);
    this.uQa = JK(1);
    this.uQa.setText(i.h.emoji_store_person_tab_more);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(i.c.topTabbarHeight));
    localLayoutParams.weight = 1.0F;
    this.uPX.addView(this.uQa, localLayoutParams);
    AppMethodBeat.o(109381);
  }
  
  private void init()
  {
    AppMethodBeat.i(109377);
    cWT();
    cWU();
    cWV();
    cWW();
    AppMethodBeat.o(109377);
  }
  
  public int getCurentIndex()
  {
    return this.uPV;
  }
  
  public final void mN(boolean paramBoolean)
  {
    AppMethodBeat.i(109386);
    if (this.uQa != null) {
      this.uQa.FA(paramBoolean);
    }
    AppMethodBeat.o(109386);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(109376);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.uPU = ((paramInt3 - paramInt1) / 2);
    paramInt2 = this.uPU;
    if (((this.uPW == null) || (this.uPW.getWidth() != paramInt2)) && (paramInt2 > 0)) {
      if (this.uPW != null) {
        break label168;
      }
    }
    label168:
    for (paramInt1 = -1;; paramInt1 = this.uPW.getWidth())
    {
      Log.w("MicroMsg.emoji.EmojiStoreV2TabView", "sharp width changed, from %d to %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.uPW = Bitmap.createBitmap(paramInt2, a.fromDPToPix(getContext(), 3), Bitmap.Config.ARGB_8888);
      new Canvas(this.uPW).drawColor(getResources().getColor(i.b.wechat_green));
      q(this.uPV, 0.0F);
      this.uPY.setImageBitmap(this.uPW);
      setTo(this.uPV);
      AppMethodBeat.o(109376);
      return;
    }
  }
  
  public final void q(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(109383);
    this.aqj.setTranslate(this.uPU * (paramInt + paramFloat), 0.0F);
    this.uPY.setImageMatrix(this.aqj);
    AppMethodBeat.o(109383);
  }
  
  public void setOnTabClickListener(EmojiStoreV2TabView.a parama)
  {
    this.uQb = parama;
  }
  
  public void setPersonTabUnReadCount(String paramString)
  {
    AppMethodBeat.i(109385);
    if (this.uQa != null) {
      this.uQa.setUnread(paramString);
    }
    AppMethodBeat.o(109385);
  }
  
  public void setTo(int paramInt)
  {
    AppMethodBeat.i(109384);
    this.uPV = paramInt;
    MMTabView localMMTabView = this.uPZ;
    if (this.uPV == 0)
    {
      paramInt = getResources().getColor(i.b.wechat_green);
      localMMTabView.setTextColor(paramInt);
      localMMTabView = this.uQa;
      if (this.uPV != 1) {
        break label92;
      }
    }
    label92:
    for (paramInt = getResources().getColor(i.b.wechat_green);; paramInt = getContext().getResources().getColor(i.b.FG_0))
    {
      localMMTabView.setTextColor(paramInt);
      AppMethodBeat.o(109384);
      return;
      paramInt = getContext().getResources().getColor(i.b.FG_0);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2TabView
 * JD-Core Version:    0.7.0.1
 */