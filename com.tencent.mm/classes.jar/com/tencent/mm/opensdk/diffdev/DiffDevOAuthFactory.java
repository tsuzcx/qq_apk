package com.tencent.mm.opensdk.diffdev;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.diffdev.a.a;
import com.tencent.mm.opensdk.utils.Log;

public class DiffDevOAuthFactory
{
  public static final int MAX_SUPPORTED_VERSION = 1;
  private static final String TAG = "MicroMsg.SDK.DiffDevOAuthFactory";
  public static final int VERSION_1 = 1;
  private static IDiffDevOAuth v1Instance;
  
  public static IDiffDevOAuth getDiffDevOAuth()
  {
    AppMethodBeat.i(3743);
    IDiffDevOAuth localIDiffDevOAuth = getDiffDevOAuth(1);
    AppMethodBeat.o(3743);
    return localIDiffDevOAuth;
  }
  
  public static IDiffDevOAuth getDiffDevOAuth(int paramInt)
  {
    AppMethodBeat.i(3744);
    Log.v("MicroMsg.SDK.DiffDevOAuthFactory", "getDiffDevOAuth, version = ".concat(String.valueOf(paramInt)));
    if (paramInt > 1)
    {
      Log.e("MicroMsg.SDK.DiffDevOAuthFactory", "getDiffDevOAuth fail, unsupported version = ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(3744);
      return null;
    }
    if (paramInt != 1)
    {
      AppMethodBeat.o(3744);
      return null;
    }
    if (v1Instance == null) {
      v1Instance = new a();
    }
    IDiffDevOAuth localIDiffDevOAuth = v1Instance;
    AppMethodBeat.o(3744);
    return localIDiffDevOAuth;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.opensdk.diffdev.DiffDevOAuthFactory
 * JD-Core Version:    0.7.0.1
 */