import android.content.Intent;
import android.content.res.Resources;
import android.util.Pair;
import android.view.View;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QualityCheckBox;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.GestureSelectGridView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class gsq
  implements AdapterView.OnItemClickListener
{
  public gsq(PhotoListActivity paramPhotoListActivity) {}
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i = 1;
    if (!PhotoListActivity.c(this.a)) {
      PhotoListActivity.b(this.a, true);
    }
    switch (this.a.jdField_a_of_type_Gsv.getItemViewType(paramInt))
    {
    default: 
    case 0: 
    case 1: 
      label200:
      label218:
      label488:
      label493:
      do
      {
        do
        {
          do
          {
            return;
            if (this.a.jdField_a_of_type_Boolean)
            {
              paramAdapterView = this.a.jdField_a_of_type_Gsv.a(paramInt);
              PhotoListActivity.a(this.a, paramAdapterView.a);
              return;
            }
            localObject = this.a.jdField_a_of_type_Gsv;
            LocalMediaInfo localLocalMediaInfo = ((gsv)localObject).a(paramInt);
            paramInt = localLocalMediaInfo.jdField_b_of_type_Int;
            if ((paramInt == 2) && (this.a.jdField_a_of_type_JavaUtilArrayList.size() >= this.a.d))
            {
              QQToast.a(this.a, "最多只能选择" + this.a.d + "张图片", 0).b(this.a.e);
              return;
            }
            String str;
            if (paramInt == 1)
            {
              paramInt = 2;
              localLocalMediaInfo.jdField_b_of_type_Int = paramInt;
              if (localLocalMediaInfo.jdField_b_of_type_Int != 1) {
                break label488;
              }
              paramInt = i;
              str = localLocalMediaInfo.a;
              if (paramInt == 0) {
                break label493;
              }
              this.a.jdField_a_of_type_JavaUtilArrayList.add(str);
              if (PhotoListActivity.a(this.a) != null) {
                PhotoListActivity.a(this.a).a(str);
              }
              StatisticConstants.a(this.a.getIntent(), "param_totalSelNum");
              paramAdapterView = this.a.getIntent();
              if (!paramAdapterView.hasExtra("param_initTime")) {
                paramAdapterView.putExtra("param_initTime", System.currentTimeMillis());
              }
              paramView = (LinkedHashMap)AlbumUtil.b.get(PhotoListActivity.a(this.a));
              paramAdapterView = paramView;
              if (paramView == null)
              {
                paramAdapterView = new LinkedHashMap();
                AlbumUtil.b.put(PhotoListActivity.a(this.a), paramAdapterView);
              }
              paramAdapterView.put(str, Integer.valueOf(this.a.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.s()));
              paramAdapterView = AlbumUtil.c;
              if (!paramAdapterView.containsKey(str)) {
                paramAdapterView.put(str, new Pair(PhotoListActivity.a(this.a), PhotoListActivity.b(this.a)));
              }
            }
            for (;;)
            {
              ((gsv)localObject).notifyDataSetChanged();
              if (PhotoListActivity.b(this.a) == 2) {
                PhotoListActivity.b(this.a, localLocalMediaInfo.a);
              }
              PhotoListActivity.a(this.a);
              if (!this.a.jdField_a_of_type_ComTencentMobileqqWidgetQualityCheckBox.isChecked()) {
                break;
              }
              this.a.jdField_a_of_type_ComTencentMobileqqWidgetQualityCheckBox.setText(this.a.jdField_a_of_type_JavaUtilArrayList, PhotoListActivity.c(this.a));
              return;
              paramInt = 1;
              break label200;
              paramInt = 0;
              break label218;
              this.a.jdField_a_of_type_JavaUtilArrayList.remove(str);
              if (PhotoListActivity.a(this.a) != null) {
                PhotoListActivity.a(this.a).b(str);
              }
              StatisticConstants.a(this.a.getIntent(), "param_cancelSelNum");
              paramAdapterView = (HashMap)AlbumUtil.b.get(PhotoListActivity.a(this.a));
              if (paramAdapterView != null) {
                paramAdapterView.remove(str);
              }
              paramAdapterView = AlbumUtil.c;
              if (paramAdapterView.containsKey(str)) {
                paramAdapterView.remove(str);
              }
            }
            if (!this.a.jdField_a_of_type_JavaUtilArrayList.isEmpty())
            {
              paramAdapterView = DialogUtil.a(this.a, 230);
              paramAdapterView.setMessage("不能同时选择照片和视频");
              paramAdapterView.setPositiveButton(2131365737, new DialogUtil.DialogOnClickAdapter());
              paramAdapterView.show();
              return;
            }
            if (!Utils.e())
            {
              QQToast.a(this.a, this.a.getResources().getString(2131367289), 0).a();
              return;
            }
            paramAdapterView = this.a.jdField_a_of_type_Gsv.a(paramInt);
            if (paramAdapterView.jdField_b_of_type_Long <= PhotoListActivity.a(this.a)) {
              break;
            }
            paramAdapterView = DialogUtil.a(this.a, "你选择的视频文件过大，无法发送");
            paramAdapterView.setPositiveButton(2131365737, new DialogUtil.DialogOnClickAdapter());
            paramAdapterView.show();
          } while (!PhotoListActivity.d(this.a));
          paramAdapterView = this.a.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
          paramView = new Intent("key_video_size_overflow");
          paramView.putExtra("className", paramAdapterView);
          this.a.sendBroadcast(paramView);
          return;
          if ((!PhotoListActivity.d(this.a)) || (paramAdapterView.e - PhotoListActivity.b(this.a) <= 999L)) {
            break;
          }
          paramAdapterView = DialogUtil.a(this.a, "你选择的视频时间过长，无法发送");
          paramAdapterView.setPositiveButton(2131365737, new DialogUtil.DialogOnClickAdapter());
          paramAdapterView.show();
          paramAdapterView = this.a.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
        } while (!PhotoListActivity.d(this.a));
        paramView = new Intent("key_video_time_overflow");
        paramView.putExtra("className", paramAdapterView);
        this.a.sendBroadcast(paramView);
        return;
        paramView = AlbumUtil.c;
        if (!paramView.containsKey(paramAdapterView.a))
        {
          localObject = new Pair(PhotoListActivity.a(this.a), PhotoListActivity.b(this.a));
          paramView.put(paramAdapterView.a, localObject);
        }
        PhotoListActivity.c(this.a, paramAdapterView.a);
      } while (paramAdapterView == null);
      if (!PhotoListActivity.e(this.a))
      {
        paramView = this.a.getIntent();
        paramView.putExtra("file_send_path", paramAdapterView.a);
        paramView.putExtra("PhotoConst.IS_VIDEO_SELECTED", true);
        paramView.putExtra("PhotoConst.VIDEO_SIZE", paramAdapterView.jdField_b_of_type_Long);
        localObject = new ArrayList();
        ((ArrayList)localObject).add(paramAdapterView.a);
        PhotoUtils.a(this.a, paramView, (ArrayList)localObject, 2, false);
        return;
      }
      paramView = new Intent(this.a, ShortVideoPreviewActivity.class);
      paramView.putExtra("file_send_path", paramAdapterView.a);
      paramView.putExtra("file_send_size", paramAdapterView.jdField_b_of_type_Long);
      paramView.putExtra("file_send_duration", paramAdapterView.e);
      paramView.putExtra("uin", PhotoListActivity.d(this.a));
      paramView.putExtra("uintype", PhotoListActivity.c(this.a));
      paramView.putExtra("file_source", "album");
      Object localObject = this.a.getIntent();
      if (((Intent)localObject).getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false)) {
        paramView.putExtras((Intent)localObject);
      }
      paramView.putExtra("PhotoConst.IS_FROM_TROOP_BAR", PhotoListActivity.d(this.a));
      paramAdapterView = ((Intent)localObject).getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      localObject = ((Intent)localObject).getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
      paramView.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramAdapterView);
      paramView.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", (String)localObject);
      this.a.startActivityForResult(paramView, 17);
      return;
    }
    if (!Utils.e())
    {
      QQToast.a(this.a, this.a.getResources().getString(2131367289), 0).a();
      return;
    }
    PhotoListActivity.d(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     gsq
 * JD-Core Version:    0.7.0.1
 */