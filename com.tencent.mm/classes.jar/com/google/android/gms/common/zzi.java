package com.google.android.gms.common;

import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;

final class zzi
  extends zzg
{
  private final String packageName;
  private final GoogleCertificates.CertData zzbn;
  private final boolean zzbo;
  private final boolean zzbp;
  
  private zzi(String paramString, GoogleCertificates.CertData paramCertData, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(false, null, null);
    this.packageName = paramString;
    this.zzbn = paramCertData;
    this.zzbo = paramBoolean1;
    this.zzbp = paramBoolean2;
  }
  
  final String getErrorMessage()
  {
    AppMethodBeat.i(5362);
    if (this.zzbp) {}
    for (String str1 = "debug cert rejected";; str1 = "not whitelisted")
    {
      String str2 = this.packageName;
      Object localObject = this.zzbn;
      localObject = Hex.bytesToStringLowercase(AndroidUtilsLight.getMessageDigest("SHA-1").digest(((GoogleCertificates.CertData)localObject).getBytes()));
      boolean bool = this.zzbo;
      str1 = String.valueOf(str1).length() + 44 + String.valueOf(str2).length() + String.valueOf(localObject).length() + str1 + ": pkg=" + str2 + ", sha1=" + (String)localObject + ", atk=" + bool + ", ver=12451009.false";
      AppMethodBeat.o(5362);
      return str1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.zzi
 * JD-Core Version:    0.7.0.1
 */