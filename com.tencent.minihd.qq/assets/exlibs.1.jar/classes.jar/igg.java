import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmoticonPageIndicator;
import com.tencent.mobileqq.emoticonview.EmoticonPagerAdapter;
import com.tencent.mobileqq.emoticonview.EmoticonViewBinder;
import com.tencent.mobileqq.emoticonview.RecentAndFavPanelViewBinder;
import com.tencent.mobileqq.widget.QQViewPager;
import java.util.ArrayList;
import java.util.List;

public class igg
  implements Runnable
{
  public igg(EmoticonMainPanel paramEmoticonMainPanel) {}
  
  public void run()
  {
    Object localObject;
    int i;
    int k;
    if ((EmoticonMainPanel.g == 1) && (EmoticonMainPanel.h == 0) && (this.a.b != null) && (this.a.b.size() > 0))
    {
      localObject = (EmoticonViewBinder)this.a.b.get(0);
      if ((localObject != null) && ((localObject instanceof RecentAndFavPanelViewBinder)))
      {
        localObject = (RecentAndFavPanelViewBinder)localObject;
        ((RecentAndFavPanelViewBinder)localObject).a(true);
        if (this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerAdapter != null) {
          this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerAdapter.notifyDataSetChanged();
        }
        this.a.jdField_a_of_type_JavaUtilList = this.a.b;
        i = ((RecentAndFavPanelViewBinder)localObject).b();
        k = ((RecentAndFavPanelViewBinder)localObject).a();
        this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPageIndicator.setRecent(true);
        if (i != 0) {
          break label258;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPageIndicator.setVisibility(4);
      }
    }
    for (;;)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localObject);
      int j = this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem();
      i = j;
      if (j >= k) {
        i = k - 1;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerAdapter != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerAdapter.a(localArrayList);
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerAdapter);
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(i, false);
        this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerAdapter.a(true);
      }
      return;
      label258:
      this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPageIndicator.setVisibility(0);
      this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPageIndicator.a(i, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     igg
 * JD-Core Version:    0.7.0.1
 */