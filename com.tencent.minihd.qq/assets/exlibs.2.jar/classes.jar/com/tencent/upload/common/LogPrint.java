package com.tencent.upload.common;

import FileUpload.SvcResponsePacket;
import com.tencent.upload.network.action.ActionResponse;
import com.tencent.upload.network.action.IActionRequest;
import com.tencent.upload.network.route.IUploadRouteStrategy;
import com.tencent.upload.uinterface.IUploadAction;
import com.tencent.upload.uinterface.Utility.ServerCategory;

public class LogPrint
{
  public static final String actionSequence(ActionResponse paramActionResponse)
  {
    if (paramActionResponse == null) {
      return "null";
    }
    return Integer.toString(paramActionResponse.getActionSequence());
  }
  
  public static final String actionSequence(IActionRequest paramIActionRequest)
  {
    if (paramIActionRequest == null) {
      return "null";
    }
    return Integer.toString(paramIActionRequest.getActionSequence());
  }
  
  public static final String actionSequence(IUploadAction paramIUploadAction)
  {
    if (paramIUploadAction == null) {
      return "null";
    }
    return Integer.toString(paramIUploadAction.getActionSequence());
  }
  
  public static final String commandId(ActionResponse paramActionResponse)
  {
    if (paramActionResponse == null) {
      return "null";
    }
    if (paramActionResponse.getReponsePacket() == null) {
      return "null";
    }
    return Integer.toString(paramActionResponse.getReponsePacket().iCmdID);
  }
  
  public static final String commandId(IActionRequest paramIActionRequest)
  {
    if (paramIActionRequest == null) {
      return "null";
    }
    return Integer.toString(paramIActionRequest.getCommandId());
  }
  
  public static final String getSimpleName(Object paramObject)
  {
    if (paramObject == null) {
      return "null";
    }
    return paramObject.getClass().getSimpleName();
  }
  
  public static final String hashCode(Object paramObject)
  {
    if (paramObject == null) {
      return "null";
    }
    return Integer.toString(paramObject.hashCode());
  }
  
  public static final String requestSequence(IActionRequest paramIActionRequest)
  {
    if (paramIActionRequest == null) {
      return "null";
    }
    return Integer.toString(paramIActionRequest.getRequestSequence());
  }
  
  public static final String serverCategory(IUploadRouteStrategy paramIUploadRouteStrategy)
  {
    if (paramIUploadRouteStrategy == null) {
      return "null";
    }
    return Utility.ServerCategory.print(paramIUploadRouteStrategy.getServerCategory());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.upload.common.LogPrint
 * JD-Core Version:    0.7.0.1
 */