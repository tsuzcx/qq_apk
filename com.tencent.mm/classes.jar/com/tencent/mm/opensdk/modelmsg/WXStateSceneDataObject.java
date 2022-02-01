package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.utils.Log;

public class WXStateSceneDataObject
  implements SendMessageToWX.IWXSceneDataObject
{
  private static final int LENGTH_LIMIT = 10240;
  private static final String TAG = "MicroMsg.SDK.WXStateSceneDataObject";
  private static final String WX_STATE_JUMP_INFO_KEY_IDENTIFIER = "_wxapi_scene_data_state_jump_info_identifier";
  public String stateId;
  public IWXStateJumpInfo stateJumpInfo;
  public String stateTitle;
  public String token;
  
  public boolean checkArgs()
  {
    AppMethodBeat.i(255034);
    Object localObject = this.stateId;
    if ((localObject != null) && (((String)localObject).length() > 10240))
    {
      Log.e("MicroMsg.SDK.WXStateSceneDataObject", "checkArgs fail, stateId is invalid");
      AppMethodBeat.o(255034);
      return false;
    }
    localObject = this.stateTitle;
    if ((localObject != null) && (((String)localObject).length() > 10240))
    {
      Log.e("MicroMsg.SDK.WXStateSceneDataObject", "checkArgs fail, stateId is invalid");
      AppMethodBeat.o(255034);
      return false;
    }
    localObject = this.token;
    if ((localObject != null) && (((String)localObject).length() > 10240))
    {
      Log.e("MicroMsg.SDK.WXStateSceneDataObject", "checkArgs fail, stateId is invalid");
      AppMethodBeat.o(255034);
      return false;
    }
    localObject = this.stateJumpInfo;
    if (localObject == null)
    {
      Log.e("MicroMsg.SDK.WXStateSceneDataObject", "checkArgs fail, statsJumpInfo is null");
      AppMethodBeat.o(255034);
      return false;
    }
    boolean bool = ((IWXStateJumpInfo)localObject).checkArgs();
    AppMethodBeat.o(255034);
    return bool;
  }
  
  public int getJumpType()
  {
    AppMethodBeat.i(255035);
    IWXStateJumpInfo localIWXStateJumpInfo = this.stateJumpInfo;
    if (localIWXStateJumpInfo != null)
    {
      int i = localIWXStateJumpInfo.type();
      AppMethodBeat.o(255035);
      return i;
    }
    AppMethodBeat.o(255035);
    return 0;
  }
  
  public void serialize(Bundle paramBundle)
  {
    AppMethodBeat.i(255032);
    paramBundle.putString("_wxapi_scene_data_state_id", this.stateId);
    paramBundle.putString("_wxapi_scene_data_state_title", this.stateTitle);
    paramBundle.putString("_wxapi_scene_data_state_token", this.token);
    IWXStateJumpInfo localIWXStateJumpInfo = this.stateJumpInfo;
    if (localIWXStateJumpInfo != null)
    {
      paramBundle.putString("_wxapi_scene_data_state_jump_info_identifier", localIWXStateJumpInfo.getClass().getName());
      this.stateJumpInfo.serialize(paramBundle);
    }
    AppMethodBeat.o(255032);
  }
  
  public void unserialize(Bundle paramBundle)
  {
    AppMethodBeat.i(255033);
    this.stateId = paramBundle.getString("_wxapi_scene_data_state_id");
    this.stateTitle = paramBundle.getString("_wxapi_scene_data_state_title");
    this.token = paramBundle.getString("_wxapi_scene_data_state_token");
    String str = paramBundle.getString("_wxapi_scene_data_state_jump_info_identifier");
    if (str != null) {
      try
      {
        IWXStateJumpInfo localIWXStateJumpInfo = (IWXStateJumpInfo)Class.forName(str).newInstance();
        this.stateJumpInfo = localIWXStateJumpInfo;
        localIWXStateJumpInfo.unserialize(paramBundle);
        AppMethodBeat.o(255033);
        return;
      }
      catch (Exception paramBundle)
      {
        Log.e("MicroMsg.SDK.WXStateSceneDataObject", "get WXSceneDataObject from bundle failed: unknown ident " + str + ", ex = " + paramBundle.getMessage());
      }
    }
    AppMethodBeat.o(255033);
  }
  
  public static abstract interface IWXStateJumpInfo
  {
    public static final int WX_STATE_JUMP_TYPE_UNKNOWN = 0;
    public static final int WX_STATE_JUMP_TYPE_URL = 1;
    
    public abstract boolean checkArgs();
    
    public abstract void serialize(Bundle paramBundle);
    
    public abstract int type();
    
    public abstract void unserialize(Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.WXStateSceneDataObject
 * JD-Core Version:    0.7.0.1
 */