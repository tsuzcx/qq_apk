import android.os.Handler;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.profile.ProfileCardTemplateInfo;
import com.tencent.mobileqq.profile.VipProfileCardPreviewActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class jne
  implements Runnable
{
  public jne(VipProfileCardPreviewActivity paramVipProfileCardPreviewActivity) {}
  
  public void run()
  {
    int m = 0;
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "initTemplateListData start.");
    }
    if ((this.a.jdField_a_of_type_JavaUtilList == null) || (this.a.jdField_b_of_type_JavaUtilArrayList == null)) {
      return;
    }
    Object localObject2 = null;
    ArrayList localArrayList = this.a.a();
    if (this.a.jdField_b_of_type_Long == 0L)
    {
      localObject1 = new ProfileCardTemplate();
      ((ProfileCardTemplate)localObject1).h = 0L;
      ((ProfileCardTemplate)localObject1).m = "https://imgcache.gtimg.cn/club/mobile/profile/template/default_v_53.jpg";
      ((ProfileCardTemplate)localObject1).i = "https://imgcache.gtimg.cn/club/mobile/profile/template/default_v_53.jpg";
      ((ProfileCardTemplate)localObject1).o = "https://imgcache.gtimg.cn/club/mobile/profile/template/default_v_53.jpg";
      ((ProfileCardTemplate)localObject1).k = "https://imgcache.gtimg.cn/club/mobile/profile/template/default_v_53.jpg";
      ((ProfileCardTemplate)localObject1).g = "0";
      ((ProfileCardTemplate)localObject1).e = this.a.getString(2131369029);
      localArrayList.add(localObject1);
    }
    Object localObject1 = localObject2;
    int i;
    int k;
    int j;
    label266:
    ProfileCardTemplateInfo localProfileCardTemplateInfo;
    if (localArrayList != null)
    {
      localObject1 = localObject2;
      if (localArrayList.size() > 0)
      {
        localObject1 = new ArrayList();
        if (this.a.c)
        {
          i = 0;
          while (i < localArrayList.size())
          {
            localObject2 = (ProfileCardTemplate)localArrayList.get(i);
            if (this.a.jdField_a_of_type_Long == ((ProfileCardTemplate)localObject2).h) {
              this.a.av = i;
            }
            this.a.jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(((ProfileCardTemplate)localObject2).h));
            i += 1;
          }
        }
        i = 0;
        if (i < this.a.jdField_b_of_type_JavaUtilArrayList.size())
        {
          k = 0;
          j = 0;
          if (k < localArrayList.size())
          {
            localObject2 = (ProfileCardTemplate)localArrayList.get(k);
            if (((Long)this.a.jdField_b_of_type_JavaUtilArrayList.get(i)).longValue() != ((ProfileCardTemplate)localObject2).h) {
              break label750;
            }
            localProfileCardTemplateInfo = new ProfileCardTemplateInfo();
            localProfileCardTemplateInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = ((ProfileCardTemplate)localObject2);
            if (this.a.a(localProfileCardTemplateInfo))
            {
              localProfileCardTemplateInfo.jdField_a_of_type_Int = 2;
              label346:
              this.a.a(localProfileCardTemplateInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate);
              ((ArrayList)localObject1).add(localProfileCardTemplateInfo);
              j = 1;
            }
          }
        }
      }
    }
    label750:
    for (;;)
    {
      k += 1;
      break label266;
      localProfileCardTemplateInfo.jdField_a_of_type_Int = 0;
      break label346;
      if (j == 0)
      {
        this.a.jdField_b_of_type_JavaUtilArrayList.remove(i);
        if ((this.a.av > 0) && (i <= this.a.av))
        {
          localObject2 = this.a;
          ((VipProfileCardPreviewActivity)localObject2).av -= 1;
        }
        i -= 1;
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
        {
          this.a.jdField_a_of_type_JavaUtilList.clear();
          this.a.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject1);
          if (QLog.isColorLevel()) {
            i = m;
          }
        }
        else
        {
          while (i < this.a.jdField_a_of_type_JavaUtilList.size())
          {
            if (QLog.isColorLevel()) {
              QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "initTemplateListData, style : " + ((ProfileCardTemplateInfo)this.a.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.h + ", status : " + ((ProfileCardTemplateInfo)this.a.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Int + ", position : " + i);
            }
            i += 1;
            continue;
            localObject1 = new ArrayList();
            i = 0;
            if (i < localArrayList.size())
            {
              localObject2 = new ProfileCardTemplateInfo();
              ((ProfileCardTemplateInfo)localObject2).jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = ((ProfileCardTemplate)localArrayList.get(i));
              if (this.a.a((ProfileCardTemplateInfo)localObject2)) {}
              for (((ProfileCardTemplateInfo)localObject2).jdField_a_of_type_Int = 2;; ((ProfileCardTemplateInfo)localObject2).jdField_a_of_type_Int = 0)
              {
                this.a.a(((ProfileCardTemplateInfo)localObject2).jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate);
                ((ArrayList)localObject1).add(localObject2);
                i += 1;
                break;
              }
            }
            this.a.jdField_a_of_type_JavaUtilList.clear();
            this.a.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject1);
          }
        }
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jne
 * JD-Core Version:    0.7.0.1
 */