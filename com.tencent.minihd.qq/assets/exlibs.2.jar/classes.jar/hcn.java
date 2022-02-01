import android.widget.ImageView;
import com.tencent.mobileqq.activity.widget.qqmusic.business.album.AlbumImageLoader;
import com.tencent.mobileqq.activity.widget.qqmusic.business.album.AlbumImageLoader.LoadAlbumOptions;
import com.tencent.mobileqq.activity.widget.qqmusic.data.AlbumInfo;
import com.tencent.mobileqq.activity.widget.qqmusic.network.listener.OnResultListener;
import com.tencent.mobileqq.activity.widget.qqmusic.network.response.CommonResponse;
import com.tencent.mobileqq.activity.widget.qqmusic.utils.MLog;

public class hcn
  implements OnResultListener
{
  public hcn(AlbumImageLoader paramAlbumImageLoader, AlbumImageLoader.LoadAlbumOptions paramLoadAlbumOptions) {}
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicBusinessAlbumAlbumImageLoader$LoadAlbumOptions.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicBusinessAlbumAlbumImageLoader$LoadAlbumOptions.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    MLog.d("AlbumImageLoader", "AlbumRequest error : " + paramInt);
  }
  
  public void a(CommonResponse paramCommonResponse)
  {
    paramCommonResponse = (AlbumInfo)paramCommonResponse.a();
    AlbumImageLoader.a(this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicBusinessAlbumAlbumImageLoader, paramCommonResponse, this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicBusinessAlbumAlbumImageLoader$LoadAlbumOptions);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     hcn
 * JD-Core Version:    0.7.0.1
 */