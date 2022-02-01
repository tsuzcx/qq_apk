package com.tencent.mm.plugin.handoff.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import d.n.n;
import java.util.UUID;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/handoff/model/HandOff;", "Landroid/os/Parcelable;", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "handOffType", "", "from", "", "to", "key", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "createTime", "", "getCreateTime", "()J", "setCreateTime", "(J)V", "getFrom", "()Ljava/lang/String;", "setFrom", "(Ljava/lang/String;)V", "getHandOffType", "()I", "setHandOffType", "(I)V", "id", "getId", "setId", "getKey", "setKey", "getTo", "setTo", "body", "build", "copy", "getDataType", "update", "", "newHandOff", "writeToParcel", "dest", "flags", "Companion", "api-handoff_release"})
public abstract class HandOff
  implements Parcelable
{
  public static final a tBb = new a((byte)0);
  public long createTime;
  String dsT;
  String hmj;
  public String id;
  public String key;
  public int tBa;
  
  public HandOff(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.tBa = paramInt;
    this.dsT = paramString1;
    this.hmj = paramString2;
    this.key = paramString3;
    this.createTime = System.currentTimeMillis();
    paramString1 = UUID.randomUUID().toString();
    k.g(paramString1, "UUID.randomUUID().toString()");
    this.id = paramString1;
  }
  
  public HandOff(Parcel paramParcel)
  {
    this(i, str1, str2, paramParcel);
  }
  
  public static final String GO(int paramInt)
  {
    return a.fX(1, paramInt);
  }
  
  public final void adU(String paramString)
  {
    k.h(paramString, "<set-?>");
    this.id = paramString;
  }
  
  protected abstract String cSF();
  
  public abstract HandOff cSG();
  
  public final String cSH()
  {
    return n.aWZ("\n    <handoff type=\"" + getDataType() + "\" id=\"" + this.id + "\" createtime=\"" + this.createTime + "\" from=\"" + this.dsT + "\" to=\"" + this.hmj + "\">\n        <handofftype>" + a.di(Integer.valueOf(this.tBa)) + "</handofftype>\n        " + cSF() + "\n    </handoff>\n    ");
  }
  
  public abstract int getDataType();
  
  public void j(HandOff paramHandOff)
  {
    k.h(paramHandOff, "newHandOff");
  }
  
  public final void setKey(String paramString)
  {
    k.h(paramString, "<set-?>");
    this.key = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    k.h(paramParcel, "dest");
    paramParcel.writeInt(this.tBa);
    paramParcel.writeString(this.dsT);
    paramParcel.writeString(this.hmj);
    paramParcel.writeString(this.key);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/handoff/model/HandOff$Companion;", "", "()V", "generateKey", "", "dataType", "", "handOffType", "api-handoff_release"})
  public static final class a
  {
    public static String fX(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(121692);
      String str = paramInt1 + '_' + paramInt2 + '_' + System.currentTimeMillis();
      AppMethodBeat.o(121692);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.model.HandOff
 * JD-Core Version:    0.7.0.1
 */