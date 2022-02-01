import cooperation.qzone.QzoneEnterPluginProxyActivity;
import cooperation.qzone.QzoneGPUPluginProxyActivity;
import cooperation.qzone.QzoneOrientationPluginProxyActivity;
import cooperation.qzone.QzonePictureExtPluginProxyActivity;
import cooperation.qzone.QzonePicturePluginProxyActivity;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.QzoneTransNoTitlePluginProxyActivity;
import cooperation.qzone.QzoneTransWithKeyboardPluginProxyActivity;

public class mbh
{
  public static Class a(String paramString)
  {
    if (QzonePluginProxyActivity.a(QzonePluginProxyActivity.a(), paramString)) {
      return QzonePicturePluginProxyActivity.class;
    }
    if (QzonePluginProxyActivity.a(QzonePluginProxyActivity.b(), paramString)) {
      return QzoneTransNoTitlePluginProxyActivity.class;
    }
    if ("com.qzone.common.activities.FeedActionPanelActivity".equals(paramString)) {
      return QzoneTransWithKeyboardPluginProxyActivity.class;
    }
    if ("com.qzone.face.ui.QzoneMarkFaceActivity".equals(paramString)) {
      return QzonePictureExtPluginProxyActivity.class;
    }
    if ("com.qzone.preview.QZoneVideoFloatActivity".equals(paramString)) {
      return QzoneOrientationPluginProxyActivity.class;
    }
    if ("com.qzone.feed.ui.activity.QZoneFriendFeedActivity".equals(paramString)) {
      return QzoneEnterPluginProxyActivity.class;
    }
    return QzoneGPUPluginProxyActivity.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     mbh
 * JD-Core Version:    0.7.0.1
 */