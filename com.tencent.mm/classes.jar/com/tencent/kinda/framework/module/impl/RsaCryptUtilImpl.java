package com.tencent.kinda.framework.module.impl;

import android.util.Base64;
import com.tencent.kinda.gen.RsaCryptUtil;
import com.tencent.kinda.gen.RsaEncryptResult;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class RsaCryptUtilImpl
  implements RsaCryptUtil
{
  private static final String TAG = "MicroMsg.RsaCryptUtilImpl";
  
  public RsaEncryptResult rsaPublicEncryptPemkey(String paramString1, String paramString2)
  {
    AppMethodBeat.i(18680);
    RsaEncryptResult localRsaEncryptResult = new RsaEncryptResult();
    if (Util.isNullOrNil(new String[] { paramString1, paramString2 }))
    {
      Log.w("MicroMsg.RsaCryptUtilImpl", "input is null");
      localRsaEncryptResult.mRet = 0;
      AppMethodBeat.o(18680);
      return localRsaEncryptResult;
    }
    PByteArray localPByteArray = new PByteArray();
    boolean bool = MMProtocalJni.rsaPublicEncryptPemkey(paramString1.getBytes(), localPByteArray, paramString2.getBytes());
    if ((bool) && (!Util.isNullOrNil(localPByteArray.value))) {
      localRsaEncryptResult.mBase64Str = Base64.encodeToString(localPByteArray.value, 2);
    }
    if (bool) {}
    for (int i = 0;; i = 1)
    {
      localRsaEncryptResult.mRet = i;
      Log.d("MicroMsg.RsaCryptUtilImpl", "encrypt ret: %s", new Object[] { localRsaEncryptResult });
      AppMethodBeat.o(18680);
      return localRsaEncryptResult;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.framework.module.impl.RsaCryptUtilImpl
 * JD-Core Version:    0.7.0.1
 */