import android.os.Handler;
import com.tencent.biz.helper.TroopInfoActivityHelper.IGetSameCityCheckTypeInfo;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupGeoInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.TagRecord;

public class fhk
  implements TroopInfoActivityHelper.IGetSameCityCheckTypeInfo
{
  public fhk(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void a()
  {
    TroopInfoActivity.b(this.a);
  }
  
  public void a(oidb_0x88d.GroupInfo paramGroupInfo)
  {
    TroopInfoActivity.a(this.a);
    if (paramGroupInfo != null)
    {
      if (paramGroupInfo.string_group_name.has()) {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.f = paramGroupInfo.string_group_name.get().toStringUtf8();
      }
      Object localObject1;
      if (paramGroupInfo.group_geo_info.has())
      {
        localObject1 = (oidb_0x88d.GroupGeoInfo)paramGroupInfo.group_geo_info.get();
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.d = ((int)((oidb_0x88d.GroupGeoInfo)localObject1).int64_latitude.get());
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e = ((int)((oidb_0x88d.GroupGeoInfo)localObject1).int64_longitude.get());
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.k = ((oidb_0x88d.GroupGeoInfo)localObject1).bytes_geocontent.get().toStringUtf8();
      }
      if (paramGroupInfo.uint32_group_class_ext.has()) {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Long = paramGroupInfo.uint32_group_class_ext.get();
      }
      if ((paramGroupInfo.rpt_tag_record.has()) && (paramGroupInfo.rpt_tag_record.size() > 0))
      {
        Object localObject2 = paramGroupInfo.rpt_tag_record.get();
        localObject1 = new ArrayList();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((List)localObject1).add(((oidb_0x88d.TagRecord)((Iterator)localObject2).next()).bytes_tag_value.get().toStringUtf8());
        }
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_JavaUtilList = ((List)localObject1);
      }
      if (paramGroupInfo.string_group_finger_memo.has()) {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.m = paramGroupInfo.string_group_rich_finger_memo.get().toStringUtf8();
      }
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
      TroopInfoActivity.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fhk
 * JD-Core Version:    0.7.0.1
 */