import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.photo.AlbumListActivity;
import com.tencent.mobileqq.activity.photo.AlbumListAdapter;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;

public class gro
  implements AdapterView.OnItemClickListener
{
  private gro(AlbumListActivity paramAlbumListActivity) {}
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumListAdapter.a(paramInt);
    if ((paramAdapterView == null) || (paramAdapterView.mMediaFileCount <= 0) || (TextUtils.isEmpty(paramAdapterView.name)))
    {
      QQToast.a(this.a, 2131368526, 0).a();
      return;
    }
    this.a.jdField_a_of_type_ComTencentWidgetXListView.setItemChecked(paramInt, true);
    paramView = this.a.getIntent();
    paramView.putExtra("ALBUM_ID", paramAdapterView._id);
    paramView.putExtra("ALBUM_NAME", paramAdapterView.name);
    paramView.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", paramView.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0));
    paramView.putExtra("album_enter_directly", false);
    AlbumListActivity.a(this.a, true);
    this.a.setResult(-1, paramView);
    this.a.finish();
    AlbumUtil.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     gro
 * JD-Core Version:    0.7.0.1
 */