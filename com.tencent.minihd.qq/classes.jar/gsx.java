import android.os.AsyncTask;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.LogTag;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GestureSelectGridView;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class gsx
  extends AsyncTask
{
  private gsx(PhotoListActivity paramPhotoListActivity) {}
  
  protected List a(Object... paramVarArgs)
  {
    int k = 0;
    LogTag.a();
    paramVarArgs = AlbumUtil.c(this.a, PhotoListActivity.a(this.a), PhotoListActivity.b(this.a), MediaFileFilter.filterOfOrdinal(PhotoListActivity.a(this.a)));
    LogTag.a("PEAK", "getAlbumMedias");
    if (paramVarArgs == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SelectPhotoTrace", 2, "photoList is null");
      }
      return null;
    }
    if ((this.a.jdField_a_of_type_JavaUtilArrayList != null) && (this.a.jdField_a_of_type_JavaUtilArrayList.size() != 0))
    {
      int j;
      for (i = 0; i < this.a.jdField_a_of_type_JavaUtilArrayList.size(); i = j + 1)
      {
        j = i;
        if (!new File((String)this.a.jdField_a_of_type_JavaUtilArrayList.get(i)).exists())
        {
          this.a.jdField_a_of_type_JavaUtilArrayList.remove(i);
          j = i - 1;
        }
      }
    }
    System.currentTimeMillis();
    long l = AlbumUtil.c;
    int i = k;
    if (AlbumUtil.a.containsKey(PhotoListActivity.a(this.a)))
    {
      ((Integer)AlbumUtil.a.get(PhotoListActivity.a(this.a))).intValue();
      i = k;
    }
    if (i < paramVarArgs.size())
    {
      LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)paramVarArgs.get(i);
      if (localLocalMediaInfo.a == null) {}
      for (;;)
      {
        i += 1;
        break;
        if (this.a.jdField_a_of_type_JavaUtilArrayList.contains(localLocalMediaInfo.a))
        {
          localLocalMediaInfo.b = 1;
        }
        else if ((this.a.jdField_a_of_type_JavaUtilArrayList.size() < this.a.d) && (PhotoListActivity.c(this.a) != null) && (localLocalMediaInfo.a.equals(PhotoListActivity.c(this.a))))
        {
          localLocalMediaInfo.b = 1;
          this.a.jdField_a_of_type_JavaUtilArrayList.add(localLocalMediaInfo.a);
        }
        else
        {
          localLocalMediaInfo.b = 2;
        }
      }
    }
    return paramVarArgs;
  }
  
  protected void a(List paramList)
  {
    int k = 0;
    PhotoListActivity.c(this.a);
    if (paramList == null)
    {
      this.a.jdField_a_of_type_Gsv.a(paramList);
      this.a.jdField_a_of_type_Gsv.notifyDataSetChanged();
      PhotoListActivity.a(this.a);
      QQToast.a(this.a, "暂无媒体文件", 1000).a();
      return;
    }
    this.a.jdField_a_of_type_Gsv.a(paramList);
    if (paramList.isEmpty()) {
      QQToast.a(this.a, "暂无媒体文件", 1000).a();
    }
    int i;
    int j;
    if (PhotoListActivity.a(this.a))
    {
      PhotoListActivity.a(this.a, false);
      i = PhotoListActivity.a();
      if (i != -1) {
        break label294;
      }
      LinkedHashMap localLinkedHashMap = (LinkedHashMap)AlbumUtil.b.get(PhotoListActivity.a(this.a));
      if (localLinkedHashMap == null) {
        break label331;
      }
      j = localLinkedHashMap.size();
      if (j <= 0) {
        break label331;
      }
      i = ((Integer)localLinkedHashMap.get(localLinkedHashMap.keySet().toArray()[(j - 1)])).intValue();
    }
    label294:
    label331:
    for (;;)
    {
      if ((i == -1) && (PhotoListActivity.b(this.a)))
      {
        paramList = paramList.iterator();
        j = 0;
        if (paramList.hasNext()) {
          if (((LocalMediaInfo)paramList.next()).b == 3) {
            i = j;
          }
        }
      }
      for (;;)
      {
        label233:
        j = this.a.jdField_a_of_type_Gsv.getCount();
        if (j == 0) {
          j = k;
        }
        for (;;)
        {
          this.a.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setSelection(j);
          this.a.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setAdapter(this.a.jdField_a_of_type_Gsv);
          PhotoListActivity.a(this.a);
          return;
          j += 1;
          break;
          PhotoListActivity.a(-1);
          break label233;
          if (i > j - 1)
          {
            j -= 1;
          }
          else
          {
            j = k;
            if (i >= 0) {
              j = i;
            }
          }
        }
      }
    }
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    PhotoListActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     gsx
 * JD-Core Version:    0.7.0.1
 */