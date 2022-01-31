package android.support.design.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.r;
import android.support.v4.view.t;
import android.support.v4.widget.q;
import android.support.v7.app.ActionBar.a;
import android.support.v7.c.a.a;
import android.support.v7.widget.bb;
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
  private View lX;
  private TabLayout.e mc;
  private TextView md;
  private ImageView me;
  private TextView mf;
  private ImageView mg;
  private int mh = 2;
  
  public TabLayout$g(TabLayout paramTabLayout, Context paramContext)
  {
    super(paramContext);
    if (paramTabLayout.lo != 0) {
      t.a(this, a.k(paramContext, paramTabLayout.lo));
    }
    t.d(this, paramTabLayout.lg, paramTabLayout.lh, paramTabLayout.li, paramTabLayout.lj);
    setGravity(17);
    setOrientation(1);
    setClickable(true);
    t.a(this, r.T(getContext()));
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
    if (this.mc != null)
    {
      localDrawable = this.mc.la;
      if (this.mc == null) {
        break label194;
      }
      localCharSequence2 = this.mc.mText;
      if (this.mc == null) {
        break label200;
      }
      localCharSequence1 = this.mc.lW;
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
    for (int j = this.lG.L(8);; j = 0)
    {
      if (j != paramTextView.bottomMargin)
      {
        paramTextView.bottomMargin = j;
        paramImageView.requestLayout();
      }
      if (i != 0) {}
      for (paramTextView = localObject;; paramTextView = localCharSequence1)
      {
        bb.a(this, paramTextView);
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
  
  final void i(TabLayout.e parame)
  {
    if (parame != this.mc)
    {
      this.mc = parame;
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
    int n = this.lG.getTabMaxWidth();
    int i = paramInt1;
    if (n > 0) {
      if (m != 0)
      {
        i = paramInt1;
        if (j <= n) {}
      }
      else
      {
        i = View.MeasureSpec.makeMeasureSpec(this.lG.lp, -2147483648);
      }
    }
    super.onMeasure(i, paramInt2);
    float f2;
    float f1;
    if (this.md != null)
    {
      getResources();
      f2 = this.lG.lm;
      j = this.mh;
      if ((this.me == null) || (this.me.getVisibility() != 0)) {
        break label289;
      }
      paramInt1 = 1;
      f1 = f2;
    }
    for (;;)
    {
      f2 = this.md.getTextSize();
      m = this.md.getLineCount();
      j = q.b(this.md);
      if ((f1 != f2) || ((j >= 0) && (paramInt1 != j)))
      {
        j = k;
        if (this.lG.mMode == 1)
        {
          j = k;
          if (f1 > f2)
          {
            j = k;
            if (m == 1)
            {
              Layout localLayout = this.md.getLayout();
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
          this.md.setTextSize(0, f1);
          this.md.setMaxLines(paramInt1);
          super.onMeasure(i, paramInt2);
        }
      }
      return;
      label289:
      paramInt1 = j;
      f1 = f2;
      if (this.md != null)
      {
        paramInt1 = j;
        f1 = f2;
        if (this.md.getLineCount() > 1)
        {
          f1 = this.lG.ln;
          paramInt1 = j;
        }
      }
    }
  }
  
  public final boolean performClick()
  {
    boolean bool2 = super.performClick();
    boolean bool1 = bool2;
    if (this.mc != null)
    {
      if (!bool2) {
        playSoundEffect(0);
      }
      this.mc.select();
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
      if (this.md != null) {
        this.md.setSelected(paramBoolean);
      }
      if (this.me != null) {
        this.me.setSelected(paramBoolean);
      }
      if (this.lX != null) {
        this.lX.setSelected(paramBoolean);
      }
      return;
    }
  }
  
  final void update()
  {
    TabLayout.e locale = this.mc;
    Object localObject;
    if (locale != null)
    {
      localObject = locale.lX;
      if (localObject == null) {
        break label305;
      }
      ViewParent localViewParent = ((View)localObject).getParent();
      if (localViewParent != this)
      {
        if (localViewParent != null) {
          ((ViewGroup)localViewParent).removeView((View)localObject);
        }
        addView((View)localObject);
      }
      this.lX = ((View)localObject);
      if (this.md != null) {
        this.md.setVisibility(8);
      }
      if (this.me != null)
      {
        this.me.setVisibility(8);
        this.me.setImageDrawable(null);
      }
      this.mf = ((TextView)((View)localObject).findViewById(16908308));
      if (this.mf != null) {
        this.mh = q.b(this.mf);
      }
      this.mg = ((ImageView)((View)localObject).findViewById(16908294));
      label140:
      if (this.lX != null) {
        break label338;
      }
      if (this.me == null)
      {
        localObject = (ImageView)LayoutInflater.from(getContext()).inflate(2130969308, this, false);
        addView((View)localObject, 0);
        this.me = ((ImageView)localObject);
      }
      if (this.md == null)
      {
        localObject = (TextView)LayoutInflater.from(getContext()).inflate(2130969309, this, false);
        addView((View)localObject);
        this.md = ((TextView)localObject);
        this.mh = q.b(this.md);
      }
      q.b(this.md, this.lG.lk);
      if (this.lG.ll != null) {
        this.md.setTextColor(this.lG.ll);
      }
      a(this.md, this.me);
      label281:
      if ((locale == null) || (!locale.isSelected())) {
        break label367;
      }
    }
    label305:
    label338:
    label367:
    for (boolean bool = true;; bool = false)
    {
      setSelected(bool);
      return;
      localObject = null;
      break;
      if (this.lX != null)
      {
        removeView(this.lX);
        this.lX = null;
      }
      this.mf = null;
      this.mg = null;
      break label140;
      if ((this.mf == null) && (this.mg == null)) {
        break label281;
      }
      a(this.mf, this.mg);
      break label281;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.design.widget.TabLayout.g
 * JD-Core Version:    0.7.0.1
 */