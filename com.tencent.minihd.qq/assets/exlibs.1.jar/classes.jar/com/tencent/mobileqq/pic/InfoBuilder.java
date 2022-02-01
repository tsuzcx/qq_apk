package com.tencent.mobileqq.pic;

import android.content.Intent;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import java.util.ArrayList;

public abstract interface InfoBuilder
{
  public abstract CompressInfo a(Intent paramIntent);
  
  public abstract PicDownloadInfo a(Intent paramIntent);
  
  public abstract PicFowardInfo a(Intent paramIntent);
  
  public abstract PicFowardInfo a(MessageForPic paramMessageForPic, int paramInt, String paramString1, String paramString2, String paramString3);
  
  public abstract PicUploadInfo a(Intent paramIntent);
  
  public abstract ArrayList a(MessageForMixedMsg paramMessageForMixedMsg, int paramInt, String paramString1, String paramString2, String paramString3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pic.InfoBuilder
 * JD-Core Version:    0.7.0.1
 */