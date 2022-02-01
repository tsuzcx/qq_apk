package NS_MOBILE_TEMPLATE_GIFT;

import NS_MOBILE_COMM.yellow_info;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class template_gift_type_list_rsp
  extends JceStruct
{
  static ArrayList cache_common_list;
  static ArrayList cache_diy_list;
  static yellow_info cache_user_yellow_info;
  public ArrayList common_list = null;
  public int common_total = 0;
  public ArrayList diy_list = null;
  public int diy_total = 0;
  public yellow_info user_yellow_info = null;
  
  public template_gift_type_list_rsp() {}
  
  public template_gift_type_list_rsp(ArrayList paramArrayList1, ArrayList paramArrayList2, int paramInt1, int paramInt2, yellow_info paramyellow_info)
  {
    this.diy_list = paramArrayList1;
    this.common_list = paramArrayList2;
    this.diy_total = paramInt1;
    this.common_total = paramInt2;
    this.user_yellow_info = paramyellow_info;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    Object localObject;
    if (cache_diy_list == null)
    {
      cache_diy_list = new ArrayList();
      localObject = new template_gift_type_item();
      cache_diy_list.add(localObject);
    }
    this.diy_list = ((ArrayList)paramJceInputStream.read(cache_diy_list, 0, true));
    if (cache_common_list == null)
    {
      cache_common_list = new ArrayList();
      localObject = new common_gift_type_item();
      cache_common_list.add(localObject);
    }
    this.common_list = ((ArrayList)paramJceInputStream.read(cache_common_list, 1, true));
    this.diy_total = paramJceInputStream.read(this.diy_total, 2, true);
    this.common_total = paramJceInputStream.read(this.common_total, 3, true);
    if (cache_user_yellow_info == null) {
      cache_user_yellow_info = new yellow_info();
    }
    this.user_yellow_info = ((yellow_info)paramJceInputStream.read(cache_user_yellow_info, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.diy_list, 0);
    paramJceOutputStream.write(this.common_list, 1);
    paramJceOutputStream.write(this.diy_total, 2);
    paramJceOutputStream.write(this.common_total, 3);
    if (this.user_yellow_info != null) {
      paramJceOutputStream.write(this.user_yellow_info, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_TEMPLATE_GIFT.template_gift_type_list_rsp
 * JD-Core Version:    0.7.0.1
 */