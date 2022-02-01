import android.text.TextUtils;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mobileqq.jsp.QQApiPlugin;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;

class jcu
  implements WXShareHelper.WXShareListener
{
  jcu(jct paramjct) {}
  
  public void a(BaseResp paramBaseResp)
  {
    if ((this.a.a.r == null) || (!this.a.a.r.equals(paramBaseResp.transaction))) {
      return;
    }
    boolean bool;
    switch (paramBaseResp.errCode)
    {
    case -1: 
    default: 
      QRUtils.a(1, 2131367819);
      bool = false;
    }
    while (!TextUtils.isEmpty(this.a.a.q))
    {
      this.a.a.callJs(this.a.a.q, new String[] { String.valueOf(bool) });
      return;
      QRUtils.a(2, 2131367818);
      bool = true;
      continue;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jcu
 * JD-Core Version:    0.7.0.1
 */