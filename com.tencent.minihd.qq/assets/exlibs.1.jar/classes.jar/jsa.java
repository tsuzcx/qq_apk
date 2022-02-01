import android.content.Context;
import android.graphics.Color;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.richstatus.EditActivity;
import com.tencent.mobileqq.richstatus.RichStatusEditText;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.SignatureTemplateInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class jsa
  implements URLDrawable.URLDrawableListener
{
  public jsa(EditActivity paramEditActivity) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    this.a.d = true;
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (!NetworkUtil.e(BaseApplication.getContext())) {
      QQToast.a(this.a.getApplicationContext(), this.a.getBaseContext().getString(2131366979), 0).a();
    }
    this.a.d = true;
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    this.a.d = true;
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    this.a.d = false;
    EditActivity.a(this.a, false, this.a.d);
    if (EditActivity.a(this.a) != null) {
      EditActivity.a(this.a).setTextColor(Color.parseColor(EditActivity.a(this.a).e));
    }
    EditActivity.a(this.a).setBackgroundDrawable(null);
    EditActivity.a(this.a).setBackgroundDrawable(paramURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jsa
 * JD-Core Version:    0.7.0.1
 */