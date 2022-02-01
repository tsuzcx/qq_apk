package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.emoticon.EPRecommendTask;

public class GetEmoticonWhenNoFile
  extends AsyncStep
{
  protected int a()
  {
    new EPRecommendTask(this.a.a).a("https://imgcache.qq.com/club/item/parcel/android_tab.json", "1").a();
    new EPRecommendTask(this.a.a).a("https://imgcache.qq.com/club/item/parcel/android_magictab.json", "2").a();
    new EPRecommendTask(this.a.a).a("https://i.gtimg.cn/qqshow/admindata/comdata/vip_emoji_aio_android_config/xydata.json", "3").a();
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetEmoticonWhenNoFile
 * JD-Core Version:    0.7.0.1
 */