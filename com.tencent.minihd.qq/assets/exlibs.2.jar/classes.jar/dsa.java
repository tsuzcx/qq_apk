import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.activity.Contacts;
import com.tencent.mobileqq.activity.Contacts.OverScrollViewTag;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.proxy.GroupActionResp;
import com.tencent.mobileqq.fpsreport.FPSPinnedHeaderExpandableListView;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

public class dsa
  extends FriendListObserver
{
  private dsa(Contacts paramContacts) {}
  
  protected void a(String paramString, byte paramByte1, byte paramByte2)
  {
    if ((paramString != null) && (this.a.jdField_a_of_type_Boolean)) {
      this.a.a(1400L, true);
    }
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_Boolean)) {
      this.a.a(1400L, true);
    }
  }
  
  protected void a(boolean paramBoolean, GroupActionResp paramGroupActionResp)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_Boolean)) {
      this.a.a(1400L, true);
    }
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_Boolean)) {
      this.a.a(1400L, true);
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      this.a.a(5000L, false);
    }
  }
  
  protected void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_Boolean)) {
      this.a.a(1400L, true);
    }
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_Boolean)) {
      this.a.a(1400L, true);
    }
  }
  
  protected void a(boolean paramBoolean, List paramList)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_Boolean)) {
      this.a.a(1400L, true);
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = this.a;
    if ((paramBoolean2) || (!paramBoolean1))
    {
      paramBoolean2 = true;
      ((Contacts)localObject).jdField_a_of_type_Boolean = paramBoolean2;
      paramBoolean2 = this.a.b;
      if (this.a.b)
      {
        if (this.a.jdField_a_of_type_Boolean)
        {
          this.a.b = false;
          if (!paramBoolean1) {
            break label201;
          }
          this.a.d();
          if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader != null) && (((Contacts.OverScrollViewTag)this.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.getTag()).jdField_a_of_type_Boolean))
          {
            localObject = (Contacts.OverScrollViewTag)this.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.getTag();
            this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 800L);
            ((Contacts.OverScrollViewTag)localObject).jdField_a_of_type_Boolean = false;
            this.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0);
          }
        }
        label145:
        localObject = this.a;
        if (!this.a.jdField_a_of_type_Boolean) {
          break label285;
        }
      }
    }
    label285:
    for (long l = 0L;; l = 1400L)
    {
      ((Contacts)localObject).a(l, true);
      if ((!paramBoolean2) && (this.a.jdField_a_of_type_Boolean)) {
        this.a.a(1400L, true);
      }
      return;
      paramBoolean2 = false;
      break;
      label201:
      if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader != null) && (((Contacts.OverScrollViewTag)this.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.getTag()).jdField_a_of_type_Boolean))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView.B();
        ((Contacts.OverScrollViewTag)this.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.getTag()).jdField_a_of_type_Boolean = false;
      }
      QQToast.a(this.a.getActivity(), 1, 2131366939, 0).b(this.a.e);
      break label145;
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramBoolean1) && (paramBoolean2) && (paramBoolean3)) {
      this.a.a(0L, true);
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    if ((paramBoolean1) && (paramBoolean2) && (paramBoolean3)) {
      this.a.a(1400L, true);
    }
  }
  
  protected void a(boolean paramBoolean, String[] paramArrayOfString)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_Boolean)) {
      this.a.a(1400L, true);
    }
  }
  
  protected void b(boolean paramBoolean, GroupActionResp paramGroupActionResp)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_Boolean)) {
      this.a.a(1400L, true);
    }
  }
  
  protected void b(boolean paramBoolean, List paramList)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_Boolean)) {
      this.a.a(1400L, true);
    }
  }
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      this.a.a(1400L, false);
    }
  }
  
  protected void b(boolean paramBoolean, String[] paramArrayOfString)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_Boolean)) {
      this.a.a(1400L, false);
    }
  }
  
  protected void c(boolean paramBoolean, GroupActionResp paramGroupActionResp)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_Boolean)) {
      this.a.a(1400L, true);
    }
  }
  
  protected void d(boolean paramBoolean, GroupActionResp paramGroupActionResp)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_Boolean)) {
      this.a.a(1400L, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dsa
 * JD-Core Version:    0.7.0.1
 */