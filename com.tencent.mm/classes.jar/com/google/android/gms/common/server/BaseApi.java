package com.google.android.gms.common.server;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DeviceProperties;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseApi
{
  @Deprecated
  public static String append(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(11926);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    if (paramString1.indexOf("?") != -1) {
      localStringBuilder.append('&');
    }
    for (;;)
    {
      localStringBuilder.append(paramString2);
      localStringBuilder.append('=');
      localStringBuilder.append(paramString3);
      paramString1 = localStringBuilder.toString();
      AppMethodBeat.o(11926);
      return paramString1;
      localStringBuilder.append('?');
    }
  }
  
  public static void append(StringBuilder paramStringBuilder, String paramString1, String paramString2)
  {
    AppMethodBeat.i(11927);
    if (paramStringBuilder.indexOf("?") != -1) {
      paramStringBuilder.append('&');
    }
    for (;;)
    {
      paramStringBuilder.append(paramString1);
      paramStringBuilder.append('=');
      paramStringBuilder.append(paramString2);
      AppMethodBeat.o(11927);
      return;
      paramStringBuilder.append('?');
    }
  }
  
  public static String enc(String paramString)
  {
    AppMethodBeat.i(11924);
    Preconditions.checkNotNull(paramString, "Encoding a null parameter!");
    paramString = Uri.encode(paramString);
    AppMethodBeat.o(11924);
    return paramString;
  }
  
  protected static List<String> enc(List<String> paramList)
  {
    AppMethodBeat.i(11925);
    int j = paramList.size();
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(enc((String)paramList.get(i)));
      i += 1;
    }
    AppMethodBeat.o(11925);
    return localArrayList;
  }
  
  public static class BaseApiaryOptions<DerivedClassType extends BaseApiaryOptions<DerivedClassType>>
  {
    private final ArrayList<String> zzvt;
    private final HashMap<String, String> zzvu;
    private String zzvv;
    private final BaseApiaryOptions<DerivedClassType>.Collector zzvw;
    
    public BaseApiaryOptions()
    {
      AppMethodBeat.i(11913);
      this.zzvt = new ArrayList();
      this.zzvu = new HashMap();
      this.zzvw = new Collector();
      AppMethodBeat.o(11913);
    }
    
    private static String zzcy()
    {
      AppMethodBeat.i(11922);
      if (!DeviceProperties.isUserBuild()) {}
      for (boolean bool = true;; bool = false)
      {
        AppMethodBeat.o(11922);
        return String.valueOf(bool);
      }
    }
    
    public final DerivedClassType addField(String paramString)
    {
      AppMethodBeat.i(11915);
      this.zzvt.add(paramString);
      AppMethodBeat.o(11915);
      return this;
    }
    
    @Deprecated
    public final String appendParametersToUrl(String paramString)
    {
      AppMethodBeat.i(11920);
      String str = BaseApi.append(paramString, "prettyPrint", zzcy());
      paramString = str;
      if (this.zzvv != null) {
        paramString = BaseApi.append(str, "trace", getTrace());
      }
      str = paramString;
      if (!this.zzvt.isEmpty()) {
        str = BaseApi.append(paramString, "fields", TextUtils.join(",", getFields().toArray()));
      }
      AppMethodBeat.o(11920);
      return str;
    }
    
    public void appendParametersToUrl(StringBuilder paramStringBuilder)
    {
      AppMethodBeat.i(11921);
      BaseApi.append(paramStringBuilder, "prettyPrint", zzcy());
      if (this.zzvv != null) {
        BaseApi.append(paramStringBuilder, "trace", getTrace());
      }
      if (!this.zzvt.isEmpty()) {
        BaseApi.append(paramStringBuilder, "fields", TextUtils.join(",", getFields().toArray()));
      }
      AppMethodBeat.o(11921);
    }
    
    public final DerivedClassType buildFrom(BaseApiaryOptions<?> paramBaseApiaryOptions)
    {
      AppMethodBeat.i(11914);
      if (paramBaseApiaryOptions.zzvv != null) {
        this.zzvv = paramBaseApiaryOptions.zzvv;
      }
      if (!paramBaseApiaryOptions.zzvt.isEmpty())
      {
        this.zzvt.clear();
        this.zzvt.addAll(paramBaseApiaryOptions.zzvt);
      }
      AppMethodBeat.o(11914);
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
      AppMethodBeat.i(11917);
      paramString = setHeader("ETag", paramString);
      AppMethodBeat.o(11917);
      return paramString;
    }
    
    public final DerivedClassType setHeader(String paramString1, String paramString2)
    {
      AppMethodBeat.i(11916);
      this.zzvu.put(paramString1, paramString2);
      AppMethodBeat.o(11916);
      return this;
    }
    
    public final DerivedClassType setTraceByLdap(String paramString)
    {
      AppMethodBeat.i(11918);
      String str = String.valueOf("email:");
      paramString = String.valueOf(paramString);
      if (paramString.length() != 0) {}
      for (paramString = str.concat(paramString);; paramString = new String(str))
      {
        this.zzvv = paramString;
        AppMethodBeat.o(11918);
        return this;
      }
    }
    
    public final DerivedClassType setTraceByToken(String paramString)
    {
      AppMethodBeat.i(11919);
      String str = String.valueOf("token:");
      paramString = String.valueOf(paramString);
      if (paramString.length() != 0) {}
      for (paramString = str.concat(paramString);; paramString = new String(str))
      {
        this.zzvv = paramString;
        AppMethodBeat.o(11919);
        return this;
      }
    }
    
    public final class Collector
    {
      private boolean zzvx;
      private boolean zzvy;
      private int zzvz;
      private StringBuilder zzwa;
      
      public Collector()
      {
        AppMethodBeat.i(11907);
        this.zzwa = new StringBuilder();
        AppMethodBeat.o(11907);
      }
      
      private final void append(String paramString)
      {
        AppMethodBeat.i(11908);
        if (this.zzvx)
        {
          this.zzvx = false;
          this.zzwa.append(",");
        }
        for (;;)
        {
          this.zzwa.append(paramString);
          AppMethodBeat.o(11908);
          return;
          if (this.zzvy)
          {
            this.zzvy = false;
            this.zzwa.append("/");
          }
        }
      }
      
      public final void addPiece(String paramString)
      {
        AppMethodBeat.i(11909);
        append(paramString);
        this.zzvy = true;
        AppMethodBeat.o(11909);
      }
      
      public final void beginSubCollection(String paramString)
      {
        AppMethodBeat.i(11911);
        append(paramString);
        this.zzwa.append("(");
        this.zzvz += 1;
        AppMethodBeat.o(11911);
      }
      
      public final void endSubCollection()
      {
        AppMethodBeat.i(11912);
        this.zzwa.append(")");
        this.zzvz -= 1;
        if (this.zzvz == 0)
        {
          BaseApi.BaseApiaryOptions.this.addField(this.zzwa.toString());
          this.zzwa.setLength(0);
          this.zzvx = false;
          this.zzvy = false;
          AppMethodBeat.o(11912);
          return;
        }
        this.zzvx = true;
        AppMethodBeat.o(11912);
      }
      
      public final void finishPiece(String paramString)
      {
        AppMethodBeat.i(11910);
        append(paramString);
        if (this.zzvz == 0)
        {
          BaseApi.BaseApiaryOptions.this.addField(this.zzwa.toString());
          this.zzwa.setLength(0);
          AppMethodBeat.o(11910);
          return;
        }
        this.zzvx = true;
        AppMethodBeat.o(11910);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.common.server.BaseApi
 * JD-Core Version:    0.7.0.1
 */