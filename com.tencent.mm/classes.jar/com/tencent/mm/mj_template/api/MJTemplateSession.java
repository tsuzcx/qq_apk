package com.tencent.mm.mj_template.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.fxr;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/api/MJTemplateSession;", "Landroid/os/Parcelable;", "templatePb", "", "musicId", "", "([BLjava/lang/String;)V", "getMusicId", "()Ljava/lang/String;", "templateInfo", "Lcom/tencent/mm/protocal/protobuf/VideoTemplate;", "getTemplateInfo", "()Lcom/tencent/mm/protocal/protobuf/VideoTemplate;", "templateInfo$delegate", "Lkotlin/Lazy;", "getTemplatePb", "()[B", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-mj-template.api_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MJTemplateSession
  implements Parcelable
{
  public static final Parcelable.Creator<MJTemplateSession> CREATOR;
  public final String musicId;
  final byte[] nZo;
  private final j nZp;
  
  static
  {
    AppMethodBeat.i(240143);
    CREATOR = (Parcelable.Creator)new a();
    AppMethodBeat.o(240143);
  }
  
  public MJTemplateSession(byte[] paramArrayOfByte, String paramString)
  {
    AppMethodBeat.i(240126);
    this.nZo = paramArrayOfByte;
    this.musicId = paramString;
    this.nZp = k.cm((a)new b(this));
    AppMethodBeat.o(240126);
  }
  
  public final fxr bxj()
  {
    AppMethodBeat.i(240149);
    fxr localfxr = (fxr)this.nZp.getValue();
    AppMethodBeat.o(240149);
    return localfxr;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(240165);
    if (this == paramObject)
    {
      AppMethodBeat.o(240165);
      return true;
    }
    if (!(paramObject instanceof MJTemplateSession))
    {
      AppMethodBeat.o(240165);
      return false;
    }
    paramObject = (MJTemplateSession)paramObject;
    if (!s.p(this.nZo, paramObject.nZo))
    {
      AppMethodBeat.o(240165);
      return false;
    }
    if (!s.p(this.musicId, paramObject.musicId))
    {
      AppMethodBeat.o(240165);
      return false;
    }
    AppMethodBeat.o(240165);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(240160);
    int i = Arrays.hashCode(this.nZo);
    int j = this.musicId.hashCode();
    AppMethodBeat.o(240160);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(240155);
    String str = "MJTemplateSession(templatePb=" + Arrays.toString(this.nZo) + ", musicId=" + this.musicId + ')';
    AppMethodBeat.o(240155);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(240177);
    s.u(paramParcel, "out");
    paramParcel.writeByteArray(this.nZo);
    paramParcel.writeString(this.musicId);
    AppMethodBeat.o(240177);
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<MJTemplateSession>
  {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/protocal/protobuf/VideoTemplate;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<fxr>
  {
    b(MJTemplateSession paramMJTemplateSession)
    {
      super();
    }
    
    private fxr bxk()
    {
      AppMethodBeat.i(240104);
      fxr localfxr = new fxr();
      MJTemplateSession localMJTemplateSession = this.nZq;
      try
      {
        localfxr.parseFrom(localMJTemplateSession.nZo);
        AppMethodBeat.o(240104);
        return localfxr;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("MJTemplate", "parse template info error", new Object[] { localException });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.mj_template.api.MJTemplateSession
 * JD-Core Version:    0.7.0.1
 */