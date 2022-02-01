package oicq.wlogin_sdk.tlv_type;

import android.content.Context;
import oicq.wlogin_sdk.tools.util;

public class tlv_t52d
  extends tlv_t
{
  public tlv_t52d()
  {
    this._cmd = 1325;
  }
  
  public byte[] get_tlv_52d(Context paramContext)
  {
    paramContext = util.get_android_dev_info(paramContext);
    if ((paramContext != null) && (paramContext.length > 0))
    {
      set_data(paramContext, paramContext.length);
      util.LOGI("get_tlv_52d success " + paramContext.length, "");
    }
    for (;;)
    {
      return get_buf();
      util.LOGI("get_tlv_52d failed", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t52d
 * JD-Core Version:    0.7.0.1
 */