import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.Holder;
import com.tencent.mobileqq.utils.FileUtils;

public class fwo
  implements DialogInterface.OnClickListener
{
  public fwo(ShortVideoItemBuilder paramShortVideoItemBuilder, String paramString, ShortVideoItemBuilder.Holder paramHolder) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    FileUtils.d(this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder$Holder.b != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder$Holder.b.setImageResource(2130841673);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fwo
 * JD-Core Version:    0.7.0.1
 */