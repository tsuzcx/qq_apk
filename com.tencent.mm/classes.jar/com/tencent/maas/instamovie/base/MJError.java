package com.tencent.maas.instamovie.base;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class MJError
{
  public MaasEC ec;
  public String message;
  
  public MJError(int paramInt, String paramString)
  {
    AppMethodBeat.i(216937);
    this.ec = MaasEC.fromInt(paramInt);
    this.message = paramString;
    AppMethodBeat.o(216937);
  }
  
  public static enum MaasEC
  {
    private final int errorCode;
    
    static
    {
      AppMethodBeat.i(216964);
      None = new MaasEC("None", 0, -1);
      NoError = new MaasEC("NoError", 1, 0);
      GeneralError = new MaasEC("GeneralError", 2, 1);
      LoadAssetFailed = new MaasEC("LoadAssetFailed", 3, 4);
      FileExists = new MaasEC("FileExists", 4, 36);
      InvalidArgument = new MaasEC("InvalidArgument", 5, 45);
      NetworkDown = new MaasEC("NetworkDown", 6, 50);
      TimedOut = new MaasEC("TimedOut", 7, 87);
      InvalidState = new MaasEC("InvalidState", 8, 101);
      NetworkFailed = new MaasEC("NetworkFailed", 9, 115);
      VideoEncodeFailed = new MaasEC("VideoEncodeFailed", 10, 144);
      $VALUES = new MaasEC[] { None, NoError, GeneralError, LoadAssetFailed, FileExists, InvalidArgument, NetworkDown, TimedOut, InvalidState, NetworkFailed, VideoEncodeFailed };
      AppMethodBeat.o(216964);
    }
    
    private MaasEC(int paramInt)
    {
      this.errorCode = paramInt;
    }
    
    public static MaasEC fromInt(int paramInt)
    {
      AppMethodBeat.i(216953);
      Object localObject = values();
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        MaasEC localMaasEC = localObject[i];
        if (localMaasEC.getErrorCode() == paramInt)
        {
          AppMethodBeat.o(216953);
          return localMaasEC;
        }
        i += 1;
      }
      localObject = None;
      AppMethodBeat.o(216953);
      return localObject;
    }
    
    public final int getErrorCode()
    {
      return this.errorCode;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.maas.instamovie.base.MJError
 * JD-Core Version:    0.7.0.1
 */