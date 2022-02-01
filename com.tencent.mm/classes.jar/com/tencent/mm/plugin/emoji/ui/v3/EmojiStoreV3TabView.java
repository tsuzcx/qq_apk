package com.tencent.mm.plugin.emoji.ui.v3;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.plugin.emoji.h.c;
import com.tencent.mm.plugin.emoji.h.d;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.ui.tools.v;
import com.tencent.mm.view.d;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/ui/v3/EmojiStoreV3TabView;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "index", "", "(Landroid/content/Context;I)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ENLAGE_SIZE_IN_DP", "TAG", "", "padding", "pointIV", "Landroid/widget/ImageView;", "titleTV", "Landroid/widget/TextView;", "total", "getTotal", "()I", "setTotal", "(I)V", "unreadTV", "buildDesc", "", "getText", "getUnread", "onLayout", "changed", "", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setTitleText", "resId", "str", "setTitleTextColor", "colors", "setTitleTextMedium", "setTitleTextSize", "pxValue", "", "setUnread", "unread", "showPoint", "show", "plugin-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class EmojiStoreV3TabView
  extends ViewGroup
{
  private final String TAG;
  private int index;
  TextView pJJ;
  private int padding;
  private int total;
  private final int yaO;
  private ImageView yaP;
  private TextView yaQ;
  
  public EmojiStoreV3TabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(270593);
    AppMethodBeat.o(270593);
  }
  
  public EmojiStoreV3TabView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(270585);
    this.TAG = "MicroMsg.EmojiStoreV3TabView";
    this.yaO = 2;
    this.total = 3;
    float f = com.tencent.mm.cd.a.br(paramContext, h.c.BigTextSize);
    this.pJJ = new TextView(paramContext);
    paramAttributeSet = this.pJJ;
    if (paramAttributeSet != null)
    {
      paramAttributeSet.setSingleLine();
      paramAttributeSet.setTextColor(paramAttributeSet.getResources().getColorStateList(h.b.FG_1));
      setTitleTextSize(f);
      paramAttributeSet.setText((CharSequence)"");
      addView((View)this.pJJ);
    }
    this.yaP = new ImageView(paramContext);
    paramAttributeSet = this.yaP;
    if (paramAttributeSet != null)
    {
      paramAttributeSet.setBackgroundResource(h.d.unread_dot_shape);
      paramAttributeSet.setVisibility(4);
      addView((View)this.yaP);
    }
    this.yaQ = new TextView(paramContext);
    paramAttributeSet = this.yaQ;
    if (paramAttributeSet != null)
    {
      paramAttributeSet.setTextColor(paramAttributeSet.getResources().getColor(h.b.white_text_color));
      paramAttributeSet.setTextSize(1, 11.0F);
      paramAttributeSet.setBackgroundResource(v.nH(paramContext));
      paramAttributeSet.setTypeface(Typeface.DEFAULT_BOLD);
      paramAttributeSet.setGravity(17);
      paramAttributeSet.setVisibility(4);
      addView((View)this.yaQ);
    }
    dCS();
    this.padding = getResources().getDimensionPixelSize(h.c.SmallestPadding);
    AppMethodBeat.o(270585);
  }
  
  private static final void a(TextView paramTextView, String paramString, EmojiStoreV3TabView paramEmojiStoreV3TabView)
  {
    AppMethodBeat.i(270602);
    s.u(paramTextView, "$it");
    s.u(paramString, "$unread");
    s.u(paramEmojiStoreV3TabView, "this$0");
    paramTextView.setText((CharSequence)paramString);
    paramTextView.setBackgroundResource(v.bC(paramEmojiStoreV3TabView.getContext(), Integer.parseInt(paramString)));
    paramEmojiStoreV3TabView.dCS();
    AppMethodBeat.o(270602);
  }
  
  private void dCS()
  {
    AppMethodBeat.i(270598);
    Log.d(this.TAG, "build: %d desc, unread: %s", new Object[] { Integer.valueOf(this.index), getUnread() });
    a.a.jlv().a((View)this, getText(), getUnread(), this.index);
    AppMethodBeat.o(270598);
  }
  
  public final String getText()
  {
    AppMethodBeat.i(270672);
    Object localObject = this.pJJ;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((TextView)localObject).getText())
    {
      localObject = String.valueOf(localObject);
      AppMethodBeat.o(270672);
      return localObject;
    }
  }
  
  public final int getTotal()
  {
    return this.total;
  }
  
  public final String getUnread()
  {
    AppMethodBeat.i(270677);
    Object localObject = this.yaQ;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((TextView)localObject).getText())
    {
      localObject = String.valueOf(localObject);
      AppMethodBeat.o(270677);
      return localObject;
    }
  }
  
  public final void ol(boolean paramBoolean)
  {
    AppMethodBeat.i(270626);
    ImageView localImageView = this.yaP;
    if (localImageView != null) {
      if (!paramBoolean) {
        break label33;
      }
    }
    label33:
    for (int i = 0;; i = 4)
    {
      localImageView.setVisibility(i);
      AppMethodBeat.o(270626);
      return;
    }
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(270647);
    paramInt3 -= paramInt1;
    paramInt1 = paramInt4 - paramInt2;
    Object localObject = this.pJJ;
    if (localObject != null)
    {
      paramInt2 = (paramInt3 - ((TextView)localObject).getMeasuredWidth()) / 2;
      paramInt4 = ((TextView)localObject).getMeasuredWidth() + paramInt2;
      int i = (paramInt1 - ((TextView)localObject).getMeasuredHeight()) / 2;
      ((TextView)localObject).layout(paramInt2, i, paramInt4, ((TextView)localObject).getMeasuredHeight() + i);
      localObject = this.yaP;
      if (localObject != null)
      {
        i = this.padding + paramInt4;
        int j = ((ImageView)localObject).getMeasuredWidth();
        int k = (paramInt1 - ((ImageView)localObject).getMeasuredHeight()) / 2;
        ((ImageView)localObject).layout(i, k, j + i, ((ImageView)localObject).getMeasuredHeight() + k);
      }
      localObject = this.yaQ;
      if (localObject != null)
      {
        if (paramInt2 - this.padding < ((TextView)localObject).getMeasuredWidth())
        {
          paramInt2 = paramInt3 - ((TextView)localObject).getMeasuredWidth();
          paramInt3 = ((TextView)localObject).getMeasuredWidth();
          paramInt1 = (paramInt1 - ((TextView)localObject).getMeasuredHeight()) / 2;
          ((TextView)localObject).layout(paramInt2, paramInt1, paramInt3 + paramInt2, ((TextView)localObject).getMeasuredHeight() + paramInt1);
          AppMethodBeat.o(270647);
          return;
        }
        paramInt2 = this.padding + paramInt4;
        paramInt3 = ((TextView)localObject).getMeasuredWidth();
        paramInt1 = (paramInt1 - ((TextView)localObject).getMeasuredHeight()) / 2;
        ((TextView)localObject).layout(paramInt2, paramInt1, paramInt3 + paramInt2, ((TextView)localObject).getMeasuredHeight() + paramInt1);
      }
    }
    AppMethodBeat.o(270647);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(270636);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    int i = getPaddingLeft();
    i = getPaddingRight() + (paramInt1 + i);
    Object localObject = this.yaP;
    if ((localObject != null) && (((ImageView)localObject).getVisibility() == 0))
    {
      paramInt1 = 1;
      if (paramInt1 == 0) {
        break label221;
      }
      localObject = this.yaP;
      if (localObject != null) {
        break label203;
      }
      paramInt1 = 0;
    }
    label63:
    label203:
    label221:
    for (paramInt1 = paramInt1 + i + d.e(getContext(), this.padding);; paramInt1 = i)
    {
      i = View.MeasureSpec.getSize(paramInt2) - getPaddingTop() - getPaddingBottom();
      if (View.MeasureSpec.getMode(paramInt2) == -2147483648) {}
      for (paramInt2 = View.MeasureSpec.makeMeasureSpec(i, -2147483648);; paramInt2 = View.MeasureSpec.makeMeasureSpec(0, 0))
      {
        localObject = this.pJJ;
        if (localObject != null) {
          ((TextView)localObject).measure(View.MeasureSpec.makeMeasureSpec(paramInt1, -2147483648), paramInt2);
        }
        localObject = this.yaP;
        if (localObject != null) {
          ((ImageView)localObject).measure(View.MeasureSpec.makeMeasureSpec(paramInt1, -2147483648), paramInt2);
        }
        localObject = this.yaQ;
        if (localObject != null) {
          ((TextView)localObject).measure(View.MeasureSpec.makeMeasureSpec(paramInt1, -2147483648), paramInt2);
        }
        setMeasuredDimension(paramInt1, i);
        AppMethodBeat.o(270636);
        return;
        paramInt1 = 0;
        break;
        paramInt1 = ((ImageView)localObject).getMeasuredWidth();
        break label63;
      }
    }
  }
  
  public final void setTitleText(int paramInt)
  {
    AppMethodBeat.i(270666);
    TextView localTextView = this.pJJ;
    if (localTextView != null) {
      localTextView.setText(paramInt);
    }
    AppMethodBeat.o(270666);
  }
  
  public final void setTitleText(String paramString)
  {
    AppMethodBeat.i(270662);
    s.u(paramString, "str");
    TextView localTextView = this.pJJ;
    if (localTextView != null) {
      localTextView.setText((CharSequence)paramString);
    }
    AppMethodBeat.o(270662);
  }
  
  public final void setTitleTextColor(int paramInt)
  {
    AppMethodBeat.i(270657);
    TextView localTextView = this.pJJ;
    if (localTextView != null) {
      localTextView.setTextColor(paramInt);
    }
    AppMethodBeat.o(270657);
  }
  
  public final void setTitleTextSize(float paramFloat)
  {
    AppMethodBeat.i(270653);
    Object localObject = LocaleUtil.getApplicationLanguage();
    boolean bool1 = LocaleUtil.isChineseAppLang();
    boolean bool2 = n.T((String)localObject, "en", true);
    if (bool1) {}
    for (int i = (int)(com.tencent.mm.cd.a.getScaleSize(getContext()) * com.tencent.mm.cd.a.fromDPToPix(getContext(), this.yaO));; i = 0)
    {
      localObject = this.pJJ;
      if (localObject != null)
      {
        ((TextView)localObject).setTextSize(0, paramFloat);
        if (bool1)
        {
          paramFloat = ((TextView)localObject).getTextSize();
          ((TextView)localObject).setTextSize(0, i + paramFloat);
          ((TextView)localObject).setTypeface(null, 0);
          AppMethodBeat.o(270653);
          return;
        }
        if (bool2) {
          ((TextView)localObject).setTypeface(null, 1);
        }
      }
      AppMethodBeat.o(270653);
      return;
    }
  }
  
  public final void setTotal(int paramInt)
  {
    this.total = paramInt;
  }
  
  public final void setUnread(String paramString)
  {
    AppMethodBeat.i(270681);
    s.u(paramString, "unread");
    if (Util.isNullOrNil(paramString))
    {
      paramString = this.yaQ;
      if (paramString != null) {
        paramString.setVisibility(4);
      }
      AppMethodBeat.o(270681);
      return;
    }
    TextView localTextView = this.yaQ;
    if (localTextView != null)
    {
      localTextView.setVisibility(0);
      localTextView.post(new EmojiStoreV3TabView..ExternalSyntheticLambda0(localTextView, paramString, this));
    }
    AppMethodBeat.o(270681);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v3.EmojiStoreV3TabView
 * JD-Core Version:    0.7.0.1
 */