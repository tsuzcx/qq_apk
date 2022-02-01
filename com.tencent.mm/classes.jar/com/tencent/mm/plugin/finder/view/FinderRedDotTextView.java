package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d.b.g;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.j;
import com.tencent.mm.plugin.finder.loader.p;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;
import kotlin.k.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderRedDotTextView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dropStat", "getDropStat", "()I", "setDropStat", "(I)V", "endGapWidth", "highLightContainer", "Landroid/view/View;", "highLightIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "highLightTextView", "Landroid/widget/TextView;", "highLightTitleWidth", "", "isHasIcon", "", "lastIconUrl", "", "lineWithIconMaxWordCount", "mMaxWidth", "rowCount", "getRowCount", "setRowCount", "subTitleWidthWordCount", "titleTextView", "addPadding", "title", "needPaddingWidth", "paddingIndex", "adjustHighLightHeight", "", "adjustLayout", "maxWidth", "highlightTitle", "adjustLayoutParam", "adjustMarginEnd", "marginEnd", "view", "adjustMultiLineTitle", "adjustSingleLineTitle", "adjustSubTitle", "adjustTitleByNewLine", "adjustTitleWidth", "textView", "calcSubTitleMaxWidth", "isIncludeGap", "calcSubTitleWidthMaxWord", "dropSubTitle", "existSubTitle", "getHighLightHeight", "getHighLightIconWidth", "getMarginEnd", "getPaddingWordCount", "paddingWordWidth", "init", "isOldIconUrl", "iconUrl", "loadHighLightIcon", "highLightColor", "onFinishInflate", "onLoadFail", "onMultiLineAverageWordLine", "lastLineAvailableWidth", "onMultiLineTitle", "reset", "setInfo", "highlightTitleSizeDim", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderRedDotTextView
  extends FrameLayout
{
  public static final FinderRedDotTextView.a GBP;
  private String DlE;
  private View GBQ;
  private WeImageView GBR;
  private TextView GBS;
  private boolean GBT;
  private int GBU;
  private int GBV;
  private float GBW;
  private int GBX;
  private int endGapWidth;
  private TextView lzN;
  private int rowCount;
  private int vF;
  
  static
  {
    AppMethodBeat.i(344783);
    GBP = new FinderRedDotTextView.a((byte)0);
    AppMethodBeat.o(344783);
  }
  
  public FinderRedDotTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(344624);
    this.DlE = "";
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(344624);
  }
  
  public FinderRedDotTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(344630);
    this.DlE = "";
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(344630);
  }
  
  private static void a(int paramInt, TextView paramTextView)
  {
    AppMethodBeat.i(344677);
    ViewGroup.LayoutParams localLayoutParams = paramTextView.getLayoutParams();
    localLayoutParams.width = paramInt;
    paramTextView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(344677);
  }
  
  private static final void a(final FinderRedDotTextView paramFinderRedDotTextView, final String paramString, final int paramInt, com.tencent.mm.loader.g.a.a parama, g paramg, Bitmap paramBitmap)
  {
    AppMethodBeat.i(344739);
    kotlin.g.b.s.u(paramFinderRedDotTextView, "this$0");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(paramBitmap, paramFinderRedDotTextView, paramString, paramInt));
    AppMethodBeat.o(344739);
  }
  
  private static final void a(FinderRedDotTextView paramFinderRedDotTextView, String paramString, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(344749);
    kotlin.g.b.s.u(paramFinderRedDotTextView, "this$0");
    paramFinderRedDotTextView.fle();
    AppMethodBeat.o(344749);
  }
  
  private static final void a(String paramString, final FinderRedDotTextView paramFinderRedDotTextView, final int paramInt, boolean paramBoolean, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(344746);
    kotlin.g.b.s.u(paramFinderRedDotTextView, "this$0");
    Log.i("Finder.RedDotTextView", "setImageDownloadListener iconUrl:" + paramString + " success：" + paramBoolean);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new c(paramBoolean, paramFinderRedDotTextView, paramInt));
    AppMethodBeat.o(344746);
  }
  
  private final boolean aCF(String paramString)
  {
    AppMethodBeat.i(344645);
    if ((!Util.isNullOrNil(this.DlE)) && (kotlin.g.b.s.p(this.DlE, paramString)))
    {
      WeImageView localWeImageView = this.GBR;
      paramString = localWeImageView;
      if (localWeImageView == null)
      {
        kotlin.g.b.s.bIx("highLightIcon");
        paramString = null;
      }
      if (paramString.getDrawable() != null)
      {
        AppMethodBeat.o(344645);
        return true;
      }
    }
    AppMethodBeat.o(344645);
    return false;
  }
  
  private final boolean aCG(String paramString)
  {
    AppMethodBeat.i(344710);
    if ((!TextUtils.isEmpty((CharSequence)paramString)) || (this.GBT))
    {
      AppMethodBeat.o(344710);
      return true;
    }
    AppMethodBeat.o(344710);
    return false;
  }
  
  private final int aT(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(344651);
    if (paramBoolean) {}
    for (int i = this.endGapWidth;; i = 0)
    {
      int j = uY(this.GBT);
      AppMethodBeat.o(344651);
      return paramInt - i - j;
    }
  }
  
  private final String aq(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(344716);
    if ((paramInt2 > paramString.length()) || (paramInt1 == 0))
    {
      Log.e("Finder.RedDotTextView", "addPadding paddingIndex out of limit! needPaddingWidth:" + paramInt1 + " paddingIndex:" + paramInt2);
      AppMethodBeat.o(344716);
      return paramString;
    }
    TextView localTextView2 = this.lzN;
    TextView localTextView1 = localTextView2;
    if (localTextView2 == null)
    {
      kotlin.g.b.s.bIx("titleTextView");
      localTextView1 = null;
    }
    float f2 = localTextView1.getPaint().measureText(" ");
    float f1 = paramInt1 / f2;
    f2 = this.endGapWidth / f2;
    Log.i("Finder.RedDotTextView", "getPaddingWordCount :ret " + f1 + " ratio:" + f2);
    if ((f1 * 10.0F % 10.0F >= 4.0D) || (f2 <= 2.0D)) {}
    for (paramInt1 = (int)f1 + 1;; paramInt1 = (int)f1)
    {
      paramString = new StringBuilder(paramString);
      while (paramInt1 > 0)
      {
        paramString.append(" ");
        paramInt1 -= 1;
      }
    }
    Log.i("Finder.RedDotTextView", kotlin.g.b.s.X("addPadding :", paramString));
    paramString = paramString.toString();
    kotlin.g.b.s.s(paramString, "paddedTitleBuilder.toString()");
    AppMethodBeat.o(344716);
    return paramString;
  }
  
  private final void bH(int paramInt, String paramString)
  {
    AppMethodBeat.i(344672);
    Log.i("Finder.RedDotTextView", kotlin.g.b.s.X("dropSubTitle highlightTitle:", paramString));
    if (!aCG(paramString))
    {
      View localView = this.GBQ;
      paramString = localView;
      if (localView == null)
      {
        kotlin.g.b.s.bIx("highLightContainer");
        paramString = null;
      }
      paramString.setVisibility(8);
      a(this, paramInt);
      this.rowCount = 2;
      this.GBX = 2;
      AppMethodBeat.o(344672);
      return;
    }
    this.GBX = 1;
    AppMethodBeat.o(344672);
  }
  
  private final void fa(String paramString, int paramInt)
  {
    Object localObject = null;
    AppMethodBeat.i(344664);
    Log.i("Finder.RedDotTextView", "adjustTitleByNewLine direct padding new line");
    TextView localTextView = this.lzN;
    if (localTextView == null)
    {
      kotlin.g.b.s.bIx("titleTextView");
      localTextView = null;
      localTextView.setText((CharSequence)kotlin.g.b.s.X(paramString, "\n"));
      this.rowCount = 2;
      fld();
      a(this, paramInt);
      paramString = this.GBS;
      if (paramString != null) {
        break label99;
      }
      kotlin.g.b.s.bIx("highLightTextView");
      paramString = localObject;
    }
    label99:
    for (;;)
    {
      paramString.setMaxWidth(aT(paramInt, false));
      AppMethodBeat.o(344664);
      return;
      break;
    }
  }
  
  private final void fld()
  {
    Object localObject2 = null;
    AppMethodBeat.i(344724);
    Object localObject3 = this.GBQ;
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("highLightContainer");
      localObject1 = null;
    }
    localObject1 = ((View)localObject1).getLayoutParams();
    if (localObject1 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(344724);
      throw ((Throwable)localObject1);
    }
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localObject1;
    localObject3 = this.lzN;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("titleTextView");
      localObject1 = null;
    }
    localObject1 = ((TextView)localObject1).getPaint().getFontMetricsInt();
    localMarginLayoutParams.bottomMargin = ((((Paint.FontMetricsInt)localObject1).descent - ((Paint.FontMetricsInt)localObject1).ascent) / 2 - getHighLightHeight() / 2);
    localObject1 = this.GBQ;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("highLightContainer");
      localObject1 = localObject2;
    }
    for (;;)
    {
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localMarginLayoutParams);
      AppMethodBeat.o(344724);
      return;
    }
  }
  
  private final void fle()
  {
    AppMethodBeat.i(344732);
    WeImageView localWeImageView2 = this.GBR;
    WeImageView localWeImageView1 = localWeImageView2;
    if (localWeImageView2 == null)
    {
      kotlin.g.b.s.bIx("highLightIcon");
      localWeImageView1 = null;
    }
    localWeImageView1.setVisibility(4);
    AppMethodBeat.o(344732);
  }
  
  private final int getHighLightHeight()
  {
    AppMethodBeat.i(344728);
    int i = (int)getResources().getDimension(e.c.Edge_2A);
    TextView localTextView = this.GBS;
    Object localObject = localTextView;
    if (localTextView == null)
    {
      kotlin.g.b.s.bIx("highLightTextView");
      localObject = null;
    }
    localObject = ((TextView)localObject).getPaint().getFontMetricsInt();
    int j = ((Paint.FontMetricsInt)localObject).descent - ((Paint.FontMetricsInt)localObject).ascent;
    if ((this.GBT) && (i > j))
    {
      AppMethodBeat.o(344728);
      return i;
    }
    AppMethodBeat.o(344728);
    return j;
  }
  
  private final void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(344637);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, e.j.FinderRedDotTextView);
    kotlin.g.b.s.s(paramContext, "context.obtainStyledAttr…ble.FinderRedDotTextView)");
    try
    {
      this.endGapWidth = paramContext.getDimensionPixelSize(e.j.FinderRedDotTextView_endGapWidth, 0);
      paramContext.recycle();
      Log.i("Finder.RedDotTextView", kotlin.g.b.s.X("init : endGapWidth:", Integer.valueOf(this.endGapWidth)));
      AppMethodBeat.o(344637);
      return;
    }
    finally
    {
      paramContext.recycle();
      AppMethodBeat.o(344637);
    }
  }
  
  private static void o(int paramInt, View paramView)
  {
    AppMethodBeat.i(344696);
    Object localObject = paramView.getLayoutParams();
    if (localObject == null)
    {
      paramView = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(344696);
      throw paramView;
    }
    localObject = (ViewGroup.MarginLayoutParams)localObject;
    ((ViewGroup.MarginLayoutParams)localObject).setMarginEnd(paramInt);
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    AppMethodBeat.o(344696);
  }
  
  private final int uY(boolean paramBoolean)
  {
    AppMethodBeat.i(344656);
    if (paramBoolean)
    {
      int i = (int)getResources().getDimension(e.c.Edge_2A);
      AppMethodBeat.o(344656);
      return i;
    }
    AppMethodBeat.o(344656);
    return 0;
  }
  
  public final void a(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3)
  {
    AppMethodBeat.i(344868);
    Object localObject1 = new StringBuilder("maxWidth:").append(paramInt1).append("  title:").append(paramString1).append(" highlightTitle:").append(paramString2).append(" highLightColor:").append(paramInt3).append(" iconUrl:").append(paramString3).append(" end:");
    Object localObject2 = ((View)this).getLayoutParams();
    if (localObject2 == null)
    {
      paramString1 = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(344868);
      throw paramString1;
    }
    Log.i("Finder.RedDotTextView", ((ViewGroup.MarginLayoutParams)localObject2).getMarginEnd() + " width:" + getWidth());
    localObject1 = getLayoutParams();
    if (localObject1 == null)
    {
      paramString1 = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(344868);
      throw paramString1;
    }
    localObject1 = (ViewGroup.MarginLayoutParams)localObject1;
    if (((ViewGroup.MarginLayoutParams)localObject1).getMarginEnd() == 0)
    {
      ((ViewGroup.MarginLayoutParams)localObject1).setMarginEnd((int)getResources().getDimension(e.c.Edge_A));
      setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
    localObject1 = this.lzN;
    boolean bool;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("titleTextView");
      localObject1 = null;
      ((TextView)localObject1).setText((CharSequence)paramString1);
      localObject2 = this.lzN;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("titleTextView");
        localObject1 = null;
      }
      ((TextView)localObject1).setVisibility(0);
      if (Util.isNullOrNil(paramString3)) {
        break label458;
      }
      bool = true;
      label275:
      this.GBT = bool;
      this.vF = paramInt1;
      this.GBU = 0;
      this.GBV = 0;
      this.GBW = 0.0F;
      this.GBX = 0;
      this.rowCount = 1;
      if (this.endGapWidth == 0) {
        this.endGapWidth = ((int)getResources().getDimension(e.c.Edge_A));
      }
      b(this, 0);
      o((int)getResources().getDimension(e.c.Edge_A), (View)this);
      a(this, -2);
      if (paramInt1 > 0) {
        break label467;
      }
      Log.i("Finder.RedDotTextView", "setInfo: title:" + paramString1 + " maxWidth:" + paramInt1);
      paramString1 = this.lzN;
      if (paramString1 != null) {
        break label464;
      }
      kotlin.g.b.s.bIx("titleTextView");
      paramString1 = null;
    }
    label458:
    label464:
    for (;;)
    {
      paramString1.setText((CharSequence)"");
      paramString2 = this.GBQ;
      paramString1 = paramString2;
      if (paramString2 == null)
      {
        kotlin.g.b.s.bIx("highLightContainer");
        paramString1 = null;
      }
      paramString1.setVisibility(8);
      AppMethodBeat.o(344868);
      return;
      break;
      bool = false;
      break label275;
    }
    label467:
    if ((!TextUtils.isEmpty((CharSequence)paramString2)) || (this.GBT))
    {
      localObject2 = this.GBQ;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("highLightContainer");
        localObject1 = null;
      }
      ((View)localObject1).setVisibility(0);
      localObject2 = this.GBS;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("highLightTextView");
        localObject1 = null;
      }
      ((TextView)localObject1).setTextSize(0, getResources().getDimension(paramInt2));
      localObject2 = this.GBS;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("highLightTextView");
        localObject1 = null;
      }
      ((TextView)localObject1).setTextColor(paramInt3);
      localObject1 = this.GBS;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("highLightTextView");
        localObject1 = null;
        ((TextView)localObject1).setText((CharSequence)paramString2);
        if (!this.GBT) {
          break label1271;
        }
        if (paramString3 != null) {
          break label1074;
        }
        localObject1 = "";
        label629:
        if (!aCF((String)localObject1)) {
          break label1081;
        }
        localObject1 = this.GBR;
        paramString3 = (String)localObject1;
        if (localObject1 == null)
        {
          kotlin.g.b.s.bIx("highLightIcon");
          paramString3 = null;
        }
        paramString3.setIconColor(paramInt3);
        if (paramString1 != null) {
          break label1344;
        }
        paramString1 = "";
        if (paramString2 != null) {
          break label1347;
        }
        paramString2 = "";
      }
    }
    label669:
    label676:
    float f1;
    float f2;
    label1074:
    label1081:
    label1344:
    label1347:
    for (;;)
    {
      bool = this.GBT;
      localObject1 = this.GBS;
      paramString3 = (String)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("highLightTextView");
        paramString3 = null;
      }
      f1 = paramString3.getPaint().measureText(paramString2);
      i = uY(bool);
      paramInt3 = (int)(paramInt1 - f1 - i - this.endGapWidth);
      paramInt2 = paramInt3;
      if (paramInt3 < 0) {
        paramInt2 = 0;
      }
      localObject2 = (CharSequence)paramString1;
      paramInt3 = paramString1.length();
      localObject1 = this.lzN;
      paramString3 = (String)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("titleTextView");
        paramString3 = null;
      }
      localObject2 = new StaticLayout((CharSequence)localObject2, 0, paramInt3, paramString3.getPaint(), paramInt2, Layout.Alignment.ALIGN_NORMAL, 1.0F, 1.0F, true);
      this.GBU = ((StaticLayout)localObject2).getLineEnd(0);
      localObject1 = this.GBS;
      paramString3 = (String)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("highLightTextView");
        paramString3 = null;
      }
      this.GBW = (paramString3.getPaint().measureText(paramString2) + uY(bool) + this.endGapWidth);
      localObject1 = this.lzN;
      paramString3 = (String)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("titleTextView");
        paramString3 = null;
      }
      f2 = paramString3.getPaint().measureText("我");
      this.GBV = ((int)(this.GBW / f2));
      Log.i("Finder.RedDotTextView", "adjustLayout lineWithIconMaxWordCount:" + this.GBU + " subTitleWidthWordCount:" + this.GBV + " endGapWidth:" + this.endGapWidth);
      paramInt3 = (int)(i + f1 + this.endGapWidth);
      if (((StaticLayout)localObject2).getLineCount() != 1) {
        break label1350;
      }
      this.rowCount = 1;
      Log.i("Finder.RedDotTextView", kotlin.g.b.s.X("adjustSingleLineTitle:", paramString1));
      paramString3 = this.lzN;
      paramString2 = paramString3;
      if (paramString3 == null)
      {
        kotlin.g.b.s.bIx("titleTextView");
        paramString2 = null;
      }
      paramString2.setText((CharSequence)paramString1);
      b(this, paramInt3);
      fld();
      AppMethodBeat.o(344868);
      return;
      break;
      localObject1 = paramString3;
      break label629;
      localObject2 = this.GBR;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("highLightIcon");
        localObject1 = null;
      }
      ((WeImageView)localObject1).setVisibility(0);
      Log.i("Finder.RedDotTextView", "loadHighLightIcon: iconUrl" + paramString3 + " highLightColor:" + paramInt3);
      localObject1 = p.ExI;
      localObject1 = p.eCl();
      localObject2 = new com.tencent.mm.plugin.finder.loader.s(paramString3, v.FKZ);
      p localp = p.ExI;
      ((com.tencent.mm.loader.d)localObject1).a(localObject2, p.a(p.a.ExR)).a(new FinderRedDotTextView..ExternalSyntheticLambda2(this, paramString3, paramInt3)).a(new FinderRedDotTextView..ExternalSyntheticLambda0(paramString3, this, paramInt3)).a(new FinderRedDotTextView..ExternalSyntheticLambda1(this)).Td();
      localObject1 = this.GBR;
      paramString3 = (String)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("highLightIcon");
        paramString3 = null;
      }
      paramString3.setIconColor(paramInt3);
      break label669;
      label1271:
      localObject1 = this.GBR;
      paramString3 = (String)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("highLightIcon");
        paramString3 = null;
      }
      paramString3.setVisibility(8);
      break label669;
      localObject1 = this.GBQ;
      paramString3 = (String)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("highLightContainer");
        paramString3 = null;
      }
      paramString3.setVisibility(8);
      this.endGapWidth = 0;
      break label669;
      break label676;
    }
    label1350:
    Log.i("Finder.RedDotTextView", kotlin.g.b.s.X("onMultiLineAverageWordLine:", paramString1));
    localObject2 = (CharSequence)paramString1;
    paramInt2 = paramString1.length();
    localObject1 = this.lzN;
    paramString3 = (String)localObject1;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("titleTextView");
      paramString3 = null;
    }
    paramString3 = new StaticLayout((CharSequence)localObject2, 0, paramInt2, paramString3.getPaint(), paramInt1, Layout.Alignment.ALIGN_NORMAL, 1.0F, 1.0F, true);
    int i = paramString3.getLineEnd(0);
    int j = paramString1.length();
    Log.i("Finder.RedDotTextView", "titleWordCount :" + j + " fullLineMaxWordCount:" + i + " lineWithIconMaxWordCount:" + this.GBU);
    if ((j > this.GBU + i) || ((j == this.GBU + i) && (!TextUtils.isEmpty((CharSequence)paramString2))))
    {
      bH(paramInt1, paramString2);
      AppMethodBeat.o(344868);
      return;
    }
    if (paramString3.getLineCount() == 1)
    {
      Log.i("Finder.RedDotTextView", "onMultiLineAverageWordLine direct padding new line");
      fa(paramString1, paramInt1);
      AppMethodBeat.o(344868);
      return;
    }
    paramInt2 = k.qv((this.GBV + j) / 2, j);
    if (i - paramInt2 > 0) {
      paramInt2 += 1;
    }
    for (;;)
    {
      localObject1 = this.lzN;
      paramString3 = (String)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("titleTextView");
        paramString3 = null;
      }
      f1 = paramString3.getPaint().measureText(paramString1.subSequence(0, paramInt2).toString());
      localObject1 = this.lzN;
      paramString3 = (String)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("titleTextView");
        paramString3 = null;
      }
      f2 = paramString3.getPaint().measureText(paramString1.subSequence(paramInt2, j - paramInt2 + paramInt2).toString()) + this.GBW;
      float f3 = k.bt(f1, f2);
      if (paramInt1 < f3) {
        Log.e("Finder.RedDotTextView", "drop for content too long!");
      }
      i = (int)k.bu(k.bt(f1, f2), paramInt1);
      Log.i("Finder.RedDotTextView", "averageCount:" + paramInt2 + " firstLineWidth:" + f1 + " lastLineWidth:" + f2 + " viewWidth:" + i + " maxWidth:" + paramInt1);
      a(this, i);
      if ((i < this.GBW) && (!TextUtils.isEmpty((CharSequence)paramString1)))
      {
        if (j > paramInt2)
        {
          bool = true;
          paramInt1 = aT(i, bool);
          localObject1 = this.GBS;
          paramString3 = (String)localObject1;
          if (localObject1 == null)
          {
            kotlin.g.b.s.bIx("highLightTextView");
            paramString3 = null;
          }
          a(paramInt1, paramString3);
        }
      }
      else
      {
        Log.i("Finder.RedDotTextView", kotlin.g.b.s.X("onMultiLineTitle:", paramString1));
        localObject2 = (CharSequence)paramString1;
        paramInt1 = paramString1.length();
        localObject1 = this.lzN;
        paramString3 = (String)localObject1;
        if (localObject1 == null)
        {
          kotlin.g.b.s.bIx("titleTextView");
          paramString3 = null;
        }
        localObject2 = new StaticLayout((CharSequence)localObject2, 0, paramInt1, paramString3.getPaint(), i, Layout.Alignment.ALIGN_NORMAL, 1.0F, 1.0F, true);
        localObject1 = this.lzN;
        paramString3 = (String)localObject1;
        if (localObject1 == null)
        {
          kotlin.g.b.s.bIx("titleTextView");
          paramString3 = null;
        }
        paramInt1 = paramString3.getMaxLines();
        if (((StaticLayout)localObject2).getLineCount() < paramInt1) {
          break label2243;
        }
        paramString3 = paramString1.subSequence(((StaticLayout)localObject2).getLineEnd(paramInt1 - 2), paramString1.length()).toString();
        if (i - paramInt3 <= 0) {
          break label2161;
        }
        paramInt1 = i - paramInt3;
        label2016:
        Log.i("Finder.RedDotTextView", "preLastLineText:" + paramString3 + "  preLastLineWidth:" + paramInt1);
        localObject2 = (CharSequence)paramString3;
        paramInt2 = paramString3.length();
        localObject1 = this.lzN;
        paramString3 = (String)localObject1;
        if (localObject1 == null)
        {
          kotlin.g.b.s.bIx("titleTextView");
          paramString3 = null;
        }
        if (new StaticLayout((CharSequence)localObject2, 0, paramInt2, paramString3.getPaint(), paramInt1, Layout.Alignment.ALIGN_NORMAL, 1.0F, 1.0F, true).getLineCount() <= 1) {
          break label2166;
        }
      }
      label2161:
      label2166:
      for (bool = true;; bool = false)
      {
        Log.i("Finder.RedDotTextView", kotlin.g.b.s.X("onMultiLineTitle isNeedEllipse:", Boolean.valueOf(bool)));
        if (!bool) {
          break label2172;
        }
        bH(i, paramString2);
        AppMethodBeat.o(344868);
        return;
        bool = false;
        break;
        paramInt1 = 0;
        break label2016;
      }
      label2172:
      Log.i("Finder.RedDotTextView", kotlin.g.b.s.X("adjustMultiLineTitle:", paramString1));
      paramString2 = this.lzN;
      if (paramString2 == null)
      {
        kotlin.g.b.s.bIx("titleTextView");
        paramString2 = null;
      }
      for (;;)
      {
        paramString2.setText((CharSequence)aq(paramString1, paramInt3, paramString1.length()));
        this.rowCount = 2;
        fld();
        a(this, i);
        AppMethodBeat.o(344868);
        return;
      }
      label2243:
      fa(paramString1, i);
      AppMethodBeat.o(344868);
      return;
    }
  }
  
  public final int getDropStat()
  {
    return this.GBX;
  }
  
  public final int getRowCount()
  {
    return this.rowCount;
  }
  
  protected final void onFinishInflate()
  {
    AppMethodBeat.i(344834);
    super.onFinishInflate();
    af.mU(getContext()).inflate(e.f.red_dot_text_view, (ViewGroup)this, true);
    Object localObject = findViewById(e.e.red_dot_title);
    kotlin.g.b.s.s(localObject, "findViewById(R.id.red_dot_title)");
    this.lzN = ((TextView)localObject);
    localObject = findViewById(e.e.red_dot_highlight_container);
    kotlin.g.b.s.s(localObject, "findViewById(R.id.red_dot_highlight_container)");
    this.GBQ = ((View)localObject);
    localObject = findViewById(e.e.red_dot_highlight_title);
    kotlin.g.b.s.s(localObject, "findViewById(R.id.red_dot_highlight_title)");
    this.GBS = ((TextView)localObject);
    localObject = findViewById(e.e.red_dot_highlight_icon);
    kotlin.g.b.s.s(localObject, "findViewById(R.id.red_dot_highlight_icon)");
    this.GBR = ((WeImageView)localObject);
    TextView localTextView = this.GBS;
    localObject = localTextView;
    if (localTextView == null)
    {
      kotlin.g.b.s.bIx("highLightTextView");
      localObject = null;
    }
    aw.a((Paint)((TextView)localObject).getPaint(), 0.8F);
    AppMethodBeat.o(344834);
  }
  
  public final void setDropStat(int paramInt)
  {
    this.GBX = paramInt;
  }
  
  public final void setRowCount(int paramInt)
  {
    this.rowCount = paramInt;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(Bitmap paramBitmap, FinderRedDotTextView paramFinderRedDotTextView, String paramString, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(boolean paramBoolean, FinderRedDotTextView paramFinderRedDotTextView, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderRedDotTextView
 * JD-Core Version:    0.7.0.1
 */