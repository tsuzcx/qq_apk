package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;

public class WXChannelShareVideo
{
  public static class Req
    extends BaseReq
  {
    private static final int LENGTH_LIMIT = 1024;
    private static final String TAG = "MicroMsg.SDK.WXChannelShareVideo.Req";
    private static final String WX_CHANNEL_SHARE_VIDEO_JUMP_INFO_KEY_IDENTIFIER = "_wxapi_channel_share_video_jump_info_identifier";
    public String extData;
    public IWXChannelJumpInfo jumpInfo;
    public String videoPath;
    
    public boolean checkArgs()
    {
      AppMethodBeat.i(243061);
      if (b.b(this.videoPath))
      {
        Log.e("MicroMsg.SDK.WXChannelShareVideo.Req", "videoPath is null");
        AppMethodBeat.o(243061);
        return false;
      }
      IWXChannelJumpInfo localIWXChannelJumpInfo = this.jumpInfo;
      if ((localIWXChannelJumpInfo != null) && (!localIWXChannelJumpInfo.checkArgs()))
      {
        Log.e("MicroMsg.SDK.WXChannelShareVideo.Req", "checkArgs fail, jumpInfo is invalid");
        AppMethodBeat.o(243061);
        return false;
      }
      AppMethodBeat.o(243061);
      return true;
    }
    
    public void fromBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(243062);
      super.fromBundle(paramBundle);
      this.videoPath = paramBundle.getString("_wxapi_finder_share_video_path");
      this.extData = paramBundle.getString("_wxapi_finder_share_video_extData");
      String str = paramBundle.getString("_wxapi_channel_share_video_jump_info_identifier");
      if (str != null) {
        try
        {
          IWXChannelJumpInfo localIWXChannelJumpInfo = (IWXChannelJumpInfo)Class.forName(str).newInstance();
          this.jumpInfo = localIWXChannelJumpInfo;
          localIWXChannelJumpInfo.unserialize(paramBundle);
          AppMethodBeat.o(243062);
          return;
        }
        catch (Exception paramBundle)
        {
          Log.e("MicroMsg.SDK.WXChannelShareVideo.Req", "get WXChannelJumpInfo from bundle failed: unknown ident " + str + ", ex = " + paramBundle.getMessage());
        }
      }
      AppMethodBeat.o(243062);
    }
    
    public int getType()
    {
      return 33;
    }
    
    public void toBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(243065);
      super.toBundle(paramBundle);
      paramBundle.putString("_wxapi_finder_share_video_path", this.videoPath);
      paramBundle.putString("_wxapi_finder_share_video_extData", this.extData);
      IWXChannelJumpInfo localIWXChannelJumpInfo = this.jumpInfo;
      if (localIWXChannelJumpInfo != null)
      {
        paramBundle.putString("_wxapi_channel_share_video_jump_info_identifier", localIWXChannelJumpInfo.getClass().getName());
        this.jumpInfo.serialize(paramBundle);
      }
      AppMethodBeat.o(243065);
    }
  }
  
  public static class Resp
    extends BaseResp
  {
    public String extMsg;
    
    public Resp() {}
    
    public Resp(Bundle paramBundle)
    {
      AppMethodBeat.i(243083);
      fromBundle(paramBundle);
      AppMethodBeat.o(243083);
    }
    
    public boolean checkArgs()
    {
      return true;
    }
    
    public void fromBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(243088);
      super.fromBundle(paramBundle);
      this.extMsg = paramBundle.getString("_wxapi_finder_extMsg");
      AppMethodBeat.o(243088);
    }
    
    public int getType()
    {
      return 33;
    }
    
    public void toBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(243090);
      super.toBundle(paramBundle);
      paramBundle.putString("_wxapi_finder_extMsg", this.extMsg);
      AppMethodBeat.o(243090);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.WXChannelShareVideo
 * JD-Core Version:    0.7.0.1
 */