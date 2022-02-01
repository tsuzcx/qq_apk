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
    public String extData;
    public String videoPath;
    
    public boolean checkArgs()
    {
      AppMethodBeat.i(254116);
      if (b.b(this.videoPath))
      {
        Log.e("MicroMsg.SDK.WXChannelShareVideo.Req", "videoPath is null");
        AppMethodBeat.o(254116);
        return false;
      }
      AppMethodBeat.o(254116);
      return true;
    }
    
    public void fromBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(254118);
      super.fromBundle(paramBundle);
      this.videoPath = paramBundle.getString("_wxapi_finder_share_video_path");
      this.extData = paramBundle.getString("_wxapi_finder_share_video_extData");
      AppMethodBeat.o(254118);
    }
    
    public int getType()
    {
      return 33;
    }
    
    public void toBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(254119);
      super.toBundle(paramBundle);
      paramBundle.putString("_wxapi_finder_share_video_path", this.videoPath);
      paramBundle.putString("_wxapi_finder_share_video_extData", this.extData);
      AppMethodBeat.o(254119);
    }
  }
  
  public static class Resp
    extends BaseResp
  {
    public String extMsg;
    
    public Resp() {}
    
    public Resp(Bundle paramBundle)
    {
      AppMethodBeat.i(254807);
      fromBundle(paramBundle);
      AppMethodBeat.o(254807);
    }
    
    public boolean checkArgs()
    {
      return true;
    }
    
    public void fromBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(254810);
      super.fromBundle(paramBundle);
      this.extMsg = paramBundle.getString("_wxapi_finder_extMsg");
      AppMethodBeat.o(254810);
    }
    
    public int getType()
    {
      return 33;
    }
    
    public void toBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(254813);
      super.toBundle(paramBundle);
      paramBundle.putString("_wxapi_finder_extMsg", this.extMsg);
      AppMethodBeat.o(254813);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.WXChannelShareVideo
 * JD-Core Version:    0.7.0.1
 */