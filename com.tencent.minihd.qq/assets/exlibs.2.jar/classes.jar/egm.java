import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.adapter.LebaListViewAdapter.CornerListItemHolder;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.widget.XListView;

class egm
  implements Runnable
{
  egm(egl paramegl, String paramString, Bitmap paramBitmap, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Egl.a.a == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        int j = this.jdField_a_of_type_Egl.a.a.getChildCount();
        int i = 0;
        if (i < j)
        {
          localObject = this.jdField_a_of_type_Egl.a.a.getChildAt(i);
          LebaListViewAdapter.CornerListItemHolder localCornerListItemHolder = (LebaListViewAdapter.CornerListItemHolder)((View)localObject).getTag();
          if ((localCornerListItemHolder == null) || (localCornerListItemHolder.a == null) || (localCornerListItemHolder.a.a == null) || (!this.jdField_a_of_type_JavaLangString.equals(localCornerListItemHolder.a.a.strPkgName))) {}
          for (;;)
          {
            i += 1;
            break;
            localObject = (ImageView)((View)localObject).findViewById(2131297527);
            if (localObject != null) {
              ((ImageView)localObject).setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
            }
          }
        }
      } while (this.jdField_a_of_type_Boolean);
      localObject = this.jdField_a_of_type_Egl.a.a.findViewWithTag(this.jdField_a_of_type_JavaLangString);
    } while ((localObject == null) || (!(localObject instanceof ImageView)));
    ((ImageView)localObject).setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     egm
 * JD-Core Version:    0.7.0.1
 */