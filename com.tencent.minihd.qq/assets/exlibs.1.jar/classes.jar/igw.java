import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.PlusPanelUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.emoticonview.FastImagePreviewLayout;
import com.tencent.mobileqq.transfile.AlbumThumbDownloader;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.EmptyStackException;
import java.util.List;

public class igw
  implements Runnable
{
  public igw(FastImagePreviewLayout paramFastImagePreviewLayout) {}
  
  public void run()
  {
    int i = MediaFileFilter.MEDIA_FILTER_SHOW_IMAGE.ordinal();
    Object localObject1 = AlbumUtil.a(this.a.jdField_a_of_type_AndroidContentContext, 210, 1, MediaFileFilter.filterOfOrdinal(i));
    if (QLog.isColorLevel()) {
      QLog.d(FastImagePreviewLayout.jdField_a_of_type_JavaLangString, 2, "queryFastImage called");
    }
    Object localObject4;
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject4 = (LocalMediaInfo)((List)localObject1).get(0);
      if ((PlusPanelUtils.b == null) || (!PlusPanelUtils.b.equals(((LocalMediaInfo)localObject4).jdField_a_of_type_JavaLangString))) {
        break label91;
      }
    }
    for (;;)
    {
      return;
      label91:
      PlusPanelUtils.b = ((LocalMediaInfo)localObject4).jdField_a_of_type_JavaLangString;
      if (((PlusPanelUtils.jdField_a_of_type_JavaLangString != null) && (PlusPanelUtils.b.equals(PlusPanelUtils.jdField_a_of_type_JavaLangString))) || (((LocalMediaInfo)localObject4).jdField_a_of_type_JavaLangString.contains("/tencent/zebra/cache/"))) {
        continue;
      }
      ColorDrawable localColorDrawable = new ColorDrawable(570425344);
      try
      {
        localObject1 = this.a.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841071);
        URL localURL = AlbumUtil.a((LocalMediaInfo)localObject4, AlbumThumbDownloader.a);
        long l1 = System.currentTimeMillis();
        long l2 = l1 - ((LocalMediaInfo)localObject4).c * 1000L;
        if (QLog.isColorLevel()) {
          QLog.d(FastImagePreviewLayout.jdField_a_of_type_JavaLangString, 2, "queryFastImage called, spentTime = " + l2 + ",currentTime = " + l1 + ",addedTime = " + ((LocalMediaInfo)localObject4).c + ",modifiedTime = " + ((LocalMediaInfo)localObject4).d);
        }
        if (l2 >= 30000L) {
          continue;
        }
        localObject4 = (ImageView)View.inflate(this.a.jdField_a_of_type_AndroidContentContext, 2130903075, null).findViewById(2131296701);
        this.a.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(localURL, ((ImageView)localObject4).getWidth(), ((ImageView)localObject4).getHeight(), localColorDrawable, (Drawable)localObject1);
        this.a.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
        this.a.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(new igx(this));
        return;
      }
      catch (EmptyStackException localEmptyStackException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d(FastImagePreviewLayout.jdField_a_of_type_JavaLangString, 2, "queryFastImage EmptyStackException = " + localEmptyStackException);
          }
          Object localObject2 = null;
        }
      }
      catch (NullPointerException localNullPointerException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d(FastImagePreviewLayout.jdField_a_of_type_JavaLangString, 2, "queryFastImage NullPointerException = " + localNullPointerException);
          }
          Object localObject3 = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     igw
 * JD-Core Version:    0.7.0.1
 */