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
import com.tencent.c.a.a.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.e;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.b.l;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.findersdk.d.a.a.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;
import kotlin.g.b.p;
import kotlin.l;
import org.libpag.PAGFile;
import org.libpag.PAGView;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderLiveOnliveWidget;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "customerBgDrawable", "Landroid/graphics/drawable/Drawable;", "desc", "", "descColor", "descH", "getDescH", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "descMarginBottom", "descMarginLeft", "descMarginRight", "descMarginTop", "descTextBold", "", "descTextSize", "descW", "getDescW", "logoAnimAutoPlay", "logoAnimation", "Lorg/libpag/PAGView;", "logoAnimationFile", "logoColor", "logoDesc", "Landroid/widget/TextView;", "logoImage", "Landroid/widget/ImageView;", "logoImgId", "logoMarginBottom", "logoMarginLeft", "logoMarginRight", "logoMarginTop", "logoStyle", "logoViewH", "getLogoViewH", "logoViewW", "getLogoViewW", "mode", "pngAnimation", "Lcom/tencent/mm/plugin/finder/view/FinderLiveLogoAnim;", "showLogoAnim", "showLogoImg", "showPngAnim", "checkState", "", "hideAnim", "hideDesc", "hideImage", "hidePngAnim", "init", "initAttribute", "playAnim", "setBackground", "setText", "text", "setVisibility", "visibility", "showAnim", "colorId", "showDebugLog", "msg", "showDesc", "showImage", "showLogo", "imageId", "showPagAnim", "stopAnim", "Companion", "plugin-finder_release"})
public final class FinderLiveOnliveWidget
  extends LinearLayout
{
  public static final a AZb;
  private static final String TAG = "Finder.LiveOnliveWidget";
  private int AYA;
  private Drawable AYB;
  private String AYC;
  private PAGView AYD;
  private FinderLiveLogoAnim AYE;
  private ImageView AYF;
  private TextView AYG;
  private Integer AYH;
  private Integer AYI;
  private int AYJ;
  private int AYK;
  private int AYL;
  private int AYM;
  private int AYN;
  private boolean AYO;
  private boolean AYP;
  private boolean AYQ;
  private boolean AYR;
  private int AYS;
  private Integer AYT;
  private Integer AYU;
  private int AYV;
  private int AYW;
  private int AYX;
  private int AYY;
  private int AYZ;
  private boolean AZa;
  private String desc;
  private int descTextSize;
  private int mode;
  
  static
  {
    AppMethodBeat.i(284770);
    AZb = new a((byte)0);
    TAG = "Finder.LiveOnliveWidget";
    Object localObject = a.Zlt;
    if (((Number)a.ilt().aSr()).intValue() == 0)
    {
      localObject = aj.AGc;
      aj.aFQ(String.valueOf(TAG));
      AppMethodBeat.o(284770);
      return;
    }
    Log.i(TAG, "tryLoadLibrary pag start " + ChannelUtil.isGPVersion());
    if ((!ChannelUtil.isGPVersion()) || (a.isEnabled()))
    {
      if (com.tencent.mm.kernel.h.aHB()) {
        break label123;
      }
      Log.e(TAG, "loadPagLib account is not ready");
    }
    for (;;)
    {
      Log.i(TAG, "tryLoadLibrary pag end");
      AppMethodBeat.o(284770);
      return;
      label123:
      com.tencent.mm.plugin.report.service.h.IzE.p(1279L, 200L, 1L);
      localObject = com.tencent.mm.plugin.expansions.d.vtq;
      com.tencent.mm.plugin.expansions.d.avY("pag");
      com.tencent.mm.plugin.report.service.h.IzE.p(1279L, 201L, 1L);
    }
  }
  
  public FinderLiveOnliveWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(284768);
    this.AYA = 3;
    this.AYH = Integer.valueOf(0);
    this.AYI = Integer.valueOf(0);
    this.AYT = Integer.valueOf(0);
    this.AYU = Integer.valueOf(0);
    this.descTextSize = com.tencent.mm.view.d.e(getContext(), 10.0F);
    b(paramAttributeSet, 0);
    init();
    AppMethodBeat.o(284768);
  }
  
  public FinderLiveOnliveWidget(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(284769);
    this.AYA = 3;
    this.AYH = Integer.valueOf(0);
    this.AYI = Integer.valueOf(0);
    this.AYT = Integer.valueOf(0);
    this.AYU = Integer.valueOf(0);
    this.descTextSize = com.tencent.mm.view.d.e(getContext(), 10.0F);
    b(paramAttributeSet, paramInt);
    init();
    AppMethodBeat.o(284769);
  }
  
  private static void aGx(String paramString)
  {
    AppMethodBeat.i(284767);
    aj localaj = aj.AGc;
    if (aj.eej()) {
      Log.d(TAG, paramString);
    }
    AppMethodBeat.o(284767);
  }
  
  private final void b(AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(284756);
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, b.l.FinderLiveOnliveWidget, paramInt, 0);
      this.mode = paramAttributeSet.getInt(b.l.FinderLiveOnliveWidget_logo_mode, 0);
      switch (this.mode)
      {
      default: 
        this.AYA = paramAttributeSet.getInt(b.l.FinderLiveOnliveWidget_logo_style, 3);
        if (this.AYA == 1)
        {
          this.AYO = true;
          this.AYQ = false;
          this.AYR = false;
          this.AYP = paramAttributeSet.getBoolean(b.l.FinderLiveOnliveWidget_logo_anim_auto_paly, false);
          this.AYC = paramAttributeSet.getString(b.l.FinderLiveOnliveWidget_animation_file);
        }
        break;
      }
    }
    for (;;)
    {
      if (paramAttributeSet.hasValue(b.l.FinderLiveOnliveWidget_logo_color)) {
        this.AYN = paramAttributeSet.getColor(b.l.FinderLiveOnliveWidget_logo_color, getResources().getColor(b.c.White));
      }
      if (paramAttributeSet.hasValue(b.l.FinderLiveOnliveWidget_logo_width)) {
        this.AYH = Integer.valueOf((int)paramAttributeSet.getDimension(b.l.FinderLiveOnliveWidget_logo_width, 0.0F));
      }
      if (paramAttributeSet.hasValue(b.l.FinderLiveOnliveWidget_logo_height)) {
        this.AYI = Integer.valueOf((int)paramAttributeSet.getDimension(b.l.FinderLiveOnliveWidget_logo_height, 0.0F));
      }
      if (paramAttributeSet.hasValue(b.l.FinderLiveOnliveWidget_logo_margin_left)) {
        this.AYJ = ((int)paramAttributeSet.getDimension(b.l.FinderLiveOnliveWidget_logo_margin_left, 0.0F));
      }
      if (paramAttributeSet.hasValue(b.l.FinderLiveOnliveWidget_logo_margin_right)) {
        this.AYL = ((int)paramAttributeSet.getDimension(b.l.FinderLiveOnliveWidget_logo_margin_right, 0.0F));
      }
      if (paramAttributeSet.hasValue(b.l.FinderLiveOnliveWidget_desc_text)) {
        this.desc = paramAttributeSet.getString(b.l.FinderLiveOnliveWidget_desc_text);
      }
      if (paramAttributeSet.hasValue(b.l.FinderLiveOnliveWidget_desc_width)) {
        this.AYT = Integer.valueOf((int)paramAttributeSet.getDimension(b.l.FinderLiveOnliveWidget_desc_width, 0.0F));
      }
      if (paramAttributeSet.hasValue(b.l.FinderLiveOnliveWidget_desc_height)) {
        this.AYU = Integer.valueOf((int)paramAttributeSet.getDimension(b.l.FinderLiveOnliveWidget_desc_height, 0.0F));
      }
      if (paramAttributeSet.hasValue(b.l.FinderLiveOnliveWidget_desc_margin_left)) {
        this.AYV = ((int)paramAttributeSet.getDimension(b.l.FinderLiveOnliveWidget_desc_margin_left, 0.0F));
      }
      if (paramAttributeSet.hasValue(b.l.FinderLiveOnliveWidget_desc_margin_right)) {
        this.AYX = ((int)paramAttributeSet.getDimension(b.l.FinderLiveOnliveWidget_desc_margin_right, 0.0F));
      }
      if (paramAttributeSet.hasValue(b.l.FinderLiveOnliveWidget_desc_color)) {
        this.AYZ = paramAttributeSet.getColor(b.l.FinderLiveOnliveWidget_desc_color, this.AYN);
      }
      if (paramAttributeSet.hasValue(b.l.FinderLiveOnliveWidget_desc_text_size)) {
        this.descTextSize = ((int)paramAttributeSet.getDimension(b.l.FinderLiveOnliveWidget_desc_text_size, 0.0F));
      }
      if (paramAttributeSet.hasValue(b.l.FinderLiveOnliveWidget_desc_text_bold)) {
        this.AZa = paramAttributeSet.getBoolean(b.l.FinderLiveOnliveWidget_desc_text_bold, false);
      }
      if (paramAttributeSet.hasValue(b.l.FinderLiveOnliveWidget_customBackground)) {
        this.AYB = paramAttributeSet.getDrawable(b.l.FinderLiveOnliveWidget_customBackground);
      }
      paramAttributeSet.recycle();
      if (BuildInfo.DEBUG) {
        Log.i(TAG, "[initAttribute],mode:" + this.mode + ",logoStyle:" + this.AYA + ",logoAnimationFile:" + this.AYC + ",logoColor:" + this.AYN + ",logoViewW:" + getLogoViewW() + ",logoViewH:" + getLogoViewH() + ',' + "logoMarginLeft:" + this.AYJ + ",logoMarginRight:" + this.AYL + ",logoAnimAutoPlay" + this.AYP + ",\\n text:" + this.desc + ",descW:" + getDescW() + ",descH:" + getDescH() + ",descMarginLeft:" + this.AYV + ",descMarginRight:" + this.AYX + ",descColor:" + this.AYZ + ",descTextSize:" + this.descTextSize);
      }
      AppMethodBeat.o(284756);
      return;
      Context localContext = getContext();
      p.j(localContext, "context");
      this.AYB = localContext.getResources().getDrawable(b.e.finder_live_logo_bg, null);
      this.AYN = getResources().getColor(b.c.White);
      localContext = getContext();
      p.j(localContext, "context");
      this.AYH = Integer.valueOf(localContext.getResources().getDimensionPixelOffset(b.d.Edge_1_5_A));
      localContext = getContext();
      p.j(localContext, "context");
      this.AYI = Integer.valueOf(localContext.getResources().getDimensionPixelOffset(b.d.Edge_1_5_A));
      localContext = getContext();
      p.j(localContext, "context");
      this.AYZ = localContext.getResources().getColor(b.c.White);
      this.descTextSize = com.tencent.mm.view.d.e(getContext(), 10.0F);
      this.AYV = com.tencent.mm.view.d.e(getContext(), 2.0F);
      localContext = getContext();
      p.j(localContext, "context");
      this.desc = localContext.getResources().getString(b.j.finder_onlive_status);
      this.AZa = false;
      break;
      localContext = getContext();
      p.j(localContext, "context");
      this.AYB = localContext.getResources().getDrawable(b.e.finder_live_light_logo_bg, null);
      this.AYN = getResources().getColor(b.c.finder_live_logo_color);
      localContext = getContext();
      p.j(localContext, "context");
      this.AYH = Integer.valueOf(localContext.getResources().getDimensionPixelOffset(b.d.Edge_1_5_A));
      localContext = getContext();
      p.j(localContext, "context");
      this.AYI = Integer.valueOf(localContext.getResources().getDimensionPixelOffset(b.d.Edge_1_5_A));
      localContext = getContext();
      p.j(localContext, "context");
      this.AYZ = localContext.getResources().getColor(b.c.finder_live_logo_color);
      this.descTextSize = com.tencent.mm.view.d.e(getContext(), 10.0F);
      this.AYV = com.tencent.mm.view.d.e(getContext(), 2.0F);
      localContext = getContext();
      p.j(localContext, "context");
      this.desc = localContext.getResources().getString(b.j.finder_onlive_status);
      this.AZa = false;
      break;
      this.AYB = null;
      this.AYN = getResources().getColor(b.c.White);
      localContext = getContext();
      p.j(localContext, "context");
      this.AYH = Integer.valueOf(localContext.getResources().getDimensionPixelOffset(b.d.Edge_3A));
      localContext = getContext();
      p.j(localContext, "context");
      this.AYI = Integer.valueOf(localContext.getResources().getDimensionPixelOffset(b.d.Edge_3A));
      localContext = getContext();
      p.j(localContext, "context");
      this.AYZ = localContext.getResources().getColor(b.c.White);
      this.descTextSize = com.tencent.mm.view.d.e(getContext(), 17.0F);
      this.AYV = com.tencent.mm.view.d.e(getContext(), 4.0F);
      localContext = getContext();
      p.j(localContext, "context");
      this.desc = localContext.getResources().getString(b.j.finder_live_end);
      this.AZa = true;
      break;
      this.AYB = null;
      this.AYN = getResources().getColor(b.c.White);
      localContext = getContext();
      p.j(localContext, "context");
      this.AYH = Integer.valueOf(localContext.getResources().getDimensionPixelOffset(b.d.Edge_2_5_A));
      localContext = getContext();
      p.j(localContext, "context");
      this.AYI = Integer.valueOf(localContext.getResources().getDimensionPixelOffset(b.d.Edge_2_5_A));
      localContext = getContext();
      p.j(localContext, "context");
      this.AYZ = localContext.getResources().getColor(b.c.White);
      this.descTextSize = com.tencent.mm.view.d.e(getContext(), 15.0F);
      this.AYV = com.tencent.mm.view.d.e(getContext(), 4.0F);
      localContext = getContext();
      p.j(localContext, "context");
      this.desc = localContext.getResources().getString(b.j.finder_live_end);
      this.AZa = true;
      break;
      this.AYB = null;
      this.AYN = getResources().getColor(b.c.finder_live_logo_color);
      localContext = getContext();
      p.j(localContext, "context");
      this.AYH = Integer.valueOf(localContext.getResources().getDimensionPixelOffset(b.d.Edge_A));
      localContext = getContext();
      p.j(localContext, "context");
      this.AYI = Integer.valueOf(localContext.getResources().getDimensionPixelOffset(b.d.Edge_A));
      this.desc = "";
      break;
      if (this.AYA == 2)
      {
        this.AYO = false;
        this.AYQ = true;
        this.AYR = false;
        this.AYP = paramAttributeSet.getBoolean(b.l.FinderLiveOnliveWidget_logo_anim_auto_paly, false);
      }
      else
      {
        this.AYO = false;
        this.AYQ = false;
        this.AYR = true;
        this.AYS = paramAttributeSet.getResourceId(b.l.FinderLiveOnliveWidget_logo_image_src, 0);
      }
    }
  }
  
  private final void dGj()
  {
    AppMethodBeat.i(284759);
    Throwable localThrowable;
    if ((!this.AYO) && (!this.AYQ) && (!this.AYR) && (this.AYS == 0))
    {
      localThrowable = (Throwable)new Exception("neither amin or logo been set");
      AppMethodBeat.o(284759);
      throw localThrowable;
    }
    if (((this.AYO) || (this.AYO)) && ((this.AYR) || (this.AYS != 0)))
    {
      localThrowable = (Throwable)new Exception("either amin or logo been set");
      AppMethodBeat.o(284759);
      throw localThrowable;
    }
    AppMethodBeat.o(284759);
  }
  
  private final void eiT()
  {
    AppMethodBeat.i(284761);
    if (!this.AYR)
    {
      AppMethodBeat.o(284761);
      return;
    }
    if (this.AYF == null) {
      this.AYF = new ImageView(getContext());
    }
    Object localObject1;
    Object localObject2;
    if (this.AYS != 0)
    {
      localObject1 = this.AYF;
      if (localObject1 != null)
      {
        localObject2 = getContext();
        p.j(localObject2, "context");
        ((ImageView)localObject1).setImageDrawable(f.b(((Context)localObject2).getResources(), this.AYS, null));
      }
    }
    for (;;)
    {
      localObject1 = getLogoViewW();
      if (localObject1 == null) {
        p.iCn();
      }
      int i = ((Integer)localObject1).intValue();
      localObject1 = getLogoViewH();
      if (localObject1 == null) {
        p.iCn();
      }
      localObject1 = new LinearLayout.LayoutParams(i, ((Integer)localObject1).intValue());
      ((LinearLayout.LayoutParams)localObject1).setMargins(this.AYJ, this.AYK, this.AYL, this.AYM);
      if (this.AYK == 0) {
        ((LinearLayout.LayoutParams)localObject1).gravity = 16;
      }
      localObject2 = this.AYF;
      if (localObject2 != null) {
        ((ImageView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      addView((View)this.AYF, 0);
      Log.i(TAG, "showImage logoImgId:" + this.AYS);
      AppMethodBeat.o(284761);
      return;
      localObject1 = this.AYF;
      if (localObject1 != null) {
        ((ImageView)localObject1).setImageDrawable(au.o(getContext(), b.i.finder_live_logo, this.AYN));
      }
    }
  }
  
  private final void eiU()
  {
    AppMethodBeat.i(284762);
    Object localObject = (CharSequence)this.desc;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(284762);
      return;
    }
    if (this.AYG == null) {
      this.AYG = new TextView(getContext());
    }
    localObject = getDescW();
    if (localObject == null) {
      p.iCn();
    }
    i = ((Integer)localObject).intValue();
    localObject = getDescH();
    if (localObject == null) {
      p.iCn();
    }
    localObject = new LinearLayout.LayoutParams(i, ((Integer)localObject).intValue());
    ((LinearLayout.LayoutParams)localObject).setMargins(this.AYV, this.AYW, this.AYX, this.AYY);
    if (this.AYK == 0) {
      ((LinearLayout.LayoutParams)localObject).gravity = 16;
    }
    TextView localTextView = this.AYG;
    if (localTextView != null) {
      localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    localObject = this.AYG;
    if (localObject != null) {
      ((TextView)localObject).setText((CharSequence)this.desc);
    }
    localObject = this.AYG;
    if (localObject != null) {
      ((TextView)localObject).setGravity(16);
    }
    localObject = this.AYG;
    if (localObject != null) {
      ((TextView)localObject).setTextSize(0, this.descTextSize);
    }
    localObject = this.AYG;
    if (localObject != null) {
      ((TextView)localObject).setTextColor(this.AYZ);
    }
    localObject = this.AYG;
    if (localObject != null) {
      ((TextView)localObject).setIncludeFontPadding(false);
    }
    if (this.AZa)
    {
      localObject = this.AYG;
      if (localObject != null)
      {
        localObject = ((TextView)localObject).getPaint();
        ar.a((Paint)localObject, 0.8F);
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
      AppMethodBeat.o(284762);
      return;
      localObject = null;
      break;
    }
    addView((View)this.AYG, getChildCount());
    Log.i(TAG, "showDesc desc:" + this.desc);
    AppMethodBeat.o(284762);
  }
  
  private final Integer getDescH()
  {
    AppMethodBeat.i(284754);
    Integer localInteger = this.AYU;
    if (localInteger == null) {}
    while (this.AYU == null) {
      do
      {
        AppMethodBeat.o(284754);
        return Integer.valueOf(-2);
      } while (localInteger.intValue() == 0);
    }
    localInteger = this.AYU;
    AppMethodBeat.o(284754);
    return localInteger;
  }
  
  private final Integer getDescW()
  {
    AppMethodBeat.i(284753);
    Integer localInteger = this.AYT;
    if (localInteger == null) {}
    while (this.AYT == null) {
      do
      {
        AppMethodBeat.o(284753);
        return Integer.valueOf(-2);
      } while (localInteger.intValue() == 0);
    }
    localInteger = this.AYT;
    AppMethodBeat.o(284753);
    return localInteger;
  }
  
  private final Integer getLogoViewH()
  {
    AppMethodBeat.i(284752);
    Integer localInteger = this.AYI;
    if (localInteger == null) {}
    while (this.AYI == null) {
      do
      {
        AppMethodBeat.o(284752);
        return Integer.valueOf(-1);
      } while (localInteger.intValue() == 0);
    }
    localInteger = this.AYI;
    AppMethodBeat.o(284752);
    return localInteger;
  }
  
  private final Integer getLogoViewW()
  {
    AppMethodBeat.i(284751);
    Integer localInteger = this.AYH;
    if (localInteger == null) {}
    while (this.AYH == null) {
      do
      {
        AppMethodBeat.o(284751);
        return Integer.valueOf(-1);
      } while (localInteger.intValue() == 0);
    }
    localInteger = this.AYH;
    AppMethodBeat.o(284751);
    return localInteger;
  }
  
  private final void init()
  {
    AppMethodBeat.i(284757);
    setOrientation(0);
    dGj();
    if (this.mode != 0) {
      setBackground(this.AYB);
    }
    Object localObject1;
    int i;
    if (this.AYO)
    {
      if (!a.isEnabled()) {
        Log.i(TAG, "showAnim fail,pag not ready!");
      }
    }
    else if (this.AYQ) {
      switch (this.mode)
      {
      default: 
        if (this.AYN == getResources().getColor(b.c.finder_live_logo_color))
        {
          localObject1 = FinderLiveLogoAnim.AYz;
          i = FinderLiveLogoAnim.eiQ();
        }
        break;
      }
    }
    for (;;)
    {
      if (this.AYE == null)
      {
        localObject1 = getContext();
        p.j(localObject1, "context");
        this.AYE = new FinderLiveLogoAnim((Context)localObject1, i);
      }
      localObject1 = getLogoViewW();
      if (localObject1 == null) {
        p.iCn();
      }
      int j = ((Integer)localObject1).intValue();
      localObject1 = getLogoViewH();
      if (localObject1 == null) {
        p.iCn();
      }
      localObject1 = new LinearLayout.LayoutParams(j, ((Integer)localObject1).intValue());
      ((LinearLayout.LayoutParams)localObject1).setMargins(this.AYJ, this.AYK, this.AYL, this.AYM);
      if (this.AYK == 0) {
        ((LinearLayout.LayoutParams)localObject1).gravity = 16;
      }
      Object localObject2 = this.AYE;
      if (localObject2 != null) {
        ((FinderLiveLogoAnim)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      addView((View)this.AYE, 0);
      if (this.AYP)
      {
        localObject1 = this.AYE;
        if (localObject1 != null) {
          ((FinderLiveLogoAnim)localObject1).cjx();
        }
      }
      Log.i(TAG, "showPngAnim auto play:" + this.AYP + ",pngAnimType:" + i);
      eiT();
      eiU();
      AppMethodBeat.o(284757);
      return;
      if (this.AYD == null) {
        this.AYD = new PAGView(getContext());
      }
      localObject1 = getLogoViewW();
      if (localObject1 == null) {
        p.iCn();
      }
      i = ((Integer)localObject1).intValue();
      localObject1 = getLogoViewH();
      if (localObject1 == null) {
        p.iCn();
      }
      localObject1 = new LinearLayout.LayoutParams(i, ((Integer)localObject1).intValue());
      ((LinearLayout.LayoutParams)localObject1).setMargins(this.AYJ, this.AYK, this.AYL, this.AYM);
      if (this.AYK == 0) {
        ((LinearLayout.LayoutParams)localObject1).gravity = 16;
      }
      localObject2 = this.AYD;
      if (localObject2 != null) {
        ((PAGView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      if (!Util.isNullOrNil(this.AYC))
      {
        localObject1 = this.AYD;
        if (localObject1 != null)
        {
          localObject2 = getContext();
          p.j(localObject2, "context");
          ((PAGView)localObject1).setFile(PAGFile.Load(((Context)localObject2).getAssets(), this.AYC));
        }
      }
      for (;;)
      {
        addView((View)this.AYD, 0);
        localObject1 = this.AYD;
        if (localObject1 != null) {
          ((PAGView)localObject1).setRepeatCount(-1);
        }
        if (this.AYP)
        {
          localObject1 = this.AYD;
          if (localObject1 != null) {
            ((PAGView)localObject1).play();
          }
        }
        Log.i(TAG, "showAnim auto play:" + this.AYP);
        break;
        if (this.AYN == getResources().getColor(b.c.finder_live_logo_color))
        {
          localObject1 = this.AYD;
          if (localObject1 != null)
          {
            localObject2 = getContext();
            p.j(localObject2, "context");
            ((PAGView)localObject1).setFile(PAGFile.Load(((Context)localObject2).getAssets(), "finder_live_logo_amin_red.pag"));
          }
        }
        else
        {
          localObject1 = this.AYD;
          if (localObject1 != null)
          {
            localObject2 = getContext();
            p.j(localObject2, "context");
            ((PAGView)localObject1).setFile(PAGFile.Load(((Context)localObject2).getAssets(), "finder_live_logo_amin_white.pag"));
          }
        }
      }
      localObject1 = FinderLiveLogoAnim.AYz;
      i = FinderLiveLogoAnim.eiS();
      continue;
      localObject1 = FinderLiveLogoAnim.AYz;
      i = FinderLiveLogoAnim.eiR();
    }
  }
  
  public final void cTg()
  {
    AppMethodBeat.i(284764);
    Object localObject = this.AYD;
    if (localObject != null) {
      ((PAGView)localObject).stop();
    }
    localObject = this.AYE;
    if (localObject != null)
    {
      ((FinderLiveLogoAnim)localObject).cTg();
      AppMethodBeat.o(284764);
      return;
    }
    AppMethodBeat.o(284764);
  }
  
  public final void eiV()
  {
    AppMethodBeat.i(284763);
    Object localObject;
    if (this.AYA == 1)
    {
      localObject = this.AYD;
      if (localObject != null)
      {
        ((PAGView)localObject).play();
        AppMethodBeat.o(284763);
        return;
      }
      AppMethodBeat.o(284763);
      return;
    }
    if (this.AYA == 2)
    {
      localObject = this.AYE;
      if (localObject != null)
      {
        ((FinderLiveLogoAnim)localObject).cjx();
        AppMethodBeat.o(284763);
        return;
      }
    }
    AppMethodBeat.o(284763);
  }
  
  public final void setText(String paramString)
  {
    AppMethodBeat.i(284766);
    p.k(paramString, "text");
    if (p.h(this.desc, paramString))
    {
      aGx("same text:" + paramString + '!');
      AppMethodBeat.o(284766);
      return;
    }
    if (indexOfChild((View)this.AYG) != -1)
    {
      removeView((View)this.AYG);
      Log.i(TAG, "hideDesc");
    }
    this.desc = paramString;
    eiU();
    AppMethodBeat.o(284766);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(284755);
    super.setVisibility(paramInt);
    Object localObject;
    if (paramInt != 0)
    {
      if (this.AYO)
      {
        localObject = this.AYD;
        if (localObject != null) {
          ((PAGView)localObject).stop();
        }
      }
      if (this.AYQ)
      {
        localObject = this.AYE;
        if (localObject != null)
        {
          ((FinderLiveLogoAnim)localObject).cTg();
          AppMethodBeat.o(284755);
          return;
        }
        AppMethodBeat.o(284755);
      }
    }
    else if (this.AYP)
    {
      if (this.AYO)
      {
        localObject = this.AYD;
        if (localObject != null) {
          ((PAGView)localObject).play();
        }
      }
      if (this.AYQ)
      {
        localObject = this.AYE;
        if (localObject != null)
        {
          ((FinderLiveLogoAnim)localObject).cjx();
          AppMethodBeat.o(284755);
          return;
        }
      }
    }
    AppMethodBeat.o(284755);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderLiveOnliveWidget$Companion;", "", "()V", "DEFAULT_RED_ANIMATION_FILE", "", "DEFAULT_WHITE_ANIMATION_FILE", "LOGO_ANIM", "", "LOGO_IMAGE", "LOGO_PNG_ANIM", "MODE_CARD_ONLIVE", "MODE_FINISH_STAGGERED_GRID_MASK", "MODE_FINISH_TIME_LINE_MASK", "MODE_NONE", "MODE_ONLIVE_LIGHT_RED", "MODE_ONLIVE_RED", "TAG", "getTAG", "()Ljava/lang/String;", "isEnabled", "", "loadPagLib", "", "tryLoadLibrary", "plugin-finder_release"})
  public static final class a
  {
    public static boolean isEnabled()
    {
      AppMethodBeat.i(279054);
      com.tencent.mm.plugin.expansions.d locald = com.tencent.mm.plugin.expansions.d.vtq;
      boolean bool = com.tencent.mm.plugin.expansions.d.awa("xlab");
      AppMethodBeat.o(279054);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderLiveOnliveWidget
 * JD-Core Version:    0.7.0.1
 */