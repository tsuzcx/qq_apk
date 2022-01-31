package com.google.android.gms.common.server;

import android.text.TextUtils;
import com.google.android.gms.common.util.DeviceProperties;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseApi$BaseApiaryOptions<DerivedClassType extends BaseApiaryOptions<DerivedClassType>>
{
  private final ArrayList<String> zzvt;
  private final HashMap<String, String> zzvu;
  private String zzvv;
  private final BaseApiaryOptions<DerivedClassType>.Collector zzvw;
  
  public BaseApi$BaseApiaryOptions()
  {
    AppMethodBeat.i(61421);
    this.zzvt = new ArrayList();
    this.zzvu = new HashMap();
    this.zzvw = new BaseApi.BaseApiaryOptions.Collector(this);
    AppMethodBeat.o(61421);
  }
  
  private static String zzcy()
  {
    AppMethodBeat.i(61430);
    if (!DeviceProperties.isUserBuild()) {}
    for (boolean bool = true;; bool = false)
    {
      AppMethodBeat.o(61430);
      return String.valueOf(bool);
    }
  }
  
  public final DerivedClassType addField(String paramString)
  {
    AppMethodBeat.i(61423);
    this.zzvt.add(paramString);
    AppMethodBeat.o(61423);
    return this;
  }
  
  @Deprecated
  public final String appendParametersToUrl(String paramString)
  {
    AppMethodBeat.i(61428);
    String str = BaseApi.append(paramString, "prettyPrint", zzcy());
    paramString = str;
    if (this.zzvv != null) {
      paramString = BaseApi.append(str, "trace", getTrace());
    }
    str = paramString;
    if (!this.zzvt.isEmpty()) {
      str = BaseApi.append(paramString, "fields", TextUtils.join(",", getFields().toArray()));
    }
    AppMethodBeat.o(61428);
    return str;
  }
  
  public void appendParametersToUrl(StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(61429);
    BaseApi.append(paramStringBuilder, "prettyPrint", zzcy());
    if (this.zzvv != null) {
      BaseApi.append(paramStringBuilder, "trace", getTrace());
    }
    if (!this.zzvt.isEmpty()) {
      BaseApi.append(paramStringBuilder, "fields", TextUtils.join(",", getFields().toArray()));
    }
    AppMethodBeat.o(61429);
  }
  
  public final DerivedClassType buildFrom(BaseApiaryOptions<?> paramBaseApiaryOptions)
  {
    AppMethodBeat.i(61422);
    if (paramBaseApiaryOptions.zzvv != null) {
      this.zzvv = paramBaseApiaryOptions.zzvv;
    }
    if (!paramBaseApiaryOptions.zzvt.isEmpty())
    {
      this.zzvt.clear();
      this.zzvt.addAll(paramBaseApiaryOptions.zzvt);
    }
    AppMethodBeat.o(61422);
    return this;
  }
  
  protected final BaseApiaryOptions<DerivedClassType>.Collector getCollector()
  {
    return this.zzvw;
  }
  
  public final List<String> getFields()
  {
    return this.zzvt;
  }
  
  public final Map<String, String> getHeaders()
  {
    return this.zzvu;
  }
  
  public final String getTrace()
  {
    return this.zzvv;
  }
  
  public final DerivedClassType setEtag(String paramString)
  {
    AppMethodBeat.i(61425);
    paramString = setHeader("ETag", paramString);
    AppMethodBeat.o(61425);
    return paramString;
  }
  
  public final DerivedClassType setHeader(String paramString1, String paramString2)
  {
    AppMethodBeat.i(61424);
    this.zzvu.put(paramString1, paramString2);
    AppMethodBeat.o(61424);
    return this;
  }
  
  public final DerivedClassType setTraceByLdap(String paramString)
  {
    AppMethodBeat.i(61426);
    String str = String.valueOf("email:");
    paramString = String.valueOf(paramString);
    if (paramString.length() != 0) {}
    for (paramString = str.concat(paramString);; paramString = new String(str))
    {
      this.zzvv = paramString;
      AppMethodBeat.o(61426);
      return this;
    }
  }
  
  public final DerivedClassType setTraceByToken(String paramString)
  {
    AppMethodBeat.i(61427);
    String str = String.valueOf("token:");
    paramString = String.valueOf(paramString);
    if (paramString.length() != 0) {}
    for (paramString = str.concat(paramString);; paramString = new String(str))
    {
      this.zzvv = paramString;
      AppMethodBeat.o(61427);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.common.server.BaseApi.BaseApiaryOptions
 * JD-Core Version:    0.7.0.1
 */