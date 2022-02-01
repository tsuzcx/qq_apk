package cooperation.qwallet.plugin;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.util.SizeMeasure;

public class QWalletLoadingDialog
  extends Dialog
{
  Context jdField_a_of_type_AndroidContentContext = null;
  Animatable jdField_a_of_type_AndroidGraphicsDrawableAnimatable = null;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  
  public QWalletLoadingDialog(Context paramContext)
  {
    this(paramContext, 2131558900);
  }
  
  public QWalletLoadingDialog(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    a(paramContext);
  }
  
  private void a()
  {
    Window localWindow = getWindow();
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localLayoutParams.gravity = 53;
    localLayoutParams.width = SizeMeasure.e(this.jdField_a_of_type_AndroidContentContext);
    localLayoutParams.height = -1;
    localLayoutParams.windowAnimations = 0;
    localWindow.setAttributes(localLayoutParams);
  }
  
  protected void a(Context paramContext)
  {
    super.requestWindowFeature(1);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    paramContext = LayoutInflater.from(paramContext).inflate(2130904149, null);
    setContentView(paramContext);
    Object localObject = getWindow();
    WindowManager.LayoutParams localLayoutParams = ((Window)localObject).getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
    ((Window)localObject).setAttributes(localLayoutParams);
    setCanceledOnTouchOutside(false);
    localObject = (TextView)paramContext.findViewById(2131297357);
    if (localObject != null)
    {
      ((TextView)localObject).setVisibility(8);
      ((TextView)localObject).setText(2131366374);
    }
    localObject = paramContext.findViewById(2131297358);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131297348));
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131365030);
    }
    paramContext = (ImageView)paramContext.findViewById(2131301012);
    if (paramContext != null)
    {
      paramContext.setVisibility(0);
      paramContext.setImageResource(2130840834);
    }
    paramContext = (ImageView)super.findViewById(2131301014);
    localObject = new TranslateAnimation(1, -1.0F, 2, 1.0F, 1, 0.0F, 1, 0.0F);
    ((TranslateAnimation)localObject).setDuration(3000L);
    ((TranslateAnimation)localObject).setRepeatCount(-1);
    paramContext.startAnimation((Animation)localObject);
    super.setCancelable(false);
    a();
  }
  
  public void dismiss()
  {
    super.dismiss();
    if (this.jdField_a_of_type_AndroidGraphicsDrawableAnimatable != null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimatable.stop();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    this.jdField_a_of_type_AndroidGraphicsDrawableAnimatable = ((Animatable)this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838136));
    if ((this.jdField_a_of_type_AndroidGraphicsDrawableAnimatable != null) && (this.jdField_a_of_type_AndroidWidgetTextView != null))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(10);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable)this.jdField_a_of_type_AndroidGraphicsDrawableAnimatable, null, null, null);
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimatable.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qwallet.plugin.QWalletLoadingDialog
 * JD-Core Version:    0.7.0.1
 */