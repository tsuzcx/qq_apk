package com.tencent.mm.plugin.handoff.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import d.n.n;
import java.util.UUID;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/handoff/model/HandOff;", "Landroid/os/Parcelable;", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "handOffType", "", "from", "", "to", "key", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "createTime", "", "getCreateTime", "()J", "setCreateTime", "(J)V", "getFrom", "()Ljava/lang/String;", "setFrom", "(Ljava/lang/String;)V", "getHandOffType", "()I", "setHandOffType", "(I)V", "id", "getId", "setId", "getKey", "setKey", "getTo", "setTo", "body", "build", "copy", "getDataType", "update", "", "newHandOff", "writeToParcel", "dest", "flags", "Companion", "api-handoff_release"})
public abstract class HandOff
  implements Parcelable
{
  public static final a stl = new a((byte)0);
  public long createTime;
  String dvh;
  String gLJ;
  public String id;
  public String key;
  public int stk;
  
  public HandOff(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.stk = paramInt;
    this.dvh = paramString1;
    this.gLJ = paramString2;
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
  
  public static final String ES(int paramInt)
  {
    return a.fQ(1, paramInt);
  }
  
  public final void Zm(String paramString)
  {
    k.h(paramString, "<set-?>");
    this.id = paramString;
  }
  
  protected abstract String cFv();
  
  public abstract HandOff cFw();
  
  public final String cFx()
  {
    return n.aRa("\n    <handoff type=\"" + getDataType() + "\" id=\"" + this.id + "\" createtime=\"" + this.createTime + "\" from=\"" + this.dvh + "\" to=\"" + this.gLJ + "\">\n        <handofftype>" + a.dg(Integer.valueOf(this.stk)) + "</handofftype>\n        " + cFv() + "\n    </handoff>\n    ");
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
    paramParcel.writeInt(this.stk);
    paramParcel.writeString(this.dvh);
    paramParcel.writeString(this.gLJ);
    paramParcel.writeString(this.key);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/handoff/model/HandOff$Companion;", "", "()V", "generateKey", "", "dataType", "", "handOffType", "api-handoff_release"})
  public static final class a
  {
    public static String fQ(int paramInt1, int paramInt2)
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