package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.servlet.VipGifServlet;
import com.tencent.mobileqq.vipgift.VipGiftDownloadInfo;
import com.tencent.mobileqq.vipgift.VipGiftManager;
import mqq.app.NewIntent;

public class VipCheckGift
  extends AsyncStep
{
  protected int a()
  {
    Object localObject = (VipGiftManager)this.a.a.getManager(72);
    VipGiftDownloadInfo localVipGiftDownloadInfo = ((VipGiftManager)localObject).a();
    if (localVipGiftDownloadInfo != null)
    {
      if ((localVipGiftDownloadInfo.d != 0L) || (localVipGiftDownloadInfo.a == 0L)) {
        break label54;
      }
      ((VipGiftManager)localObject).a(localVipGiftDownloadInfo.a);
    }
    for (;;)
    {
      return 7;
      label54:
      if (localVipGiftDownloadInfo.d == 2L)
      {
        localObject = new NewIntent(this.a.a.getApplication(), VipGifServlet.class);
        ((NewIntent)localObject).setAction("gif_ui_show");
        ((NewIntent)localObject).putExtra("gif_ui_show_bid", 0);
        ((NewIntent)localObject).putExtra("gif_ui_show_seq", localVipGiftDownloadInfo.a);
        this.a.a.startServlet((NewIntent)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.VipCheckGift
 * JD-Core Version:    0.7.0.1
 */