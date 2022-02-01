package cooperation.plugin;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.widget.BounceScrollView;
import java.lang.reflect.Method;
import lxp;

public class PluginIphoneTitleBarActivity
  extends PluginBaseActivity
{
  public static final int s = 1;
  protected float a;
  private int jdField_a_of_type_Int;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  protected ViewGroup a;
  private boolean jdField_a_of_type_Boolean;
  private Drawable[] jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable;
  protected View.OnClickListener c = new lxp(this);
  protected TextView g;
  protected TextView h;
  protected TextView i;
  protected TextView j;
  protected ImageView k;
  
  private void b(Intent paramIntent)
  {
    ((FrameLayout)findViewById(16908290)).setForeground(getResources().getDrawable(2130841809));
    if (this.g == null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131297347));
      b(this.jdField_a_of_type_AndroidViewViewGroup);
      b();
      c();
      a();
      a(paramIntent);
    }
  }
  
  public static void b(View paramView)
  {
    if (paramView == null) {}
    while (Build.VERSION.SDK_INT <= 10) {
      return;
    }
    try
    {
      paramView.getClass().getMethod("setLayerType", new Class[] { Integer.TYPE, Paint.class }).invoke(paramView, new Object[] { Integer.valueOf(1), null });
      return;
    }
    catch (Exception paramView) {}
  }
  
  protected View a()
  {
    this.i = ((TextView)findViewById(2131297360));
    this.k = ((ImageView)findViewById(2131297361));
    b(this.i);
    b(this.k);
    return this.i;
  }
  
  public View a(int paramInt)
  {
    BounceScrollView localBounceScrollView = (BounceScrollView)View.inflate(this, 2130903129, null);
    View localView = View.inflate(this, paramInt, null);
    localBounceScrollView.addView(localView);
    setContentView(localBounceScrollView);
    return localView;
  }
  
  protected void a(int paramInt, View.OnClickListener paramOnClickListener)
  {
    this.g.setVisibility(8);
    this.g = ((TextView)findViewById(2131297358));
    b(this.g);
    this.g.setVisibility(0);
    this.g.setText(paramInt);
    if (paramOnClickListener == null)
    {
      this.g.setOnClickListener(this.c);
      return;
    }
    this.g.setOnClickListener(paramOnClickListener);
  }
  
  protected void a(Intent paramIntent)
  {
    if ((this.g != null) && ((this.g instanceof TextView)) && (paramIntent != null) && (paramIntent.getExtras() != null))
    {
      TextView localTextView = this.g;
      String str = paramIntent.getExtras().getString("leftViewText");
      paramIntent = str;
      if (str == null) {
        paramIntent = getString(2131366374);
      }
      localTextView.setText(paramIntent);
    }
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    if (paramBoolean)
    {
      requestWindowFeature(7);
      super.setContentView(paramView);
      getWindow().setFeatureInt(7, 2130903206);
      b(getIntent());
      return;
    }
    requestWindowFeature(1);
    super.setContentView(paramView);
  }
  
  public void a(CharSequence paramCharSequence, String paramString)
  {
    if ((this.h != null) && ((this.h instanceof TextView)))
    {
      this.h.setText(paramCharSequence);
      super.setTitle(paramString);
    }
  }
  
  protected View b()
  {
    this.g = ((TextView)findViewById(2131297357));
    this.g.setOnClickListener(this.c);
    b(this.g);
    return this.g;
  }
  
  public String b()
  {
    if ((this.h == null) || (this.h.getText() == null) || (this.h.getText().length() == 0)) {
      return getString(2131366374);
    }
    return this.h.getText().toString();
  }
  
  protected void b(int paramInt, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_Boolean = true;
    this.i.setVisibility(0);
    this.i.setText(paramInt);
    this.i.setEnabled(false);
    this.j = ((TextView)getLayoutInflater().inflate(2130903209, null));
    b(this.j);
    this.j.setText(paramInt);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(11, 1);
    localLayoutParams.addRule(15, 1);
    localLayoutParams.rightMargin = ((int)(8.0F * this.jdField_a_of_type_Float));
    this.jdField_a_of_type_AndroidViewViewGroup.addView(this.j, localLayoutParams);
    this.j.setVisibility(8);
    if (paramOnClickListener != null) {
      this.j.setOnClickListener(paramOnClickListener);
    }
  }
  
  protected boolean b()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130838136);
      this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable = this.h.getCompoundDrawables();
      this.jdField_a_of_type_Int = this.h.getCompoundDrawablePadding();
      this.h.setCompoundDrawablePadding(10);
      this.h.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[1], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[2], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[3]);
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
      return true;
    }
    return false;
  }
  
  protected View c()
  {
    this.h = ((TextView)findViewById(2131297348));
    return this.h;
  }
  
  public String c()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.h != null)
    {
      localObject1 = localObject2;
      if ((this.h instanceof TextView))
      {
        CharSequence localCharSequence = this.h.getText();
        localObject1 = localObject2;
        if (localCharSequence != null) {
          localObject1 = localCharSequence.toString();
        }
      }
    }
    return localObject1;
  }
  
  protected void c(int paramInt, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_Boolean = false;
    this.i.setVisibility(0);
    this.i.setText(paramInt);
    this.i.setEnabled(true);
    if (paramOnClickListener != null) {
      this.i.setOnClickListener(paramOnClickListener);
    }
  }
  
  protected void c(boolean paramBoolean)
  {
    if ((this.j == null) || (!this.jdField_a_of_type_Boolean)) {
      return;
    }
    if (paramBoolean)
    {
      this.i.setVisibility(8);
      this.j.setVisibility(0);
      return;
    }
    this.i.setVisibility(0);
    this.j.setVisibility(8);
  }
  
  protected boolean c()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      this.h.setCompoundDrawablePadding(this.jdField_a_of_type_Int);
      this.h.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[0], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[1], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[2], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[3]);
      return true;
    }
    return false;
  }
  
  public void g(int paramInt)
  {
    setContentView(paramInt);
    getWindow().setBackgroundDrawable(null);
  }
  
  public void h(int paramInt)
  {
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    requestWindowFeature(1);
    super.setContentView(paramInt);
    b(getIntent());
  }
  
  protected void i(int paramInt)
  {
    if ((this.g != null) && ((this.g instanceof TextView)))
    {
      String str2 = getString(paramInt);
      TextView localTextView = this.g;
      String str1;
      if (str2 != null)
      {
        str1 = str2;
        if (!"".equals(str2)) {}
      }
      else
      {
        str1 = getString(2131366374);
      }
      localTextView.setText(str1);
    }
  }
  
  @TargetApi(11)
  public void j()
  {
    if (Build.VERSION.SDK_INT == 16) {
      this.jdField_a_of_type_AndroidViewViewGroup.setLayerType(0, null);
    }
  }
  
  public boolean onBackEvent()
  {
    finish();
    return false;
  }
  
  public void setContentView(int paramInt)
  {
    boolean bool = true;
    Intent localIntent = getIntent();
    if (localIntent != null) {
      bool = localIntent.getBooleanExtra("showTitleBar", true);
    }
    if (bool) {
      requestWindowFeature(7);
    }
    super.setContentView(paramInt);
    if (bool) {
      getWindow().setFeatureInt(7, 2130903206);
    }
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    if (bool) {
      b(getIntent());
    }
  }
  
  public void setContentView(View paramView)
  {
    a(paramView, true);
  }
  
  public void setTitle(int paramInt)
  {
    setTitle(getString(paramInt));
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    if ((this.h != null) && ((this.h instanceof TextView)))
    {
      this.h.setText(paramCharSequence);
      super.setTitle(paramCharSequence);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.plugin.PluginIphoneTitleBarActivity
 * JD-Core Version:    0.7.0.1
 */