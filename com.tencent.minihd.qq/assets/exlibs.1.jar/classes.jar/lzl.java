import android.view.View;
import android.view.View.OnClickListener;
import cooperation.qqfav.widget.FavoriteActionSheet;
import cooperation.qqfav.widget.FavoriteActionSheet.Actions;
import java.util.List;

public class lzl
  implements View.OnClickListener
{
  public lzl(FavoriteActionSheet paramFavoriteActionSheet) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.jdField_a_of_type_Boolean) || (this.a.jdField_a_of_type_CooperationQqfavWidgetFavoriteActionSheet$Actions == null)) {}
    int i;
    do
    {
      do
      {
        return;
        i = ((Integer)paramView.getTag()).intValue();
        this.a.jdField_a_of_type_Boolean = true;
        if (i >= this.a.jdField_a_of_type_JavaUtilList.size()) {
          break;
        }
        i = ((Integer)this.a.jdField_a_of_type_JavaUtilList.get(i)).intValue();
        if (i == 16)
        {
          this.a.jdField_a_of_type_CooperationQqfavWidgetFavoriteActionSheet$Actions.d();
          return;
        }
        if (i == 32)
        {
          this.a.jdField_a_of_type_CooperationQqfavWidgetFavoriteActionSheet$Actions.a();
          return;
        }
        if (i == 1)
        {
          this.a.jdField_a_of_type_CooperationQqfavWidgetFavoriteActionSheet$Actions.b();
          FavoriteActionSheet.a(this.a);
          return;
        }
        if (i == 2)
        {
          this.a.jdField_a_of_type_CooperationQqfavWidgetFavoriteActionSheet$Actions.e();
          return;
        }
        if (i == 4)
        {
          this.a.jdField_a_of_type_CooperationQqfavWidgetFavoriteActionSheet$Actions.f();
          return;
        }
      } while (i != 8);
      this.a.jdField_a_of_type_CooperationQqfavWidgetFavoriteActionSheet$Actions.c();
      return;
      i -= this.a.jdField_a_of_type_JavaUtilList.size();
    } while ((i < 0) || (i >= this.a.b.size()));
    this.a.jdField_a_of_type_CooperationQqfavWidgetFavoriteActionSheet$Actions.a((String)this.a.b.get(i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     lzl
 * JD-Core Version:    0.7.0.1
 */