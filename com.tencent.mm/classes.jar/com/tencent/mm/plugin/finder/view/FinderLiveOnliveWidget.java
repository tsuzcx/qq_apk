package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.core.content.a.f;
import com.tencent.d.a.a.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.bb;
import com.tencent.mm.view.d;
import com.tencent.mm.w.a.a.a.b;
import com.tencent.mm.w.a.a.a.c;
import com.tencent.mm.w.a.a.a.d;
import com.tencent.mm.w.a.a.a.h;
import com.tencent.mm.w.a.a.a.i;
import com.tencent.mm.w.a.a.a.k;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.libpag.PAGFile;
import org.libpag.PAGView;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderLiveOnliveWidget;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "customerBgDrawable", "Landroid/graphics/drawable/Drawable;", "desc", "", "descColor", "descH", "getDescH", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "descMarginBottom", "descMarginLeft", "descMarginRight", "descMarginTop", "descTextBold", "", "descTextSize", "descW", "getDescW", "logoAnimAutoPlay", "logoAnimation", "Lorg/libpag/PAGView;", "logoAnimationFile", "logoColor", "logoDesc", "Landroid/widget/TextView;", "logoImage", "Landroid/widget/ImageView;", "logoImgId", "logoMarginBottom", "logoMarginLeft", "logoMarginRight", "logoMarginTop", "logoStyle", "logoViewH", "getLogoViewH", "logoViewW", "getLogoViewW", "mode", "showLogoAnim", "showLogoImg", "checkState", "", "getText", "hideAnim", "hideDesc", "hideImage", "init", "initAttribute", "playAnim", "setBackground", "setLogoStyle", "style", "setText", "text", "setVisibility", "visibility", "showAnim", "colorId", "showDebugLog", "msg", "showDesc", "showImage", "showLogo", "imageId", "showPagAnim", "stopAnim", "Companion", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveOnliveWidget
  extends LinearLayout
{
  public static final a GAF;
  public static final String TAG;
  public int GAG;
  private Drawable GAH;
  private String GAI;
  public PAGView GAJ;
  public ImageView GAK;
  private TextView GAL;
  private Integer GAM;
  private Integer GAN;
  private int GAO;
  private int GAP;
  private int GAQ;
  private int GAR;
  public int GAS;
  public boolean GAT;
  private boolean GAU;
  public boolean GAV;
  private int GAW;
  private Integer GAX;
  private Integer GAY;
  private int GAZ;
  private int GBa;
  private int GBb;
  private int GBc;
  private int GBd;
  private boolean GBe;
  private String desc;
  private int descTextSize;
  private int mode;
  
  static
  {
    AppMethodBeat.i(344579);
    GAF = new a((byte)0);
    TAG = "Finder.LiveOnliveWidget";
    Object localObject = a.ahiX;
    if (((Number)a.jRU().bmg()).intValue() == 0)
    {
      localObject = com.tencent.mm.plugin.finder.utils.aw.Gjk;
      com.tencent.mm.plugin.finder.utils.aw.aBW(String.valueOf(TAG));
      AppMethodBeat.o(344579);
      return;
    }
    Log.i(TAG, s.X("tryLoadLibrary pag start ", Boolean.valueOf(ChannelUtil.isGPVersion())));
    if ((!ChannelUtil.isGPVersion()) || (a.isEnabled()))
    {
      if (com.tencent.mm.kernel.h.baz()) {
        break label116;
      }
      Log.e(TAG, "loadPagLib account is not ready");
    }
    for (;;)
    {
      Log.i(TAG, "tryLoadLibrary pag end");
      AppMethodBeat.o(344579);
      return;
      label116:
      com.tencent.mm.plugin.report.service.h.OAn.p(1279L, 200L, 1L);
      localObject = com.tencent.mm.plugin.expansions.b.yFu;
      com.tencent.mm.plugin.expansions.b.tryLoadLibrary("pag");
      com.tencent.mm.plugin.report.service.h.OAn.p(1279L, 201L, 1L);
    }
  }
  
  public FinderLiveOnliveWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(344510);
    this.GAG = 2;
    this.GAM = Integer.valueOf(0);
    this.GAN = Integer.valueOf(0);
    this.GAX = Integer.valueOf(0);
    this.GAY = Integer.valueOf(0);
    this.GBb = MMApplicationContext.getContext().getResources().getDimensionPixelOffset(a.c.Edge_A);
    this.descTextSize = d.e(getContext(), 10.0F);
    b(paramAttributeSet, 0);
    init();
    AppMethodBeat.o(344510);
  }
  
  public FinderLiveOnliveWidget(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(344516);
    this.GAG = 2;
    this.GAM = Integer.valueOf(0);
    this.GAN = Integer.valueOf(0);
    this.GAX = Integer.valueOf(0);
    this.GAY = Integer.valueOf(0);
    this.GBb = MMApplicationContext.getContext().getResources().getDimensionPixelOffset(a.c.Edge_A);
    this.descTextSize = d.e(getContext(), 10.0F);
    b(paramAttributeSet, paramInt);
    init();
    AppMethodBeat.o(344516);
  }
  
  public static void aCE(String paramString)
  {
    AppMethodBeat.i(344571);
    com.tencent.mm.plugin.finder.utils.aw localaw = com.tencent.mm.plugin.finder.utils.aw.Gjk;
    if (com.tencent.mm.plugin.finder.utils.aw.bgV()) {
      Log.d(TAG, paramString);
    }
    AppMethodBeat.o(344571);
  }
  
  private final void b(AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(344535);
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, a.k.FinderLiveOnliveWidget, paramInt, 0);
      s.s(paramAttributeSet, "context.obtainStyledAttr…nliveWidget, defStyle, 0)");
      this.mode = paramAttributeSet.getInt(a.k.FinderLiveOnliveWidget_logo_mode, 0);
      switch (this.mode)
      {
      default: 
        this.GAG = paramAttributeSet.getInt(a.k.FinderLiveOnliveWidget_logo_style, 2);
        if (this.GAG == 1)
        {
          this.GAT = true;
          this.GAV = false;
          this.GAU = paramAttributeSet.getBoolean(a.k.FinderLiveOnliveWidget_logo_anim_auto_paly, false);
          this.GAI = paramAttributeSet.getString(a.k.FinderLiveOnliveWidget_animation_file);
        }
        break;
      }
    }
    for (;;)
    {
      if (paramAttributeSet.hasValue(a.k.FinderLiveOnliveWidget_logo_color)) {
        this.GAS = paramAttributeSet.getColor(a.k.FinderLiveOnliveWidget_logo_color, getResources().getColor(a.b.White));
      }
      if (paramAttributeSet.hasValue(a.k.FinderLiveOnliveWidget_logo_width)) {
        this.GAM = Integer.valueOf((int)paramAttributeSet.getDimension(a.k.FinderLiveOnliveWidget_logo_width, 0.0F));
      }
      if (paramAttributeSet.hasValue(a.k.FinderLiveOnliveWidget_logo_height)) {
        this.GAN = Integer.valueOf((int)paramAttributeSet.getDimension(a.k.FinderLiveOnliveWidget_logo_height, 0.0F));
      }
      if (paramAttributeSet.hasValue(a.k.FinderLiveOnliveWidget_logo_margin_left)) {
        this.GAO = ((int)paramAttributeSet.getDimension(a.k.FinderLiveOnliveWidget_logo_margin_left, 0.0F));
      }
      if (paramAttributeSet.hasValue(a.k.FinderLiveOnliveWidget_logo_margin_right)) {
        this.GAQ = ((int)paramAttributeSet.getDimension(a.k.FinderLiveOnliveWidget_logo_margin_right, 0.0F));
      }
      if (paramAttributeSet.hasValue(a.k.FinderLiveOnliveWidget_desc_text)) {
        this.desc = paramAttributeSet.getString(a.k.FinderLiveOnliveWidget_desc_text);
      }
      if (paramAttributeSet.hasValue(a.k.FinderLiveOnliveWidget_desc_width)) {
        this.GAX = Integer.valueOf((int)paramAttributeSet.getDimension(a.k.FinderLiveOnliveWidget_desc_width, 0.0F));
      }
      if (paramAttributeSet.hasValue(a.k.FinderLiveOnliveWidget_desc_height)) {
        this.GAY = Integer.valueOf((int)paramAttributeSet.getDimension(a.k.FinderLiveOnliveWidget_desc_height, 0.0F));
      }
      if (paramAttributeSet.hasValue(a.k.FinderLiveOnliveWidget_desc_margin_left)) {
        this.GAZ = ((int)paramAttributeSet.getDimension(a.k.FinderLiveOnliveWidget_desc_margin_left, 0.0F));
      }
      if (paramAttributeSet.hasValue(a.k.FinderLiveOnliveWidget_desc_margin_right)) {
        this.GBb = ((int)paramAttributeSet.getDimension(a.k.FinderLiveOnliveWidget_desc_margin_right, 0.0F));
      }
      if (paramAttributeSet.hasValue(a.k.FinderLiveOnliveWidget_desc_color)) {
        this.GBd = paramAttributeSet.getColor(a.k.FinderLiveOnliveWidget_desc_color, this.GAS);
      }
      if (paramAttributeSet.hasValue(a.k.FinderLiveOnliveWidget_desc_text_size)) {
        this.descTextSize = ((int)paramAttributeSet.getDimension(a.k.FinderLiveOnliveWidget_desc_text_size, 0.0F));
      }
      if (paramAttributeSet.hasValue(a.k.FinderLiveOnliveWidget_desc_text_bold)) {
        this.GBe = paramAttributeSet.getBoolean(a.k.FinderLiveOnliveWidget_desc_text_bold, false);
      }
      if (paramAttributeSet.hasValue(a.k.FinderLiveOnliveWidget_customBackground)) {
        this.GAH = paramAttributeSet.getDrawable(a.k.FinderLiveOnliveWidget_customBackground);
      }
      paramAttributeSet.recycle();
      if (BuildInfo.DEBUG)
      {
        paramAttributeSet = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[initAttribute],mode:").append(this.mode).append(",logoStyle:").append(this.GAG).append(",logoAnimationFile:").append(this.GAI).append(",logoColor:").append(this.GAS).append(",logoViewW:").append(getLogoViewW()).append(",logoViewH:").append(getLogoViewH()).append(",logoMarginLeft:").append(this.GAO).append(",logoMarginRight:").append(this.GAQ).append(",logoAnimAutoPlay").append(this.GAU).append(",\\n text:").append(this.desc).append(",descW:").append(getDescW()).append(",descH:");
        localStringBuilder.append(getDescH()).append(",descMarginLeft:").append(this.GAZ).append(",descMarginRight:").append(this.GBb).append(",descColor:").append(this.GBd).append(",descTextSize:").append(this.descTextSize);
        Log.i(paramAttributeSet, localStringBuilder.toString());
      }
      AppMethodBeat.o(344535);
      return;
      this.GAH = getContext().getResources().getDrawable(a.d.finder_live_logo_bg, null);
      this.GAS = getResources().getColor(a.b.White);
      this.GAM = Integer.valueOf(getContext().getResources().getDimensionPixelOffset(a.c.Edge_1_5_A));
      this.GAN = Integer.valueOf(getContext().getResources().getDimensionPixelOffset(a.c.Edge_1_5_A));
      this.GBd = getContext().getResources().getColor(a.b.White);
      this.descTextSize = d.e(getContext(), 10.0F);
      this.GAZ = d.e(getContext(), 2.0F);
      this.desc = getContext().getResources().getString(a.i.finder_onlive_status);
      this.GBe = false;
      break;
      this.GAH = getContext().getResources().getDrawable(a.d.finder_live_light_logo_bg, null);
      this.GAS = getResources().getColor(a.b.finder_live_logo_color);
      this.GAM = Integer.valueOf(getContext().getResources().getDimensionPixelOffset(a.c.Edge_1_5_A));
      this.GAN = Integer.valueOf(getContext().getResources().getDimensionPixelOffset(a.c.Edge_1_5_A));
      this.GBd = getContext().getResources().getColor(a.b.finder_live_logo_color);
      this.descTextSize = d.e(getContext(), 10.0F);
      this.GAZ = d.e(getContext(), 2.0F);
      this.desc = getContext().getResources().getString(a.i.finder_onlive_status);
      this.GBe = false;
      break;
      this.GAH = null;
      this.GAS = getResources().getColor(a.b.White);
      this.GAM = Integer.valueOf(getContext().getResources().getDimensionPixelOffset(a.c.Edge_3A));
      this.GAN = Integer.valueOf(getContext().getResources().getDimensionPixelOffset(a.c.Edge_3A));
      this.GBd = getContext().getResources().getColor(a.b.White);
      this.descTextSize = d.e(getContext(), 17.0F);
      this.GAZ = d.e(getContext(), 4.0F);
      this.desc = getContext().getResources().getString(a.i.finder_live_end);
      this.GBe = true;
      break;
      this.GAH = null;
      this.GAS = getResources().getColor(a.b.White);
      this.GAM = Integer.valueOf(getContext().getResources().getDimensionPixelOffset(a.c.Edge_2_5_A));
      this.GAN = Integer.valueOf(getContext().getResources().getDimensionPixelOffset(a.c.Edge_2_5_A));
      this.GBd = getContext().getResources().getColor(a.b.White);
      this.descTextSize = d.e(getContext(), 15.0F);
      this.GAZ = d.e(getContext(), 4.0F);
      this.desc = getContext().getResources().getString(a.i.finder_live_end);
      this.GBe = true;
      break;
      this.GAH = null;
      this.GAS = getResources().getColor(a.b.finder_live_logo_color);
      this.GAM = Integer.valueOf(getContext().getResources().getDimensionPixelOffset(a.c.Edge_A));
      this.GAN = Integer.valueOf(getContext().getResources().getDimensionPixelOffset(a.c.Edge_A));
      this.desc = "";
      break;
      this.GAT = false;
      this.GAV = true;
      this.GAW = paramAttributeSet.getResourceId(a.k.FinderLiveOnliveWidget_logo_image_src, 0);
    }
  }
  
  private final void fkU()
  {
    AppMethodBeat.i(344550);
    if (this.mode != 0) {
      setBackground(this.GAH);
    }
    AppMethodBeat.o(344550);
  }
  
  private final void fkW()
  {
    AppMethodBeat.i(344560);
    if (!this.GAV)
    {
      AppMethodBeat.o(344560);
      return;
    }
    if (this.GAK == null) {
      this.GAK = new ImageView(getContext());
    }
    Object localObject;
    if (this.GAW != 0)
    {
      localObject = this.GAK;
      if (localObject != null) {
        ((ImageView)localObject).setImageDrawable(f.b(getContext().getResources(), this.GAW, null));
      }
    }
    for (;;)
    {
      localObject = getLogoViewW();
      s.checkNotNull(localObject);
      int i = ((Integer)localObject).intValue();
      localObject = getLogoViewH();
      s.checkNotNull(localObject);
      localObject = new LinearLayout.LayoutParams(i, ((Integer)localObject).intValue());
      ((LinearLayout.LayoutParams)localObject).setMargins(this.GAO, this.GAP, this.GAQ, this.GAR);
      if (this.GAP == 0) {
        ((LinearLayout.LayoutParams)localObject).gravity = 16;
      }
      ImageView localImageView = this.GAK;
      if (localImageView != null) {
        localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      addView((View)this.GAK, 0);
      Log.i(TAG, s.X("showImage logoImgId:", Integer.valueOf(this.GAW)));
      AppMethodBeat.o(344560);
      return;
      localObject = this.GAK;
      if (localObject != null) {
        ((ImageView)localObject).setImageDrawable(bb.m(getContext(), a.h.finder_live_logo, this.GAS));
      }
    }
  }
  
  private final void fkX()
  {
    AppMethodBeat.i(344566);
    Object localObject = (CharSequence)this.desc;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(344566);
      return;
    }
    if (this.GAL == null) {
      this.GAL = new TextView(getContext());
    }
    localObject = getDescW();
    s.checkNotNull(localObject);
    i = ((Integer)localObject).intValue();
    localObject = getDescH();
    s.checkNotNull(localObject);
    localObject = new LinearLayout.LayoutParams(i, ((Integer)localObject).intValue());
    ((LinearLayout.LayoutParams)localObject).setMargins(this.GAZ, this.GBa, this.GBb, this.GBc);
    if (this.GAP == 0) {
      ((LinearLayout.LayoutParams)localObject).gravity = 16;
    }
    TextView localTextView = this.GAL;
    if (localTextView != null) {
      localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    localObject = this.GAL;
    if (localObject != null) {
      ((TextView)localObject).setText((CharSequence)this.desc);
    }
    localObject = this.GAL;
    if (localObject != null) {
      ((TextView)localObject).setGravity(16);
    }
    localObject = this.GAL;
    if (localObject != null) {
      ((TextView)localObject).setTextSize(0, this.descTextSize);
    }
    localObject = this.GAL;
    if (localObject != null) {
      ((TextView)localObject).setTextColor(this.GBd);
    }
    localObject = this.GAL;
    if (localObject != null) {
      ((TextView)localObject).setIncludeFontPadding(false);
    }
    if (this.GBe)
    {
      localObject = this.GAL;
      if (localObject == null)
      {
        localObject = null;
        com.tencent.mm.ui.aw.a((Paint)localObject, 0.8F);
      }
    }
    else
    {
      i = getChildCount();
      if (i < 0) {
        break label337;
      }
      if (i > 1) {
        break label332;
      }
      i = 1;
    }
    for (;;)
    {
      if (i == 0) {
        break label342;
      }
      addView((View)this.GAL, getChildCount());
      Log.i(TAG, s.X("showDesc desc:", this.desc));
      AppMethodBeat.o(344566);
      return;
      localObject = ((TextView)localObject).getPaint();
      break;
      label332:
      i = 0;
      continue;
      label337:
      i = 0;
    }
    label342:
    Log.i(TAG, "showDesc fail,childCount:" + getChildCount() + ", desc:" + this.desc);
    AppMethodBeat.o(344566);
  }
  
  private final Integer getDescH()
  {
    AppMethodBeat.i(344507);
    Integer localInteger = this.GAY;
    if (localInteger == null) {}
    while (this.GAY == null) {
      do
      {
        AppMethodBeat.o(344507);
        return Integer.valueOf(-2);
      } while (localInteger.intValue() == 0);
    }
    localInteger = this.GAY;
    AppMethodBeat.o(344507);
    return localInteger;
  }
  
  private final Integer getDescW()
  {
    AppMethodBeat.i(344504);
    Integer localInteger = this.GAX;
    if (localInteger == null) {}
    while (this.GAX == null) {
      do
      {
        AppMethodBeat.o(344504);
        return Integer.valueOf(-2);
      } while (localInteger.intValue() == 0);
    }
    localInteger = this.GAX;
    AppMethodBeat.o(344504);
    return localInteger;
  }
  
  private final Integer getLogoViewH()
  {
    AppMethodBeat.i(344500);
    Integer localInteger = this.GAN;
    if (localInteger == null) {}
    while (this.GAN == null) {
      do
      {
        AppMethodBeat.o(344500);
        return Integer.valueOf(-1);
      } while (localInteger.intValue() == 0);
    }
    localInteger = this.GAN;
    AppMethodBeat.o(344500);
    return localInteger;
  }
  
  private final Integer getLogoViewW()
  {
    AppMethodBeat.i(344489);
    Integer localInteger = this.GAM;
    if (localInteger == null) {}
    while (this.GAM == null) {
      do
      {
        AppMethodBeat.o(344489);
        return Integer.valueOf(-1);
      } while (localInteger.intValue() == 0);
    }
    localInteger = this.GAM;
    AppMethodBeat.o(344489);
    return localInteger;
  }
  
  private final void init()
  {
    AppMethodBeat.i(344544);
    setOrientation(0);
    exv();
    fkU();
    fkV();
    fkW();
    fkX();
    AppMethodBeat.o(344544);
  }
  
  public final void dxz()
  {
    AppMethodBeat.i(344607);
    PAGView localPAGView = this.GAJ;
    if (localPAGView != null) {
      localPAGView.stop();
    }
    AppMethodBeat.o(344607);
  }
  
  public final void exv()
  {
    AppMethodBeat.i(344588);
    Exception localException;
    if ((!this.GAT) && (!this.GAV) && (this.GAW == 0))
    {
      localException = new Exception("neither amin or logo been set");
      AppMethodBeat.o(344588);
      throw localException;
    }
    if ((this.GAT) && ((this.GAV) || (this.GAW != 0)))
    {
      localException = new Exception("either amin or logo been set");
      AppMethodBeat.o(344588);
      throw localException;
    }
    AppMethodBeat.o(344588);
  }
  
  public final void fkV()
  {
    AppMethodBeat.i(344595);
    if (!this.GAT)
    {
      AppMethodBeat.o(344595);
      return;
    }
    if (!a.isEnabled())
    {
      Log.i(TAG, "showAnim fail,pag not ready!");
      AppMethodBeat.o(344595);
      return;
    }
    if (this.GAJ == null) {
      this.GAJ = new PAGView(getContext());
    }
    Object localObject = getLogoViewW();
    s.checkNotNull(localObject);
    int i = ((Integer)localObject).intValue();
    localObject = getLogoViewH();
    s.checkNotNull(localObject);
    localObject = new LinearLayout.LayoutParams(i, ((Integer)localObject).intValue());
    ((LinearLayout.LayoutParams)localObject).setMargins(this.GAO, this.GAP, this.GAQ, this.GAR);
    if (this.GAP == 0) {
      ((LinearLayout.LayoutParams)localObject).gravity = 16;
    }
    PAGView localPAGView = this.GAJ;
    if (localPAGView != null) {
      localPAGView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    localObject = com.tencent.mm.plugin.expansions.b.yFu;
    if (com.tencent.mm.plugin.expansions.b.isInstalled("pag"))
    {
      if (Util.isNullOrNil(this.GAI)) {
        break label271;
      }
      localObject = this.GAJ;
      if (localObject != null) {
        ((PAGView)localObject).setFile(PAGFile.Load(getContext().getAssets(), this.GAI));
      }
    }
    for (;;)
    {
      addView((View)this.GAJ, 0);
      localObject = this.GAJ;
      if (localObject != null) {
        ((PAGView)localObject).setRepeatCount(-1);
      }
      if (this.GAU)
      {
        localObject = this.GAJ;
        if (localObject != null) {
          ((PAGView)localObject).play();
        }
      }
      Log.i(TAG, s.X("showAnim auto play:", Boolean.valueOf(this.GAU)));
      AppMethodBeat.o(344595);
      return;
      label271:
      if (this.GAS == getResources().getColor(a.b.finder_live_logo_color))
      {
        localObject = this.GAJ;
        if (localObject != null) {
          ((PAGView)localObject).setFile(PAGFile.Load(getContext().getAssets(), "finder_live_logo_amin_red.pag"));
        }
      }
      else
      {
        localObject = this.GAJ;
        if (localObject != null) {
          ((PAGView)localObject).setFile(PAGFile.Load(getContext().getAssets(), "finder_live_logo_amin_white.pag"));
        }
      }
    }
  }
  
  public final void fkY()
  {
    AppMethodBeat.i(344602);
    if (this.GAG == 1)
    {
      PAGView localPAGView = this.GAJ;
      if (localPAGView != null)
      {
        localPAGView.play();
        AppMethodBeat.o(344602);
      }
    }
    else
    {
      Log.e(TAG, s.X("playAnim error logoStyle:", Integer.valueOf(this.GAG)));
    }
    AppMethodBeat.o(344602);
  }
  
  public final String getText()
  {
    return this.desc;
  }
  
  public final void setLogoStyle(int paramInt)
  {
    this.GAG = paramInt;
  }
  
  public final void setText(String paramString)
  {
    AppMethodBeat.i(344623);
    s.u(paramString, "text");
    if (s.p(this.desc, paramString))
    {
      aCE("same text:" + paramString + '!');
      AppMethodBeat.o(344623);
      return;
    }
    if (indexOfChild((View)this.GAL) != -1)
    {
      removeView((View)this.GAL);
      Log.i(TAG, "hideDesc");
    }
    this.desc = paramString;
    fkX();
    AppMethodBeat.o(344623);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(344583);
    super.setVisibility(paramInt);
    PAGView localPAGView;
    if (paramInt != 0)
    {
      if (this.GAT)
      {
        localPAGView = this.GAJ;
        if (localPAGView != null)
        {
          localPAGView.stop();
          AppMethodBeat.o(344583);
        }
      }
    }
    else if ((this.GAU) && (this.GAT))
    {
      localPAGView = this.GAJ;
      if (localPAGView != null) {
        localPAGView.play();
      }
    }
    AppMethodBeat.o(344583);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderLiveOnliveWidget$Companion;", "", "()V", "DEFAULT_RED_ANIMATION_FILE", "", "DEFAULT_WHITE_ANIMATION_FILE", "LOGO_ANIM", "", "LOGO_IMAGE", "MODE_CARD_ONLIVE", "MODE_FINISH_STAGGERED_GRID_MASK", "MODE_FINISH_TIME_LINE_MASK", "MODE_NONE", "MODE_ONLIVE_LIGHT_RED", "MODE_ONLIVE_RED", "TAG", "getTAG", "()Ljava/lang/String;", "isEnabled", "", "loadPagLib", "", "tryLoadLibrary", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static boolean isEnabled()
    {
      AppMethodBeat.i(343968);
      com.tencent.mm.plugin.expansions.b localb = com.tencent.mm.plugin.expansions.b.yFu;
      boolean bool = com.tencent.mm.plugin.expansions.b.isInstalled("xlab");
      AppMethodBeat.o(343968);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderLiveOnliveWidget
 * JD-Core Version:    0.7.0.1
 */