package com.google.firebase;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.StringResourceValueReader;
import com.google.android.gms.common.util.Strings;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  private final String bId;
  public final String bIe;
  public final String zzs;
  private final String zzt;
  private final String zzu;
  private final String zzw;
  private final String zzx;
  
  private b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(4063);
    if (!Strings.isEmptyOrWhitespace(paramString1)) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool, "ApplicationId must be set.");
      this.zzs = paramString1;
      this.bId = paramString2;
      this.zzt = paramString3;
      this.zzu = paramString4;
      this.bIe = paramString5;
      this.zzw = paramString6;
      this.zzx = paramString7;
      AppMethodBeat.o(4063);
      return;
    }
  }
  
  public static b aj(Context paramContext)
  {
    AppMethodBeat.i(4064);
    paramContext = new StringResourceValueReader(paramContext);
    String str = paramContext.getString("google_app_id");
    if (TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(4064);
      return null;
    }
    paramContext = new b(str, paramContext.getString("google_api_key"), paramContext.getString("firebase_database_url"), paramContext.getString("ga_trackingId"), paramContext.getString("gcm_defaultSenderId"), paramContext.getString("google_storage_bucket"), paramContext.getString("project_id"));
    AppMethodBeat.o(4064);
    return paramContext;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(4065);
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(4065);
      return false;
    }
    paramObject = (b)paramObject;
    if ((Objects.equal(this.zzs, paramObject.zzs)) && (Objects.equal(this.bId, paramObject.bId)) && (Objects.equal(this.zzt, paramObject.zzt)) && (Objects.equal(this.zzu, paramObject.zzu)) && (Objects.equal(this.bIe, paramObject.bIe)) && (Objects.equal(this.zzw, paramObject.zzw)) && (Objects.equal(this.zzx, paramObject.zzx)))
    {
      AppMethodBeat.o(4065);
      return true;
    }
    AppMethodBeat.o(4065);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(4066);
    int i = Objects.hashCode(new Object[] { this.zzs, this.bId, this.zzt, this.zzu, this.bIe, this.zzw, this.zzx });
    AppMethodBeat.o(4066);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(4067);
    String str = Objects.toStringHelper(this).add("applicationId", this.zzs).add("apiKey", this.bId).add("databaseUrl", this.zzt).add("gcmSenderId", this.bIe).add("storageBucket", this.zzw).add("projectId", this.zzx).toString();
    AppMethodBeat.o(4067);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.firebase.b
 * JD-Core Version:    0.7.0.1
 */