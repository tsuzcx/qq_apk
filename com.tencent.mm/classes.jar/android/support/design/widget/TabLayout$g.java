package android.support.design.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.design.a.h;
import android.support.v4.view.q;
import android.support.v7.app.ActionBar.a;
import android.support.v7.c.a.b;
import android.support.v7.widget.az;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

final class TabLayout$g
  extends LinearLayout
{
  private View la;
  private TabLayout.e lg;
  private TextView lh;
  private ImageView li;
  private TextView lj;
  private ImageView lk;
  private int ll = 2;
  
  public TabLayout$g(TabLayout paramTabLayout, Context paramContext)
  {
    super(paramContext);
    if (paramTabLayout.kq != 0) {
      q.a(this, b.g(paramContext, paramTabLayout.kq));
    }
    q.d(this, paramTabLayout.ki, paramTabLayout.kj, paramTabLayout.kk, paramTabLayout.kl);
    setGravity(17);
    setOrientation(1);
    setClickable(true);
    q.a(this, android.support.v4.view.o.S(getContext()));
  }
  
  private void a(TextView paramTextView, ImageView paramImageView)
  {
    Object localObject = null;
    Drawable localDrawable;
    CharSequence localCharSequence2;
    label35:
    CharSequence localCharSequence1;
    label51:
    label76:
    int i;
    if (this.lg != null)
    {
      localDrawable = this.lg.kc;
      if (this.lg == null) {
        break label194;
      }
      localCharSequence2 = this.lg.mText;
      if (this.lg == null) {
        break label200;
      }
      localCharSequence1 = this.lg.kZ;
      if (paramImageView != null)
      {
        if (localDrawable == null) {
          break label206;
        }
        paramImageView.setImageDrawable(localDrawable);
        paramImageView.setVisibility(0);
        setVisibility(0);
        paramImageView.setContentDescription(localCharSequence1);
      }
      if (TextUtils.isEmpty(localCharSequence2)) {
        break label220;
      }
      i = 1;
      label92:
      if (paramTextView != null)
      {
        if (i == 0) {
          break label225;
        }
        paramTextView.setText(localCharSequence2);
        paramTextView.setVisibility(0);
        setVisibility(0);
        label116:
        paramTextView.setContentDescription(localCharSequence1);
      }
      if (paramImageView != null)
      {
        paramTextView = (ViewGroup.MarginLayoutParams)paramImageView.getLayoutParams();
        if ((i == 0) || (paramImageView.getVisibility() != 0)) {
          break label245;
        }
      }
    }
    label194:
    label200:
    label206:
    label220:
    label225:
    label245:
    for (int j = this.kI.M(8);; j = 0)
    {
      if (j != paramTextView.bottomMargin)
      {
        paramTextView.bottomMargin = j;
        paramImageView.requestLayout();
      }
      if (i != 0) {}
      for (paramTextView = localObject;; paramTextView = localCharSequence1)
      {
        az.a(this, paramTextView);
        return;
        localDrawable = null;
        break;
        localCharSequence2 = null;
        break label35;
        localCharSequence1 = null;
        break label51;
        paramImageView.setVisibility(8);
        paramImageView.setImageDrawable(null);
        break label76;
        i = 0;
        break label92;
        paramTextView.setVisibility(8);
        paramTextView.setText(null);
        break label116;
      }
    }
  }
  
  final void c(TabLayout.e parame)
  {
    if (parame != this.lg)
    {
      this.lg = parame;
      update();
    }
  }
  
  public final void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(ActionBar.a.class.getName());
  }
  
  public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName(ActionBar.a.class.getName());
  }
  
  public final void onMeasure(int paramInt1, int paramInt2)
  {
    int k = 1;
    int j = View.MeasureSpec.getSize(paramInt1);
    int m = View.MeasureSpec.getMode(paramInt1);
    int n = this.kI.getTabMaxWidth();
    int i = paramInt1;
    if (n > 0) {
      if (m != 0)
      {
        i = paramInt1;
        if (j <= n) {}
      }
      else
      {
        i = View.MeasureSpec.makeMeasureSpec(this.kI.kr, -2147483648);
      }
    }
    super.onMeasure(i, paramInt2);
    float f2;
    float f1;
    if (this.lh != null)
    {
      getResources();
      f2 = this.kI.ko;
      j = this.ll;
      if ((this.li == null) || (this.li.getVisibility() != 0)) {
        break label289;
      }
      paramInt1 = 1;
      f1 = f2;
    }
    for (;;)
    {
      f2 = this.lh.getTextSize();
      m = this.lh.getLineCount();
      j = android.support.v4.widget.o.b(this.lh);
      if ((f1 != f2) || ((j >= 0) && (paramInt1 != j)))
      {
        j = k;
        if (this.kI.mMode == 1)
        {
          j = k;
          if (f1 > f2)
          {
            j = k;
            if (m == 1)
            {
              Layout localLayout = this.lh.getLayout();
              if (localLayout != null)
              {
                f2 = localLayout.getLineWidth(0);
                j = k;
                if (f1 / localLayout.getPaint().getTextSize() * f2 <= getMeasuredWidth() - getPaddingLeft() - getPaddingRight()) {}
              }
              else
              {
                j = 0;
              }
            }
          }
        }
        if (j != 0)
        {
          this.lh.setTextSize(0, f1);
          this.lh.setMaxLines(paramInt1);
          super.onMeasure(i, paramInt2);
        }
      }
      return;
      label289:
      paramInt1 = j;
      f1 = f2;
      if (this.lh != null)
      {
        paramInt1 = j;
        f1 = f2;
        if (this.lh.getLineCount() > 1)
        {
          f1 = this.kI.kp;
          paramInt1 = j;
        }
      }
    }
  }
  
  public final boolean performClick()
  {
    boolean bool2 = super.performClick();
    boolean bool1 = bool2;
    if (this.lg != null)
    {
      if (!bool2) {
        playSoundEffect(0);
      }
      this.lg.select();
      bool1 = true;
    }
    return bool1;
  }
  
  public final void setSelected(boolean paramBoolean)
  {
    if (isSelected() != paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      super.setSelected(paramBoolean);
      if ((i != 0) && (paramBoolean) && (Build.VERSION.SDK_INT < 16)) {
        sendAccessibilityEvent(4);
      }
      if (this.lh != null) {
        this.lh.setSelected(paramBoolean);
      }
      if (this.li != null) {
        this.li.setSelected(paramBoolean);
      }
      if (this.la != null) {
        this.la.setSelected(paramBoolean);
      }
      return;
    }
  }
  
  final void update()
  {
    TabLayout.e locale = this.lg;
    Object localObject;
    if (locale != null)
    {
      localObject = locale.la;
      if (localObject == null) {
        break label313;
      }
      ViewParent localViewParent = ((View)localObject).getParent();
      if (localViewParent != this)
      {
        if (localViewParent != null) {
          ((ViewGroup)localViewParent).removeView((View)localObject);
        }
        addView((View)localObject);
      }
      this.la = ((View)localObject);
      if (this.lh != null) {
        this.lh.setVisibility(8);
      }
      if (this.li != null)
      {
        this.li.setVisibility(8);
        this.li.setImageDrawable(null);
      }
      this.lj = ((TextView)((View)localObject).findViewById(16908308));
      if (this.lj != null) {
        this.ll = android.support.v4.widget.o.b(this.lj);
      }
      this.lk = ((ImageView)((View)localObject).findViewById(16908294));
      label143:
      if (this.la != null) {
        break label346;
      }
      if (this.li == null)
      {
        localObject = (ImageView)LayoutInflater.from(getContext()).inflate(a.h.design_layout_tab_icon, this, false);
        addView((View)localObject, 0);
        this.li = ((ImageView)localObject);
      }
      if (this.lh == null)
      {
        localObject = (TextView)LayoutInflater.from(getContext()).inflate(a.h.design_layout_tab_text, this, false);
        addView((View)localObject);
        this.lh = ((TextView)localObject);
        this.ll = android.support.v4.widget.o.b(this.lh);
      }
      android.support.v4.widget.o.b(this.lh, this.kI.km);
      if (this.kI.kn != null) {
        this.lh.setTextColor(this.kI.kn);
      }
      a(this.lh, this.li);
    }
    label313:
    label346:
    int i;
    for (;;)
    {
      if (locale != null)
      {
        if (locale.lb == null)
        {
          throw new IllegalArgumentException("Tab not attached to a TabLayout");
          localObject = null;
          break;
          if (this.la != null)
          {
            removeView(this.la);
            this.la = null;
          }
          this.lj = null;
          this.lk = null;
          break label143;
          if ((this.lj == null) && (this.lk == null)) {
            continue;
          }
          a(this.lj, this.lk);
          continue;
        }
        if (locale.lb.getSelectedTabPosition() == locale.mPosition)
        {
          i = 1;
          if (i == 0) {
            break label410;
          }
        }
      }
    }
    label410:
    for (boolean bool = true;; bool = false)
    {
      setSelected(bool);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.design.widget.TabLayout.g
 * JD-Core Version:    0.7.0.1
 */