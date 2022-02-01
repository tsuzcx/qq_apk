import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.widget.HongbaoTextView;

public class lsc
  implements Runnable
{
  public lsc(HongbaoTextView paramHongbaoTextView, CharSequence paramCharSequence, int paramInt, Context paramContext, boolean paramBoolean) {}
  
  public void run()
  {
    String str = "";
    Intent localIntent = new Intent("hongbao_money_get");
    localIntent.putExtra("hb_count_tv", this.jdField_a_of_type_JavaLangCharSequence);
    if (this.jdField_a_of_type_Int == 2131299146) {
      localIntent.putExtra("hb_error_tv", true);
    }
    Object localObject1;
    boolean bool;
    Object localObject2;
    if ((this.jdField_a_of_type_AndroidContentContext instanceof ContextWrapper))
    {
      localObject1 = ((ContextWrapper)this.jdField_a_of_type_AndroidContentContext).getBaseContext();
      if ((localObject1 instanceof Activity))
      {
        localObject1 = (Activity)localObject1;
        bool = ((Activity)localObject1).getIntent().getBooleanExtra("from_float_aio", false);
        str = ((Activity)localObject1).getIntent().getStringExtra("from_float_nick");
        localObject2 = (TextView)((Activity)localObject1).findViewById(2131297708);
        if ((localObject2 != null) && (((TextView)localObject2).getVisibility() == 0)) {
          localIntent.putExtra("hb_yiling_tv", ((TextView)localObject2).getText());
        }
        localObject2 = (ImageView)((Activity)localObject1).findViewById(2131297704);
        if ((localObject2 != null) && (((ImageView)localObject2).getVisibility() == 0)) {
          localIntent.putExtra("pin_icon", true);
        }
      }
    }
    for (;;)
    {
      if (!bool) {}
      label285:
      do
      {
        for (;;)
        {
          return;
          try
          {
            if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentWidgetHongbaoTextView.getParent() != null))
            {
              localObject2 = (TextView)((View)this.jdField_a_of_type_ComTencentWidgetHongbaoTextView.getParent()).findViewById(2131299180);
              if (localObject2 != null)
              {
                localObject2 = ((TextView)localObject2).getText().toString();
                Log.i("app2", "setText name2=" + (String)localObject2 + " nickname=" + str);
                if ((localObject2 == null) || (!((String)localObject2).equals(str))) {
                  continue;
                }
                ((Activity)localObject1).getIntent().removeExtra("from_float_aio");
              }
            }
          }
          catch (Exception localException2)
          {
            break label285;
          }
        }
        this.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent);
      } while ((localObject1 == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangCharSequence)));
      try
      {
        ((Activity)localObject1).onKeyDown(4, null);
        return;
      }
      catch (Exception localException1)
      {
        ((Activity)localObject1).setResult(-1);
        ((Activity)localObject1).finish();
        return;
      }
      bool = false;
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     lsc
 * JD-Core Version:    0.7.0.1
 */