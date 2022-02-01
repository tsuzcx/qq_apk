package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.v4.content.a.f;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.b.a;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ar;
import kotlin.g.b.p;
import kotlin.l;
import org.libpag.PAGFile;
import org.libpag.PAGView;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/FinderLiveOnliveWidget;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "customerBgDrawable", "Landroid/graphics/drawable/Drawable;", "desc", "", "descColor", "descH", "getDescH", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "descMarginBottom", "descMarginLeft", "descMarginRight", "descMarginTop", "descTextBold", "", "descTextSize", "descW", "getDescW", "logoAnimAutoPlay", "logoAnimation", "Lorg/libpag/PAGView;", "logoAnimationFile", "logoColor", "logoDesc", "Landroid/widget/TextView;", "logoImage", "Landroid/widget/ImageView;", "logoImgId", "logoMarginBottom", "logoMarginLeft", "logoMarginRight", "logoMarginTop", "logoStyle", "logoViewH", "getLogoViewH", "logoViewW", "getLogoViewW", "mode", "pngAnimation", "Lcom/tencent/mm/plugin/finder/view/FinderLiveLogoAnim;", "showLogoAnim", "showLogoImg", "showPngAnim", "checkState", "", "hideAnim", "hideDesc", "hideImage", "hidePngAnim", "init", "initAttribute", "playAnim", "setBackground", "setText", "text", "setVisibility", "visibility", "showAnim", "colorId", "showDebugLog", "msg", "showDesc", "showImage", "showLogo", "imageId", "showPagAnim", "stopAnim", "Companion", "plugin-finder_release"})
public final class FinderLiveOnliveWidget
  extends LinearLayout
{
  private static final String TAG = "Finder.LiveOnliveWidget";
  public static final a wnW;
  private String desc;
  private int mode;
  private TextView wnA;
  private Integer wnB;
  private Integer wnC;
  private int wnD;
  private int wnE;
  private int wnF;
  private int wnG;
  private int wnH;
  private boolean wnI;
  private boolean wnJ;
  private boolean wnK;
  private boolean wnL;
  private int wnM;
  private Integer wnN;
  private Integer wnO;
  private int wnP;
  private int wnQ;
  private int wnR;
  private int wnS;
  private int wnT;
  private int wnU;
  private boolean wnV;
  private int wnu;
  private Drawable wnv;
  private String wnw;
  private PAGView wnx;
  private FinderLiveLogoAnim wny;
  private ImageView wnz;
  
  static
  {
    AppMethodBeat.i(254883);
    wnW = new a((byte)0);
    TAG = "Finder.LiveOnliveWidget";
    Log.i("Finder.LiveOnliveWidget", "tryLoadLibrary pag start " + ChannelUtil.isGPVersion());
    if ((!ChannelUtil.isGPVersion()) || (a.isEnabled()))
    {
      if (g.aAc()) {
        break label84;
      }
      Log.e(TAG, "loadPagLib account is not ready");
    }
    for (;;)
    {
      Log.i(TAG, "tryLoadLibrary pag end");
      AppMethodBeat.o(254883);
      return;
      label84:
      h.CyF.n(1279L, 200L, 1L);
      com.tencent.mm.plugin.expansions.d locald = com.tencent.mm.plugin.expansions.d.rNG;
      com.tencent.mm.plugin.expansions.d.aoa("pag");
      h.CyF.n(1279L, 201L, 1L);
    }
  }
  
  public FinderLiveOnliveWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(254881);
    this.wnu = 3;
    this.wnB = Integer.valueOf(0);
    this.wnC = Integer.valueOf(0);
    this.wnN = Integer.valueOf(0);
    this.wnO = Integer.valueOf(0);
    this.wnU = com.tencent.mm.view.d.e(getContext(), 10.0F);
    b(paramAttributeSet, 0);
    init();
    AppMethodBeat.o(254881);
  }
  
  public FinderLiveOnliveWidget(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(254882);
    this.wnu = 3;
    this.wnB = Integer.valueOf(0);
    this.wnC = Integer.valueOf(0);
    this.wnN = Integer.valueOf(0);
    this.wnO = Integer.valueOf(0);
    this.wnU = com.tencent.mm.view.d.e(getContext(), 10.0F);
    b(paramAttributeSet, paramInt);
    init();
    AppMethodBeat.o(254882);
  }
  
  private static void awR(String paramString)
  {
    AppMethodBeat.i(254880);
    y localy = y.vXH;
    if (y.dCM()) {
      Log.d(TAG, paramString);
    }
    AppMethodBeat.o(254880);
  }
  
  private final void b(AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(254871);
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, b.a.FinderLiveOnliveWidget, paramInt, 0);
      this.mode = paramAttributeSet.getInt(16, 0);
      switch (this.mode)
      {
      default: 
        this.wnu = paramAttributeSet.getInt(17, 3);
        if (this.wnu == 1)
        {
          this.wnI = true;
          this.wnK = false;
          this.wnL = false;
          this.wnJ = paramAttributeSet.getBoolean(10, false);
          this.wnw = paramAttributeSet.getString(0);
        }
        break;
      }
    }
    for (;;)
    {
      if (paramAttributeSet.hasValue(11)) {
        this.wnH = paramAttributeSet.getColor(11, getResources().getColor(2131099844));
      }
      if (paramAttributeSet.hasValue(18)) {
        this.wnB = Integer.valueOf((int)paramAttributeSet.getDimension(18, 0.0F));
      }
      if (paramAttributeSet.hasValue(12)) {
        this.wnC = Integer.valueOf((int)paramAttributeSet.getDimension(12, 0.0F));
      }
      if (paramAttributeSet.hasValue(14)) {
        this.wnD = ((int)paramAttributeSet.getDimension(14, 0.0F));
      }
      if (paramAttributeSet.hasValue(15)) {
        this.wnF = ((int)paramAttributeSet.getDimension(15, 0.0F));
      }
      if (paramAttributeSet.hasValue(6)) {
        this.desc = paramAttributeSet.getString(6);
      }
      if (paramAttributeSet.hasValue(9)) {
        this.wnN = Integer.valueOf((int)paramAttributeSet.getDimension(9, 0.0F));
      }
      if (paramAttributeSet.hasValue(3)) {
        this.wnO = Integer.valueOf((int)paramAttributeSet.getDimension(3, 0.0F));
      }
      if (paramAttributeSet.hasValue(4)) {
        this.wnP = ((int)paramAttributeSet.getDimension(4, 0.0F));
      }
      if (paramAttributeSet.hasValue(5)) {
        this.wnR = ((int)paramAttributeSet.getDimension(5, 0.0F));
      }
      if (paramAttributeSet.hasValue(2)) {
        this.wnT = paramAttributeSet.getColor(2, this.wnH);
      }
      if (paramAttributeSet.hasValue(8)) {
        this.wnU = ((int)paramAttributeSet.getDimension(8, 0.0F));
      }
      if (paramAttributeSet.hasValue(7)) {
        this.wnV = paramAttributeSet.getBoolean(7, false);
      }
      if (paramAttributeSet.hasValue(1)) {
        this.wnv = paramAttributeSet.getDrawable(1);
      }
      paramAttributeSet.recycle();
      if (BuildInfo.DEBUG) {
        Log.i(TAG, "[initAttribute],mode:" + this.mode + ",logoStyle:" + this.wnu + ",logoAnimationFile:" + this.wnw + ",logoColor:" + this.wnH + ",logoViewW:" + getLogoViewW() + ",logoViewH:" + getLogoViewH() + ',' + "logoMarginLeft:" + this.wnD + ",logoMarginRight:" + this.wnF + ",logoAnimAutoPlay" + this.wnJ + ",\\n text:" + this.desc + ",descW:" + getDescW() + ",descH:" + getDescH() + ",descMarginLeft:" + this.wnP + ",descMarginRight:" + this.wnR + ",descColor:" + this.wnT + ",descTextSize:" + this.wnU);
      }
      AppMethodBeat.o(254871);
      return;
      Context localContext = getContext();
      p.g(localContext, "context");
      this.wnv = localContext.getResources().getDrawable(2131232622, null);
      this.wnH = getResources().getColor(2131099844);
      localContext = getContext();
      p.g(localContext, "context");
      this.wnB = Integer.valueOf(localContext.getResources().getDimensionPixelOffset(2131165289));
      localContext = getContext();
      p.g(localContext, "context");
      this.wnC = Integer.valueOf(localContext.getResources().getDimensionPixelOffset(2131165289));
      localContext = getContext();
      p.g(localContext, "context");
      this.wnT = localContext.getResources().getColor(2131099844);
      this.wnU = com.tencent.mm.view.d.e(getContext(), 10.0F);
      this.wnP = com.tencent.mm.view.d.e(getContext(), 2.0F);
      localContext = getContext();
      p.g(localContext, "context");
      this.desc = localContext.getResources().getString(2131760368);
      this.wnV = false;
      break;
      localContext = getContext();
      p.g(localContext, "context");
      this.wnv = localContext.getResources().getDrawable(2131232613, null);
      this.wnH = getResources().getColor(2131100431);
      localContext = getContext();
      p.g(localContext, "context");
      this.wnB = Integer.valueOf(localContext.getResources().getDimensionPixelOffset(2131165289));
      localContext = getContext();
      p.g(localContext, "context");
      this.wnC = Integer.valueOf(localContext.getResources().getDimensionPixelOffset(2131165289));
      localContext = getContext();
      p.g(localContext, "context");
      this.wnT = localContext.getResources().getColor(2131100431);
      this.wnU = com.tencent.mm.view.d.e(getContext(), 10.0F);
      this.wnP = com.tencent.mm.view.d.e(getContext(), 2.0F);
      localContext = getContext();
      p.g(localContext, "context");
      this.desc = localContext.getResources().getString(2131760368);
      this.wnV = false;
      break;
      this.wnv = null;
      this.wnH = getResources().getColor(2131099844);
      localContext = getContext();
      p.g(localContext, "context");
      this.wnB = Integer.valueOf(localContext.getResources().getDimensionPixelOffset(2131165299));
      localContext = getContext();
      p.g(localContext, "context");
      this.wnC = Integer.valueOf(localContext.getResources().getDimensionPixelOffset(2131165299));
      localContext = getContext();
      p.g(localContext, "context");
      this.wnT = localContext.getResources().getColor(2131099844);
      this.wnU = com.tencent.mm.view.d.e(getContext(), 17.0F);
      this.wnP = com.tencent.mm.view.d.e(getContext(), 4.0F);
      localContext = getContext();
      p.g(localContext, "context");
      this.desc = localContext.getResources().getString(2131759918);
      this.wnV = true;
      break;
      this.wnv = null;
      this.wnH = getResources().getColor(2131099844);
      localContext = getContext();
      p.g(localContext, "context");
      this.wnB = Integer.valueOf(localContext.getResources().getDimensionPixelOffset(2131165297));
      localContext = getContext();
      p.g(localContext, "context");
      this.wnC = Integer.valueOf(localContext.getResources().getDimensionPixelOffset(2131165297));
      localContext = getContext();
      p.g(localContext, "context");
      this.wnT = localContext.getResources().getColor(2131099844);
      this.wnU = com.tencent.mm.view.d.e(getContext(), 15.0F);
      this.wnP = com.tencent.mm.view.d.e(getContext(), 4.0F);
      localContext = getContext();
      p.g(localContext, "context");
      this.desc = localContext.getResources().getString(2131759918);
      this.wnV = true;
      break;
      this.wnv = null;
      this.wnH = getResources().getColor(2131100431);
      localContext = getContext();
      p.g(localContext, "context");
      this.wnB = Integer.valueOf(localContext.getResources().getDimensionPixelOffset(2131165314));
      localContext = getContext();
      p.g(localContext, "context");
      this.wnC = Integer.valueOf(localContext.getResources().getDimensionPixelOffset(2131165314));
      this.desc = "";
      break;
      if (this.wnu == 2)
      {
        this.wnI = false;
        this.wnK = true;
        this.wnL = false;
        this.wnJ = paramAttributeSet.getBoolean(10, false);
      }
      else
      {
        this.wnI = false;
        this.wnK = false;
        this.wnL = true;
        this.wnM = paramAttributeSet.getResourceId(13, 0);
      }
    }
  }
  
  private final void dGU()
  {
    AppMethodBeat.i(254874);
    if (!this.wnL)
    {
      AppMethodBeat.o(254874);
      return;
    }
    if (this.wnz == null) {
      this.wnz = new ImageView(getContext());
    }
    Object localObject1;
    Object localObject2;
    if (this.wnM != 0)
    {
      localObject1 = this.wnz;
      if (localObject1 != null)
      {
        localObject2 = getContext();
        p.g(localObject2, "context");
        ((ImageView)localObject1).setImageDrawable(f.c(((Context)localObject2).getResources(), this.wnM, null));
      }
    }
    for (;;)
    {
      localObject1 = getLogoViewW();
      if (localObject1 == null) {
        p.hyc();
      }
      int i = ((Integer)localObject1).intValue();
      localObject1 = getLogoViewH();
      if (localObject1 == null) {
        p.hyc();
      }
      localObject1 = new LinearLayout.LayoutParams(i, ((Integer)localObject1).intValue());
      ((LinearLayout.LayoutParams)localObject1).setMargins(this.wnD, this.wnE, this.wnF, this.wnG);
      if (this.wnE == 0) {
        ((LinearLayout.LayoutParams)localObject1).gravity = 16;
      }
      localObject2 = this.wnz;
      if (localObject2 != null) {
        ((ImageView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      addView((View)this.wnz, 0);
      Log.i(TAG, "showImage logoImgId:" + this.wnM);
      AppMethodBeat.o(254874);
      return;
      localObject1 = this.wnz;
      if (localObject1 != null) {
        ((ImageView)localObject1).setImageDrawable(ar.m(getContext(), 2131690269, this.wnH));
      }
    }
  }
  
  private final void dGV()
  {
    AppMethodBeat.i(254875);
    Object localObject = (CharSequence)this.desc;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(254875);
      return;
    }
    if (this.wnA == null) {
      this.wnA = new TextView(getContext());
    }
    localObject = getDescW();
    if (localObject == null) {
      p.hyc();
    }
    i = ((Integer)localObject).intValue();
    localObject = getDescH();
    if (localObject == null) {
      p.hyc();
    }
    localObject = new LinearLayout.LayoutParams(i, ((Integer)localObject).intValue());
    ((LinearLayout.LayoutParams)localObject).setMargins(this.wnP, this.wnQ, this.wnR, this.wnS);
    if (this.wnE == 0) {
      ((LinearLayout.LayoutParams)localObject).gravity = 16;
    }
    TextView localTextView = this.wnA;
    if (localTextView != null) {
      localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    localObject = this.wnA;
    if (localObject != null) {
      ((TextView)localObject).setText((CharSequence)this.desc);
    }
    localObject = this.wnA;
    if (localObject != null) {
      ((TextView)localObject).setGravity(16);
    }
    localObject = this.wnA;
    if (localObject != null) {
      ((TextView)localObject).setTextSize(0, this.wnU);
    }
    localObject = this.wnA;
    if (localObject != null) {
      ((TextView)localObject).setTextColor(this.wnT);
    }
    localObject = this.wnA;
    if (localObject != null) {
      ((TextView)localObject).setIncludeFontPadding(false);
    }
    if (this.wnV)
    {
      localObject = this.wnA;
      if (localObject != null)
      {
        localObject = ((TextView)localObject).getPaint();
        ao.a((Paint)localObject, 0.8F);
      }
    }
    else
    {
      i = getChildCount();
      if (i >= 0) {
        break label335;
      }
    }
    label335:
    while (1 < i)
    {
      Log.i(TAG, "showDesc fail,childCount:" + getChildCount() + ", desc:" + this.desc);
      AppMethodBeat.o(254875);
      return;
      localObject = null;
      break;
    }
    addView((View)this.wnA, getChildCount());
    Log.i(TAG, "showDesc desc:" + this.desc);
    AppMethodBeat.o(254875);
  }
  
  private final void diX()
  {
    AppMethodBeat.i(254873);
    Throwable localThrowable;
    if ((!this.wnI) && (!this.wnK) && (!this.wnL) && (this.wnM == 0))
    {
      localThrowable = (Throwable)new Exception("neither amin or logo been set");
      AppMethodBeat.o(254873);
      throw localThrowable;
    }
    if (((this.wnI) || (this.wnI)) && ((this.wnL) || (this.wnM != 0)))
    {
      localThrowable = (Throwable)new Exception("either amin or logo been set");
      AppMethodBeat.o(254873);
      throw localThrowable;
    }
    AppMethodBeat.o(254873);
  }
  
  private final Integer getDescH()
  {
    AppMethodBeat.i(254869);
    Integer localInteger = this.wnO;
    if (localInteger == null) {}
    while (this.wnO == null) {
      do
      {
        AppMethodBeat.o(254869);
        return Integer.valueOf(-2);
      } while (localInteger.intValue() == 0);
    }
    localInteger = this.wnO;
    AppMethodBeat.o(254869);
    return localInteger;
  }
  
  private final Integer getDescW()
  {
    AppMethodBeat.i(254868);
    Integer localInteger = this.wnN;
    if (localInteger == null) {}
    while (this.wnN == null) {
      do
      {
        AppMethodBeat.o(254868);
        return Integer.valueOf(-2);
      } while (localInteger.intValue() == 0);
    }
    localInteger = this.wnN;
    AppMethodBeat.o(254868);
    return localInteger;
  }
  
  private final Integer getLogoViewH()
  {
    AppMethodBeat.i(254867);
    Integer localInteger = this.wnC;
    if (localInteger == null) {}
    while (this.wnC == null) {
      do
      {
        AppMethodBeat.o(254867);
        return Integer.valueOf(-1);
      } while (localInteger.intValue() == 0);
    }
    localInteger = this.wnC;
    AppMethodBeat.o(254867);
    return localInteger;
  }
  
  private final Integer getLogoViewW()
  {
    AppMethodBeat.i(254866);
    Integer localInteger = this.wnB;
    if (localInteger == null) {}
    while (this.wnB == null) {
      do
      {
        AppMethodBeat.o(254866);
        return Integer.valueOf(-1);
      } while (localInteger.intValue() == 0);
    }
    localInteger = this.wnB;
    AppMethodBeat.o(254866);
    return localInteger;
  }
  
  private final void init()
  {
    AppMethodBeat.i(254872);
    setOrientation(0);
    diX();
    if (this.mode != 0) {
      setBackground(this.wnv);
    }
    Object localObject1;
    int i;
    if (this.wnI)
    {
      if (!a.isEnabled()) {
        Log.i(TAG, "showAnim fail,pag not ready!");
      }
    }
    else if (this.wnK) {
      switch (this.mode)
      {
      default: 
        if (this.wnH == getResources().getColor(2131100431))
        {
          localObject1 = FinderLiveLogoAnim.wnt;
          i = FinderLiveLogoAnim.dGR();
        }
        break;
      }
    }
    for (;;)
    {
      if (this.wny == null)
      {
        localObject1 = getContext();
        p.g(localObject1, "context");
        this.wny = new FinderLiveLogoAnim((Context)localObject1, i);
      }
      localObject1 = getLogoViewW();
      if (localObject1 == null) {
        p.hyc();
      }
      int j = ((Integer)localObject1).intValue();
      localObject1 = getLogoViewH();
      if (localObject1 == null) {
        p.hyc();
      }
      localObject1 = new LinearLayout.LayoutParams(j, ((Integer)localObject1).intValue());
      ((LinearLayout.LayoutParams)localObject1).setMargins(this.wnD, this.wnE, this.wnF, this.wnG);
      if (this.wnE == 0) {
        ((LinearLayout.LayoutParams)localObject1).gravity = 16;
      }
      Object localObject2 = this.wny;
      if (localObject2 != null) {
        ((FinderLiveLogoAnim)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      addView((View)this.wny, 0);
      if (this.wnJ)
      {
        localObject1 = this.wny;
        if (localObject1 != null) {
          ((FinderLiveLogoAnim)localObject1).bWT();
        }
      }
      Log.i(TAG, "showPngAnim auto play:" + this.wnJ + ",pngAnimType:" + i);
      dGU();
      dGV();
      AppMethodBeat.o(254872);
      return;
      if (this.wnx == null) {
        this.wnx = new PAGView(getContext());
      }
      localObject1 = getLogoViewW();
      if (localObject1 == null) {
        p.hyc();
      }
      i = ((Integer)localObject1).intValue();
      localObject1 = getLogoViewH();
      if (localObject1 == null) {
        p.hyc();
      }
      localObject1 = new LinearLayout.LayoutParams(i, ((Integer)localObject1).intValue());
      ((LinearLayout.LayoutParams)localObject1).setMargins(this.wnD, this.wnE, this.wnF, this.wnG);
      if (this.wnE == 0) {
        ((LinearLayout.LayoutParams)localObject1).gravity = 16;
      }
      localObject2 = this.wnx;
      if (localObject2 != null) {
        ((PAGView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      if (!Util.isNullOrNil(this.wnw))
      {
        localObject1 = this.wnx;
        if (localObject1 != null)
        {
          localObject2 = getContext();
          p.g(localObject2, "context");
          ((PAGView)localObject1).setFile(PAGFile.Load(((Context)localObject2).getAssets(), this.wnw));
        }
      }
      for (;;)
      {
        addView((View)this.wnx, 0);
        localObject1 = this.wnx;
        if (localObject1 != null) {
          ((PAGView)localObject1).setRepeatCount(-1);
        }
        if (this.wnJ)
        {
          localObject1 = this.wnx;
          if (localObject1 != null) {
            ((PAGView)localObject1).play();
          }
        }
        Log.i(TAG, "showAnim auto play:" + this.wnJ);
        break;
        if (this.wnH == getResources().getColor(2131100431))
        {
          localObject1 = this.wnx;
          if (localObject1 != null)
          {
            localObject2 = getContext();
            p.g(localObject2, "context");
            ((PAGView)localObject1).setFile(PAGFile.Load(((Context)localObject2).getAssets(), "finder_live_logo_amin_red.pag"));
          }
        }
        else
        {
          localObject1 = this.wnx;
          if (localObject1 != null)
          {
            localObject2 = getContext();
            p.g(localObject2, "context");
            ((PAGView)localObject1).setFile(PAGFile.Load(((Context)localObject2).getAssets(), "finder_live_logo_amin_white.pag"));
          }
        }
      }
      localObject1 = FinderLiveLogoAnim.wnt;
      i = FinderLiveLogoAnim.dGT();
      continue;
      localObject1 = FinderLiveLogoAnim.wnt;
      i = FinderLiveLogoAnim.dGS();
    }
  }
  
  public final void cEA()
  {
    AppMethodBeat.i(254877);
    Object localObject = this.wnx;
    if (localObject != null) {
      ((PAGView)localObject).stop();
    }
    localObject = this.wny;
    if (localObject != null)
    {
      ((FinderLiveLogoAnim)localObject).cEA();
      AppMethodBeat.o(254877);
      return;
    }
    AppMethodBeat.o(254877);
  }
  
  public final void dGW()
  {
    AppMethodBeat.i(254876);
    Object localObject;
    if (this.wnu == 1)
    {
      localObject = this.wnx;
      if (localObject != null)
      {
        ((PAGView)localObject).play();
        AppMethodBeat.o(254876);
        return;
      }
      AppMethodBeat.o(254876);
      return;
    }
    if (this.wnu == 2)
    {
      localObject = this.wny;
      if (localObject != null)
      {
        ((FinderLiveLogoAnim)localObject).bWT();
        AppMethodBeat.o(254876);
        return;
      }
    }
    AppMethodBeat.o(254876);
  }
  
  public final void setText(String paramString)
  {
    AppMethodBeat.i(254879);
    p.h(paramString, "text");
    if (p.j(this.desc, paramString))
    {
      awR("same text:" + paramString + '!');
      AppMethodBeat.o(254879);
      return;
    }
    if (indexOfChild((View)this.wnA) != -1)
    {
      removeView((View)this.wnA);
      Log.i(TAG, "hideDesc");
    }
    this.desc = paramString;
    dGV();
    AppMethodBeat.o(254879);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(254870);
    super.setVisibility(paramInt);
    Object localObject;
    if (paramInt != 0)
    {
      if (this.wnI)
      {
        localObject = this.wnx;
        if (localObject != null) {
          ((PAGView)localObject).stop();
        }
      }
      if (this.wnK)
      {
        localObject = this.wny;
        if (localObject != null)
        {
          ((FinderLiveLogoAnim)localObject).cEA();
          AppMethodBeat.o(254870);
          return;
        }
        AppMethodBeat.o(254870);
      }
    }
    else if (this.wnJ)
    {
      if (this.wnI)
      {
        localObject = this.wnx;
        if (localObject != null) {
          ((PAGView)localObject).play();
        }
      }
      if (this.wnK)
      {
        localObject = this.wny;
        if (localObject != null)
        {
          ((FinderLiveLogoAnim)localObject).bWT();
          AppMethodBeat.o(254870);
          return;
        }
      }
    }
    AppMethodBeat.o(254870);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/FinderLiveOnliveWidget$Companion;", "", "()V", "DEFAULT_RED_ANIMATION_FILE", "", "DEFAULT_WHITE_ANIMATION_FILE", "LOGO_ANIM", "", "LOGO_IMAGE", "LOGO_PNG_ANIM", "MODE_CARD_ONLIVE", "MODE_FINISH_STAGGERED_GRID_MASK", "MODE_FINISH_TIME_LINE_MASK", "MODE_NONE", "MODE_ONLIVE_LIGHT_RED", "MODE_ONLIVE_RED", "TAG", "getTAG", "()Ljava/lang/String;", "isEnabled", "", "loadPagLib", "", "tryLoadLibrary", "plugin-finder_release"})
  public static final class a
  {
    public static boolean isEnabled()
    {
      AppMethodBeat.i(254865);
      com.tencent.mm.plugin.expansions.d locald = com.tencent.mm.plugin.expansions.d.rNG;
      boolean bool = com.tencent.mm.plugin.expansions.d.aoc("xlab");
      AppMethodBeat.o(254865);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderLiveOnliveWidget
 * JD-Core Version:    0.7.0.1
 */