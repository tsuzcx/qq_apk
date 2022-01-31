package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseResp;

public final class WXLaunchMiniProgram$Resp
  extends BaseResp
{
  public String extMsg;
  
  public WXLaunchMiniProgram$Resp() {}
  
  public WXLaunchMiniProgram$Resp(Bundle paramBundle)
  {
    fromBundle(paramBundle);
  }
  
  public final boolean checkArgs()
  {
    return true;
  }
  
  public final void fromBundle(Bundle paramBundle)
  {
    super.fromBundle(paramBundle);
    this.extMsg = paramBundle.getString("_launch_wxminiprogram_ext_msg");
  }
  
  public final int getType()
  {
    return 19;
  }
  
  public final void toBundle(Bundle paramBundle)
  {
    super.toBundle(paramBundle);
    paramBundle.putString("_launch_wxminiprogram_ext_msg", this.extMsg);
    paramBundle.putInt("_wxapi_command_type", getType());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram.Resp
 * JD-Core Version:    0.7.0.1
 */