package com.tencent.mm.plugin.handoff.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import d.n.n;
import java.util.UUID;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/handoff/model/HandOff;", "Landroid/os/Parcelable;", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "handOffType", "", "from", "", "to", "key", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "createTime", "", "getCreateTime", "()J", "setCreateTime", "(J)V", "getFrom", "()Ljava/lang/String;", "setFrom", "(Ljava/lang/String;)V", "getHandOffType", "()I", "setHandOffType", "(I)V", "id", "getId", "setId", "getKey", "setKey", "getTo", "setTo", "body", "build", "copy", "getDataType", "update", "", "newHandOff", "writeToParcel", "dest", "flags", "Companion", "api-handoff_release"})
public abstract class HandOff
  implements Parcelable
{
  public static final a uPp = new a((byte)0);
  public long createTime;
  String dFY;
  String hHo;
  public String id;
  public String key;
  public int uPo;
  
  public HandOff(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.uPo = paramInt;
    this.dFY = paramString1;
    this.hHo = paramString2;
    this.key = paramString3;
    this.createTime = System.currentTimeMillis();
    paramString1 = UUID.randomUUID().toString();
    p.g(paramString1, "UUID.randomUUID().toString()");
    this.id = paramString1;
  }
  
  public HandOff(Parcel paramParcel)
  {
    this(i, str1, str2, paramParcel);
  }
  
  public static final String II(int paramInt)
  {
    return a.go(1, paramInt);
  }
  
  protected abstract String deD();
  
  public abstract HandOff deE();
  
  public final String deF()
  {
    return n.beG("\n    <handoff type=\"" + getDataType() + "\" id=\"" + this.id + "\" createtime=\"" + this.createTime + "\" from=\"" + this.dFY + "\" to=\"" + this.hHo + "\">\n        <handofftype>" + a.dm(Integer.valueOf(this.uPo)) + "</handofftype>\n        " + deD() + "\n    </handoff>\n    ");
  }
  
  public abstract int getDataType();
  
  public void k(HandOff paramHandOff)
  {
    p.h(paramHandOff, "newHandOff");
  }
  
  public final void setId(String paramString)
  {
    p.h(paramString, "<set-?>");
    this.id = paramString;
  }
  
  public final void setKey(String paramString)
  {
    p.h(paramString, "<set-?>");
    this.key = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    p.h(paramParcel, "dest");
    paramParcel.writeInt(this.uPo);
    paramParcel.writeString(this.dFY);
    paramParcel.writeString(this.hHo);
    paramParcel.writeString(this.key);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/handoff/model/HandOff$Companion;", "", "()V", "generateKey", "", "dataType", "", "handOffType", "api-handoff_release"})
  public static final class a
  {
    public static String go(int paramInt1, int paramInt2)
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