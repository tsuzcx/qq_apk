package com.tencent.mm.opensdk.diffdev;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.diffdev.a.a;
import com.tencent.mm.opensdk.utils.Log;

public class DiffDevOAuthFactory
{
  public static final int MAX_SUPPORTED_VERSION = 1;
  private static final String TAG = "MicroMsg.SDK.DiffDevOAuthFactory";
  public static final int VERSION_1 = 1;
  private static IDiffDevOAuth v1Instance = null;
  
  public static IDiffDevOAuth getDiffDevOAuth()
  {
    AppMethodBeat.i(128058);
    IDiffDevOAuth localIDiffDevOAuth = getDiffDevOAuth(1);
    AppMethodBeat.o(128058);
    return localIDiffDevOAuth;
  }
  
  public static IDiffDevOAuth getDiffDevOAuth(int paramInt)
  {
    AppMethodBeat.i(128059);
    Log.v("MicroMsg.SDK.DiffDevOAuthFactory", "getDiffDevOAuth, version = ".concat(String.valueOf(paramInt)));
    if (paramInt > 1)
    {
      Log.e("MicroMsg.SDK.DiffDevOAuthFactory", "getDiffDevOAuth fail, unsupported version = ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(128059);
      return null;
    }
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(128059);
      return null;
    }
    if (v1Instance == null) {
      v1Instance = new a();
    }
    IDiffDevOAuth localIDiffDevOAuth = v1Instance;
    AppMethodBeat.o(128059);
    return localIDiffDevOAuth;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.diffdev.DiffDevOAuthFactory
 * JD-Core Version:    0.7.0.1
 */