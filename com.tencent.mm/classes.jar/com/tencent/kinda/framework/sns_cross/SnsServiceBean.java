package com.tencent.kinda.framework.sns_cross;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.wallet.PayInfo;

public class SnsServiceBean
{
  private int mChannel;
  private Context mContext;
  private PayInfo mPayInfo;
  private int mPayScene;
  private String mReceiverName;
  private String mReqKey;
  private String mTrueName;
  
  SnsServiceBean(Context paramContext, PayInfo paramPayInfo)
  {
    AppMethodBeat.i(18717);
    this.mReceiverName = "";
    this.mTrueName = "";
    this.mPayInfo = paramPayInfo;
    this.mContext = paramContext;
    this.mReqKey = paramPayInfo.dmw;
    this.mChannel = paramPayInfo.channel;
    this.mPayScene = paramPayInfo.dDH;
    if (paramPayInfo.hwN != null)
    {
      this.mReceiverName = paramPayInfo.hwN.getString("extinfo_key_1");
      this.mTrueName = paramPayInfo.hwN.getString("extinfo_key_2");
    }
    AppMethodBeat.o(18717);
  }
  
  public int getChannel()
  {
    return this.mChannel;
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public PayInfo getPayInfo()
  {
    return this.mPayInfo;
  }
  
  public int getPayScene()
  {
    return this.mPayScene;
  }
  
  public String getReceiverName()
  {
    return this.mReceiverName;
  }
  
  public String getReqKey()
  {
    return this.mReqKey;
  }
  
  public String getTrueName()
  {
    return this.mTrueName;
  }
  
  public void setChannel(int paramInt)
  {
    this.mChannel = paramInt;
  }
  
  public void setContext(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public void setPayInfo(PayInfo paramPayInfo)
  {
    this.mPayInfo = paramPayInfo;
  }
  
  public void setPayScene(int paramInt)
  {
    this.mPayScene = paramInt;
  }
  
  public void setReceiverName(String paramString)
  {
    this.mReceiverName = paramString;
  }
  
  public void setReqKey(String paramString)
  {
    this.mReqKey = paramString;
  }
  
  public void setTrueName(String paramString)
  {
    this.mTrueName = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.framework.sns_cross.SnsServiceBean
 * JD-Core Version:    0.7.0.1
 */