package cooperation.qzone;

import common.config.service.QzoneConfig;

public class QZoneHelper$QZoneCoverConstants
{
  public static final int a = 1;
  public static final String a = "https://sz.n.photo.qq.com/bgstore/index?_wv=2097155&uin={uin}&sid={sid}&from={from}&page={page}&qua={qua}&_bid=372&clicktime={clicktime}#!/list?cate_id={cate_id}&from_tab=classify";
  public static final int b = 2;
  public static final String b = "cover_uin";
  public static final int c = 3;
  public static final String c = "set_source";
  public static final int d = 4;
  public static final String d = "current_cover";
  public static final int e = 5;
  public static final String e = "photowall_mode";
  public static final int f = 6;
  public static final String f = "photowall_updated";
  public static final int g = 7;
  public static final String g = "key_from";
  public static final int h = 0;
  public static final String h = "direct_select_photo";
  public static final int i = 1;
  public static final String i = "jigsaw_open";
  public static final int j = 1;
  public static final String j = "cover_setjigsaw";
  public static final int k = 1;
  public static final String k = "com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity";
  public static final int l = 2;
  public static final String l = "action.com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity.cover_img_crop_end";
  public static final int m = 3;
  public static final String m = "showWidgetSet";
  public static final int n = 4;
  public static final String n = "action.com.qzone.cover.set_cover_success";
  public static final int o = 5;
  public static final String o = "preload_cover_url";
  public static final int p = 6;
  public static final String p = "preload_cover_uin";
  public static final int q = 7;
  public static final String q = "HigeResolutionCover";
  public static final String r = "LowResolutionCover";
  private static final String s = "https://h5.qzone.qq.com/bgstore/index?_wv=2097155&uin={uin}&sid={sid}&from={from}&page={page}&qua={qua}&_bid=372&clicktime={clicktime}";
  private static final String t = "https://qzs.qq.com/qzone/hybrid/bgStore/index.html?sid={sid}&qua={qua}&_bid=372&_wv=2098179&from={from}&page={page}#!/detail?coverid={coverid}";
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return QzoneConfig.a().a("H5Url", "CoverStore", "https://h5.qzone.qq.com/bgstore/index?_wv=2097155&uin={uin}&sid={sid}&from={from}&page={page}&qua={qua}&_bid=372&clicktime={clicktime}").replace("{uin}", paramString4).replace("{sid}", paramString1).replace("{qua}", QUA.a()).replace("{pb}", "").replace("{clicktime}", String.valueOf(System.currentTimeMillis())).replace("{from}", paramString2).replace("{page}", paramString3);
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    return QzoneConfig.a().a("H5Url", "CoverList", "https://sz.n.photo.qq.com/bgstore/index?_wv=2097155&uin={uin}&sid={sid}&from={from}&page={page}&qua={qua}&_bid=372&clicktime={clicktime}#!/list?cate_id={cate_id}&from_tab=classify").replace("{uin}", paramString4).replace("{sid}", paramString1).replace("{qua}", QUA.a()).replace("{pb}", "").replace("{clicktime}", String.valueOf(System.currentTimeMillis())).replace("{from}", paramString2).replace("{page}", paramString3).replace("{cate_id}", paramString5);
  }
  
  public static String b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return QzoneConfig.a().a("H5Url", "CoverPreview", "https://qzs.qq.com/qzone/hybrid/bgStore/index.html?sid={sid}&qua={qua}&_bid=372&_wv=2098179&from={from}&page={page}#!/detail?coverid={coverid}").replace("{sid}", paramString1).replace("{qua}", QUA.a()).replace("{pb}", "").replace("{from}", paramString2).replace("{page}", paramString3).replace("{coverid}", paramString4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qzone.QZoneHelper.QZoneCoverConstants
 * JD-Core Version:    0.7.0.1
 */