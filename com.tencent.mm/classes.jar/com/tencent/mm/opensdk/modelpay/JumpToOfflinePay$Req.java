package com.tencent.mm.opensdk.modelpay;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;

public class JumpToOfflinePay$Req
  extends BaseReq
{
  private static final String TAG = "MicroMsg.SDK.JumpToOfflinePay.Req";
  
  public boolean checkArgs()
  {
    return true;
  }
  
  public void fromBundle(Bundle paramBundle)
  {
    super.fromBundle(paramBundle);
  }
  
  public int getType()
  {
    return 24;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    super.toBundle(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelpay.JumpToOfflinePay.Req
 * JD-Core Version:    0.7.0.1
 */